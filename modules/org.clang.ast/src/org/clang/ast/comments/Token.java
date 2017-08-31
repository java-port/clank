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

package org.clang.ast.comments;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
//import org.clang.lex.Token;

// end namespace tok

/// \brief Comment token.
//<editor-fold defaultstate="collapsed" desc="clang::comments::Token">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 57,
 FQN="clang::comments::Token", NM="_ZN5clang8comments5TokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5TokenE")
//</editor-fold>
public class Token implements NativePOD<Token> {
  /*friend  class Lexer*/
  /*friend  class TextTokenRetokenizer*/
  
  /// The location of the token.
  private SourceLocation Loc;
  
  /// The actual kind of the token.
  private tok.TokenKind Kind;
  
  /// Length of the token spelling in comment.  Can be 0 for synthenized
  /// tokens.
  private /*uint*/int Length;
  
  /// Contains text value associated with a token.
  public/*friend*//*private*/ /*const*/char$ptr/*char P*/ TextPtr;
  
  /// Integer value associated with a token.
  ///
  /// If the token is a konwn command, contains command ID and TextPtr is
  /// unused (command spelling can be found with CommandTraits).  Otherwise,
  /// contains the length of the string that starts at TextPtr.
  public/*friend*//*private*/ /*uint*/int IntVal;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 82,
   FQN="clang::comments::Token::getLocation", NM="_ZNK5clang8comments5Token11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Token11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::setLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 83,
   FQN="clang::comments::Token::setLocation", NM="_ZN5clang8comments5Token11setLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Token11setLocationENS_14SourceLocationE")
  //</editor-fold>
  public void setLocation(SourceLocation SL) {
    Loc.$assign(SL);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::getEndLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 85,
   FQN="clang::comments::Token::getEndLocation", NM="_ZNK5clang8comments5Token14getEndLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Token14getEndLocationEv")
  //</editor-fold>
  public SourceLocation getEndLocation() /*const*//* __attribute__((pure))*/ {
    if (Length == 0 || Length == 1) {
      return new SourceLocation(Loc);
    }
    return Loc.getLocWithOffset(Length - 1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 91,
   FQN="clang::comments::Token::getKind", NM="_ZNK5clang8comments5Token7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Token7getKindEv")
  //</editor-fold>
  public tok.TokenKind getKind() /*const*//* __attribute__((pure))*/ {
    return Kind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::setKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 92,
   FQN="clang::comments::Token::setKind", NM="_ZN5clang8comments5Token7setKindENS0_3tok9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Token7setKindENS0_3tok9TokenKindE")
  //</editor-fold>
  public void setKind(tok.TokenKind K) {
    Kind = K;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::is">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 94,
   FQN="clang::comments::Token::is", NM="_ZNK5clang8comments5Token2isENS0_3tok9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Token2isENS0_3tok9TokenKindE")
  //</editor-fold>
  public boolean is(tok.TokenKind K) /*const*//* __attribute__((pure))*/ {
    return Kind == K;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::isNot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 95,
   FQN="clang::comments::Token::isNot", NM="_ZNK5clang8comments5Token5isNotENS0_3tok9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Token5isNotENS0_3tok9TokenKindE")
  //</editor-fold>
  public boolean isNot(tok.TokenKind K) /*const*//* __attribute__((pure))*/ {
    return Kind != K;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::getLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 97,
   FQN="clang::comments::Token::getLength", NM="_ZNK5clang8comments5Token9getLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Token9getLengthEv")
  //</editor-fold>
  public /*uint*/int getLength() /*const*//* __attribute__((pure))*/ {
    return Length;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::setLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 98,
   FQN="clang::comments::Token::setLength", NM="_ZN5clang8comments5Token9setLengthEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Token9setLengthEj")
  //</editor-fold>
  public void setLength(/*uint*/int L) {
    Length = L;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::getText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 100,
   FQN="clang::comments::Token::getText", NM="_ZNK5clang8comments5Token7getTextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Token7getTextEv")
  //</editor-fold>
  public StringRef getText() /*const*//* __attribute__((pure))*/ {
    assert (is(tok.TokenKind.text));
    return new StringRef(TextPtr, IntVal);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::setText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 105,
   FQN="clang::comments::Token::setText", NM="_ZN5clang8comments5Token7setTextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Token7setTextEN4llvm9StringRefE")
  //</editor-fold>
  public void setText(StringRef Text) {
    assert (is(tok.TokenKind.text));
    TextPtr = $tryClone(Text.data());
    IntVal = Text.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::getUnknownCommandName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 111,
   FQN="clang::comments::Token::getUnknownCommandName", NM="_ZNK5clang8comments5Token21getUnknownCommandNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Token21getUnknownCommandNameEv")
  //</editor-fold>
  public StringRef getUnknownCommandName() /*const*//* __attribute__((pure))*/ {
    assert (is(tok.TokenKind.unknown_command));
    return new StringRef(TextPtr, IntVal);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::setUnknownCommandName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 116,
   FQN="clang::comments::Token::setUnknownCommandName", NM="_ZN5clang8comments5Token21setUnknownCommandNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Token21setUnknownCommandNameEN4llvm9StringRefE")
  //</editor-fold>
  public void setUnknownCommandName(StringRef Name) {
    assert (is(tok.TokenKind.unknown_command));
    TextPtr = $tryClone(Name.data());
    IntVal = Name.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::getCommandID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 122,
   FQN="clang::comments::Token::getCommandID", NM="_ZNK5clang8comments5Token12getCommandIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Token12getCommandIDEv")
  //</editor-fold>
  public /*uint*/int getCommandID() /*const*//* __attribute__((pure))*/ {
    assert (is(tok.TokenKind.backslash_command) || is(tok.TokenKind.at_command));
    return IntVal;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::setCommandID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 127,
   FQN="clang::comments::Token::setCommandID", NM="_ZN5clang8comments5Token12setCommandIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Token12setCommandIDEj")
  //</editor-fold>
  public void setCommandID(/*uint*/int ID) {
    assert (is(tok.TokenKind.backslash_command) || is(tok.TokenKind.at_command));
    IntVal = ID;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::getVerbatimBlockID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 132,
   FQN="clang::comments::Token::getVerbatimBlockID", NM="_ZNK5clang8comments5Token18getVerbatimBlockIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Token18getVerbatimBlockIDEv")
  //</editor-fold>
  public /*uint*/int getVerbatimBlockID() /*const*//* __attribute__((pure))*/ {
    assert (is(tok.TokenKind.verbatim_block_begin) || is(tok.TokenKind.verbatim_block_end));
    return IntVal;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::setVerbatimBlockID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 137,
   FQN="clang::comments::Token::setVerbatimBlockID", NM="_ZN5clang8comments5Token18setVerbatimBlockIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Token18setVerbatimBlockIDEj")
  //</editor-fold>
  public void setVerbatimBlockID(/*uint*/int ID) {
    assert (is(tok.TokenKind.verbatim_block_begin) || is(tok.TokenKind.verbatim_block_end));
    IntVal = ID;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::getVerbatimBlockText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 142,
   FQN="clang::comments::Token::getVerbatimBlockText", NM="_ZNK5clang8comments5Token20getVerbatimBlockTextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Token20getVerbatimBlockTextEv")
  //</editor-fold>
  public StringRef getVerbatimBlockText() /*const*//* __attribute__((pure))*/ {
    assert (is(tok.TokenKind.verbatim_block_line));
    return new StringRef(TextPtr, IntVal);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::setVerbatimBlockText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 147,
   FQN="clang::comments::Token::setVerbatimBlockText", NM="_ZN5clang8comments5Token20setVerbatimBlockTextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Token20setVerbatimBlockTextEN4llvm9StringRefE")
  //</editor-fold>
  public void setVerbatimBlockText(StringRef Text) {
    assert (is(tok.TokenKind.verbatim_block_line));
    TextPtr = $tryClone(Text.data());
    IntVal = Text.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::getVerbatimLineID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 153,
   FQN="clang::comments::Token::getVerbatimLineID", NM="_ZNK5clang8comments5Token17getVerbatimLineIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Token17getVerbatimLineIDEv")
  //</editor-fold>
  public /*uint*/int getVerbatimLineID() /*const*//* __attribute__((pure))*/ {
    assert (is(tok.TokenKind.verbatim_line_name));
    return IntVal;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::setVerbatimLineID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 158,
   FQN="clang::comments::Token::setVerbatimLineID", NM="_ZN5clang8comments5Token17setVerbatimLineIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Token17setVerbatimLineIDEj")
  //</editor-fold>
  public void setVerbatimLineID(/*uint*/int ID) {
    assert (is(tok.TokenKind.verbatim_line_name));
    IntVal = ID;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::getVerbatimLineText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 163,
   FQN="clang::comments::Token::getVerbatimLineText", NM="_ZNK5clang8comments5Token19getVerbatimLineTextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Token19getVerbatimLineTextEv")
  //</editor-fold>
  public StringRef getVerbatimLineText() /*const*//* __attribute__((pure))*/ {
    assert (is(tok.TokenKind.verbatim_line_text));
    return new StringRef(TextPtr, IntVal);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::setVerbatimLineText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 168,
   FQN="clang::comments::Token::setVerbatimLineText", NM="_ZN5clang8comments5Token19setVerbatimLineTextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Token19setVerbatimLineTextEN4llvm9StringRefE")
  //</editor-fold>
  public void setVerbatimLineText(StringRef Text) {
    assert (is(tok.TokenKind.verbatim_line_text));
    TextPtr = $tryClone(Text.data());
    IntVal = Text.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::getHTMLTagStartName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 174,
   FQN="clang::comments::Token::getHTMLTagStartName", NM="_ZNK5clang8comments5Token19getHTMLTagStartNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Token19getHTMLTagStartNameEv")
  //</editor-fold>
  public StringRef getHTMLTagStartName() /*const*//* __attribute__((pure))*/ {
    assert (is(tok.TokenKind.html_start_tag));
    return new StringRef(TextPtr, IntVal);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::setHTMLTagStartName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 179,
   FQN="clang::comments::Token::setHTMLTagStartName", NM="_ZN5clang8comments5Token19setHTMLTagStartNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Token19setHTMLTagStartNameEN4llvm9StringRefE")
  //</editor-fold>
  public void setHTMLTagStartName(StringRef Name) {
    assert (is(tok.TokenKind.html_start_tag));
    TextPtr = $tryClone(Name.data());
    IntVal = Name.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::getHTMLIdent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 185,
   FQN="clang::comments::Token::getHTMLIdent", NM="_ZNK5clang8comments5Token12getHTMLIdentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Token12getHTMLIdentEv")
  //</editor-fold>
  public StringRef getHTMLIdent() /*const*//* __attribute__((pure))*/ {
    assert (is(tok.TokenKind.html_ident));
    return new StringRef(TextPtr, IntVal);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::setHTMLIdent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 190,
   FQN="clang::comments::Token::setHTMLIdent", NM="_ZN5clang8comments5Token12setHTMLIdentEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Token12setHTMLIdentEN4llvm9StringRefE")
  //</editor-fold>
  public void setHTMLIdent(StringRef Name) {
    assert (is(tok.TokenKind.html_ident));
    TextPtr = $tryClone(Name.data());
    IntVal = Name.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::getHTMLQuotedString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 196,
   FQN="clang::comments::Token::getHTMLQuotedString", NM="_ZNK5clang8comments5Token19getHTMLQuotedStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Token19getHTMLQuotedStringEv")
  //</editor-fold>
  public StringRef getHTMLQuotedString() /*const*//* __attribute__((pure))*/ {
    assert (is(tok.TokenKind.html_quoted_string));
    return new StringRef(TextPtr, IntVal);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::setHTMLQuotedString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 201,
   FQN="clang::comments::Token::setHTMLQuotedString", NM="_ZN5clang8comments5Token19setHTMLQuotedStringEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Token19setHTMLQuotedStringEN4llvm9StringRefE")
  //</editor-fold>
  public void setHTMLQuotedString(StringRef Str) {
    assert (is(tok.TokenKind.html_quoted_string));
    TextPtr = $tryClone(Str.data());
    IntVal = Str.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::getHTMLTagEndName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 207,
   FQN="clang::comments::Token::getHTMLTagEndName", NM="_ZNK5clang8comments5Token17getHTMLTagEndNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Token17getHTMLTagEndNameEv")
  //</editor-fold>
  public StringRef getHTMLTagEndName() /*const*//* __attribute__((pure))*/ {
    assert (is(tok.TokenKind.html_end_tag));
    return new StringRef(TextPtr, IntVal);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::setHTMLTagEndName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 212,
   FQN="clang::comments::Token::setHTMLTagEndName", NM="_ZN5clang8comments5Token17setHTMLTagEndNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Token17setHTMLTagEndNameEN4llvm9StringRefE")
  //</editor-fold>
  public void setHTMLTagEndName(StringRef Name) {
    assert (is(tok.TokenKind.html_end_tag));
    TextPtr = $tryClone(Name.data());
    IntVal = Name.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 22,
   FQN="clang::comments::Token::dump", NM="_ZNK5clang8comments5Token4dumpERKNS0_5LexerERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Token4dumpERKNS0_5LexerERKNS_13SourceManagerE")
  //</editor-fold>
  public void dump(final /*const*/ Lexer /*&*/ L, final /*const*/ SourceManager /*&*/ SM) /*const*/ {
    llvm.errs().$out(/*KEEP_STR*/"comments::Token Kind=").$out_int(Kind.getValue()).$out(/*KEEP_STR*/$SPACE);
    Loc.dump(SM);
    llvm.errs().$out(/*KEEP_STR*/$SPACE).$out_uint(Length).$out(/*KEEP_STR*/" \"").$out(L.getSpelling(/*Deref*/this, SM)).$out(/*KEEP_STR*/$QUOTE_LF);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::Token">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 57,
   FQN="clang::comments::Token::Token", NM="_ZN5clang8comments5TokenC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments5TokenC1ERKS1_")
  //</editor-fold>
  public /*inline*/ Token(final /*const*/ Token /*&*/ $Prm0) {
    // : Loc(.Loc), Kind(.Kind), Length(.Length), TextPtr(.TextPtr), IntVal(.IntVal) 
    //START JInit
    this.Loc = new SourceLocation($Prm0.Loc);
    this.Kind = $Prm0.Kind;
    this.Length = $Prm0.Length;
    this.TextPtr = $tryClone($Prm0.TextPtr);
    this.IntVal = $Prm0.IntVal;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::Token">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 57,
   FQN="clang::comments::Token::Token", NM="_ZN5clang8comments5TokenC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments5TokenC1EOS1_")
  //</editor-fold>
  public /*inline*/ Token(JD$Move _dparam, final Token /*&&*/$Prm0) {
    // : Loc(static_cast<Token &&>().Loc), Kind(static_cast<Token &&>().Kind), Length(static_cast<Token &&>().Length), TextPtr(static_cast<Token &&>().TextPtr), IntVal(static_cast<Token &&>().IntVal) 
    //START JInit
    this.Loc = new SourceLocation(JD$Move.INSTANCE, $Prm0.Loc);
    this.Kind = $Prm0.Kind;
    this.Length = $Prm0.Length;
    this.TextPtr = $tryClone($Prm0.TextPtr);
    this.IntVal = $Prm0.IntVal;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 57,
   FQN="clang::comments::Token::operator=", NM="_ZN5clang8comments5TokenaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments5TokenaSERKS1_")
  //</editor-fold>
  public /*inline*/ Token /*&*/ $assign(final /*const*/ Token /*&*/ $Prm0) {
    this.Loc.$assign($Prm0.Loc);
    this.Kind = $Prm0.Kind;
    this.Length = $Prm0.Length;
    this.TextPtr = $tryClone($Prm0.TextPtr);
    this.IntVal = $Prm0.IntVal;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 57,
   FQN="clang::comments::Token::operator=", NM="_ZN5clang8comments5TokenaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments5TokenaSEOS1_")
  //</editor-fold>
  public /*inline*/ Token /*&*/ $assignMove(final Token /*&&*/$Prm0) {
    this.Loc.$assignMove($Prm0.Loc);
    this.Kind = $Prm0.Kind;
    this.Length = $Prm0.Length;
    this.TextPtr = $tryClone($Prm0.TextPtr);
    this.IntVal = $Prm0.IntVal;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::~Token">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 57,
   FQN="clang::comments::Token::~Token", NM="_ZN5clang8comments5TokenD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments5TokenD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
  }


  //<editor-fold defaultstate="collapsed" desc="clang::comments::Token::Token">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 57,
   FQN="clang::comments::Token::Token", NM="_ZN5clang8comments5TokenC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments5TokenC1Ev")
  //</editor-fold>
  public /*inline*/ Token() {
    // : Loc() 
    //START JInit
    this.Loc = new SourceLocation();
    //END JInit
  }

  @Override public Token clone() { return new Token(this); }

  @Override public String toString() {
    return "" + "Loc=" + Loc // NOI18N
              + ", Kind=" + Kind // NOI18N
              + ", Length=" + Length // NOI18N
              + ", TextPtr=" + TextPtr // NOI18N
              + ", IntVal=" + IntVal; // NOI18N
  }
}
