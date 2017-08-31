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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.impl.ExprClassificationStatics.*;
import static org.clang.ast.impl.ExprConstantStatics.*;
import static org.clang.ast.impl.ExprStatics.*;
import org.clang.basic.java.OptionalNotes;


/// Expr - This represents one expression.  Note that Expr's are subclasses of
/// Stmt.  This allows an expression to be transparently used any place a Stmt
/// is required.
///
//<editor-fold defaultstate="collapsed" desc="clang::Expr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 105,
 FQN="clang::Expr", NM="_ZN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4ExprE")
//</editor-fold>
public class Expr extends /*public*/ Stmt {
  private QualType TR;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::Expr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 109,
   FQN="clang::Expr::Expr", NM="_ZN5clang4ExprC1ENS_4Stmt9StmtClassENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindEbbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4ExprC1ENS_4Stmt9StmtClassENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindEbbbb")
  //</editor-fold>
  protected Expr(StmtClass SC, QualType T, ExprValueKind VK, ExprObjectKind OK, 
      boolean TD, boolean VD, boolean ID, boolean ContainsUnexpandedParameterPack) {
    // : Stmt(SC), TR() 
    //START JInit
    super(SC);
    this.TR = new QualType();
    //END JInit
    Unnamed_field.ExprBits.TypeDependent = TD;
    Unnamed_field.ExprBits.ValueDependent = VD;
    Unnamed_field.ExprBits.InstantiationDependent = ID;
    Unnamed_field.ExprBits.ValueKind = $uint2uint_2bits(VK.getValue());
    Unnamed_field.ExprBits.ObjectKind = $uint2uint_3bits(OK.getValue());
    Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = ContainsUnexpandedParameterPack;
    setType(new QualType(T));
  }

  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  public Expr() {
  }

  /// \brief Construct an empty expression.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::Expr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 123,
   FQN="clang::Expr::Expr", NM="_ZN5clang4ExprC1ENS_4Stmt9StmtClassENS1_10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4ExprC1ENS_4Stmt9StmtClassENS1_10EmptyShellE")
  //</editor-fold>
  protected /*explicit*/ Expr(StmtClass SC, EmptyShell $Prm1) {
    // : Stmt(SC), TR() 
    //START JInit
    super(SC);
    this.TR = new QualType();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 126,
   FQN="clang::Expr::getType", NM="_ZNK5clang4Expr7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr7getTypeEv")
  //</editor-fold>
  public QualType getType() /*const*/ {
    return new QualType(TR);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Expr::setType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 127,
   FQN="clang::Expr::setType", NM="_ZN5clang4Expr7setTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr7setTypeENS_8QualTypeE")
  //</editor-fold>
  public void setType(QualType t) {
    // In C++, the type of an expression is always adjusted so that it
    // will not have reference type (C++ [expr]p6). Use
    // QualType::getNonReferenceType() to retrieve the non-reference
    // type. Additionally, inspect Expr::isLvalue to determine whether
    // an expression that is adjusted in this manner should be
    // considered an lvalue.
    assert ((t.isNull() || !t.$arrow().isReferenceType())) : "Expressions can't have reference type";
    
    TR.$assign(t);
  }

  
  /// isValueDependent - Determines whether this expression is
  /// value-dependent (C++ [temp.dep.constexpr]). For example, the
  /// array bound of "Chars" in the following example is
  /// value-dependent.
  /// @code
  /// template<int Size, char (&Chars)[Size]> struct meta_string;
  /// @endcode
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isValueDependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 147,
   FQN="clang::Expr::isValueDependent", NM="_ZNK5clang4Expr16isValueDependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr16isValueDependentEv")
  //</editor-fold>
  public boolean isValueDependent() /*const*/ {
    return Unnamed_field.ExprBits.ValueDependent;
  }

  
  /// \brief Set whether this expression is value-dependent or not.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::setValueDependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 150,
   FQN="clang::Expr::setValueDependent", NM="_ZN5clang4Expr17setValueDependentEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr17setValueDependentEb")
  //</editor-fold>
  public void setValueDependent(boolean VD) {
    Unnamed_field.ExprBits.ValueDependent = VD;
  }

  
  /// isTypeDependent - Determines whether this expression is
  /// type-dependent (C++ [temp.dep.expr]), which means that its type
  /// could change from one template instantiation to the next. For
  /// example, the expressions "x" and "x + y" are type-dependent in
  /// the following code, but "y" is not type-dependent:
  /// @code
  /// template<typename T>
  /// void add(T x, int y) {
  ///   x + y;
  /// }
  /// @endcode
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isTypeDependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 165,
   FQN="clang::Expr::isTypeDependent", NM="_ZNK5clang4Expr15isTypeDependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr15isTypeDependentEv")
  //</editor-fold>
  public boolean isTypeDependent() /*const*/ {
    return Unnamed_field.ExprBits.TypeDependent;
  }

  
  /// \brief Set whether this expression is type-dependent or not.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::setTypeDependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 168,
   FQN="clang::Expr::setTypeDependent", NM="_ZN5clang4Expr16setTypeDependentEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr16setTypeDependentEb")
  //</editor-fold>
  public void setTypeDependent(boolean TD) {
    Unnamed_field.ExprBits.TypeDependent = TD;
  }

  
  /// \brief Whether this expression is instantiation-dependent, meaning that
  /// it depends in some way on a template parameter, even if neither its type
  /// nor (constant) value can change due to the template instantiation.
  ///
  /// In the following example, the expression \c sizeof(sizeof(T() + T())) is
  /// instantiation-dependent (since it involves a template parameter \c T), but
  /// is neither type- nor value-dependent, since the type of the inner
  /// \c sizeof is known (\c std::size_t) and therefore the size of the outer
  /// \c sizeof is known.
  ///
  /// \code
  /// template<typename T>
  /// void f(T x, T y) {
  ///   sizeof(sizeof(T() + T());
  /// }
  /// \endcode
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isInstantiationDependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 189,
   FQN="clang::Expr::isInstantiationDependent", NM="_ZNK5clang4Expr24isInstantiationDependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr24isInstantiationDependentEv")
  //</editor-fold>
  public boolean isInstantiationDependent() /*const*/ {
    return Unnamed_field.ExprBits.InstantiationDependent;
  }

  
  /// \brief Set whether this expression is instantiation-dependent or not.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::setInstantiationDependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 194,
   FQN="clang::Expr::setInstantiationDependent", NM="_ZN5clang4Expr25setInstantiationDependentEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr25setInstantiationDependentEb")
  //</editor-fold>
  public void setInstantiationDependent(boolean ID) {
    Unnamed_field.ExprBits.InstantiationDependent = ID;
  }

  
  /// \brief Whether this expression contains an unexpanded parameter
  /// pack (for C++11 variadic templates).
  ///
  /// Given the following function template:
  ///
  /// \code
  /// template<typename F, typename ...Types>
  /// void forward(const F &f, Types &&...args) {
  ///   f(static_cast<Types&&>(args)...);
  /// }
  /// \endcode
  ///
  /// The expressions \c args and \c static_cast<Types&&>(args) both
  /// contain parameter packs.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::containsUnexpandedParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 212,
   FQN="clang::Expr::containsUnexpandedParameterPack", NM="_ZNK5clang4Expr31containsUnexpandedParameterPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr31containsUnexpandedParameterPackEv")
  //</editor-fold>
  public boolean containsUnexpandedParameterPack() /*const*/ {
    return Unnamed_field.ExprBits.ContainsUnexpandedParameterPack;
  }

  
  /// \brief Set the bit that describes whether this expression
  /// contains an unexpanded parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::setContainsUnexpandedParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 218,
   FQN="clang::Expr::setContainsUnexpandedParameterPack", NM="_ZN5clang4Expr34setContainsUnexpandedParameterPackEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr34setContainsUnexpandedParameterPackEb")
  //</editor-fold>
  public void setContainsUnexpandedParameterPack() {
    setContainsUnexpandedParameterPack(true);
  }
  public void setContainsUnexpandedParameterPack(boolean PP/*= true*/) {
    Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = PP;
  }

  
  /// getExprLoc - Return the preferred location for the arrow when diagnosing
  /// a problem with a generic expression.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::getExprLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 193,
   FQN="clang::Expr::getExprLoc", NM="_ZNK5clang4Expr10getExprLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr10getExprLocEv")
  //</editor-fold>
  public SourceLocation getExprLoc() /*const*//* __attribute__((pure))*/ {
    switch (getStmtClass()) {
     case NoStmtClass:
      throw new llvm_unreachable("statement without class");
     case GCCAsmStmtClass:
      break;
     case MSAsmStmtClass:
      break;
     case AttributedStmtClass:
      break;
     case BreakStmtClass:
      break;
     case CXXCatchStmtClass:
      break;
     case CXXForRangeStmtClass:
      break;
     case CXXTryStmtClass:
      break;
     case CapturedStmtClass:
      break;
     case CompoundStmtClass:
      break;
     case ContinueStmtClass:
      break;
     case CoreturnStmtClass:
      break;
     case CoroutineBodyStmtClass:
      break;
     case DeclStmtClass:
      break;
     case DoStmtClass:
      break;
     case BinaryConditionalOperatorClass:
      return ExprStatics.<BinaryConditionalOperator>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/BinaryConditionalOperator::getExprLoc);
     case ConditionalOperatorClass:
      return ExprStatics.<ConditionalOperator>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ConditionalOperator::getExprLoc);
     case AddrLabelExprClass:
      return ExprStatics.<AddrLabelExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/AddrLabelExpr::getExprLoc);
     case ArraySubscriptExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return ExprStatics.<ArraySubscriptExpr>getExprLocImpl$getExprLoc(this, /*AddrOf*//*FPtr*/ArraySubscriptExpr::getExprLoc);
     case ArrayTypeTraitExprClass:
      return ExprStatics.<ArrayTypeTraitExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ArrayTypeTraitExpr::getExprLoc);
     case AsTypeExprClass:
      return ExprStatics.<AsTypeExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/AsTypeExpr::getExprLoc);
     case AtomicExprClass:
      return ExprStatics.<AtomicExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/AtomicExpr::getExprLoc);
     case BinaryOperatorClass:
      if(true)throw new ClassCastException("Cannot be here");
      return ExprStatics.<BinaryOperator>getExprLocImpl$getExprLoc(this, /*AddrOf*//*FPtr*/BinaryOperator::getExprLoc);
     case CompoundAssignOperatorClass:
      if(true)throw new ClassCastException("Cannot be here");
      return ExprStatics.<CompoundAssignOperator>getExprLocImpl$getExprLoc(this, /*AddrOf*//*FPtr*/CompoundAssignOperator::getExprLoc);
     case BlockExprClass:
      return ExprStatics.<BlockExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/BlockExpr::getExprLoc);
     case CXXBindTemporaryExprClass:
      return ExprStatics.<CXXBindTemporaryExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXBindTemporaryExpr::getExprLoc);
     case CXXBoolLiteralExprClass:
      return ExprStatics.<CXXBoolLiteralExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXBoolLiteralExpr::getExprLoc);
     case CXXConstructExprClass:
      return ExprStatics.<CXXConstructExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXConstructExpr::getExprLoc);
     case CXXTemporaryObjectExprClass:
      return ExprStatics.<CXXTemporaryObjectExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXTemporaryObjectExpr::getExprLoc);
     case CXXDefaultArgExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return ExprStatics.<CXXDefaultArgExpr>getExprLocImpl$getExprLoc(this, /*AddrOf*//*FPtr*/CXXDefaultArgExpr::getExprLoc);
     case CXXDefaultInitExprClass:
      return ExprStatics.<CXXDefaultInitExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXDefaultInitExpr::getExprLoc);
     case CXXDeleteExprClass:
      return ExprStatics.<CXXDeleteExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXDeleteExpr::getExprLoc);
     case CXXDependentScopeMemberExprClass:
      return ExprStatics.<CXXDependentScopeMemberExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXDependentScopeMemberExpr::getExprLoc);
     case CXXFoldExprClass:
      return ExprStatics.<CXXFoldExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXFoldExpr::getExprLoc);
     case CXXInheritedCtorInitExprClass:
      return ExprStatics.<CXXInheritedCtorInitExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXInheritedCtorInitExpr::getExprLoc);
     case CXXNewExprClass:
      return ExprStatics.<CXXNewExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXNewExpr::getExprLoc);
     case CXXNoexceptExprClass:
      return ExprStatics.<CXXNoexceptExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXNoexceptExpr::getExprLoc);
     case CXXNullPtrLiteralExprClass:
      return ExprStatics.<CXXNullPtrLiteralExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXNullPtrLiteralExpr::getExprLoc);
     case CXXPseudoDestructorExprClass:
      return ExprStatics.<CXXPseudoDestructorExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXPseudoDestructorExpr::getExprLoc);
     case CXXScalarValueInitExprClass:
      return ExprStatics.<CXXScalarValueInitExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXScalarValueInitExpr::getExprLoc);
     case CXXStdInitializerListExprClass:
      return ExprStatics.<CXXStdInitializerListExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXStdInitializerListExpr::getExprLoc);
     case CXXThisExprClass:
      return ExprStatics.<CXXThisExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXThisExpr::getExprLoc);
     case CXXThrowExprClass:
      return ExprStatics.<CXXThrowExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXThrowExpr::getExprLoc);
     case CXXTypeidExprClass:
      return ExprStatics.<CXXTypeidExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXTypeidExpr::getExprLoc);
     case CXXUnresolvedConstructExprClass:
      return ExprStatics.<CXXUnresolvedConstructExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXUnresolvedConstructExpr::getExprLoc);
     case CXXUuidofExprClass:
      return ExprStatics.<CXXUuidofExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXUuidofExpr::getExprLoc);
     case CallExprClass:
      return ExprStatics.<CallExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CallExpr::getExprLoc);
     case CUDAKernelCallExprClass:
      return ExprStatics.<CUDAKernelCallExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CUDAKernelCallExpr::getExprLoc);
     case CXXMemberCallExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return ExprStatics.<CXXMemberCallExpr>getExprLocImpl$getExprLoc(this, /*AddrOf*//*FPtr*/CXXMemberCallExpr::getExprLoc);
     case CXXOperatorCallExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return ExprStatics.<CXXOperatorCallExpr>getExprLocImpl$getExprLoc(this, /*AddrOf*//*FPtr*/CXXOperatorCallExpr::getExprLoc);
     case UserDefinedLiteralClass:
      return ExprStatics.<UserDefinedLiteral>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/UserDefinedLiteral::getExprLoc);
     case CStyleCastExprClass:
      return ExprStatics.<CStyleCastExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CStyleCastExpr::getExprLoc);
     case CXXFunctionalCastExprClass:
      return ExprStatics.<CXXFunctionalCastExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXFunctionalCastExpr::getExprLoc);
     case CXXConstCastExprClass:
      return ExprStatics.<CXXConstCastExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXConstCastExpr::getExprLoc);
     case CXXDynamicCastExprClass:
      return ExprStatics.<CXXDynamicCastExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXDynamicCastExpr::getExprLoc);
     case CXXReinterpretCastExprClass:
      return ExprStatics.<CXXReinterpretCastExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXReinterpretCastExpr::getExprLoc);
     case CXXStaticCastExprClass:
      return ExprStatics.<CXXStaticCastExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CXXStaticCastExpr::getExprLoc);
     case ObjCBridgedCastExprClass:
      return ExprStatics.<ObjCBridgedCastExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ObjCBridgedCastExpr::getExprLoc);
     case ImplicitCastExprClass:
      return ExprStatics.<ImplicitCastExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ImplicitCastExpr::getExprLoc);
     case CharacterLiteralClass:
      return ExprStatics.<CharacterLiteral>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CharacterLiteral::getExprLoc);
     case ChooseExprClass:
      return ExprStatics.<ChooseExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ChooseExpr::getExprLoc);
     case CompoundLiteralExprClass:
      return ExprStatics.<CompoundLiteralExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CompoundLiteralExpr::getExprLoc);
     case ConvertVectorExprClass:
      return ExprStatics.<ConvertVectorExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ConvertVectorExpr::getExprLoc);
     case CoawaitExprClass:
      return ExprStatics.<CoawaitExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CoawaitExpr::getExprLoc);
     case CoyieldExprClass:
      return ExprStatics.<CoyieldExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/CoyieldExpr::getExprLoc);
     case DeclRefExprClass:
      return ExprStatics.<DeclRefExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/DeclRefExpr::getExprLoc);
     case DependentScopeDeclRefExprClass:
      return ExprStatics.<DependentScopeDeclRefExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/DependentScopeDeclRefExpr::getExprLoc);
     case DesignatedInitExprClass:
      return ExprStatics.<DesignatedInitExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/DesignatedInitExpr::getExprLoc);
     case DesignatedInitUpdateExprClass:
      return ExprStatics.<DesignatedInitUpdateExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/DesignatedInitUpdateExpr::getExprLoc);
     case ExprWithCleanupsClass:
      return ExprStatics.<ExprWithCleanups>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ExprWithCleanups::getExprLoc);
     case ExpressionTraitExprClass:
      return ExprStatics.<ExpressionTraitExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ExpressionTraitExpr::getExprLoc);
     case ExtVectorElementExprClass:
      return ExprStatics.<ExtVectorElementExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ExtVectorElementExpr::getExprLoc);
     case FloatingLiteralClass:
      return ExprStatics.<FloatingLiteral>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/FloatingLiteral::getExprLoc);
     case FunctionParmPackExprClass:
      return ExprStatics.<FunctionParmPackExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/FunctionParmPackExpr::getExprLoc);
     case GNUNullExprClass:
      return ExprStatics.<GNUNullExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/GNUNullExpr::getExprLoc);
     case GenericSelectionExprClass:
      return ExprStatics.<GenericSelectionExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/GenericSelectionExpr::getExprLoc);
     case ImaginaryLiteralClass:
      return ExprStatics.<ImaginaryLiteral>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ImaginaryLiteral::getExprLoc);
     case ImplicitValueInitExprClass:
      return ExprStatics.<ImplicitValueInitExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ImplicitValueInitExpr::getExprLoc);
     case InitListExprClass:
      return ExprStatics.<InitListExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/InitListExpr::getExprLoc);
     case IntegerLiteralClass:
      return ExprStatics.<IntegerLiteral>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/IntegerLiteral::getExprLoc);
     case LambdaExprClass:
      return ExprStatics.<LambdaExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/LambdaExpr::getExprLoc);
     case MSPropertyRefExprClass:
      return ExprStatics.<MSPropertyRefExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/MSPropertyRefExpr::getExprLoc);
     case MSPropertySubscriptExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return ExprStatics.<MSPropertySubscriptExpr>getExprLocImpl$getExprLoc(this, /*AddrOf*//*FPtr*/MSPropertySubscriptExpr::getExprLoc);
     case MaterializeTemporaryExprClass:
      return ExprStatics.<MaterializeTemporaryExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/MaterializeTemporaryExpr::getExprLoc);
     case MemberExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return ExprStatics.<MemberExpr>getExprLocImpl$getExprLoc(this, /*AddrOf*//*FPtr*/MemberExpr::getExprLoc);
     case NoInitExprClass:
      return ExprStatics.<NoInitExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/NoInitExpr::getExprLoc);
     case OMPArraySectionExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return ExprStatics.<OMPArraySectionExpr>getExprLocImpl$getExprLoc(this, /*AddrOf*//*FPtr*/OMPArraySectionExpr::getExprLoc);
     case ObjCArrayLiteralClass:
      return ExprStatics.<ObjCArrayLiteral>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ObjCArrayLiteral::getExprLoc);
     case ObjCAvailabilityCheckExprClass:
      return ExprStatics.<ObjCAvailabilityCheckExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ObjCAvailabilityCheckExpr::getExprLoc);
     case ObjCBoolLiteralExprClass:
      return ExprStatics.<ObjCBoolLiteralExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ObjCBoolLiteralExpr::getExprLoc);
     case ObjCBoxedExprClass:
      return ExprStatics.<ObjCBoxedExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ObjCBoxedExpr::getExprLoc);
     case ObjCDictionaryLiteralClass:
      return ExprStatics.<ObjCDictionaryLiteral>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ObjCDictionaryLiteral::getExprLoc);
     case ObjCEncodeExprClass:
      return ExprStatics.<ObjCEncodeExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ObjCEncodeExpr::getExprLoc);
     case ObjCIndirectCopyRestoreExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return ExprStatics.<ObjCIndirectCopyRestoreExpr>getExprLocImpl$getExprLoc(this, /*AddrOf*//*FPtr*/ObjCIndirectCopyRestoreExpr::getExprLoc);
     case ObjCIsaExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return ExprStatics.<ObjCIsaExpr>getExprLocImpl$getExprLoc(this, /*AddrOf*//*FPtr*/ObjCIsaExpr::getExprLoc);
     case ObjCIvarRefExprClass:
      return ExprStatics.<ObjCIvarRefExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ObjCIvarRefExpr::getExprLoc);
     case ObjCMessageExprClass:
      return ExprStatics.<ObjCMessageExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ObjCMessageExpr::getExprLoc);
     case ObjCPropertyRefExprClass:
      return ExprStatics.<ObjCPropertyRefExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ObjCPropertyRefExpr::getExprLoc);
     case ObjCProtocolExprClass:
      return ExprStatics.<ObjCProtocolExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ObjCProtocolExpr::getExprLoc);
     case ObjCSelectorExprClass:
      return ExprStatics.<ObjCSelectorExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ObjCSelectorExpr::getExprLoc);
     case ObjCStringLiteralClass:
      return ExprStatics.<ObjCStringLiteral>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ObjCStringLiteral::getExprLoc);
     case ObjCSubscriptRefExprClass:
      return ExprStatics.<ObjCSubscriptRefExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ObjCSubscriptRefExpr::getExprLoc);
     case OffsetOfExprClass:
      return ExprStatics.<OffsetOfExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/OffsetOfExpr::getExprLoc);
     case OpaqueValueExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return ExprStatics.<OpaqueValueExpr>getExprLocImpl$getExprLoc(this, /*AddrOf*//*FPtr*/OpaqueValueExpr::getExprLoc);
     case UnresolvedLookupExprClass:
      return ExprStatics.<UnresolvedLookupExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/UnresolvedLookupExpr::getExprLoc);
     case UnresolvedMemberExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return ExprStatics.<UnresolvedMemberExpr>getExprLocImpl$getExprLoc(this, /*AddrOf*//*FPtr*/UnresolvedMemberExpr::getExprLoc);
     case PackExpansionExprClass:
      return ExprStatics.<PackExpansionExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/PackExpansionExpr::getExprLoc);
     case ParenExprClass:
      return ExprStatics.<ParenExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ParenExpr::getExprLoc);
     case ParenListExprClass:
      return ExprStatics.<ParenListExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ParenListExpr::getExprLoc);
     case PredefinedExprClass:
      return ExprStatics.<PredefinedExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/PredefinedExpr::getExprLoc);
     case PseudoObjectExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return ExprStatics.<PseudoObjectExpr>getExprLocImpl$getExprLoc(this, /*AddrOf*//*FPtr*/PseudoObjectExpr::getExprLoc);
     case ShuffleVectorExprClass:
      return ExprStatics.<ShuffleVectorExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/ShuffleVectorExpr::getExprLoc);
     case SizeOfPackExprClass:
      return ExprStatics.<SizeOfPackExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/SizeOfPackExpr::getExprLoc);
     case StmtExprClass:
      return ExprStatics.<StmtExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/StmtExpr::getExprLoc);
     case StringLiteralClass:
      return ExprStatics.<StringLiteral>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/StringLiteral::getExprLoc);
     case SubstNonTypeTemplateParmExprClass:
      return ExprStatics.<SubstNonTypeTemplateParmExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/SubstNonTypeTemplateParmExpr::getExprLoc);
     case SubstNonTypeTemplateParmPackExprClass:
      return ExprStatics.<SubstNonTypeTemplateParmPackExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/SubstNonTypeTemplateParmPackExpr::getExprLoc);
     case TypeTraitExprClass:
      return ExprStatics.<TypeTraitExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/TypeTraitExpr::getExprLoc);
     case TypoExprClass:
      return ExprStatics.<TypoExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/TypoExpr::getExprLoc);
     case UnaryExprOrTypeTraitExprClass:
      return ExprStatics.<UnaryExprOrTypeTraitExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/UnaryExprOrTypeTraitExpr::getExprLoc);
     case UnaryOperatorClass:
      if(true)throw new ClassCastException("Cannot be here");
      return ExprStatics.<UnaryOperator>getExprLocImpl$getExprLoc(this, /*AddrOf*//*FPtr*/UnaryOperator::getExprLoc);
     case VAArgExprClass:
      return ExprStatics.<VAArgExpr>getExprLocImpl$getLocStart(this, /*AddrOf*//*FPtr*/VAArgExpr::getExprLoc);
     case ForStmtClass:
      break;
     case GotoStmtClass:
      break;
     case IfStmtClass:
      break;
     case IndirectGotoStmtClass:
      break;
     case LabelStmtClass:
      break;
     case MSDependentExistsStmtClass:
      break;
     case NullStmtClass:
      break;
     case OMPAtomicDirectiveClass:
      break;
     case OMPBarrierDirectiveClass:
      break;
     case OMPCancelDirectiveClass:
      break;
     case OMPCancellationPointDirectiveClass:
      break;
     case OMPCriticalDirectiveClass:
      break;
     case OMPFlushDirectiveClass:
      break;
     case OMPDistributeDirectiveClass:
      break;
     case OMPDistributeParallelForDirectiveClass:
      break;
     case OMPDistributeParallelForSimdDirectiveClass:
      break;
     case OMPDistributeSimdDirectiveClass:
      break;
     case OMPForDirectiveClass:
      break;
     case OMPForSimdDirectiveClass:
      break;
     case OMPParallelForDirectiveClass:
      break;
     case OMPParallelForSimdDirectiveClass:
      break;
     case OMPSimdDirectiveClass:
      break;
     case OMPTargetParallelForSimdDirectiveClass:
      break;
     case OMPTaskLoopDirectiveClass:
      break;
     case OMPTaskLoopSimdDirectiveClass:
      break;
     case OMPMasterDirectiveClass:
      break;
     case OMPOrderedDirectiveClass:
      break;
     case OMPParallelDirectiveClass:
      break;
     case OMPParallelSectionsDirectiveClass:
      break;
     case OMPSectionDirectiveClass:
      break;
     case OMPSectionsDirectiveClass:
      break;
     case OMPSingleDirectiveClass:
      break;
     case OMPTargetDataDirectiveClass:
      break;
     case OMPTargetDirectiveClass:
      break;
     case OMPTargetEnterDataDirectiveClass:
      break;
     case OMPTargetExitDataDirectiveClass:
      break;
     case OMPTargetParallelDirectiveClass:
      break;
     case OMPTargetParallelForDirectiveClass:
      break;
     case OMPTargetUpdateDirectiveClass:
      break;
     case OMPTaskDirectiveClass:
      break;
     case OMPTaskgroupDirectiveClass:
      break;
     case OMPTaskwaitDirectiveClass:
      break;
     case OMPTaskyieldDirectiveClass:
      break;
     case OMPTeamsDirectiveClass:
      break;
     case ObjCAtCatchStmtClass:
      break;
     case ObjCAtFinallyStmtClass:
      break;
     case ObjCAtSynchronizedStmtClass:
      break;
     case ObjCAtThrowStmtClass:
      break;
     case ObjCAtTryStmtClass:
      break;
     case ObjCAutoreleasePoolStmtClass:
      break;
     case ObjCForCollectionStmtClass:
      break;
     case ReturnStmtClass:
      break;
     case SEHExceptStmtClass:
      break;
     case SEHFinallyStmtClass:
      break;
     case SEHLeaveStmtClass:
      break;
     case SEHTryStmtClass:
      break;
     case CaseStmtClass:
      break;
     case DefaultStmtClass:
      break;
     case SwitchStmtClass:
      break;
     case WhileStmtClass:
      break;
    }
    throw new llvm_unreachable("unknown expression kind");
  }

  
  /// isUnusedResultAWarning - Return true if this immediate expression should
  /// be warned about if the result is unused.  If so, fill in expr, location,
  /// and ranges with expr to warn on and source locations/ranges appropriate
  /// for a warning.
  
  //===----------------------------------------------------------------------===//
  // Generic Expression Routines
  //===----------------------------------------------------------------------===//
  
  /// isUnusedResultAWarning - Return true if this immediate expression should
  /// be warned about if the result is unused.  If so, fill in Loc and Ranges
  /// with location to warn on and the source range[s] to report with the
  /// warning.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isUnusedResultAWarning">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1896,
   FQN="clang::Expr::isUnusedResultAWarning", NM="_ZNK5clang4Expr22isUnusedResultAWarningERPKS0_RNS_14SourceLocationERNS_11SourceRangeES7_RNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr22isUnusedResultAWarningERPKS0_RNS_14SourceLocationERNS_11SourceRangeES7_RNS_10ASTContextE")
  //</editor-fold>
  public boolean isUnusedResultAWarning(final type$ptr</*const*/ Expr /*P*/ /*&*/> WarnE, final SourceLocation /*&*/ Loc, 
                        final SourceRange /*&*/ R1, final SourceRange /*&*/ R2, 
                        final ASTContext /*&*/ Ctx) /*const*/ {
    // Don't warn if the expr is type dependent. The type could end up
    // instantiating to void.
    if (isTypeDependent()) {
      return false;
    }
    switch (getStmtClass()) {
     default:
      if (getType().$arrow().isVoidType()) {
        return false;
      }
      WarnE.$set(this);
      Loc.$assignMove(getExprLoc());
      R1.$assignMove(getSourceRange());
      return true;
     case ParenExprClass:
      return cast_ParenExpr(this).getSubExpr$Const().
          isUnusedResultAWarning(WarnE, Loc, R1, R2, Ctx);
     case GenericSelectionExprClass:
      return cast_GenericSelectionExpr(this).getResultExpr$Const().
          isUnusedResultAWarning(WarnE, Loc, R1, R2, Ctx);
     case ChooseExprClass:
      return cast_ChooseExpr(this).getChosenSubExpr().
          isUnusedResultAWarning(WarnE, Loc, R1, R2, Ctx);
     case UnaryOperatorClass:
      {
        /*const*/ UnaryOperator /*P*/ UO = cast_UnaryOperator(this);
        switch (UO.getOpcode()) {
         case UO_Plus:
         case UO_Minus:
         case UO_AddrOf:
         case UO_Not:
         case UO_LNot:
         case UO_Deref:
          break;
         case UO_Coawait:
         case UO_PostInc:
         case UO_PostDec:
         case UO_PreInc:
         case UO_PreDec: // ++/--
          return false; // Not a warning.
         case UO_Real:
         case UO_Imag:
          // accessing a piece of a volatile complex is a side-effect.
          if (Ctx.getCanonicalType(UO.getSubExpr().getType()).
              isVolatileQualified()) {
            return false;
          }
          break;
         case UO_Extension:
          return UO.getSubExpr().isUnusedResultAWarning(WarnE, Loc, R1, R2, Ctx);
        }
        WarnE.$set(this);
        Loc.$assignMove(UO.getOperatorLoc());
        R1.$assignMove(UO.getSubExpr().getSourceRange());
        return true;
      }
     case BinaryOperatorClass:
      {
        /*const*/ BinaryOperator /*P*/ BO = cast_BinaryOperator(this);
        switch (BO.getOpcode()) {
         default:
          break;
         case BO_Comma:
          {
            // ((foo = <blah>), 0) is an idiom for hiding the result (and
            // lvalue-ness) of an assignment written in a macro.
            IntegerLiteral /*P*/ IE = dyn_cast_IntegerLiteral(BO.getRHS().IgnoreParens());
            if ((IE != null)) {
              if (IE.getValue().$eq(0)) {
                return false;
              }
            }
          }
          return BO.getRHS().isUnusedResultAWarning(WarnE, Loc, R1, R2, Ctx);
         case BO_LAnd:
         case BO_LOr:
          // Consider '||', '&&' to have side effects if the LHS or RHS does.
          if (!BO.getLHS().isUnusedResultAWarning(WarnE, Loc, R1, R2, Ctx)
             || !BO.getRHS().isUnusedResultAWarning(WarnE, Loc, R1, R2, Ctx)) {
            return false;
          }
          break;
        }
        if (BO.isAssignmentOp()) {
          return false;
        }
        WarnE.$set(this);
        Loc.$assignMove(BO.getOperatorLoc());
        R1.$assignMove(BO.getLHS().getSourceRange());
        R2.$assignMove(BO.getRHS().getSourceRange());
        return true;
      }
     case CompoundAssignOperatorClass:
     case VAArgExprClass:
     case AtomicExprClass:
      return false;
     case ConditionalOperatorClass:
      {
        // If only one of the LHS or RHS is a warning, the operator might
        // be being used for control flow. Only warn if both the LHS and
        // RHS are warnings.
        /*const*/ ConditionalOperator /*P*/ Exp = cast_ConditionalOperator(this);
        if (!Exp.getRHS().isUnusedResultAWarning(WarnE, Loc, R1, R2, Ctx)) {
          return false;
        }
        if (!(Exp.getLHS() != null)) {
          return true;
        }
        return Exp.getLHS().isUnusedResultAWarning(WarnE, Loc, R1, R2, Ctx);
      }
     case MemberExprClass:
      WarnE.$set(this);
      Loc.$assignMove(cast_MemberExpr(this).getMemberLoc());
      R1.$assignMove(new SourceRange(/*NO_COPY*/Loc, /*NO_COPY*/Loc));
      R2.$assignMove(cast_MemberExpr(this).getBase().getSourceRange());
      return true;
     case ArraySubscriptExprClass:
      WarnE.$set(this);
      Loc.$assignMove(cast_ArraySubscriptExpr(this).getRBracketLoc());
      R1.$assignMove(cast_ArraySubscriptExpr(this).getLHS$Const().getSourceRange());
      R2.$assignMove(cast_ArraySubscriptExpr(this).getRHS$Const().getSourceRange());
      return true;
     case CXXOperatorCallExprClass:
      {
        // Warn about operator ==,!=,<,>,<=, and >= even when user-defined operator
        // overloads as there is no reasonable way to define these such that they
        // have non-trivial, desirable side-effects. See the -Wunused-comparison
        // warning: operators == and != are commonly typo'ed, and so warning on them
        // provides additional value as well. If this list is updated,
        // DiagnoseUnusedComparison should be as well.
        /*const*/ CXXOperatorCallExpr /*P*/ Op = cast_CXXOperatorCallExpr(this);
        switch (Op.getOperator()) {
         default:
          break;
         case OO_EqualEqual:
         case OO_ExclaimEqual:
         case OO_Less:
         case OO_Greater:
         case OO_GreaterEqual:
         case OO_LessEqual:
          if (Op.getCallReturnType(Ctx).$arrow().isReferenceType()
             || Op.getCallReturnType(Ctx).$arrow().isVoidType()) {
            break;
          }
          WarnE.$set(this);
          Loc.$assignMove(Op.getOperatorLoc());
          R1.$assignMove(Op.getSourceRange());
          return true;
        }
        // Fallthrough for generic call handling.
      }
     case CallExprClass:
     case CXXMemberCallExprClass:
     case UserDefinedLiteralClass:
      {
        // If this is a direct call, get the callee.
        /*const*/ CallExpr /*P*/ CE = cast_CallExpr(this);
        {
          /*const*/ Decl /*P*/ FD = CE.getCalleeDecl$Const();
          if ((FD != null)) {
            /*const*/ FunctionDecl /*P*/ Func = dyn_cast_FunctionDecl(FD);
            boolean HasWarnUnusedResultAttr = (Func != null) ? Func.hasUnusedResultAttr() : FD.hasAttr(WarnUnusedResultAttr.class);
            
            // If the callee has attribute pure, const, or warn_unused_result, warn
            // about it. void foo() { strlen("bar"); } should warn.
            //
            // Note: If new cases are added here, DiagnoseUnusedExprResult should be
            // updated to match for QoI.
            if (HasWarnUnusedResultAttr
               || FD.hasAttr(PureAttr.class) || FD.hasAttr(ConstAttr.class)) {
              WarnE.$set(this);
              Loc.$assignMove(CE.getCallee$Const().getLocStart());
              R1.$assignMove(CE.getCallee$Const().getSourceRange());
              {
                
                /*uint*/int NumArgs = CE.getNumArgs();
                if ((NumArgs != 0)) {
                  R2.$assignMove(new SourceRange(CE.getArg$Const(0).getLocStart(), 
                          CE.getArg$Const(NumArgs - 1).getLocEnd()));
                }
              }
              return true;
            }
          }
        }
        return false;
      }
     case UnresolvedLookupExprClass:
     case CXXUnresolvedConstructExprClass:
      
      // If we don't know precisely what we're looking at, let's not warn.
      return false;
     case CXXTemporaryObjectExprClass:
     case CXXConstructExprClass:
      {
        {
          /*const*/ CXXRecordDecl /*P*/ Type = getType().$arrow().getAsCXXRecordDecl();
          if ((Type != null)) {
            if (Type.hasAttr(WarnUnusedAttr.class)) {
              WarnE.$set(this);
              Loc.$assignMove(getLocStart());
              R1.$assignMove(getSourceRange());
              return true;
            }
          }
        }
        return false;
      }
     case ObjCMessageExprClass:
      {
        /*const*/ ObjCMessageExpr /*P*/ ME = cast_ObjCMessageExpr(this);
        if (Ctx.getLangOpts().ObjCAutoRefCount
           && ME.isInstanceMessage()
           && !ME.getType().$arrow().isVoidType()
           && ME.getMethodFamily() == ObjCMethodFamily.OMF_init) {
          WarnE.$set(this);
          Loc.$assignMove(getExprLoc());
          R1.$assignMove(ME.getSourceRange());
          return true;
        }
        {
          
          /*const*/ ObjCMethodDecl /*P*/ MD = ME.getMethodDecl$Const();
          if ((MD != null)) {
            if (MD.hasAttr(WarnUnusedResultAttr.class)) {
              WarnE.$set(this);
              Loc.$assignMove(getExprLoc());
              return true;
            }
          }
        }
        
        return false;
      }
     case ObjCPropertyRefExprClass:
      WarnE.$set(this);
      Loc.$assignMove(getExprLoc());
      R1.$assignMove(getSourceRange());
      return true;
     case PseudoObjectExprClass:
      {
        /*const*/ PseudoObjectExpr /*P*/ PO = cast_PseudoObjectExpr(this);
        
        // Only complain about things that have the form of a getter.
        if (isa_UnaryOperator(PO.getSyntacticForm$Const())
           || isa_BinaryOperator(PO.getSyntacticForm$Const())) {
          return false;
        }
        
        WarnE.$set(this);
        Loc.$assignMove(getExprLoc());
        R1.$assignMove(getSourceRange());
        return true;
      }
     case StmtExprClass:
      {
        // Statement exprs don't logically have side effects themselves, but are
        // sometimes used in macros in ways that give them a type that is unused.
        // For example ({ blah; foo(); }) will end up with a type if foo has a type.
        // however, if the result of the stmt expr is dead, we don't want to emit a
        // warning.
        /*const*/ CompoundStmt /*P*/ CS = cast_StmtExpr(this).getSubStmt$Const();
        if (!CS.body_empty()) {
          {
            /*const*/ Expr /*P*/ E = dyn_cast_Expr(CS.body_back$Const());
            if ((E != null)) {
              return E.isUnusedResultAWarning(WarnE, Loc, R1, R2, Ctx);
            }
          }
          {
            /*const*/ LabelStmt /*P*/ Label = dyn_cast_LabelStmt(CS.body_back$Const());
            if ((Label != null)) {
              {
                /*const*/ Expr /*P*/ E = dyn_cast_Expr(Label.getSubStmt$Const());
                if ((E != null)) {
                  return E.isUnusedResultAWarning(WarnE, Loc, R1, R2, Ctx);
                }
              }
            }
          }
        }
        if (getType().$arrow().isVoidType()) {
          return false;
        }
        WarnE.$set(this);
        Loc.$assignMove(cast_StmtExpr(this).getLParenLoc());
        R1.$assignMove(getSourceRange());
        return true;
      }
     case CXXFunctionalCastExprClass:
     case CStyleCastExprClass:
      {
        // Ignore an explicit cast to void unless the operand is a non-trivial
        // volatile lvalue.
        /*const*/ CastExpr /*P*/ CE = cast_CastExpr(this);
        if (CE.getCastKind() == CastKind.CK_ToVoid) {
          if (CE.getSubExpr$Const().isGLValue()
             && CE.getSubExpr$Const().getType().isVolatileQualified()) {
            /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(CE.getSubExpr$Const().IgnoreParens$Const());
            if (!((DRE != null) && isa_VarDecl(DRE.getDecl$Const())
               && cast_VarDecl(DRE.getDecl$Const()).hasLocalStorage())) {
              return CE.getSubExpr$Const().isUnusedResultAWarning(WarnE, Loc, 
                  R1, R2, Ctx);
            }
          }
          return false;
        }
        
        // If this is a cast to a constructor conversion, check the operand.
        // Otherwise, the result of the cast is unused.
        if (CE.getCastKind() == CastKind.CK_ConstructorConversion) {
          return CE.getSubExpr$Const().isUnusedResultAWarning(WarnE, Loc, R1, R2, Ctx);
        }
        
        WarnE.$set(this);
        {
          /*const*/ CXXFunctionalCastExpr /*P*/ CXXCE = dyn_cast_CXXFunctionalCastExpr(this);
          if ((CXXCE != null)) {
            Loc.$assignMove(CXXCE.getLocStart());
            R1.$assignMove(CXXCE.getSubExpr$Const().getSourceRange());
          } else {
            /*const*/ CStyleCastExpr /*P*/ CStyleCE = cast_CStyleCastExpr(this);
            Loc.$assignMove(CStyleCE.getLParenLoc());
            R1.$assignMove(CStyleCE.getSubExpr$Const().getSourceRange());
          }
        }
        return true;
      }
     case ImplicitCastExprClass:
      {
        /*const*/ CastExpr /*P*/ ICE = cast_ImplicitCastExpr(this);
        
        // lvalue-to-rvalue conversion on a volatile lvalue is a side-effect.
        if (ICE.getCastKind() == CastKind.CK_LValueToRValue
           && ICE.getSubExpr$Const().getType().isVolatileQualified()) {
          return false;
        }
        
        return ICE.getSubExpr$Const().isUnusedResultAWarning(WarnE, Loc, R1, R2, Ctx);
      }
     case CXXDefaultArgExprClass:
      return (cast_CXXDefaultArgExpr(this).
          getExpr$Const().isUnusedResultAWarning(WarnE, Loc, R1, R2, Ctx));
     case CXXDefaultInitExprClass:
      return (cast_CXXDefaultInitExpr(this).
          getExpr$Const().isUnusedResultAWarning(WarnE, Loc, R1, R2, Ctx));
     case CXXNewExprClass:
     case CXXDeleteExprClass:
      // FIXME: In theory, there might be new expressions that don't have side
      // effects (e.g. a placement new with an uninitialized POD).
      return false;
     case CXXBindTemporaryExprClass:
      return (cast_CXXBindTemporaryExpr(this).
          getSubExpr$Const().isUnusedResultAWarning(WarnE, Loc, R1, R2, Ctx));
     case ExprWithCleanupsClass:
      return (cast_ExprWithCleanups(this).
          getSubExpr$Const().isUnusedResultAWarning(WarnE, Loc, R1, R2, Ctx));
    }
  }

  
  /// isLValue - True if this expression is an "l-value" according to
  /// the rules of the current language.  C and C++ give somewhat
  /// different rules for this concept, but in general, the result of
  /// an l-value expression identifies a specific object whereas the
  /// result of an r-value expression is a value detached from any
  /// specific storage.
  ///
  /// C++11 divides the concept of "r-value" into pure r-values
  /// ("pr-values") and so-called expiring values ("x-values"), which
  /// identify specific objects that can be safely cannibalized for
  /// their resources.  This is an unfortunate abuse of terminology on
  /// the part of the C++ committee.  In Clang, when we say "r-value",
  /// we generally mean a pr-value.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 247,
   FQN="clang::Expr::isLValue", NM="_ZNK5clang4Expr8isLValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr8isLValueEv")
  //</editor-fold>
  public boolean isLValue() /*const*/ {
    return getValueKind() == ExprValueKind.VK_LValue;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isRValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 248,
   FQN="clang::Expr::isRValue", NM="_ZNK5clang4Expr8isRValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr8isRValueEv")
  //</editor-fold>
  public boolean isRValue() /*const*/ {
    return getValueKind() == ExprValueKind.VK_RValue;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isXValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 249,
   FQN="clang::Expr::isXValue", NM="_ZNK5clang4Expr8isXValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr8isXValueEv")
  //</editor-fold>
  public boolean isXValue() /*const*/ {
    return getValueKind() == ExprValueKind.VK_XValue;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isGLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 250,
   FQN="clang::Expr::isGLValue", NM="_ZNK5clang4Expr9isGLValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr9isGLValueEv")
  //</editor-fold>
  public boolean isGLValue() /*const*/ {
    return getValueKind() != ExprValueKind.VK_RValue;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::LValueClassification">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 252,
   FQN="clang::Expr::LValueClassification", NM="_ZN5clang4Expr20LValueClassificationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr20LValueClassificationE")
  //</editor-fold>
  public enum LValueClassification implements Native.ComparableLower {
    LV_Valid(0),
    LV_NotObjectType(LV_Valid.getValue() + 1),
    LV_IncompleteVoidType(LV_NotObjectType.getValue() + 1),
    LV_DuplicateVectorComponents(LV_IncompleteVoidType.getValue() + 1),
    LV_InvalidExpression(LV_DuplicateVectorComponents.getValue() + 1),
    LV_InvalidMessageExpression(LV_InvalidExpression.getValue() + 1),
    LV_MemberFunction(LV_InvalidMessageExpression.getValue() + 1),
    LV_SubObjCPropertySetting(LV_MemberFunction.getValue() + 1),
    LV_ClassTemporary(LV_SubObjCPropertySetting.getValue() + 1),
    LV_ArrayTemporary(LV_ClassTemporary.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static LValueClassification valueOf(int val) {
      LValueClassification out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final LValueClassification[] VALUES;
      private static final LValueClassification[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (LValueClassification kind : LValueClassification.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new LValueClassification[min < 0 ? (1-min) : 0];
        VALUES = new LValueClassification[max >= 0 ? (1+max) : 0];
        for (LValueClassification kind : LValueClassification.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private LValueClassification(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((LValueClassification)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((LValueClassification)obj).value);}
    //</editor-fold>
  };
  /// Reasons why an expression might not be an l-value.
  /// Reasons why an expression might not be an l-value.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::ClassifyLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp", line = 636,
   FQN="clang::Expr::ClassifyLValue", NM="_ZNK5clang4Expr14ClassifyLValueERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp -nm=_ZNK5clang4Expr14ClassifyLValueERNS_10ASTContextE")
  //</editor-fold>
  public Expr.LValueClassification ClassifyLValue(final ASTContext /*&*/ Ctx) /*const*/ {
    Classification VC = Classify(Ctx);
    switch (VC.getKind()) {
     case CL_LValue:
      return LValueClassification.LV_Valid;
     case CL_XValue:
      return LValueClassification.LV_InvalidExpression;
     case CL_Function:
      return LValueClassification.LV_NotObjectType;
     case CL_Void:
      return LValueClassification.LV_InvalidExpression;
     case CL_AddressableVoid:
      return LValueClassification.LV_IncompleteVoidType;
     case CL_DuplicateVectorComponents:
      return LValueClassification.LV_DuplicateVectorComponents;
     case CL_MemberFunction:
      return LValueClassification.LV_MemberFunction;
     case CL_SubObjCPropertySetting:
      return LValueClassification.LV_SubObjCPropertySetting;
     case CL_ClassTemporary:
      return LValueClassification.LV_ClassTemporary;
     case CL_ArrayTemporary:
      return LValueClassification.LV_ArrayTemporary;
     case CL_ObjCMessageRValue:
      return LValueClassification.LV_InvalidMessageExpression;
     case CL_PRValue:
      return LValueClassification.LV_InvalidExpression;
    }
    throw new llvm_unreachable("Unhandled kind");
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isModifiableLvalueResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 267,
   FQN="clang::Expr::isModifiableLvalueResult", NM="_ZN5clang4Expr24isModifiableLvalueResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr24isModifiableLvalueResultE")
  //</editor-fold>
  public enum isModifiableLvalueResult implements Native.ComparableLower {
    MLV_Valid(0),
    MLV_NotObjectType(MLV_Valid.getValue() + 1),
    MLV_IncompleteVoidType(MLV_NotObjectType.getValue() + 1),
    MLV_DuplicateVectorComponents(MLV_IncompleteVoidType.getValue() + 1),
    MLV_InvalidExpression(MLV_DuplicateVectorComponents.getValue() + 1),
    MLV_LValueCast(MLV_InvalidExpression.getValue() + 1), // Specialized form of MLV_InvalidExpression.
    MLV_IncompleteType(MLV_LValueCast.getValue() + 1),
    MLV_ConstQualified(MLV_IncompleteType.getValue() + 1),
    MLV_ConstAddrSpace(MLV_ConstQualified.getValue() + 1),
    MLV_ArrayType(MLV_ConstAddrSpace.getValue() + 1),
    MLV_NoSetterProperty(MLV_ArrayType.getValue() + 1),
    MLV_MemberFunction(MLV_NoSetterProperty.getValue() + 1),
    MLV_SubObjCPropertySetting(MLV_MemberFunction.getValue() + 1),
    MLV_InvalidMessageExpression(MLV_SubObjCPropertySetting.getValue() + 1),
    MLV_ClassTemporary(MLV_InvalidMessageExpression.getValue() + 1),
    MLV_ArrayTemporary(MLV_ClassTemporary.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static isModifiableLvalueResult valueOf(int val) {
      isModifiableLvalueResult out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final isModifiableLvalueResult[] VALUES;
      private static final isModifiableLvalueResult[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (isModifiableLvalueResult kind : isModifiableLvalueResult.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new isModifiableLvalueResult[min < 0 ? (1-min) : 0];
        VALUES = new isModifiableLvalueResult[max >= 0 ? (1+max) : 0];
        for (isModifiableLvalueResult kind : isModifiableLvalueResult.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private isModifiableLvalueResult(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((isModifiableLvalueResult)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((isModifiableLvalueResult)obj).value);}
    //</editor-fold>
  };
  /// isModifiableLvalue - C99 6.3.2.1: an lvalue that does not have array type,
  /// does not have an incomplete type, does not have a const-qualified type,
  /// and if it is a structure or union, does not have any member (including,
  /// recursively, any member or element of all contained aggregates or unions)
  /// with a const-qualified type.
  ///
  /// \param Loc [in,out] - A source location which *may* be filled
  /// in with the location of the expression making this a
  /// non-modifiable lvalue, if specified.
  /// isModifiableLvalue - C99 6.3.2.1: an lvalue that does not have array type,
  /// does not have an incomplete type, does not have a const-qualified type,
  /// and if it is a structure or union, does not have any member (including,
  /// recursively, any member or element of all contained aggregates or unions)
  /// with a const-qualified type.
  ///
  /// \param Loc [in,out] - A source location which *may* be filled
  /// in with the location of the expression making this a
  /// non-modifiable lvalue, if specified.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isModifiableLvalue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp", line = 655,
   FQN="clang::Expr::isModifiableLvalue", NM="_ZNK5clang4Expr18isModifiableLvalueERNS_10ASTContextEPNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp -nm=_ZNK5clang4Expr18isModifiableLvalueERNS_10ASTContextEPNS_14SourceLocationE")
  //</editor-fold>
  public Expr.isModifiableLvalueResult isModifiableLvalue(final ASTContext /*&*/ Ctx) /*const*/ {
    return isModifiableLvalue(Ctx, (type$ptr<SourceLocation> /*P*/ )null);
  }
  public Expr.isModifiableLvalueResult isModifiableLvalue(final ASTContext /*&*/ Ctx, type$ptr<SourceLocation> /*P*/ Loc/*= null*/) /*const*/ {
    type$ptr<SourceLocation> dummy/*J*/= create_type$ptr(new SourceLocation());
    Classification VC = ClassifyModifiable(Ctx, Native.$bool(Loc) ? Loc : dummy);
    switch (VC.getKind()) {
     case CL_LValue:
      break;
     case CL_XValue:
      return isModifiableLvalueResult.MLV_InvalidExpression;
     case CL_Function:
      return isModifiableLvalueResult.MLV_NotObjectType;
     case CL_Void:
      return isModifiableLvalueResult.MLV_InvalidExpression;
     case CL_AddressableVoid:
      return isModifiableLvalueResult.MLV_IncompleteVoidType;
     case CL_DuplicateVectorComponents:
      return isModifiableLvalueResult.MLV_DuplicateVectorComponents;
     case CL_MemberFunction:
      return isModifiableLvalueResult.MLV_MemberFunction;
     case CL_SubObjCPropertySetting:
      return isModifiableLvalueResult.MLV_SubObjCPropertySetting;
     case CL_ClassTemporary:
      return isModifiableLvalueResult.MLV_ClassTemporary;
     case CL_ArrayTemporary:
      return isModifiableLvalueResult.MLV_ArrayTemporary;
     case CL_ObjCMessageRValue:
      return isModifiableLvalueResult.MLV_InvalidMessageExpression;
     case CL_PRValue:
      return VC.getModifiable() == Expr.Classification.ModifiableType.CM_LValueCast ? isModifiableLvalueResult.MLV_LValueCast : isModifiableLvalueResult.MLV_InvalidExpression;
    }
    assert (VC.getKind() == Expr.Classification.Kinds.CL_LValue) : "Unhandled kind";
    switch (VC.getModifiable()) {
     case CM_Untested:
      throw new llvm_unreachable("Did not test modifiability");
     case CM_Modifiable:
      return isModifiableLvalueResult.MLV_Valid;
     case CM_RValue:
      throw new llvm_unreachable("CM_RValue and CL_LValue don't match");
     case CM_Function:
      return isModifiableLvalueResult.MLV_NotObjectType;
     case CM_LValueCast:
      throw new llvm_unreachable("CM_LValueCast and CL_LValue don't match");
     case CM_NoSetterProperty:
      return isModifiableLvalueResult.MLV_NoSetterProperty;
     case CM_ConstQualified:
      return isModifiableLvalueResult.MLV_ConstQualified;
     case CM_ConstAddrSpace:
      return isModifiableLvalueResult.MLV_ConstAddrSpace;
     case CM_ArrayType:
      return isModifiableLvalueResult.MLV_ArrayType;
     case CM_IncompleteType:
      return isModifiableLvalueResult.MLV_IncompleteType;
    }
    throw new llvm_unreachable("Unhandled modifiable type");
  }


  
  /// \brief The return type of classify(). Represents the C++11 expression
  ///        taxonomy.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::Classification">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 299,
   FQN="clang::Expr::Classification", NM="_ZN5clang4Expr14ClassificationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr14ClassificationE")
  //</editor-fold>
  public static class Classification {
  /*public:*/
    /// \brief The various classification results. Most of these mean prvalue.
    //<editor-fold defaultstate="collapsed" desc="clang::Expr::Classification::Kinds">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 302,
     FQN="clang::Expr::Classification::Kinds", NM="_ZN5clang4Expr14Classification5KindsE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr14Classification5KindsE")
    //</editor-fold>
    public enum Kinds implements Native.ComparableLower {
      CL_LValue(0),
      CL_XValue(CL_LValue.getValue() + 1),
      CL_Function(CL_XValue.getValue() + 1), // Functions cannot be lvalues in C.
      CL_Void(CL_Function.getValue() + 1), // Void cannot be an lvalue in C.
      CL_AddressableVoid(CL_Void.getValue() + 1), // Void expression whose address can be taken in C.
      CL_DuplicateVectorComponents(CL_AddressableVoid.getValue() + 1), // A vector shuffle with dupes.
      CL_MemberFunction(CL_DuplicateVectorComponents.getValue() + 1), // An expression referring to a member function
      CL_SubObjCPropertySetting(CL_MemberFunction.getValue() + 1),
      CL_ClassTemporary(CL_SubObjCPropertySetting.getValue() + 1), // A temporary of class type, or subobject thereof.
      CL_ArrayTemporary(CL_ClassTemporary.getValue() + 1), // A temporary of array type.
      CL_ObjCMessageRValue(CL_ArrayTemporary.getValue() + 1), // ObjC message is an rvalue
      CL_PRValue(CL_ObjCMessageRValue.getValue() + 1); // A prvalue for any other reason, of any other type

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static Kinds valueOf(int val) {
        Kinds out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final Kinds[] VALUES;
        private static final Kinds[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (Kinds kind : Kinds.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new Kinds[min < 0 ? (1-min) : 0];
          VALUES = new Kinds[max >= 0 ? (1+max) : 0];
          for (Kinds kind : Kinds.values()) {
            if (kind.value < 0) {
              _VALUES[-kind.value] = kind;
            } else {
              VALUES[kind.value] = kind;
            }
          }
        }
      }

      private final /*uint*/int value;
      private Kinds(int val) { this.value = (/*uint*/int)val;}
      public /*uint*/int getValue() { return value;}
      @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kinds)obj).value);}
      @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kinds)obj).value);}
      //</editor-fold>
    };
    /// \brief The results of modification testing.
    //<editor-fold defaultstate="collapsed" desc="clang::Expr::Classification::ModifiableType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 317,
     FQN="clang::Expr::Classification::ModifiableType", NM="_ZN5clang4Expr14Classification14ModifiableTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr14Classification14ModifiableTypeE")
    //</editor-fold>
    public enum ModifiableType implements Native.ComparableLower {
      CM_Untested(0), // testModifiable was false.
      CM_Modifiable(CM_Untested.getValue() + 1),
      CM_RValue(CM_Modifiable.getValue() + 1), // Not modifiable because it's an rvalue
      CM_Function(CM_RValue.getValue() + 1), // Not modifiable because it's a function; C++ only
      CM_LValueCast(CM_Function.getValue() + 1), // Same as CM_RValue, but indicates GCC cast-as-lvalue ext
      CM_NoSetterProperty(CM_LValueCast.getValue() + 1), // Implicit assignment to ObjC property without setter
      CM_ConstQualified(CM_NoSetterProperty.getValue() + 1),
      CM_ConstAddrSpace(CM_ConstQualified.getValue() + 1),
      CM_ArrayType(CM_ConstAddrSpace.getValue() + 1),
      CM_IncompleteType(CM_ArrayType.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static ModifiableType valueOf(int val) {
        ModifiableType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final ModifiableType[] VALUES;
        private static final ModifiableType[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (ModifiableType kind : ModifiableType.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new ModifiableType[min < 0 ? (1-min) : 0];
          VALUES = new ModifiableType[max >= 0 ? (1+max) : 0];
          for (ModifiableType kind : ModifiableType.values()) {
            if (kind.value < 0) {
              _VALUES[-kind.value] = kind;
            } else {
              VALUES[kind.value] = kind;
            }
          }
        }
      }

      private final /*uint*/int value;
      private ModifiableType(int val) { this.value = (/*uint*/int)val;}
      public /*uint*/int getValue() { return value;}
      @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ModifiableType)obj).value);}
      @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ModifiableType)obj).value);}
      //</editor-fold>
    };
  /*private:*/
    /*friend  class Expr*/
    
    private /*ushort*/char Kind;
    private /*ushort*/char Modifiable;
    
    //<editor-fold defaultstate="collapsed" desc="clang::Expr::Classification::Classification">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 336,
     FQN="clang::Expr::Classification::Classification", NM="_ZN5clang4Expr14ClassificationC1ENS1_5KindsENS1_14ModifiableTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr14ClassificationC1ENS1_5KindsENS1_14ModifiableTypeE")
    //</editor-fold>
    private /*explicit*/ Classification(Kinds k, ModifiableType m) {
      // : Kind(k), Modifiable(m) 
      //START JInit
      this.Kind = $uint2ushort(k.getValue());
      this.Modifiable = $uint2ushort(m.getValue());
      //END JInit
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Expr::Classification::Classification">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 341,
     FQN="clang::Expr::Classification::Classification", NM="_ZN5clang4Expr14ClassificationC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr14ClassificationC1Ev")
    //</editor-fold>
    public Classification() {
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Expr::Classification::getKind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 343,
     FQN="clang::Expr::Classification::getKind", NM="_ZNK5clang4Expr14Classification7getKindEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr14Classification7getKindEv")
    //</editor-fold>
    public Kinds getKind() /*const*/ {
      return /*static_cast*/Kinds.valueOf(Kind);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Expr::Classification::getModifiable">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 344,
     FQN="clang::Expr::Classification::getModifiable", NM="_ZNK5clang4Expr14Classification13getModifiableEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr14Classification13getModifiableEv")
    //</editor-fold>
    public ModifiableType getModifiable() /*const*/ {
      assert ($ushort2int(Modifiable) != ModifiableType.CM_Untested.getValue()) : "Did not test for modifiability.";
      return /*static_cast*/ModifiableType.valueOf(Modifiable);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Expr::Classification::isLValue">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 348,
     FQN="clang::Expr::Classification::isLValue", NM="_ZNK5clang4Expr14Classification8isLValueEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr14Classification8isLValueEv")
    //</editor-fold>
    public boolean isLValue() /*const*/ {
      return $ushort2int(Kind) == Kinds.CL_LValue.getValue();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Expr::Classification::isXValue">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 349,
     FQN="clang::Expr::Classification::isXValue", NM="_ZNK5clang4Expr14Classification8isXValueEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr14Classification8isXValueEv")
    //</editor-fold>
    public boolean isXValue() /*const*/ {
      return $ushort2int(Kind) == Kinds.CL_XValue.getValue();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Expr::Classification::isGLValue">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 350,
     FQN="clang::Expr::Classification::isGLValue", NM="_ZNK5clang4Expr14Classification9isGLValueEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr14Classification9isGLValueEv")
    //</editor-fold>
    public boolean isGLValue() /*const*/ {
      return $ushort2int(Kind) <= Kinds.CL_XValue.getValue();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Expr::Classification::isPRValue">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 351,
     FQN="clang::Expr::Classification::isPRValue", NM="_ZNK5clang4Expr14Classification9isPRValueEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr14Classification9isPRValueEv")
    //</editor-fold>
    public boolean isPRValue() /*const*/ {
      return $ushort2int(Kind) >= Kinds.CL_Function.getValue();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Expr::Classification::isRValue">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 352,
     FQN="clang::Expr::Classification::isRValue", NM="_ZNK5clang4Expr14Classification8isRValueEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr14Classification8isRValueEv")
    //</editor-fold>
    public boolean isRValue() /*const*/ {
      return $ushort2int(Kind) >= Kinds.CL_XValue.getValue();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Expr::Classification::isModifiable">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 353,
     FQN="clang::Expr::Classification::isModifiable", NM="_ZNK5clang4Expr14Classification12isModifiableEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr14Classification12isModifiableEv")
    //</editor-fold>
    public boolean isModifiable() /*const*/ {
      return getModifiable() == ModifiableType.CM_Modifiable;
    }

    
    /// \brief Create a simple, modifiably lvalue
    //<editor-fold defaultstate="collapsed" desc="clang::Expr::Classification::makeSimpleLValue">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 356,
     FQN="clang::Expr::Classification::makeSimpleLValue", NM="_ZN5clang4Expr14Classification16makeSimpleLValueEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr14Classification16makeSimpleLValueEv")
    //</editor-fold>
    public static Classification makeSimpleLValue() {
      return new Classification(Kinds.CL_LValue, ModifiableType.CM_Modifiable);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Expr::Classification::Classification">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 299,
     FQN="clang::Expr::Classification::Classification", NM="_ZN5clang4Expr14ClassificationC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr14ClassificationC1EOS1_")
    //</editor-fold>
    public /*inline*/ Classification(JD$Move _dparam, final Classification /*&&*/$Prm0) {
      // : Kind(static_cast<Classification &&>().Kind), Modifiable(static_cast<Classification &&>().Modifiable) 
      //START JInit
      this.Kind = $Prm0.Kind;
      this.Modifiable = $Prm0.Modifiable;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Expr::Classification::Classification">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 299,
     FQN="clang::Expr::Classification::Classification", NM="_ZN5clang4Expr14ClassificationC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Expr14ClassificationC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Classification(final /*const*/ Classification /*&*/ $Prm0) {
      // : Kind(.Kind), Modifiable(.Modifiable) 
      //START JInit
      this.Kind = $Prm0.Kind;
      this.Modifiable = $Prm0.Modifiable;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Expr::Classification::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 299,
     FQN="clang::Expr::Classification::operator=", NM="_ZN5clang4Expr14ClassificationaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Expr14ClassificationaSEOS1_")
    //</editor-fold>
    public /*inline*/ Classification /*&*/ $assignMove(final Classification /*&&*/$Prm0) {
      this.Kind = $Prm0.Kind;
      this.Modifiable = $Prm0.Modifiable;
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "Kind=" + $ushort2uint(Kind) // NOI18N
                + ", Modifiable=" + $ushort2uint(Modifiable); // NOI18N
    }
  };
  /// \brief Classify - Classify this expression according to the C++11
  ///        expression taxonomy.
  ///
  /// C++11 defines ([basic.lval]) a new taxonomy of expressions to replace the
  /// old lvalue vs rvalue. This function determines the type of expression this
  /// is. There are three expression types:
  /// - lvalues are classical lvalues as in C++03.
  /// - prvalues are equivalent to rvalues in C++03.
  /// - xvalues are expressions yielding unnamed rvalue references, e.g. a
  ///   function returning an rvalue reference.
  /// lvalues and xvalues are collectively referred to as glvalues, while
  /// prvalues and xvalues together form rvalues.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::Classify">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 373,
   FQN="clang::Expr::Classify", NM="_ZNK5clang4Expr8ClassifyERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr8ClassifyERNS_10ASTContextE")
  //</editor-fold>
  public Classification Classify(final ASTContext /*&*/ Ctx) /*const*/ {
    return ClassifyImpl(Ctx, (type$ptr<SourceLocation> /*P*/ )null);
  }

  
  /// \brief ClassifyModifiable - Classify this expression according to the
  ///        C++11 expression taxonomy, and see if it is valid on the left side
  ///        of an assignment.
  ///
  /// This function extends classify in that it also tests whether the
  /// expression is modifiable (C99 6.3.2.1p1).
  /// \param Loc A source location that might be filled with a relevant location
  ///            if the expression is not modifiable.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::ClassifyModifiable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 385,
   FQN="clang::Expr::ClassifyModifiable", NM="_ZNK5clang4Expr18ClassifyModifiableERNS_10ASTContextERNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr18ClassifyModifiableERNS_10ASTContextERNS_14SourceLocationE")
  //</editor-fold>
  public Classification ClassifyModifiable(final ASTContext /*&*/ Ctx, final type$ptr<SourceLocation /*&*/> Loc) /*const*/ {
    return ClassifyImpl(Ctx, $AddrOf(Loc));
  }

  
  /// getValueKindForType - Given a formal return or parameter type,
  /// give its value kind.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::getValueKindForType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 391,
   FQN="clang::Expr::getValueKindForType", NM="_ZN5clang4Expr19getValueKindForTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr19getValueKindForTypeENS_8QualTypeE")
  //</editor-fold>
  public static ExprValueKind getValueKindForType(QualType T) {
    {
      /*const*/ ReferenceType /*P*/ RT = T.$arrow().getAs(ReferenceType.class);
      if ((RT != null)) {
        return (isa_LValueReferenceType(RT) ? ExprValueKind.VK_LValue : (RT.getPointeeType().$arrow().isFunctionType() ? ExprValueKind.VK_LValue : ExprValueKind.VK_XValue));
      }
    }
    return ExprValueKind.VK_RValue;
  }

  
  /// getValueKind - The value kind that this expression produces.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::getValueKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 401,
   FQN="clang::Expr::getValueKind", NM="_ZNK5clang4Expr12getValueKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr12getValueKindEv")
  //</editor-fold>
  public ExprValueKind getValueKind() /*const*/ {
    return /*static_cast*/ExprValueKind.valueOf(Unnamed_field.ExprBits.ValueKind);
  }

  
  /// getObjectKind - The object kind that this expression produces.
  /// Object kinds are meaningful only for expressions that yield an
  /// l-value or x-value.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::getObjectKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 408,
   FQN="clang::Expr::getObjectKind", NM="_ZNK5clang4Expr13getObjectKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr13getObjectKindEv")
  //</editor-fold>
  public ExprObjectKind getObjectKind() /*const*/ {
    return /*static_cast*/ExprObjectKind.valueOf(Unnamed_field.ExprBits.ObjectKind);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isOrdinaryOrBitFieldObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 412,
   FQN="clang::Expr::isOrdinaryOrBitFieldObject", NM="_ZNK5clang4Expr26isOrdinaryOrBitFieldObjectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr26isOrdinaryOrBitFieldObjectEv")
  //</editor-fold>
  public boolean isOrdinaryOrBitFieldObject() /*const*/ {
    ExprObjectKind OK = getObjectKind();
    return (OK == ExprObjectKind.OK_Ordinary || OK == ExprObjectKind.OK_BitField);
  }

  
  /// setValueKind - Set the value kind produced by this expression.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::setValueKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 418,
   FQN="clang::Expr::setValueKind", NM="_ZN5clang4Expr12setValueKindENS_13ExprValueKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr12setValueKindENS_13ExprValueKindE")
  //</editor-fold>
  public void setValueKind(ExprValueKind Cat) {
    Unnamed_field.ExprBits.ValueKind = $uint2uint_2bits(Cat.getValue());
  }

  
  /// setObjectKind - Set the object kind produced by this expression.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::setObjectKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 421,
   FQN="clang::Expr::setObjectKind", NM="_ZN5clang4Expr13setObjectKindENS_14ExprObjectKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr13setObjectKindENS_14ExprObjectKindE")
  //</editor-fold>
  public void setObjectKind(ExprObjectKind Cat) {
    Unnamed_field.ExprBits.ObjectKind = $uint2uint_3bits(Cat.getValue());
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::ClassifyImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp", line = 37,
   FQN="clang::Expr::ClassifyImpl", NM="_ZNK5clang4Expr12ClassifyImplERNS_10ASTContextEPNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp -nm=_ZNK5clang4Expr12ClassifyImplERNS_10ASTContextEPNS_14SourceLocationE")
  //</editor-fold>
  private Expr.Classification ClassifyImpl(final ASTContext /*&*/ Ctx, type$ptr<SourceLocation> /*P*/ Loc) /*const*/ {
    assert (!TR.$arrow().isReferenceType()) : "Expressions can't have reference type.";
    
    Expr.Classification.Kinds kind = ClassifyInternal(Ctx, this);
    // C99 6.3.2.1: An lvalue is an expression with an object type or an
    //   incomplete type other than void.
    if (!Ctx.getLangOpts().CPlusPlus) {
      // Thus, no functions.
      if (TR.$arrow().isFunctionType() || $eq_QualType$C(TR, Ctx.OverloadTy.$QualType())) {
        kind = Expr.Classification.Kinds.CL_Function;
      } else // No void either, but qualified void is OK because it is "other than void".
      // Void "lvalues" are classified as addressable void values, which are void
      // expressions whose address can be taken.
      if (TR.$arrow().isVoidType() && !TR.hasQualifiers()) {
        kind = (kind == Expr.Classification.Kinds.CL_LValue ? Expr.Classification.Kinds.CL_AddressableVoid : Expr.Classification.Kinds.CL_Void);
      }
    }
    
    // Enable this assertion for testing.
    switch (kind) {
     case CL_LValue:
      assert (getValueKind() == ExprValueKind.VK_LValue);
      break;
     case CL_XValue:
      assert (getValueKind() == ExprValueKind.VK_XValue);
      break;
     case CL_Function:
     case CL_Void:
     case CL_AddressableVoid:
     case CL_DuplicateVectorComponents:
     case CL_MemberFunction:
     case CL_SubObjCPropertySetting:
     case CL_ClassTemporary:
     case CL_ArrayTemporary:
     case CL_ObjCMessageRValue:
     case CL_PRValue:
      assert (getValueKind() == ExprValueKind.VK_RValue);
      break;
    }
    
    Expr.Classification.ModifiableType modifiable = Expr.Classification.ModifiableType.CM_Untested;
    if (Native.$bool(Loc)) {
      modifiable = IsModifiable(Ctx, this, kind, Loc.$star());
    }
    return new Classification(kind, modifiable);
  }


/*public:*/
  
  /// \brief Returns true if this expression is a gl-value that
  /// potentially refers to a bit-field.
  ///
  /// In C++, whether a gl-value refers to a bitfield is essentially
  /// an aspect of the value-kind type system.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::refersToBitField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 433,
   FQN="clang::Expr::refersToBitField", NM="_ZNK5clang4Expr16refersToBitFieldEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr16refersToBitFieldEv")
  //</editor-fold>
  public boolean refersToBitField() /*const*/ {
    return getObjectKind() == ExprObjectKind.OK_BitField;
  }

  
  /// \brief If this expression refers to a bit-field, retrieve the
  /// declaration of that bit-field.
  ///
  /// Note that this returns a non-null pointer in subtly different
  /// places than refersToBitField returns true.  In particular, this can
  /// return a non-null pointer even for r-values loaded from
  /// bit-fields, but it will return null for a conditional bit-field.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::getSourceBitField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3289,
   FQN="clang::Expr::getSourceBitField", NM="_ZN5clang4Expr17getSourceBitFieldEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr17getSourceBitFieldEv")
  //</editor-fold>
  public FieldDecl /*P*/ getSourceBitField() {
    Expr /*P*/ E = this.IgnoreParens();
    {
      
      ImplicitCastExpr /*P*/ ICE;
      while (((/*P*/ ICE = dyn_cast_ImplicitCastExpr(E)) != null)) {
        if (ICE.getCastKind() == CastKind.CK_LValueToRValue
           || (ICE.getValueKind() != ExprValueKind.VK_RValue && ICE.getCastKind() == CastKind.CK_NoOp)) {
          E = ICE.getSubExpr().IgnoreParens();
        } else {
          break;
        }
      }
    }
    {
      
      MemberExpr /*P*/ MemRef = dyn_cast_MemberExpr(E);
      if ((MemRef != null)) {
        {
          FieldDecl /*P*/ Field = dyn_cast_FieldDecl(MemRef.getMemberDecl());
          if ((Field != null)) {
            if (Field.isBitField()) {
              return Field;
            }
          }
        }
      }
    }
    {
      
      ObjCIvarRefExpr /*P*/ IvarRef = dyn_cast_ObjCIvarRefExpr(E);
      if ((IvarRef != null)) {
        {
          FieldDecl /*P*/ Ivar = dyn_cast_FieldDecl(IvarRef.getDecl());
          if ((Ivar != null)) {
            if (Ivar.isBitField()) {
              return Ivar;
            }
          }
        }
      }
    }
    {
      
      DeclRefExpr /*P*/ DeclRef = dyn_cast_DeclRefExpr(E);
      if ((DeclRef != null)) {
        {
          FieldDecl /*P*/ Field = dyn_cast_FieldDecl(DeclRef.getDecl());
          if ((Field != null)) {
            if (Field.isBitField()) {
              return Field;
            }
          }
        }
      }
    }
    {
      
      BinaryOperator /*P*/ BinOp = dyn_cast_BinaryOperator(E);
      if ((BinOp != null)) {
        if (BinOp.isAssignmentOp() && (BinOp.getLHS() != null)) {
          return BinOp.getLHS().getSourceBitField();
        }
        if (BinOp.getOpcode() == BinaryOperatorKind.BO_Comma && (BinOp.getRHS() != null)) {
          return BinOp.getRHS().getSourceBitField();
        }
      }
    }
    {
      
      UnaryOperator /*P*/ UnOp = dyn_cast_UnaryOperator(E);
      if ((UnOp != null)) {
        if (UnOp.isPrefix() && UnOp.isIncrementDecrementOp()) {
          return UnOp.getSubExpr().getSourceBitField();
        }
      }
    }
    
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::getSourceBitField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 444,
   FQN="clang::Expr::getSourceBitField", NM="_ZNK5clang4Expr17getSourceBitFieldEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr17getSourceBitFieldEv")
  //</editor-fold>
  public /*const*/ FieldDecl /*P*/ getSourceBitField$Const() /*const*/ {
    return ((/*const_cast*/Expr /*P*/ )(this)).getSourceBitField();
  }

  
  /// \brief If this expression is an l-value for an Objective C
  /// property, find the underlying property reference expression.
  
  /// \brief If this expression is an l-value for an Objective C
  /// property, find the underlying property reference expression.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::getObjCProperty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3251,
   FQN="clang::Expr::getObjCProperty", NM="_ZNK5clang4Expr15getObjCPropertyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr15getObjCPropertyEv")
  //</editor-fold>
  public /*const*/ ObjCPropertyRefExpr /*P*/ getObjCProperty() /*const*/ {
    /*const*/ Expr /*P*/ E = this;
    while (true) {
      assert ((E.getValueKind() == ExprValueKind.VK_LValue && E.getObjectKind() == ExprObjectKind.OK_ObjCProperty)) : "expression is not a property reference";
      E = E.IgnoreParenCasts$Const();
      {
        /*const*/ BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(E);
        if ((BO != null)) {
          if (BO.getOpcode() == BinaryOperatorKind.BO_Comma) {
            E = BO.getRHS();
            continue;
          }
        }
      }
      
      break;
    }
    
    return cast_ObjCPropertyRefExpr(E);
  }

  
  /// \brief Check if this expression is the ObjC 'self' implicit parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isObjCSelfExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3271,
   FQN="clang::Expr::isObjCSelfExpr", NM="_ZNK5clang4Expr14isObjCSelfExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr14isObjCSelfExprEv")
  //</editor-fold>
  public boolean isObjCSelfExpr() /*const*/ {
    /*const*/ Expr /*P*/ E = IgnoreParenImpCasts$Const();
    
    /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
    if (!(DRE != null)) {
      return false;
    }
    
    /*const*/ ImplicitParamDecl /*P*/ Param = dyn_cast_ImplicitParamDecl(DRE.getDecl$Const());
    if (!(Param != null)) {
      return false;
    }
    
    /*const*/ ObjCMethodDecl /*P*/ M = dyn_cast_ObjCMethodDecl(Param.getDeclContext$Const());
    if (!(M != null)) {
      return false;
    }
    
    return M.getSelfDecl() == Param;
  }

  
  /// \brief Returns whether this expression refers to a vector element.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::refersToVectorElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3330,
   FQN="clang::Expr::refersToVectorElement", NM="_ZNK5clang4Expr21refersToVectorElementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr21refersToVectorElementEv")
  //</editor-fold>
  public boolean refersToVectorElement() /*const*/ {
    /*const*/ Expr /*P*/ E = this.IgnoreParens$Const();
    {
      
      /*const*/ ImplicitCastExpr /*P*/ ICE;
      while (((/*P*/ ICE = dyn_cast_ImplicitCastExpr(E)) != null)) {
        if (ICE.getValueKind() != ExprValueKind.VK_RValue
           && ICE.getCastKind() == CastKind.CK_NoOp) {
          E = ICE.getSubExpr$Const().IgnoreParens$Const();
        } else {
          break;
        }
      }
    }
    {
      
      /*const*/ ArraySubscriptExpr /*P*/ ASE = dyn_cast_ArraySubscriptExpr(E);
      if ((ASE != null)) {
        return ASE.getBase$Const().getType().$arrow().isVectorType();
      }
    }
    if (isa_ExtVectorElementExpr(E)) {
      return true;
    }
    
    return false;
  }

  
  /// \brief Returns whether this expression refers to a global register
  /// variable.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::refersToGlobalRegisterVar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3350,
   FQN="clang::Expr::refersToGlobalRegisterVar", NM="_ZNK5clang4Expr25refersToGlobalRegisterVarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr25refersToGlobalRegisterVarEv")
  //</editor-fold>
  public boolean refersToGlobalRegisterVar() /*const*/ {
    /*const*/ Expr /*P*/ E = this.IgnoreParenImpCasts$Const();
    {
      
      /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
      if ((DRE != null)) {
        {
          /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DRE.getDecl$Const());
          if ((VD != null)) {
            if (VD.getStorageClass() == StorageClass.SC_Register
               && VD.hasAttr(AsmLabelAttr.class) && !VD.isLocalVarDecl()) {
              return true;
            }
          }
        }
      }
    }
    
    return false;
  }

  
  /// \brief Returns whether this expression has a placeholder type.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::hasPlaceholderType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 463,
   FQN="clang::Expr::hasPlaceholderType", NM="_ZNK5clang4Expr18hasPlaceholderTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr18hasPlaceholderTypeEv")
  //</editor-fold>
  public boolean hasPlaceholderType() /*const*/ {
    return getType().$arrow().isPlaceholderType();
  }

  
  /// \brief Returns whether this expression has a specific placeholder type.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::hasPlaceholderType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 468,
   FQN="clang::Expr::hasPlaceholderType", NM="_ZNK5clang4Expr18hasPlaceholderTypeENS_11BuiltinType4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr18hasPlaceholderTypeENS_11BuiltinType4KindE")
  //</editor-fold>
  public boolean hasPlaceholderType(BuiltinType.Kind K) /*const*/ {
    assert (BuiltinType.isPlaceholderTypeKind(K));
    {
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(getType());
      if ((BT != null)) {
        return BT.getKind() == K;
      }
    }
    return false;
  }

  
  /// isKnownToHaveBooleanValue - Return true if this is an integer expression
  /// that is known to return 0 or 1.  This happens for _Bool/bool expressions
  /// but also int expressions which are produced by things like comparisons in
  /// C.
  
  /// isKnownToHaveBooleanValue - Return true if this is an integer expression
  /// that is known to return 0 or 1.  This happens for _Bool/bool expressions
  /// but also int expressions which are produced by things like comparisons in
  /// C.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isKnownToHaveBooleanValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 112,
   FQN="clang::Expr::isKnownToHaveBooleanValue", NM="_ZNK5clang4Expr25isKnownToHaveBooleanValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr25isKnownToHaveBooleanValueEv")
  //</editor-fold>
  public boolean isKnownToHaveBooleanValue() /*const*/ {
    /*const*/ Expr /*P*/ E = IgnoreParens$Const();
    
    // If this value has _Bool type, it is obvious 0/1.
    if (E.getType().$arrow().isBooleanType()) {
      return true;
    }
    // If this is a non-scalar-integer type, we don't care enough to try. 
    if (!E.getType().$arrow().isIntegralOrEnumerationType()) {
      return false;
    }
    {
      
      /*const*/ UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(E);
      if ((UO != null)) {
        switch (UO.getOpcode()) {
         case UO_Plus:
          return UO.getSubExpr().isKnownToHaveBooleanValue();
         case UO_LNot:
          return true;
         default:
          return false;
        }
      }
    }
    {
      
      // Only look through implicit casts.  If the user writes
      // '(int) (a && b)' treat it as an arbitrary int.
      /*const*/ ImplicitCastExpr /*P*/ CE = dyn_cast_ImplicitCastExpr(E);
      if ((CE != null)) {
        return CE.getSubExpr$Const().isKnownToHaveBooleanValue();
      }
    }
    {
      
      /*const*/ BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(E);
      if ((BO != null)) {
        switch (BO.getOpcode()) {
         default:
          return false;
         case BO_LT: // Relational operators.
         case BO_GT:
         case BO_LE:
         case BO_GE:
         case BO_EQ: // Equality operators.
         case BO_NE:
         case BO_LAnd: // AND operator.
         case BO_LOr: // Logical OR operator.
          return true;
         case BO_And: // Bitwise AND operator.
         case BO_Xor: // Bitwise XOR operator.
         case BO_Or: // Bitwise OR operator.
          // Handle things like (x==2)|(y==12).
          return BO.getLHS().isKnownToHaveBooleanValue()
             && BO.getRHS().isKnownToHaveBooleanValue();
         case BO_Comma:
         case BO_Assign:
          return BO.getRHS().isKnownToHaveBooleanValue();
        }
      }
    }
    {
      
      /*const*/ ConditionalOperator /*P*/ CO = dyn_cast_ConditionalOperator(E);
      if ((CO != null)) {
        return CO.getTrueExpr().isKnownToHaveBooleanValue()
           && CO.getFalseExpr().isKnownToHaveBooleanValue();
      }
    }
    
    return false;
  }

  
  /// isIntegerConstantExpr - Return true if this expression is a valid integer
  /// constant expression, and, if so, return its value in Result.  If not a
  /// valid i-c-e, return false and fill in Loc (if specified) with the location
  /// of the invalid expression.
  ///
  /// Note: This does not perform the implicit conversions required by C++11
  /// [expr.const]p5.
  
  /// isIntegerConstantExpr - Return true if this expression is a valid integer
  /// constant expression, and, if so, return its value in Result.  If not a
  /// valid i-c-e, return false and fill in Loc (if specified) with the location
  /// of the invalid expression.
  ///
  /// Note: This does not perform the implicit conversions required by C++11
  /// [expr.const]p5.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isIntegerConstantExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9739,
   FQN="clang::Expr::isIntegerConstantExpr", NM="_ZNK5clang4Expr21isIntegerConstantExprERN4llvm6APSIntERKNS_10ASTContextEPNS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK5clang4Expr21isIntegerConstantExprERN4llvm6APSIntERKNS_10ASTContextEPNS_14SourceLocationEb")
  //</editor-fold>
  public boolean isIntegerConstantExpr(final APSInt /*&*/ Value, final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    return isIntegerConstantExpr(Value, Ctx, 
                       (type$ptr<SourceLocation> /*P*/ )null, true);
  }
  public boolean isIntegerConstantExpr(final APSInt /*&*/ Value, final /*const*/ ASTContext /*&*/ Ctx, 
                       type$ptr<SourceLocation> /*P*/ Loc/*= null*/) /*const*/ {
    return isIntegerConstantExpr(Value, Ctx, 
                       Loc, true);
  }
  public boolean isIntegerConstantExpr(final APSInt /*&*/ Value, final /*const*/ ASTContext /*&*/ Ctx, 
                       type$ptr<SourceLocation> /*P*/ Loc/*= null*/, boolean isEvaluated/*= true*/) /*const*/ {
    if (Ctx.getLangOpts().CPlusPlus11) {
      return EvaluateCPlusPlus11IntegralConstantExpr(Ctx, this, $AddrOf(Value), Loc);
    }
    if (!isIntegerConstantExpr(Ctx, Loc)) {
      return false;
    }
    // The only possible side-effects here are due to UB discovered in the
    // evaluation (for instance, INT_MAX + 1). In such a case, we are still
    // required to treat the expression as an ICE, so we produce the folded
    // value.
    if (!EvaluateAsInt(Value, Ctx, SideEffectsKind.SE_AllowSideEffects)) {
      throw new llvm_unreachable("ICE cannot be evaluated!");
    }
    return true;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isIntegerConstantExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9726,
   FQN="clang::Expr::isIntegerConstantExpr", NM="_ZNK5clang4Expr21isIntegerConstantExprERKNS_10ASTContextEPNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK5clang4Expr21isIntegerConstantExprERKNS_10ASTContextEPNS_14SourceLocationE")
  //</editor-fold>
  public boolean isIntegerConstantExpr(final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    return isIntegerConstantExpr(Ctx, 
                       (type$ptr<SourceLocation> /*P*/ )null);
  }
  public boolean isIntegerConstantExpr(final /*const*/ ASTContext /*&*/ Ctx, 
                       type$ptr<SourceLocation> /*P*/ Loc/*= null*/) /*const*/ {
    if (Ctx.getLangOpts().CPlusPlus11) {
      return EvaluateCPlusPlus11IntegralConstantExpr(Ctx, this, (APSInt /*P*/ )null, Loc);
    }
    
    ICEDiag D = CheckICE(this, Ctx);
    if (D.Kind != ICEKind.IK_ICE) {
      if (Native.$bool(Loc)) {
        Loc.$star().$assign(D.Loc);
      }
      return false;
    }
    return true;
  }


  
  /// isCXX98IntegralConstantExpr - Return true if this expression is an
  /// integral constant expression in C++98. Can only be used in C++.
  
  /// isCXX98IntegralConstantExpr - Return true if this expression is an
  /// integral constant expression in C++98. Can only be used in C++.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isCXX98IntegralConstantExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9755,
   FQN="clang::Expr::isCXX98IntegralConstantExpr", NM="_ZNK5clang4Expr27isCXX98IntegralConstantExprERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK5clang4Expr27isCXX98IntegralConstantExprERKNS_10ASTContextE")
  //</editor-fold>
  public boolean isCXX98IntegralConstantExpr(final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    return CheckICE(this, Ctx).Kind == ICEKind.IK_ICE;
  }


  
  /// isCXX11ConstantExpr - Return true if this expression is a constant
  /// expression in C++11. Can only be used in C++.
  ///
  /// Note: This does not perform the implicit conversions required by C++11
  /// [expr.const]p5.
  
  /// isCXX11ConstantExpr - Return true if this expression is a constant
  /// expression in C++11. Can only be used in C++.
  ///
  /// Note: This does not perform the implicit conversions required by C++11
  /// [expr.const]p5.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isCXX11ConstantExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9759,
   FQN="clang::Expr::isCXX11ConstantExpr", NM="_ZNK5clang4Expr19isCXX11ConstantExprERKNS_10ASTContextEPNS_7APValueEPNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK5clang4Expr19isCXX11ConstantExprERKNS_10ASTContextEPNS_7APValueEPNS_14SourceLocationE")
  //</editor-fold>
  public boolean isCXX11ConstantExpr(final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    return isCXX11ConstantExpr(Ctx, (APValue /*P*/ )null, 
                     (type$ptr<SourceLocation> /*P*/ )null);
  }
  public boolean isCXX11ConstantExpr(final /*const*/ ASTContext /*&*/ Ctx, APValue /*P*/ Result/*= null*/) /*const*/ {
    return isCXX11ConstantExpr(Ctx, Result, 
                     (type$ptr<SourceLocation> /*P*/ )null);
  }
  public boolean isCXX11ConstantExpr(final /*const*/ ASTContext /*&*/ Ctx, APValue /*P*/ Result/*= null*/, 
                     type$ptr<SourceLocation> /*P*/ Loc/*= null*/) /*const*/ {
    OptionalNotes Diags = null;
    EvalInfo Info = null;
    APValue Scratch = null;
    try {
      // We support this checking in C++98 mode in order to diagnose compatibility
      // issues.
      assert Native.$bool(Ctx.getLangOpts().CPlusPlus);
      
      // Build evaluation settings.
      Expr.EvalStatus Status/*J*/= new Expr.EvalStatus();
      Diags/*J*/= new OptionalNotes(8);
      Status.Diag = $AddrOf(Diags);
      Info/*J*/= new EvalInfo(Ctx, Status, EvalInfo.EvaluationMode.EM_ConstantExpression);
      
      Scratch/*J*/= new APValue();
      boolean IsConstExpr = ExprConstantStatics./*::*/EvaluateAsRValue(Info, this, (Result != null) ? $Deref(Result) : Scratch);
      if (!Diags.empty()) {
        IsConstExpr = false;
        if (Native.$bool(Loc)) {
          Loc.$star().$assign(Diags.$at(0).first);
        }
      } else if (!IsConstExpr) {
        // FIXME: This shouldn't happen.
        if (Native.$bool(Loc)) {
          Loc.$star().$assignMove(getExprLoc());
        }
      }
      
      return IsConstExpr;
    } finally {
      if (Scratch != null) { Scratch.$destroy(); }
      if (Info != null) { Info.$destroy(); }
      if (Diags != null) { Diags.$destroy(); }
    }
  }


  
  /// isPotentialConstantExpr - Return true if this function's definition
  /// might be usable in a constant expression in C++11, if it were marked
  /// constexpr. Return false if the function can never produce a constant
  /// expression, along with diagnostics describing why not.
  
  /// isPotentialConstantExpr - Return true if this function's definition
  /// might be usable in a constant expression in C++11, if it were marked
  /// constexpr. Return false if the function can never produce a constant
  /// expression, along with diagnostics describing why not.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isPotentialConstantExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9808,
   FQN="clang::Expr::isPotentialConstantExpr", NM="_ZN5clang4Expr23isPotentialConstantExprEPKNS_12FunctionDeclERN4llvm15SmallVectorImplISt4pairINS_14SourceLocationENS_17PartialDiagnosticEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN5clang4Expr23isPotentialConstantExprEPKNS_12FunctionDeclERN4llvm15SmallVectorImplISt4pairINS_14SourceLocationENS_17PartialDiagnosticEEEE")
  //</editor-fold>
  public static boolean isPotentialConstantExpr(/*const*/ FunctionDecl /*P*/ FD, 
                         final OptionalNotes /*&*/ Diags) {
    EvalInfo Info = null;
    LValue This = null;
    APValue Scratch = null;
    try {
      // FIXME: It would be useful to check constexpr function templates, but at the
      // moment the constant expression evaluator cannot cope with the non-rigorous
      // ASTs which we build for dependent expressions.
      if (FD.isDependentContext()) {
        return true;
      }
      
      Expr.EvalStatus Status/*J*/= new Expr.EvalStatus();
      Status.Diag = $AddrOf(Diags);
      
      Info/*J*/= new EvalInfo(FD.getASTContext(), Status, 
          EvalInfo.EvaluationMode.EM_PotentialConstantExpression);
      
      /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(FD);
      /*const*/ CXXRecordDecl /*P*/ RD = (MD != null) ? MD.getParent$Const().getCanonicalDecl$Const() : null;
      
      // Fabricate an arbitrary expression on the stack and pretend that it
      // is a temporary being used as the 'this' pointer.
      This/*J*/= new LValue();
      ImplicitValueInitExpr VIE/*J*/= new ImplicitValueInitExpr((RD != null) ? Info.Ctx.getRecordType(RD) : Info.Ctx.IntTy.$QualType());
      This.set(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T1.INSTANCE, /*const*/ Expr /*P*/ .class, $AddrOf(VIE)), Info.CurrentCall.Index);
      
      ArrayRef</*const*/ Expr /*P*/ > Args/*J*/= new ArrayRef</*const*/ Expr /*P*/ >(true);
      
      Scratch/*J*/= new APValue();
      {
        /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(FD);
        if ((CD != null)) {
          // Evaluate the call as a constant initializer, to allow the construction
          // of objects of non-literal types.
          Info.setEvaluatingDecl(This.getLValueBase(), Scratch);
          HandleConstructorCall($AddrOf(VIE), This, new ArrayRef</*const*/ Expr /*P*/ >(Args), CD, Info, Scratch);
        } else {
          SourceLocation Loc = FD.getLocation();
          HandleFunctionCall(new SourceLocation(Loc), FD, ((MD != null) && MD.isInstance()) ? $AddrOf(This) : (LValue /*P*/ )null, 
              new ArrayRef</*const*/ Expr /*P*/ >(Args), FD.getBody(), Info, Scratch, (/*const*/ LValue /*P*/ )null);
        }
      }
      
      return Diags.empty();
    } finally {
      if (Scratch != null) { Scratch.$destroy(); }
      if (This != null) { This.$destroy(); }
      if (Info != null) { Info.$destroy(); }
    }
  }


  
  /// isPotentialConstantExprUnevaluted - Return true if this expression might
  /// be usable in a constant expression in C++11 in an unevaluated context, if
  /// it were in function FD marked constexpr. Return false if the function can
  /// never produce a constant expression, along with diagnostics describing
  /// why not.
  
  /// isPotentialConstantExprUnevaluted - Return true if this expression might
  /// be usable in a constant expression in C++11 in an unevaluated context, if
  /// it were in function FD marked constexpr. Return false if the function can
  /// never produce a constant expression, along with diagnostics describing
  /// why not.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isPotentialConstantExprUnevaluated">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9849,
   FQN="clang::Expr::isPotentialConstantExprUnevaluated", NM="_ZN5clang4Expr34isPotentialConstantExprUnevaluatedEPS0_PKNS_12FunctionDeclERN4llvm15SmallVectorImplISt4pairINS_14SourceLocationENS_17PartialDiagnosticEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN5clang4Expr34isPotentialConstantExprUnevaluatedEPS0_PKNS_12FunctionDeclERN4llvm15SmallVectorImplISt4pairINS_14SourceLocationENS_17PartialDiagnosticEEEE")
  //</editor-fold>
  public static boolean isPotentialConstantExprUnevaluated(Expr /*P*/ E, 
                                    /*const*/ FunctionDecl /*P*/ FD, 
                                    final OptionalNotes /*&*/ Diags) {
    EvalInfo Info = null;
    SmallVector<APValue> ArgValues = null;
    CallStackFrame Frame = null;
    APValue ResultScratch = null;
    try {
      Expr.EvalStatus Status/*J*/= new Expr.EvalStatus();
      Status.Diag = $AddrOf(Diags);
      
      Info/*J*/= new EvalInfo(FD.getASTContext(), Status, 
          EvalInfo.EvaluationMode.EM_PotentialConstantExpressionUnevaluated);
      
      // Fabricate a call stack frame to give the arguments a plausible cover story.
      ArrayRef</*const*/ Expr /*P*/ > Args/*J*/= new ArrayRef</*const*/ Expr /*P*/ >(true);
      ArgValues/*J*/= new SmallVector<APValue>(JD$UInt_T$C$R.INSTANCE, 8, 0, new APValue());
      boolean Success = EvaluateArgs(new ArrayRef</*const*/ Expr /*P*/ >(Args), ArgValues, Info);
      //Java /*J:(void)*/Success;
      assert (Success) : "Failed to set up arguments for potential constant evaluation";
      Frame/*J*/= new CallStackFrame(Info, new SourceLocation(), FD, (/*const*/ LValue /*P*/ )null, ArgValues.data());
      
      ResultScratch/*J*/= new APValue();
      Evaluate(ResultScratch, Info, E);
      return Diags.empty();
    } finally {
      if (ResultScratch != null) { ResultScratch.$destroy(); }
      if (Frame != null) { Frame.$destroy(); }
      if (ArgValues != null) { ArgValues.$destroy(); }
      if (Info != null) { Info.$destroy(); }
    }
  }


  
  /// isConstantInitializer - Returns true if this expression can be emitted to
  /// IR as a constant, and thus can be used as a constant initializer in C.
  /// If this expression is not constant and Culprit is non-null,
  /// it is used to store the address of first non constant expr.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isConstantInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 2614,
   FQN="clang::Expr::isConstantInitializer", NM="_ZNK5clang4Expr21isConstantInitializerERNS_10ASTContextEbPPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr21isConstantInitializerERNS_10ASTContextEbPPKS0_")
  //</editor-fold>
  public boolean isConstantInitializer(final ASTContext /*&*/ Ctx, boolean IsForRef) /*const*/ {
    return isConstantInitializer(Ctx, IsForRef, 
                       (type$ptr</*const*/ Expr /*P*/ /*P*/>)null);
  }
  public boolean isConstantInitializer(final ASTContext /*&*/ Ctx, boolean IsForRef, 
                       type$ptr</*const*/ Expr /*P*/ /*P*/> Culprit/*= null*/) /*const*/ {
    // This function is attempting whether an expression is an initializer
    // which can be evaluated at compile-time. It very closely parallels
    // ConstExprEmitter in CGExprConstant.cpp; if they don't match, it
    // will lead to unexpected results.  Like ConstExprEmitter, it falls back
    // to isEvaluatable most of the time.
    //
    // If we ever capture reference-binding directly in the AST, we can
    // kill the second parameter.
    if (IsForRef) {
      EvalResult Result = null;
      try {
        Result/*J*/= new EvalResult();
        if (EvaluateAsLValue(Result, Ctx) && !Result.HasSideEffects) {
          return true;
        }
        if (Native.$bool(Culprit)) {
          Culprit.$set(this);
        }
        return false;
      } finally {
        if (Result != null) { Result.$destroy(); }
      }
    }
    switch (getStmtClass()) {
     default:
      break;
     case StringLiteralClass:
     case ObjCEncodeExprClass:
      return true;
     case CXXTemporaryObjectExprClass:
     case CXXConstructExprClass:
      {
        /*const*/ CXXConstructExpr /*P*/ CE = cast_CXXConstructExpr(this);
        if (CE.getConstructor().isTrivial()
           && CE.getConstructor().getParent().hasTrivialDestructor()) {
          // Trivial default constructor
          if (!(CE.getNumArgs() != 0)) {
            return true;
          }
          
          // Trivial copy constructor
          assert (CE.getNumArgs() == 1) : "trivial ctor with > 1 argument";
          return CE.getArg$Const(0).isConstantInitializer(Ctx, false, Culprit);
        }
        
        break;
      }
     case CompoundLiteralExprClass:
      {
        // This handles gcc's extension that allows global initializers like
        // "struct x {int x;} x = (struct x) {};".
        // FIXME: This accepts other cases it shouldn't!
        /*const*/ Expr /*P*/ Exp = cast_CompoundLiteralExpr(this).getInitializer$Const();
        return Exp.isConstantInitializer(Ctx, false, Culprit);
      }
     case DesignatedInitUpdateExprClass:
      {
        /*const*/ DesignatedInitUpdateExpr /*P*/ DIUE = cast_DesignatedInitUpdateExpr(this);
        return DIUE.getBase().isConstantInitializer(Ctx, false, Culprit)
           && DIUE.getUpdater().isConstantInitializer(Ctx, false, Culprit);
      }
     case InitListExprClass:
      {
        /*const*/ InitListExpr /*P*/ ILE = cast_InitListExpr(this);
        if (ILE.getType().$arrow().isArrayType()) {
          /*uint*/int numInits = ILE.getNumInits();
          for (/*uint*/int i = 0; $less_uint(i, numInits); i++) {
            if (!ILE.getInit$Const(i).isConstantInitializer(Ctx, false, Culprit)) {
              return false;
            }
          }
          return true;
        }
        if (ILE.getType().$arrow().isRecordType()) {
          /*uint*/int ElementNo = 0;
          RecordDecl /*P*/ RD = ILE.getType().$arrow().<RecordType>getAs$RecordType().getDecl();
          for (/*const*/ FieldDecl /*P*/ Field : RD.fields()) {
            // If this is a union, skip all the fields that aren't being initialized.
            if (RD.isUnion() && ILE.getInitializedFieldInUnion$Const() != Field) {
              continue;
            }
            
            // Don't emit anonymous bitfields, they just affect layout.
            if (Field.isUnnamedBitfield()) {
              continue;
            }
            if ($less_uint(ElementNo, ILE.getNumInits())) {
              /*const*/ Expr /*P*/ Elt = ILE.getInit$Const(ElementNo++);
              if (Field.isBitField()) {
                // Bitfields have to evaluate to an integer.
                APSInt ResultTmp/*J*/= new APSInt();
                if (!Elt.EvaluateAsInt(ResultTmp, Ctx)) {
                  if (Native.$bool(Culprit)) {
                    Culprit.$set(Elt);
                  }
                  return false;
                }
              } else {
                boolean RefType = Field.getType().$arrow().isReferenceType();
                if (!Elt.isConstantInitializer(Ctx, RefType, Culprit)) {
                  return false;
                }
              }
            }
          }
          return true;
        }
        
        break;
      }
     case ImplicitValueInitExprClass:
     case NoInitExprClass:
      return true;
     case ParenExprClass:
      return cast_ParenExpr(this).getSubExpr$Const().
          isConstantInitializer(Ctx, IsForRef, Culprit);
     case GenericSelectionExprClass:
      return cast_GenericSelectionExpr(this).getResultExpr$Const().
          isConstantInitializer(Ctx, IsForRef, Culprit);
     case ChooseExprClass:
      if (cast_ChooseExpr(this).isConditionDependent()) {
        if (Native.$bool(Culprit)) {
          Culprit.$set(this);
        }
        return false;
      }
      return cast_ChooseExpr(this).getChosenSubExpr().
          isConstantInitializer(Ctx, IsForRef, Culprit);
     case UnaryOperatorClass:
      {
        /*const*/ UnaryOperator /*P*/ Exp = cast_UnaryOperator(this);
        if (Exp.getOpcode() == UnaryOperatorKind.UO_Extension) {
          return Exp.getSubExpr().isConstantInitializer(Ctx, false, Culprit);
        }
        break;
      }
     case CXXFunctionalCastExprClass:
     case CXXStaticCastExprClass:
     case ImplicitCastExprClass:
     case CStyleCastExprClass:
     case ObjCBridgedCastExprClass:
     case CXXDynamicCastExprClass:
     case CXXReinterpretCastExprClass:
     case CXXConstCastExprClass:
      {
        /*const*/ CastExpr /*P*/ CE = cast_CastExpr(this);
        
        // Handle misc casts we want to ignore.
        if (CE.getCastKind() == CastKind.CK_NoOp
           || CE.getCastKind() == CastKind.CK_LValueToRValue
           || CE.getCastKind() == CastKind.CK_ToUnion
           || CE.getCastKind() == CastKind.CK_ConstructorConversion
           || CE.getCastKind() == CastKind.CK_NonAtomicToAtomic
           || CE.getCastKind() == CastKind.CK_AtomicToNonAtomic) {
          return CE.getSubExpr$Const().isConstantInitializer(Ctx, false, Culprit);
        }
        
        break;
      }
     case MaterializeTemporaryExprClass:
      return cast_MaterializeTemporaryExpr(this).GetTemporaryExpr().
          isConstantInitializer(Ctx, false, Culprit);
     case SubstNonTypeTemplateParmExprClass:
      return cast_SubstNonTypeTemplateParmExpr(this).getReplacement().
          isConstantInitializer(Ctx, false, Culprit);
     case CXXDefaultArgExprClass:
      return cast_CXXDefaultArgExpr(this).getExpr$Const().
          isConstantInitializer(Ctx, false, Culprit);
     case CXXDefaultInitExprClass:
      return cast_CXXDefaultInitExpr(this).getExpr$Const().
          isConstantInitializer(Ctx, false, Culprit);
    }
    // Allow certain forms of UB in constant initializers: signed integer
    // overflow and floating-point division by zero. We'll give a warning on
    // these, but they're common enough that we have to accept them.
    if (isEvaluatable(Ctx, SideEffectsKind.SE_AllowUndefinedBehavior)) {
      return true;
    }
    if (Culprit != null) {
      Culprit.$set(this);
    }
    return false;
  }

  
  /// EvalStatus is a struct with detailed info about an evaluation in progress.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::EvalStatus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 532,
   FQN="clang::Expr::EvalStatus", NM="_ZN5clang4Expr10EvalStatusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr10EvalStatusE")
  //</editor-fold>
  public static class/*struct*/ EvalStatus {
    /// \brief Whether the evaluated expression has side effects.
    /// For example, (f() && 0) can be folded, but it still has side effects.
    public boolean HasSideEffects;
    
    /// \brief Whether the evaluation hit undefined behavior.
    /// For example, 1.0 / 0.0 can be folded to Inf, but has undefined behavior.
    /// Likewise, INT_MAX + 1 can be folded to INT_MIN, but has UB.
    public boolean HasUndefinedBehavior;
    
    /// Diag - If this is non-null, it will be filled in with a stack of notes
    /// indicating why evaluation failed (or why it failed to produce a constant
    /// expression).
    /// If the expression is unfoldable, the notes will indicate why it's not
    /// foldable. If the expression is foldable, but not a constant expression,
    /// the notes will describes why it isn't a constant expression. If the
    /// expression *is* a constant expression, no notes will be produced.
    public OptionalNotes /*P*/ Diag;
    
    //<editor-fold defaultstate="collapsed" desc="clang::Expr::EvalStatus::EvalStatus">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 551,
     FQN="clang::Expr::EvalStatus::EvalStatus", NM="_ZN5clang4Expr10EvalStatusC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr10EvalStatusC1Ev")
    //</editor-fold>
    public EvalStatus() {
      // : HasSideEffects(false), HasUndefinedBehavior(false), Diag(null) 
      //START JInit
      this.HasSideEffects = false;
      this.HasUndefinedBehavior = false;
      this.Diag = null;
      //END JInit
    }
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public /*virtual*/ void $destroy() {
    }

    // hasSideEffects - Return true if the evaluated expression has
    // side effects.
    //<editor-fold defaultstate="collapsed" desc="clang::Expr::EvalStatus::hasSideEffects">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 556,
     FQN="clang::Expr::EvalStatus::hasSideEffects", NM="_ZNK5clang4Expr10EvalStatus14hasSideEffectsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr10EvalStatus14hasSideEffectsEv")
    //</editor-fold>
    public boolean hasSideEffects() /*const*/ {
      return HasSideEffects;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Expr::EvalStatus::EvalStatus">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 532,
     FQN="clang::Expr::EvalStatus::EvalStatus", NM="_ZN5clang4Expr10EvalStatusC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN5clang4Expr10EvalStatusC1ERKS1_")
    //</editor-fold>
    public /*inline*/ EvalStatus(final /*const*/ EvalStatus /*&*/ $Prm0) {
      // : HasSideEffects(.HasSideEffects), HasUndefinedBehavior(.HasUndefinedBehavior), Diag(.Diag) 
      //START JInit
      this.HasSideEffects = $Prm0.HasSideEffects;
      this.HasUndefinedBehavior = $Prm0.HasUndefinedBehavior;
      this.Diag = $Prm0.Diag;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Expr::EvalStatus::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 532,
     FQN="clang::Expr::EvalStatus::operator=", NM="_ZN5clang4Expr10EvalStatusaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN5clang4Expr10EvalStatusaSERKS1_")
    //</editor-fold>
    public /*inline*/ EvalStatus /*&*/ $assign(final /*const*/ EvalStatus /*&*/ $Prm0) {
      this.HasSideEffects = $Prm0.HasSideEffects;
      this.HasUndefinedBehavior = $Prm0.HasUndefinedBehavior;
      this.Diag = $Prm0.Diag;
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "HasSideEffects=" + HasSideEffects // NOI18N
                + ", HasUndefinedBehavior=" + HasUndefinedBehavior // NOI18N
                + ", Diag=" + Diag; // NOI18N
    }
  };
  
  /// EvalResult is a struct with detailed info about an evaluated expression.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::EvalResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 562,
   FQN="clang::Expr::EvalResult", NM="_ZN5clang4Expr10EvalResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr10EvalResultE")
  //</editor-fold>
  public static class/*struct*/ EvalResult extends /**/ EvalStatus implements Destructors.ClassWithDestructor {
    /// Val - This is the value the expression can be folded to.
    public APValue Val;
    
    // isGlobalLValue - Return true if the evaluated lvalue expression
    // is global.
    
    // isGlobalLValue - Return true if the evaluated lvalue expression
    // is global.
    //<editor-fold defaultstate="collapsed" desc="clang::Expr::EvalResult::isGlobalLValue">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9267,
     FQN="clang::Expr::EvalResult::isGlobalLValue", NM="_ZNK5clang4Expr10EvalResult14isGlobalLValueEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK5clang4Expr10EvalResult14isGlobalLValueEv")
    //</editor-fold>
    public boolean isGlobalLValue() /*const*/ {
      assert (Val.isLValue());
      return IsGlobalLValue(Val.getLValueBase());
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Expr::EvalResult::~EvalResult">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 562,
     FQN="clang::Expr::EvalResult::~EvalResult", NM="_ZN5clang4Expr10EvalResultD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr10EvalResultD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Val.$destroy();
      super.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Expr::EvalResult::EvalResult">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 562,
     FQN="clang::Expr::EvalResult::EvalResult", NM="_ZN5clang4Expr10EvalResultC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr10EvalResultC1Ev")
    //</editor-fold>
    public /*inline*/ EvalResult() {
      // : EvalStatus(), Val() 
      //START JInit
      super();
      this.Val = new APValue();
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Val=" + Val // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  /// EvaluateAsRValue - Return true if this is a constant which we can fold to
  /// an rvalue using any crazy technique (that has nothing to do with language
  /// standards) that we want to, even if the expression has side-effects. If
  /// this function returns true, it returns the folded constant in Result. If
  /// the expression is a glvalue, an lvalue-to-rvalue conversion will be
  /// applied.
  
  /// EvaluateAsRValue - Return true if this is a constant which we can fold to
  /// an rvalue using any crazy technique (that has nothing to do with language
  /// standards) that we want to, even if the expression has side-effects. If
  /// this function returns true, it returns the folded constant in Result. If
  /// the expression is a glvalue, an lvalue-to-rvalue conversion will be
  /// applied.
  
  /// EvaluateAsRValue - Return true if this is a constant which we can fold using
  /// any crazy technique (that has nothing to do with language standards) that
  /// we want to.  If this function returns true, it returns the folded constant
  /// in Result. If this expression is a glvalue, an lvalue-to-rvalue conversion
  /// will be applied to the result.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::EvaluateAsRValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9134,
   FQN="clang::Expr::EvaluateAsRValue", NM="_ZNK5clang4Expr16EvaluateAsRValueERNS0_10EvalResultERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK5clang4Expr16EvaluateAsRValueERNS0_10EvalResultERKNS_10ASTContextE")
  //</editor-fold>
  public boolean EvaluateAsRValue(final EvalResult /*&*/ Result, final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    EvalInfo Info = null;
    try {
      bool$ref IsConst = create_bool$ref();
      if (FastEvaluateAsRValue(this, Result, Ctx, IsConst)) {
        return IsConst.$deref();
      }
      
      Info/*J*/= new EvalInfo(Ctx, Result, EvalInfo.EvaluationMode.EM_IgnoreSideEffects);
      return ExprConstantStatics./*::*/EvaluateAsRValue(Info, this, Result.Val);
    } finally {
      if (Info != null) { Info.$destroy(); }
    }
  }


  
  /// EvaluateAsBooleanCondition - Return true if this is a constant
  /// which we we can fold and convert to a boolean condition using
  /// any crazy technique that we want to, even if the expression has
  /// side-effects.
  
  /// EvaluateAsBooleanCondition - Return true if this is a constant
  /// which we we can fold and convert to a boolean condition using
  /// any crazy technique that we want to, even if the expression has
  /// side-effects.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::EvaluateAsBooleanCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9143,
   FQN="clang::Expr::EvaluateAsBooleanCondition", NM="_ZNK5clang4Expr26EvaluateAsBooleanConditionERbRKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK5clang4Expr26EvaluateAsBooleanConditionERbRKNS_10ASTContextE")
  //</editor-fold>
  public boolean EvaluateAsBooleanCondition(final bool$ref/*bool &*/ Result, 
                            final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    EvalResult Scratch = null;
    try {
      Scratch/*J*/= new EvalResult();
      return EvaluateAsRValue(Scratch, Ctx)
         && HandleConversionToBool(Scratch.Val, Result);
    } finally {
      if (Scratch != null) { Scratch.$destroy(); }
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::SideEffectsKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 585,
   FQN="clang::Expr::SideEffectsKind", NM="_ZN5clang4Expr15SideEffectsKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr15SideEffectsKindE")
  //</editor-fold>
  public enum SideEffectsKind implements Native.ComparableLower {
    SE_NoSideEffects(0), ///< Strictly evaluate the expression.
    SE_AllowUndefinedBehavior(SE_NoSideEffects.getValue() + 1), ///< Allow UB that we can give a value, but not
    ///< arbitrary unmodeled side effects.
    SE_AllowSideEffects(SE_AllowUndefinedBehavior.getValue() + 1); ///< Allow any unmodeled side effect.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SideEffectsKind valueOf(int val) {
      SideEffectsKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SideEffectsKind[] VALUES;
      private static final SideEffectsKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SideEffectsKind kind : SideEffectsKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SideEffectsKind[min < 0 ? (1-min) : 0];
        VALUES = new SideEffectsKind[max >= 0 ? (1+max) : 0];
        for (SideEffectsKind kind : SideEffectsKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private SideEffectsKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((SideEffectsKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((SideEffectsKind)obj).value);}
    //</editor-fold>
  };
  
  /// EvaluateAsInt - Return true if this is a constant which we can fold and
  /// convert to an integer, using any crazy technique that we want to.
  
  /// EvaluateAsInt - Return true if this is a constant which we can fold and
  /// convert to an integer, using any crazy technique that we want to.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::EvaluateAsInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9156,
   FQN="clang::Expr::EvaluateAsInt", NM="_ZNK5clang4Expr13EvaluateAsIntERN4llvm6APSIntERKNS_10ASTContextENS0_15SideEffectsKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK5clang4Expr13EvaluateAsIntERN4llvm6APSIntERKNS_10ASTContextENS0_15SideEffectsKindE")
  //</editor-fold>
  public boolean EvaluateAsInt(final APSInt /*&*/ Result, final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    return EvaluateAsInt(Result, Ctx, 
               SideEffectsKind.SE_NoSideEffects);
  }
  public boolean EvaluateAsInt(final APSInt /*&*/ Result, final /*const*/ ASTContext /*&*/ Ctx, 
               SideEffectsKind AllowSideEffects/*= SE_NoSideEffects*/) /*const*/ {
    EvalResult ExprResult = null;
    try {
      if (!getType().$arrow().isIntegralOrEnumerationType()) {
        return false;
      }
      
      ExprResult/*J*/= new EvalResult();
      if (!EvaluateAsRValue(ExprResult, Ctx) || !ExprResult.Val.isInt()
         || hasUnacceptableSideEffect(ExprResult, AllowSideEffects)) {
        return false;
      }
      
      Result.$assign(ExprResult.Val.getInt());
      return true;
    } finally {
      if (ExprResult != null) { ExprResult.$destroy(); }
    }
  }


  
  /// EvaluateAsFloat - Return true if this is a constant which we can fold and
  /// convert to a floating point value, using any crazy technique that we
  /// want to.
  
  /// EvaluateAsFloat - Return true if this is a constant which we can fold and
  /// convert to a floating point value, using any crazy technique that we
  /// want to.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::EvaluateAsFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9170,
   FQN="clang::Expr::EvaluateAsFloat", NM="_ZNK5clang4Expr15EvaluateAsFloatERN4llvm7APFloatERKNS_10ASTContextENS0_15SideEffectsKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK5clang4Expr15EvaluateAsFloatERN4llvm7APFloatERKNS_10ASTContextENS0_15SideEffectsKindE")
  //</editor-fold>
  public boolean EvaluateAsFloat(final APFloat /*&*/ Result, final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    return EvaluateAsFloat(Result, Ctx, 
                 SideEffectsKind.SE_NoSideEffects);
  }
  public boolean EvaluateAsFloat(final APFloat /*&*/ Result, final /*const*/ ASTContext /*&*/ Ctx, 
                 SideEffectsKind AllowSideEffects/*= SE_NoSideEffects*/) /*const*/ {
    EvalResult ExprResult = null;
    try {
      if (!getType().$arrow().isRealFloatingType()) {
        return false;
      }
      
      ExprResult/*J*/= new EvalResult();
      if (!EvaluateAsRValue(ExprResult, Ctx) || !ExprResult.Val.isFloat()
         || hasUnacceptableSideEffect(ExprResult, AllowSideEffects)) {
        return false;
      }
      
      Result.$assign(ExprResult.Val.getFloat());
      return true;
    } finally {
      if (ExprResult != null) { ExprResult.$destroy(); }
    }
  }


  
  /// isEvaluatable - Call EvaluateAsRValue to see if this expression can be
  /// constant folded without side-effects, but discard the result.
  
  /// isEvaluatable - Call EvaluateAsRValue to see if this expression can be
  /// constant folded without side-effects, but discard the result.
  
  /// isEvaluatable - Call EvaluateAsRValue to see if this expression can be
  /// constant folded, but discard the result.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isEvaluatable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9240,
   FQN="clang::Expr::isEvaluatable", NM="_ZNK5clang4Expr13isEvaluatableERKNS_10ASTContextENS0_15SideEffectsKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK5clang4Expr13isEvaluatableERKNS_10ASTContextENS0_15SideEffectsKindE")
  //</editor-fold>
  public boolean isEvaluatable(final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    return isEvaluatable(Ctx, SideEffectsKind.SE_NoSideEffects);
  }
  public boolean isEvaluatable(final /*const*/ ASTContext /*&*/ Ctx, SideEffectsKind SEK/*= SE_NoSideEffects*/) /*const*/ {
    EvalResult Result = null;
    try {
      Result/*J*/= new EvalResult();
      return EvaluateAsRValue(Result, Ctx)
         && !hasUnacceptableSideEffect(Result, SEK);
    } finally {
      if (Result != null) { Result.$destroy(); }
    }
  }


  
  /// HasSideEffects - This routine returns true for all those expressions
  /// which have any effect other than producing a value. Example is a function
  /// call, volatile variable read, or throwing an exception. If
  /// IncludePossibleEffects is false, this call treats certain expressions with
  /// potential side effects (such as function call-like expressions,
  /// instantiation-dependent expressions, or invocations from a macro) as not
  /// having side effects.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::HasSideEffects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 2802,
   FQN="clang::Expr::HasSideEffects", NM="_ZNK5clang4Expr14HasSideEffectsERKNS_10ASTContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr14HasSideEffectsERKNS_10ASTContextEb")
  //</editor-fold>
  public boolean HasSideEffects(final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    return HasSideEffects(Ctx, 
                true);
  }
  public boolean HasSideEffects(final /*const*/ ASTContext /*&*/ Ctx, 
                boolean IncludePossibleEffects/*= true*/) /*const*/ {
    // In circumstances where we care about definite side effects instead of
    // potential side effects, we want to ignore expressions that are part of a
    // macro expansion as a potential side effect.
    if (!IncludePossibleEffects && getExprLoc().isMacroID()) {
      return false;
    }
    if (isInstantiationDependent()) {
      return IncludePossibleEffects;
    }
    switch (getStmtClass()) {
     case NoStmtClass:
     case GCCAsmStmtClass:
     case MSAsmStmtClass:
     case AttributedStmtClass:
     case BreakStmtClass:
     case CXXCatchStmtClass:
     case CXXForRangeStmtClass:
     case CXXTryStmtClass:
     case CapturedStmtClass:
     case CompoundStmtClass:
     case ContinueStmtClass:
     case CoreturnStmtClass:
     case CoroutineBodyStmtClass:
     case DeclStmtClass:
     case DoStmtClass:
     case ForStmtClass:
     case GotoStmtClass:
     case IfStmtClass:
     case IndirectGotoStmtClass:
     case LabelStmtClass:
     case MSDependentExistsStmtClass:
     case NullStmtClass:
     case OMPAtomicDirectiveClass:
     case OMPBarrierDirectiveClass:
     case OMPCancelDirectiveClass:
     case OMPCancellationPointDirectiveClass:
     case OMPCriticalDirectiveClass:
     case OMPFlushDirectiveClass:
     case OMPDistributeDirectiveClass:
     case OMPDistributeParallelForDirectiveClass:
     case OMPDistributeParallelForSimdDirectiveClass:
     case OMPDistributeSimdDirectiveClass:
     case OMPForDirectiveClass:
     case OMPForSimdDirectiveClass:
     case OMPParallelForDirectiveClass:
     case OMPParallelForSimdDirectiveClass:
     case OMPSimdDirectiveClass:
     case OMPTargetParallelForSimdDirectiveClass:
     case OMPTaskLoopDirectiveClass:
     case OMPTaskLoopSimdDirectiveClass:
     case OMPMasterDirectiveClass:
     case OMPOrderedDirectiveClass:
     case OMPParallelDirectiveClass:
     case OMPParallelSectionsDirectiveClass:
     case OMPSectionDirectiveClass:
     case OMPSectionsDirectiveClass:
     case OMPSingleDirectiveClass:
     case OMPTargetDataDirectiveClass:
     case OMPTargetDirectiveClass:
     case OMPTargetEnterDataDirectiveClass:
     case OMPTargetExitDataDirectiveClass:
     case OMPTargetParallelDirectiveClass:
     case OMPTargetParallelForDirectiveClass:
     case OMPTargetUpdateDirectiveClass:
     case OMPTaskDirectiveClass:
     case OMPTaskgroupDirectiveClass:
     case OMPTaskwaitDirectiveClass:
     case OMPTaskyieldDirectiveClass:
     case OMPTeamsDirectiveClass:
     case ObjCAtCatchStmtClass:
     case ObjCAtFinallyStmtClass:
     case ObjCAtSynchronizedStmtClass:
     case ObjCAtThrowStmtClass:
     case ObjCAtTryStmtClass:
     case ObjCAutoreleasePoolStmtClass:
     case ObjCForCollectionStmtClass:
     case ReturnStmtClass:
     case SEHExceptStmtClass:
     case SEHFinallyStmtClass:
     case SEHLeaveStmtClass:
     case SEHTryStmtClass:
     case CaseStmtClass:
     case DefaultStmtClass:
     case SwitchStmtClass:
     case WhileStmtClass:
      throw new llvm_unreachable("unexpected Expr kind");
     case DependentScopeDeclRefExprClass:
     case CXXUnresolvedConstructExprClass:
     case CXXDependentScopeMemberExprClass:
     case UnresolvedLookupExprClass:
     case UnresolvedMemberExprClass:
     case PackExpansionExprClass:
     case SubstNonTypeTemplateParmPackExprClass:
     case FunctionParmPackExprClass:
     case TypoExprClass:
     case CXXFoldExprClass:
      throw new llvm_unreachable("shouldn't see dependent / unresolved nodes here");
     case DeclRefExprClass:
     case ObjCIvarRefExprClass:
     case PredefinedExprClass:
     case IntegerLiteralClass:
     case FloatingLiteralClass:
     case ImaginaryLiteralClass:
     case StringLiteralClass:
     case CharacterLiteralClass:
     case OffsetOfExprClass:
     case ImplicitValueInitExprClass:
     case UnaryExprOrTypeTraitExprClass:
     case AddrLabelExprClass:
     case GNUNullExprClass:
     case NoInitExprClass:
     case CXXBoolLiteralExprClass:
     case CXXNullPtrLiteralExprClass:
     case CXXThisExprClass:
     case CXXScalarValueInitExprClass:
     case TypeTraitExprClass:
     case ArrayTypeTraitExprClass:
     case ExpressionTraitExprClass:
     case CXXNoexceptExprClass:
     case SizeOfPackExprClass:
     case ObjCStringLiteralClass:
     case ObjCEncodeExprClass:
     case ObjCBoolLiteralExprClass:
     case ObjCAvailabilityCheckExprClass:
     case CXXUuidofExprClass:
     case OpaqueValueExprClass:
      // These never have a side-effect.
      return false;
     case CallExprClass:
     case CXXOperatorCallExprClass:
     case CXXMemberCallExprClass:
     case CUDAKernelCallExprClass:
     case UserDefinedLiteralClass:
      {
        // We don't know a call definitely has side effects, except for calls
        // to pure/const functions that definitely don't.
        // If the call itself is considered side-effect free, check the operands.
        /*const*/ Decl /*P*/ FD = cast_CallExpr(this).getCalleeDecl$Const();
        boolean IsPure = (FD != null) && (FD.hasAttr(ConstAttr.class) || FD.hasAttr(PureAttr.class));
        if (IsPure || !IncludePossibleEffects) {
          break;
        }
        return true;
      }
     case BlockExprClass:
     case CXXBindTemporaryExprClass:
      if (!IncludePossibleEffects) {
        break;
      }
      return true;
     case MSPropertyRefExprClass:
     case MSPropertySubscriptExprClass:
     case CompoundAssignOperatorClass:
     case VAArgExprClass:
     case AtomicExprClass:
     case CXXThrowExprClass:
     case CXXNewExprClass:
     case CXXDeleteExprClass:
     case CoawaitExprClass:
     case CoyieldExprClass:
      // These always have a side-effect.
      return true;
     case StmtExprClass:
      {
        // StmtExprs have a side-effect if any substatement does.
        SideEffectFinder Finder/*J*/= new SideEffectFinder(Ctx, IncludePossibleEffects);
        Finder.Visit(cast_StmtExpr(this).getSubStmt$Const());
        return Finder.hasSideEffects();
      }
     case ExprWithCleanupsClass:
      if (IncludePossibleEffects) {
        if (cast_ExprWithCleanups(this).cleanupsHaveSideEffects()) {
          return true;
        }
      }
      break;
     case ParenExprClass:
     case ArraySubscriptExprClass:
     case OMPArraySectionExprClass:
     case MemberExprClass:
     case ConditionalOperatorClass:
     case BinaryConditionalOperatorClass:
     case CompoundLiteralExprClass:
     case ExtVectorElementExprClass:
     case DesignatedInitExprClass:
     case DesignatedInitUpdateExprClass:
     case ParenListExprClass:
     case CXXPseudoDestructorExprClass:
     case CXXStdInitializerListExprClass:
     case SubstNonTypeTemplateParmExprClass:
     case MaterializeTemporaryExprClass:
     case ShuffleVectorExprClass:
     case ConvertVectorExprClass:
     case AsTypeExprClass:
      // These have a side-effect if any subexpression does.
      break;
     case UnaryOperatorClass:
      if (cast_UnaryOperator(this).isIncrementDecrementOp()) {
        return true;
      }
      break;
     case BinaryOperatorClass:
      if (cast_BinaryOperator(this).isAssignmentOp()) {
        return true;
      }
      break;
     case InitListExprClass:
      {
        // FIXME: The children for an InitListExpr doesn't include the array filler.
        /*const*/ Expr /*P*/ E = cast_InitListExpr(this).getArrayFiller$Const();
        if ((E != null)) {
          if (E.HasSideEffects(Ctx, IncludePossibleEffects)) {
            return true;
          }
        }
      }
      break;
     case GenericSelectionExprClass:
      return cast_GenericSelectionExpr(this).getResultExpr$Const().
          HasSideEffects(Ctx, IncludePossibleEffects);
     case ChooseExprClass:
      return cast_ChooseExpr(this).getChosenSubExpr().HasSideEffects(Ctx, IncludePossibleEffects);
     case CXXDefaultArgExprClass:
      return cast_CXXDefaultArgExpr(this).getExpr$Const().HasSideEffects(Ctx, IncludePossibleEffects);
     case CXXDefaultInitExprClass:
      {
        /*const*/ FieldDecl /*P*/ FD = cast_CXXDefaultInitExpr(this).getField$Const();
        {
          /*const*/ Expr /*P*/ E = FD.getInClassInitializer();
          if ((E != null)) {
            return E.HasSideEffects(Ctx, IncludePossibleEffects);
          }
        }
        // If we've not yet parsed the initializer, assume it has side-effects.
        return true;
      }
     case CXXDynamicCastExprClass:
      {
        // A dynamic_cast expression has side-effects if it can throw.
        /*const*/ CXXDynamicCastExpr /*P*/ DCE = cast_CXXDynamicCastExpr(this);
        if (DCE.getTypeAsWritten().$arrow().isReferenceType()
           && DCE.getCastKind() == CastKind.CK_Dynamic) {
          return true;
        }
      } // Fall through.
     case ImplicitCastExprClass:
     case CStyleCastExprClass:
     case CXXStaticCastExprClass:
     case CXXReinterpretCastExprClass:
     case CXXConstCastExprClass:
     case CXXFunctionalCastExprClass:
      {
        // While volatile reads are side-effecting in both C and C++, we treat them
        // as having possible (not definite) side-effects. This allows idiomatic
        // code to behave without warning, such as sizeof(*v) for a volatile-
        // qualified pointer.
        if (!IncludePossibleEffects) {
          break;
        }
        
        /*const*/ CastExpr /*P*/ CE = cast_CastExpr(this);
        if (CE.getCastKind() == CastKind.CK_LValueToRValue
           && CE.getSubExpr$Const().getType().isVolatileQualified()) {
          return true;
        }
        break;
      }
     case CXXTypeidExprClass:
      // typeid might throw if its subexpression is potentially-evaluated, so has
      // side-effects in that case whether or not its subexpression does.
      return cast_CXXTypeidExpr(this).isPotentiallyEvaluated();
     case CXXConstructExprClass:
     case CXXTemporaryObjectExprClass:
      {
        /*const*/ CXXConstructExpr /*P*/ CE = cast_CXXConstructExpr(this);
        if (!CE.getConstructor().isTrivial() && IncludePossibleEffects) {
          return true;
        }
        // A trivial constructor does not add any side-effects of its own. Just look
        // at its arguments.
        break;
      }
     case CXXInheritedCtorInitExprClass:
      {
        /*const*/ CXXInheritedCtorInitExpr /*P*/ ICIE = cast_CXXInheritedCtorInitExpr(this);
        if (!ICIE.getConstructor().isTrivial() && IncludePossibleEffects) {
          return true;
        }
        break;
      }
     case LambdaExprClass:
      {
        /*const*/ LambdaExpr /*P*/ LE = cast_LambdaExpr(this);
        for (type$ptr<LambdaCapture> I = $tryClone(LE.capture_begin()), 
            /*P*/ E = $tryClone(LE.capture_end()); $noteq_ptr(I, E); I.$preInc())  {
          if (I./*->*/$star().getCaptureKind() == LambdaCaptureKind.LCK_ByCopy) {
            // FIXME: Only has a side-effect if the variable is volatile or if
            // the copy would invoke a non-trivial copy constructor.
            return true;
          }
        }
        return false;
      }
     case PseudoObjectExprClass:
      {
        // Only look for side-effects in the semantic form, and look past
        // OpaqueValueExpr bindings in that form.
        /*const*/ PseudoObjectExpr /*P*/ PO = cast_PseudoObjectExpr(this);
        for (type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> I = $tryClone(PO.semantics_begin$Const()), 
            /*P*/ /*const*/ /*P*/ E = $tryClone(PO.semantics_end$Const());
             $noteq_ptr(I, E); I.$preInc()) {
          /*const*/ Expr /*P*/ Subexpr = I.$star();
          {
            /*const*/ OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(Subexpr);
            if ((OVE != null)) {
              Subexpr = OVE.getSourceExpr();
            }
          }
          if (Subexpr.HasSideEffects(Ctx, IncludePossibleEffects)) {
            return true;
          }
        }
        return false;
      }
     case ObjCBoxedExprClass:
     case ObjCArrayLiteralClass:
     case ObjCDictionaryLiteralClass:
     case ObjCSelectorExprClass:
     case ObjCProtocolExprClass:
     case ObjCIsaExprClass:
     case ObjCIndirectCopyRestoreExprClass:
     case ObjCSubscriptRefExprClass:
     case ObjCBridgedCastExprClass:
     case ObjCMessageExprClass:
     case ObjCPropertyRefExprClass:
      // FIXME: Classify these cases better.
      if (IncludePossibleEffects) {
        return true;
      }
      break;
    }
    
    // Recurse to children.
    for (/*const*/ Stmt /*P*/ SubStmt : children$Const())  {
      if ((SubStmt != null)
         && cast_Expr(SubStmt).HasSideEffects(Ctx, IncludePossibleEffects)) {
        return true;
      }
    }
    
    return false;
  }

  
  /// \brief Determine whether this expression involves a call to any function
  /// that is not trivial.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::hasNonTrivialCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3120,
   FQN="clang::Expr::hasNonTrivialCall", NM="_ZNK5clang4Expr17hasNonTrivialCallERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr17hasNonTrivialCallERKNS_10ASTContextE")
  //</editor-fold>
  public boolean hasNonTrivialCall(final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    NonTrivialCallFinder Finder/*J*/= new NonTrivialCallFinder(Ctx);
    Finder.Visit(this);
    return Finder.hasNonTrivialCall();
  }

  
  /// EvaluateKnownConstInt - Call EvaluateAsRValue and return the folded
  /// integer. This must be called on an expression that constant folds to an
  /// integer.
  
  /// EvaluateKnownConstInt - Call EvaluateAsRValue and return the folded
  /// integer. This must be called on an expression that constant folds to an
  /// integer.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::EvaluateKnownConstInt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9246,
   FQN="clang::Expr::EvaluateKnownConstInt", NM="_ZNK5clang4Expr21EvaluateKnownConstIntERKNS_10ASTContextEPN4llvm15SmallVectorImplISt4pairINS_14SourceLocationENS_17PartialDiagnosticEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK5clang4Expr21EvaluateKnownConstIntERKNS_10ASTContextEPN4llvm15SmallVectorImplISt4pairINS_14SourceLocationENS_17PartialDiagnosticEEEE")
  //</editor-fold>
  public APSInt EvaluateKnownConstInt(final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    return EvaluateKnownConstInt(Ctx, 
                       (OptionalNotes /*P*/ )null);
  }
  public APSInt EvaluateKnownConstInt(final /*const*/ ASTContext /*&*/ Ctx, 
                       OptionalNotes /*P*/ Diag/*= null*/) /*const*/ {
    EvalResult $EvalResult = null;
    try {
      $EvalResult/*J*/= new EvalResult();
      $EvalResult.Diag = Diag;
      boolean Result = EvaluateAsRValue($EvalResult, Ctx);
      //Java /*J:(void)*/Result;
      assert (Result) : "Could not evaluate expression";
      assert ($EvalResult.Val.isInt()) : "Expression did not evaluate to integer";
      
      return new APSInt($EvalResult.Val.getInt());
    } finally {
      if ($EvalResult != null) { $EvalResult.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Expr::EvaluateForOverflow">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9258,
   FQN="clang::Expr::EvaluateForOverflow", NM="_ZNK5clang4Expr19EvaluateForOverflowERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK5clang4Expr19EvaluateForOverflowERKNS_10ASTContextE")
  //</editor-fold>
  public void EvaluateForOverflow(final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    EvalResult $EvalResult = null;
    try {
      bool$ref IsConst = create_bool$ref();
      $EvalResult/*J*/= new EvalResult();
      if (!FastEvaluateAsRValue(this, $EvalResult, Ctx, IsConst)) {
        EvalInfo Info = null;
        try {
          Info/*J*/= new EvalInfo(Ctx, $EvalResult, EvalInfo.EvaluationMode.EM_EvaluateForOverflow);
          /*J:(void)*/ExprConstantStatics./*::*/EvaluateAsRValue(Info, this, $EvalResult.Val);
        } finally {
          if (Info != null) { Info.$destroy(); }
        }
      }
    } finally {
      if ($EvalResult != null) { $EvalResult.$destroy(); }
    }
  }


  
  /// EvaluateAsLValue - Evaluate an expression to see if we can fold it to an
  /// lvalue with link time known address, with no side-effects.
  
  /// EvaluateAsLValue - Evaluate an expression to see if we can fold it to an
  /// lvalue with link time known address, with no side-effects.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::EvaluateAsLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9184,
   FQN="clang::Expr::EvaluateAsLValue", NM="_ZNK5clang4Expr16EvaluateAsLValueERNS0_10EvalResultERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK5clang4Expr16EvaluateAsLValueERNS0_10EvalResultERKNS_10ASTContextE")
  //</editor-fold>
  public boolean EvaluateAsLValue(final EvalResult /*&*/ Result, final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    EvalInfo Info = null;
    LValue LV = null;
    try {
      Info/*J*/= new EvalInfo(Ctx, Result, EvalInfo.EvaluationMode.EM_ConstantFold);
      
      LV/*J*/= new LValue();
      if (!EvaluateLValue(this, LV, Info) || Result.HasSideEffects
         || !CheckLValueConstantExpression(Info, getExprLoc(), 
          Ctx.getLValueReferenceType(getType()), LV)) {
        return false;
      }
      
      LV.moveInto(Result.Val);
      return true;
    } finally {
      if (LV != null) { LV.$destroy(); }
      if (Info != null) { Info.$destroy(); }
    }
  }


  
  /// EvaluateAsInitializer - Evaluate an expression as if it were the
  /// initializer of the given declaration. Returns true if the initializer
  /// can be folded to a constant, and produces any relevant notes. In C++11,
  /// notes will be produced if the expression is not a constant expression.
  
  /// EvaluateAsInitializer - Evaluate an expression as if it were the
  /// initializer of the given declaration. Returns true if the initializer
  /// can be folded to a constant, and produces any relevant notes. In C++11,
  /// notes will be produced if the expression is not a constant expression.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::EvaluateAsInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9197,
   FQN="clang::Expr::EvaluateAsInitializer", NM="_ZNK5clang4Expr21EvaluateAsInitializerERNS_7APValueERKNS_10ASTContextEPKNS_7VarDeclERN4llvm15SmallVectorImplISt4pairINS_14SourceLocationENS_17PartialDiagnosticEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK5clang4Expr21EvaluateAsInitializerERNS_7APValueERKNS_10ASTContextEPKNS_7VarDeclERN4llvm15SmallVectorImplISt4pairINS_14SourceLocationENS_17PartialDiagnosticEEEE")
  //</editor-fold>
  public boolean EvaluateAsInitializer(final APValue /*&*/ Value, final /*const*/ ASTContext /*&*/ Ctx, 
                       /*const*/ VarDecl /*P*/ VD, 
                       final OptionalNotes /*&*/ Notes) /*const*/ {
    EvalInfo InitInfo = null;
    LValue LVal = null;
    try {
      // FIXME: Evaluating initializers for large array and record types can cause
      // performance problems. Only do so in C++11 for now.
      if (isRValue() && (getType().$arrow().isArrayType() || getType().$arrow().isRecordType())
         && !Ctx.getLangOpts().CPlusPlus11) {
        return false;
      }
      
      Expr.EvalStatus EStatus/*J*/= new Expr.EvalStatus();
      EStatus.Diag = $AddrOf(Notes);
      
      InitInfo/*J*/= new EvalInfo(Ctx, EStatus, VD.isConstexpr() ? EvalInfo.EvaluationMode.EM_ConstantExpression : EvalInfo.EvaluationMode.EM_ConstantFold);
      InitInfo.setEvaluatingDecl(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T.INSTANCE, /*const*/ ValueDecl /*P*/ .class, VD), Value);
      
      LVal/*J*/= new LValue();
      LVal.set(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T.INSTANCE, /*const*/ ValueDecl /*P*/ .class, VD));
      
      // C++11 [basic.start.init]p2:
      //  Variables with static storage duration or thread storage duration shall be
      //  zero-initialized before any other initialization takes place.
      // This behavior is not present in C.
      if (Ctx.getLangOpts().CPlusPlus && !VD.hasLocalStorage()
         && !VD.getType().$arrow().isReferenceType()) {
        ImplicitValueInitExpr VIE/*J*/= new ImplicitValueInitExpr(VD.getType());
        if (!EvaluateInPlace(Value, InitInfo, LVal, $AddrOf(VIE), 
            /*AllowNonLiteralTypes=*/ true)) {
          return false;
        }
      }
      if (!EvaluateInPlace(Value, InitInfo, LVal, this, 
          /*AllowNonLiteralTypes=*/ true)
         || EStatus.HasSideEffects) {
        return false;
      }
      
      return CheckConstantExpression(InitInfo, VD.getLocation(), VD.getType(), 
          Value);
    } finally {
      if (LVal != null) { LVal.$destroy(); }
      if (InitInfo != null) { InitInfo.$destroy(); }
    }
  }


  
  /// EvaluateWithSubstitution - Evaluate an expression as if from the context
  /// of a call to the given function with the given arguments, inside an
  /// unevaluated context. Returns true if the expression could be folded to a
  /// constant.
  
  /// EvaluateWithSubstitution - Evaluate an expression as if from the context
  /// of a call to the given function with the given arguments, inside an
  /// unevaluated context. Returns true if the expression could be folded to a
  /// constant.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::EvaluateWithSubstitution">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9785,
   FQN="clang::Expr::EvaluateWithSubstitution", NM="_ZNK5clang4Expr24EvaluateWithSubstitutionERNS_7APValueERNS_10ASTContextEPKNS_12FunctionDeclEN4llvm8ArrayRefIPKS0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK5clang4Expr24EvaluateWithSubstitutionERNS_7APValueERNS_10ASTContextEPKNS_12FunctionDeclEN4llvm8ArrayRefIPKS0_EE")
  //</editor-fold>
  public boolean EvaluateWithSubstitution(final APValue /*&*/ Value, final ASTContext /*&*/ Ctx, 
                          /*const*/ FunctionDecl /*P*/ Callee, 
                          ArrayRef</*const*/ Expr /*P*/ > Args) /*const*/ {
    EvalInfo Info = null;
    SmallVector<APValue> ArgValues = null;
    CallStackFrame Frame = null;
    try {
      Expr.EvalStatus Status/*J*/= new Expr.EvalStatus();
      Info/*J*/= new EvalInfo(Ctx, Status, EvalInfo.EvaluationMode.EM_ConstantExpressionUnevaluated);
      
      ArgValues/*J*/= new SmallVector<APValue>(JD$UInt_T$C$R.INSTANCE, 8, Args.size(), new APValue());
      for (type$ptr<Expr/*P*/>/*iterator*/ I = $tryClone(Args.begin()), /*P*/ E = $tryClone(Args.end());
           $noteq_ptr(I, E); I.$preInc()) {
        if ((I.$star()).isValueDependent()
           || !Evaluate(ArgValues.$at(I.$sub(Args.begin())), Info, I.$star())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // If evaluation fails, throw away the argument entirely.
            $c$.clean(ArgValues.$at(I.$sub(Args.begin())).$assign($c$.track(new APValue())));
          } finally {
            $c$.$destroy();
          }
        }
        if (Info.EvalStatus.HasSideEffects) {
          return false;
        }
      }
      
      // Build fake call to Callee.
      Frame/*J*/= new CallStackFrame(Info, Callee.getLocation(), Callee, /*This*/ (/*const*/ LValue /*P*/ )null, 
          ArgValues.data());
      return Evaluate(Value, Info, this) && !Info.EvalStatus.HasSideEffects;
    } finally {
      if (Frame != null) { Frame.$destroy(); }
      if (ArgValues != null) { ArgValues.$destroy(); }
      if (Info != null) { Info.$destroy(); }
    }
  }


  
  /// \brief If the current Expr is a pointer, this will try to statically
  /// determine the number of bytes available where the pointer is pointing.
  /// Returns true if all of the above holds and we were able to figure out the
  /// size, false otherwise.
  ///
  /// \param Type - How to evaluate the size of the Expr, as defined by the
  /// "type" parameter of __builtin_object_size
  
  /// \brief If the current Expr is a pointer, this will try to statically
  /// determine the number of bytes available where the pointer is pointing.
  /// Returns true if all of the above holds and we were able to figure out the
  /// size, false otherwise.
  ///
  /// \param Type - How to evaluate the size of the Expr, as defined by the
  /// "type" parameter of __builtin_object_size
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::tryEvaluateObjectSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 9873,
   FQN="clang::Expr::tryEvaluateObjectSize", NM="_ZNK5clang4Expr21tryEvaluateObjectSizeERyRNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK5clang4Expr21tryEvaluateObjectSizeERyRNS_10ASTContextEj")
  //</editor-fold>
  public boolean tryEvaluateObjectSize(final ulong$ref/*uint64_t &*/ Result, final ASTContext /*&*/ Ctx, 
                       /*uint*/int Type) /*const*/ {
    EvalInfo Info = null;
    try {
      if (!getType().$arrow().isPointerType()) {
        return false;
      }
      
      Expr.EvalStatus Status/*J*/= new Expr.EvalStatus();
      Info/*J*/= new EvalInfo(Ctx, Status, EvalInfo.EvaluationMode.EM_ConstantFold);
      return /*::*/tryEvaluateBuiltinObjectSize(this, Type, Info, Result);
    } finally {
      if (Info != null) { Info.$destroy(); }
    }
  }


  
  /// \brief Enumeration used to describe the kind of Null pointer constant
  /// returned from \c isNullPointerConstant().
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::NullPointerConstantKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 663,
   FQN="clang::Expr::NullPointerConstantKind", NM="_ZN5clang4Expr23NullPointerConstantKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr23NullPointerConstantKindE")
  //</editor-fold>
  public enum NullPointerConstantKind implements Native.ComparableLower {
    /// \brief Expression is not a Null pointer constant.
    NPCK_NotNull(0),
    
    /// \brief Expression is a Null pointer constant built from a zero integer
    /// expression that is not a simple, possibly parenthesized, zero literal.
    /// C++ Core Issue 903 will classify these expressions as "not pointers"
    /// once it is adopted.
    /// http://www.open-std.org/jtc1/sc22/wg21/docs/cwg_active.html#903
    NPCK_ZeroExpression(NPCK_NotNull.getValue() + 1),
    
    /// \brief Expression is a Null pointer constant built from a literal zero.
    NPCK_ZeroLiteral(NPCK_ZeroExpression.getValue() + 1),
    
    /// \brief Expression is a C++11 nullptr.
    NPCK_CXX11_nullptr(NPCK_ZeroLiteral.getValue() + 1),
    
    /// \brief Expression is a GNU-style __null constant.
    NPCK_GNUNull(NPCK_CXX11_nullptr.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static NullPointerConstantKind valueOf(int val) {
      NullPointerConstantKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final NullPointerConstantKind[] VALUES;
      private static final NullPointerConstantKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (NullPointerConstantKind kind : NullPointerConstantKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new NullPointerConstantKind[min < 0 ? (1-min) : 0];
        VALUES = new NullPointerConstantKind[max >= 0 ? (1+max) : 0];
        for (NullPointerConstantKind kind : NullPointerConstantKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private NullPointerConstantKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((NullPointerConstantKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((NullPointerConstantKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Enumeration used to describe how \c isNullPointerConstant()
  /// should cope with value-dependent expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::NullPointerConstantValueDependence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 686,
   FQN="clang::Expr::NullPointerConstantValueDependence", NM="_ZN5clang4Expr34NullPointerConstantValueDependenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr34NullPointerConstantValueDependenceE")
  //</editor-fold>
  public enum NullPointerConstantValueDependence implements Native.ComparableLower {
    /// \brief Specifies that the expression should never be value-dependent.
    NPC_NeverValueDependent(0),
    
    /// \brief Specifies that a value-dependent expression of integral or
    /// dependent type should be considered a null pointer constant.
    NPC_ValueDependentIsNull(NPC_NeverValueDependent.getValue() + 1),
    
    /// \brief Specifies that a value-dependent expression should be considered
    /// to never be a null pointer constant.
    NPC_ValueDependentIsNotNull(NPC_ValueDependentIsNull.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static NullPointerConstantValueDependence valueOf(int val) {
      NullPointerConstantValueDependence out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final NullPointerConstantValueDependence[] VALUES;
      private static final NullPointerConstantValueDependence[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (NullPointerConstantValueDependence kind : NullPointerConstantValueDependence.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new NullPointerConstantValueDependence[min < 0 ? (1-min) : 0];
        VALUES = new NullPointerConstantValueDependence[max >= 0 ? (1+max) : 0];
        for (NullPointerConstantValueDependence kind : NullPointerConstantValueDependence.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private NullPointerConstantValueDependence(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((NullPointerConstantValueDependence)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((NullPointerConstantValueDependence)obj).value);}
    //</editor-fold>
  };
  
  /// isNullPointerConstant - C99 6.3.2.3p3 - Test if this reduces down to
  /// a Null pointer constant. The return value can further distinguish the
  /// kind of NULL pointer constant that was detected.
  
  /// isNullPointerConstant - C99 6.3.2.3p3 - Return whether this is a null 
  /// pointer constant or not, as well as the specific kind of constant detected.
  /// Null pointer constants can be integer constant expressions with the
  /// value zero, casts of zero to void*, nullptr (C++0X), or __null
  /// (a GNU extension).
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isNullPointerConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3131,
   FQN="clang::Expr::isNullPointerConstant", NM="_ZNK5clang4Expr21isNullPointerConstantERNS_10ASTContextENS0_34NullPointerConstantValueDependenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr21isNullPointerConstantERNS_10ASTContextENS0_34NullPointerConstantValueDependenceE")
  //</editor-fold>
  public Expr.NullPointerConstantKind isNullPointerConstant(final ASTContext /*&*/ Ctx, 
                       NullPointerConstantValueDependence NPC) /*const*/ {
    if (isValueDependent()
       && (!Ctx.getLangOpts().CPlusPlus11 || Ctx.getLangOpts().MSVCCompat)) {
      switch (NPC) {
       case NPC_NeverValueDependent:
        throw new llvm_unreachable("Unexpected value dependent expression!");
       case NPC_ValueDependentIsNull:
        if (isTypeDependent() || getType().$arrow().isIntegralType(Ctx)) {
          return NullPointerConstantKind.NPCK_ZeroExpression;
        } else {
          return NullPointerConstantKind.NPCK_NotNull;
        }
       case NPC_ValueDependentIsNotNull:
        return NullPointerConstantKind.NPCK_NotNull;
      }
    }
    {
      
      // Strip off a cast to void*, if it exists. Except in C++.
      /*const*/ ExplicitCastExpr /*P*/ CE = dyn_cast_ExplicitCastExpr(this);
      if ((CE != null)) {
        if (!Ctx.getLangOpts().CPlusPlus) {
          {
            // Check that it is a cast to void*.
            /*const*/ PointerType /*P*/ PT = CE.getType().$arrow().getAs(PointerType.class);
            if ((PT != null)) {
              QualType Pointee = PT.getPointeeType();
              Qualifiers Q = Pointee.getQualifiers();
              // In OpenCL v2.0 generic address space acts as a placeholder
              // and should be ignored.
              boolean IsASValid = true;
              if ($greatereq_uint(Ctx.getLangOpts().OpenCLVersion, 200)) {
                if (Pointee.getAddressSpace() == LangAS.ID.opencl_generic) {
                  Q.removeAddressSpace();
                } else {
                  IsASValid = false;
                }
              }
              if (IsASValid && !Q.hasQualifiers()
                 && Pointee.$arrow().isVoidType() // to void*
                 && CE.getSubExpr$Const().getType().$arrow().isIntegerType()) { // from int.
                return CE.getSubExpr$Const().isNullPointerConstant(Ctx, NPC);
              }
            }
          }
        }
      } else {
        /*const*/ ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(this);
        if ((ICE != null)) {
          // Ignore the ImplicitCastExpr type entirely.
          return ICE.getSubExpr$Const().isNullPointerConstant(Ctx, NPC);
        } else {
          /*const*/ ParenExpr /*P*/ PE = dyn_cast_ParenExpr(this);
          if ((PE != null)) {
            // Accept ((void*)0) as a null pointer constant, as many other
            // implementations do.
            return PE.getSubExpr$Const().isNullPointerConstant(Ctx, NPC);
          } else {
            /*const*/ GenericSelectionExpr /*P*/ GE = dyn_cast_GenericSelectionExpr(this);
            if ((GE != null)) {
              if (GE.isResultDependent()) {
                return NullPointerConstantKind.NPCK_NotNull;
              }
              return GE.getResultExpr$Const().isNullPointerConstant(Ctx, NPC);
            } else {
              /*const*/ ChooseExpr /*P*/ CE$1 = dyn_cast_ChooseExpr(this);
              if ((CE$1 != null)) {
                if (CE$1.isConditionDependent()) {
                  return NullPointerConstantKind.NPCK_NotNull;
                }
                return CE$1.getChosenSubExpr().isNullPointerConstant(Ctx, NPC);
              } else {
                /*const*/ CXXDefaultArgExpr /*P*/ DefaultArg = dyn_cast_CXXDefaultArgExpr(this);
                if ((DefaultArg != null)) {
                  // See through default argument expressions.
                  return DefaultArg.getExpr$Const().isNullPointerConstant(Ctx, NPC);
                } else {
                  /*const*/ CXXDefaultInitExpr /*P*/ DefaultInit = dyn_cast_CXXDefaultInitExpr(this);
                  if ((DefaultInit != null)) {
                    // See through default initializer expressions.
                    return DefaultInit.getExpr$Const().isNullPointerConstant(Ctx, NPC);
                  } else if (isa_GNUNullExpr(this)) {
                    // The GNU __null extension is always a null pointer constant.
                    return NullPointerConstantKind.NPCK_GNUNull;
                  } else {
                    /*const*/ MaterializeTemporaryExpr /*P*/ M = dyn_cast_MaterializeTemporaryExpr(this);
                    if ((M != null)) {
                      return M.GetTemporaryExpr().isNullPointerConstant(Ctx, NPC);
                    } else {
                      /*const*/ OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(this);
                      if ((OVE != null)) {
                        {
                          /*const*/ Expr /*P*/ Source = OVE.getSourceExpr();
                          if ((Source != null)) {
                            return Source.isNullPointerConstant(Ctx, NPC);
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    
    // C++11 nullptr_t is always a null pointer constant.
    if (getType().$arrow().isNullPtrType()) {
      return NullPointerConstantKind.NPCK_CXX11_nullptr;
    }
    {
      
      /*const*/ RecordType /*P*/ UT = getType().$arrow().getAsUnionType();
      if ((UT != null)) {
        if (!Ctx.getLangOpts().CPlusPlus11
           && (UT != null) && UT.getDecl().hasAttr(TransparentUnionAttr.class)) {
          {
            /*const*/ CompoundLiteralExpr /*P*/ CLE = dyn_cast_CompoundLiteralExpr(this);
            if ((CLE != null)) {
              /*const*/ Expr /*P*/ InitExpr = CLE.getInitializer$Const();
              {
                /*const*/ InitListExpr /*P*/ ILE = dyn_cast_InitListExpr(InitExpr);
                if ((ILE != null)) {
                  return ILE.getInit$Const(0).isNullPointerConstant(Ctx, NPC);
                }
              }
            }
          }
        }
      }
    }
    // This expression must be an integer type.
    if (!getType().$arrow().isIntegerType()
       || (Ctx.getLangOpts().CPlusPlus && getType().$arrow().isEnumeralType())) {
      return NullPointerConstantKind.NPCK_NotNull;
    }
    if (Ctx.getLangOpts().CPlusPlus11) {
      // C++11 [conv.ptr]p1: A null pointer constant is an integer literal with
      // value zero or a prvalue of type std::nullptr_t.
      // Microsoft mode permits C++98 rules reflecting MSVC behavior.
      /*const*/ IntegerLiteral /*P*/ Lit = dyn_cast_IntegerLiteral(this);
      if ((Lit != null) && Lit.getValue().$not()) {
        return NullPointerConstantKind.NPCK_ZeroLiteral;
      } else if (!Ctx.getLangOpts().MSVCCompat || !isCXX98IntegralConstantExpr(Ctx)) {
        return NullPointerConstantKind.NPCK_NotNull;
      }
    } else {
      // If we have an integer constant expression, we need to *evaluate* it and
      // test for the value 0.
      if (!isIntegerConstantExpr(Ctx)) {
        return NullPointerConstantKind.NPCK_NotNull;
      }
    }
    if (EvaluateKnownConstInt(Ctx).$noteq(0)) {
      return NullPointerConstantKind.NPCK_NotNull;
    }
    if (isa_IntegerLiteral(this)) {
      return NullPointerConstantKind.NPCK_ZeroLiteral;
    }
    return NullPointerConstantKind.NPCK_ZeroExpression;
  }

  
  /// isOBJCGCCandidate - Return true if this expression may be used in a read/
  /// write barrier.
  
  /// isOBJCGCCandidate - Check if an expression is objc gc'able.
  /// returns true, if it is; false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isOBJCGCCandidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 2226,
   FQN="clang::Expr::isOBJCGCCandidate", NM="_ZNK5clang4Expr17isOBJCGCCandidateERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr17isOBJCGCCandidateERNS_10ASTContextE")
  //</editor-fold>
  public boolean isOBJCGCCandidate(final ASTContext /*&*/ Ctx) /*const*/ {
    /*const*/ Expr /*P*/ E = IgnoreParens$Const();
    switch (E.getStmtClass()) {
     default:
      return false;
     case ObjCIvarRefExprClass:
      return true;
     case UnaryOperatorClass:
      return cast_UnaryOperator(E).getSubExpr().isOBJCGCCandidate(Ctx);
     case ImplicitCastExprClass:
      return cast_ImplicitCastExpr(E).getSubExpr$Const().isOBJCGCCandidate(Ctx);
     case MaterializeTemporaryExprClass:
      return cast_MaterializeTemporaryExpr(E).GetTemporaryExpr().
          isOBJCGCCandidate(Ctx);
     case CStyleCastExprClass:
      return cast_CStyleCastExpr(E).getSubExpr$Const().isOBJCGCCandidate(Ctx);
     case DeclRefExprClass:
      {
        /*const*/ Decl /*P*/ D = cast_DeclRefExpr(E).getDecl$Const();
        {
          
          /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
          if ((VD != null)) {
            if (VD.hasGlobalStorage()) {
              return true;
            }
            QualType T = VD.getType();
            // dereferencing to a  pointer is always a gc'able candidate,
            // unless it is __weak.
            return T.$arrow().isPointerType()
               && (Ctx.getObjCGCAttrKind(new QualType(T)) != Qualifiers.GC.Weak);
          }
        }
        return false;
      }
     case MemberExprClass:
      {
        /*const*/ MemberExpr /*P*/ M = cast_MemberExpr(E);
        return M.getBase().isOBJCGCCandidate(Ctx);
      }
     case ArraySubscriptExprClass:
      return cast_ArraySubscriptExpr(E).getBase$Const().isOBJCGCCandidate(Ctx);
    }
  }

  
  /// \brief Returns true if this expression is a bound member function.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isBoundMemberFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 2265,
   FQN="clang::Expr::isBoundMemberFunction", NM="_ZNK5clang4Expr21isBoundMemberFunctionERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr21isBoundMemberFunctionERNS_10ASTContextE")
  //</editor-fold>
  public boolean isBoundMemberFunction(final ASTContext /*&*/ Ctx) /*const*/ {
    if (isTypeDependent()) {
      return false;
    }
    return ClassifyLValue(Ctx) == Expr.LValueClassification.LV_MemberFunction;
  }

  
  /// \brief Given an expression of bound-member type, find the type
  /// of the member.  Returns null if this is an *overloaded* bound
  /// member expression.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::findBoundMemberType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 2271,
   FQN="clang::Expr::findBoundMemberType", NM="_ZN5clang4Expr19findBoundMemberTypeEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr19findBoundMemberTypeEPKS0_")
  //</editor-fold>
  public static QualType findBoundMemberType(/*const*/ Expr /*P*/ expr) {
    assert (expr.hasPlaceholderType(BuiltinType.Kind.BoundMember));
    
    // Bound member expressions are always one of these possibilities:
    //   x->m      x.m      x->*y      x.*y
    // (possibly parenthesized)
    expr = expr.IgnoreParens$Const();
    {
      /*const*/ MemberExpr /*P*/ mem = dyn_cast_MemberExpr(expr);
      if ((mem != null)) {
        assert (isa_CXXMethodDecl(mem.getMemberDecl()));
        return mem.getMemberDecl().getType();
      }
    }
    {
      
      /*const*/ BinaryOperator /*P*/ op = dyn_cast_BinaryOperator(expr);
      if ((op != null)) {
        QualType type = op.getRHS().getType().$arrow().castAs(MemberPointerType.class).
            getPointeeType();
        assert (type.$arrow().isFunctionType());
        return type;
      }
    }
    assert (isa_UnresolvedMemberExpr(expr) || isa_CXXPseudoDestructorExpr(expr));
    return new QualType();
  }

  
  /// IgnoreImpCasts - Skip past any implicit casts which might
  /// surround this expression.  Only skips ImplicitCastExprs.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::IgnoreImpCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2777,
   FQN="clang::Expr::IgnoreImpCasts", NM="_ZN5clang4Expr14IgnoreImpCastsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr14IgnoreImpCastsEv")
  //</editor-fold>
  public /*inline*/ Expr /*P*/ IgnoreImpCasts()/* __attribute__((pure))*/ {
    Expr /*P*/ e = this;
    {
      ImplicitCastExpr /*P*/ ice;
      while (((/*P*/ ice = dyn_cast_ImplicitCastExpr(e)) != null)) {
        e = ice.getSubExpr();
      }
    }
    return e;
  }

  
  /// IgnoreImplicit - Skip past any implicit AST nodes which might
  /// surround this expression.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::IgnoreImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 724,
   FQN="clang::Expr::IgnoreImplicit", NM="_ZN5clang4Expr14IgnoreImplicitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr14IgnoreImplicitEv")
  //</editor-fold>
  public Expr /*P*/ IgnoreImplicit()/* __attribute__((pure))*/ {
    return cast_Expr(super.IgnoreImplicit());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::IgnoreImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 728,
   FQN="clang::Expr::IgnoreImplicit", NM="_ZNK5clang4Expr14IgnoreImplicitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr14IgnoreImplicitEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ IgnoreImplicit$Const() /*const*//* __attribute__((pure))*/ {
    return ((/*const_cast*/Expr /*P*/ )(this)).IgnoreImplicit();
  }

  
  /// IgnoreParens - Ignore parentheses.  If this Expr is a ParenExpr, return
  ///  its subexpression.  If that subexpression is also a ParenExpr,
  ///  then this method recursively returns its subexpression, and so forth.
  ///  Otherwise, the method returns the current Expr.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::IgnoreParens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 2295,
   FQN="clang::Expr::IgnoreParens", NM="_ZN5clang4Expr12IgnoreParensEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr12IgnoreParensEv")
  //</editor-fold>
  public Expr /*P*/ IgnoreParens()/* __attribute__((pure))*/ {
    Expr /*P*/ E = this;
    while (true) {
      {
        ParenExpr /*P*/ P = dyn_cast_ParenExpr(E);
        if ((P != null)) {
          E = P.getSubExpr();
          continue;
        }
      }
      {
        UnaryOperator /*P*/ P = dyn_cast_UnaryOperator(E);
        if ((P != null)) {
          if (P.getOpcode() == UnaryOperatorKind.UO_Extension) {
            E = P.getSubExpr();
            continue;
          }
        }
      }
      {
        GenericSelectionExpr /*P*/ P = dyn_cast_GenericSelectionExpr(E);
        if ((P != null)) {
          if (!P.isResultDependent()) {
            E = P.getResultExpr();
            continue;
          }
        }
      }
      {
        ChooseExpr /*P*/ P = dyn_cast_ChooseExpr(E);
        if ((P != null)) {
          if (!P.isConditionDependent()) {
            E = P.getChosenSubExpr();
            continue;
          }
        }
      }
      return E;
    }
  }

  
  /// IgnoreParenCasts - Ignore parentheses and casts.  Strip off any ParenExpr
  /// or CastExprs, returning their operand.
  
  /// IgnoreParenCasts - Ignore parentheses and casts.  Strip off any ParenExpr
  /// or CastExprs or ImplicitCastExprs, returning their operand.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::IgnoreParenCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 2326,
   FQN="clang::Expr::IgnoreParenCasts", NM="_ZN5clang4Expr16IgnoreParenCastsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr16IgnoreParenCastsEv")
  //</editor-fold>
  public Expr /*P*/ IgnoreParenCasts()/* __attribute__((pure))*/ {
    Expr /*P*/ E = this;
    while (true) {
      E = E.IgnoreParens();
      {
        CastExpr /*P*/ P = dyn_cast_CastExpr(E);
        if ((P != null)) {
          E = P.getSubExpr();
          continue;
        }
      }
      {
        MaterializeTemporaryExpr /*P*/ Materialize = dyn_cast_MaterializeTemporaryExpr(E);
        if ((Materialize != null)) {
          E = Materialize.GetTemporaryExpr();
          continue;
        }
      }
      {
        SubstNonTypeTemplateParmExpr /*P*/ NTTP = dyn_cast_SubstNonTypeTemplateParmExpr(E);
        if ((NTTP != null)) {
          E = NTTP.getReplacement();
          continue;
        }
      }
      return E;
    }
  }

  
  /// Ignore casts.  Strip off any CastExprs, returning their operand.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::IgnoreCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 2348,
   FQN="clang::Expr::IgnoreCasts", NM="_ZN5clang4Expr11IgnoreCastsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr11IgnoreCastsEv")
  //</editor-fold>
  public Expr /*P*/ IgnoreCasts()/* __attribute__((pure))*/ {
    Expr /*P*/ E = this;
    while (true) {
      {
        CastExpr /*P*/ P = dyn_cast_CastExpr(E);
        if ((P != null)) {
          E = P.getSubExpr();
          continue;
        }
      }
      {
        MaterializeTemporaryExpr /*P*/ Materialize = dyn_cast_MaterializeTemporaryExpr(E);
        if ((Materialize != null)) {
          E = Materialize.GetTemporaryExpr();
          continue;
        }
      }
      {
        SubstNonTypeTemplateParmExpr /*P*/ NTTP = dyn_cast_SubstNonTypeTemplateParmExpr(E);
        if ((NTTP != null)) {
          E = NTTP.getReplacement();
          continue;
        }
      }
      return E;
    }
  }

  
  /// IgnoreParenImpCasts - Ignore parentheses and implicit casts.  Strip off
  /// any ParenExpr or ImplicitCastExprs, returning their operand.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::IgnoreParenImpCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 2413,
   FQN="clang::Expr::IgnoreParenImpCasts", NM="_ZN5clang4Expr19IgnoreParenImpCastsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr19IgnoreParenImpCastsEv")
  //</editor-fold>
  public Expr /*P*/ IgnoreParenImpCasts()/* __attribute__((pure))*/ {
    Expr /*P*/ E = this;
    while (true) {
      E = E.IgnoreParens();
      {
        ImplicitCastExpr /*P*/ P = dyn_cast_ImplicitCastExpr(E);
        if ((P != null)) {
          E = P.getSubExpr();
          continue;
        }
      }
      {
        MaterializeTemporaryExpr /*P*/ Materialize = dyn_cast_MaterializeTemporaryExpr(E);
        if ((Materialize != null)) {
          E = Materialize.GetTemporaryExpr();
          continue;
        }
      }
      {
        SubstNonTypeTemplateParmExpr /*P*/ NTTP = dyn_cast_SubstNonTypeTemplateParmExpr(E);
        if ((NTTP != null)) {
          E = NTTP.getReplacement();
          continue;
        }
      }
      return E;
    }
  }

  
  /// IgnoreConversionOperator - Ignore conversion operator. If this Expr is a
  /// call to a conversion operator, return the argument.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::IgnoreConversionOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 2435,
   FQN="clang::Expr::IgnoreConversionOperator", NM="_ZN5clang4Expr24IgnoreConversionOperatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr24IgnoreConversionOperatorEv")
  //</editor-fold>
  public Expr /*P*/ IgnoreConversionOperator()/* __attribute__((pure))*/ {
    {
      CXXMemberCallExpr /*P*/ MCE = dyn_cast_CXXMemberCallExpr(this);
      if ((MCE != null)) {
        if ((MCE.getMethodDecl() != null) && isa_CXXConversionDecl(MCE.getMethodDecl())) {
          return MCE.getImplicitObjectArgument();
        }
      }
    }
    return this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::IgnoreConversionOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 753,
   FQN="clang::Expr::IgnoreConversionOperator", NM="_ZNK5clang4Expr24IgnoreConversionOperatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr24IgnoreConversionOperatorEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ IgnoreConversionOperator$Const() /*const*//* __attribute__((pure))*/ {
    return ((/*const_cast*/Expr /*P*/ )(this)).IgnoreConversionOperator();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::IgnoreParenImpCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 757,
   FQN="clang::Expr::IgnoreParenImpCasts", NM="_ZNK5clang4Expr19IgnoreParenImpCastsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr19IgnoreParenImpCastsEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ IgnoreParenImpCasts$Const() /*const*//* __attribute__((pure))*/ {
    return ((/*const_cast*/Expr /*P*/ )(this)).IgnoreParenImpCasts();
  }

  
  /// Ignore parentheses and lvalue casts.  Strip off any ParenExpr and
  /// CastExprs that represent lvalue casts, returning their operand.
  
  /// IgnoreParenLValueCasts - Ignore parentheses and lvalue-to-rvalue
  /// casts.  This is intended purely as a temporary workaround for code
  /// that hasn't yet been rewritten to do the right thing about those
  /// casts, and may disappear along with the last internal use.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::IgnoreParenLValueCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 2373,
   FQN="clang::Expr::IgnoreParenLValueCasts", NM="_ZN5clang4Expr22IgnoreParenLValueCastsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr22IgnoreParenLValueCastsEv")
  //</editor-fold>
  public Expr /*P*/ IgnoreParenLValueCasts()/* __attribute__((pure))*/ {
    Expr /*P*/ E = this;
    while (true) {
      E = E.IgnoreParens();
      {
        CastExpr /*P*/ P = dyn_cast_CastExpr(E);
        if ((P != null)) {
          if (P.getCastKind() == CastKind.CK_LValueToRValue) {
            E = P.getSubExpr();
            continue;
          }
        } else {
          MaterializeTemporaryExpr /*P*/ Materialize = dyn_cast_MaterializeTemporaryExpr(E);
          if ((Materialize != null)) {
            E = Materialize.GetTemporaryExpr();
            continue;
          } else {
            SubstNonTypeTemplateParmExpr /*P*/ NTTP = dyn_cast_SubstNonTypeTemplateParmExpr(E);
            if ((NTTP != null)) {
              E = NTTP.getReplacement();
              continue;
            }
          }
        }
      }
      break;
    }
    return E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::IgnoreParenLValueCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 765,
   FQN="clang::Expr::IgnoreParenLValueCasts", NM="_ZNK5clang4Expr22IgnoreParenLValueCastsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr22IgnoreParenLValueCastsEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ IgnoreParenLValueCasts$Const() /*const*//* __attribute__((pure))*/ {
    return ((/*const_cast*/Expr /*P*/ )(this)).IgnoreParenLValueCasts();
  }

  
  /// IgnoreParenNoopCasts - Ignore parentheses and casts that do not change the
  /// value (including ptr->int casts of the same size).  Strip off any
  /// ParenExpr or CastExprs, returning their operand.
  
  /// IgnoreParenNoopCasts - Ignore parentheses and casts that do not change the
  /// value (including ptr->int casts of the same size).  Strip off any
  /// ParenExpr or CastExprs, returning their operand.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::IgnoreParenNoopCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 2446,
   FQN="clang::Expr::IgnoreParenNoopCasts", NM="_ZN5clang4Expr20IgnoreParenNoopCastsERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr20IgnoreParenNoopCastsERNS_10ASTContextE")
  //</editor-fold>
  public Expr /*P*/ IgnoreParenNoopCasts(final ASTContext /*&*/ Ctx)/* __attribute__((pure))*/ {
    Expr /*P*/ E = this;
    while (true) {
      E = E.IgnoreParens();
      {
        
        CastExpr /*P*/ P = dyn_cast_CastExpr(E);
        if ((P != null)) {
          // We ignore integer <-> casts that are of the same width, ptr<->ptr and
          // ptr<->int casts of the same width.  We also ignore all identity casts.
          Expr /*P*/ SE = P.getSubExpr();
          if (Ctx.hasSameUnqualifiedType(E.getType(), SE.getType())) {
            E = SE;
            continue;
          }
          if ((E.getType().$arrow().isPointerType()
             || E.getType().$arrow().isIntegralType(Ctx))
             && (SE.getType().$arrow().isPointerType()
             || SE.getType().$arrow().isIntegralType(Ctx))
             && Ctx.getTypeSize(E.getType()) == Ctx.getTypeSize(SE.getType())) {
            E = SE;
            continue;
          }
        }
      }
      {
        
        SubstNonTypeTemplateParmExpr /*P*/ NTTP = dyn_cast_SubstNonTypeTemplateParmExpr(E);
        if ((NTTP != null)) {
          E = NTTP.getReplacement();
          continue;
        }
      }
      
      return E;
    }
  }

  
  /// Ignore parentheses and derived-to-base casts.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::ignoreParenBaseCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 2396,
   FQN="clang::Expr::ignoreParenBaseCasts", NM="_ZN5clang4Expr20ignoreParenBaseCastsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr20ignoreParenBaseCastsEv")
  //</editor-fold>
  public Expr /*P*/ ignoreParenBaseCasts()/* __attribute__((pure))*/ {
    Expr /*P*/ E = this;
    while (true) {
      E = E.IgnoreParens();
      {
        CastExpr /*P*/ CE = dyn_cast_CastExpr(E);
        if ((CE != null)) {
          if (CE.getCastKind() == CastKind.CK_DerivedToBase
             || CE.getCastKind() == CastKind.CK_UncheckedDerivedToBase
             || CE.getCastKind() == CastKind.CK_NoOp) {
            E = CE.getSubExpr();
            continue;
          }
        }
      }
      
      return E;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::ignoreParenBaseCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 777,
   FQN="clang::Expr::ignoreParenBaseCasts", NM="_ZNK5clang4Expr20ignoreParenBaseCastsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr20ignoreParenBaseCastsEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ ignoreParenBaseCasts$Const() /*const*//* __attribute__((pure))*/ {
    return ((/*const_cast*/Expr /*P*/ )(this)).ignoreParenBaseCasts();
  }

  
  /// \brief Determine whether this expression is a default function argument.
  ///
  /// Default arguments are implicitly generated in the abstract syntax tree
  /// by semantic analysis for function calls, object constructions, etc. in
  /// C++. Default arguments are represented by \c CXXDefaultArgExpr nodes;
  /// this routine also looks through any implicit casts to determine whether
  /// the expression is a default argument.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isDefaultArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 2481,
   FQN="clang::Expr::isDefaultArgument", NM="_ZNK5clang4Expr17isDefaultArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr17isDefaultArgumentEv")
  //</editor-fold>
  public boolean isDefaultArgument() /*const*/ {
    /*const*/ Expr /*P*/ E = this;
    {
      /*const*/ MaterializeTemporaryExpr /*P*/ M = dyn_cast_MaterializeTemporaryExpr(E);
      if ((M != null)) {
        E = M.GetTemporaryExpr();
      }
    }
    {
      
      /*const*/ ImplicitCastExpr /*P*/ ICE;
      while (((/*P*/ ICE = dyn_cast_ImplicitCastExpr(E)) != null)) {
        E = ICE.getSubExprAsWritten$Const();
      }
    }
    
    return isa_CXXDefaultArgExpr(E);
  }

  
  /// \brief Determine whether the result of this expression is a
  /// temporary object of the given class type.
  
  /// isTemporaryObject - Determines if this expression produces a
  /// temporary of the given class type.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isTemporaryObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 2520,
   FQN="clang::Expr::isTemporaryObject", NM="_ZNK5clang4Expr17isTemporaryObjectERNS_10ASTContextEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr17isTemporaryObjectERNS_10ASTContextEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public boolean isTemporaryObject(final ASTContext /*&*/ C, /*const*/ CXXRecordDecl /*P*/ TempTy) /*const*/ {
    if (!C.hasSameUnqualifiedType(getType(), C.getTypeDeclType(TempTy))) {
      return false;
    }
    
    /*const*/ Expr /*P*/ E = skipTemporaryBindingsNoOpCastsAndParens(this);
    
    // Temporaries are by definition pr-values of class type.
    if (!E.Classify(C).isPRValue()) {
      // In this context, property reference is a message call and is pr-value.
      if (!isa_ObjCPropertyRefExpr(E)) {
        return false;
      }
    }
    
    // Black-list a few cases which yield pr-values of class type that don't
    // refer to temporaries of that type:
    
    // - implicit derived-to-base conversions
    if (isa_ImplicitCastExpr(E)) {
      switch (cast_ImplicitCastExpr(E).getCastKind()) {
       case CK_DerivedToBase:
       case CK_UncheckedDerivedToBase:
        return false;
       default:
        break;
      }
    }
    
    // - member expressions (all)
    if (isa_MemberExpr(E)) {
      return false;
    }
    {
      
      /*const*/ BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(E);
      if ((BO != null)) {
        if (BO.isPtrMemOp()) {
          return false;
        }
      }
    }
    
    // - opaque values (all)
    if (isa_OpaqueValueExpr(E)) {
      return false;
    }
    
    return true;
  }

  
  /// \brief Whether this expression is an implicit reference to 'this' in C++.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::isImplicitCXXThis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 2562,
   FQN="clang::Expr::isImplicitCXXThis", NM="_ZNK5clang4Expr17isImplicitCXXThisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr17isImplicitCXXThisEv")
  //</editor-fold>
  public boolean isImplicitCXXThis() /*const*/ {
    /*const*/ Expr /*P*/ E = this;
    
    // Strip away parentheses and casts we don't care about.
    while (true) {
      {
        /*const*/ ParenExpr /*P*/ Paren = dyn_cast_ParenExpr(E);
        if ((Paren != null)) {
          E = Paren.getSubExpr$Const();
          continue;
        }
      }
      {
        
        /*const*/ ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(E);
        if ((ICE != null)) {
          if (ICE.getCastKind() == CastKind.CK_NoOp
             || ICE.getCastKind() == CastKind.CK_LValueToRValue
             || ICE.getCastKind() == CastKind.CK_DerivedToBase
             || ICE.getCastKind() == CastKind.CK_UncheckedDerivedToBase) {
            E = ICE.getSubExpr$Const();
            continue;
          }
        }
      }
      {
        
        /*const*/ UnaryOperator /*P*/ UnOp = dyn_cast_UnaryOperator(E);
        if ((UnOp != null)) {
          if (UnOp.getOpcode() == UnaryOperatorKind.UO_Extension) {
            E = UnOp.getSubExpr();
            continue;
          }
        }
      }
      {
        
        /*const*/ MaterializeTemporaryExpr /*P*/ M = dyn_cast_MaterializeTemporaryExpr(E);
        if ((M != null)) {
          E = M.GetTemporaryExpr();
          continue;
        }
      }
      
      break;
    }
    {
      
      /*const*/ CXXThisExpr /*P*/ This = dyn_cast_CXXThisExpr(E);
      if ((This != null)) {
        return This.isImplicit();
      }
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::IgnoreImpCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 797,
   FQN="clang::Expr::IgnoreImpCasts", NM="_ZNK5clang4Expr14IgnoreImpCastsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr14IgnoreImpCastsEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ IgnoreImpCasts$Const() /*const*//* __attribute__((pure))*/ {
    return ((/*const_cast*/Expr /*P*/ )(this)).IgnoreImpCasts();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Expr::IgnoreParens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 800,
   FQN="clang::Expr::IgnoreParens", NM="_ZNK5clang4Expr12IgnoreParensEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr12IgnoreParensEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ IgnoreParens$Const() /*const*//* __attribute__((pure))*/ {
    return ((/*const_cast*/Expr /*P*/ )(this)).IgnoreParens();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Expr::IgnoreParenCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 803,
   FQN="clang::Expr::IgnoreParenCasts", NM="_ZNK5clang4Expr16IgnoreParenCastsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr16IgnoreParenCastsEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ IgnoreParenCasts$Const() /*const*//* __attribute__((pure))*/ {
    return ((/*const_cast*/Expr /*P*/ )(this)).IgnoreParenCasts();
  }

  /// Strip off casts, but keep parentheses.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::IgnoreCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 807,
   FQN="clang::Expr::IgnoreCasts", NM="_ZNK5clang4Expr11IgnoreCastsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr11IgnoreCastsEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ IgnoreCasts$Const() /*const*//* __attribute__((pure))*/ {
    return ((/*const_cast*/Expr /*P*/ )(this)).IgnoreCasts();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::IgnoreParenNoopCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 811,
   FQN="clang::Expr::IgnoreParenNoopCasts", NM="_ZNK5clang4Expr20IgnoreParenNoopCastsERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr20IgnoreParenNoopCastsERNS_10ASTContextE")
  //</editor-fold>
  public /*const*/ Expr /*P*/ IgnoreParenNoopCasts$Const(final ASTContext /*&*/ Ctx) /*const*//* __attribute__((pure))*/ {
    return ((/*const_cast*/Expr /*P*/ )(this)).IgnoreParenNoopCasts(Ctx);
  }

  
  
  /// hasAnyTypeDependentArguments - Determines if any of the expressions
  /// in Exprs is type-dependent.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::hasAnyTypeDependentArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 2606,
   FQN="clang::Expr::hasAnyTypeDependentArguments", NM="_ZN5clang4Expr28hasAnyTypeDependentArgumentsEN4llvm8ArrayRefIPS0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr28hasAnyTypeDependentArgumentsEN4llvm8ArrayRefIPS0_EE")
  //</editor-fold>
  public static boolean hasAnyTypeDependentArguments(ArrayRef<Expr /*P*/ > Exprs) {
    for (/*uint*/int I = 0; $less_uint(I, Exprs.size()); ++I)  {
      if (Exprs.$at(I).isTypeDependent()) {
        return true;
      }
    }
    
    return false;
  }

  
  /// \brief For an expression of class type or pointer to class type,
  /// return the most derived class decl the expression is known to refer to.
  ///
  /// If this expression is a cast, this method looks through it to find the
  /// most derived decl that can be inferred from the expression.
  /// This is valid because derived-to-base conversions have undefined
  /// behavior if the object isn't dynamically of the derived type.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::getBestDynamicClassType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 39,
   FQN="clang::Expr::getBestDynamicClassType", NM="_ZNK5clang4Expr23getBestDynamicClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr23getBestDynamicClassTypeEv")
  //</editor-fold>
  public /*const*/ CXXRecordDecl /*P*/ getBestDynamicClassType() /*const*/ {
    /*const*/ Expr /*P*/ E = ignoreParenBaseCasts$Const();
    
    QualType DerivedType = E.getType();
    {
      /*const*/ PointerType /*P*/ PTy = DerivedType.$arrow().getAs(PointerType.class);
      if ((PTy != null)) {
        DerivedType.$assignMove(PTy.getPointeeType());
      }
    }
    if (DerivedType.$arrow().isDependentType()) {
      return null;
    }
    
    /*const*/ RecordType /*P*/ Ty = DerivedType.$arrow().<RecordType>castAs$RecordType();
    Decl /*P*/ D = Ty.getDecl();
    return cast_CXXRecordDecl(D);
  }

  
  /// Walk outwards from an expression we want to bind a reference to and
  /// find the expression whose lifetime needs to be extended. Record
  /// the LHSs of comma expressions and adjustments needed along the path.
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::skipRValueSubobjectAdjustments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 54,
   FQN="clang::Expr::skipRValueSubobjectAdjustments", NM="_ZNK5clang4Expr30skipRValueSubobjectAdjustmentsERN4llvm15SmallVectorImplIPKS0_EERNS2_INS_19SubobjectAdjustmentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang4Expr30skipRValueSubobjectAdjustmentsERN4llvm15SmallVectorImplIPKS0_EERNS2_INS_19SubobjectAdjustmentEEE")
  //</editor-fold>
  public /*const*/ Expr /*P*/ skipRValueSubobjectAdjustments(final SmallVectorImpl</*const*/ Expr /*P*/ > /*&*/ CommaLHSs, 
                                final SmallVectorImpl<SubobjectAdjustment> /*&*/ Adjustments) /*const*/ {
    /*const*/ Expr /*P*/ E = this;
    while (true) {
      E = E.IgnoreParens$Const();
      {
        
        /*const*/ CastExpr /*P*/ CE = dyn_cast_CastExpr(E);
        if ((CE != null)) {
          if ((CE.getCastKind() == CastKind.CK_DerivedToBase
             || CE.getCastKind() == CastKind.CK_UncheckedDerivedToBase)
             && E.getType().$arrow().isRecordType()) {
            E = CE.getSubExpr$Const();
            CXXRecordDecl /*P*/ Derived = cast_CXXRecordDecl(E.getType().$arrow().<RecordType>getAs$RecordType().getDecl());
            Adjustments.push_back(new SubobjectAdjustment(CE, Derived));
            continue;
          }
          if (CE.getCastKind() == CastKind.CK_NoOp) {
            E = CE.getSubExpr$Const();
            continue;
          }
        } else {
          /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E);
          if ((ME != null)) {
            if (!ME.isArrow()) {
              assert (ME.getBase().getType().$arrow().isRecordType());
              {
                FieldDecl /*P*/ Field = dyn_cast_FieldDecl(ME.getMemberDecl());
                if ((Field != null)) {
                  if (!Field.isBitField() && !Field.getType().$arrow().isReferenceType()) {
                    E = ME.getBase();
                    Adjustments.push_back(new SubobjectAdjustment(Field));
                    continue;
                  }
                }
              }
            }
          } else {
            /*const*/ BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(E);
            if ((BO != null)) {
              if (BO.isPtrMemOp()) {
                assert (BO.getRHS().isRValue());
                E = BO.getLHS();
                /*const*/ MemberPointerType /*P*/ MPT = BO.getRHS().getType().$arrow().getAs(MemberPointerType.class);
                Adjustments.push_back(new SubobjectAdjustment(MPT, BO.getRHS()));
                continue;
              } else if (BO.getOpcode() == BinaryOperatorKind.BO_Comma) {
                CommaLHSs.push_back(BO.getLHS());
                E = BO.getRHS();
                continue;
              }
            }
          }
        }
      }
      
      // Nothing changed.
      break;
    }
    return E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Expr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 833,
   FQN="clang::Expr::classof", NM="_ZN5clang4Expr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang4Expr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass().getValue() >= StmtClass.firstExprConstant.getValue()
       && T.getStmtClass().getValue() <= StmtClass.lastExprConstant.getValue();
  }

  protected Expr(Expr other) {
    super(other);
    if (other.TR != null) {
      this.TR = other.TR.clone();
    }
  }
  
  @Override public String toString() {
    return "" + "TR=" + TR // NOI18N
              + super.toString(); // NOI18N
  }
}
