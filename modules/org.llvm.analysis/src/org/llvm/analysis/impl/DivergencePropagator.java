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

package org.llvm.analysis.impl;

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
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivergencePropagator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp", line = 83,
 FQN="(anonymous namespace)::DivergencePropagator", NM="_ZN12_GLOBAL__N_120DivergencePropagatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZN12_GLOBAL__N_120DivergencePropagatorE")
//</editor-fold>
public class DivergencePropagator implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivergencePropagator::DivergencePropagator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp", line = 85,
   FQN="(anonymous namespace)::DivergencePropagator::DivergencePropagator", NM="_ZN12_GLOBAL__N_120DivergencePropagatorC1ERN4llvm8FunctionERNS1_19TargetTransformInfoERNS1_13DominatorTreeERNS1_17PostDominatorTreeERNS1_8DenseSetIPKNS1_5ValueENS1_12DenseMapInfoISD_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZN12_GLOBAL__N_120DivergencePropagatorC1ERN4llvm8FunctionERNS1_19TargetTransformInfoERNS1_13DominatorTreeERNS1_17PostDominatorTreeERNS1_8DenseSetIPKNS1_5ValueENS1_12DenseMapInfoISD_EEEE")
  //</editor-fold>
  public DivergencePropagator(final Function /*&*/ F, final TargetTransformInfo /*&*/ TTI, final DominatorTree /*&*/ DT, 
      final PostDominatorTree /*&*/ PDT, final DenseSet</*const*/ Value /*P*/ > /*&*/ DV) {
    // : F(F), TTI(TTI), DT(DT), PDT(PDT), Worklist(), DV(DV) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivergencePropagator::populateWithSourcesOfDivergence">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp", line = 113,
   FQN="(anonymous namespace)::DivergencePropagator::populateWithSourcesOfDivergence", NM="_ZN12_GLOBAL__N_120DivergencePropagator31populateWithSourcesOfDivergenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZN12_GLOBAL__N_120DivergencePropagator31populateWithSourcesOfDivergenceEv")
  //</editor-fold>
  public void populateWithSourcesOfDivergence() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivergencePropagator::propagate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp", line = 249,
   FQN="(anonymous namespace)::DivergencePropagator::propagate", NM="_ZN12_GLOBAL__N_120DivergencePropagator9propagateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZN12_GLOBAL__N_120DivergencePropagator9propagateEv")
  //</editor-fold>
  public void propagate() {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  // A helper function that explores data dependents of V.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivergencePropagator::exploreDataDependency">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp", line = 240,
   FQN="(anonymous namespace)::DivergencePropagator::exploreDataDependency", NM="_ZN12_GLOBAL__N_120DivergencePropagator21exploreDataDependencyEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZN12_GLOBAL__N_120DivergencePropagator21exploreDataDependencyEPN4llvm5ValueE")
  //</editor-fold>
  private void exploreDataDependency(Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // A helper function that explores sync dependents of TI.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivergencePropagator::exploreSyncDependency">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp", line = 130,
   FQN="(anonymous namespace)::DivergencePropagator::exploreSyncDependency", NM="_ZN12_GLOBAL__N_120DivergencePropagator21exploreSyncDependencyEPN4llvm14TerminatorInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZN12_GLOBAL__N_120DivergencePropagator21exploreSyncDependencyEPN4llvm14TerminatorInstE")
  //</editor-fold>
  private void exploreSyncDependency(TerminatorInst /*P*/ TI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Computes the influence region from Start to End. This region includes all
  // basic blocks on any simple path from Start to End.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivergencePropagator::computeInfluenceRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp", line = 222,
   FQN="(anonymous namespace)::DivergencePropagator::computeInfluenceRegion", NM="_ZN12_GLOBAL__N_120DivergencePropagator22computeInfluenceRegionEPN4llvm10BasicBlockES3_RNS1_8DenseSetIS3_NS1_12DenseMapInfoIS3_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZN12_GLOBAL__N_120DivergencePropagator22computeInfluenceRegionEPN4llvm10BasicBlockES3_RNS1_8DenseSetIS3_NS1_12DenseMapInfoIS3_EEEE")
  //</editor-fold>
  private void computeInfluenceRegion(BasicBlock /*P*/ Start, BasicBlock /*P*/ End, 
                        final DenseSet<BasicBlock /*P*/ > /*&*/ InfluenceRegion) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Finds all users of I that are outside the influence region, and add these
  // users to Worklist.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivergencePropagator::findUsersOutsideInfluenceRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp", line = 199,
   FQN="(anonymous namespace)::DivergencePropagator::findUsersOutsideInfluenceRegion", NM="_ZN12_GLOBAL__N_120DivergencePropagator31findUsersOutsideInfluenceRegionERN4llvm11InstructionERKNS1_8DenseSetIPNS1_10BasicBlockENS1_12DenseMapInfoIS6_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZN12_GLOBAL__N_120DivergencePropagator31findUsersOutsideInfluenceRegionERN4llvm11InstructionERKNS1_8DenseSetIPNS1_10BasicBlockENS1_12DenseMapInfoIS6_EEEE")
  //</editor-fold>
  private void findUsersOutsideInfluenceRegion(final Instruction /*&*/ I, final /*const*/DenseSet<BasicBlock /*P*/ > /*&*/ InfluenceRegion) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private final Function /*&*/ F;
  private final TargetTransformInfo /*&*/ TTI;
  private final DominatorTree /*&*/ DT;
  private final PostDominatorTree /*&*/ PDT;
  private std.vector<Value /*P*/ > Worklist; // Stack for DFS.
  private final DenseSet</*const*/ Value /*P*/ > /*&*/ DV; // Stores all divergent values.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DivergencePropagator::~DivergencePropagator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp", line = 83,
   FQN="(anonymous namespace)::DivergencePropagator::~DivergencePropagator", NM="_ZN12_GLOBAL__N_120DivergencePropagatorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZN12_GLOBAL__N_120DivergencePropagatorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "F=" + F // NOI18N
              + ", TTI=" + TTI // NOI18N
              + ", DT=" + DT // NOI18N
              + ", PDT=" + PDT // NOI18N
              + ", Worklist=" + Worklist // NOI18N
              + ", DV=" + DV; // NOI18N
  }
}
