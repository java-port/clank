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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnPointerRangeChecker">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnPointerRangeChecker.cpp", line = 26,
 FQN="(anonymous namespace)::ReturnPointerRangeChecker", NM="_ZN12_GLOBAL__N_125ReturnPointerRangeCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnPointerRangeChecker.cpp -nm=_ZN12_GLOBAL__N_125ReturnPointerRangeCheckerE")
//</editor-fold>
public class ReturnPointerRangeChecker extends /*public*/ Checker/*T<PreStmt<ReturnStmt> > */
        implements org.clang.staticanalyzer.java.PreStmtChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BuiltinBug> BT;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnPointerRangeChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnPointerRangeChecker.cpp", line = 35,
   FQN="(anonymous namespace)::ReturnPointerRangeChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_125ReturnPointerRangeChecker12checkPreStmtEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnPointerRangeChecker.cpp -nm=_ZNK12_GLOBAL__N_125ReturnPointerRangeChecker12checkPreStmtEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ ReturnStmt /*P*/ RS, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> StInBound = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> StOutBound = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      /*const*/ Expr /*P*/ RetE = RS.getRetValue$Const();
      if (!(RetE != null)) {
        return;
      }
      
      SVal V = state.$arrow().getSVal(RetE, C.getLocationContext());
      /*const*/ MemRegion /*P*/ R = V.getAsRegion();
      
      /*const*/ ElementRegion /*P*/ ER = dyn_cast_or_null_ElementRegion(R);
      if (!(ER != null)) {
        return;
      }
      
      DefinedOrUnknownSVal Idx = ER.getIndex().castAs(DefinedOrUnknownSVal.class);
      // Zero index is always in bound, this also passes ElementRegions created for
      // pointer casts.
      if (Idx.isZeroConstant()) {
        return;
      }
      // FIXME: All of this out-of-bounds checking should eventually be refactored
      // into a common place.
      DefinedOrUnknownSVal NumElements = $c$.clean(C.getStoreManager().getSizeInElements($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), ER.getSuperRegion(), 
          ER.getValueType()));
      
      StInBound = state.$arrow().assumeInBound(new DefinedOrUnknownSVal(Idx), new DefinedOrUnknownSVal(NumElements), true);
      StOutBound = state.$arrow().assumeInBound(new DefinedOrUnknownSVal(Idx), new DefinedOrUnknownSVal(NumElements), false);
      if (StOutBound.$bool() && !StInBound.$bool()) {
        unique_ptr<BugReport> report = null;
        try {
          ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StOutBound))));
          if (!(N != null)) {
            return;
          }
          
          // FIXME: This bug correspond to CWE-466.  Eventually we should have bug
          // types explicitly reference such exploit categories (when applicable).
          if (!BT.$bool()) {
            BT.reset(new BuiltinBug(this, $("Return of pointer value outside of expected range"), 
                    $("Returned pointer value points outside the original object (potential buffer overflow)")));
          }
          
          // FIXME: It would be nice to eventually make this diagnostic more clear,
          // e.g., by referencing the original declaration or by saying *why* this
          // reference is outside the range.
          
          // Generate a report for this bug.
          report = llvm.make_unique(new BugReport(BT.$star(), BT.$arrow().getDescription(), N));
          
          report.$arrow().addRange(RetE.getSourceRange());
          C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
        } finally {
          if (report != null) { report.$destroy(); }
        }
      }
    } finally {
      if (StOutBound != null) { StOutBound.$destroy(); }
      if (StInBound != null) { StInBound.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnPointerRangeChecker::~ReturnPointerRangeChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnPointerRangeChecker.cpp", line = 26,
   FQN="(anonymous namespace)::ReturnPointerRangeChecker::~ReturnPointerRangeChecker", NM="_ZN12_GLOBAL__N_125ReturnPointerRangeCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnPointerRangeChecker.cpp -nm=_ZN12_GLOBAL__N_125ReturnPointerRangeCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnPointerRangeChecker::ReturnPointerRangeChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnPointerRangeChecker.cpp", line = 26,
   FQN="(anonymous namespace)::ReturnPointerRangeChecker::ReturnPointerRangeChecker", NM="_ZN12_GLOBAL__N_125ReturnPointerRangeCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnPointerRangeChecker.cpp -nm=_ZN12_GLOBAL__N_125ReturnPointerRangeCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ ReturnPointerRangeChecker() {
    // : Checker<PreStmt<ReturnStmt> >(), BT() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BuiltinBug>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPreStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof ReturnStmt) {
      checkPreStmt((ReturnStmt) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PreStmt<ReturnStmt>(ReturnStmt.class)
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT=" + BT // NOI18N
              + super.toString(); // NOI18N
  }
}
