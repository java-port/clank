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
package org.clang.staticanalyzer.checkers.ento;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.checkers.ento.objc_retain.*;
import org.clang.staticanalyzer.checkers.llvm.impl.FoldingSetTraitArgEffect;
import org.clang.staticanalyzer.checkers.llvm.impl.FoldingSetTraitRetEffect;
import org.llvm.adt.FoldingSetNodeID;
import org.llvm.adt.FoldingSetTrait;


//<editor-fold defaultstate="collapsed" desc="static type objc_retain">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN5clang4ento11objc_retain11CallEffectsE;_ZN5clang4ento11objc_retain9ArgEffectE;_ZN5clang4ento11objc_retain9RetEffectE; -static-type=objc_retain -package=org.clang.staticanalyzer.checkers.ento")
//</editor-fold>
public final class objc_retain {


/// An ArgEffect summarizes the retain count behavior on an argument or receiver
/// to a function or method.
//<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::ArgEffect">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 34,
 FQN="clang::ento::objc_retain::ArgEffect", NM="_ZN5clang4ento11objc_retain9ArgEffectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4ento11objc_retain9ArgEffectE")
//</editor-fold>
public enum ArgEffect implements FoldingSetTrait.Profilable, Native.NativeUIntEnum {
  /// There is no effect.
  DoNothing(0),
  
  /// The argument is treated as if an -autorelease message had been sent to
  /// the referenced object.
  Autorelease(DoNothing.getValue() + 1),
  
  /// The argument is treated as if an -dealloc message had been sent to
  /// the referenced object.
  Dealloc(Autorelease.getValue() + 1),
  
  /// The argument has its reference count decreased by 1.  This is as
  /// if CFRelease has been called on the argument.
  DecRef(Dealloc.getValue() + 1),
  
  /// The argument has its reference count decreased by 1.  This is as
  /// if a -release message has been sent to the argument.  This differs
  /// in behavior from DecRef when GC is enabled.
  DecRefMsg(DecRef.getValue() + 1),
  
  /// The argument has its reference count decreased by 1 to model
  /// a transferred bridge cast under ARC.
  DecRefBridgedTransferred(DecRefMsg.getValue() + 1),
  
  /// The argument has its reference count increased by 1.  This is as
  /// if a -retain message has been sent to the argument.  This differs
  /// in behavior from IncRef when GC is enabled.
  IncRefMsg(DecRefBridgedTransferred.getValue() + 1),
  
  /// The argument has its reference count increased by 1.  This is as
  /// if CFRetain has been called on the argument.
  IncRef(IncRefMsg.getValue() + 1),
  
  /// The argument acts as if has been passed to CFMakeCollectable, which
  /// transfers the object to the Garbage Collector under GC.
  MakeCollectable(IncRef.getValue() + 1),
  
  /// The argument is a pointer to a retain-counted object; on exit, the new
  /// value of the pointer is a +0 value or NULL.
  UnretainedOutParameter(MakeCollectable.getValue() + 1),
  
  /// The argument is a pointer to a retain-counted object; on exit, the new
  /// value of the pointer is a +1 value or NULL.
  RetainedOutParameter(UnretainedOutParameter.getValue() + 1),
  
  /// The argument is treated as potentially escaping, meaning that
  /// even when its reference count hits 0 it should be treated as still
  /// possibly being alive as someone else *may* be holding onto the object.
  MayEscape(RetainedOutParameter.getValue() + 1),
  
  /// All typestate tracking of the object ceases.  This is usually employed
  /// when the effect of the call is completely unknown.
  StopTracking(MayEscape.getValue() + 1),
  
  /// All typestate tracking of the object ceases.  Unlike StopTracking,
  /// this is also enforced when the method body is inlined.
  ///
  /// In some cases, we obtain a better summary for this checker
  /// by looking at the call site than by inlining the function.
  /// Signifies that we should stop tracking the symbol even if
  /// the function is inlined.
  StopTrackingHard(StopTracking.getValue() + 1),
  
  /// Performs the combined functionality of DecRef and StopTrackingHard.
  ///
  /// The models the effect that the called function decrements the reference
  /// count of the argument and all typestate tracking on that argument
  /// should cease.
  DecRefAndStopTrackingHard(StopTrackingHard.getValue() + 1),
  
  /// Performs the combined functionality of DecRefMsg and StopTrackingHard.
  ///
  /// The models the effect that the called function decrements the reference
  /// count of the argument and all typestate tracking on that argument
  /// should cease.
  DecRefMsgAndStopTrackingHard(DecRefAndStopTrackingHard.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ArgEffect valueOf(int val) {
    ArgEffect out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ArgEffect[] VALUES;
    private static final ArgEffect[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ArgEffect kind : ArgEffect.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ArgEffect[min < 0 ? (1-min) : 0];
      VALUES = new ArgEffect[max >= 0 ? (1+max) : 0];
      for (ArgEffect kind : ArgEffect.values()) {
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
  private ArgEffect(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>

  @Override public void Profile(FoldingSetNodeID ID) {
    FoldingSetTraitArgEffect.Profile(this, ID);
  }
}

/// RetEffect summarizes a call's retain/release behavior with respect
/// to its return value.
//<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::RetEffect">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 115,
 FQN="clang::ento::objc_retain::RetEffect", NM="_ZN5clang4ento11objc_retain9RetEffectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4ento11objc_retain9RetEffectE")
//</editor-fold>
public static class RetEffect implements FoldingSetTrait.Profilable, Native.NativeComparable<RetEffect> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::RetEffect::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 117,
   FQN="clang::ento::objc_retain::RetEffect::Kind", NM="_ZN5clang4ento11objc_retain9RetEffect4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4ento11objc_retain9RetEffect4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    /// Indicates that no retain count information is tracked for
    /// the return value.
    NoRet(0),
    /// Indicates that the returned value is an owned (+1) symbol.
    OwnedSymbol(NoRet.getValue() + 1),
    /// Indicates that the returned value is an owned (+1) symbol and
    /// that it should be treated as freshly allocated.
    OwnedAllocatedSymbol(OwnedSymbol.getValue() + 1),
    /// Indicates that the returned value is an object with retain count
    /// semantics but that it is not owned (+0).  This is the default
    /// for getters, etc.
    NotOwnedSymbol(OwnedAllocatedSymbol.getValue() + 1),
    /// Indicates that the object is not owned and controlled by the
    /// Garbage collector.
    GCNotOwnedSymbol(NotOwnedSymbol.getValue() + 1),
    /// Indicates that the return value is an owned object when the
    /// receiver is also a tracked object.
    OwnedWhenTrackedReceiver(GCNotOwnedSymbol.getValue() + 1),
    // Treat this function as returning a non-tracked symbol even if
    // the function has been inlined. This is used where the call
    // site summary is more presise than the summary indirectly produced
    // by inlining the function
    NoRetHard(OwnedWhenTrackedReceiver.getValue() + 1);

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
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
    //</editor-fold>
  };
  
  /// Determines the object kind of a tracked object.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::RetEffect::ObjKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 144,
   FQN="clang::ento::objc_retain::RetEffect::ObjKind", NM="_ZN5clang4ento11objc_retain9RetEffect7ObjKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4ento11objc_retain9RetEffect7ObjKindE")
  //</editor-fold>
  public enum ObjKind implements Native.ComparableLower {
    /// Indicates that the tracked object is a CF object.  This is
    /// important between GC and non-GC code.
    CF(0),
    /// Indicates that the tracked object is an Objective-C object.
    ObjC(CF.getValue() + 1),
    /// Indicates that the tracked object could be a CF or Objective-C object.
    AnyObj(ObjC.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ObjKind valueOf(int val) {
      ObjKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ObjKind[] VALUES;
      private static final ObjKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ObjKind kind : ObjKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ObjKind[min < 0 ? (1-min) : 0];
        VALUES = new ObjKind[max >= 0 ? (1+max) : 0];
        for (ObjKind kind : ObjKind.values()) {
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
    private ObjKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ObjKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ObjKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private Kind K;
  private ObjKind O;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::RetEffect::RetEffect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 158,
   FQN="clang::ento::objc_retain::RetEffect::RetEffect", NM="_ZN5clang4ento11objc_retain9RetEffectC1ENS2_4KindENS2_7ObjKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4ento11objc_retain9RetEffectC1ENS2_4KindENS2_7ObjKindE")
  //</editor-fold>
  private RetEffect(Kind k) {
    this(k, ObjKind.AnyObj);
  }
  private RetEffect(Kind k, ObjKind o/*= AnyObj*/) {
    // : K(k), O(o) 
    //START JInit
    this.K = k;
    this.O = o;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::RetEffect::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 161,
   FQN="clang::ento::objc_retain::RetEffect::getKind", NM="_ZNK5clang4ento11objc_retain9RetEffect7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang4ento11objc_retain9RetEffect7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    return K;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::RetEffect::getObjKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 163,
   FQN="clang::ento::objc_retain::RetEffect::getObjKind", NM="_ZNK5clang4ento11objc_retain9RetEffect10getObjKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang4ento11objc_retain9RetEffect10getObjKindEv")
  //</editor-fold>
  public ObjKind getObjKind() /*const*/ {
    return O;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::RetEffect::isOwned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 165,
   FQN="clang::ento::objc_retain::RetEffect::isOwned", NM="_ZNK5clang4ento11objc_retain9RetEffect7isOwnedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang4ento11objc_retain9RetEffect7isOwnedEv")
  //</editor-fold>
  public boolean isOwned() /*const*/ {
    return K == Kind.OwnedSymbol || K == Kind.OwnedAllocatedSymbol
       || K == Kind.OwnedWhenTrackedReceiver;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::RetEffect::notOwned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 170,
   FQN="clang::ento::objc_retain::RetEffect::notOwned", NM="_ZNK5clang4ento11objc_retain9RetEffect8notOwnedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang4ento11objc_retain9RetEffect8notOwnedEv")
  //</editor-fold>
  public boolean notOwned() /*const*/ {
    return K == Kind.NotOwnedSymbol;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::RetEffect::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 174,
   FQN="clang::ento::objc_retain::RetEffect::operator==", NM="_ZNK5clang4ento11objc_retain9RetEffecteqERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang4ento11objc_retain9RetEffecteqERKS2_")
  //</editor-fold>
  public boolean $eq(final /*const*/ RetEffect /*&*/ Other) /*const*/ {
    return K == Other.K && O == Other.O;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::RetEffect::MakeOwnedWhenTrackedReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 178,
   FQN="clang::ento::objc_retain::RetEffect::MakeOwnedWhenTrackedReceiver", NM="_ZN5clang4ento11objc_retain9RetEffect28MakeOwnedWhenTrackedReceiverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4ento11objc_retain9RetEffect28MakeOwnedWhenTrackedReceiverEv")
  //</editor-fold>
  public static RetEffect MakeOwnedWhenTrackedReceiver() {
    return new RetEffect(Kind.OwnedWhenTrackedReceiver, ObjKind.ObjC);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::RetEffect::MakeOwned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 182,
   FQN="clang::ento::objc_retain::RetEffect::MakeOwned", NM="_ZN5clang4ento11objc_retain9RetEffect9MakeOwnedENS2_7ObjKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4ento11objc_retain9RetEffect9MakeOwnedENS2_7ObjKindEb")
  //</editor-fold>
  public static RetEffect MakeOwned(ObjKind o) {
    return MakeOwned(o, false);
  }
  public static RetEffect MakeOwned(ObjKind o, boolean isAllocated/*= false*/) {
    return new RetEffect(isAllocated ? Kind.OwnedAllocatedSymbol : Kind.OwnedSymbol, o);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::RetEffect::MakeNotOwned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 185,
   FQN="clang::ento::objc_retain::RetEffect::MakeNotOwned", NM="_ZN5clang4ento11objc_retain9RetEffect12MakeNotOwnedENS2_7ObjKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4ento11objc_retain9RetEffect12MakeNotOwnedENS2_7ObjKindE")
  //</editor-fold>
  public static RetEffect MakeNotOwned(ObjKind o) {
    return new RetEffect(Kind.NotOwnedSymbol, o);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::RetEffect::MakeGCNotOwned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 188,
   FQN="clang::ento::objc_retain::RetEffect::MakeGCNotOwned", NM="_ZN5clang4ento11objc_retain9RetEffect14MakeGCNotOwnedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4ento11objc_retain9RetEffect14MakeGCNotOwnedEv")
  //</editor-fold>
  public static RetEffect MakeGCNotOwned() {
    return new RetEffect(Kind.GCNotOwnedSymbol, ObjKind.ObjC);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::RetEffect::MakeNoRet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 191,
   FQN="clang::ento::objc_retain::RetEffect::MakeNoRet", NM="_ZN5clang4ento11objc_retain9RetEffect9MakeNoRetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4ento11objc_retain9RetEffect9MakeNoRetEv")
  //</editor-fold>
  public static RetEffect MakeNoRet() {
    return new RetEffect(Kind.NoRet);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::RetEffect::MakeNoRetHard">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 194,
   FQN="clang::ento::objc_retain::RetEffect::MakeNoRetHard", NM="_ZN5clang4ento11objc_retain9RetEffect13MakeNoRetHardEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4ento11objc_retain9RetEffect13MakeNoRetHardEv")
  //</editor-fold>
  public static RetEffect MakeNoRetHard() {
    return new RetEffect(Kind.NoRetHard);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::RetEffect::RetEffect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 115,
   FQN="clang::ento::objc_retain::RetEffect::RetEffect", NM="_ZN5clang4ento11objc_retain9RetEffectC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4ento11objc_retain9RetEffectC1ERKS2_")
  //</editor-fold>
  public /*inline*/ RetEffect(final /*const*/ RetEffect /*&*/ $Prm0) {
    // : K(.K), O(.O) 
    //START JInit
    this.K = $Prm0.K;
    this.O = $Prm0.O;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::RetEffect::RetEffect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 115,
   FQN="clang::ento::objc_retain::RetEffect::RetEffect", NM="_ZN5clang4ento11objc_retain9RetEffectC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4ento11objc_retain9RetEffectC1EOS2_")
  //</editor-fold>
  public /*inline*/ RetEffect(JD$Move _dparam, final RetEffect /*&&*/$Prm0) {
    // : K(static_cast<RetEffect &&>().K), O(static_cast<RetEffect &&>().O) 
    //START JInit
    this.K = $Prm0.K;
    this.O = $Prm0.O;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::RetEffect::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 115,
   FQN="clang::ento::objc_retain::RetEffect::operator=", NM="_ZN5clang4ento11objc_retain9RetEffectaSERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN5clang4ento11objc_retain9RetEffectaSERKS2_")
  //</editor-fold>
  public /*inline*/ RetEffect /*&*/ $assign(final /*const*/ RetEffect /*&*/ $Prm0) {
    this.K = $Prm0.K;
    this.O = $Prm0.O;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::RetEffect::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 115,
   FQN="clang::ento::objc_retain::RetEffect::operator=", NM="_ZN5clang4ento11objc_retain9RetEffectaSEOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN5clang4ento11objc_retain9RetEffectaSEOS2_")
  //</editor-fold>
  public /*inline*/ RetEffect /*&*/ $assignMove(final RetEffect /*&&*/$Prm0) {
    this.K = $Prm0.K;
    this.O = $Prm0.O;
    return /*Deref*/this;
  }

  @Override public void Profile(FoldingSetNodeID ID) {
    FoldingSetTraitRetEffect.Profile(this, ID);
  }
    
  @Override public String toString() {
    return "" + "K=" + K // NOI18N
              + ", O=" + O; // NOI18N
  }
}

/// Encapsulates the retain count semantics on the arguments, return value,
/// and receiver (if any) of a function/method call.
///
/// Note that construction of these objects is not highly efficient.  That
/// is okay for clients where creating these objects isn't really a bottleneck.
/// The purpose of the API is to provide something simple.  The actual
/// static analyzer checker that implements retain/release typestate
/// tracking uses something more efficient.
//<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::CallEffects">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 207,
 FQN="clang::ento::objc_retain::CallEffects", NM="_ZN5clang4ento11objc_retain11CallEffectsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4ento11objc_retain11CallEffectsE")
//</editor-fold>
public static class CallEffects implements Destructors.ClassWithDestructor {
  private SmallVector<ArgEffect> Args;
  private RetEffect Ret;
  private ArgEffect Receiver;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::CallEffects::CallEffects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 212,
   FQN="clang::ento::objc_retain::CallEffects::CallEffects", NM="_ZN5clang4ento11objc_retain11CallEffectsC1ERKNS1_9RetEffectE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4ento11objc_retain11CallEffectsC1ERKNS1_9RetEffectE")
  //</editor-fold>
  private CallEffects(final /*const*/ RetEffect /*&*/ R) {
    // : Args(), Ret(R) 
    //START JInit
    this.Args = new SmallVector<ArgEffect>(10, ArgEffect.valueOf(0));
    this.Ret = new RetEffect(R);
    //END JInit
  }

/*public:*/
  /// Returns the argument effects for a call.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::CallEffects::getArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 216,
   FQN="clang::ento::objc_retain::CallEffects::getArgs", NM="_ZNK5clang4ento11objc_retain11CallEffects7getArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang4ento11objc_retain11CallEffects7getArgsEv")
  //</editor-fold>
  public ArrayRef<ArgEffect> getArgs() /*const*/ {
    return new ArrayRef<ArgEffect>(Args);
  }

  
  /// Returns the effects on the receiver.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::CallEffects::getReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 219,
   FQN="clang::ento::objc_retain::CallEffects::getReceiver", NM="_ZNK5clang4ento11objc_retain11CallEffects11getReceiverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang4ento11objc_retain11CallEffects11getReceiverEv")
  //</editor-fold>
  public ArgEffect getReceiver() /*const*/ {
    return Receiver;
  }

  
  /// Returns the effect on the return value.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::CallEffects::getReturnValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 222,
   FQN="clang::ento::objc_retain::CallEffects::getReturnValue", NM="_ZNK5clang4ento11objc_retain11CallEffects14getReturnValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang4ento11objc_retain11CallEffects14getReturnValueEv")
  //</editor-fold>
  public RetEffect getReturnValue() /*const*/ {
    return new RetEffect(Ret);
  }

  
  /// Return the CallEfect for a given Objective-C method.
  
  /// Return the CallEfect for a given Objective-C method.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::CallEffects::getEffect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 4008,
   FQN="clang::ento::objc_retain::CallEffects::getEffect", NM="_ZN5clang4ento11objc_retain11CallEffects9getEffectEPKNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN5clang4ento11objc_retain11CallEffects9getEffectEPKNS_14ObjCMethodDeclE")
  //</editor-fold>
  public static CallEffects getEffect(/*const*/ ObjCMethodDecl /*P*/ MD) {
    RetainSummaryManager M = null;
    CallEffects CE = null;
    try {
      final ASTContext /*&*/ Ctx = MD.getASTContext();
      LangOptions L = new LangOptions(Ctx.getLangOpts());
      M/*J*/= new RetainSummaryManager(Ctx, ((LangOptions.GCMode.GCOnly).getValue() != 0), L.ObjCAutoRefCount);
      /*const*/ RetainSummary /*P*/ S = M.getMethodSummary(MD);
      CE/*J*/= new CallEffects(S.getRetEffect());
      CE.Receiver = S.getReceiverEffect();
      /*uint*/int N = MD.param_size();
      for (/*uint*/int i = 0; $less_uint(i, N); ++i) {
        CE.Args.push_back(S.getArg(i));
      }
      ;
      return new CallEffects(JD$Move.INSTANCE, CE);
    } finally {
      if (CE != null) { CE.$destroy(); }
      if (M != null) { M.$destroy(); }
    }
  }


  
  /// Return the CallEfect for a given C/C++ function.
  
  /// Return the CallEfect for a given C/C++ function.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::CallEffects::getEffect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 4013,
   FQN="clang::ento::objc_retain::CallEffects::getEffect", NM="_ZN5clang4ento11objc_retain11CallEffects9getEffectEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN5clang4ento11objc_retain11CallEffects9getEffectEPKNS_12FunctionDeclE")
  //</editor-fold>
  public static CallEffects getEffect(/*const*/ FunctionDecl /*P*/ FD) {
    RetainSummaryManager M = null;
    CallEffects CE = null;
    try {
      final ASTContext /*&*/ Ctx = FD.getASTContext();
      LangOptions L = new LangOptions(Ctx.getLangOpts());
      M/*J*/= new RetainSummaryManager(Ctx, ((LangOptions.GCMode.GCOnly).getValue() != 0), L.ObjCAutoRefCount);
      /*const*/ RetainSummary /*P*/ S = M.getFunctionSummary(FD);
      CE/*J*/= new CallEffects(S.getRetEffect());
      CE.Receiver = S.getReceiverEffect();
      /*uint*/int N = FD.param_size();
      for (/*uint*/int i = 0; $less_uint(i, N); ++i) {
        CE.Args.push_back(S.getArg(i));
      }
      ;
      return new CallEffects(JD$Move.INSTANCE, CE);
    } finally {
      if (CE != null) { CE.$destroy(); }
      if (M != null) { M.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::CallEffects::CallEffects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 207,
   FQN="clang::ento::objc_retain::CallEffects::CallEffects", NM="_ZN5clang4ento11objc_retain11CallEffectsC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4ento11objc_retain11CallEffectsC1EOS2_")
  //</editor-fold>
  public /*inline*/ CallEffects(JD$Move _dparam, final CallEffects /*&&*/$Prm0) {
    // : Args(static_cast<CallEffects &&>().Args), Ret(static_cast<CallEffects &&>().Ret), Receiver(static_cast<CallEffects &&>().Receiver) 
    //START JInit
    this.Args = new SmallVector<ArgEffect>(JD$Move.INSTANCE, $Prm0.Args);
    this.Ret = new RetEffect(JD$Move.INSTANCE, $Prm0.Ret);
    this.Receiver = $Prm0.Receiver;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::objc_retain::CallEffects::~CallEffects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/ObjCRetainCount.h", line = 207,
   FQN="clang::ento::objc_retain::CallEffects::~CallEffects", NM="_ZN5clang4ento11objc_retain11CallEffectsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4ento11objc_retain11CallEffectsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Args.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Args=" + Args // NOI18N
              + ", Ret=" + Ret // NOI18N
              + ", Receiver=" + Receiver; // NOI18N
  }
}
} // END OF class objc_retain
