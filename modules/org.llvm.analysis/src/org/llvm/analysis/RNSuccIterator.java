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
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import org.llvm.analysis.bfi_detail.*;
import org.llvm.analysis.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;

//===----------------------------------------------------------------------===//
/// @brief Hierarchical RegionNode successor iterator.
///
/// This iterator iterates over all successors of a RegionNode.
///
/// For a BasicBlock RegionNode it skips all BasicBlocks that are not part of
/// the parent Region.  Furthermore for BasicBlocks that start a subregion, a
/// RegionNode representing the subregion is returned.
///
/// For a subregion RegionNode there is just one successor. The RegionNode
/// representing the exit of the subregion.
/*template <class NodeType, class BlockT, class RegionT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::RNSuccIterator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionIterator.h", line = 33,
 FQN="llvm::RNSuccIterator", NM="_ZN4llvm14RNSuccIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RNSuccIteratorE")
//</editor-fold>
public class RNSuccIterator</*class*/ NodeType, /*class*/ BlockT, /*class*/ RegionT>  implements /*public*/ std.iterator<std.forward_iterator_tag, NodeType/*, int*/>, Native.NativeComparable<RNSuccIterator> {
  // JAVA: typedef std::iterator<std::forward_iterator_tag, NodeType, ptrdiff_t> super
//  public final class super extends std.iterator<std.forward_iterator_tag, NodeType, int>{ };
  
  // JAVA: typedef GraphTraits<BlockT *> BlockTraits
//  public final class BlockTraits extends GraphTraits<BlockT /*P*/ >{ };
  // JAVA: typedef typename BlockTraits::ChildIteratorType SuccIterTy
//  public final class SuccIterTy extends  GraphTraits.ChildIteratorType<BlockT /*P*/ >{ };
  
  // The iterator works in two modes, bb mode or region mode.
  //<editor-fold defaultstate="collapsed" desc="llvm::RNSuccIterator::ItMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionIterator.h", line = 42,
   FQN="llvm::RNSuccIterator::ItMode", NM="_ZN4llvm14RNSuccIterator6ItModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RNSuccIterator6ItModeE")
  //</editor-fold>
  private enum ItMode implements Native.NativeIntEnum {
    // In BB mode it returns all successors of this BasicBlock as its
    // successors.
    ItBB(0),
    // In region mode there is only one successor, thats the regionnode mapping
    // to the exit block of the regionnode
    ItRgBegin(ItBB.getValue() + 1), // At the beginning of the regionnode successor.
    ItRgEnd(ItRgBegin.getValue() + 1); // At the end of the regionnode successor.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ItMode valueOf(int val) {
      ItMode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ItMode[] VALUES;
      private static final ItMode[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ItMode kind : ItMode.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ItMode[min < 0 ? (1-min) : 0];
        VALUES = new ItMode[max >= 0 ? (1+max) : 0];
        for (ItMode kind : ItMode.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*<dependent type>*/int value;
    private ItMode(int val) { this.value = val;}
    @Override public final int getValue() { return value;}
    //</editor-fold>
  };
  
//  // Use two bit to represent the mode iterator.
//  private PointerIntPair<NodeType /*P*/ , 2, ItMode> Node;
//  
//  // The block successor iterator.
//  private  GraphTraits.ChildIteratorType<BlockT /*P*/ > BItor;
  
  // advanceRegionSucc - A region node has only one successor. It reaches end
  // once we advance it.
  //<editor-fold defaultstate="collapsed" desc="llvm::RNSuccIterator::advanceRegionSucc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionIterator.h", line = 60,
   FQN="llvm::RNSuccIterator::advanceRegionSucc", NM="_ZN4llvm14RNSuccIterator17advanceRegionSuccEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RNSuccIterator17advanceRegionSuccEv")
  //</editor-fold>
  private void advanceRegionSucc() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::RNSuccIterator::getNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionIterator.h", line = 65,
   FQN="llvm::RNSuccIterator::getNode", NM="_ZNK4llvm14RNSuccIterator7getNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RNSuccIterator7getNodeEv")
  //</editor-fold>
  private NodeType /*P*/ getNode() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // isRegionMode - Is the current iterator in region mode?
  //<editor-fold defaultstate="collapsed" desc="llvm::RNSuccIterator::isRegionMode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionIterator.h", line = 68,
   FQN="llvm::RNSuccIterator::isRegionMode", NM="_ZNK4llvm14RNSuccIterator12isRegionModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RNSuccIterator12isRegionModeEv")
  //</editor-fold>
  private boolean isRegionMode() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Get the immediate successor. This function may return a Basic Block
  // RegionNode or a subregion RegionNode.
  //<editor-fold defaultstate="collapsed" desc="llvm::RNSuccIterator::getISucc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionIterator.h", line = 72,
   FQN="llvm::RNSuccIterator::getISucc", NM="_ZNK4llvm14RNSuccIterator8getISuccEPT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RNSuccIterator8getISuccEPT0_")
  //</editor-fold>
  private NodeType /*P*/ getISucc(BlockT /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // getRegionSucc - Return the successor basic block of a SubRegion RegionNode.
  //<editor-fold defaultstate="collapsed" desc="llvm::RNSuccIterator::getRegionSucc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionIterator.h", line = 80,
   FQN="llvm::RNSuccIterator::getRegionSucc", NM="_ZNK4llvm14RNSuccIterator13getRegionSuccEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RNSuccIterator13getRegionSuccEv")
  //</editor-fold>
  private /*inline*/ BlockT /*P*/ getRegionSucc() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // isExit - Is this the exit BB of the Region?
  //<editor-fold defaultstate="collapsed" desc="llvm::RNSuccIterator::isExit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionIterator.h", line = 86,
   FQN="llvm::RNSuccIterator::isExit", NM="_ZNK4llvm14RNSuccIterator6isExitEPT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RNSuccIterator6isExitEPT0_")
  //</editor-fold>
  private /*inline*/ boolean isExit(BlockT /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  // JAVA: typedef RNSuccIterator<NodeType, BlockT, RegionT> Self
//  public final class Self extends RNSuccIterator<NodeType, BlockT, RegionT>{ };
  
  // JAVA: typedef typename super::pointer pointer
//  public final class pointer extends  std.iterator.pointer<std.forward_iterator_tag, NodeType, int>{ };
  
  /// @brief Create begin iterator of a RegionNode.
  //<editor-fold defaultstate="collapsed" desc="llvm::RNSuccIterator::RNSuccIterator<NodeType, BlockT, RegionT>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionIterator.h", line = 95,
   FQN="llvm::RNSuccIterator::RNSuccIterator<NodeType, BlockT, RegionT>", NM="_ZN4llvm14RNSuccIteratorC1EPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RNSuccIteratorC1EPT_")
  //</editor-fold>
  public /*inline*/ RNSuccIterator(NodeType /*P*/ node) {
    // : Node(node, node->isSubRegion() ? ItRgBegin : ItBB), BItor(BlockTraits::child_begin(node->getEntry())) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// @brief Create an end iterator.
  //<editor-fold defaultstate="collapsed" desc="llvm::RNSuccIterator::RNSuccIterator<NodeType, BlockT, RegionT>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionIterator.h", line = 109,
   FQN="llvm::RNSuccIterator::RNSuccIterator<NodeType, BlockT, RegionT>", NM="_ZN4llvm14RNSuccIteratorC1EPT_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RNSuccIteratorC1EPT_b")
  //</editor-fold>
  public /*inline*/ RNSuccIterator(NodeType /*P*/ node, boolean $Prm1) {
    // : Node(node, node->isSubRegion() ? ItRgEnd : ItBB), BItor(BlockTraits::child_end(node->getEntry())) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::RNSuccIterator::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionIterator.h", line = 113,
   FQN="llvm::RNSuccIterator::operator==", NM="_ZNK4llvm14RNSuccIteratoreqERKNS_14RNSuccIteratorIT_T0_T1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RNSuccIteratoreqERKNS_14RNSuccIteratorIT_T0_T1_EE")
  //</editor-fold>
  public /*inline*/ boolean $eq(final /*const*/ RNSuccIterator<NodeType, BlockT, RegionT> /*&*/ x) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::RNSuccIterator::operator!=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionIterator.h", line = 121,
   FQN="llvm::RNSuccIterator::operator!=", NM="_ZNK4llvm14RNSuccIteratorneERKNS_14RNSuccIteratorIT_T0_T1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RNSuccIteratorneERKNS_14RNSuccIteratorIT_T0_T1_EE")
  //</editor-fold>
  public /*inline*/ boolean $noteq(final /*const*/ RNSuccIterator<NodeType, BlockT, RegionT> /*&*/ x) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::RNSuccIterator::operator*">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionIterator.h", line = 123,
   FQN="llvm::RNSuccIterator::operator*", NM="_ZNK4llvm14RNSuccIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RNSuccIteratordeEv")
  //</editor-fold>
  public /*inline*/  std.iterator<forward_iterator_tag, NodeType/*, int*/> $star() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::RNSuccIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionIterator.h", line = 129,
   FQN="llvm::RNSuccIterator::operator++", NM="_ZN4llvm14RNSuccIteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RNSuccIteratorppEv")
  //</editor-fold>
  public /*inline*/ RNSuccIterator<NodeType, BlockT, RegionT> /*&*/ $preInc() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::RNSuccIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionIterator.h", line = 143,
   FQN="llvm::RNSuccIterator::operator++", NM="_ZN4llvm14RNSuccIteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RNSuccIteratorppEi")
  //</editor-fold>
  public /*inline*/ RNSuccIterator<NodeType, BlockT, RegionT> $postInc(int $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Node=" //+ Node // NOI18N
              + ", BItor=" //+ BItor // NOI18N
              + super.toString(); // NOI18N
  }
}
