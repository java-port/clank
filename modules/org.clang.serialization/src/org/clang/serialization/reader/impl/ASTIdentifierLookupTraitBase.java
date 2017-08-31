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

package org.clang.serialization.reader.impl;

import org.clank.java.*;
import static org.clank.java.std_pair.wrap_uint_uint_pair;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.sizeof$uint16;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.support.llvm.support.endian;
import org.llvm.support.llvm.support.endianness;
import static org.llvm.support.llvm.support.unaligned;


/// \brief Base class for the trait describing the on-disk hash table for the
/// identifiers in an AST file.
///
/// This class is not useful by itself; rather, it provides common
/// functionality for accessing the on-disk hash table of identifiers
/// in an AST file. Different subclasses customize that functionality
/// based on what information they are interested in. Those subclasses
/// must provide the \c data_type typedef and the ReadData operation,
/// only.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTIdentifierLookupTraitBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 137,
 FQN="clang::serialization::reader::ASTIdentifierLookupTraitBase", NM="_ZN5clang13serialization6reader28ASTIdentifierLookupTraitBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader28ASTIdentifierLookupTraitBaseE")
//</editor-fold>
public class ASTIdentifierLookupTraitBase<data_type> implements OnDiskChainedHashTable.InfoInterface<StringRef, StringRef, data_type> {
/*public:*/
  // JAVA: typedef StringRef external_key_type
//  public final class external_key_type extends StringRef{ };
  // JAVA: typedef StringRef internal_key_type
//  public final class internal_key_type extends StringRef{ };
  // JAVA: typedef unsigned int hash_value_type;
  // JAVA: typedef unsigned int offset_type;
  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTIdentifierLookupTraitBase::EqualKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 144,
   FQN="clang::serialization::reader::ASTIdentifierLookupTraitBase::EqualKey", NM="_ZN5clang13serialization6reader28ASTIdentifierLookupTraitBase8EqualKeyERKN4llvm9StringRefES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader28ASTIdentifierLookupTraitBase8EqualKeyERKN4llvm9StringRefES6_")
  //</editor-fold>
  @Override public final boolean EqualKey(final /*const*/ StringRef /*&*/ a, final /*const*/ StringRef /*&*/ b) {
    return $eq_StringRef(/*NO_COPY*/a, /*NO_COPY*/b);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTIdentifierLookupTraitBase::ComputeHash">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 736,
   FQN="clang::serialization::reader::ASTIdentifierLookupTraitBase::ComputeHash", NM="_ZN5clang13serialization6reader28ASTIdentifierLookupTraitBase11ComputeHashERKN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader28ASTIdentifierLookupTraitBase11ComputeHashERKN4llvm9StringRefE")
  //</editor-fold>
  @Override public /*uint*/int ComputeHash(final /*const*/ StringRef /*&*/ a) {
    return $ComputeHash(a);
  }
  
  // This hopefully will just get inlined and removed by the optimizer.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTIdentifierLookupTraitBase::GetInternalKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 154,
   FQN="clang::serialization::reader::ASTIdentifierLookupTraitBase::GetInternalKey", NM="_ZN5clang13serialization6reader28ASTIdentifierLookupTraitBase14GetInternalKeyERKN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader28ASTIdentifierLookupTraitBase14GetInternalKeyERKN4llvm9StringRefE")
  //</editor-fold>
  @Override public final /*const*/ StringRef /*&*/ GetInternalKey(final /*const*/ StringRef /*&*/ x) {
    return x;
  }

  
  // This hopefully will just get inlined and removed by the optimizer.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTIdentifierLookupTraitBase::GetExternalKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 158,
   FQN="clang::serialization::reader::ASTIdentifierLookupTraitBase::GetExternalKey", NM="_ZN5clang13serialization6reader28ASTIdentifierLookupTraitBase14GetExternalKeyERKN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader28ASTIdentifierLookupTraitBase14GetExternalKeyERKN4llvm9StringRefE")
  //</editor-fold>
  @Override public final /*const*/ StringRef /*&*/ GetExternalKey(final /*const*/ StringRef /*&*/ x) {
    return x;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTIdentifierLookupTraitBase::ReadKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*removed static; added OffsetInBuf*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 748,
   FQN="clang::serialization::reader::ASTIdentifierLookupTraitBase::ReadKey", NM="_ZN5clang13serialization6reader28ASTIdentifierLookupTraitBase7ReadKeyEPKhj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader28ASTIdentifierLookupTraitBase7ReadKeyEPKhj")
  //</editor-fold>
  @Override public final StringRef ReadKey(/*const*/char$ptr/*uchar P*/ Buf, int OffsetInBuf, /*uint*/int KeyLength) {
    // copied from ReadKey and adjusted with OffsetInBuf
    assert ($greatereq_uint(KeyLength, 2) && $uchar2int(Buf.$at(OffsetInBuf + KeyLength - 1)) == $$TERM);
    return new StringRef(Buf.$add(OffsetInBuf), KeyLength - 1);
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTIdentifierLookupTraitBase::ASTIdentifierLookupTraitBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 137,
   FQN="clang::serialization::reader::ASTIdentifierLookupTraitBase::ASTIdentifierLookupTraitBase", NM="_ZN5clang13serialization6reader28ASTIdentifierLookupTraitBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader28ASTIdentifierLookupTraitBaseC1Ev")
  //</editor-fold>
  public /*inline*/ ASTIdentifierLookupTraitBase() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTIdentifierLookupTraitBase::ASTIdentifierLookupTraitBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 137,
   FQN="clang::serialization::reader::ASTIdentifierLookupTraitBase::ASTIdentifierLookupTraitBase", NM="_ZN5clang13serialization6reader28ASTIdentifierLookupTraitBaseC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader28ASTIdentifierLookupTraitBaseC1ERKS2_")
  //</editor-fold>
  public /*inline*/ ASTIdentifierLookupTraitBase(final /*const*/ ASTIdentifierLookupTraitBase /*&*/ $Prm0) {
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public final long ReadKeyDataLength(char$ptr Buf, int OffsetInBuf) {
    // copied from ReadKeyDataLength and replaced readNext by read
    /*uint*/int DataLen = $ushort2uint(endian.read_uint16(endianness.little, 1, Buf, OffsetInBuf));
                                              OffsetInBuf+=sizeof$uint16();
    /*uint*/int KeyLen = $ushort2uint(endian.read_uint16(endianness.little, 1, Buf, OffsetInBuf));
    return wrap_uint_uint_pair(KeyLen, DataLen);
  }

  @Override
  public final int getReadKeyDataLengthBytes() {
    return sizeof$uint16()*2;
  }
  
  public static /*uint*/int $ComputeHash(final /*const*/ StringRef /*&*/ a) {
    return llvm.HashString(a);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
