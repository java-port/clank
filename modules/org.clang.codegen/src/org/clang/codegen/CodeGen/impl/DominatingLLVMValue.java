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

package org.clang.codegen.CodeGen.impl;

import org.clank.support.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


/// Helper class with most of the code for saving a value for a
/// conditional expression cleanup.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingLLVMValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3409,
 FQN="clang::CodeGen::DominatingLLVMValue", NM="_ZN5clang7CodeGen19DominatingLLVMValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen19DominatingLLVMValueE")
//</editor-fold>
public class/*struct*/ DominatingLLVMValue {
  // JAVA: typedef llvm::PointerIntPair<llvm::Value *, 1, bool> saved_type
//  public final class saved_type extends PointerBoolPair<Value /*P*/ >{ };
  
  /// Answer whether the given value needs extra work to be saved.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingLLVMValue::needsSaving">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3413,
   FQN="clang::CodeGen::DominatingLLVMValue::needsSaving", NM="_ZN5clang7CodeGen19DominatingLLVMValue11needsSavingEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen19DominatingLLVMValue11needsSavingEPN4llvm5ValueE")
  //</editor-fold>
  public static boolean needsSaving(Value /*P*/ value) {
    // If it's not an instruction, we don't need to save.
    if (!isa_Instruction(value)) {
      return false;
    }
    
    // If it's an instruction in the entry block, we don't need to save.
    BasicBlock /*P*/ block = cast_Instruction(value).getParent();
    return (block != /*AddrOf*/block.getParent().getEntryBlock());
  }

  
  /// Try to save the given value.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingLLVMValue::save">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3423,
   FQN="clang::CodeGen::DominatingLLVMValue::save", NM="_ZN5clang7CodeGen19DominatingLLVMValue4saveERNS0_15CodeGenFunctionEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen19DominatingLLVMValue4saveERNS0_15CodeGenFunctionEPN4llvm5ValueE")
  //</editor-fold>
  public static PointerBoolPair<Value /*P*/ > save(final CodeGenFunction /*&*/ CGF, Value /*P*/ value) {
    if (!DominatingLLVMValue.needsSaving(value)) {
      return new PointerBoolPair<Value /*P*/ >(value, false);
    }
    
    // Otherwise, we need an alloca.
    CharUnits align = CharUnits.fromQuantity($uint2long(CGF.CGM.getDataLayout().getPrefTypeAlignment(value.getType())));
    Address alloca = CGF.CreateTempAlloca(value.getType(), new CharUnits(align), new Twine(/*KEEP_STR*/"cond-cleanup.save"));
    CGF.Builder.CreateStore(value, new Address(alloca));
    
    return new PointerBoolPair<Value /*P*/ >(alloca.getPointer(), true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingLLVMValue::restore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3436,
   FQN="clang::CodeGen::DominatingLLVMValue::restore", NM="_ZN5clang7CodeGen19DominatingLLVMValue7restoreERNS0_15CodeGenFunctionEN4llvm14PointerIntPairIPNS4_5ValueELj1EbNS4_21PointerLikeTypeTraitsIS7_EENS4_18PointerIntPairInfoIS7_Lj1ES9_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen19DominatingLLVMValue7restoreERNS0_15CodeGenFunctionEN4llvm14PointerIntPairIPNS4_5ValueELj1EbNS4_21PointerLikeTypeTraitsIS7_EENS4_18PointerIntPairInfoIS7_Lj1ES9_EEEE")
  //</editor-fold>
  public static Value /*P*/ restore(final CodeGenFunction /*&*/ CGF, PointerBoolPair<Value /*P*/ > value) {
    // If the value says it wasn't saved, trust that it's still dominating.
    if (!value.getInt()) {
      return value.getPointer();
    }
    
    // Otherwise, it should be an alloca instruction, as set up in save().
    AllocaInst /*P*/ alloca = cast_AllocaInst(value.getPointer());
    return CGF.Builder.CreateAlignedLoad(alloca, alloca.getAlignment());
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
