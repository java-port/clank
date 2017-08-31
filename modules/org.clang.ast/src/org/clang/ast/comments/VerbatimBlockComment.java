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
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


/// A verbatim block command (e. g., preformatted code).  Verbatim block has an
/// opening and a closing command and contains multiple lines of text
/// (VerbatimBlockLineComment nodes).
//<editor-fold defaultstate="collapsed" desc="clang::comments::VerbatimBlockComment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 897,
 FQN="clang::comments::VerbatimBlockComment", NM="_ZN5clang8comments20VerbatimBlockCommentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments20VerbatimBlockCommentE")
//</editor-fold>
public class VerbatimBlockComment extends /*public*/ BlockCommandComment {
/*protected:*/
  protected StringRef CloseName;
  protected SourceLocation CloseNameLocBegin;
  protected ArrayRef<VerbatimBlockLineComment /*P*/ > Lines;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::VerbatimBlockComment::VerbatimBlockComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 904,
   FQN="clang::comments::VerbatimBlockComment::VerbatimBlockComment", NM="_ZN5clang8comments20VerbatimBlockCommentC1ENS_14SourceLocationES2_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments20VerbatimBlockCommentC1ENS_14SourceLocationES2_j")
  //</editor-fold>
  public VerbatimBlockComment(SourceLocation LocBegin, 
      SourceLocation LocEnd, 
      /*uint*/int CommandID) {
    // : BlockCommandComment(VerbatimBlockCommentKind, LocBegin, LocEnd, CommandID, CMK_At), CloseName(), CloseNameLocBegin(), Lines() 
    //START JInit
    super(CommentKind.VerbatimBlockCommentKind, 
        new SourceLocation(LocBegin), new SourceLocation(LocEnd), CommandID, 
        CommandMarkerKind.CMK_At); // FIXME: improve source fidelity.
    this.CloseName = new StringRef();
    this.CloseNameLocBegin = new SourceLocation();
    this.Lines = new ArrayRef<VerbatimBlockLineComment /*P*/ >(true);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::VerbatimBlockComment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 912,
   FQN="clang::comments::VerbatimBlockComment::classof", NM="_ZN5clang8comments20VerbatimBlockComment7classofEPKNS0_7CommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments20VerbatimBlockComment7classofEPKNS0_7CommentE")
  //</editor-fold>
  public static boolean classof(/*const*/ Comment /*P*/ C) {
    return C.getCommentKind() == CommentKind.VerbatimBlockCommentKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::VerbatimBlockComment::child_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 916,
   FQN="clang::comments::VerbatimBlockComment::child_begin", NM="_ZNK5clang8comments20VerbatimBlockComment11child_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20VerbatimBlockComment11child_beginEv")
  //</editor-fold>
  public type$ptr<Comment/*P*/> child_begin() /*const*/ {
    return ((type$ptr<Comment/*P*/> )reinterpret_cast(type$ptr.class, Lines.begin()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::VerbatimBlockComment::child_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 920,
   FQN="clang::comments::VerbatimBlockComment::child_end", NM="_ZNK5clang8comments20VerbatimBlockComment9child_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20VerbatimBlockComment9child_endEv")
  //</editor-fold>
  public type$ptr<Comment/*P*/> child_end() /*const*/ {
    return ((type$ptr<Comment/*P*/> )reinterpret_cast(type$ptr.class, Lines.end()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::VerbatimBlockComment::setCloseName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 924,
   FQN="clang::comments::VerbatimBlockComment::setCloseName", NM="_ZN5clang8comments20VerbatimBlockComment12setCloseNameEN4llvm9StringRefENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments20VerbatimBlockComment12setCloseNameEN4llvm9StringRefENS_14SourceLocationE")
  //</editor-fold>
  public void setCloseName(StringRef Name, SourceLocation LocBegin) {
    CloseName.$assign(Name);
    CloseNameLocBegin.$assign(LocBegin);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::VerbatimBlockComment::setLines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 929,
   FQN="clang::comments::VerbatimBlockComment::setLines", NM="_ZN5clang8comments20VerbatimBlockComment8setLinesEN4llvm8ArrayRefIPNS0_24VerbatimBlockLineCommentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments20VerbatimBlockComment8setLinesEN4llvm8ArrayRefIPNS0_24VerbatimBlockLineCommentEEE")
  //</editor-fold>
  public void setLines(ArrayRef<VerbatimBlockLineComment /*P*/ > L) {
    Lines.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::VerbatimBlockComment::getCloseName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 933,
   FQN="clang::comments::VerbatimBlockComment::getCloseName", NM="_ZNK5clang8comments20VerbatimBlockComment12getCloseNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20VerbatimBlockComment12getCloseNameEv")
  //</editor-fold>
  public StringRef getCloseName() /*const*/ {
    return new StringRef(CloseName);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::VerbatimBlockComment::getNumLines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 937,
   FQN="clang::comments::VerbatimBlockComment::getNumLines", NM="_ZNK5clang8comments20VerbatimBlockComment11getNumLinesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20VerbatimBlockComment11getNumLinesEv")
  //</editor-fold>
  public /*uint*/int getNumLines() /*const*/ {
    return Lines.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::VerbatimBlockComment::getText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 941,
   FQN="clang::comments::VerbatimBlockComment::getText", NM="_ZNK5clang8comments20VerbatimBlockComment7getTextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20VerbatimBlockComment7getTextEj")
  //</editor-fold>
  public StringRef getText(/*uint*/int LineIdx) /*const*/ {
    return Lines.$at(LineIdx).getText();
  }

  
  @Override public String toString() {
    return "" + "CloseName=" + CloseName // NOI18N
              + ", CloseNameLocBegin=" + CloseNameLocBegin // NOI18N
              + ", Lines=" + Lines // NOI18N
              + super.toString(); // NOI18N
  }
}
