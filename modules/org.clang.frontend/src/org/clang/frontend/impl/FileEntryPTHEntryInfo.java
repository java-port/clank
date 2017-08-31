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

package org.clang.frontend.impl;

import org.clank.support.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.support.endian.*;
import static org.llvm.support.llvm.support.endianness.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileEntryPTHEntryInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 113,
 FQN="(anonymous namespace)::FileEntryPTHEntryInfo", NM="_ZN12_GLOBAL__N_121FileEntryPTHEntryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_121FileEntryPTHEntryInfoE")
//</editor-fold>
public class FileEntryPTHEntryInfo implements OnDiskChainedHashTableGenerator.EmitInfoInterface<PTHEntryKeyVariant,PTHEntry, Void/*unused*/> {
/*public:*/
  /*typedef PTHEntryKeyVariant key_type*/
//  public final class key_type extends PTHEntryKeyVariant{ };
  /*typedef key_type key_type_ref*/
//  public final class key_type_ref extends PTHEntryKeyVariant{ };
  
  /*typedef PTHEntry data_type*/
//  public final class data_type extends PTHEntry{ };
  /*typedef const PTHEntry &data_type_ref*/
//  public final class data_type_ref extends /*const*/ PTHEntry /*&*/ { };
  
  /*typedef unsigned int hash_value_type*/;
  /*typedef unsigned int offset_type*/;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileEntryPTHEntryInfo::ComputeHash">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*virtual vs. static*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 124,
   FQN="(anonymous namespace)::FileEntryPTHEntryInfo::ComputeHash", NM="_ZN12_GLOBAL__N_121FileEntryPTHEntryInfo11ComputeHashENS_18PTHEntryKeyVariantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_121FileEntryPTHEntryInfo11ComputeHashENS_18PTHEntryKeyVariantE")
  //</editor-fold>
  @Override
  public /*uint*/int ComputeHash(PTHEntryKeyVariant V) {
    return llvm.HashString(V.getString());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileEntryPTHEntryInfo::EmitKeyDataLength">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*virtual vs. static*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 128,
   FQN="(anonymous namespace)::FileEntryPTHEntryInfo::EmitKeyDataLength", NM="_ZN12_GLOBAL__N_121FileEntryPTHEntryInfo17EmitKeyDataLengthERN4llvm11raw_ostreamENS_18PTHEntryKeyVariantERKNS_8PTHEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_121FileEntryPTHEntryInfo17EmitKeyDataLengthERN4llvm11raw_ostreamENS_18PTHEntryKeyVariantERKNS_8PTHEntryE")
  //</editor-fold>
  @Override
  public /*std.pair<uint, uint>*/long EmitKeyDataLength$WrapPair(raw_ostream /*&*/ Out, PTHEntryKeyVariant V, 
                   /*const*/ PTHEntry /*&*/ E) {
    //JAVA: using namespace llvm::support;
    Writer LE/*J*/= new Writer(little, Out);
    
    /*uint*/int n = V.getString().size() + 1 + 1;
    LE.write_uint16($uint2ushort(n));
    
    /*uint*/int m = V.getRepresentationLength() + (V.isFile() ? 4 + 4 : 0);
    LE.write_uint8($uint2uchar(m));
    
    return wrap_uint_uint_pair(n, m);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileEntryPTHEntryInfo::EmitKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*virtual vs. static*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 143,
   FQN="(anonymous namespace)::FileEntryPTHEntryInfo::EmitKey", NM="_ZN12_GLOBAL__N_121FileEntryPTHEntryInfo7EmitKeyERN4llvm11raw_ostreamENS_18PTHEntryKeyVariantEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_121FileEntryPTHEntryInfo7EmitKeyERN4llvm11raw_ostreamENS_18PTHEntryKeyVariantEj")
  //</editor-fold>
  @Override
  public void EmitKey(raw_ostream /*&*/ Out, PTHEntryKeyVariant V, /*uint*/int n) {
    //JAVA: using namespace llvm::support;
    // Emit the entry kind.
    new Writer(little, Out).write_uint8((/*uchar*/byte)V.getKind());
    // Emit the string.
    Out.write(V.getString().data(), n - 1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileEntryPTHEntryInfo::EmitData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*virtual vs. static*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 151,
   FQN="(anonymous namespace)::FileEntryPTHEntryInfo::EmitData", NM="_ZN12_GLOBAL__N_121FileEntryPTHEntryInfo8EmitDataERN4llvm11raw_ostreamENS_18PTHEntryKeyVariantERKNS_8PTHEntryEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_121FileEntryPTHEntryInfo8EmitDataERN4llvm11raw_ostreamENS_18PTHEntryKeyVariantERKNS_8PTHEntryEj")
  //</editor-fold>
  @Override
  public void EmitData(raw_ostream /*&*/ Out, PTHEntryKeyVariant V, 
          /*const*/ PTHEntry /*&*/ E, /*uint*/int $Prm3) {
    //JAVA: using namespace llvm::support;
    Writer LE/*J*/= new Writer(little, Out);
    
    // For file entries emit the offsets into the PTH file for token data
    // and the preprocessor blocks table.
    if (V.isFile()) {
      LE.write_uint32(E.getTokenOffset());
      LE.write_uint32(E.getPPCondTableOffset());
    }
    
    // Emit any other data associated with the key (i.e., stat information).
    V.EmitData(Out);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileEntryPTHEntryInfo::FileEntryPTHEntryInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 113,
   FQN="(anonymous namespace)::FileEntryPTHEntryInfo::FileEntryPTHEntryInfo", NM="_ZN12_GLOBAL__N_121FileEntryPTHEntryInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_121FileEntryPTHEntryInfoC1Ev")
  //</editor-fold>
  public /*inline*/ FileEntryPTHEntryInfo() {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
