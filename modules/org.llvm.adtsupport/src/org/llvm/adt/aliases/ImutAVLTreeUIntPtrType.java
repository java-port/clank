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

package org.llvm.adt.aliases;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.*;

/*template <typename ImutInfo> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 37,
 FQN="llvm::ImutAVLTree", NM="_ZN4llvm11ImutAVLTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm11ImutAVLTreeE")
//</editor-fold>
public class ImutAVLTreeUIntPtrType</*typename ImutInfo*/ DataT, ValT> extends NativeTrace.CreateDestroy$Tracker {
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private final ImutAVLTreeInfoUIntPtrType<DataT, ValT> ImutInfo;

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public ImutAVLTreeUIntPtrType(ImutAVLTreeInfoUIntPtrType<DataT, ValT> ImutInfo) {
    this.ImutInfo = ImutInfo;
  }
  
/*public:*/
  /*typedef typename ImutInfo::key_type_ref key_type_ref*/
//  public final class key_type_ref extends K{ };
  /*typedef typename ImutInfo::value_type value_type*/
//  public final class value_type extends std.pair<K, V>{ };
  /*typedef typename ImutInfo::value_type_ref value_type_ref*/
//  public final class value_type_ref extends std.pair<K, V>{ };
  
  /*typedef ImutAVLFactory<ImutInfo> Factory*/
//  public final class Factory extends ImutAVLFactory<ImutInfo>{ };
  /*friend  class ImutAVLFactory<ImutInfo>*/
  /*friend  class ImutIntervalAVLFactory<ImutInfo>*/
  
  /*friend  class ImutAVLTreeGenericIterator<ImutInfo>*/
  
  /*typedef ImutAVLTreeInOrderIterator<K, V> iterator*/
//  public final class iterator extends ImutAVLTreeInOrderIterator<K, V>{ };
  
  //===----------------------------------------------------===//
  // Public Interface.
  //===----------------------------------------------------===//
  
  /// Return a pointer to the left subtree.  This value
  ///  is NULL if there is no left subtree.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::getLeft">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 58,
   FQN="llvm::ImutAVLTree::getLeft", NM="_ZNK4llvm11ImutAVLTree7getLeftEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm11ImutAVLTree7getLeftEv")
  //</editor-fold>
  public ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ getLeft() /*const*/ {
    assert checkAlive();
    return left;
  }

  
  /// Return a pointer to the right subtree.  This value is
  ///  NULL if there is no right subtree.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::getRight">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 62,
   FQN="llvm::ImutAVLTree::getRight", NM="_ZNK4llvm11ImutAVLTree8getRightEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm11ImutAVLTree8getRightEv")
  //</editor-fold>
  public ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ getRight() /*const*/ {
    assert checkAlive();
    return right;
  }

  
  /// getHeight - Returns the height of the tree.  A tree with no subtrees
  ///  has a height of 1.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::getHeight">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 66,
   FQN="llvm::ImutAVLTree::getHeight", NM="_ZNK4llvm11ImutAVLTree9getHeightEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm11ImutAVLTree9getHeightEv")
  //</editor-fold>
  public /*uint*/int getHeight() /*const*/ {
    assert checkAlive();
    return height;
  }

  
  /// getValue - Returns the data value associated with the tree node.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 69,
   FQN="llvm::ImutAVLTree::getValue", NM="_ZNK4llvm11ImutAVLTree8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm11ImutAVLTree8getValueEv")
  //</editor-fold>
  public /*const*/ValT/*&*/ getValue() /*const*/ {
    assert checkAlive();
    return value;
  }

  
  /// find - Finds the subtree associated with the specified key value.
  ///  This method returns NULL if no matching subtree is found.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::find">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 73,
   FQN="llvm::ImutAVLTree::find", NM="_ZN4llvm11ImutAVLTree4findENT_12key_type_refE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm11ImutAVLTree4findENT_12key_type_refE")
  //</editor-fold>
  public ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ find(/*uint*/int $K) {
    assert checkAlive();
    ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ T = this;
    while (T != null) {
      /*uint*/int CurrentKey = ImutInfo.KeyOfValue(T.getValue());
      if (ImutInfo.isEqual($K, CurrentKey)) {
        return T;
      } else if (ImutInfo.isLess($K, CurrentKey)) {
        T = T.getLeft();
      } else {
        T = T.getRight();
      }
    }
    return null;
  }

  
  /// getMaxElement - Find the subtree associated with the highest ranged
  ///  key value.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::getMaxElement">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 89,
   FQN="llvm::ImutAVLTree::getMaxElement", NM="_ZN4llvm11ImutAVLTree13getMaxElementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm11ImutAVLTree13getMaxElementEv")
  //</editor-fold>
  public ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ getMaxElement() {
    assert checkAlive();
    ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ T = this;
    ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ Right = T.getRight();
    while (Right != null) {
      T = Right;
      Right = T.getRight();
    }
    return T;
  }

  
  /// size - Returns the number of nodes in the tree, which includes
  ///  both leaves and non-leaf nodes.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::size">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 98,
   FQN="llvm::ImutAVLTree::size", NM="_ZNK4llvm11ImutAVLTree4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm11ImutAVLTree4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    assert checkAlive();
    /*uint*/int n = 1;
    {
      /*const*/ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ L = getLeft();
      if (L != null) {
        n += L.size();
      }
    }
    {
      /*const*/ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ R = getRight();
      if (R != null) {
        n += R.size();
      }
    }
    return n;
  }

  
  /// begin - Returns an iterator that iterates over the nodes of the tree
  ///  in an inorder traversal.  The returned iterator thus refers to the
  ///  the tree node with the minimum data element.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 110,
   FQN="llvm::ImutAVLTree::begin", NM="_ZNK4llvm11ImutAVLTree5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm11ImutAVLTree5beginEv")
  //</editor-fold>
  public ImutAVLTreeInOrderIteratorUIntPtrType<DataT, ValT> begin() /*const*/ {
    assert checkAlive();
    return new ImutAVLTreeInOrderIteratorUIntPtrType<DataT, ValT>(this);
  }

  
  /// end - Returns an iterator for the tree that denotes the end of an
  ///  inorder traversal.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 114,
   FQN="llvm::ImutAVLTree::end", NM="_ZNK4llvm11ImutAVLTree3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm11ImutAVLTree3endEv")
  //</editor-fold>
  public ImutAVLTreeInOrderIteratorUIntPtrType<DataT, ValT> end() /*const*/ {
    assert checkAlive();
    return new ImutAVLTreeInOrderIteratorUIntPtrType<DataT, ValT>();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::isElementEqual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 116,
   FQN="llvm::ImutAVLTree::isElementEqual", NM="_ZNK4llvm11ImutAVLTree14isElementEqualENT_14value_type_refE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm11ImutAVLTree14isElementEqualENT_14value_type_refE")
  //</editor-fold>
  public boolean isElementEqual(ValT V) /*const*/ {
    assert checkAlive();
    // Compare the keys.
    if (Native.$not(ImutInfo.isEqual(ImutInfo.KeyOfValue(getValue()), 
        ImutInfo.KeyOfValue(V)))) {
      return false;
    }
    
    // Also compare the data values.
    if (Native.$not(ImutInfo.isDataEqual(ImutInfo.DataOfValue(getValue()), 
        ImutInfo.DataOfValue(V)))) {
      return false;
    }
    
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::isElementEqual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 130,
   FQN="llvm::ImutAVLTree::isElementEqual", NM="_ZNK4llvm11ImutAVLTree14isElementEqualEPKNS_11ImutAVLTreeIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm11ImutAVLTree14isElementEqualEPKNS_11ImutAVLTreeIT_EE")
  //</editor-fold>
  public boolean isElementEqual(/*const*/ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ RHS) /*const*/ {
    assert RHS.checkAlive();
    assert checkAlive();
    return isElementEqual(RHS.getValue());
  }

  
  /// isEqual - Compares two trees for structural equality and returns true
  ///   if they are equal.  This worst case performance of this operation is
  //    linear in the sizes of the trees.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 137,
   FQN="llvm::ImutAVLTree::isEqual", NM="_ZNK4llvm11ImutAVLTree7isEqualERKNS_11ImutAVLTreeIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm11ImutAVLTree7isEqualERKNS_11ImutAVLTreeIT_EE")
  //</editor-fold>
  public boolean isEqual(final /*const*/ImutAVLTreeUIntPtrType<DataT, ValT>/*&*/ RHS) /*const*/ {
    assert RHS.checkAlive();
    assert checkAlive();
    if (RHS == this) {
      return true;
    }
    
    ImutAVLTreeInOrderIteratorUIntPtrType<DataT, ValT> LItr = begin();
    ImutAVLTreeInOrderIteratorUIntPtrType<DataT, ValT> LEnd = end();
    ImutAVLTreeInOrderIteratorUIntPtrType<DataT, ValT> RItr = RHS.begin();
    ImutAVLTreeInOrderIteratorUIntPtrType<DataT, ValT> REnd = RHS.end();
    while (Native.$bool(Native.$noteq_iter(LItr, LEnd)) && Native.$bool(Native.$noteq_iter(RItr, REnd))) {
      if (/*AddrOf*/Native.$star(LItr) == /*AddrOf*/Native.$star(RItr)) {
        LItr.skipSubTree();
        RItr.skipSubTree();
        continue;
      }
      if (Native.$not(LItr.$arrow().isElementEqual(/*AddrOf*/RItr.$star()))) {
        return false;
      }
      
      LItr.$preInc();
      RItr.$preInc();
    }
    
    return Native.$bool(Native.$eq_iter(LItr, LEnd)) && Native.$bool(Native.$eq_iter(RItr, REnd));
  }

  
  /// isNotEqual - Compares two trees for structural inequality.  Performance
  ///  is the same is isEqual.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::isNotEqual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 163,
   FQN="llvm::ImutAVLTree::isNotEqual", NM="_ZNK4llvm11ImutAVLTree10isNotEqualERKNS_11ImutAVLTreeIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm11ImutAVLTree10isNotEqualERKNS_11ImutAVLTreeIT_EE")
  //</editor-fold>
  public boolean isNotEqual(final /*const*/ImutAVLTreeUIntPtrType<DataT, ValT>/*&*/ RHS) /*const*/ {
    assert RHS.checkAlive();
    assert checkAlive();
    return !(isEqual(RHS));
  }

  
  /// contains - Returns true if this tree contains a subtree (node) that
  ///  has an data element that matches the specified key.  Complexity
  ///  is logarithmic in the size of the tree.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::contains">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 168,
   FQN="llvm::ImutAVLTree::contains", NM="_ZN4llvm11ImutAVLTree8containsENT_12key_type_refE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm11ImutAVLTree8containsENT_12key_type_refE")
  //</editor-fold>
  public boolean contains(/*uint*/int $K) {
    assert checkAlive();
    return (boolean)(find($K) != null);
  }

  
  /// foreach - A member template the accepts invokes operator() on a functor
  ///  object (specifed by Callback) for every node/subtree in the tree.
  ///  Nodes are visited using an inorder traversal.
  /*template <typename Callback> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::foreach">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 174,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", old_line = 173,
   FQN="llvm::ImutAVLTree::foreach", NM="Tpl__ZN4llvm11ImutAVLTree7foreachERT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN4llvm11ImutAVLTree7foreachERT_")
  //</editor-fold>
  public void foreach(final Type2Void<ValT> /*&*/ C) {
    assert checkAlive();
    {
      ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ L = getLeft();
      if (L != null) {
        L.foreach(C);
      }
    }
    
    C.$call(value);
    {
      
      ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ R = getRight();
      if (R != null) {
        R.foreach(C);
      }
    }
  }

  
  /// validateTree - A utility method that checks that the balancing and
  ///  ordering invariants of the tree are satisifed.  It is a recursive
  ///  method that returns the height of the tree, which is then consumed
  ///  by the enclosing validateTree call.  External callers should ignore the
  ///  return value.  An invalid tree will cause an assertion to fire in
  ///  a debug build.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::validateTree">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 190,
   FQN="llvm::ImutAVLTree::validateTree", NM="_ZNK4llvm11ImutAVLTree12validateTreeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm11ImutAVLTree12validateTreeEv")
  //</editor-fold>
  public /*uint*/int validateTree() /*const*/ {
    assert checkAlive();
    /*uint*/int HL = getLeft() != null ? getLeft().validateTree() : 0;
    /*uint*/int HR = getRight() != null ? getRight().validateTree() : 0;
    ///*J:(void)*/HL;
    ///*J:(void)*/HR;
    assert Native.$bool(Native.$eq(getHeight(), ($greater_uint(HL, HR) ? HL : HR) + 1)) : "Height calculation wrong";
    assert ($lesseq_uint(($greater_uint(HL, HR) ? HL - HR : HR - HL), 2)) : "Balancing invariant violated";
    assert Native.$bool((Native.$not(getLeft()) || Native.$bool(ImutInfo.isLess(ImutInfo.KeyOfValue(getLeft().getValue()), ImutInfo.KeyOfValue(getValue()))))) : "Value in left child is not less that current value";
    assert Native.$bool(Native.$not((Native.$bool(getRight()) || Native.$bool(ImutInfo.isLess(ImutInfo.KeyOfValue(getValue()), ImutInfo.KeyOfValue(getRight().getValue())))))) : "Current value is not less that value of right child";
    
    return getHeight();
  }


  //===----------------------------------------------------===//
  // Internal values.
  //===----------------------------------------------------===//
  /*private:*/
  private ImutAVLFactoryUIntPtrType<DataT, ValT> /*P*/ factory;
  private ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ left;
  private ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ right;
  /*friend*/ ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ prev;
  /*friend*/ ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ next;
  
  private /*uint*/int height /*: 28*/;
  private /*JBIT unsigned int*/ boolean IsMutable /*: 1*/;
  private /*JBIT unsigned int*/ boolean IsDigestCached /*: 1*/;
  /*friend*/ /*JBIT unsigned int*/ boolean IsCanonicalized /*: 1*/;
  
  /*friend*/ ValT value;
  private /*uint32_t*/int digest;
  /*friend*/ /*uint32_t*/int refCount;

  //===----------------------------------------------------===//
  // Internal methods (node manipulation; used by Factory).
  //===----------------------------------------------------===//
  /*private:*/
  /// ImutAVLTree - Internal constructor that is only called by
  ///   ImutAVLFactory.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::ImutAVLTree<ImutInfo>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 243,
   FQN="llvm::ImutAVLTree::ImutAVLTree<ImutInfo>", NM="_ZN4llvm11ImutAVLTreeC1EPNS_14ImutAVLFactoryIT_EEPNS_11ImutAVLTreeIS2_EES8_NS2_14value_type_refEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm11ImutAVLTreeC1EPNS_14ImutAVLFactoryIT_EEPNS_11ImutAVLTreeIS2_EES8_NS2_14value_type_refEj")
  //</editor-fold>
  /*friend*/ ImutAVLTreeUIntPtrType<DataT, ValT> $ImutAVLTree(ImutAVLFactoryUIntPtrType<DataT, ValT> /*P*/ f, ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ l, ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ r, ValT v, 
      /*uint*/int height) {
    // : factory(f), left(l), right(r), prev(null), next(null), height(height), IsMutable(true), IsDigestCached(false), IsCanonicalized(0), value(v), digest(0), refCount(0) 
    //START JInit
    this.factory = /*ParenListExpr*/f;
    this.left = /*ParenListExpr*/l;
    this.right = /*ParenListExpr*/r;
    this.prev = /*ParenListExpr*/null;
    this.next = /*ParenListExpr*/null;
    this.height = height;
    this.IsMutable = true;
    this.IsDigestCached = false;
    this.IsCanonicalized = false;
    this.value = /*ParenListExpr*/$cloneIfNeeded(v);
    this.digest = 0;
    this.refCount = 0;
    //END JInit
    if (left != null) {
      left.retain();
    }
    if (right != null) {
      right.retain();
    }
    return this;
  }

  
  /// isMutable - Returns true if the left and right subtree references
  ///  (as well as height) can be changed.  If this method returns false,
  ///  the tree is truly immutable.  Trees returned from an ImutAVLFactory
  ///  object should always have this method return true.  Further, if this
  ///  method returns false for an instance of ImutAVLTree, all subtrees
  ///  will also have this method return false.  The converse is not true.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::isMutable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 259,
   FQN="llvm::ImutAVLTree::isMutable", NM="_ZNK4llvm11ImutAVLTree9isMutableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm11ImutAVLTree9isMutableEv")
  //</editor-fold>
  /*friend*/ boolean isMutable() /*const*/ {
    assert checkAlive();
    return IsMutable;
  }

  
  /// hasCachedDigest - Returns true if the digest for this tree is cached.
  ///  This can only be true if the tree is immutable.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::hasCachedDigest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 263,
   FQN="llvm::ImutAVLTree::hasCachedDigest", NM="_ZNK4llvm11ImutAVLTree15hasCachedDigestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm11ImutAVLTree15hasCachedDigestEv")
  //</editor-fold>
  private boolean hasCachedDigest() /*const*/ {
    assert checkAlive();
    return IsDigestCached;
  }

  
  //===----------------------------------------------------===//
  // Mutating operations.  A tree root can be manipulated as
  // long as its reference has not "escaped" from internal
  // methods of a factory object (see below).  When a tree
  // pointer is externally viewable by client code, the
  // internal "mutable bit" is cleared to mark the tree
  // immutable.  Note that a tree that still has its mutable
  // bit set may have children (subtrees) that are themselves
  // immutable.
  //===----------------------------------------------------===//
  
  /// markImmutable - Clears the mutable flag for a tree.  After this happens,
  ///   it is an error to call setLeft(), setRight(), and setHeight().
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::markImmutable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 278,
   FQN="llvm::ImutAVLTree::markImmutable", NM="_ZN4llvm11ImutAVLTree13markImmutableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm11ImutAVLTree13markImmutableEv")
  //</editor-fold>
  /*friend*/ void markImmutable() {
    assert checkAlive();
    assert Native.$bool(isMutable()) : "Mutable flag already removed.";
    IsMutable = false;
  }

  
  /// markedCachedDigest - Clears the NoCachedDigest flag for a tree.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::markedCachedDigest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 284,
   FQN="llvm::ImutAVLTree::markedCachedDigest", NM="_ZN4llvm11ImutAVLTree18markedCachedDigestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm11ImutAVLTree18markedCachedDigestEv")
  //</editor-fold>
  private void markedCachedDigest() {
    assert checkAlive();
    assert Native.$bool(Native.$not(hasCachedDigest())) : "NoCachedDigest flag already removed.";
    IsDigestCached = true;
  }

  
  /// setHeight - Changes the height of the tree.  Used internally by
  ///  ImutAVLFactory.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::setHeight">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 291,
   FQN="llvm::ImutAVLTree::setHeight", NM="_ZN4llvm11ImutAVLTree9setHeightEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm11ImutAVLTree9setHeightEj")
  //</editor-fold>
  private void setHeight(/*uint*/int h) {
    assert checkAlive();
    assert Native.$bool(isMutable()) : "Only a mutable tree can have its height changed.";
    height = h;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::computeDigest">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 296,
   FQN="llvm::ImutAVLTree::computeDigest", NM="_ZN4llvm11ImutAVLTree13computeDigestEPNS_11ImutAVLTreeIT_EES5_NS2_14value_type_refE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm11ImutAVLTree13computeDigestEPNS_11ImutAVLTreeIT_EES5_NS2_14value_type_refE")
  //</editor-fold>
  private int computeDigest(ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ L, ImutAVLTreeUIntPtrType<DataT, ValT>/*P*/ R, 
               ValT V) {
    assert checkAlive();
    /*uint32_t*/int digest = 0;
    if (L != null) {
      digest += L.computeDigest();
    }
    
    // Compute digest of stored data.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ImutInfo.Profile(ID, V);
    digest += ID.ComputeHash();
    if (R != null) {
      digest += R.computeDigest();
    }
    
    return digest;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::computeDigest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 314,
   FQN="llvm::ImutAVLTree::computeDigest", NM="_ZN4llvm11ImutAVLTree13computeDigestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm11ImutAVLTree13computeDigestEv")
  //</editor-fold>
  /*friend*/ /*uint32_t*/int computeDigest() {
    assert checkAlive();
    // Check the lowest bit to determine if digest has actually been
    // pre-computed.
    if (hasCachedDigest()) {
      return digest;
    }
    
    /*uint32_t*/int X = computeDigest(getLeft(), getRight(), getValue());
    digest = X;
    markedCachedDigest();
    return X;
  }


  //===----------------------------------------------------===//
  // Reference count operations.
  //===----------------------------------------------------===//
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::retain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 331,
   FQN="llvm::ImutAVLTree::retain", NM="_ZN4llvm11ImutAVLTree6retainEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm11ImutAVLTree6retainEv")
  //</editor-fold>
  public void retain() {
    assert checkAlive();
    ++refCount;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::release">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 332,
   FQN="llvm::ImutAVLTree::release", NM="_ZN4llvm11ImutAVLTree7releaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm11ImutAVLTree7releaseEv")
  //</editor-fold>
  public void release() {
    assert checkAlive();
    assert Native.$bool(Native.$greater(refCount, 0)) : "Already released " + this.getClass();
    if (Native.$eq(--refCount, 0)) {
      destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTree::destroy">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 337,
   FQN="llvm::ImutAVLTree::destroy", NM="_ZN4llvm11ImutAVLTree7destroyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm11ImutAVLTree7destroyEv")
  //</editor-fold>
  public void destroy() {
    assert checkAlive();
    if (left != null) {
      left.release();
    }
    if (right != null) {
      right.release();
    }
    if (IsCanonicalized) {
      if (next != null) {
        next.prev = prev;
      }
      if (prev != null) {
        prev.next = next;
      } else {
        factory.Cache.$set(factory.maskCacheIndex(computeDigest()), next);
      }
    }
    
    // We need to clear the mutability bit in case we are
    // destroying the node as part of a sweep in ImutAVLFactory::recoverNodes().
    IsMutable = false;
    super.set$destroyed();
    factory.pushBackDestroyedNode(this);
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private ValT $cloneIfNeeded(ValT V) {
    assert checkAlive();
    return Native.$tryClone(V);
  }
  
  @Override public String toString() {
    return (super.is$destroyed() ? "DESTROYED ":"")
//              + "factory=" + factory // NOI18N
//              + ", left=" + left // NOI18N
//              + ", right=" + right // NOI18N
//              + ", prev=" + prev // NOI18N
//              + ", next=" + next // NOI18N
              + ", height=" + height // NOI18N
              + ", IsMutable=" + IsMutable // NOI18N
              + ", IsDigestCached=" + IsDigestCached // NOI18N
              + ", IsCanonicalized=" + IsCanonicalized // NOI18N
              + ", value=" + value // NOI18N
              + ", digest=" + digest // NOI18N
              + ", refCount=" + refCount; // NOI18N
  }
  
  protected final boolean checkAlive() {
    return check$Alive();
  }    
  
  protected final boolean is$Destroyed() {
    return is$destroyed();
  }    

  final void reset$Destroyed() {
    assert is$destroyed();
    super.clear$destroyed();
  }    
}
