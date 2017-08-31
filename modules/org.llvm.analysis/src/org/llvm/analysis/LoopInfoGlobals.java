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

import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clank.support.aliases.JavaIterator;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;


//<editor-fold defaultstate="collapsed" desc="static type LoopInfoGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="LoopInfoGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseE;_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEEE;_ZN4llvm8LoopBaseE;_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEEE; -static-type=LoopInfoGlobals")
//</editor-fold>
public final class LoopInfoGlobals {


//===----------------------------------------------------------------------===//
/// Instances of this class are used to represent loops that are detected in the
/// flow graph.
///
/*template <class BlockT, class LoopT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::LoopBase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 67,
 FQN="llvm::LoopBase", NM="_ZN4llvm8LoopBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseE")
//</editor-fold>
public static class LoopBase</*class*/ BlockT, /*class*/ LoopT>  implements Destructors.ClassWithDestructor {
  private LoopT /*P*/ ParentLoop;
  // Loops contained entirely within this one.
  private std.vector<LoopT /*P*/ > SubLoops;
  
  // The list of blocks in this loop. First entry is the header node.
  private std.vector<BlockT /*P*/ > Blocks;
  
  private SmallPtrSet</*const*/ BlockT /*P*//* , 8*/> DenseBlockSet;
  
  /// Indicator that this loop is no longer a valid loop.
  private boolean IsInvalid/* = false*/;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::LoopBase<N, M>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 81,
   FQN="llvm::LoopBase::LoopBase<N, M>", NM="_ZN4llvm8LoopBaseC1ERKNS_8LoopBaseIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseC1ERKNS_8LoopBaseIT_T0_EE")
  //</editor-fold>
  protected/*private*/ LoopBase(final /*const*/ LoopBase<BlockT, LoopT> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 82,
   FQN="llvm::LoopBase::operator=", NM="_ZN4llvm8LoopBaseaSERKNS_8LoopBaseIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseaSERKNS_8LoopBaseIT_T0_EE")
  //</editor-fold>
  protected/*private*/ /*const*/ LoopBase<BlockT, LoopT> /*&*/ $assign(final /*const*/ LoopBase<BlockT, LoopT> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  /// This creates an empty loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::LoopBase<N, M>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 86,
   FQN="llvm::LoopBase::LoopBase<N, M>", NM="_ZN4llvm8LoopBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseC1Ev")
  //</editor-fold>
  public LoopBase() {
    // : ParentLoop(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::~LoopBase<N, M>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 87,
   FQN="llvm::LoopBase::~LoopBase<N, M>", NM="_ZN4llvm8LoopBaseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the nesting level of this loop.  An outer-most loop has depth 1,
  /// for consistency with loop depth values used for basic blocks, where depth
  /// 0 is used for blocks not inside any loops.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::getLoopDepth">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 95,
   FQN="llvm::LoopBase::getLoopDepth", NM="_ZNK4llvm8LoopBase12getLoopDepthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase12getLoopDepthEv")
  //</editor-fold>
  public /*uint*/int getLoopDepth() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::getHeader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 102,
   FQN="llvm::LoopBase::getHeader", NM="_ZNK4llvm8LoopBase9getHeaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase9getHeaderEv")
  //</editor-fold>
  public BlockT /*P*/ getHeader() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::getParentLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 103,
   FQN="llvm::LoopBase::getParentLoop", NM="_ZNK4llvm8LoopBase13getParentLoopEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase13getParentLoopEv")
  //</editor-fold>
  public LoopT /*P*/ getParentLoop() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This is a raw interface for bypassing addChildLoop.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::setParentLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 106,
   FQN="llvm::LoopBase::setParentLoop", NM="_ZN4llvm8LoopBase13setParentLoopEPT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBase13setParentLoopEPT0_")
  //</editor-fold>
  public void setParentLoop(LoopT /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the specified loop is contained within in this loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::contains">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 109,
   FQN="llvm::LoopBase::contains", NM="_ZNK4llvm8LoopBase8containsEPKT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase8containsEPKT0_")
  //</editor-fold>
  public boolean contains_T1$C$P(/*const*/ LoopT /*P*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the specified basic block is in this loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::contains">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 116,
   FQN="llvm::LoopBase::contains", NM="_ZNK4llvm8LoopBase8containsEPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase8containsEPKT_")
  //</editor-fold>
  public boolean contains_T$C$P(/*const*/ BlockT /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the specified instruction is in this loop.
  /*template <class InstT> TEMPLATE*/
  /// Return true if the specified instruction is in this loop.
  /*template <class InstT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::contains">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 122,
   FQN="llvm::LoopBase::contains", NM="Tpl__ZNK4llvm8LoopBase8containsEPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=Tpl__ZNK4llvm8LoopBase8containsEPKT_")
  //</editor-fold>
  public </*class*/ InstT> boolean contains_T$C$P_2(/*const*/ InstT /*P*/ Inst) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the loops contained entirely within this loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::getSubLoops">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 127,
   FQN="llvm::LoopBase::getSubLoops", NM="_ZNK4llvm8LoopBase11getSubLoopsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase11getSubLoopsEv")
  //</editor-fold>
  public /*const*/ std.vector<LoopT /*P*/ > /*&*/ getSubLoops() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::getSubLoopsVector">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 128,
   FQN="llvm::LoopBase::getSubLoopsVector", NM="_ZN4llvm8LoopBase17getSubLoopsVectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBase17getSubLoopsVectorEv")
  //</editor-fold>
  public std.vector<LoopT /*P*/ > /*&*/ getSubLoopsVector() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // JAVA: typedef typename std::vector<LoopT *>::const_iterator iterator
//  public final class iterator extends  std.vector.const_iterator<LoopT /*P*/ >{ };
  // JAVA: typedef typename std::vector<LoopT *>::const_reverse_iterator reverse_iterator
//  public final class reverse_iterator extends  std.vector.const_reverse_iterator<LoopT /*P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 132,
   FQN="llvm::LoopBase::begin", NM="_ZNK4llvm8LoopBase5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase5beginEv")
  //</editor-fold>
  public  std.vector.iterator<LoopT /*P*/ > begin() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 133,
   FQN="llvm::LoopBase::end", NM="_ZNK4llvm8LoopBase3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase3endEv")
  //</editor-fold>
  public  std.vector.iterator<LoopT /*P*/ > end() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::rbegin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 134,
   FQN="llvm::LoopBase::rbegin", NM="_ZNK4llvm8LoopBase6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase6rbeginEv")
  //</editor-fold>
  public  std.reverse_iterator<LoopT /*P*/ > rbegin() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::rend">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 135,
   FQN="llvm::LoopBase::rend", NM="_ZNK4llvm8LoopBase4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase4rendEv")
  //</editor-fold>
  public  std.reverse_iterator<LoopT /*P*/ > rend() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::empty">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 136,
   FQN="llvm::LoopBase::empty", NM="_ZNK4llvm8LoopBase5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get a list of the basic blocks which make up this loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::getBlocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 139,
   FQN="llvm::LoopBase::getBlocks", NM="_ZNK4llvm8LoopBase9getBlocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase9getBlocksEv")
  //</editor-fold>
  public /*const*/ std.vector<BlockT /*P*/ > /*&*/ getBlocks() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // JAVA: typedef typename std::vector<BlockT *>::const_iterator block_iterator
//  public final class block_iterator extends  std.vector.const_iterator<BlockT /*P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::block_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 141,
   FQN="llvm::LoopBase::block_begin", NM="_ZNK4llvm8LoopBase11block_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase11block_beginEv")
  //</editor-fold>
  public  std.vector.iterator<BlockT /*P*/ > block_begin() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::block_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 142,
   FQN="llvm::LoopBase::block_end", NM="_ZNK4llvm8LoopBase9block_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase9block_endEv")
  //</editor-fold>
  public  std.vector.iterator<BlockT /*P*/ > block_end() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::blocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 143,
   FQN="llvm::LoopBase::blocks", NM="_ZNK4llvm8LoopBase6blocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase6blocksEv")
  //</editor-fold>
  public /*inline*/ iterator_range< std.vector.iterator<BlockT /*P*/ > > blocks() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the number of blocks in this loop in constant time.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::getNumBlocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 148,
   FQN="llvm::LoopBase::getNumBlocks", NM="_ZNK4llvm8LoopBase12getNumBlocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase12getNumBlocksEv")
  //</editor-fold>
  public /*uint*/int getNumBlocks() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Invalidate the loop, indicating that it is no longer a loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::invalidate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 153,
   FQN="llvm::LoopBase::invalidate", NM="_ZN4llvm8LoopBase10invalidateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBase10invalidateEv")
  //</editor-fold>
  public void invalidate() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if this loop is no longer valid.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::isInvalid">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 156,
   FQN="llvm::LoopBase::isInvalid", NM="_ZN4llvm8LoopBase9isInvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBase9isInvalidEv")
  //</editor-fold>
  public boolean isInvalid() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// True if terminator in the block can branch to another block that is
  /// outside of the current loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::isLoopExiting">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 160,
   FQN="llvm::LoopBase::isLoopExiting", NM="_ZNK4llvm8LoopBase13isLoopExitingEPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase13isLoopExitingEPKT_")
  //</editor-fold>
  public boolean isLoopExiting(/*const*/ BlockT /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Calculate the number of back edges to the loop header.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::getNumBackEdges">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 172,
   FQN="llvm::LoopBase::getNumBackEdges", NM="_ZNK4llvm8LoopBase15getNumBackEdgesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase15getNumBackEdgesEv")
  //</editor-fold>
  public /*uint*/int getNumBackEdges() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //===--------------------------------------------------------------------===//
  // APIs for simple analysis of the loop.
  //
  // Note that all of these methods can fail on general loops (ie, there may not
  // be a preheader, etc).  For best success, the loop simplification and
  // induction variable canonicalization pass should be used to normalize loops
  // for easy analysis.  These methods assume canonical loops.
  
  /// Return all blocks inside the loop that have successors outside of the
  /// loop. These are the blocks _inside of the current loop_ which branch out.
  /// The returned list is always unique.
  
  //===----------------------------------------------------------------------===//
  // APIs for simple analysis of the loop. See header notes.
  
  /// getExitingBlocks - Return all blocks inside the loop that have successors
  /// outside of the loop.  These are the blocks _inside of the current loop_
  /// which branch out.  The returned list is always unique.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::getExitingBlocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 33,
   FQN="llvm::LoopBase::getExitingBlocks", NM="_ZNK4llvm8LoopBase16getExitingBlocksERNS_15SmallVectorImplIPT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase16getExitingBlocksERNS_15SmallVectorImplIPT_EE")
  //</editor-fold>
  public void getExitingBlocks(final SmallVectorImpl<BlockT /*P*/ > /*&*/ ExitingBlocks) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// If getExitingBlocks would return exactly one block, return that block.
  /// Otherwise return null.
  
  /// getExitingBlock - If getExitingBlocks would return exactly one block,
  /// return that block. Otherwise return null.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::getExitingBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 50,
   FQN="llvm::LoopBase::getExitingBlock", NM="_ZNK4llvm8LoopBase15getExitingBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase15getExitingBlockEv")
  //</editor-fold>
  public BlockT /*P*/ getExitingBlock() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return all of the successor blocks of this loop. These are the blocks
  /// _outside of the current loop_ which are branched to.
  
  /// getExitBlocks - Return all of the successor blocks of this loop.  These
  /// are the blocks _outside of the current loop_ which are branched to.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::getExitBlocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 62,
   FQN="llvm::LoopBase::getExitBlocks", NM="_ZNK4llvm8LoopBase13getExitBlocksERNS_15SmallVectorImplIPT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase13getExitBlocksERNS_15SmallVectorImplIPT_EE")
  //</editor-fold>
  public void getExitBlocks(final SmallVectorImpl<BlockT /*P*/ > /*&*/ ExitBlocks) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// If getExitBlocks would return exactly one block, return that block.
  /// Otherwise return null.
  
  /// getExitBlock - If getExitBlocks would return exactly one block,
  /// return that block. Otherwise return null.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::getExitBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 77,
   FQN="llvm::LoopBase::getExitBlock", NM="_ZNK4llvm8LoopBase12getExitBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase12getExitBlockEv")
  //</editor-fold>
  public BlockT /*P*/ getExitBlock() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Edge type.
  // JAVA: typedef std::pair<const BlockT *, const BlockT *> Edge
//  public final class Edge extends std.pair</*const*/ BlockT /*P*/ , /*const*/ BlockT /*P*/ >{ };
  
  /// Return all pairs of (_inside_block_,_outside_block_).
  
  /// getExitEdges - Return all pairs of (_inside_block_,_outside_block_).
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::getExitEdges">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 87,
   FQN="llvm::LoopBase::getExitEdges", NM="_ZNK4llvm8LoopBase12getExitEdgesERNS_15SmallVectorImplISt4pairIPKT_S5_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase12getExitEdgesERNS_15SmallVectorImplISt4pairIPKT_S5_EEE")
  //</editor-fold>
  public void getExitEdges(final SmallVectorImpl<std.pair</*const*/ BlockT /*P*/ , /*const*/ BlockT /*P*/ > > /*&*/ ExitEdges) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// If there is a preheader for this loop, return it. A loop has a preheader
  /// if there is only one edge to the header of the loop from outside of the
  /// loop. If this is the case, the block branching to the header of the loop
  /// is the preheader node.
  ///
  /// This method returns null if there is no preheader for the loop.
  
  /// getLoopPreheader - If there is a preheader for this loop, return it.  A
  /// loop has a preheader if there is only one edge to the header of the loop
  /// from outside of the loop.  If this is the case, the block branching to the
  /// header of the loop is the preheader node.
  ///
  /// This method returns null if there is no preheader for the loop.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::getLoopPreheader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 107,
   FQN="llvm::LoopBase::getLoopPreheader", NM="_ZNK4llvm8LoopBase16getLoopPreheaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase16getLoopPreheaderEv")
  //</editor-fold>
  public BlockT /*P*/ getLoopPreheader() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// If the given loop's header has exactly one unique predecessor outside the
  /// loop, return it. Otherwise return null.
  ///  This is less strict that the loop "preheader" concept, which requires
  /// the predecessor to have exactly one successor.
  
  /// getLoopPredecessor - If the given loop's header has exactly one unique
  /// predecessor outside the loop, return it. Otherwise return null.
  /// This is less strict that the loop "preheader" concept, which requires
  /// the predecessor to have exactly one successor.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::getLoopPredecessor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 129,
   FQN="llvm::LoopBase::getLoopPredecessor", NM="_ZNK4llvm8LoopBase18getLoopPredecessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase18getLoopPredecessorEv")
  //</editor-fold>
  public BlockT /*P*/ getLoopPredecessor() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// If there is a single latch block for this loop, return it.
  /// A latch block is a block that contains a branch back to the header.
  
  /// getLoopLatch - If there is a single latch block for this loop, return it.
  /// A latch block is a block that contains a branch back to the header.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::getLoopLatch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 155,
   FQN="llvm::LoopBase::getLoopLatch", NM="_ZNK4llvm8LoopBase12getLoopLatchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase12getLoopLatchEv")
  //</editor-fold>
  public BlockT /*P*/ getLoopLatch() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return all loop latch blocks of this loop. A latch block is a block that
  /// contains a branch back to the header.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::getLoopLatches">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 237,
   FQN="llvm::LoopBase::getLoopLatches", NM="_ZNK4llvm8LoopBase14getLoopLatchesERNS_15SmallVectorImplIPT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase14getLoopLatchesERNS_15SmallVectorImplIPT_EE")
  //</editor-fold>
  public void getLoopLatches(final SmallVectorImpl<BlockT /*P*/ > /*&*/ LoopLatches) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //===--------------------------------------------------------------------===//
  // APIs for updating loop information after changing the CFG
  //
  
  /// This method is used by other analyses to update loop information.
  /// NewBB is set to be a new member of the current loop.
  /// Because of this, it is added as a member of all parent loops, and is added
  /// to the specified LoopInfo object as being in the current basic block.  It
  /// is not valid to replace the loop header with this method.
  
  //===----------------------------------------------------------------------===//
  // APIs for updating loop information after changing the CFG
  //
  
  /// addBasicBlockToLoop - This method is used by other analyses to update loop
  /// information.  NewBB is set to be a new member of the current loop.
  /// Because of this, it is added as a member of all parent loops, and is added
  /// to the specified LoopInfo object as being in the current basic block.  It
  /// is not valid to replace the loop header with this method.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::addBasicBlockToLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 185,
   FQN="llvm::LoopBase::addBasicBlockToLoop", NM="_ZN4llvm8LoopBase19addBasicBlockToLoopEPT_RNS_12LoopInfoBaseIS1_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBase19addBasicBlockToLoopEPT_RNS_12LoopInfoBaseIS1_T0_EE")
  //</editor-fold>
  public void addBasicBlockToLoop(BlockT /*P*/ NewBB, final LoopInfoBase<BlockT, LoopT> /*&*/ LIB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This is used when splitting loops up. It replaces the OldChild entry in
  /// our children list with NewChild, and updates the parent pointer of
  /// OldChild to be null and the NewChild to be this loop.
  /// This updates the loop depth of the new child.
  
  /// replaceChildLoopWith - This is used when splitting loops up.  It replaces
  /// the OldChild entry in our children list with NewChild, and updates the
  /// parent pointer of OldChild to be null and the NewChild to be this loop.
  /// This updates the loop depth of the new child.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::replaceChildLoopWith">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 209,
   FQN="llvm::LoopBase::replaceChildLoopWith", NM="_ZN4llvm8LoopBase20replaceChildLoopWithEPT0_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBase20replaceChildLoopWithEPT0_S2_")
  //</editor-fold>
  public void replaceChildLoopWith(LoopT /*P*/ OldChild, LoopT /*P*/ NewChild) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Add the specified loop to be a child of this loop.
  /// This updates the loop depth of the new child.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::addChildLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 266,
   FQN="llvm::LoopBase::addChildLoop", NM="_ZN4llvm8LoopBase12addChildLoopEPT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBase12addChildLoopEPT0_")
  //</editor-fold>
  public void addChildLoop(LoopT /*P*/ NewChild) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This removes the specified child from being a subloop of this loop. The
  /// loop is not deleted, as it will presumably be inserted into another loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::removeChildLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 274,
   FQN="llvm::LoopBase::removeChildLoop", NM="_ZN4llvm8LoopBase15removeChildLoopENSt6vectorIPT0_SaIS3_EE14const_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBase15removeChildLoopENSt6vectorIPT0_SaIS3_EE14const_iteratorE")
  //</editor-fold>
  public LoopT /*P*/ removeChildLoop( std.vector.iterator<LoopT /*P*/ > I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This adds a basic block directly to the basic block list.
  /// This should only be used by transformations that create new loops.  Other
  /// transformations should use addBasicBlockToLoop.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::addBlockEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 286,
   FQN="llvm::LoopBase::addBlockEntry", NM="_ZN4llvm8LoopBase13addBlockEntryEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBase13addBlockEntryEPT_")
  //</editor-fold>
  public void addBlockEntry(BlockT /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// interface to reverse Blocks[from, end of loop] in this loop
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::reverseBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 292,
   FQN="llvm::LoopBase::reverseBlock", NM="_ZN4llvm8LoopBase12reverseBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBase12reverseBlockEj")
  //</editor-fold>
  public void reverseBlock(/*uint*/int from) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// interface to do reserve() for Blocks
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::reserveBlocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 297,
   FQN="llvm::LoopBase::reserveBlocks", NM="_ZN4llvm8LoopBase13reserveBlocksEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBase13reserveBlocksEj")
  //</editor-fold>
  public void reserveBlocks(/*uint*/int size) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This method is used to move BB (which must be part of this loop) to be the
  /// loop header of the loop (the block that dominates all others).
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::moveToHeader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 303,
   FQN="llvm::LoopBase::moveToHeader", NM="_ZN4llvm8LoopBase12moveToHeaderEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBase12moveToHeaderEPT_")
  //</editor-fold>
  public void moveToHeader(BlockT /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This removes the specified basic block from the current loop, updating the
  /// Blocks as appropriate. This does not update the mapping in the LoopInfo
  /// class.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::removeBlockFromLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 318,
   FQN="llvm::LoopBase::removeBlockFromLoop", NM="_ZN4llvm8LoopBase19removeBlockFromLoopEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBase19removeBlockFromLoopEPT_")
  //</editor-fold>
  public void removeBlockFromLoop(BlockT /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Verify loop structure
  
  /// verifyLoop - Verify loop structure
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::verifyLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 223,
   FQN="llvm::LoopBase::verifyLoop", NM="_ZNK4llvm8LoopBase10verifyLoopEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase10verifyLoopEv")
  //</editor-fold>
  public void verifyLoop() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Verify loop structure of this loop and all nested loops.
  
  /// verifyLoop - Verify loop structure of this loop and all nested loops.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::verifyLoopNest">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 307,
   FQN="llvm::LoopBase::verifyLoopNest", NM="_ZNK4llvm8LoopBase14verifyLoopNestEPNS_8DenseSetIPKT0_NS_12DenseMapInfoIS4_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase14verifyLoopNestEPNS_8DenseSetIPKT0_NS_12DenseMapInfoIS4_EEEE")
  //</editor-fold>
  public void verifyLoopNest(DenseSet</*const*/ LoopT /*P*/ > /*P*/ Loops) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 318,
   FQN="llvm::LoopBase::print", NM="_ZNK4llvm8LoopBase5printERNS_11raw_ostreamEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBase5printERNS_11raw_ostreamEj")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    print(OS, 0);
  }
  public void print(final raw_ostream /*&*/ OS, /*uint*/int Depth/*= 0*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*protected:*/
  /*friend  class LoopInfoBase<BlockT, LoopT>*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase::LoopBase<N, M>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 336,
   FQN="llvm::LoopBase::LoopBase<N, M>", NM="_ZN4llvm8LoopBaseC1EPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseC1EPT_")
  //</editor-fold>
  protected /*explicit*/ LoopBase(BlockT /*P*/ BB) {
    // : ParentLoop(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "ParentLoop=" + ParentLoop // NOI18N
              + ", SubLoops=" + SubLoops // NOI18N
              + ", Blocks=" + Blocks // NOI18N
              + ", DenseBlockSet=" + DenseBlockSet // NOI18N
              + ", IsInvalid=" + IsInvalid; // NOI18N
  }
}

// Implementation in LoopInfoImpl.h
//<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 349,
 FQN="llvm::LoopBase<BasicBlock, Loop>", NM="_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEEE")
//</editor-fold>
public static class LoopBase$BasicBlock$Loop extends LoopBase<BasicBlock,Loop> implements Destructors.ClassWithDestructor {
//  private Loop /*P*/ ParentLoop;
//  private std.vector<Loop /*P*/ > SubLoops;
//  private std.vector<BasicBlock /*P*/ > Blocks;
//  
//  private SmallPtrSet</*const*/ BasicBlock /*P*/ > DenseBlockSet;
//  private boolean IsInvalid/* = false*/;
//  
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::LoopBase">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 81,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::LoopBase", NM="_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEEC1ERKS3_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEEC1ERKS3_")
//  //</editor-fold>
//  protected/*private*/ LoopBase$BasicBlock$Loop(final /*const*/ LoopBase<BasicBlock, Loop> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::operator=">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 82,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::operator=", NM="_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEEaSERKS3_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEEaSERKS3_")
//  //</editor-fold>
//  protected/*private*/ /*const*/ LoopBase<BasicBlock, Loop> /*&*/ $assign(final /*const*/ LoopBase<BasicBlock, Loop> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}
//
///*public:*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::LoopBase">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 86,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::LoopBase", NM="_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEEC1Ev",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEEC1Ev")
//  //</editor-fold>
//  public LoopBase() {
//    // : ParentLoop(null), SubLoops(), Blocks(), DenseBlockSet(), IsInvalid(false) 
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::~LoopBase">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 87,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::~LoopBase", NM="_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEED0Ev",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEED0Ev")
//  //</editor-fold>
//  public void $destroy() {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::getLoopDepth">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 95,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::getLoopDepth", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE12getLoopDepthEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE12getLoopDepthEv")
//  //</editor-fold>
//  public /*uint*/int getLoopDepth() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::getHeader">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 102,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::getHeader", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE9getHeaderEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE9getHeaderEv")
//  //</editor-fold>
//  public BasicBlock /*P*/ getHeader() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::getParentLoop">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 103,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::getParentLoop", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE13getParentLoopEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE13getParentLoopEv")
//  //</editor-fold>
//  public Loop /*P*/ getParentLoop() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::setParentLoop">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 106,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::setParentLoop", NM="_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE13setParentLoopEPS2_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE13setParentLoopEPS2_")
//  //</editor-fold>
//  public void setParentLoop(Loop /*P*/ L) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::contains">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 109,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::contains", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE8containsEPKS2_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE8containsEPKS2_")
//  //</editor-fold>
//  public boolean contains_T1$C$P(/*const*/ Loop /*P*/ L) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::contains">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 116,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::contains", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE8containsEPKS1_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE8containsEPKS1_")
//  //</editor-fold>
//  public boolean contains_T$C$P(/*const*/ BasicBlock /*P*/ BB) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  /*template <class InstT> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::contains">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 122,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::contains", NM="Tpl__ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE8containsEPKT_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=Tpl__ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE8containsEPKT_")
//  //</editor-fold>
//  public </*class*/ InstT> boolean contains_T$C$P(/*const*/ InstT /*P*/ Inst) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::getSubLoops">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 127,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::getSubLoops", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE11getSubLoopsEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE11getSubLoopsEv")
//  //</editor-fold>
//  public /*const*/std.vector<Loop /*P*/ > /*&*/ getSubLoops() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::getSubLoopsVector">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 128,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::getSubLoopsVector", NM="_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE17getSubLoopsVectorEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE17getSubLoopsVectorEv")
//  //</editor-fold>
//  public std.vector<Loop /*P*/ > /*&*/ getSubLoopsVector() {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  // JAVA: typedef typename std::vector<Loop *>::const_iterator iterator
////  public final class iterator extends std.vector.iterator</*const*/ Loop /*P*/ >{ };
//  // JAVA: typedef typename std::vector<Loop *>::const_reverse_iterator reverse_iterator
////  public final class reverse_iterator extends std.reverse_iterator</*const*/ Loop /*&*/ >{ };
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::begin">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 132,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::begin", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE5beginEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE5beginEv")
//  //</editor-fold>
//  public std.vector.iterator</*const*/ Loop /*P*/ > begin() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::end">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 133,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::end", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE3endEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE3endEv")
//  //</editor-fold>
//  public std.vector.iterator</*const*/ Loop /*P*/ > end() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::rbegin">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 134,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::rbegin", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE6rbeginEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE6rbeginEv")
//  //</editor-fold>
//  public std.reverse_iterator</*const*/ Loop /*&*/ > rbegin() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::rend">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 135,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::rend", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE4rendEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE4rendEv")
//  //</editor-fold>
//  public std.reverse_iterator</*const*/ Loop /*&*/ > rend() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::empty">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 136,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::empty", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE5emptyEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE5emptyEv")
//  //</editor-fold>
//  public boolean empty() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::getBlocks">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 139,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::getBlocks", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE9getBlocksEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE9getBlocksEv")
//  //</editor-fold>
//  public /*const*/std.vector<BasicBlock /*P*/ > /*&*/ getBlocks() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  // JAVA: typedef typename std::vector<BasicBlock *>::const_iterator block_iterator
////  public final class block_iterator extends std.vector.iterator</*const*/ BasicBlock /*P*/ >{ };
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::block_begin">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 141,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::block_begin", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE11block_beginEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE11block_beginEv")
//  //</editor-fold>
//  public std.vector.iterator</*const*/ BasicBlock /*P*/ > block_begin() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::block_end">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 142,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::block_end", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE9block_endEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE9block_endEv")
//  //</editor-fold>
//  public std.vector.iterator</*const*/ BasicBlock /*P*/ > block_end() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::blocks">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 143,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::blocks", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE6blocksEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE6blocksEv")
//  //</editor-fold>
//  public /*inline*/ iterator_range</*const*/ BasicBlock /*&*/ > blocks() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::getNumBlocks">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 148,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::getNumBlocks", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE12getNumBlocksEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE12getNumBlocksEv")
//  //</editor-fold>
//  public /*uint*/int getNumBlocks() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::invalidate">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 153,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::invalidate", NM="_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE10invalidateEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE10invalidateEv")
//  //</editor-fold>
//  public void invalidate() {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::isInvalid">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 156,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::isInvalid", NM="_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE9isInvalidEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE9isInvalidEv")
//  //</editor-fold>
//  public boolean isInvalid() {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::isLoopExiting">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 160,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::isLoopExiting", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE13isLoopExitingEPKS1_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE13isLoopExitingEPKS1_")
//  //</editor-fold>
//  public boolean isLoopExiting(/*const*/ BasicBlock /*P*/ BB) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::getNumBackEdges">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 172,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::getNumBackEdges", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE15getNumBackEdgesEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE15getNumBackEdgesEv")
//  //</editor-fold>
//  public /*uint*/int getNumBackEdges() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::getExitingBlocks">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 34,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::getExitingBlocks", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE16getExitingBlocksERNS_15SmallVectorImplIPS1_EE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE16getExitingBlocksERNS_15SmallVectorImplIPS1_EE")
//  //</editor-fold>
//  public void getExitingBlocks(final SmallVectorImpl<BasicBlock /*P*/ > /*&*/ ExitingBlocks) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::getExitingBlock">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 51,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::getExitingBlock", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE15getExitingBlockEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE15getExitingBlockEv")
//  //</editor-fold>
//  public BasicBlock /*P*/ getExitingBlock() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::getExitBlocks">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 63,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::getExitBlocks", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE13getExitBlocksERNS_15SmallVectorImplIPS1_EE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE13getExitBlocksERNS_15SmallVectorImplIPS1_EE")
//  //</editor-fold>
//  public void getExitBlocks(final SmallVectorImpl<BasicBlock /*P*/ > /*&*/ ExitBlocks) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::getExitBlock">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 78,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::getExitBlock", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE12getExitBlockEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE12getExitBlockEv")
//  //</editor-fold>
//  public BasicBlock /*P*/ getExitBlock() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  // JAVA: typedef std::pair<const BasicBlock *, const BasicBlock *> Edge
////  public final class Edge extends std.pair</*const*/ BasicBlock /*P*/ , /*const*/ BasicBlock /*P*/ >{ };
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::getExitEdges">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 88,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::getExitEdges", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE12getExitEdgesERNS_15SmallVectorImplISt4pairIPKS1_S7_EEE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE12getExitEdgesERNS_15SmallVectorImplISt4pairIPKS1_S7_EEE")
//  //</editor-fold>
//  public void getExitEdges(final SmallVectorImpl<std.pair</*const*/ BasicBlock /*P*/ , /*const*/ BasicBlock /*P*/ > > /*&*/ ExitEdges) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::getLoopPreheader">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 108,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::getLoopPreheader", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE16getLoopPreheaderEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE16getLoopPreheaderEv")
//  //</editor-fold>
//  public BasicBlock /*P*/ getLoopPreheader() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::getLoopPredecessor">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 130,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::getLoopPredecessor", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE18getLoopPredecessorEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE18getLoopPredecessorEv")
//  //</editor-fold>
//  public BasicBlock /*P*/ getLoopPredecessor() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::getLoopLatch">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 156,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::getLoopLatch", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE12getLoopLatchEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE12getLoopLatchEv")
//  //</editor-fold>
//  public BasicBlock /*P*/ getLoopLatch() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::getLoopLatches">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 237,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::getLoopLatches", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE14getLoopLatchesERNS_15SmallVectorImplIPS1_EE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE14getLoopLatchesERNS_15SmallVectorImplIPS1_EE")
//  //</editor-fold>
//  public void getLoopLatches(final SmallVectorImpl<BasicBlock /*P*/ > /*&*/ LoopLatches) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::addBasicBlockToLoop">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 186,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::addBasicBlockToLoop", NM="_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE19addBasicBlockToLoopEPS1_RNS_12LoopInfoBaseIS1_S2_EE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE19addBasicBlockToLoopEPS1_RNS_12LoopInfoBaseIS1_S2_EE")
//  //</editor-fold>
//  public void addBasicBlockToLoop(BasicBlock /*P*/ NewBB, final LoopInfoBase<BasicBlock, Loop> /*&*/ LIB) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::replaceChildLoopWith">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 210,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::replaceChildLoopWith", NM="_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE20replaceChildLoopWithEPS2_S4_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE20replaceChildLoopWithEPS2_S4_")
//  //</editor-fold>
//  public void replaceChildLoopWith(Loop /*P*/ OldChild, Loop /*P*/ NewChild) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::addChildLoop">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 266,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::addChildLoop", NM="_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE12addChildLoopEPS2_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE12addChildLoopEPS2_")
//  //</editor-fold>
//  public void addChildLoop(Loop /*P*/ NewChild) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::removeChildLoop">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 274,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::removeChildLoop", NM="_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE15removeChildLoopEN9__gnu_cxx17__normal_iteratorIPKPS2_St6vectorIS6_SaIS6_EEEE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE15removeChildLoopEN9__gnu_cxx17__normal_iteratorIPKPS2_St6vectorIS6_SaIS6_EEEE")
//  //</editor-fold>
//  public Loop /*P*/ removeChildLoop(std.vector.iterator</*const*/ Loop /*P*/ > I) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::addBlockEntry">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 286,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::addBlockEntry", NM="_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE13addBlockEntryEPS1_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE13addBlockEntryEPS1_")
//  //</editor-fold>
//  public void addBlockEntry(BasicBlock /*P*/ BB) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::reverseBlock">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 292,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::reverseBlock", NM="_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE12reverseBlockEj",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE12reverseBlockEj")
//  //</editor-fold>
//  public void reverseBlock(/*uint*/int from) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::reserveBlocks">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 297,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::reserveBlocks", NM="_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE13reserveBlocksEj",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE13reserveBlocksEj")
//  //</editor-fold>
//  public void reserveBlocks(/*uint*/int size) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::moveToHeader">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 303,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::moveToHeader", NM="_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE12moveToHeaderEPS1_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE12moveToHeaderEPS1_")
//  //</editor-fold>
//  public void moveToHeader(BasicBlock /*P*/ BB) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::removeBlockFromLoop">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 318,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::removeBlockFromLoop", NM="_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE19removeBlockFromLoopEPS1_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE19removeBlockFromLoopEPS1_")
//  //</editor-fold>
//  public void removeBlockFromLoop(BasicBlock /*P*/ BB) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::verifyLoop">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 224,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::verifyLoop", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE10verifyLoopEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE10verifyLoopEv")
//  //</editor-fold>
//  public void verifyLoop() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::verifyLoopNest">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 308,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::verifyLoopNest", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE14verifyLoopNestEPNS_8DenseSetIPKS2_NS_12DenseMapInfoIS6_EEEE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE14verifyLoopNestEPNS_8DenseSetIPKS2_NS_12DenseMapInfoIS6_EEEE")
//  //</editor-fold>
//  public void verifyLoopNest(DenseSet</*const*/ Loop /*P*/ > /*P*/ Loops) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::print">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 319,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::print", NM="_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE5printERNS_11raw_ostreamEj",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm8LoopBaseINS_10BasicBlockENS_4LoopEE5printERNS_11raw_ostreamEj")
//  //</editor-fold>
//  public void print(final raw_ostream /*&*/ OS) /*const*/ {
//    print(OS, 0);
//  }
//  public void print(final raw_ostream /*&*/ OS, /*uint*/int Depth/*= 0*/) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
///*protected:*/
//  /*friend  class LoopInfoBase<BasicBlock, Loop>*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopBase<BasicBlock, Loop>::LoopBase">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 336,
//   FQN="llvm::LoopBase<BasicBlock, Loop>::LoopBase", NM="_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEEC1EPS1_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm8LoopBaseINS_10BasicBlockENS_4LoopEEC1EPS1_")
//  //</editor-fold>
//  protected /*explicit*/ LoopBase$BasicBlock$Loop(BasicBlock /*P*/ BB) {
//    // : ParentLoop(null), SubLoops(), Blocks(), DenseBlockSet(), IsInvalid(false) 
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  @Override public String toString() {
//    return "" + "ParentLoop=" + ParentLoop // NOI18N
//              + ", SubLoops=" + SubLoops // NOI18N
//              + ", Blocks=" + Blocks // NOI18N
//              + ", DenseBlockSet=" + DenseBlockSet // NOI18N
//              + ", IsInvalid=" + IsInvalid; // NOI18N
//  }
}

//===----------------------------------------------------------------------===//
/// This class builds and contains all of the top-level loop
/// structures in the specified function.
///
/*template <class BlockT, class LoopT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 479,
 FQN="llvm::LoopInfoBase", NM="_ZN4llvm12LoopInfoBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseE")
//</editor-fold>
public static class LoopInfoBase</*class*/ BlockT, /*class*/ LoopT>  implements Iterable<LoopT /*P*/>, Destructors.ClassWithDestructor {
  // BBMap - Mapping of basic blocks to the inner most loop they occur in
  private DenseMap</*const*/ BlockT /*P*/ , LoopT /*P*/ > BBMap;
  private std.vector<LoopT /*P*/ > TopLevelLoops;
  /*friend*/public/*private*/ std.vector<LoopT /*P*/ > RemovedLoops;
  
  /*friend  class LoopBase<BlockT, LoopT>*/
  /*friend  class LoopInfo*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 489,
   FQN="llvm::LoopInfoBase::operator=", NM="_ZN4llvm12LoopInfoBaseaSERKNS_12LoopInfoBaseIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseaSERKNS_12LoopInfoBaseIT_T0_EE")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ LoopInfoBase</*class*/ BlockT, /*class*/ LoopT> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::LoopInfoBase<N, M>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 490,
   FQN="llvm::LoopInfoBase::LoopInfoBase<N, M>", NM="_ZN4llvm12LoopInfoBaseC1ERKNS_12LoopInfoBaseIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseC1ERKNS_12LoopInfoBaseIT_T0_EE")
  //</editor-fold>
  protected/*private*/ LoopInfoBase(final /*const*/ LoopInfoBase</*class*/ BlockT, /*class*/ LoopT> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::LoopInfoBase<N, M>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 492,
   FQN="llvm::LoopInfoBase::LoopInfoBase<N, M>", NM="_ZN4llvm12LoopInfoBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseC1Ev")
  //</editor-fold>
  public LoopInfoBase() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::~LoopInfoBase<N, M>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 493,
   FQN="llvm::LoopInfoBase::~LoopInfoBase<N, M>", NM="_ZN4llvm12LoopInfoBaseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::LoopInfoBase<N, M>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 495,
   FQN="llvm::LoopInfoBase::LoopInfoBase<N, M>", NM="_ZN4llvm12LoopInfoBaseC1EONS_12LoopInfoBaseIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseC1EONS_12LoopInfoBaseIT_T0_EE")
  //</editor-fold>
  public LoopInfoBase(JD$Move _dparam, final LoopInfoBase</*class*/ BlockT, /*class*/ LoopT> /*&&*/Arg) {
    // : BBMap(std::move(Arg.BBMap)), TopLevelLoops(std::move(Arg.TopLevelLoops)) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 501,
   FQN="llvm::LoopInfoBase::operator=", NM="_ZN4llvm12LoopInfoBaseaSEONS_12LoopInfoBaseIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseaSEONS_12LoopInfoBaseIT_T0_EE")
  //</editor-fold>
  public LoopInfoBase</*class*/ BlockT, /*class*/ LoopT> /*&*/ $assignMove(final LoopInfoBase</*class*/ BlockT, /*class*/ LoopT> /*&&*/RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 511,
   FQN="llvm::LoopInfoBase::releaseMemory", NM="_ZN4llvm12LoopInfoBase13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBase13releaseMemoryEv")
  //</editor-fold>
  public void releaseMemory() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// iterator/begin/end - The interface to the top-level loops in the current
  /// function.
  ///
  // JAVA: typedef typename std::vector<LoopT *>::const_iterator iterator
//  public final class iterator extends  std.vector.const_iterator<LoopT /*P*/ >{ };
  // JAVA: typedef typename std::vector<LoopT *>::const_reverse_iterator reverse_iterator
//  public final class reverse_iterator extends  std.vector.const_reverse_iterator<LoopT /*P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 528,
   FQN="llvm::LoopInfoBase::begin", NM="_ZNK4llvm12LoopInfoBase5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBase5beginEv")
  //</editor-fold>
  public  std.vector.iterator<LoopT /*P*/ > begin() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 529,
   FQN="llvm::LoopInfoBase::end", NM="_ZNK4llvm12LoopInfoBase3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBase3endEv")
  //</editor-fold>
  public  std.vector.iterator<LoopT /*P*/ > end() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::rbegin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 530,
   FQN="llvm::LoopInfoBase::rbegin", NM="_ZNK4llvm12LoopInfoBase6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBase6rbeginEv")
  //</editor-fold>
  public  std.reverse_iterator<LoopT /*P*/ > rbegin() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::rend">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 531,
   FQN="llvm::LoopInfoBase::rend", NM="_ZNK4llvm12LoopInfoBase4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBase4rendEv")
  //</editor-fold>
  public  std.reverse_iterator<LoopT /*P*/ > rend() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::empty">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 532,
   FQN="llvm::LoopInfoBase::empty", NM="_ZNK4llvm12LoopInfoBase5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBase5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the inner most loop that BB lives in. If a basic block is in no
  /// loop (for example the entry node), null is returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::getLoopFor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 536,
   FQN="llvm::LoopInfoBase::getLoopFor", NM="_ZNK4llvm12LoopInfoBase10getLoopForEPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBase10getLoopForEPKT_")
  //</editor-fold>
  public LoopT /*P*/ getLoopFor(/*const*/ BlockT /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Same as getLoopFor.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::operator[]">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 539,
   FQN="llvm::LoopInfoBase::operator[]", NM="_ZNK4llvm12LoopInfoBaseixEPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBaseixEPKT_")
  //</editor-fold>
  public /*const*/ LoopT /*P*/ $at(/*const*/ BlockT /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the loop nesting level of the specified block. A depth of 0 means
  /// the block is not inside any loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::getLoopDepth">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 545,
   FQN="llvm::LoopInfoBase::getLoopDepth", NM="_ZNK4llvm12LoopInfoBase12getLoopDepthEPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBase12getLoopDepthEPKT_")
  //</editor-fold>
  public /*uint*/int getLoopDepth(/*const*/ BlockT /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // True if the block is a loop header node
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::isLoopHeader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 551,
   FQN="llvm::LoopInfoBase::isLoopHeader", NM="_ZNK4llvm12LoopInfoBase12isLoopHeaderEPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBase12isLoopHeaderEPKT_")
  //</editor-fold>
  public boolean isLoopHeader(/*const*/ BlockT /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This removes the specified top-level loop from this loop info object.
  /// The loop is not deleted, as it will presumably be inserted into
  /// another loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::removeLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 559,
   FQN="llvm::LoopInfoBase::removeLoop", NM="_ZN4llvm12LoopInfoBase10removeLoopENSt6vectorIPT0_SaIS3_EE14const_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBase10removeLoopENSt6vectorIPT0_SaIS3_EE14const_iteratorE")
  //</editor-fold>
  public LoopT /*P*/ removeLoop( std.vector.iterator<LoopT /*P*/ > I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Change the top-level loop that contains BB to the specified loop.
  /// This should be used by transformations that restructure the loop hierarchy
  /// tree.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::changeLoopFor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 570,
   FQN="llvm::LoopInfoBase::changeLoopFor", NM="_ZN4llvm12LoopInfoBase13changeLoopForEPT_PT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBase13changeLoopForEPT_PT0_")
  //</editor-fold>
  public void changeLoopFor(BlockT /*P*/ BB, LoopT /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Replace the specified loop in the top-level loops list with the indicated
  /// loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::changeTopLevelLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 580,
   FQN="llvm::LoopInfoBase::changeTopLevelLoop", NM="_ZN4llvm12LoopInfoBase18changeTopLevelLoopEPT0_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBase18changeTopLevelLoopEPT0_S2_")
  //</editor-fold>
  public void changeTopLevelLoop(LoopT /*P*/ OldLoop, 
                    LoopT /*P*/ NewLoop) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This adds the specified loop to the collection of top-level loops.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::addTopLevelLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 590,
   FQN="llvm::LoopInfoBase::addTopLevelLoop", NM="_ZN4llvm12LoopInfoBase15addTopLevelLoopEPT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBase15addTopLevelLoopEPT0_")
  //</editor-fold>
  public void addTopLevelLoop(LoopT /*P*/ New) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This method completely removes BB from all data structures,
  /// including all of the Loop objects it is nested in and our mapping from
  /// BasicBlocks to loops.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::removeBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 598,
   FQN="llvm::LoopInfoBase::removeBlock", NM="_ZN4llvm12LoopInfoBase11removeBlockEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBase11removeBlockEPT_")
  //</editor-fold>
  public void removeBlock(BlockT /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Internals
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::isNotAlreadyContainedIn">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 610,
   FQN="llvm::LoopInfoBase::isNotAlreadyContainedIn", NM="_ZN4llvm12LoopInfoBase23isNotAlreadyContainedInEPKT0_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBase23isNotAlreadyContainedInEPKT0_S3_")
  //</editor-fold>
  public static </*class*/ BlockT, /*class*/ LoopT> boolean isNotAlreadyContainedIn(/*const*/ LoopT /*P*/ SubLoop, 
                         /*const*/ LoopT /*P*/ ParentLoop) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Create the loop forest using a stable algorithm.
  
  /// Analyze LoopInfo discovers loops during a postorder DominatorTree traversal
  /// interleaved with backward CFG traversals within each subloop
  /// (discoverAndMapSubloop). The backward traversal skips inner subloops, so
  /// this part of the algorithm is linear in the number of CFG edges. Subloop and
  /// Block vectors are then populated during a single forward CFG traversal
  /// (PopulateLoopDFS).
  ///
  /// During the two CFG traversals each block is seen three times:
  /// 1) Discovered and mapped by a reverse CFG traversal.
  /// 2) Visited during a forward DFS CFG traversal.
  /// 3) Reverse-inserted in the loop in postorder following forward DFS.
  ///
  /// The Block vectors are inclusive, so step 3 requires loop-depth number of
  /// insertions per block.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::analyze">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 469,
   FQN="llvm::LoopInfoBase::analyze", NM="_ZN4llvm12LoopInfoBase7analyzeERKNS_17DominatorTreeBaseIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBase7analyzeERKNS_17DominatorTreeBaseIT_EE")
  //</editor-fold>
  public void analyze(final /*const*/ DominatorTreeBase<BlockT> /*&*/ DomTree) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Debugging
  
  // Debugging
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 507,
   FQN="llvm::LoopInfoBase::print", NM="_ZNK4llvm12LoopInfoBase5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBase5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase::verify">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 519,
   FQN="llvm::LoopInfoBase::verify", NM="_ZNK4llvm12LoopInfoBase6verifyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBase6verifyEv")
  //</editor-fold>
  public void verify() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  @Override
  public Iterator<LoopT> iterator() {
    return new JavaIterator<>(begin(), end());
  }
  
  @Override public String toString() {
    return "" + "BBMap=" + BBMap // NOI18N
              + ", TopLevelLoops=" + TopLevelLoops // NOI18N
              + ", RemovedLoops=" + RemovedLoops; // NOI18N
  }
}

// Implementation in LoopInfoImpl.h
//<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 627,
 FQN="llvm::LoopInfoBase<BasicBlock, Loop>", NM="_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEEE")
//</editor-fold>
public static class LoopInfoBase$BasicBlock$Loop extends LoopInfoBase</*class*/ BasicBlock, /*class*/ Loop> implements Destructors.ClassWithDestructor {
//  private DenseMap</*const*/ BasicBlock /*P*/ , Loop /*P*/ > BBMap;
//  private std.vector<Loop /*P*/ > TopLevelLoops;
//  private std.vector<Loop /*P*/ > RemovedLoops;
//  
//  /*friend  class LoopBase<BasicBlock, Loop>*/
//  /*friend  class LoopInfo*/
//  
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::operator=">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 489,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::operator=", NM="_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEEaSERKS3_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEEaSERKS3_")
//  //</editor-fold>
//  protected/*private*/ void $assign(final /*const*/ LoopInfoBase<BasicBlock, Loop> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::LoopInfoBase">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 490,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::LoopInfoBase", NM="_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEEC1ERKS3_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEEC1ERKS3_")
//  //</editor-fold>
//  protected/*private*/ LoopInfoBase(final /*const*/ LoopInfoBase<BasicBlock, Loop> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}
//
///*public:*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::LoopInfoBase">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 492,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::LoopInfoBase", NM="_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEEC1Ev",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEEC1Ev")
//  //</editor-fold>
//  public LoopInfoBase() {
//    // : BBMap(), TopLevelLoops(), RemovedLoops() 
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::~LoopInfoBase">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 493,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::~LoopInfoBase", NM="_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEED0Ev",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEED0Ev")
//  //</editor-fold>
//  public void $destroy() {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::LoopInfoBase">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 495,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::LoopInfoBase", NM="_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEEC1EOS3_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEEC1EOS3_")
//  //</editor-fold>
//  public LoopInfoBase(JD$Move _dparam, final LoopInfoBase<BasicBlock, Loop> /*&&*/Arg) {
//    // : BBMap(std::move(Arg.BBMap)), TopLevelLoops(std::move(Arg.TopLevelLoops)), RemovedLoops() 
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::operator=">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 501,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::operator=", NM="_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEEaSEOS3_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEEaSEOS3_")
//  //</editor-fold>
//  public LoopInfoBase<BasicBlock, Loop> /*&*/ $assignMove(final LoopInfoBase<BasicBlock, Loop> /*&&*/RHS) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::releaseMemory">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 511,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::releaseMemory", NM="_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE13releaseMemoryEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE13releaseMemoryEv")
//  //</editor-fold>
//  public void releaseMemory() {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  // JAVA: typedef typename std::vector<Loop *>::const_iterator iterator
////  public final class iterator extends std.vector.iterator</*const*/ Loop /*P*/ >{ };
//  // JAVA: typedef typename std::vector<Loop *>::const_reverse_iterator reverse_iterator
////  public final class reverse_iterator extends std.reverse_iterator</*const*/ Loop /*&*/ >{ };
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::begin">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 528,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::begin", NM="_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE5beginEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE5beginEv")
//  //</editor-fold>
//  public std.vector.iterator</*const*/ Loop /*P*/ > begin() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::end">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 529,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::end", NM="_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE3endEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE3endEv")
//  //</editor-fold>
//  public std.vector.iterator</*const*/ Loop /*P*/ > end() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::rbegin">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 530,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::rbegin", NM="_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE6rbeginEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE6rbeginEv")
//  //</editor-fold>
//  public std.reverse_iterator</*const*/ Loop /*&*/ > rbegin() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::rend">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 531,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::rend", NM="_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE4rendEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE4rendEv")
//  //</editor-fold>
//  public std.reverse_iterator</*const*/ Loop /*&*/ > rend() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::empty">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 532,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::empty", NM="_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE5emptyEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE5emptyEv")
//  //</editor-fold>
//  public boolean empty() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::getLoopFor">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 536,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::getLoopFor", NM="_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE10getLoopForEPKS1_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE10getLoopForEPKS1_")
//  //</editor-fold>
//  public Loop /*P*/ getLoopFor(/*const*/ BasicBlock /*P*/ BB) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::operator[]">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 539,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::operator[]", NM="_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEEixEPKS1_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEEixEPKS1_")
//  //</editor-fold>
//  public /*const*/ Loop /*P*/ $at(/*const*/ BasicBlock /*P*/ BB) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::getLoopDepth">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 545,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::getLoopDepth", NM="_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE12getLoopDepthEPKS1_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE12getLoopDepthEPKS1_")
//  //</editor-fold>
//  public /*uint*/int getLoopDepth(/*const*/ BasicBlock /*P*/ BB) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::isLoopHeader">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 551,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::isLoopHeader", NM="_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE12isLoopHeaderEPKS1_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE12isLoopHeaderEPKS1_")
//  //</editor-fold>
//  public boolean isLoopHeader(/*const*/ BasicBlock /*P*/ BB) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::removeLoop">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 559,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::removeLoop", NM="_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE10removeLoopEN9__gnu_cxx17__normal_iteratorIPKPS2_St6vectorIS6_SaIS6_EEEE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE10removeLoopEN9__gnu_cxx17__normal_iteratorIPKPS2_St6vectorIS6_SaIS6_EEEE")
//  //</editor-fold>
//  public Loop /*P*/ removeLoop(std.vector.iterator</*const*/ Loop /*P*/ > I) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::changeLoopFor">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 570,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::changeLoopFor", NM="_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE13changeLoopForEPS1_PS2_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE13changeLoopForEPS1_PS2_")
//  //</editor-fold>
//  public void changeLoopFor(BasicBlock /*P*/ BB, Loop /*P*/ L) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::changeTopLevelLoop">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 580,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::changeTopLevelLoop", NM="_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE18changeTopLevelLoopEPS2_S4_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE18changeTopLevelLoopEPS2_S4_")
//  //</editor-fold>
//  public void changeTopLevelLoop(Loop /*P*/ OldLoop, 
//                    Loop /*P*/ NewLoop) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::addTopLevelLoop">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 590,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::addTopLevelLoop", NM="_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE15addTopLevelLoopEPS2_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE15addTopLevelLoopEPS2_")
//  //</editor-fold>
//  public void addTopLevelLoop(Loop /*P*/ New) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::removeBlock">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 598,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::removeBlock", NM="_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE11removeBlockEPS1_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE11removeBlockEPS1_")
//  //</editor-fold>
//  public void removeBlock(BasicBlock /*P*/ BB) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::isNotAlreadyContainedIn">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 610,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::isNotAlreadyContainedIn", NM="_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE23isNotAlreadyContainedInEPKS2_S5_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE23isNotAlreadyContainedInEPKS2_S5_")
//  //</editor-fold>
//  public static boolean isNotAlreadyContainedIn(/*const*/ Loop /*P*/ SubLoop, 
//                         /*const*/ Loop /*P*/ ParentLoop) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::analyze">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 470,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::analyze", NM="_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE7analyzeERKNS_17DominatorTreeBaseIS1_EE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE7analyzeERKNS_17DominatorTreeBaseIS1_EE")
//  //</editor-fold>
//  public void analyze(final /*const*/DominatorTreeBase$BasicBlock /*&*/ DomTree) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::print">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 508,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::print", NM="_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE5printERNS_11raw_ostreamE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE5printERNS_11raw_ostreamE")
//  //</editor-fold>
//  public void print(final raw_ostream /*&*/ OS) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::LoopInfoBase<BasicBlock, Loop>::verify">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 520,
//   FQN="llvm::LoopInfoBase<BasicBlock, Loop>::verify", NM="_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE6verifyEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZNK4llvm12LoopInfoBaseINS_10BasicBlockENS_4LoopEE6verifyEv")
//  //</editor-fold>
//  public void verify() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  @Override public String toString() {
//    return "" + "BBMap=" + BBMap // NOI18N
//              + ", TopLevelLoops=" + TopLevelLoops // NOI18N
//              + ", RemovedLoops=" + RemovedLoops; // NOI18N
//  }
}
} // END OF class LoopInfoGlobals
