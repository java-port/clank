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

package org.llvm.bitcode;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.bitcode.java.BitcodeJavaDifferentiators.*;
import org.llvm.support.llvm.support.endian;
import org.llvm.support.llvm.support.endianness;


/// This represents a position within a bitstream. There may be multiple
/// independent cursors reading within one bitstream, each maintaining their
/// own local state.
//<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 135,
 FQN="llvm::SimpleBitstreamCursor", NM="_ZN4llvm21SimpleBitstreamCursorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursorE")
//</editor-fold>
public class SimpleBitstreamCursor {
  private BitstreamReader /*P*/ R/* = null*/;
  private /*size_t*/int NextChar/* = 0*/;
  
  // The size of the bicode. 0 if we don't know it yet.
  private /*size_t*/int Size/* = 0*/;

  /// This is the current data we have pulled from the stream but have not
  /// returned to the client. This is specifically and intentionally defined to
  /// follow the word size of the host machine for efficiency. We use word_t in
  /// places that are aware of this to make it perfectly explicit what is going
  /// on.
  /*public:*/
  // JAVA: typedef size_t word_t;
/*private:*/
  private /*size_t*/int CurWord/* = 0*/;
  
  /// This is the number of bits in CurWord that are valid. This is always from
  /// [0...bits_of(size_t)-1] inclusive.
  private /*uint*/int BitsInCurWord/* = 0*/;
/*public:*/
  public static final /*const*//*size_t*/int MaxChunkSize = $sizeof_UInt() * 8;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::SimpleBitstreamCursor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 160,
   FQN="llvm::SimpleBitstreamCursor::SimpleBitstreamCursor", NM="_ZN4llvm21SimpleBitstreamCursorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursorC1Ev")
  //</editor-fold>
  public SimpleBitstreamCursor() {
    // : R(null), NextChar(0), Size(0), CurWord(0), BitsInCurWord(0)/* = default*/ 
    //START JInit
    /*InClass*/this.R = null;
    /*InClass*/this.NextChar = 0;
    /*InClass*/this.Size = 0;
    /*InClass*/this.CurWord = 0;
    /*InClass*/this.BitsInCurWord = 0;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::SimpleBitstreamCursor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 162,
   FQN="llvm::SimpleBitstreamCursor::SimpleBitstreamCursor", NM="_ZN4llvm21SimpleBitstreamCursorC1ERNS_15BitstreamReaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursorC1ERNS_15BitstreamReaderE")
  //</editor-fold>
  public /*explicit*/ SimpleBitstreamCursor(JD$BitstreamReader _dparam, final BitstreamReader /*&*/ R) {
    // : R(&R), NextChar(0), Size(0), CurWord(0), BitsInCurWord(0) 
    //START JInit
    this.R = $AddrOf(R);
    /*InClass*/this.NextChar = 0;
    /*InClass*/this.Size = 0;
    /*InClass*/this.CurWord = 0;
    /*InClass*/this.BitsInCurWord = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::SimpleBitstreamCursor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 163,
   FQN="llvm::SimpleBitstreamCursor::SimpleBitstreamCursor", NM="_ZN4llvm21SimpleBitstreamCursorC1EPNS_15BitstreamReaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursorC1EPNS_15BitstreamReaderE")
  //</editor-fold>
  public /*explicit*/ SimpleBitstreamCursor(JD$BitstreamReader$P _dparam, BitstreamReader /*P*/ R) {
    // : R(R), NextChar(0), Size(0), CurWord(0), BitsInCurWord(0) 
    //START JInit
    this.R = R;
    /*InClass*/this.NextChar = 0;
    /*InClass*/this.Size = 0;
    /*InClass*/this.CurWord = 0;
    /*InClass*/this.BitsInCurWord = 0;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::canSkipToPos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 165,
   FQN="llvm::SimpleBitstreamCursor::canSkipToPos", NM="_ZNK4llvm21SimpleBitstreamCursor12canSkipToPosEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK4llvm21SimpleBitstreamCursor12canSkipToPosEj")
  //</editor-fold>
  public boolean canSkipToPos(/*size_t*/int pos) /*const*/ {
    // pos can be skipped to if it is a valid address or one byte past the end.
    return pos == 0
       || R.getBitcodeBytes().isValidAddress(((/*static_cast*/long/*uint64_t*/)($uint2ulong(pos - 1))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::AtEndOfStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 171,
   FQN="llvm::SimpleBitstreamCursor::AtEndOfStream", NM="_ZN4llvm21SimpleBitstreamCursor13AtEndOfStreamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursor13AtEndOfStreamEv")
  //</editor-fold>
  public boolean AtEndOfStream() {
    if (BitsInCurWord != 0) {
      return false;
    }
    if (Size != 0) {
      return $lesseq_uint(Size, NextChar);
    }
    fillCurWord();
    return BitsInCurWord == 0;
  }

  
  /// Return the bit # of the bit we are reading.
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::GetCurrentBitNo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 181,
   FQN="llvm::SimpleBitstreamCursor::GetCurrentBitNo", NM="_ZNK4llvm21SimpleBitstreamCursor15GetCurrentBitNoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK4llvm21SimpleBitstreamCursor15GetCurrentBitNoEv")
  //</editor-fold>
  public long/*uint64_t*/ GetCurrentBitNo() /*const*/ {
    return $uint2ulong(NextChar * CHAR_BIT - BitsInCurWord);
  }

  
  // Return the byte # of the current bit.
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::getCurrentByteNo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 186,
   FQN="llvm::SimpleBitstreamCursor::getCurrentByteNo", NM="_ZNK4llvm21SimpleBitstreamCursor16getCurrentByteNoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK4llvm21SimpleBitstreamCursor16getCurrentByteNoEv")
  //</editor-fold>
  public long/*uint64_t*/ getCurrentByteNo() /*const*/ {
    return $div_ulong_ullong(GetCurrentBitNo(), $int2ullong(8));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::getBitStreamReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 188,
   FQN="llvm::SimpleBitstreamCursor::getBitStreamReader", NM="_ZN4llvm21SimpleBitstreamCursor18getBitStreamReaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursor18getBitStreamReaderEv")
  //</editor-fold>
  public BitstreamReader /*P*/ getBitStreamReader() {
    return R;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::getBitStreamReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 189,
   FQN="llvm::SimpleBitstreamCursor::getBitStreamReader", NM="_ZNK4llvm21SimpleBitstreamCursor18getBitStreamReaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK4llvm21SimpleBitstreamCursor18getBitStreamReaderEv")
  //</editor-fold>
  public /*const*/ BitstreamReader /*P*/ getBitStreamReader$Const() /*const*/ {
    return R;
  }

  
  /// Reset the stream to the specified bit number.
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::JumpToBit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 192,
   FQN="llvm::SimpleBitstreamCursor::JumpToBit", NM="_ZN4llvm21SimpleBitstreamCursor9JumpToBitEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursor9JumpToBitEy")
  //</editor-fold>
  public void JumpToBit(long/*uint64_t*/ BitNo) {
    /*size_t*/int ByteNo = ((/*size_t*/int)($ullong2uint($div_ulong_ullong(BitNo, $int2ullong(8))))) & ~($sizeof_UInt() - 1);
    /*uint*/int WordBitNo = ((/*uint*/int)($ullong2uint(BitNo & $uint2ullong(($sizeof_UInt() * 8 - 1)))));
    assert (canSkipToPos(ByteNo)) : "Invalid location";
    
    // Move the cursor to the right word.
    NextChar = ByteNo;
    BitsInCurWord = 0;
    
    // Skip over any bits that are already consumed.
    if ((WordBitNo != 0)) {
      Read(WordBitNo);
    }
  }

  
  /// Reset the stream to the bit pointed at by the specified pointer.
  ///
  /// The pointer must be a dereferenceable pointer into the bytes in the
  /// underlying memory object.
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::jumpToPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 210,
   FQN="llvm::SimpleBitstreamCursor::jumpToPointer", NM="_ZN4llvm21SimpleBitstreamCursor13jumpToPointerEPKh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursor13jumpToPointerEPKh")
  //</editor-fold>
  public void jumpToPointer_byte$C$P(/*const*/char$ptr/*uint8_t*//*P*/ Pointer) {
    /*const*/char$ptr/*uchar P*/ Pointer0 = $tryClone(getPointerToByte($int2ulong(0), $int2ulong(1)));
    assert ($less(Pointer0, Pointer) || Pointer0.$eq(Pointer)) : "Expected pointer into bitstream";
    
    JumpToBit($int2ulong(8 * (Pointer.$sub(Pointer0))));
    assert ((Object/*intptr_t*/)getPointerToByte(getCurrentByteNo(), $int2ulong(1)) == (Object/*intptr_t*/)Pointer) : "Expected to reach pointer";
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::jumpToPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 220,
   FQN="llvm::SimpleBitstreamCursor::jumpToPointer", NM="_ZN4llvm21SimpleBitstreamCursor13jumpToPointerEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursor13jumpToPointerEPKc")
  //</editor-fold>
  public void jumpToPointer_char$ptr$C(/*const*/char$ptr/*char P*/ Pointer) {
    jumpToPointer_byte$C$P(Pointer);//reinterpret_cast(/*const*/byte/*uint8_t*//*P*/ .class, Pointer));
  }

  
  /// Get a pointer into the bitstream at the specified byte offset.
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::getPointerToByte">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 225,
   FQN="llvm::SimpleBitstreamCursor::getPointerToByte", NM="_ZN4llvm21SimpleBitstreamCursor16getPointerToByteEyy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursor16getPointerToByteEyy")
  //</editor-fold>
  public /*const*/char$ptr/*uint8_t*//*P*/ getPointerToByte(long/*uint64_t*/ ByteNo, long/*uint64_t*/ NumBytes) {
    return R.getBitcodeBytes().getPointer(ByteNo, NumBytes);
  }

  
  /// Get a pointer into the bitstream at the specified bit offset.
  ///
  /// The bit offset must be on a byte boundary.
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::getPointerToBit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 232,
   FQN="llvm::SimpleBitstreamCursor::getPointerToBit", NM="_ZN4llvm21SimpleBitstreamCursor15getPointerToBitEyy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursor15getPointerToBitEyy")
  //</editor-fold>
  public /*const*/char$ptr/*uint8_t*//*P*/ getPointerToBit(long/*uint64_t*/ BitNo, long/*uint64_t*/ NumBytes) {
    assert (!(($rem_ulong_ullong(BitNo, $int2ullong(8))) != 0)) : "Expected bit on byte boundary";
    return getPointerToByte($div_ulong_ullong(BitNo, $int2ullong(8)), NumBytes);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::fillCurWord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 237,
   FQN="llvm::SimpleBitstreamCursor::fillCurWord", NM="_ZN4llvm21SimpleBitstreamCursor11fillCurWordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursor11fillCurWordEv")
  //</editor-fold>
  public void fillCurWord() {
    if (Size != 0 && $greatereq_uint(NextChar, Size)) {
      report_fatal_error($("Unexpected end of file"));
    }
    
    // Read the next word from the stream.
    char$ptr/*uint8_t*/ Array/*[4]*/ = create_char$ptr(new byte[4]);//new$char(4, 0);
    char$ptr/*uint8_t*/ CharArray/*[4]*/ = create_char$ptr(Array.$array());
    
    long/*uint64_t*/ BytesRead = R.getBitcodeBytes().readBytes(Array, $uint2ulong(sizeof(Array)), $uint2ulong(NextChar));
    
    // If we run out of data, stop at the end of the stream.
    if (BytesRead == $int2ullong(0)) {
      CurWord = 0;
      BitsInCurWord = 0;
      Size = NextChar;
      return;
    }
    
    CurWord
       = endian./*<size_t, support.endianness.little, support.unaligned>*/read_uint32(endianness.little, support.unaligned, CharArray, 0);
    NextChar += BytesRead;
    BitsInCurWord = $ullong2uint(BytesRead * $int2ullong(8));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::Read">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 262,
   FQN="llvm::SimpleBitstreamCursor::Read", NM="_ZN4llvm21SimpleBitstreamCursor4ReadEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursor4ReadEj")
  //</editor-fold>
  public /*size_t*/int Read(/*uint*/int NumBits) {
    final/*static*/ /*const*//*uint*/int BitsInWord = Read$$.BitsInWord;
    assert ((NumBits != 0) && $lesseq_uint(NumBits, BitsInWord)) : "Cannot return zero or more than BitsInWord bits!";
    
    final/*static*/ /*const*//*uint*/int Mask = Read$$.Mask;
    
    // If the field is fully contained by CurWord, return it quickly.
    if ($greatereq_uint(BitsInCurWord, NumBits)) {
      /*size_t*/int R = CurWord & (~((/*size_t*/int)(0)) >>> (BitsInWord - NumBits));
      
      // Use a mask to avoid undefined behavior.
      CurWord >>>= (NumBits & Mask);
      
      BitsInCurWord -= NumBits;
      return R;
    }
    
    /*size_t*/int R = (BitsInCurWord != 0) ? CurWord : 0;
    /*uint*/int BitsLeft = NumBits - BitsInCurWord;
    
    fillCurWord();
    
    // If we run out of data, stop at the end of the stream.
    if ($greater_uint(BitsLeft, BitsInCurWord)) {
      return 0;
    }
    
    /*size_t*/int R2 = CurWord & (~((/*size_t*/int)(0)) >>> (BitsInWord - BitsLeft));
    
    // Use a mask to avoid undefined behavior.
    CurWord >>>= (BitsLeft & Mask);
    
    BitsInCurWord -= BitsLeft;
    
    R |= R2 << (NumBits - BitsLeft);
    
    return R;
  }
  private static final class Read$$ {
    static final/*static*/ /*const*//*uint*/int BitsInWord = MaxChunkSize;
    static final/*static*/ /*const*//*uint*/int Mask = $greater_uint($sizeof_UInt(), 4) ? 0x3f : 0x1f;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::ReadVBR">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 302,
   FQN="llvm::SimpleBitstreamCursor::ReadVBR", NM="_ZN4llvm21SimpleBitstreamCursor7ReadVBREj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursor7ReadVBREj")
  //</editor-fold>
  public /*uint32_t*/int ReadVBR(/*uint*/int NumBits) {
    /*uint32_t*/int Piece = Read(NumBits);
    if ((Piece & (1/*U*/ << (NumBits - 1))) == 0) {
      return Piece;
    }
    
    /*uint32_t*/int Result = 0;
    /*uint*/int NextBit = 0;
    while (true) {
      Result |= (Piece & ((1/*U*/ << (NumBits - 1)) - 1)) << NextBit;
      if ((Piece & (1/*U*/ << (NumBits - 1))) == 0) {
        return Result;
      }
      
      NextBit += NumBits - 1;
      Piece = Read(NumBits);
    }
  }

  
  // Read a VBR that may have a value up to 64-bits in size. The chunk size of
  // the VBR must still be <= 32 bits though.
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::ReadVBR64">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*why manul conversion to uint64?*/,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 322,
   FQN="llvm::SimpleBitstreamCursor::ReadVBR64", NM="_ZN4llvm21SimpleBitstreamCursor9ReadVBR64Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursor9ReadVBR64Ej")
  //</editor-fold>
  public long/*uint64_t*/ ReadVBR64(/*uint*/int NumBits) {
    /*uint32_t*/int Piece = Read(NumBits);
    if ((Piece & (1/*U*/ << (NumBits - 1))) == 0) {
      return ((long/*uint64_t*/)($uint2ulong(Piece)));
    }
    
    long/*uint64_t*/ Result = $int2ulong(0);
    /*uint*/int NextBit = 0;
    while (true) {
      Result |= $uint2ulong(Piece & ((1/*U*/ << (NumBits - 1)) - 1)) << NextBit;
      if ((Piece & (1/*U*/ << (NumBits - 1))) == 0) {
        return Result;
      }
      
      NextBit += NumBits - 1;
      Piece = Read(NumBits);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::SkipToFourByteBoundary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 340,
   FQN="llvm::SimpleBitstreamCursor::SkipToFourByteBoundary", NM="_ZN4llvm21SimpleBitstreamCursor22SkipToFourByteBoundaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursor22SkipToFourByteBoundaryEv")
  //</editor-fold>
  public void SkipToFourByteBoundary() {
    // If word_t is 64-bits and if we've read less than 32 bits, just dump
    // the bits we have up to the next 32-bit boundary.
    if ($greater_uint($sizeof_UInt(), 4)
       && $greatereq_uint(BitsInCurWord, 32)) {
      CurWord >>>= BitsInCurWord - 32;
      BitsInCurWord = 32;
      return;
    }
    
    BitsInCurWord = 0;
  }

  
  /// Skip to the end of the file.
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::skipToEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 354,
   FQN="llvm::SimpleBitstreamCursor::skipToEnd", NM="_ZN4llvm21SimpleBitstreamCursor9skipToEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursor9skipToEndEv")
  //</editor-fold>
  public void skipToEnd() {
    NextChar = $ulong2uint(R.getBitcodeBytes().getExtent());
  }

  
  /// Prevent the cursor from reading past a byte boundary.
  ///
  /// Prevent the cursor from requesting byte reads past \c Limit.  This is
  /// useful when working with a cursor on a StreamingMemoryObject, when it's
  /// desirable to avoid invalidating the result of getPointerToByte().
  ///
  /// If \c Limit is on a word boundary, AtEndOfStream() will return true if
  /// the cursor position reaches or exceeds \c Limit, regardless of the true
  /// number of available bytes.  Otherwise, AtEndOfStream() returns true when
  /// it reaches or exceeds the next word boundary.
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::setArtificialByteLimit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 366,
   FQN="llvm::SimpleBitstreamCursor::setArtificialByteLimit", NM="_ZN4llvm21SimpleBitstreamCursor22setArtificialByteLimitEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursor22setArtificialByteLimitEy")
  //</editor-fold>
  public void setArtificialByteLimit(long/*uint64_t*/ Limit) {
    assert ($less_ulong(getCurrentByteNo(), Limit)) : "Move cursor before lowering limit";
    
    // Round to word boundary.
    Limit = alignTo(Limit, $uint2ulong($sizeof_UInt()));
    
    // Only change size if the new one is lower.
    if (!(Size != 0) || $greater_uint_ulong(Size, Limit)) {
      Size = $ulong2uint(Limit);
    }
  }

  
  /// Return the Size, if known.
  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::getSizeIfKnown">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 378,
   FQN="llvm::SimpleBitstreamCursor::getSizeIfKnown", NM="_ZNK4llvm21SimpleBitstreamCursor14getSizeIfKnownEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK4llvm21SimpleBitstreamCursor14getSizeIfKnownEv")
  //</editor-fold>
  public long/*uint64_t*/ getSizeIfKnown() /*const*/ {
    return $uint2ulong(Size);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::SimpleBitstreamCursor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 135,
   FQN="llvm::SimpleBitstreamCursor::SimpleBitstreamCursor", NM="_ZN4llvm21SimpleBitstreamCursorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursorC1ERKS0_")
  //</editor-fold>
  public /*inline*/ SimpleBitstreamCursor(final /*const*/ SimpleBitstreamCursor /*&*/ $Prm0) {
    // : R(.R), NextChar(.NextChar), Size(.Size), CurWord(.CurWord), BitsInCurWord(.BitsInCurWord) 
    //START JInit
    this.R = $Prm0.R;
    this.NextChar = $Prm0.NextChar;
    this.Size = $Prm0.Size;
    this.CurWord = $Prm0.CurWord;
    this.BitsInCurWord = $Prm0.BitsInCurWord;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::SimpleBitstreamCursor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 135,
   FQN="llvm::SimpleBitstreamCursor::SimpleBitstreamCursor", NM="_ZN4llvm21SimpleBitstreamCursorC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursorC1EOS0_")
  //</editor-fold>
  public /*inline*/ SimpleBitstreamCursor(JD$Move _dparam, final SimpleBitstreamCursor /*&&*/$Prm0) {
    // : R(static_cast<SimpleBitstreamCursor &&>().R), NextChar(static_cast<SimpleBitstreamCursor &&>().NextChar), Size(static_cast<SimpleBitstreamCursor &&>().Size), CurWord(static_cast<SimpleBitstreamCursor &&>().CurWord), BitsInCurWord(static_cast<SimpleBitstreamCursor &&>().BitsInCurWord) 
    //START JInit
    this.R = $Prm0.R;
    this.NextChar = $Prm0.NextChar;
    this.Size = $Prm0.Size;
    this.CurWord = $Prm0.CurWord;
    this.BitsInCurWord = $Prm0.BitsInCurWord;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 135,
   FQN="llvm::SimpleBitstreamCursor::operator=", NM="_ZN4llvm21SimpleBitstreamCursoraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursoraSERKS0_")
  //</editor-fold>
  public /*inline*/ SimpleBitstreamCursor /*&*/ $assign(final /*const*/ SimpleBitstreamCursor /*&*/ $Prm0) {
    this.R = $Prm0.R;
    this.NextChar = $Prm0.NextChar;
    this.Size = $Prm0.Size;
    this.CurWord = $Prm0.CurWord;
    this.BitsInCurWord = $Prm0.BitsInCurWord;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SimpleBitstreamCursor::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 135,
   FQN="llvm::SimpleBitstreamCursor::operator=", NM="_ZN4llvm21SimpleBitstreamCursoraSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm21SimpleBitstreamCursoraSEOS0_")
  //</editor-fold>
  public /*inline*/ SimpleBitstreamCursor /*&*/ $assignMove(final SimpleBitstreamCursor /*&&*/$Prm0) {
    this.R = $Prm0.R;
    this.NextChar = $Prm0.NextChar;
    this.Size = $Prm0.Size;
    this.CurWord = $Prm0.CurWord;
    this.BitsInCurWord = $Prm0.BitsInCurWord;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public /*inline*/ void $destroy() {
    // JAVA: why was called from BitstreamCursor?
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "R=" + R // NOI18N
              + ", NextChar=" + NextChar // NOI18N
              + ", Size=" + Size // NOI18N
              + ", CurWord=" + CurWord // NOI18N
              + ", BitsInCurWord=" + BitsInCurWord; // NOI18N
  }
}
