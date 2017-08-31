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
package org.clang.codegen.impl;

import org.clank.support.*;
import static org.clank.java.io.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.cl.NumOccurrencesFlag;
import org.llvm.cl.ClGlobals;
import org.llvm.cl.desc;
import org.llvm.cl.aliases.optBool;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenPGOStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZL17scaleBranchWeightyy;_ZL20EnableValueProfiling;_ZL20calculateWeightScaley; -static-type=CodeGenPGOStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CodeGenPGOStatics {

//<editor-fold defaultstate="collapsed" desc="EnableValueProfiling">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 25,
 FQN="EnableValueProfiling", NM="_ZL20EnableValueProfiling",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZL20EnableValueProfiling")
//</editor-fold>
public static optBool EnableValueProfiling/*J*/= new optBool($("enable-value-profiling"), NumOccurrencesFlag.ZeroOrMore, 
    new desc($("Enable value profiling")), ClGlobals.init(false));

/// \brief Calculate what to divide by to scale weights.
///
/// Given the maximum weight, calculate a divisor that will scale all the
/// weights to strictly less than UINT32_MAX.
//<editor-fold defaultstate="collapsed" desc="calculateWeightScale">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 827,
 FQN="calculateWeightScale", NM="_ZL20calculateWeightScaley",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZL20calculateWeightScaley")
//</editor-fold>
public static long/*uint64_t*/ calculateWeightScale(long/*uint64_t*/ MaxWeight) {
  return $less_ulong_uint(MaxWeight, UINT32_MAX) ? $int2ullong(1) : $div_ulong_uint(MaxWeight, UINT32_MAX) + $int2ullong(1);
}


/// \brief Scale an individual branch weight (and add 1).
///
/// Scale a 64-bit weight down to 32-bits using \c Scale.
///
/// According to Laplace's Rule of Succession, it is better to compute the
/// weight based on the count plus 1, so universally add 1 to the value.
///
/// \pre \c Scale was calculated by \a calculateWeightScale() with a weight no
/// greater than \c Weight.
//<editor-fold defaultstate="collapsed" desc="scaleBranchWeight">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 840,
 FQN="scaleBranchWeight", NM="_ZL17scaleBranchWeightyy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZL17scaleBranchWeightyy")
//</editor-fold>
public static /*uint32_t*/int scaleBranchWeight(long/*uint64_t*/ Weight, long/*uint64_t*/ Scale) {
  assert ((Scale != 0)) : "scale by 0?";
  long/*uint64_t*/ Scaled = $div_ulong(Weight, Scale) + $int2ullong(1);
  assert ($lesseq_ulong_ullong(Scaled, (4294967295L/*U*/))) : "overflow 32-bits";
  return $ulong2uint(Scaled);
}

} // END OF class CodeGenPGOStatics
