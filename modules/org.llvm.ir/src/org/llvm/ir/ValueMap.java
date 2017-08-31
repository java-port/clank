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

package org.llvm.ir;

import java.util.function.Supplier;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


/// See the file comment.
/*template <typename KeyT, typename ValueT, typename Config = ValueMapConfig<KeyT>> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ValueMap">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 80,
 FQN="llvm::ValueMap", NM="_ZN4llvm8ValueMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMapE")
//</editor-fold>
public class ValueMap</*typename*/ KeyT, /*typename*/ ValueT/*, typename Config = ValueMapConfig<KeyT>*/>  implements Destructors.ClassWithDestructor {
  /*friend  class ValueMapCallbackVH<KeyT, ValueT, Config>*/
  // JAVA: typedef ValueMapCallbackVH<KeyT, ValueT, Config> ValueMapCVH
//  public final class ValueMapCVH extends ValueMapCallbackVH<KeyT, ValueT>{ };
  // JAVA: typedef DenseMap<ValueMapCVH, ValueT, DenseMapInfo<ValueMapCVH> > MapT
//  public final class MapT extends DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>{ };
  // JAVA: typedef DenseMap<const Metadata *, TrackingMDRef> MDMapT
//  public final class MDMapT extends DenseMap</*const*/ Metadata /*P*/ , TrackingMDRef>{ };
  // JAVA: typedef typename Config::ExtraData ExtraData
//  public final class ExtraData extends /*Config.ExtraData*/Object{ };
  DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT> Map;
  private Optional<DenseMap</*const*/ Metadata /*P*/ , TrackingMDRef> > MDMap;
  /*Config.ExtraData*/Object Data;
  
  private boolean MayMapMetadata/* = true*/;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::ValueMap<KeyT, ValueT, Config>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 93,
   FQN="llvm::ValueMap::ValueMap<KeyT, ValueT, Config>", NM="_ZN4llvm8ValueMapC1ERKNS_8ValueMapIT_T0_T1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMapC1ERKNS_8ValueMapIT_T0_T1_EE")
  //</editor-fold>
  protected/*private*/ ValueMap(final /*const*/ValueMap<KeyT, ValueT>/*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 94,
   FQN="llvm::ValueMap::operator=", NM="_ZN4llvm8ValueMapaSERKNS_8ValueMapIT_T0_T1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMapaSERKNS_8ValueMapIT_T0_T1_EE")
  //</editor-fold>
  protected/*private*/ ValueMap<KeyT, ValueT>/*&*/ $assign(final /*const*/ValueMap<KeyT, ValueT>/*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  // JAVA: typedef KeyT key_type
//  public final class key_type extends KeyT{ };
  // JAVA: typedef ValueT mapped_type
//  public final class mapped_type extends ValueT{ };
  // JAVA: typedef std::pair<KeyT, ValueT> value_type
//  public final class value_type extends std.pair<KeyT, ValueT>{ };
  // JAVA: typedef unsigned int size_type;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::ValueMap<KeyT, ValueT, Config>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 101,
   FQN="llvm::ValueMap::ValueMap<KeyT, ValueT, Config>", NM="_ZN4llvm8ValueMapC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMapC1Ej")
  //</editor-fold>
  public /*explicit*/ ValueMap(ValueMapConfig<KeyT> Config, Supplier<ValueT> supplier) {
    this(Config, supplier, 64);
  }
  public /*explicit*/ ValueMap(ValueMapConfig<KeyT> Config, Supplier<ValueT> supplier, /*uint*/int NumInitBuckets/*= 64*/) {
    // : Map(NumInitBuckets), Data() 
    //START JInit
    this.Config = Config;
    this.supplier = supplier;
    this.Map = /*ParenListExpr*/new DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>(DenseMapInfoValueMapCallbackVH$T$T_0_1$T_0_2.$Info(), NumInitBuckets, supplier.get());//new ValueT());
    this.Data = /*ParenListExpr*/new /*Config.ExtraData*/Object();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::ValueMap<KeyT, ValueT, Config>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 103,
   FQN="llvm::ValueMap::ValueMap<KeyT, ValueT, Config>", NM="_ZN4llvm8ValueMapC1ERKNT1_9ExtraDataEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMapC1ERKNT1_9ExtraDataEj")
  //</editor-fold>
  public /*explicit*/ ValueMap(ValueMapConfig<KeyT> Config, Supplier<ValueT> supplier, final /*const*//*Config.ExtraData*/Object/*&*/ Data) {
    this(Config, supplier, Data, 64);
  }
  public /*explicit*/ ValueMap(ValueMapConfig<KeyT> Config, Supplier<ValueT> supplier, final /*const*//*Config.ExtraData*/Object/*&*/ Data, /*uint*/int NumInitBuckets/*= 64*/) {
    // : Map(NumInitBuckets), Data(Data) 
    //START JInit
    this.Config = Config;
    this.supplier = supplier;
    this.Map = /*ParenListExpr*/new DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>(DenseMapInfoValueMapCallbackVH$T$T_0_1$T_0_2.$Info(), NumInitBuckets, supplier.get());//new ValueT());
    this.Data = Data;///*ParenListExpr*/new /*Config.ExtraData*/Object(Data);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::hasMD">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 106,
   FQN="llvm::ValueMap::hasMD", NM="_ZNK4llvm8ValueMap5hasMDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm8ValueMap5hasMDEv")
  //</editor-fold>
  public boolean hasMD() /*const*/ {
    return MDMap.$bool();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::MD">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 107,
   FQN="llvm::ValueMap::MD", NM="_ZN4llvm8ValueMap2MDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMap2MDEv")
  //</editor-fold>
  public DenseMap</*const*/ Metadata /*P*/ , TrackingMDRef> /*&*/ MD() {
    if (!MDMap.$bool()) {
      MDMap.emplace();
    }
    return $Deref(MDMap.$star());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::getMDMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 112,
   FQN="llvm::ValueMap::getMDMap", NM="_ZN4llvm8ValueMap8getMDMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMap8getMDMapEv")
  //</editor-fold>
  public Optional<DenseMap</*const*/ Metadata /*P*/ , TrackingMDRef> > /*&*/ getMDMap() {
    return MDMap;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::mayMapMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 114,
   FQN="llvm::ValueMap::mayMapMetadata", NM="_ZNK4llvm8ValueMap14mayMapMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm8ValueMap14mayMapMetadataEv")
  //</editor-fold>
  public boolean mayMapMetadata() /*const*/ {
    return MayMapMetadata;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::enableMapMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 115,
   FQN="llvm::ValueMap::enableMapMetadata", NM="_ZN4llvm8ValueMap17enableMapMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMap17enableMapMetadataEv")
  //</editor-fold>
  public void enableMapMetadata() {
    MayMapMetadata = true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::disableMapMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 116,
   FQN="llvm::ValueMap::disableMapMetadata", NM="_ZN4llvm8ValueMap18disableMapMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMap18disableMapMetadataEv")
  //</editor-fold>
  public void disableMapMetadata() {
    MayMapMetadata = false;
  }

  
  /// Get the mapped metadata, if it's in the map.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::getMappedMD">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 119,
   FQN="llvm::ValueMap::getMappedMD", NM="_ZNK4llvm8ValueMap11getMappedMDEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm8ValueMap11getMappedMDEPKNS_8MetadataE")
  //</editor-fold>
  public OptionalPtr<Metadata /*P*/ > getMappedMD(/*const*/ Metadata /*P*/ MD) /*const*/ {
    if (Native.$not(MDMap)) {
      return new OptionalPtr<Metadata /*P*/ >(None);
    }
    DenseMapIterator<Metadata, TrackingMDRef> Where = MDMap.$arrow$Const().find(MD);
    if (Native.$eq(Where, MDMap.$arrow$Const().end())) {
      return new OptionalPtr<Metadata /*P*/ >(None);
    }
    return OptionalPtr.create(Where.$star().second.get());
  }

  
  // JAVA: typedef ValueMapIterator<MapT, KeyT> iterator
//  public final class iterator extends ValueMapIterator<DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>, KeyT>{ };
  // JAVA: typedef ValueMapConstIterator<MapT, KeyT> const_iterator
//  public final class const_iterator extends ValueMapConstIterator<DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>, KeyT>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 130,
   FQN="llvm::ValueMap::begin", NM="_ZN4llvm8ValueMap5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMap5beginEv")
  //</editor-fold>
  public /*inline*/ ValueMapIterator<DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>, KeyT> begin() {
    return new ValueMapIterator<DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>, KeyT>(Map.begin());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 131,
   FQN="llvm::ValueMap::end", NM="_ZN4llvm8ValueMap3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMap3endEv")
  //</editor-fold>
  public /*inline*/ ValueMapIterator<DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>, KeyT> end() {
    return new ValueMapIterator<DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>, KeyT>(Map.end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 132,
   FQN="llvm::ValueMap::begin", NM="_ZNK4llvm8ValueMap5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm8ValueMap5beginEv")
  //</editor-fold>
  public /*inline*/ ValueMapConstIterator<DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>, KeyT> begin$Const() /*const*/ {
    return new ValueMapConstIterator<DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>, KeyT>(Map.begin());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 133,
   FQN="llvm::ValueMap::end", NM="_ZNK4llvm8ValueMap3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm8ValueMap3endEv")
  //</editor-fold>
  public /*inline*/ ValueMapConstIterator<DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>, KeyT> end$Const() /*const*/ {
    return new ValueMapConstIterator<DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>, KeyT>(Map.end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 135,
   FQN="llvm::ValueMap::empty", NM="_ZNK4llvm8ValueMap5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm8ValueMap5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Map.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 136,
   FQN="llvm::ValueMap::size", NM="_ZNK4llvm8ValueMap4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm8ValueMap4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Map.size();
  }

  
  /// Grow the map so that it has at least Size buckets. Does not shrink
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::resize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 139,
   FQN="llvm::ValueMap::resize", NM="_ZN4llvm8ValueMap6resizeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMap6resizeEj")
  //</editor-fold>
  public void resize(/*size_t*/int Size) {
    Map.resize(Size);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 141,
   FQN="llvm::ValueMap::clear", NM="_ZN4llvm8ValueMap5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMap5clearEv")
  //</editor-fold>
  public void clear() {
    Map.clear();
    MDMap.reset();
  }

  
  /// Return 1 if the specified key is in the map, 0 otherwise.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::count">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 147,
   FQN="llvm::ValueMap::count", NM="_ZNK4llvm8ValueMap5countERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm8ValueMap5countERKT_")
  //</editor-fold>
  public /*uint*/int count(final /*const*/ KeyT /*&*/ Val) /*const*/ {
    return Native.$eq(Map.find_as(Val), Map.end()) ? 0 : 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::find">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 151,
   FQN="llvm::ValueMap::find", NM="_ZN4llvm8ValueMap4findERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMap4findERKT_")
  //</editor-fold>
  public ValueMapIterator<DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>, KeyT> find(final /*const*/ KeyT /*&*/ Val) {
    return new ValueMapIterator<DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>, KeyT>(Map.find_as(Val));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::find">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 154,
   FQN="llvm::ValueMap::find", NM="_ZNK4llvm8ValueMap4findERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm8ValueMap4findERKT_")
  //</editor-fold>
  public ValueMapConstIterator<DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>, KeyT> find$Const(final /*const*/ KeyT /*&*/ Val) /*const*/ {
    return new ValueMapConstIterator<DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>, KeyT>(Map.find_as(Val));
  }

  
  /// lookup - Return the entry for the specified key, or a default
  /// constructed value if no such entry exists.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::lookup">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 160,
   FQN="llvm::ValueMap::lookup", NM="_ZNK4llvm8ValueMap6lookupERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm8ValueMap6lookupERKT_")
  //</editor-fold>
  public ValueT lookup(final /*const*/ KeyT /*&*/ Val) /*const*/ {
    DenseMapIterator<ValueMapCallbackVH<KeyT, ValueT>, ValueT> I = Map.find_as(Val);
    return Native.$noteq(I, Map.end()) ? I.$star().second : supplier.get();//new ValueT();
  }

  
  // Inserts key,value pair into the map if the key isn't already in the map.
  // If the key is already in the map, it returns false and doesn't update the
  // value.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::insert">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 168,
   FQN="llvm::ValueMap::insert", NM="_ZN4llvm8ValueMap6insertERKSt4pairIT_T0_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMap6insertERKSt4pairIT_T0_E")
  //</editor-fold>
  public std.pairTypeBool<ValueMapIterator> insert_pair$KeyT$ValueT$C(final /*const*/ std.pair<KeyT, ValueT> /*&*/ KV) {
    pairTypeBool<DenseMapIterator<ValueMapCallbackVH<KeyT, ValueT>, ValueT>> MapResult = Map.insert(std.make_pair(Wrap(KV.first), KV.second));
    return std.make_pair_T_bool(new ValueMapIterator<DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>, KeyT>(MapResult.first), MapResult.second);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 173,
   FQN="llvm::ValueMap::insert", NM="_ZN4llvm8ValueMap6insertEOSt4pairIT_T0_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMap6insertEOSt4pairIT_T0_E")
  //</editor-fold>
  public std.pairTypeBool<ValueMapIterator> insert_pair$KeyT$ValueT(final std.pair<KeyT, ValueT> /*&&*/KV) {
    pairTypeBool<DenseMapIterator<ValueMapCallbackVH<KeyT, ValueT>, ValueT>> MapResult = Map.insert(std.make_pair(Wrap(KV.first), std.move(KV.second)));
    return std.make_pair_T_bool(new ValueMapIterator<DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>, KeyT>(MapResult.first), MapResult.second);
  }

  
  /// insert - Range insertion of pairs.
  /*template <typename InputIt> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::insert">
  @Converted(kind = Converted.Kind.MANUAL_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 181,
   FQN="llvm::ValueMap::insert", NM="Tpl__ZN4llvm8ValueMap6insertET_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=Tpl__ZN4llvm8ValueMap6insertET_S1_")
  //</editor-fold>
  public </*typename*/ InputIt> void insert$T(InputIt I, InputIt E) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::erase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 187,
   FQN="llvm::ValueMap::erase", NM="_ZN4llvm8ValueMap5eraseERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMap5eraseERKT_")
  //</editor-fold>
  public boolean erase(final /*const*/ KeyT /*&*/ Val) {
    DenseMapIterator<ValueMapCallbackVH<KeyT, ValueT>, ValueT> I = Map.find_as(Val);
    if (Native.$eq(I, Map.end())) {
      return false;
    }
    
    Map.erase(I);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::erase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 195,
   FQN="llvm::ValueMap::erase", NM="_ZN4llvm8ValueMap5eraseENS_16ValueMapIteratorINS_8DenseMapINS_18ValueMapCallbackVHIT_T0_T1_EES5_NS_12DenseMapInfoIS7_EENS_6detail12DenseMapPairIS7_S5_EEEES4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMap5eraseENS_16ValueMapIteratorINS_8DenseMapINS_18ValueMapCallbackVHIT_T0_T1_EES5_NS_12DenseMapInfoIS7_EENS_6detail12DenseMapPairIS7_S5_EEEES4_EE")
  //</editor-fold>
  public void erase(ValueMapIterator<DenseMap<ValueMapCallbackVH<KeyT, ValueT>, ValueT>, KeyT> I) {
    Map.erase(I.base());
    /*JAVA:return*/return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::FindAndConstruct">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 199,
   FQN="llvm::ValueMap::FindAndConstruct", NM="_ZN4llvm8ValueMap16FindAndConstructERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMap16FindAndConstructERKT_")
  //</editor-fold>
  public std.pair<ValueMapCallbackVH<KeyT, ValueT>, ValueT> /*&*/ FindAndConstruct(final /*const*/ KeyT /*&*/ Key) {
    return Map.FindAndConstruct(Wrap(Key));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 203,
   FQN="llvm::ValueMap::operator[]", NM="_ZN4llvm8ValueMapixERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm8ValueMapixERKT_")
  //</editor-fold>
  public ValueT /*&*/ $at(final /*const*/ KeyT /*&*/ Key) {
    return Map.$at(Wrap(Key));
  }

  
  /// isPointerIntoBucketsArray - Return true if the specified pointer points
  /// somewhere into the ValueMap's array of buckets (i.e. either to a key or
  /// value in the ValueMap).
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::isPointerIntoBucketsArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 210,
   FQN="llvm::ValueMap::isPointerIntoBucketsArray", NM="_ZNK4llvm8ValueMap25isPointerIntoBucketsArrayEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm8ValueMap25isPointerIntoBucketsArrayEPKv")
  //</editor-fold>
  public boolean isPointerIntoBucketsArray(/*const*/Object/*void P*/ Ptr) /*const*/ {
    return Map.isPointerIntoBucketsArray(Ptr);
  }

  
  /// getPointerIntoBucketsArray() - Return an opaque pointer into the buckets
  /// array.  In conjunction with the previous method, this can be used to
  /// determine whether an insertion caused the ValueMap to reallocate.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::getPointerIntoBucketsArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 217,
   FQN="llvm::ValueMap::getPointerIntoBucketsArray", NM="_ZNK4llvm8ValueMap26getPointerIntoBucketsArrayEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm8ValueMap26getPointerIntoBucketsArrayEv")
  //</editor-fold>
  public /*const*/Object/*void P*/ getPointerIntoBucketsArray() /*const*/ {
    return Map.getPointerIntoBucketsArray();
  }

/*private:*/
  // Takes a key being looked up in the map and wraps it into a
  // ValueMapCallbackVH, the actual key type of the map.  We use a helper
  // function because ValueMapCVH is constructed with a second parameter.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMap::Wrap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 225,
   FQN="llvm::ValueMap::Wrap", NM="_ZNK4llvm8ValueMap4WrapET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm8ValueMap4WrapET_")
  //</editor-fold>
  private ValueMapCallbackVH<KeyT, ValueT> Wrap(KeyT key) /*const*/ {
    // The only way the resulting CallbackVH could try to modify *this (making
    // the const_cast incorrect) is if it gets inserted into the map.  But then
    // this function must have been called from a non-const method, making the
    // const_cast ok.
    return new ValueMapCallbackVH<KeyT, ValueT>(key, ((/*const_cast*/ValueMap<KeyT, ValueT>/*P*/ )(this)));
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  final ValueMapConfig<KeyT> Config;
  
  private final Supplier<ValueT> supplier;
  
  @Override public void $destroy() {}
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Map=" + Map // NOI18N
              + ", MDMap=" + MDMap // NOI18N
              + ", Data=" + Data // NOI18N
              + ", MayMapMetadata=" + MayMapMetadata; // NOI18N
  }
}
