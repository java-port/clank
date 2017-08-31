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

/// ChooseExpr - GNU builtin-in function __builtin_choose_expr.
/// This AST node is similar to the conditional operator (?:) in C, with
/// the following exceptions:
/// - the test expression must be a integer constant expression.
/// - the expression returned acts like the chosen subexpression in every
///   visible way: the type is the same as that of the chosen subexpression,
///   and all predicates (whether it's an l-value, whether it's an integer
///   constant expression, etc.) return the same result as for the chosen
///   sub-expression.
//<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3547,
 FQN="clang::ChooseExpr", NM="_ZN5clang10ChooseExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10ChooseExprE")
//</editor-fold>
public class ChooseExpr extends /*public*/ Expr {
  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3548,
   FQN="clang::ChooseExpr::(anonymous)", NM="_ZN5clang10ChooseExprE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10ChooseExprE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
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
  private Stmt /*P*/ SubExprs[/*3*/] = new Stmt /*P*/  [3]; // Left/Middle/Right hand sides.
  private SourceLocation BuiltinLoc;
  private SourceLocation RParenLoc;
  private boolean CondIsTrue;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::ChooseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3553,
   FQN="clang::ChooseExpr::ChooseExpr", NM="_ZN5clang10ChooseExprC1ENS_14SourceLocationEPNS_4ExprES3_S3_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindES1_bbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10ChooseExprC1ENS_14SourceLocationEPNS_4ExprES3_S3_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindES1_bbb")
  //</editor-fold>
  public ChooseExpr(SourceLocation BLoc, Expr /*P*/ cond, Expr /*P*/ lhs, Expr /*P*/ rhs, 
      QualType t, ExprValueKind VK, ExprObjectKind OK, 
      SourceLocation RP, boolean condIsTrue, 
      boolean TypeDependent, boolean ValueDependent) {
    // : Expr(ChooseExprClass, t, VK, OK, TypeDependent, ValueDependent, (cond->isInstantiationDependent() || lhs->isInstantiationDependent() || rhs->isInstantiationDependent()), (cond->containsUnexpandedParameterPack() || lhs->containsUnexpandedParameterPack() || rhs->containsUnexpandedParameterPack())), BuiltinLoc(BLoc), RParenLoc(RP), CondIsTrue(condIsTrue) 
    //START JInit
    super(StmtClass.ChooseExprClass, new QualType(t), VK, OK, TypeDependent, ValueDependent, 
        (cond.isInstantiationDependent()
           || lhs.isInstantiationDependent()
           || rhs.isInstantiationDependent()), 
        (cond.containsUnexpandedParameterPack()
           || lhs.containsUnexpandedParameterPack()
           || rhs.containsUnexpandedParameterPack()));
    this.BuiltinLoc = new SourceLocation(BLoc);
    this.RParenLoc = new SourceLocation(RP);
    this.CondIsTrue = condIsTrue;
    //END JInit
    SubExprs[Unnamed_enum.COND.getValue()] = cond;
    SubExprs[Unnamed_enum.LHS.getValue()] = lhs;
    SubExprs[Unnamed_enum.RHS.getValue()] = rhs;
  }

  
  /// \brief Build an empty __builtin_choose_expr.
  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::ChooseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3571,
   FQN="clang::ChooseExpr::ChooseExpr", NM="_ZN5clang10ChooseExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10ChooseExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ChooseExpr(EmptyShell Empty) {
    // : Expr(ChooseExprClass, Empty), BuiltinLoc(), RParenLoc() 
    //START JInit
    super(StmtClass.ChooseExprClass, new EmptyShell(Empty));
    this.BuiltinLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
  }

  
  /// isConditionTrue - Return whether the condition is true (i.e. not
  /// equal to zero).
  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::isConditionTrue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3575,
   FQN="clang::ChooseExpr::isConditionTrue", NM="_ZNK5clang10ChooseExpr15isConditionTrueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10ChooseExpr15isConditionTrueEv")
  //</editor-fold>
  public boolean isConditionTrue() /*const*/ {
    assert (!isConditionDependent()) : "Dependent condition isn't true or false";
    return CondIsTrue;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::setIsConditionTrue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3580,
   FQN="clang::ChooseExpr::setIsConditionTrue", NM="_ZN5clang10ChooseExpr18setIsConditionTrueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10ChooseExpr18setIsConditionTrueEb")
  //</editor-fold>
  public void setIsConditionTrue(boolean isTrue) {
    CondIsTrue = isTrue;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::isConditionDependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3582,
   FQN="clang::ChooseExpr::isConditionDependent", NM="_ZNK5clang10ChooseExpr20isConditionDependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10ChooseExpr20isConditionDependentEv")
  //</editor-fold>
  public boolean isConditionDependent() /*const*/ {
    return getCond().isTypeDependent() || getCond().isValueDependent();
  }

  
  /// getChosenSubExpr - Return the subexpression chosen according to the
  /// condition.
  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::getChosenSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3588,
   FQN="clang::ChooseExpr::getChosenSubExpr", NM="_ZNK5clang10ChooseExpr16getChosenSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10ChooseExpr16getChosenSubExprEv")
  //</editor-fold>
  public Expr /*P*/ getChosenSubExpr() /*const*/ {
    return isConditionTrue() ? getLHS() : getRHS();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::getCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3592,
   FQN="clang::ChooseExpr::getCond", NM="_ZNK5clang10ChooseExpr7getCondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10ChooseExpr7getCondEv")
  //</editor-fold>
  public Expr /*P*/ getCond() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.COND.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::setCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3593,
   FQN="clang::ChooseExpr::setCond", NM="_ZN5clang10ChooseExpr7setCondEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10ChooseExpr7setCondEPNS_4ExprE")
  //</editor-fold>
  public void setCond(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.COND.getValue()] = E;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::getLHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3594,
   FQN="clang::ChooseExpr::getLHS", NM="_ZNK5clang10ChooseExpr6getLHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10ChooseExpr6getLHSEv")
  //</editor-fold>
  public Expr /*P*/ getLHS() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.LHS.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::setLHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3595,
   FQN="clang::ChooseExpr::setLHS", NM="_ZN5clang10ChooseExpr6setLHSEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10ChooseExpr6setLHSEPNS_4ExprE")
  //</editor-fold>
  public void setLHS(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.LHS.getValue()] = E;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::getRHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3596,
   FQN="clang::ChooseExpr::getRHS", NM="_ZNK5clang10ChooseExpr6getRHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10ChooseExpr6getRHSEv")
  //</editor-fold>
  public Expr /*P*/ getRHS() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.RHS.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::setRHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3597,
   FQN="clang::ChooseExpr::setRHS", NM="_ZN5clang10ChooseExpr6setRHSEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10ChooseExpr6setRHSEPNS_4ExprE")
  //</editor-fold>
  public void setRHS(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.RHS.getValue()] = E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::getBuiltinLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3599,
   FQN="clang::ChooseExpr::getBuiltinLoc", NM="_ZNK5clang10ChooseExpr13getBuiltinLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10ChooseExpr13getBuiltinLocEv")
  //</editor-fold>
  public SourceLocation getBuiltinLoc() /*const*/ {
    return new SourceLocation(BuiltinLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::setBuiltinLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3600,
   FQN="clang::ChooseExpr::setBuiltinLoc", NM="_ZN5clang10ChooseExpr13setBuiltinLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10ChooseExpr13setBuiltinLocENS_14SourceLocationE")
  //</editor-fold>
  public void setBuiltinLoc(SourceLocation L) {
    BuiltinLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3602,
   FQN="clang::ChooseExpr::getRParenLoc", NM="_ZNK5clang10ChooseExpr12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10ChooseExpr12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3603,
   FQN="clang::ChooseExpr::setRParenLoc", NM="_ZN5clang10ChooseExpr12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10ChooseExpr12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation L) {
    RParenLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3605,
   FQN="clang::ChooseExpr::getLocStart", NM="_ZNK5clang10ChooseExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10ChooseExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(BuiltinLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3606,
   FQN="clang::ChooseExpr::getLocEnd", NM="_ZNK5clang10ChooseExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10ChooseExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3608,
   FQN="clang::ChooseExpr::classof", NM="_ZN5clang10ChooseExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10ChooseExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ChooseExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ChooseExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3613,
   FQN="clang::ChooseExpr::children", NM="_ZN5clang10ChooseExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10ChooseExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(SubExprs)/*[0]*/)), new StmtIterator(create_type$ptr($AddrOf(SubExprs)/*[0]*/).$add(Unnamed_enum.END_EXPR.getValue())));
  }

  
  @Override public String toString() {
    return "" + "SubExprs=" + SubExprs // NOI18N
              + ", BuiltinLoc=" + BuiltinLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + ", CondIsTrue=" + CondIsTrue // NOI18N
              + super.toString(); // NOI18N
  }
}
