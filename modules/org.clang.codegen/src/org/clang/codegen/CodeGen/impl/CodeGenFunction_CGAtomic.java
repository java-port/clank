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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.llvm.ir.java.IrRTTI;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGAtomic">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGAtomic",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_NotDefined ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitAtomicExprEPNS_10AtomicExprE;_ZN5clang7CodeGen15CodeGenFunction14EmitAtomicInitEPNS_4ExprENS0_6LValueE;_ZN5clang7CodeGen15CodeGenFunction14EmitAtomicLoadENS0_6LValueENS_14SourceLocationEN4llvm14AtomicOrderingEbNS0_12AggValueSlotE;_ZN5clang7CodeGen15CodeGenFunction14EmitAtomicLoadENS0_6LValueENS_14SourceLocationENS0_12AggValueSlotE;_ZN5clang7CodeGen15CodeGenFunction15EmitAtomicStoreENS0_6RValueENS0_6LValueEN4llvm14AtomicOrderingEbb;_ZN5clang7CodeGen15CodeGenFunction15EmitAtomicStoreENS0_6RValueENS0_6LValueEb;_ZN5clang7CodeGen15CodeGenFunction16EmitAtomicUpdateENS0_6LValueEN4llvm14AtomicOrderingERKNS3_12function_refIFNS0_6RValueES6_EEEb;_ZN5clang7CodeGen15CodeGenFunction25EmitAtomicCompareExchangeENS0_6LValueENS0_6RValueES3_NS_14SourceLocationEN4llvm14AtomicOrderingES6_bNS0_12AggValueSlotE;_ZN5clang7CodeGen15CodeGenFunction31LValueIsSuitableForInlineAtomicENS0_6LValueE; -static-type=CodeGenFunction_CGAtomic -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGAtomic extends CodeGenFunction_NotDefined {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGAtomic(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAtomicInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1816,
 FQN="clang::CodeGen::CodeGenFunction::EmitAtomicInit", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitAtomicInitEPNS_4ExprENS0_6LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitAtomicInitEPNS_4ExprENS0_6LValueE")
//</editor-fold>
public final void EmitAtomicInit(Expr /*P*/ init, LValue dest) {
  AtomicInfo atomics/*J*/= new AtomicInfo(/*Deref*/$this(), dest);
  switch (atomics.getEvaluationKind()) {
   case TEK_Scalar:
    {
      Value /*P*/ value = $this().EmitScalarExpr(init);
      atomics.emitCopyIntoMemory(RValue.get(value));
      return;
    }
   case TEK_Complex:
    {
      std.pair<Value /*P*/ , Value /*P*/ > value = $this().EmitComplexExpr(init);
      atomics.emitCopyIntoMemory(RValue.getComplex(value));
      return;
    }
   case TEK_Aggregate:
    {
      // Fix up the destination if the initializer isn't an expression
      // of atomic type.
      boolean Zeroed = false;
      if (!init.getType().$arrow().isAtomicType()) {
        Zeroed = atomics.emitMemSetZeroIfNecessary();
        dest.$assignMove(atomics.projectValue());
      }
      
      // Evaluate the expression directly into the destination.
      AggValueSlot slot = AggValueSlot.forLValue(dest, 
          AggValueSlot.IsDestructed_t.IsNotDestructed, 
          AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers, 
          AggValueSlot.IsAliased_t.IsNotAliased, 
          Zeroed ? AggValueSlot.IsZeroed_t.IsZeroed : AggValueSlot.IsZeroed_t.IsNotZeroed);
      
      $this().EmitAggExpr(init, new AggValueSlot(slot));
      return;
    }
  }
  throw new llvm_unreachable("bad evaluation kind");
}


/// An LValue is a candidate for having its loads and stores be made atomic if
/// we are operating under /volatile:ms *and* the LValue itself is volatile and
/// performing such an operation can be performed without a libcall.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::LValueIsSuitableForInlineAtomic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1271,
 FQN="clang::CodeGen::CodeGenFunction::LValueIsSuitableForInlineAtomic", NM="_ZN5clang7CodeGen15CodeGenFunction31LValueIsSuitableForInlineAtomicENS0_6LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction31LValueIsSuitableForInlineAtomicENS0_6LValueE")
//</editor-fold>
public final boolean LValueIsSuitableForInlineAtomic(LValue LV) {
  if (!$this().CGM.getCodeGenOpts().MSVolatile) {
    return false;
  }
  AtomicInfo AI/*J*/= new AtomicInfo(/*Deref*/$this(), LV);
  boolean IsVolatile = LV.isVolatile() || $this().hasVolatileMember(LV.getType());
  // An atomic is inline if we don't need to use a libcall.
  boolean AtomicIsInline = !AI.shouldUseLibcall();
  // MSVC doesn't seem to do this for types wider than a pointer.
  if ($greater_ulong($this().getContext().getTypeSize(LV.getType())
    , $this().getContext().getTypeSize($this().getContext().getIntPtrType()))) {
    return false;
  }
  return IsVolatile && AtomicIsInline;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAtomicLoad">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1284,
 FQN="clang::CodeGen::CodeGenFunction::EmitAtomicLoad", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitAtomicLoadENS0_6LValueENS_14SourceLocationENS0_12AggValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitAtomicLoadENS0_6LValueENS_14SourceLocationENS0_12AggValueSlotE")
//</editor-fold>
public final RValue EmitAtomicLoad(LValue LV, SourceLocation SL) {
  return EmitAtomicLoad(LV, SL, 
              AggValueSlot.ignored());
}
public final RValue EmitAtomicLoad(LValue LV, SourceLocation SL, 
              AggValueSlot Slot/*= AggValueSlot::ignored()*/) {
  AtomicOrdering AO;
  boolean IsVolatile = LV.isVolatileQualified();
  if (LV.getType().$arrow().isAtomicType()) {
    AO = AtomicOrdering.SequentiallyConsistent;
  } else {
    AO = AtomicOrdering.Acquire;
    IsVolatile = true;
  }
  return $this().EmitAtomicLoad(new LValue(LV), new SourceLocation(SL), AO, IsVolatile, new AggValueSlot(Slot));
}


/// Emit a load from an l-value of atomic type.  Note that the r-value
/// we produce is an r-value of the atomic *value* type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAtomicLoad">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1330,
 FQN="clang::CodeGen::CodeGenFunction::EmitAtomicLoad", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitAtomicLoadENS0_6LValueENS_14SourceLocationEN4llvm14AtomicOrderingEbNS0_12AggValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitAtomicLoadENS0_6LValueENS_14SourceLocationEN4llvm14AtomicOrderingEbNS0_12AggValueSlotE")
//</editor-fold>
public final RValue EmitAtomicLoad(LValue src, SourceLocation loc, 
              AtomicOrdering AO) {
  return EmitAtomicLoad(src, loc, 
              AO, false, 
              AggValueSlot.ignored());
}
public final RValue EmitAtomicLoad(LValue src, SourceLocation loc, 
              AtomicOrdering AO, boolean IsVolatile/*= false*/) {
  return EmitAtomicLoad(src, loc, 
              AO, IsVolatile, 
              AggValueSlot.ignored());
}
public final RValue EmitAtomicLoad(LValue src, SourceLocation loc, 
              AtomicOrdering AO, boolean IsVolatile/*= false*/, 
              AggValueSlot resultSlot/*= AggValueSlot::ignored()*/) {
  AtomicInfo Atomics/*J*/= new AtomicInfo(/*Deref*/$this(), src);
  return Atomics.EmitAtomicLoad(new AggValueSlot(resultSlot), new SourceLocation(loc), /*AsValue=*/ true, AO, 
      IsVolatile);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAtomicStore">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1706,
 FQN="clang::CodeGen::CodeGenFunction::EmitAtomicStore", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitAtomicStoreENS0_6RValueENS0_6LValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitAtomicStoreENS0_6RValueENS0_6LValueEb")
//</editor-fold>
public final void EmitAtomicStore(RValue rvalue, LValue lvalue, 
               boolean isInit) {
  boolean IsVolatile = lvalue.isVolatileQualified();
  AtomicOrdering AO;
  if (lvalue.getType().$arrow().isAtomicType()) {
    AO = AtomicOrdering.SequentiallyConsistent;
  } else {
    AO = AtomicOrdering.Release;
    IsVolatile = true;
  }
  $this().EmitAtomicStore(new RValue(rvalue), new LValue(lvalue), AO, IsVolatile, isInit);
  /*JAVA:return*/return;
}


/// Emit a store to an l-value of atomic type.
///
/// Note that the r-value is expected to be an r-value *of the atomic
/// type*; this means that for aggregate r-values, it should include
/// storage for any padding that was necessary.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAtomicStore">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1724,
 FQN="clang::CodeGen::CodeGenFunction::EmitAtomicStore", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitAtomicStoreENS0_6RValueENS0_6LValueEN4llvm14AtomicOrderingEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitAtomicStoreENS0_6RValueENS0_6LValueEN4llvm14AtomicOrderingEbb")
//</editor-fold>
public final void EmitAtomicStore(RValue rvalue, LValue dest, 
               AtomicOrdering AO, boolean IsVolatile, 
               boolean isInit) {
  // If this is an aggregate r-value, it should agree in type except
  // maybe for address-space qualification.
  assert (!rvalue.isAggregate() || rvalue.getAggregateAddress().getElementType() == dest.getAddress().getElementType());
  
  AtomicInfo atomics/*J*/= new AtomicInfo(/*Deref*/$this(), dest);
  LValue LVal = new LValue(atomics.getAtomicLValue());
  
  // If this is an initialization, just put the value there normally.
  if (LVal.isSimple()) {
    if (isInit) {
      atomics.emitCopyIntoMemory(new RValue(rvalue));
      return;
    }
    
    // Check whether we should use a library call.
    if (atomics.shouldUseLibcall()) {
      CallArgList args = null;
      try {
        // Produce a source address.
        Address srcAddr = atomics.materializeRValue(new RValue(rvalue));
        
        // void __atomic_store(size_t size, void *mem, void *val, int order)
        args/*J*/= new CallArgList();
        args.add(RValue.get(atomics.getAtomicSizeValue()), 
            $this().getContext().getSizeType().$QualType());
        args.add(RValue.get($this().EmitCastToVoidPtr(atomics.getAtomicPointer())), 
            $this().getContext().VoidPtrTy.$QualType());
        args.add(RValue.get($this().EmitCastToVoidPtr(srcAddr.getPointer())), 
            $this().getContext().VoidPtrTy.$QualType());
        args.add(RValue.get(ConstantInt.get(IntTy, $int2ulong(((int)AdtsupportLlvmGlobals.toCABI(AO).getValue())))), 
            $this().getContext().IntTy.$QualType());
        CGAtomicStatics.emitAtomicLibcall(/*Deref*/$this(), new StringRef(/*KEEP_STR*/"__atomic_store"), $this().getContext().VoidTy.$QualType(), args);
        return;
      } finally {
        if (args != null) { args.$destroy(); }
      }
    }
    
    // Okay, we're doing this natively.
    Value /*P*/ intValue = atomics.convertRValueToInt(new RValue(rvalue));
    
    // Do the atomic store.
    Address addr = atomics.emitCastToAtomicIntPointer(atomics.getAtomicAddress());
    intValue = $this().Builder.CreateIntCast(intValue, addr.getElementType(), /*isSigned=*/ false);
    StoreInst /*P*/ store = $this().Builder.CreateStore(intValue, new Address(addr));
    
    // Initializations don't need to be atomic.
    if (!isInit) {
      store.setAtomic(AO);
    }
    
    // Other decoration.
    if (IsVolatile) {
      store.setVolatile(true);
    }
    if ((dest.getTBAAInfo() != null)) {
      $this().CGM.DecorateInstructionWithTBAA(store, dest.getTBAAInfo());
    }
    return;
  }
  
  // Emit simple atomic update operation.
  atomics.EmitAtomicUpdate(AO, new RValue(rvalue), IsVolatile);
}


/// Emit a compare-and-exchange op for atomic type.
///
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAtomicCompareExchange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1791,
 FQN="clang::CodeGen::CodeGenFunction::EmitAtomicCompareExchange", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitAtomicCompareExchangeENS0_6LValueENS0_6RValueES3_NS_14SourceLocationEN4llvm14AtomicOrderingES6_bNS0_12AggValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitAtomicCompareExchangeENS0_6LValueENS0_6RValueES3_NS_14SourceLocationEN4llvm14AtomicOrderingES6_bNS0_12AggValueSlotE")
//</editor-fold>
public final std.pair<RValue, Value /*P*/ > EmitAtomicCompareExchange(LValue Obj, RValue Expected, RValue Desired, SourceLocation Loc) {
  return EmitAtomicCompareExchange(Obj, Expected, Desired, Loc, 
                         AtomicOrdering.SequentiallyConsistent, AtomicOrdering.SequentiallyConsistent, false, 
                         AggValueSlot.ignored());
}
public final std.pair<RValue, Value /*P*/ > EmitAtomicCompareExchange(LValue Obj, RValue Expected, RValue Desired, SourceLocation Loc, 
                         AtomicOrdering Success/*= AtomicOrdering::SequentiallyConsistent*/) {
  return EmitAtomicCompareExchange(Obj, Expected, Desired, Loc, 
                         Success, AtomicOrdering.SequentiallyConsistent, false, 
                         AggValueSlot.ignored());
}
public final std.pair<RValue, Value /*P*/ > EmitAtomicCompareExchange(LValue Obj, RValue Expected, RValue Desired, SourceLocation Loc, 
                         AtomicOrdering Success/*= AtomicOrdering::SequentiallyConsistent*/, AtomicOrdering Failure/*= AtomicOrdering::SequentiallyConsistent*/) {
  return EmitAtomicCompareExchange(Obj, Expected, Desired, Loc, 
                         Success, Failure, false, 
                         AggValueSlot.ignored());
}
public final std.pair<RValue, Value /*P*/ > EmitAtomicCompareExchange(LValue Obj, RValue Expected, RValue Desired, SourceLocation Loc, 
                         AtomicOrdering Success/*= AtomicOrdering::SequentiallyConsistent*/, AtomicOrdering Failure/*= AtomicOrdering::SequentiallyConsistent*/, boolean IsWeak/*= false*/) {
  return EmitAtomicCompareExchange(Obj, Expected, Desired, Loc, 
                         Success, Failure, IsWeak, 
                         AggValueSlot.ignored());
}
public final std.pair<RValue, Value /*P*/ > EmitAtomicCompareExchange(LValue Obj, RValue Expected, RValue Desired, SourceLocation Loc, 
                         AtomicOrdering Success/*= AtomicOrdering::SequentiallyConsistent*/, AtomicOrdering Failure/*= AtomicOrdering::SequentiallyConsistent*/, boolean IsWeak/*= false*/, 
                         AggValueSlot Slot/*= AggValueSlot::ignored()*/) {
  // If this is an aggregate r-value, it should agree in type except
  // maybe for address-space qualification.
  assert (!Expected.isAggregate() || Expected.getAggregateAddress().getElementType() == Obj.getAddress().getElementType());
  assert (!Desired.isAggregate() || Desired.getAggregateAddress().getElementType() == Obj.getAddress().getElementType());
  AtomicInfo Atomics/*J*/= new AtomicInfo(/*Deref*/$this(), Obj);
  
  return Atomics.EmitAtomicCompareExchange(new RValue(Expected), new RValue(Desired), Success, Failure, 
      IsWeak);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAtomicUpdate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 1809,
 FQN="clang::CodeGen::CodeGenFunction::EmitAtomicUpdate", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitAtomicUpdateENS0_6LValueEN4llvm14AtomicOrderingERKNS3_12function_refIFNS0_6RValueES6_EEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitAtomicUpdateENS0_6LValueEN4llvm14AtomicOrderingERKNS3_12function_refIFNS0_6RValueES6_EEEb")
//</editor-fold>
public final void EmitAtomicUpdate(LValue LVal, AtomicOrdering AO, 
                final /*const*/Type2Type<RValue> /*&*/ UpdateOp, boolean IsVolatile) {
  AtomicInfo Atomics/*J*/= new AtomicInfo(/*Deref*/$this(), LVal);
  Atomics.EmitAtomicUpdate(AO, UpdateOp, IsVolatile);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAtomicExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp", line = 661,
 FQN="clang::CodeGen::CodeGenFunction::EmitAtomicExpr", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitAtomicExprEPNS_10AtomicExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitAtomicExprEPNS_10AtomicExprE")
//</editor-fold>
public final RValue EmitAtomicExpr(AtomicExpr /*P*/ E) {
  QualType AtomicTy = E.getPtr().getType().$arrow().getPointeeType();
  QualType MemTy = new QualType(AtomicTy);
  {
    /*const*/ AtomicType /*P*/ AT = AtomicTy.$arrow().getAs(AtomicType.class);
    if ((AT != null)) {
      MemTy.$assignMove(AT.getValueType());
    }
  }
  CharUnits sizeChars/*J*/= new CharUnits();
  CharUnits alignChars/*J*/= new CharUnits();
  std.tie(sizeChars, alignChars).$assign($this().getContext().getTypeInfoInChars(new QualType(AtomicTy)));
  long/*uint64_t*/ Size = sizeChars.getQuantity();
  /*uint*/int MaxInlineWidthInBits = $this().getTarget().getMaxAtomicInlineWidth();
  boolean UseLibcall = (sizeChars.$noteq(alignChars)
     || $this().getContext().toBits(new CharUnits(sizeChars)) > $uint2llong(MaxInlineWidthInBits));
  
  Value /*P*/ IsWeak = null;
  Value /*P*/ OrderFail = null;
  
  Address Val1 = Address.invalid();
  Address Val2 = Address.invalid();
  Address Dest = Address.invalid();
  Address Ptr/*J*/= new Address($this().EmitScalarExpr(E.getPtr()), new CharUnits(alignChars));
  if (E.getOp() == AtomicExpr.AtomicOp.AO__c11_atomic_init) {
    LValue lvalue = $this().MakeAddrLValue(new Address(Ptr), new QualType(AtomicTy));
    $this().EmitAtomicInit(E.getVal1(), new LValue(lvalue));
    return RValue.get((Value /*P*/ )null);
  }
  
  Value /*P*/ Order = $this().EmitScalarExpr(E.getOrder());
  switch (E.getOp()) {
   case AO__c11_atomic_init:
    throw new llvm_unreachable("Already handled above with EmitAtomicInit!");
   case AO__c11_atomic_load:
   case AO__atomic_load_n:
    break;
   case AO__atomic_load:
    Dest.$assignMove($this().EmitPointerWithAlignment(E.getVal1()));
    break;
   case AO__atomic_store:
    Val1.$assignMove($this().EmitPointerWithAlignment(E.getVal1()));
    break;
   case AO__atomic_exchange:
    Val1.$assignMove($this().EmitPointerWithAlignment(E.getVal1()));
    Dest.$assignMove($this().EmitPointerWithAlignment(E.getVal2()));
    break;
   case AO__c11_atomic_compare_exchange_strong:
   case AO__c11_atomic_compare_exchange_weak:
   case AO__atomic_compare_exchange_n:
   case AO__atomic_compare_exchange:
    Val1.$assignMove($this().EmitPointerWithAlignment(E.getVal1()));
    if (E.getOp() == AtomicExpr.AtomicOp.AO__atomic_compare_exchange) {
      Val2.$assignMove($this().EmitPointerWithAlignment(E.getVal2()));
    } else {
      Val2.$assignMove(CGAtomicStatics.EmitValToTemp(/*Deref*/$this(), E.getVal2()));
    }
    OrderFail = $this().EmitScalarExpr(E.getOrderFail());
    if (E.getNumSubExprs() == 6) {
      IsWeak = $this().EmitScalarExpr(E.getWeak());
    }
    break;
   case AO__c11_atomic_fetch_add:
   case AO__c11_atomic_fetch_sub:
    if (MemTy.$arrow().isPointerType()) {
      // For pointer arithmetic, we're required to do a bit of math:
      // adding 1 to an int* is not the same as adding 1 to a uintptr_t.
      // ... but only for the C11 builtins. The GNU builtins expect the
      // user to multiply by sizeof(T).
      QualType Val1Ty = E.getVal1().getType();
      Value /*P*/ Val1Scalar = $this().EmitScalarExpr(E.getVal1());
      CharUnits PointeeIncAmt = $this().getContext().getTypeSizeInChars(MemTy.$arrow().getPointeeType());
      Val1Scalar = $this().Builder.CreateMul(Val1Scalar, $this().CGM.getSize(new CharUnits(PointeeIncAmt)));
      Address Temp = $this().CreateMemTemp(new QualType(Val1Ty), new Twine(/*KEEP_STR*/".atomictmp"));
      Val1.$assign(Temp);
      $this().EmitStoreOfScalar(Val1Scalar, $this().MakeAddrLValue(new Address(Temp), new QualType(Val1Ty)));
      break;
    }
   case AO__atomic_fetch_add:
   case AO__atomic_fetch_sub:
   case AO__atomic_add_fetch:
   case AO__atomic_sub_fetch:
   case AO__c11_atomic_store:
   case AO__c11_atomic_exchange:
   case AO__atomic_store_n:
   case AO__atomic_exchange_n:
   case AO__c11_atomic_fetch_and:
   case AO__c11_atomic_fetch_or:
   case AO__c11_atomic_fetch_xor:
   case AO__atomic_fetch_and:
   case AO__atomic_fetch_or:
   case AO__atomic_fetch_xor:
   case AO__atomic_fetch_nand:
   case AO__atomic_and_fetch:
   case AO__atomic_or_fetch:
   case AO__atomic_xor_fetch:
   case AO__atomic_nand_fetch:
    // Fall through.
    Val1.$assignMove(CGAtomicStatics.EmitValToTemp(/*Deref*/$this(), E.getVal1()));
    break;
  }
  
  QualType RValTy = E.getType().getUnqualifiedType();
  
  // The inlined atomics only function on iN types, where N is a power of 2. We
  // need to make sure (via temporaries if necessary) that all incoming values
  // are compatible.
  LValue AtomicVal = $this().MakeAddrLValue(new Address(Ptr), new QualType(AtomicTy));
  AtomicInfo Atomics/*J*/= new AtomicInfo(/*Deref*/$this(), AtomicVal);
  
  Ptr.$assignMove(Atomics.emitCastToAtomicIntPointer(new Address(Ptr)));
  if (Val1.isValid()) {
    Val1.$assignMove(Atomics.convertToAtomicIntPointer(new Address(Val1)));
  }
  if (Val2.isValid()) {
    Val2.$assignMove(Atomics.convertToAtomicIntPointer(new Address(Val2)));
  }
  if (Dest.isValid()) {
    Dest.$assignMove(Atomics.emitCastToAtomicIntPointer(new Address(Dest)));
  } else if (E.isCmpXChg()) {
    Dest.$assignMove($this().CreateMemTemp(new QualType(RValTy), new Twine(/*KEEP_STR*/"cmpxchg.bool")));
  } else if (!RValTy.$arrow().isVoidType()) {
    Dest.$assignMove(Atomics.emitCastToAtomicIntPointer(Atomics.CreateTempAlloca()));
  }
  
  // Use a library call.  See: http://gcc.gnu.org/wiki/Atomic/GCCMM/LIbrary .
  if (UseLibcall) {
    CallArgList Args = null;
    try {
      boolean UseOptimizedLibcall = false;
      switch (E.getOp()) {
       case AO__c11_atomic_init:
        throw new llvm_unreachable("Already handled above with EmitAtomicInit!");
       case AO__c11_atomic_fetch_add:
       case AO__atomic_fetch_add:
       case AO__c11_atomic_fetch_and:
       case AO__atomic_fetch_and:
       case AO__c11_atomic_fetch_or:
       case AO__atomic_fetch_or:
       case AO__atomic_fetch_nand:
       case AO__c11_atomic_fetch_sub:
       case AO__atomic_fetch_sub:
       case AO__c11_atomic_fetch_xor:
       case AO__atomic_fetch_xor:
       case AO__atomic_add_fetch:
       case AO__atomic_and_fetch:
       case AO__atomic_nand_fetch:
       case AO__atomic_or_fetch:
       case AO__atomic_sub_fetch:
       case AO__atomic_xor_fetch:
        // For these, only library calls for certain sizes exist.
        UseOptimizedLibcall = true;
        break;
       case AO__c11_atomic_load:
       case AO__c11_atomic_store:
       case AO__c11_atomic_exchange:
       case AO__c11_atomic_compare_exchange_weak:
       case AO__c11_atomic_compare_exchange_strong:
       case AO__atomic_load_n:
       case AO__atomic_load:
       case AO__atomic_store_n:
       case AO__atomic_store:
       case AO__atomic_exchange_n:
       case AO__atomic_exchange:
       case AO__atomic_compare_exchange_n:
       case AO__atomic_compare_exchange:
        // Only use optimized library calls for sizes for which they exist.
        if (Size == $int2ullong(1) || Size == $int2ullong(2) || Size == $int2ullong(4) || Size == $int2ullong(8)) {
          UseOptimizedLibcall = true;
        }
        break;
      }
      
      Args/*J*/= new CallArgList();
      if (!UseOptimizedLibcall) {
        // For non-optimized library calls, the size is the first parameter
        Args.add(RValue.get(ConstantInt.get(Unnamed_field8.SizeTy, Size)), 
            $this().getContext().getSizeType().$QualType());
      }
      // Atomic address is the first or second parameter
      Args.add(RValue.get($this().EmitCastToVoidPtr(Ptr.getPointer())), 
          $this().getContext().VoidPtrTy.$QualType());
      
      std.string LibCallName/*J*/= new std.string();
      QualType LoweredMemTy = MemTy.$arrow().isPointerType() ? $this().getContext().getIntPtrType() : new QualType(MemTy);
      QualType RetTy/*J*/= new QualType();
      boolean HaveRetTy = false;
      /*BinaryOps*/int PostOp = (0);
      switch (E.getOp()) {
       case AO__c11_atomic_init:
        throw new llvm_unreachable("Already handled!");
       case AO__c11_atomic_compare_exchange_weak:
       case AO__c11_atomic_compare_exchange_strong:
       case AO__atomic_compare_exchange:
       case AO__atomic_compare_exchange_n:
        
        // There is only one libcall for compare an exchange, because there is no
        // optimisation benefit possible from a libcall version of a weak compare
        // and exchange.
        // bool __atomic_compare_exchange(size_t size, void *mem, void *expected,
        //                                void *desired, int success, int failure)
        // bool __atomic_compare_exchange_N(T *mem, T *expected, T desired,
        //                                  int success, int failure)
        LibCallName.$assign_T$C$P(/*KEEP_STR*/"__atomic_compare_exchange");
        RetTy.$assignMove($this().getContext().BoolTy.$QualType());
        HaveRetTy = true;
        Args.add(RValue.get($this().EmitCastToVoidPtr(Val1.getPointer())), 
            $this().getContext().VoidPtrTy.$QualType());
        CGAtomicStatics.AddDirectArgument(/*Deref*/$this(), Args, UseOptimizedLibcall, Val2.getPointer(), 
            new QualType(MemTy), E.getExprLoc(), new CharUnits(sizeChars));
        Args.add(RValue.get(Order), $this().getContext().IntTy.$QualType());
        Order = OrderFail;
        break;
       case AO__c11_atomic_exchange:
       case AO__atomic_exchange_n:
       case AO__atomic_exchange:
        // void __atomic_exchange(size_t size, void *mem, void *val, void *return,
        //                        int order)
        // T __atomic_exchange_N(T *mem, T val, int order)
        LibCallName.$assign_T$C$P(/*KEEP_STR*/"__atomic_exchange");
        CGAtomicStatics.AddDirectArgument(/*Deref*/$this(), Args, UseOptimizedLibcall, Val1.getPointer(), 
            new QualType(MemTy), E.getExprLoc(), new CharUnits(sizeChars));
        break;
       case AO__c11_atomic_store:
       case AO__atomic_store:
       case AO__atomic_store_n:
        // void __atomic_store(size_t size, void *mem, void *val, int order)
        // void __atomic_store_N(T *mem, T val, int order)
        LibCallName.$assign_T$C$P(/*KEEP_STR*/"__atomic_store");
        RetTy.$assignMove($this().getContext().VoidTy.$QualType());
        HaveRetTy = true;
        CGAtomicStatics.AddDirectArgument(/*Deref*/$this(), Args, UseOptimizedLibcall, Val1.getPointer(), 
            new QualType(MemTy), E.getExprLoc(), new CharUnits(sizeChars));
        break;
       case AO__c11_atomic_load:
       case AO__atomic_load:
       case AO__atomic_load_n:
        // void __atomic_load(size_t size, void *mem, void *return, int order)
        // T __atomic_load_N(T *mem, int order)
        LibCallName.$assign_T$C$P(/*KEEP_STR*/"__atomic_load");
        break;
       case AO__atomic_add_fetch:
        // T __atomic_add_fetch_N(T *mem, T val, int order)
        // T __atomic_fetch_add_N(T *mem, T val, int order)
        PostOp = Instruction.BinaryOps.Add;
       case AO__c11_atomic_fetch_add:
       case AO__atomic_fetch_add:
        // Fall through.
        LibCallName.$assign_T$C$P(/*KEEP_STR*/"__atomic_fetch_add");
        CGAtomicStatics.AddDirectArgument(/*Deref*/$this(), Args, UseOptimizedLibcall, Val1.getPointer(), 
            new QualType(LoweredMemTy), E.getExprLoc(), new CharUnits(sizeChars));
        break;
       case AO__atomic_and_fetch:
        // T __atomic_and_fetch_N(T *mem, T val, int order)
        // T __atomic_fetch_and_N(T *mem, T val, int order)
        PostOp = Instruction.BinaryOps.And;
       case AO__c11_atomic_fetch_and:
       case AO__atomic_fetch_and:
        // Fall through.
        LibCallName.$assign_T$C$P(/*KEEP_STR*/"__atomic_fetch_and");
        CGAtomicStatics.AddDirectArgument(/*Deref*/$this(), Args, UseOptimizedLibcall, Val1.getPointer(), 
            new QualType(MemTy), E.getExprLoc(), new CharUnits(sizeChars));
        break;
       case AO__atomic_or_fetch:
        // T __atomic_or_fetch_N(T *mem, T val, int order)
        // T __atomic_fetch_or_N(T *mem, T val, int order)
        PostOp = Instruction.BinaryOps.Or;
       case AO__c11_atomic_fetch_or:
       case AO__atomic_fetch_or:
        // Fall through.
        LibCallName.$assign_T$C$P(/*KEEP_STR*/"__atomic_fetch_or");
        CGAtomicStatics.AddDirectArgument(/*Deref*/$this(), Args, UseOptimizedLibcall, Val1.getPointer(), 
            new QualType(MemTy), E.getExprLoc(), new CharUnits(sizeChars));
        break;
       case AO__atomic_sub_fetch:
        // T __atomic_sub_fetch_N(T *mem, T val, int order)
        // T __atomic_fetch_sub_N(T *mem, T val, int order)
        PostOp = Instruction.BinaryOps.Sub;
       case AO__c11_atomic_fetch_sub:
       case AO__atomic_fetch_sub:
        // Fall through.
        LibCallName.$assign_T$C$P(/*KEEP_STR*/"__atomic_fetch_sub");
        CGAtomicStatics.AddDirectArgument(/*Deref*/$this(), Args, UseOptimizedLibcall, Val1.getPointer(), 
            new QualType(LoweredMemTy), E.getExprLoc(), new CharUnits(sizeChars));
        break;
       case AO__atomic_xor_fetch:
        // T __atomic_xor_fetch_N(T *mem, T val, int order)
        // T __atomic_fetch_xor_N(T *mem, T val, int order)
        PostOp = Instruction.BinaryOps.Xor;
       case AO__c11_atomic_fetch_xor:
       case AO__atomic_fetch_xor:
        // Fall through.
        LibCallName.$assign_T$C$P(/*KEEP_STR*/"__atomic_fetch_xor");
        CGAtomicStatics.AddDirectArgument(/*Deref*/$this(), Args, UseOptimizedLibcall, Val1.getPointer(), 
            new QualType(MemTy), E.getExprLoc(), new CharUnits(sizeChars));
        break;
       case AO__atomic_nand_fetch:
        // T __atomic_nand_fetch_N(T *mem, T val, int order)
        // T __atomic_fetch_nand_N(T *mem, T val, int order)
        PostOp = Instruction.BinaryOps.And; // the NOT is special cased below
       case AO__atomic_fetch_nand:
        // Fall through.
        LibCallName.$assign_T$C$P(/*KEEP_STR*/"__atomic_fetch_nand");
        CGAtomicStatics.AddDirectArgument(/*Deref*/$this(), Args, UseOptimizedLibcall, Val1.getPointer(), 
            new QualType(MemTy), E.getExprLoc(), new CharUnits(sizeChars));
        break;
      }
      
      // Optimized functions have the size in their name.
      if (UseOptimizedLibcall) {
        LibCallName.$addassign($add_T$C$P_string(/*KEEP_STR*/"_", llvm.utostr(Size)));
      }
      // By default, assume we return a value of the atomic type.
      if (!HaveRetTy) {
        if (UseOptimizedLibcall) {
          // Value is returned directly.
          // The function returns an appropriately sized integer type.
          RetTy.$assignMove($this().getContext().getIntTypeForBitwidth($long2uint($this().getContext().toBits(new CharUnits(sizeChars))), /*Signed=*/ /*false*/0));
        } else {
          // Value is returned through parameter before the order.
          RetTy.$assignMove($this().getContext().VoidTy.$QualType());
          Args.add(RValue.get($this().EmitCastToVoidPtr(Dest.getPointer())), 
              $this().getContext().VoidPtrTy.$QualType());
        }
      }
      // order is always the last parameter
      Args.add(RValue.get(Order), 
          $this().getContext().IntTy.$QualType());
      
      // PostOp is only needed for the atomic_*_fetch operations, and
      // thus is only needed for and implemented in the
      // UseOptimizedLibcall codepath.
      assert (UseOptimizedLibcall || !(PostOp != 0));
      
      RValue Res = CGAtomicStatics.emitAtomicLibcall(/*Deref*/$this(), new StringRef(LibCallName), new QualType(RetTy), Args);
      // The value is returned directly from the libcall.
      if (E.isCmpXChg()) {
        return Res;
      }
      
      // The value is returned directly for optimized libcalls but the expr
      // provided an out-param.
      if (UseOptimizedLibcall && (Res.getScalarVal() != null)) {
        Value /*P*/ ResVal = Res.getScalarVal();
        if ((PostOp != 0)) {
          Value /*P*/ LoadVal1 = Args.$at(1).RV.getScalarVal();
          ResVal = $this().Builder.CreateBinOp(PostOp, ResVal, LoadVal1);
        }
        if (E.getOp() == AtomicExpr.AtomicOp.AO__atomic_nand_fetch) {
          ResVal = $this().Builder.CreateNot(ResVal);
        }
        
        $this().Builder.CreateStore(ResVal, 
            $this().Builder.CreateBitCast(new Address(Dest), ResVal.getType().getPointerTo()));
      }
      if (RValTy.$arrow().isVoidType()) {
        return RValue.get((Value /*P*/ )null);
      }
      
      return $this().convertTempToRValue($this().Builder.CreateBitCast(new Address(Dest), $this().ConvertTypeForMem(new QualType(RValTy)).getPointerTo()), 
          new QualType(RValTy), E.getExprLoc());
    } finally {
      if (Args != null) { Args.$destroy(); }
    }
  }
  
  boolean IsStore = E.getOp() == AtomicExpr.AtomicOp.AO__c11_atomic_store
     || E.getOp() == AtomicExpr.AtomicOp.AO__atomic_store
     || E.getOp() == AtomicExpr.AtomicOp.AO__atomic_store_n;
  boolean IsLoad = E.getOp() == AtomicExpr.AtomicOp.AO__c11_atomic_load
     || E.getOp() == AtomicExpr.AtomicOp.AO__atomic_load
     || E.getOp() == AtomicExpr.AtomicOp.AO__atomic_load_n;
  if (IrRTTI.isa_ConstantInt(Order)) {
    long/*uint64_t*/ ord = IrRTTI.cast_ConstantInt(Order).getZExtValue();
    // We should not ever get to a case where the ordering isn't a valid C ABI
    // value, but it's hard to enforce that in general.
    if (llvm.isValidAtomicOrderingCABI(ord)) {
      switch (AtomicOrderingCABI.valueOf(ord)) {
       case relaxed:
        CGAtomicStatics.EmitAtomicOp(/*Deref*/$this(), E, new Address(Dest), new Address(Ptr), new Address(Val1), new Address(Val2), IsWeak, OrderFail, Size, 
            AtomicOrdering.Monotonic);
        break;
       case consume:
       case acquire:
        if (IsStore) {
          break; // Avoid crashing on code with undefined behavior
        }
        CGAtomicStatics.EmitAtomicOp(/*Deref*/$this(), E, new Address(Dest), new Address(Ptr), new Address(Val1), new Address(Val2), IsWeak, OrderFail, Size, 
            AtomicOrdering.Acquire);
        break;
       case release:
        if (IsLoad) {
          break; // Avoid crashing on code with undefined behavior
        }
        CGAtomicStatics.EmitAtomicOp(/*Deref*/$this(), E, new Address(Dest), new Address(Ptr), new Address(Val1), new Address(Val2), IsWeak, OrderFail, Size, 
            AtomicOrdering.Release);
        break;
       case acq_rel:
        if (IsLoad || IsStore) {
          break; // Avoid crashing on code with undefined behavior
        }
        CGAtomicStatics.EmitAtomicOp(/*Deref*/$this(), E, new Address(Dest), new Address(Ptr), new Address(Val1), new Address(Val2), IsWeak, OrderFail, Size, 
            AtomicOrdering.AcquireRelease);
        break;
       case seq_cst:
        CGAtomicStatics.EmitAtomicOp(/*Deref*/$this(), E, new Address(Dest), new Address(Ptr), new Address(Val1), new Address(Val2), IsWeak, OrderFail, Size, 
            AtomicOrdering.SequentiallyConsistent);
        break;
      }
    }
    if (RValTy.$arrow().isVoidType()) {
      return RValue.get((Value /*P*/ )null);
    }
    
    return $this().convertTempToRValue($this().Builder.CreateBitCast(new Address(Dest), $this().ConvertTypeForMem(new QualType(RValTy)).getPointerTo()), 
        new QualType(RValTy), E.getExprLoc());
  }
  
  // Long case, when Order isn't obviously constant.
  
  // Create all the relevant BB's
  BasicBlock /*P*/ MonotonicBB = null;
  BasicBlock /*P*/ AcquireBB = null;
  BasicBlock /*P*/ ReleaseBB = null;
  BasicBlock /*P*/ AcqRelBB = null;
  BasicBlock /*P*/ SeqCstBB = null;
  MonotonicBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"monotonic"), $this().CurFn);
  if (!IsStore) {
    AcquireBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"acquire"), $this().CurFn);
  }
  if (!IsLoad) {
    ReleaseBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"release"), $this().CurFn);
  }
  if (!IsLoad && !IsStore) {
    AcqRelBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"acqrel"), $this().CurFn);
  }
  SeqCstBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"seqcst"), $this().CurFn);
  BasicBlock /*P*/ ContBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"atomic.continue"), $this().CurFn);
  
  // Create the switch for the split
  // MonotonicBB is arbitrarily chosen as the default case; in practice, this
  // doesn't matter unless someone is crazy enough to use something that
  // doesn't fold to a constant for the ordering.
  Order = $this().Builder.CreateIntCast(Order, $this().Builder.getInt32Ty(), false);
  SwitchInst /*P*/ SI = $this().Builder.CreateSwitch(Order, MonotonicBB);
  
  // Emit all the different atomics
  $this().Builder.SetInsertPoint(MonotonicBB);
  CGAtomicStatics.EmitAtomicOp(/*Deref*/$this(), E, new Address(Dest), new Address(Ptr), new Address(Val1), new Address(Val2), IsWeak, OrderFail, 
      Size, AtomicOrdering.Monotonic);
  $this().Builder.CreateBr(ContBB);
  if (!IsStore) {
    $this().Builder.SetInsertPoint(AcquireBB);
    CGAtomicStatics.EmitAtomicOp(/*Deref*/$this(), E, new Address(Dest), new Address(Ptr), new Address(Val1), new Address(Val2), IsWeak, OrderFail, 
        Size, AtomicOrdering.Acquire);
    $this().Builder.CreateBr(ContBB);
    SI.addCase($this().Builder.getInt32(((int)AtomicOrderingCABI.consume.getValue())), 
        AcquireBB);
    SI.addCase($this().Builder.getInt32(((int)AtomicOrderingCABI.acquire.getValue())), 
        AcquireBB);
  }
  if (!IsLoad) {
    $this().Builder.SetInsertPoint(ReleaseBB);
    CGAtomicStatics.EmitAtomicOp(/*Deref*/$this(), E, new Address(Dest), new Address(Ptr), new Address(Val1), new Address(Val2), IsWeak, OrderFail, 
        Size, AtomicOrdering.Release);
    $this().Builder.CreateBr(ContBB);
    SI.addCase($this().Builder.getInt32(((int)AtomicOrderingCABI.release.getValue())), 
        ReleaseBB);
  }
  if (!IsLoad && !IsStore) {
    $this().Builder.SetInsertPoint(AcqRelBB);
    CGAtomicStatics.EmitAtomicOp(/*Deref*/$this(), E, new Address(Dest), new Address(Ptr), new Address(Val1), new Address(Val2), IsWeak, OrderFail, 
        Size, AtomicOrdering.AcquireRelease);
    $this().Builder.CreateBr(ContBB);
    SI.addCase($this().Builder.getInt32(((int)AtomicOrderingCABI.acq_rel.getValue())), 
        AcqRelBB);
  }
  $this().Builder.SetInsertPoint(SeqCstBB);
  CGAtomicStatics.EmitAtomicOp(/*Deref*/$this(), E, new Address(Dest), new Address(Ptr), new Address(Val1), new Address(Val2), IsWeak, OrderFail, 
      Size, AtomicOrdering.SequentiallyConsistent);
  $this().Builder.CreateBr(ContBB);
  SI.addCase($this().Builder.getInt32(((int)AtomicOrderingCABI.seq_cst.getValue())), 
      SeqCstBB);
  
  // Cleanup and return
  $this().Builder.SetInsertPoint(ContBB);
  if (RValTy.$arrow().isVoidType()) {
    return RValue.get((Value /*P*/ )null);
  }
  assert ($lesseq_ulong(Atomics.getValueSizeInBits(), Atomics.getAtomicSizeInBits()));
  return $this().convertTempToRValue($this().Builder.CreateBitCast(new Address(Dest), $this().ConvertTypeForMem(new QualType(RValTy)).getPointerTo()), 
      new QualType(RValTy), E.getExprLoc());
}

} // END OF class CodeGenFunction_CGAtomic
