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
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.codegen.impl.CGExprAggStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGExprAgg">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGExprAgg",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGExpr ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11EmitAggExprEPKNS_4ExprENS0_12AggValueSlotE;_ZN5clang7CodeGen15CodeGenFunction17EmitAggregateCopyENS0_7AddressES2_NS_8QualTypeEbb;_ZN5clang7CodeGen15CodeGenFunction19EmitAggExprToLValueEPKNS_4ExprE; -static-type=CodeGenFunction_CGExprAgg -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGExprAgg extends CodeGenFunction_CGExpr {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGExprAgg(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}


/// EmitAggregateCopy - Emit an aggregate copy.
///
/// \param isVolatile - True iff either the source or the destination is
/// volatile.
/// \param isAssignment - If false, allow padding to be copied.  This often
/// yields more efficient.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAggregateCopy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 1459,
 FQN="clang::CodeGen::CodeGenFunction::EmitAggregateCopy", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitAggregateCopyENS0_7AddressES2_NS_8QualTypeEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitAggregateCopyENS0_7AddressES2_NS_8QualTypeEbb")
//</editor-fold>
public final void EmitAggregateCopy(Address DestPtr, 
                 Address SrcPtr, QualType Ty) {
  EmitAggregateCopy(DestPtr, 
                 SrcPtr, Ty, 
                 false, 
                 false);
}
public final void EmitAggregateCopy(Address DestPtr, 
                 Address SrcPtr, QualType Ty, 
                 boolean isVolatile/*= false*/) {
  EmitAggregateCopy(DestPtr, 
                 SrcPtr, Ty, 
                 isVolatile, 
                 false);
}
public final void EmitAggregateCopy(Address DestPtr, 
                 Address SrcPtr, QualType Ty, 
                 boolean isVolatile/*= false*/, 
                 boolean isAssignment/*= false*/) {
  assert (!Ty.$arrow().isAnyComplexType()) : "Shouldn't happen for complex";
  if ($this().getLangOpts().CPlusPlus) {
    {
      /*const*/ RecordType /*P*/ RT = Ty.$arrow().getAs$RecordType();
      if ((RT != null)) {
        CXXRecordDecl /*P*/ Record = cast_CXXRecordDecl(RT.getDecl());
        assert ((Record.hasTrivialCopyConstructor() || Record.hasTrivialCopyAssignment() || Record.hasTrivialMoveConstructor() || Record.hasTrivialMoveAssignment() || Record.isUnion())) : "Trying to aggregate-copy a type without a trivial copy/move constructor or assignment operator";
        // Ignore empty classes in C++.
        if (Record.isEmpty()) {
          return;
        }
      }
    }
  }
  
  // Aggregate assignment turns into llvm.memcpy.  This is almost valid per
  // C99 6.5.16.1p3, which states "If the value being stored in an object is
  // read from another object that overlaps in anyway the storage of the first
  // object, then the overlap shall be exact and the two objects shall have
  // qualified or unqualified versions of a compatible type."
  //
  // memcpy is not defined if the source and destination pointers are exactly
  // equal, but other compilers do this optimization, and almost every memcpy
  // implementation handles this case safely.  If there is a libc that does not
  // safely handle this, we can add a target hook.
  
  // Get data size info for this aggregate. If this is an assignment,
  // don't copy the tail padding, because we might be assigning into a
  // base subobject where the tail padding is claimed.  Otherwise,
  // copying it is fine.
  std.pair<CharUnits, CharUnits> TypeInfo/*J*/= new std.pairTypeType<CharUnits, CharUnits>(new CharUnits(), new CharUnits());
  if (isAssignment) {
    TypeInfo.$assignMove($this().getContext().getTypeInfoDataSizeInChars(new QualType(Ty)));
  } else {
    TypeInfo.$assignMove($this().getContext().getTypeInfoInChars(new QualType(Ty)));
  }
  
  Value /*P*/ SizeVal = null;
  if (TypeInfo.first.isZero()) {
    {
      // But note that getTypeInfo returns 0 for a VLA.
      /*const*/ VariableArrayType /*P*/ VAT = dyn_cast_or_null_VariableArrayType($this().getContext().getAsArrayType(new QualType(Ty)));
      if ((VAT != null)) {
        QualType BaseEltTy/*J*/= new QualType();
        SizeVal = $this().emitArrayLength(VAT, BaseEltTy, DestPtr);
        TypeInfo.$assignMove($this().getContext().getTypeInfoDataSizeInChars(new QualType(BaseEltTy)));
        std.pair<CharUnits, CharUnits> LastElementTypeInfo/*J*/= new std.pairTypeType<CharUnits, CharUnits>(new CharUnits(), new CharUnits());
        if (!isAssignment) {
          LastElementTypeInfo.$assignMove($this().getContext().getTypeInfoInChars(new QualType(BaseEltTy)));
        }
        assert (!TypeInfo.first.isZero());
        SizeVal = $this().Builder.CreateNUWMul(SizeVal, 
            ConstantInt.get(Unnamed_field8.SizeTy, TypeInfo.first.getQuantity()));
        if (!isAssignment) {
          SizeVal = $this().Builder.CreateNUWSub(SizeVal, 
              ConstantInt.get(Unnamed_field8.SizeTy, TypeInfo.first.getQuantity()));
          SizeVal = $this().Builder.CreateNUWAdd(SizeVal, ConstantInt.get(Unnamed_field8.SizeTy, LastElementTypeInfo.first.getQuantity()));
        }
      }
    }
  }
  if (!(SizeVal != null)) {
    SizeVal = ConstantInt.get(Unnamed_field8.SizeTy, TypeInfo.first.getQuantity());
  }
  
  // FIXME: If we have a volatile struct, the optimizer can remove what might
  // appear to be `extra' memory ops:
  //
  // volatile struct { int i; } a, b;
  //
  // int main() {
  //   a = b;
  //   a = b;
  // }
  //
  // we need to use a different call here.  We use isVolatile to indicate when
  // either the source or the destination is volatile.
  DestPtr.$assignMove($this().Builder.CreateElementBitCast(new Address(DestPtr), Int8Ty));
  SrcPtr.$assignMove($this().Builder.CreateElementBitCast(new Address(SrcPtr), Int8Ty));
  
  // Don't do any of the memmove_collectable tests if GC isn't set.
  if ($this().CGM.getLangOpts().getGC() == LangOptions.GCMode.NonGC) {
    // fall through
  } else {
    /*const*/ RecordType /*P*/ RecordTy = Ty.$arrow().getAs$RecordType();
    if ((RecordTy != null)) {
      RecordDecl /*P*/ Record = RecordTy.getDecl();
      if (Record.hasObjectMember()) {
        $this().CGM.getObjCRuntime().EmitGCMemmoveCollectable(/*Deref*/$this(), new Address(DestPtr), new Address(SrcPtr), 
            SizeVal);
        return;
      }
    } else if (Ty.$arrow().isArrayType()) {
      QualType BaseType = $this().getContext().getBaseElementType(new QualType(Ty));
      {
        /*const*/ RecordType /*P*/ RecordTy$1 = BaseType.$arrow().getAs$RecordType();
        if ((RecordTy$1 != null)) {
          if (RecordTy$1.getDecl().hasObjectMember()) {
            $this().CGM.getObjCRuntime().EmitGCMemmoveCollectable(/*Deref*/$this(), new Address(DestPtr), new Address(SrcPtr), 
                SizeVal);
            return;
          }
        }
      }
    }
  }
  
  CallInst /*P*/ Inst = $this().Builder.CreateMemCpy(new Address(DestPtr), new Address(SrcPtr), SizeVal, isVolatile);
  {
    
    // Determine the metadata to describe the position of any padding in this
    // memcpy, as well as the TBAA tags for the members of the struct, in case
    // the optimizer wishes to expand it in to scalar memory operations.
    MDNode /*P*/ TBAAStructTag = $this().CGM.getTBAAStructInfo(new QualType(Ty));
    if ((TBAAStructTag != null)) {
      Inst.setMetadata(LLVMContext.Unnamed_enum.MD_tbaa_struct.getValue(), TBAAStructTag);
    }
  }
}


/// EmitAggExpr - Emit the computation of the specified expression
/// of aggregate type.  The result is computed into the given slot,
/// which may be null to indicate that the value is not needed.

/// EmitAggExpr - Emit the computation of the specified expression of aggregate
/// type.  The result is computed into DestPtr.  Note that if DestPtr is null,
/// the value of the aggregate expression is not needed.  If VolatileDest is
/// true, DestPtr cannot be 0.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAggExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 1437,
 FQN="clang::CodeGen::CodeGenFunction::EmitAggExpr", NM="_ZN5clang7CodeGen15CodeGenFunction11EmitAggExprEPKNS_4ExprENS0_12AggValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11EmitAggExprEPKNS_4ExprENS0_12AggValueSlotE")
//</editor-fold>
public final void EmitAggExpr(/*const*/ Expr /*P*/ E, AggValueSlot Slot) {
  assert ((E != null) && CodeGenFunction.hasAggregateEvaluationKind(E.getType())) : "Invalid aggregate expression to emit";
  assert ((Slot.getAddress().isValid() || Slot.isIgnored())) : "slot has bits but no address";
  
  // Optimize the slot if possible.
  CGExprAggStatics.CheckAggExprForMemSetUse(Slot, E, /*Deref*/$this());
  
  new AggExprEmitter(/*Deref*/$this(), new AggValueSlot(Slot), Slot.isIgnored()).Visit(((/*const_cast*/Expr /*P*/ )(E)));
}


/// EmitAggExprToLValue - Emit the computation of the specified expression of
/// aggregate type into a temporary LValue.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAggExprToLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 1449,
 FQN="clang::CodeGen::CodeGenFunction::EmitAggExprToLValue", NM="_ZN5clang7CodeGen15CodeGenFunction19EmitAggExprToLValueEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19EmitAggExprToLValueEPKNS_4ExprE")
//</editor-fold>
public final LValue EmitAggExprToLValue(/*const*/ Expr /*P*/ E) {
  assert (CodeGenFunction.hasAggregateEvaluationKind(E.getType())) : "Invalid argument!";
  Address Temp = $this().CreateMemTemp(E.getType());
  LValue LV = $this().MakeAddrLValue(new Address(Temp), E.getType());
  $this().EmitAggExpr(E, AggValueSlot.forLValue(LV, AggValueSlot.IsDestructed_t.IsNotDestructed, 
          AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers, 
          AggValueSlot.IsAliased_t.IsNotAliased));
  return LV;
}

} // END OF class CodeGenFunction_CGExprAgg
