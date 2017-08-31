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

import java.util.concurrent.atomic.AtomicInteger;
import org.clang.basic.DiagnosticIDs;
import org.clang.basic.DiagnosticOptions;
import org.clang.basic.DiagnosticsEngine;
import org.clang.basic.FileData;
import org.clang.basic.FileManager;
import org.clang.basic.LangOptions;
import org.clang.basic.SourceManager;
import org.clang.basic.target.TargetInfo;
import org.clang.basic.target.TargetOptions;
import org.clang.frontend.CompilerInstance;
import org.clang.frontend.CompilerInvocation;
import org.clang.lex.HeaderSearch;
import org.clang.lex.ModuleLoader;
import org.clang.lex.PreprocessorOptions;
import org.clang.tools.services.ClankCompilationDataBase;
import org.clang.tools.services.ClankRunDiagnosticsSettings;
import org.clank.java.std;
import org.clank.java.std_ptr;
import org.llvm.adt.IntrusiveRefCntPtr;
import org.llvm.adt.StringRef;
import org.llvm.adt.Triple;
import org.llvm.adt.Twine;
import org.llvm.adt.aliases.StringMap;
import org.llvm.support.MemoryBuffer;
import org.llvm.support.llvm;

/**
 *
 * @author masha
 */
public class CompilerInvokationInitializer {

  private std.unique_ptr<CompilerInstance> Clang = null;
  private IntrusiveRefCntPtr<DiagnosticIDs> DiagID = null;
//  private std_ptr.shared_ptr<PCHContainerOperations> PCHOps = null;
  private IntrusiveRefCntPtr<DiagnosticOptions> DiagOpts = null;
  protected LangOptions LangOpts = null;
  protected SourceManager SourceMgr = null;
  protected HeaderSearch HS = null;
  protected ModuleLoader ModLoader = null;
  protected final FileManager FileMgr;
  //protected final PTHManager PTHMgr;
  protected final ClankDiagnosticsConsumerImpl DiagnosticConsumer;
  protected final DiagnosticsEngine Diags;
  protected final TargetOptions TargetOpts;
  protected final IntrusiveRefCntPtr<TargetInfo> Target;
  final PreprocessorOptions PPOpts;
  private static final StringMap<MemoryBuffer/*, BumpPtrAllocator*/> MemoryBufferCache;
  private static final AtomicInteger MemoryBufferCacheHits;
  private static final AtomicInteger MemoryBufferCacheMisses;
  private static final AtomicInteger MemoryBufferMainFileHits;
  private static final StringMap<FileData/*, BumpPtrAllocator*/> FileStatCache;
  private static final StringMap<FileData/*, BumpPtrAllocator*/> DirectoryStatCache;

  static {
    FileStatCache = new StringMap<FileData/*, BumpPtrAllocator*/>(1024 * 64, null);
    DirectoryStatCache = new StringMap<FileData/*, BumpPtrAllocator*/>(1024 * 8, null);
    MemoryBufferCache = new StringMap<MemoryBuffer/*, BumpPtrAllocator*/>(1024 * 16, null);
    MemoryBufferCacheHits = new AtomicInteger(0);
    MemoryBufferCacheMisses = new AtomicInteger(0);
    MemoryBufferMainFileHits = new AtomicInteger(0);
  }

  public CompilerInvokationInitializer(ClankRunDiagnosticsSettings settings, ClankCompilationDataBase.Entry entry) {
    Clang/*J*/ = new std.unique_ptr<CompilerInstance>(new CompilerInstance());
    DiagID/*J*/ = new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs());
// Buffer diagnostics from argument parsing so that we can output them using a
    // well formed diagnostic object.
    DiagOpts = new IntrusiveRefCntPtr<DiagnosticOptions>(new DiagnosticOptions());
    final ClankDiagnosticsConsumerImpl clankDiagnosticsConsumerImpl = new ClankDiagnosticsConsumerImpl(llvm.outs(), DiagOpts.$star(),
            settings, entry);
    //TextDiagnosticBuffer /*P*/ DiagsBuffer = new TextDiagnosticBuffer();
    Diags/*J*/ = new DiagnosticsEngine(DiagID, /*AddrOf*/ DiagOpts.$star(), clankDiagnosticsConsumerImpl);
    Diags.setEnableAllWarnings(settings.showAllWarning);
    //Diags.setWarningsAsErrors(true);
    //Diags.setE
    Clang.$arrow().setDiagnostics(Diags);
    FileMgr = PreprocessorInitializerHelper.$getFileManager(
            new SharedMemoryBufferCache(MemoryBufferCache, MemoryBufferCacheHits, MemoryBufferMainFileHits, MemoryBufferCacheMisses),
            FileStatCache, DirectoryStatCache, entry.getFileSystem());
    //compilerInstance.setFileManager(FileMgr);
    SourceMgr = new SourceManager(Diags, FileMgr);
    //compilerInstance.setSourceManager(SourceMgr);      
    DiagnosticConsumer = new ClankDiagnosticsConsumerImpl(llvm.outs(), DiagOpts.$star(),
            settings, entry);
    LangOpts = new LangOptions();
    LangOpts.Digraphs = true;
    LangOpts.Trigraphs = true;
    LangOpts.LineComment = true;
    TargetOpts = new TargetOptions();
    TargetOpts.Triple.$assign("x86_64");
    Triple T/*J*/ = new Triple(new Twine(TargetOpts.Triple));
    PPOpts = Clang.$arrow().getInvocation().getPreprocessorOpts();
    PPOpts.UsePredefines = false;
    // handle -include
    for (CharSequence path : entry.getIncludeFiles()) {
//            if (TRACE) {
//                System.err.println("file include " + path.toString());
//            }
      PPOpts.Includes.push_back(path);
    }
    for (String macro : entry.getSystemMacroDefines()) {
//            if (TRACE) {
//                System.err.println("sys macro " + macro);
//            }
      PPOpts.addMacroDef(new StringRef(macro));
    }
    for (String macro : entry.getUserMacroDefines()) {
//            if (TRACE) {
//                 System.err.println("user macro " + macro);
//            }
      PPOpts.addMacroDef(new StringRef(macro));
    }
    // remap unsaved files as memory buffers
    //TODO: fixme
//        if (this.remappedBuffers != null && !this.remappedBuffers.isEmpty()) {
//            PPOpts.RetainRemappedFileBuffers = true;
//            for (Map.Entry<String, MemoryBuffer> entry : this.remappedBuffers.entrySet()) {
//              final StringRef PathStringRef = ClangUtilities.createPathStringRef(entry.getKey());
//              final MemoryBuffer ToValue = entry.getValue();
//              if (TRACE) {
//                  err.$out("mapping [").$out(PathStringRef).$out("]=> Size [").$out(ToValue.getBufferSize()).$out("]").$out(NativePointer.$LF);
//              }
//              PPOpts.addRemappedFile(PathStringRef, ToValue);
//            }
//        }    

    CompilerInvocation.setLangDefaults(LangOpts, entry.getLanguage(), T, PPOpts, entry.getLangStandard());
    Target = new IntrusiveRefCntPtr<>(TargetInfo.CreateTargetInfo(Diags, /*AddrOf*/ new std_ptr.shared_ptr<TargetOptions>(TargetOpts)));
    ClankCompilerInvokationInitializer.fillInHeaderSearchOptions(Clang.$arrow().getInvocation().getHeaderSearchOpts(), entry);
    Clang.$arrow().setTarget(Target.$star());
    initializeCompilerInvokation();
    FileManager FileMgr = PreprocessorInitializerHelper.$getFileManager(
            new SharedMemoryBufferCache(MemoryBufferCache, MemoryBufferCacheHits, MemoryBufferMainFileHits, MemoryBufferCacheMisses),
            FileStatCache, DirectoryStatCache, entry.getFileSystem());
    Clang.$arrow().setFileManager(FileMgr);
    SourceManager SourceMgr = new SourceManager(Clang.$arrow().getDiagnostics(), FileMgr);
    Clang.$arrow().setSourceManager(SourceMgr);
  }

  private void initializeCompilerInvokation() {
    CompilerInvocation compilerInvocation = Clang.$arrow().getInvocation();
    //and now fill it
    if (compilerInvocation.TargetOpts != null) {
      compilerInvocation.TargetOpts.$destroy();
    }
    if (compilerInvocation.DiagnosticOpts != null) {
      compilerInvocation.DiagnosticOpts.$destroy();
    }
    if (compilerInvocation.LangOpts != null) {
      compilerInvocation.LangOpts.$destroy();
    }
    compilerInvocation.TargetOpts = new std_ptr.shared_ptr<>(TargetOpts);
    compilerInvocation.DiagnosticOpts = new IntrusiveRefCntPtr<>(Diags.getDiagnosticOptions());
    compilerInvocation.LangOpts = new std_ptr.shared_ptr<>(LangOpts);
  }
  
  public CompilerInstance get() {
    return Clang.$arrow();
  }

  public void $destroy() {
    Target.$destroy();
    TargetOpts.$destroy();
    SourceMgr.$destroy();
    HS.$destroy();
    ModLoader.$destroy();
    LangOpts.$destroy();
    PPOpts.$destroy();
    DiagOpts.$destroy();
    //Diags.$destroy(); it will be destroyed by DiagnosticConsumer
    DiagnosticConsumer.$destroy();
    Clang.$destroy();
    FileMgr.$destroy();
    SourceMgr.$destroy();
    
  }
}
