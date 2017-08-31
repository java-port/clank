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
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.core.StaticanalyzerClangGlobals.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BugHashDumper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 221,
 FQN="(anonymous namespace)::BugHashDumper", NM="_ZN12_GLOBAL__N_113BugHashDumperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN12_GLOBAL__N_113BugHashDumperE")
//</editor-fold>
public class BugHashDumper extends /*public*/ Checker/*T<org.clang.staticanalyzer.core.ento.check.PostStmt<Stmt> > */
        implements org.clang.staticanalyzer.java.PostStmtChecker, Destructors.ClassWithDestructor {
/*public:*/
  public /*mutable */std.unique_ptr<BugType> BT;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BugHashDumper::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 225,
   FQN="(anonymous namespace)::BugHashDumper::checkPostStmt", NM="_ZNK12_GLOBAL__N_113BugHashDumper13checkPostStmtEPKN5clang4StmtERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZNK12_GLOBAL__N_113BugHashDumper13checkPostStmtEPKN5clang4StmtERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ Stmt /*P*/ S, final CheckerContext /*&*/ C) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!BT.$bool()) {
        BT.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Dump hash components"), new StringRef(/*KEEP_STR*/"debug")));
      }
      
      ExplodedNode /*P*/ N = C.generateNonFatalErrorNode();
      if (!(N != null)) {
        return;
      }
      
      final /*const*/ LangOptions /*&*/ Opts = C.getLangOpts();
      final /*const*/ SourceManager /*&*/ SM = C.getSourceManager();
      FullSourceLoc FL/*J*/= new FullSourceLoc(S.getLocStart(), SM);
      std.string HashContent = GetIssueString(SM, FL, getCheckName().getName(), BT.$arrow().getCategory(), 
          C.getLocationContext().getDecl(), Opts);
      
      C.emitReport($c$.track(llvm.make_unique(new BugReport(BT.$star(), new StringRef(HashContent), N)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BugHashDumper::~BugHashDumper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 221,
   FQN="(anonymous namespace)::BugHashDumper::~BugHashDumper", NM="_ZN12_GLOBAL__N_113BugHashDumperD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN12_GLOBAL__N_113BugHashDumperD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BugHashDumper::BugHashDumper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 221,
   FQN="(anonymous namespace)::BugHashDumper::BugHashDumper", NM="_ZN12_GLOBAL__N_113BugHashDumperC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN12_GLOBAL__N_113BugHashDumperC1Ev")
  //</editor-fold>
  public /*inline*/ BugHashDumper() {
    // : Checker<PostStmt<Stmt> >(), BT() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BugType>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public void $checkPostStmt(Stmt stmt, CheckerContext C) { checkPostStmt(stmt, C); }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PostStmt<Stmt>(Stmt.class)
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT=" + BT // NOI18N
              + super.toString(); // NOI18N
  }
}
