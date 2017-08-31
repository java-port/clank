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
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief Represents a folding of a pack over an operator.
///
/// This expression is always dependent and represents a pack expansion of the
/// forms:
///
///    ( expr op ... )
///    ( ... op expr )
///    ( expr op ... op expr )
//<editor-fold defaultstate="collapsed" desc="clang::CXXFoldExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4065,
 FQN="clang::CXXFoldExpr", NM="_ZN5clang11CXXFoldExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang11CXXFoldExprE")
//</editor-fold>
public class CXXFoldExpr extends /*public*/ Expr {
  /*friend*/public SourceLocation LParenLoc;
  /*friend*/public SourceLocation EllipsisLoc;
  /*friend*/public SourceLocation RParenLoc;
  /*friend*/public Stmt /*P*/ SubExprs[/*2*/] = new Stmt /*P*/  [2];
  /*friend*/public BinaryOperatorKind Opcode;
  
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFoldExpr::CXXFoldExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4075,
   FQN="clang::CXXFoldExpr::CXXFoldExpr", NM="_ZN5clang11CXXFoldExprC1ENS_8QualTypeENS_14SourceLocationEPNS_4ExprENS_18BinaryOperatorKindES2_S4_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang11CXXFoldExprC1ENS_8QualTypeENS_14SourceLocationEPNS_4ExprENS_18BinaryOperatorKindES2_S4_S2_")
  //</editor-fold>
  public CXXFoldExpr(QualType T, SourceLocation LParenLoc, Expr /*P*/ LHS, 
      BinaryOperatorKind Opcode, SourceLocation EllipsisLoc, Expr /*P*/ RHS, 
      SourceLocation RParenLoc) {
    // : Expr(CXXFoldExprClass, T, VK_RValue, OK_Ordinary, /*Dependent*/ true, true, true, /*ContainsUnexpandedParameterPack*/ false), LParenLoc(LParenLoc), EllipsisLoc(EllipsisLoc), RParenLoc(RParenLoc), Opcode(Opcode) 
    //START JInit
    super(StmtClass.CXXFoldExprClass, new QualType(T), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
        true, true, true, 
        false);
    this.LParenLoc = new SourceLocation(LParenLoc);
    this.EllipsisLoc = new SourceLocation(EllipsisLoc);
    this.RParenLoc = new SourceLocation(RParenLoc);
    this.Opcode = Opcode;
    //END JInit
    SubExprs[0] = LHS;
    SubExprs[1] = RHS;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXFoldExpr::CXXFoldExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4086,
   FQN="clang::CXXFoldExpr::CXXFoldExpr", NM="_ZN5clang11CXXFoldExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang11CXXFoldExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public CXXFoldExpr(EmptyShell Empty) {
    // : Expr(CXXFoldExprClass, Empty), LParenLoc(), EllipsisLoc(), RParenLoc() 
    //START JInit
    super(StmtClass.CXXFoldExprClass, new EmptyShell(Empty));
    this.LParenLoc = new SourceLocation();
    this.EllipsisLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFoldExpr::getLHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4088,
   FQN="clang::CXXFoldExpr::getLHS", NM="_ZNK5clang11CXXFoldExpr6getLHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang11CXXFoldExpr6getLHSEv")
  //</editor-fold>
  public Expr /*P*/ getLHS() /*const*/ {
    return ((/*static_cast*/Expr /*P*/ )(SubExprs[0]));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXFoldExpr::getRHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4089,
   FQN="clang::CXXFoldExpr::getRHS", NM="_ZNK5clang11CXXFoldExpr6getRHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang11CXXFoldExpr6getRHSEv")
  //</editor-fold>
  public Expr /*P*/ getRHS() /*const*/ {
    return ((/*static_cast*/Expr /*P*/ )(SubExprs[1]));
  }

  
  /// Does this produce a right-associated sequence of operators?
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFoldExpr::isRightFold">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4092,
   FQN="clang::CXXFoldExpr::isRightFold", NM="_ZNK5clang11CXXFoldExpr11isRightFoldEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang11CXXFoldExpr11isRightFoldEv")
  //</editor-fold>
  public boolean isRightFold() /*const*/ {
    return (getLHS() != null) && getLHS().containsUnexpandedParameterPack();
  }

  /// Does this produce a left-associated sequence of operators?
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFoldExpr::isLeftFold">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4096,
   FQN="clang::CXXFoldExpr::isLeftFold", NM="_ZNK5clang11CXXFoldExpr10isLeftFoldEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang11CXXFoldExpr10isLeftFoldEv")
  //</editor-fold>
  public boolean isLeftFold() /*const*/ {
    return !isRightFold();
  }

  /// Get the pattern, that is, the operand that contains an unexpanded pack.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFoldExpr::getPattern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4098,
   FQN="clang::CXXFoldExpr::getPattern", NM="_ZNK5clang11CXXFoldExpr10getPatternEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang11CXXFoldExpr10getPatternEv")
  //</editor-fold>
  public Expr /*P*/ getPattern() /*const*/ {
    return isLeftFold() ? getRHS() : getLHS();
  }

  /// Get the operand that doesn't contain a pack, for a binary fold.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFoldExpr::getInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4100,
   FQN="clang::CXXFoldExpr::getInit", NM="_ZNK5clang11CXXFoldExpr7getInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang11CXXFoldExpr7getInitEv")
  //</editor-fold>
  public Expr /*P*/ getInit() /*const*/ {
    return isLeftFold() ? getLHS() : getRHS();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFoldExpr::getEllipsisLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4102,
   FQN="clang::CXXFoldExpr::getEllipsisLoc", NM="_ZNK5clang11CXXFoldExpr14getEllipsisLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang11CXXFoldExpr14getEllipsisLocEv")
  //</editor-fold>
  public SourceLocation getEllipsisLoc() /*const*/ {
    return new SourceLocation(EllipsisLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXFoldExpr::getOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4103,
   FQN="clang::CXXFoldExpr::getOperator", NM="_ZNK5clang11CXXFoldExpr11getOperatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang11CXXFoldExpr11getOperatorEv")
  //</editor-fold>
  public BinaryOperatorKind getOperator() /*const*/ {
    return Opcode;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFoldExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4105,
   FQN="clang::CXXFoldExpr::getLocStart", NM="_ZNK5clang11CXXFoldExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang11CXXFoldExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(LParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXFoldExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4108,
   FQN="clang::CXXFoldExpr::getLocEnd", NM="_ZNK5clang11CXXFoldExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang11CXXFoldExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFoldExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4112,
   FQN="clang::CXXFoldExpr::classof", NM="_ZN5clang11CXXFoldExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang11CXXFoldExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXFoldExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFoldExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4117,
   FQN="clang::CXXFoldExpr::children", NM="_ZN5clang11CXXFoldExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang11CXXFoldExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr(SubExprs)), new StmtIterator(create_type$ptr(SubExprs).$add(2)));
  }

  
  @Override public String toString() {
    return "" + "LParenLoc=" + LParenLoc // NOI18N
              + ", EllipsisLoc=" + EllipsisLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + ", SubExprs=" + SubExprs // NOI18N
              + ", Opcode=" + Opcode // NOI18N
              + super.toString(); // NOI18N
  }
}
