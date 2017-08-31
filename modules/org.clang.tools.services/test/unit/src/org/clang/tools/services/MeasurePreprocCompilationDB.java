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
/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2015 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2015 Sun Microsystems, Inc.
 */
package org.clang.tools.services;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.clang.tools.services.impl.AbstractClankCompilationDataBase;
import org.clang.tools.services.impl.CompilationDBFromDumpedEntries;
import org.clang.tools.services.impl.CompilationDBFromSourceFiles;
import org.clang.tools.services.impl.PreprocessorSupport;
import org.clang.tools.services.support.FileInfoCallback;
import org.clang.tools.services.support.ClangUtilities;
import org.clang.tools.services.support.FileInfo;
import org.clang.tools.services.support.Interrupter;
import org.clank.java.std;
import org.clank.support.Casts;
import org.clank.support.NativeTrace;
import org.clank.support.aliases.*;
import org.llvm.adt.StringRef;
import org.llvm.adt.aliases.StringMap;
import org.llvm.adt.aliases.StringMapEntry;
import org.llvm.support.MemoryBuffer;
import org.llvm.support.llvm;
import org.llvm.support.raw_fd_ostream;
import org.llvm.support.raw_ostream;
import org.llvm.support.sys.fs;
import org.llvm.support.sys.path;

/**
 *
 * @author Vladimir Voskresensky
 */
public class MeasurePreprocCompilationDB extends Measurer {

    private static final String CLANK_DB_PATH = "clank.db";
    private static final String CLANK_COLLECT_MACRO_EXPANSION_PROP = "clank.collect.macro.expansion";
    private final static boolean COLLECT_MACRO_EXPANSION = Boolean.parseBoolean(System.getProperty(CLANK_COLLECT_MACRO_EXPANSION_PROP, "false"));
    private static final String CLANK_COLLECT_TOKENS_PROP = "clank.collect.tokens";
    private final static boolean COLLECT_TOKENS = Boolean.parseBoolean(System.getProperty(CLANK_COLLECT_TOKENS_PROP, "true"));
    private static final String CLANK_KEEP_COMMENTS_PROP = "clank.keep.comments";
    private final static boolean KEEP_COMMENTS = Boolean.parseBoolean(System.getProperty(CLANK_KEEP_COMMENTS_PROP, "false"));
    private static final String CLANK_COLLECT_MAINFILE_ONLY_PROP = "clank.collect.mainfile.only";
    private final static boolean ONLY_IN_MAIN_FILE = Boolean.parseBoolean(System.getProperty(CLANK_COLLECT_MAINFILE_ONLY_PROP, "false"));
    private static final String CLANK_COLLECT_FULLFILE_ONCE_PROP = "clank.collect.fullfile.once";
    private final static boolean ONLY_ONCE_IF_SEEN_FULL_FILE = Boolean.parseBoolean(System.getProperty(CLANK_COLLECT_FULLFILE_ONCE_PROP, "false"));

    private static final String CLANK_PRINT_COLLECTED_INFO_PROP = "clank.print.collected.info";
    private static final boolean PRINT_COLLECTED_INFO = Boolean.getBoolean(CLANK_PRINT_COLLECTED_INFO_PROP);
    
    private final boolean dumpDB = Boolean.getBoolean("clank.dump.db");
    private final boolean preprocessDB = Boolean.parseBoolean(System.getProperty("clank.pp", "true"));
    
    private static final String CLANK_PRINT_PREPROCESSED_TOKENS_PROP = "clank.print.tokens";
    private final boolean printTokens = Boolean.getBoolean(CLANK_PRINT_PREPROCESSED_TOKENS_PROP) || (System.getProperty(CLANK_TEST_E_PROP) != null);    
    private static final String CLANK_PRINT_DIAGNOSTICS_PROP = "clank.print.diagnostics";
    private final boolean printDiagnostics = Boolean.getBoolean(CLANK_PRINT_DIAGNOSTICS_PROP);
    private static final String CLANK_PRINT_PROGRESS_PROP = "clank.print.progress";
    private final boolean printProgress = Boolean.getBoolean(CLANK_PRINT_PROGRESS_PROP);
    private static final String CLANK_INTERRUPT_COUNTER_PROP = "clank.interrupt.counter";
    private final int maxFiles = Integer.getInteger(CLANK_INTERRUPT_COUNTER_PROP, Integer.MAX_VALUE);
    
    private String compilationDBPath;
    private ClankCompilationDataBase DB;
    
    public static void main(String[] args) {
        new MeasurePreprocCompilationDB().execute(args);
    }
    
    @Override
    protected String[] prepareParams(String[] args) {
        final raw_ostream out = llvm.outs();
        final raw_ostream err = llvm.errs();
        err.$out("\n");
        err.$out("Sorted Compilation (" + AbstractClankCompilationDataBase.SORT_PARSED_FILES_PROPERTY + "):").$out(Boolean.toString(AbstractClankCompilationDataBase.SORT_PARSED_FILES)).$out("\n").flush();        
        if (compileFiles.length > 0 && (System.getProperty(CLANK_DB_PATH) == null)) {
          compilationDBPath = compileFiles[0] + ".db.out";
          DB = CompilationDBFromSourceFiles.createForFiles(compileFiles);
          out.$out("Preprocessing ").$out(Arrays.toString(compileFiles)).$out("\n").flush();
        } else {
          String path;
          path = ClangUtilities.substituteEnvironmentVariables(System.getProperty(CLANK_DB_PATH, "${LLVM_SRC}/nbproject/private/db.out"));
          if (!new File(ClangUtilities.substituteEnvironmentVariables(path)).exists()) {
              llvm.outs().$out("Can not find ").$out(path).$out("\n").flush();
              path = "${LLVM_SRC}/../LLVM35/nbproject/private/db.out";
          }
          compilationDBPath = ClangUtilities.substituteEnvironmentVariables(path);
          out.$out("Using ").$out(compilationDBPath).$out("\n").flush();
          DB = CompilationDBFromDumpedEntries.createFromDumpEntries(compilationDBPath);
        }
        err.$out("\n");
        err.$out("Collect Once If Seen Full File (" + CLANK_COLLECT_FULLFILE_ONCE_PROP + "):").$out(Boolean.toString(ONLY_ONCE_IF_SEEN_FULL_FILE)).$out("\n").flush();
        err.$out("Collect In Main File Only (" + CLANK_COLLECT_MAINFILE_ONLY_PROP + "):").$out(Boolean.toString(ONLY_IN_MAIN_FILE)).$out("\n").flush();
        err.$out("Print Collected File Callback Info (" + CLANK_PRINT_COLLECTED_INFO_PROP + "):").$out(Boolean.toString(PRINT_COLLECTED_INFO)).$out("\n").flush();
        err.$out("Collect Macro Expansion (" + CLANK_COLLECT_MACRO_EXPANSION_PROP + "):").$out(Boolean.toString(COLLECT_MACRO_EXPANSION)).$out("\n").flush();
        err.$out("Collect Tokens (" + CLANK_COLLECT_TOKENS_PROP + "):").$out(Boolean.toString(COLLECT_TOKENS)).$out("\n").flush();
        err.$out("Keep Comments (" + CLANK_KEEP_COMMENTS_PROP + "):").$out(Boolean.toString(KEEP_COMMENTS)).$out("\n").flush();
        err.$out("Pretty Print Preprocessed Text (" + CLANK_PRINT_PREPROCESSED_TOKENS_PROP + " | " + CLANK_TEST_E_PROP + "):").$out(Boolean.toString(printTokens)).$out("\n").flush();
        err.$out("Pretty Print Diagnostics (" + CLANK_PRINT_DIAGNOSTICS_PROP + "):").$out(Boolean.toString(printDiagnostics)).$out("\n").flush();
        err.$out("Print Progress (" + CLANK_PRINT_PROGRESS_PROP + "):").$out(Boolean.toString(printProgress)).$out("\n").flush();
        err.$out("Max Files (" + CLANK_INTERRUPT_COUNTER_PROP + "):").$out(Integer.toString(maxFiles)).$out("\n").flush();
        err.$out("Trace File Info Exits (" + NativeTrace.TRACE_FILE_INFO_EXIT_PROP + "):").$out(Integer.toString(NativeTrace.TRACE_FILE_INFO_EXIT)).$out("\n").flush();
       
        return args;
    }

    @Override
    protected void doTestWork(String[] args) throws Throwable {
        if (DB == null) {
            System.err.println("DB was not created for " + Arrays.toString(args));
            return;
        }        
        List<ClankCompilationDataBase> DBs = Collections.singletonList(DB);
        if (dumpDB) {
            ClankRunPreprocessorSettings settings = new ClankRunPreprocessorSettings();
            std.error_code Error/*J*/= new std.error_code();
            std.string outFileName = new std.string(compilationDBPath+".dump");
            llvm.outs().$out("Dump DB from ").$out(compilationDBPath).$out(" into ").$out(outFileName).$out("...\n").flush();
            raw_fd_ostream /*P*/ Out = new raw_fd_ostream(new StringRef(outFileName), Error, fs.OpenFlags.F_None);
            if (Error.$bool()) {
                System.err.println("DB can not be printed into " + outFileName.toJavaString() + " because of " + outFileName.toJavaString());
                return;
            }
            settings.out = Out;
            PreprocessorSupport.traceCompilations(DBs, settings);
            llvm.outs().$out("Done Dump DB from ").$out(compilationDBPath).$out(" into ").$out(outFileName).$out("\n").flush();
        }
        if (preprocessDB) {
            final raw_ostream out = llvm.outs();
            final raw_ostream err = llvm.errs();
            String msg = (compileFiles.length == 0) ? compilationDBPath : Arrays.toString(compileFiles);
            err.$out("Preprocess DB from ").$out(msg).$out("...\n").flush();
            ClankRunPreprocessorSettings settings = new ClankRunPreprocessorSettings();
            settings.out = out;
            settings.err = err;
            // do not set, it will be printed by Measures after the last iteration
            if (false) settings.TraceClankStatistics = printStatistics; 
            settings.TraceStatisticsOS = err;
            settings.PrettyPrintDiagnostics = printDiagnostics;
            settings.PrintDiagnosticsOS = out;
            settings.PrettyPrintTokens = printTokens;
            settings.TokenCache = PreprocessorSupport.TOKEN_CACHE_PTH_FILE_PATH;
            settings.IncludeInfoCallbacks = new MeasureTrackIncludeInfoCallback(err);
            final AtomicBoolean cancelled = new AtomicBoolean(false);
            ClankProgressHandler delegateProgress;
            if (printProgress) {
                delegateProgress = ClangUtilities.createProgress(err);
            } else {
                delegateProgress = ClangUtilities.EmptyProgress();
            }
            settings.progress = new ClangUtilities.ClankProgressHandlerChain(delegateProgress) {
                @Override
                public void progress(String message, int workunit) {
                    if (workunit >= maxFiles) {
                        err.$out("Cancelled ").$out(message).$out(" due to max file counter.\n").flush();
                        cancelled.set(true);
                    } else {
                        super.progress(message, workunit);
                    }
                }

                @Override
                public void switchToDeterminate(int workunits, long estimate) {
                    super.switchToDeterminate(workunits, estimate);
                    if (maxFiles < Integer.MAX_VALUE) {
                        err.$out("Stop at ").$out_int(maxFiles).$out("th file...\n").flush();
                    }
                }
            };
            settings.cancelled = new Interrupter() {
                @Override
                public boolean isCancelled() {
                    return cancelled.get();
                }
            };
            PreprocessorSupport.preprocess(DBs, settings, Collections.<String, MemoryBuffer>emptyMap());
            err.$out("Done Preprocessing DB from ").$out(msg).$out("\n").flush();
        }
    }    

    private static final class MeasureTrackIncludeInfoCallback extends FileInfoCallback implements Cloneable {
        private boolean needInfo = false;
        private final boolean needMacroExpansion = COLLECT_MACRO_EXPANSION;
        private final boolean needTokens = COLLECT_TOKENS;
        private final boolean needComments = KEEP_COMMENTS;

        protected MeasureTrackIncludeInfoCallback(raw_ostream err) {
          super(err);
        }

        @Override
        protected boolean needPPDirectives() {
          return needInfo;
        }

        @Override
        protected boolean needTokens() {
          return needInfo && needTokens;
        }

        @Override
        protected boolean needSkippedRanges() {
          return needInfo;
        }

        @Override
        protected boolean needMacroExpansion() {
          return needInfo && needMacroExpansion;
        }

        @Override
        protected boolean needComments() {
          return needInfo && needComments;
        }

        private final List<Boolean> needFileInfos = new ArrayList<>();
        @Override
        protected void onEnter(FileInfo enteredFrom, FileInfo enteredTo) {
          if (enteredTo == null) {
            // exited from main file
            needInfo = false;
          } else {
            if (ONLY_IN_MAIN_FILE) {
              needInfo = enteredTo.isMainFile();
            } else if (ONLY_ONCE_IF_SEEN_FULL_FILE) {
              needInfo = !IsWholeFileAlreadyIncluded(enteredTo);
            } else {
              needInfo = isInterestingFile(enteredTo.getName(), true);
            }
            if (enteredTo.isFile() && !enteredTo.isMainFile()) {
              if (false && !needInfo) {
                System.err.println("ENTER: " + (needInfo ? " COLLECT " : " SKIP ") + enteredTo);
              }
            }
          }
          needFileInfos.add(needInfo);
        }

        @Override
        protected void onExit(FileInfo exitedFrom, FileInfo exitedTo) {
          boolean collectedInfo = needInfo;
          if (collectedInfo && ONLY_ONCE_IF_SEEN_FULL_FILE) {
            updateSkipRangeInfo(exitedFrom);
          }
          int lastIndex = needFileInfos.size() - 1;
          needFileInfos.remove(lastIndex--);
          if (exitedTo != null) {
            needInfo = needFileInfos.get(lastIndex);
          } else {
            needInfo = false;
          }
//          System.err.println(" EXIT: " + (needInfo ? " COLLECT " : " ") + exitedTo);
          if (FileInfoCallback.TRACE || (collectedInfo && PRINT_COLLECTED_INFO)) {
            if (collectedInfo) {
              traceOS.$out("COLLECTED:");
            } else {
              traceOS.$out("  SKIPPED:");
            }
            traceOS.$out("ExitFrom [");
            if (exitedFrom.isFile()) {
              traceOS.$out(exitedFrom.getName());
            } else {
              traceOS.$out_int(exitedFrom.getFileID());
            }
            String exitedToName;
            if (exitedTo == null) {
              exitedToName = "<null>";
            } else if (exitedTo.isFile()) {
              exitedToName = Casts.toJavaString(exitedTo.getName());
            } else {
              exitedToName = "" + exitedTo.getFileID();
            }            
            traceOS.$out("] To:").$out(exitedToName);
            int NumTokens = 0;
            if (exitedFrom.getTokens() != null) {
              NumTokens = exitedFrom.getTokens().size();
            }
            traceOS.$out("\n with #Token: ").$out_int(NumTokens).$out("\n");
            int[] offs = exitedFrom.getSkippedRanges();
            if (offs.length > 0) {
              for (int i = 0; i < offs.length; i+=2) {
                int st = offs[i];
                int end = offs[i+1];
                traceOS.$out("[").$out_uint(st).$out("-").$out_uint(end).$out("] ");
              }
              traceOS.$out("\n");
            }
            traceOS.$out("Now in ").$out(exitedToName).$out("\n");
            traceOS.flush();
          }
        }

        @Override
        public FileInfoCallback copy() {
          return new MeasureTrackIncludeInfoCallback(super.traceOS);
        }
    }
    
    private static final StringMap<MyFileData/*, BumpPtrAllocator*/> SkipRangeInfo = new StringMap<MyFileData/*, BumpPtrAllocator*/>(1024 * 64, null);
    private static final class MyFileData {
      private int AmountFileIncluded = -1;
      private int NumWhenWholeFileWasIncluded = -1;

      boolean IsWholeFileAlreadyIncluded() {
        return NumWhenWholeFileWasIncluded >= 0;
      }

      void posInclude(int[] skippedRanges) {
        AmountFileIncluded++;
        assert skippedRanges != null || IsWholeFileAlreadyIncluded() : "skipped ranges can be null only if there were not collected";
        if (!IsWholeFileAlreadyIncluded() && skippedRanges.length == 0) {
          NumWhenWholeFileWasIncluded = AmountFileIncluded;
        }
      }
    }  
    
    private static boolean IsWholeFileAlreadyIncluded(FileInfo fileInfo) {
      assert ONLY_ONCE_IF_SEEN_FULL_FILE;
      StringMapEntry<MyFileData> Entry = getOrCreateEntry(fileInfo);
      if (Entry != null) {
        synchronized (Entry) {
          MyFileData value = Entry.getValue();
          return value == null ? false : value.IsWholeFileAlreadyIncluded();
        }
      }
      return false;
    }
    
    private static void updateSkipRangeInfo(FileInfo fileInfo) {
      assert ONLY_ONCE_IF_SEEN_FULL_FILE;
      StringMapEntry<MyFileData> Entry = getOrCreateEntry(fileInfo);
      if (Entry != null) {
        int[] skippedRanges = fileInfo.getSkippedRanges();
        synchronized (Entry) {
          MyFileData value = Entry.getValue();
          if (value == null) {
            Entry.setValue(value = new MyFileData());
          }
          value.posInclude(skippedRanges);
        }
      }
    }    

    private static StringMapEntry<MyFileData> getOrCreateEntry(FileInfo fileInfo) {
      assert ONLY_ONCE_IF_SEEN_FULL_FILE;
      if (fileInfo != null) {
        // don't need to keep info for built-ins and start of compilation unit
        if (fileInfo.isFile() && !fileInfo.isMainFile()) {      
          char$ptr Path = fileInfo.getName();
          assert path.is_absolute(Path) : "non absolute " + Path;
          int PathLen = std.strlen(Path);
          synchronized (SkipRangeInfo) {
            return SkipRangeInfo.GetOrCreateValue(Path, PathLen);
          }
        }
      }
      return null;
    }
}
