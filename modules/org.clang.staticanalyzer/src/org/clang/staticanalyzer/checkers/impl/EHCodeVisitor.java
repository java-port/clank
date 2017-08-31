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
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.checkers.impl.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// A simple visitor to record what VarDecls occur in EH-handling code.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EHCodeVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp", line = 34,
 FQN="(anonymous namespace)::EHCodeVisitor", NM="_ZN12_GLOBAL__N_113EHCodeVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN12_GLOBAL__N_113EHCodeVisitorE")
//</editor-fold>
public class EHCodeVisitor implements /*public*/ RecursiveASTVisitor<EHCodeVisitor> {
/*public:*/
  public boolean inEH;
  public final DenseSet</*const*/ VarDecl /*P*/ > /*&*/ S;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EHCodeVisitor::TraverseObjCAtFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp", line = 39,
   FQN="(anonymous namespace)::EHCodeVisitor::TraverseObjCAtFinallyStmt", NM="_ZN12_GLOBAL__N_113EHCodeVisitor25TraverseObjCAtFinallyStmtEPN5clang17ObjCAtFinallyStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN12_GLOBAL__N_113EHCodeVisitor25TraverseObjCAtFinallyStmtEPN5clang17ObjCAtFinallyStmtE")
  //</editor-fold>
  public boolean TraverseObjCAtFinallyStmt(ObjCAtFinallyStmt /*P*/ S) {
    SaveAndRestoreBool inFinally = null;
    try {
      inFinally/*J*/= new SaveAndRestoreBool(inEH$ref, true);
      return RecursiveASTVisitor.super.TraverseObjCAtFinallyStmt(S);
    } finally {
      if (inFinally != null) { inFinally.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EHCodeVisitor::TraverseObjCAtCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp", line = 44,
   FQN="(anonymous namespace)::EHCodeVisitor::TraverseObjCAtCatchStmt", NM="_ZN12_GLOBAL__N_113EHCodeVisitor23TraverseObjCAtCatchStmtEPN5clang15ObjCAtCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN12_GLOBAL__N_113EHCodeVisitor23TraverseObjCAtCatchStmtEPN5clang15ObjCAtCatchStmtE")
  //</editor-fold>
  public boolean TraverseObjCAtCatchStmt(ObjCAtCatchStmt /*P*/ S) {
    SaveAndRestoreBool inCatch = null;
    try {
      inCatch/*J*/= new SaveAndRestoreBool(inEH$ref, true);
      return RecursiveASTVisitor.super.TraverseObjCAtCatchStmt(S);
    } finally {
      if (inCatch != null) { inCatch.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EHCodeVisitor::TraverseCXXCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp", line = 49,
   FQN="(anonymous namespace)::EHCodeVisitor::TraverseCXXCatchStmt", NM="_ZN12_GLOBAL__N_113EHCodeVisitor20TraverseCXXCatchStmtEPN5clang12CXXCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN12_GLOBAL__N_113EHCodeVisitor20TraverseCXXCatchStmtEPN5clang12CXXCatchStmtE")
  //</editor-fold>
  public boolean TraverseCXXCatchStmt(CXXCatchStmt /*P*/ S) {
    SaveAndRestoreBool inCatch = null;
    try {
      inCatch/*J*/= new SaveAndRestoreBool(inEH$ref, true);
      return TraverseStmt(S.getHandlerBlock());
    } finally {
      if (inCatch != null) { inCatch.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EHCodeVisitor::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp", line = 54,
   FQN="(anonymous namespace)::EHCodeVisitor::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_113EHCodeVisitor16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN12_GLOBAL__N_113EHCodeVisitor16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public boolean VisitDeclRefExpr(DeclRefExpr /*P*/ DR) {
    if (inEH) {
      {
        /*const*/ VarDecl /*P*/ D = dyn_cast_VarDecl(DR.getDecl());
        if ((D != null)) {
          S.insert(D);
        }
      }
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EHCodeVisitor::EHCodeVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp", line = 61,
   FQN="(anonymous namespace)::EHCodeVisitor::EHCodeVisitor", NM="_ZN12_GLOBAL__N_113EHCodeVisitorC1ERN4llvm8DenseSetIPKN5clang7VarDeclENS1_12DenseMapInfoIS6_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN12_GLOBAL__N_113EHCodeVisitorC1ERN4llvm8DenseSetIPKN5clang7VarDeclENS1_12DenseMapInfoIS6_EEEE")
  //</editor-fold>
  public EHCodeVisitor(final DenseSet</*const*/ VarDecl /*P*/ > /*&*/ S) {
    // : RecursiveASTVisitor<EHCodeVisitor>(), inEH(false), S(S) 
    //START JInit
    $RecursiveASTVisitor();
    this.inEH = false;
    this./*&*/S=/*&*/S;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public bool$ref inEH$ref = new bool$ref() {
    @Override
    public boolean $deref() {
      return inEH;
    }
    @Override
    public boolean $set(boolean value) {
      inEH = value;
      return inEH;
    }
  };

  @Override
  public boolean has_overridden_traverse_with_queue_method(String TraverseMethodName) {
    // no Traverse* methods with Queue params
    return false;
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////  
  
  @Override public String toString() {
    return "" + "inEH=" + inEH // NOI18N
              + ", S=" + S // NOI18N
              + super.toString(); // NOI18N
  }
}
