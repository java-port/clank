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

package org.llvm.support;

import static org.clank.java.std.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.Casts.reinterpret_cast;
import static org.clank.support.Native.*;
import org.clank.support.aliases.char$ptr;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.llvm.support.llvm.*;

//<editor-fold defaultstate="collapsed" desc="llvm::MD5">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MD5.h", line = 38,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MD5.h", old_line = 37,
 FQN="llvm::MD5", NM="_ZN4llvm3MD5E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MD5.cpp -nm=_ZN4llvm3MD5E")
//</editor-fold>
public class MD5 {
  // Any 32-bit or wider unsigned integer data type will do.
  // JAVA: typedef uint32_t MD5_u32plus;
  
  private /*uint32_t*/int a;
  
  private /*uint32_t*/int b;
  
  private /*uint32_t*/int c;
  
  private /*uint32_t*/int d;
  private /*uint32_t*/int hi;
  private /*uint32_t*/int lo;
  private byte/*uint8_t*/ buffer[/*64*/] = new$char(64);
  private /*uint32_t*/int block[/*16*/] = new$uint(16);
/*public:*/
  // JAVA: typedef uint8_t MD5Result[16]
//  public final class MD5Result extends byte/*uint8_t*/ [16]{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MD5::MD5">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/MD5.cpp", line = 182,
   FQN="llvm::MD5::MD5", NM="_ZN4llvm3MD5C1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MD5.cpp -nm=_ZN4llvm3MD5C1Ev")
  //</editor-fold>
  public MD5() {
    // : a(0x67452301), b(0xefcdab89U), c(0x98badcfeU), d(0x10325476), hi(0), lo(0) 
    //START JInit
    this.a = 0x67452301;
    this.b = 0xefcdab89/*U*/;
    this.c = 0x98badcfe/*U*/;
    this.d = 0x10325476;
    this.hi = 0;
    this.lo = 0;
    //END JInit
  }

  
  /// \brief Updates the hash for the byte stream provided.
  
  /// Incrementally add the bytes in \p Data to the hash.
  //<editor-fold defaultstate="collapsed" desc="llvm::MD5::update">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/MD5.cpp", line = 187,
   FQN="llvm::MD5::update", NM="_ZN4llvm3MD56updateENS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MD5.cpp -nm=_ZN4llvm3MD56updateENS_8ArrayRefIhEE")
  //</editor-fold>
  public void update(ArrayRefChar Data) {
    /*uint32_t*/int saved_lo;
    /*ulong*/int used;
    /*ulong*/int free;
    /*const*/char$ptr/*uint8_t*//*P*/ Ptr = $tryClone(Data.data());
    /*ulong*/int Size = Data.size();
    
    saved_lo = lo;
    if ($less_uint((lo = (saved_lo + Size) & 0x1fffffff), saved_lo)) {
      hi++;
    }
    hi += Size >>> 29;
  
    used = saved_lo & 0x3f;
    if ((used != 0)) {
      free = 64 - used;
      if ($less_ulong(Size, free)) {
        memcpy($AddrOf(buffer), (int)used, Ptr, 0, Size);
        return;
      }

      memcpy($AddrOf(buffer), (int)used, Ptr, 0, free);
      Ptr = $tryClone(Ptr.$add(free));
      Size -= free;
      body(makeArrayRef(create_char$ptr(buffer), 64));
    }
    if ($greatereq_ulong(Size, 64)) {
      Ptr = $tryClone(body(makeArrayRef(Ptr, Size & ~(/*ulong*/int)0x3f)));
      Size &= 0x3f;
    }
    
    memcpy(buffer, Ptr, Size);
  }

  
  /// \brief Updates the hash for the StringRef provided.
  
  /// Add the bytes in the StringRef \p Str to the hash.
  // Note that this isn't a string and so this won't include any trailing NULL
  // bytes.
  //<editor-fold defaultstate="collapsed" desc="llvm::MD5::update">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/MD5.cpp", line = 225,
   FQN="llvm::MD5::update", NM="_ZN4llvm3MD56updateENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MD5.cpp -nm=_ZN4llvm3MD56updateENS_9StringRefE")
  //</editor-fold>
  public void update(StringRef Str) {
    ArrayRefChar SVal/*J*/= new ArrayRefChar(reinterpret_cast(/*const*/char$ptr/*uint8_t*//*P*/ .class, Str.data()), Str.size());
    update(new ArrayRefChar(SVal));
  }

  
  /// \brief Finishes off the hash and puts the result in result.
  
  /// \brief Finish the hash and place the resulting hash into \p result.
  /// \param result is assumed to be a minimum of 16-bytes in size.
  //<editor-fold defaultstate="collapsed" desc="llvm::MD5::final">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/MD5.cpp", line = 232,
   FQN="llvm::MD5::final", NM="_ZN4llvm3MD55finalERA16_h",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MD5.cpp -nm=_ZN4llvm3MD55finalERA16_h")
  //</editor-fold>
  public void __final(final /*uint8*/char$ptr Result) {
    /*ulong*/int used;
    /*ulong*/int free;
    
    used = lo & 0x3f;
    
    buffer[(int)used++] = $int2uchar(0x80);
    
    free = 64 - used;
    if ($less_ulong(free, 8)) {
      memset(create_char$ptr(buffer, (int)used), $$TERM, free);
      body(makeArrayRef(create_char$ptr(buffer), 64));
      used = 0;
      free = 64;
  }

    memset(create_char$ptr(buffer, (int)used), $$TERM, free - 8);
  
    lo <<= 3;
    buffer[56] = (/*uchar*/byte)(lo);
    buffer[57] = (/*uchar*/byte)(lo >>> 8);
    buffer[58] = (/*uchar*/byte)(lo >>> 16);
    buffer[59] = (/*uchar*/byte)(lo >>> 24);
    buffer[60] = (/*uchar*/byte)(hi);
    buffer[61] = (/*uchar*/byte)(hi >>> 8);
    buffer[62] = (/*uchar*/byte)(hi >>> 16);
    buffer[63] = (/*uchar*/byte)(hi >>> 24);
    
    body(makeArrayRef(create_char$ptr(buffer), 64));
    
    Result.$set(0, (/*uchar*/byte)(a));
    Result.$set(1, (/*uchar*/byte)(a >>> 8));
    Result.$set(2, (/*uchar*/byte)(a >>> 16));
    Result.$set(3, (/*uchar*/byte)(a >>> 24));
    Result.$set(4, (/*uchar*/byte)(b));
    Result.$set(5, (/*uchar*/byte)(b >>> 8));
    Result.$set(6, (/*uchar*/byte)(b >>> 16));
    Result.$set(7, (/*uchar*/byte)(b >>> 24));
    Result.$set(8, (/*uchar*/byte)(c));
    Result.$set(9, (/*uchar*/byte)(c >>> 8));
    Result.$set(10, (/*uchar*/byte)(c >>> 16));
    Result.$set(11, (/*uchar*/byte)(c >>> 24));
    Result.$set(12, (/*uchar*/byte)(d));
    Result.$set(13, (/*uchar*/byte)(d >>> 8));
    Result.$set(14, (/*uchar*/byte)(d >>> 16));
    Result.$set(15, (/*uchar*/byte)(d >>> 24));
  }

  
  /// \brief Translates the bytes in \p Res to a hex string that is
  /// deposited into \p Str. The result will be of length 32.
  //<editor-fold defaultstate="collapsed" desc="llvm::MD5::stringifyResult">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*uchar=>char and changes in format string*/,
   source = "${LLVM_SRC}/llvm/lib/Support/MD5.cpp", line = 280,
   FQN="llvm::MD5::stringifyResult", NM="_ZN4llvm3MD515stringifyResultERA16_hRNS_11SmallStringILj32EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MD5.cpp -nm=_ZN4llvm3MD515stringifyResultERA16_hRNS_11SmallStringILj32EEE")
  //</editor-fold>
  public static void stringifyResult(final /*uint8*/char$ptr Result, final SmallString/*32*/ /*&*/ Str) {
    raw_svector_ostream Res = null;
    try {
      assert Str.size() == 0;
      Res/*J*/= new raw_svector_ostream(Str);
      for (int i = 0; i < 16; ++i)  {
        // JAVA: %.2 => %02
        Res.$out(format_uchar(/*KEEP_STR*/"%02x", Result.$at(i)));
      }
      assert Str.size() == 32;
    } finally {
      if (Res != null) { Res.$destroy(); }
    }
  }

/*private:*/
  
  /// \brief This processes one or more 64-byte data blocks, but does NOT update
  ///the bit counters.  There are no alignment requirements.
  //<editor-fold defaultstate="collapsed" desc="llvm::MD5::body">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/MD5.cpp", line = 75,
   FQN="llvm::MD5::body", NM="_ZN4llvm3MD54bodyENS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MD5.cpp -nm=_ZN4llvm3MD54bodyENS_8ArrayRefIhEE")
  //</editor-fold>
  private /*const*/char$ptr/*uint8_t*//*P*/ body(ArrayRefChar Data) {
    /*const*/char$ptr/*uint8_t*//*P*/ ptr;
    /*uint32_t*/int a;
    /*uint32_t*/int b;
    /*uint32_t*/int c;
    /*uint32_t*/int d;
    /*uint32_t*/int saved_a;
    /*uint32_t*/int saved_b;
    /*uint32_t*/int saved_c;
    /*uint32_t*/int saved_d;
    /*ulong*/long Size = Data.size();
    
    ptr = $tryClone(Data.data());
    
    a = this.a;
    b = this.b;
    c = this.c;
    d = this.d;
    
    do {
      saved_a = a;
      saved_b = b;
      saved_c = c;
      saved_d = d;
      
      // Round 1
      (a) += (((d)) ^ (((b)) & (((c)) ^ ((d))))) + ((block[(0)] = (/*uint32_t*/int)$uchar2uint(ptr.$at((0) * 4)) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((0) * 4 + 1)) << 8) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((0) * 4 + 2)) << 16) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((0) * 4 + 3)) << 24))) + (0xD76AA478/*U*/);
      (a) = (((a) << (7)) | (((a) & 0xFFFFFFFF/*U*/) >>> (32 - (7))));
      (a) += (b);
      (d) += (((c)) ^ (((a)) & (((b)) ^ ((c))))) + ((block[(1)] = (/*uint32_t*/int)$uchar2uint(ptr.$at((1) * 4)) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((1) * 4 + 1)) << 8) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((1) * 4 + 2)) << 16) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((1) * 4 + 3)) << 24))) + (0xE8C7B756/*U*/);
      (d) = (((d) << (12)) | (((d) & 0xFFFFFFFF/*U*/) >>> (32 - (12))));
      (d) += (a);
      (c) += (((b)) ^ (((d)) & (((a)) ^ ((b))))) + ((block[(2)] = (/*uint32_t*/int)$uchar2uint(ptr.$at((2) * 4)) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((2) * 4 + 1)) << 8) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((2) * 4 + 2)) << 16) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((2) * 4 + 3)) << 24))) + (0x242070DB);
      (c) = (((c) << (17)) | (((c) & 0xFFFFFFFF/*U*/) >>> (32 - (17))));
      (c) += (d);
      (b) += (((a)) ^ (((c)) & (((d)) ^ ((a))))) + ((block[(3)] = (/*uint32_t*/int)$uchar2uint(ptr.$at((3) * 4)) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((3) * 4 + 1)) << 8) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((3) * 4 + 2)) << 16) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((3) * 4 + 3)) << 24))) + (0xC1BDCEEE/*U*/);
      (b) = (((b) << (22)) | (((b) & 0xFFFFFFFF/*U*/) >>> (32 - (22))));
      (b) += (c);
      (a) += (((d)) ^ (((b)) & (((c)) ^ ((d))))) + ((block[(4)] = (/*uint32_t*/int)$uchar2uint(ptr.$at((4) * 4)) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((4) * 4 + 1)) << 8) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((4) * 4 + 2)) << 16) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((4) * 4 + 3)) << 24))) + (0xF57C0FAF/*U*/);
      (a) = (((a) << (7)) | (((a) & 0xFFFFFFFF/*U*/) >>> (32 - (7))));
      (a) += (b);
      (d) += (((c)) ^ (((a)) & (((b)) ^ ((c))))) + ((block[(5)] = (/*uint32_t*/int)$uchar2uint(ptr.$at((5) * 4)) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((5) * 4 + 1)) << 8) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((5) * 4 + 2)) << 16) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((5) * 4 + 3)) << 24))) + (0x4787C62A);
      (d) = (((d) << (12)) | (((d) & 0xFFFFFFFF/*U*/) >>> (32 - (12))));
      (d) += (a);
      (c) += (((b)) ^ (((d)) & (((a)) ^ ((b))))) + ((block[(6)] = (/*uint32_t*/int)$uchar2uint(ptr.$at((6) * 4)) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((6) * 4 + 1)) << 8) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((6) * 4 + 2)) << 16) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((6) * 4 + 3)) << 24))) + (0xA8304613/*U*/);
      (c) = (((c) << (17)) | (((c) & 0xFFFFFFFF/*U*/) >>> (32 - (17))));
      (c) += (d);
      (b) += (((a)) ^ (((c)) & (((d)) ^ ((a))))) + ((block[(7)] = (/*uint32_t*/int)$uchar2uint(ptr.$at((7) * 4)) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((7) * 4 + 1)) << 8) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((7) * 4 + 2)) << 16) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((7) * 4 + 3)) << 24))) + (0xFD469501/*U*/);
      (b) = (((b) << (22)) | (((b) & 0xFFFFFFFF/*U*/) >>> (32 - (22))));
      (b) += (c);
      (a) += (((d)) ^ (((b)) & (((c)) ^ ((d))))) + ((block[(8)] = (/*uint32_t*/int)$uchar2uint(ptr.$at((8) * 4)) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((8) * 4 + 1)) << 8) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((8) * 4 + 2)) << 16) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((8) * 4 + 3)) << 24))) + (0x698098D8);
      (a) = (((a) << (7)) | (((a) & 0xFFFFFFFF/*U*/) >>> (32 - (7))));
      (a) += (b);
      (d) += (((c)) ^ (((a)) & (((b)) ^ ((c))))) + ((block[(9)] = (/*uint32_t*/int)$uchar2uint(ptr.$at((9) * 4)) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((9) * 4 + 1)) << 8) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((9) * 4 + 2)) << 16) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((9) * 4 + 3)) << 24))) + (0x8B44F7AF/*U*/);
      (d) = (((d) << (12)) | (((d) & 0xFFFFFFFF/*U*/) >>> (32 - (12))));
      (d) += (a);
      (c) += (((b)) ^ (((d)) & (((a)) ^ ((b))))) + ((block[(10)] = (/*uint32_t*/int)$uchar2uint(ptr.$at((10) * 4)) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((10) * 4 + 1)) << 8) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((10) * 4 + 2)) << 16) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((10) * 4 + 3)) << 24))) + (0xFFFF5BB1/*U*/);
      (c) = (((c) << (17)) | (((c) & 0xFFFFFFFF/*U*/) >>> (32 - (17))));
      (c) += (d);
      (b) += (((a)) ^ (((c)) & (((d)) ^ ((a))))) + ((block[(11)] = (/*uint32_t*/int)$uchar2uint(ptr.$at((11) * 4)) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((11) * 4 + 1)) << 8) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((11) * 4 + 2)) << 16) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((11) * 4 + 3)) << 24))) + (0x895CD7BE/*U*/);
      (b) = (((b) << (22)) | (((b) & 0xFFFFFFFF/*U*/) >>> (32 - (22))));
      (b) += (c);
      (a) += (((d)) ^ (((b)) & (((c)) ^ ((d))))) + ((block[(12)] = (/*uint32_t*/int)$uchar2uint(ptr.$at((12) * 4)) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((12) * 4 + 1)) << 8) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((12) * 4 + 2)) << 16) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((12) * 4 + 3)) << 24))) + (0x6B901122);
      (a) = (((a) << (7)) | (((a) & 0xFFFFFFFF/*U*/) >>> (32 - (7))));
      (a) += (b);
      (d) += (((c)) ^ (((a)) & (((b)) ^ ((c))))) + ((block[(13)] = (/*uint32_t*/int)$uchar2uint(ptr.$at((13) * 4)) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((13) * 4 + 1)) << 8) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((13) * 4 + 2)) << 16) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((13) * 4 + 3)) << 24))) + (0xFD987193/*U*/);
      (d) = (((d) << (12)) | (((d) & 0xFFFFFFFF/*U*/) >>> (32 - (12))));
      (d) += (a);
      (c) += (((b)) ^ (((d)) & (((a)) ^ ((b))))) + ((block[(14)] = (/*uint32_t*/int)$uchar2uint(ptr.$at((14) * 4)) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((14) * 4 + 1)) << 8) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((14) * 4 + 2)) << 16) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((14) * 4 + 3)) << 24))) + (0xA679438E/*U*/);
      (c) = (((c) << (17)) | (((c) & 0xFFFFFFFF/*U*/) >>> (32 - (17))));
      (c) += (d);
      (b) += (((a)) ^ (((c)) & (((d)) ^ ((a))))) + ((block[(15)] = (/*uint32_t*/int)$uchar2uint(ptr.$at((15) * 4)) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((15) * 4 + 1)) << 8) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((15) * 4 + 2)) << 16) | ((/*uint32_t*/int)$uchar2uint(ptr.$at((15) * 4 + 3)) << 24))) + (0x49B40821);
      (b) = (((b) << (22)) | (((b) & 0xFFFFFFFF/*U*/) >>> (32 - (22))));
      (b) += (c);
      
      // Round 2
      (a) += (((c)) ^ (((d)) & (((b)) ^ ((c))))) + ((block[(1)])) + (0xF61E2562/*U*/);
      (a) = (((a) << (5)) | (((a) & 0xFFFFFFFF/*U*/) >>> (32 - (5))));
      (a) += (b);
      (d) += (((b)) ^ (((c)) & (((a)) ^ ((b))))) + ((block[(6)])) + (0xC040B340/*U*/);
      (d) = (((d) << (9)) | (((d) & 0xFFFFFFFF/*U*/) >>> (32 - (9))));
      (d) += (a);
      (c) += (((a)) ^ (((b)) & (((d)) ^ ((a))))) + ((block[(11)])) + (0x265E5A51);
      (c) = (((c) << (14)) | (((c) & 0xFFFFFFFF/*U*/) >>> (32 - (14))));
      (c) += (d);
      (b) += (((d)) ^ (((a)) & (((c)) ^ ((d))))) + ((block[(0)])) + (0xE9B6C7AA/*U*/);
      (b) = (((b) << (20)) | (((b) & 0xFFFFFFFF/*U*/) >>> (32 - (20))));
      (b) += (c);
      (a) += (((c)) ^ (((d)) & (((b)) ^ ((c))))) + ((block[(5)])) + (0xD62F105D/*U*/);
      (a) = (((a) << (5)) | (((a) & 0xFFFFFFFF/*U*/) >>> (32 - (5))));
      (a) += (b);
      (d) += (((b)) ^ (((c)) & (((a)) ^ ((b))))) + ((block[(10)])) + (0x2441453);
      (d) = (((d) << (9)) | (((d) & 0xFFFFFFFF/*U*/) >>> (32 - (9))));
      (d) += (a);
      (c) += (((a)) ^ (((b)) & (((d)) ^ ((a))))) + ((block[(15)])) + (0xD8A1E681/*U*/);
      (c) = (((c) << (14)) | (((c) & 0xFFFFFFFF/*U*/) >>> (32 - (14))));
      (c) += (d);
      (b) += (((d)) ^ (((a)) & (((c)) ^ ((d))))) + ((block[(4)])) + (0xE7D3FBC8/*U*/);
      (b) = (((b) << (20)) | (((b) & 0xFFFFFFFF/*U*/) >>> (32 - (20))));
      (b) += (c);
      (a) += (((c)) ^ (((d)) & (((b)) ^ ((c))))) + ((block[(9)])) + (0x21E1CDE6);
      (a) = (((a) << (5)) | (((a) & 0xFFFFFFFF/*U*/) >>> (32 - (5))));
      (a) += (b);
      (d) += (((b)) ^ (((c)) & (((a)) ^ ((b))))) + ((block[(14)])) + (0xC33707D6/*U*/);
      (d) = (((d) << (9)) | (((d) & 0xFFFFFFFF/*U*/) >>> (32 - (9))));
      (d) += (a);
      (c) += (((a)) ^ (((b)) & (((d)) ^ ((a))))) + ((block[(3)])) + (0xF4D50D87/*U*/);
      (c) = (((c) << (14)) | (((c) & 0xFFFFFFFF/*U*/) >>> (32 - (14))));
      (c) += (d);
      (b) += (((d)) ^ (((a)) & (((c)) ^ ((d))))) + ((block[(8)])) + (0x455A14ED);
      (b) = (((b) << (20)) | (((b) & 0xFFFFFFFF/*U*/) >>> (32 - (20))));
      (b) += (c);
      (a) += (((c)) ^ (((d)) & (((b)) ^ ((c))))) + ((block[(13)])) + (0xA9E3E905/*U*/);
      (a) = (((a) << (5)) | (((a) & 0xFFFFFFFF/*U*/) >>> (32 - (5))));
      (a) += (b);
      (d) += (((b)) ^ (((c)) & (((a)) ^ ((b))))) + ((block[(2)])) + (0xFCEFA3F8/*U*/);
      (d) = (((d) << (9)) | (((d) & 0xFFFFFFFF/*U*/) >>> (32 - (9))));
      (d) += (a);
      (c) += (((a)) ^ (((b)) & (((d)) ^ ((a))))) + ((block[(7)])) + (0x676F02D9);
      (c) = (((c) << (14)) | (((c) & 0xFFFFFFFF/*U*/) >>> (32 - (14))));
      (c) += (d);
      (b) += (((d)) ^ (((a)) & (((c)) ^ ((d))))) + ((block[(12)])) + (0x8D2A4C8A/*U*/);
      (b) = (((b) << (20)) | (((b) & 0xFFFFFFFF/*U*/) >>> (32 - (20))));
      (b) += (c);
      
      // Round 3
      (a) += (((b)) ^ ((c)) ^ ((d))) + ((block[(5)])) + (0xFFFA3942/*U*/);
      (a) = (((a) << (4)) | (((a) & 0xFFFFFFFF/*U*/) >>> (32 - (4))));
      (a) += (b);
      (d) += (((a)) ^ ((b)) ^ ((c))) + ((block[(8)])) + (0x8771F681/*U*/);
      (d) = (((d) << (11)) | (((d) & 0xFFFFFFFF/*U*/) >>> (32 - (11))));
      (d) += (a);
      (c) += (((d)) ^ ((a)) ^ ((b))) + ((block[(11)])) + (0x6D9D6122);
      (c) = (((c) << (16)) | (((c) & 0xFFFFFFFF/*U*/) >>> (32 - (16))));
      (c) += (d);
      (b) += (((c)) ^ ((d)) ^ ((a))) + ((block[(14)])) + (0xFDE5380C/*U*/);
      (b) = (((b) << (23)) | (((b) & 0xFFFFFFFF/*U*/) >>> (32 - (23))));
      (b) += (c);
      (a) += (((b)) ^ ((c)) ^ ((d))) + ((block[(1)])) + (0xA4BEEA44/*U*/);
      (a) = (((a) << (4)) | (((a) & 0xFFFFFFFF/*U*/) >>> (32 - (4))));
      (a) += (b);
      (d) += (((a)) ^ ((b)) ^ ((c))) + ((block[(4)])) + (0x4BDECFA9);
      (d) = (((d) << (11)) | (((d) & 0xFFFFFFFF/*U*/) >>> (32 - (11))));
      (d) += (a);
      (c) += (((d)) ^ ((a)) ^ ((b))) + ((block[(7)])) + (0xF6BB4B60/*U*/);
      (c) = (((c) << (16)) | (((c) & 0xFFFFFFFF/*U*/) >>> (32 - (16))));
      (c) += (d);
      (b) += (((c)) ^ ((d)) ^ ((a))) + ((block[(10)])) + (0xBEBFBC70/*U*/);
      (b) = (((b) << (23)) | (((b) & 0xFFFFFFFF/*U*/) >>> (32 - (23))));
      (b) += (c);
      (a) += (((b)) ^ ((c)) ^ ((d))) + ((block[(13)])) + (0x289B7EC6);
      (a) = (((a) << (4)) | (((a) & 0xFFFFFFFF/*U*/) >>> (32 - (4))));
      (a) += (b);
      (d) += (((a)) ^ ((b)) ^ ((c))) + ((block[(0)])) + (0xEAA127FA/*U*/);
      (d) = (((d) << (11)) | (((d) & 0xFFFFFFFF/*U*/) >>> (32 - (11))));
      (d) += (a);
      (c) += (((d)) ^ ((a)) ^ ((b))) + ((block[(3)])) + (0xD4EF3085/*U*/);
      (c) = (((c) << (16)) | (((c) & 0xFFFFFFFF/*U*/) >>> (32 - (16))));
      (c) += (d);
      (b) += (((c)) ^ ((d)) ^ ((a))) + ((block[(6)])) + (0x4881D05);
      (b) = (((b) << (23)) | (((b) & 0xFFFFFFFF/*U*/) >>> (32 - (23))));
      (b) += (c);
      (a) += (((b)) ^ ((c)) ^ ((d))) + ((block[(9)])) + (0xD9D4D039/*U*/);
      (a) = (((a) << (4)) | (((a) & 0xFFFFFFFF/*U*/) >>> (32 - (4))));
      (a) += (b);
      (d) += (((a)) ^ ((b)) ^ ((c))) + ((block[(12)])) + (0xE6DB99E5/*U*/);
      (d) = (((d) << (11)) | (((d) & 0xFFFFFFFF/*U*/) >>> (32 - (11))));
      (d) += (a);
      (c) += (((d)) ^ ((a)) ^ ((b))) + ((block[(15)])) + (0x1FA27CF8);
      (c) = (((c) << (16)) | (((c) & 0xFFFFFFFF/*U*/) >>> (32 - (16))));
      (c) += (d);
      (b) += (((c)) ^ ((d)) ^ ((a))) + ((block[(2)])) + (0xC4AC5665/*U*/);
      (b) = (((b) << (23)) | (((b) & 0xFFFFFFFF/*U*/) >>> (32 - (23))));
      (b) += (c);
      
      // Round 4
      (a) += (((c)) ^ (((b)) | ~((d)))) + ((block[(0)])) + (0xF4292244/*U*/);
      (a) = (((a) << (6)) | (((a) & 0xFFFFFFFF/*U*/) >>> (32 - (6))));
      (a) += (b);
      (d) += (((b)) ^ (((a)) | ~((c)))) + ((block[(7)])) + (0x432AFF97);
      (d) = (((d) << (10)) | (((d) & 0xFFFFFFFF/*U*/) >>> (32 - (10))));
      (d) += (a);
      (c) += (((a)) ^ (((d)) | ~((b)))) + ((block[(14)])) + (0xAB9423A7/*U*/);
      (c) = (((c) << (15)) | (((c) & 0xFFFFFFFF/*U*/) >>> (32 - (15))));
      (c) += (d);
      (b) += (((d)) ^ (((c)) | ~((a)))) + ((block[(5)])) + (0xFC93A039/*U*/);
      (b) = (((b) << (21)) | (((b) & 0xFFFFFFFF/*U*/) >>> (32 - (21))));
      (b) += (c);
      (a) += (((c)) ^ (((b)) | ~((d)))) + ((block[(12)])) + (0x655B59C3);
      (a) = (((a) << (6)) | (((a) & 0xFFFFFFFF/*U*/) >>> (32 - (6))));
      (a) += (b);
      (d) += (((b)) ^ (((a)) | ~((c)))) + ((block[(3)])) + (0x8F0CCC92/*U*/);
      (d) = (((d) << (10)) | (((d) & 0xFFFFFFFF/*U*/) >>> (32 - (10))));
      (d) += (a);
      (c) += (((a)) ^ (((d)) | ~((b)))) + ((block[(10)])) + (0xFFEFF47D/*U*/);
      (c) = (((c) << (15)) | (((c) & 0xFFFFFFFF/*U*/) >>> (32 - (15))));
      (c) += (d);
      (b) += (((d)) ^ (((c)) | ~((a)))) + ((block[(1)])) + (0x85845DD1/*U*/);
      (b) = (((b) << (21)) | (((b) & 0xFFFFFFFF/*U*/) >>> (32 - (21))));
      (b) += (c);
      (a) += (((c)) ^ (((b)) | ~((d)))) + ((block[(8)])) + (0x6FA87E4F);
      (a) = (((a) << (6)) | (((a) & 0xFFFFFFFF/*U*/) >>> (32 - (6))));
      (a) += (b);
      (d) += (((b)) ^ (((a)) | ~((c)))) + ((block[(15)])) + (0xFE2CE6E0/*U*/);
      (d) = (((d) << (10)) | (((d) & 0xFFFFFFFF/*U*/) >>> (32 - (10))));
      (d) += (a);
      (c) += (((a)) ^ (((d)) | ~((b)))) + ((block[(6)])) + (0xA3014314/*U*/);
      (c) = (((c) << (15)) | (((c) & 0xFFFFFFFF/*U*/) >>> (32 - (15))));
      (c) += (d);
      (b) += (((d)) ^ (((c)) | ~((a)))) + ((block[(13)])) + (0x4E0811A1);
      (b) = (((b) << (21)) | (((b) & 0xFFFFFFFF/*U*/) >>> (32 - (21))));
      (b) += (c);
      (a) += (((c)) ^ (((b)) | ~((d)))) + ((block[(4)])) + (0xF7537E82/*U*/);
      (a) = (((a) << (6)) | (((a) & 0xFFFFFFFF/*U*/) >>> (32 - (6))));
      (a) += (b);
      (d) += (((b)) ^ (((a)) | ~((c)))) + ((block[(11)])) + (0xBD3AF235/*U*/);
      (d) = (((d) << (10)) | (((d) & 0xFFFFFFFF/*U*/) >>> (32 - (10))));
      (d) += (a);
      (c) += (((a)) ^ (((d)) | ~((b)))) + ((block[(2)])) + (0x2AD7D2BB);
      (c) = (((c) << (15)) | (((c) & 0xFFFFFFFF/*U*/) >>> (32 - (15))));
      (c) += (d);
      (b) += (((d)) ^ (((c)) | ~((a)))) + ((block[(9)])) + (0xEB86D391/*U*/);
      (b) = (((b) << (21)) | (((b) & 0xFFFFFFFF/*U*/) >>> (32 - (21))));
      (b) += (c);
      
      a += saved_a;
      b += saved_b;
      c += saved_c;
      d += saved_d;
      
      ptr.$inc(64);
    } while (((Size -= 64) != 0));
    
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
    
    return ptr;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public void update(long Data) { 
    // we ignore endian since for MD5 this does not matter, just process all bytes
    byte[] a = new byte[8];
    for (int i = 0; i < 8; i++) {
      a[i] = (byte) (Data & 0xFF); // low byte
      Data <<= 8;
    }
    update(new ArrayRefChar(a));
  }

  public void __final(final /*uint8*/byte Result[]) {
    __final(create_char$ptr(Result));
  }

  public static void stringifyResult(final /*uint8*/byte Result[], final SmallString/*32*/ /*&*/ Str) {
    stringifyResult(create_char$ptr(Result), Str);
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "a=" + a // NOI18N
              + ", b=" + b // NOI18N
              + ", c=" + c // NOI18N
              + ", d=" + d // NOI18N
              + ", hi=" + hi // NOI18N
              + ", lo=" + lo // NOI18N
              + ", buffer=" + buffer // NOI18N
              + ", block=" + block; // NOI18N
  }
}
