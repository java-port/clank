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
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.ir.*;


//===--------------------------------------------------------------------===//
// GraphTraits specializations for function basic block graphs (CFGs)
//===--------------------------------------------------------------------===//

// Provide specializations of GraphTraits to be able to treat a function as a
// graph of basic blocks... these are the same as the basic block iterators,
// except that the root node is implicitly the first node of the function.
//
//<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<Function * >">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 228,
 FQN="llvm::GraphTraits<Function * >", NM="_ZN4llvm11GraphTraitsIPNS_8FunctionEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsIPNS_8FunctionEEE")
//</editor-fold>
public class/*struct*/ GraphTraitsFunction$P extends /*public*/ GraphTraitsBasicBlock$P<Function> {
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<Function * >::getEntryNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 229,
   FQN="llvm::GraphTraits<Function * >::getEntryNode", NM="_ZN4llvm11GraphTraitsIPNS_8FunctionEE12getEntryNodeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsIPNS_8FunctionEE12getEntryNodeES2_")
  //</editor-fold>
  @Override
  public BasicBlock /*P*/ getEntryNode(Function /*P*/ F) {
    return $AddrOf(F.getEntryBlock());
  }


  // nodes_iterator/begin/end - Allow iteration over all nodes in the graph
  // JAVA: typedef Function::iterator nodes_iterator
//  public final class nodes_iterator extends ilist_iterator<BasicBlock>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<Function * >::nodes_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 233,
   FQN="llvm::GraphTraits<Function * >::nodes_begin", NM="_ZN4llvm11GraphTraitsIPNS_8FunctionEE11nodes_beginES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsIPNS_8FunctionEE11nodes_beginES2_")
  //</editor-fold>
  @Override
  public ilist_iterator<BasicBlock> nodes_begin(Function /*P*/ F) {
    return F.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<Function * >::nodes_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 234,
   FQN="llvm::GraphTraits<Function * >::nodes_end", NM="_ZN4llvm11GraphTraitsIPNS_8FunctionEE9nodes_endES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsIPNS_8FunctionEE9nodes_endES2_")
  //</editor-fold>
  @Override
  public ilist_iterator<BasicBlock> nodes_end(Function /*P*/ F) {
    return F.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<Function * >::size">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 235,
   FQN="llvm::GraphTraits<Function * >::size", NM="_ZN4llvm11GraphTraitsIPNS_8FunctionEE4sizeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsIPNS_8FunctionEE4sizeES2_")
  //</editor-fold>
  @Override public /*size_t*/int size(Function /*P*/ F) {
    return F.size();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final GraphTraitsFunction$P INSTANCE = new GraphTraitsFunction$P();

  public static GraphTraitsFunction$P $GTraits() { return INSTANCE; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
