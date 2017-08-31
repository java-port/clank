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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.DenseMapInfo;

/// This class implements a map that also provides access to all stored values
/// in a deterministic order. The values are kept in a std::vector and the
/// mapping is done with DenseMap from Keys to indexes in that vector.
/*template <typename KeyT, typename ValueT, typename MapType = llvm::DenseMap<KeyT, unsigned int>, typename VectorType = std::vector<std::pair<KeyT, ValueT> >> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::MapVector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 29,
 FQN="llvm::MapVector", NM="_ZN4llvm9MapVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MapVectorE")
//</editor-fold>
public class MapVectorIntType<ValueT> extends NativeTrace.CreateDestroy$Tracker
 implements Iterable<std.pairIntType<ValueT>>, Destructors.ClassWithDestructor {
  /*typedef typename VectorType::size_type size_type*/
//  public final class size_type extends  VectorType.size_type{ };
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private final ValueT defaultValue;
  
  private DenseMapIntUInt Map;
  private std.vector<std.pairIntType<ValueT>> Vector;
/*public:*/
  /*typedef typename VectorType::iterator iterator*/
//  public final class iterator extends  VectorType.iterator{ };
  /*typedef typename VectorType::const_iterator const_iterator*/
//  public final class const_iterator extends  VectorType.const_iterator{ };
  /*typedef typename VectorType::reverse_iterator reverse_iterator*/
//  public final class reverse_iterator extends  VectorType.reverse_iterator{ };
  /*typedef typename VectorType::const_reverse_iterator const_reverse_iterator*/
//  public final class const_reverse_iterator extends  VectorType.const_reverse_iterator{ };

//  Must use constructor with specified keyInfo and default value
//  @Converted(kind = Converted.Kind.MANUAL_ADDED)
//  public MapVectorIntType() {
//    this(DenseMapInfoInt.$Info(), (ValueT)defaultValue);
//  }
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public MapVectorIntType(DenseMapInfoInt keyInfo, ValueT defaultValue) {
    assert keyInfo != null : "forgot to pass keyInfo?";
    this.Map = new DenseMapIntUInt(keyInfo, 0);
    this.Vector = new std.vector<std.pairIntType<ValueT>>(new std.pairIntType<ValueT>((int)0, (ValueT)defaultValue));
    this.defaultValue = defaultValue;
    assert (defaultValue instanceof NativeCloneable) && NativeTrace.assertDefaultValue(defaultValue);
  }
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public MapVectorIntType(MapVectorIntType<ValueT> Other) {
    assert Other.checkAlive();
    this.defaultValue = Other.defaultValue;
    this.Map = new DenseMapIntUInt(Other.Map.keyInfoT, 0);
    this.Map.$assign(Other.Map);
    this.Vector = new std.vector<std.pairIntType<ValueT>>(new std.pairIntType<ValueT>((int)0, (ValueT)Other.defaultValue));
    this.Vector.$assign(Other.Vector);
  }
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public MapVectorIntType(JD$Move _diff, MapVectorIntType<ValueT> Other) {
    assert Other.checkAlive();
    this.defaultValue = Other.defaultValue;
    this.Map = new DenseMapIntUInt(Other.Map.keyInfoT, 0);
    this.Map.$assignMove(Other.Map);
    this.Vector = new std.vector<std.pairIntType<ValueT>>(new std.pairIntType<ValueT>((int)0, (ValueT)Other.defaultValue));
    this.Vector.$assignMove(Other.Vector);
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MapVector::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 44,
   FQN="llvm::MapVector::size", NM="_ZNK4llvm9MapVector4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MapVector4sizeEv")
  //</editor-fold>
  public  int size() /*const*/ {
    assert checkAlive();
    return Vector.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MapVector::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 46,
   FQN="llvm::MapVector::begin", NM="_ZN4llvm9MapVector5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MapVector5beginEv")
  //</editor-fold>
  public  std.vector.iterator<std.pairIntType<ValueT>> begin() {
    assert checkAlive();
    return Vector.begin();
  }

  ////<editor-fold defaultstate="collapsed" desc="llvm::MapVector::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 47,
   FQN="llvm::MapVector::begin", NM="_ZNK4llvm9MapVector5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MapVector5beginEv")
  //</editor-fold>
  public final std.vector.iterator<std.pairIntType<ValueT>> begin$Const() /*const*/ {
    assert checkAlive();
    return Vector.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MapVector::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 48,
   FQN="llvm::MapVector::end", NM="_ZN4llvm9MapVector3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MapVector3endEv")
  //</editor-fold>
  public  std.vector.iterator<std.pairIntType<ValueT>> end() {
    assert checkAlive();
    return Vector.end();
  }

  ////<editor-fold defaultstate="collapsed" desc="llvm::MapVector::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 49,
   FQN="llvm::MapVector::end", NM="_ZNK4llvm9MapVector3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MapVector3endEv")
  //</editor-fold>
  public final std.vector.iterator<std.pairIntType<ValueT>> end$Const() /*const*/ {
    assert checkAlive();
    return Vector.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MapVector::rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 51,
   FQN="llvm::MapVector::rbegin", NM="_ZN4llvm9MapVector6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MapVector6rbeginEv")
  //</editor-fold>
  public  std.reverse_iterator<std.pairIntType<ValueT>> rbegin() {
    assert checkAlive();
    return Vector.rbegin();
  }

  ////<editor-fold defaultstate="collapsed" desc="llvm::MapVector::rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 52,
   FQN="llvm::MapVector::rbegin", NM="_ZNK4llvm9MapVector6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MapVector6rbeginEv")
  //</editor-fold>
  public final std.reverse_iterator<std.pairIntType<ValueT>> rbegin$Const() /*const*/ {
    assert checkAlive();
    return Vector.rbegin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MapVector::rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 53,
   FQN="llvm::MapVector::rend", NM="_ZN4llvm9MapVector4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MapVector4rendEv")
  //</editor-fold>
  public  std.reverse_iterator<std.pairIntType<ValueT>> rend() {
    assert checkAlive();
    return Vector.rend();
  }

  ////<editor-fold defaultstate="collapsed" desc="llvm::MapVector::rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 54,
   FQN="llvm::MapVector::rend", NM="_ZNK4llvm9MapVector4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MapVector4rendEv")
  //</editor-fold>
  public final std.reverse_iterator<std.pairIntType<ValueT>> rend$Const() /*const*/ {
    assert checkAlive();
    return Vector.rend$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MapVector::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 56,
   FQN="llvm::MapVector::empty", NM="_ZNK4llvm9MapVector5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MapVector5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    assert checkAlive();
    return Vector.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MapVector::front">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 60,
   FQN="llvm::MapVector::front", NM="_ZN4llvm9MapVector5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MapVector5frontEv")
  //</editor-fold>
  public std.pairIntType<ValueT> /*&*/ front() {
    assert checkAlive();
    return Vector.front();
  }

  ////<editor-fold defaultstate="collapsed" desc="llvm::MapVector::front">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 61,
   FQN="llvm::MapVector::front", NM="_ZNK4llvm9MapVector5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MapVector5frontEv")
  //</editor-fold>
  public final /*const*/ std.pairIntType<ValueT> /*&*/ front$Const() /*const*/ {
    assert checkAlive();
    return Vector.front$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MapVector::back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 62,
   FQN="llvm::MapVector::back", NM="_ZN4llvm9MapVector4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MapVector4backEv")
  //</editor-fold>
  public std.pairIntType<ValueT> /*&*/ back() {
    assert checkAlive();
    return Vector.back();
  }

  ////<editor-fold defaultstate="collapsed" desc="llvm::MapVector::back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 63,
   FQN="llvm::MapVector::back", NM="_ZNK4llvm9MapVector4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MapVector4backEv")
  //</editor-fold>
  public final /*const*/ std.pairIntType<ValueT> /*&*/ back$Const() /*const*/ {
    assert checkAlive();
    return Vector.back$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MapVector::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 65,
   FQN="llvm::MapVector::clear", NM="_ZN4llvm9MapVector5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MapVector5clearEv")
  //</editor-fold>
  public void clear() {
    assert checkAlive();
    Map.clear();
    Vector.clear();
  }

  @Override
  public void $destroy() {
    assert checkAlive();
    Map.$destroy();
    Vector.$destroy();
    super.set$destroyed();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MapVector::swap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 70,
   FQN="llvm::MapVector::swap", NM="_ZN4llvm9MapVector4swapERNS_9MapVectorIT_T0_T1_T2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MapVector4swapERNS_9MapVectorIT_T0_T1_T2_EE")
  //</editor-fold>
  public void swap(MapVectorIntType<ValueT> /*&*/ RHS) {
    assert RHS.checkAlive();
    assert checkAlive();
    //std.swap(Map, RHS.Map);
    DenseMapIntUInt tempMap = this.Map;
    this.Map = RHS.Map;
    RHS.Map = tempMap;
    //std.swap(Vector, RHS.Vector);
    std.vector<std.pairIntType<ValueT>> tempVector = this.Vector;
    this.Vector = RHS.Vector;
    RHS.Vector = tempVector;
  }

  public ValueT /*&*/ $set(/*const*/ int /*&*/ Key, ValueT Value) {
    assert checkAlive();
    return ref$at(Key).$set(Value);
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MapVector::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 75,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", old_line = 70,
   FQN="llvm::MapVector::operator[]", NM="_ZN4llvm9MapVectorixERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MapVectorixERKT_")
  //</editor-fold>
  public ValueT /*&*/ $at(/*const*/ int /*&*/ Key) {
    assert checkAlive();
    std.pairIntUInt Pair = new std.pairIntUInt(Key, 0);
    std.pairTypeBool<DenseMapIteratorIntUInt> Result = Map.insert(Pair);
    if (Result.second) {
      Vector.push_back(new std.pairIntType<ValueT>(Key, $ValueT()));
      Result.first.$arrow().second = Vector.size() - 1;
    }
    final /*uint*/int I = Result.first.$arrow().second;
    return Vector.$at(I).second;
  }

  public type$ref<ValueT> /*&*/ ref$at(final /*const*/int /*&*/ Key) {
    assert checkAlive();
    final std.pairIntUInt Pair = new std.pairIntUInt(Key, 0);
    final std.pairTypeBool<DenseMapIteratorIntUInt> Result = Map.insert(Pair);
    if (Result.second) {
      Vector.push_back(new std.pairIntType<ValueT>(Key, $ValueT()));
      Result.first.$arrow().second = Vector.size() - 1;
    }
    final /*uint*/int I = Result.first.$arrow().second;
    return new type$ref<ValueT>() {      
      @Override
      public ValueT $deref() {
        assert checkAlive();
        assert Native.$eq(Key, Pair.first);
        return Vector.$at(I).second;
      }

      @Override
      public ValueT $set(ValueT value) {
        assert checkAlive();
        assert Native.$eq(Key, Pair.first);
        Vector.$at(I).second = (isDataPointerLike() ? value : $tryClone(value));
        return value;
      }

      @Override
      public String toString() {
        return "$(" + Key + ")\n => [" + Vector.$at(I).second + "]";
      }
    };
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MapVector::lookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 86,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", old_line = 81,
   FQN="llvm::MapVector::lookup", NM="_ZNK4llvm9MapVector6lookupERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MapVector6lookupERKT_")
  //</editor-fold>
  public ValueT lookup(/*const*/ int /*&*/ Key) /*const*/ {
    assert checkAlive();
    DenseMapIteratorIntUInt Pos = Map.find(Key);
    return Native.$eq_iter(Pos, Map.end()) ? $ValueT() : Vector.$at(Pos.$arrow().second).second;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MapVector::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 91,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", old_line = 86,
   FQN="llvm::MapVector::insert", NM="_ZN4llvm9MapVector6insertERKSt4pairIT_T0_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MapVector6insertERKSt4pairIT_T0_E")
  //</editor-fold>
  public std.pairTypeBool<std.vector.iterator<std.pairIntType<ValueT>>> insert(/*const*/ std.pairIntType<ValueT> /*&*/ KV) {
    assert checkAlive();
    std.pairIntUInt Pair = new std.pairIntUInt(KV.first, 0);
    std.pairTypeBool<DenseMapIteratorIntUInt> Result = Map.insert(Pair);
    int/*uint &*/ I = Result.first.$arrow().second;
    if (Result.second) {
      Vector.push_back(new std.pairIntType<ValueT>(KV.first, KV.second));
      Result.first.$arrow().second = Vector.size() - 1;
      return std.make_pair_T_bool(std.prev(end()), true);
    }
    return std.make_pair_T_bool(begin().$add(I), false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MapVector::count">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 103,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", old_line = 98,
   FQN="llvm::MapVector::count", NM="_ZNK4llvm9MapVector5countERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MapVector5countERKT_")
  //</editor-fold>
  public  int count(/*const*/ int /*&*/ Key) /*const*/ {
    assert checkAlive();
    DenseMapIteratorIntUInt Pos = Map.find(Key);
    return Native.$eq_iter(Pos, Map.end()) ? 0 : 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MapVector::find">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 108,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", old_line = 103,
   FQN="llvm::MapVector::find", NM="_ZN4llvm9MapVector4findERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MapVector4findERKT_")
  //</editor-fold>
  public  std.vector.iterator<std.pairIntType<ValueT>> find(/*const*/ int /*&*/ Key) {
    assert checkAlive();
    DenseMapIteratorIntUInt Pos = Map.find(Key);
    return Native.$eq_iter(Pos, Map.end()) ? Vector.end() : (Vector.begin().$add(Pos.$arrow().second));
  }

  
  ////<editor-fold defaultstate="collapsed" desc="llvm::MapVector::find">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 114,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", old_line = 109,
   FQN="llvm::MapVector::find", NM="_ZNK4llvm9MapVector4findERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MapVector4findERKT_")
  //</editor-fold>
  public final std.vector.iterator<std.pairIntType<ValueT>> find$Const(/*const*/ int /*&*/ Key) /*const*/ {
    assert checkAlive();
    return find(Key);
  }

  
  /// \brief Remove the last element from the vector.
  //<editor-fold defaultstate="collapsed" desc="llvm::MapVector::pop_back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 121,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", old_line = 116,
   FQN="llvm::MapVector::pop_back", NM="_ZN4llvm9MapVector8pop_backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MapVector8pop_backEv")
  //</editor-fold>
  public void pop_back() {
    assert checkAlive();
    DenseMapIteratorIntUInt Pos = Map.find(Vector.back().first);
    Map.erase(Pos);
    Vector.pop_back();
  }

  
  /// \brief Remove the element given by Iterator.
  ///
  /// Returns an iterator to the element following the one which was removed,
  /// which may be end().
  ///
  /// \note This is a deceivingly expensive operation (linear time).  It's
  /// usually better to use \a remove_if() if possible.
  //<editor-fold defaultstate="collapsed" desc="llvm::MapVector::erase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 134,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", old_line = 129,
   FQN="llvm::MapVector::erase", NM="_ZN4llvm9MapVector5eraseENT2_8iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MapVector5eraseENT2_8iteratorE")
  //</editor-fold>
  public  std.vector.iterator<std.pairIntType<ValueT>> erase( std.vector.iterator<std.pairIntType<ValueT>> Iterator) {
    assert checkAlive();
    Map.erase(Iterator.$arrow().first);
    std.vector.iterator<std.pairIntType<ValueT>> Next = Vector.erase(Iterator);
    if (Native.$eq_iter(Next, Vector.end())) {
      return Next;
    }
    
    // Update indices in the map.
    /*size_t*/int Index = Next.$sub(Vector.begin());
    for (std.pairIntUInt /*&*/ I : Map) {
      assert (Native.$noteq(I.second, Index)) : "Index was already erased!";
      if (Native.$greater(I.second, Index)) {
        --I.second;
      }
    }
    return Next;
  }

  
  /// \brief Remove all elements with the key value Key.
  ///
  /// Returns the number of elements removed.
  //<editor-fold defaultstate="collapsed" desc="llvm::MapVector::erase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 153,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", old_line = 148,
   FQN="llvm::MapVector::erase", NM="_ZN4llvm9MapVector5eraseERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MapVector5eraseERKT_")
  //</editor-fold>
  public  int erase(/*const*/ int /*&*/ Key) {
    assert checkAlive();
    std.vector.iterator<std.pairIntType<ValueT>> Iterator = find(Key);
    if (Native.$eq_iter(Iterator, end())) {
      return 0;
    }
    erase(Iterator);
    return 1;
  }

  
  /// \brief Remove the elements that match the predicate.
  ///
  /// Erase all elements that match \c Pred in a single pass.  Takes linear
  /// time.
  /*template <class Predicate> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MapVector::remove_if">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", line = 168,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/MapVector.h", old_line = 164,
   FQN="llvm::MapVector::remove_if", NM="Tpl__ZN4llvm9MapVector9remove_ifET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=Tpl__ZN4llvm9MapVector9remove_ifET_")
  //</editor-fold>
  public void remove_if(BoolPredicate<std.pairIntType<ValueT>> Pred) {
    assert checkAlive();
    std.vector.iterator<std.pairIntType<ValueT>> O = Vector.begin();
    for (std.vector.iterator<std.pairIntType<ValueT>> I = $tryClone(O), E = Vector.end(); Native.$noteq(I, E); I.$preInc()) {
      if (Pred.$call(/*Deref*/I.$star())) {
        // Erase from the map.
        Map.erase(I.$arrow().first);
        continue;
      }
      if (Native.$noteq(I, O)) {
        // Move the value and update the index in the map.
        O.$star().$assign(std.move(/*Deref*/I.$star()));
        Map.ref$at(O.$arrow().first).$set(O.$sub(Vector.begin()));
      }
      O.$preInc();
    }
    // Erase trailing entries in the vector.
    Vector.erase(O, Vector.end());
  }
  
  private ValueT $ValueT() {
    assert checkAlive();
    return (ValueT)$Clone((NativeCloneable)defaultValue);
  }  

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private boolean isDataPointerLike() {
    return false;
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override
  public Iterator<std.pairIntType<ValueT>> iterator() {
    assert checkAlive();
    return Vector.iterator();
  }

  public String toString() {
    return (super.is$destroyed() ? "DESTROYED ":"")
              + "Map=" + Map // NOI18N
              + ", Vector=" + Vector; // NOI18N
  }
    
  protected final boolean checkAlive() {
    return check$Alive();
  }    
}
