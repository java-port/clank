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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.basic.*;


//<editor-fold defaultstate="collapsed" desc="static type UnwrappedLineFormatterFormatStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.format.impl.UnwrappedLineFormatterFormatStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_118startsExternCBlockERKNS0_13AnnotatedLineE;_ZN5clang6format12_GLOBAL__N_1L13markFinalizedEPNS0_11FormatTokenE;_ZN5clang6format12_GLOBAL__N_1L14printLineStateERKNS0_9LineStateE; -static-type=UnwrappedLineFormatterFormatStatics -package=org.clang.format.impl")
//</editor-fold>
public final class UnwrappedLineFormatterFormatStatics {

//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::startsExternCBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 21,
 FQN="clang::format::(anonymous namespace)::startsExternCBlock", NM="_ZN5clang6format12_GLOBAL__N_118startsExternCBlockERKNS0_13AnnotatedLineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_118startsExternCBlockERKNS0_13AnnotatedLineE")
//</editor-fold>
public static boolean startsExternCBlock(final /*const*/ AnnotatedLine /*&*/ Line) {
  /*const*/ FormatToken /*P*/ Next = Line.First.getNextNonComment();
  /*const*/ FormatToken /*P*/ NextNext = (Next != null) ? Next.getNextNonComment() : null;
  return Line.startsWith(tok.TokenKind.kw_extern) && (Next != null) && Next.isStringLiteral()
     && (NextNext != null) && NextNext.is_TokenKind(tok.TokenKind.l_brace);
}

//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::markFinalized">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 453,
 FQN="clang::format::(anonymous namespace)::markFinalized", NM="_ZN5clang6format12_GLOBAL__N_1L13markFinalizedEPNS0_11FormatTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_1L13markFinalizedEPNS0_11FormatTokenE")
//</editor-fold>
public static void markFinalized(FormatToken /*P*/ Tok) {
  for (; (Tok != null); Tok = Tok.Next) {
    Tok.Finalized = true;
    for (AnnotatedLine /*P*/ Child : Tok.Children)  {
      markFinalized(Child.First);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::printLineState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 462,
 FQN="clang::format::(anonymous namespace)::printLineState", NM="_ZN5clang6format12_GLOBAL__N_1L14printLineStateERKNS0_9LineStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_1L14printLineStateERKNS0_9LineStateE")
//</editor-fold>
public static void printLineState(final /*const*/ LineState /*&*/ State) {
  llvm.dbgs().$out(/*KEEP_STR*/"State: ");
  for (final /*const*/ ParenState /*&*/ P : State.Stack) {
    llvm.dbgs().$out_uint(P.Indent).$out(/*KEEP_STR*/$PIPE).$out_uint(P.LastSpace).$out(/*KEEP_STR*/$PIPE).$out_uint(P.NestedBlockIndent).$out(
        /*KEEP_STR*/$SPACE
    );
  }
  llvm.dbgs().$out(/*NO_COPY*/State.NextToken.TokenText).$out(/*KEEP_STR*/$LF);
}

} // END OF class UnwrappedLineFormatterFormatStatics
