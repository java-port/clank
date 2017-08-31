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

package org.clang.basic;

import org.clank.support.*;
import org.clang.basic.*;


/// \brief Specifies the kind of type.
//<editor-fold defaultstate="collapsed" desc="clang::TypeSpecifierType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", line = 45,
 FQN="clang::TypeSpecifierType", NM="_ZN5clang17TypeSpecifierTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clang17TypeSpecifierTypeE")
//</editor-fold>
public enum TypeSpecifierType implements Native.ComparableLower {
  TST_unspecified(0),
  TST_void(TST_unspecified.getValue() + 1),
  TST_char(TST_void.getValue() + 1),
  TST_wchar(TST_char.getValue() + 1), // C++ wchar_t
  TST_char16(TST_wchar.getValue() + 1), // C++11 char16_t
  TST_char32(TST_char16.getValue() + 1), // C++11 char32_t
  TST_int(TST_char32.getValue() + 1),
  TST_int128(TST_int.getValue() + 1),
  TST_half(TST_int128.getValue() + 1), // OpenCL half, ARM NEON __fp16
  TST_float(TST_half.getValue() + 1),
  TST_double(TST_float.getValue() + 1),
  TST_float128(TST_double.getValue() + 1),
  TST_bool(TST_float128.getValue() + 1), // _Bool
  TST_decimal32(TST_bool.getValue() + 1), // _Decimal32
  TST_decimal64(TST_decimal32.getValue() + 1), // _Decimal64
  TST_decimal128(TST_decimal64.getValue() + 1), // _Decimal128
  TST_enum(TST_decimal128.getValue() + 1),
  TST_union(TST_enum.getValue() + 1),
  TST_struct(TST_union.getValue() + 1),
  TST_class(TST_struct.getValue() + 1), // C++ class type
  TST_interface(TST_class.getValue() + 1), // C++ (Microsoft-specific) __interface type
  TST_typename(TST_interface.getValue() + 1), // Typedef, C++ class-name or enum name, etc.
  TST_typeofType(TST_typename.getValue() + 1),
  TST_typeofExpr(TST_typeofType.getValue() + 1),
  TST_decltype(TST_typeofExpr.getValue() + 1), // C++11 decltype
  TST_underlyingType(TST_decltype.getValue() + 1), // __underlying_type for C++11
  TST_auto(TST_underlyingType.getValue() + 1), // C++11 auto
  TST_decltype_auto(TST_auto.getValue() + 1), // C++1y decltype(auto)
  TST_auto_type(TST_decltype_auto.getValue() + 1), // __auto_type extension
  TST_unknown_anytype(TST_auto_type.getValue() + 1), // __unknown_anytype extension
  TST_atomic(TST_unknown_anytype.getValue() + 1), // C11 _Atomic
  TST_image1d_t(TST_atomic.getValue() + 1),
  TST_image1d_array_t(TST_image1d_t.getValue() + 1),
  TST_image1d_buffer_t(TST_image1d_array_t.getValue() + 1),
  TST_image2d_t(TST_image1d_buffer_t.getValue() + 1),
  TST_image2d_array_t(TST_image2d_t.getValue() + 1),
  TST_image2d_depth_t(TST_image2d_array_t.getValue() + 1),
  TST_image2d_array_depth_t(TST_image2d_depth_t.getValue() + 1),
  TST_image2d_msaa_t(TST_image2d_array_depth_t.getValue() + 1),
  TST_image2d_array_msaa_t(TST_image2d_msaa_t.getValue() + 1),
  TST_image2d_msaa_depth_t(TST_image2d_array_msaa_t.getValue() + 1),
  TST_image2d_array_msaa_depth_t(TST_image2d_msaa_depth_t.getValue() + 1),
  TST_image3d_t(TST_image2d_array_msaa_depth_t.getValue() + 1),
  TST_error(TST_image3d_t.getValue() + 1); // erroneous type

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static TypeSpecifierType valueOf(int val) {
    TypeSpecifierType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final TypeSpecifierType[] VALUES;
    private static final TypeSpecifierType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (TypeSpecifierType kind : TypeSpecifierType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new TypeSpecifierType[min < 0 ? (1-min) : 0];
      VALUES = new TypeSpecifierType[max >= 0 ? (1+max) : 0];
      for (TypeSpecifierType kind : TypeSpecifierType.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private TypeSpecifierType(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TypeSpecifierType)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TypeSpecifierType)obj).value);}
  //</editor-fold>
}
