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
package org.clang.ast.comments.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="static type CommentBriefParserCommentsStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp -nm=_ZN5clang8comments12_GLOBAL__N_112cleanupBriefERSs;_ZN5clang8comments12_GLOBAL__N_112isWhitespaceEN4llvm9StringRefE;_ZN5clang8comments12_GLOBAL__N_112isWhitespaceEc; -static-type=CommentBriefParserCommentsStatics -package=org.clang.ast.comments.impl")
//</editor-fold>
public final class CommentBriefParserCommentsStatics {

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isWhitespace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp", line = 18,
 FQN="clang::comments::(anonymous namespace)::isWhitespace", NM="_ZN5clang8comments12_GLOBAL__N_112isWhitespaceEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp -nm=_ZN5clang8comments12_GLOBAL__N_112isWhitespaceEc")
//</editor-fold>
public static /*inline*/ boolean isWhitespace(/*char*/byte C) {
  return C == $$SPACE || C == $$LF || C == $$CR
     || C == $$TAB || C == $$FF || C == $$VTAB;
}


/// Convert all whitespace into spaces, remove leading and trailing spaces,
/// compress multiple spaces into one.
//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::cleanupBrief">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp", line = 25,
 FQN="clang::comments::(anonymous namespace)::cleanupBrief", NM="_ZN5clang8comments12_GLOBAL__N_112cleanupBriefERSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp -nm=_ZN5clang8comments12_GLOBAL__N_112cleanupBriefERSs")
//</editor-fold>
public static void cleanupBrief(final std.string/*&*/ S) {
  boolean PrevWasSpace = true;
  char$ptr begin = S.begin();
  char$ptr/*char P*/ O = S.begin();
  for (char$ptr/*char P*/ I = S.begin(), E = S.end();
       $noteq___normal_iterator$C(I, E); I.$preInc()) {
    /*const*//*char*/byte C = I.$star();
    if (isWhitespace(C)) {
      if (!PrevWasSpace) {
        O.$postInc(0).$set($$SPACE);
        PrevWasSpace = true;
      }
      continue;
    } else {
      O.$postInc(0).$set(C);
      PrevWasSpace = false;
    }
  }
  if ($noteq___normal_iterator$C(O, S.begin()) && (O.$sub(1)).$star() == $$SPACE) {
    O.$preDec();
  }
  
  S.resize($sub___normal_iterator$C(O, S.begin()));
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isWhitespace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp", line = 48,
 FQN="clang::comments::(anonymous namespace)::isWhitespace", NM="_ZN5clang8comments12_GLOBAL__N_112isWhitespaceEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp -nm=_ZN5clang8comments12_GLOBAL__N_112isWhitespaceEN4llvm9StringRefE")
//</editor-fold>
public static boolean isWhitespace(StringRef Text) {
  for (char$ptr I = $tryClone(Text.begin()), /*P*/ E = $tryClone(Text.end());
       $noteq_ptr(I, E); I.$preInc()) {
    if (!isWhitespace(I.$star())) {
      return false;
    }
  }
  return true;
}

} // END OF class CommentBriefParserCommentsStatics
