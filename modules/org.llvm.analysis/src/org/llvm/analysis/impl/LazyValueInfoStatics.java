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


//<editor-fold defaultstate="collapsed" desc="static type LazyValueInfoStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.LazyValueInfoStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZL14hasSingleValueRKN12_GLOBAL__N_113LVILatticeValE;_ZL17getEdgeValueLocalPN4llvm5ValueEPNS_10BasicBlockES3_RN12_GLOBAL__N_113LVILatticeValE;_ZL18getPredicateResultjPN4llvm8ConstantERN12_GLOBAL__N_113LVILatticeValERKNS_10DataLayoutEPNS_17TargetLibraryInfoE;_ZL20getFromRangeMetadataPN4llvm11InstructionE;_ZL25getValueFromFromConditionPN4llvm5ValueEPNS_8ICmpInstERN12_GLOBAL__N_113LVILatticeValEb;_ZL27isObjectDereferencedInBlockPN4llvm5ValueEPNS_10BasicBlockE;_ZL30InstructionDereferencesPointerPN4llvm11InstructionEPNS_5ValueE;_ZL42InitializeLazyValueInfoWrapperPassPassFlag;_ZL42initializeLazyValueInfoWrapperPassPassOnceRN4llvm12PassRegistryE;_ZL8getCacheRPvPN4llvm15AssumptionCacheEPKNS1_10DataLayoutEPNS1_13DominatorTreeE;_ZL9intersectN12_GLOBAL__N_113LVILatticeValES0_; -static-type=LazyValueInfoStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class LazyValueInfoStatics {

//<editor-fold defaultstate="collapsed" desc="initializeLazyValueInfoWrapperPassPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 42,
 FQN="initializeLazyValueInfoWrapperPassPassOnce", NM="_ZL42initializeLazyValueInfoWrapperPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZL42initializeLazyValueInfoWrapperPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeLazyValueInfoWrapperPassPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeLazyValueInfoWrapperPassPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 46,
 FQN="InitializeLazyValueInfoWrapperPassPassFlag", NM="_ZL42InitializeLazyValueInfoWrapperPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZL42InitializeLazyValueInfoWrapperPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeLazyValueInfoWrapperPassPassFlag/*J*/= new std.once_flag();

/// Returns true if this lattice value represents at most one possible value.
/// This is as precise as any lattice value can get while still representing
/// reachable code.
//<editor-fold defaultstate="collapsed" desc="hasSingleValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 301,
 FQN="hasSingleValue", NM="_ZL14hasSingleValueRKN12_GLOBAL__N_113LVILatticeValE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZL14hasSingleValueRKN12_GLOBAL__N_113LVILatticeValE")
//</editor-fold>
public static boolean hasSingleValue(final /*const*/ LVILatticeVal /*&*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Combine two sets of facts about the same value into a single set of
/// facts.  Note that this method is not suitable for merging facts along
/// different paths in a CFG; that's what the mergeIn function is for.  This
/// is for merging facts gathered about the same value at the same location
/// through two independent means.
/// Notes:
/// * This method does not promise to return the most precise possible lattice
///   value implied by A and B.  It is allowed to return any lattice element
///   which is at least as strong as *either* A or B (unless our facts
///   conflict, see below).
/// * Due to unreachable code, the intersection of two lattice values could be
///   contradictory.  If this happens, we return some valid lattice value so as
///   not confuse the rest of LVI.  Ideally, we'd always return Undefined, but
///   we do not make this guarantee.  TODO: This would be a useful enhancement.
//<editor-fold defaultstate="collapsed" desc="intersect">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 326,
 FQN="intersect", NM="_ZL9intersectN12_GLOBAL__N_113LVILatticeValES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZL9intersectN12_GLOBAL__N_113LVILatticeValES0_")
//</editor-fold>
public static LVILatticeVal intersect(LVILatticeVal A, LVILatticeVal B) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getFromRangeMetadata">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 607,
 FQN="getFromRangeMetadata", NM="_ZL20getFromRangeMetadataPN4llvm11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZL20getFromRangeMetadataPN4llvm11InstructionE")
//</editor-fold>
public static LVILatticeVal getFromRangeMetadata(Instruction /*P*/ BBI) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InstructionDereferencesPointer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 702,
 FQN="InstructionDereferencesPointer", NM="_ZL30InstructionDereferencesPointerPN4llvm11InstructionEPNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZL30InstructionDereferencesPointerPN4llvm11InstructionEPNS_5ValueE")
//</editor-fold>
public static boolean InstructionDereferencesPointer(Instruction /*P*/ I, Value /*P*/ Ptr) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if the allocation associated with Val is ever dereferenced
/// within the given basic block.  This establishes the fact Val is not null,
/// but does not imply that the memory at Val is dereferenceable.  (Val may
/// point off the end of the dereferenceable part of the object.)
//<editor-fold defaultstate="collapsed" desc="isObjectDereferencedInBlock">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 737,
 FQN="isObjectDereferencedInBlock", NM="_ZL27isObjectDereferencedInBlockPN4llvm5ValueEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZL27isObjectDereferencedInBlockPN4llvm5ValueEPNS_10BasicBlockE")
//</editor-fold>
public static boolean isObjectDereferencedInBlock(Value /*P*/ Val, BasicBlock /*P*/ BB) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getValueFromFromCondition">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1168,
 FQN="getValueFromFromCondition", NM="_ZL25getValueFromFromConditionPN4llvm5ValueEPNS_8ICmpInstERN12_GLOBAL__N_113LVILatticeValEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZL25getValueFromFromConditionPN4llvm5ValueEPNS_8ICmpInstERN12_GLOBAL__N_113LVILatticeValEb")
//</editor-fold>
public static boolean getValueFromFromCondition(Value /*P*/ Val, ICmpInst /*P*/ ICI, 
                         final LVILatticeVal /*&*/ Result) {
  return getValueFromFromCondition(Val, ICI, 
                         Result, true);
}
public static boolean getValueFromFromCondition(Value /*P*/ Val, ICmpInst /*P*/ ICI, 
                         final LVILatticeVal /*&*/ Result, boolean isTrueDest/*= true*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Compute the value of Val on the edge BBFrom -> BBTo. Returns false if
/// Val is not constrained on the edge.  Result is unspecified if return value
/// is false.
//<editor-fold defaultstate="collapsed" desc="getEdgeValueLocal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1213,
 FQN="getEdgeValueLocal", NM="_ZL17getEdgeValueLocalPN4llvm5ValueEPNS_10BasicBlockES3_RN12_GLOBAL__N_113LVILatticeValE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZL17getEdgeValueLocalPN4llvm5ValueEPNS_10BasicBlockES3_RN12_GLOBAL__N_113LVILatticeValE")
//</editor-fold>
public static boolean getEdgeValueLocal(Value /*P*/ Val, BasicBlock /*P*/ BBFrom, 
                 BasicBlock /*P*/ BBTo, final LVILatticeVal /*&*/ Result) {
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//                            LazyValueInfo Impl
//===----------------------------------------------------------------------===//

/// This lazily constructs the LazyValueInfoCache.
//<editor-fold defaultstate="collapsed" desc="getCache">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1428,
 FQN="getCache", NM="_ZL8getCacheRPvPN4llvm15AssumptionCacheEPKNS1_10DataLayoutEPNS1_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZL8getCacheRPvPN4llvm15AssumptionCacheEPKNS1_10DataLayoutEPNS1_13DominatorTreeE")
//</editor-fold>
public static LazyValueInfoCache /*&*/ getCache(final type$ref<Object>/*void P&*/ PImpl, AssumptionCache /*P*/ AC, 
        /*const*/ DataLayout /*P*/ DL) {
  return getCache(PImpl, AC, 
        DL, 
        (DominatorTree /*P*/ )null);
}
public static LazyValueInfoCache /*&*/ getCache(final type$ref<Object>/*void P&*/ PImpl, AssumptionCache /*P*/ AC, 
        /*const*/ DataLayout /*P*/ DL, 
        DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getPredicateResult">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 1532,
 FQN="getPredicateResult", NM="_ZL18getPredicateResultjPN4llvm8ConstantERN12_GLOBAL__N_113LVILatticeValERKNS_10DataLayoutEPNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZL18getPredicateResultjPN4llvm8ConstantERN12_GLOBAL__N_113LVILatticeValERKNS_10DataLayoutEPNS_17TargetLibraryInfoE")
//</editor-fold>
public static LazyValueInfo.Tristate getPredicateResult(/*uint*/int Pred, Constant /*P*/ C, 
                  final LVILatticeVal /*&*/ Result, 
                  final /*const*/ DataLayout /*&*/ DL, 
                  TargetLibraryInfo /*P*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class LazyValueInfoStatics
