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
package org.llvm.mc.impl;

import org.clank.support.*;
import static org.clank.java.std.*;
import org.llvm.mc.MCTargetOptions;


//<editor-fold defaultstate="collapsed" desc="static type MCTargetOptionsLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.mc.impl.MCTargetOptionsLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCTargetOptions.cpp -nm=_ZN4llvmeqERKNS_15MCTargetOptionsES2_;_ZN4llvmneERKNS_15MCTargetOptionsES2_; -static-type=MCTargetOptionsLlvmGlobals -package=org.llvm.mc.impl")
//</editor-fold>
public final class MCTargetOptionsLlvmGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCTargetOptions.h", line = 52,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCTargetOptions.h", old_line = 48,
 FQN="llvm::operator==", NM="_ZN4llvmeqERKNS_15MCTargetOptionsES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCTargetOptions.cpp -nm=_ZN4llvmeqERKNS_15MCTargetOptionsES2_")
//</editor-fold>
public static /*inline*/ boolean $eq_MCTargetOptions$C(final /*const*/ MCTargetOptions /*&*/ LHS, final /*const*/ MCTargetOptions /*&*/ RHS) {
  return (LHS.SanitizeAddress == RHS.SanitizeAddress
     && LHS.MCRelaxAll == RHS.MCRelaxAll
     && LHS.MCNoExecStack == RHS.MCNoExecStack
     && LHS.MCFatalWarnings == RHS.MCFatalWarnings
     && LHS.MCNoWarn == RHS.MCNoWarn
     && LHS.MCSaveTempLabels == RHS.MCSaveTempLabels
     && LHS.MCUseDwarfDirectory == RHS.MCUseDwarfDirectory
     && LHS.MCIncrementalLinkerCompatible == RHS.MCIncrementalLinkerCompatible
     && LHS.ShowMCEncoding == RHS.ShowMCEncoding
     && LHS.ShowMCInst == RHS.ShowMCInst
     && LHS.AsmVerbose == RHS.AsmVerbose
     && LHS.DwarfVersion == RHS.DwarfVersion
     && $eq_str$C(LHS.ABIName, RHS.ABIName));
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCTargetOptions.h", line = 70,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCTargetOptions.h", old_line = 66,
 FQN="llvm::operator!=", NM="_ZN4llvmneERKNS_15MCTargetOptionsES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCTargetOptions.cpp -nm=_ZN4llvmneERKNS_15MCTargetOptionsES2_")
//</editor-fold>
public static /*inline*/ boolean $noteq_MCTargetOptions$C(final /*const*/ MCTargetOptions /*&*/ LHS, final /*const*/ MCTargetOptions /*&*/ RHS) {
  return !($eq_MCTargetOptions$C(LHS, RHS));
}

} // END OF class MCTargetOptionsLlvmGlobals
