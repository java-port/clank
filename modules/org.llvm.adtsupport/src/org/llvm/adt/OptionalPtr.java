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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clank.support.aliases.*;

// JAVA: specializaton for pointer (vs. Optional which is for values)
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::Optional">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 28,
 FQN = "llvm::Optional", NM = "_ZN4llvm8OptionalE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalE")
//</editor-fold>
public class OptionalPtr</*typename*/ T>  implements Destructors.ClassWithDestructor, Native.Native$Bool, NativeSwappable, NativeCloneable<OptionalPtr<T>>, NativeMoveable<OptionalPtr<T>> {
  private T storage;
  private boolean hasVal;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::Optional<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 35,
   FQN = "llvm::Optional::Optional<T>", NM = "_ZN4llvm8OptionalC1ENS_8NoneTypeE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalC1ENS_8NoneTypeE")
  //</editor-fold>
  public OptionalPtr(NoneType $Prm0) {
    /* : hasVal(false)*/ 
    //START JInit
    this.hasVal = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::Optional<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 36,
   FQN = "llvm::Optional::Optional<T>", NM = "_ZN4llvm8OptionalC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalC1Ev")
  //</editor-fold>
  public /*explicit*/ OptionalPtr() {
    /* : hasVal(false)*/ 
    //START JInit
    this.hasVal = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::Optional<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 37,
   FQN = "llvm::Optional::Optional<T>", NM = "_ZN4llvm8OptionalC1ERKT_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalC1ERKT_")
  //</editor-fold>
  public OptionalPtr(JD$T$RR _dparam, /*const*/T /*&*/ y) {
    /* : hasVal(true)*/ 
    //START JInit
    this.hasVal = true;
    //END JInit
    assert !(y instanceof NativePointerLike) : "must use Optional for " + NativeTrace.getIdentityStr(y);
    this.storage = (y);
//    /*FIXME:*/new /*(storage.buffer)*/ T(( y ));
  }
  public OptionalPtr(JD$T$C$R _dparam, /*const*/T /*&*/ y) {
    /* : hasVal(true)*/ 
    //START JInit
    this.hasVal = true;
    //END JInit
    assert !(y instanceof NativePointerLike) : "must use Optional for " + NativeTrace.getIdentityStr(y);
    this.storage = (y);
//    /*FIXME:*/new /*(storage.buffer)*/ T(( y ));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::Optional<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 40,
   FQN = "llvm::Optional::Optional<T>", NM = "_ZN4llvm8OptionalC1ERKNS_8OptionalIT_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalC1ERKNS_8OptionalIT_EE")
  //</editor-fold>
  public OptionalPtr(/*const*/OptionalPtr<T> /*&*/ O) {
    /* : hasVal(O.hasVal)*/ 
    //START JInit
    this.hasVal = O.hasVal;
    //END JInit
    if (hasVal) {
      this.storage = (O.storage);
//      /*FIXME:*/new /*(storage.buffer)*/ T(( /*Deref*/O ));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 81,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 128,
   FQN = "llvm::Optional::create", NM = "_ZN4llvm8Optional6createEPKT_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8Optional6createEPKT_")
  //</editor-fold>
  public static <T> /*inline*/ OptionalPtr<T> create(/*const*/T /*P*/ y) {
    assert !(y instanceof NativePointerLike) : "must use Optional for " + NativeTrace.getIdentityStr(y);
    return y != null ? new OptionalPtr<T>(JD$T$C$R.INSTANCE, (y)) : new OptionalPtr<T>();
  }

  
  // FIXME: these assignments (& the equivalent const T&/const Optional& ctors)
  // could be made more efficient by passing by value, possibly unifying them
  // with the rvalue versions above - but this could place a different set of
  // requirements (notably: the existence of a default ctor) when implemented
  // in that way. Careful SFINAE to avoid such pitfalls would be required.
  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 90,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 137,
   FQN = "llvm::Optional::operator=", NM = "_ZN4llvm8OptionalaSERKT_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalaSERKT_")
  //</editor-fold>
  public OptionalPtr<T> /*&*/ $assign(/*const*/T /*&*/ y) {
    assert !(y instanceof NativePointerLike) : "must use Optional for " + NativeTrace.getIdentityStr(y);
    this.storage = (y);
    hasVal = true;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 100,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 147,
   FQN = "llvm::Optional::operator=", NM = "_ZN4llvm8OptionalaSERKNS_8OptionalIT_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalaSERKNS_8OptionalIT_EE")
  //</editor-fold>
  public OptionalPtr<T> /*&*/ $assign(/*const*/OptionalPtr<T> /*&*/ O) {
    if (!O.$bool()) {
      reset();
    } else {
      this.storage = (O.storage);
      this.hasVal = O.hasVal;
    }
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 63,
   FQN="llvm::Optional::operator=", NM="_ZN4llvm8OptionalaSEONS_8OptionalIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalaSEONS_8OptionalIT_EE")
  //</editor-fold>
  public OptionalPtr<T> /*&*/ $assignMove(OptionalPtr<T> /*&&*/O) {
    if (!O.$bool()) {
      reset();
    } else {
      this.storage = O.storage;
      this.hasVal = O.hasVal;
      O.hasVal = false;
      O.storage = null;
    }
    return /*Deref*/this;
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::reset">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 108,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 155,
   FQN = "llvm::Optional::reset", NM = "_ZN4llvm8Optional5resetEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8Optional5resetEv")
  //</editor-fold>
  public void reset() {
    if (hasVal) {
//      Native.destroy(storage);
      storage = null;
      hasVal = false;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::~Optional<T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 115,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 162,
   FQN = "llvm::Optional::~Optional<T>", NM = "_ZN4llvm8OptionalD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm8OptionalD0Ev")
  //</editor-fold>
  public void $destroy() {
    reset();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::getPointer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 119,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 166,
   FQN = "llvm::Optional::getPointer", NM = "_ZNK4llvm8Optional10getPointerEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm8Optional10getPointerEv")
  //</editor-fold>
  public /*const*/T /*P*/ getPointer() /*const*/ {
    assert(hasVal);
    return storage;
//  return reinterpret_cast(/*const*/T /*P*/ .class, storage.buffer);    
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public /*const*/type$ref<T> /*P*/ getPointer$Ref() /*const*/ {
    assert(hasVal);
    return new type$ref<T>() {
      @Override
      public T $deref() {
        assert(hasVal);
        return storage;
      }

      @Override
      public T $set(T value) {
        assert(hasVal);
        OptionalPtr.this.storage = value;
        return OptionalPtr.this.storage;
      }
    };
//  return reinterpret_cast(/*const*/T /*P*/ .class, storage.buffer);    
  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::getPointer">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 114,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Path.cpp -filter=llvm::Optional::getPointer")
//  //</editor-fold>
//  public T /*P*/ getPointer() {
//    assert(hasVal);
//    return reinterpret_cast(T /*P*/ .class, storage.buffer);
//  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::getValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 121,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 168,
   FQN = "llvm::Optional::getValue", NM = "_ZNKR4llvm8Optional8getValueEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNKR4llvm8Optional8getValueEv")
  //</editor-fold>
  public /*const*/T /*&*/ getValue() /*const*/ {
    assert(hasVal);
    return /*Deref*/getPointer();
  }
   public T getValue$Const() {
    assert(hasVal);
    return /*Deref*/getPointer();
  }

  /*template <typename U> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::getValueOr">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 132,
   FQN="llvm::Optional::getValueOr", NM="_ZNKR4llvm8Optional10getValueOrEOT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNKR4llvm8Optional10getValueOrEOT_")
  //</editor-fold>
  public /*<typename U>*/ T getValueOr(T /*&&*/value) /*const*/ {
    return hasValue() ? getValue() : /*std.forward<U>(value)*/ value;
  }
  
//  /*template <typename U> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::getValueOr">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 141,
//   FQN="llvm::Optional::getValueOr", NM="_ZNO4llvm8Optional10getValueOrEOT_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNO4llvm8Optional10getValueOrEOT_")
//  //</editor-fold>
//  public </*typename*/ U> T getValueOr(U /*&&*/value) {
//    return hasValue() ? std.move(getValue()) : std.forward<U>(value);
//  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::getValue">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 116,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Path.cpp -filter=llvm::Optional::getValue")
//  //</editor-fold>
//  public T /*&*/ getValue() {
//    assert(hasVal);
//    return /*Deref*/getPointer();
//  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::operator boolean">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 171,
   FQN = "llvm::Optional::operator bool", NM = "_ZNK4llvm8OptionalcvbEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -filter=llvm::Optional::operator boolean")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return hasVal;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::hasValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 125,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 172,
   FQN = "llvm::Optional::hasValue", NM = "_ZNK4llvm8Optional8hasValueEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm8Optional8hasValueEv")
  //</editor-fold>
  public boolean hasValue() /*const*/ {
    return hasVal;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::operator->">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 126,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 173,
   FQN = "llvm::Optional::operator->", NM = "_ZNK4llvm8OptionalptEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm8OptionalptEv")
  //</editor-fold>
  public /*const*/T /*P*/ $arrow() /*const*/ {
    return getPointer();
  }
  public T $arrow$Const() {
    return getPointer();
  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::operator->">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 121,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Path.cpp -filter=llvm::Optional::operator->")
//  //</editor-fold>
//  public T /*P*/ $arrow() {
//    return getPointer();
//  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::operator*">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 128,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 175,
   FQN = "llvm::Optional::operator*", NM = "_ZNKR4llvm8OptionaldeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNKR4llvm8OptionaldeEv")
  //</editor-fold>
  public /*const*/T /*&*/ $star() /*const*/ {
    assert(hasVal);
    return /*Deref*/getPointer();
  }
  public T $star$Const() {
    assert(hasVal);
    return /*Deref*/getPointer();
  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::Optional::operator*">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 123,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/Path.cpp -filter=llvm::Optional::operator*")
//  //</editor-fold>
//  public T /*&*/ $star() {
//    ((hasVal) ? (/*static_cast*/void)(0) : __assert_fail("hasVal", ${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", 123, __PRETTY_FUNCTION__));
//    return /*Deref*/getPointer();
//  }

  public void $assign_T$C$R(T other) {
    assert !(other instanceof NativePointerLike) : "must use Optional for " + NativeTrace.getIdentityStr(other);
    this.storage = (other);
    this.hasVal = true;
  }

  public void $assign_T$RR(T other) {
    assert !(other instanceof NativePointerLike) : "must use Optional for " + NativeTrace.getIdentityStr(other);
    this.storage = (other);
    this.hasVal = true;
  }
  
  public @Override void swap(NativeSwappable RHS) {
    OptionalPtr</*typename*/ T> other = (OptionalPtr</*typename*/ T>) RHS;
    final T myStorage = this.storage;
    this.storage = other.storage;
    other.storage = myStorage;
    final boolean myHasVal = this.hasVal;    
    this.hasVal = other.hasVal;
    other.hasVal = myHasVal;
  }
  
  @Override public OptionalPtr<T> clone() { return new OptionalPtr(this); }

  @Override public OptionalPtr<T> move() { return new OptionalPtr().$assignMove(this); }
  
  @Override
  public String toString() {
    if (!hasVal) {
      return "NO_VALUE";
    } else {
      return "storage=[" + storage + "]";
    }
  }    
}
