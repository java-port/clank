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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;

// NOTE: This will possibly become the new implementation of ImmutableMap some day.
// template <typename ${KEY_TYPE}, typename ValT, typename ValInfo = ImutKeyValueInfo<${KEY_TYPE}, ValT>> TEMPLATE
//<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 250,
 FQN="llvm::ImmutableMapRef", NM="_ZN4llvm15ImmutableMapRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm15ImmutableMapRefE")
//</editor-fold>
public class ${FILE_NAME}${CLASS_SUFFIX} extends NativeTrace.CreateDestroy$Tracker
  implements Destructors.ClassWithDestructor, Native.NativeComparable<${FILE_NAME}>,
      Native.NativeIterable<${FILE_NAME}.iterator${CLASS_SUFFIX}>, Iterable<${PAIR_TYPE}>, FoldingSetTrait.Profilable {
/*public:*/
  /*typedef typename ValInfo::value_type value_type*/
//  public final class value_type extends std.pair<${KEY_TYPE}, ValT>{ };
  /*typedef typename ValInfo::value_type_ref value_type_ref*/
//  public final class value_type_ref extends std.pair<${KEY_TYPE}, ValT>{ };
  /*typedef typename ValInfo::key_type key_type*/
//  public final class key_type extends ${KEY_TYPE}{ };
  /*typedef typename ValInfo::key_type_ref key_type_ref*/
//  public final class key_type_ref extends ${KEY_TYPE}{ };
  /*typedef typename ValInfo::data_type data_type*/
//  public final class data_type extends ValT{ };
  /*typedef typename ValInfo::data_type_ref data_type_ref*/
//  public final class data_type_ref extends ValT{ };
//  /*typedef ImutAVLTree<${KEY_TYPE}, ValT> TreeTy*/
//  public final class TreeTy extends ImutAVLTree<${KEY_TYPE}, ValT>{ };
  /*typedef typename TreeTy::Factory FactoryTy*/
//  public final class FactoryTy extends ImutAVLFactory<${KEY_TYPE}, ValT>{ };
/*protected:*/
  protected ${AVL_TREE_TYPE} /*P*/ Root;
  protected ${AVL_FACTORY_TYPE} /*P*/ Factory;
/*public:*/
  /// Constructs a map from a pointer to a tree root.  In general one
  /// should use a Factory object to create maps instead of directly
  /// invoking the constructor, but there are cases where make this
  /// constructor public is useful.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::ImmutableMapRef<${KEY_TYPE}, ValT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 272,
   FQN="llvm::ImmutableMapRef::ImmutableMapRef<${KEY_TYPE}, ValT>", NM="_ZN4llvm15ImmutableMapRefC1EPKNS_11ImutAVLTreeIT1_EEPNS3_7FactoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm15ImmutableMapRefC1EPKNS_11ImutAVLTreeIT1_EEPNS3_7FactoryE")
  //</editor-fold>
  public /*explicit*/ ${FILE_NAME}(/*const*/ ${AVL_TREE_TYPE} /*P*/ R,  ${AVL_FACTORY_TYPE} /*P*/ F) {
    // : Root(const_cast<TreeTy * >(R)), Factory(F) 
    //START JInit
    this.Root = /*ParenListExpr*/((/*const_cast*/${AVL_TREE_TYPE} /*P*/ )(R));
    this.Factory = /*ParenListExpr*/F;
    //END JInit
    if (Root != null) {
      Root.retain();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::ImmutableMapRef<${KEY_TYPE}, ValT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 279,
   FQN="llvm::ImmutableMapRef::ImmutableMapRef<${KEY_TYPE}, ValT>", NM="_ZN4llvm15ImmutableMapRefC1ERKNS_12ImmutableMapIT_T0_NS_16ImutKeyValueInfoIS2_S3_EEEERNS6_7FactoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm15ImmutableMapRefC1ERKNS_12ImmutableMapIT_T0_NS_16ImutKeyValueInfoIS2_S3_EEEERNS6_7FactoryE")
  //</editor-fold>
  public /*explicit*/ ${FILE_NAME}(final /*const*/ ${IMMUTABLE_MAP_TYPE} /*&*/ X, 
      final  ${IMMUTABLE_MAP_FACTORY_TYPE} /*&*/ F) {
    // : Root(X.getRootWithoutRetain()), Factory(F.getTreeFactory()) 
    assert X.checkAlive();
    //START JInit
    this.Root = /*ParenListExpr*/X.getRootWithoutRetain();
    this.Factory = /*ParenListExpr*/F.getTreeFactory();
    //END JInit
    if (Root != null) {
      Root.retain();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::ImmutableMapRef<${KEY_TYPE}, ValT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 286,
   FQN="llvm::ImmutableMapRef::ImmutableMapRef<${KEY_TYPE}, ValT>", NM="_ZN4llvm15ImmutableMapRefC1ERKNS_15ImmutableMapRefIT_T0_T1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm15ImmutableMapRefC1ERKNS_15ImmutableMapRefIT_T0_T1_EE")
  //</editor-fold>
  public ${FILE_NAME}(final /*const*/ ${CLASS_TYPE} /*&*/ X) {
    assert X.checkAlive();
    // : Root(X.Root), Factory(X.Factory) 
    //START JInit
    this.Root = /*ParenListExpr*/X.Root;
    this.Factory = /*ParenListExpr*/X.Factory;
    //END JInit
    if (Root != null) {
      Root.retain();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 292,
   FQN="llvm::ImmutableMapRef::operator=", NM="_ZN4llvm15ImmutableMapRefaSERKNS_15ImmutableMapRefIT_T0_T1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm15ImmutableMapRefaSERKNS_15ImmutableMapRefIT_T0_T1_EE")
  //</editor-fold>
  public ${CLASS_TYPE} /*&*/ $assign(final /*const*/ ${CLASS_TYPE} /*&*/ X) {
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

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::~ImmutableMapRef<${KEY_TYPE}, ValT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 306,
   FQN="llvm::ImmutableMapRef::~ImmutableMapRef<${KEY_TYPE}, ValT>", NM="_ZN4llvm15ImmutableMapRefD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm15ImmutableMapRefD0Ev")
  //</editor-fold>
  public void $destroy() {
    assert checkAlive();
    if (Root != null) {
      Root.release();
    }
    super.set$destroyed();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::getEmptyMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 311,
   FQN="llvm::ImmutableMapRef::getEmptyMap", NM="_ZN4llvm15ImmutableMapRef11getEmptyMapEPNS_11ImutAVLTreeIT1_E7FactoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm15ImmutableMapRef11getEmptyMapEPNS_11ImutAVLTreeIT1_E7FactoryE")
  //</editor-fold>
  public static /*inline*/ ${CLASS_SUFFIX} ${CLASS_TYPE} getEmptyMap( ${AVL_FACTORY_TYPE} /*P*/ F) {
    return new ${CLASS_TYPE}(null, F);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::manualRetain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 315,
   FQN="llvm::ImmutableMapRef::manualRetain", NM="_ZN4llvm15ImmutableMapRef12manualRetainEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm15ImmutableMapRef12manualRetainEv")
  //</editor-fold>
  public void manualRetain() {
    assert checkAlive();
    if (Root != null) {
      Root.retain();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::manualRelease">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 319,
   FQN="llvm::ImmutableMapRef::manualRelease", NM="_ZN4llvm15ImmutableMapRef13manualReleaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm15ImmutableMapRef13manualReleaseEv")
  //</editor-fold>
  public void manualRelease() {
    assert checkAlive();
    if (Root != null) {
      Root.release();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 323,
   FQN="llvm::ImmutableMapRef::add", NM="_ZNK4llvm15ImmutableMapRef3addENT1_12key_type_refENS1_13data_type_refE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK4llvm15ImmutableMapRef3addENT1_12key_type_refENS1_13data_type_refE")
  //</editor-fold>
  public ${CLASS_TYPE} add(${KEY_TYPE} K, ${DATA_TYPE} D) /*const*/ {
    assert checkAlive();
    ${AVL_TREE_TYPE} /*P*/ NewT = Factory.add(Root, new ${PAIR_TYPE}(K, D));
    return new ${CLASS_TYPE}(NewT, Factory);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::remove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 328,
   FQN="llvm::ImmutableMapRef::remove", NM="_ZNK4llvm15ImmutableMapRef6removeENT1_12key_type_refE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK4llvm15ImmutableMapRef6removeENT1_12key_type_refE")
  //</editor-fold>
  public ${CLASS_TYPE} remove(${KEY_TYPE} K) /*const*/ {
    assert checkAlive();
    ${AVL_TREE_TYPE} /*P*/ NewT = Factory.remove(Root, K);
    return new ${CLASS_TYPE}(NewT, Factory);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::contains">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 333,
   FQN="llvm::ImmutableMapRef::contains", NM="_ZNK4llvm15ImmutableMapRef8containsENT1_12key_type_refE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK4llvm15ImmutableMapRef8containsENT1_12key_type_refE")
  //</editor-fold>
  public boolean contains(${KEY_TYPE} K) /*const*/ {
    assert checkAlive();
    return Root != null ? Root.contains(K) : false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::asImmutableMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 337,
   FQN="llvm::ImmutableMapRef::asImmutableMap", NM="_ZNK4llvm15ImmutableMapRef14asImmutableMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK4llvm15ImmutableMapRef14asImmutableMapEv")
  //</editor-fold>
  public ${IMMUTABLE_MAP_TYPE} asImmutableMap() /*const*/ {
    assert checkAlive();
    return new ${IMMUTABLE_MAP_TYPE}(Factory.getCanonicalTree(Root));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 341,
   FQN="llvm::ImmutableMapRef::operator==", NM="_ZNK4llvm15ImmutableMapRefeqERKNS_15ImmutableMapRefIT_T0_T1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK4llvm15ImmutableMapRefeqERKNS_15ImmutableMapRefIT_T0_T1_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/ ${CLASS_TYPE} /*&*/ RHS) /*const*/ {
    assert checkAlive();
    return Root != null && RHS.Root != null ? Root.isEqual(RHS.Root) : Root == RHS.Root;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 345,
   FQN="llvm::ImmutableMapRef::operator!=", NM="_ZNK4llvm15ImmutableMapRefneERKNS_15ImmutableMapRefIT_T0_T1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK4llvm15ImmutableMapRefneERKNS_15ImmutableMapRefIT_T0_T1_EE")
  //</editor-fold>
  public boolean $noteq(final /*const*/ ${CLASS_TYPE} /*&*/ RHS) /*const*/ {
    assert checkAlive();
    return Root != null && RHS.Root != null ? Root.isNotEqual(RHS.Root) : Root != RHS.Root;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::isEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 349,
   FQN="llvm::ImmutableMapRef::isEmpty", NM="_ZNK4llvm15ImmutableMapRef7isEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK4llvm15ImmutableMapRef7isEmptyEv")
  //</editor-fold>
  public boolean isEmpty() /*const*/ {
    assert checkAlive();
    return Root == null;
  }

  
  //===--------------------------------------------------===//
  // For testing.
  //===--------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::verify">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 355,
   FQN="llvm::ImmutableMapRef::verify", NM="_ZNK4llvm15ImmutableMapRef6verifyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK4llvm15ImmutableMapRef6verifyEv")
  //</editor-fold>
  public void verify() /*const*/ {
    throw new UnsupportedOperationException("Why verify is called?");
//    if (Root != null) {
//      Root.verify();
//    }
  }

  
  //===--------------------------------------------------===//
  // Iterators.
  //===--------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 364,
   FQN="llvm::ImmutableMapRef::iterator", NM="_ZN4llvm15ImmutableMapRef8iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm15ImmutableMapRef8iteratorE")
  //</editor-fold>
  public static class iterator${CLASS_SUFFIX} extends /*public*/ ${AVL_VALUE_ITER_TYPE} {
    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 365,
     FQN="llvm::ImmutableMapRef::iterator::iterator", NM="_ZN4llvm15ImmutableMapRef8iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm15ImmutableMapRef8iteratorC1Ev")
    //</editor-fold>
    private iterator()/* = default*/ {
      super();
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 366,
     FQN="llvm::ImmutableMapRef::iterator::iterator", NM="_ZN4llvm15ImmutableMapRef8iteratorC1EPNS_11ImutAVLTreeIT1_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm15ImmutableMapRef8iteratorC1EPNS_11ImutAVLTreeIT1_EE")
    //</editor-fold>
    private /*explicit*/ iterator(${AVL_TREE_TYPE} /*P*/ Tree) {
      // : iterator::ImutAVLValueIterator(Tree) 
      //START JInit
      /*ParenListExpr*/super(Tree);
      //END JInit
    }

    /*friend  class ImmutableMapRef<${KEY_TYPE}, ValT>*/
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::iterator::getKey">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 370,
     FQN="llvm::ImmutableMapRef::iterator::getKey", NM="_ZNK4llvm15ImmutableMapRef8iterator6getKeyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK4llvm15ImmutableMapRef8iterator6getKeyEv")
    //</editor-fold>
    public ${KEY_TYPE} getKey() /*const*/ {
      return this.$star().first;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::iterator::getData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 371,
     FQN="llvm::ImmutableMapRef::iterator::getData", NM="_ZNK4llvm15ImmutableMapRef8iterator7getDataEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK4llvm15ImmutableMapRef8iterator7getDataEv")
    //</editor-fold>
    public ${DATA_TYPE} getData() /*const*/ {
      return this.$star().second;
    }

    private iterator(iterator${CLASS_SUFFIX} $Prm0) {
      super($Prm0);
    }
    
    @Override public iterator${CLASS_SUFFIX} clone() {
      return new iterator(this);
    }
    
    @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 374,
   FQN="llvm::ImmutableMapRef::begin", NM="_ZNK4llvm15ImmutableMapRef5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK4llvm15ImmutableMapRef5beginEv")
  //</editor-fold>
  public iterator${CLASS_SUFFIX} begin() /*const*/ {
    assert checkAlive();
    return new iterator(Root);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 375,
   FQN="llvm::ImmutableMapRef::end", NM="_ZNK4llvm15ImmutableMapRef3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK4llvm15ImmutableMapRef3endEv")
  //</editor-fold>
  public iterator${CLASS_SUFFIX} end() /*const*/ {
    assert checkAlive();
    return new iterator();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::lookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 377,
   FQN="llvm::ImmutableMapRef::lookup", NM="_ZNK4llvm15ImmutableMapRef6lookupENT1_12key_type_refE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK4llvm15ImmutableMapRef6lookupENT1_12key_type_refE")
  //</editor-fold>
  public ${LOOKUP_TYPE} lookup(${KEY_TYPE} K) /*const*/ {
    assert checkAlive();
    if (Root != null) {
      ${AVL_TREE_TYPE} /*P*/ T = Root.find(K);
      if (T != null) {
        final ${PAIR_TYPE} value = T.getValue();
        return /*AddrOf*/new ${LOOKUP_RETURN_IMPL}(value) {
          @Override protected ${DATA_TYPE} $star$impl() { return value.second; }
          @Override protected ${DATA_TYPE} $set$impl(${DATA_TYPE} V) { return value.second = V; }
          @Override public boolean $isNull() { return false; }
          @Override public boolean $bool() { return true; }
        };
      }
    }
    
    return null;
  }

  
  /// getMaxElement - Returns the <key,value> pair in the ImmutableMap for
  ///  which key is the highest in the ordering of keys in the map.  This
  ///  method returns NULL if the map is empty.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::getMaxElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 389,
   FQN="llvm::ImmutableMapRef::getMaxElement", NM="_ZNK4llvm15ImmutableMapRef13getMaxElementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK4llvm15ImmutableMapRef13getMaxElementEv")
  //</editor-fold>
  public ${PAIR_TYPE}/*P*/ getMaxElement() /*const*/ {
    assert checkAlive();
    return Root != null ? /*AddrOf*/(Root.getMaxElement().getValue()) : null;
  }

  
  //===--------------------------------------------------===//
  // Utility methods.
  //===--------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::getHeight">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 397,
   FQN="llvm::ImmutableMapRef::getHeight", NM="_ZNK4llvm15ImmutableMapRef9getHeightEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK4llvm15ImmutableMapRef9getHeightEv")
  //</editor-fold>
  public /*uint*/int getHeight() /*const*/ {
    assert checkAlive();
    return Root != null ? Root.getHeight() : 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 399,
   FQN="llvm::ImmutableMapRef::Profile", NM="_ZN4llvm15ImmutableMapRef7ProfileERNS_16FoldingSetNodeIDERKNS_15ImmutableMapRefIT_T0_T1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN4llvm15ImmutableMapRef7ProfileERNS_16FoldingSetNodeIDERKNS_15ImmutableMapRefIT_T0_T1_EE")
  //</editor-fold>
  public static /*inline*/ ${CLASS_SUFFIX} void Profile(final FoldingSetNodeID /*&*/ ID, final /*const*/ ${CLASS_TYPE} /*&*/ M) {
    assert M.checkAlive();
    ID.AddPointer(M.Root);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableMapRef::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableMap.h", line = 403,
   FQN="llvm::ImmutableMapRef::Profile", NM="_ZNK4llvm15ImmutableMapRef7ProfileERNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK4llvm15ImmutableMapRef7ProfileERNS_16FoldingSetNodeIDE")
  //</editor-fold>
  public /*inline*/ void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    assert checkAlive();
    Profile(ID, this);
    /*JAVA:return*/return;
  }

  @Override
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public Iterator<${PAIR_TYPE}> iterator() {
    assert checkAlive();
    return new JavaIterator(begin(), end());
  }
  
  @Override public String toString() {
    StringBuilder out = new StringBuilder(super.is$destroyed() ? "DESTROYED ":"");
    int idx = 0;
    for (${PAIR_TYPE} entry : this) {
      out.append("\n[").append(idx++).append("] {");
      out.append(entry.first).append("} => {");
      out.append(entry.second).append("}");
    }
    return "${FILE_NAME}" + out.toString(); // NOI18N
  }
  
  final boolean checkAlive() {
    return check$Alive();
  }  
  
}
