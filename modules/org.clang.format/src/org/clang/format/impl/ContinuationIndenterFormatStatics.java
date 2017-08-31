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
package org.clang.format.impl;

import org.clank.support.*;
import org.clang.basic.*;
import org.clang.format.*;


//<editor-fold defaultstate="collapsed" desc="static type ContinuationIndenterFormatStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.format.impl.ContinuationIndenterFormatStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6formatL19startsNextParameterERKNS0_11FormatTokenERKNS0_11FormatStyleE;_ZN5clang6formatL23getLengthToNextOperatorERKNS0_11FormatTokenE;_ZN5clang6formatL24getLengthToMatchingParenERKNS0_11FormatTokenE;_ZN5clang6formatL30startsSegmentOfBuilderTypeCallERKNS0_11FormatTokenE; -static-type=ContinuationIndenterFormatStatics -package=org.clang.format.impl")
//</editor-fold>
public final class ContinuationIndenterFormatStatics {


// Returns the length of everything up to the first possible line break after
// the ), ], } or > matching \c Tok.
//<editor-fold defaultstate="collapsed" desc="clang::format::getLengthToMatchingParen">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 31,
 FQN="clang::format::getLengthToMatchingParen", NM="_ZN5clang6formatL24getLengthToMatchingParenERKNS0_11FormatTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6formatL24getLengthToMatchingParenERKNS0_11FormatTokenE")
//</editor-fold>
public static /*uint*/int getLengthToMatchingParen(final /*const*/ FormatToken /*&*/ Tok) {
  if (!(Tok.MatchingParen != null)) {
    return 0;
  }
  FormatToken /*P*/ End = Tok.MatchingParen;
  while ((End.Next != null) && !End.Next.CanBreakBefore) {
    End = End.Next;
  }
  return End.TotalLength - Tok.TotalLength + 1;
}

//<editor-fold defaultstate="collapsed" desc="clang::format::getLengthToNextOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 41,
 FQN="clang::format::getLengthToNextOperator", NM="_ZN5clang6formatL23getLengthToNextOperatorERKNS0_11FormatTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6formatL23getLengthToNextOperatorERKNS0_11FormatTokenE")
//</editor-fold>
public static /*uint*/int getLengthToNextOperator(final /*const*/ FormatToken /*&*/ Tok) {
  if (!(Tok.NextOperator != null)) {
    return 0;
  }
  return Tok.NextOperator.TotalLength - Tok.TotalLength;
}


// Returns \c true if \c Tok is the "." or "->" of a call and starts the next
// segment of a builder type call.
//<editor-fold defaultstate="collapsed" desc="clang::format::startsSegmentOfBuilderTypeCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 49,
 FQN="clang::format::startsSegmentOfBuilderTypeCall", NM="_ZN5clang6formatL30startsSegmentOfBuilderTypeCallERKNS0_11FormatTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6formatL30startsSegmentOfBuilderTypeCallERKNS0_11FormatTokenE")
//</editor-fold>
public static boolean startsSegmentOfBuilderTypeCall(final /*const*/ FormatToken /*&*/ Tok) {
  return Tok.isMemberAccess() && (Tok.Previous != null) && Tok.Previous.closesScope();
}


// Returns \c true if \c Current starts a new parameter.
//<editor-fold defaultstate="collapsed" desc="clang::format::startsNextParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp", line = 54,
 FQN="clang::format::startsNextParameter", NM="_ZN5clang6formatL19startsNextParameterERKNS0_11FormatTokenERKNS0_11FormatStyleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6formatL19startsNextParameterERKNS0_11FormatTokenERKNS0_11FormatStyleE")
//</editor-fold>
public static boolean startsNextParameter(final /*const*/ FormatToken /*&*/ Current, 
                   final /*const*/ FormatStyle /*&*/ Style) {
  final /*const*/ FormatToken /*&*/ Previous = /*Deref*/Current.Previous;
  if (Current.is_TokenType(TokenType.TT_CtorInitializerComma)
     && Style.BreakConstructorInitializersBeforeComma) {
    return true;
  }
  return Previous.is_TokenKind(tok.TokenKind.comma) && !Current.isTrailingComment()
     && (Previous.isNot(TokenType.TT_CtorInitializerComma)
     || !Style.BreakConstructorInitializersBeforeComma);
}

} // END OF class ContinuationIndenterFormatStatics
