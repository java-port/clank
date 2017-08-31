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

package org.clang.ast;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// \brief Represents a C++ pseudo-destructor (C++ [expr.pseudo]).
///
/// A pseudo-destructor is an expression that looks like a member access to a
/// destructor of a scalar type, except that scalar types don't have
/// destructors. For example:
///
/// \code
/// typedef int T;
/// void f(int *p) {
///   p->T::~T();
/// }
/// \endcode
///
/// Pseudo-destructors typically occur when instantiating templates such as:
///
/// \code
/// template<typename T>
/// void destroy(T* ptr) {
///   ptr->T::~T();
/// }
/// \endcode
///
/// for scalar types. A pseudo-destructor expression has no run-time semantics
/// beyond evaluating the base expression.
//<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2129,
 FQN="clang::CXXPseudoDestructorExpr", NM="_ZN5clang23CXXPseudoDestructorExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang23CXXPseudoDestructorExprE")
//</editor-fold>
public class CXXPseudoDestructorExpr extends /*public*/ Expr {
  /// \brief The base expression (that is being destroyed).
  /*friend*/public Stmt /*P*/ Base;
  
  /// \brief Whether the operator was an arrow ('->'); otherwise, it was a
  /// period ('.').
  /*friend*/public /*JBIT bool*/ boolean IsArrow /*: 1*/;
  
  /// \brief The location of the '.' or '->' operator.
  /*friend*/public SourceLocation OperatorLoc;
  
  /// \brief The nested-name-specifier that follows the operator, if present.
  /*friend*/public NestedNameSpecifierLoc QualifierLoc;
  
  /// \brief The type that precedes the '::' in a qualified pseudo-destructor
  /// expression.
  /*friend*/public TypeSourceInfo /*P*/ ScopeType;
  
  /// \brief The location of the '::' in a qualified pseudo-destructor
  /// expression.
  /*friend*/public SourceLocation ColonColonLoc;
  
  /// \brief The location of the '~'.
  /*friend*/public SourceLocation TildeLoc;
  
  /// \brief The type being destroyed, or its name if we were unable to
  /// resolve the name.
  private PseudoDestructorTypeStorage DestroyedType;
  
  /*friend  class ASTStmtReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::CXXPseudoDestructorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 162,
   FQN="clang::CXXPseudoDestructorExpr::CXXPseudoDestructorExpr", NM="_ZN5clang23CXXPseudoDestructorExprC1ERKNS_10ASTContextEPNS_4ExprEbNS_14SourceLocationENS_22NestedNameSpecifierLocEPNS_14TypeSourceInfoES6_S6_NS_27PseudoDestructorTypeStorageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang23CXXPseudoDestructorExprC1ERKNS_10ASTContextEPNS_4ExprEbNS_14SourceLocationENS_22NestedNameSpecifierLocEPNS_14TypeSourceInfoES6_S6_NS_27PseudoDestructorTypeStorageE")
  //</editor-fold>
  public CXXPseudoDestructorExpr(final /*const*/ ASTContext /*&*/ Context, 
      Expr /*P*/ Base, boolean isArrow, SourceLocation OperatorLoc, 
      NestedNameSpecifierLoc QualifierLoc, TypeSourceInfo /*P*/ ScopeType, 
      SourceLocation ColonColonLoc, SourceLocation TildeLoc, 
      PseudoDestructorTypeStorage DestroyedType) {
    // : Expr(CXXPseudoDestructorExprClass, Context.BoundMemberTy.operator QualType(), VK_RValue, OK_Ordinary, /*isTypeDependent=*/ (Base->isTypeDependent() || (DestroyedType.getTypeSourceInfo() && DestroyedType.getTypeSourceInfo()->getType()->isDependentType())), /*isValueDependent=*/ Base->isValueDependent(), (Base->isInstantiationDependent() || (QualifierLoc.operator bool() && QualifierLoc.getNestedNameSpecifier()->isInstantiationDependent()) || (ScopeType && ScopeType->getType()->isInstantiationDependentType()) || (DestroyedType.getTypeSourceInfo() && DestroyedType.getTypeSourceInfo()->getType()->isInstantiationDependentType())), (Base->containsUnexpandedParameterPack() || (QualifierLoc.operator bool() && QualifierLoc.getNestedNameSpecifier()->containsUnexpandedParameterPack()) || (ScopeType && ScopeType->getType()->containsUnexpandedParameterPack()) || (DestroyedType.getTypeSourceInfo() && DestroyedType.getTypeSourceInfo()->getType()->containsUnexpandedParameterPack()))), Base(static_cast<Stmt * >(Base)), IsArrow(isArrow), OperatorLoc(OperatorLoc), QualifierLoc(QualifierLoc), ScopeType(ScopeType), ColonColonLoc(ColonColonLoc), TildeLoc(TildeLoc), DestroyedType(DestroyedType) 
    //START JInit
    super(StmtClass.CXXPseudoDestructorExprClass, 
        Context.BoundMemberTy.$QualType(), 
        ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
        (Base.isTypeDependent()
           || ((DestroyedType.getTypeSourceInfo() != null)
           && DestroyedType.getTypeSourceInfo().getType().$arrow().isDependentType())), 
        Base.isValueDependent(), 
        (Base.isInstantiationDependent()
           || (QualifierLoc.$bool()
           && QualifierLoc.getNestedNameSpecifier().isInstantiationDependent())
           || ((ScopeType != null)
           && ScopeType.getType().$arrow().isInstantiationDependentType())
           || ((DestroyedType.getTypeSourceInfo() != null)
           && DestroyedType.getTypeSourceInfo().getType().$arrow().
            isInstantiationDependentType())), 
        // ContainsUnexpandedParameterPack
        (Base.containsUnexpandedParameterPack()
           || (QualifierLoc.$bool()
           && QualifierLoc.getNestedNameSpecifier().
            containsUnexpandedParameterPack())
           || ((ScopeType != null)
           && ScopeType.getType().$arrow().containsUnexpandedParameterPack())
           || ((DestroyedType.getTypeSourceInfo() != null)
           && DestroyedType.getTypeSourceInfo().getType().$arrow().
            containsUnexpandedParameterPack())));
    this.Base = ((/*static_cast*/Stmt /*P*/ )(Base));
    this.IsArrow = isArrow;
    this.OperatorLoc = new SourceLocation(OperatorLoc);
    this.QualifierLoc = new NestedNameSpecifierLoc(QualifierLoc);
    this.ScopeType = ScopeType;
    this.ColonColonLoc = new SourceLocation(ColonColonLoc);
    this.TildeLoc = new SourceLocation(TildeLoc);
    this.DestroyedType = new PseudoDestructorTypeStorage(DestroyedType);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::CXXPseudoDestructorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2169,
   FQN="clang::CXXPseudoDestructorExpr::CXXPseudoDestructorExpr", NM="_ZN5clang23CXXPseudoDestructorExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang23CXXPseudoDestructorExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ CXXPseudoDestructorExpr(EmptyShell Shell) {
    // : Expr(CXXPseudoDestructorExprClass, Shell), Base(null), IsArrow(false), OperatorLoc(), QualifierLoc(), ScopeType(null), ColonColonLoc(), TildeLoc(), DestroyedType() 
    //START JInit
    super(StmtClass.CXXPseudoDestructorExprClass, new EmptyShell(Shell));
    this.Base = null;
    this.IsArrow = false;
    this.OperatorLoc = new SourceLocation();
    this.QualifierLoc = new NestedNameSpecifierLoc();
    this.ScopeType = null;
    this.ColonColonLoc = new SourceLocation();
    this.TildeLoc = new SourceLocation();
    this.DestroyedType = new PseudoDestructorTypeStorage();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2173,
   FQN="clang::CXXPseudoDestructorExpr::getBase", NM="_ZNK5clang23CXXPseudoDestructorExpr7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23CXXPseudoDestructorExpr7getBaseEv")
  //</editor-fold>
  public Expr /*P*/ getBase() /*const*/ {
    return cast_Expr(Base);
  }

  
  /// \brief Determines whether this member expression actually had
  /// a C++ nested-name-specifier prior to the name of the member, e.g.,
  /// x->Base::foo.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::hasQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2178,
   FQN="clang::CXXPseudoDestructorExpr::hasQualifier", NM="_ZNK5clang23CXXPseudoDestructorExpr12hasQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23CXXPseudoDestructorExpr12hasQualifierEv")
  //</editor-fold>
  public boolean hasQualifier() /*const*/ {
    return QualifierLoc.hasQualifier();
  }

  
  /// \brief Retrieves the nested-name-specifier that qualifies the type name,
  /// with source-location information.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::getQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2182,
   FQN="clang::CXXPseudoDestructorExpr::getQualifierLoc", NM="_ZNK5clang23CXXPseudoDestructorExpr15getQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23CXXPseudoDestructorExpr15getQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getQualifierLoc() /*const*/ {
    return new NestedNameSpecifierLoc(QualifierLoc);
  }

  
  /// \brief If the member name was qualified, retrieves the
  /// nested-name-specifier that precedes the member name. Otherwise, returns
  /// null.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::getQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2187,
   FQN="clang::CXXPseudoDestructorExpr::getQualifier", NM="_ZNK5clang23CXXPseudoDestructorExpr12getQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23CXXPseudoDestructorExpr12getQualifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getQualifier() /*const*/ {
    return QualifierLoc.getNestedNameSpecifier();
  }

  
  /// \brief Determine whether this pseudo-destructor expression was written
  /// using an '->' (otherwise, it used a '.').
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::isArrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2193,
   FQN="clang::CXXPseudoDestructorExpr::isArrow", NM="_ZNK5clang23CXXPseudoDestructorExpr7isArrowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23CXXPseudoDestructorExpr7isArrowEv")
  //</editor-fold>
  public boolean isArrow() /*const*/ {
    return IsArrow;
  }

  
  /// \brief Retrieve the location of the '.' or '->' operator.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::getOperatorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2196,
   FQN="clang::CXXPseudoDestructorExpr::getOperatorLoc", NM="_ZNK5clang23CXXPseudoDestructorExpr14getOperatorLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23CXXPseudoDestructorExpr14getOperatorLocEv")
  //</editor-fold>
  public SourceLocation getOperatorLoc() /*const*/ {
    return new SourceLocation(OperatorLoc);
  }

  
  /// \brief Retrieve the scope type in a qualified pseudo-destructor
  /// expression.
  ///
  /// Pseudo-destructor expressions can have extra qualification within them
  /// that is not part of the nested-name-specifier, e.g., \c p->T::~T().
  /// Here, if the object type of the expression is (or may be) a scalar type,
  /// \p T may also be a scalar type and, therefore, cannot be part of a
  /// nested-name-specifier. It is stored as the "scope type" of the pseudo-
  /// destructor expression.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::getScopeTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2207,
   FQN="clang::CXXPseudoDestructorExpr::getScopeTypeInfo", NM="_ZNK5clang23CXXPseudoDestructorExpr16getScopeTypeInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23CXXPseudoDestructorExpr16getScopeTypeInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getScopeTypeInfo() /*const*/ {
    return ScopeType;
  }

  
  /// \brief Retrieve the location of the '::' in a qualified pseudo-destructor
  /// expression.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::getColonColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2211,
   FQN="clang::CXXPseudoDestructorExpr::getColonColonLoc", NM="_ZNK5clang23CXXPseudoDestructorExpr16getColonColonLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23CXXPseudoDestructorExpr16getColonColonLocEv")
  //</editor-fold>
  public SourceLocation getColonColonLoc() /*const*/ {
    return new SourceLocation(ColonColonLoc);
  }

  
  /// \brief Retrieve the location of the '~'.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::getTildeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2214,
   FQN="clang::CXXPseudoDestructorExpr::getTildeLoc", NM="_ZNK5clang23CXXPseudoDestructorExpr11getTildeLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23CXXPseudoDestructorExpr11getTildeLocEv")
  //</editor-fold>
  public SourceLocation getTildeLoc() /*const*/ {
    return new SourceLocation(TildeLoc);
  }

  
  /// \brief Retrieve the source location information for the type
  /// being destroyed.
  ///
  /// This type-source information is available for non-dependent
  /// pseudo-destructor expressions and some dependent pseudo-destructor
  /// expressions. Returns null if we only have the identifier for a
  /// dependent pseudo-destructor expression.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::getDestroyedTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2223,
   FQN="clang::CXXPseudoDestructorExpr::getDestroyedTypeInfo", NM="_ZNK5clang23CXXPseudoDestructorExpr20getDestroyedTypeInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23CXXPseudoDestructorExpr20getDestroyedTypeInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getDestroyedTypeInfo() /*const*/ {
    return DestroyedType.getTypeSourceInfo();
  }

  
  /// \brief In a dependent pseudo-destructor expression for which we do not
  /// have full type information on the destroyed type, provides the name
  /// of the destroyed type.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::getDestroyedTypeIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2230,
   FQN="clang::CXXPseudoDestructorExpr::getDestroyedTypeIdentifier", NM="_ZNK5clang23CXXPseudoDestructorExpr26getDestroyedTypeIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23CXXPseudoDestructorExpr26getDestroyedTypeIdentifierEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getDestroyedTypeIdentifier() /*const*/ {
    return DestroyedType.getIdentifier();
  }

  
  /// \brief Retrieve the type being destroyed.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::getDestroyedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 197,
   FQN="clang::CXXPseudoDestructorExpr::getDestroyedType", NM="_ZNK5clang23CXXPseudoDestructorExpr16getDestroyedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23CXXPseudoDestructorExpr16getDestroyedTypeEv")
  //</editor-fold>
  public QualType getDestroyedType() /*const*/ {
    {
      TypeSourceInfo /*P*/ TInfo = DestroyedType.getTypeSourceInfo();
      if ((TInfo != null)) {
        return TInfo.getType();
      }
    }
    
    return new QualType();
  }

  
  /// \brief Retrieve the starting location of the type being destroyed.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::getDestroyedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2238,
   FQN="clang::CXXPseudoDestructorExpr::getDestroyedTypeLoc", NM="_ZNK5clang23CXXPseudoDestructorExpr19getDestroyedTypeLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23CXXPseudoDestructorExpr19getDestroyedTypeLocEv")
  //</editor-fold>
  public SourceLocation getDestroyedTypeLoc() /*const*/ {
    return DestroyedType.getLocation();
  }

  
  /// \brief Set the name of destroyed type for a dependent pseudo-destructor
  /// expression.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::setDestroyedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2244,
   FQN="clang::CXXPseudoDestructorExpr::setDestroyedType", NM="_ZN5clang23CXXPseudoDestructorExpr16setDestroyedTypeEPNS_14IdentifierInfoENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang23CXXPseudoDestructorExpr16setDestroyedTypeEPNS_14IdentifierInfoENS_14SourceLocationE")
  //</editor-fold>
  public void setDestroyedType(IdentifierInfo /*P*/ II, SourceLocation Loc) {
    DestroyedType.$assignMove(new PseudoDestructorTypeStorage(II, new SourceLocation(Loc)));
  }

  
  /// \brief Set the destroyed type.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::setDestroyedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2249,
   FQN="clang::CXXPseudoDestructorExpr::setDestroyedType", NM="_ZN5clang23CXXPseudoDestructorExpr16setDestroyedTypeEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang23CXXPseudoDestructorExpr16setDestroyedTypeEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setDestroyedType(TypeSourceInfo /*P*/ Info) {
    DestroyedType.$assignMove(new PseudoDestructorTypeStorage(Info));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2253,
   FQN="clang::CXXPseudoDestructorExpr::getLocStart", NM="_ZNK5clang23CXXPseudoDestructorExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23CXXPseudoDestructorExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return Base.getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 204,
   FQN="clang::CXXPseudoDestructorExpr::getLocEnd", NM="_ZNK5clang23CXXPseudoDestructorExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23CXXPseudoDestructorExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    SourceLocation End = DestroyedType.getLocation();
    {
      TypeSourceInfo /*P*/ TInfo = DestroyedType.getTypeSourceInfo();
      if ((TInfo != null)) {
        End.$assignMove(TInfo.getTypeLoc().getLocalSourceRange().getEnd());
      }
    }
    return End;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2256,
   FQN="clang::CXXPseudoDestructorExpr::classof", NM="_ZN5clang23CXXPseudoDestructorExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang23CXXPseudoDestructorExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXPseudoDestructorExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CXXPseudoDestructorExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2261,
   FQN="clang::CXXPseudoDestructorExpr::children", NM="_ZN5clang23CXXPseudoDestructorExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang23CXXPseudoDestructorExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Base))), new StmtIterator(create_type$ptr($AddrOf(Base)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "Base=" + Base // NOI18N
              + ", IsArrow=" + IsArrow // NOI18N
              + ", OperatorLoc=" + OperatorLoc // NOI18N
              + ", QualifierLoc=" + QualifierLoc // NOI18N
              + ", ScopeType=" + ScopeType // NOI18N
              + ", ColonColonLoc=" + ColonColonLoc // NOI18N
              + ", TildeLoc=" + TildeLoc // NOI18N
              + ", DestroyedType=" + DestroyedType // NOI18N
              + super.toString(); // NOI18N
  }
}
