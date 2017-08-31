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
package org.clang.parse;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.llvm.*;
import org.clang.sema.*;
import org.clang.parse.*;
import org.clang.parse.impl.*;
import org.clang.parse.java.ParseMemberPointers.*;
import static org.clang.parse.Parser.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.parse.impl.ParsePragmaStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type Parser_ParsePragma">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType -split-class=clang::Parser@this -extends=Parser_ParseOpenMP ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser16HandlePragmaDumpEv;_ZN5clang6Parser16HandlePragmaPackEv;_ZN5clang6Parser16HandlePragmaWeakEv;_ZN5clang6Parser17HandlePragmaAlignEv;_ZN5clang6Parser18HandlePragmaUnusedEv;_ZN5clang6Parser19resetPragmaHandlersEv;_ZN5clang6Parser20HandlePragmaCapturedEv;_ZN5clang6Parser20HandlePragmaLoopHintERNS_8LoopHintE;_ZN5clang6Parser20HandlePragmaMSPragmaEv;_ZN5clang6Parser20HandlePragmaMSStructEv;_ZN5clang6Parser21HandlePragmaMSInitSegEN4llvm9StringRefENS_14SourceLocationE;_ZN5clang6Parser21HandlePragmaMSSectionEN4llvm9StringRefENS_14SourceLocationE;_ZN5clang6Parser21HandlePragmaMSSegmentEN4llvm9StringRefENS_14SourceLocationE;_ZN5clang6Parser21HandlePragmaWeakAliasEv;_ZN5clang6Parser22HandlePragmaFPContractEv;_ZN5clang6Parser22HandlePragmaMSVtorDispEv;_ZN5clang6Parser22HandlePragmaVisibilityEv;_ZN5clang6Parser24initializePragmaHandlersEv;_ZN5clang6Parser27HandlePragmaOpenCLExtensionEv;_ZN5clang6Parser27HandlePragmaRedefineExtnameEv;_ZN5clang6Parser31HandlePragmaMSPointersToMembersEv; -static-type=Parser_ParsePragma -package=org.clang.parse")
//</editor-fold>
public class Parser_ParsePragma extends Parser_ParseOpenMP {
private final /*split clang::Parser*/ Parser $this() { return (Parser)this; }


/// \brief Initialize all pragma handlers.
// end namespace
//<editor-fold defaultstate="collapsed" desc="clang::Parser::initializePragmaHandlers">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 166,
   FQN="clang::Parser::initializePragmaHandlers", NM="_ZN5clang6Parser24initializePragmaHandlersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser24initializePragmaHandlersEv")
  //</editor-fold>
  protected /*private*/ void initializePragmaHandlers() {
    $this().AlignHandler.reset(new PragmaAlignHandler());
    $this().PP.AddPragmaHandler($this().AlignHandler.get());
    
    $this().GCCVisibilityHandler.reset(new PragmaGCCVisibilityHandler());
    $this().PP.AddPragmaHandler(new StringRef(/*KEEP_STR*/"GCC"), $this().GCCVisibilityHandler.get());
    
    $this().OptionsHandler.reset(new PragmaOptionsHandler());
    $this().PP.AddPragmaHandler($this().OptionsHandler.get());
    
    $this().PackHandler.reset(new PragmaPackHandler());
    $this().PP.AddPragmaHandler($this().PackHandler.get());
    
    $this().MSStructHandler.reset(new PragmaMSStructHandler());
    $this().PP.AddPragmaHandler($this().MSStructHandler.get());
    
    $this().UnusedHandler.reset(new PragmaUnusedHandler());
    $this().PP.AddPragmaHandler($this().UnusedHandler.get());
    
    $this().WeakHandler.reset(new PragmaWeakHandler());
    $this().PP.AddPragmaHandler($this().WeakHandler.get());
    
    $this().RedefineExtnameHandler.reset(new PragmaRedefineExtnameHandler());
    $this().PP.AddPragmaHandler($this().RedefineExtnameHandler.get());
    
    $this().FPContractHandler.reset(new PragmaFPContractHandler());
    $this().PP.AddPragmaHandler(new StringRef(/*KEEP_STR*/"STDC"), $this().FPContractHandler.get());
    if ($this().getLangOpts().OpenCL) {
      $this().OpenCLExtensionHandler.reset(new PragmaOpenCLExtensionHandler());
      $this().PP.AddPragmaHandler(new StringRef(/*KEEP_STR*/"OPENCL"), $this().OpenCLExtensionHandler.get());
      
      $this().PP.AddPragmaHandler(new StringRef(/*KEEP_STR*/"OPENCL"), $this().FPContractHandler.get());
    }
    if (($this().getLangOpts().OpenMP != 0)) {
      $this().OpenMPHandler.reset(new PragmaOpenMPHandler());
    } else {
      $this().OpenMPHandler.reset(new PragmaNoOpenMPHandler());
    }
    $this().PP.AddPragmaHandler($this().OpenMPHandler.get());
    if ($this().getLangOpts().MicrosoftExt || $this().getTargetInfo().getTriple().isPS4()) {
      $this().MSCommentHandler.reset(new PragmaCommentHandler($this().Actions));
      $this().PP.AddPragmaHandler($this().MSCommentHandler.get());
    }
    if ($this().getLangOpts().MicrosoftExt) {
      $this().MSDetectMismatchHandler.reset(new PragmaDetectMismatchHandler($this().Actions));
      $this().PP.AddPragmaHandler($this().MSDetectMismatchHandler.get());
      $this().MSPointersToMembers.reset(new PragmaMSPointersToMembers());
      $this().PP.AddPragmaHandler($this().MSPointersToMembers.get());
      $this().MSVtorDisp.reset(new PragmaMSVtorDisp());
      $this().PP.AddPragmaHandler($this().MSVtorDisp.get());
      $this().MSInitSeg.reset(new PragmaMSPragma($("init_seg")));
      $this().PP.AddPragmaHandler($this().MSInitSeg.get());
      $this().MSDataSeg.reset(new PragmaMSPragma($("data_seg")));
      $this().PP.AddPragmaHandler($this().MSDataSeg.get());
      $this().MSBSSSeg.reset(new PragmaMSPragma($("bss_seg")));
      $this().PP.AddPragmaHandler($this().MSBSSSeg.get());
      $this().MSConstSeg.reset(new PragmaMSPragma($("const_seg")));
      $this().PP.AddPragmaHandler($this().MSConstSeg.get());
      $this().MSCodeSeg.reset(new PragmaMSPragma($("code_seg")));
      $this().PP.AddPragmaHandler($this().MSCodeSeg.get());
      $this().MSSection.reset(new PragmaMSPragma($("section")));
      $this().PP.AddPragmaHandler($this().MSSection.get());
      $this().MSRuntimeChecks.reset(new PragmaMSRuntimeChecksHandler());
      $this().PP.AddPragmaHandler($this().MSRuntimeChecks.get());
    }
    
    $this().OptimizeHandler.reset(new PragmaOptimizeHandler($this().Actions));
    $this().PP.AddPragmaHandler(new StringRef(/*KEEP_STR*/"clang"), $this().OptimizeHandler.get());
    
    $this().LoopHintHandler.reset(new PragmaLoopHintHandler());
    $this().PP.AddPragmaHandler(new StringRef(/*KEEP_STR*/"clang"), $this().LoopHintHandler.get());
    
    $this().UnrollHintHandler.reset(new PragmaUnrollHintHandler($("unroll")));
    $this().PP.AddPragmaHandler($this().UnrollHintHandler.get());
    
    $this().NoUnrollHintHandler.reset(new PragmaUnrollHintHandler($("nounroll")));
    $this().PP.AddPragmaHandler($this().NoUnrollHintHandler.get());
  }


/// \brief Destroy and reset all pragma handlers.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::resetPragmaHandlers">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 247,
   FQN="clang::Parser::resetPragmaHandlers", NM="_ZN5clang6Parser19resetPragmaHandlersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser19resetPragmaHandlersEv")
  //</editor-fold>
  protected /*private*/ void resetPragmaHandlers() {
    // Remove the pragma handlers we installed.
    $this().PP.RemovePragmaHandler($this().AlignHandler.get());
    $this().AlignHandler.reset();
    $this().PP.RemovePragmaHandler(new StringRef(/*KEEP_STR*/"GCC"), $this().GCCVisibilityHandler.get());
    $this().GCCVisibilityHandler.reset();
    $this().PP.RemovePragmaHandler($this().OptionsHandler.get());
    $this().OptionsHandler.reset();
    $this().PP.RemovePragmaHandler($this().PackHandler.get());
    $this().PackHandler.reset();
    $this().PP.RemovePragmaHandler($this().MSStructHandler.get());
    $this().MSStructHandler.reset();
    $this().PP.RemovePragmaHandler($this().UnusedHandler.get());
    $this().UnusedHandler.reset();
    $this().PP.RemovePragmaHandler($this().WeakHandler.get());
    $this().WeakHandler.reset();
    $this().PP.RemovePragmaHandler($this().RedefineExtnameHandler.get());
    $this().RedefineExtnameHandler.reset();
    if ($this().getLangOpts().OpenCL) {
      $this().PP.RemovePragmaHandler(new StringRef(/*KEEP_STR*/"OPENCL"), $this().OpenCLExtensionHandler.get());
      $this().OpenCLExtensionHandler.reset();
      $this().PP.RemovePragmaHandler(new StringRef(/*KEEP_STR*/"OPENCL"), $this().FPContractHandler.get());
    }
    $this().PP.RemovePragmaHandler($this().OpenMPHandler.get());
    $this().OpenMPHandler.reset();
    if ($this().getLangOpts().MicrosoftExt || $this().getTargetInfo().getTriple().isPS4()) {
      $this().PP.RemovePragmaHandler($this().MSCommentHandler.get());
      $this().MSCommentHandler.reset();
    }
    if ($this().getLangOpts().MicrosoftExt) {
      $this().PP.RemovePragmaHandler($this().MSDetectMismatchHandler.get());
      $this().MSDetectMismatchHandler.reset();
      $this().PP.RemovePragmaHandler($this().MSPointersToMembers.get());
      $this().MSPointersToMembers.reset();
      $this().PP.RemovePragmaHandler($this().MSVtorDisp.get());
      $this().MSVtorDisp.reset();
      $this().PP.RemovePragmaHandler($this().MSInitSeg.get());
      $this().MSInitSeg.reset();
      $this().PP.RemovePragmaHandler($this().MSDataSeg.get());
      $this().MSDataSeg.reset();
      $this().PP.RemovePragmaHandler($this().MSBSSSeg.get());
      $this().MSBSSSeg.reset();
      $this().PP.RemovePragmaHandler($this().MSConstSeg.get());
      $this().MSConstSeg.reset();
      $this().PP.RemovePragmaHandler($this().MSCodeSeg.get());
      $this().MSCodeSeg.reset();
      $this().PP.RemovePragmaHandler($this().MSSection.get());
      $this().MSSection.reset();
      $this().PP.RemovePragmaHandler($this().MSRuntimeChecks.get());
      $this().MSRuntimeChecks.reset();
    }
    
    $this().PP.RemovePragmaHandler(new StringRef(/*KEEP_STR*/"STDC"), $this().FPContractHandler.get());
    $this().FPContractHandler.reset();
    
    $this().PP.RemovePragmaHandler(new StringRef(/*KEEP_STR*/"clang"), $this().OptimizeHandler.get());
    $this().OptimizeHandler.reset();
    
    $this().PP.RemovePragmaHandler(new StringRef(/*KEEP_STR*/"clang"), $this().LoopHintHandler.get());
    $this().LoopHintHandler.reset();
    
    $this().PP.RemovePragmaHandler($this().UnrollHintHandler.get());
    $this().UnrollHintHandler.reset();
    
    $this().PP.RemovePragmaHandler($this().NoUnrollHintHandler.get());
    $this().NoUnrollHintHandler.reset();
  }


/// \brief Handle the annotation token produced for #pragma unused(...)

/// \brief Handle the annotation token produced for #pragma unused(...)
///
/// Each annot_pragma_unused is followed by the argument token so e.g.
/// "#pragma unused(x,y)" becomes:
/// annot_pragma_unused 'x' annot_pragma_unused 'y'
//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandlePragmaUnused">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 323,
   FQN="clang::Parser::HandlePragmaUnused", NM="_ZN5clang6Parser18HandlePragmaUnusedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser18HandlePragmaUnusedEv")
  //</editor-fold>
  protected /*private*/ void HandlePragmaUnused() {
    assert ($this().Tok.is(tok.TokenKind.annot_pragma_unused));
    SourceLocation UnusedLoc = $this().ConsumeToken();
    $this().Actions.ActOnPragmaUnused($this().Tok, $this().getCurScope(), new SourceLocation(UnusedLoc));
    $this().ConsumeToken(); // The argument token.
  }


/// \brief Handle the annotation token produced for
/// #pragma GCC visibility...
//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandlePragmaVisibility">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 330,
   FQN="clang::Parser::HandlePragmaVisibility", NM="_ZN5clang6Parser22HandlePragmaVisibilityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser22HandlePragmaVisibilityEv")
  //</editor-fold>
  protected /*private*/ void HandlePragmaVisibility() {
    assert ($this().Tok.is(tok.TokenKind.annot_pragma_vis));
    /*const*/ IdentifierInfo /*P*/ VisType = ((/*static_cast*/IdentifierInfo /*P*/ )($this().Tok.getAnnotationValue()));
    SourceLocation VisLoc = $this().ConsumeToken();
    $this().Actions.ActOnPragmaVisibility(VisType, new SourceLocation(VisLoc));
  }


/// \brief Handle the annotation token produced for
/// #pragma pack...
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandlePragmaPack">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 346,
   FQN="clang::Parser::HandlePragmaPack", NM="_ZN5clang6Parser16HandlePragmaPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser16HandlePragmaPackEv")
  //</editor-fold>
  protected /*private*/ void HandlePragmaPack() {
    assert ($this().Tok.is(tok.TokenKind.annot_pragma_pack));
    PragmaPackInfo /*P*/ Info = ((/*static_cast*/PragmaPackInfo /*P*/ )($this().Tok.getAnnotationValue()));
    SourceLocation PragmaLoc = $this().ConsumeToken();
    ActionResultTTrue<Expr /*P*/ > Alignment/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if (Info.Alignment.is(tok.TokenKind.numeric_constant)) {
      Alignment.$assignMove($this().Actions.ActOnNumericConstant(Info.Alignment));
      if (Alignment.isInvalid()) {
        return;
      }
    }
    $this().Actions.ActOnPragmaPack(new SourceLocation(PragmaLoc), Info.Action, new StringRef(Info.SlotLabel), 
        Alignment.get());
  }


/// \brief Handle the annotation token produced for
/// #pragma ms_struct...
//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandlePragmaMSStruct">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 361,
   FQN="clang::Parser::HandlePragmaMSStruct", NM="_ZN5clang6Parser20HandlePragmaMSStructEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser20HandlePragmaMSStructEv")
  //</editor-fold>
  protected /*private*/ void HandlePragmaMSStruct() {
    assert ($this().Tok.is(tok.TokenKind.annot_pragma_msstruct));
    PragmaMSStructKind Kind = /*static_cast*/PragmaMSStructKind.valueOf(reinterpret_cast_uint($this().Tok.getAnnotationValue()));
    $this().Actions.ActOnPragmaMSStruct(Kind);
    $this().ConsumeToken(); // The annotation token.
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandlePragmaMSPointersToMembers">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 496,
   FQN="clang::Parser::HandlePragmaMSPointersToMembers", NM="_ZN5clang6Parser31HandlePragmaMSPointersToMembersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser31HandlePragmaMSPointersToMembersEv")
  //</editor-fold>
  protected /*private*/ void HandlePragmaMSPointersToMembers() {
    assert ($this().Tok.is(tok.TokenKind.annot_pragma_ms_pointers_to_members));
    LangOptions.PragmaMSPointersToMembersKind RepresentationMethod = /*static_cast*/LangOptions.PragmaMSPointersToMembersKind.valueOf(reinterpret_cast_uint($this().Tok.getAnnotationValue()));
    SourceLocation PragmaLoc = $this().ConsumeToken(); // The annotation token.
    $this().Actions.ActOnPragmaMSPointersToMembers(RepresentationMethod, new SourceLocation(PragmaLoc));
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandlePragmaMSVtorDisp">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 505,
   FQN="clang::Parser::HandlePragmaMSVtorDisp", NM="_ZN5clang6Parser22HandlePragmaMSVtorDispEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser22HandlePragmaMSVtorDispEv")
  //</editor-fold>
  protected /*private*/ void HandlePragmaMSVtorDisp() {
    assert ($this().Tok.is(tok.TokenKind.annot_pragma_ms_vtordisp));
    int/*uintptr_t*/ Value = reinterpret_cast_uint($this().Tok.getAnnotationValue());
    /*Sema::PragmaMsStackAction*//*uint*/int Action = ((/*static_cast*//*Sema::PragmaMsStackAction*//*uint*/int)((Value >>> 16) & 0xFFFF));
    MSVtorDispAttr.Mode Mode = MSVtorDispAttr.Mode.valueOf(Value & 0xFFFF);
    SourceLocation PragmaLoc = $this().ConsumeToken(); // The annotation token.
    $this().Actions.ActOnPragmaMSVtorDisp(Action, new SourceLocation(PragmaLoc), Mode);
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandlePragmaMSPragma">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 515,
   FQN="clang::Parser::HandlePragmaMSPragma", NM="_ZN5clang6Parser20HandlePragmaMSPragmaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser20HandlePragmaMSPragmaEv")
  //</editor-fold>
  protected /*private*/ void HandlePragmaMSPragma() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert ($this().Tok.is(tok.TokenKind.annot_pragma_ms_pragma));
      // Grab the tokens out of the annotation and enter them into the stream.
      std.pairTypeUInt<unique_ptr_array<Token>> /*P*/ TheTokens = (std.pairTypeUInt<unique_ptr_array<Token>> /*P*/)$this().Tok.getAnnotationValue();
      $this().PP.EnterTokenStream($c$.track(new unique_ptr_array<Token>(JD$Move.INSTANCE, std.move(TheTokens.first))), TheTokens.second, true); $c$.clean();
      SourceLocation PragmaLocation = $this().ConsumeToken(); // The annotation token.
      assert ($this().Tok.isAnyIdentifier());
      StringRef PragmaName = $this().Tok.getIdentifierInfo().getName();
      $this().PP.Lex($this().Tok); // pragma kind
      
      // Figure out which #pragma we're dealing with.  The switch has no default
      // because lex shouldn't emit the annotation token for unrecognized pragmas.
      /*typedef bool (Parser::*PragmaHandler)(StringRef, SourceLocation)*/
  //    final class PragmaHandler extends Parser$StringRefSourceLocation2Bool{ };
      Parser$StringRefSourceLocation2Bool Handler = new StringSwitch<Parser$StringRefSourceLocation2Bool>(/*NO_COPY*/PragmaName).
          Case(/*KEEP_STR*/"data_seg", /*AddrOf*//*FPtr*/Parser::HandlePragmaMSSegment).
          Case(/*KEEP_STR*/"bss_seg", /*AddrOf*//*FPtr*/Parser::HandlePragmaMSSegment).
          Case(/*KEEP_STR*/"const_seg", /*AddrOf*//*FPtr*/Parser::HandlePragmaMSSegment).
          Case(/*KEEP_STR*/"code_seg", /*AddrOf*//*FPtr*/Parser::HandlePragmaMSSegment).
          Case(/*KEEP_STR*/"section", /*AddrOf*//*FPtr*/Parser::HandlePragmaMSSection).
          Case(/*KEEP_STR*/"init_seg", /*AddrOf*//*FPtr*/Parser::HandlePragmaMSInitSeg).$T1();
      if (!Handler.$call(/*PtrMemI*/$this(), new StringRef(PragmaName), new SourceLocation(PragmaLocation))) {
        // Pragma handling failed, and has been diagnosed.  Slurp up the tokens
        // until eof (really end of line) to prevent follow-on errors.
        while ($this().Tok.isNot(tok.TokenKind.eof)) {
          $this().PP.Lex($this().Tok);
        }
        $this().PP.Lex($this().Tok);
      }
    } finally {
      $c$.$destroy();
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandlePragmaMSSection">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 546,
   FQN="clang::Parser::HandlePragmaMSSection", NM="_ZN5clang6Parser21HandlePragmaMSSectionEN4llvm9StringRefENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser21HandlePragmaMSSectionEN4llvm9StringRefENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ boolean HandlePragmaMSSection(StringRef PragmaName, 
                       SourceLocation PragmaLocation) {
    if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().PP.Diag(/*NO_COPY*/PragmaLocation, diag.warn_pragma_expected_lparen)), /*NO_COPY*/PragmaName));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    $this().PP.Lex($this().Tok); // (
    // Parsing code for pragma section
    if ($this().Tok.isNot(tok.TokenKind.string_literal)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().PP.Diag(/*NO_COPY*/PragmaLocation, diag.warn_pragma_expected_section_name)), 
            /*NO_COPY*/PragmaName));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    ActionResultTTrue<Expr /*P*/ > StringResult = $this().ParseStringLiteralExpression();
    if (StringResult.isInvalid()) {
      return false; // Already diagnosed.
    }
    StringLiteral /*P*/ SegmentName = cast(StringLiteral.class, StringResult.get());
    if (SegmentName.getCharByteWidth() != 1) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().PP.Diag(/*NO_COPY*/PragmaLocation, diag.warn_pragma_expected_non_wide_string)), 
            /*NO_COPY*/PragmaName));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    int SectionFlags = ASTContext.PragmaSectionFlag.PSF_Read;
    boolean SectionFlagsAreDefault = true;
    while ($this().Tok.is(tok.TokenKind.comma)) {
      $this().PP.Lex($this().Tok); // ,
      // Ignore "long" and "short".
      // They are undocumented, but widely used, section attributes which appear
      // to do nothing.
      if ($this().Tok.is(tok.TokenKind.kw_long) || $this().Tok.is(tok.TokenKind.kw_short)) {
        $this().PP.Lex($this().Tok); // long/short
        continue;
      }
      if (!$this().Tok.isAnyIdentifier()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().PP.Diag(/*NO_COPY*/PragmaLocation, diag.warn_pragma_expected_action_or_r_paren)), 
              /*NO_COPY*/PragmaName));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
      /*ASTContext::PragmaSectionFlag*//*uint*/int Flag = new StringSwitchInt/*ASTContext.PragmaSectionFlag*/($this().Tok.getIdentifierInfo().getName()).
          Case(/*KEEP_STR*/"read", ASTContext.PragmaSectionFlag.PSF_Read).
          Case(/*KEEP_STR*/"write", ASTContext.PragmaSectionFlag.PSF_Write).
          Case(/*KEEP_STR*/"execute", ASTContext.PragmaSectionFlag.PSF_Execute).
          Case(/*KEEP_STR*/"shared", ASTContext.PragmaSectionFlag.PSF_Invalid).
          Case(/*KEEP_STR*/"nopage", ASTContext.PragmaSectionFlag.PSF_Invalid).
          Case(/*KEEP_STR*/"nocache", ASTContext.PragmaSectionFlag.PSF_Invalid).
          Case(/*KEEP_STR*/"discard", ASTContext.PragmaSectionFlag.PSF_Invalid).
          Case(/*KEEP_STR*/"remove", ASTContext.PragmaSectionFlag.PSF_Invalid).
          Default(ASTContext.PragmaSectionFlag.PSF_None);
      if (Flag == ASTContext.PragmaSectionFlag.PSF_None || Flag == ASTContext.PragmaSectionFlag.PSF_Invalid) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track($this().PP.Diag(/*NO_COPY*/PragmaLocation, Flag == ASTContext.PragmaSectionFlag.PSF_None ? diag.warn_pragma_invalid_specific_action : diag.warn_pragma_unsupported_action)), 
                  /*NO_COPY*/PragmaName), $this().Tok.getIdentifierInfo().getName()));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
      SectionFlags |= Flag;
      SectionFlagsAreDefault = false;
      $this().PP.Lex($this().Tok); // Identifier
    }
    // If no section attributes are specified, the section will be marked as
    // read/write.
    if (SectionFlagsAreDefault) {
      SectionFlags |= ASTContext.PragmaSectionFlag.PSF_Write;
    }
    if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().PP.Diag(/*NO_COPY*/PragmaLocation, diag.warn_pragma_expected_rparen)), /*NO_COPY*/PragmaName));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    $this().PP.Lex($this().Tok); // )
    if ($this().Tok.isNot(tok.TokenKind.eof)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().PP.Diag(/*NO_COPY*/PragmaLocation, diag.warn_pragma_extra_tokens_at_eol)), 
            /*NO_COPY*/PragmaName));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    $this().PP.Lex($this().Tok); // eof
    $this().Actions.ActOnPragmaMSSection(new SourceLocation(PragmaLocation), SectionFlags, SegmentName);
    return true;
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandlePragmaMSSegment">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 627,
   FQN="clang::Parser::HandlePragmaMSSegment", NM="_ZN5clang6Parser21HandlePragmaMSSegmentEN4llvm9StringRefENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser21HandlePragmaMSSegmentEN4llvm9StringRefENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ boolean HandlePragmaMSSegment(StringRef PragmaName, 
                       SourceLocation PragmaLocation) {
    if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().PP.Diag(/*NO_COPY*/PragmaLocation, diag.warn_pragma_expected_lparen)), /*NO_COPY*/PragmaName));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    $this().PP.Lex($this().Tok); // (
    /*Sema::PragmaMsStackAction*//*uint*/int Action = Sema.PragmaMsStackAction.PSK_Reset;
    StringRef SlotLabel/*J*/= new StringRef();
    if ($this().Tok.isAnyIdentifier()) {
      StringRef PushPop = $this().Tok.getIdentifierInfo().getName();
      if ($eq_StringRef(/*NO_COPY*/PushPop, /*STRINGREF_STR*/"push")) {
        Action = Sema.PragmaMsStackAction.PSK_Push;
      } else if ($eq_StringRef(/*NO_COPY*/PushPop, /*STRINGREF_STR*/"pop")) {
        Action = Sema.PragmaMsStackAction.PSK_Pop;
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().PP.Diag(/*NO_COPY*/PragmaLocation, 
                  diag.warn_pragma_expected_section_push_pop_or_name)), 
              /*NO_COPY*/PragmaName));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
      if (Action != Sema.PragmaMsStackAction.PSK_Reset) {
        $this().PP.Lex($this().Tok); // push | pop
        if ($this().Tok.is(tok.TokenKind.comma)) {
          $this().PP.Lex($this().Tok); // ,
          // If we've got a comma, we either need a label or a string.
          if ($this().Tok.isAnyIdentifier()) {
            SlotLabel.$assignMove($this().Tok.getIdentifierInfo().getName());
            $this().PP.Lex($this().Tok); // identifier
            if ($this().Tok.is(tok.TokenKind.comma)) {
              $this().PP.Lex($this().Tok);
            } else if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().PP.Diag(/*NO_COPY*/PragmaLocation, diag.warn_pragma_expected_punc)), 
                    /*NO_COPY*/PragmaName));
                return false;
              } finally {
                $c$.$destroy();
              }
            }
          }
        } else if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().PP.Diag(/*NO_COPY*/PragmaLocation, diag.warn_pragma_expected_punc)), /*NO_COPY*/PragmaName));
            return false;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    // Grab the string literal for our section name.
    StringLiteral /*P*/ SegmentName = null;
    if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
      if ($this().Tok.isNot(tok.TokenKind.string_literal)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          /*uint*/int DiagID = Action != Sema.PragmaMsStackAction.PSK_Reset ? !SlotLabel.empty() ? diag.warn_pragma_expected_section_name : diag.warn_pragma_expected_section_label_or_name : diag.warn_pragma_expected_section_push_pop_or_name;
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().PP.Diag(/*NO_COPY*/PragmaLocation, DiagID)), /*NO_COPY*/PragmaName));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
      ActionResultTTrue<Expr /*P*/ > StringResult = $this().ParseStringLiteralExpression();
      if (StringResult.isInvalid()) {
        return false; // Already diagnosed.
      }
      SegmentName = cast(StringLiteral.class, StringResult.get());
      if (SegmentName.getCharByteWidth() != 1) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().PP.Diag(/*NO_COPY*/PragmaLocation, diag.warn_pragma_expected_non_wide_string)), 
              /*NO_COPY*/PragmaName));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
      // Setting section "" has no effect
      if ((SegmentName.getLength() != 0)) {
        Action = (/*Sema::PragmaMsStackAction*//*uint*/int)(Action | Sema.PragmaMsStackAction.PSK_Set);
      }
    }
    if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().PP.Diag(/*NO_COPY*/PragmaLocation, diag.warn_pragma_expected_rparen)), /*NO_COPY*/PragmaName));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    $this().PP.Lex($this().Tok); // )
    if ($this().Tok.isNot(tok.TokenKind.eof)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().PP.Diag(/*NO_COPY*/PragmaLocation, diag.warn_pragma_extra_tokens_at_eol)), 
            /*NO_COPY*/PragmaName));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    $this().PP.Lex($this().Tok); // eof
    $this().Actions.ActOnPragmaMSSeg(new SourceLocation(PragmaLocation), Action, new StringRef(SlotLabel), 
        SegmentName, new StringRef(PragmaName));
    return true;
  }


// #pragma init_seg({ compiler | lib | user | "section-name" [, func-name]} )
//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandlePragmaMSInitSeg">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 711,
   FQN="clang::Parser::HandlePragmaMSInitSeg", NM="_ZN5clang6Parser21HandlePragmaMSInitSegEN4llvm9StringRefENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser21HandlePragmaMSInitSegEN4llvm9StringRefENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ boolean HandlePragmaMSInitSeg(StringRef PragmaName, 
                       SourceLocation PragmaLocation) {
    if ($this().getTargetInfo().getTriple().getEnvironment() != Triple.EnvironmentType.MSVC) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().PP.Diag(/*NO_COPY*/PragmaLocation, diag.warn_pragma_init_seg_unsupported_target)));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    if ($this().ExpectAndConsume(tok.TokenKind.l_paren, diag.warn_pragma_expected_lparen, 
        new StringRef(PragmaName))) {
      return false;
    }
    
    // Parse either the known section names or the string section name.
    StringLiteral /*P*/ SegmentName = null;
    if ($this().Tok.isAnyIdentifier()) {
      IdentifierInfo /*P*/ II = $this().Tok.getIdentifierInfo();
      StringRef Section = new StringSwitchStringRef(II.getName()).
          Case(/*KEEP_STR*/"compiler", /*STRINGREF_STR*/"\".CRT$XCC\"").
          Case(/*KEEP_STR*/"lib", /*STRINGREF_STR*/"\".CRT$XCL\"").
          Case(/*KEEP_STR*/"user", /*STRINGREF_STR*/"\".CRT$XCU\"").
          Default(/*STRINGREF_STR*/$EMPTY);
      if (!Section.empty()) {
        // Pretend the user wrote the appropriate string literal here.
        Token Toks[/*1*/]/*J*/= new$T(new Token [1], ()->new Token());
        Toks[0].startToken();
        Toks[0].setKind(tok.TokenKind.string_literal);
        Toks[0].setLocation($this().Tok.getLocation());
        Toks[0].setLiteralData(Section.data());
        Toks[0].setLength(Section.size());
        SegmentName
           = cast(StringLiteral.class, $this().Actions.ActOnStringLiteral(new ArrayRefToken(Toks), (Scope /*P*/ )null).get());
        $this().PP.Lex($this().Tok);
      }
    } else if ($this().Tok.is(tok.TokenKind.string_literal)) {
      ActionResultTTrue<Expr /*P*/ > StringResult = $this().ParseStringLiteralExpression();
      if (StringResult.isInvalid()) {
        return false;
      }
      SegmentName = cast(StringLiteral.class, StringResult.get());
      if (SegmentName.getCharByteWidth() != 1) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().PP.Diag(/*NO_COPY*/PragmaLocation, diag.warn_pragma_expected_non_wide_string)), 
              /*NO_COPY*/PragmaName));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
      // FIXME: Add support for the '[, func-name]' part of the pragma.
    }
    if (!(SegmentName != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().PP.Diag(/*NO_COPY*/PragmaLocation, diag.warn_pragma_expected_init_seg)), /*NO_COPY*/PragmaName));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    if ($this().ExpectAndConsume(tok.TokenKind.r_paren, diag.warn_pragma_expected_rparen, 
        new StringRef(PragmaName))
       || $this().ExpectAndConsume(tok.TokenKind.eof, diag.warn_pragma_extra_tokens_at_eol, 
        new StringRef(PragmaName))) {
      return false;
    }
    
    $this().Actions.ActOnPragmaMSInitSeg(new SourceLocation(PragmaLocation), SegmentName);
    return true;
  }


/// \brief Handle the annotation token produced for
/// #pragma align...
//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandlePragmaAlign">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 369,
   FQN="clang::Parser::HandlePragmaAlign", NM="_ZN5clang6Parser17HandlePragmaAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser17HandlePragmaAlignEv")
  //</editor-fold>
  protected /*private*/ void HandlePragmaAlign() {
    assert ($this().Tok.is(tok.TokenKind.annot_pragma_align));
    Sema.PragmaOptionsAlignKind Kind = /*static_cast*/Sema.PragmaOptionsAlignKind.valueOf(reinterpret_cast_uint($this().Tok.getAnnotationValue()));
    SourceLocation PragmaLoc = $this().ConsumeToken();
    $this().Actions.ActOnPragmaOptionsAlign(Kind, new SourceLocation(PragmaLoc));
  }


/// \brief Handle the annotation token produced for
/// #pragma clang __debug dump...
//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandlePragmaDump">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 378,
   FQN="clang::Parser::HandlePragmaDump", NM="_ZN5clang6Parser16HandlePragmaDumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser16HandlePragmaDumpEv")
  //</editor-fold>
  protected /*private*/ void HandlePragmaDump() {
    assert ($this().Tok.is(tok.TokenKind.annot_pragma_dump));
    IdentifierInfo /*P*/ II = reinterpret_cast(IdentifierInfo /*P*/ .class, $this().Tok.getAnnotationValue());
    $this().Actions.ActOnPragmaDump($this().getCurScope(), $this().Tok.getLocation(), II);
    $this().ConsumeToken();
  }


/// \brief Handle the annotation token produced for
/// #pragma weak id...
//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandlePragmaWeak">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 386,
   FQN="clang::Parser::HandlePragmaWeak", NM="_ZN5clang6Parser16HandlePragmaWeakEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser16HandlePragmaWeakEv")
  //</editor-fold>
  protected /*private*/ void HandlePragmaWeak() {
    assert ($this().Tok.is(tok.TokenKind.annot_pragma_weak));
    SourceLocation PragmaLoc = $this().ConsumeToken();
    $this().Actions.ActOnPragmaWeakID($this().Tok.getIdentifierInfo(), new SourceLocation(PragmaLoc), 
        $this().Tok.getLocation());
    $this().ConsumeToken(); // The weak name.
  }


/// \brief Handle the annotation token produced for
/// #pragma weak id = id...
//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandlePragmaWeakAlias">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 394,
   FQN="clang::Parser::HandlePragmaWeakAlias", NM="_ZN5clang6Parser21HandlePragmaWeakAliasEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser21HandlePragmaWeakAliasEv")
  //</editor-fold>
  protected /*private*/ void HandlePragmaWeakAlias() {
    assert ($this().Tok.is(tok.TokenKind.annot_pragma_weakalias));
    SourceLocation PragmaLoc = $this().ConsumeToken();
    IdentifierInfo /*P*/ WeakName = $this().Tok.getIdentifierInfo();
    SourceLocation WeakNameLoc = $this().Tok.getLocation();
    $this().ConsumeToken();
    IdentifierInfo /*P*/ AliasName = $this().Tok.getIdentifierInfo();
    SourceLocation AliasNameLoc = $this().Tok.getLocation();
    $this().ConsumeToken();
    $this().Actions.ActOnPragmaWeakAlias(WeakName, AliasName, new SourceLocation(PragmaLoc), 
        new SourceLocation(WeakNameLoc), new SourceLocation(AliasNameLoc));
  }


/// \brief Handle the annotation token produced for
/// #pragma redefine_extname...
//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandlePragmaRedefineExtname">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 408,
   FQN="clang::Parser::HandlePragmaRedefineExtname", NM="_ZN5clang6Parser27HandlePragmaRedefineExtnameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser27HandlePragmaRedefineExtnameEv")
  //</editor-fold>
  protected /*private*/ void HandlePragmaRedefineExtname() {
    assert ($this().Tok.is(tok.TokenKind.annot_pragma_redefine_extname));
    SourceLocation RedefLoc = $this().ConsumeToken();
    IdentifierInfo /*P*/ RedefName = $this().Tok.getIdentifierInfo();
    SourceLocation RedefNameLoc = $this().Tok.getLocation();
    $this().ConsumeToken();
    IdentifierInfo /*P*/ AliasName = $this().Tok.getIdentifierInfo();
    SourceLocation AliasNameLoc = $this().Tok.getLocation();
    $this().ConsumeToken();
    $this().Actions.ActOnPragmaRedefineExtname(RedefName, AliasName, new SourceLocation(RedefLoc), 
        new SourceLocation(RedefNameLoc), new SourceLocation(AliasNameLoc));
  }


/// \brief Handle the annotation token produced for
/// #pragma STDC FP_CONTRACT...
//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandlePragmaFPContract">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 421,
   FQN="clang::Parser::HandlePragmaFPContract", NM="_ZN5clang6Parser22HandlePragmaFPContractEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser22HandlePragmaFPContractEv")
  //</editor-fold>
  protected /*private*/ void HandlePragmaFPContract() {
    assert ($this().Tok.is(tok.TokenKind.annot_pragma_fp_contract));
    tok.OnOffSwitch OOS = /*static_cast*/tok.OnOffSwitch.valueOf(reinterpret_cast_uint($this().Tok.getAnnotationValue()));
    $this().Actions.ActOnPragmaFPContract(OOS);
    $this().ConsumeToken(); // The annotation token.
  }


/// \brief Handle the annotation token produced for
/// #pragma OPENCL EXTENSION...
//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandlePragmaOpenCLExtension">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 461,
   FQN="clang::Parser::HandlePragmaOpenCLExtension", NM="_ZN5clang6Parser27HandlePragmaOpenCLExtensionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser27HandlePragmaOpenCLExtensionEv")
  //</editor-fold>
  protected /*private*/ void HandlePragmaOpenCLExtension() {
    assert ($this().Tok.is(tok.TokenKind.annot_pragma_opencl_extension));
    PointerBoolPair<IdentifierInfo /*P*/ > data = PointerBoolPair.<IdentifierInfo /*P*/ >getFromOpaqueValue_voidPtr($this().Tok.getAnnotationValue());
    /*uint*/int state = (data.getInt() ? 1 : 0);
    IdentifierInfo /*P*/ ename = data.getPointer();
    SourceLocation NameLoc = $this().Tok.getLocation();
    $this().ConsumeToken(); // The annotation token.
    
    final OpenCLOptions /*&*/ f = $this().Actions.getOpenCLOptions();
    /*uint*/int CLVer = $this().getLangOpts().OpenCLVersion;
    final /*const*/ OpenCLOptions /*&*/ Supp = $this().getTargetInfo().getSupportedOpenCLOpts$Const();
    // OpenCL 1.1 9.1: "The all variant sets the behavior for all extensions,
    // overriding all previously issued extension directives, but only if the
    // behavior is set to disable."
    if (state == 0 && ename.isStr(/*KEEP_STR*/"all")) {
      // OPENCLEXT_INTERNAL
      
      // OpenCL 1.0.
      if (Supp.is_cl_khr_3d_image_writes_supported_extension(CLVer)) {
        f.cl_khr_3d_image_writes = false;
      }
      // fprounding mode is special since it is not mentioned beyond 1.0
      if (Supp.is_cl_khr_select_fprounding_mode_supported_extension(CLVer)) {
        f.cl_khr_select_fprounding_mode = false;
      }
      if (Supp.is_cl_khr_byte_addressable_store_supported_extension(CLVer)) {
        f.cl_khr_byte_addressable_store = false;
      }
      if (Supp.is_cl_khr_fp16_supported_extension(CLVer)) {
        f.cl_khr_fp16 = false;
      }
      if (Supp.is_cl_khr_fp64_supported_extension(CLVer)) {
        f.cl_khr_fp64 = false;
      }
      if (Supp.is_cl_khr_global_int32_base_atomics_supported_extension(CLVer)) {
        f.cl_khr_global_int32_base_atomics = false;
      }
      if (Supp.is_cl_khr_global_int32_extended_atomics_supported_extension(CLVer)) {
        f.cl_khr_global_int32_extended_atomics = false;
      }
      if (Supp.is_cl_khr_local_int32_base_atomics_supported_extension(CLVer)) {
        f.cl_khr_local_int32_base_atomics = false;
      }
      if (Supp.is_cl_khr_local_int32_extended_atomics_supported_extension(CLVer)) {
        f.cl_khr_local_int32_extended_atomics = false;
      }
      if (Supp.is_cl_khr_int64_base_atomics_supported_extension(CLVer)) {
        f.cl_khr_int64_base_atomics = false;
      }
      if (Supp.is_cl_khr_int64_extended_atomics_supported_extension(CLVer)) {
        f.cl_khr_int64_extended_atomics = false;
      }
      if (Supp.is_cl_khr_gl_sharing_supported_extension(CLVer)) {
        f.cl_khr_gl_sharing = false;
      }
      if (Supp.is_cl_khr_icd_supported_extension(CLVer)) {
        f.cl_khr_icd = false;
      }
      
      // OpenCL 1.1.
      if (Supp.is_cl_khr_gl_event_supported_extension(CLVer)) {
        f.cl_khr_gl_event = false;
      }
      if (Supp.is_cl_khr_d3d10_sharing_supported_extension(CLVer)) {
        f.cl_khr_d3d10_sharing = false;
      }
      
      // OpenCL 1.2.
      if (Supp.is_cl_khr_context_abort_supported_extension(CLVer)) {
        f.cl_khr_context_abort = false;
      }
      if (Supp.is_cl_khr_d3d11_sharing_supported_extension(CLVer)) {
        f.cl_khr_d3d11_sharing = false;
      }
      if (Supp.is_cl_khr_depth_images_supported_extension(CLVer)) {
        f.cl_khr_depth_images = false;
      }
      if (Supp.is_cl_khr_dx9_media_sharing_supported_extension(CLVer)) {
        f.cl_khr_dx9_media_sharing = false;
      }
      if (Supp.is_cl_khr_image2d_from_buffer_supported_extension(CLVer)) {
        f.cl_khr_image2d_from_buffer = false;
      }
      if (Supp.is_cl_khr_initialize_memory_supported_extension(CLVer)) {
        f.cl_khr_initialize_memory = false;
      }
      if (Supp.is_cl_khr_gl_depth_images_supported_extension(CLVer)) {
        f.cl_khr_gl_depth_images = false;
      }
      if (Supp.is_cl_khr_gl_msaa_sharing_supported_extension(CLVer)) {
        f.cl_khr_gl_msaa_sharing = false;
      }
      if (Supp.is_cl_khr_spir_supported_extension(CLVer)) {
        f.cl_khr_spir = false;
      }
      
      // OpenCL 2.0.
      if (Supp.is_cl_khr_egl_event_supported_extension(CLVer)) {
        f.cl_khr_egl_event = false;
      }
      if (Supp.is_cl_khr_egl_image_supported_extension(CLVer)) {
        f.cl_khr_egl_image = false;
      }
      if (Supp.is_cl_khr_srgb_image_writes_supported_extension(CLVer)) {
        f.cl_khr_srgb_image_writes = false;
      }
      if (Supp.is_cl_khr_subgroups_supported_extension(CLVer)) {
        f.cl_khr_subgroups = false;
      }
      if (Supp.is_cl_khr_terminate_context_supported_extension(CLVer)) {
        f.cl_khr_terminate_context = false;
      }
      
      // Clang Extensions.
      if (Supp.is_cl_clang_storage_class_specifiers_supported_extension(CLVer)) {
        f.cl_clang_storage_class_specifiers = false;
      }
    } else // OPENCLEXT_INTERNAL
    
    // OpenCL 1.0.
    if (ename.isStr(/*KEEP_STR*/"cl_khr_3d_image_writes")) {
      if (Supp.is_cl_khr_3d_image_writes_supported_extension(CLVer)) {
        f.cl_khr_3d_image_writes = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_3d_image_writes_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else // fprounding mode is special since it is not mentioned beyond 1.0
    if (ename.isStr(/*KEEP_STR*/"cl_khr_select_fprounding_mode")) {
      if (Supp.is_cl_khr_select_fprounding_mode_supported_extension(CLVer)) {
        f.cl_khr_select_fprounding_mode = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_select_fprounding_mode_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_byte_addressable_store")) {
      if (Supp.is_cl_khr_byte_addressable_store_supported_extension(CLVer)) {
        f.cl_khr_byte_addressable_store = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_byte_addressable_store_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_fp16")) {
      if (Supp.is_cl_khr_fp16_supported_extension(CLVer)) {
        f.cl_khr_fp16 = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_fp16_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_fp64")) {
      if (Supp.is_cl_khr_fp64_supported_extension(CLVer)) {
        f.cl_khr_fp64 = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_fp64_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_global_int32_base_atomics")) {
      if (Supp.is_cl_khr_global_int32_base_atomics_supported_extension(CLVer)) {
        f.cl_khr_global_int32_base_atomics = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_global_int32_base_atomics_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_global_int32_extended_atomics")) {
      if (Supp.is_cl_khr_global_int32_extended_atomics_supported_extension(CLVer)) {
        f.cl_khr_global_int32_extended_atomics = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_global_int32_extended_atomics_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_local_int32_base_atomics")) {
      if (Supp.is_cl_khr_local_int32_base_atomics_supported_extension(CLVer)) {
        f.cl_khr_local_int32_base_atomics = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_local_int32_base_atomics_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_local_int32_extended_atomics")) {
      if (Supp.is_cl_khr_local_int32_extended_atomics_supported_extension(CLVer)) {
        f.cl_khr_local_int32_extended_atomics = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_local_int32_extended_atomics_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_int64_base_atomics")) {
      if (Supp.is_cl_khr_int64_base_atomics_supported_extension(CLVer)) {
        f.cl_khr_int64_base_atomics = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_int64_base_atomics_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_int64_extended_atomics")) {
      if (Supp.is_cl_khr_int64_extended_atomics_supported_extension(CLVer)) {
        f.cl_khr_int64_extended_atomics = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_int64_extended_atomics_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_gl_sharing")) {
      if (Supp.is_cl_khr_gl_sharing_supported_extension(CLVer)) {
        f.cl_khr_gl_sharing = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_gl_sharing_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_icd")) {
      if (Supp.is_cl_khr_icd_supported_extension(CLVer)) {
        f.cl_khr_icd = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_icd_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else 
    // OpenCL 1.1.
    if (ename.isStr(/*KEEP_STR*/"cl_khr_gl_event")) {
      if (Supp.is_cl_khr_gl_event_supported_extension(CLVer)) {
        f.cl_khr_gl_event = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_gl_event_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_d3d10_sharing")) {
      if (Supp.is_cl_khr_d3d10_sharing_supported_extension(CLVer)) {
        f.cl_khr_d3d10_sharing = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_d3d10_sharing_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else 
    // OpenCL 1.2.
    if (ename.isStr(/*KEEP_STR*/"cl_khr_context_abort")) {
      if (Supp.is_cl_khr_context_abort_supported_extension(CLVer)) {
        f.cl_khr_context_abort = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_context_abort_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_d3d11_sharing")) {
      if (Supp.is_cl_khr_d3d11_sharing_supported_extension(CLVer)) {
        f.cl_khr_d3d11_sharing = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_d3d11_sharing_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_depth_images")) {
      if (Supp.is_cl_khr_depth_images_supported_extension(CLVer)) {
        f.cl_khr_depth_images = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_depth_images_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_dx9_media_sharing")) {
      if (Supp.is_cl_khr_dx9_media_sharing_supported_extension(CLVer)) {
        f.cl_khr_dx9_media_sharing = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_dx9_media_sharing_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_image2d_from_buffer")) {
      if (Supp.is_cl_khr_image2d_from_buffer_supported_extension(CLVer)) {
        f.cl_khr_image2d_from_buffer = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_image2d_from_buffer_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_initialize_memory")) {
      if (Supp.is_cl_khr_initialize_memory_supported_extension(CLVer)) {
        f.cl_khr_initialize_memory = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_initialize_memory_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_gl_depth_images")) {
      if (Supp.is_cl_khr_gl_depth_images_supported_extension(CLVer)) {
        f.cl_khr_gl_depth_images = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_gl_depth_images_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_gl_msaa_sharing")) {
      if (Supp.is_cl_khr_gl_msaa_sharing_supported_extension(CLVer)) {
        f.cl_khr_gl_msaa_sharing = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_gl_msaa_sharing_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_spir")) {
      if (Supp.is_cl_khr_spir_supported_extension(CLVer)) {
        f.cl_khr_spir = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_spir_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else 
    // OpenCL 2.0.
    if (ename.isStr(/*KEEP_STR*/"cl_khr_egl_event")) {
      if (Supp.is_cl_khr_egl_event_supported_extension(CLVer)) {
        f.cl_khr_egl_event = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_egl_event_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_egl_image")) {
      if (Supp.is_cl_khr_egl_image_supported_extension(CLVer)) {
        f.cl_khr_egl_image = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_egl_image_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_srgb_image_writes")) {
      if (Supp.is_cl_khr_srgb_image_writes_supported_extension(CLVer)) {
        f.cl_khr_srgb_image_writes = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_srgb_image_writes_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_subgroups")) {
      if (Supp.is_cl_khr_subgroups_supported_extension(CLVer)) {
        f.cl_khr_subgroups = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_subgroups_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (ename.isStr(/*KEEP_STR*/"cl_khr_terminate_context")) {
      if (Supp.is_cl_khr_terminate_context_supported_extension(CLVer)) {
        f.cl_khr_terminate_context = $uint2uint_1bit(state);
      } else if (Supp.is_cl_khr_terminate_context_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else 
    // Clang Extensions.
    if (ename.isStr(/*KEEP_STR*/"cl_clang_storage_class_specifiers")) {
      if (Supp.is_cl_clang_storage_class_specifiers_supported_extension(CLVer)) {
        f.cl_clang_storage_class_specifiers = $uint2uint_1bit(state);
      } else if (Supp.is_cl_clang_storage_class_specifiers_supported_core(CLVer)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_extension_is_core)), ename));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unsupported_extension)), ename));
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().PP.Diag(/*NO_COPY*/NameLoc, diag.warn_pragma_unknown_extension)), ename));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }


/// \brief Handle the annotation token produced for
/// #pragma clang __debug captured
//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandlePragmaCaptured">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 430,
   FQN="clang::Parser::HandlePragmaCaptured", NM="_ZN5clang6Parser20HandlePragmaCapturedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser20HandlePragmaCapturedEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > HandlePragmaCaptured() {
    ParseScope CapturedRegionScope = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.annot_pragma_captured));
      $this().ConsumeToken();
      if ($this().Tok.isNot(tok.TokenKind.l_brace)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().PP.Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_brace));
          return StmtError();
        } finally {
          $c$.$destroy();
        }
      }
      
      SourceLocation Loc = $this().Tok.getLocation();
      
      CapturedRegionScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.FnScope | Scope.ScopeFlags.DeclScope);
      $this().Actions.ActOnCapturedRegionStart(new SourceLocation(Loc), $this().getCurScope(), CapturedRegionKind.CR_Default, 
          /*NumParams=*/ 1);
      
      ActionResultTTrue<Stmt /*P*/ > R = $this().ParseCompoundStatement();
      CapturedRegionScope.Exit();
      if (R.isInvalid()) {
        $this().Actions.ActOnCapturedRegionError();
        return StmtError();
      }
      
      return $this().Actions.ActOnCapturedRegionEnd(R.get());
    } finally {
      if (CapturedRegionScope != null) { CapturedRegionScope.$destroy(); }
    }
  }


/// \brief Handle the annotation token produced for
/// #pragma clang loop and #pragma unroll.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandlePragmaLoopHint">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 793,
   FQN="clang::Parser::HandlePragmaLoopHint", NM="_ZN5clang6Parser20HandlePragmaLoopHintERNS_8LoopHintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN5clang6Parser20HandlePragmaLoopHintERNS_8LoopHintE")
  //</editor-fold>
  protected /*private*/ boolean HandlePragmaLoopHint(final LoopHint /*&*/ Hint) {
    assert ($this().Tok.is(tok.TokenKind.annot_pragma_loop_hint));
    PragmaLoopHintInfo /*P*/ Info = ((/*static_cast*/PragmaLoopHintInfo /*P*/ )($this().Tok.getAnnotationValue()));
    
    IdentifierInfo /*P*/ PragmaNameInfo = Info.PragmaName.getIdentifierInfo();
    Hint.PragmaNameLoc = IdentifierLoc.create($this().Actions.Context, Info.PragmaName.getLocation(), PragmaNameInfo);
    
    // It is possible that the loop hint has no option identifier, such as
    // #pragma unroll(4).
    IdentifierInfo /*P*/ OptionInfo = Info.Option.is(tok.TokenKind.identifier) ? Info.Option.getIdentifierInfo() : null;
    Hint.OptionLoc = IdentifierLoc.create($this().Actions.Context, Info.Option.getLocation(), OptionInfo);
    
    ArrayRefToken Toks = new ArrayRefToken(Info.Toks);
    
    // Return a valid hint if pragma unroll or nounroll were specified
    // without an argument.
    boolean PragmaUnroll = $eq_StringRef(PragmaNameInfo.getName(), /*STRINGREF_STR*/"unroll");
    boolean PragmaNoUnroll = $eq_StringRef(PragmaNameInfo.getName(), /*STRINGREF_STR*/"nounroll");
    if (Toks.empty() && (PragmaUnroll || PragmaNoUnroll)) {
      $this().ConsumeToken(); // The annotation token.
      Hint.Range.$assignMove(new SourceRange(Info.PragmaName.getLocation()));
      return true;
    }
    
    // The constant expression is always followed by an eof token, which increases
    // the TokSize by 1.
    assert (!Toks.empty()) : "PragmaLoopHintInfo::Toks must contain at least one token.";
    
    // If no option is specified the argument is assumed to be a constant expr.
    boolean OptionUnroll = false;
    boolean OptionDistribute = false;
    boolean StateOption = false;
    if ((OptionInfo != null)) { // Pragma Unroll does not specify an option.
      OptionUnroll = OptionInfo.isStr(/*KEEP_STR*/"unroll");
      OptionDistribute = OptionInfo.isStr(/*KEEP_STR*/"distribute");
      StateOption = new StringSwitchBool(OptionInfo.getName()).
          Case(/*KEEP_STR*/"vectorize", true).
          Case(/*KEEP_STR*/"interleave", true).
          Default(false)
         || OptionUnroll || OptionDistribute;
    }
    
    boolean AssumeSafetyArg = !OptionUnroll && !OptionDistribute;
    // Verify loop hint has an argument.
    if (Toks.$at(0).is(tok.TokenKind.eof)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $this().ConsumeToken(); // The annotation token.
        $c$.clean($out$Same2Bool($out$Same2Bool($out$Same2Bool($c$.track($this().Diag(Toks.$at(0).getLocation(), diag.err_pragma_loop_missing_argument)), 
                    /*StateArgument=*/ StateOption), /*FullKeyword=*/ OptionUnroll), 
            /*AssumeSafetyKeyword=*/ AssumeSafetyArg));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Validate the argument.
    if (StateOption) {
      $this().ConsumeToken(); // The annotation token.
      SourceLocation StateLoc = Toks.$at(0).getLocation();
      IdentifierInfo /*P*/ StateInfo = Toks.$at(0).getIdentifierInfo();
      
      boolean Valid = (StateInfo != null)
         && new StringSwitchBool(StateInfo.getName()).
          Cases(/*KEEP_STR*/"enable", /*KEEP_STR*/"disable", true).
          Case(/*KEEP_STR*/"full", OptionUnroll).
          Case(/*KEEP_STR*/"assume_safety", AssumeSafetyArg).
          Default(false);
      if (!Valid) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out$Same2Bool($out$Same2Bool($c$.track($this().Diag(Toks.$at(0).getLocation(), diag.err_pragma_invalid_keyword)), 
                  /*FullKeyword=*/ OptionUnroll), 
              /*AssumeSafetyKeyword=*/ AssumeSafetyArg));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
      if ($greater_uint(Toks.size(), 2)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag($this().Tok.getLocation(), diag.warn_pragma_extra_tokens_at_eol)), 
              new StringRef(PragmaLoopHintString(new Token(Info.PragmaName), new Token(Info.Option)))));
        } finally {
          $c$.$destroy();
        }
      }
      Hint.StateLoc = IdentifierLoc.create($this().Actions.Context, new SourceLocation(StateLoc), StateInfo);
    } else {
      // Enter constant expression including eof terminator into token stream.
      $this().PP.EnterTokenStream(new ArrayRefToken(Toks), /*DisableMacroExpansion=*/ false);
      $this().ConsumeToken(); // The annotation token.
      
      ActionResultTTrue<Expr /*P*/ > R = $this().ParseConstantExpression();
      
      // Tokens following an error in an ill-formed constant expression will
      // remain in the token stream and must be removed.
      if ($this().Tok.isNot(tok.TokenKind.eof)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag($this().Tok.getLocation(), diag.warn_pragma_extra_tokens_at_eol)), 
              new StringRef(PragmaLoopHintString(new Token(Info.PragmaName), new Token(Info.Option)))));
          while ($this().Tok.isNot(tok.TokenKind.eof)) {
            $this().ConsumeAnyToken();
          }
        } finally {
          $c$.$destroy();
        }
      }
      
      $this().ConsumeToken(); // Consume the constant expression eof terminator.
      if (R.isInvalid()
         || $this().Actions.CheckLoopHintExpr(R.get(), Toks.$at(0).getLocation())) {
        return false;
      }
      
      // Argument is a constant expression with an integer type.
      Hint.ValueExpr = R.get();
    }
    
    Hint.Range.$assignMove(new SourceRange(Info.PragmaName.getLocation(), 
            Info.Toks.back().getLocation()));
    return true;
  }

} // END OF class Parser_ParsePragma
