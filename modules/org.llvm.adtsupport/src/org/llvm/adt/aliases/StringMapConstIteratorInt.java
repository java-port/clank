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

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.clank.support.JavaDifferentiators.*;

/*template <typename ValueTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::StringMapConstIteratorInt">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 413,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapConstIteratorInt")
//</editor-fold>
public abstract class StringMapConstIteratorInt implements type$iterator<StringMapIteratorInt, StringMapEntryInt>, Native.NativeComparable, Native.assignable<StringMapIteratorInt> {
/*protected:*/
  protected StringMapEntryBase[] /*P*/ /*P*/ Ptr;
  protected int /*P*/ /*P*/ PtrIdx;
/*public:*/
  /*typedef StringMapEntryInt value_type*/
//  public final class value_type extends StringMapEntryInt{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapConstIteratorInt::StringMapConstIteratorInt<ValueT>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 420,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapConstIteratorInt::StringMapConstIteratorInt<ValueT>")
  //</editor-fold>
  protected StringMapConstIteratorInt() {
    /* : Ptr(0)*/ 
    //START JInit
    this.Ptr = null;
    //END JInit
  }
  protected StringMapConstIteratorInt(JD$Move _dparam, StringMapConstIteratorInt other) {
    /* : Ptr(0)*/ 
    //START JInit
    this.Ptr = other.Ptr;
    this.PtrIdx = other.PtrIdx;
    //END JInit
  }
  protected StringMapConstIteratorInt(StringMapConstIteratorInt other) {
    /* : Ptr(0)*/ 
    //START JInit
    this.Ptr = other.Ptr;
    this.PtrIdx = other.PtrIdx;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapConstIteratorInt::StringMapConstIteratorInt<ValueT>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 422,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapConstIteratorInt::StringMapConstIteratorInt<ValueT>")
  //</editor-fold>
  protected /*explicit*/ StringMapConstIteratorInt(StringMapEntryBase[] /*P*/ /*P*/ Bucket, int BucketIdx, boolean NoAdvance/*= false*/) {
    /* : Ptr(Bucket)*/ 
    //START JInit
    this.Ptr = Bucket;
    this.PtrIdx = BucketIdx;
    //END JInit
    if (!NoAdvance) {
      AdvancePastEmptyBuckets();
    }
  }

  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapConstIteratorInt::operator*">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 428,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapConstIteratorInt::operator*")
  //</editor-fold>
  public /*const*/StringMapEntryInt /*&*/ $star() /*const*/ {
    return /*Deref*/(/*static_cast*/StringMapEntryInt /*P*/ )(/*Deref*/Ptr[PtrIdx]);
  }

  @Override
  public type$ref<StringMapEntryInt> star$ref() {
    return new type$ref<StringMapEntryInt>() {
      
      private int localPtrIdx = PtrIdx;
      
      @Override
      public StringMapEntryInt $deref() {
        return (/*static_cast*/StringMapEntryInt /*P*/ )(/*Deref*/Ptr[localPtrIdx]);
      }

      @Override
      public StringMapEntryInt $set(StringMapEntryInt value) {
        return (StringMapEntryInt)(Ptr[localPtrIdx]=value);
      }      

    };
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapConstIteratorInt::operator->">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 431,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapConstIteratorInt::operator->")
  //</editor-fold>
  public /*const*/StringMapEntryInt /*P*/ $arrow() /*const*/ {
    return (/*static_cast*/StringMapEntryInt /*P*/ )(/*Deref*/Ptr[PtrIdx]);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapConstIteratorInt::operator==">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 435,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapConstIteratorInt::operator==")
  //</editor-fold>
  public boolean $eq(/*const*/StringMapConstIteratorInt /*&*/ RHS) /*const*/ {
    return (PtrIdx == RHS.PtrIdx) && (Ptr == RHS.Ptr);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapConstIteratorInt::operator!=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 438,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapConstIteratorInt::operator!=")
  //</editor-fold>
  public boolean $noteq(/*const*/StringMapConstIteratorInt /*&*/ RHS) /*const*/ {
    return (PtrIdx != RHS.PtrIdx) || (Ptr != RHS.Ptr);
  }

  @Override
  public boolean $eq(Object other) {
    if (other instanceof StringMapConstIteratorInt) {
      return $eq((StringMapConstIteratorInt) other);
    }
    return false;
  }

  @Override
  public boolean $noteq(Object other) {
    if (other instanceof StringMapConstIteratorInt) {
      return $noteq((StringMapConstIteratorInt) other);
    }
    return true;
  }

  // Preincrement
  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapConstIteratorInt::operator++">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 442,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapConstIteratorInt::operator++")
  //</editor-fold>
  public /*inline*/ StringMapIteratorInt /*&*/ $preInc() {
    ++PtrIdx;
    AdvancePastEmptyBuckets();
    return /*Deref*/(StringMapIteratorInt) this;
  }

  // Postincrement
  @Override
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapConstIteratorInt::operator++">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 447,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapConstIteratorInt::operator++")
  //</editor-fold>
  public StringMapIteratorInt $postInc() {
    StringMapIteratorInt tmp = /*Deref*/(StringMapIteratorInt) this.clone();
    ++PtrIdx;
    return tmp;
  }

  public StringMapIteratorInt $assign(StringMapIteratorInt other) {
    this.Ptr = other.Ptr;
    this.PtrIdx = other.PtrIdx;
    return (StringMapIteratorInt) this;    
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapConstIteratorInt::AdvancePastEmptyBuckets">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 452,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapConstIteratorInt::AdvancePastEmptyBuckets")
  //</editor-fold>
  private void AdvancePastEmptyBuckets() {
    while (/*Deref*/Ptr[PtrIdx] == null || /*Deref*/Ptr[PtrIdx] == StringMapImpl.getTombstoneVal()) {
      ++PtrIdx;
    }
  }

  @Override
  public StringMapIteratorInt clone() {
    return new StringMapIteratorInt(Ptr, PtrIdx, true);
  }

  @Override
  public StringMapIteratorInt const_clone() {
    return new StringMapIteratorInt(Ptr, PtrIdx, true);
  }

  @Override public String toString() {
    return this.getClass().getSimpleName() + " {" + StringMapImpl.toStringBucket(Ptr, PtrIdx) + "}";
  }
}
