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

//===----------------------------------------------------------------------===//
// Postfix Operators.
//===----------------------------------------------------------------------===//

/// ArraySubscriptExpr - [C99 6.5.2.1] Array Subscripting.
//<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2063,
 FQN="clang::ArraySubscriptExpr", NM="_ZN5clang18ArraySubscriptExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18ArraySubscriptExprE")
//</editor-fold>
public class ArraySubscriptExpr extends /*public*/ Expr {
  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2064,
   FQN="clang::ArraySubscriptExpr::(anonymous)", NM="_ZN5clang18ArraySubscriptExprE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18ArraySubscriptExprE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    LHS(0),
    RHS(LHS.getValue() + 1),
    END_EXPR(2);

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
  private SourceLocation RBracketLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::ArraySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2068,
   FQN="clang::ArraySubscriptExpr::ArraySubscriptExpr", NM="_ZN5clang18ArraySubscriptExprC1EPNS_4ExprES2_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18ArraySubscriptExprC1EPNS_4ExprES2_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationE")
  //</editor-fold>
  public ArraySubscriptExpr(Expr /*P*/ lhs, Expr /*P*/ rhs, QualType t, 
      ExprValueKind VK, ExprObjectKind OK, 
      SourceLocation rbracketloc) {
    // : Expr(ArraySubscriptExprClass, t, VK, OK, lhs->isTypeDependent() || rhs->isTypeDependent(), lhs->isValueDependent() || rhs->isValueDependent(), (lhs->isInstantiationDependent() || rhs->isInstantiationDependent()), (lhs->containsUnexpandedParameterPack() || rhs->containsUnexpandedParameterPack())), RBracketLoc(rbracketloc) 
    //START JInit
    super(StmtClass.ArraySubscriptExprClass, new QualType(t), VK, OK, 
        lhs.isTypeDependent() || rhs.isTypeDependent(), 
        lhs.isValueDependent() || rhs.isValueDependent(), 
        (lhs.isInstantiationDependent()
           || rhs.isInstantiationDependent()), 
        (lhs.containsUnexpandedParameterPack()
           || rhs.containsUnexpandedParameterPack()));
    this.RBracketLoc = new SourceLocation(rbracketloc);
    //END JInit
    SubExprs[Unnamed_enum.LHS.getValue()] = lhs;
    SubExprs[Unnamed_enum.RHS.getValue()] = rhs;
  }

  
  /// \brief Create an empty array subscript expression.
  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::ArraySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2084,
   FQN="clang::ArraySubscriptExpr::ArraySubscriptExpr", NM="_ZN5clang18ArraySubscriptExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18ArraySubscriptExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ArraySubscriptExpr(EmptyShell Shell) {
    // : Expr(ArraySubscriptExprClass, Shell), RBracketLoc() 
    //START JInit
    super(StmtClass.ArraySubscriptExprClass, new EmptyShell(Shell));
    this.RBracketLoc = new SourceLocation();
    //END JInit
  }

  
  /// An array access can be written A[4] or 4[A] (both are equivalent).
  /// - getBase() and getIdx() always present the normalized view: A[4].
  ///    In this case getBase() returns "A" and getIdx() returns "4".
  /// - getLHS() and getRHS() present the syntactic view. e.g. for
  ///    4[A] getLHS() returns "4".
  /// Note: Because vector element access is also written A[4] we must
  /// predicate the format conversion in getBase and getIdx only on the
  /// the type of the RHS, as it is possible for the LHS to be a vector of
  /// integer type
  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::getLHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2096,
   FQN="clang::ArraySubscriptExpr::getLHS", NM="_ZN5clang18ArraySubscriptExpr6getLHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18ArraySubscriptExpr6getLHSEv")
  //</editor-fold>
  public Expr /*P*/ getLHS() {
    return cast_Expr(SubExprs[Unnamed_enum.LHS.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::getLHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2097,
   FQN="clang::ArraySubscriptExpr::getLHS", NM="_ZNK5clang18ArraySubscriptExpr6getLHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang18ArraySubscriptExpr6getLHSEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getLHS$Const() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.LHS.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::setLHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2098,
   FQN="clang::ArraySubscriptExpr::setLHS", NM="_ZN5clang18ArraySubscriptExpr6setLHSEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18ArraySubscriptExpr6setLHSEPNS_4ExprE")
  //</editor-fold>
  public void setLHS(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.LHS.getValue()] = E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::getRHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2100,
   FQN="clang::ArraySubscriptExpr::getRHS", NM="_ZN5clang18ArraySubscriptExpr6getRHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18ArraySubscriptExpr6getRHSEv")
  //</editor-fold>
  public Expr /*P*/ getRHS() {
    return cast_Expr(SubExprs[Unnamed_enum.RHS.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::getRHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2101,
   FQN="clang::ArraySubscriptExpr::getRHS", NM="_ZNK5clang18ArraySubscriptExpr6getRHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang18ArraySubscriptExpr6getRHSEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getRHS$Const() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.RHS.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::setRHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2102,
   FQN="clang::ArraySubscriptExpr::setRHS", NM="_ZN5clang18ArraySubscriptExpr6setRHSEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18ArraySubscriptExpr6setRHSEPNS_4ExprE")
  //</editor-fold>
  public void setRHS(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.RHS.getValue()] = E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2104,
   FQN="clang::ArraySubscriptExpr::getBase", NM="_ZN5clang18ArraySubscriptExpr7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18ArraySubscriptExpr7getBaseEv")
  //</editor-fold>
  public Expr /*P*/ getBase() {
    return cast_Expr(getRHS().getType().$arrow().isIntegerType() ? getLHS() : getRHS());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2108,
   FQN="clang::ArraySubscriptExpr::getBase", NM="_ZNK5clang18ArraySubscriptExpr7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang18ArraySubscriptExpr7getBaseEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getBase$Const() /*const*/ {
    return cast_Expr(getRHS$Const().getType().$arrow().isIntegerType() ? getLHS$Const() : getRHS$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::getIdx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2112,
   FQN="clang::ArraySubscriptExpr::getIdx", NM="_ZN5clang18ArraySubscriptExpr6getIdxEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18ArraySubscriptExpr6getIdxEv")
  //</editor-fold>
  public Expr /*P*/ getIdx() {
    return cast_Expr(getRHS().getType().$arrow().isIntegerType() ? getRHS() : getLHS());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::getIdx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2116,
   FQN="clang::ArraySubscriptExpr::getIdx", NM="_ZNK5clang18ArraySubscriptExpr6getIdxEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang18ArraySubscriptExpr6getIdxEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getIdx$Const() /*const*/ {
    return cast_Expr(getRHS$Const().getType().$arrow().isIntegerType() ? getRHS$Const() : getLHS$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2120,
   FQN="clang::ArraySubscriptExpr::getLocStart", NM="_ZNK5clang18ArraySubscriptExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang18ArraySubscriptExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getLHS$Const().getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2123,
   FQN="clang::ArraySubscriptExpr::getLocEnd", NM="_ZNK5clang18ArraySubscriptExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang18ArraySubscriptExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RBracketLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::getRBracketLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2125,
   FQN="clang::ArraySubscriptExpr::getRBracketLoc", NM="_ZNK5clang18ArraySubscriptExpr14getRBracketLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang18ArraySubscriptExpr14getRBracketLocEv")
  //</editor-fold>
  public SourceLocation getRBracketLoc() /*const*/ {
    return new SourceLocation(RBracketLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::setRBracketLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2126,
   FQN="clang::ArraySubscriptExpr::setRBracketLoc", NM="_ZN5clang18ArraySubscriptExpr14setRBracketLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18ArraySubscriptExpr14setRBracketLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRBracketLoc(SourceLocation L) {
    RBracketLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::getExprLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2128,
   FQN="clang::ArraySubscriptExpr::getExprLoc", NM="_ZNK5clang18ArraySubscriptExpr10getExprLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang18ArraySubscriptExpr10getExprLocEv")
  //</editor-fold>
  public SourceLocation getExprLoc() /*const*//* __attribute__((pure))*/ {
    return getBase$Const().getExprLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2132,
   FQN="clang::ArraySubscriptExpr::classof", NM="_ZN5clang18ArraySubscriptExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18ArraySubscriptExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ArraySubscriptExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ArraySubscriptExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2137,
   FQN="clang::ArraySubscriptExpr::children", NM="_ZN5clang18ArraySubscriptExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18ArraySubscriptExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(SubExprs)/*[0]*/)), new StmtIterator(create_type$ptr($AddrOf(SubExprs)/*[0]*/).$add(Unnamed_enum.END_EXPR.getValue())));
  }

  
  @Override public String toString() {
    return "" + "SubExprs=" + SubExprs // NOI18N
              + ", RBracketLoc=" + RBracketLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
