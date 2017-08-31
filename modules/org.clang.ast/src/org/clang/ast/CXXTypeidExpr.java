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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// A C++ \c typeid expression (C++ [expr.typeid]), which gets
/// the \c type_info that corresponds to the supplied type, or the (possibly
/// dynamic) type of the supplied expression.
///
/// This represents code like \c typeid(int) or \c typeid(*objPtr)
//<editor-fold defaultstate="collapsed" desc="clang::CXXTypeidExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 575,
 FQN="clang::CXXTypeidExpr", NM="_ZN5clang13CXXTypeidExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXTypeidExprE")
//</editor-fold>
public class CXXTypeidExpr extends /*public*/ Expr {
/*private:*/
  private PointerUnion<Stmt /*P*/ , TypeSourceInfo /*P*/ > Operand;
  private SourceRange Range;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTypeidExpr::CXXTypeidExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 581,
   FQN="clang::CXXTypeidExpr::CXXTypeidExpr", NM="_ZN5clang13CXXTypeidExprC1ENS_8QualTypeEPNS_14TypeSourceInfoENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXTypeidExprC1ENS_8QualTypeEPNS_14TypeSourceInfoENS_11SourceRangeE")
  //</editor-fold>
  public CXXTypeidExpr(QualType Ty, TypeSourceInfo /*P*/ Operand, SourceRange R) {
    // : Expr(CXXTypeidExprClass, Ty, VK_LValue, OK_Ordinary, false, Operand->getType()->isDependentType(), Operand->getType()->isInstantiationDependentType(), Operand->getType()->containsUnexpandedParameterPack()), Operand(Operand), Range(R) 
    //START JInit
    super(StmtClass.CXXTypeidExprClass, new QualType(Ty), ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, 
        // typeid is never type-dependent (C++ [temp.dep.expr]p4)
        false, 
        // typeid is value-dependent if the type or expression are dependent
        Operand.getType().$arrow().isDependentType(), 
        Operand.getType().$arrow().isInstantiationDependentType(), 
        Operand.getType().$arrow().containsUnexpandedParameterPack());
    this.Operand = new PointerUnion<Stmt /*P*/ , TypeSourceInfo /*P*/ >(JD$T1.INSTANCE, TypeSourceInfo /*P*/ .class, Operand);
    this.Range = new SourceRange(R);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTypeidExpr::CXXTypeidExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 591,
   FQN="clang::CXXTypeidExpr::CXXTypeidExpr", NM="_ZN5clang13CXXTypeidExprC1ENS_8QualTypeEPNS_4ExprENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXTypeidExprC1ENS_8QualTypeEPNS_4ExprENS_11SourceRangeE")
  //</editor-fold>
  public CXXTypeidExpr(QualType Ty, Expr /*P*/ Operand, SourceRange R) {
    // : Expr(CXXTypeidExprClass, Ty, VK_LValue, OK_Ordinary, false, Operand->isTypeDependent() || Operand->isValueDependent(), Operand->isInstantiationDependent(), Operand->containsUnexpandedParameterPack()), Operand(Operand), Range(R) 
    //START JInit
    super(StmtClass.CXXTypeidExprClass, new QualType(Ty), ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, 
        // typeid is never type-dependent (C++ [temp.dep.expr]p4)
        false, 
        // typeid is value-dependent if the type or expression are dependent
        Operand.isTypeDependent() || Operand.isValueDependent(), 
        Operand.isInstantiationDependent(), 
        Operand.containsUnexpandedParameterPack());
    this.Operand = new PointerUnion<Stmt /*P*/ , TypeSourceInfo /*P*/ >(JD$T.INSTANCE, Stmt /*P*/ .class, Operand);
    this.Range = new SourceRange(R);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTypeidExpr::CXXTypeidExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 601,
   FQN="clang::CXXTypeidExpr::CXXTypeidExpr", NM="_ZN5clang13CXXTypeidExprC1ENS_4Stmt10EmptyShellEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXTypeidExprC1ENS_4Stmt10EmptyShellEb")
  //</editor-fold>
  public CXXTypeidExpr(EmptyShell Empty, boolean isExpr) {
    // : Expr(CXXTypeidExprClass, Empty), Operand(), Range() 
    //START JInit
    super(StmtClass.CXXTypeidExprClass, new EmptyShell(Empty));
    this.Operand = new PointerUnion<Stmt /*P*/ , TypeSourceInfo /*P*/ >(Stmt /*P*/ .class);
    this.Range = new SourceRange();
    //END JInit
    if (isExpr) {
      Operand.$assign_T$C$R(Stmt /*P*/.class, (Expr /*P*/ )null);
    } else {
      Operand.$assign_T1$C$R(TypeSourceInfo /*P*/.class, (TypeSourceInfo /*P*/ )null);
    }
  }

  
  /// Determine whether this typeid has a type operand which is potentially
  /// evaluated, per C++11 [expr.typeid]p3.
  
  //===----------------------------------------------------------------------===//
  //  Child Iterators for iterating over subexpressions/substatements
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTypeidExpr::isPotentiallyEvaluated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 28,
   FQN="clang::CXXTypeidExpr::isPotentiallyEvaluated", NM="_ZNK5clang13CXXTypeidExpr22isPotentiallyEvaluatedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXTypeidExpr22isPotentiallyEvaluatedEv")
  //</editor-fold>
  public boolean isPotentiallyEvaluated() /*const*/ {
    if (isTypeOperand()) {
      return false;
    }
    
    // C++11 [expr.typeid]p3:
    //   When typeid is applied to an expression other than a glvalue of
    //   polymorphic class type, [...] the expression is an unevaluated operand.
    /*const*/ Expr /*P*/ E = getExprOperand();
    {
      /*const*/ CXXRecordDecl /*P*/ RD = E.getType().$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        if (RD.isPolymorphic() && E.isGLValue()) {
          return true;
        }
      }
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTypeidExpr::isTypeOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 613,
   FQN="clang::CXXTypeidExpr::isTypeOperand", NM="_ZNK5clang13CXXTypeidExpr13isTypeOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXTypeidExpr13isTypeOperandEv")
  //</editor-fold>
  public boolean isTypeOperand() /*const*/ {
    return (Operand.is(TypeSourceInfo /*P*/.class) != 0);
  }

  
  /// \brief Retrieves the type operand of this typeid() expression after
  /// various required adjustments (removing reference types, cv-qualifiers).
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTypeidExpr::getTypeOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 43,
   FQN="clang::CXXTypeidExpr::getTypeOperand", NM="_ZNK5clang13CXXTypeidExpr14getTypeOperandERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXTypeidExpr14getTypeOperandERNS_10ASTContextE")
  //</editor-fold>
  public QualType getTypeOperand(final ASTContext /*&*/ Context) /*const*/ {
    assert (isTypeOperand()) : "Cannot call getTypeOperand for typeid(expr)";
    Qualifiers Quals/*J*/= new Qualifiers();
    return Context.getUnqualifiedArrayType(Operand.get(TypeSourceInfo /*P*/.class).getType().getNonReferenceType(), Quals);
  }

  
  /// \brief Retrieve source information for the type operand.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTypeidExpr::getTypeOperandSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 620,
   FQN="clang::CXXTypeidExpr::getTypeOperandSourceInfo", NM="_ZNK5clang13CXXTypeidExpr24getTypeOperandSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXTypeidExpr24getTypeOperandSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeOperandSourceInfo() /*const*/ {
    assert (isTypeOperand()) : "Cannot call getTypeOperand for typeid(expr)";
    return Operand.get(TypeSourceInfo /*P*/.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTypeidExpr::setTypeOperandSourceInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 625,
   FQN="clang::CXXTypeidExpr::setTypeOperandSourceInfo", NM="_ZN5clang13CXXTypeidExpr24setTypeOperandSourceInfoEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXTypeidExpr24setTypeOperandSourceInfoEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setTypeOperandSourceInfo(TypeSourceInfo /*P*/ TSI) {
    assert (isTypeOperand()) : "Cannot call getTypeOperand for typeid(expr)";
    Operand.$assign_T1$C$R(TypeSourceInfo /*P*/.class, TSI);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTypeidExpr::getExprOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 630,
   FQN="clang::CXXTypeidExpr::getExprOperand", NM="_ZNK5clang13CXXTypeidExpr14getExprOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXTypeidExpr14getExprOperandEv")
  //</editor-fold>
  public Expr /*P*/ getExprOperand() /*const*/ {
    assert (!isTypeOperand()) : "Cannot call getExprOperand for typeid(type)";
    return ((/*static_cast*/Expr /*P*/ )(Operand.get(Stmt /*P*/.class)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTypeidExpr::setExprOperand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 635,
   FQN="clang::CXXTypeidExpr::setExprOperand", NM="_ZN5clang13CXXTypeidExpr14setExprOperandEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXTypeidExpr14setExprOperandEPNS_4ExprE")
  //</editor-fold>
  public void setExprOperand(Expr /*P*/ E) {
    assert (!isTypeOperand()) : "Cannot call getExprOperand for typeid(type)";
    Operand.$assign_T$C$R(Stmt /*P*/.class, E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTypeidExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 640,
   FQN="clang::CXXTypeidExpr::getLocStart", NM="_ZNK5clang13CXXTypeidExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXTypeidExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return Range.getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXTypeidExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 641,
   FQN="clang::CXXTypeidExpr::getLocEnd", NM="_ZNK5clang13CXXTypeidExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXTypeidExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return Range.getEnd();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXTypeidExpr::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 642,
   FQN="clang::CXXTypeidExpr::getSourceRange", NM="_ZNK5clang13CXXTypeidExpr14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXTypeidExpr14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return new SourceRange(Range);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXTypeidExpr::setSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 643,
   FQN="clang::CXXTypeidExpr::setSourceRange", NM="_ZN5clang13CXXTypeidExpr14setSourceRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXTypeidExpr14setSourceRangeENS_11SourceRangeE")
  //</editor-fold>
  public void setSourceRange(SourceRange R) {
    Range.$assign(R);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTypeidExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 645,
   FQN="clang::CXXTypeidExpr::classof", NM="_ZN5clang13CXXTypeidExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXTypeidExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXTypeidExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTypeidExpr::children">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 650,
   FQN="clang::CXXTypeidExpr::children", NM="_ZN5clang13CXXTypeidExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXTypeidExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    if (isTypeOperand()) {
      return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
    }
    type$ptr<Stmt /*P*/ /*P*/> begin = $tryClone(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, $AddrOf(Operand.getAddrOfPtr1(Stmt.class)))));
    return new iterator_range<Stmt/*P*/>(new StmtIterator(begin), new StmtIterator(begin.$add(1)));
  }

  
  @Override public String toString() {
    return "" + "Operand=" + Operand // NOI18N
              + ", Range=" + Range // NOI18N
              + super.toString(); // NOI18N
  }
}
