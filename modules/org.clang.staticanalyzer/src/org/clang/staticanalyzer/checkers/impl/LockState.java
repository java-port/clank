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
import org.llvm.adt.*;
import org.clang.staticanalyzer.checkers.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LockState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 28,
 FQN="(anonymous namespace)::LockState", NM="_ZN12_GLOBAL__N_19LockStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZN12_GLOBAL__N_19LockStateE")
//</editor-fold>
public class/*struct*/ LockState implements Native.NativeComparable<LockState>, FoldingSetTrait.Profilable, NativeCloneable<LockState> {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LockState::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 29,
   FQN="(anonymous namespace)::LockState::Kind", NM="_ZN12_GLOBAL__N_19LockState4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZN12_GLOBAL__N_19LockState4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    Destroyed(0),
    Locked(Destroyed.getValue() + 1),
    Unlocked(Locked.getValue() + 1);

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
  public  Kind K;
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LockState::LockState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 32,
   FQN="(anonymous namespace)::LockState::LockState", NM="_ZN12_GLOBAL__N_19LockStateC1ENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZN12_GLOBAL__N_19LockStateC1ENS0_4KindE")
  //</editor-fold>
  private LockState(Kind K) {
    // : K(K) 
    //START JInit
    this.K = K;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LockState::getLocked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 35,
   FQN="(anonymous namespace)::LockState::getLocked", NM="_ZN12_GLOBAL__N_19LockState9getLockedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZN12_GLOBAL__N_19LockState9getLockedEv")
  //</editor-fold>
  public static LockState getLocked() {
    return new LockState(Kind.Locked);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LockState::getUnlocked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 36,
   FQN="(anonymous namespace)::LockState::getUnlocked", NM="_ZN12_GLOBAL__N_19LockState11getUnlockedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZN12_GLOBAL__N_19LockState11getUnlockedEv")
  //</editor-fold>
  public static LockState getUnlocked() {
    return new LockState(Kind.Unlocked);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LockState::getDestroyed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 37,
   FQN="(anonymous namespace)::LockState::getDestroyed", NM="_ZN12_GLOBAL__N_19LockState12getDestroyedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZN12_GLOBAL__N_19LockState12getDestroyedEv")
  //</editor-fold>
  public static LockState getDestroyed() {
    return new LockState(Kind.Destroyed);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LockState::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 39,
   FQN="(anonymous namespace)::LockState::operator==", NM="_ZNK12_GLOBAL__N_19LockStateeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZNK12_GLOBAL__N_19LockStateeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ LockState /*&*/ X) /*const*/ {
    return K == X.K;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LockState::isLocked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 43,
   FQN="(anonymous namespace)::LockState::isLocked", NM="_ZNK12_GLOBAL__N_19LockState8isLockedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZNK12_GLOBAL__N_19LockState8isLockedEv")
  //</editor-fold>
  public boolean isLocked() /*const*/ {
    return K == Kind.Locked;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LockState::isUnlocked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 44,
   FQN="(anonymous namespace)::LockState::isUnlocked", NM="_ZNK12_GLOBAL__N_19LockState10isUnlockedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZNK12_GLOBAL__N_19LockState10isUnlockedEv")
  //</editor-fold>
  public boolean isUnlocked() /*const*/ {
    return K == Kind.Unlocked;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LockState::isDestroyed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 45,
   FQN="(anonymous namespace)::LockState::isDestroyed", NM="_ZNK12_GLOBAL__N_19LockState11isDestroyedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZNK12_GLOBAL__N_19LockState11isDestroyedEv")
  //</editor-fold>
  public boolean isDestroyed() /*const*/ {
    return K == Kind.Destroyed;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LockState::Profile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 47,
   FQN="(anonymous namespace)::LockState::Profile", NM="_ZNK12_GLOBAL__N_19LockState7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZNK12_GLOBAL__N_19LockState7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddInteger_int(K.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LockState::LockState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 28,
   FQN="(anonymous namespace)::LockState::LockState", NM="_ZN12_GLOBAL__N_19LockStateC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZN12_GLOBAL__N_19LockStateC1ERKS0_")
  //</editor-fold>
  public /*inline*/ LockState(final /*const*/ LockState /*&*/ $Prm0) {
    // : K(.K) 
    //START JInit
    this.K = $Prm0.K;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LockState::LockState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 28,
   FQN="(anonymous namespace)::LockState::LockState", NM="_ZN12_GLOBAL__N_19LockStateC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZN12_GLOBAL__N_19LockStateC1EOS0_")
  //</editor-fold>
  public /*inline*/ LockState(JD$Move _dparam, final LockState /*&&*/$Prm0) {
    // : K(static_cast<LockState &&>().K) 
    //START JInit
    this.K = $Prm0.K;
    //END JInit
  }

  @Override public LockState clone() { return new LockState(this); }
  
  @Override public String toString() {
    return "" + "K=" + K; // NOI18N
  }
}
