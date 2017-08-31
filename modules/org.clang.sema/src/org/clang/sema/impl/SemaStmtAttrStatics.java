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
package org.clang.sema.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstAttributesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaStmtAttrStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAttr.cpp -nm=_ZL18handleLoopHintAttrRN5clang4SemaEPNS_4StmtERKNS_13AttributeListENS_11SourceRangeE;_ZL20ProcessStmtAttributeRN5clang4SemaEPNS_4StmtERKNS_13AttributeListENS_11SourceRangeE;_ZL21handleFallThroughAttrRN5clang4SemaEPNS_4StmtERKNS_13AttributeListENS_11SourceRangeE;_ZL22handleOpenCLUnrollHintRN5clang4SemaEPNS_4StmtERKNS_13AttributeListENS_11SourceRangeE;_ZL30CheckForIncompatibleAttributesRN5clang4SemaERKN4llvm15SmallVectorImplIPKNS_4AttrEEE; -static-type=SemaStmtAttrStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaStmtAttrStatics {

//<editor-fold defaultstate="collapsed" desc="handleFallThroughAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAttr.cpp", line = 26,
 FQN="handleFallThroughAttr", NM="_ZL21handleFallThroughAttrRN5clang4SemaEPNS_4StmtERKNS_13AttributeListENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAttr.cpp -nm=_ZL21handleFallThroughAttrRN5clang4SemaEPNS_4StmtERKNS_13AttributeListENS_11SourceRangeE")
//</editor-fold>
public static Attr /*P*/ handleFallThroughAttr(final Sema /*&*/ S, Stmt /*P*/ St, final /*const*/ AttributeList /*&*/ A, 
                     SourceRange Range) {
  FallThroughAttr Attr/*J*/= new FallThroughAttr(A.getRange(), S.Context, 
      A.getAttributeSpellingListIndex());
  if (!isa_NullStmt(St)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(A.getRange().getBegin(), diag.err_fallthrough_attr_wrong_target)), 
              Attr.getSpelling()), St.getLocStart()));
      if (isa_SwitchCase(St)) {
        SourceLocation L = S.getLocForEndOfToken(Range.getEnd());
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(L), diag.note_fallthrough_insert_semi_fixit)), 
            FixItHint.CreateInsertion(/*NO_COPY*/L, new StringRef(/*KEEP_STR*/$SEMI))));
      }
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  FunctionScopeInfo /*P*/ FnScope = S.getCurFunction();
  if (FnScope.SwitchStack.empty()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(A.getRange().getBegin(), diag.err_fallthrough_attr_outside_switch)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  
  // If this is spelled as the standard C++1z attribute, but not in C++1z, warn
  // about using it as an extension.
  if (!S.getLangOpts().CPlusPlus1z && A.isCXX11Attribute()
     && !(A.getScopeName() != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(A.getLoc(), diag.ext_cxx1z_attr)), A.getName()));
    } finally {
      $c$.$destroy();
    }
  }
  
  FnScope.setHasFallthroughStmt();
  return /*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new FallThroughAttr(Attr);
}

//<editor-fold defaultstate="collapsed" desc="handleLoopHintAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAttr.cpp", line = 56,
 FQN="handleLoopHintAttr", NM="_ZL18handleLoopHintAttrRN5clang4SemaEPNS_4StmtERKNS_13AttributeListENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAttr.cpp -nm=_ZL18handleLoopHintAttrRN5clang4SemaEPNS_4StmtERKNS_13AttributeListENS_11SourceRangeE")
//</editor-fold>
public static Attr /*P*/ handleLoopHintAttr(final Sema /*&*/ S, Stmt /*P*/ St, final /*const*/ AttributeList /*&*/ A, 
                  SourceRange $Prm3) {
  IdentifierLoc /*P*/ PragmaNameLoc = A.getArgAsIdent(0);
  IdentifierLoc /*P*/ OptionLoc = A.getArgAsIdent(1);
  IdentifierLoc /*P*/ StateLoc = A.getArgAsIdent(2);
  Expr /*P*/ ValueExpr = A.getArgAsExpr(3);
  
  boolean PragmaUnroll = $eq_StringRef(PragmaNameLoc.Ident.getName(), /*STRINGREF_STR*/"unroll");
  boolean PragmaNoUnroll = $eq_StringRef(PragmaNameLoc.Ident.getName(), /*STRINGREF_STR*/"nounroll");
  if (St.getStmtClass() != Stmt.StmtClass.DoStmtClass
     && St.getStmtClass() != Stmt.StmtClass.ForStmtClass
     && St.getStmtClass() != Stmt.StmtClass.CXXForRangeStmtClass
     && St.getStmtClass() != Stmt.StmtClass.WhileStmtClass) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/char$ptr/*char P*/ Pragma = $tryClone(new StringSwitchCharPtr(PragmaNameLoc.Ident.getName()).
          Case(/*KEEP_STR*/"unroll", /*KEEP_STR*/"#pragma unroll").
          Case(/*KEEP_STR*/"nounroll", /*KEEP_STR*/"#pragma nounroll").
          Default(/*KEEP_STR*/"#pragma clang loop"));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(St.getLocStart(), diag.err_pragma_loop_precedes_nonloop)), Pragma));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  
  LoopHintAttr.Spelling Spelling;
  LoopHintAttr.OptionType Option;
  LoopHintAttr.LoopHintState State;
  if (PragmaNoUnroll) {
    // #pragma nounroll
    Spelling = LoopHintAttr.Spelling.Pragma_nounroll;
    Option = LoopHintAttr.OptionType.Unroll;
    State = LoopHintAttr.LoopHintState.Disable;
  } else if (PragmaUnroll) {
    Spelling = LoopHintAttr.Spelling.Pragma_unroll;
    if ((ValueExpr != null)) {
      // #pragma unroll N
      Option = LoopHintAttr.OptionType.UnrollCount;
      State = LoopHintAttr.LoopHintState.Numeric;
    } else {
      // #pragma unroll
      Option = LoopHintAttr.OptionType.Unroll;
      State = LoopHintAttr.LoopHintState.Enable;
    }
  } else {
    // #pragma clang loop ...
    Spelling = LoopHintAttr.Spelling.Pragma_clang_loop;
    assert ((OptionLoc != null) && (OptionLoc.Ident != null)) : "Attribute must have valid option info.";
    Option = new StringSwitch<LoopHintAttr.OptionType>(OptionLoc.Ident.getName()).
        Case(/*KEEP_STR*/"vectorize", LoopHintAttr.OptionType.Vectorize).
        Case(/*KEEP_STR*/"vectorize_width", LoopHintAttr.OptionType.VectorizeWidth).
        Case(/*KEEP_STR*/"interleave", LoopHintAttr.OptionType.Interleave).
        Case(/*KEEP_STR*/"interleave_count", LoopHintAttr.OptionType.InterleaveCount).
        Case(/*KEEP_STR*/"unroll", LoopHintAttr.OptionType.Unroll).
        Case(/*KEEP_STR*/"unroll_count", LoopHintAttr.OptionType.UnrollCount).
        Case(/*KEEP_STR*/"distribute", LoopHintAttr.OptionType.Distribute).
        Default(LoopHintAttr.OptionType.Vectorize);
    if (Option == LoopHintAttr.OptionType.VectorizeWidth
       || Option == LoopHintAttr.OptionType.InterleaveCount
       || Option == LoopHintAttr.OptionType.UnrollCount) {
      assert ((ValueExpr != null)) : "Attribute must have a valid value expression.";
      if (S.CheckLoopHintExpr(ValueExpr, St.getLocStart())) {
        return null;
      }
      State = LoopHintAttr.LoopHintState.Numeric;
    } else if (Option == LoopHintAttr.OptionType.Vectorize
       || Option == LoopHintAttr.OptionType.Interleave
       || Option == LoopHintAttr.OptionType.Unroll
       || Option == LoopHintAttr.OptionType.Distribute) {
      assert ((StateLoc != null) && (StateLoc.Ident != null)) : "Loop hint must have an argument";
      if (StateLoc.Ident.isStr(/*KEEP_STR*/"disable")) {
        State = LoopHintAttr.LoopHintState.Disable;
      } else if (StateLoc.Ident.isStr(/*KEEP_STR*/"assume_safety")) {
        State = LoopHintAttr.LoopHintState.AssumeSafety;
      } else if (StateLoc.Ident.isStr(/*KEEP_STR*/"full")) {
        State = LoopHintAttr.LoopHintState.Full;
      } else if (StateLoc.Ident.isStr(/*KEEP_STR*/"enable")) {
        State = LoopHintAttr.LoopHintState.Enable;
      } else {
        throw new llvm_unreachable("bad loop hint argument");
      }
    } else {
      throw new llvm_unreachable("bad loop hint");
    }
  }
  
  return LoopHintAttr.CreateImplicit(S.Context, Spelling, Option, State, 
      ValueExpr, A.getRange());
}

//<editor-fold defaultstate="collapsed" desc="CheckForIncompatibleAttributes">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAttr.cpp", line = 142,
 FQN="CheckForIncompatibleAttributes", NM="_ZL30CheckForIncompatibleAttributesRN5clang4SemaERKN4llvm15SmallVectorImplIPKNS_4AttrEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAttr.cpp -nm=_ZL30CheckForIncompatibleAttributesRN5clang4SemaERKN4llvm15SmallVectorImplIPKNS_4AttrEEE")
//</editor-fold>
public static void CheckForIncompatibleAttributes(final Sema /*&*/ S, 
                              final /*const*/ SmallVectorImpl</*const*/ Attr /*P*/ > /*&*/ Attrs) {
  // There are 4 categories of loop hints attributes: vectorize, interleave,
  // unroll and distribute. Except for distribute they come in two variants: a
  // state form and a numeric form.  The state form selectively
  // defaults/enables/disables the transformation for the loop (for unroll,
  // default indicates full unrolling rather than enabling the transformation).
  // The numeric form form provides an integer hint (for example, unroll count)
  // to the transformer. The following array accumulates the hints encountered
  // while iterating through the attributes to check for compatibility.
  //<editor-fold defaultstate="collapsed" desc="">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAttr.cpp", line = 153,
   FQN="", NM="_ZL30CheckForIncompatibleAttributesRN5clang4SemaERKN4llvm15SmallVectorImplIPKNS_4AttrEEE_Unnamed_struct",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAttr.cpp -nm=_ZL30CheckForIncompatibleAttributesRN5clang4SemaERKN4llvm15SmallVectorImplIPKNS_4AttrEEE_Unnamed_struct")
  //</editor-fold>
   class/*struct*/ Unnamed_struct {
    public /*const*/ LoopHintAttr /*P*/ StateAttr;
    public /*const*/ LoopHintAttr /*P*/ NumericAttr;

    public Unnamed_struct(LoopHintAttr StateAttr, LoopHintAttr NumericAttr) {
      this.StateAttr = StateAttr;
      this.NumericAttr = NumericAttr;
    }
    
    @Override public String toString() {
      return "" + "StateAttr=" + StateAttr // NOI18N
                + ", NumericAttr=" + NumericAttr; // NOI18N
    }
  } Unnamed_struct HintAttrs[/*4*/] = new Unnamed_struct [/*4*/] {
    new Unnamed_struct((/*const*/ LoopHintAttr /*P*/ )null, (/*const*/ LoopHintAttr /*P*/ )null), 
    new Unnamed_struct((/*const*/ LoopHintAttr /*P*/ )null, (/*const*/ LoopHintAttr /*P*/ )null), 
    new Unnamed_struct((/*const*/ LoopHintAttr /*P*/ )null, (/*const*/ LoopHintAttr /*P*/ )null), 
    new Unnamed_struct((/*const*/ LoopHintAttr /*P*/ )null, (/*const*/ LoopHintAttr /*P*/ )null)};
  
  for (/*const*/ Attr /*P*/ I : Attrs) {
    /*const*/ LoopHintAttr /*P*/ LH = dyn_cast_LoopHintAttr(I);
    
    // Skip non loop hint attributes
    if (!(LH != null)) {
      continue;
    }
    
    LoopHintAttr.OptionType Option = LH.getOption();
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int Vectorize = 0;
      final /*uint*/int Interleave = Vectorize + 1;
      final /*uint*/int Unroll = Interleave + 1;
      final /*uint*/int Distribute = Unroll + 1;
    /*}*//*Unnamed enum*//*uint*/int Category;
    switch (Option) {
     default:
     case Vectorize:
     case VectorizeWidth:
      Category = Vectorize;
      break;
     case Interleave:
     case InterleaveCount:
      Category = Interleave;
      break;
     case Unroll:
     case UnrollCount:
      Category = Unroll;
      break;
     case Distribute:
      // Perform the check for duplicated 'distribute' hints.
      Category = Distribute;
      break;
    }
    /*JSKIP;*/
    
    final Unnamed_struct CategoryState = HintAttrs[Category];
    /*const*/ LoopHintAttr /*P*/ PrevAttr;
    if (Option == LoopHintAttr.OptionType.Vectorize
       || Option == LoopHintAttr.OptionType.Interleave || Option == LoopHintAttr.OptionType.Unroll
       || Option == LoopHintAttr.OptionType.Distribute) {
      // Enable|Disable|AssumeSafety hint.  For example, vectorize(enable).
      PrevAttr = CategoryState.StateAttr;
      CategoryState.StateAttr = LH;
    } else {
      // Numeric hint.  For example, vectorize_width(8).
      PrevAttr = CategoryState.NumericAttr;
      CategoryState.NumericAttr = LH;
    }
    
    PrintingPolicy Policy/*J*/= new PrintingPolicy(S.Context.getLangOpts());
    SourceLocation OptionLoc = LH.getRange().getBegin();
    if ((PrevAttr != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Cannot specify same type of attribute twice.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OptionLoc), diag.err_pragma_loop_compatibility)), 
                    /*Duplicate=*/ true), PrevAttr.getDiagnosticName(Policy)), 
            LH.getDiagnosticName(Policy)));
      } finally {
        $c$.$destroy();
      }
    }
    if ((CategoryState.StateAttr != null) && (CategoryState.NumericAttr != null)
       && (Category == Unroll
       || CategoryState.StateAttr.getState() == LoopHintAttr.LoopHintState.Disable)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Disable hints are not compatible with numeric hints of the same
        // category.  As a special case, numeric unroll hints are also not
        // compatible with enable or full form of the unroll pragma because these
        // directives indicate full unrolling.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OptionLoc), diag.err_pragma_loop_compatibility)), 
                    /*Duplicate=*/ false), 
                CategoryState.StateAttr.getDiagnosticName(Policy)), 
            CategoryState.NumericAttr.getDiagnosticName(Policy)));
      } finally {
        $c$.$destroy();
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="handleOpenCLUnrollHint">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAttr.cpp", line = 226,
 FQN="handleOpenCLUnrollHint", NM="_ZL22handleOpenCLUnrollHintRN5clang4SemaEPNS_4StmtERKNS_13AttributeListENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAttr.cpp -nm=_ZL22handleOpenCLUnrollHintRN5clang4SemaEPNS_4StmtERKNS_13AttributeListENS_11SourceRangeE")
//</editor-fold>
public static Attr /*P*/ handleOpenCLUnrollHint(final Sema /*&*/ S, Stmt /*P*/ St, final /*const*/ AttributeList /*&*/ A, 
                      SourceRange Range) {
  // OpenCL v2.0 s6.11.5 - opencl_unroll_hint can have 0 arguments (compiler
  // determines unrolling factor) or 1 argument (the unroll factor provided
  // by the user).
  if ($less_uint(S.getLangOpts().OpenCLVersion, 200)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(A.getLoc(), diag.err_attribute_requires_opencl_version)), 
                  A.getName()), /*KEEP_STR*/"2.0"), 1));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  
  /*uint*/int NumArgs = A.getNumArgs();
  if ($greater_uint(NumArgs, 1)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(A.getLoc(), diag.err_attribute_too_many_arguments)), A.getName()), 
          1));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  
  /*uint*/int UnrollFactor = 0;
  if (NumArgs == 1) {
    Expr /*P*/ E = A.getArgAsExpr(0);
    APSInt ArgVal/*J*/= new APSInt(32);
    if (!E.isIntegerConstantExpr(ArgVal, S.Context)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(A.getLoc(), diag.err_attribute_argument_type)), 
                    A.getName()), AttributeArgumentNType.AANT_ArgumentIntegerConstant), E.getSourceRange()));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    
    int Val = (int)ArgVal.getSExtValue();
    if (Val <= 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(A.getRange().getBegin(), 
                diag.err_attribute_requires_positive_integer)), 
            A.getName()));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    UnrollFactor = Val;
  }
  
  return OpenCLUnrollHintAttr.CreateImplicit(S.Context, UnrollFactor);
}

//<editor-fold defaultstate="collapsed" desc="ProcessStmtAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAttr.cpp", line = 272,
 FQN="ProcessStmtAttribute", NM="_ZL20ProcessStmtAttributeRN5clang4SemaEPNS_4StmtERKNS_13AttributeListENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAttr.cpp -nm=_ZL20ProcessStmtAttributeRN5clang4SemaEPNS_4StmtERKNS_13AttributeListENS_11SourceRangeE")
//</editor-fold>
public static Attr /*P*/ ProcessStmtAttribute(final Sema /*&*/ S, Stmt /*P*/ St, final /*const*/ AttributeList /*&*/ A, 
                    SourceRange Range) {
  switch (A.getKind()) {
   case UnknownAttribute:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(A.getLoc(), A.isDeclspecAttribute() ? diag.warn_unhandled_ms_attribute_ignored : diag.warn_unknown_attribute_ignored)), A.getName()));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
   case AT_FallThrough:
    return handleFallThroughAttr(S, St, A, new SourceRange(Range));
   case AT_LoopHint:
    return handleLoopHintAttr(S, St, A, new SourceRange(Range));
   case AT_OpenCLUnrollHint:
    return handleOpenCLUnrollHint(S, St, A, new SourceRange(Range));
   default:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // if we're here, then we parsed a known attribute, but didn't recognize
        // it as a statement attribute => it is declaration attribute
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(A.getRange().getBegin(), diag.err_decl_attribute_invalid_on_stmt)), 
                A.getName()), St.getLocStart()));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
  }
}

} // END OF class SemaStmtAttrStatics
