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
import static org.clank.support.Casts.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstRTTI.*;

/// A single paragraph that contains inline content.
//<editor-fold defaultstate="collapsed" desc="clang::comments::ParagraphComment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 552,
 FQN="clang::comments::ParagraphComment", NM="_ZN5clang8comments16ParagraphCommentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments16ParagraphCommentE")
//</editor-fold>
public class ParagraphComment extends /*public*/ BlockContentComment {
  private ArrayRef<InlineContentComment /*P*/ > Content;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParagraphComment::ParagraphComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 556,
   FQN="clang::comments::ParagraphComment::ParagraphComment", NM="_ZN5clang8comments16ParagraphCommentC1EN4llvm8ArrayRefIPNS0_20InlineContentCommentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments16ParagraphCommentC1EN4llvm8ArrayRefIPNS0_20InlineContentCommentEEE")
  //</editor-fold>
  public ParagraphComment(ArrayRef<InlineContentComment /*P*/ > Content) {
    // : BlockContentComment(ParagraphCommentKind, SourceLocation(), SourceLocation()), Content(Content) 
    //START JInit
    super(CommentKind.ParagraphCommentKind, 
        new SourceLocation(), 
        new SourceLocation());
    this.Content = new ArrayRef<InlineContentComment /*P*/ >(Content);
    //END JInit
    if (Content.empty()) {
      Unnamed_field2.ParagraphCommentBits.IsWhitespace = true;
      Unnamed_field2.ParagraphCommentBits.IsWhitespaceValid = true;
      return;
    }
    
    Unnamed_field2.ParagraphCommentBits.IsWhitespaceValid = false;
    
    setSourceRange(new SourceRange(Content.front().getLocStart(), 
            Content.back().getLocEnd()));
    setLocation(Content.front().getLocStart());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParagraphComment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 574,
   FQN="clang::comments::ParagraphComment::classof", NM="_ZN5clang8comments16ParagraphComment7classofEPKNS0_7CommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments16ParagraphComment7classofEPKNS0_7CommentE")
  //</editor-fold>
  public static boolean classof(/*const*/ Comment /*P*/ C) {
    return C.getCommentKind() == CommentKind.ParagraphCommentKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParagraphComment::child_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 578,
   FQN="clang::comments::ParagraphComment::child_begin", NM="_ZNK5clang8comments16ParagraphComment11child_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments16ParagraphComment11child_beginEv")
  //</editor-fold>
  public type$ptr<Comment/*P*/> child_begin() /*const*/ {
    return ((type$ptr<Comment/*P*/> )reinterpret_cast(type$ptr.class, Content.begin()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParagraphComment::child_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 582,
   FQN="clang::comments::ParagraphComment::child_end", NM="_ZNK5clang8comments16ParagraphComment9child_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments16ParagraphComment9child_endEv")
  //</editor-fold>
  public type$ptr<Comment/*P*/> child_end() /*const*/ {
    return ((type$ptr<Comment/*P*/> )reinterpret_cast(type$ptr.class, Content.end()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParagraphComment::isWhitespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 586,
   FQN="clang::comments::ParagraphComment::isWhitespace", NM="_ZNK5clang8comments16ParagraphComment12isWhitespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments16ParagraphComment12isWhitespaceEv")
  //</editor-fold>
  public boolean isWhitespace() /*const*/ {
    if (Unnamed_field2.ParagraphCommentBits.IsWhitespaceValid) {
      return Unnamed_field2.ParagraphCommentBits.IsWhitespace;
    }
    
    Unnamed_field2.ParagraphCommentBits.IsWhitespace = isWhitespaceNoCache();
    Unnamed_field2.ParagraphCommentBits.IsWhitespaceValid = true;
    return Unnamed_field2.ParagraphCommentBits.IsWhitespace;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParagraphComment::isWhitespaceNoCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp", line = 106,
   FQN="clang::comments::ParagraphComment::isWhitespaceNoCache", NM="_ZNK5clang8comments16ParagraphComment19isWhitespaceNoCacheEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments16ParagraphComment19isWhitespaceNoCacheEv")
  //</editor-fold>
  private boolean isWhitespaceNoCache() /*const*/ {
    for (type$ptr<Comment/*P*/> I = $tryClone(child_begin()), /*P*/ /*const*/ /*P*/ E = $tryClone(child_end()); $noteq_ptr(I, E); I.$preInc()) {
      {
        /*const*/ TextComment /*P*/ TC = dyn_cast_TextComment(I.$star());
        if ((TC != null)) {
          if (!TC.isWhitespace()) {
            return false;
          }
        } else {
          return false;
        }
      }
    }
    return true;
  }

  
  @Override public String toString() {
    return "" + "Content=" + Content // NOI18N
              + super.toString(); // NOI18N
  }
}
