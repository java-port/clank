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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.DenseMapInfo;

/*template <typename long, typename ValueInfoT = DenseMapInfoULong> TEMPLATE*/

/// DenseSet - This implements a dense probed hash-table based set.
///
/// FIXME: This is currently implemented directly in terms of DenseMap, this
/// should be optimized later if there is a need.
//<editor-fold defaultstate="collapsed" desc="llvm::DenseSet">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 25,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet")
//</editor-fold>
public class DenseSetULong extends NativeTrace.CreateDestroy$Tracker
implements Iterable<Long>, Destructors.ClassWithDestructor {
  /*typedef DenseMap<long, char, ValueInfoT> MapTy*/
//  public final class MapTy extends DenseMap<long, /*char*/byte, ValueInfoT>{ };
  private final DenseMapULongChar TheMap;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::DenseSet<long, ValueInfoT>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 30,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::DenseSet<long, ValueInfoT>")
  //</editor-fold>
  public DenseSetULong(/*const*/DenseSetULong /*&*/ Other) {
    /* : TheMap(Other.TheMap)*/ 
    assert Other.checkAlive();
    //START JInit
    this.TheMap = new DenseMapULongChar(Other.TheMap);
    //END JInit
  }
  public DenseSetULong(JavaDifferentiators.JD$Move _dparm, DenseSetULong Other) {
    this.TheMap = new DenseMapULongChar(JavaDifferentiators.JD$Move.INSTANCE, Other.TheMap);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::DenseSet<long, ValueInfoT>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 31,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::DenseSet<long, ValueInfoT>")
  //</editor-fold>
  public /*explicit*/ DenseSetULong(DenseMapInfoULong ValueInfo) {
    this(ValueInfo, 0);
  }
  public /*explicit*/ DenseSetULong(DenseMapInfoULong ValueInfo,/*uint*/int NumInitBuckets/*= 0*/) {
    /* : TheMap(NumInitBuckets)*/ 
    assert NumInitBuckets >= 0 : "can not be negative " + NumInitBuckets;
    //START JInit
    this.TheMap = new DenseMapULongChar(ValueInfo, NumInitBuckets, $$TERM);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::empty">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 33,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::empty")
  //</editor-fold>
  public boolean empty() /*const*/ {
    assert checkAlive();
    return TheMap.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::size">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 34,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::size")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    assert checkAlive();
    return TheMap.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::getMemorySize">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 35,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::getMemorySize")
  //</editor-fold>
  public /*size_t*/int getMemorySize() /*const*/ {
    assert checkAlive();
    return TheMap.getMemorySize();
  }

  
  /// Grow the DenseSet so that it has at least Size buckets. Will not shrink
  /// the Size of the set.
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::resize">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 39,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::resize")
  //</editor-fold>
  public void resize(/*size_t*/int Size) {
    assert checkAlive();
    TheMap.resize(Size);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::clear">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 41,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::clear")
  //</editor-fold>
  public void clear() {
    assert checkAlive();
    TheMap.clear();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::count">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 45,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::count")
  //</editor-fold>
  public int count(/*const*/long /*&*/ V) /*const*/ {
    assert checkAlive();
    return TheMap.count(V);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::erase">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 49,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::erase")
  //</editor-fold>
  public boolean erase(/*const*/long /*&*/ V) {
    assert checkAlive();
    return TheMap.erase(V);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::swap">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 53,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::swap")
  //</editor-fold>
  public void swap(DenseSetULong /*&*/ RHS) {
    assert checkAlive();
    TheMap.swap(RHS.TheMap);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 57,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::operator=")
  //</editor-fold>
  public DenseSetULong /*&*/ $assign(/*const*/DenseSetULong /*&*/ RHS) {
    assert checkAlive();
    assert RHS.checkAlive();
    TheMap.$assign(RHS.TheMap);
    return /*Deref*/this;
  }

  @Override
  public void $destroy() {
    assert checkAlive();
    TheMap.$destroy();
    super.set$destroyed();
  }

  public void insert$T(ulong$ptr begin, ulong$ptr end) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  // Iterators.
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::Iterator">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 64,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::Iterator")
  //</editor-fold>
  public static class iterator implements ulong$iterator<iterator> {
    private  DenseMapIteratorULongChar I;
    /*friend  class DenseSet<long, ValueInfoT>*/;
  /*public:*/
    /*typedef typename MapTy::iterator::difference_type difference_type*/
    //public final class difference_type extends  MapTy.iterator.difference_type{ };
    /*typedef long value_type*/
    //public final class value_type extends long{ };
    /*typedef value_type *pointer*/
    //public final class pointer extends value_type /*P*/ { };
    /*typedef value_type &reference*/
    //public final class reference extends value_type /*&*/ { };
    /*typedef std::forward_iterator_tag iterator_category*/
//    public final class iterator_category extends std.forward_iterator_tag{ };
    //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::Iterator::Iterator">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 74,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::Iterator::Iterator")
    //</editor-fold>
    public iterator(/*const*/ DenseMapIteratorULongChar /*&*/ i) {
      /* : I(i)*/ 
      //START JInit
      this.I = $tryClone(i);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::Iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 76,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::Iterator::operator*")
    //</editor-fold>
    public long /*&*/ $star() {
      return I.$star().first;
    }

    @Override
    public ulong$ref star$ref() {
      return new ulong$ref() {
        
        private DenseMapIteratorULongChar localIter = $tryClone(I);

        @Override
        public long $deref() {
          return localIter.$star().first;
        }

        @Override
        public long $set(long value) {
          return localIter.$star().first = $tryClone(value);
        }

      };
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::Iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 77,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::Iterator::operator->")
    //</editor-fold>
    public long /*P*/ $arrow() {
      return /*AddrOf*/I.$star().first;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::Iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 79,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::Iterator::operator++")
    //</editor-fold>
    public iterator /*&*/ $preInc() {
      I.$preInc();
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::Iterator::operator==">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 80,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::Iterator::operator==")
    //</editor-fold>
    public boolean $eq(/*const*/iterator /*&*/ X) /*const*/ {
      return $eq_iter(I, X.I);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::Iterator::operator!=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 81,
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::Iterator::operator!=")
    //</editor-fold>
    public boolean $noteq(/*const*/iterator /*&*/ X) /*const*/ {
      return $noteq_iter(I, X.I);
    }
    
    @Override
    public boolean $noteq(Object other) {
      if (other instanceof iterator) {
        return $noteq((iterator) other);
      }
      return true;
    }

    @Override
    public boolean $eq(Object other) {
      if (other instanceof iterator) {
        return $eq((iterator) other);
      }
      return false;
    }
        

    @Override
    public iterator clone() {
      return new iterator(I);
    }

    @Override
    public iterator const_clone() {
      // TODO: pass constness
      return new iterator(I);
    }

    @Override public String toString() {
      return "" + I;
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::begin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 107,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::begin")
  //</editor-fold>
  public iterator begin() {
    assert checkAlive();
    return new iterator(TheMap.begin());
  }
  public iterator begin$Const() {
    assert checkAlive();
    return new iterator(TheMap.begin());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::end">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 108,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::end")
  //</editor-fold>
  public iterator end() {
    assert checkAlive();
    return new iterator(TheMap.end());
  }
  public iterator end$Const() {
    assert checkAlive();
    return new iterator(TheMap.end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::find">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 113,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::find")
  //</editor-fold>
  public iterator find(/*const*/long /*&*/ V) {
    assert checkAlive();
    return new iterator(TheMap.find(V));
  }
  
  public </*class*/ LookupKeyT> iterator find_as(/*const*/LookupKeyT /*&*/ V) {
    assert checkAlive();
    return new iterator(TheMap.find_as(V));
  }
  public </*class*/ LookupKeyT> iterator find_as_T$C$R(/*const*/LookupKeyT /*&*/ V) {
    assert checkAlive();
    return find_as(V);
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::erase">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 114,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::erase")
  //</editor-fold>
  public void erase(iterator I) {
    assert checkAlive();
    TheMap.erase(I.I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::insert">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 117,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::insert")
  //</editor-fold>
  public std.pairTypeBool<iterator> insert(/*const*/long /*&*/ V) {
      assert checkAlive();
    std.pairTypeBool<DenseMapIteratorULongChar> mapPair = TheMap.insert(std.make_pair_ulong_char(V, (byte) 0));
    return std.make_pair_T_bool(new iterator(mapPair.first), mapPair.second);
  }

  /*template <typename LookupKeyT>*/
  public </*class*/ LookupKeyT> std.pairTypeBool<iterator> insert_as(/*const*/long /*&*/ V,
                                      /*const*/LookupKeyT /*&*/ LookupKey) {
    assert checkAlive();
    std.pairTypeBool<DenseMapIteratorULongChar> mapPair = TheMap.insert_as(std.make_pair_ulong_char(V, (byte) 0), LookupKey);
    return std.make_pair_T_bool(new iterator(mapPair.first), mapPair.second);
  }

  
  // Range insertion of values.
  /*template <typename InputIt> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseSet::insert">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseSet.h", line = 123,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::DenseSet::insert")
  //</editor-fold>
  public void insert(ulong$iterator<?> I, ulong$iterator<?> E) {
    assert checkAlive();
    I = $tryClone(I);
    for (; $noteq_iter(I, E); I.$preInc())  {
      insert(/*Deref*/I.$star());
    }
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override
  public Iterator<Long> iterator() {
    assert checkAlive();
    return new JavaIteratorULong(begin(), end());
  }
  
  @Override
  public String toString() {
    return "DenseSet " + (is$destroyed()?"DESTROYED":"") + "{DenseMap=" + TheMap + "}";
  }
  
  protected final boolean checkAlive() {
    return check$Alive();
  }  
}
