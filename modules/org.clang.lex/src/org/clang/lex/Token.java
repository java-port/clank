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

package org.clang.lex;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;


/// Token - This structure provides full information about a lexed token.
/// It is not intended to be space efficient, it is intended to return as much
/// information as possible about each returned token.  This is expected to be
/// compressed into a smaller form if memory footprint is important.
///
/// The parser can create a special "annotation token" representing a stream of
/// tokens that were parsed and semantically resolved, e.g.: "foo::MyClass<int>"
/// can be represented by a single typename annotation token that carries
/// information about the SourceRange of the tokens and the type object.
//<editor-fold defaultstate="collapsed" desc="clang::Token">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 35,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 37,
 FQN="clang::Token", NM="_ZN5clang5TokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5TokenE")
//</editor-fold>
public final class Token implements NativePOD<Token>, NativeType.SizeofCapable {
  /// The location of the token. This is actually a SourceLocation.
  private /*uint*/int Loc;
  
  // Conceptually these next two fields could be in a union.  However, this
  // causes gcc 4.2 to pessimize LexTokenInternal, a very performance critical
  // routine. Keeping as separate members with casts until a more beautiful fix
  // presents itself.
  
  /// UintData - This holds either the length of the token text, when
  /// a normal token, or the end of the SourceRange when an annotation
  /// token.
  private /*uint*/int UintData;
  
  /// PtrData - This is a union of four different pointer types, which depends
  /// on what type of token this is:
  ///  Identifiers, keywords, etc:
  ///    This is an IdentifierInfo*, which contains the uniqued identifier
  ///    spelling.
  ///  Literals:  isLiteral() returns true.
  ///    This is a pointer to the start of the token in a text buffer, which
  ///    may be dirty (have trigraphs / escaped newlines).
  ///  Annotations (resolved type names, C++ scopes, etc): isAnnotation().
  ///    This is a pointer to sema-specific data for the annotation token.
  ///  Eof:
  //     This is a pointer to a Decl.
  ///  Other:
  ///    This is null.
  private Object/*void P*/ PtrData;
  private byte[]/*void P*/ CharPtrData;
  private int CharPtrDataIndex;
  
  /// Kind - The actual flavor of token this is.
  private /*tok.TokenKind*/char Kind;
  
  /// Flags - Bits we track about this token, members of the TokenFlags enum.
  private /*TokenFlags ushort*/char Flags;
/*public:*/
  // Various flags set per token:
  //<editor-fold defaultstate="collapsed" desc="clang::Token::TokenFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 73,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 75,
   FQN="clang::Token::TokenFlags", NM="_ZN5clang5Token10TokenFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Token10TokenFlagsE")
  //</editor-fold>
  public static final class/*enum*/ TokenFlags {
    public static final char StartOfLine = 0x01; // At start of line or only after whitespace
    // (considering the line after macro expansion).
    public static final char LeadingSpace = 0x02; // Whitespace exists before this token (considering 
    // whitespace after macro expansion).
    public static final char DisableExpand = 0x04; // This identifier may never be macro expanded.
    public static final char NeedsCleaning = 0x08; // Contained an escaped newline or trigraph.
    public static final char LeadingEmptyMacro = 0x10; // Empty macro exists before this token.
    public static final char HasUDSuffix = 0x20; // This string or character literal has a ud-suffix.
    public static final char HasUCN = 0x40; // This identifier contains a UCN.
    public static final char IgnoredComma = 0x80; // This comma is not a macro argument separator (MS).
    public static final char StringifiedInMacro = 0x100; // This string or character literal is formed by
                                                        // macro stringizing or charizing operator.
    public static final char CommaAfterElided = 0x200; // The comma following this token was elided (MS).
            
    // JAVA FIX: marker for incomplete tokens like string literals
    // to produce diagnostics from PTH mode as well
    // this bit is not stored in PTH, see PTHWriter.EmitToken and PTHLexer.Lex
    public static final char Incomplete = (char)0x8000;     // This token is incomplete (i.e. string without closing quote)
    
    public static String toString(char Flags) {
      StringBuilder out = new StringBuilder();
      appendFlag(out, Flags, Incomplete, "INCOMPLETE");
      
      appendFlag(out, Flags, StartOfLine, "StartOfLine");
      appendFlag(out, Flags, LeadingSpace, "LeadingSpace");
      appendFlag(out, Flags, DisableExpand, "DisableExpand");
      appendFlag(out, Flags, DisableExpand, "DisableExpand");
      appendFlag(out, Flags, NeedsCleaning, "NeedsCleaning");
      appendFlag(out, Flags, LeadingEmptyMacro, "LeadingEmptyMacro");
      appendFlag(out, Flags, HasUDSuffix, "HasUDSuffix");
      appendFlag(out, Flags, HasUCN, "HasUCN");
      appendFlag(out, Flags, IgnoredComma, "IgnoredComma");
      appendFlag(out, Flags, StringifiedInMacro, "StringifiedInMacro");
      appendFlag(out, Flags, CommaAfterElided, "CommaAfterElided");
      
      if (out.length() > 0) {
        out.insert(0, "<");
        out.append(">");
      } else {
        out.append("<NO_FLAGS>");
      }
      return out.toString();
    }
    
    private static void appendFlag(StringBuilder out, char Flags, char Flag, String msg) {
      if ((Flags & Flag) == Flag) {
        if (out.length() > 0) {
          out.append(",");
        }
        out.append(msg);
      }
    }
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::Token::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 89,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 90,
   FQN="clang::Token::getKind", NM="_ZNK5clang5Token7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token7getKindEv")
  //</editor-fold>
  public /*tok.TokenKind*/char getKind() /*const*/ {
    return Kind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Token::setKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 90,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 91,
   FQN="clang::Token::setKind", NM="_ZN5clang5Token7setKindENS_3tok9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Token7setKindENS_3tok9TokenKindE")
  //</editor-fold>
  public void setKind(/*tok.TokenKind*/char K) {
    Kind = K;
  }

  
  /// is/isNot - Predicates to check if this token is a specific kind, as in
  /// "if (Tok.is(tok::l_brace)) {...}".
  //<editor-fold defaultstate="collapsed" desc="clang::Token::is">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 94,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 95,
   FQN="clang::Token::is", NM="_ZNK5clang5Token2isENS_3tok9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token2isENS_3tok9TokenKindE")
  //</editor-fold>
  public boolean is(/*tok.TokenKind*/char K) /*const*/ {
    return Kind == K;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Token::isNot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 95,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 96,
   FQN="clang::Token::isNot", NM="_ZNK5clang5Token5isNotENS_3tok9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token5isNotENS_3tok9TokenKindE")
  //</editor-fold>
  public boolean isNot(/*tok.TokenKind*/char K) /*const*/ {
    return Kind != K;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Token::isOneOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 96,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 97,
   FQN="clang::Token::isOneOf", NM="_ZNK5clang5Token7isOneOfENS_3tok9TokenKindES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token7isOneOfENS_3tok9TokenKindES2_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char K2) /*const*/ {
    return is(K1) || is(K2);
  }
  
  // JAVA: when need more params, just add extra overload with more params
  /*template <typename ... Ts> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::Token::isOneOf">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 99,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 101,
   FQN="clang::Token::isOneOf", NM="Tpl__ZNK5clang5Token7isOneOfENS_3tok9TokenKindES2_DpT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=Tpl__ZNK5clang5Token7isOneOfENS_3tok9TokenKindES2_DpT_")
  //</editor-fold>
  public boolean isOneOf$T(/*tok.TokenKind*/char ...Ks) /*const*/ {
    for (char K : Ks) {
      if (is(K)) { return true; }
    }
    return false;
  }
  public boolean isOneOf$T(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char K2, 
          /*tok.TokenKind*/char Ks) /*const*/ {
    return is(K1) || is(K2) || is(Ks);
  }
  public boolean isOneOf$T(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char K2, /*tok.TokenKind*/char K3, 
          /*tok.TokenKind*/char Ks) /*const*/ {
    return is(K1) || is(K2) || is(K3) || is(Ks);
  }
  public boolean isOneOf$T(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char K2, /*tok.TokenKind*/char K3, /*tok.TokenKind*/char K4, 
          /*tok.TokenKind*/char Ks) /*const*/ {
    return is(K1) || is(K2) || is(K3) || is(K4) || is(Ks);
  }
  public boolean isOneOf$T(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char K2, /*tok.TokenKind*/char K3, 
          /*tok.TokenKind*/char K4, /*tok.TokenKind*/char K5, 
          /*tok.TokenKind*/char Ks) /*const*/ {
    return is(K1) || is(K2) || is(K3) || is(K4) || is(K5) || is(Ks);
  }
  public boolean isOneOf$T(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char K2, /*tok.TokenKind*/char K3, 
          /*tok.TokenKind*/char K4, /*tok.TokenKind*/char K5, /*tok.TokenKind*/char K6, 
          /*tok.TokenKind*/char Ks) /*const*/ {
    return is(K1) || is(K2) || is(K3) || is(K4) || is(K5) || is(K6) || is(Ks);
  }
  public boolean isOneOf$T(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char K2, /*tok.TokenKind*/char K3, 
          /*tok.TokenKind*/char K4, /*tok.TokenKind*/char K5, /*tok.TokenKind*/char K6, /*tok.TokenKind*/char K7, 
          /*tok.TokenKind*/char Ks) /*const*/ {
    return is(K1) || is(K2) || is(K3) || is(K4) || is(K5) || is(K6) || is(K7) || is(Ks);
  }
  public boolean isOneOf$T(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char K2, /*tok.TokenKind*/char K3, 
          /*tok.TokenKind*/char K4, /*tok.TokenKind*/char K5, /*tok.TokenKind*/char K6, /*tok.TokenKind*/char K7, 
          /*tok.TokenKind*/char K8, /*tok.TokenKind*/char Ks) /*const*/ {
    return is(K1) || is(K2) || is(K3) || is(K4) || is(K5) || is(K6) || is(K7) || is(K8) ||is(Ks);
  }
  public boolean isOneOf$T(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char K2, /*tok.TokenKind*/char K3, 
          /*tok.TokenKind*/char K4, /*tok.TokenKind*/char K5, /*tok.TokenKind*/char K6, /*tok.TokenKind*/char K7, 
          /*tok.TokenKind*/char K8, /*tok.TokenKind*/char K9, /*tok.TokenKind*/char Ks) /*const*/ {
    return is(K1) || is(K2) || is(K3) || is(K4) || is(K5) || is(K6) || is(K7) || is(K8) || is(K9) || is(Ks);
  }
  public boolean isOneOf$T(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char K2, /*tok.TokenKind*/char K3, 
          /*tok.TokenKind*/char K4, /*tok.TokenKind*/char K5, /*tok.TokenKind*/char K6, /*tok.TokenKind*/char K7, 
          /*tok.TokenKind*/char K8, /*tok.TokenKind*/char K9, /*tok.TokenKind*/char K10, /*tok.TokenKind*/char Ks) /*const*/ {
    return is(K1) || is(K2) || is(K3) || is(K4) || is(K5) || is(K6) || is(K7) || is(K8) || is(K9) || is(K10) || is(Ks);
  }

  
  /// \brief Return true if this is a raw identifier (when lexing
  /// in raw mode) or a non-keyword identifier (when lexing in non-raw mode).
  //<editor-fold defaultstate="collapsed" desc="clang::Token::isAnyIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 106,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 107,
   FQN="clang::Token::isAnyIdentifier", NM="_ZNK5clang5Token15isAnyIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token15isAnyIdentifierEv")
  //</editor-fold>
  public boolean isAnyIdentifier() /*const*/ {
    return tok.isAnyIdentifier(Kind);
  }

  
  /// \brief Return true if this is a "literal", like a numeric
  /// constant, string, etc.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::isLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 112,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 113,
   FQN="clang::Token::isLiteral", NM="_ZNK5clang5Token9isLiteralEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token9isLiteralEv")
  //</editor-fold>
  public boolean isLiteral() /*const*/ {
    return tok.isLiteral(Kind);
  }

  
  /// \brief Return true if this is any of tok::annot_* kind tokens.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::isAnnotation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 117,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 118,
   FQN="clang::Token::isAnnotation", NM="_ZNK5clang5Token12isAnnotationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token12isAnnotationEv")
  //</editor-fold>
  public boolean isAnnotation() /*const*/ {
    return tok.isAnnotation(Kind);
  }

  
  /// \brief Return a source location identifier for the specified
  /// offset in the current file.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 123,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 124,
   FQN="clang::Token::getLocation", NM="_ZNK5clang5Token11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return SourceLocation.getFromRawEncoding(Loc);
  }
  public /*uint*/int $getLocation() /*const*/ {
    return Loc;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Token::getLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 126,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 127,
   FQN="clang::Token::getLength", NM="_ZNK5clang5Token9getLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token9getLengthEv")
  //</editor-fold>
  public /*uint*/int getLength() /*const*/ {
    assert (!isAnnotation()) : "Annotation tokens have no length field; kind:" + tok.getTokenName(this.getKind());
    assert UintData >= 0; // JAVA: is it really needed that used uint is positive int?
    return UintData;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Token::setLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 131,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 132,
   FQN="clang::Token::setLocation", NM="_ZN5clang5Token11setLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Token11setLocationENS_14SourceLocationE")
  //</editor-fold>
  public void setLocation(SourceLocation L) {
    setLocation(L.getRawEncoding());
  }
  public void setLocation(/*SourceLocation*/int L) {
    isDebug(this.index);
    Loc = L;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Token::setLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 132,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 133,
   FQN="clang::Token::setLength", NM="_ZN5clang5Token9setLengthEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Token9setLengthEj")
  //</editor-fold>
  public void setLength(/*uint*/int Len) {
    assert (!isAnnotation()) : "Annotation tokens have no length field; kind:" + tok.getTokenName(this.getKind());
    assert Len >= 0;
    UintData = Len;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Token::getAnnotationEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 137,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 138,
   FQN="clang::Token::getAnnotationEndLoc", NM="_ZNK5clang5Token19getAnnotationEndLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token19getAnnotationEndLocEv")
  //</editor-fold>
  public SourceLocation getAnnotationEndLoc() /*const*/ {
    return SourceLocation.getFromRawEncoding($getAnnotationEndLoc());
  }
  public /*SourceLocation*/int $getAnnotationEndLoc() /*const*/ {
    assert (isAnnotation()) : "Used AnnotEndLocID on non-annotation token; kind:" + tok.getTokenName(this.getKind());
    return ((UintData != 0) ? UintData : Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Token::setAnnotationEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 141,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 142,
   FQN="clang::Token::setAnnotationEndLoc", NM="_ZN5clang5Token19setAnnotationEndLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Token19setAnnotationEndLocENS_14SourceLocationE")
  //</editor-fold>
  public void setAnnotationEndLoc(SourceLocation L) {
    setAnnotationEndLoc(L.getRawEncoding());
  }
  public void setAnnotationEndLoc(/*SourceLocation*/int L) {
    assert (isAnnotation()) : "Used AnnotEndLocID on non-annotation token; kind:" + tok.getTokenName(this.getKind());
    UintData = L;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Token::getLastLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 146,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 147,
   FQN="clang::Token::getLastLoc", NM="_ZNK5clang5Token10getLastLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token10getLastLocEv")
  //</editor-fold>
  public SourceLocation getLastLoc() /*const*/ {
    return SourceLocation.getFromRawEncoding($getLastLoc());
  }
  public /*SourceLocation*/int $getLastLoc() /*const*/ {
    return isAnnotation() ? $getAnnotationEndLoc() : $getLocation();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Token::getEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 150,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 151,
   FQN="clang::Token::getEndLoc", NM="_ZNK5clang5Token9getEndLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token9getEndLocEv")
  //</editor-fold>
  public SourceLocation getEndLoc() /*const*/ {
    return isAnnotation() ? getAnnotationEndLoc() : getLocation().getLocWithOffset(getLength());
  }

  
  /// \brief SourceRange of the group of tokens that this annotation token
  /// represents.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::getAnnotationRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 157,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 158,
   FQN="clang::Token::getAnnotationRange", NM="_ZNK5clang5Token18getAnnotationRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token18getAnnotationRangeEv")
  //</editor-fold>
  public SourceRange getAnnotationRange() /*const*/ {
    return new SourceRange($getLocation(), getAnnotationEndLoc().getRawEncoding());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Token::setAnnotationRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 160,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 161,
   FQN="clang::Token::setAnnotationRange", NM="_ZN5clang5Token18setAnnotationRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Token18setAnnotationRangeENS_11SourceRangeE")
  //</editor-fold>
  public void setAnnotationRange(SourceRange R) {
    setLocation(R.$getBegin());
    setAnnotationEndLoc(R.$getEnd());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Token::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 165,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 166,
   FQN="clang::Token::getName", NM="_ZNK5clang5Token7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token7getNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getName() /*const*/ {
    return tok.getTokenName(Kind);
  }

  
  /// \brief Reset all flags to cleared.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::startToken">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 168,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 169,
   FQN="clang::Token::startToken", NM="_ZN5clang5Token10startTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Token10startTokenEv")
  //</editor-fold>
  public void startToken() {
    isDebug(this.index);
    Kind = tok.TokenKind.unknown;
    Flags = 0;
    PtrData = null;
    CharPtrData = null;
    CharPtrDataIndex = 0;
    UintData = 0;
    Loc = 0;
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::Token::getIdentifierInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 176,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 177,
   FQN="clang::Token::getIdentifierInfo", NM="_ZNK5clang5Token17getIdentifierInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token17getIdentifierInfoEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getIdentifierInfo() /*const*/ {
    assert (isNot(tok.TokenKind.raw_identifier)) : "getIdentifierInfo() on a tok::raw_identifier token! kind:" + tok.getTokenName(this.getKind());
    assert (!isAnnotation()) : "getIdentifierInfo() on an annotation token! kind:" + tok.getTokenName(this.getKind());
    if (isLiteral()) {
      return null;
    }
    if (is(tok.TokenKind.eof)) {
      return null;
    }
    return (IdentifierInfo /*P*/ )PtrData;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Token::setIdentifierInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 185,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 186,
   FQN="clang::Token::setIdentifierInfo", NM="_ZN5clang5Token17setIdentifierInfoEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Token17setIdentifierInfoEPNS_14IdentifierInfoE")
  //</editor-fold>
  public void setIdentifierInfo(IdentifierInfo /*P*/ II) {
    PtrData = II;
    CharPtrData = null;
    CharPtrDataIndex = 0;
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::Token::getEofData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 189,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 190,
   FQN="clang::Token::getEofData", NM="_ZNK5clang5Token10getEofDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token10getEofDataEv")
  //</editor-fold>
  public /*const*/Object/*void P*/ getEofData() /*const*/ {
    assert (is(tok.TokenKind.eof)) : "unexpected kind:" + tok.getTokenName(this.getKind());
    return PtrData;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Token::setEofData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 193,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 194,
   FQN="clang::Token::setEofData", NM="_ZN5clang5Token10setEofDataEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Token10setEofDataEPKv")
  //</editor-fold>
  public void setEofData(/*const*/Object/*void P*/ D) {
    assert (is(tok.TokenKind.eof)) : "unexpected kind:" + tok.getTokenName(this.getKind());
    assert (!(PtrData != null));
    PtrData = D;
  }

  
  /// getRawIdentifier - For a raw identifier token (i.e., an identifier
  /// lexed in raw mode), returns a reference to the text substring in the
  /// buffer if known.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::getRawIdentifier">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 202,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 203,
   FQN="clang::Token::getRawIdentifier", NM="_ZNK5clang5Token16getRawIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token16getRawIdentifierEv")
  //</editor-fold>
  public StringRef getRawIdentifier() /*const*/ {
    assert (is(tok.TokenKind.raw_identifier)) : "unexpected kind:" + tok.getTokenName(this.getKind());
    if (this.CharPtrData == null) {
      return new StringRef((/*const*/char$ptr/*char P*/)PtrData, getLength());
    } else {
      trackFailedGetCharPtr();
      return new StringRef(create_char$ptr(CharPtrData, CharPtrDataIndex), getLength());
    }
  }
  
  /// JAVA: in Java StringRef is not quite free.
  /// In llvm 3.6 const char* getRawIdentifierData() was replaced with
  /// StringRef getRawIdentifier()
  /// I restored getRawIdentifierData() since we think in Java it's more effective
  /// VK
  public /*const*/char$ptr/*char P*/ getRawIdentifierData() /*const*/ {
    assert (is(tok.TokenKind.raw_identifier)) : "unexpected kind:" + tok.getTokenName(this.getKind());
    if (this.CharPtrData == null) {
      return (/*const*/char$ptr/*char P*/)PtrData;
    } else {
      trackFailedGetCharPtr();
      return create_char$ptr(CharPtrData, CharPtrDataIndex);
    }
  }  
  
  /*package*/ boolean hasRawIdentiferData() {
    assert (is(tok.TokenKind.raw_identifier)) : "unexpected kind:" + tok.getTokenName(this.getKind());
    // either CharPtrData or char$ptr in PtrData have to be present
    if (CharPtrData == null) {
        return PtrData instanceof char$ptr;
    } else {
        return true;
    }    
  }
  
  public byte[] $CharPtrData() {
    return CharPtrData;
  }
  public int $CharPtrDataIndex() {
    return CharPtrDataIndex;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::Token::setRawIdentifierData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 206,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 207,
   FQN="clang::Token::setRawIdentifierData", NM="_ZN5clang5Token20setRawIdentifierDataEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Token20setRawIdentifierDataEPKc")
  //</editor-fold>
  public void setRawIdentifierData(/*const*/char$ptr/*char P*/ Ptr) {
    assert (is(tok.TokenKind.raw_identifier)) : "unexpected kind:" + tok.getTokenName(this.getKind());
    trackFailedCharPtr();
    PtrData = $toConst(Ptr);   
    CharPtrData = null;
    CharPtrDataIndex = 0;        
  }
  public void setRawIdentifierData(/*const*/byte[]/*char P*/ PtrArray, int PtrArIndex) {
    assert (is(tok.TokenKind.raw_identifier)) : "unexpected kind:" + tok.getTokenName(this.getKind());
    PtrData = null;
    CharPtrData = PtrArray;
    CharPtrDataIndex = PtrArIndex;
  }
  
  
  /// getLiteralData - For a literal token (numeric constant, string, etc), this
  /// returns a pointer to the start of it in the text buffer if known, null
  /// otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::getLiteralData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 214,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 215,
   FQN="clang::Token::getLiteralData", NM="_ZNK5clang5Token14getLiteralDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token14getLiteralDataEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getLiteralData() /*const*/ {
    assert (isLiteral()) : "Cannot get literal data of non-literal kind:" + tok.getTokenName(this.getKind());
    if (this.CharPtrData == null) {
      return (/*const*/char$ptr/*char P*/)PtrData;
    } else {
      trackFailedGetCharPtr();
      return create_char$ptr(CharPtrData, CharPtrDataIndex);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Token::setLiteralData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 218,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 219,
   FQN="clang::Token::setLiteralData", NM="_ZN5clang5Token14setLiteralDataEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Token14setLiteralDataEPKc")
  //</editor-fold>
  public void setLiteralData(/*const*/char$ptr/*char P*/ Ptr) {
    assert (isLiteral()) : "Cannot set literal data of non-literal kind:" + tok.getTokenName(this.getKind());
    trackFailedCharPtr();
    PtrData = $toConst(Ptr);        
    CharPtrData = null;
    CharPtrDataIndex = 0;        
  }
  public void setLiteralData(byte[] PtrArray, int PtrArIndex) {
    PtrData = null;
    CharPtrData = PtrArray;
    CharPtrDataIndex = PtrArIndex;    
  }
    
  
  //<editor-fold defaultstate="collapsed" desc="clang::Token::getAnnotationValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 223,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 224,
   FQN="clang::Token::getAnnotationValue", NM="_ZNK5clang5Token18getAnnotationValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token18getAnnotationValueEv")
  //</editor-fold>
  public Object/*void P*/ getAnnotationValue() /*const*/ {
    assert (isAnnotation()) : "Used AnnotVal on non-annotation token kind:" + tok.getTokenName(this.getKind());
    return PtrData;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Token::setAnnotationValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 227,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 228,
   FQN="clang::Token::setAnnotationValue", NM="_ZN5clang5Token18setAnnotationValueEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Token18setAnnotationValueEPv")
  //</editor-fold>
  public void setAnnotationValue(Object/*void P*/ Ptr) {
    assert (isAnnotation()) : "Used AnnotVal on non-annotation token kind:" + tok.getTokenName(this.getKind());
    PtrData = $tryClone(Ptr);
    CharPtrData = null;
    CharPtrDataIndex = 0;
  }

  
  /// \brief Set the specified flag.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::setFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 233,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 234,
   FQN="clang::Token::setFlag", NM="_ZN5clang5Token7setFlagENS0_10TokenFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Token7setFlagENS0_10TokenFlagsE")
  //</editor-fold>
  public void setFlag(/*Token.TokenFlags*/char Flag) {
    Flags |= Flag;
  }

  
  /// \brief Get the specified flag.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::getFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 238,
   FQN="clang::Token::getFlag", NM="_ZNK5clang5Token7getFlagENS0_10TokenFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token7getFlagENS0_10TokenFlagsE")
  //</editor-fold>
  public boolean getFlag(/*Token.TokenFlags*/char Flag) /*const*/ {
    return (Flags & Flag) != 0;
  }

  
  /// \brief Unset the specified flag.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::clearFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 243,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 239,
   FQN="clang::Token::clearFlag", NM="_ZN5clang5Token9clearFlagENS0_10TokenFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Token9clearFlagENS0_10TokenFlagsE")
  //</editor-fold>
  public void clearFlag(/*Token.TokenFlags*/char Flag) {
    Flags &= ~Flag;
  }

  
  /// \brief Return the internal represtation of the flags.
  ///
  /// This is only intended for low-level operations such as writing tokens to
  /// disk.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::getFlags">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 251,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 247,
   FQN="clang::Token::getFlags", NM="_ZNK5clang5Token8getFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token8getFlagsEv")
  //</editor-fold>
  public /*TokenFlags*/char getFlags() /*const*/ {
    return Flags;
  }
  /*friend Preprocessor*/void setFlags(/*TokenFlags*/char Flags) {
    this.Flags = Flags;
  }
  
  
  /// \brief Set a flag to either true or false.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::setFlagValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 256,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 252,
   FQN="clang::Token::setFlagValue", NM="_ZN5clang5Token12setFlagValueENS0_10TokenFlagsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Token12setFlagValueENS0_10TokenFlagsEb")
  //</editor-fold>
  public void setFlagValue(/*Token.TokenFlags*/char Flag, boolean Val) {
    if (Val) {
      setFlag(Flag);
    } else {
      clearFlag(Flag);
    }
  }
  
  
  /// isAtStartOfLine - Return true if this token is at the start of a line.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Token::isAtStartOfLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 265,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 261,
   FQN="clang::Token::isAtStartOfLine", NM="_ZNK5clang5Token15isAtStartOfLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token15isAtStartOfLineEv")
  //</editor-fold>
  public boolean isAtStartOfLine() /*const*/ {
    return getFlag(TokenFlags.StartOfLine);
  }

  
  /// \brief Return true if this token has whitespace before it.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Token::hasLeadingSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 269,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 265,
   FQN="clang::Token::hasLeadingSpace", NM="_ZNK5clang5Token15hasLeadingSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token15hasLeadingSpaceEv")
  //</editor-fold>
  public boolean hasLeadingSpace() /*const*/ {
    return getFlag(TokenFlags.LeadingSpace);
  }

  
  /// \brief Return true if this identifier token should never
  /// be expanded in the future, due to C99 6.10.3.4p2.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::isExpandDisabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 273,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 269,
   FQN="clang::Token::isExpandDisabled", NM="_ZNK5clang5Token16isExpandDisabledEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token16isExpandDisabledEv")
  //</editor-fold>
  public boolean isExpandDisabled() /*const*/ {
    return getFlag(TokenFlags.DisableExpand);
  }
  
  
  /// \brief Return true if we have an ObjC keyword identifier.
  
  //===----------------------------------------------------------------------===//
  // Token Class Implementation
  //===----------------------------------------------------------------------===//
  
  /// isObjCAtKeyword - Return true if we have an ObjC keyword identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::isObjCAtKeyword">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 36,
   FQN="clang::Token::isObjCAtKeyword", NM="_ZNK5clang5Token15isObjCAtKeywordENS_3tok15ObjCKeywordKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token15isObjCAtKeywordENS_3tok15ObjCKeywordKindE")
  //</editor-fold>
  public boolean isObjCAtKeyword(/*tok.ObjCKeywordKind*/char objcKey) /*const*/ {
    {
      IdentifierInfo /*P*/ II = getIdentifierInfo();
      if ((II != null)) {
        return II.getObjCKeywordID() == objcKey;
      }
    }
    return false;
  }

  
  /// \brief Return the ObjC keyword kind.
  
  /// getObjCKeywordID - Return the ObjC keyword kind.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::getObjCKeywordID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 43,
   FQN="clang::Token::getObjCKeywordID", NM="_ZNK5clang5Token16getObjCKeywordIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token16getObjCKeywordIDEv")
  //</editor-fold>
  public /*tok.ObjCKeywordKind*/char getObjCKeywordID() /*const*/ {
    IdentifierInfo /*P*/ specId = getIdentifierInfo();
    return (specId != null) ? specId.getObjCKeywordID() : tok.ObjCKeywordKind.objc_not_keyword;
  }

  
  /// \brief Return true if this token has trigraphs or escaped newlines in it.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::needsCleaning">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 282,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 280,
   FQN="clang::Token::needsCleaning", NM="_ZNK5clang5Token13needsCleaningEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token13needsCleaningEv")
  //</editor-fold>
  public boolean needsCleaning() /*const*/ {
    return getFlag(TokenFlags.NeedsCleaning);
  }

  
  /// \brief Return true if this token has an empty macro before it.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Token::hasLeadingEmptyMacro">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 286,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 284,
   FQN="clang::Token::hasLeadingEmptyMacro", NM="_ZNK5clang5Token20hasLeadingEmptyMacroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token20hasLeadingEmptyMacroEv")
  //</editor-fold>
  public boolean hasLeadingEmptyMacro() /*const*/ {
    return getFlag(TokenFlags.LeadingEmptyMacro);
  }

  
  /// \brief Return true if this token is a string or character literal which
  /// has a ud-suffix.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::hasUDSuffix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 290,
   FQN="clang::Token::hasUDSuffix", NM="_ZNK5clang5Token11hasUDSuffixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token11hasUDSuffixEv")
  //</editor-fold>
  public boolean hasUDSuffix() /*const*/ {
    return getFlag(TokenFlags.HasUDSuffix);
  }

  
  /// Returns true if this token contains a universal character name.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::hasUCN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 293,
   FQN="clang::Token::hasUCN", NM="_ZNK5clang5Token6hasUCNEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token6hasUCNEv")
  //</editor-fold>
  public boolean hasUCN() /*const*/ {
    return getFlag(TokenFlags.HasUCN);
  }
  
  
  /// Returns true if this token is formed by macro by stringizing or charizing
  /// operator.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::stringifiedInMacro">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 297,
   FQN="clang::Token::stringifiedInMacro", NM="_ZNK5clang5Token18stringifiedInMacroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token18stringifiedInMacroEv")
  //</editor-fold>
  public boolean stringifiedInMacro() /*const*/ {
    return getFlag(TokenFlags.StringifiedInMacro);
  }

  
  /// Returns true if the comma after this token was elided.
  //<editor-fold defaultstate="collapsed" desc="clang::Token::commaAfterElided">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 300,
   FQN="clang::Token::commaAfterElided", NM="_ZNK5clang5Token16commaAfterElidedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Token16commaAfterElidedEv")
  //</editor-fold>
  public boolean commaAfterElided() /*const*/ {
    return getFlag(TokenFlags.CommaAfterElided);
  }
  
  // JAVA FIX: support for incomplete tokens
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public boolean isIncomplete() {
    return getFlag(TokenFlags.Incomplete);
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::Token::Token">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 35,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 37,
   FQN="clang::Token::Token", NM="_ZN5clang5TokenC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5TokenC1Ev")
  //</editor-fold>
  public /*inline*/ Token() {
    /* : Loc()*/ 
    //START JInit
    this.Loc = 0;
    //END JInit
    this.index = trackInstance();    
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Token::Token">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 35,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 37,
   FQN="clang::Token::Token", NM="_ZN5clang5TokenC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5TokenC1ERKS0_")
  //</editor-fold>
  public /*inline*/ Token(/*const*/ Token /*&*/ $Prm0) {
    /* : Loc(.Loc), UintData(.UintData), PtrData(.PtrData), Kind(.Kind), Flags(.Flags)*/ 
    //START JInit
    this.Loc = $Prm0.Loc;
    this.UintData = $Prm0.UintData;
    // VV: this is very perf sensitive path, prevent cloning, but
    // VV: make sure it is not broken by caller
    this.PtrData = $Prm0.PtrData;
    this.CharPtrData = $Prm0.CharPtrData;
    this.CharPtrDataIndex = $Prm0.CharPtrDataIndex;
    this.Kind = $Prm0.Kind;
    this.Flags = $Prm0.Flags;
    //END JInit
    this.index = trackInstance();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Token::Token">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 35,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 37,
   FQN="clang::Token::Token", NM="_ZN5clang5TokenC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5TokenC1EOS0_")
  //</editor-fold>
  public /*inline*/ Token(JD$Move _dparam, Token /*&&*/$Prm0) {
    /* : Loc(static_cast<Token &&>().Loc), UintData(static_cast<Token &&>().UintData), PtrData(static_cast<Token &&>().PtrData), Kind(static_cast<Token &&>().Kind), Flags(static_cast<Token &&>().Flags)*/ 
    //START JInit
    this.Loc = $Prm0.Loc;
    this.UintData = $Prm0.UintData;
    // VV: this is very perf sensitive path, prevent cloning, but
    // VV: make sure it is not broken by caller
    this.PtrData = $Prm0.PtrData;
    this.CharPtrData = $Prm0.CharPtrData;
    this.CharPtrDataIndex = $Prm0.CharPtrDataIndex;
    this.Kind = $Prm0.Kind;
    this.Flags = $Prm0.Flags;
    //END JInit
    this.index = trackInstance();
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::Token::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 35,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 37,
   FQN="clang::Token::operator=", NM="_ZN5clang5TokenaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5TokenaSERKS0_")
  //</editor-fold>
  public /*inline*/ Token /*&*/ $assign(/*const*/ Token /*&*/ $Prm0) {
    isDebug(this.index);
    isDebug($Prm0.index);
    this.Loc = $Prm0.Loc;
    this.UintData = $Prm0.UintData;
    this.PtrData = $Prm0.PtrData;
    this.CharPtrData = $Prm0.CharPtrData;
    this.CharPtrDataIndex = $Prm0.CharPtrDataIndex;
    this.Kind = $Prm0.Kind;
    this.Flags = $Prm0.Flags;
    return /*Deref*/this;
  }
  

  //<editor-fold defaultstate="collapsed" desc="clang::Token::~Token">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 35,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 37,
   FQN="clang::Token::~Token", NM="_ZN5clang5TokenD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZN5clang5TokenD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    // JAVA: enough to clear pointer
    PtrData = null;
    CharPtrData = null;
    // Do we need to clean up old kind?
    // Kind = tok.TokenKind.unknown;    
  }
  

  //<editor-fold defaultstate="collapsed" desc="clang::Token::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", line = 35,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Token.h", old_line = 37,
   FQN="clang::Token::operator=", NM="_ZN5clang5TokenaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZN5clang5TokenaSEOS0_")
  //</editor-fold>
  public /*inline*/ Token /*&*/ $assignMove(Token /*&&*/$Prm0) {
    isDebug(this.index);
    isDebug($Prm0.index);
    this.Loc = $Prm0.Loc;
    this.UintData = $Prm0.UintData;
    this.PtrData = $Prm0.PtrData;
    this.CharPtrData = $Prm0.CharPtrData;
    this.CharPtrDataIndex = $Prm0.CharPtrDataIndex;
    this.Kind = $Prm0.Kind;
    this.Flags = $Prm0.Flags;
    return /*Deref*/this;
  }

  private static void isDebug(long index) {
    if (true) return;
    if (index == 28 || index == 48) {
      int  i = 10;
    }
  }

  @Override
  public String toString() {
    return "Tok{[" + this.index + "]Loc=[" + getLocation() + "], UintData=" + $uint2long(UintData) + 
            ", Kind=[" + (int)this.getKind() + ":" + $toString(tok.getTokenName(this.getKind())) + "],"
            + " Flags=" + TokenFlags.toString(Flags) + "[" + NativeTrace.getIdentityStr(PtrData) + "]}";
  }
  
  @Override
  public Token clone() {
    return new Token(this);
  }

  @Override
  public boolean $noteq(Token other) {
    return !$eq(other);
  }

  @Override
  public boolean $eq(Token other) {
    return this.Flags == other.Flags && this.Kind == other.Kind && this.UintData == other.UintData && this.Loc == other.Loc && this.PtrData == other.PtrData;
  }
  
  @Override
  public int $sizeof() {
    return $sizeof_Token();
  }

  public static int $sizeof_Token() {
    return NativeType.BYTES_IN_JAVA_OBJECT_HEADER +
           NativeType.BYTES_IN_UINT + 
           NativeType.BYTES_IN_UINT + 
           NativeType.BYTES_IN_JAVA_OBJECT_REF + 
           NativeType.BYTES_IN_USHORT + 
           NativeType.BYTES_IN_UCHAR;
  }  
  
  private static /*final*/ int index; // To use Debug index - remove static from field and add final
  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long instances = 0;
  private static long failedCharPtrArray = 0;
  private static long failedGetCharPtrArray = 0;

  private static void trackFailedCharPtr() {
    if (NativeTrace.STATISTICS) failedCharPtrArray++;
  }

  private static void trackFailedGetCharPtr() {
    if (NativeTrace.STATISTICS) failedGetCharPtrArray++;
  }
  
  private static int trackInstance() {
    if (NativeTrace.STATISTICS) instances++;
    isDebug(instances);
    return (int)instances;
  }

  public static void clearStatistics() {
    instances = 0;
    failedCharPtrArray = 0;
    failedGetCharPtrArray = 0;
  }
  // JAVA: pass OS and return some integral value
  public static long PrintStats(raw_ostream out) {
    out.$out(String.format("%22s created:\t", Token.class.getSimpleName())).$out(NativeTrace.formatNumber(instances)).$out(".\n");
    out.$out(String.format("%20s no byte[]:\t", Token.class.getSimpleName())).$out(NativeTrace.formatNumber(failedCharPtrArray)).$out(".\n");
    out.$out(String.format("%18s slow byte[]:\t", Token.class.getSimpleName())).$out(NativeTrace.formatNumber(failedGetCharPtrArray)).$out(".\n");
    NativeTrace.dumpStatisticValue(Token.class.getSimpleName(), instances);
    return instances;
  }  
}
