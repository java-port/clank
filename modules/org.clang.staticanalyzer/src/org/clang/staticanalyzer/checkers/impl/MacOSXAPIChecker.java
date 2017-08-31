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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerMemberPointers.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSXAPIChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSXAPIChecker.cpp", line = 33,
 FQN="(anonymous namespace)::MacOSXAPIChecker", NM="_ZN12_GLOBAL__N_116MacOSXAPICheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSXAPIChecker.cpp -nm=_ZN12_GLOBAL__N_116MacOSXAPICheckerE")
//</editor-fold>
public class MacOSXAPIChecker extends /*public*/ Checker/*T<PreStmt<CallExpr> > */
        implements org.clang.staticanalyzer.java.PreStmtChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BugType> BT_dispatchOnce;
/*public:*/

  //===----------------------------------------------------------------------===//
  // Central dispatch function.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSXAPIChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSXAPIChecker.cpp", line = 104,
   FQN="(anonymous namespace)::MacOSXAPIChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_116MacOSXAPIChecker12checkPreStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSXAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_116MacOSXAPIChecker12checkPreStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ CallExpr /*P*/ CE, 
              final CheckerContext /*&*/ C) /*const*/ {
    StringRef Name = C.getCalleeName(CE);
    if (Name.empty()) {
      return;
    }
    
    MacOSXAPIChecker$SubChecker SC = new StringSwitch<MacOSXAPIChecker$SubChecker>(/*NO_COPY*/Name).
        Cases(/*KEEP_STR*/"dispatch_once", 
        /*KEEP_STR*/"_dispatch_once", 
        /*KEEP_STR*/"dispatch_once_f", 
        /*AddrOf*//*FPtr*/MacOSXAPIChecker::CheckDispatchOnce).
        Default((MacOSXAPIChecker$SubChecker)null);
    if ((SC != null)) {
      SC.$call(/*PtrMemI*/this, C, CE, new StringRef(Name));
    }
  }

  
  //end anonymous namespace
  
  //===----------------------------------------------------------------------===//
  // dispatch_once and dispatch_once_f
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSXAPIChecker::CheckDispatchOnce">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSXAPIChecker.cpp", line = 52,
   FQN="(anonymous namespace)::MacOSXAPIChecker::CheckDispatchOnce", NM="_ZNK12_GLOBAL__N_116MacOSXAPIChecker17CheckDispatchOnceERN5clang4ento14CheckerContextEPKNS1_8CallExprEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSXAPIChecker.cpp -nm=_ZNK12_GLOBAL__N_116MacOSXAPIChecker17CheckDispatchOnceERN5clang4ento14CheckerContextEPKNS1_8CallExprEN4llvm9StringRefE")
  //</editor-fold>
  public void CheckDispatchOnce(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE, 
                   StringRef FName) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    raw_svector_ostream os = null;
    unique_ptr<BugReport> report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if ($less_uint(CE.getNumArgs(), 1)) {
        return;
      }
      
      // Check if the first argument is stack allocated.  If so, issue a warning
      // because that's likely to be bad news.
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ MemRegion /*P*/ R = state.$arrow().getSVal(CE.getArg$Const(0), C.getLocationContext()).getAsRegion();
      if (!(R != null) || !isa_StackSpaceRegion(R.getMemorySpace())) {
        return;
      }
      
      ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
      if (!(N != null)) {
        return;
      }
      if (!BT_dispatchOnce.$bool()) {
        BT_dispatchOnce.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Improper use of 'dispatch_once'"), 
                new StringRef(/*KEEP_STR*/"API Misuse (Apple)")));
      }
      
      // Handle _dispatch_once.  In some versions of the OS X SDK we have the case
      // that dispatch_once is a macro that wraps a call to _dispatch_once.
      // _dispatch_once is then a function which then calls the real dispatch_once.
      // Users do not care; they just want the warning at the top-level call.
      if (CE.getLocStart().isMacroID()) {
        StringRef TrimmedFName = FName.ltrim($$UNDERSCORE);
        if ($noteq_StringRef(/*NO_COPY*/TrimmedFName, /*NO_COPY*/FName)) {
          FName.$assign(TrimmedFName);
        }
      }
      
      SmallString/*<256>*/ S/*J*/= new SmallString/*<256>*/(256);
      os/*J*/= new raw_svector_ostream(S);
      os.$out(/*KEEP_STR*/"Call to '").$out(/*NO_COPY*/FName).$out(/*KEEP_STR*/"' uses");
      {
        /*const*/ VarRegion /*P*/ VR = dyn_cast_VarRegion(R);
        if ((VR != null)) {
          os.$out(/*KEEP_STR*/" the local variable '").$out(VR.getDecl().getName()).$out_char($$SGL_QUOTE);
        } else {
          os.$out(/*KEEP_STR*/" stack allocated memory");
        }
      }
      os.$out(/*KEEP_STR*/" for the predicate value.  Using such transient memory for the predicate is potentially dangerous.");
      if (isa_VarRegion(R) && isa_StackLocalsSpaceRegion(R.getMemorySpace())) {
        os.$out(/*KEEP_STR*/"  Perhaps you intended to declare the variable as 'static'?");
      }
      
      report = llvm.make_unique(new BugReport(BT_dispatchOnce.$star(), os.str(), N));
      report.$arrow().addRange(CE.getArg$Const(0).getSourceRange());
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
    } finally {
      if (report != null) { report.$destroy(); }
      if (os != null) { os.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  
  // JAVA: typedef void (MacOSXAPIChecker::*SubChecker)(CheckerContext &, const CallExpr *, StringRef) const
//  public final class SubChecker extends MacOSXAPIChecker$SubChecker{ };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSXAPIChecker::~MacOSXAPIChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSXAPIChecker.cpp", line = 33,
   FQN="(anonymous namespace)::MacOSXAPIChecker::~MacOSXAPIChecker", NM="_ZN12_GLOBAL__N_116MacOSXAPICheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSXAPIChecker.cpp -nm=_ZN12_GLOBAL__N_116MacOSXAPICheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT_dispatchOnce.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MacOSXAPIChecker::MacOSXAPIChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSXAPIChecker.cpp", line = 33,
   FQN="(anonymous namespace)::MacOSXAPIChecker::MacOSXAPIChecker", NM="_ZN12_GLOBAL__N_116MacOSXAPICheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSXAPIChecker.cpp -nm=_ZN12_GLOBAL__N_116MacOSXAPICheckerC1Ev")
  //</editor-fold>
  public /*inline*/ MacOSXAPIChecker() {
    // : Checker<PreStmt<CallExpr> >(), BT_dispatchOnce() 
    //START JInit
    super();
    this.BT_dispatchOnce = new std.unique_ptr<BugType>();
    //END JInit
   }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPreStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof CallExpr) {
      checkPreStmt((CallExpr) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PreStmt<CallExpr>(CallExpr.class)
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT_dispatchOnce=" + BT_dispatchOnce // NOI18N
              + super.toString(); // NOI18N
  }
}
