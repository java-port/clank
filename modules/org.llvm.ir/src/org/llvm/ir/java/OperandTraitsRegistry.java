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

package org.llvm.ir.java;

import java.util.concurrent.ConcurrentHashMap;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;

/**
 *
 * @author vkvashin
 */
public class OperandTraitsRegistry {

  // NB: extends User, not IUser - that's only for "real" users
  //public static <SubClass extends User> void register(Class<SubClass> clazz, OperandTraits<SubClass> trait) {
  public static void register(Class<? extends User> clazz, OperandTraits<? extends User> trait) {
    OperandTraits prev = traitsMap.putIfAbsent(clazz, trait);
    assert (prev == null || prev == trait) : "Two different trait instances registered for " + clazz.getName() + " prev: " + prev + " curr: " + trait;
  }

  public static OperandTraits<User> get(Class<? extends User> clazz) {
    return traitsMap.get(clazz);
  }

  private static final ConcurrentHashMap<Class, OperandTraits> traitsMap;

  static {
    traitsMap = new ConcurrentHashMap<>();
    // register known classes
    register(GlobalVariable.class, new OperandTraitsGlobalVariable());
    register(BlockAddress.class, new OperandTraitsBlockAddress());
    register(AtomicCmpXchgInst.class, new OperandTraitsAtomicCmpXchgInst());
    register(AtomicRMWInst.class, new OperandTraitsAtomicRMWInst());
    register(BinaryOperator.class, new OperandTraitsBinaryOperator());
    register(BranchInst.class, new OperandTraitsBranchInst());
    register(CallInst.class, new OperandTraitsCallInst());
    register(CatchReturnInst.class, new OperandTraitsCatchReturnInst());
    register(CatchSwitchInst.class, new OperandTraitsCatchSwitchInst());
    register(CleanupReturnInst.class, new OperandTraitsCleanupReturnInst());
    register(CmpInst.class, new OperandTraitsCmpInst());
    register(ConstantAggregate.class, new OperandTraitsConstantAggregate());
    register(ConstantExpr.class, new OperandTraitsConstantExpr());
    register(ExtractElementInst.class, new OperandTraitsExtractElementInst());
    register(FuncletPadInst.class, new OperandTraitsFuncletPadInst());
    register(Function.class, new OperandTraitsFunction());
    register(GetElementPtrInst.class, new OperandTraitsGetElementPtrInst());
    register(GlobalIndirectSymbol.class, new OperandTraitsGlobalIndirectSymbol());
    register(IndirectBrInst.class, new OperandTraitsIndirectBrInst());
    register(InsertElementInst.class, new OperandTraitsInsertElementInst());
    register(InsertValueInst.class, new OperandTraitsInsertValueInst());
    register(InvokeInst.class, new OperandTraitsInvokeInst());
    register(LandingPadInst.class, new OperandTraitsLandingPadInst());
    register(PHINode.class, new OperandTraitsPHINode());
    register(ResumeInst.class, new OperandTraitsResumeInst());
    register(ReturnInst.class, new OperandTraitsReturnInst());
    register(SelectInst.class, new OperandTraitsSelectInst());
    register(ShuffleVectorInst.class, new OperandTraitsShuffleVectorInst());
    register(StoreInst.class, new OperandTraitsStoreInst());
    register(SwitchInst.class, new OperandTraitsSwitchInst());
    register(UnaryInstruction.class, new OperandTraitsUnaryInstruction());
      register(AllocaInst.class, new OperandTraitsUnaryInstruction());
      register(CastInst.class, new OperandTraitsUnaryInstruction());
        register(AddrSpaceCastInst.class, new OperandTraitsUnaryInstruction());
        register(BitCastInst.class, new OperandTraitsUnaryInstruction());
        register(FPExtInst.class, new OperandTraitsUnaryInstruction());
        register(FPToSIInst.class, new OperandTraitsUnaryInstruction());
        register(FPToUIInst.class, new OperandTraitsUnaryInstruction());
        register(FPTruncInst.class, new OperandTraitsUnaryInstruction());
        register(IntToPtrInst.class, new OperandTraitsUnaryInstruction());
        register(PtrToIntInst.class, new OperandTraitsUnaryInstruction());
        register(SExtInst.class, new OperandTraitsUnaryInstruction());
        register(SIToFPInst.class, new OperandTraitsUnaryInstruction());
        register(TruncInst.class, new OperandTraitsUnaryInstruction());
        register(UIToFPInst.class, new OperandTraitsUnaryInstruction());
        register(ZExtInst.class, new OperandTraitsUnaryInstruction());
      register(ExtractValueInst.class, new OperandTraitsUnaryInstruction());
      register(LoadInst.class, new OperandTraitsUnaryInstruction());
      register(VAArgInst.class, new OperandTraitsUnaryInstruction());
        
    register(BinaryConstantExpr.class, new OperandTraitsBinaryConstantExpr());
    register(CompareConstantExpr.class, new OperandTraitsCompareConstantExpr());
    register(ExtractElementConstantExpr.class, new OperandTraitsExtractElementConstantExpr());
    register(ExtractValueConstantExpr.class, new OperandTraitsExtractValueConstantExpr());
    register(GetElementPtrConstantExpr.class, new OperandTraitsGetElementPtrConstantExpr());
    register(InsertElementConstantExpr.class, new OperandTraitsInsertElementConstantExpr());
    register(SelectConstantExpr.class, new OperandTraitsSelectConstantExpr());
    register(ShuffleVectorConstantExpr.class, new OperandTraitsShuffleVectorConstantExpr());
    register(UnaryConstantExpr.class, new OperandTraitsUnaryConstantExpr());
  }
}
