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

import org.clank.java.*;
import org.clank.support.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.comments.Token;
//import org.clang.lex.Token;
import static org.clang.ast.comments.impl.CommentBriefParserCommentsStatics.*;


/// A very simple comment parser that extracts "a brief description".
///
/// Due to a variety of comment styles, it considers the following as "a brief
/// description", in order of priority:
/// \li a \\brief or \\short command,
/// \li the first paragraph,
/// \li a \\result or \\return or \\returns paragraph.
//<editor-fold defaultstate="collapsed" desc="clang::comments::BriefParser">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentBriefParser.h", line = 30,
 FQN="clang::comments::BriefParser", NM="_ZN5clang8comments11BriefParserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp -nm=_ZN5clang8comments11BriefParserE")
//</editor-fold>
public class BriefParser {
  private final Lexer /*&*/ L;
  
  private final /*const*/ CommandTraits /*&*/ Traits;
  
  /// Current lookahead token.
  private Token Tok;
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BriefParser::ConsumeToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentBriefParser.h", line = 38,
   FQN="clang::comments::BriefParser::ConsumeToken", NM="_ZN5clang8comments11BriefParser12ConsumeTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp -nm=_ZN5clang8comments11BriefParser12ConsumeTokenEv")
  //</editor-fold>
  private SourceLocation ConsumeToken() {
    SourceLocation Loc = Tok.getLocation();
    L.lex(Tok);
    return Loc;
  }

/*public:*/
  // unnamed namespace
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BriefParser::BriefParser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp", line = 58,
   FQN="clang::comments::BriefParser::BriefParser", NM="_ZN5clang8comments11BriefParserC1ERNS0_5LexerERKNS0_13CommandTraitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp -nm=_ZN5clang8comments11BriefParserC1ERNS0_5LexerERKNS0_13CommandTraitsE")
  //</editor-fold>
  public BriefParser(final Lexer /*&*/ L, final /*const*/ CommandTraits /*&*/ Traits) {
    // : L(L), Traits(Traits), Tok() 
    //START JInit
    this./*&*/L=/*&*/L;
    this./*&*/Traits=/*&*/Traits;
    this.Tok = new Token();
    //END JInit
    // Get lookahead token.
    ConsumeToken();
  }

  
  /// Return the best "brief description" we can find.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BriefParser::Parse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp", line = 64,
   FQN="clang::comments::BriefParser::Parse", NM="_ZN5clang8comments11BriefParser5ParseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentBriefParser.cpp -nm=_ZN5clang8comments11BriefParser5ParseEv")
  //</editor-fold>
  public std.string Parse() {
    std.string FirstParagraphOrBrief/*J*/= new std.string();
    std.string ReturnsParagraph/*J*/= new std.string();
    boolean InFirstParagraph = true;
    boolean InBrief = false;
    boolean InReturns = false;
    while (Tok.isNot(tok.TokenKind.eof)) {
      if (Tok.is(tok.TokenKind.text)) {
        if (InFirstParagraph || InBrief) {
          $addassign_string_StringRef(FirstParagraphOrBrief, Tok.getText());
        } else if (InReturns) {
          $addassign_string_StringRef(ReturnsParagraph, Tok.getText());
        }
        ConsumeToken();
        continue;
      }
      if (Tok.is(tok.TokenKind.backslash_command) || Tok.is(tok.TokenKind.at_command)) {
        /*const*/ CommandInfo /*P*/ Info = Traits.getCommandInfo(Tok.getCommandID());
        if (Info.IsBriefCommand) {
          FirstParagraphOrBrief.clear();
          InBrief = true;
          ConsumeToken();
          continue;
        }
        if (Info.IsReturnsCommand) {
          InReturns = true;
          InBrief = false;
          InFirstParagraph = false;
          ReturnsParagraph.$addassign_T$C$P(/*KEEP_STR*/"Returns ");
          ConsumeToken();
          continue;
        }
        // Block commands implicitly start a new paragraph.
        if (Info.IsBlockCommand) {
          // We found an implicit paragraph end.
          InFirstParagraph = false;
          if (InBrief) {
            break;
          }
        }
      }
      if (Tok.is(tok.TokenKind.newline)) {
        if (InFirstParagraph || InBrief) {
          FirstParagraphOrBrief.$addassign_T($$SPACE);
        } else if (InReturns) {
          ReturnsParagraph.$addassign_T($$SPACE);
        }
        ConsumeToken();
        
        // If the next token is a whitespace only text, ignore it.  Thus we allow
        // two paragraphs to be separated by line that has only whitespace in it.
        //
        // We don't need to add a space to the parsed text because we just added
        // a space for the newline.
        if (Tok.is(tok.TokenKind.text)) {
          if (isWhitespace(Tok.getText())) {
            ConsumeToken();
          }
        }
        if (Tok.is(tok.TokenKind.newline)) {
          ConsumeToken();
          // We found a paragraph end.  This ends the brief description if
          // \\brief command or its equivalent was explicitly used.
          // Stop scanning text because an explicit \\brief paragraph is the
          // preffered one.
          if (InBrief) {
            break;
          }
          // End first paragraph if we found some non-whitespace text.
          if (InFirstParagraph && !isWhitespace(new StringRef(FirstParagraphOrBrief))) {
            InFirstParagraph = false;
          }
          // End the \\returns paragraph because we found the paragraph end.
          InReturns = false;
        }
        continue;
      }
      
      // We didn't handle this token, so just drop it.
      ConsumeToken();
    }
    
    cleanupBrief(FirstParagraphOrBrief);
    if (!FirstParagraphOrBrief.empty()) {
      return FirstParagraphOrBrief;
    }
    
    cleanupBrief(ReturnsParagraph);
    return ReturnsParagraph;
  }

  
  @Override public String toString() {
    return "" + "L=" + "[Lexer]" // NOI18N
              + ", Traits=" + Traits // NOI18N
              + ", Tok=" + Tok; // NOI18N
  }
}
