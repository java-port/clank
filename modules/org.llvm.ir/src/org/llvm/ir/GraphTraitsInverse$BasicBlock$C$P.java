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
import org.llvm.adt.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import org.llvm.adt.java.GraphTraits;

//<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<Inverse<const BasicBlock * > >">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 203,
 FQN="llvm::GraphTraits<Inverse<const BasicBlock * > >", NM="_ZN4llvm11GraphTraitsINS_7InverseIPKNS_10BasicBlockEEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsINS_7InverseIPKNS_10BasicBlockEEEEE")
//</editor-fold>
public class/*struct*/ GraphTraitsInverse$BasicBlock$C$P<GraphType> implements GraphTraits<Inverse<GraphType/*const BasicBlock P*/>, BasicBlock, BasicBlock>  {
  // JAVA: typedef const BasicBlock NodeType
//  public final class NodeType extends /*const*/ BasicBlock{ };
  // JAVA: typedef const BasicBlock *NodeRef
//  public final class NodeRef extends /*const*/ BasicBlock /*P*/ { };
  // JAVA: typedef const_pred_iterator ChildIteratorType
//  public final class ChildIteratorType extends PredIterator</*const*/ BasicBlock, Value.user_iterator_impl</*const*/ User> >{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<Inverse<const BasicBlock * > >::getEntryNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 207,
   FQN="llvm::GraphTraits<Inverse<const BasicBlock * > >::getEntryNode", NM="_ZN4llvm11GraphTraitsINS_7InverseIPKNS_10BasicBlockEEEE12getEntryNodeES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsINS_7InverseIPKNS_10BasicBlockEEEE12getEntryNodeES5_")
  //</editor-fold>
  @Override
  public /*const*/ BasicBlock /*P*/ getEntryNode(Inverse<GraphType/*const BasicBlock P*/> G) {
    return ((Inverse</*const*/ BasicBlock /*P*/ >)G).Graph;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<Inverse<const BasicBlock * > >::child_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 210,
   FQN="llvm::GraphTraits<Inverse<const BasicBlock * > >::child_begin", NM="_ZN4llvm11GraphTraitsINS_7InverseIPKNS_10BasicBlockEEEE11child_beginES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsINS_7InverseIPKNS_10BasicBlockEEEE11child_beginES4_")
  //</editor-fold>
  @Override
  public /*inline*/ PredIterator</*const*/ BasicBlock, Value.user_iterator_impl</*const*/ User> > child_begin(/*const*/ BasicBlock /*P*/ N) {
    return IrLlvmGlobals.pred_begin_BasicBlock$C$P(N);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<Inverse<const BasicBlock * > >::child_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 213,
   FQN="llvm::GraphTraits<Inverse<const BasicBlock * > >::child_end", NM="_ZN4llvm11GraphTraitsINS_7InverseIPKNS_10BasicBlockEEEE9child_endES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsINS_7InverseIPKNS_10BasicBlockEEEE9child_endES4_")
  //</editor-fold>
  @Override
  public /*inline*/ PredIterator</*const*/ BasicBlock, Value.user_iterator_impl</*const*/ User> > child_end(/*const*/ BasicBlock /*P*/ N) {
    return IrLlvmGlobals.pred_end_BasicBlock$C$P(N);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final GraphTraitsInverse$BasicBlock$C$P INSTANCE = new GraphTraitsInverse$BasicBlock$C$P();

  public static GraphTraitsInverse$BasicBlock$C$P $GTraits() { return INSTANCE; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return ""; // NOI18N
  }
}
