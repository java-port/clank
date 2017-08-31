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

/// ObjCSubscriptRefExpr - used for array and dictionary subscripting.
/// array[4] = array[3]; dictionary[key] = dictionary[alt_key];
///
//<editor-fold defaultstate="collapsed" desc="clang::ObjCSubscriptRefExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 760,
 FQN="clang::ObjCSubscriptRefExpr", NM="_ZN5clang20ObjCSubscriptRefExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang20ObjCSubscriptRefExprE")
//</editor-fold>
public class ObjCSubscriptRefExpr extends /*public*/ Expr {
  // Location of ']' in an indexing expression.
  private SourceLocation RBracket;
  // array/dictionary base expression.
  // for arrays, this is a numeric expression. For dictionaries, this is
  // an objective-c object pointer expression.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSubscriptRefExpr::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 766,
   FQN="clang::ObjCSubscriptRefExpr::(anonymous)", NM="_ZN5clang20ObjCSubscriptRefExprE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang20ObjCSubscriptRefExprE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    BASE(0),
    KEY(BASE.getValue() + 1),
    END_EXPR(KEY.getValue() + 1);

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
  
  /*friend*/public ObjCMethodDecl /*P*/ GetAtIndexMethodDecl;
  
  // For immutable objects this is null. When ObjCSubscriptRefExpr is to read
  // an indexed object this is null too.
  /*friend*/public ObjCMethodDecl /*P*/ SetAtIndexMethodDecl;
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSubscriptRefExpr::ObjCSubscriptRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 777,
   FQN="clang::ObjCSubscriptRefExpr::ObjCSubscriptRefExpr", NM="_ZN5clang20ObjCSubscriptRefExprC1EPNS_4ExprES2_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindEPNS_14ObjCMethodDeclES7_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang20ObjCSubscriptRefExprC1EPNS_4ExprES2_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindEPNS_14ObjCMethodDeclES7_NS_14SourceLocationE")
  //</editor-fold>
  public ObjCSubscriptRefExpr(Expr /*P*/ base, Expr /*P*/ key, QualType T, 
      ExprValueKind VK, ExprObjectKind OK, 
      ObjCMethodDecl /*P*/ getMethod, 
      ObjCMethodDecl /*P*/ setMethod, SourceLocation RB) {
    // : Expr(ObjCSubscriptRefExprClass, T, VK, OK, base->isTypeDependent() || key->isTypeDependent(), base->isValueDependent() || key->isValueDependent(), base->isInstantiationDependent() || key->isInstantiationDependent(), (base->containsUnexpandedParameterPack() || key->containsUnexpandedParameterPack())), RBracket(RB), GetAtIndexMethodDecl(getMethod), SetAtIndexMethodDecl(setMethod) 
    //START JInit
    super(StmtClass.ObjCSubscriptRefExprClass, new QualType(T), VK, OK, 
        base.isTypeDependent() || key.isTypeDependent(), 
        base.isValueDependent() || key.isValueDependent(), 
        base.isInstantiationDependent() || key.isInstantiationDependent(), 
        (base.containsUnexpandedParameterPack()
           || key.containsUnexpandedParameterPack()));
    this.RBracket = new SourceLocation(RB);
    this.GetAtIndexMethodDecl = getMethod;
    this.SetAtIndexMethodDecl = setMethod;
    //END JInit
    SubExprs[Unnamed_enum.BASE.getValue()] = base;
    SubExprs[Unnamed_enum.KEY.getValue()] = key;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSubscriptRefExpr::ObjCSubscriptRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 792,
   FQN="clang::ObjCSubscriptRefExpr::ObjCSubscriptRefExpr", NM="_ZN5clang20ObjCSubscriptRefExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang20ObjCSubscriptRefExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ObjCSubscriptRefExpr(EmptyShell Empty) {
    // : Expr(ObjCSubscriptRefExprClass, Empty), RBracket() 
    //START JInit
    super(StmtClass.ObjCSubscriptRefExprClass, new EmptyShell(Empty));
    this.RBracket = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSubscriptRefExpr::getRBracket">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 795,
   FQN="clang::ObjCSubscriptRefExpr::getRBracket", NM="_ZNK5clang20ObjCSubscriptRefExpr11getRBracketEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang20ObjCSubscriptRefExpr11getRBracketEv")
  //</editor-fold>
  public SourceLocation getRBracket() /*const*/ {
    return new SourceLocation(RBracket);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSubscriptRefExpr::setRBracket">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 796,
   FQN="clang::ObjCSubscriptRefExpr::setRBracket", NM="_ZN5clang20ObjCSubscriptRefExpr11setRBracketENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang20ObjCSubscriptRefExpr11setRBracketENS_14SourceLocationE")
  //</editor-fold>
  public void setRBracket(SourceLocation RB) {
    RBracket.$assign(RB);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSubscriptRefExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 798,
   FQN="clang::ObjCSubscriptRefExpr::getLocStart", NM="_ZNK5clang20ObjCSubscriptRefExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang20ObjCSubscriptRefExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return SubExprs[Unnamed_enum.BASE.getValue()].getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSubscriptRefExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 801,
   FQN="clang::ObjCSubscriptRefExpr::getLocEnd", NM="_ZNK5clang20ObjCSubscriptRefExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang20ObjCSubscriptRefExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RBracket);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSubscriptRefExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 803,
   FQN="clang::ObjCSubscriptRefExpr::classof", NM="_ZN5clang20ObjCSubscriptRefExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang20ObjCSubscriptRefExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCSubscriptRefExprClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSubscriptRefExpr::getBaseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 807,
   FQN="clang::ObjCSubscriptRefExpr::getBaseExpr", NM="_ZNK5clang20ObjCSubscriptRefExpr11getBaseExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang20ObjCSubscriptRefExpr11getBaseExprEv")
  //</editor-fold>
  public Expr /*P*/ getBaseExpr() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.BASE.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSubscriptRefExpr::setBaseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 808,
   FQN="clang::ObjCSubscriptRefExpr::setBaseExpr", NM="_ZN5clang20ObjCSubscriptRefExpr11setBaseExprEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang20ObjCSubscriptRefExpr11setBaseExprEPNS_4StmtE")
  //</editor-fold>
  public void setBaseExpr(Stmt /*P*/ S) {
    SubExprs[Unnamed_enum.BASE.getValue()] = S;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSubscriptRefExpr::getKeyExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 810,
   FQN="clang::ObjCSubscriptRefExpr::getKeyExpr", NM="_ZNK5clang20ObjCSubscriptRefExpr10getKeyExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang20ObjCSubscriptRefExpr10getKeyExprEv")
  //</editor-fold>
  public Expr /*P*/ getKeyExpr() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum.KEY.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSubscriptRefExpr::setKeyExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 811,
   FQN="clang::ObjCSubscriptRefExpr::setKeyExpr", NM="_ZN5clang20ObjCSubscriptRefExpr10setKeyExprEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang20ObjCSubscriptRefExpr10setKeyExprEPNS_4StmtE")
  //</editor-fold>
  public void setKeyExpr(Stmt /*P*/ S) {
    SubExprs[Unnamed_enum.KEY.getValue()] = S;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSubscriptRefExpr::getAtIndexMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 813,
   FQN="clang::ObjCSubscriptRefExpr::getAtIndexMethodDecl", NM="_ZNK5clang20ObjCSubscriptRefExpr20getAtIndexMethodDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang20ObjCSubscriptRefExpr20getAtIndexMethodDeclEv")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ getAtIndexMethodDecl() /*const*/ {
    return GetAtIndexMethodDecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSubscriptRefExpr::setAtIndexMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 817,
   FQN="clang::ObjCSubscriptRefExpr::setAtIndexMethodDecl", NM="_ZNK5clang20ObjCSubscriptRefExpr20setAtIndexMethodDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang20ObjCSubscriptRefExpr20setAtIndexMethodDeclEv")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ setAtIndexMethodDecl() /*const*/ {
    return SetAtIndexMethodDecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSubscriptRefExpr::isArraySubscriptRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 821,
   FQN="clang::ObjCSubscriptRefExpr::isArraySubscriptRefExpr", NM="_ZNK5clang20ObjCSubscriptRefExpr23isArraySubscriptRefExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang20ObjCSubscriptRefExpr23isArraySubscriptRefExprEv")
  //</editor-fold>
  public boolean isArraySubscriptRefExpr() /*const*/ {
    return getKeyExpr().getType().$arrow().isIntegralOrEnumerationType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSubscriptRefExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 825,
   FQN="clang::ObjCSubscriptRefExpr::children", NM="_ZN5clang20ObjCSubscriptRefExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang20ObjCSubscriptRefExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr(SubExprs)), new StmtIterator(create_type$ptr(SubExprs).$add(Unnamed_enum.END_EXPR.getValue())));
  }

/*private:*/
  /*friend  class ASTStmtReader*/
  
  @Override public String toString() {
    return "" + "RBracket=" + RBracket // NOI18N
              + ", SubExprs=" + SubExprs // NOI18N
              + ", GetAtIndexMethodDecl=" + GetAtIndexMethodDecl // NOI18N
              + ", SetAtIndexMethodDecl=" + SetAtIndexMethodDecl // NOI18N
              + super.toString(); // NOI18N
  }
}
