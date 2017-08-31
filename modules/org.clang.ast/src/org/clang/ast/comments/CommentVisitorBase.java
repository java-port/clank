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
import org.llvm.support.*;

/*template <template <typename > class Ptr, typename ImplClass, typename RetTy = void> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentVisitor.h", line = 22,
 FQN="clang::comments::CommentVisitorBase", NM="_ZN5clang8comments18CommentVisitorBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBaseE")
//</editor-fold>
public interface/*class*/ CommentVisitorBase</*template <typename > TEMPLATE*/
/*class*/ Ptr, /*typename*/ ImplClass extends CommentVisitorBase<?, ?, RetTy>, /*typename*/ RetTy/* = void*/>  {
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentVisitor.h", line = 29,
   FQN="clang::comments::CommentVisitorBase::visit", NM="_ZN5clang8comments18CommentVisitorBase5visitENT_INS0_7CommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase5visitENT_INS0_7CommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy visit(Comment/*P*/ C) {
    if (C == null) {
      return $CommentVisitorBase$RetTy();
    }
    switch (C.getCommentKind()) {
     default:
      throw new llvm_unreachable("Unknown comment kind!");
     case BlockCommandCommentKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).visitBlockCommandComment(((/*static_cast*/BlockCommandComment/*P*/)(C)));
     case ParamCommandCommentKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).visitParamCommandComment(((/*static_cast*/ParamCommandComment/*P*/)(C)));
     case TParamCommandCommentKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).visitTParamCommandComment(((/*static_cast*/TParamCommandComment/*P*/)(C)));
     case VerbatimBlockCommentKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).visitVerbatimBlockComment(((/*static_cast*/VerbatimBlockComment/*P*/)(C)));
     case VerbatimLineCommentKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).visitVerbatimLineComment(((/*static_cast*/VerbatimLineComment/*P*/)(C)));
     case ParagraphCommentKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).visitParagraphComment(((/*static_cast*/ParagraphComment/*P*/)(C)));
     case FullCommentKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).visitFullComment(((/*static_cast*/FullComment/*P*/)(C)));
     case HTMLEndTagCommentKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).visitHTMLEndTagComment(((/*static_cast*/HTMLEndTagComment/*P*/)(C)));
     case HTMLStartTagCommentKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).visitHTMLStartTagComment(((/*static_cast*/HTMLStartTagComment/*P*/)(C)));
     case InlineCommandCommentKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).visitInlineCommandComment(((/*static_cast*/InlineCommandComment/*P*/)(C)));
     case TextCommentKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).visitTextComment(((/*static_cast*/TextComment/*P*/)(C)));
     case VerbatimBlockLineCommentKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).visitVerbatimBlockLineComment(((/*static_cast*/VerbatimBlockLineComment/*P*/)(C)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitBlockContentComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 23,
   FQN="clang::comments::CommentVisitorBase::visitBlockContentComment", NM="_ZN5clang8comments18CommentVisitorBase24visitBlockContentCommentENT_INS0_19BlockContentCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase24visitBlockContentCommentENT_INS0_19BlockContentCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy visitBlockContentComment(BlockContentComment/*P*/ C) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).visitComment(((/*static_cast*/Comment/*P*/)(C)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitBlockCommandComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 27,
   FQN="clang::comments::CommentVisitorBase::visitBlockCommandComment", NM="_ZN5clang8comments18CommentVisitorBase24visitBlockCommandCommentENT_INS0_19BlockCommandCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase24visitBlockCommandCommentENT_INS0_19BlockCommandCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy visitBlockCommandComment(BlockCommandComment/*P*/ C) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).visitBlockContentComment(((/*static_cast*/BlockContentComment/*P*/)(C)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitParamCommandComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 31,
   FQN="clang::comments::CommentVisitorBase::visitParamCommandComment", NM="_ZN5clang8comments18CommentVisitorBase24visitParamCommandCommentENT_INS0_19ParamCommandCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase24visitParamCommandCommentENT_INS0_19ParamCommandCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy visitParamCommandComment(ParamCommandComment/*P*/ C) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).visitBlockCommandComment(((/*static_cast*/BlockCommandComment/*P*/)(C)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitTParamCommandComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 37,
   FQN="clang::comments::CommentVisitorBase::visitTParamCommandComment", NM="_ZN5clang8comments18CommentVisitorBase25visitTParamCommandCommentENT_INS0_20TParamCommandCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase25visitTParamCommandCommentENT_INS0_20TParamCommandCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy visitTParamCommandComment(TParamCommandComment/*P*/ C) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).visitBlockCommandComment(((/*static_cast*/BlockCommandComment/*P*/)(C)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitVerbatimBlockComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 43,
   FQN="clang::comments::CommentVisitorBase::visitVerbatimBlockComment", NM="_ZN5clang8comments18CommentVisitorBase25visitVerbatimBlockCommentENT_INS0_20VerbatimBlockCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase25visitVerbatimBlockCommentENT_INS0_20VerbatimBlockCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy visitVerbatimBlockComment(VerbatimBlockComment/*P*/ C) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).visitBlockCommandComment(((/*static_cast*/BlockCommandComment/*P*/)(C)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitVerbatimLineComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 49,
   FQN="clang::comments::CommentVisitorBase::visitVerbatimLineComment", NM="_ZN5clang8comments18CommentVisitorBase24visitVerbatimLineCommentENT_INS0_19VerbatimLineCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase24visitVerbatimLineCommentENT_INS0_19VerbatimLineCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy visitVerbatimLineComment(VerbatimLineComment/*P*/ C) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).visitBlockCommandComment(((/*static_cast*/BlockCommandComment/*P*/)(C)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitParagraphComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 59,
   FQN="clang::comments::CommentVisitorBase::visitParagraphComment", NM="_ZN5clang8comments18CommentVisitorBase21visitParagraphCommentENT_INS0_16ParagraphCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase21visitParagraphCommentENT_INS0_16ParagraphCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy visitParagraphComment(ParagraphComment/*P*/ C) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).visitBlockContentComment(((/*static_cast*/BlockContentComment/*P*/)(C)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitFullComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 69,
   FQN="clang::comments::CommentVisitorBase::visitFullComment", NM="_ZN5clang8comments18CommentVisitorBase16visitFullCommentENT_INS0_11FullCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase16visitFullCommentENT_INS0_11FullCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy visitFullComment(FullComment/*P*/ C) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).visitComment(((/*static_cast*/Comment/*P*/)(C)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitInlineContentComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 75,
   FQN="clang::comments::CommentVisitorBase::visitInlineContentComment", NM="_ZN5clang8comments18CommentVisitorBase25visitInlineContentCommentENT_INS0_20InlineContentCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase25visitInlineContentCommentENT_INS0_20InlineContentCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy visitInlineContentComment(InlineContentComment/*P*/ C) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).visitComment(((/*static_cast*/Comment/*P*/)(C)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitHTMLTagComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 79,
   FQN="clang::comments::CommentVisitorBase::visitHTMLTagComment", NM="_ZN5clang8comments18CommentVisitorBase19visitHTMLTagCommentENT_INS0_14HTMLTagCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase19visitHTMLTagCommentENT_INS0_14HTMLTagCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy visitHTMLTagComment(HTMLTagComment/*P*/ C) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).visitInlineContentComment(((/*static_cast*/InlineContentComment/*P*/)(C)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitHTMLEndTagComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 83,
   FQN="clang::comments::CommentVisitorBase::visitHTMLEndTagComment", NM="_ZN5clang8comments18CommentVisitorBase22visitHTMLEndTagCommentENT_INS0_17HTMLEndTagCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase22visitHTMLEndTagCommentENT_INS0_17HTMLEndTagCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy visitHTMLEndTagComment(HTMLEndTagComment/*P*/ C) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).visitHTMLTagComment(((/*static_cast*/HTMLTagComment/*P*/)(C)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitHTMLStartTagComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 89,
   FQN="clang::comments::CommentVisitorBase::visitHTMLStartTagComment", NM="_ZN5clang8comments18CommentVisitorBase24visitHTMLStartTagCommentENT_INS0_19HTMLStartTagCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase24visitHTMLStartTagCommentENT_INS0_19HTMLStartTagCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy visitHTMLStartTagComment(HTMLStartTagComment/*P*/ C) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).visitHTMLTagComment(((/*static_cast*/HTMLTagComment/*P*/)(C)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitInlineCommandComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 99,
   FQN="clang::comments::CommentVisitorBase::visitInlineCommandComment", NM="_ZN5clang8comments18CommentVisitorBase25visitInlineCommandCommentENT_INS0_20InlineCommandCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase25visitInlineCommandCommentENT_INS0_20InlineCommandCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy visitInlineCommandComment(InlineCommandComment/*P*/ C) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).visitInlineContentComment(((/*static_cast*/InlineContentComment/*P*/)(C)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitTextComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 105,
   FQN="clang::comments::CommentVisitorBase::visitTextComment", NM="_ZN5clang8comments18CommentVisitorBase16visitTextCommentENT_INS0_11TextCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase16visitTextCommentENT_INS0_11TextCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy visitTextComment(TextComment/*P*/ C) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).visitInlineContentComment(((/*static_cast*/InlineContentComment/*P*/)(C)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitVerbatimBlockLineComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 115,
   FQN="clang::comments::CommentVisitorBase::visitVerbatimBlockLineComment", NM="_ZN5clang8comments18CommentVisitorBase29visitVerbatimBlockLineCommentENT_INS0_24VerbatimBlockLineCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase29visitVerbatimBlockLineCommentENT_INS0_24VerbatimBlockLineCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy visitVerbatimBlockLineComment(VerbatimBlockLineComment/*P*/ C) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).visitComment(((/*static_cast*/Comment/*P*/)(C)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitComment">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentVisitor.h", line = 53,
   FQN="clang::comments::CommentVisitorBase::visitComment", NM="_ZN5clang8comments18CommentVisitorBase12visitCommentENT_INS0_7CommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase12visitCommentENT_INS0_7CommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy visitComment(Comment/*P*/ C) {
    return $CommentVisitorBase$RetTy();
  }

  // JAVA: default value for default implementations
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public default RetTy $CommentVisitorBase$RetTy() {
    return null;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public default void $destroy$CommentVisitorBase() { }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
}
