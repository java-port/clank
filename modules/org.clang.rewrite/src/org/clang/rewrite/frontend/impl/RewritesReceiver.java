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

package org.clang.rewrite.frontend.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.edit.*;
import org.clang.rewrite.core.*;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewritesReceiver">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp", line = 58,
 FQN="(anonymous namespace)::RewritesReceiver", NM="_ZN12_GLOBAL__N_116RewritesReceiverE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp -nm=_ZN12_GLOBAL__N_116RewritesReceiverE")
//</editor-fold>
public class RewritesReceiver extends /*public*/ EditsReceiver implements Destructors.ClassWithDestructor {
  private Rewriter /*&*/ Rewrite;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewritesReceiver::RewritesReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp", line = 62,
   FQN="(anonymous namespace)::RewritesReceiver::RewritesReceiver", NM="_ZN12_GLOBAL__N_116RewritesReceiverC1ERN5clang8RewriterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp -nm=_ZN12_GLOBAL__N_116RewritesReceiverC1ERN5clang8RewriterE")
  //</editor-fold>
  public RewritesReceiver(Rewriter /*&*/ Rewrite) {
    // : EditsReceiver(), Rewrite(Rewrite) 
    //START JInit
    super();
    this./*&*/Rewrite=/*&*/Rewrite;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewritesReceiver::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp", line = 64,
   FQN="(anonymous namespace)::RewritesReceiver::insert", NM="_ZN12_GLOBAL__N_116RewritesReceiver6insertEN5clang14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp -nm=_ZN12_GLOBAL__N_116RewritesReceiver6insertEN5clang14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void insert(SourceLocation loc, StringRef text)/* override*/ {
    Rewrite.InsertText(new SourceLocation(loc), new StringRef(text));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewritesReceiver::replace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp", line = 67,
   FQN="(anonymous namespace)::RewritesReceiver::replace", NM="_ZN12_GLOBAL__N_116RewritesReceiver7replaceEN5clang15CharSourceRangeEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp -nm=_ZN12_GLOBAL__N_116RewritesReceiver7replaceEN5clang15CharSourceRangeEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void replace(CharSourceRange range, StringRef text)/* override*/ {
    Rewrite.ReplaceText(range.getBegin(), Rewrite.getRangeSize(range), new StringRef(text));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewritesReceiver::~RewritesReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp", line = 58,
   FQN="(anonymous namespace)::RewritesReceiver::~RewritesReceiver", NM="_ZN12_GLOBAL__N_116RewritesReceiverD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp -nm=_ZN12_GLOBAL__N_116RewritesReceiverD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Rewrite=" + Rewrite // NOI18N
              + super.toString(); // NOI18N
  }
}
