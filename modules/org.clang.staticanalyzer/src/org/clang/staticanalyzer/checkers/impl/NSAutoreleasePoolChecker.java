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
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.AstClangGlobals.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NSAutoreleasePoolChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSAutoreleasePoolChecker.cpp", line = 33,
 FQN="(anonymous namespace)::NSAutoreleasePoolChecker", NM="_ZN12_GLOBAL__N_124NSAutoreleasePoolCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSAutoreleasePoolChecker.cpp -nm=_ZN12_GLOBAL__N_124NSAutoreleasePoolCheckerE")
//</editor-fold>
public class NSAutoreleasePoolChecker extends /*public*/ Checker/*T<PreObjCMessage> */
        implements org.clang.staticanalyzer.java.PreObjCMessageChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BugType> BT;
  private /*mutable */Selector releaseS;
/*public:*/
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NSAutoreleasePoolChecker::checkPreObjCMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSAutoreleasePoolChecker.cpp", line = 44,
   FQN="(anonymous namespace)::NSAutoreleasePoolChecker::checkPreObjCMessage", NM="_ZNK12_GLOBAL__N_124NSAutoreleasePoolChecker19checkPreObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSAutoreleasePoolChecker.cpp -nm=_ZNK12_GLOBAL__N_124NSAutoreleasePoolChecker19checkPreObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreObjCMessage(final /*const*/ ObjCMethodCall /*&*/ msg, 
                     final CheckerContext /*&*/ C) /*const*/ {
    unique_ptr<BugReport> Report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!msg.isInstanceMessage()) {
        return;
      }
      
      /*const*/ ObjCInterfaceDecl /*P*/ OD = msg.getReceiverInterface();
      if (!(OD != null)) {
        return;
      }
      if (!OD.getIdentifier().isStr(/*KEEP_STR*/"NSAutoreleasePool")) {
        return;
      }
      if (releaseS.isNull()) {
        releaseS.$assignMove(GetNullarySelector(new StringRef(/*KEEP_STR*/"release"), C.getASTContext()));
      }
      // Sending 'release' message?
      if (msg.getSelector().$noteq(/*NO_COPY*/releaseS)) {
        return;
      }
      if (!BT.$bool()) {
        BT.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Use -drain instead of -release"), 
                new StringRef(/*KEEP_STR*/"API Upgrade (Apple)")));
      }
      
      ExplodedNode /*P*/ N = C.generateNonFatalErrorNode();
      if (!(N != null)) {
        assert Native.$bool(0);
        return;
      }
      
      Report = llvm.make_unique(new BugReport(BT.$star(), $("Use -drain instead of -release when using NSAutoreleasePool and garbage collection"), N));
      Report.$arrow().addRange(msg.getSourceRange());
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(Report)))); $c$.clean();
    } finally {
      if (Report != null) { Report.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NSAutoreleasePoolChecker::~NSAutoreleasePoolChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSAutoreleasePoolChecker.cpp", line = 33,
   FQN="(anonymous namespace)::NSAutoreleasePoolChecker::~NSAutoreleasePoolChecker", NM="_ZN12_GLOBAL__N_124NSAutoreleasePoolCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSAutoreleasePoolChecker.cpp -nm=_ZN12_GLOBAL__N_124NSAutoreleasePoolCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NSAutoreleasePoolChecker::NSAutoreleasePoolChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSAutoreleasePoolChecker.cpp", line = 33,
   FQN="(anonymous namespace)::NSAutoreleasePoolChecker::NSAutoreleasePoolChecker", NM="_ZN12_GLOBAL__N_124NSAutoreleasePoolCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSAutoreleasePoolChecker.cpp -nm=_ZN12_GLOBAL__N_124NSAutoreleasePoolCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ NSAutoreleasePoolChecker() {
    // : Checker<PreObjCMessage>(), BT(), releaseS() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BugType>();
    this.releaseS = new Selector();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new PreObjCMessage()
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT=" + BT // NOI18N
              + ", releaseS=" + releaseS // NOI18N
              + super.toString(); // NOI18N
  }
}
