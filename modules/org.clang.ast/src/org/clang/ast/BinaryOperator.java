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

/// \brief A builtin binary operation expression such as "x + y" or "x <= y".
///
/// This expression node kind describes a builtin binary operation,
/// such as "x + y" for integer values "x" and "y". The operands will
/// already have been converted to appropriate types (e.g., by
/// performing promotions or conversions).
///
/// In C++, where operators may be overloaded, a different kind of
/// expression node (CXXOperatorCallExpr) is used to express the
/// invocation of an overloaded operator with operator syntax. Within
/// a C++ template, whether BinaryOperator or CXXOperatorCallExpr is
/// used to store an expression "x + y" depends on the subexpressions
/// for x and y. If neither x or y is type-dependent, and the "+"
/// operator resolves to a built-in operation, BinaryOperator will be
/// used to express the computation (x and y may still be
/// value-dependent). If either x or y is type-dependent, or if the
/// "+" resolves to an overloaded operator, CXXOperatorCallExpr will
/// be used to express the computation.
//<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2897,
 FQN="clang::BinaryOperator", NM="_ZN5clang14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperatorE")
//</editor-fold>
public class BinaryOperator extends /*public*/ Expr {
/*public:*/
  /*typedef BinaryOperatorKind Opcode*/
//  public final class Opcode extends BinaryOperatorKind{ };
/*private:*/
  private /*JBYTE unsigned int*/ byte Opc /*: 6*/;
  
  // Records the FP_CONTRACT pragma status at the point that this binary
  // operator was parsed. This bit is only meaningful for operations on
  // floating point types. For all other types it should default to
  // false.
  private /*JBIT unsigned int*/ boolean FPContractable /*: 1*/;
  private SourceLocation OpLoc;
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2911,
   FQN="clang::BinaryOperator::(anonymous)", NM="_ZN5clang14BinaryOperatorE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperatorE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    LHS(0),
    RHS(LHS.getValue() + 1),
    END_EXPR(RHS.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum)obj).value);}
    //</editor-fold>
  };
  private Stmt /*P*/ SubExprs[/*2*/] = new Stmt /*P*/  [2];
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::BinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2915,
   FQN="clang::BinaryOperator::BinaryOperator", NM="_ZN5clang14BinaryOperatorC1EPNS_4ExprES2_NS_18BinaryOperatorKindENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperatorC1EPNS_4ExprES2_NS_18BinaryOperatorKindENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationEb")
  //</editor-fold>
  public BinaryOperator(Expr /*P*/ lhs, Expr /*P*/ rhs, BinaryOperatorKind opc, QualType ResTy, 
      ExprValueKind VK, ExprObjectKind OK, 
      SourceLocation opLoc, boolean fpContractable) {
    // : Expr(BinaryOperatorClass, ResTy, VK, OK, lhs->isTypeDependent() || rhs->isTypeDependent(), lhs->isValueDependent() || rhs->isValueDependent(), (lhs->isInstantiationDependent() || rhs->isInstantiationDependent()), (lhs->containsUnexpandedParameterPack() || rhs->containsUnexpandedParameterPack())), Opc(opc), FPContractable(fpContractable), OpLoc(opLoc) 
    //START JInit
    super(StmtClass.BinaryOperatorClass, new QualType(ResTy), VK, OK, 
        lhs.isTypeDependent() || rhs.isTypeDependent(), 
        lhs.isValueDependent() || rhs.isValueDependent(), 
        (lhs.isInstantiationDependent()
           || rhs.isInstantiationDependent()), 
        (lhs.containsUnexpandedParameterPack()
           || rhs.containsUnexpandedParameterPack()));
    this.Opc = $uint2uint_6bits(opc.getValue());
    this.FPContractable = fpContractable;
    this.OpLoc = new SourceLocation(opLoc);
    //END JInit
    SubExprs[Unnamed_enum.LHS.getValue()] = lhs;
    SubExprs[Unnamed_enum.RHS.getValue()] = rhs;
    assert (!isCompoundAssignmentOp()) : "Use CompoundAssignOperator for compound assignments";
  }

  
  /// \brief Construct an empty binary operator.
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::BinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2933,
   FQN="clang::BinaryOperator::BinaryOperator", NM="_ZN5clang14BinaryOperatorC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperatorC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ BinaryOperator(EmptyShell Empty) {
    // : Expr(BinaryOperatorClass, Empty), Opc(BO_Comma), OpLoc() 
    //START JInit
    super(StmtClass.BinaryOperatorClass, new EmptyShell(Empty));
    this.Opc = $uint2uint_6bits(BinaryOperatorKind.BO_Comma.getValue());
    this.OpLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::getExprLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2936,
   FQN="clang::BinaryOperator::getExprLoc", NM="_ZNK5clang14BinaryOperator10getExprLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator10getExprLocEv")
  //</editor-fold>
  public SourceLocation getExprLoc() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(OpLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::getOperatorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2937,
   FQN="clang::BinaryOperator::getOperatorLoc", NM="_ZNK5clang14BinaryOperator14getOperatorLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator14getOperatorLocEv")
  //</editor-fold>
  public SourceLocation getOperatorLoc() /*const*/ {
    return new SourceLocation(OpLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::setOperatorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2938,
   FQN="clang::BinaryOperator::setOperatorLoc", NM="_ZN5clang14BinaryOperator14setOperatorLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator14setOperatorLocENS_14SourceLocationE")
  //</editor-fold>
  public void setOperatorLoc(SourceLocation L) {
    OpLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::getOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2940,
   FQN="clang::BinaryOperator::getOpcode", NM="_ZNK5clang14BinaryOperator9getOpcodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator9getOpcodeEv")
  //</editor-fold>
  public BinaryOperatorKind getOpcode() /*const*/ {
    return /*static_cast*/BinaryOperatorKind.valueOf(Opc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::setOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2941,
   FQN="clang::BinaryOperator::setOpcode", NM="_ZN5clang14BinaryOperator9setOpcodeENS_18BinaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator9setOpcodeENS_18BinaryOperatorKindE")
  //</editor-fold>
  public void setOpcode(BinaryOperatorKind O) {
    Opc = $uint2uint_6bits(O.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::getLHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2943,
   FQN="clang::BinaryOperator::getLHS", NM="_ZNK5clang14BinaryOperator6getLHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator6getLHSEv")
  //</editor-fold>
  public Expr /*P*/ getLHS() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.LHS.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::setLHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2944,
   FQN="clang::BinaryOperator::setLHS", NM="_ZN5clang14BinaryOperator6setLHSEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator6setLHSEPNS_4ExprE")
  //</editor-fold>
  public void setLHS(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.LHS.getValue()] = E;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::getRHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2945,
   FQN="clang::BinaryOperator::getRHS", NM="_ZNK5clang14BinaryOperator6getRHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator6getRHSEv")
  //</editor-fold>
  public Expr /*P*/ getRHS() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.RHS.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::setRHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2946,
   FQN="clang::BinaryOperator::setRHS", NM="_ZN5clang14BinaryOperator6setRHSEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator6setRHSEPNS_4ExprE")
  //</editor-fold>
  public void setRHS(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.RHS.getValue()] = E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2948,
   FQN="clang::BinaryOperator::getLocStart", NM="_ZNK5clang14BinaryOperator11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getLHS().getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2951,
   FQN="clang::BinaryOperator::getLocEnd", NM="_ZNK5clang14BinaryOperator9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getRHS().getLocEnd();
  }

  
  /// getOpcodeStr - Turn an Opcode enum value into the punctuation char it
  /// corresponds to, e.g. "<<=".
  
  /// getOpcodeStr - Turn an Opcode enum value into the punctuation char it
  /// corresponds to, e.g. "<<=".
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::getOpcodeStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1696,
   FQN="clang::BinaryOperator::getOpcodeStr", NM="_ZN5clang14BinaryOperator12getOpcodeStrENS_18BinaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator12getOpcodeStrENS_18BinaryOperatorKindE")
  //</editor-fold>
  public static StringRef getOpcodeStr(BinaryOperatorKind Op) {
    switch (Op) {
     case BO_PtrMemD:
      
      //===- Binary Operations  -------------------------------------------------===//
      // Operators listed in order of precedence.
      // Note that additions to this should also update the StmtVisitor class.
      
      // [C++ 5.5] Pointer-to-member operators.
      return new StringRef(/*KEEP_STR*/$DOT_STAR);
     case BO_PtrMemI:
      return new StringRef(/*KEEP_STR*/$ARROW_STAR);
     case BO_Mul:
      // [C99 6.5.5] Multiplicative operators.
      return new StringRef(/*KEEP_STR*/$STAR);
     case BO_Div:
      return new StringRef(/*KEEP_STR*/$SLASH);
     case BO_Rem:
      return new StringRef(/*KEEP_STR*/$PERCENT);
     case BO_Add:
      // [C99 6.5.6] Additive operators.
      return new StringRef(/*KEEP_STR*/$PLUS);
     case BO_Sub:
      return new StringRef(/*KEEP_STR*/$MINUS);
     case BO_Shl:
      // [C99 6.5.7] Bitwise shift operators.
      return new StringRef(/*KEEP_STR*/$LT_LT);
     case BO_Shr:
      return new StringRef(/*KEEP_STR*/$GT_GT);
     case BO_LT:
      // [C99 6.5.8] Relational operators.
      return new StringRef(/*KEEP_STR*/$LT);
     case BO_GT:
      return new StringRef(/*KEEP_STR*/$GT);
     case BO_LE:
      return new StringRef(/*KEEP_STR*/$LT_EQ);
     case BO_GE:
      return new StringRef(/*KEEP_STR*/$GT_EQ);
     case BO_EQ:
      // [C99 6.5.9] Equality operators.
      return new StringRef(/*KEEP_STR*/$EQ_EQ);
     case BO_NE:
      return new StringRef(/*KEEP_STR*/$EXCLAIM_EQ);
     case BO_And:
      // [C99 6.5.10] Bitwise AND operator.
      return new StringRef(/*KEEP_STR*/$AMP);
     case BO_Xor:
      // [C99 6.5.11] Bitwise XOR operator.
      return new StringRef(/*KEEP_STR*/$CARET);
     case BO_Or:
      // [C99 6.5.12] Bitwise OR operator.
      return new StringRef(/*KEEP_STR*/$PIPE);
     case BO_LAnd:
      // [C99 6.5.13] Logical AND operator.
      return new StringRef(/*KEEP_STR*/$AMP_AMP);
     case BO_LOr:
      // [C99 6.5.14] Logical OR operator.
      return new StringRef(/*KEEP_STR*/$PIPE_PIPE);
     case BO_Assign:
      // [C99 6.5.16] Assignment operators.
      return new StringRef(/*KEEP_STR*/$EQ);
     case BO_MulAssign:
      return new StringRef(/*KEEP_STR*/$STAR_EQ);
     case BO_DivAssign:
      return new StringRef(/*KEEP_STR*/$SLASH_EQ);
     case BO_RemAssign:
      return new StringRef(/*KEEP_STR*/$PERCENT_EQ);
     case BO_AddAssign:
      return new StringRef(/*KEEP_STR*/$PLUS_EQ);
     case BO_SubAssign:
      return new StringRef(/*KEEP_STR*/$MINUS_EQ);
     case BO_ShlAssign:
      return new StringRef(/*KEEP_STR*/$LT_LT_EQ);
     case BO_ShrAssign:
      return new StringRef(/*KEEP_STR*/$GT_GT_EQ);
     case BO_AndAssign:
      return new StringRef(/*KEEP_STR*/$AMP_EQ);
     case BO_XorAssign:
      return new StringRef(/*KEEP_STR*/$CARET_EQ);
     case BO_OrAssign:
      return new StringRef(/*KEEP_STR*/$PIPE_EQ);
     case BO_Comma:
      // [C99 6.5.17] Comma operator.
      return new StringRef(/*KEEP_STR*/$COMMA);
    }
    throw new llvm_unreachable("Invalid OpCode!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::getOpcodeStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2959,
   FQN="clang::BinaryOperator::getOpcodeStr", NM="_ZNK5clang14BinaryOperator12getOpcodeStrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator12getOpcodeStrEv")
  //</editor-fold>
  public StringRef getOpcodeStr() /*const*/ {
    return getOpcodeStr(getOpcode());
  }

  
  /// \brief Retrieve the binary opcode that corresponds to the given
  /// overloaded operator.
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::getOverloadedOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1704,
   FQN="clang::BinaryOperator::getOverloadedOpcode", NM="_ZN5clang14BinaryOperator19getOverloadedOpcodeENS_22OverloadedOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator19getOverloadedOpcodeENS_22OverloadedOperatorKindE")
  //</editor-fold>
  public static BinaryOperatorKind getOverloadedOpcode(OverloadedOperatorKind OO) {
    switch (OO) {
     default:
      throw new llvm_unreachable("Not an overloadable binary operator");
     case OO_Plus:
      return BinaryOperatorKind.BO_Add;
     case OO_Minus:
      return BinaryOperatorKind.BO_Sub;
     case OO_Star:
      return BinaryOperatorKind.BO_Mul;
     case OO_Slash:
      return BinaryOperatorKind.BO_Div;
     case OO_Percent:
      return BinaryOperatorKind.BO_Rem;
     case OO_Caret:
      return BinaryOperatorKind.BO_Xor;
     case OO_Amp:
      return BinaryOperatorKind.BO_And;
     case OO_Pipe:
      return BinaryOperatorKind.BO_Or;
     case OO_Equal:
      return BinaryOperatorKind.BO_Assign;
     case OO_Less:
      return BinaryOperatorKind.BO_LT;
     case OO_Greater:
      return BinaryOperatorKind.BO_GT;
     case OO_PlusEqual:
      return BinaryOperatorKind.BO_AddAssign;
     case OO_MinusEqual:
      return BinaryOperatorKind.BO_SubAssign;
     case OO_StarEqual:
      return BinaryOperatorKind.BO_MulAssign;
     case OO_SlashEqual:
      return BinaryOperatorKind.BO_DivAssign;
     case OO_PercentEqual:
      return BinaryOperatorKind.BO_RemAssign;
     case OO_CaretEqual:
      return BinaryOperatorKind.BO_XorAssign;
     case OO_AmpEqual:
      return BinaryOperatorKind.BO_AndAssign;
     case OO_PipeEqual:
      return BinaryOperatorKind.BO_OrAssign;
     case OO_LessLess:
      return BinaryOperatorKind.BO_Shl;
     case OO_GreaterGreater:
      return BinaryOperatorKind.BO_Shr;
     case OO_LessLessEqual:
      return BinaryOperatorKind.BO_ShlAssign;
     case OO_GreaterGreaterEqual:
      return BinaryOperatorKind.BO_ShrAssign;
     case OO_EqualEqual:
      return BinaryOperatorKind.BO_EQ;
     case OO_ExclaimEqual:
      return BinaryOperatorKind.BO_NE;
     case OO_LessEqual:
      return BinaryOperatorKind.BO_LE;
     case OO_GreaterEqual:
      return BinaryOperatorKind.BO_GE;
     case OO_AmpAmp:
      return BinaryOperatorKind.BO_LAnd;
     case OO_PipePipe:
      return BinaryOperatorKind.BO_LOr;
     case OO_Comma:
      return BinaryOperatorKind.BO_Comma;
     case OO_ArrowStar:
      return BinaryOperatorKind.BO_PtrMemI;
    }
  }

  
  /// \brief Retrieve the overloaded operator kind that corresponds to
  /// the given binary opcode.
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::getOverloadedOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1742,
   FQN="clang::BinaryOperator::getOverloadedOperator", NM="_ZN5clang14BinaryOperator21getOverloadedOperatorENS_18BinaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator21getOverloadedOperatorENS_18BinaryOperatorKindE")
  //</editor-fold>
  public static OverloadedOperatorKind getOverloadedOperator(BinaryOperatorKind Opc) {
    final/*static*/ /*const*/ OverloadedOperatorKind OverOps[/*32*/] = getOverloadedOperator$$.OverOps;
    return OverOps[Opc.getValue()];
  }
  private static final class getOverloadedOperator$$ {
    static final/*static*/ /*const*/ OverloadedOperatorKind OverOps[/*32*/] = new /*const*/ OverloadedOperatorKind [/*32*/] {
      /* .* Cannot be overloaded */ OverloadedOperatorKind.OO_None, OverloadedOperatorKind.OO_ArrowStar, 
      OverloadedOperatorKind.OO_Star, OverloadedOperatorKind.OO_Slash, OverloadedOperatorKind.OO_Percent, 
      OverloadedOperatorKind.OO_Plus, OverloadedOperatorKind.OO_Minus, 
      OverloadedOperatorKind.OO_LessLess, OverloadedOperatorKind.OO_GreaterGreater, 
      OverloadedOperatorKind.OO_Less, OverloadedOperatorKind.OO_Greater, OverloadedOperatorKind.OO_LessEqual, OverloadedOperatorKind.OO_GreaterEqual, 
      OverloadedOperatorKind.OO_EqualEqual, OverloadedOperatorKind.OO_ExclaimEqual, 
      OverloadedOperatorKind.OO_Amp, 
      OverloadedOperatorKind.OO_Caret, 
      OverloadedOperatorKind.OO_Pipe, 
      OverloadedOperatorKind.OO_AmpAmp, 
      OverloadedOperatorKind.OO_PipePipe, 
      OverloadedOperatorKind.OO_Equal, OverloadedOperatorKind.OO_StarEqual, 
      OverloadedOperatorKind.OO_SlashEqual, OverloadedOperatorKind.OO_PercentEqual, 
      OverloadedOperatorKind.OO_PlusEqual, OverloadedOperatorKind.OO_MinusEqual, 
      OverloadedOperatorKind.OO_LessLessEqual, OverloadedOperatorKind.OO_GreaterGreaterEqual, 
      OverloadedOperatorKind.OO_AmpEqual, OverloadedOperatorKind.OO_CaretEqual, 
      OverloadedOperatorKind.OO_PipeEqual, 
      OverloadedOperatorKind.OO_Comma
    };
  }

  
  /// predicates to categorize the respective opcodes.
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isPtrMemOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2970,
   FQN="clang::BinaryOperator::isPtrMemOp", NM="_ZNK5clang14BinaryOperator10isPtrMemOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator10isPtrMemOpEv")
  //</editor-fold>
  public boolean isPtrMemOp() /*const*/ {
    return Opc == $int2uint_6bits(BinaryOperatorKind.BO_PtrMemD.getValue()) || Opc == $int2uint_6bits(BinaryOperatorKind.BO_PtrMemI.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isMultiplicativeOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2971,
   FQN="clang::BinaryOperator::isMultiplicativeOp", NM="_ZN5clang14BinaryOperator18isMultiplicativeOpENS_18BinaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator18isMultiplicativeOpENS_18BinaryOperatorKindE")
  //</editor-fold>
  public static boolean isMultiplicativeOp(BinaryOperatorKind Opc) {
    return Opc.getValue() >= BinaryOperatorKind.BO_Mul.getValue() && Opc.getValue() <= BinaryOperatorKind.BO_Rem.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isMultiplicativeOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2974,
   FQN="clang::BinaryOperator::isMultiplicativeOp", NM="_ZNK5clang14BinaryOperator18isMultiplicativeOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator18isMultiplicativeOpEv")
  //</editor-fold>
  public boolean isMultiplicativeOp() /*const*/ {
    return isMultiplicativeOp(getOpcode());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isAdditiveOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2975,
   FQN="clang::BinaryOperator::isAdditiveOp", NM="_ZN5clang14BinaryOperator12isAdditiveOpENS_18BinaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator12isAdditiveOpENS_18BinaryOperatorKindE")
  //</editor-fold>
  public static boolean isAdditiveOp(BinaryOperatorKind Opc) {
    return Opc == BinaryOperatorKind.BO_Add || Opc == BinaryOperatorKind.BO_Sub;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isAdditiveOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2976,
   FQN="clang::BinaryOperator::isAdditiveOp", NM="_ZNK5clang14BinaryOperator12isAdditiveOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator12isAdditiveOpEv")
  //</editor-fold>
  public boolean isAdditiveOp() /*const*/ {
    return isAdditiveOp(getOpcode());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isShiftOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2977,
   FQN="clang::BinaryOperator::isShiftOp", NM="_ZN5clang14BinaryOperator9isShiftOpENS_18BinaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator9isShiftOpENS_18BinaryOperatorKindE")
  //</editor-fold>
  public static boolean isShiftOp(BinaryOperatorKind Opc) {
    return Opc == BinaryOperatorKind.BO_Shl || Opc == BinaryOperatorKind.BO_Shr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isShiftOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2978,
   FQN="clang::BinaryOperator::isShiftOp", NM="_ZNK5clang14BinaryOperator9isShiftOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator9isShiftOpEv")
  //</editor-fold>
  public boolean isShiftOp() /*const*/ {
    return isShiftOp(getOpcode());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isBitwiseOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2980,
   FQN="clang::BinaryOperator::isBitwiseOp", NM="_ZN5clang14BinaryOperator11isBitwiseOpENS_18BinaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator11isBitwiseOpENS_18BinaryOperatorKindE")
  //</editor-fold>
  public static boolean isBitwiseOp(BinaryOperatorKind Opc) {
    return Opc.getValue() >= BinaryOperatorKind.BO_And.getValue() && Opc.getValue() <= BinaryOperatorKind.BO_Or.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isBitwiseOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2981,
   FQN="clang::BinaryOperator::isBitwiseOp", NM="_ZNK5clang14BinaryOperator11isBitwiseOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator11isBitwiseOpEv")
  //</editor-fold>
  public boolean isBitwiseOp() /*const*/ {
    return isBitwiseOp(getOpcode());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isRelationalOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2983,
   FQN="clang::BinaryOperator::isRelationalOp", NM="_ZN5clang14BinaryOperator14isRelationalOpENS_18BinaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator14isRelationalOpENS_18BinaryOperatorKindE")
  //</editor-fold>
  public static boolean isRelationalOp(BinaryOperatorKind Opc) {
    return Opc.getValue() >= BinaryOperatorKind.BO_LT.getValue() && Opc.getValue() <= BinaryOperatorKind.BO_GE.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isRelationalOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2984,
   FQN="clang::BinaryOperator::isRelationalOp", NM="_ZNK5clang14BinaryOperator14isRelationalOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator14isRelationalOpEv")
  //</editor-fold>
  public boolean isRelationalOp() /*const*/ {
    return isRelationalOp(getOpcode());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isEqualityOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2986,
   FQN="clang::BinaryOperator::isEqualityOp", NM="_ZN5clang14BinaryOperator12isEqualityOpENS_18BinaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator12isEqualityOpENS_18BinaryOperatorKindE")
  //</editor-fold>
  public static boolean isEqualityOp(BinaryOperatorKind Opc) {
    return Opc == BinaryOperatorKind.BO_EQ || Opc == BinaryOperatorKind.BO_NE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isEqualityOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2987,
   FQN="clang::BinaryOperator::isEqualityOp", NM="_ZNK5clang14BinaryOperator12isEqualityOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator12isEqualityOpEv")
  //</editor-fold>
  public boolean isEqualityOp() /*const*/ {
    return isEqualityOp(getOpcode());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isComparisonOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2989,
   FQN="clang::BinaryOperator::isComparisonOp", NM="_ZN5clang14BinaryOperator14isComparisonOpENS_18BinaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator14isComparisonOpENS_18BinaryOperatorKindE")
  //</editor-fold>
  public static boolean isComparisonOp(BinaryOperatorKind Opc) {
    return Opc.getValue() >= BinaryOperatorKind.BO_LT.getValue() && Opc.getValue() <= BinaryOperatorKind.BO_NE.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isComparisonOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2990,
   FQN="clang::BinaryOperator::isComparisonOp", NM="_ZNK5clang14BinaryOperator14isComparisonOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator14isComparisonOpEv")
  //</editor-fold>
  public boolean isComparisonOp() /*const*/ {
    return isComparisonOp(getOpcode());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::negateComparisonOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2992,
   FQN="clang::BinaryOperator::negateComparisonOp", NM="_ZN5clang14BinaryOperator18negateComparisonOpENS_18BinaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator18negateComparisonOpENS_18BinaryOperatorKindE")
  //</editor-fold>
  public static BinaryOperatorKind negateComparisonOp(BinaryOperatorKind Opc) {
    switch (Opc) {
     default:
      throw new llvm_unreachable("Not a comparsion operator.");
     case BO_LT:
      return BinaryOperatorKind.BO_GE;
     case BO_GT:
      return BinaryOperatorKind.BO_LE;
     case BO_LE:
      return BinaryOperatorKind.BO_GT;
     case BO_GE:
      return BinaryOperatorKind.BO_LT;
     case BO_EQ:
      return BinaryOperatorKind.BO_NE;
     case BO_NE:
      return BinaryOperatorKind.BO_EQ;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::reverseComparisonOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3005,
   FQN="clang::BinaryOperator::reverseComparisonOp", NM="_ZN5clang14BinaryOperator19reverseComparisonOpENS_18BinaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator19reverseComparisonOpENS_18BinaryOperatorKindE")
  //</editor-fold>
  public static BinaryOperatorKind reverseComparisonOp(BinaryOperatorKind Opc) {
    switch (Opc) {
     default:
      throw new llvm_unreachable("Not a comparsion operator.");
     case BO_LT:
      return BinaryOperatorKind.BO_GT;
     case BO_GT:
      return BinaryOperatorKind.BO_LT;
     case BO_LE:
      return BinaryOperatorKind.BO_GE;
     case BO_GE:
      return BinaryOperatorKind.BO_LE;
     case BO_EQ:
     case BO_NE:
      return Opc;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isLogicalOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3019,
   FQN="clang::BinaryOperator::isLogicalOp", NM="_ZN5clang14BinaryOperator11isLogicalOpENS_18BinaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator11isLogicalOpENS_18BinaryOperatorKindE")
  //</editor-fold>
  public static boolean isLogicalOp(BinaryOperatorKind Opc) {
    return Opc == BinaryOperatorKind.BO_LAnd || Opc == BinaryOperatorKind.BO_LOr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isLogicalOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3020,
   FQN="clang::BinaryOperator::isLogicalOp", NM="_ZNK5clang14BinaryOperator11isLogicalOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator11isLogicalOpEv")
  //</editor-fold>
  public boolean isLogicalOp() /*const*/ {
    return isLogicalOp(getOpcode());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isAssignmentOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3022,
   FQN="clang::BinaryOperator::isAssignmentOp", NM="_ZN5clang14BinaryOperator14isAssignmentOpENS_18BinaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator14isAssignmentOpENS_18BinaryOperatorKindE")
  //</editor-fold>
  public static boolean isAssignmentOp(BinaryOperatorKind Opc) {
    return Opc.getValue() >= BinaryOperatorKind.BO_Assign.getValue() && Opc.getValue() <= BinaryOperatorKind.BO_OrAssign.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isAssignmentOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3025,
   FQN="clang::BinaryOperator::isAssignmentOp", NM="_ZNK5clang14BinaryOperator14isAssignmentOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator14isAssignmentOpEv")
  //</editor-fold>
  public boolean isAssignmentOp() /*const*/ {
    return isAssignmentOp(getOpcode());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isCompoundAssignmentOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3027,
   FQN="clang::BinaryOperator::isCompoundAssignmentOp", NM="_ZN5clang14BinaryOperator22isCompoundAssignmentOpENS_18BinaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator22isCompoundAssignmentOpENS_18BinaryOperatorKindE")
  //</editor-fold>
  public static boolean isCompoundAssignmentOp(BinaryOperatorKind Opc) {
    return Opc.getValue() > BinaryOperatorKind.BO_Assign.getValue() && Opc.getValue() <= BinaryOperatorKind.BO_OrAssign.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isCompoundAssignmentOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3030,
   FQN="clang::BinaryOperator::isCompoundAssignmentOp", NM="_ZNK5clang14BinaryOperator22isCompoundAssignmentOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator22isCompoundAssignmentOpEv")
  //</editor-fold>
  public boolean isCompoundAssignmentOp() /*const*/ {
    return isCompoundAssignmentOp(getOpcode());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::getOpForCompoundAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3033,
   FQN="clang::BinaryOperator::getOpForCompoundAssignment", NM="_ZN5clang14BinaryOperator26getOpForCompoundAssignmentENS_18BinaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator26getOpForCompoundAssignmentENS_18BinaryOperatorKindE")
  //</editor-fold>
  public static BinaryOperatorKind getOpForCompoundAssignment(BinaryOperatorKind Opc) {
    assert (isCompoundAssignmentOp(Opc));
    if (Opc.getValue() >= BinaryOperatorKind.BO_AndAssign.getValue()) {
      return BinaryOperatorKind.valueOf(((/*uint*/int)(Opc.getValue())) - BinaryOperatorKind.BO_AndAssign.getValue() + BinaryOperatorKind.BO_And.getValue());
    } else {
      return BinaryOperatorKind.valueOf(((/*uint*/int)(Opc.getValue())) - BinaryOperatorKind.BO_MulAssign.getValue() + BinaryOperatorKind.BO_Mul.getValue());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isShiftAssignOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3041,
   FQN="clang::BinaryOperator::isShiftAssignOp", NM="_ZN5clang14BinaryOperator15isShiftAssignOpENS_18BinaryOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator15isShiftAssignOpENS_18BinaryOperatorKindE")
  //</editor-fold>
  public static boolean isShiftAssignOp(BinaryOperatorKind Opc) {
    return Opc == BinaryOperatorKind.BO_ShlAssign || Opc == BinaryOperatorKind.BO_ShrAssign;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isShiftAssignOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3044,
   FQN="clang::BinaryOperator::isShiftAssignOp", NM="_ZNK5clang14BinaryOperator15isShiftAssignOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator15isShiftAssignOpEv")
  //</editor-fold>
  public boolean isShiftAssignOp() /*const*/ {
    return isShiftAssignOp(getOpcode());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3048,
   FQN="clang::BinaryOperator::classof", NM="_ZN5clang14BinaryOperator7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ S) {
    return S.getStmtClass().getValue() >= StmtClass.firstBinaryOperatorConstant.getValue()
       && S.getStmtClass().getValue() <= StmtClass.lastBinaryOperatorConstant.getValue();
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3054,
   FQN="clang::BinaryOperator::children", NM="_ZN5clang14BinaryOperator8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator($AddrOf(create_type$ptr(SubExprs, 0))), new StmtIterator($AddrOf(create_type$ptr(SubExprs, 0).$add(Unnamed_enum.END_EXPR.getValue()))));
  }

  
  // Set the FP contractability status of this operator. Only meaningful for
  // operations on floating point types.
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::setFPContractable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3060,
   FQN="clang::BinaryOperator::setFPContractable", NM="_ZN5clang14BinaryOperator17setFPContractableEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperator17setFPContractableEb")
  //</editor-fold>
  public void setFPContractable(boolean FPC) {
    FPContractable = FPC;
  }

  
  // Get the FP contractability status of this operator. Only meaningful for
  // operations on floating point types.
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::isFPContractable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3064,
   FQN="clang::BinaryOperator::isFPContractable", NM="_ZNK5clang14BinaryOperator16isFPContractableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14BinaryOperator16isFPContractableEv")
  //</editor-fold>
  public boolean isFPContractable() /*const*/ {
    return FPContractable;
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::BinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3067,
   FQN="clang::BinaryOperator::BinaryOperator", NM="_ZN5clang14BinaryOperatorC1EPNS_4ExprES2_NS_18BinaryOperatorKindENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperatorC1EPNS_4ExprES2_NS_18BinaryOperatorKindENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationEbb")
  //</editor-fold>
  protected BinaryOperator(Expr /*P*/ lhs, Expr /*P*/ rhs, BinaryOperatorKind opc, QualType ResTy, 
      ExprValueKind VK, ExprObjectKind OK, 
      SourceLocation opLoc, boolean fpContractable, boolean dead2) {
    // : Expr(CompoundAssignOperatorClass, ResTy, VK, OK, lhs->isTypeDependent() || rhs->isTypeDependent(), lhs->isValueDependent() || rhs->isValueDependent(), (lhs->isInstantiationDependent() || rhs->isInstantiationDependent()), (lhs->containsUnexpandedParameterPack() || rhs->containsUnexpandedParameterPack())), Opc(opc), FPContractable(fpContractable), OpLoc(opLoc) 
    //START JInit
    super(StmtClass.CompoundAssignOperatorClass, new QualType(ResTy), VK, OK, 
        lhs.isTypeDependent() || rhs.isTypeDependent(), 
        lhs.isValueDependent() || rhs.isValueDependent(), 
        (lhs.isInstantiationDependent()
           || rhs.isInstantiationDependent()), 
        (lhs.containsUnexpandedParameterPack()
           || rhs.containsUnexpandedParameterPack()));
    this.Opc = $uint2uint_6bits(opc.getValue());
    this.FPContractable = fpContractable;
    this.OpLoc = new SourceLocation(opLoc);
    //END JInit
    SubExprs[Unnamed_enum.LHS.getValue()] = lhs;
    SubExprs[Unnamed_enum.RHS.getValue()] = rhs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryOperator::BinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3082,
   FQN="clang::BinaryOperator::BinaryOperator", NM="_ZN5clang14BinaryOperatorC1ENS_4Stmt9StmtClassENS1_10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14BinaryOperatorC1ENS_4Stmt9StmtClassENS1_10EmptyShellE")
  //</editor-fold>
  protected BinaryOperator(StmtClass SC, EmptyShell Empty) {
    // : Expr(SC, Empty), Opc(BO_MulAssign), OpLoc() 
    //START JInit
    super(SC, new EmptyShell(Empty));
    this.Opc = $uint2uint_6bits(BinaryOperatorKind.BO_MulAssign.getValue());
    this.OpLoc = new SourceLocation();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Opc=" + BinaryOperatorKind.valueOf($uchar2uint(Opc)) // NOI18N
              + ", FPContractable=" + FPContractable // NOI18N
              + ", OpLoc=" + OpLoc // NOI18N
              + ", SubExprs=" + SubExprs // NOI18N
              + super.toString(); // NOI18N
  }
}
