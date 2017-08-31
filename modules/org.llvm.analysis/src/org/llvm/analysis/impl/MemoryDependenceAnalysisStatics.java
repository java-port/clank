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
import static org.clank.support.NativePointer.*;
import org.llvm.adt.SmallPtrSet;
import org.llvm.adt.Statistic;
import org.llvm.adt.aliases.DenseMap;
import org.llvm.ir.*;
import org.llvm.pass.*;
import org.llvm.analysis.*;
import org.llvm.analysis.target.*;
import org.llvm.cl.*;
import org.llvm.cl.aliases.optUInt;


//<editor-fold defaultstate="collapsed" desc="static type MemoryDependenceAnalysisStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.MemoryDependenceAnalysisStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=Tpl__ZL20RemoveFromReverseMapRN4llvm8DenseMapIPNS_11InstructionENS_11SmallPtrSetIT_Lj4EEENS_12DenseMapInfoIS2_EENS_6detail12DenseMapPairIS2_S5_EEEES2_S4_;_ZL10isVolatilePN4llvm11InstructionE;_ZL11GetLocationPKN4llvm11InstructionERNS_14MemoryLocationERKNS_17TargetLibraryInfoE;_ZL12AssertSortedRSt6vectorIN4llvm16NonLocalDepEntryESaIS1_EEi;_ZL14BlockScanLimit;_ZL15NumResultsLimit;_ZL16BlockNumberLimit;_ZL16NumCacheNonLocal;_ZL18NumUncacheNonLocal;_ZL19NumCacheNonLocalPtr;_ZL21NumCacheDirtyNonLocal;_ZL21NumUncacheNonLocalPtr;_ZL24NumCacheDirtyNonLocalPtr;_ZL24SortNonLocalDepInfoCacheRSt6vectorIN4llvm16NonLocalDepEntryESaIS1_EEj;_ZL27NumCacheCompleteNonLocalPtr;_ZL38isLoadLoadClobberIfExtendedToFullWidthRKN4llvm14MemoryLocationERPKNS_5ValueERxPKNS_8LoadInstE;_ZL45InitializeMemoryDependenceWrapperPassPassFlag;_ZL45initializeMemoryDependenceWrapperPassPassOnceRN4llvm12PassRegistryE; -static-type=MemoryDependenceAnalysisStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class MemoryDependenceAnalysisStatics {

//<editor-fold defaultstate="collapsed" desc="NumCacheNonLocal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 40,
 FQN="NumCacheNonLocal", NM="_ZL16NumCacheNonLocal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZL16NumCacheNonLocal")
//</editor-fold>
public static Statistic NumCacheNonLocal = new Statistic($("memdep"), $("NumCacheNonLocal"), $("Number of fully cached non-local responses"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumCacheDirtyNonLocal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 41,
 FQN="NumCacheDirtyNonLocal", NM="_ZL21NumCacheDirtyNonLocal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZL21NumCacheDirtyNonLocal")
//</editor-fold>
public static Statistic NumCacheDirtyNonLocal = new Statistic($("memdep"), $("NumCacheDirtyNonLocal"), $("Number of dirty cached non-local responses"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumUncacheNonLocal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 42,
 FQN="NumUncacheNonLocal", NM="_ZL18NumUncacheNonLocal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZL18NumUncacheNonLocal")
//</editor-fold>
public static Statistic NumUncacheNonLocal = new Statistic($("memdep"), $("NumUncacheNonLocal"), $("Number of uncached non-local responses"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumCacheNonLocalPtr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 44,
 FQN="NumCacheNonLocalPtr", NM="_ZL19NumCacheNonLocalPtr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZL19NumCacheNonLocalPtr")
//</editor-fold>
public static Statistic NumCacheNonLocalPtr = new Statistic($("memdep"), $("NumCacheNonLocalPtr"), $("Number of fully cached non-local ptr responses"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumCacheDirtyNonLocalPtr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 46,
 FQN="NumCacheDirtyNonLocalPtr", NM="_ZL24NumCacheDirtyNonLocalPtr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZL24NumCacheDirtyNonLocalPtr")
//</editor-fold>
public static Statistic NumCacheDirtyNonLocalPtr = new Statistic($("memdep"), $("NumCacheDirtyNonLocalPtr"), $("Number of cached, but dirty, non-local ptr responses"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumUncacheNonLocalPtr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 48,
 FQN="NumUncacheNonLocalPtr", NM="_ZL21NumUncacheNonLocalPtr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZL21NumUncacheNonLocalPtr")
//</editor-fold>
public static Statistic NumUncacheNonLocalPtr = new Statistic($("memdep"), $("NumUncacheNonLocalPtr"), $("Number of uncached non-local ptr responses"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumCacheCompleteNonLocalPtr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 49,
 FQN="NumCacheCompleteNonLocalPtr", NM="_ZL27NumCacheCompleteNonLocalPtr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZL27NumCacheCompleteNonLocalPtr")
//</editor-fold>
public static Statistic NumCacheCompleteNonLocalPtr = new Statistic($("memdep"), $("NumCacheCompleteNonLocalPtr"), $("Number of block queries that were completely cached"), 0, false);

// Limit for the number of instructions to scan in a block.
//<editor-fold defaultstate="collapsed" desc="BlockScanLimit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 54,
 FQN="BlockScanLimit", NM="_ZL14BlockScanLimit",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZL14BlockScanLimit")
//</editor-fold>
public static optUInt BlockScanLimit/*J*/= new optUInt(opt.StorageKind.Internal, $("memdep-block-scan-limit"), OptionHidden.Hidden, ClGlobals.init$Int(100), 
    new desc($("The number of instructions to scan in a block in memory dependency analysis (default = 100)")));
//<editor-fold defaultstate="collapsed" desc="BlockNumberLimit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 59,
 FQN="BlockNumberLimit", NM="_ZL16BlockNumberLimit",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZL16BlockNumberLimit")
//</editor-fold>
public static optUInt BlockNumberLimit/*J*/= new optUInt(opt.StorageKind.Internal, $("memdep-block-number-limit"), OptionHidden.Hidden, ClGlobals.init$Int(1000), 
    new desc($("The number of blocks to scan during memory dependency analysis (default = 1000)")));

// Limit on the number of memdep results to process.
//<editor-fold defaultstate="collapsed" desc="NumResultsLimit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 65,
 FQN="NumResultsLimit", NM="_ZL15NumResultsLimit",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZL15NumResultsLimit")
//</editor-fold>
public static /*const*//*uint*/int NumResultsLimit = 100;

/// This is a helper function that removes Val from 'Inst's set in ReverseMap.
///
/// If the set becomes empty, remove Inst's entry.
/*template <typename KeyTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="RemoveFromReverseMap">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 71,
 FQN="RemoveFromReverseMap", NM="Tpl__ZL20RemoveFromReverseMapRN4llvm8DenseMapIPNS_11InstructionENS_11SmallPtrSetIT_Lj4EEENS_12DenseMapInfoIS2_EENS_6detail12DenseMapPairIS2_S5_EEEES2_S4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=Tpl__ZL20RemoveFromReverseMapRN4llvm8DenseMapIPNS_11InstructionENS_11SmallPtrSetIT_Lj4EEENS_12DenseMapInfoIS2_EENS_6detail12DenseMapPairIS2_S5_EEEES2_S4_")
//</editor-fold>
public static </*typename*/ KeyTy> void RemoveFromReverseMap(final DenseMap<Instruction /*P*/ , SmallPtrSet<KeyTy>/*<4>*/> /*&*/ ReverseMap, 
                    Instruction /*P*/ Inst, KeyTy Val) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// If the given instruction references a specific memory location, fill in Loc
/// with the details, otherwise set Loc.Ptr to null.
///
/// Returns a ModRefInfo value describing the general behavior of the
/// instruction.
//<editor-fold defaultstate="collapsed" desc="GetLocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 89,
 FQN="GetLocation", NM="_ZL11GetLocationPKN4llvm11InstructionERNS_14MemoryLocationERKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZL11GetLocationPKN4llvm11InstructionERNS_14MemoryLocationERKNS_17TargetLibraryInfoE")
//</editor-fold>
public static ModRefInfo GetLocation(/*const*/ Instruction /*P*/ Inst, final MemoryLocation /*&*/ Loc, 
           final /*const*/ TargetLibraryInfo /*&*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if LI is a load that would fully overlap MemLoc if done as
/// a wider legal integer load.
///
/// MemLocBase, MemLocOffset are lazily computed here the first time the
/// base/offs of memloc is needed.
//<editor-fold defaultstate="collapsed" desc="isLoadLoadClobberIfExtendedToFullWidth">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 228,
 FQN="isLoadLoadClobberIfExtendedToFullWidth", NM="_ZL38isLoadLoadClobberIfExtendedToFullWidthRKN4llvm14MemoryLocationERPKNS_5ValueERxPKNS_8LoadInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZL38isLoadLoadClobberIfExtendedToFullWidthRKN4llvm14MemoryLocationERPKNS_5ValueERxPKNS_8LoadInstE")
//</editor-fold>
public static boolean isLoadLoadClobberIfExtendedToFullWidth(final /*const*/ MemoryLocation /*&*/ MemLoc, 
                                      final type$ref</*const*/ Value /*P*/ /*&*/> MemLocBase, 
                                      final long$ref/*int64_t &*/ MemLocOffs, 
                                      /*const*/ LoadInst /*P*/ LI) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="isVolatile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 318,
 FQN="isVolatile", NM="_ZL10isVolatilePN4llvm11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZL10isVolatilePN4llvm11InstructionE")
//</editor-fold>
public static boolean isVolatile(Instruction /*P*/ Inst) {
  throw new UnsupportedOperationException("EmptyBody");
}

/// This method is used when -debug is specified to verify that cache arrays
/// are properly kept sorted.
//<editor-fold defaultstate="collapsed" desc="AssertSorted">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 737,
 FQN="AssertSorted", NM="_ZL12AssertSortedRSt6vectorIN4llvm16NonLocalDepEntryESaIS1_EEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZL12AssertSortedRSt6vectorIN4llvm16NonLocalDepEntryESaIS1_EEi")
//</editor-fold>
public static void AssertSorted(final std.vector<NonLocalDepEntry> /*&*/ Cache) {
  AssertSorted(Cache, 
            -1);
}
public static void AssertSorted(final std.vector<NonLocalDepEntry> /*&*/ Cache, 
            int Count/*= -1*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Sort the NonLocalDepInfo cache, given a certain number of elements in the
/// array that are already properly ordered.
///
/// This is optimized for the case when only a few entries are added.
//<editor-fold defaultstate="collapsed" desc="SortNonLocalDepInfoCache">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 999,
 FQN="SortNonLocalDepInfoCache", NM="_ZL24SortNonLocalDepInfoCacheRSt6vectorIN4llvm16NonLocalDepEntryESaIS1_EEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZL24SortNonLocalDepInfoCacheRSt6vectorIN4llvm16NonLocalDepEntryESaIS1_EEj")
//</editor-fold>
public static void SortNonLocalDepInfoCache(final std.vector<NonLocalDepEntry> /*&*/ Cache, 
                        /*uint*/int NumSortedEntries) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="initializeMemoryDependenceWrapperPassPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 1675,
 FQN="initializeMemoryDependenceWrapperPassPassOnce", NM="_ZL45initializeMemoryDependenceWrapperPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZL45initializeMemoryDependenceWrapperPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeMemoryDependenceWrapperPassPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeMemoryDependenceWrapperPassPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 1681,
 FQN="InitializeMemoryDependenceWrapperPassPassFlag", NM="_ZL45InitializeMemoryDependenceWrapperPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZL45InitializeMemoryDependenceWrapperPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeMemoryDependenceWrapperPassPassFlag/*J*/= new std.once_flag();
} // END OF class MemoryDependenceAnalysisStatics
