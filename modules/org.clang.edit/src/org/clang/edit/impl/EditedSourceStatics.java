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
package org.clang.edit.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.edit.*;
import org.clang.lex.*;


//<editor-fold defaultstate="collapsed" desc="static type EditedSourceStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZL11canBeJoinedccRKN5clang11LangOptionsE;_ZL12applyRewriteRN5clang4edit13EditsReceiverEN4llvm9StringRefENS0_10FileOffsetEjRKNS_13SourceManagerERKNS_11LangOptionsE;_ZL13adjustRemovalRKN5clang13SourceManagerERKNS_11LangOptionsENS_14SourceLocationENS_4edit10FileOffsetERjRN4llvm9StringRefE;_ZL19canRemoveWhitespacecccRKN5clang11LangOptionsE; -static-type=EditedSourceStatics -package=org.clang.edit.impl")
//</editor-fold>
public final class EditedSourceStatics {


// \brief Returns true if it is ok to make the two given characters adjacent.
//<editor-fold defaultstate="collapsed" desc="canBeJoined">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 296,
 FQN="canBeJoined", NM="_ZL11canBeJoinedccRKN5clang11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZL11canBeJoinedccRKN5clang11LangOptionsE")
//</editor-fold>
public static boolean canBeJoined(/*char*/byte left, /*char*/byte right, /*const*/ LangOptions /*&*/ LangOpts) {
  // FIXME: Should use TokenConcatenation to make sure we don't allow stuff like
  // making two '<' adjacent.
  return !(Lexer.isIdentifierBodyChar(left, LangOpts)
     && Lexer.isIdentifierBodyChar(right, LangOpts));
}


/// \brief Returns true if it is ok to eliminate the trailing whitespace between
/// the given characters.
//<editor-fold defaultstate="collapsed" desc="canRemoveWhitespace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 305,
 FQN="canRemoveWhitespace", NM="_ZL19canRemoveWhitespacecccRKN5clang11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZL19canRemoveWhitespacecccRKN5clang11LangOptionsE")
//</editor-fold>
public static boolean canRemoveWhitespace(/*char*/byte left, /*char*/byte beforeWSpace, /*char*/byte right, 
                   /*const*/ LangOptions /*&*/ LangOpts) {
  if (!canBeJoined(left, right, LangOpts)) {
    return false;
  }
  if (isWhitespace(left) || isWhitespace(right)) {
    return true;
  }
  if (canBeJoined(beforeWSpace, right, LangOpts)) {
    return false; // the whitespace was intentional, keep it.
  }
  return true;
}


/// \brief Check the range that we are going to remove and:
/// -Remove any trailing whitespace if possible.
/// -Insert a space if removing the range is going to mess up the source tokens.
//<editor-fold defaultstate="collapsed" desc="adjustRemoval">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 319,
 FQN="adjustRemoval", NM="_ZL13adjustRemovalRKN5clang13SourceManagerERKNS_11LangOptionsENS_14SourceLocationENS_4edit10FileOffsetERjRN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZL13adjustRemovalRKN5clang13SourceManagerERKNS_11LangOptionsENS_14SourceLocationENS_4edit10FileOffsetERjRN4llvm9StringRefE")
//</editor-fold>
public static void adjustRemoval(/*const*/ SourceManager /*&*/ SM, /*const*/ LangOptions /*&*/ LangOpts, 
             SourceLocation Loc, FileOffset offs, 
             uint$ref/*uint &*/ len, StringRef /*&*/ text) {
  assert ((len.$deref() != 0) && text.empty());
  SourceLocation BeginTokLoc = Lexer.GetBeginningOfToken(new SourceLocation(Loc), SM, LangOpts);
  if ($noteq_SourceLocation$C(BeginTokLoc, Loc)) {
    return; // the range is not at the beginning of a token, keep the range.
  }
  
  // JAVA: PERF
  bool$ptr Invalid = null; //create_bool$ptr(false);
  StringRef buffer = SM.getBufferData(offs.getFID(), /*AddrOf*/Invalid);
  if (/*JAVA: PERF*/buffer == SourceManager.INVALID_BUFFER_DATA/*Invalid.$star()*/) {
    return;
  }
  
  /*uint*/int begin = offs.getOffset();
  /*uint*/int end = begin + len.$deref();
  
  // Do not try to extend the removal if we're at the end of the buffer already.
  if (end == buffer.size()) {
    return;
  }
  assert ($less_uint(begin, buffer.size()) && $less_uint(end, buffer.size())) : "Invalid range!";
  
  // FIXME: Remove newline.
  if (begin == 0) {
    if (buffer.$at(end) == $$SPACE) {
      len.$set$preInc();
    }
    return;
  }
  if (buffer.$at(end) == $$SPACE) {
    assert ((end + 1 != buffer.size() || buffer.data().$at(end + 1) == 0)) : "buffer not zero-terminated!";
    if (canRemoveWhitespace(/*left=*/ buffer.$at(begin - 1), 
        /*beforeWSpace=*/ buffer.$at(end - 1), 
        /*right=*/ buffer.data().$at(end + 1),  // zero-terminated
        LangOpts)) {
      len.$set$preInc();
    }
    return;
  }
  if (!canBeJoined(buffer.$at(begin - 1), buffer.$at(end), LangOpts)) {
    text.$assignMove(/*STRINGREF_STR*/$SPACE);
  }
}

//<editor-fold defaultstate="collapsed" desc="applyRewrite">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 364,
 FQN="applyRewrite", NM="_ZL12applyRewriteRN5clang4edit13EditsReceiverEN4llvm9StringRefENS0_10FileOffsetEjRKNS_13SourceManagerERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZL12applyRewriteRN5clang4edit13EditsReceiverEN4llvm9StringRefENS0_10FileOffsetEjRKNS_13SourceManagerERKNS_11LangOptionsE")
//</editor-fold>
public static void applyRewrite(EditsReceiver /*&*/ receiver, 
            StringRef text, FileOffset offs, /*uint*/int len, 
            /*const*/ SourceManager /*&*/ SM, /*const*/ LangOptions /*&*/ LangOpts) {
  assert (offs.getFID().isValid());
  SourceLocation Loc = SM.getLocForStartOfFile(offs.getFID());
  Loc.$assignMove(Loc.getLocWithOffset(offs.getOffset()));
  assert (Loc.isFileID());
  if (text.empty()) {
    uint$ref $len = create_uint$ref(len);
    adjustRemoval(SM, LangOpts, new SourceLocation(Loc), new FileOffset(offs), $len, text);
    len = $len.$deref();
  }
  
  CharSourceRange range = CharSourceRange.getCharRange(/*NO_COPY*/Loc, 
      Loc.getLocWithOffset(len));
  if (text.empty()) {
    assert (len != 0);
    receiver.remove(new CharSourceRange(range));
    return;
  }
  if ((len != 0)) {
    receiver.replace(new CharSourceRange(range), new StringRef(text));
  } else {
    receiver.insert(new SourceLocation(Loc), new StringRef(text));
  }
}

} // END OF class EditedSourceStatics
