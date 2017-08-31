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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


/// \brief When a region containing undefined value or '0' value is passed 
/// as an argument in a call, marks the call as interesting.
///
/// As a result, BugReporter will not prune the path through the function even
/// if the region's contents are not modified/accessed by the call.
//<editor-fold defaultstate="collapsed" desc="clang::ento::UndefOrNullArgVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 282,
 FQN="clang::ento::UndefOrNullArgVisitor", NM="_ZN5clang4ento21UndefOrNullArgVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento21UndefOrNullArgVisitorE")
//</editor-fold>
public final class UndefOrNullArgVisitor extends /*public*/ BugReporterVisitorImpl<UndefOrNullArgVisitor> implements Destructors.ClassWithDestructor {
  
  /// The interesting memory region this visitor is tracking.
  private /*const*/ MemRegion /*P*/ R;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::UndefOrNullArgVisitor::UndefOrNullArgVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 289,
   FQN="clang::ento::UndefOrNullArgVisitor::UndefOrNullArgVisitor", NM="_ZN5clang4ento21UndefOrNullArgVisitorC1EPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento21UndefOrNullArgVisitorC1EPKNS0_9MemRegionE")
  //</editor-fold>
  public UndefOrNullArgVisitor(/*const*/ MemRegion /*P*/ InR) {
    // : BugReporterVisitorImpl<UndefOrNullArgVisitor>(), R(InR) 
    //START JInit
    super();
    this.R = InR;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::UndefOrNullArgVisitor::Profile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 291,
   FQN="clang::ento::UndefOrNullArgVisitor::Profile", NM="_ZNK5clang4ento21UndefOrNullArgVisitor7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZNK5clang4ento21UndefOrNullArgVisitor7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    final/*static*/ Object Tag = Profile$$.Tag;
    ID.AddPointer($AddrOf(Tag));
    ID.AddPointer(R);
  }
  private static final class Profile$$ {
    static final/*static*/ Object Tag = UndefOrNullArgVisitor.class;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::UndefOrNullArgVisitor::VisitNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp", line = 1643,
   FQN="clang::ento::UndefOrNullArgVisitor::VisitNode", NM="_ZN5clang4ento21UndefOrNullArgVisitor9VisitNodeEPKNS0_12ExplodedNodeES4_RNS0_18BugReporterContextERNS0_9BugReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento21UndefOrNullArgVisitor9VisitNodeEPKNS0_12ExplodedNodeES4_RNS0_18BugReporterContextERNS0_9BugReportE")
  //</editor-fold>
  @Override public PathDiagnosticPiece /*P*/ VisitNode(/*const*/ ExplodedNode /*P*/ N, 
           /*const*/ ExplodedNode /*P*/ PrevN, 
           final BugReporterContext /*&*/ BRC, 
           final BugReport /*&*/ BR)/* override*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    CallEventRef<CallEvent> Call = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
      ProgramPoint ProgLoc = N.getLocation();
      
      // We are only interested in visiting CallEnter nodes.
      Optional<CallEnter> CEnter = ProgLoc.getAs(CallEnter.class);
      if (!CEnter.$bool()) {
        return null;
      }
      
      // Check if one of the arguments is the region the visitor is tracking.
      final CallEventManager /*&*/ CEMgr = BRC.getStateManager().getCallEventManager();
      Call = $c$.clean(CEMgr.getCaller(CEnter.$arrow().getCalleeContext(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      /*uint*/int Idx = 0;
      ArrayRef<ParmVarDecl /*P*/ > parms = Call.$arrow().parameters();
      
      for (type$ptr<ParmVarDecl /*P*/ /*P*/> I = $tryClone(parms.begin()), /*P*/ E = $tryClone(parms.end());
           $noteq_ptr(I, E); I.$preInc() , ++Idx) {
        /*const*/ MemRegion /*P*/ ArgReg = Call.$arrow().getArgSVal(Idx).getAsRegion();
        
        // Are we tracking the argument or its subregion?
        if (!(ArgReg != null) || (ArgReg != R && !R.isSubRegionOf(ArgReg.StripCasts()))) {
          continue;
        }
        
        // Check the function parameter type.
        /*const*/ ParmVarDecl /*P*/ ParamDecl = I.$star();
        assert ((ParamDecl != null)) : "Formal parameter has no decl?";
        QualType T = ParamDecl.getType();
        if (!(T.$arrow().isAnyPointerType() || T.$arrow().isReferenceType())) {
          // Function can only change the value passed in by address.
          continue;
        }
        
        // If it is a const pointer value, the function does not intend to
        // change the value.
        if (T.$arrow().getPointeeType().isConstQualified()) {
          continue;
        }
        
        // Mark the call site (LocationContext) as interesting if the value of the
        // argument is undefined or '0'/'NULL'.
        SVal BoundVal = State.$arrow().getSVal(R);
        if (BoundVal.isUndef$SVal() || BoundVal.isZeroConstant()) {
          BR.markInteresting(CEnter.$arrow().getCalleeContext());
          return null;
        }
      }
      return null;
    } finally {
      if (Call != null) { Call.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::UndefOrNullArgVisitor::~UndefOrNullArgVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 282,
   FQN="clang::ento::UndefOrNullArgVisitor::~UndefOrNullArgVisitor", NM="_ZN5clang4ento21UndefOrNullArgVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento21UndefOrNullArgVisitorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::UndefOrNullArgVisitor::UndefOrNullArgVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporterVisitor.h", line = 282,
   FQN="clang::ento::UndefOrNullArgVisitor::UndefOrNullArgVisitor", NM="_ZN5clang4ento21UndefOrNullArgVisitorC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporterVisitors.cpp -nm=_ZN5clang4ento21UndefOrNullArgVisitorC1ERKS1_")
  //</editor-fold>
  public /*inline*/ UndefOrNullArgVisitor(final /*const*/ UndefOrNullArgVisitor /*&*/ $Prm0) {
    // : BugReporterVisitorImpl<UndefOrNullArgVisitor>(), R(.R) 
    //START JInit
    super($Prm0);
    this.R = $Prm0.R;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public UndefOrNullArgVisitor clone() {
    return new UndefOrNullArgVisitor(this);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "R=" + R // NOI18N
              + super.toString(); // NOI18N
  }
}
