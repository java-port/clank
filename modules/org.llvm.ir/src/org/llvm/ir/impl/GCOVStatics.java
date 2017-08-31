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
package org.llvm.ir.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.support.sys.path;


//<editor-fold defaultstate="collapsed" desc="static type GCOVStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.GCOVStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/GCOV.cpp -nm=_ZL18mangleCoveragePathB5cxx11N4llvm9StringRefEb;_ZL7safeDivyy;_ZL9branchDivyy;_ZN12_GLOBAL__N_1lsERN4llvm11raw_ostreamERKNS_16formatBranchInfoE; -static-type=GCOVStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class GCOVStatics {


//===----------------------------------------------------------------------===//
// FileInfo implementation.

// Safe integer division, returns 0 if numerator is 0.
//<editor-fold defaultstate="collapsed" desc="safeDiv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/GCOV.cpp", line = 431,
 FQN="safeDiv", NM="_ZL7safeDivyy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/GCOV.cpp -nm=_ZL7safeDivyy")
//</editor-fold>
public static /*uint32_t*/int safeDiv(long/*uint64_t*/ Numerator, long/*uint64_t*/ Divisor) {
  if (!(Numerator != 0)) {
    return 0;
  }
  return $ullong2uint($div_ulong(Numerator, Divisor));
}


// This custom division function mimics gcov's branch ouputs:
//   - Round to closest whole number
//   - Only output 0% or 100% if it's exactly that value
//<editor-fold defaultstate="collapsed" desc="branchDiv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/GCOV.cpp", line = 440,
 FQN="branchDiv", NM="_ZL9branchDivyy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/GCOV.cpp -nm=_ZL9branchDivyy")
//</editor-fold>
public static /*uint32_t*/int branchDiv(long/*uint64_t*/ Numerator, long/*uint64_t*/ Divisor) {
  if (!(Numerator != 0)) {
    return 0;
  }
  if (Numerator == Divisor) {
    return 100;
  }
  
  byte/*uint8_t*/ Res = $ullong2uchar($div_ullong_ulong((Numerator * $int2ullong(100) + $div_ulong_ullong(Divisor, $int2ullong(2))), Divisor));
  if ($uchar2int(Res) == 0) {
    return 1;
  }
  if ($uchar2int(Res) == 100) {
    return 99;
  }
  return $uchar2uint(Res);
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/GCOV.cpp", line = 473,
 FQN="(anonymous namespace)::operator<<", NM="_ZN12_GLOBAL__N_1lsERN4llvm11raw_ostreamERKNS_16formatBranchInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/GCOV.cpp -nm=_ZN12_GLOBAL__N_1lsERN4llvm11raw_ostreamERKNS_16formatBranchInfoE")
//</editor-fold>
public static raw_ostream /*&*/ $out_raw_ostream_formatBranchInfo$C(final raw_ostream /*&*/ OS, final /*const*/ formatBranchInfo /*&*/ FBI) {
  FBI.print(OS);
  return OS;
}

// end anonymous namespace

/// Convert a path to a gcov filename. If PreservePaths is true, this
/// translates "/" to "#", ".." to "^", and drops ".", to match gcov.
//<editor-fold defaultstate="collapsed" desc="mangleCoveragePath">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/GCOV.cpp", line = 508,
 FQN="mangleCoveragePath", NM="_ZL18mangleCoveragePathN4llvm9StringRefEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/GCOV.cpp -nm=_ZL18mangleCoveragePathN4llvm9StringRefEb")
//</editor-fold>
public static std.string mangleCoveragePath(StringRef Filename, boolean PreservePaths) {
  if (!PreservePaths) {
    return path.filename(/*NO_COPY*/Filename).str();
  }
  
  // This behaviour is defined by gcov in terms of text replacements, so it's
  // not likely to do anything useful on filesystems with different textual
  // conventions.
  SmallString/*<256>*/ Result/*J*/= new SmallString/*<256>*/(256, new StringRef(/*KEEP_STR*/$EMPTY));
  char$ptr I;
  char$ptr S;
  char$ptr E;
  for (I = $tryClone(S = $tryClone(Filename.begin())) , E = $tryClone(Filename.end()); $noteq_ptr(I, E); I.$preInc()) {
    if (I.$star() != $$SLASH) {
      continue;
    }
    final int $distance = I.$sub(S);
    if ($distance == 1 && S.$star() == $$DOT) {
      // ".", the current directory, is skipped.
    } else if ($distance == 2 && S.$star() == $$DOT && (S.$add(1)).$star() == $$DOT) {
      // "..", the parent directory, is replaced with "^".
      Result.append(new StringRef(/*KEEP_STR*/"^#"));
    } else {
      if (S.$less(I)) {
        // Leave other components intact,
        Result.append$T(S, /*I*/$distance);
      }
      // And separate with "#".
      Result.push_back($$HASH);
    }
    S = $tryClone(I.$add(1));
  }
  if (S.$less(I)) {
    Result.append$T(S, I);
  }
  return Result.str().$string();
}

} // END OF class GCOVStatics
