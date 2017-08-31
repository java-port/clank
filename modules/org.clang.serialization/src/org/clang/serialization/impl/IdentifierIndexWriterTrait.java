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

import org.clank.java.*;
import static org.clank.java.std_pair.wrap_uint_uint_pair;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import org.llvm.support.OnDiskChainedHashTableGenerator.EmitInfoInterface;
import org.llvm.support.endian.Writer;
import static org.llvm.support.llvm.support.endianness.little;


/// \brief Trait used to generate the identifier index as an on-disk hash
/// table.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IdentifierIndexWriterTrait">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 651,
 FQN="(anonymous namespace)::IdentifierIndexWriterTrait", NM="_ZN12_GLOBAL__N_126IdentifierIndexWriterTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_126IdentifierIndexWriterTraitE")
//</editor-fold>
public class IdentifierIndexWriterTrait implements EmitInfoInterface<StringRef, SmallVectorUInt, Void/*unused*/> {
/*public:*/
  // JAVA: typedef StringRef key_type
//  public final class key_type extends StringRef{ };
  // JAVA: typedef StringRef key_type_ref
//  public final class key_type_ref extends StringRef{ };
  // JAVA: typedef SmallVector<unsigned int, 2> data_type
//  public final class data_type extends SmallVectorUInt{ };
  // JAVA: typedef const SmallVector<unsigned int, 2> &data_type_ref
//  public final class data_type_ref extends /*const*/SmallVectorUInt /*&*/{ };
  // JAVA: typedef unsigned int hash_value_type;
  // JAVA: typedef unsigned int offset_type;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IdentifierIndexWriterTrait::ComputeHash">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 660,
   FQN="(anonymous namespace)::IdentifierIndexWriterTrait::ComputeHash", NM="_ZN12_GLOBAL__N_126IdentifierIndexWriterTrait11ComputeHashEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_126IdentifierIndexWriterTrait11ComputeHashEN4llvm9StringRefE")
  //</editor-fold>
  @Override public /*uint*/int ComputeHash(StringRef Key) {
    return llvm.HashString(new StringRef(Key));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IdentifierIndexWriterTrait::EmitKeyDataLength">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 664,
   FQN="(anonymous namespace)::IdentifierIndexWriterTrait::EmitKeyDataLength", NM="_ZN12_GLOBAL__N_126IdentifierIndexWriterTrait17EmitKeyDataLengthERN4llvm11raw_ostreamENS1_9StringRefERKNS1_11SmallVectorIjLj2EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_126IdentifierIndexWriterTrait17EmitKeyDataLengthERN4llvm11raw_ostreamENS1_9StringRefERKNS1_11SmallVectorIjLj2EEE")
  //</editor-fold>
  @Override public std.pairUIntUInt EmitKeyDataLength(final raw_ostream /*&*/ Out, StringRef Key, final /*const*/SmallVectorUInt /*&*/ Data) {
    throw new UnsupportedOperationException("EmitKeyDataLength$WrapPair must be used");
  }  
  @Override public /*std.pair<uint, uint>*/long EmitKeyDataLength$WrapPair(final raw_ostream /*&*/ Out, StringRef Key, final /*const*/SmallVectorUInt /*&*/ Data) {
    //JAVA: using namespace llvm::support;
    Writer LE/*J*/= new Writer(little, Out);
    /*uint*/int KeyLen = Key.size();
    /*uint*/int DataLen = Data.size() * 4;
    LE.write_uint16($uint2ushort(KeyLen));
    LE.write_uint16($uint2ushort(DataLen));
    return wrap_uint_uint_pair(KeyLen, DataLen);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IdentifierIndexWriterTrait::EmitKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 675,
   FQN="(anonymous namespace)::IdentifierIndexWriterTrait::EmitKey", NM="_ZN12_GLOBAL__N_126IdentifierIndexWriterTrait7EmitKeyERN4llvm11raw_ostreamENS1_9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_126IdentifierIndexWriterTrait7EmitKeyERN4llvm11raw_ostreamENS1_9StringRefEj")
  //</editor-fold>
  @Override public void EmitKey(final raw_ostream /*&*/ Out, StringRef Key, /*uint*/int KeyLen) {
    Out.write(Key.data(), KeyLen);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IdentifierIndexWriterTrait::EmitData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 679,
   FQN="(anonymous namespace)::IdentifierIndexWriterTrait::EmitData", NM="_ZN12_GLOBAL__N_126IdentifierIndexWriterTrait8EmitDataERN4llvm11raw_ostreamENS1_9StringRefERKNS1_11SmallVectorIjLj2EEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_126IdentifierIndexWriterTrait8EmitDataERN4llvm11raw_ostreamENS1_9StringRefERKNS1_11SmallVectorIjLj2EEEj")
  //</editor-fold>
  @Override public void EmitData(final raw_ostream /*&*/ Out, StringRef Key, final /*const*/SmallVectorUInt /*&*/ Data, 
          /*uint*/int DataLen) {
    //JAVA: using namespace llvm::support;
    for (/*uint*/int I = 0, N = Data.size(); I != N; ++I)  {
      new Writer(little, Out).write_uint32(Data.$at$Const(I));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IdentifierIndexWriterTrait::IdentifierIndexWriterTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 651,
   FQN="(anonymous namespace)::IdentifierIndexWriterTrait::IdentifierIndexWriterTrait", NM="_ZN12_GLOBAL__N_126IdentifierIndexWriterTraitC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_126IdentifierIndexWriterTraitC1Ev")
  //</editor-fold>
  public /*inline*/ IdentifierIndexWriterTrait() {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
