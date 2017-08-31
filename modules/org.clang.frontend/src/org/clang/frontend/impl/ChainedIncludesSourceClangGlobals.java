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
package org.clang.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.basic.target.TargetInfo;
import org.clang.lex.*;
import org.clang.sema.*;
import org.clang.serialization.*;
import static org.clang.frontend.impl.ChainedIncludesSourceStatics.*;
import org.clang.frontend.*;
import org.clang.frontend.impl.*;
import static org.clang.parse.ParseClangGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type ChainedIncludesSourceClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp -nm=_ZN5clang27createChainedIncludesSourceERNS_16CompilerInstanceERN4llvm18IntrusiveRefCntPtrINS_18ExternalSemaSourceEEE; -static-type=ChainedIncludesSourceClangGlobals -package=org.clang.frontend.impl")
//</editor-fold>
public final class ChainedIncludesSourceClangGlobals {


/// The ChainedIncludesSource class converts headers to chained PCHs in
/// memory, mainly for testing.
//<editor-fold defaultstate="collapsed" desc="clang::createChainedIncludesSource">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp", line = 112,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp", old_line = 115,
 FQN="clang::createChainedIncludesSource", NM="_ZN5clang27createChainedIncludesSourceERNS_16CompilerInstanceERN4llvm18IntrusiveRefCntPtrINS_18ExternalSemaSourceEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp -nm=_ZN5clang27createChainedIncludesSourceERNS_16CompilerInstanceERN4llvm18IntrusiveRefCntPtrINS_18ExternalSemaSourceEEE")
//</editor-fold>
public static IntrusiveRefCntPtr<ExternalSemaSource> createChainedIncludesSource(CompilerInstance /*&*/ CI, IntrusiveRefCntPtr<ExternalSemaSource> /*&*/ Reader) {
  std.vector<std.unique_ptr<CompilerInstance>> CIs = null;
  SmallVector<std.unique_ptr<MemoryBuffer>> SerialBufs = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    
    std.vectorString/*&*/ includes = CI.getPreprocessorOpts().ChainedIncludes;
    assert (!includes.empty()) : "No '-chain-include' in options!";
    
    CIs/*J*/= new std.vector<std.unique_ptr<CompilerInstance>>(new std.unique_ptr<CompilerInstance>());
    InputKind IK = CI.getFrontendOpts().Inputs.$at(0).getKind();
    
    SerialBufs/*J*/= new SmallVector<std.unique_ptr<MemoryBuffer>>(4, new std.unique_ptr<MemoryBuffer>());
    SmallVector<std.string> serialBufNames/*J*/= new SmallVector<std.string>(4, new std.string());
    
    for (/*uint*/int i = 0, e = includes.size(); i != e; ++i) {
      std.unique_ptr<CompilerInvocation> CInvok = null;
      FrontendInputFile InputFile = null;
      IntrusiveRefCntPtr<DiagnosticIDs> DiagID = null;
      IntrusiveRefCntPtr<DiagnosticsEngine> Diags = null;
      std.unique_ptr<CompilerInstance> Clang = null;
      shared_ptr<PCHBuffer> Buffer = null;
      unique_ptr<PCHGenerator> consumer = null;
      try {
        boolean firstInclude = (i == 0);
        CInvok/*J*/= new std.unique_ptr<CompilerInvocation>();
        CInvok.reset(new CompilerInvocation(CI.getInvocation()));
        
        CInvok.$arrow().getPreprocessorOpts().ChainedIncludes.clear();
        CInvok.$arrow().getPreprocessorOpts().ImplicitPCHInclude.clear();
        CInvok.$arrow().getPreprocessorOpts().ImplicitPTHInclude.clear();
        CInvok.$arrow().getPreprocessorOpts().DisablePCHValidation = true;
        CInvok.$arrow().getPreprocessorOpts().Includes.clear();
        CInvok.$arrow().getPreprocessorOpts().MacroIncludes.clear();
        CInvok.$arrow().getPreprocessorOpts().Macros.clear();
        
        CInvok.$arrow().getFrontendOpts().Inputs.clear();
        InputFile/*J*/= new FrontendInputFile(new StringRef(includes.$at(i)), IK);
        CInvok.$arrow().getFrontendOpts().Inputs.push_back_T$C$R(InputFile);
        
        TextDiagnosticPrinter /*P*/ DiagClient = new TextDiagnosticPrinter(llvm.errs(), new DiagnosticOptions());
        DiagID/*J*/= new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs());
        Diags/*J*/= new IntrusiveRefCntPtr<DiagnosticsEngine>(new DiagnosticsEngine(DiagID, /*AddrOf*/CI.getDiagnosticOpts(), DiagClient));
        
        Clang/*J*/= $c$.clean(new std.unique_ptr<CompilerInstance>(new CompilerInstance($c$.track(CI.getPCHContainerOperations()))));
        Clang.$arrow().setInvocation(CInvok.release());
        Clang.$arrow().setDiagnostics(Diags.get());
        Clang.$arrow().setTarget(TargetInfo.CreateTargetInfo(Clang.$arrow().getDiagnostics(), Clang.$arrow().getInvocation().TargetOpts));
        Clang.$arrow().createFileManager();
        Clang.$arrow().createSourceManager(Clang.$arrow().getFileManager());
        Clang.$arrow().createPreprocessor(TranslationUnitKind.TU_Prefix);
        Clang.$arrow().getDiagnosticClient().BeginSourceFile(Clang.$arrow().getLangOpts(), 
            /*AddrOf*/Clang.$arrow().getPreprocessor());
        Clang.$arrow().createASTContext();
        
        Buffer = std.make_shared(new PCHBuffer());
        ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension> > Extensions/*J*/= new ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension> >();
        consumer = llvm.make_unique(new PCHGenerator(Clang.$arrow().getPreprocessor(), StringRef.R$MINUS, (Module)null, /*isysroot=*/ StringRef.R$EMPTY, Buffer, 
            Extensions, /*AllowASTWithErrors=*/ true));
        Clang.$arrow().getASTContext().setASTMutationListener(consumer.$arrow().GetASTMutationListener());
        Clang.$arrow().setASTConsumer($c$.track(new std.unique_ptr<ASTConsumer>(JD$Unique_ptr$_Up$_Ep.INSTANCE, std.move(consumer)))); $c$.clean();
        Clang.$arrow().createSema(TranslationUnitKind.TU_Prefix, (CodeCompleteConsumer /*P*/ )null);
        if (firstInclude) {
          Preprocessor /*&*/ PP = Clang.$arrow().getPreprocessor();
          PP.getBuiltinInfo().initializeBuiltins(PP.getIdentifierTable(), 
              PP.getLangOpts());
        } else {
          SmallVector<std.unique_ptr<MemoryBuffer>> Bufs = null;
          raw_string_ostream os = null;
          IntrusiveRefCntPtr<ASTReader> _Reader = null;
          try {
            assert (!SerialBufs.empty());
            Bufs/*J*/= new SmallVector<std.unique_ptr<MemoryBuffer>>(4, new std.unique_ptr<MemoryBuffer>());
            // TODO: Pass through the existing MemoryBuffer instances instead of
            // allocating new ones.
            for (unique_ptr<MemoryBuffer> /*&*/ SB : SerialBufs)  {
              Bufs.push_back_T$RR($c$.track(MemoryBuffer.getMemBuffer(SB.$arrow().getBuffer()))); $c$.clean();
            }
            std.string pchName = new std.string(includes.$at(i - 1));
            os/*J*/= new raw_string_ostream(pchName);
            os.$out(/*KEEP_STR*/".pch").$out_uint(i - 1);
            serialBufNames.push_back_T$C$R(os.str());
            
            _Reader/*J*/= new IntrusiveRefCntPtr<ASTReader>();
            $c$.clean(_Reader.$assign($c$.track(new IntrusiveRefCntPtr<ASTReader>(createASTReader(Clang.$star(), new StringRef(pchName), Bufs, serialBufNames, 
                        Clang.$arrow().getASTConsumer().GetASTDeserializationListener())))));
            if (!_Reader.$bool()) {
              return new IntrusiveRefCntPtr<ExternalSemaSource>((ExternalSemaSource /*P*/ )null);
            }
            Clang.$arrow().setModuleManager($c$.track(new IntrusiveRefCntPtr<ASTReader>(_Reader))); $c$.clean();
            Clang.$arrow().getASTContext().setExternalSource($c$.track(new IntrusiveRefCntPtr<ExternalASTSource>(JD$IntrusiveRefCntPtr$X$C.INSTANCE, _Reader))); $c$.clean();
          } finally {
            if (_Reader != null) { _Reader.$destroy(); }
            if (os != null) { os.$destroy(); }
            if (Bufs != null) { Bufs.$destroy(); }
          }
        }
        if (!Clang.$arrow().InitializeSourceManager(InputFile)) {
          return new IntrusiveRefCntPtr<ExternalSemaSource>((ExternalSemaSource /*P*/ )null);
        }
        
        ParseAST(Clang.$arrow().getSema());
        Clang.$arrow().getDiagnosticClient().EndSourceFile();
        assert (Buffer.$arrow().IsComplete) : "serialization did not complete";
        SmallString /*&*/ serialAST = Buffer.$arrow().Data;
        SerialBufs.push_back_T$RR($c$.track(MemoryBuffer.getMemBufferCopy(new StringRef(serialAST.data(), serialAST.size())))); $c$.clean();
        serialAST.clear();
        CIs.push_back_T$RR(std.move(Clang));
      } finally {
        if (consumer != null) { consumer.$destroy(); }
        if (Buffer != null) { Buffer.$destroy(); }
        if (Clang != null) { Clang.$destroy(); }
        if (Diags != null) { Diags.$destroy(); }
        if (DiagID != null) { DiagID.$destroy(); }
        if (InputFile != null) { InputFile.$destroy(); }
        if (CInvok != null) { CInvok.$destroy(); }
      }
    }
    assert (!SerialBufs.empty());
    std.string pchName = $add_string$C_T$C$P(includes.back(), /*KEEP_STR*/".pch-final");
    serialBufNames.push_back_T$C$R(pchName);
    $c$.clean(Reader.$assign($c$.track(new IntrusiveRefCntPtr<ExternalSemaSource>(createASTReader(CI, new StringRef(pchName), SerialBufs, serialBufNames)))));
    if (!Reader.$bool()) {
      return new IntrusiveRefCntPtr<ExternalSemaSource>((ExternalSemaSource /*P*/ )null);
    }
    
    return $c$.clean(new IntrusiveRefCntPtr<ExternalSemaSource>(JD$IntrusiveRefCntPtr$X.INSTANCE, $c$.track(new IntrusiveRefCntPtr<ChainedIncludesSource>(new ChainedIncludesSource($c$.track(new std.vector<std.unique_ptr<CompilerInstance>>(JD$Move.INSTANCE, std.move(CIs))), $c$.track(new IntrusiveRefCntPtr<ExternalSemaSource>(Reader)))))));
  } finally {
    if (SerialBufs != null) { SerialBufs.$destroy(); }
    if (CIs != null) { CIs.$destroy(); }
    $c$.$destroy();
  }
}

} // END OF class ChainedIncludesSourceClangGlobals
