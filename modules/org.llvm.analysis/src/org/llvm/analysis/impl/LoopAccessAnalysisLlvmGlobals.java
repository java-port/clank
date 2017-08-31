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


//<editor-fold defaultstate="collapsed" desc="static type LoopAccessAnalysisLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.LoopAccessAnalysisLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm12getPtrStrideERNS_25PredicatedScalarEvolutionEPNS_5ValueEPKNS_4LoopERKNS_8DenseMapIPKS2_S3_NS_12DenseMapInfoIS9_EENS_6detail12DenseMapPairIS9_S3_EEEEb;_ZN4llvm16stripIntegerCastEPNS_5ValueE;_ZN4llvm19isConsecutiveAccessEPNS_5ValueES1_RKNS_10DataLayoutERNS_15ScalarEvolutionEb;_ZN4llvm25replaceSymbolicStrideSCEVERNS_25PredicatedScalarEvolutionERKNS_8DenseMapIPKNS_5ValueEPS3_NS_12DenseMapInfoIS5_EENS_6detail12DenseMapPairIS5_S6_EEEES6_S6_; -static-type=LoopAccessAnalysisLlvmGlobals -package=org.llvm.analysis.impl")
//</editor-fold>
public final class LoopAccessAnalysisLlvmGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::stripIntegerCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 107,
 FQN="llvm::stripIntegerCast", NM="_ZN4llvm16stripIntegerCastEPNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16stripIntegerCastEPNS_5ValueE")
//</editor-fold>
public static Value /*P*/ stripIntegerCast(Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Return the SCEV corresponding to a pointer with the symbolic stride
/// replaced with constant one, assuming the SCEV predicate associated with
/// \p PSE is true.
///
/// If necessary this method will version the stride of the pointer according
/// to \p PtrToStride and therefore add further predicates to \p PSE.
///
/// If \p OrigPtr is not null, use it to look up the stride value instead of \p
/// Ptr.  \p PtrToStride provides the mapping between the pointer value and its
/// stride as collected by LoopVectorizationLegality::collectStridedAccess.
//<editor-fold defaultstate="collapsed" desc="llvm::replaceSymbolicStrideSCEV">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 114,
 FQN="llvm::replaceSymbolicStrideSCEV", NM="_ZN4llvm25replaceSymbolicStrideSCEVERNS_25PredicatedScalarEvolutionERKNS_8DenseMapIPKNS_5ValueEPS3_NS_12DenseMapInfoIS5_EENS_6detail12DenseMapPairIS5_S6_EEEES6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm25replaceSymbolicStrideSCEVERNS_25PredicatedScalarEvolutionERKNS_8DenseMapIPKNS_5ValueEPS3_NS_12DenseMapInfoIS5_EENS_6detail12DenseMapPairIS5_S6_EEEES6_S6_")
//</editor-fold>
public static /*const*/ SCEV /*P*/ replaceSymbolicStrideSCEV(final PredicatedScalarEvolution /*&*/ PSE, 
                         final /*const*/DenseMap</*const*/ Value /*P*/ , Value /*P*/ > /*&*/ PtrToStride, 
                         Value /*P*/ Ptr) {
  return replaceSymbolicStrideSCEV(PSE, 
                         PtrToStride, 
                         Ptr, (Value /*P*/ )null);
}
public static /*const*/ SCEV /*P*/ replaceSymbolicStrideSCEV(final PredicatedScalarEvolution /*&*/ PSE, 
                         final /*const*/DenseMap</*const*/ Value /*P*/ , Value /*P*/ > /*&*/ PtrToStride, 
                         Value /*P*/ Ptr, Value /*P*/ OrigPtr/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief If the pointer has a constant stride return it in units of its
/// element size.  Otherwise return zero.
///
/// Ensure that it does not wrap in the address space, assuming the predicate
/// associated with \p PSE is true.
///
/// If necessary this method will version the stride of the pointer according
/// to \p PtrToStride and therefore add further predicates to \p PSE.
/// The \p Assume parameter indicates if we are allowed to make additional
/// run-time assumptions.

/// \brief Check whether the access through \p Ptr has a constant stride.
//<editor-fold defaultstate="collapsed" desc="llvm::getPtrStride">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 869,
 FQN="llvm::getPtrStride", NM="_ZN4llvm12getPtrStrideERNS_25PredicatedScalarEvolutionEPNS_5ValueEPKNS_4LoopERKNS_8DenseMapIPKS2_S3_NS_12DenseMapInfoIS9_EENS_6detail12DenseMapPairIS9_S3_EEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm12getPtrStrideERNS_25PredicatedScalarEvolutionEPNS_5ValueEPKNS_4LoopERKNS_8DenseMapIPKS2_S3_NS_12DenseMapInfoIS9_EENS_6detail12DenseMapPairIS9_S3_EEEEb")
//</editor-fold>
public static long/*int64_t*/ getPtrStride(final PredicatedScalarEvolution /*&*/ PSE, Value /*P*/ Ptr, 
            /*const*/ Loop /*P*/ Lp) {
  return getPtrStride(PSE, Ptr, 
            Lp, new DenseMap</*const*/ Value /*P*/ , Value /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Value /*P*/ )null), 
            false);
}
public static long/*int64_t*/ getPtrStride(final PredicatedScalarEvolution /*&*/ PSE, Value /*P*/ Ptr, 
            /*const*/ Loop /*P*/ Lp, final /*const*/DenseMap</*const*/ Value /*P*/ , Value /*P*/ > /*&*/ StridesMap/*= ValueToValueMap()*/) {
  return getPtrStride(PSE, Ptr, 
            Lp, StridesMap, 
            false);
}
public static long/*int64_t*/ getPtrStride(final PredicatedScalarEvolution /*&*/ PSE, Value /*P*/ Ptr, 
            /*const*/ Loop /*P*/ Lp, final /*const*/DenseMap</*const*/ Value /*P*/ , Value /*P*/ > /*&*/ StridesMap/*= ValueToValueMap()*/, 
            boolean Assume/*= false*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Returns true if the memory operations \p A and \p B are consecutive.
/// This is a simple API that does not depend on the analysis pass. 

/// Returns true if the memory operations \p A and \p B are consecutive.
//<editor-fold defaultstate="collapsed" desc="llvm::isConsecutiveAccess">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 997,
 FQN="llvm::isConsecutiveAccess", NM="_ZN4llvm19isConsecutiveAccessEPNS_5ValueES1_RKNS_10DataLayoutERNS_15ScalarEvolutionEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm19isConsecutiveAccessEPNS_5ValueES1_RKNS_10DataLayoutERNS_15ScalarEvolutionEb")
//</editor-fold>
public static boolean isConsecutiveAccess(Value /*P*/ A, Value /*P*/ B, final /*const*/ DataLayout /*&*/ DL, 
                   final ScalarEvolution /*&*/ SE) {
  return isConsecutiveAccess(A, B, DL, 
                   SE, true);
}
public static boolean isConsecutiveAccess(Value /*P*/ A, Value /*P*/ B, final /*const*/ DataLayout /*&*/ DL, 
                   final ScalarEvolution /*&*/ SE, boolean CheckType/*= true*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class LoopAccessAnalysisLlvmGlobals
