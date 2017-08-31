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

package org.clang.format.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clank.support.Native.NativePOD;
import org.llvm.adt.aliases.*;

//<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.h", line = 208,
 FQN="clang::format::UnwrappedLineNode", NM="_ZN5clang6format17UnwrappedLineNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format17UnwrappedLineNodeE")
//</editor-fold>
public class/*struct*/ UnwrappedLineNode implements Destructors.ClassWithDestructor, NativePOD<UnwrappedLineNode> {
  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineNode::UnwrappedLineNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.h", line = 209,
   FQN="clang::format::UnwrappedLineNode::UnwrappedLineNode", NM="_ZN5clang6format17UnwrappedLineNodeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format17UnwrappedLineNodeC1Ev")
  //</editor-fold>
  public UnwrappedLineNode() {
    // : Tok(null), Children() 
    //START JInit
    this.Tok = null;
    this.Children = new SmallVector<UnwrappedLine>(0, new UnwrappedLine());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineNode::UnwrappedLineNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.h", line = 210,
   FQN="clang::format::UnwrappedLineNode::UnwrappedLineNode", NM="_ZN5clang6format17UnwrappedLineNodeC1EPNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format17UnwrappedLineNodeC1EPNS0_11FormatTokenE")
  //</editor-fold>
  public UnwrappedLineNode(FormatToken /*P*/ Tok) {
    // : Tok(Tok), Children() 
    //START JInit
    this.Tok = Tok;
    this.Children = new SmallVector<UnwrappedLine>(0, new UnwrappedLine());
    //END JInit
  }

  
  public FormatToken /*P*/ Tok;
  public SmallVector<UnwrappedLine> Children;
  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineNode::~UnwrappedLineNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.h", line = 208,
   FQN="clang::format::UnwrappedLineNode::~UnwrappedLineNode", NM="_ZN5clang6format17UnwrappedLineNodeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format17UnwrappedLineNodeD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Children.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineNode::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.h", line = 208,
   FQN="clang::format::UnwrappedLineNode::operator=", NM="_ZN5clang6format17UnwrappedLineNodeaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format17UnwrappedLineNodeaSERKS1_")
  //</editor-fold>
  public /*inline*/ UnwrappedLineNode /*&*/ $assign(final /*const*/ UnwrappedLineNode /*&*/ $Prm0) {
    this.Tok = $Prm0.Tok;
    this.Children.$assign($Prm0.Children);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineNode::UnwrappedLineNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.h", line = 208,
   FQN="clang::format::UnwrappedLineNode::UnwrappedLineNode", NM="_ZN5clang6format17UnwrappedLineNodeC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format17UnwrappedLineNodeC1ERKS1_")
  //</editor-fold>
  public /*inline*/ UnwrappedLineNode(final /*const*/ UnwrappedLineNode /*&*/ $Prm0) {
    // : Tok(.Tok), Children(.Children) 
    //START JInit
    this.Tok = $Prm0.Tok;
    this.Children = new SmallVector<UnwrappedLine>($Prm0.Children);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineNode::UnwrappedLineNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.h", line = 208,
   FQN="clang::format::UnwrappedLineNode::UnwrappedLineNode", NM="_ZN5clang6format17UnwrappedLineNodeC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format17UnwrappedLineNodeC1EOS1_")
  //</editor-fold>
  public /*inline*/ UnwrappedLineNode(JD$Move _dparam, final UnwrappedLineNode /*&&*/$Prm0) {
    // : Tok(static_cast<UnwrappedLineNode &&>().Tok), Children(static_cast<UnwrappedLineNode &&>().Children) 
    //START JInit
    this.Tok = $Prm0.Tok;
    this.Children = new SmallVector<UnwrappedLine>(JD$Move.INSTANCE, $Prm0.Children);
    //END JInit
  }

  @Override public UnwrappedLineNode clone() {
    return new UnwrappedLineNode(this);
  }
  
//  @Override
//  public UnwrappedLineNode move() {
//    return new UnwrappedLineNode(JD$Move.INSTANCE, this);
//  }
  
  @Override public String toString() {
    return "" + "Tok=" + Tok // NOI18N
              + ", Children=" + Children; // NOI18N
  }
}
