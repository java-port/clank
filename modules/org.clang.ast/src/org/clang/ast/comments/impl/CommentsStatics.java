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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstMemberPointers.*;


//<editor-fold defaultstate="collapsed" desc="static type CommentsStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=Tpl__ZN5clang8comments12_GLOBAL__N_126implements_child_begin_endEMT_KFPKPNS0_7CommentEvE;_ZN5clang8comments12_GLOBAL__N_111findNewlineEPKcS3_;_ZN5clang8comments12_GLOBAL__N_111skipNewlineEPKcS3_;_ZN5clang8comments12_GLOBAL__N_112cleanupBriefERSs;_ZN5clang8comments12_GLOBAL__N_112isWhitespaceEN4llvm9StringRefE;_ZN5clang8comments12_GLOBAL__N_112isWhitespaceEPKcS3_;_ZN5clang8comments12_GLOBAL__N_112isWhitespaceEc;_ZN5clang8comments12_GLOBAL__N_114skipWhitespaceEPKcS3_;_ZN5clang8comments12_GLOBAL__N_115findCCommentEndEPKcS3_;_ZN5clang8comments12_GLOBAL__N_115skipCommandNameEPKcS3_;_ZN5clang8comments12_GLOBAL__N_118findBCPLCommentEndEPKcS3_;_ZN5clang8comments12_GLOBAL__N_118skipHTMLIdentifierEPKcS3_;_ZN5clang8comments12_GLOBAL__N_120skipHTMLQuotedStringEPKcS3_;_ZN5clang8comments12_GLOBAL__N_122isCommandNameCharacterEc;_ZN5clang8comments12_GLOBAL__N_125isHTMLIdentifierCharacterEc;_ZN5clang8comments12_GLOBAL__N_125skipHexCharacterReferenceEPKcS3_;_ZN5clang8comments12_GLOBAL__N_127isCommandNameStartCharacterEc;_ZN5clang8comments12_GLOBAL__N_127skipNamedCharacterReferenceEPKcS3_;_ZN5clang8comments12_GLOBAL__N_128ResolveTParamReferenceHelperEN4llvm9StringRefEPKNS_21TemplateParameterListEPNS2_15SmallVectorImplIjEE;_ZN5clang8comments12_GLOBAL__N_129skipDecimalCharacterReferenceEPKcS3_;_ZN5clang8comments12_GLOBAL__N_133isHTMLIdentifierStartingCharacterEc;_ZN5clang8comments12_GLOBAL__N_134CorrectTypoInTParamReferenceHelperEPKNS_21TemplateParameterListERNS1_19SimpleTypoCorrectorE;_ZN5clang8comments12_GLOBAL__N_1L20CheckCommentASTNodesEv;_ZN5clang8comments12_GLOBAL__N_1L26implements_child_begin_endEMNS0_7CommentEKFPKPS2_vE;_ZN5clang8commentsL21getParamPassDirectionEN4llvm9StringRefE;_ZN5clang8commentsL22convertCodePointToUTF8ERN4llvm20BumpPtrAllocatorImplINS1_15MallocAllocatorELj4096ELj4096EEEj;_ZN5clang8commentsL36isHTMLHexCharacterReferenceCharacterEc;_ZN5clang8commentsL38isHTMLNamedCharacterReferenceCharacterEc;_ZN5clang8commentsL40isHTMLDecimalCharacterReferenceCharacterEc; -static-type=CommentsStatics -package=org.clang.ast.comments.impl")
//</editor-fold>
public final class CommentsStatics {

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::implements_child_begin_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp", line = 41,
 FQN="clang::comments::(anonymous namespace)::implements_child_begin_end", NM="Tpl__ZN5clang8comments12_GLOBAL__N_126implements_child_begin_endEMT_KFPKPNS0_7CommentEvE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=Tpl__ZN5clang8comments12_GLOBAL__N_126implements_child_begin_endEMT_KFPKPNS0_7CommentEvE")
//</editor-fold>
public static </*typename*/ T> good implements_child_begin_end$T(T$getChildrenCommentsIterator<T> $Prm0) {
  return /*delegate*/org.clang.ast.comments.impl.CommentCommentsStatics.
    implements_child_begin_end$T($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::implements_child_begin_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp", line = 45,
 FQN="clang::comments::(anonymous namespace)::implements_child_begin_end", NM="_ZN5clang8comments12_GLOBAL__N_1L26implements_child_begin_endEMNS0_7CommentEKFPKPS2_vE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments12_GLOBAL__N_1L26implements_child_begin_endEMNS0_7CommentEKFPKPS2_vE")
//</editor-fold>
public static /*inline*/ bad implements_child_begin_end(Comment$getChildrenCommentsIterator $Prm0)/* __attribute__((unused))*/ {
  return /*delegate*/org.clang.ast.comments.impl.CommentCommentsStatics.
    implements_child_begin_end($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::CheckCommentASTNodes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp", line = 54,
 FQN="clang::comments::(anonymous namespace)::CheckCommentASTNodes", NM="_ZN5clang8comments12_GLOBAL__N_1L20CheckCommentASTNodesEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments12_GLOBAL__N_1L20CheckCommentASTNodesEv")
//</editor-fold>
public static /*inline*/ void CheckCommentASTNodes()/* __attribute__((unused))*/ {
  /*delegate*/org.clang.ast.comments.impl.CommentCommentsStatics.
    CheckCommentASTNodes();
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isWhitespace">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp", line = 18,
 FQN="clang::comments::(anonymous namespace)::isWhitespace", NM="_ZN5clang8comments12_GLOBAL__N_112isWhitespaceEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp -nm=_ZN5clang8comments12_GLOBAL__N_112isWhitespaceEc")
//</editor-fold>
public static /*inline*/ boolean isWhitespace(/*char*/byte C) {
  return /*delegate*/org.clang.ast.comments.impl.CommentBriefParserCommentsStatics.
    isWhitespace(C);
}


/// Convert all whitespace into spaces, remove leading and trailing spaces,
/// compress multiple spaces into one.
//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::cleanupBrief">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp", line = 25,
 FQN="clang::comments::(anonymous namespace)::cleanupBrief", NM="_ZN5clang8comments12_GLOBAL__N_112cleanupBriefERSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp -nm=_ZN5clang8comments12_GLOBAL__N_112cleanupBriefERSs")
//</editor-fold>
public static void cleanupBrief(final std.string/*&*/ S) {
  /*delegate*/org.clang.ast.comments.impl.CommentBriefParserCommentsStatics.
    cleanupBrief(S);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isWhitespace">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp", line = 48,
 FQN="clang::comments::(anonymous namespace)::isWhitespace", NM="_ZN5clang8comments12_GLOBAL__N_112isWhitespaceEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp -nm=_ZN5clang8comments12_GLOBAL__N_112isWhitespaceEN4llvm9StringRefE")
//</editor-fold>
public static boolean isWhitespace(StringRef Text) {
  return /*delegate*/org.clang.ast.comments.impl.CommentBriefParserCommentsStatics.
    isWhitespace(Text);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::isHTMLNamedCharacterReferenceCharacter">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 28,
 FQN="clang::comments::isHTMLNamedCharacterReferenceCharacter", NM="_ZN5clang8commentsL38isHTMLNamedCharacterReferenceCharacterEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8commentsL38isHTMLNamedCharacterReferenceCharacterEc")
//</editor-fold>
public static /*inline*/ boolean isHTMLNamedCharacterReferenceCharacter(/*char*/byte C) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    isHTMLNamedCharacterReferenceCharacter(C);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::isHTMLDecimalCharacterReferenceCharacter">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 32,
 FQN="clang::comments::isHTMLDecimalCharacterReferenceCharacter", NM="_ZN5clang8commentsL40isHTMLDecimalCharacterReferenceCharacterEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8commentsL40isHTMLDecimalCharacterReferenceCharacterEc")
//</editor-fold>
public static /*inline*/ boolean isHTMLDecimalCharacterReferenceCharacter(/*char*/byte C) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    isHTMLDecimalCharacterReferenceCharacter(C);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::isHTMLHexCharacterReferenceCharacter">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 36,
 FQN="clang::comments::isHTMLHexCharacterReferenceCharacter", NM="_ZN5clang8commentsL36isHTMLHexCharacterReferenceCharacterEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8commentsL36isHTMLHexCharacterReferenceCharacterEc")
//</editor-fold>
public static /*inline*/ boolean isHTMLHexCharacterReferenceCharacter(/*char*/byte C) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    isHTMLHexCharacterReferenceCharacter(C);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::convertCodePointToUTF8">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 40,
 FQN="clang::comments::convertCodePointToUTF8", NM="_ZN5clang8commentsL22convertCodePointToUTF8ERN4llvm20BumpPtrAllocatorImplINS1_15MallocAllocatorELj4096ELj4096EEEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8commentsL22convertCodePointToUTF8ERN4llvm20BumpPtrAllocatorImplINS1_15MallocAllocatorELj4096ELj4096EEEj")
//</editor-fold>
public static /*inline*/ StringRef convertCodePointToUTF8(final BumpPtrAllocatorImpl /*&*/ Allocator, 
                      /*uint*/int CodePoint) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    convertCodePointToUTF8(Allocator, 
                      CodePoint);
}

/// Returns pointer to the first newline character in the string.
//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::findNewline">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 127,
 FQN="clang::comments::(anonymous namespace)::findNewline", NM="_ZN5clang8comments12_GLOBAL__N_111findNewlineEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_111findNewlineEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ findNewline(/*const*/char$ptr/*char P*/ BufferPtr, /*const*/char$ptr/*char P*/ BufferEnd) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    findNewline(BufferPtr, BufferEnd);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::skipNewline">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 135,
 FQN="clang::comments::(anonymous namespace)::skipNewline", NM="_ZN5clang8comments12_GLOBAL__N_111skipNewlineEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_111skipNewlineEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ skipNewline(/*const*/char$ptr/*char P*/ BufferPtr, /*const*/char$ptr/*char P*/ BufferEnd) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    skipNewline(BufferPtr, BufferEnd);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::skipNamedCharacterReference">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 150,
 FQN="clang::comments::(anonymous namespace)::skipNamedCharacterReference", NM="_ZN5clang8comments12_GLOBAL__N_127skipNamedCharacterReferenceEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_127skipNamedCharacterReferenceEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ skipNamedCharacterReference(/*const*/char$ptr/*char P*/ BufferPtr, 
                           /*const*/char$ptr/*char P*/ BufferEnd) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    skipNamedCharacterReference(BufferPtr, 
                           BufferEnd);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::skipDecimalCharacterReference">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 159,
 FQN="clang::comments::(anonymous namespace)::skipDecimalCharacterReference", NM="_ZN5clang8comments12_GLOBAL__N_129skipDecimalCharacterReferenceEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_129skipDecimalCharacterReferenceEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ skipDecimalCharacterReference(/*const*/char$ptr/*char P*/ BufferPtr, 
                             /*const*/char$ptr/*char P*/ BufferEnd) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    skipDecimalCharacterReference(BufferPtr, 
                             BufferEnd);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::skipHexCharacterReference">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 168,
 FQN="clang::comments::(anonymous namespace)::skipHexCharacterReference", NM="_ZN5clang8comments12_GLOBAL__N_125skipHexCharacterReferenceEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_125skipHexCharacterReferenceEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ skipHexCharacterReference(/*const*/char$ptr/*char P*/ BufferPtr, 
                         /*const*/char$ptr/*char P*/ BufferEnd) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    skipHexCharacterReference(BufferPtr, 
                         BufferEnd);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isHTMLIdentifierStartingCharacter">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 177,
 FQN="clang::comments::(anonymous namespace)::isHTMLIdentifierStartingCharacter", NM="_ZN5clang8comments12_GLOBAL__N_133isHTMLIdentifierStartingCharacterEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_133isHTMLIdentifierStartingCharacterEc")
//</editor-fold>
public static boolean isHTMLIdentifierStartingCharacter(/*char*/byte C) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    isHTMLIdentifierStartingCharacter(C);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isHTMLIdentifierCharacter">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 181,
 FQN="clang::comments::(anonymous namespace)::isHTMLIdentifierCharacter", NM="_ZN5clang8comments12_GLOBAL__N_125isHTMLIdentifierCharacterEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_125isHTMLIdentifierCharacterEc")
//</editor-fold>
public static boolean isHTMLIdentifierCharacter(/*char*/byte C) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    isHTMLIdentifierCharacter(C);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::skipHTMLIdentifier">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 185,
 FQN="clang::comments::(anonymous namespace)::skipHTMLIdentifier", NM="_ZN5clang8comments12_GLOBAL__N_118skipHTMLIdentifierEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_118skipHTMLIdentifierEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ skipHTMLIdentifier(/*const*/char$ptr/*char P*/ BufferPtr, /*const*/char$ptr/*char P*/ BufferEnd) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    skipHTMLIdentifier(BufferPtr, BufferEnd);
}


/// Skip HTML string quoted in single or double quotes.  Escaping quotes inside
/// string allowed.
///
/// Returns pointer to closing quote.
//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::skipHTMLQuotedString">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 197,
 FQN="clang::comments::(anonymous namespace)::skipHTMLQuotedString", NM="_ZN5clang8comments12_GLOBAL__N_120skipHTMLQuotedStringEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_120skipHTMLQuotedStringEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ skipHTMLQuotedString(/*const*/char$ptr/*char P*/ BufferPtr, /*const*/char$ptr/*char P*/ BufferEnd) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    skipHTMLQuotedString(BufferPtr, BufferEnd);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::skipWhitespace">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 211,
 FQN="clang::comments::(anonymous namespace)::skipWhitespace", NM="_ZN5clang8comments12_GLOBAL__N_114skipWhitespaceEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_114skipWhitespaceEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ skipWhitespace(/*const*/char$ptr/*char P*/ BufferPtr, /*const*/char$ptr/*char P*/ BufferEnd) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    skipWhitespace(BufferPtr, BufferEnd);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isWhitespace">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 219,
 FQN="clang::comments::(anonymous namespace)::isWhitespace", NM="_ZN5clang8comments12_GLOBAL__N_112isWhitespaceEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_112isWhitespaceEPKcS3_")
//</editor-fold>
public static boolean isWhitespace(/*const*/char$ptr/*char P*/ BufferPtr, /*const*/char$ptr/*char P*/ BufferEnd) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    isWhitespace(BufferPtr, BufferEnd);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isCommandNameStartCharacter">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 223,
 FQN="clang::comments::(anonymous namespace)::isCommandNameStartCharacter", NM="_ZN5clang8comments12_GLOBAL__N_127isCommandNameStartCharacterEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_127isCommandNameStartCharacterEc")
//</editor-fold>
public static boolean isCommandNameStartCharacter(/*char*/byte C) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    isCommandNameStartCharacter(C);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isCommandNameCharacter">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 227,
 FQN="clang::comments::(anonymous namespace)::isCommandNameCharacter", NM="_ZN5clang8comments12_GLOBAL__N_122isCommandNameCharacterEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_122isCommandNameCharacterEc")
//</editor-fold>
public static boolean isCommandNameCharacter(/*char*/byte C) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    isCommandNameCharacter(C);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::skipCommandName">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 231,
 FQN="clang::comments::(anonymous namespace)::skipCommandName", NM="_ZN5clang8comments12_GLOBAL__N_115skipCommandNameEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_115skipCommandNameEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ skipCommandName(/*const*/char$ptr/*char P*/ BufferPtr, /*const*/char$ptr/*char P*/ BufferEnd) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    skipCommandName(BufferPtr, BufferEnd);
}


/// Return the one past end pointer for BCPL comments.
/// Handles newlines escaped with backslash or trigraph for backslahs.
//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::findBCPLCommentEnd">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 241,
 FQN="clang::comments::(anonymous namespace)::findBCPLCommentEnd", NM="_ZN5clang8comments12_GLOBAL__N_118findBCPLCommentEndEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_118findBCPLCommentEndEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ findBCPLCommentEnd(/*const*/char$ptr/*char P*/ BufferPtr, /*const*/char$ptr/*char P*/ BufferEnd) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    findBCPLCommentEnd(BufferPtr, BufferEnd);
}


/// Return the one past end pointer for C comments.
/// Very dumb, does not handle escaped newlines or trigraphs.
//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::findCCommentEnd">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 267,
 FQN="clang::comments::(anonymous namespace)::findCCommentEnd", NM="_ZN5clang8comments12_GLOBAL__N_115findCCommentEndEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_115findCCommentEndEPKcS3_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ findCCommentEnd(/*const*/char$ptr/*char P*/ BufferPtr, /*const*/char$ptr/*char P*/ BufferEnd) {
  return /*delegate*/org.clang.ast.comments.impl.CommentLexerCommentsStatics.
    findCCommentEnd(BufferPtr, BufferEnd);
}


/// \brief Turn a string into the corresponding PassDirection or -1 if it's not
/// valid.
//<editor-fold defaultstate="collapsed" desc="clang::comments::getParamPassDirection">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 220,
 FQN="clang::comments::getParamPassDirection", NM="_ZN5clang8commentsL21getParamPassDirectionEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8commentsL21getParamPassDirectionEN4llvm9StringRefE")
//</editor-fold>
public static int getParamPassDirection(StringRef Arg) {
  return /*delegate*/org.clang.ast.comments.impl.CommentSemaCommentsStatics.
    getParamPassDirection(Arg);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::ResolveTParamReferenceHelper">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 1018,
 FQN="clang::comments::(anonymous namespace)::ResolveTParamReferenceHelper", NM="_ZN5clang8comments12_GLOBAL__N_128ResolveTParamReferenceHelperEN4llvm9StringRefEPKNS_21TemplateParameterListEPNS2_15SmallVectorImplIjEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments12_GLOBAL__N_128ResolveTParamReferenceHelperEN4llvm9StringRefEPKNS_21TemplateParameterListEPNS2_15SmallVectorImplIjEE")
//</editor-fold>
public static boolean ResolveTParamReferenceHelper(StringRef Name, 
                            /*const*/ TemplateParameterList /*P*/ TemplateParameters, 
                            SmallVectorImplUInt/*P*/ Position) {
  return /*delegate*/org.clang.ast.comments.impl.CommentSemaCommentsStatics.
    ResolveTParamReferenceHelper(Name, 
                            TemplateParameters, 
                            Position);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::CorrectTypoInTParamReferenceHelper">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 1055,
 FQN="clang::comments::(anonymous namespace)::CorrectTypoInTParamReferenceHelper", NM="_ZN5clang8comments12_GLOBAL__N_134CorrectTypoInTParamReferenceHelperEPKNS_21TemplateParameterListERNS1_19SimpleTypoCorrectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments12_GLOBAL__N_134CorrectTypoInTParamReferenceHelperEPKNS_21TemplateParameterListERNS1_19SimpleTypoCorrectorE")
//</editor-fold>
public static void CorrectTypoInTParamReferenceHelper(/*const*/ TemplateParameterList /*P*/ TemplateParameters, 
                                  final SimpleTypoCorrector /*&*/ Corrector) {
  /*delegate*/org.clang.ast.comments.impl.CommentSemaCommentsStatics.
    CorrectTypoInTParamReferenceHelper(TemplateParameters, 
                                  Corrector);
}

} // END OF class CommentsStatics
