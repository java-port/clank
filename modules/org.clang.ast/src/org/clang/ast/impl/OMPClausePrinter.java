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

package org.clang.ast.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.basic.BasicClangGlobals.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 595,
 FQN="(anonymous namespace)::OMPClausePrinter", NM="_ZN12_GLOBAL__N_116OMPClausePrinterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinterE")
//</editor-fold>
public class OMPClausePrinter implements /*public*/ OMPClauseVisitorVoid<OMPClausePrinter> {
  private final raw_ostream /*&*/ OS;
  private final /*const*/ PrintingPolicy /*&*/ Policy;
  /// \brief Process clauses with list of variables.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPClauseList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*bound T*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 769,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPClauseList", NM="Tpl__ZN12_GLOBAL__N_116OMPClausePrinter18VisitOMPClauseListEPT_c",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=Tpl__ZN12_GLOBAL__N_116OMPClausePrinter18VisitOMPClauseListEPT_c")
  //</editor-fold>
  private </*typename*/ T extends OMPVarListClause<?>> void VisitOMPClauseList(T /*P*/ Node, /*char*/byte StartSym) {
    for ( type$ptr<Expr/*P*/> I = Node.varlist_begin(), 
        E = Node.varlist_end();
         Native.$noteq_iter(I, E); I.$preInc()) {
      assert Native.$bool(Native.$star(I)) : "Expected non-null Stmt";
      OS.$out_char((Native.$eq_iter(I, Node.varlist_begin()) ? StartSym : $$COMMA));
      {
        DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Native.$star(I));
        if ((DRE != null)) {
          if (isa_OMPCapturedExprDecl(DRE.getDecl())) {
            DRE.printPretty(OS, (PrinterHelper /*P*/ )null, Policy, 0);
          } else {
            DRE.getDecl().printQualifiedName(OS);
          }
        } else {
          (Native.$star(I)).printPretty(OS, null, Policy, 0);
        }
      }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::OMPClausePrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 602,
   FQN="(anonymous namespace)::OMPClausePrinter::OMPClausePrinter", NM="_ZN12_GLOBAL__N_116OMPClausePrinterC1ERN4llvm11raw_ostreamERKN5clang14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinterC1ERN4llvm11raw_ostreamERKN5clang14PrintingPolicyE")
  //</editor-fold>
  public OMPClausePrinter(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) {
    // : OMPClauseVisitor<OMPClausePrinter>(), OS(OS), Policy(Policy) 
    //START JInit
    $OMPClauseVisitor();
    this./*&*/OS=/*&*/OS;
    this./*&*/Policy=/*&*/Policy;
    //END JInit
  }

  
  // OpenMP clauses.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPIfClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 609,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPIfClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter16VisitOMPIfClauseEPN5clang11OMPIfClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter16VisitOMPIfClauseEPN5clang11OMPIfClauseE")
  //</editor-fold>
  public void VisitOMPIfClause(OMPIfClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"if(");
    if (Node.getNameModifier() != OpenMPDirectiveKind.OMPD_unknown) {
      OS.$out(getOpenMPDirectiveName(Node.getNameModifier())).$out(/*KEEP_STR*/": ");
    }
    Node.getCondition().printPretty(OS, (PrinterHelper /*P*/ )null, Policy, 0);
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPFinalClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 617,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPFinalClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter19VisitOMPFinalClauseEPN5clang14OMPFinalClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter19VisitOMPFinalClauseEPN5clang14OMPFinalClauseE")
  //</editor-fold>
  public void VisitOMPFinalClause(OMPFinalClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"final(");
    Node.getCondition().printPretty(OS, (PrinterHelper /*P*/ )null, Policy, 0);
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPNumThreadsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 623,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPNumThreadsClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter24VisitOMPNumThreadsClauseEPN5clang19OMPNumThreadsClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter24VisitOMPNumThreadsClauseEPN5clang19OMPNumThreadsClauseE")
  //</editor-fold>
  public void VisitOMPNumThreadsClause(OMPNumThreadsClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"num_threads(");
    Node.getNumThreads().printPretty(OS, (PrinterHelper /*P*/ )null, Policy, 0);
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPSafelenClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 629,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPSafelenClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter21VisitOMPSafelenClauseEPN5clang16OMPSafelenClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter21VisitOMPSafelenClauseEPN5clang16OMPSafelenClauseE")
  //</editor-fold>
  public void VisitOMPSafelenClause(OMPSafelenClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"safelen(");
    Node.getSafelen().printPretty(OS, (PrinterHelper /*P*/ )null, Policy, 0);
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPSimdlenClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 635,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPSimdlenClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter21VisitOMPSimdlenClauseEPN5clang16OMPSimdlenClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter21VisitOMPSimdlenClauseEPN5clang16OMPSimdlenClauseE")
  //</editor-fold>
  public void VisitOMPSimdlenClause(OMPSimdlenClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"simdlen(");
    Node.getSimdlen().printPretty(OS, (PrinterHelper /*P*/ )null, Policy, 0);
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPCollapseClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 641,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPCollapseClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter22VisitOMPCollapseClauseEPN5clang17OMPCollapseClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter22VisitOMPCollapseClauseEPN5clang17OMPCollapseClauseE")
  //</editor-fold>
  public void VisitOMPCollapseClause(OMPCollapseClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"collapse(");
    Node.getNumForLoops().printPretty(OS, (PrinterHelper /*P*/ )null, Policy, 0);
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPDefaultClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 647,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPDefaultClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter21VisitOMPDefaultClauseEPN5clang16OMPDefaultClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter21VisitOMPDefaultClauseEPN5clang16OMPDefaultClauseE")
  //</editor-fold>
  public void VisitOMPDefaultClause(OMPDefaultClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"default(").$out(
        getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_default, Node.getDefaultKind().getValue())
    ).$out(
        /*KEEP_STR*/$RPAREN
    );
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPPrivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 785,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPPrivateClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter21VisitOMPPrivateClauseEPN5clang16OMPPrivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter21VisitOMPPrivateClauseEPN5clang16OMPPrivateClauseE")
  //</editor-fold>
  public void VisitOMPPrivateClause(OMPPrivateClause /*P*/ Node) {
    if (!Node.varlist_empty()) {
      OS.$out(/*KEEP_STR*/$private);
      VisitOMPClauseList(Node, $$LPAREN);
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPFirstprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 793,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPFirstprivateClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter26VisitOMPFirstprivateClauseEPN5clang21OMPFirstprivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter26VisitOMPFirstprivateClauseEPN5clang21OMPFirstprivateClauseE")
  //</editor-fold>
  public void VisitOMPFirstprivateClause(OMPFirstprivateClause /*P*/ Node) {
    if (!Node.varlist_empty()) {
      OS.$out(/*KEEP_STR*/"firstprivate");
      VisitOMPClauseList(Node, $$LPAREN);
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPLastprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 801,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPLastprivateClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter25VisitOMPLastprivateClauseEPN5clang20OMPLastprivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter25VisitOMPLastprivateClauseEPN5clang20OMPLastprivateClauseE")
  //</editor-fold>
  public void VisitOMPLastprivateClause(OMPLastprivateClause /*P*/ Node) {
    if (!Node.varlist_empty()) {
      OS.$out(/*KEEP_STR*/"lastprivate");
      VisitOMPClauseList(Node, $$LPAREN);
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPSharedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 809,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPSharedClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter20VisitOMPSharedClauseEPN5clang15OMPSharedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter20VisitOMPSharedClauseEPN5clang15OMPSharedClauseE")
  //</editor-fold>
  public void VisitOMPSharedClause(OMPSharedClause /*P*/ Node) {
    if (!Node.varlist_empty()) {
      OS.$out(/*KEEP_STR*/"shared");
      VisitOMPClauseList(Node, $$LPAREN);
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPReductionClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 817,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPReductionClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter23VisitOMPReductionClauseEPN5clang18OMPReductionClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter23VisitOMPReductionClauseEPN5clang18OMPReductionClauseE")
  //</editor-fold>
  public void VisitOMPReductionClause(OMPReductionClause /*P*/ Node) {
    if (!Node.varlist_empty()) {
      OS.$out(/*KEEP_STR*/"reduction(");
      NestedNameSpecifier /*P*/ QualifierLoc = Node.getQualifierLoc().getNestedNameSpecifier();
      OverloadedOperatorKind OOK = Node.getNameInfo().getName().getCXXOverloadedOperator();
      if (QualifierLoc == null && OOK != OverloadedOperatorKind.OO_None) {
        // Print reduction identifier in C format
        OS.$out(getOperatorSpelling(OOK));
      } else {
        // Use C++ format
        if (QualifierLoc != null) {
          QualifierLoc.print(OS, Policy);
        }
        $out_raw_ostream_DeclarationNameInfo(OS, /*NO_COPY*/Node.getNameInfo());
      }
      OS.$out(/*KEEP_STR*/$COLON);
      VisitOMPClauseList(Node, $$SPACE);
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPLinearClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 839,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPLinearClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter20VisitOMPLinearClauseEPN5clang15OMPLinearClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter20VisitOMPLinearClauseEPN5clang15OMPLinearClauseE")
  //</editor-fold>
  public void VisitOMPLinearClause(OMPLinearClause /*P*/ Node) {
    if (!Node.varlist_empty()) {
      OS.$out(/*KEEP_STR*/"linear");
      if (Node.getModifierLoc().isValid()) {
        OS.$out_char($$LPAREN).$out(
            getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_linear, Node.getModifier().getValue())
        );
      }
      VisitOMPClauseList(Node, $$LPAREN);
      if (Node.getModifierLoc().isValid()) {
        OS.$out_char($$RPAREN);
      }
      if (Node.getStep() != null) {
        OS.$out(/*KEEP_STR*/": ");
        Node.getStep().printPretty(OS, (PrinterHelper /*P*/ )null, Policy, 0);
      }
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPAlignedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 857,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPAlignedClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter21VisitOMPAlignedClauseEPN5clang16OMPAlignedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter21VisitOMPAlignedClauseEPN5clang16OMPAlignedClauseE")
  //</editor-fold>
  public void VisitOMPAlignedClause(OMPAlignedClause /*P*/ Node) {
    if (!Node.varlist_empty()) {
      OS.$out(/*KEEP_STR*/"aligned");
      VisitOMPClauseList(Node, $$LPAREN);
      if (Node.getAlignment() != null) {
        OS.$out(/*KEEP_STR*/": ");
        Node.getAlignment().printPretty(OS, (PrinterHelper /*P*/ )null, Policy, 0);
      }
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPCopyinClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 869,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPCopyinClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter20VisitOMPCopyinClauseEPN5clang15OMPCopyinClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter20VisitOMPCopyinClauseEPN5clang15OMPCopyinClauseE")
  //</editor-fold>
  public void VisitOMPCopyinClause(OMPCopyinClause /*P*/ Node) {
    if (!Node.varlist_empty()) {
      OS.$out(/*KEEP_STR*/"copyin");
      VisitOMPClauseList(Node, $$LPAREN);
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPCopyprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 877,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPCopyprivateClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter25VisitOMPCopyprivateClauseEPN5clang20OMPCopyprivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter25VisitOMPCopyprivateClauseEPN5clang20OMPCopyprivateClauseE")
  //</editor-fold>
  public void VisitOMPCopyprivateClause(OMPCopyprivateClause /*P*/ Node) {
    if (!Node.varlist_empty()) {
      OS.$out(/*KEEP_STR*/"copyprivate");
      VisitOMPClauseList(Node, $$LPAREN);
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPProcBindClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 653,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPProcBindClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter22VisitOMPProcBindClauseEPN5clang17OMPProcBindClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter22VisitOMPProcBindClauseEPN5clang17OMPProcBindClauseE")
  //</editor-fold>
  public void VisitOMPProcBindClause(OMPProcBindClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"proc_bind(").$out(
        getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_proc_bind, Node.getProcBindKind().getValue())
    ).$out(
        /*KEEP_STR*/$RPAREN
    );
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPScheduleClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 659,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPScheduleClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter22VisitOMPScheduleClauseEPN5clang17OMPScheduleClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter22VisitOMPScheduleClauseEPN5clang17OMPScheduleClauseE")
  //</editor-fold>
  public void VisitOMPScheduleClause(OMPScheduleClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"schedule(");
    if (Node.getFirstScheduleModifier() != OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_unknown) {
      OS.$out(getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_schedule, 
              Node.getFirstScheduleModifier()));
      if (Node.getSecondScheduleModifier() != OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_unknown) {
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        OS.$out(getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_schedule, 
                Node.getSecondScheduleModifier()));
      }
      OS.$out(/*KEEP_STR*/": ");
    }
    OS.$out(getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_schedule, Node.getScheduleKind()));
    {
      Expr /*P*/ E = Node.getChunkSize();
      if ((E != null)) {
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        E.printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
      }
    }
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPOrderedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 679,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPOrderedClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter21VisitOMPOrderedClauseEPN5clang16OMPOrderedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter21VisitOMPOrderedClauseEPN5clang16OMPOrderedClauseE")
  //</editor-fold>
  public void VisitOMPOrderedClause(OMPOrderedClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"ordered");
    {
      Expr /*P*/ Num = Node.getNumForLoops();
      if ((Num != null)) {
        OS.$out(/*KEEP_STR*/$LPAREN);
        Num.printPretty(OS, (PrinterHelper /*P*/ )null, Policy, 0);
        OS.$out(/*KEEP_STR*/$RPAREN);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPNowaitClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 688,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPNowaitClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter20VisitOMPNowaitClauseEPN5clang15OMPNowaitClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter20VisitOMPNowaitClauseEPN5clang15OMPNowaitClauseE")
  //</editor-fold>
  public void VisitOMPNowaitClause(OMPNowaitClause /*P*/ $Prm0) {
    OS.$out(/*KEEP_STR*/"nowait");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPUntiedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 692,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPUntiedClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter20VisitOMPUntiedClauseEPN5clang15OMPUntiedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter20VisitOMPUntiedClauseEPN5clang15OMPUntiedClauseE")
  //</editor-fold>
  public void VisitOMPUntiedClause(OMPUntiedClause /*P*/ $Prm0) {
    OS.$out(/*KEEP_STR*/"untied");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPMergeableClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 700,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPMergeableClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter23VisitOMPMergeableClauseEPN5clang18OMPMergeableClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter23VisitOMPMergeableClauseEPN5clang18OMPMergeableClauseE")
  //</editor-fold>
  public void VisitOMPMergeableClause(OMPMergeableClause /*P*/ $Prm0) {
    OS.$out(/*KEEP_STR*/"mergeable");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPFlushClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 885,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPFlushClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter19VisitOMPFlushClauseEPN5clang14OMPFlushClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter19VisitOMPFlushClauseEPN5clang14OMPFlushClauseE")
  //</editor-fold>
  public void VisitOMPFlushClause(OMPFlushClause /*P*/ Node) {
    if (!Node.varlist_empty()) {
      VisitOMPClauseList(Node, $$LPAREN);
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPReadClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 704,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPReadClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter18VisitOMPReadClauseEPN5clang13OMPReadClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter18VisitOMPReadClauseEPN5clang13OMPReadClauseE")
  //</editor-fold>
  public void VisitOMPReadClause(OMPReadClause /*P*/ $Prm0) {
    OS.$out(/*KEEP_STR*/"read");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPWriteClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 706,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPWriteClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter19VisitOMPWriteClauseEPN5clang14OMPWriteClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter19VisitOMPWriteClauseEPN5clang14OMPWriteClauseE")
  //</editor-fold>
  public void VisitOMPWriteClause(OMPWriteClause /*P*/ $Prm0) {
    OS.$out(/*KEEP_STR*/"write");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPUpdateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 708,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPUpdateClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter20VisitOMPUpdateClauseEPN5clang15OMPUpdateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter20VisitOMPUpdateClauseEPN5clang15OMPUpdateClauseE")
  //</editor-fold>
  public void VisitOMPUpdateClause(OMPUpdateClause /*P*/ $Prm0) {
    OS.$out(/*KEEP_STR*/"update");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPCaptureClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 712,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPCaptureClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter21VisitOMPCaptureClauseEPN5clang16OMPCaptureClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter21VisitOMPCaptureClauseEPN5clang16OMPCaptureClauseE")
  //</editor-fold>
  public void VisitOMPCaptureClause(OMPCaptureClause /*P*/ $Prm0) {
    OS.$out(/*KEEP_STR*/"capture");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPSeqCstClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 716,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPSeqCstClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter20VisitOMPSeqCstClauseEPN5clang15OMPSeqCstClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter20VisitOMPSeqCstClauseEPN5clang15OMPSeqCstClauseE")
  //</editor-fold>
  public void VisitOMPSeqCstClause(OMPSeqCstClause /*P*/ $Prm0) {
    OS.$out(/*KEEP_STR*/"seq_cst");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPDependClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 892,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPDependClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter20VisitOMPDependClauseEPN5clang15OMPDependClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter20VisitOMPDependClauseEPN5clang15OMPDependClauseE")
  //</editor-fold>
  public void VisitOMPDependClause(OMPDependClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"depend(");
    OS.$out(getOpenMPSimpleClauseTypeName(Node.getClauseKind(), 
            Node.getDependencyKind().getValue()));
    if (!Node.varlist_empty()) {
      OS.$out(/*KEEP_STR*/" :");
      VisitOMPClauseList(Node, $$SPACE);
    }
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPDeviceClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 726,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPDeviceClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter20VisitOMPDeviceClauseEPN5clang15OMPDeviceClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter20VisitOMPDeviceClauseEPN5clang15OMPDeviceClauseE")
  //</editor-fold>
  public void VisitOMPDeviceClause(OMPDeviceClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"device(");
    Node.getDevice().printPretty(OS, (PrinterHelper /*P*/ )null, Policy, 0);
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPThreadsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 720,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPThreadsClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter21VisitOMPThreadsClauseEPN5clang16OMPThreadsClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter21VisitOMPThreadsClauseEPN5clang16OMPThreadsClauseE")
  //</editor-fold>
  public void VisitOMPThreadsClause(OMPThreadsClause /*P*/ $Prm0) {
    OS.$out(/*KEEP_STR*/"threads");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPSIMDClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 724,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPSIMDClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter18VisitOMPSIMDClauseEPN5clang13OMPSIMDClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter18VisitOMPSIMDClauseEPN5clang13OMPSIMDClauseE")
  //</editor-fold>
  public void VisitOMPSIMDClause(OMPSIMDClause /*P*/ $Prm0) {
    OS.$out(/*KEEP_STR*/"simd");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPMapClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 903,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPMapClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter17VisitOMPMapClauseEPN5clang12OMPMapClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter17VisitOMPMapClauseEPN5clang12OMPMapClauseE")
  //</editor-fold>
  public void VisitOMPMapClause(OMPMapClause /*P*/ Node) {
    if (!Node.varlist_empty()) {
      OS.$out(/*KEEP_STR*/"map(");
      if (Node.getMapType() != OpenMPMapClauseKind.OMPC_MAP_unknown) {
        if (Node.getMapTypeModifier() != OpenMPMapClauseKind.OMPC_MAP_unknown) {
          OS.$out(getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_map, 
                  Node.getMapTypeModifier().getValue()));
          OS.$out_char($$COMMA);
        }
        OS.$out(getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_map, Node.getMapType().getValue()));
        OS.$out_char($$COLON);
      }
      VisitOMPClauseList(Node, $$SPACE);
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPNumTeamsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 732,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPNumTeamsClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter22VisitOMPNumTeamsClauseEPN5clang17OMPNumTeamsClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter22VisitOMPNumTeamsClauseEPN5clang17OMPNumTeamsClauseE")
  //</editor-fold>
  public void VisitOMPNumTeamsClause(OMPNumTeamsClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"num_teams(");
    Node.getNumTeams().printPretty(OS, (PrinterHelper /*P*/ )null, Policy, 0);
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPThreadLimitClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 738,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPThreadLimitClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter25VisitOMPThreadLimitClauseEPN5clang20OMPThreadLimitClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter25VisitOMPThreadLimitClauseEPN5clang20OMPThreadLimitClauseE")
  //</editor-fold>
  public void VisitOMPThreadLimitClause(OMPThreadLimitClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"thread_limit(");
    Node.getThreadLimit().printPretty(OS, (PrinterHelper /*P*/ )null, Policy, 0);
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPPriorityClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 744,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPPriorityClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter22VisitOMPPriorityClauseEPN5clang17OMPPriorityClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter22VisitOMPPriorityClauseEPN5clang17OMPPriorityClauseE")
  //</editor-fold>
  public void VisitOMPPriorityClause(OMPPriorityClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"priority(");
    Node.getPriority().printPretty(OS, (PrinterHelper /*P*/ )null, Policy, 0);
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPGrainsizeClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 750,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPGrainsizeClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter23VisitOMPGrainsizeClauseEPN5clang18OMPGrainsizeClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter23VisitOMPGrainsizeClauseEPN5clang18OMPGrainsizeClauseE")
  //</editor-fold>
  public void VisitOMPGrainsizeClause(OMPGrainsizeClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"grainsize(");
    Node.getGrainsize().printPretty(OS, (PrinterHelper /*P*/ )null, Policy, 0);
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPNogroupClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 696,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPNogroupClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter21VisitOMPNogroupClauseEPN5clang16OMPNogroupClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter21VisitOMPNogroupClauseEPN5clang16OMPNogroupClauseE")
  //</editor-fold>
  public void VisitOMPNogroupClause(OMPNogroupClause /*P*/ $Prm0) {
    OS.$out(/*KEEP_STR*/"nogroup");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPNumTasksClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 756,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPNumTasksClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter22VisitOMPNumTasksClauseEPN5clang17OMPNumTasksClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter22VisitOMPNumTasksClauseEPN5clang17OMPNumTasksClauseE")
  //</editor-fold>
  public void VisitOMPNumTasksClause(OMPNumTasksClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"num_tasks(");
    Node.getNumTasks().printPretty(OS, (PrinterHelper /*P*/ )null, Policy, 0);
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPHintClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 762,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPHintClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter18VisitOMPHintClauseEPN5clang13OMPHintClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter18VisitOMPHintClauseEPN5clang13OMPHintClauseE")
  //</editor-fold>
  public void VisitOMPHintClause(OMPHintClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"hint(");
    Node.getHint().printPretty(OS, (PrinterHelper /*P*/ )null, Policy, 0);
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPDistScheduleClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 936,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPDistScheduleClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter26VisitOMPDistScheduleClauseEPN5clang21OMPDistScheduleClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter26VisitOMPDistScheduleClauseEPN5clang21OMPDistScheduleClauseE")
  //</editor-fold>
  public void VisitOMPDistScheduleClause(OMPDistScheduleClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"dist_schedule(").$out(getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_dist_schedule, Node.getDistScheduleKind()));
    {
      Expr /*P*/ E = Node.getChunkSize();
      if ((E != null)) {
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        E.printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
      }
    }
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPDefaultmapClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 946,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPDefaultmapClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter24VisitOMPDefaultmapClauseEPN5clang19OMPDefaultmapClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter24VisitOMPDefaultmapClauseEPN5clang19OMPDefaultmapClauseE")
  //</editor-fold>
  public void VisitOMPDefaultmapClause(OMPDefaultmapClause /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"defaultmap(");
    OS.$out(getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_defaultmap, 
            Node.getDefaultmapModifier()));
    OS.$out(/*KEEP_STR*/": ");
    OS.$out(getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_defaultmap, 
            Node.getDefaultmapKind()));
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPToClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 920,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPToClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter16VisitOMPToClauseEPN5clang11OMPToClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter16VisitOMPToClauseEPN5clang11OMPToClauseE")
  //</editor-fold>
  public void VisitOMPToClause(OMPToClause /*P*/ Node) {
    if (!Node.varlist_empty()) {
      OS.$out(/*KEEP_STR*/"to");
      VisitOMPClauseList(Node, $$LPAREN);
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPFromClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 928,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPFromClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter18VisitOMPFromClauseEPN5clang13OMPFromClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter18VisitOMPFromClauseEPN5clang13OMPFromClauseE")
  //</editor-fold>
  public void VisitOMPFromClause(OMPFromClause /*P*/ Node) {
    if (!Node.varlist_empty()) {
      OS.$out(/*KEEP_STR*/"from");
      VisitOMPClauseList(Node, $$LPAREN);
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPUseDevicePtrClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 956,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPUseDevicePtrClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter26VisitOMPUseDevicePtrClauseEPN5clang21OMPUseDevicePtrClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter26VisitOMPUseDevicePtrClauseEPN5clang21OMPUseDevicePtrClauseE")
  //</editor-fold>
  public void VisitOMPUseDevicePtrClause(OMPUseDevicePtrClause /*P*/ Node) {
    if (!Node.varlist_empty()) {
      OS.$out(/*KEEP_STR*/"use_device_ptr");
      VisitOMPClauseList(Node, $$LPAREN);
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClausePrinter::VisitOMPIsDevicePtrClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 964,
   FQN="(anonymous namespace)::OMPClausePrinter::VisitOMPIsDevicePtrClause", NM="_ZN12_GLOBAL__N_116OMPClausePrinter25VisitOMPIsDevicePtrClauseEPN5clang20OMPIsDevicePtrClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_116OMPClausePrinter25VisitOMPIsDevicePtrClauseEPN5clang20OMPIsDevicePtrClauseE")
  //</editor-fold>
  public void VisitOMPIsDevicePtrClause(OMPIsDevicePtrClause /*P*/ Node) {
    if (!Node.varlist_empty()) {
      OS.$out(/*KEEP_STR*/"is_device_ptr");
      VisitOMPClauseList(Node, $$LPAREN);
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
  }

  
  @Override public String toString() {
    return "" + "OS=" + OS // NOI18N
              + ", Policy=" + Policy // NOI18N
              + super.toString(); // NOI18N
  }
}
