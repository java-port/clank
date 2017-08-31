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
package org.clang.sema;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.ast.ASTContext.SectionInfo;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.sema.impl.SemaAttrStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaAttr">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaAccess ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema12UnifySectionEN4llvm9StringRefEiNS_14SourceLocationE;_ZN5clang4Sema12UnifySectionEN4llvm9StringRefEiPNS_14DeclaratorDeclE;_ZN5clang4Sema14FreeVisContextEv;_ZN5clang4Sema15ActOnPragmaPackENS_14SourceLocationENS0_19PragmaMsStackActionEN4llvm9StringRefEPNS_4ExprE;_ZN5clang4Sema16ActOnPragmaMSSegENS_14SourceLocationENS0_19PragmaMsStackActionEN4llvm9StringRefEPNS_13StringLiteralES4_;_ZN5clang4Sema17ActOnPragmaUnusedERKNS_5TokenEPNS_5ScopeENS_14SourceLocationE;_ZN5clang4Sema19ActOnPragmaMSStructENS_18PragmaMSStructKindE;_ZN5clang4Sema19ActOnPragmaOptimizeEbNS_14SourceLocationE;_ZN5clang4Sema19PopPragmaVisibilityEbNS_14SourceLocationE;_ZN5clang4Sema20ActOnPragmaMSCommentENS_14SourceLocationENS_19PragmaMSCommentKindEN4llvm9StringRefE;_ZN5clang4Sema20ActOnPragmaMSInitSegENS_14SourceLocationEPNS_13StringLiteralE;_ZN5clang4Sema20ActOnPragmaMSSectionENS_14SourceLocationEiPNS_13StringLiteralE;_ZN5clang4Sema20AddRangeBasedOptnoneEPNS_12FunctionDeclE;_ZN5clang4Sema21ActOnPragmaFPContractENS_3tok11OnOffSwitchE;_ZN5clang4Sema21ActOnPragmaMSVtorDispENS0_19PragmaMsStackActionENS_14SourceLocationENS_14MSVtorDispAttr4ModeE;_ZN5clang4Sema21ActOnPragmaVisibilityEPKNS_14IdentifierInfoENS_14SourceLocationE;_ZN5clang4Sema21AddCFAuditedAttributeEPNS_4DeclE;_ZN5clang4Sema23ActOnPragmaOptionsAlignENS0_22PragmaOptionsAlignKindENS_14SourceLocationE;_ZN5clang4Sema25ActOnPragmaDetectMismatchENS_14SourceLocationEN4llvm9StringRefES3_;_ZN5clang4Sema26AddMsStructLayoutForRecordEPNS_10RecordDeclE;_ZN5clang4Sema27PushNamespaceVisibilityAttrEPKNS_14VisibilityAttrENS_14SourceLocationE;_ZN5clang4Sema28AddPushedVisibilityAttributeEPNS_4DeclE;_ZN5clang4Sema30ActOnPragmaMSPointersToMembersENS_11LangOptions29PragmaMSPointersToMembersKindENS_14SourceLocationE;_ZN5clang4Sema31AddAlignmentAttributesForRecordEPNS_10RecordDeclE;_ZN5clang4Sema32AddOptnoneAttributeIfNoConflictsEPNS_12FunctionDeclENS_14SourceLocationE; -static-type=Sema_SemaAttr -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaAttr extends Sema_SemaAccess {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


/// ActOnPragmaOptionsAlign - Called on well formed \#pragma options align.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPragmaOptionsAlign">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 78,
 FQN="clang::Sema::ActOnPragmaOptionsAlign", NM="_ZN5clang4Sema23ActOnPragmaOptionsAlignENS0_22PragmaOptionsAlignKindENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema23ActOnPragmaOptionsAlignENS0_22PragmaOptionsAlignKindENS_14SourceLocationE")
//</editor-fold>
public final void ActOnPragmaOptionsAlign(PragmaOptionsAlignKind Kind, 
                       SourceLocation PragmaLoc) {
  /*PragmaMsStackAction*//*uint*/int Action = Sema.PragmaMsStackAction.PSK_Reset;
  /*uint*/int Alignment = 0;
  switch (Kind) {
   case POAK_Native:
   case POAK_Power:
   case POAK_Natural:
    // For all targets we support native and natural are the same.
    //
    // FIXME: This is not true on Darwin/PPC.
    Action = Sema.PragmaMsStackAction.PSK_Push_Set;
    Alignment = 0;
    break;
   case POAK_Packed:
    
    // Note that '#pragma options align=packed' is not equivalent to attribute
    // packed, it has a different precedence relative to attribute aligned.
    Action = Sema.PragmaMsStackAction.PSK_Push_Set;
    Alignment = 1;
    break;
   case POAK_Mac68k:
    // Check if the target supports this.
    if (!$this().Context.getTargetInfo().hasAlignMac68kSupport()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(PragmaLoc), diag.err_pragma_options_align_mac68k_target_unsupported)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    Action = Sema.PragmaMsStackAction.PSK_Push_Set;
    Alignment = Sema.kMac68kAlignmentSentinel;
    break;
   case POAK_Reset:
    // Reset just pops the top of the stack, or resets the current alignment to
    // default.
    Action = Sema.PragmaMsStackAction.PSK_Pop;
    if ($this().PackStack.Stack.empty()) {
      if (($this().PackStack.CurrentValue != 0)) {
        Action = Sema.PragmaMsStackAction.PSK_Reset;
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PragmaLoc), diag.warn_pragma_options_align_reset_failed)), 
              /*KEEP_STR*/"stack empty"));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
    break;
  }
  
  $this().PackStack.Act(new SourceLocation(PragmaLoc), Action, new StringRef(), Alignment);
}


/// ActOnPragmaPack - Called on well formed \#pragma pack(...).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPragmaPack">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 129,
 FQN="clang::Sema::ActOnPragmaPack", NM="_ZN5clang4Sema15ActOnPragmaPackENS_14SourceLocationENS0_19PragmaMsStackActionEN4llvm9StringRefEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema15ActOnPragmaPackENS_14SourceLocationENS0_19PragmaMsStackActionEN4llvm9StringRefEPNS_4ExprE")
//</editor-fold>
public final void ActOnPragmaPack(SourceLocation PragmaLoc, /*PragmaMsStackAction*//*uint*/int Action, 
               StringRef SlotLabel, Expr /*P*/ alignment) {
  Expr /*P*/ Alignment = ((/*static_cast*/Expr /*P*/ )(alignment));
  
  // If specified then alignment must be a "small" power of two.
  /*uint*/int AlignmentVal = 0;
  if ((Alignment != null)) {
    APSInt Val/*J*/= new APSInt();
    
    // pack(0) is like pack(), which just works out since that is what
    // we use 0 for in PackAttr.
    if (Alignment.isTypeDependent()
       || Alignment.isValueDependent()
       || !Alignment.isIntegerConstantExpr(Val, $this().Context)
       || !(Val.$eq(0) || Val.isPowerOf2())
       || $greater_ulong_ullong(Val.getZExtValue(), 16)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(PragmaLoc), diag.warn_pragma_pack_invalid_alignment)));
        return; // Ignore
      } finally {
        $c$.$destroy();
      }
    }
    
    AlignmentVal = (/*uint*/int)$ulong2uint(Val.getZExtValue());
  }
  if (Action == Sema.PragmaMsStackAction.PSK_Show) {
    // Show the current alignment, making sure to show the right value
    // for the default.
    // FIXME: This should come from the target.
    AlignmentVal = $this().PackStack.CurrentValue;
    if (AlignmentVal == 0) {
      AlignmentVal = 8;
    }
    if (AlignmentVal == Sema.kMac68kAlignmentSentinel) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PragmaLoc), diag.warn_pragma_pack_show)), /*KEEP_STR*/"mac68k"));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PragmaLoc), diag.warn_pragma_pack_show)), AlignmentVal));
      } finally {
        $c$.$destroy();
      }
    }
  }
  // MSDN, C/C++ Preprocessor Reference > Pragma Directives > pack:
  // "#pragma pack(pop, identifier, n) is undefined"
  if (((Action & Sema.PragmaMsStackAction.PSK_Pop) != 0)) {
    if ((Alignment != null) && !SlotLabel.empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(PragmaLoc), diag.warn_pragma_pack_pop_identifer_and_alignment)));
      } finally {
        $c$.$destroy();
      }
    }
    if ($this().PackStack.Stack.empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PragmaLoc), diag.warn_pragma_pop_failed)), /*KEEP_STR*/"pack"), /*KEEP_STR*/"stack empty"));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  $this().PackStack.Act(new SourceLocation(PragmaLoc), Action, new StringRef(SlotLabel), AlignmentVal);
}


/// ActOnPragmaMSStruct - Called on well formed \#pragma ms_struct [on|off].
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPragmaMSStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 175,
 FQN="clang::Sema::ActOnPragmaMSStruct", NM="_ZN5clang4Sema19ActOnPragmaMSStructENS_18PragmaMSStructKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema19ActOnPragmaMSStructENS_18PragmaMSStructKindE")
//</editor-fold>
public final void ActOnPragmaMSStruct(PragmaMSStructKind Kind) {
  $this().MSStructPragmaOn = (Kind == PragmaMSStructKind.PMSST_ON);
}


/// ActOnPragmaMSComment - Called on well formed
/// \#pragma comment(kind, "arg").
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPragmaMSComment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 179,
 FQN="clang::Sema::ActOnPragmaMSComment", NM="_ZN5clang4Sema20ActOnPragmaMSCommentENS_14SourceLocationENS_19PragmaMSCommentKindEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema20ActOnPragmaMSCommentENS_14SourceLocationENS_19PragmaMSCommentKindEN4llvm9StringRefE")
//</editor-fold>
public final void ActOnPragmaMSComment(SourceLocation CommentLoc, 
                    PragmaMSCommentKind Kind, StringRef Arg) {
  PragmaCommentDecl /*P*/ PCD = PragmaCommentDecl.Create($this().Context, $this().Context.getTranslationUnitDecl(), new SourceLocation(CommentLoc), Kind, new StringRef(Arg));
  $this().Context.getTranslationUnitDecl().addDecl(PCD);
  $this().Consumer.HandleTopLevelDecl(new DeclGroupRef(PCD));
}


/// ActOnPragmaMSPointersToMembers - called on well formed \#pragma
/// pointers_to_members(representation method[, general purpose
/// representation]).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPragmaMSPointersToMembers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 195,
 FQN="clang::Sema::ActOnPragmaMSPointersToMembers", NM="_ZN5clang4Sema30ActOnPragmaMSPointersToMembersENS_11LangOptions29PragmaMSPointersToMembersKindENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema30ActOnPragmaMSPointersToMembersENS_11LangOptions29PragmaMSPointersToMembersKindENS_14SourceLocationE")
//</editor-fold>
public final void ActOnPragmaMSPointersToMembers(LangOptions.PragmaMSPointersToMembersKind RepresentationMethod, 
                              SourceLocation PragmaLoc) {
  $this().MSPointerToMemberRepresentationMethod = RepresentationMethod;
  $this().ImplicitMSInheritanceAttrLoc.$assign(PragmaLoc);
}


/// \brief Called on well formed \#pragma vtordisp().
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPragmaMSVtorDisp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 202,
 FQN="clang::Sema::ActOnPragmaMSVtorDisp", NM="_ZN5clang4Sema21ActOnPragmaMSVtorDispENS0_19PragmaMsStackActionENS_14SourceLocationENS_14MSVtorDispAttr4ModeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema21ActOnPragmaMSVtorDispENS0_19PragmaMsStackActionENS_14SourceLocationENS_14MSVtorDispAttr4ModeE")
//</editor-fold>
public final void ActOnPragmaMSVtorDisp(/*PragmaMsStackAction*//*uint*/int Action, 
                     SourceLocation PragmaLoc, 
                     MSVtorDispAttr.Mode Mode) {
  if (((Action & PragmaMsStackAction.PSK_Pop) != 0) && $this().VtorDispStack.Stack.empty()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PragmaLoc), diag.warn_pragma_pop_failed)), /*KEEP_STR*/"vtordisp"), 
          /*KEEP_STR*/"stack empty"));
    } finally {
      $c$.$destroy();
    }
  }
  $this().VtorDispStack.Act(new SourceLocation(PragmaLoc), Action, new StringRef(), Mode);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::UnifySection">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 247,
 FQN="clang::Sema::UnifySection", NM="_ZN5clang4Sema12UnifySectionEN4llvm9StringRefEiPNS_14DeclaratorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema12UnifySectionEN4llvm9StringRefEiPNS_14DeclaratorDeclE")
//</editor-fold>
public final boolean UnifySection(StringRef SectionName, 
            int SectionFlags, 
            DeclaratorDecl /*P*/ Decl) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    StringMapIterator<SectionInfo> Section = $this().Context.SectionInfos.find(/*NO_COPY*/SectionName);
    if (Section.$eq($this().Context.SectionInfos.end())) {
      $this().Context.SectionInfos.$at(/*NO_COPY*/SectionName).$assignMove(
          new ASTContext.SectionInfo(Decl, new SourceLocation(), SectionFlags)
      );
      return false;
    }
    // A pre-declared section takes precedence w/o diagnostic.
    if (Section.$arrow().second.SectionFlags == SectionFlags
       || !((Section.$arrow().second.SectionFlags & ASTContext.PragmaSectionFlag.PSF_Implicit) != 0)) {
      return false;
    }
    DeclaratorDecl /*P*/ OtherDecl = Section.$arrow().second.Decl;
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Decl.getLocation(), diag.err_section_conflict)), 
            Decl), OtherDecl));
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(OtherDecl.getLocation(), diag.note_declared_at)), 
        OtherDecl.getName()));
    {
      SectionAttr /*P*/ A = Decl.getAttr(SectionAttr.class);
      if ((A != null)) {
        if (A.isImplicit()) {
          $c$.clean($c$.track($this().Diag(A.getLocation(), diag.note_pragma_entered_here)));
        }
      }
    }
    {
      SectionAttr /*P*/ A = OtherDecl.getAttr(SectionAttr.class);
      if ((A != null)) {
        if (A.isImplicit()) {
          $c$.clean($c$.track($this().Diag(A.getLocation(), diag.note_pragma_entered_here)));
        }
      }
    }
    return true;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::UnifySection">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 274,
 FQN="clang::Sema::UnifySection", NM="_ZN5clang4Sema12UnifySectionEN4llvm9StringRefEiNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema12UnifySectionEN4llvm9StringRefEiNS_14SourceLocationE")
//</editor-fold>
public final boolean UnifySection(StringRef SectionName, 
            int SectionFlags, 
            SourceLocation PragmaSectionLocation) {
  StringMapIterator<SectionInfo> Section = $this().Context.SectionInfos.find(/*NO_COPY*/SectionName);
  if (Section.$noteq($this().Context.SectionInfos.end())) {
    if (Section.$arrow().second.SectionFlags == SectionFlags) {
      return false;
    }
    if (!((Section.$arrow().second.SectionFlags & ASTContext.PragmaSectionFlag.PSF_Implicit) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PragmaSectionLocation), diag.err_section_conflict)), 
                /*KEEP_STR*/"this"), /*KEEP_STR*/"a prior #pragma section"));
        $c$.clean($c$.track($this().Diag(new SourceLocation(Section.$arrow().second.PragmaSectionLocation), 
            diag.note_pragma_entered_here)));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  $this().Context.SectionInfos.$at(/*NO_COPY*/SectionName).$assignMove(
      new ASTContext.SectionInfo((DeclaratorDecl /*P*/ )null, new SourceLocation(PragmaSectionLocation), SectionFlags)
  );
  return false;
}


/// \brief Called on well formed \#pragma bss_seg/data_seg/const_seg/code_seg.

/// \brief Called on well formed \#pragma bss_seg().
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPragmaMSSeg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 295,
 FQN="clang::Sema::ActOnPragmaMSSeg", NM="_ZN5clang4Sema16ActOnPragmaMSSegENS_14SourceLocationENS0_19PragmaMsStackActionEN4llvm9StringRefEPNS_13StringLiteralES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema16ActOnPragmaMSSegENS_14SourceLocationENS0_19PragmaMsStackActionEN4llvm9StringRefEPNS_13StringLiteralES4_")
//</editor-fold>
public final void ActOnPragmaMSSeg(SourceLocation PragmaLocation, 
                /*PragmaMsStackAction*//*uint*/int Action, 
                StringRef StackSlotLabel, 
                StringLiteral /*P*/ SegmentName, 
                StringRef PragmaName) {
  PragmaStack<StringLiteral /*P*/ > /*P*/ Stack = new StringSwitch<PragmaStack<StringLiteral /*P*/ > /*P*/ >(/*NO_COPY*/PragmaName).
      Case(/*KEEP_STR*/"data_seg", $AddrOf($this().DataSegStack)).
      Case(/*KEEP_STR*/"bss_seg", $AddrOf($this().BSSSegStack)).
      Case(/*KEEP_STR*/"const_seg", $AddrOf($this().ConstSegStack)).
      Case(/*KEEP_STR*/"code_seg", $AddrOf($this().CodeSegStack)).$T1();
  if (((Action & PragmaMsStackAction.PSK_Pop) != 0) && Stack.Stack.empty()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PragmaLocation), diag.warn_pragma_pop_failed)), PragmaName), 
          /*KEEP_STR*/"stack empty"));
    } finally {
      $c$.$destroy();
    }
  }
  if ((SegmentName != null)
     && !$this().checkSectionName(SegmentName.getLocStart(), SegmentName.getString())) {
    return;
  }
  Stack.Act(new SourceLocation(PragmaLocation), Action, new StringRef(StackSlotLabel), SegmentName);
}


/// \brief Called on well formed \#pragma section().

/// \brief Called on well formed \#pragma bss_seg().
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPragmaMSSection">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 316,
 FQN="clang::Sema::ActOnPragmaMSSection", NM="_ZN5clang4Sema20ActOnPragmaMSSectionENS_14SourceLocationEiPNS_13StringLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema20ActOnPragmaMSSectionENS_14SourceLocationEiPNS_13StringLiteralE")
//</editor-fold>
public final void ActOnPragmaMSSection(SourceLocation PragmaLocation, 
                    int SectionFlags, StringLiteral /*P*/ SegmentName) {
  $this().UnifySection(SegmentName.getString(), SectionFlags, new SourceLocation(PragmaLocation));
}


/// \brief Called on well-formed \#pragma init_seg().
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPragmaMSInitSeg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 321,
 FQN="clang::Sema::ActOnPragmaMSInitSeg", NM="_ZN5clang4Sema20ActOnPragmaMSInitSegENS_14SourceLocationEPNS_13StringLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema20ActOnPragmaMSInitSegENS_14SourceLocationEPNS_13StringLiteralE")
//</editor-fold>
public final void ActOnPragmaMSInitSeg(SourceLocation PragmaLocation, 
                    StringLiteral /*P*/ SegmentName) {
  // There's no stack to maintain, so we just have a current section.  When we
  // see the default section, reset our current section back to null so we stop
  // tacking on unnecessary attributes.
  $this().CurInitSeg = $eq_StringRef(SegmentName.getString(), /*STRINGREF_STR*/".CRT$XCU") ? null : SegmentName;
  $this().CurInitSegLoc.$assign(PragmaLocation);
}


/// ActOnPragmaDetectMismatch - Call on well-formed \#pragma detect_mismatch
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPragmaDetectMismatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 187,
 FQN="clang::Sema::ActOnPragmaDetectMismatch", NM="_ZN5clang4Sema25ActOnPragmaDetectMismatchENS_14SourceLocationEN4llvm9StringRefES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema25ActOnPragmaDetectMismatchENS_14SourceLocationEN4llvm9StringRefES3_")
//</editor-fold>
public final void ActOnPragmaDetectMismatch(SourceLocation Loc, StringRef Name, 
                         StringRef Value) {
  PragmaDetectMismatchDecl /*P*/ PDMD = PragmaDetectMismatchDecl.Create($this().Context, $this().Context.getTranslationUnitDecl(), new SourceLocation(Loc), new StringRef(Name), new StringRef(Value));
  $this().Context.getTranslationUnitDecl().addDecl(PDMD);
  $this().Consumer.HandleTopLevelDecl(new DeclGroupRef(PDMD));
}


/// ActOnPragmaUnused - Called on well-formed '\#pragma unused'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPragmaUnused">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 330,
 FQN="clang::Sema::ActOnPragmaUnused", NM="_ZN5clang4Sema17ActOnPragmaUnusedERKNS_5TokenEPNS_5ScopeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema17ActOnPragmaUnusedERKNS_5TokenEPNS_5ScopeENS_14SourceLocationE")
//</editor-fold>
public final void ActOnPragmaUnused(final /*const*/ Token /*&*/ IdTok, Scope /*P*/ curScope, 
                 SourceLocation PragmaLoc) {
  LookupResult Lookup = null;
  try {
    
    IdentifierInfo /*P*/ Name = IdTok.getIdentifierInfo();
    Lookup/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(Name), IdTok.getLocation(), LookupNameKind.LookupOrdinaryName);
    $this().LookupParsedName(Lookup, curScope, (CXXScopeSpec /*P*/ )null, true);
    if (Lookup.empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PragmaLoc), diag.warn_pragma_unused_undeclared_var)), 
                Name), new SourceRange(IdTok.getLocation())));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    VarDecl /*P*/ VD = Lookup.<VarDecl>getAsSingle(VarDecl.class);
    if (!(VD != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PragmaLoc), diag.warn_pragma_unused_expected_var_arg)), 
                Name), new SourceRange(IdTok.getLocation())));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Warn if this was used before being marked unused.
    if (VD.isUsed()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PragmaLoc), diag.warn_used_but_marked_unused)), Name));
      } finally {
        $c$.$destroy();
      }
    }
    
    VD.addAttr(UnusedAttr.CreateImplicit($this().Context, UnusedAttr.Spelling.GNU_unused, 
            new SourceRange(IdTok.getLocation())));
  } finally {
    if (Lookup != null) { Lookup.$destroy(); }
  }
}


/// ActOnPragmaVisibility - Called on well formed \#pragma GCC visibility... .
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPragmaVisibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 435,
 FQN="clang::Sema::ActOnPragmaVisibility", NM="_ZN5clang4Sema21ActOnPragmaVisibilityEPKNS_14IdentifierInfoENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema21ActOnPragmaVisibilityEPKNS_14IdentifierInfoENS_14SourceLocationE")
//</editor-fold>
public final void ActOnPragmaVisibility(/*const*/ IdentifierInfo /*P*/ VisType, 
                     SourceLocation PragmaLoc) {
  if ((VisType != null)) {
    // Compute visibility to use.
    type$ref<VisibilityAttr.VisibilityType> T = create_type$ref();
    if (!VisibilityAttr.ConvertStrToVisibilityType(VisType.getName(), T)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PragmaLoc), diag.warn_attribute_unknown_visibility)), VisType));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    PushPragmaVisibility(/*Deref*/$this(), T.$deref().getValue(), new SourceLocation(PragmaLoc));
  } else {
    $this().PopPragmaVisibility(false, new SourceLocation(PragmaLoc));
  }
}


/// ActOnPragmaFPContract - Called on well formed
/// \#pragma {STDC,OPENCL} FP_CONTRACT
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPragmaFPContract">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 450,
 FQN="clang::Sema::ActOnPragmaFPContract", NM="_ZN5clang4Sema21ActOnPragmaFPContractENS_3tok11OnOffSwitchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema21ActOnPragmaFPContractENS_3tok11OnOffSwitchE")
//</editor-fold>
public final void ActOnPragmaFPContract(tok.OnOffSwitch OOS) {
  switch (OOS) {
   case OOS_ON:
    $this().FPFeatures.fp_contract = true;
    break;
   case OOS_OFF:
    $this().FPFeatures.fp_contract = false;
    break;
   case OOS_DEFAULT:
    $this().FPFeatures.fp_contract = $this().getLangOpts().DefaultFPContract;
    break;
  }
}


/// AddAlignmentAttributesForRecord - Adds any needed alignment attributes to
/// a the record decl, to handle '\#pragma pack' and '\#pragma options align'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddAlignmentAttributesForRecord">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 51,
 FQN="clang::Sema::AddAlignmentAttributesForRecord", NM="_ZN5clang4Sema31AddAlignmentAttributesForRecordEPNS_10RecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema31AddAlignmentAttributesForRecordEPNS_10RecordDeclE")
//</editor-fold>
public final void AddAlignmentAttributesForRecord(RecordDecl /*P*/ RD) {
  // If there is no pack value, we don't need any attributes.
  if (!($this().PackStack.CurrentValue != 0)) {
    return;
  }
  {
    
    // Otherwise, check to see if we need a max field alignment attribute.
    /*uint*/int Alignment = $this().PackStack.CurrentValue;
    if ((Alignment != 0)) {
      if (Alignment == Sema.kMac68kAlignmentSentinel) {
        RD.addAttr(AlignMac68kAttr.CreateImplicit($this().Context));
      } else {
        RD.addAttr(MaxFieldAlignmentAttr.CreateImplicit($this().Context, 
                Alignment * 8));
      }
    }
  }
}


/// AddMsStructLayoutForRecord - Adds ms_struct layout attribute to record.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddMsStructLayoutForRecord">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 66,
 FQN="clang::Sema::AddMsStructLayoutForRecord", NM="_ZN5clang4Sema26AddMsStructLayoutForRecordEPNS_10RecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema26AddMsStructLayoutForRecordEPNS_10RecordDeclE")
//</editor-fold>
public final void AddMsStructLayoutForRecord(RecordDecl /*P*/ RD) {
  if ($this().MSStructPragmaOn) {
    RD.addAttr(MSStructAttr.CreateImplicit($this().Context));
  }
  
  // FIXME: We should merge AddAlignmentAttributesForRecord with
  // AddMsStructLayoutForRecord into AddPragmaAttributesForRecord, which takes
  // all active pragmas and applies them as attributes to class definitions.
  if ($this().VtorDispStack.CurrentValue.getValue() != $this().getLangOpts().VtorDispMode) {
    RD.addAttr(MSVtorDispAttr.CreateImplicit($this().Context, $this().VtorDispStack.CurrentValue.getValue()));
  }
}


/// PushNamespaceVisibilityAttr - Note that we've entered a
/// namespace with a visibility attribute.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PushNamespaceVisibilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 464,
 FQN="clang::Sema::PushNamespaceVisibilityAttr", NM="_ZN5clang4Sema27PushNamespaceVisibilityAttrEPKNS_14VisibilityAttrENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema27PushNamespaceVisibilityAttrEPKNS_14VisibilityAttrENS_14SourceLocationE")
//</editor-fold>
public final void PushNamespaceVisibilityAttr(/*const*/ VisibilityAttr /*P*/ Attr, 
                           SourceLocation Loc) {
  // Visibility calculations will consider the namespace's visibility.
  // Here we just want to note that we're in a visibility context
  // which overrides any enclosing #pragma context, but doesn't itself
  // contribute visibility.
  PushPragmaVisibility(/*Deref*/$this(), NoVisibility, new SourceLocation(Loc));
}


/// AddPushedVisibilityAttribute - If '\#pragma GCC visibility' was used,
/// add an appropriate visibility attribute.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddPushedVisibilityAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 401,
 FQN="clang::Sema::AddPushedVisibilityAttribute", NM="_ZN5clang4Sema28AddPushedVisibilityAttributeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema28AddPushedVisibilityAttributeEPNS_4DeclE")
//</editor-fold>
public final void AddPushedVisibilityAttribute(Decl /*P*/ D) {
  if (!($this().VisContext != null)) {
    return;
  }
  
  NamedDecl /*P*/ ND = dyn_cast_NamedDecl(D);
  if ((ND != null) && ND.getExplicitVisibility(NamedDecl.ExplicitVisibilityKind.VisibilityForValue).$bool()) {
    return;
  }
  
  std.vector<std.pairUIntType<SourceLocation>> /*P*/ Stack = ((/*static_cast*/std.vector<std.pairUIntType<SourceLocation>> /*P*/)($this().VisContext));
  /*uint*/int rawType = Stack.back().first;
  if (rawType == NoVisibility) {
    return;
  }
  
  VisibilityAttr.VisibilityType type = VisibilityAttr.VisibilityType.valueOf(rawType);
  SourceLocation loc = new SourceLocation(Stack.back().second);
  
  D.addAttr(VisibilityAttr.CreateImplicit($this().Context, type, new SourceRange(/*NO_COPY*/loc)));
}


/// PopPragmaVisibility - Pop the top element of the visibility stack; used
/// for '\#pragma GCC visibility' and visibility attributes on namespaces.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PopPragmaVisibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 473,
 FQN="clang::Sema::PopPragmaVisibility", NM="_ZN5clang4Sema19PopPragmaVisibilityEbNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema19PopPragmaVisibilityEbNS_14SourceLocationE")
//</editor-fold>
public final void PopPragmaVisibility(boolean IsNamespaceEnd, SourceLocation EndLoc) {
  if (!($this().VisContext != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(EndLoc), diag.err_pragma_pop_visibility_mismatch)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Pop visibility from stack
  std.vector<std.pairUIntType<SourceLocation>> /*P*/ Stack = ((/*static_cast*/std.vector<std.pairUIntType<SourceLocation>> /*P*/)($this().VisContext));
  
  /*const*/std.pairUIntType<SourceLocation> /*P*/ Back = $AddrOf(Stack.back());
  boolean StartsWithPragma = Back.first != NoVisibility;
  if (StartsWithPragma && IsNamespaceEnd) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Back.second), diag.err_pragma_push_visibility_mismatch)));
      $c$.clean($c$.track($this().Diag(new SourceLocation(EndLoc), diag.note_surrounding_namespace_ends_here)));
      
      // For better error recovery, eat all pushes inside the namespace.
      do {
        Stack.pop_back();
        Back = $AddrOf(Stack.back());
        StartsWithPragma = Back.first != NoVisibility;
      } while (StartsWithPragma);
    } finally {
      $c$.$destroy();
    }
  } else if (!StartsWithPragma && !IsNamespaceEnd) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(EndLoc), diag.err_pragma_pop_visibility_mismatch)));
      $c$.clean($c$.track($this().Diag(new SourceLocation(Back.second), diag.note_surrounding_namespace_starts_here)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  Stack.pop_back();
  // To simplify the implementation, never keep around an empty stack.
  if (Stack.empty()) {
    $this().FreeVisContext();
  }
}


/// FreeVisContext - Deallocate and null out VisContext.

/// FreeVisContext - Deallocate and null out VisContext.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FreeVisContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 421,
 FQN="clang::Sema::FreeVisContext", NM="_ZN5clang4Sema14FreeVisContextEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema14FreeVisContextEv")
//</editor-fold>
public final void FreeVisContext() {
  if (((/*static_cast*/std.vector<std.pairUIntType<SourceLocation>> /*P*/)($this().VisContext)) != null) { ((/*static_cast*/std.vector<std.pairUIntType<SourceLocation>> /*P*/)($this().VisContext)).$destroy();};
  $this().VisContext = null;
}


/// AddCFAuditedAttribute - Check whether we're currently within
/// '\#pragma clang arc_cf_code_audited' and, if so, consider adding
/// the appropriate attribute.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddCFAuditedAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 358,
 FQN="clang::Sema::AddCFAuditedAttribute", NM="_ZN5clang4Sema21AddCFAuditedAttributeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema21AddCFAuditedAttributeEPNS_4DeclE")
//</editor-fold>
public final void AddCFAuditedAttribute(Decl /*P*/ D) {
  SourceLocation Loc = $this().PP.getPragmaARCCFCodeAuditedLoc();
  if (!Loc.isValid()) {
    return;
  }
  
  // Don't add a redundant or conflicting attribute.
  if (D.hasAttr(CFAuditedTransferAttr.class)
     || D.hasAttr(CFUnknownTransferAttr.class)) {
    return;
  }
  
  D.addAttr(CFAuditedTransferAttr.CreateImplicit($this().Context, new SourceRange(/*NO_COPY*/Loc)));
}


/// \brief Called on well formed \#pragma clang optimize.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPragmaOptimize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 370,
 FQN="clang::Sema::ActOnPragmaOptimize", NM="_ZN5clang4Sema19ActOnPragmaOptimizeEbNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema19ActOnPragmaOptimizeEbNS_14SourceLocationE")
//</editor-fold>
public final void ActOnPragmaOptimize(boolean On, SourceLocation PragmaLoc) {
  if (On) {
    $this().OptimizeOffPragmaLocation.$assignMove(new SourceLocation());
  } else {
    $this().OptimizeOffPragmaLocation.$assign(PragmaLoc);
  }
}


/// \brief Only called on function definitions; if there is a pragma in scope
/// with the effect of a range-based optnone, consider marking the function
/// with attribute optnone.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddRangeBasedOptnone">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 377,
 FQN="clang::Sema::AddRangeBasedOptnone", NM="_ZN5clang4Sema20AddRangeBasedOptnoneEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema20AddRangeBasedOptnoneEPNS_12FunctionDeclE")
//</editor-fold>
public final void AddRangeBasedOptnone(FunctionDecl /*P*/ FD) {
  // In the future, check other pragmas if they're implemented (e.g. pragma
  // optimize 0 will probably map to this functionality too).
  if ($this().OptimizeOffPragmaLocation.isValid()) {
    $this().AddOptnoneAttributeIfNoConflicts(FD, new SourceLocation($this().OptimizeOffPragmaLocation));
  }
}


/// \brief Adds the 'optnone' attribute to the function declaration if there
/// are no conflicts; Loc represents the location causing the 'optnone'
/// attribute to be added (usually because of a pragma).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddOptnoneAttributeIfNoConflicts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp", line = 384,
 FQN="clang::Sema::AddOptnoneAttributeIfNoConflicts", NM="_ZN5clang4Sema32AddOptnoneAttributeIfNoConflictsEPNS_12FunctionDeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang4Sema32AddOptnoneAttributeIfNoConflictsEPNS_12FunctionDeclENS_14SourceLocationE")
//</editor-fold>
public final void AddOptnoneAttributeIfNoConflicts(FunctionDecl /*P*/ FD, 
                                SourceLocation Loc) {
  // Don't add a conflicting attribute. No diagnostic is needed.
  if (FD.hasAttr(MinSizeAttr.class) || FD.hasAttr(AlwaysInlineAttr.class)) {
    return;
  }
  
  // Add attributes only if required. Optnone requires noinline as well, but if
  // either is already present then don't bother adding them.
  if (!FD.hasAttr(OptimizeNoneAttr.class)) {
    FD.addAttr(OptimizeNoneAttr.CreateImplicit($this().Context, new SourceRange(/*NO_COPY*/Loc)));
  }
  if (!FD.hasAttr(NoInlineAttr.class)) {
    FD.addAttr(NoInlineAttr.CreateImplicit($this().Context, new SourceRange(/*NO_COPY*/Loc)));
  }
}

} // END OF class Sema_SemaAttr
