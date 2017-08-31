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

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.*;


/// EquivalenceClasses - This represents a collection of equivalence classes and
/// supports three efficient operations: insert an element into a class of its
/// own, union two classes, and find the class for a given element.  In
/// addition to these modification methods, it is possible to iterate over all
/// of the equivalence classes and all of the elements in a class.
///
/// This implementation is an efficient implementation that only stores one copy
/// of the element being indexed per entry in the set, and allows any arbitrary
/// type to be indexed (as long as it can be ordered with operator<).
///
/// Here is a simple example using integers:
///
/// \code
///  EquivalenceClasses<int> EC;
///  EC.unionSets(1, 2);                // insert 1, 2 into the same set
///  EC.insert(4); EC.insert(5);        // insert 4, 5 into own sets
///  EC.unionSets(5, 1);                // merge the set for 1 with 5's set.
///
///  for (EquivalenceClasses<int>::iterator I = EC.begin(), E = EC.end();
///       I != E; ++I) {           // Iterate over all of the equivalence sets.
///    if (!I->isLeader()) continue;   // Ignore non-leader sets.
///    for (EquivalenceClasses<int>::member_iterator MI = EC.member_begin(I);
///         MI != EC.member_end(); ++MI)   // Loop over members in this set.
///      cerr << *MI << " ";  // Print member.
///    cerr << "\n";   // Finish set.
///  }
/// \endcode
///
/// This example prints:
///   4
///   5 1 2
///
/*template <class ElemTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 57,
 FQN="llvm::EquivalenceClasses", NM="_ZN4llvm18EquivalenceClassesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm18EquivalenceClassesE")
//</editor-fold>
public class EquivalenceClasses</*class*/ ElemTy>  {
  /// ECValue - The EquivalenceClasses data structure is just a set of these.
  /// Each of these represents a relation for a value.  First it stores the
  /// value itself, which provides the ordering that the set queries.  Next, it
  /// provides a "next pointer", which is used to enumerate all of the elements
  /// in the unioned set.  Finally, it defines either a "end of list pointer" or
  /// "leader pointer" depending on whether the value itself is a leader.  A
  /// "leader pointer" points to the node that is the leader for this element,
  /// if the node is not a leader.  A "end of list pointer" points to the last
  /// node in the list of members of this list.  Whether or not a node is a
  /// leader is determined by a bit stolen from one of the pointers.
  //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::ECValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 69,
   FQN="llvm::EquivalenceClasses::ECValue", NM="_ZN4llvm18EquivalenceClasses7ECValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm18EquivalenceClasses7ECValueE")
  //</editor-fold>
  private static class ECValue</*class*/ ElemTy> {
    /*friend  class EquivalenceClasses<ElemTy>*/
    private /*mutable *//*const*/ ECValue /*P*/ Leader;
    private /*mutable *//*const*/ ECValue /*P*/ Next;
    private ElemTy Data;
    // ECValue ctor - Start out with EndOfList pointing to this node, Next is
    // Null, isLeader = true.
    //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::ECValue::ECValue">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 75,
     FQN="llvm::EquivalenceClasses::ECValue::ECValue", NM="_ZN4llvm18EquivalenceClasses7ECValueC1ERKT_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm18EquivalenceClasses7ECValueC1ERKT_")
    //</editor-fold>
    private ECValue(final /*const*/ ElemTy /*&*/ Elt) {
      // : Leader(this), Next((ECValue * )(intptr_t)1), Data(Elt) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::ECValue::getLeader">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 78,
     FQN="llvm::EquivalenceClasses::ECValue::getLeader", NM="_ZNK4llvm18EquivalenceClasses7ECValue9getLeaderEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses7ECValue9getLeaderEv")
    //</editor-fold>
    private /*const*/ ECValue /*P*/ getLeader() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::ECValue::getEndOfList">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 84,
     FQN="llvm::EquivalenceClasses::ECValue::getEndOfList", NM="_ZNK4llvm18EquivalenceClasses7ECValue12getEndOfListEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses7ECValue12getEndOfListEv")
    //</editor-fold>
    private /*const*/ ECValue /*P*/ getEndOfList() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::ECValue::setNext">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 89,
     FQN="llvm::EquivalenceClasses::ECValue::setNext", NM="_ZNK4llvm18EquivalenceClasses7ECValue7setNextEPKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses7ECValue7setNextEPKS1_")
    //</editor-fold>
    private void setNext(/*const*/ ECValue /*P*/ NewNext) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::ECValue::ECValue">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 94,
     FQN="llvm::EquivalenceClasses::ECValue::ECValue", NM="_ZN4llvm18EquivalenceClasses7ECValueC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm18EquivalenceClasses7ECValueC1ERKS1_")
    //</editor-fold>
    public ECValue(final /*const*/ ECValue /*&*/ RHS) {
      // : Leader(this), Next((ECValue * )(intptr_t)1), Data(RHS.Data) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::ECValue::operator<">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 100,
     FQN="llvm::EquivalenceClasses::ECValue::operator<", NM="_ZNK4llvm18EquivalenceClasses7ECValueltERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses7ECValueltERKS1_")
    //</editor-fold>
    public boolean $less(final /*const*/ ECValue /*&*/ UFN) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::ECValue::isLeader">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 102,
     FQN="llvm::EquivalenceClasses::ECValue::isLeader", NM="_ZNK4llvm18EquivalenceClasses7ECValue8isLeaderEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses7ECValue8isLeaderEv")
    //</editor-fold>
    public boolean isLeader() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::ECValue::getData">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 103,
     FQN="llvm::EquivalenceClasses::ECValue::getData", NM="_ZNK4llvm18EquivalenceClasses7ECValue7getDataEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses7ECValue7getDataEv")
    //</editor-fold>
    public /*const*/ ElemTy /*&*/ getData() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::ECValue::getNext">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 105,
     FQN="llvm::EquivalenceClasses::ECValue::getNext", NM="_ZNK4llvm18EquivalenceClasses7ECValue7getNextEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses7ECValue7getNextEv")
    //</editor-fold>
    public /*const*/ ECValue /*P*/ getNext() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /*template <typename T> TEMPLATE*/
    //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::ECValue::operator<">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 110,
     FQN="llvm::EquivalenceClasses::ECValue::operator<", NM="Tpl__ZNK4llvm18EquivalenceClasses7ECValueltERKT_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=Tpl__ZNK4llvm18EquivalenceClasses7ECValueltERKT_")
    //</editor-fold>
    public </*typename*/ T> boolean $less$T(final /*const*/ T /*&*/ Val) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Leader=" + Leader // NOI18N
                + ", Next=" + Next // NOI18N
                + ", Data=" + Data; // NOI18N
    }
  };
  
  /// TheMapping - This implicitly provides a mapping from ElemTy values to the
  /// ECValues, it just keeps the key as part of the value.
  private std.setType<ECValue> TheMapping;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::EquivalenceClasses<ElemTy>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 118,
   FQN="llvm::EquivalenceClasses::EquivalenceClasses<ElemTy>", NM="_ZN4llvm18EquivalenceClassesC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm18EquivalenceClassesC1Ev")
  //</editor-fold>
  public EquivalenceClasses() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::EquivalenceClasses<ElemTy>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 119,
   FQN="llvm::EquivalenceClasses::EquivalenceClasses<ElemTy>", NM="_ZN4llvm18EquivalenceClassesC1ERKNS_18EquivalenceClassesIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm18EquivalenceClassesC1ERKNS_18EquivalenceClassesIT_EE")
  //</editor-fold>
  public EquivalenceClasses(final /*const*/ EquivalenceClasses<ElemTy> /*&*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 123,
   FQN="llvm::EquivalenceClasses::operator=", NM="_ZN4llvm18EquivalenceClassesaSERKNS_18EquivalenceClassesIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm18EquivalenceClassesaSERKNS_18EquivalenceClassesIT_EE")
  //</editor-fold>
  public /*const*/ EquivalenceClasses<ElemTy> /*&*/ $assign(final /*const*/ EquivalenceClasses<ElemTy> /*&*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //===--------------------------------------------------------------------===//
  // Inspection methods
  //
  
  /// iterator* - Provides a way to iterate over all values in the set.
  // JAVA: typedef typename std::set<ECValue>::const_iterator iterator
//  public final class iterator extends  std.set.const_iterator<ECValue>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 141,
   FQN="llvm::EquivalenceClasses::begin", NM="_ZNK4llvm18EquivalenceClasses5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses5beginEv")
  //</editor-fold>
  public  std.setType.iterator<ECValue> begin() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 142,
   FQN="llvm::EquivalenceClasses::end", NM="_ZNK4llvm18EquivalenceClasses3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses3endEv")
  //</editor-fold>
  public  std.setType.iterator<ECValue> end() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::empty">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 144,
   FQN="llvm::EquivalenceClasses::empty", NM="_ZNK4llvm18EquivalenceClasses5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// member_* Iterate over the members of an equivalence class.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::member_iterator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 240,
   FQN="llvm::EquivalenceClasses::member_iterator", NM="_ZN4llvm18EquivalenceClasses15member_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm18EquivalenceClasses15member_iteratorE")
  //</editor-fold>
  public static class member_iterator</*class*/ ElemTy> implements /*public*/ std.iterator<std.forward_iterator_tag, /*const*/ ElemTy/*, int*/>, Native.NativeComparable<member_iterator> {
    // JAVA: typedef std::iterator<std::forward_iterator_tag, const ElemTy, ptrdiff_t> super
//    public final class super extends std.iterator<std.forward_iterator_tag, /*const*/ ElemTy, int>{ };
    private /*const*/ ECValue /*P*/ Node;
    /*friend  class EquivalenceClasses<ElemTy>*/
  /*public:*/
    // JAVA: typedef size_t size_type;
    // JAVA: typedef typename super::pointer pointer
//    public final class pointer extends  std.iterator.pointer<std.forward_iterator_tag, /*const*/ ElemTy, int>{ };
    // JAVA: typedef typename super::reference reference
//    public final class reference extends  std.iterator.reference<std.forward_iterator_tag, /*const*/ ElemTy, int>{ };
    
    //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::member_iterator::member_iterator">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 251,
     FQN="llvm::EquivalenceClasses::member_iterator::member_iterator", NM="_ZN4llvm18EquivalenceClasses15member_iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm18EquivalenceClasses15member_iteratorC1Ev")
    //</editor-fold>
    public /*explicit*/ member_iterator() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::member_iterator::member_iterator">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 252,
     FQN="llvm::EquivalenceClasses::member_iterator::member_iterator", NM="_ZN4llvm18EquivalenceClasses15member_iteratorC1EPKNS0_7ECValueE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm18EquivalenceClasses15member_iteratorC1EPKNS0_7ECValueE")
    //</editor-fold>
    public /*explicit*/ member_iterator(/*const*/ ECValue /*P*/ N) {
      // : Node(N) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::member_iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 254,
     FQN="llvm::EquivalenceClasses::member_iterator::operator*", NM="_ZNK4llvm18EquivalenceClasses15member_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses15member_iteratordeEv")
    //</editor-fold>
    public  std.iterator<std.forward_iterator_tag, /*const*/ ElemTy/*, int*/> $star() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::member_iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 258,
     FQN="llvm::EquivalenceClasses::member_iterator::operator->", NM="_ZNK4llvm18EquivalenceClasses15member_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses15member_iteratorptEv")
    //</editor-fold>
    public  std.iterator<std.forward_iterator_tag, /*const*/ ElemTy/*, int*/> $arrow() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::member_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 260,
     FQN="llvm::EquivalenceClasses::member_iterator::operator++", NM="_ZN4llvm18EquivalenceClasses15member_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm18EquivalenceClasses15member_iteratorppEv")
    //</editor-fold>
    public member_iterator /*&*/ $preInc() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::member_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 266,
     FQN="llvm::EquivalenceClasses::member_iterator::operator++", NM="_ZN4llvm18EquivalenceClasses15member_iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm18EquivalenceClasses15member_iteratorppEi")
    //</editor-fold>
    public member_iterator $postInc(int $Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::member_iterator::operator==">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 272,
     FQN="llvm::EquivalenceClasses::member_iterator::operator==", NM="_ZNK4llvm18EquivalenceClasses15member_iteratoreqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses15member_iteratoreqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ member_iterator /*&*/ RHS) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::member_iterator::operator!=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 275,
     FQN="llvm::EquivalenceClasses::member_iterator::operator!=", NM="_ZNK4llvm18EquivalenceClasses15member_iteratorneERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses15member_iteratorneERKS1_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ member_iterator /*&*/ RHS) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Node=" + Node // NOI18N
                + super.toString(); // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::member_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 149,
   FQN="llvm::EquivalenceClasses::member_begin", NM="_ZNK4llvm18EquivalenceClasses12member_beginENSt3setINS0_7ECValueESt4lessIS2_ESaIS2_EE14const_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses12member_beginENSt3setINS0_7ECValueESt4lessIS2_ESaIS2_EE14const_iteratorE")
  //</editor-fold>
  public member_iterator member_begin( std.setType.iterator<ECValue> I) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::member_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 153,
   FQN="llvm::EquivalenceClasses::member_end", NM="_ZNK4llvm18EquivalenceClasses10member_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses10member_endEv")
  //</editor-fold>
  public member_iterator member_end() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// findValue - Return an iterator to the specified value.  If it does not
  /// exist, end() is returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::findValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 159,
   FQN="llvm::EquivalenceClasses::findValue", NM="_ZNK4llvm18EquivalenceClasses9findValueERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses9findValueERKT_")
  //</editor-fold>
  public  std.setType.iterator<ECValue> findValue(final /*const*/ ElemTy /*&*/ V) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getLeaderValue - Return the leader for the specified value that is in the
  /// set.  It is an error to call this method for a value that is not yet in
  /// the set.  For that, call getOrInsertLeaderValue(V).
  //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::getLeaderValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 166,
   FQN="llvm::EquivalenceClasses::getLeaderValue", NM="_ZNK4llvm18EquivalenceClasses14getLeaderValueERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses14getLeaderValueERKT_")
  //</editor-fold>
  public /*const*/ ElemTy /*&*/ getLeaderValue(final /*const*/ ElemTy /*&*/ V) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getOrInsertLeaderValue - Return the leader for the specified value that is
  /// in the set.  If the member is not in the set, it is inserted, then
  /// returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::getOrInsertLeaderValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 175,
   FQN="llvm::EquivalenceClasses::getOrInsertLeaderValue", NM="_ZN4llvm18EquivalenceClasses22getOrInsertLeaderValueERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm18EquivalenceClasses22getOrInsertLeaderValueERKT_")
  //</editor-fold>
  public /*const*/ ElemTy /*&*/ getOrInsertLeaderValue(final /*const*/ ElemTy /*&*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getNumClasses - Return the number of equivalence classes in this set.
  /// Note that this is a linear time operation.
  //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::getNumClasses">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 183,
   FQN="llvm::EquivalenceClasses::getNumClasses", NM="_ZNK4llvm18EquivalenceClasses13getNumClassesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses13getNumClassesEv")
  //</editor-fold>
  public /*uint*/int getNumClasses() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //===--------------------------------------------------------------------===//
  // Mutation methods
  
  /// insert - Insert a new value into the union/find set, ignoring the request
  /// if the value already exists.
  //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::insert">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 196,
   FQN="llvm::EquivalenceClasses::insert", NM="_ZN4llvm18EquivalenceClasses6insertERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm18EquivalenceClasses6insertERKT_")
  //</editor-fold>
  public  std.setType.iterator<ECValue> insert(final /*const*/ ElemTy /*&*/ Data) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// findLeader - Given a value in the set, return a member iterator for the
  /// equivalence class it is in.  This does the path-compression part that
  /// makes union-find "union findy".  This returns an end iterator if the value
  /// is not in the equivalence class.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::findLeader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 205,
   FQN="llvm::EquivalenceClasses::findLeader", NM="_ZNK4llvm18EquivalenceClasses10findLeaderENSt3setINS0_7ECValueESt4lessIS2_ESaIS2_EE14const_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses10findLeaderENSt3setINS0_7ECValueESt4lessIS2_ESaIS2_EE14const_iteratorE")
  //</editor-fold>
  public member_iterator findLeader( std.setType.iterator<ECValue> I) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::findLeader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 209,
   FQN="llvm::EquivalenceClasses::findLeader", NM="_ZNK4llvm18EquivalenceClasses10findLeaderERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm18EquivalenceClasses10findLeaderERKT_")
  //</editor-fold>
  public member_iterator findLeader(final /*const*/ ElemTy /*&*/ V) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// union - Merge the two equivalence sets for the specified values, inserting
  /// them if they do not already exist in the equivalence set.
  //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::unionSets">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 216,
   FQN="llvm::EquivalenceClasses::unionSets", NM="_ZN4llvm18EquivalenceClasses9unionSetsERKT_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm18EquivalenceClasses9unionSetsERKT_S3_")
  //</editor-fold>
  public member_iterator unionSets(final /*const*/ ElemTy /*&*/ V1, final /*const*/ ElemTy /*&*/ V2) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::EquivalenceClasses::unionSets">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/EquivalenceClasses.h", line = 220,
   FQN="llvm::EquivalenceClasses::unionSets", NM="_ZN4llvm18EquivalenceClasses9unionSetsENS0_15member_iteratorES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm18EquivalenceClasses9unionSetsENS0_15member_iteratorES1_")
  //</editor-fold>
  public member_iterator unionSets(member_iterator L1, member_iterator L2) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  ;
  
  @Override public String toString() {
    return "" + "TheMapping=" + TheMapping; // NOI18N
  }
}
