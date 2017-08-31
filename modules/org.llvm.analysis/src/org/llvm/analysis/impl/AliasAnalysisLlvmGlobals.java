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

import org.clank.support.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;


//<editor-fold defaultstate="collapsed" desc="static type AliasAnalysisLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.AliasAnalysisLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm13isNoAliasCallEPKNS_5ValueE;_ZN4llvm17isNoAliasArgumentEPKNS_5ValueE;_ZN4llvm18isIdentifiedObjectEPKNS_5ValueE;_ZN4llvm23createLegacyPMAAResultsERNS_4PassERNS_8FunctionERNS_13BasicAAResultE;_ZN4llvm25getAAResultsAnalysisUsageERNS_13AnalysisUsageE;_ZN4llvm25isIdentifiedFunctionLocalEPKNS_5ValueE;_ZN4llvm26createAAResultsWrapperPassEv;_ZN4llvm27createExternalAAWrapperPassESt8functionIFvRNS_4PassERNS_8FunctionERNS_9AAResultsEEE; -static-type=AliasAnalysisLlvmGlobals -package=org.llvm.analysis.impl")
//</editor-fold>
public final class AliasAnalysisLlvmGlobals {


/// Return true if this pointer is returned by a noalias function.
//<editor-fold defaultstate="collapsed" desc="llvm::isNoAliasCall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 671,
 FQN="llvm::isNoAliasCall", NM="_ZN4llvm13isNoAliasCallEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm13isNoAliasCallEPKNS_5ValueE")
//</editor-fold>
public static boolean isNoAliasCall(/*const*/ Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if this is an argument with the noalias attribute.
//<editor-fold defaultstate="collapsed" desc="llvm::isNoAliasArgument">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 677,
 FQN="llvm::isNoAliasArgument", NM="_ZN4llvm17isNoAliasArgumentEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm17isNoAliasArgumentEPKNS_5ValueE")
//</editor-fold>
public static boolean isNoAliasArgument(/*const*/ Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if this pointer refers to a distinct and identifiable object.
/// This returns true for:
///    Global Variables and Functions (but not Global Aliases)
///    Allocas
///    ByVal and NoAlias Arguments
///    NoAlias returns (e.g. calls to malloc)
///
//<editor-fold defaultstate="collapsed" desc="llvm::isIdentifiedObject">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 683,
 FQN="llvm::isIdentifiedObject", NM="_ZN4llvm18isIdentifiedObjectEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm18isIdentifiedObjectEPKNS_5ValueE")
//</editor-fold>
public static boolean isIdentifiedObject(/*const*/ Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if V is umabigously identified at the function-level.
/// Different IdentifiedFunctionLocals can't alias.
/// Further, an IdentifiedFunctionLocal can not alias with any function
/// arguments other than itself, which is not necessarily true for
/// IdentifiedObjects.
//<editor-fold defaultstate="collapsed" desc="llvm::isIdentifiedFunctionLocal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 695,
 FQN="llvm::isIdentifiedFunctionLocal", NM="_ZN4llvm25isIdentifiedFunctionLocalEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm25isIdentifiedFunctionLocalEPKNS_5ValueE")
//</editor-fold>
public static boolean isIdentifiedFunctionLocal(/*const*/ Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::createAAResultsWrapperPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 570,
 FQN="llvm::createAAResultsWrapperPass", NM="_ZN4llvm26createAAResultsWrapperPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm26createAAResultsWrapperPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createAAResultsWrapperPass() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// A wrapper pass around a callback which can be used to populate the
/// AAResults in the AAResultsWrapperPass from an external AA.
///
/// The callback provided here will be used each time we prepare an AAResults
/// object, and will receive a reference to the function wrapper pass, the
/// function, and the AAResults object to populate. This should be used when
/// setting up a custom pass pipeline to inject a hook into the AA results.
//<editor-fold defaultstate="collapsed" desc="llvm::createExternalAAWrapperPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 545,
 FQN="llvm::createExternalAAWrapperPass", NM="_ZN4llvm27createExternalAAWrapperPassESt8functionIFvRNS_4PassERNS_8FunctionERNS_9AAResultsEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm27createExternalAAWrapperPassESt8functionIFvRNS_4PassERNS_8FunctionERNS_9AAResultsEEE")
//</editor-fold>
public static ImmutablePass /*P*/ createExternalAAWrapperPass(PassFunctionAAResults2Void Callback) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// A helper for the legacy pass manager to create a \c AAResults
/// object populated to the best of our ability for a particular function when
/// inside of a \c ModulePass or a \c CallGraphSCCPass.
///
/// If a \c ModulePass or a \c CallGraphSCCPass calls \p
/// createLegacyPMAAResults, it also needs to call \p addUsedAAAnalyses in \p
/// getAnalysisUsage.
//<editor-fold defaultstate="collapsed" desc="llvm::createLegacyPMAAResults">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 644,
 FQN="llvm::createLegacyPMAAResults", NM="_ZN4llvm23createLegacyPMAAResultsERNS_4PassERNS_8FunctionERNS_13BasicAAResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm23createLegacyPMAAResultsERNS_4PassERNS_8FunctionERNS_13BasicAAResultE")
//</editor-fold>
public static AAResults createLegacyPMAAResults(final Pass /*&*/ P, final Function /*&*/ F, 
                       final BasicAAResult /*&*/ BAR) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// A helper for the legacy pass manager to populate \p AU to add uses to make
/// sure the analyses required by \p createLegacyPMAAResults are available.
//<editor-fold defaultstate="collapsed" desc="llvm::getAAResultsAnalysisUsage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 699,
 FQN="llvm::getAAResultsAnalysisUsage", NM="_ZN4llvm25getAAResultsAnalysisUsageERNS_13AnalysisUsageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm25getAAResultsAnalysisUsageERNS_13AnalysisUsageE")
//</editor-fold>
public static void getAAResultsAnalysisUsage(final AnalysisUsage /*&*/ AU) {
  // This function needs to be in sync with llvm::createLegacyPMAAResults -- if
  // more alias analyses are added to llvm::createLegacyPMAAResults, they need
  // to be added here also.
  AU.<TargetLibraryInfoWrapperPass>addRequired(TargetLibraryInfoWrapperPass.class);
  AU.<ScopedNoAliasAAWrapperPass>addUsedIfAvailable(ScopedNoAliasAAWrapperPass.class);
  AU.<TypeBasedAAWrapperPass>addUsedIfAvailable(TypeBasedAAWrapperPass.class);
  AU.<ObjCARCAAWrapperPass>addUsedIfAvailable(ObjCARCAAWrapperPass.class);
  AU.<GlobalsAAWrapperPass>addUsedIfAvailable(GlobalsAAWrapperPass.class);
  AU.<CFLAndersAAWrapperPass>addUsedIfAvailable(CFLAndersAAWrapperPass.class);
  AU.<CFLSteensAAWrapperPass>addUsedIfAvailable(CFLSteensAAWrapperPass.class);
}

} // END OF class AliasAnalysisLlvmGlobals
