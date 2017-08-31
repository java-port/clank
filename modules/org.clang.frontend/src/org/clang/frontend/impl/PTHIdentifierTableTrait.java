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
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.support.endian.*;
import static org.llvm.support.llvm.support.endianness.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHIdentifierTableTrait">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 610,
 FQN="(anonymous namespace)::PTHIdentifierTableTrait", NM="_ZN12_GLOBAL__N_123PTHIdentifierTableTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_123PTHIdentifierTableTraitE")
//</editor-fold>
public class PTHIdentifierTableTrait implements OnDiskChainedHashTableGenerator.EmitInfoInterface<PTHIdKey, Integer, Void/*unused*/> {
/*public:*/
  /*typedef PTHIdKey *key_type*/
//  public final class key_type extends PTHIdKey /*P*/ { };
  /*typedef key_type key_type_ref*/
//  public final class key_type_ref extends PTHIdKey /*P*/ { };
  
  /*typedef uint32_t data_type*/;
  /*typedef data_type data_type_ref*/;
  
  /*typedef unsigned int hash_value_type*/;
  /*typedef unsigned int offset_type*/;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHIdentifierTableTrait::ComputeHash">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*virtual vs. static*/,
   optimized = Converted.Optimization.COMPLEX,      
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 621,
   FQN="(anonymous namespace)::PTHIdentifierTableTrait::ComputeHash", NM="_ZN12_GLOBAL__N_123PTHIdentifierTableTrait11ComputeHashEPNS_8PTHIdKeyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_123PTHIdentifierTableTrait11ComputeHashEPNS_8PTHIdKeyE")
  //</editor-fold>
  @Override
  public /*uint*/int ComputeHash(PTHIdKey /*P*/ key) {
    // JAVA: optimized
    StringMapEntryBase entry = key.II.getEntry();
    return llvm.HashString(entry.getKeyArray(), entry.getKeyArrayIndex(), entry.getKeyLength());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHIdentifierTableTrait::EmitKeyDataLength">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*virtual vs. static*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 625,
   FQN="(anonymous namespace)::PTHIdentifierTableTrait::EmitKeyDataLength", NM="_ZN12_GLOBAL__N_123PTHIdentifierTableTrait17EmitKeyDataLengthERN4llvm11raw_ostreamEPKNS_8PTHIdKeyEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_123PTHIdentifierTableTrait17EmitKeyDataLengthERN4llvm11raw_ostreamEPKNS_8PTHIdKeyEj")
  //</editor-fold>
  @Override
  public /*std.pair<uint, uint>*/long EmitKeyDataLength$WrapPair(raw_ostream /*&*/ Out, /*const*/ PTHIdKey /*P*/ key, /*uint32_t*/Integer $Prm2) {
    //JAVA: using namespace llvm::support;
    /*uint*/int n = key.II.getLength() + 1;
    new Writer(little, Out).write_uint16(n);
    return wrap_uint_uint_pair(n, $sizeof_UInt());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHIdentifierTableTrait::EmitKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*virtual vs. static*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 633,
   FQN="(anonymous namespace)::PTHIdentifierTableTrait::EmitKey", NM="_ZN12_GLOBAL__N_123PTHIdentifierTableTrait7EmitKeyERN4llvm11raw_ostreamEPNS_8PTHIdKeyEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_123PTHIdentifierTableTrait7EmitKeyERN4llvm11raw_ostreamEPNS_8PTHIdKeyEj")
  //</editor-fold>
  @Override
  public void EmitKey(raw_ostream /*&*/ Out, PTHIdKey /*P*/ key, /*uint*/int n) {
    // Record the location of the key data.  This is used when generating
    // the mapping from persistent IDs to strings.
    key.FileOffset = $ulong2uint(Out.tell());
    Out.write(key.II.getNameStart(), n);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHIdentifierTableTrait::EmitData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*virtual vs. static*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 640,
   FQN="(anonymous namespace)::PTHIdentifierTableTrait::EmitData", NM="_ZN12_GLOBAL__N_123PTHIdentifierTableTrait8EmitDataERN4llvm11raw_ostreamEPNS_8PTHIdKeyEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_123PTHIdentifierTableTrait8EmitDataERN4llvm11raw_ostreamEPNS_8PTHIdKeyEjj")
  //</editor-fold>
  @Override
  public void EmitData(raw_ostream /*&*/ Out, PTHIdKey /*P*/ $Prm1, /*uint32_t*/Integer pID, 
          /*uint*/int $Prm3) {
    //JAVA: using namespace llvm::support;
    new Writer(little, Out).write_uint32(pID);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHIdentifierTableTrait::PTHIdentifierTableTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 610,
   FQN="(anonymous namespace)::PTHIdentifierTableTrait::PTHIdentifierTableTrait", NM="_ZN12_GLOBAL__N_123PTHIdentifierTableTraitC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_123PTHIdentifierTableTraitC1Ev")
  //</editor-fold>
  public /*inline*/ PTHIdentifierTableTrait() {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }  
}
