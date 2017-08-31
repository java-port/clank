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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.rewrite.impl.*;
import static org.clang.rewrite.impl.RewriteRopeStatics.getCN;


//===--------------------------------------------------------------------===//
// RopePieceBTreeIterator Class
//===--------------------------------------------------------------------===//

/// RopePieceBTreeIterator - This class provides read-only forward iteration
/// over bytes that are in a RopePieceBTree.  This first iterates over bytes
/// in a RopePiece, then iterates over RopePiece's in a RopePieceBTreeLeaf,
/// then iterates over RopePieceBTreeLeaf's in a RopePieceBTree.
//<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTreeIterator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 88,
 FQN="clang::RopePieceBTreeIterator", NM="_ZN5clang22RopePieceBTreeIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang22RopePieceBTreeIteratorE")
//</editor-fold>
public class RopePieceBTreeIterator implements /*public*/ char$iterator<RopePieceBTreeIterator> {
  /// CurNode - The current B+Tree node that we are inspecting.
  private /*const*/Object/*void P*/ CurNode;
  /// CurPiece - The current RopePiece in the B+Tree node that we're
  /// inspecting.
  private /*const*/ type$ptr<RopePiece> /*P*/ CurPiece;
  /// CurChar - The current byte in the RopePiece we are pointing to.
  private /*uint*/int CurChar;
/*public:*/
  // begin iterator.
  
  // begin iterator.
  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTreeIterator::RopePieceBTreeIterator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 668,
   FQN="clang::RopePieceBTreeIterator::RopePieceBTreeIterator", NM="_ZN5clang22RopePieceBTreeIteratorC1EPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang22RopePieceBTreeIteratorC1EPKv")
  //</editor-fold>
  public RopePieceBTreeIterator(/*const*/Object/*void P*/ n) {
    // : std::iterator<std::forward_iterator_tag, const char, ptrdiff_t>() 
    //START JInit
    $iterator();
    //END JInit
    /*const*/ RopePieceBTreeNode /*P*/ N = ((/*static_cast*//*const*/ RopePieceBTreeNode /*P*/ )(n));
    {
      
      // Walk down the left side of the tree until we get to a leaf.
      /*const*/ RopePieceBTreeInterior /*P*/ IN;
      while (((/*P*/ IN = dyn_cast(RopePieceBTreeInterior.class, N)) != null)) {
        N = IN.getChild$Const(0);
      }
    }
    
    // We must have at least one leaf.
    CurNode = cast(RopePieceBTreeLeaf.class, N);
    
    // If we found a leaf that happens to be empty, skip over it until we get
    // to something full.
    while ((CurNode != null) && getCN(CurNode).getNumPieces() == 0) {
      CurNode = getCN(CurNode).getNextLeafInOrder();
    }
    if ((CurNode != null)) {
      CurPiece = /*AddrOf*/getCN(CurNode).getPiece(0);
    } else { // Empty tree, this is an end() iterator.
      CurPiece = null;
    }
    CurChar = 0;
  }

  // end iterator
  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTreeIterator::RopePieceBTreeIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 101,
   FQN="clang::RopePieceBTreeIterator::RopePieceBTreeIterator", NM="_ZN5clang22RopePieceBTreeIteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang22RopePieceBTreeIteratorC1Ev")
  //</editor-fold>
  public RopePieceBTreeIterator() {
    // : std::iterator<std::forward_iterator_tag, const char, ptrdiff_t>(), CurNode(null), CurPiece(null), CurChar(0) 
    //START JInit
    $iterator();
    this.CurNode = null;
    this.CurPiece = null;
    this.CurChar = 0;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTreeIterator::operator*">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 104,
   FQN="clang::RopePieceBTreeIterator::operator*", NM="_ZNK5clang22RopePieceBTreeIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK5clang22RopePieceBTreeIteratordeEv")
  //</editor-fold>
  public /*char*/byte $star() /*const*/ {
    return (/*Deref*/CurPiece.$star()).$at$Const(CurChar).$deref();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTreeIterator::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 108,
   FQN="clang::RopePieceBTreeIterator::operator==", NM="_ZNK5clang22RopePieceBTreeIteratoreqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK5clang22RopePieceBTreeIteratoreqERKS0_")
  //</editor-fold>
  public boolean $eq(/*const*/ RopePieceBTreeIterator /*&*/ RHS) /*const*/ {
    return $eq_ptr(CurPiece, RHS.CurPiece) && CurChar == RHS.CurChar;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTreeIterator::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 111,
   FQN="clang::RopePieceBTreeIterator::operator!=", NM="_ZNK5clang22RopePieceBTreeIteratorneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK5clang22RopePieceBTreeIteratorneERKS0_")
  //</editor-fold>
  public boolean $noteq(/*const*/ RopePieceBTreeIterator /*&*/ RHS) /*const*/ {
    return !$eq(RHS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTreeIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 115,
   FQN="clang::RopePieceBTreeIterator::operator++", NM="_ZN5clang22RopePieceBTreeIteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang22RopePieceBTreeIteratorppEv")
  //</editor-fold>
  public RopePieceBTreeIterator /*&*/ $preInc() {
    // Preincrement
    if ($less_uint(CurChar + 1, CurPiece.$star().size())) {
      ++CurChar;
    } else {
      MoveToNextPiece();
    }
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTreeIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 122,
   FQN="clang::RopePieceBTreeIterator::operator++", NM="_ZN5clang22RopePieceBTreeIteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang22RopePieceBTreeIteratorppEi")
  //</editor-fold>
  public /*inline*/ RopePieceBTreeIterator $postInc(int $Prm0) {
    // Postincrement
    RopePieceBTreeIterator tmp = new RopePieceBTreeIterator(/*Deref*/this);
    /*Deref*/this.$preInc();
    return tmp;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTreeIterator::piece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 126,
   FQN="clang::RopePieceBTreeIterator::piece", NM="_ZNK5clang22RopePieceBTreeIterator5pieceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK5clang22RopePieceBTreeIterator5pieceEv")
  //</editor-fold>
  public StringRef piece() /*const*/ {
    return new StringRef(/*AddrOf*/(/*Deref*/CurPiece.$star()).$at$Const(0).deref$ptr(), CurPiece.$star().size());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTreeIterator::MoveToNextPiece">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 690,
   FQN="clang::RopePieceBTreeIterator::MoveToNextPiece", NM="_ZN5clang22RopePieceBTreeIterator15MoveToNextPieceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang22RopePieceBTreeIterator15MoveToNextPieceEv")
  //</editor-fold>
  public void MoveToNextPiece() {
    if ($noteq_ptr(CurPiece, /*AddrOf*/getCN(CurNode).getPiece(getCN(CurNode).getNumPieces() - 1))) {
      CurChar = 0;
      CurPiece.$preInc();
      return;
    }
    
    // Find the next non-empty leaf node.
    do  {
      CurNode = getCN(CurNode).getNextLeafInOrder();
    } while ((CurNode != null) && getCN(CurNode).getNumPieces() == 0);
    if ((CurNode != null)) {
      CurPiece = /*AddrOf*/getCN(CurNode).getPiece(0);
    } else { // Hit end().
      CurPiece = null;
    }
    CurChar = 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTreeIterator::RopePieceBTreeIterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 88,
   FQN="clang::RopePieceBTreeIterator::RopePieceBTreeIterator", NM="_ZN5clang22RopePieceBTreeIteratorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang22RopePieceBTreeIteratorC1ERKS0_")
  //</editor-fold>
  public /*inline*/ RopePieceBTreeIterator(/*const*/ RopePieceBTreeIterator /*&*/ $Prm0) {
    // : std::iterator<std::forward_iterator_tag, const char, ptrdiff_t>(), CurNode(.CurNode), CurPiece(.CurPiece), CurChar(.CurChar) 
    //START JInit
    $iterator($Prm0);
    this.CurNode = $Prm0.CurNode;
    this.CurPiece = $tryClone($Prm0.CurPiece);
    this.CurChar = $Prm0.CurChar;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTreeIterator::RopePieceBTreeIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 88,
   FQN="clang::RopePieceBTreeIterator::RopePieceBTreeIterator", NM="_ZN5clang22RopePieceBTreeIteratorC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang22RopePieceBTreeIteratorC1EOS0_")
  //</editor-fold>
  public /*inline*/ RopePieceBTreeIterator(JD$Move _dparam, RopePieceBTreeIterator /*&&*/$Prm0) {
    // : std::iterator<std::forward_iterator_tag, const char, ptrdiff_t>(static_cast<RopePieceBTreeIterator &&>()), CurNode(static_cast<RopePieceBTreeIterator &&>().CurNode), CurPiece(static_cast<RopePieceBTreeIterator &&>().CurPiece), CurChar(static_cast<RopePieceBTreeIterator &&>().CurChar) 
    //START JInit
    $iterator(JD$Move.INSTANCE, $Prm0);
    this.CurNode = $Prm0.CurNode;
    this.CurPiece = $Prm0.CurPiece;
    this.CurChar = $Prm0.CurChar;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::RopePieceBTreeIterator::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 88,
   FQN="clang::RopePieceBTreeIterator::operator=", NM="_ZN5clang22RopePieceBTreeIteratoraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang22RopePieceBTreeIteratoraSERKS0_")
  //</editor-fold>
  public /*inline*/ RopePieceBTreeIterator /*&*/ $assign(/*const*/ RopePieceBTreeIterator /*&*/ $Prm0) {
    //JAVA: /*Deref*/this.$assign($Prm0);
    this.CurNode = $Prm0.CurNode;
    this.CurPiece = $tryClone($Prm0.CurPiece);
    this.CurChar = $Prm0.CurChar;
    return /*Deref*/this;
  }

  @Override public RopePieceBTreeIterator clone() {
    return new RopePieceBTreeIterator(this);
  }

  @Override
  public boolean $eq(Object other) {
    return $eq((RopePieceBTreeIterator)other);
  }
  
  @Override
  public boolean $noteq(Object other) {
    return $noteq((RopePieceBTreeIterator)other);
  }

  @Override
  public int $sub(RopePieceBTreeIterator iter) {
    return std.distance(iter, this, JD$FAKE.TRAILING);
  }

  @Override
  public RopePieceBTreeIterator $add(int amount) {
    RopePieceBTreeIterator tmp = new RopePieceBTreeIterator(/*Deref*/this);    
    return tmp.$inc(amount);
  }

  @Override
  public RopePieceBTreeIterator $inc(int amount) {
    for (int i = 0; i < amount; ++i) {
      $preInc();
    }
    return this;
  }
  
  private void $iterator() { }
  private void $iterator(Object dummy) { }
  private void $iterator(JD$Move _dparm, Object dummy) { }
  
  @Override public String toString() {
    return "" + "CurNode=" + CurNode // NOI18N
              + ", CurPiece=" + CurPiece // NOI18N
              + ", CurChar=" + CurChar // NOI18N
              + super.toString(); // NOI18N
  }

}
