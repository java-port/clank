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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import org.clang.basic.target.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import org.llvm.mc.mcparser.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaStmtAsmStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp -nm=_ZL14CheckAsmLValuePKN5clang4ExprERNS_4SemaE;_ZL18isOperandMentionedjN4llvm8ArrayRefIN5clang10GCCAsmStmt14AsmStringPieceEEE;_ZL21fillInlineAsmTypeInfoRKN5clang10ASTContextENS_8QualTypeERN4llvm23InlineAsmIdentifierInfoE;_ZL23CheckNakedParmReferencePN5clang4ExprERNS_4SemaE;_ZL31checkExprMemoryConstraintCompatRN5clang4SemaEPNS_4ExprERNS_10TargetInfo14ConstraintInfoEb; -static-type=SemaStmtAsmStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaStmtAsmStatics {


/// CheckAsmLValue - GNU C has an extremely ugly extension whereby they silently
/// ignore "noop" casts in places where an lvalue is required by an inline asm.
/// We emulate this behavior when -fheinous-gnu-extensions is specified, but
/// provide a strong guidance to not use it.
///
/// This method checks to see if the argument is an acceptable l-value and
/// returns false if it is a case we can handle.
//<editor-fold defaultstate="collapsed" desc="CheckAsmLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp", line = 37,
 FQN="CheckAsmLValue", NM="_ZL14CheckAsmLValuePKN5clang4ExprERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp -nm=_ZL14CheckAsmLValuePKN5clang4ExprERNS_4SemaE")
//</editor-fold>
public static boolean CheckAsmLValue(/*const*/ Expr /*P*/ E, final Sema /*&*/ S) {
  // Type dependent expressions will be checked during instantiation.
  if (E.isTypeDependent()) {
    return false;
  }
  if (E.isLValue()) {
    return false; // Cool, this is an lvalue.
  }
  
  // Okay, this is not an lvalue, but perhaps it is the result of a cast that we
  // are supposed to allow.
  /*const*/ Expr /*P*/ E2 = E.IgnoreParenNoopCasts$Const(S.Context);
  if (E != E2 && E2.isLValue()) {
    if (!S.getLangOpts().HeinousExtensions) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E2.getLocStart(), diag.err_invalid_asm_cast_lvalue)), 
            E.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E2.getLocStart(), diag.warn_invalid_asm_cast_lvalue)), 
            E.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
    // Accept, even if we emitted an error diagnostic.
    return false;
  }
  
  // None of the above, just randomly invalid non-lvalue.
  return true;
}


/// isOperandMentioned - Return true if the specified operand # is mentioned
/// anywhere in the decomposed asm string.
//<editor-fold defaultstate="collapsed" desc="isOperandMentioned">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp", line = 65,
 FQN="isOperandMentioned", NM="_ZL18isOperandMentionedjN4llvm8ArrayRefIN5clang10GCCAsmStmt14AsmStringPieceEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp -nm=_ZL18isOperandMentionedjN4llvm8ArrayRefIN5clang10GCCAsmStmt14AsmStringPieceEEE")
//</editor-fold>
public static boolean isOperandMentioned(/*uint*/int OpNo, 
                  ArrayRef<GCCAsmStmt.AsmStringPiece> AsmStrPieces) {
  for (/*uint*/int p = 0, e = AsmStrPieces.size(); p != e; ++p) {
    final /*const*/ GCCAsmStmt.AsmStringPiece /*&*/ Piece = AsmStrPieces.$at(p);
    if (!Piece.isOperand()) {
      continue;
    }
    
    // If this is a reference to the input and if the input was the smaller
    // one, then we have to reject this asm.
    if (Piece.getOperandNo() == OpNo) {
      return true;
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="CheckNakedParmReference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp", line = 79,
 FQN="CheckNakedParmReference", NM="_ZL23CheckNakedParmReferencePN5clang4ExprERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp -nm=_ZL23CheckNakedParmReferencePN5clang4ExprERNS_4SemaE")
//</editor-fold>
public static boolean CheckNakedParmReference(Expr /*P*/ E, final Sema /*&*/ S) {
  FunctionDecl /*P*/ Func = dyn_cast_FunctionDecl(S.CurContext);
  if (!(Func != null)) {
    return false;
  }
  if (!Func.hasAttr(NakedAttr.class)) {
    return false;
  }
  
  SmallVector<Expr /*P*/ > WorkList/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
  WorkList.push_back(E);
  while ((WorkList.size() != 0)) {
    Expr /*P*/ E$1 = WorkList.pop_back_val();
    if (isa_CXXThisExpr(E$1)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(E$1.getLocStart(), diag.err_asm_naked_this_ref)));
        $c$.clean($c$.track(S.Diag(Func.getAttr(NakedAttr.class).getLocation(), diag.note_attribute)));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    {
      DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E$1);
      if ((DRE != null)) {
        if (isa_ParmVarDecl(DRE.getDecl())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(S.Diag(DRE.getLocStart(), diag.err_asm_naked_parm_ref)));
            $c$.clean($c$.track(S.Diag(Func.getAttr(NakedAttr.class).getLocation(), diag.note_attribute)));
            return true;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    for (Stmt /*P*/ Child : E$1.children()) {
      {
        Expr /*P*/ E$2 = dyn_cast_or_null_Expr(Child);
        if ((E$2 != null)) {
          WorkList.push_back(E$2);
        }
      }
    }
  }
  return false;
}


/// \brief Returns true if given expression is not compatible with inline
/// assembly's memory constraint; false otherwise.
//<editor-fold defaultstate="collapsed" desc="checkExprMemoryConstraintCompat">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp", line = 112,
 FQN="checkExprMemoryConstraintCompat", NM="_ZL31checkExprMemoryConstraintCompatRN5clang4SemaEPNS_4ExprERNS_10TargetInfo14ConstraintInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp -nm=_ZL31checkExprMemoryConstraintCompatRN5clang4SemaEPNS_4ExprERNS_10TargetInfo14ConstraintInfoEb")
//</editor-fold>
public static boolean checkExprMemoryConstraintCompat(final Sema /*&*/ S, Expr /*P*/ E, 
                               final TargetInfo.ConstraintInfo /*&*/ Info, 
                               boolean is_input_expr) {
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    final /*uint*/int ExprBitfield = 0;
    final /*uint*/int ExprVectorElt = ExprBitfield + 1;
    final /*uint*/int ExprGlobalRegVar = ExprVectorElt + 1;
    final /*uint*/int ExprSafeType = ExprGlobalRegVar + 1;
  /*}*//*Unnamed enum*//*uint*/int EType = ExprSafeType;
  
  // Bitfields, vector elements and global register variables are not
  // compatible.
  if (E.refersToBitField()) {
    EType = ExprBitfield;
  } else if (E.refersToVectorElement()) {
    EType = ExprVectorElt;
  } else if (E.refersToGlobalRegisterVar()) {
    EType = ExprGlobalRegVar;
  }
  if (EType != ExprSafeType) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getLocStart(), diag.err_asm_non_addr_value_in_memory_constraint)), 
                      EType), is_input_expr), Info.getConstraintStr()), 
          E.getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="fillInlineAsmTypeInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp", line = 550,
 FQN="fillInlineAsmTypeInfo", NM="_ZL21fillInlineAsmTypeInfoRKN5clang10ASTContextENS_8QualTypeERN4llvm23InlineAsmIdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp -nm=_ZL21fillInlineAsmTypeInfoRKN5clang10ASTContextENS_8QualTypeERN4llvm23InlineAsmIdentifierInfoE")
//</editor-fold>
public static void fillInlineAsmTypeInfo(final /*const*/ ASTContext /*&*/ Context, QualType T, 
                     final InlineAsmIdentifierInfo /*&*/ Info) {
  // Compute the type size (and array length if applicable?).
  Info.Type = Info.Size = $long2uint(Context.getTypeSizeInChars(new QualType(T)).getQuantity());
  if (T.$arrow().isArrayType()) {
    /*const*/ ArrayType /*P*/ ATy = Context.getAsArrayType(new QualType(T));
    Info.Type = $long2uint(Context.getTypeSizeInChars(ATy.getElementType()).getQuantity());
    Info.Length = $div_uint(Info.Size, Info.Type);
  }
}

} // END OF class SemaStmtAsmStatics
