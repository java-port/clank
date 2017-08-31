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

package org.clang.staticanalyzer.core.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.staticanalyzer.core.llvm.impl.StaticanalyzerLlvmStatics.$out_raw_ostream_BindingKey;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 152,
 FQN="(anonymous namespace)::RegionBindingsRef", NM="_ZN12_GLOBAL__N_117RegionBindingsRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_117RegionBindingsRefE")
//</editor-fold>
public class RegionBindingsRef extends /*public*/ ImmutableMapRefPtrType</*const*/ MemRegion /*P*/ , ImmutableMap<BindingKey, SVal> > implements Destructors.ClassWithDestructor, NativeMoveable<RegionBindingsRef> {
  private ImmutableMap.Factory<BindingKey, SVal> /*P*/ CBFactory;
/*public:*/
  /*typedef llvm::ImmutableMapRef<const MemRegion *, ClusterBindings> ParentTy*/
//  public final class ParentTy extends ImmutableMapRef</*const*/ MemRegion /*P*/ , ImmutableMap<BindingKey, SVal> >{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::RegionBindingsRef">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 160,
   FQN="(anonymous namespace)::RegionBindingsRef::RegionBindingsRef", NM="_ZN12_GLOBAL__N_117RegionBindingsRefC1ERN4llvm12ImmutableMapINS_10BindingKeyEN5clang4ento4SValENS1_16ImutKeyValueInfoIS3_S6_EEE7FactoryEPKNS1_11ImutAVLTreeINS7_IPKNS5_9MemRegionES9_EEEEPNS1_14ImutAVLFactoryISG_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_117RegionBindingsRefC1ERN4llvm12ImmutableMapINS_10BindingKeyEN5clang4ento4SValENS1_16ImutKeyValueInfoIS3_S6_EEE7FactoryEPKNS1_11ImutAVLTreeINS7_IPKNS5_9MemRegionES9_EEEEPNS1_14ImutAVLFactoryISG_EE")
  //</editor-fold>
  public RegionBindingsRef(final ImmutableMap.Factory<BindingKey, SVal> /*&*/ CBFactory, 
      /*const*/ ImutAVLTreePtrTypeType</*const*/ MemRegion /*P*/ , ImmutableMap<BindingKey, SVal>, std.pairPtrType</*const*/ MemRegion /*P*/ , ImmutableMap<BindingKey, SVal>> > /*P*/ T, 
      ImutAVLFactoryPtrTypeType</*const*/ MemRegion /*P*/ , ImmutableMap<BindingKey, SVal>, std.pairPtrType</*const*/ MemRegion /*P*/ , ImmutableMap<BindingKey, SVal>> > /*P*/ F) {
    // : ImmutableMapRef<const MemRegion * , ClusterBindings>(T, F), CBFactory(&CBFactory) 
    //START JInit
    super(T, F);
    this.CBFactory = $AddrOf(CBFactory);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::RegionBindingsRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 166,
   FQN="(anonymous namespace)::RegionBindingsRef::RegionBindingsRef", NM="_ZN12_GLOBAL__N_117RegionBindingsRefC1ERKN4llvm15ImmutableMapRefIPKN5clang4ento9MemRegionENS1_12ImmutableMapINS_10BindingKeyENS4_4SValENS1_16ImutKeyValueInfoIS9_SA_EEEENSB_IS7_SD_EEEERNSD_7FactoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_117RegionBindingsRefC1ERKN4llvm15ImmutableMapRefIPKN5clang4ento9MemRegionENS1_12ImmutableMapINS_10BindingKeyENS4_4SValENS1_16ImutKeyValueInfoIS9_SA_EEEENSB_IS7_SD_EEEERNSD_7FactoryE")
  //</editor-fold>
  public RegionBindingsRef(final /*const*/ ImmutableMapRefPtrType</*const*/ MemRegion /*P*/ , ImmutableMap<BindingKey, SVal> > /*&*/ P, final ImmutableMap.Factory<BindingKey, SVal> /*&*/ CBFactory) {
    // : ImmutableMapRef<const MemRegion * , ClusterBindings>(P), CBFactory(&CBFactory) 
    //START JInit
    super(P);
    this.CBFactory = $AddrOf(CBFactory);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 170,
   FQN="(anonymous namespace)::RegionBindingsRef::add", NM="_ZNK12_GLOBAL__N_117RegionBindingsRef3addERKPKN5clang4ento9MemRegionERKN4llvm12ImmutableMapINS_10BindingKeyENS2_4SValENS8_16ImutKeyValueInfoISA_SB_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_117RegionBindingsRef3addERKPKN5clang4ento9MemRegionERKN4llvm12ImmutableMapINS_10BindingKeyENS2_4SValENS8_16ImutKeyValueInfoISA_SB_EEEE")
  //</editor-fold>
  public RegionBindingsRef add(final /*const*/ MemRegion /*&*/ K, final /*const*/ImmutableMap<BindingKey, SVal> /*&*/ D) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new RegionBindingsRef($c$.track(/*JCast:const ImmutableMapRef<const MemRegion * , ImmutableMap<BindingKey, SVal> > * */super.add(K, D)), 
          $Deref(CBFactory)));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::remove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 175,
   FQN="(anonymous namespace)::RegionBindingsRef::remove", NM="_ZNK12_GLOBAL__N_117RegionBindingsRef6removeERKPKN5clang4ento9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_117RegionBindingsRef6removeERKPKN5clang4ento9MemRegionE")
  //</editor-fold>
  public RegionBindingsRef remove(final /*const*/ MemRegion /*&*/ K) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new RegionBindingsRef($c$.track(/*JCast:const ImmutableMapRef<const MemRegion * , ImmutableMap<BindingKey, SVal> > * */super.remove(K)), 
          $Deref(CBFactory)));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::addBinding">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 240,
   FQN="(anonymous namespace)::RegionBindingsRef::addBinding", NM="_ZNK12_GLOBAL__N_117RegionBindingsRef10addBindingENS_10BindingKeyEN5clang4ento4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_117RegionBindingsRef10addBindingENS_10BindingKeyEN5clang4ento4SValE")
  //</editor-fold>
  public RegionBindingsRef addBinding(BindingKey K, SVal V) /*const*/ {
    ImmutableMap<BindingKey, SVal> Cluster = null;
    ImmutableMap<BindingKey, SVal> NewCluster = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ MemRegion /*P*/ Base = K.getBaseRegion();

      /*const*/ type$ptr<ImmutableMap<BindingKey, SVal>> /*P*/ ExistingCluster = lookup(Base);
      Cluster = ((ExistingCluster != null) ? new ImmutableMap<BindingKey, SVal>($Deref(ExistingCluster.$star())) : CBFactory.getEmptyMap());

      NewCluster = $c$.clean(CBFactory.add($c$.track(new ImmutableMap<BindingKey, SVal>(Cluster)), K, V));
      return add(Base, NewCluster);
    } finally {
      if (NewCluster != null) { NewCluster.$destroy(); }
      if (Cluster != null) { Cluster.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::addBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 252,
   FQN="(anonymous namespace)::RegionBindingsRef::addBinding", NM="_ZNK12_GLOBAL__N_117RegionBindingsRef10addBindingEPKN5clang4ento9MemRegionENS_10BindingKey4KindENS2_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_117RegionBindingsRef10addBindingEPKN5clang4ento9MemRegionENS_10BindingKey4KindENS2_4SValE")
  //</editor-fold>
  public RegionBindingsRef addBinding(/*const*/ MemRegion /*P*/ R, 
            /*BindingKey::Kind*//*uint*/int k, 
            SVal V) /*const*/ {
    return addBinding(BindingKey.Make(R, k), new SVal(V));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::lookup">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 258,
   FQN="(anonymous namespace)::RegionBindingsRef::lookup", NM="_ZNK12_GLOBAL__N_117RegionBindingsRef6lookupENS_10BindingKeyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_117RegionBindingsRef6lookupENS_10BindingKeyE")
  //</editor-fold>
  public /*const*/ type$ptr<SVal> /*P*/ lookup(BindingKey K) /*const*/ {
    /*const*/ type$ptr<ImmutableMap<BindingKey, SVal>> /*P*/ Cluster = lookup(K.getBaseRegion());
    if (!(Cluster != null)) {
      return null;
    }
    return Cluster.$arrow().lookup(K);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::lookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 265,
   FQN="(anonymous namespace)::RegionBindingsRef::lookup", NM="_ZNK12_GLOBAL__N_117RegionBindingsRef6lookupEPKN5clang4ento9MemRegionENS_10BindingKey4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_117RegionBindingsRef6lookupEPKN5clang4ento9MemRegionENS_10BindingKey4KindE")
  //</editor-fold>
  public /*const*/ type$ptr<SVal> /*P*/ lookup(/*const*/ MemRegion /*P*/ R, 
        /*BindingKey::Kind*//*uint*/int k) /*const*/ {
    return lookup(BindingKey.Make(R, k));
  }

  //JAVA: using llvm::ImmutableMapRef</*const*/ MemRegion /*P*/ , ImmutableMap<BindingKey, SVal> >::lookup;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::removeBinding">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 270,
   FQN="(anonymous namespace)::RegionBindingsRef::removeBinding", NM="_ZN12_GLOBAL__N_117RegionBindingsRef13removeBindingENS_10BindingKeyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_117RegionBindingsRef13removeBindingENS_10BindingKeyE")
  //</editor-fold>
  public RegionBindingsRef removeBinding(BindingKey K) {
    ImmutableMap<BindingKey, SVal> NewCluster = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ MemRegion /*P*/ Base = K.getBaseRegion();
      /*const*/ type$ptr<ImmutableMap<BindingKey, SVal>> /*P*/ Cluster = lookup(Base);
      if (!(Cluster != null)) {
        return new RegionBindingsRef(/*Deref*/this);
      }

      NewCluster = $c$.clean(CBFactory.remove($c$.track(new ImmutableMap<BindingKey, SVal>($Deref(Cluster.$star()))), K));
      if (NewCluster.isEmpty()) {
        return remove(Base);
      }
      return add(Base, NewCluster);
    } finally {
      if (NewCluster != null) { NewCluster.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::removeBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 282,
   FQN="(anonymous namespace)::RegionBindingsRef::removeBinding", NM="_ZN12_GLOBAL__N_117RegionBindingsRef13removeBindingEPKN5clang4ento9MemRegionENS_10BindingKey4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_117RegionBindingsRef13removeBindingEPKN5clang4ento9MemRegionENS_10BindingKey4KindE")
  //</editor-fold>
  public RegionBindingsRef removeBinding(/*const*/ MemRegion /*P*/ R, 
               /*BindingKey::Kind*//*uint*/int k) {
    return removeBinding(BindingKey.Make(R, k));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::removeBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 194,
   FQN="(anonymous namespace)::RegionBindingsRef::removeBinding", NM="_ZN12_GLOBAL__N_117RegionBindingsRef13removeBindingEPKN5clang4ento9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_117RegionBindingsRef13removeBindingEPKN5clang4ento9MemRegionE")
  //</editor-fold>
  public RegionBindingsRef removeBinding(/*const*/ MemRegion /*P*/ R) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($c$.track(removeBinding(R, BindingKey.Kind.Direct)).
          removeBinding(R, BindingKey.Kind.Default));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::getDirectBinding">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 227,
   FQN="(anonymous namespace)::RegionBindingsRef::getDirectBinding", NM="_ZNK12_GLOBAL__N_117RegionBindingsRef16getDirectBindingEPKN5clang4ento9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_117RegionBindingsRef16getDirectBindingEPKN5clang4ento9MemRegionE")
  //</editor-fold>
  public Optional<SVal> getDirectBinding(/*const*/ MemRegion /*P*/ R) /*const*/ {
    return Optional.<SVal>createFromPtr(lookup(R, BindingKey.Kind.Direct));
  }

  
  /// getDefaultBinding - Returns an SVal* representing an optional default
  ///  binding associated with a region and its subregions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::getDefaultBinding">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 231,
   FQN="(anonymous namespace)::RegionBindingsRef::getDefaultBinding", NM="_ZNK12_GLOBAL__N_117RegionBindingsRef17getDefaultBindingEPKN5clang4ento9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_117RegionBindingsRef17getDefaultBindingEPKN5clang4ento9MemRegionE")
  //</editor-fold>
  public Optional<SVal> getDefaultBinding(/*const*/ MemRegion /*P*/ R) /*const*/ {
    if (R.isBoundable()) {
      {
        /*const*/ TypedValueRegion /*P*/ TR = dyn_cast_TypedValueRegion(R);
        if ((TR != null)) {
          if (TR.getValueType().$arrow().isUnionType()) {
            return new Optional<SVal>(JD$T$RR.INSTANCE, new UnknownVal());
          }
        }
      }
    }
    return Optional.<SVal>createFromPtr(lookup(R, BindingKey.Kind.Default));
  }

  
  /// Return the internal tree as a Store.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::asStore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 206,
   FQN="(anonymous namespace)::RegionBindingsRef::asStore", NM="_ZNK12_GLOBAL__N_117RegionBindingsRef7asStoreEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_117RegionBindingsRef7asStoreEv")
  //</editor-fold>
  public /*const*/Object/*void P*/ asStore() /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($c$.track(asImmutableMap()).getRootWithoutRetain());
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::dump">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 210,
   FQN="(anonymous namespace)::RegionBindingsRef::dump", NM="_ZNK12_GLOBAL__N_117RegionBindingsRef4dumpERN4llvm11raw_ostreamEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_117RegionBindingsRef4dumpERN4llvm11raw_ostreamEPKc")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ OS, /*const*/char$ptr/*char P*/ nl) /*const*/ {
    ImmutableMapRefPtrType.iterator</*const*/ MemRegion /*P*/ , ImmutableMap<BindingKey, SVal>> I = null;
    ImmutableMapRefPtrType.iterator</*const*/ MemRegion /*P*/ , ImmutableMap<BindingKey, SVal>> E = null;
    try {
      for (I = begin(), E = end(); I.$noteq(E); I.$preInc()) {
        final /*const*/ ImmutableMap<BindingKey, SVal> /*&*/ Cluster = I.getData();
        ImmutableMap.iterator<BindingKey, SVal> CI = null;
        ImmutableMap.iterator<BindingKey, SVal> CE = null;
        try {
          for (CI = Cluster.begin(), CE = Cluster.end();
               CI.$noteq(CE); CI.$preInc()) {
            $out_raw_ostream_SVal($out_raw_ostream_BindingKey(OS.$out_char($$SPACE), /*NO_COPY*/CI.getKey()).$out(/*KEEP_STR*/" : "), /*NO_COPY*/CI.getData()).$out(nl);
          }
        } finally {
          if (CE != null) { CE.$destroy(); }
          if (CI != null) { CI.$destroy(); }
        }
        OS.$out(nl);
      }
    } finally {
      if (E != null) { E.$destroy(); }
      if (I != null) { I.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 221,
   FQN="(anonymous namespace)::RegionBindingsRef::dump", NM="_ZNK12_GLOBAL__N_117RegionBindingsRef4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_117RegionBindingsRef4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dump(llvm.errs(), $LF);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::RegionBindingsRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 152,
   FQN="(anonymous namespace)::RegionBindingsRef::RegionBindingsRef", NM="_ZN12_GLOBAL__N_117RegionBindingsRefC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_117RegionBindingsRefC1EOS0_")
  //</editor-fold>
  public /*inline*/ RegionBindingsRef(JD$Move _dparam, final RegionBindingsRef /*&&*/$Prm0) {
    // : ImmutableMapRef<const MemRegion * , ClusterBindings>(static_cast<RegionBindingsRef &&>()), CBFactory(static_cast<RegionBindingsRef &&>().CBFactory) 
    //START JInit
    super($Prm0);
    this.CBFactory = $Prm0.CBFactory;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 152,
   FQN="(anonymous namespace)::RegionBindingsRef::operator=", NM="_ZN12_GLOBAL__N_117RegionBindingsRefaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_117RegionBindingsRefaSEOS0_")
  //</editor-fold>
  public /*inline*/ RegionBindingsRef /*&*/ $assignMove(final RegionBindingsRef /*&&*/$Prm0) {
    /*J:ToBase*/super.$assign($Prm0);
    this.CBFactory = $Prm0.CBFactory;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::~RegionBindingsRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 152,
   FQN="(anonymous namespace)::RegionBindingsRef::~RegionBindingsRef", NM="_ZN12_GLOBAL__N_117RegionBindingsRefD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_117RegionBindingsRefD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionBindingsRef::RegionBindingsRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 152,
   FQN="(anonymous namespace)::RegionBindingsRef::RegionBindingsRef", NM="_ZN12_GLOBAL__N_117RegionBindingsRefC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_117RegionBindingsRefC1ERKS0_")
  //</editor-fold>
  public /*inline*/ RegionBindingsRef(final /*const*/ RegionBindingsRef /*&*/ $Prm0) {
    // : ImmutableMapRef<const MemRegion * , ClusterBindings>(), CBFactory(.CBFactory) 
    //START JInit
    super($Prm0);
    this.CBFactory = $Prm0.CBFactory;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private void dumpToString(raw_ostream OS) {
    dump(OS, $LF);
  }
  
  @Override
  public RegionBindingsRef move() {
    return new RegionBindingsRef(JD$Move.INSTANCE, this);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    if (true) {
      return llvm.DumpJavaString(this, RegionBindingsRef::dumpToString);
    }        
    return "" + "CBFactory=" + CBFactory // NOI18N
              + super.toString(); // NOI18N
  }
}
