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
package org.llvm.analysis.InlineConstants;

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


//<editor-fold defaultstate="collapsed" desc="static type InlineConstantsGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.InlineConstants.InlineConstantsGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm15InlineConstantsL11CallPenaltyE;_ZN4llvm15InlineConstantsL13ColdccPenaltyE;_ZN4llvm15InlineConstantsL15NoreturnPenaltyE;_ZN4llvm15InlineConstantsL21IndirectCallThresholdE;_ZN4llvm15InlineConstantsL21LastCallToStaticBonusE;_ZN4llvm15InlineConstantsL30TotalAllocaSizeRecursiveCallerE;_ZN4llvm15InlineConstantsL9InstrCostE; -static-type=InlineConstantsGlobals -package=org.llvm.analysis.InlineConstants")
//</editor-fold>
public final class InlineConstantsGlobals {

// Various magic constants used to adjust heuristics.
//<editor-fold defaultstate="collapsed" desc="llvm::InlineConstants::InstrCost">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 31,
 FQN="llvm::InlineConstants::InstrCost", NM="_ZN4llvm15InlineConstantsL9InstrCostE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm15InlineConstantsL9InstrCostE")
//</editor-fold>
public static /*const*/int InstrCost = 5;
//<editor-fold defaultstate="collapsed" desc="llvm::InlineConstants::IndirectCallThreshold">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 32,
 FQN="llvm::InlineConstants::IndirectCallThreshold", NM="_ZN4llvm15InlineConstantsL21IndirectCallThresholdE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm15InlineConstantsL21IndirectCallThresholdE")
//</editor-fold>
public static /*const*/int IndirectCallThreshold = 100;
//<editor-fold defaultstate="collapsed" desc="llvm::InlineConstants::CallPenalty">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 33,
 FQN="llvm::InlineConstants::CallPenalty", NM="_ZN4llvm15InlineConstantsL11CallPenaltyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm15InlineConstantsL11CallPenaltyE")
//</editor-fold>
public static /*const*/int CallPenalty = 25;
//<editor-fold defaultstate="collapsed" desc="llvm::InlineConstants::LastCallToStaticBonus">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 34,
 FQN="llvm::InlineConstants::LastCallToStaticBonus", NM="_ZN4llvm15InlineConstantsL21LastCallToStaticBonusE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm15InlineConstantsL21LastCallToStaticBonusE")
//</editor-fold>
public static /*const*/int LastCallToStaticBonus = -15000;
//<editor-fold defaultstate="collapsed" desc="llvm::InlineConstants::ColdccPenalty">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 35,
 FQN="llvm::InlineConstants::ColdccPenalty", NM="_ZN4llvm15InlineConstantsL13ColdccPenaltyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm15InlineConstantsL13ColdccPenaltyE")
//</editor-fold>
public static /*const*/int ColdccPenalty = 2000;
//<editor-fold defaultstate="collapsed" desc="llvm::InlineConstants::NoreturnPenalty">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 36,
 FQN="llvm::InlineConstants::NoreturnPenalty", NM="_ZN4llvm15InlineConstantsL15NoreturnPenaltyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm15InlineConstantsL15NoreturnPenaltyE")
//</editor-fold>
public static /*const*/int NoreturnPenalty = 10000;
/// Do not inline functions which allocate this many bytes on the stack
/// when the caller is recursive.
//<editor-fold defaultstate="collapsed" desc="llvm::InlineConstants::TotalAllocaSizeRecursiveCaller">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 39,
 FQN="llvm::InlineConstants::TotalAllocaSizeRecursiveCaller", NM="_ZN4llvm15InlineConstantsL30TotalAllocaSizeRecursiveCallerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm15InlineConstantsL30TotalAllocaSizeRecursiveCallerE")
//</editor-fold>
public static /*const*//*uint*/int TotalAllocaSizeRecursiveCaller = 1024;
} // END OF class InlineConstantsGlobals
