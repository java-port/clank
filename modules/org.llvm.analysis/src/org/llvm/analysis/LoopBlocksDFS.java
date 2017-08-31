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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;


/// Store the result of a depth first search within basic blocks contained by a
/// single loop.
///
/// TODO: This could be generalized for any CFG region, or the entire CFG.
//<editor-fold defaultstate="collapsed" desc="llvm::LoopBlocksDFS">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 38,
 FQN="llvm::LoopBlocksDFS", NM="_ZN4llvm13LoopBlocksDFSE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm13LoopBlocksDFSE")
//</editor-fold>
public class LoopBlocksDFS implements Destructors.ClassWithDestructor {
/*public:*/
  /// Postorder list iterators.
  // JAVA: typedef std::vector<BasicBlock *>::const_iterator POIterator
//  public final class POIterator extends std.vector.iterator</*const*/ BasicBlock /*P*/ >{ };
  // JAVA: typedef std::vector<BasicBlock *>::const_reverse_iterator RPOIterator
//  public final class RPOIterator extends std.reverse_iterator</*const*/ BasicBlock /*&*/ >{ };
  
  /*friend  class LoopBlocksTraversal*/
/*private:*/
  private Loop /*P*/ L;
  
  /// Map each block to its postorder number. A block is only mapped after it is
  /// preorder visited by DFS. It's postorder number is initially zero and set
  /// to nonzero after it is finished by postorder traversal.
  private DenseMapTypeUInt<BasicBlock /*P*/ > PostNumbers;
  private std.vector<BasicBlock /*P*/ > PostBlocks;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBlocksDFS::LoopBlocksDFS">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 56,
   FQN="llvm::LoopBlocksDFS::LoopBlocksDFS", NM="_ZN4llvm13LoopBlocksDFSC1EPNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm13LoopBlocksDFSC1EPNS_4LoopE")
  //</editor-fold>
  public LoopBlocksDFS(Loop /*P*/ Container) {
    // : L(Container), PostNumbers(NextPowerOf2(Container->getNumBlocks())), PostBlocks() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBlocksDFS::getLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 61,
   FQN="llvm::LoopBlocksDFS::getLoop", NM="_ZNK4llvm13LoopBlocksDFS7getLoopEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm13LoopBlocksDFS7getLoopEv")
  //</editor-fold>
  public Loop /*P*/ getLoop() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Traverse the loop blocks and store the DFS result.
  
  //===----------------------------------------------------------------------===//
  // LoopBlocksDFS implementation
  //
  
  /// Traverse the loop blocks and store the DFS result.
  /// Useful for clients that just want the final DFS result and don't need to
  /// visit blocks during the initial traversal.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBlocksDFS::perform">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 725,
   FQN="llvm::LoopBlocksDFS::perform", NM="_ZN4llvm13LoopBlocksDFS7performEPNS_8LoopInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm13LoopBlocksDFS7performEPNS_8LoopInfoE")
  //</editor-fold>
  public void perform(LoopInfo /*P*/ LI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if postorder numbers are assigned to all loop blocks.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBlocksDFS::isComplete">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 67,
   FQN="llvm::LoopBlocksDFS::isComplete", NM="_ZNK4llvm13LoopBlocksDFS10isCompleteEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm13LoopBlocksDFS10isCompleteEv")
  //</editor-fold>
  public boolean isComplete() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Iterate over the cached postorder blocks.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBlocksDFS::beginPostorder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 70,
   FQN="llvm::LoopBlocksDFS::beginPostorder", NM="_ZNK4llvm13LoopBlocksDFS14beginPostorderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm13LoopBlocksDFS14beginPostorderEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ BasicBlock /*P*/ > beginPostorder() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBlocksDFS::endPostorder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 74,
   FQN="llvm::LoopBlocksDFS::endPostorder", NM="_ZNK4llvm13LoopBlocksDFS12endPostorderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm13LoopBlocksDFS12endPostorderEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ BasicBlock /*P*/ > endPostorder() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Reverse iterate over the cached postorder blocks.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBlocksDFS::beginRPO">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 77,
   FQN="llvm::LoopBlocksDFS::beginRPO", NM="_ZNK4llvm13LoopBlocksDFS8beginRPOEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm13LoopBlocksDFS8beginRPOEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ BasicBlock /*&*/ > beginRPO() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBlocksDFS::endRPO">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 81,
   FQN="llvm::LoopBlocksDFS::endRPO", NM="_ZNK4llvm13LoopBlocksDFS6endRPOEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm13LoopBlocksDFS6endRPOEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ BasicBlock /*&*/ > endRPO() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if this block has been preorder visited.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBlocksDFS::hasPreorder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 84,
   FQN="llvm::LoopBlocksDFS::hasPreorder", NM="_ZNK4llvm13LoopBlocksDFS11hasPreorderEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm13LoopBlocksDFS11hasPreorderEPNS_10BasicBlockE")
  //</editor-fold>
  public boolean hasPreorder(BasicBlock /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if this block has a postorder number.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBlocksDFS::hasPostorder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 87,
   FQN="llvm::LoopBlocksDFS::hasPostorder", NM="_ZNK4llvm13LoopBlocksDFS12hasPostorderEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm13LoopBlocksDFS12hasPostorderEPNS_10BasicBlockE")
  //</editor-fold>
  public boolean hasPostorder(BasicBlock /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get a block's postorder number.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBlocksDFS::getPostorder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 93,
   FQN="llvm::LoopBlocksDFS::getPostorder", NM="_ZNK4llvm13LoopBlocksDFS12getPostorderEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm13LoopBlocksDFS12getPostorderEPNS_10BasicBlockE")
  //</editor-fold>
  public /*uint*/int getPostorder(BasicBlock /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get a block's reverse postorder number.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBlocksDFS::getRPO">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 101,
   FQN="llvm::LoopBlocksDFS::getRPO", NM="_ZNK4llvm13LoopBlocksDFS6getRPOEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm13LoopBlocksDFS6getRPOEPNS_10BasicBlockE")
  //</editor-fold>
  public /*uint*/int getRPO(BasicBlock /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBlocksDFS::clear">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 105,
   FQN="llvm::LoopBlocksDFS::clear", NM="_ZN4llvm13LoopBlocksDFS5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm13LoopBlocksDFS5clearEv")
  //</editor-fold>
  public void clear() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBlocksDFS::~LoopBlocksDFS">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 38,
   FQN="llvm::LoopBlocksDFS::~LoopBlocksDFS", NM="_ZN4llvm13LoopBlocksDFSD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm13LoopBlocksDFSD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "L=" + L // NOI18N
              + ", PostNumbers=" + PostNumbers // NOI18N
              + ", PostBlocks=" + PostBlocks; // NOI18N
  }
}
