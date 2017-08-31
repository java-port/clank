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
import static org.clang.ast.java.AstStatementsRTTI.*;
//<editor-fold defaultstate="collapsed" desc="clang::CaseStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 689,
 FQN="clang::CaseStmt", NM="_ZN5clang8CaseStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8CaseStmtE")
//</editor-fold>
public class CaseStmt extends /*public*/ SwitchCase {
  private SourceLocation EllipsisLoc;
  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 691,
   FQN="clang::CaseStmt::(anonymous)", NM="_ZN5clang8CaseStmtE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8CaseStmtE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    LHS(0),
    RHS(LHS.getValue() + 1),
    SUBSTMT(RHS.getValue() + 1),
    END_EXPR(SUBSTMT.getValue() + 1);

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
  private Stmt /*P*/ SubExprs[/*3*/] = new Stmt /*P*/  [3]; // The expression for the RHS is Non-null for
  // GNU "case 1 ... 4" extension
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::CaseStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 695,
   FQN="clang::CaseStmt::CaseStmt", NM="_ZN5clang8CaseStmtC1EPNS_4ExprES2_NS_14SourceLocationES3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8CaseStmtC1EPNS_4ExprES2_NS_14SourceLocationES3_S3_")
  //</editor-fold>
  public CaseStmt(Expr /*P*/ lhs, Expr /*P*/ rhs, SourceLocation caseLoc, 
      SourceLocation ellipsisLoc, SourceLocation colonLoc) {
    // : SwitchCase(CaseStmtClass, caseLoc, colonLoc), EllipsisLoc() 
    //START JInit
    super(StmtClass.CaseStmtClass, new SourceLocation(caseLoc), new SourceLocation(colonLoc));
    this.EllipsisLoc = new SourceLocation();
    //END JInit
    SubExprs[Unnamed_enum.SUBSTMT.getValue()] = null;
    SubExprs[Unnamed_enum.LHS.getValue()] = reinterpret_cast(Stmt /*P*/ .class, lhs);
    SubExprs[Unnamed_enum.RHS.getValue()] = reinterpret_cast(Stmt /*P*/ .class, rhs);
    EllipsisLoc.$assign(ellipsisLoc);
  }

  
  /// \brief Build an empty switch case statement.
  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::CaseStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 705,
   FQN="clang::CaseStmt::CaseStmt", NM="_ZN5clang8CaseStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8CaseStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ CaseStmt(EmptyShell Empty) {
    // : SwitchCase(CaseStmtClass, Empty), EllipsisLoc() 
    //START JInit
    super(StmtClass.CaseStmtClass, new EmptyShell(Empty));
    this.EllipsisLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::getCaseLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 707,
   FQN="clang::CaseStmt::getCaseLoc", NM="_ZNK5clang8CaseStmt10getCaseLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8CaseStmt10getCaseLocEv")
  //</editor-fold>
  public SourceLocation getCaseLoc() /*const*/ {
    return new SourceLocation(KeywordLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::setCaseLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 708,
   FQN="clang::CaseStmt::setCaseLoc", NM="_ZN5clang8CaseStmt10setCaseLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8CaseStmt10setCaseLocENS_14SourceLocationE")
  //</editor-fold>
  public void setCaseLoc(SourceLocation L) {
    KeywordLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::getEllipsisLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 709,
   FQN="clang::CaseStmt::getEllipsisLoc", NM="_ZNK5clang8CaseStmt14getEllipsisLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8CaseStmt14getEllipsisLocEv")
  //</editor-fold>
  public SourceLocation getEllipsisLoc() /*const*/ {
    return new SourceLocation(EllipsisLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::setEllipsisLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 710,
   FQN="clang::CaseStmt::setEllipsisLoc", NM="_ZN5clang8CaseStmt14setEllipsisLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8CaseStmt14setEllipsisLocENS_14SourceLocationE")
  //</editor-fold>
  public void setEllipsisLoc(SourceLocation L) {
    EllipsisLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::getColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 711,
   FQN="clang::CaseStmt::getColonLoc", NM="_ZNK5clang8CaseStmt11getColonLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8CaseStmt11getColonLocEv")
  //</editor-fold>
  public SourceLocation getColonLoc() /*const*/ {
    return new SourceLocation(ColonLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::setColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 712,
   FQN="clang::CaseStmt::setColonLoc", NM="_ZN5clang8CaseStmt11setColonLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8CaseStmt11setColonLocENS_14SourceLocationE")
  //</editor-fold>
  public void setColonLoc(SourceLocation L) {
    ColonLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::getLHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 714,
   FQN="clang::CaseStmt::getLHS", NM="_ZN5clang8CaseStmt6getLHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8CaseStmt6getLHSEv")
  //</editor-fold>
  public Expr /*P*/ getLHS() {
    return reinterpret_cast(Expr /*P*/ .class, SubExprs[Unnamed_enum.LHS.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::getRHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 715,
   FQN="clang::CaseStmt::getRHS", NM="_ZN5clang8CaseStmt6getRHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8CaseStmt6getRHSEv")
  //</editor-fold>
  public Expr /*P*/ getRHS() {
    return reinterpret_cast(Expr /*P*/ .class, SubExprs[Unnamed_enum.RHS.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::getSubStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 716,
   FQN="clang::CaseStmt::getSubStmt", NM="_ZN5clang8CaseStmt10getSubStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8CaseStmt10getSubStmtEv")
  //</editor-fold>
  public Stmt /*P*/ getSubStmt() {
    return SubExprs[Unnamed_enum.SUBSTMT.getValue()];
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::getLHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 718,
   FQN="clang::CaseStmt::getLHS", NM="_ZNK5clang8CaseStmt6getLHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8CaseStmt6getLHSEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getLHS$Const() /*const*/ {
    return reinterpret_cast(/*const*/ Expr /*P*/ .class, SubExprs[Unnamed_enum.LHS.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::getRHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 721,
   FQN="clang::CaseStmt::getRHS", NM="_ZNK5clang8CaseStmt6getRHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8CaseStmt6getRHSEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getRHS$Const() /*const*/ {
    return reinterpret_cast(/*const*/ Expr /*P*/ .class, SubExprs[Unnamed_enum.RHS.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::getSubStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 724,
   FQN="clang::CaseStmt::getSubStmt", NM="_ZNK5clang8CaseStmt10getSubStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8CaseStmt10getSubStmtEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getSubStmt$Const() /*const*/ {
    return SubExprs[Unnamed_enum.SUBSTMT.getValue()];
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::setSubStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 726,
   FQN="clang::CaseStmt::setSubStmt", NM="_ZN5clang8CaseStmt10setSubStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8CaseStmt10setSubStmtEPNS_4StmtE")
  //</editor-fold>
  public void setSubStmt(Stmt /*P*/ S) {
    SubExprs[Unnamed_enum.SUBSTMT.getValue()] = S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::setLHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 727,
   FQN="clang::CaseStmt::setLHS", NM="_ZN5clang8CaseStmt6setLHSEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8CaseStmt6setLHSEPNS_4ExprE")
  //</editor-fold>
  public void setLHS(Expr /*P*/ Val) {
    SubExprs[Unnamed_enum.LHS.getValue()] = reinterpret_cast(Stmt /*P*/ .class, Val);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::setRHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 728,
   FQN="clang::CaseStmt::setRHS", NM="_ZN5clang8CaseStmt6setRHSEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8CaseStmt6setRHSEPNS_4ExprE")
  //</editor-fold>
  public void setRHS(Expr /*P*/ Val) {
    SubExprs[Unnamed_enum.RHS.getValue()] = reinterpret_cast(Stmt /*P*/ .class, Val);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 730,
   FQN="clang::CaseStmt::getLocStart", NM="_ZNK5clang8CaseStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8CaseStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(KeywordLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 731,
   FQN="clang::CaseStmt::getLocEnd", NM="_ZNK5clang8CaseStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8CaseStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    // Handle deeply nested case statements with iteration instead of recursion.
    /*const*/ CaseStmt /*P*/ CS = this;
    {
      /*const*/ CaseStmt /*P*/ CS2;
      while (((/*P*/ CS2 = dyn_cast_CaseStmt(CS.getSubStmt$Const())) != null)) {
        CS = CS2;
      }
    }
    
    return CS.getSubStmt$Const().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 740,
   FQN="clang::CaseStmt::classof", NM="_ZN5clang8CaseStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8CaseStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CaseStmtClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CaseStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 745,
   FQN="clang::CaseStmt::children", NM="_ZN5clang8CaseStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8CaseStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator($AddrOf(SubExprs)), new StmtIterator($AddrOf(SubExprs),Unnamed_enum.END_EXPR.getValue()));
  }

  
  @Override public String toString() {
    return "" + "EllipsisLoc=" + EllipsisLoc // NOI18N
              + ", SubExprs=" + SubExprs // NOI18N
              + super.toString(); // NOI18N
  }
}
