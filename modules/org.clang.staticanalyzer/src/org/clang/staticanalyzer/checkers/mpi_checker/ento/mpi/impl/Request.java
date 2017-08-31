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

package org.clang.staticanalyzer.checkers.mpi_checker.ento.mpi.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::Request">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPITypes.h", line = 28,
 FQN="clang::ento::mpi::Request", NM="_ZN5clang4ento3mpi7RequestE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp -nm=_ZN5clang4ento3mpi7RequestE")
//</editor-fold>
public class Request implements FoldingSetTrait.Profilable, NativeCloneable<Request>, Native.NativeComparable<Request> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::Request::State">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPITypes.h", line = 30,
   FQN="clang::ento::mpi::Request::State", NM="_ZN5clang4ento3mpi7Request5StateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp -nm=_ZN5clang4ento3mpi7Request5StateE")
  //</editor-fold>
  public enum State/* : unsigned char*/ implements Native.NativeUCharEnum {
    Nonblocking(0),
    Wait(Nonblocking.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static State valueOf(/*uchar*/byte val) {
      State out = valueOf((int)val);
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]. Int not capable to keep values?";
      return out;
    }
    public static State valueOf(int val) {
      State out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final State[] VALUES;
      private static final State[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (State kind : State.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new State[min < 0 ? (1-min) : 0];
        VALUES = new State[max >= 0 ? (1+max) : 0];
        for (State kind : State.values()) {
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

    private final /*uchar*/byte value;
    private State(int val) { this.value = (/*uchar*/byte)val;}
    @Override public final /*uchar*/byte getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::Request::Request">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPITypes.h", line = 32,
   FQN="clang::ento::mpi::Request::Request", NM="_ZN5clang4ento3mpi7RequestC1ENS2_5StateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp -nm=_ZN5clang4ento3mpi7RequestC1ENS2_5StateE")
  //</editor-fold>
  public Request(State S) {
    // : CurrentState({S}) 
    //START JInit
    this.CurrentState = S;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::Request::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPITypes.h", line = 34,
   FQN="clang::ento::mpi::Request::Profile", NM="_ZNK5clang4ento3mpi7Request7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp -nm=_ZNK5clang4ento3mpi7Request7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public/*public*/ void Profile(final FoldingSetNodeID /*&*/ Id) /*const*/ {
    Id.AddInteger_int(CurrentState.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::Request::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPITypes.h", line = 38,
   FQN="clang::ento::mpi::Request::operator==", NM="_ZNK5clang4ento3mpi7RequesteqERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp -nm=_ZNK5clang4ento3mpi7RequesteqERKS2_")
  //</editor-fold>
  public boolean $eq(final /*const*/ Request /*&*/ ToCompare) /*const*/ {
    return CurrentState == ToCompare.CurrentState;
  }

  
  public /*const*/ State CurrentState;
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::Request::Request">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPITypes.h", line = 28,
   FQN="clang::ento::mpi::Request::Request", NM="_ZN5clang4ento3mpi7RequestC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp -nm=_ZN5clang4ento3mpi7RequestC1ERKS2_")
  //</editor-fold>
  public /*inline*/ Request(final /*const*/ Request /*&*/ $Prm0) {
    // : CurrentState(.CurrentState) 
    //START JInit
    this.CurrentState = $Prm0.CurrentState;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::Request::Request">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPITypes.h", line = 28,
   FQN="clang::ento::mpi::Request::Request", NM="_ZN5clang4ento3mpi7RequestC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp -nm=_ZN5clang4ento3mpi7RequestC1EOS2_")
  //</editor-fold>
  public /*inline*/ Request(JD$Move _dparam, final Request /*&&*/$Prm0) {
    // : CurrentState(static_cast<Request &&>().CurrentState) 
    //START JInit
    this.CurrentState = $Prm0.CurrentState;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public Request clone() { return new Request(this); }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "CurrentState=" + CurrentState; // NOI18N
  }
}
