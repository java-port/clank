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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import org.llvm.analysis.bfi_detail.*;
import org.llvm.analysis.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;


/// This pass computes, caches, and vends lazy value constraint information.
//<editor-fold defaultstate="collapsed" desc="llvm::LazyValueInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyValueInfo.h", line = 32,
 FQN="llvm::LazyValueInfo", NM="_ZN4llvm13LazyValueInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm13LazyValueInfoE")
//</editor-fold>
public class LazyValueInfo implements Destructors.ClassWithDestructor {
  /*friend  class LazyValueInfoWrapperPass*/
  private AssumptionCache /*P*/ AC/* = null*/;
  private  TargetLibraryInfo /*P*/ TLI/* = null*/;
  private DominatorTree /*P*/ DT/* = null*/;
  private Object/*void P*/ PImpl/* = null*/;
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyValueInfo::LazyValueInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyValueInfo.h", line = 38,
   FQN="llvm::LazyValueInfo::LazyValueInfo", NM="_ZN4llvm13LazyValueInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm13LazyValueInfoC1ERKS0_")
  //</editor-fold>
  protected/*private*/ LazyValueInfo(final /*const*/ LazyValueInfo /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::LazyValueInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyValueInfo.h", line = 39,
   FQN="llvm::LazyValueInfo::operator=", NM="_ZN4llvm13LazyValueInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm13LazyValueInfoaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ LazyValueInfo /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyValueInfo::~LazyValueInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1462,
   FQN="llvm::LazyValueInfo::~LazyValueInfo", NM="_ZN4llvm13LazyValueInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm13LazyValueInfoD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LazyValueInfo::LazyValueInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyValueInfo.h", line = 42,
   FQN="llvm::LazyValueInfo::LazyValueInfo", NM="_ZN4llvm13LazyValueInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm13LazyValueInfoC1Ev")
  //</editor-fold>
  public LazyValueInfo() {
    // : AC(null), TLI(null), DT(null), PImpl(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LazyValueInfo::LazyValueInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyValueInfo.h", line = 43,
   FQN="llvm::LazyValueInfo::LazyValueInfo", NM="_ZN4llvm13LazyValueInfoC1EPNS_15AssumptionCacheEPNS_17TargetLibraryInfoEPNS_13DominatorTreeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm13LazyValueInfoC1EPNS_15AssumptionCacheEPNS_17TargetLibraryInfoEPNS_13DominatorTreeE")
  //</editor-fold>
  public LazyValueInfo(AssumptionCache /*P*/ AC_, TargetLibraryInfo /*P*/ TLI_, 
      DominatorTree /*P*/ DT_) {
    // : AC(AC_), TLI(TLI_), DT(DT_), PImpl(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LazyValueInfo::LazyValueInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyValueInfo.h", line = 46,
   FQN="llvm::LazyValueInfo::LazyValueInfo", NM="_ZN4llvm13LazyValueInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm13LazyValueInfoC1EOS0_")
  //</editor-fold>
  public LazyValueInfo(JD$Move _dparam, final LazyValueInfo /*&&*/Arg) {
    // : AC(Arg.AC), TLI(Arg.TLI), DT(Arg.DT), PImpl(Arg.PImpl) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LazyValueInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyValueInfo.h", line = 50,
   FQN="llvm::LazyValueInfo::operator=", NM="_ZN4llvm13LazyValueInfoaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm13LazyValueInfoaSEOS0_")
  //</editor-fold>
  public LazyValueInfo /*&*/ $assignMove(final LazyValueInfo /*&&*/Arg) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This is used to return true/false/dunno results.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyValueInfo::Tristate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyValueInfo.h", line = 61,
   FQN="llvm::LazyValueInfo::Tristate", NM="_ZN4llvm13LazyValueInfo8TristateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm13LazyValueInfo8TristateE")
  //</editor-fold>
  public enum Tristate implements Native.NativeIntEnum {
    Unknown(-1),
    False(0),
    True(1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Tristate valueOf(int val) {
      Tristate out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Tristate[] VALUES;
      private static final Tristate[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Tristate kind : Tristate.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Tristate[min < 0 ? (1-min) : 0];
        VALUES = new Tristate[max >= 0 ? (1+max) : 0];
        for (Tristate kind : Tristate.values()) {
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
    private Tristate(int val) { this.value = (int)val;}
    @Override public final int getValue() { return value;}
    //</editor-fold>
  };
  
  // Public query interface.
  
  /// Determine whether the specified value comparison with a constant is known
  /// to be true or false on the specified CFG edge.
  /// Pred is a CmpInst predicate.
  
  /// Determine whether the specified value comparison with a constant is known to
  /// be true or false on the specified CFG edge. Pred is a CmpInst predicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyValueInfo::getPredicateOnEdge">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1602,
   FQN="llvm::LazyValueInfo::getPredicateOnEdge", NM="_ZN4llvm13LazyValueInfo18getPredicateOnEdgeEjPNS_5ValueEPNS_8ConstantEPNS_10BasicBlockES6_PNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm13LazyValueInfo18getPredicateOnEdgeEjPNS_5ValueEPNS_8ConstantEPNS_10BasicBlockES6_PNS_11InstructionE")
  //</editor-fold>
  public LazyValueInfo.Tristate getPredicateOnEdge(/*uint*/int Pred, Value /*P*/ V, Constant /*P*/ C, 
                    BasicBlock /*P*/ FromBB, BasicBlock /*P*/ ToBB) {
    return getPredicateOnEdge(Pred, V, C, 
                    FromBB, ToBB, 
                    (Instruction /*P*/ )null);
  }
  public LazyValueInfo.Tristate getPredicateOnEdge(/*uint*/int Pred, Value /*P*/ V, Constant /*P*/ C, 
                    BasicBlock /*P*/ FromBB, BasicBlock /*P*/ ToBB, 
                    Instruction /*P*/ CxtI/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Determine whether the specified value comparison with a constant is known
  /// to be true or false at the specified instruction
  /// (from an assume intrinsic). Pred is a CmpInst predicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyValueInfo::getPredicateAt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1613,
   FQN="llvm::LazyValueInfo::getPredicateAt", NM="_ZN4llvm13LazyValueInfo14getPredicateAtEjPNS_5ValueEPNS_8ConstantEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm13LazyValueInfo14getPredicateAtEjPNS_5ValueEPNS_8ConstantEPNS_11InstructionE")
  //</editor-fold>
  public LazyValueInfo.Tristate getPredicateAt(/*uint*/int Pred, Value /*P*/ V, Constant /*P*/ C, 
                Instruction /*P*/ CxtI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Determine whether the specified value is known to be a
  /// constant at the end of the specified block.  Return null if not.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyValueInfo::getConstant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1482,
   FQN="llvm::LazyValueInfo::getConstant", NM="_ZN4llvm13LazyValueInfo11getConstantEPNS_5ValueEPNS_10BasicBlockEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm13LazyValueInfo11getConstantEPNS_5ValueEPNS_10BasicBlockEPNS_11InstructionE")
  //</editor-fold>
  public Constant /*P*/ getConstant(Value /*P*/ V, BasicBlock /*P*/ BB) {
    return getConstant(V, BB, 
             (Instruction /*P*/ )null);
  }
  public Constant /*P*/ getConstant(Value /*P*/ V, BasicBlock /*P*/ BB, 
             Instruction /*P*/ CxtI/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the ConstantRange constraint that is known to hold for the
  /// specified value at the end of the specified block. This may only be called
  /// on integer-typed Values.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyValueInfo::getConstantRange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1498,
   FQN="llvm::LazyValueInfo::getConstantRange", NM="_ZN4llvm13LazyValueInfo16getConstantRangeEPNS_5ValueEPNS_10BasicBlockEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm13LazyValueInfo16getConstantRangeEPNS_5ValueEPNS_10BasicBlockEPNS_11InstructionE")
  //</editor-fold>
  public ConstantRange getConstantRange(Value /*P*/ V, BasicBlock /*P*/ BB) {
    return getConstantRange(V, BB, 
                  (Instruction /*P*/ )null);
  }
  public ConstantRange getConstantRange(Value /*P*/ V, BasicBlock /*P*/ BB, 
                  Instruction /*P*/ CxtI/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Determine whether the specified value is known to be a
  /// constant on the specified edge.  Return null if not.
  
  /// Determine whether the specified value is known to be a
  /// constant on the specified edge. Return null if not.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyValueInfo::getConstantOnEdge">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1515,
   FQN="llvm::LazyValueInfo::getConstantOnEdge", NM="_ZN4llvm13LazyValueInfo17getConstantOnEdgeEPNS_5ValueEPNS_10BasicBlockES4_PNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm13LazyValueInfo17getConstantOnEdgeEPNS_5ValueEPNS_10BasicBlockES4_PNS_11InstructionE")
  //</editor-fold>
  public Constant /*P*/ getConstantOnEdge(Value /*P*/ V, BasicBlock /*P*/ FromBB, 
                   BasicBlock /*P*/ ToBB) {
    return getConstantOnEdge(V, FromBB, 
                   ToBB, 
                   (Instruction /*P*/ )null);
  }
  public Constant /*P*/ getConstantOnEdge(Value /*P*/ V, BasicBlock /*P*/ FromBB, 
                   BasicBlock /*P*/ ToBB, 
                   Instruction /*P*/ CxtI/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Inform the analysis cache that we have threaded an edge from
  /// PredBB to OldSucc to be from PredBB to NewSucc instead.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyValueInfo::threadEdge">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1703,
   FQN="llvm::LazyValueInfo::threadEdge", NM="_ZN4llvm13LazyValueInfo10threadEdgeEPNS_10BasicBlockES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm13LazyValueInfo10threadEdgeEPNS_10BasicBlockES2_S2_")
  //</editor-fold>
  public void threadEdge(BasicBlock /*P*/ PredBB, BasicBlock /*P*/ OldSucc, 
            BasicBlock /*P*/ NewSucc) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Inform the analysis cache that we have erased a block.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyValueInfo::eraseBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1711,
   FQN="llvm::LazyValueInfo::eraseBlock", NM="_ZN4llvm13LazyValueInfo10eraseBlockEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm13LazyValueInfo10eraseBlockEPNS_10BasicBlockE")
  //</editor-fold>
  public void eraseBlock(BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // For old PM pass. Delete once LazyValueInfoWrapperPass is gone.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyValueInfo::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1464,
   FQN="llvm::LazyValueInfo::releaseMemory", NM="_ZN4llvm13LazyValueInfo13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm13LazyValueInfo13releaseMemoryEv")
  //</editor-fold>
  public void releaseMemory() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "AC=" + AC // NOI18N
              + ", TLI=" + TLI // NOI18N
              + ", DT=" + DT // NOI18N
              + ", PImpl=" + NativeTrace.getIdentityStr(PImpl); // NOI18N
  }
}
