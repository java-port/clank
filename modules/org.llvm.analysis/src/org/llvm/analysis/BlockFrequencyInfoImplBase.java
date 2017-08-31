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
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.APInt;
import org.llvm.adt.aliases.SmallVector;
import org.llvm.adt.iterator_range;
import org.llvm.adt.scc_iterator;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.bfi_detail.*;
import static org.llvm.analysis.bfi_detail.Bfi_detailGlobals.*;
import org.llvm.analysis.impl.*;
import static org.llvm.analysis.impl.BlockFrequencyInfoImplStatics.*;


/// \brief Base class for BlockFrequencyInfoImpl
///
/// BlockFrequencyInfoImplBase has supporting data structures and some
/// algorithms for BlockFrequencyInfoImplBase.  Only algorithms that depend on
/// the block type (or that call such algorithms) are skipped here.
///
/// Nevertheless, the majority of the overall algorithm documention lives with
/// BlockFrequencyInfoImpl.  See there for details.
//<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 160,
 FQN="llvm::BlockFrequencyInfoImplBase", NM="_ZN4llvm26BlockFrequencyInfoImplBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBaseE")
//</editor-fold>
public class BlockFrequencyInfoImplBase implements Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef ScaledNumber<uint64_t> Scaled64
//  public final class Scaled64 extends ScaledNumberULLong{ };
  // JAVA: typedef bfi_detail::BlockMass BlockMass
//  public final class BlockMass extends BlockMass{ };
  
  /// \brief Representative of a block.
  ///
  /// This is a simple wrapper around an index into the reverse-post-order
  /// traversal of the blocks.
  ///
  /// Unlike a block pointer, its order has meaning (location in the
  /// topological sort) and it's class is the same regardless of block type.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::BlockNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 172,
   FQN="llvm::BlockFrequencyInfoImplBase::BlockNode", NM="_ZN4llvm26BlockFrequencyInfoImplBase9BlockNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase9BlockNodeE")
  //</editor-fold>
  public static class/*struct*/ BlockNode implements NativeCloneable<BlockNode>, Comparable<BlockNode>, Native.NativeComparable<BlockNode> {
    // JAVA: typedef uint32_t IndexType;
    public /*uint32_t*/int Index;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::BlockNode::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 176,
     FQN="llvm::BlockFrequencyInfoImplBase::BlockNode::operator==", NM="_ZNK4llvm26BlockFrequencyInfoImplBase9BlockNodeeqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase9BlockNodeeqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ BlockNode /*&*/ X) /*const*/ {
      return Index == X.Index;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::BlockNode::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 177,
     FQN="llvm::BlockFrequencyInfoImplBase::BlockNode::operator!=", NM="_ZNK4llvm26BlockFrequencyInfoImplBase9BlockNodeneERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase9BlockNodeneERKS1_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ BlockNode /*&*/ X) /*const*/ {
      return Index != X.Index;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::BlockNode::operator<=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 178,
     FQN="llvm::BlockFrequencyInfoImplBase::BlockNode::operator<=", NM="_ZNK4llvm26BlockFrequencyInfoImplBase9BlockNodeleERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase9BlockNodeleERKS1_")
    //</editor-fold>
    public boolean $lesseq(final /*const*/ BlockNode /*&*/ X) /*const*/ {
      return $lesseq_uint(Index, X.Index);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::BlockNode::operator>=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 179,
     FQN="llvm::BlockFrequencyInfoImplBase::BlockNode::operator>=", NM="_ZNK4llvm26BlockFrequencyInfoImplBase9BlockNodegeERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase9BlockNodegeERKS1_")
    //</editor-fold>
    public boolean $greatereq(final /*const*/ BlockNode /*&*/ X) /*const*/ {
      return $greatereq_uint(Index, X.Index);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::BlockNode::operator<">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 180,
     FQN="llvm::BlockFrequencyInfoImplBase::BlockNode::operator<", NM="_ZNK4llvm26BlockFrequencyInfoImplBase9BlockNodeltERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase9BlockNodeltERKS1_")
    //</editor-fold>
    public boolean $less(final /*const*/ BlockNode /*&*/ X) /*const*/ {
      return $less_uint(Index, X.Index);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::BlockNode::operator>">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 181,
     FQN="llvm::BlockFrequencyInfoImplBase::BlockNode::operator>", NM="_ZNK4llvm26BlockFrequencyInfoImplBase9BlockNodegtERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase9BlockNodegtERKS1_")
    //</editor-fold>
    public boolean $greater(final /*const*/ BlockNode /*&*/ X) /*const*/ {
      return $greater_uint(Index, X.Index);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::BlockNode::BlockNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 183,
     FQN="llvm::BlockFrequencyInfoImplBase::BlockNode::BlockNode", NM="_ZN4llvm26BlockFrequencyInfoImplBase9BlockNodeC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase9BlockNodeC1Ev")
    //</editor-fold>
    public BlockNode() {
      // : Index(4294967295U) 
      //START JInit
      this.Index = UINT32_MAX;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::BlockNode::BlockNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 184,
     FQN="llvm::BlockFrequencyInfoImplBase::BlockNode::BlockNode", NM="_ZN4llvm26BlockFrequencyInfoImplBase9BlockNodeC1Ej",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase9BlockNodeC1Ej")
    //</editor-fold>
    public BlockNode(/*uint32_t*/int Index) {
      // : Index(Index) 
      //START JInit
      this.Index = Index;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::BlockNode::isValid">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 186,
     FQN="llvm::BlockFrequencyInfoImplBase::BlockNode::isValid", NM="_ZNK4llvm26BlockFrequencyInfoImplBase9BlockNode7isValidEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase9BlockNode7isValidEv")
    //</editor-fold>
    public boolean isValid() /*const*/ {
      return $lesseq_uint(Index, BlockNode.getMaxIndex());
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::BlockNode::getMaxIndex">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 187,
     FQN="llvm::BlockFrequencyInfoImplBase::BlockNode::getMaxIndex", NM="_ZN4llvm26BlockFrequencyInfoImplBase9BlockNode11getMaxIndexEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase9BlockNode11getMaxIndexEv")
    //</editor-fold>
    public static /*size_t*/int getMaxIndex() {
      return UINT32_MAX - 1;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::BlockNode::BlockNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 172,
     FQN="llvm::BlockFrequencyInfoImplBase::BlockNode::BlockNode", NM="_ZN4llvm26BlockFrequencyInfoImplBase9BlockNodeC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase9BlockNodeC1ERKS1_")
    //</editor-fold>
    public /*inline*/ BlockNode(final /*const*/ BlockNode /*&*/ $Prm0) {
      // : Index(.Index) 
      //START JInit
      this.Index = $Prm0.Index;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::BlockNode::BlockNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 172,
     FQN="llvm::BlockFrequencyInfoImplBase::BlockNode::BlockNode", NM="_ZN4llvm26BlockFrequencyInfoImplBase9BlockNodeC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase9BlockNodeC1EOS1_")
    //</editor-fold>
    public /*inline*/ BlockNode(JD$Move _dparam, final BlockNode /*&&*/$Prm0) {
      // : Index(static_cast<BlockNode &&>().Index) 
      //START JInit
      this.Index = $Prm0.Index;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::BlockNode::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 172,
     FQN="llvm::BlockFrequencyInfoImplBase::BlockNode::operator=", NM="_ZN4llvm26BlockFrequencyInfoImplBase9BlockNodeaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase9BlockNodeaSERKS1_")
    //</editor-fold>
    public /*inline*/ BlockNode /*&*/ $assign(final /*const*/ BlockNode /*&*/ $Prm0) {
      this.Index = $Prm0.Index;
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::BlockNode::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 172,
     FQN="llvm::BlockFrequencyInfoImplBase::BlockNode::operator=", NM="_ZN4llvm26BlockFrequencyInfoImplBase9BlockNodeaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase9BlockNodeaSEOS1_")
    //</editor-fold>
    public /*inline*/ BlockNode /*&*/ $assignMove(final BlockNode /*&&*/$Prm0) {
      this.Index = $Prm0.Index;
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override
    public BlockNode clone() {
      return new BlockNode(this);
    }

    @Override
    public int compareTo(BlockNode o) {
      if (this.$less(o)) {
        return -1;
      } else if (this.$greater(o)) {
        return 1;
      }
      return 0;
    }
    

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Index=" + Index; // NOI18N
    }
  };
  
  /// \brief Stats about a block itself.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::FrequencyData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 191,
   FQN="llvm::BlockFrequencyInfoImplBase::FrequencyData", NM="_ZN4llvm26BlockFrequencyInfoImplBase13FrequencyDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase13FrequencyDataE")
  //</editor-fold>
  public static class/*struct*/ FrequencyData {
    public ScaledNumberULLong Scaled;
    public long/*uint64_t*/ Integer;
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::FrequencyData::FrequencyData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 191,
     FQN="llvm::BlockFrequencyInfoImplBase::FrequencyData::FrequencyData", NM="_ZN4llvm26BlockFrequencyInfoImplBase13FrequencyDataC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase13FrequencyDataC1Ev")
    //</editor-fold>
    public /*inline*/ FrequencyData() {
      // : Scaled() 
      //START JInit
      this.Scaled = new ScaledNumberULLong();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::FrequencyData::FrequencyData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 191,
     FQN="llvm::BlockFrequencyInfoImplBase::FrequencyData::FrequencyData", NM="_ZN4llvm26BlockFrequencyInfoImplBase13FrequencyDataC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase13FrequencyDataC1EOS1_")
    //</editor-fold>
    public /*inline*/ FrequencyData(JD$Move _dparam, final FrequencyData /*&&*/$Prm0) {
      // : Scaled(static_cast<FrequencyData &&>().Scaled), Integer(static_cast<FrequencyData &&>().Integer) 
      //START JInit
      this.Scaled = new ScaledNumberULLong(JD$Move.INSTANCE, $Prm0.Scaled);
      this.Integer = $Prm0.Integer;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Scaled=" + Scaled // NOI18N
                + ", Integer=" + Integer; // NOI18N
    }
  };
  
  /// \brief Data about a loop.
  ///
  /// Contains the data necessary to represent a loop as a pseudo-node once it's
  /// packaged.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::LoopData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 200,
   FQN="llvm::BlockFrequencyInfoImplBase::LoopData", NM="_ZN4llvm26BlockFrequencyInfoImplBase8LoopDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase8LoopDataE")
  //</editor-fold>
  public static class/*struct*/ LoopData implements Destructors.ClassWithDestructor {
    // JAVA: typedef SmallVector<std::pair<BlockNode, BlockMass>, 4> ExitMap
//    public final class ExitMap extends SmallVector<std.pairTypeType<BlockNode, BlockMass>>{ };
    // JAVA: typedef SmallVector<BlockNode, 4> NodeList
//    public final class NodeList extends SmallVector<BlockNode>{ };
    // JAVA: typedef SmallVector<BlockMass, 1> HeaderMassList
//    public final class HeaderMassList extends SmallVector<BlockMass>{ };
    public LoopData /*P*/ Parent; ///< The parent loop.
    public boolean IsPackaged; ///< Whether this has been packaged.
    public /*uint32_t*/int NumHeaders; ///< Number of headers.
    public SmallVector<std.pairTypeType<BlockNode, BlockMass>> Exits; ///< Successor edges (and weights).
    public SmallVector<BlockNode> Nodes; ///< Header and the members of the loop.
    public SmallVector<BlockMass> BackedgeMass; ///< Mass returned to each loop header.
    public BlockMass Mass;
    public ScaledNumberULLong Scale;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::LoopData::LoopData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 213,
     FQN="llvm::BlockFrequencyInfoImplBase::LoopData::LoopData", NM="_ZN4llvm26BlockFrequencyInfoImplBase8LoopDataC1EPS1_RKNS0_9BlockNodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase8LoopDataC1EPS1_RKNS0_9BlockNodeE")
    //</editor-fold>
    public LoopData(LoopData /*P*/ Parent, final /*const*/ BlockNode /*&*/ Header) {
      // : Parent(Parent), IsPackaged(false), NumHeaders(1), Exits(), Nodes(1, Header), BackedgeMass(1), Mass(), Scale() 
      //START JInit
      this.Parent = Parent;
      this.IsPackaged = false;
      this.NumHeaders = 1;
      this.Exits = new SmallVector<std.pairTypeType<BlockNode, BlockMass>>(4, new std.pairTypeType<BlockNode, BlockMass>());
      this.Nodes = new SmallVector<BlockNode>(JD$UInt_T$C$R.INSTANCE, 4, 1, Header, new BlockNode());
      this.BackedgeMass = new SmallVector<BlockMass>(JD$UInt_T$C$R.INSTANCE, 1, 1, new BlockMass());
      this.Mass = new BlockMass();
      this.Scale = new ScaledNumberULLong();
      //END JInit
    }

    /*template <class It1, class It2> TEMPLATE*/
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::LoopData::LoopData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 217,
     FQN="llvm::BlockFrequencyInfoImplBase::LoopData::LoopData", NM="Tpl__ZN4llvm26BlockFrequencyInfoImplBase8LoopDataC1EPS1_T_S3_T0_S4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=Tpl__ZN4llvm26BlockFrequencyInfoImplBase8LoopDataC1EPS1_T_S3_T0_S4_")
    //</editor-fold>
    public </*class*/ It1 extends type$iterator<?, ? extends BlockNode>, /*class*/ It2 extends type$iterator<?, ? extends BlockNode>> LoopData(LoopData /*P*/ Parent, It1 FirstHeader, It1 LastHeader, It2 FirstOther, 
        It2 LastOther) {
      // : Parent(Parent), IsPackaged(false), Nodes(FirstHeader, LastHeader) 
      //START JInit
      this.Parent = Parent;
      this.IsPackaged = false;
      this.Nodes = /*ParenListExpr*/new SmallVector<BlockNode>(4, FirstHeader, LastHeader, new BlockNode());
      //END JInit
      NumHeaders = Nodes.size();
      Nodes.insert(Nodes.end(), FirstOther, LastOther);
      BackedgeMass.resize(NumHeaders);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::LoopData::isHeader">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 224,
     FQN="llvm::BlockFrequencyInfoImplBase::LoopData::isHeader", NM="_ZNK4llvm26BlockFrequencyInfoImplBase8LoopData8isHeaderERKNS0_9BlockNodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase8LoopData8isHeaderERKNS0_9BlockNodeE")
    //</editor-fold>
    public boolean isHeader(final /*const*/ BlockNode /*&*/ Node) /*const*/ {
      if (isIrreducible()) {
        return std.binary_search(Nodes.begin$Const(), Nodes.begin$Const().$add(NumHeaders), 
            Node);
      }
      return Node.$eq(Nodes.$at$Const(0));
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::LoopData::getHeader">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 230,
     FQN="llvm::BlockFrequencyInfoImplBase::LoopData::getHeader", NM="_ZNK4llvm26BlockFrequencyInfoImplBase8LoopData9getHeaderEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase8LoopData9getHeaderEv")
    //</editor-fold>
    public BlockNode getHeader() /*const*/ {
      return new BlockNode(Nodes.$at$Const(0));
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::LoopData::isIrreducible">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 231,
     FQN="llvm::BlockFrequencyInfoImplBase::LoopData::isIrreducible", NM="_ZNK4llvm26BlockFrequencyInfoImplBase8LoopData13isIrreducibleEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase8LoopData13isIrreducibleEv")
    //</editor-fold>
    public boolean isIrreducible() /*const*/ {
      return $greater_uint(NumHeaders, 1);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::LoopData::getHeaderIndex">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 233,
     FQN="llvm::BlockFrequencyInfoImplBase::LoopData::getHeaderIndex", NM="_ZN4llvm26BlockFrequencyInfoImplBase8LoopData14getHeaderIndexERKNS0_9BlockNodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase8LoopData14getHeaderIndexERKNS0_9BlockNodeE")
    //</editor-fold>
    public int getHeaderIndex(final /*const*/ BlockNode /*&*/ B) {
      assert (isHeader(B)) : "this is only valid on loop header blocks";
      if (isIrreducible()) {
        return std.lower_bound(Nodes.begin(), Nodes.begin().$add(NumHeaders), B)
                .$sub(Nodes.begin());
      }
      return 0;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::LoopData::members_begin">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 241,
     FQN="llvm::BlockFrequencyInfoImplBase::LoopData::members_begin", NM="_ZNK4llvm26BlockFrequencyInfoImplBase8LoopData13members_beginEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase8LoopData13members_beginEv")
    //</editor-fold>
    public type$ptr</*const*/ BlockNode /*P*/ > members_begin() /*const*/ {
      return Nodes.begin$Const().$add(NumHeaders);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::LoopData::members_end">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 244,
     FQN="llvm::BlockFrequencyInfoImplBase::LoopData::members_end", NM="_ZNK4llvm26BlockFrequencyInfoImplBase8LoopData11members_endEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase8LoopData11members_endEv")
    //</editor-fold>
    public type$ptr</*const*/ BlockNode /*P*/ > members_end() /*const*/ {
      return Nodes.end$Const();
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::LoopData::members">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 245,
     FQN="llvm::BlockFrequencyInfoImplBase::LoopData::members", NM="_ZNK4llvm26BlockFrequencyInfoImplBase8LoopData7membersEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase8LoopData7membersEv")
    //</editor-fold>
    public iterator_range</*const*/ BlockNode> members() /*const*/ {
      return make_range(members_begin(), members_end());
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::LoopData::~LoopData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 200,
     FQN="llvm::BlockFrequencyInfoImplBase::LoopData::~LoopData", NM="_ZN4llvm26BlockFrequencyInfoImplBase8LoopDataD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase8LoopDataD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      BackedgeMass.$destroy();
      Nodes.$destroy();
      Exits.$destroy();
      //END JDestroy
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public LoopData() { }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Parent=" + Parent // NOI18N
                + ", IsPackaged=" + IsPackaged // NOI18N
                + ", NumHeaders=" + NumHeaders // NOI18N
                + ", Exits=" + Exits // NOI18N
                + ", Nodes=" + Nodes // NOI18N
                + ", BackedgeMass=" + BackedgeMass // NOI18N
                + ", Mass=" + Mass // NOI18N
                + ", Scale=" + Scale; // NOI18N
    }
  };
  
  /// \brief Index of loop information.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::WorkingData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 251,
   FQN="llvm::BlockFrequencyInfoImplBase::WorkingData", NM="_ZN4llvm26BlockFrequencyInfoImplBase11WorkingDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase11WorkingDataE")
  //</editor-fold>
  public static class/*struct*/ WorkingData {
    public BlockNode Node; ///< This node.
    public LoopData /*P*/ Loop; ///< The loop this block is inside.
    public BlockMass Mass; ///< Mass distribution from the entry block.
    
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::WorkingData::WorkingData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 256,
     FQN="llvm::BlockFrequencyInfoImplBase::WorkingData::WorkingData", NM="_ZN4llvm26BlockFrequencyInfoImplBase11WorkingDataC1ERKNS0_9BlockNodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase11WorkingDataC1ERKNS0_9BlockNodeE")
    //</editor-fold>
    public WorkingData(final /*const*/ BlockNode /*&*/ Node) {
      // : Node(Node), Loop(null), Mass() 
      //START JInit
      this.Node = new BlockNode(Node);
      this.Loop = null;
      this.Mass = new BlockMass();
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::WorkingData::isLoopHeader">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 258,
     FQN="llvm::BlockFrequencyInfoImplBase::WorkingData::isLoopHeader", NM="_ZNK4llvm26BlockFrequencyInfoImplBase11WorkingData12isLoopHeaderEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase11WorkingData12isLoopHeaderEv")
    //</editor-fold>
    public boolean isLoopHeader() /*const*/ {
      return (Loop != null) && Loop.isHeader(Node);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::WorkingData::isDoubleLoopHeader">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 259,
     FQN="llvm::BlockFrequencyInfoImplBase::WorkingData::isDoubleLoopHeader", NM="_ZNK4llvm26BlockFrequencyInfoImplBase11WorkingData18isDoubleLoopHeaderEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase11WorkingData18isDoubleLoopHeaderEv")
    //</editor-fold>
    public boolean isDoubleLoopHeader() /*const*/ {
      return isLoopHeader() && (Loop.Parent != null) && Loop.Parent.isIrreducible()
         && Loop.Parent.isHeader(Node);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::WorkingData::getContainingLoop">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 264,
     FQN="llvm::BlockFrequencyInfoImplBase::WorkingData::getContainingLoop", NM="_ZNK4llvm26BlockFrequencyInfoImplBase11WorkingData17getContainingLoopEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase11WorkingData17getContainingLoopEv")
    //</editor-fold>
    public LoopData /*P*/ getContainingLoop() /*const*/ {
      if (!isLoopHeader()) {
        return Loop;
      }
      if (!isDoubleLoopHeader()) {
        return Loop.Parent;
      }
      return Loop.Parent.Parent;
    }

    
    /// \brief Resolve a node to its representative.
    ///
    /// Get the node currently representing Node, which could be a containing
    /// loop.
    ///
    /// This function should only be called when distributing mass.  As long as
    /// there are no irreducible edges to Node, then it will have complexity
    /// O(1) in this context.
    ///
    /// In general, the complexity is O(L), where L is the number of loop
    /// headers Node has been packaged into.  Since this method is called in
    /// the context of distributing mass, L will be the number of loop headers
    /// an early exit edge jumps out of.
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::WorkingData::getResolvedNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 285,
     FQN="llvm::BlockFrequencyInfoImplBase::WorkingData::getResolvedNode", NM="_ZNK4llvm26BlockFrequencyInfoImplBase11WorkingData15getResolvedNodeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase11WorkingData15getResolvedNodeEv")
    //</editor-fold>
    public BlockNode getResolvedNode() /*const*/ {
      LoopData /*P*/ L = getPackagedLoop();
      return (L != null) ? L.getHeader() : new BlockNode(Node);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::WorkingData::getPackagedLoop">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 289,
     FQN="llvm::BlockFrequencyInfoImplBase::WorkingData::getPackagedLoop", NM="_ZNK4llvm26BlockFrequencyInfoImplBase11WorkingData15getPackagedLoopEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase11WorkingData15getPackagedLoopEv")
    //</editor-fold>
    public LoopData /*P*/ getPackagedLoop() /*const*/ {
      if (!(Loop != null) || !Loop.IsPackaged) {
        return null;
      }
      LoopData /*P*/ L = Loop;
      while ((L.Parent != null) && L.Parent.IsPackaged) {
        L = L.Parent;
      }
      return L;
    }

    
    /// \brief Get the appropriate mass for a node.
    ///
    /// Get appropriate mass for Node.  If Node is a loop-header (whose loop
    /// has been packaged), returns the mass of its pseudo-node.  If it's a
    /// node inside a packaged loop, it returns the loop's mass.
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::WorkingData::getMass">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 303,
     FQN="llvm::BlockFrequencyInfoImplBase::WorkingData::getMass", NM="_ZN4llvm26BlockFrequencyInfoImplBase11WorkingData7getMassEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase11WorkingData7getMassEv")
    //</editor-fold>
    public BlockMass /*&*/ getMass() {
      if (!isAPackage()) {
        return Mass;
      }
      if (!isADoublePackage()) {
        return Loop.Mass;
      }
      return Loop.Parent.Mass;
    }

    
    /// \brief Has ContainingLoop been packaged up?
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::WorkingData::isPackaged">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 312,
     FQN="llvm::BlockFrequencyInfoImplBase::WorkingData::isPackaged", NM="_ZNK4llvm26BlockFrequencyInfoImplBase11WorkingData10isPackagedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase11WorkingData10isPackagedEv")
    //</editor-fold>
    public boolean isPackaged() /*const*/ {
      return getResolvedNode().$noteq(Node);
    }

    /// \brief Has Loop been packaged up?
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::WorkingData::isAPackage">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 314,
     FQN="llvm::BlockFrequencyInfoImplBase::WorkingData::isAPackage", NM="_ZNK4llvm26BlockFrequencyInfoImplBase11WorkingData10isAPackageEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase11WorkingData10isAPackageEv")
    //</editor-fold>
    public boolean isAPackage() /*const*/ {
      return isLoopHeader() && Loop.IsPackaged;
    }

    /// \brief Has Loop been packaged up twice?
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::WorkingData::isADoublePackage">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 316,
     FQN="llvm::BlockFrequencyInfoImplBase::WorkingData::isADoublePackage", NM="_ZNK4llvm26BlockFrequencyInfoImplBase11WorkingData16isADoublePackageEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase11WorkingData16isADoublePackageEv")
    //</editor-fold>
    public boolean isADoublePackage() /*const*/ {
      return isDoubleLoopHeader() && Loop.Parent.IsPackaged;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::WorkingData::WorkingData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 251,
     FQN="llvm::BlockFrequencyInfoImplBase::WorkingData::WorkingData", NM="_ZN4llvm26BlockFrequencyInfoImplBase11WorkingDataC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase11WorkingDataC1EOS1_")
    //</editor-fold>
    public /*inline*/ WorkingData(JD$Move _dparam, final WorkingData /*&&*/$Prm0) {
      // : Node(static_cast<WorkingData &&>().Node), Loop(static_cast<WorkingData &&>().Loop), Mass(static_cast<WorkingData &&>().Mass) 
      //START JInit
      this.Node = new BlockNode(JD$Move.INSTANCE, $Prm0.Node);
      this.Loop = $Prm0.Loop;
      this.Mass = new BlockMass(JD$Move.INSTANCE, $Prm0.Mass);
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public WorkingData() {}

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Node=" + Node // NOI18N
                + ", Loop=" + Loop // NOI18N
                + ", Mass=" + Mass; // NOI18N
    }
  };
  
  /// \brief Unscaled probability weight.
  ///
  /// Probability weight for an edge in the graph (including the
  /// successor/target node).
  ///
  /// All edges in the original function are 32-bit.  However, exit edges from
  /// loop packages are taken from 64-bit exit masses, so we need 64-bits of
  /// space in general.
  ///
  /// In addition to the raw weight amount, Weight stores the type of the edge
  /// in the current context (i.e., the context of the loop being processed).
  /// Is this a local edge within the loop, an exit from the loop, or a
  /// backedge to the loop header?
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::Weight">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 334,
   FQN="llvm::BlockFrequencyInfoImplBase::Weight", NM="_ZN4llvm26BlockFrequencyInfoImplBase6WeightE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase6WeightE")
  //</editor-fold>
  public static class/*struct*/ Weight {
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::Weight::DistType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 335,
     FQN="llvm::BlockFrequencyInfoImplBase::Weight::DistType", NM="_ZN4llvm26BlockFrequencyInfoImplBase6Weight8DistTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase6Weight8DistTypeE")
    //</editor-fold>
    public enum DistType implements Native.NativeUIntEnum {
      Local(0),
      Exit(Local.getValue() + 1),
      Backedge(Exit.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static DistType valueOf(int val) {
        DistType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final DistType[] VALUES;
        private static final DistType[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (DistType kind : DistType.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new DistType[min < 0 ? (1-min) : 0];
          VALUES = new DistType[max >= 0 ? (1+max) : 0];
          for (DistType kind : DistType.values()) {
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

      private final /*uint*/int value;
      private DistType(int val) { this.value = (/*uint*/int)val;}
      @Override public final /*uint*/int getValue() { return value;}
      //</editor-fold>
    };
    public DistType Type;
    public BlockNode TargetNode;
    public long/*uint64_t*/ Amount;
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::Weight::Weight">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 339,
     FQN="llvm::BlockFrequencyInfoImplBase::Weight::Weight", NM="_ZN4llvm26BlockFrequencyInfoImplBase6WeightC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase6WeightC1Ev")
    //</editor-fold>
    public Weight() {
      // : Type(Local), TargetNode(), Amount(0) 
      //START JInit
      this.Type = DistType.Local;
      this.TargetNode = new BlockNode();
      this.Amount = $int2ulong(0);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::Weight::Weight">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 340,
     FQN="llvm::BlockFrequencyInfoImplBase::Weight::Weight", NM="_ZN4llvm26BlockFrequencyInfoImplBase6WeightC1ENS1_8DistTypeENS0_9BlockNodeEy",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase6WeightC1ENS1_8DistTypeENS0_9BlockNodeEy")
    //</editor-fold>
    public Weight(DistType Type, BlockNode TargetNode, long/*uint64_t*/ Amount) {
      // : Type(Type), TargetNode(TargetNode), Amount(Amount) 
      //START JInit
      this.Type = Type;
      this.TargetNode = new BlockNode(TargetNode);
      this.Amount = Amount;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::Weight::Weight">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 334,
     FQN="llvm::BlockFrequencyInfoImplBase::Weight::Weight", NM="_ZN4llvm26BlockFrequencyInfoImplBase6WeightC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase6WeightC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Weight(final /*const*/ Weight /*&*/ $Prm0) {
      // : Type(.Type), TargetNode(.TargetNode), Amount(.Amount) 
      //START JInit
      this.Type = $Prm0.Type;
      this.TargetNode = new BlockNode($Prm0.TargetNode);
      this.Amount = $Prm0.Amount;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::Weight::Weight">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 334,
     FQN="llvm::BlockFrequencyInfoImplBase::Weight::Weight", NM="_ZN4llvm26BlockFrequencyInfoImplBase6WeightC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase6WeightC1EOS1_")
    //</editor-fold>
    public /*inline*/ Weight(JD$Move _dparam, final Weight /*&&*/$Prm0) {
      // : Type(static_cast<Weight &&>().Type), TargetNode(static_cast<Weight &&>().TargetNode), Amount(static_cast<Weight &&>().Amount) 
      //START JInit
      this.Type = $Prm0.Type;
      this.TargetNode = new BlockNode(JD$Move.INSTANCE, $Prm0.TargetNode);
      this.Amount = $Prm0.Amount;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::Weight::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 334,
     FQN="llvm::BlockFrequencyInfoImplBase::Weight::operator=", NM="_ZN4llvm26BlockFrequencyInfoImplBase6WeightaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase6WeightaSERKS1_")
    //</editor-fold>
    public /*inline*/ Weight /*&*/ $assign(final /*const*/ Weight /*&*/ $Prm0) {
      this.Type = $Prm0.Type;
      this.TargetNode.$assign($Prm0.TargetNode);
      this.Amount = $Prm0.Amount;
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::Weight::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 334,
     FQN="llvm::BlockFrequencyInfoImplBase::Weight::operator=", NM="_ZN4llvm26BlockFrequencyInfoImplBase6WeightaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase6WeightaSEOS1_")
    //</editor-fold>
    public /*inline*/ Weight /*&*/ $assignMove(final Weight /*&&*/$Prm0) {
      this.Type = $Prm0.Type;
      this.TargetNode.$assignMove($Prm0.TargetNode);
      this.Amount = $Prm0.Amount;
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "Type=" + Type // NOI18N
                + ", TargetNode=" + TargetNode // NOI18N
                + ", Amount=" + Amount; // NOI18N
    }
  };
  
  /// \brief Distribution of unscaled probability weight.
  ///
  /// Distribution of unscaled probability weight to a set of successors.
  ///
  /// This class collates the successor edge weights for later processing.
  ///
  /// \a DidOverflow indicates whether \a Total did overflow while adding to
  /// the distribution.  It should never overflow twice.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::Distribution">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 352,
   FQN="llvm::BlockFrequencyInfoImplBase::Distribution", NM="_ZN4llvm26BlockFrequencyInfoImplBase12DistributionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase12DistributionE")
  //</editor-fold>
  public static class/*struct*/ Distribution implements Destructors.ClassWithDestructor {
    // JAVA: typedef SmallVector<Weight, 4> WeightList
//    public final class WeightList extends SmallVector<Weight>{ };
    public SmallVector<Weight> Weights; ///< Individual successor weights.
    public long/*uint64_t*/ Total; ///< Sum of all weights.
    public boolean DidOverflow; ///< Whether \a Total did overflow.
    
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::Distribution::Distribution">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 358,
     FQN="llvm::BlockFrequencyInfoImplBase::Distribution::Distribution", NM="_ZN4llvm26BlockFrequencyInfoImplBase12DistributionC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase12DistributionC1Ev")
    //</editor-fold>
    public Distribution() {
      // : Weights(), Total(0), DidOverflow(false) 
      //START JInit
      this.Weights = new SmallVector<Weight>(4, new Weight());
      this.Total = $int2ulong(0);
      this.DidOverflow = false;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::Distribution::addLocal">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 359,
     FQN="llvm::BlockFrequencyInfoImplBase::Distribution::addLocal", NM="_ZN4llvm26BlockFrequencyInfoImplBase12Distribution8addLocalERKNS0_9BlockNodeEy",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase12Distribution8addLocalERKNS0_9BlockNodeEy")
    //</editor-fold>
    public void addLocal(final /*const*/ BlockNode /*&*/ Node, long/*uint64_t*/ Amount) {
      add(Node, Amount, Weight.DistType.Local);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::Distribution::addExit">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 362,
     FQN="llvm::BlockFrequencyInfoImplBase::Distribution::addExit", NM="_ZN4llvm26BlockFrequencyInfoImplBase12Distribution7addExitERKNS0_9BlockNodeEy",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase12Distribution7addExitERKNS0_9BlockNodeEy")
    //</editor-fold>
    public void addExit(final /*const*/ BlockNode /*&*/ Node, long/*uint64_t*/ Amount) {
      add(Node, Amount, Weight.DistType.Exit);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::Distribution::addBackedge">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 365,
     FQN="llvm::BlockFrequencyInfoImplBase::Distribution::addBackedge", NM="_ZN4llvm26BlockFrequencyInfoImplBase12Distribution11addBackedgeERKNS0_9BlockNodeEy",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase12Distribution11addBackedgeERKNS0_9BlockNodeEy")
    //</editor-fold>
    public void addBackedge(final /*const*/ BlockNode /*&*/ Node, long/*uint64_t*/ Amount) {
      add(Node, Amount, Weight.DistType.Backedge);
    }

    
    /// \brief Normalize the distribution.
    ///
    /// Combines multiple edges to the same \a Weight::TargetNode and scales
    /// down so that \a Total fits into 32-bits.
    ///
    /// This is linear in the size of \a Weights.  For the vast majority of
    /// cases, adjacent edge weights are combined by sorting WeightList and
    /// combining adjacent weights.  However, for very large edge lists an
    /// auxiliary hash table is used.
    
    /// \brief Normalize the distribution.
    ///
    /// Combines multiple edges to the same \a Weight::TargetNode and scales
    /// down so that \a Total fits into 32-bits.
    ///
    /// This is linear in the size of \a Weights.  For the vast majority of
    /// cases, adjacent edge weights are combined by sorting WeightList and
    /// combining adjacent weights.  However, for very large edge lists an
    /// auxiliary hash table is used.
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::Distribution::normalize">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 193,
     FQN="llvm::BlockFrequencyInfoImplBase::Distribution::normalize", NM="_ZN4llvm26BlockFrequencyInfoImplBase12Distribution9normalizeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase12Distribution9normalizeEv")
    //</editor-fold>
    public void normalize() {
      // Early exit for termination nodes.
      if (Weights.empty()) {
        return;
      }
      
      // Only bother if there are multiple successors.
      if ($greater_uint(Weights.size(), 1)) {
        combineWeights(Weights);
      }
      
      // Early exit when combined into a single successor.
      if (Weights.size() == 1) {
        Total = $int2ulong(1);
        Weights.front().Amount = $int2ulong(1);
        return;
      }
      
      // Determine how much to shift right so that the total fits into 32-bits.
      //
      // If we shift at all, shift by 1 extra.  Otherwise, the lower limit of 1
      // for each weight can cause a 32-bit overflow.
      int Shift = 0;
      if (DidOverflow) {
        Shift = 33;
      } else if ($greater_ulong_uint(Total, UINT32_MAX)) {
        Shift = 33 - countLeadingZeros/*$ULLong*/(Total);
      }
      
      // Early exit if nothing needs to be scaled.
      if (!(Shift != 0)) {
        // If we didn't overflow then combineWeights() shouldn't have changed the
        // sum of the weights, but let's double-check.
        //assert (Total == std.accumulate(Weights.begin(), Weights.end(), 0L/*ULL*/, /*[]*/ (long/*uint64_t*/ Sum, final /*const*/ Weight /*&*/ W) -> {
        //      return Sum + W.Amount;
        //    })) : "Expected total to be correct";
        long Sum = 0;
        for (Weight W : Weights) {
          Sum += W.Amount;
        }
        assert Total == Sum : "Expected total to be correct";
        return;
      }
      
      // Recompute the total through accumulation (rather than shifting it) so that
      // it's accurate after shifting and any changes combineWeights() made above.
      Total = $int2ulong(0);
      
      // Sum the weights to each node and shift right if necessary.
      for (final Weight /*&*/ W : Weights) {
        // Scale down below UINT32_MAX.  Since Shift is larger than necessary, we
        // can round here without concern about overflow.
        assert (W.TargetNode.isValid());
        W.Amount = std.max(1L/*ULL*/, shiftRightAndRound(W.Amount, Shift));
        assert ($lesseq_ulong_uint(W.Amount, 0xFFFFFFFF));//(4294967295/*U*/)));
        
        // Update the total.
        Total += W.Amount;
      }
      assert ($lesseq_ulong_uint(Total, 0xFFFFFFFF));//(4294967295/*U*/)));
    }


  /*private:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::Distribution::add">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 103,
     FQN="llvm::BlockFrequencyInfoImplBase::Distribution::add", NM="_ZN4llvm26BlockFrequencyInfoImplBase12Distribution3addERKNS0_9BlockNodeEyNS0_6Weight8DistTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase12Distribution3addERKNS0_9BlockNodeEyNS0_6Weight8DistTypeE")
    //</editor-fold>
    private void add(final /*const*/ BlockNode /*&*/ Node, long/*uint64_t*/ Amount, 
       Weight.DistType Type) {
      assert ((Amount != 0)) : "invalid weight of 0";
      long/*uint64_t*/ NewTotal = Total + Amount;
      
      // Check for overflow.  It should be impossible to overflow twice.
      boolean IsOverflow = $less_ulong(NewTotal, Total);
      assert (!(DidOverflow && IsOverflow)) : "unexpected repeated overflow";
      DidOverflow |= IsOverflow;
      
      // Update the total.
      Total = NewTotal;
      
      // Save the weight.
      Weights.push_back(new Weight(Type, new BlockNode(Node), Amount));
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::Distribution::~Distribution">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 352,
     FQN="llvm::BlockFrequencyInfoImplBase::Distribution::~Distribution", NM="_ZN4llvm26BlockFrequencyInfoImplBase12DistributionD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase12DistributionD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Weights.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Weights=" + Weights // NOI18N
                + ", Total=" + Total // NOI18N
                + ", DidOverflow=" + DidOverflow; // NOI18N
    }
  };
  
  /// \brief Data about each block.  This is used downstream.
  public std.vector<FrequencyData> Freqs;
  
  /// \brief Loop data: see initializeLoops().
  public std.vector<WorkingData> Working;
  
  /// \brief Indexed information about loops.
  public std.list<LoopData> Loops;
  
  /// \brief Add all edges out of a packaged loop to the distribution.
  ///
  /// Adds all edges from LocalLoopHead to Dist.  Calls addToDist() to add each
  /// successor edge.
  ///
  /// \return \c true unless there's an irreducible backedge.
  
  /// \brief Add all edges out of a packaged loop to the distribution.
  ///
  /// Adds all edges from LocalLoopHead to Dist.  Calls addToDist() to add each
  /// successor edge.
  ///
  /// \return \c true unless there's an irreducible backedge.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::addLoopSuccessorsToDist">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 328,
   FQN="llvm::BlockFrequencyInfoImplBase::addLoopSuccessorsToDist", NM="_ZN4llvm26BlockFrequencyInfoImplBase23addLoopSuccessorsToDistEPKNS0_8LoopDataERS1_RNS0_12DistributionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase23addLoopSuccessorsToDistEPKNS0_8LoopDataERS1_RNS0_12DistributionE")
  //</editor-fold>
  public boolean addLoopSuccessorsToDist(/*const*/ LoopData /*P*/ OuterLoop, final LoopData /*&*/ Loop, final Distribution /*&*/ Dist) {
    // Copy the exit map into Dist.
    for (final /*const*/std.pairTypeType<BlockNode, BlockMass> /*&*/ I : Loop.Exits)  {
      if (!addToDist(Dist, OuterLoop, Loop.getHeader(), I.first, 
          I.second.getMass())) {
        // Irreducible backedge.
        return false;
      }
    }
    
    return true;
  }


  
  /// \brief Add an edge to the distribution.
  ///
  /// Adds an edge to Succ to Dist.  If \c LoopHead.isValid(), then whether the
  /// edge is local/exit/backedge is in the context of LoopHead.  Otherwise,
  /// every edge should be a local edge (since all the loops are packaged up).
  ///
  /// \return \c true unless aborted due to an irreducible backedge.
  
  /// \brief Add an edge to the distribution.
  ///
  /// Adds an edge to Succ to Dist.  If \c LoopHead.isValid(), then whether the
  /// edge is local/exit/backedge is in the context of LoopHead.  Otherwise,
  /// every edge should be a local edge (since all the loops are packaged up).
  ///
  /// \return \c true unless aborted due to an irreducible backedge.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::addToDist">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 266,
   FQN="llvm::BlockFrequencyInfoImplBase::addToDist", NM="_ZN4llvm26BlockFrequencyInfoImplBase9addToDistERNS0_12DistributionEPKNS0_8LoopDataERKNS0_9BlockNodeES8_y",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase9addToDistERNS0_12DistributionEPKNS0_8LoopDataERKNS0_9BlockNodeES8_y")
  //</editor-fold>
  public boolean addToDist(final Distribution /*&*/ Dist, 
           /*const*/ LoopData /*P*/ OuterLoop, 
           final /*const*/ BlockNode /*&*/ Pred, 
           final /*const*/ BlockNode /*&*/ Succ, 
           long/*uint64_t*/ Weight) {
    if (!(Weight != 0)) {
      Weight = $int2ulong(1);
    }
    
    BlockNode2Bool isLoopHeader = /*[&OuterLoop]*/ (final /*const*/ BlockNode /*&*/ Node) -> {
          return (OuterLoop != null) && OuterLoop.isHeader(Node);
        };
    
    BlockNode Resolved = Working.$at(Succ.Index).getResolvedNode();
    long/*uint64_t*/ Weight_final  = Weight;
    CharPrt2Void debugSuccessor = /*[&, &Weight, &isLoopHeader, &Resolved, this, &Succ]*/ (/*const*/char$ptr/*char P*/ Type) -> {
          dbgs().$out(/*KEEP_STR*/"  =>").$out(
              /*KEEP_STR*/" ["
          ).$out(Type).$out(/*KEEP_STR*/"] weight = ").$out_ullong(Weight_final);
          if (!isLoopHeader.$call(Resolved)) {
            dbgs().$out(/*KEEP_STR*/", succ = ").$out(getBlockName(Succ));
          }
          if (Resolved.$noteq(Succ)) {
            dbgs().$out(/*KEEP_STR*/", resolved = ").$out(getBlockName(Resolved));
          }
          dbgs().$out(/*KEEP_STR*/$LF);
        };
    ///*J:(void)*/debugSuccessor;
    if (isLoopHeader.$call(Resolved)) {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
          debugSuccessor.$call($("backedge"));
        }
      } while (false);
      Dist.addBackedge(Resolved, Weight);
      return true;
    }
    if (Working.$at(Resolved.Index).getContainingLoop() != OuterLoop) {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
          debugSuccessor.$call($("  exit  "));
        }
      } while (false);
      Dist.addExit(Resolved, Weight);
      return true;
    }
    if (Resolved.$less(Pred)) {
      if (!isLoopHeader.$call(Pred)) {
        // If OuterLoop is an irreducible loop, we can't actually handle this.
        assert ((!(OuterLoop != null) || !OuterLoop.isIrreducible())) : "unhandled irreducible control flow";
        
        // Irreducible backedge.  Abort.
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
            debugSuccessor.$call($("abort!!!"));
          }
        } while (false);
        return false;
      }
      
      // If "Pred" is a loop header, then this isn't really a backedge; rather,
      // OuterLoop must be irreducible.  These false backedges can come only from
      // secondary loop headers.
      assert ((OuterLoop != null) && OuterLoop.isIrreducible() && !isLoopHeader.$call(Resolved)) : "unhandled irreducible control flow";
    }
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
        debugSuccessor.$call($(" local  "));
      }
    } while (false);
    Dist.addLocal(Resolved, Weight);
    return true;
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::getLoopPackage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 412,
   FQN="llvm::BlockFrequencyInfoImplBase::getLoopPackage", NM="_ZN4llvm26BlockFrequencyInfoImplBase14getLoopPackageERKNS0_9BlockNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase14getLoopPackageERKNS0_9BlockNodeE")
  //</editor-fold>
  public LoopData /*&*/ getLoopPackage(final /*const*/ BlockNode /*&*/ Head) {
    assert ($less_uint(Head.Index, Working.size()));
    assert (Working.$at(Head.Index).isLoopHeader());
    return $Deref(Working.$at(Head.Index).Loop);
  }

  
  /// \brief Analyze irreducible SCCs.
  ///
  /// Separate irreducible SCCs from \c G, which is an explict graph of \c
  /// OuterLoop (or the top-level function, if \c OuterLoop is \c nullptr).
  /// Insert them into \a Loops before \c Insert.
  ///
  /// \return the \c LoopData nodes representing the irreducible SCCs.
  
  /// \brief Analyze irreducible SCCs.
  ///
  /// Separate irreducible SCCs from \c G, which is an explict graph of \c
  /// OuterLoop (or the top-level function, if \c OuterLoop is \c nullptr).
  /// Insert them into \a Loops before \c Insert.
  ///
  /// \return the \c LoopData nodes representing the irreducible SCCs.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::analyzeIrreducible">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 730,
   FQN="llvm::BlockFrequencyInfoImplBase::analyzeIrreducible", NM="_ZN4llvm26BlockFrequencyInfoImplBase18analyzeIrreducibleERKNS_10bfi_detail16IrreducibleGraphEPNS0_8LoopDataESt14_List_iteratorIS5_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase18analyzeIrreducibleERKNS_10bfi_detail16IrreducibleGraphEPNS0_8LoopDataESt14_List_iteratorIS5_E")
  //</editor-fold>
  public iterator_range<LoopData /*&*/ > analyzeIrreducible(final /*const*/ IrreducibleGraph /*&*/ G, LoopData /*P*/ OuterLoop, 
                    std.list.iterator<LoopData> Insert) {
    assert ((OuterLoop == null) == (Insert.$eq(Loops.begin())));
    std.list.iterator<LoopData> Prev = (OuterLoop != null) ? std.prev(new std.list.iterator<LoopData>(Insert)) : Loops.end();
    scc_iterator<IrreducibleGraph, IrreducibleGraph.IrrNode, IrreducibleGraph.IrrNode> I = null;
    try {
      for (I = scc_iterator.scc_begin(new GraphTraitsIrreducibleGraph(), G); !I.isAtEnd(); I.$preInc()) {
        if ($less_uint(I.$arrow().size(), 2)) {
          continue;
        }
        
        // Translate the SCC into RPO.
        createIrreducibleLoop(/*Deref*/this, G, OuterLoop, new std.list.iterator<LoopData>(Insert), I.$star());
      }
    } finally {
      if (I != null) { I.$destroy(); }
    }
    if ((OuterLoop != null)) {
      return make_range(std.next(new std.list.iterator<LoopData>(Prev)), new std.list.iterator<LoopData>(Insert));
    }
    return make_range(Loops.begin(), new std.list.iterator<LoopData>(Insert));
  }


  
  /// \brief Update a loop after packaging irreducible SCCs inside of it.
  ///
  /// Update \c OuterLoop.  Before finding irreducible control flow, it was
  /// partway through \a computeMassInLoop(), so \a LoopData::Exits and \a
  /// LoopData::BackedgeMass need to be reset.  Also, nodes that were packaged
  /// up need to be removed from \a OuterLoop::Nodes.
  
  /// \brief Update a loop after packaging irreducible SCCs inside of it.
  ///
  /// Update \c OuterLoop.  Before finding irreducible control flow, it was
  /// partway through \a computeMassInLoop(), so \a LoopData::Exits and \a
  /// LoopData::BackedgeMass need to be reset.  Also, nodes that were packaged
  /// up need to be removed from \a OuterLoop::Nodes.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::updateLoopWithIrreducible">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 750,
   FQN="llvm::BlockFrequencyInfoImplBase::updateLoopWithIrreducible", NM="_ZN4llvm26BlockFrequencyInfoImplBase25updateLoopWithIrreducibleERNS0_8LoopDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase25updateLoopWithIrreducibleERNS0_8LoopDataE")
  //</editor-fold>
  public void updateLoopWithIrreducible(final LoopData /*&*/ OuterLoop) {
    OuterLoop.Exits.clear();
    for (final BlockMass /*&*/ Mass : OuterLoop.BackedgeMass)  {
      Mass.$assignMove(BlockMass.getEmpty());
    }
    type$ptr<BlockNode /*P*/ > O = $tryClone(OuterLoop.Nodes.begin().$add(1));
    for (type$ptr<BlockNode /*P*/ > /*P*/ I = O, /*P*/ E = $tryClone(OuterLoop.Nodes.end()); $noteq_ptr(I, E); I.$preInc())  {
      if (!Working.$at(I.$star().Index).isPackaged()) {
        $Deref(O.$postInc()).$assign($Deref(I));
      }
    }
    OuterLoop.Nodes.erase(O, OuterLoop.Nodes.end());
  }


  
  /// \brief Distribute mass according to a distribution.
  ///
  /// Distributes the mass in Source according to Dist.  If LoopHead.isValid(),
  /// backedges and exits are stored in its entry in Loops.
  ///
  /// Mass is distributed in parallel from two copies of the source mass.
  
  /// \brief Distribute mass according to a distribution.
  ///
  /// Distributes the mass in Source according to Dist.  If LoopHead.isValid(),
  /// backedges and exits are stored in its entry in Loops.
  ///
  /// Mass is distributed in parallel from two copies of the source mass.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::distributeMass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 400,
   FQN="llvm::BlockFrequencyInfoImplBase::distributeMass", NM="_ZN4llvm26BlockFrequencyInfoImplBase14distributeMassERKNS0_9BlockNodeEPNS0_8LoopDataERNS0_12DistributionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase14distributeMassERKNS0_9BlockNodeEPNS0_8LoopDataERNS0_12DistributionE")
  //</editor-fold>
  public void distributeMass(final /*const*/ BlockNode /*&*/ Source, 
                LoopData /*P*/ OuterLoop, 
                final Distribution /*&*/ Dist) {
    BlockMass Mass = new BlockMass(Working.$at(Source.Index).getMass());
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
        $out_raw_ostream_BlockMass(dbgs().$out(/*KEEP_STR*/"  => mass:  "), /*NO_COPY*/Mass).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    
    // Distribute mass to successors as laid out in Dist.
    DitheringDistributer D/*J*/= new DitheringDistributer(Dist, Mass);
    
    for (final /*const*/ Weight /*&*/ W : Dist.Weights) {
      // Check for a local edge (non-backedge and non-exit).
      BlockMass Taken = D.takeMass($ulong2uint(W.Amount));
      if (W.Type == Weight.DistType.Local) {
        Working.$at(W.TargetNode.Index).getMass().$addassign(/*NO_COPY*/Taken);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
            debugAssign(/*Deref*/this, D, W.TargetNode, Taken, (/*const*/char$ptr/*char P*/ )null);
          }
        } while (false);
        continue;
      }
      
      // Backedges and exits only make sense if we're processing a loop.
      assert ((OuterLoop != null)) : "backedge or exit outside of loop";
      
      // Check for a backedge.
      if (W.Type == Weight.DistType.Backedge) {
        OuterLoop.BackedgeMass.$at(OuterLoop.getHeaderIndex(W.TargetNode)).$addassign(/*NO_COPY*/Taken);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
            debugAssign(/*Deref*/this, D, W.TargetNode, Taken, $("back"));
          }
        } while (false);
        continue;
      }
      
      // This must be an exit.
      assert (W.Type == Weight.DistType.Exit);
      OuterLoop.Exits.push_back(std.make_pair($Clone(W.TargetNode), $Clone(Taken)));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
          debugAssign(/*Deref*/this, D, W.TargetNode, Taken, $("exit"));
        }
      } while (false);
    }
  }


  
  /// \brief Compute the loop scale for a loop.
  
  /// \brief Compute the loop scale for a loop.
  
  /// \brief Compute the loop scale for a loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::computeLoopScale">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 341,
   FQN="llvm::BlockFrequencyInfoImplBase::computeLoopScale", NM="_ZN4llvm26BlockFrequencyInfoImplBase16computeLoopScaleERNS0_8LoopDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase16computeLoopScaleERNS0_8LoopDataE")
  //</editor-fold>
  public void computeLoopScale(final LoopData /*&*/ Loop) {
    // Compute loop scale.
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
        dbgs().$out(/*KEEP_STR*/"compute-loop-scale: ").$out(getLoopName(Loop)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    
    // Infinite loops need special handling. If we give the back edge an infinite
    // mass, they may saturate all the other scales in the function down to 1,
    // making all the other region temperatures look exactly the same. Choose an
    // arbitrary scale to avoid these issues.
    //
    // FIXME: An alternate way would be to select a symbolic scale which is later
    // replaced to be the maximum of all computed scales plus 1. This would
    // appropriately describe the loop as having a large scale, without skewing
    // the final frequency computation.
    /*const*/ ScaledNumberULLong InfiniteLoopScale/*J*/= new ScaledNumberULLong($int2ullong(1), $int2short(12));
    
    // LoopScale == 1 / ExitMass
    // ExitMass == HeadMass - BackedgeMass
    BlockMass TotalBackedgeMass/*J*/= new BlockMass();
    for (final BlockMass /*&*/ Mass : Loop.BackedgeMass)  {
      TotalBackedgeMass.$addassign(/*NO_COPY*/Mass);
    }
    BlockMass ExitMass = $sub_BlockMass(BlockMass.getFull(), /*NO_COPY*/TotalBackedgeMass);
    
    // Block scale stores the inverse of the scale. If this is an infinite loop,
    // its exit mass will be zero. In this case, use an arbitrary scale for the
    // loop scale.
    Loop.Scale.$assign(
        ExitMass.isEmpty() ? new ScaledNumberULLong(InfiniteLoopScale) : ExitMass.toScaled().inverse()
    );
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
        AdtsupportLlvmGlobals.$out_raw_ostream_ScaledNumber$DigitsT$C($out_raw_ostream_BlockMass($out_raw_ostream_BlockMass($out_raw_ostream_BlockMass(dbgs().$out(/*KEEP_STR*/" - exit-mass = "), /*NO_COPY*/ExitMass).$out(/*KEEP_STR*/" ("), BlockMass.getFull()).$out(/*KEEP_STR*/" - "), /*NO_COPY*/TotalBackedgeMass).$out(/*KEEP_STR*/")\n").$out(/*KEEP_STR*/" - scale = "), Loop.Scale).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
  }


  
  /// Adjust the mass of all headers in an irreducible loop.
  ///
  /// Initially, irreducible loops are assumed to distribute their mass
  /// equally among its headers. This can lead to wrong frequency estimates
  /// since some headers may be executed more frequently than others.
  ///
  /// This adjusts header mass distribution so it matches the weights of
  /// the backedges going into each of the loop headers.
  
  /// Adjust the mass of all headers in an irreducible loop.
  ///
  /// Initially, irreducible loops are assumed to distribute their mass
  /// equally among its headers. This can lead to wrong frequency estimates
  /// since some headers may be executed more frequently than others.
  ///
  /// This adjusts header mass distribution so it matches the weights of
  /// the backedges going into each of the loop headers.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::adjustLoopHeaderMass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 762,
   FQN="llvm::BlockFrequencyInfoImplBase::adjustLoopHeaderMass", NM="_ZN4llvm26BlockFrequencyInfoImplBase20adjustLoopHeaderMassERNS0_8LoopDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase20adjustLoopHeaderMassERNS0_8LoopDataE")
  //</editor-fold>
  public void adjustLoopHeaderMass(final LoopData /*&*/ Loop) {
    Distribution Dist = null;
    try {
      assert (Loop.isIrreducible()) : "this only makes sense on irreducible loops";
      
      // Since the loop has more than one header block, the mass flowing back into
      // each header will be different. Adjust the mass in each header loop to
      // reflect the masses flowing through back edges.
      //
      // To do this, we distribute the initial mass using the backedge masses
      // as weights for the distribution.
      BlockMass LoopMass = BlockMass.getFull();
      Dist/*J*/= new Distribution();
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
          dbgs().$out(/*KEEP_STR*/"adjust-loop-header-mass:\n");
        }
      } while (false);
      for (/*uint32_t*/int H = 0; $less_uint(H, Loop.NumHeaders); ++H) {
        final BlockNode /*&*/ HeaderNode = Loop.Nodes.$at(H);
        final BlockMass /*&*/ BackedgeMass = Loop.BackedgeMass.$at(Loop.getHeaderIndex(HeaderNode));
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
            $out_raw_ostream_BlockMass(dbgs().$out(/*KEEP_STR*/" - Add back edge mass for node ").$out(getBlockName(HeaderNode)).$out(/*KEEP_STR*/": "), /*NO_COPY*/BackedgeMass).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        if ($greater_ulong_ullong(BackedgeMass.getMass(), $int2ullong(0))) {
          Dist.addLocal(HeaderNode, BackedgeMass.getMass());
        } else {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
              dbgs().$out(/*KEEP_STR*/"   Nothing added. Back edge mass is zero\n");
            }
          } while (false);
        }
      }
      
      DitheringDistributer D/*J*/= new DitheringDistributer(Dist, LoopMass);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
          $out_raw_ostream_BlockMass(dbgs().$out(/*KEEP_STR*/" Distribute loop mass "), /*NO_COPY*/LoopMass).$out(/*KEEP_STR*/" to headers using above weights\n");
        }
      } while (false);
      for (final /*const*/ Weight /*&*/ W : Dist.Weights) {
        BlockMass Taken = D.takeMass($ulong2uint(W.Amount));
        assert (W.Type == Weight.DistType.Local) : "all weights should be local";
        Working.$at(W.TargetNode.Index).getMass().$assign(Taken);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
            debugAssign(/*Deref*/this, D, W.TargetNode, Taken, (/*const*/char$ptr/*char P*/ )null);
          }
        } while (false);
      }
    } finally {
      if (Dist != null) { Dist.$destroy(); }
    }
  }


  
  /// \brief Package up a loop.
  
  /// \brief Package up a loop.
  
  /// \brief Package up a loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::packageLoop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 375,
   FQN="llvm::BlockFrequencyInfoImplBase::packageLoop", NM="_ZN4llvm26BlockFrequencyInfoImplBase11packageLoopERNS0_8LoopDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase11packageLoopERNS0_8LoopDataE")
  //</editor-fold>
  public void packageLoop(final LoopData /*&*/ Loop) {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
        dbgs().$out(/*KEEP_STR*/"packaging-loop: ").$out(getLoopName(Loop)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    
    // Clear the subloop exits to prevent quadratic memory usage.
    for (final /*const*/ BlockNode /*&*/ M : Loop.Nodes) {
      {
        LoopData /*P*/ Loop$1 = Working.$at(M.Index).getPackagedLoop();
        if ((Loop$1 != null)) {
          Loop$1.Exits.clear();
        }
      }
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
          dbgs().$out(/*KEEP_STR*/" - node: ").$out(getBlockName(new BlockNode(M.Index))).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
    }
    Loop.IsPackaged = true;
  }


  
  /// \brief Unwrap loops.
  
  /// \brief Unwrap loops.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::unwrapLoops">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 496,
   FQN="llvm::BlockFrequencyInfoImplBase::unwrapLoops", NM="_ZN4llvm26BlockFrequencyInfoImplBase11unwrapLoopsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase11unwrapLoopsEv")
  //</editor-fold>
  public void unwrapLoops() {
    // Set initial frequencies from loop-local masses.
    for (/*size_t*/int Index = 0; $less_uint(Index, Working.size()); ++Index)  {
      Freqs.$at(Index).Scaled.$assignMove(Working.$at(Index).Mass.toScaled());
    }
    
    for (final LoopData /*&*/ Loop : Loops)  {
      unwrapLoop(/*Deref*/this, Loop);
    }
  }


  
  /// \brief Finalize frequency metrics.
  ///
  /// Calculates final frequencies and cleans up no-longer-needed data
  /// structures.
  
  /// \brief Finalize frequency metrics.
  ///
  /// Calculates final frequencies and cleans up no-longer-needed data
  /// structures.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::finalizeMetrics">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 505,
   FQN="llvm::BlockFrequencyInfoImplBase::finalizeMetrics", NM="_ZN4llvm26BlockFrequencyInfoImplBase15finalizeMetricsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase15finalizeMetricsEv")
  //</editor-fold>
  public void finalizeMetrics() {
    // Unwrap loop packages in reverse post-order, tracking min and max
    // frequencies.
    ScaledNumberULLong Min = ScaledNumberULLong.getLargest();
    ScaledNumberULLong Max = ScaledNumberULLong.getZero();
    for (/*size_t*/int Index = 0; $less_uint(Index, Working.size()); ++Index) {
      // Update min/max scale.
      Min.$assign(Min.$less(Freqs.$at(Index).Scaled) ? Min : Freqs.$at(Index).Scaled);
      Max.$assign(Max.$greater(Freqs.$at(Index).Scaled) ? Max : Freqs.$at(Index).Scaled);
    }
    
    // Convert to integers.
    convertFloatingToInteger(/*Deref*/this, Min, Max);
    
    // Clean up data structures.
    cleanup(/*Deref*/this);
    
    // Print out the final stats.
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"block-freq")) {
        dump();
      }
    } while (false);
  }


  
  /// \brief Clear all memory.
  
  /// \brief Clear all memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 249,
   FQN="llvm::BlockFrequencyInfoImplBase::clear", NM="_ZN4llvm26BlockFrequencyInfoImplBase5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase5clearEv")
  //</editor-fold>
  public void clear() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Swap with a default-constructed std::vector, since std::vector<>::clear()
      // does not actually clear heap storage.
      $c$.track(new std.vector<FrequencyData>(new FrequencyData())).swap(Freqs); $c$.clean();
      $c$.track(new std.vector<WorkingData>(new WorkingData())).swap(Working); $c$.clean();
      Loops.clear();
    } finally {
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::getBlockName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 562,
   FQN="llvm::BlockFrequencyInfoImplBase::getBlockName", NM="_ZNK4llvm26BlockFrequencyInfoImplBase12getBlockNameERKNS0_9BlockNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase12getBlockNameERKNS0_9BlockNodeE")
  //</editor-fold>
  public std.string getBlockName(final /*const*/ BlockNode /*&*/ Node) /*const*/ {
    return new std.string();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::getLoopName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 567,
   FQN="llvm::BlockFrequencyInfoImplBase::getLoopName", NM="_ZNK4llvm26BlockFrequencyInfoImplBase11getLoopNameERKNS0_8LoopDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase11getLoopNameERKNS0_8LoopDataE")
  //</editor-fold>
  public std.string getLoopName(final /*const*/ LoopData /*&*/ Loop) /*const*/ {
    return $add_string_T$C$P(getBlockName(Loop.getHeader()), (Loop.isIrreducible() ? $("**") : $STAR));
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 477,
   FQN="llvm::BlockFrequencyInfoImplBase::print", NM="_ZNK4llvm26BlockFrequencyInfoImplBase5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase5printERNS_11raw_ostreamE")
  //</editor-fold>
  public /*virtual*/ raw_ostream /*&*/ print(final raw_ostream /*&*/ OS) /*const*/ {
    return OS;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 478,
   FQN="llvm::BlockFrequencyInfoImplBase::dump", NM="_ZNK4llvm26BlockFrequencyInfoImplBase4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase4dumpEv")
  //</editor-fold>
  public void dump() /*const*/ {
    print(dbgs());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::getFloatingBlockFreq">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 548,
   FQN="llvm::BlockFrequencyInfoImplBase::getFloatingBlockFreq", NM="_ZNK4llvm26BlockFrequencyInfoImplBase20getFloatingBlockFreqERKNS0_9BlockNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase20getFloatingBlockFreqERKNS0_9BlockNodeE")
  //</editor-fold>
  public ScaledNumberULLong getFloatingBlockFreq(final /*const*/ BlockNode /*&*/ Node) /*const*/ {
    if (!Node.isValid()) {
      return ScaledNumberULLong.getZero();
    }
    return new ScaledNumberULLong(Freqs.$at$Const(Node.Index).Scaled);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::getBlockFreq">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 526,
   FQN="llvm::BlockFrequencyInfoImplBase::getBlockFreq", NM="_ZNK4llvm26BlockFrequencyInfoImplBase12getBlockFreqERKNS0_9BlockNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase12getBlockFreqERKNS0_9BlockNodeE")
  //</editor-fold>
  public BlockFrequency getBlockFreq(final /*const*/ BlockNode /*&*/ Node) /*const*/ {
    if (!Node.isValid()) {
      return new BlockFrequency($int2ulong(0));
    }
    return new BlockFrequency(Freqs.$at$Const(Node.Index).Integer);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::getBlockProfileCount">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 533,
   FQN="llvm::BlockFrequencyInfoImplBase::getBlockProfileCount", NM="_ZNK4llvm26BlockFrequencyInfoImplBase20getBlockProfileCountERKNS_8FunctionERKNS0_9BlockNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase20getBlockProfileCountERKNS_8FunctionERKNS0_9BlockNodeE")
  //</editor-fold>
  public OptionalULong getBlockProfileCount(final /*const*/ Function /*&*/ F, 
                      final /*const*/ BlockNode /*&*/ Node) /*const*/ {
    OptionalULong EntryCount = F.getEntryCount();
    if (!EntryCount.$bool()) {
      return new OptionalULong(None);
    }
    // Use 128 bit APInt to do the arithmetic to avoid overflow.
    APInt BlockCount/*J*/= new APInt(JD$UInt_ULong.INSTANCE, 128, EntryCount.getValue());
    APInt BlockFreq/*J*/= new APInt(JD$UInt_ULong.INSTANCE, 128, getBlockFreq(Node).getFrequency());
    APInt EntryFreq/*J*/= new APInt(JD$UInt_ULong.INSTANCE, 128, getEntryFreq());
    BlockCount.$starassign(BlockFreq);
    BlockCount.$assignMove(BlockCount.udiv(EntryFreq));
    return new OptionalULong(JD$T$RR.INSTANCE, BlockCount.getLimitedValue());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::setBlockFreq">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 555,
   FQN="llvm::BlockFrequencyInfoImplBase::setBlockFreq", NM="_ZN4llvm26BlockFrequencyInfoImplBase12setBlockFreqERKNS0_9BlockNodeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBase12setBlockFreqERKNS0_9BlockNodeEy")
  //</editor-fold>
  public void setBlockFreq(final /*const*/ BlockNode /*&*/ Node, 
              long/*uint64_t*/ Freq) {
    assert (Node.isValid()) : "Expected valid node";
    assert ($less_uint(Node.Index, Freqs.size())) : "Expected legal index";
    Freqs.$at(Node.Index).Integer = Freq;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::printBlockFreq">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 572,
   FQN="llvm::BlockFrequencyInfoImplBase::printBlockFreq", NM="_ZNK4llvm26BlockFrequencyInfoImplBase14printBlockFreqERNS_11raw_ostreamERKNS0_9BlockNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase14printBlockFreqERNS_11raw_ostreamERKNS0_9BlockNodeE")
  //</editor-fold>
  public raw_ostream /*&*/ printBlockFreq(final raw_ostream /*&*/ OS, 
                final /*const*/ BlockNode /*&*/ Node) /*const*/ {
    return AdtsupportLlvmGlobals.$out_raw_ostream_ScaledNumber$DigitsT$C(OS, getFloatingBlockFreq(Node));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::printBlockFreq">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp", line = 578,
   FQN="llvm::BlockFrequencyInfoImplBase::printBlockFreq", NM="_ZNK4llvm26BlockFrequencyInfoImplBase14printBlockFreqERNS_11raw_ostreamERKNS_14BlockFrequencyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase14printBlockFreqERNS_11raw_ostreamERKNS_14BlockFrequencyE")
  //</editor-fold>
  public raw_ostream /*&*/ printBlockFreq(final raw_ostream /*&*/ OS, 
                final /*const*/ BlockFrequency /*&*/ Freq) /*const*/ {
    ScaledNumberULLong Block/*J*/= new ScaledNumberULLong(Freq.getFrequency(), $int2short(0));
    ScaledNumberULLong Entry/*J*/= new ScaledNumberULLong(getEntryFreq(), $int2short(0));
    
    return AdtsupportLlvmGlobals.$out_raw_ostream_ScaledNumber$DigitsT$C(OS, AdtsupportLlvmGlobals.$slash_ScaledNumber$DigitsT$C(Block, Entry));
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::getEntryFreq">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 492,
   FQN="llvm::BlockFrequencyInfoImplBase::getEntryFreq", NM="_ZNK4llvm26BlockFrequencyInfoImplBase12getEntryFreqEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm26BlockFrequencyInfoImplBase12getEntryFreqEv")
  //</editor-fold>
  public long/*uint64_t*/ getEntryFreq() /*const*/ {
    assert (!Freqs.empty());
    return Freqs.$at$Const(0).Integer;
  }

  /// \brief Virtual destructor.
  ///
  /// Need a virtual destructor to mask the compiler warning about
  /// getBlockName().
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::~BlockFrequencyInfoImplBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 500,
   FQN="llvm::BlockFrequencyInfoImplBase::~BlockFrequencyInfoImplBase", NM="_ZN4llvm26BlockFrequencyInfoImplBaseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBaseD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    //START JDestroy
    Loops.$destroy();
    Working.$destroy();
    Freqs.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoImplBase::BlockFrequencyInfoImplBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 160,
   FQN="llvm::BlockFrequencyInfoImplBase::BlockFrequencyInfoImplBase", NM="_ZN4llvm26BlockFrequencyInfoImplBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26BlockFrequencyInfoImplBaseC1Ev")
  //</editor-fold>
  public /*inline*/ BlockFrequencyInfoImplBase() {
    // : Freqs(), Working(), Loops() 
    //START JInit
    this.Freqs = new std.vector<FrequencyData>(new FrequencyData());
    this.Working = new std.vector<WorkingData>(new WorkingData());
    this.Loops = new std.list<LoopData>(new LoopData());
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Freqs=" + Freqs // NOI18N
              + ", Working=" + Working // NOI18N
              + ", Loops=" + Loops; // NOI18N
  }
}
