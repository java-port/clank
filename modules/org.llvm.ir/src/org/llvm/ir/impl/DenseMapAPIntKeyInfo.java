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

package org.llvm.ir.impl;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.support.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DenseMapAPIntKeyInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 50,
 FQN="llvm::DenseMapAPIntKeyInfo", NM="_ZN4llvm20DenseMapAPIntKeyInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm20DenseMapAPIntKeyInfoE")
//</editor-fold>
public class/*struct*/ DenseMapAPIntKeyInfo implements DenseMapInfo<APInt> {
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapAPIntKeyInfo::getEmptyKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 51,
   FQN="llvm::DenseMapAPIntKeyInfo::getEmptyKey", NM="_ZN4llvm20DenseMapAPIntKeyInfo11getEmptyKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm20DenseMapAPIntKeyInfo11getEmptyKeyEv")
  //</editor-fold>
  public /*static inline*/ APInt getEmptyKey() {
    //APInt V/*J*/= new APInt((ulong$ptr/*uint64_t P*/ )null, 0);
    //V.VAL = $int2ulong(0);
    return emptyKey;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapAPIntKeyInfo::getTombstoneKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 56,
   FQN="llvm::DenseMapAPIntKeyInfo::getTombstoneKey", NM="_ZN4llvm20DenseMapAPIntKeyInfo15getTombstoneKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm20DenseMapAPIntKeyInfo15getTombstoneKeyEv")
  //</editor-fold>
  public  /*static inline*/ APInt getTombstoneKey() {
    //APInt V/*J*/= new APInt((ulong$ptr/*uint64_t P*/ )null, 0);
    //V.VAL = $int2ulong(1);
    return tombstoneKey;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapAPIntKeyInfo::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 61,
   FQN="llvm::DenseMapAPIntKeyInfo::getHashValue", NM="_ZN4llvm20DenseMapAPIntKeyInfo12getHashValueERKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm20DenseMapAPIntKeyInfo12getHashValueERKNS_5APIntE")
  //</editor-fold>
  public /*static uint*/int getHashValue(final /*const*/ APInt /*&*/ Key) {
    return ((/*static_cast*//*uint*/int)(AdtsupportLlvmGlobals.hash_value(Key).$uint()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapAPIntKeyInfo::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 64,
   FQN="llvm::DenseMapAPIntKeyInfo::isEqual", NM="_ZN4llvm20DenseMapAPIntKeyInfo7isEqualERKNS_5APIntES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm20DenseMapAPIntKeyInfo7isEqualERKNS_5APIntES3_")
  //</editor-fold>
  public /*static*/ boolean isEqual(final /*const*/ APInt /*&*/ LHS, final /*const*/ APInt /*&*/ RHS) {
    return LHS.getBitWidth() == RHS.getBitWidth() && LHS.$eq(RHS);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final DenseMapAPIntKeyInfo $INFO = new DenseMapAPIntKeyInfo();
  private static final APInt emptyKey; 
  static {
    emptyKey = new APInt((ulong$ptr/*uint64_t P*/ )null, 0);
    emptyKey.VAL = $int2ulong(0);
  }
  private static final APInt tombstoneKey; 
  static {
    tombstoneKey = new APInt((ulong$ptr/*uint64_t P*/ )null, 0);
    tombstoneKey.VAL = $int2ulong(0);
  }
  
  public static DenseMapAPIntKeyInfo $Info() { return $INFO; }
  
  @Override public boolean isKeyPointerLike() { return false; }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
