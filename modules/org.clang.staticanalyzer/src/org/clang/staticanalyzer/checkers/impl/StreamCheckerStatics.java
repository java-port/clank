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
import org.clang.ast.*;


//<editor-fold defaultstate="collapsed" desc="static type StreamCheckerStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZN12_GLOBAL__N_111StreamStateE;_ZN12_GLOBAL__N_19StreamMapE; -static-type=StreamCheckerStatics")
//</editor-fold>
public final class StreamCheckerStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 29,
 FQN="(anonymous namespace)::StreamState", NM="_ZN12_GLOBAL__N_111StreamStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZN12_GLOBAL__N_111StreamStateE")
//</editor-fold>
public static class/*struct*/ StreamState implements Native.NativeComparable<StreamState>, FoldingSetTrait.Profilable, NativeCloneable<StreamState> {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 30,
   FQN="(anonymous namespace)::StreamState::Kind", NM="_ZN12_GLOBAL__N_111StreamState4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZN12_GLOBAL__N_111StreamState4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    Opened(0),
    Closed(Opened.getValue() + 1),
    OpenFailed(Closed.getValue() + 1),
    Escaped(OpenFailed.getValue() + 1);

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
  public /*const*/ Stmt /*P*/ S;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::StreamState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 33,
   FQN="(anonymous namespace)::StreamState::StreamState", NM="_ZN12_GLOBAL__N_111StreamStateC1ENS0_4KindEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZN12_GLOBAL__N_111StreamStateC1ENS0_4KindEPKN5clang4StmtE")
  //</editor-fold>
  public StreamState(Kind k, /*const*/ Stmt /*P*/ s) {
    // : K(k), S(s) 
    //START JInit
    this.K = k;
    this.S = s;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::isOpened">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 35,
   FQN="(anonymous namespace)::StreamState::isOpened", NM="_ZNK12_GLOBAL__N_111StreamState8isOpenedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_111StreamState8isOpenedEv")
  //</editor-fold>
  public boolean isOpened() /*const*/ {
    return K == Kind.Opened;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::isClosed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 36,
   FQN="(anonymous namespace)::StreamState::isClosed", NM="_ZNK12_GLOBAL__N_111StreamState8isClosedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_111StreamState8isClosedEv")
  //</editor-fold>
  public boolean isClosed() /*const*/ {
    return K == Kind.Closed;
  }

  //bool isOpenFailed() const { return K == OpenFailed; }
  //bool isEscaped() const { return K == Escaped; }
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 40,
   FQN="(anonymous namespace)::StreamState::operator==", NM="_ZNK12_GLOBAL__N_111StreamStateeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_111StreamStateeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ StreamState /*&*/ X) /*const*/ {
    return K == X.K && S == X.S;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::getOpened">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 44,
   FQN="(anonymous namespace)::StreamState::getOpened", NM="_ZN12_GLOBAL__N_111StreamState9getOpenedEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZN12_GLOBAL__N_111StreamState9getOpenedEPKN5clang4StmtE")
  //</editor-fold>
  public static StreamState getOpened(/*const*/ Stmt /*P*/ s) {
    return new StreamState(Kind.Opened, s);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::getClosed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 45,
   FQN="(anonymous namespace)::StreamState::getClosed", NM="_ZN12_GLOBAL__N_111StreamState9getClosedEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZN12_GLOBAL__N_111StreamState9getClosedEPKN5clang4StmtE")
  //</editor-fold>
  public static StreamState getClosed(/*const*/ Stmt /*P*/ s) {
    return new StreamState(Kind.Closed, s);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::getOpenFailed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 46,
   FQN="(anonymous namespace)::StreamState::getOpenFailed", NM="_ZN12_GLOBAL__N_111StreamState13getOpenFailedEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZN12_GLOBAL__N_111StreamState13getOpenFailedEPKN5clang4StmtE")
  //</editor-fold>
  public static StreamState getOpenFailed(/*const*/ Stmt /*P*/ s) {
    return new StreamState(Kind.OpenFailed, s);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::getEscaped">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 49,
   FQN="(anonymous namespace)::StreamState::getEscaped", NM="_ZN12_GLOBAL__N_111StreamState10getEscapedEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZN12_GLOBAL__N_111StreamState10getEscapedEPKN5clang4StmtE")
  //</editor-fold>
  public static StreamState getEscaped(/*const*/ Stmt /*P*/ s) {
    return new StreamState(Kind.Escaped, s);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 53,
   FQN="(anonymous namespace)::StreamState::Profile", NM="_ZNK12_GLOBAL__N_111StreamState7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZNK12_GLOBAL__N_111StreamState7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddInteger_int(K.getValue());
    ID.AddPointer(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::StreamState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 29,
   FQN="(anonymous namespace)::StreamState::StreamState", NM="_ZN12_GLOBAL__N_111StreamStateC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZN12_GLOBAL__N_111StreamStateC1ERKS0_")
  //</editor-fold>
  public /*inline*/ StreamState(final /*const*/ StreamState /*&*/ $Prm0) {
    // : K(.K), S(.S) 
    //START JInit
    this.K = $Prm0.K;
    this.S = $Prm0.S;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamState::StreamState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 29,
   FQN="(anonymous namespace)::StreamState::StreamState", NM="_ZN12_GLOBAL__N_111StreamStateC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZN12_GLOBAL__N_111StreamStateC1EOS0_")
  //</editor-fold>
  public /*inline*/ StreamState(JD$Move _dparam, final StreamState /*&&*/$Prm0) {
    // : K(static_cast<StreamState &&>().K), S(static_cast<StreamState &&>().S) 
    //START JInit
    this.K = $Prm0.K;
    this.S = $Prm0.S;
    //END JInit
  }

  @Override public StreamState clone() { return new StreamState(this); }
  
  @Override public String toString() {
    return "" + "K=" + K // NOI18N
              + ", S=" + S; // NOI18N
  }
}
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StreamMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 105,
 FQN="(anonymous namespace)::StreamMap", NM="_ZN12_GLOBAL__N_19StreamMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZN12_GLOBAL__N_19StreamMapE")
//</editor-fold>
public static class StreamMap {
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
} // END OF class StreamCheckerStatics
