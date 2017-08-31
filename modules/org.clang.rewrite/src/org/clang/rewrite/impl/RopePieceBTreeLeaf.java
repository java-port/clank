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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.rewrite.core.*;

/// RopePieceBTreeLeaf - Directly manages up to '2*WidthFactor' RopePiece
/// nodes.  This directly represents a chunk of the string with those
/// RopePieces contatenated.  Since this is a B+Tree, all values (in this case
/// instances of RopePiece) are stored in leaves like this.  To make iteration
/// over the leaves efficient, they maintain a singly linked list through the
/// NextLeaf field.  This allows the B+Tree forward iterator to be constant
/// time for all increments.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeLeaf">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*check usage of PrevLeaf*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 135,
 FQN="(anonymous namespace)::RopePieceBTreeLeaf", NM="_ZN12_GLOBAL__N_118RopePieceBTreeLeafE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_118RopePieceBTreeLeafE")
//</editor-fold>
public class RopePieceBTreeLeaf extends /*public*/ RopePieceBTreeNode implements Destructors.ClassWithDestructor {
  /// NumPieces - This holds the number of rope pieces currently active in the
  /// Pieces array.
  private /*uchar*/byte NumPieces;
  
  /// Pieces - This tracks the file chunks currently in this leaf.
  ///
  private RopePiece Pieces[/*16*/] = new RopePiece [16];
  
  /// NextLeaf - This is a pointer to the next leaf in the tree, allowing
  /// efficient in-order forward iteration of the tree without traversal.
  private type$ptr<RopePieceBTreeLeaf/*P*/> PrevLeaf;
  private RopePieceBTreeLeaf /*P*/ NextLeaf;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeLeaf::RopePieceBTreeLeaf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 148,
   FQN="(anonymous namespace)::RopePieceBTreeLeaf::RopePieceBTreeLeaf", NM="_ZN12_GLOBAL__N_118RopePieceBTreeLeafC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_118RopePieceBTreeLeafC1Ev")
  //</editor-fold>
  public RopePieceBTreeLeaf() {
    // : RopePieceBTreeNode(true), NumPieces(0), Pieces(), PrevLeaf(null), NextLeaf(null) 
    //START JInit
    super(true);
    this.NumPieces = 0;
    this.Pieces = new$T(new RopePiece [16], ()->new RopePiece());
    this.PrevLeaf = create_type$null$ptr();
    this.NextLeaf = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeLeaf::~RopePieceBTreeLeaf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 150,
   FQN="(anonymous namespace)::RopePieceBTreeLeaf::~RopePieceBTreeLeaf", NM="_ZN12_GLOBAL__N_118RopePieceBTreeLeafD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_118RopePieceBTreeLeafD0Ev")
  //</editor-fold>
  public void $destroy() {
    if ((PrevLeaf.$star() != null) || (NextLeaf != null)) {
      removeFromLeafInOrder();
    }
    clear();
    //START JDestroy
    Native.destroy(Pieces);//Pieces.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeLeaf::isFull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 156,
   FQN="(anonymous namespace)::RopePieceBTreeLeaf::isFull", NM="_ZNK12_GLOBAL__N_118RopePieceBTreeLeaf6isFullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK12_GLOBAL__N_118RopePieceBTreeLeaf6isFullEv")
  //</editor-fold>
  public boolean isFull() /*const*/ {
    return $uchar2int(NumPieces) == 2 * WidthFactor;
  }

  
  /// clear - Remove all rope pieces from this leaf.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeLeaf::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 159,
   FQN="(anonymous namespace)::RopePieceBTreeLeaf::clear", NM="_ZN12_GLOBAL__N_118RopePieceBTreeLeaf5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_118RopePieceBTreeLeaf5clearEv")
  //</editor-fold>
  public void clear() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      while ((NumPieces != 0)) {
        $c$.clean(Pieces[--NumPieces].$assignMove($c$.track(new RopePiece())));
      }
      Size = 0;
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeLeaf::getNumPieces">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 165,
   FQN="(anonymous namespace)::RopePieceBTreeLeaf::getNumPieces", NM="_ZNK12_GLOBAL__N_118RopePieceBTreeLeaf12getNumPiecesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK12_GLOBAL__N_118RopePieceBTreeLeaf12getNumPiecesEv")
  //</editor-fold>
  public /*uint*/int getNumPieces() /*const*/ {
    return $uchar2uint(NumPieces);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeLeaf::getPiece">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 167,
   FQN="(anonymous namespace)::RopePieceBTreeLeaf::getPiece", NM="_ZNK12_GLOBAL__N_118RopePieceBTreeLeaf8getPieceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK12_GLOBAL__N_118RopePieceBTreeLeaf8getPieceEj")
  //</editor-fold>
  public /*const*/ type$ptr<RopePiece> /*&*/ getPiece(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, getNumPieces())) : "Invalid piece ID";
    return create_type$ptr(Pieces, i);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeLeaf::getNextLeafInOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 172,
   FQN="(anonymous namespace)::RopePieceBTreeLeaf::getNextLeafInOrder", NM="_ZNK12_GLOBAL__N_118RopePieceBTreeLeaf18getNextLeafInOrderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK12_GLOBAL__N_118RopePieceBTreeLeaf18getNextLeafInOrderEv")
  //</editor-fold>
  public /*const*/ RopePieceBTreeLeaf /*P*/ getNextLeafInOrder() /*const*/ {
    return NextLeaf;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeLeaf::insertAfterLeafInOrder">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 173,
   FQN="(anonymous namespace)::RopePieceBTreeLeaf::insertAfterLeafInOrder", NM="_ZN12_GLOBAL__N_118RopePieceBTreeLeaf22insertAfterLeafInOrderEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_118RopePieceBTreeLeaf22insertAfterLeafInOrderEPS0_")
  //</editor-fold>
  public void insertAfterLeafInOrder(RopePieceBTreeLeaf /*P*/ Node) {
    assert (!(PrevLeaf.$star() != null) && !(NextLeaf != null)) : "Already in ordering";
    
    NextLeaf = Node.NextLeaf;
    if ((NextLeaf != null)) {
      NextLeaf.PrevLeaf.$set(/*AddrOf*/NextLeaf);
    }
    PrevLeaf.$set(/*AddrOf*/Node.NextLeaf);
    Node.NextLeaf = this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeLeaf::removeFromLeafInOrder">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 183,
   FQN="(anonymous namespace)::RopePieceBTreeLeaf::removeFromLeafInOrder", NM="_ZN12_GLOBAL__N_118RopePieceBTreeLeaf21removeFromLeafInOrderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_118RopePieceBTreeLeaf21removeFromLeafInOrderEv")
  //</editor-fold>
  public void removeFromLeafInOrder() {
    if ((PrevLeaf.$star() != null)) {
      PrevLeaf.$set(NextLeaf);
      if ((NextLeaf != null)) {
        NextLeaf.PrevLeaf = $tryClone(PrevLeaf);
      }
    } else if ((NextLeaf != null)) {
      NextLeaf.PrevLeaf.$set(null);
    }
  }

  
  /// FullRecomputeSizeLocally - This method recomputes the 'Size' field by
  /// summing the size of all RopePieces.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeLeaf::FullRecomputeSizeLocally">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 195,
   FQN="(anonymous namespace)::RopePieceBTreeLeaf::FullRecomputeSizeLocally", NM="_ZN12_GLOBAL__N_118RopePieceBTreeLeaf24FullRecomputeSizeLocallyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_118RopePieceBTreeLeaf24FullRecomputeSizeLocallyEv")
  //</editor-fold>
  public void FullRecomputeSizeLocally() {
    Size = 0;
    for (/*uint*/int i = 0, e = getNumPieces(); i != e; ++i)  {
      Size += getPiece(i).$star().size();
    }
  }

  
  /// split - Split the range containing the specified offset so that we are
  /// guaranteed that there is a place to do an insertion at the specified
  /// offset.  The offset is relative, so "0" is the start of the node.
  ///
  /// If there is no space in this subtree for the extra piece, the extra tree
  /// node is returned and must be inserted into a parent.
  // end anonymous namespace
  
  /// split - Split the range containing the specified offset so that we are
  /// guaranteed that there is a place to do an insertion at the specified
  /// offset.  The offset is relative, so "0" is the start of the node.
  ///
  /// If there is no space in this subtree for the extra piece, the extra tree
  /// node is returned and must be inserted into a parent.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeLeaf::split">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 234,
   FQN="(anonymous namespace)::RopePieceBTreeLeaf::split", NM="_ZN12_GLOBAL__N_118RopePieceBTreeLeaf5splitEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_118RopePieceBTreeLeaf5splitEj")
  //</editor-fold>
  public RopePieceBTreeNode /*P*/ split(/*uint*/int Offset) {
    RopePiece Tail = null;
    try {
      // Find the insertion point.  We are guaranteed that there is a split at the
      // specified offset so find it.
      if (Offset == 0 || Offset == size()) {
        // Fastpath for a common case.  There is already a splitpoint at the end.
        return null;
      }
      
      // Find the piece that this offset lands in.
      /*uint*/int PieceOffs = 0;
      /*uint*/int i = 0;
      while ($greatereq_uint(Offset, PieceOffs + Pieces[i].size())) {
        PieceOffs += Pieces[i].size();
        ++i;
      }
      
      // If there is already a split point at the specified offset, just return
      // success.
      if (PieceOffs == Offset) {
        return null;
      }
      
      // Otherwise, we need to split piece 'i' at Offset-PieceOffs.  Convert Offset
      // to being Piece relative.
      /*uint*/int IntraPieceOffset = Offset - PieceOffs;
      
      // We do this by shrinking the RopePiece and then doing an insert of the tail.
      Tail/*J*/= new RopePiece(new IntrusiveRefCntPtr<RopeRefCountString>(Pieces[i].StrData), Pieces[i].StartOffs + IntraPieceOffset, 
          Pieces[i].EndOffs);
      Size -= Pieces[i].size();
      Pieces[i].EndOffs = Pieces[i].StartOffs + IntraPieceOffset;
      Size += Pieces[i].size();
      
      return insert(Offset, Tail);
    } finally {
      if (Tail != null) { Tail.$destroy(); }
    }
  }

  
  /// insert - Insert the specified ropepiece into this tree node at the
  /// specified offset.  The offset is relative, so "0" is the start of the
  /// node.
  ///
  /// If there is no space in this subtree for the extra piece, the extra tree
  /// node is returned and must be inserted into a parent.
  
  /// insert - Insert the specified RopePiece into this tree node at the
  /// specified offset.  The offset is relative, so "0" is the start of the node.
  ///
  /// If there is no space in this subtree for the extra piece, the extra tree
  /// node is returned and must be inserted into a parent.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeLeaf::insert">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 275,
   FQN="(anonymous namespace)::RopePieceBTreeLeaf::insert", NM="_ZN12_GLOBAL__N_118RopePieceBTreeLeaf6insertEjRKN5clang9RopePieceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_118RopePieceBTreeLeaf6insertEjRKN5clang9RopePieceE")
  //</editor-fold>
  public RopePieceBTreeNode /*P*/ insert(/*uint*/int Offset, 
        /*const*/ RopePiece /*&*/ R) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // If this node is not full, insert the piece.
      if (!isFull()) {
        // Find the insertion point.  We are guaranteed that there is a split at the
        // specified offset so find it.
        /*uint*/int i = 0, e = getNumPieces();
        if (Offset == size()) {
          // Fastpath for a common case.
          i = e;
        } else {
          /*uint*/int SlotOffs = 0;
          for (; $greater_uint(Offset, SlotOffs); ++i)  {
            SlotOffs += getPiece(i).$star().size();
          }
          assert (SlotOffs == Offset) : "Split didn't occur before insertion!";
        }
        
        // For an insertion into a non-full leaf node, just insert the value in
        // its sorted position.  This requires moving later values over.
        for (; i != e; --e)  {
          Pieces[e].$assign(Pieces[e - 1]);
        }
        Pieces[i].$assign(R);
        ++NumPieces;
        Size += R.size();
        return null;
      }
      
      // Otherwise, if this is leaf is full, split it in two halves.  Since this
      // node is full, it contains 2*WidthFactor values.  We move the first
      // 'WidthFactor' values to the LHS child (which we leave in this node) and
      // move the last 'WidthFactor' values into the RHS child.
      
      // Create the new node.
      RopePieceBTreeLeaf /*P*/ NewNode = new RopePieceBTreeLeaf();
      
      // Move over the last 'WidthFactor' values from here to NewNode.
      std.copy(/*AddrOf*/create_type$ptr(Pieces, WidthFactor), /*AddrOf*/create_type$ptr(Pieces, 2 * WidthFactor), 
          /*AddrOf*/create_type$ptr(NewNode.Pieces, 0));
      // Replace old pieces with null RopePieces to drop refcounts.
      std.fill(/*AddrOf*/create_type$ptr(Pieces, WidthFactor), /*AddrOf*/create_type$ptr(Pieces, 2 * WidthFactor), $c$.track(new RopePiece())); $c$.clean();
      
      // Decrease the number of values in the two nodes.
      NewNode.NumPieces = NumPieces = $uint2uchar(WidthFactor);
      
      // Recompute the two nodes' size.
      NewNode.FullRecomputeSizeLocally();
      FullRecomputeSizeLocally();
      
      // Update the list of leaves.
      NewNode.insertAfterLeafInOrder(this);
      
      // These insertions can't fail.
      if ($greatereq_uint(this.size(), Offset)) {
        this.insert(Offset, R);
      } else {
        NewNode.insert(Offset - this.size(), R);
      }
      return NewNode;
    } finally {
      $c$.$destroy();
    }
  }

  
  /// erase - Remove NumBytes from this node at the specified offset.  We are
  /// guaranteed that there is a split at Offset.
  
  /// erase - Remove NumBytes from this node at the specified offset.  We are
  /// guaranteed that there is a split at Offset.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeLeaf::erase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 336,
   FQN="(anonymous namespace)::RopePieceBTreeLeaf::erase", NM="_ZN12_GLOBAL__N_118RopePieceBTreeLeaf5eraseEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_118RopePieceBTreeLeaf5eraseEjj")
  //</editor-fold>
  public void erase(/*uint*/int Offset, /*uint*/int NumBytes) {
    // Since we are guaranteed that there is a split at Offset, we start by
    // finding the Piece that starts there.
    /*uint*/int PieceOffs = 0;
    /*uint*/int i = 0;
    for (; $greater_uint(Offset, PieceOffs); ++i)  {
      PieceOffs += getPiece(i).$star().size();
    }
    assert (PieceOffs == Offset) : "Split didn't occur before erase!";
    
    /*uint*/int StartPiece = i;
    
    // Figure out how many pieces completely cover 'NumBytes'.  We want to remove
    // all of them.
    for (; $greater_uint(Offset + NumBytes, PieceOffs + getPiece(i).$star().size()); ++i)  {
      PieceOffs += getPiece(i).$star().size();
    }
    
    // If we exactly include the last one, include it in the region to delete.
    if (Offset + NumBytes == PieceOffs + getPiece(i).$star().size()) {
      PieceOffs += getPiece(i).$star().size();
      ++i;
    }
    
    // If we completely cover some RopePieces, erase them now.
    if (i != StartPiece) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*uint*/int NumDeleted = i - StartPiece;
        for (; i != getNumPieces(); ++i)  {
          Pieces[i - NumDeleted].$assign(Pieces[i]);
        }
        
        // Drop references to dead rope pieces.
        std.fill(/*AddrOf*/create_type$ptr(Pieces, getNumPieces() - NumDeleted), /*AddrOf*/create_type$ptr(Pieces, getNumPieces()), 
            $c$.track(new RopePiece())); $c$.clean();
        NumPieces -= NumDeleted;
        
        /*uint*/int CoverBytes = PieceOffs - Offset;
        NumBytes -= CoverBytes;
        Size -= CoverBytes;
      } finally {
        $c$.$destroy();
      }
    }
    
    // If we completely removed some stuff, we could be done.
    if (NumBytes == 0) {
      return;
    }
    
    // Okay, now might be erasing part of some Piece.  If this is the case, then
    // move the start point of the piece.
    assert ($greater_uint(getPiece(StartPiece).$star().size(), NumBytes));
    Pieces[StartPiece].StartOffs += NumBytes;
    
    // The size of this node just shrunk by NumBytes.
    Size -= NumBytes;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeLeaf::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 222,
   FQN="(anonymous namespace)::RopePieceBTreeLeaf::classof", NM="_ZN12_GLOBAL__N_118RopePieceBTreeLeaf7classofEPKNS_18RopePieceBTreeNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_118RopePieceBTreeLeaf7classofEPKNS_18RopePieceBTreeNodeE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ RopePieceBTreeNode /*P*/ N) {
    return N.isLeaf();
  }

  
  @Override public String toString() {
    return "" + "NumPieces=" + NumPieces // NOI18N
              + ", Pieces=" + Pieces // NOI18N
              + ", PrevLeaf=" + PrevLeaf // NOI18N
              + ", NextLeaf=" + NextLeaf // NOI18N
              + super.toString(); // NOI18N
  }
}
