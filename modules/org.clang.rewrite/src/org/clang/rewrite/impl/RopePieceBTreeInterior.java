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
import static org.clank.support.Unsigned.*;
import org.clang.rewrite.core.*;

/// RopePieceBTreeInterior - This represents an interior node in the B+Tree,
/// which holds up to 2*WidthFactor pointers to child nodes.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeInterior">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 393,
 FQN="(anonymous namespace)::RopePieceBTreeInterior", NM="_ZN12_GLOBAL__N_122RopePieceBTreeInteriorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_122RopePieceBTreeInteriorE")
//</editor-fold>
public class RopePieceBTreeInterior extends /*public*/ RopePieceBTreeNode implements Destructors.ClassWithDestructor {
  /// NumChildren - This holds the number of children currently active in the
  /// Children array.
  private /*uchar*/byte NumChildren;
  private RopePieceBTreeNode /*P*/ Children[/*16*/] = new RopePieceBTreeNode /*P*/ [16];
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeInterior::RopePieceBTreeInterior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 399,
   FQN="(anonymous namespace)::RopePieceBTreeInterior::RopePieceBTreeInterior", NM="_ZN12_GLOBAL__N_122RopePieceBTreeInteriorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_122RopePieceBTreeInteriorC1Ev")
  //</editor-fold>
  public RopePieceBTreeInterior() {
    // : RopePieceBTreeNode(false), NumChildren(0) 
    //START JInit
    super(false);
    this.NumChildren = 0;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeInterior::RopePieceBTreeInterior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 401,
   FQN="(anonymous namespace)::RopePieceBTreeInterior::RopePieceBTreeInterior", NM="_ZN12_GLOBAL__N_122RopePieceBTreeInteriorC1EPNS_18RopePieceBTreeNodeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_122RopePieceBTreeInteriorC1EPNS_18RopePieceBTreeNodeES2_")
  //</editor-fold>
  public RopePieceBTreeInterior(RopePieceBTreeNode /*P*/ LHS, RopePieceBTreeNode /*P*/ RHS) {
    // : RopePieceBTreeNode(false) 
    //START JInit
    super(false);
    //END JInit
    Children[0] = LHS;
    Children[1] = RHS;
    NumChildren = 2;
    Size = LHS.size() + RHS.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeInterior::~RopePieceBTreeInterior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 409,
   FQN="(anonymous namespace)::RopePieceBTreeInterior::~RopePieceBTreeInterior", NM="_ZN12_GLOBAL__N_122RopePieceBTreeInteriorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_122RopePieceBTreeInteriorD0Ev")
  //</editor-fold>
  public void $destroy() {
    for (/*uint*/int i = 0, e = getNumChildren(); i != e; ++i)  {
      Children[i].Destroy();
    }
    super.$destroy();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeInterior::isFull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 414,
   FQN="(anonymous namespace)::RopePieceBTreeInterior::isFull", NM="_ZNK12_GLOBAL__N_122RopePieceBTreeInterior6isFullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK12_GLOBAL__N_122RopePieceBTreeInterior6isFullEv")
  //</editor-fold>
  public boolean isFull() /*const*/ {
    return $uchar2int(NumChildren) == 2 * WidthFactor;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeInterior::getNumChildren">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 416,
   FQN="(anonymous namespace)::RopePieceBTreeInterior::getNumChildren", NM="_ZNK12_GLOBAL__N_122RopePieceBTreeInterior14getNumChildrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK12_GLOBAL__N_122RopePieceBTreeInterior14getNumChildrenEv")
  //</editor-fold>
  public /*uint*/int getNumChildren() /*const*/ {
    return $uchar2uint(NumChildren);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeInterior::getChild">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 417,
   FQN="(anonymous namespace)::RopePieceBTreeInterior::getChild", NM="_ZNK12_GLOBAL__N_122RopePieceBTreeInterior8getChildEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK12_GLOBAL__N_122RopePieceBTreeInterior8getChildEj")
  //</editor-fold>
  public /*const*/ RopePieceBTreeNode /*P*/ getChild$Const(/*uint*/int i) /*const*/ {
    assert ($less_uint_uchar(i, NumChildren)) : "invalid child #";
    return Children[i];
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeInterior::getChild">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 421,
   FQN="(anonymous namespace)::RopePieceBTreeInterior::getChild", NM="_ZN12_GLOBAL__N_122RopePieceBTreeInterior8getChildEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_122RopePieceBTreeInterior8getChildEj")
  //</editor-fold>
  public RopePieceBTreeNode /*P*/ getChild(/*uint*/int i) {
    assert ($less_uint_uchar(i, NumChildren)) : "invalid child #";
    return Children[i];
  }

  
  /// FullRecomputeSizeLocally - Recompute the Size field of this node by
  /// summing up the sizes of the child nodes.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeInterior::FullRecomputeSizeLocally">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 428,
   FQN="(anonymous namespace)::RopePieceBTreeInterior::FullRecomputeSizeLocally", NM="_ZN12_GLOBAL__N_122RopePieceBTreeInterior24FullRecomputeSizeLocallyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_122RopePieceBTreeInterior24FullRecomputeSizeLocallyEv")
  //</editor-fold>
  public void FullRecomputeSizeLocally() {
    Size = 0;
    for (/*uint*/int i = 0, e = getNumChildren(); i != e; ++i)  {
      Size += getChild(i).size();
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
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeInterior::split">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 472,
   FQN="(anonymous namespace)::RopePieceBTreeInterior::split", NM="_ZN12_GLOBAL__N_122RopePieceBTreeInterior5splitEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_122RopePieceBTreeInterior5splitEj")
  //</editor-fold>
  public RopePieceBTreeNode /*P*/ split(/*uint*/int Offset) {
    // Figure out which child to split.
    if (Offset == 0 || Offset == size()) {
      return null; // If we have an exact offset, we're already split.
    }
    
    /*uint*/int ChildOffset = 0;
    /*uint*/int i = 0;
    for (; $greatereq_uint(Offset, ChildOffset + getChild(i).size()); ++i)  {
      ChildOffset += getChild(i).size();
    }
    
    // If already split there, we're done.
    if (ChildOffset == Offset) {
      return null;
    }
    {
      
      // Otherwise, recursively split the child.
      RopePieceBTreeNode /*P*/ RHS = getChild(i).split(Offset - ChildOffset);
      if ((RHS != null)) {
        return HandleChildPiece(i, RHS);
      }
    }
    return null; // Done!
  }

  
  /// insert - Insert the specified ropepiece into this tree node at the
  /// specified offset.  The offset is relative, so "0" is the start of the
  /// node.
  ///
  /// If there is no space in this subtree for the extra piece, the extra tree
  /// node is returned and must be inserted into a parent.
  
  /// insert - Insert the specified ropepiece into this tree node at the
  /// specified offset.  The offset is relative, so "0" is the start of the
  /// node.
  ///
  /// If there is no space in this subtree for the extra piece, the extra tree
  /// node is returned and must be inserted into a parent.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeInterior::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 498,
   FQN="(anonymous namespace)::RopePieceBTreeInterior::insert", NM="_ZN12_GLOBAL__N_122RopePieceBTreeInterior6insertEjRKN5clang9RopePieceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_122RopePieceBTreeInterior6insertEjRKN5clang9RopePieceE")
  //</editor-fold>
  public RopePieceBTreeNode /*P*/ insert(/*uint*/int Offset, 
        /*const*/ RopePiece /*&*/ R) {
    // Find the insertion point.  We are guaranteed that there is a split at the
    // specified offset so find it.
    /*uint*/int i = 0, e = getNumChildren();
    
    /*uint*/int ChildOffs = 0;
    if (Offset == size()) {
      // Fastpath for a common case.  Insert at end of last child.
      i = e - 1;
      ChildOffs = size() - getChild(i).size();
    } else {
      for (; $greater_uint(Offset, ChildOffs + getChild(i).size()); ++i)  {
        ChildOffs += getChild(i).size();
      }
    }
    
    Size += R.size();
    {
      
      // Insert at the end of this child.
      RopePieceBTreeNode /*P*/ RHS = getChild(i).insert(Offset - ChildOffs, R);
      if ((RHS != null)) {
        return HandleChildPiece(i, RHS);
      }
    }
    
    return null;
  }

  
  /// HandleChildPiece - A child propagated an insertion result up to us.
  /// Insert the new child, and/or propagate the result further up the tree.
  
  /// HandleChildPiece - A child propagated an insertion result up to us.
  /// Insert the new child, and/or propagate the result further up the tree.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeInterior::HandleChildPiece">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 525,
   FQN="(anonymous namespace)::RopePieceBTreeInterior::HandleChildPiece", NM="_ZN12_GLOBAL__N_122RopePieceBTreeInterior16HandleChildPieceEjPNS_18RopePieceBTreeNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_122RopePieceBTreeInterior16HandleChildPieceEjPNS_18RopePieceBTreeNodeE")
  //</editor-fold>
  public RopePieceBTreeNode /*P*/ HandleChildPiece(/*uint*/int i, RopePieceBTreeNode /*P*/ RHS) {
    // Otherwise the child propagated a subtree up to us as a new child.  See if
    // we have space for it here.
    if (!isFull()) {
      // Insert RHS after child 'i'.
      if (i + 1 != getNumChildren()) {
        memmove(/*AddrOf*/Children, i + 2, /*AddrOf*/Children, i + 1, 
            (getNumChildren() - i - 1)/* * sizeof(Children[0])*/);
      }
      Children[i + 1] = RHS;
      ++NumChildren;
      return null;
    }
    
    // Okay, this node is full.  Split it in half, moving WidthFactor children to
    // a newly allocated interior node.
    
    // Create the new node.
    RopePieceBTreeInterior /*P*/ NewNode = new RopePieceBTreeInterior();
    
    // Move over the last 'WidthFactor' values from here to NewNode.
    memcpy(/*AddrOf*/NewNode.Children, 0, /*AddrOf*/Children, WidthFactor, 
        WidthFactor /* * sizeof$ptr(Children[0])*/);
    
    // Decrease the number of values in the two nodes.
    NewNode.NumChildren = NumChildren = $uint2uchar(WidthFactor);
    
    // Finally, insert the two new children in the side the can (now) hold them.
    // These insertions can't fail.
    if ($less_uint(i, WidthFactor)) {
      this.HandleChildPiece(i, RHS);
    } else {
      NewNode.HandleChildPiece(i - WidthFactor, RHS);
    }
    
    // Recompute the two nodes' size.
    NewNode.FullRecomputeSizeLocally();
    FullRecomputeSizeLocally();
    return NewNode;
  }

  
  /// erase - Remove NumBytes from this node at the specified offset.  We are
  /// guaranteed that there is a split at Offset.
  
  /// erase - Remove NumBytes from this node at the specified offset.  We are
  /// guaranteed that there is a split at Offset.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeInterior::erase">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 567,
   FQN="(anonymous namespace)::RopePieceBTreeInterior::erase", NM="_ZN12_GLOBAL__N_122RopePieceBTreeInterior5eraseEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_122RopePieceBTreeInterior5eraseEjj")
  //</editor-fold>
  public void erase(/*uint*/int Offset, /*uint*/int NumBytes) {
    // This will shrink this node by NumBytes.
    Size -= NumBytes;
    
    // Find the first child that overlaps with Offset.
    /*uint*/int i = 0;
    for (; $greatereq_uint(Offset, getChild(i).size()); ++i)  {
      Offset -= getChild(i).size();
    }
    
    // Propagate the delete request into overlapping children, or completely
    // delete the children as appropriate.
    while ((NumBytes != 0)) {
      RopePieceBTreeNode /*P*/ CurChild = getChild(i);
      
      // If we are deleting something contained entirely in the child, pass on the
      // request.
      if ($less_uint(Offset + NumBytes, CurChild.size())) {
        CurChild.erase(Offset, NumBytes);
        return;
      }
      
      // If this deletion request starts somewhere in the middle of the child, it
      // must be deleting to the end of the child.
      if ((Offset != 0)) {
        /*uint*/int BytesFromChild = CurChild.size() - Offset;
        CurChild.erase(Offset, BytesFromChild);
        NumBytes -= BytesFromChild;
        // Start at the beginning of the next child.
        Offset = 0;
        ++i;
        continue;
      }
      
      // If the deletion request completely covers the child, delete it and move
      // the rest down.
      NumBytes -= CurChild.size();
      CurChild.Destroy();
      --NumChildren;
      if (i != getNumChildren()) {
        memmove(/*AddrOf*/Children, i, /*AddrOf*/Children, i + 1, 
            (getNumChildren() - i) /** sizeof(Children[0])*/);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeInterior::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 460,
   FQN="(anonymous namespace)::RopePieceBTreeInterior::classof", NM="_ZN12_GLOBAL__N_122RopePieceBTreeInterior7classofEPKNS_18RopePieceBTreeNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_122RopePieceBTreeInterior7classofEPKNS_18RopePieceBTreeNodeE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ RopePieceBTreeNode /*P*/ N) {
    return !N.isLeaf();
  }

  
  @Override public String toString() {
    return "" + "NumChildren=" + NumChildren // NOI18N
              + ", Children=" + Children // NOI18N
              + super.toString(); // NOI18N
  }
}
