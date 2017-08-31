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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;


/// SmallPtrSetImpl - This is the common code shared among all the
/// SmallPtrSet<>'s, which is almost everything.  SmallPtrSet has two modes, one
/// for small and one for large sets.
///
/// Small sets use an array of pointers allocated in the SmallPtrSet object,
/// which is treated as a simple array of pointers.  When a pointer is added to
/// the set, the array is scanned to see if the element already exists, if not
/// the element is 'pushed back' onto the array.  If we run out of space in the
/// array, we grow into the 'large set' case.  SmallSet should be used when the
/// sets are often small.  In this case, no memory allocation is used, and only
/// light-weight and cache-efficient scanning is used.
///
/// Large sets use a classic exponentially-probed hash table.  Empty buckets are
/// represented with an illegal pointer value (-1) to allow null pointers to be
/// inserted.  Tombstones are represented with another illegal pointer value
/// (-2), to allow deletion.  The hash table is resized when the table is 3/4 or
/// more.  When this happens, the table is doubled in size.
///
//<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 49,
 FQN="llvm::SmallPtrSetImplBase", NM="_ZN4llvm19SmallPtrSetImplBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetImplBaseE")
//</editor-fold>
public class SmallPtrSetImplBase<PtrType> implements Destructors.ClassWithDestructor, NativeSwappable {
  /*friend  class SmallPtrSetIteratorImpl*/
  protected final DenseMapInfo<PtrType> KeyInfo;
  private final Object EmptyKey;
  private final Object TombstoneKey;
/*protected:*/
  /// SmallArray - Points to a fixed size set of buckets, used in 'small mode'.
  protected /*const*/type$ptr<PtrType>/*void PP*/ SmallArray;
  /// CurArray - This is the current set of buckets.  If equal to SmallArray,
  /// then the set is in 'small mode'.
  protected /*const*/type$ptr<PtrType>/*void PP*/ CurArray;
  /// CurArraySize - The allocated size of CurArray, always a power of two.
  protected /*uint*/int CurArraySize;
  
  // If small, this is # elts allocated consecutively
  protected /*uint*/int NumElements;
  protected /*uint*/int NumTombstones;
  
  // Helpers to copy and move construct a SmallPtrSet.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::SmallPtrSetImplBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", line = 169,
   old_source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", old_line = 168,
   FQN="llvm::SmallPtrSetImplBase::SmallPtrSetImplBase", NM="_ZN4llvm19SmallPtrSetImplBaseC1EPPKvRKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetImplBaseC1EPPKvRKS0_")
  //</editor-fold>
  protected SmallPtrSetImplBase(/*const*/type$ptr<PtrType>/*void PP*/ SmallStorage, 
      /*const*/ SmallPtrSetImplBase<PtrType> /*&*/ that) {
    SmallArray = $tryClone(SmallStorage);
    
    // If we're becoming small, prepare to insert into our stack space
    if (that.isSmall()) {
      CurArray = $tryClone(SmallArray);
      // Otherwise, allocate new heap space (unless we were the same size)
    } else {
      //CurArray = $tryClone(reinterpret_cast(/*const*/type$ptr<void$ptr>/*void PP*/ .class, malloc(sizeof(void$ptr/*void P*/ ) * that.CurArraySize)));
      CurArray = malloc(that.CurArraySize);
      assert ((CurArray != null)) : "Failed to allocate memory?";
    }
    
    // Copy over the new array size
    CurArraySize = that.CurArraySize;
    
    // Copy over the contents from the other set
    memcpy(CurArray, that.CurArray, CurArraySize, true);
    
    NumElements = that.NumElements;
    NumTombstones = that.NumTombstones;
    KeyInfo = that.KeyInfo;
    EmptyKey = that.EmptyKey;
    TombstoneKey = that.TombstoneKey;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::SmallPtrSetImplBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", line = 192,
   old_source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", old_line = 191,
   FQN="llvm::SmallPtrSetImplBase::SmallPtrSetImplBase", NM="_ZN4llvm19SmallPtrSetImplBaseC1EPPKvjOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetImplBaseC1EPPKvjOS0_")
  //</editor-fold>
  protected SmallPtrSetImplBase(/*const*/type$ptr<PtrType>/*void PP*/ SmallStorage, 
      /*uint*/int SmallSize, 
      SmallPtrSetImplBase<PtrType> /*&&*/that) {
    SmallArray = $tryClone(SmallStorage);
    
    // Copy over the basic members.
    CurArraySize = that.CurArraySize;
    NumElements = that.NumElements;
    NumTombstones = that.NumTombstones;
    KeyInfo = that.KeyInfo;
    EmptyKey = that.EmptyKey;
    TombstoneKey = that.TombstoneKey;
    
    // When small, just copy into our small buffer.
    if (that.isSmall()) {
      CurArray = $tryClone(SmallArray);
      memcpy(CurArray, that.CurArray, CurArraySize, true);
    } else {
      // Otherwise, we steal the large memory allocation and no copy is needed.
      CurArray = $tryClone(that.CurArray);
      that.CurArray = $tryClone(that.SmallArray);
    }
    
    // Make the "that" object small and empty.
    that.CurArraySize = SmallSize;
    assert ($eq_ptr(that.CurArray, that.SmallArray));
    that.NumElements = 0;
    that.NumTombstones = 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::SmallPtrSetImplBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 69,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 68,
   FQN="llvm::SmallPtrSetImplBase::SmallPtrSetImplBase", NM="_ZN4llvm19SmallPtrSetImplBaseC1EPPKvj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetImplBaseC1EPPKvj")
  //</editor-fold>
  protected /*explicit*/ SmallPtrSetImplBase(DenseMapInfo<PtrType> KeyInfo, /*const*/type$ptr<PtrType>/*void PP*/ SmallStorage, /*uint*/int SmallSize) {
    /* : SmallArray(SmallStorage), CurArray(SmallStorage), CurArraySize(SmallSize)*/ 
    //START JInit
    this.SmallArray = $tryClone(SmallStorage);
    this.CurArray = $tryClone(SmallStorage);
    this.CurArraySize = SmallSize;
    this.KeyInfo = KeyInfo;
    //END JInit
    assert ((SmallSize != 0) && (SmallSize & (SmallSize - 1)) == 0) : "Initial size must be a power of two!";
    EmptyKey = KeyInfo.getEmptyKey();
    assert EmptyKey == KeyInfo.getEmptyKey() : "empty key must be persistent between calls" + KeyInfo;
    TombstoneKey = KeyInfo.getTombstoneKey();
    assert TombstoneKey == KeyInfo.getTombstoneKey() : "tombstone key must be persistent between calls" + KeyInfo;
    assert (EmptyKey != TombstoneKey): "EmptyKey must be different from TombstoneKey:" + this.KeyInfo;
    clear();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::~SmallPtrSetImplBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", line = 335,
   old_source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", old_line = 334,
   FQN="llvm::SmallPtrSetImplBase::~SmallPtrSetImplBase", NM="_ZN4llvm19SmallPtrSetImplBaseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetImplBaseD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy() {
    if (!isSmall()) {
      free(CurArray);
    }
  }

/*public:*/
  /*typedef unsigned int size_type*/;
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 79,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 78,
   FQN="llvm::SmallPtrSetImplBase::empty", NM="_ZNK4llvm19SmallPtrSetImplBase5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZNK4llvm19SmallPtrSetImplBase5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*//* __attribute__((warn_unused_result))*/ {
    return size() == 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 80,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 79,
   FQN="llvm::SmallPtrSetImplBase::size", NM="_ZNK4llvm19SmallPtrSetImplBase4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZNK4llvm19SmallPtrSetImplBase4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return NumElements;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 82,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 81,
   FQN="llvm::SmallPtrSetImplBase::clear", NM="_ZN4llvm19SmallPtrSetImplBase5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetImplBase5clearEv")
  //</editor-fold>
  public void clear() {
    // If the capacity of the array is huge, and the # elements used is small,
    // shrink the array.
    if (!isSmall() && $less_uint(NumElements * 4, CurArraySize) && $greater_uint(CurArraySize, 32)) {
      shrink_and_clear();
      return;
    }
    
    // Fill the array with empty markers.
    memset(CurArray, (PtrType)getEmptyMarker(), CurArraySize);
    NumElements = 0;
    NumTombstones = 0;
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::getTombstoneMarker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 95,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 94,
   FQN="llvm::SmallPtrSetImplBase::getTombstoneMarker", NM="_ZN4llvm19SmallPtrSetImplBase18getTombstoneMarkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetImplBase18getTombstoneMarkerEv")
  //</editor-fold>
  protected Object/*void P*/ getTombstoneMarker() {
    return TombstoneKey;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::getEmptyMarker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 96,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 95,
   FQN="llvm::SmallPtrSetImplBase::getEmptyMarker", NM="_ZN4llvm19SmallPtrSetImplBase14getEmptyMarkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetImplBase14getEmptyMarkerEv")
  //</editor-fold>
  protected Object/*void P*/ getEmptyMarker() {
    return EmptyKey;
  }

  
  /// insert_imp - This returns true if the pointer was new to the set, false if
  /// it was already in the set.  This is hidden from the client so that the
  /// derived class can check that the right type of pointer is passed in.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::insert_imp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", line = 37,
   FQN="llvm::SmallPtrSetImplBase::insert_imp", NM="_ZN4llvm19SmallPtrSetImplBase10insert_impEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetImplBase10insert_impEPKv")
  //</editor-fold>
  protected std.pairTypeBool</*const*/type$ptr<PtrType>/*void P const P*/> insert_imp(/*const*/PtrType/*void P*/ Ptr) {
    if (isSmall()) {
      // Check to see if it is already in the set.
      for (int APtr = 0, /*P*/ /*P*/ E = NumElements; APtr != E; ++APtr)  {
        PtrType CurKey = SmallArray.$at(APtr);
        assert CurKey != getEmptyMarker() : "empty markers are only at the end of array";
        assert CurKey != getTombstoneMarker() : "no tombstones markers in small array";
        if (this.KeyInfo.isEqual(Ptr, CurKey)) {
          return std.make_pair_T_bool(SmallArray.$add(APtr), false);
        }
      }
      
      // Nope, there isn't.  If we stay small, just 'pushback' now.
      if ($less_uint(NumElements, CurArraySize)) {
        SmallArray.$set(NumElements++, Ptr);
        return std.make_pair_T_bool(SmallArray.$add((NumElements - 1)), true);
      }
      // Otherwise, hit the big set case, which will call grow.
    }
    if ($greatereq_uint(NumElements * 4, CurArraySize * 3)) {
      // If more than 3/4 of the array is full, grow.
      Grow($less_uint(CurArraySize, 64) ? 128 : CurArraySize * 2);
    } else if ($less_uint(CurArraySize - (NumElements + NumTombstones), CurArraySize / 8)) {
      // If fewer of 1/8 of the array is empty (meaning that many are filled with
      // tombstones), rehash.
      Grow(CurArraySize);
    }
    
    // Okay, we know we have space.  Find a hash bucket.
    /*const*/type$ptr<PtrType>/*void PP*/ Bucket = FindBucketFor(Ptr);
    PtrType CurKey = Bucket.$star();
    if ((CurKey != getTombstoneMarker()) && (CurKey != getEmptyMarker())) {
      // Already inserted, good.
      assert KeyInfo.isEqual(Ptr, CurKey) : "" + Ptr + " vs. " + CurKey;
      return std.make_pair_T_bool(Bucket, false); 
    }
    
    // Otherwise, insert it!
    if (CurKey == getTombstoneMarker()) {
      --NumTombstones;
    }
    Bucket.$set($cloneIfNeeded(Ptr));
    ++NumElements; // Track density.
    return std.make_pair_T_bool(Bucket, true);
  }

  
  /// erase_imp - If the set contains the specified pointer, remove it and
  /// return true, otherwise return false.  This is hidden from the client so
  /// that the derived class can check that the right type of pointer is passed
  /// in.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::erase_imp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", line = 77,
   old_source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", old_line = 76,
   FQN="llvm::SmallPtrSetImplBase::erase_imp", NM="_ZN4llvm19SmallPtrSetImplBase9erase_impEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetImplBase9erase_impEPKv")
  //</editor-fold>
  protected boolean erase_imp(/*const*/PtrType/*void P*/ Ptr) {
    if (isSmall()) {
      // Check to see if it is in the set.
      for (int APtr = 0, /*P*/ /*P*/ E = NumElements; APtr != E; ++APtr)  {
        PtrType CurKey = SmallArray.$at(APtr);
        assert CurKey != getEmptyMarker() : "empty markers are only at the end of array";
        assert CurKey != getTombstoneMarker() : "no tombstones markers in small array";
        if (KeyInfo.isEqual(Ptr, CurKey)) {
          // If it is in the set, move last element to the vacant position
          SmallArray.$set(APtr, SmallArray.$at(E-1));
          SmallArray.$set(E-1, (PtrType)getEmptyMarker());
          --NumElements;
          return true;
        }
      }
      
      return false;
    }
    
    // Okay, we know we have space.  Find a hash bucket.
    type$ptr<PtrType>/*void PP*/ Bucket = FindBucketFor(Ptr);
    PtrType CurKey = Bucket.$star();
    if ((CurKey == getTombstoneMarker()) || (CurKey == getEmptyMarker())) {
      return false; // Not in the set?
    }
    assert KeyInfo.isEqual(Ptr, CurKey) : "Not in the set? " + CurKey + " vs " + Ptr;
    
    // Set this as a tombstone.
    Bucket.$set((PtrType)getTombstoneMarker());
    --NumElements;
    ++NumTombstones;
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::count_imp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 113,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 112,
   FQN="llvm::SmallPtrSetImplBase::count_imp", NM="_ZNK4llvm19SmallPtrSetImplBase9count_impEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZNK4llvm19SmallPtrSetImplBase9count_impEPKv")
  //</editor-fold>
  protected boolean count_imp(/*const*/PtrType/*void P*/ Ptr) /*const*/ {
    if (isSmall()) {
      // Linear search for the item.
      for (int APtr = 0, /*P*/ /*P*/ E = NumElements; APtr != E; ++APtr)  {
        PtrType CurKey = SmallArray.$at(APtr);
        assert CurKey != getEmptyMarker() : "empty markers are only at the end of array";
        assert CurKey != getTombstoneMarker() : "no tombstones markers in small array";
        if (KeyInfo.isEqual(Ptr, CurKey)) {
          return true;
        }        
      }
      return false;
    }
    
    // Big set case.
    type$ptr<PtrType>/*void PP*/ Bucket = FindBucketFor(Ptr);
    PtrType CurKey = Bucket.$star();
    if ((CurKey == getTombstoneMarker()) || (CurKey == getEmptyMarker())) {
      return false; // Not in the set
    }
    assert KeyInfo.isEqual(Ptr, CurKey) : "Not in the set? " + CurKey + " vs " + Ptr;
    return true;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::isSmall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 128,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 127,
   FQN="llvm::SmallPtrSetImplBase::isSmall", NM="_ZNK4llvm19SmallPtrSetImplBase7isSmallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZNK4llvm19SmallPtrSetImplBase7isSmallEv")
  //</editor-fold>
  private boolean isSmall() /*const*/ {
    return $eq_ptr(CurArray, SmallArray);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::FindBucketFor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", line = 104,
   old_source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", old_line = 103,
   FQN="llvm::SmallPtrSetImplBase::FindBucketFor", NM="_ZNK4llvm19SmallPtrSetImplBase13FindBucketForEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZNK4llvm19SmallPtrSetImplBase13FindBucketForEPKv")
  //</editor-fold>
  private /*const*/type$ptr<PtrType>/*void P const P*/ FindBucketFor(/*const*/PtrType/*void P*/ Ptr) /*const*/ {
    /*uint*/int Bucket = KeyInfo.getHashValue(Ptr) & (CurArraySize - 1);
    /*uint*/int ArraySize = CurArraySize;
    /*uint*/int ProbeAmt = 1;
    /*const*/type$ptr<PtrType>/*void P const P*/ Array = CurArray;
    /*const*/type$ptr/*void P const P*/ Tombstone = null;
    while (true) {
      // If we found an empty bucket, the pointer doesn't exist in the set.
      // Return a tombstone if we've seen one so far, or the empty bucket if
      // not.
      PtrType CurKey = Array.$at(Bucket);
      if (CurKey == getEmptyMarker()) {
        return (Tombstone != null) ? Tombstone : Array.$add(Bucket);
      }
      
      // If this is a tombstone, remember it.  If Ptr ends up not in the set, we
      // prefer to return it than something that would require more probing.
      if (CurKey == getTombstoneMarker()) {
        if (Tombstone == null) {
          Tombstone = Array.$add(Bucket); // Remember the first tombstone found.
        }
      } else {
        // Found Ptr's bucket?
        if (this.KeyInfo.isEqual(Ptr, CurKey)) {
          return Array.$add(Bucket);
        }
      }
      
      // It's a hash collision or a tombstone. Reprobe.
      Bucket = (Bucket + ProbeAmt++) & (ArraySize - 1);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::shrink_and_clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", line = 23,
   FQN="llvm::SmallPtrSetImplBase::shrink_and_clear", NM="_ZN4llvm19SmallPtrSetImplBase16shrink_and_clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetImplBase16shrink_and_clearEv")
  //</editor-fold>
  private void shrink_and_clear() {
    assert (!isSmall()) : "Can't shrink a small set!";
    free(CurArray);
    
    // Reduce the number of buckets.
    CurArraySize = $greater_uint(NumElements, 16) ? 1 << (Log2_32_Ceil(NumElements) + 1) : 32;
    NumElements = NumTombstones = 0;
    
    // Install the new array.  Clear all the buckets to empty.
    CurArray = malloc(CurArraySize);
    assert ((CurArray != null)) : "Failed to allocate memory?";
    memset(CurArray, (PtrType)getEmptyMarker(), CurArraySize);
  }

  
  /// Grow - Allocate a larger backing store for the buckets and move it over.
  
  /// Grow - Allocate a larger backing store for the buckets and move it over.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::Grow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", line = 133,
   old_source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", old_line = 132,
   FQN="llvm::SmallPtrSetImplBase::Grow", NM="_ZN4llvm19SmallPtrSetImplBase4GrowEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetImplBase4GrowEj")
  //</editor-fold>
  private void Grow(/*uint*/int NewSize) {
    // Allocate at twice as many buckets, but at least 128.
    /*uint*/int OldSize = CurArraySize;
    
    /*const*/type$ptr<PtrType>/*void PP*/ OldBuckets = $tryClone(CurArray);
    boolean WasSmall = isSmall();
    
    // Install the new array.  Clear all the buckets to empty.
    CurArray = malloc(NewSize);
    assert ((CurArray != null)) : "Failed to allocate memory?";
    CurArraySize = NewSize;
    memset(CurArray, (PtrType)getEmptyMarker(), NewSize);
    
    // Copy over all the elements.
    if (WasSmall) {
      // Small sets store their elements in order.
      for (int APtr = 0, /*P*/ /*P*/ E = NumElements; APtr != E; ++APtr)  {
        PtrType Elt = SmallArray.$at(APtr);
        assert Elt != getEmptyMarker() : "empty markers are only at the end of array";
        assert Elt != getTombstoneMarker() : "no tombstones markers in small array";        
        final type$ptr<PtrType> BucketFor = FindBucketFor(Elt);
        assert BucketFor.$star() == getEmptyMarker() || BucketFor.$star() == getTombstoneMarker() : "must find free bucket for " + Elt + " vs. " + BucketFor;
        BucketFor.$set(Elt);
      }
    } else {
      // Copy over all valid entries.
      for (/*const*/type$ptr<PtrType>/*void PP*/ BucketPtr = $tryClone(OldBuckets), /*P*/ /*P*/ E = OldBuckets.$add(OldSize);
           $noteq_ptr(BucketPtr, E); BucketPtr.$preInc()) {
        // Copy over the element if it is valid.
        /*const*/PtrType/*void P*/ Elt = BucketPtr.$star();
        if ((Elt != getTombstoneMarker()) && (Elt != getEmptyMarker())) {
          final type$ptr<PtrType> BucketFor = FindBucketFor(Elt);
          assert BucketFor.$star() == getEmptyMarker() || BucketFor.$star() == getTombstoneMarker() : "must find free bucket for " + Elt + " vs. " + BucketFor;
          BucketFor.$set(Elt);          
        }
      }
      
      free(OldBuckets);
      NumTombstones = 0;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 136,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 135,
   FQN="llvm::SmallPtrSetImplBase::operator=", NM="_ZN4llvm19SmallPtrSetImplBaseaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetImplBaseaSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ SmallPtrSetImplBase<PtrType> /*&*/ RHS) { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  /// swap - Swaps the elements of two sets.
  /// Note: This method assumes that both sets have the same small size.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::swap">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", line = 285,
   old_source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", old_line = 284,
   FQN="llvm::SmallPtrSetImplBase::swap", NM="_ZN4llvm19SmallPtrSetImplBase4swapERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetImplBase4swapERS0_")
  //</editor-fold>
  @Override public void swap(NativeSwappable _RHS) {
  //protected void swap(SmallPtrSetImplBase<PtrType> /*&*/ RHS) {
    SmallPtrSetImplBase<PtrType> RHS = (SmallPtrSetImplBase<PtrType>) _RHS;
    if (this == $AddrOf(RHS)) {
      return;
    }
    
    // We can only avoid copying elements if neither set is small.
    if (!this.isSmall() && !RHS.isSmall()) {
      // std.swap(this.CurArray, RHS.CurArray);
      type$ptr<PtrType> tmpPtr = this.CurArray;
      this.CurArray = RHS.CurArray;
      RHS.CurArray = tmpPtr;
      // std.swap(this.CurArraySize, RHS.CurArraySize);
      int tmp = this.CurArraySize;
      this.CurArraySize = RHS.CurArraySize;
      RHS.CurArraySize = tmp;            
      // std.swap(this.NumElements, RHS.NumElements);
      tmp = this.NumElements;
      this.NumElements = RHS.NumElements;
      RHS.NumElements = tmp;            
      // std.swap(this.NumTombstones, RHS.NumTombstones);
      tmp = this.NumTombstones;
      this.NumTombstones = RHS.NumTombstones;
      RHS.NumTombstones = tmp;    
      return;
    }
    
    // FIXME: From here on we assume that both sets have the same small size.
    
    // If only RHS is small, copy the small elements into LHS and move the pointer
    // from LHS to RHS.
    if (!this.isSmall() && RHS.isSmall()) {
      std.copy(RHS.SmallArray, RHS.SmallArray.$add(RHS.CurArraySize), this.SmallArray);
      
      // std.swap(this.NumElements, RHS.NumElements);
      int tmp = this.NumElements;
      this.NumElements = RHS.NumElements;
      RHS.NumElements = tmp;                  
      // std.swap(this.CurArraySize, RHS.CurArraySize);
      tmp = this.CurArraySize;
      this.CurArraySize = RHS.CurArraySize;
      RHS.CurArraySize = tmp; 
      
      RHS.CurArray = $tryClone(this.CurArray);
      RHS.NumTombstones = this.NumTombstones;
      this.CurArray = $tryClone(this.SmallArray);
      this.NumTombstones = 0;
      return;
    }
    
    // If only LHS is small, copy the small elements into RHS and move the pointer
    // from RHS to LHS.
    if (this.isSmall() && !RHS.isSmall()) {
      std.copy(this.SmallArray, this.SmallArray.$add(this.CurArraySize), RHS.SmallArray);
      
      // std.swap(RHS.NumElements, this.NumElements);
      int tmp = this.NumElements;
      this.NumElements = RHS.NumElements;
      RHS.NumElements = tmp;         
      // std.swap(RHS.CurArraySize, this.CurArraySize);
      tmp = this.CurArraySize;
      this.CurArraySize = RHS.CurArraySize;
      RHS.CurArraySize = tmp;       
      
      this.CurArray = $tryClone(RHS.CurArray);
      this.NumTombstones = RHS.NumTombstones;
      RHS.CurArray = $tryClone(RHS.SmallArray);
      RHS.NumTombstones = 0;
      return;
    }
    
    // Both a small, just swap the small elements.
    assert (this.isSmall() && RHS.isSmall());
    assert (this.CurArraySize == RHS.CurArraySize);
    std.swap_ranges(this.SmallArray, this.SmallArray.$add(this.CurArraySize), 
        RHS.SmallArray);
    
    // std.swap(this.NumElements, RHS.NumElements);
    int tmp = this.NumElements;
    this.NumElements = RHS.NumElements;
    RHS.NumElements = tmp;  
  }

  
  
  /// CopyFrom - implement operator= from a smallptrset that has the same pointer
  /// type, but may have a different small size.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::CopyFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", line = 221,
   old_source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", old_line = 220,
   FQN="llvm::SmallPtrSetImplBase::CopyFrom", NM="_ZN4llvm19SmallPtrSetImplBase8CopyFromERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetImplBase8CopyFromERKS0_")
  //</editor-fold>
  protected void CopyFrom(/*const*/ SmallPtrSetImplBase<PtrType> /*&*/ RHS) {
    assert ($AddrOf(RHS) != this) : "Self-copy should be handled by the caller.";
    if (isSmall() && RHS.isSmall()) {
      assert (CurArraySize == RHS.CurArraySize) : "Cannot assign sets with different small sizes";
    }
    
    // If we're becoming small, prepare to insert into our stack space
    if (RHS.isSmall()) {
      if (!isSmall()) {
        free(CurArray);
      }
      CurArray = $tryClone(SmallArray);
      // Otherwise, allocate new heap space (unless we were the same size)
    } else if (CurArraySize != RHS.CurArraySize) {
      if (isSmall()) {
        CurArray = malloc(RHS.CurArraySize);
      } else {
        /*const*/type$ptr<PtrType>/*void PP*/ Arr = realloc(CurArray, CurArraySize, RHS.CurArraySize);
        if (!(Arr != null)) {
          free(CurArray);
        }
        CurArray = $tryClone(Arr);
      }
      assert ((CurArray != null)) : "Failed to allocate memory?";
    }
    
    // Copy over the new array size
    CurArraySize = RHS.CurArraySize;
    
    // Copy over the contents from the other set
    memcpy(CurArray, RHS.CurArray, CurArraySize, true);
    
    NumElements = RHS.NumElements;
    NumTombstones = RHS.NumTombstones;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImplBase::MoveFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", line = 257,
   old_source = "${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp", old_line = 256,
   FQN="llvm::SmallPtrSetImplBase::MoveFrom", NM="_ZN4llvm19SmallPtrSetImplBase8MoveFromEjOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetImplBase8MoveFromEjOS0_")
  //</editor-fold>
  protected void MoveFrom(/*uint*/int SmallSize, 
          SmallPtrSetImplBase<PtrType> /*&&*/RHS) {
    assert ($AddrOf(RHS) != this) : "Self-move should be handled by the caller.";
    if (!isSmall()) {
      free(CurArray);
    }
    if (RHS.isSmall()) {
      // Copy a small RHS rather than moving.
      CurArray = $tryClone(SmallArray);
      memcpy(CurArray, RHS.CurArray, RHS.CurArraySize, true);
    } else {
      CurArray = $tryClone(RHS.CurArray);
      RHS.CurArray = $tryClone(RHS.SmallArray);
    }
    
    // Copy the rest of the trivial members.
    CurArraySize = RHS.CurArraySize;
    NumElements = RHS.NumElements;
    NumTombstones = RHS.NumTombstones;
    
    // Make the RHS small and empty.
    RHS.CurArraySize = SmallSize;
    assert ($eq_ptr(RHS.CurArray, RHS.SmallArray));
    RHS.NumElements = 0;
    RHS.NumTombstones = 0;
  }

  private PtrType $cloneIfNeeded(PtrType Ptr) {
    // LibC-Java pointers passed from client code need to be cloned,
    // because in Native they are passed by value
    return Ptr instanceof void$ptr ? $tryClone(Ptr) : Ptr;
  }
    
  public String toString() {
    StringBuilder out = new StringBuilder("SmallArray="); // NOI18N
    out.append(isSmall() ? "YES" : "NO"); // NOI18N
    out.append(", NumElements=").append(NumElements); // NOI18N
    out.append(", CurArraySize=").append(CurArraySize); // NOI18N
    out.append(", NumTombstones=").append(NumTombstones); // NOI18N
    int idx = 0;
    for (int i = 0; i < CurArraySize; i++) {
      if (CurArray.$at(i) != getEmptyMarker() && CurArray.$at(i) != getTombstoneMarker()) {
        out.append("\n [").append(NativeTrace.formatNumber(idx++, 2)).append("] ");
        out.append("{").append(CurArray.$at(i)).append("}");
      }
    }
    return out.toString();
  }
}
