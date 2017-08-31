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

package org.clang.format;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="static type FormatTestUtils">
@Converted(kind = Converted.Kind.AUTO,
 NM="FormatTestUtils",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestUtils.h -test=FormatTestUtils")
//</editor-fold>
public final class FormatTestUtils extends ADTSupportTestBase {

//JAVA: namespace clang {
//JAVA: namespace format {
//JAVA: namespace test {
public static final class test {
  
  //<editor-fold defaultstate="collapsed" desc="clang::format::test::messUp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestUtils.h", line = 23,
   FQN="clang::format::test::messUp", NM="_ZN5clang6format4test6messUpEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestUtils.h -nm=_ZN5clang6format4test6messUpEN4llvm9StringRefE")
  //</editor-fold>
  public static /*inline*/ std.string messUp(StringRef Code) {
    std.string MessedUp/*J*/= Code.str();
    boolean InComment = false;
    boolean InPreprocessorDirective = false;
    boolean JustReplacedNewline = false;
    for (/*uint*/int i = 0, e = MessedUp.size() - 1; i != e; ++i) {
      if (MessedUp.$at(i) == $$SLASH && MessedUp.$at(i + 1) == $$SLASH) {
        if (JustReplacedNewline) {
          MessedUp.$set(i - 1, $$LF);
        }
        InComment = true;
      } else if (MessedUp.$at(i) == $$HASH && (JustReplacedNewline || i == 0)) {
        if (i != 0) {
          MessedUp.$set(i - 1, $$LF);
        }
        InPreprocessorDirective = true;
      } else if (MessedUp.$at(i) == $$BACK_SLASH && MessedUp.$at(i + 1) == $$LF) {
        MessedUp.$set(i, $$SPACE);
        MessedUp.$set(i + 1, $$SPACE);
      } else if (MessedUp.$at(i) == $$LF) {
        if (InComment) {
          InComment = false;
        } else if (InPreprocessorDirective) {
          InPreprocessorDirective = false;
        } else {
          JustReplacedNewline = true;
          MessedUp.$set(i, $$SPACE);
        }
      } else if (MessedUp.$at(i) != $$SPACE) {
        JustReplacedNewline = false;
      }
    }
    std.string WithoutWhitespace/*J*/= new std.string();
    if (MessedUp.$at(0) != $$SPACE) {
      WithoutWhitespace.push_back(MessedUp.$at(0));
    }
    for (/*uint*/int i = 1, e = MessedUp.size(); i != e; ++i) {
      if (MessedUp.$at(i) != $$SPACE || MessedUp.$at(i - 1) != $$SPACE) {
        WithoutWhitespace.push_back(MessedUp.$at(i));
      }
    }
    return WithoutWhitespace;
  }


}
//} JAVA: end of namespace test // end namespace test
//} JAVA: end of namespace format // end namespace format
//} JAVA: end of namespace clang
} // END OF class FormatTestUtils
