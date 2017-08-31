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
* \brief Flags that control the creation of translation units.
*
* The enumerators in this enumeration type are meant to be bitwise
* ORed together to specify which options should be used when
* constructing the translation unit.
*/
//<editor-fold defaultstate="collapsed" desc="CXTranslationUnit_Flags">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang-c/Index.h", line = 1114,
 FQN="CXTranslationUnit_Flags", NM="_Z23CXTranslationUnit_Flags",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z23CXTranslationUnit_Flags")
//</editor-fold>
public final class/*enum*/ CXTranslationUnit_Flags {
  /**
  * \brief Used to indicate that no special translation-unit options are
  * needed.
  */
  public static final /*uint*/int CXTranslationUnit_None = 0x0;
  
  /**
  * \brief Used to indicate that the parser should construct a "detailed"
  * preprocessing record, including all macro definitions and instantiations.
  *
  * Constructing a detailed preprocessing record requires more memory
  * and time to parse, since the information contained in the record
  * is usually not retained. However, it can be useful for
  * applications that require more detailed information about the
  * behavior of the preprocessor.
  */
  public static final /*uint*/int CXTranslationUnit_DetailedPreprocessingRecord = 0x01;
  
  /**
  * \brief Used to indicate that the translation unit is incomplete.
  *
  * When a translation unit is considered "incomplete", semantic
  * analysis that is typically performed at the end of the
  * translation unit will be suppressed. For example, this suppresses
  * the completion of tentative declarations in C and of
  * instantiation of implicitly-instantiation function templates in
  * C++. This option is typically used when parsing a header with the
  * intent of producing a precompiled header.
  */
  public static final /*uint*/int CXTranslationUnit_Incomplete = 0x02;
  
  /**
  * \brief Used to indicate that the translation unit should be built with an 
  * implicit precompiled header for the preamble.
  *
  * An implicit precompiled header is used as an optimization when a
  * particular translation unit is likely to be reparsed many times
  * when the sources aren't changing that often. In this case, an
  * implicit precompiled header will be built containing all of the
  * initial includes at the top of the main file (what we refer to as
  * the "preamble" of the file). In subsequent parses, if the
  * preamble or the files in it have not changed, \c
  * clang_reparseTranslationUnit() will re-use the implicit
  * precompiled header to improve parsing performance.
  */
  public static final /*uint*/int CXTranslationUnit_PrecompiledPreamble = 0x04;
  
  /**
  * \brief Used to indicate that the translation unit should cache some
  * code-completion results with each reparse of the source file.
  *
  * Caching of code-completion results is a performance optimization that
  * introduces some overhead to reparsing but improves the performance of
  * code-completion operations.
  */
  public static final /*uint*/int CXTranslationUnit_CacheCompletionResults = 0x08;
  
  /**
  * \brief Used to indicate that the translation unit will be serialized with
  * \c clang_saveTranslationUnit.
  *
  * This option is typically used when parsing a header with the intent of
  * producing a precompiled header.
  */
  public static final /*uint*/int CXTranslationUnit_ForSerialization = 0x10;
  
  /**
  * \brief DEPRECATED: Enabled chained precompiled preambles in C++.
  *
  * Note: this is a *temporary* option that is available only while
  * we are testing C++ precompiled preamble support. It is deprecated.
  */
  public static final /*uint*/int CXTranslationUnit_CXXChainedPCH = 0x20;
  
  /**
  * \brief Used to indicate that function/method bodies should be skipped while
  * parsing.
  *
  * This option can be used to search for declarations/definitions while
  * ignoring the usages.
  */
  public static final /*uint*/int CXTranslationUnit_SkipFunctionBodies = 0x40;
  
  /**
  * \brief Used to indicate that brief documentation comments should be
  * included into the set of code completions returned from this translation
  * unit.
  */
  public static final /*uint*/int CXTranslationUnit_IncludeBriefCommentsInCodeCompletion = 0x80;
  
  /**
  * \brief Used to indicate that the precompiled preamble should be created on
  * the first parse. Otherwise it will be created on the first reparse. This
  * trades runtime on the first parse (serializing the preamble takes time) for
  * reduced runtime on the second parse (can now reuse the preamble).
  */
  public static final /*uint*/int CXTranslationUnit_CreatePreambleOnFirstParse = 0x100;
  
  /**
  * \brief Do not stop processing when fatal errors are encountered.
  *
  * When fatal errors are encountered while parsing a translation unit,
  * semantic analysis is typically stopped early when compiling code. A common
  * source for fatal errors are unresolvable include files. For the
  * purposes of an IDE, this is undesirable behavior and as much information
  * as possible should be reported. Use this flag to enable this behavior.
  */
  public static final /*uint*/int CXTranslationUnit_KeepGoing = 0x200;
}
