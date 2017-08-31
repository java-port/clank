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
import org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;
import org.clank.support.Native.NativePOD;


/// \brief Stores token information for comparing actual tokens with
/// predefined values.  Only handles simple tokens and identifiers.
//<editor-fold defaultstate="collapsed" desc="clang::TokenValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 65,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 64,
 FQN="clang::TokenValue", NM="_ZN5clang10TokenValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang10TokenValueE")
//</editor-fold>
public class TokenValue implements Native.NativeComparable<TokenValue>, NativePOD<TokenValue>, NativeMoveable<TokenValue> {
  private /*tok.TokenKind*/char Kind;
  private IdentifierInfo /*P*/ II;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TokenValue::TokenValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 70,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 69,
   FQN="clang::TokenValue::TokenValue", NM="_ZN5clang10TokenValueC1ENS_3tok9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang10TokenValueC1ENS_3tok9TokenKindE")
  //</editor-fold>
  public TokenValue(/*tok.TokenKind*/char Kind) {
    /* : Kind(Kind), II(null)*/ 
    //START JInit
    this.Kind = Kind;
    this.II = null;
    //END JInit
    assert (Kind != tok.TokenKind.raw_identifier) : "Raw identifiers are not supported.";
    assert (Kind != tok.TokenKind.identifier) : "Identifiers should be created by TokenValue(IdentifierInfo *)";
    assert (!tok.isLiteral(Kind)) : "Literals are not supported.";
    assert (!tok.isAnnotation(Kind)) : "Annotations are not supported.";
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TokenValue::TokenValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 77,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 76,
   FQN="clang::TokenValue::TokenValue", NM="_ZN5clang10TokenValueC1EPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang10TokenValueC1EPNS_14IdentifierInfoE")
  //</editor-fold>
  public TokenValue(IdentifierInfo /*P*/ II) {
    /* : Kind(tok::identifier), II(II)*/ 
    //START JInit
    this.Kind = tok.TokenKind.identifier;
    this.II = II;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TokenValue::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 78,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 77,
   FQN="clang::TokenValue::operator==", NM="_ZNK5clang10TokenValueeqERKNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZNK5clang10TokenValueeqERKNS_5TokenE")
  //</editor-fold>
  public boolean $eq(/*const*/ Token /*&*/ Tok) /*const*/ {
    return Tok.getKind() == Kind
       && (!(II != null) || II == Tok.getIdentifierInfo());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TokenValue::TokenValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 65,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 64,
   FQN="clang::TokenValue::TokenValue", NM="_ZN5clang10TokenValueC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang10TokenValueC1EOS0_")
  //</editor-fold>
  public /*inline*/ TokenValue(JD$Move _dparam, TokenValue /*&&*/$Prm0) {
    /* : Kind(static_cast<TokenValue &&>().Kind), II(static_cast<TokenValue &&>().II)*/ 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.II = $Prm0.II;
    //END JInit
  }

  public TokenValue() {
    /*for collections*/
    this('\0');
  }
  
  public /*inline*/ TokenValue(TokenValue /*&&*/$Prm0) {
    /* : Kind(static_cast<TokenValue &&>().Kind), II(static_cast<TokenValue &&>().II)*/ 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.II = $Prm0.II;
    //END JInit
  }

  @Override
  public TokenValue $assign(TokenValue $Prm0) {
    this.Kind = $Prm0.Kind;
    this.II = $Prm0.II;
    return this;
  }

  @Override
  public TokenValue clone() {
    return new TokenValue(this);
  }

  @Override
  public TokenValue move() {
    return new TokenValue(JD$Move.INSTANCE, this);
  }
  
  public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", II=" + II; // NOI18N
  }
}
