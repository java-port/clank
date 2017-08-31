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

/*template <typename ${VALUE_TYPE}> TEMPLATE*/

/// ${FILE_NAME} - Represent a constant reference to an array (0 or more elements
/// consecutively in memory), i.e. a start pointer and a length.  It allows
/// various APIs to take consecutive elements easily and conveniently.
///
/// This class does not own the underlying data, it is expected to be used in
/// situations where the data resides in some other buffer, whose lifetime
/// extends past that of the ${FILE_NAME}. For this reason, it is not in general
/// safe to store an ${FILE_NAME}.
///
/// This is intended to be trivially copyable, so it should be passed by
/// value.
//<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 30,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}")
//</editor-fold>
public class ${FILE_NAME}${CLASS_SUFFIX} implements Iterable<${BOXED_VALUE_TYPE}>, NativePOD<${FILE_NAME}${CLASS_SUFFIX}>, 
    NativeIterable<${VALUE_POINTER}>, NativeReverseIterable<${REVERSE_ITERATOR}>, NativeMoveable<${FILE_NAME}${CLASS_SUFFIX}> {
  private static final ${FILE_NAME} NONE;
  static {
    // initialize into temporary to have NONE = null in constructor
    ${FILE_NAME} obj = new ${FILE_NAME}(NoneType.None);
    NONE = obj;
  }

  // constant replacement for new ${FILE_NAME}${CLASS_SUFFIX}(NoneType.None)
  public static ${CLASS_SUFFIX} ${FILE_NAME}${CLASS_SUFFIX} None() {
    return (${FILE_NAME}${CLASS_SUFFIX})NONE;
  }
  
/*public:*/
  @Override
  public ${FILE_NAME}${CLASS_SUFFIX} move() {
    return new ${FILE_NAME}${CLASS_SUFFIX}(JD$Move.INSTANCE, this);
  }
  
  /*typedef const ${VALUE_TYPE} *iterator*/
//  public final class iterator extends /*const*/${VALUE_TYPE} /*P*/ { };
  /*typedef const ${VALUE_TYPE} *const_iterator*/
//  public final class const_iterator extends /*const*/${VALUE_TYPE} /*P*/ { };
  /*typedef size_t size_type*/;
  /*typedef std::${REVERSE_ITERATOR}<iterator> ${REVERSE_ITERATOR}*/
//  public final class ${REVERSE_ITERATOR} extends std.${REVERSE_ITERATOR}<iterator>{ };
/*private:*/
  /// The start of the array, in an external buffer.
  private /*const*/${VALUE_POINTER} /*P*/ Data;
  
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
    public /*const*/ ${TREF_TYPE} /*P*/ TPtr;

    //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRef::TRefOrNothing::TRefOrNothing">
    @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 56,
     FQN="llvm::ArrayRef::TRefOrNothing::TRefOrNothing", NM="_ZN4llvm8ArrayRef13TRefOrNothingC1Ev",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm8ArrayRef13TRefOrNothingC1Ev")
    //</editor-fold>
    public TRefOrNothing() {
      /* : TPtr(null)*/ 
      //START JInit
      this.TPtr = ${TREF_DEFAULT_VALUE};
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRef::TRefOrNothing::TRefOrNothing">
    @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 57,
     FQN="llvm::ArrayRef::TRefOrNothing::TRefOrNothing", NM="_ZN4llvm8ArrayRef13TRefOrNothingC1ERKT_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm8ArrayRef13TRefOrNothingC1ERKT_")
    //</editor-fold>
    public TRefOrNothing(/*const*/ ${TREF_TYPE} /*&*/ TRef) {
      /* : TPtr(&TRef)*/ 
      //START JInit
      this.TPtr = TRef;
      //END JInit
    }


    public String toString() {
      return "" + "TPtr=" + TPtr; // NOI18N
    }
  }
  
  /// Construct an empty ${FILE_NAME}.
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::${FILE_NAME}${CLASS_SUFFIX}">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 51,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::${FILE_NAME}${CLASS_SUFFIX}")
  //</editor-fold>
  public ${FILE_NAME}() {
    this(false);
  }
  public ${FILE_NAME}(boolean isDataPointerLike) {
    /* : Data(0), Length(0)*/ 
    //START JInit
    this.Data = ${POINTER_FACTORY_METHOD}((${VALUE_TYPE}[]) null);
    this.Length = 0;
    this.isDataPointerLike = isDataPointerLike;
    //END JInit
  }

  
  /// Construct an empty ${FILE_NAME} from None.
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::${FILE_NAME}${CLASS_SUFFIX}">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 54,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::${FILE_NAME}${CLASS_SUFFIX}")
  //</editor-fold>
  public ${FILE_NAME}(NoneType $Prm0) {
    this($Prm0, false);
  }
  public ${FILE_NAME}(NoneType $Prm0, boolean isDataPointerLike) {
    /* : Data(0), Length(0)*/ 
    //START JInit
    this.Data = ${POINTER_FACTORY_METHOD}((${VALUE_TYPE}[]) null);
    this.Length = 0;
    this.isDataPointerLike = isDataPointerLike;
    //END JInit
//    if (NONE != null) {
//      NativeTrace.printStackTraceOnce(new Exception("use ${FILE_NAME}.None() or new ${FILE_NAME}<>(" + isDataPointerLike + ") instead"));
//    }
  }

  
  /// Construct an ${FILE_NAME} from a single element.
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::${FILE_NAME}${CLASS_SUFFIX}">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 57,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::${FILE_NAME}${CLASS_SUFFIX}")
  //</editor-fold>
${CTOR_FROM_ONE_ELEMENT_COMMENT1}  public ${FILE_NAME}(/*const*/${VALUE_TYPE} /*&*/ OneElt) {
${CTOR_FROM_ONE_ELEMENT_COMMENT2}    this(OneElt, false);
${CTOR_FROM_ONE_ELEMENT_COMMENT3}  }
  public ${FILE_NAME}(${VALUE_TYPE} /*P*/ OneElt, int len, boolean isDataPointerLike) {
    this(/*AddrOf*/OneElt, isDataPointerLike);
    assert len == 1 : "you meant call to ${FILE_NAME}(/*const*/${VALUE_POINTER} /*P*/ data, int len, boolean isDataPointerLike)?";
  }  
  public ${FILE_NAME}(/*const*/${VALUE_TYPE} /*&*/ OneElt, boolean isDataPointerLike) {
    /* : Data(&OneElt), Length(1)*/ 
    //START JInit
    this.Data = ${POINTER_FACTORY_METHOD}((${VALUE_TYPE}[])${CREATE_ARRAY_FROM_ONE_ELT});
    this.Length = 1;
    this.isDataPointerLike = isDataPointerLike;
    //END JInit
  }
  
  // Construct an ${FILE_NAME} using length elements of passed array
  public ${FILE_NAME}(${VALUE_TYPE}[] data, /*size_t*/int length) {
    this(data, length, false);
  }
  public ${FILE_NAME}(${VALUE_TYPE}[] data, /*size_t*/int length, boolean isDataPointerLike) {
    this(${POINTER_FACTORY_METHOD}(data), length, isDataPointerLike);
  }
  
  /// Construct an ${FILE_NAME} from a pointer and length.
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::${FILE_NAME}${CLASS_SUFFIX}">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 61,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::${FILE_NAME}${CLASS_SUFFIX}")
  //</editor-fold>
  public ${FILE_NAME}(/*const*/${VALUE_POINTER} /*P*/ data, /*size_t*/int length) {
    this(data, length, false);
  }
  public ${FILE_NAME}(/*const*/${VALUE_POINTER} /*P*/ data, /*size_t*/int length, boolean isDataPointerLike) {
    /* : Data(data), Length(length)*/ 
    //START JInit
    this.Data = $tryConstClone(data);
    this.Length = length;
    this.isDataPointerLike = isDataPointerLike;
    //END JInit
  }

  
  /// Construct an ${FILE_NAME} from a range.
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::${FILE_NAME}${CLASS_SUFFIX}">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 65,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::${FILE_NAME}${CLASS_SUFFIX}")
  //</editor-fold>
  public ${FILE_NAME}(/*const*/${VALUE_POINTER} /*P*/ begin, /*const*/${VALUE_POINTER} /*P*/ end) {
    this(begin, end, false);
  }
  public ${FILE_NAME}(/*const*/${VALUE_POINTER} /*P*/ begin, /*const*/${VALUE_POINTER} /*P*/ end, boolean isDataPointerLike) {
    /* : Data(begin), Length(end - begin)*/ 
    //START JInit
    this.Data = $tryConstClone(begin);
    this.Length = std.distance(begin, end);
    this.isDataPointerLike = isDataPointerLike;
    //END JInit
  }

  
  /// Construct an ${FILE_NAME} from a SmallVector. This is templated in order to
  /// avoid instantiating SmallVectorTemplateCommon${CLASS_SUFFIX} whenever we
  /// copy-construct an ${FILE_NAME}.
  /*template <typename U> TEMPLATE*/
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::${FILE_NAME}${CLASS_SUFFIX}">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 72,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::${FILE_NAME}${CLASS_SUFFIX}")
  //</editor-fold>
  public </*typename*/ U> ${FILE_NAME}(/*const*/${SMALL_VECTOR_TYPE} /*&*/ Vec) {
    this(Vec, Vec.isDataPointerLike());
  }
  public </*typename*/ U> ${FILE_NAME}(/*const*/${SMALL_VECTOR_TYPE} /*&*/ Vec, boolean isDataPointerLike) {
    /* : Data(Vec.data()), Length(Vec.size())*/ 
    //START JInit
    this.Data = $tryConstClone(Vec.data());
    this.Length = Vec.size();
    this.isDataPointerLike = isDataPointerLike;
    //END JInit
    assert isDataPointerLike == Vec.isDataPointerLike();
  }

  
  /// Construct an ${FILE_NAME} from a std::vector.
  /*template <typename A> TEMPLATE*/
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::${FILE_NAME}${CLASS_SUFFIX}">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 78,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::${FILE_NAME}${CLASS_SUFFIX}")
  //</editor-fold>
  public </*typename*/ A> ${FILE_NAME}(/*const*/${VECTOR_TYPE} /*&*/ Vec) {
    this(Vec, Vec.isDataPointerLike());
  }
  public </*typename*/ A> ${FILE_NAME}(/*const*/${VECTOR_TYPE} /*&*/ Vec, boolean isDataPointerLike) {
    /* : Data(Vec.empty() ? (${VALUE_TYPE} * )0 : &Vec[0]), Length(Vec.size())*/ 
    //START JInit
    this.Data = $tryConstClone(Vec.data());
    this.Length = Vec.size();
    this.isDataPointerLike = isDataPointerLike;
    //END JInit
    assert isDataPointerLike == Vec.isDataPointerLike();
  }
  public ${FILE_NAME}(/*const*/std.vectorString /*&*/ Vec) {
  this(Vec, Vec.isDataPointerLike());
  }
  public ${FILE_NAME}(/*const*/std.vectorString /*&*/ Vec, boolean isDataPointerLike) {
    /* : Data(Vec.empty() ? (${VALUE_TYPE} * )0 : &Vec[0]), Length(Vec.size())*/ 
    //START JInit
    this.Data = $tryConstClone((${VALUE_POINTER}) (Object) Vec.data()); // hack to make specializations compilable
    this.Length = Vec.size();
    this.isDataPointerLike = isDataPointerLike;
    //END JInit
    assert isDataPointerLike == Vec.isDataPointerLike();
    assert isDataPointerLike == false;
  }

  
  /// Construct an ${FILE_NAME} from a C array.
  /*template <size_t N> TEMPLATE*/
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::${FILE_NAME}${CLASS_SUFFIX}">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 83,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::${FILE_NAME}${CLASS_SUFFIX}")
  //</editor-fold>
  public /*<int*//*size_t*//* N>*/ ${FILE_NAME}(/*const*/${VALUE_TYPE} /*&*/ Arr[]) {
    this(Arr, false);
  }
  public /*<int*//*size_t*//* N>*/ ${FILE_NAME}(/*const*/${VALUE_TYPE} /*&*/ Arr[], boolean isDataPointerLike) {
    /* : Data(Arr), Length(N)*/ 
    //START JInit
    this.Data = NativePointer.${POINTER_FACTORY_METHOD}(Arr);
    this.Length = Arr.length;
    this.isDataPointerLike = isDataPointerLike;
    //END JInit
  }


  // Copy constructor
  public ${FILE_NAME}(${FILE_NAME}${CLASS_SUFFIX} other) {
    this.Data = $tryConstClone(other.Data);
    this.Length = other.size();
    this.isDataPointerLike = other.isDataPointerLike;
  }
  public ${FILE_NAME}(JD$Convertible _param, ${FILE_NAME} other, boolean isDataPointerLike) {
    this.Data = (${VALUE_POINTER})$tryConstClone(other.Data);
    this.Length = other.size();
    assert other.isDataPointerLike == isDataPointerLike;
    this.isDataPointerLike = other.isDataPointerLike;
  }
  public ${FILE_NAME}(JD$Convertible _param, /*const*/${SMALL_VECTOR_TYPE} /*&*/ Vec, boolean isDataPointerLike) {
    this.Data = (${VALUE_POINTER})$tryConstClone(Vec.data());
    this.Length = Vec.size();
    this.isDataPointerLike = isDataPointerLike;
    assert isDataPointerLike == Vec.isDataPointerLike();
  }

  // Move constructor
  public ${FILE_NAME}(JD$Move _dparam, ${FILE_NAME}${CLASS_SUFFIX} other) {
    assert other != NONE : "use new ${FILE_NAME}<>(true/false) instead?";
    this.Data = other.Data;
    this.Length = other.Length;
    this.isDataPointerLike = other.isDataPointerLike;
    other.Data = null;
    other.Length = 0;
  }

  
  /// @}
  /// @name Simple Operations
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::begin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 97,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::begin")
  //</editor-fold>
  public ${VALUE_POINTER} begin() /*const*/ {
    return Data;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::end">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 98,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::end")
  //</editor-fold>
  public ${VALUE_POINTER} end() /*const*/ {
    return Length == 0 ? Data : Data.$add(Length);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::rbegin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 100,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::rbegin")
  //</editor-fold>
  public ${REVERSE_ITERATOR} rbegin() /*const*/ {
    return new ${REVERSE_ITERATOR}(end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::rend">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 101,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::rend")
  //</editor-fold>
  public ${REVERSE_ITERATOR} rend() /*const*/ {
    return new ${REVERSE_ITERATOR}(begin());
  }

  
  /// empty - Check if the array is empty.
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::empty">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 104,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::empty")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Length == 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::data">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 106,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::data")
  //</editor-fold>
  public /*const*/${VALUE_POINTER} /*P*/ data() /*const*/ {
    return Data;
  }

  
  /// size - Get the array size.
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::size">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 109,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::size")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    return Length;
  }

  
  /// front - Get the first element.
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::front">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 112,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::front")
  //</editor-fold>
  public /*const*/${VALUE_TYPE} /*&*/ front() /*const*/ {
    return Data.$at(0);
  }

  
  /// back - Get the last element.
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::back">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 118,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::back")
  //</editor-fold>
  public /*const*/${VALUE_TYPE} /*&*/ back() /*const*/ {
    return Data.$at(Length - 1);
  }


  // copy - Allocate copy in Allocator and return ArrayRef<T> to it.
  /*template <typename Allocator> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRef::copy">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 146,
   FQN="llvm::ArrayRef::copy", NM="_ZN4llvm8ArrayRef4copyERT_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm8ArrayRef4copyERT_")
  //</editor-fold>
  public ${FILE_NAME}${CLASS_SUFFIX} copy(Class<${BOXED_VALUE_TYPE}> cls, NativeMemory.Allocator /*&*/ A) {
    ${VALUE_POINTER} Buff;
    if (false) {
      Buff = (${VALUE_POINTER}) A.Allocate(cls, Length);
    } else {
      Buff = NativePointer.${POINTER_FACTORY_METHOD}(${CREATE_ARRAY_FROM_ELT_CLASS});
    }    
    ${CALL_STD_COPY};
    return new ${FILE_NAME}(Buff, Length, isDataPointerLike);
  }

  
  /// equals - Check for element-wise equality.
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::equals">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 124,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::equals")
  //</editor-fold>
  public boolean equals(${FILE_NAME}${CLASS_SUFFIX} RHS) /*const*/ {
    if (Native.$noteq(Length, RHS.Length)) {
      return false;
    }
    // Don't use std::equal(), since it asserts in MSVC on nullptr iterators.
    for (${VALUE_POINTER} L = $tryClone(begin()), LE = end(), R = $tryClone(RHS.begin()); L.$noteq(LE); L.$preInc(), R.$preInc()) {
      // Match std::equal() in using == (instead of !=) to minimize API
      // requirements of ArrayRef'ed types.
      if (!(Native.$eq(L.$star(), R.$star(), isDataPointerLike))) {
        return false;
      }
    }
    return true;
  }

  
  /// slice(n) - Chop off the first N elements of the array.
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::slice">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 134,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::slice")
  //</editor-fold>
  public ${FILE_NAME}${CLASS_SUFFIX} slice(/*uint*/int N) /*const*/ {
    return new ${FILE_NAME}${CLASS_SUFFIX}(data().$add(N), size() - N, isDataPointerLike);
  }

  
  /// slice(n, m) - Chop off the first N elements of the array, and keep M
  /// elements in the array.
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::slice">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 141,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::slice")
  //</editor-fold>
  public ${FILE_NAME}${CLASS_SUFFIX} slice(/*uint*/int N, /*uint*/int M) /*const*/ {
    return new ${FILE_NAME}${CLASS_SUFFIX}(data().$add(N), M, isDataPointerLike);
  }


  // \brief Drop the last \p N elements of the array.
  //<editor-fold defaultstate="collapsed" desc="llvm::ArrayRef::drop_back">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 179,
   FQN="llvm::ArrayRef::drop_back", NM="_ZNK4llvm8ArrayRef9drop_backEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm8ArrayRef9drop_backEj")
  //</editor-fold>
  public ${FILE_NAME}${CLASS_SUFFIX} drop_back() /*const*/ {
    return drop_back(1);
  }
  public ${FILE_NAME}${CLASS_SUFFIX} drop_back(/*uint*/int N/*= 1*/) /*const*/ {
    assert size() >= N : "Dropping more elements than exist";
    return slice(0, size() - N);
  }

  
  /// @}
  /// @name Operator Overloads
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::operator[]">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 149,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::operator[]")
  //</editor-fold>
  public /*const*/${VALUE_TYPE} /*&*/ $at(/*size_t*/int Index) /*const*/ {
    return Data.$at(Index);
  }
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::operator[]">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 149,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::operator[]")
  //</editor-fold>
  public /*const*/${VALUE_TYPE} /*&*/ $at(/*size_t*/uint$ref Index) /*const*/ {
    return Data.$at(Index.$deref());
  }

  public /*const*/${VALUE_POINTER} ptr$at(/*size_t*/uint$ref Index) /*const*/ {
    return ptr$at(Index.$deref());
  }
  public /*const*/${VALUE_POINTER} ptr$at(/*size_t*/int Index) /*const*/ {
    return Index == 0 ? Data : Data.$add(Index);
  }

  public /*const*/${VALUE_REFERENCE} ref$at(/*size_t*/uint$ref Index) /*const*/ {
    return ref$at(Index.$deref());
  }
  public /*const*/${VALUE_REFERENCE} ref$at(/*size_t*/int Index) /*const*/ {
    return Data.$add(Index).star$ref();
  }
  
  /// @}
  /// @name Expensive Operations
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::vec">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 157,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::vec")
  //</editor-fold>
  public ${VECTOR_TYPE} vec() /*const*/ {
    return new ${VECTOR_TYPE}(Data, end(), ${DEFAULT_VALUE});
  }

  
  /// @}
  /// @name Conversion operators
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::${FILE_NAME}::operator vector<type-parameter-0-0, allocator<type-parameter-0-0> >">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 164,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::${FILE_NAME}::operator vector<type-parameter-0-0, allocator<type-parameter-0-0> >")
  //</editor-fold>
  public ${VECTOR_TYPE} $vector/*<type-parameter-0-0, allocator<type-parameter-0-0> >*/() /*const*/ {
    return new ${VECTOR_TYPE}(Data, end(), ${DEFAULT_VALUE});
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

  public ${FILE_NAME}${CLASS_SUFFIX} $assign(${FILE_NAME}${CLASS_SUFFIX} other) {
    this.Data = other.Data;
    this.Length = other.Length;
    return this;
  }

  public ${FILE_NAME}${CLASS_SUFFIX} $assignMove(${FILE_NAME}${CLASS_SUFFIX} other) {
    assert other != NONE : "use new ${FILE_NAME}<>(" + this.isDataPointerLike + ") instead?";
    assert this.isDataPointerLike == other.isDataPointerLike;
    ${VALUE_POINTER} DataTmp = this.Data;
    int LengthTmp = this.Length;
    this.Data = other.Data;
    this.Length = other.Length;
    other.Data = null;
    other.Length = 0;
    return this;
  }
  
  @Override
  public ${FILE_NAME}${CLASS_SUFFIX} clone() {
    if (this.getClass() != ${FILE_NAME}.class) {
      throw new UnsupportedOperationException("Must be overridden in derived " + this.getClass());
    }
    return new ${FILE_NAME}${CLASS_SUFFIX}(this);
  }

  @Override
  public boolean $eq(${FILE_NAME}${CLASS_SUFFIX} other) {
    return this.equals(other);
  }
  
  @Override
  public Iterator<${BOXED_VALUE_TYPE}> iterator() {
    return Length == 0 ? EMPTY : new ArrayRefIterator(Data, Length);
  }  
  
  private static final ArrayRefIterator EMPTY = new ArrayRefIterator(null, 0);
  
  private static final class ArrayRefIterator${CLASS_SUFFIX} implements Iterator<${BOXED_VALUE_TYPE}> {
      
    private final ${VALUE_POINTER} localData;
    
    private final int localLength;
    
    private int pos = 0;

    public ArrayRefIterator(${VALUE_POINTER} Data, int Length) {
      this.localData = $tryClone(Data);
      this.localLength = Length;
    }

    @Override
    public boolean hasNext() {
      return pos < localLength;
    }

    @Override
    public ${BOXED_VALUE_TYPE} next() {
      ${BOXED_VALUE_TYPE} val = localData.$star();
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
