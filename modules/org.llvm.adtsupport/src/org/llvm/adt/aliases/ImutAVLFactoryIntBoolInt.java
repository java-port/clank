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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;


//===----------------------------------------------------------------------===//
// Immutable AVL-Tree Factory class.
//===----------------------------------------------------------------------===//
/*template <typename ImutInfo> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 363,
 FQN="llvm::ImutAVLFactory", NM="_ZN4llvm14ImutAVLFactoryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14ImutAVLFactoryE")
//</editor-fold>
public class ImutAVLFactoryIntBoolInt  implements Destructors.ClassWithDestructor {
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private final ImutAVLTreeInfoIntBoolInt ImutInfo;
  
  /*friend  class ImutAVLTree<ImutInfo>*/
  /*typedef ImutAVLTree<ImutInfo> TreeTy*/
//  public final class TreeTy extends ImutAVLTreeIntBoolInt{ };
  /*typedef typename TreeTy::value_type_ref value_type_ref*/
//  public final class value_type_ref extends int{ };
  /*typedef typename TreeTy::key_type_ref key_type_ref*/
//  public final class key_type_ref extends _Kt{ };
  
  /*typedef DenseMap<unsigned int, TreeTy *> CacheTy*/
//  public final class CacheTy extends DenseMap</*uint*/int, ImutAVLTreeIntBoolInt/*P*/ >{ };
  
  /*friend*/ DenseMapUIntType<ImutAVLTreeIntBoolInt/*P*/ > Cache;
  private PointerBoolPair<Object>/*uintptr_t*/ Allocator;
  private std.vector<ImutAVLTreeIntBoolInt/*P*/ > createdNodes;
  /*friend*/ std.vector<ImutAVLTreeIntBoolInt/*P*/ > freeNodes;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::ownsAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 377,
   FQN="llvm::ImutAVLFactory::ownsAllocator", NM="_ZNK4llvm14ImutAVLFactory13ownsAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14ImutAVLFactory13ownsAllocatorEv")
  //</editor-fold>
  private boolean ownsAllocator() /*const*/ {
    return Allocator.getBool() ? false : true; // Allocator & 0x1 ? false : true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::getAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 381,
   FQN="llvm::ImutAVLFactory::getAllocator", NM="_ZNK4llvm14ImutAVLFactory12getAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14ImutAVLFactory12getAllocatorEv")
  //</editor-fold>
  /*TODO: change to package */public BumpPtrAllocatorImpl /*&*/ getAllocator() /*const*/ {
    return /*Deref*/reinterpret_cast(BumpPtrAllocatorImpl /*P*/ .class, Allocator.getPointer() /*& ~0x1*/);
  }


  //===--------------------------------------------------===//
  // Public interface.
  //===--------------------------------------------------===//
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::ImutAVLFactory<ImutInfo>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 390,
   FQN="llvm::ImutAVLFactory::ImutAVLFactory<ImutInfo>", NM="_ZN4llvm14ImutAVLFactoryC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14ImutAVLFactoryC1Ev")
  //</editor-fold>
  public ImutAVLFactoryIntBoolInt(ImutAVLTreeInfoIntBoolInt ImutInfo) {
    // : Allocator(reinterpret_cast<uintptr_t>(new BumpPtrAllocator())) 
    //START JInit
    this.Cache = new DenseMapUIntType<>(DenseMapInfoUInt.$Info(), (ImutAVLTreeIntBoolInt/*P*/ ) null);
    this.createdNodes = new std.vector<>((ImutAVLTreeIntBoolInt/*P*/) null);
    this.freeNodes = new std.vector<>((ImutAVLTreeIntBoolInt/*P*/) null);
    this.Allocator = new PointerBoolPair<>(reinterpret_cast_Object/*uintptr_t*/(new BumpPtrAllocatorImpl()), false);
    //END JInit
    this.ImutInfo = ImutInfo;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::ImutAVLFactory<ImutInfo>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 393,
   FQN="llvm::ImutAVLFactory::ImutAVLFactory<ImutInfo>", NM="_ZN4llvm14ImutAVLFactoryC1ERNS_20BumpPtrAllocatorImplINS_15MallocAllocatorELj4096ELj4096EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14ImutAVLFactoryC1ERNS_20BumpPtrAllocatorImplINS_15MallocAllocatorELj4096ELj4096EEE")
  //</editor-fold>
  public ImutAVLFactoryIntBoolInt(ImutAVLTreeInfoIntBoolInt ImutInfo, final BumpPtrAllocatorImpl /*&*/ Alloc) {
    // : Allocator(reinterpret_cast<uintptr_t>(&Alloc) | 0x1) 
    //START JInit
    this.Cache = new DenseMapUIntType<>(DenseMapInfoUInt.$Info(), (ImutAVLTreeIntBoolInt/*P*/ ) null);
    this.createdNodes = new std.vector<>((ImutAVLTreeIntBoolInt/*P*/) null);
    this.freeNodes = new std.vector<>((ImutAVLTreeIntBoolInt/*P*/) null);
    this.Allocator = new PointerBoolPair<>(reinterpret_cast_Object/*uintptr_t*/(/*AddrOf*/Alloc), true);
    //END JInit
    this.ImutInfo = ImutInfo;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::~ImutAVLFactory<ImutInfo>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 396,
   FQN="llvm::ImutAVLFactory::~ImutAVLFactory<ImutInfo>", NM="_ZN4llvm14ImutAVLFactoryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14ImutAVLFactoryD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (ownsAllocator()) {
      /*delete*/Destructors.$destroy(/*AddrOf*/getAllocator());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 400,
   FQN="llvm::ImutAVLFactory::add", NM="_ZN4llvm14ImutAVLFactory3addEPNS_11ImutAVLTreeIT_EENS3_14value_type_refE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14ImutAVLFactory3addEPNS_11ImutAVLTreeIT_EENS3_14value_type_refE")
  //</editor-fold>
  public ImutAVLTreeIntBoolInt/*P*/ add(ImutAVLTreeIntBoolInt/*P*/ T, int V) {
    T = add_internal(V, T);
    markImmutable(T);
    recoverNodes();
    return T;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::remove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 407,
   FQN="llvm::ImutAVLFactory::remove", NM="_ZN4llvm14ImutAVLFactory6removeEPNS_11ImutAVLTreeIT_EENS3_12key_type_refE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14ImutAVLFactory6removeEPNS_11ImutAVLTreeIT_EENS3_12key_type_refE")
  //</editor-fold>
  public ImutAVLTreeIntBoolInt/*P*/ remove(ImutAVLTreeIntBoolInt/*P*/ T, int V) {
    T = remove_internal(V, T);
    markImmutable(T);
    recoverNodes();
    return T;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::getEmptyTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 414,
   FQN="llvm::ImutAVLFactory::getEmptyTree", NM="_ZNK4llvm14ImutAVLFactory12getEmptyTreeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14ImutAVLFactory12getEmptyTreeEv")
  //</editor-fold>
  public ImutAVLTreeIntBoolInt/*P*/ getEmptyTree() /*const*/ {
    return null;
  }

/*protected:*/
  
  //===--------------------------------------------------===//
  // A bunch of quick helper functions used for reasoning
  // about the properties of trees and their children.
  // These have succinct names so that the balancing code
  // is as terse (and readable) as possible.
  //===--------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::isEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 425,
   FQN="llvm::ImutAVLFactory::isEmpty", NM="_ZNK4llvm14ImutAVLFactory7isEmptyEPNS_11ImutAVLTreeIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14ImutAVLFactory7isEmptyEPNS_11ImutAVLTreeIT_EE")
  //</editor-fold>
  protected boolean isEmpty(ImutAVLTreeIntBoolInt/*P*/ T) /*const*/ {
    return Native.$not(T);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::getHeight">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 426,
   FQN="llvm::ImutAVLFactory::getHeight", NM="_ZNK4llvm14ImutAVLFactory9getHeightEPNS_11ImutAVLTreeIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14ImutAVLFactory9getHeightEPNS_11ImutAVLTreeIT_EE")
  //</editor-fold>
  protected /*uint*/int getHeight(ImutAVLTreeIntBoolInt/*P*/ T) /*const*/ {
    return T != null ? T.getHeight() : 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::getLeft">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 427,
   FQN="llvm::ImutAVLFactory::getLeft", NM="_ZNK4llvm14ImutAVLFactory7getLeftEPNS_11ImutAVLTreeIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14ImutAVLFactory7getLeftEPNS_11ImutAVLTreeIT_EE")
  //</editor-fold>
  protected ImutAVLTreeIntBoolInt/*P*/ getLeft(ImutAVLTreeIntBoolInt/*P*/ T) /*const*/ {
    return T.getLeft();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::getRight">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 428,
   FQN="llvm::ImutAVLFactory::getRight", NM="_ZNK4llvm14ImutAVLFactory8getRightEPNS_11ImutAVLTreeIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14ImutAVLFactory8getRightEPNS_11ImutAVLTreeIT_EE")
  //</editor-fold>
  protected ImutAVLTreeIntBoolInt/*P*/ getRight(ImutAVLTreeIntBoolInt/*P*/ T) /*const*/ {
    return T.getRight();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 429,
   FQN="llvm::ImutAVLFactory::getValue", NM="_ZNK4llvm14ImutAVLFactory8getValueEPNS_11ImutAVLTreeIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14ImutAVLFactory8getValueEPNS_11ImutAVLTreeIT_EE")
  //</editor-fold>
  protected int getValue(ImutAVLTreeIntBoolInt/*P*/ T) /*const*/ {
    return T.value;
  }

  
  // Make sure the index is not the Tombstone or Entry key of the DenseMap.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::maskCacheIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 432,
   FQN="llvm::ImutAVLFactory::maskCacheIndex", NM="_ZN4llvm14ImutAVLFactory14maskCacheIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14ImutAVLFactory14maskCacheIndexEj")
  //</editor-fold>
  protected static </*typename*/ ImutInfo> /*uint*/int maskCacheIndex(/*uint*/int I) {
    return (I & ~0x02);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::incrementHeight">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 434,
   FQN="llvm::ImutAVLFactory::incrementHeight", NM="_ZNK4llvm14ImutAVLFactory15incrementHeightEPNS_11ImutAVLTreeIT_EES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm14ImutAVLFactory15incrementHeightEPNS_11ImutAVLTreeIT_EES4_")
  //</editor-fold>
  protected /*uint*/int incrementHeight(ImutAVLTreeIntBoolInt/*P*/ L, ImutAVLTreeIntBoolInt/*P*/ R) /*const*/ {
    /*uint*/int hl = getHeight(L);
    /*uint*/int hr = getHeight(R);
    return ($greater_uint(hl, hr) ? hl : hr) + 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::compareTreeWithSection">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 440,
   FQN="llvm::ImutAVLFactory::compareTreeWithSection", NM="_ZN4llvm14ImutAVLFactory22compareTreeWithSectionEPNS_11ImutAVLTreeIT_EERNS3_8iteratorES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14ImutAVLFactory22compareTreeWithSectionEPNS_11ImutAVLTreeIT_EERNS3_8iteratorES6_")
  //</editor-fold>
  protected boolean compareTreeWithSection(ImutAVLTreeIntBoolInt/*P*/ T, 
                        final  ImutAVLTreeInOrderIteratorIntBoolInt /*&*/ TI, 
                        final  ImutAVLTreeInOrderIteratorIntBoolInt /*&*/ TE) {
    ImutAVLTreeInOrderIteratorIntBoolInt I = T.begin();
    ImutAVLTreeInOrderIteratorIntBoolInt E = T.end();
    for (; Native.$noteq_iter(I, E); I.$preInc() , TI.$preInc()) {
      if (Native.$bool(Native.$eq_iter(TI, TE)) || Native.$not(I.$arrow().isElementEqual(/*AddrOf*/Native.$star(TI)))) {
        return false;
      }
    }
    return true;
  }

  
  //===--------------------------------------------------===//
  // "createNode" is used to generate new tree roots that link
  // to other trees.  The functon may also simply move links
  // in an existing root if that root is still marked mutable.
  // This is necessary because otherwise our balancing code
  // would leak memory as it would create nodes that are
  // then discarded later before the finished tree is
  // returned to the caller.
  //===--------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::createNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 461,
   FQN="llvm::ImutAVLFactory::createNode", NM="_ZN4llvm14ImutAVLFactory10createNodeEPNS_11ImutAVLTreeIT_EENS3_14value_type_refES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14ImutAVLFactory10createNodeEPNS_11ImutAVLTreeIT_EENS3_14value_type_refES4_")
  //</editor-fold>
  protected ImutAVLTreeIntBoolInt/*P*/ createNode(ImutAVLTreeIntBoolInt/*P*/ L, int V, ImutAVLTreeIntBoolInt/*P*/ R) {
    final BumpPtrAllocatorImpl /*&*/ A = getAllocator();
    ImutAVLTreeIntBoolInt/*P*/ T;
    if (!freeNodes.empty()) {
      T = freeNodes.back();
      freeNodes.pop_back();
      T.reset$Destroyed();
      assert Native.$bool(T != L);
      assert Native.$bool(T != R);
    } else {
      T = A.$RegisterCreated(new ImutAVLTreeIntBoolInt(ImutInfo));
      //T = (ImutAVLTreeIntBoolInt/*P*/ )A.<ImutAVLTreeIntBoolInt >Allocate();
    }
    /*FIXME: NEW_EXPR [NoNewFun]*/T = /*new (T)*/ T.$ImutAVLTree(this, L, R, V, incrementHeight(L, R));
    createdNodes.push_back(T);
    return T;
  }

  void pushBackDestroyedNode(ImutAVLTreeIntBoolInt/*P*/ Released) {
    assert Released.is$Destroyed();
    freeNodes.push_back(Released);
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::createNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 477,
   FQN="llvm::ImutAVLFactory::createNode", NM="_ZN4llvm14ImutAVLFactory10createNodeEPNS_11ImutAVLTreeIT_EES4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14ImutAVLFactory10createNodeEPNS_11ImutAVLTreeIT_EES4_S4_")
  //</editor-fold>
  protected ImutAVLTreeIntBoolInt/*P*/ createNode(ImutAVLTreeIntBoolInt/*P*/ newLeft, ImutAVLTreeIntBoolInt/*P*/ oldTree, ImutAVLTreeIntBoolInt/*P*/ newRight) {
    return createNode(newLeft, getValue(oldTree), newRight);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::recoverNodes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 481,
   FQN="llvm::ImutAVLFactory::recoverNodes", NM="_ZN4llvm14ImutAVLFactory12recoverNodesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14ImutAVLFactory12recoverNodesEv")
  //</editor-fold>
  protected void recoverNodes() {
    for (/*uint*/int i = 0, n = createdNodes.size(); $less_uint(i, n); ++i) {
      ImutAVLTreeIntBoolInt/*P*/ N = createdNodes.$at(i);
      if (Native.$bool(N.isMutable()) && Native.$bool(Native.$eq(N.refCount, 0))) {
        N.destroy();
      }
    }
    createdNodes.clear();
  }

  
  /// balanceTree - Used by add_internal and remove_internal to
  ///  balance a newly created tree.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::balanceTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 492,
   FQN="llvm::ImutAVLFactory::balanceTree", NM="_ZN4llvm14ImutAVLFactory11balanceTreeEPNS_11ImutAVLTreeIT_EENS3_14value_type_refES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14ImutAVLFactory11balanceTreeEPNS_11ImutAVLTreeIT_EENS3_14value_type_refES4_")
  //</editor-fold>
  protected ImutAVLTreeIntBoolInt/*P*/ balanceTree(ImutAVLTreeIntBoolInt/*P*/ L, int V, ImutAVLTreeIntBoolInt/*P*/ R) {
    /*uint*/int hl = getHeight(L);
    /*uint*/int hr = getHeight(R);
    if ($greater_uint(hl, hr + 2)) {
      assert Native.$bool(Native.$not(isEmpty(L))) : "Left tree cannot be empty to have a height >= 2";
      
      ImutAVLTreeIntBoolInt/*P*/ LL = getLeft(L);
      ImutAVLTreeIntBoolInt/*P*/ LR = getRight(L);
      if (Native.$greatereq(getHeight(LL), getHeight(LR))) {
        return createNode(LL, L, createNode(LR, V, R));
      }
      assert Native.$bool(Native.$not(isEmpty(LR))) : "LR cannot be empty because it has a height >= 1";
      
      ImutAVLTreeIntBoolInt/*P*/ LRL = getLeft(LR);
      ImutAVLTreeIntBoolInt/*P*/ LRR = getRight(LR);
      
      return createNode(createNode(LL, L, LRL), LR, createNode(LRR, V, R));
    }
    if ($greater_uint(hr, hl + 2)) {
      assert Native.$bool(Native.$not(isEmpty(R))) : "Right tree cannot be empty to have a height >= 2";
      
      ImutAVLTreeIntBoolInt/*P*/ RL = getLeft(R);
      ImutAVLTreeIntBoolInt/*P*/ RR = getRight(R);
      if (Native.$greatereq(getHeight(RR), getHeight(RL))) {
        return createNode(createNode(L, V, RL), R, RR);
      }
      assert Native.$bool(Native.$not(isEmpty(RL))) : "RL cannot be empty because it has a height >= 1";
      
      ImutAVLTreeIntBoolInt/*P*/ RLL = getLeft(RL);
      ImutAVLTreeIntBoolInt/*P*/ RLR = getRight(RL);
      
      return createNode(createNode(L, V, RLL), RL, createNode(RLR, R, RR));
    }
    
    return createNode(L, V, R);
  }

  
  /// add_internal - Creates a new tree that includes the specified
  ///  data and the data from the original tree.  If the original tree
  ///  already contained the data item, the original tree is returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::add_internal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 536,
   FQN="llvm::ImutAVLFactory::add_internal", NM="_ZN4llvm14ImutAVLFactory12add_internalENS_11ImutAVLTreeIT_E14value_type_refEPS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14ImutAVLFactory12add_internalENS_11ImutAVLTreeIT_E14value_type_refEPS3_")
  //</editor-fold>
  protected ImutAVLTreeIntBoolInt/*P*/ add_internal(int V, ImutAVLTreeIntBoolInt/*P*/ T) {
    if (isEmpty(T)) {
      return createNode(T, V, T);
    }
    assert Native.$bool(Native.$not(T.isMutable()));
    
    int K = ImutInfo.KeyOfValue(V);
    int KCurrent = ImutInfo.KeyOfValue(getValue(T));
    if (ImutInfo.isEqual(K, KCurrent)) {
      return createNode(getLeft(T), V, getRight(T));
    } else if (ImutInfo.isLess(K, KCurrent)) {
      return balanceTree(add_internal(V, getLeft(T)), getValue(T), getRight(T));
    } else {
      return balanceTree(getLeft(T), getValue(T), add_internal(V, getRight(T)));
    }
  }

  
  /// remove_internal - Creates a new tree that includes all the data
  ///  from the original tree except the specified data.  If the
  ///  specified data did not exist in the original tree, the original
  ///  tree is returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::remove_internal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 556,
   FQN="llvm::ImutAVLFactory::remove_internal", NM="_ZN4llvm14ImutAVLFactory15remove_internalENS_11ImutAVLTreeIT_E12key_type_refEPS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14ImutAVLFactory15remove_internalENS_11ImutAVLTreeIT_E12key_type_refEPS3_")
  //</editor-fold>
  protected ImutAVLTreeIntBoolInt/*P*/ remove_internal(int K, ImutAVLTreeIntBoolInt/*P*/ T) {
    if (isEmpty(T)) {
      return T;
    }
    assert Native.$bool(Native.$not(T.isMutable()));
    
    int KCurrent = ImutInfo.KeyOfValue(getValue(T));
    if (ImutInfo.isEqual(K, KCurrent)) {
      return combineTrees(getLeft(T), getRight(T));
    } else if (ImutInfo.isLess(K, KCurrent)) {
      return balanceTree(remove_internal(K, getLeft(T)), 
          getValue(T), getRight(T));
    } else {
      return balanceTree(getLeft(T), getValue(T), 
          remove_internal(K, getRight(T)));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::combineTrees">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 575,
   FQN="llvm::ImutAVLFactory::combineTrees", NM="_ZN4llvm14ImutAVLFactory12combineTreesEPNS_11ImutAVLTreeIT_EES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14ImutAVLFactory12combineTreesEPNS_11ImutAVLTreeIT_EES4_")
  //</editor-fold>
  protected ImutAVLTreeIntBoolInt/*P*/ combineTrees(ImutAVLTreeIntBoolInt/*P*/ L, ImutAVLTreeIntBoolInt/*P*/ R) {
    if (isEmpty(L)) {
      return R;
    }
    if (isEmpty(R)) {
      return L;
    }
    type$ref<ImutAVLTreeIntBoolInt/*P*/ > OldNode = create_type$ref();
    ImutAVLTreeIntBoolInt/*P*/ newRight = removeMinBinding(R, OldNode);
    return balanceTree(L, getValue(OldNode.$deref()), newRight);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::removeMinBinding">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 585,
   FQN="llvm::ImutAVLFactory::removeMinBinding", NM="_ZN4llvm14ImutAVLFactory16removeMinBindingEPNS_11ImutAVLTreeIT_EERS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14ImutAVLFactory16removeMinBindingEPNS_11ImutAVLTreeIT_EERS4_")
  //</editor-fold>
  protected ImutAVLTreeIntBoolInt/*P*/ removeMinBinding(ImutAVLTreeIntBoolInt/*P*/ T, final type$ref<ImutAVLTreeIntBoolInt/*P*/ >/*&*/ Noderemoved) {
    assert Native.$bool(Native.$not(isEmpty(T)));
    if (isEmpty(getLeft(T))) {
      Noderemoved.$set(T);
      return getRight(T);
    }
    return balanceTree(removeMinBinding(getLeft(T), Noderemoved), 
        getValue(T), getRight(T));
  }

  
  /// markImmutable - Clears the mutable bits of a root and all of its
  ///  descendants.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::markImmutable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 597,
   FQN="llvm::ImutAVLFactory::markImmutable", NM="_ZN4llvm14ImutAVLFactory13markImmutableEPNS_11ImutAVLTreeIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14ImutAVLFactory13markImmutableEPNS_11ImutAVLTreeIT_EE")
  //</editor-fold>
  protected void markImmutable(ImutAVLTreeIntBoolInt/*P*/ T) {
    if (Native.$not(T) || Native.$not(T.isMutable())) {
      return;
    }
    T.markImmutable();
    markImmutable(getLeft(T));
    markImmutable(getRight(T));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLFactory::getCanonicalTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 606,
   FQN="llvm::ImutAVLFactory::getCanonicalTree", NM="_ZN4llvm14ImutAVLFactory16getCanonicalTreeEPNS_11ImutAVLTreeIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm14ImutAVLFactory16getCanonicalTreeEPNS_11ImutAVLTreeIT_EE")
  //</editor-fold>
  public ImutAVLTreeIntBoolInt/*P*/ getCanonicalTree(ImutAVLTreeIntBoolInt/*P*/ TNew) {
    if (Native.$not(TNew)) {
      return null;
    }
    if (TNew.IsCanonicalized) {
      return TNew;
    }
    
    // Search the hashtable for another tree with the same digest, and
    // if find a collision compare those trees by their contents.
    /*uint*/int digest = TNew.computeDigest();
    final type$ref<ImutAVLTreeIntBoolInt/*P*/> /*&*/ entry = Cache.ref$at(maskCacheIndex(digest));
    do {
      if (entry.$deref() == null /*Native.$not(entry)*/) {
        break;
      }
      for (ImutAVLTreeIntBoolInt/*P*/ T = entry.$deref(); T != null; T = T.next) {
        // Compare the Contents('T') with Contents('TNew')
        ImutAVLTreeInOrderIteratorIntBoolInt TI = T.begin();
        ImutAVLTreeInOrderIteratorIntBoolInt TE = T.end();
        if (Native.$not(compareTreeWithSection(TNew, TI, TE))) {
          continue;
        }
        if (Native.$noteq_iter(TI, TE)) {
          continue; // T has more contents than TNew.
        }
        // Trees did match!  Return 'T'.
        if (Native.$eq(TNew.refCount, 0)) {
          TNew.destroy();
        }
        return T;
      }
      entry.$deref().prev = TNew;
      TNew.next = entry.$deref();
    } while (false);
    
    entry.$set(TNew);
    TNew.IsCanonicalized = true;
    return TNew;
  }

  
  @Override public String toString() {
    return "" + "Cache=" + Cache.size() // NOI18N
              + ", Allocator=" + NativeTrace.getIdentityStr(Allocator) // NOI18N
              + ", createdNodes=" + createdNodes.size() // NOI18N
              + ", freeNodes=" + freeNodes.size(); // NOI18N
  }
}
