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
import org.clang.format.java.FormatFunctionPointers.*;


//<editor-fold defaultstate="collapsed" desc="static type TokenAnnotatorFormatStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.format.impl.TokenAnnotatorFormatStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6formatL13isAllmanBraceERKNS0_11FormatTokenE;_ZN5clang6formatL25isFunctionDeclarationNameERKNS0_11FormatTokenERKNS0_13AnnotatedLineE; -static-type=TokenAnnotatorFormatStatics -package=org.clang.format.impl")
//</editor-fold>
public final class TokenAnnotatorFormatStatics {


// This function heuristically determines whether 'Current' starts the name of a
// function declaration.
//<editor-fold defaultstate="collapsed" desc="clang::format::isFunctionDeclarationName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 1590,
 FQN="clang::format::isFunctionDeclarationName", NM="_ZN5clang6formatL25isFunctionDeclarationNameERKNS0_11FormatTokenERKNS0_13AnnotatedLineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6formatL25isFunctionDeclarationNameERKNS0_11FormatTokenERKNS0_13AnnotatedLineE")
//</editor-fold>
public static boolean isFunctionDeclarationName(final /*const*/ FormatToken /*&*/ Current, 
                         final /*const*/ AnnotatedLine /*&*/ Line) {
  FormatToken2FormatToken skipOperatorName = /*[]*/ (/*const*/ FormatToken /*P*/ Next) -> {
        for (; (Next != null); Next = Next.Next) {
          if (Next.is_TokenType(TokenType.TT_OverloadedOperatorLParen)) {
            return Next;
          }
          if (Next.is_TokenType(TokenType.TT_OverloadedOperator)) {
            continue;
          }
          if (Next.isOneOf(tok.TokenKind.kw_new, tok.TokenKind.kw_delete)) {
            // For 'new[]' and 'delete[]'.
            if ((Next.Next != null) && Next.Next.is_TokenKind(tok.TokenKind.l_square)
               && (Next.Next.Next != null) && Next.Next.Next.is_TokenKind(tok.TokenKind.r_square)) {
              Next = Next.Next.Next;
            }
            continue;
          }
          
          break;
        }
        return null;
      };
  
  // Find parentheses of parameter list.
  /*const*/ FormatToken /*P*/ Next = Current.Next;
  if (Current.is_TokenKind(tok.TokenKind.kw_operator)) {
    if ((Current.Previous != null) && Current.Previous.is_TokenKind(tok.TokenKind.coloncolon)) {
      return false;
    }
    Next = skipOperatorName.$call(Next);
  } else {
    if (!Current.is_TokenType(TokenType.TT_StartOfName) || Current.NestingLevel != 0) {
      return false;
    }
    for (; (Next != null); Next = Next.Next) {
      if (Next.is_TokenType(TokenType.TT_TemplateOpener)) {
        Next = Next.MatchingParen;
      } else if (Next.is_TokenKind(tok.TokenKind.coloncolon)) {
        Next = Next.Next;
        if (!(Next != null)) {
          return false;
        }
        if (Next.is_TokenKind(tok.TokenKind.kw_operator)) {
          Next = skipOperatorName.$call(Next.Next);
          break;
        }
        if (!Next.is_TokenKind(tok.TokenKind.identifier)) {
          return false;
        }
      } else if (Next.is_TokenKind(tok.TokenKind.l_paren)) {
        break;
      } else {
        return false;
      }
    }
  }
  
  // Check whether parameter list can be long to a function declaration.
  if (!(Next != null) || !Next.is_TokenKind(tok.TokenKind.l_paren) || !(Next.MatchingParen != null)) {
    return false;
  }
  // If the lines ends with "{", this is likely an function definition.
  if (Line.Last.is_TokenKind(tok.TokenKind.l_brace)) {
    return true;
  }
  if (Next.Next == Next.MatchingParen) {
    return true; // Empty parentheses.
  }
  // If there is an &/&& after the r_paren, this is likely a function.
  if ((Next.MatchingParen.Next != null)
     && Next.MatchingParen.Next.is_TokenType(TokenType.TT_PointerOrReference)) {
    return true;
  }
  for (/*const*/ FormatToken /*P*/ Tok = Next.Next; (Tok != null) && Tok != Next.MatchingParen;
       Tok = Tok.Next) {
    if (Tok.is_TokenKind(tok.TokenKind.kw_const) || Tok.isSimpleTypeSpecifier()
       || Tok.isOneOf(TokenType.TT_PointerOrReference, TokenType.TT_StartOfName, tok.TokenKind.ellipsis)) {
      return true;
    }
    if (Tok.isOneOf(tok.TokenKind.l_brace, tok.TokenKind.string_literal, TokenType.TT_ObjCMethodExpr)
       || Tok.Tok.isLiteral()) {
      return false;
    }
  }
  return false;
}


// Returns 'true' if 'Tok' is a brace we'd want to break before in Allman style.
//<editor-fold defaultstate="collapsed" desc="clang::format::isAllmanBrace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp", line = 2246,
 FQN="clang::format::isAllmanBrace", NM="_ZN5clang6formatL13isAllmanBraceERKNS0_11FormatTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6formatL13isAllmanBraceERKNS0_11FormatTokenE")
//</editor-fold>
public static boolean isAllmanBrace(final /*const*/ FormatToken /*&*/ Tok) {
  return Tok.is_TokenKind(tok.TokenKind.l_brace) && Tok.BlockKind == BraceBlockKind.BK_Block
     && !Tok.isOneOf(TokenType.TT_ObjCBlockLBrace, TokenType.TT_DictLiteral);
}

} // END OF class TokenAnnotatorFormatStatics
