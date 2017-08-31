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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.gen.AttributesCompatFuncStatics;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.ir.legacy.FunctionPassManager;
import org.llvm.llvmc.CoreGlobals.*;
import org.llvm.llvmc.java.LlvmCFunctionPointers.*;
import static org.llvm.support.AdtsupportLlvmGlobals.llvm_is_multithreaded;
import org.llvm.support.sys.fs;


//<editor-fold defaultstate="collapsed" desc="static type CoreStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.CoreStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z10LLVMIsNull;_Z10LLVMMDNode;_Z10LLVMSizeOf;_Z10LLVMTypeOf;_Z11LLVMAddCase;_Z11LLVMAlignOf;_Z11LLVMBuildBr;_Z11LLVMBuildOr;_Z11LLVMConstOr;_Z11LLVMGetUser;_Z11LLVMIntType;_Z11LLVMIsAUser;_Z11LLVMIsUndef;_Z12LLVMAddAlias;_Z12LLVMBuildAdd;_Z12LLVMBuildAnd;_Z12LLVMBuildGEP;_Z12LLVMBuildMul;_Z12LLVMBuildNeg;_Z12LLVMBuildNot;_Z12LLVMBuildPhi;_Z12LLVMBuildRet;_Z12LLVMBuildShl;_Z12LLVMBuildSub;_Z12LLVMBuildXor;_Z12LLVMConstAdd;_Z12LLVMConstAnd;_Z12LLVMConstGEP;_Z12LLVMConstInt;_Z12LLVMConstMul;_Z12LLVMConstNeg;_Z12LLVMConstNot;_Z12LLVMConstShl;_Z12LLVMConstSub;_Z12LLVMConstXor;_Z12LLVMDumpType;_Z12LLVMGetParam;_Z12LLVMGetUndef;_Z12LLVMHalfType;_Z12LLVMInt1Type;_Z12LLVMInt8Type;_Z12LLVMMDString;_Z12LLVMShutdown;_Z12LLVMVoidType;_Z13LLVMAddClause;_Z13LLVMAddGlobal;_Z13LLVMArrayType;_Z13LLVMBuildAShr;_Z13LLVMBuildCall;_Z13LLVMBuildCast;_Z13LLVMBuildFAdd;_Z13LLVMBuildFCmp;_Z13LLVMBuildFDiv;_Z13LLVMBuildFMul;_Z13LLVMBuildFNeg;_Z13LLVMBuildFRem;_Z13LLVMBuildFSub;_Z13LLVMBuildFree;_Z13LLVMBuildICmp;_Z13LLVMBuildLShr;_Z13LLVMBuildLoad;_Z13LLVMBuildSDiv;_Z13LLVMBuildSExt;_Z13LLVMBuildSRem;_Z13LLVMBuildUDiv;_Z13LLVMBuildURem;_Z13LLVMBuildZExt;_Z13LLVMConstAShr;_Z13LLVMConstFAdd;_Z13LLVMConstFCmp;_Z13LLVMConstFDiv;_Z13LLVMConstFMul;_Z13LLVMConstFNeg;_Z13LLVMConstFRem;_Z13LLVMConstFSub;_Z13LLVMConstICmp;_Z13LLVMConstLShr;_Z13LLVMConstNull;_Z13LLVMConstReal;_Z13LLVMConstSDiv;_Z13LLVMConstSExt;_Z13LLVMConstSRem;_Z13LLVMConstUDiv;_Z13LLVMConstURem;_Z13LLVMConstZExt;_Z13LLVMDumpValue;_Z13LLVMFP128Type;_Z13LLVMFloatType;_Z13LLVMGetClause;_Z13LLVMGetParams;_Z13LLVMGetTarget;_Z13LLVMInt16Type;_Z13LLVMInt32Type;_Z13LLVMInt64Type;_Z13LLVMIsAMDNode;_Z13LLVMIsCleanup;_Z13LLVMLabelType;_Z13LLVMSetTarget;_Z14LLVMBuildBinOp;_Z14LLVMBuildFPExt;_Z14LLVMBuildFence;_Z14LLVMBuildStore;_Z14LLVMBuildTrunc;_Z14LLVMBuildVAArg;_Z14LLVMConstArray;_Z14LLVMConstFPExt;_Z14LLVMConstTrunc;_Z14LLVMDoubleType;_Z14LLVMDumpModule;_Z14LLVMGetIndices;_Z14LLVMGetLinkage;_Z14LLVMGetNextUse;_Z14LLVMGetOperand;_Z14LLVMGetSection;_Z14LLVMInt128Type;_Z14LLVMIsACmpInst;_Z14LLVMIsAPHINode;_Z14LLVMIsConstant;_Z14LLVMIsInBounds;_Z14LLVMIsTailCall;_Z14LLVMSetCleanup;_Z14LLVMSetLinkage;_Z14LLVMSetOperand;_Z14LLVMSetSection;_Z14LLVMStructType;_Z14LLVMVectorType;_Z14LLVMX86MMXType;_Z15LLVMAddFunction;_Z15LLVMAddIncoming;_Z15LLVMBuildAlloca;_Z15LLVMBuildCondBr;_Z15LLVMBuildFPCast;_Z15LLVMBuildFPToSI;_Z15LLVMBuildFPToUI;_Z15LLVMBuildInvoke;_Z15LLVMBuildIsNull;_Z15LLVMBuildMalloc;_Z15LLVMBuildNSWAdd;_Z15LLVMBuildNSWMul;_Z15LLVMBuildNSWNeg;_Z15LLVMBuildNSWSub;_Z15LLVMBuildNUWAdd;_Z15LLVMBuildNUWMul;_Z15LLVMBuildNUWNeg;_Z15LLVMBuildNUWSub;_Z15LLVMBuildResume;_Z15LLVMBuildSIToFP;_Z15LLVMBuildSelect;_Z15LLVMBuildSwitch;_Z15LLVMBuildUIToFP;_Z15LLVMConstFPCast;_Z15LLVMConstFPToSI;_Z15LLVMConstFPToUI;_Z15LLVMConstNSWAdd;_Z15LLVMConstNSWMul;_Z15LLVMConstNSWNeg;_Z15LLVMConstNSWSub;_Z15LLVMConstNUWAdd;_Z15LLVMConstNUWMul;_Z15LLVMConstNUWNeg;_Z15LLVMConstNUWSub;_Z15LLVMConstSIToFP;_Z15LLVMConstSelect;_Z15LLVMConstString;_Z15LLVMConstStruct;_Z15LLVMConstUIToFP;_Z15LLVMConstVector;_Z15LLVMCountParams;_Z15LLVMGetAsString;_Z15LLVMGetFirstUse;_Z15LLVMGetMDKindID;_Z15LLVMGetMDString;_Z15LLVMGetMetadata;_Z15LLVMGetOrdering;_Z15LLVMGetTypeKind;_Z15LLVMGetVolatile;_Z15LLVMHasMetadata;_Z15LLVMIsAArgument;_Z15LLVMIsACallInst;_Z15LLVMIsACastInst;_Z15LLVMIsAConstant;_Z15LLVMIsAFCmpInst;_Z15LLVMIsAFunction;_Z15LLVMIsAICmpInst;_Z15LLVMIsALoadInst;_Z15LLVMIsAMDString;_Z15LLVMIsASExtInst;_Z15LLVMIsAZExtInst;_Z15LLVMPointerType;_Z15LLVMSetMetadata;_Z15LLVMSetOrdering;_Z15LLVMSetTailCall;_Z15LLVMSetVolatile;_Z15LLVMTypeIsSized;_Z15LLVMX86FP80Type;_Z16LLVMAddAttribute;_Z16LLVMBlockAddress;_Z16LLVMBuildBitCast;_Z16LLVMBuildFPTrunc;_Z16LLVMBuildIntCast;_Z16LLVMBuildPtrDiff;_Z16LLVMBuildRetVoid;_Z16LLVMConstAllOnes;_Z16LLVMConstBitCast;_Z16LLVMConstFPTrunc;_Z16LLVMConstIntCast;_Z16LLVMDeleteGlobal;_Z16LLVMFunctionType;_Z16LLVMGetAlignment;_Z16LLVMGetAttribute;_Z16LLVMGetCondition;_Z16LLVMGetLastParam;_Z16LLVMGetNextParam;_Z16LLVMGetSuccessor;_Z16LLVMGetUsedValue;_Z16LLVMGetValueKind;_Z16LLVMGetValueName;_Z16LLVMIsAFPExtInst;_Z16LLVMIsAInlineAsm;_Z16LLVMIsAStoreInst;_Z16LLVMIsATruncInst;_Z16LLVMIsAVAArgInst;_Z16LLVMPPCFP128Type;_Z16LLVMSetAlignment;_Z16LLVMSetCondition;_Z16LLVMSetSuccessor;_Z16LLVMSetValueName;_Z17LLVMBuildIntToPtr;_Z17LLVMBuildPtrToInt;_Z17LLVMConstIntToPtr;_Z17LLVMConstPtrToInt;_Z17LLVMContextCreate;_Z17LLVMCountIncoming;_Z17LLVMCreateBuilder;_Z17LLVMCreateMessage;_Z17LLVMDisposeModule;_Z17LLVMGetBufferSize;_Z17LLVMGetDataLayout;_Z17LLVMGetFirstParam;_Z17LLVMGetLastGlobal;_Z17LLVMGetNextGlobal;_Z17LLVMGetNormalDest;_Z17LLVMGetNumClauses;_Z17LLVMGetNumIndices;_Z17LLVMGetOperandUse;_Z17LLVMGetParamTypes;_Z17LLVMGetReturnType;_Z17LLVMGetStructName;_Z17LLVMGetTypeByName;_Z17LLVMGetUnwindDest;_Z17LLVMGetVectorSize;_Z17LLVMGetVisibility;_Z17LLVMIsAAllocaInst;_Z17LLVMIsABasicBlock;_Z17LLVMIsABranchInst;_Z17LLVMIsAConstantFP;_Z17LLVMIsAFPToSIInst;_Z17LLVMIsAFPToUIInst;_Z17LLVMIsAInvokeInst;_Z17LLVMIsAMemCpyInst;_Z17LLVMIsAMemSetInst;_Z17LLVMIsAResumeInst;_Z17LLVMIsAReturnInst;_Z17LLVMIsASIToFPInst;_Z17LLVMIsASelectInst;_Z17LLVMIsASwitchInst;_Z17LLVMIsAUIToFPInst;_Z17LLVMIsAUndefValue;_Z17LLVMIsConditional;_Z17LLVMIsDeclaration;_Z17LLVMIsThreadLocal;_Z17LLVMSetDataLayout;_Z17LLVMSetIsInBounds;_Z17LLVMSetNormalDest;_Z17LLVMSetUnwindDest;_Z17LLVMSetVisibility;_Z17LLVMStructSetBody;_Z18LLVMAddDestination;_Z18LLVMBuildAtomicRMW;_Z18LLVMBuildExactSDiv;_Z18LLVMBuildIsNotNull;_Z18LLVMBuildStructGEP;_Z18LLVMConstExactSDiv;_Z18LLVMConstInlineAsm;_Z18LLVMContextDispose;_Z18LLVMDeleteFunction;_Z18LLVMDisposeBuilder;_Z18LLVMDisposeMessage;_Z18LLVMGetArrayLength;_Z18LLVMGetBasicBlocks;_Z18LLVMGetBufferStart;_Z18LLVMGetCalledValue;_Z18LLVMGetConstOpcode;_Z18LLVMGetElementType;_Z18LLVMGetFirstGlobal;_Z18LLVMGetInitializer;_Z18LLVMGetInsertBlock;_Z18LLVMGetIntrinsicID;_Z18LLVMGetNamedGlobal;_Z18LLVMGetNumOperands;_Z18LLVMGetParamParent;_Z18LLVMGetTypeContext;_Z18LLVMHasUnnamedAddr;_Z18LLVMInitializeCore;_Z18LLVMIsABitCastInst;_Z18LLVMIsAConstantInt;_Z18LLVMIsAFPTruncInst;_Z18LLVMIsAGlobalAlias;_Z18LLVMIsAGlobalValue;_Z18LLVMIsAInstruction;_Z18LLVMIsAMemMoveInst;_Z18LLVMIsOpaqueStruct;_Z18LLVMIsPackedStruct;_Z18LLVMRunPassManager;_Z18LLVMSetInitializer;_Z18LLVMSetThreadLocal;_Z18LLVMSetUnnamedAddr;_Z19LLVMAddFunctionAttr;_Z19LLVMBuildIndirectBr;_Z19LLVMBuildLandingPad;_Z19LLVMCountParamTypes;_Z19LLVMGetFunctionAttr;_Z19LLVMGetGlobalParent;_Z19LLVMGetIntTypeWidth;_Z19LLVMGetLastFunction;_Z19LLVMGetNextFunction;_Z19LLVMIsABlockAddress;_Z19LLVMIsACatchPadInst;_Z19LLVMIsAConstantExpr;_Z19LLVMIsAGlobalObject;_Z19LLVMIsAIntToPtrInst;_Z19LLVMIsAMemIntrinsic;_Z19LLVMIsAPtrToIntInst;_Z19LLVMIsEnumAttribute;_Z19LLVMIsMultithreaded;_Z19LLVMMDNodeInContext;_Z19LLVMPositionBuilder;_Z19LLVMRemoveAttribute;_Z20LLVMAppendBasicBlock;_Z20LLVMBuildArrayAlloca;_Z20LLVMBuildArrayMalloc;_Z20LLVMBuildInBoundsGEP;_Z20LLVMBuildInsertValue;_Z20LLVMBuildPointerCast;_Z20LLVMBuildUnreachable;_Z20LLVMConstInBoundsGEP;_Z20LLVMConstInsertValue;_Z20LLVMConstIntOfString;_Z20LLVMConstNamedStruct;_Z20LLVMConstPointerCast;_Z20LLVMConstPointerNull;_Z20LLVMCountBasicBlocks;_Z20LLVMDeleteBasicBlock;_Z20LLVMGetAllocatedType;_Z20LLVMGetDataLayoutStr;_Z20LLVMGetFCmpPredicate;_Z20LLVMGetFirstFunction;_Z20LLVMGetGlobalContext;_Z20LLVMGetICmpPredicate;_Z20LLVMGetIncomingBlock;_Z20LLVMGetIncomingValue;_Z20LLVMGetModuleContext;_Z20LLVMGetNamedFunction;_Z20LLVMGetNumSuccessors;_Z20LLVMGetPersonalityFn;_Z20LLVMGetPreviousParam;_Z20LLVMHasPersonalityFn;_Z20LLVMInsertBasicBlock;_Z20LLVMInstructionClone;_Z20LLVMIntTypeInContext;_Z20LLVMIsAConstantArray;_Z20LLVMIsAIntrinsicInst;_Z20LLVMIsConstantString;_Z20LLVMIsFunctionVarArg;_Z20LLVMIsGlobalConstant;_Z20LLVMSetPersonalityFn;_Z21LLVMAddInstrAttribute;_Z21LLVMBasicBlockAsValue;_Z21LLVMBuildAggregateRet;_Z21LLVMBuildExtractValue;_Z21LLVMBuildGlobalString;_Z21LLVMConstExtractValue;_Z21LLVMConstRealOfString;_Z21LLVMCreatePassManager;_Z21LLVMGetBasicBlockName;_Z21LLVMGetLastBasicBlock;_Z21LLVMGetMDNodeOperands;_Z21LLVMGetNextBasicBlock;_Z21LLVMGetNumArgOperands;_Z21LLVMGetPreviousGlobal;_Z21LLVMHalfTypeInContext;_Z21LLVMInsertIntoBuilder;_Z21LLVMInt1TypeInContext;_Z21LLVMInt8TypeInContext;_Z21LLVMIsABinaryOperator;_Z21LLVMIsACleanupPadInst;_Z21LLVMIsAConstantStruct;_Z21LLVMIsAConstantVector;_Z21LLVMIsADbgDeclareInst;_Z21LLVMIsAFuncletPadInst;_Z21LLVMIsAGlobalVariable;_Z21LLVMIsAIndirectBrInst;_Z21LLVMIsALandingPadInst;_Z21LLVMIsATerminatorInst;_Z21LLVMIsStringAttribute;_Z21LLVMMDStringInContext;_Z21LLVMPrintModuleToFile;_Z21LLVMPrintTypeToString;_Z21LLVMSetGlobalConstant;_Z21LLVMSetParamAlignment;_Z21LLVMStopMultithreaded;_Z21LLVMStructCreateNamed;_Z21LLVMValueAsBasicBlock;_Z21LLVMValueIsBasicBlock;_Z21LLVMVoidTypeInContext;_Z22LLVMBuildAddrSpaceCast;_Z22LLVMBuildAtomicCmpXchg;_Z22LLVMBuildInsertElement;_Z22LLVMBuildSExtOrBitCast;_Z22LLVMBuildShuffleVector;_Z22LLVMBuildZExtOrBitCast;_Z22LLVMConstAddrSpaceCast;_Z22LLVMConstInsertElement;_Z22LLVMConstRealGetDouble;_Z22LLVMConstSExtOrBitCast;_Z22LLVMConstShuffleVector;_Z22LLVMConstZExtOrBitCast;_Z22LLVMDisposePassManager;_Z22LLVMFP128TypeInContext;_Z22LLVMFloatTypeInContext;_Z22LLVMGetDLLStorageClass;_Z22LLVMGetEntryBasicBlock;_Z22LLVMGetFirstBasicBlock;_Z22LLVMGetLastInstruction;_Z22LLVMGetNextInstruction;_Z22LLVMGetThreadLocalMode;_Z22LLVMInt16TypeInContext;_Z22LLVMInt32TypeInContext;_Z22LLVMInt64TypeInContext;_Z22LLVMIsACatchReturnInst;_Z22LLVMIsAInsertValueInst;_Z22LLVMIsAUnreachableInst;_Z22LLVMLabelTypeInContext;_Z22LLVMPrintValueToString;_Z22LLVMRemoveFunctionAttr;_Z22LLVMReplaceAllUsesWith;_Z22LLVMSetDLLStorageClass;_Z22LLVMSetModuleInlineAsm;_Z22LLVMSetThreadLocalMode;_Z22LLVMStartMultithreaded;_Z22LLVMTokenTypeInContextP17LLVMOpaqueContext;_Z23LLVMAddAttributeAtIndex;_Z23LLVMBuildExtractElement;_Z23LLVMBuildTruncOrBitCast;_Z23LLVMConstExtractElement;_Z23LLVMConstTruncOrBitCast;_Z23LLVMCreateEnumAttribute;_Z23LLVMDisposeMemoryBuffer;_Z23LLVMDoubleTypeInContext;_Z23LLVMGetBasicBlockParent;_Z23LLVMGetDiagInfoSeverity;_Z23LLVMGetFirstInstruction;_Z23LLVMGetFunctionCallConv;_Z23LLVMGetModuleIdentifier;_Z23LLVMGetPreviousFunction;_Z23LLVMInt128TypeInContext;_Z23LLVMIsADbgInfoIntrinsic;_Z23LLVMIsAExtractValueInst;_Z23LLVMIsAUnaryInstruction;_Z23LLVMMoveBasicBlockAfter;_Z23LLVMPrintModuleToString;_Z23LLVMSetFunctionCallConv;_Z23LLVMSetModuleIdentifier;_Z23LLVMStructTypeInContext;_Z23LLVMX86MMXTypeInContext;_Z24LLVMAddCallSiteAttribute;_Z24LLVMBuildGlobalStringPtr;_Z24LLVMConstIntGetSExtValue;_Z24LLVMConstIntGetZExtValue;_Z24LLVMConstStringInContext;_Z24LLVMConstStructInContext;_Z24LLVMGetAttributesAtIndex;_Z24LLVMGetElementAsConstant;_Z24LLVMGetEnumAttributeKind;_Z24LLVMGetInstructionOpcode;_Z24LLVMGetInstructionParent;_Z24LLVMGetMDKindIDInContext;_Z24LLVMGetMDNodeNumOperands;_Z24LLVMGetSwitchDefaultDest;_Z24LLVMIsAAddrSpaceCastInst;_Z24LLVMIsACleanupReturnInst;_Z24LLVMIsAConstantDataArray;_Z24LLVMIsAConstantTokenNone;_Z24LLVMIsAGetElementPtrInst;_Z24LLVMIsAInsertElementInst;_Z24LLVMIsAShuffleVectorInst;_Z24LLVMIsAtomicSingleThread;_Z24LLVMModuleCreateWithName;_Z24LLVMMoveBasicBlockBefore;_Z24LLVMPositionBuilderAtEnd;_Z24LLVMRemoveInstrAttribute;_Z24LLVMSetInstDebugLocation;_Z24LLVMStructGetTypeAtIndex;_Z24LLVMX86FP80TypeInContext;_Z25LLVMCreateStringAttribute;_Z25LLVMDisposeModuleProvider;_Z25LLVMGetCallSiteAttributes;_Z25LLVMGetEnumAttributeValue;_Z25LLVMGetGlobalPassRegistry;_Z25LLVMGetPreviousBasicBlock;_Z25LLVMGetStructElementTypes;_Z25LLVMIsAConstantDataVector;_Z25LLVMIsAExtractElementInst;_Z25LLVMPPCFP128TypeInContext;_Z25LLVMPositionBuilderBefore;_Z25LLVMSetAtomicSingleThread;_Z26LLVMClearInsertionPosition;_Z26LLVMCreateBuilderInContext;_Z26LLVMGetDiagInfoDescription;_Z26LLVMGetInstructionCallConv;_Z26LLVMGetPointerAddressSpace;_Z26LLVMGetPreviousInstruction;_Z26LLVMGetStringAttributeKind;_Z26LLVMIsAConstantPointerNull;_Z26LLVMRunFunctionPassManager;_Z26LLVMSetInstrParamAlignment;_Z26LLVMSetInstructionCallConv;_Z27LLVMAddGlobalInAddressSpace;_Z27LLVMAddNamedMetadataOperand;_Z27LLVMConstIntOfStringAndSize;_Z27LLVMContextSetYieldCallback;_Z27LLVMCountStructElementTypes;_Z27LLVMGetBasicBlockTerminator;_Z27LLVMGetCurrentDebugLocation;_Z27LLVMGetEnumAttributeAtIndex;_Z27LLVMGetStringAttributeValue;_Z27LLVMIsExternallyInitialized;_Z27LLVMSetCurrentDebugLocation;_Z28LLVMConstRealOfStringAndSize;_Z28LLVMGetAttributeCountAtIndex;_Z28LLVMGetCallSiteEnumAttribute;_Z28LLVMGetLastEnumAttributeKind;_Z28LLVMGetNamedMetadataOperands;_Z28LLVMIsAConstantAggregateZero;_Z28LLVMSetExternallyInitialized;_Z29LLVMAppendBasicBlockInContext;_Z29LLVMCreateFunctionPassManager;_Z29LLVMGetCallSiteAttributeCount;_Z29LLVMGetCmpXchgFailureOrdering;_Z29LLVMGetCmpXchgSuccessOrdering;_Z29LLVMGetStringAttributeAtIndex;_Z29LLVMInsertBasicBlockInContext;_Z29LLVMInsertIntoBuilderWithName;_Z29LLVMIsAConstantDataSequential;_Z29LLVMSetCmpXchgFailureOrdering;_Z29LLVMSetCmpXchgSuccessOrdering;_Z30LLVMGetCallSiteStringAttribute;_Z30LLVMInstructionEraseFromParent;_Z30LLVMRemoveBasicBlockFromParent;_Z30LLVMRemoveEnumAttributeAtIndex;_Z31LLVMContextGetDiagnosticContext;_Z31LLVMContextGetDiagnosticHandler;_Z31LLVMContextSetDiagnosticHandler;_Z31LLVMCreateMemoryBufferWithSTDIN;_Z31LLVMFinalizeFunctionPassManager;_Z31LLVMGetEnumAttributeKindForName;_Z31LLVMGetNamedMetadataNumOperands;_Z31LLVMInstructionRemoveFromParent;_Z31LLVMRemoveCallSiteEnumAttribute;_Z32LLVMConstIntOfArbitraryPrecision;_Z32LLVMRemoveStringAttributeAtIndex;_Z33LLVMInitializeFunctionPassManager;_Z33LLVMModuleCreateWithNameInContext;_Z33LLVMRemoveCallSiteStringAttribute;_Z34LLVMAddTargetDependentFunctionAttr;_Z37LLVMCreateMemoryBufferWithMemoryRange;_Z38LLVMCreateFunctionPassManagerForModule;_Z40LLVMCreateMemoryBufferWithContentsOfFile;_Z41LLVMCreateMemoryBufferWithMemoryRangeCopy;_Z41LLVMCreateModuleProviderForExistingModule;_Z9LLVMGetGC;_Z9LLVMSetGC;_ZL13GlobalContext;_ZL13extractMDNodePN4llvm15MetadataAsValueE;_ZL17mapToLLVMOrderingN4llvm14AtomicOrderingE;_ZL17map_to_llvmopcodei;_ZL19mapFromLLVMOrdering18LLVMAtomicOrdering;_ZL19map_from_llvmopcode10LLVMOpcode;_ZL20getMDNodeOperandImplRN4llvm11LLVMContextEPKNS_6MDNodeEj; -static-type=CoreStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class CoreStatics {


/**
* @}
*/
//<editor-fold defaultstate="collapsed" desc="LLVMInitializeCore">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 57,
 FQN="LLVMInitializeCore", NM="_Z18LLVMInitializeCore",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMInitializeCore")
//</editor-fold>
public static void LLVMInitializeCore( LLVMOpaquePassRegistry /*P*/ R) {
  IrLlvmGlobals.initializeCore($Deref(IrLlvmGlobals.unwrap(R)));
}


/** Deallocate and destroy all ManagedStatic variables.
@see llvm::llvm_shutdown
@see ManagedStatic */
//<editor-fold defaultstate="collapsed" desc="LLVMShutdown">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 61,
 FQN="LLVMShutdown", NM="_Z12LLVMShutdown",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMShutdown")
//</editor-fold>
public static void LLVMShutdown() {
  llvm_shutdown();
}


/*===-- Error handling ----------------------------------------------------===*/

/*===-- Error handling ----------------------------------------------------===*/
//<editor-fold defaultstate="collapsed" desc="LLVMCreateMessage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 67,
 FQN="LLVMCreateMessage", NM="_Z17LLVMCreateMessage",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMCreateMessage")
//</editor-fold>
public static char$ptr/*char P*/ LLVMCreateMessage(/*const*/char$ptr/*char P*/ Message) {
  return strdup(Message);
}

//<editor-fold defaultstate="collapsed" desc="LLVMDisposeMessage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 71,
 FQN="LLVMDisposeMessage", NM="_Z18LLVMDisposeMessage",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMDisposeMessage")
//</editor-fold>
public static void LLVMDisposeMessage(char$ptr/*char P*/ Message) {
  free(Message);
}


/**
* Create a new context.
*
* Every call to this function should be paired with a call to
* LLVMContextDispose() or the context will leak memory.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMContextCreate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 80,
 FQN="LLVMContextCreate", NM="_Z17LLVMContextCreate",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMContextCreate")
//</editor-fold>
public static  LLVMOpaqueContext /*P*/ LLVMContextCreate() {
  return IrLlvmGlobals.wrap_LLVMContext$C$P(new LLVMContext());
}


/**
* Obtain the global context instance.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetGlobalContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 84,
 FQN="LLVMGetGlobalContext", NM="_Z20LLVMGetGlobalContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetGlobalContext")
//</editor-fold>
public static  LLVMOpaqueContext /*P*/ LLVMGetGlobalContext() {
  return IrLlvmGlobals.wrap_LLVMContext$C$P($AddrOf(GlobalContext.$star()));
}


/**
* Set the diagnostic handler for this context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMContextSetDiagnosticHandler">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 86,
 FQN="LLVMContextSetDiagnosticHandler", NM="_Z31LLVMContextSetDiagnosticHandler",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z31LLVMContextSetDiagnosticHandler")
//</editor-fold>
public static void LLVMContextSetDiagnosticHandler( LLVMOpaqueContext /*P*/ C, 
                               LLVMDiagnosticHandler Handler, 
                               Object/*void P*/ DiagnosticContext) {
  IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C).setDiagnosticHandler(reinterpret_cast(DiagnosticInfoHandler.class, Handler), 
      DiagnosticContext);
}


/**
* Get the diagnostic handler of this context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMContextGetDiagnosticHandler">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 95,
 FQN="LLVMContextGetDiagnosticHandler", NM="_Z31LLVMContextGetDiagnosticHandler",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z31LLVMContextGetDiagnosticHandler")
//</editor-fold>
public static LLVMDiagnosticHandler LLVMContextGetDiagnosticHandler( LLVMOpaqueContext /*P*/ C) {
  return reinterpret_cast(LLVMDiagnosticHandler.class, IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C).getDiagnosticHandler());
}


/**
* Get the diagnostic context of this context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMContextGetDiagnosticContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 100,
 FQN="LLVMContextGetDiagnosticContext", NM="_Z31LLVMContextGetDiagnosticContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z31LLVMContextGetDiagnosticContext")
//</editor-fold>
public static Object/*void P*/ LLVMContextGetDiagnosticContext( LLVMOpaqueContext /*P*/ C) {
  return IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C).getDiagnosticContext();
}


/**
* Set the yield callback function for this context.
*
* @see LLVMContext::setYieldCallback()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMContextSetYieldCallback">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 104,
 FQN="LLVMContextSetYieldCallback", NM="_Z27LLVMContextSetYieldCallback",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMContextSetYieldCallback")
//</editor-fold>
public static void LLVMContextSetYieldCallback( LLVMOpaqueContext /*P*/ C, LLVMYieldCallback Callback, 
                           Object/*void P*/ OpaqueHandle) {
  YieldCallbackTy YieldCallback = reinterpret_cast(YieldCallbackTy.class, Callback);
  IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C).setYieldCallback(YieldCallback, OpaqueHandle);
}


/**
* Destroy a context instance.
*
* This should be called for every call to LLVMContextCreate() or memory
* will be leaked.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMContextDispose">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 111,
 FQN="LLVMContextDispose", NM="_Z18LLVMContextDispose",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMContextDispose")
//</editor-fold>
public static void LLVMContextDispose( LLVMOpaqueContext /*P*/ C) {
  /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C));
}


/**
* Return a string representation of the DiagnosticInfo. Use
* LLVMDisposeMessage to free the string.
*
* @see DiagnosticInfo::print()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetDiagInfoDescription">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 181,
 FQN="LLVMGetDiagInfoDescription", NM="_Z26LLVMGetDiagInfoDescription",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMGetDiagInfoDescription")
//</editor-fold>
public static char$ptr/*char P*/ LLVMGetDiagInfoDescription( LLVMOpaqueDiagnosticInfo /*P*/ DI) {
  raw_string_ostream Stream = null;
  DiagnosticPrinterRawOStream DP = null;
  try {
    std.string MsgStorage/*J*/= new std.string();
    Stream/*J*/= new raw_string_ostream(MsgStorage);
    DP/*J*/= new DiagnosticPrinterRawOStream(Stream);
    
    IrLlvmGlobals.unwrap(DI).print(DP);
    Stream.flush();
    
    return LLVMCreateMessage(MsgStorage.c_str());
  } finally {
    if (DP != null) { DP.$destroy(); }
    if (Stream != null) { Stream.$destroy(); }
  }
}


/**
* Return an enum LLVMDiagnosticSeverity.
*
* @see DiagnosticInfo::getSeverity()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetDiagInfoSeverity">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 192,
 FQN="LLVMGetDiagInfoSeverity", NM="_Z23LLVMGetDiagInfoSeverity",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMGetDiagInfoSeverity")
//</editor-fold>
public static LLVMDiagnosticSeverity LLVMGetDiagInfoSeverity( LLVMOpaqueDiagnosticInfo /*P*/ DI) {
  LLVMDiagnosticSeverity severity;
  switch (IrLlvmGlobals.unwrap(DI).getSeverity()) {
   default:
    severity = LLVMDiagnosticSeverity.LLVMDSError;
    break;
   case DS_Warning:
    severity = LLVMDiagnosticSeverity.LLVMDSWarning;
    break;
   case DS_Remark:
    severity = LLVMDiagnosticSeverity.LLVMDSRemark;
    break;
   case DS_Note:
    severity = LLVMDiagnosticSeverity.LLVMDSNote;
    break;
  }
  
  return severity;
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetMDKindIDInContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 115,
 FQN="LLVMGetMDKindIDInContext", NM="_Z24LLVMGetMDKindIDInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMGetMDKindIDInContext")
//</editor-fold>
public static /*uint*/int LLVMGetMDKindIDInContext( LLVMOpaqueContext /*P*/ C, /*const*/char$ptr/*char P*/ Name, 
                        /*uint*/int SLen) {
  return IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C).getMDKindID(new StringRef(Name, SLen));
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetMDKindID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 120,
 FQN="LLVMGetMDKindID", NM="_Z15LLVMGetMDKindID",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMGetMDKindID")
//</editor-fold>
public static /*uint*/int LLVMGetMDKindID(/*const*/char$ptr/*char P*/ Name, /*uint*/int SLen) {
  return LLVMGetMDKindIDInContext(LLVMGetGlobalContext(), Name, SLen);
}


/**
* Return an unique id given the name of a enum attribute,
* or 0 if no attribute by that name exists.
*
* See http://llvm.org/docs/LangRef.html#parameter-attributes
* and http://llvm.org/docs/LangRef.html#function-attributes
* for the list of available attributes.
*
* NB: Attribute names and/or id are subject to change without
* going through the C API deprecation cycle.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetEnumAttributeKindForName">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 127,
 FQN="LLVMGetEnumAttributeKindForName", NM="_Z31LLVMGetEnumAttributeKindForName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z31LLVMGetEnumAttributeKindForName")
//</editor-fold>
public static /*uint*/int LLVMGetEnumAttributeKindForName(/*const*/char$ptr/*char P*/ Name, /*size_t*/int SLen) {
    return AttributesCompatFuncStatics.getAttrKindFromName(new StringRef(Name, SLen)).getValue();
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetLastEnumAttributeKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 131,
 FQN="LLVMGetLastEnumAttributeKind", NM="_Z28LLVMGetLastEnumAttributeKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z28LLVMGetLastEnumAttributeKind")
//</editor-fold>
public static /*uint*/int LLVMGetLastEnumAttributeKind() {
  return Attribute.AttrKind.EndAttrKinds.getValue();
}


/**
* Create an enum attribute.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMCreateEnumAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 135,
 FQN="LLVMCreateEnumAttribute", NM="_Z23LLVMCreateEnumAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMCreateEnumAttribute")
//</editor-fold>
public static  LLVMOpaqueAttributeRef /*P*/ LLVMCreateEnumAttribute( LLVMOpaqueContext /*P*/ C, /*uint*/int KindID, 
                       long/*uint64_t*/ Val) {
  return IrLlvmGlobals.wrap(Attribute.get($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)), Attribute.AttrKind.valueOf(KindID), Val));
}


/**
* Get the unique id corresponding to the enum attribute
* passed as argument.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetEnumAttributeKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 140,
 FQN="LLVMGetEnumAttributeKind", NM="_Z24LLVMGetEnumAttributeKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMGetEnumAttributeKind")
//</editor-fold>
public static /*uint*/int LLVMGetEnumAttributeKind( LLVMOpaqueAttributeRef /*P*/ A) {
  return IrLlvmGlobals.unwrap(A).getKindAsEnum().getValue();
}


/**
* Get the enum attribute's value. 0 is returned if none exists.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetEnumAttributeValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 144,
 FQN="LLVMGetEnumAttributeValue", NM="_Z25LLVMGetEnumAttributeValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMGetEnumAttributeValue")
//</editor-fold>
public static long/*uint64_t*/ LLVMGetEnumAttributeValue( LLVMOpaqueAttributeRef /*P*/ A) {
  Attribute Attr = IrLlvmGlobals.unwrap(A);
  if (Attr.isEnumAttribute()) {
    return $int2ulong(0);
  }
  return Attr.getValueAsInt();
}


/**
* Create a string attribute.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMCreateStringAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 151,
 FQN="LLVMCreateStringAttribute", NM="_Z25LLVMCreateStringAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMCreateStringAttribute")
//</editor-fold>
public static  LLVMOpaqueAttributeRef /*P*/ LLVMCreateStringAttribute( LLVMOpaqueContext /*P*/ C, 
                         /*const*/char$ptr/*char P*/ K, /*uint*/int KLength, 
                         /*const*/char$ptr/*char P*/ V, /*uint*/int VLength) {
  return IrLlvmGlobals.wrap(Attribute.get($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)), new StringRef(K, KLength), 
          new StringRef(V, VLength)));
}


/**
* Get the string attribute's kind.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetStringAttributeKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 158,
 FQN="LLVMGetStringAttributeKind", NM="_Z26LLVMGetStringAttributeKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMGetStringAttributeKind")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetStringAttributeKind( LLVMOpaqueAttributeRef /*P*/ A, 
                          uint$ptr/*uint P*/ Length) {
  StringRef S = IrLlvmGlobals.unwrap(A).getKindAsString();
  Length.$set(S.size());
  return S.data();
}


/**
* Get the string attribute's value.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetStringAttributeValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 165,
 FQN="LLVMGetStringAttributeValue", NM="_Z27LLVMGetStringAttributeValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMGetStringAttributeValue")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetStringAttributeValue( LLVMOpaqueAttributeRef /*P*/ A, 
                           uint$ptr/*uint P*/ Length) {
  StringRef S = IrLlvmGlobals.unwrap(A).getValueAsString();
  Length.$set(S.size());
  return S.data();
}


/**
* Check for the different types of attributes.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsEnumAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 172,
 FQN="LLVMIsEnumAttribute", NM="_Z19LLVMIsEnumAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMIsEnumAttribute")
//</editor-fold>
public static int LLVMIsEnumAttribute( LLVMOpaqueAttributeRef /*P*/ A) {
  Attribute Attr = IrLlvmGlobals.unwrap(A);
  return ((Attr.isEnumAttribute() || Attr.isIntAttribute()) ? 1 : 0);
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsStringAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 177,
 FQN="LLVMIsStringAttribute", NM="_Z21LLVMIsStringAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsStringAttribute")
//</editor-fold>
public static int LLVMIsStringAttribute( LLVMOpaqueAttributeRef /*P*/ A) {
  return (IrLlvmGlobals.unwrap(A).isStringAttribute() ? 1 : 0);
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreModule Modules
*
* Modules represent the top-level structure in an LLVM program. An LLVM
* module is effectively a translation unit or a collection of
* translation units merged together.
*
* @{
*/

/**
* Create a new, empty module in the global context.
*
* This is equivalent to calling LLVMModuleCreateWithNameInContext with
* LLVMGetGlobalContext() as the context parameter.
*
* Every invocation should be paired with LLVMDisposeModule() or memory
* will be leaked.
*/

/*===-- Operations on modules ---------------------------------------------===*/
//<editor-fold defaultstate="collapsed" desc="LLVMModuleCreateWithName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 215,
 FQN="LLVMModuleCreateWithName", NM="_Z24LLVMModuleCreateWithName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMModuleCreateWithName")
//</editor-fold>
public static  LLVMOpaqueModule /*P*/ LLVMModuleCreateWithName(/*const*/char$ptr/*char P*/ ModuleID) {
  return IrLlvmGlobals.wrap(new Module(new StringRef(ModuleID), GlobalContext.$star()));
}


/**
* Create a new, empty module in a specific context.
*
* Every invocation should be paired with LLVMDisposeModule() or memory
* will be leaked.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMModuleCreateWithNameInContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 219,
 FQN="LLVMModuleCreateWithNameInContext", NM="_Z33LLVMModuleCreateWithNameInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z33LLVMModuleCreateWithNameInContext")
//</editor-fold>
public static  LLVMOpaqueModule /*P*/ LLVMModuleCreateWithNameInContext(/*const*/char$ptr/*char P*/ ModuleID, 
                                  LLVMOpaqueContext /*P*/ C) {
  return IrLlvmGlobals.wrap(new Module(new StringRef(ModuleID), $Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C))));
}


/**
* Destroy a module instance.
*
* This must be called for every created module or memory will be
* leaked.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMDisposeModule">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 224,
 FQN="LLVMDisposeModule", NM="_Z17LLVMDisposeModule",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMDisposeModule")
//</editor-fold>
public static void LLVMDisposeModule( LLVMOpaqueModule /*P*/ M) {
  /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)IrLlvmGlobals.unwrap(M));
}


/**
* Obtain the identifier of a module.
*
* @param M Module to obtain identifier of
* @param Len Out parameter which holds the length of the returned string.
* @return The identifier of M.
* @see Module::getModuleIdentifier()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetModuleIdentifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 228,
 FQN="LLVMGetModuleIdentifier", NM="_Z23LLVMGetModuleIdentifier",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMGetModuleIdentifier")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetModuleIdentifier( LLVMOpaqueModule /*P*/ M, uint$ptr/*size_t P*/ Len) {
  final /*const*/std.string/*&*/ Str = IrLlvmGlobals.unwrap(M).getModuleIdentifier();
  Len.$set(Str.length());
  return Str.c_str();
}


/**
* Set the identifier of a module to a string Ident with length Len.
*
* @param M The module to set identifier
* @param Ident The string to set M's identifier to
* @param Len Length of Ident
* @see Module::setModuleIdentifier()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetModuleIdentifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 234,
 FQN="LLVMSetModuleIdentifier", NM="_Z23LLVMSetModuleIdentifier",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMSetModuleIdentifier")
//</editor-fold>
public static void LLVMSetModuleIdentifier( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Ident, /*size_t*/int Len) {
  IrLlvmGlobals.unwrap(M).setModuleIdentifier(new StringRef(Ident, Len));
}


/**
* Obtain the data layout for a module.
*
* @see Module::getDataLayoutStr()
*
* LLVMGetDataLayout is DEPRECATED, as the name is not only incorrect,
* but match the name of another method on the module. Prefer the use
* of LLVMGetDataLayoutStr, which is not ambiguous.
*/

/*--.. Data layout .........................................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetDataLayoutStr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 240,
 FQN="LLVMGetDataLayoutStr", NM="_Z20LLVMGetDataLayoutStr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetDataLayoutStr")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetDataLayoutStr( LLVMOpaqueModule /*P*/ M) {
  return IrLlvmGlobals.unwrap(M).getDataLayoutStr().c_str();
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetDataLayout">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 244,
 FQN="LLVMGetDataLayout", NM="_Z17LLVMGetDataLayout",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetDataLayout")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetDataLayout( LLVMOpaqueModule /*P*/ M) {
  return LLVMGetDataLayoutStr(M);
}


/**
* Set the data layout for a module.
*
* @see Module::setDataLayout()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetDataLayout">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 248,
 FQN="LLVMSetDataLayout", NM="_Z17LLVMSetDataLayout",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMSetDataLayout")
//</editor-fold>
public static void LLVMSetDataLayout( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ DataLayoutStr) {
  IrLlvmGlobals.unwrap(M).setDataLayout(new StringRef(DataLayoutStr));
}


/**
* Obtain the target triple for a module.
*
* @see Module::getTargetTriple()
*/

/*--.. Target triple .......................................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetTarget">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 253,
 FQN="LLVMGetTarget", NM="_Z13LLVMGetTarget",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMGetTarget")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetTarget( LLVMOpaqueModule /*P*/ M) {
  return IrLlvmGlobals.unwrap(M).getTargetTriple().c_str();
}


/**
* Set the target triple for a module.
*
* @see Module::setTargetTriple()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetTarget">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 257,
 FQN="LLVMSetTarget", NM="_Z13LLVMSetTarget",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMSetTarget")
//</editor-fold>
public static void LLVMSetTarget( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Triple) {
  IrLlvmGlobals.unwrap(M).setTargetTriple(new StringRef(Triple));
}


/**
* Dump a representation of a module to stderr.
*
* @see Module::dump()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMDumpModule">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 261,
 FQN="LLVMDumpModule", NM="_Z14LLVMDumpModule",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMDumpModule")
//</editor-fold>
public static void LLVMDumpModule( LLVMOpaqueModule /*P*/ M) {
  IrLlvmGlobals.unwrap(M).dump();
}


/**
* Print a representation of a module to a file. The ErrorMessage needs to be
* disposed with LLVMDisposeMessage. Returns 0 on success, 1 otherwise.
*
* @see Module::print()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMPrintModuleToFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 265,
 FQN="LLVMPrintModuleToFile", NM="_Z21LLVMPrintModuleToFile",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMPrintModuleToFile")
//</editor-fold>
public static int LLVMPrintModuleToFile( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Filename, 
                     type$ptr<char$ptr>/*char PP*/ ErrorMessage) {
  raw_fd_ostream dest = null;
  try {
    std.error_code EC/*J*/= new std.error_code();
    dest/*J*/= new raw_fd_ostream(new StringRef(Filename), EC, fs.OpenFlags.F_Text);
    if (EC.$bool()) {
      ErrorMessage.$set(strdup(EC.message().c_str()));
      return /*true*/1;
    }
    
    IrLlvmGlobals.unwrap(M).print(dest, (AssemblyAnnotationWriter /*P*/ )null);
    
    dest.close();
    if (dest.has_error()) {
      ErrorMessage.$set(strdup($("Error printing to file")));
      return /*true*/1;
    }
    
    return /*false*/0;
  } finally {
    if (dest != null) { dest.$destroy(); }
  }
}


/**
* Return a string representation of the module. Use
* LLVMDisposeMessage to free the string.
*
* @see Module::print()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMPrintModuleToString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 286,
 FQN="LLVMPrintModuleToString", NM="_Z23LLVMPrintModuleToString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMPrintModuleToString")
//</editor-fold>
public static char$ptr/*char P*/ LLVMPrintModuleToString( LLVMOpaqueModule /*P*/ M) {
  raw_string_ostream os = null;
  try {
    std.string buf/*J*/= new std.string();
    os/*J*/= new raw_string_ostream(buf);
    
    IrLlvmGlobals.unwrap(M).print(os, (AssemblyAnnotationWriter /*P*/ )null);
    os.flush();
    
    return strdup(buf.c_str());
  } finally {
    if (os != null) { os.$destroy(); }
  }
}


/**
* Set inline assembly for a module.
*
* @see Module::setModuleInlineAsm()
*/

/*--.. Operations on inline assembler ......................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetModuleInlineAsm">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 297,
 FQN="LLVMSetModuleInlineAsm", NM="_Z22LLVMSetModuleInlineAsm",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMSetModuleInlineAsm")
//</editor-fold>
public static void LLVMSetModuleInlineAsm( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Asm) {
  IrLlvmGlobals.unwrap(M).setModuleInlineAsm(new StringRef(Asm));
}


/**
* Obtain the context to which this module is associated.
*
* @see Module::getContext()
*/

/*--.. Operations on module contexts ......................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetModuleContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 303,
 FQN="LLVMGetModuleContext", NM="_Z20LLVMGetModuleContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetModuleContext")
//</editor-fold>
public static  LLVMOpaqueContext /*P*/ LLVMGetModuleContext( LLVMOpaqueModule /*P*/ M) {
  return IrLlvmGlobals.wrap_LLVMContext$C$P($AddrOf(IrLlvmGlobals.unwrap(M).getContext()));
}


/**
* Obtain a Type from a module by its registered name.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetTypeByName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 563,
 FQN="LLVMGetTypeByName", NM="_Z17LLVMGetTypeByName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetTypeByName")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMGetTypeByName( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Type$C$P(IrLlvmGlobals.unwrap(M).getTypeByName(new StringRef(Name)));
}


/**
* Obtain the number of operands for named metadata in a module.
*
* @see llvm::Module::getNamedMetadata()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNamedMetadataNumOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 891,
 FQN="LLVMGetNamedMetadataNumOperands", NM="_Z31LLVMGetNamedMetadataNumOperands",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z31LLVMGetNamedMetadataNumOperands")
//</editor-fold>
public static /*uint*/int LLVMGetNamedMetadataNumOperands( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Name) {
  {
    NamedMDNode /*P*/ N = IrLlvmGlobals.unwrap(M).getNamedMetadata(new Twine(Name));
    if ((N != null)) {
      return N.getNumOperands();
    }
  }
  return 0;
}


/**
* Obtain the named metadata operands for a module.
*
* The passed LLVMValueRef pointer should refer to an array of
* LLVMValueRef at least LLVMGetNamedMetadataNumOperands long. This
* array will be populated with the LLVMValueRef instances. Each
* instance corresponds to a llvm::MDNode.
*
* @see llvm::Module::getNamedMetadata()
* @see llvm::MDNode::getOperand()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNamedMetadataOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 898,
 FQN="LLVMGetNamedMetadataOperands", NM="_Z28LLVMGetNamedMetadataOperands",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z28LLVMGetNamedMetadataOperands")
//</editor-fold>
public static void LLVMGetNamedMetadataOperands( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Name, 
                            type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Dest) {
  NamedMDNode /*P*/ N = IrLlvmGlobals.unwrap(M).getNamedMetadata(new Twine(Name));
  if (!(N != null)) {
    return;
  }
  final LLVMContext /*&*/ Context = IrLlvmGlobals.unwrap(M).getContext();
  for (/*uint*/int i = 0; $less_uint(i, N.getNumOperands()); i++)  {
    Dest.$set(i, IrLlvmGlobals.wrap_Value$C$P(MetadataAsValue.get(Context, N.getOperand(i))));
  }
}


/**
* Add an operand to named metadata.
*
* @see llvm::Module::getNamedMetadata()
* @see llvm::MDNode::addOperand()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMAddNamedMetadataOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 908,
 FQN="LLVMAddNamedMetadataOperand", NM="_Z27LLVMAddNamedMetadataOperand",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMAddNamedMetadataOperand")
//</editor-fold>
public static void LLVMAddNamedMetadataOperand( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Name, 
                            LLVMOpaqueValue /*P*/ Val) {
  NamedMDNode /*P*/ N = IrLlvmGlobals.unwrap(M).getOrInsertNamedMetadata(new StringRef(Name));
  if (!(N != null)) {
    return;
  }
  if (!(Val != null)) {
    return;
  }
  N.addOperand(extractMDNode(IrLlvmGlobals.<MetadataAsValue>unwrap_LLVMOpaqueValue$P(MetadataAsValue.class, Val)));
}


/**
* Add a function to a module under a specified name.
*
* @see llvm::Function::Create()
*/

/*--.. Operations on functions .............................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMAddFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1746,
 FQN="LLVMAddFunction", NM="_Z15LLVMAddFunction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMAddFunction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMAddFunction( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Name, 
                LLVMOpaqueType /*P*/ FunctionTy) {
  return IrLlvmGlobals.wrap_Value$C$P(Function.Create(IrLlvmGlobals.<FunctionType>unwrap_LLVMOpaqueType$P(FunctionType.class, FunctionTy), 
          GlobalValue.LinkageTypes.ExternalLinkage, new Twine(Name), IrLlvmGlobals.unwrap(M)));
}


/**
* Obtain a Function value from a Module by its name.
*
* The returned value corresponds to a llvm::Function value.
*
* @see llvm::Module::getFunction()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNamedFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1752,
 FQN="LLVMGetNamedFunction", NM="_Z20LLVMGetNamedFunction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetNamedFunction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetNamedFunction( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(M).getFunction(new StringRef(Name)));
}


/**
* Obtain an iterator to the first Function in a Module.
*
* @see llvm::Module::begin()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetFirstFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1756,
 FQN="LLVMGetFirstFunction", NM="_Z20LLVMGetFirstFunction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetFirstFunction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetFirstFunction( LLVMOpaqueModule /*P*/ M) {
  Module /*P*/ Mod = IrLlvmGlobals.unwrap(M);
  ilist_iterator<Function> I = Mod.begin();
  if (I.$eq(Mod.end())) {
    return null;
  }
  return IrLlvmGlobals.wrap_Value$C$P($AddrOf(I.$star()));
}


/**
* Obtain an iterator to the last Function in a Module.
*
* @see llvm::Module::end()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetLastFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1764,
 FQN="LLVMGetLastFunction", NM="_Z19LLVMGetLastFunction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMGetLastFunction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetLastFunction( LLVMOpaqueModule /*P*/ M) {
  Module /*P*/ Mod = IrLlvmGlobals.unwrap(M);
  ilist_iterator<Function> I = Mod.end();
  if (I.$eq(Mod.begin())) {
    return null;
  }
  return IrLlvmGlobals.wrap_Value$C$P($AddrOf(I.$preDec().$star()));
}


/**
* Advance a Function iterator to the next Function.
*
* Returns NULL if the iterator was already at the end and there are no more
* functions.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNextFunction">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1772,
 FQN="LLVMGetNextFunction", NM="_Z19LLVMGetNextFunction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMGetNextFunction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetNextFunction( LLVMOpaqueValue /*P*/ Fn) {
  Function /*P*/ Func = IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, Fn);
  ilist_iterator<Function> I/*J*/= new ilist_iterator<Function>(Func, ilist_traits_IR.ilist_traits$Function());
  if (I.$preInc().$eq(Func.getParent().end())) {
    return null;
  }
  return IrLlvmGlobals.wrap_Value$C$P($AddrOf(I.$star()));
}


/**
* Decrement a Function iterator to the previous Function.
*
* Returns NULL if the iterator was already at the beginning and there are
* no previous functions.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetPreviousFunction">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1780,
 FQN="LLVMGetPreviousFunction", NM="_Z23LLVMGetPreviousFunction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMGetPreviousFunction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetPreviousFunction( LLVMOpaqueValue /*P*/ Fn) {
  Function /*P*/ Func = IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, Fn);
  ilist_iterator<Function> I/*J*/= new ilist_iterator<Function>(Func, ilist_traits_IR.ilist_traits$Function());
  if (I.$eq(Func.getParent().begin())) {
    return null;
  }
  return IrLlvmGlobals.wrap_Value$C$P($AddrOf(I.$preDec().$star()));
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreType Types
*
* Types represent the type of a value.
*
* Types are associated with a context instance. The context internally
* deduplicates types so there is only 1 instance of a specific type
* alive at a time. In other words, a unique type is shared among all
* consumers within a context.
*
* A Type in the C API corresponds to llvm::Type.
*
* Types have the following hierarchy:
*
*   types:
*     integer type
*     real type
*     function type
*     sequence types:
*       array type
*       pointer type
*       vector type
*     void type
*     label type
*     opaque type
*
* @{
*/

/**
* Obtain the enumerated type of a Type instance.
*
* @see llvm::Type:getTypeID()
*/

/*===-- Operations on types -----------------------------------------------===*/

/*--.. Operations on all types (mostly) ....................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetTypeKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 312,
 FQN="LLVMGetTypeKind", NM="_Z15LLVMGetTypeKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMGetTypeKind")
//</editor-fold>
public static LLVMTypeKind LLVMGetTypeKind( LLVMOpaqueType /*P*/ Ty) {
  switch (IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty).getTypeID()) {
   case VoidTyID:
    return LLVMTypeKind.LLVMVoidTypeKind;
   case HalfTyID:
    return LLVMTypeKind.LLVMHalfTypeKind;
   case FloatTyID:
    return LLVMTypeKind.LLVMFloatTypeKind;
   case DoubleTyID:
    return LLVMTypeKind.LLVMDoubleTypeKind;
   case X86_FP80TyID:
    return LLVMTypeKind.LLVMX86_FP80TypeKind;
   case FP128TyID:
    return LLVMTypeKind.LLVMFP128TypeKind;
   case PPC_FP128TyID:
    return LLVMTypeKind.LLVMPPC_FP128TypeKind;
   case LabelTyID:
    return LLVMTypeKind.LLVMLabelTypeKind;
   case MetadataTyID:
    return LLVMTypeKind.LLVMMetadataTypeKind;
   case IntegerTyID:
    return LLVMTypeKind.LLVMIntegerTypeKind;
   case FunctionTyID:
    return LLVMTypeKind.LLVMFunctionTypeKind;
   case StructTyID:
    return LLVMTypeKind.LLVMStructTypeKind;
   case ArrayTyID:
    return LLVMTypeKind.LLVMArrayTypeKind;
   case PointerTyID:
    return LLVMTypeKind.LLVMPointerTypeKind;
   case VectorTyID:
    return LLVMTypeKind.LLVMVectorTypeKind;
   case X86_MMXTyID:
    return LLVMTypeKind.LLVMX86_MMXTypeKind;
   case TokenTyID:
    return LLVMTypeKind.LLVMTokenTypeKind;
  }
  throw new llvm_unreachable("Unhandled TypeID.");
}


/**
* Whether the type has a known size.
*
* Things that don't have a size are abstract types, labels, and void.a
*
* @see llvm::Type::isSized()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMTypeIsSized">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 352,
 FQN="LLVMTypeIsSized", NM="_Z15LLVMTypeIsSized",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMTypeIsSized")
//</editor-fold>
public static int LLVMTypeIsSized( LLVMOpaqueType /*P*/ Ty) {
  return (IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty).isSized() ? 1 : 0);
}


/**
* Obtain the context to which this type instance is associated.
*
* @see llvm::Type::getContext()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetTypeContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 357,
 FQN="LLVMGetTypeContext", NM="_Z18LLVMGetTypeContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetTypeContext")
//</editor-fold>
public static  LLVMOpaqueContext /*P*/ LLVMGetTypeContext( LLVMOpaqueType /*P*/ Ty) {
  return IrLlvmGlobals.wrap_LLVMContext$C$P($AddrOf(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty).getContext()));
}


/**
* Dump a representation of a type to stderr.
*
* @see llvm::Type::dump()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMDumpType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 361,
 FQN="LLVMDumpType", NM="_Z12LLVMDumpType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMDumpType")
//</editor-fold>
public static void LLVMDumpType( LLVMOpaqueType /*P*/ Ty) {
  IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty).dump();
  /*JAVA:return*/return;
}


/**
* Return a string representation of the type. Use
* LLVMDisposeMessage to free the string.
*
* @see llvm::Type::print()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMPrintTypeToString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 365,
 FQN="LLVMPrintTypeToString", NM="_Z21LLVMPrintTypeToString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMPrintTypeToString")
//</editor-fold>
public static char$ptr/*char P*/ LLVMPrintTypeToString( LLVMOpaqueType /*P*/ Ty) {
  raw_string_ostream os = null;
  try {
    std.string buf/*J*/= new std.string();
    os/*J*/= new raw_string_ostream(buf);
    if ((IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty) != null)) {
      IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty).print(os);
    } else {
      os.$out(/*KEEP_STR*/"Printing <null> Type");
    }
    
    os.flush();
    
    return strdup(buf.c_str());
  } finally {
    if (os != null) { os.$destroy(); }
  }
}


/**
* @defgroup LLVMCCoreTypeInt Integer Types
*
* Functions in this section operate on integer types.
*
* @{
*/

/**
* Obtain an integer type from a context with specified bit width.
*/

/*--.. Operations on integer types .........................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMInt1TypeInContext">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 381,
 FQN="LLVMInt1TypeInContext", NM="_Z21LLVMInt1TypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMInt1TypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt1TypeInContext( LLVMOpaqueContext /*P*/ C) {
  return ( LLVMOpaqueType /*P*/ )(Object)Type.getInt1Ty($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt8TypeInContext">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 384,
 FQN="LLVMInt8TypeInContext", NM="_Z21LLVMInt8TypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMInt8TypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt8TypeInContext( LLVMOpaqueContext /*P*/ C) {
  return ( LLVMOpaqueType /*P*/ )(Object)Type.getInt8Ty($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt16TypeInContext">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 387,
 FQN="LLVMInt16TypeInContext", NM="_Z22LLVMInt16TypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMInt16TypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt16TypeInContext( LLVMOpaqueContext /*P*/ C) {
  return ( LLVMOpaqueType /*P*/ )(Object)Type.getInt16Ty($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt32TypeInContext">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 390,
 FQN="LLVMInt32TypeInContext", NM="_Z22LLVMInt32TypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMInt32TypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt32TypeInContext( LLVMOpaqueContext /*P*/ C) {
  return ( LLVMOpaqueType /*P*/ )(Object)Type.getInt32Ty($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt64TypeInContext">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 393,
 FQN="LLVMInt64TypeInContext", NM="_Z22LLVMInt64TypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMInt64TypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt64TypeInContext( LLVMOpaqueContext /*P*/ C) {
  return ( LLVMOpaqueType /*P*/ )(Object)Type.getInt64Ty($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt128TypeInContext">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 396,
 FQN="LLVMInt128TypeInContext", NM="_Z23LLVMInt128TypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMInt128TypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt128TypeInContext( LLVMOpaqueContext /*P*/ C) {
  return ( LLVMOpaqueType /*P*/ )(Object)Type.getInt128Ty($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIntTypeInContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 399,
 FQN="LLVMIntTypeInContext", NM="_Z20LLVMIntTypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMIntTypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMIntTypeInContext( LLVMOpaqueContext /*P*/ C, /*uint*/int NumBits) {
  return IrLlvmGlobals.wrap_Type$C$P(IntegerType.get($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)), NumBits));
}


/**
* Obtain an integer type from the global context with a specified bit
* width.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMInt1Type">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 403,
 FQN="LLVMInt1Type", NM="_Z12LLVMInt1Type",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMInt1Type")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt1Type() {
  return LLVMInt1TypeInContext(LLVMGetGlobalContext());
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt8Type">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 406,
 FQN="LLVMInt8Type", NM="_Z12LLVMInt8Type",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMInt8Type")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt8Type() {
  return LLVMInt8TypeInContext(LLVMGetGlobalContext());
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt16Type">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 409,
 FQN="LLVMInt16Type", NM="_Z13LLVMInt16Type",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMInt16Type")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt16Type() {
  return LLVMInt16TypeInContext(LLVMGetGlobalContext());
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt32Type">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 412,
 FQN="LLVMInt32Type", NM="_Z13LLVMInt32Type",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMInt32Type")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt32Type() {
  return LLVMInt32TypeInContext(LLVMGetGlobalContext());
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt64Type">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 415,
 FQN="LLVMInt64Type", NM="_Z13LLVMInt64Type",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMInt64Type")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt64Type() {
  return LLVMInt64TypeInContext(LLVMGetGlobalContext());
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt128Type">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 418,
 FQN="LLVMInt128Type", NM="_Z14LLVMInt128Type",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMInt128Type")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt128Type() {
  return LLVMInt128TypeInContext(LLVMGetGlobalContext());
}

//<editor-fold defaultstate="collapsed" desc="LLVMIntType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 421,
 FQN="LLVMIntType", NM="_Z11LLVMIntType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z11LLVMIntType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMIntType(/*uint*/int NumBits) {
  return LLVMIntTypeInContext(LLVMGetGlobalContext(), NumBits);
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetIntTypeWidth">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 425,
 FQN="LLVMGetIntTypeWidth", NM="_Z19LLVMGetIntTypeWidth",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMGetIntTypeWidth")
//</editor-fold>
public static /*uint*/int LLVMGetIntTypeWidth( LLVMOpaqueType /*P*/ IntegerTy) {
  return IrLlvmGlobals.<IntegerType>unwrap_LLVMOpaqueType$P(IntegerType.class, IntegerTy).getBitWidth();
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreTypeFloat Floating Point Types
*
* @{
*/

/**
* Obtain a 16-bit floating point type from a context.
*/

/*--.. Operations on real types ............................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMHalfTypeInContext">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 431,
 FQN="LLVMHalfTypeInContext", NM="_Z21LLVMHalfTypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMHalfTypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMHalfTypeInContext( LLVMOpaqueContext /*P*/ C) {
  return ( LLVMOpaqueType /*P*/ )(Object)Type.getHalfTy($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)));
}


/**
* Obtain a 32-bit floating point type from a context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMFloatTypeInContext">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 434,
 FQN="LLVMFloatTypeInContext", NM="_Z22LLVMFloatTypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMFloatTypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMFloatTypeInContext( LLVMOpaqueContext /*P*/ C) {
  return ( LLVMOpaqueType /*P*/ )(Object)Type.getFloatTy($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)));
}


/**
* Obtain a 64-bit floating point type from a context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMDoubleTypeInContext">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 437,
 FQN="LLVMDoubleTypeInContext", NM="_Z23LLVMDoubleTypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMDoubleTypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMDoubleTypeInContext( LLVMOpaqueContext /*P*/ C) {
  return ( LLVMOpaqueType /*P*/ )(Object)Type.getDoubleTy($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)));
}


/**
* Obtain a 80-bit floating point type (X87) from a context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMX86FP80TypeInContext">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 440,
 FQN="LLVMX86FP80TypeInContext", NM="_Z24LLVMX86FP80TypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMX86FP80TypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMX86FP80TypeInContext( LLVMOpaqueContext /*P*/ C) {
  return ( LLVMOpaqueType /*P*/ )(Object)Type.getX86_FP80Ty($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)));
}


/**
* Obtain a 128-bit floating point type (112-bit mantissa) from a
* context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMFP128TypeInContext">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 443,
 FQN="LLVMFP128TypeInContext", NM="_Z22LLVMFP128TypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMFP128TypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMFP128TypeInContext( LLVMOpaqueContext /*P*/ C) {
  return ( LLVMOpaqueType /*P*/ )(Object)Type.getFP128Ty($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)));
}


/**
* Obtain a 128-bit floating point type (two 64-bits) from a context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMPPCFP128TypeInContext">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 446,
 FQN="LLVMPPCFP128TypeInContext", NM="_Z25LLVMPPCFP128TypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMPPCFP128TypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMPPCFP128TypeInContext( LLVMOpaqueContext /*P*/ C) {
  return ( LLVMOpaqueType /*P*/ )(Object)Type.getPPC_FP128Ty($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)));
}


/**
* Obtain a floating point type from the global context.
*
* These map to the functions in this group of the same name.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMHalfType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 456,
 FQN="LLVMHalfType", NM="_Z12LLVMHalfType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMHalfType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMHalfType() {
  return LLVMHalfTypeInContext(LLVMGetGlobalContext());
}

//<editor-fold defaultstate="collapsed" desc="LLVMFloatType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 459,
 FQN="LLVMFloatType", NM="_Z13LLVMFloatType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMFloatType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMFloatType() {
  return LLVMFloatTypeInContext(LLVMGetGlobalContext());
}

//<editor-fold defaultstate="collapsed" desc="LLVMDoubleType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 462,
 FQN="LLVMDoubleType", NM="_Z14LLVMDoubleType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMDoubleType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMDoubleType() {
  return LLVMDoubleTypeInContext(LLVMGetGlobalContext());
}

//<editor-fold defaultstate="collapsed" desc="LLVMX86FP80Type">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 465,
 FQN="LLVMX86FP80Type", NM="_Z15LLVMX86FP80Type",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMX86FP80Type")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMX86FP80Type() {
  return LLVMX86FP80TypeInContext(LLVMGetGlobalContext());
}

//<editor-fold defaultstate="collapsed" desc="LLVMFP128Type">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 468,
 FQN="LLVMFP128Type", NM="_Z13LLVMFP128Type",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMFP128Type")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMFP128Type() {
  return LLVMFP128TypeInContext(LLVMGetGlobalContext());
}

//<editor-fold defaultstate="collapsed" desc="LLVMPPCFP128Type">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 471,
 FQN="LLVMPPCFP128Type", NM="_Z16LLVMPPCFP128Type",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMPPCFP128Type")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMPPCFP128Type() {
  return LLVMPPCFP128TypeInContext(LLVMGetGlobalContext());
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreTypeFunction Function Types
*
* @{
*/

/**
* Obtain a function type consisting of a specified signature.
*
* The function is defined as a tuple of a return Type, a list of
* parameter types, and whether the function is variadic.
*/

/*--.. Operations on function types ........................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMFunctionType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 480,
 FQN="LLVMFunctionType", NM="_Z16LLVMFunctionType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMFunctionType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMFunctionType( LLVMOpaqueType /*P*/ ReturnType, 
                type$ptr<LLVMOpaqueType /*P*/ /*P*/> ParamTypes, /*uint*/int ParamCount, 
                int IsVarArg) {
  ArrayRef<Type /*P*/ > Tys/*J*/= new ArrayRef<Type /*P*/ >(IrLlvmGlobals.unwrap_type$ptr$LLVMOpaqueType$P$P(ParamTypes), ParamCount, true);
  return IrLlvmGlobals.wrap_Type$C$P(FunctionType.get(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ReturnType), new ArrayRef<Type /*P*/ >(Tys), IsVarArg != 0));
}


/**
* Returns whether a function type is variadic.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsFunctionVarArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 487,
 FQN="LLVMIsFunctionVarArg", NM="_Z20LLVMIsFunctionVarArg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMIsFunctionVarArg")
//</editor-fold>
public static int LLVMIsFunctionVarArg( LLVMOpaqueType /*P*/ FunctionTy) {
  return (IrLlvmGlobals.<FunctionType>unwrap_LLVMOpaqueType$P(FunctionType.class, FunctionTy).isVarArg() ? 1 : 0);
}


/**
* Obtain the Type this function Type returns.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetReturnType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 491,
 FQN="LLVMGetReturnType", NM="_Z17LLVMGetReturnType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetReturnType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMGetReturnType( LLVMOpaqueType /*P*/ FunctionTy) {
  return IrLlvmGlobals.wrap_Type$C$P(IrLlvmGlobals.<FunctionType>unwrap_LLVMOpaqueType$P(FunctionType.class, FunctionTy).getReturnType());
}


/**
* Obtain the number of parameters this function accepts.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMCountParamTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 495,
 FQN="LLVMCountParamTypes", NM="_Z19LLVMCountParamTypes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMCountParamTypes")
//</editor-fold>
public static /*uint*/int LLVMCountParamTypes( LLVMOpaqueType /*P*/ FunctionTy) {
  return IrLlvmGlobals.<FunctionType>unwrap_LLVMOpaqueType$P(FunctionType.class, FunctionTy).getNumParams();
}


/**
* Obtain the types of a function's parameters.
*
* The Dest parameter should point to a pre-allocated array of
* LLVMTypeRef at least LLVMCountParamTypes() large. On return, the
* first LLVMCountParamTypes() entries in the array will be populated
* with LLVMTypeRef instances.
*
* @param FunctionTy The function type to operate on.
* @param Dest Memory address of an array to be filled with result.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetParamTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 499,
 FQN="LLVMGetParamTypes", NM="_Z17LLVMGetParamTypes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetParamTypes")
//</editor-fold>
public static void LLVMGetParamTypes( LLVMOpaqueType /*P*/ FunctionTy, type$ptr<LLVMOpaqueType /*P*/ /*P*/> Dest) {
  FunctionType /*P*/ Ty = IrLlvmGlobals.<FunctionType>unwrap_LLVMOpaqueType$P(FunctionType.class, FunctionTy);
  for (type$ptr<Type /*P*/ /*const*/ /*P*/> I = $tryClone(Ty.param_begin()), 
      /*P*/ /*const*/ /*P*/ E = $tryClone(Ty.param_end()); $noteq_ptr(I, E); I.$preInc())  {
    Dest.$postInc().$set(IrLlvmGlobals.wrap_Type$C$P(I.$star()));
  }
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreTypeStruct Structure Types
*
* These functions relate to LLVMTypeRef instances.
*
* @see llvm::StructType
*
* @{
*/

/**
* Create a new structure type in a context.
*
* A structure is specified by a list of inner elements/types and
* whether these can be packed together.
*
* @see llvm::StructType::create()
*/

/*--.. Operations on struct types ..........................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMStructTypeInContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 508,
 FQN="LLVMStructTypeInContext", NM="_Z23LLVMStructTypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMStructTypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMStructTypeInContext( LLVMOpaqueContext /*P*/ C, type$ptr<LLVMOpaqueType /*P*/ /*P*/> ElementTypes, 
                       /*uint*/int ElementCount, int Packed) {
  ArrayRef<Type /*P*/ > Tys/*J*/= new ArrayRef<Type /*P*/ >(IrLlvmGlobals.unwrap_type$ptr$LLVMOpaqueType$P$P(ElementTypes), ElementCount, true);
  return IrLlvmGlobals.wrap_Type$C$P(StructType.get($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)), new ArrayRef<Type /*P*/ >(Tys), Packed != 0));
}


/**
* Create a new structure type in the global context.
*
* @see llvm::StructType::create()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMStructType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 514,
 FQN="LLVMStructType", NM="_Z14LLVMStructType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMStructType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMStructType(type$ptr<LLVMOpaqueType /*P*/ /*P*/> ElementTypes, 
              /*uint*/int ElementCount, int Packed) {
  return LLVMStructTypeInContext(LLVMGetGlobalContext(), ElementTypes, 
      ElementCount, Packed);
}


/**
* Create an empty structure in a context having a specified name.
*
* @see llvm::StructType::create()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMStructCreateNamed">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 520,
 FQN="LLVMStructCreateNamed", NM="_Z21LLVMStructCreateNamed",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMStructCreateNamed")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMStructCreateNamed( LLVMOpaqueContext /*P*/ C, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Type$C$P(StructType.create($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)), new StringRef(Name)));
}


/**
* Obtain the name of a structure.
*
* @see llvm::StructType::getName()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetStructName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 525,
 FQN="LLVMGetStructName", NM="_Z17LLVMGetStructName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetStructName")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetStructName( LLVMOpaqueType /*P*/ Ty) {
  StructType /*P*/ Type = IrLlvmGlobals.<StructType>unwrap_LLVMOpaqueType$P(StructType.class, Ty);
  if (!Type.hasName()) {
    return null;
  }
  return Type.getName().data();
}


/**
* Set the contents of a structure type.
*
* @see llvm::StructType::setBody()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMStructSetBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 533,
 FQN="LLVMStructSetBody", NM="_Z17LLVMStructSetBody",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMStructSetBody")
//</editor-fold>
public static void LLVMStructSetBody( LLVMOpaqueType /*P*/ StructTy, type$ptr<LLVMOpaqueType /*P*/ /*P*/> ElementTypes, 
                 /*uint*/int ElementCount, int Packed) {
  ArrayRef<Type /*P*/ > Tys/*J*/= new ArrayRef<Type /*P*/ >(IrLlvmGlobals.unwrap_type$ptr$LLVMOpaqueType$P$P(ElementTypes), ElementCount, true);
  IrLlvmGlobals.<StructType>unwrap_LLVMOpaqueType$P(StructType.class, StructTy).setBody(new ArrayRef<Type /*P*/ >(Tys), Packed != 0);
}


/**
* Get the number of elements defined inside the structure.
*
* @see llvm::StructType::getNumElements()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMCountStructElementTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 539,
 FQN="LLVMCountStructElementTypes", NM="_Z27LLVMCountStructElementTypes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMCountStructElementTypes")
//</editor-fold>
public static /*uint*/int LLVMCountStructElementTypes( LLVMOpaqueType /*P*/ StructTy) {
  return IrLlvmGlobals.<StructType>unwrap_LLVMOpaqueType$P(StructType.class, StructTy).getNumElements();
}


/**
* Get the elements within a structure.
*
* The function is passed the address of a pre-allocated array of
* LLVMTypeRef at least LLVMCountStructElementTypes() long. After
* invocation, this array will be populated with the structure's
* elements. The objects in the destination array will have a lifetime
* of the structure type itself, which is the lifetime of the context it
* is contained in.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetStructElementTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 543,
 FQN="LLVMGetStructElementTypes", NM="_Z25LLVMGetStructElementTypes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMGetStructElementTypes")
//</editor-fold>
public static void LLVMGetStructElementTypes( LLVMOpaqueType /*P*/ StructTy, type$ptr<LLVMOpaqueType /*P*/ /*P*/> Dest) {
  StructType /*P*/ Ty = IrLlvmGlobals.<StructType>unwrap_LLVMOpaqueType$P(StructType.class, StructTy);
  for (type$ptr<Type /*P*/ /*const*/ /*P*/> I = $tryClone(Ty.element_begin()), 
      /*P*/ /*const*/ /*P*/ E = $tryClone(Ty.element_end()); $noteq_ptr(I, E); I.$preInc())  {
    Dest.$postInc().$set(IrLlvmGlobals.wrap_Type$C$P(I.$star()));
  }
}


/**
* Get the type of the element at a given index in the structure.
*
* @see llvm::StructType::getTypeAtIndex()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMStructGetTypeAtIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 550,
 FQN="LLVMStructGetTypeAtIndex", NM="_Z24LLVMStructGetTypeAtIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMStructGetTypeAtIndex")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMStructGetTypeAtIndex( LLVMOpaqueType /*P*/ StructTy, /*uint*/int i) {
  StructType /*P*/ Ty = IrLlvmGlobals.<StructType>unwrap_LLVMOpaqueType$P(StructType.class, StructTy);
  return IrLlvmGlobals.wrap_Type$C$P(Ty.getTypeAtIndex(i));
}


/**
* Determine whether a structure is packed.
*
* @see llvm::StructType::isPacked()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsPackedStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 555,
 FQN="LLVMIsPackedStruct", NM="_Z18LLVMIsPackedStruct",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMIsPackedStruct")
//</editor-fold>
public static int LLVMIsPackedStruct( LLVMOpaqueType /*P*/ StructTy) {
  return (IrLlvmGlobals.<StructType>unwrap_LLVMOpaqueType$P(StructType.class, StructTy).isPacked() ? 1 : 0);
}


/**
* Determine whether a structure is opaque.
*
* @see llvm::StructType::isOpaque()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsOpaqueStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 559,
 FQN="LLVMIsOpaqueStruct", NM="_Z18LLVMIsOpaqueStruct",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMIsOpaqueStruct")
//</editor-fold>
public static int LLVMIsOpaqueStruct( LLVMOpaqueType /*P*/ StructTy) {
  return (IrLlvmGlobals.<StructType>unwrap_LLVMOpaqueType$P(StructType.class, StructTy).isOpaque() ? 1 : 0);
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreTypeSequential Sequential Types
*
* Sequential types represents "arrays" of types. This is a super class
* for array, vector, and pointer types.
*
* @{
*/

/**
* Obtain the type of elements within a sequential type.
*
* This works on array, vector, and pointer types.
*
* @see llvm::SequentialType::getElementType()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetElementType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 581,
 FQN="LLVMGetElementType", NM="_Z18LLVMGetElementType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetElementType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMGetElementType( LLVMOpaqueType /*P*/ Ty) {
  return IrLlvmGlobals.wrap_Type$C$P(IrLlvmGlobals.<SequentialType>unwrap_LLVMOpaqueType$P(SequentialType.class, Ty).getElementType());
}


/**
* Create a fixed size array type that refers to a specific type.
*
* The created type will exist in the context that its element type
* exists in.
*
* @see llvm::ArrayType::get()
*/

/*--.. Operations on array, pointer, and vector types (sequence types) .....--*/
//<editor-fold defaultstate="collapsed" desc="LLVMArrayType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 569,
 FQN="LLVMArrayType", NM="_Z13LLVMArrayType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMArrayType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMArrayType( LLVMOpaqueType /*P*/ ElementType, /*uint*/int ElementCount) {
  return IrLlvmGlobals.wrap_Type$C$P(ArrayType.get(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ElementType), $uint2ulong(ElementCount)));
}


/**
* Obtain the length of an array type.
*
* This only works on types that represent arrays.
*
* @see llvm::ArrayType::getNumElements()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetArrayLength">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 585,
 FQN="LLVMGetArrayLength", NM="_Z18LLVMGetArrayLength",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetArrayLength")
//</editor-fold>
public static /*uint*/int LLVMGetArrayLength( LLVMOpaqueType /*P*/ ArrayTy) {
  return $ulong2uint(IrLlvmGlobals.<ArrayType>unwrap_LLVMOpaqueType$P(ArrayType.class, ArrayTy).getNumElements());
}


/**
* Create a pointer type that points to a defined type.
*
* The created type will exist in the context that its pointee type
* exists in.
*
* @see llvm::PointerType::get()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMPointerType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 573,
 FQN="LLVMPointerType", NM="_Z15LLVMPointerType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMPointerType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMPointerType( LLVMOpaqueType /*P*/ ElementType, /*uint*/int AddressSpace) {
  return IrLlvmGlobals.wrap_Type$C$P(PointerType.get(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ElementType), AddressSpace));
}


/**
* Obtain the address space of a pointer type.
*
* This only works on types that represent pointers.
*
* @see llvm::PointerType::getAddressSpace()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetPointerAddressSpace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 589,
 FQN="LLVMGetPointerAddressSpace", NM="_Z26LLVMGetPointerAddressSpace",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMGetPointerAddressSpace")
//</editor-fold>
public static /*uint*/int LLVMGetPointerAddressSpace( LLVMOpaqueType /*P*/ PointerTy) {
  return IrLlvmGlobals.<PointerType>unwrap_LLVMOpaqueType$P(PointerType.class, PointerTy).getAddressSpace();
}


/**
* Create a vector type that contains a defined type and has a specific
* number of elements.
*
* The created type will exist in the context thats its element type
* exists in.
*
* @see llvm::VectorType::get()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMVectorType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 577,
 FQN="LLVMVectorType", NM="_Z14LLVMVectorType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMVectorType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMVectorType( LLVMOpaqueType /*P*/ ElementType, /*uint*/int ElementCount) {
  return IrLlvmGlobals.wrap_Type$C$P(VectorType.get(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ElementType), ElementCount));
}


/**
* Obtain the number of elements in a vector type.
*
* This only works on types that represent vectors.
*
* @see llvm::VectorType::getNumElements()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetVectorSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 593,
 FQN="LLVMGetVectorSize", NM="_Z17LLVMGetVectorSize",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetVectorSize")
//</editor-fold>
public static /*uint*/int LLVMGetVectorSize( LLVMOpaqueType /*P*/ VectorTy) {
  return IrLlvmGlobals.<VectorType>unwrap_LLVMOpaqueType$P(VectorType.class, VectorTy).getNumElements();
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreTypeOther Other Types
*
* @{
*/

/**
* Create a void type in a context.
*/

/*--.. Operations on other types ...........................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMVoidTypeInContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 599,
 FQN="LLVMVoidTypeInContext", NM="_Z21LLVMVoidTypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMVoidTypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMVoidTypeInContext( LLVMOpaqueContext /*P*/ C) {
  return IrLlvmGlobals.wrap_Type$C$P(Type.getVoidTy($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C))));
}


/**
* Create a label type in a context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMLabelTypeInContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 602,
 FQN="LLVMLabelTypeInContext", NM="_Z22LLVMLabelTypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMLabelTypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMLabelTypeInContext( LLVMOpaqueContext /*P*/ C) {
  return IrLlvmGlobals.wrap_Type$C$P(Type.getLabelTy($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C))));
}


/**
* Create a X86 MMX type in a context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMX86MMXTypeInContext">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 449,
 FQN="LLVMX86MMXTypeInContext", NM="_Z23LLVMX86MMXTypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMX86MMXTypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMX86MMXTypeInContext( LLVMOpaqueContext /*P*/ C) {
  return ( LLVMOpaqueType /*P*/ )(Object)Type.getX86_MMXTy($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)));
}


/**
* These are similar to the above functions except they operate on the
* global context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMVoidType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 606,
 FQN="LLVMVoidType", NM="_Z12LLVMVoidType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMVoidType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMVoidType() {
  return LLVMVoidTypeInContext(LLVMGetGlobalContext());
}

//<editor-fold defaultstate="collapsed" desc="LLVMLabelType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 609,
 FQN="LLVMLabelType", NM="_Z13LLVMLabelType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMLabelType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMLabelType() {
  return LLVMLabelTypeInContext(LLVMGetGlobalContext());
}

//<editor-fold defaultstate="collapsed" desc="LLVMX86MMXType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 474,
 FQN="LLVMX86MMXType", NM="_Z14LLVMX86MMXType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMX86MMXType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMX86MMXType() {
  return LLVMX86MMXTypeInContext(LLVMGetGlobalContext());
}


/**
* @defgroup LLVMCCoreValueGeneral General APIs
*
* Functions in this section work on all LLVMValueRef instances,
* regardless of their sub-type. They correspond to functions available
* on llvm::Value.
*
* @{
*/

/**
* Obtain the type of a value.
*
* @see llvm::Value::getType()
*/

/*===-- Operations on values ----------------------------------------------===*/

/*--.. Operations on all values ............................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMTypeOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 617,
 FQN="LLVMTypeOf", NM="_Z10LLVMTypeOf",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z10LLVMTypeOf")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMTypeOf( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Type$C$P(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val).getType());
}


/**
* Obtain the enumerated type of a Value instance.
*
* @see llvm::Value::getValueID()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetValueKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 621,
 FQN="LLVMGetValueKind", NM="_Z16LLVMGetValueKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMGetValueKind")
//</editor-fold>
public static LLVMValueKind LLVMGetValueKind( LLVMOpaqueValue /*P*/ Val) {
  switch (Value.ValueTy.valueOf(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val).getValueID())) {
   case ArgumentVal:
    return LLVMValueKind.LLVMArgumentValueKind;
   case BasicBlockVal:
    return LLVMValueKind.LLVMBasicBlockValueKind;
   case MemoryUseVal:
    return LLVMValueKind.LLVMMemoryUseValueKind;
   case MemoryDefVal:
    return LLVMValueKind.LLVMMemoryDefValueKind;
   case MemoryPhiVal:
    return LLVMValueKind.LLVMMemoryPhiValueKind;
   case FunctionVal:
    return LLVMValueKind.LLVMFunctionValueKind;
   case GlobalAliasVal:
    return LLVMValueKind.LLVMGlobalAliasValueKind;
   case GlobalIFuncVal:
    return LLVMValueKind.LLVMGlobalIFuncValueKind;
   case GlobalVariableVal:
    return LLVMValueKind.LLVMGlobalVariableValueKind;
   case BlockAddressVal:
    return LLVMValueKind.LLVMBlockAddressValueKind;
   case ConstantExprVal:
    return LLVMValueKind.LLVMConstantExprValueKind;
   case ConstantArrayVal:
    
    // ConstantAggregate.
    return LLVMValueKind.LLVMConstantArrayValueKind;
   case ConstantStructVal:
    return LLVMValueKind.LLVMConstantStructValueKind;
   case ConstantVectorVal:
    return LLVMValueKind.LLVMConstantVectorValueKind;
   case UndefValueVal:
    
    // ConstantData.
    return LLVMValueKind.LLVMUndefValueValueKind;
   case ConstantAggregateZeroVal:
    return LLVMValueKind.LLVMConstantAggregateZeroValueKind;
   case ConstantDataArrayVal:
    return LLVMValueKind.LLVMConstantDataArrayValueKind;
   case ConstantDataVectorVal:
    return LLVMValueKind.LLVMConstantDataVectorValueKind;
   case ConstantIntVal:
    return LLVMValueKind.LLVMConstantIntValueKind;
   case ConstantFPVal:
    return LLVMValueKind.LLVMConstantFPValueKind;
   case ConstantPointerNullVal:
    return LLVMValueKind.LLVMConstantPointerNullValueKind;
   case ConstantTokenNoneVal:
    return LLVMValueKind.LLVMConstantTokenNoneValueKind;
   case MetadataAsValueVal:
    return LLVMValueKind.LLVMMetadataAsValueValueKind;
   case InlineAsmVal:
    return LLVMValueKind.LLVMInlineAsmValueKind;
   case InstructionVal:
    return LLVMValueKind.LLVMInstructionValueKind;
   default:
    return LLVMValueKind.LLVMInstructionValueKind;
  }
}


/**
* Obtain the string name of a value.
*
* @see llvm::Value::getName()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetValueName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 632,
 FQN="LLVMGetValueName", NM="_Z16LLVMGetValueName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMGetValueName")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetValueName( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val).getName().data();
}


/**
* Set the string name of a value.
*
* @see llvm::Value::setName()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetValueName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 636,
 FQN="LLVMSetValueName", NM="_Z16LLVMSetValueName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMSetValueName")
//</editor-fold>
public static void LLVMSetValueName( LLVMOpaqueValue /*P*/ Val, /*const*/char$ptr/*char P*/ Name) {
  IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val).setName(new Twine(Name));
}


/**
* Dump a representation of a value to stderr.
*
* @see llvm::Value::dump()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMDumpValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 640,
 FQN="LLVMDumpValue", NM="_Z13LLVMDumpValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMDumpValue")
//</editor-fold>
public static void LLVMDumpValue( LLVMOpaqueValue /*P*/ Val) {
  IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val).dump();
}


/**
* Return a string representation of the value. Use
* LLVMDisposeMessage to free the string.
*
* @see llvm::Value::print()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMPrintValueToString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 644,
 FQN="LLVMPrintValueToString", NM="_Z22LLVMPrintValueToString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMPrintValueToString")
//</editor-fold>
public static char$ptr/*char P*/ LLVMPrintValueToString( LLVMOpaqueValue /*P*/ Val) {
  raw_string_ostream os = null;
  try {
    std.string buf/*J*/= new std.string();
    os/*J*/= new raw_string_ostream(buf);
    if ((IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val) != null)) {
      IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val).print(os);
    } else {
      os.$out(/*KEEP_STR*/"Printing <null> Value");
    }
    
    os.flush();
    
    return strdup(buf.c_str());
  } finally {
    if (os != null) { os.$destroy(); }
  }
}


/**
* Replace all uses of a value with another one.
*
* @see llvm::Value::replaceAllUsesWith()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMReplaceAllUsesWith">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 658,
 FQN="LLVMReplaceAllUsesWith", NM="_Z22LLVMReplaceAllUsesWith",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMReplaceAllUsesWith")
//</editor-fold>
public static void LLVMReplaceAllUsesWith( LLVMOpaqueValue /*P*/ OldVal,  LLVMOpaqueValue /*P*/ NewVal) {
  IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(OldVal).replaceAllUsesWith(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(NewVal));
}


/**
* Determine whether the specified value instance is constant.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsConstant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 799,
 FQN="LLVMIsConstant", NM="_Z14LLVMIsConstant",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMIsConstant")
//</editor-fold>
public static int LLVMIsConstant( LLVMOpaqueValue /*P*/ Ty) {
  return (isa_Constant(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Ty)) ? 1 : 0);
}


/**
* Determine whether a value instance is undefined.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsUndef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 809,
 FQN="LLVMIsUndef", NM="_Z11LLVMIsUndef",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z11LLVMIsUndef")
//</editor-fold>
public static int LLVMIsUndef( LLVMOpaqueValue /*P*/ Val) {
  return (isa_UndefValue(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)) ? 1 : 0);
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAArgument", NM="_Z15LLVMIsAArgument",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsAArgument")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAArgument( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_Argument(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsABasicBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsABasicBlock", NM="_Z17LLVMIsABasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsABasicBlock")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsABasicBlock( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_BasicBlock(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAInlineAsm">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAInlineAsm", NM="_Z16LLVMIsAInlineAsm",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMIsAInlineAsm")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAInlineAsm( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_InlineAsm(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAUser">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAUser", NM="_Z11LLVMIsAUser",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z11LLVMIsAUser")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAUser( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_User(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstant", NM="_Z15LLVMIsAConstant",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsAConstant")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstant( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_Constant(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsABlockAddress">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsABlockAddress", NM="_Z19LLVMIsABlockAddress",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMIsABlockAddress")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsABlockAddress( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_BlockAddress(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantAggregateZero">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantAggregateZero", NM="_Z28LLVMIsAConstantAggregateZero",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z28LLVMIsAConstantAggregateZero")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantAggregateZero( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_ConstantAggregateZero(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantArray">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantArray", NM="_Z20LLVMIsAConstantArray",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMIsAConstantArray")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantArray( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_ConstantArray(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantDataSequential">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantDataSequential", NM="_Z29LLVMIsAConstantDataSequential",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMIsAConstantDataSequential")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantDataSequential( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_ConstantDataSequential(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantDataArray">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantDataArray", NM="_Z24LLVMIsAConstantDataArray",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMIsAConstantDataArray")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantDataArray( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_ConstantDataArray(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantDataVector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantDataVector", NM="_Z25LLVMIsAConstantDataVector",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMIsAConstantDataVector")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantDataVector( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_ConstantDataVector(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantExpr", NM="_Z19LLVMIsAConstantExpr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMIsAConstantExpr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantExpr( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_ConstantExpr(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantFP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantFP", NM="_Z17LLVMIsAConstantFP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAConstantFP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantFP( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_ConstantFP(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantInt", NM="_Z18LLVMIsAConstantInt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMIsAConstantInt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantInt( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_ConstantInt(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantPointerNull">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantPointerNull", NM="_Z26LLVMIsAConstantPointerNull",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMIsAConstantPointerNull")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantPointerNull( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_ConstantPointerNull(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantStruct", NM="_Z21LLVMIsAConstantStruct",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsAConstantStruct")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantStruct( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_ConstantStruct(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantTokenNone">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantTokenNone", NM="_Z24LLVMIsAConstantTokenNone",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMIsAConstantTokenNone")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantTokenNone( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_ConstantTokenNone(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantVector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantVector", NM="_Z21LLVMIsAConstantVector",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsAConstantVector")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantVector( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_ConstantVector(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAGlobalValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAGlobalValue", NM="_Z18LLVMIsAGlobalValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMIsAGlobalValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAGlobalValue( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_GlobalValue(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAGlobalAlias">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAGlobalAlias", NM="_Z18LLVMIsAGlobalAlias",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMIsAGlobalAlias")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAGlobalAlias( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_GlobalAlias(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAGlobalObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAGlobalObject", NM="_Z19LLVMIsAGlobalObject",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMIsAGlobalObject")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAGlobalObject( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_GlobalObject(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAFunction", NM="_Z15LLVMIsAFunction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsAFunction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAFunction( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_Function(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAGlobalVariable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAGlobalVariable", NM="_Z21LLVMIsAGlobalVariable",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsAGlobalVariable")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAGlobalVariable( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_GlobalVariable(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAUndefValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAUndefValue", NM="_Z17LLVMIsAUndefValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAUndefValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAUndefValue( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_UndefValue(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAInstruction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAInstruction", NM="_Z18LLVMIsAInstruction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMIsAInstruction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAInstruction( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_Instruction(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsABinaryOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsABinaryOperator", NM="_Z21LLVMIsABinaryOperator",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsABinaryOperator")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsABinaryOperator( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_BinaryOperator(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsACallInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsACallInst", NM="_Z15LLVMIsACallInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsACallInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsACallInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_CallInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAIntrinsicInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAIntrinsicInst", NM="_Z20LLVMIsAIntrinsicInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMIsAIntrinsicInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAIntrinsicInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_IntrinsicInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsADbgInfoIntrinsic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsADbgInfoIntrinsic", NM="_Z23LLVMIsADbgInfoIntrinsic",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMIsADbgInfoIntrinsic")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsADbgInfoIntrinsic( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_DbgInfoIntrinsic(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsADbgDeclareInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsADbgDeclareInst", NM="_Z21LLVMIsADbgDeclareInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsADbgDeclareInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsADbgDeclareInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_DbgDeclareInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAMemIntrinsic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAMemIntrinsic", NM="_Z19LLVMIsAMemIntrinsic",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMIsAMemIntrinsic")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAMemIntrinsic( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_MemIntrinsic(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAMemCpyInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAMemCpyInst", NM="_Z17LLVMIsAMemCpyInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAMemCpyInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAMemCpyInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_MemCpyInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAMemMoveInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAMemMoveInst", NM="_Z18LLVMIsAMemMoveInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMIsAMemMoveInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAMemMoveInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_MemMoveInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAMemSetInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAMemSetInst", NM="_Z17LLVMIsAMemSetInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAMemSetInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAMemSetInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_MemSetInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsACmpInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsACmpInst", NM="_Z14LLVMIsACmpInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMIsACmpInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsACmpInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_CmpInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAFCmpInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAFCmpInst", NM="_Z15LLVMIsAFCmpInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsAFCmpInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAFCmpInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_FCmpInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAICmpInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAICmpInst", NM="_Z15LLVMIsAICmpInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsAICmpInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAICmpInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_ICmpInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAExtractElementInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAExtractElementInst", NM="_Z25LLVMIsAExtractElementInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMIsAExtractElementInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAExtractElementInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_ExtractElementInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAGetElementPtrInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAGetElementPtrInst", NM="_Z24LLVMIsAGetElementPtrInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMIsAGetElementPtrInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAGetElementPtrInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_GetElementPtrInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAInsertElementInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAInsertElementInst", NM="_Z24LLVMIsAInsertElementInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMIsAInsertElementInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAInsertElementInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_InsertElementInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAInsertValueInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAInsertValueInst", NM="_Z22LLVMIsAInsertValueInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMIsAInsertValueInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAInsertValueInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_InsertValueInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsALandingPadInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsALandingPadInst", NM="_Z21LLVMIsALandingPadInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsALandingPadInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsALandingPadInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_LandingPadInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAPHINode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAPHINode", NM="_Z14LLVMIsAPHINode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMIsAPHINode")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAPHINode( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_PHINode(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsASelectInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsASelectInst", NM="_Z17LLVMIsASelectInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsASelectInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsASelectInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_SelectInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAShuffleVectorInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAShuffleVectorInst", NM="_Z24LLVMIsAShuffleVectorInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMIsAShuffleVectorInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAShuffleVectorInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_ShuffleVectorInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAStoreInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAStoreInst", NM="_Z16LLVMIsAStoreInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMIsAStoreInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAStoreInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_StoreInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsATerminatorInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsATerminatorInst", NM="_Z21LLVMIsATerminatorInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsATerminatorInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsATerminatorInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_TerminatorInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsABranchInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsABranchInst", NM="_Z17LLVMIsABranchInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsABranchInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsABranchInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_BranchInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAIndirectBrInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAIndirectBrInst", NM="_Z21LLVMIsAIndirectBrInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsAIndirectBrInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAIndirectBrInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_IndirectBrInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAInvokeInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAInvokeInst", NM="_Z17LLVMIsAInvokeInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAInvokeInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAInvokeInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_InvokeInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAReturnInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAReturnInst", NM="_Z17LLVMIsAReturnInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAReturnInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAReturnInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_ReturnInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsASwitchInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsASwitchInst", NM="_Z17LLVMIsASwitchInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsASwitchInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsASwitchInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_SwitchInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAUnreachableInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAUnreachableInst", NM="_Z22LLVMIsAUnreachableInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMIsAUnreachableInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAUnreachableInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_UnreachableInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAResumeInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAResumeInst", NM="_Z17LLVMIsAResumeInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAResumeInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAResumeInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_ResumeInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsACleanupReturnInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsACleanupReturnInst", NM="_Z24LLVMIsACleanupReturnInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMIsACleanupReturnInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsACleanupReturnInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_CleanupReturnInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsACatchReturnInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsACatchReturnInst", NM="_Z22LLVMIsACatchReturnInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMIsACatchReturnInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsACatchReturnInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_CatchReturnInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAFuncletPadInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAFuncletPadInst", NM="_Z21LLVMIsAFuncletPadInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsAFuncletPadInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAFuncletPadInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_FuncletPadInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsACatchPadInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsACatchPadInst", NM="_Z19LLVMIsACatchPadInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMIsACatchPadInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsACatchPadInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_CatchPadInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsACleanupPadInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsACleanupPadInst", NM="_Z21LLVMIsACleanupPadInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsACleanupPadInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsACleanupPadInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_CleanupPadInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAUnaryInstruction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAUnaryInstruction", NM="_Z23LLVMIsAUnaryInstruction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMIsAUnaryInstruction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAUnaryInstruction( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_UnaryInstruction(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAAllocaInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAAllocaInst", NM="_Z17LLVMIsAAllocaInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAAllocaInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAAllocaInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_AllocaInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsACastInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsACastInst", NM="_Z15LLVMIsACastInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsACastInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsACastInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_CastInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAAddrSpaceCastInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAAddrSpaceCastInst", NM="_Z24LLVMIsAAddrSpaceCastInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMIsAAddrSpaceCastInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAAddrSpaceCastInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_AddrSpaceCastInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsABitCastInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsABitCastInst", NM="_Z18LLVMIsABitCastInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMIsABitCastInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsABitCastInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_BitCastInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAFPExtInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAFPExtInst", NM="_Z16LLVMIsAFPExtInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMIsAFPExtInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAFPExtInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_FPExtInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAFPToSIInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAFPToSIInst", NM="_Z17LLVMIsAFPToSIInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAFPToSIInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAFPToSIInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_FPToSIInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAFPToUIInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAFPToUIInst", NM="_Z17LLVMIsAFPToUIInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAFPToUIInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAFPToUIInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_FPToUIInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAFPTruncInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAFPTruncInst", NM="_Z18LLVMIsAFPTruncInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMIsAFPTruncInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAFPTruncInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_FPTruncInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAIntToPtrInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAIntToPtrInst", NM="_Z19LLVMIsAIntToPtrInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMIsAIntToPtrInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAIntToPtrInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_IntToPtrInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAPtrToIntInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAPtrToIntInst", NM="_Z19LLVMIsAPtrToIntInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMIsAPtrToIntInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAPtrToIntInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_PtrToIntInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsASExtInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsASExtInst", NM="_Z15LLVMIsASExtInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsASExtInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsASExtInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_SExtInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsASIToFPInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsASIToFPInst", NM="_Z17LLVMIsASIToFPInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsASIToFPInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsASIToFPInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_SIToFPInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsATruncInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsATruncInst", NM="_Z16LLVMIsATruncInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMIsATruncInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsATruncInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_TruncInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAUIToFPInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAUIToFPInst", NM="_Z17LLVMIsAUIToFPInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAUIToFPInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAUIToFPInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_UIToFPInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAZExtInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAZExtInst", NM="_Z15LLVMIsAZExtInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsAZExtInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAZExtInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_ZExtInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAExtractValueInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAExtractValueInst", NM="_Z23LLVMIsAExtractValueInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMIsAExtractValueInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAExtractValueInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_ExtractValueInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsALoadInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsALoadInst", NM="_Z15LLVMIsALoadInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsALoadInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsALoadInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_LoadInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAVAArgInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAVAArgInst", NM="_Z16LLVMIsAVAArgInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMIsAVAArgInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAVAArgInst( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(dyn_cast_or_null_VAArgInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAMDNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 703,
 FQN="LLVMIsAMDNode", NM="_Z13LLVMIsAMDNode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMIsAMDNode")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAMDNode( LLVMOpaqueValue /*P*/ Val) {
  {
    MetadataAsValue /*P*/ MD = dyn_cast_or_null_MetadataAsValue(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val));
    if ((MD != null)) {
      if (isa_MDNode(MD.getMetadata())
         || isa_ValueAsMetadata(MD.getMetadata())) {
        return Val;
      }
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAMDString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 711,
 FQN="LLVMIsAMDString", NM="_Z15LLVMIsAMDString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsAMDString")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAMDString( LLVMOpaqueValue /*P*/ Val) {
  {
    MetadataAsValue /*P*/ MD = dyn_cast_or_null_MetadataAsValue(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val));
    if ((MD != null)) {
      if (isa_MDString(MD.getMetadata())) {
        return Val;
      }
    }
  }
  return null;
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreValueUses Usage
*
* This module defines functions that allow you to inspect the uses of a
* LLVMValueRef.
*
* It is possible to obtain an LLVMUseRef for any LLVMValueRef instance.
* Each LLVMUseRef (which corresponds to a llvm::Use instance) holds a
* llvm::User and llvm::Value.
*
* @{
*/

/**
* Obtain the first use of a value.
*
* Uses are obtained in an iterator fashion. First, call this function
* to obtain a reference to the first use. Then, call LLVMGetNextUse()
* on that instance and all subsequently obtained instances until
* LLVMGetNextUse() returns NULL.
*
* @see llvm::Value::use_begin()
*/

/*--.. Operations on Uses ..................................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetFirstUse">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 719,
 FQN="LLVMGetFirstUse", NM="_Z15LLVMGetFirstUse",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMGetFirstUse")
//</editor-fold>
public static  LLVMOpaqueUse /*P*/ LLVMGetFirstUse( LLVMOpaqueValue /*P*/ Val) {
  Value /*P*/ V = IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val);
  Value.use_iterator_impl<Use> I = V.use_begin();
  if (I.$eq(V.use_end())) {
    return null;
  }
  return IrLlvmGlobals.wrap(create_type$ptr(I.$star()));
}


/**
* Obtain the next use of a value.
*
* This effectively advances the iterator. It returns NULL if you are on
* the final use and no more are available.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNextUse">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 727,
 FQN="LLVMGetNextUse", NM="_Z14LLVMGetNextUse",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMGetNextUse")
//</editor-fold>
public static  LLVMOpaqueUse /*P*/ LLVMGetNextUse( LLVMOpaqueUse /*P*/ U) {
  type$ptr<Use /*P*/> Next = create_type$ptr($tryClone(IrLlvmGlobals.unwrap(U).$star().getNext()));
  if (Native.$bool(Next)) {
    return IrLlvmGlobals.wrap(Next);
  }
  return null;
}


/**
* Obtain the user value for a user.
*
* The returned value corresponds to a llvm::User type.
*
* @see llvm::Use::getUser()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetUser">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 734,
 FQN="LLVMGetUser", NM="_Z11LLVMGetUser",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z11LLVMGetUser")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetUser( LLVMOpaqueUse /*P*/ U) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(U).$star().getUser());
}


/**
* Obtain the value this use corresponds to.
*
* @see llvm::Use::get().
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetUsedValue">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 738,
 FQN="LLVMGetUsedValue", NM="_Z16LLVMGetUsedValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMGetUsedValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetUsedValue( LLVMOpaqueUse /*P*/ U) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(U).$star().get());
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreValueUser User value
*
* Function in this group pertain to LLVMValueRef instances that descent
* from llvm::User. This includes constants, instructions, and
* operators.
*
* @{
*/

/**
* Obtain an operand at a specific index in a llvm::User value.
*
* @see llvm::User::getOperand()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 754,
 FQN="LLVMGetOperand", NM="_Z14LLVMGetOperand",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMGetOperand")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetOperand( LLVMOpaqueValue /*P*/ Val, /*uint*/int Index) {
  Value /*P*/ V = IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val);
  {
    MetadataAsValue /*P*/ MD = dyn_cast_MetadataAsValue(V);
    if ((MD != null)) {
      {
        ValueAsMetadata /*P*/ L = dyn_cast_ValueAsMetadata(MD.getMetadata());
        if ((L != null)) {
          assert (Index == 0) : "Function-local metadata can only have one operand";
          return IrLlvmGlobals.wrap_Value$C$P(L.getValue());
        }
      }
      return getMDNodeOperandImpl(V.getContext(), 
          cast_MDNode(MD.getMetadata()), Index);
    }
  }
  
  return IrLlvmGlobals.wrap_Value$C$P(cast_User(V).getOperand(Index));
}


/**
* Obtain the use of an operand at a specific index in a llvm::User value.
*
* @see llvm::User::getOperandUse()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetOperandUse">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 768,
 FQN="LLVMGetOperandUse", NM="_Z17LLVMGetOperandUse",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetOperandUse")
//</editor-fold>
public static  LLVMOpaqueUse /*P*/ LLVMGetOperandUse( LLVMOpaqueValue /*P*/ Val, /*uint*/int Index) {
  Value /*P*/ V = IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val);
  return IrLlvmGlobals.wrap(create_type$ptr($AddrOf(cast_User(V).getOperandUse(Index))));
}


/**
* Set an operand at a specific index in a llvm::User value.
*
* @see llvm::User::setOperand()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 773,
 FQN="LLVMSetOperand", NM="_Z14LLVMSetOperand",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMSetOperand")
//</editor-fold>
public static void LLVMSetOperand( LLVMOpaqueValue /*P*/ Val, /*uint*/int Index,  LLVMOpaqueValue /*P*/ Op) {
  IrLlvmGlobals.<User>unwrap_LLVMOpaqueValue$P(User.class, Val).setOperand(Index, IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Op));
}


/**
* Obtain the number of operands in a llvm::User value.
*
* @see llvm::User::getNumOperands()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNumOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 777,
 FQN="LLVMGetNumOperands", NM="_Z18LLVMGetNumOperands",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetNumOperands")
//</editor-fold>
public static int LLVMGetNumOperands( LLVMOpaqueValue /*P*/ Val) {
  Value /*P*/ V = IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val);
  if (isa_MetadataAsValue(V)) {
    return LLVMGetMDNodeNumOperands(Val);
  }
  
  return cast_User(V).getNumOperands();
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreValueConstant Constants
*
* This section contains APIs for interacting with LLVMValueRef that
* correspond to llvm::Constant instances.
*
* These functions will work for any LLVMValueRef in the llvm::Constant
* class hierarchy.
*
* @{
*/

/**
* Obtain a constant value referring to the null instance of a type.
*
* @see llvm::Constant::getNullValue()
*/

/*--.. Operations on constants of any type .................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstNull">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 787,
 FQN="LLVMConstNull", NM="_Z13LLVMConstNull",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstNull")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNull( LLVMOpaqueType /*P*/ Ty) {
  return IrLlvmGlobals.wrap_Value$C$P(Constant.getNullValue(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty)));
}

/* all zeroes */

/**
* Obtain a constant value referring to the instance of a type
* consisting of all ones.
*
* This is only valid for integer types.
*
* @see llvm::Constant::getAllOnesValue()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstAllOnes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 791,
 FQN="LLVMConstAllOnes", NM="_Z16LLVMConstAllOnes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMConstAllOnes")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstAllOnes( LLVMOpaqueType /*P*/ Ty) {
  return IrLlvmGlobals.wrap_Value$C$P(Constant.getAllOnesValue(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty)));
}


/**
* Obtain a constant value referring to an undefined value of a type.
*
* @see llvm::UndefValue::get()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetUndef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 795,
 FQN="LLVMGetUndef", NM="_Z12LLVMGetUndef",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMGetUndef")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetUndef( LLVMOpaqueType /*P*/ Ty) {
  return IrLlvmGlobals.wrap_Value$C$P(UndefValue.get(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty)));
}


/**
* Determine whether a value instance is null.
*
* @see llvm::Constant::isNullValue()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsNull">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 803,
 FQN="LLVMIsNull", NM="_Z10LLVMIsNull",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z10LLVMIsNull")
//</editor-fold>
public static int LLVMIsNull( LLVMOpaqueValue /*P*/ Val) {
  {
    Constant /*P*/ C = dyn_cast_Constant(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val));
    if ((C != null)) {
      return (C.isNullValue() ? 1 : 0);
    }
  }
  return /*false*/0;
}


/**
* Obtain a constant that is a constant pointer pointing to NULL for a
* specified type.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstPointerNull">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 813,
 FQN="LLVMConstPointerNull", NM="_Z20LLVMConstPointerNull",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMConstPointerNull")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstPointerNull( LLVMOpaqueType /*P*/ Ty) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantPointerNull.get(IrLlvmGlobals.<PointerType>unwrap_LLVMOpaqueType$P(PointerType.class, Ty)));
}


/**
* @defgroup LLVMCCoreValueConstantScalar Scalar constants
*
* Functions in this group model LLVMValueRef instances that correspond
* to constants referring to scalar types.
*
* For integer types, the LLVMTypeRef parameter should correspond to a
* llvm::IntegerType instance and the returned LLVMValueRef will
* correspond to a llvm::ConstantInt.
*
* For floating point types, the LLVMTypeRef returned corresponds to a
* llvm::ConstantFP.
*
* @{
*/

/**
* Obtain a constant value for an integer type.
*
* The returned value corresponds to a llvm::ConstantInt.
*
* @see llvm::ConstantInt::get()
*
* @param IntTy Integer type to obtain value of.
* @param N The value the returned instance should refer to.
* @param SignExtend Whether to sign extend the produced value.
*/

/*--.. Operations on scalar constants ......................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 920,
 FQN="LLVMConstInt", NM="_Z12LLVMConstInt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstInt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstInt( LLVMOpaqueType /*P*/ IntTy, /*ullong*/long N, 
            int SignExtend) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantInt.get(IrLlvmGlobals.<IntegerType>unwrap_LLVMOpaqueType$P(IntegerType.class, IntTy), N, SignExtend != 0));
}


/**
* Obtain a constant value for an integer of arbitrary precision.
*
* @see llvm::ConstantInt::get()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstIntOfArbitraryPrecision">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 925,
 FQN="LLVMConstIntOfArbitraryPrecision", NM="_Z32LLVMConstIntOfArbitraryPrecision",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z32LLVMConstIntOfArbitraryPrecision")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstIntOfArbitraryPrecision( LLVMOpaqueType /*P*/ IntTy, 
                                /*uint*/int NumWords, 
                                /*const*/long/*uint64_t*/ Words[]) {
  IntegerType /*P*/ Ty = IrLlvmGlobals.<IntegerType>unwrap_LLVMOpaqueType$P(IntegerType.class, IntTy);
  return IrLlvmGlobals.wrap_Value$C$P(ConstantInt.get(Ty.getContext(), 
          new APInt(Ty.getBitWidth(), 
                  makeArrayRef$ULLong(Words, NumWords))));
}


/**
* Obtain a constant value for an integer parsed from a string.
*
* A similar API, LLVMConstIntOfStringAndSize is also available. If the
* string's length is available, it is preferred to call that function
* instead.
*
* @see llvm::ConstantInt::get()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstIntOfString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 934,
 FQN="LLVMConstIntOfString", NM="_Z20LLVMConstIntOfString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMConstIntOfString")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstIntOfString( LLVMOpaqueType /*P*/ IntTy, /*const*//*char*/byte Str[], 
                    byte/*uint8_t*/ Radix) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantInt.get(IrLlvmGlobals.<IntegerType>unwrap_LLVMOpaqueType$P(IntegerType.class, IntTy), new StringRef(Str), 
          Radix));
}


/**
* Obtain a constant value for an integer parsed from a string with
* specified length.
*
* @see llvm::ConstantInt::get()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstIntOfStringAndSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 940,
 FQN="LLVMConstIntOfStringAndSize", NM="_Z27LLVMConstIntOfStringAndSize",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMConstIntOfStringAndSize")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstIntOfStringAndSize( LLVMOpaqueType /*P*/ IntTy, /*const*//*char*/byte Str[], 
                           /*uint*/int SLen, byte/*uint8_t*/ Radix) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantInt.get(IrLlvmGlobals.<IntegerType>unwrap_LLVMOpaqueType$P(IntegerType.class, IntTy), new StringRef(Str, SLen), 
          Radix));
}


/**
* Obtain a constant value referring to a double floating point value.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstReal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 946,
 FQN="LLVMConstReal", NM="_Z13LLVMConstReal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstReal")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstReal( LLVMOpaqueType /*P*/ RealTy, double N) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantFP.get(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(RealTy), N));
}


/**
* Obtain a constant for a floating point value parsed from a string.
*
* A similar API, LLVMConstRealOfStringAndSize is also available. It
* should be used if the input string's length is known.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstRealOfString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 950,
 FQN="LLVMConstRealOfString", NM="_Z21LLVMConstRealOfString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMConstRealOfString")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstRealOfString( LLVMOpaqueType /*P*/ RealTy, /*const*/char$ptr/*char P*/ Text) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantFP.get(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(RealTy), new StringRef(Text)));
}


/**
* Obtain a constant for a floating point value parsed from a string.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstRealOfStringAndSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 954,
 FQN="LLVMConstRealOfStringAndSize", NM="_Z28LLVMConstRealOfStringAndSize",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z28LLVMConstRealOfStringAndSize")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstRealOfStringAndSize( LLVMOpaqueType /*P*/ RealTy, /*const*//*char*/byte Str[], 
                            /*uint*/int SLen) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantFP.get(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(RealTy), new StringRef(Str, SLen)));
}


/**
* Obtain the zero extended value for an integer constant value.
*
* @see llvm::ConstantInt::getZExtValue()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstIntGetZExtValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 959,
 FQN="LLVMConstIntGetZExtValue", NM="_Z24LLVMConstIntGetZExtValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMConstIntGetZExtValue")
//</editor-fold>
public static /*ullong*/long LLVMConstIntGetZExtValue( LLVMOpaqueValue /*P*/ ConstantVal) {
  return IrLlvmGlobals.<ConstantInt>unwrap_LLVMOpaqueValue$P(ConstantInt.class, ConstantVal).getZExtValue();
}


/**
* Obtain the sign extended value for an integer constant value.
*
* @see llvm::ConstantInt::getSExtValue()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstIntGetSExtValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 963,
 FQN="LLVMConstIntGetSExtValue", NM="_Z24LLVMConstIntGetSExtValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMConstIntGetSExtValue")
//</editor-fold>
public static /*llong*/long LLVMConstIntGetSExtValue( LLVMOpaqueValue /*P*/ ConstantVal) {
  return IrLlvmGlobals.<ConstantInt>unwrap_LLVMOpaqueValue$P(ConstantInt.class, ConstantVal).getSExtValue();
}


/**
* Obtain the double value for an floating point constant value.
* losesInfo indicates if some precision was lost in the conversion.
*
* @see llvm::ConstantFP::getDoubleValue
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstRealGetDouble">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 967,
 FQN="LLVMConstRealGetDouble", NM="_Z22LLVMConstRealGetDouble",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMConstRealGetDouble")
//</editor-fold>
public static double LLVMConstRealGetDouble( LLVMOpaqueValue /*P*/ ConstantVal, int$ptr/*int P*/ LosesInfo) {
  ConstantFP /*P*/ cFP = IrLlvmGlobals.<ConstantFP>unwrap_LLVMOpaqueValue$P(ConstantFP.class, ConstantVal);
  Type /*P*/ Ty = cFP.getType();
  if (Ty.isFloatTy()) {
    LosesInfo.$set(/*false*/0);
    return cFP.getValueAPF().convertToFloat();
  }
  if (Ty.isDoubleTy()) {
    LosesInfo.$set(/*false*/0);
    return cFP.getValueAPF().convertToDouble();
  }
  
  bool$ptr APFLosesInfo = create_bool$ptr();
  APFloat APF = new APFloat(cFP.getValueAPF());
  APF.convert(APFloat.IEEEdouble, APFloat.roundingMode.rmNearestTiesToEven, $AddrOf(APFLosesInfo));
  LosesInfo.$set((APFLosesInfo.$star() ? 1 : 0));
  return APF.convertToDouble();
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreValueConstantComposite Composite Constants
*
* Functions in this group operate on composite constants.
*
* @{
*/

/**
* Create a ConstantDataSequential and initialize it with a string.
*
* @see llvm::ConstantDataArray::getString()
*/

/*--.. Operations on composite constants ...................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstStringInContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 990,
 FQN="LLVMConstStringInContext", NM="_Z24LLVMConstStringInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMConstStringInContext")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstStringInContext( LLVMOpaqueContext /*P*/ C, /*const*/char$ptr/*char P*/ Str, 
                        /*uint*/int Length, 
                        int DontNullTerminate) {
  /* Inverted the sense of AddNull because ', 0)' is a
  better mnemonic for null termination than ', 1)'. */
  return IrLlvmGlobals.wrap_Value$C$P(ConstantDataArray.getString($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)), new StringRef(Str, Length), 
          DontNullTerminate == 0));
}


/**
* Create a ConstantDataSequential with string content in the global context.
*
* This is the same as LLVMConstStringInContext except it operates on the
* global context.
*
* @see LLVMConstStringInContext()
* @see llvm::ConstantDataArray::getString()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 999,
 FQN="LLVMConstString", NM="_Z15LLVMConstString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstString")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstString(/*const*/char$ptr/*char P*/ Str, /*uint*/int Length, 
               int DontNullTerminate) {
  return LLVMConstStringInContext(LLVMGetGlobalContext(), Str, Length, 
      DontNullTerminate);
}


/**
* Returns true if the specified constant is an array of i8.
*
* @see ConstantDataSequential::getAsString()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsConstantString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1009,
 FQN="LLVMIsConstantString", NM="_Z20LLVMIsConstantString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMIsConstantString")
//</editor-fold>
public static int LLVMIsConstantString( LLVMOpaqueValue /*P*/ C) {
  return (IrLlvmGlobals.<ConstantDataSequential>unwrap_LLVMOpaqueValue$P(ConstantDataSequential.class, C).isString() ? 1 : 0);
}


/**
* Get the given constant data sequential as a string.
*
* @see ConstantDataSequential::getAsString()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetAsString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1013,
 FQN="LLVMGetAsString", NM="_Z15LLVMGetAsString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMGetAsString")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetAsString( LLVMOpaqueValue /*P*/ C, uint$ptr/*size_t P*/ Length) {
  StringRef Str = IrLlvmGlobals.<ConstantDataSequential>unwrap_LLVMOpaqueValue$P(ConstantDataSequential.class, C).getAsString();
  Length.$set(Str.size());
  return Str.data();
}


/**
* Create an anonymous ConstantStruct with the specified values.
*
* @see llvm::ConstantStruct::getAnon()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstStructInContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1025,
 FQN="LLVMConstStructInContext", NM="_Z24LLVMConstStructInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMConstStructInContext")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstStructInContext( LLVMOpaqueContext /*P*/ C, 
                        type$ptr<LLVMOpaqueValue /*P*/ /*P*/> ConstantVals, 
                        /*uint*/int Count, int Packed) {
  type$ptr<Constant /*P*/ /*P*/> Elements = $tryClone(IrLlvmGlobals.<Constant>unwrap$T(Constant.class, ConstantVals, Count));
  return IrLlvmGlobals.wrap_Value$C$P(ConstantStruct.getAnon($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)), makeArrayRef(Elements, Count), 
          Packed != 0));
}


/**
* Create a ConstantStruct in the global Context.
*
* This is the same as LLVMConstStructInContext except it operates on the
* global Context.
*
* @see LLVMConstStructInContext()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1033,
 FQN="LLVMConstStruct", NM="_Z15LLVMConstStruct",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstStruct")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstStruct(type$ptr<LLVMOpaqueValue /*P*/ /*P*/> ConstantVals, /*uint*/int Count, 
               int Packed) {
  return LLVMConstStructInContext(LLVMGetGlobalContext(), ConstantVals, Count, 
      Packed);
}


/**
* Create a ConstantArray from values.
*
* @see llvm::ConstantArray::get()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstArray">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1019,
 FQN="LLVMConstArray", NM="_Z14LLVMConstArray",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMConstArray")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstArray( LLVMOpaqueType /*P*/ ElementTy, 
              type$ptr<LLVMOpaqueValue /*P*/ /*P*/> ConstantVals, /*uint*/int Length) {
  ArrayRef<Constant /*P*/ > V/*J*/= new ArrayRef<Constant /*P*/ >(IrLlvmGlobals.<Constant>unwrap$T(Constant.class, ConstantVals, Length), Length, true);
  return IrLlvmGlobals.wrap_Value$C$P(ConstantArray.get(ArrayType.get(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ElementTy), $uint2ulong(Length)), new ArrayRef<Constant /*P*/ >(V)));
}


/**
* Create a non-anonymous ConstantStruct from values.
*
* @see llvm::ConstantStruct::get()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstNamedStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1039,
 FQN="LLVMConstNamedStruct", NM="_Z20LLVMConstNamedStruct",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMConstNamedStruct")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNamedStruct( LLVMOpaqueType /*P*/ StructTy, 
                    type$ptr<LLVMOpaqueValue /*P*/ /*P*/> ConstantVals, 
                    /*uint*/int Count) {
  type$ptr<Constant /*P*/ /*P*/> Elements = $tryClone(IrLlvmGlobals.<Constant>unwrap$T(Constant.class, ConstantVals, Count));
  StructType /*P*/ Ty = cast_StructType(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(StructTy));
  
  return IrLlvmGlobals.wrap_Value$C$P(ConstantStruct.get(Ty, makeArrayRef(Elements, Count)));
}


/**
* Get an element at specified index as a constant.
*
* @see ConstantDataSequential::getElementAsConstant()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetElementAsConstant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1005,
 FQN="LLVMGetElementAsConstant", NM="_Z24LLVMGetElementAsConstant",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMGetElementAsConstant")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetElementAsConstant( LLVMOpaqueValue /*P*/ C, /*uint*/int idx) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.<ConstantDataSequential>unwrap_LLVMOpaqueValue$P(ConstantDataSequential.class, C).getElementAsConstant(idx));
}


/**
* Create a ConstantVector from values.
*
* @see llvm::ConstantVector::get()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstVector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1048,
 FQN="LLVMConstVector", NM="_Z15LLVMConstVector",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstVector")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstVector(type$ptr<LLVMOpaqueValue /*P*/ /*P*/> ScalarConstantVals, /*uint*/int Size) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantVector.get(makeArrayRef(IrLlvmGlobals.<Constant>unwrap$T(Constant.class, ScalarConstantVals, Size), Size)));
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreValueConstantExpressions Constant Expressions
*
* Functions in this group correspond to APIs on llvm::ConstantExpr.
*
* @see llvm::ConstantExpr.
*
* @{
*/

/*--.. Constant expressions ................................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetConstOpcode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1077,
 FQN="LLVMGetConstOpcode", NM="_Z18LLVMGetConstOpcode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetConstOpcode")
//</editor-fold>
public static LLVMOpcode LLVMGetConstOpcode( LLVMOpaqueValue /*P*/ ConstantVal) {
  return map_to_llvmopcode(IrLlvmGlobals.<ConstantExpr>unwrap_LLVMOpaqueValue$P(ConstantExpr.class, ConstantVal).getOpcode());
}

//<editor-fold defaultstate="collapsed" desc="LLVMAlignOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1081,
 FQN="LLVMAlignOf", NM="_Z11LLVMAlignOf",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z11LLVMAlignOf")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMAlignOf( LLVMOpaqueType /*P*/ Ty) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getAlignOf(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMSizeOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1085,
 FQN="LLVMSizeOf", NM="_Z10LLVMSizeOf",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z10LLVMSizeOf")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMSizeOf( LLVMOpaqueType /*P*/ Ty) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getSizeOf(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNeg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1089,
 FQN="LLVMConstNeg", NM="_Z12LLVMConstNeg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstNeg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNeg( LLVMOpaqueValue /*P*/ ConstantVal) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getNeg(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNSWNeg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1093,
 FQN="LLVMConstNSWNeg", NM="_Z15LLVMConstNSWNeg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstNSWNeg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNSWNeg( LLVMOpaqueValue /*P*/ ConstantVal) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getNSWNeg(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNUWNeg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1097,
 FQN="LLVMConstNUWNeg", NM="_Z15LLVMConstNUWNeg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstNUWNeg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNUWNeg( LLVMOpaqueValue /*P*/ ConstantVal) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getNUWNeg(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFNeg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1102,
 FQN="LLVMConstFNeg", NM="_Z13LLVMConstFNeg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstFNeg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFNeg( LLVMOpaqueValue /*P*/ ConstantVal) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getFNeg(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNot">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1106,
 FQN="LLVMConstNot", NM="_Z12LLVMConstNot",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstNot")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNot( LLVMOpaqueValue /*P*/ ConstantVal) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getNot(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstAdd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1110,
 FQN="LLVMConstAdd", NM="_Z12LLVMConstAdd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstAdd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstAdd( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getAdd(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNSWAdd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1115,
 FQN="LLVMConstNSWAdd", NM="_Z15LLVMConstNSWAdd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstNSWAdd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNSWAdd( LLVMOpaqueValue /*P*/ LHSConstant, 
                LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getNSWAdd(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNUWAdd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1121,
 FQN="LLVMConstNUWAdd", NM="_Z15LLVMConstNUWAdd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstNUWAdd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNUWAdd( LLVMOpaqueValue /*P*/ LHSConstant, 
                LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getNUWAdd(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFAdd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1127,
 FQN="LLVMConstFAdd", NM="_Z13LLVMConstFAdd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstFAdd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFAdd( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getFAdd(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstSub">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1132,
 FQN="LLVMConstSub", NM="_Z12LLVMConstSub",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstSub")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstSub( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getSub(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNSWSub">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1137,
 FQN="LLVMConstNSWSub", NM="_Z15LLVMConstNSWSub",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstNSWSub")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNSWSub( LLVMOpaqueValue /*P*/ LHSConstant, 
                LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getNSWSub(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNUWSub">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1143,
 FQN="LLVMConstNUWSub", NM="_Z15LLVMConstNUWSub",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstNUWSub")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNUWSub( LLVMOpaqueValue /*P*/ LHSConstant, 
                LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getNUWSub(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFSub">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1149,
 FQN="LLVMConstFSub", NM="_Z13LLVMConstFSub",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstFSub")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFSub( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getFSub(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstMul">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1154,
 FQN="LLVMConstMul", NM="_Z12LLVMConstMul",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstMul")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstMul( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getMul(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNSWMul">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1159,
 FQN="LLVMConstNSWMul", NM="_Z15LLVMConstNSWMul",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstNSWMul")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNSWMul( LLVMOpaqueValue /*P*/ LHSConstant, 
                LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getNSWMul(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNUWMul">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1165,
 FQN="LLVMConstNUWMul", NM="_Z15LLVMConstNUWMul",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstNUWMul")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNUWMul( LLVMOpaqueValue /*P*/ LHSConstant, 
                LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getNUWMul(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFMul">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1171,
 FQN="LLVMConstFMul", NM="_Z13LLVMConstFMul",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstFMul")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFMul( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getFMul(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstUDiv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1176,
 FQN="LLVMConstUDiv", NM="_Z13LLVMConstUDiv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstUDiv")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstUDiv( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getUDiv(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstSDiv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1181,
 FQN="LLVMConstSDiv", NM="_Z13LLVMConstSDiv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstSDiv")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstSDiv( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getSDiv(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstExactSDiv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1186,
 FQN="LLVMConstExactSDiv", NM="_Z18LLVMConstExactSDiv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMConstExactSDiv")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstExactSDiv( LLVMOpaqueValue /*P*/ LHSConstant, 
                   LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getExactSDiv(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFDiv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1192,
 FQN="LLVMConstFDiv", NM="_Z13LLVMConstFDiv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstFDiv")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFDiv( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getFDiv(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstURem">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1197,
 FQN="LLVMConstURem", NM="_Z13LLVMConstURem",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstURem")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstURem( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getURem(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstSRem">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1202,
 FQN="LLVMConstSRem", NM="_Z13LLVMConstSRem",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstSRem")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstSRem( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getSRem(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFRem">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1207,
 FQN="LLVMConstFRem", NM="_Z13LLVMConstFRem",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstFRem")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFRem( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getFRem(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstAnd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1212,
 FQN="LLVMConstAnd", NM="_Z12LLVMConstAnd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstAnd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstAnd( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getAnd(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstOr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1217,
 FQN="LLVMConstOr", NM="_Z11LLVMConstOr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z11LLVMConstOr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstOr( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getOr(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstXor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1222,
 FQN="LLVMConstXor", NM="_Z12LLVMConstXor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstXor")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstXor( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getXor(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstICmp">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1227,
 FQN="LLVMConstICmp", NM="_Z13LLVMConstICmp",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstICmp")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstICmp(LLVMIntPredicate Predicate, 
              LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getICmp((char) Predicate.getValue(), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFCmp">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1234,
 FQN="LLVMConstFCmp", NM="_Z13LLVMConstFCmp",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstFCmp")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFCmp(LLVMRealPredicate Predicate, 
              LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getFCmp((char) Predicate.getValue(), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstShl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1241,
 FQN="LLVMConstShl", NM="_Z12LLVMConstShl",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstShl")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstShl( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getShl(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstLShr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1246,
 FQN="LLVMConstLShr", NM="_Z13LLVMConstLShr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstLShr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstLShr( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getLShr(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstAShr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1251,
 FQN="LLVMConstAShr", NM="_Z13LLVMConstAShr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstAShr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstAShr( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getAShr(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, LHSConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, RHSConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstGEP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1256,
 FQN="LLVMConstGEP", NM="_Z12LLVMConstGEP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstGEP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstGEP( LLVMOpaqueValue /*P*/ ConstantVal, 
            type$ptr<LLVMOpaqueValue /*P*/ /*P*/> ConstantIndices, /*uint*/int NumIndices) {
  ArrayRef<Constant /*P*/ > IdxList/*J*/= new ArrayRef<Constant /*P*/ >(IrLlvmGlobals.<Constant>unwrap$T(Constant.class, ConstantIndices, NumIndices), 
      NumIndices, true);
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P((Type /*P*/ )null, IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), new ArrayRef<Constant /*P*/ >(IdxList)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstInBoundsGEP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1264,
 FQN="LLVMConstInBoundsGEP", NM="_Z20LLVMConstInBoundsGEP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMConstInBoundsGEP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstInBoundsGEP( LLVMOpaqueValue /*P*/ ConstantVal, 
                    type$ptr<LLVMOpaqueValue /*P*/ /*P*/> ConstantIndices, 
                    /*uint*/int NumIndices) {
  Constant /*P*/ Val = IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal);
  ArrayRef<Constant /*P*/ > IdxList/*J*/= new ArrayRef<Constant /*P*/ >(IrLlvmGlobals.<Constant>unwrap$T(Constant.class, ConstantIndices, NumIndices), 
      NumIndices, true);
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getInBoundsGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P((Type /*P*/ )null, Val, new ArrayRef<Constant /*P*/ >(IdxList)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstTrunc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1273,
 FQN="LLVMConstTrunc", NM="_Z14LLVMConstTrunc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMConstTrunc")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstTrunc( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getTrunc(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ToType)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstSExt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1278,
 FQN="LLVMConstSExt", NM="_Z13LLVMConstSExt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstSExt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstSExt( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getSExt(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ToType)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstZExt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1283,
 FQN="LLVMConstZExt", NM="_Z13LLVMConstZExt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstZExt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstZExt( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getZExt(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ToType)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFPTrunc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1288,
 FQN="LLVMConstFPTrunc", NM="_Z16LLVMConstFPTrunc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMConstFPTrunc")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFPTrunc( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getFPTrunc(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ToType)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFPExt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1293,
 FQN="LLVMConstFPExt", NM="_Z14LLVMConstFPExt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMConstFPExt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFPExt( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getFPExtend(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ToType)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstUIToFP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1298,
 FQN="LLVMConstUIToFP", NM="_Z15LLVMConstUIToFP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstUIToFP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstUIToFP( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getUIToFP(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ToType)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstSIToFP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1303,
 FQN="LLVMConstSIToFP", NM="_Z15LLVMConstSIToFP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstSIToFP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstSIToFP( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getSIToFP(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ToType)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFPToUI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1308,
 FQN="LLVMConstFPToUI", NM="_Z15LLVMConstFPToUI",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstFPToUI")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFPToUI( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getFPToUI(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ToType)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFPToSI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1313,
 FQN="LLVMConstFPToSI", NM="_Z15LLVMConstFPToSI",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstFPToSI")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFPToSI( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getFPToSI(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ToType)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstPtrToInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1318,
 FQN="LLVMConstPtrToInt", NM="_Z17LLVMConstPtrToInt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMConstPtrToInt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstPtrToInt( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getPtrToInt(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ToType)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstIntToPtr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1323,
 FQN="LLVMConstIntToPtr", NM="_Z17LLVMConstIntToPtr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMConstIntToPtr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstIntToPtr( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getIntToPtr(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ToType)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstBitCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1328,
 FQN="LLVMConstBitCast", NM="_Z16LLVMConstBitCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMConstBitCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstBitCast( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getBitCast(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ToType)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstAddrSpaceCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1333,
 FQN="LLVMConstAddrSpaceCast", NM="_Z22LLVMConstAddrSpaceCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMConstAddrSpaceCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstAddrSpaceCast( LLVMOpaqueValue /*P*/ ConstantVal, 
                       LLVMOpaqueType /*P*/ ToType) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getAddrSpaceCast(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ToType)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstZExtOrBitCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1339,
 FQN="LLVMConstZExtOrBitCast", NM="_Z22LLVMConstZExtOrBitCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMConstZExtOrBitCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstZExtOrBitCast( LLVMOpaqueValue /*P*/ ConstantVal, 
                       LLVMOpaqueType /*P*/ ToType) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getZExtOrBitCast(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ToType)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstSExtOrBitCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1345,
 FQN="LLVMConstSExtOrBitCast", NM="_Z22LLVMConstSExtOrBitCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMConstSExtOrBitCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstSExtOrBitCast( LLVMOpaqueValue /*P*/ ConstantVal, 
                       LLVMOpaqueType /*P*/ ToType) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getSExtOrBitCast(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ToType)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstTruncOrBitCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1351,
 FQN="LLVMConstTruncOrBitCast", NM="_Z23LLVMConstTruncOrBitCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMConstTruncOrBitCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstTruncOrBitCast( LLVMOpaqueValue /*P*/ ConstantVal, 
                        LLVMOpaqueType /*P*/ ToType) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getTruncOrBitCast(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ToType)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstPointerCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1357,
 FQN="LLVMConstPointerCast", NM="_Z20LLVMConstPointerCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMConstPointerCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstPointerCast( LLVMOpaqueValue /*P*/ ConstantVal, 
                     LLVMOpaqueType /*P*/ ToType) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getPointerCast(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ToType)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstIntCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1363,
 FQN="LLVMConstIntCast", NM="_Z16LLVMConstIntCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMConstIntCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstIntCast( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType, 
                int isSigned) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getIntegerCast(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ToType), (isSigned != 0)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFPCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1369,
 FQN="LLVMConstFPCast", NM="_Z15LLVMConstFPCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstFPCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFPCast( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getFPCast(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(ToType)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstSelect">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1374,
 FQN="LLVMConstSelect", NM="_Z15LLVMConstSelect",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstSelect")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstSelect( LLVMOpaqueValue /*P*/ ConstantCondition, 
                LLVMOpaqueValue /*P*/ ConstantIfTrue, 
                LLVMOpaqueValue /*P*/ ConstantIfFalse) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getSelect(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantCondition), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantIfTrue), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantIfFalse)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstExtractElement">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1382,
 FQN="LLVMConstExtractElement", NM="_Z23LLVMConstExtractElement",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMConstExtractElement")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstExtractElement( LLVMOpaqueValue /*P*/ VectorConstant, 
                        LLVMOpaqueValue /*P*/ IndexConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getExtractElement(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, VectorConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, IndexConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstInsertElement">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1388,
 FQN="LLVMConstInsertElement", NM="_Z22LLVMConstInsertElement",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMConstInsertElement")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstInsertElement( LLVMOpaqueValue /*P*/ VectorConstant, 
                       LLVMOpaqueValue /*P*/ ElementValueConstant, 
                       LLVMOpaqueValue /*P*/ IndexConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getInsertElement(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, VectorConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ElementValueConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, IndexConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstShuffleVector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1396,
 FQN="LLVMConstShuffleVector", NM="_Z22LLVMConstShuffleVector",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMConstShuffleVector")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstShuffleVector( LLVMOpaqueValue /*P*/ VectorAConstant, 
                       LLVMOpaqueValue /*P*/ VectorBConstant, 
                       LLVMOpaqueValue /*P*/ MaskConstant) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getShuffleVector(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, VectorAConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, VectorBConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, MaskConstant)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstExtractValue">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1404,
 FQN="LLVMConstExtractValue", NM="_Z21LLVMConstExtractValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMConstExtractValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstExtractValue( LLVMOpaqueValue /*P*/ AggConstant, uint$ptr/*uint P*/ IdxList, 
                     /*uint*/int NumIdx) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getExtractValue(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, AggConstant), 
          makeArrayRef/*$UInt*/(IdxList, NumIdx)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstInsertValue">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1410,
 FQN="LLVMConstInsertValue", NM="_Z20LLVMConstInsertValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMConstInsertValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstInsertValue( LLVMOpaqueValue /*P*/ AggConstant, 
                     LLVMOpaqueValue /*P*/ ElementValueConstant, 
                    uint$ptr/*uint P*/ IdxList, /*uint*/int NumIdx) {
  return IrLlvmGlobals.wrap_Value$C$P(ConstantExpr.getInsertValue(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, AggConstant), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ElementValueConstant), 
          makeArrayRef/*$UInt*/(IdxList, NumIdx)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstInlineAsm">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1418,
 FQN="LLVMConstInlineAsm", NM="_Z18LLVMConstInlineAsm",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMConstInlineAsm")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstInlineAsm( LLVMOpaqueType /*P*/ Ty, /*const*/char$ptr/*char P*/ AsmString, 
                  /*const*/char$ptr/*char P*/ Constraints, 
                  int HasSideEffects, 
                  int IsAlignStack) {
  return IrLlvmGlobals.wrap_Value$C$P(InlineAsm.get(dyn_cast_FunctionType(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty)), new StringRef(AsmString), 
          new StringRef(Constraints), (HasSideEffects != 0), (IsAlignStack != 0)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBlockAddress">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1426,
 FQN="LLVMBlockAddress", NM="_Z16LLVMBlockAddress",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMBlockAddress")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBlockAddress( LLVMOpaqueValue /*P*/ F,  LLVMOpaqueBasicBlock /*P*/ BB) {
  return IrLlvmGlobals.wrap_Value$C$P(BlockAddress.get(IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, F), IrLlvmGlobals.unwrap(BB)));
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreValueConstantGlobals Global Values
*
* This group contains functions that operate on global values. Functions in
* this group relate to functions in the llvm::GlobalValue class tree.
*
* @see llvm::GlobalValue
*
* @{
*/

/*--.. Operations on global variables, functions, and aliases (globals) ....--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetGlobalParent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1432,
 FQN="LLVMGetGlobalParent", NM="_Z19LLVMGetGlobalParent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMGetGlobalParent")
//</editor-fold>
public static  LLVMOpaqueModule /*P*/ LLVMGetGlobalParent( LLVMOpaqueValue /*P*/ Global) {
  return IrLlvmGlobals.wrap(IrLlvmGlobals.<GlobalValue>unwrap_LLVMOpaqueValue$P(GlobalValue.class, Global).getParent());
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1436,
 FQN="LLVMIsDeclaration", NM="_Z17LLVMIsDeclaration",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsDeclaration")
//</editor-fold>
public static int LLVMIsDeclaration( LLVMOpaqueValue /*P*/ Global) {
  return (IrLlvmGlobals.<GlobalValue>unwrap_LLVMOpaqueValue$P(GlobalValue.class, Global).isDeclaration() ? 1 : 0);
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetLinkage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1440,
 FQN="LLVMGetLinkage", NM="_Z14LLVMGetLinkage",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMGetLinkage")
//</editor-fold>
public static LLVMLinkage LLVMGetLinkage( LLVMOpaqueValue /*P*/ Global) {
  switch (IrLlvmGlobals.<GlobalValue>unwrap_LLVMOpaqueValue$P(GlobalValue.class, Global).getLinkage()) {
   case ExternalLinkage:
    return LLVMLinkage.LLVMExternalLinkage;
   case AvailableExternallyLinkage:
    return LLVMLinkage.LLVMAvailableExternallyLinkage;
   case LinkOnceAnyLinkage:
    return LLVMLinkage.LLVMLinkOnceAnyLinkage;
   case LinkOnceODRLinkage:
    return LLVMLinkage.LLVMLinkOnceODRLinkage;
   case WeakAnyLinkage:
    return LLVMLinkage.LLVMWeakAnyLinkage;
   case WeakODRLinkage:
    return LLVMLinkage.LLVMWeakODRLinkage;
   case AppendingLinkage:
    return LLVMLinkage.LLVMAppendingLinkage;
   case InternalLinkage:
    return LLVMLinkage.LLVMInternalLinkage;
   case PrivateLinkage:
    return LLVMLinkage.LLVMPrivateLinkage;
   case ExternalWeakLinkage:
    return LLVMLinkage.LLVMExternalWeakLinkage;
   case CommonLinkage:
    return LLVMLinkage.LLVMCommonLinkage;
  }
  throw new llvm_unreachable("Invalid GlobalValue linkage!");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetLinkage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1469,
 FQN="LLVMSetLinkage", NM="_Z14LLVMSetLinkage",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMSetLinkage")
//</editor-fold>
public static void LLVMSetLinkage( LLVMOpaqueValue /*P*/ Global, LLVMLinkage Linkage) {
  GlobalValue /*P*/ GV = IrLlvmGlobals.<GlobalValue>unwrap_LLVMOpaqueValue$P(GlobalValue.class, Global);
  switch (Linkage) {
   case LLVMExternalLinkage:
    GV.setLinkage(GlobalValue.LinkageTypes.ExternalLinkage);
    break;
   case LLVMAvailableExternallyLinkage:
    GV.setLinkage(GlobalValue.LinkageTypes.AvailableExternallyLinkage);
    break;
   case LLVMLinkOnceAnyLinkage:
    GV.setLinkage(GlobalValue.LinkageTypes.LinkOnceAnyLinkage);
    break;
   case LLVMLinkOnceODRLinkage:
    GV.setLinkage(GlobalValue.LinkageTypes.LinkOnceODRLinkage);
    break;
   case LLVMLinkOnceODRAutoHideLinkage:
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"ir")) {
        errs().$out(/*KEEP_STR*/"LLVMSetLinkage(): LLVMLinkOnceODRAutoHideLinkage is no longer supported.");
      }
    } while (false);
    break;
   case LLVMWeakAnyLinkage:
    GV.setLinkage(GlobalValue.LinkageTypes.WeakAnyLinkage);
    break;
   case LLVMWeakODRLinkage:
    GV.setLinkage(GlobalValue.LinkageTypes.WeakODRLinkage);
    break;
   case LLVMAppendingLinkage:
    GV.setLinkage(GlobalValue.LinkageTypes.AppendingLinkage);
    break;
   case LLVMInternalLinkage:
    GV.setLinkage(GlobalValue.LinkageTypes.InternalLinkage);
    break;
   case LLVMPrivateLinkage:
    GV.setLinkage(GlobalValue.LinkageTypes.PrivateLinkage);
    break;
   case LLVMLinkerPrivateLinkage:
    GV.setLinkage(GlobalValue.LinkageTypes.PrivateLinkage);
    break;
   case LLVMLinkerPrivateWeakLinkage:
    GV.setLinkage(GlobalValue.LinkageTypes.PrivateLinkage);
    break;
   case LLVMDLLImportLinkage:
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"ir")) {
        errs().$out(/*KEEP_STR*/"LLVMSetLinkage(): LLVMDLLImportLinkage is no longer supported.");
      }
    } while (false);
    break;
   case LLVMDLLExportLinkage:
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"ir")) {
        errs().$out(/*KEEP_STR*/"LLVMSetLinkage(): LLVMDLLExportLinkage is no longer supported.");
      }
    } while (false);
    break;
   case LLVMExternalWeakLinkage:
    GV.setLinkage(GlobalValue.LinkageTypes.ExternalWeakLinkage);
    break;
   case LLVMGhostLinkage:
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"ir")) {
        errs().$out(/*KEEP_STR*/"LLVMSetLinkage(): LLVMGhostLinkage is no longer supported.");
      }
    } while (false);
    break;
   case LLVMCommonLinkage:
    GV.setLinkage(GlobalValue.LinkageTypes.CommonLinkage);
    break;
  }
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetSection">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1531,
 FQN="LLVMGetSection", NM="_Z14LLVMGetSection",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMGetSection")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetSection( LLVMOpaqueValue /*P*/ Global) {
  // Using .data() is safe because of how GlobalObject::setSection is
  // implemented.
  return IrLlvmGlobals.<GlobalValue>unwrap_LLVMOpaqueValue$P(GlobalValue.class, Global).getSection().data();
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetSection">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1537,
 FQN="LLVMSetSection", NM="_Z14LLVMSetSection",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMSetSection")
//</editor-fold>
public static void LLVMSetSection( LLVMOpaqueValue /*P*/ Global, /*const*/char$ptr/*char P*/ Section) {
  IrLlvmGlobals.<GlobalObject>unwrap_LLVMOpaqueValue$P(GlobalObject.class, Global).setSection(new StringRef(Section));
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetVisibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1541,
 FQN="LLVMGetVisibility", NM="_Z17LLVMGetVisibility",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetVisibility")
//</editor-fold>
public static LLVMVisibility LLVMGetVisibility( LLVMOpaqueValue /*P*/ Global) {
  return /*static_cast*/LLVMVisibility.valueOf(IrLlvmGlobals.<GlobalValue>unwrap_LLVMOpaqueValue$P(GlobalValue.class, Global).getVisibility().getValue());
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetVisibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1546,
 FQN="LLVMSetVisibility", NM="_Z17LLVMSetVisibility",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMSetVisibility")
//</editor-fold>
public static void LLVMSetVisibility( LLVMOpaqueValue /*P*/ Global, LLVMVisibility Viz) {
  IrLlvmGlobals.<GlobalValue>unwrap_LLVMOpaqueValue$P(GlobalValue.class, Global).
      setVisibility(/*static_cast*/GlobalValue.VisibilityTypes.valueOf(Viz.getValue()));
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetDLLStorageClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1551,
 FQN="LLVMGetDLLStorageClass", NM="_Z22LLVMGetDLLStorageClass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMGetDLLStorageClass")
//</editor-fold>
public static LLVMDLLStorageClass LLVMGetDLLStorageClass( LLVMOpaqueValue /*P*/ Global) {
  return /*static_cast*/LLVMDLLStorageClass.valueOf(IrLlvmGlobals.<GlobalValue>unwrap_LLVMOpaqueValue$P(GlobalValue.class, Global).getDLLStorageClass().getValue());
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetDLLStorageClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1556,
 FQN="LLVMSetDLLStorageClass", NM="_Z22LLVMSetDLLStorageClass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMSetDLLStorageClass")
//</editor-fold>
public static void LLVMSetDLLStorageClass( LLVMOpaqueValue /*P*/ Global, LLVMDLLStorageClass Class) {
  IrLlvmGlobals.<GlobalValue>unwrap_LLVMOpaqueValue$P(GlobalValue.class, Global).setDLLStorageClass(/*static_cast*/GlobalValue.DLLStorageClassTypes.valueOf(Class.getValue()));
}

//<editor-fold defaultstate="collapsed" desc="LLVMHasUnnamedAddr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1561,
 FQN="LLVMHasUnnamedAddr", NM="_Z18LLVMHasUnnamedAddr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMHasUnnamedAddr")
//</editor-fold>
public static int LLVMHasUnnamedAddr( LLVMOpaqueValue /*P*/ Global) {
  return (IrLlvmGlobals.<GlobalValue>unwrap_LLVMOpaqueValue$P(GlobalValue.class, Global).hasGlobalUnnamedAddr() ? 1 : 0);
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetUnnamedAddr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1565,
 FQN="LLVMSetUnnamedAddr", NM="_Z18LLVMSetUnnamedAddr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMSetUnnamedAddr")
//</editor-fold>
public static void LLVMSetUnnamedAddr( LLVMOpaqueValue /*P*/ Global, int HasUnnamedAddr) {
  IrLlvmGlobals.<GlobalValue>unwrap_LLVMOpaqueValue$P(GlobalValue.class, Global).setUnnamedAddr((HasUnnamedAddr != 0) ? GlobalValue.UnnamedAddr.Global : GlobalValue.UnnamedAddr.None);
}


/**
* @defgroup LLVMCCoreValueWithAlignment Values with alignment
*
* Functions in this group only apply to values with alignment, i.e.
* global variables, load and store instructions.
*/

/**
* Obtain the preferred alignment of the value.
* @see llvm::AllocaInst::getAlignment()
* @see llvm::LoadInst::getAlignment()
* @see llvm::StoreInst::getAlignment()
* @see llvm::GlobalValue::getAlignment()
*/

/*--.. Operations on global variables, load and store instructions .........--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetAlignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1573,
 FQN="LLVMGetAlignment", NM="_Z16LLVMGetAlignment",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMGetAlignment")
//</editor-fold>
public static /*uint*/int LLVMGetAlignment( LLVMOpaqueValue /*P*/ V) {
  Value /*P*/ P = IrLlvmGlobals.<Value>unwrap_LLVMOpaqueValue$P(Value.class, V);
  {
    GlobalValue /*P*/ GV = dyn_cast_GlobalValue(P);
    if ((GV != null)) {
      return GV.getAlignment();
    }
  }
  {
    AllocaInst /*P*/ AI = dyn_cast_AllocaInst(P);
    if ((AI != null)) {
      return AI.getAlignment();
    }
  }
  {
    LoadInst /*P*/ LI = dyn_cast_LoadInst(P);
    if ((LI != null)) {
      return LI.getAlignment();
    }
  }
  {
    StoreInst /*P*/ SI = dyn_cast_StoreInst(P);
    if ((SI != null)) {
      return SI.getAlignment();
    }
  }
  throw new llvm_unreachable("only GlobalValue, AllocaInst, LoadInst and StoreInst have alignment");
}


/**
* Set the preferred alignment of the value.
* @see llvm::AllocaInst::setAlignment()
* @see llvm::LoadInst::setAlignment()
* @see llvm::StoreInst::setAlignment()
* @see llvm::GlobalValue::setAlignment()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetAlignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1588,
 FQN="LLVMSetAlignment", NM="_Z16LLVMSetAlignment",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMSetAlignment")
//</editor-fold>
public static void LLVMSetAlignment( LLVMOpaqueValue /*P*/ V, /*uint*/int Bytes) {
  Value /*P*/ P = IrLlvmGlobals.<Value>unwrap_LLVMOpaqueValue$P(Value.class, V);
  {
    GlobalObject /*P*/ GV = dyn_cast_GlobalObject(P);
    if ((GV != null)) {
      GV.setAlignment(Bytes);
    } else {
      AllocaInst /*P*/ AI = dyn_cast_AllocaInst(P);
      if ((AI != null)) {
        AI.setAlignment(Bytes);
      } else {
        LoadInst /*P*/ LI = dyn_cast_LoadInst(P);
        if ((LI != null)) {
          LI.setAlignment(Bytes);
        } else {
          StoreInst /*P*/ SI = dyn_cast_StoreInst(P);
          if ((SI != null)) {
            SI.setAlignment(Bytes);
          } else {
            throw new llvm_unreachable("only GlobalValue, AllocaInst, LoadInst and StoreInst have alignment");
          }
        }
      }
    }
  }
}


/**
* @}
*/

/**
* @defgroup LLVMCoreValueConstantGlobalVariable Global Variables
*
* This group contains functions that operate on global variable values.
*
* @see llvm::GlobalVariable
*
* @{
*/

/*--.. Operations on global variables ......................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMAddGlobal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1605,
 FQN="LLVMAddGlobal", NM="_Z13LLVMAddGlobal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMAddGlobal")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMAddGlobal( LLVMOpaqueModule /*P*/ M,  LLVMOpaqueType /*P*/ Ty, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(/*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable($Deref(IrLlvmGlobals.unwrap(M)), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty), false, 
                  GlobalValue.LinkageTypes.ExternalLinkage, (Constant /*P*/ )null, new Twine(Name));
       }));
}

//<editor-fold defaultstate="collapsed" desc="LLVMAddGlobalInAddressSpace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1610,
 FQN="LLVMAddGlobalInAddressSpace", NM="_Z27LLVMAddGlobalInAddressSpace",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMAddGlobalInAddressSpace")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMAddGlobalInAddressSpace( LLVMOpaqueModule /*P*/ M,  LLVMOpaqueType /*P*/ Ty, 
                           /*const*/char$ptr/*char P*/ Name, 
                           /*uint*/int AddressSpace) {
  return IrLlvmGlobals.wrap_Value$C$P(/*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable($Deref(IrLlvmGlobals.unwrap(M)), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty), false, 
                  GlobalValue.LinkageTypes.ExternalLinkage, (Constant /*P*/ )null, new Twine(Name), 
                  (GlobalVariable /*P*/ )null, GlobalVariable.ThreadLocalMode.NotThreadLocal, 
                  AddressSpace);
       }));
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetNamedGlobal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1619,
 FQN="LLVMGetNamedGlobal", NM="_Z18LLVMGetNamedGlobal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetNamedGlobal")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetNamedGlobal( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(M).getNamedGlobal(new StringRef(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetFirstGlobal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1623,
 FQN="LLVMGetFirstGlobal", NM="_Z18LLVMGetFirstGlobal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetFirstGlobal")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetFirstGlobal( LLVMOpaqueModule /*P*/ M) {
  Module /*P*/ Mod = IrLlvmGlobals.unwrap(M);
  ilist_iterator<GlobalVariable> I = Mod.global_begin();
  if (I.$eq(Mod.global_end())) {
    return null;
  }
  return IrLlvmGlobals.wrap_Value$C$P($AddrOf(I.$star()));
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetLastGlobal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1631,
 FQN="LLVMGetLastGlobal", NM="_Z17LLVMGetLastGlobal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetLastGlobal")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetLastGlobal( LLVMOpaqueModule /*P*/ M) {
  Module /*P*/ Mod = IrLlvmGlobals.unwrap(M);
  ilist_iterator<GlobalVariable> I = Mod.global_end();
  if (I.$eq(Mod.global_begin())) {
    return null;
  }
  return IrLlvmGlobals.wrap_Value$C$P($AddrOf(I.$preDec().$star()));
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetNextGlobal">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1639,
 FQN="LLVMGetNextGlobal", NM="_Z17LLVMGetNextGlobal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetNextGlobal")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetNextGlobal( LLVMOpaqueValue /*P*/ GlobalVar) {
  GlobalVariable /*P*/ GV = IrLlvmGlobals.<GlobalVariable>unwrap_LLVMOpaqueValue$P(GlobalVariable.class, GlobalVar);
  ilist_iterator<GlobalVariable> I/*J*/= new ilist_iterator<GlobalVariable>(GV, ilist_traits_IR.ilist_traits$GlobalVariable());
  if (I.$preInc().$eq(GV.getParent().global_end())) {
    return null;
  }
  return IrLlvmGlobals.wrap_Value$C$P($AddrOf(I.$star()));
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetPreviousGlobal">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1647,
 FQN="LLVMGetPreviousGlobal", NM="_Z21LLVMGetPreviousGlobal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMGetPreviousGlobal")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetPreviousGlobal( LLVMOpaqueValue /*P*/ GlobalVar) {
  GlobalVariable /*P*/ GV = IrLlvmGlobals.<GlobalVariable>unwrap_LLVMOpaqueValue$P(GlobalVariable.class, GlobalVar);
  ilist_iterator<GlobalVariable> I/*J*/= new ilist_iterator<GlobalVariable>(GV, ilist_traits_IR.ilist_traits$GlobalVariable());
  if (I.$eq(GV.getParent().global_begin())) {
    return null;
  }
  return IrLlvmGlobals.wrap_Value$C$P($AddrOf(I.$preDec().$star()));
}

//<editor-fold defaultstate="collapsed" desc="LLVMDeleteGlobal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1655,
 FQN="LLVMDeleteGlobal", NM="_Z16LLVMDeleteGlobal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMDeleteGlobal")
//</editor-fold>
public static void LLVMDeleteGlobal( LLVMOpaqueValue /*P*/ GlobalVar) {
  IrLlvmGlobals.<GlobalVariable>unwrap_LLVMOpaqueValue$P(GlobalVariable.class, GlobalVar).eraseFromParent();
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1659,
 FQN="LLVMGetInitializer", NM="_Z18LLVMGetInitializer",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetInitializer")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetInitializer( LLVMOpaqueValue /*P*/ GlobalVar) {
  GlobalVariable /*P*/ GV = IrLlvmGlobals.<GlobalVariable>unwrap_LLVMOpaqueValue$P(GlobalVariable.class, GlobalVar);
  if (!GV.hasInitializer()) {
    return null;
  }
  return IrLlvmGlobals.wrap_Value$C$P(GV.getInitializer());
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1666,
 FQN="LLVMSetInitializer", NM="_Z18LLVMSetInitializer",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMSetInitializer")
//</editor-fold>
public static void LLVMSetInitializer( LLVMOpaqueValue /*P*/ GlobalVar,  LLVMOpaqueValue /*P*/ ConstantVal) {
  IrLlvmGlobals.<GlobalVariable>unwrap_LLVMOpaqueValue$P(GlobalVariable.class, GlobalVar).
      setInitializer(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, ConstantVal));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsThreadLocal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1671,
 FQN="LLVMIsThreadLocal", NM="_Z17LLVMIsThreadLocal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsThreadLocal")
//</editor-fold>
public static int LLVMIsThreadLocal( LLVMOpaqueValue /*P*/ GlobalVar) {
  return (IrLlvmGlobals.<GlobalVariable>unwrap_LLVMOpaqueValue$P(GlobalVariable.class, GlobalVar).isThreadLocal() ? 1 : 0);
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetThreadLocal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1675,
 FQN="LLVMSetThreadLocal", NM="_Z18LLVMSetThreadLocal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMSetThreadLocal")
//</editor-fold>
public static void LLVMSetThreadLocal( LLVMOpaqueValue /*P*/ GlobalVar, int IsThreadLocal) {
  IrLlvmGlobals.<GlobalVariable>unwrap_LLVMOpaqueValue$P(GlobalVariable.class, GlobalVar).setThreadLocal(IsThreadLocal != 0);
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsGlobalConstant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1679,
 FQN="LLVMIsGlobalConstant", NM="_Z20LLVMIsGlobalConstant",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMIsGlobalConstant")
//</editor-fold>
public static int LLVMIsGlobalConstant( LLVMOpaqueValue /*P*/ GlobalVar) {
  return (IrLlvmGlobals.<GlobalVariable>unwrap_LLVMOpaqueValue$P(GlobalVariable.class, GlobalVar).isConstant() ? 1 : 0);
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetGlobalConstant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1683,
 FQN="LLVMSetGlobalConstant", NM="_Z21LLVMSetGlobalConstant",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMSetGlobalConstant")
//</editor-fold>
public static void LLVMSetGlobalConstant( LLVMOpaqueValue /*P*/ GlobalVar, int IsConstant) {
  IrLlvmGlobals.<GlobalVariable>unwrap_LLVMOpaqueValue$P(GlobalVariable.class, GlobalVar).setConstant(IsConstant != 0);
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetThreadLocalMode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1687,
 FQN="LLVMGetThreadLocalMode", NM="_Z22LLVMGetThreadLocalMode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMGetThreadLocalMode")
//</editor-fold>
public static LLVMThreadLocalMode LLVMGetThreadLocalMode( LLVMOpaqueValue /*P*/ GlobalVar) {
  switch (IrLlvmGlobals.<GlobalVariable>unwrap_LLVMOpaqueValue$P(GlobalVariable.class, GlobalVar).getThreadLocalMode()) {
   case NotThreadLocal:
    return LLVMThreadLocalMode.LLVMNotThreadLocal;
   case GeneralDynamicTLSModel:
    return LLVMThreadLocalMode.LLVMGeneralDynamicTLSModel;
   case LocalDynamicTLSModel:
    return LLVMThreadLocalMode.LLVMLocalDynamicTLSModel;
   case InitialExecTLSModel:
    return LLVMThreadLocalMode.LLVMInitialExecTLSModel;
   case LocalExecTLSModel:
    return LLVMThreadLocalMode.LLVMLocalExecTLSModel;
  }
  throw new llvm_unreachable("Invalid GlobalVariable thread local mode");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetThreadLocalMode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1704,
 FQN="LLVMSetThreadLocalMode", NM="_Z22LLVMSetThreadLocalMode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMSetThreadLocalMode")
//</editor-fold>
public static void LLVMSetThreadLocalMode( LLVMOpaqueValue /*P*/ GlobalVar, LLVMThreadLocalMode Mode) {
  GlobalVariable /*P*/ GV = IrLlvmGlobals.<GlobalVariable>unwrap_LLVMOpaqueValue$P(GlobalVariable.class, GlobalVar);
  switch (Mode) {
   case LLVMNotThreadLocal:
    GV.setThreadLocalMode(GlobalVariable.ThreadLocalMode.NotThreadLocal);
    break;
   case LLVMGeneralDynamicTLSModel:
    GV.setThreadLocalMode(GlobalVariable.ThreadLocalMode.GeneralDynamicTLSModel);
    break;
   case LLVMLocalDynamicTLSModel:
    GV.setThreadLocalMode(GlobalVariable.ThreadLocalMode.LocalDynamicTLSModel);
    break;
   case LLVMInitialExecTLSModel:
    GV.setThreadLocalMode(GlobalVariable.ThreadLocalMode.InitialExecTLSModel);
    break;
   case LLVMLocalExecTLSModel:
    GV.setThreadLocalMode(GlobalVariable.ThreadLocalMode.LocalExecTLSModel);
    break;
  }
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsExternallyInitialized">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1726,
 FQN="LLVMIsExternallyInitialized", NM="_Z27LLVMIsExternallyInitialized",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMIsExternallyInitialized")
//</editor-fold>
public static int LLVMIsExternallyInitialized( LLVMOpaqueValue /*P*/ GlobalVar) {
  return (IrLlvmGlobals.<GlobalVariable>unwrap_LLVMOpaqueValue$P(GlobalVariable.class, GlobalVar).isExternallyInitialized() ? 1 : 0);
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetExternallyInitialized">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1730,
 FQN="LLVMSetExternallyInitialized", NM="_Z28LLVMSetExternallyInitialized",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z28LLVMSetExternallyInitialized")
//</editor-fold>
public static void LLVMSetExternallyInitialized( LLVMOpaqueValue /*P*/ GlobalVar, int IsExtInit) {
  IrLlvmGlobals.<GlobalVariable>unwrap_LLVMOpaqueValue$P(GlobalVariable.class, GlobalVar).setExternallyInitialized((IsExtInit != 0));
}


/**
* @}
*/

/**
* @defgroup LLVMCoreValueConstantGlobalAlias Global Aliases
*
* This group contains function that operate on global alias values.
*
* @see llvm::GlobalAlias
*
* @{
*/

/*--.. Operations on aliases ......................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMAddAlias">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1736,
 FQN="LLVMAddAlias", NM="_Z12LLVMAddAlias",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMAddAlias")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMAddAlias( LLVMOpaqueModule /*P*/ M,  LLVMOpaqueType /*P*/ Ty,  LLVMOpaqueValue /*P*/ Aliasee, 
            /*const*/char$ptr/*char P*/ Name) {
  PointerType /*P*/ PTy = cast_PointerType(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty));
  return IrLlvmGlobals.wrap_Value$C$P(GlobalAlias.create(PTy.getElementType(), PTy.getAddressSpace(), 
          GlobalValue.LinkageTypes.ExternalLinkage, new Twine(Name), 
          IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, Aliasee), IrLlvmGlobals.unwrap(M)));
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreValueFunction Function values
*
* Functions in this group operate on LLVMValueRef instances that
* correspond to llvm::Function instances.
*
* @see llvm::Function
*
* @{
*/

/**
* Remove a function from its containing module and deletes it.
*
* @see llvm::Function::eraseFromParent()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMDeleteFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1788,
 FQN="LLVMDeleteFunction", NM="_Z18LLVMDeleteFunction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMDeleteFunction")
//</editor-fold>
public static void LLVMDeleteFunction( LLVMOpaqueValue /*P*/ Fn) {
  IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, Fn).eraseFromParent();
}


/**
* Check whether the given function has a personality function.
*
* @see llvm::Function::hasPersonalityFn()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMHasPersonalityFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1792,
 FQN="LLVMHasPersonalityFn", NM="_Z20LLVMHasPersonalityFn",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMHasPersonalityFn")
//</editor-fold>
public static int LLVMHasPersonalityFn( LLVMOpaqueValue /*P*/ Fn) {
  return (IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, Fn).hasPersonalityFn() ? 1 : 0);
}


/**
* Obtain the personality function attached to the function.
*
* @see llvm::Function::getPersonalityFn()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetPersonalityFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1796,
 FQN="LLVMGetPersonalityFn", NM="_Z20LLVMGetPersonalityFn",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetPersonalityFn")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetPersonalityFn( LLVMOpaqueValue /*P*/ Fn) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, Fn).getPersonalityFn());
}


/**
* Set the personality function attached to the function.
*
* @see llvm::Function::setPersonalityFn()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetPersonalityFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1800,
 FQN="LLVMSetPersonalityFn", NM="_Z20LLVMSetPersonalityFn",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMSetPersonalityFn")
//</editor-fold>
public static void LLVMSetPersonalityFn( LLVMOpaqueValue /*P*/ Fn,  LLVMOpaqueValue /*P*/ PersonalityFn) {
  IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, Fn).setPersonalityFn(IrLlvmGlobals.<Constant>unwrap_LLVMOpaqueValue$P(Constant.class, PersonalityFn));
}


/**
* Obtain the ID number from a function instance.
*
* @see llvm::Function::getIntrinsicID()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetIntrinsicID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1804,
 FQN="LLVMGetIntrinsicID", NM="_Z18LLVMGetIntrinsicID",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetIntrinsicID")
//</editor-fold>
public static /*uint*/int LLVMGetIntrinsicID( LLVMOpaqueValue /*P*/ Fn) {
  {
    Function /*P*/ F = dyn_cast_Function(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Fn));
    if ((F != null)) {
      return F.getIntrinsicID();
    }
  }
  return 0;
}


/**
* Obtain the calling function of a function.
*
* The returned value corresponds to the LLVMCallConv enumeration.
*
* @see llvm::Function::getCallingConv()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetFunctionCallConv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1810,
 FQN="LLVMGetFunctionCallConv", NM="_Z23LLVMGetFunctionCallConv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMGetFunctionCallConv")
//</editor-fold>
public static /*uint*/int LLVMGetFunctionCallConv( LLVMOpaqueValue /*P*/ Fn) {
  return IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, Fn).getCallingConv();
}


/**
* Set the calling convention of a function.
*
* @see llvm::Function::setCallingConv()
*
* @param Fn Function to operate on
* @param CC LLVMCallConv to set calling convention to
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetFunctionCallConv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1814,
 FQN="LLVMSetFunctionCallConv", NM="_Z23LLVMSetFunctionCallConv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMSetFunctionCallConv")
//</editor-fold>
public static void LLVMSetFunctionCallConv( LLVMOpaqueValue /*P*/ Fn, /*uint*/int CC) {
  IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, Fn).setCallingConv(((/*static_cast*//*uint*/int)(CC)));
  /*JAVA:return*/return;
}


/**
* Obtain the name of the garbage collector to use during code
* generation.
*
* @see llvm::Function::getGC()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetGC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1819,
 FQN="LLVMGetGC", NM="_Z9LLVMGetGC",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z9LLVMGetGC")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetGC( LLVMOpaqueValue /*P*/ Fn) {
  Function /*P*/ F = IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, Fn);
  return F.hasGC() ? F.getGC().c_str() : null;
}


/**
* Define the garbage collector to use during code generation.
*
* @see llvm::Function::setGC()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetGC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1824,
 FQN="LLVMSetGC", NM="_Z9LLVMSetGC",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z9LLVMSetGC")
//</editor-fold>
public static void LLVMSetGC( LLVMOpaqueValue /*P*/ Fn, /*const*/char$ptr/*char P*/ GC) {
  Function /*P*/ F = IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, Fn);
  if (Native.$bool(GC)) {
    F.setGC(new std.string(JD$T$C$P_T2$C$R.INSTANCE, GC));
  } else {
    F.clearGC();
  }
}


/**
* Add an attribute to a function.
*
* @see llvm::Function::addAttribute()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMAddFunctionAttr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1832,
 FQN="LLVMAddFunctionAttr", NM="_Z19LLVMAddFunctionAttr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMAddFunctionAttr")
//</editor-fold>
public static void LLVMAddFunctionAttr( LLVMOpaqueValue /*P*/ Fn, int/*LLVMAttribute*/ PA) {
  AttrBuilder B = null;
  try {
    Function /*P*/ Func = IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, Fn);
    /*const*/ AttributeSet PAL = Func.getAttributes();
    B/*J*/= new AttrBuilder($int2ulong(PA));
    /*const*/ AttributeSet PALnew = PAL.addAttributes(Func.getContext(), AttributeSet.AttrIndex.FunctionIndex.getValue(), 
        AttributeSet.get(Func.getContext(), 
            AttributeSet.AttrIndex.FunctionIndex.getValue(), B));
    Func.setAttributes(new AttributeSet(PALnew));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="LLVMAddAttributeAtIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1843,
 FQN="LLVMAddAttributeAtIndex", NM="_Z23LLVMAddAttributeAtIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMAddAttributeAtIndex")
//</editor-fold>
public static void LLVMAddAttributeAtIndex( LLVMOpaqueValue /*P*/ F, /*uint*/int Idx, 
                        LLVMOpaqueAttributeRef /*P*/ A) {
  IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, F).addAttribute(Idx, IrLlvmGlobals.unwrap(A));
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetAttributeCountAtIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1848,
 FQN="LLVMGetAttributeCountAtIndex", NM="_Z28LLVMGetAttributeCountAtIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z28LLVMGetAttributeCountAtIndex")
//</editor-fold>
public static /*uint*/int LLVMGetAttributeCountAtIndex( LLVMOpaqueValue /*P*/ F, /*uint*/int Idx) {
  AttributeSetNode /*P*/ ASN = AttributeSetNode.get(IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, F).getAttributes(), Idx);
  return ASN.getNumAttributes();
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetAttributesAtIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1853,
 FQN="LLVMGetAttributesAtIndex", NM="_Z24LLVMGetAttributesAtIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMGetAttributesAtIndex")
//</editor-fold>
public static void LLVMGetAttributesAtIndex( LLVMOpaqueValue /*P*/ F, /*uint*/int Idx, 
                        type$ptr<LLVMOpaqueAttributeRef /*P*/ /*P*/> Attrs) {
  AttributeSetNode /*P*/ ASN = AttributeSetNode.get(IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, F).getAttributes(), Idx);
  for (Attribute A : make_range(ASN.begin(), ASN.end()))  {
    Attrs.$postInc().$set(IrLlvmGlobals.wrap(new Attribute(A)));
  }
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetEnumAttributeAtIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1860,
 FQN="LLVMGetEnumAttributeAtIndex", NM="_Z27LLVMGetEnumAttributeAtIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMGetEnumAttributeAtIndex")
//</editor-fold>
public static  LLVMOpaqueAttributeRef /*P*/ LLVMGetEnumAttributeAtIndex( LLVMOpaqueValue /*P*/ F, 
                           /*uint*/int Idx, 
                           /*uint*/int KindID) {
  return IrLlvmGlobals.wrap(IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, F).getAttribute(Idx, 
          Attribute.AttrKind.valueOf(KindID)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetStringAttributeAtIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1867,
 FQN="LLVMGetStringAttributeAtIndex", NM="_Z29LLVMGetStringAttributeAtIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMGetStringAttributeAtIndex")
//</editor-fold>
public static  LLVMOpaqueAttributeRef /*P*/ LLVMGetStringAttributeAtIndex( LLVMOpaqueValue /*P*/ F, 
                             /*uint*/int Idx, 
                             /*const*/char$ptr/*char P*/ K, /*uint*/int KLen) {
  return IrLlvmGlobals.wrap(IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, F).getAttribute(Idx, new StringRef(K, KLen)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMRemoveEnumAttributeAtIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1873,
 FQN="LLVMRemoveEnumAttributeAtIndex", NM="_Z30LLVMRemoveEnumAttributeAtIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z30LLVMRemoveEnumAttributeAtIndex")
//</editor-fold>
public static void LLVMRemoveEnumAttributeAtIndex( LLVMOpaqueValue /*P*/ F, /*uint*/int Idx, 
                              /*uint*/int KindID) {
  IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, F).removeAttribute(Idx, Attribute.AttrKind.valueOf(KindID));
}

//<editor-fold defaultstate="collapsed" desc="LLVMRemoveStringAttributeAtIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1878,
 FQN="LLVMRemoveStringAttributeAtIndex", NM="_Z32LLVMRemoveStringAttributeAtIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z32LLVMRemoveStringAttributeAtIndex")
//</editor-fold>
public static void LLVMRemoveStringAttributeAtIndex( LLVMOpaqueValue /*P*/ F, /*uint*/int Idx, 
                                /*const*/char$ptr/*char P*/ K, /*uint*/int KLen) {
  IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, F).removeAttribute(Idx, new StringRef(K, KLen));
}


/**
* Add a target-dependent attribute to a function
* @see llvm::AttrBuilder::addAttribute()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMAddTargetDependentFunctionAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1883,
 FQN="LLVMAddTargetDependentFunctionAttr", NM="_Z34LLVMAddTargetDependentFunctionAttr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z34LLVMAddTargetDependentFunctionAttr")
//</editor-fold>
public static void LLVMAddTargetDependentFunctionAttr( LLVMOpaqueValue /*P*/ Fn, /*const*/char$ptr/*char P*/ A, 
                                  /*const*/char$ptr/*char P*/ V) {
  AttrBuilder B = null;
  try {
    Function /*P*/ Func = IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, Fn);
    AttributeSet.AttrIndex Idx = ((AttributeSet.AttrIndex)(AttributeSet.AttrIndex.FunctionIndex));
    B/*J*/= new AttrBuilder();
    
    B.addAttribute(new StringRef(A), new StringRef(V));
    AttributeSet Set = AttributeSet.get(Func.getContext(), Idx.getValue(), B);
    Func.addAttributes(Idx.getValue(), new AttributeSet(Set));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}


/**
* Obtain an attribute from a function.
*
* @see llvm::Function::getAttributes()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetFunctionAttr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1906,
 FQN="LLVMGetFunctionAttr", NM="_Z19LLVMGetFunctionAttr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMGetFunctionAttr")
//</editor-fold>
public static int/*LLVMAttribute*/ LLVMGetFunctionAttr( LLVMOpaqueValue /*P*/ Fn) {
  Function /*P*/ Func = IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, Fn);
  /*const*/ AttributeSet PAL = Func.getAttributes();
  return /*(LLVMAttribute)*/(int)PAL.Raw(AttributeSet.AttrIndex.FunctionIndex.getValue());
}


/**
* Remove an attribute from a function.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMRemoveFunctionAttr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1895,
 FQN="LLVMRemoveFunctionAttr", NM="_Z22LLVMRemoveFunctionAttr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMRemoveFunctionAttr")
//</editor-fold>
public static void LLVMRemoveFunctionAttr( LLVMOpaqueValue /*P*/ Fn, int/*LLVMAttribute*/ PA) {
  AttrBuilder B = null;
  try {
    Function /*P*/ Func = IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, Fn);
    /*const*/ AttributeSet PAL = Func.getAttributes();
    B/*J*/= new AttrBuilder($int2ulong(PA));
    /*const*/ AttributeSet PALnew = PAL.removeAttributes(Func.getContext(), AttributeSet.AttrIndex.FunctionIndex.getValue(), 
        AttributeSet.get(Func.getContext(), 
            AttributeSet.AttrIndex.FunctionIndex.getValue(), B));
    Func.setAttributes(new AttributeSet(PALnew));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}


/**
* @defgroup LLVMCCoreValueFunctionParameters Function Parameters
*
* Functions in this group relate to arguments/parameters on functions.
*
* Functions in this group expect LLVMValueRef instances that correspond
* to llvm::Function instances.
*
* @{
*/

/**
* Obtain the number of parameters in a function.
*
* @see llvm::Function::arg_size()
*/

/*--.. Operations on parameters ............................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMCountParams">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1914,
 FQN="LLVMCountParams", NM="_Z15LLVMCountParams",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMCountParams")
//</editor-fold>
public static /*uint*/int LLVMCountParams( LLVMOpaqueValue /*P*/ FnRef) {
  // This function is strictly redundant to
  //   LLVMCountParamTypes(LLVMGetElementType(LLVMTypeOf(FnRef)))
  return IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, FnRef).arg_size();
}


/**
* Obtain the parameters in a function.
*
* The takes a pointer to a pre-allocated array of LLVMValueRef that is
* at least LLVMCountParams() long. This array will be filled with
* LLVMValueRef instances which correspond to the parameters the
* function receives. Each LLVMValueRef corresponds to a llvm::Argument
* instance.
*
* @see llvm::Function::arg_begin()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetParams">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1920,
 FQN="LLVMGetParams", NM="_Z13LLVMGetParams",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMGetParams")
//</editor-fold>
public static void LLVMGetParams( LLVMOpaqueValue /*P*/ FnRef, type$ptr<LLVMOpaqueValue /*P*/ /*P*/> ParamRefs) {
  Function /*P*/ Fn = IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, FnRef);
  for (ilist_iterator<Argument> I = Fn.arg_begin(), 
      E = Fn.arg_end(); I.$noteq(E); I.$postInc(0))  {
    ParamRefs.$postInc().$set(IrLlvmGlobals.wrap_Value$C$P($AddrOf(I.$star())));
  }
}


/**
* Obtain the parameter at the specified index.
*
* Parameters are indexed from 0.
*
* @see llvm::Function::arg_begin()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetParam">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1927,
 FQN="LLVMGetParam", NM="_Z12LLVMGetParam",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMGetParam")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetParam( LLVMOpaqueValue /*P*/ FnRef, /*uint*/int index) {
  ilist_iterator<Argument> AI = IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, FnRef).arg_begin();
  while ($greater_uint(index--, 0)) {
    AI.$postInc(0);
  }
  return IrLlvmGlobals.wrap_Value$C$P($AddrOf(AI.$star()));
}


/**
* Obtain the function to which this argument belongs.
*
* Unlike other functions in this group, this one takes an LLVMValueRef
* that corresponds to a llvm::Attribute.
*
* The returned LLVMValueRef is the llvm::Function to which this
* argument belongs.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetParamParent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1934,
 FQN="LLVMGetParamParent", NM="_Z18LLVMGetParamParent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetParamParent")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetParamParent( LLVMOpaqueValue /*P*/ V) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.<Argument>unwrap_LLVMOpaqueValue$P(Argument.class, V).getParent());
}


/**
* Obtain the first parameter to a function.
*
* @see llvm::Function::arg_begin()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetFirstParam">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1938,
 FQN="LLVMGetFirstParam", NM="_Z17LLVMGetFirstParam",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetFirstParam")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetFirstParam( LLVMOpaqueValue /*P*/ Fn) {
  Function /*P*/ Func = IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, Fn);
  ilist_iterator<Argument> I = Func.arg_begin();
  if (I.$eq(Func.arg_end())) {
    return null;
  }
  return IrLlvmGlobals.wrap_Value$C$P($AddrOf(I.$star()));
}


/**
* Obtain the last parameter to a function.
*
* @see llvm::Function::arg_end()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetLastParam">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1946,
 FQN="LLVMGetLastParam", NM="_Z16LLVMGetLastParam",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMGetLastParam")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetLastParam( LLVMOpaqueValue /*P*/ Fn) {
  Function /*P*/ Func = IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, Fn);
  ilist_iterator<Argument> I = Func.arg_end();
  if (I.$eq(Func.arg_begin())) {
    return null;
  }
  return IrLlvmGlobals.wrap_Value$C$P($AddrOf(I.$preDec().$star()));
}


/**
* Obtain the next parameter to a function.
*
* This takes an LLVMValueRef obtained from LLVMGetFirstParam() (which is
* actually a wrapped iterator) and obtains the next parameter from the
* underlying iterator.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNextParam">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1954,
 FQN="LLVMGetNextParam", NM="_Z16LLVMGetNextParam",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMGetNextParam")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetNextParam( LLVMOpaqueValue /*P*/ Arg) {
  Argument /*P*/ A = IrLlvmGlobals.<Argument>unwrap_LLVMOpaqueValue$P(Argument.class, Arg);
  ilist_iterator<Argument> I/*J*/= new ilist_iterator<Argument>(A, ilist_traits_IR.ilist_traits$Argument());
  if (I.$preInc().$eq(A.getParent().arg_end())) {
    return null;
  }
  return IrLlvmGlobals.wrap_Value$C$P($AddrOf(I.$star()));
}


/**
* Obtain the previous parameter to a function.
*
* This is the opposite of LLVMGetNextParam().
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetPreviousParam">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1962,
 FQN="LLVMGetPreviousParam", NM="_Z20LLVMGetPreviousParam",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetPreviousParam")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetPreviousParam( LLVMOpaqueValue /*P*/ Arg) {
  Argument /*P*/ A = IrLlvmGlobals.<Argument>unwrap_LLVMOpaqueValue$P(Argument.class, Arg);
  ilist_iterator<Argument> I/*J*/= new ilist_iterator<Argument>(A, ilist_traits_IR.ilist_traits$Argument());
  if (I.$eq(A.getParent().arg_begin())) {
    return null;
  }
  return IrLlvmGlobals.wrap_Value$C$P($AddrOf(I.$preDec().$star()));
}


/**
* Add an attribute to a function argument.
*
* @see llvm::Argument::addAttr()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMAddAttribute">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1970,
 FQN="LLVMAddAttribute", NM="_Z16LLVMAddAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMAddAttribute")
//</editor-fold>
public static void LLVMAddAttribute( LLVMOpaqueValue /*P*/ Arg, int/*LLVMAttribute*/ PA) {
  AttrBuilder B = null;
  try {
    Argument /*P*/ A = IrLlvmGlobals.<Argument>unwrap_LLVMOpaqueValue$P(Argument.class, Arg);
    B/*J*/= new AttrBuilder($int2ulong(PA));
    A.addAttr(AttributeSet.get(A.getContext(), A.getArgNo() + 1, B));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}


/**
* Remove an attribute from a function argument.
*
* @see llvm::Argument::removeAttr()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMRemoveAttribute">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1976,
 FQN="LLVMRemoveAttribute", NM="_Z19LLVMRemoveAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMRemoveAttribute")
//</editor-fold>
public static void LLVMRemoveAttribute( LLVMOpaqueValue /*P*/ Arg, int/*LLVMAttribute*/ PA) {
  AttrBuilder B = null;
  try {
    Argument /*P*/ A = IrLlvmGlobals.<Argument>unwrap_LLVMOpaqueValue$P(Argument.class, Arg);
    B/*J*/= new AttrBuilder($int2ulong(PA));
    A.removeAttr(AttributeSet.get(A.getContext(), A.getArgNo() + 1, B));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}


/**
* Get an attribute from a function argument.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetAttribute">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1982,
 FQN="LLVMGetAttribute", NM="_Z16LLVMGetAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMGetAttribute")
//</editor-fold>
public static int/*LLVMAttribute*/ LLVMGetAttribute( LLVMOpaqueValue /*P*/ Arg) {
  Argument /*P*/ A = IrLlvmGlobals.<Argument>unwrap_LLVMOpaqueValue$P(Argument.class, Arg);
  return /*(LLVMAttribute)*/(int)A.getParent().getAttributes().
      Raw(A.getArgNo() + 1);
}


/**
* Set the alignment for a function parameter.
*
* @see llvm::Argument::addAttr()
* @see llvm::AttrBuilder::addAlignmentAttr()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetParamAlignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1988,
 FQN="LLVMSetParamAlignment", NM="_Z21LLVMSetParamAlignment",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMSetParamAlignment")
//</editor-fold>
public static void LLVMSetParamAlignment( LLVMOpaqueValue /*P*/ Arg, /*uint*/int align) {
  AttrBuilder B = null;
  try {
    Argument /*P*/ A = IrLlvmGlobals.<Argument>unwrap_LLVMOpaqueValue$P(Argument.class, Arg);
    B/*J*/= new AttrBuilder();
    B.addAlignmentAttr(align);
    A.addAttr(AttributeSet.get(A.getContext(), A.getArgNo() + 1, B));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}


/**
* @}
*/

/**
* @}
*/

/**
* @}
*/

/**
* @}
*/

/**
* @defgroup LLVMCCoreValueMetadata Metadata
*
* @{
*/

/**
* Obtain a MDString value from a context.
*
* The returned instance corresponds to the llvm::MDString class.
*
* The instance is specified by string data of a specified length. The
* string content is copied, so the backing memory can be freed after
* this function returns.
*/

/*--.. Operations on metadata nodes ........................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMMDStringInContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 819,
 FQN="LLVMMDStringInContext", NM="_Z21LLVMMDStringInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMMDStringInContext")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMMDStringInContext( LLVMOpaqueContext /*P*/ C, /*const*/char$ptr/*char P*/ Str, 
                     /*uint*/int SLen) {
  final LLVMContext /*&*/ Context = $Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C));
  return IrLlvmGlobals.wrap_Value$C$P(MetadataAsValue.get(Context, MDString.get(Context, new StringRef(Str, SLen))));
}


/**
* Obtain a MDString value from the global context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMMDString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 826,
 FQN="LLVMMDString", NM="_Z12LLVMMDString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMMDString")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMMDString(/*const*/char$ptr/*char P*/ Str, /*uint*/int SLen) {
  return LLVMMDStringInContext(LLVMGetGlobalContext(), Str, SLen);
}


/**
* Obtain a MDNode value from a context.
*
* The returned value corresponds to the llvm::MDNode class.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMMDNodeInContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 830,
 FQN="LLVMMDNodeInContext", NM="_Z19LLVMMDNodeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMMDNodeInContext")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMMDNodeInContext( LLVMOpaqueContext /*P*/ C, type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Vals, 
                   /*uint*/int Count) {
  final LLVMContext /*&*/ Context = $Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C));
  SmallVector<Metadata /*P*/ > MDs/*J*/= new SmallVector<Metadata /*P*/ >(8, (Metadata /*P*/ )null);
  for (LLVMOpaqueValue /*P*/ OV : makeArrayRef(Vals, Count)) {
    Value /*P*/ V = IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(OV);
    Metadata /*P*/ MD;
    if (!(V != null)) {
      MD = null;
    } else {
      Constant /*P*/ C$1 = dyn_cast_Constant(V);
      if ((C$1 != null)) {
        MD = ConstantAsMetadata.get(C$1);
      } else {
        MetadataAsValue /*P*/ MDV = dyn_cast_MetadataAsValue(V);
        if ((MDV != null)) {
          MD = MDV.getMetadata();
          assert (!isa_LocalAsMetadata(MD)) : "Unexpected function-local metadata outside of direct argument to call";
        } else {
          // This is function-local metadata.  Pretend to make an MDNode.
          assert (Count == 1) : "Expected only one operand to function-local metadata";
          return IrLlvmGlobals.wrap_Value$C$P(MetadataAsValue.get(Context, LocalAsMetadata.get(V)));
        }
      }
    }
    
    MDs.push_back(MD);
  }
  return IrLlvmGlobals.wrap_Value$C$P(MetadataAsValue.get(Context, MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(MDs, true))));
}


/**
* Obtain a MDNode value from the global context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMMDNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 857,
 FQN="LLVMMDNode", NM="_Z10LLVMMDNode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z10LLVMMDNode")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMMDNode(type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Vals, /*uint*/int Count) {
  return LLVMMDNodeInContext(LLVMGetGlobalContext(), Vals, Count);
}


/**
* Obtain the underlying string from a MDString value.
*
* @param V Instance to obtain string from.
* @param Length Memory address which will hold length of returned string.
* @return String data in MDString.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetMDString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 861,
 FQN="LLVMGetMDString", NM="_Z15LLVMGetMDString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMGetMDString")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetMDString( LLVMOpaqueValue /*P*/ V, uint$ptr/*uint P*/ Length) {
  {
    /*const*/ MetadataAsValue /*P*/ MD = dyn_cast_MetadataAsValue(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(V));
    if ((MD != null)) {
      {
        /*const*/ MDString /*P*/ S = dyn_cast_MDString(MD.getMetadata());
        if ((S != null)) {
          Length.$set(S.getString().size());
          return S.getString().data();
        }
      }
    }
  }
  Length.$set(0);
  return null;
}


/**
* Obtain the number of operands from an MDNode value.
*
* @param V MDNode to get number of operands from.
* @return Number of operands of the MDNode.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetMDNodeNumOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 871,
 FQN="LLVMGetMDNodeNumOperands", NM="_Z24LLVMGetMDNodeNumOperands",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMGetMDNodeNumOperands")
//</editor-fold>
public static /*uint*/int LLVMGetMDNodeNumOperands( LLVMOpaqueValue /*P*/ V) {
  MetadataAsValue /*P*/ MD = cast_MetadataAsValue(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(V));
  if (isa_ValueAsMetadata(MD.getMetadata())) {
    return 1;
  }
  return cast_MDNode(MD.getMetadata()).getNumOperands();
}


/**
* Obtain the given MDNode's operands.
*
* The passed LLVMValueRef pointer should point to enough memory to hold all of
* the operands of the given MDNode (see LLVMGetMDNodeNumOperands) as
* LLVMValueRefs. This memory will be populated with the LLVMValueRefs of the
* MDNode's operands.
*
* @param V MDNode to get the operands from.
* @param Dest Destination array for operands.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetMDNodeOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 878,
 FQN="LLVMGetMDNodeOperands", NM="_Z21LLVMGetMDNodeOperands",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMGetMDNodeOperands")
//</editor-fold>
public static void LLVMGetMDNodeOperands( LLVMOpaqueValue /*P*/ V, type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Dest) {
  MetadataAsValue /*P*/ MD = cast_MetadataAsValue(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(V));
  {
    ValueAsMetadata /*P*/ MDV = dyn_cast_ValueAsMetadata(MD.getMetadata());
    if ((MDV != null)) {
      Dest.$set(IrLlvmGlobals.wrap_Value$C$P(MDV.getValue()));
      return;
    }
  }
  /*const*/ MDNode /*P*/ N = cast_MDNode(MD.getMetadata());
  /*const*//*uint*/int numOperands = N.getNumOperands();
  final LLVMContext /*&*/ Context = IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(V).getContext();
  for (/*uint*/int i = 0; $less_uint(i, numOperands); i++)  {
    Dest.$set(i, getMDNodeOperandImpl(Context, N, i));
  }
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreValueBasicBlock Basic Block
*
* A basic block represents a single entry single exit section of code.
* Basic blocks contain a list of instructions which form the body of
* the block.
*
* Basic blocks belong to functions. They have the type of label.
*
* Basic blocks are themselves values. However, the C API models them as
* LLVMBasicBlockRef.
*
* @see llvm::BasicBlock
*
* @{
*/

/**
* Convert a basic block instance to a value type.
*/

/*--.. Operations on basic blocks ..........................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMBasicBlockAsValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1997,
 FQN="LLVMBasicBlockAsValue", NM="_Z21LLVMBasicBlockAsValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMBasicBlockAsValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBasicBlockAsValue( LLVMOpaqueBasicBlock /*P*/ BB) {
  return IrLlvmGlobals.wrap_Value$C$P(((/*static_cast*/Value /*P*/ )(IrLlvmGlobals.unwrap(BB))));
}


/**
* Determine whether an LLVMValueRef is itself a basic block.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMValueIsBasicBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2001,
 FQN="LLVMValueIsBasicBlock", NM="_Z21LLVMValueIsBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMValueIsBasicBlock")
//</editor-fold>
public static int LLVMValueIsBasicBlock( LLVMOpaqueValue /*P*/ Val) {
  return (isa_BasicBlock(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val)) ? 1 : 0);
}


/**
* Convert an LLVMValueRef to an LLVMBasicBlockRef instance.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMValueAsBasicBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2005,
 FQN="LLVMValueAsBasicBlock", NM="_Z21LLVMValueAsBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMValueAsBasicBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMValueAsBasicBlock( LLVMOpaqueValue /*P*/ Val) {
  return IrLlvmGlobals.wrap(IrLlvmGlobals.<BasicBlock>unwrap_LLVMOpaqueValue$P(BasicBlock.class, Val));
}


/**
* Obtain the string name of a basic block.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetBasicBlockName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2009,
 FQN="LLVMGetBasicBlockName", NM="_Z21LLVMGetBasicBlockName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMGetBasicBlockName")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetBasicBlockName( LLVMOpaqueBasicBlock /*P*/ BB) {
  return IrLlvmGlobals.unwrap(BB).getName().data();
}


/**
* Obtain the function to which a basic block belongs.
*
* @see llvm::BasicBlock::getParent()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetBasicBlockParent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2013,
 FQN="LLVMGetBasicBlockParent", NM="_Z23LLVMGetBasicBlockParent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMGetBasicBlockParent")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetBasicBlockParent( LLVMOpaqueBasicBlock /*P*/ BB) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(BB).getParent());
}


/**
* Obtain the terminator instruction for a basic block.
*
* If the basic block does not have a terminator (it is not well-formed
* if it doesn't), then NULL is returned.
*
* The returned LLVMValueRef corresponds to a llvm::TerminatorInst.
*
* @see llvm::BasicBlock::getTerminator()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetBasicBlockTerminator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2017,
 FQN="LLVMGetBasicBlockTerminator", NM="_Z27LLVMGetBasicBlockTerminator",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMGetBasicBlockTerminator")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetBasicBlockTerminator( LLVMOpaqueBasicBlock /*P*/ BB) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(BB).getTerminator());
}


/**
* Obtain the number of basic blocks in a function.
*
* @param Fn Function value to operate on.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMCountBasicBlocks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2021,
 FQN="LLVMCountBasicBlocks", NM="_Z20LLVMCountBasicBlocks",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMCountBasicBlocks")
//</editor-fold>
public static /*uint*/int LLVMCountBasicBlocks( LLVMOpaqueValue /*P*/ FnRef) {
  return IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, FnRef).size();
}


/**
* Obtain all of the basic blocks in a function.
*
* This operates on a function value. The BasicBlocks parameter is a
* pointer to a pre-allocated array of LLVMBasicBlockRef of at least
* LLVMCountBasicBlocks() in length. This array is populated with
* LLVMBasicBlockRef instances.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetBasicBlocks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2025,
 FQN="LLVMGetBasicBlocks", NM="_Z18LLVMGetBasicBlocks",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetBasicBlocks")
//</editor-fold>
public static void LLVMGetBasicBlocks( LLVMOpaqueValue /*P*/ FnRef, type$ptr<LLVMOpaqueBasicBlock /*P*/ /*P*/> BasicBlocksRefs) {
  Function /*P*/ Fn = IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, FnRef);
  for (final BasicBlock /*&*/ BB : $Deref(Fn))  {
    BasicBlocksRefs.$postInc().$set(IrLlvmGlobals.wrap($AddrOf(BB)));
  }
}


/**
* Obtain the first basic block in a function.
*
* The returned basic block can be used as an iterator. You will likely
* eventually call into LLVMGetNextBasicBlock() with it.
*
* @see llvm::Function::begin()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetFirstBasicBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2035,
 FQN="LLVMGetFirstBasicBlock", NM="_Z22LLVMGetFirstBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMGetFirstBasicBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetFirstBasicBlock( LLVMOpaqueValue /*P*/ Fn) {
  Function /*P*/ Func = IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, Fn);
  ilist_iterator<BasicBlock> I = Func.begin();
  if (I.$eq(Func.end())) {
    return null;
  }
  return IrLlvmGlobals.wrap($AddrOf(I.$star()));
}


/**
* Obtain the last basic block in a function.
*
* @see llvm::Function::end()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetLastBasicBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2043,
 FQN="LLVMGetLastBasicBlock", NM="_Z21LLVMGetLastBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMGetLastBasicBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetLastBasicBlock( LLVMOpaqueValue /*P*/ Fn) {
  Function /*P*/ Func = IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, Fn);
  ilist_iterator<BasicBlock> I = Func.end();
  if (I.$eq(Func.begin())) {
    return null;
  }
  return IrLlvmGlobals.wrap($AddrOf(I.$preDec().$star()));
}


/**
* Advance a basic block iterator.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNextBasicBlock">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2051,
 FQN="LLVMGetNextBasicBlock", NM="_Z21LLVMGetNextBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMGetNextBasicBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetNextBasicBlock( LLVMOpaqueBasicBlock /*P*/ BB) {
  BasicBlock /*P*/ Block = IrLlvmGlobals.unwrap(BB);
  ilist_iterator<BasicBlock> I/*J*/= new ilist_iterator<BasicBlock>(Block, ilist_traits_IR.ilist_traits$BasicBlock());
  if (I.$preInc().$eq(Block.getParent().end())) {
    return null;
  }
  return IrLlvmGlobals.wrap($AddrOf(I.$star()));
}


/**
* Go backwards in a basic block iterator.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetPreviousBasicBlock">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2059,
 FQN="LLVMGetPreviousBasicBlock", NM="_Z25LLVMGetPreviousBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMGetPreviousBasicBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetPreviousBasicBlock( LLVMOpaqueBasicBlock /*P*/ BB) {
  BasicBlock /*P*/ Block = IrLlvmGlobals.unwrap(BB);
  ilist_iterator<BasicBlock> I/*J*/= new ilist_iterator<BasicBlock>(Block, ilist_traits_IR.ilist_traits$BasicBlock());
  if (I.$eq(Block.getParent().begin())) {
    return null;
  }
  return IrLlvmGlobals.wrap($AddrOf(I.$preDec().$star()));
}


/**
* Obtain the basic block that corresponds to the entry point of a
* function.
*
* @see llvm::Function::getEntryBlock()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetEntryBasicBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2031,
 FQN="LLVMGetEntryBasicBlock", NM="_Z22LLVMGetEntryBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMGetEntryBasicBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetEntryBasicBlock( LLVMOpaqueValue /*P*/ Fn) {
  return IrLlvmGlobals.wrap($AddrOf(IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, Fn).getEntryBlock()));
}


/**
* Append a basic block to the end of a function.
*
* @see llvm::BasicBlock::Create()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMAppendBasicBlockInContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2067,
 FQN="LLVMAppendBasicBlockInContext", NM="_Z29LLVMAppendBasicBlockInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMAppendBasicBlockInContext")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMAppendBasicBlockInContext( LLVMOpaqueContext /*P*/ C, 
                              LLVMOpaqueValue /*P*/ FnRef, 
                             /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap(BasicBlock.Create($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)), new Twine(Name), IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, FnRef)));
}


/**
* Append a basic block to the end of a function using the global
* context.
*
* @see llvm::BasicBlock::Create()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMAppendBasicBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2073,
 FQN="LLVMAppendBasicBlock", NM="_Z20LLVMAppendBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMAppendBasicBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMAppendBasicBlock( LLVMOpaqueValue /*P*/ FnRef, /*const*/char$ptr/*char P*/ Name) {
  return LLVMAppendBasicBlockInContext(LLVMGetGlobalContext(), FnRef, Name);
}


/**
* Insert a basic block in a function before another basic block.
*
* The function to add to is determined by the function of the
* passed basic block.
*
* @see llvm::BasicBlock::Create()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMInsertBasicBlockInContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2077,
 FQN="LLVMInsertBasicBlockInContext", NM="_Z29LLVMInsertBasicBlockInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMInsertBasicBlockInContext")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMInsertBasicBlockInContext( LLVMOpaqueContext /*P*/ C, 
                              LLVMOpaqueBasicBlock /*P*/ BBRef, 
                             /*const*/char$ptr/*char P*/ Name) {
  BasicBlock /*P*/ BB = IrLlvmGlobals.unwrap(BBRef);
  return IrLlvmGlobals.wrap(BasicBlock.Create($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)), new Twine(Name), BB.getParent(), BB));
}


/**
* Insert a basic block in a function using the global context.
*
* @see llvm::BasicBlock::Create()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMInsertBasicBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2084,
 FQN="LLVMInsertBasicBlock", NM="_Z20LLVMInsertBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMInsertBasicBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMInsertBasicBlock( LLVMOpaqueBasicBlock /*P*/ BBRef, 
                    /*const*/char$ptr/*char P*/ Name) {
  return LLVMInsertBasicBlockInContext(LLVMGetGlobalContext(), BBRef, Name);
}


/**
* Remove a basic block from a function and delete it.
*
* This deletes the basic block from its containing function and deletes
* the basic block itself.
*
* @see llvm::BasicBlock::eraseFromParent()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMDeleteBasicBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2089,
 FQN="LLVMDeleteBasicBlock", NM="_Z20LLVMDeleteBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMDeleteBasicBlock")
//</editor-fold>
public static void LLVMDeleteBasicBlock( LLVMOpaqueBasicBlock /*P*/ BBRef) {
  IrLlvmGlobals.unwrap(BBRef).eraseFromParent();
}


/**
* Remove a basic block from a function.
*
* This deletes the basic block from its containing function but keep
* the basic block alive.
*
* @see llvm::BasicBlock::removeFromParent()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMRemoveBasicBlockFromParent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2093,
 FQN="LLVMRemoveBasicBlockFromParent", NM="_Z30LLVMRemoveBasicBlockFromParent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z30LLVMRemoveBasicBlockFromParent")
//</editor-fold>
public static void LLVMRemoveBasicBlockFromParent( LLVMOpaqueBasicBlock /*P*/ BBRef) {
  IrLlvmGlobals.unwrap(BBRef).removeFromParent();
}


/**
* Move a basic block to before another one.
*
* @see llvm::BasicBlock::moveBefore()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMMoveBasicBlockBefore">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2097,
 FQN="LLVMMoveBasicBlockBefore", NM="_Z24LLVMMoveBasicBlockBefore",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMMoveBasicBlockBefore")
//</editor-fold>
public static void LLVMMoveBasicBlockBefore( LLVMOpaqueBasicBlock /*P*/ BB,  LLVMOpaqueBasicBlock /*P*/ MovePos) {
  IrLlvmGlobals.unwrap(BB).moveBefore(IrLlvmGlobals.unwrap(MovePos));
}


/**
* Move a basic block to after another one.
*
* @see llvm::BasicBlock::moveAfter()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMMoveBasicBlockAfter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2101,
 FQN="LLVMMoveBasicBlockAfter", NM="_Z23LLVMMoveBasicBlockAfter",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMMoveBasicBlockAfter")
//</editor-fold>
public static void LLVMMoveBasicBlockAfter( LLVMOpaqueBasicBlock /*P*/ BB,  LLVMOpaqueBasicBlock /*P*/ MovePos) {
  IrLlvmGlobals.unwrap(BB).moveAfter(IrLlvmGlobals.unwrap(MovePos));
}


/**
* Obtain the first instruction in a basic block.
*
* The returned LLVMValueRef corresponds to a llvm::Instruction
* instance.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetFirstInstruction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2111,
 FQN="LLVMGetFirstInstruction", NM="_Z23LLVMGetFirstInstruction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMGetFirstInstruction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetFirstInstruction( LLVMOpaqueBasicBlock /*P*/ BB) {
  BasicBlock /*P*/ Block = IrLlvmGlobals.unwrap(BB);
  ilist_iterator<Instruction> I = Block.begin();
  if (I.$eq(Block.end())) {
    return null;
  }
  return IrLlvmGlobals.wrap_Value$C$P($AddrOf(I.$star()));
}


/**
* Obtain the last instruction in a basic block.
*
* The returned LLVMValueRef corresponds to an LLVM:Instruction.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetLastInstruction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2119,
 FQN="LLVMGetLastInstruction", NM="_Z22LLVMGetLastInstruction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMGetLastInstruction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetLastInstruction( LLVMOpaqueBasicBlock /*P*/ BB) {
  BasicBlock /*P*/ Block = IrLlvmGlobals.unwrap(BB);
  ilist_iterator<Instruction> I = Block.end();
  if (I.$eq(Block.begin())) {
    return null;
  }
  return IrLlvmGlobals.wrap_Value$C$P($AddrOf(I.$preDec().$star()));
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreValueInstruction Instructions
*
* Functions in this group relate to the inspection and manipulation of
* individual instructions.
*
* In the C++ API, an instruction is modeled by llvm::Instruction. This
* class has a large number of descendents. llvm::Instruction is a
* llvm::Value and in the C API, instructions are modeled by
* LLVMValueRef.
*
* This group also contains sub-groups which operate on specific
* llvm::Instruction types, e.g. llvm::CallInst.
*
* @{
*/

/**
* Determine whether an instruction has any metadata attached.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMHasMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 662,
 FQN="LLVMHasMetadata", NM="_Z15LLVMHasMetadata",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMHasMetadata")
//</editor-fold>
public static int LLVMHasMetadata( LLVMOpaqueValue /*P*/ Inst) {
  return (IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Inst).hasMetadata() ? 1 : 0);
}


/**
* Return metadata associated with an instruction value.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 666,
 FQN="LLVMGetMetadata", NM="_Z15LLVMGetMetadata",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMGetMetadata")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetMetadata( LLVMOpaqueValue /*P*/ Inst, /*uint*/int KindID) {
  Instruction /*P*/ I = IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Inst);
  assert ((I != null)) : "Expected instruction";
  {
    MDNode /*P*/ MD = I.getMetadata(KindID);
    if ((MD != null)) {
      return IrLlvmGlobals.wrap_Value$C$P(MetadataAsValue.get(I.getContext(), MD));
    }
  }
  return null;
}


/**
* Set metadata associated with an instruction value.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 688,
 FQN="LLVMSetMetadata", NM="_Z15LLVMSetMetadata",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMSetMetadata")
//</editor-fold>
public static void LLVMSetMetadata( LLVMOpaqueValue /*P*/ Inst, /*uint*/int KindID,  LLVMOpaqueValue /*P*/ Val) {
  MDNode /*P*/ N = (Val != null) ? extractMDNode(IrLlvmGlobals.<MetadataAsValue>unwrap_LLVMOpaqueValue$P(MetadataAsValue.class, Val)) : null;
  
  IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Inst).setMetadata(KindID, N);
}


/**
* Obtain the basic block to which an instruction belongs.
*
* @see llvm::Instruction::getParent()
*/

/*--.. Operations on instructions ..........................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetInstructionParent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2107,
 FQN="LLVMGetInstructionParent", NM="_Z24LLVMGetInstructionParent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMGetInstructionParent")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetInstructionParent( LLVMOpaqueValue /*P*/ Inst) {
  return IrLlvmGlobals.wrap(IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Inst).getParent());
}


/**
* Obtain the instruction that occurs after the one specified.
*
* The next instruction will be from the same basic block.
*
* If this is the last instruction in a basic block, NULL will be
* returned.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNextInstruction">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2127,
 FQN="LLVMGetNextInstruction", NM="_Z22LLVMGetNextInstruction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMGetNextInstruction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetNextInstruction( LLVMOpaqueValue /*P*/ Inst) {
  Instruction /*P*/ Instr = IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Inst);
  ilist_iterator<Instruction> I/*J*/= new ilist_iterator<Instruction>(Instr, ilist_traits_IR.ilist_traits$Instruction());
  if (I.$preInc().$eq(Instr.getParent().end())) {
    return null;
  }
  return IrLlvmGlobals.wrap_Value$C$P($AddrOf(I.$star()));
}


/**
* Obtain the instruction that occurred before this one.
*
* If the instruction is the first instruction in a basic block, NULL
* will be returned.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetPreviousInstruction">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2135,
 FQN="LLVMGetPreviousInstruction", NM="_Z26LLVMGetPreviousInstruction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMGetPreviousInstruction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetPreviousInstruction( LLVMOpaqueValue /*P*/ Inst) {
  Instruction /*P*/ Instr = IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Inst);
  ilist_iterator<Instruction> I/*J*/= new ilist_iterator<Instruction>(Instr, ilist_traits_IR.ilist_traits$Instruction());
  if (I.$eq(Instr.getParent().begin())) {
    return null;
  }
  return IrLlvmGlobals.wrap_Value$C$P($AddrOf(I.$preDec().$star()));
}


/**
* Remove and delete an instruction.
*
* The instruction specified is removed from its containing building
* block but is kept alive.
*
* @see llvm::Instruction::removeFromParent()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMInstructionRemoveFromParent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2143,
 FQN="LLVMInstructionRemoveFromParent", NM="_Z31LLVMInstructionRemoveFromParent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z31LLVMInstructionRemoveFromParent")
//</editor-fold>
public static void LLVMInstructionRemoveFromParent( LLVMOpaqueValue /*P*/ Inst) {
  IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Inst).removeFromParent();
}


/**
* Remove and delete an instruction.
*
* The instruction specified is removed from its containing building
* block and then deleted.
*
* @see llvm::Instruction::eraseFromParent()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMInstructionEraseFromParent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2147,
 FQN="LLVMInstructionEraseFromParent", NM="_Z30LLVMInstructionEraseFromParent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z30LLVMInstructionEraseFromParent")
//</editor-fold>
public static void LLVMInstructionEraseFromParent( LLVMOpaqueValue /*P*/ Inst) {
  IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Inst).eraseFromParent();
}


/**
* Obtain the code opcode for an individual instruction.
*
* @see llvm::Instruction::getOpCode()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetInstructionOpcode">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2169,
 FQN="LLVMGetInstructionOpcode", NM="_Z24LLVMGetInstructionOpcode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMGetInstructionOpcode")
//</editor-fold>
public static LLVMOpcode LLVMGetInstructionOpcode( LLVMOpaqueValue /*P*/ Inst) {
  {
    Instruction /*P*/ C = dyn_cast_Instruction(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Inst));
    if ((C != null)) {
      return map_to_llvmopcode(C.getOpcode());
    }
  }
  return LLVMOpcode.valueOf(0);
}


/**
* Obtain the predicate of an instruction.
*
* This is only valid for instructions that correspond to llvm::ICmpInst
* or llvm::ConstantExpr whose opcode is llvm::Instruction::ICmp.
*
* @see llvm::ICmpInst::getPredicate()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetICmpPredicate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2151,
 FQN="LLVMGetICmpPredicate", NM="_Z20LLVMGetICmpPredicate",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetICmpPredicate")
//</editor-fold>
public static LLVMIntPredicate LLVMGetICmpPredicate( LLVMOpaqueValue /*P*/ Inst) {
  {
    ICmpInst /*P*/ I = dyn_cast_ICmpInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Inst));
    if ((I != null)) {
      return LLVMIntPredicate.valueOf(I.getPredicate().getValue());
    }
  }
  {
    ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Inst));
    if ((CE != null)) {
      if (CE.getOpcode() == Instruction.OtherOps.ICmp) {
        return LLVMIntPredicate.valueOf(CE.getPredicate());
      }
    }
  }
  return LLVMIntPredicate.valueOf(0);
}


/**
* Obtain the float predicate of an instruction.
*
* This is only valid for instructions that correspond to llvm::FCmpInst
* or llvm::ConstantExpr whose opcode is llvm::Instruction::FCmp.
*
* @see llvm::FCmpInst::getPredicate()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetFCmpPredicate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2160,
 FQN="LLVMGetFCmpPredicate", NM="_Z20LLVMGetFCmpPredicate",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetFCmpPredicate")
//</editor-fold>
public static LLVMRealPredicate LLVMGetFCmpPredicate( LLVMOpaqueValue /*P*/ Inst) {
  {
    FCmpInst /*P*/ I = dyn_cast_FCmpInst(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Inst));
    if ((I != null)) {
      return LLVMRealPredicate.valueOf(I.getPredicate().getValue());
    }
  }
  {
    ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Inst));
    if ((CE != null)) {
      if (CE.getOpcode() == Instruction.OtherOps.FCmp) {
        return LLVMRealPredicate.valueOf(CE.getPredicate());
      }
    }
  }
  return LLVMRealPredicate.valueOf(0);
}


/**
* Create a copy of 'this' instruction that is identical in all ways
* except the following:
*   * The instruction has no parent
*   * The instruction has no name
*
* @see llvm::Instruction::clone()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMInstructionClone">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2175,
 FQN="LLVMInstructionClone", NM="_Z20LLVMInstructionClone",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMInstructionClone")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMInstructionClone( LLVMOpaqueValue /*P*/ Inst) {
  {
    Instruction /*P*/ C = dyn_cast_Instruction(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Inst));
    if ((C != null)) {
      return IrLlvmGlobals.wrap_Value$C$P(C.clone());
    }
  }
  return null;
}


/**
* @defgroup LLVMCCoreValueInstructionCall Call Sites and Invocations
*
* Functions in this group apply to instructions that refer to call
* sites and invocations. These correspond to C++ types in the
* llvm::CallInst class tree.
*
* @{
*/

/**
* Obtain the argument count for a call instruction.
*
* This expects an LLVMValueRef that corresponds to a llvm::CallInst or
* llvm::InvokeInst.
*
* @see llvm::CallInst::getNumArgOperands()
* @see llvm::InvokeInst::getNumArgOperands()
*/

/*--.. Call and invoke instructions ........................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNumArgOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2183,
 FQN="LLVMGetNumArgOperands", NM="_Z21LLVMGetNumArgOperands",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMGetNumArgOperands")
//</editor-fold>
public static /*uint*/int LLVMGetNumArgOperands( LLVMOpaqueValue /*P*/ Instr) {
  return new CallSite(IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Instr)).getNumArgOperands();
}


/**
* Set the calling convention for a call instruction.
*
* This expects an LLVMValueRef that corresponds to a llvm::CallInst or
* llvm::InvokeInst.
*
* @see llvm::CallInst::setCallingConv()
* @see llvm::InvokeInst::setCallingConv()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetInstructionCallConv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2191,
 FQN="LLVMSetInstructionCallConv", NM="_Z26LLVMSetInstructionCallConv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMSetInstructionCallConv")
//</editor-fold>
public static void LLVMSetInstructionCallConv( LLVMOpaqueValue /*P*/ Instr, /*uint*/int CC) {
  new CallSite(IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Instr)).
      setCallingConv(((/*static_cast*//*uint*/int)(CC)));
  /*JAVA:return*/return;
}


/**
* Obtain the calling convention for a call instruction.
*
* This is the opposite of LLVMSetInstructionCallConv(). Reads its
* usage.
*
* @see LLVMSetInstructionCallConv()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetInstructionCallConv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2187,
 FQN="LLVMGetInstructionCallConv", NM="_Z26LLVMGetInstructionCallConv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMGetInstructionCallConv")
//</editor-fold>
public static /*uint*/int LLVMGetInstructionCallConv( LLVMOpaqueValue /*P*/ Instr) {
  return new CallSite(IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Instr)).getCallingConv();
}

//<editor-fold defaultstate="collapsed" desc="LLVMAddInstrAttribute">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2196,
 FQN="LLVMAddInstrAttribute", NM="_Z21LLVMAddInstrAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMAddInstrAttribute")
//</editor-fold>
public static void LLVMAddInstrAttribute( LLVMOpaqueValue /*P*/ Instr, /*uint*/int index, 
                     int/*LLVMAttribute*/ PA) {
  AttrBuilder B = null;
  try {
    CallSite Call = new CallSite(IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Instr));
    B/*J*/= new AttrBuilder($int2ulong(PA));
    Call.setAttributes(Call.getAttributes().addAttributes(Call.$arrow().getContext(), index, 
            AttributeSet.get(Call.$arrow().getContext(), 
                index, B)));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="LLVMRemoveInstrAttribute">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2206,
 FQN="LLVMRemoveInstrAttribute", NM="_Z24LLVMRemoveInstrAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMRemoveInstrAttribute")
//</editor-fold>
public static void LLVMRemoveInstrAttribute( LLVMOpaqueValue /*P*/ Instr, /*uint*/int index, 
                        int/*LLVMAttribute*/ PA) {
  AttrBuilder B = null;
  try {
    CallSite Call = new CallSite(IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Instr));
    B/*J*/= new AttrBuilder($int2ulong(PA));
    Call.setAttributes(Call.getAttributes().
            removeAttributes(Call.$arrow().getContext(), index, 
            AttributeSet.get(Call.$arrow().getContext(), 
                index, B)));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetInstrParamAlignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2216,
 FQN="LLVMSetInstrParamAlignment", NM="_Z26LLVMSetInstrParamAlignment",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMSetInstrParamAlignment")
//</editor-fold>
public static void LLVMSetInstrParamAlignment( LLVMOpaqueValue /*P*/ Instr, /*uint*/int index, 
                          /*uint*/int align) {
  AttrBuilder B = null;
  try {
    CallSite Call = new CallSite(IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Instr));
    B/*J*/= new AttrBuilder();
    B.addAlignmentAttr(align);
    Call.setAttributes(Call.getAttributes().
            addAttributes(Call.$arrow().getContext(), index, 
            AttributeSet.get(Call.$arrow().getContext(), 
                index, B)));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="LLVMAddCallSiteAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2227,
 FQN="LLVMAddCallSiteAttribute", NM="_Z24LLVMAddCallSiteAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMAddCallSiteAttribute")
//</editor-fold>
public static void LLVMAddCallSiteAttribute( LLVMOpaqueValue /*P*/ C, /*uint*/int Idx, 
                         LLVMOpaqueAttributeRef /*P*/ A) {
  new CallSite(IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, C)).addAttribute(Idx, IrLlvmGlobals.unwrap(A));
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetCallSiteAttributeCount">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2232,
 FQN="LLVMGetCallSiteAttributeCount", NM="_Z29LLVMGetCallSiteAttributeCount",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMGetCallSiteAttributeCount")
//</editor-fold>
public static /*uint*/int LLVMGetCallSiteAttributeCount( LLVMOpaqueValue /*P*/ C, 
                             /*uint*/int Idx) {
  CallSite CS = new CallSite(IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, C));
  AttributeSetNode /*P*/ ASN = AttributeSetNode.get(new AttributeSet(CS.getAttributes()), Idx);
  return ASN.getNumAttributes();
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetCallSiteAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2239,
 FQN="LLVMGetCallSiteAttributes", NM="_Z25LLVMGetCallSiteAttributes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMGetCallSiteAttributes")
//</editor-fold>
public static void LLVMGetCallSiteAttributes( LLVMOpaqueValue /*P*/ C, /*uint*/int Idx, 
                         type$ptr<LLVMOpaqueAttributeRef /*P*/ /*P*/> Attrs) {
  CallSite CS = new CallSite(IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, C));
  AttributeSetNode /*P*/ ASN = AttributeSetNode.get(new AttributeSet(CS.getAttributes()), Idx);
  for (Attribute A : make_range(ASN.begin(), ASN.end()))  {
    Attrs.$postInc().$set(IrLlvmGlobals.wrap(new Attribute(A)));
  }
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetCallSiteEnumAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2247,
 FQN="LLVMGetCallSiteEnumAttribute", NM="_Z28LLVMGetCallSiteEnumAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z28LLVMGetCallSiteEnumAttribute")
//</editor-fold>
public static  LLVMOpaqueAttributeRef /*P*/ LLVMGetCallSiteEnumAttribute( LLVMOpaqueValue /*P*/ C, 
                            /*uint*/int Idx, 
                            /*uint*/int KindID) {
  return IrLlvmGlobals.wrap(new CallSite(IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, C)).
          getAttribute(Idx, Attribute.AttrKind.valueOf(KindID)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetCallSiteStringAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2254,
 FQN="LLVMGetCallSiteStringAttribute", NM="_Z30LLVMGetCallSiteStringAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z30LLVMGetCallSiteStringAttribute")
//</editor-fold>
public static  LLVMOpaqueAttributeRef /*P*/ LLVMGetCallSiteStringAttribute( LLVMOpaqueValue /*P*/ C, 
                              /*uint*/int Idx, 
                              /*const*/char$ptr/*char P*/ K, /*uint*/int KLen) {
  return IrLlvmGlobals.wrap(new CallSite(IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, C)).
          getAttribute(Idx, new StringRef(K, KLen)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMRemoveCallSiteEnumAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2261,
 FQN="LLVMRemoveCallSiteEnumAttribute", NM="_Z31LLVMRemoveCallSiteEnumAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z31LLVMRemoveCallSiteEnumAttribute")
//</editor-fold>
public static void LLVMRemoveCallSiteEnumAttribute( LLVMOpaqueValue /*P*/ C, /*uint*/int Idx, 
                               /*uint*/int KindID) {
  new CallSite(IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, C)).
      removeAttribute(Idx, Attribute.AttrKind.valueOf(KindID));
}

//<editor-fold defaultstate="collapsed" desc="LLVMRemoveCallSiteStringAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2267,
 FQN="LLVMRemoveCallSiteStringAttribute", NM="_Z33LLVMRemoveCallSiteStringAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z33LLVMRemoveCallSiteStringAttribute")
//</editor-fold>
public static void LLVMRemoveCallSiteStringAttribute( LLVMOpaqueValue /*P*/ C, /*uint*/int Idx, 
                                 /*const*/char$ptr/*char P*/ K, /*uint*/int KLen) {
  new CallSite(IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, C)).removeAttribute(Idx, new StringRef(K, KLen));
}


/**
* Obtain the pointer to the function invoked by this instruction.
*
* This expects an LLVMValueRef that corresponds to a llvm::CallInst or
* llvm::InvokeInst.
*
* @see llvm::CallInst::getCalledValue()
* @see llvm::InvokeInst::getCalledValue()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetCalledValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2272,
 FQN="LLVMGetCalledValue", NM="_Z18LLVMGetCalledValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetCalledValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetCalledValue( LLVMOpaqueValue /*P*/ Instr) {
  return IrLlvmGlobals.wrap_Value$C$P(new CallSite(IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Instr)).getCalledValue());
}


/**
* Obtain whether a call instruction is a tail call.
*
* This only works on llvm::CallInst instructions.
*
* @see llvm::CallInst::isTailCall()
*/

/*--.. Operations on call instructions (only) ..............................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsTailCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2278,
 FQN="LLVMIsTailCall", NM="_Z14LLVMIsTailCall",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMIsTailCall")
//</editor-fold>
public static int LLVMIsTailCall( LLVMOpaqueValue /*P*/ Call) {
  return (IrLlvmGlobals.<CallInst>unwrap_LLVMOpaqueValue$P(CallInst.class, Call).isTailCall() ? 1 : 0);
}


/**
* Set whether a call instruction is a tail call.
*
* This only works on llvm::CallInst instructions.
*
* @see llvm::CallInst::setTailCall()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetTailCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2282,
 FQN="LLVMSetTailCall", NM="_Z15LLVMSetTailCall",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMSetTailCall")
//</editor-fold>
public static void LLVMSetTailCall( LLVMOpaqueValue /*P*/ Call, int isTailCall) {
  IrLlvmGlobals.<CallInst>unwrap_LLVMOpaqueValue$P(CallInst.class, Call).setTailCall((isTailCall != 0));
}


/**
* Return the normal destination basic block.
*
* This only works on llvm::InvokeInst instructions.
*
* @see llvm::InvokeInst::getNormalDest()
*/

/*--.. Operations on invoke instructions (only) ............................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNormalDest">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2288,
 FQN="LLVMGetNormalDest", NM="_Z17LLVMGetNormalDest",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetNormalDest")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetNormalDest( LLVMOpaqueValue /*P*/ Invoke) {
  return IrLlvmGlobals.wrap(IrLlvmGlobals.<InvokeInst>unwrap_LLVMOpaqueValue$P(InvokeInst.class, Invoke).getNormalDest());
}


/**
* Return the unwind destination basic block.
*
* This only works on llvm::InvokeInst instructions.
*
* @see llvm::InvokeInst::getUnwindDest()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetUnwindDest">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2292,
 FQN="LLVMGetUnwindDest", NM="_Z17LLVMGetUnwindDest",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetUnwindDest")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetUnwindDest( LLVMOpaqueValue /*P*/ Invoke) {
  return IrLlvmGlobals.wrap(IrLlvmGlobals.<InvokeInst>unwrap_LLVMOpaqueValue$P(InvokeInst.class, Invoke).getUnwindDest());
}


/**
* Set the normal destination basic block.
*
* This only works on llvm::InvokeInst instructions.
*
* @see llvm::InvokeInst::setNormalDest()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetNormalDest">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2296,
 FQN="LLVMSetNormalDest", NM="_Z17LLVMSetNormalDest",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMSetNormalDest")
//</editor-fold>
public static void LLVMSetNormalDest( LLVMOpaqueValue /*P*/ Invoke,  LLVMOpaqueBasicBlock /*P*/ B) {
  IrLlvmGlobals.<InvokeInst>unwrap_LLVMOpaqueValue$P(InvokeInst.class, Invoke).setNormalDest(IrLlvmGlobals.unwrap(B));
}


/**
* Set the unwind destination basic block.
*
* This only works on llvm::InvokeInst instructions.
*
* @see llvm::InvokeInst::setUnwindDest()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetUnwindDest">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2300,
 FQN="LLVMSetUnwindDest", NM="_Z17LLVMSetUnwindDest",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMSetUnwindDest")
//</editor-fold>
public static void LLVMSetUnwindDest( LLVMOpaqueValue /*P*/ Invoke,  LLVMOpaqueBasicBlock /*P*/ B) {
  IrLlvmGlobals.<InvokeInst>unwrap_LLVMOpaqueValue$P(InvokeInst.class, Invoke).setUnwindDest(IrLlvmGlobals.unwrap(B));
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreValueInstructionTerminator Terminators
*
* Functions in this group only apply to instructions that map to
* llvm::TerminatorInst instances.
*
* @{
*/

/**
* Return the number of successors that this terminator has.
*
* @see llvm::TerminatorInst::getNumSuccessors
*/

/*--.. Operations on terminators ...........................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNumSuccessors">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2306,
 FQN="LLVMGetNumSuccessors", NM="_Z20LLVMGetNumSuccessors",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetNumSuccessors")
//</editor-fold>
public static /*uint*/int LLVMGetNumSuccessors( LLVMOpaqueValue /*P*/ Term) {
  return IrLlvmGlobals.<TerminatorInst>unwrap_LLVMOpaqueValue$P(TerminatorInst.class, Term).getNumSuccessors();
}


/**
* Return the specified successor.
*
* @see llvm::TerminatorInst::getSuccessor
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetSuccessor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2310,
 FQN="LLVMGetSuccessor", NM="_Z16LLVMGetSuccessor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMGetSuccessor")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetSuccessor( LLVMOpaqueValue /*P*/ Term, /*uint*/int i) {
  return IrLlvmGlobals.wrap(IrLlvmGlobals.<TerminatorInst>unwrap_LLVMOpaqueValue$P(TerminatorInst.class, Term).getSuccessor(i));
}


/**
* Update the specified successor to point at the provided block.
*
* @see llvm::TerminatorInst::setSuccessor
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetSuccessor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2314,
 FQN="LLVMSetSuccessor", NM="_Z16LLVMSetSuccessor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMSetSuccessor")
//</editor-fold>
public static void LLVMSetSuccessor( LLVMOpaqueValue /*P*/ Term, /*uint*/int i,  LLVMOpaqueBasicBlock /*P*/ block) {
  IrLlvmGlobals.<TerminatorInst>unwrap_LLVMOpaqueValue$P(TerminatorInst.class, Term).setSuccessor(i, IrLlvmGlobals.unwrap(block));
  /*JAVA:return*/return;
}


/**
* Return if a branch is conditional.
*
* This only works on llvm::BranchInst instructions.
*
* @see llvm::BranchInst::isConditional
*/

/*--.. Operations on branch instructions (only) ............................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsConditional">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2320,
 FQN="LLVMIsConditional", NM="_Z17LLVMIsConditional",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsConditional")
//</editor-fold>
public static int LLVMIsConditional( LLVMOpaqueValue /*P*/ Branch) {
  return (IrLlvmGlobals.<BranchInst>unwrap_LLVMOpaqueValue$P(BranchInst.class, Branch).isConditional() ? 1 : 0);
}


/**
* Return the condition of a branch instruction.
*
* This only works on llvm::BranchInst instructions.
*
* @see llvm::BranchInst::getCondition
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetCondition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2324,
 FQN="LLVMGetCondition", NM="_Z16LLVMGetCondition",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMGetCondition")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetCondition( LLVMOpaqueValue /*P*/ Branch) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.<BranchInst>unwrap_LLVMOpaqueValue$P(BranchInst.class, Branch).getCondition());
}


/**
* Set the condition of a branch instruction.
*
* This only works on llvm::BranchInst instructions.
*
* @see llvm::BranchInst::setCondition
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetCondition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2328,
 FQN="LLVMSetCondition", NM="_Z16LLVMSetCondition",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMSetCondition")
//</editor-fold>
public static void LLVMSetCondition( LLVMOpaqueValue /*P*/ Branch,  LLVMOpaqueValue /*P*/ Cond) {
  IrLlvmGlobals.<BranchInst>unwrap_LLVMOpaqueValue$P(BranchInst.class, Branch).setCondition(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Cond));
  /*JAVA:return*/return;
}


/**
* Obtain the default destination basic block of a switch instruction.
*
* This only works on llvm::SwitchInst instructions.
*
* @see llvm::SwitchInst::getDefaultDest()
*/

/*--.. Operations on switch instructions (only) ............................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetSwitchDefaultDest">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2334,
 FQN="LLVMGetSwitchDefaultDest", NM="_Z24LLVMGetSwitchDefaultDest",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMGetSwitchDefaultDest")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetSwitchDefaultDest( LLVMOpaqueValue /*P*/ Switch) {
  return IrLlvmGlobals.wrap(IrLlvmGlobals.<SwitchInst>unwrap_LLVMOpaqueValue$P(SwitchInst.class, Switch).getDefaultDest());
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreValueInstructionAlloca Allocas
*
* Functions in this group only apply to instructions that map to
* llvm::AllocaInst instances.
*
* @{
*/

/**
* Obtain the type that is being allocated by the alloca instruction.
*/

/*--.. Operations on alloca instructions (only) ............................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetAllocatedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2340,
 FQN="LLVMGetAllocatedType", NM="_Z20LLVMGetAllocatedType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetAllocatedType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMGetAllocatedType( LLVMOpaqueValue /*P*/ Alloca) {
  return IrLlvmGlobals.wrap_Type$C$P(IrLlvmGlobals.<AllocaInst>unwrap_LLVMOpaqueValue$P(AllocaInst.class, Alloca).getAllocatedType());
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreValueInstructionGetElementPointer GEPs
*
* Functions in this group only apply to instructions that map to
* llvm::GetElementPtrInst instances.
*
* @{
*/

/**
* Check whether the given GEP instruction is inbounds.
*/

/*--.. Operations on gep instructions (only) ...............................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsInBounds">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2346,
 FQN="LLVMIsInBounds", NM="_Z14LLVMIsInBounds",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMIsInBounds")
//</editor-fold>
public static int LLVMIsInBounds( LLVMOpaqueValue /*P*/ GEP) {
  return (IrLlvmGlobals.<GetElementPtrInst>unwrap_LLVMOpaqueValue$P(GetElementPtrInst.class, GEP).isInBounds() ? 1 : 0);
}


/**
* Set the given GEP instruction to be inbounds or not.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetIsInBounds">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2350,
 FQN="LLVMSetIsInBounds", NM="_Z17LLVMSetIsInBounds",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMSetIsInBounds")
//</editor-fold>
public static void LLVMSetIsInBounds( LLVMOpaqueValue /*P*/ GEP, int InBounds) {
  IrLlvmGlobals.<GetElementPtrInst>unwrap_LLVMOpaqueValue$P(GetElementPtrInst.class, GEP).setIsInBounds((InBounds != 0));
  /*JAVA:return*/return;
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreValueInstructionPHINode PHI Nodes
*
* Functions in this group only apply to instructions that map to
* llvm::PHINode instances.
*
* @{
*/

/**
* Add an incoming value to the end of a PHI list.
*/

/*--.. Operations on phi nodes .............................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMAddIncoming">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2356,
 FQN="LLVMAddIncoming", NM="_Z15LLVMAddIncoming",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMAddIncoming")
//</editor-fold>
public static void LLVMAddIncoming( LLVMOpaqueValue /*P*/ PhiNode, type$ptr<LLVMOpaqueValue /*P*/ /*P*/> IncomingValues, 
               type$ptr<LLVMOpaqueBasicBlock /*P*/ /*P*/> IncomingBlocks, /*uint*/int Count) {
  PHINode /*P*/ PhiVal = IrLlvmGlobals.<PHINode>unwrap_LLVMOpaqueValue$P(PHINode.class, PhiNode);
  for (/*uint*/int I = 0; I != Count; ++I)  {
    PhiVal.addIncoming(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(IncomingValues.$at(I)), IrLlvmGlobals.unwrap(IncomingBlocks.$at(I)));
  }
}


/**
* Obtain the number of incoming basic blocks to a PHI node.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMCountIncoming">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2363,
 FQN="LLVMCountIncoming", NM="_Z17LLVMCountIncoming",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMCountIncoming")
//</editor-fold>
public static /*uint*/int LLVMCountIncoming( LLVMOpaqueValue /*P*/ PhiNode) {
  return IrLlvmGlobals.<PHINode>unwrap_LLVMOpaqueValue$P(PHINode.class, PhiNode).getNumIncomingValues();
}


/**
* Obtain an incoming value to a PHI node as an LLVMValueRef.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetIncomingValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2367,
 FQN="LLVMGetIncomingValue", NM="_Z20LLVMGetIncomingValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetIncomingValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetIncomingValue( LLVMOpaqueValue /*P*/ PhiNode, /*uint*/int Index) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.<PHINode>unwrap_LLVMOpaqueValue$P(PHINode.class, PhiNode).getIncomingValue(Index));
}


/**
* Obtain an incoming value to a PHI node as an LLVMBasicBlockRef.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetIncomingBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2371,
 FQN="LLVMGetIncomingBlock", NM="_Z20LLVMGetIncomingBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetIncomingBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetIncomingBlock( LLVMOpaqueValue /*P*/ PhiNode, /*uint*/int Index) {
  return IrLlvmGlobals.wrap(IrLlvmGlobals.<PHINode>unwrap_LLVMOpaqueValue$P(PHINode.class, PhiNode).getIncomingBlock(Index));
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreValueInstructionExtractValue ExtractValue
* @defgroup LLVMCCoreValueInstructionInsertValue InsertValue
*
* Functions in this group only apply to instructions that map to
* llvm::ExtractValue and llvm::InsertValue instances.
*
* @{
*/

/**
* Obtain the number of indices.
* NB: This also works on GEP.
*/

/*--.. Operations on extractvalue and insertvalue nodes ....................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNumIndices">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2377,
 FQN="LLVMGetNumIndices", NM="_Z17LLVMGetNumIndices",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetNumIndices")
//</editor-fold>
public static /*uint*/int LLVMGetNumIndices( LLVMOpaqueValue /*P*/ Inst) {
  Value /*P*/ I = IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Inst);
  {
    GetElementPtrInst /*P*/ GEP = dyn_cast_GetElementPtrInst(I);
    if ((GEP != null)) {
      return GEP.getNumIndices();
    }
  }
  {
    ExtractValueInst /*P*/ EV = dyn_cast_ExtractValueInst(I);
    if ((EV != null)) {
      return EV.getNumIndices();
    }
  }
  {
    InsertValueInst /*P*/ IV = dyn_cast_InsertValueInst(I);
    if ((IV != null)) {
      return IV.getNumIndices();
    }
  }
  throw new llvm_unreachable("LLVMGetNumIndices applies only to extractvalue and insertvalue!");
}


/**
* Obtain the indices as an array.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetIndices">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2389,
 FQN="LLVMGetIndices", NM="_Z14LLVMGetIndices",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMGetIndices")
//</editor-fold>
public static /*const*/uint$ptr/*uint P*/ LLVMGetIndices( LLVMOpaqueValue /*P*/ Inst) {
  Value /*P*/ I = IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Inst);
  {
    ExtractValueInst /*P*/ EV = dyn_cast_ExtractValueInst(I);
    if ((EV != null)) {
      return EV.getIndices().data();
    }
  }
  {
    InsertValueInst /*P*/ IV = dyn_cast_InsertValueInst(I);
    if ((IV != null)) {
      return IV.getIndices().data();
    }
  }
  throw new llvm_unreachable("LLVMGetIndices applies only to extractvalue and insertvalue!");
}


/**
* @}
*/

/**
* @}
*/

/**
* @}
*/

/**
* @defgroup LLVMCCoreInstructionBuilder Instruction Builders
*
* An instruction builder represents a point within a basic block and is
* the exclusive means of building instructions using the C interface.
*
* @{
*/

/*===-- Instruction builders ----------------------------------------------===*/
//<editor-fold defaultstate="collapsed" desc="LLVMCreateBuilderInContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2402,
 FQN="LLVMCreateBuilderInContext", NM="_Z26LLVMCreateBuilderInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMCreateBuilderInContext")
//</editor-fold>
public static  LLVMOpaqueBuilder /*P*/ LLVMCreateBuilderInContext( LLVMOpaqueContext /*P*/ C) {
  return IrLlvmGlobals.wrap(new IRBuilder($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C))));
}

//<editor-fold defaultstate="collapsed" desc="LLVMCreateBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2406,
 FQN="LLVMCreateBuilder", NM="_Z17LLVMCreateBuilder",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMCreateBuilder")
//</editor-fold>
public static  LLVMOpaqueBuilder /*P*/ LLVMCreateBuilder() {
  return LLVMCreateBuilderInContext(LLVMGetGlobalContext());
}

//<editor-fold defaultstate="collapsed" desc="LLVMPositionBuilder">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2410,
 FQN="LLVMPositionBuilder", NM="_Z19LLVMPositionBuilder",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMPositionBuilder")
//</editor-fold>
public static void LLVMPositionBuilder( LLVMOpaqueBuilder /*P*/ Builder,  LLVMOpaqueBasicBlock /*P*/ Block, 
                    LLVMOpaqueValue /*P*/ Instr) {
  BasicBlock /*P*/ BB = IrLlvmGlobals.unwrap(Block);
  Instruction /*P*/ I = (Instr != null) ? IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Instr) :
          (Instruction /*P*/ )BB.end().$star()/*.$pointer$bidirectional_iterator_tag$NodeTy$int()*/;
  IrLlvmGlobals.unwrap(Builder).SetInsertPoint(BB, I.getIterator());
}

//<editor-fold defaultstate="collapsed" desc="LLVMPositionBuilderBefore">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2417,
 FQN="LLVMPositionBuilderBefore", NM="_Z25LLVMPositionBuilderBefore",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMPositionBuilderBefore")
//</editor-fold>
public static void LLVMPositionBuilderBefore( LLVMOpaqueBuilder /*P*/ Builder,  LLVMOpaqueValue /*P*/ Instr) {
  Instruction /*P*/ I = IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Instr);
  IrLlvmGlobals.unwrap(Builder).SetInsertPoint(I.getParent(), I.getIterator());
}

//<editor-fold defaultstate="collapsed" desc="LLVMPositionBuilderAtEnd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2422,
 FQN="LLVMPositionBuilderAtEnd", NM="_Z24LLVMPositionBuilderAtEnd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMPositionBuilderAtEnd")
//</editor-fold>
public static void LLVMPositionBuilderAtEnd( LLVMOpaqueBuilder /*P*/ Builder,  LLVMOpaqueBasicBlock /*P*/ Block) {
  BasicBlock /*P*/ BB = IrLlvmGlobals.unwrap(Block);
  IrLlvmGlobals.unwrap(Builder).SetInsertPoint(BB);
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetInsertBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2427,
 FQN="LLVMGetInsertBlock", NM="_Z18LLVMGetInsertBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetInsertBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetInsertBlock( LLVMOpaqueBuilder /*P*/ Builder) {
  return IrLlvmGlobals.wrap(IrLlvmGlobals.unwrap(Builder).GetInsertBlock());
}

//<editor-fold defaultstate="collapsed" desc="LLVMClearInsertionPosition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2431,
 FQN="LLVMClearInsertionPosition", NM="_Z26LLVMClearInsertionPosition",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMClearInsertionPosition")
//</editor-fold>
public static void LLVMClearInsertionPosition( LLVMOpaqueBuilder /*P*/ Builder) {
  IrLlvmGlobals.unwrap(Builder).ClearInsertionPoint();
}

//<editor-fold defaultstate="collapsed" desc="LLVMInsertIntoBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2435,
 FQN="LLVMInsertIntoBuilder", NM="_Z21LLVMInsertIntoBuilder",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMInsertIntoBuilder")
//</editor-fold>
public static void LLVMInsertIntoBuilder( LLVMOpaqueBuilder /*P*/ Builder,  LLVMOpaqueValue /*P*/ Instr) {
  IrLlvmGlobals.unwrap(Builder).Insert$T(IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Instr));
}

//<editor-fold defaultstate="collapsed" desc="LLVMInsertIntoBuilderWithName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2439,
 FQN="LLVMInsertIntoBuilderWithName", NM="_Z29LLVMInsertIntoBuilderWithName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMInsertIntoBuilderWithName")
//</editor-fold>
public static void LLVMInsertIntoBuilderWithName( LLVMOpaqueBuilder /*P*/ Builder,  LLVMOpaqueValue /*P*/ Instr, 
                             /*const*/char$ptr/*char P*/ Name) {
  IrLlvmGlobals.unwrap(Builder).Insert$T(IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Instr), new Twine(Name));
}

//<editor-fold defaultstate="collapsed" desc="LLVMDisposeBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2444,
 FQN="LLVMDisposeBuilder", NM="_Z18LLVMDisposeBuilder",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMDisposeBuilder")
//</editor-fold>
public static void LLVMDisposeBuilder( LLVMOpaqueBuilder /*P*/ Builder) {
  /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)IrLlvmGlobals.unwrap(Builder));
}


/* Metadata */

/*--.. Metadata builders ...................................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetCurrentDebugLocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2450,
 FQN="LLVMSetCurrentDebugLocation", NM="_Z27LLVMSetCurrentDebugLocation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMSetCurrentDebugLocation")
//</editor-fold>
public static void LLVMSetCurrentDebugLocation( LLVMOpaqueBuilder /*P*/ Builder,  LLVMOpaqueValue /*P*/ L) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    MDNode /*P*/ Loc = (L != null) ? cast_MDNode(IrLlvmGlobals.<MetadataAsValue>unwrap_LLVMOpaqueValue$P(MetadataAsValue.class, L).getMetadata()) : null;
    IrLlvmGlobals.unwrap(Builder).SetCurrentDebugLocation($c$.track(new DebugLoc(Loc))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetCurrentDebugLocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2456,
 FQN="LLVMGetCurrentDebugLocation", NM="_Z27LLVMGetCurrentDebugLocation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMGetCurrentDebugLocation")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetCurrentDebugLocation( LLVMOpaqueBuilder /*P*/ Builder) {
  final LLVMContext /*&*/ Context = IrLlvmGlobals.unwrap(Builder).getContext();
  return IrLlvmGlobals.wrap_Value$C$P(MetadataAsValue.get(Context, IrLlvmGlobals.unwrap(Builder).getCurrentDebugLocation().getAsMDNode()));
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetInstDebugLocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2462,
 FQN="LLVMSetInstDebugLocation", NM="_Z24LLVMSetInstDebugLocation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMSetInstDebugLocation")
//</editor-fold>
public static void LLVMSetInstDebugLocation( LLVMOpaqueBuilder /*P*/ Builder,  LLVMOpaqueValue /*P*/ Inst) {
  IrLlvmGlobals.unwrap(Builder).SetInstDebugLocation(IrLlvmGlobals.<Instruction>unwrap_LLVMOpaqueValue$P(Instruction.class, Inst));
}


/* Terminators */

/*--.. Instruction builders ................................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMBuildRetVoid">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2469,
 FQN="LLVMBuildRetVoid", NM="_Z16LLVMBuildRetVoid",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMBuildRetVoid")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildRetVoid( LLVMOpaqueBuilder /*P*/ B) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateRetVoid());
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildRet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2473,
 FQN="LLVMBuildRet", NM="_Z12LLVMBuildRet",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildRet")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildRet( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ V) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateRet(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(V)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildAggregateRet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2477,
 FQN="LLVMBuildAggregateRet", NM="_Z21LLVMBuildAggregateRet",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMBuildAggregateRet")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildAggregateRet( LLVMOpaqueBuilder /*P*/ B, type$ptr<LLVMOpaqueValue /*P*/ /*P*/> RetVals, 
                     /*uint*/int N) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateAggregateRet(IrLlvmGlobals.unwrap_type$ptr$LLVMOpaqueValue$P$P(RetVals), N));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildBr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2482,
 FQN="LLVMBuildBr", NM="_Z11LLVMBuildBr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z11LLVMBuildBr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildBr( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueBasicBlock /*P*/ Dest) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateBr(IrLlvmGlobals.unwrap(Dest)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildCondBr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2486,
 FQN="LLVMBuildCondBr", NM="_Z15LLVMBuildCondBr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildCondBr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildCondBr( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ If, 
                LLVMOpaqueBasicBlock /*P*/ Then,  LLVMOpaqueBasicBlock /*P*/ Else) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateCondBr(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(If), IrLlvmGlobals.unwrap(Then), IrLlvmGlobals.unwrap(Else)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildSwitch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2491,
 FQN="LLVMBuildSwitch", NM="_Z15LLVMBuildSwitch",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildSwitch")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildSwitch( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ V, 
                LLVMOpaqueBasicBlock /*P*/ Else, /*uint*/int NumCases) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateSwitch(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(V), IrLlvmGlobals.unwrap(Else), NumCases));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildIndirectBr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2496,
 FQN="LLVMBuildIndirectBr", NM="_Z19LLVMBuildIndirectBr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMBuildIndirectBr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildIndirectBr( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Addr, 
                   /*uint*/int NumDests) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateIndirectBr(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Addr), NumDests));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildInvoke">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2501,
 FQN="LLVMBuildInvoke", NM="_Z15LLVMBuildInvoke",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildInvoke")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildInvoke( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Fn, 
               type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Args, /*uint*/int NumArgs, 
                LLVMOpaqueBasicBlock /*P*/ Then,  LLVMOpaqueBasicBlock /*P*/ Catch, 
               /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateInvoke(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Fn), IrLlvmGlobals.unwrap(Then), IrLlvmGlobals.unwrap(Catch), 
          makeArrayRef(IrLlvmGlobals.unwrap_type$ptr$LLVMOpaqueValue$P$P(Args), NumArgs), 
          new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildLandingPad">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2510,
 FQN="LLVMBuildLandingPad", NM="_Z19LLVMBuildLandingPad",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMBuildLandingPad")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildLandingPad( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueType /*P*/ Ty, 
                    LLVMOpaqueValue /*P*/ PersFn, /*uint*/int NumClauses, 
                   /*const*/char$ptr/*char P*/ Name) {
  // The personality used to live on the landingpad instruction, but now it
  // lives on the parent function. For compatibility, take the provided
  // personality and put it on the parent function.
  if ((PersFn != null)) {
    IrLlvmGlobals.unwrap(B).GetInsertBlock().getParent().setPersonalityFn(cast_Function(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(PersFn)));
  }
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateLandingPad(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty), NumClauses, new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildResume">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2522,
 FQN="LLVMBuildResume", NM="_Z15LLVMBuildResume",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildResume")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildResume( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Exn) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateResume(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Exn)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildUnreachable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2526,
 FQN="LLVMBuildUnreachable", NM="_Z20LLVMBuildUnreachable",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMBuildUnreachable")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildUnreachable( LLVMOpaqueBuilder /*P*/ B) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateUnreachable());
}


/* Add a case to the switch instruction */
//<editor-fold defaultstate="collapsed" desc="LLVMAddCase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2530,
 FQN="LLVMAddCase", NM="_Z11LLVMAddCase",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z11LLVMAddCase")
//</editor-fold>
public static void LLVMAddCase( LLVMOpaqueValue /*P*/ Switch,  LLVMOpaqueValue /*P*/ OnVal, 
            LLVMOpaqueBasicBlock /*P*/ Dest) {
  IrLlvmGlobals.<SwitchInst>unwrap_LLVMOpaqueValue$P(SwitchInst.class, Switch).addCase(IrLlvmGlobals.<ConstantInt>unwrap_LLVMOpaqueValue$P(ConstantInt.class, OnVal), IrLlvmGlobals.unwrap(Dest));
}


/* Add a destination to the indirectbr instruction */
//<editor-fold defaultstate="collapsed" desc="LLVMAddDestination">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2535,
 FQN="LLVMAddDestination", NM="_Z18LLVMAddDestination",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMAddDestination")
//</editor-fold>
public static void LLVMAddDestination( LLVMOpaqueValue /*P*/ IndirectBr,  LLVMOpaqueBasicBlock /*P*/ Dest) {
  IrLlvmGlobals.<IndirectBrInst>unwrap_LLVMOpaqueValue$P(IndirectBrInst.class, IndirectBr).addDestination(IrLlvmGlobals.unwrap(Dest));
}


/* Get the number of clauses on the landingpad instruction */
//<editor-fold defaultstate="collapsed" desc="LLVMGetNumClauses">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2539,
 FQN="LLVMGetNumClauses", NM="_Z17LLVMGetNumClauses",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetNumClauses")
//</editor-fold>
public static /*uint*/int LLVMGetNumClauses( LLVMOpaqueValue /*P*/ LandingPad) {
  return IrLlvmGlobals.<LandingPadInst>unwrap_LLVMOpaqueValue$P(LandingPadInst.class, LandingPad).getNumClauses();
}


/* Get the value of the clause at idnex Idx on the landingpad instruction */
//<editor-fold defaultstate="collapsed" desc="LLVMGetClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2543,
 FQN="LLVMGetClause", NM="_Z13LLVMGetClause",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMGetClause")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetClause( LLVMOpaqueValue /*P*/ LandingPad, /*uint*/int Idx) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.<LandingPadInst>unwrap_LLVMOpaqueValue$P(LandingPadInst.class, LandingPad).getClause(Idx));
}


/* Add a catch or filter clause to the landingpad instruction */
//<editor-fold defaultstate="collapsed" desc="LLVMAddClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2547,
 FQN="LLVMAddClause", NM="_Z13LLVMAddClause",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMAddClause")
//</editor-fold>
public static void LLVMAddClause( LLVMOpaqueValue /*P*/ LandingPad,  LLVMOpaqueValue /*P*/ ClauseVal) {
  IrLlvmGlobals.<LandingPadInst>unwrap_LLVMOpaqueValue$P(LandingPadInst.class, LandingPad).
      addClause(cast_Constant(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(ClauseVal)));
}


/* Get the 'cleanup' flag in the landingpad instruction */
//<editor-fold defaultstate="collapsed" desc="LLVMIsCleanup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2552,
 FQN="LLVMIsCleanup", NM="_Z13LLVMIsCleanup",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMIsCleanup")
//</editor-fold>
public static int LLVMIsCleanup( LLVMOpaqueValue /*P*/ LandingPad) {
  return (IrLlvmGlobals.<LandingPadInst>unwrap_LLVMOpaqueValue$P(LandingPadInst.class, LandingPad).isCleanup() ? 1 : 0);
}


/* Set the 'cleanup' flag in the landingpad instruction */
//<editor-fold defaultstate="collapsed" desc="LLVMSetCleanup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2556,
 FQN="LLVMSetCleanup", NM="_Z14LLVMSetCleanup",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMSetCleanup")
//</editor-fold>
public static void LLVMSetCleanup( LLVMOpaqueValue /*P*/ LandingPad, int Val) {
  IrLlvmGlobals.<LandingPadInst>unwrap_LLVMOpaqueValue$P(LandingPadInst.class, LandingPad).setCleanup((Val != 0));
}


/* Arithmetic */

/*--.. Arithmetic ..........................................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMBuildAdd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2562,
 FQN="LLVMBuildAdd", NM="_Z12LLVMBuildAdd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildAdd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildAdd( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
            /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateAdd(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNSWAdd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2567,
 FQN="LLVMBuildNSWAdd", NM="_Z15LLVMBuildNSWAdd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildNSWAdd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNSWAdd( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
               /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateNSWAdd(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNUWAdd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2572,
 FQN="LLVMBuildNUWAdd", NM="_Z15LLVMBuildNUWAdd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildNUWAdd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNUWAdd( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
               /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateNUWAdd(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFAdd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2577,
 FQN="LLVMBuildFAdd", NM="_Z13LLVMBuildFAdd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildFAdd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFAdd( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateFAdd(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildSub">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2582,
 FQN="LLVMBuildSub", NM="_Z12LLVMBuildSub",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildSub")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildSub( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
            /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateSub(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNSWSub">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2587,
 FQN="LLVMBuildNSWSub", NM="_Z15LLVMBuildNSWSub",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildNSWSub")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNSWSub( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
               /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateNSWSub(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNUWSub">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2592,
 FQN="LLVMBuildNUWSub", NM="_Z15LLVMBuildNUWSub",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildNUWSub")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNUWSub( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
               /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateNUWSub(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFSub">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2597,
 FQN="LLVMBuildFSub", NM="_Z13LLVMBuildFSub",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildFSub")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFSub( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateFSub(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildMul">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2602,
 FQN="LLVMBuildMul", NM="_Z12LLVMBuildMul",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildMul")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildMul( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
            /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateMul(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNSWMul">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2607,
 FQN="LLVMBuildNSWMul", NM="_Z15LLVMBuildNSWMul",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildNSWMul")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNSWMul( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
               /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateNSWMul(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNUWMul">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2612,
 FQN="LLVMBuildNUWMul", NM="_Z15LLVMBuildNUWMul",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildNUWMul")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNUWMul( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
               /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateNUWMul(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFMul">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2617,
 FQN="LLVMBuildFMul", NM="_Z13LLVMBuildFMul",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildFMul")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFMul( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateFMul(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildUDiv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2622,
 FQN="LLVMBuildUDiv", NM="_Z13LLVMBuildUDiv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildUDiv")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildUDiv( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateUDiv(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildSDiv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2627,
 FQN="LLVMBuildSDiv", NM="_Z13LLVMBuildSDiv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildSDiv")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildSDiv( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateSDiv(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildExactSDiv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2632,
 FQN="LLVMBuildExactSDiv", NM="_Z18LLVMBuildExactSDiv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMBuildExactSDiv")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildExactSDiv( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS, 
                   LLVMOpaqueValue /*P*/ RHS, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateExactSDiv(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFDiv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2637,
 FQN="LLVMBuildFDiv", NM="_Z13LLVMBuildFDiv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildFDiv")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFDiv( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateFDiv(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildURem">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2642,
 FQN="LLVMBuildURem", NM="_Z13LLVMBuildURem",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildURem")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildURem( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateURem(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildSRem">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2647,
 FQN="LLVMBuildSRem", NM="_Z13LLVMBuildSRem",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildSRem")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildSRem( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateSRem(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFRem">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2652,
 FQN="LLVMBuildFRem", NM="_Z13LLVMBuildFRem",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildFRem")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFRem( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateFRem(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildShl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2657,
 FQN="LLVMBuildShl", NM="_Z12LLVMBuildShl",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildShl")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildShl( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
            /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateShl(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildLShr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2662,
 FQN="LLVMBuildLShr", NM="_Z13LLVMBuildLShr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildLShr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildLShr( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateLShr(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildAShr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2667,
 FQN="LLVMBuildAShr", NM="_Z13LLVMBuildAShr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildAShr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildAShr( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateAShr(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildAnd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2672,
 FQN="LLVMBuildAnd", NM="_Z12LLVMBuildAnd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildAnd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildAnd( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
            /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateAnd(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildOr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2677,
 FQN="LLVMBuildOr", NM="_Z11LLVMBuildOr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z11LLVMBuildOr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildOr( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
           /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateOr(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildXor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2682,
 FQN="LLVMBuildXor", NM="_Z12LLVMBuildXor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildXor")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildXor( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
            /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateXor(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildBinOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2687,
 FQN="LLVMBuildBinOp", NM="_Z14LLVMBuildBinOp",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMBuildBinOp")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildBinOp( LLVMOpaqueBuilder /*P*/ B, LLVMOpcode Op, 
               LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
              /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateBinOp(map_from_llvmopcode(Op), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), 
          IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNeg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2694,
 FQN="LLVMBuildNeg", NM="_Z12LLVMBuildNeg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildNeg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNeg( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ V, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateNeg(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(V), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNSWNeg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2698,
 FQN="LLVMBuildNSWNeg", NM="_Z15LLVMBuildNSWNeg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildNSWNeg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNSWNeg( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ V, 
               /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateNSWNeg(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(V), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNUWNeg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2703,
 FQN="LLVMBuildNUWNeg", NM="_Z15LLVMBuildNUWNeg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildNUWNeg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNUWNeg( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ V, 
               /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateNUWNeg(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(V), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFNeg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2708,
 FQN="LLVMBuildFNeg", NM="_Z13LLVMBuildFNeg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildFNeg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFNeg( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ V, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateFNeg(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(V), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNot">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2712,
 FQN="LLVMBuildNot", NM="_Z12LLVMBuildNot",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildNot")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNot( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ V, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateNot(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(V), new Twine(Name)));
}


/* Memory */

/*--.. Memory ..............................................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMBuildMalloc">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2718,
 FQN="LLVMBuildMalloc", NM="_Z15LLVMBuildMalloc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildMalloc")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildMalloc( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueType /*P*/ Ty, 
               /*const*/char$ptr/*char P*/ Name) {
  Type /*P*/ ITy = Type.getInt32Ty(IrLlvmGlobals.unwrap(B).GetInsertBlock().getContext());
  Constant /*P*/ AllocSize = ConstantExpr.getSizeOf(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty));
  AllocSize = ConstantExpr.getTruncOrBitCast(AllocSize, ITy);
  Instruction /*P*/ Malloc = CallInst.CreateMalloc(IrLlvmGlobals.unwrap(B).GetInsertBlock(), 
      ITy, IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty), AllocSize, 
      (Value /*P*/ )null, (Function /*P*/ )null, new Twine(/*KEEP_STR*/$EMPTY));
  return IrLlvmGlobals.wrap_Value$C$P((Value)IrLlvmGlobals.unwrap(B).Insert$T(Malloc, new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildArrayMalloc">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2729,
 FQN="LLVMBuildArrayMalloc", NM="_Z20LLVMBuildArrayMalloc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMBuildArrayMalloc")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildArrayMalloc( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueType /*P*/ Ty, 
                     LLVMOpaqueValue /*P*/ Val, /*const*/char$ptr/*char P*/ Name) {
  Type /*P*/ ITy = Type.getInt32Ty(IrLlvmGlobals.unwrap(B).GetInsertBlock().getContext());
  Constant /*P*/ AllocSize = ConstantExpr.getSizeOf(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty));
  AllocSize = ConstantExpr.getTruncOrBitCast(AllocSize, ITy);
  Instruction /*P*/ Malloc = CallInst.CreateMalloc(IrLlvmGlobals.unwrap(B).GetInsertBlock(), 
      ITy, IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty), AllocSize, 
      IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), (Function /*P*/ )null, new Twine(/*KEEP_STR*/$EMPTY));
  return IrLlvmGlobals.wrap_Value$C$P((Value)IrLlvmGlobals.unwrap(B).Insert$T(Malloc, new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildAlloca">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2740,
 FQN="LLVMBuildAlloca", NM="_Z15LLVMBuildAlloca",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildAlloca")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildAlloca( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueType /*P*/ Ty, 
               /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateAlloca(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty), (Value /*P*/ )null, new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildArrayAlloca">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2745,
 FQN="LLVMBuildArrayAlloca", NM="_Z20LLVMBuildArrayAlloca",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMBuildArrayAlloca")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildArrayAlloca( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueType /*P*/ Ty, 
                     LLVMOpaqueValue /*P*/ Val, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateAlloca(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFree">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2750,
 FQN="LLVMBuildFree", NM="_Z13LLVMBuildFree",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildFree")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFree( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ PointerVal) {
  return IrLlvmGlobals.wrap_Value$C$P((Value)IrLlvmGlobals.unwrap(B).Insert$T(CallInst.CreateFree(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(PointerVal), IrLlvmGlobals.unwrap(B).GetInsertBlock())));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildLoad">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2755,
 FQN="LLVMBuildLoad", NM="_Z13LLVMBuildLoad",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildLoad")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildLoad( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ PointerVal, 
             /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateLoad(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(PointerVal), Name));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildStore">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2760,
 FQN="LLVMBuildStore", NM="_Z14LLVMBuildStore",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMBuildStore")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildStore( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
               LLVMOpaqueValue /*P*/ PointerVal) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateStore(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(PointerVal)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildGEP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2805,
 FQN="LLVMBuildGEP", NM="_Z12LLVMBuildGEP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildGEP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildGEP( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Pointer, 
            type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Indices, /*uint*/int NumIndices, 
            /*const*/char$ptr/*char P*/ Name) {
  ArrayRef<Value /*P*/ > IdxList/*J*/= new ArrayRef<Value /*P*/ >(IrLlvmGlobals.unwrap_type$ptr$LLVMOpaqueValue$P$P(Indices), NumIndices, true);
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateGEP((Type /*P*/ )null, IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Pointer), new ArrayRef<Value /*P*/ >(IdxList), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildInBoundsGEP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2812,
 FQN="LLVMBuildInBoundsGEP", NM="_Z20LLVMBuildInBoundsGEP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMBuildInBoundsGEP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildInBoundsGEP( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Pointer, 
                    type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Indices, /*uint*/int NumIndices, 
                    /*const*/char$ptr/*char P*/ Name) {
  ArrayRef<Value /*P*/ > IdxList/*J*/= new ArrayRef<Value /*P*/ >(IrLlvmGlobals.unwrap_type$ptr$LLVMOpaqueValue$P$P(Indices), NumIndices, true);
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateInBoundsGEP((Type /*P*/ )null, IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Pointer), new ArrayRef<Value /*P*/ >(IdxList), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildStructGEP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2820,
 FQN="LLVMBuildStructGEP", NM="_Z18LLVMBuildStructGEP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMBuildStructGEP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildStructGEP( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Pointer, 
                  /*uint*/int Idx, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateStructGEP((Type /*P*/ )null, IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Pointer), Idx, new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildGlobalString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2825,
 FQN="LLVMBuildGlobalString", NM="_Z21LLVMBuildGlobalString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMBuildGlobalString")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildGlobalString( LLVMOpaqueBuilder /*P*/ B, /*const*/char$ptr/*char P*/ Str, 
                     /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateGlobalString(new StringRef(Str), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildGlobalStringPtr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2830,
 FQN="LLVMBuildGlobalStringPtr", NM="_Z24LLVMBuildGlobalStringPtr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMBuildGlobalStringPtr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildGlobalStringPtr( LLVMOpaqueBuilder /*P*/ B, /*const*/char$ptr/*char P*/ Str, 
                        /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateGlobalStringPtr(new StringRef(Str), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetVolatile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2835,
 FQN="LLVMGetVolatile", NM="_Z15LLVMGetVolatile",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMGetVolatile")
//</editor-fold>
public static int LLVMGetVolatile( LLVMOpaqueValue /*P*/ MemAccessInst) {
  Value /*P*/ P = IrLlvmGlobals.<Value>unwrap_LLVMOpaqueValue$P(Value.class, MemAccessInst);
  {
    LoadInst /*P*/ LI = dyn_cast_LoadInst(P);
    if ((LI != null)) {
      return (LI.isVolatile() ? 1 : 0);
    }
  }
  return (cast_StoreInst(P).isVolatile() ? 1 : 0);
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetVolatile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2842,
 FQN="LLVMSetVolatile", NM="_Z15LLVMSetVolatile",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMSetVolatile")
//</editor-fold>
public static void LLVMSetVolatile( LLVMOpaqueValue /*P*/ MemAccessInst, int isVolatile) {
  Value /*P*/ P = IrLlvmGlobals.<Value>unwrap_LLVMOpaqueValue$P(Value.class, MemAccessInst);
  {
    LoadInst /*P*/ LI = dyn_cast_LoadInst(P);
    if ((LI != null)) {
      LI.setVolatile((isVolatile != 0));
      /*JAVA:return*/return;
    }
  }
  cast_StoreInst(P).setVolatile((isVolatile != 0));
  /*JAVA:return*/return;
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetOrdering">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2849,
 FQN="LLVMGetOrdering", NM="_Z15LLVMGetOrdering",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMGetOrdering")
//</editor-fold>
public static LLVMAtomicOrdering LLVMGetOrdering( LLVMOpaqueValue /*P*/ MemAccessInst) {
  Value /*P*/ P = IrLlvmGlobals.<Value>unwrap_LLVMOpaqueValue$P(Value.class, MemAccessInst);
  AtomicOrdering O;
  {
    LoadInst /*P*/ LI = dyn_cast_LoadInst(P);
    if ((LI != null)) {
      O = LI.getOrdering();
    } else {
      O = cast_StoreInst(P).getOrdering();
    }
  }
  return mapToLLVMOrdering(O);
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetOrdering">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2859,
 FQN="LLVMSetOrdering", NM="_Z15LLVMSetOrdering",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMSetOrdering")
//</editor-fold>
public static void LLVMSetOrdering( LLVMOpaqueValue /*P*/ MemAccessInst, LLVMAtomicOrdering Ordering) {
  Value /*P*/ P = IrLlvmGlobals.<Value>unwrap_LLVMOpaqueValue$P(Value.class, MemAccessInst);
  AtomicOrdering O = mapFromLLVMOrdering(Ordering);
  {
    
    LoadInst /*P*/ LI = dyn_cast_LoadInst(P);
    if ((LI != null)) {
      LI.setOrdering(O);
      /*JAVA:return*/return;
    }
  }
  cast_StoreInst(P).setOrdering(O);
  /*JAVA:return*/return;
}


/* Casts */

/*--.. Casts ...............................................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMBuildTrunc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2870,
 FQN="LLVMBuildTrunc", NM="_Z14LLVMBuildTrunc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMBuildTrunc")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildTrunc( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
               LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateTrunc(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildZExt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2875,
 FQN="LLVMBuildZExt", NM="_Z13LLVMBuildZExt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildZExt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildZExt( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
              LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateZExt(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildSExt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2880,
 FQN="LLVMBuildSExt", NM="_Z13LLVMBuildSExt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildSExt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildSExt( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
              LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateSExt(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFPToUI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2885,
 FQN="LLVMBuildFPToUI", NM="_Z15LLVMBuildFPToUI",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildFPToUI")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFPToUI( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateFPToUI(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFPToSI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2890,
 FQN="LLVMBuildFPToSI", NM="_Z15LLVMBuildFPToSI",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildFPToSI")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFPToSI( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateFPToSI(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildUIToFP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2895,
 FQN="LLVMBuildUIToFP", NM="_Z15LLVMBuildUIToFP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildUIToFP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildUIToFP( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateUIToFP(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildSIToFP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2900,
 FQN="LLVMBuildSIToFP", NM="_Z15LLVMBuildSIToFP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildSIToFP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildSIToFP( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateSIToFP(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFPTrunc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2905,
 FQN="LLVMBuildFPTrunc", NM="_Z16LLVMBuildFPTrunc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMBuildFPTrunc")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFPTrunc( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                 LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateFPTrunc(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFPExt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2910,
 FQN="LLVMBuildFPExt", NM="_Z14LLVMBuildFPExt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMBuildFPExt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFPExt( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
               LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateFPExt(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildPtrToInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2915,
 FQN="LLVMBuildPtrToInt", NM="_Z17LLVMBuildPtrToInt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMBuildPtrToInt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildPtrToInt( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                  LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreatePtrToInt(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildIntToPtr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2920,
 FQN="LLVMBuildIntToPtr", NM="_Z17LLVMBuildIntToPtr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMBuildIntToPtr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildIntToPtr( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                  LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateIntToPtr(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildBitCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2925,
 FQN="LLVMBuildBitCast", NM="_Z16LLVMBuildBitCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMBuildBitCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildBitCast( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                 LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateBitCast(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildAddrSpaceCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2930,
 FQN="LLVMBuildAddrSpaceCast", NM="_Z22LLVMBuildAddrSpaceCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMBuildAddrSpaceCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildAddrSpaceCast( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                       LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateAddrSpaceCast(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildZExtOrBitCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2935,
 FQN="LLVMBuildZExtOrBitCast", NM="_Z22LLVMBuildZExtOrBitCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMBuildZExtOrBitCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildZExtOrBitCast( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                       LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateZExtOrBitCast(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), 
          new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildSExtOrBitCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2941,
 FQN="LLVMBuildSExtOrBitCast", NM="_Z22LLVMBuildSExtOrBitCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMBuildSExtOrBitCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildSExtOrBitCast( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                       LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateSExtOrBitCast(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), 
          new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildTruncOrBitCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2947,
 FQN="LLVMBuildTruncOrBitCast", NM="_Z23LLVMBuildTruncOrBitCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMBuildTruncOrBitCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildTruncOrBitCast( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                        LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateTruncOrBitCast(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), 
          new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2953,
 FQN="LLVMBuildCast", NM="_Z13LLVMBuildCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildCast( LLVMOpaqueBuilder /*P*/ B, LLVMOpcode Op,  LLVMOpaqueValue /*P*/ Val, 
              LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateCast(map_from_llvmopcode(Op), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), 
          IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildPointerCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2959,
 FQN="LLVMBuildPointerCast", NM="_Z20LLVMBuildPointerCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMBuildPointerCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildPointerCast( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                     LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreatePointerCast(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildIntCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2964,
 FQN="LLVMBuildIntCast", NM="_Z16LLVMBuildIntCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMBuildIntCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildIntCast( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                 LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateIntCast(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), 
          /*isSigned*/ true, new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFPCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2970,
 FQN="LLVMBuildFPCast", NM="_Z15LLVMBuildFPCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildFPCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFPCast( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateFPCast(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(DestTy), new Twine(Name)));
}


/* Comparisons */

/*--.. Comparisons .........................................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMBuildICmp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2977,
 FQN="LLVMBuildICmp", NM="_Z13LLVMBuildICmp",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildICmp")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildICmp( LLVMOpaqueBuilder /*P*/ B, LLVMIntPredicate Op, 
              LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateICmp(/*static_cast*/ICmpInst.Predicate.valueOf(Op.getValue()), 
          IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFCmp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2984,
 FQN="LLVMBuildFCmp", NM="_Z13LLVMBuildFCmp",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildFCmp")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFCmp( LLVMOpaqueBuilder /*P*/ B, LLVMRealPredicate Op, 
              LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateFCmp(/*static_cast*/FCmpInst.Predicate.valueOf(Op.getValue()), 
          IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}


/* Miscellaneous instructions */

/*--.. Miscellaneous instructions ..........................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMBuildPhi">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2993,
 FQN="LLVMBuildPhi", NM="_Z12LLVMBuildPhi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildPhi")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildPhi( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueType /*P*/ Ty, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreatePHI(IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty), 0, new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2997,
 FQN="LLVMBuildCall", NM="_Z13LLVMBuildCall",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildCall")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildCall( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Fn, 
             type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Args, /*uint*/int NumArgs, 
             /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Fn), 
          makeArrayRef(IrLlvmGlobals.unwrap_type$ptr$LLVMOpaqueValue$P$P(Args), NumArgs), 
          new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildSelect">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3005,
 FQN="LLVMBuildSelect", NM="_Z15LLVMBuildSelect",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildSelect")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildSelect( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ If, 
                LLVMOpaqueValue /*P*/ Then,  LLVMOpaqueValue /*P*/ Else, 
               /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateSelect(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(If), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Then), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Else), 
          new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildVAArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3012,
 FQN="LLVMBuildVAArg", NM="_Z14LLVMBuildVAArg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMBuildVAArg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildVAArg( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ List, 
               LLVMOpaqueType /*P*/ Ty, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateVAArg(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(List), IrLlvmGlobals.unwrap_LLVMOpaqueType$P(Ty), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildExtractElement">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3017,
 FQN="LLVMBuildExtractElement", NM="_Z23LLVMBuildExtractElement",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMBuildExtractElement")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildExtractElement( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ VecVal, 
                        LLVMOpaqueValue /*P*/ Index, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateExtractElement(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(VecVal), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Index), 
          new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildInsertElement">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3023,
 FQN="LLVMBuildInsertElement", NM="_Z22LLVMBuildInsertElement",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMBuildInsertElement")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildInsertElement( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ VecVal, 
                       LLVMOpaqueValue /*P*/ EltVal,  LLVMOpaqueValue /*P*/ Index, 
                      /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateInsertElement(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(VecVal), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(EltVal), 
          IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Index), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildShuffleVector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3030,
 FQN="LLVMBuildShuffleVector", NM="_Z22LLVMBuildShuffleVector",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMBuildShuffleVector")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildShuffleVector( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ V1, 
                       LLVMOpaqueValue /*P*/ V2,  LLVMOpaqueValue /*P*/ Mask, 
                      /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateShuffleVector(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(V1), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(V2), 
          IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Mask), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildExtractValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3037,
 FQN="LLVMBuildExtractValue", NM="_Z21LLVMBuildExtractValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMBuildExtractValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildExtractValue( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ AggVal, 
                     /*uint*/int Index, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateExtractValue(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(AggVal), new ArrayRefUInt(Index), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildInsertValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3042,
 FQN="LLVMBuildInsertValue", NM="_Z20LLVMBuildInsertValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMBuildInsertValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildInsertValue( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ AggVal, 
                     LLVMOpaqueValue /*P*/ EltVal, /*uint*/int Index, 
                    /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateInsertValue(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(AggVal), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(EltVal), 
          new ArrayRefUInt(Index), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildIsNull">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3049,
 FQN="LLVMBuildIsNull", NM="_Z15LLVMBuildIsNull",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildIsNull")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildIsNull( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
               /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateIsNull(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildIsNotNull">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3054,
 FQN="LLVMBuildIsNotNull", NM="_Z18LLVMBuildIsNotNull",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMBuildIsNotNull")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildIsNotNull( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                  /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateIsNotNull(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildPtrDiff">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3059,
 FQN="LLVMBuildPtrDiff", NM="_Z16LLVMBuildPtrDiff",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMBuildPtrDiff")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildPtrDiff( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS, 
                 LLVMOpaqueValue /*P*/ RHS, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreatePtrDiff(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(LHS), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(RHS), new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFence">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2797,
 FQN="LLVMBuildFence", NM="_Z14LLVMBuildFence",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMBuildFence")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFence( LLVMOpaqueBuilder /*P*/ B, LLVMAtomicOrdering Ordering, 
              int isSingleThread, /*const*/char$ptr/*char P*/ Name) {
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateFence(mapFromLLVMOrdering(Ordering), 
          (isSingleThread != 0) ? SynchronizationScope.SingleThread : SynchronizationScope.CrossThread, 
          new Twine(Name)));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildAtomicRMW">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3064,
 FQN="LLVMBuildAtomicRMW", NM="_Z18LLVMBuildAtomicRMW",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMBuildAtomicRMW")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildAtomicRMW( LLVMOpaqueBuilder /*P*/ B, LLVMAtomicRMWBinOp op, 
                   LLVMOpaqueValue /*P*/ PTR,  LLVMOpaqueValue /*P*/ Val, 
                  LLVMAtomicOrdering ordering, 
                  int singleThread) {
  AtomicRMWInst.BinOp intop = AtomicRMWInst.BinOp.Xchg;
  switch (op) {
   case LLVMAtomicRMWBinOpXchg:
    intop = AtomicRMWInst.BinOp.Xchg;
    break;
   case LLVMAtomicRMWBinOpAdd:
    intop = AtomicRMWInst.BinOp.Add;
    break;
   case LLVMAtomicRMWBinOpSub:
    intop = AtomicRMWInst.BinOp.Sub;
    break;
   case LLVMAtomicRMWBinOpAnd:
    intop = AtomicRMWInst.BinOp.And;
    break;
   case LLVMAtomicRMWBinOpNand:
    intop = AtomicRMWInst.BinOp.Nand;
    break;
   case LLVMAtomicRMWBinOpOr:
    intop = AtomicRMWInst.BinOp.Or;
    break;
   case LLVMAtomicRMWBinOpXor:
    intop = AtomicRMWInst.BinOp.Xor;
    break;
   case LLVMAtomicRMWBinOpMax:
    intop = AtomicRMWInst.BinOp.Max;
    break;
   case LLVMAtomicRMWBinOpMin:
    intop = AtomicRMWInst.BinOp.Min;
    break;
   case LLVMAtomicRMWBinOpUMax:
    intop = AtomicRMWInst.BinOp.UMax;
    break;
   case LLVMAtomicRMWBinOpUMin:
    intop = AtomicRMWInst.BinOp.UMin;
    break;
  }
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateAtomicRMW(intop, IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(PTR), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Val), 
          mapFromLLVMOrdering(ordering), (singleThread != 0) ? SynchronizationScope.SingleThread : SynchronizationScope.CrossThread));
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildAtomicCmpXchg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3086,
 FQN="LLVMBuildAtomicCmpXchg", NM="_Z22LLVMBuildAtomicCmpXchg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMBuildAtomicCmpXchg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildAtomicCmpXchg( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Ptr, 
                       LLVMOpaqueValue /*P*/ Cmp,  LLVMOpaqueValue /*P*/ New, 
                      LLVMAtomicOrdering SuccessOrdering, 
                      LLVMAtomicOrdering FailureOrdering, 
                      int singleThread) {
  
  return IrLlvmGlobals.wrap_Value$C$P(IrLlvmGlobals.unwrap(B).CreateAtomicCmpXchg(IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Ptr), IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(Cmp), 
          IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(New), mapFromLLVMOrdering(SuccessOrdering), 
          mapFromLLVMOrdering(FailureOrdering), 
          (singleThread != 0) ? SynchronizationScope.SingleThread : SynchronizationScope.CrossThread));
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAtomicSingleThread">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3099,
 FQN="LLVMIsAtomicSingleThread", NM="_Z24LLVMIsAtomicSingleThread",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMIsAtomicSingleThread")
//</editor-fold>
public static int LLVMIsAtomicSingleThread( LLVMOpaqueValue /*P*/ AtomicInst) {
  Value /*P*/ P = IrLlvmGlobals.<Value>unwrap_LLVMOpaqueValue$P(Value.class, AtomicInst);
  {
    
    AtomicRMWInst /*P*/ I = dyn_cast_AtomicRMWInst(P);
    if ((I != null)) {
      return ((I.getSynchScope() == SynchronizationScope.SingleThread) ? 1 : 0);
    }
  }
  return ((cast_AtomicCmpXchgInst(P).getSynchScope() == SynchronizationScope.SingleThread) ? 1 : 0);
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetAtomicSingleThread">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3107,
 FQN="LLVMSetAtomicSingleThread", NM="_Z25LLVMSetAtomicSingleThread",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMSetAtomicSingleThread")
//</editor-fold>
public static void LLVMSetAtomicSingleThread( LLVMOpaqueValue /*P*/ AtomicInst, int NewValue) {
  Value /*P*/ P = IrLlvmGlobals.<Value>unwrap_LLVMOpaqueValue$P(Value.class, AtomicInst);
  SynchronizationScope Sync = (NewValue != 0) ? SynchronizationScope.SingleThread : SynchronizationScope.CrossThread;
  {
    
    AtomicRMWInst /*P*/ I = dyn_cast_AtomicRMWInst(P);
    if ((I != null)) {
      I.setSynchScope(Sync);
      /*JAVA:return*/return;
    }
  }
  cast_AtomicCmpXchgInst(P).setSynchScope(Sync);
  /*JAVA:return*/return;
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetCmpXchgSuccessOrdering">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3116,
 FQN="LLVMGetCmpXchgSuccessOrdering", NM="_Z29LLVMGetCmpXchgSuccessOrdering",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMGetCmpXchgSuccessOrdering")
//</editor-fold>
public static LLVMAtomicOrdering LLVMGetCmpXchgSuccessOrdering( LLVMOpaqueValue /*P*/ CmpXchgInst) {
  Value /*P*/ P = IrLlvmGlobals.<Value>unwrap_LLVMOpaqueValue$P(Value.class, CmpXchgInst);
  return mapToLLVMOrdering(cast_AtomicCmpXchgInst(P).getSuccessOrdering());
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetCmpXchgSuccessOrdering">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3121,
 FQN="LLVMSetCmpXchgSuccessOrdering", NM="_Z29LLVMSetCmpXchgSuccessOrdering",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMSetCmpXchgSuccessOrdering")
//</editor-fold>
public static void LLVMSetCmpXchgSuccessOrdering( LLVMOpaqueValue /*P*/ CmpXchgInst, 
                             LLVMAtomicOrdering Ordering) {
  Value /*P*/ P = IrLlvmGlobals.<Value>unwrap_LLVMOpaqueValue$P(Value.class, CmpXchgInst);
  AtomicOrdering O = mapFromLLVMOrdering(Ordering);
  
  cast_AtomicCmpXchgInst(P).setSuccessOrdering(O);
  /*JAVA:return*/return;
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetCmpXchgFailureOrdering">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3129,
 FQN="LLVMGetCmpXchgFailureOrdering", NM="_Z29LLVMGetCmpXchgFailureOrdering",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMGetCmpXchgFailureOrdering")
//</editor-fold>
public static LLVMAtomicOrdering LLVMGetCmpXchgFailureOrdering( LLVMOpaqueValue /*P*/ CmpXchgInst) {
  Value /*P*/ P = IrLlvmGlobals.<Value>unwrap_LLVMOpaqueValue$P(Value.class, CmpXchgInst);
  return mapToLLVMOrdering(cast_AtomicCmpXchgInst(P).getFailureOrdering());
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetCmpXchgFailureOrdering">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3134,
 FQN="LLVMSetCmpXchgFailureOrdering", NM="_Z29LLVMSetCmpXchgFailureOrdering",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMSetCmpXchgFailureOrdering")
//</editor-fold>
public static void LLVMSetCmpXchgFailureOrdering( LLVMOpaqueValue /*P*/ CmpXchgInst, 
                             LLVMAtomicOrdering Ordering) {
  Value /*P*/ P = IrLlvmGlobals.<Value>unwrap_LLVMOpaqueValue$P(Value.class, CmpXchgInst);
  AtomicOrdering O = mapFromLLVMOrdering(Ordering);
  
  cast_AtomicCmpXchgInst(P).setFailureOrdering(O);
  /*JAVA:return*/return;
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreModuleProvider Module Providers
*
* @{
*/

/**
* Changes the type of M so it can be passed to FunctionPassManagers and the
* JIT.  They take ModuleProviders for historical reasons.
*/

/*===-- Module providers --------------------------------------------------===*/
//<editor-fold defaultstate="collapsed" desc="LLVMCreateModuleProviderForExistingModule">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3144,
 FQN="LLVMCreateModuleProviderForExistingModule", NM="_Z41LLVMCreateModuleProviderForExistingModule",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z41LLVMCreateModuleProviderForExistingModule")
//</editor-fold>
public static  LLVMOpaqueModuleProvider /*P*/ LLVMCreateModuleProviderForExistingModule( LLVMOpaqueModule /*P*/ M) {
  return reinterpret_cast( LLVMOpaqueModuleProvider /*P*/ .class, M);
}


/**
* Destroys the module M.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMDisposeModuleProvider">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3149,
 FQN="LLVMDisposeModuleProvider", NM="_Z25LLVMDisposeModuleProvider",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMDisposeModuleProvider")
//</editor-fold>
public static void LLVMDisposeModuleProvider( LLVMOpaqueModuleProvider /*P*/ MP) {
  /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)IrLlvmGlobals.unwrap(MP));
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreMemoryBuffers Memory Buffers
*
* @{
*/

/*===-- Memory buffers ----------------------------------------------------===*/
//<editor-fold defaultstate="collapsed" desc="LLVMCreateMemoryBufferWithContentsOfFile">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3156,
 FQN="LLVMCreateMemoryBufferWithContentsOfFile", NM="_Z40LLVMCreateMemoryBufferWithContentsOfFile",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z40LLVMCreateMemoryBufferWithContentsOfFile")
//</editor-fold>
public static int LLVMCreateMemoryBufferWithContentsOfFile(/*const*/char$ptr/*char P*/ Path, 
                                        type$ptr<LLVMOpaqueMemoryBuffer /*P*/ /*P*/> OutMemBuf, 
                                        type$ptr<char$ptr>/*char PP*/ OutMessage) {
  ErrorOr<std.unique_ptr<MemoryBuffer> > MBOrErr = null;
  try {
    
    MBOrErr = MemoryBuffer.getFile(new Twine(Path));
    {
      std.error_code EC = MBOrErr.getError();
      if (EC.$bool()) {
        OutMessage.$set(strdup(EC.message().c_str()));
        return 1;
      }
    }
    OutMemBuf.$set((LLVMOpaqueMemoryBuffer)wrap(MBOrErr.get().release()));
    return 0;
  } finally {
    if (MBOrErr != null) { MBOrErr.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="LLVMCreateMemoryBufferWithSTDIN">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3170,
 FQN="LLVMCreateMemoryBufferWithSTDIN", NM="_Z31LLVMCreateMemoryBufferWithSTDIN",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z31LLVMCreateMemoryBufferWithSTDIN")
//</editor-fold>
public static int LLVMCreateMemoryBufferWithSTDIN(type$ptr<LLVMOpaqueMemoryBuffer /*P*/ /*P*/> OutMemBuf, 
                               type$ptr<char$ptr>/*char PP*/ OutMessage) {
  ErrorOr<std.unique_ptr<MemoryBuffer> > MBOrErr = null;
  try {
    MBOrErr = MemoryBuffer.getSTDIN();
    {
      std.error_code EC = MBOrErr.getError();
      if (EC.$bool()) {
        OutMessage.$set(strdup(EC.message().c_str()));
        return 1;
      }
    }
    OutMemBuf.$set((LLVMOpaqueMemoryBuffer)wrap(MBOrErr.get().release()));
    return 0;
  } finally {
    if (MBOrErr != null) { MBOrErr.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="LLVMCreateMemoryBufferWithMemoryRange">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3181,
 FQN="LLVMCreateMemoryBufferWithMemoryRange", NM="_Z37LLVMCreateMemoryBufferWithMemoryRange",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z37LLVMCreateMemoryBufferWithMemoryRange")
//</editor-fold>
public static  LLVMOpaqueMemoryBuffer /*P*/ LLVMCreateMemoryBufferWithMemoryRange(/*const*/char$ptr/*char P*/ InputData, 
                                     /*size_t*/int InputDataLength, 
                                     /*const*/char$ptr/*char P*/ BufferName, 
                                     int RequiresNullTerminator) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    
    return $c$.clean((LLVMOpaqueMemoryBuffer)wrap($c$.track(MemoryBuffer.getMemBuffer(new StringRef(InputData, InputDataLength), 
            new StringRef(BufferName), 
            (RequiresNullTerminator != 0))).release()));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="LLVMCreateMemoryBufferWithMemoryRangeCopy">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3192,
 FQN="LLVMCreateMemoryBufferWithMemoryRangeCopy", NM="_Z41LLVMCreateMemoryBufferWithMemoryRangeCopy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z41LLVMCreateMemoryBufferWithMemoryRangeCopy")
//</editor-fold>
public static  LLVMOpaqueMemoryBuffer /*P*/ LLVMCreateMemoryBufferWithMemoryRangeCopy(/*const*/char$ptr/*char P*/ InputData, 
                                         /*size_t*/int InputDataLength, 
                                         /*const*/char$ptr/*char P*/ BufferName) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    
    return $c$.clean((LLVMOpaqueMemoryBuffer)wrap($c$.track(MemoryBuffer.getMemBufferCopy(new StringRef(InputData, InputDataLength), 
            new Twine(/*STRINGREF_STR*/BufferName))).release()));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetBufferStart">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3202,
 FQN="LLVMGetBufferStart", NM="_Z18LLVMGetBufferStart",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetBufferStart")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetBufferStart( LLVMOpaqueMemoryBuffer /*P*/ MemBuf) {
  return unwrap((LLVMMemoryBufferRef)MemBuf).getBufferStart();
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetBufferSize">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3206,
 FQN="LLVMGetBufferSize", NM="_Z17LLVMGetBufferSize",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetBufferSize")
//</editor-fold>
public static /*size_t*/int LLVMGetBufferSize( LLVMOpaqueMemoryBuffer /*P*/ MemBuf) {
  return unwrap((LLVMMemoryBufferRef)MemBuf).getBufferSize();
}

//<editor-fold defaultstate="collapsed" desc="LLVMDisposeMemoryBuffer">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3210,
 FQN="LLVMDisposeMemoryBuffer", NM="_Z23LLVMDisposeMemoryBuffer",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMDisposeMemoryBuffer")
//</editor-fold>
public static void LLVMDisposeMemoryBuffer( LLVMOpaqueMemoryBuffer /*P*/ MemBuf) {
  /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)unwrap((LLVMMemoryBufferRef)MemBuf));
}


/**
* @}
*/

/**
* @defgroup LLVMCCorePassRegistry Pass Registry
*
* @{
*/

/** Return the global pass registry, for use with initialization functions.
@see llvm::PassRegistry::getPassRegistry */

/*===-- Pass Registry -----------------------------------------------------===*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetGlobalPassRegistry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3216,
 FQN="LLVMGetGlobalPassRegistry", NM="_Z25LLVMGetGlobalPassRegistry",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMGetGlobalPassRegistry")
//</editor-fold>
public static  LLVMOpaquePassRegistry /*P*/ LLVMGetGlobalPassRegistry() {
  return IrLlvmGlobals.wrap(PassRegistry.getPassRegistry());
}


/**
* @}
*/

/**
* @defgroup LLVMCCorePassManagers Pass Managers
*
* @{
*/

/** Constructs a new whole-module pass pipeline. This type of pipeline is
suitable for link-time optimization and whole-module transformations.
@see llvm::PassManager::PassManager */

/*===-- Pass Manager ------------------------------------------------------===*/
//<editor-fold defaultstate="collapsed" desc="LLVMCreatePassManager">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3222,
 FQN="LLVMCreatePassManager", NM="_Z21LLVMCreatePassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMCreatePassManager")
//</editor-fold>
public static  LLVMOpaquePassManager /*P*/ LLVMCreatePassManager() {
  return IrLlvmGlobals.wrap(new org.llvm.ir.legacy.PassManager());
}


/** Constructs a new function-by-function pass pipeline over the module
provider. It does not take ownership of the module provider. This type of
pipeline is suitable for code generation and JIT compilation tasks.
@see llvm::FunctionPassManager::FunctionPassManager */
//<editor-fold defaultstate="collapsed" desc="LLVMCreateFunctionPassManagerForModule">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3226,
 FQN="LLVMCreateFunctionPassManagerForModule", NM="_Z38LLVMCreateFunctionPassManagerForModule",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z38LLVMCreateFunctionPassManagerForModule")
//</editor-fold>
public static  LLVMOpaquePassManager /*P*/ LLVMCreateFunctionPassManagerForModule( LLVMOpaqueModule /*P*/ M) {
  return IrLlvmGlobals.wrap(new FunctionPassManager(IrLlvmGlobals.unwrap(M)));
}


/** Deprecated: Use LLVMCreateFunctionPassManagerForModule instead. */
//<editor-fold defaultstate="collapsed" desc="LLVMCreateFunctionPassManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3230,
 FQN="LLVMCreateFunctionPassManager", NM="_Z29LLVMCreateFunctionPassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMCreateFunctionPassManager")
//</editor-fold>
public static  LLVMOpaquePassManager /*P*/ LLVMCreateFunctionPassManager( LLVMOpaqueModuleProvider /*P*/ P) {
  return LLVMCreateFunctionPassManagerForModule(reinterpret_cast( LLVMOpaqueModule /*P*/ .class, P));
}


/** Initializes, executes on the provided module, and finalizes all of the
passes scheduled in the pass manager. Returns 1 if any of the passes
modified the module, 0 otherwise.
@see llvm::PassManager::run(Module&) */
//<editor-fold defaultstate="collapsed" desc="LLVMRunPassManager">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3235,
 FQN="LLVMRunPassManager", NM="_Z18LLVMRunPassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMRunPassManager")
//</editor-fold>
public static int LLVMRunPassManager( LLVMOpaquePassManager /*P*/ PM,  LLVMOpaqueModule /*P*/ M) {
  return (IrLlvmGlobals.<org.llvm.ir.legacy.PassManager>unwrap$T(org.llvm.ir.legacy.PassManager.class, PM).run($Deref(IrLlvmGlobals.unwrap(M))) ? 1 : 0);
}


/** Initializes all of the function passes scheduled in the function pass
manager. Returns 1 if any of the passes modified the module, 0 otherwise.
@see llvm::FunctionPassManager::doInitialization */
//<editor-fold defaultstate="collapsed" desc="LLVMInitializeFunctionPassManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3239,
 FQN="LLVMInitializeFunctionPassManager", NM="_Z33LLVMInitializeFunctionPassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z33LLVMInitializeFunctionPassManager")
//</editor-fold>
public static int LLVMInitializeFunctionPassManager( LLVMOpaquePassManager /*P*/ FPM) {
  return (IrLlvmGlobals.<FunctionPassManager>unwrap$T(FunctionPassManager.class, FPM).doInitialization() ? 1 : 0);
}


/** Executes all of the function passes scheduled in the function pass manager
on the provided function. Returns 1 if any of the passes modified the
function, false otherwise.
@see llvm::FunctionPassManager::run(Function&) */
//<editor-fold defaultstate="collapsed" desc="LLVMRunFunctionPassManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3243,
 FQN="LLVMRunFunctionPassManager", NM="_Z26LLVMRunFunctionPassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMRunFunctionPassManager")
//</editor-fold>
public static int LLVMRunFunctionPassManager( LLVMOpaquePassManager /*P*/ FPM,  LLVMOpaqueValue /*P*/ F) {
  return (IrLlvmGlobals.<FunctionPassManager>unwrap$T(FunctionPassManager.class, FPM).run($Deref(IrLlvmGlobals.<Function>unwrap_LLVMOpaqueValue$P(Function.class, F))) ? 1 : 0);
}


/** Finalizes all of the function passes scheduled in in the function pass
manager. Returns 1 if any of the passes modified the module, 0 otherwise.
@see llvm::FunctionPassManager::doFinalization */
//<editor-fold defaultstate="collapsed" desc="LLVMFinalizeFunctionPassManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3247,
 FQN="LLVMFinalizeFunctionPassManager", NM="_Z31LLVMFinalizeFunctionPassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z31LLVMFinalizeFunctionPassManager")
//</editor-fold>
public static int LLVMFinalizeFunctionPassManager( LLVMOpaquePassManager /*P*/ FPM) {
  return (IrLlvmGlobals.<FunctionPassManager>unwrap$T(FunctionPassManager.class, FPM).doFinalization() ? 1 : 0);
}


/** Frees the memory of a pass pipeline. For function pipelines, does not free
the module provider.
@see llvm::PassManagerBase::~PassManagerBase. */
//<editor-fold defaultstate="collapsed" desc="LLVMDisposePassManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3251,
 FQN="LLVMDisposePassManager", NM="_Z22LLVMDisposePassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMDisposePassManager")
//</editor-fold>
public static void LLVMDisposePassManager( LLVMOpaquePassManager /*P*/ PM) {
  /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)IrLlvmGlobals.unwrap(PM));
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreThreading Threading
*
* Handle the structures needed to make LLVM safe for multithreading.
*
* @{
*/

/** Deprecated: Multi-threading can only be enabled/disabled with the compile
time define LLVM_ENABLE_THREADS.  This function always returns
LLVMIsMultithreaded(). */

/*===-- Threading ------------------------------------------------------===*/
//<editor-fold defaultstate="collapsed" desc="LLVMStartMultithreaded">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3257,
 FQN="LLVMStartMultithreaded", NM="_Z22LLVMStartMultithreaded",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMStartMultithreaded")
//</editor-fold>
public static int LLVMStartMultithreaded() {
  return LLVMIsMultithreaded();
}


/** Deprecated: Multi-threading can only be enabled/disabled with the compile
time define LLVM_ENABLE_THREADS. */
//<editor-fold defaultstate="collapsed" desc="LLVMStopMultithreaded">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3261,
 FQN="LLVMStopMultithreaded", NM="_Z21LLVMStopMultithreaded",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMStopMultithreaded")
//</editor-fold>
public static void LLVMStopMultithreaded() {
}


/** Check whether LLVM is executing in thread-safe mode or not.
@see llvm::llvm_is_multithreaded */
//<editor-fold defaultstate="collapsed" desc="LLVMIsMultithreaded">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3264,
 FQN="LLVMIsMultithreaded", NM="_Z19LLVMIsMultithreaded",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMIsMultithreaded")
//</editor-fold>
public static int LLVMIsMultithreaded() {
  return (llvm_is_multithreaded() ? 1 : 0);
}


/*===-- Operations on contexts --------------------------------------------===*/
//<editor-fold defaultstate="collapsed" desc="GlobalContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 78,
 FQN="GlobalContext", NM="_ZL13GlobalContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_ZL13GlobalContext")
//</editor-fold>
public static ManagedStatic<LLVMContext> GlobalContext/*J*/= new ManagedStatic<LLVMContext>(new LLVMContextInfo());
//<editor-fold defaultstate="collapsed" desc="LLVMTokenTypeInContext">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 452,
 FQN="LLVMTokenTypeInContext", NM="_Z22LLVMTokenTypeInContextP17LLVMOpaqueContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMTokenTypeInContextP17LLVMOpaqueContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMTokenTypeInContext( LLVMOpaqueContext /*P*/ C) {
  return ( LLVMOpaqueType /*P*/ )(Object)Type.getTokenTy($Deref(IrLlvmGlobals.unwrap_LLVMOpaqueContext$P(C)));
}


// MetadataAsValue uses a canonical format which strips the actual MDNode for
// MDNode with just a single constant value, storing just a ConstantAsMetadata
// This undoes this canonicalization, reconstructing the MDNode.
//<editor-fold defaultstate="collapsed" desc="extractMDNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 677,
 FQN="extractMDNode", NM="_ZL13extractMDNodePN4llvm15MetadataAsValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_ZL13extractMDNodePN4llvm15MetadataAsValueE")
//</editor-fold>
public static MDNode /*P*/ extractMDNode(MetadataAsValue /*P*/ MAV) {
  Metadata /*P*/ MD = MAV.getMetadata();
  assert ((isa_MDNode(MD) || isa_ConstantAsMetadata(MD))) : "Expected a metadata node or a canonicalized constant";
  {
    
    MDNode /*P*/ N = dyn_cast_MDNode(MD);
    if ((N != null)) {
      return N;
    }
  }
  
  return MDNode.get(MAV.getContext(), new ArrayRef<Metadata /*P*/ >(MD, true));
}


/*--.. Operations on Users .................................................--*/
//<editor-fold defaultstate="collapsed" desc="getMDNodeOperandImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 744,
 FQN="getMDNodeOperandImpl", NM="_ZL20getMDNodeOperandImplRN4llvm11LLVMContextEPKNS_6MDNodeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_ZL20getMDNodeOperandImplRN4llvm11LLVMContextEPKNS_6MDNodeEj")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ getMDNodeOperandImpl(final LLVMContext /*&*/ Context, /*const*/ MDNode /*P*/ N, 
                    /*uint*/int Index) {
  Metadata /*P*/ Op = N.getOperand(Index).$Metadata$P();
  if (!(Op != null)) {
    return null;
  }
  {
    ConstantAsMetadata /*P*/ C = dyn_cast_ConstantAsMetadata(Op);
    if ((C != null)) {
      return IrLlvmGlobals.wrap_Value$C$P(C.getValue());
    }
  }
  return IrLlvmGlobals.wrap_Value$C$P(MetadataAsValue.get(Context, Op));
}


/*-- Opcode mapping */
//<editor-fold defaultstate="collapsed" desc="map_to_llvmopcode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1055,
 FQN="map_to_llvmopcode", NM="_ZL17map_to_llvmopcodei",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_ZL17map_to_llvmopcodei")
//</editor-fold>
public static LLVMOpcode map_to_llvmopcode(int opcode) {
  switch (opcode) {
   default:
    throw new llvm_unreachable("Unhandled Opcode.");
   case 1:
    return LLVMOpcode.LLVMRet;
   case 2:
    return LLVMOpcode.LLVMBr;
   case 3:
    return LLVMOpcode.LLVMSwitch;
   case 4:
    return LLVMOpcode.LLVMIndirectBr;
   case 5:
    return LLVMOpcode.LLVMInvoke;
   case 6:
    return LLVMOpcode.LLVMResume;
   case 7:
    return LLVMOpcode.LLVMUnreachable;
   case 8:
    return LLVMOpcode.LLVMCleanupRet;
   case 9:
    return LLVMOpcode.LLVMCatchRet;
   case 10:
    return LLVMOpcode.LLVMCatchSwitch;
   case 11:
    return LLVMOpcode.LLVMAdd;
   case 12:
    return LLVMOpcode.LLVMFAdd;
   case 13:
    return LLVMOpcode.LLVMSub;
   case 14:
    return LLVMOpcode.LLVMFSub;
   case 15:
    return LLVMOpcode.LLVMMul;
   case 16:
    return LLVMOpcode.LLVMFMul;
   case 17:
    return LLVMOpcode.LLVMUDiv;
   case 18:
    return LLVMOpcode.LLVMSDiv;
   case 19:
    return LLVMOpcode.LLVMFDiv;
   case 20:
    return LLVMOpcode.LLVMURem;
   case 21:
    return LLVMOpcode.LLVMSRem;
   case 22:
    return LLVMOpcode.LLVMFRem;
   case 23: // Shift left  (logical)
    
    // Logical operators (integer operands)
    return LLVMOpcode.LLVMShl;
   case 24: // Shift right (logical)
    return LLVMOpcode.LLVMLShr;
   case 25: // Shift right (arithmetic)
    return LLVMOpcode.LLVMAShr;
   case 26:
    return LLVMOpcode.LLVMAnd;
   case 27:
    return LLVMOpcode.LLVMOr;
   case 28:
    return LLVMOpcode.LLVMXor;
   case 29: // Stack management
    return LLVMOpcode.LLVMAlloca;
   case 30: // Memory manipulation instrs
    return LLVMOpcode.LLVMLoad;
   case 31:
    return LLVMOpcode.LLVMStore;
   case 32:
    return LLVMOpcode.LLVMGetElementPtr;
   case 33:
    return LLVMOpcode.LLVMFence;
   case 34:
    return LLVMOpcode.LLVMAtomicCmpXchg;
   case 35:
    return LLVMOpcode.LLVMAtomicRMW;
   case 36: // Truncate integers
    return LLVMOpcode.LLVMTrunc;
   case 37: // Zero extend integers
    return LLVMOpcode.LLVMZExt;
   case 38: // Sign extend integers
    return LLVMOpcode.LLVMSExt;
   case 39: // floating point -> UInt
    return LLVMOpcode.LLVMFPToUI;
   case 40: // floating point -> SInt
    return LLVMOpcode.LLVMFPToSI;
   case 41: // UInt -> floating point
    return LLVMOpcode.LLVMUIToFP;
   case 42: // SInt -> floating point
    return LLVMOpcode.LLVMSIToFP;
   case 43: // Truncate floating point
    return LLVMOpcode.LLVMFPTrunc;
   case 44: // Extend floating point
    return LLVMOpcode.LLVMFPExt;
   case 45: // Pointer -> Integer
    return LLVMOpcode.LLVMPtrToInt;
   case 46: // Integer -> Pointer
    return LLVMOpcode.LLVMIntToPtr;
   case 47: // Type cast
    return LLVMOpcode.LLVMBitCast;
   case 48: // addrspace cast
    return LLVMOpcode.LLVMAddrSpaceCast;
   case 49:
    return LLVMOpcode.LLVMCleanupPad;
   case 50:
    return LLVMOpcode.LLVMCatchPad;
   case 51: // Integer comparison instruction
    return LLVMOpcode.LLVMICmp;
   case 52: // Floating point comparison instr.
    return LLVMOpcode.LLVMFCmp;
   case 53: // PHI node instruction
    return LLVMOpcode.LLVMPHI;
   case 54: // Call a function
    return LLVMOpcode.LLVMCall;
   case 55: // select instruction
    return LLVMOpcode.LLVMSelect;
   case 56: // May be used internally in a pass
    return LLVMOpcode.LLVMUserOp1;
   case 57: // Internal to passes only
    return LLVMOpcode.LLVMUserOp2;
   case 58: // vaarg instruction
    return LLVMOpcode.LLVMVAArg;
   case 59: // extract from vector
    return LLVMOpcode.LLVMExtractElement;
   case 60: // insert into vector
    return LLVMOpcode.LLVMInsertElement;
   case 61: // shuffle two vectors.
    return LLVMOpcode.LLVMShuffleVector;
   case 62: // extract from aggregate
    return LLVMOpcode.LLVMExtractValue;
   case 63: // insert into aggregate
    return LLVMOpcode.LLVMInsertValue;
   case 64: // Landing pad instruction.
    return LLVMOpcode.LLVMLandingPad;
  }
}

//<editor-fold defaultstate="collapsed" desc="map_from_llvmopcode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1065,
 FQN="map_from_llvmopcode", NM="_ZL19map_from_llvmopcode10LLVMOpcode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_ZL19map_from_llvmopcode10LLVMOpcode")
//</editor-fold>
public static int map_from_llvmopcode(LLVMOpcode code) {
  switch (code) {
   case LLVMRet:
    return 1;
   case LLVMBr:
    return 2;
   case LLVMSwitch:
    return 3;
   case LLVMIndirectBr:
    return 4;
   case LLVMInvoke:
    return 5;
   case LLVMResume:
    return 6;
   case LLVMUnreachable:
    return 7;
   case LLVMCleanupRet:
    return 8;
   case LLVMCatchRet:
    return 9;
   case LLVMCatchSwitch:
    return 10;
   case LLVMAdd:
    return 11;
   case LLVMFAdd:
    return 12;
   case LLVMSub:
    return 13;
   case LLVMFSub:
    return 14;
   case LLVMMul:
    return 15;
   case LLVMFMul:
    return 16;
   case LLVMUDiv:
    return 17;
   case LLVMSDiv:
    return 18;
   case LLVMFDiv:
    return 19;
   case LLVMURem:
    return 20;
   case LLVMSRem:
    return 21;
   case LLVMFRem:
    return 22;
   case LLVMShl: // Shift left  (logical)
    
    // Logical operators (integer operands)
    return 23;
   case LLVMLShr: // Shift right (logical)
    return 24;
   case LLVMAShr: // Shift right (arithmetic)
    return 25;
   case LLVMAnd:
    return 26;
   case LLVMOr:
    return 27;
   case LLVMXor:
    return 28;
   case LLVMAlloca: // Stack management
    return 29;
   case LLVMLoad: // Memory manipulation instrs
    return 30;
   case LLVMStore:
    return 31;
   case LLVMGetElementPtr:
    return 32;
   case LLVMFence:
    return 33;
   case LLVMAtomicCmpXchg:
    return 34;
   case LLVMAtomicRMW:
    return 35;
   case LLVMTrunc: // Truncate integers
    return 36;
   case LLVMZExt: // Zero extend integers
    return 37;
   case LLVMSExt: // Sign extend integers
    return 38;
   case LLVMFPToUI: // floating point -> UInt
    return 39;
   case LLVMFPToSI: // floating point -> SInt
    return 40;
   case LLVMUIToFP: // UInt -> floating point
    return 41;
   case LLVMSIToFP: // SInt -> floating point
    return 42;
   case LLVMFPTrunc: // Truncate floating point
    return 43;
   case LLVMFPExt: // Extend floating point
    return 44;
   case LLVMPtrToInt: // Pointer -> Integer
    return 45;
   case LLVMIntToPtr: // Integer -> Pointer
    return 46;
   case LLVMBitCast: // Type cast
    return 47;
   case LLVMAddrSpaceCast: // addrspace cast
    return 48;
   case LLVMCleanupPad:
    return 49;
   case LLVMCatchPad:
    return 50;
   case LLVMICmp: // Integer comparison instruction
    return 51;
   case LLVMFCmp: // Floating point comparison instr.
    return 52;
   case LLVMPHI: // PHI node instruction
    return 53;
   case LLVMCall: // Call a function
    return 54;
   case LLVMSelect: // select instruction
    return 55;
   case LLVMUserOp1: // May be used internally in a pass
    return 56;
   case LLVMUserOp2: // Internal to passes only
    return 57;
   case LLVMVAArg: // vaarg instruction
    return 58;
   case LLVMExtractElement: // extract from vector
    return 59;
   case LLVMInsertElement: // insert into vector
    return 60;
   case LLVMShuffleVector: // shuffle two vectors.
    return 61;
   case LLVMExtractValue: // extract from aggregate
    return 62;
   case LLVMInsertValue: // insert into aggregate
    return 63;
   case LLVMLandingPad: // Landing pad instruction.
    return 64;
  }
  throw new llvm_unreachable("Unhandled Opcode.");
}

//<editor-fold defaultstate="collapsed" desc="mapFromLLVMOrdering">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2765,
 FQN="mapFromLLVMOrdering", NM="_ZL19mapFromLLVMOrdering18LLVMAtomicOrdering",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_ZL19mapFromLLVMOrdering18LLVMAtomicOrdering")
//</editor-fold>
public static AtomicOrdering mapFromLLVMOrdering(LLVMAtomicOrdering Ordering) {
  switch (Ordering) {
   case LLVMAtomicOrderingNotAtomic:
    return AtomicOrdering.NotAtomic;
   case LLVMAtomicOrderingUnordered:
    return AtomicOrdering.Unordered;
   case LLVMAtomicOrderingMonotonic:
    return AtomicOrdering.Monotonic;
   case LLVMAtomicOrderingAcquire:
    return AtomicOrdering.Acquire;
   case LLVMAtomicOrderingRelease:
    return AtomicOrdering.Release;
   case LLVMAtomicOrderingAcquireRelease:
    return AtomicOrdering.AcquireRelease;
   case LLVMAtomicOrderingSequentiallyConsistent:
    return AtomicOrdering.SequentiallyConsistent;
  }
  throw new llvm_unreachable("Invalid LLVMAtomicOrdering value!");
}

//<editor-fold defaultstate="collapsed" desc="mapToLLVMOrdering">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2781,
 FQN="mapToLLVMOrdering", NM="_ZL17mapToLLVMOrderingN4llvm14AtomicOrderingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_ZL17mapToLLVMOrderingN4llvm14AtomicOrderingE")
//</editor-fold>
public static LLVMAtomicOrdering mapToLLVMOrdering(AtomicOrdering Ordering) {
  switch (Ordering) {
   case NotAtomic:
    return LLVMAtomicOrdering.LLVMAtomicOrderingNotAtomic;
   case Unordered:
    return LLVMAtomicOrdering.LLVMAtomicOrderingUnordered;
   case Monotonic:
    return LLVMAtomicOrdering.LLVMAtomicOrderingMonotonic;
   case Acquire:
    return LLVMAtomicOrdering.LLVMAtomicOrderingAcquire;
   case Release:
    return LLVMAtomicOrdering.LLVMAtomicOrderingRelease;
   case AcquireRelease:
    return LLVMAtomicOrdering.LLVMAtomicOrderingAcquireRelease;
   case SequentiallyConsistent:
    return LLVMAtomicOrdering.LLVMAtomicOrderingSequentiallyConsistent;
  }
  throw new llvm_unreachable("Invalid AtomicOrdering value!");
}

} // END OF class CoreStatics
