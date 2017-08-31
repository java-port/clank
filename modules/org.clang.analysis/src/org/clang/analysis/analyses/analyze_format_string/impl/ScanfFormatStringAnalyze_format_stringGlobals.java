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
package org.clang.analysis.analyses.analyze_format_string.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.clang.basic.*;
import org.clang.analysis.analyses.analyze_format_string.*;
import org.clang.analysis.analyses.analyze_scanf.ScanfSpecifier;
import org.clang.analysis.analyze_format_string.impl.SpecifierResult;
import static org.clang.analysis.impl.ScanfFormatStringStatics.ParseScanfSpecifier;
import org.clang.basic.target.TargetInfo;


//<editor-fold defaultstate="collapsed" desc="static type ScanfFormatStringAnalyze_format_stringGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang21analyze_format_string16ParseScanfStringERNS0_19FormatStringHandlerEPKcS4_RKNS_11LangOptionsERKNS_10TargetInfoE; -static-type=ScanfFormatStringAnalyze_format_stringGlobals -package=org.clang.analysis.analyses.analyze_format_string.impl")
//</editor-fold>
public final class ScanfFormatStringAnalyze_format_stringGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ParseScanfString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp", line = 530,
 FQN="clang::analyze_format_string::ParseScanfString", NM="_ZN5clang21analyze_format_string16ParseScanfStringERNS0_19FormatStringHandlerEPKcS4_RKNS_11LangOptionsERKNS_10TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang21analyze_format_string16ParseScanfStringERNS0_19FormatStringHandlerEPKcS4_RKNS_11LangOptionsERKNS_10TargetInfoE")
//</editor-fold>
public static boolean ParseScanfString(final FormatStringHandler /*&*/ H, 
                /*const*/char$ptr/*char P*/ I, 
                /*const*/char$ptr/*char P*/ E, 
                final /*const*/ LangOptions /*&*/ LO, 
                final /*const*/ TargetInfo /*&*/ Target) {
  
  uint$ref argIndex = create_uint$ref(0);
  
  // Keep looking for a format specifier until we have exhausted the string.
  while ($noteq_ptr(I, E)) {
    final /*const*/ SpecifierResult<ScanfSpecifier> /*&*/ FSR = ParseScanfSpecifier(H, I, E, argIndex, 
        LO, Target);
    // Did a fail-stop error of any kind occur when parsing the specifier?
    // If so, don't do any more processing.
    if (FSR.shouldStop()) {
      return true;
    }
    // Did we exhaust the string or encounter an error that
    // we can recover from?
    if (!FSR.hasValue()) {
      continue;
    }
    // We have a format specifier.  Pass it to the callback.
    if (!H.HandleScanfSpecifier(FSR.getValue$Const(), FSR.getStart(), 
        I.$sub(FSR.getStart()))) {
      return true;
    }
  }
  assert ($eq_ptr(I, E)) : "Format string not exhausted";
  return false;
}

} // END OF class ScanfFormatStringAnalyze_format_stringGlobals
