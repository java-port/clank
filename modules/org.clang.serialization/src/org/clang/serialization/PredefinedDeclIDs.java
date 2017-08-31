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


/// \brief Predefined declaration IDs.
///
/// These declaration IDs correspond to predefined declarations in the AST
/// context, such as the NULL declaration ID. Such declarations are never
/// actually serialized, since they will be built by the AST context when 
/// it is created.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::PredefinedDeclIDs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 938,
 FQN="clang::serialization::PredefinedDeclIDs", NM="_ZN5clang13serialization17PredefinedDeclIDsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serialization17PredefinedDeclIDsE")
//</editor-fold>
public final class/*enum*/ PredefinedDeclIDs {
  /// \brief The NULL declaration.
  public static final int PREDEF_DECL_NULL_ID = 0;
  
  /// \brief The translation unit.
  public static final int PREDEF_DECL_TRANSLATION_UNIT_ID = 1;
  
  /// \brief The Objective-C 'id' type.
  public static final int PREDEF_DECL_OBJC_ID_ID = 2;
  
  /// \brief The Objective-C 'SEL' type.
  public static final int PREDEF_DECL_OBJC_SEL_ID = 3;
  
  /// \brief The Objective-C 'Class' type.
  public static final int PREDEF_DECL_OBJC_CLASS_ID = 4;
  
  /// \brief The Objective-C 'Protocol' type.
  public static final int PREDEF_DECL_OBJC_PROTOCOL_ID = 5;
  
  /// \brief The signed 128-bit integer type.
  public static final int PREDEF_DECL_INT_128_ID = 6;
  
  /// \brief The unsigned 128-bit integer type.
  public static final int PREDEF_DECL_UNSIGNED_INT_128_ID = 7;
  
  /// \brief The internal 'instancetype' typedef.
  public static final int PREDEF_DECL_OBJC_INSTANCETYPE_ID = 8;
  
  /// \brief The internal '__builtin_va_list' typedef.
  public static final int PREDEF_DECL_BUILTIN_VA_LIST_ID = 9;
  
  /// \brief The internal '__va_list_tag' struct, if any.
  public static final int PREDEF_DECL_VA_LIST_TAG = 10;
  
  /// \brief The internal '__builtin_ms_va_list' typedef.
  public static final int PREDEF_DECL_BUILTIN_MS_VA_LIST_ID = 11;
  
  /// \brief The extern "C" context.
  public static final int PREDEF_DECL_EXTERN_C_CONTEXT_ID = 12;
  
  /// \brief The internal '__make_integer_seq' template.
  public static final int PREDEF_DECL_MAKE_INTEGER_SEQ_ID = 13;
  
  /// \brief The internal '__NSConstantString' typedef.
  public static final int PREDEF_DECL_CF_CONSTANT_STRING_ID = 14;
  
  /// \brief The internal '__NSConstantString' tag type.
  public static final int PREDEF_DECL_CF_CONSTANT_STRING_TAG_ID = 15;
  
  /// \brief The internal '__type_pack_element' template.
  public static final int PREDEF_DECL_TYPE_PACK_ELEMENT_ID = 16;
}
