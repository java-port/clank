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

import java.util.Iterator;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;


// NOTE: This may some day replace the current ImmutableSet.
/*template <typename ValT, typename ValInfo = ImutContainerInfo<ValT>> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1107,
 FQN="llvm::ImmutableSetRef", NM="_ZN4llvm15ImmutableSetRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm15ImmutableSetRefE")
//</editor-fold>
public class ImmutableSetRefInt extends NativeTrace.CreateDestroy$Tracker
    implements Destructors.ClassWithDestructor,
       Native.NativeComparable<ImmutableSetRefInt>, Iterable<Integer>, FoldingSetTrait.Profilable {
/*public:*/
  /*typedef typename ValInfo::value_type value_type*/
//  public final class value_type extends ValT{ };
  /*typedef typename ValInfo::value_type_ref value_type_ref*/
//  public final class value_type_ref extends ValT{ };
  /*typedef ImutAVLTreeIntBoolInt TreeTy*/
//  public final class TreeTy extends ImutAVLTreeIntBoolInt{ };
  /*typedef typename TreeTy::Factory FactoryTy*/
//  public final class FactoryTy extends  ImutAVLFactoryIntBoolInt{ };
/*private:*/
  private ImutAVLTreeIntBoolInt /*P*/ Root;
  private  ImutAVLFactoryIntBoolInt /*P*/ Factory;
/*public:*/
  /// Constructs a set from a pointer to a tree root.  In general one
  /// should use a Factory object to create sets instead of directly
  /// invoking the constructor, but there are cases where make this
  /// constructor public is useful.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::ImmutableSetRef<ValT, ValInfo>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1124,
   FQN="llvm::ImmutableSetRef::ImmutableSetRef<ValT, ValInfo>", NM="_ZN4llvm15ImmutableSetRefC1EPNS_11ImutAVLTreeIT0_EEPNS3_7FactoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm15ImmutableSetRefC1EPNS_11ImutAVLTreeIT0_EEPNS3_7FactoryE")
  //</editor-fold>
  public /*explicit*/ ImmutableSetRefInt(ImutAVLTreeIntBoolInt /*P*/ R,  ImutAVLFactoryIntBoolInt /*P*/ F) {
    // : Root(R), Factory(F) 
    //START JInit
    this.Root = /*ParenListExpr*/R;
    this.Factory = /*ParenListExpr*/F;
    //END JInit
    if (Root != null) {
      Root.retain();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::ImmutableSetRef<ValT, ValInfo>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1129,
   FQN="llvm::ImmutableSetRef::ImmutableSetRef<ValT, ValInfo>", NM="_ZN4llvm15ImmutableSetRefC1ERKNS_15ImmutableSetRefIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm15ImmutableSetRefC1ERKNS_15ImmutableSetRefIT_T0_EE")
  //</editor-fold>
  public ImmutableSetRefInt(final /*const*/ ImmutableSetRefInt /*&*/ X) {
    // : Root(X.Root), Factory(X.Factory) 
    assert X.checkAlive();
    //START JInit
    this.Root = /*ParenListExpr*/X.Root;
    this.Factory = /*ParenListExpr*/X.Factory;
    //END JInit
    if (Root != null) {
      Root.retain();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1134,
   FQN="llvm::ImmutableSetRef::operator=", NM="_ZN4llvm15ImmutableSetRefaSERKNS_15ImmutableSetRefIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm15ImmutableSetRefaSERKNS_15ImmutableSetRefIT_T0_EE")
  //</editor-fold>
  public ImmutableSetRefInt /*&*/ $assign(final /*const*/ ImmutableSetRefInt /*&*/ X) {
    assert X.checkAlive();
    assert checkAlive();
    if (Root != X.Root) {
      if (X.Root != null) {
        X.Root.retain();
      }
      if (Root != null) {
        Root.release();
      }
      Root = X.Root;
      Factory = X.Factory;
    }
    return this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::~ImmutableSetRef<ValT, ValInfo>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1143,
   FQN="llvm::ImmutableSetRef::~ImmutableSetRef<ValT, ValInfo>", NM="_ZN4llvm15ImmutableSetRefD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm15ImmutableSetRefD0Ev")
  //</editor-fold>
  public void $destroy() {
    assert checkAlive();
    if (Root != null) {
      Root.release();
    }
    set$destroyed();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::getEmptySet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1147,
   FQN="llvm::ImmutableSetRef::getEmptySet", NM="_ZN4llvm15ImmutableSetRef11getEmptySetEPNS_11ImutAVLTreeIT0_E7FactoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm15ImmutableSetRef11getEmptySetEPNS_11ImutAVLTreeIT0_E7FactoryE")
  //</editor-fold>
  public static  ImmutableSetRefInt getEmptySet( ImutAVLFactoryIntBoolInt /*P*/ F) {
    return new ImmutableSetRefInt(null, F);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1151,
   FQN="llvm::ImmutableSetRef::add", NM="_ZN4llvm15ImmutableSetRef3addENT0_14value_type_refE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm15ImmutableSetRef3addENT0_14value_type_refE")
  //</editor-fold>
  public ImmutableSetRefInt add(int V) {
    assert checkAlive();
    return new ImmutableSetRefInt(Factory.add(Root, V), Factory);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::remove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1155,
   FQN="llvm::ImmutableSetRef::remove", NM="_ZN4llvm15ImmutableSetRef6removeENT0_14value_type_refE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm15ImmutableSetRef6removeENT0_14value_type_refE")
  //</editor-fold>
  public ImmutableSetRefInt remove(int V) {
    assert checkAlive();
    return new ImmutableSetRefInt(Factory.remove(Root, V), Factory);
  }

  
  /// Returns true if the set contains the specified value.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::contains">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1160,
   FQN="llvm::ImmutableSetRef::contains", NM="_ZNK4llvm15ImmutableSetRef8containsENT0_14value_type_refE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm15ImmutableSetRef8containsENT0_14value_type_refE")
  //</editor-fold>
  public boolean contains(int V) /*const*/ {
    assert checkAlive();
    return Root != null ? Root.contains(V) : false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::asImmutableSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1164,
   FQN="llvm::ImmutableSetRef::asImmutableSet", NM="_ZNK4llvm15ImmutableSetRef14asImmutableSetEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm15ImmutableSetRef14asImmutableSetEb")
  //</editor-fold>
  public ImmutableSetInt asImmutableSet() /*const*/ {
    assert checkAlive();
    return asImmutableSet(true);
  }
  public ImmutableSetInt asImmutableSet(boolean canonicalize/*= true*/) /*const*/ {
    assert checkAlive();
    return new ImmutableSetInt(canonicalize ? Factory.getCanonicalTree(Root) : Root);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::getRootWithoutRetain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1169,
   FQN="llvm::ImmutableSetRef::getRootWithoutRetain", NM="_ZNK4llvm15ImmutableSetRef20getRootWithoutRetainEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm15ImmutableSetRef20getRootWithoutRetainEv")
  //</editor-fold>
  public ImutAVLTreeIntBoolInt /*P*/ getRootWithoutRetain() /*const*/ {
    assert checkAlive();
    return Root;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1173,
   FQN="llvm::ImmutableSetRef::operator==", NM="_ZNK4llvm15ImmutableSetRefeqERKNS_15ImmutableSetRefIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm15ImmutableSetRefeqERKNS_15ImmutableSetRefIT_T0_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/ ImmutableSetRefInt /*&*/ RHS) /*const*/ {
    assert RHS.checkAlive();
    assert checkAlive();
    return Root != null && RHS.Root != null ? Root.isEqual(RHS.Root) : Root == RHS.Root;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1177,
   FQN="llvm::ImmutableSetRef::operator!=", NM="_ZNK4llvm15ImmutableSetRefneERKNS_15ImmutableSetRefIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm15ImmutableSetRefneERKNS_15ImmutableSetRefIT_T0_EE")
  //</editor-fold>
  public boolean $noteq(final /*const*/ ImmutableSetRefInt /*&*/ RHS) /*const*/ {
    assert RHS.checkAlive();
    assert checkAlive();
    return !$eq(RHS);
  }

  
  /// isEmpty - Return true if the set contains no elements.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::isEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1182,
   FQN="llvm::ImmutableSetRef::isEmpty", NM="_ZNK4llvm15ImmutableSetRef7isEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm15ImmutableSetRef7isEmptyEv")
  //</editor-fold>
  public boolean isEmpty() /*const*/ {
    assert checkAlive();
    return Root == null;
  }

  
  /// isSingleton - Return true if the set contains exactly one element.
  ///   This method runs in constant time.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::isSingleton">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1186,
   FQN="llvm::ImmutableSetRef::isSingleton", NM="_ZNK4llvm15ImmutableSetRef11isSingletonEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm15ImmutableSetRef11isSingletonEv")
  //</editor-fold>
  public boolean isSingleton() /*const*/ {
    assert checkAlive();
    return Native.$eq(getHeight(), 1);
  }

  
  //===--------------------------------------------------===//
  // Iterators.
  //===--------------------------------------------------===//
  /*typedef ImutAVLValueIterator<ImmutableSetRef<ValT, ValInfo> > iterator*/
//  public final class iterator extends ImutAVLValueIterator<ImmutableSetRef<ValT, ValInfo> >{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1194,
   FQN="llvm::ImmutableSetRef::begin", NM="_ZNK4llvm15ImmutableSetRef5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm15ImmutableSetRef5beginEv")
  //</editor-fold>
  public ImutAVLValueIteratorIntBoolInt begin() /*const*/ {
    assert checkAlive();
    return new ImutAVLValueIteratorIntBoolInt(Root);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1195,
   FQN="llvm::ImmutableSetRef::end", NM="_ZNK4llvm15ImmutableSetRef3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm15ImmutableSetRef3endEv")
  //</editor-fold>
  public ImutAVLValueIteratorIntBoolInt end() /*const*/ {
    assert checkAlive();
    return new ImutAVLValueIteratorIntBoolInt();
  }

  
  //===--------------------------------------------------===//
  // Utility methods.
  //===--------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::getHeight">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1201,
   FQN="llvm::ImmutableSetRef::getHeight", NM="_ZNK4llvm15ImmutableSetRef9getHeightEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm15ImmutableSetRef9getHeightEv")
  //</editor-fold>
  public /*uint*/int getHeight() /*const*/ {
    assert checkAlive();
    return Root != null ? Root.getHeight() : 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1203,
   FQN="llvm::ImmutableSetRef::Profile", NM="_ZN4llvm15ImmutableSetRef7ProfileERNS_16FoldingSetNodeIDERKNS_15ImmutableSetRefIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm15ImmutableSetRef7ProfileERNS_16FoldingSetNodeIDERKNS_15ImmutableSetRefIT_T0_EE")
  //</editor-fold>
  public static  void Profile(final FoldingSetNodeID /*&*/ ID, final /*const*/ ImmutableSetRefInt /*&*/ S) {
    assert S.checkAlive();
    ID.AddPointer(S.Root);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1207,
   FQN="llvm::ImmutableSetRef::Profile", NM="_ZNK4llvm15ImmutableSetRef7ProfileERNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm15ImmutableSetRef7ProfileERNS_16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    assert checkAlive();
    Profile(ID, this);
    /*JAVA:return*/return;
  }

  
  //===--------------------------------------------------===//
  // For testing.
  //===--------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSetRef::validateTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1213,
   FQN="llvm::ImmutableSetRef::validateTree", NM="_ZNK4llvm15ImmutableSetRef12validateTreeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm15ImmutableSetRef12validateTreeEv")
  //</editor-fold>
  public void validateTree() /*const*/ {
    assert checkAlive();
    if (Root != null) {
      Root.validateTree();
    }
  }

  @Override
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public Iterator<Integer> iterator() {
    assert checkAlive();
    return new JavaIteratorInt(begin(), end());
  }
  
  @Override public String toString() {
    return (super.is$destroyed() ? "DESTROYED ":"") + "Root=" + Root // NOI18N
              + ", Factory=" + Factory; // NOI18N
  }
  
  final boolean checkAlive() {
    return check$Alive();
  }   
}
