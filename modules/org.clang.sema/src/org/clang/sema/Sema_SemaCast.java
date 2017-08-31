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
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaCast">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaCXXScopeSpec ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN5clang4Sema17ActOnCXXNamedCastENS_14SourceLocationENS_3tok9TokenKindES1_RNS_10DeclaratorES1_S1_PNS_4ExprES1_;_ZN5clang4Sema17BuildCXXNamedCastENS_14SourceLocationENS_3tok9TokenKindEPNS_14TypeSourceInfoEPNS_4ExprENS_11SourceRangeES8_;_ZN5clang4Sema19BuildCStyleCastExprENS_14SourceLocationEPNS_14TypeSourceInfoES1_PNS_4ExprE;_ZN5clang4Sema26BuildCXXFunctionalCastExprEPNS_14TypeSourceInfoENS_14SourceLocationEPNS_4ExprES3_;_ZN5clang4Sema30CheckCompatibleReinterpretCastENS_8QualTypeES1_bNS_11SourceRangeE; -static-type=Sema_SemaCast -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaCast extends Sema_SemaCXXScopeSpec {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCStyleCastExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 2593,
 FQN="clang::Sema::BuildCStyleCastExpr", NM="_ZN5clang4Sema19BuildCStyleCastExprENS_14SourceLocationEPNS_14TypeSourceInfoES1_PNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN5clang4Sema19BuildCStyleCastExprENS_14SourceLocationEPNS_14TypeSourceInfoES1_PNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCStyleCastExpr(SourceLocation LPLoc, 
                   TypeSourceInfo /*P*/ CastTypeInfo, 
                   SourceLocation RPLoc, 
                   Expr /*P*/ CastExpr) {
  CastOperation Op = null;
  try {
    Op/*J*/= new CastOperation(/*Deref*/$this(), CastTypeInfo.getType(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CastExpr));
    Op.DestRange.$assignMove(CastTypeInfo.getTypeLoc().getSourceRange());
    Op.OpRange.$assignMove(new SourceRange(/*NO_COPY*/LPLoc, CastExpr.getLocEnd()));
    if ($this().getLangOpts().CPlusPlus) {
      Op.CheckCXXCStyleCast(/*FunctionalStyle=*/ false, 
          isa_InitListExpr(CastExpr));
    } else {
      Op.CheckCStyleCast();
    }
    if (Op.SrcExpr.isInvalid()) {
      return ExprError();
    }
    
    return Op.complete(CStyleCastExpr.Create($this().Context, new QualType(Op.ResultType), 
            Op.ValueKind, Op.Kind, Op.SrcExpr.get(), 
            $AddrOf(Op.BasePath), CastTypeInfo, new SourceLocation(LPLoc), new SourceLocation(RPLoc)));
  } finally {
    if (Op != null) { Op.$destroy(); }
  }
}


// Checks that reinterpret casts don't have undefined behavior.

// Checks for undefined behavior in reinterpret_cast.
// The cases that is checked for is:
// *reinterpret_cast<T*>(&a)
// reinterpret_cast<T&>(a)
// where accessing 'a' as type 'T' will result in undefined behavior.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckCompatibleReinterpretCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 1660,
 FQN="clang::Sema::CheckCompatibleReinterpretCast", NM="_ZN5clang4Sema30CheckCompatibleReinterpretCastENS_8QualTypeES1_bNS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN5clang4Sema30CheckCompatibleReinterpretCastENS_8QualTypeES1_bNS_11SourceRangeE")
//</editor-fold>
public final void CheckCompatibleReinterpretCast(QualType SrcType, QualType DestType, 
                              boolean IsDereference, 
                              SourceRange Range) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*uint*/int DiagID = IsDereference ? diag.warn_pointer_indirection_from_incompatible_type : diag.warn_undefined_reinterpret_cast;
    if ($this().Diags.isIgnored(DiagID, Range.getBegin())) {
      return;
    }
    
    QualType SrcTy/*J*/= new QualType();
    QualType DestTy/*J*/= new QualType();
    if (IsDereference) {
      if (!(SrcType.$arrow().getAs(PointerType.class) != null) || !(DestType.$arrow().getAs(PointerType.class) != null)) {
        return;
      }
      SrcTy.$assignMove(SrcType.$arrow().getPointeeType());
      DestTy.$assignMove(DestType.$arrow().getPointeeType());
    } else {
      if (!(DestType.$arrow().getAs(ReferenceType.class) != null)) {
        return;
      }
      SrcTy.$assign(SrcType);
      DestTy.$assignMove(DestType.$arrow().getPointeeType());
    }
    
    // Cast is compatible if the types are the same.
    if ($this().Context.hasSameUnqualifiedType(new QualType(DestTy), new QualType(SrcTy))) {
      return;
    }
    // or one of the types is a char or void type
    if (DestTy.$arrow().isAnyCharacterType() || DestTy.$arrow().isVoidType()
       || SrcTy.$arrow().isAnyCharacterType() || SrcTy.$arrow().isVoidType()) {
      return;
    }
    // or one of the types is a tag type.
    if ((SrcTy.$arrow().getAs(TagType.class) != null) || (DestTy.$arrow().getAs(TagType.class) != null)) {
      return;
    }
    
    // FIXME: Scoped enums?
    if ((SrcTy.$arrow().isUnsignedIntegerType() && DestTy.$arrow().isSignedIntegerType())
       || (SrcTy.$arrow().isSignedIntegerType() && DestTy.$arrow().isUnsignedIntegerType())) {
      if ($this().Context.getTypeSize(new QualType(DestTy)) == $this().Context.getTypeSize(new QualType(SrcTy))) {
        return;
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Range.getBegin(), DiagID)), SrcType), DestType), Range));
  } finally {
    $c$.$destroy();
  }
}


/// ActOnCXXNamedCast - Parse {dynamic,static,reinterpret,const}_cast's.

/// ActOnCXXNamedCast - Parse {dynamic,static,reinterpret,const}_cast's.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXNamedCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 213,
 FQN="clang::Sema::ActOnCXXNamedCast", NM="_ZN5clang4Sema17ActOnCXXNamedCastENS_14SourceLocationENS_3tok9TokenKindES1_RNS_10DeclaratorES1_S1_PNS_4ExprES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN5clang4Sema17ActOnCXXNamedCastENS_14SourceLocationENS_3tok9TokenKindES1_RNS_10DeclaratorES1_S1_PNS_4ExprES1_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnCXXNamedCast(SourceLocation OpLoc, /*tok.TokenKind*/char Kind, 
                 SourceLocation LAngleBracketLoc, final Declarator /*&*/ D, 
                 SourceLocation RAngleBracketLoc, 
                 SourceLocation LParenLoc, Expr /*P*/ E, 
                 SourceLocation RParenLoc) {
  assert (!D.isInvalidType());
  
  TypeSourceInfo /*P*/ TInfo = $this().GetTypeForDeclaratorCast(D, E.getType());
  if (D.isInvalidType()) {
    return ExprError();
  }
  if ($this().getLangOpts().CPlusPlus) {
    // Check that there are no default arguments (C++ only).
    $this().CheckExtraCXXDefaultArguments(D);
  }
  
  return $this().BuildCXXNamedCast(new SourceLocation(OpLoc), Kind, TInfo, E, 
      new SourceRange(/*NO_COPY*/LAngleBracketLoc, /*NO_COPY*/RAngleBracketLoc), 
      new SourceRange(/*NO_COPY*/LParenLoc, /*NO_COPY*/RParenLoc));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXNamedCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 236,
 FQN="clang::Sema::BuildCXXNamedCast", NM="_ZN5clang4Sema17BuildCXXNamedCastENS_14SourceLocationENS_3tok9TokenKindEPNS_14TypeSourceInfoEPNS_4ExprENS_11SourceRangeES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN5clang4Sema17BuildCXXNamedCastENS_14SourceLocationENS_3tok9TokenKindEPNS_14TypeSourceInfoEPNS_4ExprENS_11SourceRangeES8_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCXXNamedCast(SourceLocation OpLoc, /*tok.TokenKind*/char Kind, 
                 TypeSourceInfo /*P*/ DestTInfo, Expr /*P*/ E, 
                 SourceRange AngleBrackets, SourceRange Parens) {
  CastOperation Op = null;
  try {
    ActionResultTTrue<Expr /*P*/ > Ex = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    QualType DestType = DestTInfo.getType();
    
    // If the type is dependent, we won't do the semantic analysis now.
    boolean TypeDependent = DestType.$arrow().isDependentType() || Ex.get().isTypeDependent();
    
    Op/*J*/= new CastOperation(/*Deref*/$this(), new QualType(DestType), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E));
    Op.OpRange.$assignMove(new SourceRange(/*NO_COPY*/OpLoc, Parens.getEnd()));
    Op.DestRange.$assign(AngleBrackets);
    switch (Kind) {
     default:
      throw new llvm_unreachable("Unknown C++ cast!");
     case tok.TokenKind.kw_const_cast:
      if (!TypeDependent) {
        Op.CheckConstCast();
        if (Op.SrcExpr.isInvalid()) {
          return ExprError();
        }
      }
      return Op.complete(CXXConstCastExpr.Create($this().Context, new QualType(Op.ResultType), 
              Op.ValueKind, Op.SrcExpr.get(), DestTInfo, 
              new SourceLocation(OpLoc), Parens.getEnd(), 
              new SourceRange(AngleBrackets)));
     case tok.TokenKind.kw_dynamic_cast:
      {
        if (!TypeDependent) {
          Op.CheckDynamicCast();
          if (Op.SrcExpr.isInvalid()) {
            return ExprError();
          }
        }
        return Op.complete(CXXDynamicCastExpr.Create($this().Context, new QualType(Op.ResultType), 
                Op.ValueKind, Op.Kind, Op.SrcExpr.get(), 
                $AddrOf(Op.BasePath), DestTInfo, 
                new SourceLocation(OpLoc), Parens.getEnd(), 
                new SourceRange(AngleBrackets)));
      }
     case tok.TokenKind.kw_reinterpret_cast:
      {
        if (!TypeDependent) {
          Op.CheckReinterpretCast();
          if (Op.SrcExpr.isInvalid()) {
            return ExprError();
          }
        }
        return Op.complete(CXXReinterpretCastExpr.Create($this().Context, new QualType(Op.ResultType), 
                Op.ValueKind, Op.Kind, Op.SrcExpr.get(), 
                (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, DestTInfo, new SourceLocation(OpLoc), 
                Parens.getEnd(), 
                new SourceRange(AngleBrackets)));
      }
     case tok.TokenKind.kw_static_cast:
      {
        if (!TypeDependent) {
          Op.CheckStaticCast();
          if (Op.SrcExpr.isInvalid()) {
            return ExprError();
          }
        }
        
        return Op.complete(CXXStaticCastExpr.Create($this().Context, new QualType(Op.ResultType), 
                Op.ValueKind, Op.Kind, Op.SrcExpr.get(), 
                $AddrOf(Op.BasePath), DestTInfo, 
                new SourceLocation(OpLoc), Parens.getEnd(), 
                new SourceRange(AngleBrackets)));
      }
    }
  } finally {
    if (Op != null) { Op.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXFunctionalCastExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp", line = 2616,
 FQN="clang::Sema::BuildCXXFunctionalCastExpr", NM="_ZN5clang4Sema26BuildCXXFunctionalCastExprEPNS_14TypeSourceInfoENS_14SourceLocationEPNS_4ExprES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN5clang4Sema26BuildCXXFunctionalCastExprEPNS_14TypeSourceInfoENS_14SourceLocationEPNS_4ExprES3_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCXXFunctionalCastExpr(TypeSourceInfo /*P*/ CastTypeInfo, 
                          SourceLocation LPLoc, 
                          Expr /*P*/ CastExpr, 
                          SourceLocation RPLoc) {
  CastOperation Op = null;
  try {
    assert (LPLoc.isValid()) : "List-initialization shouldn't get here.";
    Op/*J*/= new CastOperation(/*Deref*/$this(), CastTypeInfo.getType(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CastExpr));
    Op.DestRange.$assignMove(CastTypeInfo.getTypeLoc().getSourceRange());
    Op.OpRange.$assignMove(new SourceRange(Op.DestRange.getBegin(), CastExpr.getLocEnd()));
    
    Op.CheckCXXCStyleCast(/*FunctionalStyle=*/ true, /*ListInit=*/ false);
    if (Op.SrcExpr.isInvalid()) {
      return ExprError();
    }
    
    Expr /*P*/ SubExpr = Op.SrcExpr.get();
    {
      CXXBindTemporaryExpr /*P*/ BindExpr = dyn_cast_CXXBindTemporaryExpr(SubExpr);
      if ((BindExpr != null)) {
        SubExpr = BindExpr.getSubExpr();
      }
    }
    {
      CXXConstructExpr /*P*/ ConstructExpr = dyn_cast_CXXConstructExpr(SubExpr);
      if ((ConstructExpr != null)) {
        ConstructExpr.setParenOrBraceRange(new SourceRange(/*NO_COPY*/LPLoc, /*NO_COPY*/RPLoc));
      }
    }
    
    return Op.complete(CXXFunctionalCastExpr.Create($this().Context, new QualType(Op.ResultType), 
            Op.ValueKind, CastTypeInfo, Op.Kind, 
            Op.SrcExpr.get(), $AddrOf(Op.BasePath), new SourceLocation(LPLoc), new SourceLocation(RPLoc)));
  } finally {
    if (Op != null) { Op.$destroy(); }
  }
}

} // END OF class Sema_SemaCast
