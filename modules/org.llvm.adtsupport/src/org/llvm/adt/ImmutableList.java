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

package org.llvm.adt;

import java.util.Iterator;
import org.clank.support.*;
import org.clank.support.Native.NativePOD;
import org.clank.support.aliases.JavaIterator;
import org.clank.support.aliases.type$iterator;


/// ImmutableList - This class represents an immutable (functional) list.
///  It is implemented as a smart pointer (wraps ImmutableListImpl), so it
///  it is intended to always be copied by value as if it were a pointer.
///  This interface matches ImmutableSet and ImmutableMap.  ImmutableList
///  objects should almost never be created directly, and instead should
///  be created by ImmutableListFactory objects that manage the lifetime
///  of a group of lists.  When the factory object is reclaimed, all lists
///  created by that factory are released as well.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 62,
 FQN="llvm::ImmutableList", NM="_ZN4llvm13ImmutableListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm13ImmutableListE")
//</editor-fold>
public class ImmutableList</*typename*/ T>  implements Native.NativeComparable<ImmutableList<T>>, Iterable<T>, NativePOD<ImmutableList<T>> {
/*public:*/
  // JAVA: typedef T value_type
//  public final class value_type extends T{ };
  // JAVA: typedef ImmutableListFactory<T> Factory
//  public final class Factory extends ImmutableListFactory<T>{ };
/*private:*/
  private /*const*/ ImmutableListImpl<T> /*P*/ X;
/*public:*/
  // This constructor should normally only be called by ImmutableListFactory<T>.
  // There may be cases, however, when one needs to extract the internal pointer
  // and reconstruct a list object from that pointer.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList::ImmutableList<T>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 75,
   FQN="llvm::ImmutableList::ImmutableList<T>", NM="_ZN4llvm13ImmutableListC1EPKNS_17ImmutableListImplIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm13ImmutableListC1EPKNS_17ImmutableListImplIT_EE")
  //</editor-fold>
  public ImmutableList() {
    this((ImmutableListImpl<T>)null);
  }
  public ImmutableList(/*const*/ ImmutableListImpl<T> /*P*/ x/*= null*/) {
    // : X(x) 
    //START JInit
    this.X = /*ParenListExpr*/x;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList::getInternalPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 77,
   FQN="llvm::ImmutableList::getInternalPointer", NM="_ZNK4llvm13ImmutableList18getInternalPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm13ImmutableList18getInternalPointerEv")
  //</editor-fold>
  public /*const*/ ImmutableListImpl<T> /*P*/ getInternalPointer() /*const*/ {
    return X;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList::iterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 81,
   FQN="llvm::ImmutableList::iterator", NM="_ZN4llvm13ImmutableList8iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm13ImmutableList8iteratorE")
  //</editor-fold>
  public static class iterator<T> implements Native.NativeComparable, type$iterator<iterator<T>, T> {
    private /*const*/ ImmutableListImpl<T> /*P*/ L;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 84,
     FQN="llvm::ImmutableList::iterator::iterator", NM="_ZN4llvm13ImmutableList8iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm13ImmutableList8iteratorC1Ev")
    //</editor-fold>
    public iterator() {
      // : L(null) 
      //START JInit
      this.L = /*ParenListExpr*/null;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 85,
     FQN="llvm::ImmutableList::iterator::iterator", NM="_ZN4llvm13ImmutableList8iteratorC1ENS_13ImmutableListIT_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm13ImmutableList8iteratorC1ENS_13ImmutableListIT_EE")
    //</editor-fold>
    public iterator(ImmutableList<T> l) {
      // : L(l.getInternalPointer()) 
      //START JInit
      this.L = /*ParenListExpr*/l.getInternalPointer();
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList::iterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 87,
     FQN="llvm::ImmutableList::iterator::operator++", NM="_ZN4llvm13ImmutableList8iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm13ImmutableList8iteratorppEv")
    //</editor-fold>
    public iterator<T> /*&*/ $preInc() {
      L = L.getTail();
      return this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList::iterator::operator==">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 88,
     FQN="llvm::ImmutableList::iterator::operator==", NM="_ZNK4llvm13ImmutableList8iteratoreqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm13ImmutableList8iteratoreqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ iterator<T> /*&*/ I) /*const*/ {
      return L == I.L;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList::iterator::operator!=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 89,
     FQN="llvm::ImmutableList::iterator::operator!=", NM="_ZNK4llvm13ImmutableList8iteratorneERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm13ImmutableList8iteratorneERKS1_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ iterator<T> /*&*/ I) /*const*/ {
      return (L != I.L);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList::iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 90,
     FQN="llvm::ImmutableList::iterator::operator*", NM="_ZNK4llvm13ImmutableList8iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm13ImmutableList8iteratordeEv")
    //</editor-fold>
    public /*const*/ T /*&*/ $star() /*const*/ {
      return L.getHead();
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList::iterator::getList">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 91,
     FQN="llvm::ImmutableList::iterator::getList", NM="_ZNK4llvm13ImmutableList8iterator7getListEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm13ImmutableList8iterator7getListEv")
    //</editor-fold>
    public ImmutableList<T> getList() /*const*/ {
      return new ImmutableList<T>(L);
    }

    private iterator(ImmutableListImpl<T> inner) {
      this.L = inner;
    }

    @Override public iterator<T> clone() {
      return new iterator<T>(this.L);
    }

    @Override public String toString() {
      return "" + "L=" + L; // NOI18N
    }
  };
  
  /// begin - Returns an iterator referring to the head of the list, or
  ///  an iterator denoting the end of the list if the list is empty.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 96,
   FQN="llvm::ImmutableList::begin", NM="_ZNK4llvm13ImmutableList5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm13ImmutableList5beginEv")
  //</editor-fold>
  public iterator<T> begin() /*const*/ {
    return new iterator<T>(X);
  }

  
  /// end - Returns an iterator denoting the end of the list.  This iterator
  ///  does not refer to a valid list element.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 100,
   FQN="llvm::ImmutableList::end", NM="_ZNK4llvm13ImmutableList3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm13ImmutableList3endEv")
  //</editor-fold>
  public iterator<T> end() /*const*/ {
    return new iterator<T>();
  }

  
  /// isEmpty - Returns true if the list is empty.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList::isEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 103,
   FQN="llvm::ImmutableList::isEmpty", NM="_ZNK4llvm13ImmutableList7isEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm13ImmutableList7isEmptyEv")
  //</editor-fold>
  public boolean isEmpty() /*const*/ {
    return X != null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList::contains">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 105,
   FQN="llvm::ImmutableList::contains", NM="_ZNK4llvm13ImmutableList8containsERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm13ImmutableList8containsERKT_")
  //</editor-fold>
  public boolean contains(final /*const*/ T /*&*/ V) /*const*/ {
    for (iterator I = begin(), E = end(); Native.$noteq(I, E); I.$preInc()) {
      if (Native.$eq(Native.$star(I), V)) {
        return true;
      }
    }
    return false;
  }

  
  /// isEqual - Returns true if two lists are equal.  Because all lists created
  ///  from the same ImmutableListFactory are uniqued, this has O(1) complexity
  ///  because it the contents of the list do not need to be compared.  Note
  ///  that you should only compare two lists created from the same
  ///  ImmutableListFactory.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 118,
   FQN="llvm::ImmutableList::isEqual", NM="_ZNK4llvm13ImmutableList7isEqualERKNS_13ImmutableListIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm13ImmutableList7isEqualERKNS_13ImmutableListIT_EE")
  //</editor-fold>
  public boolean isEqual(final /*const*/ ImmutableList<T> /*&*/ L) /*const*/ {
    return (X == L.X);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 120,
   FQN="llvm::ImmutableList::operator==", NM="_ZNK4llvm13ImmutableListeqERKNS_13ImmutableListIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm13ImmutableListeqERKNS_13ImmutableListIT_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/ ImmutableList<T> /*&*/ L) /*const*/ {
    return isEqual(L);
  }

  
  /// getHead - Returns the head of the list.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList::getHead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 123,
   FQN="llvm::ImmutableList::getHead", NM="_ZN4llvm13ImmutableList7getHeadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm13ImmutableList7getHeadEv")
  //</editor-fold>
  public /*const*/ T /*&*/ getHead() {
    assert Native.$bool(Native.$not(isEmpty())) : "Cannot get the head of an empty list.";
    return X.getHead();
  }

  
  /// getTail - Returns the tail of the list, which is another (possibly empty)
  ///  ImmutableList.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList::getTail">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 130,
   FQN="llvm::ImmutableList::getTail", NM="_ZN4llvm13ImmutableList7getTailEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm13ImmutableList7getTailEv")
  //</editor-fold>
  public ImmutableList<T> getTail() {
    return new ImmutableList<T>(X != null ? X.getTail() : null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableList::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 134,
   FQN="llvm::ImmutableList::Profile", NM="_ZNK4llvm13ImmutableList7ProfileERNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm13ImmutableList7ProfileERNS_16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddPointer(X);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public ImmutableList(ImmutableList<T> $Prm0) {
    this.X = $Prm0.X;
  }
  
  public ImmutableList<T> $assign(ImmutableList<T> consVals) {
    assert this != consVals;
    this.X = consVals.X;
    return this;
  }
  
  public ImmutableList<T> $assignMove(ImmutableList<T> consVals) {
    assert this != consVals;
    this.X = consVals.X;
    consVals.X = null;
    return this;
  }

  @Override public ImmutableList<T> clone() {
    return new ImmutableList<T>(this);
  }
  
  @Override
  public Iterator<T> iterator() {
    return new JavaIterator<T>(begin(), end());
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "X=" + X; // NOI18N
  }
}
