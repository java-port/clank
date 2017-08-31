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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.checkers.ento.objc_retain.*;
import static org.clang.ast.QualType.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 76,
 FQN="(anonymous namespace)::RefVal", NM="_ZN12_GLOBAL__N_16RefValE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_16RefValE")
//</editor-fold>
public class RefVal implements Native.NativeComparable<RefVal>, FoldingSetTrait.Profilable, NativeCloneable<RefVal> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 78,
   FQN="(anonymous namespace)::RefVal::Kind", NM="_ZN12_GLOBAL__N_16RefVal4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_16RefVal4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    Owned(0), // Owning reference.
    NotOwned(Owned.getValue() + 1), // Reference is not owned by still valid (not freed).
    Released(NotOwned.getValue() + 1), // Object has been released.
    ReturnedOwned(Released.getValue() + 1), // Returned object passes ownership to caller.
    ReturnedNotOwned(ReturnedOwned.getValue() + 1), // Return object does not pass ownership to caller.
    ERROR_START(ReturnedNotOwned.getValue() + 1),
    ErrorDeallocNotOwned(ERROR_START.getValue() + 1), // -dealloc called on non-owned object.
    ErrorDeallocGC(ErrorDeallocNotOwned.getValue() + 1), // Calling -dealloc with GC enabled.
    ErrorUseAfterRelease(ErrorDeallocGC.getValue() + 1), // Object used after released.
    ErrorReleaseNotOwned(ErrorUseAfterRelease.getValue() + 1), // Release of an object that was not owned.
    ERROR_LEAK_START(ErrorReleaseNotOwned.getValue() + 1),
    ErrorLeak(ERROR_LEAK_START.getValue() + 1), // A memory leak due to excessive reference counts.
    ErrorLeakReturned(ErrorLeak.getValue() + 1), // A memory leak due to the returning method not having
    // the correct naming conventions.
    ErrorGCLeakReturned(ErrorLeakReturned.getValue() + 1),
    ErrorOverAutorelease(ErrorGCLeakReturned.getValue() + 1),
    ErrorReturnedNotOwned(ErrorOverAutorelease.getValue() + 1);

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
  
  /// Tracks how an object referenced by an ivar has been used.
  ///
  /// This accounts for us not knowing if an arbitrary ivar is supposed to be
  /// stored at +0 or +1.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::IvarAccessHistory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 102,
   FQN="(anonymous namespace)::RefVal::IvarAccessHistory", NM="_ZN12_GLOBAL__N_16RefVal17IvarAccessHistoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_16RefVal17IvarAccessHistoryE")
  //</editor-fold>
  public enum /*class */IvarAccessHistory/* : int*/ implements Native.ComparableLower {
    None(0),
    AccessedDirectly(None.getValue() + 1),
    ReleasedAfterDirectAccess(AccessedDirectly.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static IvarAccessHistory valueOf(int val) {
      IvarAccessHistory out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final IvarAccessHistory[] VALUES;
      private static final IvarAccessHistory[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (IvarAccessHistory kind : IvarAccessHistory.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new IvarAccessHistory[min < 0 ? (1-min) : 0];
        VALUES = new IvarAccessHistory[max >= 0 ? (1+max) : 0];
        for (IvarAccessHistory kind : IvarAccessHistory.values()) {
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

    private final int value;
    private IvarAccessHistory(int val) { this.value = (int)val;}
    public int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_int(value, ((IvarAccessHistory)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_int(value, ((IvarAccessHistory)obj).value);}
    //</editor-fold>
  };
/*private:*/
  /// The number of outstanding retains.
  private /*uint*/int Cnt;
  /// The number of outstanding autoreleases.
  private /*uint*/int ACnt;
  /// The (static) type of the object at the time we started tracking it.
  private QualType T;
  
  /// The current state of the object.
  ///
  /// See the RefVal::Kind enum for possible values.
  private /*JBYTE unsigned int*/ byte RawKind /*: 5*/;
  
  /// The kind of object being tracked (CF or ObjC), if known.
  ///
  /// See the RetEffect::ObjKind enum for possible values.
  private /*JBYTE unsigned int*/ byte RawObjectKind /*: 2*/;
  
  /// True if the current state and/or retain count may turn out to not be the
  /// best possible approximation of the reference counting state.
  ///
  /// If true, the checker may decide to throw away ("override") this state
  /// in favor of something else when it sees the object being used in new ways.
  ///
  /// This setting should not be propagated to state derived from this state.
  /// Once we start deriving new states, it would be inconsistent to override
  /// them.
  private /*JBYTE unsigned int*/ byte RawIvarAccessHistory /*: 2*/;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::RefVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 137,
   FQN="(anonymous namespace)::RefVal::RefVal", NM="_ZN12_GLOBAL__N_16RefValC1ENS0_4KindEN5clang4ento11objc_retain9RetEffect7ObjKindEjjNS2_8QualTypeENS0_17IvarAccessHistoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_16RefValC1ENS0_4KindEN5clang4ento11objc_retain9RetEffect7ObjKindEjjNS2_8QualTypeENS0_17IvarAccessHistoryE")
  //</editor-fold>
  private RefVal(Kind k, RetEffect.ObjKind o, /*uint*/int cnt, /*uint*/int acnt, QualType t, 
      IvarAccessHistory IvarAccess) {
    // : Cnt(cnt), ACnt(acnt), T(t), RawKind(static_cast<unsigned int>(k)), RawObjectKind(static_cast<unsigned int>(o)), RawIvarAccessHistory(static_cast<unsigned int>(IvarAccess)) 
    //START JInit
    this.Cnt = cnt;
    this.ACnt = acnt;
    this.T = new QualType(t);
    this.RawKind = $uint2uint_5bits(((/*static_cast*//*uint*/int)(k.getValue())));
    this.RawObjectKind = $uint2uint_2bits(((/*static_cast*//*uint*/int)(o.getValue())));
    this.RawIvarAccessHistory = $uint2uint_2bits(((/*static_cast*//*uint*/int)IvarAccess.getValue()));
    //END JInit
    assert (getKind() == k) : "not enough bits for the kind";
    assert (getObjKind() == o) : "not enough bits for the object kind";
    assert (getIvarAccessHistory() == IvarAccess) : "not enough bits";
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 148,
   FQN="(anonymous namespace)::RefVal::getKind", NM="_ZNK12_GLOBAL__N_16RefVal7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefVal7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    return /*static_cast*/Kind.valueOf($5bits_uint2uint(RawKind));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::getObjKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 150,
   FQN="(anonymous namespace)::RefVal::getObjKind", NM="_ZNK12_GLOBAL__N_16RefVal10getObjKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefVal10getObjKindEv")
  //</editor-fold>
  public RetEffect.ObjKind getObjKind() /*const*/ {
    return /*static_cast*/RetEffect.ObjKind.valueOf($2bits_uint2uint(RawObjectKind)); 
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::getCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 154,
   FQN="(anonymous namespace)::RefVal::getCount", NM="_ZNK12_GLOBAL__N_16RefVal8getCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefVal8getCountEv")
  //</editor-fold>
  public /*uint*/int getCount() /*const*/ {
    return Cnt;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::getAutoreleaseCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 155,
   FQN="(anonymous namespace)::RefVal::getAutoreleaseCount", NM="_ZNK12_GLOBAL__N_16RefVal19getAutoreleaseCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefVal19getAutoreleaseCountEv")
  //</editor-fold>
  public /*uint*/int getAutoreleaseCount() /*const*/ {
    return ACnt;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::getCombinedCounts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 156,
   FQN="(anonymous namespace)::RefVal::getCombinedCounts", NM="_ZNK12_GLOBAL__N_16RefVal17getCombinedCountsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefVal17getCombinedCountsEv")
  //</editor-fold>
  public /*uint*/int getCombinedCounts() /*const*/ {
    return Cnt + ACnt;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::clearCounts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 157,
   FQN="(anonymous namespace)::RefVal::clearCounts", NM="_ZN12_GLOBAL__N_16RefVal11clearCountsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_16RefVal11clearCountsEv")
  //</editor-fold>
  public void clearCounts() {
    Cnt = 0;
    ACnt = 0;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::setCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 161,
   FQN="(anonymous namespace)::RefVal::setCount", NM="_ZN12_GLOBAL__N_16RefVal8setCountEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_16RefVal8setCountEj")
  //</editor-fold>
  public void setCount(/*uint*/int i) {
    Cnt = i;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::setAutoreleaseCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 164,
   FQN="(anonymous namespace)::RefVal::setAutoreleaseCount", NM="_ZN12_GLOBAL__N_16RefVal19setAutoreleaseCountEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_16RefVal19setAutoreleaseCountEj")
  //</editor-fold>
  public void setAutoreleaseCount(/*uint*/int i) {
    ACnt = i;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 168,
   FQN="(anonymous namespace)::RefVal::getType", NM="_ZNK12_GLOBAL__N_16RefVal7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefVal7getTypeEv")
  //</editor-fold>
  public QualType getType() /*const*/ {
    return new QualType(T);
  }

  
  /// Returns what the analyzer knows about direct accesses to a particular
  /// instance variable.
  ///
  /// If the object with this refcount wasn't originally from an Objective-C
  /// ivar region, this should always return IvarAccessHistory::None.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::getIvarAccessHistory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 175,
   FQN="(anonymous namespace)::RefVal::getIvarAccessHistory", NM="_ZNK12_GLOBAL__N_16RefVal20getIvarAccessHistoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefVal20getIvarAccessHistoryEv")
  //</editor-fold>
  public IvarAccessHistory getIvarAccessHistory() /*const*/ {
    return /*static_cast*/IvarAccessHistory.valueOf($2bits_uint2uint(RawIvarAccessHistory));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::isOwned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 179,
   FQN="(anonymous namespace)::RefVal::isOwned", NM="_ZNK12_GLOBAL__N_16RefVal7isOwnedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefVal7isOwnedEv")
  //</editor-fold>
  public boolean isOwned() /*const*/ {
    return getKind() == Kind.Owned;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::isNotOwned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 183,
   FQN="(anonymous namespace)::RefVal::isNotOwned", NM="_ZNK12_GLOBAL__N_16RefVal10isNotOwnedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefVal10isNotOwnedEv")
  //</editor-fold>
  public boolean isNotOwned() /*const*/ {
    return getKind() == Kind.NotOwned;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::isReturnedOwned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 187,
   FQN="(anonymous namespace)::RefVal::isReturnedOwned", NM="_ZNK12_GLOBAL__N_16RefVal15isReturnedOwnedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefVal15isReturnedOwnedEv")
  //</editor-fold>
  public boolean isReturnedOwned() /*const*/ {
    return getKind() == Kind.ReturnedOwned;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::isReturnedNotOwned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 191,
   FQN="(anonymous namespace)::RefVal::isReturnedNotOwned", NM="_ZNK12_GLOBAL__N_16RefVal18isReturnedNotOwnedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefVal18isReturnedNotOwnedEv")
  //</editor-fold>
  public boolean isReturnedNotOwned() /*const*/ {
    return getKind() == Kind.ReturnedNotOwned;
  }

  
  /// Create a state for an object whose lifetime is the responsibility of the
  /// current function, at least partially.
  ///
  /// Most commonly, this is an owned object with a retain count of +1.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::makeOwned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 199,
   FQN="(anonymous namespace)::RefVal::makeOwned", NM="_ZN12_GLOBAL__N_16RefVal9makeOwnedEN5clang4ento11objc_retain9RetEffect7ObjKindENS1_8QualTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_16RefVal9makeOwnedEN5clang4ento11objc_retain9RetEffect7ObjKindENS1_8QualTypeEj")
  //</editor-fold>
  public static RefVal makeOwned(RetEffect.ObjKind o, QualType t) {
    return makeOwned(o, t, 
           1);
  }
  public static RefVal makeOwned(RetEffect.ObjKind o, QualType t, 
           /*uint*/int Count/*= 1*/) {
    return new RefVal(Kind.Owned, o, Count, 0, new QualType(t), IvarAccessHistory.None);
  }

  
  /// Create a state for an object whose lifetime is not the responsibility of
  /// the current function.
  ///
  /// Most commonly, this is an unowned object with a retain count of +0.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::makeNotOwned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 208,
   FQN="(anonymous namespace)::RefVal::makeNotOwned", NM="_ZN12_GLOBAL__N_16RefVal12makeNotOwnedEN5clang4ento11objc_retain9RetEffect7ObjKindENS1_8QualTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_16RefVal12makeNotOwnedEN5clang4ento11objc_retain9RetEffect7ObjKindENS1_8QualTypeEj")
  //</editor-fold>
  public static RefVal makeNotOwned(RetEffect.ObjKind o, QualType t) {
    return makeNotOwned(o, t, 
              0);
  }
  public static RefVal makeNotOwned(RetEffect.ObjKind o, QualType t, 
              /*uint*/int Count/*= 0*/) {
    return new RefVal(Kind.NotOwned, o, Count, 0, new QualType(t), IvarAccessHistory.None);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::operator-">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 213,
   FQN="(anonymous namespace)::RefVal::operator-", NM="_ZNK12_GLOBAL__N_16RefValmiEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefValmiEj")
  //</editor-fold>
  public RefVal $sub(/*size_t*/int i) /*const*/ {
    return new RefVal(getKind(), getObjKind(), getCount() - i, 
        getAutoreleaseCount(), getType(), getIvarAccessHistory());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::operator+">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 218,
   FQN="(anonymous namespace)::RefVal::operator+", NM="_ZNK12_GLOBAL__N_16RefValplEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefValplEj")
  //</editor-fold>
  public RefVal $add(/*size_t*/int i) /*const*/ {
    return new RefVal(getKind(), getObjKind(), getCount() + i, 
        getAutoreleaseCount(), getType(), getIvarAccessHistory());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::operator^">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 223,
   FQN="(anonymous namespace)::RefVal::operator^", NM="_ZNK12_GLOBAL__N_16RefValeoENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefValeoENS0_4KindE")
  //</editor-fold>
  public RefVal $bitxor(Kind k) /*const*/ {
    return new RefVal(k, getObjKind(), getCount(), getAutoreleaseCount(), 
        getType(), getIvarAccessHistory());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::autorelease">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 228,
   FQN="(anonymous namespace)::RefVal::autorelease", NM="_ZNK12_GLOBAL__N_16RefVal11autoreleaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefVal11autoreleaseEv")
  //</editor-fold>
  public RefVal autorelease() /*const*/ {
    return new RefVal(getKind(), getObjKind(), getCount(), getAutoreleaseCount() + 1, 
        getType(), getIvarAccessHistory());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::withIvarAccess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 233,
   FQN="(anonymous namespace)::RefVal::withIvarAccess", NM="_ZNK12_GLOBAL__N_16RefVal14withIvarAccessEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefVal14withIvarAccessEv")
  //</editor-fold>
  public RefVal withIvarAccess() /*const*/ {
    assert (getIvarAccessHistory() == IvarAccessHistory.None);
    return new RefVal(getKind(), getObjKind(), getCount(), getAutoreleaseCount(), 
        getType(), IvarAccessHistory.AccessedDirectly);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::releaseViaIvar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 239,
   FQN="(anonymous namespace)::RefVal::releaseViaIvar", NM="_ZNK12_GLOBAL__N_16RefVal14releaseViaIvarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefVal14releaseViaIvarEv")
  //</editor-fold>
  public RefVal releaseViaIvar() /*const*/ {
    assert (getIvarAccessHistory() == IvarAccessHistory.AccessedDirectly);
    return new RefVal(getKind(), getObjKind(), getCount(), getAutoreleaseCount(), 
        getType(), IvarAccessHistory.ReleasedAfterDirectAccess);
  }

  
  // Comparison, profiling, and pretty-printing.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::hasSameState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 247,
   FQN="(anonymous namespace)::RefVal::hasSameState", NM="_ZNK12_GLOBAL__N_16RefVal12hasSameStateERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefVal12hasSameStateERKS0_")
  //</editor-fold>
  public boolean hasSameState(final /*const*/ RefVal /*&*/ X) /*const*/ {
    return getKind() == X.getKind() && Cnt == X.Cnt && ACnt == X.ACnt
       && getIvarAccessHistory() == X.getIvarAccessHistory();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 252,
   FQN="(anonymous namespace)::RefVal::operator==", NM="_ZNK12_GLOBAL__N_16RefValeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefValeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ RefVal /*&*/ X) /*const*/ {
    return $eq_QualType$C(T, X.T) && hasSameState(X) && getObjKind() == X.getObjKind();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 256,
   FQN="(anonymous namespace)::RefVal::Profile", NM="_ZNK12_GLOBAL__N_16RefVal7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefVal7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.Add(T);
    ID.AddInteger_uint($5bits_uint2uint(RawKind));
    ID.AddInteger_uint(Cnt);
    ID.AddInteger_uint(ACnt);
    ID.AddInteger_uint($2bits_uint2uint(RawObjectKind));
    ID.AddInteger_uint($2bits_uint2uint(RawIvarAccessHistory));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 268,
   FQN="(anonymous namespace)::RefVal::print", NM="_ZNK12_GLOBAL__N_16RefVal5printERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_16RefVal5printERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ Out) /*const*/ {
    if (!T.isNull()) {
      Out.$out(/*KEEP_STR*/"Tracked ").$out(T.getAsString()).$out_char($$SLASH);
    }
    switch (getKind()) {
     default:
      throw new llvm_unreachable("Invalid RefVal kind");
     case Owned:
      {
        Out.$out(/*KEEP_STR*/"Owned");
        /*uint*/int cnt = getCount();
        if ((cnt != 0)) {
          Out.$out(/*KEEP_STR*/" (+ ").$out_uint(cnt).$out(/*KEEP_STR*/$RPAREN);
        }
        break;
      }
     case NotOwned:
      {
        Out.$out(/*KEEP_STR*/"NotOwned");
        /*uint*/int cnt = getCount();
        if ((cnt != 0)) {
          Out.$out(/*KEEP_STR*/" (+ ").$out_uint(cnt).$out(/*KEEP_STR*/$RPAREN);
        }
        break;
      }
     case ReturnedOwned:
      {
        Out.$out(/*KEEP_STR*/"ReturnedOwned");
        /*uint*/int cnt = getCount();
        if ((cnt != 0)) {
          Out.$out(/*KEEP_STR*/" (+ ").$out_uint(cnt).$out(/*KEEP_STR*/$RPAREN);
        }
        break;
      }
     case ReturnedNotOwned:
      {
        Out.$out(/*KEEP_STR*/"ReturnedNotOwned");
        /*uint*/int cnt = getCount();
        if ((cnt != 0)) {
          Out.$out(/*KEEP_STR*/" (+ ").$out_uint(cnt).$out(/*KEEP_STR*/$RPAREN);
        }
        break;
      }
     case Released:
      Out.$out(/*KEEP_STR*/"Released");
      break;
     case ErrorDeallocGC:
      Out.$out(/*KEEP_STR*/"-dealloc (GC)");
      break;
     case ErrorDeallocNotOwned:
      Out.$out(/*KEEP_STR*/"-dealloc (not-owned)");
      break;
     case ErrorLeak:
      Out.$out(/*KEEP_STR*/"Leaked");
      break;
     case ErrorLeakReturned:
      Out.$out(/*KEEP_STR*/"Leaked (Bad naming)");
      break;
     case ErrorGCLeakReturned:
      Out.$out(/*KEEP_STR*/"Leaked (GC-ed at return)");
      break;
     case ErrorUseAfterRelease:
      Out.$out(/*KEEP_STR*/"Use-After-Release [ERROR]");
      break;
     case ErrorReleaseNotOwned:
      Out.$out(/*KEEP_STR*/"Release of Not-Owned [ERROR]");
      break;
     case ErrorOverAutorelease:
      Out.$out(/*KEEP_STR*/"Over-autoreleased");
      break;
     case ErrorReturnedNotOwned:
      Out.$out(/*KEEP_STR*/"Non-owned object returned instead of owned");
      break;
    }
    switch (getIvarAccessHistory()) {
     case None:
      break;
     case AccessedDirectly:
      Out.$out(/*KEEP_STR*/" [direct ivar access]");
      break;
     case ReleasedAfterDirectAccess:
      Out.$out(/*KEEP_STR*/" [released after direct ivar access]");
    }
    if ((ACnt != 0)) {
      Out.$out(/*KEEP_STR*/" [autorelease -").$out_uint(ACnt).$out_char($$RSQUARE);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::RefVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 76,
   FQN="(anonymous namespace)::RefVal::RefVal", NM="_ZN12_GLOBAL__N_16RefValC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_16RefValC1ERKS0_")
  //</editor-fold>
  public /*inline*/ RefVal(final /*const*/ RefVal /*&*/ $Prm0) {
    // : Cnt(.Cnt), ACnt(.ACnt), T(.T), RawKind(.RawKind), RawObjectKind(.RawObjectKind), RawIvarAccessHistory(.RawIvarAccessHistory) 
    //START JInit
    this.Cnt = $Prm0.Cnt;
    this.ACnt = $Prm0.ACnt;
    this.T = new QualType($Prm0.T);
    this.RawKind = $uint2uint_5bits($5bits_uint2uint($Prm0.RawKind));
    this.RawObjectKind = $uint2uint_2bits($2bits_uint2uint($Prm0.RawObjectKind));
    this.RawIvarAccessHistory = $uint2uint_2bits($2bits_uint2uint($Prm0.RawIvarAccessHistory));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::RefVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 76,
   FQN="(anonymous namespace)::RefVal::RefVal", NM="_ZN12_GLOBAL__N_16RefValC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_16RefValC1EOS0_")
  //</editor-fold>
  public /*inline*/ RefVal(JD$Move _dparam, final RefVal /*&&*/$Prm0) {
    // : Cnt(static_cast<RefVal &&>().Cnt), ACnt(static_cast<RefVal &&>().ACnt), T(static_cast<RefVal &&>().T), RawKind(static_cast<RefVal &&>().RawKind), RawObjectKind(static_cast<RefVal &&>().RawObjectKind), RawIvarAccessHistory(static_cast<RefVal &&>().RawIvarAccessHistory) 
    //START JInit
    this.Cnt = $Prm0.Cnt;
    this.ACnt = $Prm0.ACnt;
    this.T = new QualType(JD$Move.INSTANCE, $Prm0.T);
    this.RawKind = $uint2uint_5bits($5bits_uint2uint($Prm0.RawKind));
    this.RawObjectKind = $uint2uint_2bits($2bits_uint2uint($Prm0.RawObjectKind));
    this.RawIvarAccessHistory = $uint2uint_2bits($2bits_uint2uint($Prm0.RawIvarAccessHistory));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 76,
   FQN="(anonymous namespace)::RefVal::operator=", NM="_ZN12_GLOBAL__N_16RefValaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_16RefValaSERKS0_")
  //</editor-fold>
  public /*inline*/ RefVal /*&*/ $assign(final /*const*/ RefVal /*&*/ $Prm0) {
    this.Cnt = $Prm0.Cnt;
    this.ACnt = $Prm0.ACnt;
    this.T.$assign($Prm0.T);
    this.RawKind = $uint2uint_5bits($5bits_uint2uint($Prm0.RawKind));
    this.RawObjectKind = $uint2uint_2bits($2bits_uint2uint($Prm0.RawObjectKind));
    this.RawIvarAccessHistory = $uint2uint_2bits($2bits_uint2uint($Prm0.RawIvarAccessHistory));
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefVal::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 76,
   FQN="(anonymous namespace)::RefVal::operator=", NM="_ZN12_GLOBAL__N_16RefValaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_16RefValaSEOS0_")
  //</editor-fold>
  public /*inline*/ RefVal /*&*/ $assignMove(final RefVal /*&&*/$Prm0) {
    this.Cnt = $Prm0.Cnt;
    this.ACnt = $Prm0.ACnt;
    this.T.$assignMove($Prm0.T);
    this.RawKind = $uint2uint_5bits($5bits_uint2uint($Prm0.RawKind));
    this.RawObjectKind = $uint2uint_2bits($2bits_uint2uint($Prm0.RawObjectKind));
    this.RawIvarAccessHistory = $uint2uint_2bits($2bits_uint2uint($Prm0.RawIvarAccessHistory));
    return /*Deref*/this;
  }

  @Override public RefVal clone() { return new RefVal(this); }
  
  @Override public String toString() {
    return "" + "Cnt=" + Cnt // NOI18N
              + ", ACnt=" + ACnt // NOI18N
              + ", T=" + T // NOI18N
              + ", RawKind=" + $uchar2uint(RawKind) // NOI18N
              + ", RawObjectKind=" + $uchar2uint(RawObjectKind) // NOI18N
              + ", RawIvarAccessHistory=" + $uchar2uint(RawIvarAccessHistory); // NOI18N
  }
}
