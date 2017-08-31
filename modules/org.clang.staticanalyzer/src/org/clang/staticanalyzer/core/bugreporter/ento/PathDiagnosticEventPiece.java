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

package org.clang.staticanalyzer.core.bugreporter.ento;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticEventPiece">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 501,
 FQN="clang::ento::PathDiagnosticEventPiece", NM="_ZN5clang4ento24PathDiagnosticEventPieceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento24PathDiagnosticEventPieceE")
//</editor-fold>
public class PathDiagnosticEventPiece extends /*public*/ PathDiagnosticSpotPiece implements Destructors.ClassWithDestructor {
  private OptionalBool IsPrunable;
  
  /// If the event occurs in a different frame than the final diagnostic,
  /// supply a message that will be used to construct an extra hint on the
  /// returns from all the calls on the stack from this event to the final
  /// diagnostic.
  private std.unique_ptr<StackHintGenerator> CallStackHint;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticEventPiece::PathDiagnosticEventPiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 511,
   FQN="clang::ento::PathDiagnosticEventPiece::PathDiagnosticEventPiece", NM="_ZN5clang4ento24PathDiagnosticEventPieceC1ERKNS0_22PathDiagnosticLocationEN4llvm9StringRefEbPNS0_18StackHintGeneratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento24PathDiagnosticEventPieceC1ERKNS0_22PathDiagnosticLocationEN4llvm9StringRefEbPNS0_18StackHintGeneratorE")
  //</editor-fold>
  public PathDiagnosticEventPiece(final /*const*/ PathDiagnosticLocation /*&*/ pos, 
      StringRef s) {
    this(pos, 
      s, true, 
      (StackHintGenerator /*P*/ )null);
  }
  public PathDiagnosticEventPiece(final /*const*/ PathDiagnosticLocation /*&*/ pos, 
      StringRef s, boolean addPosRange/*= true*/) {
    this(pos, 
      s, addPosRange, 
      (StackHintGenerator /*P*/ )null);
  }
  public PathDiagnosticEventPiece(final /*const*/ PathDiagnosticLocation /*&*/ pos, 
      StringRef s, boolean addPosRange/*= true*/, 
      StackHintGenerator /*P*/ stackHint/*= null*/) {
    // : PathDiagnosticSpotPiece(pos, s, Event, addPosRange), IsPrunable(), CallStackHint(stackHint) 
    //START JInit
    super(pos, new StringRef(s), Kind.Event, addPosRange);
    this.IsPrunable = new OptionalBool();
    this.CallStackHint = new std.unique_ptr<StackHintGenerator>(stackHint);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticEventPiece::~PathDiagnosticEventPiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 59,
   FQN="clang::ento::PathDiagnosticEventPiece::~PathDiagnosticEventPiece", NM="_ZN5clang4ento24PathDiagnosticEventPieceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento24PathDiagnosticEventPieceD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    CallStackHint.$destroy();
    IsPrunable.$destroy();
    super.$destroy();
    //END JDestroy
  }


  
  /// Mark the diagnostic piece as being potentially prunable.  This
  /// flag may have been previously set, at which point it will not
  /// be reset unless one specifies to do so.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticEventPiece::setPrunable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 522,
   FQN="clang::ento::PathDiagnosticEventPiece::setPrunable", NM="_ZN5clang4ento24PathDiagnosticEventPiece11setPrunableEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento24PathDiagnosticEventPiece11setPrunableEbb")
  //</editor-fold>
  public void setPrunable(boolean isPrunable) {
    setPrunable(isPrunable, false);
  }
  public void setPrunable(boolean isPrunable, boolean override/*= false*/) {
    if (IsPrunable.hasValue() && !override) {
      return;
    }
    IsPrunable.$assign_T$C$R(/*KEEP_BOOL*/isPrunable);
  }

  
  /// Return true if the diagnostic piece is prunable.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticEventPiece::isPrunable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 529,
   FQN="clang::ento::PathDiagnosticEventPiece::isPrunable", NM="_ZNK5clang4ento24PathDiagnosticEventPiece10isPrunableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento24PathDiagnosticEventPiece10isPrunableEv")
  //</editor-fold>
  public boolean isPrunable() /*const*/ {
    return IsPrunable.hasValue() ? IsPrunable.getValue$Const() : false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticEventPiece::hasCallStackHint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 533,
   FQN="clang::ento::PathDiagnosticEventPiece::hasCallStackHint", NM="_ZN5clang4ento24PathDiagnosticEventPiece16hasCallStackHintEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento24PathDiagnosticEventPiece16hasCallStackHintEv")
  //</editor-fold>
  public boolean hasCallStackHint() {
    return (boolean)CallStackHint.$bool();
  }

  
  /// Produce the hint for the given node. The node contains 
  /// information about the call for which the diagnostic can be generated.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticEventPiece::getCallStackMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 537,
   FQN="clang::ento::PathDiagnosticEventPiece::getCallStackMessage", NM="_ZN5clang4ento24PathDiagnosticEventPiece19getCallStackMessageEPKNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento24PathDiagnosticEventPiece19getCallStackMessageEPKNS0_12ExplodedNodeE")
  //</editor-fold>
  public std.string getCallStackMessage(/*const*/ ExplodedNode /*P*/ N) {
    if (CallStackHint.$bool()) {
      return CallStackHint.$arrow().getMessage(N);
    }
    return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticEventPiece::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 3501,
   FQN="clang::ento::PathDiagnosticEventPiece::dump", NM="_ZNK5clang4ento24PathDiagnosticEventPiece4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento24PathDiagnosticEventPiece4dumpEv")
  //</editor-fold>
  @Override public void dump() /*const*//* __attribute__((used)) __attribute__((noinline)) override*/ {
    llvm.errs().$out(/*KEEP_STR*/"EVENT\n--------------\n");
    llvm.errs().$out(getString()).$out(/*KEEP_STR*/$LF);
    llvm.errs().$out(/*KEEP_STR*/" ---- at ----\n");
    getLocation().dump();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticEventPiece::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 545,
   FQN="clang::ento::PathDiagnosticEventPiece::classof", NM="_ZN5clang4ento24PathDiagnosticEventPiece7classofEPKNS0_19PathDiagnosticPieceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento24PathDiagnosticEventPiece7classofEPKNS0_19PathDiagnosticPieceE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ PathDiagnosticPiece /*P*/ P) {
    return P.getKind() == Kind.Event;
  }

  
  @Override public String toString() {
    return "" + "IsPrunable=" + IsPrunable // NOI18N
              + ", CallStackHint=" + CallStackHint // NOI18N
              + super.toString(); // NOI18N
  }
}
