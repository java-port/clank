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

import java.util.Comparator;
import java.util.Iterator;
import org.clank.java.*;
import static org.clank.java.std.max;
import static org.clank.java.std.memcmp;
import static org.clank.java.std.min;
import org.clank.java.std.string;
import static org.clank.java.std.strlen;
import org.clank.support.*;
import static org.clank.support.Casts.*;
import static org.clank.support.Native.*;
import org.clank.support.Native.NativePOD;
import org.clank.support.Native.OpCapable;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import static org.llvm.support.impl.StringRefStatics.*;
import static org.llvm.support.llvm.*;
import static org.llvm.support.llvm.getAsSignedInteger;
import static org.llvm.support.llvm.getAsUnsignedInteger;


/// StringRef - Represent a constant reference to a string, i.e. a character
/// array and a length, which need not be null terminated.
///
/// This class does not own the string data, it is expected to be used in
/// situations where the character data resides in some other buffer, whose
/// lifetime extends past that of the StringRef. For this reason, it is not in
/// general safe to store a StringRef.
//<editor-fold defaultstate="collapsed" desc="llvm::StringRef">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 41,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 40,
 FQN = "llvm::StringRef", NM = "_ZN4llvm9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm9StringRefE")
//</editor-fold>
public class StringRef implements OpCapable, NativePOD<StringRef>, ComparableLower, NativeSwappable, NativeMoveable<StringRef>, Iterable<Byte> {
  public static final StringRef R$EMPTY = createConstStringRef(NativePointer.$EMPTY);
  public static final StringRef R$SPACE = createConstStringRef(NativePointer.$SPACE);
  public static final StringRef R$DOT = createConstStringRef(NativePointer.$DOT);
  public static final StringRef R$PLUS = createConstStringRef(NativePointer.$PLUS);
  public static final StringRef R$MINUS = createConstStringRef(NativePointer.$MINUS);
  public static final StringRef R$0 = createConstStringRef(NativePointer.$0);
  public static final StringRef R$1 = createConstStringRef(NativePointer.$1);
  public static final StringRef R$2 = createConstStringRef(NativePointer.$2);
  public static final StringRef R$3 = createConstStringRef(NativePointer.$3);
  public static final StringRef R$SLASH = createConstStringRef(NativePointer.$SLASH);
  public static final StringRef R$DOT_DOT = createConstStringRef(NativePointer.$DOT_DOT);
  public static final StringRef R$COLON = createConstStringRef(NativePointer.$COLON);

  //////////////////////////////////////////////////////////////////////////////
  // other commonly used StringRefs
  public static final StringRef R$scratch_space_marker = createConstStringRef(NativePointer.$scratch_space_marker);
  public static final StringRef R$__VA_ARGS__ = createConstStringRef(NativePointer.$__VA_ARGS__);
  public static final StringRef R$import = createConstStringRef(NativePointer.$import);
  public static final /*const*/StringRef R$invalid_marker/*J*/= createConstStringRef(NativePointer.$invalid_marker);
  public static final /*const*/StringRef R$built_in_marker/*J*/= createConstStringRef(NativePointer.$built_in_marker);
  public static final /*const*/StringRef R$STRING_REF_NO_ARGS/*J*/= createConstStringRef(null); // new StringRef()
  public static Comparator<StringRef> COMPARATOR = new Comparator<StringRef>() {
    @Override
    public int compare(StringRef o1, StringRef o2) {
      return o1.compare(o2);
    }
  };
  
  private static StringRef createConstStringRef(char$ptr constCharPtr) {
    if (NativeTrace.isDebugMode()) {
      return constCharPtr == null ? new ConstStringRef() : new ConstStringRef(constCharPtr);
    } else {
      return constCharPtr == null ? new StringRef() : new StringRef(constCharPtr);
    }
  }
  
  static {
    assert checkBuiltIn(R$EMPTY, "");
    assert checkBuiltIn(R$SPACE, " ");
    assert checkBuiltIn(R$DOT, ".");
    assert checkBuiltIn(R$PLUS, "+");
    assert checkBuiltIn(R$MINUS, "-");
    assert checkBuiltIn(R$0, "0");
    assert checkBuiltIn(R$1, "1");
    assert checkBuiltIn(R$2, "2");
    assert checkBuiltIn(R$3, "3");
    assert checkBuiltIn(R$SLASH, "/");
    assert checkBuiltIn(R$DOT_DOT, "..");
    assert checkBuiltIn(R$COLON, ":");
    assert checkBuiltIn(R$scratch_space_marker, "<scratch space>");
    assert checkBuiltIn(R$__VA_ARGS__, "__VA_ARGS__");
    assert checkBuiltIn(R$import, "import");
    assert checkBuiltIn(R$invalid_marker, "<invalid>");
    assert checkBuiltIn(R$built_in_marker, "<built-in>");
  }
  
  private static boolean checkBuiltIn(StringRef b, String toCompare) {
    assert b.$eq(new StringRef(toCompare)) : "[" + Casts.toJavaString(b.Data, b.Length) + "] vs. expected [" + toCompare + "]";
    assert b.$equals(toCompare) : "[" + Casts.toJavaString(b.Data, b.Length) + "] vs. expected [" + toCompare + "]";
    assert builtInConst(b) : "not builtin [" + Casts.toJavaString(b.Data, b.Length) + "]";
    return true;
  }
  
  private static boolean builtInConst(StringRef $Prm0) {
    if ($Prm0 == R$EMPTY) {
      return true;
    } else if ($Prm0 == R$SPACE) {
      return true;
    } else if ($Prm0 == R$DOT) {
      return true;
    } else if ($Prm0 == R$PLUS) {
      return true;
    } else if ($Prm0 == R$MINUS) {
      return true;
    } else if ($Prm0 == R$0) {
      return true;
    } else if ($Prm0 == R$1) {
      return true;
    } else if ($Prm0 == R$2) {
      return true;
    } else if ($Prm0 == R$3) {
      return true;
    } else if ($Prm0 == R$SLASH) {
      return true;
    } else if ($Prm0 == R$DOT_DOT) {
      return true;
    } else if ($Prm0 == R$COLON) {
      return true;
    } else if ($Prm0 == R$scratch_space_marker) {
      return true;
    } else if ($Prm0 == R$__VA_ARGS__) {
      return true;
    } else if ($Prm0 == R$import) {
      return true;
    } else if ($Prm0 == R$invalid_marker) {
      return true;
    } else if ($Prm0 == R$built_in_marker) {
      return true;
    } else if ($Prm0 == R$STRING_REF_NO_ARGS) {
      return true;
    }
    return false;
  }
  
/*public:*/
  /*typedef const char *iterator*/;
  /*typedef const char *const_iterator*/;
  public static /*const*//*size_t*/int npos = string.npos;
  /*typedef size_t size_type*/;
/*private:*/
  /// The start of the string, in an external buffer.
  private /*const*/char$ptr/*char P*/ Data;
  
  /// The length of the string.
  private /*size_t*/int Length;
  
  // Workaround memcmp issue with null pointers (undefined behavior)
  // by providing a specialized version
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::compareMemory">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 57,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 56,
   FQN = "llvm::StringRef::compareMemory", NM = "_ZN4llvm9StringRef13compareMemoryEPKcS2_j",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm9StringRef13compareMemoryEPKcS2_j")
  //</editor-fold>
  private static int compareMemory(/*const*/char$ptr/*char P*/ Lhs, int LhsStartIdx, /*const*/char$ptr/*char P*/ Rhs, int RhsStartIdx, /*size_t*/int Length) {
    if (Length == 0) {
      return 0;
    }
    return /*::*/memcmp(Lhs, LhsStartIdx, Rhs, RhsStartIdx, Length);
  }

  private static int compareMemory(/*const*/char$ptr/*char P*/ Lhs, int LhsStartIdx, /*const*/byte[]/*char P*/ Rhs, int RhsStartIdx, /*size_t*/int Length) {
    if (Length == 0) {
      return 0;
    }
    return /*::*/memcmp(Lhs, LhsStartIdx, Rhs, RhsStartIdx, Length);
  }

  // Workaround memcmp issue with null pointers (undefined behavior)
  // by providing a specialized version
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::compareMemory">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 63,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringRef::compareMemory")
  //</editor-fold>
  private static int compareMemory(/*const*/char$ptr/*char P*/ Lhs, int LhsStartIdx, /*const*/String/*char P*/ Rhs, int RhsIdx, /*size_t*/int Length) {
    if (Length == 0) {
      return 0;
    }
    return /*::*/memcmp(Lhs, LhsStartIdx, Rhs, RhsIdx, Length);
  }
  private static int compareMemory(byte[] Lhs, int LhsStartIdx, /*const*/String/*char P*/ Rhs, int RhsIdx, /*size_t*/int Length) {
    if (Length == 0) {
      return 0;
    }
    return /*::*/memcmp(Lhs, LhsStartIdx, Rhs, RhsIdx, Length);
  }

/*public:*/
  
  /// Construct an empty string ref.
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::StringRef">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 68,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 66,
   FQN = "llvm::StringRef::StringRef", NM = "_ZN4llvm9StringRefC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm9StringRefC1Ev")
  //</editor-fold>
  public StringRef() {
    /* : Data(0), Length(0)*/ 
    //START JInit
    this.Data = null;
    this.Length = 0;
    //END JInit
    trackEmptyInstance();
  }

  public StringRef(std.ConvertableToStdString obj) {
    this(obj.std$string());
  }

  public StringRef(Object obj) {
    throw new AssertionError("Unexpected " + NativeTrace.getIdentityStr(obj) + ":" + obj);
  }
  public StringRef(/*char*/byte ch) {
    throw new AssertionError("Use char$ptr constant (usually with one leading $ instead of [" + Unsigned.$uchar2ushort(ch) + "]");
  }
  
  /// Construct a string ref from a cstring.
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::StringRef">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 71,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 69,
   FQN = "llvm::StringRef::StringRef", NM = "_ZN4llvm9StringRefC1EPKc",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm9StringRefC1EPKc")
  //</editor-fold>
  public StringRef(/*const*/char$ptr/*char P*/ Str) {
    /* : Data(Str)*/ 
    //START JInit
    // VV: input pointer should not be reused outside after, change it to const
    this.Data = $toConst(Str);
    //END JInit
    assert ((Str != null)) : "StringRef cannot be built from a NULL argument";
    Length = /*::*/strlen(Str); // invoking strlen(NULL) is undefined behavior
    trackOtherInstance();
  }

  
  /// Construct a string ref from a pointer and length.
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::StringRef">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 78,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 76,
   FQN = "llvm::StringRef::StringRef", NM = "_ZN4llvm9StringRefC1EPKcj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm9StringRefC1EPKcj")
  //</editor-fold>
  public StringRef(/*const*/char$ptr/*char P*/ data, /*size_t*/int length) {
    /* : Data(data), Length(length)*/ 
    assert length >= 0 : "can not be negative " + length;
    //START JInit
    // VV: input pointer should not be reused outside after, change it to const
    this.Data = $toConst(data);
    this.Length = length;
    //END JInit
    assert (((data != null) || length == 0)) : "StringRef cannot be built from a NULL argument with non-null length";
    trackOtherInstance();
  }
  
  /// Construct a string ref from an std::string.
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::StringRef">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 86,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 83,
   FQN = "llvm::StringRef::StringRef", NM = "_ZN4llvm9StringRefC1ERKSs",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm9StringRefC1ERKSs")
  //</editor-fold>
  public StringRef(/*const*/std.string /*&*/ Str) {
    /* : Data(Str.data()), Length(Str.length())*/ 
    //START JInit
    this.Data = $toConst(Str.data());
    this.Length = Str.length();
    //END JInit
    trackOtherInstance();
  }
  
  // Constuct a string ref from java String
  public StringRef(String string) {
    this(string, string.length());
  }
  public StringRef(String string, int length) {
    this(create_char$ptr(string), length);
    trackCharSeqInstance();
  }  
  
  // Constuct a string ref from bytes using Len symbols
  public StringRef(byte seq[]) {
    this(seq, seq.length-1);
    assert seq[seq.length-1] == $$TERM: "must be \0 termed " + new String(seq);
  }
  public StringRef(byte seq[], int Len) {
    assert Len >= 0 : "can not be negative " + Len;
    this.Data = $toConst(NativePointer.create_const_char$ptr(seq));
    this.Length = Len;
    trackBytesInstance();
  }  

  // Constuct a string ref from bytes using Len symbols starting from index
  public StringRef(byte seq[], int startIdx, int Len) {
    assert Len >= 0 : "can not be negative " + Len;
    this.Data = $toConst(NativePointer.create_const_char$ptr(seq, startIdx));
    this.Length = Len;
    trackBytesInstance();
  }  
  
  /// @}
  /// @name Iterators
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::begin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 94,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 90,
   FQN = "llvm::StringRef::begin", NM = "_ZNK4llvm9StringRef5beginEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef5beginEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ begin() /*const*/ {
    return Data;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::end">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 96,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 92,
   FQN = "llvm::StringRef::end", NM = "_ZNK4llvm9StringRef3endEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef3endEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ end() /*const*/ {
    return Length == 0 ? Data : Data.$add(Length);
  }

  
  /// data - Get a pointer to the start of the string (which may not be null
  /// terminated).
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::data">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 111,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 107,
   FQN = "llvm::StringRef::data", NM = "_ZNK4llvm9StringRef4dataEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef4dataEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ data() /*const*/ {
    return Data;
  }

  
  /// empty - Check if the string is empty.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::empty">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 115,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 110,
   FQN = "llvm::StringRef::empty", NM = "_ZNK4llvm9StringRef5emptyEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Length == 0;
  }

  
  /// size - Get the string size.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::size">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 119,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 113,
   FQN = "llvm::StringRef::size", NM = "_ZNK4llvm9StringRef4sizeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    return Length;
  }

  
  /// front - Get the first character in the string.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::front">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 123,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 116,
   FQN = "llvm::StringRef::front", NM = "_ZNK4llvm9StringRef5frontEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef5frontEv")
  //</editor-fold>
  public /*char*/byte front() /*const*/ {
    assert (!empty());
    return Data.$at(0);
  }

  
  /// back - Get the last character in the string.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::back">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 129,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 122,
   FQN = "llvm::StringRef::back", NM = "_ZNK4llvm9StringRef4backEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef4backEv")
  //</editor-fold>
  public /*char*/byte back() /*const*/ {
    assert (!empty());
    return Data.$at(Length - 1);
  }

  // copy - Allocate copy in Allocator and return StringRef to it.
  /*template <typename Allocator> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::copy">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 135,
   FQN="llvm::StringRef::copy", NM="_ZNK4llvm9StringRef4copyERT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef4copyERT_")
  //</editor-fold>
  public StringRef copy(NativeMemory.Allocator /*&*/ A) /*const*/ {
    if (Length == 0) {
      return new StringRef();
    }
    char$ptr/*char P*/ S = A./*template */Allocate$Chars(Length);
    std.copy(begin(), end(), S);
    return new StringRef(S, Length);
  }
  
  /// equals - Check for string equality, this is more efficient than
  /// compare() when the relative ordering of inequal strings isn't needed.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::equals">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 143,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 136,
   FQN = "llvm::StringRef::equals", NM = "_ZNK4llvm9StringRef6equalsES0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef6equalsES0_")
  //</editor-fold>
  public boolean equals(StringRef RHS) /*const*/ {
    checkStringRef(RHS);
    return (RHS == this) || (Length == RHS.Length && compareMemory(Data, 0, RHS.Data, 0, RHS.Length) == 0);
  }
  public boolean equals(String RHS) /*const*/ {
    int length = RHS.length();
    return (Length == length && compareMemory(Data, 0, RHS, 0, length) == 0);
  }
  public boolean equals(std.string RHS) /*const*/ {
    int length = RHS.length();
    return (Length == length && compareMemory(Data, 0, RHS.$array(), 0, length) == 0);
  }
  public boolean equals(char$ptr RHS) /*const*/ {
    int length = strlen(RHS);
    return (Length == length && compareMemory(Data, 0, RHS, 0, length) == 0);
  }
  public boolean equals(byte[] RHSWithNullTerm) /*const*/ {
    assert RHSWithNullTerm[RHSWithNullTerm.length-1] == $$TERM : "Must be null-termed string";
    int length = RHSWithNullTerm.length-1/*TERM*/;
    return (Length == length && compareMemory(Data, 0, RHSWithNullTerm, 0, length) == 0);
  }
  
  /// equals_lower - Check for string equality, ignoring case.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::equals_lower">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 150,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 142,
   FQN = "llvm::StringRef::equals_lower", NM = "_ZNK4llvm9StringRef12equals_lowerES0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef12equals_lowerES0_")
  //</editor-fold>
  public boolean equals_lower(StringRef RHS) /*const*/ {
    return Length == RHS.Length && compare_lower(RHS) == 0;
  }

  public boolean equals_lower(String RHS) /*const*/ {
    return Length == RHS.length() && compare_lower(RHS) == 0;
  }

  public boolean equals_lower(char$ptr RHS) /*const*/ {
    int length = strlen(RHS);
    return Length == length && compare_lower(RHS, length) == 0;
  }

  
  /// compare - Compare two strings; the result is -1, 0, or 1 if this string
  /// is lexicographically less than, equal to, or greater than the \p RHS.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::compare">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 156,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 148,
   FQN = "llvm::StringRef::compare", NM = "_ZNK4llvm9StringRef7compareES0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef7compareES0_")
  //</editor-fold>
  public int compare(StringRef RHS) /*const*/ {
    if (RHS == this) {
        return 0;
    }
    {
      // Check the prefix for a mismatch.
      int Res = compareMemory(Data, 0, RHS.Data, 0, min(Length, RHS.Length));
      if ((Res != 0)) {
        return Res < 0 ? -1 : 1;
      }
    }
    
    // Otherwise the prefixes match, so we only need to check the lengths.
    if (Length == RHS.Length) {
      return 0;
    }
    return Length < RHS.Length ? -1 : 1;
  }
  public int compare(String RHS) /*const*/ {
    {
      // Check the prefix for a mismatch.
      int Res = compareMemory(Data, 0, RHS, 0, min(Length, RHS.length()));
      if ((Res != 0)) {
        return Res < 0 ? -1 : 1;
      }
    }
    
    // Otherwise the prefixes match, so we only need to check the lengths.
    if (Length == RHS.length()) {
      return 0;
    }
    return Length < RHS.length() ? -1 : 1;
  }

  
  /// compare_lower - Compare two strings, ignoring case.
  
  /// compare_lower - Compare strings, ignoring case.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::compare_lower">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 52,
   FQN = "llvm::StringRef::compare_lower", NM = "_ZNK4llvm9StringRef13compare_lowerES0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef13compare_lowerES0_")
  //</editor-fold>
  public int compare_lower(StringRef RHS) /*const*/ {
    if (RHS == this) {
        return 0;
    }      
    {
      int Res = ascii_strncasecmp(Data, RHS.Data, min(Length, RHS.Length));
      if ((Res != 0)) {
        return Res;
      }
    }
    if (Length == RHS.Length) {
      return 0;
    }
    return Length < RHS.Length ? -1 : 1;
  }
  public int compare_lower(String RHS) /*const*/ {    
    {
      int Res = ascii_strncasecmp(Data, RHS, min(Length, RHS.length()));
      if ((Res != 0)) {
        return Res;
      }
    }
    if (Length == RHS.length()) {
      return 0;
    }
    return Length < RHS.length() ? -1 : 1;
  }
  public int compare_lower(char$ptr RHS, int RHSLen) /*const*/ {    
    {
      int Res = ascii_strncasecmp(Data, RHS, min(Length, RHSLen));
      if ((Res != 0)) {
        return Res;
      }
    }
    if (Length == RHSLen) {
      return 0;
    }
    return Length < RHSLen ? -1 : 1;
  }

  
  /// compare_numeric - Compare two strings, treating sequences of digits as
  /// numbers.
  
  /// compare_numeric - Compare strings, handle embedded numbers.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::compare_numeric">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 73,
   FQN = "llvm::StringRef::compare_numeric", NM = "_ZNK4llvm9StringRef15compare_numericES0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef15compare_numericES0_")
  //</editor-fold>
  public int compare_numeric(StringRef RHS) /*const*/ {
    if (RHS == this) {
        return 0;
    }      
    for (/*size_t*/int I = 0, E = min(Length, RHS.Length); I != E; ++I) {
      // Check for sequences of digits.
      if (ascii_isdigit(Data.$at(I)) && ascii_isdigit(RHS.Data.$at(I))) {
        // The longer sequence of numbers is considered larger.
        // This doesn't really handle prefixed zeros well.
        /*size_t*/int J;
        for (J = I + 1; J != E + 1; ++J) {
          boolean ld = J < Length && ascii_isdigit(Data.$at(J));
          boolean rd = J < RHS.Length && ascii_isdigit(RHS.Data.$at(J));
          if (ld != rd) {
            return rd ? -1 : 1;
          }
          if (!rd) {
            break;
          }
        }
        {
          // The two number sequences have the same length (J-I), just memcmp them.
          int Res = compareMemory(Data, (int)I, RHS.Data, (int)I, J - I);
          if ((Res != 0)) {
            return Res < 0 ? -1 : 1;
          }
        }
        // Identical number sequences, continue search after the numbers.
        I = J - 1;
        continue;
      }
      if (Data.$at(I) != RHS.Data.$at(I)) {
        return ((/*uchar*/byte)Data.$at(I) & 0xFF) < ((/*uchar*/byte)RHS.Data.$at(I) & 0xFF) ? -1 : 1;
      }
    }
    if (Length == RHS.Length) {
      return 0;
    }
    return Length < RHS.Length ? -1 : 1;
  }

  
  /// \brief Determine the edit distance between this string and another
  /// string.
  ///
  /// \param Other the string to compare this string against.
  ///
  /// \param AllowReplacements whether to allow character
  /// replacements (change one character into another) as a single
  /// operation, rather than as two operations (an insertion and a
  /// removal).
  ///
  /// \param MaxEditDistance If non-zero, the maximum edit distance that
  /// this routine is allowed to compute. If the edit distance will exceed
  /// that maximum, returns \c MaxEditDistance+1.
  ///
  /// \returns the minimum number of character insertions, removals,
  /// or (if \p AllowReplacements is \c true) replacements needed to
  /// transform one of the given strings into the other. If zero,
  /// the strings are identical.
  
  // Compute the edit distance between the two given strings.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::edit_distance">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 104,
   FQN = "llvm::StringRef::edit_distance", NM = "_ZNK4llvm9StringRef13edit_distanceES0_bj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef13edit_distanceES0_bj")
  //</editor-fold>
  public /*uint*/int edit_distance(StringRef Other) /*const*/ {
    return edit_distance(Other, true, 0);
  }
  public /*uint*/int edit_distance(StringRef Other, boolean AllowReplacements/*= true*/) /*const*/ {
    return edit_distance(Other, AllowReplacements, 0);
  }
  public /*uint*/int edit_distance(StringRef Other, boolean AllowReplacements/*= true*/, /*uint*/int MaxEditDistance/*= 0*/) /*const*/ {
    return llvm.ComputeEditDistance(new ArrayRefChar(data(), size()), new ArrayRefChar(Other.data(), Other.size()), AllowReplacements, MaxEditDistance);
  }

  
  /// str - Get the contents as an std::string.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::str">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 197,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 188,
   FQN = "llvm::StringRef::str", NM = "_ZNK4llvm9StringRef3strEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef3strEv")
  //</editor-fold>
  public std.string str() /*const*/ {
    if (Data == null) {
      return new std.string();
    }
    return new std.string(Data, Length);
  }

  
  /// @}
  /// @name Operator Overloads
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::operator[]">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 206,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 197,
   FQN = "llvm::StringRef::operator[]", NM = "_ZNK4llvm9StringRefixEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRefixEj")
  //</editor-fold>
  public /*char*/byte $at(/*size_t*/int Index) /*const*/ {
    assert (Index < Length) : "Invalid index " + Index + " vs. " + Length;
    return Data.$at(Index);
  }

  
  /// @}
  /// @name Type Conversions
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::operator basic_string">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 206,
   FQN = "llvm::StringRef::operator basic_string", NM = "_ZNK4llvm9StringRefcvSsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringRef::operator basic_string")
  //</editor-fold>
  public std.string $string() /*const*/ {
    return str();
  }

  
  /// Check if this string starts with the given \p Prefix.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::startswith">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 224,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 215,
   FQN = "llvm::StringRef::startswith", NM = "_ZNK4llvm9StringRef10startswithES0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef10startswithES0_")
  //</editor-fold>
  public boolean startswith(StringRef Prefix) /*const*/ {
    checkStringRef(Prefix);
    return Length >= Prefix.Length && compareMemory(Data, 0, Prefix.Data, 0, Prefix.Length) == 0;
  }

  public boolean startswith(/*const*/std.string /*&*/ Prefix) /*const*/ {
    int length = Prefix.length();
    return Length >= length && compareMemory(Data, 0, Prefix.$array(), 0, length) == 0;
  }

  /// Check if this string starts with the given \p Prefix.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::startswith">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 208,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringRef::startswith")
  //</editor-fold>
  public boolean startswith(String Prefix) /*const*/ {
    int length = Prefix.length();
    return Length >= length && compareMemory(Data, 0, Prefix, 0, length) == 0;
  }  

  public boolean startswith(char$ptr Prefix) /*const*/ {
    int length = strlen(Prefix);
    return Length >= length && compareMemory(Data, 0, Prefix, 0, length) == 0;
  }  
  
  /// Check if this string starts with the given \p Prefix, ignoring case.
  
  /// Check if this string starts with the given \p Prefix, ignoring case.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::startswith_lower">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 61,
   FQN = "llvm::StringRef::startswith_lower", NM = "_ZNK4llvm9StringRef16startswith_lowerES0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef16startswith_lowerES0_")
  //</editor-fold>
  public boolean startswith_lower(StringRef Prefix) /*const*/ {
    return Length >= Prefix.Length && ascii_strncasecmp(Data, Prefix.Data, Prefix.Length) == 0;
  }
  public boolean startswith_lower(String Prefix) /*const*/ {
    return Length >= Prefix.length() && ascii_strncasecmp(Data, Prefix, Prefix.length()) == 0;
  }
  public boolean startswith_lower(char$ptr Prefix) /*const*/ {
    return startswith_lower(new StringRef(Prefix));
  }

  
  /// Check if this string ends with the given \p Suffix.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::endswith">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 234,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 224,
   FQN = "llvm::StringRef::endswith", NM = "_ZNK4llvm9StringRef8endswithES0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef8endswithES0_")
  //</editor-fold>
  public boolean endswith(StringRef Suffix) /*const*/ {
    checkStringRef(Suffix);
    return Length >= Suffix.Length && compareMemory(Data, this.Length - Suffix.Length, Suffix.Data, 0, Suffix.Length) == 0;
  }

  /// Check if this string ends with the given \p Suffix.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::endswith">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 217,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringRef::endswith")
  //</editor-fold>
  public boolean endswith(String Suffix) /*const*/ {
    int length = Suffix.length();
    return Length >= length && compareMemory(Data, this.Length - length, Suffix, 0, length) == 0;
  }

  public boolean endswith(char$ptr Suffix) /*const*/ {
    int length = strlen(Suffix);
    return Length >= length && compareMemory(Data, this.Length - length, Suffix, 0, length) == 0;
  }
  
  /// Check if this string ends with the given \p Suffix, ignoring case.
  
  /// Check if this string ends with the given \p Suffix, ignoring case.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::endswith_lower">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 67,
   FQN = "llvm::StringRef::endswith_lower", NM = "_ZNK4llvm9StringRef14endswith_lowerES0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef14endswith_lowerES0_")
  //</editor-fold>
  public boolean endswith_lower(StringRef Suffix) /*const*/ {
    return Length >= Suffix.Length && ascii_strncasecmp(Data, Length - Suffix.Length, Suffix.Data, 0, Suffix.Length) == 0;
  }
  
  @Converted(kind = Converted.Kind.MANUAL)
  public boolean endswith_lower(String Suffix) /*const*/ {
    return Length >= Suffix.length() && ascii_strncasecmp(Data, Length - Suffix.length(), Suffix, 0, Suffix.length()) == 0;
  }

  
  /// Search for the first character \p C in the string.
  ///
  /// \returns The index of the first occurrence of \p C, or npos if not
  /// found.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::find">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 251,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 240,
   FQN = "llvm::StringRef::find", NM = "_ZNK4llvm9StringRef4findEcj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef4findEcj")
  //</editor-fold>
  public /*size_t*/int find(/*char*/byte C) /*const*/ {
    return find(C, 0);
  }
  public /*size_t*/int find(/*char*/byte C, /*size_t*/int From/*= 0*/) /*const*/ {
    for (/*size_t*/int i = min(From, Length), e = Length; i != e; ++i)  {
      if (Data.$at(i) == C) {
        return i;
      }
    }
    return npos;
  }

  
  /// Search for the first string \p Str in the string.
  ///
  /// \returns The index of the first occurrence of \p Str, or npos if not
  /// found.
  
  /// find - Search for the first string \arg Str in the string.
  ///
  /// \return - The index of the first occurrence of \arg Str, or npos if not
  /// found.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::find">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 142,
   FQN = "llvm::StringRef::find", NM = "_ZNK4llvm9StringRef4findES0_j",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef4findES0_j")
  //</editor-fold>
  public /*size_t*/int find(StringRef Str) /*const*/ {
    return find(Str, 0);
  }
  public /*size_t*/int find(StringRef Str, /*size_t*/int From/*= 0*/) /*const*/ {
    checkStringRef(Str);
    /*size_t*/int N = Str.size();
    if (N > Length) {
      return npos;
    }
    
    // For short haystacks or unsupported needles fall back to the naive algorithm
    if (Length < 16 || N > 255 || N == 0) {
      for (/*size_t*/int e = Length - N + 1, i = min(From, e); i != e; ++i)  {
        if (compareMemory(Data, i, Str.Data, 0, N) == 0) {
          return i;
        }
      }
      return npos;
    }
    if (From >= Length) {
      return npos;
    }
    
    // Build the bad char heuristic table, with uint8_t to reduce cache thrashing.
    int BadCharSkip[/*256*/] = $BadCharSkip();
    std.memset(BadCharSkip, N, 256);
    for (/*uint*/int i = 0; i != N - 1; ++i)  {
      BadCharSkip[$char(Str.$at(i))] = (N - 1 - i);
    }
    
    /*uint*/int Len = Length - From, Pos = From;
    while (Len >= N) {
      if (compareMemory(Data, Pos, Str.Data, 0, N) == 0) {
        // See if this is the correct substring.
        return Pos;
      }
      
      // Otherwise skip the appropriate number of bytes.
      /*uchar*/int Skip = BadCharSkip[$char(this.$at(Pos + N - 1))];
      assert Skip >= 0 : "must be unsigned value";
      Len -= Skip;
      Pos += Skip;
    }
    
    return npos;
  }

  public int find(char$ptr Str) {
    return find(new StringRef(Str));
  }

  // JAVA: Performance
  public /*size_t*/int find(std.string Str) /*const*/ {
    return find(Str, 0);
  }
  public /*size_t*/int find(std.string Str, /*size_t*/int From/*= 0*/) /*const*/ {
    /*size_t*/int N = Str.size();
    if (N > Length) {
      return npos;
    }
    
    // For short haystacks or unsupported needles fall back to the naive algorithm
    if (Length < 16 || N > 255 || N == 0) {
      for (/*size_t*/int e = Length - N + 1, i = min(From, e); i != e; ++i)  {
        if (compareMemory(Data, i, Str.$array(), 0, N) == 0) {
          return i;
        }
      }
      return npos;
    }
    if (From >= Length) {
      return npos;
    }
    
    // Build the bad char heuristic table, with uint8_t to reduce cache thrashing.
    int BadCharSkip[/*256*/] = $BadCharSkip();
    std.memset(BadCharSkip, N, 256);
    for (/*uint*/int i = 0; i != N - 1; ++i)  {
      BadCharSkip[$char(Str.$at(i))] = (N - 1 - i);
    }
    
    /*uint*/int Len = Length - From, Pos = From;
    while (Len >= N) {
      if (compareMemory(Data, Pos, Str.$array(), 0, N) == 0) {
        // See if this is the correct substring.
        return Pos;
      }
      
      // Otherwise skip the appropriate number of bytes.
      /*uchar*/int Skip = BadCharSkip[$char(this.$at(Pos + N - 1))];
      assert Skip >= 0 : "must be unsigned value";
      Len -= Skip;
      Pos += Skip;
    }
    
    return npos;
  }
  
  // JAVA: Performance
  public /*size_t*/int find(String Str) /*const*/ {
    return find(Str, 0);
  }
  public /*size_t*/int find(String Str, /*size_t*/int From/*= 0*/) /*const*/ {
    /*size_t*/int N = Str.length();
    if (N > Length) {
      return npos;
    }
    
    // For short haystacks or unsupported needles fall back to the naive algorithm
    if (Length < 16 || N > 255 || N == 0) {
      for (/*size_t*/int e = Length - N + 1, i = min(From, e); i != e; ++i)  {
        if (compareMemory(Data, i, Str, 0, N) == 0) {
          return i;
        }
      }
      return npos;
    }
    if (From >= Length) {
      return npos;
    }
    
    // Build the bad char heuristic table, with uint8_t to reduce cache thrashing.
    int BadCharSkip[/*256*/] = $BadCharSkip();
    std.memset(BadCharSkip, N, 256);
    for (/*uint*/int i = 0; i != N - 1; ++i)  {
      BadCharSkip[Str.charAt(i)] = (N - 1 - i);
    }
    
    /*uint*/int Len = Length - From, Pos = From;
    while (Len >= N) {
      if (compareMemory(Data, Pos, Str, 0, N) == 0) {
        // See if this is the correct substring.
        return Pos;
      }
      
      // Otherwise skip the appropriate number of bytes.
      /*uchar*/int Skip = BadCharSkip[$char(this.$at(Pos + N - 1))];
      assert Skip >= 0 : "must be unsigned value";
      Len -= Skip;
      Pos += Skip;
    }
    
    return npos;
  }
  
  public static /*size_t*/int find(String Str, byte[] Data, /*size_t*/int DataIndex, int DataLength) /*const*/ {
    /*size_t*/int N = Str.length();
    int Length = DataLength;
    if (N > Length) {
      return npos;
    }
    int From = 0;
    // For short haystacks or unsupported needles fall back to the naive algorithm
    if (Length < 16 || N > 255 || N == 0) {
      for (/*size_t*/int e = Length - N + 1, i = min(From, e); i != e; ++i)  {
        if (compareMemory(Data, DataIndex + i, Str, 0, N) == 0) {
          return DataIndex+i;
        }
      }
      return npos;
    }
    if (From >= Length) {
      return npos;
    }
    
    // Build the bad char heuristic table, with uint8_t to reduce cache thrashing.
    int BadCharSkip[/*256*/] = $BadCharSkip();
    std.memset(BadCharSkip, N, 256);
    for (/*uint*/int i = 0; i != N - 1; ++i)  {
      BadCharSkip[Str.charAt(i)] = (N - 1 - i);
    }
    
    /*uint*/int Len = Length - From, Pos = From;
    while (Len >= N) {
      if (compareMemory(Data, DataIndex + Pos, Str, 0, N) == 0) {
        // See if this is the correct substring.
        return DataIndex+Pos;
      }
      
      // Otherwise skip the appropriate number of bytes.
      /*uchar*/int Skip = BadCharSkip[$char(Data[Pos + N - 1])];
      assert Skip >= 0 : "must be unsigned value";
      Len -= Skip;
      Pos += Skip;
    }
    
    return npos;
  }
  
  /// Search for the last character \p C in the string.
  ///
  /// \returns The index of the last occurrence of \p C, or npos if not
  /// found.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::rfind">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 272,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 257,
   FQN = "llvm::StringRef::rfind", NM = "_ZNK4llvm9StringRef5rfindEcj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef5rfindEcj")
  //</editor-fold>
  public /*size_t*/int rfind(/*char*/byte C) /*const*/ {
    return rfind(C, npos);
  }
  public /*size_t*/int rfind(/*char*/byte C, /*size_t*/int From/*= npos*/) /*const*/ {
    From = min(From, Length);
    /*size_t*/int i = From;
    while (i != 0) {
      --i;
      if (Data.$at(i) == C) {
        return i;
      }
    }
    return npos;
  }

  
  /// Search for the last string \p Str in the string.
  ///
  /// \returns The index of the last occurrence of \p Str, or npos if not
  /// found.
  
  /// rfind - Search for the last string \arg Str in the string.
  ///
  /// \return - The index of the last occurrence of \arg Str, or npos if not
  /// found.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::rfind">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 189,
   old_source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", old_line = 182,
   FQN = "llvm::StringRef::rfind", NM = "_ZNK4llvm9StringRef5rfindES0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef5rfindES0_")
  //</editor-fold>
  public /*size_t*/int rfind(StringRef Str) /*const*/ {
    /*size_t*/int N = Str.size();
    if (N > Length) {
      return npos;
    }
    for (/*size_t*/int i = Length - N + 1, e = 0; i != e;) {
      --i;
      if (compareMemory(Data, i, Str.Data, 0, N) == 0) {
        return i;
      }
    }
    return npos;
  }

  public /*size_t*/int rfind(String Str) /*const*/ {
    // TODO: this should be probably optimized
    return rfind(new StringRef(Str));
  }
    
  /// Find the first character in the string that is \p C, or npos if not
  /// found. Same as find.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::find_first_of">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 291,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 276,
   FQN = "llvm::StringRef::find_first_of", NM = "_ZNK4llvm9StringRef13find_first_ofEcj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef13find_first_ofEcj")
  //</editor-fold>
  public /*size_t*/int find_first_of(/*char*/byte C) /*const*/ {
    return find_first_of(C, 0);
  }
  public /*size_t*/int find_first_of(/*char*/byte C, /*size_t*/int From/*= 0*/) /*const*/ {
    return find(C, From);
  }

  
  /// Find the first character in the string that is in \p Chars, or npos if
  /// not found.
  ///
  /// Complexity: O(size() + Chars.size())
  
  /// find_first_of - Find the first character in the string that is in \arg
  /// Chars, or npos if not found.
  ///
  /// Note: O(size() + Chars.size())
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::find_first_of">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 205,
   old_source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", old_line = 198,
   FQN = "llvm::StringRef::find_first_of", NM = "_ZNK4llvm9StringRef13find_first_ofES0_j",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef13find_first_ofES0_j")
  //</editor-fold>
  public /*size_t*/int find_first_of(StringRef Chars) /*const*/ {
    return find_first_of(Chars, 0);
  }
  public /*size_t*/int find_first_of(StringRef Chars, /*size_t*/int From/*= 0*/) /*const*/ {
    std.bitset CharBits/*J*/= new std.bitset(1 << 8);
    for (/*size_t*/int i = 0; i != Chars.size(); ++i)  {
      CharBits.set((/*uchar*/byte)Chars.$at(i));
    }
    
    for (/*size_t*/int i = min(From, Length), e = Length; i != e; ++i)  {
      if (CharBits.test((/*uchar*/byte)Data.$at(i))) {
        return i;
      }
    }
    return npos;
  }
  public /*size_t*/int find_first_of(String Chars) /*const*/ {
    return find_first_of(Chars, 0);
  }
  public /*size_t*/int find_first_of(String Chars, /*size_t*/int From/*= 0*/) /*const*/ {
    std.bitset CharBits/*J*/= new std.bitset(1 << 8);
    for (/*size_t*/int i = 0; i != Chars.length(); ++i)  {
      CharBits.set((/*uchar*/byte)Chars.charAt(i));
    }
    
    for (/*size_t*/int i = min(From, Length), e = Length; i != e; ++i)  {
      if (CharBits.test((/*uchar*/byte)Data.$at(i))) {
        return i;
      }
    }
    return npos;
  }

  
  /// Find the first character in the string that is not \p C or npos if not
  /// found.
  
  /// find_first_not_of - Find the first character in the string that is not
  /// \arg C or npos if not found.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::find_first_not_of">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 219,
   old_source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", old_line = 212,
   FQN = "llvm::StringRef::find_first_not_of", NM = "_ZNK4llvm9StringRef17find_first_not_ofEcj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef17find_first_not_ofEcj")
  //</editor-fold>
  public /*size_t*/int find_first_not_of(/*char*/byte C) /*const*/ {
    return find_first_not_of(C, 0);
  }
  public /*size_t*/int find_first_not_of(/*char*/byte C, /*size_t*/int From/*= 0*/) /*const*/ {
    for (/*size_t*/int i = min(From, Length), e = Length; i != e; ++i)  {
      if (Data.$at(i) != C) {
        return i;
      }
    }
    return npos;
  }


  /// Find the first character in the string that is not in the string
  /// \p Chars, or npos if not found.
  ///
  /// Complexity: O(size() + Chars.size())
  
  /// find_first_not_of - Find the first character in the string that is not
  /// in the string \arg Chars, or npos if not found.
  ///
  /// Note: O(size() + Chars.size())
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::find_first_not_of">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 230,
   old_source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", old_line = 223,
   FQN = "llvm::StringRef::find_first_not_of", NM = "_ZNK4llvm9StringRef17find_first_not_ofES0_j",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef17find_first_not_ofES0_j")
  //</editor-fold>
  public /*size_t*/int find_first_not_of(StringRef Chars) /*const*/ {
    return find_first_not_of(Chars, 0);
  }
  public /*size_t*/int find_first_not_of(StringRef Chars, /*size_t*/int From/*= 0*/) /*const*/ {
    std.bitset CharBits/*J*/= new std.bitset(1 << 8);
    for (/*size_t*/int i = 0; i != Chars.size(); ++i)  {
      CharBits.set((/*uchar*/byte)Chars.$at(i));
    }
    
    for (/*size_t*/int i = min(From, Length), e = Length; i != e; ++i)  {
      if (!CharBits.test((/*uchar*/byte)Data.$at(i))) {
        return i;
      }
    }
    return npos;
  }
  public int find_first_not_of(char$ptr Blanks) {
    return find_first_not_of(new StringRef(Blanks));
  }


  public final /*size_t*/int find_first_not_of(String Chars) /*const*/ {
    return find_first_not_of(Chars, 0);
  }

  public final /*size_t*/int find_first_not_of(String Chars, /*size_t*/int From/*= 0*/) /*const*/ {
    std.bitset CharBits/*J*/= new std.bitset(1 << 8);
    for (/*size_t*/int i = 0; i != Chars.length(); ++i)  {
      CharBits.set((/*uchar*/byte)Chars.charAt(i));
    }

    for (/*size_t*/int i = min(From, Length), e = Length; i != e; ++i)  {
      if (!CharBits.test((/*uchar*/byte)Data.$at(i))) {
        return i;
      }
    }
    return npos;
  }

  /// Find the last character in the string that is \p C, or npos if not
  /// found.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::find_last_of">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 313,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 298,
   FQN = "llvm::StringRef::find_last_of", NM = "_ZNK4llvm9StringRef12find_last_ofEcj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef12find_last_ofEcj")
  //</editor-fold>
  public /*size_t*/int find_last_of(/*char*/byte C) /*const*/ {
    return find_last_of(C, npos);
  }
  public /*size_t*/int find_last_of(/*char*/byte C, /*size_t*/int From/*= npos*/) /*const*/ {
    return rfind(C, From);
  }

  
  /// Find the last character in the string that is in \p C, or npos if not
  /// found.
  ///
  /// Complexity: O(size() + Chars.size())
  
  /// find_last_of - Find the last character in the string that is in \arg C,
  /// or npos if not found.
  ///
  /// Note: O(size() + Chars.size())
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::find_last_of">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 246,
   old_source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", old_line = 239,
   FQN = "llvm::StringRef::find_last_of", NM = "_ZNK4llvm9StringRef12find_last_ofES0_j",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef12find_last_ofES0_j")
  //</editor-fold>
  public /*size_t*/int find_last_of(StringRef Chars) /*const*/ {
    return find_last_of(Chars, npos);
  }
  public /*size_t*/int find_last_of(StringRef Chars, /*size_t*/int From/*= npos*/) /*const*/ {
    std.bitset CharBits/*J*/= new std.bitset(1 << 8);
    for (/*size_t*/int i = 0; i != Chars.size(); ++i)  {
      CharBits.set((/*uchar*/byte)Chars.$at(i));
    }
    
    for (/*size_t*/int i = min(From, Length) - 1, e = -1; i != e; --i)  {
      if (CharBits.test((/*uchar*/byte)Data.$at(i))) {
        return i;
      }
    }
    return npos;
  }

  public /*size_t*/int find_last_of(String Chars) /*const*/ {
    return find_last_of(Chars, npos);
  }

  public /*size_t*/int find_last_of(String Chars, int From) /*const*/ {
    std.bitset CharBits/*J*/= new std.bitset(1 << 8);
    for (/*size_t*/int i = 0; i != Chars.length(); ++i)  {
      CharBits.set((/*uchar*/byte)Chars.charAt(i));
    }

    for (/*size_t*/int i = min(From, Length) - 1, e = -1; i != e; --i)  {
      if (CharBits.test((/*uchar*/byte)Data.$at(i))) {
        return i;
      }
    }
    return npos;
  }
  
  /// Find the last character in the string that is not \p C, or npos if not
  /// found.
  
  /// find_last_not_of - Find the last character in the string that is not
  /// \arg C, or npos if not found.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::find_last_not_of">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 260,
   old_source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", old_line = 253,
   FQN = "llvm::StringRef::find_last_not_of", NM = "_ZNK4llvm9StringRef16find_last_not_ofEcj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef16find_last_not_ofEcj")
  //</editor-fold>
  public /*size_t*/int find_last_not_of(/*char*/byte C) /*const*/ {
    return find_last_not_of(C, npos);
  }
  public /*size_t*/int find_last_not_of(/*char*/byte C, /*size_t*/int From/*= npos*/) /*const*/ {
    for (/*size_t*/int i = min(From, Length) - 1, e = -1; i != e; --i)  {
      if (Data.$at(i) != C) {
        return i;
      }
    }
    return npos;
  }
  
  public int find_last_not_of(char$ptr Blanks, int From) {
    return find_last_not_of(new StringRef(Blanks), From);
  }

  
  /// Find the last character in the string that is not in \p Chars, or
  /// npos if not found.
  ///
  /// Complexity: O(size() + Chars.size())
  
  /// find_last_not_of - Find the last character in the string that is not in
  /// \arg Chars, or npos if not found.
  ///
  /// Note: O(size() + Chars.size())
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::find_last_not_of">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 271,
   old_source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", old_line = 264,
   FQN = "llvm::StringRef::find_last_not_of", NM = "_ZNK4llvm9StringRef16find_last_not_ofES0_j",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef16find_last_not_ofES0_j")
  //</editor-fold>
  public /*size_t*/int find_last_not_of(StringRef Chars) /*const*/ {
    return find_last_not_of(Chars, npos);
  }
  public /*size_t*/int find_last_not_of(StringRef Chars, /*size_t*/int From/*= npos*/) /*const*/ {
    std.bitset CharBits/*J*/= new std.bitset(1 << 8);
    for (/*size_t*/int i = 0, e = Chars.size(); i != e; ++i)  {
      CharBits.set((/*uchar*/byte)Chars.$at(i));
    }
    
    for (/*size_t*/int i = min(From, Length) - 1, e = -1; i != e; --i)  {
      if (!CharBits.test((/*uchar*/byte)Data.$at(i))) {
        return i;
      }
    }
    return npos;
  }

  public /*size_t*/int find_last_not_of(String Chars) /*const*/ {
    return find_last_not_of(Chars, npos);
  }

  public /*size_t*/int find_last_not_of(String Chars, /*size_t*/int From/*= npos*/) /*const*/ {
    std.bitset CharBits/*J*/= new std.bitset(1 << 8);
    for (/*size_t*/int i = 0, e = Chars.length(); i != e; ++i)  {
      CharBits.set((/*uchar*/byte)Chars.charAt(i));
    }

    for (/*size_t*/int i = min(From, Length) - 1, e = -1; i != e; --i)  {
      if (!CharBits.test((/*uchar*/byte)Data.$at(i))) {
        return i;
      }
    }
    return npos;
  }

  
  /// Return the number of occurrences of \p C in the string.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::count">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 338,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 323,
   FQN = "llvm::StringRef::count", NM = "_ZNK4llvm9StringRef5countEc",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef5countEc")
  //</editor-fold>
  public /*size_t*/int count(/*char*/byte C) /*const*/ {
    /*size_t*/int Count = 0;
    for (/*size_t*/int i = 0, e = Length; i != e; ++i)  {
      if (Data.$at(i) == C) {
        ++Count;
      }
    }
    return Count;
  }

  
  /// Return the number of non-overlapped occurrences of \p Str in
  /// the string.
  
  /// count - Return the number of non-overlapped occurrences of \arg Str in
  /// the string.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::count">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 342,
   old_source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", old_line = 303,
   FQN = "llvm::StringRef::count", NM = "_ZNK4llvm9StringRef5countES0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef5countES0_")
  //</editor-fold>
  public /*size_t*/int count(StringRef Str) /*const*/ {
    /*size_t*/int Count = 0;
    /*size_t*/int N = Str.size();
    if (N > Length) {
      return 0;
    }
    for (/*size_t*/int i = 0, e = Length - N + 1; i != e; ++i)  {
      if (compareMemory(Data, i, Str.Data, 0, N) == 0) {
        ++Count;
      }
    }
    return Count;
  }

  /// Parse the current string as an integer of the specified radix.  If
  /// \p Radix is specified as zero, this does radix autosensing using
  /// extended C rules: 0 is octal, 0x is hex, 0b is binary.
  ///
  /// If the string is invalid or if only a subset of the string is valid,
  /// this returns true to signify the error.  The string is considered
  /// erroneous if empty or if it overflows T.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::getAsInteger">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 366,
   FQN="llvm::StringRef::getAsInteger", NM="_ZNK4llvm9StringRef12getAsIntegerEjRT_R_ZTSNSt9enable_ifIXsr3std14numeric_limitsIT_EE9is_signedEbE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef12getAsIntegerEjRT_R_ZTSNSt9enable_ifIXsr3std14numeric_limitsIT_EE9is_signedEbE4typeE")
  //</editor-fold>
  public /*std::enable_if<std::numeric_limits<T>::is_signed, boolean>::type*/boolean getAsInteger$Signed(/*uint*/int Radix, int$ref /*&*/ Result) /*const*/ {
    /*llong*/llong$ref LLVal = create_llong$ref(0);
    if (getAsSignedInteger(new StringRef(/*Deref*/this), Radix, LLVal)
       || ((int)(LLVal.$deref()) != LLVal.$deref())) {
      return true;
    }
    Result.$set($long2int(LLVal.$deref()));
    return false;
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::getAsInteger">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 377,
   FQN="llvm::StringRef::getAsInteger", NM="_ZNK4llvm9StringRef12getAsIntegerEjRT_R_ZTSNSt9enable_ifIXntsr3std14numeric_limitsIT_EE9is_signedEbE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef12getAsIntegerEjRT_R_ZTSNSt9enable_ifIXntsr3std14numeric_limitsIT_EE9is_signedEbE4typeE")
  //</editor-fold>
  public </*typename*/ T> /*std::enable_if<!std::numeric_limits<T>::is_signed, boolean>::type*/boolean getAsInteger$NotSigned(/*uint*/int Radix, uint$ref /*&*/ Result) /*const*/ {
    /*ullong*/ullong$ref ULLVal = create_ullong$ref(0);
    // The additional cast to unsigned long long is required to avoid the
    // Visual C++ warning C4805: '!=' : unsafe mix of type 'bool' and type
    // 'unsigned __int64' when instantiating getAsInteger with T = bool.
    if (getAsUnsignedInteger(new StringRef(/*Deref*/this), Radix, ULLVal)
       || ((/*uint*/int)(ULLVal.$deref()) != ULLVal.$deref())) {
      return true;
    }
    Result.$set($ullong2uint(ULLVal.$deref()));
    return false;
  }
  public </*typename*/ T> /*std::enable_if<!std::numeric_limits<T>::is_signed, boolean>::type*/boolean getAsInteger$NotSigned(/*uint*/int Radix, ulong$ref /*&*/ Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }
  public </*typename*/ T> /*std::enable_if<!std::numeric_limits<T>::is_signed, boolean>::type*/boolean getAsInteger$NotSigned(/*uint*/int Radix, ullong$ref /*&*/ Result) /*const*/ {
    /*ullong*/ullong$ref ULLVal = create_ullong$ref(0);
    // The additional cast to unsigned long long is required to avoid the
    // Visual C++ warning C4805: '!=' : unsafe mix of type 'bool' and type
    // 'unsigned __int64' when instantiating getAsInteger with T = bool.
    if (getAsUnsignedInteger(new StringRef(/*Deref*/this), Radix, ULLVal)
       || ((/*ulong*/long)(ULLVal.$deref()) != ULLVal.$deref())) {
      return true;
    }
    Result.$set(ULLVal.$deref());
    return false;
  }
  public </*typename*/ T> /*std::enable_if<!std::numeric_limits<T>::is_signed, boolean>::type*/boolean getAsInteger$NotSigned(/*uint*/int Radix, bool$ref /*&*/ Result) /*const*/ {
    assert Radix == 2 : "specialization for Radix = 2 vs " + Radix;
    /*ullong*/ullong$ref ULLVal = create_ullong$ref(0);
    // The additional cast to unsigned long long is required to avoid the
    // Visual C++ warning C4805: '!=' : unsafe mix of type 'bool' and type
    // 'unsigned __int64' when instantiating getAsInteger with T = bool.
    if (getAsUnsignedInteger(new StringRef(/*Deref*/this), Radix, ULLVal)) {
      return true;
    }
    Result.$set(ULLVal.$deref() == 0 ? false : true);
    return false;
  }
  
  /// Parse the current string as an integer of the specified radix.  If
  /// \p Radix is specified as zero, this does radix autosensing using
  /// extended C rules: 0 is octal, 0x is hex, 0b is binary.
  ///
  /// If the string is invalid or if only a subset of the string is valid,
  /// this returns true to signify the error.  The string is considered
  /// erroneous if empty or if it overflows T.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::getAsInteger">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 336,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringRef::getAsInteger")
  //</editor-fold>
  public boolean getAsInteger(/*uint*/int Radix, int$ref /*&*/ Result) /*const*/ {
    /*llong*/llong$ref LLVal = NativePointer.create_llong$ref(0);
    if (getAsSignedInteger(/*Deref*/this, Radix, LLVal) || (/*static_cast*//*T*/int)(LLVal.$deref()) != LLVal.$deref()) {
      return true;
    }
    Result.$set((int) LLVal.$deref());
    return false;
  }

  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::getAsInteger">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 347,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringRef::getAsInteger")
  //</editor-fold>
  public boolean getAsInteger(/*uint*/int Radix, uint$ref /*&*/ Result) /*const*/ {
    /*ullong*/ullong$ref ULLVal = NativePointer.create_ullong$ref(0);
    if (getAsUnsignedInteger(/*Deref*/this, Radix, ULLVal) || (/*static_cast*//*T*/ long)(ULLVal.$deref()) != ULLVal.$deref()) {
      return true;
    }
    Result.$set($long2uint(ULLVal.$deref()));
    return false;
  }
  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::getAsInteger">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 347,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -filter=llvm::StringRef::getAsInteger")
  //</editor-fold>
  public boolean getAsInteger(/*uint*/int Radix, ulong$ref /*&*/ Result) /*const*/ {
    /*ullong*/ullong$ref ULLVal = NativePointer.create_ullong$ref(0);
    if (getAsUnsignedInteger(/*Deref*/this, Radix, ULLVal) || (/*static_cast*//*T*/ long)(ULLVal.$deref()) != ULLVal.$deref()) {
      return true;
    }
    Result.$set(ULLVal.$deref());
    return false;
  }

  
  /// Parse the current string as an integer of the specified \p Radix, or of
  /// an autosensed radix if the \p Radix given is 0.  The current value in
  /// \p Result is discarded, and the storage is changed to be wide enough to
  /// store the parsed integer.
  ///
  /// \returns true if the string does not solely consist of a valid
  /// non-empty number in the appropriate base.
  ///
  /// APInt::fromString is superficially similar but assumes the
  /// string is well-formed in the given radix.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::getAsInteger">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 445,
   old_source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", old_line = 406,
   FQN = "llvm::StringRef::getAsInteger", NM = "_ZNK4llvm9StringRef12getAsIntegerEjRNS_5APIntE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef12getAsIntegerEjRNS_5APIntE")
  //</editor-fold>
  public boolean getAsInteger(/*uint*/int Radix, APInt /*&*/ Result) /*const*/ {
    APInt RadixAP = null;
    APInt CharAP = null;
    try {
      StringRef Str = new StringRef(this);
      
      // Autosense radix if not specified.
      if (Radix == 0) {
        Radix = GetAutoSenseRadix(Str);
      }
      assert (Radix > 1) : Radix <= 36;
      
      // Empty strings (after the radix autosense) are invalid.
      if (Str.empty()) {
        return true;
      }
      
      // Skip leading zeroes.  This can be a significant improvement if
      // it means we don't need > 64 bits.
      while (!Str.empty() && Str.front() == $$0) {
        Str.$assign$substr(1);
      }
      
      // If it was nothing but zeroes....
      if (Str.empty()) {
        Result.$assign(new APInt(64, 0));
        return false;
      }
      
      // (Over-)estimate the required number of bits.
      /*uint*/int Log2Radix = 0;
      while ((1/*U*/ << Log2Radix) < Radix) {
        Log2Radix++;
      }
      boolean IsPowerOf2Radix = ((1/*U*/ << Log2Radix) == Radix);
      
      /*uint*/int BitWidth = Log2Radix * Str.size();
      if (BitWidth < Result.getBitWidth()) {
        BitWidth = Result.getBitWidth(); // don't shrink the result
      } else if (BitWidth > Result.getBitWidth()) {
        Result.$assign(Result.zext(BitWidth));
      }
      
      RadixAP/*J*/= new APInt(); CharAP/*J*/= new APInt(); // unused unless !IsPowerOf2Radix
      if (!IsPowerOf2Radix) {
        // These must have the same bit-width as Result.
        RadixAP.$assign(new APInt(BitWidth, Radix));
        CharAP.$assign(new APInt(BitWidth, 0));
      }
      
      // Parse all the bytes of the string given this radix.
      Result.$assign(0);
      while (!Str.empty()) {
        /*uint*/int CharVal;
        if (Str.$at(0) >= $$0 && Str.$at(0) <= $$9) {
          CharVal = Str.$at(0) - $$0;
        } else if (Str.$at(0) >= $$a && Str.$at(0) <= $$z) {
          CharVal = Str.$at(0) - $$a + 10;
        } else if (Str.$at(0) >= $$A && Str.$at(0) <= $$Z) {
          CharVal = Str.$at(0) - $$A + 10;
        } else {
          return true;
        }
        
        // If the parsed value is larger than the integer radix, the string is
        // invalid.
        if (CharVal >= Radix) {
          return true;
        }
        
        // Add in this character.
        if (IsPowerOf2Radix) {
          Result.$lshiftassign(Log2Radix);
          Result.$orassign(CharVal);
        } else {
          Result.$starassign(RadixAP);
          CharAP.$assign(CharVal);
          Result.$addassign(CharAP);
        }
        
        Str.$assign$substr(1);
      }
      
      return false;
    } finally {
      if (CharAP != null) { CharAP.$destroy(); }
      if (RadixAP != null) { RadixAP.$destroy(); }
    }
  }

  
  // Convert the given ASCII string to lowercase.
  
  //===----------------------------------------------------------------------===//
  // String Operations
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::lower">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 117,
   FQN = "llvm::StringRef::lower", NM = "_ZNK4llvm9StringRef5lowerEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef5lowerEv")
  //</editor-fold>
  public std.string lower() /*const*/ {
    std.string Result = null;
    try {
      Result/*J*/= new std.string(size()+1, /*char*/(byte)0);
      for (/*size_t*/int i = 0, e = size(); i != e; ++i) {
        Result.$set(i, ascii_tolower(Data.$at(i)));
      }
      return Result;
    } finally {
      if (Result != null) { Result.$destroy(); }
    }
  }

  
  /// Convert the given ASCII string to uppercase.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::upper">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 125,
   FQN = "llvm::StringRef::upper", NM = "_ZNK4llvm9StringRef5upperEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef5upperEv")
  //</editor-fold>
  public std.string upper() /*const*/ {
    std.string Result = null;
    try {
      Result/*J*/= new std.string(size()+1, /*char*/(byte)0);
      for (/*size_t*/int i = 0, e = size(); i != e; ++i) {
        Result.$set(i, ascii_toupper(Data.$at(i)));
      }
      return Result;
    } finally {
      if (Result != null) { Result.$destroy(); }
    }
  }

  
  /// Return a reference to the substring from [Start, Start + N).
  ///
  /// \param Start The index of the starting character in the substring; if
  /// the index is npos or greater than the length of the string then the
  /// empty substring will be returned.
  ///
  /// \param N The number of characters to included in the substring. If N
  /// exceeds the number of characters remaining in the string, the string
  /// suffix (starting with \p Start) will be returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::substr">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 417,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 402,
   FQN = "llvm::StringRef::substr", NM = "_ZNK4llvm9StringRef6substrEjj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef6substrEjj")
  //</editor-fold>
  public StringRef substr(/*size_t*/int Start) /*const*/ {
    return substr(Start, npos);
  }
  public StringRef substr(/*size_t*/int Start, /*size_t*/int N/*= npos*/) /*const*/ {
    Start = min(Start, Length);
    return new StringRef(Start == 0L ? Data : Data.$add(Start), std.min_uint(N, Length - Start));
  }
  public final StringRef $assign$substr(/*size_t*/int NewStart) /*const*/ {
    return $assign$substr(NewStart, Length-NewStart);
  }
  public StringRef $assign$substr(/*size_t*/int NewStart, /*size_t*/int NewLen/*= npos*/) /*const*/ {
    assert !builtInConst(this);
    assert NewStart <= Length : NewStart + "<=" + Length;
    assert this.Data != null;
    assert !NativePointer.builtInConst(this.Data);
    this.Data = Native.$toConst($tryClone(this.Data).$inc(NewStart));
    assert NewLen == npos || (NewStart + NewLen <= Length) : NewStart + " + " + NewLen + "<=" + Length;
    this.Length = min(NewLen, Length - NewStart);
    return this;
  }
  
  
  /// Return a StringRef equal to 'this' but with the first \p N elements
  /// dropped.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::drop_front">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 425,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 409,
   FQN = "llvm::StringRef::drop_front", NM = "_ZNK4llvm9StringRef10drop_frontEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef10drop_frontEj")
  //</editor-fold>
  public StringRef drop_front() /*const*/ {
    return drop_front(1);
  }
  public StringRef drop_front(/*size_t*/int N/*= 1*/) /*const*/ {
    assert (size() >= N) : "Dropping more elements than exist";
    return substr(N);
  }

  
  /// Return a StringRef equal to 'this' but with the last \p N elements
  /// dropped.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::drop_back">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 433,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 416,
   FQN = "llvm::StringRef::drop_back", NM = "_ZNK4llvm9StringRef9drop_backEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef9drop_backEj")
  //</editor-fold>
  public StringRef drop_back() /*const*/ {
    return drop_back(1);
  }
  public StringRef drop_back(/*size_t*/int N/*= 1*/) /*const*/ {
    assert (size() >= N) : "Dropping more elements than exist";
    return substr(0, size() - N);
  }
  public final StringRef $assign$drop_back() /*const*/ {
    return $assign$drop_back(1);
  }
  public final StringRef $assign$drop_back(/*size_t*/int N/*= 1*/) /*const*/ {
    assert (size() >= N) : "Dropping more elements than exist";
    return $assign$substr(0, size() - N);
  }

  
  /// Return a reference to the substring from [Start, End).
  ///
  /// \param Start The index of the starting character in the substring; if
  /// the index is npos or greater than the length of the string then the
  /// empty substring will be returned.
  ///
  /// \param End The index following the last character to include in the
  /// substring. If this is npos, or less than \p Start, or exceeds the
  /// number of characters remaining in the string, the string suffix
  /// (starting with \p Start) will be returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::slice">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 449,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 431,
   FQN = "llvm::StringRef::slice", NM = "_ZNK4llvm9StringRef5sliceEjj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef5sliceEjj")
  //</editor-fold>
  public StringRef slice(/*size_t*/int Start, /*size_t*/int End) /*const*/ {
    Start = std.min_uint(Start, Length);
    End = std.min_uint(max(Start, End), Length);
    return new StringRef(Start == 0L ? Data : Data.$add(Start), End - Start);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::split">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 466,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 447,
   FQN = "llvm::StringRef::split", NM = "_ZNK4llvm9StringRef5splitEc",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef5splitEc")
  //</editor-fold>
  public std.pairTypeType<StringRef, StringRef> split(/*char*/byte Separator) /*const*/ {
    /*size_t*/int Idx = find(Separator);
    if (Idx == npos) {
      return std.make_pair(new StringRef(this), new StringRef());
    }
    return std.make_pair(slice(0, Idx), slice(Idx + 1, npos));
  }
  
  public std.pairTypeType<StringRef, StringRef> split(/*char*/char Separator) /*const*/ {
    return split($(Separator));
  }

  public std.pairTypeType<StringRef, StringRef> split(/*char**/String Separator) /*const*/ {
    // TODO: optimize?
    return (Separator.length() == 1) ? split(Separator.charAt(0)) : split(new StringRef(Separator));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::split">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 483,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 464,
   FQN = "llvm::StringRef::split", NM = "_ZNK4llvm9StringRef5splitES0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef5splitES0_")
  //</editor-fold>
  public std.pairTypeType<StringRef, StringRef> split(StringRef Separator) /*const*/ {
    /*size_t*/int Idx = find(Separator);
    if (Idx == npos) {
      return std.make_pair(new StringRef(this), new StringRef());
    }
    return std.make_pair(slice(0, Idx), slice(Idx + Separator.size(), npos));
  }

  
  /// Split into substrings around the occurrences of a separator string.
  ///
  /// Each substring is stored in \p A. If \p MaxSplit is >= 0, at most
  /// \p MaxSplit splits are done and consequently <= \p MaxSplit
  /// elements are added to A.
  /// If \p KeepEmpty is false, empty strings are not added to \p A. They
  /// still count when considering \p MaxSplit
  /// An useful invariant is that
  /// Separator.join(A) == *this if MaxSplit == -1 and KeepEmpty == true
  ///
  /// \param A - Where to put the substrings.
  /// \param Separator - The string to split on.
  /// \param MaxSplit - The maximum number of times the string is split.
  /// \param KeepEmpty - True if empty substring should be added.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::split">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 283,
   old_source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", old_line = 276,
   FQN = "llvm::StringRef::split", NM = "_ZNK4llvm9StringRef5splitERNS_15SmallVectorImplIS0_EES0_ib",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef5splitERNS_15SmallVectorImplIS0_EES0_ib")
  //</editor-fold>
  public void split(SmallVectorImpl<StringRef> /*&*/ A, StringRef Separators) /*const*/ {
    split(A, Separators, -1, true);
  }
  public void split(SmallVectorImpl<StringRef> /*&*/ A, StringRef Separators, int MaxSplit/*= -1*/) /*const*/ {
    split(A, Separators, MaxSplit, true);
  }
  public void split(SmallVectorImpl<StringRef> /*&*/ A, StringRef Separators, int MaxSplit/*= -1*/, boolean KeepEmpty/*= true*/) /*const*/ {
    StringRef rest = new StringRef(this);
    
    // rest.data() is used to distinguish cases like "a," that splits into
    // "a" + "" and "a" that splits into "a" + 0.
    for (int splits = 0; rest.data() != null && (MaxSplit < 0 || splits < MaxSplit); ++splits) {
      std.pair<StringRef, StringRef> p = rest.split(Separators);
      if (KeepEmpty || p.first.size() != 0) {
        A.push_back(p.first);
      }
      rest.$assign(p.second);
    }
    // If we have a tail left, add it.
    if (rest.data() != null && (rest.size() != 0 || KeepEmpty)) {
      A.push_back(rest);
    }
  }
  public void split(SmallVectorImpl<StringRef> /*&*/ A, /*char*/byte Separator) /*const*/ {
    split(A, Separator, -1, true);
  }
  public void split(SmallVectorImpl<StringRef> /*&*/ A, /*char*/byte Separator, int MaxSplit/*= -1*/) /*const*/ {
    split(A, Separator, MaxSplit, true);
  }
  public void split(SmallVectorImpl<StringRef> /*&*/ A, /*char*/byte Separator, int MaxSplit/*= -1*/, boolean KeepEmpty/*= true*/) /*const*/ {
    split(A, new StringRef(new byte[]{Separator,0}), MaxSplit);
  }
  public void split(SmallVectorImpl<StringRef> /*&*/ A, String Separators) /*const*/ {
    split(A, Separators, -1, true);
  }
  public void split(SmallVectorImpl<StringRef> /*&*/ A, String Separators, int MaxSplit/*= -1*/) /*const*/ {
    split(A, Separators, MaxSplit, true);
  }
  public void split(SmallVectorImpl<StringRef> /*&*/ A, String Separators, int MaxSplit/*= -1*/, boolean KeepEmpty/*= true*/) /*const*/ {
    split(A, new StringRef(Separators), MaxSplit);
  }
  
  public void split(SmallVectorImpl<StringRef> /*&*/ A, byte[] Separators) /*const*/ {
    split(A, new StringRef(Separators));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::rsplit">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 535,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 499,
   FQN = "llvm::StringRef::rsplit", NM = "_ZNK4llvm9StringRef6rsplitEc",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef6rsplitEc")
  //</editor-fold>
  public std.pairTypeType<StringRef, StringRef> rsplit(/*char*/byte Separator) /*const*/ {
    /*size_t*/int Idx = rfind(Separator);
    if (Idx == npos) {
      return std.make_pair(new StringRef(this), new StringRef());
    }
    return std.make_pair(slice(0, Idx), slice(Idx + 1, npos));
  }

  
  /// Return string with consecutive characters in \p Chars starting from
  /// the left removed.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::ltrim">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 544,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 508,
   FQN = "llvm::StringRef::ltrim", NM = "_ZNK4llvm9StringRef5ltrimES0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef5ltrimES0_")
  //</editor-fold>
  public StringRef ltrim() /*const*/ {
    return ltrim(STRING_REF_DELIMETERS);
  }
  public StringRef ltrim(StringRef Chars/*= " \t\n\013\014\015"*/) /*const*/ {
    return drop_front(std.min_uint(Length, find_first_not_of(Chars)));
  }
  public StringRef ltrim(/*char*/byte delim) /*const*/ {
    return drop_front(std.min_uint(Length, find_first_not_of(delim)));
  }

  
  /// Return string with consecutive characters in \p Chars starting from
  /// the right removed.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::rtrim">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 550,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 514,
   FQN = "llvm::StringRef::rtrim", NM = "_ZNK4llvm9StringRef5rtrimES0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef5rtrimES0_")
  //</editor-fold>
  public StringRef rtrim() /*const*/ {
    return rtrim(STRING_REF_DELIMETERS);
  }
  public StringRef rtrim(StringRef Chars/*= " \t\n\013\014\015"*/) /*const*/ {
    return drop_back(Length - std.min_uint(Length, find_last_not_of(Chars) + 1));
  }
  public StringRef rtrim(String Chars) /*const*/ {
    return drop_back(Length - std.min_uint(Length, find_last_not_of(Chars) + 1));
  }
  

  /// Return string with consecutive characters in \p Chars starting from
  /// the left and right removed.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::trim">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 556,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 520,
   FQN = "llvm::StringRef::trim", NM = "_ZNK4llvm9StringRef4trimES0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZNK4llvm9StringRef4trimES0_")
  //</editor-fold>
  public StringRef trim() /*const*/ {
    return trim(STRING_REF_DELIMETERS);
  }
  public StringRef trim(StringRef Chars/*= " \t\n\013\014\015"*/) /*const*/ {
    return ltrim(Chars).rtrim(Chars);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::StringRef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*constness*/, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 41,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 40,
   FQN = "llvm::StringRef::StringRef", NM = "_ZN4llvm9StringRefC1ERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm9StringRefC1ERKS0_")
  //</editor-fold>
  public /*inline*/ StringRef(/*const*/StringRef /*&*/ $Prm0)/* throw()*/ {
    /* : Data(.Data), Length(.Length)*/ 
    //START JInit
    assert Native.$assertConstPtr($Prm0.Data);
    this.Data = /*PERF: do not clone*/$Prm0.Data;
    this.Length = $Prm0.Length;
    //END JInit
    trackCopiedInstance();
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::StringRef">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 41,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 40,
   FQN = "llvm::StringRef::StringRef", NM = "_ZN4llvm9StringRefC1EOS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm9StringRefC1EOS0_")
  //</editor-fold>
  public /*inline*/ StringRef(JD$Move _dparam, StringRef /*&&*/$Prm0) {
    /* : Data(static_cast<StringRef &&>().Data), Length(static_cast<StringRef &&>().Length)*/ 
    //START JInit
    assert Native.$assertConstPtr($Prm0.Data);
    this.Data = /*PERF: do not clone*/$Prm0.Data;
    this.Length = $Prm0.Length;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*constness*/, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 41,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 40,
   FQN = "llvm::StringRef::operator=", NM = "_ZN4llvm9StringRefaSEOS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm9StringRefaSEOS0_")
  //</editor-fold>
  @Override public /*inline*/ StringRef /*&*/ $assign(/*const*/StringRef /*&*/ $Prm0)/* throw()*/ {
    assert !builtInConst(this) : "can not modify const " + this + " into " + $Prm0 + "; probably constant was used incorrectly in outer call";
    assert Native.$assertConstPtr($Prm0.Data);
    this.Data = /*PERF: do not clone*/$Prm0.Data;
    this.Length = $Prm0.Length;
    return /*Deref*/this;
  }
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::operator=">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 41,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 40,
   FQN = "llvm::StringRef::operator=", NM = "_ZN4llvm9StringRefaSEOS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm9StringRefaSEOS0_")
  //</editor-fold>
  public /*inline*/ StringRef /*&*/ $assign(/*const*/String /*&*/ $Prm0)/* throw()*/ {
    assert !builtInConst(this) : "can not modify const " + this + " into " + $Prm0 + "; probably constant was used incorrectly in outer call";
    this.Data = $toConst(create_char$ptr($Prm0));
    this.Length = $Prm0.length();
    return /*Deref*/this;
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 41,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 40,
   FQN = "llvm::StringRef::operator=", NM = "_ZN4llvm9StringRefaSEOS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm9StringRefaSEOS0_")
  //</editor-fold>
  public final /*inline*/ StringRef /*&*/ $assignMove(StringRef /*&&*/$Prm0) {
    return $assign($Prm0);
  }
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::operator=">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 41,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 40,
   FQN = "llvm::StringRef::operator=", NM = "_ZN4llvm9StringRefaSEOS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm9StringRefaSEOS0_")
  //</editor-fold>
  public final/*inline*/ StringRef /*&*/ $assignMove(String /*&&*/$Prm0) {
    return $assign($Prm0);
  }
  //<editor-fold defaultstate="collapsed" desc="llvm::StringRef::operator=">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 41,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 40,
   FQN = "llvm::StringRef::operator=", NM = "_ZN4llvm9StringRefaSEOS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm9StringRefaSEOS0_")
  //</editor-fold>
  public final/*inline*/ StringRef /*&*/ $assignMove(/*const*/char$ptr /*&&*/$Prm0) {
    return $assign($Prm0);
  }

  public /*inline*/ final StringRef /*&*/ $assign(/*const*/char$ptr /*&*/ Str)/* throw()*/ {
    assert ((Str != null)) : "StringRef cannot be built from a NULL argument";
    return $assign(Str, strlen(Str));
  }

  public /*inline*/ final StringRef /*&*/ $assign(/*const*/SmallVectorImplChar /*&*/ Str)/* throw()*/ {
    if (true) return $assign(Str.data(), Str.size());
    assert ((Str != null)) : "StringRef cannot be built from a NULL argument";
    assert !builtInConst(this) : "can not modify const " + this + " into " + Str + "; probably constant was used incorrectly in outer call";
    assert this.Data != null : "This is for reusables only! Forgot to initialize like new StringRef(create_char$null$ptr()) or called $destroy?";
    assert this.Data instanceof char$ptr$array : "This is for reusables only! Forgot to initialize like new StringRef(create_char$null$ptr()) " + this.Data;
    assert (this.Data.getClass() == Str.data().getClass()) : "This is for reusables only! " + this.Data + " but expected array ";
    // we don't want extra char$ptr to be created from Str.data(); assign directly
    assert this.Data.$index() == 0 : "must point to the beginning " + Data.$index();
    byte[] $array = Str.$array();
    if (this.Data.$array() != $array) {
      // reassign
      Native.$setArrayAndIndex((char$ptr$array)this.Data, $array, 0);
    }
    this.Length = Str.size();
    return /*Deref*/this;
  }

  public /*inline*/ StringRef /*&*/ $assign(/*const*/char$ptr /*&*/ Str, int Length)/* throw()*/ {
    assert !builtInConst(this) : "can not modify const " + this + " into " + Str + "; probably constant was used incorrectly in outer call";
    this.Data = $toConst(Str);
    assert ((Str != null)) : "StringRef cannot be built from a NULL argument";
    this.Length = Length; // invoking strlen(NULL) is undefined behavior    
    return /*Deref*/this;
  }

  public boolean $equals(String other) {
    if (Length != other.length()) {
      return false;
    }
    for (int i = 0; i < Length; i++) {
      if (other.charAt(i) != (char)Data.$at(i)) {
        return false;
      }
    }
    return true;
  }  

  public String toJavaString() {
    return Casts.toJavaString(Data, Length);
  }

  public void toStringBuilder(StringBuilder out) {
    Casts.toStringBuilder(out, Data, Length);
  }

  @Override
  public String toString() {
    return "StringRef{" + toJavaString() + "}";
  }    

  @Override
  public Boolean $op(Op k, Object obj) {
    if (obj instanceof StringRef) {
      if (Op.EQ == k) {
        return this.$eq((StringRef)obj);
      }
    } else if (obj instanceof std.string) {
      if (Op.EQ == k) {
        return str().$eq((std.string)obj);
      }
    } else if (obj instanceof String) {
      if (Op.EQ == k) {
        return this.$equals((String)obj);
      }
    }
    return null;
  }

  @Override
  public int hashCode() {
    throw new UnsupportedOperationException("StringRef can not be used as key in maps");
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final StringRef other = (StringRef) obj;
    return $eq(other);
  }

  @Override
  public final StringRef clone() {
    return new StringRef(this);
  }

  @Override
  public boolean $noteq(StringRef other) {
    return !$eq(other);
  }

  @Override
  public boolean $eq(StringRef other) {
    return $eq_StringRef(this, other);
  }
  
  public void $release() {
    this.Data = null;
    this.Length = 0;
  }
  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long emptyInstances = 0;
  private static long copiedInstances = 0;
  private static long charSeqInstances = 0;
  private static long otherInstances = 0;
  private static long bytesInstances = 0;
  private static void trackCopiedInstance() {
    if (NativeTrace.STATISTICS) copiedInstances++;
  }
  private static void trackCharSeqInstance() {
    if (NativeTrace.STATISTICS) charSeqInstances++;
  }
  private static void trackOtherInstance() {
    if (NativeTrace.STATISTICS) otherInstances++;
  }
  private static void trackEmptyInstance() {
    if (NativeTrace.STATISTICS) emptyInstances++;
  }
  private static void trackBytesInstance() {
    if (NativeTrace.STATISTICS) bytesInstances++;
  }
  
  public static void clearStatistics() {
    copiedInstances = 0;
    charSeqInstances = 0;
    otherInstances = 0;
    emptyInstances = 0;
    bytesInstances = 0;
  }

  public static long PrintStats(raw_ostream out) {
    long Value = bytesInstances+emptyInstances+copiedInstances+charSeqInstances+otherInstances;
    out.$out(String.format("%22s created:\t", StringRef.class.getSimpleName()+" Total")).$out(NativeTrace.formatNumber(Value)).$out(".\n");
    out.$out(String.format("%22s created:\t", StringRef.class.getSimpleName()+" empty")).$out(NativeTrace.formatNumber(emptyInstances)).$out(".\n");
    out.$out(String.format("%22s created:\t", StringRef.class.getSimpleName()+" copies")).$out(NativeTrace.formatNumber(copiedInstances)).$out(".\n");
    out.$out(String.format("%22s created:\t", StringRef.class.getSimpleName()+" char seq")).$out(NativeTrace.formatNumber(charSeqInstances)).$out(".\n");
    out.$out(String.format("%22s created:\t", StringRef.class.getSimpleName()+" byte seq")).$out(NativeTrace.formatNumber(bytesInstances)).$out(".\n");
    out.$out(String.format("%22s created:\t", StringRef.class.getSimpleName()+" others")).$out(NativeTrace.formatNumber(otherInstances)).$out(".\n");
    NativeTrace.dumpStatisticValue(StringRef.class.getSimpleName(), Value);
    return Value;
  }   
  
  private static final ThreadLocal<int[]> $BadCharSkipArrays = new ThreadLocal<int[]>() {
    @Override
    protected int[] initialValue() {
      return new$int(256);
    }
    
  };
  
  private static int[] $BadCharSkip() {
    return $BadCharSkipArrays.get();
  }
  
  private static final boolean CHECK_STRING_REF = Boolean.getBoolean("clank.check.string.ref");
  private static void checkStringRef(StringRef check) {
    if (CHECK_STRING_REF) {
      if (check.Data instanceof char$ptr$CharSequence) {
        Exception exception = new Exception("use String-based method instead for " + check);
        for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
          String methodName = stackTraceElement.getMethodName(); 
          String className = stackTraceElement.getClassName();
          if (methodName.equals("<clinit>") && className.equals("org.llvm.adt.StringRef")) {
            // skip asserts from static initializer
            return;
          } else if (className.equals("org.clang.basic.FileManager")/* && methodName.equals("getFile")*/) {
            // skip asserts from FileManager.getFile
            return;
          } else if (className.equals("org.clang.basic.target.TargetInfo") && methodName.equals("CreateTargetInfo")) {
            // skip asserts from TargetInfo.CreateTargetInfo
            return;
          } else if (className.equals("org.llvm.support.MemoryBuffer") && methodName.equals("$getMemBufferName")) {
            // skip asserts from org.llvm.support.MemoryBuffer.$getMemBufferName
            return;
          }
        }
        exception.printStackTrace(System.out);
        System.exit(1);
      }
    }
  }

  @Override
  public final boolean $less(Object obj) {
    return llvm.$less_StringRef(this, (StringRef)obj);
  }

  @Override
  public final boolean $lesseq(Object obj) {
    return llvm.$lesseq_StringRef(this, (StringRef)obj);
  }

  public int find_last_of(char$ptr Blanks, int max) {
    return find_last_of(new StringRef(Blanks), max);
  }

  public int find_first_of(char$ptr Blanks, int max) {
    return find_first_of(new StringRef(Blanks), max);
  }

  public StringRef rtrim(char$ptr Blanks) {
    return rtrim(new StringRef(Blanks));
  }

  public StringRef ltrim(char$ptr Blanks) {
    return ltrim(new StringRef(Blanks));
  }

  public StringRef rtrim(byte $$SPACE) {
    return rtrim(create_char$ptr(new byte[]{$$SPACE,0}));
  }

  public void swap(NativeSwappable $Prm0) {
    assert !builtInConst(this) : "can not modify const " + this + "; probably constant was used incorrectly in outer call";
    StringRef RHS = (StringRef) $Prm0;
    assert !builtInConst(RHS) && !(RHS instanceof ConstStringRef): "can not modify const " + RHS + "; probably constant was used incorrectly in outer call";
    int Tmp = this.Length;
    this.Length = RHS.Length;
    RHS.Length = Tmp;    
    char$ptr TmpData = this.Data;
    this.Data = RHS.Data;
    RHS.Data = TmpData;
  }

  @Override
  public StringRef move() {
    return new StringRef(JD$Move.INSTANCE, this);
  }

  @Override
  public Iterator<Byte> iterator() {
    return new JavaIteratorChar(begin(), end());
  }

  private static final class ConstStringRef extends StringRef {
    private ConstStringRef() {
      super();
    }
    
    public ConstStringRef(char$ptr Str) {
      super(Str);
    }

    public ConstStringRef(ConstStringRef $Prm0) {
      super($Prm0);
    }

    // It's OK to create modifyable copy of const-StringRef
//    @Override
//    public ConstStringRef clone() {
//      throw new UnsupportedOperationException("Must not clone constant StringRef, use real one");
//    }

    @Override
    public StringRef move() {
      throw new UnsupportedOperationException("Attempt to move constant StringRef");
    }

    @Override
    public StringRef $assign(StringRef $Prm0) {
      throw new UnsupportedOperationException("Attempt to modify constant StringRef");
    }

    @Override
    public StringRef $assign(String $Prm0) {
      throw new UnsupportedOperationException("Attempt to modify constant StringRef");
    }

    @Override
    public StringRef $assign(char$ptr Str, int Length) {
      throw new UnsupportedOperationException("Attempt to modify constant StringRef");
    }

    @Override
    public StringRef $assign$substr(int NewStart, int NewLen) {
      throw new UnsupportedOperationException("Attempt to modify constant StringRef");
    }
    
    @Override
    public void $release() {
      throw new UnsupportedOperationException("Attempt to modify constant StringRef");
    }

    @Override
    public void swap(NativeSwappable $Prm0) {
      throw new UnsupportedOperationException("Attempt to modify constant StringRef");
    }
  }
}
