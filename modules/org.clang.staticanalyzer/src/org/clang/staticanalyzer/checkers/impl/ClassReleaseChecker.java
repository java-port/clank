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
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.AstClangGlobals.*;
import org.clang.staticanalyzer.java.CheckBase;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClassReleaseChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 623,
 FQN="(anonymous namespace)::ClassReleaseChecker", NM="_ZN12_GLOBAL__N_119ClassReleaseCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_119ClassReleaseCheckerE")
//</editor-fold>
public class ClassReleaseChecker extends /*public*/ Checker/*T<PreObjCMessage>*/ 
        implements org.clang.staticanalyzer.java.PreObjCMessageChecker, Destructors.ClassWithDestructor {
  private /*mutable */Selector releaseS;
  private /*mutable */Selector retainS;
  private /*mutable */Selector autoreleaseS;
  private /*mutable */Selector drainS;
  private /*mutable */std.unique_ptr<BugType> BT;
/*public:*/
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClassReleaseChecker::checkPreObjCMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 635,
   FQN="(anonymous namespace)::ClassReleaseChecker::checkPreObjCMessage", NM="_ZNK12_GLOBAL__N_119ClassReleaseChecker19checkPreObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_119ClassReleaseChecker19checkPreObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreObjCMessage(final /*const*/ ObjCMethodCall /*&*/ msg, 
                     final CheckerContext /*&*/ C) /*const*/ {
    if (!BT.$bool()) {
      BT.reset(new APIMisuse(this, $("message incorrectly sent to class instead of class instance")));
      
      final ASTContext /*&*/ Ctx = C.getASTContext();
      releaseS.$assignMove(GetNullarySelector(new StringRef(/*KEEP_STR*/"release"), Ctx));
      retainS.$assignMove(GetNullarySelector(new StringRef(/*KEEP_STR*/"retain"), Ctx));
      autoreleaseS.$assignMove(GetNullarySelector(new StringRef(/*KEEP_STR*/"autorelease"), Ctx));
      drainS.$assignMove(GetNullarySelector(new StringRef(/*KEEP_STR*/"drain"), Ctx));
    }
    if (msg.isInstanceMessage()) {
      return;
    }
    /*const*/ ObjCInterfaceDecl /*P*/ Class = msg.getReceiverInterface();
    assert Native.$bool(Class);
    
    Selector S = msg.getSelector();
    if (!(S.$eq(/*NO_COPY*/releaseS) || S.$eq(/*NO_COPY*/retainS) || S.$eq(/*NO_COPY*/autoreleaseS) || S.$eq(/*NO_COPY*/drainS))) {
      return;
    }
    {
      
      ExplodedNode /*P*/ N = C.generateNonFatalErrorNode();
      if ((N != null)) {
        raw_svector_ostream os = null;
        unique_ptr<BugReport> report = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SmallString/*200*/ buf/*J*/= new SmallString/*200*/(200);
          os/*J*/= new raw_svector_ostream(buf);
          
          os.$out(/*KEEP_STR*/"The '");
          S.print(os);
          os.$out(/*KEEP_STR*/"' message should be sent to instances of class '").$out(Class.getName()).$out(
              /*KEEP_STR*/"' and not the class directly"
          );
          
          report = llvm.make_unique(new BugReport(BT.$star(), os.str(), N));
          report.$arrow().addRange(msg.getSourceRange());
          C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
        } finally {
          if (report != null) { report.$destroy(); }
          if (os != null) { os.$destroy(); }
          $c$.$destroy();
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClassReleaseChecker::~ClassReleaseChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 623,
   FQN="(anonymous namespace)::ClassReleaseChecker::~ClassReleaseChecker", NM="_ZN12_GLOBAL__N_119ClassReleaseCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_119ClassReleaseCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClassReleaseChecker::ClassReleaseChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 623,
   FQN="(anonymous namespace)::ClassReleaseChecker::ClassReleaseChecker", NM="_ZN12_GLOBAL__N_119ClassReleaseCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_119ClassReleaseCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ ClassReleaseChecker() {
    // : Checker<PreObjCMessage>(), releaseS(), retainS(), autoreleaseS(), drainS(), BT() 
    //START JInit
    super();
    this.releaseS = new Selector();
    this.retainS = new Selector();
    this.autoreleaseS = new Selector();
    this.drainS = new Selector();
    this.BT = new std.unique_ptr<BugType>();
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
    return "" + "releaseS=" + releaseS // NOI18N
              + ", retainS=" + retainS // NOI18N
              + ", autoreleaseS=" + autoreleaseS // NOI18N
              + ", drainS=" + drainS // NOI18N
              + ", BT=" + BT // NOI18N
              + super.toString(); // NOI18N
  }
}
