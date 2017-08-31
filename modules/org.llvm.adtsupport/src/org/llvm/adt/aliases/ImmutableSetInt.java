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
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;


//===----------------------------------------------------------------------===//
// Immutable Set
//===----------------------------------------------------------------------===//
/*template <typename ValT, typename ValInfo = ImutContainerInfo<ValT>> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 957,
 FQN="llvm::ImmutableSet", NM="_ZN4llvm12ImmutableSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm12ImmutableSetE")
//</editor-fold>
public class ImmutableSetInt extends NativeTrace.CreateDestroy$Tracker
    implements Destructors.ClassWithDestructor, 
      Native.NativeComparable<ImmutableSetInt>, Iterable<Integer>, FoldingSetTrait.Profilable, NativeCloneable<ImmutableSetInt> {  
/*public:*/
  /*typedef typename ValInfo::value_type value_type*/
//  public final class value_type extends ValT{ };
  /*typedef typename ValInfo::value_type_ref value_type_ref*/
//  public final class value_type_ref extends ValT{ };
  /*typedef ImutAVLTreeIntBoolInt TreeTy*/
//  public final class TreeTy extends ImutAVLTreeIntBoolInt{ };
/*private:*/
  private ImutAVLTreeIntBoolInt /*P*/ Root;
/*public:*/
  /// Constructs a set from a pointer to a tree root.  In general one
  /// should use a Factory object to create sets instead of directly
  /// invoking the constructor, but there are cases where make this
  /// constructor public is useful.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::ImmutableSetInt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 972,
   FQN="llvm::ImmutableSet::ImmutableSetInt", NM="_ZN4llvm12ImmutableSetC1EPNS_11ImutAVLTreeIT0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm12ImmutableSetC1EPNS_11ImutAVLTreeIT0_EE")
  //</editor-fold>
  public /*explicit*/ ImmutableSetInt(ImutAVLTreeIntBoolInt /*P*/ R) {
    // : Root(R) 
    //START JInit
    this.Root = /*ParenListExpr*/R;
    //END JInit
    if (Root != null) {
      Root.retain();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::ImmutableSetInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 975,
   FQN="llvm::ImmutableSet::ImmutableSetInt", NM="_ZN4llvm12ImmutableSetC1ERKNS_12ImmutableSetIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm12ImmutableSetC1ERKNS_12ImmutableSetIT_T0_EE")
  //</editor-fold>
  public ImmutableSetInt(final /*const*/ ImmutableSetInt /*&*/ X) {
    assert X.checkAlive();
    // : Root(X.Root) 
    //START JInit
    this.Root = /*ParenListExpr*/X.Root;
    //END JInit
    if (Root != null) {
      Root.retain();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 978,
   FQN="llvm::ImmutableSet::operator=", NM="_ZN4llvm12ImmutableSetaSERKNS_12ImmutableSetIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm12ImmutableSetaSERKNS_12ImmutableSetIT_T0_EE")
  //</editor-fold>
  public ImmutableSetInt /*&*/ $assign(final /*const*/ ImmutableSetInt /*&*/ X) {
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
    }
    return this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::~ImmutableSetInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 986,
   FQN="llvm::ImmutableSet::~ImmutableSetInt", NM="_ZN4llvm12ImmutableSetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm12ImmutableSetD0Ev")
  //</editor-fold>
  public void $destroy() {
    assert checkAlive();
    if (Root != null) {
      Root.release();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::Factory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 990,
   FQN="llvm::ImmutableSet::Factory", NM="_ZN4llvm12ImmutableSet7FactoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm12ImmutableSet7FactoryE")
  //</editor-fold>
  public static class Factory  implements Destructors.ClassWithDestructor {
    private  ImutAVLFactoryIntBoolInt F;
    private /*const*/boolean Canonicalize;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::Factory::Factory">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 995,
     FQN="llvm::ImmutableSet::Factory::Factory", NM="_ZN4llvm12ImmutableSet7FactoryC1Eb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm12ImmutableSet7FactoryC1Eb")
    //</editor-fold>
    public Factory(ImutContainerInfoInt ValInfo) {
      this(ValInfo, true);
    }
    public Factory(ImutContainerInfoInt ValInfo, boolean canonicalize/*= true*/) {
      // : Canonicalize(canonicalize) 
      //START JInit
      this.F = new ImutAVLFactoryIntBoolInt(ValInfo);
      this.Canonicalize = canonicalize;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::Factory::Factory">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 998,
     FQN="llvm::ImmutableSet::Factory::Factory", NM="_ZN4llvm12ImmutableSet7FactoryC1ERNS_20BumpPtrAllocatorImplINS_15MallocAllocatorELj4096ELj4096EEEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm12ImmutableSet7FactoryC1ERNS_20BumpPtrAllocatorImplINS_15MallocAllocatorELj4096ELj4096EEEb")
    //</editor-fold>
    public Factory(ImutContainerInfoInt ValInfo, final BumpPtrAllocatorImpl /*&*/ Alloc) {
      this(ValInfo, Alloc, true);
    }
    public Factory(ImutContainerInfoInt ValInfo, final BumpPtrAllocatorImpl /*&*/ Alloc, boolean canonicalize/*= true*/) {
      // : F(Alloc), Canonicalize(canonicalize) 
      //START JInit
      this.F = /*ParenListExpr*/new  ImutAVLFactoryIntBoolInt(ValInfo, Alloc);
      this.Canonicalize = canonicalize;
      //END JInit
    }

    
    /// getEmptySet - Returns an immutable set that contains no elements.
    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::Factory::getEmptySet">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1002,
     FQN="llvm::ImmutableSet::Factory::getEmptySet", NM="_ZN4llvm12ImmutableSet7Factory11getEmptySetEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm12ImmutableSet7Factory11getEmptySetEv")
    //</editor-fold>
    public ImmutableSetInt getEmptySet() {
      return new ImmutableSetInt(F.getEmptyTree());
    }

    
    /// add - Creates a new immutable set that contains all of the values
    ///  of the original set with the addition of the specified value.  If
    ///  the original set already included the value, then the original set is
    ///  returned and no memory is allocated.  The time and space complexity
    ///  of this operation is logarithmic in the size of the original set.
    ///  The memory allocated to represent the set is released when the
    ///  factory object that created the set is destroyed.
    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::Factory::add">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1013,
     FQN="llvm::ImmutableSet::Factory::add", NM="_ZN4llvm12ImmutableSet7Factory3addENS_12ImmutableSetIT_T0_EENS4_14value_type_refE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm12ImmutableSet7Factory3addENS_12ImmutableSetIT_T0_EENS4_14value_type_refE")
    //</editor-fold>
    public ImmutableSetInt add(ImmutableSetInt Old, int V) {
      ImutAVLTreeIntBoolInt /*P*/ NewT = F.add(Old.Root, V);
      return new ImmutableSetInt(Canonicalize ? F.getCanonicalTree(NewT) : NewT);
    }

    
    /// remove - Creates a new immutable set that contains all of the values
    ///  of the original set with the exception of the specified value.  If
    ///  the original set did not contain the value, the original set is
    ///  returned and no memory is allocated.  The time and space complexity
    ///  of this operation is logarithmic in the size of the original set.
    ///  The memory allocated to represent the set is released when the
    ///  factory object that created the set is destroyed.
    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::Factory::remove">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1025,
     FQN="llvm::ImmutableSet::Factory::remove", NM="_ZN4llvm12ImmutableSet7Factory6removeENS_12ImmutableSetIT_T0_EENS4_14value_type_refE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm12ImmutableSet7Factory6removeENS_12ImmutableSetIT_T0_EENS4_14value_type_refE")
    //</editor-fold>
    public ImmutableSetInt remove(ImmutableSetInt Old, int V) {
      ImutAVLTreeIntBoolInt /*P*/ NewT = F.remove(Old.Root, V);
      return new ImmutableSetInt(Canonicalize ? F.getCanonicalTree(NewT) : NewT);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::Factory::getAllocator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1030,
     FQN="llvm::ImmutableSet::Factory::getAllocator", NM="_ZN4llvm12ImmutableSet7Factory12getAllocatorEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm12ImmutableSet7Factory12getAllocatorEv")
    //</editor-fold>
    public BumpPtrAllocatorImpl /*&*/ getAllocator() {
      return F.getAllocator();
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::Factory::getTreeFactory">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1032,
     FQN="llvm::ImmutableSet::Factory::getTreeFactory", NM="_ZNK4llvm12ImmutableSet7Factory14getTreeFactoryEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm12ImmutableSet7Factory14getTreeFactoryEv")
    //</editor-fold>
    public  ImutAVLFactoryIntBoolInt /*P*/ getTreeFactory() /*const*/ {
      return ((/*const_cast*/ ImutAVLFactoryIntBoolInt /*P*/ )(/*AddrOf*/F));
    }

  /*private:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::Factory::Factory">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1037,
     FQN="llvm::ImmutableSet::Factory::Factory", NM="_ZN4llvm12ImmutableSet7FactoryC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm12ImmutableSet7FactoryC1ERKS1_")
    //</editor-fold>
    private Factory(final /*const*/ Factory /*&*/ RHS) { throw new UnsupportedOperationException("Deleted");}

    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::Factory::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1038,
     FQN="llvm::ImmutableSet::Factory::operator=", NM="_ZN4llvm12ImmutableSet7FactoryaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm12ImmutableSet7FactoryaSERKS1_")
    //</editor-fold>
    private void $assign(final /*const*/ Factory /*&*/ RHS) { throw new UnsupportedOperationException("Deleted");}

    public void $destroy() {
      this.F.$destroy();
    }
    
    @Override public String toString() {
      return "" + "F=" + F // NOI18N
                + ", Canonicalize=" + Canonicalize; // NOI18N
    }
  };
  
  /*friend  class Factory*/
  
  /// Returns true if the set contains the specified value.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::contains">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1044,
   FQN="llvm::ImmutableSet::contains", NM="_ZNK4llvm12ImmutableSet8containsENT0_14value_type_refE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm12ImmutableSet8containsENT0_14value_type_refE")
  //</editor-fold>
  public boolean contains(int V) /*const*/ {
    assert checkAlive();
    return Root != null ? Root.contains(V) : false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1048,
   FQN="llvm::ImmutableSet::operator==", NM="_ZNK4llvm12ImmutableSeteqERKNS_12ImmutableSetIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm12ImmutableSeteqERKNS_12ImmutableSetIT_T0_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/ ImmutableSetInt /*&*/ RHS) /*const*/ {
    assert RHS.checkAlive();
    assert checkAlive();
    return Root != null && RHS.Root != null ? Root.isEqual(RHS.Root) : Root == RHS.Root;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1052,
   FQN="llvm::ImmutableSet::operator!=", NM="_ZNK4llvm12ImmutableSetneERKNS_12ImmutableSetIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm12ImmutableSetneERKNS_12ImmutableSetIT_T0_EE")
  //</editor-fold>
  public boolean $noteq(final /*const*/ ImmutableSetInt /*&*/ RHS) /*const*/ {
    assert RHS.checkAlive();
    assert checkAlive();
    return !$eq(RHS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::getRoot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1056,
   FQN="llvm::ImmutableSet::getRoot", NM="_ZN4llvm12ImmutableSet7getRootEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm12ImmutableSet7getRootEv")
  //</editor-fold>
  public ImutAVLTreeIntBoolInt /*P*/ getRoot() {
    assert checkAlive();
    if (Root != null) {
      Root.retain();
    }
    return Root;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::getRootWithoutRetain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1061,
   FQN="llvm::ImmutableSet::getRootWithoutRetain", NM="_ZNK4llvm12ImmutableSet20getRootWithoutRetainEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm12ImmutableSet20getRootWithoutRetainEv")
  //</editor-fold>
  public ImutAVLTreeIntBoolInt /*P*/ getRootWithoutRetain() /*const*/ {
    assert checkAlive();
    return Root;
  }

  
  /// isEmpty - Return true if the set contains no elements.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::isEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1066,
   FQN="llvm::ImmutableSet::isEmpty", NM="_ZNK4llvm12ImmutableSet7isEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm12ImmutableSet7isEmptyEv")
  //</editor-fold>
  public boolean isEmpty() /*const*/ {
    assert checkAlive();
    return Root == null;
  }

  
  /// isSingleton - Return true if the set contains exactly one element.
  ///   This method runs in constant time.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::isSingleton">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1070,
   FQN="llvm::ImmutableSet::isSingleton", NM="_ZNK4llvm12ImmutableSet11isSingletonEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm12ImmutableSet11isSingletonEv")
  //</editor-fold>
  public boolean isSingleton() /*const*/ {
    assert checkAlive();
    return Native.$eq(getHeight(), 1);
  }

  
  /*template <typename Callback> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::foreach">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1073,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", old_line = 1072,
   FQN="llvm::ImmutableSet::foreach", NM="Tpl__ZN4llvm12ImmutableSet7foreachERT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN4llvm12ImmutableSet7foreachERT_")
  //</editor-fold>
  public <T extends Int2Void> void foreach(final T /*&*/ C) {
    assert checkAlive();
    if (Root != null) {
      Root.foreach(C);
    }
  }

  
  /*template <typename Callback> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::foreach">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1076,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", old_line = 1075,
   FQN="llvm::ImmutableSet::foreach", NM="Tpl__ZN4llvm12ImmutableSet7foreachEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN4llvm12ImmutableSet7foreachEv")
  //</editor-fold>
  public </*typename*/ Callback> void foreach() {
    assert checkAlive();
    throw new UnsupportedOperationException("Use foreach(new Callback()) instead!");
//    if (Root != null) {
//      Callback C;
//      Root.foreach(C);
//    }
  }

  
  //===--------------------------------------------------===//
  // Iterators.
  //===--------------------------------------------------===//
  /*typedef ImutAVLValueIterator<ImmutableSetInt > iterator*/
//  public final class iterator extends ImutAVLValueIterator<ImmutableSetInt >{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1084,
   FQN="llvm::ImmutableSet::begin", NM="_ZNK4llvm12ImmutableSet5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm12ImmutableSet5beginEv")
  //</editor-fold>
  public ImutAVLValueIteratorIntBoolInt begin() /*const*/ {
    assert checkAlive();
    return new ImutAVLValueIteratorIntBoolInt(Root);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1085,
   FQN="llvm::ImmutableSet::end", NM="_ZNK4llvm12ImmutableSet3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm12ImmutableSet3endEv")
  //</editor-fold>
  public ImutAVLValueIteratorIntBoolInt end() /*const*/ {
    assert checkAlive();
    return new ImutAVLValueIteratorIntBoolInt();
  }

  
  //===--------------------------------------------------===//
  // Utility methods.
  //===--------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::getHeight">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1091,
   FQN="llvm::ImmutableSet::getHeight", NM="_ZNK4llvm12ImmutableSet9getHeightEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm12ImmutableSet9getHeightEv")
  //</editor-fold>
  public /*uint*/int getHeight() /*const*/ {
    assert checkAlive();
    return Root != null ? Root.getHeight() : 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1093,
   FQN="llvm::ImmutableSet::Profile", NM="_ZN4llvm12ImmutableSet7ProfileERNS_16FoldingSetNodeIDERKNS_12ImmutableSetIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm12ImmutableSet7ProfileERNS_16FoldingSetNodeIDERKNS_12ImmutableSetIT_T0_EE")
  //</editor-fold>
  public static  void Profile(final FoldingSetNodeID /*&*/ ID, final /*const*/ ImmutableSetInt /*&*/ S) {
    assert S.checkAlive();
    ID.AddPointer(S.Root);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1097,
   FQN="llvm::ImmutableSet::Profile", NM="_ZNK4llvm12ImmutableSet7ProfileERNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm12ImmutableSet7ProfileERNS_16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    assert checkAlive();
    Profile(ID, this);
    /*JAVA:return*/return;
  }

  
  //===--------------------------------------------------===//
  // For testing.
  //===--------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableSet::validateTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 1103,
   FQN="llvm::ImmutableSet::validateTree", NM="_ZNK4llvm12ImmutableSet12validateTreeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm12ImmutableSet12validateTreeEv")
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
  
  @Override public ImmutableSetInt clone() {
    assert checkAlive();
    return new ImmutableSetInt(this);
  }
  
  @Override public String toString() {
    return (super.is$destroyed() ? "DESTROYED ":"") + "Root=" + Root; // NOI18N
  }
  
  final boolean checkAlive() {
    return check$Alive();
  } 
}
