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
import org.llvm.profiledata.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.java.ClangCodeGenFunctionPointers.*;
import org.clang.codegen.java.ClangCodeGenDummies;
import org.clang.codegen.java.CodegenRTTI;
import org.llvm.ir.FunctionType;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;
import org.llvm.transforms.utils.TransformsLlvmGlobals;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGCall">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGCall",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGCXX ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11EmitCallArgERNS0_11CallArgListEPKNS_4ExprENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction12EmitCallArgsERNS0_11CallArgListEN4llvm8ArrayRefINS_8QualTypeEEENS4_14iterator_rangeINS_4Stmt17ConstExprIteratorEEEPKNS_12FunctionDeclEj;_ZN5clang7CodeGen15CodeGenFunction13getVarArgTypeEPKNS_4ExprE;_ZN5clang7CodeGen15CodeGenFunction15EmitRuntimeCallEPN4llvm5ValueENS2_8ArrayRefIS4_EERKNS2_5TwineE;_ZN5clang7CodeGen15CodeGenFunction15EmitRuntimeCallEPN4llvm5ValueERKNS2_5TwineE;_ZN5clang7CodeGen15CodeGenFunction16EmitCallOrInvokeEPN4llvm5ValueENS2_8ArrayRefIS4_EERKNS2_5TwineE;_ZN5clang7CodeGen15CodeGenFunction16ExpandTypeToArgsENS_8QualTypeENS0_6RValueEPN4llvm12FunctionTypeERNS4_15SmallVectorImplIPNS4_5ValueEEERj;_ZN5clang7CodeGen15CodeGenFunction18EmitFunctionEpilogERKNS0_14CGFunctionInfoEbNS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction18EmitFunctionPrologERKNS0_14CGFunctionInfoEPN4llvm8FunctionERKNS0_15FunctionArgListE;_ZN5clang7CodeGen15CodeGenFunction18ExpandTypeFromArgsENS_8QualTypeENS0_6LValueERPPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction19EmitDelegateCallArgERNS0_11CallArgListEPKNS_7VarDeclENS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction19EmitNonNullArgCheckENS0_6RValueENS_8QualTypeENS_14SourceLocationEPKNS_12FunctionDeclEj;_ZN5clang7CodeGen15CodeGenFunction23EmitNounwindRuntimeCallEPN4llvm5ValueENS2_8ArrayRefIS4_EERKNS2_5TwineE;_ZN5clang7CodeGen15CodeGenFunction23EmitNounwindRuntimeCallEPN4llvm5ValueERKNS2_5TwineE;_ZN5clang7CodeGen15CodeGenFunction23EmitRuntimeCallOrInvokeEPN4llvm5ValueENS2_8ArrayRefIS4_EERKNS2_5TwineE;_ZN5clang7CodeGen15CodeGenFunction23EmitRuntimeCallOrInvokeEPN4llvm5ValueERKNS2_5TwineE;_ZN5clang7CodeGen15CodeGenFunction27AddObjCARCExceptionMetadataEPN4llvm11InstructionE;_ZN5clang7CodeGen15CodeGenFunction27deferPlaceholderReplacementEPN4llvm11InstructionEPNS2_5ValueE;_ZN5clang7CodeGen15CodeGenFunction31EmitNoreturnRuntimeCallOrInvokeEPN4llvm5ValueENS2_8ArrayRefIS4_EE;_ZN5clang7CodeGen15CodeGenFunction8EmitCallERKNS0_14CGFunctionInfoEPN4llvm5ValueENS0_15ReturnValueSlotERKNS0_11CallArgListENS0_12CGCalleeInfoEPPNS5_11InstructionE;_ZN5clang7CodeGen15CodeGenFunction9EmitVAArgEPNS_9VAArgExprERNS0_7AddressE; -static-type=CodeGenFunction_CGCall -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGCall extends CodeGenFunction_CGCXX {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGCall(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}


/// EmitFunctionProlog - Emit the target specific LLVM code to load the
/// arguments for the given function. This is also responsible for naming the
/// LLVM function arguments.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitFunctionProlog">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 2072,
 FQN="clang::CodeGen::CodeGenFunction::EmitFunctionProlog", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitFunctionPrologERKNS0_14CGFunctionInfoEPN4llvm8FunctionERKNS0_15FunctionArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitFunctionPrologERKNS0_14CGFunctionInfoEPN4llvm8FunctionERKNS0_15FunctionArgListE")
//</editor-fold>
public final void EmitFunctionProlog(final /*const*/ CGFunctionInfo /*&*/ FI, 
                  Function /*P*/ Fn, 
                  final /*const*/ FunctionArgList /*&*/ Args) {
  ClangToLLVMArgMapping IRFunctionArgs = null;
  try {
    if (($this().CurCodeDecl != null) && $this().CurCodeDecl.hasAttr(NakedAttr.class)) {
      // Naked functions don't have prologues.
      return;
    }
    {
      
      // If this is an implicit-return-zero function, go ahead and
      // initialize the return value.  TODO: it might be nice to have
      // a more general mechanism for this that didn't require synthesized
      // return statements.
      /*const*/ FunctionDecl /*P*/ FD = AstDeclarationsRTTI.dyn_cast_or_null_FunctionDecl($this().CurCodeDecl);
      if ((FD != null)) {
        if (FD.hasImplicitReturnZero()) {
          QualType RetTy = FD.getReturnType().getUnqualifiedType();
          org.llvm.ir.Type /*P*/ LLVMTy = $this().CGM.getTypes().ConvertType(new QualType(RetTy));
          Constant /*P*/ Zero = Constant.getNullValue(LLVMTy);
          $this().Builder.CreateStore(Zero, new Address($this().ReturnValue));
        }
      }
    }
    
    // FIXME: We no longer need the types from FunctionArgList; lift up and
    // simplify.
    IRFunctionArgs/*J*/= new ClangToLLVMArgMapping($this().CGM.getContext(), FI);
    // Flattened function arguments.
    SmallVector<Value /*P*/ > FnArgs/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
    FnArgs.reserve(IRFunctionArgs.totalIRArgs());
    for (final Argument /*&*/ Arg : Fn.args()) {
      FnArgs.push_back($AddrOf(Arg));
    }
    assert (FnArgs.size() == IRFunctionArgs.totalIRArgs());
    
    // If we're using inalloca, all the memory arguments are GEPs off of the last
    // parameter, which is a pointer to the complete memory area.
    Address ArgStruct = Address.invalid();
    /*const*/ StructLayout /*P*/ ArgStructLayout = null;
    if (IRFunctionArgs.hasInallocaArg()) {
      ArgStructLayout = $this().CGM.getDataLayout().getStructLayout(FI.getArgStruct());
      ArgStruct.$assignMove(new Address(FnArgs.$at(IRFunctionArgs.getInallocaArgNo()), 
              FI.getArgStructAlignment()));
      assert (ArgStruct.getType() == FI.getArgStruct().getPointerTo());
    }
    
    // Name the struct return parameter.
    if (IRFunctionArgs.hasSRetArg()) {
      Argument /*P*/ AI = IrRTTI.cast_Argument(FnArgs.$at(IRFunctionArgs.getSRetArgNo()));
      AI.setName(new Twine(/*KEEP_STR*/"agg.result"));
      AI.addAttr(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind($this().getLLVMContext(), AI.getArgNo() + 1, 
              new ArrayRef<Attribute.AttrKind>(Attribute.AttrKind.NoAlias)));
    }
    
    // Track if we received the parameter as a pointer (indirect, byval, or
    // inalloca).  If already have a pointer, EmitParmDecl doesn't need to copy it
    // into a local alloca for us.
    SmallVector<ParamValue> ArgVals/*J*/= new SmallVector<ParamValue>(16, new ParamValue());
    ArgVals.reserve(Args.size());
    
    // Create a pointer value for every parameter declaration.  This usually
    // entails copying one or more LLVM IR arguments into an alloca.  Don't push
    // any cleanups or do anything that might unwind.  We do that separately, so
    // we can push the cleanups in the correct order for the ABI.
    assert (FI.arg_size() == Args.size()) : "Mismatch between function signature & arguments.";
    /*uint*/int ArgNo = 0;
    type$ptr</*const*/ CGFunctionInfoArgInfo /*P*/ > info_it = $tryClone(FI.arg_begin$Const());
    for (type$ptr</*const*/ VarDecl /*P*/ /*const*/ /*P*/> i = $tryClone(Args.begin$Const()), /*P*/ e = $tryClone(Args.end$Const());
         $noteq_ptr(i, e); i.$preInc() , info_it.$preInc() , ++ArgNo) {
      /*const*/ VarDecl /*P*/ Arg = i.$star();
      QualType Ty = info_it./*->*/$star().type.$QualType();
      final /*const*/ ABIArgInfo /*&*/ ArgI = info_it./*->*/$star().info;
      
      boolean isPromoted = AstDeclarationsRTTI.isa_ParmVarDecl(Arg) && AstDeclarationsRTTI.cast_ParmVarDecl(Arg).isKNRPromoted();
      
      //std.tie(FirstIRArg, NumIRArgs).$assign(tmp);
      pairUIntUInt tmp = IRFunctionArgs.getIRArgs(ArgNo);
      /*uint*/int FirstIRArg = tmp.first;
      /*uint*/int NumIRArgs = tmp.second;
      switch (ArgI.getKind()) {
       case InAlloca:
        {
          assert (NumIRArgs == 0);
          /*uint*/int FieldIndex = ArgI.getInAllocaFieldIndex();
          CharUnits FieldOffset = CharUnits.fromQuantity(ArgStructLayout.getElementOffset(FieldIndex));
          Address V = $this().Builder.CreateStructGEP(new Address(ArgStruct), FieldIndex, new CharUnits(FieldOffset), 
              new Twine(Arg.getName()));
          ArgVals.push_back(ParamValue.forIndirect(new Address(V)));
          break;
        }
       case Indirect:
        {
          assert (NumIRArgs == 1);
          Address ParamAddr = new Address(FnArgs.$at(FirstIRArg), ArgI.getIndirectAlign());
          if (!CodeGenFunction.hasScalarEvaluationKind(new QualType(Ty))) {
            // Aggregates and complex variables are accessed by reference.  All we
            // need to do is realign the value, if requested.
            Address V = new Address(ParamAddr);
            if (ArgI.getIndirectRealign()) {
              Address AlignedTemp = $this().CreateMemTemp(new QualType(Ty), new Twine(/*KEEP_STR*/"coerce"));
              
              // Copy from the incoming argument pointer to the temporary with the
              // appropriate alignment.
              //
              // FIXME: We should have a common utility for generating an aggregate
              // copy.
              CharUnits Size = $this().getContext().getTypeSizeInChars(/*NO_COPY*/Ty);
              ConstantInt /*P*/ SizeVal = ConstantInt.get(Unnamed_field8.IntPtrTy, Size.getQuantity());
              Address Dst = $this().Builder.CreateBitCast(new Address(AlignedTemp), Unnamed_field9.Int8PtrTy);
              Address Src = $this().Builder.CreateBitCast(new Address(ParamAddr), Unnamed_field9.Int8PtrTy);
              $this().Builder.CreateMemCpy(new Address(Dst), new Address(Src), SizeVal, false);
              V.$assign(AlignedTemp);
            }
            ArgVals.push_back(ParamValue.forIndirect(new Address(V)));
          } else {
            // Load scalar value from indirect argument.
            Value /*P*/ V = $this().EmitLoadOfScalar(new Address(ParamAddr), false, new QualType(Ty), Arg.getLocStart());
            if (isPromoted) {
              V = CGCallStatics.emitArgumentDemotion(/*Deref*/$this(), Arg, V);
            }
            ArgVals.push_back(ParamValue.forDirect(V));
          }
          break;
        }
       case Extend:
       case Direct:
        {
          
          // If we have the trivial case, handle it with no muss and fuss.
          if (!IrRTTI.isa_StructType(ArgI.getCoerceToType())
             && ArgI.getCoerceToType() == $this().ConvertType(new QualType(Ty))
             && ArgI.getDirectOffset() == 0) {
            assert (NumIRArgs == 1);
            Value /*P*/ V = FnArgs.$at(FirstIRArg);
            Argument /*P*/ AI = IrRTTI.cast_Argument(V);
            {
              
              /*const*/ ParmVarDecl /*P*/ PVD = AstDeclarationsRTTI.dyn_cast_ParmVarDecl(Arg);
              if ((PVD != null)) {
                if ((CGCallStatics.getNonNullAttr($this().CurCodeDecl, PVD, PVD.getType(), 
                    PVD.getFunctionScopeIndex()) != null)) {
                  AI.addAttr(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind($this().getLLVMContext(), 
                          AI.getArgNo() + 1, 
                          new ArrayRef<Attribute.AttrKind>(Attribute.AttrKind.NonNull)));
                }
                
                QualType OTy = PVD.getOriginalType();
                {
                  /*const*/ ConstantArrayType /*P*/ ArrTy = $this().getContext().getAsConstantArrayType(new QualType(OTy));
                  if ((ArrTy != null)) {
                    // A C99 array parameter declaration with the static keyword also
                    // indicates dereferenceability, and if the size is constant we can
                    // use the dereferenceable attribute (which requires the size in
                    // bytes).
                    if (ArrTy.getSizeModifier() == org.clang.ast.ArrayType.ArraySizeModifier.Static) {
                      QualType ETy = ArrTy.getElementType();
                      long/*uint64_t*/ ArrSize = ArrTy.getSize().getZExtValue();
                      if (!ETy.$arrow().isIncompleteType() && ETy.$arrow().isConstantSizeType()
                         && (ArrSize != 0)) {
                        AttrBuilder Attrs = null;
                        try {
                          Attrs/*J*/= new AttrBuilder();
                          Attrs.addDereferenceableAttr($this().getContext().getTypeSizeInChars(/*NO_COPY*/ETy).getQuantity() * ArrSize);
                          AI.addAttr(AttributeSet.get($this().getLLVMContext(), 
                                  AI.getArgNo() + 1, Attrs));
                        } finally {
                          if (Attrs != null) { Attrs.$destroy(); }
                        }
                      } else if ($this().getContext().getTargetAddressSpace(new QualType(ETy)) == 0) {
                        AI.addAttr(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind($this().getLLVMContext(), 
                                AI.getArgNo() + 1, 
                                new ArrayRef<Attribute.AttrKind>(Attribute.AttrKind.NonNull)));
                      }
                    }
                  } else {
                    /*const*/ VariableArrayType /*P*/ ArrTy$1 = $this().getContext().getAsVariableArrayType(new QualType(OTy));
                    if ((ArrTy$1 != null)) {
                      // For C99 VLAs with the static keyword, we don't know the size so
                      // we can't use the dereferenceable attribute, but in addrspace(0)
                      // we know that it must be nonnull.
                      if (ArrTy$1.getSizeModifier() == VariableArrayType.ArraySizeModifier.Static
                         && !($this().getContext().getTargetAddressSpace(ArrTy$1.getElementType()) != 0)) {
                        AI.addAttr(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind($this().getLLVMContext(), 
                                AI.getArgNo() + 1, 
                                new ArrayRef<Attribute.AttrKind>(Attribute.AttrKind.NonNull)));
                      }
                    }
                  }
                }
                
                /*const*/ AlignValueAttr /*P*/ AVAttr = PVD.getAttr(AlignValueAttr.class);
                if (!(AVAttr != null)) {
                  {
                    /*const*/ TypedefType /*P*/ TOTy = AstTypesRTTI.dyn_cast_TypedefType(OTy);
                    if ((TOTy != null)) {
                      AVAttr = TOTy.getDecl().getAttr(AlignValueAttr.class);
                    }
                  }
                }
                if ((AVAttr != null)) {
                  AttrBuilder Attrs = null;
                  try {
                    Value /*P*/ AlignmentValue = $this().EmitScalarExpr(AVAttr.getAlignment());
                    ConstantInt /*P*/ AlignmentCI = IrRTTI.cast_ConstantInt(AlignmentValue);
                    /*uint*/int Alignment = std.min_uint((/*uint*/int)$ulong2uint(AlignmentCI.getZExtValue()), 
                        +Value.MaximumAlignment);
                    
                    Attrs/*J*/= new AttrBuilder();
                    Attrs.addAlignmentAttr(Alignment);
                    AI.addAttr(AttributeSet.get($this().getLLVMContext(), 
                            AI.getArgNo() + 1, Attrs));
                  } finally {
                    if (Attrs != null) { Attrs.$destroy(); }
                  }
                }
              }
            }
            if (Arg.getType().isRestrictQualified()) {
              AI.addAttr(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind($this().getLLVMContext(), 
                      AI.getArgNo() + 1, 
                      new ArrayRef<Attribute.AttrKind>(Attribute.AttrKind.NoAlias)));
            }
            
            // LLVM expects swifterror parameters to be used in very restricted
            // ways.  Copy the value into a less-restricted temporary.
            if (FI.getExtParameterInfo(ArgNo).getABI()
               == ParameterABI.SwiftErrorResult) {
              QualType pointeeTy = Ty.$arrow().getPointeeType();
              assert (pointeeTy.$arrow().isPointerType());
              Address temp = $this().CreateMemTemp(new QualType(pointeeTy), /*J:ToBase*/super.getPointerAlign(), new Twine(/*KEEP_STR*/"swifterror.temp"));
              Address arg = new Address(V, $this().getContext().getTypeAlignInChars(new QualType(pointeeTy)));
              Value /*P*/ incomingErrorValue = $this().Builder.CreateLoad(new Address(arg));
              $this().Builder.CreateStore(incomingErrorValue, new Address(temp));
              V = temp.getPointer();
              
              // Push a cleanup to copy the value back at the end of the function.
              // The convention does not guarantee that the value will be written
              // back if the function exits with an unwind exception.
              $this().EHStack.<CopyBackSwiftError>pushCleanup$T(CleanupKind.NormalCleanup, () -> new CopyBackSwiftError(new Address(temp), new Address(arg)));
            }
            
            // Ensure the argument is the correct type.
            if (V.getType() != ArgI.getCoerceToType()) {
              V = $this().Builder.CreateBitCast(V, ArgI.getCoerceToType());
            }
            if (isPromoted) {
              V = CGCallStatics.emitArgumentDemotion(/*Deref*/$this(), Arg, V);
            }
            {
              
              /*const*/ CXXMethodDecl /*P*/ MD = AstDeclarationsRTTI.dyn_cast_or_null_CXXMethodDecl($this().CurCodeDecl);
              if ((MD != null)) {
                if (MD.isVirtual() && Arg == $this().CXXABIThisDecl) {
                  V = $this().CGM.getCXXABI().
                      adjustThisParameterInVirtualFunctionPrologue(/*Deref*/$this(), new GlobalDecl($this().CurGD), V);
                }
              }
            }
            
            // Because of merging of function types from multiple decls it is
            // possible for the type of an argument to not match the corresponding
            // type in the function type. Since we are codegening the callee
            // in here, add a cast to the argument type.
            org.llvm.ir.Type /*P*/ LTy = $this().ConvertType(Arg.getType());
            if (V.getType() != LTy) {
              V = $this().Builder.CreateBitCast(V, LTy);
            }
            
            ArgVals.push_back(ParamValue.forDirect(V));
            break;
          }
          
          Address Alloca = $this().CreateMemTemp(new QualType(Ty), $this().getContext().getDeclAlign(Arg), 
              new Twine(Arg.getName()));
          
          // Pointer to store into.
          Address Ptr = CGCallStatics.emitAddressAtOffset(/*Deref*/$this(), new Address(Alloca), ArgI);
          
          // Fast-isel and the optimizer generally like scalar values better than
          // FCAs, so we flatten them if this is safe to do for this argument.
          StructType /*P*/ STy = IrRTTI.dyn_cast_StructType(ArgI.getCoerceToType());
          if (ArgI.isDirect() && ArgI.getCanBeFlattened() && (STy != null)
             && $greater_uint(STy.getNumElements(), 1)) {
            /*const*/ StructLayout /*P*/ SrcLayout = $this().CGM.getDataLayout().getStructLayout(STy);
            long/*uint64_t*/ SrcSize = $this().CGM.getDataLayout().getTypeAllocSize(STy);
            org.llvm.ir.Type /*P*/ DstTy = Ptr.getElementType();
            long/*uint64_t*/ DstSize = $this().CGM.getDataLayout().getTypeAllocSize(DstTy);
            
            Address AddrToStoreInto = Address.invalid();
            if ($lesseq_ulong(SrcSize, DstSize)) {
              AddrToStoreInto.$assignMove(
                  $this().Builder.CreateBitCast(new Address(Ptr), org.llvm.ir.PointerType.getUnqual(STy))
              );
            } else {
              AddrToStoreInto.$assignMove(
                  $this().CreateTempAlloca(STy, Alloca.getAlignment(), new Twine(/*KEEP_STR*/"coerce"))
              );
            }
            assert (STy.getNumElements() == NumIRArgs);
            for (/*uint*/int i$1 = 0, e$1 = STy.getNumElements(); i$1 != e$1; ++i$1) {
              Value /*P*/ AI = FnArgs.$at(FirstIRArg + i$1);
              AI.setName($add_Twine$C($add_StringRef$C_char$ptr$C(Arg.getName(), /*KEEP_STR*/".coerce"), new Twine(JD$UInt.INSTANCE, i$1)));
              CharUnits Offset = CharUnits.fromQuantity(SrcLayout.getElementOffset(i$1));
              Address EltPtr = $this().Builder.CreateStructGEP(new Address(AddrToStoreInto), i$1, new CharUnits(Offset));
              $this().Builder.CreateStore(AI, new Address(EltPtr));
            }
            if ($greater_ulong(SrcSize, DstSize)) {
              $this().Builder.CreateMemCpy(new Address(Ptr), new Address(AddrToStoreInto), DstSize);
            }
          } else {
            // Simple case, just do a coerced store of the argument into the alloca.
            assert (NumIRArgs == 1);
            Value /*P*/ AI = FnArgs.$at(FirstIRArg);
            AI.setName($add_StringRef$C_char$ptr$C(Arg.getName(), /*KEEP_STR*/".coerce"));
            CGCallStatics.CreateCoercedStore(AI, new Address(Ptr), /*DestIsVolatile=*/ false, /*Deref*/$this());
          }
          
          // Match to what EmitParmDecl is expecting for this type.
          if (CodeGenFunction.hasScalarEvaluationKind(new QualType(Ty))) {
            Value /*P*/ V = $this().EmitLoadOfScalar(new Address(Alloca), false, new QualType(Ty), Arg.getLocStart());
            if (isPromoted) {
              V = CGCallStatics.emitArgumentDemotion(/*Deref*/$this(), Arg, V);
            }
            ArgVals.push_back(ParamValue.forDirect(V));
          } else {
            ArgVals.push_back(ParamValue.forIndirect(new Address(Alloca)));
          }
          break;
        }
       case CoerceAndExpand:
        {
          // Reconstruct into a temporary.
          Address alloca = $this().CreateMemTemp(new QualType(Ty), $this().getContext().getDeclAlign(Arg));
          ArgVals.push_back(ParamValue.forIndirect(new Address(alloca)));
          
          StructType /*P*/ coercionType = ArgI.getCoerceAndExpandType();
          alloca.$assignMove($this().Builder.CreateElementBitCast(new Address(alloca), coercionType));
          /*const*/ StructLayout /*P*/ layout = $this().CGM.getDataLayout().getStructLayout(coercionType);
          
          /*uint*/int argIndex = FirstIRArg;
          for (/*uint*/int i$1 = 0, e$1 = coercionType.getNumElements(); i$1 != e$1; ++i$1) {
            org.llvm.ir.Type /*P*/ eltType = coercionType.getElementType(i$1);
            if (ABIArgInfo.isPaddingForCoerceAndExpand(eltType)) {
              continue;
            }
            
            Address eltAddr = $this().Builder.CreateStructGEP(new Address(alloca), i$1, layout);
            Value /*P*/ elt = FnArgs.$at(argIndex++);
            $this().Builder.CreateStore(elt, new Address(eltAddr));
          }
          assert (argIndex == FirstIRArg + NumIRArgs);
          break;
        }
       case Expand:
        {
          // If this structure was expanded into multiple arguments then
          // we need to create a temporary and reconstruct it from the
          // arguments.
          Address Alloca = $this().CreateMemTemp(new QualType(Ty), $this().getContext().getDeclAlign(Arg));
          LValue LV = $this().MakeAddrLValue(new Address(Alloca), new QualType(Ty));
          ArgVals.push_back(ParamValue.forIndirect(new Address(Alloca)));
          
          type$ptr<Value /*P*/ /*P*/> FnArgIter = $tryClone(FnArgs.begin().$add(FirstIRArg));
          $this().ExpandTypeFromArgs(new QualType(Ty), new LValue(LV), FnArgIter);
          assert ($eq_ptr(FnArgIter, FnArgs.begin().$add(FirstIRArg).$add(NumIRArgs)));
          for (/*uint*/int i$1 = 0, e$1 = NumIRArgs; i$1 != e$1; ++i$1) {
            Value /*P*/ AI = FnArgs.$at(FirstIRArg + i$1);
            AI.setName($add_Twine$C($add_StringRef$C_char$ptr$C(Arg.getName(), /*KEEP_STR*/$DOT), new Twine(JD$UInt.INSTANCE, i$1)));
          }
          break;
        }
       case Ignore:
        assert (NumIRArgs == 0);
        // Initialize the local variable appropriately.
        if (!CodeGenFunction.hasScalarEvaluationKind(new QualType(Ty))) {
          ArgVals.push_back(ParamValue.forIndirect($this().CreateMemTemp(new QualType(Ty))));
        } else {
          Value /*P*/ U = UndefValue.get($this().ConvertType(Arg.getType()));
          ArgVals.push_back(ParamValue.forDirect(U));
        }
        break;
      }
    }
    if ($this().getTarget().getCXXABI().areArgsDestroyedLeftToRightInCallee()) {
      for (int I = Args.size() - 1; I >= 0; --I)  {
        $this().EmitParmDecl($Deref(Args.$at$Const(I)), new ParamValue(ArgVals.$at(I)), I + 1);
      }
    } else {
      for (/*uint*/int I = 0, E = Args.size(); I != E; ++I)  {
        $this().EmitParmDecl($Deref(Args.$at$Const(I)), new ParamValue(ArgVals.$at(I)), I + 1);
      }
    }
  } finally {
    if (IRFunctionArgs != null) { IRFunctionArgs.$destroy(); }
  }
}


/// EmitFunctionEpilog - Emit the target specific LLVM code to return the
/// given temporary.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitFunctionEpilog">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 2664,
 FQN="clang::CodeGen::CodeGenFunction::EmitFunctionEpilog", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitFunctionEpilogERKNS0_14CGFunctionInfoEbNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitFunctionEpilogERKNS0_14CGFunctionInfoEbNS_14SourceLocationE")
//</editor-fold>
public final void EmitFunctionEpilog(final /*const*/ CGFunctionInfo /*&*/ FI, 
                  boolean EmitRetDbgLoc, 
                  SourceLocation EndLoc) {
  DebugLoc RetDbgLoc = null;
  try {
    if (($this().CurCodeDecl != null) && $this().CurCodeDecl.hasAttr(NakedAttr.class)) {
      // Naked functions don't have epilogues.
      $this().Builder.CreateUnreachable();
      return;
    }
    
    // Functions with no result always return void.
    if (!$this().ReturnValue.isValid()) {
      $this().Builder.CreateRetVoid();
      return;
    }
    
    RetDbgLoc/*J*/= new DebugLoc();
    Value /*P*/ RV = null;
    QualType RetTy = FI.getReturnType().$QualType();
    final /*const*/ ABIArgInfo /*&*/ RetAI = FI.getReturnInfo$Const();
    switch (RetAI.getKind()) {
     case InAlloca:
      // Aggregrates get evaluated directly into the destination.  Sometimes we
      // need to return the sret value in a register, though.
      assert (CodeGenFunction.hasAggregateEvaluationKind(new QualType(RetTy)));
      if (RetAI.getInAllocaSRet()) {
        ilist_iterator<Argument> EI = $this().CurFn.arg_end();
        EI.$preDec();
        Value /*P*/ ArgStruct = $AddrOf(EI.$star());
        Value /*P*/ SRet = $this().Builder.CreateStructGEP((org.llvm.ir.Type /*P*/ )null, ArgStruct, RetAI.getInAllocaFieldIndex());
        RV = $this().Builder.CreateAlignedLoad(SRet, /*J:ToBase*/super.getPointerAlign(), $("sret"));
      }
      break;
     case Indirect:
      {
        ilist_iterator<Argument> AI = $this().CurFn.arg_begin();
        if (RetAI.isSRetAfterThis()) {
          AI.$preInc();
        }
        switch (CodeGenFunction.getEvaluationKind(new QualType(RetTy))) {
         case TEK_Complex:
          {
            std.pair<Value /*P*/ , Value /*P*/ > RT = $this().EmitLoadOfComplex($this().MakeAddrLValue(new Address($this().ReturnValue), new QualType(RetTy)), new SourceLocation(EndLoc));
            $this().EmitStoreOfComplex(new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(RT), $this().MakeNaturalAlignAddrLValue($AddrOf(AI.$star()), new QualType(RetTy)), 
                /*isInit*/ true);
            break;
          }
         case TEK_Aggregate:
          // Do nothing; aggregrates get evaluated directly into the destination.
          break;
         case TEK_Scalar:
          $this().EmitStoreOfScalar($this().Builder.CreateLoad(new Address($this().ReturnValue)), 
              $this().MakeNaturalAlignAddrLValue($AddrOf(AI.$star()), new QualType(RetTy)), 
              /*isInit*/ true);
          break;
        }
        break;
      }
     case Extend:
     case Direct:
      if (RetAI.getCoerceToType() == $this().ConvertType(new QualType(RetTy))
         && RetAI.getDirectOffset() == 0) {
        {
          // The internal return value temp always will have pointer-to-return-type
          // type, just do a load.
          
          // If there is a dominating store to ReturnValue, we can elide
          // the load, zap the store, and usually zap the alloca.
          StoreInst /*P*/ SI = CGCallStatics.findDominatingStoreToReturnValue(/*Deref*/$this());
          if ((SI != null)) {
            // Reuse the debug location from the store unless there is
            // cleanup code to be emitted between the store and return
            // instruction.
            if (EmitRetDbgLoc && !$this().AutoreleaseResult) {
              RetDbgLoc.$assign(SI.getDebugLoc());
            }
            // Get the stored value and nuke the now-dead store.
            RV = SI.getValueOperand();
            SI.eraseFromParent();
            
            // If that was the only use of the return value, nuke it as well now.
            Value /*P*/ returnValueInst = $this().ReturnValue.getPointer();
            if (returnValueInst.use_empty()) {
              {
                AllocaInst /*P*/ alloca = IrRTTI.dyn_cast_AllocaInst(returnValueInst);
                if ((alloca != null)) {
                  alloca.eraseFromParent();
                  $this().ReturnValue.$assignMove(Address.invalid());
                }
              }
            }
            // Otherwise, we have to do a simple load.
          } else {
            RV = $this().Builder.CreateLoad(new Address($this().ReturnValue));
          }
        }
      } else {
        // If the value is offset in memory, apply the offset now.
        Address V = CGCallStatics.emitAddressAtOffset(/*Deref*/$this(), new Address($this().ReturnValue), RetAI);
        
        RV = CGCallStatics.CreateCoercedLoad(new Address(V), RetAI.getCoerceToType(), /*Deref*/$this());
      }
      
      // In ARC, end functions that return a retainable type with a call
      // to objc_autoreleaseReturnValue.
      if ($this().AutoreleaseResult) {
//#ifndef NDEBUG
       if (!NativeTrace.NDEBUG()) { 
        // Type::isObjCRetainabletype has to be called on a QualType that hasn't
        // been stripped of the typedefs, so we cannot use RetTy here. Get the
        // original return type of FunctionDecl, CurCodeDecl, and BlockDecl from
        // CurCodeDecl or BlockInfo.
        QualType RT/*J*/= new QualType();
        {
          
          /*const*/ FunctionDecl /*P*/ FD = AstDeclarationsRTTI.dyn_cast_FunctionDecl($this().CurCodeDecl);
          if ((FD != null)) {
            RT.$assignMove(FD.getReturnType());
          } else {
            /*const*/ ObjCMethodDecl /*P*/ MD = AstDeclarationsRTTI.dyn_cast_ObjCMethodDecl($this().CurCodeDecl);
            if ((MD != null)) {
              RT.$assignMove(MD.getReturnType());
            } else if (AstDeclarationsRTTI.isa_BlockDecl($this().CurCodeDecl)) {
              RT.$assignMove($this().BlockInfo.BlockExpression.getFunctionType().getReturnType());
            } else {
              throw new llvm_unreachable("Unexpected function/method type");
            }
          }
        }
        assert ($this().getLangOpts().ObjCAutoRefCount && !FI.isReturnsRetained() && RT.$arrow().isObjCRetainableType());
       } 
//#endif        
        RV = CGCallStatics.emitAutoreleaseOfResult(/*Deref*/$this(), RV);
      }
      
      break;
     case Ignore:
      break;
     case CoerceAndExpand:
      {
        StructType /*P*/ coercionType = RetAI.getCoerceAndExpandType();
        /*const*/ StructLayout /*P*/ layout = $this().CGM.getDataLayout().getStructLayout(coercionType);
        
        // Load all of the coerced elements out into results.
        SmallVector<Value /*P*/ > results/*J*/= new SmallVector<Value /*P*/ >(4, (Value /*P*/ )null);
        Address addr = $this().Builder.CreateElementBitCast(new Address($this().ReturnValue), coercionType);
        for (/*uint*/int i = 0, e = coercionType.getNumElements(); i != e; ++i) {
          org.llvm.ir.Type /*P*/ coercedEltType = coercionType.getElementType(i);
          if (ABIArgInfo.isPaddingForCoerceAndExpand(coercedEltType)) {
            continue;
          }
          
          Address eltAddr = $this().Builder.CreateStructGEP(new Address(addr), i, layout);
          LoadInst /*P*/ elt = $this().Builder.CreateLoad(new Address(eltAddr));
          results.push_back(elt);
        }
        
        // If we have one result, it's the single direct result type.
        if (results.size() == 1) {
          RV = results.$at(0);
          // Otherwise, we need to make a first-class aggregate.
        } else {
          // Construct a return type that lacks padding elements.
          org.llvm.ir.Type /*P*/ returnType = RetAI.getUnpaddedCoerceAndExpandType();
          
          RV = UndefValue.get(returnType);
          for (/*uint*/int i = 0, e = results.size(); i != e; ++i) {
            RV = $this().Builder.CreateInsertValue(RV, results.$at(i), new ArrayRefUInt(i));
          }
        }
        break;
      }
     case Expand:
      throw new llvm_unreachable("Invalid ABI kind for return argument");
    }
    
    Instruction /*P*/ Ret;
    if ((RV != null)) {
      if (($this().CurCodeDecl != null) && $this().SanOpts.has(SanitizerKind.ReturnsNonnullAttribute)) {
        {
          ReturnsNonNullAttr /*P*/ RetNNAttr = $this().CurCodeDecl.getAttr(ReturnsNonNullAttr.class);
          if ((RetNNAttr != null)) {
            SanitizerScope SanScope = null;
            try {
              SanScope/*J*/= new SanitizerScope($this());
              Value /*P*/ Cond = $this().Builder.CreateICmpNE(RV, Constant.getNullValue(RV.getType()));
              Constant /*P*/ StaticData[/*2*/] = new Constant /*P*/  [/*2*/] {
                $this().EmitCheckSourceLocation(new SourceLocation(EndLoc)), 
                $this().EmitCheckSourceLocation(RetNNAttr.getLocation())
              };
              $this().EmitCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(std.make_pair_Ptr_ulong(Cond, SanitizerKind.ReturnsNonnullAttribute), false), 
                  new StringRef(/*KEEP_STR*/"nonnull_return"), new ArrayRef<Constant /*P*/ >(StaticData, true), new ArrayRef<Value /*P*/ >(None, true));
            } finally {
              if (SanScope != null) { SanScope.$destroy(); }
            }
          }
        }
      }
      Ret = $this().Builder.CreateRet(RV);
    } else {
      Ret = $this().Builder.CreateRetVoid();
    }
    if (RetDbgLoc.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Ret.setDebugLoc($c$.track(new DebugLoc(JD$Move.INSTANCE, std.move(RetDbgLoc)))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
  } finally {
    if (RetDbgLoc != null) { RetDbgLoc.$destroy(); }
  }
}


/// Generate code to get an argument from the passed in pointer
/// and update it accordingly.
/// \param VE The \c VAArgExpr for which to generate code.
/// \param VAListAddr Receives a reference to the \c va_list as emitted by
/// either \c EmitVAListRef or \c EmitMSVAListRef.
/// \returns A pointer to the argument.
// FIXME: We should be able to get rid of this method and use the va_arg
// instruction in LLVM instead once it works well enough.

/* VarArg handling */
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitVAArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 4133,
 FQN="clang::CodeGen::CodeGenFunction::EmitVAArg", NM="_ZN5clang7CodeGen15CodeGenFunction9EmitVAArgEPNS_9VAArgExprERNS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction9EmitVAArgEPNS_9VAArgExprERNS0_7AddressE")
//</editor-fold>
public final Address EmitVAArg(VAArgExpr /*P*/ VE, final Address /*&*/ VAListAddr) {
  VAListAddr.$assignMove(VE.isMicrosoftABI() ? $this().EmitMSVAListRef(VE.getSubExpr()) : $this().EmitVAListRef(VE.getSubExpr()));
  QualType Ty = VE.getType();
  if (VE.isMicrosoftABI()) {
    return $this().CGM.getTypes().getABIInfo().EmitMSVAArg(/*Deref*/$this(), new Address(VAListAddr), new QualType(Ty));
  }
  return $this().CGM.getTypes().getABIInfo().EmitVAArg(/*Deref*/$this(), new Address(VAListAddr), new QualType(Ty));
}


//===--------------------------------------------------------------------===//
//                         Scalar Expression Emission
//===--------------------------------------------------------------------===//

/// EmitCall - Generate a call of the given function, expecting the given
/// result type, and using the given argument list which specifies both the
/// LLVM arguments and the types they were derived from.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCall">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3507,
 FQN="clang::CodeGen::CodeGenFunction::EmitCall", NM="_ZN5clang7CodeGen15CodeGenFunction8EmitCallERKNS0_14CGFunctionInfoEPN4llvm5ValueENS0_15ReturnValueSlotERKNS0_11CallArgListENS0_12CGCalleeInfoEPPNS5_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction8EmitCallERKNS0_14CGFunctionInfoEPN4llvm5ValueENS0_15ReturnValueSlotERKNS0_11CallArgListENS0_12CGCalleeInfoEPPNS5_11InstructionE")
//</editor-fold>
public final RValue EmitCall(final /*const*/ CGFunctionInfo /*&*/ CallInfo, 
        Value /*P*/ Callee, 
        ReturnValueSlot ReturnValue, 
        final /*const*/ CallArgList /*&*/ CallArgs) {
  return EmitCall(CallInfo, 
        Callee, 
        ReturnValue, 
        CallArgs, 
        new CGCalleeInfo(), 
        (type$ptr<Instruction /*P*/ /*P*/>)null);
}
public final RValue EmitCall(final /*const*/ CGFunctionInfo /*&*/ CallInfo, 
        Value /*P*/ Callee, 
        ReturnValueSlot ReturnValue, 
        final /*const*/ CallArgList /*&*/ CallArgs, 
        CGCalleeInfo CalleeInfo/*= CGCalleeInfo()*/) {
  return EmitCall(CallInfo, 
        Callee, 
        ReturnValue, 
        CallArgs, 
        CalleeInfo, 
        (type$ptr<Instruction /*P*/ /*P*/>)null);
}
public final RValue EmitCall(final /*const*/ CGFunctionInfo /*&*/ CallInfo, 
        Value /*P*/ Callee, 
        ReturnValueSlot ReturnValue, 
        final /*const*/ CallArgList /*&*/ CallArgs, 
        CGCalleeInfo CalleeInfo/*= CGCalleeInfo()*/, 
        type$ptr<Instruction /*P*/ /*P*/> callOrInvoke/*= null*/) {
  ClangToLLVMArgMapping IRFunctionArgs = null;
  SmallVector<OperandBundleDefT<Value /*P*/ >> BundleList = null;
  try {
    // FIXME: We no longer need the types from CallArgs; lift up and simplify.
    
    // Handle struct-return functions by passing a pointer to the
    // location that we would like to return into.
    QualType RetTy = CallInfo.getReturnType().$QualType();
    final /*const*/ ABIArgInfo /*&*/ RetAI = CallInfo.getReturnInfo$Const();
    
    org.llvm.ir.FunctionType /*P*/ IRFuncTy = IrRTTI.cast_FunctionType(IrRTTI.cast_PointerType(Callee.getType()).getElementType());
    
    // If we're using inalloca, insert the allocation after the stack save.
    // FIXME: Do this earlier rather than hacking it in here!
    Address ArgMemory = Address.invalid();
    /*const*/ StructLayout /*P*/ ArgMemoryLayout = null;
    {
      StructType /*P*/ ArgStruct = CallInfo.getArgStruct();
      if ((ArgStruct != null)) {
        ArgMemoryLayout = $this().CGM.getDataLayout().getStructLayout(ArgStruct);
        Instruction /*P*/ IP = CallArgs.getStackBase();
        AllocaInst /*P*/ AI;
        if ((IP != null)) {
          IP = IP.getNextNode();
          final Instruction /*P*/ L$IP = IP;
          AI = /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
              return new AllocaInst(ArgStruct, new Twine(/*KEEP_STR*/"argmem"), L$IP);
           });
        } else {
          AI = $this().CreateTempAlloca(ArgStruct, new Twine(/*KEEP_STR*/"argmem"));
        }
        CharUnits Align = CallInfo.getArgStructAlignment();
        AI.setAlignment($long2uint(Align.getQuantity()));
        AI.setUsedWithInAlloca(true);
        assert (AI.isUsedWithInAlloca() && !AI.isStaticAlloca());
        ArgMemory.$assignMove(new Address(AI, new CharUnits(Align)));
      }
    }
    /*const*/ StructLayout /*P*/ ArgMemoryLayout_final = ArgMemoryLayout;
    // Helper function to drill into the inalloca allocation.
    UInt2Address createInAllocaStructGEP = /*[&, &ArgMemoryLayout, this, &ArgMemory]*/ (/*uint*/int FieldIndex) -> {
          CharUnits FieldOffset = CharUnits.fromQuantity(ArgMemoryLayout_final.getElementOffset(FieldIndex));
          return $this().Builder.CreateStructGEP(new Address(ArgMemory), FieldIndex, new CharUnits(FieldOffset));
        };
    
    IRFunctionArgs/*J*/= new ClangToLLVMArgMapping($this().CGM.getContext(), CallInfo);
    SmallVector<Value /*P*/ > IRCallArgs/*J*/= new SmallVector<Value /*P*/ >(JD$UInt_T$C$R.INSTANCE, 16, IRFunctionArgs.totalIRArgs(), (Value /*P*/ )null);
    
    // If the call returns a temporary with struct return, create a temporary
    // alloca to hold the result, unless one is given to us.
    Address SRetPtr = Address.invalid();
    /*size_t*/int UnusedReturnSize = 0;
    if (RetAI.isIndirect() || RetAI.isInAlloca() || RetAI.isCoerceAndExpand()) {
      if (!ReturnValue.isNull()) {
        SRetPtr.$assignMove(ReturnValue.getValue());
      } else {
        SRetPtr.$assignMove($this().CreateMemTemp(new QualType(RetTy)));
        if ($this().HaveInsertPoint() && ReturnValue.isUnused()) {
          long/*uint64_t*/ size = $this().CGM.getDataLayout().getTypeAllocSize($this().ConvertTypeForMem(new QualType(RetTy)));
          if (($this().EmitLifetimeStart(size, SRetPtr.getPointer()) != null)) {
            UnusedReturnSize = $ulong2uint(size);
          }
        }
      }
      if (IRFunctionArgs.hasSRetArg()) {
        IRCallArgs.$set(IRFunctionArgs.getSRetArgNo(), SRetPtr.getPointer());
      } else if (RetAI.isInAlloca()) {
        Address Addr = createInAllocaStructGEP.$call(RetAI.getInAllocaFieldIndex());
        $this().Builder.CreateStore(SRetPtr.getPointer(), new Address(Addr));
      }
    }
    
    Address swiftErrorTemp = Address.invalid();
    Address swiftErrorArg = Address.invalid();
    assert (CallInfo.arg_size() == CallArgs.size()) : "Mismatch between function signature & arguments.";
    /*uint*/int ArgNo = 0;
    type$ptr</*const*/ CGFunctionInfoArgInfo /*P*/ > info_it = $tryClone(CallInfo.arg_begin$Const());
    for (type$ptr</*const*/ CallArg /*P*/ > I = $tryClone(CallArgs.begin$Const()), /*P*/ E = $tryClone(CallArgs.end$Const());
         $noteq_ptr(I, E); I.$preInc() , info_it.$preInc() , ++ArgNo) {
      final /*const*/ ABIArgInfo /*&*/ ArgInfo = info_it./*->*/$star().info;
      RValue RV = new RValue(I./*->*/$star().RV);
      
      // Insert a padding argument to ensure proper alignment.
      if (IRFunctionArgs.hasPaddingArg(ArgNo)) {
        IRCallArgs.$set(IRFunctionArgs.getPaddingArgNo(ArgNo), 
          UndefValue.get(ArgInfo.getPaddingType()));
      }
      
      //std.tie(FirstIRArg, NumIRArgs).$assign(tmp);
      final pairUIntUInt tmp = IRFunctionArgs.getIRArgs(ArgNo);
      /*uint*/int FirstIRArg = tmp.first;
      /*uint*/int NumIRArgs = tmp.second;
      switch (ArgInfo.getKind()) {
       case InAlloca:
        {
          assert (NumIRArgs == 0);
          assert ($this().getTarget().getTriple().getArch() == Triple.ArchType.x86);
          if (RV.isAggregate()) {
            // Replace the placeholder with the appropriate argument slot GEP.
            Instruction /*P*/ Placeholder = IrRTTI.cast_Instruction(RV.getAggregatePointer());
            CGBuilderTy.InsertPoint IP = $this().Builder.saveIP();
            $this().Builder.SetInsertPoint(Placeholder);
            Address Addr = createInAllocaStructGEP.$call(ArgInfo.getInAllocaFieldIndex());
            $this().Builder.restoreIP(new IRBuilderBase.InsertPoint(IP));
            $this().deferPlaceholderReplacement(Placeholder, Addr.getPointer());
          } else {
            // Store the RValue into the argument struct.
            Address Addr = createInAllocaStructGEP.$call(ArgInfo.getInAllocaFieldIndex());
            /*uint*/int AS = Addr.getType().getPointerAddressSpace();
            org.llvm.ir.Type /*P*/ MemType = $this().ConvertTypeForMem(new QualType(I./*->*/$star().Ty)).getPointerTo(AS);
            // There are some cases where a trivial bitcast is not avoidable.  The
            // definition of a type later in a translation unit may change it's type
            // from {}* to (%struct.foo*)*.
            if (Addr.getType() != MemType) {
              Addr.$assignMove($this().Builder.CreateBitCast(new Address(Addr), MemType));
            }
            LValue argLV = $this().MakeAddrLValue(new Address(Addr), new QualType(I./*->*/$star().Ty));
            CGCallStatics.EmitInitStoreOfNonAggregate(/*Deref*/$this(), new RValue(RV), new LValue(argLV));
          }
          break;
        }
       case Indirect:
        {
          assert (NumIRArgs == 1);
          if (RV.isScalar() || RV.isComplex()) {
            // Make a temporary alloca to pass the argument.
            Address Addr = $this().CreateMemTemp(new QualType(I./*->*/$star().Ty), ArgInfo.getIndirectAlign());
            IRCallArgs.$set(FirstIRArg, Addr.getPointer());
            
            LValue argLV = $this().MakeAddrLValue(new Address(Addr), new QualType(I./*->*/$star().Ty));
            CGCallStatics.EmitInitStoreOfNonAggregate(/*Deref*/$this(), new RValue(RV), new LValue(argLV));
          } else {
            // We want to avoid creating an unnecessary temporary+copy here;
            // however, we need one in three cases:
            // 1. If the argument is not byval, and we are required to copy the
            //    source.  (This case doesn't occur on any common architecture.)
            // 2. If the argument is byval, RV is not sufficiently aligned, and
            //    we cannot force it to be sufficiently aligned.
            // 3. If the argument is byval, but RV is located in an address space
            //    different than that of the argument (0).
            Address Addr = RV.getAggregateAddress();
            CharUnits Align = ArgInfo.getIndirectAlign();
            /*const*/ DataLayout /*P*/ TD = /*AddrOf*/$this().CGM.getDataLayout();
            /*const*//*uint*/int RVAddrSpace = Addr.getType().getAddressSpace();
            /*const*//*uint*/int ArgAddrSpace = ($less_uint(FirstIRArg, IRFuncTy.getNumParams()) ? IRFuncTy.getParamType(FirstIRArg).getPointerAddressSpace() : 0);
            if ((!ArgInfo.getIndirectByVal() && I./*->*/$star().NeedsCopy)
               || (ArgInfo.getIndirectByVal() && Addr.getAlignment().$less(Align)
               && $uint2llong(TransformsLlvmGlobals.getOrEnforceKnownAlignment(Addr.getPointer(), 
                $long2uint(Align.getQuantity()), /*Deref*/TD))
               < Align.getQuantity())
               || (ArgInfo.getIndirectByVal() && (RVAddrSpace != ArgAddrSpace))) {
              // Create an aligned temporary, and copy to it.
              Address AI = $this().CreateMemTemp(new QualType(I./*->*/$star().Ty), ArgInfo.getIndirectAlign());
              IRCallArgs.$set(FirstIRArg, AI.getPointer());
              $this().EmitAggregateCopy(new Address(AI), new Address(Addr), new QualType(I./*->*/$star().Ty), RV.isVolatileQualified());
            } else {
              // Skip the extra memcpy call.
              IRCallArgs.$set(FirstIRArg, Addr.getPointer());
            }
          }
          break;
        }
       case Ignore:
        assert (NumIRArgs == 0);
        break;
       case Extend:
       case Direct:
        {
          if (!IrRTTI.isa_StructType(ArgInfo.getCoerceToType())
             && ArgInfo.getCoerceToType() == $this().ConvertType(info_it./*->*/$star().type.$QualType())
             && ArgInfo.getDirectOffset() == 0) {
            assert (NumIRArgs == 1);
            Value /*P*/ V;
            if (RV.isScalar()) {
              V = RV.getScalarVal();
            } else {
              V = $this().Builder.CreateLoad(RV.getAggregateAddress());
            }
            
            // Implement swifterror by copying into a new swifterror argument.
            // We'll write back in the normal path out of the call.
            if (CallInfo.getExtParameterInfo(ArgNo).getABI()
               == ParameterABI.SwiftErrorResult) {
              assert (!swiftErrorTemp.isValid()) : "multiple swifterror args";
              
              QualType pointeeTy = I./*->*/$star().Ty.$arrow().getPointeeType();
              swiftErrorArg.$assignMove(
                  new Address(V, $this().getContext().getTypeAlignInChars(new QualType(pointeeTy)))
              );
              
              swiftErrorTemp.$assignMove(
                  $this().CreateMemTemp(new QualType(pointeeTy), /*J:ToBase*/super.getPointerAlign(), new Twine(/*KEEP_STR*/"swifterror.temp"))
              );
              V = swiftErrorTemp.getPointer();
              IrRTTI.cast_AllocaInst(V).setSwiftError(true);
              
              Value /*P*/ errorValue = $this().Builder.CreateLoad(new Address(swiftErrorArg));
              $this().Builder.CreateStore(errorValue, new Address(swiftErrorTemp));
            }
            
            // We might have to widen integers, but we should never truncate.
            if (ArgInfo.getCoerceToType() != V.getType()
               && V.getType().isIntegerTy()) {
              V = $this().Builder.CreateZExt(V, ArgInfo.getCoerceToType());
            }
            
            // If the argument doesn't match, perform a bitcast to coerce it.  This
            // can happen due to trivial type mismatches.
            if ($less_uint(FirstIRArg, IRFuncTy.getNumParams())
               && V.getType() != IRFuncTy.getParamType(FirstIRArg)) {
              V = $this().Builder.CreateBitCast(V, IRFuncTy.getParamType(FirstIRArg));
            }
            
            IRCallArgs.$set(FirstIRArg, V);
            break;
          }
          
          // FIXME: Avoid the conversion through memory if possible.
          Address Src = Address.invalid();
          if (RV.isScalar() || RV.isComplex()) {
            Src.$assignMove($this().CreateMemTemp(new QualType(I./*->*/$star().Ty), new Twine(/*KEEP_STR*/"coerce")));
            LValue SrcLV = $this().MakeAddrLValue(new Address(Src), new QualType(I./*->*/$star().Ty));
            CGCallStatics.EmitInitStoreOfNonAggregate(/*Deref*/$this(), new RValue(RV), new LValue(SrcLV));
          } else {
            Src.$assignMove(RV.getAggregateAddress());
          }
          
          // If the value is offset in memory, apply the offset now.
          Src.$assignMove(CGCallStatics.emitAddressAtOffset(/*Deref*/$this(), new Address(Src), ArgInfo));
          
          // Fast-isel and the optimizer generally like scalar values better than
          // FCAs, so we flatten them if this is safe to do for this argument.
          StructType /*P*/ STy = IrRTTI.dyn_cast_StructType(ArgInfo.getCoerceToType());
          if ((STy != null) && ArgInfo.isDirect() && ArgInfo.getCanBeFlattened()) {
            org.llvm.ir.Type /*P*/ SrcTy = Src.getType().getElementType();
            long/*uint64_t*/ SrcSize = $this().CGM.getDataLayout().getTypeAllocSize(SrcTy);
            long/*uint64_t*/ DstSize = $this().CGM.getDataLayout().getTypeAllocSize(STy);
            
            // If the source type is smaller than the destination type of the
            // coerce-to logic, copy the source value into a temp alloca the size
            // of the destination type to allow loading all of it. The bits past
            // the source value are left undef.
            if ($less_ulong(SrcSize, DstSize)) {
              Address TempAlloca = $this().CreateTempAlloca(STy, Src.getAlignment(), 
                  $add_StringRef$C_char$ptr$C(Src.getName(), /*KEEP_STR*/".coerce"));
              $this().Builder.CreateMemCpy(new Address(TempAlloca), new Address(Src), SrcSize);
              Src.$assign(TempAlloca);
            } else {
              Src.$assignMove($this().Builder.CreateBitCast(new Address(Src), org.llvm.ir.PointerType.getUnqual(STy)));
            }
            
            /*const*/ StructLayout /*P*/ SrcLayout = $this().CGM.getDataLayout().getStructLayout(STy);
            assert (NumIRArgs == STy.getNumElements());
            for (/*uint*/int i = 0, e = STy.getNumElements(); i != e; ++i) {
              CharUnits Offset = CharUnits.fromQuantity(SrcLayout.getElementOffset(i));
              Address EltPtr = $this().Builder.CreateStructGEP(new Address(Src), i, new CharUnits(Offset));
              Value /*P*/ LI = $this().Builder.CreateLoad(new Address(EltPtr));
              IRCallArgs.$set(FirstIRArg + i, LI);
            }
          } else {
            // In the simple case, just pass the coerced loaded value.
            assert (NumIRArgs == 1);
            IRCallArgs.$set(FirstIRArg, 
              CGCallStatics.CreateCoercedLoad(new Address(Src), ArgInfo.getCoerceToType(), /*Deref*/$this()));
          }
          
          break;
        }
       case CoerceAndExpand:
        {
          StructType /*P*/ coercionType = ArgInfo.getCoerceAndExpandType();
          /*const*/ StructLayout /*P*/ layout = $this().CGM.getDataLayout().getStructLayout(coercionType);
          
          Value /*P*/ tempSize = null;
          Address addr = Address.invalid();
          if (RV.isAggregate()) {
            addr.$assignMove(RV.getAggregateAddress());
          } else {
            assert (RV.isScalar()); // complex should always just be direct
            
            org.llvm.ir.Type /*P*/ scalarType = RV.getScalarVal().getType();
            long/*uint64_t*/ scalarSize = $this().CGM.getDataLayout().getTypeAllocSize(scalarType);
            /*uint*/int scalarAlign = $this().CGM.getDataLayout().getPrefTypeAlignment(scalarType);
            
            tempSize = ConstantInt.get($this().CGM.Int64Ty, scalarSize);
            
            // Materialize to a temporary.
            addr.$assignMove($this().CreateTempAlloca(RV.getScalarVal().getType(), 
                    CharUnits.fromQuantity($uint2long(std.max(layout.getAlignment(), 
                            scalarAlign)))));
            $this().EmitLifetimeStart(scalarSize, addr.getPointer());
            
            $this().Builder.CreateStore(RV.getScalarVal(), new Address(addr));
          }
          
          addr.$assignMove($this().Builder.CreateElementBitCast(new Address(addr), coercionType));
          
          /*uint*/int IRArgPos = FirstIRArg;
          for (/*uint*/int i = 0, e = coercionType.getNumElements(); i != e; ++i) {
            org.llvm.ir.Type /*P*/ eltType = coercionType.getElementType(i);
            if (ABIArgInfo.isPaddingForCoerceAndExpand(eltType)) {
              continue;
            }
            Address eltAddr = $this().Builder.CreateStructGEP(new Address(addr), i, layout);
            Value /*P*/ elt = $this().Builder.CreateLoad(new Address(eltAddr));
            IRCallArgs.$set(IRArgPos++, elt);
          }
          assert (IRArgPos == FirstIRArg + NumIRArgs);
          if ((tempSize != null)) {
            $this().EmitLifetimeEnd(tempSize, addr.getPointer());
          }
          
          break;
        }
       case Expand:
        uint$ref IRArgPos = create_uint$ref(FirstIRArg);
        $this().ExpandTypeToArgs(new QualType(I./*->*/$star().Ty), new RValue(RV), IRFuncTy, IRCallArgs, IRArgPos);
        assert (IRArgPos.$deref() == FirstIRArg + NumIRArgs);
        break;
      }
    }
    if (ArgMemory.isValid()) {
      Value /*P*/ Arg = ArgMemory.getPointer();
      if (CallInfo.isVariadic()) {
        // When passing non-POD arguments by value to variadic functions, we will
        // end up with a variadic prototype and an inalloca call site.  In such
        // cases, we can't do any parameter mismatch checks.  Give up and bitcast
        // the callee.
        /*uint*/int CalleeAS = IrRTTI.cast_PointerType(Callee.getType()).getAddressSpace();
        Callee = $this().Builder.CreateBitCast(Callee, $this().getTypes().GetFunctionType(CallInfo).getPointerTo(CalleeAS));
      } else {
        org.llvm.ir.Type /*P*/ LastParamTy = IRFuncTy.getParamType(IRFuncTy.getNumParams() - 1);
        if (Arg.getType() != LastParamTy) {
          // Assert that these structs have equivalent element types.
          StructType /*P*/ FullTy = CallInfo.getArgStruct();
          StructType /*P*/ DeclaredTy = IrRTTI.cast_StructType(IrRTTI.cast_PointerType(LastParamTy).getElementType());
          assert (DeclaredTy.getNumElements() == FullTy.getNumElements());
          for (type$ptr<org.llvm.ir.Type /*P*/ /*const*/ /*P*/> DI = $tryClone(DeclaredTy.element_begin()), 
              /*P*/ /*const*/ /*P*/ DE = $tryClone(DeclaredTy.element_end()), 
              /*P*/ /*const*/ /*P*/ FI = $tryClone(FullTy.element_begin());
               $noteq_ptr(DI, DE); DI.$preInc() , FI.$preInc())  {
            assert (DI.$star() == FI.$star());
          }
          Arg = $this().Builder.CreateBitCast(Arg, LastParamTy);
        }
      }
      assert (IRFunctionArgs.hasInallocaArg());
      IRCallArgs.$set(IRFunctionArgs.getInallocaArgNo(), Arg);
    }
    if (!CallArgs.getCleanupsToDeactivate().empty()) {
      CGCallStatics.deactivateArgCleanupsBeforeCall(/*Deref*/$this(), CallArgs);
    }
    {
      
      // If the callee is a bitcast of a function to a varargs pointer to function
      // type, check to see if we can remove the bitcast.  This handles some cases
      // with unprototyped functions.
      ConstantExpr /*P*/ CE = IrRTTI.dyn_cast_ConstantExpr(Callee);
      if ((CE != null)) {
        {
          Function /*P*/ CalleeF = IrRTTI.dyn_cast_Function(CE.getOperand_Constant(0));
          if ((CalleeF != null)) {
            org.llvm.ir.PointerType /*P*/ CurPT = IrRTTI.cast_PointerType(Callee.getType());
            org.llvm.ir.FunctionType /*P*/ CurFT = IrRTTI.cast_FunctionType(CurPT.getElementType());
            org.llvm.ir.FunctionType /*P*/ ActualFT = CalleeF.getFunctionType();
            if (CE.getOpcode() == Instruction.CastOps.BitCast
               && ActualFT.getReturnType() == CurFT.getReturnType()
               && ActualFT.getNumParams() == CurFT.getNumParams()
               && ActualFT.getNumParams() == IRCallArgs.size()
               && (CurFT.isVarArg() || !ActualFT.isVarArg())) {
              boolean ArgsMatch = true;
              for (/*uint*/int i = 0, e = ActualFT.getNumParams(); i != e; ++i)  {
                if (ActualFT.getParamType(i) != CurFT.getParamType(i)) {
                  ArgsMatch = false;
                  break;
                }
              }
              
              // Strip the cast if we can get away with it.  This is a nice cleanup,
              // but also allows us to inline the function at -O0 if it is marked
              // always_inline.
              if (ArgsMatch) {
                Callee = CalleeF;
              }
            }
          }
        }
      }
    }
    assert (IRCallArgs.size() == IRFuncTy.getNumParams() || IRFuncTy.isVarArg());
    for (/*uint*/int i = 0; $less_uint(i, IRCallArgs.size()); ++i) {
      // Inalloca argument can have different type.
      if (IRFunctionArgs.hasInallocaArg()
         && i == IRFunctionArgs.getInallocaArgNo()) {
        continue;
      }
      if ($less_uint(i, IRFuncTy.getNumParams())) {
        assert (IRCallArgs.$at(i).getType() == IRFuncTy.getParamType(i));
      }
    }
    
    uint$ref CallingConv = create_uint$ref();
    SmallVector<AttributeSet> AttributeList/*J*/= new SmallVector<AttributeSet>(8, new AttributeSet());
    $this().CGM.ConstructAttributeList(Callee.getName(), CallInfo, new CGCalleeInfo(CalleeInfo), 
        AttributeList, CallingConv, 
        /*AttrOnCallSite=*/ true);
    AttributeSet Attrs = AttributeSet.get_LLVMContext_ArrayRef$AttributeSet($this().getLLVMContext(), 
        new ArrayRef<AttributeSet>(AttributeList, false));
    
    boolean CannotThrow;
    if ($this().currentFunctionUsesSEHTry()) {
      // SEH cares about asynchronous exceptions, everything can "throw."
      CannotThrow = false;
    } else if ($this().isCleanupPadScope()
       && EHPersonality.get(/*Deref*/$this()).isMSVCXXPersonality()) {
      // The MSVC++ personality will implicitly terminate the program if an
      // exception is thrown.  An unwind edge cannot be reached.
      CannotThrow = true;
    } else {
      // Otherwise, nowunind callsites will never throw.
      CannotThrow = Attrs.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), 
          Attribute.AttrKind.NoUnwind);
    }
    BasicBlock /*P*/ InvokeDest = CannotThrow ? null : $this().getInvokeDest();
    
    BundleList/*J*/= new SmallVector<OperandBundleDefT<Value /*P*/ >>(1, new OperandBundleDefT<Value /*P*/ >());
    CGCallStatics.getBundlesForFunclet(Callee, $this().CurrentFuncletPad, BundleList);
    
    CallSite CS/*J*/= new CallSite();
    if (!(InvokeDest != null)) {
      CS.$assignMove(new CallSite($this().Builder.CreateCall(Callee, new ArrayRef<Value /*P*/ >(IRCallArgs, true), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(BundleList, false))));
    } else {
      BasicBlock /*P*/ Cont = $this().createBasicBlock(new Twine(/*KEEP_STR*/"invoke.cont"));
      CS.$assignMove(new CallSite($this().Builder.CreateInvoke(Callee, Cont, InvokeDest, new ArrayRef<Value /*P*/ >(IRCallArgs, true), 
                  new ArrayRef<OperandBundleDefT<Value /*P*/ >>(BundleList, false))));
      $this().EmitBlock(Cont);
    }
    if (Native.$bool(callOrInvoke)) {
      callOrInvoke.$set(CS.getInstruction());
    }
    if (($this().CurCodeDecl != null) && $this().CurCodeDecl.hasAttr(FlattenAttr.class)
       && !CS.hasFnAttr(Attribute.AttrKind.NoInline)) {
      Attrs.$assignMove(
          Attrs.addAttribute($this().getLLVMContext(), AttributeSet.AttrIndex.FunctionIndex.getValue(), 
              Attribute.AttrKind.AlwaysInline)
      );
    }
    
    // Disable inlining inside SEH __try blocks.
    if ($this().isSEHTryScope()) {
      Attrs.$assignMove(
          Attrs.addAttribute($this().getLLVMContext(), AttributeSet.AttrIndex.FunctionIndex.getValue(), 
              Attribute.AttrKind.NoInline)
      );
    }
    
    CS.setAttributes(Attrs);
    CS.setCallingConv(((/*static_cast*//*uint*/int)(CallingConv.$deref())));
    
    // Insert instrumentation or attach profile metadata at indirect call sites.
    // For more details, see the comment before the definition of
    // IPVK_IndirectCallTarget in InstrProfData.inc.
    if (!(CS.getCalledFunction() != null)) {
      $this().PGO.valueProfile($this().Builder, InstrProfValueKind.IPVK_IndirectCallTarget.getValue(), 
          CS.getInstruction(), Callee);
    }
    
    // In ObjC ARC mode with no ObjC ARC exception safety, tell the ARC
    // optimizer it can aggressively ignore unwind edges.
    if ($this().CGM.getLangOpts().ObjCAutoRefCount) {
      $this().AddObjCARCExceptionMetadata(CS.getInstruction());
    }
    
    // If the call doesn't return, finish the basic block and clear the
    // insertion point; this allows the rest of IRgen to discard
    // unreachable code.
    if (CS.doesNotReturn()) {
      if ((UnusedReturnSize != 0)) {
        $this().EmitLifetimeEnd(ConstantInt.get(Int64Ty, $uint2ulong(UnusedReturnSize)), 
            SRetPtr.getPointer());
      }
      
      $this().Builder.CreateUnreachable();
      $this().Builder.ClearInsertionPoint();
      
      // FIXME: For now, emit a dummy basic block because expr emitters in
      // generally are not ready to handle emitting expressions at unreachable
      // points.
      $this().EnsureInsertPoint();
      
      // Return a reasonable RValue.
      return $this().GetUndefRValue(new QualType(RetTy));
    }
    
    Instruction /*P*/ CI = CS.getInstruction();
    if (!CI.getType().isVoidTy()) {
      CI.setName(new Twine(/*KEEP_STR*/"call"));
    }
    
    // Perform the swifterror writeback.
    if (swiftErrorTemp.isValid()) {
      Value /*P*/ errorResult = $this().Builder.CreateLoad(new Address(swiftErrorTemp));
      $this().Builder.CreateStore(errorResult, new Address(swiftErrorArg));
    }
    
    // Emit any writebacks immediately.  Arguably this should happen
    // after any return-value munging.
    if (CallArgs.hasWritebacks()) {
      CGCallStatics.emitWritebacks(/*Deref*/$this(), CallArgs);
    }
    
    // The stack cleanup for inalloca arguments has to run out of the normal
    // lexical order, so deactivate it and run it manually here.
    CallArgs.freeArgumentMemory(/*Deref*/$this());
    {
      
      CallInst /*P*/ Call = IrRTTI.dyn_cast_CallInst(CI);
      if ((Call != null)) {
        /*const*/ Decl /*P*/ TargetDecl = CalleeInfo.getCalleeDecl();
        if ((TargetDecl != null) && TargetDecl.hasAttr(NotTailCalledAttr.class)) {
          Call.setTailCallKind(CallInst.TailCallKind.TCK_NoTail);
        }
      }
    }
    int UnusedReturnSize_final = UnusedReturnSize;
    Void2RValue lambda = /*[&, &RetAI, this, &SRetPtr, &CI, &RetTy, &UnusedReturnSize, &ReturnValue]*/() -> {
          switch (RetAI.getKind()) {
           case CoerceAndExpand:
            {
              StructType /*P*/ coercionType = RetAI.getCoerceAndExpandType();
              /*const*/ StructLayout /*P*/ layout = $this().CGM.getDataLayout().getStructLayout(coercionType);
              
              Address addr = new Address(SRetPtr);
              addr.$assignMove($this().Builder.CreateElementBitCast(new Address(addr), coercionType));
              assert (CI.getType() == RetAI.getUnpaddedCoerceAndExpandType());
              boolean requiresExtract = IrRTTI.isa_StructType(CI.getType());
              
              /*uint*/int unpaddedIndex = 0;
              for (/*uint*/int i = 0, e = coercionType.getNumElements(); i != e; ++i) {
                org.llvm.ir.Type /*P*/ eltType = coercionType.getElementType(i);
                if (ABIArgInfo.isPaddingForCoerceAndExpand(eltType)) {
                  continue;
                }
                Address eltAddr = $this().Builder.CreateStructGEP(new Address(addr), i, layout);
                Value /*P*/ elt = CI;
                if (requiresExtract) {
                  elt = $this().Builder.CreateExtractValue(elt, new ArrayRefUInt(unpaddedIndex++));
                } else {
                  assert (unpaddedIndex == 0);
                }
                $this().Builder.CreateStore(elt, new Address(eltAddr));
              }
              // FALLTHROUGH
            }
           case InAlloca:
           case Indirect:
            {
              RValue ret = $this().convertTempToRValue(new Address(SRetPtr), new QualType(RetTy), new SourceLocation());
              if ((UnusedReturnSize_final != 0)) {
                $this().EmitLifetimeEnd(ConstantInt.get(Int64Ty, $uint2ulong(UnusedReturnSize_final)), 
                    SRetPtr.getPointer());
              }
              return ret;
            }
           case Ignore:
            // If we are ignoring an argument that had a result, make sure to
            // construct the appropriate return value for our caller.
            return $this().GetUndefRValue(new QualType(RetTy));
           case Extend:
           case Direct:
            {
              org.llvm.ir.Type /*P*/ RetIRTy = $this().ConvertType(new QualType(RetTy));
              if (RetAI.getCoerceToType() == RetIRTy && RetAI.getDirectOffset() == 0) {
                switch (CodeGenFunction.getEvaluationKind(new QualType(RetTy))) {
                 case TEK_Complex:
                  {
                    Value /*P*/ Real = $this().Builder.CreateExtractValue(CI, new ArrayRefUInt(0));
                    Value /*P*/ Imag = $this().Builder.CreateExtractValue(CI, new ArrayRefUInt(1));
                    return RValue.getComplex(std.make_pair_Ptr_Ptr(Real, Imag));
                  }
                 case TEK_Aggregate:
                  {
                    Address DestPtr = ReturnValue.getValue();
                    boolean DestIsVolatile = ReturnValue.isVolatile();
                    if (!DestPtr.isValid()) {
                      DestPtr.$assignMove($this().CreateMemTemp(new QualType(RetTy), new Twine(/*KEEP_STR*/"agg.tmp")));
                      DestIsVolatile = false;
                    }
                    CGCallStatics.BuildAggStore(/*Deref*/$this(), CI, new Address(DestPtr), DestIsVolatile);
                    return RValue.getAggregate(new Address(DestPtr));
                  }
                 case TEK_Scalar:
                  {
                    // If the argument doesn't match, perform a bitcast to coerce it.  This
                    // can happen due to trivial type mismatches.
                    Value /*P*/ V = CI;
                    if (V.getType() != RetIRTy) {
                      V = $this().Builder.CreateBitCast(V, RetIRTy);
                    }
                    return RValue.get(V);
                  }
                }
                throw new llvm_unreachable("bad evaluation kind");
              }
              
              Address DestPtr = ReturnValue.getValue();
              boolean DestIsVolatile = ReturnValue.isVolatile();
              if (!DestPtr.isValid()) {
                DestPtr.$assignMove($this().CreateMemTemp(new QualType(RetTy), new Twine(/*KEEP_STR*/"coerce")));
                DestIsVolatile = false;
              }
              
              // If the value is offset in memory, apply the offset now.
              Address StorePtr = CGCallStatics.emitAddressAtOffset(/*Deref*/$this(), new Address(DestPtr), RetAI);
              CGCallStatics.CreateCoercedStore(CI, new Address(StorePtr), DestIsVolatile, /*Deref*/$this());
              
              return $this().convertTempToRValue(new Address(DestPtr), new QualType(RetTy), new SourceLocation());
            }
           case Expand:
            throw new llvm_unreachable("Invalid ABI kind for return argument");
          }
          throw new llvm_unreachable("Unhandled ABIArgInfo::Kind");
        };
    RValue Ret = lambda.$call();
    
    /*const*/ Decl /*P*/ TargetDecl = CalleeInfo.getCalleeDecl();
    if (Ret.isScalar() && (TargetDecl != null)) {
      {
        /*const*/ AssumeAlignedAttr /*P*/ AA = TargetDecl.getAttr(AssumeAlignedAttr.class);
        if ((AA != null)) {
          Value /*P*/ OffsetValue = null;
          {
            /*const*/ Expr /*P*/ Offset = AA.getOffset();
            if ((Offset != null)) {
              OffsetValue = $this().EmitScalarExpr(Offset);
            }
          }
          
          Value /*P*/ Alignment = $this().EmitScalarExpr(AA.getAlignment());
          ConstantInt /*P*/ AlignmentCI = IrRTTI.cast_ConstantInt(Alignment);
          $this().EmitAlignmentAssumption(Ret.getScalarVal(), $ulong2uint(AlignmentCI.getZExtValue()), 
              OffsetValue);
        }
      }
    }
    
    return Ret;
  } finally {
    if (BundleList != null) { BundleList.$destroy(); }
    if (IRFunctionArgs != null) { IRFunctionArgs.$destroy(); }
  }
}


/// Emits a simple call (never an invoke) to the given no-arguments
/// runtime function.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitRuntimeCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3387,
 FQN="clang::CodeGen::CodeGenFunction::EmitRuntimeCall", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitRuntimeCallEPN4llvm5ValueERKNS2_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitRuntimeCallEPN4llvm5ValueERKNS2_5TwineE")
//</editor-fold>
public final CallInst /*P*/ EmitRuntimeCall(Value /*P*/ callee) {
  return EmitRuntimeCall(callee, 
               new Twine(/*KEEP_STR*/$EMPTY));
}
public final CallInst /*P*/ EmitRuntimeCall(Value /*P*/ callee, 
               final /*const*/ Twine /*&*/ name/*= ""*/) {
  return $this().EmitRuntimeCall(callee, new ArrayRef<Value /*P*/ >(None, true), name);
}


/// Emits a simple call (never an invoke) to the given runtime function.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitRuntimeCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3412,
 FQN="clang::CodeGen::CodeGenFunction::EmitRuntimeCall", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitRuntimeCallEPN4llvm5ValueENS2_8ArrayRefIS4_EERKNS2_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitRuntimeCallEPN4llvm5ValueENS2_8ArrayRefIS4_EERKNS2_5TwineE")
//</editor-fold>
public final CallInst /*P*/ EmitRuntimeCall(Value /*P*/ callee, 
               ArrayRef<Value /*P*/ > args) {
  return EmitRuntimeCall(callee, 
               args, 
               new Twine(/*KEEP_STR*/$EMPTY));
}
public final CallInst /*P*/ EmitRuntimeCall(Value /*P*/ callee, 
               ArrayRef<Value /*P*/ > args, 
               final /*const*/ Twine /*&*/ name/*= ""*/) {
  SmallVector<OperandBundleDefT<Value /*P*/ >> BundleList = null;
  try {
    BundleList/*J*/= new SmallVector<OperandBundleDefT<Value /*P*/ >>(1, new OperandBundleDefT<Value /*P*/ >());
    CGCallStatics.getBundlesForFunclet(callee, $this().CurrentFuncletPad, BundleList);
    
    CallInst /*P*/ call = $this().Builder.CreateCall(callee, new ArrayRef<Value /*P*/ >(args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(BundleList, false), name);
    call.setCallingConv(/*J:ToBase*/super.getRuntimeCC());
    return call;
  } finally {
    if (BundleList != null) { BundleList.$destroy(); }
  }
}


/// Emits a call to the given no-arguments nounwind runtime function.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitNounwindRuntimeCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3369,
 FQN="clang::CodeGen::CodeGenFunction::EmitNounwindRuntimeCall", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitNounwindRuntimeCallEPN4llvm5ValueERKNS2_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitNounwindRuntimeCallEPN4llvm5ValueERKNS2_5TwineE")
//</editor-fold>
public final CallInst /*P*/ EmitNounwindRuntimeCall(Value /*P*/ callee) {
  return EmitNounwindRuntimeCall(callee, 
                       new Twine(/*KEEP_STR*/$EMPTY));
}
public final CallInst /*P*/ EmitNounwindRuntimeCall(Value /*P*/ callee, 
                       final /*const*/ Twine /*&*/ name/*= ""*/) {
  return $this().EmitNounwindRuntimeCall(callee, new ArrayRef<Value /*P*/ >(None, true), name);
}


/// Emits a call to the given nounwind runtime function.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitNounwindRuntimeCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3376,
 FQN="clang::CodeGen::CodeGenFunction::EmitNounwindRuntimeCall", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitNounwindRuntimeCallEPN4llvm5ValueENS2_8ArrayRefIS4_EERKNS2_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitNounwindRuntimeCallEPN4llvm5ValueENS2_8ArrayRefIS4_EERKNS2_5TwineE")
//</editor-fold>
public final CallInst /*P*/ EmitNounwindRuntimeCall(Value /*P*/ callee, 
                       ArrayRef<Value /*P*/ > args) {
  return EmitNounwindRuntimeCall(callee, 
                       args, 
                       new Twine(/*KEEP_STR*/$EMPTY));
}
public final CallInst /*P*/ EmitNounwindRuntimeCall(Value /*P*/ callee, 
                       ArrayRef<Value /*P*/ > args, 
                       final /*const*/ Twine /*&*/ name/*= ""*/) {
  CallInst /*P*/ call = $this().EmitRuntimeCall(callee, new ArrayRef<Value /*P*/ >(args), name);
  call.setDoesNotThrow();
  return call;
}


/// Emits a call or invoke instruction to the given function, depending
/// on the current state of the EH stack.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCallOrInvoke">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3466,
 FQN="clang::CodeGen::CodeGenFunction::EmitCallOrInvoke", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitCallOrInvokeEPN4llvm5ValueENS2_8ArrayRefIS4_EERKNS2_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitCallOrInvokeEPN4llvm5ValueENS2_8ArrayRefIS4_EERKNS2_5TwineE")
//</editor-fold>
public final CallSite EmitCallOrInvoke(Value /*P*/ Callee, 
                ArrayRef<Value /*P*/ > Args) {
  return EmitCallOrInvoke(Callee, 
                Args, 
                new Twine(/*KEEP_STR*/$EMPTY));
}
public final CallSite EmitCallOrInvoke(Value /*P*/ Callee, 
                ArrayRef<Value /*P*/ > Args, 
                final /*const*/ Twine /*&*/ Name/*= ""*/) {
  SmallVector<OperandBundleDefT<Value /*P*/ >> BundleList = null;
  try {
    BasicBlock /*P*/ InvokeDest = $this().getInvokeDest();
    BundleList/*J*/= new SmallVector<OperandBundleDefT<Value /*P*/ >>(1, new OperandBundleDefT<Value /*P*/ >());
    CGCallStatics.getBundlesForFunclet(Callee, $this().CurrentFuncletPad, BundleList);
    
    Instruction /*P*/ Inst;
    if (!(InvokeDest != null)) {
      Inst = $this().Builder.CreateCall(Callee, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(BundleList, false), Name);
    } else {
      BasicBlock /*P*/ ContBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"invoke.cont"));
      Inst = $this().Builder.CreateInvoke(Callee, ContBB, InvokeDest, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(BundleList, false), 
          Name);
      $this().EmitBlock(ContBB);
    }
    
    // In ObjC ARC mode with no ObjC ARC exception safety, tell the ARC
    // optimizer it can aggressively ignore unwind edges.
    if ($this().CGM.getLangOpts().ObjCAutoRefCount) {
      $this().AddObjCARCExceptionMetadata(Inst);
    }
    
    return new CallSite(Inst);
  } finally {
    if (BundleList != null) { BundleList.$destroy(); }
  }
}


/// Emits a call or invoke instruction to the given runtime function.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitRuntimeCallOrInvoke">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3455,
 FQN="clang::CodeGen::CodeGenFunction::EmitRuntimeCallOrInvoke", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitRuntimeCallOrInvokeEPN4llvm5ValueENS2_8ArrayRefIS4_EERKNS2_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitRuntimeCallOrInvokeEPN4llvm5ValueENS2_8ArrayRefIS4_EERKNS2_5TwineE")
//</editor-fold>
public final CallSite EmitRuntimeCallOrInvoke(Value /*P*/ callee, 
                       ArrayRef<Value /*P*/ > args) {
  return EmitRuntimeCallOrInvoke(callee, 
                       args, 
                       new Twine(/*KEEP_STR*/$EMPTY));
}
public final CallSite EmitRuntimeCallOrInvoke(Value /*P*/ callee, 
                       ArrayRef<Value /*P*/ > args, 
                       final /*const*/ Twine /*&*/ name/*= ""*/) {
  CallSite callSite = $this().EmitCallOrInvoke(callee, new ArrayRef<Value /*P*/ >(args), name);
  callSite.setCallingConv(/*J:ToBase*/super.getRuntimeCC());
  return callSite;
}


/// Emits a call or invoke instruction to the given nullary runtime function.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitRuntimeCallOrInvoke">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3448,
 FQN="clang::CodeGen::CodeGenFunction::EmitRuntimeCallOrInvoke", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitRuntimeCallOrInvokeEPN4llvm5ValueERKNS2_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitRuntimeCallOrInvokeEPN4llvm5ValueERKNS2_5TwineE")
//</editor-fold>
public final CallSite EmitRuntimeCallOrInvoke(Value /*P*/ callee) {
  return EmitRuntimeCallOrInvoke(callee, 
                       new Twine(/*KEEP_STR*/$EMPTY));
}
public final CallSite EmitRuntimeCallOrInvoke(Value /*P*/ callee, 
                       final /*const*/ Twine /*&*/ name/*= ""*/) {
  return $this().EmitRuntimeCallOrInvoke(callee, new ArrayRef<Value /*P*/ >(None, true), name);
}


/// Emits a call or invoke to the given noreturn runtime function.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitNoreturnRuntimeCallOrInvoke">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3425,
 FQN="clang::CodeGen::CodeGenFunction::EmitNoreturnRuntimeCallOrInvoke", NM="_ZN5clang7CodeGen15CodeGenFunction31EmitNoreturnRuntimeCallOrInvokeEPN4llvm5ValueENS2_8ArrayRefIS4_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction31EmitNoreturnRuntimeCallOrInvokeEPN4llvm5ValueENS2_8ArrayRefIS4_EE")
//</editor-fold>
public final void EmitNoreturnRuntimeCallOrInvoke(Value /*P*/ callee, 
                               ArrayRef<Value /*P*/ > args) {
  SmallVector<OperandBundleDefT<Value /*P*/ >> BundleList = null;
  try {
    BundleList/*J*/= new SmallVector<OperandBundleDefT<Value /*P*/ >>(1, new OperandBundleDefT<Value /*P*/ >());
    CGCallStatics.getBundlesForFunclet(callee, $this().CurrentFuncletPad, BundleList);
    if (($this().getInvokeDest() != null)) {
      InvokeInst /*P*/ invoke = $this().Builder.CreateInvoke(callee, 
          $this().getUnreachableBlock(), 
          $this().getInvokeDest(), 
          new ArrayRef<Value /*P*/ >(args), 
          new ArrayRef<OperandBundleDefT<Value /*P*/ >>(BundleList, false));
      invoke.setDoesNotReturn();
      invoke.setCallingConv(/*J:ToBase*/super.getRuntimeCC());
    } else {
      CallInst /*P*/ call = $this().Builder.CreateCall(callee, new ArrayRef<Value /*P*/ >(args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(BundleList, false));
      call.setDoesNotReturn();
      call.setCallingConv(/*J:ToBase*/super.getRuntimeCC());
      $this().Builder.CreateUnreachable();
    }
  } finally {
    if (BundleList != null) { BundleList.$destroy(); }
  }
}


/// \brief Create a check for a function parameter that may potentially be
/// declared as non-null.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitNonNullArgCheck">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3148,
 FQN="clang::CodeGen::CodeGenFunction::EmitNonNullArgCheck", NM="_ZN5clang7CodeGen15CodeGenFunction19EmitNonNullArgCheckENS0_6RValueENS_8QualTypeENS_14SourceLocationEPKNS_12FunctionDeclEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19EmitNonNullArgCheckENS0_6RValueENS_8QualTypeENS_14SourceLocationEPKNS_12FunctionDeclEj")
//</editor-fold>
public final void EmitNonNullArgCheck(RValue RV, QualType ArgType, 
                   SourceLocation ArgLoc, 
                   /*const*/ FunctionDecl /*P*/ FD, 
                   /*uint*/int ParmNum) {
  SanitizerScope SanScope = null;
  try {
    if (!$this().SanOpts.has(SanitizerKind.NonnullAttribute) || !(FD != null)) {
      return;
    }
    /*const*/ ParmVarDecl /*P*/ PVD = $less_uint(ParmNum, FD.getNumParams()) ? FD.getParamDecl$Const(ParmNum) : null;
    /*uint*/int ArgNo = (PVD != null) ? PVD.getFunctionScopeIndex() : ParmNum;
    /*const*/ NonNullAttr /*P*/ NNAttr = CGCallStatics.getNonNullAttr(FD, PVD, new QualType(ArgType), ArgNo);
    if (!(NNAttr != null)) {
      return;
    }
    SanScope/*J*/= new SanitizerScope($this());
    assert (RV.isScalar());
    Value /*P*/ V = RV.getScalarVal();
    Value /*P*/ Cond = $this().Builder.CreateICmpNE(V, Constant.getNullValue(V.getType()));
    Constant /*P*/ StaticData[/*3*/] = new Constant /*P*/  [/*3*/] {
      $this().EmitCheckSourceLocation(new SourceLocation(ArgLoc)), 
      $this().EmitCheckSourceLocation(NNAttr.getLocation()), 
      ConstantInt.get(Int32Ty, $uint2ulong(ArgNo + 1))
    };
    $this().EmitCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(std.make_pair_Ptr_ulong(Cond, SanitizerKind.NonnullAttribute), false), 
        new StringRef(/*KEEP_STR*/"nonnull_arg"), new ArrayRef<Constant /*P*/ >(StaticData, true), new ArrayRef<Value /*P*/ >(None, true));
  } finally {
    if (SanScope != null) { SanScope.$destroy(); }
  }
}


/// EmitCallArg - Emit a single call argument.
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCallArg">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3264,
 FQN="clang::CodeGen::CodeGenFunction::EmitCallArg", NM="_ZN5clang7CodeGen15CodeGenFunction11EmitCallArgERNS0_11CallArgListEPKNS_4ExprENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11EmitCallArgERNS0_11CallArgListEPKNS_4ExprENS_8QualTypeE")
//</editor-fold>
public final void EmitCallArg(final CallArgList /*&*/ args, /*const*/ Expr /*P*/ E, 
           QualType type) {
  DisableDebugLocationUpdates Dis = null;
  try {
    Dis/*J*/= new DisableDebugLocationUpdates(/*Deref*/$this(), E);
    {
      /*const*/ ObjCIndirectCopyRestoreExpr /*P*/ CRE = AstExpressionsRTTI.dyn_cast_ObjCIndirectCopyRestoreExpr(E);
      if ((CRE != null)) {
        assert Native.$bool($this().getLangOpts().ObjCAutoRefCount);
        assert ($this().getContext().hasSameType(E.getType(), new QualType(type)));
        CGCallStatics.emitWritebackArg(/*Deref*/$this(), args, CRE);
        /*JAVA:return*/return;
      }
    }
    assert (type.$arrow().isReferenceType() == E.isGLValue()) : "reference binding to unmaterialized r-value!";
    if (E.isGLValue()) {
      assert (E.getObjectKind() == ExprObjectKind.OK_Ordinary);
      args.add($this().EmitReferenceBindingToExpr(E), new QualType(type));
      /*JAVA:return*/return;
    }
    
    boolean HasAggregateEvalKind = CodeGenFunction.hasAggregateEvaluationKind(new QualType(type));
    
    // In the Microsoft C++ ABI, aggregate arguments are destructed by the callee.
    // However, we still have to push an EH-only cleanup in case we unwind before
    // we make it to the call.
    if (HasAggregateEvalKind
       && $this().CGM.getTarget().getCXXABI().areArgsDestroyedLeftToRightInCallee()) {
      // If we're using inalloca, use the argument memory.  Otherwise, use a
      // temporary.
      AggValueSlot Slot/*J*/= new AggValueSlot();
      if (args.isUsingInAlloca()) {
        Slot.$assignMove(CGCallStatics.createPlaceholderSlot(/*Deref*/$this(), new QualType(type)));
      } else {
        Slot.$assignMove($this().CreateAggTemp(new QualType(type), new Twine(/*KEEP_STR*/"agg.tmp")));
      }
      
      /*const*/ CXXRecordDecl /*P*/ RD = type.$arrow().getAsCXXRecordDecl();
      boolean DestroyedInCallee = (RD != null) && RD.hasNonTrivialDestructor()
         && $this().CGM.getCXXABI().getRecordArgABI(RD) != CGCXXABI.RecordArgABI.RAA_Default;
      if (DestroyedInCallee) {
        Slot.setExternallyDestructed();
      }
      
      $this().EmitAggExpr(E, new AggValueSlot(Slot));
      RValue RV = Slot.asRValue();
      args.add(new RValue(RV), new QualType(type));
      if (DestroyedInCallee) {
        // Create a no-op GEP between the placeholder and the cleanup so we can
        // RAUW it successfully.  It also serves as a marker of the first
        // instruction where the cleanup is active.
        $this().<DestroyUnpassedArg>pushFullExprCleanup(CleanupKind.EHCleanup, 
                (Object... A) -> new DestroyUnpassedArg((Address) A[0], (QualType) A[1]), Slot.getAddress(), new QualType(type));
        // This unreachable is a temporary marker which will be removed later.
        Instruction /*P*/ IsActive = $this().Builder.CreateUnreachable();
        args.addArgCleanupDeactivation($this().EHStack.getInnermostEHScope(), IsActive);
      }
      return;
    }
    if (HasAggregateEvalKind && AstExpressionsRTTI.isa_ImplicitCastExpr(E)
       && AstExpressionsRTTI.cast_CastExpr(E).getCastKind() == CastKind.CK_LValueToRValue) {
      LValue L = $this().EmitLValue(AstExpressionsRTTI.cast_CastExpr(E).getSubExpr$Const());
      assert (L.isSimple());
      if (L.getAlignment().$greatereq($this().getContext().getTypeAlignInChars(new QualType(type)))) {
        args.add(L.asAggregateRValue(), new QualType(type), /*NeedsCopy*/ true);
      } else {
        // We can't represent a misaligned lvalue in the CallArgList, so copy
        // to an aligned temporary now.
        Address tmp = $this().CreateMemTemp(new QualType(type));
        $this().EmitAggregateCopy(new Address(tmp), L.getAddress(), new QualType(type), L.isVolatile());
        args.add(RValue.getAggregate(new Address(tmp)), new QualType(type));
      }
      return;
    }
    
    args.add($this().EmitAnyExprToTemp(E), new QualType(type));
  } finally {
    if (Dis != null) { Dis.$destroy(); }
  }
}


/// EmitDelegateCallArg - We are performing a delegate call; that
/// is, the current function is delegating to another one.  Produce
/// a r-value suitable for passing the given parameter.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitDelegateCallArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 2881,
 FQN="clang::CodeGen::CodeGenFunction::EmitDelegateCallArg", NM="_ZN5clang7CodeGen15CodeGenFunction19EmitDelegateCallArgERNS0_11CallArgListEPKNS_7VarDeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19EmitDelegateCallArgERNS0_11CallArgListEPKNS_7VarDeclENS_14SourceLocationE")
//</editor-fold>
public final void EmitDelegateCallArg(final CallArgList /*&*/ args, 
                   /*const*/ VarDecl /*P*/ param, 
                   SourceLocation loc) {
  // StartFunction converted the ABI-lowered parameter(s) into a
  // local alloca.  We need to turn that into an r-value suitable
  // for EmitCall.
  Address local = $this().GetAddrOfLocalVar(param);
  
  QualType type = param.getType();
  assert (!CGCallStatics.isInAllocaArgument($this().CGM.getCXXABI(), new QualType(type))) : "cannot emit delegate call arguments for inalloca arguments!";
  
  // For the most part, we just need to load the alloca, except that
  // aggregate r-values are actually pointers to temporaries.
  if (type.$arrow().isReferenceType()) {
    args.add(RValue.get($this().Builder.CreateLoad(new Address(local))), new QualType(type));
  } else {
    args.add($this().convertTempToRValue(new Address(local), new QualType(type), new SourceLocation(loc)), new QualType(type));
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::deferPlaceholderReplacement">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3502,
 FQN="clang::CodeGen::CodeGenFunction::deferPlaceholderReplacement", NM="_ZN5clang7CodeGen15CodeGenFunction27deferPlaceholderReplacementEPN4llvm11InstructionEPNS2_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction27deferPlaceholderReplacementEPN4llvm11InstructionEPNS2_5ValueE")
//</editor-fold>
protected/*private*/ final void deferPlaceholderReplacement(Instruction /*P*/ Old, 
                           Value /*P*/ New) {
  $this().DeferredReplacements.push_back(std.make_pair_Ptr_Ptr(Old, New));
}


/// ExpandTypeFromArgs - Reconstruct a structure of type \arg Ty
/// from function arguments into \arg Dst. See ABIArgInfo::Expand.
///
/// \param AI - The first function argument of the expansion.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ExpandTypeFromArgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 946,
 FQN="clang::CodeGen::CodeGenFunction::ExpandTypeFromArgs", NM="_ZN5clang7CodeGen15CodeGenFunction18ExpandTypeFromArgsENS_8QualTypeENS0_6LValueERPPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18ExpandTypeFromArgsENS_8QualTypeENS0_6LValueERPPN4llvm5ValueE")
//</editor-fold>
protected/*private*/ final void ExpandTypeFromArgs(QualType Ty, LValue LV, final type$ptr<Value /*P*/ /*P*/> /*&*/ AI) {
  unique_ptr<TypeExpansion> Exp = null;
  try {
    assert (LV.isSimple()) : "Unexpected non-simple lvalue during struct expansion.";
    
    Exp = CGCallStatics.getTypeExpansion(new QualType(Ty), $this().getContext());
    {
      ConstantArrayExpansion /*P*/ CAExp = CodegenRTTI.dyn_cast_ConstantArrayExpansion(Exp.get());
      if ((CAExp != null)) {
        CGCallStatics.forConstantArrayExpansion(/*Deref*/$this(), CAExp, LV.getAddress(), 
            /*FuncArg*//*[&, this, &CAExp, &AI]*/ (Address EltAddr) -> {
                  LValue LV$1 = $this().MakeAddrLValue(new Address(EltAddr), new QualType(CAExp.EltTy));
                  $this().ExpandTypeFromArgs(new QualType(CAExp.EltTy), new LValue(LV$1), AI);
                });
      } else {
        RecordExpansion /*P*/ RExp = CodegenRTTI.dyn_cast_RecordExpansion(Exp.get());
        if ((RExp != null)) {
          Address This = LV.getAddress();
          //for (type$ptr</*const*/ CXXBaseSpecifier /*P*/ > BS : RExp.Bases) {
          for (type$ptr</*const*/ CXXBaseSpecifier /*P*/ > BS = RExp.Bases.begin(); BS.$noteq(RExp.Bases.end()); BS.$postInc()) {
            // Perform a single step derived-to-base conversion.
            Address Base = $this().GetAddressOfBaseClass(new Address(This), Ty.$arrow().getAsCXXRecordDecl(), /*AddrOf*/BS, /*AddrOf*/BS.$add(1), 
                /*NullCheckValue=*/ false, new SourceLocation());
            LValue SubLV = $this().MakeAddrLValue(new Address(Base), BS.$star().getType());
            
            // Recurse onto bases.
            $this().ExpandTypeFromArgs(BS.$star().getType(), new LValue(SubLV), AI);
          }
          for (/*const*/ FieldDecl /*P*/ FD : RExp.Fields) {
            // FIXME: What are the right qualifiers here?
            LValue SubLV = $this().EmitLValueForFieldInitialization(new LValue(LV), FD);
            $this().ExpandTypeFromArgs(FD.getType(), new LValue(SubLV), AI);
          }
        } else if (CodegenRTTI.isa_ComplexExpansion(Exp.get())) {
          Value /*P*/ realValue = AI.$postInc().$star();
          Value /*P*/ imagValue = AI.$postInc().$star();
          $this().EmitStoreOfComplex(new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, realValue, imagValue), new LValue(LV), /*init*/ true);
        } else {
          assert (CodegenRTTI.isa_NoExpansion(Exp.get()));
          $this().EmitStoreThroughLValue(RValue.get(AI.$postInc().$star()), new LValue(LV));
        }
      }
    }
  } finally {
    if (Exp != null) { Exp.$destroy(); }
  }
}


/// ExpandTypeToArgs - Expand an RValue \arg RV, with the LLVM type for \arg
/// Ty, into individual arguments on the provided vector \arg IRCallArgs,
/// starting at index \arg IRCallArgPos. See ABIArgInfo::Expand.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ExpandTypeToArgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 985,
 FQN="clang::CodeGen::CodeGenFunction::ExpandTypeToArgs", NM="_ZN5clang7CodeGen15CodeGenFunction16ExpandTypeToArgsENS_8QualTypeENS0_6RValueEPN4llvm12FunctionTypeERNS4_15SmallVectorImplIPNS4_5ValueEEERj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16ExpandTypeToArgsENS_8QualTypeENS0_6RValueEPN4llvm12FunctionTypeERNS4_15SmallVectorImplIPNS4_5ValueEEERj")
//</editor-fold>
protected/*private*/ final void ExpandTypeToArgs(QualType Ty, RValue RV, org.llvm.ir.FunctionType /*P*/ IRFuncTy, 
                final SmallVectorImpl<Value /*P*/ > /*&*/ IRCallArgs, final uint$ref/*uint &*/ IRCallArgPos) {
  unique_ptr<TypeExpansion> Exp = null;
  try {
    Exp = CGCallStatics.getTypeExpansion(new QualType(Ty), $this().getContext());
    {
      ConstantArrayExpansion /*P*/ CAExp = CodegenRTTI.dyn_cast_ConstantArrayExpansion(Exp.get());
      if ((CAExp != null)) {
        CGCallStatics.forConstantArrayExpansion(/*Deref*/$this(), CAExp, RV.getAggregateAddress(), 
            /*FuncArg*//*[&, this, &CAExp, &IRFuncTy, &IRCallArgs, &IRCallArgPos]*/ (Address EltAddr) -> {
                  RValue EltRV = $this().convertTempToRValue(new Address(EltAddr), new QualType(CAExp.EltTy), new SourceLocation());
                  $this().ExpandTypeToArgs(new QualType(CAExp.EltTy), new RValue(EltRV), IRFuncTy, IRCallArgs, IRCallArgPos);
                });
      } else {
        RecordExpansion /*P*/ RExp = CodegenRTTI.dyn_cast_RecordExpansion(Exp.get());
        if ((RExp != null)) {
          Address This = RV.getAggregateAddress();
          //for (type$ptr</*const*/ CXXBaseSpecifier /*P*/ > BS : RExp.Bases) {
          for (type$ptr</*const*/ CXXBaseSpecifier /*P*/ > BS = RExp.Bases.begin(); BS.$noteq(RExp.Bases.end()); BS.$postInc()) {
            // Perform a single step derived-to-base conversion.
            Address Base = $this().GetAddressOfBaseClass(new Address(This), Ty.$arrow().getAsCXXRecordDecl(), /*AddrOf*/BS, /*AddrOf*/BS.$add(1), 
                /*NullCheckValue=*/ false, new SourceLocation());
            RValue BaseRV = RValue.getAggregate(new Address(Base));
            
            // Recurse onto bases.
            $this().ExpandTypeToArgs(BS.$star().getType(), new RValue(BaseRV), IRFuncTy, IRCallArgs, 
                IRCallArgPos);
          }
          
          LValue LV = $this().MakeAddrLValue(new Address(This), new QualType(Ty));
          for (/*const*/ FieldDecl /*P*/ FD : RExp.Fields) {
            RValue FldRV = $this().EmitRValueForField(new LValue(LV), FD, new SourceLocation());
            $this().ExpandTypeToArgs(FD.getType(), new RValue(FldRV), IRFuncTy, IRCallArgs, 
                IRCallArgPos);
          }
        } else if (CodegenRTTI.isa_ComplexExpansion(Exp.get())) {
          std.pair<Value /*P*/ , Value /*P*/ > CV = RV.getComplexVal();
          IRCallArgs.$set(IRCallArgPos.$set$postInc(), CV.first);
          IRCallArgs.$set(IRCallArgPos.$set$postInc(), CV.second);
        } else {
          assert (CodegenRTTI.isa_NoExpansion(Exp.get()));
          assert (RV.isScalar()) : "Unexpected non-scalar rvalue during struct expansion.";
          
          // Insert a bitcast as needed.
          Value /*P*/ V = RV.getScalarVal();
          if ($less_uint(IRCallArgPos.$deref(), IRFuncTy.getNumParams())
             && V.getType() != IRFuncTy.getParamType(IRCallArgPos.$deref())) {
            V = $this().Builder.CreateBitCast(V, IRFuncTy.getParamType(IRCallArgPos.$deref()));
          }
          
          IRCallArgs.$set(IRCallArgPos.$set$postInc(), V);
        }
      }
    }
  } finally {
    if (Exp != null) { Exp.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCallArgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3173,
 FQN="clang::CodeGen::CodeGenFunction::EmitCallArgs", NM="_ZN5clang7CodeGen15CodeGenFunction12EmitCallArgsERNS0_11CallArgListEN4llvm8ArrayRefINS_8QualTypeEEENS4_14iterator_rangeINS_4Stmt17ConstExprIteratorEEEPKNS_12FunctionDeclEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12EmitCallArgsERNS0_11CallArgListEN4llvm8ArrayRefINS_8QualTypeEEENS4_14iterator_rangeINS_4Stmt17ConstExprIteratorEEEPKNS_12FunctionDeclEj")
//</editor-fold>
public final void EmitCallArgs1(final CallArgList /*&*/ Args, ArrayRef<QualType> ArgTypes, 
             iterator_range</*const*/ Expr /*P*/ /*const*/> ArgRange) {
  EmitCallArgs1(Args, ArgTypes, 
             ArgRange, 
             (/*const*/ FunctionDecl /*P*/ )null, 0);
}
public final void EmitCallArgs1(final CallArgList /*&*/ Args, ArrayRef<QualType> ArgTypes, 
             iterator_range</*const*/ Expr /*P*/ /*const*/> ArgRange, 
             /*const*/ FunctionDecl /*P*/ CalleeDecl/*= null*/) {
  EmitCallArgs1(Args, ArgTypes, 
             ArgRange, 
             CalleeDecl, 0);
}
public final void EmitCallArgs1(final CallArgList /*&*/ Args, ArrayRef<QualType> ArgTypes, 
             iterator_range</*const*/ Expr /*P*/ /*const*/> ArgRange, 
             /*const*/ FunctionDecl /*P*/ CalleeDecl/*= null*/, /*uint*/int ParamsToSkip/*= 0*/) {
  assert ((int)ArgTypes.size() == (((Stmt.ConstExprIterator)ArgRange.end()).$sub(((Stmt.ConstExprIterator)ArgRange.begin()))));
  
  UIntExpr2Void MaybeEmitImplicitObjectSize = /*[&, &CalleeDecl, this, &Args]*/ (/*uint*/int I, /*const*/ Expr /*P*/ Arg) -> {
        if (CalleeDecl == null || $greatereq_uint(I, CalleeDecl.getNumParams())) {
          return;
        }
        PassObjectSizeAttr /*P*/ PS = CalleeDecl.getParamDecl$Const(I).getAttr(PassObjectSizeAttr.class);
        if (PS == null) {
          return;
        }
        
        final /*const*/ ASTContext /*&*/ Context = $this().getContext();
        CanQual<org.clang.ast.Type> SizeTy = Context.getSizeType();
        IntegerType /*P*/ T = $this().Builder.getIntNTy($ulong2uint(Context.getTypeSize(SizeTy.$QualType())));
        Value /*P*/ V = $this().evaluateOrEmitBuiltinObjectSize(Arg, PS.getType(), T);
        Args.add(RValue.get(V), SizeTy.$QualType());
      };
  
  // We *have* to evaluate arguments from right to left in the MS C++ ABI,
  // because arguments are destroyed left to right in the callee.
  if ($this().CGM.getTarget().getCXXABI().areArgsDestroyedLeftToRightInCallee()) {
    // Insert a stack save if we're going to need any inalloca args.
    boolean HasInAllocaArgs = false;
    for (type$ptr<QualType> I = $tryClone(ArgTypes.begin()), /*P*/ E = $tryClone(ArgTypes.end());
         $noteq_ptr(I, E) && !HasInAllocaArgs; I.$preInc())  {
      HasInAllocaArgs = CGCallStatics.isInAllocaArgument($this().CGM.getCXXABI(), new QualType(I.$star()));
    }
    if (HasInAllocaArgs) {
      assert ($this().getTarget().getTriple().getArch() == Triple.ArchType.x86);
      Args.allocateArgumentMemory(/*Deref*/$this());
    }
    
    // Evaluate each argument.
    /*size_t*/int CallArgsStart = Args.size();
    for (int I = ArgTypes.size() - 1; I >= 0; --I) {
      Stmt.ConstExprIterator Arg = ((Stmt.ConstExprIterator)ArgRange.begin()).$add(I);
      MaybeEmitImplicitObjectSize.$call(I, Arg.$star());
      $this().EmitCallArg(Args, Arg.$star(), new QualType(ArgTypes.$at(I)));
      $this().EmitNonNullArgCheck(new RValue(Args.back().RV), new QualType(ArgTypes.$at(I)), (Arg.$star()).getExprLoc(), 
          CalleeDecl, ParamsToSkip + I);
    }
    
    // Un-reverse the arguments we just evaluated so they match up with the LLVM
    // IR function.
    std.reverse(Args.begin().$add(CallArgsStart), Args.end());
    return;
  }
  
  for (/*uint*/int I = 0, E = ArgTypes.size(); I != E; ++I) {
    Stmt.ConstExprIterator Arg = ((Stmt.ConstExprIterator)ArgRange.begin()).$add(I);
    assert (Arg.$noteq(((Stmt.ConstExprIterator)ArgRange.end())));
    $this().EmitCallArg(Args, Arg.$star(), new QualType(ArgTypes.$at(I)));
    $this().EmitNonNullArgCheck(new RValue(Args.back().RV), new QualType(ArgTypes.$at(I)), (Arg.$star()).getExprLoc(), 
        CalleeDecl, ParamsToSkip + I);
    MaybeEmitImplicitObjectSize.$call(I, Arg.$star());
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getVarArgType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3340,
 FQN="clang::CodeGen::CodeGenFunction::getVarArgType", NM="_ZN5clang7CodeGen15CodeGenFunction13getVarArgTypeEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13getVarArgTypeEPKNS_4ExprE")
//</editor-fold>
protected/*private*/ final QualType getVarArgType(/*const*/ Expr /*P*/ Arg) {
  // System headers on Windows define NULL to 0 instead of 0LL on Win64. MSVC
  // implicitly widens null pointer constants that are arguments to varargs
  // functions to pointer-sized ints.
  if (!$this().getTarget().getTriple().isOSWindows()) {
    return Arg.getType();
  }
  if (Arg.getType().$arrow().isIntegerType()
     && $less_ulong($this().getContext().getTypeSize(Arg.getType())
    , $this().getContext().getTargetInfo().getPointerWidth(0))
     && (Arg.isNullPointerConstant($this().getContext(), 
      Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNotNull).getValue() != 0)) {
    return $this().getContext().getIntPtrType();
  }
  
  return Arg.getType();
}


// In ObjC ARC mode with no ObjC ARC exception safety, tell the ARC
// optimizer it can aggressively ignore unwind edges.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::AddObjCARCExceptionMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3360,
 FQN="clang::CodeGen::CodeGenFunction::AddObjCARCExceptionMetadata", NM="_ZN5clang7CodeGen15CodeGenFunction27AddObjCARCExceptionMetadataEPN4llvm11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction27AddObjCARCExceptionMetadataEPN4llvm11InstructionE")
//</editor-fold>
protected/*private*/ final void AddObjCARCExceptionMetadata(Instruction /*P*/ Inst) {
  if ($2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) != 0
     && !$this().CGM.getCodeGenOpts().ObjCAutoRefCountExceptions) {
    Inst.setMetadata(new StringRef(/*KEEP_STR*/"clang.arc.no_objc_arc_exceptions"), 
        $this().CGM.getNoObjCARCExceptionsMetadata());
  }
}

} // END OF class CodeGenFunction_CGCall
