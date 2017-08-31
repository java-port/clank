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
import static org.clank.support.Casts.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief Represents Objective-C's collection statement.
///
/// This is represented as 'for (element 'in' collection-expression)' stmt.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 24,
 FQN="clang::ObjCForCollectionStmt", NM="_ZN5clang21ObjCForCollectionStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang21ObjCForCollectionStmtE")
//</editor-fold>
public class ObjCForCollectionStmt extends /*public*/ Stmt {
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 25,
   FQN="clang::ObjCForCollectionStmt::(anonymous)", NM="_ZN5clang21ObjCForCollectionStmtE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang21ObjCForCollectionStmtE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    ELEM(0),
    COLLECTION(ELEM.getValue() + 1),
    BODY(COLLECTION.getValue() + 1),
    END_EXPR(BODY.getValue() + 1);

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
  private Stmt /*P*/ SubExprs[/*3*/] = new Stmt /*P*/  [3]; // SubExprs[ELEM] is an expression or declstmt.
  private SourceLocation ForLoc;
  private SourceLocation RParenLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::ObjCForCollectionStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp", line = 21,
   FQN="clang::ObjCForCollectionStmt::ObjCForCollectionStmt", NM="_ZN5clang21ObjCForCollectionStmtC1EPNS_4StmtEPNS_4ExprES2_NS_14SourceLocationES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang21ObjCForCollectionStmtC1EPNS_4StmtEPNS_4ExprES2_NS_14SourceLocationES5_")
  //</editor-fold>
  public ObjCForCollectionStmt(Stmt /*P*/ Elem, Expr /*P*/ Collect, 
      Stmt /*P*/ Body, SourceLocation FCL, 
      SourceLocation RPL) {
    // : Stmt(ObjCForCollectionStmtClass), ForLoc(), RParenLoc() 
    //START JInit
    super(StmtClass.ObjCForCollectionStmtClass);
    this.ForLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
    SubExprs[Unnamed_enum.ELEM.getValue()] = Elem;
    SubExprs[Unnamed_enum.COLLECTION.getValue()] = Collect;
    SubExprs[Unnamed_enum.BODY.getValue()] = Body;
    ForLoc.$assign(FCL);
    RParenLoc.$assign(RPL);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::ObjCForCollectionStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 32,
   FQN="clang::ObjCForCollectionStmt::ObjCForCollectionStmt", NM="_ZN5clang21ObjCForCollectionStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang21ObjCForCollectionStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ObjCForCollectionStmt(EmptyShell Empty) {
    // : Stmt(ObjCForCollectionStmtClass, Empty), ForLoc(), RParenLoc() 
    //START JInit
    super(StmtClass.ObjCForCollectionStmtClass, new EmptyShell(Empty));
    this.ForLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::getElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 35,
   FQN="clang::ObjCForCollectionStmt::getElement", NM="_ZN5clang21ObjCForCollectionStmt10getElementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang21ObjCForCollectionStmt10getElementEv")
  //</editor-fold>
  public Stmt /*P*/ getElement() {
    return SubExprs[Unnamed_enum.ELEM.getValue()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::getCollection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 36,
   FQN="clang::ObjCForCollectionStmt::getCollection", NM="_ZN5clang21ObjCForCollectionStmt13getCollectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang21ObjCForCollectionStmt13getCollectionEv")
  //</editor-fold>
  public Expr /*P*/ getCollection() {
    return reinterpret_cast(Expr /*P*/ .class, SubExprs[Unnamed_enum.COLLECTION.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 39,
   FQN="clang::ObjCForCollectionStmt::getBody", NM="_ZN5clang21ObjCForCollectionStmt7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang21ObjCForCollectionStmt7getBodyEv")
  //</editor-fold>
  public Stmt /*P*/ getBody() {
    return SubExprs[Unnamed_enum.BODY.getValue()];
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::getElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 41,
   FQN="clang::ObjCForCollectionStmt::getElement", NM="_ZNK5clang21ObjCForCollectionStmt10getElementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang21ObjCForCollectionStmt10getElementEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getElement$Const() /*const*/ {
    return SubExprs[Unnamed_enum.ELEM.getValue()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::getCollection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 42,
   FQN="clang::ObjCForCollectionStmt::getCollection", NM="_ZNK5clang21ObjCForCollectionStmt13getCollectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang21ObjCForCollectionStmt13getCollectionEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getCollection$Const() /*const*/ {
    return reinterpret_cast(Expr /*P*/ .class, SubExprs[Unnamed_enum.COLLECTION.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 45,
   FQN="clang::ObjCForCollectionStmt::getBody", NM="_ZNK5clang21ObjCForCollectionStmt7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang21ObjCForCollectionStmt7getBodyEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getBody$Const() /*const*/ {
    return SubExprs[Unnamed_enum.BODY.getValue()];
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::setElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 47,
   FQN="clang::ObjCForCollectionStmt::setElement", NM="_ZN5clang21ObjCForCollectionStmt10setElementEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang21ObjCForCollectionStmt10setElementEPNS_4StmtE")
  //</editor-fold>
  public void setElement(Stmt /*P*/ S) {
    SubExprs[Unnamed_enum.ELEM.getValue()] = S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::setCollection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 48,
   FQN="clang::ObjCForCollectionStmt::setCollection", NM="_ZN5clang21ObjCForCollectionStmt13setCollectionEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang21ObjCForCollectionStmt13setCollectionEPNS_4ExprE")
  //</editor-fold>
  public void setCollection(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.COLLECTION.getValue()] = reinterpret_cast(Stmt /*P*/ .class, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::setBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 51,
   FQN="clang::ObjCForCollectionStmt::setBody", NM="_ZN5clang21ObjCForCollectionStmt7setBodyEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang21ObjCForCollectionStmt7setBodyEPNS_4StmtE")
  //</editor-fold>
  public void setBody(Stmt /*P*/ S) {
    SubExprs[Unnamed_enum.BODY.getValue()] = S;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::getForLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 53,
   FQN="clang::ObjCForCollectionStmt::getForLoc", NM="_ZNK5clang21ObjCForCollectionStmt9getForLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang21ObjCForCollectionStmt9getForLocEv")
  //</editor-fold>
  public SourceLocation getForLoc() /*const*/ {
    return new SourceLocation(ForLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::setForLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 54,
   FQN="clang::ObjCForCollectionStmt::setForLoc", NM="_ZN5clang21ObjCForCollectionStmt9setForLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang21ObjCForCollectionStmt9setForLocENS_14SourceLocationE")
  //</editor-fold>
  public void setForLoc(SourceLocation Loc) {
    ForLoc.$assign(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 55,
   FQN="clang::ObjCForCollectionStmt::getRParenLoc", NM="_ZNK5clang21ObjCForCollectionStmt12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang21ObjCForCollectionStmt12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 56,
   FQN="clang::ObjCForCollectionStmt::setRParenLoc", NM="_ZN5clang21ObjCForCollectionStmt12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang21ObjCForCollectionStmt12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation Loc) {
    RParenLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 58,
   FQN="clang::ObjCForCollectionStmt::getLocStart", NM="_ZNK5clang21ObjCForCollectionStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang21ObjCForCollectionStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(ForLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 59,
   FQN="clang::ObjCForCollectionStmt::getLocEnd", NM="_ZNK5clang21ObjCForCollectionStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang21ObjCForCollectionStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return SubExprs[Unnamed_enum.BODY.getValue()].getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 63,
   FQN="clang::ObjCForCollectionStmt::classof", NM="_ZN5clang21ObjCForCollectionStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang21ObjCForCollectionStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCForCollectionStmtClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCForCollectionStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 68,
   FQN="clang::ObjCForCollectionStmt::children", NM="_ZN5clang21ObjCForCollectionStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang21ObjCForCollectionStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator($AddrOf(SubExprs)), new StmtIterator($AddrOf(SubExprs),Unnamed_enum.END_EXPR.getValue()));
  }

  
  @Override public String toString() {
    return "" + "SubExprs=" + SubExprs // NOI18N
              + ", ForLoc=" + ForLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
