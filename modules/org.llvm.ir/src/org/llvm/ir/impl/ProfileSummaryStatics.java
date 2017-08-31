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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type ProfileSummaryStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.ProfileSummaryStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZL11getKeyValMDRN4llvm11LLVMContextEPKcS3_;_ZL11getKeyValMDRN4llvm11LLVMContextEPKcy;_ZL14isKeyValuePairPN4llvm7MDTupleEPKcS3_;_ZL16getSummaryFromMDPN4llvm7MDTupleERSt6vectorINS_19ProfileSummaryEntryESaIS3_EE;_ZL6getValPN4llvm7MDTupleEPKcRy; -static-type=ProfileSummaryStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class ProfileSummaryStatics {


// Return an MDTuple with two elements. The first element is a string Key and
// the second is a uint64_t Value.
//<editor-fold defaultstate="collapsed" desc="getKeyValMD">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp", line = 29,
 FQN="getKeyValMD", NM="_ZL11getKeyValMDRN4llvm11LLVMContextEPKcy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZL11getKeyValMDRN4llvm11LLVMContextEPKcy")
//</editor-fold>
public static Metadata /*P*/ getKeyValMD(final LLVMContext /*&*/ Context, /*const*/char$ptr/*char P*/ Key, 
           long/*uint64_t*/ Val) {
  Type /*P*/ Int64Ty = Type.getInt64Ty(Context);
  Metadata /*P*/ Ops[/*2*/] = new Metadata /*P*/  [/*2*/] {
    MDString.get(Context, Key), 
    ConstantAsMetadata.get(ConstantInt.get(Int64Ty, Val))};
  return MDTuple.get(Context, new ArrayRef<Metadata /*P*/ >(Ops, true));
}


// Return an MDTuple with two elements. The first element is a string Key and
// the second is a string Value.
//<editor-fold defaultstate="collapsed" desc="getKeyValMD">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp", line = 39,
 FQN="getKeyValMD", NM="_ZL11getKeyValMDRN4llvm11LLVMContextEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZL11getKeyValMDRN4llvm11LLVMContextEPKcS3_")
//</editor-fold>
public static Metadata /*P*/ getKeyValMD(final LLVMContext /*&*/ Context, /*const*/char$ptr/*char P*/ Key, 
           /*const*/char$ptr/*char P*/ Val) {
  Metadata /*P*/ Ops[/*2*/] = new Metadata /*P*/  [/*2*/] {MDString.get(Context, Key), MDString.get(Context, Val)};
  return MDTuple.get(Context, new ArrayRef<Metadata /*P*/ >(Ops, true));
}


// Parse an MDTuple representing (Key, Val) pair.
//<editor-fold defaultstate="collapsed" desc="getVal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp", line = 88,
 FQN="getVal", NM="_ZL6getValPN4llvm7MDTupleEPKcRy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZL6getValPN4llvm7MDTupleEPKcRy")
//</editor-fold>
public static boolean getVal(MDTuple /*P*/ MD, /*const*/char$ptr/*char P*/ Key, final ulong$ref/*uint64_t &*/ Val) {
  if (!(MD != null)) {
    return false;
  }
  if (MD.getNumOperands() != 2) {
    return false;
  }
  MDString /*P*/ KeyMD = dyn_cast_MDString(MD.getOperand(0));
  ConstantAsMetadata /*P*/ ValMD = dyn_cast_ConstantAsMetadata(MD.getOperand(1));
  if (!(KeyMD != null) || !(ValMD != null)) {
    return false;
  }
  if (!KeyMD.getString().equals(/*STRINGREF_STR*/Key)) {
    return false;
  }
  Val.$set(cast_ConstantInt(ValMD.getValue()).getZExtValue());
  return true;
}


// Check if an MDTuple represents a (Key, Val) pair.
//<editor-fold defaultstate="collapsed" desc="isKeyValuePair">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp", line = 104,
 FQN="isKeyValuePair", NM="_ZL14isKeyValuePairPN4llvm7MDTupleEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZL14isKeyValuePairPN4llvm7MDTupleEPKcS3_")
//</editor-fold>
public static boolean isKeyValuePair(MDTuple /*P*/ MD, /*const*/char$ptr/*char P*/ Key, /*const*/char$ptr/*char P*/ Val) {
  if (!(MD != null) || MD.getNumOperands() != 2) {
    return false;
  }
  MDString /*P*/ KeyMD = dyn_cast_MDString(MD.getOperand(0));
  MDString /*P*/ ValMD = dyn_cast_MDString(MD.getOperand(1));
  if (!(KeyMD != null) || !(ValMD != null)) {
    return false;
  }
  if (!KeyMD.getString().equals(/*STRINGREF_STR*/Key) || !ValMD.getString().equals(/*STRINGREF_STR*/Val)) {
    return false;
  }
  return true;
}


// Parse an MDTuple representing detailed summary.
//<editor-fold defaultstate="collapsed" desc="getSummaryFromMD">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp", line = 117,
 FQN="getSummaryFromMD", NM="_ZL16getSummaryFromMDPN4llvm7MDTupleERSt6vectorINS_19ProfileSummaryEntryESaIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZL16getSummaryFromMDPN4llvm7MDTupleERSt6vectorINS_19ProfileSummaryEntryESaIS3_EE")
//</editor-fold>
public static boolean getSummaryFromMD(MDTuple /*P*/ MD, final std.vector<ProfileSummaryEntry> /*&*/ Summary) {
  if (!(MD != null) || MD.getNumOperands() != 2) {
    return false;
  }
  MDString /*P*/ KeyMD = dyn_cast_MDString(MD.getOperand(0));
  if (!(KeyMD != null) || !KeyMD.getString().equals(/*STRINGREF_STR*/"DetailedSummary")) {
    return false;
  }
  MDTuple /*P*/ EntriesMD = dyn_cast_MDTuple(MD.getOperand(1));
  if (!(EntriesMD != null)) {
    return false;
  }
  for (final /*const*/ MDOperand /*&*/ /*&*/ MDOp : EntriesMD.operands()) {
    MDTuple /*P*/ EntryMD = dyn_cast_MDTuple(MDOp);
    if (!(EntryMD != null) || EntryMD.getNumOperands() != 3) {
      return false;
    }
    ConstantAsMetadata /*P*/ Op0 = dyn_cast_ConstantAsMetadata(EntryMD.getOperand(0));
    ConstantAsMetadata /*P*/ Op1 = dyn_cast_ConstantAsMetadata(EntryMD.getOperand(1));
    ConstantAsMetadata /*P*/ Op2 = dyn_cast_ConstantAsMetadata(EntryMD.getOperand(2));
    if (!(Op0 != null) || !(Op1 != null) || !(Op2 != null)) {
      return false;
    }
    Summary.emplace_back(new ProfileSummaryEntry($ulong2uint(cast_ConstantInt(Op0.getValue()).getZExtValue()), 
        cast_ConstantInt(Op1.getValue()).getZExtValue(), 
        cast_ConstantInt(Op2.getValue()).getZExtValue()));
  }
  return true;
}

} // END OF class ProfileSummaryStatics
