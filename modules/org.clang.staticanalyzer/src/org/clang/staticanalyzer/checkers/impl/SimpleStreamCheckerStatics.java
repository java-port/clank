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
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.checkers.ento.impl.SimpleStreamCheckerStatics.ProgramStateTraitStreamMap;


//<editor-fold defaultstate="collapsed" desc="static type SimpleStreamCheckerStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.checkers.impl.SimpleStreamCheckerStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZL8isLeakedPKN5clang4ento7SymExprERKN12_GLOBAL__N_111StreamStateEbN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE;_ZN12_GLOBAL__N_111StreamStateE;_ZN12_GLOBAL__N_120StopTrackingCallbackE;_ZN12_GLOBAL__N_19StreamMapE; -static-type=SimpleStreamCheckerStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class SimpleStreamCheckerStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 31,
 FQN="(anonymous namespace)::StreamState", NM="_ZN12_GLOBAL__N_111StreamStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZN12_GLOBAL__N_111StreamStateE")
//</editor-fold>
public static class/*struct*/ StreamState implements FoldingSetTrait.Profilable, NativeCloneable<StreamState>, Native.NativeComparable<StreamState> {
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 33,
   FQN="(anonymous namespace)::StreamState::Kind", NM="_ZN12_GLOBAL__N_111StreamState4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZN12_GLOBAL__N_111StreamState4KindE")
  //</editor-fold>
  private enum Kind implements Native.NativeUIntEnum {
    Opened(0),
    Closed(Opened.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
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
    private Kind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  private  Kind K;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::StreamState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 34,
   FQN="(anonymous namespace)::StreamState::StreamState", NM="_ZN12_GLOBAL__N_111StreamStateC1ENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZN12_GLOBAL__N_111StreamStateC1ENS0_4KindE")
  //</editor-fold>
  private StreamState(Kind InK) {
    // : K(InK) 
    //START JInit
    this.K = InK;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::isOpened">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 37,
   FQN="(anonymous namespace)::StreamState::isOpened", NM="_ZNK12_GLOBAL__N_111StreamState8isOpenedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZNK12_GLOBAL__N_111StreamState8isOpenedEv")
  //</editor-fold>
  public boolean isOpened() /*const*/ {
    return K == Kind.Opened;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::isClosed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 38,
   FQN="(anonymous namespace)::StreamState::isClosed", NM="_ZNK12_GLOBAL__N_111StreamState8isClosedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZNK12_GLOBAL__N_111StreamState8isClosedEv")
  //</editor-fold>
  public boolean isClosed() /*const*/ {
    return K == Kind.Closed;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::getOpened">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 40,
   FQN="(anonymous namespace)::StreamState::getOpened", NM="_ZN12_GLOBAL__N_111StreamState9getOpenedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZN12_GLOBAL__N_111StreamState9getOpenedEv")
  //</editor-fold>
  public static StreamState getOpened() {
    return new StreamState(Kind.Opened);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::getClosed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 41,
   FQN="(anonymous namespace)::StreamState::getClosed", NM="_ZN12_GLOBAL__N_111StreamState9getClosedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZN12_GLOBAL__N_111StreamState9getClosedEv")
  //</editor-fold>
  public static StreamState getClosed() {
    return new StreamState(Kind.Closed);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 43,
   FQN="(anonymous namespace)::StreamState::operator==", NM="_ZNK12_GLOBAL__N_111StreamStateeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZNK12_GLOBAL__N_111StreamStateeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ StreamState /*&*/ X) /*const*/ {
    return K == X.K;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 46,
   FQN="(anonymous namespace)::StreamState::Profile", NM="_ZNK12_GLOBAL__N_111StreamState7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZNK12_GLOBAL__N_111StreamState7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public/*public*/ void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddInteger_int(K.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::StreamState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 31,
   FQN="(anonymous namespace)::StreamState::StreamState", NM="_ZN12_GLOBAL__N_111StreamStateC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZN12_GLOBAL__N_111StreamStateC1ERKS0_")
  //</editor-fold>
  public /*inline*/ StreamState(final /*const*/ StreamState /*&*/ $Prm0) {
    // : K(.K) 
    //START JInit
    this.K = $Prm0.K;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::StreamState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 31,
   FQN="(anonymous namespace)::StreamState::StreamState", NM="_ZN12_GLOBAL__N_111StreamStateC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZN12_GLOBAL__N_111StreamStateC1EOS0_")
  //</editor-fold>
  public /*inline*/ StreamState(JD$Move _dparam, final StreamState /*&&*/$Prm0) {
    // : K(static_cast<StreamState &&>().K) 
    //START JInit
    this.K = $Prm0.K;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public StreamState clone() { return new StreamState(this); }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "K=" + K; // NOI18N
  }
}
// end anonymous namespace

/// The state of the checker is a map from tracked stream symbols to their
/// state. Let's store it in the ProgramState.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 90,
 FQN="(anonymous namespace)::StreamMap", NM="_ZN12_GLOBAL__N_19StreamMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZN12_GLOBAL__N_19StreamMapE")
//</editor-fold>
public static class StreamMap {
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StopTrackingCallback">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 93,
 FQN="(anonymous namespace)::StopTrackingCallback", NM="_ZN12_GLOBAL__N_120StopTrackingCallbackE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZN12_GLOBAL__N_120StopTrackingCallbackE")
//</editor-fold>
public static final class StopTrackingCallback extends /*public*/ SymbolVisitor implements Destructors.ClassWithDestructor {
  private IntrusiveRefCntPtr</*const*/ ProgramState> state;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StopTrackingCallback::StopTrackingCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 96,
   FQN="(anonymous namespace)::StopTrackingCallback::StopTrackingCallback", NM="_ZN12_GLOBAL__N_120StopTrackingCallbackC1EN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZN12_GLOBAL__N_120StopTrackingCallbackC1EN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEE")
  //</editor-fold>
  public StopTrackingCallback(IntrusiveRefCntPtr</*const*/ ProgramState> st) {
    // : SymbolVisitor(), state(std::move(st)) 
    //START JInit
    super();
    this.state = new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, std.move(st));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StopTrackingCallback::getState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 97,
   FQN="(anonymous namespace)::StopTrackingCallback::getState", NM="_ZNK12_GLOBAL__N_120StopTrackingCallback8getStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZNK12_GLOBAL__N_120StopTrackingCallback8getStateEv")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> getState() /*const*/ {
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(state);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StopTrackingCallback::VisitSymbol">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 99,
   FQN="(anonymous namespace)::StopTrackingCallback::VisitSymbol", NM="_ZN12_GLOBAL__N_120StopTrackingCallback11VisitSymbolEPKN5clang4ento7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZN12_GLOBAL__N_120StopTrackingCallback11VisitSymbolEPKN5clang4ento7SymExprE")
  //</editor-fold>
  @Override public boolean VisitSymbol(/*const*/ SymExpr /*P*/ sym)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(state.$assign($c$.track(state.$arrow().remove(ProgramStateTraitStreamMap.$Instance, sym))));
      return true;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StopTrackingCallback::~StopTrackingCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 93,
   FQN="(anonymous namespace)::StopTrackingCallback::~StopTrackingCallback", NM="_ZN12_GLOBAL__N_120StopTrackingCallbackD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZN12_GLOBAL__N_120StopTrackingCallbackD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }


  
  @Override public String toString() {
    return "" + "state=" + state // NOI18N
              + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="isLeaked">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 163,
 FQN="isLeaked", NM="_ZL8isLeakedPKN5clang4ento7SymExprERKN12_GLOBAL__N_111StreamStateEbN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZL8isLeakedPKN5clang4ento7SymExprERKN12_GLOBAL__N_111StreamStateEbN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
//</editor-fold>
public static boolean isLeaked(/*const*/ SymExpr /*P*/ Sym, final /*const*/ StreamState /*&*/ SS, 
        boolean IsSymDead, IntrusiveRefCntPtr</*const*/ ProgramState> State) {
  if (IsSymDead && SS.isOpened()) {
    ConditionTruthVal OpenFailed = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // If a symbol is NULL, assume that fopen failed on this path.
      // A symbol should only be considered leaked if it is non-null.
      final ConstraintManager /*&*/ CMgr = State.$arrow().getConstraintManager();
      OpenFailed = $c$.clean(CMgr.isNull($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Sym));
      return !OpenFailed.isConstrainedTrue();
    } finally {
      if (OpenFailed != null) { OpenFailed.$destroy(); }
      $c$.$destroy();
    }
  }
  return false;
}

} // END OF class SimpleStreamCheckerStatics
