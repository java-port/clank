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
import org.llvm.adt.*;
import static org.llvm.adt.HashingGlobals.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.support.llvm.*;

//<editor-fold defaultstate="collapsed" desc="llvm::AnonStructTypeKeyInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 80,
 FQN="llvm::AnonStructTypeKeyInfo", NM="_ZN4llvm21AnonStructTypeKeyInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm21AnonStructTypeKeyInfoE")
//</editor-fold>
public class/*struct*/ AnonStructTypeKeyInfo implements DenseMapInfo<StructType> {
  //<editor-fold defaultstate="collapsed" desc="llvm::AnonStructTypeKeyInfo::KeyTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 81,
   FQN="llvm::AnonStructTypeKeyInfo::KeyTy", NM="_ZN4llvm21AnonStructTypeKeyInfo5KeyTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm21AnonStructTypeKeyInfo5KeyTyE")
  //</editor-fold>
  public static class/*struct*/ KeyTy implements Native.NativeComparable<KeyTy> {
    public ArrayRef<Type /*P*/ > ETypes;
    public boolean isPacked;
    //<editor-fold defaultstate="collapsed" desc="llvm::AnonStructTypeKeyInfo::KeyTy::KeyTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 84,
     FQN="llvm::AnonStructTypeKeyInfo::KeyTy::KeyTy", NM="_ZN4llvm21AnonStructTypeKeyInfo5KeyTyC1ERKNS_8ArrayRefIPNS_4TypeEEEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm21AnonStructTypeKeyInfo5KeyTyC1ERKNS_8ArrayRefIPNS_4TypeEEEb")
    //</editor-fold>
    public KeyTy(final /*const*/ArrayRef<Type /*P*/ > /*&*/ E, boolean P) {
      // : ETypes(E), isPacked(P) 
      //START JInit
      this.ETypes = new ArrayRef<Type /*P*/ >(E);
      this.isPacked = P;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AnonStructTypeKeyInfo::KeyTy::KeyTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 86,
     FQN="llvm::AnonStructTypeKeyInfo::KeyTy::KeyTy", NM="_ZN4llvm21AnonStructTypeKeyInfo5KeyTyC1EPKNS_10StructTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm21AnonStructTypeKeyInfo5KeyTyC1EPKNS_10StructTypeE")
    //</editor-fold>
    public KeyTy(/*const*/ StructType /*P*/ ST) {
      // : ETypes(ST->elements()), isPacked(ST->isPacked()) 
      //START JInit
      this.ETypes = ST.elements();
      this.isPacked = ST.isPacked();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AnonStructTypeKeyInfo::KeyTy::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 88,
     FQN="llvm::AnonStructTypeKeyInfo::KeyTy::operator==", NM="_ZNK4llvm21AnonStructTypeKeyInfo5KeyTyeqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm21AnonStructTypeKeyInfo5KeyTyeqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ KeyTy /*&*/ that) /*const*/ {
      if (isPacked != that.isPacked) {
        return false;
      }
      if ($noteq_ArrayRef$T(/*NO_COPY*/ETypes, /*NO_COPY*/that.ETypes)) {
        return false;
      }
      return true;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AnonStructTypeKeyInfo::KeyTy::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 95,
     FQN="llvm::AnonStructTypeKeyInfo::KeyTy::operator!=", NM="_ZNK4llvm21AnonStructTypeKeyInfo5KeyTyneERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm21AnonStructTypeKeyInfo5KeyTyneERKS1_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ KeyTy /*&*/ that) /*const*/ {
      return !this.$eq(that);
    }

    
    @Override public String toString() {
      return "" + "ETypes=" + ETypes // NOI18N
                + ", isPacked=" + isPacked; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="llvm::AnonStructTypeKeyInfo::getEmptyKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 99,
   FQN="llvm::AnonStructTypeKeyInfo::getEmptyKey", NM="_ZN4llvm21AnonStructTypeKeyInfo11getEmptyKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm21AnonStructTypeKeyInfo11getEmptyKeyEv")
  //</editor-fold>
  @Override public /*static inline*/ Object /*P*/ getEmptyKey() {
    return emptyKey;//DenseMapInfoT$P.<StructType /*P*/ >getEmptyKey();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AnonStructTypeKeyInfo::getTombstoneKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 102,
   FQN="llvm::AnonStructTypeKeyInfo::getTombstoneKey", NM="_ZN4llvm21AnonStructTypeKeyInfo15getTombstoneKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm21AnonStructTypeKeyInfo15getTombstoneKeyEv")
  //</editor-fold>
  @Override public /*static inline*/ Object /*P*/ getTombstoneKey() {
    return tombstoneKey;//DenseMapInfoT$P.<StructType /*P*/ >getTombstoneKey();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AnonStructTypeKeyInfo::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 105,
   FQN="llvm::AnonStructTypeKeyInfo::getHashValue", NM="_ZN4llvm21AnonStructTypeKeyInfo12getHashValueERKNS0_5KeyTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm21AnonStructTypeKeyInfo12getHashValueERKNS0_5KeyTyE")
  //</editor-fold>
  public static /*uint*/int getHashValue(final /*const*/ KeyTy /*&*/ Key) {
    return hash_combine(hash_combine_range_ptrs(Key.ETypes.begin(), 
            Key.ETypes.end()), 
        Key.isPacked).$uint();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AnonStructTypeKeyInfo::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 110,
   FQN="llvm::AnonStructTypeKeyInfo::getHashValue", NM="_ZN4llvm21AnonStructTypeKeyInfo12getHashValueEPKNS_10StructTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm21AnonStructTypeKeyInfo12getHashValueEPKNS_10StructTypeE")
  //</editor-fold>
  @Override public /*static uint*/int getHashValue(/*const*/ StructType /*P*/ ST) {
    return getHashValue(new KeyTy(ST));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AnonStructTypeKeyInfo::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 113,
   FQN="llvm::AnonStructTypeKeyInfo::isEqual", NM="_ZN4llvm21AnonStructTypeKeyInfo7isEqualERKNS0_5KeyTyEPKNS_10StructTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm21AnonStructTypeKeyInfo7isEqualERKNS0_5KeyTyEPKNS_10StructTypeE")
  //</editor-fold>
  public /*static*/ boolean isEqual(final /*const*/ KeyTy /*&*/ LHS, /*const*/ StructType /*P*/ RHS) {
    if (RHS == getEmptyKey() || RHS == getTombstoneKey()) {
      return false;
    }
    return LHS.$eq(new KeyTy(RHS));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AnonStructTypeKeyInfo::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 118,
   FQN="llvm::AnonStructTypeKeyInfo::isEqual", NM="_ZN4llvm21AnonStructTypeKeyInfo7isEqualEPKNS_10StructTypeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm21AnonStructTypeKeyInfo7isEqualEPKNS_10StructTypeES3_")
  //</editor-fold>
  @Override public /*static*/ boolean isEqual(/*const*/ StructType /*P*/ LHS, /*const*/ StructType /*P*/ RHS) {
    return LHS == RHS;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  // we don't create StructType here because any type requires LLVMContext intstance
  protected final Object/*P*/ emptyKey = new String("StructType.EmptyKey");
  protected final Object/*P*/ tombstoneKey = new String("StructType.TombstoneKey");
  private static final AnonStructTypeKeyInfo $INFO = new AnonStructTypeKeyInfo();
  
  public static AnonStructTypeKeyInfo $Info() { return $INFO; }
  
  @Override public boolean isKeyPointerLike() { return true; }

  @Override public final /*static*/ boolean isEqualAlt(final /*const*/ Object/*KeyTy*/ /*&*/ LHS, /*const*/ StructType /*P*/ RHS) {
    return isEqual((KeyTy)LHS, RHS);
  }
  
  @Override public final /*static uint*/int getHashValueAlt(final /*const*/ Object/*KeyTy*/ /*&*/ Key) {
    return getHashValue((KeyTy)Key);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
