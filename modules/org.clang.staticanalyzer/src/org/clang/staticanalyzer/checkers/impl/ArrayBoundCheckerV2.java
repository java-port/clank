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
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ArrayBoundCheckerV2">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 29,
 FQN="(anonymous namespace)::ArrayBoundCheckerV2", NM="_ZN12_GLOBAL__N_119ArrayBoundCheckerV2E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZN12_GLOBAL__N_119ArrayBoundCheckerV2E")
//</editor-fold>
public class ArrayBoundCheckerV2 extends /*public*/ Checker/*T<Location> */
        implements org.clang.staticanalyzer.java.LocationChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BuiltinBug> BT;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ArrayBoundCheckerV2::OOB_Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 33,
   FQN="(anonymous namespace)::ArrayBoundCheckerV2::OOB_Kind", NM="_ZN12_GLOBAL__N_119ArrayBoundCheckerV28OOB_KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZN12_GLOBAL__N_119ArrayBoundCheckerV28OOB_KindE")
  //</editor-fold>
  private enum OOB_Kind implements Native.NativeUIntEnum {
    OOB_Precedes(0),
    OOB_Excedes(OOB_Precedes.getValue() + 1),
    OOB_Tainted(OOB_Excedes.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static OOB_Kind valueOf(int val) {
      OOB_Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final OOB_Kind[] VALUES;
      private static final OOB_Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (OOB_Kind kind : OOB_Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new OOB_Kind[min < 0 ? (1-min) : 0];
        VALUES = new OOB_Kind[max >= 0 ? (1+max) : 0];
        for (OOB_Kind kind : OOB_Kind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private OOB_Kind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ArrayBoundCheckerV2::reportOOB">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 181,
   FQN="(anonymous namespace)::ArrayBoundCheckerV2::reportOOB", NM="_ZNK12_GLOBAL__N_119ArrayBoundCheckerV29reportOOBERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEENS0_8OOB_KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZNK12_GLOBAL__N_119ArrayBoundCheckerV29reportOOBERN5clang4ento14CheckerContextEN4llvm18IntrusiveRefCntPtrIKNS2_12ProgramStateEEENS0_8OOB_KindE")
  //</editor-fold>
  private void reportOOB(final CheckerContext /*&*/ checkerContext, 
           IntrusiveRefCntPtr</*const*/ ProgramState> errorState, 
           OOB_Kind kind) /*const*/ {
    raw_svector_ostream os = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      ExplodedNode /*P*/ errorNode = $c$.clean(checkerContext.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(errorState))));
      if (!(errorNode != null)) {
        return;
      }
      if (!BT.$bool()) {
        BT.reset(new BuiltinBug(this, $("Out-of-bound access")));
      }
      
      // FIXME: This diagnostics are preliminary.  We should get far better
      // diagnostics for explaining buffer overruns.
      SmallString/*<256>*/ buf/*J*/= new SmallString/*<256>*/(256);
      os/*J*/= new raw_svector_ostream(buf);
      os.$out(/*KEEP_STR*/"Out of bound memory access ");
      switch (kind) {
       case OOB_Precedes:
        os.$out(/*KEEP_STR*/"(accessed memory precedes memory block)");
        break;
       case OOB_Excedes:
        os.$out(/*KEEP_STR*/"(access exceeds upper limit of memory block)");
        break;
       case OOB_Tainted:
        os.$out(/*KEEP_STR*/"(index is tainted)");
        break;
      }
      
      checkerContext.emitReport($c$.track(llvm.make_unique(new BugReport(BT.$star(), os.str(), errorNode)))); $c$.clean();
    } finally {
      if (os != null) { os.$destroy(); }
      $c$.$destroy();
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ArrayBoundCheckerV2::checkLocation">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*std.tie*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 84,
   FQN="(anonymous namespace)::ArrayBoundCheckerV2::checkLocation", NM="_ZNK12_GLOBAL__N_119ArrayBoundCheckerV213checkLocationEN5clang4ento4SValEbPKNS1_4StmtERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZNK12_GLOBAL__N_119ArrayBoundCheckerV213checkLocationEN5clang4ento4SValEbPKNS1_4StmtERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkLocation(SVal location, boolean isLoad, 
               /*const*/ Stmt /*P*/ LoadS, 
               final CheckerContext /*&*/ checkerContext) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> originalState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {

      // NOTE: Instead of using ProgramState::assumeInBound(), we are prototyping
      // some new logic here that reasons directly about memory region extents.
      // Once that logic is more mature, we can bring it back to assumeInBound()
      // for all clients to use.
      //
      // The algorithm we are using here for bounds checking is to see if the
      // memory access is within the extent of the base region.  Since we
      // have some flexibility in defining the base region, we can achieve
      // various levels of conservatism in our buffer overflow checking.
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(checkerContext.getState());
      originalState = new IntrusiveRefCntPtr</*const*/ ProgramState>(state);

      final SValBuilder /*&*/ svalBuilder = checkerContext.getSValBuilder();
      final /*const*/ RegionRawOffsetV2 /*&*/ rawOffset = $c$.clean(RegionRawOffsetV2.computeOffset($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), svalBuilder, new SVal(location)));
      if (!(rawOffset.getRegion() != null)) {
        return;
      }

      // CHECK LOWER BOUND: Is byteOffset < extent begin?
      //  If so, we are doing a load/store
      //  before the first valid offset in the memory region.
      SVal extentBegin = ArrayBoundCheckerV2Statics.computeExtentBegin(svalBuilder, rawOffset.getRegion());
      {

        Optional<NonLoc> NV = extentBegin.getAs(NonLoc.class);
        if (NV.$bool()) {
          IntrusiveRefCntPtr</*const*/ ProgramState> state_precedesLowerBound = null;
          IntrusiveRefCntPtr</*const*/ ProgramState> state_withinLowerBound = null;
          try {
            SVal lowerBound = $c$.clean(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_LT, rawOffset.getByteOffset(), new NonLoc(NV.$star()), 
                svalBuilder.getConditionType()));

            Optional<NonLoc> lowerBoundToCheck = lowerBound.getAs(NonLoc.class);
            if (!lowerBoundToCheck.$bool()) {
              return;
            }

            state_precedesLowerBound/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
            state_withinLowerBound/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
  //          $c$.clean(std.tie(state_precedesLowerBound, state_withinLowerBound).$assign(
  //              $c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(lowerBoundToCheck.$star())))
  //          ));
            // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
            std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
                    $c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(lowerBoundToCheck.$star())));
            state_precedesLowerBound.$assign($assume.first);
            state_withinLowerBound.$assign($assume.second);
            assert !$assume.first.$bool();
            assert !$assume.second.$bool();
            $c$.clean();

            // Are we constrained enough to definitely precede the lower bound?
            if (state_precedesLowerBound.$bool() && !state_withinLowerBound.$bool()) {
              reportOOB(checkerContext, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state_precedesLowerBound)), OOB_Kind.OOB_Precedes); $c$.clean();
              return;
            }

            // Otherwise, assume the constraint of the lower bound.
            assert ((state_withinLowerBound).$bool());
            $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state_withinLowerBound))));
          } finally {
            if (state_withinLowerBound != null) { state_withinLowerBound.$destroy(); }
            if (state_precedesLowerBound != null) { state_precedesLowerBound.$destroy(); }
          }
        }
      }

      do {
        IntrusiveRefCntPtr</*const*/ ProgramState> state_exceedsUpperBound = null;
        IntrusiveRefCntPtr</*const*/ ProgramState> state_withinUpperBound = null;
        try {
          // CHECK UPPER BOUND: Is byteOffset >= extent(baseRegion)?  If so,
          // we are doing a load/store after the last valid offset.
          DefinedOrUnknownSVal extentVal = rawOffset.getRegion().getExtent(svalBuilder);
          if (!extentVal.getAs(NonLoc.class).$bool()) {
            break;
          }

          SVal upperbound = $c$.clean(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_GE, rawOffset.getByteOffset(), 
              extentVal.castAs(NonLoc.class), 
              svalBuilder.getConditionType()));

          Optional<NonLoc> upperboundToCheck = upperbound.getAs(NonLoc.class);
          if (!upperboundToCheck.$bool()) {
            break;
          }

          state_exceedsUpperBound/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
          state_withinUpperBound/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
  //        $c$.clean(std.tie(state_exceedsUpperBound, state_withinUpperBound).$assign(
  //            $c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(upperboundToCheck.$star())))
  //        ));
          // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
          std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
                  $c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(upperboundToCheck.$star())));
          state_exceedsUpperBound.$assign($assume.first);
          state_withinUpperBound.$assign($assume.second);
          assert !$assume.first.$bool();
          assert !$assume.second.$bool();
          $c$.clean();

          // If we are under constrained and the index variables are tainted, report.
          if (state_exceedsUpperBound.$bool() && state_withinUpperBound.$bool()) {
            if (state.$arrow().isTainted(new SVal(JD$Move.INSTANCE, rawOffset.getByteOffset()))) {
              reportOOB(checkerContext, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state_exceedsUpperBound)), OOB_Kind.OOB_Tainted); $c$.clean();
            }
            return;
          }

          // If we are constrained enough to definitely exceed the upper bound, report.
          if (state_exceedsUpperBound.$bool()) {
            assert (!state_withinUpperBound.$bool());
            reportOOB(checkerContext, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state_exceedsUpperBound)), OOB_Kind.OOB_Excedes); $c$.clean();
            return;
          }
          assert ((state_withinUpperBound).$bool());
          $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state_withinUpperBound))));
        } finally {
          if (state_withinUpperBound != null) { state_withinUpperBound.$destroy(); }
          if (state_exceedsUpperBound != null) { state_exceedsUpperBound.$destroy(); }
        }
      } while (false);
      if ($noteq_IntrusiveRefCntPtr(state, originalState)) {
        $c$.clean(checkerContext.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
      }
    } finally {
     if (originalState != null) { originalState.$destroy(); }
     if (state != null) { state.$destroy(); }
     $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ArrayBoundCheckerV2::~ArrayBoundCheckerV2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 29,
   FQN="(anonymous namespace)::ArrayBoundCheckerV2::~ArrayBoundCheckerV2", NM="_ZN12_GLOBAL__N_119ArrayBoundCheckerV2D0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZN12_GLOBAL__N_119ArrayBoundCheckerV2D0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ArrayBoundCheckerV2::ArrayBoundCheckerV2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 29,
   FQN="(anonymous namespace)::ArrayBoundCheckerV2::ArrayBoundCheckerV2", NM="_ZN12_GLOBAL__N_119ArrayBoundCheckerV2C1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZN12_GLOBAL__N_119ArrayBoundCheckerV2C1Ev")
  //</editor-fold>
  public /*inline*/ ArrayBoundCheckerV2() {
    // : Checker<Location>(), BT() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BuiltinBug>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new Location()
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT=" + BT // NOI18N
              + super.toString(); // NOI18N
  }
}
