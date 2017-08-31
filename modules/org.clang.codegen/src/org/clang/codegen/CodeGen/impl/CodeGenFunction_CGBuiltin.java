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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.java.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.llvm.ir.java.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.java.ClangCodeGenFunctionPointers.*;
import org.llvm.ir.ArrayType;
import org.llvm.ir.FunctionType;
import org.llvm.ir.PointerType;
import org.llvm.ir.VectorType;
import org.llvm.ir.Type;
import org.llvm.ir.intrinsic.ID;
import org.clang.basic.target.*;
import org.llvm.ir.intrinsic.IntrinsicGlobals;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGBuiltin">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGBuiltin",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGBlocks ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11BuildVectorEN4llvm8ArrayRefIPNS2_5ValueEEE;_ZN5clang7CodeGen15CodeGenFunction12EmitNeonCallEPN4llvm8FunctionERNS2_15SmallVectorImplIPNS2_5ValueEEEPKcjb;_ZN5clang7CodeGen15CodeGenFunction13EmitNeonSplatEPN4llvm5ValueEPNS2_8ConstantE;_ZN5clang7CodeGen15CodeGenFunction14EmitVAStartEndEPN4llvm5ValueEb;_ZN5clang7CodeGen15CodeGenFunction15EmitBuiltinExprEPKNS_12FunctionDeclEjPKNS_8CallExprENS0_15ReturnValueSlotE;_ZN5clang7CodeGen15CodeGenFunction17EmitNeonRShiftImmEPN4llvm5ValueES4_PNS2_4TypeEbPKc;_ZN5clang7CodeGen15CodeGenFunction18EmitARMBuiltinExprEjPKNS_8CallExprE;_ZN5clang7CodeGen15CodeGenFunction18EmitPPCBuiltinExprEjPKNS_8CallExprE;_ZN5clang7CodeGen15CodeGenFunction18EmitX86BuiltinExprEjPKNS_8CallExprE;_ZN5clang7CodeGen15CodeGenFunction18GetValueForARMHintEj;_ZN5clang7CodeGen15CodeGenFunction18vectorWrapScalar16EPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction19EmitNeonShiftVectorEPN4llvm5ValueEPNS2_4TypeEb;_ZN5clang7CodeGen15CodeGenFunction20EmitNVPTXBuiltinExprEjPKNS_8CallExprE;_ZN5clang7CodeGen15CodeGenFunction21EmitAMDGPUBuiltinExprEjPKNS_8CallExprE;_ZN5clang7CodeGen15CodeGenFunction21EmitTargetBuiltinExprEjPKNS_8CallExprE;_ZN5clang7CodeGen15CodeGenFunction21emitBuiltinObjectSizeEPKNS_4ExprEjPN4llvm11IntegerTypeE;_ZN5clang7CodeGen15CodeGenFunction22EmitAArch64BuiltinExprEjPKNS_8CallExprE;_ZN5clang7CodeGen15CodeGenFunction22EmitSystemZBuiltinExprEjPKNS_8CallExprE;_ZN5clang7CodeGen15CodeGenFunction23LookupNeonLLVMIntrinsicEjjPN4llvm4TypeEPKNS_8CallExprE;_ZN5clang7CodeGen15CodeGenFunction25EmitCommonNeonBuiltinExprEjjjPKcjPKNS_8CallExprERN4llvm15SmallVectorImplIPNS7_5ValueEEENS0_7AddressESD_;_ZN5clang7CodeGen15CodeGenFunction26EmitWebAssemblyBuiltinExprEjPKNS_8CallExprE;_ZN5clang7CodeGen15CodeGenFunction29EmitAArch64CompareBuiltinExprEPN4llvm5ValueEPNS2_4TypeENS2_7CmpInst9PredicateES8_RKNS2_5TwineE;_ZN5clang7CodeGen15CodeGenFunction31evaluateOrEmitBuiltinObjectSizeEPKNS_4ExprEjPN4llvm11IntegerTypeE; -static-type=CodeGenFunction_CGBuiltin -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGBuiltin extends CodeGenFunction_CGBlocks {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGBuiltin(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}


/// Emits a call to an LLVM variable-argument intrinsic, either
/// \c llvm.va_start or \c llvm.va_end.
/// \param ArgValue A reference to the \c va_list as emitted by either
/// \c EmitVAListRef or \c EmitMSVAListRef.
/// \param IsStart If \c true, emits a call to \c llvm.va_start; otherwise,
/// calls \c llvm.va_end.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitVAStartEnd">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 390,
 FQN="clang::CodeGen::CodeGenFunction::EmitVAStartEnd", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitVAStartEndEPN4llvm5ValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitVAStartEndEPN4llvm5ValueEb")
//</editor-fold>
public final Value /*P*/ EmitVAStartEnd(Value /*P*/ ArgValue, boolean IsStart) {
  org.llvm.ir.Type /*P*/ DestType = Unnamed_field9.Int8PtrTy;
  if (ArgValue.getType() != DestType) {
    ArgValue
       = $this().Builder.CreateBitCast(ArgValue, DestType, new Twine(ArgValue.getName().data()));
  }
  
  /*Intrinsic.ID*/int inst = IsStart ? ID.vastart : ID.vaend;
  return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(inst), new ArrayRef<Value /*P*/ >(ArgValue, true));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitBuiltinExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 465,
 FQN="clang::CodeGen::CodeGenFunction::EmitBuiltinExpr", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitBuiltinExprEPKNS_12FunctionDeclEjPKNS_8CallExprENS0_15ReturnValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitBuiltinExprEPKNS_12FunctionDeclEjPKNS_8CallExprENS0_15ReturnValueSlotE")
//</editor-fold>
public final RValue EmitBuiltinExpr(/*const*/ FunctionDecl /*P*/ FD, 
               /*uint*/int BuiltinID, /*const*/ CallExpr /*P*/ E, 
               ReturnValueSlot ReturnValue) {
  Expr.EvalResult Result = null;
  try {
    // See if we can constant fold this builtin.  If so, don't emit it at all.
    Result/*J*/= new Expr.EvalResult();
    if (E.EvaluateAsRValue(Result, $this().CGM.getContext())
       && !Result.hasSideEffects()) {
      if (Result.Val.isInt()) {
        return RValue.get(ConstantInt.get($this().getLLVMContext(), 
                Result.Val.getInt()));
      }
      if (Result.Val.isFloat()) {
        return RValue.get(ConstantFP.get($this().getLLVMContext(), 
                Result.Val.getFloat()));
      }
    }
    switch (Builtin.ID.valueOf(BuiltinID)) {
     default:
      break; // Handle intrinsics and libm functions below.
     case BI__builtin___CFStringMakeConstantString:
     case BI__builtin___NSStringMakeConstantString:
      return RValue.get($this().CGM.EmitConstantExpr(E, E.getType(), (CodeGenFunction /*P*/ )null));
     case BI__builtin_stdarg_start:
     case BI__builtin_va_start:
     case BI__va_start:
     case BI__builtin_va_end:
      return RValue.get($this().EmitVAStartEnd(BuiltinID == Builtin.ID.BI__va_start.getValue() ? $this().EmitScalarExpr(E.getArg$Const(0)) : $this().EmitVAListRef(E.getArg$Const(0)).getPointer(), 
              BuiltinID != Builtin.ID.BI__builtin_va_end.getValue()));
     case BI__builtin_va_copy:
      {
        Value /*P*/ DstPtr = $this().EmitVAListRef(E.getArg$Const(0)).getPointer();
        Value /*P*/ SrcPtr = $this().EmitVAListRef(E.getArg$Const(1)).getPointer();
        
        org.llvm.ir.Type /*P*/ $Type = Unnamed_field9.Int8PtrTy;
        
        DstPtr = $this().Builder.CreateBitCast(DstPtr, $Type);
        SrcPtr = $this().Builder.CreateBitCast(SrcPtr, $Type);
        return RValue.get($this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.vacopy), 
                /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {DstPtr, SrcPtr}, true)/* }*/));
      }
     case BI__builtin_abs:
     case BI__builtin_labs:
     case BI__builtin_llabs:
      {
        Value /*P*/ ArgValue = $this().EmitScalarExpr(E.getArg$Const(0));
        
        Value /*P*/ NegOp = $this().Builder.CreateNeg(ArgValue, new Twine(/*KEEP_STR*/"neg"));
        Value /*P*/ CmpResult = $this().Builder.CreateICmpSGE(ArgValue, 
            Constant.getNullValue(ArgValue.getType()), 
            new Twine(/*KEEP_STR*/"abscond"));
        Value /*P*/ Result$1 = $this().Builder.CreateSelect(CmpResult, ArgValue, NegOp, new Twine(/*KEEP_STR*/"abs"));
        
        return RValue.get(Result$1);
      }
     case BI__builtin_fabs:
     case BI__builtin_fabsf:
     case BI__builtin_fabsl:
      {
        return RValue.get(CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.fabs));
      }
     case BI__builtin_fmod:
     case BI__builtin_fmodf:
     case BI__builtin_fmodl:
      {
        Value /*P*/ Arg1 = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ Arg2 = $this().EmitScalarExpr(E.getArg$Const(1));
        Value /*P*/ Result$1 = $this().Builder.CreateFRem(Arg1, Arg2, new Twine(/*KEEP_STR*/"fmod"));
        return RValue.get(Result$1);
      }
     case BI__builtin_copysign:
     case BI__builtin_copysignf:
     case BI__builtin_copysignl:
      {
        return RValue.get(CGBuiltinStatics.emitBinaryBuiltin(/*Deref*/$this(), E, ID.copysign));
      }
     case BI__builtin_ceil:
     case BI__builtin_ceilf:
     case BI__builtin_ceill:
      {
        return RValue.get(CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.ceil));
      }
     case BI__builtin_floor:
     case BI__builtin_floorf:
     case BI__builtin_floorl:
      {
        return RValue.get(CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.floor));
      }
     case BI__builtin_trunc:
     case BI__builtin_truncf:
     case BI__builtin_truncl:
      {
        return RValue.get(CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.trunc));
      }
     case BI__builtin_rint:
     case BI__builtin_rintf:
     case BI__builtin_rintl:
      {
        return RValue.get(CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.rint));
      }
     case BI__builtin_nearbyint:
     case BI__builtin_nearbyintf:
     case BI__builtin_nearbyintl:
      {
        return RValue.get(CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.nearbyint));
      }
     case BI__builtin_round:
     case BI__builtin_roundf:
     case BI__builtin_roundl:
      {
        return RValue.get(CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.round));
      }
     case BI__builtin_fmin:
     case BI__builtin_fminf:
     case BI__builtin_fminl:
      {
        return RValue.get(CGBuiltinStatics.emitBinaryBuiltin(/*Deref*/$this(), E, ID.minnum));
      }
     case BI__builtin_fmax:
     case BI__builtin_fmaxf:
     case BI__builtin_fmaxl:
      {
        return RValue.get(CGBuiltinStatics.emitBinaryBuiltin(/*Deref*/$this(), E, ID.maxnum));
      }
     case BI__builtin_conj:
     case BI__builtin_conjf:
     case BI__builtin_conjl:
      {
        std.pair<Value /*P*/ , Value /*P*/ > ComplexVal = $this().EmitComplexExpr(E.getArg$Const(0));
        Value /*P*/ Real = ComplexVal.first;
        Value /*P*/ Imag = ComplexVal.second;
        Value /*P*/ Zero = Imag.getType().isFPOrFPVectorTy() ? ConstantFP.getZeroValueForNegation(Imag.getType()) : Constant.getNullValue(Imag.getType());
        
        Imag = $this().Builder.CreateFSub(Zero, Imag, new Twine(/*KEEP_STR*/"sub"));
        return RValue.getComplex(std.make_pair_Ptr_Ptr(Real, Imag));
      }
     case BI__builtin_creal:
     case BI__builtin_crealf:
     case BI__builtin_creall:
     case BIcreal:
     case BIcrealf:
     case BIcreall:
      {
        std.pair<Value /*P*/ , Value /*P*/ > ComplexVal = $this().EmitComplexExpr(E.getArg$Const(0));
        return RValue.get(ComplexVal.first);
      }
     case BI__builtin_cimag:
     case BI__builtin_cimagf:
     case BI__builtin_cimagl:
     case BIcimag:
     case BIcimagf:
     case BIcimagl:
      {
        std.pair<Value /*P*/ , Value /*P*/ > ComplexVal = $this().EmitComplexExpr(E.getArg$Const(0));
        return RValue.get(ComplexVal.second);
      }
     case BI__builtin_ctzs:
     case BI__builtin_ctz:
     case BI__builtin_ctzl:
     case BI__builtin_ctzll:
      {
        Value /*P*/ ArgValue = $this().EmitScalarExpr(E.getArg$Const(0));
        
        org.llvm.ir.Type /*P*/ ArgType = ArgValue.getType();
        Value /*P*/ F = $this().CGM.getIntrinsic(ID.cttz, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgType, true));
        
        org.llvm.ir.Type /*P*/ ResultType = $this().ConvertType(E.getType());
        Value /*P*/ ZeroUndef = $this().Builder.getInt1($this().getTarget().isCLZForZeroUndef());
        Value /*P*/ Result$1 = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {ArgValue, ZeroUndef}, true)/* }*/);
        if (Result$1.getType() != ResultType) {
          Result$1 = $this().Builder.CreateIntCast(Result$1, ResultType, /*isSigned*/ true, 
              new Twine(/*KEEP_STR*/"cast"));
        }
        return RValue.get(Result$1);
      }
     case BI__builtin_clzs:
     case BI__builtin_clz:
     case BI__builtin_clzl:
     case BI__builtin_clzll:
      {
        Value /*P*/ ArgValue = $this().EmitScalarExpr(E.getArg$Const(0));
        
        org.llvm.ir.Type /*P*/ ArgType = ArgValue.getType();
        Value /*P*/ F = $this().CGM.getIntrinsic(ID.ctlz, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgType, true));
        
        org.llvm.ir.Type /*P*/ ResultType = $this().ConvertType(E.getType());
        Value /*P*/ ZeroUndef = $this().Builder.getInt1($this().getTarget().isCLZForZeroUndef());
        Value /*P*/ Result$1 = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {ArgValue, ZeroUndef}, true)/* }*/);
        if (Result$1.getType() != ResultType) {
          Result$1 = $this().Builder.CreateIntCast(Result$1, ResultType, /*isSigned*/ true, 
              new Twine(/*KEEP_STR*/"cast"));
        }
        return RValue.get(Result$1);
      }
     case BI__builtin_ffs:
     case BI__builtin_ffsl:
     case BI__builtin_ffsll:
      {
        // ffs(x) -> x ? cttz(x) + 1 : 0
        Value /*P*/ ArgValue = $this().EmitScalarExpr(E.getArg$Const(0));
        
        org.llvm.ir.Type /*P*/ ArgType = ArgValue.getType();
        Value /*P*/ F = $this().CGM.getIntrinsic(ID.cttz, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgType, true));
        
        org.llvm.ir.Type /*P*/ ResultType = $this().ConvertType(E.getType());
        Value /*P*/ Tmp = $this().Builder.CreateAdd($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {ArgValue, $this().Builder.getTrue()}, true)/* }*/), 
            ConstantInt.get(ArgType, $int2ulong(1)));
        Value /*P*/ Zero = Constant.getNullValue(ArgType);
        Value /*P*/ IsZero = $this().Builder.CreateICmpEQ(ArgValue, Zero, new Twine(/*KEEP_STR*/"iszero"));
        Value /*P*/ Result$1 = $this().Builder.CreateSelect(IsZero, Zero, Tmp, new Twine(/*KEEP_STR*/"ffs"));
        if (Result$1.getType() != ResultType) {
          Result$1 = $this().Builder.CreateIntCast(Result$1, ResultType, /*isSigned*/ true, 
              new Twine(/*KEEP_STR*/"cast"));
        }
        return RValue.get(Result$1);
      }
     case BI__builtin_parity:
     case BI__builtin_parityl:
     case BI__builtin_parityll:
      {
        // parity(x) -> ctpop(x) & 1
        Value /*P*/ ArgValue = $this().EmitScalarExpr(E.getArg$Const(0));
        
        org.llvm.ir.Type /*P*/ ArgType = ArgValue.getType();
        Value /*P*/ F = $this().CGM.getIntrinsic(ID.ctpop, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgType, true));
        
        org.llvm.ir.Type /*P*/ ResultType = $this().ConvertType(E.getType());
        Value /*P*/ Tmp = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(ArgValue, true));
        Value /*P*/ Result$1 = $this().Builder.CreateAnd(Tmp, ConstantInt.get(ArgType, $int2ulong(1)));
        if (Result$1.getType() != ResultType) {
          Result$1 = $this().Builder.CreateIntCast(Result$1, ResultType, /*isSigned*/ true, 
              new Twine(/*KEEP_STR*/"cast"));
        }
        return RValue.get(Result$1);
      }
     case BI__builtin_popcount:
     case BI__builtin_popcountl:
     case BI__builtin_popcountll:
      {
        Value /*P*/ ArgValue = $this().EmitScalarExpr(E.getArg$Const(0));
        
       org.llvm.ir. Type /*P*/ ArgType = ArgValue.getType();
        Value /*P*/ F = $this().CGM.getIntrinsic(ID.ctpop, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgType, true));
        
        org.llvm.ir.Type /*P*/ ResultType = $this().ConvertType(E.getType());
        Value /*P*/ Result$1 = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(ArgValue, true));
        if (Result$1.getType() != ResultType) {
          Result$1 = $this().Builder.CreateIntCast(Result$1, ResultType, /*isSigned*/ true, 
              new Twine(/*KEEP_STR*/"cast"));
        }
        return RValue.get(Result$1);
      }
     case BI__builtin_unpredictable:
      {
        // Always return the argument of __builtin_unpredictable. LLVM does not
        // handle this builtin. Metadata for this builtin should be added directly
        // to instructions such as branches or switches that use it.
        return RValue.get($this().EmitScalarExpr(E.getArg$Const(0)));
      }
     case BI__builtin_expect:
      {
        Value /*P*/ ArgValue = $this().EmitScalarExpr(E.getArg$Const(0));
        org.llvm.ir.Type /*P*/ ArgType = ArgValue.getType();
        
        Value /*P*/ ExpectedValue = $this().EmitScalarExpr(E.getArg$Const(1));
        // Don't generate llvm.expect on -O0 as the backend won't use it for
        // anything.
        // Note, we still IRGen ExpectedValue because it could have side-effects.
        if ($2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) == 0) {
          return RValue.get(ArgValue);
        }
        
        Value /*P*/ FnExpect = $this().CGM.getIntrinsic(ID.expect, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgType, true));
        Value /*P*/ Result$1 = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(FnExpect, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {ArgValue, ExpectedValue}, true)/* }*/, new Twine(/*KEEP_STR*/"expval"));
        return RValue.get(Result$1);
      }
     case BI__builtin_assume_aligned:
      {
        Value /*P*/ PtrValue = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ OffsetValue = ($greater_uint(E.getNumArgs(), 2)) ? $this().EmitScalarExpr(E.getArg$Const(2)) : null;
        
        Value /*P*/ AlignmentValue = $this().EmitScalarExpr(E.getArg$Const(1));
        ConstantInt /*P*/ AlignmentCI = IrRTTI.cast_ConstantInt(AlignmentValue);
        /*uint*/int Alignment = (/*uint*/int)$ulong2uint(AlignmentCI.getZExtValue());
        
        $this().EmitAlignmentAssumption(PtrValue, Alignment, OffsetValue);
        return RValue.get(PtrValue);
      }
     case BI__assume:
     case BI__builtin_assume:
      {
        if (E.getArg$Const(0).HasSideEffects($this().getContext())) {
          return RValue.get((Value /*P*/ )null);
        }
        
        Value /*P*/ ArgValue = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ FnAssume = $this().CGM.getIntrinsic(ID.assume);
        return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(FnAssume, new ArrayRef<Value /*P*/ >(ArgValue, true)));
      }
     case BI__builtin_bswap16:
     case BI__builtin_bswap32:
     case BI__builtin_bswap64:
      {
        return RValue.get(CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.bswap));
      }
     case BI__builtin_bitreverse8:
     case BI__builtin_bitreverse16:
     case BI__builtin_bitreverse32:
     case BI__builtin_bitreverse64:
      {
        return RValue.get(CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.bitreverse));
      }
     case BI__builtin_object_size:
      {
        /*uint*/int Type = $ulong2uint(E.getArg$Const(1).EvaluateKnownConstInt($this().getContext()).getZExtValue());
        IntegerType /*P*/ ResType = IrRTTI.cast_IntegerType($this().ConvertType(E.getType()));
        
        // We pass this builtin onto the optimizer so that it can figure out the
        // object size in more complex cases.
        return RValue.get($this().emitBuiltinObjectSize(E.getArg$Const(0), Type, ResType));
      }
     case BI__builtin_prefetch:
      {
        Value /*P*/ Locality;
        Value /*P*/ RW;
        Value /*P*/ Address = $this().EmitScalarExpr(E.getArg$Const(0));
        // FIXME: Technically these constants should of type 'int', yes?
        RW = ($greater_uint(E.getNumArgs(), 1)) ? $this().EmitScalarExpr(E.getArg$Const(1)) : ConstantInt.get(Int32Ty, $int2ulong(0));
        Locality = ($greater_uint(E.getNumArgs(), 2)) ? $this().EmitScalarExpr(E.getArg$Const(2)) : ConstantInt.get(Int32Ty, $int2ulong(3));
        Value /*P*/ Data = ConstantInt.get(Int32Ty, $int2ulong(1));
        Value /*P*/ F = $this().CGM.getIntrinsic(ID.prefetch);
        return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*4*/] {Address, RW, Locality, Data}, true)/* }*/));
      }
     case BI__builtin_readcyclecounter:
      {
        Value /*P*/ F = $this().CGM.getIntrinsic(ID.readcyclecounter);
        return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F));
      }
     case BI__builtin___clear_cache:
      {
        Value /*P*/ Begin = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ End = $this().EmitScalarExpr(E.getArg$Const(1));
        Value /*P*/ F = $this().CGM.getIntrinsic(ID.clear_cache);
        return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Begin, End}, true)/* }*/));
      }
     case BI__builtin_trap:
      return RValue.get($this().EmitTrapCall(ID.trap));
     case BI__debugbreak:
      return RValue.get($this().EmitTrapCall(ID.debugtrap));
     case BI__builtin_unreachable:
      {
        if ($this().SanOpts.has(SanitizerKind.Unreachable)) {
          SanitizerScope SanScope = null;
          try {
            SanScope/*J*/= new SanitizerScope($this());
            $this().EmitCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(
                    std.make_pair_Ptr_ulong(((/*static_cast*/Value /*P*/ )($this().Builder.getFalse())), 
                        SanitizerKind.Unreachable), false), 
                new StringRef(/*KEEP_STR*/"builtin_unreachable"), new ArrayRef<Constant /*P*/ >($this().EmitCheckSourceLocation(E.getExprLoc()), true), 
                new ArrayRef<Value /*P*/ >(None, true));
          } finally {
            if (SanScope != null) { SanScope.$destroy(); }
          }
        } else {
          $this().Builder.CreateUnreachable();
        }
        
        // We do need to preserve an insertion point.
        $this().EmitBlock($this().createBasicBlock(new Twine(/*KEEP_STR*/"unreachable.cont")));
        
        return RValue.get((Value /*P*/ )null);
      }
     case BI__builtin_powi:
     case BI__builtin_powif:
     case BI__builtin_powil:
      {
        Value /*P*/ Base = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ Exponent = $this().EmitScalarExpr(E.getArg$Const(1));
        org.llvm.ir.Type /*P*/ ArgType = Base.getType();
        Value /*P*/ F = $this().CGM.getIntrinsic(ID.powi, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgType, true));
        return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Base, Exponent}, true)/* }*/));
      }
     case BI__builtin_isgreater:
     case BI__builtin_isgreaterequal:
     case BI__builtin_isless:
     case BI__builtin_islessequal:
     case BI__builtin_islessgreater:
     case BI__builtin_isunordered:
      {
        // Ordered comparisons: we know the arguments to these are matching scalar
        // floating point values.
        Value /*P*/ LHS = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ RHS = $this().EmitScalarExpr(E.getArg$Const(1));
        switch (Builtin.ID.valueOf(BuiltinID)) {
         default:
          throw new llvm_unreachable("Unknown ordered comparison");
         case BI__builtin_isgreater:
          LHS = $this().Builder.CreateFCmpOGT(LHS, RHS, new Twine(/*KEEP_STR*/"cmp"));
          break;
         case BI__builtin_isgreaterequal:
          LHS = $this().Builder.CreateFCmpOGE(LHS, RHS, new Twine(/*KEEP_STR*/"cmp"));
          break;
         case BI__builtin_isless:
          LHS = $this().Builder.CreateFCmpOLT(LHS, RHS, new Twine(/*KEEP_STR*/"cmp"));
          break;
         case BI__builtin_islessequal:
          LHS = $this().Builder.CreateFCmpOLE(LHS, RHS, new Twine(/*KEEP_STR*/"cmp"));
          break;
         case BI__builtin_islessgreater:
          LHS = $this().Builder.CreateFCmpONE(LHS, RHS, new Twine(/*KEEP_STR*/"cmp"));
          break;
         case BI__builtin_isunordered:
          LHS = $this().Builder.CreateFCmpUNO(LHS, RHS, new Twine(/*KEEP_STR*/"cmp"));
          break;
        }
        // ZExt bool to int type.
        return RValue.get($this().Builder.CreateZExt(LHS, $this().ConvertType(E.getType())));
      }
     case BI__builtin_isnan:
      {
        Value /*P*/ V = $this().EmitScalarExpr(E.getArg$Const(0));
        V = $this().Builder.CreateFCmpUNO(V, V, new Twine(/*KEEP_STR*/"cmp"));
        return RValue.get($this().Builder.CreateZExt(V, $this().ConvertType(E.getType())));
      }
     case BI__builtin_isinf:
     case BI__builtin_isfinite:
      {
        // isinf(x)    --> fabs(x) == infinity
        // isfinite(x) --> fabs(x) != infinity
        // x != NaN via the ordered compare in either case.
        Value /*P*/ V = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ Fabs = CGBuiltinStatics.EmitFAbs(/*Deref*/$this(), V);
        Constant /*P*/ Infinity = ConstantFP.getInfinity(V.getType());
        CmpInst.Predicate Pred = (BuiltinID == Builtin.ID.BI__builtin_isinf.getValue()) ? CmpInst.Predicate.FCMP_OEQ : CmpInst.Predicate.FCMP_ONE;
        Value /*P*/ FCmp = $this().Builder.CreateFCmp(Pred, Fabs, Infinity, new Twine(/*KEEP_STR*/"cmpinf"));
        return RValue.get($this().Builder.CreateZExt(FCmp, $this().ConvertType(E.getType())));
      }
     case BI__builtin_isinf_sign:
      {
        // isinf_sign(x) -> fabs(x) == infinity ? (signbit(x) ? -1 : 1) : 0
        Value /*P*/ Arg = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ AbsArg = CGBuiltinStatics.EmitFAbs(/*Deref*/$this(), Arg);
        Value /*P*/ IsInf = $this().Builder.CreateFCmpOEQ(AbsArg, ConstantFP.getInfinity(Arg.getType()), new Twine(/*KEEP_STR*/"isinf"));
        Value /*P*/ IsNeg = CGBuiltinStatics.EmitSignBit(/*Deref*/$this(), Arg);
        
        org.llvm.ir.Type /*P*/ IntTy = $this().ConvertType(E.getType());
        Value /*P*/ Zero = Constant.getNullValue(IntTy);
        Value /*P*/ One = ConstantInt.get(IntTy, $int2ulong(1));
        Value /*P*/ NegativeOne = ConstantInt.get(IntTy, $int2ulong(-1));
        Value /*P*/ SignResult = $this().Builder.CreateSelect(IsNeg, NegativeOne, One);
        Value /*P*/ Result$1 = $this().Builder.CreateSelect(IsInf, SignResult, Zero);
        return RValue.get(Result$1);
      }
     case BI__builtin_isnormal:
      {
        // isnormal(x) --> x == x && fabsf(x) < infinity && fabsf(x) >= float_min
        Value /*P*/ V = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ Eq = $this().Builder.CreateFCmpOEQ(V, V, new Twine(/*KEEP_STR*/"iseq"));
        
        Value /*P*/ Abs = CGBuiltinStatics.EmitFAbs(/*Deref*/$this(), V);
        Value /*P*/ IsLessThanInf = $this().Builder.CreateFCmpULT(Abs, ConstantFP.getInfinity(V.getType()), new Twine(/*KEEP_STR*/"isinf"));
        APFloat Smallest = APFloat.getSmallestNormalized($this().getContext().getFloatTypeSemantics(E.getArg$Const(0).getType()));
        Value /*P*/ IsNormal = $this().Builder.CreateFCmpUGE(Abs, ConstantFP.get(V.getContext(), Smallest), 
            new Twine(/*KEEP_STR*/"isnormal"));
        V = $this().Builder.CreateAnd(Eq, IsLessThanInf, new Twine(/*KEEP_STR*/"and"));
        V = $this().Builder.CreateAnd(V, IsNormal, new Twine(/*KEEP_STR*/"and"));
        return RValue.get($this().Builder.CreateZExt(V, $this().ConvertType(E.getType())));
      }
     case BI__builtin_fpclassify:
      {
        Value /*P*/ V = $this().EmitScalarExpr(E.getArg$Const(5));
        org.llvm.ir.Type /*P*/ Ty = $this().ConvertType(E.getArg$Const(5).getType());
        
        // Create Result
        BasicBlock /*P*/ Begin = $this().Builder.GetInsertBlock();
        BasicBlock /*P*/ End = $this().createBasicBlock(new Twine(/*KEEP_STR*/"fpclassify_end"), $this().CurFn);
        $this().Builder.SetInsertPoint(End);
        PHINode /*P*/ Result$1 = $this().Builder.CreatePHI($this().ConvertType(E.getArg$Const(0).getType()), 4, 
            new Twine(/*KEEP_STR*/"fpclassify_result"));
        
        // if (V==0) return FP_ZERO
        $this().Builder.SetInsertPoint(Begin);
        Value /*P*/ IsZero = $this().Builder.CreateFCmpOEQ(V, Constant.getNullValue(Ty), 
            new Twine(/*KEEP_STR*/"iszero"));
        Value /*P*/ ZeroLiteral = $this().EmitScalarExpr(E.getArg$Const(4));
        BasicBlock /*P*/ NotZero = $this().createBasicBlock(new Twine(/*KEEP_STR*/"fpclassify_not_zero"), $this().CurFn);
        $this().Builder.CreateCondBr(IsZero, End, NotZero);
        Result$1.addIncoming(ZeroLiteral, Begin);
        
        // if (V != V) return FP_NAN
        $this().Builder.SetInsertPoint(NotZero);
        Value /*P*/ IsNan = $this().Builder.CreateFCmpUNO(V, V, new Twine(/*KEEP_STR*/"cmp"));
        Value /*P*/ NanLiteral = $this().EmitScalarExpr(E.getArg$Const(0));
        BasicBlock /*P*/ NotNan = $this().createBasicBlock(new Twine(/*KEEP_STR*/"fpclassify_not_nan"), $this().CurFn);
        $this().Builder.CreateCondBr(IsNan, End, NotNan);
        Result$1.addIncoming(NanLiteral, NotZero);
        
        // if (fabs(V) == infinity) return FP_INFINITY
        $this().Builder.SetInsertPoint(NotNan);
        Value /*P*/ VAbs = CGBuiltinStatics.EmitFAbs(/*Deref*/$this(), V);
        Value /*P*/ IsInf = $this().Builder.CreateFCmpOEQ(VAbs, ConstantFP.getInfinity(V.getType()), 
            new Twine(/*KEEP_STR*/"isinf"));
        Value /*P*/ InfLiteral = $this().EmitScalarExpr(E.getArg$Const(1));
        BasicBlock /*P*/ NotInf = $this().createBasicBlock(new Twine(/*KEEP_STR*/"fpclassify_not_inf"), $this().CurFn);
        $this().Builder.CreateCondBr(IsInf, End, NotInf);
        Result$1.addIncoming(InfLiteral, NotNan);
        
        // if (fabs(V) >= MIN_NORMAL) return FP_NORMAL else FP_SUBNORMAL
        $this().Builder.SetInsertPoint(NotInf);
        APFloat Smallest = APFloat.getSmallestNormalized($this().getContext().getFloatTypeSemantics(E.getArg$Const(5).getType()));
        Value /*P*/ IsNormal = $this().Builder.CreateFCmpUGE(VAbs, ConstantFP.get(V.getContext(), Smallest), 
            new Twine(/*KEEP_STR*/"isnormal"));
        Value /*P*/ NormalResult = $this().Builder.CreateSelect(IsNormal, $this().EmitScalarExpr(E.getArg$Const(2)), 
            $this().EmitScalarExpr(E.getArg$Const(3)));
        $this().Builder.CreateBr(End);
        Result$1.addIncoming(NormalResult, NotInf);
        
        // return Result
        $this().Builder.SetInsertPoint(End);
        return RValue.get(Result$1);
      }
     case BIalloca:
     case BI_alloca:
     case BI__builtin_alloca:
      {
        Value /*P*/ Size = $this().EmitScalarExpr(E.getArg$Const(0));
        return RValue.get($this().Builder.CreateAlloca($this().Builder.getInt8Ty(), Size));
      }
     case BIbzero:
     case BI__builtin_bzero:
      {
        Address Dest = $this().EmitPointerWithAlignment(E.getArg$Const(0));
        Value /*P*/ SizeVal = $this().EmitScalarExpr(E.getArg$Const(1));
        $this().EmitNonNullArgCheck(RValue.get(Dest.getPointer()), E.getArg$Const(0).getType(), 
            E.getArg$Const(0).getExprLoc(), FD, 0);
        $this().Builder.CreateMemSet(new Address(Dest), $this().Builder.getInt8($int2uchar(0)), SizeVal, false);
        return RValue.get(Dest.getPointer());
      }
     case BImemcpy:
     case BI__builtin_memcpy:
      {
        Address Dest = $this().EmitPointerWithAlignment(E.getArg$Const(0));
        Address Src = $this().EmitPointerWithAlignment(E.getArg$Const(1));
        Value /*P*/ SizeVal = $this().EmitScalarExpr(E.getArg$Const(2));
        $this().EmitNonNullArgCheck(RValue.get(Dest.getPointer()), E.getArg$Const(0).getType(), 
            E.getArg$Const(0).getExprLoc(), FD, 0);
        $this().EmitNonNullArgCheck(RValue.get(Src.getPointer()), E.getArg$Const(1).getType(), 
            E.getArg$Const(1).getExprLoc(), FD, 1);
        $this().Builder.CreateMemCpy(new Address(Dest), new Address(Src), SizeVal, false);
        return RValue.get(Dest.getPointer());
      }
     case BI__builtin___memcpy_chk:
      {
        // fold __builtin_memcpy_chk(x, y, cst1, cst2) to memcpy iff cst1<=cst2.
        APSInt Size/*J*/= new APSInt();
        APSInt DstSize/*J*/= new APSInt();
        if (!E.getArg$Const(2).EvaluateAsInt(Size, $this().CGM.getContext())
           || !E.getArg$Const(3).EvaluateAsInt(DstSize, $this().CGM.getContext())) {
          break;
        }
        if (Size.ugt(DstSize)) {
          break;
        }
        Address Dest = $this().EmitPointerWithAlignment(E.getArg$Const(0));
        Address Src = $this().EmitPointerWithAlignment(E.getArg$Const(1));
        Value /*P*/ SizeVal = ConstantInt.get($this().Builder.getContext(), Size);
        $this().Builder.CreateMemCpy(new Address(Dest), new Address(Src), SizeVal, false);
        return RValue.get(Dest.getPointer());
      }
     case BI__builtin_objc_memmove_collectable:
      {
        Address DestAddr = $this().EmitPointerWithAlignment(E.getArg$Const(0));
        Address SrcAddr = $this().EmitPointerWithAlignment(E.getArg$Const(1));
        Value /*P*/ SizeVal = $this().EmitScalarExpr(E.getArg$Const(2));
        $this().CGM.getObjCRuntime().EmitGCMemmoveCollectable(/*Deref*/$this(), 
            new Address(DestAddr), new Address(SrcAddr), SizeVal);
        return RValue.get(DestAddr.getPointer());
      }
     case BI__builtin___memmove_chk:
      {
        // fold __builtin_memmove_chk(x, y, cst1, cst2) to memmove iff cst1<=cst2.
        APSInt Size/*J*/= new APSInt();
        APSInt DstSize/*J*/= new APSInt();
        if (!E.getArg$Const(2).EvaluateAsInt(Size, $this().CGM.getContext())
           || !E.getArg$Const(3).EvaluateAsInt(DstSize, $this().CGM.getContext())) {
          break;
        }
        if (Size.ugt(DstSize)) {
          break;
        }
        Address Dest = $this().EmitPointerWithAlignment(E.getArg$Const(0));
        Address Src = $this().EmitPointerWithAlignment(E.getArg$Const(1));
        Value /*P*/ SizeVal = ConstantInt.get($this().Builder.getContext(), Size);
        $this().Builder.CreateMemMove(new Address(Dest), new Address(Src), SizeVal, false);
        return RValue.get(Dest.getPointer());
      }
     case BImemmove:
     case BI__builtin_memmove:
      {
        Address Dest = $this().EmitPointerWithAlignment(E.getArg$Const(0));
        Address Src = $this().EmitPointerWithAlignment(E.getArg$Const(1));
        Value /*P*/ SizeVal = $this().EmitScalarExpr(E.getArg$Const(2));
        $this().EmitNonNullArgCheck(RValue.get(Dest.getPointer()), E.getArg$Const(0).getType(), 
            E.getArg$Const(0).getExprLoc(), FD, 0);
        $this().EmitNonNullArgCheck(RValue.get(Src.getPointer()), E.getArg$Const(1).getType(), 
            E.getArg$Const(1).getExprLoc(), FD, 1);
        $this().Builder.CreateMemMove(new Address(Dest), new Address(Src), SizeVal, false);
        return RValue.get(Dest.getPointer());
      }
     case BImemset:
     case BI__builtin_memset:
      {
        Address Dest = $this().EmitPointerWithAlignment(E.getArg$Const(0));
        Value /*P*/ ByteVal = $this().Builder.CreateTrunc($this().EmitScalarExpr(E.getArg$Const(1)), 
            $this().Builder.getInt8Ty());
        Value /*P*/ SizeVal = $this().EmitScalarExpr(E.getArg$Const(2));
        $this().EmitNonNullArgCheck(RValue.get(Dest.getPointer()), E.getArg$Const(0).getType(), 
            E.getArg$Const(0).getExprLoc(), FD, 0);
        $this().Builder.CreateMemSet(new Address(Dest), ByteVal, SizeVal, false);
        return RValue.get(Dest.getPointer());
      }
     case BI__builtin___memset_chk:
      {
        // fold __builtin_memset_chk(x, y, cst1, cst2) to memset iff cst1<=cst2.
        APSInt Size/*J*/= new APSInt();
        APSInt DstSize/*J*/= new APSInt();
        if (!E.getArg$Const(2).EvaluateAsInt(Size, $this().CGM.getContext())
           || !E.getArg$Const(3).EvaluateAsInt(DstSize, $this().CGM.getContext())) {
          break;
        }
        if (Size.ugt(DstSize)) {
          break;
        }
        Address Dest = $this().EmitPointerWithAlignment(E.getArg$Const(0));
        Value /*P*/ ByteVal = $this().Builder.CreateTrunc($this().EmitScalarExpr(E.getArg$Const(1)), 
            $this().Builder.getInt8Ty());
        Value /*P*/ SizeVal = ConstantInt.get($this().Builder.getContext(), Size);
        $this().Builder.CreateMemSet(new Address(Dest), ByteVal, SizeVal, false);
        return RValue.get(Dest.getPointer());
      }
     case BI__builtin_dwarf_cfa:
      {
        // The offset in bytes from the first argument to the CFA.
        //
        // Why on earth is this in the frontend?  Is there any reason at
        // all that the backend can't reasonably determine this while
        // lowering llvm.eh.dwarf.cfa()?
        //
        // TODO: If there's a satisfactory reason, add a target hook for
        // this instead of hard-coding 0, which is correct for most targets.
        int/*int32_t*/ Offset = 0;
        
        Value /*P*/ F = $this().CGM.getIntrinsic(ID.eh_dwarf_cfa);
        return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, 
                new ArrayRef<Value /*P*/ >(ConstantInt.get(Int32Ty, $int2ulong(Offset)), true)));
      }
     case BI__builtin_return_address:
      {
        Value /*P*/ Depth = $this().CGM.EmitConstantExpr(E.getArg$Const(0), $this().getContext().UnsignedIntTy.$QualType(), $this());
        Value /*P*/ F = $this().CGM.getIntrinsic(ID.returnaddress);
        return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Depth, true)));
      }
     case BI__builtin_frame_address:
      {
        Value /*P*/ Depth = $this().CGM.EmitConstantExpr(E.getArg$Const(0), $this().getContext().UnsignedIntTy.$QualType(), $this());
        Value /*P*/ F = $this().CGM.getIntrinsic(ID.frameaddress);
        return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Depth, true)));
      }
     case BI__builtin_extract_return_addr:
      {
        Value /*P*/ Address = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ Result$1 = $this().getTargetHooks().decodeReturnAddress(/*Deref*/$this(), Address);
        return RValue.get(Result$1);
      }
     case BI__builtin_frob_return_addr:
      {
        Value /*P*/ Address = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ Result$1 = $this().getTargetHooks().encodeReturnAddress(/*Deref*/$this(), Address);
        return RValue.get(Result$1);
      }
     case BI__builtin_dwarf_sp_column:
      {
        IntegerType /*P*/ Ty = IrRTTI.cast_IntegerType($this().ConvertType(E.getType()));
        int Column = $this().getTargetHooks().getDwarfEHStackPointer($this().CGM);
        if (Column == -1) {
          $this().CGM.ErrorUnsupported(E, $("__builtin_dwarf_sp_column"));
          return RValue.get(UndefValue.get(Ty));
        }
        return RValue.get(ConstantInt.get(Ty, $int2ulong(Column), true));
      }
     case BI__builtin_init_dwarf_reg_size_table:
      {
        Value /*P*/ Address = $this().EmitScalarExpr(E.getArg$Const(0));
        if ($this().getTargetHooks().initDwarfEHRegSizeTable(/*Deref*/$this(), Address)) {
          $this().CGM.ErrorUnsupported(E, $("__builtin_init_dwarf_reg_size_table"));
        }
        return RValue.get(UndefValue.get($this().ConvertType(E.getType())));
      }
     case BI__builtin_eh_return:
      {
        Value /*P*/ Int = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ Ptr = $this().EmitScalarExpr(E.getArg$Const(1));
        
        IntegerType /*P*/ IntTy = IrRTTI.cast_IntegerType(Int.getType());
        assert ((IntTy.getBitWidth() == 32 || IntTy.getBitWidth() == 64)) : "LLVM's __builtin_eh_return only supports 32- and 64-bit variants";
        Value /*P*/ F = $this().CGM.getIntrinsic(IntTy.getBitWidth() == 32 ? ID.eh_return_i32 : ID.eh_return_i64);
        $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Int, Ptr}, true)/* }*/);
        $this().Builder.CreateUnreachable();
        
        // We do need to preserve an insertion point.
        $this().EmitBlock($this().createBasicBlock(new Twine(/*KEEP_STR*/"builtin_eh_return.cont")));
        
        return RValue.get((Value /*P*/ )null);
      }
     case BI__builtin_unwind_init:
      {
        Value /*P*/ F = $this().CGM.getIntrinsic(ID.eh_unwind_init);
        return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F));
      }
     case BI__builtin_extend_pointer:
      {
        // Extends a pointer to the size of an _Unwind_Word, which is
        // uint64_t on all platforms.  Generally this gets poked into a
        // register and eventually used as an address, so if the
        // addressing registers are wider than pointers and the platform
        // doesn't implicitly ignore high-order bits when doing
        // addressing, we need to make sure we zext / sext based on
        // the platform's expectations.
        //
        // See: http://gcc.gnu.org/ml/gcc-bugs/2002-02/msg00237.html
        
        // Cast the pointer to intptr_t.
        Value /*P*/ Ptr = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ Result$1 = $this().Builder.CreatePtrToInt(Ptr, Unnamed_field8.IntPtrTy, new Twine(/*KEEP_STR*/"extend.cast"));
        
        // If that's 64 bits, we're done.
        if (Unnamed_field8.IntPtrTy.getBitWidth() == 64) {
          return RValue.get(Result$1);
        }
        
        // Otherwise, ask the codegen data what to do.
        if ($this().getTargetHooks().extendPointerWithSExt()) {
          return RValue.get($this().Builder.CreateSExt(Result$1, Int64Ty, new Twine(/*KEEP_STR*/"extend.sext")));
        } else {
          return RValue.get($this().Builder.CreateZExt(Result$1, Int64Ty, new Twine(/*KEEP_STR*/"extend.zext")));
        }
      }
     case BI__builtin_setjmp:
      {
        // Buffer is a void**.
        Address Buf = $this().EmitPointerWithAlignment(E.getArg$Const(0));
        
        // Store the frame pointer to the setjmp buffer.
        Value /*P*/ FrameAddr = $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.frameaddress), 
            new ArrayRef<Value /*P*/ >(ConstantInt.get(Int32Ty, $int2ulong(0)), true));
        $this().Builder.CreateStore(FrameAddr, new Address(Buf));
        
        // Store the stack pointer to the setjmp buffer.
        Value /*P*/ StackAddr = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.stacksave));
        Address StackSaveSlot = $this().Builder.CreateConstInBoundsGEP(new Address(Buf), $int2ulong(2), /*J:ToBase*/super.getPointerSize());
        $this().Builder.CreateStore(StackAddr, new Address(StackSaveSlot));
        
        // Call LLVM's EH setjmp, which is lightweight.
        Value /*P*/ F = $this().CGM.getIntrinsic(ID.eh_sjlj_setjmp);
        Buf.$assignMove($this().Builder.CreateBitCast(new Address(Buf), Unnamed_field9.Int8PtrTy));
        return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Buf.getPointer(), true)));
      }
     case BI__builtin_longjmp:
      {
        Value /*P*/ Buf = $this().EmitScalarExpr(E.getArg$Const(0));
        Buf = $this().Builder.CreateBitCast(Buf, Unnamed_field9.Int8PtrTy);
        
        // Call LLVM's EH longjmp, which is lightweight.
        $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.eh_sjlj_longjmp), new ArrayRef<Value /*P*/ >(Buf, true));
        
        // longjmp doesn't return; mark this as unreachable.
        $this().Builder.CreateUnreachable();
        
        // We do need to preserve an insertion point.
        $this().EmitBlock($this().createBasicBlock(new Twine(/*KEEP_STR*/"longjmp.cont")));
        
        return RValue.get((Value /*P*/ )null);
      }
     case BI__sync_fetch_and_add:
     case BI__sync_fetch_and_sub:
     case BI__sync_fetch_and_or:
     case BI__sync_fetch_and_and:
     case BI__sync_fetch_and_xor:
     case BI__sync_fetch_and_nand:
     case BI__sync_add_and_fetch:
     case BI__sync_sub_and_fetch:
     case BI__sync_and_and_fetch:
     case BI__sync_or_and_fetch:
     case BI__sync_xor_and_fetch:
     case BI__sync_nand_and_fetch:
     case BI__sync_val_compare_and_swap:
     case BI__sync_bool_compare_and_swap:
     case BI__sync_lock_test_and_set:
     case BI__sync_lock_release:
     case BI__sync_swap:
      throw new llvm_unreachable("Shouldn't make it through sema");
     case BI__sync_fetch_and_add_1:
     case BI__sync_fetch_and_add_2:
     case BI__sync_fetch_and_add_4:
     case BI__sync_fetch_and_add_8:
     case BI__sync_fetch_and_add_16:
      return CGBuiltinStatics.EmitBinaryAtomic(/*Deref*/$this(), AtomicRMWInst.BinOp.Add, E);
     case BI__sync_fetch_and_sub_1:
     case BI__sync_fetch_and_sub_2:
     case BI__sync_fetch_and_sub_4:
     case BI__sync_fetch_and_sub_8:
     case BI__sync_fetch_and_sub_16:
      return CGBuiltinStatics.EmitBinaryAtomic(/*Deref*/$this(), AtomicRMWInst.BinOp.Sub, E);
     case BI__sync_fetch_and_or_1:
     case BI__sync_fetch_and_or_2:
     case BI__sync_fetch_and_or_4:
     case BI__sync_fetch_and_or_8:
     case BI__sync_fetch_and_or_16:
      return CGBuiltinStatics.EmitBinaryAtomic(/*Deref*/$this(), AtomicRMWInst.BinOp.Or, E);
     case BI__sync_fetch_and_and_1:
     case BI__sync_fetch_and_and_2:
     case BI__sync_fetch_and_and_4:
     case BI__sync_fetch_and_and_8:
     case BI__sync_fetch_and_and_16:
      return CGBuiltinStatics.EmitBinaryAtomic(/*Deref*/$this(), AtomicRMWInst.BinOp.And, E);
     case BI__sync_fetch_and_xor_1:
     case BI__sync_fetch_and_xor_2:
     case BI__sync_fetch_and_xor_4:
     case BI__sync_fetch_and_xor_8:
     case BI__sync_fetch_and_xor_16:
      return CGBuiltinStatics.EmitBinaryAtomic(/*Deref*/$this(), AtomicRMWInst.BinOp.Xor, E);
     case BI__sync_fetch_and_nand_1:
     case BI__sync_fetch_and_nand_2:
     case BI__sync_fetch_and_nand_4:
     case BI__sync_fetch_and_nand_8:
     case BI__sync_fetch_and_nand_16:
      return CGBuiltinStatics.EmitBinaryAtomic(/*Deref*/$this(), AtomicRMWInst.BinOp.Nand, E);
     case BI__sync_fetch_and_min:
      
      // Clang extensions: not overloaded yet.
      return CGBuiltinStatics.EmitBinaryAtomic(/*Deref*/$this(), AtomicRMWInst.BinOp.Min, E);
     case BI__sync_fetch_and_max:
      return CGBuiltinStatics.EmitBinaryAtomic(/*Deref*/$this(), AtomicRMWInst.BinOp.Max, E);
     case BI__sync_fetch_and_umin:
      return CGBuiltinStatics.EmitBinaryAtomic(/*Deref*/$this(), AtomicRMWInst.BinOp.UMin, E);
     case BI__sync_fetch_and_umax:
      return CGBuiltinStatics.EmitBinaryAtomic(/*Deref*/$this(), AtomicRMWInst.BinOp.UMax, E);
     case BI__sync_add_and_fetch_1:
     case BI__sync_add_and_fetch_2:
     case BI__sync_add_and_fetch_4:
     case BI__sync_add_and_fetch_8:
     case BI__sync_add_and_fetch_16:
      return CGBuiltinStatics.EmitBinaryAtomicPost(/*Deref*/$this(), AtomicRMWInst.BinOp.Add, E, 
          Instruction.BinaryOps.Add);
     case BI__sync_sub_and_fetch_1:
     case BI__sync_sub_and_fetch_2:
     case BI__sync_sub_and_fetch_4:
     case BI__sync_sub_and_fetch_8:
     case BI__sync_sub_and_fetch_16:
      return CGBuiltinStatics.EmitBinaryAtomicPost(/*Deref*/$this(), AtomicRMWInst.BinOp.Sub, E, 
          Instruction.BinaryOps.Sub);
     case BI__sync_and_and_fetch_1:
     case BI__sync_and_and_fetch_2:
     case BI__sync_and_and_fetch_4:
     case BI__sync_and_and_fetch_8:
     case BI__sync_and_and_fetch_16:
      return CGBuiltinStatics.EmitBinaryAtomicPost(/*Deref*/$this(), AtomicRMWInst.BinOp.And, E, 
          Instruction.BinaryOps.And);
     case BI__sync_or_and_fetch_1:
     case BI__sync_or_and_fetch_2:
     case BI__sync_or_and_fetch_4:
     case BI__sync_or_and_fetch_8:
     case BI__sync_or_and_fetch_16:
      return CGBuiltinStatics.EmitBinaryAtomicPost(/*Deref*/$this(), AtomicRMWInst.BinOp.Or, E, 
          Instruction.BinaryOps.Or);
     case BI__sync_xor_and_fetch_1:
     case BI__sync_xor_and_fetch_2:
     case BI__sync_xor_and_fetch_4:
     case BI__sync_xor_and_fetch_8:
     case BI__sync_xor_and_fetch_16:
      return CGBuiltinStatics.EmitBinaryAtomicPost(/*Deref*/$this(), AtomicRMWInst.BinOp.Xor, E, 
          Instruction.BinaryOps.Xor);
     case BI__sync_nand_and_fetch_1:
     case BI__sync_nand_and_fetch_2:
     case BI__sync_nand_and_fetch_4:
     case BI__sync_nand_and_fetch_8:
     case BI__sync_nand_and_fetch_16:
      return CGBuiltinStatics.EmitBinaryAtomicPost(/*Deref*/$this(), AtomicRMWInst.BinOp.Nand, E, 
          Instruction.BinaryOps.And, true);
     case BI__sync_val_compare_and_swap_1:
     case BI__sync_val_compare_and_swap_2:
     case BI__sync_val_compare_and_swap_4:
     case BI__sync_val_compare_and_swap_8:
     case BI__sync_val_compare_and_swap_16:
      return RValue.get(CGBuiltinStatics.MakeAtomicCmpXchgValue(/*Deref*/$this(), E, false));
     case BI__sync_bool_compare_and_swap_1:
     case BI__sync_bool_compare_and_swap_2:
     case BI__sync_bool_compare_and_swap_4:
     case BI__sync_bool_compare_and_swap_8:
     case BI__sync_bool_compare_and_swap_16:
      return RValue.get(CGBuiltinStatics.MakeAtomicCmpXchgValue(/*Deref*/$this(), E, true));
     case BI__sync_swap_1:
     case BI__sync_swap_2:
     case BI__sync_swap_4:
     case BI__sync_swap_8:
     case BI__sync_swap_16:
      return CGBuiltinStatics.EmitBinaryAtomic(/*Deref*/$this(), AtomicRMWInst.BinOp.Xchg, E);
     case BI__sync_lock_test_and_set_1:
     case BI__sync_lock_test_and_set_2:
     case BI__sync_lock_test_and_set_4:
     case BI__sync_lock_test_and_set_8:
     case BI__sync_lock_test_and_set_16:
      return CGBuiltinStatics.EmitBinaryAtomic(/*Deref*/$this(), AtomicRMWInst.BinOp.Xchg, E);
     case BI__sync_lock_release_1:
     case BI__sync_lock_release_2:
     case BI__sync_lock_release_4:
     case BI__sync_lock_release_8:
     case BI__sync_lock_release_16:
      {
        Value /*P*/ Ptr = $this().EmitScalarExpr(E.getArg$Const(0));
        QualType ElTy = E.getArg$Const(0).getType().$arrow().getPointeeType();
        CharUnits StoreSize = $this().getContext().getTypeSizeInChars(/*NO_COPY*/ElTy);
        org.llvm.ir.Type /*P*/ ITy = IntegerType.get($this().getLLVMContext(), 
            $llong2uint(StoreSize.getQuantity() * 8));
        Ptr = $this().Builder.CreateBitCast(Ptr, ITy.getPointerTo());
        StoreInst /*P*/ Store = $this().Builder.CreateAlignedStore(Constant.getNullValue(ITy), Ptr, 
            new CharUnits(StoreSize));
        Store.setAtomic(AtomicOrdering.Release);
        return RValue.get((Value /*P*/ )null);
      }
     case BI__sync_synchronize:
      {
        // We assume this is supposed to correspond to a C++0x-style
        // sequentially-consistent fence (i.e. this is only usable for
        // synchonization, not device I/O or anything like that). This intrinsic
        // is really badly designed in the sense that in theory, there isn't
        // any way to safely use it... but in practice, it mostly works
        // to use it with non-atomic loads and stores to get acquire/release
        // semantics.
        $this().Builder.CreateFence(AtomicOrdering.SequentiallyConsistent);
        return RValue.get((Value /*P*/ )null);
      }
     case BI__builtin_nontemporal_load:
      return RValue.get(CGBuiltinStatics.EmitNontemporalLoad(/*Deref*/$this(), E));
     case BI__builtin_nontemporal_store:
      return RValue.get(CGBuiltinStatics.EmitNontemporalStore(/*Deref*/$this(), E));
     case BI__c11_atomic_is_lock_free:
     case BI__atomic_is_lock_free:
      {
        CallArgList Args = null;
        try {
          // Call "bool __atomic_is_lock_free(size_t size, void *ptr)". For the
          // __c11 builtin, ptr is 0 (indicating a properly-aligned object), since
          // _Atomic(T) is always properly-aligned.
          /*const*/char$ptr/*char P*/ LibCallName = $("__atomic_is_lock_free");
          Args/*J*/= new CallArgList();
          Args.add(RValue.get($this().EmitScalarExpr(E.getArg$Const(0))), 
              $this().getContext().getSizeType().$QualType());
          if (BuiltinID == Builtin.ID.BI__atomic_is_lock_free.getValue()) {
            Args.add(RValue.get($this().EmitScalarExpr(E.getArg$Const(1))), 
                $this().getContext().VoidPtrTy.$QualType());
          } else {
            Args.add(RValue.get(Constant.getNullValue(Unnamed_field9.VoidPtrTy)), 
                $this().getContext().VoidPtrTy.$QualType());
          }
          final /*const*/ CGFunctionInfo /*&*/ FuncInfo = $this().CGM.getTypes().arrangeBuiltinFunctionCall(E.getType(), Args);
          FunctionType /*P*/ FTy = $this().CGM.getTypes().GetFunctionType(FuncInfo);
          Constant /*P*/ Func = $this().CGM.CreateRuntimeFunction(FTy, new StringRef(LibCallName));
          return $this().EmitCall(FuncInfo, Func, new ReturnValueSlot(), Args);
        } finally {
          if (Args != null) { Args.$destroy(); }
        }
      }
     case BI__atomic_test_and_set:
      {
        // Look at the argument type to determine whether this is a volatile
        // operation. The parameter type is always volatile.
        QualType PtrTy = E.getArg$Const(0).IgnoreImpCasts$Const().getType();
        boolean Volatile = PtrTy.$arrow().castAs(org.clang.ast.PointerType.class).getPointeeType().isVolatileQualified();
        
        Value /*P*/ Ptr = $this().EmitScalarExpr(E.getArg$Const(0));
        /*uint*/int AddrSpace = Ptr.getType().getPointerAddressSpace();
        Ptr = $this().Builder.CreateBitCast(Ptr, Int8Ty.getPointerTo(AddrSpace));
        Value /*P*/ NewVal = $this().Builder.getInt8($int2uchar(1));
        Value /*P*/ Order = $this().EmitScalarExpr(E.getArg$Const(1));
        if (IrRTTI.isa_ConstantInt(Order)) {
          int ord = $ulong2int(IrRTTI.cast_ConstantInt(Order).getZExtValue());
          AtomicRMWInst /*P*/ Result$1 = null;
          switch (ord) {
           case 0: // memory_order_relaxed
           default: // invalid order
            Result$1 = $this().Builder.CreateAtomicRMW(AtomicRMWInst.BinOp.Xchg, Ptr, NewVal, 
                AtomicOrdering.Monotonic);
            break;
           case 1: // memory_order_consume
           case 2: // memory_order_acquire
            Result$1 = $this().Builder.CreateAtomicRMW(AtomicRMWInst.BinOp.Xchg, Ptr, NewVal, 
                AtomicOrdering.Acquire);
            break;
           case 3: // memory_order_release
            Result$1 = $this().Builder.CreateAtomicRMW(AtomicRMWInst.BinOp.Xchg, Ptr, NewVal, 
                AtomicOrdering.Release);
            break;
           case 4: // memory_order_acq_rel
            
            Result$1 = $this().Builder.CreateAtomicRMW(AtomicRMWInst.BinOp.Xchg, Ptr, NewVal, 
                AtomicOrdering.AcquireRelease);
            break;
           case 5: // memory_order_seq_cst
            Result$1 = $this().Builder.CreateAtomicRMW(AtomicRMWInst.BinOp.Xchg, Ptr, NewVal, 
                AtomicOrdering.SequentiallyConsistent);
            break;
          }
          Result$1.setVolatile(Volatile);
          return RValue.get($this().Builder.CreateIsNotNull(Result$1, new Twine(/*KEEP_STR*/"tobool")));
        }
        
        BasicBlock /*P*/ ContBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"atomic.continue"), $this().CurFn);
        
        BasicBlock /*P*/ BBs[/*5*/] = new BasicBlock /*P*/  [/*5*/] {
          $this().createBasicBlock(new Twine(/*KEEP_STR*/"monotonic"), $this().CurFn), 
          $this().createBasicBlock(new Twine(/*KEEP_STR*/"acquire"), $this().CurFn), 
          $this().createBasicBlock(new Twine(/*KEEP_STR*/"release"), $this().CurFn), 
          $this().createBasicBlock(new Twine(/*KEEP_STR*/"acqrel"), $this().CurFn), 
          $this().createBasicBlock(new Twine(/*KEEP_STR*/"seqcst"), $this().CurFn)
        };
        AtomicOrdering Orders[/*5*/] = new AtomicOrdering [/*5*/] {
          AtomicOrdering.Monotonic, AtomicOrdering.Acquire, 
          AtomicOrdering.Release, AtomicOrdering.AcquireRelease, 
          AtomicOrdering.SequentiallyConsistent};
        
        Order = $this().Builder.CreateIntCast(Order, $this().Builder.getInt32Ty(), false);
        SwitchInst /*P*/ SI = $this().Builder.CreateSwitch(Order, BBs[0]);
        
        $this().Builder.SetInsertPoint(ContBB);
        PHINode /*P*/ Result$1 = $this().Builder.CreatePHI(Int8Ty, 5, new Twine(/*KEEP_STR*/"was_set"));
        
        for (/*uint*/int i = 0; $less_uint(i, 5); ++i) {
          $this().Builder.SetInsertPoint(BBs[i]);
          AtomicRMWInst /*P*/ RMW = $this().Builder.CreateAtomicRMW(AtomicRMWInst.BinOp.Xchg, 
              Ptr, NewVal, Orders[i]);
          RMW.setVolatile(Volatile);
          Result$1.addIncoming(RMW, BBs[i]);
          $this().Builder.CreateBr(ContBB);
        }
        
        SI.addCase($this().Builder.getInt32(0), BBs[0]);
        SI.addCase($this().Builder.getInt32(1), BBs[1]);
        SI.addCase($this().Builder.getInt32(2), BBs[1]);
        SI.addCase($this().Builder.getInt32(3), BBs[2]);
        SI.addCase($this().Builder.getInt32(4), BBs[3]);
        SI.addCase($this().Builder.getInt32(5), BBs[4]);
        
        $this().Builder.SetInsertPoint(ContBB);
        return RValue.get($this().Builder.CreateIsNotNull(Result$1, new Twine(/*KEEP_STR*/"tobool")));
      }
     case BI__atomic_clear:
      {
        QualType PtrTy = E.getArg$Const(0).IgnoreImpCasts$Const().getType();
        boolean Volatile = PtrTy.$arrow().castAs(org.clang.ast.PointerType.class).getPointeeType().isVolatileQualified();
        
        Address Ptr = $this().EmitPointerWithAlignment(E.getArg$Const(0));
        /*uint*/int AddrSpace = Ptr.getPointer().getType().getPointerAddressSpace();
        Ptr.$assignMove($this().Builder.CreateBitCast(new Address(Ptr), Int8Ty.getPointerTo(AddrSpace)));
        Value /*P*/ NewVal = $this().Builder.getInt8($int2uchar(0));
        Value /*P*/ Order = $this().EmitScalarExpr(E.getArg$Const(1));
        if (IrRTTI.isa_ConstantInt(Order)) {
          int ord = $ulong2int(IrRTTI.cast_ConstantInt(Order).getZExtValue());
          StoreInst /*P*/ Store = $this().Builder.CreateStore(NewVal, new Address(Ptr), Volatile);
          switch (ord) {
           case 0: // memory_order_relaxed
           default: // invalid order
            Store.setOrdering(AtomicOrdering.Monotonic);
            break;
           case 3: // memory_order_release
            Store.setOrdering(AtomicOrdering.Release);
            break;
           case 5: // memory_order_seq_cst
            Store.setOrdering(AtomicOrdering.SequentiallyConsistent);
            break;
          }
          return RValue.get((Value /*P*/ )null);
        }
        
        BasicBlock /*P*/ ContBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"atomic.continue"), $this().CurFn);
        
        BasicBlock /*P*/ BBs[/*3*/] = new BasicBlock /*P*/  [/*3*/] {
          $this().createBasicBlock(new Twine(/*KEEP_STR*/"monotonic"), $this().CurFn), 
          $this().createBasicBlock(new Twine(/*KEEP_STR*/"release"), $this().CurFn), 
          $this().createBasicBlock(new Twine(/*KEEP_STR*/"seqcst"), $this().CurFn)
        };
        AtomicOrdering Orders[/*3*/] = new AtomicOrdering [/*3*/] {
          AtomicOrdering.Monotonic, AtomicOrdering.Release, 
          AtomicOrdering.SequentiallyConsistent};
        
        Order = $this().Builder.CreateIntCast(Order, $this().Builder.getInt32Ty(), false);
        SwitchInst /*P*/ SI = $this().Builder.CreateSwitch(Order, BBs[0]);
        
        for (/*uint*/int i = 0; $less_uint(i, 3); ++i) {
          $this().Builder.SetInsertPoint(BBs[i]);
          StoreInst /*P*/ Store = $this().Builder.CreateStore(NewVal, new Address(Ptr), Volatile);
          Store.setOrdering(Orders[i]);
          $this().Builder.CreateBr(ContBB);
        }
        
        SI.addCase($this().Builder.getInt32(0), BBs[0]);
        SI.addCase($this().Builder.getInt32(3), BBs[1]);
        SI.addCase($this().Builder.getInt32(5), BBs[2]);
        
        $this().Builder.SetInsertPoint(ContBB);
        return RValue.get((Value /*P*/ )null);
      }
     case BI__atomic_thread_fence:
     case BI__atomic_signal_fence:
     case BI__c11_atomic_thread_fence:
     case BI__c11_atomic_signal_fence:
      {
        SynchronizationScope Scope;
        if (BuiltinID == Builtin.ID.BI__atomic_signal_fence.getValue()
           || BuiltinID == Builtin.ID.BI__c11_atomic_signal_fence.getValue()) {
          Scope = SynchronizationScope.SingleThread;
        } else {
          Scope = SynchronizationScope.CrossThread;
        }
        Value /*P*/ Order = $this().EmitScalarExpr(E.getArg$Const(0));
        if (IrRTTI.isa_ConstantInt(Order)) {
          int ord = $ulong2int(IrRTTI.cast_ConstantInt(Order).getZExtValue());
          switch (ord) {
           case 0: // memory_order_relaxed
           default: // invalid order
            break;
           case 1: // memory_order_consume
           case 2: // memory_order_acquire
            $this().Builder.CreateFence(AtomicOrdering.Acquire, Scope);
            break;
           case 3: // memory_order_release
            $this().Builder.CreateFence(AtomicOrdering.Release, Scope);
            break;
           case 4: // memory_order_acq_rel
            $this().Builder.CreateFence(AtomicOrdering.AcquireRelease, Scope);
            break;
           case 5: // memory_order_seq_cst
            $this().Builder.CreateFence(AtomicOrdering.SequentiallyConsistent, 
                Scope);
            break;
          }
          return RValue.get((Value /*P*/ )null);
        }
        
        BasicBlock /*P*/ AcquireBB;
        BasicBlock /*P*/ ReleaseBB;
        BasicBlock /*P*/ AcqRelBB;
        BasicBlock /*P*/ SeqCstBB;
        AcquireBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"acquire"), $this().CurFn);
        ReleaseBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"release"), $this().CurFn);
        AcqRelBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"acqrel"), $this().CurFn);
        SeqCstBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"seqcst"), $this().CurFn);
        BasicBlock /*P*/ ContBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"atomic.continue"), $this().CurFn);
        
        Order = $this().Builder.CreateIntCast(Order, $this().Builder.getInt32Ty(), false);
        SwitchInst /*P*/ SI = $this().Builder.CreateSwitch(Order, ContBB);
        
        $this().Builder.SetInsertPoint(AcquireBB);
        $this().Builder.CreateFence(AtomicOrdering.Acquire, Scope);
        $this().Builder.CreateBr(ContBB);
        SI.addCase($this().Builder.getInt32(1), AcquireBB);
        SI.addCase($this().Builder.getInt32(2), AcquireBB);
        
        $this().Builder.SetInsertPoint(ReleaseBB);
        $this().Builder.CreateFence(AtomicOrdering.Release, Scope);
        $this().Builder.CreateBr(ContBB);
        SI.addCase($this().Builder.getInt32(3), ReleaseBB);
        
        $this().Builder.SetInsertPoint(AcqRelBB);
        $this().Builder.CreateFence(AtomicOrdering.AcquireRelease, Scope);
        $this().Builder.CreateBr(ContBB);
        SI.addCase($this().Builder.getInt32(4), AcqRelBB);
        
        $this().Builder.SetInsertPoint(SeqCstBB);
        $this().Builder.CreateFence(AtomicOrdering.SequentiallyConsistent, Scope);
        $this().Builder.CreateBr(ContBB);
        SI.addCase($this().Builder.getInt32(5), SeqCstBB);
        
        $this().Builder.SetInsertPoint(ContBB);
        return RValue.get((Value /*P*/ )null);
      }
     case BIsqrt:
     case BIsqrtf:
     case BIsqrtl:
      {
        // Transform a call to sqrt* into a @llvm.sqrt.* intrinsic call, but only
        // in finite- or unsafe-math mode (the intrinsic has different semantics
        // for handling negative numbers compared to the library function, so
        // -fmath-errno=0 is not enough).
        if (!FD.hasAttr(ConstAttr.class)) {
          break;
        }
        if (!($this().CGM.getCodeGenOpts().UnsafeFPMath
           || $this().CGM.getCodeGenOpts().NoNaNsFPMath)) {
          break;
        }
        Value /*P*/ Arg0 = $this().EmitScalarExpr(E.getArg$Const(0));
        org.llvm.ir.Type /*P*/ ArgType = Arg0.getType();
        Value /*P*/ F = $this().CGM.getIntrinsic(ID.sqrt, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgType, true));
        return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Arg0, true)));
      }
     case BI__builtin_pow:
     case BI__builtin_powf:
     case BI__builtin_powl:
     case BIpow:
     case BIpowf:
     case BIpowl:
      {
        // Transform a call to pow* into a @llvm.pow.* intrinsic call.
        if (!FD.hasAttr(ConstAttr.class)) {
          break;
        }
        Value /*P*/ Base = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ Exponent = $this().EmitScalarExpr(E.getArg$Const(1));
        org.llvm.ir.Type /*P*/ ArgType = Base.getType();
        Value /*P*/ F = $this().CGM.getIntrinsic(ID.pow, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgType, true));
        return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Base, Exponent}, true)/* }*/));
      }
     case BIfma:
     case BIfmaf:
     case BIfmal:
     case BI__builtin_fma:
     case BI__builtin_fmaf:
     case BI__builtin_fmal:
      {
        // Rewrite fma to intrinsic.
        Value /*P*/ FirstArg = $this().EmitScalarExpr(E.getArg$Const(0));
        org.llvm.ir.Type /*P*/ ArgType = FirstArg.getType();
        Value /*P*/ F = $this().CGM.getIntrinsic(ID.fma, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgType, true));
        return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {
                      FirstArg, $this().EmitScalarExpr(E.getArg$Const(1)), 
                      $this().EmitScalarExpr(E.getArg$Const(2))}, true)/* }*/));
      }
     case BI__builtin_signbit:
     case BI__builtin_signbitf:
     case BI__builtin_signbitl:
      {
        return RValue.get($this().Builder.CreateZExt(CGBuiltinStatics.EmitSignBit(/*Deref*/$this(), $this().EmitScalarExpr(E.getArg$Const(0))), 
                $this().ConvertType(E.getType())));
      }
     case BI__builtin_annotation:
      {
        Value /*P*/ AnnVal = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ F = $this().CGM.getIntrinsic(ID.annotation, 
            new ArrayRef<org.llvm.ir.Type /*P*/ >(AnnVal.getType(), true));
        
        // Get the annotation string, go through casts. Sema requires this to be a
        // non-wide string literal, potentially casted, so the cast<> is safe.
        /*const*/ Expr /*P*/ AnnotationStrExpr = E.getArg$Const(1).IgnoreParenCasts$Const();
        StringRef Str = AstRTTI.cast_StringLiteral(AnnotationStrExpr).getString();
        return RValue.get($this().EmitAnnotationCall(F, AnnVal, new StringRef(Str), E.getExprLoc()));
      }
     case BI__builtin_addcb:
     case BI__builtin_addcs:
     case BI__builtin_addc:
     case BI__builtin_addcl:
     case BI__builtin_addcll:
     case BI__builtin_subcb:
     case BI__builtin_subcs:
     case BI__builtin_subc:
     case BI__builtin_subcl:
     case BI__builtin_subcll:
      {
        
        // We translate all of these builtins from expressions of the form:
        //   int x = ..., y = ..., carryin = ..., carryout, result;
        //   result = __builtin_addc(x, y, carryin, &carryout);
        //
        // to LLVM IR of the form:
        //
        //   %tmp1 = call {i32, i1} @llvm.uadd.with.overflow.i32(i32 %x, i32 %y)
        //   %tmpsum1 = extractvalue {i32, i1} %tmp1, 0
        //   %carry1 = extractvalue {i32, i1} %tmp1, 1
        //   %tmp2 = call {i32, i1} @llvm.uadd.with.overflow.i32(i32 %tmpsum1,
        //                                                       i32 %carryin)
        //   %result = extractvalue {i32, i1} %tmp2, 0
        //   %carry2 = extractvalue {i32, i1} %tmp2, 1
        //   %tmp3 = or i1 %carry1, %carry2
        //   %tmp4 = zext i1 %tmp3 to i32
        //   store i32 %tmp4, i32* %carryout
        
        // Scalarize our inputs.
        Value /*P*/ X = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ Y = $this().EmitScalarExpr(E.getArg$Const(1));
        Value /*P*/ Carryin = $this().EmitScalarExpr(E.getArg$Const(2));
        Address CarryOutPtr = $this().EmitPointerWithAlignment(E.getArg$Const(3));
        
        // Decide if we are lowering to a uadd.with.overflow or usub.with.overflow.
        /*Intrinsic.ID*/int IntrinsicId;
        switch (Builtin.ID.valueOf(BuiltinID)) {
         default:
          throw new llvm_unreachable("Unknown multiprecision builtin id.");
         case BI__builtin_addcb:
         case BI__builtin_addcs:
         case BI__builtin_addc:
         case BI__builtin_addcl:
         case BI__builtin_addcll:
          IntrinsicId = ID.uadd_with_overflow;
          break;
         case BI__builtin_subcb:
         case BI__builtin_subcs:
         case BI__builtin_subc:
         case BI__builtin_subcl:
         case BI__builtin_subcll:
          IntrinsicId = ID.usub_with_overflow;
          break;
        }
        
        // Construct our resulting LLVM IR expression.
        type$ref<Value /*P*/ > Carry1 = create_type$ref();
        Value /*P*/ Sum1 = CGBuiltinStatics.EmitOverflowIntrinsic(/*Deref*/$this(), IntrinsicId, 
            X, Y, Carry1);
        type$ref<Value /*P*/ > Carry2 = create_type$ref();
        Value /*P*/ Sum2 = CGBuiltinStatics.EmitOverflowIntrinsic(/*Deref*/$this(), IntrinsicId, 
            Sum1, Carryin, Carry2);
        Value /*P*/ CarryOut = $this().Builder.CreateZExt($this().Builder.CreateOr(Carry1.$deref(), Carry2.$deref()), 
            X.getType());
        $this().Builder.CreateStore(CarryOut, new Address(CarryOutPtr));
        return RValue.get(Sum2);
      }
     case BI__builtin_add_overflow:
     case BI__builtin_sub_overflow:
     case BI__builtin_mul_overflow:
      {
        /*const*/ Expr /*P*/ LeftArg = E.getArg$Const(0);
        /*const*/ Expr /*P*/ RightArg = E.getArg$Const(1);
        /*const*/ Expr /*P*/ ResultArg = E.getArg$Const(2);
        
        QualType ResultQTy = ResultArg.getType().$arrow().castAs(org.clang.ast.PointerType.class).getPointeeType();
        
        WidthAndSignedness LeftInfo = CGBuiltinStatics.getIntegerWidthAndSignedness($this().CGM.getContext(), LeftArg.getType());
        WidthAndSignedness RightInfo = CGBuiltinStatics.getIntegerWidthAndSignedness($this().CGM.getContext(), RightArg.getType());
        WidthAndSignedness ResultInfo = CGBuiltinStatics.getIntegerWidthAndSignedness($this().CGM.getContext(), new QualType(ResultQTy));
        WidthAndSignedness EncompassingInfo = CGBuiltinStatics.EncompassingIntegerType(/*{ */new ArrayRef< WidthAndSignedness>(new /*const*/ WidthAndSignedness [/*3*/] {LeftInfo, RightInfo, ResultInfo}, false)/* }*/);
        
        org.llvm.ir.Type /*P*/ EncompassingLLVMTy = IntegerType.get($this().CGM.getLLVMContext(), EncompassingInfo.Width);
        
        org.llvm.ir.Type /*P*/ ResultLLVMTy = $this().CGM.getTypes().ConvertType(new QualType(ResultQTy));
        
        /*Intrinsic.ID*/int IntrinsicId;
        switch (Builtin.ID.valueOf(BuiltinID)) {
         default:
          throw new llvm_unreachable("Unknown overflow builtin id.");
         case BI__builtin_add_overflow:
          IntrinsicId = EncompassingInfo.Signed ? ID.sadd_with_overflow : ID.uadd_with_overflow;
          break;
         case BI__builtin_sub_overflow:
          IntrinsicId = EncompassingInfo.Signed ? ID.ssub_with_overflow : ID.usub_with_overflow;
          break;
         case BI__builtin_mul_overflow:
          IntrinsicId = EncompassingInfo.Signed ? ID.smul_with_overflow : ID.umul_with_overflow;
          break;
        }
        
        Value /*P*/ Left = $this().EmitScalarExpr(LeftArg);
        Value /*P*/ Right = $this().EmitScalarExpr(RightArg);
        Address ResultPtr = $this().EmitPointerWithAlignment(ResultArg);
        
        // Extend each operand to the encompassing type.
        Left = $this().Builder.CreateIntCast(Left, EncompassingLLVMTy, LeftInfo.Signed);
        Right = $this().Builder.CreateIntCast(Right, EncompassingLLVMTy, RightInfo.Signed);
        
        // Perform the operation on the extended values.
        type$ref<Value /*P*/ > Overflow = create_type$ref();
        Value /*P*/ Result$1;
        Result$1 = CGBuiltinStatics.EmitOverflowIntrinsic(/*Deref*/$this(), IntrinsicId, Left, Right, Overflow);
        if ($greater_uint(EncompassingInfo.Width, ResultInfo.Width)) {
          // The encompassing type is wider than the result type, so we need to
          // truncate it.
          Value /*P*/ ResultTrunc = $this().Builder.CreateTrunc(Result$1, ResultLLVMTy);
          
          // To see if the truncation caused an overflow, we will extend
          // the result and then compare it to the original result.
          Value /*P*/ ResultTruncExt = $this().Builder.CreateIntCast(ResultTrunc, EncompassingLLVMTy, ResultInfo.Signed);
          Value /*P*/ TruncationOverflow = $this().Builder.CreateICmpNE(Result$1, ResultTruncExt);
          
          Overflow.$set($this().Builder.CreateOr(Overflow.$deref(), TruncationOverflow));
          Result$1 = ResultTrunc;
        }
        
        // Finally, store the result using the pointer.
        boolean isVolatile = ResultArg.getType().$arrow().getPointeeType().isVolatileQualified();
        $this().Builder.CreateStore($this().EmitToMemory(Result$1, new QualType(ResultQTy)), new Address(ResultPtr), isVolatile);
        
        return RValue.get(Overflow.$deref());
      }
     case BI__builtin_uadd_overflow:
     case BI__builtin_uaddl_overflow:
     case BI__builtin_uaddll_overflow:
     case BI__builtin_usub_overflow:
     case BI__builtin_usubl_overflow:
     case BI__builtin_usubll_overflow:
     case BI__builtin_umul_overflow:
     case BI__builtin_umull_overflow:
     case BI__builtin_umulll_overflow:
     case BI__builtin_sadd_overflow:
     case BI__builtin_saddl_overflow:
     case BI__builtin_saddll_overflow:
     case BI__builtin_ssub_overflow:
     case BI__builtin_ssubl_overflow:
     case BI__builtin_ssubll_overflow:
     case BI__builtin_smul_overflow:
     case BI__builtin_smull_overflow:
     case BI__builtin_smulll_overflow:
      {
        
        // We translate all of these builtins directly to the relevant llvm IR node.
        
        // Scalarize our inputs.
        Value /*P*/ X = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ Y = $this().EmitScalarExpr(E.getArg$Const(1));
        Address SumOutPtr = $this().EmitPointerWithAlignment(E.getArg$Const(2));
        
        // Decide which of the overflow intrinsics we are lowering to:
        /*Intrinsic.ID*/int IntrinsicId;
        switch (Builtin.ID.valueOf(BuiltinID)) {
         default:
          throw new llvm_unreachable("Unknown overflow builtin id.");
         case BI__builtin_uadd_overflow:
         case BI__builtin_uaddl_overflow:
         case BI__builtin_uaddll_overflow:
          IntrinsicId = ID.uadd_with_overflow;
          break;
         case BI__builtin_usub_overflow:
         case BI__builtin_usubl_overflow:
         case BI__builtin_usubll_overflow:
          IntrinsicId = ID.usub_with_overflow;
          break;
         case BI__builtin_umul_overflow:
         case BI__builtin_umull_overflow:
         case BI__builtin_umulll_overflow:
          IntrinsicId = ID.umul_with_overflow;
          break;
         case BI__builtin_sadd_overflow:
         case BI__builtin_saddl_overflow:
         case BI__builtin_saddll_overflow:
          IntrinsicId = ID.sadd_with_overflow;
          break;
         case BI__builtin_ssub_overflow:
         case BI__builtin_ssubl_overflow:
         case BI__builtin_ssubll_overflow:
          IntrinsicId = ID.ssub_with_overflow;
          break;
         case BI__builtin_smul_overflow:
         case BI__builtin_smull_overflow:
         case BI__builtin_smulll_overflow:
          IntrinsicId = ID.smul_with_overflow;
          break;
        }
        
        type$ref<Value /*P*/ > Carry = create_type$ref();
        Value /*P*/ Sum = CGBuiltinStatics.EmitOverflowIntrinsic(/*Deref*/$this(), IntrinsicId, X, Y, Carry);
        $this().Builder.CreateStore(Sum, new Address(SumOutPtr));
        
        return RValue.get(Carry.$deref());
      }
     case BI__builtin_addressof:
      return RValue.get($this().EmitLValue(E.getArg$Const(0)).getPointer());
     case BI__builtin_operator_new:
      return $this().EmitBuiltinNewDeleteCall(FD.getType().$arrow().castAs(FunctionProtoType.class), 
          E.getArg$Const(0), false);
     case BI__builtin_operator_delete:
      return $this().EmitBuiltinNewDeleteCall(FD.getType().$arrow().castAs(FunctionProtoType.class), 
          E.getArg$Const(0), true);
     case BI__noop:
      // __noop always evaluates to an integer literal zero.
      return RValue.get(ConstantInt.get(IntTy, $int2ulong(0)));
     case BI__builtin_call_with_static_chain:
      {
        /*const*/ CallExpr /*P*/ Call = AstExpressionsRTTI.cast_CallExpr(E.getArg$Const(0));
        /*const*/ Expr /*P*/ Chain = E.getArg$Const(1);
        return $this().EmitCall(Call.getCallee$Const().getType(), 
            $this().EmitScalarExpr(Call.getCallee$Const()), Call, new ReturnValueSlot(ReturnValue), 
            new CGCalleeInfo(Call.getCalleeDecl$Const()), $this().EmitScalarExpr(Chain));
      }
     case BI_InterlockedExchange:
     case BI_InterlockedExchangePointer:
      return CGBuiltinStatics.EmitBinaryAtomic(/*Deref*/$this(), AtomicRMWInst.BinOp.Xchg, E);
     case BI_InterlockedCompareExchangePointer:
      {
        org.llvm.ir.Type /*P*/ RTy;
        IntegerType /*P*/ IntType = IntegerType.get($this().getLLVMContext(), 
            $ulong2uint($this().getContext().getTypeSize(E.getType())));
        org.llvm.ir.Type /*P*/ IntPtrType = IntType.getPointerTo();
        
        Value /*P*/ Destination = $this().Builder.CreateBitCast($this().EmitScalarExpr(E.getArg$Const(0)), IntPtrType);
        
        Value /*P*/ Exchange = $this().EmitScalarExpr(E.getArg$Const(1));
        RTy = Exchange.getType();
        Exchange = $this().Builder.CreatePtrToInt(Exchange, IntType);
        
        Value /*P*/ Comparand = $this().Builder.CreatePtrToInt($this().EmitScalarExpr(E.getArg$Const(2)), IntType);
        
        AtomicCmpXchgInst /*P*/ Result$1 = $this().Builder.CreateAtomicCmpXchg(Destination, Comparand, Exchange, 
            AtomicOrdering.SequentiallyConsistent, 
            AtomicOrdering.SequentiallyConsistent);
        Result$1.setVolatile(true);
        
        return RValue.get($this().Builder.CreateIntToPtr($this().Builder.CreateExtractValue(Result$1, 
                    new ArrayRefUInt(0)), 
                RTy));
      }
     case BI_InterlockedCompareExchange:
      {
        AtomicCmpXchgInst /*P*/ CXI = $this().Builder.CreateAtomicCmpXchg($this().EmitScalarExpr(E.getArg$Const(0)), 
            $this().EmitScalarExpr(E.getArg$Const(2)), 
            $this().EmitScalarExpr(E.getArg$Const(1)), 
            AtomicOrdering.SequentiallyConsistent, 
            AtomicOrdering.SequentiallyConsistent);
        CXI.setVolatile(true);
        return RValue.get($this().Builder.CreateExtractValue(CXI, new ArrayRefUInt(0)));
      }
     case BI_InterlockedIncrement:
      {
        org.llvm.ir.Type /*P*/ IntTy = $this().ConvertType(E.getType());
        AtomicRMWInst /*P*/ RMWI = $this().Builder.CreateAtomicRMW(AtomicRMWInst.BinOp.Add, 
            $this().EmitScalarExpr(E.getArg$Const(0)), 
            ConstantInt.get(IntTy, $int2ulong(1)), 
            AtomicOrdering.SequentiallyConsistent);
        RMWI.setVolatile(true);
        return RValue.get($this().Builder.CreateAdd(RMWI, ConstantInt.get(IntTy, $int2ulong(1))));
      }
     case BI_InterlockedDecrement:
      {
        org.llvm.ir.Type /*P*/ IntTy = $this().ConvertType(E.getType());
        AtomicRMWInst /*P*/ RMWI = $this().Builder.CreateAtomicRMW(AtomicRMWInst.BinOp.Sub, 
            $this().EmitScalarExpr(E.getArg$Const(0)), 
            ConstantInt.get(IntTy, $int2ulong(1)), 
            AtomicOrdering.SequentiallyConsistent);
        RMWI.setVolatile(true);
        return RValue.get($this().Builder.CreateSub(RMWI, ConstantInt.get(IntTy, $int2ulong(1))));
      }
     case BI_InterlockedExchangeAdd:
      {
        AtomicRMWInst /*P*/ RMWI = $this().Builder.CreateAtomicRMW(AtomicRMWInst.BinOp.Add, 
            $this().EmitScalarExpr(E.getArg$Const(0)), 
            $this().EmitScalarExpr(E.getArg$Const(1)), 
            AtomicOrdering.SequentiallyConsistent);
        RMWI.setVolatile(true);
        return RValue.get(RMWI);
      }
     case BI__readfsdword:
      {
        org.llvm.ir.Type /*P*/ IntTy = $this().ConvertType(E.getType());
        Value /*P*/ IntToPtr = $this().Builder.CreateIntToPtr($this().EmitScalarExpr(E.getArg$Const(0)), 
            org.llvm.ir.PointerType.get(IntTy, 257));
        LoadInst /*P*/ Load = $this().Builder.CreateDefaultAlignedLoad(IntToPtr, /*isVolatile=*/ true);
        return RValue.get(Load);
      }
     case BI__exception_code:
     case BI_exception_code:
      return RValue.get($this().EmitSEHExceptionCode());
     case BI__exception_info:
     case BI_exception_info:
      return RValue.get($this().EmitSEHExceptionInfo());
     case BI__abnormal_termination:
     case BI_abnormal_termination:
      return RValue.get($this().EmitSEHAbnormalTermination());
     case BI_setjmpex:
      {
        if ($this().getTarget().getTriple().isOSMSVCRT()) {
          org.llvm.ir.Type /*P*/ ArgTypes[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {Unnamed_field9.Int8PtrTy, Unnamed_field9.Int8PtrTy};
          AttributeSet ReturnsTwiceAttr = AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind($this().getLLVMContext(), AttributeSet.AttrIndex.FunctionIndex.getValue(), 
              new ArrayRef<Attribute.AttrKind>(Attribute.AttrKind.ReturnsTwice));
          Constant /*P*/ SetJmpEx = $this().CGM.CreateRuntimeFunction(org.llvm.ir.FunctionType.get(IntTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTypes, true), /*isVarArg=*/ false), 
              new StringRef(/*KEEP_STR*/"_setjmpex"), new AttributeSet(ReturnsTwiceAttr));
          Value /*P*/ Buf = $this().Builder.CreateBitOrPointerCast($this().EmitScalarExpr(E.getArg$Const(0)), Unnamed_field9.Int8PtrTy);
          Value /*P*/ FrameAddr = $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.frameaddress), 
              new ArrayRef<Value /*P*/ >(ConstantInt.get(Int32Ty, $int2ulong(0)), true));
          Value /*P*/ Args[/*2*/] = new Value /*P*/  [/*2*/] {Buf, FrameAddr};
          CallSite CS = $this().EmitRuntimeCallOrInvoke(SetJmpEx, new ArrayRef<Value /*P*/ >(Args, true));
          CS.setAttributes(ReturnsTwiceAttr);
          return RValue.get(CS.getInstruction());
        }
        break;
      }
     case BI_setjmp:
      {
        if ($this().getTarget().getTriple().isOSMSVCRT()) {
          AttributeSet ReturnsTwiceAttr = AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind($this().getLLVMContext(), AttributeSet.AttrIndex.FunctionIndex.getValue(), 
              new ArrayRef<Attribute.AttrKind>(Attribute.AttrKind.ReturnsTwice));
          Value /*P*/ Buf = $this().Builder.CreateBitOrPointerCast($this().EmitScalarExpr(E.getArg$Const(0)), Unnamed_field9.Int8PtrTy);
          CallSite CS/*J*/= new CallSite();
          if ($this().getTarget().getTriple().getArch() == Triple.ArchType.x86) {
            org.llvm.ir.Type /*P*/ ArgTypes[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {Unnamed_field9.Int8PtrTy, IntTy};
            Constant /*P*/ SetJmp3 = $this().CGM.CreateRuntimeFunction(org.llvm.ir.FunctionType.get(IntTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTypes, true), /*isVarArg=*/ true), 
                new StringRef(/*KEEP_STR*/"_setjmp3"), new AttributeSet(ReturnsTwiceAttr));
            Value /*P*/ Count = ConstantInt.get(IntTy, $int2ulong(0));
            Value /*P*/ Args[/*2*/] = new Value /*P*/  [/*2*/] {Buf, Count};
            CS.$assignMove($this().EmitRuntimeCallOrInvoke(SetJmp3, new ArrayRef<Value /*P*/ >(Args, true)));
          } else {
            org.llvm.ir.Type /*P*/ ArgTypes[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {Unnamed_field9.Int8PtrTy, Unnamed_field9.Int8PtrTy};
            Constant /*P*/ SetJmp = $this().CGM.CreateRuntimeFunction(org.llvm.ir.FunctionType.get(IntTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTypes, true), /*isVarArg=*/ false), 
                new StringRef(/*KEEP_STR*/"_setjmp"), new AttributeSet(ReturnsTwiceAttr));
            Value /*P*/ FrameAddr = $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.frameaddress), 
                new ArrayRef<Value /*P*/ >(ConstantInt.get(Int32Ty, $int2ulong(0)), true));
            Value /*P*/ Args[/*2*/] = new Value /*P*/  [/*2*/] {Buf, FrameAddr};
            CS.$assignMove($this().EmitRuntimeCallOrInvoke(SetJmp, new ArrayRef<Value /*P*/ >(Args, true)));
          }
          CS.setAttributes(ReturnsTwiceAttr);
          return RValue.get(CS.getInstruction());
        }
        break;
      }
     case BI__GetExceptionInfo:
      {
        {
          GlobalVariable /*P*/ GV = $this().CGM.getCXXABI().getThrowInfo(FD.getParamDecl$Const(0).getType());
          if ((GV != null)) {
            return RValue.get(ConstantExpr.getBitCast(GV, $this().CGM.Unnamed_field9.Int8PtrTy));
          }
        }
        break;
      }
     case BIread_pipe:
     case BIwrite_pipe:
      {
        Value /*P*/ Arg0 = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ Arg1 = $this().EmitScalarExpr(E.getArg$Const(1));
        
        // Type of the generic packet parameter.
        /*uint*/int GenericAS = $this().getContext().getTargetAddressSpace(LangAS.ID.opencl_generic);
        org.llvm.ir.Type /*P*/ I8PTy = org.llvm.ir.PointerType.get(org.llvm.ir.Type.getInt8Ty($this().getLLVMContext()), GenericAS);
        
        // Testing which overloaded version we should generate the call for.
        if (2/*U*/ == E.getNumArgs()) {
          /*const*/char$ptr/*char P*/ Name = $tryClone((BuiltinID == Builtin.ID.BIread_pipe.getValue()) ? $("__read_pipe_2") : $("__write_pipe_2"));
          // Creating a generic function type to be able to call with any builtin or
          // user defined type.
          org.llvm.ir.Type /*P*/ ArgTys[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {Arg0.getType(), I8PTy};
          org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTys, true), false);
          Value /*P*/ BCast = $this().Builder.CreatePointerCast(Arg1, I8PTy);
          return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.CreateRuntimeFunction(FTy, new StringRef(Name)), /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Arg0, BCast}, true)/* }*/));
        } else {
          assert (4 == E.getNumArgs()) : "Illegal number of parameters to pipe function";
          /*const*/char$ptr/*char P*/ Name = $tryClone((BuiltinID == Builtin.ID.BIread_pipe.getValue()) ? $("__read_pipe_4") : $("__write_pipe_4"));
          
          org.llvm.ir.Type /*P*/ ArgTys[/*4*/] = new org.llvm.ir.Type /*P*/  [/*4*/] {Arg0.getType(), Arg1.getType(), Int32Ty, I8PTy};
          Value /*P*/ Arg2 = $this().EmitScalarExpr(E.getArg$Const(2));
          Value /*P*/ Arg3 = $this().EmitScalarExpr(E.getArg$Const(3));
          org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTys, true), false);
          Value /*P*/ BCast = $this().Builder.CreatePointerCast(Arg3, I8PTy);
          // We know the third argument is an integer type, but we may need to cast
          // it to i32.
          if (Arg2.getType() != Int32Ty) {
            Arg2 = $this().Builder.CreateZExtOrTrunc(Arg2, Int32Ty);
          }
          return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.CreateRuntimeFunction(FTy, new StringRef(Name)), /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*4*/] {Arg0, Arg1, Arg2, BCast}, true)/* }*/));
        }
      }
     case BIreserve_read_pipe:
     case BIreserve_write_pipe:
     case BIwork_group_reserve_read_pipe:
     case BIwork_group_reserve_write_pipe:
     case BIsub_group_reserve_read_pipe:
     case BIsub_group_reserve_write_pipe:
      {
        // Composing the mangled name for the function.
        /*const*/char$ptr/*char P*/ Name = create_char$ptr();
        if (BuiltinID == Builtin.ID.BIreserve_read_pipe.getValue()) {
          Name = $("__reserve_read_pipe");
        } else if (BuiltinID == Builtin.ID.BIreserve_write_pipe.getValue()) {
          Name = $("__reserve_write_pipe");
        } else if (BuiltinID == Builtin.ID.BIwork_group_reserve_read_pipe.getValue()) {
          Name = $("__work_group_reserve_read_pipe");
        } else if (BuiltinID == Builtin.ID.BIwork_group_reserve_write_pipe.getValue()) {
          Name = $("__work_group_reserve_write_pipe");
        } else if (BuiltinID == Builtin.ID.BIsub_group_reserve_read_pipe.getValue()) {
          Name = $("__sub_group_reserve_read_pipe");
        } else {
          Name = $("__sub_group_reserve_write_pipe");
        }
        
        Value /*P*/ Arg0 = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ Arg1 = $this().EmitScalarExpr(E.getArg$Const(1));
        org.llvm.ir.Type /*P*/ ReservedIDTy = $this().ConvertType($this().getContext().OCLReserveIDTy.$QualType());
        
        // Building the generic function prototype.
        org.llvm.ir.Type /*P*/ ArgTys[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {Arg0.getType(), Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(ReservedIDTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTys, true), false);
        // We know the second argument is an integer type, but we may need to cast
        // it to i32.
        if (Arg1.getType() != Int32Ty) {
          Arg1 = $this().Builder.CreateZExtOrTrunc(Arg1, Int32Ty);
        }
        return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.CreateRuntimeFunction(FTy, new StringRef(Name)), /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Arg0, Arg1}, true)/* }*/));
      }
     case BIcommit_read_pipe:
     case BIcommit_write_pipe:
     case BIwork_group_commit_read_pipe:
     case BIwork_group_commit_write_pipe:
     case BIsub_group_commit_read_pipe:
     case BIsub_group_commit_write_pipe:
      {
        /*const*/char$ptr/*char P*/ Name = create_char$ptr();
        if (BuiltinID == Builtin.ID.BIcommit_read_pipe.getValue()) {
          Name = $("__commit_read_pipe");
        } else if (BuiltinID == Builtin.ID.BIcommit_write_pipe.getValue()) {
          Name = $("__commit_write_pipe");
        } else if (BuiltinID == Builtin.ID.BIwork_group_commit_read_pipe.getValue()) {
          Name = $("__work_group_commit_read_pipe");
        } else if (BuiltinID == Builtin.ID.BIwork_group_commit_write_pipe.getValue()) {
          Name = $("__work_group_commit_write_pipe");
        } else if (BuiltinID == Builtin.ID.BIsub_group_commit_read_pipe.getValue()) {
          Name = $("__sub_group_commit_read_pipe");
        } else {
          Name = $("__sub_group_commit_write_pipe");
        }
        
        Value /*P*/ Arg0 = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ Arg1 = $this().EmitScalarExpr(E.getArg$Const(1));
        
        // Building the generic function prototype.
        org.llvm.ir.Type /*P*/ ArgTys[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {Arg0.getType(), Arg1.getType()};
        org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(org.llvm.ir.Type.getVoidTy($this().getLLVMContext()), 
            new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTys, true), false);
        
        return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.CreateRuntimeFunction(FTy, new StringRef(Name)), /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Arg0, Arg1}, true)/* }*/));
      }
     case BIget_pipe_num_packets:
     case BIget_pipe_max_packets:
      {
        /*const*/char$ptr/*char P*/ Name = create_char$ptr();
        if (BuiltinID == Builtin.ID.BIget_pipe_num_packets.getValue()) {
          Name = $("__get_pipe_num_packets");
        } else {
          Name = $("__get_pipe_max_packets");
        }
        
        // Building the generic function prototype.
        Value /*P*/ Arg0 = $this().EmitScalarExpr(E.getArg$Const(0));
        org.llvm.ir.Type /*P*/ ArgTys[/*1*/] = new org.llvm.ir.Type /*P*/  [/*1*/] {Arg0.getType()};
        org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTys, true), false);
        
        return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.CreateRuntimeFunction(FTy, new StringRef(Name)), /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*1*/] {Arg0}, true)/* }*/));
      }
     case BIto_global:
     case BIto_local:
     case BIto_private:
      {
        Value /*P*/ Arg0 = $this().EmitScalarExpr(E.getArg$Const(0));
        org.llvm.ir.PointerType /*P*/ NewArgT = org.llvm.ir.PointerType.get(Int8Ty, 
            $this().CGM.getContext().getTargetAddressSpace(LangAS.ID.opencl_generic));
        org.llvm.ir.PointerType /*P*/ NewRetT = org.llvm.ir.PointerType.get(Int8Ty, 
            $this().CGM.getContext().getTargetAddressSpace(E.getType().$arrow().getPointeeType().getAddressSpace()));
        org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(NewRetT, /*{ */new ArrayRef<org.llvm.ir.Type /*P*/ >(new org.llvm.ir.Type /*P*/ /*const*/ [/*1*/] {NewArgT}, true)/* }*/, false);
        Value /*P*/ NewArg;
        if (Arg0.getType().getPointerAddressSpace()
           != NewArgT.getPointerAddressSpace()) {
          NewArg = $this().Builder.CreateAddrSpaceCast(Arg0, NewArgT);
        } else {
          NewArg = $this().Builder.CreateBitOrPointerCast(Arg0, NewArgT);
        }
        std.string NewName = $add_string(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"__"), E.getDirectCallee$Const().getName().str());
        CallInst /*P*/ NewCall = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.CreateRuntimeFunction(FTy, new StringRef(NewName)), /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*1*/] {NewArg}, true)/* }*/);
        return RValue.get($this().Builder.CreateBitOrPointerCast(NewCall, 
                $this().ConvertType(E.getType())));
      }
     case BIenqueue_kernel:
      {
        StringRef Name/*J*/= new StringRef(); // Generated function call name
        /*uint*/int NumArgs = E.getNumArgs();
        
        org.llvm.ir.Type /*P*/ QueueTy = $this().ConvertType($this().getContext().OCLQueueTy.$QualType());
        org.llvm.ir.Type /*P*/ RangeTy = $this().ConvertType($this().getContext().OCLNDRangeTy.$QualType());
        
        Value /*P*/ Queue = $this().EmitScalarExpr(E.getArg$Const(0));
        Value /*P*/ Flags = $this().EmitScalarExpr(E.getArg$Const(1));
        Value /*P*/ Range = $this().EmitScalarExpr(E.getArg$Const(2));
        if (NumArgs == 4) {
          // The most basic form of the call with parameters:
          // queue_t, kernel_enqueue_flags_t, ndrange_t, block(void)
          Name.$assignMove(/*STRINGREF_STR*/"__enqueue_kernel_basic");
          org.llvm.ir.Type /*P*/ ArgTys[/*4*/] = new org.llvm.ir.Type /*P*/  [/*4*/] {QueueTy, Int32Ty, RangeTy, Unnamed_field9.Int8PtrTy};
          org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(create_type$ptr(ArgTys), 4, true), false);
          
          Value /*P*/ Block = $this().Builder.CreateBitCast($this().EmitScalarExpr(E.getArg$Const(3)), Unnamed_field9.Int8PtrTy);
          
          return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.CreateRuntimeFunction(FTy, new StringRef(Name)), /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*4*/] {Queue, Flags, Range, Block}, true)/* }*/));
        }
        assert ($greatereq_uint(NumArgs, 5)) : "Invalid enqueue_kernel signature";
        
        // Could have events and/or vaargs.
        if (E.getArg$Const(3).getType().$arrow().isBlockPointerType()) {
          std.vector<Value /*P*/ > Args = null;
          std.vector<org.llvm.ir.Type /*P*/ > ArgTys = null;
          try {
            // No events passed, but has variadic arguments.
            Name.$assignMove(/*STRINGREF_STR*/"__enqueue_kernel_vaargs");
            Value /*P*/ Block = $this().Builder.CreateBitCast($this().EmitScalarExpr(E.getArg$Const(3)), Unnamed_field9.Int8PtrTy);
            // Create a vector of the arguments, as well as a constant value to
            // express to the runtime the number of variadic arguments.
            Args = /*{ */new std.vector<Value /*P*/ >(new Value /*P*/ /*const*/ [/*5*/] {
                  Queue, Flags, Range, Block, 
                  ConstantInt.get(IntTy, $uint2ulong(NumArgs - 4))}, (Value /*P*/ )null)/* }*/;
            ArgTys = /*{ */new std.vector<org.llvm.ir.Type /*P*/ >(new org.llvm.ir.Type /*P*/ /*const*/ [/*5*/] {
                  QueueTy, IntTy, RangeTy, Unnamed_field9.Int8PtrTy, 
                  IntTy}, (org.llvm.ir.Type /*P*/ )null)/* }*/;
            
            // Add the variadics.
            for (/*uint*/int I = 4; $less_uint(I, NumArgs); ++I) {
              Value /*P*/ ArgSize = $this().EmitScalarExpr(E.getArg$Const(I));
              /*uint*/int TypeSizeInBytes = $long2uint($this().getContext().
                  getTypeSizeInChars(E.getArg$Const(I).getType()).
                  getQuantity());
              Args.push_back_T$RR($less_uint(TypeSizeInBytes, 4) ? $this().Builder.CreateZExt(ArgSize, Int32Ty) : ArgSize);
            }
            
            org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTys, true), true);
            return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.CreateRuntimeFunction(FTy, new StringRef(Name)), 
                    new ArrayRef<Value /*P*/ >(Args, true)));
          } finally {
            if (ArgTys != null) { ArgTys.$destroy(); }
            if (Args != null) { Args.$destroy(); }
          }
        }
        // Any calls now have event arguments passed.
        if ($greatereq_uint(NumArgs, 7)) {
          std.vector<org.llvm.ir.Type /*P*/ > ArgTys = null;
          std.vector<Value /*P*/ > Args = null;
          try {
            org.llvm.ir.Type /*P*/ EventTy = $this().ConvertType($this().getContext().OCLClkEventTy.$QualType());
            /*uint*/int AS4 = E.getArg$Const(4).getType().$arrow().isArrayType() ? E.getArg$Const(4).getType().getAddressSpace() : E.getArg$Const(4).getType().$arrow().getPointeeType().getAddressSpace();
            org.llvm.ir.Type /*P*/ EventPtrAS4Ty = EventTy.getPointerTo($this().CGM.getContext().getTargetAddressSpace(AS4));
            /*uint*/int AS5 = E.getArg$Const(5).getType().$arrow().getPointeeType().getAddressSpace();
            org.llvm.ir.Type /*P*/ EventPtrAS5Ty = EventTy.getPointerTo($this().CGM.getContext().getTargetAddressSpace(AS5));
            
            Value /*P*/ NumEvents = $this().EmitScalarExpr(E.getArg$Const(3));
            Value /*P*/ EventList = E.getArg$Const(4).getType().$arrow().isArrayType() ? $this().EmitArrayToPointerDecay(E.getArg$Const(4)).getPointer() : $this().EmitScalarExpr(E.getArg$Const(4));
            Value /*P*/ ClkEvent = $this().EmitScalarExpr(E.getArg$Const(5));
            Value /*P*/ Block = $this().Builder.CreateBitCast($this().EmitScalarExpr(E.getArg$Const(6)), Unnamed_field9.Int8PtrTy);
            
            ArgTys = /*{ */new std.vector<org.llvm.ir.Type /*P*/ >(new org.llvm.ir.Type /*P*/ /*const*/ [/*7*/] {
                  QueueTy, Int32Ty, RangeTy, Int32Ty, 
                  EventPtrAS4Ty, EventPtrAS5Ty, Unnamed_field9.Int8PtrTy}, (org.llvm.ir.Type /*P*/ )null)/* }*/;
            Args = /*{ */new std.vector<Value /*P*/ >(new Value /*P*/ /*const*/ [/*7*/] {
                  Queue, Flags, Range, NumEvents, 
                  EventList, ClkEvent, Block}, 7, (Value /*P*/ )null)/* }*/;
            if (NumArgs == 7) {
              // Has events but no variadics.
              Name.$assignMove(/*STRINGREF_STR*/"__enqueue_kernel_basic_events");
              org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTys, true), false);
              return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.CreateRuntimeFunction(FTy, new StringRef(Name)), 
                      new ArrayRef<Value /*P*/ >(Args, true)));
            }
            // Has event info and variadics
            // Pass the number of variadics to the runtime function too.
            Args.push_back_T$RR(ConstantInt.get(Int32Ty, $uint2ulong(NumArgs - 7)));
            ArgTys.push_back_T$RR(Int32Ty);
            Name.$assignMove(/*STRINGREF_STR*/"__enqueue_kernel_events_vaargs");
            
            // Add the variadics.
            for (/*uint*/int I = 7; $less_uint(I, NumArgs); ++I) {
              Value /*P*/ ArgSize = $this().EmitScalarExpr(E.getArg$Const(I));
              /*uint*/int TypeSizeInBytes = $long2uint($this().getContext().
                  getTypeSizeInChars(E.getArg$Const(I).getType()).
                  getQuantity());
              Args.push_back_T$RR($less_uint(TypeSizeInBytes, 4) ? $this().Builder.CreateZExt(ArgSize, Int32Ty) : ArgSize);
            }
            org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTys, true), true);
            return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.CreateRuntimeFunction(FTy, new StringRef(Name)), 
                    new ArrayRef<Value /*P*/ >(Args, true)));
          } finally {
            if (Args != null) { Args.$destroy(); }
            if (ArgTys != null) { ArgTys.$destroy(); }
          }
        }
      }
     case BIget_kernel_work_group_size:
      {
        Value /*P*/ Arg = $this().EmitScalarExpr(E.getArg$Const(0));
        Arg = $this().Builder.CreateBitCast(Arg, Unnamed_field9.Int8PtrTy);
        return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.CreateRuntimeFunction(org.llvm.ir.FunctionType.get(IntTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(Unnamed_field9.Int8PtrTy, true), false), 
                    new StringRef(/*KEEP_STR*/"__get_kernel_work_group_size_impl")), 
                new ArrayRef<Value /*P*/ >(Arg, true)));
      }
     case BIget_kernel_preferred_work_group_size_multiple:
      {
        Value /*P*/ Arg = $this().EmitScalarExpr(E.getArg$Const(0));
        Arg = $this().Builder.CreateBitCast(Arg, Unnamed_field9.Int8PtrTy);
        return RValue.get($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.CreateRuntimeFunction(org.llvm.ir.FunctionType.get(IntTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(Unnamed_field9.Int8PtrTy, true), false), 
                    new StringRef(/*KEEP_STR*/"__get_kernel_preferred_work_group_multiple_impl")), 
                new ArrayRef<Value /*P*/ >(Arg, true)));
      }
     case BIprintf:
      if ($this().getLangOpts().CUDA && $this().getLangOpts().CUDAIsDevice) {
        return $this().EmitCUDADevicePrintfCallExpr(E, new ReturnValueSlot(ReturnValue));
      }
      break;
     case BI__builtin_canonicalize:
     case BI__builtin_canonicalizef:
     case BI__builtin_canonicalizel:
      return RValue.get(CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.canonicalize));
     case BI__builtin_thread_pointer:
      {
        if (!$this().getContext().getTargetInfo().isTLSSupported()) {
          $this().CGM.ErrorUnsupported(E, $("__builtin_thread_pointer"));
        }
        // Fall through - it's already mapped to the intrinsic by GCCBuiltin.
        break;
      }
    }
    
    // If this is an alias for a lib function (e.g. __builtin_sin), emit
    // the call using the normal call path, but using the unmangled
    // version of the function name.
    if ($this().getContext().BuiltinInfo.isLibFunction(BuiltinID)) {
      return CGBuiltinStatics.emitLibraryCall(/*Deref*/$this(), FD, E, 
          $this().CGM.getBuiltinLibFunction(FD, BuiltinID));
    }
    
    // If this is a predefined lib function (e.g. malloc), emit the call
    // using exactly the normal call path.
    if ($this().getContext().BuiltinInfo.isPredefinedLibFunction(BuiltinID)) {
      return CGBuiltinStatics.emitLibraryCall(/*Deref*/$this(), FD, E, $this().EmitScalarExpr(E.getCallee$Const()));
    }
    
    // Check that a call to a target specific builtin has the correct target
    // features.
    // This is down here to avoid non-target specific builtins, however, if
    // generic builtins start to require generic target features then we
    // can move this up to the beginning of the function.
    $this().checkTargetFeatures(E, FD);
    
    // See if we have a target specific intrinsic.
    /*const*/char$ptr/*char P*/ Name = $tryClone($this().getContext().BuiltinInfo.getName(BuiltinID));
    /*Intrinsic.ID*/int IntrinsicID = ID.not_intrinsic;
    {
      /*const*/char$ptr/*char P*/ Prefix = $tryClone(Triple.getArchTypePrefix($this().getTarget().getTriple().getArch()));
      if (Native.$bool(Prefix)) {
        IntrinsicID = IntrinsicGlobals.getIntrinsicForGCCBuiltin(Prefix, Name);
        // NOTE we dont need to perform a compatibility flag check here since the
        // intrinsics are declared in Builtins*.def via LANGBUILTIN which filter the
        // MS builtins via ALL_MS_LANGUAGES and are filtered earlier.
        if (IntrinsicID == ID.not_intrinsic) {
          IntrinsicID = IntrinsicGlobals.getIntrinsicForMSBuiltin(Prefix, Name);
        }
      }
    }
    if (IntrinsicID != ID.not_intrinsic) {
      SmallVector<Value /*P*/ > Args/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
      
      // Find out if any arguments are required to be integer constant
      // expressions.
      uint$ptr ICEArguments = create_uint$ptr(0);
      type$ref<ASTContext.GetBuiltinTypeError> Error = create_type$ref();
      $this().getContext().GetBuiltinType(BuiltinID, Error, $AddrOf(ICEArguments));
      assert (Error.$deref() == ASTContext.GetBuiltinTypeError.GE_None) : "Should not codegen an error";
      
      Function /*P*/ F = $this().CGM.getIntrinsic(IntrinsicID);
      org.llvm.ir.FunctionType /*P*/ FTy = F.getFunctionType();
      
      for (/*uint*/int i = 0, e = E.getNumArgs(); i != e; ++i) {
        Value /*P*/ ArgValue;
        // If this is a normal argument, just emit it as a scalar.
        if ((ICEArguments.$star() & (1 << i)) == 0) {
          ArgValue = $this().EmitScalarExpr(E.getArg$Const(i));
        } else {
          // If this is required to be a constant, constant fold it so that we
          // know that the generated intrinsic gets a ConstantInt.
          APSInt Result$1/*J*/= new APSInt();
          boolean IsConst = E.getArg$Const(i).isIntegerConstantExpr(Result$1, $this().getContext());
          assert (IsConst) : "Constant arg isn't actually constant?";
          ///*J:(void)*/IsConst;
          ArgValue = ConstantInt.get($this().getLLVMContext(), Result$1);
        }
        
        // If the intrinsic arg type is different from the builtin arg type
        // we need to do a bit cast.
        org.llvm.ir.Type /*P*/ PTy = FTy.getParamType(i);
        if (PTy != ArgValue.getType()) {
          assert (PTy.canLosslesslyBitCastTo(FTy.getParamType(i))) : "Must be able to losslessly bit cast to param";
          ArgValue = $this().Builder.CreateBitCast(ArgValue, PTy);
        }
        
        Args.push_back(ArgValue);
      }
      
      Value /*P*/ V = $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Args, true));
      QualType BuiltinRetType = E.getType();
      
      org.llvm.ir.Type /*P*/ RetTy = VoidTy;
      if (!BuiltinRetType.$arrow().isVoidType()) {
        RetTy = $this().ConvertType(new QualType(BuiltinRetType));
      }
      if (RetTy != V.getType()) {
        assert (V.getType().canLosslesslyBitCastTo(RetTy)) : "Must be able to losslessly bit cast result type";
        V = $this().Builder.CreateBitCast(V, RetTy);
      }
      
      return RValue.get(V);
    }
    {
      
      // See if we have a target specific builtin that needs to be lowered.
      Value /*P*/ V = $this().EmitTargetBuiltinExpr(BuiltinID, E);
      if ((V != null)) {
        return RValue.get(V);
      }
    }
    
    $this().ErrorUnsupported(E, $("builtin function"));
    
    // Unknown builtin, for now just dump it out and return undef.
    return $this().GetUndefRValue(E.getType());
  } finally {
    if (Result != null) { Result.$destroy(); }
  }
}


/// EmitTargetBuiltinExpr - Emit the given builtin call. Returns 0 if the call
/// is unhandled by the current target.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitTargetBuiltinExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 2511,
 FQN="clang::CodeGen::CodeGenFunction::EmitTargetBuiltinExpr", NM="_ZN5clang7CodeGen15CodeGenFunction21EmitTargetBuiltinExprEjPKNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21EmitTargetBuiltinExprEjPKNS_8CallExprE")
//</editor-fold>
public final Value /*P*/ EmitTargetBuiltinExpr(/*uint*/int BuiltinID, 
                     /*const*/ CallExpr /*P*/ E) {
  if ($this().getContext().BuiltinInfo.isAuxBuiltinID(BuiltinID)) {
    assert (($this().getContext().getAuxTargetInfo() != null)) : "Missing aux target info";
    return CGBuiltinStatics.EmitTargetArchBuiltinExpr($this(), $this().getContext().BuiltinInfo.getAuxBuiltinID(BuiltinID), E, 
        $this().getContext().getAuxTargetInfo().getTriple().getArch());
  }
  
  return CGBuiltinStatics.EmitTargetArchBuiltinExpr($this(), BuiltinID, E, 
      $this().getTarget().getTriple().getArch());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAArch64CompareBuiltinExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 3761,
 FQN="clang::CodeGen::CodeGenFunction::EmitAArch64CompareBuiltinExpr", NM="_ZN5clang7CodeGen15CodeGenFunction29EmitAArch64CompareBuiltinExprEPN4llvm5ValueEPNS2_4TypeENS2_7CmpInst9PredicateES8_RKNS2_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction29EmitAArch64CompareBuiltinExprEPN4llvm5ValueEPNS2_4TypeENS2_7CmpInst9PredicateES8_RKNS2_5TwineE")
//</editor-fold>
public final Value /*P*/ EmitAArch64CompareBuiltinExpr(Value /*P*/ Op, org.llvm.ir.Type /*P*/ Ty, /*const*/ CmpInst.Predicate Fp, 
                             /*const*/ CmpInst.Predicate Ip) {
  return EmitAArch64CompareBuiltinExpr(Op, Ty, Fp, 
                             Ip, new Twine(/*KEEP_STR*/$EMPTY));
}
public final Value /*P*/ EmitAArch64CompareBuiltinExpr(Value /*P*/ Op, org.llvm.ir.Type /*P*/ Ty, /*const*/ CmpInst.Predicate Fp, 
                             /*const*/ CmpInst.Predicate Ip, final /*const*/ Twine /*&*/ Name/*= ""*/) {
  org.llvm.ir.Type /*P*/ OTy = Op.getType();
  {
    
    // FIXME: this is utterly horrific. We should not be looking at previous
    // codegen context to find out what needs doing. Unfortunately TableGen
    // currently gives us exactly the same calls for vceqz_f32 and vceqz_s32
    // (etc).
    BitCastInst /*P*/ BI = IrRTTI.dyn_cast_BitCastInst(Op);
    if ((BI != null)) {
      OTy = BI.getOperand(0).getType();
    }
  }
  
  Op = $this().Builder.CreateBitCast(Op, OTy);
  if (OTy.getScalarType().isFloatingPointTy()) {
    Op = $this().Builder.CreateFCmp(Fp, Op, Constant.getNullValue(OTy));
  } else {
    Op = $this().Builder.CreateICmp(Ip, Op, Constant.getNullValue(OTy));
  }
  return $this().Builder.CreateSExt(Op, Ty, Name);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARMBuiltinExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 3955,
 FQN="clang::CodeGen::CodeGenFunction::EmitARMBuiltinExpr", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitARMBuiltinExprEjPKNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitARMBuiltinExprEjPKNS_8CallExprE")
//</editor-fold>
public final Value /*P*/ EmitARMBuiltinExpr(/*uint*/int BuiltinID, 
                  /*const*/ CallExpr /*P*/ E) {
  {
    Value /*P*/ Hint = $this().GetValueForARMHint(BuiltinID);
    if ((Hint != null)) {
      return Hint;
    }
  }
  if (BuiltinID == ARM.BI__emit) {
    boolean IsThumb = $this().getTarget().getTriple().getArch() == Triple.ArchType.thumb;
    org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(VoidTy, /*Variadic=*/ false);
    
    APSInt Value/*J*/= new APSInt();
    if (!E.getArg$Const(0).EvaluateAsInt(Value, $this().CGM.getContext())) {
      throw new llvm_unreachable("Sema will ensure that the parameter is constant");
    }
    
    long/*uint64_t*/ ZExtValue = Value.zextOrTrunc(IsThumb ? 16 : 32).getZExtValue();
    
    InlineAsm /*P*/ Emit = IsThumb ? InlineAsm.get(FTy, new StringRef($add_T$C$P_string(/*KEEP_STR*/".inst.n 0x", utohexstr(ZExtValue))), new StringRef(/*KEEP_STR*/$EMPTY), 
        /*SideEffects=*/ true) : InlineAsm.get(FTy, new StringRef($add_T$C$P_string(/*KEEP_STR*/".inst 0x", utohexstr(ZExtValue))), new StringRef(/*KEEP_STR*/$EMPTY), 
        /*SideEffects=*/ true);
    
    return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(Emit);
  }
  if (BuiltinID == ARM.BI__builtin_arm_dbg) {
    Value /*P*/ Option = $this().EmitScalarExpr(E.getArg$Const(0));
    return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.arm_dbg), new ArrayRef<Value /*P*/ >(Option, true));
  }
  if (BuiltinID == ARM.BI__builtin_arm_prefetch) {
    Value /*P*/ Address = $this().EmitScalarExpr(E.getArg$Const(0));
    Value /*P*/ RW = $this().EmitScalarExpr(E.getArg$Const(1));
    Value /*P*/ IsData = $this().EmitScalarExpr(E.getArg$Const(2));
    
    // Locality is not supported on ARM target
    Value /*P*/ Locality = ConstantInt.get(Int32Ty, $int2ulong(3));
    
    Value /*P*/ F = $this().CGM.getIntrinsic(ID.prefetch);
    return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*4*/] {Address, RW, Locality, IsData}, true)/* }*/);
  }
  if (BuiltinID == ARM.BI__builtin_arm_rbit) {
    return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.arm_rbit), 
        new ArrayRef<Value /*P*/ >($this().EmitScalarExpr(E.getArg$Const(0)), true), 
        new Twine(/*KEEP_STR*/"rbit"));
  }
  if (BuiltinID == ARM.BI__clear_cache) {
    assert (E.getNumArgs() == 2) : "__clear_cache takes 2 arguments";
    /*const*/ FunctionDecl /*P*/ FD = E.getDirectCallee$Const();
    Value /*P*/ Ops[/*2*/] = new Value /*P*/  [2];
    for (/*uint*/int i = 0; $less_uint(i, 2); i++)  {
      Ops[i] = $this().EmitScalarExpr(E.getArg$Const(i));
    }
    org.llvm.ir.Type /*P*/ Ty = $this().CGM.getTypes().ConvertType(FD.getType());
    org.llvm.ir.FunctionType /*P*/ FTy = IrRTTI.cast_FunctionType(Ty);
    StringRef Name = FD.getName();
    return $this().EmitNounwindRuntimeCall($this().CGM.CreateRuntimeFunction(FTy, new StringRef(Name)), new ArrayRef<Value /*P*/ >(Ops, true));
  }
  if (BuiltinID == ARM.BI__builtin_arm_mcrr
     || BuiltinID == ARM.BI__builtin_arm_mcrr2) {
    Function /*P*/ F;
    switch (BuiltinID) {
     default:
      throw new llvm_unreachable("unexpected builtin");
     case ARM.BI__builtin_arm_mcrr:
      F = $this().CGM.getIntrinsic(ID.arm_mcrr);
      break;
     case ARM.BI__builtin_arm_mcrr2:
      F = $this().CGM.getIntrinsic(ID.arm_mcrr2);
      break;
    }
    
    // MCRR{2} instruction has 5 operands but
    // the intrinsic has 4 because Rt and Rt2
    // are represented as a single unsigned 64
    // bit integer in the intrinsic definition
    // but internally it's represented as 2 32
    // bit integers.
    Value /*P*/ Coproc = $this().EmitScalarExpr(E.getArg$Const(0));
    Value /*P*/ Opc1 = $this().EmitScalarExpr(E.getArg$Const(1));
    Value /*P*/ RtAndRt2 = $this().EmitScalarExpr(E.getArg$Const(2));
    Value /*P*/ CRm = $this().EmitScalarExpr(E.getArg$Const(3));
    
    Value /*P*/ C1 = ConstantInt.get(Int64Ty, $int2ulong(32));
    Value /*P*/ Rt = $this().Builder.CreateTruncOrBitCast(RtAndRt2, Int32Ty);
    Value /*P*/ Rt2 = $this().Builder.CreateLShr(RtAndRt2, C1);
    Rt2 = $this().Builder.CreateTruncOrBitCast(Rt2, Int32Ty);
    
    return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*5*/] {Coproc, Opc1, Rt, Rt2, CRm}, true)/* }*/);
  }
  if (BuiltinID == ARM.BI__builtin_arm_mrrc
     || BuiltinID == ARM.BI__builtin_arm_mrrc2) {
    Function /*P*/ F;
    switch (BuiltinID) {
     default:
      throw new llvm_unreachable("unexpected builtin");
     case ARM.BI__builtin_arm_mrrc:
      F = $this().CGM.getIntrinsic(ID.arm_mrrc);
      break;
     case ARM.BI__builtin_arm_mrrc2:
      F = $this().CGM.getIntrinsic(ID.arm_mrrc2);
      break;
    }
    
    Value /*P*/ Coproc = $this().EmitScalarExpr(E.getArg$Const(0));
    Value /*P*/ Opc1 = $this().EmitScalarExpr(E.getArg$Const(1));
    Value /*P*/ CRm = $this().EmitScalarExpr(E.getArg$Const(2));
    Value /*P*/ RtAndRt2 = $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {Coproc, Opc1, CRm}, true)/* }*/);
    
    // Returns an unsigned 64 bit integer, represented
    // as two 32 bit integers.
    Value /*P*/ Rt = $this().Builder.CreateExtractValue(RtAndRt2, new ArrayRefUInt(1));
    Value /*P*/ Rt1 = $this().Builder.CreateExtractValue(RtAndRt2, new ArrayRefUInt(0));
    Rt = $this().Builder.CreateZExt(Rt, Int64Ty);
    Rt1 = $this().Builder.CreateZExt(Rt1, Int64Ty);
    
    Value /*P*/ ShiftCast = ConstantInt.get(Int64Ty, $int2ulong(32));
    RtAndRt2 = $this().Builder.CreateShl(Rt, ShiftCast, new Twine(/*KEEP_STR*/"shl"), true);
    RtAndRt2 = $this().Builder.CreateOr(RtAndRt2, Rt1);
    
    return $this().Builder.CreateBitCast(RtAndRt2, $this().ConvertType(E.getType()));
  }
  if (BuiltinID == ARM.BI__builtin_arm_ldrexd
     || ((BuiltinID == ARM.BI__builtin_arm_ldrex
     || BuiltinID == ARM.BI__builtin_arm_ldaex)
     && $this().getContext().getTypeSize(E.getType()) == $int2ullong(64))
     || BuiltinID == ARM.BI__ldrexd) {
    Function /*P*/ F;
    switch (BuiltinID) {
     default:
      throw new llvm_unreachable("unexpected builtin");
     case ARM.BI__builtin_arm_ldaex:
      F = $this().CGM.getIntrinsic(ID.arm_ldaexd);
      break;
     case ARM.BI__builtin_arm_ldrexd:
     case ARM.BI__builtin_arm_ldrex:
     case ARM.BI__ldrexd:
      F = $this().CGM.getIntrinsic(ID.arm_ldrexd);
      break;
    }
    
    Value /*P*/ LdPtr = $this().EmitScalarExpr(E.getArg$Const(0));
    Value /*P*/ Val = $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >($this().Builder.CreateBitCast(LdPtr, Unnamed_field9.Int8PtrTy), true), 
        new Twine(/*KEEP_STR*/"ldrexd"));
    
    Value /*P*/ Val0 = $this().Builder.CreateExtractValue(Val, new ArrayRefUInt(1));
    Value /*P*/ Val1 = $this().Builder.CreateExtractValue(Val, new ArrayRefUInt(0));
    Val0 = $this().Builder.CreateZExt(Val0, Int64Ty);
    Val1 = $this().Builder.CreateZExt(Val1, Int64Ty);
    
    Value /*P*/ ShiftCst = ConstantInt.get(Int64Ty, $int2ulong(32));
    Val = $this().Builder.CreateShl(Val0, ShiftCst, new Twine(/*KEEP_STR*/"shl"), true/* nuw */);
    Val = $this().Builder.CreateOr(Val, Val1);
    return $this().Builder.CreateBitCast(Val, $this().ConvertType(E.getType()));
  }
  if (BuiltinID == ARM.BI__builtin_arm_ldrex
     || BuiltinID == ARM.BI__builtin_arm_ldaex) {
    Value /*P*/ LoadAddr = $this().EmitScalarExpr(E.getArg$Const(0));
    
    QualType Ty = E.getType();
    org.llvm.ir.Type /*P*/ RealResTy = $this().ConvertType(new QualType(Ty));
    org.llvm.ir.Type /*P*/ IntResTy = IntegerType.get($this().getLLVMContext(), 
        $ulong2uint($this().getContext().getTypeSize(new QualType(Ty))));
    LoadAddr = $this().Builder.CreateBitCast(LoadAddr, IntResTy.getPointerTo());
    
    Function /*P*/ F = $this().CGM.getIntrinsic(BuiltinID == ARM.BI__builtin_arm_ldaex ? ID.arm_ldaex : ID.arm_ldrex, 
        new ArrayRef<org.llvm.ir.Type /*P*/ >(LoadAddr.getType(), true));
    Value /*P*/ Val = $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(LoadAddr, true), new Twine(/*KEEP_STR*/"ldrex"));
    if (RealResTy.isPointerTy()) {
      return $this().Builder.CreateIntToPtr(Val, RealResTy);
    } else {
      Val = $this().Builder.CreateTruncOrBitCast(Val, IntResTy);
      return $this().Builder.CreateBitCast(Val, RealResTy);
    }
  }
  if (BuiltinID == ARM.BI__builtin_arm_strexd
     || ((BuiltinID == ARM.BI__builtin_arm_stlex
     || BuiltinID == ARM.BI__builtin_arm_strex)
     && $this().getContext().getTypeSize(E.getArg$Const(0).getType()) == $int2ullong(64))) {
    Function /*P*/ F = $this().CGM.getIntrinsic(BuiltinID == ARM.BI__builtin_arm_stlex ? ID.arm_stlexd : ID.arm_strexd);
    org.llvm.ir.Type /*P*/ STy = StructType.get(Int32Ty, Int32Ty, null);
    
    Address Tmp = $this().CreateMemTemp(E.getArg$Const(0).getType());
    Value /*P*/ Val = $this().EmitScalarExpr(E.getArg$Const(0));
    $this().Builder.CreateStore(Val, new Address(Tmp));
    
    Address LdPtr = $this().Builder.CreateBitCast(new Address(Tmp), org.llvm.ir.PointerType.getUnqual(STy));
    Val = $this().Builder.CreateLoad(new Address(LdPtr));
    
    Value /*P*/ Arg0 = $this().Builder.CreateExtractValue(Val, new ArrayRefUInt(0));
    Value /*P*/ Arg1 = $this().Builder.CreateExtractValue(Val, new ArrayRefUInt(1));
    Value /*P*/ StPtr = $this().Builder.CreateBitCast($this().EmitScalarExpr(E.getArg$Const(1)), Unnamed_field9.Int8PtrTy);
    return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {Arg0, Arg1, StPtr}, true)/* }*/, new Twine(/*KEEP_STR*/"strexd"));
  }
  if (BuiltinID == ARM.BI__builtin_arm_strex
     || BuiltinID == ARM.BI__builtin_arm_stlex) {
    Value /*P*/ StoreVal = $this().EmitScalarExpr(E.getArg$Const(0));
    Value /*P*/ StoreAddr = $this().EmitScalarExpr(E.getArg$Const(1));
    
    QualType Ty = E.getArg$Const(0).getType();
    org.llvm.ir.Type /*P*/ StoreTy = IntegerType.get($this().getLLVMContext(), 
        $ulong2uint($this().getContext().getTypeSize(new QualType(Ty))));
    StoreAddr = $this().Builder.CreateBitCast(StoreAddr, StoreTy.getPointerTo());
    if (StoreVal.getType().isPointerTy()) {
      StoreVal = $this().Builder.CreatePtrToInt(StoreVal, Int32Ty);
    } else {
      StoreVal = $this().Builder.CreateBitCast(StoreVal, StoreTy);
      StoreVal = $this().Builder.CreateZExtOrBitCast(StoreVal, Int32Ty);
    }
    
    Function /*P*/ F = $this().CGM.getIntrinsic(BuiltinID == ARM.BI__builtin_arm_stlex ? ID.arm_stlex : ID.arm_strex, 
        new ArrayRef<org.llvm.ir.Type /*P*/ >(StoreAddr.getType(), true));
    return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {StoreVal, StoreAddr}, true)/* }*/, new Twine(/*KEEP_STR*/"strex"));
  }
  if (BuiltinID == ARM.BI__builtin_arm_clrex) {
    Function /*P*/ F = $this().CGM.getIntrinsic(ID.arm_clrex);
    return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F);
  }
  
  // CRC32
  /*Intrinsic.ID*/int CRCIntrinsicID = ID.not_intrinsic;
  switch (BuiltinID) {
   case ARM.BI__builtin_arm_crc32b:
    CRCIntrinsicID = ID.arm_crc32b;
    break;
   case ARM.BI__builtin_arm_crc32cb:
    CRCIntrinsicID = ID.arm_crc32cb;
    break;
   case ARM.BI__builtin_arm_crc32h:
    CRCIntrinsicID = ID.arm_crc32h;
    break;
   case ARM.BI__builtin_arm_crc32ch:
    CRCIntrinsicID = ID.arm_crc32ch;
    break;
   case ARM.BI__builtin_arm_crc32w:
   case ARM.BI__builtin_arm_crc32d:
    CRCIntrinsicID = ID.arm_crc32w;
    break;
   case ARM.BI__builtin_arm_crc32cw:
   case ARM.BI__builtin_arm_crc32cd:
    CRCIntrinsicID = ID.arm_crc32cw;
    break;
  }
  if (CRCIntrinsicID != ID.not_intrinsic) {
    Value /*P*/ Arg0 = $this().EmitScalarExpr(E.getArg$Const(0));
    Value /*P*/ Arg1 = $this().EmitScalarExpr(E.getArg$Const(1));
    
    // crc32{c,}d intrinsics are implemnted as two calls to crc32{c,}w
    // intrinsics, hence we need different codegen for these cases.
    if (BuiltinID == ARM.BI__builtin_arm_crc32d
       || BuiltinID == ARM.BI__builtin_arm_crc32cd) {
      Value /*P*/ C1 = ConstantInt.get(Int64Ty, $int2ulong(32));
      Value /*P*/ Arg1a = $this().Builder.CreateTruncOrBitCast(Arg1, Int32Ty);
      Value /*P*/ Arg1b = $this().Builder.CreateLShr(Arg1, C1);
      Arg1b = $this().Builder.CreateTruncOrBitCast(Arg1b, Int32Ty);
      
      Function /*P*/ F = $this().CGM.getIntrinsic(CRCIntrinsicID);
      Value /*P*/ Res = $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Arg0, Arg1a}, true)/* }*/);
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Res, Arg1b}, true)/* }*/);
    } else {
      Arg1 = $this().Builder.CreateZExtOrBitCast(Arg1, Int32Ty);
      
      Function /*P*/ F = $this().CGM.getIntrinsic(CRCIntrinsicID);
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Arg0, Arg1}, true)/* }*/);
    }
  }
  if (BuiltinID == ARM.BI__builtin_arm_rsr
     || BuiltinID == ARM.BI__builtin_arm_rsr64
     || BuiltinID == ARM.BI__builtin_arm_rsrp
     || BuiltinID == ARM.BI__builtin_arm_wsr
     || BuiltinID == ARM.BI__builtin_arm_wsr64
     || BuiltinID == ARM.BI__builtin_arm_wsrp) {
    
    boolean IsRead = BuiltinID == ARM.BI__builtin_arm_rsr
       || BuiltinID == ARM.BI__builtin_arm_rsr64
       || BuiltinID == ARM.BI__builtin_arm_rsrp;
    
    boolean IsPointerBuiltin = BuiltinID == ARM.BI__builtin_arm_rsrp
       || BuiltinID == ARM.BI__builtin_arm_wsrp;
    
    boolean Is64Bit = BuiltinID == ARM.BI__builtin_arm_rsr64
       || BuiltinID == ARM.BI__builtin_arm_wsr64;
    
    org.llvm.ir.Type /*P*/ ValueType;
    org.llvm.ir.Type /*P*/ RegisterType;
    if (IsPointerBuiltin) {
      ValueType = Unnamed_field9.VoidPtrTy;
      RegisterType = Int32Ty;
    } else if (Is64Bit) {
      ValueType = RegisterType = Int64Ty;
    } else {
      ValueType = RegisterType = Int32Ty;
    }
    
    return CGBuiltinStatics.EmitSpecialRegisterBuiltin(/*Deref*/$this(), E, RegisterType, ValueType, IsRead);
  }
  
  // Find out if any arguments are required to be integer constant
  // expressions.
  uint$ptr ICEArguments = create_uint$ptr(0);
  type$ref<ASTContext.GetBuiltinTypeError> Error = create_type$ref();
  $this().getContext().GetBuiltinType(BuiltinID, Error, $AddrOf(ICEArguments));
  assert (Error.$deref() == ASTContext.GetBuiltinTypeError.GE_None) : "Should not codegen an error";
  
  Address2Value getAlignmentValue32 = /*[&, this]*/ (Address addr) -> {
        return $this().Builder.getInt32($long2uint(addr.getAlignment().getQuantity()));
      };
  
  Address PtrOp0 = Address.invalid();
  Address PtrOp1 = Address.invalid();
  SmallVector<Value /*P*/ > Ops/*J*/= new SmallVector<Value /*P*/ >(4, (Value /*P*/ )null);
  boolean HasExtraArg = CGBuiltinStatics.HasExtraNeonArgument(BuiltinID);
  /*uint*/int NumArgs = E.getNumArgs() - (HasExtraArg ? 1 : 0);
  for (/*uint*/int i = 0, e = NumArgs; i != e; i++) {
    if (i == 0) {
      switch (BuiltinID) {
       case NEON.BI__builtin_neon_vld1_v:
       case NEON.BI__builtin_neon_vld1q_v:
       case NEON.BI__builtin_neon_vld1q_lane_v:
       case NEON.BI__builtin_neon_vld1_lane_v:
       case NEON.BI__builtin_neon_vld1_dup_v:
       case NEON.BI__builtin_neon_vld1q_dup_v:
       case NEON.BI__builtin_neon_vst1_v:
       case NEON.BI__builtin_neon_vst1q_v:
       case NEON.BI__builtin_neon_vst1q_lane_v:
       case NEON.BI__builtin_neon_vst1_lane_v:
       case NEON.BI__builtin_neon_vst2_v:
       case NEON.BI__builtin_neon_vst2q_v:
       case NEON.BI__builtin_neon_vst2_lane_v:
       case NEON.BI__builtin_neon_vst2q_lane_v:
       case NEON.BI__builtin_neon_vst3_v:
       case NEON.BI__builtin_neon_vst3q_v:
       case NEON.BI__builtin_neon_vst3_lane_v:
       case NEON.BI__builtin_neon_vst3q_lane_v:
       case NEON.BI__builtin_neon_vst4_v:
       case NEON.BI__builtin_neon_vst4q_v:
       case NEON.BI__builtin_neon_vst4_lane_v:
       case NEON.BI__builtin_neon_vst4q_lane_v:
        // Get the alignment for the argument in addition to the value;
        // we'll use it later.
        PtrOp0.$assignMove($this().EmitPointerWithAlignment(E.getArg$Const(0)));
        Ops.push_back(PtrOp0.getPointer());
        continue;
      }
    }
    if (i == 1) {
      switch (BuiltinID) {
       case NEON.BI__builtin_neon_vld2_v:
       case NEON.BI__builtin_neon_vld2q_v:
       case NEON.BI__builtin_neon_vld3_v:
       case NEON.BI__builtin_neon_vld3q_v:
       case NEON.BI__builtin_neon_vld4_v:
       case NEON.BI__builtin_neon_vld4q_v:
       case NEON.BI__builtin_neon_vld2_lane_v:
       case NEON.BI__builtin_neon_vld2q_lane_v:
       case NEON.BI__builtin_neon_vld3_lane_v:
       case NEON.BI__builtin_neon_vld3q_lane_v:
       case NEON.BI__builtin_neon_vld4_lane_v:
       case NEON.BI__builtin_neon_vld4q_lane_v:
       case NEON.BI__builtin_neon_vld2_dup_v:
       case NEON.BI__builtin_neon_vld3_dup_v:
       case NEON.BI__builtin_neon_vld4_dup_v:
        // Get the alignment for the argument in addition to the value;
        // we'll use it later.
        PtrOp1.$assignMove($this().EmitPointerWithAlignment(E.getArg$Const(1)));
        Ops.push_back(PtrOp1.getPointer());
        continue;
      }
    }
    if ((ICEArguments.$star() & (1 << i)) == 0) {
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(i)));
    } else {
      // If this is required to be a constant, constant fold it so that we know
      // that the generated intrinsic gets a ConstantInt.
      APSInt Result/*J*/= new APSInt();
      boolean IsConst = E.getArg$Const(i).isIntegerConstantExpr(Result, $this().getContext());
      assert (IsConst) : "Constant arg isn't actually constant?";
      ///*J:(void)*/IsConst;
      Ops.push_back(ConstantInt.get($this().getLLVMContext(), Result));
    }
  }
  switch (BuiltinID) {
   default:
    break;
   case NEON.BI__builtin_neon_vget_lane_i8:
   case NEON.BI__builtin_neon_vget_lane_i16:
   case NEON.BI__builtin_neon_vget_lane_i32:
   case NEON.BI__builtin_neon_vget_lane_i64:
   case NEON.BI__builtin_neon_vget_lane_f32:
   case NEON.BI__builtin_neon_vgetq_lane_i8:
   case NEON.BI__builtin_neon_vgetq_lane_i16:
   case NEON.BI__builtin_neon_vgetq_lane_i32:
   case NEON.BI__builtin_neon_vgetq_lane_i64:
   case NEON.BI__builtin_neon_vgetq_lane_f32:
    return $this().Builder.CreateExtractElement(Ops.$at(0), Ops.$at(1), new Twine(/*KEEP_STR*/"vget_lane"));
   case NEON.BI__builtin_neon_vset_lane_i8:
   case NEON.BI__builtin_neon_vset_lane_i16:
   case NEON.BI__builtin_neon_vset_lane_i32:
   case NEON.BI__builtin_neon_vset_lane_i64:
   case NEON.BI__builtin_neon_vset_lane_f32:
   case NEON.BI__builtin_neon_vsetq_lane_i8:
   case NEON.BI__builtin_neon_vsetq_lane_i16:
   case NEON.BI__builtin_neon_vsetq_lane_i32:
   case NEON.BI__builtin_neon_vsetq_lane_i64:
   case NEON.BI__builtin_neon_vsetq_lane_f32:
    return $this().Builder.CreateInsertElement(Ops.$at(1), Ops.$at(0), Ops.$at(2), new Twine(/*KEEP_STR*/"vset_lane"));
   case NEON.BI__builtin_neon_vsha1h_u32:
    return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.arm_neon_sha1h), Ops, 
        $("vsha1h"));
   case NEON.BI__builtin_neon_vsha1cq_u32:
    return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.arm_neon_sha1c), Ops, 
        $("vsha1h"));
   case NEON.BI__builtin_neon_vsha1pq_u32:
    return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.arm_neon_sha1p), Ops, 
        $("vsha1h"));
   case NEON.BI__builtin_neon_vsha1mq_u32:
    return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.arm_neon_sha1m), Ops, 
        $("vsha1h"));
   case ARM.BI_MoveToCoprocessor:
   case ARM.BI_MoveToCoprocessor2:
    {
      Function /*P*/ F = $this().CGM.getIntrinsic(BuiltinID == ARM.BI_MoveToCoprocessor ? ID.arm_mcr : ID.arm_mcr2);
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*6*/] {
                Ops.$at(1), Ops.$at(2), Ops.$at(0), 
                Ops.$at(3), Ops.$at(4), Ops.$at(5)}, true)/* }*/);
    }
  }
  
  // Get the last argument, which specifies the vector type.
  assert (HasExtraArg);
  APSInt Result/*J*/= new APSInt();
  /*const*/ Expr /*P*/ Arg = E.getArg$Const(E.getNumArgs() - 1);
  if (!Arg.isIntegerConstantExpr(Result, $this().getContext())) {
    return null;
  }
  if (BuiltinID == ARM.BI__builtin_arm_vcvtr_f
     || BuiltinID == ARM.BI__builtin_arm_vcvtr_d) {
    // Determine the overloaded type of this builtin.
    org.llvm.ir.Type /*P*/ Ty;
    if (BuiltinID == ARM.BI__builtin_arm_vcvtr_f) {
      Ty = FloatTy;
    } else {
      Ty = DoubleTy;
    }
    
    // Determine whether this is an unsigned conversion or not.
    boolean usgn = Result.getZExtValue() == $int2ullong(1);
    /*uint*/int Int = usgn ? ID.arm_vcvtru : ID.arm_vcvtr;
    
    // Call the appropriate intrinsic.
    Function /*P*/ F = $this().CGM.getIntrinsic(Int, new ArrayRef<org.llvm.ir.Type /*P*/ >(Ty, true));
    return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Ops, true), new Twine(/*KEEP_STR*/"vcvtr"));
  }
  
  // Determine the type of this overloaded NEON intrinsic.
  NeonTypeFlags Type/*J*/= new NeonTypeFlags($ulong2uint(Result.getZExtValue()));
  boolean usgn = Type.isUnsigned();
  boolean rightShift = false;
  
  org.llvm.ir.VectorType /*P*/ VTy = CGBuiltinStatics.GetNeonType($this(), new NeonTypeFlags(Type));
  org.llvm.ir.Type /*P*/ Ty = VTy;
  if (!(Ty != null)) {
    return null;
  }
  
  // Many NEON builtins have identical semantics and uses in ARM and
  // AArch64. Emit these in a single function.
  ArrayRef<NeonIntrinsicInfo> IntrinsicMap = makeArrayRef(214, CGBuiltinStatics.ARMSIMDIntrinsicMap, false);
  /*const*/ NeonIntrinsicInfo /*P*/ Builtin = CGBuiltinStatics.findNeonIntrinsicInMap(new ArrayRef<NeonIntrinsicInfo>(IntrinsicMap), BuiltinID, CGBuiltinStatics.NEONSIMDIntrinsicsProvenSorted_ref);
  if ((Builtin != null)) {
    return $this().EmitCommonNeonBuiltinExpr(Builtin.BuiltinID, Builtin.LLVMIntrinsic, Builtin.AltLLVMIntrinsic, 
        Builtin.NameHint, Builtin.TypeModifier, E, Ops, new Address(PtrOp0), new Address(PtrOp1));
  }
  
  /*uint*/int Int;
  switch (BuiltinID) {
   default:
    return null;
   case NEON.BI__builtin_neon_vld1q_lane_v:
    // Handle 64-bit integer elements as a special case.  Use shuffles of
    // one-element vectors to avoid poor code for i64 in the backend.
    if (VTy.getElementType().isIntegerTy(64)) {
      // Extract the other lane.
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
      /*uint32_t*/int Lane = $ulong2uint(IrRTTI.cast_ConstantInt(Ops.$at(2)).getZExtValue());
      Value /*P*/ SV = ConstantVector.get(new ArrayRef<Constant /*P*/ >(ConstantInt.get(Int32Ty, $uint2ulong(1 - Lane)), true));
      Ops.$set(1, $this().Builder.CreateShuffleVector(Ops.$at(1), Ops.$at(1), SV));
      // Load the value as a one-element vector.
      Ty = org.llvm.ir.VectorType.get(VTy.getElementType(), 1);
      org.llvm.ir.Type /*P*/ Tys[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {Ty, Unnamed_field9.Int8PtrTy};
      Function /*P*/ F = $this().CGM.getIntrinsic(ID.arm_neon_vld1, new ArrayRef<org.llvm.ir.Type /*P*/ >(Tys, true));
      Value /*P*/ Align = getAlignmentValue32.$call(new Address(PtrOp0));
      Value /*P*/ Ld = $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Ops.$at(0), Align}, true)/* }*/);
      // Combine them.
      /*uint32_t*/int Indices[/*2*/] = new$uint(2, 1 - Lane, Lane);
      SV = ConstantDataVector.get_LLVMContext_ArrayRefUInt($this().getLLVMContext(), new ArrayRefUInt(Indices));
      return $this().Builder.CreateShuffleVector(Ops.$at(1), Ld, SV, new Twine(/*KEEP_STR*/"vld1q_lane"));
    }
   case NEON.BI__builtin_neon_vld1_lane_v:
    {
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
      PtrOp0.$assignMove($this().Builder.CreateElementBitCast(new Address(PtrOp0), VTy.getElementType()));
      Value /*P*/ Ld = $this().Builder.CreateLoad(new Address(PtrOp0));
      return $this().Builder.CreateInsertElement(Ops.$at(1), Ld, Ops.$at(2), new Twine(/*KEEP_STR*/"vld1_lane"));
    }
   case NEON.BI__builtin_neon_vld2_dup_v:
   case NEON.BI__builtin_neon_vld3_dup_v:
   case NEON.BI__builtin_neon_vld4_dup_v:
    {
      // Handle 64-bit elements as a special-case.  There is no "dup" needed.
      if (VTy.getElementType().getPrimitiveSizeInBits() == 64) {
        switch (BuiltinID) {
         case NEON.BI__builtin_neon_vld2_dup_v:
          Int = ID.arm_neon_vld2;
          break;
         case NEON.BI__builtin_neon_vld3_dup_v:
          Int = ID.arm_neon_vld3;
          break;
         case NEON.BI__builtin_neon_vld4_dup_v:
          Int = ID.arm_neon_vld4;
          break;
         default:
          throw new llvm_unreachable("unknown vld_dup intrinsic?");
        }
        org.llvm.ir.Type /*P*/ Tys[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {Ty, Unnamed_field9.Int8PtrTy};
        Function /*P*/ F = $this().CGM.getIntrinsic(Int, new ArrayRef<org.llvm.ir.Type /*P*/ >(Tys, true));
        Value /*P*/ Align = getAlignmentValue32.$call(new Address(PtrOp1));
        Ops.$set(1, $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Ops.$at(1), Align}, true)/* }*/, new Twine(/*KEEP_STR*/"vld_dup")));
        Ty = org.llvm.ir.PointerType.getUnqual(Ops.$at(1).getType());
        Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
        return $this().Builder.CreateDefaultAlignedStore(Ops.$at(1), Ops.$at(0));
      }
      switch (BuiltinID) {
       case NEON.BI__builtin_neon_vld2_dup_v:
        Int = ID.arm_neon_vld2lane;
        break;
       case NEON.BI__builtin_neon_vld3_dup_v:
        Int = ID.arm_neon_vld3lane;
        break;
       case NEON.BI__builtin_neon_vld4_dup_v:
        Int = ID.arm_neon_vld4lane;
        break;
       default:
        throw new llvm_unreachable("unknown vld_dup intrinsic?");
      }
      org.llvm.ir.Type /*P*/ Tys[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {Ty, Unnamed_field9.Int8PtrTy};
      Function /*P*/ F = $this().CGM.getIntrinsic(Int, new ArrayRef<org.llvm.ir.Type /*P*/ >(Tys, true));
      StructType /*P*/ STy = IrRTTI.cast_StructType(F.getReturnType());
      
      SmallVector<Value /*P*/ > Args/*J*/= new SmallVector<Value /*P*/ >(6, (Value /*P*/ )null);
      Args.push_back(Ops.$at(1));
      Args.append(STy.getNumElements(), UndefValue.get(Ty));
      
      Constant /*P*/ CI = ConstantInt.get(Int32Ty, $int2ulong(0));
      Args.push_back(CI);
      Args.push_back(getAlignmentValue32.$call(new Address(PtrOp1)));
      
      Ops.$set(1, $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Args, true), new Twine(/*KEEP_STR*/"vld_dup")));
      // splat lane 0 to all elts in each vector of the result.
      for (/*uint*/int i = 0, e = STy.getNumElements(); i != e; ++i) {
        Value /*P*/ Val = $this().Builder.CreateExtractValue(Ops.$at(1), new ArrayRefUInt(i));
        Value /*P*/ Elt = $this().Builder.CreateBitCast(Val, Ty);
        Elt = $this().EmitNeonSplat(Elt, CI);
        Elt = $this().Builder.CreateBitCast(Elt, Val.getType());
        Ops.$set(1, $this().Builder.CreateInsertValue(Ops.$at(1), Elt, new ArrayRefUInt(i)));
      }
      Ty = org.llvm.ir.PointerType.getUnqual(Ops.$at(1).getType());
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
      return $this().Builder.CreateDefaultAlignedStore(Ops.$at(1), Ops.$at(0));
    }
   case NEON.BI__builtin_neon_vqrshrn_n_v:
    Int
       = usgn ? ID.arm_neon_vqrshiftnu : ID.arm_neon_vqrshiftns;
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<org.llvm.ir.Type /*P*/ >(Ty, true)), Ops, $("vqrshrn_n"), 
        1, true);
   case NEON.BI__builtin_neon_vqrshrun_n_v:
    return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.arm_neon_vqrshiftnsu, new ArrayRef<org.llvm.ir.Type /*P*/ >(Ty, true)), 
        Ops, $("vqrshrun_n"), 1, true);
   case NEON.BI__builtin_neon_vqshrn_n_v:
    Int = usgn ? ID.arm_neon_vqshiftnu : ID.arm_neon_vqshiftns;
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<org.llvm.ir.Type /*P*/ >(Ty, true)), Ops, $("vqshrn_n"), 
        1, true);
   case NEON.BI__builtin_neon_vqshrun_n_v:
    return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.arm_neon_vqshiftnsu, new ArrayRef<org.llvm.ir.Type /*P*/ >(Ty, true)), 
        Ops, $("vqshrun_n"), 1, true);
   case NEON.BI__builtin_neon_vrecpe_v:
   case NEON.BI__builtin_neon_vrecpeq_v:
    return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.arm_neon_vrecpe, new ArrayRef<org.llvm.ir.Type /*P*/ >(Ty, true)), 
        Ops, $("vrecpe"));
   case NEON.BI__builtin_neon_vrshrn_n_v:
    return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.arm_neon_vrshiftn, new ArrayRef<org.llvm.ir.Type /*P*/ >(Ty, true)), 
        Ops, $("vrshrn_n"), 1, true);
   case NEON.BI__builtin_neon_vrsra_n_v:
   case NEON.BI__builtin_neon_vrsraq_n_v:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
    Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
    Ops.$set(2, $this().EmitNeonShiftVector(Ops.$at(2), Ty, true));
    Int = usgn ? ID.arm_neon_vrshiftu : ID.arm_neon_vrshifts;
    Ops.$set(1, $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Ops.$at(1), Ops.$at(2)}, true)/* }*/));
    return $this().Builder.CreateAdd(Ops.$at(0), Ops.$at(1), new Twine(/*KEEP_STR*/"vrsra_n"));
   case NEON.BI__builtin_neon_vsri_n_v:
   case NEON.BI__builtin_neon_vsriq_n_v:
    rightShift = true;
   case NEON.BI__builtin_neon_vsli_n_v:
   case NEON.BI__builtin_neon_vsliq_n_v:
    Ops.$set(2, $this().EmitNeonShiftVector(Ops.$at(2), Ty, rightShift));
    return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.arm_neon_vshiftins, new ArrayRef<org.llvm.ir.Type /*P*/ >(Ty, true)), 
        Ops, $("vsli_n"));
   case NEON.BI__builtin_neon_vsra_n_v:
   case NEON.BI__builtin_neon_vsraq_n_v:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
    Ops.$set(1, $this().EmitNeonRShiftImm(Ops.$at(1), Ops.$at(2), Ty, usgn, $("vsra_n")));
    return $this().Builder.CreateAdd(Ops.$at(0), Ops.$at(1));
   case NEON.BI__builtin_neon_vst1q_lane_v:
    // Handle 64-bit integer elements as a special case.  Use a shuffle to get
    // a one-element vector and avoid poor code for i64 in the backend.
    if (VTy.getElementType().isIntegerTy(64)) {
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
      Value /*P*/ SV = ConstantVector.get(new ArrayRef<Constant /*P*/ >(IrRTTI.cast_Constant(Ops.$at(2)), true));
      Ops.$set(1, $this().Builder.CreateShuffleVector(Ops.$at(1), Ops.$at(1), SV));
      Ops.$set(2, getAlignmentValue32.$call(new Address(PtrOp0)));
      org.llvm.ir.Type /*P*/ Tys[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {Unnamed_field9.Int8PtrTy, Ops.$at(1).getType()};
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.arm_neon_vst1, 
              new ArrayRef<org.llvm.ir.Type /*P*/ >(Tys, true)), new ArrayRef<Value /*P*/ >(Ops, true));
    }
   case NEON.BI__builtin_neon_vst1_lane_v:
    {
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
      Ops.$set(1, $this().Builder.CreateExtractElement(Ops.$at(1), Ops.$at(2)));
      Ty = org.llvm.ir.PointerType.getUnqual(Ops.$at(1).getType());
      StoreInst /*P*/ St = $this().Builder.CreateStore(Ops.$at(1), $this().Builder.CreateBitCast(new Address(PtrOp0), Ty));
      return St;
    }
   case NEON.BI__builtin_neon_vtbl1_v:
    return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.arm_neon_vtbl1), 
        Ops, $("vtbl1"));
   case NEON.BI__builtin_neon_vtbl2_v:
    return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.arm_neon_vtbl2), 
        Ops, $("vtbl2"));
   case NEON.BI__builtin_neon_vtbl3_v:
    return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.arm_neon_vtbl3), 
        Ops, $("vtbl3"));
   case NEON.BI__builtin_neon_vtbl4_v:
    return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.arm_neon_vtbl4), 
        Ops, $("vtbl4"));
   case NEON.BI__builtin_neon_vtbx1_v:
    return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.arm_neon_vtbx1), 
        Ops, $("vtbx1"));
   case NEON.BI__builtin_neon_vtbx2_v:
    return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.arm_neon_vtbx2), 
        Ops, $("vtbx2"));
   case NEON.BI__builtin_neon_vtbx3_v:
    return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.arm_neon_vtbx3), 
        Ops, $("vtbx3"));
   case NEON.BI__builtin_neon_vtbx4_v:
    return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.arm_neon_vtbx4), 
        Ops, $("vtbx4"));
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCommonNeonBuiltinExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 3335,
 FQN="clang::CodeGen::CodeGenFunction::EmitCommonNeonBuiltinExpr", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitCommonNeonBuiltinExprEjjjPKcjPKNS_8CallExprERN4llvm15SmallVectorImplIPNS7_5ValueEEENS0_7AddressESD_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitCommonNeonBuiltinExprEjjjPKcjPKNS_8CallExprERN4llvm15SmallVectorImplIPNS7_5ValueEEENS0_7AddressESD_")
//</editor-fold>
public final Value /*P*/ EmitCommonNeonBuiltinExpr(/*uint*/int BuiltinID, /*uint*/int LLVMIntrinsic, /*uint*/int AltLLVMIntrinsic, 
                         /*const*/char$ptr/*char P*/ NameHint, /*uint*/int Modifier, /*const*/ CallExpr /*P*/ E, 
                         final SmallVectorImpl<Value /*P*/ > /*&*/ Ops, Address PtrOp0, Address PtrOp1) {
  // Get the last argument, which specifies the vector type.
  APSInt NeonTypeConst/*J*/= new APSInt();
  /*const*/ Expr /*P*/ Arg = E.getArg$Const(E.getNumArgs() - 1);
  if (!Arg.isIntegerConstantExpr(NeonTypeConst, $this().getContext())) {
    return null;
  }
  
  // Determine the type of this overloaded NEON intrinsic.
  NeonTypeFlags Type/*J*/= new NeonTypeFlags($ulong2uint(NeonTypeConst.getZExtValue()));
  boolean Usgn = Type.isUnsigned();
  boolean Quad = Type.isQuad();
  
  org.llvm.ir.VectorType /*P*/ VTy = CGBuiltinStatics.GetNeonType($this(), new NeonTypeFlags(Type));
  org.llvm.ir.Type /*P*/ Ty = VTy;
  if (!(Ty != null)) {
    return null;
  }
  
  Address2Value getAlignmentValue32 = /*[&, this]*/ (Address addr) -> {
        return $this().Builder.getInt32($long2uint(addr.getAlignment().getQuantity()));
      };
  
  /*uint*/int Int = LLVMIntrinsic;
  if (((Modifier & CGBuiltinStatics.UnsignedAlts) != 0) && !Usgn) {
    Int = AltLLVMIntrinsic;
  }
  switch (BuiltinID) {
   default:
    break;
   case NEON.BI__builtin_neon_vabs_v:
   case NEON.BI__builtin_neon_vabsq_v:
    if (VTy.getElementType().isFloatingPointTy()) {
      return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.fabs, new ArrayRef<org.llvm.ir.Type /*P*/ >(Ty, true)), Ops, $("vabs"));
    }
    return $this().EmitNeonCall($this().CGM.getIntrinsic(LLVMIntrinsic, new ArrayRef<org.llvm.ir.Type /*P*/ >(Ty, true)), Ops, $("vabs"));
   case NEON.BI__builtin_neon_vaddhn_v:
    {
      VectorType /*P*/ SrcTy = org.llvm.ir.VectorType.getExtendedElementVectorType(VTy);
      
      // %sum = add <4 x i32> %lhs, %rhs
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), SrcTy));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), SrcTy));
      Ops.$set(0, $this().Builder.CreateAdd(Ops.$at(0), Ops.$at(1), new Twine(/*KEEP_STR*/"vaddhn")));
      
      // %high = lshr <4 x i32> %sum, <i32 16, i32 16, i32 16, i32 16>
      Constant /*P*/ ShiftAmt = ConstantInt.get(SrcTy, $uint2ulong($div_uint(SrcTy.getScalarSizeInBits(), 2)));
      Ops.$set(0, $this().Builder.CreateLShr(Ops.$at(0), ShiftAmt, new Twine(/*KEEP_STR*/"vaddhn")));
      
      // %res = trunc <4 x i32> %high to <4 x i16>
      return $this().Builder.CreateTrunc(Ops.$at(0), VTy, new Twine(/*KEEP_STR*/"vaddhn"));
    }
   case NEON.BI__builtin_neon_vcale_v:
   case NEON.BI__builtin_neon_vcaleq_v:
   case NEON.BI__builtin_neon_vcalt_v:
   case NEON.BI__builtin_neon_vcaltq_v:
    //std.swap(Ops.$at(0), Ops.$at(1));
    Value v0 = Ops.$at(0);
    Value v1 = Ops.$at(1);
    Ops.$set(0, v1);
    Ops.$set(1, v0);
   case NEON.BI__builtin_neon_vcage_v:
   case NEON.BI__builtin_neon_vcageq_v:
   case NEON.BI__builtin_neon_vcagt_v:
   case NEON.BI__builtin_neon_vcagtq_v:
    {
      org.llvm.ir.Type /*P*/ VecFlt = org.llvm.ir.VectorType.get(VTy.getScalarSizeInBits() == 32 ? FloatTy : DoubleTy, 
          VTy.getNumElements());
      org.llvm.ir.Type /*P*/ Tys[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {VTy, VecFlt};
      Function /*P*/ F = $this().CGM.getIntrinsic(LLVMIntrinsic, new ArrayRef<org.llvm.ir.Type /*P*/ >(Tys, true));
      return $this().EmitNeonCall(F, Ops, NameHint);
    }
   case NEON.BI__builtin_neon_vclz_v:
   case NEON.BI__builtin_neon_vclzq_v:
    // We generate target-independent intrinsic, which needs a second argument
    // for whether or not clz of zero is undefined; on ARM it isn't.
    Ops.push_back($this().Builder.getInt1($this().getTarget().isCLZForZeroUndef()));
    break;
   case NEON.BI__builtin_neon_vcvt_f32_v:
   case NEON.BI__builtin_neon_vcvtq_f32_v:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
    Ty = CGBuiltinStatics.GetNeonType($this(), new NeonTypeFlags(NeonTypeFlags.EltType.Float32, false, Quad));
    return Usgn ? $this().Builder.CreateUIToFP(Ops.$at(0), Ty, new Twine(/*KEEP_STR*/"vcvt")) : $this().Builder.CreateSIToFP(Ops.$at(0), Ty, new Twine(/*KEEP_STR*/"vcvt"));
   case NEON.BI__builtin_neon_vcvt_n_f32_v:
   case NEON.BI__builtin_neon_vcvt_n_f64_v:
   case NEON.BI__builtin_neon_vcvtq_n_f32_v:
   case NEON.BI__builtin_neon_vcvtq_n_f64_v:
    {
      org.llvm.ir.Type /*P*/ Tys[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {CGBuiltinStatics.GetFloatNeonType($this(), new NeonTypeFlags(Type)), Ty};
      Int = Usgn ? LLVMIntrinsic : AltLLVMIntrinsic;
      Function /*P*/ F = $this().CGM.getIntrinsic(Int, new ArrayRef<org.llvm.ir.Type /*P*/ >(Tys, true));
      return $this().EmitNeonCall(F, Ops, $("vcvt_n"));
    }
   case NEON.BI__builtin_neon_vcvt_n_s32_v:
   case NEON.BI__builtin_neon_vcvt_n_u32_v:
   case NEON.BI__builtin_neon_vcvt_n_s64_v:
   case NEON.BI__builtin_neon_vcvt_n_u64_v:
   case NEON.BI__builtin_neon_vcvtq_n_s32_v:
   case NEON.BI__builtin_neon_vcvtq_n_u32_v:
   case NEON.BI__builtin_neon_vcvtq_n_s64_v:
   case NEON.BI__builtin_neon_vcvtq_n_u64_v:
    {
      org.llvm.ir.Type /*P*/ Tys[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {Ty, CGBuiltinStatics.GetFloatNeonType($this(), new NeonTypeFlags(Type))};
      Function /*P*/ F = $this().CGM.getIntrinsic(LLVMIntrinsic, new ArrayRef<org.llvm.ir.Type /*P*/ >(Tys, true));
      return $this().EmitNeonCall(F, Ops, $("vcvt_n"));
    }
   case NEON.BI__builtin_neon_vcvt_s32_v:
   case NEON.BI__builtin_neon_vcvt_u32_v:
   case NEON.BI__builtin_neon_vcvt_s64_v:
   case NEON.BI__builtin_neon_vcvt_u64_v:
   case NEON.BI__builtin_neon_vcvtq_s32_v:
   case NEON.BI__builtin_neon_vcvtq_u32_v:
   case NEON.BI__builtin_neon_vcvtq_s64_v:
   case NEON.BI__builtin_neon_vcvtq_u64_v:
    {
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), CGBuiltinStatics.GetFloatNeonType($this(), new NeonTypeFlags(Type))));
      return Usgn ? $this().Builder.CreateFPToUI(Ops.$at(0), Ty, new Twine(/*KEEP_STR*/"vcvt")) : $this().Builder.CreateFPToSI(Ops.$at(0), Ty, new Twine(/*KEEP_STR*/"vcvt"));
    }
   case NEON.BI__builtin_neon_vcvta_s32_v:
   case NEON.BI__builtin_neon_vcvta_s64_v:
   case NEON.BI__builtin_neon_vcvta_u32_v:
   case NEON.BI__builtin_neon_vcvta_u64_v:
   case NEON.BI__builtin_neon_vcvtaq_s32_v:
   case NEON.BI__builtin_neon_vcvtaq_s64_v:
   case NEON.BI__builtin_neon_vcvtaq_u32_v:
   case NEON.BI__builtin_neon_vcvtaq_u64_v:
   case NEON.BI__builtin_neon_vcvtn_s32_v:
   case NEON.BI__builtin_neon_vcvtn_s64_v:
   case NEON.BI__builtin_neon_vcvtn_u32_v:
   case NEON.BI__builtin_neon_vcvtn_u64_v:
   case NEON.BI__builtin_neon_vcvtnq_s32_v:
   case NEON.BI__builtin_neon_vcvtnq_s64_v:
   case NEON.BI__builtin_neon_vcvtnq_u32_v:
   case NEON.BI__builtin_neon_vcvtnq_u64_v:
   case NEON.BI__builtin_neon_vcvtp_s32_v:
   case NEON.BI__builtin_neon_vcvtp_s64_v:
   case NEON.BI__builtin_neon_vcvtp_u32_v:
   case NEON.BI__builtin_neon_vcvtp_u64_v:
   case NEON.BI__builtin_neon_vcvtpq_s32_v:
   case NEON.BI__builtin_neon_vcvtpq_s64_v:
   case NEON.BI__builtin_neon_vcvtpq_u32_v:
   case NEON.BI__builtin_neon_vcvtpq_u64_v:
   case NEON.BI__builtin_neon_vcvtm_s32_v:
   case NEON.BI__builtin_neon_vcvtm_s64_v:
   case NEON.BI__builtin_neon_vcvtm_u32_v:
   case NEON.BI__builtin_neon_vcvtm_u64_v:
   case NEON.BI__builtin_neon_vcvtmq_s32_v:
   case NEON.BI__builtin_neon_vcvtmq_s64_v:
   case NEON.BI__builtin_neon_vcvtmq_u32_v:
   case NEON.BI__builtin_neon_vcvtmq_u64_v:
    {
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, CGBuiltinStatics.GetFloatNeonType($this(), new NeonTypeFlags(Type))};
      return $this().EmitNeonCall($this().CGM.getIntrinsic(LLVMIntrinsic, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, NameHint);
    }
   case NEON.BI__builtin_neon_vext_v:
   case NEON.BI__builtin_neon_vextq_v:
    {
      int CV = (int)IrRTTI.cast_ConstantInt(Ops.$at(2)).getSExtValue();
      SmallVectorUInt Indices/*J*/= new SmallVectorUInt(16, 0);
      for (/*uint*/int i = 0, e = VTy.getNumElements(); i != e; ++i)  {
        Indices.push_back(i + CV);
      }
      
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
      return $this().Builder.CreateShuffleVector(Ops.$at(0), Ops.$at(1), new ArrayRefUInt(Indices), new Twine(/*KEEP_STR*/"vext"));
    }
   case NEON.BI__builtin_neon_vfma_v:
   case NEON.BI__builtin_neon_vfmaq_v:
    {
      Value /*P*/ F = $this().CGM.getIntrinsic(ID.fma, new ArrayRef<Type /*P*/ >(Ty, true));
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
      Ops.$set(2, $this().Builder.CreateBitCast(Ops.$at(2), Ty));
      
      // NEON intrinsic puts accumulator first, unlike the LLVM fma.
      return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {Ops.$at(1), Ops.$at(2), Ops.$at(0)}, true)/* }*/);
    }
   case NEON.BI__builtin_neon_vld1_v:
   case NEON.BI__builtin_neon_vld1q_v:
    {
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, Unnamed_field9.Int8PtrTy};
      Ops.push_back(getAlignmentValue32.$call(new Address(PtrOp0)));
      return $this().EmitNeonCall($this().CGM.getIntrinsic(LLVMIntrinsic, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vld1"));
    }
   case NEON.BI__builtin_neon_vld2_v:
   case NEON.BI__builtin_neon_vld2q_v:
   case NEON.BI__builtin_neon_vld3_v:
   case NEON.BI__builtin_neon_vld3q_v:
   case NEON.BI__builtin_neon_vld4_v:
   case NEON.BI__builtin_neon_vld4q_v:
    {
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, Unnamed_field9.Int8PtrTy};
      Function /*P*/ F = $this().CGM.getIntrinsic(LLVMIntrinsic, new ArrayRef<Type /*P*/ >(Tys, true));
      Value /*P*/ Align = getAlignmentValue32.$call(new Address(PtrOp1));
      Ops.$set(1, $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Ops.$at(1), Align}, true)/* }*/, new Twine(NameHint)));
      Ty = PointerType.getUnqual(Ops.$at(1).getType());
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
      return $this().Builder.CreateDefaultAlignedStore(Ops.$at(1), Ops.$at(0));
    }
   case NEON.BI__builtin_neon_vld1_dup_v:
   case NEON.BI__builtin_neon_vld1q_dup_v:
    {
      Value /*P*/ V = UndefValue.get(Ty);
      Ty = PointerType.getUnqual(VTy.getElementType());
      PtrOp0.$assignMove($this().Builder.CreateBitCast(new Address(PtrOp0), Ty));
      LoadInst /*P*/ Ld = $this().Builder.CreateLoad(new Address(PtrOp0));
      Constant /*P*/ CI = ConstantInt.get(Unnamed_field8.SizeTy, $int2ulong(0));
      Ops.$set(0, $this().Builder.CreateInsertElement(V, Ld, CI));
      return $this().EmitNeonSplat(Ops.$at(0), CI);
    }
   case NEON.BI__builtin_neon_vld2_lane_v:
   case NEON.BI__builtin_neon_vld2q_lane_v:
   case NEON.BI__builtin_neon_vld3_lane_v:
   case NEON.BI__builtin_neon_vld3q_lane_v:
   case NEON.BI__builtin_neon_vld4_lane_v:
   case NEON.BI__builtin_neon_vld4q_lane_v:
    {
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, Unnamed_field9.Int8PtrTy};
      Function /*P*/ F = $this().CGM.getIntrinsic(LLVMIntrinsic, new ArrayRef<Type /*P*/ >(Tys, true));
      for (/*uint*/int I = 2; $less_uint(I, Ops.size() - 1); ++I)  {
        Ops.$set(I, $this().Builder.CreateBitCast(Ops.$at(I), Ty));
      }
      Ops.push_back(getAlignmentValue32.$call(new Address(PtrOp1)));
      Ops.$set(1, $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, makeArrayRef(Ops).slice(1), new Twine(NameHint)));
      Ty = PointerType.getUnqual(Ops.$at(1).getType());
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
      return $this().Builder.CreateDefaultAlignedStore(Ops.$at(1), Ops.$at(0));
    }
   case NEON.BI__builtin_neon_vmovl_v:
    {
      Type /*P*/ DTy = VectorType.getTruncatedElementVectorType(VTy);
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), DTy));
      if (Usgn) {
        return $this().Builder.CreateZExt(Ops.$at(0), Ty, new Twine(/*KEEP_STR*/"vmovl"));
      }
      return $this().Builder.CreateSExt(Ops.$at(0), Ty, new Twine(/*KEEP_STR*/"vmovl"));
    }
   case NEON.BI__builtin_neon_vmovn_v:
    {
      Type /*P*/ QTy = VectorType.getExtendedElementVectorType(VTy);
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), QTy));
      return $this().Builder.CreateTrunc(Ops.$at(0), Ty, new Twine(/*KEEP_STR*/"vmovn"));
    }
   case NEON.BI__builtin_neon_vmull_v:
    // FIXME: the integer vmull operations could be emitted in terms of pure
    // LLVM IR (2 exts followed by a mul). Unfortunately LLVM has a habit of
    // hoisting the exts outside loops. Until global ISel comes along that can
    // see through such movement this leads to bad CodeGen. So we need an
    // intrinsic for now.
    Int = Usgn ? ID.arm_neon_vmullu : ID.arm_neon_vmulls;
    Int = Type.isPoly() ? (/*uint*/int)ID.arm_neon_vmullp : Int;
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vmull"));
   case NEON.BI__builtin_neon_vpadal_v:
   case NEON.BI__builtin_neon_vpadalq_v:
    {
      // The source operand type has twice as many elements of half the size.
      /*uint*/int EltBits = VTy.getElementType().getPrimitiveSizeInBits();
      Type /*P*/ EltTy = IntegerType.get($this().getLLVMContext(), $div_uint(EltBits, 2));
      Type /*P*/ NarrowTy = VectorType.get(EltTy, VTy.getNumElements() * 2);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, NarrowTy};
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, NameHint);
    }
   case NEON.BI__builtin_neon_vpaddl_v:
   case NEON.BI__builtin_neon_vpaddlq_v:
    {
      // The source operand type has twice as many elements of half the size.
      /*uint*/int EltBits = VTy.getElementType().getPrimitiveSizeInBits();
      Type /*P*/ EltTy = IntegerType.get($this().getLLVMContext(), $div_uint(EltBits, 2));
      Type /*P*/ NarrowTy = VectorType.get(EltTy, VTy.getNumElements() * 2);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, NarrowTy};
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vpaddl"));
    }
   case NEON.BI__builtin_neon_vqdmlal_v:
   case NEON.BI__builtin_neon_vqdmlsl_v:
    {
      SmallVector<Value /*P*/ > MulOps/*J*/= new SmallVector<Value /*P*/ >(JD$T.INSTANCE, 2, Ops.begin().$add(1), Ops.end(), (Value /*P*/ )null);
      Ops.$set(1, 
        $this().EmitNeonCall($this().CGM.getIntrinsic(LLVMIntrinsic, new ArrayRef<Type /*P*/ >(Ty, true)), MulOps, $("vqdmlal")));
      Ops.resize(2);
      return $this().EmitNeonCall($this().CGM.getIntrinsic(AltLLVMIntrinsic, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, NameHint);
    }
   case NEON.BI__builtin_neon_vqshl_n_v:
   case NEON.BI__builtin_neon_vqshlq_n_v:
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vqshl_n"), 
        1, false);
   case NEON.BI__builtin_neon_vqshlu_n_v:
   case NEON.BI__builtin_neon_vqshluq_n_v:
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vqshlu_n"), 
        1, false);
   case NEON.BI__builtin_neon_vrecpe_v:
   case NEON.BI__builtin_neon_vrecpeq_v:
   case NEON.BI__builtin_neon_vrsqrte_v:
   case NEON.BI__builtin_neon_vrsqrteq_v:
    Int = Ty.isFPOrFPVectorTy() ? LLVMIntrinsic : AltLLVMIntrinsic;
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, NameHint);
   case NEON.BI__builtin_neon_vrshr_n_v:
   case NEON.BI__builtin_neon_vrshrq_n_v:
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vrshr_n"), 
        1, true);
   case NEON.BI__builtin_neon_vshl_n_v:
   case NEON.BI__builtin_neon_vshlq_n_v:
    Ops.$set(1, $this().EmitNeonShiftVector(Ops.$at(1), Ty, false));
    return $this().Builder.CreateShl($this().Builder.CreateBitCast(Ops.$at(0), Ty), Ops.$at(1), 
        new Twine(/*KEEP_STR*/"vshl_n"));
   case NEON.BI__builtin_neon_vshll_n_v:
    {
      Type /*P*/ SrcTy = VectorType.getTruncatedElementVectorType(VTy);
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), SrcTy));
      if (Usgn) {
        Ops.$set(0, $this().Builder.CreateZExt(Ops.$at(0), VTy));
      } else {
        Ops.$set(0, $this().Builder.CreateSExt(Ops.$at(0), VTy));
      }
      Ops.$set(1, $this().EmitNeonShiftVector(Ops.$at(1), VTy, false));
      return $this().Builder.CreateShl(Ops.$at(0), Ops.$at(1), new Twine(/*KEEP_STR*/"vshll_n"));
    }
   case NEON.BI__builtin_neon_vshrn_n_v:
    {
      Type /*P*/ SrcTy = VectorType.getExtendedElementVectorType(VTy);
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), SrcTy));
      Ops.$set(1, $this().EmitNeonShiftVector(Ops.$at(1), SrcTy, false));
      if (Usgn) {
        Ops.$set(0, $this().Builder.CreateLShr(Ops.$at(0), Ops.$at(1)));
      } else {
        Ops.$set(0, $this().Builder.CreateAShr(Ops.$at(0), Ops.$at(1)));
      }
      return $this().Builder.CreateTrunc(Ops.$at(0), Ty, new Twine(/*KEEP_STR*/"vshrn_n"));
    }
   case NEON.BI__builtin_neon_vshr_n_v:
   case NEON.BI__builtin_neon_vshrq_n_v:
    return $this().EmitNeonRShiftImm(Ops.$at(0), Ops.$at(1), Ty, Usgn, $("vshr_n"));
   case NEON.BI__builtin_neon_vst1_v:
   case NEON.BI__builtin_neon_vst1q_v:
   case NEON.BI__builtin_neon_vst2_v:
   case NEON.BI__builtin_neon_vst2q_v:
   case NEON.BI__builtin_neon_vst3_v:
   case NEON.BI__builtin_neon_vst3q_v:
   case NEON.BI__builtin_neon_vst4_v:
   case NEON.BI__builtin_neon_vst4q_v:
   case NEON.BI__builtin_neon_vst2_lane_v:
   case NEON.BI__builtin_neon_vst2q_lane_v:
   case NEON.BI__builtin_neon_vst3_lane_v:
   case NEON.BI__builtin_neon_vst3q_lane_v:
   case NEON.BI__builtin_neon_vst4_lane_v:
   case NEON.BI__builtin_neon_vst4q_lane_v:
    {
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Unnamed_field9.Int8PtrTy, Ty};
      Ops.push_back(getAlignmentValue32.$call(new Address(PtrOp0)));
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $EMPTY);
    }
   case NEON.BI__builtin_neon_vsubhn_v:
    {
      VectorType /*P*/ SrcTy = VectorType.getExtendedElementVectorType(VTy);
      
      // %sum = add <4 x i32> %lhs, %rhs
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), SrcTy));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), SrcTy));
      Ops.$set(0, $this().Builder.CreateSub(Ops.$at(0), Ops.$at(1), new Twine(/*KEEP_STR*/"vsubhn")));
      
      // %high = lshr <4 x i32> %sum, <i32 16, i32 16, i32 16, i32 16>
      Constant /*P*/ ShiftAmt = ConstantInt.get(SrcTy, $uint2ulong($div_uint(SrcTy.getScalarSizeInBits(), 2)));
      Ops.$set(0, $this().Builder.CreateLShr(Ops.$at(0), ShiftAmt, new Twine(/*KEEP_STR*/"vsubhn")));
      
      // %res = trunc <4 x i32> %high to <4 x i16>
      return $this().Builder.CreateTrunc(Ops.$at(0), VTy, new Twine(/*KEEP_STR*/"vsubhn"));
    }
   case NEON.BI__builtin_neon_vtrn_v:
   case NEON.BI__builtin_neon_vtrnq_v:
    {
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), PointerType.getUnqual(Ty)));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
      Ops.$set(2, $this().Builder.CreateBitCast(Ops.$at(2), Ty));
      Value /*P*/ SV = null;
      
      for (/*uint*/int vi = 0; vi != 2; ++vi) {
        SmallVectorUInt Indices/*J*/= new SmallVectorUInt(16, 0);
        for (/*uint*/int i = 0, e = VTy.getNumElements(); i != e; i += 2) {
          Indices.push_back(i + vi);
          Indices.push_back(i + e + vi);
        }
        Value /*P*/ Addr = $this().Builder.CreateConstInBoundsGEP1_32(Ty, Ops.$at(0), vi);
        SV = $this().Builder.CreateShuffleVector(Ops.$at(1), Ops.$at(2), new ArrayRefUInt(Indices), new Twine(/*KEEP_STR*/"vtrn"));
        SV = $this().Builder.CreateDefaultAlignedStore(SV, Addr);
      }
      return SV;
    }
   case NEON.BI__builtin_neon_vtst_v:
   case NEON.BI__builtin_neon_vtstq_v:
    {
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
      Ops.$set(0, $this().Builder.CreateAnd(Ops.$at(0), Ops.$at(1)));
      Ops.$set(0, $this().Builder.CreateICmp(ICmpInst.Predicate.ICMP_NE, Ops.$at(0), 
          ConstantAggregateZero.get(Ty)));
      return $this().Builder.CreateSExt(Ops.$at(0), Ty, new Twine(/*KEEP_STR*/"vtst"));
    }
   case NEON.BI__builtin_neon_vuzp_v:
   case NEON.BI__builtin_neon_vuzpq_v:
    {
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), PointerType.getUnqual(Ty)));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
      Ops.$set(2, $this().Builder.CreateBitCast(Ops.$at(2), Ty));
      Value /*P*/ SV = null;
      
      for (/*uint*/int vi = 0; vi != 2; ++vi) {
        SmallVectorUInt Indices/*J*/= new SmallVectorUInt(16, 0);
        for (/*uint*/int i = 0, e = VTy.getNumElements(); i != e; ++i)  {
          Indices.push_back(2 * i + vi);
        }
        
        Value /*P*/ Addr = $this().Builder.CreateConstInBoundsGEP1_32(Ty, Ops.$at(0), vi);
        SV = $this().Builder.CreateShuffleVector(Ops.$at(1), Ops.$at(2), new ArrayRefUInt(Indices), new Twine(/*KEEP_STR*/"vuzp"));
        SV = $this().Builder.CreateDefaultAlignedStore(SV, Addr);
      }
      return SV;
    }
   case NEON.BI__builtin_neon_vzip_v:
   case NEON.BI__builtin_neon_vzipq_v:
    {
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), PointerType.getUnqual(Ty)));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
      Ops.$set(2, $this().Builder.CreateBitCast(Ops.$at(2), Ty));
      Value /*P*/ SV = null;
      
      for (/*uint*/int vi = 0; vi != 2; ++vi) {
        SmallVectorUInt Indices/*J*/= new SmallVectorUInt(16, 0);
        for (/*uint*/int i = 0, e = VTy.getNumElements(); i != e; i += 2) {
          Indices.push_back((i + vi * e) >>> 1);
          Indices.push_back(((i + vi * e) >>> 1) + e);
        }
        Value /*P*/ Addr = $this().Builder.CreateConstInBoundsGEP1_32(Ty, Ops.$at(0), vi);
        SV = $this().Builder.CreateShuffleVector(Ops.$at(1), Ops.$at(2), new ArrayRefUInt(Indices), new Twine(/*KEEP_STR*/"vzip"));
        SV = $this().Builder.CreateDefaultAlignedStore(SV, Addr);
      }
      return SV;
    }
  }
  assert ((Int != 0)) : "Expected valid intrinsic number";
  
  // Determine the type(s) of this overloaded AArch64 intrinsic.
  Function /*P*/ F = $this().LookupNeonLLVMIntrinsic(Int, Modifier, Ty, E);
  
  Value /*P*/ Result = $this().EmitNeonCall(F, Ops, NameHint);
  Type /*P*/ ResultType = $this().ConvertType(E.getType());
  // AArch64 intrinsic one-element vector type cast to
  // scalar type expected by the builtin
  return $this().Builder.CreateBitCast(Result, ResultType, new Twine(NameHint));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::LookupNeonLLVMIntrinsic">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 3233,
 FQN="clang::CodeGen::CodeGenFunction::LookupNeonLLVMIntrinsic", NM="_ZN5clang7CodeGen15CodeGenFunction23LookupNeonLLVMIntrinsicEjjPN4llvm4TypeEPKNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23LookupNeonLLVMIntrinsicEjjPN4llvm4TypeEPKNS_8CallExprE")
//</editor-fold>
public final Function /*P*/ LookupNeonLLVMIntrinsic(/*uint*/int IntrinsicID, 
                       /*uint*/int Modifier, 
                       Type /*P*/ ArgType, 
                       /*const*/ CallExpr /*P*/ E) {
  int VectorSize = 0;
  if (((Modifier & CGBuiltinStatics.Use64BitVectors) != 0)) {
    VectorSize = 64;
  } else if (((Modifier & CGBuiltinStatics.Use128BitVectors) != 0)) {
    VectorSize = 128;
  }
  
  // Return type.
  SmallVector<Type /*P*/ > Tys/*J*/= new SmallVector<Type /*P*/ >(3, (Type /*P*/ )null);
  if (((Modifier & CGBuiltinStatics.AddRetType) != 0)) {
    Type /*P*/ Ty = $this().ConvertType(E.getCallReturnType($this().getContext()));
    if (((Modifier & CGBuiltinStatics.VectorizeRetType) != 0)) {
      Ty = VectorType.get(Ty, (VectorSize != 0) ? $div_uint(VectorSize, Ty.getPrimitiveSizeInBits()) : 1);
    }
    
    Tys.push_back(Ty);
  }
  
  // Arguments.
  if (((Modifier & CGBuiltinStatics.VectorizeArgTypes) != 0)) {
    int Elts = (VectorSize != 0) ? $div_uint(VectorSize, ArgType.getPrimitiveSizeInBits()) : 1;
    ArgType = VectorType.get(ArgType, Elts);
  }
  if (((Modifier & (CGBuiltinStatics.Add1ArgType | CGBuiltinStatics.Add2ArgTypes)) != 0)) {
    Tys.push_back(ArgType);
  }
  if (((Modifier & CGBuiltinStatics.Add2ArgTypes) != 0)) {
    Tys.push_back(ArgType);
  }
  if (((Modifier & CGBuiltinStatics.InventFloatType) != 0)) {
    Tys.push_back(FloatTy);
  }
  
  return $this().CGM.getIntrinsic(IntrinsicID, new ArrayRef<Type /*P*/ >(Tys, true));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitNeonCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 2573,
 FQN="clang::CodeGen::CodeGenFunction::EmitNeonCall", NM="_ZN5clang7CodeGen15CodeGenFunction12EmitNeonCallEPN4llvm8FunctionERNS2_15SmallVectorImplIPNS2_5ValueEEEPKcjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12EmitNeonCallEPN4llvm8FunctionERNS2_15SmallVectorImplIPNS2_5ValueEEEPKcjb")
//</editor-fold>
public final Value /*P*/ EmitNeonCall(Function /*P*/ F, final SmallVectorImpl<Value /*P*/ > /*&*/ Ops, 
            /*const*/char$ptr/*char P*/ name) {
  return EmitNeonCall(F, Ops, 
            name, 
            0, false);
}
public final Value /*P*/ EmitNeonCall(Function /*P*/ F, final SmallVectorImpl<Value /*P*/ > /*&*/ Ops, 
            /*const*/char$ptr/*char P*/ name, 
            /*uint*/int shift/*= 0*/) {
  return EmitNeonCall(F, Ops, 
            name, 
            shift, false);
}
public final Value /*P*/ EmitNeonCall(Function /*P*/ F, final SmallVectorImpl<Value /*P*/ > /*&*/ Ops, 
            /*const*/char$ptr/*char P*/ name, 
            /*uint*/int shift/*= 0*/, boolean rightshift/*= false*/) {
  /*uint*/int j = 0;
  for (ilist_iterator</*const*/ Argument> ai = new ilist_iterator</*const*/ Argument>(F.arg_begin()), ae = new ilist_iterator</*const*/ Argument>(F.arg_end());
       ai.$noteq(ae); ai.$preInc() , ++j)  {
    if ($greater_uint(shift, 0) && shift == j) {
      Ops.$set(j, $this().EmitNeonShiftVector(Ops.$at(j), ai.$arrow().getType(), rightshift));
    } else {
      Ops.$set(j, $this().Builder.CreateBitCast(Ops.$at(j), ai.$arrow().getType(), new Twine(name)));
    }
  }
  
  return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Ops, true), new Twine(name));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitNeonSplat">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 2567,
 FQN="clang::CodeGen::CodeGenFunction::EmitNeonSplat", NM="_ZN5clang7CodeGen15CodeGenFunction13EmitNeonSplatEPN4llvm5ValueEPNS2_8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13EmitNeonSplatEPN4llvm5ValueEPNS2_8ConstantE")
//</editor-fold>
public final Value /*P*/ EmitNeonSplat(Value /*P*/ V, Constant /*P*/ C) {
  /*uint*/int nElts = V.getType().getVectorNumElements();
  Value /*P*/ SV = ConstantVector.getSplat(nElts, C);
  return $this().Builder.CreateShuffleVector(V, V, SV, new Twine(/*KEEP_STR*/"lane"));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitNeonShiftVector">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 2587,
 FQN="clang::CodeGen::CodeGenFunction::EmitNeonShiftVector", NM="_ZN5clang7CodeGen15CodeGenFunction19EmitNeonShiftVectorEPN4llvm5ValueEPNS2_4TypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19EmitNeonShiftVectorEPN4llvm5ValueEPNS2_4TypeEb")
//</editor-fold>
public final Value /*P*/ EmitNeonShiftVector(Value /*P*/ V, Type /*P*/ Ty, 
                   boolean neg) {
  int SV = (int)IrRTTI.cast_ConstantInt(V).getSExtValue();
  return ConstantInt.get(Ty, $int2ulong(neg ? -SV : SV));
}


// \brief Right-shift a vector by a constant.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitNeonRShiftImm">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 2594,
 FQN="clang::CodeGen::CodeGenFunction::EmitNeonRShiftImm", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitNeonRShiftImmEPN4llvm5ValueES4_PNS2_4TypeEbPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitNeonRShiftImmEPN4llvm5ValueES4_PNS2_4TypeEbPKc")
//</editor-fold>
public final Value /*P*/ EmitNeonRShiftImm(Value /*P*/ Vec, Value /*P*/ Shift, 
                 Type /*P*/ Ty, boolean usgn, 
                 /*const*/char$ptr/*char P*/ name) {
  VectorType /*P*/ VTy = IrRTTI.cast_VectorType(Ty);
  
  int ShiftAmt = (int)IrRTTI.cast_ConstantInt(Shift).getSExtValue();
  int EltSize = VTy.getScalarSizeInBits();
  
  Vec = $this().Builder.CreateBitCast(Vec, Ty);
  
  // lshr/ashr are undefined when the shift amount is equal to the vector
  // element size.
  if (ShiftAmt == EltSize) {
    if (usgn) {
      // Right-shifting an unsigned value by its size yields 0.
      return ConstantAggregateZero.get(VTy);
    } else {
      // Right-shifting a signed value by its size is equivalent
      // to a shift of size-1.
      --ShiftAmt;
      Shift = ConstantInt.get(VTy.getElementType(), $int2ulong(ShiftAmt));
    }
  }
  
  Shift = $this().EmitNeonShiftVector(Shift, Ty, false);
  if (usgn) {
    return $this().Builder.CreateLShr(Vec, Shift, new Twine(name));
  } else {
    return $this().Builder.CreateAShr(Vec, Shift, new Twine(name));
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::vectorWrapScalar16">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 4776,
 FQN="clang::CodeGen::CodeGenFunction::vectorWrapScalar16", NM="_ZN5clang7CodeGen15CodeGenFunction18vectorWrapScalar16EPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18vectorWrapScalar16EPN4llvm5ValueE")
//</editor-fold>
public final Value /*P*/ vectorWrapScalar16(Value /*P*/ Op) {
  Type /*P*/ VTy = VectorType.get(Int16Ty, 4);
  Op = $this().Builder.CreateBitCast(Op, Int16Ty);
  Value /*P*/ V = UndefValue.get(VTy);
  Constant /*P*/ CI = ConstantInt.get(Unnamed_field8.SizeTy, $int2ulong(0));
  Op = $this().Builder.CreateInsertElement(V, Op, CI);
  return Op;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAArch64BuiltinExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 4785,
 FQN="clang::CodeGen::CodeGenFunction::EmitAArch64BuiltinExpr", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitAArch64BuiltinExprEjPKNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitAArch64BuiltinExprEjPKNS_8CallExprE")
//</editor-fold>
public final Value /*P*/ EmitAArch64BuiltinExpr(/*uint*/int BuiltinID, 
                      /*const*/ CallExpr /*P*/ E) {
  /*uint*/int HintID = ((/*static_cast*//*uint*/int)(-1));
  switch (BuiltinID) {
   default:
    break;
   case AArch64.BI__builtin_arm_nop:
    HintID = 0;
    break;
   case AArch64.BI__builtin_arm_yield:
    HintID = 1;
    break;
   case AArch64.BI__builtin_arm_wfe:
    HintID = 2;
    break;
   case AArch64.BI__builtin_arm_wfi:
    HintID = 3;
    break;
   case AArch64.BI__builtin_arm_sev:
    HintID = 4;
    break;
   case AArch64.BI__builtin_arm_sevl:
    HintID = 5;
    break;
  }
  if (HintID != ((/*static_cast*//*uint*/int)(-1))) {
    Function /*P*/ F = $this().CGM.getIntrinsic(ID.aarch64_hint);
    return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(ConstantInt.get(Int32Ty, $uint2ulong(HintID)), true));
  }
  if (BuiltinID == AArch64.BI__builtin_arm_prefetch) {
    Value /*P*/ Address = $this().EmitScalarExpr(E.getArg$Const(0));
    Value /*P*/ RW = $this().EmitScalarExpr(E.getArg$Const(1));
    Value /*P*/ CacheLevel = $this().EmitScalarExpr(E.getArg$Const(2));
    Value /*P*/ RetentionPolicy = $this().EmitScalarExpr(E.getArg$Const(3));
    Value /*P*/ IsData = $this().EmitScalarExpr(E.getArg$Const(4));
    
    Value /*P*/ Locality = null;
    if (IrRTTI.cast_ConstantInt(RetentionPolicy).isZero()) {
      // Temporal fetch, needs to convert cache level to locality.
      Locality = ConstantInt.get(Int32Ty, 
          IrRTTI.cast_ConstantInt(CacheLevel).getValue().$sub().$add($int2ulong(3)));
    } else {
      // Streaming fetch.
      Locality = ConstantInt.get(Int32Ty, $int2ulong(0));
    }
    
    // FIXME: We need AArch64 specific LLVM intrinsic if we want to specify
    // PLDL3STRM or PLDL2STRM.
    Value /*P*/ F = $this().CGM.getIntrinsic(ID.prefetch);
    return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*4*/] {Address, RW, Locality, IsData}, true)/* }*/);
  }
  if (BuiltinID == AArch64.BI__builtin_arm_rbit) {
    assert (($this().getContext().getTypeSize(E.getType()) == $int2ullong(32))) : "rbit of unusual size!";
    Value /*P*/ Arg = $this().EmitScalarExpr(E.getArg$Const(0));
    return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.aarch64_rbit, new ArrayRef<Type /*P*/ >(Arg.getType(), true)), new ArrayRef<Value /*P*/ >(Arg, true), new Twine(/*KEEP_STR*/"rbit"));
  }
  if (BuiltinID == AArch64.BI__builtin_arm_rbit64) {
    assert (($this().getContext().getTypeSize(E.getType()) == $int2ullong(64))) : "rbit of unusual size!";
    Value /*P*/ Arg = $this().EmitScalarExpr(E.getArg$Const(0));
    return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.aarch64_rbit, new ArrayRef<Type /*P*/ >(Arg.getType(), true)), new ArrayRef<Value /*P*/ >(Arg, true), new Twine(/*KEEP_STR*/"rbit"));
  }
  if (BuiltinID == AArch64.BI__clear_cache) {
    assert (E.getNumArgs() == 2) : "__clear_cache takes 2 arguments";
    /*const*/ FunctionDecl /*P*/ FD = E.getDirectCallee$Const();
    Value /*P*/ Ops[/*2*/] = new Value /*P*/  [2];
    for (/*uint*/int i = 0; $less_uint(i, 2); i++)  {
      Ops[i] = $this().EmitScalarExpr(E.getArg$Const(i));
    }
    Type /*P*/ Ty = $this().CGM.getTypes().ConvertType(FD.getType());
    FunctionType /*P*/ FTy = IrRTTI.cast_FunctionType(Ty);
    StringRef Name = FD.getName();
    return $this().EmitNounwindRuntimeCall($this().CGM.CreateRuntimeFunction(FTy, new StringRef(Name)), new ArrayRef<Value /*P*/ >(Ops, true));
  }
  if ((BuiltinID == AArch64.BI__builtin_arm_ldrex
     || BuiltinID == AArch64.BI__builtin_arm_ldaex)
     && $this().getContext().getTypeSize(E.getType()) == $int2ullong(128)) {
    Function /*P*/ F = $this().CGM.getIntrinsic(BuiltinID == AArch64.BI__builtin_arm_ldaex ? ID.aarch64_ldaxp : ID.aarch64_ldxp);
    
    Value /*P*/ LdPtr = $this().EmitScalarExpr(E.getArg$Const(0));
    Value /*P*/ Val = $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >($this().Builder.CreateBitCast(LdPtr, Unnamed_field9.Int8PtrTy), true), 
        new Twine(/*KEEP_STR*/"ldxp"));
    
    Value /*P*/ Val0 = $this().Builder.CreateExtractValue(Val, new ArrayRefUInt(1));
    Value /*P*/ Val1 = $this().Builder.CreateExtractValue(Val, new ArrayRefUInt(0));
    Type /*P*/ Int128Ty = IntegerType.get($this().getLLVMContext(), 128);
    Val0 = $this().Builder.CreateZExt(Val0, Int128Ty);
    Val1 = $this().Builder.CreateZExt(Val1, Int128Ty);
    
    Value /*P*/ ShiftCst = ConstantInt.get(Int128Ty, $int2ulong(64));
    Val = $this().Builder.CreateShl(Val0, ShiftCst, new Twine(/*KEEP_STR*/"shl"), true/* nuw */);
    Val = $this().Builder.CreateOr(Val, Val1);
    return $this().Builder.CreateBitCast(Val, $this().ConvertType(E.getType()));
  } else if (BuiltinID == AArch64.BI__builtin_arm_ldrex
     || BuiltinID == AArch64.BI__builtin_arm_ldaex) {
    Value /*P*/ LoadAddr = $this().EmitScalarExpr(E.getArg$Const(0));
    
    QualType Ty = E.getType();
    Type /*P*/ RealResTy = $this().ConvertType(new QualType(Ty));
    Type /*P*/ IntResTy = IntegerType.get($this().getLLVMContext(), 
        $ulong2uint($this().getContext().getTypeSize(new QualType(Ty))));
    LoadAddr = $this().Builder.CreateBitCast(LoadAddr, IntResTy.getPointerTo());
    
    Function /*P*/ F = $this().CGM.getIntrinsic(BuiltinID == AArch64.BI__builtin_arm_ldaex ? ID.aarch64_ldaxr : ID.aarch64_ldxr, 
        new ArrayRef<Type /*P*/ >(LoadAddr.getType(), true));
    Value /*P*/ Val = $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(LoadAddr, true), new Twine(/*KEEP_STR*/"ldxr"));
    if (RealResTy.isPointerTy()) {
      return $this().Builder.CreateIntToPtr(Val, RealResTy);
    }
    
    Val = $this().Builder.CreateTruncOrBitCast(Val, IntResTy);
    return $this().Builder.CreateBitCast(Val, RealResTy);
  }
  if ((BuiltinID == AArch64.BI__builtin_arm_strex
     || BuiltinID == AArch64.BI__builtin_arm_stlex)
     && $this().getContext().getTypeSize(E.getArg$Const(0).getType()) == $int2ullong(128)) {
    Function /*P*/ F = $this().CGM.getIntrinsic(BuiltinID == AArch64.BI__builtin_arm_stlex ? ID.aarch64_stlxp : ID.aarch64_stxp);
    Type /*P*/ STy = StructType.get(Int64Ty, Int64Ty, null);
    
    Address Tmp = $this().CreateMemTemp(E.getArg$Const(0).getType());
    $this().EmitAnyExprToMem(E.getArg$Const(0), new Address(Tmp), new Qualifiers(), /*init*/ true);
    
    Tmp.$assignMove($this().Builder.CreateBitCast(new Address(Tmp), PointerType.getUnqual(STy)));
    Value /*P*/ Val = $this().Builder.CreateLoad(new Address(Tmp));
    
    Value /*P*/ Arg0 = $this().Builder.CreateExtractValue(Val, new ArrayRefUInt(0));
    Value /*P*/ Arg1 = $this().Builder.CreateExtractValue(Val, new ArrayRefUInt(1));
    Value /*P*/ StPtr = $this().Builder.CreateBitCast($this().EmitScalarExpr(E.getArg$Const(1)), 
        Unnamed_field9.Int8PtrTy);
    return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {Arg0, Arg1, StPtr}, true)/* }*/, new Twine(/*KEEP_STR*/"stxp"));
  }
  if (BuiltinID == AArch64.BI__builtin_arm_strex
     || BuiltinID == AArch64.BI__builtin_arm_stlex) {
    Value /*P*/ StoreVal = $this().EmitScalarExpr(E.getArg$Const(0));
    Value /*P*/ StoreAddr = $this().EmitScalarExpr(E.getArg$Const(1));
    
    QualType Ty = E.getArg$Const(0).getType();
    Type /*P*/ StoreTy = IntegerType.get($this().getLLVMContext(), 
        $ulong2uint($this().getContext().getTypeSize(new QualType(Ty))));
    StoreAddr = $this().Builder.CreateBitCast(StoreAddr, StoreTy.getPointerTo());
    if (StoreVal.getType().isPointerTy()) {
      StoreVal = $this().Builder.CreatePtrToInt(StoreVal, Int64Ty);
    } else {
      StoreVal = $this().Builder.CreateBitCast(StoreVal, StoreTy);
      StoreVal = $this().Builder.CreateZExtOrBitCast(StoreVal, Int64Ty);
    }
    
    Function /*P*/ F = $this().CGM.getIntrinsic(BuiltinID == AArch64.BI__builtin_arm_stlex ? ID.aarch64_stlxr : ID.aarch64_stxr, 
        new ArrayRef<Type /*P*/ >(StoreAddr.getType(), true));
    return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {StoreVal, StoreAddr}, true)/* }*/, new Twine(/*KEEP_STR*/"stxr"));
  }
  if (BuiltinID == AArch64.BI__builtin_arm_clrex) {
    Function /*P*/ F = $this().CGM.getIntrinsic(ID.aarch64_clrex);
    return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F);
  }
  
  // CRC32
  /*Intrinsic.ID*/int CRCIntrinsicID = ID.not_intrinsic;
  switch (BuiltinID) {
   case AArch64.BI__builtin_arm_crc32b:
    CRCIntrinsicID = ID.aarch64_crc32b;
    break;
   case AArch64.BI__builtin_arm_crc32cb:
    CRCIntrinsicID = ID.aarch64_crc32cb;
    break;
   case AArch64.BI__builtin_arm_crc32h:
    CRCIntrinsicID = ID.aarch64_crc32h;
    break;
   case AArch64.BI__builtin_arm_crc32ch:
    CRCIntrinsicID = ID.aarch64_crc32ch;
    break;
   case AArch64.BI__builtin_arm_crc32w:
    CRCIntrinsicID = ID.aarch64_crc32w;
    break;
   case AArch64.BI__builtin_arm_crc32cw:
    CRCIntrinsicID = ID.aarch64_crc32cw;
    break;
   case AArch64.BI__builtin_arm_crc32d:
    CRCIntrinsicID = ID.aarch64_crc32x;
    break;
   case AArch64.BI__builtin_arm_crc32cd:
    CRCIntrinsicID = ID.aarch64_crc32cx;
    break;
  }
  if (CRCIntrinsicID != ID.not_intrinsic) {
    Value /*P*/ Arg0 = $this().EmitScalarExpr(E.getArg$Const(0));
    Value /*P*/ Arg1 = $this().EmitScalarExpr(E.getArg$Const(1));
    Function /*P*/ F = $this().CGM.getIntrinsic(CRCIntrinsicID);
    
    Type /*P*/ DataTy = F.getFunctionType().getParamType(1);
    Arg1 = $this().Builder.CreateZExtOrBitCast(Arg1, DataTy);
    
    return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Arg0, Arg1}, true)/* }*/);
  }
  if (BuiltinID == AArch64.BI__builtin_arm_rsr
     || BuiltinID == AArch64.BI__builtin_arm_rsr64
     || BuiltinID == AArch64.BI__builtin_arm_rsrp
     || BuiltinID == AArch64.BI__builtin_arm_wsr
     || BuiltinID == AArch64.BI__builtin_arm_wsr64
     || BuiltinID == AArch64.BI__builtin_arm_wsrp) {
    
    boolean IsRead = BuiltinID == AArch64.BI__builtin_arm_rsr
       || BuiltinID == AArch64.BI__builtin_arm_rsr64
       || BuiltinID == AArch64.BI__builtin_arm_rsrp;
    
    boolean IsPointerBuiltin = BuiltinID == AArch64.BI__builtin_arm_rsrp
       || BuiltinID == AArch64.BI__builtin_arm_wsrp;
    
    boolean Is64Bit = BuiltinID != AArch64.BI__builtin_arm_rsr
       && BuiltinID != AArch64.BI__builtin_arm_wsr;
    
    Type /*P*/ ValueType;
    Type /*P*/ RegisterType = Int64Ty;
    if (IsPointerBuiltin) {
      ValueType = Unnamed_field9.VoidPtrTy;
    } else if (Is64Bit) {
      ValueType = Int64Ty;
    } else {
      ValueType = Int32Ty;
    }
    
    return CGBuiltinStatics.EmitSpecialRegisterBuiltin(/*Deref*/$this(), E, RegisterType, ValueType, IsRead);
  }
  
  // Find out if any arguments are required to be integer constant
  // expressions.
  uint$ptr ICEArguments = create_uint$ptr(0);
  type$ref<ASTContext.GetBuiltinTypeError> Error = create_type$ref();
  $this().getContext().GetBuiltinType(BuiltinID, Error, $AddrOf(ICEArguments));
  assert (Error.$deref() == ASTContext.GetBuiltinTypeError.GE_None) : "Should not codegen an error";
  
  SmallVector<Value /*P*/ > Ops/*J*/= new SmallVector<Value /*P*/ >(4, (Value /*P*/ )null);
  for (/*uint*/int i = 0, e = E.getNumArgs() - 1; i != e; i++) {
    if ((ICEArguments.$star() & (1 << i)) == 0) {
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(i)));
    } else {
      // If this is required to be a constant, constant fold it so that we know
      // that the generated intrinsic gets a ConstantInt.
      APSInt Result/*J*/= new APSInt();
      boolean IsConst = E.getArg$Const(i).isIntegerConstantExpr(Result, $this().getContext());
      assert (IsConst) : "Constant arg isn't actually constant?";
      ///*J:(void)*/IsConst;
      Ops.push_back(ConstantInt.get($this().getLLVMContext(), Result));
    }
  }
  
  ArrayRef<NeonIntrinsicInfo> SISDMap = makeArrayRef(192, CGBuiltinStatics.AArch64SISDIntrinsicMap, false);
  /*const*/ NeonIntrinsicInfo /*P*/ Builtin = CGBuiltinStatics.findNeonIntrinsicInMap(new ArrayRef<NeonIntrinsicInfo>(SISDMap), BuiltinID, CGBuiltinStatics.AArch64SISDIntrinsicsProvenSorted_ref);
  if ((Builtin != null)) {
    Ops.push_back($this().EmitScalarExpr(E.getArg$Const(E.getNumArgs() - 1)));
    Value /*P*/ Result = CGBuiltinStatics.EmitCommonNeonSISDBuiltinExpr(/*Deref*/$this(), $Deref(Builtin), Ops, E);
    assert ((Result != null)) : "SISD intrinsic should have been handled";
    return Result;
  }
  
  APSInt Result/*J*/= new APSInt();
  /*const*/ Expr /*P*/ Arg = E.getArg$Const(E.getNumArgs() - 1);
  NeonTypeFlags Type/*J*/= new NeonTypeFlags(0);
  if (Arg.isIntegerConstantExpr(Result, $this().getContext())) {
    // Determine the type of this overloaded NEON intrinsic.
    Type.$assignMove(new NeonTypeFlags($ulong2uint(Result.getZExtValue())));
  }
  
  boolean usgn = Type.isUnsigned();
  boolean quad = Type.isQuad();
  
  // Handle non-overloaded intrinsics first.
  switch (BuiltinID) {
   default:
    break;
   case NEON.BI__builtin_neon_vldrq_p128:
    {
      org.llvm.ir.Type /*P*/ Int128PTy = org.llvm.ir.Type.getIntNPtrTy($this().getLLVMContext(), 128);
      Value /*P*/ Ptr = $this().Builder.CreateBitCast($this().EmitScalarExpr(E.getArg$Const(0)), Int128PTy);
      return $this().Builder.CreateDefaultAlignedLoad(Ptr);
    }
   case NEON.BI__builtin_neon_vstrq_p128:
    {
      org.llvm.ir.Type /*P*/ Int128PTy = org.llvm.ir.Type.getIntNPtrTy($this().getLLVMContext(), 128);
      Value /*P*/ Ptr = $this().Builder.CreateBitCast(Ops.$at(0), Int128PTy);
      return $this().Builder.CreateDefaultAlignedStore($this().EmitScalarExpr(E.getArg$Const(1)), Ptr);
    }
   case NEON.BI__builtin_neon_vcvts_u32_f32:
   case NEON.BI__builtin_neon_vcvtd_u64_f64:
    usgn = true;
   case NEON.BI__builtin_neon_vcvts_s32_f32:
   case NEON.BI__builtin_neon_vcvtd_s64_f64:
    {
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      boolean Is64 = Ops.$at(0).getType().getPrimitiveSizeInBits() == 64;
      org.llvm.ir.Type /*P*/ InTy = Is64 ? Int64Ty : Int32Ty;
      org.llvm.ir.Type /*P*/ FTy = Is64 ? DoubleTy : FloatTy;
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), FTy));
      if (usgn) {
        return $this().Builder.CreateFPToUI(Ops.$at(0), InTy);
      }
      return $this().Builder.CreateFPToSI(Ops.$at(0), InTy);
    }
   case NEON.BI__builtin_neon_vcvts_f32_u32:
   case NEON.BI__builtin_neon_vcvtd_f64_u64:
    usgn = true;
   case NEON.BI__builtin_neon_vcvts_f32_s32:
   case NEON.BI__builtin_neon_vcvtd_f64_s64:
    {
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      boolean Is64 = Ops.$at(0).getType().getPrimitiveSizeInBits() == 64;
      org.llvm.ir.Type /*P*/ InTy = Is64 ? Int64Ty : Int32Ty;
      org.llvm.ir.Type /*P*/ FTy = Is64 ? DoubleTy : FloatTy;
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), InTy));
      if (usgn) {
        return $this().Builder.CreateUIToFP(Ops.$at(0), FTy);
      }
      return $this().Builder.CreateSIToFP(Ops.$at(0), FTy);
    }
   case NEON.BI__builtin_neon_vpaddd_s64:
    {
      org.llvm.ir.Type /*P*/ Ty = org.llvm.ir.VectorType.get(Int64Ty, 2);
      Value /*P*/ Vec = $this().EmitScalarExpr(E.getArg$Const(0));
      // The vector is v2f64, so make sure it's bitcast to that.
      Vec = $this().Builder.CreateBitCast(Vec, Ty, new Twine(/*KEEP_STR*/"v2i64"));
      Value /*P*/ Idx0 = ConstantInt.get(Unnamed_field8.SizeTy, $int2ulong(0));
      Value /*P*/ Idx1 = ConstantInt.get(Unnamed_field8.SizeTy, $int2ulong(1));
      Value /*P*/ Op0 = $this().Builder.CreateExtractElement(Vec, Idx0, new Twine(/*KEEP_STR*/"lane0"));
      Value /*P*/ Op1 = $this().Builder.CreateExtractElement(Vec, Idx1, new Twine(/*KEEP_STR*/"lane1"));
      // Pairwise addition of a v2f64 into a scalar f64.
      return $this().Builder.CreateAdd(Op0, Op1, new Twine(/*KEEP_STR*/"vpaddd"));
    }
   case NEON.BI__builtin_neon_vpaddd_f64:
    {
      org.llvm.ir.Type /*P*/ Ty = org.llvm.ir.VectorType.get(DoubleTy, 2);
      Value /*P*/ Vec = $this().EmitScalarExpr(E.getArg$Const(0));
      // The vector is v2f64, so make sure it's bitcast to that.
      Vec = $this().Builder.CreateBitCast(Vec, Ty, new Twine(/*KEEP_STR*/"v2f64"));
      Value /*P*/ Idx0 = ConstantInt.get(Unnamed_field8.SizeTy, $int2ulong(0));
      Value /*P*/ Idx1 = ConstantInt.get(Unnamed_field8.SizeTy, $int2ulong(1));
      Value /*P*/ Op0 = $this().Builder.CreateExtractElement(Vec, Idx0, new Twine(/*KEEP_STR*/"lane0"));
      Value /*P*/ Op1 = $this().Builder.CreateExtractElement(Vec, Idx1, new Twine(/*KEEP_STR*/"lane1"));
      // Pairwise addition of a v2f64 into a scalar f64.
      return $this().Builder.CreateFAdd(Op0, Op1, new Twine(/*KEEP_STR*/"vpaddd"));
    }
   case NEON.BI__builtin_neon_vpadds_f32:
    {
      org.llvm.ir.Type /*P*/ Ty = org.llvm.ir.VectorType.get(FloatTy, 2);
      Value /*P*/ Vec = $this().EmitScalarExpr(E.getArg$Const(0));
      // The vector is v2f32, so make sure it's bitcast to that.
      Vec = $this().Builder.CreateBitCast(Vec, Ty, new Twine(/*KEEP_STR*/"v2f32"));
      Value /*P*/ Idx0 = ConstantInt.get(Unnamed_field8.SizeTy, $int2ulong(0));
      Value /*P*/ Idx1 = ConstantInt.get(Unnamed_field8.SizeTy, $int2ulong(1));
      Value /*P*/ Op0 = $this().Builder.CreateExtractElement(Vec, Idx0, new Twine(/*KEEP_STR*/"lane0"));
      Value /*P*/ Op1 = $this().Builder.CreateExtractElement(Vec, Idx1, new Twine(/*KEEP_STR*/"lane1"));
      // Pairwise addition of a v2f32 into a scalar f32.
      return $this().Builder.CreateFAdd(Op0, Op1, new Twine(/*KEEP_STR*/"vpaddd"));
    }
   case NEON.BI__builtin_neon_vceqzd_s64:
   case NEON.BI__builtin_neon_vceqzd_f64:
   case NEON.BI__builtin_neon_vceqzs_f32:
    Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
    return $this().EmitAArch64CompareBuiltinExpr(Ops.$at(0), $this().ConvertType(E.getCallReturnType($this().getContext())), 
        ICmpInst.Predicate.FCMP_OEQ, ICmpInst.Predicate.ICMP_EQ, new Twine(/*KEEP_STR*/"vceqz"));
   case NEON.BI__builtin_neon_vcgezd_s64:
   case NEON.BI__builtin_neon_vcgezd_f64:
   case NEON.BI__builtin_neon_vcgezs_f32:
    Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
    return $this().EmitAArch64CompareBuiltinExpr(Ops.$at(0), $this().ConvertType(E.getCallReturnType($this().getContext())), 
        ICmpInst.Predicate.FCMP_OGE, ICmpInst.Predicate.ICMP_SGE, new Twine(/*KEEP_STR*/"vcgez"));
   case NEON.BI__builtin_neon_vclezd_s64:
   case NEON.BI__builtin_neon_vclezd_f64:
   case NEON.BI__builtin_neon_vclezs_f32:
    Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
    return $this().EmitAArch64CompareBuiltinExpr(Ops.$at(0), $this().ConvertType(E.getCallReturnType($this().getContext())), 
        ICmpInst.Predicate.FCMP_OLE, ICmpInst.Predicate.ICMP_SLE, new Twine(/*KEEP_STR*/"vclez"));
   case NEON.BI__builtin_neon_vcgtzd_s64:
   case NEON.BI__builtin_neon_vcgtzd_f64:
   case NEON.BI__builtin_neon_vcgtzs_f32:
    Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
    return $this().EmitAArch64CompareBuiltinExpr(Ops.$at(0), $this().ConvertType(E.getCallReturnType($this().getContext())), 
        ICmpInst.Predicate.FCMP_OGT, ICmpInst.Predicate.ICMP_SGT, new Twine(/*KEEP_STR*/"vcgtz"));
   case NEON.BI__builtin_neon_vcltzd_s64:
   case NEON.BI__builtin_neon_vcltzd_f64:
   case NEON.BI__builtin_neon_vcltzs_f32:
    Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
    return $this().EmitAArch64CompareBuiltinExpr(Ops.$at(0), $this().ConvertType(E.getCallReturnType($this().getContext())), 
        ICmpInst.Predicate.FCMP_OLT, ICmpInst.Predicate.ICMP_SLT, new Twine(/*KEEP_STR*/"vcltz"));
   case NEON.BI__builtin_neon_vceqzd_u64:
    {
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Int64Ty));
      Ops.$set(0, 
        $this().Builder.CreateICmpEQ(Ops.$at(0), Constant.getNullValue(Int64Ty)));
      return $this().Builder.CreateSExt(Ops.$at(0), Int64Ty, new Twine(/*KEEP_STR*/"vceqzd"));
    }
   case NEON.BI__builtin_neon_vceqd_f64:
   case NEON.BI__builtin_neon_vcled_f64:
   case NEON.BI__builtin_neon_vcltd_f64:
   case NEON.BI__builtin_neon_vcged_f64:
   case NEON.BI__builtin_neon_vcgtd_f64:
    {
      CmpInst.Predicate P;
      switch (BuiltinID) {
       default:
        throw new llvm_unreachable("missing builtin ID in switch!");
       case NEON.BI__builtin_neon_vceqd_f64:
        P = FCmpInst.Predicate.FCMP_OEQ;
        break;
       case NEON.BI__builtin_neon_vcled_f64:
        P = FCmpInst.Predicate.FCMP_OLE;
        break;
       case NEON.BI__builtin_neon_vcltd_f64:
        P = FCmpInst.Predicate.FCMP_OLT;
        break;
       case NEON.BI__builtin_neon_vcged_f64:
        P = FCmpInst.Predicate.FCMP_OGE;
        break;
       case NEON.BI__builtin_neon_vcgtd_f64:
        P = FCmpInst.Predicate.FCMP_OGT;
        break;
      }
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(1)));
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), DoubleTy));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), DoubleTy));
      Ops.$set(0, $this().Builder.CreateFCmp(P, Ops.$at(0), Ops.$at(1)));
      return $this().Builder.CreateSExt(Ops.$at(0), Int64Ty, new Twine(/*KEEP_STR*/"vcmpd"));
    }
   case NEON.BI__builtin_neon_vceqs_f32:
   case NEON.BI__builtin_neon_vcles_f32:
   case NEON.BI__builtin_neon_vclts_f32:
   case NEON.BI__builtin_neon_vcges_f32:
   case NEON.BI__builtin_neon_vcgts_f32:
    {
      CmpInst.Predicate P;
      switch (BuiltinID) {
       default:
        throw new llvm_unreachable("missing builtin ID in switch!");
       case NEON.BI__builtin_neon_vceqs_f32:
        P = FCmpInst.Predicate.FCMP_OEQ;
        break;
       case NEON.BI__builtin_neon_vcles_f32:
        P = FCmpInst.Predicate.FCMP_OLE;
        break;
       case NEON.BI__builtin_neon_vclts_f32:
        P = FCmpInst.Predicate.FCMP_OLT;
        break;
       case NEON.BI__builtin_neon_vcges_f32:
        P = FCmpInst.Predicate.FCMP_OGE;
        break;
       case NEON.BI__builtin_neon_vcgts_f32:
        P = FCmpInst.Predicate.FCMP_OGT;
        break;
      }
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(1)));
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), FloatTy));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), FloatTy));
      Ops.$set(0, $this().Builder.CreateFCmp(P, Ops.$at(0), Ops.$at(1)));
      return $this().Builder.CreateSExt(Ops.$at(0), Int32Ty, new Twine(/*KEEP_STR*/"vcmpd"));
    }
   case NEON.BI__builtin_neon_vceqd_s64:
   case NEON.BI__builtin_neon_vceqd_u64:
   case NEON.BI__builtin_neon_vcgtd_s64:
   case NEON.BI__builtin_neon_vcgtd_u64:
   case NEON.BI__builtin_neon_vcltd_s64:
   case NEON.BI__builtin_neon_vcltd_u64:
   case NEON.BI__builtin_neon_vcged_u64:
   case NEON.BI__builtin_neon_vcged_s64:
   case NEON.BI__builtin_neon_vcled_u64:
   case NEON.BI__builtin_neon_vcled_s64:
    {
      CmpInst.Predicate P;
      switch (BuiltinID) {
       default:
        throw new llvm_unreachable("missing builtin ID in switch!");
       case NEON.BI__builtin_neon_vceqd_s64:
       case NEON.BI__builtin_neon_vceqd_u64:
        P = ICmpInst.Predicate.ICMP_EQ;
        break;
       case NEON.BI__builtin_neon_vcgtd_s64:
        P = ICmpInst.Predicate.ICMP_SGT;
        break;
       case NEON.BI__builtin_neon_vcgtd_u64:
        P = ICmpInst.Predicate.ICMP_UGT;
        break;
       case NEON.BI__builtin_neon_vcltd_s64:
        P = ICmpInst.Predicate.ICMP_SLT;
        break;
       case NEON.BI__builtin_neon_vcltd_u64:
        P = ICmpInst.Predicate.ICMP_ULT;
        break;
       case NEON.BI__builtin_neon_vcged_u64:
        P = ICmpInst.Predicate.ICMP_UGE;
        break;
       case NEON.BI__builtin_neon_vcged_s64:
        P = ICmpInst.Predicate.ICMP_SGE;
        break;
       case NEON.BI__builtin_neon_vcled_u64:
        P = ICmpInst.Predicate.ICMP_ULE;
        break;
       case NEON.BI__builtin_neon_vcled_s64:
        P = ICmpInst.Predicate.ICMP_SLE;
        break;
      }
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(1)));
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Int64Ty));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Int64Ty));
      Ops.$set(0, $this().Builder.CreateICmp(P, Ops.$at(0), Ops.$at(1)));
      return $this().Builder.CreateSExt(Ops.$at(0), Int64Ty, new Twine(/*KEEP_STR*/"vceqd"));
    }
   case NEON.BI__builtin_neon_vtstd_s64:
   case NEON.BI__builtin_neon_vtstd_u64:
    {
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(1)));
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Int64Ty));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Int64Ty));
      Ops.$set(0, $this().Builder.CreateAnd(Ops.$at(0), Ops.$at(1)));
      Ops.$set(0, $this().Builder.CreateICmp(ICmpInst.Predicate.ICMP_NE, Ops.$at(0), 
          Constant.getNullValue(Int64Ty)));
      return $this().Builder.CreateSExt(Ops.$at(0), Int64Ty, new Twine(/*KEEP_STR*/"vtstd"));
    }
   case NEON.BI__builtin_neon_vset_lane_i8:
   case NEON.BI__builtin_neon_vset_lane_i16:
   case NEON.BI__builtin_neon_vset_lane_i32:
   case NEON.BI__builtin_neon_vset_lane_i64:
   case NEON.BI__builtin_neon_vset_lane_f32:
   case NEON.BI__builtin_neon_vsetq_lane_i8:
   case NEON.BI__builtin_neon_vsetq_lane_i16:
   case NEON.BI__builtin_neon_vsetq_lane_i32:
   case NEON.BI__builtin_neon_vsetq_lane_i64:
   case NEON.BI__builtin_neon_vsetq_lane_f32:
    Ops.push_back($this().EmitScalarExpr(E.getArg$Const(2)));
    return $this().Builder.CreateInsertElement(Ops.$at(1), Ops.$at(0), Ops.$at(2), new Twine(/*KEEP_STR*/"vset_lane"));
   case NEON.BI__builtin_neon_vset_lane_f64:
    // The vector type needs a cast for the v1f64 variant.
    Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), 
        org.llvm.ir.VectorType.get(DoubleTy, 1)));
    Ops.push_back($this().EmitScalarExpr(E.getArg$Const(2)));
    return $this().Builder.CreateInsertElement(Ops.$at(1), Ops.$at(0), Ops.$at(2), new Twine(/*KEEP_STR*/"vset_lane"));
   case NEON.BI__builtin_neon_vsetq_lane_f64:
    // The vector type needs a cast for the v2f64 variant.
    Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), 
        org.llvm.ir.VectorType.get(DoubleTy, 2)));
    Ops.push_back($this().EmitScalarExpr(E.getArg$Const(2)));
    return $this().Builder.CreateInsertElement(Ops.$at(1), Ops.$at(0), Ops.$at(2), new Twine(/*KEEP_STR*/"vset_lane"));
   case NEON.BI__builtin_neon_vget_lane_i8:
   case NEON.BI__builtin_neon_vdupb_lane_i8:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), org.llvm.ir.VectorType.get(Int8Ty, 8)));
    return $this().Builder.CreateExtractElement(Ops.$at(0), $this().EmitScalarExpr(E.getArg$Const(1)), 
        new Twine(/*KEEP_STR*/"vget_lane"));
   case NEON.BI__builtin_neon_vgetq_lane_i8:
   case NEON.BI__builtin_neon_vdupb_laneq_i8:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), org.llvm.ir.VectorType.get(Int8Ty, 16)));
    return $this().Builder.CreateExtractElement(Ops.$at(0), $this().EmitScalarExpr(E.getArg$Const(1)), 
        new Twine(/*KEEP_STR*/"vgetq_lane"));
   case NEON.BI__builtin_neon_vget_lane_i16:
   case NEON.BI__builtin_neon_vduph_lane_i16:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), org.llvm.ir.VectorType.get(Int16Ty, 4)));
    return $this().Builder.CreateExtractElement(Ops.$at(0), $this().EmitScalarExpr(E.getArg$Const(1)), 
        new Twine(/*KEEP_STR*/"vget_lane"));
   case NEON.BI__builtin_neon_vgetq_lane_i16:
   case NEON.BI__builtin_neon_vduph_laneq_i16:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), org.llvm.ir.VectorType.get(Int16Ty, 8)));
    return $this().Builder.CreateExtractElement(Ops.$at(0), $this().EmitScalarExpr(E.getArg$Const(1)), 
        new Twine(/*KEEP_STR*/"vgetq_lane"));
   case NEON.BI__builtin_neon_vget_lane_i32:
   case NEON.BI__builtin_neon_vdups_lane_i32:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), org.llvm.ir.VectorType.get(Int32Ty, 2)));
    return $this().Builder.CreateExtractElement(Ops.$at(0), $this().EmitScalarExpr(E.getArg$Const(1)), 
        new Twine(/*KEEP_STR*/"vget_lane"));
   case NEON.BI__builtin_neon_vdups_lane_f32:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), 
        org.llvm.ir.VectorType.get(FloatTy, 2)));
    return $this().Builder.CreateExtractElement(Ops.$at(0), $this().EmitScalarExpr(E.getArg$Const(1)), 
        new Twine(/*KEEP_STR*/"vdups_lane"));
   case NEON.BI__builtin_neon_vgetq_lane_i32:
   case NEON.BI__builtin_neon_vdups_laneq_i32:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), org.llvm.ir.VectorType.get(Int32Ty, 4)));
    return $this().Builder.CreateExtractElement(Ops.$at(0), $this().EmitScalarExpr(E.getArg$Const(1)), 
        new Twine(/*KEEP_STR*/"vgetq_lane"));
   case NEON.BI__builtin_neon_vget_lane_i64:
   case NEON.BI__builtin_neon_vdupd_lane_i64:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), org.llvm.ir.VectorType.get(Int64Ty, 1)));
    return $this().Builder.CreateExtractElement(Ops.$at(0), $this().EmitScalarExpr(E.getArg$Const(1)), 
        new Twine(/*KEEP_STR*/"vget_lane"));
   case NEON.BI__builtin_neon_vdupd_lane_f64:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), 
        org.llvm.ir.VectorType.get(DoubleTy, 1)));
    return $this().Builder.CreateExtractElement(Ops.$at(0), $this().EmitScalarExpr(E.getArg$Const(1)), 
        new Twine(/*KEEP_STR*/"vdupd_lane"));
   case NEON.BI__builtin_neon_vgetq_lane_i64:
   case NEON.BI__builtin_neon_vdupd_laneq_i64:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), org.llvm.ir.VectorType.get(Int64Ty, 2)));
    return $this().Builder.CreateExtractElement(Ops.$at(0), $this().EmitScalarExpr(E.getArg$Const(1)), 
        new Twine(/*KEEP_STR*/"vgetq_lane"));
   case NEON.BI__builtin_neon_vget_lane_f32:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), 
        org.llvm.ir.VectorType.get(FloatTy, 2)));
    return $this().Builder.CreateExtractElement(Ops.$at(0), $this().EmitScalarExpr(E.getArg$Const(1)), 
        new Twine(/*KEEP_STR*/"vget_lane"));
   case NEON.BI__builtin_neon_vget_lane_f64:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), 
        org.llvm.ir.VectorType.get(DoubleTy, 1)));
    return $this().Builder.CreateExtractElement(Ops.$at(0), $this().EmitScalarExpr(E.getArg$Const(1)), 
        new Twine(/*KEEP_STR*/"vget_lane"));
   case NEON.BI__builtin_neon_vgetq_lane_f32:
   case NEON.BI__builtin_neon_vdups_laneq_f32:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), 
        org.llvm.ir.VectorType.get(FloatTy, 4)));
    return $this().Builder.CreateExtractElement(Ops.$at(0), $this().EmitScalarExpr(E.getArg$Const(1)), 
        new Twine(/*KEEP_STR*/"vgetq_lane"));
   case NEON.BI__builtin_neon_vgetq_lane_f64:
   case NEON.BI__builtin_neon_vdupd_laneq_f64:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), 
        org.llvm.ir.VectorType.get(DoubleTy, 2)));
    return $this().Builder.CreateExtractElement(Ops.$at(0), $this().EmitScalarExpr(E.getArg$Const(1)), 
        new Twine(/*KEEP_STR*/"vgetq_lane"));
   case NEON.BI__builtin_neon_vaddd_s64:
   case NEON.BI__builtin_neon_vaddd_u64:
    return $this().Builder.CreateAdd(Ops.$at(0), $this().EmitScalarExpr(E.getArg$Const(1)), new Twine(/*KEEP_STR*/"vaddd"));
   case NEON.BI__builtin_neon_vsubd_s64:
   case NEON.BI__builtin_neon_vsubd_u64:
    return $this().Builder.CreateSub(Ops.$at(0), $this().EmitScalarExpr(E.getArg$Const(1)), new Twine(/*KEEP_STR*/"vsubd"));
   case NEON.BI__builtin_neon_vqdmlalh_s16:
   case NEON.BI__builtin_neon_vqdmlslh_s16:
    {
      SmallVector<Value /*P*/ > ProductOps/*J*/= new SmallVector<Value /*P*/ >(2, (Value /*P*/ )null);
      ProductOps.push_back($this().vectorWrapScalar16(Ops.$at(1)));
      ProductOps.push_back($this().vectorWrapScalar16($this().EmitScalarExpr(E.getArg$Const(2))));
      Type /*P*/ VTy = VectorType.get(Int32Ty, 4);
      Ops.$set(1, $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_sqdmull, new ArrayRef<Type /*P*/ >(VTy, true)), 
          ProductOps, $("vqdmlXl")));
      Constant /*P*/ CI = ConstantInt.get(Unnamed_field8.SizeTy, $int2ulong(0));
      Ops.$set(1, $this().Builder.CreateExtractElement(Ops.$at(1), CI, new Twine(/*KEEP_STR*/"lane0")));
      
      /*uint*/int AccumInt = BuiltinID == NEON.BI__builtin_neon_vqdmlalh_s16 ? ID.aarch64_neon_sqadd : ID.aarch64_neon_sqsub;
      return $this().EmitNeonCall($this().CGM.getIntrinsic(AccumInt, new ArrayRef<Type /*P*/ >(Int32Ty, true)), Ops, $("vqdmlXl"));
    }
   case NEON.BI__builtin_neon_vqshlud_n_s64:
    {
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(1)));
      Ops.$set(1, $this().Builder.CreateZExt(Ops.$at(1), Int64Ty));
      return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_sqshlu, new ArrayRef<Type /*P*/ >(Int64Ty, true)), 
          Ops, $("vqshlu_n"));
    }
   case NEON.BI__builtin_neon_vqshld_n_u64:
   case NEON.BI__builtin_neon_vqshld_n_s64:
    {
      /*uint*/int Int = BuiltinID == NEON.BI__builtin_neon_vqshld_n_u64 ? ID.aarch64_neon_uqshl : ID.aarch64_neon_sqshl;
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(1)));
      Ops.$set(1, $this().Builder.CreateZExt(Ops.$at(1), Int64Ty));
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Int64Ty, true)), Ops, $("vqshl_n"));
    }
   case NEON.BI__builtin_neon_vrshrd_n_u64:
   case NEON.BI__builtin_neon_vrshrd_n_s64:
    {
      /*uint*/int Int = BuiltinID == NEON.BI__builtin_neon_vrshrd_n_u64 ? ID.aarch64_neon_urshl : ID.aarch64_neon_srshl;
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(1)));
      int SV = (int)IrRTTI.cast_ConstantInt(Ops.$at(1)).getSExtValue();
      Ops.$set(1, ConstantInt.get(Int64Ty, $int2ulong(-SV)));
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Int64Ty, true)), Ops, $("vrshr_n"));
    }
   case NEON.BI__builtin_neon_vrsrad_n_u64:
   case NEON.BI__builtin_neon_vrsrad_n_s64:
    {
      /*uint*/int Int = BuiltinID == NEON.BI__builtin_neon_vrsrad_n_u64 ? ID.aarch64_neon_urshl : ID.aarch64_neon_srshl;
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Int64Ty));
      Ops.push_back($this().Builder.CreateNeg($this().EmitScalarExpr(E.getArg$Const(2))));
      Ops.$set(1, $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Int64Ty, true)), 
          /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Ops.$at(1), $this().Builder.CreateSExt(Ops.$at(2), Int64Ty)}, true)/* }*/));
      return $this().Builder.CreateAdd(Ops.$at(0), $this().Builder.CreateBitCast(Ops.$at(1), Int64Ty));
    }
   case NEON.BI__builtin_neon_vshld_n_s64:
   case NEON.BI__builtin_neon_vshld_n_u64:
    {
      ConstantInt /*P*/ Amt = IrRTTI.cast_ConstantInt($this().EmitScalarExpr(E.getArg$Const(1)));
      return $this().Builder.CreateShl(Ops.$at(0), ConstantInt.get(Int64Ty, Amt.getZExtValue()), new Twine(/*KEEP_STR*/"shld_n"));
    }
   case NEON.BI__builtin_neon_vshrd_n_s64:
    {
      ConstantInt /*P*/ Amt = IrRTTI.cast_ConstantInt($this().EmitScalarExpr(E.getArg$Const(1)));
      return $this().Builder.CreateAShr(Ops.$at(0), ConstantInt.get(Int64Ty, std.min(((/*static_cast*/long/*uint64_t*/)($int2ulong(63))), 
                  Amt.getZExtValue())), 
          new Twine(/*KEEP_STR*/"shrd_n"));
    }
   case NEON.BI__builtin_neon_vshrd_n_u64:
    {
      ConstantInt /*P*/ Amt = IrRTTI.cast_ConstantInt($this().EmitScalarExpr(E.getArg$Const(1)));
      long/*uint64_t*/ ShiftAmt = Amt.getZExtValue();
      // Right-shifting an unsigned value by its size yields 0.
      if (ShiftAmt == $int2ullong(64)) {
        return ConstantInt.get(Int64Ty, $int2ulong(0));
      }
      return $this().Builder.CreateLShr(Ops.$at(0), ConstantInt.get(Int64Ty, ShiftAmt), 
          new Twine(/*KEEP_STR*/"shrd_n"));
    }
   case NEON.BI__builtin_neon_vsrad_n_s64:
    {
      ConstantInt /*P*/ Amt = IrRTTI.cast_ConstantInt($this().EmitScalarExpr(E.getArg$Const(2)));
      Ops.$set(1, $this().Builder.CreateAShr(Ops.$at(1), ConstantInt.get(Int64Ty, std.min(((/*static_cast*/long/*uint64_t*/)($int2ulong(63))), 
                  Amt.getZExtValue())), 
          new Twine(/*KEEP_STR*/"shrd_n")));
      return $this().Builder.CreateAdd(Ops.$at(0), Ops.$at(1));
    }
   case NEON.BI__builtin_neon_vsrad_n_u64:
    {
      ConstantInt /*P*/ Amt = IrRTTI.cast_ConstantInt($this().EmitScalarExpr(E.getArg$Const(2)));
      long/*uint64_t*/ ShiftAmt = Amt.getZExtValue();
      // Right-shifting an unsigned value by its size yields 0.
      // As Op + 0 = Op, return Ops[0] directly.
      if (ShiftAmt == $int2ullong(64)) {
        return Ops.$at(0);
      }
      Ops.$set(1, $this().Builder.CreateLShr(Ops.$at(1), ConstantInt.get(Int64Ty, ShiftAmt), 
          new Twine(/*KEEP_STR*/"shrd_n")));
      return $this().Builder.CreateAdd(Ops.$at(0), Ops.$at(1));
    }
   case NEON.BI__builtin_neon_vqdmlalh_lane_s16:
   case NEON.BI__builtin_neon_vqdmlalh_laneq_s16:
   case NEON.BI__builtin_neon_vqdmlslh_lane_s16:
   case NEON.BI__builtin_neon_vqdmlslh_laneq_s16:
    {
      Ops.$set(2, $this().Builder.CreateExtractElement(Ops.$at(2), $this().EmitScalarExpr(E.getArg$Const(3)), 
          new Twine(/*KEEP_STR*/"lane")));
      SmallVector<Value /*P*/ > ProductOps/*J*/= new SmallVector<Value /*P*/ >(2, (Value /*P*/ )null);
      ProductOps.push_back($this().vectorWrapScalar16(Ops.$at(1)));
      ProductOps.push_back($this().vectorWrapScalar16(Ops.$at(2)));
      Type /*P*/ VTy = VectorType.get(Int32Ty, 4);
      Ops.$set(1, $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_sqdmull, new ArrayRef<Type /*P*/ >(VTy, true)), 
          ProductOps, $("vqdmlXl")));
      Constant /*P*/ CI = ConstantInt.get(Unnamed_field8.SizeTy, $int2ulong(0));
      Ops.$set(1, $this().Builder.CreateExtractElement(Ops.$at(1), CI, new Twine(/*KEEP_STR*/"lane0")));
      Ops.pop_back();
      
      /*uint*/int AccInt = (BuiltinID == NEON.BI__builtin_neon_vqdmlalh_lane_s16
         || BuiltinID == NEON.BI__builtin_neon_vqdmlalh_laneq_s16) ? ID.aarch64_neon_sqadd : ID.aarch64_neon_sqsub;
      return $this().EmitNeonCall($this().CGM.getIntrinsic(AccInt, new ArrayRef<Type /*P*/ >(Int32Ty, true)), Ops, $("vqdmlXl"));
    }
   case NEON.BI__builtin_neon_vqdmlals_s32:
   case NEON.BI__builtin_neon_vqdmlsls_s32:
    {
      SmallVector<Value /*P*/ > ProductOps/*J*/= new SmallVector<Value /*P*/ >(2, (Value /*P*/ )null);
      ProductOps.push_back(Ops.$at(1));
      ProductOps.push_back($this().EmitScalarExpr(E.getArg$Const(2)));
      Ops.$set(1, 
        $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_sqdmulls_scalar), 
          ProductOps, $("vqdmlXl")));
      
      /*uint*/int AccumInt = BuiltinID == NEON.BI__builtin_neon_vqdmlals_s32 ? ID.aarch64_neon_sqadd : ID.aarch64_neon_sqsub;
      return $this().EmitNeonCall($this().CGM.getIntrinsic(AccumInt, new ArrayRef<Type /*P*/ >(Int64Ty, true)), Ops, $("vqdmlXl"));
    }
   case NEON.BI__builtin_neon_vqdmlals_lane_s32:
   case NEON.BI__builtin_neon_vqdmlals_laneq_s32:
   case NEON.BI__builtin_neon_vqdmlsls_lane_s32:
   case NEON.BI__builtin_neon_vqdmlsls_laneq_s32:
    {
      Ops.$set(2, $this().Builder.CreateExtractElement(Ops.$at(2), $this().EmitScalarExpr(E.getArg$Const(3)), 
          new Twine(/*KEEP_STR*/"lane")));
      SmallVector<Value /*P*/ > ProductOps/*J*/= new SmallVector<Value /*P*/ >(2, (Value /*P*/ )null);
      ProductOps.push_back(Ops.$at(1));
      ProductOps.push_back(Ops.$at(2));
      Ops.$set(1, 
        $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_sqdmulls_scalar), 
          ProductOps, $("vqdmlXl")));
      Ops.pop_back();
      
      /*uint*/int AccInt = (BuiltinID == NEON.BI__builtin_neon_vqdmlals_lane_s32
         || BuiltinID == NEON.BI__builtin_neon_vqdmlals_laneq_s32) ? ID.aarch64_neon_sqadd : ID.aarch64_neon_sqsub;
      return $this().EmitNeonCall($this().CGM.getIntrinsic(AccInt, new ArrayRef<Type /*P*/ >(Int64Ty, true)), Ops, $("vqdmlXl"));
    }
  }
  
  org.llvm.ir.VectorType /*P*/ VTy = CGBuiltinStatics.GetNeonType($this(), new NeonTypeFlags(Type));
  org.llvm.ir.Type /*P*/ Ty = VTy;
  if (!(Ty != null)) {
    return null;
  }
  
  // Not all intrinsics handled by the common case work for AArch64 yet, so only
  // defer to common code if it's been added to our special map.
  Builtin = CGBuiltinStatics.findNeonIntrinsicInMap(new ArrayRef<NeonIntrinsicInfo>(CGBuiltinStatics.AArch64SIMDIntrinsicMap, false), BuiltinID, 
      CGBuiltinStatics.AArch64SIMDIntrinsicsProvenSorted_ref);
  if ((Builtin != null)) {
    return $this().EmitCommonNeonBuiltinExpr(Builtin.BuiltinID, Builtin.LLVMIntrinsic, Builtin.AltLLVMIntrinsic, 
        Builtin.NameHint, Builtin.TypeModifier, E, Ops, 
        /*never use addresses*/ Address.invalid(), Address.invalid());
  }
  {
    
    Value /*P*/ V = CGBuiltinStatics.EmitAArch64TblBuiltinExpr(/*Deref*/$this(), BuiltinID, E, Ops);
    if ((V != null)) {
      return V;
    }
  }
  
  /*uint*/int Int;
  switch (BuiltinID) {
   default:
    return null;
   case NEON.BI__builtin_neon_vbsl_v:
   case NEON.BI__builtin_neon_vbslq_v:
    {
      org.llvm.ir.Type /*P*/ BitTy = org.llvm.ir.VectorType.getInteger(VTy);
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), BitTy, new Twine(/*KEEP_STR*/"vbsl")));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), BitTy, new Twine(/*KEEP_STR*/"vbsl")));
      Ops.$set(2, $this().Builder.CreateBitCast(Ops.$at(2), BitTy, new Twine(/*KEEP_STR*/"vbsl")));
      
      Ops.$set(1, $this().Builder.CreateAnd(Ops.$at(0), Ops.$at(1), new Twine(/*KEEP_STR*/"vbsl")));
      Ops.$set(2, $this().Builder.CreateAnd($this().Builder.CreateNot(Ops.$at(0)), Ops.$at(2), new Twine(/*KEEP_STR*/"vbsl")));
      Ops.$set(0, $this().Builder.CreateOr(Ops.$at(1), Ops.$at(2), new Twine(/*KEEP_STR*/"vbsl")));
      return $this().Builder.CreateBitCast(Ops.$at(0), Ty);
    }
   case NEON.BI__builtin_neon_vfma_lane_v:
   case NEON.BI__builtin_neon_vfmaq_lane_v:
    { // Only used for FP types
      // The ARM builtins (and instructions) have the addend as the first
      // operand, but the 'fma' intrinsics have it last. Swap it around here.
      Value /*P*/ Addend = Ops.$at(0);
      Value /*P*/ Multiplicand = Ops.$at(1);
      Value /*P*/ LaneSource = Ops.$at(2);
      Ops.$set(0, Multiplicand);
      Ops.$set(1, LaneSource);
      Ops.$set(2, Addend);
      
      // Now adjust things to handle the lane access.
      Type /*P*/ SourceTy = BuiltinID == NEON.BI__builtin_neon_vfmaq_lane_v ? VectorType.get(VTy.getElementType(), $div_uint(VTy.getNumElements(), 2)) : VTy;
      Constant /*P*/ cst = IrRTTI.cast_Constant(Ops.$at(3));
      Value /*P*/ SV = ConstantVector.getSplat(VTy.getNumElements(), cst);
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), SourceTy));
      Ops.$set(1, $this().Builder.CreateShuffleVector(Ops.$at(1), Ops.$at(1), SV, new Twine(/*KEEP_STR*/"lane")));
      
      Ops.pop_back();
      Int = ID.fma;
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("fmla"));
    }
   case NEON.BI__builtin_neon_vfma_laneq_v:
    {
      VectorType /*P*/ VTy$1 = IrRTTI.cast_VectorType(Ty);
      // v1f64 fma should be mapped to Neon scalar f64 fma
      if ((VTy$1 != null) && VTy$1.getElementType() == DoubleTy) {
        Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), DoubleTy));
        Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), DoubleTy));
        Type /*P*/ VTy$2 = CGBuiltinStatics.GetNeonType($this(), 
            new NeonTypeFlags(NeonTypeFlags.EltType.Float64, false, true));
        Ops.$set(2, $this().Builder.CreateBitCast(Ops.$at(2), VTy$2));
        Ops.$set(2, $this().Builder.CreateExtractElement(Ops.$at(2), Ops.$at(3), new Twine(/*KEEP_STR*/"extract")));
        Value /*P*/ F = $this().CGM.getIntrinsic(ID.fma, new ArrayRef<Type /*P*/ >(DoubleTy, true));
        Value /*P*/ Result$1 = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {Ops.$at(1), Ops.$at(2), Ops.$at(0)}, true)/* }*/);
        return $this().Builder.CreateBitCast(Result$1, Ty);
      }
      Value /*P*/ F = $this().CGM.getIntrinsic(ID.fma, new ArrayRef<Type /*P*/ >(Ty, true));
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
      
      org.llvm.ir.Type /*P*/ STy = org.llvm.ir.VectorType.get(VTy$1.getElementType(), 
          VTy$1.getNumElements() * 2);
      Ops.$set(2, $this().Builder.CreateBitCast(Ops.$at(2), STy));
      Value /*P*/ SV = ConstantVector.getSplat(VTy$1.getNumElements(), 
          IrRTTI.cast_ConstantInt(Ops.$at(3)));
      Ops.$set(2, $this().Builder.CreateShuffleVector(Ops.$at(2), Ops.$at(2), SV, new Twine(/*KEEP_STR*/"lane")));
      
      return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {Ops.$at(2), Ops.$at(1), Ops.$at(0)}, true)/* }*/);
    }
   case NEON.BI__builtin_neon_vfmaq_laneq_v:
    {
      Value /*P*/ F = $this().CGM.getIntrinsic(ID.fma, new ArrayRef<Type /*P*/ >(Ty, true));
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
      
      Ops.$set(2, $this().Builder.CreateBitCast(Ops.$at(2), Ty));
      Ops.$set(2, $this().EmitNeonSplat(Ops.$at(2), IrRTTI.cast_ConstantInt(Ops.$at(3))));
      return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {Ops.$at(2), Ops.$at(1), Ops.$at(0)}, true)/* }*/);
    }
   case NEON.BI__builtin_neon_vfmas_lane_f32:
   case NEON.BI__builtin_neon_vfmas_laneq_f32:
   case NEON.BI__builtin_neon_vfmad_lane_f64:
   case NEON.BI__builtin_neon_vfmad_laneq_f64:
    {
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(3)));
      Type /*P*/ Ty$1 = $this().ConvertType(E.getCallReturnType($this().getContext()));
      Value /*P*/ F = $this().CGM.getIntrinsic(ID.fma, new ArrayRef<Type /*P*/ >(Ty$1, true));
      Ops.$set(2, $this().Builder.CreateExtractElement(Ops.$at(2), Ops.$at(3), new Twine(/*KEEP_STR*/"extract")));
      return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {Ops.$at(1), Ops.$at(2), Ops.$at(0)}, true)/* }*/);
    }
   case NEON.BI__builtin_neon_vmull_v:
    // FIXME: improve sharing scheme to cope with 3 alternative LLVM intrinsics.
    Int = usgn ? ID.aarch64_neon_umull : ID.aarch64_neon_smull;
    if (Type.isPoly()) {
      Int = ID.aarch64_neon_pmull;
    }
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vmull"));
   case NEON.BI__builtin_neon_vmax_v:
   case NEON.BI__builtin_neon_vmaxq_v:
    // FIXME: improve sharing scheme to cope with 3 alternative LLVM intrinsics.
    Int = usgn ? ID.aarch64_neon_umax : ID.aarch64_neon_smax;
    if (Ty.isFPOrFPVectorTy()) {
      Int = ID.aarch64_neon_fmax;
    }
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vmax"));
   case NEON.BI__builtin_neon_vmin_v:
   case NEON.BI__builtin_neon_vminq_v:
    // FIXME: improve sharing scheme to cope with 3 alternative LLVM intrinsics.
    Int = usgn ? ID.aarch64_neon_umin : ID.aarch64_neon_smin;
    if (Ty.isFPOrFPVectorTy()) {
      Int = ID.aarch64_neon_fmin;
    }
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vmin"));
   case NEON.BI__builtin_neon_vabd_v:
   case NEON.BI__builtin_neon_vabdq_v:
    // FIXME: improve sharing scheme to cope with 3 alternative LLVM intrinsics.
    Int = usgn ? ID.aarch64_neon_uabd : ID.aarch64_neon_sabd;
    if (Ty.isFPOrFPVectorTy()) {
      Int = ID.aarch64_neon_fabd;
    }
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vabd"));
   case NEON.BI__builtin_neon_vpadal_v:
   case NEON.BI__builtin_neon_vpadalq_v:
    {
      /*uint*/int ArgElts = VTy.getNumElements();
      IntegerType /*P*/ EltTy = IrRTTI.cast_IntegerType(VTy.getElementType());
      /*uint*/int BitWidth = EltTy.getBitWidth();
      Type /*P*/ ArgTy = VectorType.get(IntegerType.get($this().getLLVMContext(), $div_uint(BitWidth, 2)), 2 * ArgElts);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {VTy, ArgTy};
      Int = usgn ? ID.aarch64_neon_uaddlp : ID.aarch64_neon_saddlp;
      SmallVector<Value /*P*/ > TmpOps/*J*/= new SmallVector<Value /*P*/ >(1, (Value /*P*/ )null);
      TmpOps.push_back(Ops.$at(1));
      Function /*P*/ F = $this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true));
      Value /*P*/ tmp = $this().EmitNeonCall(F, TmpOps, $("vpadal"));
      Value /*P*/ addend = $this().Builder.CreateBitCast(Ops.$at(0), tmp.getType());
      return $this().Builder.CreateAdd(tmp, addend);
    }
   case NEON.BI__builtin_neon_vpmin_v:
   case NEON.BI__builtin_neon_vpminq_v:
    // FIXME: improve sharing scheme to cope with 3 alternative LLVM intrinsics.
    Int = usgn ? ID.aarch64_neon_uminp : ID.aarch64_neon_sminp;
    if (Ty.isFPOrFPVectorTy()) {
      Int = ID.aarch64_neon_fminp;
    }
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vpmin"));
   case NEON.BI__builtin_neon_vpmax_v:
   case NEON.BI__builtin_neon_vpmaxq_v:
    // FIXME: improve sharing scheme to cope with 3 alternative LLVM intrinsics.
    Int = usgn ? ID.aarch64_neon_umaxp : ID.aarch64_neon_smaxp;
    if (Ty.isFPOrFPVectorTy()) {
      Int = ID.aarch64_neon_fmaxp;
    }
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vpmax"));
   case NEON.BI__builtin_neon_vminnm_v:
   case NEON.BI__builtin_neon_vminnmq_v:
    Int = ID.aarch64_neon_fminnm;
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vminnm"));
   case NEON.BI__builtin_neon_vmaxnm_v:
   case NEON.BI__builtin_neon_vmaxnmq_v:
    Int = ID.aarch64_neon_fmaxnm;
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vmaxnm"));
   case NEON.BI__builtin_neon_vrecpss_f32:
    {
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(1)));
      return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_frecps, new ArrayRef<Type /*P*/ >(FloatTy, true)), 
          Ops, $("vrecps"));
    }
   case NEON.BI__builtin_neon_vrecpsd_f64:
    {
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(1)));
      return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_frecps, new ArrayRef<Type /*P*/ >(DoubleTy, true)), 
          Ops, $("vrecps"));
    }
   case NEON.BI__builtin_neon_vqshrun_n_v:
    Int = ID.aarch64_neon_sqshrun;
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vqshrun_n"));
   case NEON.BI__builtin_neon_vqrshrun_n_v:
    Int = ID.aarch64_neon_sqrshrun;
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vqrshrun_n"));
   case NEON.BI__builtin_neon_vqshrn_n_v:
    Int = usgn ? ID.aarch64_neon_uqshrn : ID.aarch64_neon_sqshrn;
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vqshrn_n"));
   case NEON.BI__builtin_neon_vrshrn_n_v:
    Int = ID.aarch64_neon_rshrn;
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vrshrn_n"));
   case NEON.BI__builtin_neon_vqrshrn_n_v:
    Int = usgn ? ID.aarch64_neon_uqrshrn : ID.aarch64_neon_sqrshrn;
    return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vqrshrn_n"));
   case NEON.BI__builtin_neon_vrnda_v:
   case NEON.BI__builtin_neon_vrndaq_v:
    {
      Int = ID.round;
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vrnda"));
    }
   case NEON.BI__builtin_neon_vrndi_v:
   case NEON.BI__builtin_neon_vrndiq_v:
    {
      Int = ID.nearbyint;
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vrndi"));
    }
   case NEON.BI__builtin_neon_vrndm_v:
   case NEON.BI__builtin_neon_vrndmq_v:
    {
      Int = ID.floor;
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vrndm"));
    }
   case NEON.BI__builtin_neon_vrndn_v:
   case NEON.BI__builtin_neon_vrndnq_v:
    {
      Int = ID.aarch64_neon_frintn;
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vrndn"));
    }
   case NEON.BI__builtin_neon_vrndp_v:
   case NEON.BI__builtin_neon_vrndpq_v:
    {
      Int = ID.ceil;
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vrndp"));
    }
   case NEON.BI__builtin_neon_vrndx_v:
   case NEON.BI__builtin_neon_vrndxq_v:
    {
      Int = ID.rint;
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vrndx"));
    }
   case NEON.BI__builtin_neon_vrnd_v:
   case NEON.BI__builtin_neon_vrndq_v:
    {
      Int = ID.trunc;
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vrndz"));
    }
   case NEON.BI__builtin_neon_vceqz_v:
   case NEON.BI__builtin_neon_vceqzq_v:
    return $this().EmitAArch64CompareBuiltinExpr(Ops.$at(0), Ty, ICmpInst.Predicate.FCMP_OEQ, 
        ICmpInst.Predicate.ICMP_EQ, new Twine(/*KEEP_STR*/"vceqz"));
   case NEON.BI__builtin_neon_vcgez_v:
   case NEON.BI__builtin_neon_vcgezq_v:
    return $this().EmitAArch64CompareBuiltinExpr(Ops.$at(0), Ty, ICmpInst.Predicate.FCMP_OGE, 
        ICmpInst.Predicate.ICMP_SGE, new Twine(/*KEEP_STR*/"vcgez"));
   case NEON.BI__builtin_neon_vclez_v:
   case NEON.BI__builtin_neon_vclezq_v:
    return $this().EmitAArch64CompareBuiltinExpr(Ops.$at(0), Ty, ICmpInst.Predicate.FCMP_OLE, 
        ICmpInst.Predicate.ICMP_SLE, new Twine(/*KEEP_STR*/"vclez"));
   case NEON.BI__builtin_neon_vcgtz_v:
   case NEON.BI__builtin_neon_vcgtzq_v:
    return $this().EmitAArch64CompareBuiltinExpr(Ops.$at(0), Ty, ICmpInst.Predicate.FCMP_OGT, 
        ICmpInst.Predicate.ICMP_SGT, new Twine(/*KEEP_STR*/"vcgtz"));
   case NEON.BI__builtin_neon_vcltz_v:
   case NEON.BI__builtin_neon_vcltzq_v:
    return $this().EmitAArch64CompareBuiltinExpr(Ops.$at(0), Ty, ICmpInst.Predicate.FCMP_OLT, 
        ICmpInst.Predicate.ICMP_SLT, new Twine(/*KEEP_STR*/"vcltz"));
   case NEON.BI__builtin_neon_vcvt_f64_v:
   case NEON.BI__builtin_neon_vcvtq_f64_v:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
    Ty = CGBuiltinStatics.GetNeonType($this(), new NeonTypeFlags(NeonTypeFlags.EltType.Float64, false, quad));
    return usgn ? $this().Builder.CreateUIToFP(Ops.$at(0), Ty, new Twine(/*KEEP_STR*/"vcvt")) : $this().Builder.CreateSIToFP(Ops.$at(0), Ty, new Twine(/*KEEP_STR*/"vcvt"));
   case NEON.BI__builtin_neon_vcvt_f64_f32:
    {
      assert (Type.getEltType() == NeonTypeFlags.EltType.Float64 && quad) : "unexpected vcvt_f64_f32 builtin";
      NeonTypeFlags SrcFlag = new NeonTypeFlags(NeonTypeFlags.EltType.Float32, false, false);
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), CGBuiltinStatics.GetNeonType($this(), new NeonTypeFlags(SrcFlag))));
      
      return $this().Builder.CreateFPExt(Ops.$at(0), Ty, new Twine(/*KEEP_STR*/"vcvt"));
    }
   case NEON.BI__builtin_neon_vcvt_f32_f64:
    {
      assert (Type.getEltType() == NeonTypeFlags.EltType.Float32) : "unexpected vcvt_f32_f64 builtin";
      NeonTypeFlags SrcFlag = new NeonTypeFlags(NeonTypeFlags.EltType.Float64, false, true);
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), CGBuiltinStatics.GetNeonType($this(), new NeonTypeFlags(SrcFlag))));
      
      return $this().Builder.CreateFPTrunc(Ops.$at(0), Ty, new Twine(/*KEEP_STR*/"vcvt"));
    }
   case NEON.BI__builtin_neon_vcvt_s32_v:
   case NEON.BI__builtin_neon_vcvt_u32_v:
   case NEON.BI__builtin_neon_vcvt_s64_v:
   case NEON.BI__builtin_neon_vcvt_u64_v:
   case NEON.BI__builtin_neon_vcvtq_s32_v:
   case NEON.BI__builtin_neon_vcvtq_u32_v:
   case NEON.BI__builtin_neon_vcvtq_s64_v:
   case NEON.BI__builtin_neon_vcvtq_u64_v:
    {
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), CGBuiltinStatics.GetFloatNeonType($this(), new NeonTypeFlags(Type))));
      if (usgn) {
        return $this().Builder.CreateFPToUI(Ops.$at(0), Ty);
      }
      return $this().Builder.CreateFPToSI(Ops.$at(0), Ty);
    }
   case NEON.BI__builtin_neon_vcvta_s32_v:
   case NEON.BI__builtin_neon_vcvtaq_s32_v:
   case NEON.BI__builtin_neon_vcvta_u32_v:
   case NEON.BI__builtin_neon_vcvtaq_u32_v:
   case NEON.BI__builtin_neon_vcvta_s64_v:
   case NEON.BI__builtin_neon_vcvtaq_s64_v:
   case NEON.BI__builtin_neon_vcvta_u64_v:
   case NEON.BI__builtin_neon_vcvtaq_u64_v:
    {
      Int = usgn ? ID.aarch64_neon_fcvtau : ID.aarch64_neon_fcvtas;
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, CGBuiltinStatics.GetFloatNeonType($this(), new NeonTypeFlags(Type))};
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vcvta"));
    }
   case NEON.BI__builtin_neon_vcvtm_s32_v:
   case NEON.BI__builtin_neon_vcvtmq_s32_v:
   case NEON.BI__builtin_neon_vcvtm_u32_v:
   case NEON.BI__builtin_neon_vcvtmq_u32_v:
   case NEON.BI__builtin_neon_vcvtm_s64_v:
   case NEON.BI__builtin_neon_vcvtmq_s64_v:
   case NEON.BI__builtin_neon_vcvtm_u64_v:
   case NEON.BI__builtin_neon_vcvtmq_u64_v:
    {
      Int = usgn ? ID.aarch64_neon_fcvtmu : ID.aarch64_neon_fcvtms;
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, CGBuiltinStatics.GetFloatNeonType($this(), new NeonTypeFlags(Type))};
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vcvtm"));
    }
   case NEON.BI__builtin_neon_vcvtn_s32_v:
   case NEON.BI__builtin_neon_vcvtnq_s32_v:
   case NEON.BI__builtin_neon_vcvtn_u32_v:
   case NEON.BI__builtin_neon_vcvtnq_u32_v:
   case NEON.BI__builtin_neon_vcvtn_s64_v:
   case NEON.BI__builtin_neon_vcvtnq_s64_v:
   case NEON.BI__builtin_neon_vcvtn_u64_v:
   case NEON.BI__builtin_neon_vcvtnq_u64_v:
    {
      Int = usgn ? ID.aarch64_neon_fcvtnu : ID.aarch64_neon_fcvtns;
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, CGBuiltinStatics.GetFloatNeonType($this(), new NeonTypeFlags(Type))};
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vcvtn"));
    }
   case NEON.BI__builtin_neon_vcvtp_s32_v:
   case NEON.BI__builtin_neon_vcvtpq_s32_v:
   case NEON.BI__builtin_neon_vcvtp_u32_v:
   case NEON.BI__builtin_neon_vcvtpq_u32_v:
   case NEON.BI__builtin_neon_vcvtp_s64_v:
   case NEON.BI__builtin_neon_vcvtpq_s64_v:
   case NEON.BI__builtin_neon_vcvtp_u64_v:
   case NEON.BI__builtin_neon_vcvtpq_u64_v:
    {
      Int = usgn ? ID.aarch64_neon_fcvtpu : ID.aarch64_neon_fcvtps;
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, CGBuiltinStatics.GetFloatNeonType($this(), new NeonTypeFlags(Type))};
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vcvtp"));
    }
   case NEON.BI__builtin_neon_vmulx_v:
   case NEON.BI__builtin_neon_vmulxq_v:
    {
      Int = ID.aarch64_neon_fmulx;
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vmulx"));
    }
   case NEON.BI__builtin_neon_vmul_lane_v:
   case NEON.BI__builtin_neon_vmul_laneq_v:
    {
      // v1f64 vmul_lane should be mapped to Neon scalar mul lane
      boolean Quad = false;
      if (BuiltinID == NEON.BI__builtin_neon_vmul_laneq_v) {
        Quad = true;
      }
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), DoubleTy));
      org.llvm.ir.Type /*P*/ VTy$1 = CGBuiltinStatics.GetNeonType($this(), 
          new NeonTypeFlags(NeonTypeFlags.EltType.Float64, false, Quad));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), VTy$1));
      Ops.$set(1, $this().Builder.CreateExtractElement(Ops.$at(1), Ops.$at(2), new Twine(/*KEEP_STR*/"extract")));
      Value /*P*/ Result$1 = $this().Builder.CreateFMul(Ops.$at(0), Ops.$at(1));
      return $this().Builder.CreateBitCast(Result$1, Ty);
    }
   case NEON.BI__builtin_neon_vnegd_s64:
    return $this().Builder.CreateNeg($this().EmitScalarExpr(E.getArg$Const(0)), new Twine(/*KEEP_STR*/"vnegd"));
   case NEON.BI__builtin_neon_vpmaxnm_v:
   case NEON.BI__builtin_neon_vpmaxnmq_v:
    {
      Int = ID.aarch64_neon_fmaxnmp;
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vpmaxnm"));
    }
   case NEON.BI__builtin_neon_vpminnm_v:
   case NEON.BI__builtin_neon_vpminnmq_v:
    {
      Int = ID.aarch64_neon_fminnmp;
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vpminnm"));
    }
   case NEON.BI__builtin_neon_vsqrt_v:
   case NEON.BI__builtin_neon_vsqrtq_v:
    {
      Int = ID.sqrt;
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vsqrt"));
    }
   case NEON.BI__builtin_neon_vrbit_v:
   case NEON.BI__builtin_neon_vrbitq_v:
    {
      Int = ID.aarch64_neon_rbit;
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vrbit"));
    }
   case NEON.BI__builtin_neon_vaddv_u8:
    // FIXME: These are handled by the AArch64 scalar code.
    usgn = true;
   case NEON.BI__builtin_neon_vaddv_s8:
    {
      Int = usgn ? ID.aarch64_neon_uaddv : ID.aarch64_neon_saddv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int8Ty, 8);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vaddv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int8Ty);
    }
   case NEON.BI__builtin_neon_vaddv_u16:
    usgn = true;
   case NEON.BI__builtin_neon_vaddv_s16:
    {
      Int = usgn ? ID.aarch64_neon_uaddv : ID.aarch64_neon_saddv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int16Ty, 4);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vaddv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int16Ty);
    }
   case NEON.BI__builtin_neon_vaddvq_u8:
    usgn = true;
   case NEON.BI__builtin_neon_vaddvq_s8:
    {
      Int = usgn ? ID.aarch64_neon_uaddv : ID.aarch64_neon_saddv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int8Ty, 16);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vaddv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int8Ty);
    }
   case NEON.BI__builtin_neon_vaddvq_u16:
    usgn = true;
   case NEON.BI__builtin_neon_vaddvq_s16:
    {
      Int = usgn ? ID.aarch64_neon_uaddv : ID.aarch64_neon_saddv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int16Ty, 8);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vaddv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int16Ty);
    }
   case NEON.BI__builtin_neon_vmaxv_u8:
    {
      Int = ID.aarch64_neon_umaxv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int8Ty, 8);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vmaxv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int8Ty);
    }
   case NEON.BI__builtin_neon_vmaxv_u16:
    {
      Int = ID.aarch64_neon_umaxv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int16Ty, 4);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vmaxv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int16Ty);
    }
   case NEON.BI__builtin_neon_vmaxvq_u8:
    {
      Int = ID.aarch64_neon_umaxv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int8Ty, 16);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vmaxv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int8Ty);
    }
   case NEON.BI__builtin_neon_vmaxvq_u16:
    {
      Int = ID.aarch64_neon_umaxv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int16Ty, 8);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vmaxv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int16Ty);
    }
   case NEON.BI__builtin_neon_vmaxv_s8:
    {
      Int = ID.aarch64_neon_smaxv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int8Ty, 8);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vmaxv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int8Ty);
    }
   case NEON.BI__builtin_neon_vmaxv_s16:
    {
      Int = ID.aarch64_neon_smaxv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int16Ty, 4);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vmaxv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int16Ty);
    }
   case NEON.BI__builtin_neon_vmaxvq_s8:
    {
      Int = ID.aarch64_neon_smaxv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int8Ty, 16);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vmaxv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int8Ty);
    }
   case NEON.BI__builtin_neon_vmaxvq_s16:
    {
      Int = ID.aarch64_neon_smaxv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int16Ty, 8);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vmaxv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int16Ty);
    }
   case NEON.BI__builtin_neon_vminv_u8:
    {
      Int = ID.aarch64_neon_uminv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int8Ty, 8);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vminv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int8Ty);
    }
   case NEON.BI__builtin_neon_vminv_u16:
    {
      Int = ID.aarch64_neon_uminv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int16Ty, 4);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vminv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int16Ty);
    }
   case NEON.BI__builtin_neon_vminvq_u8:
    {
      Int = ID.aarch64_neon_uminv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int8Ty, 16);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vminv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int8Ty);
    }
   case NEON.BI__builtin_neon_vminvq_u16:
    {
      Int = ID.aarch64_neon_uminv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int16Ty, 8);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vminv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int16Ty);
    }
   case NEON.BI__builtin_neon_vminv_s8:
    {
      Int = ID.aarch64_neon_sminv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int8Ty, 8);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vminv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int8Ty);
    }
   case NEON.BI__builtin_neon_vminv_s16:
    {
      Int = ID.aarch64_neon_sminv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int16Ty, 4);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vminv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int16Ty);
    }
   case NEON.BI__builtin_neon_vminvq_s8:
    {
      Int = ID.aarch64_neon_sminv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int8Ty, 16);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vminv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int8Ty);
    }
   case NEON.BI__builtin_neon_vminvq_s16:
    {
      Int = ID.aarch64_neon_sminv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int16Ty, 8);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vminv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int16Ty);
    }
   case NEON.BI__builtin_neon_vmul_n_f64:
    {
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), DoubleTy));
      Value /*P*/ RHS = $this().Builder.CreateBitCast($this().EmitScalarExpr(E.getArg$Const(1)), DoubleTy);
      return $this().Builder.CreateFMul(Ops.$at(0), RHS);
    }
   case NEON.BI__builtin_neon_vaddlv_u8:
    {
      Int = ID.aarch64_neon_uaddlv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int8Ty, 8);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vaddlv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int16Ty);
    }
   case NEON.BI__builtin_neon_vaddlv_u16:
    {
      Int = ID.aarch64_neon_uaddlv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int16Ty, 4);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vaddlv"));
    }
   case NEON.BI__builtin_neon_vaddlvq_u8:
    {
      Int = ID.aarch64_neon_uaddlv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int8Ty, 16);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vaddlv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int16Ty);
    }
   case NEON.BI__builtin_neon_vaddlvq_u16:
    {
      Int = ID.aarch64_neon_uaddlv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int16Ty, 8);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vaddlv"));
    }
   case NEON.BI__builtin_neon_vaddlv_s8:
    {
      Int = ID.aarch64_neon_saddlv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int8Ty, 8);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vaddlv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int16Ty);
    }
   case NEON.BI__builtin_neon_vaddlv_s16:
    {
      Int = ID.aarch64_neon_saddlv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int16Ty, 4);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vaddlv"));
    }
   case NEON.BI__builtin_neon_vaddlvq_s8:
    {
      Int = ID.aarch64_neon_saddlv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int8Ty, 16);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      Ops.$set(0, $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vaddlv")));
      return $this().Builder.CreateTrunc(Ops.$at(0), Int16Ty);
    }
   case NEON.BI__builtin_neon_vaddlvq_s16:
    {
      Int = ID.aarch64_neon_saddlv;
      Ty = Int32Ty;
      VTy = VectorType.get(Int16Ty, 8);
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {Ty, VTy};
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(0)));
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $("vaddlv"));
    }
   case NEON.BI__builtin_neon_vsri_n_v:
   case NEON.BI__builtin_neon_vsriq_n_v:
    {
      Int = ID.aarch64_neon_vsri;
      Function /*P*/ Intrin = $this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true));
      return $this().EmitNeonCall(Intrin, Ops, $("vsri_n"));
    }
   case NEON.BI__builtin_neon_vsli_n_v:
   case NEON.BI__builtin_neon_vsliq_n_v:
    {
      Int = ID.aarch64_neon_vsli;
      Function /*P*/ Intrin = $this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true));
      return $this().EmitNeonCall(Intrin, Ops, $("vsli_n"));
    }
   case NEON.BI__builtin_neon_vsra_n_v:
   case NEON.BI__builtin_neon_vsraq_n_v:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
    Ops.$set(1, $this().EmitNeonRShiftImm(Ops.$at(1), Ops.$at(2), Ty, usgn, $("vsra_n")));
    return $this().Builder.CreateAdd(Ops.$at(0), Ops.$at(1));
   case NEON.BI__builtin_neon_vrsra_n_v:
   case NEON.BI__builtin_neon_vrsraq_n_v:
    {
      Int = usgn ? ID.aarch64_neon_urshl : ID.aarch64_neon_srshl;
      SmallVector<Value /*P*/ > TmpOps/*J*/= new SmallVector<Value /*P*/ >(2, (Value /*P*/ )null);
      TmpOps.push_back(Ops.$at(1));
      TmpOps.push_back(Ops.$at(2));
      Function /*P*/ F = $this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true));
      Value /*P*/ tmp = $this().EmitNeonCall(F, TmpOps, $("vrshr_n"), 1, true);
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), VTy));
      return $this().Builder.CreateAdd(Ops.$at(0), tmp);
    }
   case NEON.BI__builtin_neon_vld1_x2_v:
   case NEON.BI__builtin_neon_vld1q_x2_v:
   case NEON.BI__builtin_neon_vld1_x3_v:
   case NEON.BI__builtin_neon_vld1q_x3_v:
   case NEON.BI__builtin_neon_vld1_x4_v:
   case NEON.BI__builtin_neon_vld1q_x4_v:
    {
      Type /*P*/ PTy = PointerType.getUnqual(VTy.getVectorElementType());
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), PTy));
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {VTy, PTy};
      /*uint*/int Int$1 = 0;
      switch (BuiltinID) {
       case NEON.BI__builtin_neon_vld1_x2_v:
       case NEON.BI__builtin_neon_vld1q_x2_v:
        Int$1 = ID.aarch64_neon_ld1x2;
        break;
       case NEON.BI__builtin_neon_vld1_x3_v:
       case NEON.BI__builtin_neon_vld1q_x3_v:
        Int$1 = ID.aarch64_neon_ld1x3;
        break;
       case NEON.BI__builtin_neon_vld1_x4_v:
       case NEON.BI__builtin_neon_vld1q_x4_v:
        Int$1 = ID.aarch64_neon_ld1x4;
        break;
      }
      Function /*P*/ F = $this().CGM.getIntrinsic(Int$1, new ArrayRef<Type /*P*/ >(Tys, true));
      Ops.$set(1, $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Ops.$at(1), true), new Twine(/*KEEP_STR*/"vld1xN")));
      Ty = PointerType.getUnqual(Ops.$at(1).getType());
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
      return $this().Builder.CreateDefaultAlignedStore(Ops.$at(1), Ops.$at(0));
    }
   case NEON.BI__builtin_neon_vst1_x2_v:
   case NEON.BI__builtin_neon_vst1q_x2_v:
   case NEON.BI__builtin_neon_vst1_x3_v:
   case NEON.BI__builtin_neon_vst1q_x3_v:
   case NEON.BI__builtin_neon_vst1_x4_v:
   case NEON.BI__builtin_neon_vst1q_x4_v:
    {
      Type /*P*/ PTy = PointerType.getUnqual(VTy.getVectorElementType());
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {VTy, PTy};
      /*uint*/int Int$1 = 0;
      switch (BuiltinID) {
       case NEON.BI__builtin_neon_vst1_x2_v:
       case NEON.BI__builtin_neon_vst1q_x2_v:
        Int$1 = ID.aarch64_neon_st1x2;
        break;
       case NEON.BI__builtin_neon_vst1_x3_v:
       case NEON.BI__builtin_neon_vst1q_x3_v:
        Int$1 = ID.aarch64_neon_st1x3;
        break;
       case NEON.BI__builtin_neon_vst1_x4_v:
       case NEON.BI__builtin_neon_vst1q_x4_v:
        Int$1 = ID.aarch64_neon_st1x4;
        break;
      }
      std.rotate(Ops.begin(), Ops.begin().$add(1), Ops.end());
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int$1, new ArrayRef<Type /*P*/ >(Tys, true)), Ops, $EMPTY);
    }
   case NEON.BI__builtin_neon_vld1_v:
   case NEON.BI__builtin_neon_vld1q_v:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), PointerType.getUnqual(VTy)));
    return $this().Builder.CreateDefaultAlignedLoad(Ops.$at(0));
   case NEON.BI__builtin_neon_vst1_v:
   case NEON.BI__builtin_neon_vst1q_v:
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), PointerType.getUnqual(VTy)));
    Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), VTy));
    return $this().Builder.CreateDefaultAlignedStore(Ops.$at(1), Ops.$at(0));
   case NEON.BI__builtin_neon_vld1_lane_v:
   case NEON.BI__builtin_neon_vld1q_lane_v:
    Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
    Ty = org.llvm.ir.PointerType.getUnqual(VTy.getElementType());
    Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
    Ops.$set(0, $this().Builder.CreateDefaultAlignedLoad(Ops.$at(0)));
    return $this().Builder.CreateInsertElement(Ops.$at(1), Ops.$at(0), Ops.$at(2), new Twine(/*KEEP_STR*/"vld1_lane"));
   case NEON.BI__builtin_neon_vld1_dup_v:
   case NEON.BI__builtin_neon_vld1q_dup_v:
    {
      Value /*P*/ V = UndefValue.get(Ty);
      Ty = org.llvm.ir.PointerType.getUnqual(VTy.getElementType());
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
      Ops.$set(0, $this().Builder.CreateDefaultAlignedLoad(Ops.$at(0)));
      Constant /*P*/ CI = ConstantInt.get(Int32Ty, $int2ulong(0));
      Ops.$set(0, $this().Builder.CreateInsertElement(V, Ops.$at(0), CI));
      return $this().EmitNeonSplat(Ops.$at(0), CI);
    }
   case NEON.BI__builtin_neon_vst1_lane_v:
   case NEON.BI__builtin_neon_vst1q_lane_v:
    Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
    Ops.$set(1, $this().Builder.CreateExtractElement(Ops.$at(1), Ops.$at(2)));
    Ty = org.llvm.ir.PointerType.getUnqual(Ops.$at(1).getType());
    return $this().Builder.CreateDefaultAlignedStore(Ops.$at(1), 
        $this().Builder.CreateBitCast(Ops.$at(0), Ty));
   case NEON.BI__builtin_neon_vld2_v:
   case NEON.BI__builtin_neon_vld2q_v:
    {
      Type /*P*/ PTy = PointerType.getUnqual(VTy);
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), PTy));
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {VTy, PTy};
      Function /*P*/ F = $this().CGM.getIntrinsic(ID.aarch64_neon_ld2, new ArrayRef<Type /*P*/ >(Tys, true));
      Ops.$set(1, $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Ops.$at(1), true), new Twine(/*KEEP_STR*/"vld2")));
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), 
          PointerType.getUnqual(Ops.$at(1).getType())));
      return $this().Builder.CreateDefaultAlignedStore(Ops.$at(1), Ops.$at(0));
    }
   case NEON.BI__builtin_neon_vld3_v:
   case NEON.BI__builtin_neon_vld3q_v:
    {
      Type /*P*/ PTy = PointerType.getUnqual(VTy);
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), PTy));
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {VTy, PTy};
      Function /*P*/ F = $this().CGM.getIntrinsic(ID.aarch64_neon_ld3, new ArrayRef<Type /*P*/ >(Tys, true));
      Ops.$set(1, $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Ops.$at(1), true), new Twine(/*KEEP_STR*/"vld3")));
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), 
          PointerType.getUnqual(Ops.$at(1).getType())));
      return $this().Builder.CreateDefaultAlignedStore(Ops.$at(1), Ops.$at(0));
    }
   case NEON.BI__builtin_neon_vld4_v:
   case NEON.BI__builtin_neon_vld4q_v:
    {
      Type /*P*/ PTy = PointerType.getUnqual(VTy);
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), PTy));
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {VTy, PTy};
      Function /*P*/ F = $this().CGM.getIntrinsic(ID.aarch64_neon_ld4, new ArrayRef<Type /*P*/ >(Tys, true));
      Ops.$set(1, $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Ops.$at(1), true), new Twine(/*KEEP_STR*/"vld4")));
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), 
          PointerType.getUnqual(Ops.$at(1).getType())));
      return $this().Builder.CreateDefaultAlignedStore(Ops.$at(1), Ops.$at(0));
    }
   case NEON.BI__builtin_neon_vld2_dup_v:
   case NEON.BI__builtin_neon_vld2q_dup_v:
    {
      Type /*P*/ PTy = PointerType.getUnqual(VTy.getElementType());
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), PTy));
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {VTy, PTy};
      Function /*P*/ F = $this().CGM.getIntrinsic(ID.aarch64_neon_ld2r, new ArrayRef<Type /*P*/ >(Tys, true));
      Ops.$set(1, $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Ops.$at(1), true), new Twine(/*KEEP_STR*/"vld2")));
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), 
          PointerType.getUnqual(Ops.$at(1).getType())));
      return $this().Builder.CreateDefaultAlignedStore(Ops.$at(1), Ops.$at(0));
    }
   case NEON.BI__builtin_neon_vld3_dup_v:
   case NEON.BI__builtin_neon_vld3q_dup_v:
    {
      Type /*P*/ PTy = PointerType.getUnqual(VTy.getElementType());
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), PTy));
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {VTy, PTy};
      Function /*P*/ F = $this().CGM.getIntrinsic(ID.aarch64_neon_ld3r, new ArrayRef<Type /*P*/ >(Tys, true));
      Ops.$set(1, $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Ops.$at(1), true), new Twine(/*KEEP_STR*/"vld3")));
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), 
          PointerType.getUnqual(Ops.$at(1).getType())));
      return $this().Builder.CreateDefaultAlignedStore(Ops.$at(1), Ops.$at(0));
    }
   case NEON.BI__builtin_neon_vld4_dup_v:
   case NEON.BI__builtin_neon_vld4q_dup_v:
    {
      Type /*P*/ PTy = PointerType.getUnqual(VTy.getElementType());
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), PTy));
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {VTy, PTy};
      Function /*P*/ F = $this().CGM.getIntrinsic(ID.aarch64_neon_ld4r, new ArrayRef<Type /*P*/ >(Tys, true));
      Ops.$set(1, $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Ops.$at(1), true), new Twine(/*KEEP_STR*/"vld4")));
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), 
          PointerType.getUnqual(Ops.$at(1).getType())));
      return $this().Builder.CreateDefaultAlignedStore(Ops.$at(1), Ops.$at(0));
    }
   case NEON.BI__builtin_neon_vld2_lane_v:
   case NEON.BI__builtin_neon_vld2q_lane_v:
    {
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {VTy, Ops.$at(1).getType()};
      Function /*P*/ F = $this().CGM.getIntrinsic(ID.aarch64_neon_ld2lane, new ArrayRef<Type /*P*/ >(Tys, true));
      Ops.push_back(Ops.$at(1));
      Ops.erase(Ops.begin().$add(1));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
      Ops.$set(2, $this().Builder.CreateBitCast(Ops.$at(2), Ty));
      Ops.$set(3, $this().Builder.CreateZExt(Ops.$at(3), Int64Ty));
      Ops.$set(1, $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, makeArrayRef(Ops).slice(1), new Twine(/*KEEP_STR*/"vld2_lane")));
      Ty = PointerType.getUnqual(Ops.$at(1).getType());
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
      return $this().Builder.CreateDefaultAlignedStore(Ops.$at(1), Ops.$at(0));
    }
   case NEON.BI__builtin_neon_vld3_lane_v:
   case NEON.BI__builtin_neon_vld3q_lane_v:
    {
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {VTy, Ops.$at(1).getType()};
      Function /*P*/ F = $this().CGM.getIntrinsic(ID.aarch64_neon_ld3lane, new ArrayRef<Type /*P*/ >(Tys, true));
      Ops.push_back(Ops.$at(1));
      Ops.erase(Ops.begin().$add(1));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
      Ops.$set(2, $this().Builder.CreateBitCast(Ops.$at(2), Ty));
      Ops.$set(3, $this().Builder.CreateBitCast(Ops.$at(3), Ty));
      Ops.$set(4, $this().Builder.CreateZExt(Ops.$at(4), Int64Ty));
      Ops.$set(1, $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, makeArrayRef(Ops).slice(1), new Twine(/*KEEP_STR*/"vld3_lane")));
      Ty = PointerType.getUnqual(Ops.$at(1).getType());
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
      return $this().Builder.CreateDefaultAlignedStore(Ops.$at(1), Ops.$at(0));
    }
   case NEON.BI__builtin_neon_vld4_lane_v:
   case NEON.BI__builtin_neon_vld4q_lane_v:
    {
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {VTy, Ops.$at(1).getType()};
      Function /*P*/ F = $this().CGM.getIntrinsic(ID.aarch64_neon_ld4lane, new ArrayRef<Type /*P*/ >(Tys, true));
      Ops.push_back(Ops.$at(1));
      Ops.erase(Ops.begin().$add(1));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
      Ops.$set(2, $this().Builder.CreateBitCast(Ops.$at(2), Ty));
      Ops.$set(3, $this().Builder.CreateBitCast(Ops.$at(3), Ty));
      Ops.$set(4, $this().Builder.CreateBitCast(Ops.$at(4), Ty));
      Ops.$set(5, $this().Builder.CreateZExt(Ops.$at(5), Int64Ty));
      Ops.$set(1, $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, makeArrayRef(Ops).slice(1), new Twine(/*KEEP_STR*/"vld4_lane")));
      Ty = PointerType.getUnqual(Ops.$at(1).getType());
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), Ty));
      return $this().Builder.CreateDefaultAlignedStore(Ops.$at(1), Ops.$at(0));
    }
   case NEON.BI__builtin_neon_vst2_v:
   case NEON.BI__builtin_neon_vst2q_v:
    {
      Ops.push_back(Ops.$at(0));
      Ops.erase(Ops.begin());
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {VTy, Ops.$at(2).getType()};
      return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_st2, new ArrayRef<Type /*P*/ >(Tys, true)), 
          Ops, $EMPTY);
    }
   case NEON.BI__builtin_neon_vst2_lane_v:
   case NEON.BI__builtin_neon_vst2q_lane_v:
    {
      Ops.push_back(Ops.$at(0));
      Ops.erase(Ops.begin());
      Ops.$set(2, $this().Builder.CreateZExt(Ops.$at(2), Int64Ty));
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {VTy, Ops.$at(3).getType()};
      return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_st2lane, new ArrayRef<Type /*P*/ >(Tys, true)), 
          Ops, $EMPTY);
    }
   case NEON.BI__builtin_neon_vst3_v:
   case NEON.BI__builtin_neon_vst3q_v:
    {
      Ops.push_back(Ops.$at(0));
      Ops.erase(Ops.begin());
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {VTy, Ops.$at(3).getType()};
      return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_st3, new ArrayRef<Type /*P*/ >(Tys, true)), 
          Ops, $EMPTY);
    }
   case NEON.BI__builtin_neon_vst3_lane_v:
   case NEON.BI__builtin_neon_vst3q_lane_v:
    {
      Ops.push_back(Ops.$at(0));
      Ops.erase(Ops.begin());
      Ops.$set(3, $this().Builder.CreateZExt(Ops.$at(3), Int64Ty));
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {VTy, Ops.$at(4).getType()};
      return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_st3lane, new ArrayRef<Type /*P*/ >(Tys, true)), 
          Ops, $EMPTY);
    }
   case NEON.BI__builtin_neon_vst4_v:
   case NEON.BI__builtin_neon_vst4q_v:
    {
      Ops.push_back(Ops.$at(0));
      Ops.erase(Ops.begin());
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {VTy, Ops.$at(4).getType()};
      return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_st4, new ArrayRef<Type /*P*/ >(Tys, true)), 
          Ops, $EMPTY);
    }
   case NEON.BI__builtin_neon_vst4_lane_v:
   case NEON.BI__builtin_neon_vst4q_lane_v:
    {
      Ops.push_back(Ops.$at(0));
      Ops.erase(Ops.begin());
      Ops.$set(4, $this().Builder.CreateZExt(Ops.$at(4), Int64Ty));
      Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {VTy, Ops.$at(5).getType()};
      return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_st4lane, new ArrayRef<Type /*P*/ >(Tys, true)), 
          Ops, $EMPTY);
    }
   case NEON.BI__builtin_neon_vtrn_v:
   case NEON.BI__builtin_neon_vtrnq_v:
    {
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), PointerType.getUnqual(Ty)));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
      Ops.$set(2, $this().Builder.CreateBitCast(Ops.$at(2), Ty));
      Value /*P*/ SV = null;
      
      for (/*uint*/int vi = 0; vi != 2; ++vi) {
        SmallVectorUInt Indices/*J*/= new SmallVectorUInt(16, 0);
        for (/*uint*/int i = 0, e = VTy.getNumElements(); i != e; i += 2) {
          Indices.push_back(i + vi);
          Indices.push_back(i + e + vi);
        }
        Value /*P*/ Addr = $this().Builder.CreateConstInBoundsGEP1_32(Ty, Ops.$at(0), vi);
        SV = $this().Builder.CreateShuffleVector(Ops.$at(1), Ops.$at(2), new ArrayRefUInt(Indices), new Twine(/*KEEP_STR*/"vtrn"));
        SV = $this().Builder.CreateDefaultAlignedStore(SV, Addr);
      }
      return SV;
    }
   case NEON.BI__builtin_neon_vuzp_v:
   case NEON.BI__builtin_neon_vuzpq_v:
    {
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), PointerType.getUnqual(Ty)));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
      Ops.$set(2, $this().Builder.CreateBitCast(Ops.$at(2), Ty));
      Value /*P*/ SV = null;
      
      for (/*uint*/int vi = 0; vi != 2; ++vi) {
        SmallVectorUInt Indices/*J*/= new SmallVectorUInt(16, 0);
        for (/*uint*/int i = 0, e = VTy.getNumElements(); i != e; ++i)  {
          Indices.push_back(2 * i + vi);
        }
        
        Value /*P*/ Addr = $this().Builder.CreateConstInBoundsGEP1_32(Ty, Ops.$at(0), vi);
        SV = $this().Builder.CreateShuffleVector(Ops.$at(1), Ops.$at(2), new ArrayRefUInt(Indices), new Twine(/*KEEP_STR*/"vuzp"));
        SV = $this().Builder.CreateDefaultAlignedStore(SV, Addr);
      }
      return SV;
    }
   case NEON.BI__builtin_neon_vzip_v:
   case NEON.BI__builtin_neon_vzipq_v:
    {
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), PointerType.getUnqual(Ty)));
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Ty));
      Ops.$set(2, $this().Builder.CreateBitCast(Ops.$at(2), Ty));
      Value /*P*/ SV = null;
      
      for (/*uint*/int vi = 0; vi != 2; ++vi) {
        SmallVectorUInt Indices/*J*/= new SmallVectorUInt(16, 0);
        for (/*uint*/int i = 0, e = VTy.getNumElements(); i != e; i += 2) {
          Indices.push_back((i + vi * e) >>> 1);
          Indices.push_back(((i + vi * e) >>> 1) + e);
        }
        Value /*P*/ Addr = $this().Builder.CreateConstInBoundsGEP1_32(Ty, Ops.$at(0), vi);
        SV = $this().Builder.CreateShuffleVector(Ops.$at(1), Ops.$at(2), new ArrayRefUInt(Indices), new Twine(/*KEEP_STR*/"vzip"));
        SV = $this().Builder.CreateDefaultAlignedStore(SV, Addr);
      }
      return SV;
    }
   case NEON.BI__builtin_neon_vqtbl1q_v:
    {
      return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_tbl1, new ArrayRef<Type /*P*/ >(Ty, true)), 
          Ops, $("vtbl1"));
    }
   case NEON.BI__builtin_neon_vqtbl2q_v:
    {
      return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_tbl2, new ArrayRef<Type /*P*/ >(Ty, true)), 
          Ops, $("vtbl2"));
    }
   case NEON.BI__builtin_neon_vqtbl3q_v:
    {
      return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_tbl3, new ArrayRef<Type /*P*/ >(Ty, true)), 
          Ops, $("vtbl3"));
    }
   case NEON.BI__builtin_neon_vqtbl4q_v:
    {
      return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_tbl4, new ArrayRef<Type /*P*/ >(Ty, true)), 
          Ops, $("vtbl4"));
    }
   case NEON.BI__builtin_neon_vqtbx1q_v:
    {
      return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_tbx1, new ArrayRef<Type /*P*/ >(Ty, true)), 
          Ops, $("vtbx1"));
    }
   case NEON.BI__builtin_neon_vqtbx2q_v:
    {
      return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_tbx2, new ArrayRef<Type /*P*/ >(Ty, true)), 
          Ops, $("vtbx2"));
    }
   case NEON.BI__builtin_neon_vqtbx3q_v:
    {
      return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_tbx3, new ArrayRef<Type /*P*/ >(Ty, true)), 
          Ops, $("vtbx3"));
    }
   case NEON.BI__builtin_neon_vqtbx4q_v:
    {
      return $this().EmitNeonCall($this().CGM.getIntrinsic(ID.aarch64_neon_tbx4, new ArrayRef<Type /*P*/ >(Ty, true)), 
          Ops, $("vtbx4"));
    }
   case NEON.BI__builtin_neon_vsqadd_v:
   case NEON.BI__builtin_neon_vsqaddq_v:
    {
      Int = ID.aarch64_neon_usqadd;
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vsqadd"));
    }
   case NEON.BI__builtin_neon_vuqadd_v:
   case NEON.BI__builtin_neon_vuqaddq_v:
    {
      Int = ID.aarch64_neon_suqadd;
      return $this().EmitNeonCall($this().CGM.getIntrinsic(Int, new ArrayRef<Type /*P*/ >(Ty, true)), Ops, $("vuqadd"));
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::BuildVector">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 6541,
 FQN="clang::CodeGen::CodeGenFunction::BuildVector", NM="_ZN5clang7CodeGen15CodeGenFunction11BuildVectorEN4llvm8ArrayRefIPNS2_5ValueEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11BuildVectorEN4llvm8ArrayRefIPNS2_5ValueEEE")
//</editor-fold>
public final Value /*P*/ BuildVector(ArrayRef<Value /*P*/ > Ops) {
  assert ((Ops.size() & (Ops.size() - 1)) == 0) : "Not a power-of-two sized vector!";
  boolean AllConstants = true;
  for (/*uint*/int i = 0, e = Ops.size(); i != e && AllConstants; ++i)  {
    AllConstants &= IrRTTI.isa_Constant(Ops.$at(i));
  }
  
  // If this is a constant vector, create a ConstantVector.
  if (AllConstants) {
    SmallVector<Constant /*P*/ > CstOps/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
    for (/*uint*/int i = 0, e = Ops.size(); i != e; ++i)  {
      CstOps.push_back(IrRTTI.cast_Constant(Ops.$at(i)));
    }
    return ConstantVector.get(new ArrayRef<Constant /*P*/ >(CstOps, true));
  }
  
  // Otherwise, insertelement the values to build the vector.
  Value /*P*/ Result = UndefValue.get(VectorType.get(Ops.$at(0).getType(), Ops.size()));
  
  for (/*uint*/int i = 0, e = Ops.size(); i != e; ++i)  {
    Result = $this().Builder.CreateInsertElement(Result, Ops.$at(i), $this().Builder.getInt32(i));
  }
  
  return Result;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitX86BuiltinExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 6679,
 FQN="clang::CodeGen::CodeGenFunction::EmitX86BuiltinExpr", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitX86BuiltinExprEjPKNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitX86BuiltinExprEjPKNS_8CallExprE")
//</editor-fold>
public final Value /*P*/ EmitX86BuiltinExpr(/*uint*/int BuiltinID, 
                  /*const*/ CallExpr /*P*/ E) {
  if (BuiltinID == X86.BI__builtin_ms_va_start
     || BuiltinID == X86.BI__builtin_ms_va_end) {
    return $this().EmitVAStartEnd($this().EmitMSVAListRef(E.getArg$Const(0)).getPointer(), 
        BuiltinID == X86.BI__builtin_ms_va_start);
  }
  if (BuiltinID == X86.BI__builtin_ms_va_copy) {
    // Lower this manually. We can't reliably determine whether or not any
    // given va_copy() is for a Win64 va_list from the calling convention
    // alone, because it's legal to do this from a System V ABI function.
    // With opaque pointer types, we won't have enough information in LLVM
    // IR to determine this from the argument types, either. Best to do it
    // now, while we have enough information.
    Address DestAddr = $this().EmitMSVAListRef(E.getArg$Const(0));
    Address SrcAddr = $this().EmitMSVAListRef(E.getArg$Const(1));
    
    org.llvm.ir.Type /*P*/ BPP = Unnamed_field10.Int8PtrPtrTy;
    
    DestAddr.$assignMove(new Address($this().Builder.CreateBitCast(DestAddr.getPointer(), BPP, new Twine(/*KEEP_STR*/"cp")), 
            DestAddr.getAlignment()));
    SrcAddr.$assignMove(new Address($this().Builder.CreateBitCast(SrcAddr.getPointer(), BPP, new Twine(/*KEEP_STR*/"ap")), 
            SrcAddr.getAlignment()));
    
    Value /*P*/ ArgPtr = $this().Builder.CreateLoad(new Address(SrcAddr), $("ap.val"));
    return $this().Builder.CreateStore(ArgPtr, new Address(DestAddr));
  }
  
  SmallVector<Value /*P*/ > Ops/*J*/= new SmallVector<Value /*P*/ >(4, (Value /*P*/ )null);
  
  // Find out if any arguments are required to be integer constant expressions.
  uint$ptr ICEArguments = create_uint$ptr(0);
  type$ref<ASTContext.GetBuiltinTypeError> Error = create_type$ref();
  $this().getContext().GetBuiltinType(BuiltinID, Error, $AddrOf(ICEArguments));
  assert (Error.$deref() == ASTContext.GetBuiltinTypeError.GE_None) : "Should not codegen an error";
  
  for (/*uint*/int i = 0, e = E.getNumArgs(); i != e; i++) {
    // If this is a normal argument, just emit it as a scalar.
    if ((ICEArguments.$star() & (1 << i)) == 0) {
      Ops.push_back($this().EmitScalarExpr(E.getArg$Const(i)));
      continue;
    }
    
    // If this is required to be a constant, constant fold it so that we know
    // that the generated intrinsic gets a ConstantInt.
    APSInt Result/*J*/= new APSInt();
    boolean IsConst = E.getArg$Const(i).isIntegerConstantExpr(Result, $this().getContext());
    assert (IsConst) : "Constant arg isn't actually constant?";
    ///*J:(void)*/IsConst;
    Ops.push_back(ConstantInt.get($this().getLLVMContext(), Result));
  }
  
  // These exist so that the builtin that takes an immediate can be bounds
  // checked by clang to avoid passing bad immediates to the backend. Since
  // AVX has a larger immediate than SSE we would need separate builtins to
  // do the different bounds checking. Rather than create a clang specific
  // SSE only builtin, this implements eight separate builtins to match gcc
  // implementation.
  IntUInt2CallInst getCmpIntrinsicCall = /*[this, &Ops]*/ (/*Intrinsic.ID*/int ID, /*uint*/int Imm) -> {
        Ops.push_back(ConstantInt.get(Int8Ty, $uint2ulong(Imm)));
        Function /*P*/ F = $this().CGM.getIntrinsic(ID);
        return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Ops, true));
      };
  
  // For the vector forms of FP comparisons, translate the builtins directly to
  // IR.
  // TODO: The builtins could be removed if the SSE header files used vector
  // extension comparisons directly (vector ordered/unordered may need
  // additional support via __builtin_isnan()).
  Predicate2Value getVectorFCmpIR = /*[this, &Ops]*/ (CmpInst.Predicate Pred) -> {
        Value /*P*/ Cmp = $this().Builder.CreateFCmp(Pred, Ops.$at(0), Ops.$at(1));
        VectorType /*P*/ FPVecTy = IrRTTI.cast_VectorType(Ops.$at(0).getType());
        VectorType /*P*/ IntVecTy = VectorType.getInteger(FPVecTy);
        Value /*P*/ Sext = $this().Builder.CreateSExt(Cmp, IntVecTy);
        return $this().Builder.CreateBitCast(Sext, FPVecTy);
      };
  switch (BuiltinID) {
   default:
    return null;
   case X86.BI__builtin_cpu_supports:
    {
      /*const*/ Expr /*P*/ FeatureExpr = E.getArg$Const(0).IgnoreParenCasts$Const();
      StringRef FeatureStr = AstRTTI.cast_StringLiteral(FeatureExpr).getString();
      
      // TODO: When/if this becomes more than x86 specific then use a TargetInfo
      // based mapping.
      // Processor features and mapping to processor feature value.
      final class/*enum*/ X86Features {
        private static final /*uint*/int CMOV = 0;
        private static final /*uint*/int MMX = CMOV + 1;
        private static final /*uint*/int POPCNT = MMX + 1;
        private static final /*uint*/int SSE = POPCNT + 1;
        private static final /*uint*/int SSE2 = SSE + 1;
        private static final /*uint*/int SSE3 = SSE2 + 1;
        private static final /*uint*/int SSSE3 = SSE3 + 1;
        private static final /*uint*/int SSE4_1 = SSSE3 + 1;
        private static final /*uint*/int SSE4_2 = SSE4_1 + 1;
        private static final /*uint*/int AVX = SSE4_2 + 1;
        private static final /*uint*/int AVX2 = AVX + 1;
        private static final /*uint*/int SSE4_A = AVX2 + 1;
        private static final /*uint*/int FMA4 = SSE4_A + 1;
        private static final /*uint*/int XOP = FMA4 + 1;
        private static final /*uint*/int FMA = XOP + 1;
        private static final /*uint*/int AVX512F = FMA + 1;
        private static final /*uint*/int BMI = AVX512F + 1;
        private static final /*uint*/int BMI2 = BMI + 1;
        private static final /*uint*/int AES = BMI2 + 1;
        private static final /*uint*/int PCLMUL = AES + 1;
        private static final /*uint*/int AVX512VL = PCLMUL + 1;
        private static final /*uint*/int AVX512BW = AVX512VL + 1;
        private static final /*uint*/int AVX512DQ = AVX512BW + 1;
        private static final /*uint*/int AVX512CD = AVX512DQ + 1;
        private static final /*uint*/int AVX512ER = AVX512CD + 1;
        private static final /*uint*/int AVX512PF = AVX512ER + 1;
        private static final /*uint*/int AVX512VBMI = AVX512PF + 1;
        private static final /*uint*/int AVX512IFMA = AVX512VBMI + 1;
        private static final /*uint*/int MAX = AVX512IFMA + 1;
      };
      
      /*X86Features*//*uint*/int Feature = new StringSwitchInt(/*NO_COPY*/FeatureStr).
          Case(/*KEEP_STR*/"cmov", X86Features.CMOV).
          Case(/*KEEP_STR*/"mmx", X86Features.MMX).
          Case(/*KEEP_STR*/"popcnt", X86Features.POPCNT).
          Case(/*KEEP_STR*/"sse", X86Features.SSE).
          Case(/*KEEP_STR*/"sse2", X86Features.SSE2).
          Case(/*KEEP_STR*/"sse3", X86Features.SSE3).
          Case(/*KEEP_STR*/"ssse3", X86Features.SSSE3).
          Case(/*KEEP_STR*/"sse4.1", X86Features.SSE4_1).
          Case(/*KEEP_STR*/"sse4.2", X86Features.SSE4_2).
          Case(/*KEEP_STR*/"avx", X86Features.AVX).
          Case(/*KEEP_STR*/"avx2", X86Features.AVX2).
          Case(/*KEEP_STR*/"sse4a", X86Features.SSE4_A).
          Case(/*KEEP_STR*/"fma4", X86Features.FMA4).
          Case(/*KEEP_STR*/"xop", X86Features.XOP).
          Case(/*KEEP_STR*/"fma", X86Features.FMA).
          Case(/*KEEP_STR*/"avx512f", X86Features.AVX512F).
          Case(/*KEEP_STR*/"bmi", X86Features.BMI).
          Case(/*KEEP_STR*/"bmi2", X86Features.BMI2).
          Case(/*KEEP_STR*/"aes", X86Features.AES).
          Case(/*KEEP_STR*/"pclmul", X86Features.PCLMUL).
          Case(/*KEEP_STR*/"avx512vl", X86Features.AVX512VL).
          Case(/*KEEP_STR*/"avx512bw", X86Features.AVX512BW).
          Case(/*KEEP_STR*/"avx512dq", X86Features.AVX512DQ).
          Case(/*KEEP_STR*/"avx512cd", X86Features.AVX512CD).
          Case(/*KEEP_STR*/"avx512er", X86Features.AVX512ER).
          Case(/*KEEP_STR*/"avx512pf", X86Features.AVX512PF).
          Case(/*KEEP_STR*/"avx512vbmi", X86Features.AVX512VBMI).
          Case(/*KEEP_STR*/"avx512ifma", X86Features.AVX512IFMA).
          Default(X86Features.MAX);
      assert (Feature != X86Features.MAX) : "Invalid feature!";
      
      // Matching the struct layout from the compiler-rt/libgcc structure that is
      // filled in:
      // unsigned int __cpu_vendor;
      // unsigned int __cpu_type;
      // unsigned int __cpu_subtype;
      // unsigned int __cpu_features[1];
      org.llvm.ir.Type /*P*/ STy = StructType.get(Int32Ty, Int32Ty, Int32Ty, org.llvm.ir.ArrayType.get(Int32Ty, $int2ulong(1)), null);
      
      // Grab the global __cpu_model.
      Constant /*P*/ CpuModel = $this().CGM.CreateRuntimeVariable(STy, new StringRef(/*KEEP_STR*/"__cpu_model"));
      
      // Grab the first (0th) element from the field __cpu_features off of the
      // global in the struct STy.
      Value /*P*/ Idxs[/*3*/] = new Value /*P*/  [/*3*/] {
        ConstantInt.get(Int32Ty, $int2ulong(0)), 
        ConstantInt.get(Int32Ty, $int2ulong(3)), 
        ConstantInt.get(Int32Ty, $int2ulong(0))
      };
      Value /*P*/ CpuFeatures = $this().Builder.CreateGEP(STy, CpuModel, new ArrayRef<Value /*P*/ >(Idxs, true));
      Value /*P*/ Features = $this().Builder.CreateAlignedLoad(CpuFeatures, 
          CharUnits.fromQuantity(4));
      
      // Check the value of the bit corresponding to the feature requested.
      Value /*P*/ Bitset = $this().Builder.CreateAnd(Features, ConstantInt.get(Int32Ty, 1L/*ULL*/ << Feature));
      return $this().Builder.CreateICmpNE(Bitset, ConstantInt.get(Int32Ty, $int2ulong(0)));
    }
   case X86.BI_mm_prefetch:
    {
      Value /*P*/ Address = Ops.$at(0);
      Value /*P*/ RW = ConstantInt.get(Int32Ty, $int2ulong(0));
      Value /*P*/ Locality = Ops.$at(1);
      Value /*P*/ Data = ConstantInt.get(Int32Ty, $int2ulong(1));
      Value /*P*/ F = $this().CGM.getIntrinsic(org.llvm.ir.intrinsic.ID.prefetch);
      return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*4*/] {Address, RW, Locality, Data}, true)/* }*/);
    }
   case X86.BI__builtin_ia32_undef128:
   case X86.BI__builtin_ia32_undef256:
   case X86.BI__builtin_ia32_undef512:
    return UndefValue.get($this().ConvertType(E.getType()));
   case X86.BI__builtin_ia32_vec_init_v8qi:
   case X86.BI__builtin_ia32_vec_init_v4hi:
   case X86.BI__builtin_ia32_vec_init_v2si:
    return $this().Builder.CreateBitCast($this().BuildVector(new ArrayRef<Value /*P*/ >(Ops, true)), 
        Type.getX86_MMXTy($this().getLLVMContext()));
   case X86.BI__builtin_ia32_vec_ext_v2si:
    return $this().Builder.CreateExtractElement(Ops.$at(0), 
        ConstantInt.get(Ops.$at(1).getType(), $int2ulong(0)));
   case X86.BI__builtin_ia32_ldmxcsr:
    {
      Address Tmp = $this().CreateMemTemp(E.getArg$Const(0).getType());
      $this().Builder.CreateStore(Ops.$at(0), new Address(Tmp));
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(org.llvm.ir.intrinsic.ID.x86_sse_ldmxcsr), 
          new ArrayRef<Value /*P*/ >($this().Builder.CreateBitCast(Tmp.getPointer(), Unnamed_field9.Int8PtrTy), true));
    }
   case X86.BI__builtin_ia32_stmxcsr:
    {
      Address Tmp = $this().CreateMemTemp(E.getType());
      $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(org.llvm.ir.intrinsic.ID.x86_sse_stmxcsr), 
          new ArrayRef<Value /*P*/ >($this().Builder.CreateBitCast(Tmp.getPointer(), Unnamed_field9.Int8PtrTy), true));
      return $this().Builder.CreateLoad(new Address(Tmp), $("stmxcsr"));
    }
   case X86.BI__builtin_ia32_xsave:
   case X86.BI__builtin_ia32_xsave64:
   case X86.BI__builtin_ia32_xrstor:
   case X86.BI__builtin_ia32_xrstor64:
   case X86.BI__builtin_ia32_xsaveopt:
   case X86.BI__builtin_ia32_xsaveopt64:
   case X86.BI__builtin_ia32_xrstors:
   case X86.BI__builtin_ia32_xrstors64:
   case X86.BI__builtin_ia32_xsavec:
   case X86.BI__builtin_ia32_xsavec64:
   case X86.BI__builtin_ia32_xsaves:
   case X86.BI__builtin_ia32_xsaves64:
    {
      /*Intrinsic.ID*/int ID1;
      switch (BuiltinID) {
       default:
        throw new llvm_unreachable("Unsupported intrinsic!");
       case X86.BI__builtin_ia32_xsave:
        ID1 = org.llvm.ir.intrinsic.ID.x86_xsave;
        break;
       case X86.BI__builtin_ia32_xsave64:
        ID1 = org.llvm.ir.intrinsic.ID.x86_xsave64;
        break;
       case X86.BI__builtin_ia32_xrstor:
        ID1 = org.llvm.ir.intrinsic.ID.x86_xrstor;
        break;
       case X86.BI__builtin_ia32_xrstor64:
        ID1 = org.llvm.ir.intrinsic.ID.x86_xrstor64;
        break;
       case X86.BI__builtin_ia32_xsaveopt:
        ID1 = org.llvm.ir.intrinsic.ID.x86_xsaveopt;
        break;
       case X86.BI__builtin_ia32_xsaveopt64:
        ID1 = org.llvm.ir.intrinsic.ID.x86_xsaveopt64;
        break;
       case X86.BI__builtin_ia32_xrstors:
        ID1 = org.llvm.ir.intrinsic.ID.x86_xrstors;
        break;
       case X86.BI__builtin_ia32_xrstors64:
        ID1 = org.llvm.ir.intrinsic.ID.x86_xrstors64;
        break;
       case X86.BI__builtin_ia32_xsavec:
        ID1 = org.llvm.ir.intrinsic.ID.x86_xsavec;
        break;
       case X86.BI__builtin_ia32_xsavec64:
        ID1 = org.llvm.ir.intrinsic.ID.x86_xsavec64;
        break;
       case X86.BI__builtin_ia32_xsaves:
        ID1 = org.llvm.ir.intrinsic.ID.x86_xsaves;
        break;
       case X86.BI__builtin_ia32_xsaves64:
        ID1 = org.llvm.ir.intrinsic.ID.x86_xsaves64;
        break;
      }
      Value /*P*/ Mhi = $this().Builder.CreateTrunc($this().Builder.CreateLShr(Ops.$at(1), ConstantInt.get(Int64Ty, $int2ulong(32))), Int32Ty);
      Value /*P*/ Mlo = $this().Builder.CreateTrunc(Ops.$at(1), Int32Ty);
      Ops.$set(1, Mhi);
      Ops.push_back(Mlo);
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID1), new ArrayRef<Value /*P*/ >(Ops, true));
    }
   case X86.BI__builtin_ia32_storedqudi128_mask:
   case X86.BI__builtin_ia32_storedqusi128_mask:
   case X86.BI__builtin_ia32_storedquhi128_mask:
   case X86.BI__builtin_ia32_storedquqi128_mask:
   case X86.BI__builtin_ia32_storeupd128_mask:
   case X86.BI__builtin_ia32_storeups128_mask:
   case X86.BI__builtin_ia32_storedqudi256_mask:
   case X86.BI__builtin_ia32_storedqusi256_mask:
   case X86.BI__builtin_ia32_storedquhi256_mask:
   case X86.BI__builtin_ia32_storedquqi256_mask:
   case X86.BI__builtin_ia32_storeupd256_mask:
   case X86.BI__builtin_ia32_storeups256_mask:
   case X86.BI__builtin_ia32_storedqudi512_mask:
   case X86.BI__builtin_ia32_storedqusi512_mask:
   case X86.BI__builtin_ia32_storedquhi512_mask:
   case X86.BI__builtin_ia32_storedquqi512_mask:
   case X86.BI__builtin_ia32_storeupd512_mask:
   case X86.BI__builtin_ia32_storeups512_mask:
    return CGBuiltinStatics.EmitX86MaskedStore(/*Deref*/$this(), Ops, 1);
   case X86.BI__builtin_ia32_movdqa32store128_mask:
   case X86.BI__builtin_ia32_movdqa64store128_mask:
   case X86.BI__builtin_ia32_storeaps128_mask:
   case X86.BI__builtin_ia32_storeapd128_mask:
   case X86.BI__builtin_ia32_movdqa32store256_mask:
   case X86.BI__builtin_ia32_movdqa64store256_mask:
   case X86.BI__builtin_ia32_storeaps256_mask:
   case X86.BI__builtin_ia32_storeapd256_mask:
   case X86.BI__builtin_ia32_movdqa32store512_mask:
   case X86.BI__builtin_ia32_movdqa64store512_mask:
   case X86.BI__builtin_ia32_storeaps512_mask:
   case X86.BI__builtin_ia32_storeapd512_mask:
    {
      /*uint*/int Align = $long2uint($this().getContext().getTypeAlignInChars(E.getArg$Const(1).getType()).getQuantity());
      return CGBuiltinStatics.EmitX86MaskedStore(/*Deref*/$this(), Ops, Align);
    }
   case X86.BI__builtin_ia32_loadups128_mask:
   case X86.BI__builtin_ia32_loadups256_mask:
   case X86.BI__builtin_ia32_loadups512_mask:
   case X86.BI__builtin_ia32_loadupd128_mask:
   case X86.BI__builtin_ia32_loadupd256_mask:
   case X86.BI__builtin_ia32_loadupd512_mask:
   case X86.BI__builtin_ia32_loaddquqi128_mask:
   case X86.BI__builtin_ia32_loaddquqi256_mask:
   case X86.BI__builtin_ia32_loaddquqi512_mask:
   case X86.BI__builtin_ia32_loaddquhi128_mask:
   case X86.BI__builtin_ia32_loaddquhi256_mask:
   case X86.BI__builtin_ia32_loaddquhi512_mask:
   case X86.BI__builtin_ia32_loaddqusi128_mask:
   case X86.BI__builtin_ia32_loaddqusi256_mask:
   case X86.BI__builtin_ia32_loaddqusi512_mask:
   case X86.BI__builtin_ia32_loaddqudi128_mask:
   case X86.BI__builtin_ia32_loaddqudi256_mask:
   case X86.BI__builtin_ia32_loaddqudi512_mask:
    return CGBuiltinStatics.EmitX86MaskedLoad(/*Deref*/$this(), Ops, 1);
   case X86.BI__builtin_ia32_loadaps128_mask:
   case X86.BI__builtin_ia32_loadaps256_mask:
   case X86.BI__builtin_ia32_loadaps512_mask:
   case X86.BI__builtin_ia32_loadapd128_mask:
   case X86.BI__builtin_ia32_loadapd256_mask:
   case X86.BI__builtin_ia32_loadapd512_mask:
   case X86.BI__builtin_ia32_movdqa32load128_mask:
   case X86.BI__builtin_ia32_movdqa32load256_mask:
   case X86.BI__builtin_ia32_movdqa32load512_mask:
   case X86.BI__builtin_ia32_movdqa64load128_mask:
   case X86.BI__builtin_ia32_movdqa64load256_mask:
   case X86.BI__builtin_ia32_movdqa64load512_mask:
    {
      /*uint*/int Align = $long2uint($this().getContext().getTypeAlignInChars(E.getArg$Const(1).getType()).getQuantity());
      return CGBuiltinStatics.EmitX86MaskedLoad(/*Deref*/$this(), Ops, Align);
    }
   case X86.BI__builtin_ia32_storehps:
   case X86.BI__builtin_ia32_storelps:
    {
      org.llvm.ir.Type /*P*/ PtrTy = org.llvm.ir.PointerType.getUnqual(Int64Ty);
      org.llvm.ir.Type /*P*/ VecTy = org.llvm.ir.VectorType.get(Int64Ty, 2);
      
      // cast val v2i64
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), VecTy, new Twine(/*KEEP_STR*/"cast")));
      
      // extract (0, 1)
      /*uint*/int Index = BuiltinID == X86.BI__builtin_ia32_storelps ? 0 : 1;
      Value /*P*/ Idx = ConstantInt.get(Unnamed_field8.SizeTy, $uint2ulong(Index));
      Ops.$set(1, $this().Builder.CreateExtractElement(Ops.$at(1), Idx, new Twine(/*KEEP_STR*/"extract")));
      
      // cast pointer to i64 & store
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), PtrTy));
      return $this().Builder.CreateDefaultAlignedStore(Ops.$at(1), Ops.$at(0));
    }
   case X86.BI__builtin_ia32_palignr128:
   case X86.BI__builtin_ia32_palignr256:
   case X86.BI__builtin_ia32_palignr128_mask:
   case X86.BI__builtin_ia32_palignr256_mask:
   case X86.BI__builtin_ia32_palignr512_mask:
    {
      /*uint*/int ShiftVal = $ulong2uint(IrRTTI.cast_ConstantInt(Ops.$at(2)).getZExtValue());
      
      /*uint*/int NumElts = Ops.$at(0).getType().getVectorNumElements();
      assert ($rem_uint(NumElts, 16) == 0);
      
      // If palignr is shifting the pair of vectors more than the size of two
      // lanes, emit zero.
      if ($greatereq_uint(ShiftVal, 32)) {
        return Constant.getNullValue($this().ConvertType(E.getType()));
      }
      
      // If palignr is shifting the pair of input vectors more than one lane,
      // but less than two lanes, convert to shifting in zeroes.
      if ($greater_uint(ShiftVal, 16)) {
        ShiftVal -= 16;
        Ops.$set(1, Ops.$at(0));
        Ops.$set(0, Constant.getNullValue(Ops.$at(0).getType()));
      }
      
      /*uint32_t*/int Indices[/*64*/] = new$uint(64);
      // 256-bit palignr operates on 128-bit lanes so we need to handle that
      for (/*uint*/int l = 0; l != NumElts; l += 16) {
        for (/*uint*/int i = 0; i != 16; ++i) {
          /*uint*/int Idx = ShiftVal + i;
          if ($greatereq_uint(Idx, 16)) {
            Idx += NumElts - 16; // End of lane, switch operand.
          }
          Indices[l + i] = Idx + l;
        }
      }
      
      Value /*P*/ Align = $this().Builder.CreateShuffleVector(Ops.$at(1), Ops.$at(0), 
          makeArrayRef(Indices, NumElts), 
          new Twine(/*KEEP_STR*/"palignr"));
      
      // If this isn't a masked builtin, just return the align operation.
      if (Ops.size() == 3) {
        return Align;
      }
      
      return CGBuiltinStatics.EmitX86Select(/*Deref*/$this(), Ops.$at(4), Align, Ops.$at(3));
    }
   case X86.BI__builtin_ia32_movnti:
   case X86.BI__builtin_ia32_movnti64:
    {
      MDNode /*P*/ Node = MDNode.get($this().getLLVMContext(), new ArrayRef<Metadata /*P*/ >(ConstantAsMetadata.get($this().Builder.getInt32(1)), true));
      
      // Convert the type of the pointer to a pointer to the stored type.
      Value /*P*/ BC = $this().Builder.CreateBitCast(Ops.$at(0), 
          org.llvm.ir.PointerType.getUnqual(Ops.$at(1).getType()), 
          new Twine(/*KEEP_STR*/"cast"));
      StoreInst /*P*/ SI = $this().Builder.CreateDefaultAlignedStore(Ops.$at(1), BC);
      SI.setMetadata($this().CGM.getModule().getMDKindID(new StringRef(/*KEEP_STR*/"nontemporal")), Node);
      
      // No alignment for scalar intrinsic store.
      SI.setAlignment(1);
      return SI;
    }
   case X86.BI__builtin_ia32_movntsd:
   case X86.BI__builtin_ia32_movntss:
    {
      MDNode /*P*/ Node = MDNode.get($this().getLLVMContext(), new ArrayRef<Metadata /*P*/ >(ConstantAsMetadata.get($this().Builder.getInt32(1)), true));
      
      // Extract the 0'th element of the source vector.
      Value /*P*/ Scl = $this().Builder.CreateExtractElement(Ops.$at(1), (long/*uint64_t*/)$int2ulong(0), new Twine(/*KEEP_STR*/"extract"));
      
      // Convert the type of the pointer to a pointer to the stored type.
      Value /*P*/ BC = $this().Builder.CreateBitCast(Ops.$at(0), 
          org.llvm.ir.PointerType.getUnqual(Scl.getType()), 
          new Twine(/*KEEP_STR*/"cast"));
      
      // Unaligned nontemporal store of the scalar value.
      StoreInst /*P*/ SI = $this().Builder.CreateDefaultAlignedStore(Scl, BC);
      SI.setMetadata($this().CGM.getModule().getMDKindID(new StringRef(/*KEEP_STR*/"nontemporal")), Node);
      SI.setAlignment(1);
      return SI;
    }
   case X86.BI__builtin_ia32_selectb_128:
   case X86.BI__builtin_ia32_selectb_256:
   case X86.BI__builtin_ia32_selectb_512:
   case X86.BI__builtin_ia32_selectw_128:
   case X86.BI__builtin_ia32_selectw_256:
   case X86.BI__builtin_ia32_selectw_512:
   case X86.BI__builtin_ia32_selectd_128:
   case X86.BI__builtin_ia32_selectd_256:
   case X86.BI__builtin_ia32_selectd_512:
   case X86.BI__builtin_ia32_selectq_128:
   case X86.BI__builtin_ia32_selectq_256:
   case X86.BI__builtin_ia32_selectq_512:
   case X86.BI__builtin_ia32_selectps_128:
   case X86.BI__builtin_ia32_selectps_256:
   case X86.BI__builtin_ia32_selectps_512:
   case X86.BI__builtin_ia32_selectpd_128:
   case X86.BI__builtin_ia32_selectpd_256:
   case X86.BI__builtin_ia32_selectpd_512:
    return CGBuiltinStatics.EmitX86Select(/*Deref*/$this(), Ops.$at(0), Ops.$at(1), Ops.$at(2));
   case X86.BI__builtin_ia32_pcmpeqb128_mask:
   case X86.BI__builtin_ia32_pcmpeqb256_mask:
   case X86.BI__builtin_ia32_pcmpeqb512_mask:
   case X86.BI__builtin_ia32_pcmpeqw128_mask:
   case X86.BI__builtin_ia32_pcmpeqw256_mask:
   case X86.BI__builtin_ia32_pcmpeqw512_mask:
   case X86.BI__builtin_ia32_pcmpeqd128_mask:
   case X86.BI__builtin_ia32_pcmpeqd256_mask:
   case X86.BI__builtin_ia32_pcmpeqd512_mask:
   case X86.BI__builtin_ia32_pcmpeqq128_mask:
   case X86.BI__builtin_ia32_pcmpeqq256_mask:
   case X86.BI__builtin_ia32_pcmpeqq512_mask:
    return CGBuiltinStatics.EmitX86MaskedCompare(/*Deref*/$this(), 0, false, Ops);
   case X86.BI__builtin_ia32_pcmpgtb128_mask:
   case X86.BI__builtin_ia32_pcmpgtb256_mask:
   case X86.BI__builtin_ia32_pcmpgtb512_mask:
   case X86.BI__builtin_ia32_pcmpgtw128_mask:
   case X86.BI__builtin_ia32_pcmpgtw256_mask:
   case X86.BI__builtin_ia32_pcmpgtw512_mask:
   case X86.BI__builtin_ia32_pcmpgtd128_mask:
   case X86.BI__builtin_ia32_pcmpgtd256_mask:
   case X86.BI__builtin_ia32_pcmpgtd512_mask:
   case X86.BI__builtin_ia32_pcmpgtq128_mask:
   case X86.BI__builtin_ia32_pcmpgtq256_mask:
   case X86.BI__builtin_ia32_pcmpgtq512_mask:
    return CGBuiltinStatics.EmitX86MaskedCompare(/*Deref*/$this(), 6, true, Ops);
   case X86.BI__builtin_ia32_cmpb128_mask:
   case X86.BI__builtin_ia32_cmpb256_mask:
   case X86.BI__builtin_ia32_cmpb512_mask:
   case X86.BI__builtin_ia32_cmpw128_mask:
   case X86.BI__builtin_ia32_cmpw256_mask:
   case X86.BI__builtin_ia32_cmpw512_mask:
   case X86.BI__builtin_ia32_cmpd128_mask:
   case X86.BI__builtin_ia32_cmpd256_mask:
   case X86.BI__builtin_ia32_cmpd512_mask:
   case X86.BI__builtin_ia32_cmpq128_mask:
   case X86.BI__builtin_ia32_cmpq256_mask:
   case X86.BI__builtin_ia32_cmpq512_mask:
    {
      /*uint*/int CC = $ullong2uint(IrRTTI.cast_ConstantInt(Ops.$at(2)).getZExtValue() & $int2ullong(0x7));
      return CGBuiltinStatics.EmitX86MaskedCompare(/*Deref*/$this(), CC, true, Ops);
    }
   case X86.BI__builtin_ia32_ucmpb128_mask:
   case X86.BI__builtin_ia32_ucmpb256_mask:
   case X86.BI__builtin_ia32_ucmpb512_mask:
   case X86.BI__builtin_ia32_ucmpw128_mask:
   case X86.BI__builtin_ia32_ucmpw256_mask:
   case X86.BI__builtin_ia32_ucmpw512_mask:
   case X86.BI__builtin_ia32_ucmpd128_mask:
   case X86.BI__builtin_ia32_ucmpd256_mask:
   case X86.BI__builtin_ia32_ucmpd512_mask:
   case X86.BI__builtin_ia32_ucmpq128_mask:
   case X86.BI__builtin_ia32_ucmpq256_mask:
   case X86.BI__builtin_ia32_ucmpq512_mask:
    {
      /*uint*/int CC = $ullong2uint(IrRTTI.cast_ConstantInt(Ops.$at(2)).getZExtValue() & $int2ullong(0x7));
      return CGBuiltinStatics.EmitX86MaskedCompare(/*Deref*/$this(), CC, false, Ops);
    }
   case X86.BI__builtin_ia32_vplzcntd_128_mask:
   case X86.BI__builtin_ia32_vplzcntd_256_mask:
   case X86.BI__builtin_ia32_vplzcntd_512_mask:
   case X86.BI__builtin_ia32_vplzcntq_128_mask:
   case X86.BI__builtin_ia32_vplzcntq_256_mask:
   case X86.BI__builtin_ia32_vplzcntq_512_mask:
    {
      Function /*P*/ F = $this().CGM.getIntrinsic(org.llvm.ir.intrinsic.ID.ctlz, new ArrayRef<Type /*P*/ >(Ops.$at(0).getType(), true));
      return CGBuiltinStatics.EmitX86Select(/*Deref*/$this(), Ops.$at(2), 
          $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Ops.$at(0), $this().Builder.getInt1(false)}, true)/* }*/), 
          Ops.$at(1));
    }
   case X86.BI__builtin_ia32_pmaxsb128:
   case X86.BI__builtin_ia32_pmaxsw128:
   case X86.BI__builtin_ia32_pmaxsd128:
   case X86.BI__builtin_ia32_pmaxsb256:
   case X86.BI__builtin_ia32_pmaxsw256:
   case X86.BI__builtin_ia32_pmaxsd256:
    {
      Value /*P*/ Cmp = $this().Builder.CreateICmp(ICmpInst.Predicate.ICMP_SGT, Ops.$at(0), Ops.$at(1));
      return $this().Builder.CreateSelect(Cmp, Ops.$at(0), Ops.$at(1));
    }
   case X86.BI__builtin_ia32_pmaxub128:
   case X86.BI__builtin_ia32_pmaxuw128:
   case X86.BI__builtin_ia32_pmaxud128:
   case X86.BI__builtin_ia32_pmaxub256:
   case X86.BI__builtin_ia32_pmaxuw256:
   case X86.BI__builtin_ia32_pmaxud256:
    {
      Value /*P*/ Cmp = $this().Builder.CreateICmp(ICmpInst.Predicate.ICMP_UGT, Ops.$at(0), Ops.$at(1));
      return $this().Builder.CreateSelect(Cmp, Ops.$at(0), Ops.$at(1));
    }
   case X86.BI__builtin_ia32_pminsb128:
   case X86.BI__builtin_ia32_pminsw128:
   case X86.BI__builtin_ia32_pminsd128:
   case X86.BI__builtin_ia32_pminsb256:
   case X86.BI__builtin_ia32_pminsw256:
   case X86.BI__builtin_ia32_pminsd256:
    {
      Value /*P*/ Cmp = $this().Builder.CreateICmp(ICmpInst.Predicate.ICMP_SLT, Ops.$at(0), Ops.$at(1));
      return $this().Builder.CreateSelect(Cmp, Ops.$at(0), Ops.$at(1));
    }
   case X86.BI__builtin_ia32_pminub128:
   case X86.BI__builtin_ia32_pminuw128:
   case X86.BI__builtin_ia32_pminud128:
   case X86.BI__builtin_ia32_pminub256:
   case X86.BI__builtin_ia32_pminuw256:
   case X86.BI__builtin_ia32_pminud256:
    {
      Value /*P*/ Cmp = $this().Builder.CreateICmp(ICmpInst.Predicate.ICMP_ULT, Ops.$at(0), Ops.$at(1));
      return $this().Builder.CreateSelect(Cmp, Ops.$at(0), Ops.$at(1));
    }
   case X86.BI__builtin_ia32_pswapdsf:
   case X86.BI__builtin_ia32_pswapdsi:
    {
      Type /*P*/ MMXTy = Type.getX86_MMXTy($this().getLLVMContext());
      Ops.$set(0, $this().Builder.CreateBitCast(Ops.$at(0), MMXTy, new Twine(/*KEEP_STR*/"cast")));
      Function /*P*/ F = $this().CGM.getIntrinsic(org.llvm.ir.intrinsic.ID.x86_3dnowa_pswapd);
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Ops, true), new Twine(/*KEEP_STR*/"pswapd"));
    }
   case X86.BI__builtin_ia32_rdrand16_step:
   case X86.BI__builtin_ia32_rdrand32_step:
   case X86.BI__builtin_ia32_rdrand64_step:
   case X86.BI__builtin_ia32_rdseed16_step:
   case X86.BI__builtin_ia32_rdseed32_step:
   case X86.BI__builtin_ia32_rdseed64_step:
    {
      /*Intrinsic.ID*/int ID2;
      switch (BuiltinID) {
       default:
        throw new llvm_unreachable("Unsupported intrinsic!");
       case X86.BI__builtin_ia32_rdrand16_step:
        ID2 = org.llvm.ir.intrinsic.ID.x86_rdrand_16;
        break;
       case X86.BI__builtin_ia32_rdrand32_step:
        ID2 = org.llvm.ir.intrinsic.ID.x86_rdrand_32;
        break;
       case X86.BI__builtin_ia32_rdrand64_step:
        ID2 = org.llvm.ir.intrinsic.ID.x86_rdrand_64;
        break;
       case X86.BI__builtin_ia32_rdseed16_step:
        ID2 = org.llvm.ir.intrinsic.ID.x86_rdseed_16;
        break;
       case X86.BI__builtin_ia32_rdseed32_step:
        ID2 = org.llvm.ir.intrinsic.ID.x86_rdseed_32;
        break;
       case X86.BI__builtin_ia32_rdseed64_step:
        ID2 = org.llvm.ir.intrinsic.ID.x86_rdseed_64;
        break;
      }
      
      Value /*P*/ Call = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID2));
      $this().Builder.CreateDefaultAlignedStore($this().Builder.CreateExtractValue(Call, new ArrayRefUInt(0)), 
          Ops.$at(0));
      return $this().Builder.CreateExtractValue(Call, new ArrayRefUInt(1));
    }
   case X86.BI__builtin_ia32_cmpeqps:
   case X86.BI__builtin_ia32_cmpeqpd:
    
    // SSE packed comparison intrinsics
    return getVectorFCmpIR.$call(/*KEEP_ENUM*/CmpInst.Predicate.FCMP_OEQ);
   case X86.BI__builtin_ia32_cmpltps:
   case X86.BI__builtin_ia32_cmpltpd:
    return getVectorFCmpIR.$call(/*KEEP_ENUM*/CmpInst.Predicate.FCMP_OLT);
   case X86.BI__builtin_ia32_cmpleps:
   case X86.BI__builtin_ia32_cmplepd:
    return getVectorFCmpIR.$call(/*KEEP_ENUM*/CmpInst.Predicate.FCMP_OLE);
   case X86.BI__builtin_ia32_cmpunordps:
   case X86.BI__builtin_ia32_cmpunordpd:
    return getVectorFCmpIR.$call(/*KEEP_ENUM*/CmpInst.Predicate.FCMP_UNO);
   case X86.BI__builtin_ia32_cmpneqps:
   case X86.BI__builtin_ia32_cmpneqpd:
    return getVectorFCmpIR.$call(/*KEEP_ENUM*/CmpInst.Predicate.FCMP_UNE);
   case X86.BI__builtin_ia32_cmpnltps:
   case X86.BI__builtin_ia32_cmpnltpd:
    return getVectorFCmpIR.$call(/*KEEP_ENUM*/CmpInst.Predicate.FCMP_UGE);
   case X86.BI__builtin_ia32_cmpnleps:
   case X86.BI__builtin_ia32_cmpnlepd:
    return getVectorFCmpIR.$call(/*KEEP_ENUM*/CmpInst.Predicate.FCMP_UGT);
   case X86.BI__builtin_ia32_cmpordps:
   case X86.BI__builtin_ia32_cmpordpd:
    return getVectorFCmpIR.$call(/*KEEP_ENUM*/CmpInst.Predicate.FCMP_ORD);
   case X86.BI__builtin_ia32_cmpps:
   case X86.BI__builtin_ia32_cmpps256:
   case X86.BI__builtin_ia32_cmppd:
   case X86.BI__builtin_ia32_cmppd256:
    {
      /*uint*/int CC = $ulong2uint(IrRTTI.cast_ConstantInt(Ops.$at(2)).getZExtValue());
      // If this one of the SSE immediates, we can use native IR.
      if ($less_uint(CC, 8)) {
        FCmpInst.Predicate Pred1 = FCmpInst.Predicate.FCMP_FALSE;
        switch (CC) {
         case 0:
          Pred1 = FCmpInst.Predicate.FCMP_OEQ;
          break;
         case 1:
          Pred1 = FCmpInst.Predicate.FCMP_OLT;
          break;
         case 2:
          Pred1 = FCmpInst.Predicate.FCMP_OLE;
          break;
         case 3:
          Pred1 = FCmpInst.Predicate.FCMP_UNO;
          break;
         case 4:
          Pred1 = FCmpInst.Predicate.FCMP_UNE;
          break;
         case 5:
          Pred1 = FCmpInst.Predicate.FCMP_UGE;
          break;
         case 6:
          Pred1 = FCmpInst.Predicate.FCMP_UGT;
          break;
         case 7:
          Pred1 = FCmpInst.Predicate.FCMP_ORD;
          break;
        }
        return getVectorFCmpIR.$call(/*KEEP_ENUM*/Pred1);
      }
      
      // We can't handle 8-31 immediates with native IR, use the intrinsic.
      /*Intrinsic.ID*/int ID3;
      switch (BuiltinID) {
       default:
        throw new llvm_unreachable("Unsupported intrinsic!");
       case X86.BI__builtin_ia32_cmpps:
        ID3 = org.llvm.ir.intrinsic.ID.x86_sse_cmp_ps;
        break;
       case X86.BI__builtin_ia32_cmpps256:
        ID3 = org.llvm.ir.intrinsic.ID.x86_avx_cmp_ps_256;
        break;
       case X86.BI__builtin_ia32_cmppd:
        ID3 = org.llvm.ir.intrinsic.ID.x86_sse2_cmp_pd;
        break;
       case X86.BI__builtin_ia32_cmppd256:
        ID3 = org.llvm.ir.intrinsic.ID.x86_avx_cmp_pd_256;
        break;
      }
      
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID3), new ArrayRef<Value /*P*/ >(Ops, true));
    }
   case X86.BI__builtin_ia32_cmpeqss:
    
    // SSE scalar comparison intrinsics
    return getCmpIntrinsicCall.$call(/*KEEP_ENUM*/org.llvm.ir.intrinsic.ID.x86_sse_cmp_ss, 0);
   case X86.BI__builtin_ia32_cmpltss:
    return getCmpIntrinsicCall.$call(/*KEEP_ENUM*/org.llvm.ir.intrinsic.ID.x86_sse_cmp_ss, 1);
   case X86.BI__builtin_ia32_cmpless:
    return getCmpIntrinsicCall.$call(/*KEEP_ENUM*/org.llvm.ir.intrinsic.ID.x86_sse_cmp_ss, 2);
   case X86.BI__builtin_ia32_cmpunordss:
    return getCmpIntrinsicCall.$call(/*KEEP_ENUM*/org.llvm.ir.intrinsic.ID.x86_sse_cmp_ss, 3);
   case X86.BI__builtin_ia32_cmpneqss:
    return getCmpIntrinsicCall.$call(/*KEEP_ENUM*/org.llvm.ir.intrinsic.ID.x86_sse_cmp_ss, 4);
   case X86.BI__builtin_ia32_cmpnltss:
    return getCmpIntrinsicCall.$call(/*KEEP_ENUM*/org.llvm.ir.intrinsic.ID.x86_sse_cmp_ss, 5);
   case X86.BI__builtin_ia32_cmpnless:
    return getCmpIntrinsicCall.$call(/*KEEP_ENUM*/org.llvm.ir.intrinsic.ID.x86_sse_cmp_ss, 6);
   case X86.BI__builtin_ia32_cmpordss:
    return getCmpIntrinsicCall.$call(/*KEEP_ENUM*/org.llvm.ir.intrinsic.ID.x86_sse_cmp_ss, 7);
   case X86.BI__builtin_ia32_cmpeqsd:
    return getCmpIntrinsicCall.$call(/*KEEP_ENUM*/org.llvm.ir.intrinsic.ID.x86_sse2_cmp_sd, 0);
   case X86.BI__builtin_ia32_cmpltsd:
    return getCmpIntrinsicCall.$call(/*KEEP_ENUM*/org.llvm.ir.intrinsic.ID.x86_sse2_cmp_sd, 1);
   case X86.BI__builtin_ia32_cmplesd:
    return getCmpIntrinsicCall.$call(/*KEEP_ENUM*/org.llvm.ir.intrinsic.ID.x86_sse2_cmp_sd, 2);
   case X86.BI__builtin_ia32_cmpunordsd:
    return getCmpIntrinsicCall.$call(/*KEEP_ENUM*/org.llvm.ir.intrinsic.ID.x86_sse2_cmp_sd, 3);
   case X86.BI__builtin_ia32_cmpneqsd:
    return getCmpIntrinsicCall.$call(/*KEEP_ENUM*/org.llvm.ir.intrinsic.ID.x86_sse2_cmp_sd, 4);
   case X86.BI__builtin_ia32_cmpnltsd:
    return getCmpIntrinsicCall.$call(/*KEEP_ENUM*/org.llvm.ir.intrinsic.ID.x86_sse2_cmp_sd, 5);
   case X86.BI__builtin_ia32_cmpnlesd:
    return getCmpIntrinsicCall.$call(/*KEEP_ENUM*/org.llvm.ir.intrinsic.ID.x86_sse2_cmp_sd, 6);
   case X86.BI__builtin_ia32_cmpordsd:
    return getCmpIntrinsicCall.$call(/*KEEP_ENUM*/org.llvm.ir.intrinsic.ID.x86_sse2_cmp_sd, 7);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitPPCBuiltinExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 7370,
 FQN="clang::CodeGen::CodeGenFunction::EmitPPCBuiltinExpr", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitPPCBuiltinExprEjPKNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitPPCBuiltinExprEjPKNS_8CallExprE")
//</editor-fold>
public final Value /*P*/ EmitPPCBuiltinExpr(/*uint*/int BuiltinID, 
                  /*const*/ CallExpr /*P*/ E) {
  SmallVector<Value /*P*/ > Ops/*J*/= new SmallVector<Value /*P*/ >(4, (Value /*P*/ )null);
  
  for (/*uint*/int i = 0, e = E.getNumArgs(); i != e; i++)  {
    Ops.push_back($this().EmitScalarExpr(E.getArg$Const(i)));
  }
  
  /*Intrinsic.ID*/int ID = org.llvm.ir.intrinsic.ID.not_intrinsic;
  switch (BuiltinID) {
   default:
    return null;
   case PPC.BI__builtin_ppc_get_timebase:
    
    // __builtin_ppc_get_timebase is GCC 4.8+'s PowerPC-specific name for what we
    // call __builtin_readcyclecounter.
    return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(org.llvm.ir.intrinsic.ID.readcyclecounter));
   case PPC.BI__builtin_altivec_lvx:
   case PPC.BI__builtin_altivec_lvxl:
   case PPC.BI__builtin_altivec_lvebx:
   case PPC.BI__builtin_altivec_lvehx:
   case PPC.BI__builtin_altivec_lvewx:
   case PPC.BI__builtin_altivec_lvsl:
   case PPC.BI__builtin_altivec_lvsr:
   case PPC.BI__builtin_vsx_lxvd2x:
   case PPC.BI__builtin_vsx_lxvw4x:
    {
      Ops.$set(1, $this().Builder.CreateBitCast(Ops.$at(1), Unnamed_field9.Int8PtrTy));
      
      Ops.$set(0, $this().Builder.CreateGEP(Ops.$at(1), Ops.$at(0)));
      Ops.pop_back();
      switch (BuiltinID) {
       default:
        throw new llvm_unreachable("Unsupported ld/lvsl/lvsr intrinsic!");
       case PPC.BI__builtin_altivec_lvx:
        ID = org.llvm.ir.intrinsic.ID.ppc_altivec_lvx;
        break;
       case PPC.BI__builtin_altivec_lvxl:
        ID = org.llvm.ir.intrinsic.ID.ppc_altivec_lvxl;
        break;
       case PPC.BI__builtin_altivec_lvebx:
        ID = org.llvm.ir.intrinsic.ID.ppc_altivec_lvebx;
        break;
       case PPC.BI__builtin_altivec_lvehx:
        ID = org.llvm.ir.intrinsic.ID.ppc_altivec_lvehx;
        break;
       case PPC.BI__builtin_altivec_lvewx:
        ID = org.llvm.ir.intrinsic.ID.ppc_altivec_lvewx;
        break;
       case PPC.BI__builtin_altivec_lvsl:
        ID = org.llvm.ir.intrinsic.ID.ppc_altivec_lvsl;
        break;
       case PPC.BI__builtin_altivec_lvsr:
        ID = org.llvm.ir.intrinsic.ID.ppc_altivec_lvsr;
        break;
       case PPC.BI__builtin_vsx_lxvd2x:
        ID = org.llvm.ir.intrinsic.ID.ppc_vsx_lxvd2x;
        break;
       case PPC.BI__builtin_vsx_lxvw4x:
        ID = org.llvm.ir.intrinsic.ID.ppc_vsx_lxvw4x;
        break;
      }
      Function /*P*/ F = $this().CGM.getIntrinsic(ID);
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Ops, true), new Twine(/*KEEP_STR*/$EMPTY));
    }
   case PPC.BI__builtin_altivec_stvx:
   case PPC.BI__builtin_altivec_stvxl:
   case PPC.BI__builtin_altivec_stvebx:
   case PPC.BI__builtin_altivec_stvehx:
   case PPC.BI__builtin_altivec_stvewx:
   case PPC.BI__builtin_vsx_stxvd2x:
   case PPC.BI__builtin_vsx_stxvw4x:
    {
      Ops.$set(2, $this().Builder.CreateBitCast(Ops.$at(2), Unnamed_field9.Int8PtrTy));
      Ops.$set(1, $this().Builder.CreateGEP(Ops.$at(2), Ops.$at(1)));
      Ops.pop_back();
      switch (BuiltinID) {
       default:
        throw new llvm_unreachable("Unsupported st intrinsic!");
       case PPC.BI__builtin_altivec_stvx:
        ID = org.llvm.ir.intrinsic.ID.ppc_altivec_stvx;
        break;
       case PPC.BI__builtin_altivec_stvxl:
        ID = org.llvm.ir.intrinsic.ID.ppc_altivec_stvxl;
        break;
       case PPC.BI__builtin_altivec_stvebx:
        ID = org.llvm.ir.intrinsic.ID.ppc_altivec_stvebx;
        break;
       case PPC.BI__builtin_altivec_stvehx:
        ID = org.llvm.ir.intrinsic.ID.ppc_altivec_stvehx;
        break;
       case PPC.BI__builtin_altivec_stvewx:
        ID = org.llvm.ir.intrinsic.ID.ppc_altivec_stvewx;
        break;
       case PPC.BI__builtin_vsx_stxvd2x:
        ID = org.llvm.ir.intrinsic.ID.ppc_vsx_stxvd2x;
        break;
       case PPC.BI__builtin_vsx_stxvw4x:
        ID = org.llvm.ir.intrinsic.ID.ppc_vsx_stxvw4x;
        break;
      }
      Function /*P*/ F = $this().CGM.getIntrinsic(ID);
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(Ops, true), new Twine(/*KEEP_STR*/$EMPTY));
    }
   case PPC.BI__builtin_vsx_xvsqrtsp:
   case PPC.BI__builtin_vsx_xvsqrtdp:
    {
      org.llvm.ir.Type /*P*/ ResultType = $this().ConvertType(E.getType());
      Value /*P*/ X = $this().EmitScalarExpr(E.getArg$Const(0));
      ID = org.llvm.ir.intrinsic.ID.sqrt;
      Function /*P*/ F = $this().CGM.getIntrinsic(ID, new ArrayRef<Type /*P*/ >(ResultType, true));
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(X, true));
    }
   case PPC.BI__builtin_altivec_vclzb:
   case PPC.BI__builtin_altivec_vclzh:
   case PPC.BI__builtin_altivec_vclzw:
   case PPC.BI__builtin_altivec_vclzd:
    {
      org.llvm.ir.Type /*P*/ ResultType = $this().ConvertType(E.getType());
      Value /*P*/ X = $this().EmitScalarExpr(E.getArg$Const(0));
      Value /*P*/ Undef = ConstantInt.get($this().Builder.getInt1Ty(), /*false*/0);
      Function /*P*/ F = $this().CGM.getIntrinsic(org.llvm.ir.intrinsic.ID.ctlz, new ArrayRef<Type /*P*/ >(ResultType, true));
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {X, Undef}, true)/* }*/);
    }
   case PPC.BI__builtin_vsx_xvcpsgnsp:
   case PPC.BI__builtin_vsx_xvcpsgndp:
    {
      org.llvm.ir.Type /*P*/ ResultType = $this().ConvertType(E.getType());
      Value /*P*/ X = $this().EmitScalarExpr(E.getArg$Const(0));
      Value /*P*/ Y = $this().EmitScalarExpr(E.getArg$Const(1));
      ID = org.llvm.ir.intrinsic.ID.copysign;
      Function /*P*/ F = $this().CGM.getIntrinsic(ID, new ArrayRef<Type /*P*/ >(ResultType, true));
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {X, Y}, true)/* }*/);
    }
   case PPC.BI__builtin_vsx_xvrspip:
   case PPC.BI__builtin_vsx_xvrdpip:
   case PPC.BI__builtin_vsx_xvrdpim:
   case PPC.BI__builtin_vsx_xvrspim:
   case PPC.BI__builtin_vsx_xvrdpi:
   case PPC.BI__builtin_vsx_xvrspi:
   case PPC.BI__builtin_vsx_xvrdpic:
   case PPC.BI__builtin_vsx_xvrspic:
   case PPC.BI__builtin_vsx_xvrdpiz:
   case PPC.BI__builtin_vsx_xvrspiz:
    {
      org.llvm.ir.Type /*P*/ ResultType = $this().ConvertType(E.getType());
      Value /*P*/ X = $this().EmitScalarExpr(E.getArg$Const(0));
      if (BuiltinID == PPC.BI__builtin_vsx_xvrdpim
         || BuiltinID == PPC.BI__builtin_vsx_xvrspim) {
        ID = org.llvm.ir.intrinsic.ID.floor;
      } else if (BuiltinID == PPC.BI__builtin_vsx_xvrdpi
         || BuiltinID == PPC.BI__builtin_vsx_xvrspi) {
        ID = org.llvm.ir.intrinsic.ID.round;
      } else if (BuiltinID == PPC.BI__builtin_vsx_xvrdpic
         || BuiltinID == PPC.BI__builtin_vsx_xvrspic) {
        ID = org.llvm.ir.intrinsic.ID.nearbyint;
      } else if (BuiltinID == PPC.BI__builtin_vsx_xvrdpip
         || BuiltinID == PPC.BI__builtin_vsx_xvrspip) {
        ID = org.llvm.ir.intrinsic.ID.ceil;
      } else if (BuiltinID == PPC.BI__builtin_vsx_xvrdpiz
         || BuiltinID == PPC.BI__builtin_vsx_xvrspiz) {
        ID = org.llvm.ir.intrinsic.ID.trunc;
      }
      Function /*P*/ F = $this().CGM.getIntrinsic(ID, new ArrayRef<Type /*P*/ >(ResultType, true));
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(X, true));
    }
   case PPC.BI__builtin_vsx_xvabsdp:
   case PPC.BI__builtin_vsx_xvabssp:
    {
      org.llvm.ir.Type /*P*/ ResultType = $this().ConvertType(E.getType());
      Value /*P*/ X = $this().EmitScalarExpr(E.getArg$Const(0));
      Function /*P*/ F = $this().CGM.getIntrinsic(org.llvm.ir.intrinsic.ID.fabs, new ArrayRef<Type /*P*/ >(ResultType, true));
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(X, true));
    }
   case PPC.BI__builtin_vsx_xvmaddadp:
   case PPC.BI__builtin_vsx_xvmaddasp:
   case PPC.BI__builtin_vsx_xvnmaddadp:
   case PPC.BI__builtin_vsx_xvnmaddasp:
   case PPC.BI__builtin_vsx_xvmsubadp:
   case PPC.BI__builtin_vsx_xvmsubasp:
   case PPC.BI__builtin_vsx_xvnmsubadp:
   case PPC.BI__builtin_vsx_xvnmsubasp:
    {
      org.llvm.ir.Type /*P*/ ResultType = $this().ConvertType(E.getType());
      Value /*P*/ X = $this().EmitScalarExpr(E.getArg$Const(0));
      Value /*P*/ Y = $this().EmitScalarExpr(E.getArg$Const(1));
      Value /*P*/ Z = $this().EmitScalarExpr(E.getArg$Const(2));
      Value /*P*/ Zero = ConstantFP.getZeroValueForNegation(ResultType);
      Function /*P*/ F = $this().CGM.getIntrinsic(org.llvm.ir.intrinsic.ID.fma, new ArrayRef<Type /*P*/ >(ResultType, true));
      switch (BuiltinID) {
       case PPC.BI__builtin_vsx_xvmaddadp:
       case PPC.BI__builtin_vsx_xvmaddasp:
        return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {X, Y, Z}, true)/* }*/);
       case PPC.BI__builtin_vsx_xvnmaddadp:
       case PPC.BI__builtin_vsx_xvnmaddasp:
        return $this().Builder.CreateFSub(Zero, 
            $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {X, Y, Z}, true)/* }*/), new Twine(/*KEEP_STR*/"sub"));
       case PPC.BI__builtin_vsx_xvmsubadp:
       case PPC.BI__builtin_vsx_xvmsubasp:
        return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, 
            /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {X, Y, $this().Builder.CreateFSub(Zero, Z, new Twine(/*KEEP_STR*/"sub"))}, true)/* }*/);
       case PPC.BI__builtin_vsx_xvnmsubadp:
       case PPC.BI__builtin_vsx_xvnmsubasp:
        Value /*P*/ FsubRes = $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {X, Y, $this().Builder.CreateFSub(Zero, Z, new Twine(/*KEEP_STR*/"sub"))}, true)/* }*/);
        return $this().Builder.CreateFSub(Zero, FsubRes, new Twine(/*KEEP_STR*/"sub"));
      }
      throw new llvm_unreachable("Unknown FMA operation");
//      return null; // Suppress no-return warning
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAMDGPUBuiltinExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 7587,
 FQN="clang::CodeGen::CodeGenFunction::EmitAMDGPUBuiltinExpr", NM="_ZN5clang7CodeGen15CodeGenFunction21EmitAMDGPUBuiltinExprEjPKNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21EmitAMDGPUBuiltinExprEjPKNS_8CallExprE")
//</editor-fold>
public final Value /*P*/ EmitAMDGPUBuiltinExpr(/*uint*/int BuiltinID, 
                     /*const*/ CallExpr /*P*/ E) {
  switch (BuiltinID) {
   case AMDGPU.BI__builtin_amdgcn_div_scale:
   case AMDGPU.BI__builtin_amdgcn_div_scalef:
    {
      // Translate from the intrinsics's struct return to the builtin's out
      // argument.
      Address FlagOutPtr = $this().EmitPointerWithAlignment(E.getArg$Const(3));
      
      Value /*P*/ X = $this().EmitScalarExpr(E.getArg$Const(0));
      Value /*P*/ Y = $this().EmitScalarExpr(E.getArg$Const(1));
      Value /*P*/ Z = $this().EmitScalarExpr(E.getArg$Const(2));
      
      Value /*P*/ Callee = $this().CGM.getIntrinsic(ID.amdgcn_div_scale, 
          new ArrayRef<Type /*P*/ >(X.getType(), true));
      
      Value /*P*/ Tmp = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(Callee, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {X, Y, Z}, true)/* }*/);
      
      Value /*P*/ Result = $this().Builder.CreateExtractValue(Tmp, new ArrayRefUInt(0));
      Value /*P*/ Flag = $this().Builder.CreateExtractValue(Tmp, new ArrayRefUInt(1));
      
      org.llvm.ir.Type /*P*/ RealFlagType = FlagOutPtr.getPointer().getType().getPointerElementType();
      
      Value /*P*/ FlagExt = $this().Builder.CreateZExt(Flag, RealFlagType);
      $this().Builder.CreateStore(FlagExt, new Address(FlagOutPtr));
      return Result;
    }
   case AMDGPU.BI__builtin_amdgcn_div_fmas:
   case AMDGPU.BI__builtin_amdgcn_div_fmasf:
    {
      Value /*P*/ Src0 = $this().EmitScalarExpr(E.getArg$Const(0));
      Value /*P*/ Src1 = $this().EmitScalarExpr(E.getArg$Const(1));
      Value /*P*/ Src2 = $this().EmitScalarExpr(E.getArg$Const(2));
      Value /*P*/ Src3 = $this().EmitScalarExpr(E.getArg$Const(3));
      
      Value /*P*/ F = $this().CGM.getIntrinsic(ID.amdgcn_div_fmas, 
          new ArrayRef<Type /*P*/ >(Src0.getType(), true));
      Value /*P*/ Src3ToBool = $this().Builder.CreateIsNotNull(Src3);
      return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*4*/] {Src0, Src1, Src2, Src3ToBool}, true)/* }*/);
    }
   case AMDGPU.BI__builtin_amdgcn_div_fixup:
   case AMDGPU.BI__builtin_amdgcn_div_fixupf:
    return CGBuiltinStatics.emitTernaryBuiltin(/*Deref*/$this(), E, ID.amdgcn_div_fixup);
   case AMDGPU.BI__builtin_amdgcn_trig_preop:
   case AMDGPU.BI__builtin_amdgcn_trig_preopf:
    return CGBuiltinStatics.emitFPIntBuiltin(/*Deref*/$this(), E, ID.amdgcn_trig_preop);
   case AMDGPU.BI__builtin_amdgcn_rcp:
   case AMDGPU.BI__builtin_amdgcn_rcpf:
    return CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.amdgcn_rcp);
   case AMDGPU.BI__builtin_amdgcn_rsq:
   case AMDGPU.BI__builtin_amdgcn_rsqf:
    return CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.amdgcn_rsq);
   case AMDGPU.BI__builtin_amdgcn_rsq_clamp:
   case AMDGPU.BI__builtin_amdgcn_rsq_clampf:
    return CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.amdgcn_rsq_clamp);
   case AMDGPU.BI__builtin_amdgcn_sinf:
    return CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.amdgcn_sin);
   case AMDGPU.BI__builtin_amdgcn_cosf:
    return CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.amdgcn_cos);
   case AMDGPU.BI__builtin_amdgcn_log_clampf:
    return CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.amdgcn_log_clamp);
   case AMDGPU.BI__builtin_amdgcn_ldexp:
   case AMDGPU.BI__builtin_amdgcn_ldexpf:
    return CGBuiltinStatics.emitFPIntBuiltin(/*Deref*/$this(), E, ID.amdgcn_ldexp);
   case AMDGPU.BI__builtin_amdgcn_frexp_mant:
   case AMDGPU.BI__builtin_amdgcn_frexp_mantf:
    {
      return CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.amdgcn_frexp_mant);
    }
   case AMDGPU.BI__builtin_amdgcn_frexp_exp:
   case AMDGPU.BI__builtin_amdgcn_frexp_expf:
    {
      return CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.amdgcn_frexp_exp);
    }
   case AMDGPU.BI__builtin_amdgcn_fract:
   case AMDGPU.BI__builtin_amdgcn_fractf:
    return CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.amdgcn_fract);
   case AMDGPU.BI__builtin_amdgcn_lerp:
    return CGBuiltinStatics.emitTernaryBuiltin(/*Deref*/$this(), E, ID.amdgcn_lerp);
   case AMDGPU.BI__builtin_amdgcn_class:
   case AMDGPU.BI__builtin_amdgcn_classf:
    return CGBuiltinStatics.emitFPIntBuiltin(/*Deref*/$this(), E, ID.amdgcn_class);
   case AMDGPU.BI__builtin_amdgcn_read_exec:
    {
      CallInst /*P*/ CI = IrRTTI.cast_CallInst(CGBuiltinStatics.EmitSpecialRegisterBuiltin(/*Deref*/$this(), E, Int64Ty, Int64Ty, true, new StringRef(/*KEEP_STR*/"exec")));
      CI.setConvergent();
      return CI;
    }
   case AMDGPU.BI__builtin_amdgcn_workitem_id_x:
    
    // amdgcn workitem
    return CGBuiltinStatics.emitRangedBuiltin(/*Deref*/$this(), ID.amdgcn_workitem_id_x, 0, 1024);
   case AMDGPU.BI__builtin_amdgcn_workitem_id_y:
    return CGBuiltinStatics.emitRangedBuiltin(/*Deref*/$this(), ID.amdgcn_workitem_id_y, 0, 1024);
   case AMDGPU.BI__builtin_amdgcn_workitem_id_z:
    return CGBuiltinStatics.emitRangedBuiltin(/*Deref*/$this(), ID.amdgcn_workitem_id_z, 0, 1024);
   case AMDGPU.BI__builtin_r600_recipsqrt_ieee:
   case AMDGPU.BI__builtin_r600_recipsqrt_ieeef:
    
    // r600 intrinsics
    return CGBuiltinStatics.emitUnaryBuiltin(/*Deref*/$this(), E, ID.r600_recipsqrt_ieee);
   case AMDGPU.BI__builtin_r600_read_tidig_x:
    return CGBuiltinStatics.emitRangedBuiltin(/*Deref*/$this(), ID.r600_read_tidig_x, 0, 1024);
   case AMDGPU.BI__builtin_r600_read_tidig_y:
    return CGBuiltinStatics.emitRangedBuiltin(/*Deref*/$this(), ID.r600_read_tidig_y, 0, 1024);
   case AMDGPU.BI__builtin_r600_read_tidig_z:
    return CGBuiltinStatics.emitRangedBuiltin(/*Deref*/$this(), ID.r600_read_tidig_z, 0, 1024);
   default:
    return null;
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitSystemZBuiltinExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 7717,
 FQN="clang::CodeGen::CodeGenFunction::EmitSystemZBuiltinExpr", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitSystemZBuiltinExprEjPKNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitSystemZBuiltinExprEjPKNS_8CallExprE")
//</editor-fold>
public final Value /*P*/ EmitSystemZBuiltinExpr(/*uint*/int BuiltinID, 
                      /*const*/ CallExpr /*P*/ E) {
  switch (BuiltinID) {
   case SystemZ.BI__builtin_tbegin:
    {
      Value /*P*/ TDB = $this().EmitScalarExpr(E.getArg$Const(0));
      Value /*P*/ Control = ConstantInt.get(Int32Ty, $int2ulong(0xff0c));
      Value /*P*/ F = $this().CGM.getIntrinsic(ID.s390_tbegin);
      return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {TDB, Control}, true)/* }*/);
    }
   case SystemZ.BI__builtin_tbegin_nofloat:
    {
      Value /*P*/ TDB = $this().EmitScalarExpr(E.getArg$Const(0));
      Value /*P*/ Control = ConstantInt.get(Int32Ty, $int2ulong(0xff0c));
      Value /*P*/ F = $this().CGM.getIntrinsic(ID.s390_tbegin_nofloat);
      return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {TDB, Control}, true)/* }*/);
    }
   case SystemZ.BI__builtin_tbeginc:
    {
      Value /*P*/ TDB = ConstantPointerNull.get(Unnamed_field9.Int8PtrTy);
      Value /*P*/ Control = ConstantInt.get(Int32Ty, $int2ulong(0xff08));
      Value /*P*/ F = $this().CGM.getIntrinsic(ID.s390_tbeginc);
      return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {TDB, Control}, true)/* }*/);
    }
   case SystemZ.BI__builtin_tabort:
    {
      Value /*P*/ Data = $this().EmitScalarExpr(E.getArg$Const(0));
      Value /*P*/ F = $this().CGM.getIntrinsic(ID.s390_tabort);
      return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >($this().Builder.CreateSExt(Data, Int64Ty, new Twine(/*KEEP_STR*/"tabort")), true));
    }
   case SystemZ.BI__builtin_non_tx_store:
    {
      Value /*P*/ Address = $this().EmitScalarExpr(E.getArg$Const(0));
      Value /*P*/ Data = $this().EmitScalarExpr(E.getArg$Const(1));
      Value /*P*/ F = $this().CGM.getIntrinsic(ID.s390_ntstg);
      return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Data, Address}, true)/* }*/);
    }
   case SystemZ.BI__builtin_s390_vpopctb:
   case SystemZ.BI__builtin_s390_vpopcth:
   case SystemZ.BI__builtin_s390_vpopctf:
   case SystemZ.BI__builtin_s390_vpopctg:
    {
      Type /*P*/ ResultType = $this().ConvertType(E.getType());
      Value /*P*/ X = $this().EmitScalarExpr(E.getArg$Const(0));
      Function /*P*/ F = $this().CGM.getIntrinsic(ID.ctpop, new ArrayRef<Type /*P*/ >(ResultType, true));
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(X, true));
    }
   case SystemZ.BI__builtin_s390_vclzb:
   case SystemZ.BI__builtin_s390_vclzh:
   case SystemZ.BI__builtin_s390_vclzf:
   case SystemZ.BI__builtin_s390_vclzg:
    {
      Type /*P*/ ResultType = $this().ConvertType(E.getType());
      Value /*P*/ X = $this().EmitScalarExpr(E.getArg$Const(0));
      Value /*P*/ Undef = ConstantInt.get($this().Builder.getInt1Ty(), /*false*/0);
      Function /*P*/ F = $this().CGM.getIntrinsic(ID.ctlz, new ArrayRef<Type /*P*/ >(ResultType, true));
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {X, Undef}, true)/* }*/);
    }
   case SystemZ.BI__builtin_s390_vctzb:
   case SystemZ.BI__builtin_s390_vctzh:
   case SystemZ.BI__builtin_s390_vctzf:
   case SystemZ.BI__builtin_s390_vctzg:
    {
      Type /*P*/ ResultType = $this().ConvertType(E.getType());
      Value /*P*/ X = $this().EmitScalarExpr(E.getArg$Const(0));
      Value /*P*/ Undef = ConstantInt.get($this().Builder.getInt1Ty(), /*false*/0);
      Function /*P*/ F = $this().CGM.getIntrinsic(ID.cttz, new ArrayRef<Type /*P*/ >(ResultType, true));
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {X, Undef}, true)/* }*/);
    }
   case SystemZ.BI__builtin_s390_vfsqdb:
    {
      Type /*P*/ ResultType = $this().ConvertType(E.getType());
      Value /*P*/ X = $this().EmitScalarExpr(E.getArg$Const(0));
      Function /*P*/ F = $this().CGM.getIntrinsic(ID.sqrt, new ArrayRef<Type /*P*/ >(ResultType, true));
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(X, true));
    }
   case SystemZ.BI__builtin_s390_vfmadb:
    {
      Type /*P*/ ResultType = $this().ConvertType(E.getType());
      Value /*P*/ X = $this().EmitScalarExpr(E.getArg$Const(0));
      Value /*P*/ Y = $this().EmitScalarExpr(E.getArg$Const(1));
      Value /*P*/ Z = $this().EmitScalarExpr(E.getArg$Const(2));
      Function /*P*/ F = $this().CGM.getIntrinsic(ID.fma, new ArrayRef<Type /*P*/ >(ResultType, true));
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {X, Y, Z}, true)/* }*/);
    }
   case SystemZ.BI__builtin_s390_vfmsdb:
    {
      Type /*P*/ ResultType = $this().ConvertType(E.getType());
      Value /*P*/ X = $this().EmitScalarExpr(E.getArg$Const(0));
      Value /*P*/ Y = $this().EmitScalarExpr(E.getArg$Const(1));
      Value /*P*/ Z = $this().EmitScalarExpr(E.getArg$Const(2));
      Value /*P*/ Zero = ConstantFP.getZeroValueForNegation(ResultType);
      Function /*P*/ F = $this().CGM.getIntrinsic(ID.fma, new ArrayRef<Type /*P*/ >(ResultType, true));
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {X, Y, $this().Builder.CreateFSub(Zero, Z, new Twine(/*KEEP_STR*/"sub"))}, true)/* }*/);
    }
   case SystemZ.BI__builtin_s390_vflpdb:
    {
      Type /*P*/ ResultType = $this().ConvertType(E.getType());
      Value /*P*/ X = $this().EmitScalarExpr(E.getArg$Const(0));
      Function /*P*/ F = $this().CGM.getIntrinsic(ID.fabs, new ArrayRef<Type /*P*/ >(ResultType, true));
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(X, true));
    }
   case SystemZ.BI__builtin_s390_vflndb:
    {
      Type /*P*/ ResultType = $this().ConvertType(E.getType());
      Value /*P*/ X = $this().EmitScalarExpr(E.getArg$Const(0));
      Value /*P*/ Zero = ConstantFP.getZeroValueForNegation(ResultType);
      Function /*P*/ F = $this().CGM.getIntrinsic(ID.fabs, new ArrayRef<Type /*P*/ >(ResultType, true));
      return $this().Builder.CreateFSub(Zero, $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(X, true)), new Twine(/*KEEP_STR*/"sub"));
    }
   case SystemZ.BI__builtin_s390_vfidb:
    {
      Type /*P*/ ResultType = $this().ConvertType(E.getType());
      Value /*P*/ X = $this().EmitScalarExpr(E.getArg$Const(0));
      // Constant-fold the M4 and M5 mask arguments.
      APSInt M4/*J*/= new APSInt();
      APSInt M5/*J*/= new APSInt();
      boolean IsConstM4 = E.getArg$Const(1).isIntegerConstantExpr(M4, $this().getContext());
      boolean IsConstM5 = E.getArg$Const(2).isIntegerConstantExpr(M5, $this().getContext());
      assert (IsConstM4 && IsConstM5) : "Constant arg isn't actually constant?";
      ///*J:(void)*/IsConstM4;
      ///*J:(void)*/IsConstM5;
      // Check whether this instance of vfidb can be represented via a LLVM
      // standard intrinsic.  We only support some combinations of M4 and M5.
      /*Intrinsic.ID*/int ID = org.llvm.ir.intrinsic.ID.not_intrinsic;
      switch ((int)M4.getZExtValue()) {
       default:
        break;
       case 0: // IEEE-inexact exception allowed
        switch ((int)M5.getZExtValue()) {
         default:
          break;
         case 0:
          ID = org.llvm.ir.intrinsic.ID.rint;
          break;
        }
        break;
       case 4: // IEEE-inexact exception suppressed
        switch ((int)M5.getZExtValue()) {
         default:
          break;
         case 0:
          ID = org.llvm.ir.intrinsic.ID.nearbyint;
          break;
         case 1:
          ID = org.llvm.ir.intrinsic.ID.round;
          break;
         case 5:
          ID = org.llvm.ir.intrinsic.ID.trunc;
          break;
         case 6:
          ID = org.llvm.ir.intrinsic.ID.ceil;
          break;
         case 7:
          ID = org.llvm.ir.intrinsic.ID.floor;
          break;
        }
        break;
      }
      if (ID != org.llvm.ir.intrinsic.ID.not_intrinsic) {
        Function /*P*/ F = $this().CGM.getIntrinsic(ID, new ArrayRef<Type /*P*/ >(ResultType, true));
        return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(X, true));
      }
      Function /*P*/ F = $this().CGM.getIntrinsic(org.llvm.ir.intrinsic.ID.s390_vfidb);
      Value /*P*/ M4Value = ConstantInt.get($this().getLLVMContext(), M4);
      Value /*P*/ M5Value = ConstantInt.get($this().getLLVMContext(), M5);
      return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {X, M4Value, M5Value}, true)/* }*/);
    }
   case SystemZ.BI__builtin_s390_vpkshs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vpkshs, E);
   case SystemZ.BI__builtin_s390_vpksfs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vpksfs, E);
   case SystemZ.BI__builtin_s390_vpksgs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vpksgs, E);
   case SystemZ.BI__builtin_s390_vpklshs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vpklshs, E);
   case SystemZ.BI__builtin_s390_vpklsfs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vpklsfs, E);
   case SystemZ.BI__builtin_s390_vpklsgs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vpklsgs, E);
   case SystemZ.BI__builtin_s390_vceqbs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vceqbs, E);
   case SystemZ.BI__builtin_s390_vceqhs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vceqhs, E);
   case SystemZ.BI__builtin_s390_vceqfs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vceqfs, E);
   case SystemZ.BI__builtin_s390_vceqgs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vceqgs, E);
   case SystemZ.BI__builtin_s390_vchbs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vchbs, E);
   case SystemZ.BI__builtin_s390_vchhs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vchhs, E);
   case SystemZ.BI__builtin_s390_vchfs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vchfs, E);
   case SystemZ.BI__builtin_s390_vchgs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vchgs, E);
   case SystemZ.BI__builtin_s390_vchlbs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vchlbs, E);
   case SystemZ.BI__builtin_s390_vchlhs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vchlhs, E);
   case SystemZ.BI__builtin_s390_vchlfs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vchlfs, E);
   case SystemZ.BI__builtin_s390_vchlgs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vchlgs, E);
   case SystemZ.BI__builtin_s390_vfaebs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfaebs, E);
   case SystemZ.BI__builtin_s390_vfaehs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfaehs, E);
   case SystemZ.BI__builtin_s390_vfaefs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfaefs, E);
   case SystemZ.BI__builtin_s390_vfaezbs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfaezbs, E);
   case SystemZ.BI__builtin_s390_vfaezhs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfaezhs, E);
   case SystemZ.BI__builtin_s390_vfaezfs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfaezfs, E);
   case SystemZ.BI__builtin_s390_vfeebs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfeebs, E);
   case SystemZ.BI__builtin_s390_vfeehs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfeehs, E);
   case SystemZ.BI__builtin_s390_vfeefs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfeefs, E);
   case SystemZ.BI__builtin_s390_vfeezbs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfeezbs, E);
   case SystemZ.BI__builtin_s390_vfeezhs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfeezhs, E);
   case SystemZ.BI__builtin_s390_vfeezfs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfeezfs, E);
   case SystemZ.BI__builtin_s390_vfenebs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfenebs, E);
   case SystemZ.BI__builtin_s390_vfenehs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfenehs, E);
   case SystemZ.BI__builtin_s390_vfenefs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfenefs, E);
   case SystemZ.BI__builtin_s390_vfenezbs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfenezbs, E);
   case SystemZ.BI__builtin_s390_vfenezhs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfenezhs, E);
   case SystemZ.BI__builtin_s390_vfenezfs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfenezfs, E);
   case SystemZ.BI__builtin_s390_vistrbs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vistrbs, E);
   case SystemZ.BI__builtin_s390_vistrhs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vistrhs, E);
   case SystemZ.BI__builtin_s390_vistrfs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vistrfs, E);
   case SystemZ.BI__builtin_s390_vstrcbs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vstrcbs, E);
   case SystemZ.BI__builtin_s390_vstrchs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vstrchs, E);
   case SystemZ.BI__builtin_s390_vstrcfs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vstrcfs, E);
   case SystemZ.BI__builtin_s390_vstrczbs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vstrczbs, E);
   case SystemZ.BI__builtin_s390_vstrczhs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vstrczhs, E);
   case SystemZ.BI__builtin_s390_vstrczfs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vstrczfs, E);
   case SystemZ.BI__builtin_s390_vfcedbs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfcedbs, E);
   case SystemZ.BI__builtin_s390_vfchdbs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfchdbs, E);
   case SystemZ.BI__builtin_s390_vfchedbs:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vfchedbs, E);
   case SystemZ.BI__builtin_s390_vftcidb:
    return CGBuiltinStatics.EmitSystemZIntrinsicWithCC(/*Deref*/$this(), ID.s390_vftcidb, E);
   default:
    return null;
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitNVPTXBuiltinExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 7942,
 FQN="clang::CodeGen::CodeGenFunction::EmitNVPTXBuiltinExpr", NM="_ZN5clang7CodeGen15CodeGenFunction20EmitNVPTXBuiltinExprEjPKNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20EmitNVPTXBuiltinExprEjPKNS_8CallExprE")
//</editor-fold>
public final Value /*P*/ EmitNVPTXBuiltinExpr(/*uint*/int BuiltinID, 
                    /*const*/ CallExpr /*P*/ E) {
  UInt2CallInst MakeLdg = /*[&, this, &E]*/ (/*uint*/int IntrinsicID) -> {
        Value /*P*/ Ptr = $this().EmitScalarExpr(E.getArg$Const(0));
        type$ptr<AlignmentSource> AlignSource = create_type$null$ptr();
        CharUnits Align = $this().getNaturalPointeeTypeAlignment(E.getArg$Const(0).getType(), /*AddrOf*/AlignSource);
        return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(IntrinsicID, /*{ */new ArrayRef<Type /*P*/ >(new Type /*P*/ /*const*/ [/*2*/] {
                      Ptr.getType().getPointerElementType(), 
                      Ptr.getType()}, true)/* }*/), 
            /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Ptr, ConstantInt.get($this().Builder.getInt32Ty(), Align.getQuantity())}, true)/* }*/);
      };
  switch (BuiltinID) {
   case NVPTX.BI__nvvm_atom_add_gen_i:
   case NVPTX.BI__nvvm_atom_add_gen_l:
   case NVPTX.BI__nvvm_atom_add_gen_ll:
    return CGBuiltinStatics.MakeBinaryAtomicValue(/*Deref*/$this(), AtomicRMWInst.BinOp.Add, E);
   case NVPTX.BI__nvvm_atom_sub_gen_i:
   case NVPTX.BI__nvvm_atom_sub_gen_l:
   case NVPTX.BI__nvvm_atom_sub_gen_ll:
    return CGBuiltinStatics.MakeBinaryAtomicValue(/*Deref*/$this(), AtomicRMWInst.BinOp.Sub, E);
   case NVPTX.BI__nvvm_atom_and_gen_i:
   case NVPTX.BI__nvvm_atom_and_gen_l:
   case NVPTX.BI__nvvm_atom_and_gen_ll:
    return CGBuiltinStatics.MakeBinaryAtomicValue(/*Deref*/$this(), AtomicRMWInst.BinOp.And, E);
   case NVPTX.BI__nvvm_atom_or_gen_i:
   case NVPTX.BI__nvvm_atom_or_gen_l:
   case NVPTX.BI__nvvm_atom_or_gen_ll:
    return CGBuiltinStatics.MakeBinaryAtomicValue(/*Deref*/$this(), AtomicRMWInst.BinOp.Or, E);
   case NVPTX.BI__nvvm_atom_xor_gen_i:
   case NVPTX.BI__nvvm_atom_xor_gen_l:
   case NVPTX.BI__nvvm_atom_xor_gen_ll:
    return CGBuiltinStatics.MakeBinaryAtomicValue(/*Deref*/$this(), AtomicRMWInst.BinOp.Xor, E);
   case NVPTX.BI__nvvm_atom_xchg_gen_i:
   case NVPTX.BI__nvvm_atom_xchg_gen_l:
   case NVPTX.BI__nvvm_atom_xchg_gen_ll:
    return CGBuiltinStatics.MakeBinaryAtomicValue(/*Deref*/$this(), AtomicRMWInst.BinOp.Xchg, E);
   case NVPTX.BI__nvvm_atom_max_gen_i:
   case NVPTX.BI__nvvm_atom_max_gen_l:
   case NVPTX.BI__nvvm_atom_max_gen_ll:
    return CGBuiltinStatics.MakeBinaryAtomicValue(/*Deref*/$this(), AtomicRMWInst.BinOp.Max, E);
   case NVPTX.BI__nvvm_atom_max_gen_ui:
   case NVPTX.BI__nvvm_atom_max_gen_ul:
   case NVPTX.BI__nvvm_atom_max_gen_ull:
    return CGBuiltinStatics.MakeBinaryAtomicValue(/*Deref*/$this(), AtomicRMWInst.BinOp.UMax, E);
   case NVPTX.BI__nvvm_atom_min_gen_i:
   case NVPTX.BI__nvvm_atom_min_gen_l:
   case NVPTX.BI__nvvm_atom_min_gen_ll:
    return CGBuiltinStatics.MakeBinaryAtomicValue(/*Deref*/$this(), AtomicRMWInst.BinOp.Min, E);
   case NVPTX.BI__nvvm_atom_min_gen_ui:
   case NVPTX.BI__nvvm_atom_min_gen_ul:
   case NVPTX.BI__nvvm_atom_min_gen_ull:
    return CGBuiltinStatics.MakeBinaryAtomicValue(/*Deref*/$this(), AtomicRMWInst.BinOp.UMin, E);
   case NVPTX.BI__nvvm_atom_cas_gen_i:
   case NVPTX.BI__nvvm_atom_cas_gen_l:
   case NVPTX.BI__nvvm_atom_cas_gen_ll:
    // __nvvm_atom_cas_gen_* should return the old value rather than the
    // success flag.
    return CGBuiltinStatics.MakeAtomicCmpXchgValue(/*Deref*/$this(), E, /*ReturnBool=*/ false);
   case NVPTX.BI__nvvm_atom_add_gen_f:
    {
      Value /*P*/ Ptr = $this().EmitScalarExpr(E.getArg$Const(0));
      Value /*P*/ Val = $this().EmitScalarExpr(E.getArg$Const(1));
      // atomicrmw only deals with integer arguments so we need to use
      // LLVM's nvvm_atomic_load_add_f32 intrinsic for that.
      Value /*P*/ FnALAF32 = $this().CGM.getIntrinsic(ID.nvvm_atomic_load_add_f32, new ArrayRef<Type /*P*/ >(Ptr.getType(), true));
      return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(FnALAF32, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Ptr, Val}, true)/* }*/);
    }
   case NVPTX.BI__nvvm_atom_inc_gen_ui:
    {
      Value /*P*/ Ptr = $this().EmitScalarExpr(E.getArg$Const(0));
      Value /*P*/ Val = $this().EmitScalarExpr(E.getArg$Const(1));
      Value /*P*/ FnALI32 = $this().CGM.getIntrinsic(ID.nvvm_atomic_load_inc_32, new ArrayRef<Type /*P*/ >(Ptr.getType(), true));
      return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(FnALI32, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Ptr, Val}, true)/* }*/);
    }
   case NVPTX.BI__nvvm_atom_dec_gen_ui:
    {
      Value /*P*/ Ptr = $this().EmitScalarExpr(E.getArg$Const(0));
      Value /*P*/ Val = $this().EmitScalarExpr(E.getArg$Const(1));
      Value /*P*/ FnALD32 = $this().CGM.getIntrinsic(ID.nvvm_atomic_load_dec_32, new ArrayRef<Type /*P*/ >(Ptr.getType(), true));
      return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(FnALD32, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Ptr, Val}, true)/* }*/);
    }
   case NVPTX.BI__nvvm_ldg_c:
   case NVPTX.BI__nvvm_ldg_c2:
   case NVPTX.BI__nvvm_ldg_c4:
   case NVPTX.BI__nvvm_ldg_s:
   case NVPTX.BI__nvvm_ldg_s2:
   case NVPTX.BI__nvvm_ldg_s4:
   case NVPTX.BI__nvvm_ldg_i:
   case NVPTX.BI__nvvm_ldg_i2:
   case NVPTX.BI__nvvm_ldg_i4:
   case NVPTX.BI__nvvm_ldg_l:
   case NVPTX.BI__nvvm_ldg_ll:
   case NVPTX.BI__nvvm_ldg_ll2:
   case NVPTX.BI__nvvm_ldg_uc:
   case NVPTX.BI__nvvm_ldg_uc2:
   case NVPTX.BI__nvvm_ldg_uc4:
   case NVPTX.BI__nvvm_ldg_us:
   case NVPTX.BI__nvvm_ldg_us2:
   case NVPTX.BI__nvvm_ldg_us4:
   case NVPTX.BI__nvvm_ldg_ui:
   case NVPTX.BI__nvvm_ldg_ui2:
   case NVPTX.BI__nvvm_ldg_ui4:
   case NVPTX.BI__nvvm_ldg_ul:
   case NVPTX.BI__nvvm_ldg_ull:
   case NVPTX.BI__nvvm_ldg_ull2:
    // PTX Interoperability section 2.2: "For a vector with an even number of
    // elements, its alignment is set to number of elements times the alignment
    // of its member: n*alignof(t)."
    return MakeLdg.$call(/*KEEP_ENUM*/ID.nvvm_ldg_global_i);
   case NVPTX.BI__nvvm_ldg_f:
   case NVPTX.BI__nvvm_ldg_f2:
   case NVPTX.BI__nvvm_ldg_f4:
   case NVPTX.BI__nvvm_ldg_d:
   case NVPTX.BI__nvvm_ldg_d2:
    return MakeLdg.$call(/*KEEP_ENUM*/ID.nvvm_ldg_global_f);
   default:
    return null;
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitWebAssemblyBuiltinExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 8078,
 FQN="clang::CodeGen::CodeGenFunction::EmitWebAssemblyBuiltinExpr", NM="_ZN5clang7CodeGen15CodeGenFunction26EmitWebAssemblyBuiltinExprEjPKNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26EmitWebAssemblyBuiltinExprEjPKNS_8CallExprE")
//</editor-fold>
public final Value /*P*/ EmitWebAssemblyBuiltinExpr(/*uint*/int BuiltinID, 
                          /*const*/ CallExpr /*P*/ E) {
  switch (BuiltinID) {
   case WebAssembly.BI__builtin_wasm_current_memory:
    {
      Type /*P*/ ResultType = $this().ConvertType(E.getType());
      Value /*P*/ Callee = $this().CGM.getIntrinsic(ID.wasm_current_memory, new ArrayRef<Type /*P*/ >(ResultType, true));
      return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(Callee);
    }
   case WebAssembly.BI__builtin_wasm_grow_memory:
    {
      Value /*P*/ X = $this().EmitScalarExpr(E.getArg$Const(0));
      Value /*P*/ Callee = $this().CGM.getIntrinsic(ID.wasm_grow_memory, new ArrayRef<Type /*P*/ >(X.getType(), true));
      return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(Callee, new ArrayRef<Value /*P*/ >(X, true));
    }
   default:
    return null;
  }
}


/// \brief Attempts to statically evaluate the object size of E. If that
/// fails, emits code to figure the size of E out for us. This is
/// pass_object_size aware.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::evaluateOrEmitBuiltinObjectSize">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 414,
 FQN="clang::CodeGen::CodeGenFunction::evaluateOrEmitBuiltinObjectSize", NM="_ZN5clang7CodeGen15CodeGenFunction31evaluateOrEmitBuiltinObjectSizeEPKNS_4ExprEjPN4llvm11IntegerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction31evaluateOrEmitBuiltinObjectSizeEPKNS_4ExprEjPN4llvm11IntegerTypeE")
//</editor-fold>
protected/*private*/ final Value /*P*/ evaluateOrEmitBuiltinObjectSize(/*const*/ Expr /*P*/ E, /*uint*/int Type, 
                               IntegerType /*P*/ ResType) {
  ulong$ref ObjectSize = create_ulong$ref(0);
  if (!E.tryEvaluateObjectSize(ObjectSize, $this().getContext(), Type)) {
    return $this().emitBuiltinObjectSize(E, Type, ResType);
  }
  return ConstantInt.get(ResType, ObjectSize.$deref(), /*isSigned=*/ true);
}


/// \brief Emits the size of E, as required by __builtin_object_size. This
/// function is aware of pass_object_size parameters, and will act accordingly
/// if E is a parameter with the pass_object_size attribute.

/// Returns a Value corresponding to the size of the given expression.
/// This Value may be either of the following:
///   - A llvm::Argument (if E is a param with the pass_object_size attribute on
///     it)
///   - A call to the @llvm.objectsize intrinsic
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::emitBuiltinObjectSize">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 428,
 FQN="clang::CodeGen::CodeGenFunction::emitBuiltinObjectSize", NM="_ZN5clang7CodeGen15CodeGenFunction21emitBuiltinObjectSizeEPKNS_4ExprEjPN4llvm11IntegerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21emitBuiltinObjectSizeEPKNS_4ExprEjPN4llvm11IntegerTypeE")
//</editor-fold>
protected/*private*/ final Value /*P*/ emitBuiltinObjectSize(/*const*/ Expr /*P*/ E, /*uint*/int Type, 
                     IntegerType /*P*/ ResType) {
  {
    // We need to reference an argument if the pointer is a parameter with the
    // pass_object_size attribute.
    /*const*/ DeclRefExpr /*P*/ D = AstExpressionsRTTI.dyn_cast_DeclRefExpr(E.IgnoreParenImpCasts$Const());
    if ((D != null)) {
      /*const*/ ParmVarDecl /*P*/ Param = AstDeclarationsRTTI.dyn_cast_ParmVarDecl(D.getDecl$Const());
      PassObjectSizeAttr /*P*/ PS = D.getDecl$Const().getAttr(PassObjectSizeAttr.class);
      if (Param != null && PS != null
         && CGBuiltinStatics.areBOSTypesCompatible(PS.getType(), Type)) {
        DenseMapIterator</*const*/ ParmVarDecl /*P*/ , /*const*/ ImplicitParamDecl /*P*/ > Iter = $this().SizeArguments.find(Param);
        assert (Iter.$noteq(/*NO_ITER_COPY*/$this().SizeArguments.end()));
        
        /*const*/ ImplicitParamDecl /*P*/ D$1 = Iter.$arrow().second;
        DenseMapIterator</*const*/ Decl /*P*/ , Address> DIter = $this().LocalDeclMap.find(D$1);
        assert (DIter.$noteq(/*NO_ITER_COPY*/$this().LocalDeclMap.end()));
        
        return $this().EmitLoadOfScalar(new Address(DIter.$arrow().second), /*volatile=*/ false, 
            $this().getContext().getSizeType().$QualType(), E.getLocStart());
      }
    }
  }
  
  // LLVM can't handle Type=3 appropriately, and __builtin_object_size shouldn't
  // evaluate E for side-effects. In either case, we shouldn't lower to
  // @llvm.objectsize.
  if (Type == 3 || E.HasSideEffects($this().getContext())) {
    return CGBuiltinStatics.getDefaultBuiltinObjectSizeResult(Type, ResType);
  }
  
  // LLVM only supports 0 and 2, make sure that we pass along that
  // as a boolean.
  ConstantInt /*P*/ CI = ConstantInt.get($this().Builder.getInt1Ty(), $uint2ulong((Type & 2) >>> 1));
  // FIXME: Get right address space.
  Type /*P*/ Tys[/*2*/] = new Type /*P*/  [/*2*/] {ResType, $this().Builder.getInt8PtrTy(0)};
  Value /*P*/ F = $this().CGM.getIntrinsic(ID.objectsize, new ArrayRef<Type /*P*/ >(Tys, true));
  return $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {$this().EmitScalarExpr(E), CI}, true)/* }*/);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GetValueForARMHint">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 3821,
 FQN="clang::CodeGen::CodeGenFunction::GetValueForARMHint", NM="_ZN5clang7CodeGen15CodeGenFunction18GetValueForARMHintEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18GetValueForARMHintEj")
//</editor-fold>
protected/*private*/ final Value /*P*/ GetValueForARMHint(/*uint*/int BuiltinID) {
  /*uint*/int Value;
  switch (BuiltinID) {
   default:
    return null;
   case ARM.BI__builtin_arm_nop:
    Value = 0;
    break;
   case ARM.BI__builtin_arm_yield:
   case ARM.BI__yield:
    Value = 1;
    break;
   case ARM.BI__builtin_arm_wfe:
   case ARM.BI__wfe:
    Value = 2;
    break;
   case ARM.BI__builtin_arm_wfi:
   case ARM.BI__wfi:
    Value = 3;
    break;
   case ARM.BI__builtin_arm_sev:
   case ARM.BI__sev:
    Value = 4;
    break;
   case ARM.BI__builtin_arm_sevl:
   case ARM.BI__sevl:
    Value = 5;
    break;
  }
  
  return $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.arm_hint), 
      new ArrayRef<Value /*P*/ >(ConstantInt.get(Int32Ty, $uint2ulong(Value)), true));
}

} // END OF class CodeGenFunction_CGBuiltin
