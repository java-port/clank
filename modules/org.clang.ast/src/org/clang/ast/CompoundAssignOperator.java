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
import org.clang.basic.*;


/// CompoundAssignOperator - For compound assignments (e.g. +=), we keep
/// track of the type the operation is performed in.  Due to the semantics of
/// these operators, the operands are promoted, the arithmetic performed, an
/// implicit conversion back to the result type done, then the assignment takes
/// place.  This captures the intermediate type which the computation is done
/// in.
//<editor-fold defaultstate="collapsed" desc="clang::CompoundAssignOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3092,
 FQN="clang::CompoundAssignOperator", NM="_ZN5clang22CompoundAssignOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang22CompoundAssignOperatorE")
//</editor-fold>
public class CompoundAssignOperator extends /*public*/ BinaryOperator {
  private QualType ComputationLHSType;
  private QualType ComputationResultType;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundAssignOperator::CompoundAssignOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3096,
   FQN="clang::CompoundAssignOperator::CompoundAssignOperator", NM="_ZN5clang22CompoundAssignOperatorC1EPNS_4ExprES2_NS_18BinaryOperatorKindENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindES4_S4_NS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang22CompoundAssignOperatorC1EPNS_4ExprES2_NS_18BinaryOperatorKindENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindES4_S4_NS_14SourceLocationEb")
  //</editor-fold>
  public CompoundAssignOperator(Expr /*P*/ lhs, Expr /*P*/ rhs, BinaryOperatorKind opc, QualType ResType, 
      ExprValueKind VK, ExprObjectKind OK, 
      QualType CompLHSType, QualType CompResultType, 
      SourceLocation OpLoc, boolean fpContractable) {
    // : BinaryOperator(lhs, rhs, opc, ResType, VK, OK, OpLoc, fpContractable, true), ComputationLHSType(CompLHSType), ComputationResultType(CompResultType) 
    //START JInit
    super(lhs, rhs, opc, new QualType(ResType), VK, OK, new SourceLocation(OpLoc), fpContractable, 
        true);
    this.ComputationLHSType = new QualType(CompLHSType);
    this.ComputationResultType = new QualType(CompResultType);
    //END JInit
    assert (isCompoundAssignmentOp()) : "Only should be used for compound assignments";
  }

  
  /// \brief Build an empty compound assignment operator expression.
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundAssignOperator::CompoundAssignOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3109,
   FQN="clang::CompoundAssignOperator::CompoundAssignOperator", NM="_ZN5clang22CompoundAssignOperatorC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang22CompoundAssignOperatorC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ CompoundAssignOperator(EmptyShell Empty) {
    // : BinaryOperator(CompoundAssignOperatorClass, Empty), ComputationLHSType(), ComputationResultType() 
    //START JInit
    super(StmtClass.CompoundAssignOperatorClass, new EmptyShell(Empty));
    this.ComputationLHSType = new QualType();
    this.ComputationResultType = new QualType();
    //END JInit
  }

  
  // The two computation types are the type the LHS is converted
  // to for the computation and the type of the result; the two are
  // distinct in a few cases (specifically, int+=ptr and ptr-=ptr).
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundAssignOperator::getComputationLHSType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3115,
   FQN="clang::CompoundAssignOperator::getComputationLHSType", NM="_ZNK5clang22CompoundAssignOperator21getComputationLHSTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang22CompoundAssignOperator21getComputationLHSTypeEv")
  //</editor-fold>
  public QualType getComputationLHSType() /*const*/ {
    return new QualType(ComputationLHSType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundAssignOperator::setComputationLHSType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3116,
   FQN="clang::CompoundAssignOperator::setComputationLHSType", NM="_ZN5clang22CompoundAssignOperator21setComputationLHSTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang22CompoundAssignOperator21setComputationLHSTypeENS_8QualTypeE")
  //</editor-fold>
  public void setComputationLHSType(QualType T) {
    ComputationLHSType.$assign(T);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundAssignOperator::getComputationResultType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3118,
   FQN="clang::CompoundAssignOperator::getComputationResultType", NM="_ZNK5clang22CompoundAssignOperator24getComputationResultTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang22CompoundAssignOperator24getComputationResultTypeEv")
  //</editor-fold>
  public QualType getComputationResultType() /*const*/ {
    return new QualType(ComputationResultType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundAssignOperator::setComputationResultType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3119,
   FQN="clang::CompoundAssignOperator::setComputationResultType", NM="_ZN5clang22CompoundAssignOperator24setComputationResultTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang22CompoundAssignOperator24setComputationResultTypeENS_8QualTypeE")
  //</editor-fold>
  public void setComputationResultType(QualType T) {
    ComputationResultType.$assign(T);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundAssignOperator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3121,
   FQN="clang::CompoundAssignOperator::classof", NM="_ZN5clang22CompoundAssignOperator7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang22CompoundAssignOperator7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ S) {
    return S.getStmtClass() == StmtClass.CompoundAssignOperatorClass;
  }

  
  @Override public String toString() {
    return "" + "ComputationLHSType=" + ComputationLHSType // NOI18N
              + ", ComputationResultType=" + ComputationResultType // NOI18N
              + super.toString(); // NOI18N
  }
}
