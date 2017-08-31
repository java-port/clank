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

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// A Microsoft C++ @c __uuidof expression, which gets
/// the _GUID that corresponds to the supplied type or expression.
///
/// This represents code like @c __uuidof(COMTYPE) or @c __uuidof(*comPtr)
//<editor-fold defaultstate="collapsed" desc="clang::CXXUuidofExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 784,
 FQN="clang::CXXUuidofExpr", NM="_ZN5clang13CXXUuidofExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXUuidofExprE")
//</editor-fold>
public class CXXUuidofExpr extends /*public*/ Expr {
/*private:*/
  private PointerUnion<Stmt /*P*/ , TypeSourceInfo /*P*/ > Operand;
  private StringRef UuidStr;
  private SourceRange Range;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUuidofExpr::CXXUuidofExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 791,
   FQN="clang::CXXUuidofExpr::CXXUuidofExpr", NM="_ZN5clang13CXXUuidofExprC1ENS_8QualTypeEPNS_14TypeSourceInfoEN4llvm9StringRefENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXUuidofExprC1ENS_8QualTypeEPNS_14TypeSourceInfoEN4llvm9StringRefENS_11SourceRangeE")
  //</editor-fold>
  public CXXUuidofExpr(QualType Ty, TypeSourceInfo /*P*/ Operand, StringRef UuidStr, 
      SourceRange R) {
    // : Expr(CXXUuidofExprClass, Ty, VK_LValue, OK_Ordinary, false, Operand->getType()->isDependentType(), Operand->getType()->isInstantiationDependentType(), Operand->getType()->containsUnexpandedParameterPack()), Operand(Operand), UuidStr(UuidStr), Range(R) 
    //START JInit
    super(StmtClass.CXXUuidofExprClass, new QualType(Ty), ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, false, 
        Operand.getType().$arrow().isDependentType(), 
        Operand.getType().$arrow().isInstantiationDependentType(), 
        Operand.getType().$arrow().containsUnexpandedParameterPack());
    this.Operand = new PointerUnion<Stmt /*P*/ , TypeSourceInfo /*P*/ >(JD$T1.INSTANCE, TypeSourceInfo /*P*/ .class, Operand);
    this.UuidStr = new StringRef(UuidStr);
    this.Range = new SourceRange(R);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUuidofExpr::CXXUuidofExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 799,
   FQN="clang::CXXUuidofExpr::CXXUuidofExpr", NM="_ZN5clang13CXXUuidofExprC1ENS_8QualTypeEPNS_4ExprEN4llvm9StringRefENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXUuidofExprC1ENS_8QualTypeEPNS_4ExprEN4llvm9StringRefENS_11SourceRangeE")
  //</editor-fold>
  public CXXUuidofExpr(QualType Ty, Expr /*P*/ Operand, StringRef UuidStr, SourceRange R) {
    // : Expr(CXXUuidofExprClass, Ty, VK_LValue, OK_Ordinary, false, Operand->isTypeDependent(), Operand->isInstantiationDependent(), Operand->containsUnexpandedParameterPack()), Operand(Operand), UuidStr(UuidStr), Range(R) 
    //START JInit
    super(StmtClass.CXXUuidofExprClass, new QualType(Ty), ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, false, 
        Operand.isTypeDependent(), Operand.isInstantiationDependent(), 
        Operand.containsUnexpandedParameterPack());
    this.Operand = new PointerUnion<Stmt /*P*/ , TypeSourceInfo /*P*/ >(JD$T.INSTANCE, Stmt /*P*/ .class, Operand);
    this.UuidStr = new StringRef(UuidStr);
    this.Range = new SourceRange(R);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUuidofExpr::CXXUuidofExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 805,
   FQN="clang::CXXUuidofExpr::CXXUuidofExpr", NM="_ZN5clang13CXXUuidofExprC1ENS_4Stmt10EmptyShellEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXUuidofExprC1ENS_4Stmt10EmptyShellEb")
  //</editor-fold>
  public CXXUuidofExpr(EmptyShell Empty, boolean isExpr) {
    // : Expr(CXXUuidofExprClass, Empty), Operand(), UuidStr(), Range() 
    //START JInit
    super(StmtClass.CXXUuidofExprClass, new EmptyShell(Empty));
    this.Operand = new PointerUnion<Stmt /*P*/ , TypeSourceInfo /*P*/ >(Stmt /*P*/ .class);
    this.UuidStr = new StringRef();
    this.Range = new SourceRange();
    //END JInit
    if (isExpr) {
      Operand.$assign_T$C$R(Stmt /*P*/.class, (Expr /*P*/ )(Expr /*P*/ )null);
    } else {
      Operand.$assign_T1$C$R(TypeSourceInfo /*P*/.class, (TypeSourceInfo /*P*/ )null);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUuidofExpr::isTypeOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 813,
   FQN="clang::CXXUuidofExpr::isTypeOperand", NM="_ZNK5clang13CXXUuidofExpr13isTypeOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXUuidofExpr13isTypeOperandEv")
  //</editor-fold>
  public boolean isTypeOperand() /*const*/ {
    return (Operand.is(TypeSourceInfo /*P*/.class) != 0);
  }

  
  /// \brief Retrieves the type operand of this __uuidof() expression after
  /// various required adjustments (removing reference types, cv-qualifiers).
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUuidofExpr::getTypeOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 50,
   FQN="clang::CXXUuidofExpr::getTypeOperand", NM="_ZNK5clang13CXXUuidofExpr14getTypeOperandERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXUuidofExpr14getTypeOperandERNS_10ASTContextE")
  //</editor-fold>
  public QualType getTypeOperand(final ASTContext /*&*/ Context) /*const*/ {
    assert (isTypeOperand()) : "Cannot call getTypeOperand for __uuidof(expr)";
    Qualifiers Quals/*J*/= new Qualifiers();
    return Context.getUnqualifiedArrayType(Operand.get(TypeSourceInfo /*P*/.class).getType().getNonReferenceType(), Quals);
  }

  
  /// \brief Retrieve source information for the type operand.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUuidofExpr::getTypeOperandSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 820,
   FQN="clang::CXXUuidofExpr::getTypeOperandSourceInfo", NM="_ZNK5clang13CXXUuidofExpr24getTypeOperandSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXUuidofExpr24getTypeOperandSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeOperandSourceInfo() /*const*/ {
    assert (isTypeOperand()) : "Cannot call getTypeOperand for __uuidof(expr)";
    return Operand.get(TypeSourceInfo /*P*/.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUuidofExpr::setTypeOperandSourceInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 825,
   FQN="clang::CXXUuidofExpr::setTypeOperandSourceInfo", NM="_ZN5clang13CXXUuidofExpr24setTypeOperandSourceInfoEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXUuidofExpr24setTypeOperandSourceInfoEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setTypeOperandSourceInfo(TypeSourceInfo /*P*/ TSI) {
    assert (isTypeOperand()) : "Cannot call getTypeOperand for __uuidof(expr)";
    Operand.$assign_T1$C$R(TypeSourceInfo /*P*/.class, TSI);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUuidofExpr::getExprOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 830,
   FQN="clang::CXXUuidofExpr::getExprOperand", NM="_ZNK5clang13CXXUuidofExpr14getExprOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXUuidofExpr14getExprOperandEv")
  //</editor-fold>
  public Expr /*P*/ getExprOperand() /*const*/ {
    assert (!isTypeOperand()) : "Cannot call getExprOperand for __uuidof(type)";
    return ((/*static_cast*/Expr /*P*/ )(Operand.get(Stmt /*P*/.class)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUuidofExpr::setExprOperand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 835,
   FQN="clang::CXXUuidofExpr::setExprOperand", NM="_ZN5clang13CXXUuidofExpr14setExprOperandEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXUuidofExpr14setExprOperandEPNS_4ExprE")
  //</editor-fold>
  public void setExprOperand(Expr /*P*/ E) {
    assert (!isTypeOperand()) : "Cannot call getExprOperand for __uuidof(type)";
    Operand.$assign_T$C$R(Stmt /*P*/.class, E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUuidofExpr::setUuidStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 840,
   FQN="clang::CXXUuidofExpr::setUuidStr", NM="_ZN5clang13CXXUuidofExpr10setUuidStrEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXUuidofExpr10setUuidStrEN4llvm9StringRefE")
  //</editor-fold>
  public void setUuidStr(StringRef US) {
    UuidStr.$assign(US);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXUuidofExpr::getUuidStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 841,
   FQN="clang::CXXUuidofExpr::getUuidStr", NM="_ZNK5clang13CXXUuidofExpr10getUuidStrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXUuidofExpr10getUuidStrEv")
  //</editor-fold>
  public StringRef getUuidStr() /*const*/ {
    return new StringRef(UuidStr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUuidofExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 843,
   FQN="clang::CXXUuidofExpr::getLocStart", NM="_ZNK5clang13CXXUuidofExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXUuidofExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return Range.getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXUuidofExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 844,
   FQN="clang::CXXUuidofExpr::getLocEnd", NM="_ZNK5clang13CXXUuidofExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXUuidofExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return Range.getEnd();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXUuidofExpr::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 845,
   FQN="clang::CXXUuidofExpr::getSourceRange", NM="_ZNK5clang13CXXUuidofExpr14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXUuidofExpr14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return new SourceRange(Range);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXUuidofExpr::setSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 846,
   FQN="clang::CXXUuidofExpr::setSourceRange", NM="_ZN5clang13CXXUuidofExpr14setSourceRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXUuidofExpr14setSourceRangeENS_11SourceRangeE")
  //</editor-fold>
  public void setSourceRange(SourceRange R) {
    Range.$assign(R);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUuidofExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 848,
   FQN="clang::CXXUuidofExpr::classof", NM="_ZN5clang13CXXUuidofExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXUuidofExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXUuidofExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CXXUuidofExpr::children">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*reinterpret_cast=>getAddrOfPtr1*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 853,
   FQN="clang::CXXUuidofExpr::children", NM="_ZN5clang13CXXUuidofExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXUuidofExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    if (isTypeOperand()) {
      return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
    }
    type$ptr<Stmt /*P*/ /*P*/> begin = Operand.getAddrOfPtr1(Stmt.class);
    return new iterator_range<Stmt/*P*/>(new StmtIterator(begin), new StmtIterator(begin.$add(1)));
  }

  
  @Override public String toString() {
    return "" + "Operand=" + Operand // NOI18N
              + ", UuidStr=" + UuidStr // NOI18N
              + ", Range=" + Range // NOI18N
              + super.toString(); // NOI18N
  }
}
