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
import org.clang.basic.*;


/// Inline content (contained within a block).
/// Abstract class.
//<editor-fold defaultstate="collapsed" desc="clang::comments::InlineContentComment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 242,
 FQN="clang::comments::InlineContentComment", NM="_ZN5clang8comments20InlineContentCommentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments20InlineContentCommentE")
//</editor-fold>
public class InlineContentComment extends /*public*/ Comment {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::InlineContentComment::InlineContentComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 244,
   FQN="clang::comments::InlineContentComment::InlineContentComment", NM="_ZN5clang8comments20InlineContentCommentC1ENS0_7Comment11CommentKindENS_14SourceLocationES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments20InlineContentCommentC1ENS0_7Comment11CommentKindENS_14SourceLocationES4_")
  //</editor-fold>
  protected InlineContentComment(CommentKind K, 
      SourceLocation LocBegin, 
      SourceLocation LocEnd) {
    // : Comment(K, LocBegin, LocEnd) 
    //START JInit
    super(K, new SourceLocation(LocBegin), new SourceLocation(LocEnd));
    //END JInit
    Unnamed_field2.InlineContentCommentBits.HasTrailingNewline = false;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::InlineContentComment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 252,
   FQN="clang::comments::InlineContentComment::classof", NM="_ZN5clang8comments20InlineContentComment7classofEPKNS0_7CommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments20InlineContentComment7classofEPKNS0_7CommentE")
  //</editor-fold>
  public static boolean classof(/*const*/ Comment /*P*/ C) {
    return C.getCommentKind().getValue() >= CommentKind.FirstInlineContentCommentConstant.getValue()
       && C.getCommentKind().getValue() <= CommentKind.LastInlineContentCommentConstant.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::InlineContentComment::addTrailingNewline">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 257,
   FQN="clang::comments::InlineContentComment::addTrailingNewline", NM="_ZN5clang8comments20InlineContentComment18addTrailingNewlineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments20InlineContentComment18addTrailingNewlineEv")
  //</editor-fold>
  public void addTrailingNewline() {
    Unnamed_field2.InlineContentCommentBits.HasTrailingNewline = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::InlineContentComment::hasTrailingNewline">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 261,
   FQN="clang::comments::InlineContentComment::hasTrailingNewline", NM="_ZNK5clang8comments20InlineContentComment18hasTrailingNewlineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20InlineContentComment18hasTrailingNewlineEv")
  //</editor-fold>
  public boolean hasTrailingNewline() /*const*/ {
    return Unnamed_field2.InlineContentCommentBits.HasTrailingNewline;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
