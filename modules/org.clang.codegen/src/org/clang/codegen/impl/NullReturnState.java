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

package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.Type;


/// A helper class for performing the null-initialization of a return
/// value.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullReturnState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1561,
 FQN="(anonymous namespace)::NullReturnState", NM="_ZN12_GLOBAL__N_115NullReturnStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115NullReturnStateE")
//</editor-fold>
public class/*struct*/ NullReturnState {
  public BasicBlock /*P*/ NullBB;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullReturnState::NullReturnState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1563,
   FQN="(anonymous namespace)::NullReturnState::NullReturnState", NM="_ZN12_GLOBAL__N_115NullReturnStateC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115NullReturnStateC1Ev")
  //</editor-fold>
  public NullReturnState() {
    // : NullBB(null) 
    //START JInit
    this.NullBB = null;
    //END JInit
  }

  
  /// Perform a null-check of the given receiver.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullReturnState::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1566,
   FQN="(anonymous namespace)::NullReturnState::init", NM="_ZN12_GLOBAL__N_115NullReturnState4initERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115NullReturnState4initERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE")
  //</editor-fold>
  public void init(final CodeGenFunction /*&*/ CGF, Value /*P*/ receiver) {
    // Make blocks for the null-receiver and call edges.
    NullBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"msgSend.null-receiver"));
    BasicBlock /*P*/ callBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"msgSend.call"));
    
    // Check for a null receiver and, if there is one, jump to the
    // null-receiver block.  There's no point in trying to avoid it:
    // we're always going to put *something* there, because otherwise
    // we shouldn't have done this null-check in the first place.
    Value /*P*/ isNull = CGF.Builder.CreateIsNull(receiver);
    CGF.Builder.CreateCondBr(isNull, NullBB, callBB);
    
    // Otherwise, start performing the call.
    CGF.EmitBlock(callBB);
  }

  
  /// Complete the null-return operation.  It is valid to call this
  /// regardless of whether 'init' has been called.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullReturnState::complete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1584,
   FQN="(anonymous namespace)::NullReturnState::complete", NM="_ZN12_GLOBAL__N_115NullReturnState8completeERN5clang7CodeGen15CodeGenFunctionENS2_6RValueENS1_8QualTypeERKNS2_11CallArgListEPKNS1_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115NullReturnState8completeERN5clang7CodeGen15CodeGenFunctionENS2_6RValueENS1_8QualTypeERKNS2_11CallArgListEPKNS1_14ObjCMethodDeclE")
  //</editor-fold>
  public RValue complete(final CodeGenFunction /*&*/ CGF, RValue result, QualType resultType, 
          final /*const*/ CallArgList /*&*/ CallArgs, 
          /*const*/ ObjCMethodDecl /*P*/ Method) {
    // If we never had to do a null-check, just use the raw result.
    if (!(NullBB != null)) {
      return new RValue(JD$Move.INSTANCE, result);
    }
    
    // The continuation block.  This will be left null if we don't have an
    // IP, which can happen if the method we're calling is marked noreturn.
    BasicBlock /*P*/ contBB = null;
    
    // Finish the call path.
    BasicBlock /*P*/ callBB = CGF.Builder.GetInsertBlock();
    if ((callBB != null)) {
      contBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"msgSend.cont"));
      CGF.Builder.CreateBr(contBB);
    }
    
    // Okay, start emitting the null-receiver block.
    CGF.EmitBlock(NullBB);
    
    // Release any consumed arguments we've got.
    if ((Method != null)) {
      type$ptr</*const*/ CallArg /*P*/ > I = $tryClone(CallArgs.begin$Const());
      for (type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/> i = $tryClone(Method.param_begin$Const()), 
          /*P*/ /*const*/ /*P*/ e = $tryClone(Method.param_end$Const()); $noteq_ptr(i, e); i.$preInc() , I.$preInc()) {
        /*const*/ ParmVarDecl /*P*/ ParamDecl = (i.$star());
        if (ParamDecl.hasAttr(NSConsumedAttr.class)) {
          RValue RV = new RValue(I./*->*/$star().RV);
          assert (RV.isScalar()) : "NullReturnState::complete - arg not on object";
          CGF.EmitARCRelease(RV.getScalarVal(), ARCPreciseLifetime_t.ARCImpreciseLifetime);
        }
      }
    }
    
    // The phi code below assumes that we haven't needed any control flow yet.
    assert (CGF.Builder.GetInsertBlock() == NullBB);
    
    // If we've got a void return, just jump to the continuation block.
    if (result.isScalar() && resultType.$arrow().isVoidType()) {
      // No jumps required if the message-send was noreturn.
      if ((contBB != null)) {
        CGF.EmitBlock(contBB);
      }
      return new RValue(JD$Move.INSTANCE, result);
    }
    
    // If we've got a scalar return, build a phi.
    if (result.isScalar()) {
      // Derive the null-initialization value.
      Constant /*P*/ __null = CGF.CGM.EmitNullConstant(new QualType(resultType));
      
      // If no join is necessary, just flow out.
      if (!(contBB != null)) {
        return RValue.get(__null);
      }
      
      // Otherwise, build a phi.
      CGF.EmitBlock(contBB);
      PHINode /*P*/ phi = CGF.Builder.CreatePHI(__null.getType(), 2);
      phi.addIncoming(result.getScalarVal(), callBB);
      phi.addIncoming(__null, NullBB);
      return RValue.get(phi);
    }
    
    // If we've got an aggregate return, null the buffer out.
    // FIXME: maybe we should be doing things differently for all the
    // cases where the ABI has us returning (1) non-agg values in
    // memory or (2) agg values in registers.
    if (result.isAggregate()) {
      assert (result.isAggregate()) : "null init of non-aggregate result?";
      CGF.EmitNullInitialization(result.getAggregateAddress(), new QualType(resultType));
      if ((contBB != null)) {
        CGF.EmitBlock(contBB);
      }
      return new RValue(JD$Move.INSTANCE, result);
    }
    
    // Complex types.
    CGF.EmitBlock(contBB);
    std.pair<Value /*P*/ , Value /*P*/ > callResult = result.getComplexVal();
    
    // Find the scalar type and its zero value.
    Type /*P*/ scalarTy = callResult.first.getType();
    Constant /*P*/ scalarZero = Constant.getNullValue(scalarTy);
    
    // Build phis for both coordinates.
    PHINode /*P*/ real = CGF.Builder.CreatePHI(scalarTy, 2);
    real.addIncoming(callResult.first, callBB);
    real.addIncoming(scalarZero, NullBB);
    PHINode /*P*/ imag = CGF.Builder.CreatePHI(scalarTy, 2);
    imag.addIncoming(callResult.second, callBB);
    imag.addIncoming(scalarZero, NullBB);
    return RValue.getComplex(real, imag);
  }

  
  @Override public String toString() {
    return "" + "NullBB=" + NullBB; // NOI18N
  }
}
