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

package org.llvm.ir;

import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;

/*template <typename KeyT, typename ValueT, typename Config> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<ValueMapCallbackVH<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 291,
 FQN="llvm::DenseMapInfo<ValueMapCallbackVH<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >", NM="_ZN4llvm12DenseMapInfoINS_18ValueMapCallbackVHIT_T0_T1_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm12DenseMapInfoINS_18ValueMapCallbackVHIT_T0_T1_EEEE")
//</editor-fold>
public class/*struct*/ DenseMapInfoValueMapCallbackVH$T$T_0_1$T_0_2</*typename*/ KeyT, /*typename*/ ValueT, /*typename*/ Config>  implements DenseMapInfo<ValueMapCallbackVH<KeyT, ValueT>> {
  // JAVA: typedef ValueMapCallbackVH<KeyT, ValueT, Config> VH
//  public final class VH extends ValueMapCallbackVH<KeyT, ValueT>{ };

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<ValueMapCallbackVH<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::getEmptyKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 295,
   FQN="llvm::DenseMapInfo<ValueMapCallbackVH<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::getEmptyKey", NM="_ZN4llvm12DenseMapInfoINS_18ValueMapCallbackVHIT_T0_T1_EEE11getEmptyKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm12DenseMapInfoINS_18ValueMapCallbackVHIT_T0_T1_EEE11getEmptyKeyEv")
  //</editor-fold>
  public Object getEmptyKey() {
    return DenseMapInfo$LikePtr.$Info().getEmptyKey();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<ValueMapCallbackVH<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::getTombstoneKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 298,
   FQN="llvm::DenseMapInfo<ValueMapCallbackVH<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::getTombstoneKey", NM="_ZN4llvm12DenseMapInfoINS_18ValueMapCallbackVHIT_T0_T1_EEE15getTombstoneKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm12DenseMapInfoINS_18ValueMapCallbackVHIT_T0_T1_EEE15getTombstoneKeyEv")
  //</editor-fold>
  public Object getTombstoneKey() {
    return DenseMapInfo$LikePtr.$Info().getTombstoneKey();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<ValueMapCallbackVH<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 301,
   FQN="llvm::DenseMapInfo<ValueMapCallbackVH<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::getHashValue", NM="_ZN4llvm12DenseMapInfoINS_18ValueMapCallbackVHIT_T0_T1_EEE12getHashValueERKS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm12DenseMapInfoINS_18ValueMapCallbackVHIT_T0_T1_EEE12getHashValueERKS5_")
  //</editor-fold>
  public int getHashValue(final /*const*/ValueMapCallbackVH<KeyT, ValueT>/*&*/ Val) {
    return DenseMapInfo$LikePtr.$Info().getHashValue(Val.Unwrap());
  }

// JAVA: implementing this would require passing an instance of a different DenseMapInfo<KeyT> as a ctor parameter
// and keeping it in field. Prior than doing this let's hold on and see whether this is really needed
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<ValueMapCallbackVH<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::getHashValue">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 304,
//   FQN="llvm::DenseMapInfo<ValueMapCallbackVH<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::getHashValue", NM="_ZN4llvm12DenseMapInfoINS_18ValueMapCallbackVHIT_T0_T1_EEE12getHashValueERKS2_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm12DenseMapInfoINS_18ValueMapCallbackVHIT_T0_T1_EEE12getHashValueERKS2_")
//  //</editor-fold>
//  public static </*typename*/ KeyT, /*typename*/ ValueT, /*typename*/ Config> /*uint*/int getHashValue(final /*const*/ KeyT /*&*/ Val) {
//    return DenseMapInfo.<KeyT>getHashValue(Val);
//  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<ValueMapCallbackVH<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 307,
   FQN="llvm::DenseMapInfo<ValueMapCallbackVH<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::isEqual", NM="_ZN4llvm12DenseMapInfoINS_18ValueMapCallbackVHIT_T0_T1_EEE7isEqualERKS5_S8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm12DenseMapInfoINS_18ValueMapCallbackVHIT_T0_T1_EEE7isEqualERKS5_S8_")
  //</editor-fold>
  public boolean isEqual(final /*const*/ValueMapCallbackVH<KeyT, ValueT>/*&*/ LHS, final /*const*/ValueMapCallbackVH<KeyT, ValueT>/*&*/ RHS) {
    return Native.$eq(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<ValueMapCallbackVH<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::isEqual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 310,
   FQN="llvm::DenseMapInfo<ValueMapCallbackVH<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::isEqual", NM="_ZN4llvm12DenseMapInfoINS_18ValueMapCallbackVHIT_T0_T1_EEE7isEqualERKS2_RKS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm12DenseMapInfoINS_18ValueMapCallbackVHIT_T0_T1_EEE7isEqualERKS2_RKS5_")
  //</editor-fold>
  public boolean isEqual(final /*const*/ KeyT /*&*/ LHS, final /*const*/ValueMapCallbackVH<KeyT, ValueT>/*&*/ RHS) {
    return Native.$eq(LHS, RHS.getValPtr());
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static DenseMapInfoValueMapCallbackVH$T$T_0_1$T_0_2 $INFO = new DenseMapInfoValueMapCallbackVH$T$T_0_1$T_0_2();

  public static DenseMapInfoValueMapCallbackVH$T$T_0_1$T_0_2 $Info() {
    return $INFO;
  }

  @Override
  public boolean isKeyPointerLike() {
    return false;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return ""; // NOI18N
  }
}
