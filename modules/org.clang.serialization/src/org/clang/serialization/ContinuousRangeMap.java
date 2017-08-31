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

package org.clang.serialization;

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
/*template <typename Int, typename V, unsigned int InitialCapacity> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 35,
 FQN="clang::ContinuousRangeMap", NM="_ZN5clang18ContinuousRangeMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMapE")
//</editor-fold>
public class ContinuousRangeMap</*typename*/ Int, /*typename*/ V/*, uint InitialCapacity*/>  {
/*public:*/
  /*typedef std::pair<Int, V> value_type*/
//  public final class value_type extends std.pair<Int, V>{ };
  /*typedef value_type &reference*/
//  public final class reference extends std.pair<Int, V> /*&*/ { };
  /*typedef const value_type &const_reference*/
//  public final class const_reference extends /*const*/ std.pair<Int, V> /*&*/ { };
  /*typedef value_type *pointer*/
//  public final class pointer extends std.pair<Int, V> /*P*/ { };
  /*typedef const value_type *const_pointer*/
//  public final class const_pointer extends /*const*/ std.pair<Int, V> /*P*/ { };
/*private:*/
  /*typedef SmallVector<value_type, InitialCapacity> Representation*/
//  public final class Representation extends SmallVector<std.pair<Int, V>, InitialCapacity>{ };
  private SmallVector<std.pair<Int, V>/*, InitialCapacity*/> Rep;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::Compare">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 48,
   FQN="clang::ContinuousRangeMap::Compare", NM="_ZN5clang18ContinuousRangeMap7CompareE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap7CompareE")
  //</editor-fold>
  private static class/*struct*/ Compare</*typename*/ Int, /*typename*/ V> {
    //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::Compare::operator()">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 49,
     FQN="clang::ContinuousRangeMap::Compare::operator()", NM="_ZNK5clang18ContinuousRangeMap7CompareclERKSt4pairIT_T0_ES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18ContinuousRangeMap7CompareclERKSt4pairIT_T0_ES3_")
    //</editor-fold>
    public boolean $call(final /*const*/ std.pair<Int, V> /*&*/ L, Int R) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::Compare::operator()">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 52,
     FQN="clang::ContinuousRangeMap::Compare::operator()", NM="_ZNK5clang18ContinuousRangeMap7CompareclET_RKSt4pairIS2_T0_E",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18ContinuousRangeMap7CompareclET_RKSt4pairIS2_T0_E")
    //</editor-fold>
    public boolean $call(Int L, final /*const*/ std.pair<Int, V> /*&*/ R) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::Compare::operator()">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 55,
     FQN="clang::ContinuousRangeMap::Compare::operator()", NM="_ZNK5clang18ContinuousRangeMap7CompareclET_S2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18ContinuousRangeMap7CompareclET_S2_")
    //</editor-fold>
    public boolean $call(Int L, Int R) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::Compare::operator()">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 58,
     FQN="clang::ContinuousRangeMap::Compare::operator()", NM="_ZNK5clang18ContinuousRangeMap7CompareclERKSt4pairIT_T0_ES7_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18ContinuousRangeMap7CompareclERKSt4pairIT_T0_ES7_")
    //</editor-fold>
    public boolean $call(final /*const*/ std.pair<Int, V> /*&*/ L, final /*const*/ std.pair<Int, V> /*&*/ R) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::insert">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 64,
   FQN="clang::ContinuousRangeMap::insert", NM="_ZN5clang18ContinuousRangeMap6insertERKSt4pairIT_T0_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap6insertERKSt4pairIT_T0_E")
  //</editor-fold>
  public void insert(final /*const*/ std.pair<Int, V> /*&*/ Val) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::insertOrReplace">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 73,
   FQN="clang::ContinuousRangeMap::insertOrReplace", NM="_ZN5clang18ContinuousRangeMap15insertOrReplaceERKSt4pairIT_T0_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap15insertOrReplaceERKSt4pairIT_T0_E")
  //</editor-fold>
  public void insertOrReplace(final /*const*/ std.pair<Int, V> /*&*/ Val) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*typedef typename Representation::iterator iterator*/
//  public final class iterator extends  SmallVector<std.pair<Int, V>, InitialCapacity>.iterator{ };
  /*typedef typename Representation::const_iterator const_iterator*/
//  public final class const_iterator extends  SmallVector<std.pair<Int, V>, InitialCapacity>.const_iterator{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 86,
   FQN="clang::ContinuousRangeMap::begin", NM="_ZN5clang18ContinuousRangeMap5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap5beginEv")
  //</editor-fold>
  public  type$ptr<std.pair<Int, V>>  begin() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 87,
   FQN="clang::ContinuousRangeMap::end", NM="_ZN5clang18ContinuousRangeMap3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap3endEv")
  //</editor-fold>
  public  type$ptr<std.pair<Int, V>>  end() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 88,
   FQN="clang::ContinuousRangeMap::begin", NM="_ZNK5clang18ContinuousRangeMap5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18ContinuousRangeMap5beginEv")
  //</editor-fold>
  public  type$ptr<std.pair<Int, V>>  begin$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 89,
   FQN="clang::ContinuousRangeMap::end", NM="_ZNK5clang18ContinuousRangeMap3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18ContinuousRangeMap3endEv")
  //</editor-fold>
  public  type$ptr<std.pair<Int, V>>  end$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::find">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 91,
   FQN="clang::ContinuousRangeMap::find", NM="_ZN5clang18ContinuousRangeMap4findET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap4findET_")
  //</editor-fold>
  public  type$ptr<std.pair<Int, V>>  find(Int K) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::find">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 100,
   FQN="clang::ContinuousRangeMap::find", NM="_ZNK5clang18ContinuousRangeMap4findET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18ContinuousRangeMap4findET_")
  //</editor-fold>
  public  type$ptr<std.pair<Int, V>>  find$Const(Int K) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::back">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 104,
   FQN="clang::ContinuousRangeMap::back", NM="_ZN5clang18ContinuousRangeMap4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap4backEv")
  //</editor-fold>
  public std.pair<Int, V> /*&*/ back() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::back">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 105,
   FQN="clang::ContinuousRangeMap::back", NM="_ZNK5clang18ContinuousRangeMap4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18ContinuousRangeMap4backEv")
  //</editor-fold>
  public /*const*/ std.pair<Int, V> /*&*/ back$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief An object that helps properly build a continuous range map
  /// from a set of values.
  //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::Builder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 109,
   FQN="clang::ContinuousRangeMap::Builder", NM="_ZN5clang18ContinuousRangeMap7BuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap7BuilderE")
  //</editor-fold>
  public static class Builder<Int, V/*, InitialCapacity*/> implements Destructors.ClassWithDestructor {
    private final ContinuousRangeMap<Int, V/*, InitialCapacity*/> /*&*/ Self;
    
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
    public /*explicit*/ Builder(final ContinuousRangeMap<Int, V/*, InitialCapacity*/> /*&*/ Self) {
      // : Self(Self) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::Builder::~Builder">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 118,
     FQN="clang::ContinuousRangeMap::Builder::~Builder", NM="_ZN5clang18ContinuousRangeMap7BuilderD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap7BuilderD0Ev")
    //</editor-fold>
    public void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ContinuousRangeMap::Builder::insert">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ContinuousRangeMap.h", line = 130,
     FQN="clang::ContinuousRangeMap::Builder::insert", NM="_ZN5clang18ContinuousRangeMap7Builder6insertERKSt4pairIT_T0_E",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18ContinuousRangeMap7Builder6insertERKSt4pairIT_T0_E")
    //</editor-fold>
    public void insert(final /*const*/ std.pair<Int, V> /*&*/ Val) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Self=" + Self; // NOI18N
    }
  };
  /*friend  class Builder*/
  
  @Override public String toString() {
    return "" + "Rep=" + Rep; // NOI18N
  }
}
