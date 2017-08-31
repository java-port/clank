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

package org.clang.analysis.impl;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.analysis.impl.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockTerminatorPrint">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4113,
 FQN="(anonymous namespace)::CFGBlockTerminatorPrint", NM="_ZN12_GLOBAL__N_123CFGBlockTerminatorPrintE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_123CFGBlockTerminatorPrintE")
//</editor-fold>
public class CFGBlockTerminatorPrint implements /*public*/ StmtVisitorVoid<CFGBlockTerminatorPrint> {
  
  private final raw_ostream /*&*/ OS;
  private StmtPrinterHelper /*P*/ Helper;
  private PrintingPolicy Policy;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockTerminatorPrint::CFGBlockTerminatorPrint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4120,
   FQN="(anonymous namespace)::CFGBlockTerminatorPrint::CFGBlockTerminatorPrint", NM="_ZN12_GLOBAL__N_123CFGBlockTerminatorPrintC1ERN4llvm11raw_ostreamEPNS_17StmtPrinterHelperERKN5clang14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_123CFGBlockTerminatorPrintC1ERN4llvm11raw_ostreamEPNS_17StmtPrinterHelperERKN5clang14PrintingPolicyE")
  //</editor-fold>
  public CFGBlockTerminatorPrint(final raw_ostream /*&*/ os, StmtPrinterHelper /*P*/ helper, 
      final /*const*/ PrintingPolicy /*&*/ Policy) {
    // : StmtVisitor<CFGBlockTerminatorPrint, void>(), OS(os), Helper(helper), Policy(Policy) 
    //START JInit
    $StmtVisitor();
    this./*&*/OS=/*&*/os;
    this.Helper = helper;
    this.Policy = new PrintingPolicy(Policy);
    //END JInit
    this.Policy.IncludeNewlines = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockTerminatorPrint::VisitIfStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4126,
   FQN="(anonymous namespace)::CFGBlockTerminatorPrint::VisitIfStmt", NM="_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint11VisitIfStmtEPN5clang6IfStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint11VisitIfStmtEPN5clang6IfStmtE")
  //</editor-fold>
  public void VisitIfStmt(IfStmt /*P*/ I) {
    OS.$out(/*KEEP_STR*/"if ");
    {
      Stmt /*P*/ C = I.getCond();
      if ((C != null)) {
        C.printPretty(OS, Helper, Policy);
      }
    }
  }

  
  // Default case.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockTerminatorPrint::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4133,
   FQN="(anonymous namespace)::CFGBlockTerminatorPrint::VisitStmt", NM="_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public void VisitStmt(Stmt /*P*/ Terminator) {
    Terminator.printPretty(OS, Helper, Policy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockTerminatorPrint::VisitDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4137,
   FQN="(anonymous namespace)::CFGBlockTerminatorPrint::VisitDeclStmt", NM="_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint13VisitDeclStmtEPN5clang8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint13VisitDeclStmtEPN5clang8DeclStmtE")
  //</editor-fold>
  public void VisitDeclStmt(DeclStmt /*P*/ DS) {
    VarDecl /*P*/ VD = cast_VarDecl(DS.getSingleDecl());
    OS.$out(/*KEEP_STR*/"static init ").$out(VD.getName());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockTerminatorPrint::VisitForStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4142,
   FQN="(anonymous namespace)::CFGBlockTerminatorPrint::VisitForStmt", NM="_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint12VisitForStmtEPN5clang7ForStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint12VisitForStmtEPN5clang7ForStmtE")
  //</editor-fold>
  public void VisitForStmt(ForStmt /*P*/ F) {
    OS.$out(/*KEEP_STR*/"for (");
    if ((F.getInit() != null)) {
      OS.$out(/*KEEP_STR*/$ELLIPSIS);
    }
    OS.$out(/*KEEP_STR*/"; ");
    {
      Stmt /*P*/ C = F.getCond();
      if ((C != null)) {
        C.printPretty(OS, Helper, Policy);
      }
    }
    OS.$out(/*KEEP_STR*/"; ");
    if ((F.getInc() != null)) {
      OS.$out(/*KEEP_STR*/$ELLIPSIS);
    }
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockTerminatorPrint::VisitWhileStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4155,
   FQN="(anonymous namespace)::CFGBlockTerminatorPrint::VisitWhileStmt", NM="_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint14VisitWhileStmtEPN5clang9WhileStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint14VisitWhileStmtEPN5clang9WhileStmtE")
  //</editor-fold>
  public void VisitWhileStmt(WhileStmt /*P*/ W) {
    OS.$out(/*KEEP_STR*/"while ");
    {
      Stmt /*P*/ C = W.getCond();
      if ((C != null)) {
        C.printPretty(OS, Helper, Policy);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockTerminatorPrint::VisitDoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4161,
   FQN="(anonymous namespace)::CFGBlockTerminatorPrint::VisitDoStmt", NM="_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint11VisitDoStmtEPN5clang6DoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint11VisitDoStmtEPN5clang6DoStmtE")
  //</editor-fold>
  public void VisitDoStmt(DoStmt /*P*/ D) {
    OS.$out(/*KEEP_STR*/"do ... while ");
    {
      Stmt /*P*/ C = D.getCond();
      if ((C != null)) {
        C.printPretty(OS, Helper, Policy);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockTerminatorPrint::VisitSwitchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4167,
   FQN="(anonymous namespace)::CFGBlockTerminatorPrint::VisitSwitchStmt", NM="_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint15VisitSwitchStmtEPN5clang10SwitchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint15VisitSwitchStmtEPN5clang10SwitchStmtE")
  //</editor-fold>
  public void VisitSwitchStmt(SwitchStmt /*P*/ Terminator) {
    OS.$out(/*KEEP_STR*/"switch ");
    Terminator.getCond().printPretty(OS, Helper, Policy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockTerminatorPrint::VisitCXXTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4172,
   FQN="(anonymous namespace)::CFGBlockTerminatorPrint::VisitCXXTryStmt", NM="_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint15VisitCXXTryStmtEPN5clang10CXXTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint15VisitCXXTryStmtEPN5clang10CXXTryStmtE")
  //</editor-fold>
  public void VisitCXXTryStmt(CXXTryStmt /*P*/ CS) {
    OS.$out(/*KEEP_STR*/"try ...");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockTerminatorPrint::VisitAbstractConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4176,
   FQN="(anonymous namespace)::CFGBlockTerminatorPrint::VisitAbstractConditionalOperator", NM="_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint32VisitAbstractConditionalOperatorEPN5clang27AbstractConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint32VisitAbstractConditionalOperatorEPN5clang27AbstractConditionalOperatorE")
  //</editor-fold>
  public void VisitAbstractConditionalOperator(AbstractConditionalOperator /*P*/ C) {
    {
      Stmt /*P*/ Cond = C.getCond();
      if ((Cond != null)) {
        Cond.printPretty(OS, Helper, Policy);
      }
    }
    OS.$out(/*KEEP_STR*/" ? ... : ...");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockTerminatorPrint::VisitChooseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4182,
   FQN="(anonymous namespace)::CFGBlockTerminatorPrint::VisitChooseExpr", NM="_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint15VisitChooseExprEPN5clang10ChooseExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint15VisitChooseExprEPN5clang10ChooseExprE")
  //</editor-fold>
  public void VisitChooseExpr(ChooseExpr /*P*/ C) {
    OS.$out(/*KEEP_STR*/"__builtin_choose_expr( ");
    {
      Stmt /*P*/ Cond = C.getCond();
      if ((Cond != null)) {
        Cond.printPretty(OS, Helper, Policy);
      }
    }
    OS.$out(/*KEEP_STR*/" )");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockTerminatorPrint::VisitIndirectGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4189,
   FQN="(anonymous namespace)::CFGBlockTerminatorPrint::VisitIndirectGotoStmt", NM="_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint21VisitIndirectGotoStmtEPN5clang16IndirectGotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint21VisitIndirectGotoStmtEPN5clang16IndirectGotoStmtE")
  //</editor-fold>
  public void VisitIndirectGotoStmt(IndirectGotoStmt /*P*/ I) {
    OS.$out(/*KEEP_STR*/"goto *");
    {
      Stmt /*P*/ T = I.getTarget();
      if ((T != null)) {
        T.printPretty(OS, Helper, Policy);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockTerminatorPrint::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4195,
   FQN="(anonymous namespace)::CFGBlockTerminatorPrint::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint19VisitBinaryOperatorEPN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint19VisitBinaryOperatorEPN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinaryOperator(BinaryOperator /*P*/ B) {
    if (!B.isLogicalOp()) {
      VisitExpr(B);
      return;
    }
    if ((B.getLHS() != null)) {
      B.getLHS().printPretty(OS, Helper, Policy);
    }
    switch (B.getOpcode()) {
     case BO_LOr:
      OS.$out(/*KEEP_STR*/" || ...");
      return;
     case BO_LAnd:
      OS.$out(/*KEEP_STR*/" && ...");
      return;
     default:
      throw new llvm_unreachable("Invalid logical operator.");
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockTerminatorPrint::VisitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4216,
   FQN="(anonymous namespace)::CFGBlockTerminatorPrint::VisitExpr", NM="_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint9VisitExprEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint9VisitExprEPN5clang4ExprE")
  //</editor-fold>
  public void VisitExpr(Expr /*P*/ E) {
    E.printPretty(OS, Helper, Policy);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockTerminatorPrint::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4221,
   FQN="(anonymous namespace)::CFGBlockTerminatorPrint::print", NM="_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint5printEN5clang13CFGTerminatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_123CFGBlockTerminatorPrint5printEN5clang13CFGTerminatorE")
  //</editor-fold>
  public void print(CFGTerminator T) {
    if (T.isTemporaryDtorsBranch()) {
      OS.$out(/*KEEP_STR*/"(Temp Dtor) ");
    }
    Visit(T.getStmt());
  }

  
  @Override public String toString() {
    return "" + "OS=" + OS // NOI18N
              + ", Helper=" + Helper // NOI18N
              + ", Policy=" + Policy // NOI18N
              + super.toString(); // NOI18N
  }
}
