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

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalizedState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 39,
 FQN="(anonymous namespace)::LocalizedState", NM="_ZN12_GLOBAL__N_114LocalizedStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_114LocalizedStateE")
//</editor-fold>
public class/*struct*/ LocalizedState implements Native.NativeComparable<LocalizedState>, FoldingSetTrait.Profilable, NativeCloneable<LocalizedState> {
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalizedState::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 41,
   FQN="(anonymous namespace)::LocalizedState::Kind", NM="_ZN12_GLOBAL__N_114LocalizedState4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_114LocalizedState4KindE")
  //</editor-fold>
  private enum Kind implements Native.ComparableLower {
    NonLocalized(0),
    Localized(NonLocalized.getValue() + 1);

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
  private  Kind K;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalizedState::LocalizedState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 42,
   FQN="(anonymous namespace)::LocalizedState::LocalizedState", NM="_ZN12_GLOBAL__N_114LocalizedStateC1ENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_114LocalizedStateC1ENS0_4KindE")
  //</editor-fold>
  private LocalizedState(Kind InK) {
    // : K(InK) 
    //START JInit
    this.K = InK;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalizedState::isLocalized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 45,
   FQN="(anonymous namespace)::LocalizedState::isLocalized", NM="_ZNK12_GLOBAL__N_114LocalizedState11isLocalizedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_114LocalizedState11isLocalizedEv")
  //</editor-fold>
  public boolean isLocalized() /*const*/ {
    return K == Kind.Localized;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalizedState::isNonLocalized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 46,
   FQN="(anonymous namespace)::LocalizedState::isNonLocalized", NM="_ZNK12_GLOBAL__N_114LocalizedState14isNonLocalizedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_114LocalizedState14isNonLocalizedEv")
  //</editor-fold>
  public boolean isNonLocalized() /*const*/ {
    return K == Kind.NonLocalized;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalizedState::getLocalized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 48,
   FQN="(anonymous namespace)::LocalizedState::getLocalized", NM="_ZN12_GLOBAL__N_114LocalizedState12getLocalizedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_114LocalizedState12getLocalizedEv")
  //</editor-fold>
  public static LocalizedState getLocalized() {
    return new LocalizedState(Kind.Localized);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalizedState::getNonLocalized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 49,
   FQN="(anonymous namespace)::LocalizedState::getNonLocalized", NM="_ZN12_GLOBAL__N_114LocalizedState15getNonLocalizedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_114LocalizedState15getNonLocalizedEv")
  //</editor-fold>
  public static LocalizedState getNonLocalized() {
    return new LocalizedState(Kind.NonLocalized);
  }

  
  // Overload the == operator
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalizedState::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 54,
   FQN="(anonymous namespace)::LocalizedState::operator==", NM="_ZNK12_GLOBAL__N_114LocalizedStateeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_114LocalizedStateeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ LocalizedState /*&*/ X) /*const*/ {
    return K == X.K;
  }

  
  // LLVMs equivalent of a hash function
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalizedState::Profile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 57,
   FQN="(anonymous namespace)::LocalizedState::Profile", NM="_ZNK12_GLOBAL__N_114LocalizedState7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_114LocalizedState7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddInteger_int(K.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalizedState::LocalizedState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 39,
   FQN="(anonymous namespace)::LocalizedState::LocalizedState", NM="_ZN12_GLOBAL__N_114LocalizedStateC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_114LocalizedStateC1ERKS0_")
  //</editor-fold>
  public /*inline*/ LocalizedState(final /*const*/ LocalizedState /*&*/ $Prm0) {
    // : K(.K) 
    //START JInit
    this.K = $Prm0.K;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalizedState::LocalizedState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 39,
   FQN="(anonymous namespace)::LocalizedState::LocalizedState", NM="_ZN12_GLOBAL__N_114LocalizedStateC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_114LocalizedStateC1EOS0_")
  //</editor-fold>
  public /*inline*/ LocalizedState(JD$Move _dparam, final LocalizedState /*&&*/$Prm0) {
    // : K(static_cast<LocalizedState &&>().K) 
    //START JInit
    this.K = $Prm0.K;
    //END JInit
  }

  @Override public LocalizedState clone() { return new LocalizedState(this); }
  
  @Override public String toString() {
    return "" + "K=" + K; // NOI18N
  }
}
