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

/// MS property subscript expression.
/// MSVC supports 'property' attribute and allows to apply it to the
/// declaration of an empty array in a class or structure definition.
/// For example:
/// \code
/// __declspec(property(get=GetX, put=PutX)) int x[];
/// \endcode
/// The above statement indicates that x[] can be used with one or more array
/// indices. In this case, i=p->x[a][b] will be turned into i=p->GetX(a, b), and
/// p->x[a][b] = i will be turned into p->PutX(a, b, i).
/// This is a syntactic pseudo-object expression.
//<editor-fold defaultstate="collapsed" desc="clang::MSPropertySubscriptExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 728,
 FQN="clang::MSPropertySubscriptExpr", NM="_ZN5clang23MSPropertySubscriptExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang23MSPropertySubscriptExprE")
//</editor-fold>
public class MSPropertySubscriptExpr extends /*public*/ Expr {
  /*friend  class ASTStmtReader*/
  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertySubscriptExpr::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 730,
   FQN="clang::MSPropertySubscriptExpr::(anonymous)", NM="_ZN5clang23MSPropertySubscriptExprE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang23MSPropertySubscriptExprE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    BASE_EXPR(0),
    IDX_EXPR(BASE_EXPR.getValue() + 1),
    NUM_SUBEXPRS(2);

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
  
  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertySubscriptExpr::setBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 734,
   FQN="clang::MSPropertySubscriptExpr::setBase", NM="_ZN5clang23MSPropertySubscriptExpr7setBaseEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang23MSPropertySubscriptExpr7setBaseEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setBase(Expr /*P*/ Base) {
    SubExprs[Unnamed_enum.BASE_EXPR.getValue()] = Base;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertySubscriptExpr::setIdx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 735,
   FQN="clang::MSPropertySubscriptExpr::setIdx", NM="_ZN5clang23MSPropertySubscriptExpr6setIdxEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang23MSPropertySubscriptExpr6setIdxEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setIdx(Expr /*P*/ Idx) {
    SubExprs[Unnamed_enum.IDX_EXPR.getValue()] = Idx;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertySubscriptExpr::MSPropertySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 738,
   FQN="clang::MSPropertySubscriptExpr::MSPropertySubscriptExpr", NM="_ZN5clang23MSPropertySubscriptExprC1EPNS_4ExprES2_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang23MSPropertySubscriptExprC1EPNS_4ExprES2_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationE")
  //</editor-fold>
  public MSPropertySubscriptExpr(Expr /*P*/ Base, Expr /*P*/ Idx, QualType Ty, ExprValueKind VK, 
      ExprObjectKind OK, SourceLocation RBracketLoc) {
    // : Expr(MSPropertySubscriptExprClass, Ty, VK, OK, Idx->isTypeDependent(), Idx->isValueDependent(), Idx->isInstantiationDependent(), Idx->containsUnexpandedParameterPack()), RBracketLoc(RBracketLoc) 
    //START JInit
    super(StmtClass.MSPropertySubscriptExprClass, new QualType(Ty), VK, OK, Idx.isTypeDependent(), 
        Idx.isValueDependent(), Idx.isInstantiationDependent(), 
        Idx.containsUnexpandedParameterPack());
    this.RBracketLoc = new SourceLocation(RBracketLoc);
    //END JInit
    SubExprs[Unnamed_enum.BASE_EXPR.getValue()] = Base;
    SubExprs[Unnamed_enum.IDX_EXPR.getValue()] = Idx;
  }

  
  /// \brief Create an empty array subscript expression.
  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertySubscriptExpr::MSPropertySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 749,
   FQN="clang::MSPropertySubscriptExpr::MSPropertySubscriptExpr", NM="_ZN5clang23MSPropertySubscriptExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang23MSPropertySubscriptExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ MSPropertySubscriptExpr(EmptyShell Shell) {
    // : Expr(MSPropertySubscriptExprClass, Shell), RBracketLoc() 
    //START JInit
    super(StmtClass.MSPropertySubscriptExprClass, new EmptyShell(Shell));
    this.RBracketLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertySubscriptExpr::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 752,
   FQN="clang::MSPropertySubscriptExpr::getBase", NM="_ZN5clang23MSPropertySubscriptExpr7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang23MSPropertySubscriptExpr7getBaseEv")
  //</editor-fold>
  public Expr /*P*/ getBase() {
    return cast_Expr(SubExprs[Unnamed_enum.BASE_EXPR.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertySubscriptExpr::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 753,
   FQN="clang::MSPropertySubscriptExpr::getBase", NM="_ZNK5clang23MSPropertySubscriptExpr7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23MSPropertySubscriptExpr7getBaseEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getBase$Const() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.BASE_EXPR.getValue()]);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertySubscriptExpr::getIdx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 755,
   FQN="clang::MSPropertySubscriptExpr::getIdx", NM="_ZN5clang23MSPropertySubscriptExpr6getIdxEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang23MSPropertySubscriptExpr6getIdxEv")
  //</editor-fold>
  public Expr /*P*/ getIdx() {
    return cast_Expr(SubExprs[Unnamed_enum.IDX_EXPR.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertySubscriptExpr::getIdx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 756,
   FQN="clang::MSPropertySubscriptExpr::getIdx", NM="_ZNK5clang23MSPropertySubscriptExpr6getIdxEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23MSPropertySubscriptExpr6getIdxEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getIdx$Const() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.IDX_EXPR.getValue()]);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertySubscriptExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 758,
   FQN="clang::MSPropertySubscriptExpr::getLocStart", NM="_ZNK5clang23MSPropertySubscriptExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23MSPropertySubscriptExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getBase$Const().getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertySubscriptExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 761,
   FQN="clang::MSPropertySubscriptExpr::getLocEnd", NM="_ZNK5clang23MSPropertySubscriptExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23MSPropertySubscriptExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RBracketLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertySubscriptExpr::getRBracketLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 763,
   FQN="clang::MSPropertySubscriptExpr::getRBracketLoc", NM="_ZNK5clang23MSPropertySubscriptExpr14getRBracketLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23MSPropertySubscriptExpr14getRBracketLocEv")
  //</editor-fold>
  public SourceLocation getRBracketLoc() /*const*/ {
    return new SourceLocation(RBracketLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertySubscriptExpr::setRBracketLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 764,
   FQN="clang::MSPropertySubscriptExpr::setRBracketLoc", NM="_ZN5clang23MSPropertySubscriptExpr14setRBracketLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang23MSPropertySubscriptExpr14setRBracketLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRBracketLoc(SourceLocation L) {
    RBracketLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertySubscriptExpr::getExprLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 766,
   FQN="clang::MSPropertySubscriptExpr::getExprLoc", NM="_ZNK5clang23MSPropertySubscriptExpr10getExprLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang23MSPropertySubscriptExpr10getExprLocEv")
  //</editor-fold>
  public SourceLocation getExprLoc() /*const*//* __attribute__((pure))*/ {
    return getBase$Const().getExprLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertySubscriptExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 770,
   FQN="clang::MSPropertySubscriptExpr::classof", NM="_ZN5clang23MSPropertySubscriptExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang23MSPropertySubscriptExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.MSPropertySubscriptExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertySubscriptExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 775,
   FQN="clang::MSPropertySubscriptExpr::children", NM="_ZN5clang23MSPropertySubscriptExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang23MSPropertySubscriptExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(SubExprs)/*[0]*/)), new StmtIterator(create_type$ptr($AddrOf(SubExprs)/*[0]*/).$add(Unnamed_enum.NUM_SUBEXPRS.getValue())));
  }

  
  @Override public String toString() {
    return "" + "SubExprs=" + SubExprs // NOI18N
              + ", RBracketLoc=" + RBracketLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
