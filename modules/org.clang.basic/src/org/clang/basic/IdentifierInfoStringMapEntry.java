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

package org.clang.basic;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import org.clank.support.NativeMemory.BumpAllocator;
import org.llvm.support.*;
import org.llvm.adt.*;

/*template <typename IdentifierInfo> TEMPLATE*/

/// StringMapEntryIdentifierInfo - This is used to represent one value that is inserted into
/// a StringMap.  It contains the Value itself and the key: the string length
/// and data.
//<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 117,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo")
//</editor-fold>
public class IdentifierInfoStringMapEntry  extends /*public*/ StringMapEntryBaseCharArray 
  implements Destructors.ClassWithDestructor, NativeType.SizeofCapable {
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo::StringMapEntryIdentifierInfo">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 119,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo::StringMapEntryIdentifierInfo")
  //</editor-fold>
  protected IdentifierInfoStringMapEntry(IdentifierInfoStringMapEntry /*&*/ E) {
    super(E);
//    this.second = E.second;
  }

/*public:*/
//  public IdentifierInfo second;
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo::StringMapEntryIdentifierInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 123,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo::StringMapEntryIdentifierInfo")
  //</editor-fold>
  public /*explicit*/ IdentifierInfoStringMapEntry(/*uint*/int strLen) {
    /* : StringMapEntryIdentifierInfoBase(strLen), second()*/ 
    //START JInit
    super(strLen);
//    this.second = null/*new IdentifierInfo()*/;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo::StringMapEntryIdentifierInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 123,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo::StringMapEntryIdentifierInfo")
  //</editor-fold>
  public /*explicit*/ IdentifierInfoStringMapEntry(char$ptr Str, /*uint*/int strLen) {
    /* : StringMapEntryIdentifierInfoBase(strLen), second()*/ 
    //START JInit
    super(Str, strLen);
//    this.second = null/*new IdentifierInfo()*/;
    //END JInit
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo::StringMapEntryIdentifierInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 123,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo::StringMapEntryIdentifierInfo")
  //</editor-fold>
  public /*explicit*/ IdentifierInfoStringMapEntry(byte Str[], int fromIdx, /*uint*/int strLen, int FullHashValue) {
    /* : StringMapEntryIdentifierInfoBase(strLen), second()*/ 
    //START JInit
    super(Str, fromIdx, strLen, FullHashValue);
//    this.second = null/*new IdentifierInfo()*/;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo::StringMapEntryIdentifierInfo">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 125,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo::StringMapEntryIdentifierInfo")
  //</editor-fold>
  public IdentifierInfoStringMapEntry(/*uint*/int strLen, /*const*/IdentifierInfo /*&*/ V) {
    /* : StringMapEntryIdentifierInfoBase(strLen), second(V)*/ 
    //START JInit
    super(strLen);
//    this.second = V;
    assert V == this : "instead of extra field 'second' we encapsulate all in derived object itself";
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo::getKey">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 128,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo::getKey")
  //</editor-fold>
  public StringRef getKey() /*const*/ {
    return new StringRef(getKeyData(), getKeyLength());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntry::getValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 137,
   FQN="llvm::StringMapEntry::getValue", NM="_ZNK4llvm14StringMapEntry8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZNK4llvm14StringMapEntry8getValueEv")
  //</editor-fold>
  public /*const*/ IdentifierInfo /*&*/ getValue$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntry::getValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 138,
   FQN="llvm::StringMapEntry::getValue", NM="_ZN4llvm14StringMapEntry8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm14StringMapEntry8getValueEv")
  //</editor-fold>
  public IdentifierInfo /*&*/ getValue() {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo::setValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 135,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo::setValue")
  //</editor-fold>
  public void setValue(/*const*/IdentifierInfo /*&*/ V) {
    throw new UnsupportedOperationException();
  }

  
  /// getKeyData - Return the start of the string data that is the key for this
  /// value.  The string data is always stored immediately after the
  /// StringMapEntryIdentifierInfo object.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo::getKeyData">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 140,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo::getKeyData")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getKeyData() /*const*/ {
    return getKeyStr()/*reinterpret_cast(char$ptr.class, this + 1)*/;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo::first">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 142,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo::first")
  //</editor-fold>
  public StringRef first() /*const*/ {
    return new StringRef(getKeyData(), getKeyLength());
  }

  
  /// Create - Create a StringMapEntryIdentifierInfo for the specified key and default
  /// construct the value.
  /*template <typename AllocatorTy, typename InitType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo::Create">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 147,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo::Create")
  //</editor-fold>
  public static <AllocatorTy extends NativeMemory.Allocator, InitType> IdentifierInfo /*P*/ Create(/*const*/char$ptr/*char P*/ KeyStart, int KeyLength, int FullHashValue, AllocatorTy /*&*/ Allocator, IdentifierInfo InitVal) {
//    /*uint*/int KeyLength = (/*static_cast*//*uint*/int)(KeyEnd.$sub(KeyStart));    
    // Okay, the item doesn't already exist, and 'Bucket' is the bucket to fill
    // in.  Allocate a new item with space for the string at the end and a null
    // terminator.
//    /*uint*/int AllocSize = (/*static_cast*//*uint*/int)(sizeof(StringMapEntryIdentifierInfo)) + KeyLength + 1;
//    /*uint*/int Alignment = alignOf<StringMapEntryIdentifierInfo >();    
//    StringMapEntryIdentifierInfo /*P*/ NewItem = (/*static_cast*/StringMapEntryIdentifierInfo /*P*/ )(Allocator.Allocate(AllocSize, Alignment));
    // Copy the string information.
    int StrBufferIndex = ((BumpAllocator)Allocator).AllocateAndGetIndex(KeyLength + 1, 1);
    byte[] StrBuffer = ((BumpAllocator)Allocator).GetLastAllocationStorage();
    memcpy(StrBuffer, StrBufferIndex, KeyStart, 0, KeyLength);
    StrBuffer[StrBufferIndex + KeyLength] = (byte)0; // Null terminate for convenience of clients.
//    StrBuffer = $toConst(StrBuffer);    
    IdentifierInfo NewItem = new IdentifierInfo(StrBuffer, StrBufferIndex, KeyLength, FullHashValue);
    assert StrBuffer == NewItem.getKeyData().$array();
    assert StrBufferIndex == NewItem.getKeyData().$index();

    // Default construct the value.
//    new (NewItem) StringMapEntryIdentifierInfo(( KeyLength ));
    
    // Initialize the value if the client wants to.
    // REM(/*Deref*/NewItem, InitVal);
    return NewItem;
  }
  public static <AllocatorTy extends NativeMemory.Allocator, InitType> IdentifierInfo /*P*/ Create(/*const*/byte[]/*char P*/ KeyArray, int KeyStartIndex, int KeyLength, int FullHashValue, AllocatorTy /*&*/ Allocator, IdentifierInfo InitVal) {
//    /*uint*/int KeyLength = (/*static_cast*//*uint*/int)(KeyEnd.$sub(KeyStart));    
    // Okay, the item doesn't already exist, and 'Bucket' is the bucket to fill
    // in.  Allocate a new item with space for the string at the end and a null
    // terminator.
//    /*uint*/int AllocSize = (/*static_cast*//*uint*/int)(sizeof(StringMapEntryIdentifierInfo)) + KeyLength + 1;
//    /*uint*/int Alignment = alignOf<StringMapEntryIdentifierInfo >();    
//    StringMapEntryIdentifierInfo /*P*/ NewItem = (/*static_cast*/StringMapEntryIdentifierInfo /*P*/ )(Allocator.Allocate(AllocSize, Alignment));
    // Copy the string information.
    int StrBufferIndex = ((BumpAllocator)Allocator).AllocateAndGetIndex(KeyLength + 1, 1);
    byte[] StrBuffer = ((BumpAllocator)Allocator).GetLastAllocationStorage();
    memcpy(StrBuffer, StrBufferIndex, KeyArray, KeyStartIndex, KeyLength);
    StrBuffer[StrBufferIndex + KeyLength] = (byte)0; // Null terminate for convenience of clients.
//    StrBuffer = $toConst(StrBuffer);    
    IdentifierInfo NewItem = new IdentifierInfo(StrBuffer, StrBufferIndex, KeyLength, FullHashValue);
    assert StrBuffer == NewItem.getKeyData().$array();
    assert StrBufferIndex == NewItem.getKeyData().$index();

    // Default construct the value.
//    new (NewItem) StringMapEntryIdentifierInfo(( KeyLength ));
    
    // Initialize the value if the client wants to.
    // REM(/*Deref*/NewItem, InitVal);
    return NewItem;
  }

//  /*template <typename AllocatorTy> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo::Create">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 177,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo::Create")
//  //</editor-fold>
//  public static </*typename*/ AllocatorTy> StringMapEntryIdentifierInfo /*P*/ Create(/*const*/char$ptr/*char P*/ KeyStart, /*const*/char$ptr/*char P*/ KeyEnd, AllocatorTy /*&*/ Allocator) {
//    return Create(KeyStart, KeyEnd, Allocator, 0);
//  }

  
  /// Create - Create a StringMapEntryIdentifierInfo with normal malloc/free.
  /*template <typename InitType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo::Create">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 184,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo::Create")
  //</editor-fold>
  public static  IdentifierInfo /*P*/ Create(/*const*/char$ptr/*char P*/ KeyStart, int KeyLength, int FullHashValue, IdentifierInfo InitVal) {
    NativeMemory.Allocator A/*J*/= new StringMapBumpPtrAllocator();
    return Create(KeyStart, KeyLength, FullHashValue, A, InitVal);
  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo::Create">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 190,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo::Create")
//  //</editor-fold>
//  public static StringMapEntryIdentifierInfo /*P*/ Create(/*const*/char$ptr/*char P*/ KeyStart, /*const*/char$ptr/*char P*/ KeyEnd) {
//    return Create(KeyStart, KeyEnd, IdentifierInfo());
//  }

  
  /// GetStringMapEntryIdentifierInfoFromValue - Given a value that is known to be embedded
  /// into a StringMapEntryIdentifierInfo, return the StringMapEntryIdentifierInfo itself.
//  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo::GetStringMapEntryIdentifierInfoFromValue">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 196,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo::GetStringMapEntryIdentifierInfoFromValue")
//  //</editor-fold>
//  public static <IdentifierInfo> StringMapEntryIdentifierInfo /*&*/ GetStringMapEntryIdentifierInfoFromValue(IdentifierInfo /*&*/ V) {
//    StringMapEntryIdentifierInfo /*P*/ EPtr = 0;
//    char$ptr/*char P*/ Ptr = reinterpret_cast(char$ptr/*char P*/ .class, /*AddrOf*/V).$sub((reinterpret_cast(char$ptr/*char P*/ .class, /*AddrOf*/EPtr.second).$sub(reinterpret_cast(char$ptr/*char P*/ .class, EPtr))));
//    return /*Deref*/reinterpret_cast(StringMapEntryIdentifierInfo /*P*/ .class, Ptr);
//  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo::GetStringMapEntryIdentifierInfoFromValue">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 203,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo::GetStringMapEntryIdentifierInfoFromValue")
//  //</editor-fold>
//  public static /*const*/StringMapEntryIdentifierInfo /*&*/ GetStringMapEntryIdentifierInfoFromValue(/*const*/IdentifierInfo /*&*/ V) {
//    return GetStringMapEntryIdentifierInfoFromValue((/*const_cast*/IdentifierInfo /*&*/ )(V));
//  }

  
//  /// GetStringMapEntryIdentifierInfoFromKeyData - Given key data that is known to be embedded
//  /// into a StringMapEntryIdentifierInfo, return the StringMapEntryIdentifierInfo itself.
//  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo::GetStringMapEntryIdentifierInfoFromKeyData">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 209,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo::GetStringMapEntryIdentifierInfoFromKeyData")
//  //</editor-fold>
//  public static StringMapEntryIdentifierInfo /*&*/ GetStringMapEntryIdentifierInfoFromKeyData(/*const*/char$ptr/*char P*/ KeyData) {
//    char$ptr/*char P*/ Ptr = (/*const_cast*/char$ptr/*char P*/ )(KeyData).$sub(sizeof(StringMapEntryIdentifierInfo));
//    return /*Deref*/reinterpret_cast(StringMapEntryIdentifierInfo /*P*/ .class, Ptr);
//  }

  
  /// Destroy - Destroy this StringMapEntryIdentifierInfo, releasing memory back to the
  /// specified allocator.
  /*template <typename AllocatorTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo::Destroy">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 217,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo::Destroy")
  //</editor-fold>
  public </*typename*/ AllocatorTy> void Destroy(AllocatorTy /*&*/ Allocator) {
    // Free memory referenced by the item.
    this.$destroy();
//    Allocator.Deallocate(this);
  }

  
  /// Destroy this object, releasing memory back to the malloc allocator.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo::Destroy">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 224,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo::Destroy")
  //</editor-fold>
  public void Destroy() {
    MallocAllocator A = null;
    try {
      A/*J*/= new MallocAllocator();
      Destroy(A);
    } finally {
      if (A != null) { A.$destroy(); }
    }
  }

  @Override
  public void $destroy() {
    // do nothing
  }

  @Override
  public String toString() {
    return "{" + getKey() + "=>" + getValue() + '}';
  }

  @Override
  public int $sizeof() {
    return $sizeof_StringMapEntryIdentifierInfo();
  }
  
  public IdentifierInfo/*P*/ $second() {
    return getValue();
  }
  
  public static /*size_t*/int $sizeof_StringMapEntryIdentifierInfo() {
    return NativeType.BYTES_IN_JAVA_OBJECT_HEADER +
       NativeType.sizeof$ptr() +
       (StringMapEntryBase.$sizeof_StringMapEntryBase_Fields());
  }
}
