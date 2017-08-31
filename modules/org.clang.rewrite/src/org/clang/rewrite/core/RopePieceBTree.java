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
import org.clang.rewrite.impl.*;
import static org.clang.rewrite.impl.RewriteRopeStatics.getRoot;


//===--------------------------------------------------------------------===//
// RopePieceBTree Class
//===--------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTree">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 137,
 FQN="clang::RopePieceBTree", NM="_ZN5clang14RopePieceBTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang14RopePieceBTreeE")
//</editor-fold>
public class RopePieceBTree implements Destructors.ClassWithDestructor {
  private Object/*void P*/ Root;
  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTree::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 139,
   FQN="clang::RopePieceBTree::operator=", NM="_ZN5clang14RopePieceBTreeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang14RopePieceBTreeaSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ RopePieceBTree /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTree::RopePieceBTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 717,
   FQN="clang::RopePieceBTree::RopePieceBTree", NM="_ZN5clang14RopePieceBTreeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang14RopePieceBTreeC1Ev")
  //</editor-fold>
  public RopePieceBTree() {
    Root = new RopePieceBTreeLeaf();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTree::RopePieceBTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 720,
   FQN="clang::RopePieceBTree::RopePieceBTree", NM="_ZN5clang14RopePieceBTreeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang14RopePieceBTreeC1ERKS0_")
  //</editor-fold>
  public RopePieceBTree(/*const*/ RopePieceBTree /*&*/ RHS) {
    assert ((RHS.empty() != 0)) : "Can't copy non-empty tree yet";
    Root = new RopePieceBTreeLeaf();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTree::~RopePieceBTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 724,
   FQN="clang::RopePieceBTree::~RopePieceBTree", NM="_ZN5clang14RopePieceBTreeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang14RopePieceBTreeD0Ev")
  //</editor-fold>
  public void $destroy() {
    getRoot(Root).Destroy();
  }

  
  /*typedef RopePieceBTreeIterator iterator*/
//  public final class iterator extends RopePieceBTreeIterator{ };
  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTree::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 146,
   FQN="clang::RopePieceBTree::begin", NM="_ZNK5clang14RopePieceBTree5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK5clang14RopePieceBTree5beginEv")
  //</editor-fold>
  public RopePieceBTreeIterator begin() /*const*/ {
    return new RopePieceBTreeIterator(Root);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTree::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 147,
   FQN="clang::RopePieceBTree::end", NM="_ZNK5clang14RopePieceBTree3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK5clang14RopePieceBTree3endEv")
  //</editor-fold>
  public RopePieceBTreeIterator end() /*const*/ {
    return new RopePieceBTreeIterator();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTree::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 728,
   FQN="clang::RopePieceBTree::size", NM="_ZNK5clang14RopePieceBTree4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK5clang14RopePieceBTree4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return getRoot(Root).size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTree::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 149,
   FQN="clang::RopePieceBTree::empty", NM="_ZNK5clang14RopePieceBTree5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK5clang14RopePieceBTree5emptyEv")
  //</editor-fold>
  public /*uint*/int empty() /*const*/ {
    return ((size() == 0) ? 1 : 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTree::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 732,
   FQN="clang::RopePieceBTree::clear", NM="_ZN5clang14RopePieceBTree5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang14RopePieceBTree5clearEv")
  //</editor-fold>
  public void clear() {
    {
      RopePieceBTreeLeaf /*P*/ Leaf = dyn_cast(RopePieceBTreeLeaf.class, getRoot(Root));
      if ((Leaf != null)) {
        Leaf.clear();
      } else {
        getRoot(Root).Destroy();
        Root = new RopePieceBTreeLeaf();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTree::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 741,
   FQN="clang::RopePieceBTree::insert", NM="_ZN5clang14RopePieceBTree6insertEjRKNS_9RopePieceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang14RopePieceBTree6insertEjRKNS_9RopePieceE")
  //</editor-fold>
  public void insert(/*uint*/int Offset, /*const*/ RopePiece /*&*/ R) {
    {
      // #1. Split at Offset.
      RopePieceBTreeNode /*P*/ RHS = getRoot(Root).split(Offset);
      if ((RHS != null)) {
        Root = new RopePieceBTreeInterior(getRoot(Root), RHS);
      }
    }
    {
      
      // #2. Do the insertion.
      RopePieceBTreeNode /*P*/ RHS = getRoot(Root).insert(Offset, R);
      if ((RHS != null)) {
        Root = new RopePieceBTreeInterior(getRoot(Root), RHS);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTree::erase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 751,
   FQN="clang::RopePieceBTree::erase", NM="_ZN5clang14RopePieceBTree5eraseEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang14RopePieceBTree5eraseEjj")
  //</editor-fold>
  public void erase(/*uint*/int Offset, /*uint*/int NumBytes) {
    {
      // #1. Split at Offset.
      RopePieceBTreeNode /*P*/ RHS = getRoot(Root).split(Offset);
      if ((RHS != null)) {
        Root = new RopePieceBTreeInterior(getRoot(Root), RHS);
      }
    }
    
    // #2. Do the erasing.
    getRoot(Root).erase(Offset, NumBytes);
  }

  
  @Override public String toString() {
    return "" + "Root=" + Root; // NOI18N
  }
}
