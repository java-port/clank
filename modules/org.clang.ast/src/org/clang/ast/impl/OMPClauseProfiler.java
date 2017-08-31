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
import static org.clank.support.Native.*;
import org.clang.ast.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 261,
 FQN="(anonymous namespace)::OMPClauseProfiler", NM="_ZN12_GLOBAL__N_117OMPClauseProfilerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfilerE")
//</editor-fold>
public class OMPClauseProfiler implements /*public*/ ConstOMPClauseVisitorVoid<OMPClauseProfiler> {
  private StmtProfiler /*P*/ Profiler;
  /// \brief Process clauses with list of variables.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPClauseList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*bound T*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 357,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPClauseList", NM="Tpl__ZN12_GLOBAL__N_117OMPClauseProfiler18VisitOMPClauseListEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=Tpl__ZN12_GLOBAL__N_117OMPClauseProfiler18VisitOMPClauseListEPT_")
  //</editor-fold>
  private </*typename*/ T extends OMPVarListClause<?>> void VisitOMPClauseList(T /*P*/ Node) {
    // JAVA: I have no idea why did I need to cast to iterator_range<Expr> below,
    // but without that javac did not compile
    for (Expr /*P*/ E : Node.varlists()) {
      if ($bool(E)) {
        Profiler.VisitStmt(E);
      }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::OMPClauseProfiler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 268,
   FQN="(anonymous namespace)::OMPClauseProfiler::OMPClauseProfiler", NM="_ZN12_GLOBAL__N_117OMPClauseProfilerC1EPNS_12StmtProfilerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfilerC1EPNS_12StmtProfilerE")
  //</editor-fold>
  public OMPClauseProfiler(StmtProfiler /*P*/ P) {
    // : ConstOMPClauseVisitor<OMPClauseProfiler>(), Profiler(P) 
    //START JInit
    $ConstOMPClauseVisitor();
    this.Profiler = P;
    //END JInit
  }

  
  // OpenMP clauses.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPIfClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 289,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPIfClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler16VisitOMPIfClauseEPKN5clang11OMPIfClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler16VisitOMPIfClauseEPKN5clang11OMPIfClauseE")
  //</editor-fold>
  public void VisitOMPIfClause(/*const*/ OMPIfClause /*P*/ C) {
    if ((C.getCondition() != null)) {
      Profiler.VisitStmt(C.getCondition());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPFinalClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 294,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPFinalClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler19VisitOMPFinalClauseEPKN5clang14OMPFinalClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler19VisitOMPFinalClauseEPKN5clang14OMPFinalClauseE")
  //</editor-fold>
  public void VisitOMPFinalClause(/*const*/ OMPFinalClause /*P*/ C) {
    if ((C.getCondition() != null)) {
      Profiler.VisitStmt(C.getCondition());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPNumThreadsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 299,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPNumThreadsClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler24VisitOMPNumThreadsClauseEPKN5clang19OMPNumThreadsClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler24VisitOMPNumThreadsClauseEPKN5clang19OMPNumThreadsClauseE")
  //</editor-fold>
  public void VisitOMPNumThreadsClause(/*const*/ OMPNumThreadsClause /*P*/ C) {
    if ((C.getNumThreads() != null)) {
      Profiler.VisitStmt(C.getNumThreads());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPSafelenClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 304,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPSafelenClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler21VisitOMPSafelenClauseEPKN5clang16OMPSafelenClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler21VisitOMPSafelenClauseEPKN5clang16OMPSafelenClauseE")
  //</editor-fold>
  public void VisitOMPSafelenClause(/*const*/ OMPSafelenClause /*P*/ C) {
    if ((C.getSafelen() != null)) {
      Profiler.VisitStmt(C.getSafelen());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPSimdlenClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 309,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPSimdlenClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler21VisitOMPSimdlenClauseEPKN5clang16OMPSimdlenClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler21VisitOMPSimdlenClauseEPKN5clang16OMPSimdlenClauseE")
  //</editor-fold>
  public void VisitOMPSimdlenClause(/*const*/ OMPSimdlenClause /*P*/ C) {
    if ((C.getSimdlen() != null)) {
      Profiler.VisitStmt(C.getSimdlen());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPCollapseClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 314,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPCollapseClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler22VisitOMPCollapseClauseEPKN5clang17OMPCollapseClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler22VisitOMPCollapseClauseEPKN5clang17OMPCollapseClauseE")
  //</editor-fold>
  public void VisitOMPCollapseClause(/*const*/ OMPCollapseClause /*P*/ C) {
    if ((C.getNumForLoops() != null)) {
      Profiler.VisitStmt(C.getNumForLoops());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPDefaultClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 319,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPDefaultClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler21VisitOMPDefaultClauseEPKN5clang16OMPDefaultClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler21VisitOMPDefaultClauseEPKN5clang16OMPDefaultClauseE")
  //</editor-fold>
  public void VisitOMPDefaultClause(/*const*/ OMPDefaultClause /*P*/ C) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPPrivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 364,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPPrivateClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler21VisitOMPPrivateClauseEPKN5clang16OMPPrivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler21VisitOMPPrivateClauseEPKN5clang16OMPPrivateClauseE")
  //</editor-fold>
  public void VisitOMPPrivateClause(/*const*/ OMPPrivateClause /*P*/ C) {
    VisitOMPClauseList(C);
    for (/*const*/ Expr /*P*/ E : C.private_copies$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPFirstprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 371,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPFirstprivateClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler26VisitOMPFirstprivateClauseEPKN5clang21OMPFirstprivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler26VisitOMPFirstprivateClauseEPKN5clang21OMPFirstprivateClauseE")
  //</editor-fold>
  public void VisitOMPFirstprivateClause(/*const*/ OMPFirstprivateClause /*P*/ C) {
    VisitOMPClauseList(C);
    VistOMPClauseWithPreInit(C);
    for (/*const*/ Expr /*P*/ E : C.private_copies$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
    for (/*const*/ Expr /*P*/ E : C.inits$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPLastprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 384,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPLastprivateClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler25VisitOMPLastprivateClauseEPKN5clang20OMPLastprivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler25VisitOMPLastprivateClauseEPKN5clang20OMPLastprivateClauseE")
  //</editor-fold>
  public void VisitOMPLastprivateClause(/*const*/ OMPLastprivateClause /*P*/ C) {
    VisitOMPClauseList(C);
    VistOMPClauseWithPostUpdate(C);
    for (/*const*/ Expr /*P*/ E : C.source_exprs$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
    for (/*const*/ Expr /*P*/ E : C.destination_exprs$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
    for (/*const*/ Expr /*P*/ E : C.assignment_ops$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPSharedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 401,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPSharedClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler20VisitOMPSharedClauseEPKN5clang15OMPSharedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler20VisitOMPSharedClauseEPKN5clang15OMPSharedClauseE")
  //</editor-fold>
  public void VisitOMPSharedClause(/*const*/ OMPSharedClause /*P*/ C) {
    VisitOMPClauseList(C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPReductionClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 404,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPReductionClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler23VisitOMPReductionClauseEPKN5clang18OMPReductionClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler23VisitOMPReductionClauseEPKN5clang18OMPReductionClauseE")
  //</editor-fold>
  public void VisitOMPReductionClause(/*const*/ OMPReductionClause /*P*/ C) {
    Profiler.VisitNestedNameSpecifier(C.getQualifierLoc().getNestedNameSpecifier());
    Profiler.VisitName(C.getNameInfo().getName());
    VisitOMPClauseList(C);
    VistOMPClauseWithPostUpdate(C);
    for (/*const*/ Expr /*P*/ E : C.privates$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
    for (/*const*/ Expr /*P*/ E : C.lhs_exprs$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
    for (/*const*/ Expr /*P*/ E : C.rhs_exprs$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
    for (/*const*/ Expr /*P*/ E : C.reduction_ops$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPLinearClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 428,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPLinearClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler20VisitOMPLinearClauseEPKN5clang15OMPLinearClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler20VisitOMPLinearClauseEPKN5clang15OMPLinearClauseE")
  //</editor-fold>
  public void VisitOMPLinearClause(/*const*/ OMPLinearClause /*P*/ C) {
    VisitOMPClauseList(C);
    VistOMPClauseWithPostUpdate(C);
    for (/*const*/ Expr /*P*/ E : C.privates$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
    for (/*const*/ Expr /*P*/ E : C.inits$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
    for (/*const*/ Expr /*P*/ E : C.updates$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
    for (/*const*/ Expr /*P*/ E : C.finals$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
    if ((C.getStep$Const() != null)) {
      Profiler.VisitStmt(C.getStep$Const());
    }
    if ((C.getCalcStep$Const() != null)) {
      Profiler.VisitStmt(C.getCalcStep$Const());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPAlignedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 452,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPAlignedClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler21VisitOMPAlignedClauseEPKN5clang16OMPAlignedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler21VisitOMPAlignedClauseEPKN5clang16OMPAlignedClauseE")
  //</editor-fold>
  public void VisitOMPAlignedClause(/*const*/ OMPAlignedClause /*P*/ C) {
    VisitOMPClauseList(C);
    if ((C.getAlignment$Const() != null)) {
      Profiler.VisitStmt(C.getAlignment$Const());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPCopyinClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 457,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPCopyinClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler20VisitOMPCopyinClauseEPKN5clang15OMPCopyinClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler20VisitOMPCopyinClauseEPKN5clang15OMPCopyinClauseE")
  //</editor-fold>
  public void VisitOMPCopyinClause(/*const*/ OMPCopyinClause /*P*/ C) {
    VisitOMPClauseList(C);
    for (/*const*/ Expr /*P*/ E : C.source_exprs$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
    for (/*const*/ Expr /*P*/ E : C.destination_exprs$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
    for (/*const*/ Expr /*P*/ E : C.assignment_ops$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPCopyprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 472,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPCopyprivateClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler25VisitOMPCopyprivateClauseEPKN5clang20OMPCopyprivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler25VisitOMPCopyprivateClauseEPKN5clang20OMPCopyprivateClauseE")
  //</editor-fold>
  public void VisitOMPCopyprivateClause(/*const*/ OMPCopyprivateClause /*P*/ C) {
    VisitOMPClauseList(C);
    for (/*const*/ Expr /*P*/ E : C.source_exprs$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
    for (/*const*/ Expr /*P*/ E : C.destination_exprs$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
    for (/*const*/ Expr /*P*/ E : C.assignment_ops$Const()) {
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPProcBindClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 321,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPProcBindClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler22VisitOMPProcBindClauseEPKN5clang17OMPProcBindClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler22VisitOMPProcBindClauseEPKN5clang17OMPProcBindClauseE")
  //</editor-fold>
  public void VisitOMPProcBindClause(/*const*/ OMPProcBindClause /*P*/ C) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPScheduleClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 323,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPScheduleClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler22VisitOMPScheduleClauseEPKN5clang17OMPScheduleClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler22VisitOMPScheduleClauseEPKN5clang17OMPScheduleClauseE")
  //</editor-fold>
  public void VisitOMPScheduleClause(/*const*/ OMPScheduleClause /*P*/ C) {
    VistOMPClauseWithPreInit(C);
    {
      /*const*/ Expr /*P*/ S = C.getChunkSize$Const();
      if ((S != null)) {
        Profiler.VisitStmt(S);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPOrderedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 329,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPOrderedClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler21VisitOMPOrderedClauseEPKN5clang16OMPOrderedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler21VisitOMPOrderedClauseEPKN5clang16OMPOrderedClauseE")
  //</editor-fold>
  public void VisitOMPOrderedClause(/*const*/ OMPOrderedClause /*P*/ C) {
    {
      Expr /*P*/ Num = C.getNumForLoops();
      if ((Num != null)) {
        Profiler.VisitStmt(Num);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPNowaitClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 334,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPNowaitClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler20VisitOMPNowaitClauseEPKN5clang15OMPNowaitClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler20VisitOMPNowaitClauseEPKN5clang15OMPNowaitClauseE")
  //</editor-fold>
  public void VisitOMPNowaitClause(/*const*/ OMPNowaitClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPUntiedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 336,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPUntiedClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler20VisitOMPUntiedClauseEPKN5clang15OMPUntiedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler20VisitOMPUntiedClauseEPKN5clang15OMPUntiedClauseE")
  //</editor-fold>
  public void VisitOMPUntiedClause(/*const*/ OMPUntiedClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPMergeableClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 338,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPMergeableClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler23VisitOMPMergeableClauseEPKN5clang18OMPMergeableClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler23VisitOMPMergeableClauseEPKN5clang18OMPMergeableClauseE")
  //</editor-fold>
  public void VisitOMPMergeableClause(/*const*/ OMPMergeableClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPFlushClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 488,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPFlushClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler19VisitOMPFlushClauseEPKN5clang14OMPFlushClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler19VisitOMPFlushClauseEPKN5clang14OMPFlushClauseE")
  //</editor-fold>
  public void VisitOMPFlushClause(/*const*/ OMPFlushClause /*P*/ C) {
    VisitOMPClauseList(C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPReadClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 340,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPReadClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler18VisitOMPReadClauseEPKN5clang13OMPReadClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler18VisitOMPReadClauseEPKN5clang13OMPReadClauseE")
  //</editor-fold>
  public void VisitOMPReadClause(/*const*/ OMPReadClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPWriteClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 342,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPWriteClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler19VisitOMPWriteClauseEPKN5clang14OMPWriteClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler19VisitOMPWriteClauseEPKN5clang14OMPWriteClauseE")
  //</editor-fold>
  public void VisitOMPWriteClause(/*const*/ OMPWriteClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPUpdateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 344,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPUpdateClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler20VisitOMPUpdateClauseEPKN5clang15OMPUpdateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler20VisitOMPUpdateClauseEPKN5clang15OMPUpdateClauseE")
  //</editor-fold>
  public void VisitOMPUpdateClause(/*const*/ OMPUpdateClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPCaptureClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 346,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPCaptureClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler21VisitOMPCaptureClauseEPKN5clang16OMPCaptureClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler21VisitOMPCaptureClauseEPKN5clang16OMPCaptureClauseE")
  //</editor-fold>
  public void VisitOMPCaptureClause(/*const*/ OMPCaptureClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPSeqCstClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 348,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPSeqCstClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler20VisitOMPSeqCstClauseEPKN5clang15OMPSeqCstClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler20VisitOMPSeqCstClauseEPKN5clang15OMPSeqCstClauseE")
  //</editor-fold>
  public void VisitOMPSeqCstClause(/*const*/ OMPSeqCstClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPDependClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 491,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPDependClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler20VisitOMPDependClauseEPKN5clang15OMPDependClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler20VisitOMPDependClauseEPKN5clang15OMPDependClauseE")
  //</editor-fold>
  public void VisitOMPDependClause(/*const*/ OMPDependClause /*P*/ C) {
    VisitOMPClauseList(C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPDeviceClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 494,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPDeviceClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler20VisitOMPDeviceClauseEPKN5clang15OMPDeviceClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler20VisitOMPDeviceClauseEPKN5clang15OMPDeviceClauseE")
  //</editor-fold>
  public void VisitOMPDeviceClause(/*const*/ OMPDeviceClause /*P*/ C) {
    if ((C.getDevice$Const() != null)) {
      Profiler.VisitStmt(C.getDevice$Const());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPThreadsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 350,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPThreadsClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler21VisitOMPThreadsClauseEPKN5clang16OMPThreadsClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler21VisitOMPThreadsClauseEPKN5clang16OMPThreadsClauseE")
  //</editor-fold>
  public void VisitOMPThreadsClause(/*const*/ OMPThreadsClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPSIMDClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 352,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPSIMDClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler18VisitOMPSIMDClauseEPKN5clang13OMPSIMDClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler18VisitOMPSIMDClauseEPKN5clang13OMPSIMDClauseE")
  //</editor-fold>
  public void VisitOMPSIMDClause(/*const*/ OMPSIMDClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPMapClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 498,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPMapClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler17VisitOMPMapClauseEPKN5clang12OMPMapClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler17VisitOMPMapClauseEPKN5clang12OMPMapClauseE")
  //</editor-fold>
  public void VisitOMPMapClause(/*const*/ OMPMapClause /*P*/ C) {
    VisitOMPClauseList(C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPNumTeamsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 501,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPNumTeamsClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler22VisitOMPNumTeamsClauseEPKN5clang17OMPNumTeamsClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler22VisitOMPNumTeamsClauseEPKN5clang17OMPNumTeamsClauseE")
  //</editor-fold>
  public void VisitOMPNumTeamsClause(/*const*/ OMPNumTeamsClause /*P*/ C) {
    if ((C.getNumTeams$Const() != null)) {
      Profiler.VisitStmt(C.getNumTeams$Const());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPThreadLimitClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 505,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPThreadLimitClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler25VisitOMPThreadLimitClauseEPKN5clang20OMPThreadLimitClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler25VisitOMPThreadLimitClauseEPKN5clang20OMPThreadLimitClauseE")
  //</editor-fold>
  public void VisitOMPThreadLimitClause(/*const*/ OMPThreadLimitClause /*P*/ C) {
    if ((C.getThreadLimit$Const() != null)) {
      Profiler.VisitStmt(C.getThreadLimit$Const());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPPriorityClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 510,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPPriorityClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler22VisitOMPPriorityClauseEPKN5clang17OMPPriorityClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler22VisitOMPPriorityClauseEPKN5clang17OMPPriorityClauseE")
  //</editor-fold>
  public void VisitOMPPriorityClause(/*const*/ OMPPriorityClause /*P*/ C) {
    if ((C.getPriority$Const() != null)) {
      Profiler.VisitStmt(C.getPriority$Const());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPGrainsizeClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 514,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPGrainsizeClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler23VisitOMPGrainsizeClauseEPKN5clang18OMPGrainsizeClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler23VisitOMPGrainsizeClauseEPKN5clang18OMPGrainsizeClauseE")
  //</editor-fold>
  public void VisitOMPGrainsizeClause(/*const*/ OMPGrainsizeClause /*P*/ C) {
    if ((C.getGrainsize() != null)) {
      Profiler.VisitStmt(C.getGrainsize());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPNogroupClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 354,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPNogroupClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler21VisitOMPNogroupClauseEPKN5clang16OMPNogroupClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler21VisitOMPNogroupClauseEPKN5clang16OMPNogroupClauseE")
  //</editor-fold>
  public void VisitOMPNogroupClause(/*const*/ OMPNogroupClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPNumTasksClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 518,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPNumTasksClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler22VisitOMPNumTasksClauseEPKN5clang17OMPNumTasksClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler22VisitOMPNumTasksClauseEPKN5clang17OMPNumTasksClauseE")
  //</editor-fold>
  public void VisitOMPNumTasksClause(/*const*/ OMPNumTasksClause /*P*/ C) {
    if ((C.getNumTasks() != null)) {
      Profiler.VisitStmt(C.getNumTasks());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPHintClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 522,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPHintClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler18VisitOMPHintClauseEPKN5clang13OMPHintClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler18VisitOMPHintClauseEPKN5clang13OMPHintClauseE")
  //</editor-fold>
  public void VisitOMPHintClause(/*const*/ OMPHintClause /*P*/ C) {
    if ((C.getHint() != null)) {
      Profiler.VisitStmt(C.getHint());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPDistScheduleClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 696,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPDistScheduleClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler26VisitOMPDistScheduleClauseEPKN5clang21OMPDistScheduleClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler26VisitOMPDistScheduleClauseEPKN5clang21OMPDistScheduleClauseE")
  //</editor-fold>
  public void VisitOMPDistScheduleClause(/*const*/ OMPDistScheduleClause /*P*/ C) {
    VistOMPClauseWithPreInit(C);
    {
      /*const*/ Expr /*P*/ S = C.getChunkSize$Const();
      if ((S != null)) {
        Profiler.VisitStmt(S);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPDefaultmapClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 703,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPDefaultmapClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler24VisitOMPDefaultmapClauseEPKN5clang19OMPDefaultmapClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler24VisitOMPDefaultmapClauseEPKN5clang19OMPDefaultmapClauseE")
  //</editor-fold>
  public void VisitOMPDefaultmapClause(/*const*/ OMPDefaultmapClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPToClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 526,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPToClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler16VisitOMPToClauseEPKN5clang11OMPToClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler16VisitOMPToClauseEPKN5clang11OMPToClauseE")
  //</editor-fold>
  public void VisitOMPToClause(/*const*/ OMPToClause /*P*/ C) {
    VisitOMPClauseList(C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPFromClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 529,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPFromClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler18VisitOMPFromClauseEPKN5clang13OMPFromClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler18VisitOMPFromClauseEPKN5clang13OMPFromClauseE")
  //</editor-fold>
  public void VisitOMPFromClause(/*const*/ OMPFromClause /*P*/ C) {
    VisitOMPClauseList(C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPUseDevicePtrClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 532,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPUseDevicePtrClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler26VisitOMPUseDevicePtrClauseEPKN5clang21OMPUseDevicePtrClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler26VisitOMPUseDevicePtrClauseEPKN5clang21OMPUseDevicePtrClauseE")
  //</editor-fold>
  public void VisitOMPUseDevicePtrClause(/*const*/ OMPUseDevicePtrClause /*P*/ C) {
    VisitOMPClauseList(C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VisitOMPIsDevicePtrClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 536,
   FQN="(anonymous namespace)::OMPClauseProfiler::VisitOMPIsDevicePtrClause", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler25VisitOMPIsDevicePtrClauseEPKN5clang20OMPIsDevicePtrClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler25VisitOMPIsDevicePtrClauseEPKN5clang20OMPIsDevicePtrClauseE")
  //</editor-fold>
  public void VisitOMPIsDevicePtrClause(/*const*/ OMPIsDevicePtrClause /*P*/ C) {
    VisitOMPClauseList(C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VistOMPClauseWithPreInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 276,
   FQN="(anonymous namespace)::OMPClauseProfiler::VistOMPClauseWithPreInit", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler24VistOMPClauseWithPreInitEPKN5clang20OMPClauseWithPreInitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler24VistOMPClauseWithPreInitEPKN5clang20OMPClauseWithPreInitE")
  //</editor-fold>
  public void VistOMPClauseWithPreInit(/*const*/ OMPClauseWithPreInit /*P*/ C) {
    {
      /*const*/ Stmt /*P*/ S = C.getPreInitStmt$Const();
      if ((S != null)) {
        Profiler.VisitStmt(S);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OMPClauseProfiler::VistOMPClauseWithPostUpdate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 282,
   FQN="(anonymous namespace)::OMPClauseProfiler::VistOMPClauseWithPostUpdate", NM="_ZN12_GLOBAL__N_117OMPClauseProfiler27VistOMPClauseWithPostUpdateEPKN5clang23OMPClauseWithPostUpdateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_117OMPClauseProfiler27VistOMPClauseWithPostUpdateEPKN5clang23OMPClauseWithPostUpdateE")
  //</editor-fold>
  public void VistOMPClauseWithPostUpdate(/*const*/ OMPClauseWithPostUpdate /*P*/ C) {
    VistOMPClauseWithPreInit(C);
    {
      /*const*/ Expr /*P*/ E = C.getPostUpdateExpr$Const();
      if ((E != null)) {
        Profiler.VisitStmt(E);
      }
    }
  }

  
  @Override public String toString() {
    return "" + "Profiler=" + Profiler // NOI18N
              + super.toString(); // NOI18N
  }
}
