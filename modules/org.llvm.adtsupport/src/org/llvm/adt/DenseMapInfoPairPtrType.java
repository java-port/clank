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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", line = 136,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", old_line = 133,
 FQN = "llvm::DenseMapInfo<pair<type-parameter-0-0, type-parameter-0-1> >", NM = "_ZN4llvm12DenseMapInfoISt4pairIT_T0_EEE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZN4llvm12DenseMapInfoISt4pairIT_T0_EEE")
//</editor-fold>
public class/*struct*/ DenseMapInfoPairPtrType<T, U> implements DenseMapInfo<std.pairPtrType<T, U>> {
  
  private final DenseMapInfo<T> FirstInfo;
  
  private final DenseMapInfo<U> SecondInfo;
  
  private final std.pairPtrType emptyKey;
  private final std.pairPtrType tombstoneKey;

  public DenseMapInfoPairPtrType(DenseMapInfo<T> FirstInfo, DenseMapInfo<U> SecondInfo) {
    this.FirstInfo = FirstInfo;
    this.SecondInfo = SecondInfo;
    this.emptyKey = std.make_pair_Ptr_T(FirstInfo.getEmptyKey(), SecondInfo.getEmptyKey());
    this.tombstoneKey = std.make_pair_Ptr_T(FirstInfo.getTombstoneKey(), SecondInfo.getTombstoneKey());
    assert (emptyKey.first != null) && (emptyKey.second != null) : "emptyKey marker must not have nulls";
    assert (tombstoneKey.first != null) && (tombstoneKey.second != null) : "tombstoneKey marker must not have nulls";    
    assert !((this.tombstoneKey.first == this.emptyKey.first) && (this.tombstoneKey.second == this.emptyKey.second)) : "emptyKey [" + this.emptyKey + "] must be different from tombstoneKey [" + this.tombstoneKey + "]";
  }

  /*typedef std::pair<T, U> Pair*/
//  public final class Pair extends std.pair<T, U>{ };
  /*typedef DenseMapInfo<T> FirstInfo*/
//  public final class FirstInfo extends DenseMapInfo<T>{ };
  /*typedef DenseMapInfo<U> SecondInfo*/
//  public final class SecondInfo extends DenseMapInfo<U>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<pair<type-parameter-0-0, type-parameter-0-1> >::getEmptyKey">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", line = 142,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", old_line = 139,
   FQN = "llvm::DenseMapInfo<pair<type-parameter-0-0, type-parameter-0-1> >::getEmptyKey", NM = "_ZN4llvm12DenseMapInfoISt4pairIT_T0_EE11getEmptyKeyEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZN4llvm12DenseMapInfoISt4pairIT_T0_EE11getEmptyKeyEvtype-parameter-0-1> >::getEmptyKey")
  //</editor-fold>
  @Override
  public /*inline*/ Object getEmptyKey() {
    return emptyKey;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<pair<type-parameter-0-0, type-parameter-0-1> >::getTombstoneKey">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", line = 146,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", old_line = 143,
   FQN = "llvm::DenseMapInfo<pair<type-parameter-0-0, type-parameter-0-1> >::getTombstoneKey", NM = "_ZN4llvm12DenseMapInfoISt4pairIT_T0_EE15getTombstoneKeyEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZN4llvm12DenseMapInfoISt4pairIT_T0_EE15getTombstoneKeyEvtype-parameter-0-1> >::getTombstoneKey")
  //</editor-fold>
  @Override
  public /*inline*/ Object getTombstoneKey() {
    return tombstoneKey;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<pair<type-parameter-0-0, type-parameter-0-1> >::getHashValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", line = 150,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", old_line = 147,
   FQN = "llvm::DenseMapInfo<pair<type-parameter-0-0, type-parameter-0-1> >::getHashValue", NM = "_ZN4llvm12DenseMapInfoISt4pairIT_T0_EE12getHashValueERKS4_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZN4llvm12DenseMapInfoISt4pairIT_T0_EE12getHashValueERKS4_type-parameter-0-1> >::getHashValue")
  //</editor-fold>
  @Override
  public /*uint*/int getHashValue(/*const*/std.pairPtrType<T, U> /*&*/ PairVal) {
    assert PairVal != emptyKey : "must not be called for emptyKey";
    assert PairVal != tombstoneKey : "must not be called for tombstoneKey";
    return combineTwoHashes(FirstInfo.getHashValue(PairVal.first), SecondInfo.getHashValue(PairVal.second));
  }

  public static int combineTwoHashes(final int firstHash, final int secondHash) {
    long/*uint64_t*/ key = ((long/*uint64_t*/)firstHash) << 32
            | ($uint2ulong(secondHash));
    key += ~(key << 32);
    key ^= (key >>> 22);
    key += ~(key << 13);
    key ^= (key >>> 8);
    key += (key << 3);
    key ^= (key >>> 15);
    key += ~(key << 27);
    key ^= (key >>> 31);
    return (/*uint*/int)key;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<pair<type-parameter-0-0, type-parameter-0-1> >::isEqual">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", line = 163,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", old_line = 160,
   FQN = "llvm::DenseMapInfo<pair<type-parameter-0-0, type-parameter-0-1> >::isEqual", NM = "_ZN4llvm12DenseMapInfoISt4pairIT_T0_EE7isEqualERKS4_S7_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZN4llvm12DenseMapInfoISt4pairIT_T0_EE7isEqualERKS4_S7_type-parameter-0-1> >::isEqual")
  //</editor-fold>
  @Override
  public boolean isEqual(/*const*/std.pairPtrType<T, U> /*&*/ LHS, /*const*/std.pairPtrType<T, U> /*&*/ RHS) {
    assert LHS != emptyKey : "LHS: must not be called for emptyKey";
    assert LHS != tombstoneKey : "LHS: must not be called for tombstoneKey";
    assert RHS != emptyKey : "RHS: must not be called for emptyKey";
    assert RHS != tombstoneKey : "RHS: must not be called for tombstoneKey";
    
    return FirstInfo.isEqual(LHS.first, RHS.first) && SecondInfo.isEqual(LHS.second, RHS.second);
  }

  @Override
  public boolean isKeyPointerLike() {
    return false;
  }
}

