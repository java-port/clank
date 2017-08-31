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
import static org.clang.staticanalyzer.checkers.impl.UndefCapturedBlockVarCheckerStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefCapturedBlockVarChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefCapturedBlockVarChecker.cpp", line = 28,
 FQN="(anonymous namespace)::UndefCapturedBlockVarChecker", NM="_ZN12_GLOBAL__N_128UndefCapturedBlockVarCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefCapturedBlockVarChecker.cpp -nm=_ZN12_GLOBAL__N_128UndefCapturedBlockVarCheckerE")
//</editor-fold>
public class UndefCapturedBlockVarChecker extends /*public*/ Checker/*T<PostStmt<BlockExpr> > */
        implements org.clang.staticanalyzer.java.PostStmtChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BugType> BT;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefCapturedBlockVarChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefCapturedBlockVarChecker.cpp", line = 51,
   FQN="(anonymous namespace)::UndefCapturedBlockVarChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_128UndefCapturedBlockVarChecker13checkPostStmtEPKN5clang9BlockExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefCapturedBlockVarChecker.cpp -nm=_ZNK12_GLOBAL__N_128UndefCapturedBlockVarChecker13checkPostStmtEPKN5clang9BlockExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ BlockExpr /*P*/ BE, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    try {
      if (!BE.getBlockDecl$Const().hasCaptures()) {
        return;
      }

      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ BlockDataRegion /*P*/ R = cast_BlockDataRegion(state.$arrow().getSVal(BE, 
      C.getLocationContext()).getAsRegion());

      BlockDataRegion.referenced_vars_iterator I = R.referenced_vars_begin();
      BlockDataRegion.referenced_vars_iterator E = R.referenced_vars_end();

      for (; I.$noteq(E); I.$preInc()) {
        // This VarRegion is the region associated with the block; we need
        // the one associated with the encompassing context.
        /*const*/ VarRegion /*P*/ VR = I.getCapturedRegion();
        /*const*/ VarDecl /*P*/ VD = VR.getDecl();
        if (VD.hasAttr(BlocksAttr.class) || !VD.hasLocalStorage()) {
          continue;
        }
        {

          // Get the VarRegion associated with VD in the local stack frame.
          Optional<UndefinedVal> V = state.$arrow().getSVal(I.getOriginalRegion()).getAs(UndefinedVal.class);
          if (V.$bool()) {
            {
              ExplodedNode /*P*/ N = C.generateErrorNode();
              if ((N != null)) {
                raw_svector_ostream os = null;
                unique_ptr<BugReport> R$1 = null;
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  if (!BT.$bool()) {
                    BT.reset(new BuiltinBug(this, $("uninitialized variable captured by block")));
                  }

                  // Generate a bug report.
                  SmallString/*<128>*/ buf/*J*/= new SmallString/*<128>*/(128);
                  os/*J*/= new raw_svector_ostream(buf);

                  os.$out(/*KEEP_STR*/"Variable '").$out(VD.getName()).$out(
                      /*KEEP_STR*/"' is uninitialized when captured by block"
                  );

                  R$1 = llvm.make_unique(new BugReport(BT.$star(), os.str(), N));
                  {
                    /*const*/ Expr /*P*/ Ex = UndefCapturedBlockVarCheckerStatics.FindBlockDeclRefExpr(BE.getBody$Const(), VD);
                    if ((Ex != null)) {
                      R$1.$arrow().addRange(Ex.getSourceRange());
                    }
                  }
                  R$1.$arrow().addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new FindLastStoreBRVisitor(new KnownSVal(V.$star()), VR, /*EnableNullFPSuppression*/ false)))))); $c$.clean();
                  R$1.$arrow().disablePathPruning();
                  // need location of block
                  C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R$1)))); $c$.clean();
                } finally {
                  if (R$1 != null) { R$1.$destroy(); }
                  if (os != null) { os.$destroy(); }
                  $c$.$destroy();
                }
              }
            }
          }
        }
      }
    } finally {
     if (state != null) { state.$destroy(); }
    } 
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefCapturedBlockVarChecker::~UndefCapturedBlockVarChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefCapturedBlockVarChecker.cpp", line = 28,
   FQN="(anonymous namespace)::UndefCapturedBlockVarChecker::~UndefCapturedBlockVarChecker", NM="_ZN12_GLOBAL__N_128UndefCapturedBlockVarCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefCapturedBlockVarChecker.cpp -nm=_ZN12_GLOBAL__N_128UndefCapturedBlockVarCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefCapturedBlockVarChecker::UndefCapturedBlockVarChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefCapturedBlockVarChecker.cpp", line = 28,
   FQN="(anonymous namespace)::UndefCapturedBlockVarChecker::UndefCapturedBlockVarChecker", NM="_ZN12_GLOBAL__N_128UndefCapturedBlockVarCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefCapturedBlockVarChecker.cpp -nm=_ZN12_GLOBAL__N_128UndefCapturedBlockVarCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ UndefCapturedBlockVarChecker() {
    // : Checker<PostStmt<BlockExpr> >(), BT() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BugType>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPostStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof BlockExpr) {
      checkPostStmt((BlockExpr) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PostStmt<BlockExpr>(BlockExpr.class)
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
