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

package org.clang.basic;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;


/// \brief Options for controlling comment parsing.
//<editor-fold defaultstate="collapsed" desc="clang::CommentOptions">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CommentOptions.h", line = 24,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CommentOptions.h", old_line = 24,
 FQN = "clang::CommentOptions", NM = "_ZN5clang14CommentOptionsE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/LangOptions.cpp -nm=_ZN5clang14CommentOptionsE")
//</editor-fold>
public class/*struct*/ CommentOptions implements Destructors.ClassWithDestructor {
  /*typedef std::vector<std::string> BlockCommandNamesTy*/
  //public final class BlockCommandNamesTy extends std.vectorString{ };
  
  /// \brief Command names to treat as block commands in comments.
  /// Should not include the leading backslash.
  public std.vectorString BlockCommandNames;
  
  /// \brief Treat ordinary comments as documentation comments.
  public boolean ParseAllComments;
  //<editor-fold defaultstate="collapsed" desc="clang::CommentOptions::CommentOptions">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CommentOptions.h", line = 34,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CommentOptions.h", old_line = 34,
   FQN = "clang::CommentOptions::CommentOptions", NM = "_ZN5clang14CommentOptionsC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/LangOptions.cpp -nm=_ZN5clang14CommentOptionsC1Ev")
  //</editor-fold>
  public CommentOptions() {
    /* : BlockCommandNames(), ParseAllComments(false)*/ 
    //START JInit
    this.BlockCommandNames = new std.vectorString(new std.string());
    this.ParseAllComments = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CommentOptions::~CommentOptions">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CommentOptions.h", line = 24,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CommentOptions.h", old_line = 24,
   FQN = "clang::CommentOptions::~CommentOptions", NM = "_ZN5clang14CommentOptionsD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/LangOptions.cpp -nm=_ZN5clang14CommentOptionsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CommentOptions::CommentOptions">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CommentOptions.h", line = 24,
   FQN = "clang::CommentOptions::CommentOptions", NM = "_ZN5clang14CommentOptionsC1ERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang14CommentOptionsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CommentOptions(/*const*/CommentOptions /*&*/ $Prm0) {
    /* : BlockCommandNames(.BlockCommandNames), ParseAllComments(.ParseAllComments)*/ 
    //START JInit
    this.BlockCommandNames = $Prm0.BlockCommandNames;
    this.ParseAllComments = $Prm0.ParseAllComments;
    //END JInit
  } 
  
  //<editor-fold defaultstate="collapsed" desc="clang::CommentOptions::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CommentOptions.h", line = 24,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CommentOptions.h", old_line = 24,
   FQN="clang::CommentOptions::operator=", NM="_ZN5clang14CommentOptionsaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang14CommentOptionsaSERKS0_")
  //</editor-fold>
  public /*inline*/ CommentOptions /*&*/ $assign(/*const*/ CommentOptions /*&*/ $Prm0) {
    this.BlockCommandNames.$assign($Prm0.BlockCommandNames);
    this.ParseAllComments = $Prm0.ParseAllComments;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CommentOptions::CommentOptions">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CommentOptions.h", line = 24,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CommentOptions.h", old_line = 24,
   FQN="clang::CommentOptions::CommentOptions", NM="_ZN5clang14CommentOptionsC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN5clang14CommentOptionsC1EOS0_")
  //</editor-fold>
  public /*inline*/ CommentOptions(JD$Move _dparam, CommentOptions /*&&*/$Prm0) {
    /* : BlockCommandNames(static_cast<CommentOptions &&>().BlockCommandNames), ParseAllComments(static_cast<CommentOptions &&>().ParseAllComments)*/ 
    //START JInit
    this.BlockCommandNames = new std.vectorString(JD$Move.INSTANCE
        /// \brief Options for controlling comment parsing.
        , $Prm0.BlockCommandNames);
    this.ParseAllComments = $Prm0.ParseAllComments;
    //END JInit
  }

  
  public String toString() {
    return "" + "BlockCommandNames=" + BlockCommandNames // NOI18N
              + ", ParseAllComments=" + ParseAllComments; // NOI18N
  }

}
