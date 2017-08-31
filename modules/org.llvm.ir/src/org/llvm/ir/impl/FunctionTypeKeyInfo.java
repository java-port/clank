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
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.support.llvm.*;

//<editor-fold defaultstate="collapsed" desc="llvm::FunctionTypeKeyInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 123,
 FQN="llvm::FunctionTypeKeyInfo", NM="_ZN4llvm19FunctionTypeKeyInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm19FunctionTypeKeyInfoE")
//</editor-fold>
public class/*struct*/ FunctionTypeKeyInfo implements DenseMapInfo<FunctionType> {
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionTypeKeyInfo::KeyTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 124,
   FQN="llvm::FunctionTypeKeyInfo::KeyTy", NM="_ZN4llvm19FunctionTypeKeyInfo5KeyTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm19FunctionTypeKeyInfo5KeyTyE")
  //</editor-fold>
  public static class/*struct*/ KeyTy implements Native.NativeComparable<KeyTy> {
    public /*const*/ Type /*P*/ ReturnType;
    public ArrayRef<Type /*P*/ > Params;
    public boolean isVarArg;
    //<editor-fold defaultstate="collapsed" desc="llvm::FunctionTypeKeyInfo::KeyTy::KeyTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 128,
     FQN="llvm::FunctionTypeKeyInfo::KeyTy::KeyTy", NM="_ZN4llvm19FunctionTypeKeyInfo5KeyTyC1EPKNS_4TypeERKNS_8ArrayRefIPS2_EEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm19FunctionTypeKeyInfo5KeyTyC1EPKNS_4TypeERKNS_8ArrayRefIPS2_EEb")
    //</editor-fold>
    public KeyTy(/*const*/ Type /*P*/ R, final /*const*/ArrayRef<Type /*P*/ > /*&*/ P, boolean V) {
      // : ReturnType(R), Params(P), isVarArg(V) 
      //START JInit
      this.ReturnType = R;
      this.Params = new ArrayRef<Type /*P*/ >(P);
      this.isVarArg = V;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::FunctionTypeKeyInfo::KeyTy::KeyTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 130,
     FQN="llvm::FunctionTypeKeyInfo::KeyTy::KeyTy", NM="_ZN4llvm19FunctionTypeKeyInfo5KeyTyC1EPKNS_12FunctionTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm19FunctionTypeKeyInfo5KeyTyC1EPKNS_12FunctionTypeE")
    //</editor-fold>
    public KeyTy(/*const*/ FunctionType /*P*/ FT) {
      // : ReturnType(FT->getReturnType()), Params(FT->params()), isVarArg(FT->isVarArg()) 
      //START JInit
      this.ReturnType = FT.getReturnType();
      this.Params = FT.params();
      this.isVarArg = FT.isVarArg();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::FunctionTypeKeyInfo::KeyTy::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 133,
     FQN="llvm::FunctionTypeKeyInfo::KeyTy::operator==", NM="_ZNK4llvm19FunctionTypeKeyInfo5KeyTyeqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm19FunctionTypeKeyInfo5KeyTyeqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ KeyTy /*&*/ that) /*const*/ {
      if (ReturnType != that.ReturnType) {
        return false;
      }
      if (isVarArg != that.isVarArg) {
        return false;
      }
      if ($noteq_ArrayRef$T(/*NO_COPY*/Params, /*NO_COPY*/that.Params)) {
        return false;
      }
      return true;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::FunctionTypeKeyInfo::KeyTy::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 142,
     FQN="llvm::FunctionTypeKeyInfo::KeyTy::operator!=", NM="_ZNK4llvm19FunctionTypeKeyInfo5KeyTyneERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm19FunctionTypeKeyInfo5KeyTyneERKS1_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ KeyTy /*&*/ that) /*const*/ {
      return !this.$eq(that);
    }

    
    @Override public String toString() {
      return "" + "ReturnType=" + ReturnType // NOI18N
                + ", Params=" + Params // NOI18N
                + ", isVarArg=" + isVarArg; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionTypeKeyInfo::getEmptyKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 146,
   FQN="llvm::FunctionTypeKeyInfo::getEmptyKey", NM="_ZN4llvm19FunctionTypeKeyInfo11getEmptyKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm19FunctionTypeKeyInfo11getEmptyKeyEv")
  //</editor-fold>
  @Override public /*static inline*/ Object /*P*/ getEmptyKey() {
    return emptyKey;//DenseMapInfoT$P.<FunctionType /*P*/ >getEmptyKey();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionTypeKeyInfo::getTombstoneKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 149,
   FQN="llvm::FunctionTypeKeyInfo::getTombstoneKey", NM="_ZN4llvm19FunctionTypeKeyInfo15getTombstoneKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm19FunctionTypeKeyInfo15getTombstoneKeyEv")
  //</editor-fold>
  @Override public /*static inline*/ Object /*P*/ getTombstoneKey() {
    return tombstoneKey;//DenseMapInfoT$P.<FunctionType /*P*/ >getTombstoneKey();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionTypeKeyInfo::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 152,
   FQN="llvm::FunctionTypeKeyInfo::getHashValue", NM="_ZN4llvm19FunctionTypeKeyInfo12getHashValueERKNS0_5KeyTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm19FunctionTypeKeyInfo12getHashValueERKNS0_5KeyTyE")
  //</editor-fold>
  public static /*uint*/int getHashValue(final /*const*/ KeyTy /*&*/ _Key) {
    KeyTy Key = (KeyTy)_Key;
    return HashingGlobals.hash_combine_ptr(Key.ReturnType, 
        HashingGlobals.hash_combine_range_ptrs(Key.Params.begin(), 
            Key.Params.end()), 
        Key.isVarArg).$uint();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionTypeKeyInfo::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 158,
   FQN="llvm::FunctionTypeKeyInfo::getHashValue", NM="_ZN4llvm19FunctionTypeKeyInfo12getHashValueEPKNS_12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm19FunctionTypeKeyInfo12getHashValueEPKNS_12FunctionTypeE")
  //</editor-fold>
  @Override public /*static uint*/int getHashValue(/*const*/ FunctionType /*P*/ FT) {
    return /*FunctionTypeKeyInfo.*/getHashValue(new KeyTy(FT));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionTypeKeyInfo::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 161,
   FQN="llvm::FunctionTypeKeyInfo::isEqual", NM="_ZN4llvm19FunctionTypeKeyInfo7isEqualERKNS0_5KeyTyEPKNS_12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm19FunctionTypeKeyInfo7isEqualERKNS0_5KeyTyEPKNS_12FunctionTypeE")
  //</editor-fold>
  public /*static*/ boolean isEqual(final /*const*/ KeyTy /*&*/ LHS, /*const*/ FunctionType /*P*/ RHS) {
    if (RHS == /*FunctionTypeKeyInfo.*/getEmptyKey() || RHS == /*FunctionTypeKeyInfo.*/getTombstoneKey()) {
      return false;
    }
    return LHS.$eq(new KeyTy(RHS));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionTypeKeyInfo::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 166,
   FQN="llvm::FunctionTypeKeyInfo::isEqual", NM="_ZN4llvm19FunctionTypeKeyInfo7isEqualEPKNS_12FunctionTypeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm19FunctionTypeKeyInfo7isEqualEPKNS_12FunctionTypeES3_")
  //</editor-fold>
  @Override public /*static*/ boolean isEqual(/*const*/ FunctionType /*P*/ LHS, /*const*/ FunctionType /*P*/ RHS) {
    return LHS == RHS;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  // we don't create FunctionType here because any type requires LLVMContext intstance
  protected final Object/*P*/ emptyKey = new String("FunctionType.EmptyKey");
  protected final Object/*P*/ tombstoneKey = new String("FunctionType.TombstoneKey");
  private static final FunctionTypeKeyInfo $INFO = new FunctionTypeKeyInfo();
  
  public static FunctionTypeKeyInfo $Info() { return $INFO; }
  
  @Override public boolean isKeyPointerLike() { return true; }
  
  @Override public /*static uint*/int getHashValueAlt(final /*const*/ Object/*KeyTy*/ /*&*/ Key) {
    return getHashValue((KeyTy)Key);
  }
  
  @Override public /*static*/ boolean isEqualAlt(final /*const*/ Object/*KeyTy*/ /*&*/ LHS, /*const*/ FunctionType /*P*/ RHS) {
    return isEqual((KeyTy)LHS, RHS);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
