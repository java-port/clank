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
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;

/// CXXForRangeStmt - This represents C++0x [stmt.ranged]'s ranged for
/// statement, represented as 'for (range-declarator : range-expression)'.
///
/// This is stored in a partially-desugared form to allow full semantic
/// analysis of the constituent components. The original syntactic components
/// can be extracted using getLoopVariable and getRangeInit.
//<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 128,
 FQN="clang::CXXForRangeStmt", NM="_ZN5clang15CXXForRangeStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmtE")
//</editor-fold>
public class CXXForRangeStmt extends /*public*/ Stmt {
  /*friend*/public SourceLocation ForLoc;
  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 130,
   FQN="clang::CXXForRangeStmt::(anonymous)", NM="_ZN5clang15CXXForRangeStmtE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmtE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    RANGE(0),
    BEGINSTMT(RANGE.getValue() + 1),
    ENDSTMT(BEGINSTMT.getValue() + 1),
    COND(ENDSTMT.getValue() + 1),
    INC(COND.getValue() + 1),
    LOOPVAR(INC.getValue() + 1),
    BODY(LOOPVAR.getValue() + 1),
    END(BODY.getValue() + 1);

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
  // SubExprs[RANGE] is an expression or declstmt.
  // SubExprs[COND] and SubExprs[INC] are expressions.
  private Stmt /*P*/ SubExprs[/*7*/] = new Stmt /*P*/  [7];
  /*friend*/public SourceLocation CoawaitLoc;
  /*friend*/public SourceLocation ColonLoc;
  /*friend*/public SourceLocation RParenLoc;
  
  /*friend  class ASTStmtReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::CXXForRangeStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp", line = 52,
   FQN="clang::CXXForRangeStmt::CXXForRangeStmt", NM="_ZN5clang15CXXForRangeStmtC1EPNS_8DeclStmtES2_S2_PNS_4ExprES4_S2_PNS_4StmtENS_14SourceLocationES7_S7_S7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmtC1EPNS_8DeclStmtES2_S2_PNS_4ExprES4_S2_PNS_4StmtENS_14SourceLocationES7_S7_S7_")
  //</editor-fold>
  public CXXForRangeStmt(DeclStmt /*P*/ Range, 
      DeclStmt /*P*/ BeginStmt, DeclStmt /*P*/ EndStmt, 
      Expr /*P*/ Cond, Expr /*P*/ Inc, DeclStmt /*P*/ LoopVar, 
      Stmt /*P*/ Body, SourceLocation FL, 
      SourceLocation CAL, SourceLocation CL, 
      SourceLocation RPL) {
    // : Stmt(CXXForRangeStmtClass), ForLoc(FL), CoawaitLoc(CAL), ColonLoc(CL), RParenLoc(RPL) 
    //START JInit
    super(StmtClass.CXXForRangeStmtClass);
    this.ForLoc = new SourceLocation(FL);
    this.CoawaitLoc = new SourceLocation(CAL);
    this.ColonLoc = new SourceLocation(CL);
    this.RParenLoc = new SourceLocation(RPL);
    //END JInit
    SubExprs[Unnamed_enum.RANGE.getValue()] = Range;
    SubExprs[Unnamed_enum.BEGINSTMT.getValue()] = BeginStmt;
    SubExprs[Unnamed_enum.ENDSTMT.getValue()] = EndStmt;
    SubExprs[Unnamed_enum.COND.getValue()] = Cond;
    SubExprs[Unnamed_enum.INC.getValue()] = Inc;
    SubExprs[Unnamed_enum.LOOPVAR.getValue()] = LoopVar;
    SubExprs[Unnamed_enum.BODY.getValue()] = Body;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::CXXForRangeStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 144,
   FQN="clang::CXXForRangeStmt::CXXForRangeStmt", NM="_ZN5clang15CXXForRangeStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public CXXForRangeStmt(EmptyShell Empty) {
    // : Stmt(CXXForRangeStmtClass, Empty), ForLoc(), CoawaitLoc(), ColonLoc(), RParenLoc() 
    //START JInit
    super(StmtClass.CXXForRangeStmtClass, new EmptyShell(Empty));
    this.ForLoc = new SourceLocation();
    this.CoawaitLoc = new SourceLocation();
    this.ColonLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getLoopVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp", line = 80,
   FQN="clang::CXXForRangeStmt::getLoopVariable", NM="_ZN5clang15CXXForRangeStmt15getLoopVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmt15getLoopVariableEv")
  //</editor-fold>
  public VarDecl /*P*/ getLoopVariable() {
    Decl /*P*/ LV = cast_DeclStmt(getLoopVarStmt()).getSingleDecl();
    assert ((LV != null)) : "No loop variable in CXXForRangeStmt";
    return cast_VarDecl(LV);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getRangeInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp", line = 69,
   FQN="clang::CXXForRangeStmt::getRangeInit", NM="_ZN5clang15CXXForRangeStmt12getRangeInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmt12getRangeInitEv")
  //</editor-fold>
  public Expr /*P*/ getRangeInit() {
    DeclStmt /*P*/ RangeStmt = getRangeStmt();
    VarDecl /*P*/ RangeDecl = dyn_cast_or_null_VarDecl(RangeStmt.getSingleDecl());
    assert ((RangeDecl != null)) : "for-range should have a single var decl";
    return RangeDecl.getInit();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getLoopVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp", line = 86,
   FQN="clang::CXXForRangeStmt::getLoopVariable", NM="_ZNK5clang15CXXForRangeStmt15getLoopVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang15CXXForRangeStmt15getLoopVariableEv")
  //</editor-fold>
  public /*const*/ VarDecl /*P*/ getLoopVariable$Const() /*const*/ {
    return ((/*const_cast*/CXXForRangeStmt /*P*/ )(this)).getLoopVariable();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getRangeInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp", line = 76,
   FQN="clang::CXXForRangeStmt::getRangeInit", NM="_ZNK5clang15CXXForRangeStmt12getRangeInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang15CXXForRangeStmt12getRangeInitEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getRangeInit$Const() /*const*/ {
    return ((/*const_cast*/CXXForRangeStmt /*P*/ )(this)).getRangeInit();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getRangeStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 154,
   FQN="clang::CXXForRangeStmt::getRangeStmt", NM="_ZN5clang15CXXForRangeStmt12getRangeStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmt12getRangeStmtEv")
  //</editor-fold>
  public DeclStmt /*P*/ getRangeStmt() {
    return cast_DeclStmt(SubExprs[Unnamed_enum.RANGE.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getBeginStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 155,
   FQN="clang::CXXForRangeStmt::getBeginStmt", NM="_ZN5clang15CXXForRangeStmt12getBeginStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmt12getBeginStmtEv")
  //</editor-fold>
  public DeclStmt /*P*/ getBeginStmt() {
    return cast_or_null_DeclStmt(SubExprs[Unnamed_enum.BEGINSTMT.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getEndStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 158,
   FQN="clang::CXXForRangeStmt::getEndStmt", NM="_ZN5clang15CXXForRangeStmt10getEndStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmt10getEndStmtEv")
  //</editor-fold>
  public DeclStmt /*P*/ getEndStmt() {
    return cast_or_null_DeclStmt(SubExprs[Unnamed_enum.ENDSTMT.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 159,
   FQN="clang::CXXForRangeStmt::getCond", NM="_ZN5clang15CXXForRangeStmt7getCondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmt7getCondEv")
  //</editor-fold>
  public Expr /*P*/ getCond() {
    return cast_or_null_Expr(SubExprs[Unnamed_enum.COND.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getInc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 160,
   FQN="clang::CXXForRangeStmt::getInc", NM="_ZN5clang15CXXForRangeStmt6getIncEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmt6getIncEv")
  //</editor-fold>
  public Expr /*P*/ getInc() {
    return cast_or_null_Expr(SubExprs[Unnamed_enum.INC.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getLoopVarStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 161,
   FQN="clang::CXXForRangeStmt::getLoopVarStmt", NM="_ZN5clang15CXXForRangeStmt14getLoopVarStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmt14getLoopVarStmtEv")
  //</editor-fold>
  public DeclStmt /*P*/ getLoopVarStmt() {
    return cast_DeclStmt(SubExprs[Unnamed_enum.LOOPVAR.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 162,
   FQN="clang::CXXForRangeStmt::getBody", NM="_ZN5clang15CXXForRangeStmt7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmt7getBodyEv")
  //</editor-fold>
  public Stmt /*P*/ getBody() {
    return SubExprs[Unnamed_enum.BODY.getValue()];
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getRangeStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 164,
   FQN="clang::CXXForRangeStmt::getRangeStmt", NM="_ZNK5clang15CXXForRangeStmt12getRangeStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang15CXXForRangeStmt12getRangeStmtEv")
  //</editor-fold>
  public /*const*/ DeclStmt /*P*/ getRangeStmt$Const() /*const*/ {
    return cast_DeclStmt(SubExprs[Unnamed_enum.RANGE.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getBeginStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 167,
   FQN="clang::CXXForRangeStmt::getBeginStmt", NM="_ZNK5clang15CXXForRangeStmt12getBeginStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang15CXXForRangeStmt12getBeginStmtEv")
  //</editor-fold>
  public /*const*/ DeclStmt /*P*/ getBeginStmt$Const() /*const*/ {
    return cast_or_null_DeclStmt(SubExprs[Unnamed_enum.BEGINSTMT.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getEndStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 170,
   FQN="clang::CXXForRangeStmt::getEndStmt", NM="_ZNK5clang15CXXForRangeStmt10getEndStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang15CXXForRangeStmt10getEndStmtEv")
  //</editor-fold>
  public /*const*/ DeclStmt /*P*/ getEndStmt$Const() /*const*/ {
    return cast_or_null_DeclStmt(SubExprs[Unnamed_enum.ENDSTMT.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 173,
   FQN="clang::CXXForRangeStmt::getCond", NM="_ZNK5clang15CXXForRangeStmt7getCondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang15CXXForRangeStmt7getCondEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getCond$Const() /*const*/ {
    return cast_or_null_Expr(SubExprs[Unnamed_enum.COND.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getInc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 176,
   FQN="clang::CXXForRangeStmt::getInc", NM="_ZNK5clang15CXXForRangeStmt6getIncEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang15CXXForRangeStmt6getIncEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getInc$Const() /*const*/ {
    return cast_or_null_Expr(SubExprs[Unnamed_enum.INC.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getLoopVarStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 179,
   FQN="clang::CXXForRangeStmt::getLoopVarStmt", NM="_ZNK5clang15CXXForRangeStmt14getLoopVarStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang15CXXForRangeStmt14getLoopVarStmtEv")
  //</editor-fold>
  public /*const*/ DeclStmt /*P*/ getLoopVarStmt$Const() /*const*/ {
    return cast_DeclStmt(SubExprs[Unnamed_enum.LOOPVAR.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 182,
   FQN="clang::CXXForRangeStmt::getBody", NM="_ZNK5clang15CXXForRangeStmt7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang15CXXForRangeStmt7getBodyEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getBody$Const() /*const*/ {
    return SubExprs[Unnamed_enum.BODY.getValue()];
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::setRangeInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 184,
   FQN="clang::CXXForRangeStmt::setRangeInit", NM="_ZN5clang15CXXForRangeStmt12setRangeInitEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmt12setRangeInitEPNS_4ExprE")
  //</editor-fold>
  public void setRangeInit(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.RANGE.getValue()] = reinterpret_cast(Stmt /*P*/ .class, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::setRangeStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 185,
   FQN="clang::CXXForRangeStmt::setRangeStmt", NM="_ZN5clang15CXXForRangeStmt12setRangeStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmt12setRangeStmtEPNS_4StmtE")
  //</editor-fold>
  public void setRangeStmt(Stmt /*P*/ S) {
    SubExprs[Unnamed_enum.RANGE.getValue()] = S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::setBeginStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 186,
   FQN="clang::CXXForRangeStmt::setBeginStmt", NM="_ZN5clang15CXXForRangeStmt12setBeginStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmt12setBeginStmtEPNS_4StmtE")
  //</editor-fold>
  public void setBeginStmt(Stmt /*P*/ S) {
    SubExprs[Unnamed_enum.BEGINSTMT.getValue()] = S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::setEndStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 187,
   FQN="clang::CXXForRangeStmt::setEndStmt", NM="_ZN5clang15CXXForRangeStmt10setEndStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmt10setEndStmtEPNS_4StmtE")
  //</editor-fold>
  public void setEndStmt(Stmt /*P*/ S) {
    SubExprs[Unnamed_enum.ENDSTMT.getValue()] = S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::setCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 188,
   FQN="clang::CXXForRangeStmt::setCond", NM="_ZN5clang15CXXForRangeStmt7setCondEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmt7setCondEPNS_4ExprE")
  //</editor-fold>
  public void setCond(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.COND.getValue()] = reinterpret_cast(Stmt /*P*/ .class, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::setInc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 189,
   FQN="clang::CXXForRangeStmt::setInc", NM="_ZN5clang15CXXForRangeStmt6setIncEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmt6setIncEPNS_4ExprE")
  //</editor-fold>
  public void setInc(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.INC.getValue()] = reinterpret_cast(Stmt /*P*/ .class, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::setLoopVarStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 190,
   FQN="clang::CXXForRangeStmt::setLoopVarStmt", NM="_ZN5clang15CXXForRangeStmt14setLoopVarStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmt14setLoopVarStmtEPNS_4StmtE")
  //</editor-fold>
  public void setLoopVarStmt(Stmt /*P*/ S) {
    SubExprs[Unnamed_enum.LOOPVAR.getValue()] = S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::setBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 191,
   FQN="clang::CXXForRangeStmt::setBody", NM="_ZN5clang15CXXForRangeStmt7setBodyEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmt7setBodyEPNS_4StmtE")
  //</editor-fold>
  public void setBody(Stmt /*P*/ S) {
    SubExprs[Unnamed_enum.BODY.getValue()] = S;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getForLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 193,
   FQN="clang::CXXForRangeStmt::getForLoc", NM="_ZNK5clang15CXXForRangeStmt9getForLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang15CXXForRangeStmt9getForLocEv")
  //</editor-fold>
  public SourceLocation getForLoc() /*const*/ {
    return new SourceLocation(ForLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getCoawaitLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 194,
   FQN="clang::CXXForRangeStmt::getCoawaitLoc", NM="_ZNK5clang15CXXForRangeStmt13getCoawaitLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang15CXXForRangeStmt13getCoawaitLocEv")
  //</editor-fold>
  public SourceLocation getCoawaitLoc() /*const*/ {
    return new SourceLocation(CoawaitLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 195,
   FQN="clang::CXXForRangeStmt::getColonLoc", NM="_ZNK5clang15CXXForRangeStmt11getColonLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang15CXXForRangeStmt11getColonLocEv")
  //</editor-fold>
  public SourceLocation getColonLoc() /*const*/ {
    return new SourceLocation(ColonLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 196,
   FQN="clang::CXXForRangeStmt::getRParenLoc", NM="_ZNK5clang15CXXForRangeStmt12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang15CXXForRangeStmt12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 198,
   FQN="clang::CXXForRangeStmt::getLocStart", NM="_ZNK5clang15CXXForRangeStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang15CXXForRangeStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(ForLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 199,
   FQN="clang::CXXForRangeStmt::getLocEnd", NM="_ZNK5clang15CXXForRangeStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang15CXXForRangeStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return SubExprs[Unnamed_enum.BODY.getValue()].getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 203,
   FQN="clang::CXXForRangeStmt::classof", NM="_ZN5clang15CXXForRangeStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXForRangeStmtClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CXXForRangeStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 208,
   FQN="clang::CXXForRangeStmt::children", NM="_ZN5clang15CXXForRangeStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang15CXXForRangeStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator($AddrOf(SubExprs)), new StmtIterator($AddrOf(SubExprs),Unnamed_enum.END.getValue()));
  }

  
  @Override public String toString() {
    return "" + "ForLoc=" + ForLoc // NOI18N
              + ", SubExprs=" + SubExprs // NOI18N
              + ", CoawaitLoc=" + CoawaitLoc // NOI18N
              + ", ColonLoc=" + ColonLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
