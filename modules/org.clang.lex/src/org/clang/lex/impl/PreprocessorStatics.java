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
package org.clang.lex.impl;

import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;


//<editor-fold defaultstate="collapsed" desc="static type PreprocessorStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZL21MacroDefinitionEqualsPKN5clang9MacroInfoEN4llvm8ArrayRefINS_10TokenValueEEE;_ZL23getFutureCompatDiagKindRKN5clang14IdentifierInfoERKNS_11LangOptionsE; -static-type=PreprocessorStatics -package=org.clang.lex.impl")
//</editor-fold>
public final class PreprocessorStatics {


/// \brief Compares macro tokens with a specified token value sequence.
//<editor-fold defaultstate="collapsed" desc="MacroDefinitionEquals">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 328,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 325,
 FQN="MacroDefinitionEquals", NM="_ZL21MacroDefinitionEqualsPKN5clang9MacroInfoEN4llvm8ArrayRefINS_10TokenValueEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZL21MacroDefinitionEqualsPKN5clang9MacroInfoEN4llvm8ArrayRefINS_10TokenValueEEE")
//</editor-fold>
public static boolean MacroDefinitionEquals(/*const*/ MacroInfo /*P*/ MI, 
                     ArrayRef<TokenValue> Tokens) {
  int Nr = Tokens.size();
  if (Nr != MI.getNumTokens()) {
    return false;
  }
  Token[] $tokens = MI.$tokens();
  for (int i = 0; i < Nr; i++) {
    if (!Tokens.$at(i).$eq($tokens[i])) {
      return false;
    }
  }
  return true;
}


/// \brief Returns a diagnostic message kind for reporting a future keyword as
/// appropriate for the identifier and specified language.
//<editor-fold defaultstate="collapsed" desc="getFutureCompatDiagKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 606,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 603,
 FQN="getFutureCompatDiagKind", NM="_ZL23getFutureCompatDiagKindRKN5clang14IdentifierInfoERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZL23getFutureCompatDiagKindRKN5clang14IdentifierInfoERKNS_11LangOptionsE")
//</editor-fold>
public static /*uint*/int getFutureCompatDiagKind(/*const*/ IdentifierInfo /*&*/ II, 
                       /*const*/ LangOptions /*&*/ LangOpts) {
  assert (II.isFutureCompatKeyword()) : "diagnostic should not be needed";
  if (LangOpts.CPlusPlus) {
    return new StringSwitchUInt(II.getName()).
        // C++11 keywords
        Case(/*KEEP_STR*/"alignas", diag.warn_cxx11_keyword).
        Case(/*KEEP_STR*/"alignof", diag.warn_cxx11_keyword).
        Case(/*KEEP_STR*/"char16_t", diag.warn_cxx11_keyword).
        Case(/*KEEP_STR*/"char32_t", diag.warn_cxx11_keyword).
        Case(/*KEEP_STR*/"constexpr", diag.warn_cxx11_keyword).
        Case(/*KEEP_STR*/"decltype", diag.warn_cxx11_keyword).
        Case(/*KEEP_STR*/"noexcept", diag.warn_cxx11_keyword).
        Case(/*KEEP_STR*/"nullptr", diag.warn_cxx11_keyword).
        Case(/*KEEP_STR*/"static_assert", diag.warn_cxx11_keyword).
        Case(/*KEEP_STR*/"thread_local", diag.warn_cxx11_keyword).$T_0_1();
  }
  throw new llvm_unreachable("Keyword not known to come from a newer Standard or proposed Standard");
}

} // END OF class PreprocessorStatics
