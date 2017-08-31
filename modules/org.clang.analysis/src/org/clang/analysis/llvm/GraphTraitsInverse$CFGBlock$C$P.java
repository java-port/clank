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

package org.clang.analysis.llvm;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.clang.analysis.*;
import static org.clang.analysis.CFGBlock.*;
import org.llvm.adt.java.GraphTraits;

//<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<llvm::Inverse<const clang::CFGBlock * > >">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 1042,
 FQN="llvm::GraphTraits<llvm::Inverse<const clang::CFGBlock * > >", NM="_ZN4llvm11GraphTraitsINS_7InverseIPKN5clang8CFGBlockEEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsINS_7InverseIPKN5clang8CFGBlockEEEEE")
//</editor-fold>
public class/*struct*/ GraphTraitsInverse$CFGBlock$C$P implements GraphTraits<Inverse</*const*/ CFGBlock /*P*/ >, CFGBlock, CFGBlock.AdjacentBlock> {
  /*typedef const ::clang::CFGBlock NodeType*/
//  public final class NodeType extends /*const*/ CFGBlock{ };
  /*typedef ::clang::CFGBlock::const_pred_iterator ChildIteratorType*/
//  public final class ChildIteratorType extends type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<llvm::Inverse<const clang::CFGBlock * > >::getEntryNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 1046,
   FQN="llvm::GraphTraits<llvm::Inverse<const clang::CFGBlock * > >::getEntryNode", NM="_ZN4llvm11GraphTraitsINS_7InverseIPKN5clang8CFGBlockEEEE12getEntryNodeES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsINS_7InverseIPKN5clang8CFGBlockEEEE12getEntryNodeES6_")
  //</editor-fold>
  public /*const*/ CFGBlock /*P*/ getEntryNode(Inverse</*const*/ CFGBlock /*P*/ > G) {
    return G.Graph;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<llvm::Inverse<const clang::CFGBlock * > >::child_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 1049,
   FQN="llvm::GraphTraits<llvm::Inverse<const clang::CFGBlock * > >::child_begin", NM="_ZN4llvm11GraphTraitsINS_7InverseIPKN5clang8CFGBlockEEEE11child_beginES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsINS_7InverseIPKN5clang8CFGBlockEEEE11child_beginES5_")
  //</editor-fold>
  public /*inline*/ type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > child_begin(/*const*/ CFGBlock /*P*/ N) {
    return N.pred_begin$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<llvm::Inverse<const clang::CFGBlock * > >::child_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 1052,
   FQN="llvm::GraphTraits<llvm::Inverse<const clang::CFGBlock * > >::child_end", NM="_ZN4llvm11GraphTraitsINS_7InverseIPKN5clang8CFGBlockEEEE9child_endES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsINS_7InverseIPKN5clang8CFGBlockEEEE9child_endES5_")
  //</editor-fold>
  public /*inline*/ type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > child_end(/*const*/ CFGBlock /*P*/ N) {
    return N.pred_end$Const();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final GraphTraitsInverse$CFGBlock$C$P INSTANCE = new GraphTraitsInverse$CFGBlock$C$P();
  
  public static GraphTraitsInverse$CFGBlock$C$P $GTraits() {
  
    return INSTANCE;
  
  }

  @Override
  public CFGBlock $ChildNodeTypeToNodeType(AdjacentBlock p) { 
    return p.$star();
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
