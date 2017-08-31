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
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentVisitor.h", line = 22,
 FQN="clang::comments::CommentVisitorBase", NM="_ZN5clang8comments18CommentVisitorBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBaseE")
//</editor-fold>
public interface/*class*/ CommentVisitorBaseVoid</*template <typename > TEMPLATE*/
/*class*/ Ptr, /*typename*/ ImplClass extends CommentVisitorBaseVoid<?, ?>/*, typename RetTy = void*/>  {
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visit">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentVisitor.h", line = 29,
   FQN="clang::comments::CommentVisitorBase::visit", NM="_ZN5clang8comments18CommentVisitorBase5visitENT_INS0_7CommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase5visitENT_INS0_7CommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ void visit(Comment/*P*/ C) {
    if (C == null) {
      return /*void*/;
    }
    switch (C.getCommentKind()) {
     default:
      throw new llvm_unreachable("Unknown comment kind!");
     case BlockCommandCommentKind:
      ((/*static_cast*/ImplClass /*P*/ )(this)).visitBlockCommandComment(((/*static_cast*/BlockCommandComment/*P*/)(C))); return;
     case ParamCommandCommentKind:
      ((/*static_cast*/ImplClass /*P*/ )(this)).visitParamCommandComment(((/*static_cast*/ParamCommandComment/*P*/)(C))); return;
     case TParamCommandCommentKind:
      ((/*static_cast*/ImplClass /*P*/ )(this)).visitTParamCommandComment(((/*static_cast*/TParamCommandComment/*P*/)(C))); return;
     case VerbatimBlockCommentKind:
      ((/*static_cast*/ImplClass /*P*/ )(this)).visitVerbatimBlockComment(((/*static_cast*/VerbatimBlockComment/*P*/)(C))); return;
     case VerbatimLineCommentKind:
      ((/*static_cast*/ImplClass /*P*/ )(this)).visitVerbatimLineComment(((/*static_cast*/VerbatimLineComment/*P*/)(C))); return;
     case ParagraphCommentKind:
      ((/*static_cast*/ImplClass /*P*/ )(this)).visitParagraphComment(((/*static_cast*/ParagraphComment/*P*/)(C))); return;
     case FullCommentKind:
      ((/*static_cast*/ImplClass /*P*/ )(this)).visitFullComment(((/*static_cast*/FullComment/*P*/)(C))); return;
     case HTMLEndTagCommentKind:
      ((/*static_cast*/ImplClass /*P*/ )(this)).visitHTMLEndTagComment(((/*static_cast*/HTMLEndTagComment/*P*/)(C))); return;
     case HTMLStartTagCommentKind:
      ((/*static_cast*/ImplClass /*P*/ )(this)).visitHTMLStartTagComment(((/*static_cast*/HTMLStartTagComment/*P*/)(C))); return;
     case InlineCommandCommentKind:
      ((/*static_cast*/ImplClass /*P*/ )(this)).visitInlineCommandComment(((/*static_cast*/InlineCommandComment/*P*/)(C))); return;
     case TextCommentKind:
      ((/*static_cast*/ImplClass /*P*/ )(this)).visitTextComment(((/*static_cast*/TextComment/*P*/)(C))); return;
     case VerbatimBlockLineCommentKind:
      ((/*static_cast*/ImplClass /*P*/ )(this)).visitVerbatimBlockLineComment(((/*static_cast*/VerbatimBlockLineComment/*P*/)(C))); return;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitBlockContentComment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 23,
   FQN="clang::comments::CommentVisitorBase::visitBlockContentComment", NM="_ZN5clang8comments18CommentVisitorBase24visitBlockContentCommentENT_INS0_19BlockContentCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase24visitBlockContentCommentENT_INS0_19BlockContentCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ void visitBlockContentComment(BlockContentComment/*P*/ C) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).visitComment(((/*static_cast*/Comment/*P*/)(C))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitBlockCommandComment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 27,
   FQN="clang::comments::CommentVisitorBase::visitBlockCommandComment", NM="_ZN5clang8comments18CommentVisitorBase24visitBlockCommandCommentENT_INS0_19BlockCommandCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase24visitBlockCommandCommentENT_INS0_19BlockCommandCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ void visitBlockCommandComment(BlockCommandComment/*P*/ C) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).visitBlockContentComment(((/*static_cast*/BlockContentComment/*P*/)(C))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitParamCommandComment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 31,
   FQN="clang::comments::CommentVisitorBase::visitParamCommandComment", NM="_ZN5clang8comments18CommentVisitorBase24visitParamCommandCommentENT_INS0_19ParamCommandCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase24visitParamCommandCommentENT_INS0_19ParamCommandCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ void visitParamCommandComment(ParamCommandComment/*P*/ C) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).visitBlockCommandComment(((/*static_cast*/BlockCommandComment/*P*/)(C))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitTParamCommandComment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 37,
   FQN="clang::comments::CommentVisitorBase::visitTParamCommandComment", NM="_ZN5clang8comments18CommentVisitorBase25visitTParamCommandCommentENT_INS0_20TParamCommandCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase25visitTParamCommandCommentENT_INS0_20TParamCommandCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ void visitTParamCommandComment(TParamCommandComment/*P*/ C) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).visitBlockCommandComment(((/*static_cast*/BlockCommandComment/*P*/)(C))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitVerbatimBlockComment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 43,
   FQN="clang::comments::CommentVisitorBase::visitVerbatimBlockComment", NM="_ZN5clang8comments18CommentVisitorBase25visitVerbatimBlockCommentENT_INS0_20VerbatimBlockCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase25visitVerbatimBlockCommentENT_INS0_20VerbatimBlockCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ void visitVerbatimBlockComment(VerbatimBlockComment/*P*/ C) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).visitBlockCommandComment(((/*static_cast*/BlockCommandComment/*P*/)(C))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitVerbatimLineComment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 49,
   FQN="clang::comments::CommentVisitorBase::visitVerbatimLineComment", NM="_ZN5clang8comments18CommentVisitorBase24visitVerbatimLineCommentENT_INS0_19VerbatimLineCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase24visitVerbatimLineCommentENT_INS0_19VerbatimLineCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ void visitVerbatimLineComment(VerbatimLineComment/*P*/ C) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).visitBlockCommandComment(((/*static_cast*/BlockCommandComment/*P*/)(C))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitParagraphComment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 59,
   FQN="clang::comments::CommentVisitorBase::visitParagraphComment", NM="_ZN5clang8comments18CommentVisitorBase21visitParagraphCommentENT_INS0_16ParagraphCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase21visitParagraphCommentENT_INS0_16ParagraphCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ void visitParagraphComment(ParagraphComment/*P*/ C) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).visitBlockContentComment(((/*static_cast*/BlockContentComment/*P*/)(C))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitFullComment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 69,
   FQN="clang::comments::CommentVisitorBase::visitFullComment", NM="_ZN5clang8comments18CommentVisitorBase16visitFullCommentENT_INS0_11FullCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase16visitFullCommentENT_INS0_11FullCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ void visitFullComment(FullComment/*P*/ C) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).visitComment(((/*static_cast*/Comment/*P*/)(C))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitInlineContentComment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 75,
   FQN="clang::comments::CommentVisitorBase::visitInlineContentComment", NM="_ZN5clang8comments18CommentVisitorBase25visitInlineContentCommentENT_INS0_20InlineContentCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase25visitInlineContentCommentENT_INS0_20InlineContentCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ void visitInlineContentComment(InlineContentComment/*P*/ C) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).visitComment(((/*static_cast*/Comment/*P*/)(C))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitHTMLTagComment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 79,
   FQN="clang::comments::CommentVisitorBase::visitHTMLTagComment", NM="_ZN5clang8comments18CommentVisitorBase19visitHTMLTagCommentENT_INS0_14HTMLTagCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase19visitHTMLTagCommentENT_INS0_14HTMLTagCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ void visitHTMLTagComment(HTMLTagComment/*P*/ C) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).visitInlineContentComment(((/*static_cast*/InlineContentComment/*P*/)(C))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitHTMLEndTagComment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 83,
   FQN="clang::comments::CommentVisitorBase::visitHTMLEndTagComment", NM="_ZN5clang8comments18CommentVisitorBase22visitHTMLEndTagCommentENT_INS0_17HTMLEndTagCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase22visitHTMLEndTagCommentENT_INS0_17HTMLEndTagCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ void visitHTMLEndTagComment(HTMLEndTagComment/*P*/ C) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).visitHTMLTagComment(((/*static_cast*/HTMLTagComment/*P*/)(C))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitHTMLStartTagComment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 89,
   FQN="clang::comments::CommentVisitorBase::visitHTMLStartTagComment", NM="_ZN5clang8comments18CommentVisitorBase24visitHTMLStartTagCommentENT_INS0_19HTMLStartTagCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase24visitHTMLStartTagCommentENT_INS0_19HTMLStartTagCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ void visitHTMLStartTagComment(HTMLStartTagComment/*P*/ C) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).visitHTMLTagComment(((/*static_cast*/HTMLTagComment/*P*/)(C))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitInlineCommandComment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 99,
   FQN="clang::comments::CommentVisitorBase::visitInlineCommandComment", NM="_ZN5clang8comments18CommentVisitorBase25visitInlineCommandCommentENT_INS0_20InlineCommandCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase25visitInlineCommandCommentENT_INS0_20InlineCommandCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ void visitInlineCommandComment(InlineCommandComment/*P*/ C) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).visitInlineContentComment(((/*static_cast*/InlineContentComment/*P*/)(C))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitTextComment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 105,
   FQN="clang::comments::CommentVisitorBase::visitTextComment", NM="_ZN5clang8comments18CommentVisitorBase16visitTextCommentENT_INS0_11TextCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase16visitTextCommentENT_INS0_11TextCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ void visitTextComment(TextComment/*P*/ C) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).visitInlineContentComment(((/*static_cast*/InlineContentComment/*P*/)(C))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitVerbatimBlockLineComment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentNodes.inc", line = 115,
   FQN="clang::comments::CommentVisitorBase::visitVerbatimBlockLineComment", NM="_ZN5clang8comments18CommentVisitorBase29visitVerbatimBlockLineCommentENT_INS0_24VerbatimBlockLineCommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase29visitVerbatimBlockLineCommentENT_INS0_24VerbatimBlockLineCommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ void visitVerbatimBlockLineComment(VerbatimBlockLineComment/*P*/ C) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).visitComment(((/*static_cast*/Comment/*P*/)(C))); return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommentVisitorBase::visitComment">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentVisitor.h", line = 53,
   FQN="clang::comments::CommentVisitorBase::visitComment", NM="_ZN5clang8comments18CommentVisitorBase12visitCommentENT_INS0_7CommentEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Index/CommentToXML.cpp -nm=_ZN5clang8comments18CommentVisitorBase12visitCommentENT_INS0_7CommentEE4typeE")
  //</editor-fold>
  public default/*interface*/ void visitComment(Comment/*P*/ C) {
    return /*void*/;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public default void $destroy$CommentVisitorBase() { }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
}
