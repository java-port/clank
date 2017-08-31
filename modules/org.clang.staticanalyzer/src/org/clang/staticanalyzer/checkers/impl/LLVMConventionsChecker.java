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
import org.clang.ast.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.checkers.impl.LLVMConventionsCheckerStatics.*;
import org.clang.staticanalyzer.java.CheckBase;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LLVMConventionsChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 298,
 FQN="(anonymous namespace)::LLVMConventionsChecker", NM="_ZN12_GLOBAL__N_122LLVMConventionsCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZN12_GLOBAL__N_122LLVMConventionsCheckerE")
//</editor-fold>
public class LLVMConventionsChecker extends /*public*/ Checker/*<ASTDecl<CXXRecordDecl>, ASTCodeBody> */
        implements org.clang.staticanalyzer.java.ASTDeclChecker<CXXRecordDecl>, org.clang.staticanalyzer.java.ASTCodeBodyChecker, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LLVMConventionsChecker::checkASTDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 302,
   FQN="(anonymous namespace)::LLVMConventionsChecker::checkASTDecl", NM="_ZNK12_GLOBAL__N_122LLVMConventionsChecker12checkASTDeclEPKN5clang13CXXRecordDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZNK12_GLOBAL__N_122LLVMConventionsChecker12checkASTDeclEPKN5clang13CXXRecordDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE")
  //</editor-fold>
  public void checkASTDecl(/*const*/ CXXRecordDecl /*P*/ R, final AnalysisManager /*&*/ mgr, 
              final BugReporter /*&*/ BR) /*const*/ {
    if (R.isCompleteDefinition()) {
      CheckASTMemory(R, BR, this);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LLVMConventionsChecker::checkASTCodeBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 308,
   FQN="(anonymous namespace)::LLVMConventionsChecker::checkASTCodeBody", NM="_ZNK12_GLOBAL__N_122LLVMConventionsChecker16checkASTCodeBodyEPKN5clang4DeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZNK12_GLOBAL__N_122LLVMConventionsChecker16checkASTCodeBodyEPKN5clang4DeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE")
  //</editor-fold>
  public void checkASTCodeBody(/*const*/ Decl /*P*/ D, final AnalysisManager /*&*/ mgr, 
                  final BugReporter /*&*/ BR) /*const*/ {
    CheckStringRefAssignedTemporary(D, BR, this);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LLVMConventionsChecker::~LLVMConventionsChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 298,
   FQN="(anonymous namespace)::LLVMConventionsChecker::~LLVMConventionsChecker", NM="_ZN12_GLOBAL__N_122LLVMConventionsCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZN12_GLOBAL__N_122LLVMConventionsCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LLVMConventionsChecker::LLVMConventionsChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 298,
   FQN="(anonymous namespace)::LLVMConventionsChecker::LLVMConventionsChecker", NM="_ZN12_GLOBAL__N_122LLVMConventionsCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZN12_GLOBAL__N_122LLVMConventionsCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ LLVMConventionsChecker() {
    // : Checker<ASTDecl<CXXRecordDecl>, ASTCodeBody>() 
    //START JInit
    super();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new ASTDecl<CXXRecordDecl>(CXXRecordDecl.class),
    new ASTCodeBody()
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
