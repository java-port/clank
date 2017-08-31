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

package org.clang.clangc;

import org.clank.support.*;


/**
* \brief Bits that represent the context under which completion is occurring.
*
* The enumerators in this enumeration may be bitwise-OR'd together if multiple
* contexts are occurring simultaneously.
*/
//<editor-fold defaultstate="collapsed" desc="CXCompletionContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang-c/Index.h", line = 4852,
 FQN="CXCompletionContext", NM="_Z19CXCompletionContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z19CXCompletionContext")
//</editor-fold>
public final class/*enum*/ CXCompletionContext {
  /**
  * \brief The context for completions is unexposed, as only Clang results
  * should be included. (This is equivalent to having no context bits set.)
  */
  public static final /*uint*/int CXCompletionContext_Unexposed = 0;
  
  /**
  * \brief Completions for any possible type should be included in the results.
  */
  public static final /*uint*/int CXCompletionContext_AnyType = 1 << 0;
  
  /**
  * \brief Completions for any possible value (variables, function calls, etc.)
  * should be included in the results.
  */
  public static final /*uint*/int CXCompletionContext_AnyValue = 1 << 1;
  /**
  * \brief Completions for values that resolve to an Objective-C object should
  * be included in the results.
  */
  public static final /*uint*/int CXCompletionContext_ObjCObjectValue = 1 << 2;
  /**
  * \brief Completions for values that resolve to an Objective-C selector
  * should be included in the results.
  */
  public static final /*uint*/int CXCompletionContext_ObjCSelectorValue = 1 << 3;
  /**
  * \brief Completions for values that resolve to a C++ class type should be
  * included in the results.
  */
  public static final /*uint*/int CXCompletionContext_CXXClassTypeValue = 1 << 4;
  
  /**
  * \brief Completions for fields of the member being accessed using the dot
  * operator should be included in the results.
  */
  public static final /*uint*/int CXCompletionContext_DotMemberAccess = 1 << 5;
  /**
  * \brief Completions for fields of the member being accessed using the arrow
  * operator should be included in the results.
  */
  public static final /*uint*/int CXCompletionContext_ArrowMemberAccess = 1 << 6;
  /**
  * \brief Completions for properties of the Objective-C object being accessed
  * using the dot operator should be included in the results.
  */
  public static final /*uint*/int CXCompletionContext_ObjCPropertyAccess = 1 << 7;
  
  /**
  * \brief Completions for enum tags should be included in the results.
  */
  public static final /*uint*/int CXCompletionContext_EnumTag = 1 << 8;
  /**
  * \brief Completions for union tags should be included in the results.
  */
  public static final /*uint*/int CXCompletionContext_UnionTag = 1 << 9;
  /**
  * \brief Completions for struct tags should be included in the results.
  */
  public static final /*uint*/int CXCompletionContext_StructTag = 1 << 10;
  
  /**
  * \brief Completions for C++ class names should be included in the results.
  */
  public static final /*uint*/int CXCompletionContext_ClassTag = 1 << 11;
  /**
  * \brief Completions for C++ namespaces and namespace aliases should be
  * included in the results.
  */
  public static final /*uint*/int CXCompletionContext_Namespace = 1 << 12;
  /**
  * \brief Completions for C++ nested name specifiers should be included in
  * the results.
  */
  public static final /*uint*/int CXCompletionContext_NestedNameSpecifier = 1 << 13;
  
  /**
  * \brief Completions for Objective-C interfaces (classes) should be included
  * in the results.
  */
  public static final /*uint*/int CXCompletionContext_ObjCInterface = 1 << 14;
  /**
  * \brief Completions for Objective-C protocols should be included in
  * the results.
  */
  public static final /*uint*/int CXCompletionContext_ObjCProtocol = 1 << 15;
  /**
  * \brief Completions for Objective-C categories should be included in
  * the results.
  */
  public static final /*uint*/int CXCompletionContext_ObjCCategory = 1 << 16;
  /**
  * \brief Completions for Objective-C instance messages should be included
  * in the results.
  */
  public static final /*uint*/int CXCompletionContext_ObjCInstanceMessage = 1 << 17;
  /**
  * \brief Completions for Objective-C class messages should be included in
  * the results.
  */
  public static final /*uint*/int CXCompletionContext_ObjCClassMessage = 1 << 18;
  /**
  * \brief Completions for Objective-C selector names should be included in
  * the results.
  */
  public static final /*uint*/int CXCompletionContext_ObjCSelectorName = 1 << 19;
  
  /**
  * \brief Completions for preprocessor macro names should be included in
  * the results.
  */
  public static final /*uint*/int CXCompletionContext_MacroName = 1 << 20;
  
  /**
  * \brief Natural language completions should be included in the results.
  */
  public static final /*uint*/int CXCompletionContext_NaturalLanguage = 1 << 21;
  
  /**
  * \brief The current context is unknown, so set all contexts.
  */
  public static final /*uint*/int CXCompletionContext_Unknown = ((1 << 22) - 1);
}
