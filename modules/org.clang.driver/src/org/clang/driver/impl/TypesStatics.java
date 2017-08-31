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
package org.clang.driver.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.driver.impl.*;
import static org.clang.driver.types.ID;


//<editor-fold defaultstate="collapsed" desc="static type TypesStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZL7getInfoj;_ZL8numTypes;_ZL9TypeInfos; -static-type=TypesStatics -package=org.clang.driver.impl")
//</editor-fold>
public final class TypesStatics {

//<editor-fold defaultstate="collapsed" desc="TypeInfos">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 26,
 FQN="TypeInfos", NM="_ZL9TypeInfos",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZL9TypeInfos")
//</editor-fold>
public static /*const*/ TypeInfo TypeInfos[/*48*/] = new /*const*/ TypeInfo [/*48*/] {
  
  // TYPE(NAME, ID, PP_TYPE, TEMP_SUFFIX, FLAGS)
  
  // The first value is the type name as a string; for types which can
  // be user specified this should be the equivalent -x option.
  
  // The second value is the type id, which will result in a
  // clang::driver::types::TY_XX enum constant.
  
  // The third value is that id of the type for preprocessed inputs of
  // this type, or INVALID if this type is not preprocessed.
  
  // The fourth value is the suffix to use when creating temporary files
  // of this type, or null if unspecified.
  
  // The fifth value is a string containing option flags. Valid values:
  //  a - The type should only be assembled.
  //  p - The type should only be precompiled.
  //  u - The type can be user specified (with -x).
  //  A - The type's temporary suffix should be appended when generating
  //      outputs of this type.
  
  // C family source language (with and without preprocessing).
  new TypeInfo(/*KEEP_STR*/"cpp-output", /*KEEP_STR*/"u", /*KEEP_STR*/"i", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"c", /*KEEP_STR*/"u", /*KEEP_STR*/"c", /*KEEP_ENUM*/ID.TY_PP_C), 
  new TypeInfo(/*KEEP_STR*/"cl", /*KEEP_STR*/"u", /*KEEP_STR*/"cl", /*KEEP_ENUM*/ID.TY_PP_C), 
  new TypeInfo(/*KEEP_STR*/"cuda-cpp-output", /*KEEP_STR*/"u", /*KEEP_STR*/"cui", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"cuda", /*KEEP_STR*/"u", /*KEEP_STR*/"cu", /*KEEP_ENUM*/ID.TY_PP_CUDA), 
  new TypeInfo(/*KEEP_STR*/"cuda", /*KEEP_STR*/"", /*KEEP_STR*/"cu", /*KEEP_ENUM*/ID.TY_PP_CUDA), 
  new TypeInfo(/*KEEP_STR*/"objective-c-cpp-output", /*KEEP_STR*/"u", /*KEEP_STR*/"mi", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"objc-cpp-output", /*KEEP_STR*/"u", /*KEEP_STR*/"mi", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"objective-c", /*KEEP_STR*/"u", /*KEEP_STR*/"m", /*KEEP_ENUM*/ID.TY_PP_ObjC), 
  new TypeInfo(/*KEEP_STR*/"c++-cpp-output", /*KEEP_STR*/"u", /*KEEP_STR*/"ii", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"c++", /*KEEP_STR*/"u", /*KEEP_STR*/"cpp", /*KEEP_ENUM*/ID.TY_PP_CXX), 
  new TypeInfo(/*KEEP_STR*/"objective-c++-cpp-output", /*KEEP_STR*/"u", /*KEEP_STR*/"mii", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"objc++-cpp-output", /*KEEP_STR*/"u", /*KEEP_STR*/"mii", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"objective-c++", /*KEEP_STR*/"u", /*KEEP_STR*/"mm", /*KEEP_ENUM*/ID.TY_PP_ObjCXX), 
  new TypeInfo(/*KEEP_STR*/"renderscript", /*KEEP_STR*/"u", /*KEEP_STR*/"rs", /*KEEP_ENUM*/ID.TY_PP_C), 
  
  // C family input files to precompile.
  new TypeInfo(/*KEEP_STR*/"c-header-cpp-output", /*KEEP_STR*/"p", /*KEEP_STR*/"i", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"c-header", /*KEEP_STR*/"pu", /*KEEP_STR*/"h", /*KEEP_ENUM*/ID.TY_PP_CHeader), 
  new TypeInfo(/*KEEP_STR*/"cl-header", /*KEEP_STR*/"pu", /*KEEP_STR*/"h", /*KEEP_ENUM*/ID.TY_PP_CHeader), 
  new TypeInfo(/*KEEP_STR*/"objective-c-header-cpp-output", /*KEEP_STR*/"p", /*KEEP_STR*/"mi", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"objective-c-header", /*KEEP_STR*/"pu", /*KEEP_STR*/"h", /*KEEP_ENUM*/ID.TY_PP_ObjCHeader), 
  new TypeInfo(/*KEEP_STR*/"c++-header-cpp-output", /*KEEP_STR*/"p", /*KEEP_STR*/"ii", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"c++-header", /*KEEP_STR*/"pu", /*KEEP_STR*/"hh", /*KEEP_ENUM*/ID.TY_PP_CXXHeader), 
  new TypeInfo(/*KEEP_STR*/"objective-c++-header-cpp-output", /*KEEP_STR*/"p", /*KEEP_STR*/"mii", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"objective-c++-header", /*KEEP_STR*/"pu", /*KEEP_STR*/"h", /*KEEP_ENUM*/ID.TY_PP_ObjCXXHeader), 
  
  // Other languages.
  new TypeInfo(/*KEEP_STR*/"ada", /*KEEP_STR*/"u", /*NULL*/(/*const*/char$ptr/*char P*/ )null, /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"assembler", /*KEEP_STR*/"au", /*KEEP_STR*/"s", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"assembler-with-cpp", /*KEEP_STR*/"au", /*KEEP_STR*/"S", /*KEEP_ENUM*/ID.TY_PP_Asm), 
  new TypeInfo(/*KEEP_STR*/"f95", /*KEEP_STR*/"u", /*NULL*/(/*const*/char$ptr/*char P*/ )null, /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"f95-cpp-input", /*KEEP_STR*/"u", /*NULL*/(/*const*/char$ptr/*char P*/ )null, /*KEEP_ENUM*/ID.TY_PP_Fortran), 
  new TypeInfo(/*KEEP_STR*/"java", /*KEEP_STR*/"u", /*NULL*/(/*const*/char$ptr/*char P*/ )null, /*KEEP_ENUM*/ID.TY_INVALID), 
  
  // LLVM IR/LTO types. We define separate types for IR and LTO because LTO
  // outputs should use the standard suffixes.
  new TypeInfo(/*KEEP_STR*/"ir", /*KEEP_STR*/"u", /*KEEP_STR*/"ll", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"ir", /*KEEP_STR*/"u", /*KEEP_STR*/"bc", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"lto-ir", /*KEEP_STR*/"", /*KEEP_STR*/"s", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"lto-bc", /*KEEP_STR*/"", /*KEEP_STR*/"o", /*KEEP_ENUM*/ID.TY_INVALID), 
  
  // Misc.
  new TypeInfo(/*KEEP_STR*/"ast", /*KEEP_STR*/"u", /*KEEP_STR*/"ast", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"pcm", /*KEEP_STR*/"u", /*KEEP_STR*/"pcm", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"plist", /*KEEP_STR*/"", /*KEEP_STR*/"plist", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"rewritten-objc", /*KEEP_STR*/"", /*KEEP_STR*/"cpp", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"rewritten-legacy-objc", /*KEEP_STR*/"", /*KEEP_STR*/"cpp", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"remap", /*KEEP_STR*/"", /*KEEP_STR*/"remap", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"precompiled-header", /*KEEP_STR*/"A", /*KEEP_STR*/"gch", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"object", /*KEEP_STR*/"", /*KEEP_STR*/"o", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"treelang", /*KEEP_STR*/"u", /*NULL*/(/*const*/char$ptr/*char P*/ )null, /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"image", /*KEEP_STR*/"", /*KEEP_STR*/"out", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"dSYM", /*KEEP_STR*/"A", /*KEEP_STR*/"dSYM", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"dependencies", /*KEEP_STR*/"", /*KEEP_STR*/"d", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"cuda-fatbin", /*KEEP_STR*/"A", /*KEEP_STR*/"fatbin", /*KEEP_ENUM*/ID.TY_INVALID), 
  new TypeInfo(/*KEEP_STR*/"none", /*KEEP_STR*/"u", /*NULL*/(/*const*/char$ptr/*char P*/ )null, /*KEEP_ENUM*/ID.TY_INVALID)
};
//<editor-fold defaultstate="collapsed" desc="numTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 32,
 FQN="numTypes", NM="_ZL8numTypes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZL8numTypes")
//</editor-fold>
public static /*const*//*uint*/int numTypes = llvm.array_lengthof(TypeInfos);
//<editor-fold defaultstate="collapsed" desc="getInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 34,
 FQN="getInfo", NM="_ZL7getInfoj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZL7getInfoj")
//</editor-fold>
public static /*const*/ TypeInfo /*&*/ getInfo(/*uint*/int id) {
  assert ($greater_uint(id, 0) && $less_uint(id - 1, numTypes)) : "Invalid Type ID.";
  return TypeInfos[id - 1];
}

} // END OF class TypesStatics
