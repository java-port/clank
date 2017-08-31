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
import org.llvm.analysis.bfi_detail.*;


//<editor-fold defaultstate="collapsed" desc="static type CFLAndersAliasAnalysisStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.CFLAndersAliasAnalysisStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZL12buildAttrMapRKN4llvm5cflaa8CFLGraphERKN12_GLOBAL__N_115ReachabilitySetE;_ZL12getNodeBelowRKN4llvm5cflaa8CFLGraphENS0_17InstantiatedValueE;_ZL18initializeWorkListRSt6vectorIN12_GLOBAL__N_112WorkListItemESaIS1_EERNS0_15ReachabilitySetERKN4llvm5cflaa8CFLGraphE;_ZL19processWorkListItemRKN12_GLOBAL__N_112WorkListItemERKN4llvm5cflaa8CFLGraphERNS_15ReachabilitySetERNS_11AliasMemSetERSt6vectorIS0_SaIS0_EE;_ZL21parentFunctionOfValuePKN4llvm5ValueE;_ZL40InitializeCFLAndersAAWrapperPassPassFlag;_ZL40initializeCFLAndersAAWrapperPassPassOnceRN4llvm12PassRegistryE;_ZL9propagateN4llvm5cflaa17InstantiatedValueES1_N12_GLOBAL__N_110MatchStateERNS2_15ReachabilitySetERSt6vectorINS2_12WorkListItemESaIS7_EE; -static-type=CFLAndersAliasAnalysisStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class CFLAndersAliasAnalysisStatics {

//<editor-fold defaultstate="collapsed" desc="parentFunctionOfValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 60,
 FQN="parentFunctionOfValue", NM="_ZL21parentFunctionOfValuePKN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZL21parentFunctionOfValuePKN4llvm5ValueE")
//</editor-fold>
public static /*const*/ Function /*P*/ parentFunctionOfValue(/*const*/ Value /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="propagate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 272,
 FQN="propagate", NM="_ZL9propagateN4llvm5cflaa17InstantiatedValueES1_N12_GLOBAL__N_110MatchStateERNS2_15ReachabilitySetERSt6vectorINS2_12WorkListItemESaIS7_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZL9propagateN4llvm5cflaa17InstantiatedValueES1_N12_GLOBAL__N_110MatchStateERNS2_15ReachabilitySetERSt6vectorINS2_12WorkListItemESaIS7_EE")
//</editor-fold>
public static void propagate(InstantiatedValue From, InstantiatedValue To, 
         MatchState State, final ReachabilitySet /*&*/ ReachSet, 
         final std.vector<WorkListItem> /*&*/ WorkList) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="initializeWorkList">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 281,
 FQN="initializeWorkList", NM="_ZL18initializeWorkListRSt6vectorIN12_GLOBAL__N_112WorkListItemESaIS1_EERNS0_15ReachabilitySetERKN4llvm5cflaa8CFLGraphE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZL18initializeWorkListRSt6vectorIN12_GLOBAL__N_112WorkListItemESaIS1_EERNS0_15ReachabilitySetERKN4llvm5cflaa8CFLGraphE")
//</editor-fold>
public static void initializeWorkList(final std.vector<WorkListItem> /*&*/ WorkList, 
                  final ReachabilitySet /*&*/ ReachSet, 
                  final /*const*/ CFLGraph /*&*/ Graph) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getNodeBelow">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 302,
 FQN="getNodeBelow", NM="_ZL12getNodeBelowRKN4llvm5cflaa8CFLGraphENS0_17InstantiatedValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZL12getNodeBelowRKN4llvm5cflaa8CFLGraphENS0_17InstantiatedValueE")
//</editor-fold>
public static Optional<InstantiatedValue> getNodeBelow(final /*const*/ CFLGraph /*&*/ Graph, 
            InstantiatedValue V) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="processWorkListItem">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 310,
 FQN="processWorkListItem", NM="_ZL19processWorkListItemRKN12_GLOBAL__N_112WorkListItemERKN4llvm5cflaa8CFLGraphERNS_15ReachabilitySetERNS_11AliasMemSetERSt6vectorIS0_SaIS0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZL19processWorkListItemRKN12_GLOBAL__N_112WorkListItemERKN4llvm5cflaa8CFLGraphERNS_15ReachabilitySetERNS_11AliasMemSetERSt6vectorIS0_SaIS0_EE")
//</editor-fold>
public static void processWorkListItem(final /*const*/ WorkListItem /*&*/ Item, final /*const*/ CFLGraph /*&*/ Graph, 
                   final ReachabilitySet /*&*/ ReachSet, final AliasMemSet /*&*/ MemSet, 
                   final std.vector<WorkListItem> /*&*/ WorkList) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="buildAttrMap">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 396,
 FQN="buildAttrMap", NM="_ZL12buildAttrMapRKN4llvm5cflaa8CFLGraphERKN12_GLOBAL__N_115ReachabilitySetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZL12buildAttrMapRKN4llvm5cflaa8CFLGraphERKN12_GLOBAL__N_115ReachabilitySetE")
//</editor-fold>
public static AliasAttrMap buildAttrMap(final /*const*/ CFLGraph /*&*/ Graph, 
            final /*const*/ ReachabilitySet /*&*/ ReachSet) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="initializeCFLAndersAAWrapperPassPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 565,
 FQN="initializeCFLAndersAAWrapperPassPassOnce", NM="_ZL40initializeCFLAndersAAWrapperPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZL40initializeCFLAndersAAWrapperPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeCFLAndersAAWrapperPassPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeCFLAndersAAWrapperPassPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 565,
 FQN="InitializeCFLAndersAAWrapperPassPassFlag", NM="_ZL40InitializeCFLAndersAAWrapperPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZL40InitializeCFLAndersAAWrapperPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeCFLAndersAAWrapperPassPassFlag/*J*/= new std.once_flag();
} // END OF class CFLAndersAliasAnalysisStatics
