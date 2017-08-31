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
import static org.clank.support.Native.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type InstructionStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.InstructionStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZL20haveSameSpecialStatePKN4llvm11InstructionES2_b; -static-type=InstructionStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class InstructionStatics {


/// Return true if both instructions have the same special state This must be
/// kept in sync with FunctionComparator::cmpOperations in
/// lib/Transforms/IPO/MergeFunctions.cpp.
//<editor-fold defaultstate="collapsed" desc="haveSameSpecialState">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Instruction.cpp", line = 349,
 FQN="haveSameSpecialState", NM="_ZL20haveSameSpecialStatePKN4llvm11InstructionES2_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instruction.cpp -nm=_ZL20haveSameSpecialStatePKN4llvm11InstructionES2_b")
//</editor-fold>
public static boolean haveSameSpecialState(/*const*/ Instruction /*P*/ I1, /*const*/ Instruction /*P*/ I2) {
  return haveSameSpecialState(I1, I2, 
                    false);
}
public static boolean haveSameSpecialState(/*const*/ Instruction /*P*/ I1, /*const*/ Instruction /*P*/ I2, 
                    boolean IgnoreAlignment/*= false*/) {
  assert (I1.getOpcode() == I2.getOpcode()) : "Can not compare special state of different instructions";
  {
    
    /*const*/ AllocaInst /*P*/ AI = dyn_cast_AllocaInst(I1);
    if ((AI != null)) {
      return AI.getAllocatedType() == cast_AllocaInst(I2).getAllocatedType()
         && (AI.getAlignment() == cast_AllocaInst(I2).getAlignment()
         || IgnoreAlignment);
    }
  }
  {
    /*const*/ LoadInst /*P*/ LI = dyn_cast_LoadInst(I1);
    if ((LI != null)) {
      return LI.isVolatile() == cast_LoadInst(I2).isVolatile()
         && (LI.getAlignment() == cast_LoadInst(I2).getAlignment()
         || IgnoreAlignment)
         && LI.getOrdering() == cast_LoadInst(I2).getOrdering()
         && LI.getSynchScope() == cast_LoadInst(I2).getSynchScope();
    }
  }
  {
    /*const*/ StoreInst /*P*/ SI = dyn_cast_StoreInst(I1);
    if ((SI != null)) {
      return SI.isVolatile() == cast_StoreInst(I2).isVolatile()
         && (SI.getAlignment() == cast_StoreInst(I2).getAlignment()
         || IgnoreAlignment)
         && SI.getOrdering() == cast_StoreInst(I2).getOrdering()
         && SI.getSynchScope() == cast_StoreInst(I2).getSynchScope();
    }
  }
  {
    /*const*/ CmpInst /*P*/ CI = dyn_cast_CmpInst(I1);
    if ((CI != null)) {
      return CI.getPredicate() == cast_CmpInst(I2).getPredicate();
    }
  }
  {
    /*const*/ CallInst /*P*/ CI = dyn_cast_CallInst(I1);
    if ((CI != null)) {
      return CI.isTailCall() == cast_CallInst(I2).isTailCall()
         && CI.getCallingConv() == cast_CallInst(I2).getCallingConv()
         && CI.getAttributes().$eq(cast_CallInst(I2).getAttributes())
         && CI.hasIdenticalOperandBundleSchema($Deref(cast_CallInst(I2)));
    }
  }
  {
    /*const*/ InvokeInst /*P*/ CI = dyn_cast_InvokeInst(I1);
    if ((CI != null)) {
      return CI.getCallingConv() == cast_InvokeInst(I2).getCallingConv()
         && CI.getAttributes().$eq(cast_InvokeInst(I2).getAttributes())
         && CI.hasIdenticalOperandBundleSchema($Deref(cast_InvokeInst(I2)));
    }
  }
  {
    /*const*/ InsertValueInst /*P*/ IVI = dyn_cast_InsertValueInst(I1);
    if ((IVI != null)) {      
      return IVI.getIndices().$eq(cast_InsertValueInst(I2).getIndices());//$eq_ArrayRef$T(IVI.getIndices(), cast_InsertValueInst(I2).getIndices());
    }
  }
  {
    /*const*/ ExtractValueInst /*P*/ EVI = dyn_cast_ExtractValueInst(I1);
    if ((EVI != null)) {
      return EVI.getIndices().$eq(cast_ExtractValueInst(I2).getIndices());//$eq_ArrayRef$T(EVI.getIndices(), cast_ExtractValueInst(I2).getIndices());
    }
  }
  {
    /*const*/ FenceInst /*P*/ FI = dyn_cast_FenceInst(I1);
    if ((FI != null)) {
      return FI.getOrdering() == cast_FenceInst(I2).getOrdering()
         && FI.getSynchScope() == cast_FenceInst(I2).getSynchScope();
    }
  }
  {
    /*const*/ AtomicCmpXchgInst /*P*/ CXI = dyn_cast_AtomicCmpXchgInst(I1);
    if ((CXI != null)) {
      return CXI.isVolatile() == cast_AtomicCmpXchgInst(I2).isVolatile()
         && CXI.isWeak() == cast_AtomicCmpXchgInst(I2).isWeak()
         && CXI.getSuccessOrdering()
         == cast_AtomicCmpXchgInst(I2).getSuccessOrdering()
         && CXI.getFailureOrdering()
         == cast_AtomicCmpXchgInst(I2).getFailureOrdering()
         && CXI.getSynchScope() == cast_AtomicCmpXchgInst(I2).getSynchScope();
    }
  }
  {
    /*const*/ AtomicRMWInst /*P*/ RMWI = dyn_cast_AtomicRMWInst(I1);
    if ((RMWI != null)) {
      return RMWI.getOperation() == cast_AtomicRMWInst(I2).getOperation()
         && RMWI.isVolatile() == cast_AtomicRMWInst(I2).isVolatile()
         && RMWI.getOrdering() == cast_AtomicRMWInst(I2).getOrdering()
         && RMWI.getSynchScope() == cast_AtomicRMWInst(I2).getSynchScope();
    }
  }
  
  return true;
}

} // END OF class InstructionStatics
