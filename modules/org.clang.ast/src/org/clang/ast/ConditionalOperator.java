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

/// ConditionalOperator - The ?: ternary operator.  The GNU "missing
/// middle" extension is a BinaryConditionalOperator.
//<editor-fold defaultstate="collapsed" desc="clang::ConditionalOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3170,
 FQN="clang::ConditionalOperator", NM="_ZN5clang19ConditionalOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19ConditionalOperatorE")
//</editor-fold>
public class ConditionalOperator extends /*public*/ AbstractConditionalOperator {
  //<editor-fold defaultstate="collapsed" desc="clang::ConditionalOperator::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3171,
   FQN="clang::ConditionalOperator::(anonymous)", NM="_ZN5clang19ConditionalOperatorE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19ConditionalOperatorE_Unnamed_enum")
  //</editor-fold>
  /*friend*/public enum Unnamed_enum implements Native.ComparableLower {
    COND(0),
    LHS(COND.getValue() + 1),
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
  /*friend*/public Stmt /*P*/ SubExprs[/*3*/] = new Stmt /*P*/  [3]; // Left/Middle/Right hand sides.
  
  /*friend  class ASTStmtReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ConditionalOperator::ConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3176,
   FQN="clang::ConditionalOperator::ConditionalOperator", NM="_ZN5clang19ConditionalOperatorC1EPNS_4ExprENS_14SourceLocationES2_S3_S2_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19ConditionalOperatorC1EPNS_4ExprENS_14SourceLocationES2_S3_S2_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindE")
  //</editor-fold>
  public ConditionalOperator(Expr /*P*/ cond, SourceLocation QLoc, Expr /*P*/ lhs, 
      SourceLocation CLoc, Expr /*P*/ rhs, 
      QualType t, ExprValueKind VK, ExprObjectKind OK) {
    // : AbstractConditionalOperator(ConditionalOperatorClass, t, VK, OK, (lhs->isTypeDependent() || rhs->isTypeDependent()), (cond->isValueDependent() || lhs->isValueDependent() || rhs->isValueDependent()), (cond->isInstantiationDependent() || lhs->isInstantiationDependent() || rhs->isInstantiationDependent()), (cond->containsUnexpandedParameterPack() || lhs->containsUnexpandedParameterPack() || rhs->containsUnexpandedParameterPack()), QLoc, CLoc) 
    //START JInit
    super(StmtClass.ConditionalOperatorClass, new QualType(t), VK, OK, 
        // FIXME: the type of the conditional operator doesn't
        // depend on the type of the conditional, but the standard
        // seems to imply that it could. File a bug!
        (lhs.isTypeDependent() || rhs.isTypeDependent()), 
        (cond.isValueDependent() || lhs.isValueDependent()
           || rhs.isValueDependent()), 
        (cond.isInstantiationDependent()
           || lhs.isInstantiationDependent()
           || rhs.isInstantiationDependent()), 
        (cond.containsUnexpandedParameterPack()
           || lhs.containsUnexpandedParameterPack()
           || rhs.containsUnexpandedParameterPack()), 
        new SourceLocation(QLoc), new SourceLocation(CLoc));
    //END JInit
    SubExprs[Unnamed_enum.COND.getValue()] = cond;
    SubExprs[Unnamed_enum.LHS.getValue()] = lhs;
    SubExprs[Unnamed_enum.RHS.getValue()] = rhs;
  }

  
  /// \brief Build an empty conditional operator.
  //<editor-fold defaultstate="collapsed" desc="clang::ConditionalOperator::ConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3199,
   FQN="clang::ConditionalOperator::ConditionalOperator", NM="_ZN5clang19ConditionalOperatorC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19ConditionalOperatorC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ConditionalOperator(EmptyShell Empty) {
    // : AbstractConditionalOperator(ConditionalOperatorClass, Empty) 
    //START JInit
    super(StmtClass.ConditionalOperatorClass, new EmptyShell(Empty));
    //END JInit
  }

  
  // getCond - Return the expression representing the condition for
  //   the ?: operator.
  //<editor-fold defaultstate="collapsed" desc="clang::ConditionalOperator::getCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3204,
   FQN="clang::ConditionalOperator::getCond", NM="_ZNK5clang19ConditionalOperator7getCondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19ConditionalOperator7getCondEv")
  //</editor-fold>
  public Expr /*P*/ getCond() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.COND.getValue()]);
  }

  
  // getTrueExpr - Return the subexpression representing the value of
  //   the expression if the condition evaluates to true.
  //<editor-fold defaultstate="collapsed" desc="clang::ConditionalOperator::getTrueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3208,
   FQN="clang::ConditionalOperator::getTrueExpr", NM="_ZNK5clang19ConditionalOperator11getTrueExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19ConditionalOperator11getTrueExprEv")
  //</editor-fold>
  public Expr /*P*/ getTrueExpr() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.LHS.getValue()]);
  }

  
  // getFalseExpr - Return the subexpression representing the value of
  //   the expression if the condition evaluates to false.  This is
  //   the same as getRHS.
  //<editor-fold defaultstate="collapsed" desc="clang::ConditionalOperator::getFalseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3213,
   FQN="clang::ConditionalOperator::getFalseExpr", NM="_ZNK5clang19ConditionalOperator12getFalseExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19ConditionalOperator12getFalseExprEv")
  //</editor-fold>
  public Expr /*P*/ getFalseExpr() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.RHS.getValue()]);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConditionalOperator::getLHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3215,
   FQN="clang::ConditionalOperator::getLHS", NM="_ZNK5clang19ConditionalOperator6getLHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19ConditionalOperator6getLHSEv")
  //</editor-fold>
  public Expr /*P*/ getLHS() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.LHS.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConditionalOperator::getRHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3216,
   FQN="clang::ConditionalOperator::getRHS", NM="_ZNK5clang19ConditionalOperator6getRHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19ConditionalOperator6getRHSEv")
  //</editor-fold>
  public Expr /*P*/ getRHS() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.RHS.getValue()]);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConditionalOperator::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3218,
   FQN="clang::ConditionalOperator::getLocStart", NM="_ZNK5clang19ConditionalOperator11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19ConditionalOperator11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getCond().getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConditionalOperator::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3221,
   FQN="clang::ConditionalOperator::getLocEnd", NM="_ZNK5clang19ConditionalOperator9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19ConditionalOperator9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getRHS().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConditionalOperator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3225,
   FQN="clang::ConditionalOperator::classof", NM="_ZN5clang19ConditionalOperator7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19ConditionalOperator7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ConditionalOperatorClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ConditionalOperator::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3230,
   FQN="clang::ConditionalOperator::children", NM="_ZN5clang19ConditionalOperator8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19ConditionalOperator8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator($AddrOf(create_type$ptr(SubExprs, 0))), new StmtIterator($AddrOf(create_type$ptr(SubExprs, 0).$add(Unnamed_enum.END_EXPR.getValue()))));
  }

  
  @Override public String toString() {
    return "" + "SubExprs=" + SubExprs // NOI18N
              + super.toString(); // NOI18N
  }
}
