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

package org.clang.staticanalyzer.checkers.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivisionBRVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 58,
 FQN="(anonymous namespace)::DivisionBRVisitor", NM="_ZN12_GLOBAL__N_117DivisionBRVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZN12_GLOBAL__N_117DivisionBRVisitorE")
//</editor-fold>
public class DivisionBRVisitor extends /*public*/ BugReporterVisitorImpl<DivisionBRVisitor> implements Destructors.ClassWithDestructor {
/*private:*/
  private /*const*/ SymExpr /*P*/ ZeroSymbol;
  private /*const*/ StackFrameContext /*P*/ SFC;
  private boolean Satisfied;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivisionBRVisitor::DivisionBRVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 65,
   FQN="(anonymous namespace)::DivisionBRVisitor::DivisionBRVisitor", NM="_ZN12_GLOBAL__N_117DivisionBRVisitorC1EPKN5clang4ento7SymExprEPKNS1_17StackFrameContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZN12_GLOBAL__N_117DivisionBRVisitorC1EPKN5clang4ento7SymExprEPKNS1_17StackFrameContextE")
  //</editor-fold>
  public DivisionBRVisitor(/*const*/ SymExpr /*P*/ ZeroSymbol, /*const*/ StackFrameContext /*P*/ SFC) {
    // : BugReporterVisitorImpl<DivisionBRVisitor>(), ZeroSymbol(ZeroSymbol), SFC(SFC), Satisfied(false) 
    //START JInit
    super();
    this.ZeroSymbol = ZeroSymbol;
    this.SFC = SFC;
    this.Satisfied = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivisionBRVisitor::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 68,
   FQN="(anonymous namespace)::DivisionBRVisitor::Profile", NM="_ZNK12_GLOBAL__N_117DivisionBRVisitor7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZNK12_GLOBAL__N_117DivisionBRVisitor7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    ID.Add(ZeroSymbol);
    ID.Add(SFC);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivisionBRVisitor::VisitNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 97,
   FQN="(anonymous namespace)::DivisionBRVisitor::VisitNode", NM="_ZN12_GLOBAL__N_117DivisionBRVisitor9VisitNodeEPKN5clang4ento12ExplodedNodeES5_RNS2_18BugReporterContextERNS2_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZN12_GLOBAL__N_117DivisionBRVisitor9VisitNodeEPKN5clang4ento12ExplodedNodeES5_RNS2_18BugReporterContextERNS2_9BugReportE")
  //</editor-fold>
  @Override public PathDiagnosticPiece /*P*/ VisitNode(/*const*/ ExplodedNode /*P*/ Succ, 
           /*const*/ ExplodedNode /*P*/ Pred, 
           final BugReporterContext /*&*/ BRC, 
           final BugReport /*&*/ BR)/* override*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      if (Satisfied) {
        return null;
      }
      
      /*const*/ Expr /*P*/ E = null;
      {
        
        Optional<org.clang.analysis.PostStmt> P = Succ.<org.clang.analysis.PostStmt>getLocationAs(org.clang.analysis.PostStmt.class);
        if (P.$bool()) {
          {
            /*const*/ BinaryOperator /*P*/ BO = P.$arrow().<BinaryOperator>getStmtAs(BinaryOperator.class);
            if ((BO != null)) {
              BinaryOperatorKind Op = BO.getOpcode();
              if (Op == BinaryOperatorKind.BO_Div || Op == BinaryOperatorKind.BO_Rem || Op == BinaryOperatorKind.BO_DivAssign
                 || Op == BinaryOperatorKind.BO_RemAssign) {
                E = BO.getRHS();
              }
            }
          }
        }
      }
      if (!(E != null)) {
        return null;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Succ.getState());
      SVal S = State.$arrow().getSVal(E, Succ.getLocationContext());
      if (ZeroSymbol == S.getAsSymbol() && SFC == Succ.getStackFrame()) {
        Satisfied = true;
        
        // Construct a new PathDiagnosticPiece.
        ProgramPoint P = Succ.getLocation();
        PathDiagnosticLocation L = PathDiagnosticLocation.create(P, BRC.getSourceManager());
        if (!L.isValid() || !L.asLocation().isValid()) {
          return null;
        }
        
        return new PathDiagnosticEventPiece(L, new StringRef(/*KEEP_STR*/"Division with compared value made here"));
      }
      
      return null;
    } finally {
      if (State != null) { State.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivisionBRVisitor::~DivisionBRVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 58,
   FQN="(anonymous namespace)::DivisionBRVisitor::~DivisionBRVisitor", NM="_ZN12_GLOBAL__N_117DivisionBRVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZN12_GLOBAL__N_117DivisionBRVisitorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivisionBRVisitor::DivisionBRVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 58,
   FQN="(anonymous namespace)::DivisionBRVisitor::DivisionBRVisitor", NM="_ZN12_GLOBAL__N_117DivisionBRVisitorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZN12_GLOBAL__N_117DivisionBRVisitorC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DivisionBRVisitor(final /*const*/ DivisionBRVisitor /*&*/ $Prm0) {
    // : BugReporterVisitorImpl<DivisionBRVisitor>(), ZeroSymbol(.ZeroSymbol), SFC(.SFC), Satisfied(.Satisfied) 
    //START JInit
    super($Prm0);
    this.ZeroSymbol = $Prm0.ZeroSymbol;
    this.SFC = $Prm0.SFC;
    this.Satisfied = $Prm0.Satisfied;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public DivisionBRVisitor clone() {
    return new DivisionBRVisitor(this);
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "ZeroSymbol=" + "[SymExpr]" // NOI18N
              + ", SFC=" + "[StackFrameContext]" // NOI18N
              + ", Satisfied=" + Satisfied // NOI18N
              + super.toString(); // NOI18N
  }
}
