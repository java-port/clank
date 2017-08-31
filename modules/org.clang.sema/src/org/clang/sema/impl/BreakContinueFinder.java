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

package org.clang.sema.impl;

import org.clank.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;


// A visitor to determine if a continue or break statement is a
// subexpression.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BreakContinueFinder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1542,
 FQN="(anonymous namespace)::BreakContinueFinder", NM="_ZN12_GLOBAL__N_119BreakContinueFinderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_119BreakContinueFinderE")
//</editor-fold>
public class BreakContinueFinder implements /*public*/ EvaluatedExprVisitor<BreakContinueFinder> {
  private SourceLocation BreakLoc;
  private SourceLocation ContinueLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BreakContinueFinder::BreakContinueFinder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1546,
   FQN="(anonymous namespace)::BreakContinueFinder::BreakContinueFinder", NM="_ZN12_GLOBAL__N_119BreakContinueFinderC1ERN5clang4SemaEPNS1_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_119BreakContinueFinderC1ERN5clang4SemaEPNS1_4StmtE")
  //</editor-fold>
  public BreakContinueFinder(final Sema /*&*/ S, Stmt /*P*/ Body) {
    // : Inherited(S.Context), BreakLoc(), ContinueLoc() 
    //START JInit
    this.EvaluatedExprVisitorBase$Flds = $EvaluatedExprVisitor(S.Context);
    this.BreakLoc = new SourceLocation();
    this.ContinueLoc = new SourceLocation();
    //END JInit
    Visit(Body);
  }

  
  // JAVA: typedef EvaluatedExprVisitor<BreakContinueFinder> Inherited
//  public final class Inherited extends EvaluatedExprVisitor<BreakContinueFinder>{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BreakContinueFinder::VisitContinueStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1553,
   FQN="(anonymous namespace)::BreakContinueFinder::VisitContinueStmt", NM="_ZN12_GLOBAL__N_119BreakContinueFinder17VisitContinueStmtEPN5clang12ContinueStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_119BreakContinueFinder17VisitContinueStmtEPN5clang12ContinueStmtE")
  //</editor-fold>
  public void VisitContinueStmt(ContinueStmt /*P*/ E) {
    ContinueLoc.$assignMove(E.getContinueLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BreakContinueFinder::VisitBreakStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1557,
   FQN="(anonymous namespace)::BreakContinueFinder::VisitBreakStmt", NM="_ZN12_GLOBAL__N_119BreakContinueFinder14VisitBreakStmtEPN5clang9BreakStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_119BreakContinueFinder14VisitBreakStmtEPN5clang9BreakStmtE")
  //</editor-fold>
  public void VisitBreakStmt(BreakStmt /*P*/ E) {
    BreakLoc.$assignMove(E.getBreakLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BreakContinueFinder::ContinueFound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1561,
   FQN="(anonymous namespace)::BreakContinueFinder::ContinueFound", NM="_ZN12_GLOBAL__N_119BreakContinueFinder13ContinueFoundEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_119BreakContinueFinder13ContinueFoundEv")
  //</editor-fold>
  public boolean ContinueFound() {
    return ContinueLoc.isValid();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BreakContinueFinder::BreakFound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1562,
   FQN="(anonymous namespace)::BreakContinueFinder::BreakFound", NM="_ZN12_GLOBAL__N_119BreakContinueFinder10BreakFoundEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_119BreakContinueFinder10BreakFoundEv")
  //</editor-fold>
  public boolean BreakFound() {
    return BreakLoc.isValid();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BreakContinueFinder::GetContinueLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1563,
   FQN="(anonymous namespace)::BreakContinueFinder::GetContinueLoc", NM="_ZN12_GLOBAL__N_119BreakContinueFinder14GetContinueLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_119BreakContinueFinder14GetContinueLocEv")
  //</editor-fold>
  public SourceLocation GetContinueLoc() {
    return new SourceLocation(ContinueLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BreakContinueFinder::GetBreakLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1564,
   FQN="(anonymous namespace)::BreakContinueFinder::GetBreakLoc", NM="_ZN12_GLOBAL__N_119BreakContinueFinder11GetBreakLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_119BreakContinueFinder11GetBreakLocEv")
  //</editor-fold>
  public SourceLocation GetBreakLoc() {
    return new SourceLocation(BreakLoc);
  }

  
  private final EvaluatedExprVisitorBase$Fields EvaluatedExprVisitorBase$Flds;// use return value of $EvaluatedExprVisitor();
  @Override public final EvaluatedExprVisitorBase$Fields $EvaluatedExprVisitorBase$Fields() { return EvaluatedExprVisitorBase$Flds; }
  
  @Override public String toString() {
    return "" + "BreakLoc=" + BreakLoc // NOI18N
              + ", ContinueLoc=" + ContinueLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
