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

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/DataExtractor.h", line = 17,
 FQN="llvm::DataExtractor", NM="_ZN4llvm13DataExtractorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZN4llvm13DataExtractorE")
//</editor-fold>
public class DataExtractor {
  private StringRef Data;
  private byte/*uint8_t*/ IsLittleEndian;
  private byte/*uint8_t*/ AddressSize;
/*public:*/
  /// Construct with a buffer that is owned by the caller.
  ///
  /// This constructor allows us to use data that is owned by the
  /// caller. The data must stay around as long as this object is
  /// valid.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::DataExtractor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DataExtractor.h", line = 27,
   FQN="llvm::DataExtractor::DataExtractor", NM="_ZN4llvm13DataExtractorC1ENS_9StringRefEbh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZN4llvm13DataExtractorC1ENS_9StringRefEbh")
  //</editor-fold>
  public DataExtractor(StringRef Data, boolean IsLittleEndian, byte/*uint8_t*/ AddressSize) {
    // : Data(Data), IsLittleEndian(IsLittleEndian), AddressSize(AddressSize) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Get the data pointed to by this extractor.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::getData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DataExtractor.h", line = 31,
   FQN="llvm::DataExtractor::getData", NM="_ZNK4llvm13DataExtractor7getDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor7getDataEv")
  //</editor-fold>
  public StringRef getData() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// \brief Get the endianess for this extractor.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::isLittleEndian">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DataExtractor.h", line = 33,
   FQN="llvm::DataExtractor::isLittleEndian", NM="_ZNK4llvm13DataExtractor14isLittleEndianEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor14isLittleEndianEv")
  //</editor-fold>
  public boolean isLittleEndian() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// \brief Get the address size for this extractor.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::getAddressSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DataExtractor.h", line = 35,
   FQN="llvm::DataExtractor::getAddressSize", NM="_ZNK4llvm13DataExtractor14getAddressSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor14getAddressSizeEv")
  //</editor-fold>
  public byte/*uint8_t*/ getAddressSize() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// \brief Set the address size for this extractor.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::setAddressSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DataExtractor.h", line = 37,
   FQN="llvm::DataExtractor::setAddressSize", NM="_ZN4llvm13DataExtractor14setAddressSizeEh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZN4llvm13DataExtractor14setAddressSizeEh")
  //</editor-fold>
  public void setAddressSize(byte/*uint8_t*/ Size) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Extract a C string from \a *offset_ptr.
  ///
  /// Returns a pointer to a C String from the data at the offset
  /// pointed to by \a offset_ptr. A variable length NULL terminated C
  /// string will be extracted and the \a offset_ptr will be
  /// updated with the offset of the byte that follows the NULL
  /// terminator byte.
  ///
  /// @param[in,out] offset_ptr
  ///     A pointer to an offset within the data that will be advanced
  ///     by the appropriate number of bytes if the value is extracted
  ///     correctly. If the offset is out of bounds or there are not
  ///     enough bytes to extract this value, the offset will be left
  ///     unmodified.
  ///
  /// @return
  ///     A pointer to the C string value in the data. If the offset
  ///     pointed to by \a offset_ptr is out of bounds, or if the
  ///     offset plus the length of the C string is out of bounds,
  ///     NULL will be returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::getCStr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp", line = 121,
   FQN="llvm::DataExtractor::getCStr", NM="_ZNK4llvm13DataExtractor7getCStrEPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor7getCStrEPj")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getCStr(/*uint32_t P*/uint$ptr offset_ptr) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Extract an unsigned integer of size \a byte_size from \a
  /// *offset_ptr.
  ///
  /// Extract a single unsigned integer value and update the offset
  /// pointed to by \a offset_ptr. The size of the extracted integer
  /// is specified by the \a byte_size argument. \a byte_size should
  /// have a value greater than or equal to one and less than or equal
  /// to eight since the return value is 64 bits wide. Any
  /// \a byte_size values less than 1 or greater than 8 will result in
  /// nothing being extracted, and zero being returned.
  ///
  /// @param[in,out] offset_ptr
  ///     A pointer to an offset within the data that will be advanced
  ///     by the appropriate number of bytes if the value is extracted
  ///     correctly. If the offset is out of bounds or there are not
  ///     enough bytes to extract this value, the offset will be left
  ///     unmodified.
  ///
  /// @param[in] byte_size
  ///     The size in byte of the integer to extract.
  ///
  /// @return
  ///     The unsigned integer value that was extracted, or zero on
  ///     failure.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::getUnsigned">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp", line = 91,
   FQN="llvm::DataExtractor::getUnsigned", NM="_ZNK4llvm13DataExtractor11getUnsignedEPjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor11getUnsignedEPjj")
  //</editor-fold>
  public long/*uint64_t*/ getUnsigned(/*uint32_t P*/uint$ptr offset_ptr, /*uint32_t*/int byte_size) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Extract an signed integer of size \a byte_size from \a *offset_ptr.
  ///
  /// Extract a single signed integer value (sign extending if required)
  /// and update the offset pointed to by \a offset_ptr. The size of
  /// the extracted integer is specified by the \a byte_size argument.
  /// \a byte_size should have a value greater than or equal to one
  /// and less than or equal to eight since the return value is 64
  /// bits wide. Any \a byte_size values less than 1 or greater than
  /// 8 will result in nothing being extracted, and zero being returned.
  ///
  /// @param[in,out] offset_ptr
  ///     A pointer to an offset within the data that will be advanced
  ///     by the appropriate number of bytes if the value is extracted
  ///     correctly. If the offset is out of bounds or there are not
  ///     enough bytes to extract this value, the offset will be left
  ///     unmodified.
  ///
  /// @param[in] size
  ///     The size in bytes of the integer to extract.
  ///
  /// @return
  ///     The sign extended signed integer value that was extracted,
  ///     or zero on failure.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::getSigned">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp", line = 106,
   FQN="llvm::DataExtractor::getSigned", NM="_ZNK4llvm13DataExtractor9getSignedEPjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor9getSignedEPjj")
  //</editor-fold>
  public long/*int64_t*/ getSigned(/*uint32_t P*/uint$ptr offset_ptr, /*uint32_t*/int byte_size) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //------------------------------------------------------------------
  /// Extract an pointer from \a *offset_ptr.
  ///
  /// Extract a single pointer from the data and update the offset
  /// pointed to by \a offset_ptr. The size of the extracted pointer
  /// is \a getAddressSize(), so the address size has to be
  /// set correctly prior to extracting any pointer values.
  ///
  /// @param[in,out] offset_ptr
  ///     A pointer to an offset within the data that will be advanced
  ///     by the appropriate number of bytes if the value is extracted
  ///     correctly. If the offset is out of bounds or there are not
  ///     enough bytes to extract this value, the offset will be left
  ///     unmodified.
  ///
  /// @return
  ///     The extracted pointer value as a 64 integer.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::getAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DataExtractor.h", line = 129,
   FQN="llvm::DataExtractor::getAddress", NM="_ZNK4llvm13DataExtractor10getAddressEPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor10getAddressEPj")
  //</editor-fold>
  public long/*uint64_t*/ getAddress(/*uint32_t P*/uint$ptr offset_ptr) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Extract a uint8_t value from \a *offset_ptr.
  ///
  /// Extract a single uint8_t from the binary data at the offset
  /// pointed to by \a offset_ptr, and advance the offset on success.
  ///
  /// @param[in,out] offset_ptr
  ///     A pointer to an offset within the data that will be advanced
  ///     by the appropriate number of bytes if the value is extracted
  ///     correctly. If the offset is out of bounds or there are not
  ///     enough bytes to extract this value, the offset will be left
  ///     unmodified.
  ///
  /// @return
  ///     The extracted uint8_t value.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::getU8">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp", line = 50,
   FQN="llvm::DataExtractor::getU8", NM="_ZNK4llvm13DataExtractor5getU8EPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor5getU8EPj")
  //</editor-fold>
  public byte/*uint8_t*/ getU8(/*uint32_t P*/uint$ptr offset_ptr) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Extract \a count uint8_t values from \a *offset_ptr.
  ///
  /// Extract \a count uint8_t values from the binary data at the
  /// offset pointed to by \a offset_ptr, and advance the offset on
  /// success. The extracted values are copied into \a dst.
  ///
  /// @param[in,out] offset_ptr
  ///     A pointer to an offset within the data that will be advanced
  ///     by the appropriate number of bytes if the value is extracted
  ///     correctly. If the offset is out of bounds or there are not
  ///     enough bytes to extract this value, the offset will be left
  ///     unmodified.
  ///
  /// @param[out] dst
  ///     A buffer to copy \a count uint8_t values into. \a dst must
  ///     be large enough to hold all requested data.
  ///
  /// @param[in] count
  ///     The number of uint8_t values to extract.
  ///
  /// @return
  ///     \a dst if all values were properly extracted and copied,
  ///     NULL otherise.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::getU8">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp", line = 54,
   FQN="llvm::DataExtractor::getU8", NM="_ZNK4llvm13DataExtractor5getU8EPjPhj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor5getU8EPjPhj")
  //</editor-fold>
  public byte/*uint8_t*//*P*/ getU8(/*uint32_t P*/uint$ptr offset_ptr, byte/*uint8_t*//*P*/ dst, /*uint32_t*/int count) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //------------------------------------------------------------------
  /// Extract a uint16_t value from \a *offset_ptr.
  ///
  /// Extract a single uint16_t from the binary data at the offset
  /// pointed to by \a offset_ptr, and update the offset on success.
  ///
  /// @param[in,out] offset_ptr
  ///     A pointer to an offset within the data that will be advanced
  ///     by the appropriate number of bytes if the value is extracted
  ///     correctly. If the offset is out of bounds or there are not
  ///     enough bytes to extract this value, the offset will be left
  ///     unmodified.
  ///
  /// @return
  ///     The extracted uint16_t value.
  //------------------------------------------------------------------
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::getU16">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp", line = 61,
   FQN="llvm::DataExtractor::getU16", NM="_ZNK4llvm13DataExtractor6getU16EPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor6getU16EPj")
  //</editor-fold>
  public /*uint16_t*/char getU16(/*uint32_t P*/uint$ptr offset_ptr) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Extract \a count uint16_t values from \a *offset_ptr.
  ///
  /// Extract \a count uint16_t values from the binary data at the
  /// offset pointed to by \a offset_ptr, and advance the offset on
  /// success. The extracted values are copied into \a dst.
  ///
  /// @param[in,out] offset_ptr
  ///     A pointer to an offset within the data that will be advanced
  ///     by the appropriate number of bytes if the value is extracted
  ///     correctly. If the offset is out of bounds or there are not
  ///     enough bytes to extract this value, the offset will be left
  ///     unmodified.
  ///
  /// @param[out] dst
  ///     A buffer to copy \a count uint16_t values into. \a dst must
  ///     be large enough to hold all requested data.
  ///
  /// @param[in] count
  ///     The number of uint16_t values to extract.
  ///
  /// @return
  ///     \a dst if all values were properly extracted and copied,
  ///     NULL otherise.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::getU16">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp", line = 65,
   FQN="llvm::DataExtractor::getU16", NM="_ZNK4llvm13DataExtractor6getU16EPjPtj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor6getU16EPjPtj")
  //</editor-fold>
  public /*uint16_t*/ushort$ptr getU16(/*uint32_t P*/uint$ptr offset_ptr, /*uint16_t*/ushort$ptr dst, 
        /*uint32_t*/int count) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Extract a uint32_t value from \a *offset_ptr.
  ///
  /// Extract a single uint32_t from the binary data at the offset
  /// pointed to by \a offset_ptr, and update the offset on success.
  ///
  /// @param[in,out] offset_ptr
  ///     A pointer to an offset within the data that will be advanced
  ///     by the appropriate number of bytes if the value is extracted
  ///     correctly. If the offset is out of bounds or there are not
  ///     enough bytes to extract this value, the offset will be left
  ///     unmodified.
  ///
  /// @return
  ///     The extracted uint32_t value.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::getU32">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp", line = 71,
   FQN="llvm::DataExtractor::getU32", NM="_ZNK4llvm13DataExtractor6getU32EPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor6getU32EPj")
  //</editor-fold>
  public /*uint32_t*/int getU32(/*uint32_t P*/uint$ptr offset_ptr) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Extract \a count uint32_t values from \a *offset_ptr.
  ///
  /// Extract \a count uint32_t values from the binary data at the
  /// offset pointed to by \a offset_ptr, and advance the offset on
  /// success. The extracted values are copied into \a dst.
  ///
  /// @param[in,out] offset_ptr
  ///     A pointer to an offset within the data that will be advanced
  ///     by the appropriate number of bytes if the value is extracted
  ///     correctly. If the offset is out of bounds or there are not
  ///     enough bytes to extract this value, the offset will be left
  ///     unmodified.
  ///
  /// @param[out] dst
  ///     A buffer to copy \a count uint32_t values into. \a dst must
  ///     be large enough to hold all requested data.
  ///
  /// @param[in] count
  ///     The number of uint32_t values to extract.
  ///
  /// @return
  ///     \a dst if all values were properly extracted and copied,
  ///     NULL otherise.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::getU32">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp", line = 75,
   FQN="llvm::DataExtractor::getU32", NM="_ZNK4llvm13DataExtractor6getU32EPjS1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor6getU32EPjS1_j")
  //</editor-fold>
  public /*uint32_t P*/uint$ptr getU32(/*uint32_t P*/uint$ptr offset_ptr, /*uint32_t P*/uint$ptr dst, 
        /*uint32_t*/int count) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Extract a uint64_t value from \a *offset_ptr.
  ///
  /// Extract a single uint64_t from the binary data at the offset
  /// pointed to by \a offset_ptr, and update the offset on success.
  ///
  /// @param[in,out] offset_ptr
  ///     A pointer to an offset within the data that will be advanced
  ///     by the appropriate number of bytes if the value is extracted
  ///     correctly. If the offset is out of bounds or there are not
  ///     enough bytes to extract this value, the offset will be left
  ///     unmodified.
  ///
  /// @return
  ///     The extracted uint64_t value.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::getU64">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp", line = 81,
   FQN="llvm::DataExtractor::getU64", NM="_ZNK4llvm13DataExtractor6getU64EPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor6getU64EPj")
  //</editor-fold>
  public long/*uint64_t*/ getU64(/*uint32_t P*/uint$ptr offset_ptr) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Extract \a count uint64_t values from \a *offset_ptr.
  ///
  /// Extract \a count uint64_t values from the binary data at the
  /// offset pointed to by \a offset_ptr, and advance the offset on
  /// success. The extracted values are copied into \a dst.
  ///
  /// @param[in,out] offset_ptr
  ///     A pointer to an offset within the data that will be advanced
  ///     by the appropriate number of bytes if the value is extracted
  ///     correctly. If the offset is out of bounds or there are not
  ///     enough bytes to extract this value, the offset will be left
  ///     unmodified.
  ///
  /// @param[out] dst
  ///     A buffer to copy \a count uint64_t values into. \a dst must
  ///     be large enough to hold all requested data.
  ///
  /// @param[in] count
  ///     The number of uint64_t values to extract.
  ///
  /// @return
  ///     \a dst if all values were properly extracted and copied,
  ///     NULL otherise.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::getU64">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp", line = 85,
   FQN="llvm::DataExtractor::getU64", NM="_ZNK4llvm13DataExtractor6getU64EPjPyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor6getU64EPjPyj")
  //</editor-fold>
  public ulong$ptr/*uint64_t P*/ getU64(/*uint32_t P*/uint$ptr offset_ptr, ulong$ptr/*uint64_t P*/ dst, 
        /*uint32_t*/int count) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Extract a signed LEB128 value from \a *offset_ptr.
  ///
  /// Extracts an signed LEB128 number from this object's data
  /// starting at the offset pointed to by \a offset_ptr. The offset
  /// pointed to by \a offset_ptr will be updated with the offset of
  /// the byte following the last extracted byte.
  ///
  /// @param[in,out] offset_ptr
  ///     A pointer to an offset within the data that will be advanced
  ///     by the appropriate number of bytes if the value is extracted
  ///     correctly. If the offset is out of bounds or there are not
  ///     enough bytes to extract this value, the offset will be left
  ///     unmodified.
  ///
  /// @return
  ///     The extracted signed integer value.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::getSLEB128">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp", line = 152,
   FQN="llvm::DataExtractor::getSLEB128", NM="_ZNK4llvm13DataExtractor10getSLEB128EPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor10getSLEB128EPj")
  //</editor-fold>
  public long/*int64_t*/ getSLEB128(/*uint32_t P*/uint$ptr offset_ptr) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Extract a unsigned LEB128 value from \a *offset_ptr.
  ///
  /// Extracts an unsigned LEB128 number from this object's data
  /// starting at the offset pointed to by \a offset_ptr. The offset
  /// pointed to by \a offset_ptr will be updated with the offset of
  /// the byte following the last extracted byte.
  ///
  /// @param[in,out] offset_ptr
  ///     A pointer to an offset within the data that will be advanced
  ///     by the appropriate number of bytes if the value is extracted
  ///     correctly. If the offset is out of bounds or there are not
  ///     enough bytes to extract this value, the offset will be left
  ///     unmodified.
  ///
  /// @return
  ///     The extracted unsigned integer value.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::getULEB128">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp", line = 131,
   FQN="llvm::DataExtractor::getULEB128", NM="_ZNK4llvm13DataExtractor10getULEB128EPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor10getULEB128EPj")
  //</editor-fold>
  public long/*uint64_t*/ getULEB128(/*uint32_t P*/uint$ptr offset_ptr) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test the validity of \a offset.
  ///
  /// @return
  ///     \b true if \a offset is a valid offset into the data in this
  ///     object, \b false otherwise.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::isValidOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DataExtractor.h", line = 340,
   FQN="llvm::DataExtractor::isValidOffset", NM="_ZNK4llvm13DataExtractor13isValidOffsetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor13isValidOffsetEj")
  //</editor-fold>
  public boolean isValidOffset(/*uint32_t*/int offset) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test the availability of \a length bytes of data from \a offset.
  ///
  /// @return
  ///     \b true if \a offset is a valid offset and there are \a
  ///     length bytes available at that offset, \b false otherwise.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::isValidOffsetForDataOfSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DataExtractor.h", line = 347,
   FQN="llvm::DataExtractor::isValidOffsetForDataOfSize", NM="_ZNK4llvm13DataExtractor26isValidOffsetForDataOfSizeEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor26isValidOffsetForDataOfSizeEjj")
  //</editor-fold>
  public boolean isValidOffsetForDataOfSize(/*uint32_t*/int offset, /*uint32_t*/int length) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test the availability of enough bytes of data for a pointer from
  /// \a offset. The size of a pointer is \a getAddressSize().
  ///
  /// @return
  ///     \b true if \a offset is a valid offset and there are enough
  ///     bytes for a pointer available at that offset, \b false
  ///     otherwise.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::isValidOffsetForAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DataExtractor.h", line = 358,
   FQN="llvm::DataExtractor::isValidOffsetForAddress", NM="_ZNK4llvm13DataExtractor23isValidOffsetForAddressEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/DataExtractor.cpp -nm=_ZNK4llvm13DataExtractor23isValidOffsetForAddressEj")
  //</editor-fold>
  public boolean isValidOffsetForAddress(/*uint32_t*/int offset) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::DataExtractor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DataExtractor.h", line = 17,
   FQN="llvm::DataExtractor::DataExtractor", NM="_ZN4llvm13DataExtractorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm13DataExtractorC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DataExtractor(final /*const*/ DataExtractor /*&*/ $Prm0) {
    // : Data(.Data), IsLittleEndian(.IsLittleEndian), AddressSize(.AddressSize) 
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DataExtractor::DataExtractor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DataExtractor.h", line = 17,
   FQN="llvm::DataExtractor::DataExtractor", NM="_ZN4llvm13DataExtractorC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm13DataExtractorC1EOS0_")
  //</editor-fold>
  public /*inline*/ DataExtractor(JD$Move _dparam, final DataExtractor /*&&*/$Prm0) {
    // : Data(static_cast<DataExtractor &&>().Data), IsLittleEndian(static_cast<DataExtractor &&>().IsLittleEndian), AddressSize(static_cast<DataExtractor &&>().AddressSize) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Data=" + Data // NOI18N
              + ", IsLittleEndian=" + $uchar2uint(IsLittleEndian) // NOI18N
              + ", AddressSize=" + $uchar2uint(AddressSize); // NOI18N
  }
}
