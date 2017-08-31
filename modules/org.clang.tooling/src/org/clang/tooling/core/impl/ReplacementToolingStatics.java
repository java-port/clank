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
package org.clang.tooling.core.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clang.basic.*;
import org.clang.tooling.core.*;


//<editor-fold defaultstate="collapsed" desc="static type ReplacementToolingStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=Tpl__ZN5clang7tooling27shiftedCodePositionInternalERKT_j;_ZN5clang7toolingL12getRangeSizeERKNS_13SourceManagerERKNS_15CharSourceRangeERKNS_11LangOptionsE;_ZN5clang7toolingL18mergeAndSortRangesESt6vectorINS0_5RangeESaIS2_EE; -static-type=ReplacementToolingStatics -package=org.clang.tooling.core.impl")
//</editor-fold>
public final class ReplacementToolingStatics {


// FIXME: This should go into the Lexer, but we need to figure out how
// to handle ranges for refactoring in general first - there is no obvious
// good way how to integrate this into the Lexer yet.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::getRangeSize">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 119,
 FQN="clang::tooling::getRangeSize", NM="_ZN5clang7toolingL12getRangeSizeERKNS_13SourceManagerERKNS_15CharSourceRangeERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7toolingL12getRangeSizeERKNS_13SourceManagerERKNS_15CharSourceRangeERKNS_11LangOptionsE")
//</editor-fold>
public static int getRangeSize(final /*const*/ SourceManager /*&*/ Sources, 
            final /*const*/ CharSourceRange /*&*/ Range, 
            final /*const*/ LangOptions /*&*/ LangOpts) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::tooling::shiftedCodePositionInternal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 142,
 FQN="clang::tooling::shiftedCodePositionInternal", NM="Tpl__ZN5clang7tooling27shiftedCodePositionInternalERKT_j",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=Tpl__ZN5clang7tooling27shiftedCodePositionInternalERKT_j")
//</editor-fold>
public static </*typename*/ T> /*uint*/int shiftedCodePositionInternal(final /*const*/ T /*&*/ Replaces, /*uint*/int Position) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Merge and sort overlapping ranges in \p Ranges.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::mergeAndSortRanges">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 286,
 FQN="clang::tooling::mergeAndSortRanges", NM="_ZN5clang7toolingL18mergeAndSortRangesESt6vectorINS0_5RangeESaIS2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7toolingL18mergeAndSortRangesESt6vectorINS0_5RangeESaIS2_EE")
//</editor-fold>
public static std.vector<Range> mergeAndSortRanges(std.vector<Range> Ranges) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class ReplacementToolingStatics
