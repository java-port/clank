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

/// This is the cache kept by LazyValueInfo which
/// maintains information about queries across the clients' queries.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 384,
 FQN="(anonymous namespace)::LazyValueInfoCache", NM="_ZN12_GLOBAL__N_118LazyValueInfoCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCacheE")
//</editor-fold>
public class LazyValueInfoCache implements Destructors.ClassWithDestructor {
  /// This is all of the cached block information for exactly one Value*.
  /// The entries are sorted by the BasicBlock* of the
  /// entries, allowing us to do a lookup with a binary search.
  /// Over-defined lattice values are recorded in OverDefinedCache to reduce
  /// memory overhead.
  // JAVA: typedef SmallDenseMap<AssertingVH<BasicBlock>, LVILatticeVal, 4> ValueCacheEntryTy
//  public final class ValueCacheEntryTy extends SmallDenseMap<AssertingVH<BasicBlock>, LVILatticeVal>{ };
  
  /// This is all of the cached information for all values,
  /// mapped from Value* to key information.
  private std.mapTypeType<LVIValueHandle, SmallDenseMap<AssertingVH<BasicBlock>, LVILatticeVal>> ValueCache;
  
  /// This tracks, on a per-block basis, the set of values that are
  /// over-defined at the end of that block.
  // JAVA: typedef DenseMap<AssertingVH<BasicBlock>, SmallPtrSet<Value *, 4> > OverDefinedCacheTy
//  public final class OverDefinedCacheTy extends DenseMap<AssertingVH<BasicBlock>, SmallPtrSet<Value /*P*/ >>{ };
  private DenseMap<AssertingVH<BasicBlock>, SmallPtrSet<Value /*P*/ >> OverDefinedCache;
  
  /// Keep track of all blocks that we have ever seen, so we
  /// don't spend time removing unused blocks from our caches.
  private DenseSet<AssertingVH<BasicBlock>> SeenBlocks;
  
  /// This stack holds the state of the value solver during a query.
  /// It basically emulates the callstack of the naive
  /// recursive value lookup process.
  private std.stack<std.pair<BasicBlock /*P*/ , Value /*P*/ > > BlockValueStack;
  
  /// Keeps track of which block-value pairs are in BlockValueStack.
  private DenseSet<std.pair<BasicBlock /*P*/ , Value /*P*/ >> BlockValueSet;
  
  /// Push BV onto BlockValueStack unless it's already in there.
  /// Returns true on success.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::pushBlockValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 417,
   FQN="(anonymous namespace)::LazyValueInfoCache::pushBlockValue", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache14pushBlockValueERKSt4pairIPN4llvm10BasicBlockEPNS2_5ValueEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache14pushBlockValueERKSt4pairIPN4llvm10BasicBlockEPNS2_5ValueEE")
  //</editor-fold>
  private boolean pushBlockValue(final /*const*/ std.pair<BasicBlock /*P*/ , Value /*P*/ > /*&*/ BV) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private AssumptionCache /*P*/ AC; ///< A pointer to the cache of @llvm.assume calls.
  private final /*const*/ DataLayout /*&*/ DL; ///< A mandatory DataLayout
  private DominatorTree /*P*/ DT; ///< An optional DT pointer.
  
  /*friend  struct LVIValueHandle*/
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::insertResult">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 433,
   FQN="(anonymous namespace)::LazyValueInfoCache::insertResult", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache12insertResultEPN4llvm5ValueEPNS1_10BasicBlockERKNS_13LVILatticeValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache12insertResultEPN4llvm5ValueEPNS1_10BasicBlockERKNS_13LVILatticeValE")
  //</editor-fold>
  private void insertResult(Value /*P*/ Val, BasicBlock /*P*/ BB, final /*const*/ LVILatticeVal /*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::getBlockValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 598,
   FQN="(anonymous namespace)::LazyValueInfoCache::getBlockValue", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache13getBlockValueEPN4llvm5ValueEPNS1_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache13getBlockValueEPN4llvm5ValueEPNS1_10BasicBlockE")
  //</editor-fold>
  private LVILatticeVal getBlockValue(Value /*P*/ Val, BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Compute the value of Val on the edge BBFrom -> BBTo or the value at
  /// the basic block if the edge does not constrain Val.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::getEdgeValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1270,
   FQN="(anonymous namespace)::LazyValueInfoCache::getEdgeValue", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache12getEdgeValueEPN4llvm5ValueEPNS1_10BasicBlockES5_RNS_13LVILatticeValEPNS1_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache12getEdgeValueEPN4llvm5ValueEPNS1_10BasicBlockES5_RNS_13LVILatticeValEPNS1_11InstructionE")
  //</editor-fold>
  private boolean getEdgeValue(Value /*P*/ Val, BasicBlock /*P*/ BBFrom, 
              BasicBlock /*P*/ BBTo, final LVILatticeVal /*&*/ Result) {
    return getEdgeValue(Val, BBFrom, 
              BBTo, Result, 
              (Instruction /*P*/ )null);
  }
  private boolean getEdgeValue(Value /*P*/ Val, BasicBlock /*P*/ BBFrom, 
              BasicBlock /*P*/ BBTo, final LVILatticeVal /*&*/ Result, 
              Instruction /*P*/ CxtI/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::hasBlockValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 590,
   FQN="(anonymous namespace)::LazyValueInfoCache::hasBlockValue", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache13hasBlockValueEPN4llvm5ValueEPNS1_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache13hasBlockValueEPN4llvm5ValueEPNS1_10BasicBlockE")
  //</editor-fold>
  private boolean hasBlockValue(Value /*P*/ Val, BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // These methods process one work item and may add more. A false value
  // returned means that the work item was not completely processed and must
  // be revisited after going through the new items.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::solveBlockValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 623,
   FQN="(anonymous namespace)::LazyValueInfoCache::solveBlockValue", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache15solveBlockValueEPN4llvm5ValueEPNS1_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache15solveBlockValueEPN4llvm5ValueEPNS1_10BasicBlockE")
  //</editor-fold>
  private boolean solveBlockValue(Value /*P*/ Val, BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::solveBlockValueNonLocal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 751,
   FQN="(anonymous namespace)::LazyValueInfoCache::solveBlockValueNonLocal", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache23solveBlockValueNonLocalERNS_13LVILatticeValEPN4llvm5ValueEPNS3_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache23solveBlockValueNonLocalERNS_13LVILatticeValEPN4llvm5ValueEPNS3_10BasicBlockE")
  //</editor-fold>
  private boolean solveBlockValueNonLocal(final LVILatticeVal /*&*/ BBLV, 
                         Value /*P*/ Val, BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::solveBlockValuePHINode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 809,
   FQN="(anonymous namespace)::LazyValueInfoCache::solveBlockValuePHINode", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache22solveBlockValuePHINodeERNS_13LVILatticeValEPN4llvm7PHINodeEPNS3_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache22solveBlockValuePHINodeERNS_13LVILatticeValEPN4llvm7PHINodeEPNS3_10BasicBlockE")
  //</editor-fold>
  private boolean solveBlockValuePHINode(final LVILatticeVal /*&*/ BBLV, 
                        PHINode /*P*/ PN, BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::solveBlockValueSelect">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 877,
   FQN="(anonymous namespace)::LazyValueInfoCache::solveBlockValueSelect", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache21solveBlockValueSelectERNS_13LVILatticeValEPN4llvm10SelectInstEPNS3_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache21solveBlockValueSelectERNS_13LVILatticeValEPN4llvm10SelectInstEPNS3_10BasicBlockE")
  //</editor-fold>
  private boolean solveBlockValueSelect(final LVILatticeVal /*&*/ BBLV, 
                       SelectInst /*P*/ SI, BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::solveBlockValueBinaryOp">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1079,
   FQN="(anonymous namespace)::LazyValueInfoCache::solveBlockValueBinaryOp", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache23solveBlockValueBinaryOpERNS_13LVILatticeValEPN4llvm11InstructionEPNS3_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache23solveBlockValueBinaryOpERNS_13LVILatticeValEPN4llvm11InstructionEPNS3_10BasicBlockE")
  //</editor-fold>
  private boolean solveBlockValueBinaryOp(final LVILatticeVal /*&*/ BBLV, 
                         Instruction /*P*/ BBI, 
                         BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::solveBlockValueCast">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1004,
   FQN="(anonymous namespace)::LazyValueInfoCache::solveBlockValueCast", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache19solveBlockValueCastERNS_13LVILatticeValEPN4llvm11InstructionEPNS3_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache19solveBlockValueCastERNS_13LVILatticeValEPN4llvm11InstructionEPNS3_10BasicBlockE")
  //</editor-fold>
  private boolean solveBlockValueCast(final LVILatticeVal /*&*/ BBLV, 
                     Instruction /*P*/ BBI, 
                     BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // If we can determine a constraint on the value given conditions assumed by
  // the program, intersect those constraints with BBLV
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::intersectAssumeBlockValueConstantRange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 854,
   FQN="(anonymous namespace)::LazyValueInfoCache::intersectAssumeBlockValueConstantRange", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache38intersectAssumeBlockValueConstantRangeEPN4llvm5ValueERNS_13LVILatticeValEPNS1_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache38intersectAssumeBlockValueConstantRangeEPN4llvm5ValueERNS_13LVILatticeValEPNS1_11InstructionE")
  //</editor-fold>
  private void intersectAssumeBlockValueConstantRange(Value /*P*/ Val, 
                                        final LVILatticeVal /*&*/ BBLV, 
                                        Instruction /*P*/ BBI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::solve">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 567,
   FQN="(anonymous namespace)::LazyValueInfoCache::solve", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache5solveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache5solveEv")
  //</editor-fold>
  private void solve() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::lookup">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 466,
   FQN="(anonymous namespace)::LazyValueInfoCache::lookup", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache6lookupEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache6lookupEPN4llvm5ValueE")
  //</editor-fold>
  private SmallDenseMap<AssertingVH<BasicBlock>, LVILatticeVal> /*&*/ lookup(Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::isOverdefined">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 470,
   FQN="(anonymous namespace)::LazyValueInfoCache::isOverdefined", NM="_ZNK12_GLOBAL__N_118LazyValueInfoCache13isOverdefinedEPN4llvm5ValueEPNS1_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZNK12_GLOBAL__N_118LazyValueInfoCache13isOverdefinedEPN4llvm5ValueEPNS1_10BasicBlockE")
  //</editor-fold>
  private boolean isOverdefined(Value /*P*/ V, BasicBlock /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::hasCachedValueInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 479,
   FQN="(anonymous namespace)::LazyValueInfoCache::hasCachedValueInfo", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache18hasCachedValueInfoEPN4llvm5ValueEPNS1_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache18hasCachedValueInfoEPN4llvm5ValueEPNS1_10BasicBlockE")
  //</editor-fold>
  private boolean hasCachedValueInfo(Value /*P*/ V, BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::getCachedValueInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 491,
   FQN="(anonymous namespace)::LazyValueInfoCache::getCachedValueInfo", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache18getCachedValueInfoEPN4llvm5ValueEPNS1_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache18getCachedValueInfoEPN4llvm5ValueEPNS1_10BasicBlockE")
  //</editor-fold>
  private LVILatticeVal getCachedValueInfo(Value /*P*/ V, BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  /// This is the query interface to determine the lattice
  /// value for the specified Value* at the end of the specified block.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::getValueInBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1316,
   FQN="(anonymous namespace)::LazyValueInfoCache::getValueInBlock", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache15getValueInBlockEPN4llvm5ValueEPNS1_10BasicBlockEPNS1_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache15getValueInBlockEPN4llvm5ValueEPNS1_10BasicBlockEPNS1_11InstructionE")
  //</editor-fold>
  public LVILatticeVal getValueInBlock(Value /*P*/ V, BasicBlock /*P*/ BB) {
    return getValueInBlock(V, BB, 
                 (Instruction /*P*/ )null);
  }
  public LVILatticeVal getValueInBlock(Value /*P*/ V, BasicBlock /*P*/ BB, 
                 Instruction /*P*/ CxtI/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This is the query interface to determine the lattice
  /// value for the specified Value* at the specified instruction (generally
  /// from an assume intrinsic).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::getValueAt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1333,
   FQN="(anonymous namespace)::LazyValueInfoCache::getValueAt", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache10getValueAtEPN4llvm5ValueEPNS1_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache10getValueAtEPN4llvm5ValueEPNS1_11InstructionE")
  //</editor-fold>
  public LVILatticeVal getValueAt(Value /*P*/ V, Instruction /*P*/ CxtI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This is the query interface to determine the lattice
  /// value for the specified Value* that is true on the specified edge.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::getValueOnEdge">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1349,
   FQN="(anonymous namespace)::LazyValueInfoCache::getValueOnEdge", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache14getValueOnEdgeEPN4llvm5ValueEPNS1_10BasicBlockES5_PNS1_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache14getValueOnEdgeEPN4llvm5ValueEPNS1_10BasicBlockES5_PNS1_11InstructionE")
  //</editor-fold>
  public LVILatticeVal getValueOnEdge(Value /*P*/ V, BasicBlock /*P*/ FromBB, BasicBlock /*P*/ ToBB) {
    return getValueOnEdge(V, FromBB, ToBB, 
                (Instruction /*P*/ )null);
  }
  public LVILatticeVal getValueOnEdge(Value /*P*/ V, BasicBlock /*P*/ FromBB, BasicBlock /*P*/ ToBB, 
                Instruction /*P*/ CxtI/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This is the update interface to inform the cache that an edge from
  /// PredBB to OldSucc has been threaded to be from PredBB to NewSucc.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::threadEdge">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1367,
   FQN="(anonymous namespace)::LazyValueInfoCache::threadEdge", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache10threadEdgeEPN4llvm10BasicBlockES3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache10threadEdgeEPN4llvm10BasicBlockES3_S3_")
  //</editor-fold>
  public void threadEdge(BasicBlock /*P*/ PredBB, BasicBlock /*P*/ OldSucc, 
            BasicBlock /*P*/ NewSucc) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This is part of the update interface to inform the cache
  /// that a block has been deleted.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::eraseBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 552,
   FQN="(anonymous namespace)::LazyValueInfoCache::eraseBlock", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache10eraseBlockEPN4llvm10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache10eraseBlockEPN4llvm10BasicBlockE")
  //</editor-fold>
  public void eraseBlock(BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// clear - Empty the cache.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::clear">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 523,
   FQN="(anonymous namespace)::LazyValueInfoCache::clear", NM="_ZN12_GLOBAL__N_118LazyValueInfoCache5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCache5clearEv")
  //</editor-fold>
  public void clear() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::LazyValueInfoCache">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 529,
   FQN="(anonymous namespace)::LazyValueInfoCache::LazyValueInfoCache", NM="_ZN12_GLOBAL__N_118LazyValueInfoCacheC1EPN4llvm15AssumptionCacheERKNS1_10DataLayoutEPNS1_13DominatorTreeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCacheC1EPN4llvm15AssumptionCacheERKNS1_10DataLayoutEPNS1_13DominatorTreeE")
  //</editor-fold>
  public LazyValueInfoCache(AssumptionCache /*P*/ AC, final /*const*/ DataLayout /*&*/ DL) {
    this(AC, DL, 
      (DominatorTree /*P*/ )null);
  }
  public LazyValueInfoCache(AssumptionCache /*P*/ AC, final /*const*/ DataLayout /*&*/ DL, 
      DominatorTree /*P*/ DT/*= null*/) {
    // : ValueCache(), OverDefinedCache(), SeenBlocks(), BlockValueStack(), BlockValueSet(), AC(AC), DL(DL), DT(DT) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyValueInfoCache::~LazyValueInfoCache">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 384,
   FQN="(anonymous namespace)::LazyValueInfoCache::~LazyValueInfoCache", NM="_ZN12_GLOBAL__N_118LazyValueInfoCacheD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_118LazyValueInfoCacheD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "ValueCache=" + ValueCache // NOI18N
              + ", OverDefinedCache=" + OverDefinedCache // NOI18N
              + ", SeenBlocks=" + SeenBlocks // NOI18N
              + ", BlockValueStack=" + BlockValueStack // NOI18N
              + ", BlockValueSet=" + BlockValueSet // NOI18N
              + ", AC=" + AC // NOI18N
              + ", DL=" + DL // NOI18N
              + ", DT=" + DT; // NOI18N
  }
}
