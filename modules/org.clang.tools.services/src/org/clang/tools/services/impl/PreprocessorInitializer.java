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
package org.clang.tools.services.impl;

import java.util.concurrent.atomic.AtomicInteger;
import org.clang.basic.DiagnosticIDs;
import org.clang.basic.DiagnosticOptions;
import org.clang.basic.DiagnosticsEngine;
import org.clang.basic.FileEntry;
import org.clang.basic.FileManager;
import org.clang.basic.LangOptions;
import org.clang.basic.Module;
import org.clang.basic.SourceLocation;
import org.clang.basic.SourceManager;
import org.clang.basic.diag;
import static org.clang.basic.BasicClangGlobals.$out_DiagnosticBuilder$C_StringRef;
import org.clang.basic.FileData;
import org.clang.basic.SrcMgr;
import org.clang.basic.target.TargetInfo;
import org.clang.basic.target.TargetOptions;
import org.clang.basic.vfs.FileSystem;
import org.clang.frontend.FrontendClangGlobals;
import org.clang.frontend.FrontendOptions;
import org.clang.lex.HeaderSearch;
import org.clang.lex.HeaderSearchOptions;
import org.clang.lex.llvm.ModuleIdPath;
import org.clang.lex.ModuleLoadResult;
import org.clang.lex.ModuleLoader;
import org.clang.lex.PTHManager;
import org.clang.lex.Preprocessor;
import org.clang.lex.PreprocessorOptions;
import org.clang.tools.services.support.ClangUtilities;
import org.clank.java.std;
import org.clank.java.std_ptr;
import org.clank.support.Converted;
import org.clank.support.Destructors;
import static org.clank.support.Native.$eq_iter;
import org.clank.support.NativeTrace;
import org.llvm.adt.IntrusiveRefCntPtr;
import org.llvm.adt.StringRef;
import org.llvm.adt.aliases.StringMap;
import org.llvm.adt.aliases.StringMapIterator;
import org.llvm.support.MemoryBuffer;
import org.llvm.support.llvm;
import org.llvm.support.raw_ostream;
import org.llvm.support.sys.fs;
import org.llvm.support.sys.path;
import org.clang.lex.spi.GlobalModuleIndexImplementation;

/**
 *
 * @author Vladimir Voskresensky
 */
public class PreprocessorInitializer {
    /*package*/static final fs.UniqueID INVALID_ID = fs.INVALID_UNIQUE_ID;
    /*package*/static final FileData CACHE_MISSING = new FileData();
    
    protected static final IntrusiveRefCntPtr<DiagnosticIDs> DiagID;
    private static final IntrusiveRefCntPtr<DiagnosticOptions> dOpts;
    private static final StringMap<FileData/*, BumpPtrAllocator*/> FileStatCache;
    private static final StringMap<FileData/*, BumpPtrAllocator*/> DirectoryStatCache;
    private static final StringMap<MemoryBuffer/*, BumpPtrAllocator*/> MemoryBufferCache;
    private static final AtomicInteger MemoryBufferCacheHits;
    private static final AtomicInteger MemoryBufferCacheMisses;
    private static final AtomicInteger MemoryBufferMainFileHits;
    static {
        DiagID = new IntrusiveRefCntPtr<>(new DiagnosticIDs());
        dOpts = new IntrusiveRefCntPtr<>(new DiagnosticOptions());
        FileStatCache = new StringMap<FileData/*, BumpPtrAllocator*/>(1024*64, null);
        DirectoryStatCache = new StringMap<FileData/*, BumpPtrAllocator*/>(1024*8, null);
        MemoryBufferCache = new StringMap<MemoryBuffer/*, BumpPtrAllocator*/>(1024*16, null);
        MemoryBufferCacheHits = new AtomicInteger(0);
        MemoryBufferCacheMisses = new AtomicInteger(0);
        MemoryBufferMainFileHits = new AtomicInteger(0);
    }

    
    protected LangOptions LangOpts = null;
    protected SourceManager SourceMgr = null;
    protected HeaderSearch HS = null;
    protected ModuleLoader ModLoader = null;
    protected final FileManager FileMgr;
    protected final PTHManager PTHMgr;
    protected final DefaultDiagnosticConsumer DiagnosticConsumer;
    protected final DiagnosticsEngine Diags;
    protected final TargetOptions TargetOpts;
    protected final IntrusiveRefCntPtr<TargetInfo> Target;
    protected final raw_ostream err;

    private static final boolean DELEGATE_FS = Boolean.parseBoolean(System.getProperty("clank.delegate.fs", "true")); //NOI18N
    private static final boolean MACRO_EXPANSION_ONLY_IN_DIRECTIVES = Boolean.parseBoolean(System.getProperty("clank.unexpanded", "false")); //NOI18N

    private final SharedMemoryBufferCache sharedMemoryBufferCache;
    private final std.string TokenCache;
    public PreprocessorInitializer(String TokenCache, raw_ostream llvm_err, String triple, IntrusiveRefCntPtr<FileSystem> FS) {
        this.err = (llvm_err == null) ? llvm.errs() : llvm_err;
        sharedMemoryBufferCache = new SharedMemoryBufferCache(MemoryBufferCache, MemoryBufferCacheHits, MemoryBufferMainFileHits, MemoryBufferCacheMisses);
        assert FS != null : "must be at least RealFileSystem";
        assert FS.get() != null : "must be at least RealFileSystem";
        FS = DELEGATE_FS ? DelegatingFileSystem.create(sharedMemoryBufferCache, FS) : FS;
        this.FileMgr = PreprocessorInitializerHelper.$getFileManager(sharedMemoryBufferCache, FileStatCache, DirectoryStatCache, FS);
        this.DiagnosticConsumer = new DefaultDiagnosticConsumer(llvm_err, dOpts.get());
        this.Diags = new DiagnosticsEngine(DiagID, dOpts.get(), DiagnosticConsumer);
        assert TokenCache != null : "Must be at least empty string, but not null";
        this.TokenCache = new std.string(TokenCache);
        this.PTHMgr = PreprocessorInitializerHelper.$getPTHManager(this.TokenCache, Diags);
        this.TargetOpts = new TargetOptions();
        this.TargetOpts.Triple.$assign(triple);
        this.Target = new IntrusiveRefCntPtr<>(TargetInfo.CreateTargetInfo(Diags, /*AddrOf*/ new std_ptr.shared_ptr<TargetOptions>(TargetOpts)));
    }

    public static void clearFileCache(CharSequence localPathOrRemoteUrl) {
        assert FileStatCache != null;
        assert DirectoryStatCache != null;
        boolean traceFlag = false;
        if (NativeTrace.isCheckingFile(localPathOrRemoteUrl)) {
          traceFlag = true;
        }        
        StringRef Path = ClangUtilities.createPathStringRef(localPathOrRemoteUrl);
        assert path.is_absolute(Path) : "Path should be absolute: " + Path; //NOI18N
        synchronized (FileStatCache) {
          FileData lookup = FileStatCache.lookup(Path);
          if (lookup != null && lookup != CACHE_MISSING) {
            if (traceFlag) {
              NativeTrace.assertTrueInConsole(false, localPathOrRemoteUrl + ":File data = " + lookup);
            }
            lookup.UniqueID = INVALID_ID;
          }
        }
        synchronized (DirectoryStatCache) {
          FileData lookup = DirectoryStatCache.lookup(Path);
          if (lookup != null && lookup != CACHE_MISSING) {
            if (traceFlag) {
              NativeTrace.assertTrueInConsole(false, localPathOrRemoteUrl + ":Dir data = " + lookup);
            }
            lookup.UniqueID = INVALID_ID;
          }
        }
        synchronized (MemoryBufferCache) {
          StringMapIterator<MemoryBuffer> I = MemoryBufferCache.find(Path);
          if (!$eq_iter(I, MemoryBufferCache.end())) {
            if (traceFlag) {
              NativeTrace.assertTrueInConsole(false, localPathOrRemoteUrl + ":Buffer = " + I.$arrow().second.getBufferSize());
            }          
            MemoryBufferCache.erase(I);
          }
        }
    }
    
    public static void clearAllFileCache() {
        synchronized (FileStatCache) {
            FileStatCache.clear();
        }
        synchronized (DirectoryStatCache) {
            DirectoryStatCache.clear();
        }
        synchronized (MemoryBufferCache) {
          MemoryBufferCache.clear();
          MemoryBufferCacheHits.set(0);
          MemoryBufferMainFileHits.set(0);
          MemoryBufferCacheMisses.set(0);
        }
    }

    private boolean InitSourceManager(String filePath, SourceManager SourceMgr,
        FileManager FileMgr, DiagnosticsEngine Diag) {
      StringRef InputFile = ClangUtilities.createPathStringRef(filePath);
      sharedMemoryBufferCache.skipMainFile(InputFile);
      final FileEntry File = FileMgr.getFile(InputFile, true);
      if (File == null) {
        $out_DiagnosticBuilder$C_StringRef(Diag.Report(diag.err_fe_error_reading), InputFile).$destroy();
        return false;
      } else {
        /*FileID*/
        int MainFID = SourceMgr.createFileID(
            File,
            SourceLocation.getInvalid(),
            SrcMgr.CharacteristicKind.C_User
        );
        SourceMgr.setMainFileID(MainFID);
        return true;
      }
    }

    void destroyPreprocessor(Preprocessor PP) {
      PP.$destroy();
    }

    //<editor-fold defaultstate="collapsed" desc="adopted CompilerInstance::createPreprocessor">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 298)
    //</editor-fold>    
    public final Preprocessor createPreprocessor(final String InputFile) {
        assert true : "this method got it's implementation from CompilerInstance.createPreprocessor; don't forget to update";
        
        ModuleLoader MLoader = createModuleLoader();
        PreprocessorOptions PPOpts = createPreprocessorOptions();
        LangOptions LOpts = createLangOptions(PPOpts);
        HeaderSearchOptions HSOpts = createHeaderSearchOptions();
        assert (SourceMgr == null);
        assert (HS == null);
        SourceMgr = new SourceManager(Diags, FileMgr);
        HS = new HeaderSearch(new IntrusiveRefCntPtr<>(HSOpts), SourceMgr, Diags, LOpts, Target.get());
//            ClangGlobals.ApplyHeaderSearchOptions(HS, HSOpts, LangOpts, Target.getPtr().getTriple());
        Preprocessor PP = new Preprocessor(new IntrusiveRefCntPtr<>(PPOpts), Diags, LOpts, SourceMgr, HS, MLoader, PTHMgr, false);
        PP.Initialize(Target.$star());

        // Note that this is different then passing PTHMgr to Preprocessor's ctor.
        // That argument is used as the IdentifierInfoLookup argument to
        // IdentifierTable's ctor.
        if ((PTHMgr != null)) {
          PTHMgr.setPreprocessor(/*AddrOf*/PP);
          PP.setPTHManager(PTHMgr);
        }
      
        if (PPOpts.DetailedRecord) {
          PP.createPreprocessingRecord();
        }
  
        Diags.getClient().BeginSourceFile(LOpts, PP);        
        FrontendClangGlobals.InitializeFileRemapping(PP.getDiagnostics(), PP.getSourceManager(),
              PP.getFileManager(), PPOpts);        
        FrontendClangGlobals.InitializePreprocessor(PP, PPOpts, /*FIXME 3.8*/null, new FrontendOptions());
        FrontendClangGlobals.ApplyHeaderSearchOptions(PP.getHeaderSearchInfo(), HSOpts, 
          PP.getLangOpts(), PP.getTargetInfo().getTriple());
        // initialize source manager for input file
        if (!InitSourceManager(InputFile, SourceMgr, FileMgr, Diags)) {
          destroyPreprocessor(PP);
          return null;
        }
        if (MACRO_EXPANSION_ONLY_IN_DIRECTIVES) {
          PP.SetMacroExpansionOnlyInDirectives();
        }
        return PP;
    }

    protected ModuleLoader createModuleLoader() {
      assert ModLoader == null;
      ModLoader = new VoidModuleLoader();
      return ModLoader;
    }

    protected LangOptions createLangOptions(PreprocessorOptions /*&*/ PPOpts) {
      assert LangOpts == null;
      LangOpts = new LangOptions();
      return LangOpts;
    }

    protected HeaderSearchOptions createHeaderSearchOptions() {
        HeaderSearchOptions HSOpts = new HeaderSearchOptions();
        HSOpts.UseBuiltinIncludes = false;
        HSOpts.UseLibcxx = false;
        HSOpts.UseStandardCXXIncludes = false;
        HSOpts.UseStandardSystemIncludes = false;

        return HSOpts;
    }

    protected PreprocessorOptions createPreprocessorOptions() {
        PreprocessorOptions out = new PreprocessorOptions();
        out.UsePredefines = false;
        // assign token cache file if has one
        out.TokenCache.$assign(this.TokenCache);
        
        return out;
    }

    public void $destroy() {
      Target.$destroy();
      TargetOpts.$destroy();
      SourceMgr.$destroy();
      HS.$destroy();
      ModLoader.$destroy();
      LangOpts.$destroy();
      //Diags.$destroy(); it will be destroyed by DiagnosticConsumer
      DiagnosticConsumer.$destroy();
      PreprocessorInitializerHelper.$releaseFileManager(FileMgr);
      PreprocessorInitializerHelper.$releasePTHManager(TokenCache, PTHMgr);
    }

    //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::VoidModuleLoader">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp", line = 31,
            cmd = "jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp -filter=<anonymous namespace>::VoidModuleLoader")
    //</editor-fold>
    public static final class VoidModuleLoader extends /*public*/ ModuleLoader implements Destructors.ClassWithDestructor {

        //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::VoidModuleLoader::loadModule">
        @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp", line = 32,
                cmd = "jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp -filter=<anonymous namespace>::VoidModuleLoader::loadModule")
        //</editor-fold>
        @Override
        public/*private*/ /*virtual*/ ModuleLoadResult loadModule(SourceLocation ImportLoc, ModuleIdPath Path, Module.NameVisibilityKind Visibility, boolean IsInclusionDirective) {
            return new ModuleLoadResult();
        }

        //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::VoidModuleLoader::makeModuleVisible">
        @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp", line = 39,
                cmd = "jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp -filter=<anonymous namespace>::VoidModuleLoader::makeModuleVisible")
        //</editor-fold>
        @Override
        public/*private*/ /*virtual*/ void makeModuleVisible(Module /*P*/ Mod, Module.NameVisibilityKind Visibility, SourceLocation ImportLoc) {
        }
        
        @Override
        public GlobalModuleIndexImplementation loadGlobalModuleIndex(SourceLocation TriggerLoc) {
          return null;
        }

        @Override
        public boolean lookupMissingImports(StringRef Name, SourceLocation TriggerLoc) {
          return false;
        }

        //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::VoidModuleLoader::~VoidModuleLoader">
        @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp", line = 31,
                cmd = "jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp -filter=<anonymous namespace>::VoidModuleLoader::~VoidModuleLoader")
        //</editor-fold>
        @Override
        public /*inline*/ void $destroy() {
            super.$destroy();
        }

        //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::VoidModuleLoader::VoidModuleLoader">
        @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp", line = 31,
                cmd = "jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp -filter=<anonymous namespace>::VoidModuleLoader::VoidModuleLoader")
        //</editor-fold>
        public /*inline*/ VoidModuleLoader() {
            /* : ModuleLoader()*/
            //START JInit
            super();
            //END JInit
        }

    }
    

    static void printFileStats() {
        llvm.errs().$out("PreprocessorInitializer:").
            $out("\n\t File StatCache size: ").$out(NativeTrace.formatNumber(FileStatCache.size())).
            $out("\n\t Directory StatCache size: ").$out(NativeTrace.formatNumber(DirectoryStatCache.size())).
            $out("\n\t MemoryBufferCache size: ").$out(NativeTrace.formatNumber(MemoryBufferCache.size())).
            $out("\n\t MemoryBufferCacheHits: ").$out(NativeTrace.formatNumber(MemoryBufferCacheHits.intValue())).
            $out("\n\t MemoryBufferCacheMisses: ").$out(NativeTrace.formatNumber(MemoryBufferCacheMisses.intValue())).
            $out("\n\t MemoryBufferMainFileHits: ").$out(NativeTrace.formatNumber(MemoryBufferMainFileHits.intValue())).
            $out("\n").flush();
    }    
}
