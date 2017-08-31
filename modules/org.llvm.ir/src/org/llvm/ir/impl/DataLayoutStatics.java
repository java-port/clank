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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.ir.*;


//<editor-fold defaultstate="collapsed" desc="static type DataLayoutStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZL17DefaultAlignments;_ZL5splitN4llvm9StringRefEc;_ZL6getIntN4llvm9StringRefE;_ZL7inBytesj; -static-type=DataLayoutStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class DataLayoutStatics {

//<editor-fold defaultstate="collapsed" desc="DefaultAlignments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 163,
 FQN="DefaultAlignments", NM="_ZL17DefaultAlignments",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZL17DefaultAlignments")
//</editor-fold>
public static /*const*/ LayoutAlignElem DefaultAlignments[/*12*/] = new /*const*/ LayoutAlignElem [/*12*/] {
  new LayoutAlignElem(AlignTypeEnum.INTEGER_ALIGN, 1, 1, 1),  // i1
  new LayoutAlignElem(AlignTypeEnum.INTEGER_ALIGN, 8, 1, 1),  // i8
  new LayoutAlignElem(AlignTypeEnum.INTEGER_ALIGN, 16, 2, 2),  // i16
  new LayoutAlignElem(AlignTypeEnum.INTEGER_ALIGN, 32, 4, 4),  // i32
  new LayoutAlignElem(AlignTypeEnum.INTEGER_ALIGN, 64, 4, 8),  // i64
  new LayoutAlignElem(AlignTypeEnum.FLOAT_ALIGN, 16, 2, 2),  // half
  new LayoutAlignElem(AlignTypeEnum.FLOAT_ALIGN, 32, 4, 4),  // float
  new LayoutAlignElem(AlignTypeEnum.FLOAT_ALIGN, 64, 8, 8),  // double
  new LayoutAlignElem(AlignTypeEnum.FLOAT_ALIGN, 128, 16, 16),  // ppcf128, quad, ...
  new LayoutAlignElem(AlignTypeEnum.VECTOR_ALIGN, 64, 8, 8),  // v2i32, v1i64, ...
  new LayoutAlignElem(AlignTypeEnum.VECTOR_ALIGN, 128, 16, 16),  // v16i8, v8i16, v4i32, ...
  new LayoutAlignElem(AlignTypeEnum.AGGREGATE_ALIGN, 0, 0, 8) // struct
};

/// Checked version of split, to ensure mandatory subparts.
//<editor-fold defaultstate="collapsed" desc="split">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 197,
 FQN="split", NM="_ZL5splitN4llvm9StringRefEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZL5splitN4llvm9StringRefEc")
//</editor-fold>
public static std.pair<StringRef, StringRef> split(StringRef Str, /*char*/byte Separator) {
  assert (!Str.empty()) : "parse error, string can't be empty here";
  std.pair<StringRef, StringRef> Split = Str.split(Separator);
  if (Split.second.empty() && $noteq_StringRef(/*NO_COPY*/Split.first, /*NO_COPY*/Str)) {
    report_fatal_error($("Trailing separator in datalayout string"));
  }
  if (!Split.second.empty() && Split.first.empty()) {
    report_fatal_error($("Expected token before separator in datalayout string"));
  }
  return Split;
}


/// Get an unsigned integer, including error checks.
//<editor-fold defaultstate="collapsed" desc="getInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 208,
 FQN="getInt", NM="_ZL6getIntN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZL6getIntN4llvm9StringRefE")
//</editor-fold>
public static /*uint*/int getInt(StringRef R) {
  uint$ref Result = create_uint$ref();
  boolean error = R.getAsInteger$NotSigned(10, Result);
  ///*J:(void)*/error;
  if (error) {
    report_fatal_error($("not a number, or does not fit in an unsigned int"));
  }
  return Result.$deref();
}


/// Convert bits into bytes. Assert if not a byte width multiple.
//<editor-fold defaultstate="collapsed" desc="inBytes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp", line = 217,
 FQN="inBytes", NM="_ZL7inBytesj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DataLayout.cpp -nm=_ZL7inBytesj")
//</editor-fold>
public static /*uint*/int inBytes(/*uint*/int Bits) {
  if ((($rem_uint(Bits, 8)) != 0)) {
    report_fatal_error($("number of bits must be a byte width multiple"));
  }
  return $div_uint(Bits, 8);
}

} // END OF class DataLayoutStatics
