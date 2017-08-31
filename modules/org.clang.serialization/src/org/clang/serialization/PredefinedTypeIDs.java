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

package org.clang.serialization;

import org.clank.support.*;


/// \defgroup ASTAST AST file AST constants
///
/// The constants in this group describe various components of the
/// abstract syntax tree within an AST file.
///
/// @{

/// \brief Predefined type IDs.
///
/// These type IDs correspond to predefined types in the AST
/// context, such as built-in types (int) and special place-holder
/// types (the \<overload> and \<dependent> type markers). Such
/// types are never actually serialized, since they will be built
/// by the AST context when it is created.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::PredefinedTypeIDs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 708,
 FQN="clang::serialization::PredefinedTypeIDs", NM="_ZN5clang13serialization17PredefinedTypeIDsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serialization17PredefinedTypeIDsE")
//</editor-fold>
public final class/*enum*/ PredefinedTypeIDs {
  /// \brief The NULL type.
  public static final int PREDEF_TYPE_NULL_ID = 0;
  /// \brief The void type.
  public static final int PREDEF_TYPE_VOID_ID = 1;
  /// \brief The 'bool' or '_Bool' type.
  public static final int PREDEF_TYPE_BOOL_ID = 2;
  /// \brief The 'char' type, when it is unsigned.
  public static final int PREDEF_TYPE_CHAR_U_ID = 3;
  /// \brief The 'unsigned char' type.
  public static final int PREDEF_TYPE_UCHAR_ID = 4;
  /// \brief The 'unsigned short' type.
  public static final int PREDEF_TYPE_USHORT_ID = 5;
  /// \brief The 'unsigned int' type.
  public static final int PREDEF_TYPE_UINT_ID = 6;
  /// \brief The 'unsigned long' type.
  public static final int PREDEF_TYPE_ULONG_ID = 7;
  /// \brief The 'unsigned long long' type.
  public static final int PREDEF_TYPE_ULONGLONG_ID = 8;
  /// \brief The 'char' type, when it is signed.
  public static final int PREDEF_TYPE_CHAR_S_ID = 9;
  /// \brief The 'signed char' type.
  public static final int PREDEF_TYPE_SCHAR_ID = 10;
  /// \brief The C++ 'wchar_t' type.
  public static final int PREDEF_TYPE_WCHAR_ID = 11;
  /// \brief The (signed) 'short' type.
  public static final int PREDEF_TYPE_SHORT_ID = 12;
  /// \brief The (signed) 'int' type.
  public static final int PREDEF_TYPE_INT_ID = 13;
  /// \brief The (signed) 'long' type.
  public static final int PREDEF_TYPE_LONG_ID = 14;
  /// \brief The (signed) 'long long' type.
  public static final int PREDEF_TYPE_LONGLONG_ID = 15;
  /// \brief The 'float' type.
  public static final int PREDEF_TYPE_FLOAT_ID = 16;
  /// \brief The 'double' type.
  public static final int PREDEF_TYPE_DOUBLE_ID = 17;
  /// \brief The 'long double' type.
  public static final int PREDEF_TYPE_LONGDOUBLE_ID = 18;
  /// \brief The placeholder type for overloaded function sets.
  public static final int PREDEF_TYPE_OVERLOAD_ID = 19;
  /// \brief The placeholder type for dependent types.
  public static final int PREDEF_TYPE_DEPENDENT_ID = 20;
  /// \brief The '__uint128_t' type.
  public static final int PREDEF_TYPE_UINT128_ID = 21;
  /// \brief The '__int128_t' type.
  public static final int PREDEF_TYPE_INT128_ID = 22;
  /// \brief The type of 'nullptr'.
  public static final int PREDEF_TYPE_NULLPTR_ID = 23;
  /// \brief The C++ 'char16_t' type.
  public static final int PREDEF_TYPE_CHAR16_ID = 24;
  /// \brief The C++ 'char32_t' type.
  public static final int PREDEF_TYPE_CHAR32_ID = 25;
  /// \brief The ObjC 'id' type.
  public static final int PREDEF_TYPE_OBJC_ID = 26;
  /// \brief The ObjC 'Class' type.
  public static final int PREDEF_TYPE_OBJC_CLASS = 27;
  /// \brief The ObjC 'SEL' type.
  public static final int PREDEF_TYPE_OBJC_SEL = 28;
  /// \brief The 'unknown any' placeholder type.
  public static final int PREDEF_TYPE_UNKNOWN_ANY = 29;
  /// \brief The placeholder type for bound member functions.
  public static final int PREDEF_TYPE_BOUND_MEMBER = 30;
  /// \brief The "auto" deduction type.
  public static final int PREDEF_TYPE_AUTO_DEDUCT = 31;
  /// \brief The "auto &&" deduction type.
  public static final int PREDEF_TYPE_AUTO_RREF_DEDUCT = 32;
  /// \brief The OpenCL 'half' / ARM NEON __fp16 type.
  public static final int PREDEF_TYPE_HALF_ID = 33;
  /// \brief ARC's unbridged-cast placeholder type.
  public static final int PREDEF_TYPE_ARC_UNBRIDGED_CAST = 34;
  /// \brief The pseudo-object placeholder type.
  public static final int PREDEF_TYPE_PSEUDO_OBJECT = 35;
  /// \brief The placeholder type for builtin functions.
  public static final int PREDEF_TYPE_BUILTIN_FN = 36;
  /// \brief OpenCL event type.
  public static final int PREDEF_TYPE_EVENT_ID = 37;
  /// \brief OpenCL clk event type.
  public static final int PREDEF_TYPE_CLK_EVENT_ID = 38;
  /// \brief OpenCL sampler type.
  public static final int PREDEF_TYPE_SAMPLER_ID = 39;
  /// \brief OpenCL queue type.
  public static final int PREDEF_TYPE_QUEUE_ID = 40;
  /// \brief OpenCL ndrange type.
  public static final int PREDEF_TYPE_NDRANGE_ID = 41;
  /// \brief OpenCL reserve_id type.
  public static final int PREDEF_TYPE_RESERVE_ID_ID = 42;
  /// \brief The placeholder type for OpenMP array section.
  public static final int PREDEF_TYPE_OMP_ARRAY_SECTION = 43;
  /// \brief The '__float128' type
  public static final int PREDEF_TYPE_FLOAT128_ID = 44;
  public static final int PREDEF_TYPE_OCLImage1dRO_ID = PREDEF_TYPE_FLOAT128_ID + 1;
  public static final int PREDEF_TYPE_OCLImage1dArrayRO_ID = PREDEF_TYPE_OCLImage1dRO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage1dBufferRO_ID = PREDEF_TYPE_OCLImage1dArrayRO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dRO_ID = PREDEF_TYPE_OCLImage1dBufferRO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dArrayRO_ID = PREDEF_TYPE_OCLImage2dRO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dDepthRO_ID = PREDEF_TYPE_OCLImage2dArrayRO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dArrayDepthRO_ID = PREDEF_TYPE_OCLImage2dDepthRO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dMSAARO_ID = PREDEF_TYPE_OCLImage2dArrayDepthRO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dArrayMSAARO_ID = PREDEF_TYPE_OCLImage2dMSAARO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dMSAADepthRO_ID = PREDEF_TYPE_OCLImage2dArrayMSAARO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dArrayMSAADepthRO_ID = PREDEF_TYPE_OCLImage2dMSAADepthRO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage3dRO_ID = PREDEF_TYPE_OCLImage2dArrayMSAADepthRO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage1dWO_ID = PREDEF_TYPE_OCLImage3dRO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage1dArrayWO_ID = PREDEF_TYPE_OCLImage1dWO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage1dBufferWO_ID = PREDEF_TYPE_OCLImage1dArrayWO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dWO_ID = PREDEF_TYPE_OCLImage1dBufferWO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dArrayWO_ID = PREDEF_TYPE_OCLImage2dWO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dDepthWO_ID = PREDEF_TYPE_OCLImage2dArrayWO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dArrayDepthWO_ID = PREDEF_TYPE_OCLImage2dDepthWO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dMSAAWO_ID = PREDEF_TYPE_OCLImage2dArrayDepthWO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dArrayMSAAWO_ID = PREDEF_TYPE_OCLImage2dMSAAWO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dMSAADepthWO_ID = PREDEF_TYPE_OCLImage2dArrayMSAAWO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dArrayMSAADepthWO_ID = PREDEF_TYPE_OCLImage2dMSAADepthWO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage3dWO_ID = PREDEF_TYPE_OCLImage2dArrayMSAADepthWO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage1dRW_ID = PREDEF_TYPE_OCLImage3dWO_ID + 1;
  public static final int PREDEF_TYPE_OCLImage1dArrayRW_ID = PREDEF_TYPE_OCLImage1dRW_ID + 1;
  public static final int PREDEF_TYPE_OCLImage1dBufferRW_ID = PREDEF_TYPE_OCLImage1dArrayRW_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dRW_ID = PREDEF_TYPE_OCLImage1dBufferRW_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dArrayRW_ID = PREDEF_TYPE_OCLImage2dRW_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dDepthRW_ID = PREDEF_TYPE_OCLImage2dArrayRW_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dArrayDepthRW_ID = PREDEF_TYPE_OCLImage2dDepthRW_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dMSAARW_ID = PREDEF_TYPE_OCLImage2dArrayDepthRW_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dArrayMSAARW_ID = PREDEF_TYPE_OCLImage2dMSAARW_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dMSAADepthRW_ID = PREDEF_TYPE_OCLImage2dArrayMSAARW_ID + 1;
  public static final int PREDEF_TYPE_OCLImage2dArrayMSAADepthRW_ID = PREDEF_TYPE_OCLImage2dMSAADepthRW_ID + 1;
  public static final int PREDEF_TYPE_OCLImage3dRW_ID = PREDEF_TYPE_OCLImage2dArrayMSAADepthRW_ID + 1;
}
