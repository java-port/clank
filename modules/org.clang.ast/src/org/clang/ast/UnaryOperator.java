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
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// UnaryOperator - This represents the unary-expression's (except sizeof and
/// alignof), the postinc/postdec operators from postfix-expression, and various
/// extensions.
///
/// Notes on various nodes:
///
/// Real/Imag - These return the real/imag part of a complex operand.  If
///   applied to a non-complex value, the former returns its operand and the
///   later returns zero in the type of the operand.
///
//<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1668,
 FQN="clang::UnaryOperator", NM="_ZN5clang13UnaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13UnaryOperatorE")
//</editor-fold>
public class UnaryOperator extends /*public*/ Expr {
/*public:*/
  /*typedef UnaryOperatorKind Opcode*/
//  public final class Opcode extends UnaryOperatorKind{ };
/*private:*/
  private /*JBYTE unsigned int*/ byte Opc /*: 5*/;
  private SourceLocation Loc;
  private Stmt /*P*/ Val;
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::UnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1678,
   FQN="clang::UnaryOperator::UnaryOperator", NM="_ZN5clang13UnaryOperatorC1EPNS_4ExprENS_17UnaryOperatorKindENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13UnaryOperatorC1EPNS_4ExprENS_17UnaryOperatorKindENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationE")
  //</editor-fold>
  public UnaryOperator(Expr /*P*/ input, UnaryOperatorKind opc, QualType type, 
      ExprValueKind VK, ExprObjectKind OK, SourceLocation l) {
    // : Expr(UnaryOperatorClass, type, VK, OK, input->isTypeDependent() || type->isDependentType(), input->isValueDependent(), (input->isInstantiationDependent() || type->isInstantiationDependentType()), input->containsUnexpandedParameterPack()), Opc(opc), Loc(l), Val(input) 
    //START JInit
    super(StmtClass.UnaryOperatorClass, new QualType(type), VK, OK, 
        input.isTypeDependent() || type.$arrow().isDependentType(), 
        input.isValueDependent(), 
        (input.isInstantiationDependent()
           || type.$arrow().isInstantiationDependentType()), 
        input.containsUnexpandedParameterPack());
    this.Opc = $uint2uint_5bits(opc.getValue());
    this.Loc = new SourceLocation(l);
    this.Val = input;
    //END JInit
  }

  
  /// \brief Build an empty unary operator.
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::UnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1689,
   FQN="clang::UnaryOperator::UnaryOperator", NM="_ZN5clang13UnaryOperatorC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13UnaryOperatorC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ UnaryOperator(EmptyShell Empty) {
    // : Expr(UnaryOperatorClass, Empty), Opc(UO_AddrOf), Loc() 
    //START JInit
    super(StmtClass.UnaryOperatorClass, new EmptyShell(Empty));
    this.Opc = $uint2uint_5bits(UnaryOperatorKind.UO_AddrOf.getValue());
    this.Loc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::getOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1692,
   FQN="clang::UnaryOperator::getOpcode", NM="_ZNK5clang13UnaryOperator9getOpcodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13UnaryOperator9getOpcodeEv")
  //</editor-fold>
  public UnaryOperatorKind getOpcode() /*const*/ {
    return /*static_cast*/UnaryOperatorKind.valueOf(Opc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::setOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1693,
   FQN="clang::UnaryOperator::setOpcode", NM="_ZN5clang13UnaryOperator9setOpcodeENS_17UnaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13UnaryOperator9setOpcodeENS_17UnaryOperatorKindE")
  //</editor-fold>
  public void setOpcode(UnaryOperatorKind O) {
    Opc = $uint2uint_5bits(O.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1695,
   FQN="clang::UnaryOperator::getSubExpr", NM="_ZNK5clang13UnaryOperator10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13UnaryOperator10getSubExprEv")
  //</editor-fold>
  public Expr /*P*/ getSubExpr() /*const*/ {
    return cast_Expr(Val);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::setSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1696,
   FQN="clang::UnaryOperator::setSubExpr", NM="_ZN5clang13UnaryOperator10setSubExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13UnaryOperator10setSubExprEPNS_4ExprE")
  //</editor-fold>
  public void setSubExpr(Expr /*P*/ E) {
    Val = E;
  }

  
  /// getOperatorLoc - Return the location of the operator.
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::getOperatorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1699,
   FQN="clang::UnaryOperator::getOperatorLoc", NM="_ZNK5clang13UnaryOperator14getOperatorLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13UnaryOperator14getOperatorLocEv")
  //</editor-fold>
  public SourceLocation getOperatorLoc() /*const*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::setOperatorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1700,
   FQN="clang::UnaryOperator::setOperatorLoc", NM="_ZN5clang13UnaryOperator14setOperatorLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13UnaryOperator14setOperatorLocENS_14SourceLocationE")
  //</editor-fold>
  public void setOperatorLoc(SourceLocation L) {
    Loc.$assign(L);
  }

  
  /// isPostfix - Return true if this is a postfix operation, like x++.
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::isPostfix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1703,
   FQN="clang::UnaryOperator::isPostfix", NM="_ZN5clang13UnaryOperator9isPostfixENS_17UnaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13UnaryOperator9isPostfixENS_17UnaryOperatorKindE")
  //</editor-fold>
  public static boolean isPostfix(UnaryOperatorKind Op) {
    return Op == UnaryOperatorKind.UO_PostInc || Op == UnaryOperatorKind.UO_PostDec;
  }

  
  /// isPrefix - Return true if this is a prefix operation, like --x.
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::isPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1708,
   FQN="clang::UnaryOperator::isPrefix", NM="_ZN5clang13UnaryOperator8isPrefixENS_17UnaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13UnaryOperator8isPrefixENS_17UnaryOperatorKindE")
  //</editor-fold>
  public static boolean isPrefix(UnaryOperatorKind Op) {
    return Op == UnaryOperatorKind.UO_PreInc || Op == UnaryOperatorKind.UO_PreDec;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::isPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1712,
   FQN="clang::UnaryOperator::isPrefix", NM="_ZNK5clang13UnaryOperator8isPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13UnaryOperator8isPrefixEv")
  //</editor-fold>
  public boolean isPrefix() /*const*/ {
    return isPrefix(getOpcode());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::isPostfix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1713,
   FQN="clang::UnaryOperator::isPostfix", NM="_ZNK5clang13UnaryOperator9isPostfixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13UnaryOperator9isPostfixEv")
  //</editor-fold>
  public boolean isPostfix() /*const*/ {
    return isPostfix(getOpcode());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::isIncrementOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1715,
   FQN="clang::UnaryOperator::isIncrementOp", NM="_ZN5clang13UnaryOperator13isIncrementOpENS_17UnaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13UnaryOperator13isIncrementOpENS_17UnaryOperatorKindE")
  //</editor-fold>
  public static boolean isIncrementOp(UnaryOperatorKind Op) {
    return Op == UnaryOperatorKind.UO_PreInc || Op == UnaryOperatorKind.UO_PostInc;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::isIncrementOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1718,
   FQN="clang::UnaryOperator::isIncrementOp", NM="_ZNK5clang13UnaryOperator13isIncrementOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13UnaryOperator13isIncrementOpEv")
  //</editor-fold>
  public boolean isIncrementOp() /*const*/ {
    return isIncrementOp(getOpcode());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::isDecrementOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1722,
   FQN="clang::UnaryOperator::isDecrementOp", NM="_ZN5clang13UnaryOperator13isDecrementOpENS_17UnaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13UnaryOperator13isDecrementOpENS_17UnaryOperatorKindE")
  //</editor-fold>
  public static boolean isDecrementOp(UnaryOperatorKind Op) {
    return Op == UnaryOperatorKind.UO_PreDec || Op == UnaryOperatorKind.UO_PostDec;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::isDecrementOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1725,
   FQN="clang::UnaryOperator::isDecrementOp", NM="_ZNK5clang13UnaryOperator13isDecrementOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13UnaryOperator13isDecrementOpEv")
  //</editor-fold>
  public boolean isDecrementOp() /*const*/ {
    return isDecrementOp(getOpcode());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::isIncrementDecrementOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1729,
   FQN="clang::UnaryOperator::isIncrementDecrementOp", NM="_ZN5clang13UnaryOperator22isIncrementDecrementOpENS_17UnaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13UnaryOperator22isIncrementDecrementOpENS_17UnaryOperatorKindE")
  //</editor-fold>
  public static boolean isIncrementDecrementOp(UnaryOperatorKind Op) {
    return Op.getValue() <= UnaryOperatorKind.UO_PreDec.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::isIncrementDecrementOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1730,
   FQN="clang::UnaryOperator::isIncrementDecrementOp", NM="_ZNK5clang13UnaryOperator22isIncrementDecrementOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13UnaryOperator22isIncrementDecrementOpEv")
  //</editor-fold>
  public boolean isIncrementDecrementOp() /*const*/ {
    return isIncrementDecrementOp(getOpcode());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::isArithmeticOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1734,
   FQN="clang::UnaryOperator::isArithmeticOp", NM="_ZN5clang13UnaryOperator14isArithmeticOpENS_17UnaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13UnaryOperator14isArithmeticOpENS_17UnaryOperatorKindE")
  //</editor-fold>
  public static boolean isArithmeticOp(UnaryOperatorKind Op) {
    return Op.getValue() >= UnaryOperatorKind.UO_Plus.getValue() && Op.getValue() <= UnaryOperatorKind.UO_LNot.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::isArithmeticOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1737,
   FQN="clang::UnaryOperator::isArithmeticOp", NM="_ZNK5clang13UnaryOperator14isArithmeticOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13UnaryOperator14isArithmeticOpEv")
  //</editor-fold>
  public boolean isArithmeticOp() /*const*/ {
    return isArithmeticOp(getOpcode());
  }

  
  /// getOpcodeStr - Turn an Opcode enum value into the punctuation char it
  /// corresponds to, e.g. "sizeof" or "[pre]++"
  
  /// getOpcodeStr - Turn an Opcode enum value into the punctuation char it
  /// corresponds to, e.g. "sizeof" or "[pre]++".
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::getOpcodeStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1085,
   FQN="clang::UnaryOperator::getOpcodeStr", NM="_ZN5clang13UnaryOperator12getOpcodeStrENS_17UnaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13UnaryOperator12getOpcodeStrENS_17UnaryOperatorKindE")
  //</editor-fold>
  public static StringRef getOpcodeStr(UnaryOperatorKind Op) {
    switch (Op) {
     case UO_PostInc:
      
      //===- Unary Operations ---------------------------------------------------===//
      // Note that additions to this should also update the StmtVisitor class.
      
      // [C99 6.5.2.4] Postfix increment and decrement
      return new StringRef(/*KEEP_STR*/$PLUS_PLUS);
     case UO_PostDec:
      return new StringRef(/*KEEP_STR*/$MINUS_MINUS);
     case UO_PreInc:
      // [C99 6.5.3.1] Prefix increment and decrement 
      return new StringRef(/*KEEP_STR*/$PLUS_PLUS);
     case UO_PreDec:
      return new StringRef(/*KEEP_STR*/$MINUS_MINUS);
     case UO_AddrOf:
      // [C99 6.5.3.2] Address and indirection
      return new StringRef(/*KEEP_STR*/$AMP);
     case UO_Deref:
      return new StringRef(/*KEEP_STR*/$STAR);
     case UO_Plus:
      // [C99 6.5.3.3] Unary arithmetic 
      return new StringRef(/*KEEP_STR*/$PLUS);
     case UO_Minus:
      return new StringRef(/*KEEP_STR*/$MINUS);
     case UO_Not:
      return new StringRef(/*KEEP_STR*/$TILDE);
     case UO_LNot:
      return new StringRef(/*KEEP_STR*/$EXCLAIM);
     case UO_Real:
      // "__real expr"/"__imag expr" Extension.
      return new StringRef(/*KEEP_STR*/$__real);
     case UO_Imag:
      return new StringRef(/*KEEP_STR*/$__imag);
     case UO_Extension:
      // __extension__ marker.
      return new StringRef(/*KEEP_STR*/$__extension__);
     case UO_Coawait:
      // [C++ Coroutines] co_await operator
      return new StringRef(/*KEEP_STR*/$co_await);
    }
    throw new llvm_unreachable("Unknown unary operator");
  }

  
  /// \brief Retrieve the unary opcode that corresponds to the given
  /// overloaded operator.
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::getOverloadedOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1093,
   FQN="clang::UnaryOperator::getOverloadedOpcode", NM="_ZN5clang13UnaryOperator19getOverloadedOpcodeENS_22OverloadedOperatorKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13UnaryOperator19getOverloadedOpcodeENS_22OverloadedOperatorKindEb")
  //</editor-fold>
  public static UnaryOperatorKind getOverloadedOpcode(OverloadedOperatorKind OO, boolean Postfix) {
    switch (OO) {
     default:
      throw new llvm_unreachable("No unary operator for overloaded function");
     case OO_PlusPlus:
      return Postfix ? UnaryOperatorKind.UO_PostInc : UnaryOperatorKind.UO_PreInc;
     case OO_MinusMinus:
      return Postfix ? UnaryOperatorKind.UO_PostDec : UnaryOperatorKind.UO_PreDec;
     case OO_Amp:
      return UnaryOperatorKind.UO_AddrOf;
     case OO_Star:
      return UnaryOperatorKind.UO_Deref;
     case OO_Plus:
      return UnaryOperatorKind.UO_Plus;
     case OO_Minus:
      return UnaryOperatorKind.UO_Minus;
     case OO_Tilde:
      return UnaryOperatorKind.UO_Not;
     case OO_Exclaim:
      return UnaryOperatorKind.UO_LNot;
     case OO_Coawait:
      return UnaryOperatorKind.UO_Coawait;
    }
  }

  
  /// \brief Retrieve the overloaded operator kind that corresponds to
  /// the given unary opcode.
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::getOverloadedOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1109,
   FQN="clang::UnaryOperator::getOverloadedOperator", NM="_ZN5clang13UnaryOperator21getOverloadedOperatorENS_17UnaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13UnaryOperator21getOverloadedOperatorENS_17UnaryOperatorKindE")
  //</editor-fold>
  public static OverloadedOperatorKind getOverloadedOperator(UnaryOperatorKind Opc) {
    switch (Opc) {
     case UO_PostInc:
     case UO_PreInc:
      return OverloadedOperatorKind.OO_PlusPlus;
     case UO_PostDec:
     case UO_PreDec:
      return OverloadedOperatorKind.OO_MinusMinus;
     case UO_AddrOf:
      return OverloadedOperatorKind.OO_Amp;
     case UO_Deref:
      return OverloadedOperatorKind.OO_Star;
     case UO_Plus:
      return OverloadedOperatorKind.OO_Plus;
     case UO_Minus:
      return OverloadedOperatorKind.OO_Minus;
     case UO_Not:
      return OverloadedOperatorKind.OO_Tilde;
     case UO_LNot:
      return OverloadedOperatorKind.OO_Exclaim;
     case UO_Coawait:
      return OverloadedOperatorKind.OO_Coawait;
     default:
      return OverloadedOperatorKind.OO_None;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1751,
   FQN="clang::UnaryOperator::getLocStart", NM="_ZNK5clang13UnaryOperator11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13UnaryOperator11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return isPostfix() ? Val.getLocStart() : new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1754,
   FQN="clang::UnaryOperator::getLocEnd", NM="_ZNK5clang13UnaryOperator9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13UnaryOperator9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return isPostfix() ? new SourceLocation(Loc) : Val.getLocEnd();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::getExprLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1757,
   FQN="clang::UnaryOperator::getExprLoc", NM="_ZNK5clang13UnaryOperator10getExprLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13UnaryOperator10getExprLocEv")
  //</editor-fold>
  public SourceLocation getExprLoc() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1759,
   FQN="clang::UnaryOperator::classof", NM="_ZN5clang13UnaryOperator7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13UnaryOperator7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.UnaryOperatorClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryOperator::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1764,
   FQN="clang::UnaryOperator::children", NM="_ZN5clang13UnaryOperator8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13UnaryOperator8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Val))), new StmtIterator(create_type$ptr($AddrOf(Val)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "Opc=" + $uchar2uint(Opc) // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", Val=" + Val // NOI18N
              + super.toString(); // NOI18N
  }
}
