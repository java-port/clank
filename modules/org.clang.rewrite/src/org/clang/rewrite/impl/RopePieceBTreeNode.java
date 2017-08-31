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
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.clang.rewrite.core.*;

/// RopePieceBTreeNode - Common base class of RopePieceBTreeLeaf and
/// RopePieceBTreeInterior.  This provides some 'virtual' dispatching methods
/// and a flag that determines which subclass the instance is.  Also
/// important, this node knows the full extend of the node, including any
/// children that it has.  This allows efficient skipping over entire subtrees
/// when looking for an offset in the BTree.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 74,
 FQN="(anonymous namespace)::RopePieceBTreeNode", NM="_ZN12_GLOBAL__N_118RopePieceBTreeNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_118RopePieceBTreeNodeE")
//</editor-fold>
public class RopePieceBTreeNode implements Destructors.ClassWithDestructor {
/*protected:*/
  /// WidthFactor - This controls the number of K/V slots held in the BTree:
  /// how wide it is.  Each level of the BTree is guaranteed to have at least
  /// 'WidthFactor' elements in it (either ropepieces or children), (except
  /// the root, which may have less) and may have at most 2*WidthFactor
  /// elements.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeNode::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 81,
   FQN="(anonymous namespace)::RopePieceBTreeNode::(anonymous)", NM="_ZN12_GLOBAL__N_118RopePieceBTreeNodeE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_118RopePieceBTreeNodeE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int WidthFactor = 8;
  /*}*/;
  
  /// Size - This is the number of bytes of file this node (including any
  /// potential children) covers.
  protected /*uint*/int Size;
  
  /// IsLeaf - True if this is an instance of RopePieceBTreeLeaf, false if it
  /// is an instance of RopePieceBTreeInterior.
  protected boolean IsLeaf;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeNode::RopePieceBTreeNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 91,
   FQN="(anonymous namespace)::RopePieceBTreeNode::RopePieceBTreeNode", NM="_ZN12_GLOBAL__N_118RopePieceBTreeNodeC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_118RopePieceBTreeNodeC1Eb")
  //</editor-fold>
  protected RopePieceBTreeNode(boolean isLeaf) {
    // : Size(0), IsLeaf(isLeaf) 
    //START JInit
    this.Size = 0;
    this.IsLeaf = isLeaf;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeNode::~RopePieceBTreeNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 92,
   FQN="(anonymous namespace)::RopePieceBTreeNode::~RopePieceBTreeNode", NM="_ZN12_GLOBAL__N_118RopePieceBTreeNodeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_118RopePieceBTreeNodeD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy()/* = default*/ {
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeNode::isLeaf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 95,
   FQN="(anonymous namespace)::RopePieceBTreeNode::isLeaf", NM="_ZNK12_GLOBAL__N_118RopePieceBTreeNode6isLeafEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK12_GLOBAL__N_118RopePieceBTreeNode6isLeafEv")
  //</editor-fold>
  public boolean isLeaf() /*const*/ {
    return IsLeaf;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeNode::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 96,
   FQN="(anonymous namespace)::RopePieceBTreeNode::size", NM="_ZNK12_GLOBAL__N_118RopePieceBTreeNode4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK12_GLOBAL__N_118RopePieceBTreeNode4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Size;
  }

  
  
  //===----------------------------------------------------------------------===//
  // RopePieceBTreeNode Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeNode::Destroy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 615,
   FQN="(anonymous namespace)::RopePieceBTreeNode::Destroy", NM="_ZN12_GLOBAL__N_118RopePieceBTreeNode7DestroyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_118RopePieceBTreeNode7DestroyEv")
  //</editor-fold>
  public void Destroy() {
    {
      RopePieceBTreeLeaf /*P*/ Leaf = dyn_cast(RopePieceBTreeLeaf.class, this);
      if ((Leaf != null)) {
        if (Leaf != null) { Leaf.$destroy();};
      } else {
        if (cast(RopePieceBTreeInterior.class, this) != null) { cast(RopePieceBTreeInterior.class, this).$destroy();};
      }
    }
  }

  
  /// split - Split the range containing the specified offset so that we are
  /// guaranteed that there is a place to do an insertion at the specified
  /// offset.  The offset is relative, so "0" is the start of the node.
  ///
  /// If there is no space in this subtree for the extra piece, the extra tree
  /// node is returned and must be inserted into a parent.
  
  /// split - Split the range containing the specified offset so that we are
  /// guaranteed that there is a place to do an insertion at the specified
  /// offset.  The offset is relative, so "0" is the start of the node.
  ///
  /// If there is no space in this subtree for the extra piece, the extra tree
  /// node is returned and must be inserted into a parent.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeNode::split">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 628,
   FQN="(anonymous namespace)::RopePieceBTreeNode::split", NM="_ZN12_GLOBAL__N_118RopePieceBTreeNode5splitEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_118RopePieceBTreeNode5splitEj")
  //</editor-fold>
  public RopePieceBTreeNode /*P*/ split(/*uint*/int Offset) {
    assert ($lesseq_uint(Offset, size())) : "Invalid offset to split!";
    {
      RopePieceBTreeLeaf /*P*/ Leaf = dyn_cast(RopePieceBTreeLeaf.class, this);
      if ((Leaf != null)) {
        return Leaf.split(Offset);
      }
    }
    return cast(RopePieceBTreeInterior.class, this).split(Offset);
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
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeNode::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 641,
   FQN="(anonymous namespace)::RopePieceBTreeNode::insert", NM="_ZN12_GLOBAL__N_118RopePieceBTreeNode6insertEjRKN5clang9RopePieceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_118RopePieceBTreeNode6insertEjRKN5clang9RopePieceE")
  //</editor-fold>
  public RopePieceBTreeNode /*P*/ insert(/*uint*/int Offset, 
        /*const*/ RopePiece /*&*/ R) {
    assert ($lesseq_uint(Offset, size())) : "Invalid offset to insert!";
    {
      RopePieceBTreeLeaf /*P*/ Leaf = dyn_cast(RopePieceBTreeLeaf.class, this);
      if ((Leaf != null)) {
        return Leaf.insert(Offset, R);
      }
    }
    return cast(RopePieceBTreeInterior.class, this).insert(Offset, R);
  }

  
  /// erase - Remove NumBytes from this node at the specified offset.  We are
  /// guaranteed that there is a split at Offset.
  
  /// erase - Remove NumBytes from this node at the specified offset.  We are
  /// guaranteed that there is a split at Offset.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RopePieceBTreeNode::erase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 651,
   FQN="(anonymous namespace)::RopePieceBTreeNode::erase", NM="_ZN12_GLOBAL__N_118RopePieceBTreeNode5eraseEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN12_GLOBAL__N_118RopePieceBTreeNode5eraseEjj")
  //</editor-fold>
  public void erase(/*uint*/int Offset, /*uint*/int NumBytes) {
    assert ($lesseq_uint(Offset + NumBytes, size())) : "Invalid offset to erase!";
    {
      RopePieceBTreeLeaf /*P*/ Leaf = dyn_cast(RopePieceBTreeLeaf.class, this);
      if ((Leaf != null)) {
        Leaf.erase(Offset, NumBytes);
        return;
      }
    }
    cast(RopePieceBTreeInterior.class, this).erase(Offset, NumBytes);
    return;
  }

  
  @Override public String toString() {
    return "" + "Size=" + Size // NOI18N
              + ", IsLeaf=" + IsLeaf; // NOI18N
  }
}
