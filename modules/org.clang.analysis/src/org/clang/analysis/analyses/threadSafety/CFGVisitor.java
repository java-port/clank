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

package org.clang.analysis.analyses.threadSafety;

import org.clank.support.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.analysis.java.BaseVisitor;

// end namespace sx

// This class defines the interface of a clang CFG Visitor.
// CFGWalker will invoke the following methods.
// Note that methods are not virtual; the visitor is templatized.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 82,
 FQN="clang::threadSafety::CFGVisitor", NM="_ZN5clang12threadSafety10CFGVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety10CFGVisitorE")
//</editor-fold>
public class CFGVisitor implements BaseVisitor {
  // Enter the CFG for Decl D, and perform any initial setup operations.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGVisitor::enterCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 84,
   FQN="clang::threadSafety::CFGVisitor::enterCFG", NM="_ZN5clang12threadSafety10CFGVisitor8enterCFGEPNS_3CFGEPKNS_9NamedDeclEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety10CFGVisitor8enterCFGEPNS_3CFGEPKNS_9NamedDeclEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void enterCFG(CFG /*P*/ Cfg, /*const*/ NamedDecl /*P*/ D, /*const*/ CFGBlock /*P*/ First) {
  }

  
  // Enter a CFGBlock.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGVisitor::enterCFGBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 87,
   FQN="clang::threadSafety::CFGVisitor::enterCFGBlock", NM="_ZN5clang12threadSafety10CFGVisitor13enterCFGBlockEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety10CFGVisitor13enterCFGBlockEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void enterCFGBlock(/*const*/ CFGBlock /*P*/ B) {
  }

  
  // Returns true if this visitor implements handlePredecessor
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGVisitor::visitPredecessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 90,
   FQN="clang::threadSafety::CFGVisitor::visitPredecessors", NM="_ZN5clang12threadSafety10CFGVisitor17visitPredecessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety10CFGVisitor17visitPredecessorsEv")
  //</editor-fold>
  @Override public /*friend*//*private*/ boolean visitPredecessors() {
    return true;
  }

  
  // Process a predecessor edge.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGVisitor::handlePredecessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 93,
   FQN="clang::threadSafety::CFGVisitor::handlePredecessor", NM="_ZN5clang12threadSafety10CFGVisitor17handlePredecessorEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety10CFGVisitor17handlePredecessorEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void handlePredecessor(/*const*/ CFGBlock /*P*/ Pred) {
  }

  
  // Process a successor back edge to a previously visited block.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGVisitor::handlePredecessorBackEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 96,
   FQN="clang::threadSafety::CFGVisitor::handlePredecessorBackEdge", NM="_ZN5clang12threadSafety10CFGVisitor25handlePredecessorBackEdgeEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety10CFGVisitor25handlePredecessorBackEdgeEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void handlePredecessorBackEdge(/*const*/ CFGBlock /*P*/ Pred) {
  }

  
  // Called just before processing statements.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGVisitor::enterCFGBlockBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 99,
   FQN="clang::threadSafety::CFGVisitor::enterCFGBlockBody", NM="_ZN5clang12threadSafety10CFGVisitor17enterCFGBlockBodyEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety10CFGVisitor17enterCFGBlockBodyEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void enterCFGBlockBody(/*const*/ CFGBlock /*P*/ B) {
  }

  
  // Process an ordinary statement.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGVisitor::handleStatement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 102,
   FQN="clang::threadSafety::CFGVisitor::handleStatement", NM="_ZN5clang12threadSafety10CFGVisitor15handleStatementEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety10CFGVisitor15handleStatementEPKNS_4StmtE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void handleStatement(/*const*/ Stmt /*P*/ S) {
  }

  
  // Process a destructor call
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGVisitor::handleDestructorCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 105,
   FQN="clang::threadSafety::CFGVisitor::handleDestructorCall", NM="_ZN5clang12threadSafety10CFGVisitor20handleDestructorCallEPKNS_7VarDeclEPKNS_17CXXDestructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety10CFGVisitor20handleDestructorCallEPKNS_7VarDeclEPKNS_17CXXDestructorDeclE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void handleDestructorCall(/*const*/ VarDecl /*P*/ VD, /*const*/ CXXDestructorDecl /*P*/ DD) {
  }

  
  // Called after all statements have been handled.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGVisitor::exitCFGBlockBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 108,
   FQN="clang::threadSafety::CFGVisitor::exitCFGBlockBody", NM="_ZN5clang12threadSafety10CFGVisitor16exitCFGBlockBodyEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety10CFGVisitor16exitCFGBlockBodyEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void exitCFGBlockBody(/*const*/ CFGBlock /*P*/ B) {
  }

  
  // Return true
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGVisitor::visitSuccessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 111,
   FQN="clang::threadSafety::CFGVisitor::visitSuccessors", NM="_ZN5clang12threadSafety10CFGVisitor15visitSuccessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety10CFGVisitor15visitSuccessorsEv")
  //</editor-fold>
  @Override public /*friend*//*private*/ boolean visitSuccessors() {
    return true;
  }

  
  // Process a successor edge.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGVisitor::handleSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 114,
   FQN="clang::threadSafety::CFGVisitor::handleSuccessor", NM="_ZN5clang12threadSafety10CFGVisitor15handleSuccessorEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety10CFGVisitor15handleSuccessorEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void handleSuccessor(/*const*/ CFGBlock /*P*/ Succ) {
  }

  
  // Process a successor back edge to a previously visited block.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGVisitor::handleSuccessorBackEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 117,
   FQN="clang::threadSafety::CFGVisitor::handleSuccessorBackEdge", NM="_ZN5clang12threadSafety10CFGVisitor23handleSuccessorBackEdgeEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety10CFGVisitor23handleSuccessorBackEdgeEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void handleSuccessorBackEdge(/*const*/ CFGBlock /*P*/ Succ) {
  }

  
  // Leave a CFGBlock.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGVisitor::exitCFGBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 120,
   FQN="clang::threadSafety::CFGVisitor::exitCFGBlock", NM="_ZN5clang12threadSafety10CFGVisitor12exitCFGBlockEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety10CFGVisitor12exitCFGBlockEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void exitCFGBlock(/*const*/ CFGBlock /*P*/ B) {
  }

  
  // Leave the CFG, and perform any final cleanup operations.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CFGVisitor::exitCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 123,
   FQN="clang::threadSafety::CFGVisitor::exitCFG", NM="_ZN5clang12threadSafety10CFGVisitor7exitCFGEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety10CFGVisitor7exitCFGEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void exitCFG(/*const*/ CFGBlock /*P*/ Last) {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
