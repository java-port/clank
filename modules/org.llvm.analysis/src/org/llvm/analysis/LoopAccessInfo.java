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


/// \brief Drive the analysis of memory accesses in the loop
///
/// This class is responsible for analyzing the memory accesses of a loop.  It
/// collects the accesses and then its main helper the AccessAnalysis class
/// finds and categorizes the dependences in buildDependenceSets.
///
/// For memory dependences that can be analyzed at compile time, it determines
/// whether the dependence is part of cycle inhibiting vectorization.  This work
/// is delegated to the MemoryDepChecker class.
///
/// For memory dependences that cannot be determined at compile time, it
/// generates run-time checks to prove independence.  This is done by
/// AccessAnalysis::canCheckPtrAtRT and the checks are maintained by the
/// RuntimePointerCheck class.
///
/// If pointers can wrap or can't be expressed as affine AddRec expressions by
/// ScalarEvolution, we will generate run-time checks by emitting a
/// SCEVUnionPredicate.
///
/// Checks for both memory dependences and the SCEV predicates contained in the
/// PSE must be emitted in order for the results of this analysis to be valid.
//<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 512,
 FQN="llvm::LoopAccessInfo", NM="_ZN4llvm14LoopAccessInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm14LoopAccessInfoE")
//</editor-fold>
public class LoopAccessInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::LoopAccessInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 1920,
   FQN="llvm::LoopAccessInfo::LoopAccessInfo", NM="_ZN4llvm14LoopAccessInfoC1EPNS_4LoopEPNS_15ScalarEvolutionEPKNS_17TargetLibraryInfoEPNS_9AAResultsEPNS_13DominatorTreeEPNS_8LoopInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm14LoopAccessInfoC1EPNS_4LoopEPNS_15ScalarEvolutionEPKNS_17TargetLibraryInfoEPNS_9AAResultsEPNS_13DominatorTreeEPNS_8LoopInfoE")
  //</editor-fold>
  public LoopAccessInfo(Loop /*P*/ L, ScalarEvolution /*P*/ SE, 
      /*const*/ TargetLibraryInfo /*P*/ TLI, AAResults /*P*/ AA, 
      DominatorTree /*P*/ DT, LoopInfo /*P*/ LI) {
    // : PSE(llvm::make_unique<PredicatedScalarEvolution>(*SE, *L)), PtrRtChecking(llvm::make_unique<RuntimePointerChecking>(SE)), DepChecker(llvm::make_unique<MemoryDepChecker>(* PSE, L)), TheLoop(L), NumLoads(0), NumStores(0), MaxSafeDepDistBytes(-1), CanVecMem(false), StoreToLoopInvariantAddress(false), Report(), SymbolicStrides(), StrideSet() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // FIXME:
  // Hack for MSVC 2013 which sems like it can't synthesize this even 
  // with default keyword:
  // LoopAccessInfo(LoopAccessInfo &&LAI) = default;
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::LoopAccessInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 521,
   FQN="llvm::LoopAccessInfo::LoopAccessInfo", NM="_ZN4llvm14LoopAccessInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm14LoopAccessInfoC1EOS0_")
  //</editor-fold>
  public LoopAccessInfo(JD$Move _dparam, final LoopAccessInfo /*&&*/LAI) {
    // : PSE(std::move(LAI.PSE)), PtrRtChecking(std::move(LAI.PtrRtChecking)), DepChecker(std::move(LAI.DepChecker)), TheLoop(LAI.TheLoop), NumLoads(LAI.NumLoads), NumStores(LAI.NumStores), MaxSafeDepDistBytes(LAI.MaxSafeDepDistBytes), CanVecMem(LAI.CanVecMem), StoreToLoopInvariantAddress(LAI.StoreToLoopInvariantAddress), Report(std::move(LAI.Report)), SymbolicStrides(std::move(LAI.SymbolicStrides)), StrideSet(std::move(LAI.StrideSet)) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  // LoopAccessInfo &operator=(LoopAccessInfo &&LAI) = default;
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 531,
   FQN="llvm::LoopAccessInfo::operator=", NM="_ZN4llvm14LoopAccessInfoaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm14LoopAccessInfoaSEOS0_")
  //</editor-fold>
  public LoopAccessInfo /*&*/ $assignMove(final LoopAccessInfo /*&&*/LAI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true we can analyze the memory accesses in the loop and there are
  /// no memory dependence cycles.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::canVectorizeMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 551,
   FQN="llvm::LoopAccessInfo::canVectorizeMemory", NM="_ZNK4llvm14LoopAccessInfo18canVectorizeMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm14LoopAccessInfo18canVectorizeMemoryEv")
  //</editor-fold>
  public boolean canVectorizeMemory() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::getRuntimePointerChecking">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 553,
   FQN="llvm::LoopAccessInfo::getRuntimePointerChecking", NM="_ZNK4llvm14LoopAccessInfo25getRuntimePointerCheckingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm14LoopAccessInfo25getRuntimePointerCheckingEv")
  //</editor-fold>
  public /*const*/ RuntimePointerChecking /*P*/ getRuntimePointerChecking() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Number of memchecks required to prove independence of otherwise
  /// may-alias pointers.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::getNumRuntimePointerChecks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 559,
   FQN="llvm::LoopAccessInfo::getNumRuntimePointerChecks", NM="_ZNK4llvm14LoopAccessInfo26getNumRuntimePointerChecksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm14LoopAccessInfo26getNumRuntimePointerChecksEv")
  //</editor-fold>
  public /*uint*/int getNumRuntimePointerChecks() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the block BB needs to be predicated in order for the loop
  /// to be vectorized.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::blockNeedsPredication">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 1739,
   FQN="llvm::LoopAccessInfo::blockNeedsPredication", NM="_ZN4llvm14LoopAccessInfo21blockNeedsPredicationEPNS_10BasicBlockEPNS_4LoopEPNS_13DominatorTreeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm14LoopAccessInfo21blockNeedsPredicationEPNS_10BasicBlockEPNS_4LoopEPNS_13DominatorTreeE")
  //</editor-fold>
  public static boolean blockNeedsPredication(BasicBlock /*P*/ BB, Loop /*P*/ TheLoop, 
                       DominatorTree /*P*/ DT) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns true if the value V is uniform within the loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::isUniform">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 1753,
   FQN="llvm::LoopAccessInfo::isUniform", NM="_ZNK4llvm14LoopAccessInfo9isUniformEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm14LoopAccessInfo9isUniformEPNS_5ValueE")
  //</editor-fold>
  public boolean isUniform(Value /*P*/ V) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::getMaxSafeDepDistBytes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 571,
   FQN="llvm::LoopAccessInfo::getMaxSafeDepDistBytes", NM="_ZNK4llvm14LoopAccessInfo22getMaxSafeDepDistBytesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm14LoopAccessInfo22getMaxSafeDepDistBytesEv")
  //</editor-fold>
  public long/*uint64_t*/ getMaxSafeDepDistBytes() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::getNumStores">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 572,
   FQN="llvm::LoopAccessInfo::getNumStores", NM="_ZNK4llvm14LoopAccessInfo12getNumStoresEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm14LoopAccessInfo12getNumStoresEv")
  //</editor-fold>
  public /*uint*/int getNumStores() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::getNumLoads">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 573,
   FQN="llvm::LoopAccessInfo::getNumLoads", NM="_ZNK4llvm14LoopAccessInfo11getNumLoadsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm14LoopAccessInfo11getNumLoadsEv")
  //</editor-fold>
  public /*uint*/int getNumLoads() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Add code that checks at runtime if the accessed arrays overlap.
  ///
  /// Returns a pair of instructions where the first element is the first
  /// instruction generated in possibly a sequence of instructions and the
  /// second value is the final comparator value or NULL if no check is needed.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::addRuntimeChecks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 1893,
   FQN="llvm::LoopAccessInfo::addRuntimeChecks", NM="_ZNK4llvm14LoopAccessInfo16addRuntimeChecksEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm14LoopAccessInfo16addRuntimeChecksEPNS_11InstructionE")
  //</editor-fold>
  public std.pair<Instruction /*P*/ , Instruction /*P*/ > addRuntimeChecks(Instruction /*P*/ Loc) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Generete the instructions for the checks in \p PointerChecks.
  ///
  /// Returns a pair of instructions where the first element is the first
  /// instruction generated in possibly a sequence of instructions and the
  /// second value is the final comparator value or NULL if no check is needed.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::addRuntimeChecks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 1831,
   FQN="llvm::LoopAccessInfo::addRuntimeChecks", NM="_ZNK4llvm14LoopAccessInfo16addRuntimeChecksEPNS_11InstructionERKNS_15SmallVectorImplISt4pairIPKNS_22RuntimePointerChecking16CheckingPtrGroupES8_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm14LoopAccessInfo16addRuntimeChecksEPNS_11InstructionERKNS_15SmallVectorImplISt4pairIPKNS_22RuntimePointerChecking16CheckingPtrGroupES8_EEE")
  //</editor-fold>
  public std.pair<Instruction /*P*/ , Instruction /*P*/ > addRuntimeChecks(Instruction /*P*/ Loc, 
                  final /*const*/ SmallVectorImpl<std.pair</*const*/ RuntimePointerChecking.CheckingPtrGroup /*P*/ , /*const*/ RuntimePointerChecking.CheckingPtrGroup /*P*/ > > /*&*/ PointerChecks) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief The diagnostics report generated for the analysis.  E.g. why we
  /// couldn't analyze the loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::getReport">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 595,
   FQN="llvm::LoopAccessInfo::getReport", NM="_ZNK4llvm14LoopAccessInfo9getReportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm14LoopAccessInfo9getReportEv")
  //</editor-fold>
  public /*const*/ Optional<LoopAccessReport> /*&*/ getReport() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief the Memory Dependence Checker which can determine the
  /// loop-independent and loop-carried dependences between memory accesses.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::getDepChecker">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 599,
   FQN="llvm::LoopAccessInfo::getDepChecker", NM="_ZNK4llvm14LoopAccessInfo13getDepCheckerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm14LoopAccessInfo13getDepCheckerEv")
  //</editor-fold>
  public /*const*/ MemoryDepChecker /*&*/ getDepChecker() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return the list of instructions that use \p Ptr to read or write
  /// memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::getInstructionsForAccess">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 603,
   FQN="llvm::LoopAccessInfo::getInstructionsForAccess", NM="_ZNK4llvm14LoopAccessInfo24getInstructionsForAccessEPNS_5ValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm14LoopAccessInfo24getInstructionsForAccessEPNS_5ValueEb")
  //</editor-fold>
  public SmallVector<Instruction /*P*/ > getInstructionsForAccess(Value /*P*/ Ptr, 
                          boolean isWrite) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief If an access has a symbolic strides, this maps the pointer value to
  /// the stride symbol.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::getSymbolicStrides">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 610,
   FQN="llvm::LoopAccessInfo::getSymbolicStrides", NM="_ZNK4llvm14LoopAccessInfo18getSymbolicStridesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm14LoopAccessInfo18getSymbolicStridesEv")
  //</editor-fold>
  public /*const*/DenseMap</*const*/ Value /*P*/ , Value /*P*/ > /*&*/ getSymbolicStrides() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Pointer has a symbolic stride.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::hasStride">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 613,
   FQN="llvm::LoopAccessInfo::hasStride", NM="_ZNK4llvm14LoopAccessInfo9hasStrideEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm14LoopAccessInfo9hasStrideEPNS_5ValueE")
  //</editor-fold>
  public boolean hasStride(Value /*P*/ V) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Print the information about the memory accesses in the loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 1932,
   FQN="llvm::LoopAccessInfo::print", NM="_ZNK4llvm14LoopAccessInfo5printERNS_11raw_ostreamEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm14LoopAccessInfo5printERNS_11raw_ostreamEj")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    print(OS, 0);
  }
  public void print(final raw_ostream /*&*/ OS, /*uint*/int Depth/*= 0*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Checks existence of store to invariant address inside loop.
  /// If the loop has any store to invariant address, then it returns true,
  /// else returns false.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::hasStoreToLoopInvariantAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 621,
   FQN="llvm::LoopAccessInfo::hasStoreToLoopInvariantAddress", NM="_ZNK4llvm14LoopAccessInfo30hasStoreToLoopInvariantAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm14LoopAccessInfo30hasStoreToLoopInvariantAddressEv")
  //</editor-fold>
  public boolean hasStoreToLoopInvariantAddress() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Used to add runtime SCEV checks. Simplifies SCEV expressions and converts
  /// them to a more usable form.  All SCEV expressions during the analysis
  /// should be re-written (and therefore simplified) according to PSE.
  /// A user of LoopAccessAnalysis will need to emit the runtime checks
  /// associated with this predicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::getPSE">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 630,
   FQN="llvm::LoopAccessInfo::getPSE", NM="_ZNK4llvm14LoopAccessInfo6getPSEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm14LoopAccessInfo6getPSEEv")
  //</editor-fold>
  public /*const*/ PredicatedScalarEvolution /*&*/ getPSE() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// \brief Analyze the loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::analyzeLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 1508,
   FQN="llvm::LoopAccessInfo::analyzeLoop", NM="_ZN4llvm14LoopAccessInfo11analyzeLoopEPNS_9AAResultsEPNS_8LoopInfoEPKNS_17TargetLibraryInfoEPNS_13DominatorTreeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm14LoopAccessInfo11analyzeLoopEPNS_9AAResultsEPNS_8LoopInfoEPKNS_17TargetLibraryInfoEPNS_13DominatorTreeE")
  //</editor-fold>
  private void analyzeLoop(AAResults /*P*/ AA, LoopInfo /*P*/ LI, 
             /*const*/ TargetLibraryInfo /*P*/ TLI, 
             DominatorTree /*P*/ DT) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Check if the structure of the loop allows it to be analyzed by this
  /// pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::canAnalyzeLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 1454,
   FQN="llvm::LoopAccessInfo::canAnalyzeLoop", NM="_ZN4llvm14LoopAccessInfo14canAnalyzeLoopEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm14LoopAccessInfo14canAnalyzeLoopEv")
  //</editor-fold>
  private boolean canAnalyzeLoop() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::emitAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 1748,
   FQN="llvm::LoopAccessInfo::emitAnalysis", NM="_ZN4llvm14LoopAccessInfo12emitAnalysisERNS_16LoopAccessReportE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm14LoopAccessInfo12emitAnalysisERNS_16LoopAccessReportE")
  //</editor-fold>
  private void emitAnalysis(final LoopAccessReport /*&*/ Message) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Collect memory access with loop invariant strides.
  ///
  /// Looks for accesses like "a[i * StrideA]" where "StrideA" is loop
  /// invariant.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::collectStridedAccess">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 1901,
   FQN="llvm::LoopAccessInfo::collectStridedAccess", NM="_ZN4llvm14LoopAccessInfo20collectStridedAccessEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm14LoopAccessInfo20collectStridedAccessEPNS_5ValueE")
  //</editor-fold>
  private void collectStridedAccess(Value /*P*/ MemAccess) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private std.unique_ptr<PredicatedScalarEvolution> PSE;
  
  /// We need to check that all of the pointers in this list are disjoint
  /// at runtime. Using std::unique_ptr to make using move ctor simpler.
  private std.unique_ptr<RuntimePointerChecking> PtrRtChecking;
  
  /// \brief the Memory Dependence Checker which can determine the
  /// loop-independent and loop-carried dependences between memory accesses.
  private std.unique_ptr<MemoryDepChecker> DepChecker;
  
  private Loop /*P*/ TheLoop;
  
  private /*uint*/int NumLoads;
  private /*uint*/int NumStores;
  
  private long/*uint64_t*/ MaxSafeDepDistBytes;
  
  /// \brief Cache the result of analyzeLoop.
  private boolean CanVecMem;
  
  /// \brief Indicator for storing to uniform addresses.
  /// If a loop has write to a loop invariant address then it should be true.
  private boolean StoreToLoopInvariantAddress;
  
  /// \brief The diagnostics report generated for the analysis.  E.g. why we
  /// couldn't analyze the loop.
  private Optional<LoopAccessReport> Report;
  
  /// \brief If an access has a symbolic strides, this maps the pointer value to
  /// the stride symbol.
  private DenseMap</*const*/ Value /*P*/ , Value /*P*/ > SymbolicStrides;
  
  /// \brief Set of symbolic strides values.
  private SmallPtrSet<Value /*P*/ > StrideSet;
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopAccessInfo::~LoopAccessInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 512,
   FQN="llvm::LoopAccessInfo::~LoopAccessInfo", NM="_ZN4llvm14LoopAccessInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm14LoopAccessInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "PSE=" + PSE // NOI18N
              + ", PtrRtChecking=" + PtrRtChecking // NOI18N
              + ", DepChecker=" + DepChecker // NOI18N
              + ", TheLoop=" + TheLoop // NOI18N
              + ", NumLoads=" + NumLoads // NOI18N
              + ", NumStores=" + NumStores // NOI18N
              + ", MaxSafeDepDistBytes=" + MaxSafeDepDistBytes // NOI18N
              + ", CanVecMem=" + CanVecMem // NOI18N
              + ", StoreToLoopInvariantAddress=" + StoreToLoopInvariantAddress // NOI18N
              + ", Report=" + Report // NOI18N
              + ", SymbolicStrides=" + SymbolicStrides // NOI18N
              + ", StrideSet=" + StrideSet; // NOI18N
  }
}
