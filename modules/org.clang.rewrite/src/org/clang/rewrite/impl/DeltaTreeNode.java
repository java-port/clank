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

package org.clang.rewrite.impl;

import org.clank.support.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;

/// DeltaTreeNode - The common part of all nodes.
///
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeltaTreeNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 53,
 FQN="(anonymous namespace)::DeltaTreeNode", NM="_ZN12_GLOBAL__N_113DeltaTreeNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZN12_GLOBAL__N_113DeltaTreeNodeE")
//</editor-fold>
public class DeltaTreeNode {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeltaTreeNode::InsertResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 55,
   FQN="(anonymous namespace)::DeltaTreeNode::InsertResult", NM="_ZN12_GLOBAL__N_113DeltaTreeNode12InsertResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZN12_GLOBAL__N_113DeltaTreeNode12InsertResultE")
  //</editor-fold>
  public static class/*struct*/ InsertResult {
    public DeltaTreeNode /*P*/ LHS;
    public DeltaTreeNode /*P*/ RHS;
    public SourceDelta Split;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeltaTreeNode::InsertResult::InsertResult">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 55,
     FQN="(anonymous namespace)::DeltaTreeNode::InsertResult::InsertResult", NM="_ZN12_GLOBAL__N_113DeltaTreeNode12InsertResultC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZN12_GLOBAL__N_113DeltaTreeNode12InsertResultC1Ev")
    //</editor-fold>
    public /*inline*/ InsertResult() {
      // : Split() 
      //START JInit
      this.Split = new SourceDelta();
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "LHS=" + LHS // NOI18N
                + ", RHS=" + RHS // NOI18N
                + ", Split=" + Split; // NOI18N
    }
  };
/*private:*/
  /*friend  class DeltaTreeInteriorNode*/
  
  /// WidthFactor - This controls the number of K/V slots held in the BTree:
  /// how wide it is.  Each level of the BTree is guaranteed to have at least
  /// WidthFactor-1 K/V pairs (except the root) and may have at most
  /// 2*WidthFactor-1 K/V pairs.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeltaTreeNode::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 67,
   FQN="(anonymous namespace)::DeltaTreeNode::(anonymous)", NM="_ZN12_GLOBAL__N_113DeltaTreeNodeE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZN12_GLOBAL__N_113DeltaTreeNodeE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int WidthFactor = 8;
  /*}*/;
  
  /// Values - This tracks the SourceDelta's currently in this node.
  ///
  /*friend*/ SourceDelta Values[/*15*/] = new SourceDelta [15];
  
  /// NumValuesUsed - This tracks the number of values this node currently
  /// holds.
  /*friend*/ /*uchar*/byte NumValuesUsed;
  
  /// IsLeaf - This is true if this is a leaf of the btree.  If false, this is
  /// an interior node, and is actually an instance of DeltaTreeInteriorNode.
  private boolean IsLeaf;
  
  /// FullDelta - This is the full delta of all the values in this node and
  /// all children nodes.
  /*friend*/ int FullDelta;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeltaTreeNode::DeltaTreeNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 85,
   FQN="(anonymous namespace)::DeltaTreeNode::DeltaTreeNode", NM="_ZN12_GLOBAL__N_113DeltaTreeNodeC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZN12_GLOBAL__N_113DeltaTreeNodeC1Eb")
  //</editor-fold>
  public DeltaTreeNode() {
    this(true);
  }
  public DeltaTreeNode(boolean isLeaf/*= true*/) {
    // : Values(), NumValuesUsed(0), IsLeaf(isLeaf), FullDelta(0) 
    //START JInit
    this.Values = new$T(new SourceDelta [15], ()->new SourceDelta());
    this.NumValuesUsed = 0;
    this.IsLeaf = isLeaf;
    this.FullDelta = 0;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeltaTreeNode::isLeaf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 88,
   FQN="(anonymous namespace)::DeltaTreeNode::isLeaf", NM="_ZNK12_GLOBAL__N_113DeltaTreeNode6isLeafEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZNK12_GLOBAL__N_113DeltaTreeNode6isLeafEv")
  //</editor-fold>
  public boolean isLeaf() /*const*/ {
    return IsLeaf;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeltaTreeNode::getFullDelta">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 89,
   FQN="(anonymous namespace)::DeltaTreeNode::getFullDelta", NM="_ZNK12_GLOBAL__N_113DeltaTreeNode12getFullDeltaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZNK12_GLOBAL__N_113DeltaTreeNode12getFullDeltaEv")
  //</editor-fold>
  public int getFullDelta() /*const*/ {
    return FullDelta;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeltaTreeNode::isFull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 90,
   FQN="(anonymous namespace)::DeltaTreeNode::isFull", NM="_ZNK12_GLOBAL__N_113DeltaTreeNode6isFullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZNK12_GLOBAL__N_113DeltaTreeNode6isFullEv")
  //</editor-fold>
  public boolean isFull() /*const*/ {
    return $uchar2int(NumValuesUsed) == 2 * WidthFactor - 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeltaTreeNode::getNumValuesUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 92,
   FQN="(anonymous namespace)::DeltaTreeNode::getNumValuesUsed", NM="_ZNK12_GLOBAL__N_113DeltaTreeNode16getNumValuesUsedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZNK12_GLOBAL__N_113DeltaTreeNode16getNumValuesUsedEv")
  //</editor-fold>
  public /*uint*/int getNumValuesUsed() /*const*/ {
    return $uchar2uint(NumValuesUsed);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeltaTreeNode::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 93,
   FQN="(anonymous namespace)::DeltaTreeNode::getValue", NM="_ZNK12_GLOBAL__N_113DeltaTreeNode8getValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZNK12_GLOBAL__N_113DeltaTreeNode8getValueEj")
  //</editor-fold>
  public /*const*/ SourceDelta /*&*/ getValue$Const(/*uint*/int i) /*const*/ {
    assert ($less_uint_uchar(i, NumValuesUsed)) : "Invalid value #";
    return Values[i];
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeltaTreeNode::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 97,
   FQN="(anonymous namespace)::DeltaTreeNode::getValue", NM="_ZN12_GLOBAL__N_113DeltaTreeNode8getValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZN12_GLOBAL__N_113DeltaTreeNode8getValueEj")
  //</editor-fold>
  public SourceDelta /*&*/ getValue(/*uint*/int i) {
    assert ($less_uint_uchar(i, NumValuesUsed)) : "Invalid value #";
    return Values[i];
  }

  
  /// DoInsertion - Do an insertion of the specified FileIndex/Delta pair into
  /// this node.  If insertion is easy, do it and return false.  Otherwise,
  /// split the node, populate InsertRes with info about the split, and return
  /// true.
  
  /// DoInsertion - Do an insertion of the specified FileIndex/Delta pair into
  /// this node.  If insertion is easy, do it and return false.  Otherwise,
  /// split the node, populate InsertRes with info about the split, and return
  /// true.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeltaTreeNode::DoInsertion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 179,
   FQN="(anonymous namespace)::DeltaTreeNode::DoInsertion", NM="_ZN12_GLOBAL__N_113DeltaTreeNode11DoInsertionEjiPNS0_12InsertResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZN12_GLOBAL__N_113DeltaTreeNode11DoInsertionEjiPNS0_12InsertResultE")
  //</editor-fold>
  public boolean DoInsertion(/*uint*/int FileIndex, int Delta, 
             InsertResult /*P*/ InsertRes) {
    // Maintain full delta for this node.
    FullDelta += Delta;
    
    // Find the insertion point, the first delta whose index is >= FileIndex.
    /*uint*/int i = 0, e = getNumValuesUsed();
    while (i != e && $greater_uint(FileIndex, getValue(i).FileLoc)) {
      ++i;
    }
    
    // If we found an a record for exactly this file index, just merge this
    // value into the pre-existing record and finish early.
    if (i != e && getValue(i).FileLoc == FileIndex) {
      // NOTE: Delta could drop to zero here.  This means that the delta entry is
      // useless and could be removed.  Supporting erases is more complex than
      // leaving an entry with Delta=0, so we just leave an entry with Delta=0 in
      // the tree.
      Values[i].Delta += Delta;
      return false;
    }
    
    // Otherwise, we found an insertion point, and we know that the value at the
    // specified index is > FileIndex.  Handle the leaf case first.
    if (isLeaf()) {
      if (!isFull()) {
        // For an insertion into a non-full leaf node, just insert the value in
        // its sorted position.  This requires moving later values over.
        if (i != e) {
          memmove(/*AddrOf*/Values, i + 1, /*AddrOf*/Values, i, /*sizeof(Values[0]) * */(e - i));
        }
        Values[i].$assignMove(SourceDelta.get(FileIndex, Delta));
        ++NumValuesUsed;
        return false;
      }
      
      // Otherwise, if this is leaf is full, split the node at its median, insert
      // the value into one of the children, and return the result.
      assert ((InsertRes != null)) : "No result location specified";
      DoSplit(/*Deref*/InsertRes);
      if ($greater_uint(InsertRes.Split.FileLoc, FileIndex)) {
        InsertRes.LHS.DoInsertion(FileIndex, Delta, (InsertResult /*P*/ )null/*can't fail*/);
      } else {
        InsertRes.RHS.DoInsertion(FileIndex, Delta, (InsertResult /*P*/ )null/*can't fail*/);
      }
      return true;
    }
    
    // Otherwise, this is an interior node.  Send the request down the tree.
    DeltaTreeInteriorNode /*P*/ IN = cast(DeltaTreeInteriorNode.class, this);
    if (!IN.Children[i].DoInsertion(FileIndex, Delta, InsertRes)) {
      return false; // If there was space in the child, just return.
    }
    
    // Okay, this split the subtree, producing a new value and two children to
    // insert here.  If this node is non-full, we can just insert it directly.
    if (!isFull()) {
      // Now that we have two nodes and a new element, insert the perclated value
      // into ourself by moving all the later values/children down, then inserting
      // the new one.
      if (i != e) {
        memmove(/*AddrOf*/IN.Children, i + 2, /*AddrOf*/IN.Children, i + 1, 
            (e - i) /* * sizeof(IN.Children[0])*/);
      }
      IN.Children[i] = InsertRes.LHS;
      IN.Children[i + 1] = InsertRes.RHS;
      if (e != i) {
        memmove(/*AddrOf*/Values, i + 1, /*AddrOf*/Values, i, (e - i) /* * sizeof(Values[0])*/);
      }
      Values[i].$assign(InsertRes.Split);
      ++NumValuesUsed;
      return false;
    }
    
    // Finally, if this interior node was full and a node is percolated up, split
    // ourself and return that up the chain.  Start by saving all our info to
    // avoid having the split clobber it.
    IN.Children[i] = InsertRes.LHS;
    DeltaTreeNode /*P*/ SubRHS = InsertRes.RHS;
    SourceDelta SubSplit = new SourceDelta(InsertRes.Split);
    
    // Do the split.
    DoSplit(/*Deref*/InsertRes);
    
    // Figure out where to insert SubRHS/NewSplit.
    DeltaTreeInteriorNode /*P*/ InsertSide;
    if ($less_uint(SubSplit.FileLoc, InsertRes.Split.FileLoc)) {
      InsertSide = cast(DeltaTreeInteriorNode.class, InsertRes.LHS);
    } else {
      InsertSide = cast(DeltaTreeInteriorNode.class, InsertRes.RHS);
    }
    
    // We now have a non-empty interior node 'InsertSide' to insert
    // SubRHS/SubSplit into.  Find out where to insert SubSplit.
    
    // Find the insertion point, the first delta whose index is >SubSplit.FileLoc.
    i = 0;
    e = InsertSide.getNumValuesUsed();
    while (i != e && $greater_uint(SubSplit.FileLoc, InsertSide.getValue(i).FileLoc)) {
      ++i;
    }
    
    // Now we know that i is the place to insert the split value into.  Insert it
    // and the child right after it.
    if (i != e) {
      memmove(/*AddrOf*/InsertSide.Children, i + 2, /*AddrOf*/InsertSide.Children, i + 1, 
          (e - i) /* * sizeof(IN.Children[0])*/);
    }
    InsertSide.Children[i + 1] = SubRHS;
    if (e != i) {
      memmove(/*AddrOf*/InsertSide.Values, i + 1, /*AddrOf*/InsertSide.Values, i, 
          (e - i) /* * sizeof(Values[0])*/);
    }
    InsertSide.Values[i].$assign(SubSplit);
    ++InsertSide.NumValuesUsed;
    InsertSide.FullDelta += SubSplit.Delta + SubRHS.getFullDelta();
    return true;
  }

  
  
  /// DoSplit - Split the currently full node (which has 2*WidthFactor-1 values)
  /// into two subtrees each with "WidthFactor-1" values and a pivot value.
  /// Return the pieces in InsertRes.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeltaTreeNode::DoSplit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 293,
   FQN="(anonymous namespace)::DeltaTreeNode::DoSplit", NM="_ZN12_GLOBAL__N_113DeltaTreeNode7DoSplitERNS0_12InsertResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZN12_GLOBAL__N_113DeltaTreeNode7DoSplitERNS0_12InsertResultE")
  //</editor-fold>
  public void DoSplit(InsertResult /*&*/ InsertRes) {
    assert (isFull()) : "Why split a non-full node?";
    
    // Since this node is full, it contains 2*WidthFactor-1 values.  We move
    // the first 'WidthFactor-1' values to the LHS child (which we leave in this
    // node), propagate one value up, and move the last 'WidthFactor-1' values
    // into the RHS child.
    
    // Create the new child node.
    DeltaTreeNode /*P*/ NewNode;
    {
      DeltaTreeInteriorNode /*P*/ IN = dyn_cast(DeltaTreeInteriorNode.class, this);
      if ((IN != null)) {
        // If this is an interior node, also move over 'WidthFactor' children
        // into the new node.
        DeltaTreeInteriorNode /*P*/ New = new DeltaTreeInteriorNode();
        memcpy(/*AddrOf*/New.Children, 0, /*AddrOf*/IN.Children, WidthFactor, 
            WidthFactor /* * sizeof(IN.Children[0])*/);
        NewNode = New;
      } else {
        // Just create the new leaf node.
        NewNode = new DeltaTreeNode();
      }
    }
    
    // Move over the last 'WidthFactor-1' values from here to NewNode.
    memcpy(/*AddrOf*/NewNode.Values, 0, /*AddrOf*/Values, WidthFactor, 
        (WidthFactor - 1) /* * sizeof(Values[0])*/);
    
    // Decrease the number of values in the two nodes.
    NewNode.NumValuesUsed = NumValuesUsed = WidthFactor - 1;
    
    // Recompute the two nodes' full delta.
    NewNode.RecomputeFullDeltaLocally();
    RecomputeFullDeltaLocally();
    
    InsertRes.LHS = this;
    InsertRes.RHS = NewNode;
    InsertRes.Split.$assign(Values[WidthFactor - 1]);
  }

  
  /// RecomputeFullDeltaLocally - Recompute the FullDelta field by doing a
  /// local walk over our contained deltas.
  
  /// RecomputeFullDeltaLocally - Recompute the FullDelta field by doing a
  /// local walk over our contained deltas.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeltaTreeNode::RecomputeFullDeltaLocally">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 165,
   FQN="(anonymous namespace)::DeltaTreeNode::RecomputeFullDeltaLocally", NM="_ZN12_GLOBAL__N_113DeltaTreeNode25RecomputeFullDeltaLocallyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZN12_GLOBAL__N_113DeltaTreeNode25RecomputeFullDeltaLocallyEv")
  //</editor-fold>
  public void RecomputeFullDeltaLocally() {
    int NewFullDelta = 0;
    for (/*uint*/int i = 0, e = getNumValuesUsed(); i != e; ++i)  {
      NewFullDelta += Values[i].Delta;
    }
    {
      DeltaTreeInteriorNode /*P*/ IN = dyn_cast(DeltaTreeInteriorNode.class, this);
      if ((IN != null)) {
        for (/*uint*/int i = 0, e = getNumValuesUsed() + 1; i != e; ++i)  {
          NewFullDelta += IN.getChild(i).getFullDelta();
        }
      }
    }
    FullDelta = NewFullDelta;
  }

  
  
  /// Destroy - A 'virtual' destructor.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeltaTreeNode::Destroy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 156,
   FQN="(anonymous namespace)::DeltaTreeNode::Destroy", NM="_ZN12_GLOBAL__N_113DeltaTreeNode7DestroyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZN12_GLOBAL__N_113DeltaTreeNode7DestroyEv")
  //</editor-fold>
  public void Destroy() {
    if (isLeaf()) {
      /*delete*/Destructors.$destroy(this);
    } else {
      if (cast(DeltaTreeInteriorNode.class, this) != null) { cast(DeltaTreeInteriorNode.class, this).$destroy();};
    }
  }

  
  @Override public String toString() {
    return "" + "Values=" + Values // NOI18N
              + ", NumValuesUsed=" + NumValuesUsed // NOI18N
              + ", IsLeaf=" + IsLeaf // NOI18N
              + ", FullDelta=" + FullDelta; // NOI18N
  }
}
