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

import org.llvm.cl.aliases.optBool;
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
import org.llvm.analysis.bfi_detail.*;


//<editor-fold defaultstate="collapsed" desc="static type BasicAliasAnalysisStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.BasicAliasAnalysisStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL11SearchTimes;_ZL12isObjectSizePKN4llvm5ValueEyRKNS_10DataLayoutERKNS_17TargetLibraryInfoE;_ZL13getObjectSizePKN4llvm5ValueERKNS_10DataLayoutERKNS_17TargetLibraryInfoEb;_ZL14isEscapeSourcePKN4llvm5ValueE;_ZL15isIntrinsicCallN4llvm17ImmutableCallSiteENS_9Intrinsic2IDE;_ZL16isWriteOnlyParamN4llvm17ImmutableCallSiteEjRKNS_17TargetLibraryInfoE;_ZL17MergeAliasResultsN4llvm11AliasResultES0_;_ZL18SearchLimitReached;_ZL18notDifferentParentPKN4llvm5ValueES2_;_ZL19adjustToPointerSizexj;_ZL19isObjectSmallerThanPKN4llvm5ValueEyRKNS_10DataLayoutERKNS_17TargetLibraryInfoE;_ZL20EnableRecPhiAnalysis;_ZL20MaxLookupSearchDepth;_ZL24aliasSameBasePointerGEPsPKN4llvm11GEPOperatorEyS2_yRKNS_10DataLayoutE;_ZL24isNonEscapingLocalObjectPKN4llvm5ValueE;_ZL34MaxNumPhiBBsValueReachabilityCheck;_ZL36InitializeBasicAAWrapperPassPassFlag;_ZL36initializeBasicAAWrapperPassPassOnceRN4llvm12PassRegistryE;_ZL9getParentPKN4llvm5ValueE; -static-type=BasicAliasAnalysisStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class BasicAliasAnalysisStatics {


/// Enable analysis of recursive PHI nodes.
//<editor-fold defaultstate="collapsed" desc="EnableRecPhiAnalysis">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 46,
 FQN="EnableRecPhiAnalysis", NM="_ZL20EnableRecPhiAnalysis",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL20EnableRecPhiAnalysis")
//</editor-fold>
public static optBool EnableRecPhiAnalysis/*J*/= new optBool($("basicaa-recphi"), OptionHidden.Hidden, 
    init(false));
/// SearchLimitReached / SearchTimes shows how often the limit of
/// to decompose GEPs is reached. It will affect the precision
/// of basic alias analysis.
//<editor-fold defaultstate="collapsed" desc="SearchLimitReached">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 51,
 FQN="SearchLimitReached", NM="_ZL18SearchLimitReached",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL18SearchLimitReached")
//</editor-fold>
public static Statistic SearchLimitReached = new Statistic($("basicaa"), $("SearchLimitReached"), $("Number of times the limit to decompose GEPs is reached"), 0, false);
//<editor-fold defaultstate="collapsed" desc="SearchTimes">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 53,
 FQN="SearchTimes", NM="_ZL11SearchTimes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL11SearchTimes")
//</editor-fold>
public static Statistic SearchTimes = new Statistic($("basicaa"), $("SearchTimes"), $("Number of times a GEP is decomposed"), 0, false);

/// Cutoff after which to stop analysing a set of phi nodes potentially involved
/// in a cycle. Because we are analysing 'through' phi nodes, we need to be
/// careful with value equivalence. We use reachability to make sure a value
/// cannot be involved in a cycle.
//<editor-fold defaultstate="collapsed" desc="MaxNumPhiBBsValueReachabilityCheck">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 59,
 FQN="MaxNumPhiBBsValueReachabilityCheck", NM="_ZL34MaxNumPhiBBsValueReachabilityCheck",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL34MaxNumPhiBBsValueReachabilityCheck")
//</editor-fold>
public static /*const*//*uint*/int MaxNumPhiBBsValueReachabilityCheck = 20;

// The max limit of the search depth in DecomposeGEPExpression() and
// GetUnderlyingObject(), both functions need to use the same search
// depth otherwise the algorithm in aliasGEP will assert.
//<editor-fold defaultstate="collapsed" desc="MaxLookupSearchDepth">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 64,
 FQN="MaxLookupSearchDepth", NM="_ZL20MaxLookupSearchDepth",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL20MaxLookupSearchDepth")
//</editor-fold>
public static /*const*//*uint*/int MaxLookupSearchDepth = 6;

//===----------------------------------------------------------------------===//
// Useful predicates
//===----------------------------------------------------------------------===//

/// Returns true if the pointer is to a function-local object that never
/// escapes from the function.
//<editor-fold defaultstate="collapsed" desc="isNonEscapingLocalObject">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 72,
 FQN="isNonEscapingLocalObject", NM="_ZL24isNonEscapingLocalObjectPKN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL24isNonEscapingLocalObjectPKN4llvm5ValueE")
//</editor-fold>
public static boolean isNonEscapingLocalObject(/*const*/ Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Returns true if the pointer is one which would have been considered an
/// escape by isNonEscapingLocalObject.
//<editor-fold defaultstate="collapsed" desc="isEscapeSource">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 97,
 FQN="isEscapeSource", NM="_ZL14isEscapeSourcePKN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL14isEscapeSourcePKN4llvm5ValueE")
//</editor-fold>
public static boolean isEscapeSource(/*const*/ Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Returns the size of the object specified by V or UnknownSize if unknown.
//<editor-fold defaultstate="collapsed" desc="getObjectSize">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 111,
 FQN="getObjectSize", NM="_ZL13getObjectSizePKN4llvm5ValueERKNS_10DataLayoutERKNS_17TargetLibraryInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL13getObjectSizePKN4llvm5ValueERKNS_10DataLayoutERKNS_17TargetLibraryInfoEb")
//</editor-fold>
public static long/*uint64_t*/ getObjectSize(/*const*/ Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, 
             final /*const*/ TargetLibraryInfo /*&*/ TLI) {
  return getObjectSize(V, DL, 
             TLI, 
             false);
}
public static long/*uint64_t*/ getObjectSize(/*const*/ Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, 
             final /*const*/ TargetLibraryInfo /*&*/ TLI, 
             boolean RoundToAlign/*= false*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Returns true if we can prove that the object specified by V is smaller than
/// Size.
//<editor-fold defaultstate="collapsed" desc="isObjectSmallerThan">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 122,
 FQN="isObjectSmallerThan", NM="_ZL19isObjectSmallerThanPKN4llvm5ValueEyRKNS_10DataLayoutERKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL19isObjectSmallerThanPKN4llvm5ValueEyRKNS_10DataLayoutERKNS_17TargetLibraryInfoE")
//</editor-fold>
public static boolean isObjectSmallerThan(/*const*/ Value /*P*/ V, long/*uint64_t*/ Size, 
                   final /*const*/ DataLayout /*&*/ DL, 
                   final /*const*/ TargetLibraryInfo /*&*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Returns true if we can prove that the object specified by V has size Size.
//<editor-fold defaultstate="collapsed" desc="isObjectSize">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 162,
 FQN="isObjectSize", NM="_ZL12isObjectSizePKN4llvm5ValueEyRKNS_10DataLayoutERKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL12isObjectSizePKN4llvm5ValueEyRKNS_10DataLayoutERKNS_17TargetLibraryInfoE")
//</editor-fold>
public static boolean isObjectSize(/*const*/ Value /*P*/ V, long/*uint64_t*/ Size, final /*const*/ DataLayout /*&*/ DL, 
            final /*const*/ TargetLibraryInfo /*&*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// To ensure a pointer offset fits in an integer of size PointerSize
/// (in bits) when that size is smaller than 64. This is an issue in
/// particular for 32b programs with negative indices that rely on two's
/// complement wrap-arounds for precise alias information.
//<editor-fold defaultstate="collapsed" desc="adjustToPointerSize">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 327,
 FQN="adjustToPointerSize", NM="_ZL19adjustToPointerSizexj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL19adjustToPointerSizexj")
//</editor-fold>
public static long/*int64_t*/ adjustToPointerSize(long/*int64_t*/ Offset, /*uint*/int PointerSize) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Returns true if this is a writeonly (i.e Mod only) parameter.
//<editor-fold defaultstate="collapsed" desc="isWriteOnlyParam">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 611,
 FQN="isWriteOnlyParam", NM="_ZL16isWriteOnlyParamN4llvm17ImmutableCallSiteEjRKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL16isWriteOnlyParamN4llvm17ImmutableCallSiteEjRKNS_17TargetLibraryInfoE")
//</editor-fold>
public static boolean isWriteOnlyParam(ImmutableCallSite CS, /*uint*/int ArgIdx, 
                final /*const*/ TargetLibraryInfo /*&*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="isIntrinsicCall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 651,
 FQN="isIntrinsicCall", NM="_ZL15isIntrinsicCallN4llvm17ImmutableCallSiteENS_9Intrinsic2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL15isIntrinsicCallN4llvm17ImmutableCallSiteENS_9Intrinsic2IDE")
//</editor-fold>
public static boolean isIntrinsicCall(ImmutableCallSite CS, /*Intrinsic.ID*/int IID) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getParent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 657,
 FQN="getParent", NM="_ZL9getParentPKN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL9getParentPKN4llvm5ValueE")
//</editor-fold>
public static /*const*/ Function /*P*/ getParent(/*const*/ Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="notDifferentParent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 667,
 FQN="notDifferentParent", NM="_ZL18notDifferentParentPKN4llvm5ValueES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL18notDifferentParentPKN4llvm5ValueES2_")
//</editor-fold>
public static boolean notDifferentParent(/*const*/ Value /*P*/ O1, /*const*/ Value /*P*/ O2) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Provide ad-hoc rules to disambiguate accesses through two GEP operators,
/// both having the exact same pointer operand.
//<editor-fold defaultstate="collapsed" desc="aliasSameBasePointerGEPs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 820,
 FQN="aliasSameBasePointerGEPs", NM="_ZL24aliasSameBasePointerGEPsPKN4llvm11GEPOperatorEyS2_yRKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL24aliasSameBasePointerGEPsPKN4llvm11GEPOperatorEyS2_yRKNS_10DataLayoutE")
//</editor-fold>
public static AliasResult aliasSameBasePointerGEPs(/*const*/ GEPOperator /*P*/ GEP1, 
                        long/*uint64_t*/ V1Size, 
                        /*const*/ GEPOperator /*P*/ GEP2, 
                        long/*uint64_t*/ V2Size, 
                        final /*const*/ DataLayout /*&*/ DL) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="MergeAliasResults">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 1237,
 FQN="MergeAliasResults", NM="_ZL17MergeAliasResultsN4llvm11AliasResultES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL17MergeAliasResultsN4llvm11AliasResultES0_")
//</editor-fold>
public static AliasResult MergeAliasResults(AliasResult A, AliasResult B) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="initializeBasicAAWrapperPassPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 1687,
 FQN="initializeBasicAAWrapperPassPassOnce", NM="_ZL36initializeBasicAAWrapperPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL36initializeBasicAAWrapperPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeBasicAAWrapperPassPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeBasicAAWrapperPassPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 1692,
 FQN="InitializeBasicAAWrapperPassPassFlag", NM="_ZL36InitializeBasicAAWrapperPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZL36InitializeBasicAAWrapperPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeBasicAAWrapperPassPassFlag/*J*/= new std.once_flag();
} // END OF class BasicAliasAnalysisStatics
