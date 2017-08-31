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

package org.clang.rewrite.core;

import org.clank.support.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.clang.rewrite.impl.*;
import static org.clang.rewrite.impl.DeltaTreeStatics.*;


/// DeltaTree - a multiway search tree (BTree) structure with some fancy
/// features.  B-Trees are generally more memory and cache efficient than
/// binary trees, because they store multiple keys/values in each node.  This
/// implements a key/value mapping from index to delta, and allows fast lookup
/// on index.  However, an added (important) bonus is that it can also
/// efficiently tell us the full accumulated delta for a specific file offset
/// as well, without traversing the whole tree.
//<editor-fold defaultstate="collapsed" desc="clang::DeltaTree">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/DeltaTree.h", line = 28,
 FQN="clang::DeltaTree", NM="_ZN5clang9DeltaTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZN5clang9DeltaTreeE")
//</editor-fold>
public class DeltaTree implements Destructors.ClassWithDestructor {
  private Object/*void P*/ Root; // "DeltaTreeNode *"
  //<editor-fold defaultstate="collapsed" desc="clang::DeltaTree::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/DeltaTree.h", line = 30,
   FQN="clang::DeltaTree::operator=", NM="_ZN5clang9DeltaTreeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZN5clang9DeltaTreeaSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ DeltaTree /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DeltaTree::DeltaTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 387,
   FQN="clang::DeltaTree::DeltaTree", NM="_ZN5clang9DeltaTreeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZN5clang9DeltaTreeC1Ev")
  //</editor-fold>
  public DeltaTree() {
    Root = new DeltaTreeNode();
  }

  
  // Note: Currently we only support copying when the RHS is empty.
  //<editor-fold defaultstate="collapsed" desc="clang::DeltaTree::DeltaTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 390,
   FQN="clang::DeltaTree::DeltaTree", NM="_ZN5clang9DeltaTreeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZN5clang9DeltaTreeC1ERKS0_")
  //</editor-fold>
  public DeltaTree(/*const*/ DeltaTree /*&*/ RHS) {
    // Currently we only support copying when the RHS is empty.
    assert (getRoot(RHS.Root).getNumValuesUsed() == 0) : "Can only copy empty tree";
    Root = new DeltaTreeNode();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeltaTree::~DeltaTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 397,
   FQN="clang::DeltaTree::~DeltaTree", NM="_ZN5clang9DeltaTreeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZN5clang9DeltaTreeD0Ev")
  //</editor-fold>
  public void $destroy() {
    getRoot(Root).Destroy();
  }

  
  /// getDeltaAt - Return the accumulated delta at the specified file offset.
  /// This includes all insertions or delections that occurred *before* the
  /// specified file index.
  
  /// getDeltaAt - Return the accumulated delta at the specified file offset.
  /// This includes all insertions or delections that occurred *before* the
  /// specified file index.
  //<editor-fold defaultstate="collapsed" desc="clang::DeltaTree::getDeltaAt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 404,
   FQN="clang::DeltaTree::getDeltaAt", NM="_ZNK5clang9DeltaTree10getDeltaAtEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZNK5clang9DeltaTree10getDeltaAtEj")
  //</editor-fold>
  public int getDeltaAt(/*uint*/int FileIndex) /*const*/ {
    /*const*/ DeltaTreeNode /*P*/ Node = getRoot(Root);
    
    int Result = 0;
    
    // Walk down the tree.
    while (true) {
      // For all nodes, include any local deltas before the specified file
      // index by summing them up directly.  Keep track of how many were
      // included.
      /*uint*/int NumValsGreater = 0;
      for (/*uint*/int e = Node.getNumValuesUsed(); NumValsGreater != e;
           ++NumValsGreater) {
        /*const*/ SourceDelta /*&*/ Val = Node.getValue$Const(NumValsGreater);
        if ($greatereq_uint(Val.FileLoc, FileIndex)) {
          break;
        }
        Result += Val.Delta;
      }
      
      // If we have an interior node, include information about children and
      // recurse.  Otherwise, if we have a leaf, we're done.
      /*const*/ DeltaTreeInteriorNode /*P*/ IN = dyn_cast(DeltaTreeInteriorNode.class, Node);
      if (!(IN != null)) {
        return Result;
      }
      
      // Include any children to the left of the values we skipped, all of
      // their deltas should be included as well.
      for (/*uint*/int i = 0; i != NumValsGreater; ++i)  {
        Result += IN.getChild$Const(i).getFullDelta();
      }
      
      // If we found exactly the value we were looking for, break off the
      // search early.  There is no need to search the RHS of the value for
      // partial results.
      if (NumValsGreater != Node.getNumValuesUsed()
         && Node.getValue$Const(NumValsGreater).FileLoc == FileIndex) {
        return Result + IN.getChild$Const(NumValsGreater).getFullDelta();
      }
      
      // Otherwise, traverse down the tree.  The selected subtree may be
      // partially included in the range.
      Node = IN.getChild$Const(NumValsGreater);
    }
    // NOT REACHED.
  }

  
  /// AddDelta - When a change is made that shifts around the text buffer,
  /// this method is used to record that info.  It inserts a delta of 'Delta'
  /// into the current DeltaTree at offset FileIndex.
  
  /// AddDelta - When a change is made that shifts around the text buffer,
  /// this method is used to record that info.  It inserts a delta of 'Delta'
  /// into the current DeltaTree at offset FileIndex.
  //<editor-fold defaultstate="collapsed" desc="clang::DeltaTree::AddDelta">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp", line = 451,
   FQN="clang::DeltaTree::AddDelta", NM="_ZN5clang9DeltaTree8AddDeltaEji",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/DeltaTree.cpp -nm=_ZN5clang9DeltaTree8AddDeltaEji")
  //</editor-fold>
  public void AddDelta(/*uint*/int FileIndex, int Delta) {
    assert ((Delta != 0)) : "Adding a noop?";
    DeltaTreeNode /*P*/ MyRoot = getRoot(Root);
    
    DeltaTreeNode.InsertResult InsertRes/*J*/= new DeltaTreeNode.InsertResult();
    if (MyRoot.DoInsertion(FileIndex, Delta, /*AddrOf*/InsertRes)) {
      Root = MyRoot = new DeltaTreeInteriorNode(InsertRes);
    }
  }

  
  @Override public String toString() {
    return "" + "Root=" + Root; // NOI18N
  }
}
