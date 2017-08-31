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

package org.clang.serialization.aliases;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.aliases.*;


/// \brief A map from continuous integer ranges to some value, with a very
/// specialized interface.
///
/// CRM maps from integer ranges to values. The ranges are continuous, i.e.
/// where one ends, the next one begins. So if the map contains the stops I0-3,
/// the first range is from I0 to I1, the second from I1 to I2, the third from
/// I2 to I3 and the last from I3 to infinity.
///
/// Ranges must be inserted in order. Inserting a new stop I4 into the map will
/// shrink the fourth range to I3 to I4 and add the new range I4 to inf.
/*template <typename int, typename V, unsigned int InitialCapacity> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 35,
 FQN="clang::ContinuousRangeMap", NM="_ZN5clang18ContinuousRangeMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMapE")
//</editor-fold>
public class ContinuousRangeMapUIntInt implements Destructors.ClassWithDestructor {
  
/*public:*/
  /*typedef std::pair<int, V> value_type*/
//  public final class value_type extends std.pairUIntInt{ };
  /*typedef value_type &reference*/
//  public final class reference extends std.pairUIntInt /*&*/ { };
  /*typedef const value_type &const_reference*/
//  public final class const_reference extends /*const*/ std.pairUIntInt /*&*/ { };
  /*typedef value_type *pointer*/
//  public final class pointer extends std.pairUIntInt /*P*/ { };
  /*typedef const value_type *const_pointer*/
//  public final class const_pointer extends /*const*/ std.pairUIntInt /*P*/ { };
/*private:*/
  /*typedef SmallVector<value_type, InitialCapacity> Representation*/
//  public final class Representation extends SmallVector<std.pairUIntInt, InitialCapacity>{ };
  private SmallVector<std.pairUIntInt> Rep;

  public ContinuousRangeMapUIntInt(int InitialCapacity) {
    this.Rep = new SmallVector<std.pairUIntInt>(InitialCapacity, std.make_pair_uint_int(0, 0));
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::Compare">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 48,
   FQN="clang::ContinuousRangeMap::Compare", NM="_ZN5clang18ContinuousRangeMap7CompareE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap7CompareE")
  //</editor-fold>
  private final class/*struct*/ Compare implements Native.ComparatorLower {
    //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::Compare::operator()">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 49,
     FQN="clang::ContinuousRangeMap::Compare::operator()", NM="_ZNK5clang18ContinuousRangeMap7CompareclERKSt4pairIT_T0_ES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18ContinuousRangeMap7CompareclERKSt4pairIT_T0_ES3_")
    //</editor-fold>
    public boolean $call(final /*const*/ std.pairUIntInt /*&*/ L, final /*uint*/int R) /*const*/ {
      return Unsigned.$less_uint(L.first, R);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::Compare::operator()">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 52,
     FQN="clang::ContinuousRangeMap::Compare::operator()", NM="_ZNK5clang18ContinuousRangeMap7CompareclET_RKSt4pairIS2_T0_E",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18ContinuousRangeMap7CompareclET_RKSt4pairIS2_T0_E")
    //</editor-fold>
    public boolean $call(final /*uint*/int L, final /*const*/ std.pairUIntInt /*&*/ R) /*const*/ {
      return Unsigned.$less_uint(L, R.first);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::Compare::operator()">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 55,
     FQN="clang::ContinuousRangeMap::Compare::operator()", NM="_ZNK5clang18ContinuousRangeMap7CompareclET_S2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18ContinuousRangeMap7CompareclET_S2_")
    //</editor-fold>
    public boolean $call(final /*uint*/int L, final /*uint*/int R) /*const*/ {
      return Unsigned.$less_uint(L, R);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::Compare::operator()">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 58,
     FQN="clang::ContinuousRangeMap::Compare::operator()", NM="_ZNK5clang18ContinuousRangeMap7CompareclERKSt4pairIT_T0_ES7_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18ContinuousRangeMap7CompareclERKSt4pairIT_T0_ES7_")
    //</editor-fold>
    public boolean $call(final /*const*/ std.pairUIntInt /*&*/ L, final /*const*/ std.pairUIntInt /*&*/ R) /*const*/ {
      return Unsigned.$less_uint(L.first, R.first);
    }

    public boolean $less(final /*const*/ Object /*&*/ L, final /*const*/ Object /*&*/ R) /*const*/ {
      assert R instanceof std.pairUIntInt : "Unexpected " + NativeTrace.getIdentityStr(R);
      if (L instanceof Number) {
        return $call(((Number)L).intValue(), (std.pairUIntInt)R);
      }
      assert L instanceof std.pairUIntInt : "Unexpected " + NativeTrace.getIdentityStr(L);
      return $call((std.pairUIntInt)L, (std.pairUIntInt)R);
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  private final Compare COMPARATOR = new Compare();
  
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 64,
   FQN="clang::ContinuousRangeMap::insert", NM="_ZN5clang18ContinuousRangeMapIjPNS_13serialization10ModuleFileELj64EE6insertERKSt4pairIjS3_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang18ContinuousRangeMapIjPNS_13serialization10ModuleFileELj64EE6insertERKSt4pairIjS3_E")
  //</editor-fold>
  public void insert(final /*const*/ std.pairUIntInt /*&*/ Val) {
    if (!Rep.empty() && Native.$eq(Rep.back(), Val)) {
      return;
    }
    assert ((Rep.empty() || Unsigned.$less_uint(Rep.back().first, Val.first))) : "Must insert keys in order.";
    Rep.push_back(Val);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::insertOrReplace">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 73,
   FQN="clang::ContinuousRangeMap::insertOrReplace", NM="_ZN5clang18ContinuousRangeMap15insertOrReplaceERKSt4pairIT_T0_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap15insertOrReplaceERKSt4pairIT_T0_E")
  //</editor-fold>
  public void insertOrReplace(final /*const*/ std.pairUIntInt /*&*/ Val) {
    type$ptr<std.pairUIntInt>/*P*/ I = std.lower_bound(Rep.begin(), Rep.end(), Val, COMPARATOR);
    if (Native.$noteq_ptr(I, Rep.end()) && I./*->*/$star().first == Val.first) {
      I./*->*/$star().second = Val.second;
      return;
    }

    Rep.insert_iterator$T_T$C$R(I, Val);
  }

  
  /*typedef typename Representation::iterator iterator*/
//  public final class iterator extends  SmallVector<std.pairUIntInt, InitialCapacity>.iterator{ };
  /*typedef typename Representation::const_iterator const_iterator*/
//  public final class const_iterator extends  SmallVector<std.pairUIntInt, InitialCapacity>.const_iterator{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 86,
   FQN="clang::ContinuousRangeMap::begin", NM="_ZN5clang18ContinuousRangeMap5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap5beginEv")
  //</editor-fold>
  public type$ptr<std.pairUIntInt>  begin() {
    return Rep.begin();
  }
  public type$ptr<std.pairUIntInt>  begin$Const() {
    return Rep.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 87,
   FQN="clang::ContinuousRangeMap::end", NM="_ZN5clang18ContinuousRangeMap3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap3endEv")
  //</editor-fold>
  public type$ptr<std.pairUIntInt>  end() {
    return Rep.end();
  }
  public type$ptr<std.pairUIntInt>  end$Const() {
    return Rep.end$Const();
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::find">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 91,
   FQN="clang::ContinuousRangeMap::find", NM="_ZN5clang18ContinuousRangeMap4findET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang18ContinuousRangeMap4findET_")
  //</editor-fold>
  public type$ptr<std.pairUIntInt>  find(final /*uint*/int K) {
    type$ptr<std.pairUIntInt> I = std.upper_bound(Rep.begin(), Rep.end(), K, COMPARATOR);
    // I points to the first entry with a key > K, which is the range that
    // follows the one containing K.
    if (Native.$eq_ptr(I, Rep.begin())) {
     return Rep.end();
    }
    I.$preDec();
    return I;
  }

  ////<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::find">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 100,
   FQN="clang::ContinuousRangeMap::find", NM="_ZNK5clang18ContinuousRangeMap4findET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18ContinuousRangeMap4findET_")
  //</editor-fold>
  public type$ptr<std.pairUIntInt> find$Const(final /*uint*/int K) /*const*/ {
    return find(K);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::back">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 104,
   FQN="clang::ContinuousRangeMap::back", NM="_ZN5clang18ContinuousRangeMap4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap4backEv")
  //</editor-fold>
  public std.pairUIntInt /*&*/ back() {
    return Rep.back();
  }

  ////<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::back">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 105,
   FQN="clang::ContinuousRangeMap::back", NM="_ZNK5clang18ContinuousRangeMap4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18ContinuousRangeMap4backEv")
  //</editor-fold>
  public /*const*/ std.pairUIntInt /*&*/ back$Const() /*const*/ {
    return Rep.back$Const();
  }

  
  /// \brief An object that helps properly build a continuous range map
  /// from a set of values.
  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::Builder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 109,
   FQN="clang::ContinuousRangeMap::Builder", NM="_ZN5clang18ContinuousRangeMap7BuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap7BuilderE")
  //</editor-fold>
  public static final class Builder implements Destructors.ClassWithDestructor {
    private final ContinuousRangeMapUIntInt /*&*/ Self;
    
    //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::Builder::Builder">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 112,
     FQN="clang::ContinuousRangeMap::Builder::Builder", NM="_ZN5clang18ContinuousRangeMap7BuilderC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap7BuilderC1ERKS1_")
    //</editor-fold>
    private Builder(final /*const*/ Builder /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

    //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::Builder::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 113,
     FQN="clang::ContinuousRangeMap::Builder::operator=", NM="_ZN5clang18ContinuousRangeMap7BuilderaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap7BuilderaSERKS1_")
    //</editor-fold>
    private Builder /*&*/ $assign(final /*const*/ Builder /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::Builder::Builder">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 116,
     FQN="clang::ContinuousRangeMap::Builder::Builder", NM="_ZN5clang18ContinuousRangeMap7BuilderC1ERNS_18ContinuousRangeMapIT_T0_XT1_EEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap7BuilderC1ERNS_18ContinuousRangeMapIT_T0_XT1_EEE")
    //</editor-fold>
    public /*explicit*/ Builder(int size, final ContinuousRangeMapUIntInt /*&*/ Self) {
      /* : Self(Self)*/ 
      this.Self = Self;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::Builder::~Builder">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 118,
     FQN="clang::ContinuousRangeMap::Builder::~Builder", NM="_ZN5clang18ContinuousRangeMap7BuilderD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap7BuilderD0Ev")
    //</editor-fold>
    public void $destroy() {
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::Builder::insert">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 130,
     FQN="clang::ContinuousRangeMap::Builder::insert", NM="_ZN5clang18ContinuousRangeMap7Builder6insertERKSt4pairIT_T0_E",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap7Builder6insertERKSt4pairIT_T0_E")
    //</editor-fold>
    public void insert(/*const*/ std.pairUIntInt /*&*/ Val) {
      Self.Rep.push_back(Val);
    }

    
    public String toString() {
      return "Builder for " + "Self=" + Self; // NOI18N
    }
  };
  /*friend  class Builder*/
  
  @Override public void $destroy() {
    this.Rep.$destroy();
  }
  
  public String toString() {
    return "" + "Rep=" + Rep; // NOI18N
  }
}
