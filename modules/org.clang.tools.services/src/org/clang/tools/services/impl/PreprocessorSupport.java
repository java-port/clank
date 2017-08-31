/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.clang.tools.services.impl;

import org.clang.tools.services.support.FileInfoCallback;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import org.clang.basic.DiagnosticConsumer;
import org.clang.basic.PresumedLoc;
import org.clang.basic.SourceLocation;
import org.clang.basic.SourceManager;
import org.clang.basic.tok;
import org.clang.frontend.FrontendClangGlobals;
import org.clang.frontend.PreprocessorOutputOptions;
import org.clang.lex.PPCallbacks;
import org.clang.lex.java.PTHManagerDriver;
import org.clang.lex.Preprocessor;
import org.clang.lex.Token;
import org.clang.tools.services.*;
import org.clang.tools.services.support.ClangUtilities;
import org.clang.tools.services.support.FileInfo;
import org.clang.tools.services.support.Interrupter;
import org.clang.tools.services.support.PrintWriter_ostream;
import org.clank.support.Converted;
import org.clank.support.NativeTrace;
import org.llvm.support.MemoryBuffer;
import org.llvm.support.llvm;
import org.llvm.support.raw_ostream;
import static org.clank.java.std.strcmp;

/**
 *
 * @author Vladimir Voskresensky
 */
public final class PreprocessorSupport {

    // do we need to keep cache misses for stat (more memory, but in standalone mode it's faster)
    public static final String KEEP_STAT_MISSES_PROP = "clank.keep.stat.miss";
    public static final boolean KEEP_STAT_MISSES;

    static {
      String prop = System.getProperty(KEEP_STAT_MISSES_PROP);
      boolean keepMisses;
      if (prop == null) {
        // if not set up externally keep misses in standalone mode, but not in NB
        keepMisses = NativeTrace.isStandalone();
      } else {
        keepMisses = Boolean.valueOf(prop);
      }
      KEEP_STAT_MISSES = keepMisses;
    }
  
    public static final String CLANK_THREADS_COUNT_PROP = "clank.threads";
    public static final int THREADS_COUNT = Integer.getInteger(CLANK_THREADS_COUNT_PROP, 1);
    
    public static final String CLANK_ALLOW_TO_SKIP_TOKENS_BETWEEN_DIRECTIVES_PROP = "clank.callback.allow.skip.token";
    public static final boolean ALLOW_TO_SKIP_TOKENS_BETWEEN_DIRECTIVES = Boolean.parseBoolean(System.getProperty(CLANK_ALLOW_TO_SKIP_TOKENS_BETWEEN_DIRECTIVES_PROP, "false")); //NativeTrace.DEBUG;
    public static final String  TOKEN_CACHE_PTH_FILE_PATH_PROP = "clank.token.cache"; //NOI18N
    public static final String  TOKEN_CACHE_PTH_FILE_PATH = System.getProperty(TOKEN_CACHE_PTH_FILE_PATH_PROP, "").trim(); //NOI18N
    public static final String  SHARED_PTH_MANAGER_PROP = "clank.shared.pth";//NOI18N
    public static final boolean SHARED_PTH_MANAGER = Boolean.parseBoolean(System.getProperty(SHARED_PTH_MANAGER_PROP, "" + !TOKEN_CACHE_PTH_FILE_PATH.isEmpty()));//NOI18N
    public static final String  USE_PTH_DRIVER_PROP = "clank.pth.driver";//NOI18N
//    public static final boolean USE_PTH_DRIVER = Boolean.parseBoolean(System.getProperty(USE_PTH_DRIVER_PROP, "true"+NativeTrace.USE_PTH_DRIVER_IN_TEST));//NOI18N
    public static final boolean USE_PTH_DRIVER = Boolean.parseBoolean(System.getProperty(USE_PTH_DRIVER_PROP, "true"));//NOI18N
    public static final String  REUSE_MEMORY_BUFFERS_PROP = "clank.reuse.mem.buffer"; //NOI18N
    public static final boolean REUSE_MEMORY_BUFFERS = Boolean.parseBoolean(System.getProperty(REUSE_MEMORY_BUFFERS_PROP, "true")); //NOI18N
    
    private PreprocessorSupport() {
    }

    private static PreprocessorOutputOptions createPPOptions(ClankRunPreprocessorSettings settings) {
        PreprocessorOutputOptions opts = new PreprocessorOutputOptions();
        if (settings.PrettyPrintTokens) {
            opts.ShowCPP = true;
            opts.ShowLineMarkers = false;
            opts.ShowMacros = true;
        }
        opts.ShowComments = true;
        opts.ShowMacroComments = true;
        return opts;
    }

    public static void traceCompilations(Collection<ClankCompilationDataBase> dbs,
            ClankRunSettings settings) {
        raw_ostream out = settings.out;
        raw_ostream err = settings.err;
        ClankProgressHandler handle = settings.progress;
        Interrupter cancelled = settings.cancelled;
        assert out != null;
        assert err != null;
        clearStatistics();
        try {
            for (ClankCompilationDataBase db : dbs) {
                handle.setDisplayName("Compilation DataBase for " + db.getName());
                handle.switchToIndeterminate();
                Collection<ClankCompilationDataBase.Entry> entries = db.getCompilations();
                int size = entries.size();
                handle.switchToDeterminate(size, -1);
                int doneFiles = 0;
                for (ClankCompilationDataBase.Entry entry : entries) {
                    if (cancelled.isCancelled()) {
                        break;
                    }
                    CharSequence absPath = ClangUtilities.getFirstCompiledPath(entry);
                    handle.progress(absPath + (" (" + (doneFiles+1) + " of " + size + ")") , doneFiles++);
                    ClangUtilities.DumpEntry(entry, out);
                }
            }    
        } finally {
            out.flush();
            err.flush();
        }
    }
    
    public static void preprocess(Collection<ClankCompilationDataBase> dbs,
            final ClankRunPreprocessorSettings settings, final Map<String, MemoryBuffer> remappedBuffers) {
        final raw_ostream out = settings.out;
        final raw_ostream err = settings.err;
        final ClankProgressHandler handle = settings.progress;
        final Interrupter cancelled = settings.cancelled;
        assert out != null;
        assert err != null;
        try {
            final PreprocessorOutputOptions Opts = createPPOptions(settings);
            clearStatistics();
            for (ClankCompilationDataBase db : dbs) {
                if (NativeTrace.VERBOSE_MODE) {
                  err.$out("START ").$out(db.getName()).$out(" in ").
                          $out_uint(THREADS_COUNT).$out(THREADS_COUNT == 1 ? " thread" : " threads").$out("\n").flush();
                }
                handle.setDisplayName("Preprocess " + db.getName());
                handle.switchToIndeterminate();
                Collection<ClankCompilationDataBase.Entry> tmp = db.getCompilations();
                final int size = tmp.size();
                final ConcurrentLinkedQueue<ClankCompilationDataBase.Entry> entries = new ConcurrentLinkedQueue<>(tmp);
                tmp = null;
                handle.switchToDeterminate(size, -1);
                final AtomicInteger doneFiles = new AtomicInteger(0);
                final AtomicLong totalTime = new AtomicLong(0);
                final Object printfLock = new Object();
                if (THREADS_COUNT > 1) {
                    Thread[] threads = new Thread[THREADS_COUNT];
                    assert settings.IncludeInfoCallbacks != null;
                    for (int i = 0; i < threads.length; i++) {
                      try {
                        final FileInfoCallback callback;
                        if (i == 0) {
                          callback = settings.IncludeInfoCallbacks;
                        } else {
                            callback = settings.IncludeInfoCallbacks.copy();
                        }
                        threads[i] = new Thread(new Runnable() {
                          @Override
                          public void run() {
                            preprocessEntries(entries, doneFiles, handle, size, cancelled, out, err, callback, settings, Opts, remappedBuffers, totalTime, printfLock);
                          }
                        }, "Preprocessing thread #" + i);
                      } catch (UnsupportedOperationException e) {
                        assert false : "must be cloneable to pass clones in threads " + settings.IncludeInfoCallbacks.getClass().getName();
                      }
                    }
                    for (int i = 0; i < threads.length; i++) {
                        threads[i].start();
                    }
                    for (int i = 0; i < threads.length; i++) {
                      try {
                        threads[i].join();
                      } catch (InterruptedException ex) {
                        NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
                      }
                    }
                } else {
                  preprocessEntries(entries, doneFiles, handle, size, cancelled, out, err, settings.IncludeInfoCallbacks, settings, Opts, remappedBuffers, totalTime, printfLock);
                }
                if (NativeTrace.VERBOSE_MODE || NativeTrace.SERVICE_STATISTICS) {
                  FileInfo.printTokenStats();
                  PreprocessorInitializer.printFileStats();
                  err.$out("DONE  ").$out(db.getName()).$out(" ").$out(NativeTrace.formatNumber(totalTime.get())).$out("ms").$out("\n").flush();
                }
            }
            if (settings.TraceClankStatistics) {
                PrintClankStatistics(err);
            }
        } finally {
            out.flush();
            err.flush();            
        }
    }

    static boolean isInterstingTestFile(ClankCompilationDataBase.Entry entry) {
      CharSequence absFilePath = ClangUtilities.getFirstCompiledPath(entry);
      String file = System.getProperty("check.one.file.only");
      if (file != null && file.contentEquals(absFilePath)) {
        return true;
      }
      return file == null;
    }
    private static void preprocessEntries(ConcurrentLinkedQueue<ClankCompilationDataBase.Entry> entries, AtomicInteger doneFiles, 
            ClankProgressHandler handle, int size, Interrupter cancelled, raw_ostream out, raw_ostream err, 
            FileInfoCallback /*P*/ Callback, 
            ClankRunPreprocessorSettings settings, PreprocessorOutputOptions Opts, 
            Map<String, MemoryBuffer> remappedBuffers, AtomicLong totalTime, Object printfLock) {
      
        while (true) {
            ClankCompilationDataBase.Entry entry = entries.poll();
            if (entry == null) {
              break;
            }
            doneFiles.incrementAndGet();
            if (false && THREADS_COUNT == 1) {
              if (doneFiles.get() == 800 || doneFiles.get() == 950) {
                try {
                  Thread.sleep(2000);
                } catch (InterruptedException ex) {
                  NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
                }
                if (doneFiles.get() == 950) {
                  break;
                }
              }
            }
            CharSequence absolutePath = ClangUtilities.getFirstCompiledPath(entry);
            handle.progress(absolutePath + (" (" + doneFiles.get() + " of " + size + ")"), doneFiles.get());
            if (cancelled.isCancelled()) {
              break;
            }
            if (false && isInterstingTestFile(entry)) {
                System.err.println(entry.toString());
            }
            long time = dumpPreprocessedEntry(entry, out, err, settings.PrintDiagnosticsOS, Opts,
                    Callback,
                    settings.PrettyPrintDiagnostics,
                    settings.PrettyPrintTokens,
                    settings.TracePPStatistics,
                    settings.SuppressIncludeNotFoundError,
                    settings.TokenCache,
                    cancelled, remappedBuffers);
            totalTime.addAndGet(time);
            if (NativeTrace.VERBOSE_MODE) {
              synchronized (printfLock) {
                err.$out("done  ").$out(absolutePath.toString()).
                        $out(" (").$out_uint(doneFiles.get()).$out(" of ").$out_uint(size).$out(") ").
                        $out(NativeTrace.formatNumber(time)).$out("ms").$out("\n").flush();
              }
            }
        }
    }

    public static long dumpPreprocessed(ClankCompilationDataBase.Entry entry,
            raw_ostream llvm_out, raw_ostream llvm_err, raw_ostream llvm_diag,
            PreprocessorOutputOptions Opts,
            FileInfoCallback /*P*/ CollectIncludeInfo,
            boolean printDiags, boolean printTokens, 
            boolean printPPStatistics, boolean suppressIncludeNotFoundError,
            String TokenCache,
            final Interrupter cancelled) {
        long time = System.currentTimeMillis();
        boolean done = false;
        try {
            dumpPreprocessedEntry(entry, llvm_out, llvm_err, llvm_diag, Opts, CollectIncludeInfo, 
                printDiags, printTokens, printPPStatistics, suppressIncludeNotFoundError, TokenCache, cancelled, Collections.<String, MemoryBuffer>emptyMap());
        } finally {
            llvm.errs().flush();
            llvm_out.flush();
            llvm_diag.flush();
        }
        return done ? time : 0;
    }

    private static long dumpPreprocessedEntry(ClankCompilationDataBase.Entry entry,
            raw_ostream llvm_out, raw_ostream llvm_err, raw_ostream llvm_diag,
            PreprocessorOutputOptions Opts,
            FileInfoCallback /*P*/ FileCallback,
            boolean printDiags, boolean printTokens, 
            boolean printPPStatistics, boolean suppressIncludeNotFoundError,
            String TokenCache,
            final Interrupter cancelled,
            final Map<String, MemoryBuffer> remappedBuffers) {
        long time = System.currentTimeMillis();
        boolean done = false;
        AdvancedPreprocessorInitializer initializer = new AdvancedPreprocessorInitializer(
            TokenCache, entry, "x86_64", printDiags ? llvm_diag : llvm.nulls(), remappedBuffers
        );
        String InputFile = ClangUtilities.getFirstCompiledPath(entry).toString();
        Preprocessor PP = initializer.createPreprocessor(InputFile);

        if (PP != null) {
            PP.SetSuppressIncludeNotFoundError(suppressIncludeNotFoundError);
            if (printTokens) {
                FrontendClangGlobals.DoPrintPreprocessedInput(PP, printTokens ? llvm_out : llvm.nulls(), Opts);
                PP.EndSourceFile();
            } else {
                ConsumePreprocessedInput(PP, llvm_out, llvm_err, llvm_diag, FileCallback, cancelled);
            }
            DiagnosticConsumer client = PP.getDiagnostics().getClient();
            if (client != null) {
                client.EndSourceFile();
            }
            time = System.currentTimeMillis() - time;
            done = true;
            if (printPPStatistics) {
                PrintPPStatistics(PP, entry, llvm_out);
            }
            destroyPreprocessor(PP);
        }
        initializer.$destroy();
        return done ? time : 0;
    }

    private static void PrintPPStatistics(Preprocessor PP, ClankCompilationDataBase.Entry entry, raw_ostream OS) {
        assert PP != null;
        assert entry != null;
        assert OS != null;
        OS.$out("\nSTATISTICS FOR '").$out(ClangUtilities.getFirstCompiledPath(entry).toString()).$out("':\n");
        PP.PrintStats(OS);
        PP.getIdentifierTable().PrintStats(OS);
        PP.getHeaderSearchInfo().PrintStats(OS);
        PP.getSourceManager().PrintStats(OS);
        OS.$out("\n");
        OS.flush();
    }
    
    private static void PrintClankStatistics(raw_ostream OS) {
        if (NativeTrace.STATISTICS) {
            PrintWriter javaOS = tryExtractPrintWriter(OS, System.out);
            org.clang.frontendtool.java.FrontendtoolJava.PrintStats(OS, javaOS);
            javaOS.flush();
        } else {
            OS.$out("Statistics was not gathered\n");
        }
        OS.flush();
    }

    private static PrintWriter tryExtractPrintWriter(raw_ostream OS, PrintStream fallback) {
        PrintWriter javaOS = tryExtractPrintWriter(OS);
        if (javaOS == null) {
            javaOS = new PrintWriter(fallback);
        }
        return javaOS;
    }
    
    private static PrintWriter tryExtractPrintWriter(raw_ostream OS) {
        PrintWriter javaOS = null;
        if (OS instanceof PrintWriter_ostream) {
            javaOS = ((PrintWriter_ostream)OS).getJavaDelegate();
        }
        return javaOS;
    }
    
    private static void destroyPreprocessor(Preprocessor PP) {
        PP.$destroy();
    }

    private static void clearStatistics() {
        org.clang.frontendtool.java.FrontendtoolJava.clearStatistics();
        FileInfo.clearTokenStats();
        PTHManagerDriver.clearStatistics();
    }    
    

    //<editor-fold defaultstate="collapsed" desc="clang::DoPrintPreprocessedInput">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 735,
     cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -filter=clang::DoPrintPreprocessedInput")
    //</editor-fold>
    private static void ConsumePreprocessedInput(Preprocessor /*&*/ PP, 
            raw_ostream /*P*/ out, raw_ostream err, raw_ostream llvm_diag,
            FileInfoCallback /*P*/ CollectIncludeInfo,
            final Interrupter cancelled) {
      if (CollectIncludeInfo == null) {
        CollectIncludeInfo = new FileInfoCallback(err);
      }
      CollectIncludeInfo.prepareEnterMainSourceFile(PP);
      PP.addPPCallbacks(llvm.<PPCallbacks>make_unique(CollectIncludeInfo));

      // After we have configured the preprocessor, enter the main file.
      PP.EnterMainSourceFile();

      // Consume all of the tokens that come from the predefines buffer.  Those
      // should not be emitted into the output and are guaranteed to be at the
      // start.
      /*const*/ SourceManager /*&*/ SourceMgr = PP.getSourceManager();
      Token Tok/*J*/= new Token();
      int numTokens = 0;
      do {
        PP.Lex(Tok);
        CollectIncludeInfo.onToken(Tok);
        numTokens++;
        if (Tok.is(tok.TokenKind.eof) || !SourceLocation.isFileID(Tok.$getLocation())) {
          break;
        }

        PresumedLoc PLoc = SourceMgr.getPresumedLoc(Tok.$getLocation());
        if (PLoc.isInvalid()) {
          break;
        }
        if ((strcmp(PLoc.getFilename(), "<built-in>") != 0)) {
          break;
        }
      } while (true);

      // Read all the preprocessed tokens
      while (Tok.isNot(tok.TokenKind.eof)) {
          if (cancelled.isCancelled()) {
            break;
          }
          numTokens++;
          PP.Lex(Tok);
          if (cancelled.isCancelled()) {
            break;
          }
          CollectIncludeInfo.onToken(Tok);
      }
      if (!cancelled.isCancelled()) {
        PP.EndSourceFile();
      }
      if (NativeTrace.VERBOSE_MODE) {
        err.$out("Lexed ").$out(NativeTrace.formatNumber(numTokens)).$out(" tokens \n");
      }
    } 
}
