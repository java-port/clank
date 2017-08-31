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
import org.llvm.adt.*;
import org.clang.basic.*;


/// Abstract class for opening and closing HTML tags.  HTML tags are always
/// treated as inline content (regardless HTML semantics).
//<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLTagComment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 377,
 FQN="clang::comments::HTMLTagComment", NM="_ZN5clang8comments14HTMLTagCommentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments14HTMLTagCommentE")
//</editor-fold>
public class HTMLTagComment extends /*public*/ InlineContentComment {
/*protected:*/
  protected StringRef TagName;
  protected SourceRange TagNameRange;
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLTagComment::HTMLTagComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 382,
   FQN="clang::comments::HTMLTagComment::HTMLTagComment", NM="_ZN5clang8comments14HTMLTagCommentC1ENS0_7Comment11CommentKindENS_14SourceLocationES4_N4llvm9StringRefES4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments14HTMLTagCommentC1ENS0_7Comment11CommentKindENS_14SourceLocationES4_N4llvm9StringRefES4_S4_")
  //</editor-fold>
  protected HTMLTagComment(CommentKind K, 
      SourceLocation LocBegin, 
      SourceLocation LocEnd, 
      StringRef TagName, 
      SourceLocation TagNameBegin, 
      SourceLocation TagNameEnd) {
    // : InlineContentComment(K, LocBegin, LocEnd), TagName(TagName), TagNameRange(TagNameBegin, TagNameEnd) 
    //START JInit
    super(K, new SourceLocation(LocBegin), new SourceLocation(LocEnd));
    this.TagName = new StringRef(TagName);
    this.TagNameRange = new SourceRange(/*NO_COPY*/TagNameBegin, /*NO_COPY*/TagNameEnd);
    //END JInit
    setLocation(new SourceLocation(TagNameBegin));
    Unnamed_field2.HTMLTagCommentBits.IsMalformed = false;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLTagComment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 396,
   FQN="clang::comments::HTMLTagComment::classof", NM="_ZN5clang8comments14HTMLTagComment7classofEPKNS0_7CommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments14HTMLTagComment7classofEPKNS0_7CommentE")
  //</editor-fold>
  public static boolean classof(/*const*/ Comment /*P*/ C) {
    return C.getCommentKind().getValue() >= CommentKind.FirstHTMLTagCommentConstant.getValue()
       && C.getCommentKind().getValue() <= CommentKind.LastHTMLTagCommentConstant.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLTagComment::getTagName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 401,
   FQN="clang::comments::HTMLTagComment::getTagName", NM="_ZNK5clang8comments14HTMLTagComment10getTagNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments14HTMLTagComment10getTagNameEv")
  //</editor-fold>
  public StringRef getTagName() /*const*//* __attribute__((pure))*/ {
    return new StringRef(TagName);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLTagComment::getTagNameSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 403,
   FQN="clang::comments::HTMLTagComment::getTagNameSourceRange", NM="_ZNK5clang8comments14HTMLTagComment21getTagNameSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments14HTMLTagComment21getTagNameSourceRangeEv")
  //</editor-fold>
  public SourceRange getTagNameSourceRange() /*const*//* __attribute__((pure))*/ {
    SourceLocation L = getLocation();
    return new SourceRange(L.getLocWithOffset(1), 
        L.getLocWithOffset(1 + TagName.size()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLTagComment::isMalformed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 409,
   FQN="clang::comments::HTMLTagComment::isMalformed", NM="_ZNK5clang8comments14HTMLTagComment11isMalformedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments14HTMLTagComment11isMalformedEv")
  //</editor-fold>
  public boolean isMalformed() /*const*/ {
    return Unnamed_field2.HTMLTagCommentBits.IsMalformed;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLTagComment::setIsMalformed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 413,
   FQN="clang::comments::HTMLTagComment::setIsMalformed", NM="_ZN5clang8comments14HTMLTagComment14setIsMalformedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments14HTMLTagComment14setIsMalformedEv")
  //</editor-fold>
  public void setIsMalformed() {
    Unnamed_field2.HTMLTagCommentBits.IsMalformed = true;
  }

  
  @Override public String toString() {
    return "" + "TagName=" + TagName // NOI18N
              + ", TagNameRange=" + TagNameRange // NOI18N
              + super.toString(); // NOI18N
  }
}
