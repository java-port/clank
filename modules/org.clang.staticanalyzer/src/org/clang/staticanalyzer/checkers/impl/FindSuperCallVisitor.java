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
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.impl.*;


//===----------------------------------------------------------------------===//
// FindSuperCallVisitor - Identify specific calls to the superclass.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindSuperCallVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp", line = 42,
 FQN="(anonymous namespace)::FindSuperCallVisitor", NM="_ZN12_GLOBAL__N_120FindSuperCallVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp -nm=_ZN12_GLOBAL__N_120FindSuperCallVisitorE")
//</editor-fold>
public class FindSuperCallVisitor implements /*public*/ RecursiveASTVisitor<FindSuperCallVisitor> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindSuperCallVisitor::FindSuperCallVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp", line = 44,
   FQN="(anonymous namespace)::FindSuperCallVisitor::FindSuperCallVisitor", NM="_ZN12_GLOBAL__N_120FindSuperCallVisitorC1EN5clang8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp -nm=_ZN12_GLOBAL__N_120FindSuperCallVisitorC1EN5clang8SelectorE")
  //</editor-fold>
  public /*explicit*/ FindSuperCallVisitor(Selector S) {
    // : RecursiveASTVisitor<FindSuperCallVisitor>(), DoesCallSuper(false), Sel(S) 
    //START JInit
    $RecursiveASTVisitor();
    this.DoesCallSuper = false;
    this.Sel = new Selector(S);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindSuperCallVisitor::VisitObjCMessageExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp", line = 46,
   FQN="(anonymous namespace)::FindSuperCallVisitor::VisitObjCMessageExpr", NM="_ZN12_GLOBAL__N_120FindSuperCallVisitor20VisitObjCMessageExprEPN5clang15ObjCMessageExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp -nm=_ZN12_GLOBAL__N_120FindSuperCallVisitor20VisitObjCMessageExprEPN5clang15ObjCMessageExprE")
  //</editor-fold>
  public boolean VisitObjCMessageExpr(ObjCMessageExpr /*P*/ E) {
    if (E.getSelector().$eq(/*NO_COPY*/Sel)) {
      if (E.getReceiverKind() == ObjCMessageExpr.ReceiverKind.SuperInstance) {
        DoesCallSuper = true;
      }
    }
    
    // Recurse if we didn't find the super call yet.
    return !DoesCallSuper;
  }

  @Override
  public boolean has_overridden_traverse_with_queue_method(String TraverseMethodName) {
    // no any overridden traverse with queue methods
    return false;
  }
  
  public boolean DoesCallSuper;
/*private:*/
  private Selector Sel;
  
  @Override public String toString() {
    return "" + "DoesCallSuper=" + DoesCallSuper // NOI18N
              + ", Sel=" + Sel // NOI18N
              + super.toString(); // NOI18N
  }
}
