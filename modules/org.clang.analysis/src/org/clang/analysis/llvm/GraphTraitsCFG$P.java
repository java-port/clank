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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clang.analysis.*;
import static org.clang.analysis.CFGBlock.*;
import org.llvm.adt.java.GraphTraits;


// Traits for: CFG
//<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CFG * >">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 1058,
 FQN="llvm::GraphTraits<clang::CFG * >", NM="_ZN4llvm11GraphTraitsIPN5clang3CFGEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang3CFGEEE")
//</editor-fold>
public class/*struct*/ GraphTraitsCFG$P /*extends GraphTraitsCFGBlock$P*/ implements GraphTraits<CFG, CFGBlock, CFGBlock.AdjacentBlock> {
  // JAVA: can not inherit GraphTraitsCFGBlock$P since it has different template parameters
  
  /*typedef ::clang::CFG::graph_iterator nodes_iterator*/
//  public final class nodes_iterator extends CFG.graph_iterator{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CFG * >::getEntryNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 1063,
   FQN="llvm::GraphTraits<clang::CFG * >::getEntryNode", NM="_ZN4llvm11GraphTraitsIPN5clang3CFGEE12getEntryNodeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang3CFGEE12getEntryNodeES3_")
  //</editor-fold>
  public CFGBlock /*P*/ getEntryNode(CFG /*P*/ F) {
    return $AddrOf(F.getEntry());
  }

  // the following two methods are added from the class that was in C++ an ancestor
  // (but in Java can not be an ancestor because of the difference in template parameters)
  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CFGBlock * >::child_begin">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 1007,
   FQN="llvm::GraphTraits<clang::CFGBlock * >::child_begin", NM="_ZN4llvm11GraphTraitsIPN5clang8CFGBlockEE11child_beginES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang8CFGBlockEE11child_beginES3_")
  //</editor-fold>
  public /*inline*/ type$ptr<CFGBlock.AdjacentBlock /*P*/ > child_begin(CFGBlock /*P*/ N) {
    return N.succ_begin();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CFGBlock * >::child_end">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 1010,
   FQN="llvm::GraphTraits<clang::CFGBlock * >::child_end", NM="_ZN4llvm11GraphTraitsIPN5clang8CFGBlockEE9child_endES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang8CFGBlockEE9child_endES3_")
  //</editor-fold>
  public /*inline*/ type$ptr<CFGBlock.AdjacentBlock /*P*/ > child_end(CFGBlock /*P*/ N) {
    return N.succ_end();
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CFG * >::nodes_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 1064,
   FQN="llvm::GraphTraits<clang::CFG * >::nodes_begin", NM="_ZN4llvm11GraphTraitsIPN5clang3CFGEE11nodes_beginES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang3CFGEE11nodes_beginES3_")
  //</editor-fold>
  public CFG.graph_iterator nodes_begin(CFG /*P*/ F) {
    return F.nodes_begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CFG * >::nodes_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 1065,
   FQN="llvm::GraphTraits<clang::CFG * >::nodes_end", NM="_ZN4llvm11GraphTraitsIPN5clang3CFGEE9nodes_endES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang3CFGEE9nodes_endES3_")
  //</editor-fold>
  public CFG.graph_iterator nodes_end(CFG /*P*/ F) {
    return F.nodes_end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<clang::CFG * >::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 1066,
   FQN="llvm::GraphTraits<clang::CFG * >::size", NM="_ZN4llvm11GraphTraitsIPN5clang3CFGEE4sizeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm11GraphTraitsIPN5clang3CFGEE4sizeES3_")
  //</editor-fold>
  public /*uint*/int size(CFG /*P*/ F) {
    return F.size();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final GraphTraitsCFG$P INSTANCE = new GraphTraitsCFG$P();
  
  public static GraphTraitsCFG$P $GTraits() {
  
    return INSTANCE;
  
  }

  @Override
  public CFGBlock $ChildNodeTypeToNodeType(AdjacentBlock p) { 
    return p.$star();
  }

  @Override
  public GraphTraits<CFGBlock, CFGBlock, CFGBlock.AdjacentBlock> getEntryNode$GTrait(CFG p) {
    return GraphTraitsCFGBlock$P.$GTraits();
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
