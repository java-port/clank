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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.*;
import static org.clang.ast.java.AstStatementsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TraversalDumper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp", line = 27,
 FQN="(anonymous namespace)::TraversalDumper", NM="_ZN12_GLOBAL__N_115TraversalDumperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp -nm=_ZN12_GLOBAL__N_115TraversalDumperE")
//</editor-fold>
public class TraversalDumper extends /*public*/ Checker/*<BranchCondition, BeginFunction, EndFunction>*/ 
        implements org.clang.staticanalyzer.java.BeginFunctionChecker, org.clang.staticanalyzer.java.EndFunctionChecker, org.clang.staticanalyzer.java.BranchConditionChecker, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TraversalDumper::checkBranchCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp", line = 37,
   FQN="(anonymous namespace)::TraversalDumper::checkBranchCondition", NM="_ZNK12_GLOBAL__N_115TraversalDumper20checkBranchConditionEPKN5clang4StmtERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp -nm=_ZNK12_GLOBAL__N_115TraversalDumper20checkBranchConditionEPKN5clang4StmtERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkBranchCondition(/*const*/ Stmt /*P*/ Condition, 
                      final CheckerContext /*&*/ C) /*const*/ {
    // Special-case Objective-C's for-in loop, which uses the entire loop as its
    // condition. We just print the collection expression.
    /*const*/ Stmt /*P*/ Parent = dyn_cast_ObjCForCollectionStmt(Condition);
    if (!(Parent != null)) {
      final /*const*/ ParentMap /*&*/ Parents = C.getLocationContext().getParentMap();
      Parent = Parents.getParent_Stmt$C$P(Condition);
    }
    
    // It is mildly evil to print directly to llvm::outs() rather than emitting
    // warnings, but this ensures things do not get filtered out by the rest of
    // the static analyzer machinery.
    SourceLocation Loc = Parent.getLocStart();
    llvm.outs().$out_uint(C.getSourceManager().getSpellingLineNumber(/*NO_COPY*/Loc)).$out(/*KEEP_STR*/$SPACE).$out(
        Parent.getStmtClassName()
    ).$out(/*KEEP_STR*/$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TraversalDumper::checkBeginFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp", line = 55,
   FQN="(anonymous namespace)::TraversalDumper::checkBeginFunction", NM="_ZNK12_GLOBAL__N_115TraversalDumper18checkBeginFunctionERN5clang4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp -nm=_ZNK12_GLOBAL__N_115TraversalDumper18checkBeginFunctionERN5clang4ento14CheckerContextE")
  //</editor-fold>
  public void checkBeginFunction(final CheckerContext /*&*/ C) /*const*/ {
    llvm.outs().$out(/*KEEP_STR*/"--BEGIN FUNCTION--\n");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TraversalDumper::checkEndFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp", line = 59,
   FQN="(anonymous namespace)::TraversalDumper::checkEndFunction", NM="_ZNK12_GLOBAL__N_115TraversalDumper16checkEndFunctionERN5clang4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp -nm=_ZNK12_GLOBAL__N_115TraversalDumper16checkEndFunctionERN5clang4ento14CheckerContextE")
  //</editor-fold>
  public void checkEndFunction(final CheckerContext /*&*/ C) /*const*/ {
    llvm.outs().$out(/*KEEP_STR*/"--END FUNCTION--\n");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TraversalDumper::~TraversalDumper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp", line = 27,
   FQN="(anonymous namespace)::TraversalDumper::~TraversalDumper", NM="_ZN12_GLOBAL__N_115TraversalDumperD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp -nm=_ZN12_GLOBAL__N_115TraversalDumperD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TraversalDumper::TraversalDumper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp", line = 27,
   FQN="(anonymous namespace)::TraversalDumper::TraversalDumper", NM="_ZN12_GLOBAL__N_115TraversalDumperC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp -nm=_ZN12_GLOBAL__N_115TraversalDumperC1Ev")
  //</editor-fold>
  public /*inline*/ TraversalDumper() {
    // : Checker<BranchCondition, BeginFunction, EndFunction>() 
    //START JInit
    super();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new BranchCondition(),
    new BeginFunction(),
    new EndFunction()
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
