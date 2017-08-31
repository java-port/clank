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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.llvm.support.ConvertUTFGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type CommentLexerCommentsStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_111findNewlineEPKcS3_;_ZN5clang8comments12_GLOBAL__N_111skipNewlineEPKcS3_;_ZN5clang8comments12_GLOBAL__N_112isWhitespaceEPKcS3_;_ZN5clang8comments12_GLOBAL__N_114skipWhitespaceEPKcS3_;_ZN5clang8comments12_GLOBAL__N_115findCCommentEndEPKcS3_;_ZN5clang8comments12_GLOBAL__N_115skipCommandNameEPKcS3_;_ZN5clang8comments12_GLOBAL__N_118findBCPLCommentEndEPKcS3_;_ZN5clang8comments12_GLOBAL__N_118skipHTMLIdentifierEPKcS3_;_ZN5clang8comments12_GLOBAL__N_120skipHTMLQuotedStringEPKcS3_;_ZN5clang8comments12_GLOBAL__N_122isCommandNameCharacterEc;_ZN5clang8comments12_GLOBAL__N_125isHTMLIdentifierCharacterEc;_ZN5clang8comments12_GLOBAL__N_125skipHexCharacterReferenceEPKcS3_;_ZN5clang8comments12_GLOBAL__N_127isCommandNameStartCharacterEc;_ZN5clang8comments12_GLOBAL__N_127skipNamedCharacterReferenceEPKcS3_;_ZN5clang8comments12_GLOBAL__N_129skipDecimalCharacterReferenceEPKcS3_;_ZN5clang8comments12_GLOBAL__N_133isHTMLIdentifierStartingCharacterEc;_ZN5clang8commentsL22convertCodePointToUTF8ERN4llvm20BumpPtrAllocatorImplINS1_15MallocAllocatorELj4096ELj4096EEEj;_ZN5clang8commentsL36isHTMLHexCharacterReferenceCharacterEc;_ZN5clang8commentsL38isHTMLNamedCharacterReferenceCharacterEc;_ZN5clang8commentsL40isHTMLDecimalCharacterReferenceCharacterEc; -static-type=CommentLexerCommentsStatics -package=org.clang.ast.comments.impl")
//</editor-fold>
public final class CommentLexerCommentsStatics {

//<editor-fold defaultstate="collapsed" desc="clang::comments::isHTMLNamedCharacterReferenceCharacter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 28,
 FQN="clang::comments::isHTMLNamedCharacterReferenceCharacter", NM="_ZN5clang8commentsL38isHTMLNamedCharacterReferenceCharacterEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8commentsL38isHTMLNamedCharacterReferenceCharacterEc")
//</editor-fold>
public static /*inline*/ boolean isHTMLNamedCharacterReferenceCharacter(/*char*/byte C) {
  return isLetter(C);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::isHTMLDecimalCharacterReferenceCharacter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 32,
 FQN="clang::comments::isHTMLDecimalCharacterReferenceCharacter", NM="_ZN5clang8commentsL40isHTMLDecimalCharacterReferenceCharacterEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8commentsL40isHTMLDecimalCharacterReferenceCharacterEc")
//</editor-fold>
public static /*inline*/ boolean isHTMLDecimalCharacterReferenceCharacter(/*char*/byte C) {
  return isDigit(C);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::isHTMLHexCharacterReferenceCharacter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 36,
 FQN="clang::comments::isHTMLHexCharacterReferenceCharacter", NM="_ZN5clang8commentsL36isHTMLHexCharacterReferenceCharacterEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8commentsL36isHTMLHexCharacterReferenceCharacterEc")
//</editor-fold>
public static /*inline*/ boolean isHTMLHexCharacterReferenceCharacter(/*char*/byte C) {
  return isHexDigit(C);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::convertCodePointToUTF8">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 40,
 FQN="clang::comments::convertCodePointToUTF8", NM="_ZN5clang8commentsL22convertCodePointToUTF8ERN4llvm20BumpPtrAllocatorImplINS1_15MallocAllocatorELj4096ELj4096EEEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8commentsL22convertCodePointToUTF8ERN4llvm20BumpPtrAllocatorImplINS1_15MallocAllocatorELj4096ELj4096EEEj")
//</editor-fold>
public static /*inline*/ StringRef convertCodePointToUTF8(final BumpPtrAllocatorImpl /*&*/ Allocator, 
                      /*uint*/int CodePoint) {
  char$ptr/*char P*/ Resolved = Allocator./*<byte>*/Allocate/*$T*/(UNI_MAX_UTF8_BYTES_PER_CODE_POINT);
  type$ref<char$ptr>/*char P*/ ResolvedPtr = create_type$ref(Resolved);
  if (llvm.ConvertCodePointToUTF8(CodePoint, ResolvedPtr)) {
    return new StringRef(Resolved, ResolvedPtr.$deref().$sub(Resolved));
  } else {
    return new StringRef();
  }
}

/// Returns pointer to the first newline character in the string.
//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::findNewline">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$tryClone*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 127,
 FQN="clang::comments::(anonymous namespace)::findNewline", NM="_ZN5clang8comments12_GLOBAL__N_111findNewlineEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_111findNewlineEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ findNewline(/*const*/char$ptr/*char P*/ BufferPtr, /*const*/char$ptr/*char P*/ BufferEnd) {
  BufferPtr = $tryClone(BufferPtr);
  for (; $noteq_ptr(BufferPtr, BufferEnd); BufferPtr.$preInc()) {
    if (isVerticalWhitespace(BufferPtr.$star())) {
      return BufferPtr;
    }
  }
  return BufferEnd;
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::skipNewline">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$tryClone*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 135,
 FQN="clang::comments::(anonymous namespace)::skipNewline", NM="_ZN5clang8comments12_GLOBAL__N_111skipNewlineEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_111skipNewlineEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ skipNewline(/*const*/char$ptr/*char P*/ BufferPtr, /*const*/char$ptr/*char P*/ BufferEnd) {
  BufferPtr = $tryClone(BufferPtr);
  if ($eq_ptr(BufferPtr, BufferEnd)) {
    return BufferPtr;
  }
  if (BufferPtr.$star() == $$LF) {
    BufferPtr.$postInc();
  } else {
    assert (BufferPtr.$star() == $$CR);
    BufferPtr.$postInc();
    if ($noteq_ptr(BufferPtr, BufferEnd) && BufferPtr.$star() == $$LF) {
      BufferPtr.$postInc();
    }
  }
  return BufferPtr;
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::skipNamedCharacterReference">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$tryClone*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 150,
 FQN="clang::comments::(anonymous namespace)::skipNamedCharacterReference", NM="_ZN5clang8comments12_GLOBAL__N_127skipNamedCharacterReferenceEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_127skipNamedCharacterReferenceEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ skipNamedCharacterReference(/*const*/char$ptr/*char P*/ BufferPtr, 
                           /*const*/char$ptr/*char P*/ BufferEnd) {
  BufferPtr = $tryClone(BufferPtr);
  for (; $noteq_ptr(BufferPtr, BufferEnd); BufferPtr.$preInc()) {
    if (!isHTMLNamedCharacterReferenceCharacter(BufferPtr.$star())) {
      return BufferPtr;
    }
  }
  return BufferEnd;
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::skipDecimalCharacterReference">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$tryClone*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 159,
 FQN="clang::comments::(anonymous namespace)::skipDecimalCharacterReference", NM="_ZN5clang8comments12_GLOBAL__N_129skipDecimalCharacterReferenceEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_129skipDecimalCharacterReferenceEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ skipDecimalCharacterReference(/*const*/char$ptr/*char P*/ BufferPtr, 
                             /*const*/char$ptr/*char P*/ BufferEnd) {
  BufferPtr = $tryClone(BufferPtr);
  for (; $noteq_ptr(BufferPtr, BufferEnd); BufferPtr.$preInc()) {
    if (!isHTMLDecimalCharacterReferenceCharacter(BufferPtr.$star())) {
      return BufferPtr;
    }
  }
  return BufferEnd;
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::skipHexCharacterReference">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$tryClone*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 168,
 FQN="clang::comments::(anonymous namespace)::skipHexCharacterReference", NM="_ZN5clang8comments12_GLOBAL__N_125skipHexCharacterReferenceEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_125skipHexCharacterReferenceEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ skipHexCharacterReference(/*const*/char$ptr/*char P*/ BufferPtr, 
                         /*const*/char$ptr/*char P*/ BufferEnd) {
  BufferPtr = $tryClone(BufferPtr);
  for (; $noteq_ptr(BufferPtr, BufferEnd); BufferPtr.$preInc()) {
    if (!isHTMLHexCharacterReferenceCharacter(BufferPtr.$star())) {
      return BufferPtr;
    }
  }
  return BufferEnd;
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isHTMLIdentifierStartingCharacter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 177,
 FQN="clang::comments::(anonymous namespace)::isHTMLIdentifierStartingCharacter", NM="_ZN5clang8comments12_GLOBAL__N_133isHTMLIdentifierStartingCharacterEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_133isHTMLIdentifierStartingCharacterEc")
//</editor-fold>
public static boolean isHTMLIdentifierStartingCharacter(/*char*/byte C) {
  return isLetter(C);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isHTMLIdentifierCharacter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 181,
 FQN="clang::comments::(anonymous namespace)::isHTMLIdentifierCharacter", NM="_ZN5clang8comments12_GLOBAL__N_125isHTMLIdentifierCharacterEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_125isHTMLIdentifierCharacterEc")
//</editor-fold>
public static boolean isHTMLIdentifierCharacter(/*char*/byte C) {
  return isAlphanumeric(C);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::skipHTMLIdentifier">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$tryClone*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 185,
 FQN="clang::comments::(anonymous namespace)::skipHTMLIdentifier", NM="_ZN5clang8comments12_GLOBAL__N_118skipHTMLIdentifierEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_118skipHTMLIdentifierEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ skipHTMLIdentifier(/*const*/char$ptr/*char P*/ BufferPtr, /*const*/char$ptr/*char P*/ BufferEnd) {
  BufferPtr = $tryClone(BufferPtr);
  for (; $noteq_ptr(BufferPtr, BufferEnd); BufferPtr.$preInc()) {
    if (!isHTMLIdentifierCharacter(BufferPtr.$star())) {
      return BufferPtr;
    }
  }
  return BufferEnd;
}


/// Skip HTML string quoted in single or double quotes.  Escaping quotes inside
/// string allowed.
///
/// Returns pointer to closing quote.
//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::skipHTMLQuotedString">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$tryClone*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 197,
 FQN="clang::comments::(anonymous namespace)::skipHTMLQuotedString", NM="_ZN5clang8comments12_GLOBAL__N_120skipHTMLQuotedStringEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_120skipHTMLQuotedStringEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ skipHTMLQuotedString(/*const*/char$ptr/*char P*/ BufferPtr, /*const*/char$ptr/*char P*/ BufferEnd) {
  BufferPtr = $tryClone(BufferPtr);
  /*const*//*char*/byte Quote = BufferPtr.$star();
  assert (Quote == $$DBL_QUOTE || Quote == $$SGL_QUOTE);
  
  BufferPtr.$postInc();
  for (; $noteq_ptr(BufferPtr, BufferEnd); BufferPtr.$preInc()) {
    /*const*//*char*/byte C = BufferPtr.$star();
    if (C == Quote && BufferPtr.$at(-1) != $$BACK_SLASH) {
      return BufferPtr;
    }
  }
  return BufferEnd;
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::skipWhitespace">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$tryClone*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 211,
 FQN="clang::comments::(anonymous namespace)::skipWhitespace", NM="_ZN5clang8comments12_GLOBAL__N_114skipWhitespaceEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_114skipWhitespaceEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ skipWhitespace(/*const*/char$ptr/*char P*/ BufferPtr, /*const*/char$ptr/*char P*/ BufferEnd) {
  BufferPtr = $tryClone(BufferPtr);
  for (; $noteq_ptr(BufferPtr, BufferEnd); BufferPtr.$preInc()) {
    if (!BasicClangGlobals.isWhitespace(BufferPtr.$star())) {
      return BufferPtr;
    }
  }
  return BufferEnd;
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isWhitespace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 219,
 FQN="clang::comments::(anonymous namespace)::isWhitespace", NM="_ZN5clang8comments12_GLOBAL__N_112isWhitespaceEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_112isWhitespaceEPKcS3_")
//</editor-fold>
public static boolean isWhitespace(/*const*/char$ptr/*char P*/ BufferPtr, /*const*/char$ptr/*char P*/ BufferEnd) {
  return $eq_ptr(skipWhitespace(BufferPtr, BufferEnd), BufferEnd);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isCommandNameStartCharacter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 223,
 FQN="clang::comments::(anonymous namespace)::isCommandNameStartCharacter", NM="_ZN5clang8comments12_GLOBAL__N_127isCommandNameStartCharacterEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_127isCommandNameStartCharacterEc")
//</editor-fold>
public static boolean isCommandNameStartCharacter(/*char*/byte C) {
  return isLetter(C);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isCommandNameCharacter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 227,
 FQN="clang::comments::(anonymous namespace)::isCommandNameCharacter", NM="_ZN5clang8comments12_GLOBAL__N_122isCommandNameCharacterEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_122isCommandNameCharacterEc")
//</editor-fold>
public static boolean isCommandNameCharacter(/*char*/byte C) {
  return isAlphanumeric(C);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::skipCommandName">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$tryClone*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 231,
 FQN="clang::comments::(anonymous namespace)::skipCommandName", NM="_ZN5clang8comments12_GLOBAL__N_115skipCommandNameEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_115skipCommandNameEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ skipCommandName(/*const*/char$ptr/*char P*/ BufferPtr, /*const*/char$ptr/*char P*/ BufferEnd) {
  BufferPtr = $tryClone(BufferPtr);
  for (; $noteq_ptr(BufferPtr, BufferEnd); BufferPtr.$preInc()) {
    if (!isCommandNameCharacter(BufferPtr.$star())) {
      return BufferPtr;
    }
  }
  return BufferEnd;
}


/// Return the one past end pointer for BCPL comments.
/// Handles newlines escaped with backslash or trigraph for backslahs.
//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::findBCPLCommentEnd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 241,
 FQN="clang::comments::(anonymous namespace)::findBCPLCommentEnd", NM="_ZN5clang8comments12_GLOBAL__N_118findBCPLCommentEndEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_118findBCPLCommentEndEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ findBCPLCommentEnd(/*const*/char$ptr/*char P*/ BufferPtr, /*const*/char$ptr/*char P*/ BufferEnd) {
  /*const*/char$ptr/*char P*/ CurPtr = $tryClone(BufferPtr);
  while ($noteq_ptr(CurPtr, BufferEnd)) {
    while (!isVerticalWhitespace(CurPtr.$star())) {
      CurPtr.$postInc();
      if ($eq_ptr(CurPtr, BufferEnd)) {
        return BufferEnd;
      }
    }
    // We found a newline, check if it is escaped.
    /*const*/char$ptr/*char P*/ EscapePtr = $tryClone(CurPtr.$sub(1));
    while (isHorizontalWhitespace(EscapePtr.$star())) {
      EscapePtr.$postDec();
    }
    if (EscapePtr.$star() == $$BACK_SLASH
       || (EscapePtr.$sub(2).$greatereq(BufferPtr) && EscapePtr.$at(0) == $$SLASH
       && EscapePtr.$at(-1) == $$QMARK && EscapePtr.$at(-2) == $$QMARK)) {
      // We found an escaped newline.
      CurPtr = $tryClone(skipNewline(CurPtr, BufferEnd));
    } else {
      return CurPtr; // Not an escaped newline.
    }
  }
  return BufferEnd;
}


/// Return the one past end pointer for C comments.
/// Very dumb, does not handle escaped newlines or trigraphs.
//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::findCCommentEnd">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$tryClone*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 267,
 FQN="clang::comments::(anonymous namespace)::findCCommentEnd", NM="_ZN5clang8comments12_GLOBAL__N_115findCCommentEndEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_115findCCommentEndEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ findCCommentEnd(/*const*/char$ptr/*char P*/ BufferPtr, /*const*/char$ptr/*char P*/ BufferEnd) {
  BufferPtr = $tryClone(BufferPtr);
  for (; $noteq_ptr(BufferPtr, BufferEnd); BufferPtr.$preInc()) {
    if (BufferPtr.$star() == $$STAR) {
      assert ($noteq_ptr(BufferPtr.$add(1), BufferEnd));
      if ((BufferPtr.$add(1)).$star() == $$SLASH) {
        return BufferPtr;
      }
    }
  }
  throw new llvm_unreachable("buffer end hit before '*/' was seen");
}

} // END OF class CommentLexerCommentsStatics
