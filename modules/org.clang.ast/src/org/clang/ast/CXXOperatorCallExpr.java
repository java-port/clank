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
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


//===--------------------------------------------------------------------===//
// C++ Expressions.
//===--------------------------------------------------------------------===//

/// \brief A call to an overloaded operator written using operator
/// syntax.
///
/// Represents a call to an overloaded operator written using operator
/// syntax, e.g., "x + y" or "*p". While semantically equivalent to a
/// normal call, this AST node provides better information about the
/// syntactic representation of the call.
///
/// In a C++ template, this expression node kind will be used whenever
/// any of the arguments are type-dependent. In this case, the
/// function itself will be a (possibly empty) set of functions and
/// function templates that were found by name lookup at template
/// definition time.
//<editor-fold defaultstate="collapsed" desc="clang::CXXOperatorCallExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 52,
 FQN="clang::CXXOperatorCallExpr", NM="_ZN5clang19CXXOperatorCallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang19CXXOperatorCallExprE")
//</editor-fold>
public class CXXOperatorCallExpr extends /*public*/ CallExpr {
  /// \brief The overloaded operator.
  /*friend*/public OverloadedOperatorKind Operator;
  /*friend*/public SourceRange Range;
  
  // Record the FP_CONTRACT state that applies to this operator call. Only
  // meaningful for floating point types. For other types this value can be
  // set to false.
  private /*JBIT unsigned int*/ boolean FPContractable /*: 1*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXOperatorCallExpr::getSourceRangeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 435,
   FQN="clang::CXXOperatorCallExpr::getSourceRangeImpl", NM="_ZNK5clang19CXXOperatorCallExpr18getSourceRangeImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang19CXXOperatorCallExpr18getSourceRangeImplEv")
  //</editor-fold>
  private SourceRange getSourceRangeImpl() /*const*//* __attribute__((pure))*/ {
    OverloadedOperatorKind Kind = getOperator();
    if (Kind == OverloadedOperatorKind.OO_PlusPlus || Kind == OverloadedOperatorKind.OO_MinusMinus) {
      if (getNumArgs() == 1) {
        // Prefix operator
        return new SourceRange(getOperatorLoc(), getArg$Const(0).getLocEnd());
      } else {
        // Postfix operator
        return new SourceRange(getArg$Const(0).getLocStart(), getOperatorLoc());
      }
    } else if (Kind == OverloadedOperatorKind.OO_Arrow) {
      return getArg$Const(0).getSourceRange();
    } else if (Kind == OverloadedOperatorKind.OO_Call) {
      return new SourceRange(getArg$Const(0).getLocStart(), getRParenLoc());
    } else if (Kind == OverloadedOperatorKind.OO_Subscript) {
      return new SourceRange(getArg$Const(0).getLocStart(), getRParenLoc());
    } else if (getNumArgs() == 1) {
      return new SourceRange(getOperatorLoc(), getArg$Const(0).getLocEnd());
    } else if (getNumArgs() == 2) {
      return new SourceRange(getArg$Const(0).getLocStart(), getArg$Const(1).getLocEnd());
    } else {
      return new SourceRange(getOperatorLoc());
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXOperatorCallExpr::CXXOperatorCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 64,
   FQN="clang::CXXOperatorCallExpr::CXXOperatorCallExpr", NM="_ZN5clang19CXXOperatorCallExprC1ERNS_10ASTContextENS_22OverloadedOperatorKindEPNS_4ExprEN4llvm8ArrayRefIS5_EENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang19CXXOperatorCallExprC1ERNS_10ASTContextENS_22OverloadedOperatorKindEPNS_4ExprEN4llvm8ArrayRefIS5_EENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationEb")
  //</editor-fold>
  public CXXOperatorCallExpr(final ASTContext /*&*/ C, OverloadedOperatorKind Op, Expr /*P*/ fn, 
      ArrayRef<Expr /*P*/ > args, QualType t, ExprValueKind VK, 
      SourceLocation operatorloc, boolean fpContractable) {
    // : CallExpr(C, CXXOperatorCallExprClass, fn, args, t, VK, operatorloc), Operator(Op), Range(), FPContractable(fpContractable) 
    //START JInit
    super(C, StmtClass.CXXOperatorCallExprClass, fn, new ArrayRef<Expr /*P*/ >(args), new QualType(t), VK, new SourceLocation(operatorloc));
    this.Operator = Op;
    this.Range = new SourceRange();
    this.FPContractable = fpContractable;
    //END JInit
    Range.$assignMove(getSourceRangeImpl());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXOperatorCallExpr::CXXOperatorCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 71,
   FQN="clang::CXXOperatorCallExpr::CXXOperatorCallExpr", NM="_ZN5clang19CXXOperatorCallExprC1ERNS_10ASTContextENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang19CXXOperatorCallExprC1ERNS_10ASTContextENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ CXXOperatorCallExpr(final ASTContext /*&*/ C, EmptyShell Empty) {
    // : CallExpr(C, CXXOperatorCallExprClass, Empty), Range() 
    //START JInit
    super(C, StmtClass.CXXOperatorCallExprClass, new EmptyShell(Empty));
    this.Range = new SourceRange();
    //END JInit
  }

  
  /// \brief Returns the kind of overloaded operator that this
  /// expression refers to.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXOperatorCallExpr::getOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 77,
   FQN="clang::CXXOperatorCallExpr::getOperator", NM="_ZNK5clang19CXXOperatorCallExpr11getOperatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang19CXXOperatorCallExpr11getOperatorEv")
  //</editor-fold>
  public OverloadedOperatorKind getOperator() /*const*/ {
    return Operator;
  }

  
  /// \brief Returns the location of the operator symbol in the expression.
  ///
  /// When \c getOperator()==OO_Call, this is the location of the right
  /// parentheses; when \c getOperator()==OO_Subscript, this is the location
  /// of the right bracket.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXOperatorCallExpr::getOperatorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 84,
   FQN="clang::CXXOperatorCallExpr::getOperatorLoc", NM="_ZNK5clang19CXXOperatorCallExpr14getOperatorLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang19CXXOperatorCallExpr14getOperatorLocEv")
  //</editor-fold>
  public SourceLocation getOperatorLoc() /*const*/ {
    return getRParenLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXOperatorCallExpr::getExprLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 86,
   FQN="clang::CXXOperatorCallExpr::getExprLoc", NM="_ZNK5clang19CXXOperatorCallExpr10getExprLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang19CXXOperatorCallExpr10getExprLocEv")
  //</editor-fold>
  public SourceLocation getExprLoc() /*const*//* __attribute__((pure))*/ {
    return (Operator.getValue() < OverloadedOperatorKind.OO_Plus.getValue() || Operator.getValue() >= OverloadedOperatorKind.OO_Arrow.getValue()
       || Operator == OverloadedOperatorKind.OO_PlusPlus || Operator == OverloadedOperatorKind.OO_MinusMinus) ? getLocStart() : getOperatorLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXOperatorCallExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 93,
   FQN="clang::CXXOperatorCallExpr::getLocStart", NM="_ZNK5clang19CXXOperatorCallExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang19CXXOperatorCallExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return Range.getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXOperatorCallExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 94,
   FQN="clang::CXXOperatorCallExpr::getLocEnd", NM="_ZNK5clang19CXXOperatorCallExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang19CXXOperatorCallExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return Range.getEnd();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXOperatorCallExpr::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 95,
   FQN="clang::CXXOperatorCallExpr::getSourceRange", NM="_ZNK5clang19CXXOperatorCallExpr14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang19CXXOperatorCallExpr14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*/ {
    return new SourceRange(Range);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXOperatorCallExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 97,
   FQN="clang::CXXOperatorCallExpr::classof", NM="_ZN5clang19CXXOperatorCallExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang19CXXOperatorCallExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXOperatorCallExprClass;
  }

  
  // Set the FP contractability status of this operator. Only meaningful for
  // operations on floating point types.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXOperatorCallExpr::setFPContractable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 103,
   FQN="clang::CXXOperatorCallExpr::setFPContractable", NM="_ZN5clang19CXXOperatorCallExpr17setFPContractableEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang19CXXOperatorCallExpr17setFPContractableEb")
  //</editor-fold>
  public void setFPContractable(boolean FPC) {
    FPContractable = FPC;
  }

  
  // Get the FP contractability status of this operator. Only meaningful for
  // operations on floating point types.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXOperatorCallExpr::isFPContractable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 107,
   FQN="clang::CXXOperatorCallExpr::isFPContractable", NM="_ZNK5clang19CXXOperatorCallExpr16isFPContractableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang19CXXOperatorCallExpr16isFPContractableEv")
  //</editor-fold>
  public boolean isFPContractable() /*const*/ {
    return FPContractable;
  }

  
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
  
  @Override public String toString() {
    return "" + "Operator=" + Operator // NOI18N
              + ", Range=" + Range // NOI18N
              + ", FPContractable=" + FPContractable // NOI18N
              + super.toString(); // NOI18N
  }
}
