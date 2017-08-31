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
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// Plain text.
//<editor-fold defaultstate="collapsed" desc="clang::comments::TextComment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 267,
 FQN="clang::comments::TextComment", NM="_ZN5clang8comments11TextCommentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments11TextCommentE")
//</editor-fold>
public class TextComment extends /*public*/ InlineContentComment {
  private StringRef Text;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextComment::TextComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 271,
   FQN="clang::comments::TextComment::TextComment", NM="_ZN5clang8comments11TextCommentC1ENS_14SourceLocationES2_N4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments11TextCommentC1ENS_14SourceLocationES2_N4llvm9StringRefE")
  //</editor-fold>
  public TextComment(SourceLocation LocBegin, 
      SourceLocation LocEnd, 
      StringRef Text) {
    // : InlineContentComment(TextCommentKind, LocBegin, LocEnd), Text(Text) 
    //START JInit
    super(CommentKind.TextCommentKind, new SourceLocation(LocBegin), new SourceLocation(LocEnd));
    this.Text = new StringRef(Text);
    //END JInit
    Unnamed_field2.TextCommentBits.IsWhitespaceValid = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextComment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 279,
   FQN="clang::comments::TextComment::classof", NM="_ZN5clang8comments11TextComment7classofEPKNS0_7CommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments11TextComment7classofEPKNS0_7CommentE")
  //</editor-fold>
  public static boolean classof(/*const*/ Comment /*P*/ C) {
    return C.getCommentKind() == CommentKind.TextCommentKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextComment::child_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 283,
   FQN="clang::comments::TextComment::child_begin", NM="_ZNK5clang8comments11TextComment11child_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments11TextComment11child_beginEv")
  //</editor-fold>
  public type$ptr<Comment/*P*/> child_begin() /*const*/ {
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextComment::child_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 285,
   FQN="clang::comments::TextComment::child_end", NM="_ZNK5clang8comments11TextComment9child_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments11TextComment9child_endEv")
  //</editor-fold>
  public type$ptr<Comment/*P*/> child_end() /*const*/ {
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextComment::getText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 287,
   FQN="clang::comments::TextComment::getText", NM="_ZNK5clang8comments11TextComment7getTextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments11TextComment7getTextEv")
  //</editor-fold>
  public StringRef getText() /*const*//* __attribute__((pure))*/ {
    return new StringRef(Text);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextComment::isWhitespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 289,
   FQN="clang::comments::TextComment::isWhitespace", NM="_ZNK5clang8comments11TextComment12isWhitespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments11TextComment12isWhitespaceEv")
  //</editor-fold>
  public boolean isWhitespace() /*const*/ {
    if (Unnamed_field2.TextCommentBits.IsWhitespaceValid) {
      return Unnamed_field2.TextCommentBits.IsWhitespace;
    }
    
    Unnamed_field2.TextCommentBits.IsWhitespace = isWhitespaceNoCache();
    Unnamed_field2.TextCommentBits.IsWhitespaceValid = true;
    return Unnamed_field2.TextCommentBits.IsWhitespace;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextComment::isWhitespaceNoCache">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp", line = 97,
   FQN="clang::comments::TextComment::isWhitespaceNoCache", NM="_ZNK5clang8comments11TextComment19isWhitespaceNoCacheEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments11TextComment19isWhitespaceNoCacheEv")
  //</editor-fold>
  private boolean isWhitespaceNoCache() /*const*/ {
    for (char$ptr I = $tryClone(Text.begin()), /*P*/ E = $tryClone(Text.end());
         $noteq_ptr(I, E); I.$preInc()) {
      if (!BasicClangGlobals.isWhitespace(I.$star())) {
        return false;
      }
    }
    return true;
  }

  
  @Override public String toString() {
    return "" + "Text=" + Text // NOI18N
              + super.toString(); // NOI18N
  }
}
