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
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;


/// A full comment attached to a declaration, contains block content.
//<editor-fold defaultstate="collapsed" desc="clang::comments::FullComment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 1097,
 FQN="clang::comments::FullComment", NM="_ZN5clang8comments11FullCommentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments11FullCommentE")
//</editor-fold>
public class FullComment extends /*public*/ Comment {
  private ArrayRef<BlockContentComment /*P*/ > Blocks;
  private DeclInfo /*P*/ ThisDeclInfo;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::FullComment::FullComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 1102,
   FQN="clang::comments::FullComment::FullComment", NM="_ZN5clang8comments11FullCommentC1EN4llvm8ArrayRefIPNS0_19BlockContentCommentEEEPNS0_8DeclInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments11FullCommentC1EN4llvm8ArrayRefIPNS0_19BlockContentCommentEEEPNS0_8DeclInfoE")
  //</editor-fold>
  public FullComment(ArrayRef<BlockContentComment /*P*/ > Blocks, DeclInfo /*P*/ D) {
    // : Comment(FullCommentKind, SourceLocation(), SourceLocation()), Blocks(Blocks), ThisDeclInfo(D) 
    //START JInit
    super(CommentKind.FullCommentKind, new SourceLocation(), new SourceLocation());
    this.Blocks = new ArrayRef<BlockContentComment /*P*/ >(Blocks);
    this.ThisDeclInfo = D;
    //END JInit
    if (Blocks.empty()) {
      return;
    }
    
    setSourceRange(new SourceRange(Blocks.front().getLocStart(), 
            Blocks.back().getLocEnd()));
    setLocation(Blocks.front().getLocStart());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::FullComment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 1113,
   FQN="clang::comments::FullComment::classof", NM="_ZN5clang8comments11FullComment7classofEPKNS0_7CommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments11FullComment7classofEPKNS0_7CommentE")
  //</editor-fold>
  public static boolean classof(/*const*/ Comment /*P*/ C) {
    return C.getCommentKind() == CommentKind.FullCommentKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::FullComment::child_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 1117,
   FQN="clang::comments::FullComment::child_begin", NM="_ZNK5clang8comments11FullComment11child_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments11FullComment11child_beginEv")
  //</editor-fold>
  public type$ptr<Comment/*P*/> child_begin() /*const*/ {
    return ((type$ptr<Comment/*P*/> )reinterpret_cast(type$ptr.class, Blocks.begin()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::FullComment::child_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 1121,
   FQN="clang::comments::FullComment::child_end", NM="_ZNK5clang8comments11FullComment9child_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments11FullComment9child_endEv")
  //</editor-fold>
  public type$ptr<Comment/*P*/> child_end() /*const*/ {
    return ((type$ptr<Comment/*P*/> )reinterpret_cast(type$ptr.class, Blocks.end()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::FullComment::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 1125,
   FQN="clang::comments::FullComment::getDecl", NM="_ZNK5clang8comments11FullComment7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments11FullComment7getDeclEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getDecl() /*const*//* __attribute__((pure))*/ {
    return ThisDeclInfo.CommentDecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::FullComment::getDeclInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 1129,
   FQN="clang::comments::FullComment::getDeclInfo", NM="_ZNK5clang8comments11FullComment11getDeclInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments11FullComment11getDeclInfoEv")
  //</editor-fold>
  public /*const*/ DeclInfo /*P*/ getDeclInfo() /*const*//* __attribute__((pure))*/ {
    if (!ThisDeclInfo.IsFilled) {
      ThisDeclInfo.fill();
    }
    return ThisDeclInfo;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::FullComment::getBlocks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 1135,
   FQN="clang::comments::FullComment::getBlocks", NM="_ZNK5clang8comments11FullComment9getBlocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments11FullComment9getBlocksEv")
  //</editor-fold>
  public ArrayRef<BlockContentComment /*P*/ > getBlocks() /*const*/ {
    return new ArrayRef<BlockContentComment /*P*/ >(Blocks);
  }

  
  @Override public String toString() {
    return "" + "Blocks=" + Blocks // NOI18N
              + ", ThisDeclInfo=" + ThisDeclInfo // NOI18N
              + super.toString(); // NOI18N
  }
}
