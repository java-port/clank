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
package org.clang.ast.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.basic.BasicClangGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type ExprStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=Tpl__ZN12_GLOBAL__N_114getExprLocImplEPKN5clang4ExprEMS1_KFNS0_14SourceLocationEvE;Tpl__ZN12_GLOBAL__N_114getExprLocImplEPKN5clang4ExprEMT0_KFNS0_14SourceLocationEvE;_ZL24computeDeclRefDependenceRKN5clang10ASTContextEPNS_9NamedDeclENS_8QualTypeERbS6_S6_;_ZL39skipTemporaryBindingsNoOpCastsAndParensPKN5clang4ExprE; -static-type=ExprStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class ExprStatics {

/// This implementation is used when a class provides a custom
/// implementation of getExprLoc.
/*template <class E, class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getExprLocImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 177,
 FQN="(anonymous namespace)::getExprLocImpl", NM="Tpl__ZN12_GLOBAL__N_114getExprLocImplEPKN5clang4ExprEMT0_KFNS0_14SourceLocationEvE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=Tpl__ZN12_GLOBAL__N_114getExprLocImplEPKN5clang4ExprEMT0_KFNS0_14SourceLocationEvE")
//</editor-fold>
public static </*class*/ E extends Expr/*, classT*/> SourceLocation getExprLocImpl$getExprLoc(/*const*/ Expr /*P*/ expr, 
                         T$getSourceLocation<E> v) {
  return ((/*static_cast*//*const*/ E /*P*/ )(expr)).getExprLoc();
}


/// This implementation is used when a class doesn't provide
/// a custom implementation of getExprLoc.  Overload resolution
/// should pick it over the implementation above because it's
/// more specialized according to function template partial ordering.
/*template <class E> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getExprLocImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 187,
 FQN="(anonymous namespace)::getExprLocImpl", NM="Tpl__ZN12_GLOBAL__N_114getExprLocImplEPKN5clang4ExprEMS1_KFNS0_14SourceLocationEvE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=Tpl__ZN12_GLOBAL__N_114getExprLocImplEPKN5clang4ExprEMS1_KFNS0_14SourceLocationEvE")
//</editor-fold>
public static </*class*/ E extends Expr> SourceLocation getExprLocImpl$getLocStart(/*const*/ Expr /*P*/ expr, 
                          T$getSourceLocation<E> v) {
  return ((/*static_cast*//*const*/ E /*P*/ )(expr)).getLocStart();
}


//===----------------------------------------------------------------------===//
// Primary Expressions.
//===----------------------------------------------------------------------===//

/// \brief Compute the type-, value-, and instantiation-dependence of a 
/// declaration reference
/// based on the declaration being referenced.
//<editor-fold defaultstate="collapsed" desc="computeDeclRefDependence">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 213,
 FQN="computeDeclRefDependence", NM="_ZL24computeDeclRefDependenceRKN5clang10ASTContextEPNS_9NamedDeclENS_8QualTypeERbS6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZL24computeDeclRefDependenceRKN5clang10ASTContextEPNS_9NamedDeclENS_8QualTypeERbS6_S6_")
//</editor-fold>
public static void computeDeclRefDependence(final /*const*/ ASTContext /*&*/ Ctx, NamedDecl /*P*/ D, 
                        QualType T, final bool$ref/*bool &*/ TypeDependent, 
                        final bool$ref/*bool &*/ ValueDependent, 
                        final bool$ref/*bool &*/ InstantiationDependent) {
  TypeDependent.$set(false);
  ValueDependent.$set(false);
  InstantiationDependent.$set(false);
  
  // (TD) C++ [temp.dep.expr]p3:
  //   An id-expression is type-dependent if it contains:
  //
  // and
  //
  // (VD) C++ [temp.dep.constexpr]p2:
  //  An identifier is value-dependent if it is:
  
  //  (TD)  - an identifier that was declared with dependent type
  //  (VD)  - a name declared with a dependent type,
  if (T.$arrow().isDependentType()) {
    TypeDependent.$set(true);
    ValueDependent.$set(true);
    InstantiationDependent.$set(true);
    return;
  } else if (T.$arrow().isInstantiationDependentType()) {
    InstantiationDependent.$set(true);
  }
  
  //  (TD)  - a conversion-function-id that specifies a dependent type
  if (D.getDeclName().getNameKind()
     == DeclarationName.NameKind.CXXConversionFunctionName) {
    QualType T$1 = D.getDeclName().getCXXNameType();
    if (T$1.$arrow().isDependentType()) {
      TypeDependent.$set(true);
      ValueDependent.$set(true);
      InstantiationDependent.$set(true);
      return;
    }
    if (T$1.$arrow().isInstantiationDependentType()) {
      InstantiationDependent.$set(true);
    }
  }
  
  //  (VD)  - the name of a non-type template parameter,
  if (isa_NonTypeTemplateParmDecl(D)) {
    ValueDependent.$set(true);
    InstantiationDependent.$set(true);
    return;
  }
  {
    
    //  (VD) - a constant with integral or enumeration type and is
    //         initialized with an expression that is value-dependent.
    //  (VD) - a constant with literal type and is initialized with an
    //         expression that is value-dependent [C++11].
    //  (VD) - FIXME: Missing from the standard:
    //       -  an entity with reference type and is initialized with an
    //          expression that is value-dependent [C++11]
    VarDecl /*P*/ Var = dyn_cast_VarDecl(D);
    if ((Var != null)) {
      if ((Ctx.getLangOpts().CPlusPlus11 ? Var.getType().$arrow().isLiteralType(Ctx) : Var.getType().$arrow().isIntegralOrEnumerationType())
         && (Var.getType().isConstQualified()
         || Var.getType().$arrow().isReferenceType())) {
        {
          /*const*/ Expr /*P*/ Init = Var.getAnyInitializer();
          if ((Init != null)) {
            if (Init.isValueDependent()) {
              ValueDependent.$set(true);
              InstantiationDependent.$set(true);
            }
          }
        }
      }
      
      // (VD) - FIXME: Missing from the standard: 
      //      -  a member function or a static data member of the current 
      //         instantiation
      if (Var.isStaticDataMember()
         && Var.getDeclContext().isDependentContext()) {
        ValueDependent.$set(true);
        InstantiationDependent.$set(true);
        TypeSourceInfo /*P*/ TInfo = Var.getFirstDecl().getTypeSourceInfo();
        if (TInfo.getType().$arrow().isIncompleteArrayType()) {
          TypeDependent.$set(true);
        }
      }
      
      return;
    }
  }
  
  // (VD) - FIXME: Missing from the standard: 
  //      -  a member function or a static data member of the current 
  //         instantiation
  if (isa_CXXMethodDecl(D) && D.getDeclContext().isDependentContext()) {
    ValueDependent.$set(true);
    InstantiationDependent.$set(true);
  }
}


/// \brief Skip over any no-op casts and any temporary-binding
/// expressions.
//<editor-fold defaultstate="collapsed" desc="skipTemporaryBindingsNoOpCastsAndParens">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 2494,
 FQN="skipTemporaryBindingsNoOpCastsAndParens", NM="_ZL39skipTemporaryBindingsNoOpCastsAndParensPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZL39skipTemporaryBindingsNoOpCastsAndParensPKN5clang4ExprE")
//</editor-fold>
public static /*const*/ Expr /*P*/ skipTemporaryBindingsNoOpCastsAndParens(/*const*/ Expr /*P*/ E) {
  {
    /*const*/ MaterializeTemporaryExpr /*P*/ M = dyn_cast_MaterializeTemporaryExpr(E);
    if ((M != null)) {
      E = M.GetTemporaryExpr();
    }
  }
  {
    
    /*const*/ ImplicitCastExpr /*P*/ ICE;
    while (((/*P*/ ICE = dyn_cast_ImplicitCastExpr(E)) != null)) {
      if (ICE.getCastKind() == CastKind.CK_NoOp) {
        E = ICE.getSubExpr$Const();
      } else {
        break;
      }
    }
  }
  {
    
    /*const*/ CXXBindTemporaryExpr /*P*/ BE;
    while (((/*P*/ BE = dyn_cast_CXXBindTemporaryExpr(E)) != null)) {
      E = BE.getSubExpr$Const();
    }
  }
  {
    
    /*const*/ ImplicitCastExpr /*P*/ ICE$1;
    while (((/*P*/ ICE$1 = dyn_cast_ImplicitCastExpr(E)) != null)) {
      if (ICE$1.getCastKind() == CastKind.CK_NoOp) {
        E = ICE$1.getSubExpr$Const();
      } else {
        break;
      }
    }
  }
  
  return E.IgnoreParens$Const();
}

} // END OF class ExprStatics
