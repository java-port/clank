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


//<editor-fold defaultstate="collapsed" desc="static type EHPersonalitiesLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.EHPersonalitiesLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp -nm=_ZN4llvm15colorEHFuncletsERNS_8FunctionE;_ZN4llvm19isNoOpWithoutInvokeENS_13EHPersonalityE;_ZN4llvm21classifyEHPersonalityEPKNS_5ValueE;_ZN4llvm22isFuncletEHPersonalityENS_13EHPersonalityE;_ZN4llvm25canSimplifyInvokeNoUnwindEPKNS_8FunctionE;_ZN4llvm27isAsynchronousEHPersonalityENS_13EHPersonalityE; -static-type=EHPersonalitiesLlvmGlobals -package=org.llvm.analysis.impl")
//</editor-fold>
public final class EHPersonalitiesLlvmGlobals {


/// \brief See if the given exception handling personality function is one
/// that we understand.  If so, return a description of it; otherwise return
/// Unknown.

/// See if the given exception handling personality function is one that we
/// understand.  If so, return a description of it; otherwise return Unknown.
//<editor-fold defaultstate="collapsed" desc="llvm::classifyEHPersonality">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp", line = 22,
 FQN="llvm::classifyEHPersonality", NM="_ZN4llvm21classifyEHPersonalityEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp -nm=_ZN4llvm21classifyEHPersonalityEPKNS_5ValueE")
//</editor-fold>
public static EHPersonality classifyEHPersonality(/*const*/ Value /*P*/ Pers) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Returns true if this personality function catches asynchronous
/// exceptions.
//<editor-fold defaultstate="collapsed" desc="llvm::isAsynchronousEHPersonality">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/EHPersonalities.h", line = 44,
 FQN="llvm::isAsynchronousEHPersonality", NM="_ZN4llvm27isAsynchronousEHPersonalityENS_13EHPersonalityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp -nm=_ZN4llvm27isAsynchronousEHPersonalityENS_13EHPersonalityE")
//</editor-fold>
public static /*inline*/ boolean isAsynchronousEHPersonality(EHPersonality Pers) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Returns true if this is a personality function that invokes
/// handler funclets (which must return to it).
//<editor-fold defaultstate="collapsed" desc="llvm::isFuncletEHPersonality">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/EHPersonalities.h", line = 59,
 FQN="llvm::isFuncletEHPersonality", NM="_ZN4llvm22isFuncletEHPersonalityENS_13EHPersonalityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp -nm=_ZN4llvm22isFuncletEHPersonalityENS_13EHPersonalityE")
//</editor-fold>
public static /*inline*/ boolean isFuncletEHPersonality(EHPersonality Pers) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Return true if this personality may be safely removed if there
/// are no invoke instructions remaining in the current function.
//<editor-fold defaultstate="collapsed" desc="llvm::isNoOpWithoutInvoke">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/EHPersonalities.h", line = 74,
 FQN="llvm::isNoOpWithoutInvoke", NM="_ZN4llvm19isNoOpWithoutInvokeENS_13EHPersonalityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp -nm=_ZN4llvm19isNoOpWithoutInvokeENS_13EHPersonalityE")
//</editor-fold>
public static /*inline*/ boolean isNoOpWithoutInvoke(EHPersonality Pers) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::canSimplifyInvokeNoUnwind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp", line = 43,
 FQN="llvm::canSimplifyInvokeNoUnwind", NM="_ZN4llvm25canSimplifyInvokeNoUnwindEPKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp -nm=_ZN4llvm25canSimplifyInvokeNoUnwindEPKNS_8FunctionE")
//</editor-fold>
public static boolean canSimplifyInvokeNoUnwind(/*const*/ Function /*P*/ F) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief If an EH funclet personality is in use (see isFuncletEHPersonality),
/// this will recompute which blocks are in which funclet. It is possible that
/// some blocks are in multiple funclets. Consider this analysis to be
/// expensive.
//<editor-fold defaultstate="collapsed" desc="llvm::colorEHFunclets">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp", line = 51,
 FQN="llvm::colorEHFunclets", NM="_ZN4llvm15colorEHFuncletsERNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp -nm=_ZN4llvm15colorEHFuncletsERNS_8FunctionE")
//</editor-fold>
public static DenseMap<BasicBlock /*P*/ , TinyPtrVector<BasicBlock /*P*/ >> colorEHFunclets(final Function /*&*/ F) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class EHPersonalitiesLlvmGlobals
