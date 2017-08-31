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


/// Provides a lazy, caching interface for making common memory aliasing
/// information queries, backed by LLVM's alias analysis passes.
///
/// The dependency information returned is somewhat unusual, but is pragmatic.
/// If queried about a store or call that might modify memory, the analysis
/// will return the instruction[s] that may either load from that memory or
/// store to it.  If queried with a load or call that can never modify memory,
/// the analysis will return calls and stores that might modify the pointer,
/// but generally does not return loads unless a) they are volatile, or
/// b) they load from *must-aliased* pointers.  Returning a dependence on
/// must-alias'd pointers instead of all pointers interacts well with the
/// internal caching mechanism.
//<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 267,
 FQN="llvm::MemoryDependenceResults", NM="_ZN4llvm23MemoryDependenceResultsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResultsE")
//</editor-fold>
public class MemoryDependenceResults implements Destructors.ClassWithDestructor {
  // A map from instructions to their dependency.
  // JAVA: typedef DenseMap<Instruction *, MemDepResult> LocalDepMapType
//  public final class LocalDepMapType extends DenseMap<Instruction /*P*/ , MemDepResult>{ };
  private DenseMap<Instruction /*P*/ , MemDepResult> LocalDeps;
/*public:*/
  // JAVA: typedef std::vector<NonLocalDepEntry> NonLocalDepInfo
//  public final class NonLocalDepInfo extends std.vector<NonLocalDepEntry>{ };
/*private:*/
  /// A pair<Value*, bool> where the bool is true if the dependence is a read
  /// only dependence, false if read/write.
  // JAVA: typedef PointerIntPair<const Value *, 1, bool> ValueIsLoadPair
//  public final class ValueIsLoadPair extends PointerBoolPair</*const*/ Value /*P*/ >{ };
  
  /// This pair is used when caching information for a block.
  ///
  /// If the pointer is null, the cache value is not a full query that starts
  /// at the specified block.  If non-null, the bool indicates whether or not
  /// the contents of the block was skipped.
  // JAVA: typedef PointerIntPair<BasicBlock *, 1, bool> BBSkipFirstBlockPair
//  public final class BBSkipFirstBlockPair extends PointerBoolPair<BasicBlock /*P*/ >{ };
  
  /// This record is the information kept for each (value, is load) pair.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::NonLocalPointerInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 288,
   FQN="llvm::MemoryDependenceResults::NonLocalPointerInfo", NM="_ZN4llvm23MemoryDependenceResults19NonLocalPointerInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults19NonLocalPointerInfoE")
  //</editor-fold>
  private static class/*struct*/ NonLocalPointerInfo implements Destructors.ClassWithDestructor {
    /// The pair of the block and the skip-first-block flag.
    public PointerBoolPair<BasicBlock /*P*/ > Pair;
    /// The results of the query for each relevant block.
    public std.vector<NonLocalDepEntry> NonLocalDeps;
    /// The maximum size of the dereferences of the pointer.
    ///
    /// May be UnknownSize if the sizes are unknown.
    public long/*uint64_t*/ Size;
    /// The AA tags associated with dereferences of the pointer.
    ///
    /// The members may be null if there are no tags or conflicting tags.
    public AAMDNodes AATags;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::NonLocalPointerInfo::NonLocalPointerInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 302,
     FQN="llvm::MemoryDependenceResults::NonLocalPointerInfo::NonLocalPointerInfo", NM="_ZN4llvm23MemoryDependenceResults19NonLocalPointerInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults19NonLocalPointerInfoC1Ev")
    //</editor-fold>
    public NonLocalPointerInfo() {
      // : Pair(), NonLocalDeps(), Size(MemoryLocation::UnknownSize), AATags() 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::NonLocalPointerInfo::NonLocalPointerInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 288,
     FQN="llvm::MemoryDependenceResults::NonLocalPointerInfo::NonLocalPointerInfo", NM="_ZN4llvm23MemoryDependenceResults19NonLocalPointerInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults19NonLocalPointerInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ NonLocalPointerInfo(JD$Move _dparam, final NonLocalPointerInfo /*&&*/$Prm0) {
      // : Pair(static_cast<NonLocalPointerInfo &&>().Pair), NonLocalDeps(static_cast<NonLocalPointerInfo &&>().NonLocalDeps), Size(static_cast<NonLocalPointerInfo &&>().Size), AATags(static_cast<NonLocalPointerInfo &&>().AATags) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::NonLocalPointerInfo::~NonLocalPointerInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 288,
     FQN="llvm::MemoryDependenceResults::NonLocalPointerInfo::~NonLocalPointerInfo", NM="_ZN4llvm23MemoryDependenceResults19NonLocalPointerInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults19NonLocalPointerInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::NonLocalPointerInfo::NonLocalPointerInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 288,
     FQN="llvm::MemoryDependenceResults::NonLocalPointerInfo::NonLocalPointerInfo", NM="_ZN4llvm23MemoryDependenceResults19NonLocalPointerInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults19NonLocalPointerInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ NonLocalPointerInfo(final /*const*/ NonLocalPointerInfo /*&*/ $Prm0) {
      // : Pair(.Pair), NonLocalDeps(.NonLocalDeps), Size(.Size), AATags(.AATags) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Pair=" + Pair // NOI18N
                + ", NonLocalDeps=" + NonLocalDeps // NOI18N
                + ", Size=" + Size // NOI18N
                + ", AATags=" + AATags; // NOI18N
    }
  };
  
  /// This map stores the cached results of doing a pointer lookup at the
  /// bottom of a block.
  ///
  /// The key of this map is the pointer+isload bit, the value is a list of
  /// <bb->result> mappings.
  // JAVA: typedef DenseMap<ValueIsLoadPair, NonLocalPointerInfo> CachedNonLocalPointerInfo
//  public final class CachedNonLocalPointerInfo extends DenseMap<PointerBoolPair</*const*/ Value /*P*/ >, NonLocalPointerInfo>{ };
  private DenseMap<PointerBoolPair</*const*/ Value /*P*/ >, NonLocalPointerInfo> NonLocalPointerDeps;
  
  // A map from instructions to their non-local pointer dependencies.
  // JAVA: typedef DenseMap<Instruction *, SmallPtrSet<ValueIsLoadPair, 4> > ReverseNonLocalPtrDepTy
//  public final class ReverseNonLocalPtrDepTy extends DenseMap<Instruction /*P*/ , SmallPtrSet<PointerBoolPair</*const*/ Value /*P*/ >>>{ };
  private DenseMap<Instruction /*P*/ , SmallPtrSet<PointerBoolPair</*const*/ Value /*P*/ >>> ReverseNonLocalPtrDeps;
  
  /// This is the instruction we keep for each cached access that we have for
  /// an instruction.
  ///
  /// The pointer is an owning pointer and the bool indicates whether we have
  /// any dirty bits in the set.
  // JAVA: typedef std::pair<NonLocalDepInfo, bool> PerInstNLInfo
//  public final class PerInstNLInfo extends std.pairTypeBool<std.vector<NonLocalDepEntry>>{ };
  
  // A map from instructions to their non-local dependencies.
  // JAVA: typedef DenseMap<Instruction *, PerInstNLInfo> NonLocalDepMapType
//  public final class NonLocalDepMapType extends DenseMap<Instruction /*P*/ , std.pairTypeBool<std.vector<NonLocalDepEntry>>>{ };
  
  private DenseMap<Instruction /*P*/ , std.pairTypeBool<std.vector<NonLocalDepEntry>>> NonLocalDeps;
  
  // A reverse mapping from dependencies to the dependees.  This is
  // used when removing instructions to keep the cache coherent.
  // JAVA: typedef DenseMap<Instruction *, SmallPtrSet<Instruction *, 4> > ReverseDepMapType
//  public final class ReverseDepMapType extends DenseMap<Instruction /*P*/ , SmallPtrSet<Instruction /*P*/ >>{ };
  private DenseMap<Instruction /*P*/ , SmallPtrSet<Instruction /*P*/ >> ReverseLocalDeps;
  
  // A reverse mapping from dependencies to the non-local dependees.
  private DenseMap<Instruction /*P*/ , SmallPtrSet<Instruction /*P*/ >> ReverseNonLocalDeps;
  
  /// Current AA implementation, just a cache.
  private final AAResults /*&*/ AA;
  private final AssumptionCache /*&*/ AC;
  private final /*const*/ TargetLibraryInfo /*&*/ TLI;
  private final DominatorTree /*&*/ DT;
  private PredIteratorCache PredCache;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::MemoryDependenceResults">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 348,
   FQN="llvm::MemoryDependenceResults::MemoryDependenceResults", NM="_ZN4llvm23MemoryDependenceResultsC1ERNS_9AAResultsERNS_15AssumptionCacheERKNS_17TargetLibraryInfoERNS_13DominatorTreeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResultsC1ERNS_9AAResultsERNS_15AssumptionCacheERKNS_17TargetLibraryInfoERNS_13DominatorTreeE")
  //</editor-fold>
  public MemoryDependenceResults(final AAResults /*&*/ AA, final AssumptionCache /*&*/ AC, 
      final /*const*/ TargetLibraryInfo /*&*/ TLI, 
      final DominatorTree /*&*/ DT) {
    // : LocalDeps(), NonLocalPointerDeps(), ReverseNonLocalPtrDeps(), NonLocalDeps(), ReverseLocalDeps(), ReverseNonLocalDeps(), AA(AA), AC(AC), TLI(TLI), DT(DT), PredCache() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns the instruction on which a memory operation depends.
  ///
  /// See the class comment for more details.  It is illegal to call this on
  /// non-memory instructions.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::getDependency">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 677,
   FQN="llvm::MemoryDependenceResults::getDependency", NM="_ZN4llvm23MemoryDependenceResults13getDependencyEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults13getDependencyEPNS_11InstructionE")
  //</editor-fold>
  public MemDepResult getDependency(Instruction /*P*/ QueryInst) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Perform a full dependency query for the specified call, returning the set
  /// of blocks that the value is potentially live across.
  ///
  /// The returned set of results will include a "NonLocal" result for all
  /// blocks where the value is live across.
  ///
  /// This method assumes the instruction returns a "NonLocal" dependency
  /// within its own block.
  ///
  /// This returns a reference to an internal data structure that may be
  /// invalidated on the next non-local query or when an instruction is
  /// removed.  Clients must copy this data if they want it around longer than
  /// that.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::getNonLocalCallDependency">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 746,
   FQN="llvm::MemoryDependenceResults::getNonLocalCallDependency", NM="_ZN4llvm23MemoryDependenceResults25getNonLocalCallDependencyENS_8CallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults25getNonLocalCallDependencyENS_8CallSiteE")
  //</editor-fold>
  public /*const*/std.vector<NonLocalDepEntry> /*&*/ getNonLocalCallDependency(CallSite QueryCS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Perform a full dependency query for an access to the QueryInst's
  /// specified memory location, returning the set of instructions that either
  /// define or clobber the value.
  ///
  /// Warning: For a volatile query instruction, the dependencies will be
  /// accurate, and thus usable for reordering, but it is never legal to
  /// remove the query instruction.
  ///
  /// This method assumes the pointer has a "NonLocal" dependency within
  /// QueryInst's parent basic block.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::getNonLocalPointerDependency">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 877,
   FQN="llvm::MemoryDependenceResults::getNonLocalPointerDependency", NM="_ZN4llvm23MemoryDependenceResults28getNonLocalPointerDependencyEPNS_11InstructionERNS_15SmallVectorImplINS_17NonLocalDepResultEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults28getNonLocalPointerDependencyEPNS_11InstructionERNS_15SmallVectorImplINS_17NonLocalDepResultEEE")
  //</editor-fold>
  public void getNonLocalPointerDependency(Instruction /*P*/ QueryInst, final SmallVectorImpl<NonLocalDepResult> /*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Removes an instruction from the dependence analysis, updating the
  /// dependence of instructions that previously depended on it.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::removeInstruction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 1457,
   FQN="llvm::MemoryDependenceResults::removeInstruction", NM="_ZN4llvm23MemoryDependenceResults17removeInstructionEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults17removeInstructionEPNS_11InstructionE")
  //</editor-fold>
  public void removeInstruction(Instruction /*P*/ RemInst) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Invalidates cached information about the specified pointer, because it
  /// may be too conservative in memdep.
  ///
  /// This is an optional call that can be used when the client detects an
  /// equivalence between the pointer and some other value and replaces the
  /// other value with ptr. This can make Ptr available in more places that
  /// cached info does not necessarily keep.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::invalidateCachedPointerInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 1443,
   FQN="llvm::MemoryDependenceResults::invalidateCachedPointerInfo", NM="_ZN4llvm23MemoryDependenceResults27invalidateCachedPointerInfoEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults27invalidateCachedPointerInfoEPNS_5ValueE")
  //</editor-fold>
  public void invalidateCachedPointerInfo(Value /*P*/ Ptr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Clears the PredIteratorCache info.
  ///
  /// This needs to be done when the CFG changes, e.g., due to splitting
  /// critical edges.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::invalidateCachedPredecessors">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 1453,
   FQN="llvm::MemoryDependenceResults::invalidateCachedPredecessors", NM="_ZN4llvm23MemoryDependenceResults28invalidateCachedPredecessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults28invalidateCachedPredecessorsEv")
  //</editor-fold>
  public void invalidateCachedPredecessors() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns the instruction on which a memory location depends.
  ///
  /// If isLoad is true, this routine ignores may-aliases with read-only
  /// operations.  If isLoad is false, this routine ignores may-aliases
  /// with reads from read-only locations. If possible, pass the query
  /// instruction as well; this function may take advantage of the metadata
  /// annotated to the query instruction to refine the result.
  ///
  /// Note that this is an uncached query, and thus may be inefficient.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::getPointerDependencyFrom">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 328,
   FQN="llvm::MemoryDependenceResults::getPointerDependencyFrom", NM="_ZN4llvm23MemoryDependenceResults24getPointerDependencyFromERKNS_14MemoryLocationEbNS_14ilist_iteratorINS_11InstructionEEEPNS_10BasicBlockEPS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults24getPointerDependencyFromERKNS_14MemoryLocationEbNS_14ilist_iteratorINS_11InstructionEEEPNS_10BasicBlockEPS5_")
  //</editor-fold>
  public MemDepResult getPointerDependencyFrom(final /*const*/ MemoryLocation /*&*/ MemLoc, boolean isLoad, ilist_iterator<Instruction> ScanIt, 
                          BasicBlock /*P*/ BB) {
    return getPointerDependencyFrom(MemLoc, isLoad, ScanIt, 
                          BB, (Instruction /*P*/ )null);
  }
  public MemDepResult getPointerDependencyFrom(final /*const*/ MemoryLocation /*&*/ MemLoc, boolean isLoad, ilist_iterator<Instruction> ScanIt, 
                          BasicBlock /*P*/ BB, Instruction /*P*/ QueryInst/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::getSimplePointerDependencyFrom">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 395,
   FQN="llvm::MemoryDependenceResults::getSimplePointerDependencyFrom", NM="_ZN4llvm23MemoryDependenceResults30getSimplePointerDependencyFromERKNS_14MemoryLocationEbNS_14ilist_iteratorINS_11InstructionEEEPNS_10BasicBlockEPS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults30getSimplePointerDependencyFromERKNS_14MemoryLocationEbNS_14ilist_iteratorINS_11InstructionEEEPNS_10BasicBlockEPS5_")
  //</editor-fold>
  public MemDepResult getSimplePointerDependencyFrom(final /*const*/ MemoryLocation /*&*/ MemLoc, boolean isLoad, ilist_iterator<Instruction> ScanIt, 
                                BasicBlock /*P*/ BB, Instruction /*P*/ QueryInst) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This analysis looks for other loads and stores with invariant.group
  /// metadata and the same pointer operand. Returns Unknown if it does not
  /// find anything, and Def if it can be assumed that 2 instructions load or
  /// store the same value.
  /// FIXME: This analysis works only on single block because of restrictions
  /// at the call site.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::getInvariantGroupPointerDependency">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 344,
   FQN="llvm::MemoryDependenceResults::getInvariantGroupPointerDependency", NM="_ZN4llvm23MemoryDependenceResults34getInvariantGroupPointerDependencyEPNS_8LoadInstEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults34getInvariantGroupPointerDependencyEPNS_8LoadInstEPNS_10BasicBlockE")
  //</editor-fold>
  public MemDepResult getInvariantGroupPointerDependency(LoadInst /*P*/ LI, 
                                    BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Looks at a memory location for a load (specified by MemLocBase, Offs, and
  /// Size) and compares it against a load.
  ///
  /// If the specified load could be safely widened to a larger integer load
  /// that is 1) still efficient, 2) safe for the target, and 3) would provide
  /// the specified memory location value, then this function returns the size
  /// in bytes of the load width to use.  If not, this returns zero.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::getLoadLoadClobberFullWidthSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 243,
   FQN="llvm::MemoryDependenceResults::getLoadLoadClobberFullWidthSize", NM="_ZN4llvm23MemoryDependenceResults31getLoadLoadClobberFullWidthSizeEPKNS_5ValueExjPKNS_8LoadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults31getLoadLoadClobberFullWidthSizeEPKNS_5ValueExjPKNS_8LoadInstE")
  //</editor-fold>
  public static /*uint*/int getLoadLoadClobberFullWidthSize(/*const*/ Value /*P*/ MemLocBase, long/*int64_t*/ MemLocOffs, /*uint*/int MemLocSize, 
                                 /*const*/ LoadInst /*P*/ LI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Release memory in caches.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 447,
   FQN="llvm::MemoryDependenceResults::releaseMemory", NM="_ZN4llvm23MemoryDependenceResults13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults13releaseMemoryEv")
  //</editor-fold>
  public void releaseMemory() {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*private:*/
  
  /// Private helper for finding the local dependencies of a call site.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::getCallSiteDependencyFrom">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 164,
   FQN="llvm::MemoryDependenceResults::getCallSiteDependencyFrom", NM="_ZN4llvm23MemoryDependenceResults25getCallSiteDependencyFromENS_8CallSiteEbNS_14ilist_iteratorINS_11InstructionEEEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults25getCallSiteDependencyFromENS_8CallSiteEbNS_14ilist_iteratorINS_11InstructionEEEPNS_10BasicBlockE")
  //</editor-fold>
  private MemDepResult getCallSiteDependencyFrom(CallSite CS, boolean isReadOnlyCall, ilist_iterator<Instruction> ScanIt, 
                           BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Perform a dependency query based on pointer/pointeesize starting at the end
  /// of StartBB.
  ///
  /// Add any clobber/def results to the results vector and keep track of which
  /// blocks are visited in 'Visited'.
  ///
  /// This has special behavior for the first block queries (when SkipFirstBlock
  /// is true).  In this special case, it ignores the contents of the specified
  /// block and starts returning dependence info for its predecessors.
  ///
  /// This function returns true on success, or false to indicate that it could
  /// not compute dependence information for some reason.  This should be treated
  /// as a clobber dependence on the first instruction in the predecessor block.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::getNonLocalPointerDepFromBB">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 1045,
   FQN="llvm::MemoryDependenceResults::getNonLocalPointerDepFromBB", NM="_ZN4llvm23MemoryDependenceResults27getNonLocalPointerDepFromBBEPNS_11InstructionERKNS_12PHITransAddrERKNS_14MemoryLocationEbPNS_10BasicBlockERNS_15SmallVectorImplINS_17NonLocalDepResultEEERNS_8DenseMapISA_PNS_5ValueENS_12DenseMapInfoISA_EENS_6detail12DenseMapPairISA_SH_EEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults27getNonLocalPointerDepFromBBEPNS_11InstructionERKNS_12PHITransAddrERKNS_14MemoryLocationEbPNS_10BasicBlockERNS_15SmallVectorImplINS_17NonLocalDepResultEEERNS_8DenseMapISA_PNS_5ValueENS_12DenseMapInfoISA_EENS_6detail12DenseMapPairISA_SH_EEEEb")
  //</editor-fold>
  private boolean getNonLocalPointerDepFromBB(Instruction /*P*/ QueryInst, final /*const*/ PHITransAddr /*&*/ Pointer, 
                             final /*const*/ MemoryLocation /*&*/ Loc, boolean isLoad, BasicBlock /*P*/ StartBB, 
                             final SmallVectorImpl<NonLocalDepResult> /*&*/ Result, 
                             final DenseMap<BasicBlock /*P*/ , Value /*P*/ > /*&*/ Visited) {
    return getNonLocalPointerDepFromBB(QueryInst, Pointer, 
                             Loc, isLoad, StartBB, 
                             Result, 
                             Visited, false);
  }
  private boolean getNonLocalPointerDepFromBB(Instruction /*P*/ QueryInst, final /*const*/ PHITransAddr /*&*/ Pointer, 
                             final /*const*/ MemoryLocation /*&*/ Loc, boolean isLoad, BasicBlock /*P*/ StartBB, 
                             final SmallVectorImpl<NonLocalDepResult> /*&*/ Result, 
                             final DenseMap<BasicBlock /*P*/ , Value /*P*/ > /*&*/ Visited, boolean SkipFirstBlock/*= false*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Compute the memdep value for BB with Pointer/PointeeSize using either
  /// cached information in Cache or by doing a lookup (which may use dirty cache
  /// info if available).
  ///
  /// If we do a lookup, add the result to the cache.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::GetNonLocalInfoForBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 930,
   FQN="llvm::MemoryDependenceResults::GetNonLocalInfoForBlock", NM="_ZN4llvm23MemoryDependenceResults23GetNonLocalInfoForBlockEPNS_11InstructionERKNS_14MemoryLocationEbPNS_10BasicBlockEPSt6vectorINS_16NonLocalDepEntryESaIS9_EEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults23GetNonLocalInfoForBlockEPNS_11InstructionERKNS_14MemoryLocationEbPNS_10BasicBlockEPSt6vectorINS_16NonLocalDepEntryESaIS9_EEj")
  //</editor-fold>
  private MemDepResult GetNonLocalInfoForBlock(Instruction /*P*/ QueryInst, final /*const*/ MemoryLocation /*&*/ Loc, boolean isLoad, 
                         BasicBlock /*P*/ BB, std.vector<NonLocalDepEntry> /*P*/ Cache, /*uint*/int NumSortedEntries) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// If P exists in CachedNonLocalPointerInfo, remove it.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::RemoveCachedNonLocalPointerDependencies">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 1419,
   FQN="llvm::MemoryDependenceResults::RemoveCachedNonLocalPointerDependencies", NM="_ZN4llvm23MemoryDependenceResults39RemoveCachedNonLocalPointerDependenciesENS_14PointerIntPairIPKNS_5ValueELj1EbNS_21PointerLikeTypeTraitsIS4_EENS_18PointerIntPairInfoIS4_Lj1ES6_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResults39RemoveCachedNonLocalPointerDependenciesENS_14PointerIntPairIPKNS_5ValueELj1EbNS_21PointerLikeTypeTraitsIS4_EENS_18PointerIntPairInfoIS4_Lj1ES6_EEEE")
  //</editor-fold>
  private void RemoveCachedNonLocalPointerDependencies(PointerBoolPair</*const*/ Value /*P*/ > P) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// Verify that the specified instruction does not occur in our internal data
  /// structures.
  ///
  /// This function verifies by asserting in debug builds.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::verifyRemoved">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 1619,
   FQN="llvm::MemoryDependenceResults::verifyRemoved", NM="_ZNK4llvm23MemoryDependenceResults13verifyRemovedEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZNK4llvm23MemoryDependenceResults13verifyRemovedEPNS_11InstructionE")
  //</editor-fold>
  private void verifyRemoved(Instruction /*P*/ D) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::MemoryDependenceResults">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 267,
   FQN="llvm::MemoryDependenceResults::MemoryDependenceResults", NM="_ZN4llvm23MemoryDependenceResultsC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResultsC1EOS0_")
  //</editor-fold>
  public /*inline*/ MemoryDependenceResults(JD$Move _dparam, final MemoryDependenceResults /*&&*/$Prm0) {
    // : LocalDeps(static_cast<MemoryDependenceResults &&>().LocalDeps), NonLocalPointerDeps(static_cast<MemoryDependenceResults &&>().NonLocalPointerDeps), ReverseNonLocalPtrDeps(static_cast<MemoryDependenceResults &&>().ReverseNonLocalPtrDeps), NonLocalDeps(static_cast<MemoryDependenceResults &&>().NonLocalDeps), ReverseLocalDeps(static_cast<MemoryDependenceResults &&>().ReverseLocalDeps), ReverseNonLocalDeps(static_cast<MemoryDependenceResults &&>().ReverseNonLocalDeps), AA(static_cast<MemoryDependenceResults &&>().AA), AC(static_cast<MemoryDependenceResults &&>().AC), TLI(static_cast<MemoryDependenceResults &&>().TLI), DT(static_cast<MemoryDependenceResults &&>().DT), PredCache(static_cast<MemoryDependenceResults &&>().PredCache) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceResults::~MemoryDependenceResults">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 267,
   FQN="llvm::MemoryDependenceResults::~MemoryDependenceResults", NM="_ZN4llvm23MemoryDependenceResultsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm23MemoryDependenceResultsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "LocalDeps=" + LocalDeps // NOI18N
              + ", NonLocalPointerDeps=" + NonLocalPointerDeps // NOI18N
              + ", ReverseNonLocalPtrDeps=" + ReverseNonLocalPtrDeps // NOI18N
              + ", NonLocalDeps=" + NonLocalDeps // NOI18N
              + ", ReverseLocalDeps=" + ReverseLocalDeps // NOI18N
              + ", ReverseNonLocalDeps=" + ReverseNonLocalDeps // NOI18N
              + ", AA=" + AA // NOI18N
              + ", AC=" + AC // NOI18N
              + ", TLI=" + TLI // NOI18N
              + ", DT=" + DT // NOI18N
              + ", PredCache=" + PredCache; // NOI18N
  }
}
