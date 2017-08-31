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

package org.llvm.ir;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;

//<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<NamedMDNode>">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 40,
 FQN="llvm::ilist_traits<NamedMDNode>", NM="_ZN4llvm12ilist_traitsINS_11NamedMDNodeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm12ilist_traitsINS_11NamedMDNodeEEE")
//</editor-fold>
public class/*struct*/ ilist_traitsNamedMDNode implements /*public*/ ilist_traits<NamedMDNode> {
  // createSentinel is used to get hold of a node that marks the end of
  // the list...
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<NamedMDNode>::createSentinel">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 44,
   FQN="llvm::ilist_traits<NamedMDNode>::createSentinel", NM="_ZNK4llvm12ilist_traitsINS_11NamedMDNodeEE14createSentinelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm12ilist_traitsINS_11NamedMDNodeEE14createSentinelEv")
  //</editor-fold>
  public NamedMDNode /*P*/ createSentinel() /*const*/ {
    return Sentinel;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<NamedMDNode>::destroySentinel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 47,
   FQN="llvm::ilist_traits<NamedMDNode>::destroySentinel", NM="_ZN4llvm12ilist_traitsINS_11NamedMDNodeEE15destroySentinelEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm12ilist_traitsINS_11NamedMDNodeEE15destroySentinelEPS1_")
  //</editor-fold>
  public void destroySentinel(NamedMDNode /*P*/ $Prm0) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<NamedMDNode>::provideInitialHead">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 49,
   FQN="llvm::ilist_traits<NamedMDNode>::provideInitialHead", NM="_ZNK4llvm12ilist_traitsINS_11NamedMDNodeEE18provideInitialHeadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm12ilist_traitsINS_11NamedMDNodeEE18provideInitialHeadEv")
  //</editor-fold>
  public NamedMDNode /*P*/ provideInitialHead() /*const*/ {
    return this.createSentinel();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<NamedMDNode>::ensureHead">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 50,
   FQN="llvm::ilist_traits<NamedMDNode>::ensureHead", NM="_ZNK4llvm12ilist_traitsINS_11NamedMDNodeEE10ensureHeadEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm12ilist_traitsINS_11NamedMDNodeEE10ensureHeadEPS1_")
  //</editor-fold>
  public @Override NamedMDNode /*P*/ ensureHead(type$ref<NamedMDNode> /*P*/ $Prm0) /*const*/ {
    return this.createSentinel();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<NamedMDNode>::noteHead">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 51,
   FQN="llvm::ilist_traits<NamedMDNode>::noteHead", NM="_ZN4llvm12ilist_traitsINS_11NamedMDNodeEE8noteHeadEPS1_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm12ilist_traitsINS_11NamedMDNodeEE8noteHeadEPS1_S3_")
  //</editor-fold>
  public void noteHead(NamedMDNode /*P*/ $Prm0, NamedMDNode /*P*/ $Prm1) {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<NamedMDNode>::addNodeToList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 52,
   FQN="llvm::ilist_traits<NamedMDNode>::addNodeToList", NM="_ZN4llvm12ilist_traitsINS_11NamedMDNodeEE13addNodeToListEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm12ilist_traitsINS_11NamedMDNodeEE13addNodeToListEPS1_")
  //</editor-fold>
  public void addNodeToList(iplist</*typename*/ NamedMDNode /*P*/> list, NamedMDNode /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<NamedMDNode>::removeNodeFromList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 53,
   FQN="llvm::ilist_traits<NamedMDNode>::removeNodeFromList", NM="_ZN4llvm12ilist_traitsINS_11NamedMDNodeEE18removeNodeFromListEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm12ilist_traitsINS_11NamedMDNodeEE18removeNodeFromListEPS1_")
  //</editor-fold>
  public void removeNodeFromList(iplist</*typename*/ NamedMDNode /*P*/> list, NamedMDNode /*P*/ $Prm0) {
  }

/*private:*/
  private final /*mutable */NamedMDNode Sentinel = new NamedMDNode(new Twine("$sentinel"));
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<NamedMDNode>::ilist_traits">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 40,
   FQN="llvm::ilist_traits<NamedMDNode>::ilist_traits", NM="_ZN4llvm12ilist_traitsINS_11NamedMDNodeEEC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm12ilist_traitsINS_11NamedMDNodeEEC1Ev")
  //</editor-fold>
  public /*inline*/ ilist_traitsNamedMDNode() {
    // : ilist_default_traits<NamedMDNode>(), Sentinel() 
    $ilist_default_traits();
  }
  
  @Override public String toString() {
    return "" + "Sentinel=" + Sentinel // NOI18N
              + super.toString(); // NOI18N
  }
}
