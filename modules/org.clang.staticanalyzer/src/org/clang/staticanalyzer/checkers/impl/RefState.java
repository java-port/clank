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
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.checkers.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 51,
 FQN="(anonymous namespace)::RefState", NM="_ZN12_GLOBAL__N_18RefStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_18RefStateE")
//</editor-fold>
public class RefState implements Native.NativeComparable<RefState>, FoldingSetTrait.Profilable, NativeCloneable<RefState> {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 52,
   FQN="(anonymous namespace)::RefState::Kind", NM="_ZN12_GLOBAL__N_18RefState4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_18RefState4KindE")
  //</editor-fold>
  private enum Kind implements Native.ComparableLower {
    // Reference to allocated memory.
    Allocated(0),
    // Reference to zero-allocated memory.
    AllocatedOfSizeZero(Allocated.getValue() + 1),
    // Reference to released/freed memory.
    Released(AllocatedOfSizeZero.getValue() + 1),
    // The responsibility for freeing resources has transferred from
    // this reference. A relinquished symbol should not be freed.
    Relinquished(Released.getValue() + 1),
    // We are no longer guaranteed to have observed all manipulations
    // of this pointer/memory. For example, it could have been
    // passed as a parameter to an opaque function.
    Escaped(Relinquished.getValue() + 1);

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
  
  private /*const*/ Stmt /*P*/ S;
  private /*JBYTE unsigned int*/ byte K /*: 3*/; // Kind enum, but stored as a bitfield.
  private /*uint*/int Family /*: 29*/; // Rest of 32-bit word, currently just an allocation
  // family.
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::RefState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 72,
   FQN="(anonymous namespace)::RefState::RefState", NM="_ZN12_GLOBAL__N_18RefStateC1ENS0_4KindEPKN5clang4StmtEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_18RefStateC1ENS0_4KindEPKN5clang4StmtEj")
  //</editor-fold>
  private RefState(Kind k, /*const*/ Stmt /*P*/ s, /*uint*/int family) {
    // : S(s), K(k), Family(family) 
    //START JInit
    this.S = s;
    this.K = $uint2uint_3bits(k.getValue());
    this.Family = family;
    //END JInit
    assert (family != AllocationFamily.AF_None.getValue());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::isAllocated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 77,
   FQN="(anonymous namespace)::RefState::isAllocated", NM="_ZNK12_GLOBAL__N_18RefState11isAllocatedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_18RefState11isAllocatedEv")
  //</editor-fold>
  public boolean isAllocated() /*const*/ {
    return $3bits_uint2uint(K) == Kind.Allocated.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::isAllocatedOfSizeZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 78,
   FQN="(anonymous namespace)::RefState::isAllocatedOfSizeZero", NM="_ZNK12_GLOBAL__N_18RefState21isAllocatedOfSizeZeroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_18RefState21isAllocatedOfSizeZeroEv")
  //</editor-fold>
  public boolean isAllocatedOfSizeZero() /*const*/ {
    return $3bits_uint2uint(K) == Kind.AllocatedOfSizeZero.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::isReleased">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 79,
   FQN="(anonymous namespace)::RefState::isReleased", NM="_ZNK12_GLOBAL__N_18RefState10isReleasedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_18RefState10isReleasedEv")
  //</editor-fold>
  public boolean isReleased() /*const*/ {
    return $3bits_uint2uint(K) == Kind.Released.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::isRelinquished">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 80,
   FQN="(anonymous namespace)::RefState::isRelinquished", NM="_ZNK12_GLOBAL__N_18RefState14isRelinquishedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_18RefState14isRelinquishedEv")
  //</editor-fold>
  public boolean isRelinquished() /*const*/ {
    return $3bits_uint2uint(K) == Kind.Relinquished.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::isEscaped">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 81,
   FQN="(anonymous namespace)::RefState::isEscaped", NM="_ZNK12_GLOBAL__N_18RefState9isEscapedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_18RefState9isEscapedEv")
  //</editor-fold>
  public boolean isEscaped() /*const*/ {
    return $3bits_uint2uint(K) == Kind.Escaped.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::getAllocationFamily">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 82,
   FQN="(anonymous namespace)::RefState::getAllocationFamily", NM="_ZNK12_GLOBAL__N_18RefState19getAllocationFamilyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_18RefState19getAllocationFamilyEv")
  //</editor-fold>
  public AllocationFamily getAllocationFamily() /*const*/ {
    return AllocationFamily.valueOf(Family);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::getStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 85,
   FQN="(anonymous namespace)::RefState::getStmt", NM="_ZNK12_GLOBAL__N_18RefState7getStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_18RefState7getStmtEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getStmt() /*const*/ {
    return S;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 87,
   FQN="(anonymous namespace)::RefState::operator==", NM="_ZNK12_GLOBAL__N_18RefStateeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_18RefStateeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ RefState /*&*/ X) /*const*/ {
    return $3bits_uint2uint(K) == $3bits_uint2uint(X.K) && S == X.S && Family == X.Family;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::getAllocated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 91,
   FQN="(anonymous namespace)::RefState::getAllocated", NM="_ZN12_GLOBAL__N_18RefState12getAllocatedEjPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_18RefState12getAllocatedEjPKN5clang4StmtE")
  //</editor-fold>
  public static RefState getAllocated(/*uint*/int family, /*const*/ Stmt /*P*/ s) {
    return new RefState(Kind.Allocated, s, family);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::getAllocatedOfSizeZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 94,
   FQN="(anonymous namespace)::RefState::getAllocatedOfSizeZero", NM="_ZN12_GLOBAL__N_18RefState22getAllocatedOfSizeZeroEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_18RefState22getAllocatedOfSizeZeroEPKS0_")
  //</editor-fold>
  public static RefState getAllocatedOfSizeZero(/*const*/ RefState /*P*/ RS) {
    return new RefState(Kind.AllocatedOfSizeZero, RS.getStmt(), 
        RS.getAllocationFamily().getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::getReleased">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 98,
   FQN="(anonymous namespace)::RefState::getReleased", NM="_ZN12_GLOBAL__N_18RefState11getReleasedEjPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_18RefState11getReleasedEjPKN5clang4StmtE")
  //</editor-fold>
  public static RefState getReleased(/*uint*/int family, /*const*/ Stmt /*P*/ s) {
    return new RefState(Kind.Released, s, family);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::getRelinquished">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 101,
   FQN="(anonymous namespace)::RefState::getRelinquished", NM="_ZN12_GLOBAL__N_18RefState15getRelinquishedEjPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_18RefState15getRelinquishedEjPKN5clang4StmtE")
  //</editor-fold>
  public static RefState getRelinquished(/*uint*/int family, /*const*/ Stmt /*P*/ s) {
    return new RefState(Kind.Relinquished, s, family);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::getEscaped">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 104,
   FQN="(anonymous namespace)::RefState::getEscaped", NM="_ZN12_GLOBAL__N_18RefState10getEscapedEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_18RefState10getEscapedEPKS0_")
  //</editor-fold>
  public static RefState getEscaped(/*const*/ RefState /*P*/ RS) {
    return new RefState(Kind.Escaped, RS.getStmt(), RS.getAllocationFamily().getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 108,
   FQN="(anonymous namespace)::RefState::Profile", NM="_ZNK12_GLOBAL__N_18RefState7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_18RefState7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddInteger_uint($3bits_uint2uint(K));
    ID.AddPointer(S);
    ID.AddInteger_uint(Family);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 114,
   FQN="(anonymous namespace)::RefState::dump", NM="_ZNK12_GLOBAL__N_18RefState4dumpERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_18RefState4dumpERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ OS) /*const*/ {
    switch (/*static_cast*/Kind.valueOf($3bits_uint2uint(K))) {
     case Allocated:
      OS.$out(/*KEEP_STR*/"Allocated");
      break;
     case AllocatedOfSizeZero:
      OS.$out(/*KEEP_STR*/"AllocatedOfSizeZero");
      break;
     case Released:
      OS.$out(/*KEEP_STR*/"Released");
      break;
     case Relinquished:
      OS.$out(/*KEEP_STR*/"Relinquished");
      break;
     case Escaped:
      OS.$out(/*KEEP_STR*/"Escaped");
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 125,
   FQN="(anonymous namespace)::RefState::dump", NM="_ZNK12_GLOBAL__N_18RefState4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_18RefState4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dump(llvm.errs());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::RefState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 51,
   FQN="(anonymous namespace)::RefState::RefState", NM="_ZN12_GLOBAL__N_18RefStateC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_18RefStateC1ERKS0_")
  //</editor-fold>
  public /*inline*/ RefState(final /*const*/ RefState /*&*/ $Prm0) {
    // : S(.S), K(.K), Family(.Family) 
    //START JInit
    this.S = $Prm0.S;
    this.K = $uint2uint_3bits($3bits_uint2uint($Prm0.K));
    this.Family = $Prm0.Family;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RefState::RefState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 51,
   FQN="(anonymous namespace)::RefState::RefState", NM="_ZN12_GLOBAL__N_18RefStateC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_18RefStateC1EOS0_")
  //</editor-fold>
  public /*inline*/ RefState(JD$Move _dparam, final RefState /*&&*/$Prm0) {
    // : S(static_cast<RefState &&>().S), K(static_cast<RefState &&>().K), Family(static_cast<RefState &&>().Family) 
    //START JInit
    this.S = $Prm0.S;
    this.K = $uint2uint_3bits($3bits_uint2uint($Prm0.K));
    this.Family = $Prm0.Family;
    //END JInit
  }

  @Override public RefState clone() { return new RefState(this); }
  
  @Override public String toString() {
    if (true) {
      return llvm.DumpJavaString(this, RefState::dump);
    }        
    return "" + "S=" + S // NOI18N
              + ", K=" + $uchar2uint(K) // NOI18N
              + ", Family=" + Family; // NOI18N
  }
}
