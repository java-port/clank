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

package org.clang.sema;

import org.clank.support.*;


/// ImplicitConversionKind - The kind of implicit conversion used to
/// convert an argument to a parameter's type. The enumerator values
/// match with Table 9 of (C++ 13.3.3.1.1) and are listed such that
/// better conversion kinds have smaller values.
//<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 60,
 FQN="clang::ImplicitConversionKind", NM="_ZN5clang22ImplicitConversionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang22ImplicitConversionKindE")
//</editor-fold>
public enum ImplicitConversionKind implements Native.ComparableLower, Native.NativeUIntEnum {
  ICK_Identity(0), ///< Identity conversion (no conversion)
  ICK_Lvalue_To_Rvalue(ICK_Identity.getValue() + 1), ///< Lvalue-to-rvalue conversion (C++ 4.1)
  ICK_Array_To_Pointer(ICK_Lvalue_To_Rvalue.getValue() + 1), ///< Array-to-pointer conversion (C++ 4.2)
  ICK_Function_To_Pointer(ICK_Array_To_Pointer.getValue() + 1), ///< Function-to-pointer (C++ 4.3)
  ICK_NoReturn_Adjustment(ICK_Function_To_Pointer.getValue() + 1), ///< Removal of noreturn from a type (Clang)
  ICK_Qualification(ICK_NoReturn_Adjustment.getValue() + 1), ///< Qualification conversions (C++ 4.4)
  ICK_Integral_Promotion(ICK_Qualification.getValue() + 1), ///< Integral promotions (C++ 4.5)
  ICK_Floating_Promotion(ICK_Integral_Promotion.getValue() + 1), ///< Floating point promotions (C++ 4.6)
  ICK_Complex_Promotion(ICK_Floating_Promotion.getValue() + 1), ///< Complex promotions (Clang extension)
  ICK_Integral_Conversion(ICK_Complex_Promotion.getValue() + 1), ///< Integral conversions (C++ 4.7)
  ICK_Floating_Conversion(ICK_Integral_Conversion.getValue() + 1), ///< Floating point conversions (C++ 4.8)
  ICK_Complex_Conversion(ICK_Floating_Conversion.getValue() + 1), ///< Complex conversions (C99 6.3.1.6)
  ICK_Floating_Integral(ICK_Complex_Conversion.getValue() + 1), ///< Floating-integral conversions (C++ 4.9)
  ICK_Pointer_Conversion(ICK_Floating_Integral.getValue() + 1), ///< Pointer conversions (C++ 4.10)
  ICK_Pointer_Member(ICK_Pointer_Conversion.getValue() + 1), ///< Pointer-to-member conversions (C++ 4.11)
  ICK_Boolean_Conversion(ICK_Pointer_Member.getValue() + 1), ///< Boolean conversions (C++ 4.12)
  ICK_Compatible_Conversion(ICK_Boolean_Conversion.getValue() + 1), ///< Conversions between compatible types in C99
  ICK_Derived_To_Base(ICK_Compatible_Conversion.getValue() + 1), ///< Derived-to-base (C++ [over.best.ics])
  ICK_Vector_Conversion(ICK_Derived_To_Base.getValue() + 1), ///< Vector conversions
  ICK_Vector_Splat(ICK_Vector_Conversion.getValue() + 1), ///< A vector splat from an arithmetic type
  ICK_Complex_Real(ICK_Vector_Splat.getValue() + 1), ///< Complex-real conversions (C99 6.3.1.7)
  ICK_Block_Pointer_Conversion(ICK_Complex_Real.getValue() + 1), ///< Block Pointer conversions 
  ICK_TransparentUnionConversion(ICK_Block_Pointer_Conversion.getValue() + 1), ///< Transparent Union Conversions
  ICK_Writeback_Conversion(ICK_TransparentUnionConversion.getValue() + 1), ///< Objective-C ARC writeback conversion
  ICK_Zero_Event_Conversion(ICK_Writeback_Conversion.getValue() + 1), ///< Zero constant to event (OpenCL1.2 6.12.10)
  ICK_C_Only_Conversion(ICK_Zero_Event_Conversion.getValue() + 1), ///< Conversions allowed in C, but not C++
  ICK_Num_Conversion_Kinds(ICK_C_Only_Conversion.getValue() + 1); ///< The number of conversion kinds

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ImplicitConversionKind valueOf(int val) {
    ImplicitConversionKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ImplicitConversionKind[] VALUES;
    private static final ImplicitConversionKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ImplicitConversionKind kind : ImplicitConversionKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ImplicitConversionKind[min < 0 ? (1-min) : 0];
      VALUES = new ImplicitConversionKind[max >= 0 ? (1+max) : 0];
      for (ImplicitConversionKind kind : ImplicitConversionKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private ImplicitConversionKind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ImplicitConversionKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ImplicitConversionKind)obj).value);}
  //</editor-fold>
}
