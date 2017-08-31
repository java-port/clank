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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.llvm.ir.ArrayType;
import org.llvm.ir.Type;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clank.support.Native.$AddrOf;
import static org.clank.support.Native.$Deref;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenModule_CGExprConstant">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.CodeGen.impl.CodeGenModule_CGExprConstant",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this -extends=CodeGenModule_CGExpr ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN5clang7CodeGen13CodeGenModule16EmitConstantExprEPKNS_4ExprENS_8QualTypeEPNS0_15CodeGenFunctionE;_ZN5clang7CodeGen13CodeGenModule16EmitConstantInitERKNS_7VarDeclEPNS0_15CodeGenFunctionE;_ZN5clang7CodeGen13CodeGenModule16EmitNullConstantENS_8QualTypeE;_ZN5clang7CodeGen13CodeGenModule17EmitConstantValueERKNS_7APValueENS_8QualTypeEPNS0_15CodeGenFunctionE;_ZN5clang7CodeGen13CodeGenModule23EmitNullConstantForBaseEPKNS_13CXXRecordDeclE;_ZN5clang7CodeGen13CodeGenModule24getMemberPointerConstantEPKNS_13UnaryOperatorE;_ZN5clang7CodeGen13CodeGenModule26EmitConstantValueForMemoryERKNS_7APValueENS_8QualTypeEPNS0_15CodeGenFunctionE;_ZN5clang7CodeGen13CodeGenModule32GetAddrOfConstantCompoundLiteralEPKNS_19CompoundLiteralExprE; -static-type=CodeGenModule_CGExprConstant -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenModule_CGExprConstant extends CodeGenModule_CGExpr {
private final /*split clang::CodeGen::CodeGenModule*/ CodeGenModule $this() { return (CodeGenModule)this; }


/// Returns a pointer to a constant global variable for the given file-scope
/// compound literal expression.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetAddrOfConstantCompoundLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 1483,
 FQN="clang::CodeGen::CodeGenModule::GetAddrOfConstantCompoundLiteral", NM="_ZN5clang7CodeGen13CodeGenModule32GetAddrOfConstantCompoundLiteralEPKNS_19CompoundLiteralExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN5clang7CodeGen13CodeGenModule32GetAddrOfConstantCompoundLiteralEPKNS_19CompoundLiteralExprE")
//</editor-fold>
public final ConstantAddress GetAddrOfConstantCompoundLiteral(/*const*/ CompoundLiteralExpr /*P*/ E) {
  assert (E.isFileScope()) : "not a file-scope compound literal expr";
  return new ConstExprEmitter(/*Deref*/$this(), (CodeGenFunction /*P*/ )null).EmitLValue(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T1.INSTANCE, /*const*/ Expr /*P*/.class, E));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getMemberPointerConstant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 1489,
 FQN="clang::CodeGen::CodeGenModule::getMemberPointerConstant", NM="_ZN5clang7CodeGen13CodeGenModule24getMemberPointerConstantEPKNS_13UnaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN5clang7CodeGen13CodeGenModule24getMemberPointerConstantEPKNS_13UnaryOperatorE")
//</editor-fold>
public final Constant /*P*/ getMemberPointerConstant(/*const*/ UnaryOperator /*P*/ uo) {
  // Member pointer constants always have a very particular form.
  /*const*/ MemberPointerType /*P*/ type = cast_MemberPointerType(uo.getType());
  /*const*/ ValueDecl /*P*/ decl = cast_DeclRefExpr(uo.getSubExpr()).getDecl();
  {
    
    // A member function pointer.
    /*const*/ CXXMethodDecl /*P*/ method = dyn_cast_CXXMethodDecl(decl);
    if ((method != null)) {
      return $this().getCXXABI().EmitMemberFunctionPointer(method);
    }
  }
  
  // Otherwise, a member data pointer.
  long/*uint64_t*/ fieldOffset = $this().getContext().getFieldOffset(decl);
  CharUnits chars = $this().getContext().toCharUnitsFromBits((long/*int64_t*/)fieldOffset);
  return $this().getCXXABI().EmitMemberDataPointer(type, new CharUnits(chars));
}


/// Try to emit the initializer for the given declaration as a constant;
/// returns 0 if the expression cannot be emitted as a constant.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitConstantInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 1196,
 FQN="clang::CodeGen::CodeGenModule::EmitConstantInit", NM="_ZN5clang7CodeGen13CodeGenModule16EmitConstantInitERKNS_7VarDeclEPNS0_15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN5clang7CodeGen13CodeGenModule16EmitConstantInitERKNS_7VarDeclEPNS0_15CodeGenFunctionE")
//</editor-fold>
public final Constant /*P*/ EmitConstantInit(final /*const*/ VarDecl /*&*/ D) {
  return EmitConstantInit(D, 
                (CodeGenFunction /*P*/ )null);
}
public final Constant /*P*/ EmitConstantInit(final /*const*/ VarDecl /*&*/ D, 
                CodeGenFunction /*P*/ CGF/*= null*/) {
  // Make a quick check if variable can be default NULL initialized
  // and avoid going through rest of code which may do, for c++11,
  // initialization of memory to all NULLs.
  if (!D.hasLocalStorage()) {
    QualType Ty = D.getType();
    if (Ty.$arrow().isArrayType()) {
      Ty.$assignMove($this().Context.getBaseElementType(new QualType(Ty)));
    }
    if (Ty.$arrow().isRecordType()) {
      {
        /*const*/ CXXConstructExpr /*P*/ E = dyn_cast_or_null_CXXConstructExpr(D.getInit$Const());
        if ((E != null)) {
          /*const*/ CXXConstructorDecl /*P*/ CD = E.getConstructor();
          if (CD.isTrivial() && CD.isDefaultConstructor()) {
            return $this().EmitNullConstant(D.getType());
          }
        }
      }
    }
  }
  {
    
    /*const*/ APValue /*P*/ Value = D.evaluateValue();
    if ((Value != null)) {
      return $this().EmitConstantValueForMemory($Deref(Value), D.getType(), CGF);
    }
  }
  
  // FIXME: Implement C++11 [basic.start.init]p2: if the initializer of a
  // reference is a constant expression, and the reference binds to a temporary,
  // then constant initialization is performed. ConstExprEmitter will
  // incorrectly emit a prvalue constant in this case, and the calling code
  // interprets that as the (pointer) value of the reference, rather than the
  // desired value of the referee.
  if (D.getType().$arrow().isReferenceType()) {
    return null;
  }
  
  /*const*/ Expr /*P*/ E = D.getInit$Const();
  assert ((E != null)) : "No initializer to emit";
  
  Constant /*P*/ C = new ConstExprEmitter(/*Deref*/$this(), CGF).Visit(((/*const_cast*/Expr /*P*/ )(E)));
  if ((C != null) && C.getType().isIntegerTy(1)) {
    Type /*P*/ BoolTy = $this().getTypes().ConvertTypeForMem(E.getType());
    C = ConstantExpr.getZExt(C, BoolTy);
  }
  return C;
}


/// Try to emit the given expression as a constant; returns 0 if the
/// expression cannot be emitted as a constant.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitConstantExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 1237,
 FQN="clang::CodeGen::CodeGenModule::EmitConstantExpr", NM="_ZN5clang7CodeGen13CodeGenModule16EmitConstantExprEPKNS_4ExprENS_8QualTypeEPNS0_15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN5clang7CodeGen13CodeGenModule16EmitConstantExprEPKNS_4ExprENS_8QualTypeEPNS0_15CodeGenFunctionE")
//</editor-fold>
public final Constant /*P*/ EmitConstantExpr(/*const*/ Expr /*P*/ E, 
                QualType DestType) {
  return EmitConstantExpr(E, 
                DestType, 
                (CodeGenFunction /*P*/ )null);
}
public final Constant /*P*/ EmitConstantExpr(/*const*/ Expr /*P*/ E, 
                QualType DestType, 
                CodeGenFunction /*P*/ CGF/*= null*/) {
  Expr.EvalResult Result = null;
  try {
    Result/*J*/= new Expr.EvalResult();
    
    boolean Success = false;
    if (DestType.$arrow().isReferenceType()) {
      Success = E.EvaluateAsLValue(Result, $this().Context);
    } else {
      Success = E.EvaluateAsRValue(Result, $this().Context);
    }
    
    Constant /*P*/ C = null;
    if (Success && !Result.HasSideEffects) {
      C = $this().EmitConstantValue(Result.Val, new QualType(DestType), CGF);
    } else {
      C = new ConstExprEmitter(/*Deref*/$this(), CGF).Visit(((/*const_cast*/Expr /*P*/ )(E)));
    }
    if ((C != null) && C.getType().isIntegerTy(1)) {
      Type /*P*/ BoolTy = $this().getTypes().ConvertTypeForMem(E.getType());
      C = ConstantExpr.getZExt(C, BoolTy);
    }
    return C;
  } finally {
    if (Result != null) { Result.$destroy(); }
  }
}


/// Emit the given constant value as a constant, in the type's scalar
/// representation.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitConstantValue">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 1262,
 FQN="clang::CodeGen::CodeGenModule::EmitConstantValue", NM="_ZN5clang7CodeGen13CodeGenModule17EmitConstantValueERKNS_7APValueENS_8QualTypeEPNS0_15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN5clang7CodeGen13CodeGenModule17EmitConstantValueERKNS_7APValueENS_8QualTypeEPNS0_15CodeGenFunctionE")
//</editor-fold>
public final Constant /*P*/ EmitConstantValue(final /*const*/ APValue /*&*/ Value, 
                 QualType DestType) {
  return EmitConstantValue(Value, 
                 DestType, 
                 (CodeGenFunction /*P*/ )null);
}
public final Constant /*P*/ EmitConstantValue(final /*const*/ APValue /*&*/ Value, 
                 QualType DestType, 
                 CodeGenFunction /*P*/ CGF/*= null*/) {
  {
    // For an _Atomic-qualified constant, we may need to add tail padding.
    /*const*/ AtomicType /*P*/ AT = DestType.$arrow().getAs(AtomicType.class);
    if ((AT != null)) {
      QualType InnerType = AT.getValueType();
      Constant /*P*/ Inner = $this().EmitConstantValue(Value, new QualType(InnerType), CGF);
      
      long/*uint64_t*/ InnerSize = $this().Context.getTypeSize(new QualType(InnerType));
      long/*uint64_t*/ OuterSize = $this().Context.getTypeSize(new QualType(DestType));
      if (InnerSize == OuterSize) {
        return Inner;
      }
      assert ($less_ulong(InnerSize, OuterSize)) : "emitted over-large constant for atomic";
      Constant /*P*/ Elts[/*2*/] = new Constant /*P*/  [/*2*/] {
        Inner, 
        ConstantAggregateZero.get(ArrayType.get($this().Int8Ty, $div_ullong((OuterSize - InnerSize), $int2ullong(8))))
      };
      return ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(Elts, true));
    }
  }
  switch (Value.getKind()) {
   case Uninitialized:
    throw new llvm_unreachable("Constant expressions should be initialized.");
   case LValue:
    {
      Type /*P*/ DestTy = $this().getTypes().ConvertTypeForMem(new QualType(DestType));
      Constant /*P*/ Offset = ConstantInt.get($this().Int64Ty, Value.getLValueOffset$Const().getQuantity());
      
      Constant /*P*/ C = null;
      {
        PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > LVBase = Value.getLValueBase();
        if (LVBase.$bool()) {
          // An array can be represented as an lvalue referring to the base.
          if (isa_ArrayType(DestTy)) {
            assert (Offset.isNullValue()) : "offset on array initializer";
            return new ConstExprEmitter(/*Deref*/$this(), CGF).Visit(((/*const_cast*/Expr /*P*/ )(LVBase.get(/*const*/ Expr /*P*/.class))));
          }
          
          C = new ConstExprEmitter(/*Deref*/$this(), CGF).EmitLValue(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(LVBase)).getPointer();
          
          // Apply offset if necessary.
          if (!Offset.isNullValue()) {
            /*uint*/int AS = C.getType().getPointerAddressSpace();
            Type /*P*/ CharPtrTy = $this().Int8Ty.getPointerTo(AS);
            Constant /*P*/ Casted = ConstantExpr.getBitCast(C, CharPtrTy);
            Casted = ConstantExpr.getGetElementPtr($this().Int8Ty, Casted, Offset);
            C = ConstantExpr.getPointerCast(Casted, C.getType());
          }
          
          // Convert to the appropriate type; this could be an lvalue for
          // an integer.
          if (isa_PointerType(DestTy)) {
            return ConstantExpr.getPointerCast(C, DestTy);
          }
          
          return ConstantExpr.getPtrToInt(C, DestTy);
        } else {
          C = Offset;
          
          // Convert to the appropriate type; this could be an lvalue for
          // an integer.
          if (isa_PointerType(DestTy)) {
            // Convert the integer to a pointer-sized integer before converting it
            // to a pointer.
            C = ConstantExpr.getIntegerCast(C, $this().getDataLayout().getIntPtrType(DestTy), 
                /*isSigned=*/ false);
            return ConstantExpr.getIntToPtr(C, DestTy);
          }
          
          // If the types don't match this should only be a truncate.
          if (C.getType() != DestTy) {
            return ConstantExpr.getTrunc(C, DestTy);
          }
          
          return C;
        }
      }
    }
   case Int:
    return ConstantInt.get($this().VMContext, Value.getInt$Const());
   case ComplexInt:
    {
      Constant /*P*/ Complex[/*2*/] = new Constant /*P*/  [2];
      
      Complex[0] = ConstantInt.get($this().VMContext, 
          Value.getComplexIntReal$Const());
      Complex[1] = ConstantInt.get($this().VMContext, 
          Value.getComplexIntImag$Const());
      
      // FIXME: the target may want to specify that this is packed.
      StructType /*P*/ STy = StructType.get(Complex[0].getType(), 
          Complex[1].getType(), 
          null);
      return ConstantStruct.get(STy, new ArrayRef<Constant /*P*/ >(Complex, true));
    }
   case Float:
    {
      final /*const*/ APFloat /*&*/ Init = Value.getFloat$Const();
      if ($AddrOf(Init.getSemantics()) == $AddrOf(APFloat.IEEEhalf)
         && !$this().Context.getLangOpts().NativeHalfType
         && !$this().Context.getLangOpts().HalfArgsAndReturns) {
        return ConstantInt.get($this().VMContext, Init.bitcastToAPInt());
      } else {
        return ConstantFP.get($this().VMContext, Init);
      }
    }
   case ComplexFloat:
    {
      Constant /*P*/ Complex[/*2*/] = new Constant /*P*/  [2];
      
      Complex[0] = ConstantFP.get($this().VMContext, 
          Value.getComplexFloatReal$Const());
      Complex[1] = ConstantFP.get($this().VMContext, 
          Value.getComplexFloatImag$Const());
      
      // FIXME: the target may want to specify that this is packed.
      StructType /*P*/ STy = StructType.get(Complex[0].getType(), 
          Complex[1].getType(), 
          null);
      return ConstantStruct.get(STy, new ArrayRef<Constant /*P*/ >(Complex, true));
    }
   case Vector:
    {
      /*uint*/int NumElts = Value.getVectorLength();
      SmallVector<Constant /*P*/ > Inits/*J*/= new SmallVector<Constant /*P*/ >(JD$UInt_T$C$R.INSTANCE, 4, NumElts, (Constant /*P*/ )null);
      
      for (/*uint*/int I = 0; I != NumElts; ++I) {
        final /*const*/ APValue /*&*/ Elt = Value.getVectorElt$Const(I);
        if (Elt.isInt()) {
          Inits.$set(I, ConstantInt.get($this().VMContext, Elt.getInt$Const()));
        } else if (Elt.isFloat()) {
          Inits.$set(I, ConstantFP.get($this().VMContext, Elt.getFloat$Const()));
        } else {
          throw new llvm_unreachable("unsupported vector element type");
        }
      }
      return ConstantVector.get(new ArrayRef<Constant /*P*/ >(Inits, true));
    }
   case AddrLabelDiff:
    {
      /*const*/ AddrLabelExpr /*P*/ LHSExpr = Value.getAddrLabelDiffLHS();
      /*const*/ AddrLabelExpr /*P*/ RHSExpr = Value.getAddrLabelDiffRHS();
      Constant /*P*/ LHS = $this().EmitConstantExpr(LHSExpr, LHSExpr.getType(), CGF);
      Constant /*P*/ RHS = $this().EmitConstantExpr(RHSExpr, RHSExpr.getType(), CGF);
      
      // Compute difference
      Type /*P*/ ResultType = $this().getTypes().ConvertType(new QualType(DestType));
      LHS = ConstantExpr.getPtrToInt(LHS, $this().Unnamed_field8.IntPtrTy);
      RHS = ConstantExpr.getPtrToInt(RHS, $this().Unnamed_field8.IntPtrTy);
      Constant /*P*/ AddrLabelDiff = ConstantExpr.getSub(LHS, RHS);
      
      // LLVM is a bit sensitive about the exact format of the
      // address-of-label difference; make sure to truncate after
      // the subtraction.
      return ConstantExpr.getTruncOrBitCast(AddrLabelDiff, ResultType);
    }
   case Struct:
   case Union:
    return ConstStructBuilder.BuildStruct(/*Deref*/$this(), CGF, Value, new QualType(DestType));
   case Array:
    {
      std.vector<Constant /*P*/ > Elts = null;
      try {
        /*const*/ org.clang.ast.ArrayType /*P*/ CAT = $this().Context.getAsArrayType(new QualType(DestType));
        /*uint*/int NumElements = Value.getArraySize();
        /*uint*/int NumInitElts = Value.getArrayInitializedElts();
        
        // Emit array filler, if there is one.
        Constant /*P*/ Filler = null;
        if (Value.hasArrayFiller()) {
          Filler = $this().EmitConstantValueForMemory(Value.getArrayFiller$Const(), 
              CAT.getElementType(), CGF);
        }
        
        // Emit initializer elements.
        Type /*P*/ CommonElementType = $this().getTypes().ConvertType(CAT.getElementType());
        
        // Try to use a ConstantAggregateZero if we can.
        if ((Filler != null) && Filler.isNullValue() && !(NumInitElts != 0)) {
          ArrayType /*P*/ AType = ArrayType.get(CommonElementType, $uint2ulong(NumElements));
          return ConstantAggregateZero.get(AType);
        }
        
        Elts/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
        Elts.reserve(NumElements);
        for (/*uint*/int I = 0; $less_uint(I, NumElements); ++I) {
          Constant /*P*/ C = Filler;
          if ($less_uint(I, NumInitElts)) {
            C = $this().EmitConstantValueForMemory(Value.getArrayInitializedElt$Const(I), 
                CAT.getElementType(), CGF);
          } else {
            assert ((Filler != null)) : "Missing filler for implicit elements of initializer";
          }
          if (I == 0) {
            CommonElementType = C.getType();
          } else if (C.getType() != CommonElementType) {
            CommonElementType = null;
          }
          Elts.push_back_T$C$R(C);
        }
        if (!(CommonElementType != null)) {
          std.vector<Type /*P*/ > Types = null;
          try {
            // FIXME: Try to avoid packing the array
            Types/*J*/= new std.vector<Type /*P*/ >((Type /*P*/ )null);
            Types.reserve(NumElements);
            for (/*uint*/int i = 0, e = Elts.size(); $less_uint(i, e); ++i)  {
              Types.push_back_T$RR(Elts.$at(i).getType());
            }
            StructType /*P*/ SType = StructType.get($this().VMContext, new ArrayRef<Type /*P*/ >(Types, true), true);
            return ConstantStruct.get(SType, new ArrayRef<Constant /*P*/ >(Elts, true));
          } finally {
            if (Types != null) { Types.$destroy(); }
          }
        }
        
        ArrayType /*P*/ AType = ArrayType.get(CommonElementType, $uint2ulong(NumElements));
        return ConstantArray.get(AType, new ArrayRef<Constant /*P*/ >(Elts, true));
      } finally {
        if (Elts != null) { Elts.$destroy(); }
      }
    }
   case MemberPointer:
    return $this().getCXXABI().EmitMemberPointer(Value, new QualType(DestType));
  }
  throw new llvm_unreachable("Unknown APValue kind");
}


/// Emit the given constant value as a constant, in the type's memory
/// representation.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitConstantValueForMemory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 1471,
 FQN="clang::CodeGen::CodeGenModule::EmitConstantValueForMemory", NM="_ZN5clang7CodeGen13CodeGenModule26EmitConstantValueForMemoryERKNS_7APValueENS_8QualTypeEPNS0_15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN5clang7CodeGen13CodeGenModule26EmitConstantValueForMemoryERKNS_7APValueENS_8QualTypeEPNS0_15CodeGenFunctionE")
//</editor-fold>
public final Constant /*P*/ EmitConstantValueForMemory(final /*const*/ APValue /*&*/ Value, 
                          QualType DestType) {
  return EmitConstantValueForMemory(Value, 
                          DestType, 
                          (CodeGenFunction /*P*/ )null);
}
public final Constant /*P*/ EmitConstantValueForMemory(final /*const*/ APValue /*&*/ Value, 
                          QualType DestType, 
                          CodeGenFunction /*P*/ CGF/*= null*/) {
  Constant /*P*/ C = $this().EmitConstantValue(Value, new QualType(DestType), CGF);
  if (C.getType().isIntegerTy(1)) {
    Type /*P*/ BoolTy = $this().getTypes().ConvertTypeForMem(new QualType(DestType));
    C = ConstantExpr.getZExt(C, BoolTy);
  }
  return C;
}


/// Return the result of value-initializing the given type, i.e. a null
/// expression of the given type.  This is usually, but not always, an LLVM
/// null constant.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitNullConstant">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 1603,
 FQN="clang::CodeGen::CodeGenModule::EmitNullConstant", NM="_ZN5clang7CodeGen13CodeGenModule16EmitNullConstantENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN5clang7CodeGen13CodeGenModule16EmitNullConstantENS_8QualTypeE")
//</editor-fold>
public final Constant /*P*/ EmitNullConstant(QualType T) {
  if ($this().getTypes().isZeroInitializable(new QualType(T))) {
    return Constant.getNullValue($this().getTypes().ConvertTypeForMem(new QualType(T)));
  }
  {
    
    /*const*/ ConstantArrayType /*P*/ CAT = $this().Context.getAsConstantArrayType(new QualType(T));
    if ((CAT != null)) {
      ArrayType /*P*/ ATy = cast_ArrayType($this().getTypes().ConvertTypeForMem(new QualType(T)));
      
      QualType ElementTy = CAT.getElementType();
      
      Constant /*P*/ Element = $this().EmitNullConstant(new QualType(ElementTy));
      /*uint*/int NumElements = $ulong2uint(CAT.getSize().getZExtValue());
      SmallVector<Constant /*P*/ > Array/*J*/= new SmallVector<Constant /*P*/ >(JD$UInt_T$C$R.INSTANCE, 8, NumElements, Element, (Constant /*P*/ )null);
      return ConstantArray.get(ATy, new ArrayRef<Constant /*P*/ >(Array, true));
    }
  }
  {
    
    /*const*/ RecordType /*P*/ RT = T.$arrow().getAs$RecordType();
    if ((RT != null)) {
      /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(RT.getDecl());
      return /*::*/CGExprConstantStatics.EmitNullConstant(/*Deref*/$this(), RD, /*complete object*/ true);
    }
  }
  assert (T.$arrow().isMemberDataPointerType()) : "Should only see pointers to data members here!";
  
  return $this().getCXXABI().EmitNullMemberPointer(T.$arrow().castAs(MemberPointerType.class));
}


/// Return a null constant appropriate for zero-initializing a base class with
/// the given type. This is usually, but not always, an LLVM null constant.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitNullConstantForBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 1630,
 FQN="clang::CodeGen::CodeGenModule::EmitNullConstantForBase", NM="_ZN5clang7CodeGen13CodeGenModule23EmitNullConstantForBaseEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN5clang7CodeGen13CodeGenModule23EmitNullConstantForBaseEPKNS_13CXXRecordDeclE")
//</editor-fold>
public final Constant /*P*/ EmitNullConstantForBase(/*const*/ CXXRecordDecl /*P*/ Record) {
  return /*::*/CGExprConstantStatics.EmitNullConstant(/*Deref*/$this(), Record, false);
}

} // END OF class CodeGenModule_CGExprConstant
