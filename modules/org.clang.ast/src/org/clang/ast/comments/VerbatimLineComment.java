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
import org.llvm.adt.*;
import org.clang.basic.*;


/// A verbatim line command.  Verbatim line has an opening command, a single
/// line of text (up to the newline after the opening command) and has no
/// closing command.
//<editor-fold defaultstate="collapsed" desc="clang::comments::VerbatimLineComment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 949,
 FQN="clang::comments::VerbatimLineComment", NM="_ZN5clang8comments19VerbatimLineCommentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19VerbatimLineCommentE")
//</editor-fold>
public class VerbatimLineComment extends /*public*/ BlockCommandComment {
/*protected:*/
  protected StringRef Text;
  protected SourceLocation TextBegin;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::VerbatimLineComment::VerbatimLineComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 955,
   FQN="clang::comments::VerbatimLineComment::VerbatimLineComment", NM="_ZN5clang8comments19VerbatimLineCommentC1ENS_14SourceLocationES2_jS2_N4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19VerbatimLineCommentC1ENS_14SourceLocationES2_jS2_N4llvm9StringRefE")
  //</editor-fold>
  public VerbatimLineComment(SourceLocation LocBegin, 
      SourceLocation LocEnd, 
      /*uint*/int CommandID, 
      SourceLocation TextBegin, 
      StringRef Text) {
    // : BlockCommandComment(VerbatimLineCommentKind, LocBegin, LocEnd, CommandID, CMK_At), Text(Text), TextBegin(TextBegin) 
    //START JInit
    super(CommentKind.VerbatimLineCommentKind, 
        new SourceLocation(LocBegin), new SourceLocation(LocEnd), 
        CommandID, 
        CommandMarkerKind.CMK_At); // FIXME: improve source fidelity.
    this.Text = new StringRef(Text);
    this.TextBegin = new SourceLocation(TextBegin);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::VerbatimLineComment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 968,
   FQN="clang::comments::VerbatimLineComment::classof", NM="_ZN5clang8comments19VerbatimLineComment7classofEPKNS0_7CommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19VerbatimLineComment7classofEPKNS0_7CommentE")
  //</editor-fold>
  public static boolean classof(/*const*/ Comment /*P*/ C) {
    return C.getCommentKind() == CommentKind.VerbatimLineCommentKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::VerbatimLineComment::child_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 972,
   FQN="clang::comments::VerbatimLineComment::child_begin", NM="_ZNK5clang8comments19VerbatimLineComment11child_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19VerbatimLineComment11child_beginEv")
  //</editor-fold>
  public type$ptr<Comment/*P*/> child_begin() /*const*/ {
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::VerbatimLineComment::child_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 974,
   FQN="clang::comments::VerbatimLineComment::child_end", NM="_ZNK5clang8comments19VerbatimLineComment9child_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19VerbatimLineComment9child_endEv")
  //</editor-fold>
  public type$ptr<Comment/*P*/> child_end() /*const*/ {
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::VerbatimLineComment::getText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 976,
   FQN="clang::comments::VerbatimLineComment::getText", NM="_ZNK5clang8comments19VerbatimLineComment7getTextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19VerbatimLineComment7getTextEv")
  //</editor-fold>
  public StringRef getText() /*const*/ {
    return new StringRef(Text);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::VerbatimLineComment::getTextRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 980,
   FQN="clang::comments::VerbatimLineComment::getTextRange", NM="_ZNK5clang8comments19VerbatimLineComment12getTextRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19VerbatimLineComment12getTextRangeEv")
  //</editor-fold>
  public SourceRange getTextRange() /*const*/ {
    return new SourceRange(/*NO_COPY*/TextBegin, getLocEnd());
  }

  
  @Override public String toString() {
    return "" + "Text=" + Text // NOI18N
              + ", TextBegin=" + TextBegin // NOI18N
              + super.toString(); // NOI18N
  }
}
