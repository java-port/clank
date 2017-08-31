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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.mc.MCLOHType;


//<editor-fold defaultstate="collapsed" desc="static type MCLinkerOptimizationHintLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.mc.impl.MCLinkerOptimizationHintLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZN4llvmL13MCLOHIdToNameENS_9MCLOHTypeE;_ZN4llvmL13MCLOHNameToIdENS_9StringRefE;_ZN4llvmL15MCLOHIdToNbArgsENS_9MCLOHTypeE;_ZN4llvmL16isValidMCLOHTypeEj;_ZN4llvmL18MCLOHDirectiveNameEv; -static-type=MCLinkerOptimizationHintLlvmGlobals -package=org.llvm.mc.impl")
//</editor-fold>
public final class MCLinkerOptimizationHintLlvmGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::MCLOHDirectiveName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 44,
 FQN="llvm::MCLOHDirectiveName", NM="_ZN4llvmL18MCLOHDirectiveNameEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZN4llvmL18MCLOHDirectiveNameEv")
//</editor-fold>
public static /*inline*/ StringRef MCLOHDirectiveName() {
  return new StringRef(/*KEEP_STR*/".loh");
}

//<editor-fold defaultstate="collapsed" desc="llvm::isValidMCLOHType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 48,
 FQN="llvm::isValidMCLOHType", NM="_ZN4llvmL16isValidMCLOHTypeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZN4llvmL16isValidMCLOHTypeEj")
//</editor-fold>
public static /*inline*/ boolean isValidMCLOHType(/*uint*/int Kind) {
  return $greatereq_uint(Kind, MCLOHType.MCLOH_AdrpAdrp) && $lesseq_uint(Kind, MCLOHType.MCLOH_AdrpLdrGot);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MCLOHNameToId">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 52,
 FQN="llvm::MCLOHNameToId", NM="_ZN4llvmL13MCLOHNameToIdENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZN4llvmL13MCLOHNameToIdENS_9StringRefE")
//</editor-fold>
public static /*inline*/ int MCLOHNameToId(StringRef Name) {
  return new StringSwitchInt(/*NO_COPY*/Name).
      Case(/*KEEP_STR*/"AdrpAdrp", MCLOHType.MCLOH_AdrpAdrp).
      Case(/*KEEP_STR*/"AdrpLdr", MCLOHType.MCLOH_AdrpLdr).
      Case(/*KEEP_STR*/"AdrpAddLdr", MCLOHType.MCLOH_AdrpAddLdr).
      Case(/*KEEP_STR*/"AdrpLdrGotLdr", MCLOHType.MCLOH_AdrpLdrGotLdr).
      Case(/*KEEP_STR*/"AdrpAddStr", MCLOHType.MCLOH_AdrpAddStr).
      Case(/*KEEP_STR*/"AdrpLdrGotStr", MCLOHType.MCLOH_AdrpLdrGotStr).
      Case(/*KEEP_STR*/"AdrpAdd", MCLOHType.MCLOH_AdrpAdd).
      Case(/*KEEP_STR*/"AdrpLdrGot", MCLOHType.MCLOH_AdrpLdrGot).
      Default(-1);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MCLOHIdToName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 66,
 FQN="llvm::MCLOHIdToName", NM="_ZN4llvmL13MCLOHIdToNameENS_9MCLOHTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZN4llvmL13MCLOHIdToNameENS_9MCLOHTypeE")
//</editor-fold>
public static /*inline*/ StringRef MCLOHIdToName(/*MCLOHType*//*uint*/int Kind) {
  switch (Kind) {
   case MCLOHType.MCLOH_AdrpAdrp:
    return new StringRef(/*KEEP_STR*/"AdrpAdrp");
   case MCLOHType.MCLOH_AdrpLdr:
    return new StringRef(/*KEEP_STR*/"AdrpLdr");
   case MCLOHType.MCLOH_AdrpAddLdr:
    return new StringRef(/*KEEP_STR*/"AdrpAddLdr");
   case MCLOHType.MCLOH_AdrpLdrGotLdr:
    return new StringRef(/*KEEP_STR*/"AdrpLdrGotLdr");
   case MCLOHType.MCLOH_AdrpAddStr:
    return new StringRef(/*KEEP_STR*/"AdrpAddStr");
   case MCLOHType.MCLOH_AdrpLdrGotStr:
    return new StringRef(/*KEEP_STR*/"AdrpLdrGotStr");
   case MCLOHType.MCLOH_AdrpAdd:
    return new StringRef(/*KEEP_STR*/"AdrpAdd");
   case MCLOHType.MCLOH_AdrpLdrGot:
    return new StringRef(/*KEEP_STR*/"AdrpLdrGot");
  }
  return new StringRef();
}

//<editor-fold defaultstate="collapsed" desc="llvm::MCLOHIdToNbArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 81,
 FQN="llvm::MCLOHIdToNbArgs", NM="_ZN4llvmL15MCLOHIdToNbArgsENS_9MCLOHTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZN4llvmL15MCLOHIdToNbArgsENS_9MCLOHTypeE")
//</editor-fold>
public static /*inline*/ int MCLOHIdToNbArgs(/*MCLOHType*//*uint*/int Kind) {
  switch (Kind) {
   case MCLOHType.MCLOH_AdrpAdrp:
   case MCLOHType.MCLOH_AdrpLdr:
   case MCLOHType.MCLOH_AdrpAdd:
   case MCLOHType.MCLOH_AdrpLdrGot:
    // LOH with two arguments
    return 2;
   case MCLOHType.MCLOH_AdrpAddLdr:
   case MCLOHType.MCLOH_AdrpLdrGotLdr:
   case MCLOHType.MCLOH_AdrpAddStr:
   case MCLOHType.MCLOH_AdrpLdrGotStr:
    // LOH with three arguments
    return 3;
  }
  return -1;
}

} // END OF class MCLinkerOptimizationHintLlvmGlobals
