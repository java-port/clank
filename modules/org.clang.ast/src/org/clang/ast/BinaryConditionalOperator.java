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
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// BinaryConditionalOperator - The GNU extension to the conditional
/// operator which allows the middle operand to be omitted.
///
/// This is a different expression kind on the assumption that almost
/// every client ends up needing to know that these are different.
//<editor-fold defaultstate="collapsed" desc="clang::BinaryConditionalOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3240,
 FQN="clang::BinaryConditionalOperator", NM="_ZN5clang25BinaryConditionalOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang25BinaryConditionalOperatorE")
//</editor-fold>
public class BinaryConditionalOperator extends /*public*/ AbstractConditionalOperator {
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryConditionalOperator::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3241,
   FQN="clang::BinaryConditionalOperator::(anonymous)", NM="_ZN5clang25BinaryConditionalOperatorE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang25BinaryConditionalOperatorE_Unnamed_enum")
  //</editor-fold>
  /*friend*/public enum Unnamed_enum implements Native.ComparableLower {
    COMMON(0),
    COND(COMMON.getValue() + 1),
    LHS(COND.getValue() + 1),
    RHS(LHS.getValue() + 1),
    NUM_SUBEXPRS(RHS.getValue() + 1);

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
  
  /// - the common condition/left-hand-side expression, which will be
  ///   evaluated as the opaque value
  /// - the condition, expressed in terms of the opaque value
  /// - the left-hand-side, expressed in terms of the opaque value
  /// - the right-hand-side
  /*friend*/public Stmt /*P*/ SubExprs[/*4*/] = new Stmt /*P*/  [4];
  /*friend*/public OpaqueValueExpr /*P*/ OpaqueValue;
  
  /*friend  class ASTStmtReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryConditionalOperator::BinaryConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3253,
   FQN="clang::BinaryConditionalOperator::BinaryConditionalOperator", NM="_ZN5clang25BinaryConditionalOperatorC1EPNS_4ExprEPNS_15OpaqueValueExprES2_S2_S2_NS_14SourceLocationES5_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang25BinaryConditionalOperatorC1EPNS_4ExprEPNS_15OpaqueValueExprES2_S2_S2_NS_14SourceLocationES5_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindE")
  //</editor-fold>
  public BinaryConditionalOperator(Expr /*P*/ common, OpaqueValueExpr /*P*/ opaqueValue, 
      Expr /*P*/ cond, Expr /*P*/ lhs, Expr /*P*/ rhs, 
      SourceLocation qloc, SourceLocation cloc, 
      QualType t, ExprValueKind VK, ExprObjectKind OK) {
    // : AbstractConditionalOperator(BinaryConditionalOperatorClass, t, VK, OK, (common->isTypeDependent() || rhs->isTypeDependent()), (common->isValueDependent() || rhs->isValueDependent()), (common->isInstantiationDependent() || rhs->isInstantiationDependent()), (common->containsUnexpandedParameterPack() || rhs->containsUnexpandedParameterPack()), qloc, cloc), OpaqueValue(opaqueValue) 
    //START JInit
    super(StmtClass.BinaryConditionalOperatorClass, new QualType(t), VK, OK, 
        (common.isTypeDependent() || rhs.isTypeDependent()), 
        (common.isValueDependent() || rhs.isValueDependent()), 
        (common.isInstantiationDependent()
           || rhs.isInstantiationDependent()), 
        (common.containsUnexpandedParameterPack()
           || rhs.containsUnexpandedParameterPack()), 
        new SourceLocation(qloc), new SourceLocation(cloc));
    this.OpaqueValue = opaqueValue;
    //END JInit
    SubExprs[Unnamed_enum.COMMON.getValue()] = common;
    SubExprs[Unnamed_enum.COND.getValue()] = cond;
    SubExprs[Unnamed_enum.LHS.getValue()] = lhs;
    SubExprs[Unnamed_enum.RHS.getValue()] = rhs;
    assert (OpaqueValue.getSourceExpr() == common) : "Wrong opaque value";
  }

  
  /// \brief Build an empty conditional operator.
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryConditionalOperator::BinaryConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3274,
   FQN="clang::BinaryConditionalOperator::BinaryConditionalOperator", NM="_ZN5clang25BinaryConditionalOperatorC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang25BinaryConditionalOperatorC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ BinaryConditionalOperator(EmptyShell Empty) {
    // : AbstractConditionalOperator(BinaryConditionalOperatorClass, Empty) 
    //START JInit
    super(StmtClass.BinaryConditionalOperatorClass, new EmptyShell(Empty));
    //END JInit
  }

  
  /// \brief getCommon - Return the common expression, written to the
  ///   left of the condition.  The opaque value will be bound to the
  ///   result of this expression.
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryConditionalOperator::getCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3280,
   FQN="clang::BinaryConditionalOperator::getCommon", NM="_ZNK5clang25BinaryConditionalOperator9getCommonEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang25BinaryConditionalOperator9getCommonEv")
  //</editor-fold>
  public Expr /*P*/ getCommon() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.COMMON.getValue()]);
  }

  
  /// \brief getOpaqueValue - Return the opaque value placeholder.
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryConditionalOperator::getOpaqueValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3283,
   FQN="clang::BinaryConditionalOperator::getOpaqueValue", NM="_ZNK5clang25BinaryConditionalOperator14getOpaqueValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang25BinaryConditionalOperator14getOpaqueValueEv")
  //</editor-fold>
  public OpaqueValueExpr /*P*/ getOpaqueValue() /*const*/ {
    return OpaqueValue;
  }

  
  /// \brief getCond - Return the condition expression; this is defined
  ///   in terms of the opaque value.
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryConditionalOperator::getCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3287,
   FQN="clang::BinaryConditionalOperator::getCond", NM="_ZNK5clang25BinaryConditionalOperator7getCondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang25BinaryConditionalOperator7getCondEv")
  //</editor-fold>
  public Expr /*P*/ getCond() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.COND.getValue()]);
  }

  
  /// \brief getTrueExpr - Return the subexpression which will be
  ///   evaluated if the condition evaluates to true;  this is defined
  ///   in terms of the opaque value.
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryConditionalOperator::getTrueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3292,
   FQN="clang::BinaryConditionalOperator::getTrueExpr", NM="_ZNK5clang25BinaryConditionalOperator11getTrueExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang25BinaryConditionalOperator11getTrueExprEv")
  //</editor-fold>
  public Expr /*P*/ getTrueExpr() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.LHS.getValue()]);
  }

  
  /// \brief getFalseExpr - Return the subexpression which will be
  ///   evaluated if the condnition evaluates to false; this is
  ///   defined in terms of the opaque value.
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryConditionalOperator::getFalseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3299,
   FQN="clang::BinaryConditionalOperator::getFalseExpr", NM="_ZNK5clang25BinaryConditionalOperator12getFalseExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang25BinaryConditionalOperator12getFalseExprEv")
  //</editor-fold>
  public Expr /*P*/ getFalseExpr() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.RHS.getValue()]);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryConditionalOperator::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3303,
   FQN="clang::BinaryConditionalOperator::getLocStart", NM="_ZNK5clang25BinaryConditionalOperator11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang25BinaryConditionalOperator11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getCommon().getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BinaryConditionalOperator::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3306,
   FQN="clang::BinaryConditionalOperator::getLocEnd", NM="_ZNK5clang25BinaryConditionalOperator9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang25BinaryConditionalOperator9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getFalseExpr().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryConditionalOperator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3310,
   FQN="clang::BinaryConditionalOperator::classof", NM="_ZN5clang25BinaryConditionalOperator7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang25BinaryConditionalOperator7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.BinaryConditionalOperatorClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::BinaryConditionalOperator::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3315,
   FQN="clang::BinaryConditionalOperator::children", NM="_ZN5clang25BinaryConditionalOperator8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang25BinaryConditionalOperator8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr(SubExprs)), new StmtIterator(create_type$ptr(SubExprs).$add(Unnamed_enum.NUM_SUBEXPRS.getValue())));
  }

  
  @Override public String toString() {
    return "" + "SubExprs=" + SubExprs // NOI18N
              + ", OpaqueValue=" + OpaqueValue // NOI18N
              + super.toString(); // NOI18N
  }
}
