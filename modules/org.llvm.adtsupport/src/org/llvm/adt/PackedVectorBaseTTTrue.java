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

import org.clank.support.*;
import org.llvm.adt.*;

//<editor-fold defaultstate="collapsed" desc="llvm::PackedVectorBase<type-parameter-0-0, BitNum, type-parameter-0-2, true>">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 44,
 FQN="llvm::PackedVectorBase<type-parameter-0-0, BitNum, type-parameter-0-2, true>", NM="_ZN4llvm16PackedVectorBaseIT_XT0_ET1_Lb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN4llvm16PackedVectorBaseIT_XT0_ET1_Lb1EEE")
//</editor-fold>
public class PackedVectorBaseTTTrue implements PackedVectorBase<PackedVectorBaseTTTrue> {
  
  private final /*uint*/int BitNum;

  public PackedVectorBaseTTTrue(int BitNum) {
    this.BitNum = BitNum;
  }
  
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PackedVectorBase<type-parameter-0-0, BitNum, type-parameter-0-2, true>::getValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 47,
   FQN="llvm::PackedVectorBase<type-parameter-0-0, BitNum, type-parameter-0-2, true>::getValue", NM="_ZN4llvm16PackedVectorBaseIT_XT0_ET1_Lb1EE8getValueERKS2_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN4llvm16PackedVectorBaseIT_XT0_ET1_Lb1EE8getValueERKS2_j")
  //</editor-fold>
  public int getValue(/*const*/ BitVectorTy /*&*/ Bits, /*uint*/int Idx) {
    int val = 0;
    for (/*uint*/int i = 0; i != BitNum - 1; ++i)  {
      val = val | ((Bits.$at$Const((Idx << (BitNum - 1)) + i) ? 1/*UL*/ : 0/*UL*/) << i);
    }
    if (Bits.$at$Const((Idx << (BitNum - 1)) + BitNum - 1)) {
      val = ~val;
    }
    return val;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PackedVectorBase<type-parameter-0-0, BitNum, type-parameter-0-2, true>::setValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/PackedVector.h", line = 56,
   FQN="llvm::PackedVectorBase<type-parameter-0-0, BitNum, type-parameter-0-2, true>::setValue", NM="_ZN4llvm16PackedVectorBaseIT_XT0_ET1_Lb1EE8setValueERS2_jS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN4llvm16PackedVectorBaseIT_XT0_ET1_Lb1EE8setValueERS2_jS1_")
  //</editor-fold>
  public void setValue(BitVectorTy /*&*/ Bits, /*uint*/int Idx, int val) {
    if (Native.$less(val, 0)) {
      val = ~val;
      Bits.set((Idx << (BitNum - 1)) + BitNum - 1);
    }
    assert (Native.$eq((val >>> (BitNum - 1)), 0)) : "value [" + val + "] is too big for " + BitNum + " signed bits";
    for (/*uint*/int i = 0; i != BitNum - 1; ++i)  {
      Bits.$at((Idx << (BitNum - 1)) + i).$assign((val & (1 << i)) != 0);
    }
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override
  public boolean $eq(PackedVectorBaseTTTrue other) {
    if (other == null) {
      return false;
    }
    if (other.getClass() != PackedVectorBaseTTTrue.class) {
      return false;
    }
    return BitNum == ((PackedVectorBaseTTTrue) other).BitNum;
  }
  
  @Override public PackedVectorBaseTTTrue clone() { return new PackedVectorBaseTTTrue(this.BitNum); }
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
