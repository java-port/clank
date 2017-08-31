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

import org.llvm.cl.aliases.optInt;
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


//<editor-fold defaultstate="collapsed" desc="static type InlineCostStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.InlineCostStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=Tpl__ZL16attributeMatchesPN4llvm8FunctionES1_T_;_ZL13ColdThreshold;_ZL13HintThreshold;_ZL16NumCallsAnalyzed;_ZL16OptSizeThreshold;_ZL19OptMinSizeThreshold;_ZL22DefaultInlineThreshold;_ZL22OptAggressiveThreshold;_ZL33functionsHaveCompatibleAttributesPN4llvm8FunctionES1_RNS_19TargetTransformInfoE; -static-type=InlineCostStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class InlineCostStatics {

//<editor-fold defaultstate="collapsed" desc="NumCallsAnalyzed">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 41,
 FQN="NumCallsAnalyzed", NM="_ZL16NumCallsAnalyzed",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZL16NumCallsAnalyzed")
//</editor-fold>
public static Statistic NumCallsAnalyzed = new Statistic($("inline-cost"), $("NumCallsAnalyzed"), $("Number of call sites analyzed"), 0, false);

// Threshold to use when optsize is specified (and there is no
// -inline-threshold).
//<editor-fold defaultstate="collapsed" desc="OptSizeThreshold">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 45,
 FQN="OptSizeThreshold", NM="_ZL16OptSizeThreshold",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZL16OptSizeThreshold")
//</editor-fold>
public static /*const*/int OptSizeThreshold = 75;

// Threshold to use when -Oz is specified (and there is no -inline-threshold).
//<editor-fold defaultstate="collapsed" desc="OptMinSizeThreshold">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 48,
 FQN="OptMinSizeThreshold", NM="_ZL19OptMinSizeThreshold",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZL19OptMinSizeThreshold")
//</editor-fold>
public static /*const*/int OptMinSizeThreshold = 25;

// Threshold to use when -O[34] is specified (and there is no
// -inline-threshold).
//<editor-fold defaultstate="collapsed" desc="OptAggressiveThreshold">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 52,
 FQN="OptAggressiveThreshold", NM="_ZL22OptAggressiveThreshold",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZL22OptAggressiveThreshold")
//</editor-fold>
public static /*const*/int OptAggressiveThreshold = 275;
//<editor-fold defaultstate="collapsed" desc="DefaultInlineThreshold">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 54,
 FQN="DefaultInlineThreshold", NM="_ZL22DefaultInlineThreshold",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZL22DefaultInlineThreshold")
//</editor-fold>
public static optInt DefaultInlineThreshold/*J*/= new optInt($("inline-threshold"), OptionHidden.Hidden, init(225), NumOccurrencesFlag.ZeroOrMore, 
    new desc($("Control the amount of inlining to perform (default = 225)")));
//<editor-fold defaultstate="collapsed" desc="HintThreshold">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 58,
 FQN="HintThreshold", NM="_ZL13HintThreshold",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZL13HintThreshold")
//</editor-fold>
public static optInt HintThreshold/*J*/= new optInt($("inlinehint-threshold"), OptionHidden.Hidden, init(325), 
    new desc($("Threshold for inlining functions with inline hint")));

// We introduce this threshold to help performance of instrumentation based
// PGO before we actually hook up inliner with analysis passes such as BPI and
// BFI.
//<editor-fold defaultstate="collapsed" desc="ColdThreshold">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 65,
 FQN="ColdThreshold", NM="_ZL13ColdThreshold",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZL13ColdThreshold")
//</editor-fold>
public static optInt ColdThreshold/*J*/= new optInt($("inlinecold-threshold"), OptionHidden.Hidden, init(225), 
    new desc($("Threshold for inlining functions with cold attribute")));

/// \brief Test that two functions either have or have not the given attribute
///        at the same time.
/*template <typename AttrKind> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="attributeMatches">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 1434,
 FQN="attributeMatches", NM="Tpl__ZL16attributeMatchesPN4llvm8FunctionES1_T_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=Tpl__ZL16attributeMatchesPN4llvm8FunctionES1_T_")
//</editor-fold>
public static </*typename*/ AttrKind> boolean attributeMatches(Function /*P*/ F1, Function /*P*/ F2, AttrKind Attr) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Test that there are no attribute conflicts between Caller and Callee
///        that prevent inlining.
//<editor-fold defaultstate="collapsed" desc="functionsHaveCompatibleAttributes">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 1440,
 FQN="functionsHaveCompatibleAttributes", NM="_ZL33functionsHaveCompatibleAttributesPN4llvm8FunctionES1_RNS_19TargetTransformInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZL33functionsHaveCompatibleAttributesPN4llvm8FunctionES1_RNS_19TargetTransformInfoE")
//</editor-fold>
public static boolean functionsHaveCompatibleAttributes(Function /*P*/ Caller, 
                                 Function /*P*/ Callee, 
                                 final TargetTransformInfo /*&*/ TTI) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class InlineCostStatics
