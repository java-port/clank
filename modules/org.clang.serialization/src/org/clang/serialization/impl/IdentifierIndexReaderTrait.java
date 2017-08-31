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

package org.clang.serialization.impl;

import static org.clank.java.std_pair.wrap_uint_uint_pair;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import org.llvm.support.OnDiskChainedHashTable.InfoInterface;
import static org.llvm.support.llvm.$eq_StringRef;
import org.llvm.support.llvm.support;
import org.llvm.support.llvm.support.endian;
import org.llvm.support.llvm.support.endianness;


/// \brief Trait used to read the identifier index from the on-disk hash
/// table.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IdentifierIndexReaderTrait">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 71,
 FQN="(anonymous namespace)::IdentifierIndexReaderTrait", NM="_ZN12_GLOBAL__N_126IdentifierIndexReaderTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_126IdentifierIndexReaderTraitE")
//</editor-fold>
public class IdentifierIndexReaderTrait implements InfoInterface<StringRef, StringRef, SmallVectorUInt>{
/*public:*/
  // JAVA: typedef StringRef external_key_type
//  public final class external_key_type extends StringRef{ };
  // JAVA: typedef StringRef internal_key_type
//  public final class internal_key_type extends StringRef{ };
  // JAVA: typedef SmallVector<unsigned int, 2> data_type
//  public final class data_type extends SmallVectorUInt{ };
  // JAVA: typedef unsigned int hash_value_type;
  // JAVA: typedef unsigned int offset_type;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IdentifierIndexReaderTrait::EqualKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 79,
   FQN="(anonymous namespace)::IdentifierIndexReaderTrait::EqualKey", NM="_ZN12_GLOBAL__N_126IdentifierIndexReaderTrait8EqualKeyERKN4llvm9StringRefES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_126IdentifierIndexReaderTrait8EqualKeyERKN4llvm9StringRefES4_")
  //</editor-fold>
  @Override public final boolean EqualKey(final /*const*/ StringRef /*&*/ a, final /*const*/ StringRef /*&*/ b) {
    return $eq_StringRef(/*NO_COPY*/a, /*NO_COPY*/b);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IdentifierIndexReaderTrait::ComputeHash">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 83,
   FQN="(anonymous namespace)::IdentifierIndexReaderTrait::ComputeHash", NM="_ZN12_GLOBAL__N_126IdentifierIndexReaderTrait11ComputeHashERKN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_126IdentifierIndexReaderTrait11ComputeHashERKN4llvm9StringRefE")
  //</editor-fold>
  @Override public final /*uint*/int ComputeHash(final /*const*/ StringRef /*&*/ a) {
    return llvm.HashString(new StringRef(a));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IdentifierIndexReaderTrait::ReadKeyDataLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 87,
   FQN="(anonymous namespace)::IdentifierIndexReaderTrait::ReadKeyDataLength", NM="_ZN12_GLOBAL__N_126IdentifierIndexReaderTrait17ReadKeyDataLengthERPKh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_126IdentifierIndexReaderTrait17ReadKeyDataLengthERPKh")
  //</editor-fold>
  @Override public final /*std.pair<uint, uint>*/long ReadKeyDataLength(final char$ptr/*const uchar P&*/ Buf, int OffsetInBuf) {
    //JAVA: using namespace llvm::support;
    /*uint*/int KeyLen = $ushort2uint(endian.read_uint16(endianness.little, 1, Buf, OffsetInBuf));
                        OffsetInBuf += NativeType.sizeof$uint16();
    /*uint*/int DataLen = $ushort2uint(endian.read_uint16(endianness.little, 1, Buf, OffsetInBuf));
    return wrap_uint_uint_pair(KeyLen, DataLen);
  }
  @Override public final /*uint*/int getReadKeyDataLengthBytes() {
    return NativeType.sizeof$uint16() + NativeType.sizeof$uint16();
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IdentifierIndexReaderTrait::GetInternalKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 95,
   FQN="(anonymous namespace)::IdentifierIndexReaderTrait::GetInternalKey", NM="_ZN12_GLOBAL__N_126IdentifierIndexReaderTrait14GetInternalKeyERKN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_126IdentifierIndexReaderTrait14GetInternalKeyERKN4llvm9StringRefE")
  //</editor-fold>
  @Override public final /*const*/ StringRef /*&*/ GetInternalKey(final /*const*/ StringRef /*&*/ x) {
    return x;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IdentifierIndexReaderTrait::GetExternalKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 98,
   FQN="(anonymous namespace)::IdentifierIndexReaderTrait::GetExternalKey", NM="_ZN12_GLOBAL__N_126IdentifierIndexReaderTrait14GetExternalKeyERKN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_126IdentifierIndexReaderTrait14GetExternalKeyERKN4llvm9StringRefE")
  //</editor-fold>
  @Override public final /*const*/ StringRef /*&*/ GetExternalKey(final /*const*/ StringRef /*&*/ x) {
    return x;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IdentifierIndexReaderTrait::ReadKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*removed static; added OffsetInBuf*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 101,
   FQN="(anonymous namespace)::IdentifierIndexReaderTrait::ReadKey", NM="_ZN12_GLOBAL__N_126IdentifierIndexReaderTrait7ReadKeyEPKhj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_126IdentifierIndexReaderTrait7ReadKeyEPKhj")
  //</editor-fold>
  @Override public final StringRef ReadKey(/*const*/char$ptr/*uchar P*/ Buf, int OffsetInBuf, /*uint*/int KeyLength) {
    // JAVA
    return new StringRef(Buf.$add(OffsetInBuf), KeyLength);
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IdentifierIndexReaderTrait::ReadData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*removed static; added OffsetInBuf*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 105,
   FQN="(anonymous namespace)::IdentifierIndexReaderTrait::ReadData", NM="_ZN12_GLOBAL__N_126IdentifierIndexReaderTrait8ReadDataERKN4llvm9StringRefEPKhj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_126IdentifierIndexReaderTrait8ReadDataERKN4llvm9StringRefEPKhj")
  //</editor-fold>
  @Override public final SmallVectorUInt ReadData(final /*const*/ StringRef /*&*/ k, 
          /*const*/char$ptr/*uchar P*/ Buf, int OffsetInBuf,
          /*uint*/int DataLen) {
    //JAVA: using namespace llvm::support;
    
    SmallVectorUInt Result/*J*/= new SmallVectorUInt(2, 0);
    while ($greater_uint(DataLen, 0)) {
      /*uint*/int ID = endian.read_uint32(endianness.little, support.unaligned, Buf, OffsetInBuf);
                            OffsetInBuf += NativeType.sizeof$uint32();
      Result.push_back(ID);
      DataLen -= 4;
    }
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IdentifierIndexReaderTrait::IdentifierIndexReaderTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 71,
   FQN="(anonymous namespace)::IdentifierIndexReaderTrait::IdentifierIndexReaderTrait", NM="_ZN12_GLOBAL__N_126IdentifierIndexReaderTraitC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_126IdentifierIndexReaderTraitC1ERKS0_")
  //</editor-fold>
  public /*inline*/ IdentifierIndexReaderTrait(final /*const*/ IdentifierIndexReaderTrait /*&*/ $Prm0) {
  }
  
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final IdentifierIndexReaderTrait $Trait = new IdentifierIndexReaderTrait();
  public static IdentifierIndexReaderTrait $Trait() {
    return $Trait;
  }
  
  private IdentifierIndexReaderTrait() {
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
