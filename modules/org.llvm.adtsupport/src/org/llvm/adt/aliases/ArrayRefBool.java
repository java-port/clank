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
import org.clank.java.std;
import org.clank.support.Converted;
import org.clank.support.JavaDifferentiators.JD$Convertible;
import org.clank.support.JavaDifferentiators.JD$Move;
import org.clank.support.Native;
import static org.clank.support.Native.$tryClone;
import static org.clank.support.Native.$tryConstClone;
import org.clank.support.Native.NativeIterable;
import org.clank.support.Native.NativePOD;
import org.clank.support.NativeMoveable;
import org.clank.support.Native.NativeReverseIterable;
import org.clank.support.NativeMemory;
import org.clank.support.NativePointer;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;
import org.llvm.adt.NoneType;
import org.llvm.adt.java.SmallVectorImplCommon;
import static org.llvm.support.llvm.array_lengthof;

/*template <typename boolean> TEMPLATE*/

/// ArrayRefBool - Represent a constant reference to an array (0 or more elements
/// consecutively in memory), i.e. a start pointer and a length.  It allows
/// various APIs to take consecutive elements easily and conveniently.
///
/// This class does not own the underlying data, it is expected to be used in
/// situations where the data resides in some other buffer, whose lifetime
/// extends past that of the ArrayRefBool. For this reason, it is not in general
/// safe to store an ArrayRefBool.
///
/// This is intended to be trivially copyable, so it should be passed by
/// value.
//<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 30,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool")
//</editor-fold>
public class ArrayRefBool implements Iterable<Boolean>, NativePOD<ArrayRefBool>, 
    NativeIterable<bool$ptr>, NativeReverseIterable<std.reverse_iteratorBool>, NativeMoveable<ArrayRefBool> {
  private static final ArrayRefBool NONE;
  static {
    // initialize into temporary to have NONE = null in constructor
    ArrayRefBool obj = new ArrayRefBool(NoneType.None);
    NONE = obj;
  }

  // constant replacement for new ArrayRefBool(NoneType.None)
  public static  ArrayRefBool None() {
    return (ArrayRefBool)NONE;
  }
  
/*public:*/
  @Override
  public ArrayRefBool move() {
    return new ArrayRefBool(JD$Move.INSTANCE, this);
  }
  
  /*typedef const boolean *iterator*/
//  public final class iterator extends /*const*/boolean /*P*/ { };
  /*typedef const boolean *const_iterator*/
//  public final class const_iterator extends /*const*/boolean /*P*/ { };
  /*typedef size_t size_type*/;
  /*typedef std::std.reverse_iteratorBool<iterator> std.reverse_iteratorBool*/
//  public final class std.reverse_iteratorBool extends std.std.reverse_iteratorBool<iterator>{ };
/*private:*/
  /// The start of the array, in an external buffer.
  private /*const*/bool$ptr /*P*/ Data;
  
  /// The number of elements.
  private /*size_t*/int Length;
  
  // ###JAVA###: true if T is pointer in native code but not pointer here
  protected final boolean isDataPointerLike;
/*public:*/

/// ###JAVA###: this class made public because JConvert creates it outside of ArrayRef
  ///
  /// \brief A dummy "optional" type that is only created by implicit
  /// conversion from a reference to T.
  ///
  /// This type must *only* be used in a function argument or as a copy of
  /// a function argument, as otherwise it will hold a pointer to a temporary
  /// past that temporaries' lifetime.
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRef::TRefOrNothing">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 53,
   FQN="llvm::ArrayRef::TRefOrNothing", NM="_ZN4llvm8ArrayRef13TRefOrNothingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm8ArrayRef13TRefOrNothingE")
  //</editor-fold>
  public static class/*struct*/ TRefOrNothing {
    public /*const*/ boolean /*P*/ TPtr;

    //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRef::TRefOrNothing::TRefOrNothing">
    @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 56,
     FQN="llvm::ArrayRef::TRefOrNothing::TRefOrNothing", NM="_ZN4llvm8ArrayRef13TRefOrNothingC1Ev",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm8ArrayRef13TRefOrNothingC1Ev")
    //</editor-fold>
    public TRefOrNothing() {
      /* : TPtr(null)*/ 
      //START JInit
      this.TPtr = ((boolean) false);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRef::TRefOrNothing::TRefOrNothing">
    @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 57,
     FQN="llvm::ArrayRef::TRefOrNothing::TRefOrNothing", NM="_ZN4llvm8ArrayRef13TRefOrNothingC1ERKT_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm8ArrayRef13TRefOrNothingC1ERKT_")
    //</editor-fold>
    public TRefOrNothing(/*const*/ boolean /*&*/ TRef) {
      /* : TPtr(&TRef)*/ 
      //START JInit
      this.TPtr = TRef;
      //END JInit
    }


    public String toString() {
      return "" + "TPtr=" + TPtr; // NOI18N
    }
  }
  
  /// Construct an empty ArrayRefBool.
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::ArrayRefBool">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 51,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::ArrayRefBool")
  //</editor-fold>
  public ArrayRefBool() {
    this(false);
  }
  public ArrayRefBool(boolean isDataPointerLike) {
    /* : Data(0), Length(0)*/ 
    //START JInit
    this.Data = create_const_bool$ptr((boolean[]) null);
    this.Length = 0;
    this.isDataPointerLike = isDataPointerLike;
    //END JInit
  }

  
  /// Construct an empty ArrayRefBool from None.
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::ArrayRefBool">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 54,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::ArrayRefBool")
  //</editor-fold>
  public ArrayRefBool(NoneType $Prm0) {
    this($Prm0, false);
  }
  public ArrayRefBool(NoneType $Prm0, boolean isDataPointerLike) {
    /* : Data(0), Length(0)*/ 
    //START JInit
    this.Data = create_const_bool$ptr((boolean[]) null);
    this.Length = 0;
    this.isDataPointerLike = isDataPointerLike;
    //END JInit
//    if (NONE != null) {
//      NativeTrace.printStackTraceOnce(new Exception("use ArrayRefBool.None() or new ArrayRefBool<>(" + isDataPointerLike + ") instead"));
//    }
  }

  
  /// Construct an ArrayRefBool from a single element.
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::ArrayRefBool">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 57,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::ArrayRefBool")
  //</editor-fold>
//  public ArrayRefBool(/*const*/boolean /*&*/ OneElt) {
//    this(OneElt, false);
//  }
  public ArrayRefBool(boolean /*P*/ OneElt, int len, boolean isDataPointerLike) {
    this(/*AddrOf*/OneElt, isDataPointerLike);
    assert len == 1 : "you meant call to ArrayRefBool(/*const*/bool$ptr /*P*/ data, int len, boolean isDataPointerLike)?";
  }  
  public ArrayRefBool(/*const*/boolean /*&*/ OneElt, boolean isDataPointerLike) {
    /* : Data(&OneElt), Length(1)*/ 
    //START JInit
    this.Data = create_const_bool$ptr((boolean[])new$bool$elem(OneElt));
    this.Length = 1;
    this.isDataPointerLike = isDataPointerLike;
    //END JInit
  }
  
  // Construct an ArrayRefBool using length elements of passed array
  public ArrayRefBool(boolean[] data, /*size_t*/int length) {
    this(data, length, false);
  }
  public ArrayRefBool(boolean[] data, /*size_t*/int length, boolean isDataPointerLike) {
    this(create_const_bool$ptr(data), length, isDataPointerLike);
  }
  
  /// Construct an ArrayRefBool from a pointer and length.
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::ArrayRefBool">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 61,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::ArrayRefBool")
  //</editor-fold>
  public ArrayRefBool(/*const*/bool$ptr /*P*/ data, /*size_t*/int length) {
    this(data, length, false);
  }
  public ArrayRefBool(/*const*/bool$ptr /*P*/ data, /*size_t*/int length, boolean isDataPointerLike) {
    /* : Data(data), Length(length)*/ 
    //START JInit
    this.Data = $tryConstClone(data);
    this.Length = length;
    this.isDataPointerLike = isDataPointerLike;
    //END JInit
  }

  
  /// Construct an ArrayRefBool from a range.
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::ArrayRefBool">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 65,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::ArrayRefBool")
  //</editor-fold>
  public ArrayRefBool(/*const*/bool$ptr /*P*/ begin, /*const*/bool$ptr /*P*/ end) {
    this(begin, end, false);
  }
  public ArrayRefBool(/*const*/bool$ptr /*P*/ begin, /*const*/bool$ptr /*P*/ end, boolean isDataPointerLike) {
    /* : Data(begin), Length(end - begin)*/ 
    //START JInit
    this.Data = $tryConstClone(begin);
    this.Length = std.distance(begin, end);
    this.isDataPointerLike = isDataPointerLike;
    //END JInit
  }

  
  /// Construct an ArrayRefBool from a SmallVector. This is templated in order to
  /// avoid instantiating SmallVectorTemplateCommon whenever we
  /// copy-construct an ArrayRefBool.
  /*template <typename U> TEMPLATE*/
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::ArrayRefBool">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 72,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::ArrayRefBool")
  //</editor-fold>
  public </*typename*/ U> ArrayRefBool(/*const*/SmallVectorImplBool /*&*/ Vec) {
    this(Vec, Vec.isDataPointerLike());
  }
  public </*typename*/ U> ArrayRefBool(/*const*/SmallVectorImplBool /*&*/ Vec, boolean isDataPointerLike) {
    /* : Data(Vec.data()), Length(Vec.size())*/ 
    //START JInit
    this.Data = $tryConstClone(Vec.data());
    this.Length = Vec.size();
    this.isDataPointerLike = isDataPointerLike;
    //END JInit
    assert isDataPointerLike == Vec.isDataPointerLike();
  }

  
  /// Construct an ArrayRefBool from a std::vector.
  /*template <typename A> TEMPLATE*/
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::ArrayRefBool">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 78,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::ArrayRefBool")
  //</editor-fold>
  public </*typename*/ A> ArrayRefBool(/*const*/std.vectorBool /*&*/ Vec) {
    this(Vec, Vec.isDataPointerLike());
  }
  public </*typename*/ A> ArrayRefBool(/*const*/std.vectorBool /*&*/ Vec, boolean isDataPointerLike) {
    /* : Data(Vec.empty() ? (boolean * )0 : &Vec[0]), Length(Vec.size())*/ 
    //START JInit
    this.Data = $tryConstClone(Vec.data());
    this.Length = Vec.size();
    this.isDataPointerLike = isDataPointerLike;
    //END JInit
    assert isDataPointerLike == Vec.isDataPointerLike();
  }
  public ArrayRefBool(/*const*/std.vectorString /*&*/ Vec) {
  this(Vec, Vec.isDataPointerLike());
  }
  public ArrayRefBool(/*const*/std.vectorString /*&*/ Vec, boolean isDataPointerLike) {
    /* : Data(Vec.empty() ? (boolean * )0 : &Vec[0]), Length(Vec.size())*/ 
    //START JInit
    this.Data = $tryConstClone((bool$ptr) (Object) Vec.data()); // hack to make specializations compilable
    this.Length = Vec.size();
    this.isDataPointerLike = isDataPointerLike;
    //END JInit
    assert isDataPointerLike == Vec.isDataPointerLike();
    assert isDataPointerLike == false;
  }

  
  /// Construct an ArrayRefBool from a C array.
  /*template <size_t N> TEMPLATE*/
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::ArrayRefBool">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 83,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::ArrayRefBool")
  //</editor-fold>
  public /*<int*//*size_t*//* N>*/ ArrayRefBool(/*const*/boolean /*&*/ Arr[]) {
    this(Arr, false);
  }
  public /*<int*//*size_t*//* N>*/ ArrayRefBool(/*const*/boolean /*&*/ Arr[], boolean isDataPointerLike) {
    /* : Data(Arr), Length(N)*/ 
    //START JInit
    this.Data = NativePointer.create_const_bool$ptr(Arr);
    this.Length = Arr.length;
    this.isDataPointerLike = isDataPointerLike;
    //END JInit
  }


  // Copy constructor
  public ArrayRefBool(ArrayRefBool other) {
    this.Data = $tryConstClone(other.Data);
    this.Length = other.size();
    this.isDataPointerLike = other.isDataPointerLike;
  }
  public ArrayRefBool(JD$Convertible _param, ArrayRefBool other, boolean isDataPointerLike) {
    this.Data = (bool$ptr)$tryConstClone(other.Data);
    this.Length = other.size();
    assert other.isDataPointerLike == isDataPointerLike;
    this.isDataPointerLike = other.isDataPointerLike;
  }
  public ArrayRefBool(JD$Convertible _param, /*const*/SmallVectorImplBool /*&*/ Vec, boolean isDataPointerLike) {
    this.Data = (bool$ptr)$tryConstClone(Vec.data());
    this.Length = Vec.size();
    this.isDataPointerLike = isDataPointerLike;
    assert isDataPointerLike == Vec.isDataPointerLike();
  }

  // Move constructor
  public ArrayRefBool(JD$Move _dparam, ArrayRefBool other) {
    assert other != NONE : "use new ArrayRefBool<>(true/false) instead?";
    this.Data = other.Data;
    this.Length = other.Length;
    this.isDataPointerLike = other.isDataPointerLike;
    other.Data = null;
    other.Length = 0;
  }

  
  /// @}
  /// @name Simple Operations
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::begin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 97,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::begin")
  //</editor-fold>
  public bool$ptr begin() /*const*/ {
    return Data;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::end">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 98,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::end")
  //</editor-fold>
  public bool$ptr end() /*const*/ {
    return Length == 0 ? Data : Data.$add(Length);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::rbegin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 100,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::rbegin")
  //</editor-fold>
  public std.reverse_iteratorBool rbegin() /*const*/ {
    return new std.reverse_iteratorBool(end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::rend">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 101,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::rend")
  //</editor-fold>
  public std.reverse_iteratorBool rend() /*const*/ {
    return new std.reverse_iteratorBool(begin());
  }

  
  /// empty - Check if the array is empty.
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::empty">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 104,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::empty")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Length == 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::data">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 106,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::data")
  //</editor-fold>
  public /*const*/bool$ptr /*P*/ data() /*const*/ {
    return Data;
  }

  
  /// size - Get the array size.
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::size">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 109,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::size")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    return Length;
  }

  
  /// front - Get the first element.
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::front">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 112,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::front")
  //</editor-fold>
  public /*const*/boolean /*&*/ front() /*const*/ {
    return Data.$at(0);
  }

  
  /// back - Get the last element.
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::back">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 118,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::back")
  //</editor-fold>
  public /*const*/boolean /*&*/ back() /*const*/ {
    return Data.$at(Length - 1);
  }


  // copy - Allocate copy in Allocator and return ArrayRef<T> to it.
  /*template <typename Allocator> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRef::copy">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 146,
   FQN="llvm::ArrayRef::copy", NM="_ZN4llvm8ArrayRef4copyERT_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm8ArrayRef4copyERT_")
  //</editor-fold>
  public ArrayRefBool copy(Class<Boolean> cls, NativeMemory.Allocator /*&*/ A) {
    bool$ptr Buff;
    if (false) {
      Buff = (bool$ptr) A.Allocate(cls, Length);
    } else {
      Buff = NativePointer.create_const_bool$ptr(NativePointer.new$bool(Length));
    }    
    std.copy(begin(), end(), Buff);
    return new ArrayRefBool(Buff, Length, isDataPointerLike);
  }

  
  /// equals - Check for element-wise equality.
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::equals">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 124,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::equals")
  //</editor-fold>
  public boolean equals(ArrayRefBool RHS) /*const*/ {
    if (Native.$noteq(Length, RHS.Length)) {
      return false;
    }
    // Don't use std::equal(), since it asserts in MSVC on nullptr iterators.
    for (bool$ptr L = $tryClone(begin()), LE = end(), R = $tryClone(RHS.begin()); L.$noteq(LE); L.$preInc(), R.$preInc()) {
      // Match std::equal() in using == (instead of !=) to minimize API
      // requirements of ArrayRef'ed types.
      if (!(Native.$eq(L.$star(), R.$star(), isDataPointerLike))) {
        return false;
      }
    }
    return true;
  }

  
  /// slice(n) - Chop off the first N elements of the array.
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::slice">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 134,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::slice")
  //</editor-fold>
  public ArrayRefBool slice(/*uint*/int N) /*const*/ {
    return new ArrayRefBool(data().$add(N), size() - N, isDataPointerLike);
  }

  
  /// slice(n, m) - Chop off the first N elements of the array, and keep M
  /// elements in the array.
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::slice">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 141,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::slice")
  //</editor-fold>
  public ArrayRefBool slice(/*uint*/int N, /*uint*/int M) /*const*/ {
    return new ArrayRefBool(data().$add(N), M, isDataPointerLike);
  }


  // \brief Drop the last \p N elements of the array.
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRef::drop_back">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 179,
   FQN="llvm::ArrayRef::drop_back", NM="_ZNK4llvm8ArrayRef9drop_backEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm8ArrayRef9drop_backEj")
  //</editor-fold>
  public ArrayRefBool drop_back() /*const*/ {
    return drop_back(1);
  }
  public ArrayRefBool drop_back(/*uint*/int N/*= 1*/) /*const*/ {
    assert size() >= N : "Dropping more elements than exist";
    return slice(0, size() - N);
  }

  
  /// @}
  /// @name Operator Overloads
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::operator[]">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 149,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::operator[]")
  //</editor-fold>
  public /*const*/boolean /*&*/ $at(/*size_t*/int Index) /*const*/ {
    return Data.$at(Index);
  }
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::operator[]">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 149,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::operator[]")
  //</editor-fold>
  public /*const*/boolean /*&*/ $at(/*size_t*/uint$ref Index) /*const*/ {
    return Data.$at(Index.$deref());
  }

  public /*const*/bool$ptr ptr$at(/*size_t*/uint$ref Index) /*const*/ {
    return ptr$at(Index.$deref());
  }
  public /*const*/bool$ptr ptr$at(/*size_t*/int Index) /*const*/ {
    return Index == 0 ? Data : Data.$add(Index);
  }

  public /*const*/bool$ref ref$at(/*size_t*/uint$ref Index) /*const*/ {
    return ref$at(Index.$deref());
  }
  public /*const*/bool$ref ref$at(/*size_t*/int Index) /*const*/ {
    return Data.$add(Index).star$ref();
  }
  
  /// @}
  /// @name Expensive Operations
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::vec">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 157,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::vec")
  //</editor-fold>
  public std.vectorBool vec() /*const*/ {
    return new std.vectorBool(Data, end(), ((boolean) false));
  }

  
  /// @}
  /// @name Conversion operators
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRefBool::operator vector<type-parameter-0-0, allocator<type-parameter-0-0> >">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 164,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::ArrayRefBool::operator vector<type-parameter-0-0, allocator<type-parameter-0-0> >")
  //</editor-fold>
  public std.vectorBool $vector/*<type-parameter-0-0, allocator<type-parameter-0-0> >*/() /*const*/ {
    return new std.vectorBool(Data, end(), ((boolean) false));
  }


  /// @brief Predicate for testing that the array equals the exact sequence of
  /// arguments.
  ///
  /// Will return false if the size is not equal to the exact number of
  /// arguments given or if the array elements don't equal the argument
  /// elements in order. Currently supports up to 16 arguments, but can
  /// easily be extended.
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRef::equals">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 217,
   FQN="llvm::ArrayRef::equals", NM="_ZN4llvm8ArrayRef6equalsENS0_13TRefOrNothingES1_S1_S1_S1_S1_S1_S1_S1_S1_S1_S1_S1_S1_S1_S1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm8ArrayRef6equalsENS0_13TRefOrNothingES1_S1_S1_S1_S1_S1_S1_S1_S1_S1_S1_S1_S1_S1_S1_")
  //</editor-fold>
  public boolean equals(TRefOrNothing ... Args) {
    // #JAVA: native code accepted only 16 arguments
    if (Args.length > 16) {
      throw new IllegalArgumentException("Too many arguments passed!");
    }

    if (size() != array_lengthof(Args)) {
      return false;
    }

    for (/*uint*/int i = 0, e = size(); i != e; ++i)  {
      if (Native.$noteq(this.$at(i), Args[(int)i].TPtr, isDataPointerLike)) {
        return false;
      }
    }
    
    return true;
  }


  @Override
  public String toString() {
    if (this.Length == 0) {
      return "<Empty>";
    }
    StringBuilder out = new StringBuilder("\nArRef{");
    String fmt = "%" + (int)Math.ceil(Math.log10(Length+1)) +"d";
    for (int i = 0; i < Length; i++) {
      out.append("[").append(String.format(fmt, i)).append("]");
      out.append("{").append(this.$at(i)).append("}\n");
    }
    out.append("}ArRef\n");
    return out.toString();
  }

  public ArrayRefBool $assign(ArrayRefBool other) {
    this.Data = other.Data;
    this.Length = other.Length;
    return this;
  }

  public ArrayRefBool $assignMove(ArrayRefBool other) {
    assert other != NONE : "use new ArrayRefBool<>(" + this.isDataPointerLike + ") instead?";
    assert this.isDataPointerLike == other.isDataPointerLike;
    bool$ptr DataTmp = this.Data;
    int LengthTmp = this.Length;
    this.Data = other.Data;
    this.Length = other.Length;
    other.Data = null;
    other.Length = 0;
    return this;
  }
  
  @Override
  public ArrayRefBool clone() {
    if (this.getClass() != ArrayRefBool.class) {
      throw new UnsupportedOperationException("Must be overridden in derived " + this.getClass());
    }
    return new ArrayRefBool(this);
  }

  @Override
  public boolean $eq(ArrayRefBool other) {
    return this.equals(other);
  }
  
  @Override
  public Iterator<Boolean> iterator() {
    return Length == 0 ? EMPTY : new ArrayRefIterator(Data, Length);
  }  
  
  private static final ArrayRefIterator EMPTY = new ArrayRefIterator(null, 0);
  
  private static final class ArrayRefIterator implements Iterator<Boolean> {
      
    private final bool$ptr localData;
    
    private final int localLength;
    
    private int pos = 0;

    public ArrayRefIterator(bool$ptr Data, int Length) {
      this.localData = $tryClone(Data);
      this.localLength = Length;
    }

    @Override
    public boolean hasNext() {
      return pos < localLength;
    }

    @Override
    public Boolean next() {
      Boolean val = localData.$star();
      localData.$preInc();
      ++pos;
      return val;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("Not supported.");
    }
  };
}
