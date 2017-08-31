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

package org.clang.analysis;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;


/// Represents a point when we begin processing an inlined call.
/// CallEnter uses the caller's location context.
//<editor-fold defaultstate="collapsed" desc="clang::CallEnter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 584,
 FQN="clang::CallEnter", NM="_ZN5clang9CallEnterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang9CallEnterE")
//</editor-fold>
public class CallEnter extends /*public*/ ProgramPoint {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CallEnter::CallEnter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 586,
   FQN="clang::CallEnter::CallEnter", NM="_ZN5clang9CallEnterC1EPKNS_4StmtEPKNS_17StackFrameContextEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang9CallEnterC1EPKNS_4StmtEPKNS_17StackFrameContextEPKNS_15LocationContextE")
  //</editor-fold>
  public CallEnter(/*const*/ Stmt /*P*/ stmt, /*const*/ StackFrameContext /*P*/ calleeCtx, 
      /*const*/ LocationContext /*P*/ callerCtx) {
    // : ProgramPoint(stmt, calleeCtx, CallEnterKind, callerCtx, null) 
    //START JInit
    super(stmt, calleeCtx, Kind.CallEnterKind, callerCtx, (/*const*/ ProgramPointTag /*P*/ )null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallEnter::getCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 590,
   FQN="clang::CallEnter::getCallExpr", NM="_ZNK5clang9CallEnter11getCallExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZNK5clang9CallEnter11getCallExprEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getCallExpr() /*const*/ {
    return ((/*static_cast*//*const*/ Stmt /*P*/ )(getData1()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallEnter::getCalleeContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 594,
   FQN="clang::CallEnter::getCalleeContext", NM="_ZNK5clang9CallEnter16getCalleeContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZNK5clang9CallEnter16getCalleeContextEv")
  //</editor-fold>
  public /*const*/ StackFrameContext /*P*/ getCalleeContext() /*const*/ {
    return ((/*static_cast*//*const*/ StackFrameContext /*P*/ )(getData2()));
  }

  
  /// Returns the entry block in the CFG for the entered function.
  //<editor-fold defaultstate="collapsed" desc="clang::CallEnter::getEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 599,
   FQN="clang::CallEnter::getEntry", NM="_ZNK5clang9CallEnter8getEntryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZNK5clang9CallEnter8getEntryEv")
  //</editor-fold>
  public /*const*/ CFGBlock /*P*/ getEntry() /*const*/ {
    /*const*/ StackFrameContext /*P*/ CalleeCtx = getCalleeContext();
    /*const*/ CFG /*P*/ CalleeCFG = CalleeCtx.getCFG();
    return $AddrOf((CalleeCFG.getEntry$Const()));
  }

/*private:*/
  /*friend  class ProgramPoint*/
  //<editor-fold defaultstate="collapsed" desc="clang::CallEnter::CallEnter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 607,
   FQN="clang::CallEnter::CallEnter", NM="_ZN5clang9CallEnterC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang9CallEnterC1Ev")
  //</editor-fold>
  /*friend*/protected/*private*/ CallEnter() {
    // : ProgramPoint() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallEnter::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 608,
   FQN="clang::CallEnter::isKind", NM="_ZN5clang9CallEnter6isKindERKNS_12ProgramPointE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang9CallEnter6isKindERKNS_12ProgramPointE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ ProgramPoint /*&*/ Location) {
    return Location.getKind() == Kind.CallEnterKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallEnter::CallEnter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 584,
   FQN="clang::CallEnter::CallEnter", NM="_ZN5clang9CallEnterC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang9CallEnterC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CallEnter(final /*const*/ CallEnter /*&*/ $Prm0) {
    // : ProgramPoint() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallEnter::CallEnter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 584,
   FQN="clang::CallEnter::CallEnter", NM="_ZN5clang9CallEnterC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang9CallEnterC1EOS0_")
  //</editor-fold>
  public /*inline*/ CallEnter(JD$Move _dparam, final CallEnter /*&&*/$Prm0) {
    // : ProgramPoint(static_cast<CallEnter &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallEnter::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 584,
   FQN="clang::CallEnter::operator=", NM="_ZN5clang9CallEnteraSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang9CallEnteraSEOS0_")
  //</editor-fold>
  public /*inline*/ CallEnter /*&*/ $assignMove(final CallEnter /*&&*/$Prm0) {
    /*J:ToBase*/super.$assignMove($Prm0);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override public CallEnter clone() {
    assert this.getClass() == CallEnter.class : "must be overridden in " + this.getClass();
    return new CallEnter(this);
  }
  
  @Override public CallEnter move() {
    assert this.getClass() == CallEnter.class : "must be overridden in " + this.getClass();
    return new CallEnter(JD$Move.INSTANCE, this);
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
