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


/// DoStmt - This represents a 'do/while' stmt.
///
//<editor-fold defaultstate="collapsed" desc="clang::DoStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1102,
 FQN="clang::DoStmt", NM="_ZN5clang6DoStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6DoStmtE")
//</editor-fold>
public class DoStmt extends /*public*/ Stmt {
  private SourceLocation DoLoc;
  //<editor-fold defaultstate="collapsed" desc="clang::DoStmt::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1104,
   FQN="clang::DoStmt::(anonymous)", NM="_ZN5clang6DoStmtE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6DoStmtE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    BODY(0),
    COND(BODY.getValue() + 1),
    END_EXPR(COND.getValue() + 1);

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
  private SourceLocation WhileLoc;
  private SourceLocation RParenLoc; // Location of final ')' in do stmt condition.
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DoStmt::DoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1110,
   FQN="clang::DoStmt::DoStmt", NM="_ZN5clang6DoStmtC1EPNS_4StmtEPNS_4ExprENS_14SourceLocationES5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6DoStmtC1EPNS_4StmtEPNS_4ExprENS_14SourceLocationES5_S5_")
  //</editor-fold>
  public DoStmt(Stmt /*P*/ body, Expr /*P*/ cond, SourceLocation DL, SourceLocation WL, 
      SourceLocation RP) {
    // : Stmt(DoStmtClass), DoLoc(DL), WhileLoc(WL), RParenLoc(RP) 
    //START JInit
    super(StmtClass.DoStmtClass);
    this.DoLoc = new SourceLocation(DL);
    this.WhileLoc = new SourceLocation(WL);
    this.RParenLoc = new SourceLocation(RP);
    //END JInit
    SubExprs[Unnamed_enum.COND.getValue()] = reinterpret_cast(Stmt /*P*/ .class, cond);
    SubExprs[Unnamed_enum.BODY.getValue()] = body;
  }

  
  /// \brief Build an empty do-while statement.
  //<editor-fold defaultstate="collapsed" desc="clang::DoStmt::DoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1118,
   FQN="clang::DoStmt::DoStmt", NM="_ZN5clang6DoStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6DoStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ DoStmt(EmptyShell Empty) {
    // : Stmt(DoStmtClass, Empty), DoLoc(), WhileLoc(), RParenLoc() 
    //START JInit
    super(StmtClass.DoStmtClass, new EmptyShell(Empty));
    this.DoLoc = new SourceLocation();
    this.WhileLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DoStmt::getCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1120,
   FQN="clang::DoStmt::getCond", NM="_ZN5clang6DoStmt7getCondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6DoStmt7getCondEv")
  //</editor-fold>
  public Expr /*P*/ getCond() {
    return reinterpret_cast(Expr /*P*/ .class, SubExprs[Unnamed_enum.COND.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DoStmt::getCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1121,
   FQN="clang::DoStmt::getCond", NM="_ZNK5clang6DoStmt7getCondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang6DoStmt7getCondEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getCond$Const() /*const*/ {
    return reinterpret_cast(Expr /*P*/ .class, SubExprs[Unnamed_enum.COND.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DoStmt::setCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1122,
   FQN="clang::DoStmt::setCond", NM="_ZN5clang6DoStmt7setCondEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6DoStmt7setCondEPNS_4ExprE")
  //</editor-fold>
  public void setCond(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.COND.getValue()] = reinterpret_cast(Stmt /*P*/ .class, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DoStmt::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1123,
   FQN="clang::DoStmt::getBody", NM="_ZN5clang6DoStmt7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6DoStmt7getBodyEv")
  //</editor-fold>
  public Stmt /*P*/ getBody() {
    return SubExprs[Unnamed_enum.BODY.getValue()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DoStmt::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1124,
   FQN="clang::DoStmt::getBody", NM="_ZNK5clang6DoStmt7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang6DoStmt7getBodyEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getBody$Const() /*const*/ {
    return SubExprs[Unnamed_enum.BODY.getValue()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DoStmt::setBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1125,
   FQN="clang::DoStmt::setBody", NM="_ZN5clang6DoStmt7setBodyEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6DoStmt7setBodyEPNS_4StmtE")
  //</editor-fold>
  public void setBody(Stmt /*P*/ S) {
    SubExprs[Unnamed_enum.BODY.getValue()] = S;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DoStmt::getDoLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1127,
   FQN="clang::DoStmt::getDoLoc", NM="_ZNK5clang6DoStmt8getDoLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang6DoStmt8getDoLocEv")
  //</editor-fold>
  public SourceLocation getDoLoc() /*const*/ {
    return new SourceLocation(DoLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DoStmt::setDoLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1128,
   FQN="clang::DoStmt::setDoLoc", NM="_ZN5clang6DoStmt8setDoLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6DoStmt8setDoLocENS_14SourceLocationE")
  //</editor-fold>
  public void setDoLoc(SourceLocation L) {
    DoLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DoStmt::getWhileLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1129,
   FQN="clang::DoStmt::getWhileLoc", NM="_ZNK5clang6DoStmt11getWhileLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang6DoStmt11getWhileLocEv")
  //</editor-fold>
  public SourceLocation getWhileLoc() /*const*/ {
    return new SourceLocation(WhileLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DoStmt::setWhileLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1130,
   FQN="clang::DoStmt::setWhileLoc", NM="_ZN5clang6DoStmt11setWhileLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6DoStmt11setWhileLocENS_14SourceLocationE")
  //</editor-fold>
  public void setWhileLoc(SourceLocation L) {
    WhileLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DoStmt::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1132,
   FQN="clang::DoStmt::getRParenLoc", NM="_ZNK5clang6DoStmt12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang6DoStmt12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DoStmt::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1133,
   FQN="clang::DoStmt::setRParenLoc", NM="_ZN5clang6DoStmt12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6DoStmt12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation L) {
    RParenLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DoStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1135,
   FQN="clang::DoStmt::getLocStart", NM="_ZNK5clang6DoStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang6DoStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(DoLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DoStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1136,
   FQN="clang::DoStmt::getLocEnd", NM="_ZNK5clang6DoStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang6DoStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DoStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1138,
   FQN="clang::DoStmt::classof", NM="_ZN5clang6DoStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6DoStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.DoStmtClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::DoStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1143,
   FQN="clang::DoStmt::children", NM="_ZN5clang6DoStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6DoStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator($AddrOf(SubExprs)), new StmtIterator($AddrOf(SubExprs),(Unnamed_enum.END_EXPR.getValue())));
  }

  
  @Override public String toString() {
    return "" + "DoLoc=" + DoLoc // NOI18N
              + ", SubExprs=" + SubExprs // NOI18N
              + ", WhileLoc=" + WhileLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
