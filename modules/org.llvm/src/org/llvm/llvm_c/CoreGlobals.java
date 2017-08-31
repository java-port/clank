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
package org.llvm.llvm_c;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.Error;
import org.llvm.object.*;
import org.llvm.llvmc.*;
import org.llvm.java.LlvmFunctionPointers.*;
import org.llvm.debuginfo.*;
import org.llvm.llvmc.java.LlvmCFunctionPointers.*;


//<editor-fold defaultstate="collapsed" desc="static type CoreGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.llvm_c.CoreGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp ${LLVM_SRC}/llvm/lib/IR/Core.cpp ${LLVM_SRC}/llvm/tools/llvm-c-test/include-all.c -nm=_Core_h_Unnamed_enum15;_LLVMAtomicOrdering;_LLVMAtomicRMWBinOp;_LLVMAttribute;_LLVMCallConv;_LLVMDLLStorageClass;_LLVMDiagnosticSeverity;_LLVMIntPredicate;_LLVMLandingPadClauseTy;_LLVMLinkage;_LLVMOpcode;_LLVMRealPredicate;_LLVMThreadLocalMode;_LLVMTypeKind;_LLVMValueKind;_LLVMVisibility;_Unnamed_enum15;_Z10LLVMIsNull;_Z10LLVMMDNode;_Z10LLVMSizeOf;_Z10LLVMTypeOf;_Z11LLVMAddCase;_Z11LLVMAlignOf;_Z11LLVMBuildBr;_Z11LLVMBuildOr;_Z11LLVMConstOr;_Z11LLVMGetUser;_Z11LLVMIntType;_Z11LLVMIsAUser;_Z11LLVMIsUndef;_Z12LLVMAddAlias;_Z12LLVMBuildAdd;_Z12LLVMBuildAnd;_Z12LLVMBuildGEP;_Z12LLVMBuildMul;_Z12LLVMBuildNeg;_Z12LLVMBuildNot;_Z12LLVMBuildPhi;_Z12LLVMBuildRet;_Z12LLVMBuildShl;_Z12LLVMBuildSub;_Z12LLVMBuildXor;_Z12LLVMConstAdd;_Z12LLVMConstAnd;_Z12LLVMConstGEP;_Z12LLVMConstInt;_Z12LLVMConstMul;_Z12LLVMConstNeg;_Z12LLVMConstNot;_Z12LLVMConstShl;_Z12LLVMConstSub;_Z12LLVMConstXor;_Z12LLVMDumpType;_Z12LLVMGetParam;_Z12LLVMGetUndef;_Z12LLVMHalfType;_Z12LLVMInt1Type;_Z12LLVMInt8Type;_Z12LLVMMDString;_Z12LLVMShutdown;_Z12LLVMVoidType;_Z13LLVMAddClause;_Z13LLVMAddGlobal;_Z13LLVMArrayType;_Z13LLVMBuildAShr;_Z13LLVMBuildCall;_Z13LLVMBuildCast;_Z13LLVMBuildFAdd;_Z13LLVMBuildFCmp;_Z13LLVMBuildFDiv;_Z13LLVMBuildFMul;_Z13LLVMBuildFNeg;_Z13LLVMBuildFRem;_Z13LLVMBuildFSub;_Z13LLVMBuildFree;_Z13LLVMBuildICmp;_Z13LLVMBuildLShr;_Z13LLVMBuildLoad;_Z13LLVMBuildSDiv;_Z13LLVMBuildSExt;_Z13LLVMBuildSRem;_Z13LLVMBuildUDiv;_Z13LLVMBuildURem;_Z13LLVMBuildZExt;_Z13LLVMConstAShr;_Z13LLVMConstFAdd;_Z13LLVMConstFCmp;_Z13LLVMConstFDiv;_Z13LLVMConstFMul;_Z13LLVMConstFNeg;_Z13LLVMConstFRem;_Z13LLVMConstFSub;_Z13LLVMConstICmp;_Z13LLVMConstLShr;_Z13LLVMConstNull;_Z13LLVMConstReal;_Z13LLVMConstSDiv;_Z13LLVMConstSExt;_Z13LLVMConstSRem;_Z13LLVMConstUDiv;_Z13LLVMConstURem;_Z13LLVMConstZExt;_Z13LLVMDumpValue;_Z13LLVMFP128Type;_Z13LLVMFloatType;_Z13LLVMGetClause;_Z13LLVMGetParams;_Z13LLVMGetTarget;_Z13LLVMInt16Type;_Z13LLVMInt32Type;_Z13LLVMInt64Type;_Z13LLVMIsAMDNode;_Z13LLVMIsCleanup;_Z13LLVMLabelType;_Z13LLVMSetTarget;_Z14LLVMBuildBinOp;_Z14LLVMBuildFPExt;_Z14LLVMBuildFence;_Z14LLVMBuildStore;_Z14LLVMBuildTrunc;_Z14LLVMBuildVAArg;_Z14LLVMConstArray;_Z14LLVMConstFPExt;_Z14LLVMConstTrunc;_Z14LLVMDoubleType;_Z14LLVMDumpModule;_Z14LLVMGetIndices;_Z14LLVMGetLinkage;_Z14LLVMGetNextUse;_Z14LLVMGetOperand;_Z14LLVMGetSection;_Z14LLVMInt128Type;_Z14LLVMIsACmpInst;_Z14LLVMIsAPHINode;_Z14LLVMIsConstant;_Z14LLVMIsInBounds;_Z14LLVMIsTailCall;_Z14LLVMSetCleanup;_Z14LLVMSetLinkage;_Z14LLVMSetOperand;_Z14LLVMSetSection;_Z14LLVMStructType;_Z14LLVMVectorType;_Z14LLVMX86MMXType;_Z15LLVMAddFunction;_Z15LLVMAddIncoming;_Z15LLVMBuildAlloca;_Z15LLVMBuildCondBr;_Z15LLVMBuildFPCast;_Z15LLVMBuildFPToSI;_Z15LLVMBuildFPToUI;_Z15LLVMBuildInvoke;_Z15LLVMBuildIsNull;_Z15LLVMBuildMalloc;_Z15LLVMBuildNSWAdd;_Z15LLVMBuildNSWMul;_Z15LLVMBuildNSWNeg;_Z15LLVMBuildNSWSub;_Z15LLVMBuildNUWAdd;_Z15LLVMBuildNUWMul;_Z15LLVMBuildNUWNeg;_Z15LLVMBuildNUWSub;_Z15LLVMBuildResume;_Z15LLVMBuildSIToFP;_Z15LLVMBuildSelect;_Z15LLVMBuildSwitch;_Z15LLVMBuildUIToFP;_Z15LLVMCloneModule;_Z15LLVMConstFPCast;_Z15LLVMConstFPToSI;_Z15LLVMConstFPToUI;_Z15LLVMConstNSWAdd;_Z15LLVMConstNSWMul;_Z15LLVMConstNSWNeg;_Z15LLVMConstNSWSub;_Z15LLVMConstNUWAdd;_Z15LLVMConstNUWMul;_Z15LLVMConstNUWNeg;_Z15LLVMConstNUWSub;_Z15LLVMConstSIToFP;_Z15LLVMConstSelect;_Z15LLVMConstString;_Z15LLVMConstStruct;_Z15LLVMConstUIToFP;_Z15LLVMConstVector;_Z15LLVMCountParams;_Z15LLVMGetAsString;_Z15LLVMGetFirstUse;_Z15LLVMGetMDKindID;_Z15LLVMGetMDString;_Z15LLVMGetMetadata;_Z15LLVMGetOrdering;_Z15LLVMGetTypeKind;_Z15LLVMGetVolatile;_Z15LLVMHasMetadata;_Z15LLVMIsAArgument;_Z15LLVMIsACallInst;_Z15LLVMIsACastInst;_Z15LLVMIsAConstant;_Z15LLVMIsAFCmpInst;_Z15LLVMIsAFunction;_Z15LLVMIsAICmpInst;_Z15LLVMIsALoadInst;_Z15LLVMIsAMDString;_Z15LLVMIsASExtInst;_Z15LLVMIsAZExtInst;_Z15LLVMPointerType;_Z15LLVMSetMetadata;_Z15LLVMSetOrdering;_Z15LLVMSetTailCall;_Z15LLVMSetVolatile;_Z15LLVMTypeIsSized;_Z15LLVMX86FP80Type;_Z16LLVMAddAttribute;_Z16LLVMBlockAddress;_Z16LLVMBuildBitCast;_Z16LLVMBuildFPTrunc;_Z16LLVMBuildIntCast;_Z16LLVMBuildPtrDiff;_Z16LLVMBuildRetVoid;_Z16LLVMConstAllOnes;_Z16LLVMConstBitCast;_Z16LLVMConstFPTrunc;_Z16LLVMConstIntCast;_Z16LLVMDeleteGlobal;_Z16LLVMFunctionType;_Z16LLVMGetAlignment;_Z16LLVMGetAttribute;_Z16LLVMGetCondition;_Z16LLVMGetLastParam;_Z16LLVMGetNextParam;_Z16LLVMGetSuccessor;_Z16LLVMGetUsedValue;_Z16LLVMGetValueKind;_Z16LLVMGetValueName;_Z16LLVMIsAFPExtInst;_Z16LLVMIsAInlineAsm;_Z16LLVMIsAStoreInst;_Z16LLVMIsATruncInst;_Z16LLVMIsAVAArgInst;_Z16LLVMPPCFP128Type;_Z16LLVMSetAlignment;_Z16LLVMSetCondition;_Z16LLVMSetSuccessor;_Z16LLVMSetValueName;_Z17LLVMBuildIntToPtr;_Z17LLVMBuildPtrToInt;_Z17LLVMConstIntToPtr;_Z17LLVMConstPtrToInt;_Z17LLVMContextCreate;_Z17LLVMCountIncoming;_Z17LLVMCreateBuilder;_Z17LLVMCreateMessage;_Z17LLVMDisposeModule;_Z17LLVMGetBufferSize;_Z17LLVMGetDataLayout;_Z17LLVMGetFirstParam;_Z17LLVMGetLastGlobal;_Z17LLVMGetNextGlobal;_Z17LLVMGetNormalDest;_Z17LLVMGetNumClauses;_Z17LLVMGetNumIndices;_Z17LLVMGetOperandUse;_Z17LLVMGetParamTypes;_Z17LLVMGetReturnType;_Z17LLVMGetStructName;_Z17LLVMGetTypeByName;_Z17LLVMGetUnwindDest;_Z17LLVMGetVectorSize;_Z17LLVMGetVisibility;_Z17LLVMIsAAllocaInst;_Z17LLVMIsABasicBlock;_Z17LLVMIsABranchInst;_Z17LLVMIsAConstantFP;_Z17LLVMIsAFPToSIInst;_Z17LLVMIsAFPToUIInst;_Z17LLVMIsAInvokeInst;_Z17LLVMIsAMemCpyInst;_Z17LLVMIsAMemSetInst;_Z17LLVMIsAResumeInst;_Z17LLVMIsAReturnInst;_Z17LLVMIsASIToFPInst;_Z17LLVMIsASelectInst;_Z17LLVMIsASwitchInst;_Z17LLVMIsAUIToFPInst;_Z17LLVMIsAUndefValue;_Z17LLVMIsConditional;_Z17LLVMIsDeclaration;_Z17LLVMIsThreadLocal;_Z17LLVMSetDataLayout;_Z17LLVMSetIsInBounds;_Z17LLVMSetNormalDest;_Z17LLVMSetUnwindDest;_Z17LLVMSetVisibility;_Z17LLVMStructSetBody;_Z18LLVMAddDestination;_Z18LLVMBuildAtomicRMW;_Z18LLVMBuildExactSDiv;_Z18LLVMBuildIsNotNull;_Z18LLVMBuildStructGEP;_Z18LLVMConstExactSDiv;_Z18LLVMConstInlineAsm;_Z18LLVMContextDispose;_Z18LLVMDeleteFunction;_Z18LLVMDisposeBuilder;_Z18LLVMDisposeMessage;_Z18LLVMGetArrayLength;_Z18LLVMGetBasicBlocks;_Z18LLVMGetBufferStart;_Z18LLVMGetCalledValue;_Z18LLVMGetConstOpcode;_Z18LLVMGetElementType;_Z18LLVMGetFirstGlobal;_Z18LLVMGetInitializer;_Z18LLVMGetInsertBlock;_Z18LLVMGetIntrinsicID;_Z18LLVMGetNamedGlobal;_Z18LLVMGetNumOperands;_Z18LLVMGetParamParent;_Z18LLVMGetTypeContext;_Z18LLVMHasUnnamedAddr;_Z18LLVMInitializeCore;_Z18LLVMIsABitCastInst;_Z18LLVMIsAConstantInt;_Z18LLVMIsAFPTruncInst;_Z18LLVMIsAGlobalAlias;_Z18LLVMIsAGlobalValue;_Z18LLVMIsAInstruction;_Z18LLVMIsAMemMoveInst;_Z18LLVMIsOpaqueStruct;_Z18LLVMIsPackedStruct;_Z18LLVMRunPassManager;_Z18LLVMSetInitializer;_Z18LLVMSetThreadLocal;_Z18LLVMSetUnnamedAddr;_Z19LLVMAddFunctionAttr;_Z19LLVMBuildIndirectBr;_Z19LLVMBuildLandingPad;_Z19LLVMCountParamTypes;_Z19LLVMGetFunctionAttr;_Z19LLVMGetGlobalParent;_Z19LLVMGetIntTypeWidth;_Z19LLVMGetLastFunction;_Z19LLVMGetNextFunction;_Z19LLVMIsABlockAddress;_Z19LLVMIsACatchPadInst;_Z19LLVMIsAConstantExpr;_Z19LLVMIsAGlobalObject;_Z19LLVMIsAIntToPtrInst;_Z19LLVMIsAMemIntrinsic;_Z19LLVMIsAPtrToIntInst;_Z19LLVMIsEnumAttribute;_Z19LLVMIsMultithreaded;_Z19LLVMMDNodeInContext;_Z19LLVMPositionBuilder;_Z19LLVMRemoveAttribute;_Z20LLVMAppendBasicBlock;_Z20LLVMBuildArrayAlloca;_Z20LLVMBuildArrayMalloc;_Z20LLVMBuildInBoundsGEP;_Z20LLVMBuildInsertValue;_Z20LLVMBuildPointerCast;_Z20LLVMBuildUnreachable;_Z20LLVMConstInBoundsGEP;_Z20LLVMConstInsertValue;_Z20LLVMConstIntOfString;_Z20LLVMConstNamedStruct;_Z20LLVMConstPointerCast;_Z20LLVMConstPointerNull;_Z20LLVMCountBasicBlocks;_Z20LLVMDeleteBasicBlock;_Z20LLVMGetAllocatedType;_Z20LLVMGetDataLayoutStr;_Z20LLVMGetFCmpPredicate;_Z20LLVMGetFirstFunction;_Z20LLVMGetGlobalContext;_Z20LLVMGetICmpPredicate;_Z20LLVMGetIncomingBlock;_Z20LLVMGetIncomingValue;_Z20LLVMGetModuleContext;_Z20LLVMGetNamedFunction;_Z20LLVMGetNumSuccessors;_Z20LLVMGetPersonalityFn;_Z20LLVMGetPreviousParam;_Z20LLVMHasPersonalityFn;_Z20LLVMInsertBasicBlock;_Z20LLVMInstructionClone;_Z20LLVMIntTypeInContext;_Z20LLVMIsAConstantArray;_Z20LLVMIsAIntrinsicInst;_Z20LLVMIsConstantString;_Z20LLVMIsFunctionVarArg;_Z20LLVMIsGlobalConstant;_Z20LLVMSetPersonalityFn;_Z21LLVMAddInstrAttribute;_Z21LLVMBasicBlockAsValue;_Z21LLVMBuildAggregateRet;_Z21LLVMBuildExtractValue;_Z21LLVMBuildGlobalString;_Z21LLVMConstExtractValue;_Z21LLVMConstRealOfString;_Z21LLVMCreatePassManager;_Z21LLVMGetBasicBlockName;_Z21LLVMGetLastBasicBlock;_Z21LLVMGetMDNodeOperands;_Z21LLVMGetNextBasicBlock;_Z21LLVMGetNumArgOperands;_Z21LLVMGetPreviousGlobal;_Z21LLVMHalfTypeInContext;_Z21LLVMInsertIntoBuilder;_Z21LLVMInt1TypeInContext;_Z21LLVMInt8TypeInContext;_Z21LLVMIsABinaryOperator;_Z21LLVMIsACleanupPadInst;_Z21LLVMIsAConstantStruct;_Z21LLVMIsAConstantVector;_Z21LLVMIsADbgDeclareInst;_Z21LLVMIsAFuncletPadInst;_Z21LLVMIsAGlobalVariable;_Z21LLVMIsAIndirectBrInst;_Z21LLVMIsALandingPadInst;_Z21LLVMIsATerminatorInst;_Z21LLVMIsStringAttribute;_Z21LLVMMDStringInContext;_Z21LLVMPrintModuleToFile;_Z21LLVMPrintTypeToString;_Z21LLVMSetGlobalConstant;_Z21LLVMSetParamAlignment;_Z21LLVMStopMultithreaded;_Z21LLVMStructCreateNamed;_Z21LLVMValueAsBasicBlock;_Z21LLVMValueIsBasicBlock;_Z21LLVMVoidTypeInContext;_Z22LLVMBuildAddrSpaceCast;_Z22LLVMBuildAtomicCmpXchg;_Z22LLVMBuildInsertElement;_Z22LLVMBuildSExtOrBitCast;_Z22LLVMBuildShuffleVector;_Z22LLVMBuildZExtOrBitCast;_Z22LLVMConstAddrSpaceCast;_Z22LLVMConstInsertElement;_Z22LLVMConstRealGetDouble;_Z22LLVMConstSExtOrBitCast;_Z22LLVMConstShuffleVector;_Z22LLVMConstZExtOrBitCast;_Z22LLVMDisposePassManager;_Z22LLVMFP128TypeInContext;_Z22LLVMFloatTypeInContext;_Z22LLVMGetDLLStorageClass;_Z22LLVMGetEntryBasicBlock;_Z22LLVMGetFirstBasicBlock;_Z22LLVMGetLastInstruction;_Z22LLVMGetNextInstruction;_Z22LLVMGetThreadLocalMode;_Z22LLVMInt16TypeInContext;_Z22LLVMInt32TypeInContext;_Z22LLVMInt64TypeInContext;_Z22LLVMIsACatchReturnInst;_Z22LLVMIsAInsertValueInst;_Z22LLVMIsAUnreachableInst;_Z22LLVMLabelTypeInContext;_Z22LLVMPrintValueToString;_Z22LLVMRemoveFunctionAttr;_Z22LLVMReplaceAllUsesWith;_Z22LLVMSetDLLStorageClass;_Z22LLVMSetModuleInlineAsm;_Z22LLVMSetThreadLocalMode;_Z22LLVMStartMultithreaded;_Z23LLVMAddAttributeAtIndex;_Z23LLVMBuildExtractElement;_Z23LLVMBuildTruncOrBitCast;_Z23LLVMConstExtractElement;_Z23LLVMConstTruncOrBitCast;_Z23LLVMCreateEnumAttribute;_Z23LLVMDisposeMemoryBuffer;_Z23LLVMDoubleTypeInContext;_Z23LLVMGetBasicBlockParent;_Z23LLVMGetDiagInfoSeverity;_Z23LLVMGetFirstInstruction;_Z23LLVMGetFunctionCallConv;_Z23LLVMGetModuleIdentifier;_Z23LLVMGetPreviousFunction;_Z23LLVMInt128TypeInContext;_Z23LLVMIsADbgInfoIntrinsic;_Z23LLVMIsAExtractValueInst;_Z23LLVMIsAUnaryInstruction;_Z23LLVMMoveBasicBlockAfter;_Z23LLVMPrintModuleToString;_Z23LLVMSetFunctionCallConv;_Z23LLVMSetModuleIdentifier;_Z23LLVMStructTypeInContext;_Z23LLVMX86MMXTypeInContext;_Z24LLVMAddCallSiteAttribute;_Z24LLVMBuildGlobalStringPtr;_Z24LLVMConstIntGetSExtValue;_Z24LLVMConstIntGetZExtValue;_Z24LLVMConstStringInContext;_Z24LLVMConstStructInContext;_Z24LLVMGetAttributesAtIndex;_Z24LLVMGetElementAsConstant;_Z24LLVMGetEnumAttributeKind;_Z24LLVMGetInstructionOpcode;_Z24LLVMGetInstructionParent;_Z24LLVMGetMDKindIDInContext;_Z24LLVMGetMDNodeNumOperands;_Z24LLVMGetSwitchDefaultDest;_Z24LLVMIsAAddrSpaceCastInst;_Z24LLVMIsACleanupReturnInst;_Z24LLVMIsAConstantDataArray;_Z24LLVMIsAConstantTokenNone;_Z24LLVMIsAGetElementPtrInst;_Z24LLVMIsAInsertElementInst;_Z24LLVMIsAShuffleVectorInst;_Z24LLVMIsAtomicSingleThread;_Z24LLVMModuleCreateWithName;_Z24LLVMMoveBasicBlockBefore;_Z24LLVMPositionBuilderAtEnd;_Z24LLVMRemoveInstrAttribute;_Z24LLVMSetInstDebugLocation;_Z24LLVMStructGetTypeAtIndex;_Z24LLVMX86FP80TypeInContext;_Z25LLVMCreateStringAttribute;_Z25LLVMDisposeModuleProvider;_Z25LLVMGetCallSiteAttributes;_Z25LLVMGetEnumAttributeValue;_Z25LLVMGetGlobalPassRegistry;_Z25LLVMGetPreviousBasicBlock;_Z25LLVMGetStructElementTypes;_Z25LLVMIsAConstantDataVector;_Z25LLVMIsAExtractElementInst;_Z25LLVMPPCFP128TypeInContext;_Z25LLVMPositionBuilderBefore;_Z25LLVMSetAtomicSingleThread;_Z26LLVMClearInsertionPosition;_Z26LLVMCreateBuilderInContext;_Z26LLVMGetDiagInfoDescription;_Z26LLVMGetInstructionCallConv;_Z26LLVMGetPointerAddressSpace;_Z26LLVMGetPreviousInstruction;_Z26LLVMGetStringAttributeKind;_Z26LLVMIsAConstantPointerNull;_Z26LLVMRunFunctionPassManager;_Z26LLVMSetInstrParamAlignment;_Z26LLVMSetInstructionCallConv;_Z27LLVMAddGlobalInAddressSpace;_Z27LLVMAddNamedMetadataOperand;_Z27LLVMConstIntOfStringAndSize;_Z27LLVMContextSetYieldCallback;_Z27LLVMCountStructElementTypes;_Z27LLVMGetBasicBlockTerminator;_Z27LLVMGetCurrentDebugLocation;_Z27LLVMGetEnumAttributeAtIndex;_Z27LLVMGetStringAttributeValue;_Z27LLVMIsExternallyInitialized;_Z27LLVMSetCurrentDebugLocation;_Z28LLVMConstRealOfStringAndSize;_Z28LLVMGetAttributeCountAtIndex;_Z28LLVMGetCallSiteEnumAttribute;_Z28LLVMGetLastEnumAttributeKind;_Z28LLVMGetNamedMetadataOperands;_Z28LLVMIsAConstantAggregateZero;_Z28LLVMSetExternallyInitialized;_Z29LLVMAppendBasicBlockInContext;_Z29LLVMCreateFunctionPassManager;_Z29LLVMGetCallSiteAttributeCount;_Z29LLVMGetCmpXchgFailureOrdering;_Z29LLVMGetCmpXchgSuccessOrdering;_Z29LLVMGetStringAttributeAtIndex;_Z29LLVMInsertBasicBlockInContext;_Z29LLVMInsertIntoBuilderWithName;_Z29LLVMIsAConstantDataSequential;_Z29LLVMSetCmpXchgFailureOrdering;_Z29LLVMSetCmpXchgSuccessOrdering;_Z30LLVMGetCallSiteStringAttribute;_Z30LLVMInstructionEraseFromParent;_Z30LLVMRemoveBasicBlockFromParent;_Z30LLVMRemoveEnumAttributeAtIndex;_Z31LLVMContextGetDiagnosticContext;_Z31LLVMContextGetDiagnosticHandler;_Z31LLVMContextSetDiagnosticHandler;_Z31LLVMCreateMemoryBufferWithSTDIN;_Z31LLVMFinalizeFunctionPassManager;_Z31LLVMGetEnumAttributeKindForName;_Z31LLVMGetNamedMetadataNumOperands;_Z31LLVMInstructionRemoveFromParent;_Z31LLVMRemoveCallSiteEnumAttribute;_Z32LLVMConstIntOfArbitraryPrecision;_Z32LLVMRemoveStringAttributeAtIndex;_Z33LLVMInitializeFunctionPassManager;_Z33LLVMModuleCreateWithNameInContext;_Z33LLVMRemoveCallSiteStringAttribute;_Z34LLVMAddTargetDependentFunctionAttr;_Z37LLVMCreateMemoryBufferWithMemoryRange;_Z38LLVMCreateFunctionPassManagerForModule;_Z40LLVMCreateMemoryBufferWithContentsOfFile;_Z41LLVMCreateMemoryBufferWithMemoryRangeCopy;_Z41LLVMCreateModuleProviderForExistingModule;_Z9LLVMGetGC;_Z9LLVMSetGC; -static-type=CoreGlobals -package=org.llvm.llvm_c")
//</editor-fold>
public final class CoreGlobals {


/**
* @defgroup LLVMC LLVM-C: C interface to LLVM
*
* This module exposes parts of the LLVM library as a C API.
*
* @{
*/

/**
* @defgroup LLVMCTransforms Transforms
*/

/**
* @defgroup LLVMCCore Core
*
* This modules provide an interface to libLLVMCore, which implements
* the LLVM intermediate representation as well as other related types
* and utilities.
*
* Many exotic languages can interoperate with C code but have a harder time
* with C++ due to name mangling. So in addition to C, this interface enables
* tools written in such languages.
*
* @{
*/

/**
* @defgroup LLVMCCoreTypes Types and Enumerations
*
* @{
*/
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/Core.h", line = 57,
 FQN="(anonymous)", NM="_LLVMAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_LLVMAttribute")
//</editor-fold>
public static final class/*enum*/ LLVMAttribute {
  public static final int LLVMZExtAttribute = 1 << 0;
  public static final int LLVMSExtAttribute = 1 << 1;
  public static final int LLVMNoReturnAttribute = 1 << 2;
  public static final int LLVMInRegAttribute = 1 << 3;
  public static final int LLVMStructRetAttribute = 1 << 4;
  public static final int LLVMNoUnwindAttribute = 1 << 5;
  public static final int LLVMNoAliasAttribute = 1 << 6;
  public static final int LLVMByValAttribute = 1 << 7;
  public static final int LLVMNestAttribute = 1 << 8;
  public static final int LLVMReadNoneAttribute = 1 << 9;
  public static final int LLVMReadOnlyAttribute = 1 << 10;
  public static final int LLVMNoInlineAttribute = 1 << 11;
  public static final int LLVMAlwaysInlineAttribute = 1 << 12;
  public static final int LLVMOptimizeForSizeAttribute = 1 << 13;
  public static final int LLVMStackProtectAttribute = 1 << 14;
  public static final int LLVMStackProtectReqAttribute = 1 << 15;
  public static final int LLVMAlignment = 31 << 16;
  public static final int LLVMNoCaptureAttribute = 1 << 21;
  public static final int LLVMNoRedZoneAttribute = 1 << 22;
  public static final int LLVMNoImplicitFloatAttribute = 1 << 23;
  public static final int LLVMNakedAttribute = 1 << 24;
  public static final int LLVMInlineHintAttribute = 1 << 25;
  public static final int LLVMStackAlignment = 7 << 26;
  public static final int LLVMReturnsTwice = 1 << 29;
  public static final int LLVMUWTable = 1 << 30;
  public static final int LLVMNonLazyBind = 1 << 31;
  /* FIXME: These attributes are currently not included in the C API as
  a temporary measure until the API/ABI impact to the C API is understood
  and the path forward agreed upon.
  LLVMSanitizeAddressAttribute = 1ULL << 32,
  LLVMStackProtectStrongAttribute = 1ULL<<35,
  LLVMColdAttribute = 1ULL << 40,
  LLVMOptimizeNoneAttribute = 1ULL << 42,
  LLVMInAllocaAttribute = 1ULL << 43,
  LLVMNonNullAttribute = 1ULL << 44,
  LLVMJumpTableAttribute = 1ULL << 45,
  LLVMConvergentAttribute = 1ULL << 46,
  LLVMSafeStackAttribute = 1ULL << 47,
  LLVMSwiftSelfAttribute = 1ULL << 48,
  LLVMSwiftErrorAttribute = 1ULL << 49,
  */
}
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/Core.h", line = 102,
 FQN="(anonymous)", NM="_LLVMOpcode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_LLVMOpcode")
//</editor-fold>
public enum LLVMOpcode implements Native.NativeUIntEnum {
  /* Terminator Instructions */
  LLVMRet(1),
  LLVMBr(2),
  LLVMSwitch(3),
  LLVMIndirectBr(4),
  LLVMInvoke(5),
  /* removed 6 due to API changes */
  LLVMUnreachable(7),
  
  /* Standard Binary Operators */
  LLVMAdd(8),
  LLVMFAdd(9),
  LLVMSub(10),
  LLVMFSub(11),
  LLVMMul(12),
  LLVMFMul(13),
  LLVMUDiv(14),
  LLVMSDiv(15),
  LLVMFDiv(16),
  LLVMURem(17),
  LLVMSRem(18),
  LLVMFRem(19),
  
  /* Logical Operators */
  LLVMShl(20),
  LLVMLShr(21),
  LLVMAShr(22),
  LLVMAnd(23),
  LLVMOr(24),
  LLVMXor(25),
  
  /* Memory Operators */
  LLVMAlloca(26),
  LLVMLoad(27),
  LLVMStore(28),
  LLVMGetElementPtr(29),
  
  /* Cast Operators */
  LLVMTrunc(30),
  LLVMZExt(31),
  LLVMSExt(32),
  LLVMFPToUI(33),
  LLVMFPToSI(34),
  LLVMUIToFP(35),
  LLVMSIToFP(36),
  LLVMFPTrunc(37),
  LLVMFPExt(38),
  LLVMPtrToInt(39),
  LLVMIntToPtr(40),
  LLVMBitCast(41),
  LLVMAddrSpaceCast(60),
  
  /* Other Operators */
  LLVMICmp(42),
  LLVMFCmp(43),
  LLVMPHI(44),
  LLVMCall(45),
  LLVMSelect(46),
  LLVMUserOp1(47),
  LLVMUserOp2(48),
  LLVMVAArg(49),
  LLVMExtractElement(50),
  LLVMInsertElement(51),
  LLVMShuffleVector(52),
  LLVMExtractValue(53),
  LLVMInsertValue(54),
  
  /* Atomic operators */
  LLVMFence(55),
  LLVMAtomicCmpXchg(56),
  LLVMAtomicRMW(57),
  
  /* Exception Handling Operators */
  LLVMResume(58),
  LLVMLandingPad(59),
  LLVMCleanupRet(61),
  LLVMCatchRet(62),
  LLVMCatchPad(63),
  LLVMCleanupPad(64),
  LLVMCatchSwitch(65);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMOpcode valueOf(int val) {
    LLVMOpcode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMOpcode[] VALUES;
    private static final LLVMOpcode[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMOpcode kind : LLVMOpcode.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMOpcode[min < 0 ? (1-min) : 0];
      VALUES = new LLVMOpcode[max >= 0 ? (1+max) : 0];
      for (LLVMOpcode kind : LLVMOpcode.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private LLVMOpcode(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/Core.h", line = 185,
 FQN="(anonymous)", NM="_LLVMTypeKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_LLVMTypeKind")
//</editor-fold>
public enum LLVMTypeKind implements Native.NativeUIntEnum {
  LLVMVoidTypeKind(0), /**< type with no size */
  LLVMHalfTypeKind(LLVMVoidTypeKind.getValue() + 1), /**< 16 bit floating point type */
  LLVMFloatTypeKind(LLVMHalfTypeKind.getValue() + 1), /**< 32 bit floating point type */
  LLVMDoubleTypeKind(LLVMFloatTypeKind.getValue() + 1), /**< 64 bit floating point type */
  LLVMX86_FP80TypeKind(LLVMDoubleTypeKind.getValue() + 1), /**< 80 bit floating point type (X87) */
  LLVMFP128TypeKind(LLVMX86_FP80TypeKind.getValue() + 1), /**< 128 bit floating point type (112-bit mantissa)*/
  LLVMPPC_FP128TypeKind(LLVMFP128TypeKind.getValue() + 1), /**< 128 bit floating point type (two 64-bits) */
  LLVMLabelTypeKind(LLVMPPC_FP128TypeKind.getValue() + 1), /**< Labels */
  LLVMIntegerTypeKind(LLVMLabelTypeKind.getValue() + 1), /**< Arbitrary bit width integers */
  LLVMFunctionTypeKind(LLVMIntegerTypeKind.getValue() + 1), /**< Functions */
  LLVMStructTypeKind(LLVMFunctionTypeKind.getValue() + 1), /**< Structures */
  LLVMArrayTypeKind(LLVMStructTypeKind.getValue() + 1), /**< Arrays */
  LLVMPointerTypeKind(LLVMArrayTypeKind.getValue() + 1), /**< Pointers */
  LLVMVectorTypeKind(LLVMPointerTypeKind.getValue() + 1), /**< SIMD 'packed' format, or other vector type */
  LLVMMetadataTypeKind(LLVMVectorTypeKind.getValue() + 1), /**< Metadata */
  LLVMX86_MMXTypeKind(LLVMMetadataTypeKind.getValue() + 1), /**< X86 MMX */
  LLVMTokenTypeKind(LLVMX86_MMXTypeKind.getValue() + 1); /**< Tokens */

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMTypeKind valueOf(int val) {
    LLVMTypeKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMTypeKind[] VALUES;
    private static final LLVMTypeKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMTypeKind kind : LLVMTypeKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMTypeKind[min < 0 ? (1-min) : 0];
      VALUES = new LLVMTypeKind[max >= 0 ? (1+max) : 0];
      for (LLVMTypeKind kind : LLVMTypeKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private LLVMTypeKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/Core.h", line = 205,
 FQN="(anonymous)", NM="_LLVMLinkage",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_LLVMLinkage")
//</editor-fold>
public enum LLVMLinkage implements Native.NativeUIntEnum {
  LLVMExternalLinkage(0), /**< Externally visible function */
  LLVMAvailableExternallyLinkage(LLVMExternalLinkage.getValue() + 1),
  LLVMLinkOnceAnyLinkage(LLVMAvailableExternallyLinkage.getValue() + 1), /**< Keep one copy of function when linking (inline)*/
  LLVMLinkOnceODRLinkage(LLVMLinkOnceAnyLinkage.getValue() + 1), /**< Same, but only replaced by something
  equivalent. */
  LLVMLinkOnceODRAutoHideLinkage(LLVMLinkOnceODRLinkage.getValue() + 1), /**< Obsolete */
  LLVMWeakAnyLinkage(LLVMLinkOnceODRAutoHideLinkage.getValue() + 1), /**< Keep one copy of function when linking (weak) */
  LLVMWeakODRLinkage(LLVMWeakAnyLinkage.getValue() + 1), /**< Same, but only replaced by something
  equivalent. */
  LLVMAppendingLinkage(LLVMWeakODRLinkage.getValue() + 1), /**< Special purpose, only applies to global arrays */
  LLVMInternalLinkage(LLVMAppendingLinkage.getValue() + 1), /**< Rename collisions when linking (static
  functions) */
  LLVMPrivateLinkage(LLVMInternalLinkage.getValue() + 1), /**< Like Internal, but omit from symbol table */
  LLVMDLLImportLinkage(LLVMPrivateLinkage.getValue() + 1), /**< Obsolete */
  LLVMDLLExportLinkage(LLVMDLLImportLinkage.getValue() + 1), /**< Obsolete */
  LLVMExternalWeakLinkage(LLVMDLLExportLinkage.getValue() + 1), /**< ExternalWeak linkage description */
  LLVMGhostLinkage(LLVMExternalWeakLinkage.getValue() + 1), /**< Obsolete */
  LLVMCommonLinkage(LLVMGhostLinkage.getValue() + 1), /**< Tentative definitions */
  LLVMLinkerPrivateLinkage(LLVMCommonLinkage.getValue() + 1), /**< Like Private, but linker removes. */
  LLVMLinkerPrivateWeakLinkage(LLVMLinkerPrivateLinkage.getValue() + 1); /**< Like LinkerPrivate, but is weak. */

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMLinkage valueOf(int val) {
    LLVMLinkage out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMLinkage[] VALUES;
    private static final LLVMLinkage[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMLinkage kind : LLVMLinkage.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMLinkage[min < 0 ? (1-min) : 0];
      VALUES = new LLVMLinkage[max >= 0 ? (1+max) : 0];
      for (LLVMLinkage kind : LLVMLinkage.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private LLVMLinkage(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/Core.h", line = 228,
 FQN="(anonymous)", NM="_LLVMVisibility",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_LLVMVisibility")
//</editor-fold>
public enum LLVMVisibility implements Native.NativeUIntEnum {
  LLVMDefaultVisibility(0), /**< The GV is visible */
  LLVMHiddenVisibility(LLVMDefaultVisibility.getValue() + 1), /**< The GV is hidden */
  LLVMProtectedVisibility(LLVMHiddenVisibility.getValue() + 1); /**< The GV is protected */

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMVisibility valueOf(int val) {
    LLVMVisibility out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMVisibility[] VALUES;
    private static final LLVMVisibility[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMVisibility kind : LLVMVisibility.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMVisibility[min < 0 ? (1-min) : 0];
      VALUES = new LLVMVisibility[max >= 0 ? (1+max) : 0];
      for (LLVMVisibility kind : LLVMVisibility.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private LLVMVisibility(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/Core.h", line = 234,
 FQN="(anonymous)", NM="_LLVMDLLStorageClass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_LLVMDLLStorageClass")
//</editor-fold>
public enum LLVMDLLStorageClass implements Native.NativeUIntEnum {
  LLVMDefaultStorageClass(0),
  LLVMDLLImportStorageClass(1), /**< Function to be imported from DLL. */
  LLVMDLLExportStorageClass(2); /**< Function to be accessible from DLL. */

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMDLLStorageClass valueOf(int val) {
    LLVMDLLStorageClass out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMDLLStorageClass[] VALUES;
    private static final LLVMDLLStorageClass[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMDLLStorageClass kind : LLVMDLLStorageClass.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMDLLStorageClass[min < 0 ? (1-min) : 0];
      VALUES = new LLVMDLLStorageClass[max >= 0 ? (1+max) : 0];
      for (LLVMDLLStorageClass kind : LLVMDLLStorageClass.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private LLVMDLLStorageClass(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/Core.h", line = 240,
 FQN="(anonymous)", NM="_LLVMCallConv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_LLVMCallConv")
//</editor-fold>
public enum LLVMCallConv implements Native.NativeUIntEnum {
  LLVMCCallConv(0),
  LLVMFastCallConv(8),
  LLVMColdCallConv(9),
  LLVMWebKitJSCallConv(12),
  LLVMAnyRegCallConv(13),
  LLVMX86StdcallCallConv(64),
  LLVMX86FastcallCallConv(65);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMCallConv valueOf(int val) {
    LLVMCallConv out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMCallConv[] VALUES;
    private static final LLVMCallConv[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMCallConv kind : LLVMCallConv.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMCallConv[min < 0 ? (1-min) : 0];
      VALUES = new LLVMCallConv[max >= 0 ? (1+max) : 0];
      for (LLVMCallConv kind : LLVMCallConv.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private LLVMCallConv(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/Core.h", line = 250,
 FQN="(anonymous)", NM="_LLVMValueKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_LLVMValueKind")
//</editor-fold>
public enum LLVMValueKind implements Native.NativeUIntEnum {
  LLVMArgumentValueKind(0),
  LLVMBasicBlockValueKind(LLVMArgumentValueKind.getValue() + 1),
  LLVMMemoryUseValueKind(LLVMBasicBlockValueKind.getValue() + 1),
  LLVMMemoryDefValueKind(LLVMMemoryUseValueKind.getValue() + 1),
  LLVMMemoryPhiValueKind(LLVMMemoryDefValueKind.getValue() + 1),
  
  LLVMFunctionValueKind(LLVMMemoryPhiValueKind.getValue() + 1),
  LLVMGlobalAliasValueKind(LLVMFunctionValueKind.getValue() + 1),
  LLVMGlobalIFuncValueKind(LLVMGlobalAliasValueKind.getValue() + 1),
  LLVMGlobalVariableValueKind(LLVMGlobalIFuncValueKind.getValue() + 1),
  LLVMBlockAddressValueKind(LLVMGlobalVariableValueKind.getValue() + 1),
  LLVMConstantExprValueKind(LLVMBlockAddressValueKind.getValue() + 1),
  LLVMConstantArrayValueKind(LLVMConstantExprValueKind.getValue() + 1),
  LLVMConstantStructValueKind(LLVMConstantArrayValueKind.getValue() + 1),
  LLVMConstantVectorValueKind(LLVMConstantStructValueKind.getValue() + 1),
  
  LLVMUndefValueValueKind(LLVMConstantVectorValueKind.getValue() + 1),
  LLVMConstantAggregateZeroValueKind(LLVMUndefValueValueKind.getValue() + 1),
  LLVMConstantDataArrayValueKind(LLVMConstantAggregateZeroValueKind.getValue() + 1),
  LLVMConstantDataVectorValueKind(LLVMConstantDataArrayValueKind.getValue() + 1),
  LLVMConstantIntValueKind(LLVMConstantDataVectorValueKind.getValue() + 1),
  LLVMConstantFPValueKind(LLVMConstantIntValueKind.getValue() + 1),
  LLVMConstantPointerNullValueKind(LLVMConstantFPValueKind.getValue() + 1),
  LLVMConstantTokenNoneValueKind(LLVMConstantPointerNullValueKind.getValue() + 1),
  
  LLVMMetadataAsValueValueKind(LLVMConstantTokenNoneValueKind.getValue() + 1),
  LLVMInlineAsmValueKind(LLVMMetadataAsValueValueKind.getValue() + 1),
  
  LLVMInstructionValueKind(LLVMInlineAsmValueKind.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMValueKind valueOf(int val) {
    LLVMValueKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMValueKind[] VALUES;
    private static final LLVMValueKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMValueKind kind : LLVMValueKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMValueKind[min < 0 ? (1-min) : 0];
      VALUES = new LLVMValueKind[max >= 0 ? (1+max) : 0];
      for (LLVMValueKind kind : LLVMValueKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private LLVMValueKind(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/Core.h", line = 282,
 FQN="(anonymous)", NM="_LLVMIntPredicate",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_LLVMIntPredicate")
//</editor-fold>
public enum LLVMIntPredicate implements Native.NativeUIntEnum {
  LLVMIntEQ(32), /**< equal */
  LLVMIntNE(LLVMIntEQ.getValue() + 1), /**< not equal */
  LLVMIntUGT(LLVMIntNE.getValue() + 1), /**< unsigned greater than */
  LLVMIntUGE(LLVMIntUGT.getValue() + 1), /**< unsigned greater or equal */
  LLVMIntULT(LLVMIntUGE.getValue() + 1), /**< unsigned less than */
  LLVMIntULE(LLVMIntULT.getValue() + 1), /**< unsigned less or equal */
  LLVMIntSGT(LLVMIntULE.getValue() + 1), /**< signed greater than */
  LLVMIntSGE(LLVMIntSGT.getValue() + 1), /**< signed greater or equal */
  LLVMIntSLT(LLVMIntSGE.getValue() + 1), /**< signed less than */
  LLVMIntSLE(LLVMIntSLT.getValue() + 1); /**< signed less or equal */

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMIntPredicate valueOf(int val) {
    LLVMIntPredicate out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMIntPredicate[] VALUES;
    private static final LLVMIntPredicate[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMIntPredicate kind : LLVMIntPredicate.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMIntPredicate[min < 0 ? (1-min) : 0];
      VALUES = new LLVMIntPredicate[max >= 0 ? (1+max) : 0];
      for (LLVMIntPredicate kind : LLVMIntPredicate.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private LLVMIntPredicate(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/Core.h", line = 295,
 FQN="(anonymous)", NM="_LLVMRealPredicate",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_LLVMRealPredicate")
//</editor-fold>
public enum LLVMRealPredicate implements Native.NativeUIntEnum {
  LLVMRealPredicateFalse(0), /**< Always false (always folded) */
  LLVMRealOEQ(LLVMRealPredicateFalse.getValue() + 1), /**< True if ordered and equal */
  LLVMRealOGT(LLVMRealOEQ.getValue() + 1), /**< True if ordered and greater than */
  LLVMRealOGE(LLVMRealOGT.getValue() + 1), /**< True if ordered and greater than or equal */
  LLVMRealOLT(LLVMRealOGE.getValue() + 1), /**< True if ordered and less than */
  LLVMRealOLE(LLVMRealOLT.getValue() + 1), /**< True if ordered and less than or equal */
  LLVMRealONE(LLVMRealOLE.getValue() + 1), /**< True if ordered and operands are unequal */
  LLVMRealORD(LLVMRealONE.getValue() + 1), /**< True if ordered (no nans) */
  LLVMRealUNO(LLVMRealORD.getValue() + 1), /**< True if unordered: isnan(X) | isnan(Y) */
  LLVMRealUEQ(LLVMRealUNO.getValue() + 1), /**< True if unordered or equal */
  LLVMRealUGT(LLVMRealUEQ.getValue() + 1), /**< True if unordered or greater than */
  LLVMRealUGE(LLVMRealUGT.getValue() + 1), /**< True if unordered, greater than, or equal */
  LLVMRealULT(LLVMRealUGE.getValue() + 1), /**< True if unordered or less than */
  LLVMRealULE(LLVMRealULT.getValue() + 1), /**< True if unordered, less than, or equal */
  LLVMRealUNE(LLVMRealULE.getValue() + 1), /**< True if unordered or not equal */
  LLVMRealPredicateTrue(LLVMRealUNE.getValue() + 1); /**< Always true (always folded) */

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMRealPredicate valueOf(int val) {
    LLVMRealPredicate out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMRealPredicate[] VALUES;
    private static final LLVMRealPredicate[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMRealPredicate kind : LLVMRealPredicate.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMRealPredicate[min < 0 ? (1-min) : 0];
      VALUES = new LLVMRealPredicate[max >= 0 ? (1+max) : 0];
      for (LLVMRealPredicate kind : LLVMRealPredicate.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private LLVMRealPredicate(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/Core.h", line = 314,
 FQN="(anonymous)", NM="_LLVMLandingPadClauseTy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_LLVMLandingPadClauseTy")
//</editor-fold>
public enum LLVMLandingPadClauseTy implements Native.NativeUIntEnum {
  LLVMLandingPadCatch(0), /**< A catch clause   */
  LLVMLandingPadFilter(LLVMLandingPadCatch.getValue() + 1); /**< A filter clause  */

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMLandingPadClauseTy valueOf(int val) {
    LLVMLandingPadClauseTy out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMLandingPadClauseTy[] VALUES;
    private static final LLVMLandingPadClauseTy[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMLandingPadClauseTy kind : LLVMLandingPadClauseTy.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMLandingPadClauseTy[min < 0 ? (1-min) : 0];
      VALUES = new LLVMLandingPadClauseTy[max >= 0 ? (1+max) : 0];
      for (LLVMLandingPadClauseTy kind : LLVMLandingPadClauseTy.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private LLVMLandingPadClauseTy(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/Core.h", line = 319,
 FQN="(anonymous)", NM="_LLVMThreadLocalMode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_LLVMThreadLocalMode")
//</editor-fold>
public enum LLVMThreadLocalMode implements Native.NativeUIntEnum {
  LLVMNotThreadLocal(0),
  LLVMGeneralDynamicTLSModel(LLVMNotThreadLocal.getValue() + 1),
  LLVMLocalDynamicTLSModel(LLVMGeneralDynamicTLSModel.getValue() + 1),
  LLVMInitialExecTLSModel(LLVMLocalDynamicTLSModel.getValue() + 1),
  LLVMLocalExecTLSModel(LLVMInitialExecTLSModel.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMThreadLocalMode valueOf(int val) {
    LLVMThreadLocalMode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMThreadLocalMode[] VALUES;
    private static final LLVMThreadLocalMode[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMThreadLocalMode kind : LLVMThreadLocalMode.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMThreadLocalMode[min < 0 ? (1-min) : 0];
      VALUES = new LLVMThreadLocalMode[max >= 0 ? (1+max) : 0];
      for (LLVMThreadLocalMode kind : LLVMThreadLocalMode.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private LLVMThreadLocalMode(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/Core.h", line = 327,
 FQN="(anonymous)", NM="_LLVMAtomicOrdering",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_LLVMAtomicOrdering")
//</editor-fold>
public enum LLVMAtomicOrdering implements Native.NativeUIntEnum {
  LLVMAtomicOrderingNotAtomic(0), /**< A load or store which is not atomic */
  LLVMAtomicOrderingUnordered(1), /**< Lowest level of atomicity, guarantees
  somewhat sane results, lock free. */
  LLVMAtomicOrderingMonotonic(2), /**< guarantees that if you take all the
  operations affecting a specific address,
  a consistent ordering exists */
  LLVMAtomicOrderingAcquire(4), /**< Acquire provides a barrier of the sort
  necessary to acquire a lock to access other
  memory with normal loads and stores. */
  LLVMAtomicOrderingRelease(5), /**< Release is similar to Acquire, but with
  a barrier of the sort necessary to release
  a lock. */
  LLVMAtomicOrderingAcquireRelease(6), /**< provides both an Acquire and a
  Release barrier (for fences and
  operations which both read and write
  memory). */
  LLVMAtomicOrderingSequentiallyConsistent(7); /**< provides Acquire semantics
  for loads and Release
  semantics for stores.
  Additionally, it guarantees
  that a total ordering exists
  between all
  SequentiallyConsistent
  operations. */

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMAtomicOrdering valueOf(int val) {
    LLVMAtomicOrdering out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMAtomicOrdering[] VALUES;
    private static final LLVMAtomicOrdering[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMAtomicOrdering kind : LLVMAtomicOrdering.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMAtomicOrdering[min < 0 ? (1-min) : 0];
      VALUES = new LLVMAtomicOrdering[max >= 0 ? (1+max) : 0];
      for (LLVMAtomicOrdering kind : LLVMAtomicOrdering.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private LLVMAtomicOrdering(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/Core.h", line = 354,
 FQN="(anonymous)", NM="_LLVMAtomicRMWBinOp",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_LLVMAtomicRMWBinOp")
//</editor-fold>
public enum LLVMAtomicRMWBinOp implements Native.NativeUIntEnum {
  LLVMAtomicRMWBinOpXchg(0), /**< Set the new value and return the one old */
  LLVMAtomicRMWBinOpAdd(LLVMAtomicRMWBinOpXchg.getValue() + 1), /**< Add a value and return the old one */
  LLVMAtomicRMWBinOpSub(LLVMAtomicRMWBinOpAdd.getValue() + 1), /**< Subtract a value and return the old one */
  LLVMAtomicRMWBinOpAnd(LLVMAtomicRMWBinOpSub.getValue() + 1), /**< And a value and return the old one */
  LLVMAtomicRMWBinOpNand(LLVMAtomicRMWBinOpAnd.getValue() + 1), /**< Not-And a value and return the old one */
  LLVMAtomicRMWBinOpOr(LLVMAtomicRMWBinOpNand.getValue() + 1), /**< OR a value and return the old one */
  LLVMAtomicRMWBinOpXor(LLVMAtomicRMWBinOpOr.getValue() + 1), /**< Xor a value and return the old one */
  LLVMAtomicRMWBinOpMax(LLVMAtomicRMWBinOpXor.getValue() + 1), /**< Sets the value if it's greater than the
  original using a signed comparison and return
  the old one */
  LLVMAtomicRMWBinOpMin(LLVMAtomicRMWBinOpMax.getValue() + 1), /**< Sets the value if it's Smaller than the
  original using a signed comparison and return
  the old one */
  LLVMAtomicRMWBinOpUMax(LLVMAtomicRMWBinOpMin.getValue() + 1), /**< Sets the value if it's greater than the
  original using an unsigned comparison and return
  the old one */
  LLVMAtomicRMWBinOpUMin(LLVMAtomicRMWBinOpUMax.getValue() + 1); /**< Sets the value if it's greater than the
  original using an unsigned comparison  and return
  the old one */

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMAtomicRMWBinOp valueOf(int val) {
    LLVMAtomicRMWBinOp out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMAtomicRMWBinOp[] VALUES;
    private static final LLVMAtomicRMWBinOp[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMAtomicRMWBinOp kind : LLVMAtomicRMWBinOp.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMAtomicRMWBinOp[min < 0 ? (1-min) : 0];
      VALUES = new LLVMAtomicRMWBinOp[max >= 0 ? (1+max) : 0];
      for (LLVMAtomicRMWBinOp kind : LLVMAtomicRMWBinOp.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private LLVMAtomicRMWBinOp(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/Core.h", line = 376,
 FQN="(anonymous)", NM="_LLVMDiagnosticSeverity",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_LLVMDiagnosticSeverity")
//</editor-fold>
public enum LLVMDiagnosticSeverity implements Native.NativeUIntEnum {
  LLVMDSError(0),
  LLVMDSWarning(LLVMDSError.getValue() + 1),
  LLVMDSRemark(LLVMDSWarning.getValue() + 1),
  LLVMDSNote(LLVMDSRemark.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMDiagnosticSeverity valueOf(int val) {
    LLVMDiagnosticSeverity out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMDiagnosticSeverity[] VALUES;
    private static final LLVMDiagnosticSeverity[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMDiagnosticSeverity kind : LLVMDiagnosticSeverity.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMDiagnosticSeverity[min < 0 ? (1-min) : 0];
      VALUES = new LLVMDiagnosticSeverity[max >= 0 ? (1+max) : 0];
      for (LLVMDiagnosticSeverity kind : LLVMDiagnosticSeverity.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private LLVMDiagnosticSeverity(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}

/**
* Attribute index are either LLVMAttributeReturnIndex,
* LLVMAttributeFunctionIndex or a parameter number from 1 to N.
*/
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/Core.h", line = 387,
 FQN="(anonymous)", NM="_Unnamed_enum15",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_Unnamed_enum15")
//</editor-fold>
public enum Unnamed_enum15 implements Native.NativeIntEnum {
  LLVMAttributeReturnIndex(0/*U*/),
  // ISO C restricts enumerator values to range of 'int'
  // (4294967295 is too large)
  // LLVMAttributeFunctionIndex = ~0U,
  LLVMAttributeFunctionIndex(-1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static Unnamed_enum15 valueOf(int val) {
    Unnamed_enum15 out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final Unnamed_enum15[] VALUES;
    private static final Unnamed_enum15[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (Unnamed_enum15 kind : Unnamed_enum15.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new Unnamed_enum15[min < 0 ? (1-min) : 0];
      VALUES = new Unnamed_enum15[max >= 0 ? (1+max) : 0];
      for (Unnamed_enum15 kind : Unnamed_enum15.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final int value;
  private Unnamed_enum15(int val) { this.value = (int)val;}
  @Override public final int getValue() { return value;}
  //</editor-fold>
}

/**
* @}
*/

/**
* @}
*/
//<editor-fold defaultstate="collapsed" desc="LLVMInitializeCore">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 57,
 FQN="LLVMInitializeCore", NM="_Z18LLVMInitializeCore",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMInitializeCore")
//</editor-fold>
public static void LLVMInitializeCore( LLVMOpaquePassRegistry /*P*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** Deallocate and destroy all ManagedStatic variables.
@see llvm::llvm_shutdown
@see ManagedStatic */

/** Deallocate and destroy all ManagedStatic variables.
@see llvm::llvm_shutdown
@see ManagedStatic */
//<editor-fold defaultstate="collapsed" desc="LLVMShutdown">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 61,
 FQN="LLVMShutdown", NM="_Z12LLVMShutdown",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMShutdown")
//</editor-fold>
public static void LLVMShutdown() {
  throw new UnsupportedOperationException("EmptyBody");
}


/*===-- Error handling ----------------------------------------------------===*/

/*===-- Error handling ----------------------------------------------------===*/

/*===-- Error handling ----------------------------------------------------===*/
//<editor-fold defaultstate="collapsed" desc="LLVMCreateMessage">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 67,
 FQN="LLVMCreateMessage", NM="_Z17LLVMCreateMessage",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMCreateMessage")
//</editor-fold>
public static char$ptr/*char P*/ LLVMCreateMessage(/*const*/char$ptr/*char P*/ Message) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMDisposeMessage">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 71,
 FQN="LLVMDisposeMessage", NM="_Z18LLVMDisposeMessage",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMDisposeMessage")
//</editor-fold>
public static void LLVMDisposeMessage(char$ptr/*char P*/ Message) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Create a new context.
*
* Every call to this function should be paired with a call to
* LLVMContextDispose() or the context will leak memory.
*/

/**
* Create a new context.
*
* Every call to this function should be paired with a call to
* LLVMContextDispose() or the context will leak memory.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMContextCreate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 80,
 FQN="LLVMContextCreate", NM="_Z17LLVMContextCreate",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMContextCreate")
//</editor-fold>
public static  LLVMOpaqueContext /*P*/ LLVMContextCreate() {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the global context instance.
*/

/**
* Obtain the global context instance.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetGlobalContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 84,
 FQN="LLVMGetGlobalContext", NM="_Z20LLVMGetGlobalContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetGlobalContext")
//</editor-fold>
public static  LLVMOpaqueContext /*P*/ LLVMGetGlobalContext() {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set the diagnostic handler for this context.
*/

/**
* Set the diagnostic handler for this context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMContextSetDiagnosticHandler">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 86,
 FQN="LLVMContextSetDiagnosticHandler", NM="_Z31LLVMContextSetDiagnosticHandler",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z31LLVMContextSetDiagnosticHandler")
//</editor-fold>
public static void LLVMContextSetDiagnosticHandler( LLVMOpaqueContext /*P*/ C, 
                               LLVMDiagnosticHandler Handler, 
                               Object/*void P*/ DiagnosticContext) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Get the diagnostic handler of this context.
*/

/**
* Get the diagnostic handler of this context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMContextGetDiagnosticHandler">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 95,
 FQN="LLVMContextGetDiagnosticHandler", NM="_Z31LLVMContextGetDiagnosticHandler",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z31LLVMContextGetDiagnosticHandler")
//</editor-fold>
public static LLVMDiagnosticHandler LLVMContextGetDiagnosticHandler( LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Get the diagnostic context of this context.
*/

/**
* Get the diagnostic context of this context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMContextGetDiagnosticContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 100,
 FQN="LLVMContextGetDiagnosticContext", NM="_Z31LLVMContextGetDiagnosticContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z31LLVMContextGetDiagnosticContext")
//</editor-fold>
public static Object/*void P*/ LLVMContextGetDiagnosticContext( LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set the yield callback function for this context.
*
* @see LLVMContext::setYieldCallback()
*/

/**
* Set the yield callback function for this context.
*
* @see LLVMContext::setYieldCallback()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMContextSetYieldCallback">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 104,
 FQN="LLVMContextSetYieldCallback", NM="_Z27LLVMContextSetYieldCallback",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMContextSetYieldCallback")
//</editor-fold>
public static void LLVMContextSetYieldCallback( LLVMOpaqueContext /*P*/ C, LLVMYieldCallback Callback, 
                           Object/*void P*/ OpaqueHandle) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Destroy a context instance.
*
* This should be called for every call to LLVMContextCreate() or memory
* will be leaked.
*/

/**
* Destroy a context instance.
*
* This should be called for every call to LLVMContextCreate() or memory
* will be leaked.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMContextDispose">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 111,
 FQN="LLVMContextDispose", NM="_Z18LLVMContextDispose",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMContextDispose")
//</editor-fold>
public static void LLVMContextDispose( LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Return a string representation of the DiagnosticInfo. Use
* LLVMDisposeMessage to free the string.
*
* @see DiagnosticInfo::print()
*/

/**
* Return a string representation of the DiagnosticInfo. Use
* LLVMDisposeMessage to free the string.
*
* @see DiagnosticInfo::print()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetDiagInfoDescription">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 181,
 FQN="LLVMGetDiagInfoDescription", NM="_Z26LLVMGetDiagInfoDescription",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMGetDiagInfoDescription")
//</editor-fold>
public static char$ptr/*char P*/ LLVMGetDiagInfoDescription( LLVMOpaqueDiagnosticInfo /*P*/ DI) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Return an enum LLVMDiagnosticSeverity.
*
* @see DiagnosticInfo::getSeverity()
*/

/**
* Return an enum LLVMDiagnosticSeverity.
*
* @see DiagnosticInfo::getSeverity()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetDiagInfoSeverity">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 192,
 FQN="LLVMGetDiagInfoSeverity", NM="_Z23LLVMGetDiagInfoSeverity",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMGetDiagInfoSeverity")
//</editor-fold>
public static LLVMDiagnosticSeverity LLVMGetDiagInfoSeverity( LLVMOpaqueDiagnosticInfo /*P*/ DI) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetMDKindIDInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 115,
 FQN="LLVMGetMDKindIDInContext", NM="_Z24LLVMGetMDKindIDInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMGetMDKindIDInContext")
//</editor-fold>
public static /*uint*/int LLVMGetMDKindIDInContext( LLVMOpaqueContext /*P*/ C, /*const*/char$ptr/*char P*/ Name, 
                        /*uint*/int SLen) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetMDKindID">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 120,
 FQN="LLVMGetMDKindID", NM="_Z15LLVMGetMDKindID",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMGetMDKindID")
//</editor-fold>
public static /*uint*/int LLVMGetMDKindID(/*const*/char$ptr/*char P*/ Name, /*uint*/int SLen) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 127,
 FQN="LLVMGetEnumAttributeKindForName", NM="_Z31LLVMGetEnumAttributeKindForName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z31LLVMGetEnumAttributeKindForName")
//</editor-fold>
public static /*uint*/int LLVMGetEnumAttributeKindForName(/*const*/char$ptr/*char P*/ Name, /*size_t*/int SLen) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetLastEnumAttributeKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 131,
 FQN="LLVMGetLastEnumAttributeKind", NM="_Z28LLVMGetLastEnumAttributeKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z28LLVMGetLastEnumAttributeKind")
//</editor-fold>
public static /*uint*/int LLVMGetLastEnumAttributeKind() {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Create an enum attribute.
*/

/**
* Create an enum attribute.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMCreateEnumAttribute">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 135,
 FQN="LLVMCreateEnumAttribute", NM="_Z23LLVMCreateEnumAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMCreateEnumAttribute")
//</editor-fold>
public static  LLVMOpaqueAttributeRef /*P*/ LLVMCreateEnumAttribute( LLVMOpaqueContext /*P*/ C, /*uint*/int KindID, 
                       long/*uint64_t*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Get the unique id corresponding to the enum attribute
* passed as argument.
*/

/**
* Get the unique id corresponding to the enum attribute
* passed as argument.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetEnumAttributeKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 140,
 FQN="LLVMGetEnumAttributeKind", NM="_Z24LLVMGetEnumAttributeKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMGetEnumAttributeKind")
//</editor-fold>
public static /*uint*/int LLVMGetEnumAttributeKind( LLVMOpaqueAttributeRef /*P*/ A) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Get the enum attribute's value. 0 is returned if none exists.
*/

/**
* Get the enum attribute's value. 0 is returned if none exists.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetEnumAttributeValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 144,
 FQN="LLVMGetEnumAttributeValue", NM="_Z25LLVMGetEnumAttributeValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMGetEnumAttributeValue")
//</editor-fold>
public static long/*uint64_t*/ LLVMGetEnumAttributeValue( LLVMOpaqueAttributeRef /*P*/ A) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Create a string attribute.
*/

/**
* Create a string attribute.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMCreateStringAttribute">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 151,
 FQN="LLVMCreateStringAttribute", NM="_Z25LLVMCreateStringAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMCreateStringAttribute")
//</editor-fold>
public static  LLVMOpaqueAttributeRef /*P*/ LLVMCreateStringAttribute( LLVMOpaqueContext /*P*/ C, 
                         /*const*/char$ptr/*char P*/ K, /*uint*/int KLength, 
                         /*const*/char$ptr/*char P*/ V, /*uint*/int VLength) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Get the string attribute's kind.
*/

/**
* Get the string attribute's kind.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetStringAttributeKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 158,
 FQN="LLVMGetStringAttributeKind", NM="_Z26LLVMGetStringAttributeKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMGetStringAttributeKind")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetStringAttributeKind( LLVMOpaqueAttributeRef /*P*/ A, 
                          uint$ptr/*uint P*/ Length) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Get the string attribute's value.
*/

/**
* Get the string attribute's value.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetStringAttributeValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 165,
 FQN="LLVMGetStringAttributeValue", NM="_Z27LLVMGetStringAttributeValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMGetStringAttributeValue")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetStringAttributeValue( LLVMOpaqueAttributeRef /*P*/ A, 
                           uint$ptr/*uint P*/ Length) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Check for the different types of attributes.
*/

/**
* Check for the different types of attributes.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsEnumAttribute">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 172,
 FQN="LLVMIsEnumAttribute", NM="_Z19LLVMIsEnumAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMIsEnumAttribute")
//</editor-fold>
public static int LLVMIsEnumAttribute( LLVMOpaqueAttributeRef /*P*/ A) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsStringAttribute">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 177,
 FQN="LLVMIsStringAttribute", NM="_Z21LLVMIsStringAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsStringAttribute")
//</editor-fold>
public static int LLVMIsStringAttribute( LLVMOpaqueAttributeRef /*P*/ A) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 215,
 FQN="LLVMModuleCreateWithName", NM="_Z24LLVMModuleCreateWithName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMModuleCreateWithName")
//</editor-fold>
public static  LLVMOpaqueModule /*P*/ LLVMModuleCreateWithName(/*const*/char$ptr/*char P*/ ModuleID) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Create a new, empty module in a specific context.
*
* Every invocation should be paired with LLVMDisposeModule() or memory
* will be leaked.
*/

/**
* Create a new, empty module in a specific context.
*
* Every invocation should be paired with LLVMDisposeModule() or memory
* will be leaked.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMModuleCreateWithNameInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 219,
 FQN="LLVMModuleCreateWithNameInContext", NM="_Z33LLVMModuleCreateWithNameInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z33LLVMModuleCreateWithNameInContext")
//</editor-fold>
public static  LLVMOpaqueModule /*P*/ LLVMModuleCreateWithNameInContext(/*const*/char$ptr/*char P*/ ModuleID, 
                                  LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}

/**
* Return an exact copy of the specified module.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMCloneModule">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp", line = 178,
 FQN="LLVMCloneModule", NM="_Z15LLVMCloneModule",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_Z15LLVMCloneModule")
//</editor-fold>
public static  LLVMOpaqueModule /*P*/ LLVMCloneModule( LLVMOpaqueModule /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Destroy a module instance.
*
* This must be called for every created module or memory will be
* leaked.
*/

/**
* Destroy a module instance.
*
* This must be called for every created module or memory will be
* leaked.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMDisposeModule">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 224,
 FQN="LLVMDisposeModule", NM="_Z17LLVMDisposeModule",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMDisposeModule")
//</editor-fold>
public static void LLVMDisposeModule( LLVMOpaqueModule /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the identifier of a module.
*
* @param M Module to obtain identifier of
* @param Len Out parameter which holds the length of the returned string.
* @return The identifier of M.
* @see Module::getModuleIdentifier()
*/

/**
* Obtain the identifier of a module.
*
* @param M Module to obtain identifier of
* @param Len Out parameter which holds the length of the returned string.
* @return The identifier of M.
* @see Module::getModuleIdentifier()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetModuleIdentifier">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 228,
 FQN="LLVMGetModuleIdentifier", NM="_Z23LLVMGetModuleIdentifier",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMGetModuleIdentifier")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetModuleIdentifier( LLVMOpaqueModule /*P*/ M, uint$ptr/*size_t P*/ Len) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set the identifier of a module to a string Ident with length Len.
*
* @param M The module to set identifier
* @param Ident The string to set M's identifier to
* @param Len Length of Ident
* @see Module::setModuleIdentifier()
*/

/**
* Set the identifier of a module to a string Ident with length Len.
*
* @param M The module to set identifier
* @param Ident The string to set M's identifier to
* @param Len Length of Ident
* @see Module::setModuleIdentifier()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetModuleIdentifier">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 234,
 FQN="LLVMSetModuleIdentifier", NM="_Z23LLVMSetModuleIdentifier",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMSetModuleIdentifier")
//</editor-fold>
public static void LLVMSetModuleIdentifier( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Ident, /*size_t*/int Len) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 240,
 FQN="LLVMGetDataLayoutStr", NM="_Z20LLVMGetDataLayoutStr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetDataLayoutStr")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetDataLayoutStr( LLVMOpaqueModule /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetDataLayout">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 244,
 FQN="LLVMGetDataLayout", NM="_Z17LLVMGetDataLayout",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetDataLayout")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetDataLayout( LLVMOpaqueModule /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set the data layout for a module.
*
* @see Module::setDataLayout()
*/

/**
* Set the data layout for a module.
*
* @see Module::setDataLayout()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetDataLayout">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 248,
 FQN="LLVMSetDataLayout", NM="_Z17LLVMSetDataLayout",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMSetDataLayout")
//</editor-fold>
public static void LLVMSetDataLayout( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ DataLayoutStr) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the target triple for a module.
*
* @see Module::getTargetTriple()
*/

/**
* Obtain the target triple for a module.
*
* @see Module::getTargetTriple()
*/

/*--.. Target triple .......................................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetTarget">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 253,
 FQN="LLVMGetTarget", NM="_Z13LLVMGetTarget",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMGetTarget")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetTarget( LLVMOpaqueModule /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set the target triple for a module.
*
* @see Module::setTargetTriple()
*/

/**
* Set the target triple for a module.
*
* @see Module::setTargetTriple()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetTarget">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 257,
 FQN="LLVMSetTarget", NM="_Z13LLVMSetTarget",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMSetTarget")
//</editor-fold>
public static void LLVMSetTarget( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Triple) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Dump a representation of a module to stderr.
*
* @see Module::dump()
*/

/**
* Dump a representation of a module to stderr.
*
* @see Module::dump()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMDumpModule">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 261,
 FQN="LLVMDumpModule", NM="_Z14LLVMDumpModule",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMDumpModule")
//</editor-fold>
public static void LLVMDumpModule( LLVMOpaqueModule /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Print a representation of a module to a file. The ErrorMessage needs to be
* disposed with LLVMDisposeMessage. Returns 0 on success, 1 otherwise.
*
* @see Module::print()
*/

/**
* Print a representation of a module to a file. The ErrorMessage needs to be
* disposed with LLVMDisposeMessage. Returns 0 on success, 1 otherwise.
*
* @see Module::print()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMPrintModuleToFile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 265,
 FQN="LLVMPrintModuleToFile", NM="_Z21LLVMPrintModuleToFile",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMPrintModuleToFile")
//</editor-fold>
public static int LLVMPrintModuleToFile( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Filename, 
                     type$ptr<char$ptr>/*char PP*/ ErrorMessage) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Return a string representation of the module. Use
* LLVMDisposeMessage to free the string.
*
* @see Module::print()
*/

/**
* Return a string representation of the module. Use
* LLVMDisposeMessage to free the string.
*
* @see Module::print()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMPrintModuleToString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 286,
 FQN="LLVMPrintModuleToString", NM="_Z23LLVMPrintModuleToString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMPrintModuleToString")
//</editor-fold>
public static char$ptr/*char P*/ LLVMPrintModuleToString( LLVMOpaqueModule /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set inline assembly for a module.
*
* @see Module::setModuleInlineAsm()
*/

/**
* Set inline assembly for a module.
*
* @see Module::setModuleInlineAsm()
*/

/*--.. Operations on inline assembler ......................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetModuleInlineAsm">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 297,
 FQN="LLVMSetModuleInlineAsm", NM="_Z22LLVMSetModuleInlineAsm",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMSetModuleInlineAsm")
//</editor-fold>
public static void LLVMSetModuleInlineAsm( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Asm) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the context to which this module is associated.
*
* @see Module::getContext()
*/

/**
* Obtain the context to which this module is associated.
*
* @see Module::getContext()
*/

/*--.. Operations on module contexts ......................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetModuleContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 303,
 FQN="LLVMGetModuleContext", NM="_Z20LLVMGetModuleContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetModuleContext")
//</editor-fold>
public static  LLVMOpaqueContext /*P*/ LLVMGetModuleContext( LLVMOpaqueModule /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain a Type from a module by its registered name.
*/

/**
* Obtain a Type from a module by its registered name.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetTypeByName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 563,
 FQN="LLVMGetTypeByName", NM="_Z17LLVMGetTypeByName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetTypeByName")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMGetTypeByName( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the number of operands for named metadata in a module.
*
* @see llvm::Module::getNamedMetadata()
*/

/**
* Obtain the number of operands for named metadata in a module.
*
* @see llvm::Module::getNamedMetadata()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNamedMetadataNumOperands">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 891,
 FQN="LLVMGetNamedMetadataNumOperands", NM="_Z31LLVMGetNamedMetadataNumOperands",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z31LLVMGetNamedMetadataNumOperands")
//</editor-fold>
public static /*uint*/int LLVMGetNamedMetadataNumOperands( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 898,
 FQN="LLVMGetNamedMetadataOperands", NM="_Z28LLVMGetNamedMetadataOperands",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z28LLVMGetNamedMetadataOperands")
//</editor-fold>
public static void LLVMGetNamedMetadataOperands( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Name, 
                            type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Dest) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Add an operand to named metadata.
*
* @see llvm::Module::getNamedMetadata()
* @see llvm::MDNode::addOperand()
*/

/**
* Add an operand to named metadata.
*
* @see llvm::Module::getNamedMetadata()
* @see llvm::MDNode::addOperand()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMAddNamedMetadataOperand">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 908,
 FQN="LLVMAddNamedMetadataOperand", NM="_Z27LLVMAddNamedMetadataOperand",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMAddNamedMetadataOperand")
//</editor-fold>
public static void LLVMAddNamedMetadataOperand( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Name, 
                            LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Add a function to a module under a specified name.
*
* @see llvm::Function::Create()
*/

/**
* Add a function to a module under a specified name.
*
* @see llvm::Function::Create()
*/

/*--.. Operations on functions .............................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMAddFunction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1746,
 FQN="LLVMAddFunction", NM="_Z15LLVMAddFunction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMAddFunction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMAddFunction( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Name, 
                LLVMOpaqueType /*P*/ FunctionTy) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain a Function value from a Module by its name.
*
* The returned value corresponds to a llvm::Function value.
*
* @see llvm::Module::getFunction()
*/

/**
* Obtain a Function value from a Module by its name.
*
* The returned value corresponds to a llvm::Function value.
*
* @see llvm::Module::getFunction()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNamedFunction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1752,
 FQN="LLVMGetNamedFunction", NM="_Z20LLVMGetNamedFunction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetNamedFunction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetNamedFunction( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain an iterator to the first Function in a Module.
*
* @see llvm::Module::begin()
*/

/**
* Obtain an iterator to the first Function in a Module.
*
* @see llvm::Module::begin()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetFirstFunction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1756,
 FQN="LLVMGetFirstFunction", NM="_Z20LLVMGetFirstFunction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetFirstFunction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetFirstFunction( LLVMOpaqueModule /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain an iterator to the last Function in a Module.
*
* @see llvm::Module::end()
*/

/**
* Obtain an iterator to the last Function in a Module.
*
* @see llvm::Module::end()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetLastFunction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1764,
 FQN="LLVMGetLastFunction", NM="_Z19LLVMGetLastFunction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMGetLastFunction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetLastFunction( LLVMOpaqueModule /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Advance a Function iterator to the next Function.
*
* Returns NULL if the iterator was already at the end and there are no more
* functions.
*/

/**
* Advance a Function iterator to the next Function.
*
* Returns NULL if the iterator was already at the end and there are no more
* functions.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNextFunction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1772,
 FQN="LLVMGetNextFunction", NM="_Z19LLVMGetNextFunction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMGetNextFunction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetNextFunction( LLVMOpaqueValue /*P*/ Fn) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Decrement a Function iterator to the previous Function.
*
* Returns NULL if the iterator was already at the beginning and there are
* no previous functions.
*/

/**
* Decrement a Function iterator to the previous Function.
*
* Returns NULL if the iterator was already at the beginning and there are
* no previous functions.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetPreviousFunction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1780,
 FQN="LLVMGetPreviousFunction", NM="_Z23LLVMGetPreviousFunction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMGetPreviousFunction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetPreviousFunction( LLVMOpaqueValue /*P*/ Fn) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 312,
 FQN="LLVMGetTypeKind", NM="_Z15LLVMGetTypeKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMGetTypeKind")
//</editor-fold>
public static LLVMTypeKind LLVMGetTypeKind( LLVMOpaqueType /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Whether the type has a known size.
*
* Things that don't have a size are abstract types, labels, and void.a
*
* @see llvm::Type::isSized()
*/

/**
* Whether the type has a known size.
*
* Things that don't have a size are abstract types, labels, and void.a
*
* @see llvm::Type::isSized()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMTypeIsSized">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 352,
 FQN="LLVMTypeIsSized", NM="_Z15LLVMTypeIsSized",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMTypeIsSized")
//</editor-fold>
public static int LLVMTypeIsSized( LLVMOpaqueType /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the context to which this type instance is associated.
*
* @see llvm::Type::getContext()
*/

/**
* Obtain the context to which this type instance is associated.
*
* @see llvm::Type::getContext()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetTypeContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 357,
 FQN="LLVMGetTypeContext", NM="_Z18LLVMGetTypeContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetTypeContext")
//</editor-fold>
public static  LLVMOpaqueContext /*P*/ LLVMGetTypeContext( LLVMOpaqueType /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Dump a representation of a type to stderr.
*
* @see llvm::Type::dump()
*/

/**
* Dump a representation of a type to stderr.
*
* @see llvm::Type::dump()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMDumpType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 361,
 FQN="LLVMDumpType", NM="_Z12LLVMDumpType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMDumpType")
//</editor-fold>
public static void LLVMDumpType( LLVMOpaqueType /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Return a string representation of the type. Use
* LLVMDisposeMessage to free the string.
*
* @see llvm::Type::print()
*/

/**
* Return a string representation of the type. Use
* LLVMDisposeMessage to free the string.
*
* @see llvm::Type::print()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMPrintTypeToString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 365,
 FQN="LLVMPrintTypeToString", NM="_Z21LLVMPrintTypeToString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMPrintTypeToString")
//</editor-fold>
public static char$ptr/*char P*/ LLVMPrintTypeToString( LLVMOpaqueType /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 381,
 FQN="LLVMInt1TypeInContext", NM="_Z21LLVMInt1TypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMInt1TypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt1TypeInContext( LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt8TypeInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 384,
 FQN="LLVMInt8TypeInContext", NM="_Z21LLVMInt8TypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMInt8TypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt8TypeInContext( LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt16TypeInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 387,
 FQN="LLVMInt16TypeInContext", NM="_Z22LLVMInt16TypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMInt16TypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt16TypeInContext( LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt32TypeInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 390,
 FQN="LLVMInt32TypeInContext", NM="_Z22LLVMInt32TypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMInt32TypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt32TypeInContext( LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt64TypeInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 393,
 FQN="LLVMInt64TypeInContext", NM="_Z22LLVMInt64TypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMInt64TypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt64TypeInContext( LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt128TypeInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 396,
 FQN="LLVMInt128TypeInContext", NM="_Z23LLVMInt128TypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMInt128TypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt128TypeInContext( LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIntTypeInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 399,
 FQN="LLVMIntTypeInContext", NM="_Z20LLVMIntTypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMIntTypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMIntTypeInContext( LLVMOpaqueContext /*P*/ C, /*uint*/int NumBits) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain an integer type from the global context with a specified bit
* width.
*/

/**
* Obtain an integer type from the global context with a specified bit
* width.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMInt1Type">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 403,
 FQN="LLVMInt1Type", NM="_Z12LLVMInt1Type",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMInt1Type")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt1Type() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt8Type">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 406,
 FQN="LLVMInt8Type", NM="_Z12LLVMInt8Type",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMInt8Type")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt8Type() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt16Type">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 409,
 FQN="LLVMInt16Type", NM="_Z13LLVMInt16Type",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMInt16Type")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt16Type() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt32Type">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 412,
 FQN="LLVMInt32Type", NM="_Z13LLVMInt32Type",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMInt32Type")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt32Type() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt64Type">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 415,
 FQN="LLVMInt64Type", NM="_Z13LLVMInt64Type",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMInt64Type")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt64Type() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMInt128Type">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 418,
 FQN="LLVMInt128Type", NM="_Z14LLVMInt128Type",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMInt128Type")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMInt128Type() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIntType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 421,
 FQN="LLVMIntType", NM="_Z11LLVMIntType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z11LLVMIntType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMIntType(/*uint*/int NumBits) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetIntTypeWidth">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 425,
 FQN="LLVMGetIntTypeWidth", NM="_Z19LLVMGetIntTypeWidth",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMGetIntTypeWidth")
//</editor-fold>
public static /*uint*/int LLVMGetIntTypeWidth( LLVMOpaqueType /*P*/ IntegerTy) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 431,
 FQN="LLVMHalfTypeInContext", NM="_Z21LLVMHalfTypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMHalfTypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMHalfTypeInContext( LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain a 32-bit floating point type from a context.
*/

/**
* Obtain a 32-bit floating point type from a context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMFloatTypeInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 434,
 FQN="LLVMFloatTypeInContext", NM="_Z22LLVMFloatTypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMFloatTypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMFloatTypeInContext( LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain a 64-bit floating point type from a context.
*/

/**
* Obtain a 64-bit floating point type from a context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMDoubleTypeInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 437,
 FQN="LLVMDoubleTypeInContext", NM="_Z23LLVMDoubleTypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMDoubleTypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMDoubleTypeInContext( LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain a 80-bit floating point type (X87) from a context.
*/

/**
* Obtain a 80-bit floating point type (X87) from a context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMX86FP80TypeInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 440,
 FQN="LLVMX86FP80TypeInContext", NM="_Z24LLVMX86FP80TypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMX86FP80TypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMX86FP80TypeInContext( LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain a 128-bit floating point type (112-bit mantissa) from a
* context.
*/

/**
* Obtain a 128-bit floating point type (112-bit mantissa) from a
* context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMFP128TypeInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 443,
 FQN="LLVMFP128TypeInContext", NM="_Z22LLVMFP128TypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMFP128TypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMFP128TypeInContext( LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain a 128-bit floating point type (two 64-bits) from a context.
*/

/**
* Obtain a 128-bit floating point type (two 64-bits) from a context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMPPCFP128TypeInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 446,
 FQN="LLVMPPCFP128TypeInContext", NM="_Z25LLVMPPCFP128TypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMPPCFP128TypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMPPCFP128TypeInContext( LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain a floating point type from the global context.
*
* These map to the functions in this group of the same name.
*/

/**
* Obtain a floating point type from the global context.
*
* These map to the functions in this group of the same name.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMHalfType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 456,
 FQN="LLVMHalfType", NM="_Z12LLVMHalfType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMHalfType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMHalfType() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMFloatType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 459,
 FQN="LLVMFloatType", NM="_Z13LLVMFloatType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMFloatType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMFloatType() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMDoubleType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 462,
 FQN="LLVMDoubleType", NM="_Z14LLVMDoubleType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMDoubleType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMDoubleType() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMX86FP80Type">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 465,
 FQN="LLVMX86FP80Type", NM="_Z15LLVMX86FP80Type",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMX86FP80Type")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMX86FP80Type() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMFP128Type">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 468,
 FQN="LLVMFP128Type", NM="_Z13LLVMFP128Type",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMFP128Type")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMFP128Type() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMPPCFP128Type">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 471,
 FQN="LLVMPPCFP128Type", NM="_Z16LLVMPPCFP128Type",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMPPCFP128Type")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMPPCFP128Type() {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 480,
 FQN="LLVMFunctionType", NM="_Z16LLVMFunctionType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMFunctionType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMFunctionType( LLVMOpaqueType /*P*/ ReturnType, 
                type$ptr<LLVMOpaqueType /*P*/ /*P*/> ParamTypes, /*uint*/int ParamCount, 
                int IsVarArg) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Returns whether a function type is variadic.
*/

/**
* Returns whether a function type is variadic.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsFunctionVarArg">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 487,
 FQN="LLVMIsFunctionVarArg", NM="_Z20LLVMIsFunctionVarArg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMIsFunctionVarArg")
//</editor-fold>
public static int LLVMIsFunctionVarArg( LLVMOpaqueType /*P*/ FunctionTy) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the Type this function Type returns.
*/

/**
* Obtain the Type this function Type returns.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetReturnType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 491,
 FQN="LLVMGetReturnType", NM="_Z17LLVMGetReturnType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetReturnType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMGetReturnType( LLVMOpaqueType /*P*/ FunctionTy) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the number of parameters this function accepts.
*/

/**
* Obtain the number of parameters this function accepts.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMCountParamTypes">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 495,
 FQN="LLVMCountParamTypes", NM="_Z19LLVMCountParamTypes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMCountParamTypes")
//</editor-fold>
public static /*uint*/int LLVMCountParamTypes( LLVMOpaqueType /*P*/ FunctionTy) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 499,
 FQN="LLVMGetParamTypes", NM="_Z17LLVMGetParamTypes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetParamTypes")
//</editor-fold>
public static void LLVMGetParamTypes( LLVMOpaqueType /*P*/ FunctionTy, type$ptr<LLVMOpaqueType /*P*/ /*P*/> Dest) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 508,
 FQN="LLVMStructTypeInContext", NM="_Z23LLVMStructTypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMStructTypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMStructTypeInContext( LLVMOpaqueContext /*P*/ C, type$ptr<LLVMOpaqueType /*P*/ /*P*/> ElementTypes, 
                       /*uint*/int ElementCount, int Packed) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Create a new structure type in the global context.
*
* @see llvm::StructType::create()
*/

/**
* Create a new structure type in the global context.
*
* @see llvm::StructType::create()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMStructType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 514,
 FQN="LLVMStructType", NM="_Z14LLVMStructType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMStructType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMStructType(type$ptr<LLVMOpaqueType /*P*/ /*P*/> ElementTypes, 
              /*uint*/int ElementCount, int Packed) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Create an empty structure in a context having a specified name.
*
* @see llvm::StructType::create()
*/

/**
* Create an empty structure in a context having a specified name.
*
* @see llvm::StructType::create()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMStructCreateNamed">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 520,
 FQN="LLVMStructCreateNamed", NM="_Z21LLVMStructCreateNamed",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMStructCreateNamed")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMStructCreateNamed( LLVMOpaqueContext /*P*/ C, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the name of a structure.
*
* @see llvm::StructType::getName()
*/

/**
* Obtain the name of a structure.
*
* @see llvm::StructType::getName()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetStructName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 525,
 FQN="LLVMGetStructName", NM="_Z17LLVMGetStructName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetStructName")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetStructName( LLVMOpaqueType /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set the contents of a structure type.
*
* @see llvm::StructType::setBody()
*/

/**
* Set the contents of a structure type.
*
* @see llvm::StructType::setBody()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMStructSetBody">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 533,
 FQN="LLVMStructSetBody", NM="_Z17LLVMStructSetBody",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMStructSetBody")
//</editor-fold>
public static void LLVMStructSetBody( LLVMOpaqueType /*P*/ StructTy, type$ptr<LLVMOpaqueType /*P*/ /*P*/> ElementTypes, 
                 /*uint*/int ElementCount, int Packed) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Get the number of elements defined inside the structure.
*
* @see llvm::StructType::getNumElements()
*/

/**
* Get the number of elements defined inside the structure.
*
* @see llvm::StructType::getNumElements()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMCountStructElementTypes">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 539,
 FQN="LLVMCountStructElementTypes", NM="_Z27LLVMCountStructElementTypes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMCountStructElementTypes")
//</editor-fold>
public static /*uint*/int LLVMCountStructElementTypes( LLVMOpaqueType /*P*/ StructTy) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 543,
 FQN="LLVMGetStructElementTypes", NM="_Z25LLVMGetStructElementTypes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMGetStructElementTypes")
//</editor-fold>
public static void LLVMGetStructElementTypes( LLVMOpaqueType /*P*/ StructTy, type$ptr<LLVMOpaqueType /*P*/ /*P*/> Dest) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Get the type of the element at a given index in the structure.
*
* @see llvm::StructType::getTypeAtIndex()
*/

/**
* Get the type of the element at a given index in the structure.
*
* @see llvm::StructType::getTypeAtIndex()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMStructGetTypeAtIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 550,
 FQN="LLVMStructGetTypeAtIndex", NM="_Z24LLVMStructGetTypeAtIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMStructGetTypeAtIndex")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMStructGetTypeAtIndex( LLVMOpaqueType /*P*/ StructTy, /*uint*/int i) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Determine whether a structure is packed.
*
* @see llvm::StructType::isPacked()
*/

/**
* Determine whether a structure is packed.
*
* @see llvm::StructType::isPacked()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsPackedStruct">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 555,
 FQN="LLVMIsPackedStruct", NM="_Z18LLVMIsPackedStruct",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMIsPackedStruct")
//</editor-fold>
public static int LLVMIsPackedStruct( LLVMOpaqueType /*P*/ StructTy) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Determine whether a structure is opaque.
*
* @see llvm::StructType::isOpaque()
*/

/**
* Determine whether a structure is opaque.
*
* @see llvm::StructType::isOpaque()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsOpaqueStruct">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 559,
 FQN="LLVMIsOpaqueStruct", NM="_Z18LLVMIsOpaqueStruct",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMIsOpaqueStruct")
//</editor-fold>
public static int LLVMIsOpaqueStruct( LLVMOpaqueType /*P*/ StructTy) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 581,
 FQN="LLVMGetElementType", NM="_Z18LLVMGetElementType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetElementType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMGetElementType( LLVMOpaqueType /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Create a fixed size array type that refers to a specific type.
*
* The created type will exist in the context that its element type
* exists in.
*
* @see llvm::ArrayType::get()
*/

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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 569,
 FQN="LLVMArrayType", NM="_Z13LLVMArrayType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMArrayType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMArrayType( LLVMOpaqueType /*P*/ ElementType, /*uint*/int ElementCount) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the length of an array type.
*
* This only works on types that represent arrays.
*
* @see llvm::ArrayType::getNumElements()
*/

/**
* Obtain the length of an array type.
*
* This only works on types that represent arrays.
*
* @see llvm::ArrayType::getNumElements()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetArrayLength">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 585,
 FQN="LLVMGetArrayLength", NM="_Z18LLVMGetArrayLength",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetArrayLength")
//</editor-fold>
public static /*uint*/int LLVMGetArrayLength( LLVMOpaqueType /*P*/ ArrayTy) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Create a pointer type that points to a defined type.
*
* The created type will exist in the context that its pointee type
* exists in.
*
* @see llvm::PointerType::get()
*/

/**
* Create a pointer type that points to a defined type.
*
* The created type will exist in the context that its pointee type
* exists in.
*
* @see llvm::PointerType::get()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMPointerType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 573,
 FQN="LLVMPointerType", NM="_Z15LLVMPointerType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMPointerType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMPointerType( LLVMOpaqueType /*P*/ ElementType, /*uint*/int AddressSpace) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the address space of a pointer type.
*
* This only works on types that represent pointers.
*
* @see llvm::PointerType::getAddressSpace()
*/

/**
* Obtain the address space of a pointer type.
*
* This only works on types that represent pointers.
*
* @see llvm::PointerType::getAddressSpace()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetPointerAddressSpace">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 589,
 FQN="LLVMGetPointerAddressSpace", NM="_Z26LLVMGetPointerAddressSpace",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMGetPointerAddressSpace")
//</editor-fold>
public static /*uint*/int LLVMGetPointerAddressSpace( LLVMOpaqueType /*P*/ PointerTy) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 577,
 FQN="LLVMVectorType", NM="_Z14LLVMVectorType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMVectorType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMVectorType( LLVMOpaqueType /*P*/ ElementType, /*uint*/int ElementCount) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the number of elements in a vector type.
*
* This only works on types that represent vectors.
*
* @see llvm::VectorType::getNumElements()
*/

/**
* Obtain the number of elements in a vector type.
*
* This only works on types that represent vectors.
*
* @see llvm::VectorType::getNumElements()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetVectorSize">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 593,
 FQN="LLVMGetVectorSize", NM="_Z17LLVMGetVectorSize",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetVectorSize")
//</editor-fold>
public static /*uint*/int LLVMGetVectorSize( LLVMOpaqueType /*P*/ VectorTy) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 599,
 FQN="LLVMVoidTypeInContext", NM="_Z21LLVMVoidTypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMVoidTypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMVoidTypeInContext( LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Create a label type in a context.
*/

/**
* Create a label type in a context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMLabelTypeInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 602,
 FQN="LLVMLabelTypeInContext", NM="_Z22LLVMLabelTypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMLabelTypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMLabelTypeInContext( LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Create a X86 MMX type in a context.
*/

/**
* Create a X86 MMX type in a context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMX86MMXTypeInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 449,
 FQN="LLVMX86MMXTypeInContext", NM="_Z23LLVMX86MMXTypeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMX86MMXTypeInContext")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMX86MMXTypeInContext( LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* These are similar to the above functions except they operate on the
* global context.
*/

/**
* These are similar to the above functions except they operate on the
* global context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMVoidType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 606,
 FQN="LLVMVoidType", NM="_Z12LLVMVoidType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMVoidType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMVoidType() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMLabelType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 609,
 FQN="LLVMLabelType", NM="_Z13LLVMLabelType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMLabelType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMLabelType() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMX86MMXType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 474,
 FQN="LLVMX86MMXType", NM="_Z14LLVMX86MMXType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMX86MMXType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMX86MMXType() {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 617,
 FQN="LLVMTypeOf", NM="_Z10LLVMTypeOf",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z10LLVMTypeOf")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMTypeOf( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the enumerated type of a Value instance.
*
* @see llvm::Value::getValueID()
*/

/**
* Obtain the enumerated type of a Value instance.
*
* @see llvm::Value::getValueID()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetValueKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 621,
 FQN="LLVMGetValueKind", NM="_Z16LLVMGetValueKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMGetValueKind")
//</editor-fold>
public static LLVMValueKind LLVMGetValueKind( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the string name of a value.
*
* @see llvm::Value::getName()
*/

/**
* Obtain the string name of a value.
*
* @see llvm::Value::getName()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetValueName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 632,
 FQN="LLVMGetValueName", NM="_Z16LLVMGetValueName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMGetValueName")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetValueName( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set the string name of a value.
*
* @see llvm::Value::setName()
*/

/**
* Set the string name of a value.
*
* @see llvm::Value::setName()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetValueName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 636,
 FQN="LLVMSetValueName", NM="_Z16LLVMSetValueName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMSetValueName")
//</editor-fold>
public static void LLVMSetValueName( LLVMOpaqueValue /*P*/ Val, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Dump a representation of a value to stderr.
*
* @see llvm::Value::dump()
*/

/**
* Dump a representation of a value to stderr.
*
* @see llvm::Value::dump()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMDumpValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 640,
 FQN="LLVMDumpValue", NM="_Z13LLVMDumpValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMDumpValue")
//</editor-fold>
public static void LLVMDumpValue( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Return a string representation of the value. Use
* LLVMDisposeMessage to free the string.
*
* @see llvm::Value::print()
*/

/**
* Return a string representation of the value. Use
* LLVMDisposeMessage to free the string.
*
* @see llvm::Value::print()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMPrintValueToString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 644,
 FQN="LLVMPrintValueToString", NM="_Z22LLVMPrintValueToString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMPrintValueToString")
//</editor-fold>
public static char$ptr/*char P*/ LLVMPrintValueToString( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Replace all uses of a value with another one.
*
* @see llvm::Value::replaceAllUsesWith()
*/

/**
* Replace all uses of a value with another one.
*
* @see llvm::Value::replaceAllUsesWith()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMReplaceAllUsesWith">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 658,
 FQN="LLVMReplaceAllUsesWith", NM="_Z22LLVMReplaceAllUsesWith",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMReplaceAllUsesWith")
//</editor-fold>
public static void LLVMReplaceAllUsesWith( LLVMOpaqueValue /*P*/ OldVal,  LLVMOpaqueValue /*P*/ NewVal) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Determine whether the specified value instance is constant.
*/

/**
* Determine whether the specified value instance is constant.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsConstant">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 799,
 FQN="LLVMIsConstant", NM="_Z14LLVMIsConstant",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMIsConstant")
//</editor-fold>
public static int LLVMIsConstant( LLVMOpaqueValue /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Determine whether a value instance is undefined.
*/

/**
* Determine whether a value instance is undefined.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsUndef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 809,
 FQN="LLVMIsUndef", NM="_Z11LLVMIsUndef",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z11LLVMIsUndef")
//</editor-fold>
public static int LLVMIsUndef( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAArgument">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAArgument", NM="_Z15LLVMIsAArgument",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsAArgument")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAArgument( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsABasicBlock">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsABasicBlock", NM="_Z17LLVMIsABasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsABasicBlock")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsABasicBlock( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAInlineAsm">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAInlineAsm", NM="_Z16LLVMIsAInlineAsm",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMIsAInlineAsm")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAInlineAsm( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAUser">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAUser", NM="_Z11LLVMIsAUser",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z11LLVMIsAUser")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAUser( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstant">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstant", NM="_Z15LLVMIsAConstant",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsAConstant")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstant( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsABlockAddress">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsABlockAddress", NM="_Z19LLVMIsABlockAddress",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMIsABlockAddress")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsABlockAddress( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantAggregateZero">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantAggregateZero", NM="_Z28LLVMIsAConstantAggregateZero",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z28LLVMIsAConstantAggregateZero")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantAggregateZero( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantArray">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantArray", NM="_Z20LLVMIsAConstantArray",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMIsAConstantArray")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantArray( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantDataSequential">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantDataSequential", NM="_Z29LLVMIsAConstantDataSequential",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMIsAConstantDataSequential")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantDataSequential( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantDataArray">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantDataArray", NM="_Z24LLVMIsAConstantDataArray",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMIsAConstantDataArray")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantDataArray( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantDataVector">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantDataVector", NM="_Z25LLVMIsAConstantDataVector",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMIsAConstantDataVector")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantDataVector( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantExpr", NM="_Z19LLVMIsAConstantExpr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMIsAConstantExpr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantExpr( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantFP">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantFP", NM="_Z17LLVMIsAConstantFP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAConstantFP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantFP( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantInt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantInt", NM="_Z18LLVMIsAConstantInt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMIsAConstantInt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantInt( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantPointerNull">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantPointerNull", NM="_Z26LLVMIsAConstantPointerNull",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMIsAConstantPointerNull")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantPointerNull( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantStruct">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantStruct", NM="_Z21LLVMIsAConstantStruct",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsAConstantStruct")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantStruct( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantTokenNone">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantTokenNone", NM="_Z24LLVMIsAConstantTokenNone",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMIsAConstantTokenNone")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantTokenNone( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAConstantVector">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAConstantVector", NM="_Z21LLVMIsAConstantVector",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsAConstantVector")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAConstantVector( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAGlobalValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAGlobalValue", NM="_Z18LLVMIsAGlobalValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMIsAGlobalValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAGlobalValue( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAGlobalAlias">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAGlobalAlias", NM="_Z18LLVMIsAGlobalAlias",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMIsAGlobalAlias")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAGlobalAlias( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAGlobalObject">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAGlobalObject", NM="_Z19LLVMIsAGlobalObject",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMIsAGlobalObject")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAGlobalObject( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAFunction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAFunction", NM="_Z15LLVMIsAFunction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsAFunction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAFunction( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAGlobalVariable">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAGlobalVariable", NM="_Z21LLVMIsAGlobalVariable",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsAGlobalVariable")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAGlobalVariable( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAUndefValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAUndefValue", NM="_Z17LLVMIsAUndefValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAUndefValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAUndefValue( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAInstruction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAInstruction", NM="_Z18LLVMIsAInstruction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMIsAInstruction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAInstruction( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsABinaryOperator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsABinaryOperator", NM="_Z21LLVMIsABinaryOperator",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsABinaryOperator")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsABinaryOperator( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsACallInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsACallInst", NM="_Z15LLVMIsACallInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsACallInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsACallInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAIntrinsicInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAIntrinsicInst", NM="_Z20LLVMIsAIntrinsicInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMIsAIntrinsicInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAIntrinsicInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsADbgInfoIntrinsic">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsADbgInfoIntrinsic", NM="_Z23LLVMIsADbgInfoIntrinsic",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMIsADbgInfoIntrinsic")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsADbgInfoIntrinsic( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsADbgDeclareInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsADbgDeclareInst", NM="_Z21LLVMIsADbgDeclareInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsADbgDeclareInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsADbgDeclareInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAMemIntrinsic">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAMemIntrinsic", NM="_Z19LLVMIsAMemIntrinsic",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMIsAMemIntrinsic")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAMemIntrinsic( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAMemCpyInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAMemCpyInst", NM="_Z17LLVMIsAMemCpyInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAMemCpyInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAMemCpyInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAMemMoveInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAMemMoveInst", NM="_Z18LLVMIsAMemMoveInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMIsAMemMoveInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAMemMoveInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAMemSetInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAMemSetInst", NM="_Z17LLVMIsAMemSetInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAMemSetInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAMemSetInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsACmpInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsACmpInst", NM="_Z14LLVMIsACmpInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMIsACmpInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsACmpInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAFCmpInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAFCmpInst", NM="_Z15LLVMIsAFCmpInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsAFCmpInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAFCmpInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAICmpInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAICmpInst", NM="_Z15LLVMIsAICmpInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsAICmpInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAICmpInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAExtractElementInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAExtractElementInst", NM="_Z25LLVMIsAExtractElementInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMIsAExtractElementInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAExtractElementInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAGetElementPtrInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAGetElementPtrInst", NM="_Z24LLVMIsAGetElementPtrInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMIsAGetElementPtrInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAGetElementPtrInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAInsertElementInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAInsertElementInst", NM="_Z24LLVMIsAInsertElementInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMIsAInsertElementInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAInsertElementInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAInsertValueInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAInsertValueInst", NM="_Z22LLVMIsAInsertValueInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMIsAInsertValueInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAInsertValueInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsALandingPadInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsALandingPadInst", NM="_Z21LLVMIsALandingPadInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsALandingPadInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsALandingPadInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAPHINode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAPHINode", NM="_Z14LLVMIsAPHINode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMIsAPHINode")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAPHINode( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsASelectInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsASelectInst", NM="_Z17LLVMIsASelectInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsASelectInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsASelectInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAShuffleVectorInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAShuffleVectorInst", NM="_Z24LLVMIsAShuffleVectorInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMIsAShuffleVectorInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAShuffleVectorInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAStoreInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAStoreInst", NM="_Z16LLVMIsAStoreInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMIsAStoreInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAStoreInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsATerminatorInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsATerminatorInst", NM="_Z21LLVMIsATerminatorInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsATerminatorInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsATerminatorInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsABranchInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsABranchInst", NM="_Z17LLVMIsABranchInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsABranchInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsABranchInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAIndirectBrInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAIndirectBrInst", NM="_Z21LLVMIsAIndirectBrInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsAIndirectBrInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAIndirectBrInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAInvokeInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAInvokeInst", NM="_Z17LLVMIsAInvokeInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAInvokeInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAInvokeInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAReturnInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAReturnInst", NM="_Z17LLVMIsAReturnInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAReturnInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAReturnInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsASwitchInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsASwitchInst", NM="_Z17LLVMIsASwitchInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsASwitchInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsASwitchInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAUnreachableInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAUnreachableInst", NM="_Z22LLVMIsAUnreachableInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMIsAUnreachableInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAUnreachableInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAResumeInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAResumeInst", NM="_Z17LLVMIsAResumeInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAResumeInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAResumeInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsACleanupReturnInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsACleanupReturnInst", NM="_Z24LLVMIsACleanupReturnInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMIsACleanupReturnInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsACleanupReturnInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsACatchReturnInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsACatchReturnInst", NM="_Z22LLVMIsACatchReturnInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMIsACatchReturnInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsACatchReturnInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAFuncletPadInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAFuncletPadInst", NM="_Z21LLVMIsAFuncletPadInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsAFuncletPadInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAFuncletPadInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsACatchPadInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsACatchPadInst", NM="_Z19LLVMIsACatchPadInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMIsACatchPadInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsACatchPadInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsACleanupPadInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsACleanupPadInst", NM="_Z21LLVMIsACleanupPadInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMIsACleanupPadInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsACleanupPadInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAUnaryInstruction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAUnaryInstruction", NM="_Z23LLVMIsAUnaryInstruction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMIsAUnaryInstruction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAUnaryInstruction( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAAllocaInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAAllocaInst", NM="_Z17LLVMIsAAllocaInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAAllocaInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAAllocaInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsACastInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsACastInst", NM="_Z15LLVMIsACastInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsACastInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsACastInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAAddrSpaceCastInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAAddrSpaceCastInst", NM="_Z24LLVMIsAAddrSpaceCastInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMIsAAddrSpaceCastInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAAddrSpaceCastInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsABitCastInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsABitCastInst", NM="_Z18LLVMIsABitCastInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMIsABitCastInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsABitCastInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAFPExtInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAFPExtInst", NM="_Z16LLVMIsAFPExtInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMIsAFPExtInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAFPExtInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAFPToSIInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAFPToSIInst", NM="_Z17LLVMIsAFPToSIInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAFPToSIInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAFPToSIInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAFPToUIInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAFPToUIInst", NM="_Z17LLVMIsAFPToUIInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAFPToUIInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAFPToUIInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAFPTruncInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAFPTruncInst", NM="_Z18LLVMIsAFPTruncInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMIsAFPTruncInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAFPTruncInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAIntToPtrInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAIntToPtrInst", NM="_Z19LLVMIsAIntToPtrInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMIsAIntToPtrInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAIntToPtrInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAPtrToIntInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAPtrToIntInst", NM="_Z19LLVMIsAPtrToIntInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMIsAPtrToIntInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAPtrToIntInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsASExtInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsASExtInst", NM="_Z15LLVMIsASExtInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsASExtInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsASExtInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsASIToFPInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsASIToFPInst", NM="_Z17LLVMIsASIToFPInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsASIToFPInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsASIToFPInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsATruncInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsATruncInst", NM="_Z16LLVMIsATruncInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMIsATruncInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsATruncInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAUIToFPInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAUIToFPInst", NM="_Z17LLVMIsAUIToFPInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsAUIToFPInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAUIToFPInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAZExtInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAZExtInst", NM="_Z15LLVMIsAZExtInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsAZExtInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAZExtInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAExtractValueInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAExtractValueInst", NM="_Z23LLVMIsAExtractValueInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMIsAExtractValueInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAExtractValueInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsALoadInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsALoadInst", NM="_Z15LLVMIsALoadInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsALoadInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsALoadInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAVAArgInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 701,
 FQN="LLVMIsAVAArgInst", NM="_Z16LLVMIsAVAArgInst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMIsAVAArgInst")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAVAArgInst( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAMDNode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 703,
 FQN="LLVMIsAMDNode", NM="_Z13LLVMIsAMDNode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMIsAMDNode")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAMDNode( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAMDString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 711,
 FQN="LLVMIsAMDString", NM="_Z15LLVMIsAMDString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMIsAMDString")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMIsAMDString( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 719,
 FQN="LLVMGetFirstUse", NM="_Z15LLVMGetFirstUse",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMGetFirstUse")
//</editor-fold>
public static  LLVMOpaqueUse /*P*/ LLVMGetFirstUse( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the next use of a value.
*
* This effectively advances the iterator. It returns NULL if you are on
* the final use and no more are available.
*/

/**
* Obtain the next use of a value.
*
* This effectively advances the iterator. It returns NULL if you are on
* the final use and no more are available.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNextUse">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 727,
 FQN="LLVMGetNextUse", NM="_Z14LLVMGetNextUse",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMGetNextUse")
//</editor-fold>
public static  LLVMOpaqueUse /*P*/ LLVMGetNextUse( LLVMOpaqueUse /*P*/ U) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the user value for a user.
*
* The returned value corresponds to a llvm::User type.
*
* @see llvm::Use::getUser()
*/

/**
* Obtain the user value for a user.
*
* The returned value corresponds to a llvm::User type.
*
* @see llvm::Use::getUser()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetUser">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 734,
 FQN="LLVMGetUser", NM="_Z11LLVMGetUser",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z11LLVMGetUser")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetUser( LLVMOpaqueUse /*P*/ U) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the value this use corresponds to.
*
* @see llvm::Use::get().
*/

/**
* Obtain the value this use corresponds to.
*
* @see llvm::Use::get().
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetUsedValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 738,
 FQN="LLVMGetUsedValue", NM="_Z16LLVMGetUsedValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMGetUsedValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetUsedValue( LLVMOpaqueUse /*P*/ U) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 754,
 FQN="LLVMGetOperand", NM="_Z14LLVMGetOperand",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMGetOperand")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetOperand( LLVMOpaqueValue /*P*/ Val, /*uint*/int Index) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the use of an operand at a specific index in a llvm::User value.
*
* @see llvm::User::getOperandUse()
*/

/**
* Obtain the use of an operand at a specific index in a llvm::User value.
*
* @see llvm::User::getOperandUse()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetOperandUse">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 768,
 FQN="LLVMGetOperandUse", NM="_Z17LLVMGetOperandUse",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetOperandUse")
//</editor-fold>
public static  LLVMOpaqueUse /*P*/ LLVMGetOperandUse( LLVMOpaqueValue /*P*/ Val, /*uint*/int Index) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set an operand at a specific index in a llvm::User value.
*
* @see llvm::User::setOperand()
*/

/**
* Set an operand at a specific index in a llvm::User value.
*
* @see llvm::User::setOperand()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetOperand">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 773,
 FQN="LLVMSetOperand", NM="_Z14LLVMSetOperand",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMSetOperand")
//</editor-fold>
public static void LLVMSetOperand( LLVMOpaqueValue /*P*/ Val, /*uint*/int Index,  LLVMOpaqueValue /*P*/ Op) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the number of operands in a llvm::User value.
*
* @see llvm::User::getNumOperands()
*/

/**
* Obtain the number of operands in a llvm::User value.
*
* @see llvm::User::getNumOperands()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNumOperands">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 777,
 FQN="LLVMGetNumOperands", NM="_Z18LLVMGetNumOperands",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetNumOperands")
//</editor-fold>
public static int LLVMGetNumOperands( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 787,
 FQN="LLVMConstNull", NM="_Z13LLVMConstNull",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstNull")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNull( LLVMOpaqueType /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 791,
 FQN="LLVMConstAllOnes", NM="_Z16LLVMConstAllOnes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMConstAllOnes")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstAllOnes( LLVMOpaqueType /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain a constant value referring to an undefined value of a type.
*
* @see llvm::UndefValue::get()
*/

/**
* Obtain a constant value referring to an undefined value of a type.
*
* @see llvm::UndefValue::get()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetUndef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 795,
 FQN="LLVMGetUndef", NM="_Z12LLVMGetUndef",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMGetUndef")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetUndef( LLVMOpaqueType /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Determine whether a value instance is null.
*
* @see llvm::Constant::isNullValue()
*/

/**
* Determine whether a value instance is null.
*
* @see llvm::Constant::isNullValue()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsNull">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 803,
 FQN="LLVMIsNull", NM="_Z10LLVMIsNull",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z10LLVMIsNull")
//</editor-fold>
public static int LLVMIsNull( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain a constant that is a constant pointer pointing to NULL for a
* specified type.
*/

/**
* Obtain a constant that is a constant pointer pointing to NULL for a
* specified type.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstPointerNull">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 813,
 FQN="LLVMConstPointerNull", NM="_Z20LLVMConstPointerNull",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMConstPointerNull")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstPointerNull( LLVMOpaqueType /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 920,
 FQN="LLVMConstInt", NM="_Z12LLVMConstInt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstInt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstInt( LLVMOpaqueType /*P*/ IntTy, /*ullong*/long N, 
            int SignExtend) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain a constant value for an integer of arbitrary precision.
*
* @see llvm::ConstantInt::get()
*/

/**
* Obtain a constant value for an integer of arbitrary precision.
*
* @see llvm::ConstantInt::get()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstIntOfArbitraryPrecision">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 925,
 FQN="LLVMConstIntOfArbitraryPrecision", NM="_Z32LLVMConstIntOfArbitraryPrecision",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z32LLVMConstIntOfArbitraryPrecision")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstIntOfArbitraryPrecision( LLVMOpaqueType /*P*/ IntTy, 
                                /*uint*/int NumWords, 
                                /*const*/long/*uint64_t*/ Words[]) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 934,
 FQN="LLVMConstIntOfString", NM="_Z20LLVMConstIntOfString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMConstIntOfString")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstIntOfString( LLVMOpaqueType /*P*/ IntTy, /*const*//*char*/byte Str[], 
                    byte/*uint8_t*/ Radix) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain a constant value for an integer parsed from a string with
* specified length.
*
* @see llvm::ConstantInt::get()
*/

/**
* Obtain a constant value for an integer parsed from a string with
* specified length.
*
* @see llvm::ConstantInt::get()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstIntOfStringAndSize">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 940,
 FQN="LLVMConstIntOfStringAndSize", NM="_Z27LLVMConstIntOfStringAndSize",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMConstIntOfStringAndSize")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstIntOfStringAndSize( LLVMOpaqueType /*P*/ IntTy, /*const*//*char*/byte Str[], 
                           /*uint*/int SLen, byte/*uint8_t*/ Radix) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain a constant value referring to a double floating point value.
*/

/**
* Obtain a constant value referring to a double floating point value.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstReal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 946,
 FQN="LLVMConstReal", NM="_Z13LLVMConstReal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstReal")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstReal( LLVMOpaqueType /*P*/ RealTy, double N) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain a constant for a floating point value parsed from a string.
*
* A similar API, LLVMConstRealOfStringAndSize is also available. It
* should be used if the input string's length is known.
*/

/**
* Obtain a constant for a floating point value parsed from a string.
*
* A similar API, LLVMConstRealOfStringAndSize is also available. It
* should be used if the input string's length is known.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstRealOfString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 950,
 FQN="LLVMConstRealOfString", NM="_Z21LLVMConstRealOfString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMConstRealOfString")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstRealOfString( LLVMOpaqueType /*P*/ RealTy, /*const*/char$ptr/*char P*/ Text) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain a constant for a floating point value parsed from a string.
*/

/**
* Obtain a constant for a floating point value parsed from a string.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstRealOfStringAndSize">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 954,
 FQN="LLVMConstRealOfStringAndSize", NM="_Z28LLVMConstRealOfStringAndSize",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z28LLVMConstRealOfStringAndSize")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstRealOfStringAndSize( LLVMOpaqueType /*P*/ RealTy, /*const*//*char*/byte Str[], 
                            /*uint*/int SLen) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the zero extended value for an integer constant value.
*
* @see llvm::ConstantInt::getZExtValue()
*/

/**
* Obtain the zero extended value for an integer constant value.
*
* @see llvm::ConstantInt::getZExtValue()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstIntGetZExtValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 959,
 FQN="LLVMConstIntGetZExtValue", NM="_Z24LLVMConstIntGetZExtValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMConstIntGetZExtValue")
//</editor-fold>
public static /*ullong*/long LLVMConstIntGetZExtValue( LLVMOpaqueValue /*P*/ ConstantVal) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the sign extended value for an integer constant value.
*
* @see llvm::ConstantInt::getSExtValue()
*/

/**
* Obtain the sign extended value for an integer constant value.
*
* @see llvm::ConstantInt::getSExtValue()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstIntGetSExtValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 963,
 FQN="LLVMConstIntGetSExtValue", NM="_Z24LLVMConstIntGetSExtValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMConstIntGetSExtValue")
//</editor-fold>
public static /*llong*/long LLVMConstIntGetSExtValue( LLVMOpaqueValue /*P*/ ConstantVal) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the double value for an floating point constant value.
* losesInfo indicates if some precision was lost in the conversion.
*
* @see llvm::ConstantFP::getDoubleValue
*/

/**
* Obtain the double value for an floating point constant value.
* losesInfo indicates if some precision was lost in the conversion.
*
* @see llvm::ConstantFP::getDoubleValue
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstRealGetDouble">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 967,
 FQN="LLVMConstRealGetDouble", NM="_Z22LLVMConstRealGetDouble",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMConstRealGetDouble")
//</editor-fold>
public static double LLVMConstRealGetDouble( LLVMOpaqueValue /*P*/ ConstantVal, int$ptr/*int P*/ LosesInfo) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 990,
 FQN="LLVMConstStringInContext", NM="_Z24LLVMConstStringInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMConstStringInContext")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstStringInContext( LLVMOpaqueContext /*P*/ C, /*const*/char$ptr/*char P*/ Str, 
                        /*uint*/int Length, 
                        int DontNullTerminate) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 999,
 FQN="LLVMConstString", NM="_Z15LLVMConstString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstString")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstString(/*const*/char$ptr/*char P*/ Str, /*uint*/int Length, 
               int DontNullTerminate) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Returns true if the specified constant is an array of i8.
*
* @see ConstantDataSequential::getAsString()
*/

/**
* Returns true if the specified constant is an array of i8.
*
* @see ConstantDataSequential::getAsString()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsConstantString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1009,
 FQN="LLVMIsConstantString", NM="_Z20LLVMIsConstantString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMIsConstantString")
//</editor-fold>
public static int LLVMIsConstantString( LLVMOpaqueValue /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Get the given constant data sequential as a string.
*
* @see ConstantDataSequential::getAsString()
*/

/**
* Get the given constant data sequential as a string.
*
* @see ConstantDataSequential::getAsString()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetAsString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1013,
 FQN="LLVMGetAsString", NM="_Z15LLVMGetAsString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMGetAsString")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetAsString( LLVMOpaqueValue /*P*/ C, uint$ptr/*size_t P*/ Length) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Create an anonymous ConstantStruct with the specified values.
*
* @see llvm::ConstantStruct::getAnon()
*/

/**
* Create an anonymous ConstantStruct with the specified values.
*
* @see llvm::ConstantStruct::getAnon()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstStructInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1025,
 FQN="LLVMConstStructInContext", NM="_Z24LLVMConstStructInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMConstStructInContext")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstStructInContext( LLVMOpaqueContext /*P*/ C, 
                        type$ptr<LLVMOpaqueValue /*P*/ /*P*/> ConstantVals, 
                        /*uint*/int Count, int Packed) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Create a ConstantStruct in the global Context.
*
* This is the same as LLVMConstStructInContext except it operates on the
* global Context.
*
* @see LLVMConstStructInContext()
*/

/**
* Create a ConstantStruct in the global Context.
*
* This is the same as LLVMConstStructInContext except it operates on the
* global Context.
*
* @see LLVMConstStructInContext()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstStruct">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1033,
 FQN="LLVMConstStruct", NM="_Z15LLVMConstStruct",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstStruct")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstStruct(type$ptr<LLVMOpaqueValue /*P*/ /*P*/> ConstantVals, /*uint*/int Count, 
               int Packed) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Create a ConstantArray from values.
*
* @see llvm::ConstantArray::get()
*/

/**
* Create a ConstantArray from values.
*
* @see llvm::ConstantArray::get()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstArray">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1019,
 FQN="LLVMConstArray", NM="_Z14LLVMConstArray",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMConstArray")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstArray( LLVMOpaqueType /*P*/ ElementTy, 
              type$ptr<LLVMOpaqueValue /*P*/ /*P*/> ConstantVals, /*uint*/int Length) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Create a non-anonymous ConstantStruct from values.
*
* @see llvm::ConstantStruct::get()
*/

/**
* Create a non-anonymous ConstantStruct from values.
*
* @see llvm::ConstantStruct::get()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstNamedStruct">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1039,
 FQN="LLVMConstNamedStruct", NM="_Z20LLVMConstNamedStruct",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMConstNamedStruct")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNamedStruct( LLVMOpaqueType /*P*/ StructTy, 
                    type$ptr<LLVMOpaqueValue /*P*/ /*P*/> ConstantVals, 
                    /*uint*/int Count) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Get an element at specified index as a constant.
*
* @see ConstantDataSequential::getElementAsConstant()
*/

/**
* Get an element at specified index as a constant.
*
* @see ConstantDataSequential::getElementAsConstant()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetElementAsConstant">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1005,
 FQN="LLVMGetElementAsConstant", NM="_Z24LLVMGetElementAsConstant",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMGetElementAsConstant")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetElementAsConstant( LLVMOpaqueValue /*P*/ C, /*uint*/int idx) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Create a ConstantVector from values.
*
* @see llvm::ConstantVector::get()
*/

/**
* Create a ConstantVector from values.
*
* @see llvm::ConstantVector::get()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMConstVector">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1048,
 FQN="LLVMConstVector", NM="_Z15LLVMConstVector",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstVector")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstVector(type$ptr<LLVMOpaqueValue /*P*/ /*P*/> ScalarConstantVals, /*uint*/int Size) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1077,
 FQN="LLVMGetConstOpcode", NM="_Z18LLVMGetConstOpcode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetConstOpcode")
//</editor-fold>
public static LLVMOpcode LLVMGetConstOpcode( LLVMOpaqueValue /*P*/ ConstantVal) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMAlignOf">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1081,
 FQN="LLVMAlignOf", NM="_Z11LLVMAlignOf",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z11LLVMAlignOf")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMAlignOf( LLVMOpaqueType /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSizeOf">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1085,
 FQN="LLVMSizeOf", NM="_Z10LLVMSizeOf",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z10LLVMSizeOf")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMSizeOf( LLVMOpaqueType /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNeg">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1089,
 FQN="LLVMConstNeg", NM="_Z12LLVMConstNeg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstNeg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNeg( LLVMOpaqueValue /*P*/ ConstantVal) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNSWNeg">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1093,
 FQN="LLVMConstNSWNeg", NM="_Z15LLVMConstNSWNeg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstNSWNeg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNSWNeg( LLVMOpaqueValue /*P*/ ConstantVal) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNUWNeg">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1097,
 FQN="LLVMConstNUWNeg", NM="_Z15LLVMConstNUWNeg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstNUWNeg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNUWNeg( LLVMOpaqueValue /*P*/ ConstantVal) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFNeg">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1102,
 FQN="LLVMConstFNeg", NM="_Z13LLVMConstFNeg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstFNeg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFNeg( LLVMOpaqueValue /*P*/ ConstantVal) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNot">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1106,
 FQN="LLVMConstNot", NM="_Z12LLVMConstNot",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstNot")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNot( LLVMOpaqueValue /*P*/ ConstantVal) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstAdd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1110,
 FQN="LLVMConstAdd", NM="_Z12LLVMConstAdd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstAdd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstAdd( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNSWAdd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1115,
 FQN="LLVMConstNSWAdd", NM="_Z15LLVMConstNSWAdd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstNSWAdd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNSWAdd( LLVMOpaqueValue /*P*/ LHSConstant, 
                LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNUWAdd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1121,
 FQN="LLVMConstNUWAdd", NM="_Z15LLVMConstNUWAdd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstNUWAdd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNUWAdd( LLVMOpaqueValue /*P*/ LHSConstant, 
                LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFAdd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1127,
 FQN="LLVMConstFAdd", NM="_Z13LLVMConstFAdd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstFAdd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFAdd( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstSub">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1132,
 FQN="LLVMConstSub", NM="_Z12LLVMConstSub",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstSub")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstSub( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNSWSub">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1137,
 FQN="LLVMConstNSWSub", NM="_Z15LLVMConstNSWSub",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstNSWSub")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNSWSub( LLVMOpaqueValue /*P*/ LHSConstant, 
                LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNUWSub">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1143,
 FQN="LLVMConstNUWSub", NM="_Z15LLVMConstNUWSub",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstNUWSub")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNUWSub( LLVMOpaqueValue /*P*/ LHSConstant, 
                LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFSub">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1149,
 FQN="LLVMConstFSub", NM="_Z13LLVMConstFSub",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstFSub")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFSub( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstMul">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1154,
 FQN="LLVMConstMul", NM="_Z12LLVMConstMul",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstMul")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstMul( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNSWMul">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1159,
 FQN="LLVMConstNSWMul", NM="_Z15LLVMConstNSWMul",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstNSWMul")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNSWMul( LLVMOpaqueValue /*P*/ LHSConstant, 
                LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstNUWMul">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1165,
 FQN="LLVMConstNUWMul", NM="_Z15LLVMConstNUWMul",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstNUWMul")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstNUWMul( LLVMOpaqueValue /*P*/ LHSConstant, 
                LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFMul">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1171,
 FQN="LLVMConstFMul", NM="_Z13LLVMConstFMul",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstFMul")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFMul( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstUDiv">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1176,
 FQN="LLVMConstUDiv", NM="_Z13LLVMConstUDiv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstUDiv")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstUDiv( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstSDiv">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1181,
 FQN="LLVMConstSDiv", NM="_Z13LLVMConstSDiv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstSDiv")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstSDiv( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstExactSDiv">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1186,
 FQN="LLVMConstExactSDiv", NM="_Z18LLVMConstExactSDiv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMConstExactSDiv")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstExactSDiv( LLVMOpaqueValue /*P*/ LHSConstant, 
                   LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFDiv">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1192,
 FQN="LLVMConstFDiv", NM="_Z13LLVMConstFDiv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstFDiv")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFDiv( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstURem">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1197,
 FQN="LLVMConstURem", NM="_Z13LLVMConstURem",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstURem")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstURem( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstSRem">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1202,
 FQN="LLVMConstSRem", NM="_Z13LLVMConstSRem",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstSRem")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstSRem( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFRem">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1207,
 FQN="LLVMConstFRem", NM="_Z13LLVMConstFRem",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstFRem")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFRem( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstAnd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1212,
 FQN="LLVMConstAnd", NM="_Z12LLVMConstAnd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstAnd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstAnd( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstOr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1217,
 FQN="LLVMConstOr", NM="_Z11LLVMConstOr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z11LLVMConstOr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstOr( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstXor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1222,
 FQN="LLVMConstXor", NM="_Z12LLVMConstXor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstXor")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstXor( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstICmp">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1227,
 FQN="LLVMConstICmp", NM="_Z13LLVMConstICmp",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstICmp")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstICmp(LLVMIntPredicate Predicate, 
              LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFCmp">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1234,
 FQN="LLVMConstFCmp", NM="_Z13LLVMConstFCmp",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstFCmp")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFCmp(LLVMRealPredicate Predicate, 
              LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstShl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1241,
 FQN="LLVMConstShl", NM="_Z12LLVMConstShl",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstShl")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstShl( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstLShr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1246,
 FQN="LLVMConstLShr", NM="_Z13LLVMConstLShr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstLShr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstLShr( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstAShr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1251,
 FQN="LLVMConstAShr", NM="_Z13LLVMConstAShr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstAShr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstAShr( LLVMOpaqueValue /*P*/ LHSConstant,  LLVMOpaqueValue /*P*/ RHSConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstGEP">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1256,
 FQN="LLVMConstGEP", NM="_Z12LLVMConstGEP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMConstGEP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstGEP( LLVMOpaqueValue /*P*/ ConstantVal, 
            type$ptr<LLVMOpaqueValue /*P*/ /*P*/> ConstantIndices, /*uint*/int NumIndices) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstInBoundsGEP">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1264,
 FQN="LLVMConstInBoundsGEP", NM="_Z20LLVMConstInBoundsGEP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMConstInBoundsGEP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstInBoundsGEP( LLVMOpaqueValue /*P*/ ConstantVal, 
                    type$ptr<LLVMOpaqueValue /*P*/ /*P*/> ConstantIndices, 
                    /*uint*/int NumIndices) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstTrunc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1273,
 FQN="LLVMConstTrunc", NM="_Z14LLVMConstTrunc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMConstTrunc")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstTrunc( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstSExt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1278,
 FQN="LLVMConstSExt", NM="_Z13LLVMConstSExt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstSExt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstSExt( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstZExt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1283,
 FQN="LLVMConstZExt", NM="_Z13LLVMConstZExt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMConstZExt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstZExt( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFPTrunc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1288,
 FQN="LLVMConstFPTrunc", NM="_Z16LLVMConstFPTrunc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMConstFPTrunc")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFPTrunc( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFPExt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1293,
 FQN="LLVMConstFPExt", NM="_Z14LLVMConstFPExt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMConstFPExt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFPExt( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstUIToFP">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1298,
 FQN="LLVMConstUIToFP", NM="_Z15LLVMConstUIToFP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstUIToFP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstUIToFP( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstSIToFP">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1303,
 FQN="LLVMConstSIToFP", NM="_Z15LLVMConstSIToFP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstSIToFP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstSIToFP( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFPToUI">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1308,
 FQN="LLVMConstFPToUI", NM="_Z15LLVMConstFPToUI",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstFPToUI")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFPToUI( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFPToSI">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1313,
 FQN="LLVMConstFPToSI", NM="_Z15LLVMConstFPToSI",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstFPToSI")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFPToSI( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstPtrToInt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1318,
 FQN="LLVMConstPtrToInt", NM="_Z17LLVMConstPtrToInt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMConstPtrToInt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstPtrToInt( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstIntToPtr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1323,
 FQN="LLVMConstIntToPtr", NM="_Z17LLVMConstIntToPtr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMConstIntToPtr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstIntToPtr( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstBitCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1328,
 FQN="LLVMConstBitCast", NM="_Z16LLVMConstBitCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMConstBitCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstBitCast( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstAddrSpaceCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1333,
 FQN="LLVMConstAddrSpaceCast", NM="_Z22LLVMConstAddrSpaceCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMConstAddrSpaceCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstAddrSpaceCast( LLVMOpaqueValue /*P*/ ConstantVal, 
                       LLVMOpaqueType /*P*/ ToType) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstZExtOrBitCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1339,
 FQN="LLVMConstZExtOrBitCast", NM="_Z22LLVMConstZExtOrBitCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMConstZExtOrBitCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstZExtOrBitCast( LLVMOpaqueValue /*P*/ ConstantVal, 
                       LLVMOpaqueType /*P*/ ToType) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstSExtOrBitCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1345,
 FQN="LLVMConstSExtOrBitCast", NM="_Z22LLVMConstSExtOrBitCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMConstSExtOrBitCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstSExtOrBitCast( LLVMOpaqueValue /*P*/ ConstantVal, 
                       LLVMOpaqueType /*P*/ ToType) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstTruncOrBitCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1351,
 FQN="LLVMConstTruncOrBitCast", NM="_Z23LLVMConstTruncOrBitCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMConstTruncOrBitCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstTruncOrBitCast( LLVMOpaqueValue /*P*/ ConstantVal, 
                        LLVMOpaqueType /*P*/ ToType) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstPointerCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1357,
 FQN="LLVMConstPointerCast", NM="_Z20LLVMConstPointerCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMConstPointerCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstPointerCast( LLVMOpaqueValue /*P*/ ConstantVal, 
                     LLVMOpaqueType /*P*/ ToType) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstIntCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1363,
 FQN="LLVMConstIntCast", NM="_Z16LLVMConstIntCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMConstIntCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstIntCast( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType, 
                int isSigned) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstFPCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1369,
 FQN="LLVMConstFPCast", NM="_Z15LLVMConstFPCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstFPCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstFPCast( LLVMOpaqueValue /*P*/ ConstantVal,  LLVMOpaqueType /*P*/ ToType) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstSelect">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1374,
 FQN="LLVMConstSelect", NM="_Z15LLVMConstSelect",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMConstSelect")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstSelect( LLVMOpaqueValue /*P*/ ConstantCondition, 
                LLVMOpaqueValue /*P*/ ConstantIfTrue, 
                LLVMOpaqueValue /*P*/ ConstantIfFalse) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstExtractElement">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1382,
 FQN="LLVMConstExtractElement", NM="_Z23LLVMConstExtractElement",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMConstExtractElement")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstExtractElement( LLVMOpaqueValue /*P*/ VectorConstant, 
                        LLVMOpaqueValue /*P*/ IndexConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstInsertElement">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1388,
 FQN="LLVMConstInsertElement", NM="_Z22LLVMConstInsertElement",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMConstInsertElement")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstInsertElement( LLVMOpaqueValue /*P*/ VectorConstant, 
                       LLVMOpaqueValue /*P*/ ElementValueConstant, 
                       LLVMOpaqueValue /*P*/ IndexConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstShuffleVector">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1396,
 FQN="LLVMConstShuffleVector", NM="_Z22LLVMConstShuffleVector",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMConstShuffleVector")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstShuffleVector( LLVMOpaqueValue /*P*/ VectorAConstant, 
                       LLVMOpaqueValue /*P*/ VectorBConstant, 
                       LLVMOpaqueValue /*P*/ MaskConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstExtractValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1404,
 FQN="LLVMConstExtractValue", NM="_Z21LLVMConstExtractValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMConstExtractValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstExtractValue( LLVMOpaqueValue /*P*/ AggConstant, uint$ptr/*uint P*/ IdxList, 
                     /*uint*/int NumIdx) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstInsertValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1410,
 FQN="LLVMConstInsertValue", NM="_Z20LLVMConstInsertValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMConstInsertValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstInsertValue( LLVMOpaqueValue /*P*/ AggConstant, 
                     LLVMOpaqueValue /*P*/ ElementValueConstant, 
                    uint$ptr/*uint P*/ IdxList, /*uint*/int NumIdx) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMConstInlineAsm">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1418,
 FQN="LLVMConstInlineAsm", NM="_Z18LLVMConstInlineAsm",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMConstInlineAsm")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMConstInlineAsm( LLVMOpaqueType /*P*/ Ty, /*const*/char$ptr/*char P*/ AsmString, 
                  /*const*/char$ptr/*char P*/ Constraints, 
                  int HasSideEffects, 
                  int IsAlignStack) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBlockAddress">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1426,
 FQN="LLVMBlockAddress", NM="_Z16LLVMBlockAddress",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMBlockAddress")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBlockAddress( LLVMOpaqueValue /*P*/ F,  LLVMOpaqueBasicBlock /*P*/ BB) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1432,
 FQN="LLVMGetGlobalParent", NM="_Z19LLVMGetGlobalParent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMGetGlobalParent")
//</editor-fold>
public static  LLVMOpaqueModule /*P*/ LLVMGetGlobalParent( LLVMOpaqueValue /*P*/ Global) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsDeclaration">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1436,
 FQN="LLVMIsDeclaration", NM="_Z17LLVMIsDeclaration",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsDeclaration")
//</editor-fold>
public static int LLVMIsDeclaration( LLVMOpaqueValue /*P*/ Global) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetLinkage">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1440,
 FQN="LLVMGetLinkage", NM="_Z14LLVMGetLinkage",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMGetLinkage")
//</editor-fold>
public static LLVMLinkage LLVMGetLinkage( LLVMOpaqueValue /*P*/ Global) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetLinkage">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1469,
 FQN="LLVMSetLinkage", NM="_Z14LLVMSetLinkage",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMSetLinkage")
//</editor-fold>
public static void LLVMSetLinkage( LLVMOpaqueValue /*P*/ Global, LLVMLinkage Linkage) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetSection">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1531,
 FQN="LLVMGetSection", NM="_Z14LLVMGetSection",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMGetSection")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetSection( LLVMOpaqueValue /*P*/ Global) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetSection">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1537,
 FQN="LLVMSetSection", NM="_Z14LLVMSetSection",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMSetSection")
//</editor-fold>
public static void LLVMSetSection( LLVMOpaqueValue /*P*/ Global, /*const*/char$ptr/*char P*/ Section) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetVisibility">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1541,
 FQN="LLVMGetVisibility", NM="_Z17LLVMGetVisibility",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetVisibility")
//</editor-fold>
public static LLVMVisibility LLVMGetVisibility( LLVMOpaqueValue /*P*/ Global) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetVisibility">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1546,
 FQN="LLVMSetVisibility", NM="_Z17LLVMSetVisibility",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMSetVisibility")
//</editor-fold>
public static void LLVMSetVisibility( LLVMOpaqueValue /*P*/ Global, LLVMVisibility Viz) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetDLLStorageClass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1551,
 FQN="LLVMGetDLLStorageClass", NM="_Z22LLVMGetDLLStorageClass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMGetDLLStorageClass")
//</editor-fold>
public static LLVMDLLStorageClass LLVMGetDLLStorageClass( LLVMOpaqueValue /*P*/ Global) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetDLLStorageClass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1556,
 FQN="LLVMSetDLLStorageClass", NM="_Z22LLVMSetDLLStorageClass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMSetDLLStorageClass")
//</editor-fold>
public static void LLVMSetDLLStorageClass( LLVMOpaqueValue /*P*/ Global, LLVMDLLStorageClass Class) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMHasUnnamedAddr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1561,
 FQN="LLVMHasUnnamedAddr", NM="_Z18LLVMHasUnnamedAddr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMHasUnnamedAddr")
//</editor-fold>
public static int LLVMHasUnnamedAddr( LLVMOpaqueValue /*P*/ Global) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetUnnamedAddr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1565,
 FQN="LLVMSetUnnamedAddr", NM="_Z18LLVMSetUnnamedAddr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMSetUnnamedAddr")
//</editor-fold>
public static void LLVMSetUnnamedAddr( LLVMOpaqueValue /*P*/ Global, int HasUnnamedAddr) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1573,
 FQN="LLVMGetAlignment", NM="_Z16LLVMGetAlignment",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMGetAlignment")
//</editor-fold>
public static /*uint*/int LLVMGetAlignment( LLVMOpaqueValue /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set the preferred alignment of the value.
* @see llvm::AllocaInst::setAlignment()
* @see llvm::LoadInst::setAlignment()
* @see llvm::StoreInst::setAlignment()
* @see llvm::GlobalValue::setAlignment()
*/

/**
* Set the preferred alignment of the value.
* @see llvm::AllocaInst::setAlignment()
* @see llvm::LoadInst::setAlignment()
* @see llvm::StoreInst::setAlignment()
* @see llvm::GlobalValue::setAlignment()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetAlignment">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1588,
 FQN="LLVMSetAlignment", NM="_Z16LLVMSetAlignment",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMSetAlignment")
//</editor-fold>
public static void LLVMSetAlignment( LLVMOpaqueValue /*P*/ V, /*uint*/int Bytes) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1605,
 FQN="LLVMAddGlobal", NM="_Z13LLVMAddGlobal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMAddGlobal")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMAddGlobal( LLVMOpaqueModule /*P*/ M,  LLVMOpaqueType /*P*/ Ty, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMAddGlobalInAddressSpace">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1610,
 FQN="LLVMAddGlobalInAddressSpace", NM="_Z27LLVMAddGlobalInAddressSpace",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMAddGlobalInAddressSpace")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMAddGlobalInAddressSpace( LLVMOpaqueModule /*P*/ M,  LLVMOpaqueType /*P*/ Ty, 
                           /*const*/char$ptr/*char P*/ Name, 
                           /*uint*/int AddressSpace) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetNamedGlobal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1619,
 FQN="LLVMGetNamedGlobal", NM="_Z18LLVMGetNamedGlobal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetNamedGlobal")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetNamedGlobal( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetFirstGlobal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1623,
 FQN="LLVMGetFirstGlobal", NM="_Z18LLVMGetFirstGlobal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetFirstGlobal")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetFirstGlobal( LLVMOpaqueModule /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetLastGlobal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1631,
 FQN="LLVMGetLastGlobal", NM="_Z17LLVMGetLastGlobal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetLastGlobal")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetLastGlobal( LLVMOpaqueModule /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetNextGlobal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1639,
 FQN="LLVMGetNextGlobal", NM="_Z17LLVMGetNextGlobal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetNextGlobal")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetNextGlobal( LLVMOpaqueValue /*P*/ GlobalVar) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetPreviousGlobal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1647,
 FQN="LLVMGetPreviousGlobal", NM="_Z21LLVMGetPreviousGlobal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMGetPreviousGlobal")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetPreviousGlobal( LLVMOpaqueValue /*P*/ GlobalVar) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMDeleteGlobal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1655,
 FQN="LLVMDeleteGlobal", NM="_Z16LLVMDeleteGlobal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMDeleteGlobal")
//</editor-fold>
public static void LLVMDeleteGlobal( LLVMOpaqueValue /*P*/ GlobalVar) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetInitializer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1659,
 FQN="LLVMGetInitializer", NM="_Z18LLVMGetInitializer",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetInitializer")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetInitializer( LLVMOpaqueValue /*P*/ GlobalVar) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetInitializer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1666,
 FQN="LLVMSetInitializer", NM="_Z18LLVMSetInitializer",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMSetInitializer")
//</editor-fold>
public static void LLVMSetInitializer( LLVMOpaqueValue /*P*/ GlobalVar,  LLVMOpaqueValue /*P*/ ConstantVal) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsThreadLocal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1671,
 FQN="LLVMIsThreadLocal", NM="_Z17LLVMIsThreadLocal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsThreadLocal")
//</editor-fold>
public static int LLVMIsThreadLocal( LLVMOpaqueValue /*P*/ GlobalVar) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetThreadLocal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1675,
 FQN="LLVMSetThreadLocal", NM="_Z18LLVMSetThreadLocal",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMSetThreadLocal")
//</editor-fold>
public static void LLVMSetThreadLocal( LLVMOpaqueValue /*P*/ GlobalVar, int IsThreadLocal) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsGlobalConstant">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1679,
 FQN="LLVMIsGlobalConstant", NM="_Z20LLVMIsGlobalConstant",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMIsGlobalConstant")
//</editor-fold>
public static int LLVMIsGlobalConstant( LLVMOpaqueValue /*P*/ GlobalVar) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetGlobalConstant">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1683,
 FQN="LLVMSetGlobalConstant", NM="_Z21LLVMSetGlobalConstant",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMSetGlobalConstant")
//</editor-fold>
public static void LLVMSetGlobalConstant( LLVMOpaqueValue /*P*/ GlobalVar, int IsConstant) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetThreadLocalMode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1687,
 FQN="LLVMGetThreadLocalMode", NM="_Z22LLVMGetThreadLocalMode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMGetThreadLocalMode")
//</editor-fold>
public static LLVMThreadLocalMode LLVMGetThreadLocalMode( LLVMOpaqueValue /*P*/ GlobalVar) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetThreadLocalMode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1704,
 FQN="LLVMSetThreadLocalMode", NM="_Z22LLVMSetThreadLocalMode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMSetThreadLocalMode")
//</editor-fold>
public static void LLVMSetThreadLocalMode( LLVMOpaqueValue /*P*/ GlobalVar, LLVMThreadLocalMode Mode) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsExternallyInitialized">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1726,
 FQN="LLVMIsExternallyInitialized", NM="_Z27LLVMIsExternallyInitialized",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMIsExternallyInitialized")
//</editor-fold>
public static int LLVMIsExternallyInitialized( LLVMOpaqueValue /*P*/ GlobalVar) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetExternallyInitialized">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1730,
 FQN="LLVMSetExternallyInitialized", NM="_Z28LLVMSetExternallyInitialized",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z28LLVMSetExternallyInitialized")
//</editor-fold>
public static void LLVMSetExternallyInitialized( LLVMOpaqueValue /*P*/ GlobalVar, int IsExtInit) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1736,
 FQN="LLVMAddAlias", NM="_Z12LLVMAddAlias",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMAddAlias")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMAddAlias( LLVMOpaqueModule /*P*/ M,  LLVMOpaqueType /*P*/ Ty,  LLVMOpaqueValue /*P*/ Aliasee, 
            /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1788,
 FQN="LLVMDeleteFunction", NM="_Z18LLVMDeleteFunction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMDeleteFunction")
//</editor-fold>
public static void LLVMDeleteFunction( LLVMOpaqueValue /*P*/ Fn) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Check whether the given function has a personality function.
*
* @see llvm::Function::hasPersonalityFn()
*/

/**
* Check whether the given function has a personality function.
*
* @see llvm::Function::hasPersonalityFn()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMHasPersonalityFn">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1792,
 FQN="LLVMHasPersonalityFn", NM="_Z20LLVMHasPersonalityFn",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMHasPersonalityFn")
//</editor-fold>
public static int LLVMHasPersonalityFn( LLVMOpaqueValue /*P*/ Fn) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the personality function attached to the function.
*
* @see llvm::Function::getPersonalityFn()
*/

/**
* Obtain the personality function attached to the function.
*
* @see llvm::Function::getPersonalityFn()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetPersonalityFn">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1796,
 FQN="LLVMGetPersonalityFn", NM="_Z20LLVMGetPersonalityFn",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetPersonalityFn")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetPersonalityFn( LLVMOpaqueValue /*P*/ Fn) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set the personality function attached to the function.
*
* @see llvm::Function::setPersonalityFn()
*/

/**
* Set the personality function attached to the function.
*
* @see llvm::Function::setPersonalityFn()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetPersonalityFn">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1800,
 FQN="LLVMSetPersonalityFn", NM="_Z20LLVMSetPersonalityFn",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMSetPersonalityFn")
//</editor-fold>
public static void LLVMSetPersonalityFn( LLVMOpaqueValue /*P*/ Fn,  LLVMOpaqueValue /*P*/ PersonalityFn) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the ID number from a function instance.
*
* @see llvm::Function::getIntrinsicID()
*/

/**
* Obtain the ID number from a function instance.
*
* @see llvm::Function::getIntrinsicID()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetIntrinsicID">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1804,
 FQN="LLVMGetIntrinsicID", NM="_Z18LLVMGetIntrinsicID",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetIntrinsicID")
//</editor-fold>
public static /*uint*/int LLVMGetIntrinsicID( LLVMOpaqueValue /*P*/ Fn) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the calling function of a function.
*
* The returned value corresponds to the LLVMCallConv enumeration.
*
* @see llvm::Function::getCallingConv()
*/

/**
* Obtain the calling function of a function.
*
* The returned value corresponds to the LLVMCallConv enumeration.
*
* @see llvm::Function::getCallingConv()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetFunctionCallConv">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1810,
 FQN="LLVMGetFunctionCallConv", NM="_Z23LLVMGetFunctionCallConv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMGetFunctionCallConv")
//</editor-fold>
public static /*uint*/int LLVMGetFunctionCallConv( LLVMOpaqueValue /*P*/ Fn) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set the calling convention of a function.
*
* @see llvm::Function::setCallingConv()
*
* @param Fn Function to operate on
* @param CC LLVMCallConv to set calling convention to
*/

/**
* Set the calling convention of a function.
*
* @see llvm::Function::setCallingConv()
*
* @param Fn Function to operate on
* @param CC LLVMCallConv to set calling convention to
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetFunctionCallConv">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1814,
 FQN="LLVMSetFunctionCallConv", NM="_Z23LLVMSetFunctionCallConv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMSetFunctionCallConv")
//</editor-fold>
public static void LLVMSetFunctionCallConv( LLVMOpaqueValue /*P*/ Fn, /*uint*/int CC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the name of the garbage collector to use during code
* generation.
*
* @see llvm::Function::getGC()
*/

/**
* Obtain the name of the garbage collector to use during code
* generation.
*
* @see llvm::Function::getGC()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetGC">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1819,
 FQN="LLVMGetGC", NM="_Z9LLVMGetGC",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z9LLVMGetGC")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetGC( LLVMOpaqueValue /*P*/ Fn) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Define the garbage collector to use during code generation.
*
* @see llvm::Function::setGC()
*/

/**
* Define the garbage collector to use during code generation.
*
* @see llvm::Function::setGC()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetGC">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1824,
 FQN="LLVMSetGC", NM="_Z9LLVMSetGC",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z9LLVMSetGC")
//</editor-fold>
public static void LLVMSetGC( LLVMOpaqueValue /*P*/ Fn, /*const*/char$ptr/*char P*/ GC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Add an attribute to a function.
*
* @see llvm::Function::addAttribute()
*/

/**
* Add an attribute to a function.
*
* @see llvm::Function::addAttribute()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMAddFunctionAttr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1832,
 FQN="LLVMAddFunctionAttr", NM="_Z19LLVMAddFunctionAttr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMAddFunctionAttr")
//</editor-fold>
public static void LLVMAddFunctionAttr( LLVMOpaqueValue /*P*/ Fn, LLVMAttribute PA) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMAddAttributeAtIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1843,
 FQN="LLVMAddAttributeAtIndex", NM="_Z23LLVMAddAttributeAtIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMAddAttributeAtIndex")
//</editor-fold>
public static void LLVMAddAttributeAtIndex( LLVMOpaqueValue /*P*/ F, /*uint*/int Idx, 
                        LLVMOpaqueAttributeRef /*P*/ A) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetAttributeCountAtIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1848,
 FQN="LLVMGetAttributeCountAtIndex", NM="_Z28LLVMGetAttributeCountAtIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z28LLVMGetAttributeCountAtIndex")
//</editor-fold>
public static /*uint*/int LLVMGetAttributeCountAtIndex( LLVMOpaqueValue /*P*/ F, /*uint*/int Idx) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetAttributesAtIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1853,
 FQN="LLVMGetAttributesAtIndex", NM="_Z24LLVMGetAttributesAtIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMGetAttributesAtIndex")
//</editor-fold>
public static void LLVMGetAttributesAtIndex( LLVMOpaqueValue /*P*/ F, /*uint*/int Idx, 
                        type$ptr<LLVMOpaqueAttributeRef /*P*/ /*P*/> Attrs) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetEnumAttributeAtIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1860,
 FQN="LLVMGetEnumAttributeAtIndex", NM="_Z27LLVMGetEnumAttributeAtIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMGetEnumAttributeAtIndex")
//</editor-fold>
public static  LLVMOpaqueAttributeRef /*P*/ LLVMGetEnumAttributeAtIndex( LLVMOpaqueValue /*P*/ F, 
                           /*uint*/int Idx, 
                           /*uint*/int KindID) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetStringAttributeAtIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1867,
 FQN="LLVMGetStringAttributeAtIndex", NM="_Z29LLVMGetStringAttributeAtIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMGetStringAttributeAtIndex")
//</editor-fold>
public static  LLVMOpaqueAttributeRef /*P*/ LLVMGetStringAttributeAtIndex( LLVMOpaqueValue /*P*/ F, 
                             /*uint*/int Idx, 
                             /*const*/char$ptr/*char P*/ K, /*uint*/int KLen) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMRemoveEnumAttributeAtIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1873,
 FQN="LLVMRemoveEnumAttributeAtIndex", NM="_Z30LLVMRemoveEnumAttributeAtIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z30LLVMRemoveEnumAttributeAtIndex")
//</editor-fold>
public static void LLVMRemoveEnumAttributeAtIndex( LLVMOpaqueValue /*P*/ F, /*uint*/int Idx, 
                              /*uint*/int KindID) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMRemoveStringAttributeAtIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1878,
 FQN="LLVMRemoveStringAttributeAtIndex", NM="_Z32LLVMRemoveStringAttributeAtIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z32LLVMRemoveStringAttributeAtIndex")
//</editor-fold>
public static void LLVMRemoveStringAttributeAtIndex( LLVMOpaqueValue /*P*/ F, /*uint*/int Idx, 
                                /*const*/char$ptr/*char P*/ K, /*uint*/int KLen) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Add a target-dependent attribute to a function
* @see llvm::AttrBuilder::addAttribute()
*/

/**
* Add a target-dependent attribute to a function
* @see llvm::AttrBuilder::addAttribute()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMAddTargetDependentFunctionAttr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1883,
 FQN="LLVMAddTargetDependentFunctionAttr", NM="_Z34LLVMAddTargetDependentFunctionAttr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z34LLVMAddTargetDependentFunctionAttr")
//</editor-fold>
public static void LLVMAddTargetDependentFunctionAttr( LLVMOpaqueValue /*P*/ Fn, /*const*/char$ptr/*char P*/ A, 
                                  /*const*/char$ptr/*char P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain an attribute from a function.
*
* @see llvm::Function::getAttributes()
*/

/**
* Obtain an attribute from a function.
*
* @see llvm::Function::getAttributes()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetFunctionAttr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1906,
 FQN="LLVMGetFunctionAttr", NM="_Z19LLVMGetFunctionAttr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMGetFunctionAttr")
//</editor-fold>
public static LLVMAttribute LLVMGetFunctionAttr( LLVMOpaqueValue /*P*/ Fn) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Remove an attribute from a function.
*/

/**
* Remove an attribute from a function.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMRemoveFunctionAttr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1895,
 FQN="LLVMRemoveFunctionAttr", NM="_Z22LLVMRemoveFunctionAttr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMRemoveFunctionAttr")
//</editor-fold>
public static void LLVMRemoveFunctionAttr( LLVMOpaqueValue /*P*/ Fn, LLVMAttribute PA) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1914,
 FQN="LLVMCountParams", NM="_Z15LLVMCountParams",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMCountParams")
//</editor-fold>
public static /*uint*/int LLVMCountParams( LLVMOpaqueValue /*P*/ FnRef) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1920,
 FQN="LLVMGetParams", NM="_Z13LLVMGetParams",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMGetParams")
//</editor-fold>
public static void LLVMGetParams( LLVMOpaqueValue /*P*/ FnRef, type$ptr<LLVMOpaqueValue /*P*/ /*P*/> ParamRefs) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the parameter at the specified index.
*
* Parameters are indexed from 0.
*
* @see llvm::Function::arg_begin()
*/

/**
* Obtain the parameter at the specified index.
*
* Parameters are indexed from 0.
*
* @see llvm::Function::arg_begin()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetParam">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1927,
 FQN="LLVMGetParam", NM="_Z12LLVMGetParam",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMGetParam")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetParam( LLVMOpaqueValue /*P*/ FnRef, /*uint*/int index) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1934,
 FQN="LLVMGetParamParent", NM="_Z18LLVMGetParamParent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetParamParent")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetParamParent( LLVMOpaqueValue /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the first parameter to a function.
*
* @see llvm::Function::arg_begin()
*/

/**
* Obtain the first parameter to a function.
*
* @see llvm::Function::arg_begin()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetFirstParam">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1938,
 FQN="LLVMGetFirstParam", NM="_Z17LLVMGetFirstParam",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetFirstParam")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetFirstParam( LLVMOpaqueValue /*P*/ Fn) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the last parameter to a function.
*
* @see llvm::Function::arg_end()
*/

/**
* Obtain the last parameter to a function.
*
* @see llvm::Function::arg_end()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetLastParam">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1946,
 FQN="LLVMGetLastParam", NM="_Z16LLVMGetLastParam",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMGetLastParam")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetLastParam( LLVMOpaqueValue /*P*/ Fn) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the next parameter to a function.
*
* This takes an LLVMValueRef obtained from LLVMGetFirstParam() (which is
* actually a wrapped iterator) and obtains the next parameter from the
* underlying iterator.
*/

/**
* Obtain the next parameter to a function.
*
* This takes an LLVMValueRef obtained from LLVMGetFirstParam() (which is
* actually a wrapped iterator) and obtains the next parameter from the
* underlying iterator.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNextParam">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1954,
 FQN="LLVMGetNextParam", NM="_Z16LLVMGetNextParam",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMGetNextParam")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetNextParam( LLVMOpaqueValue /*P*/ Arg) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the previous parameter to a function.
*
* This is the opposite of LLVMGetNextParam().
*/

/**
* Obtain the previous parameter to a function.
*
* This is the opposite of LLVMGetNextParam().
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetPreviousParam">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1962,
 FQN="LLVMGetPreviousParam", NM="_Z20LLVMGetPreviousParam",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetPreviousParam")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetPreviousParam( LLVMOpaqueValue /*P*/ Arg) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Add an attribute to a function argument.
*
* @see llvm::Argument::addAttr()
*/

/**
* Add an attribute to a function argument.
*
* @see llvm::Argument::addAttr()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMAddAttribute">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1970,
 FQN="LLVMAddAttribute", NM="_Z16LLVMAddAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMAddAttribute")
//</editor-fold>
public static void LLVMAddAttribute( LLVMOpaqueValue /*P*/ Arg, LLVMAttribute PA) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Remove an attribute from a function argument.
*
* @see llvm::Argument::removeAttr()
*/

/**
* Remove an attribute from a function argument.
*
* @see llvm::Argument::removeAttr()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMRemoveAttribute">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1976,
 FQN="LLVMRemoveAttribute", NM="_Z19LLVMRemoveAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMRemoveAttribute")
//</editor-fold>
public static void LLVMRemoveAttribute( LLVMOpaqueValue /*P*/ Arg, LLVMAttribute PA) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Get an attribute from a function argument.
*/

/**
* Get an attribute from a function argument.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetAttribute">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1982,
 FQN="LLVMGetAttribute", NM="_Z16LLVMGetAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMGetAttribute")
//</editor-fold>
public static LLVMAttribute LLVMGetAttribute( LLVMOpaqueValue /*P*/ Arg) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set the alignment for a function parameter.
*
* @see llvm::Argument::addAttr()
* @see llvm::AttrBuilder::addAlignmentAttr()
*/

/**
* Set the alignment for a function parameter.
*
* @see llvm::Argument::addAttr()
* @see llvm::AttrBuilder::addAlignmentAttr()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetParamAlignment">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1988,
 FQN="LLVMSetParamAlignment", NM="_Z21LLVMSetParamAlignment",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMSetParamAlignment")
//</editor-fold>
public static void LLVMSetParamAlignment( LLVMOpaqueValue /*P*/ Arg, /*uint*/int align) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 819,
 FQN="LLVMMDStringInContext", NM="_Z21LLVMMDStringInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMMDStringInContext")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMMDStringInContext( LLVMOpaqueContext /*P*/ C, /*const*/char$ptr/*char P*/ Str, 
                     /*uint*/int SLen) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain a MDString value from the global context.
*/

/**
* Obtain a MDString value from the global context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMMDString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 826,
 FQN="LLVMMDString", NM="_Z12LLVMMDString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMMDString")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMMDString(/*const*/char$ptr/*char P*/ Str, /*uint*/int SLen) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain a MDNode value from a context.
*
* The returned value corresponds to the llvm::MDNode class.
*/

/**
* Obtain a MDNode value from a context.
*
* The returned value corresponds to the llvm::MDNode class.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMMDNodeInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 830,
 FQN="LLVMMDNodeInContext", NM="_Z19LLVMMDNodeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMMDNodeInContext")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMMDNodeInContext( LLVMOpaqueContext /*P*/ C, type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Vals, 
                   /*uint*/int Count) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain a MDNode value from the global context.
*/

/**
* Obtain a MDNode value from the global context.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMMDNode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 857,
 FQN="LLVMMDNode", NM="_Z10LLVMMDNode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z10LLVMMDNode")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMMDNode(type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Vals, /*uint*/int Count) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the underlying string from a MDString value.
*
* @param V Instance to obtain string from.
* @param Length Memory address which will hold length of returned string.
* @return String data in MDString.
*/

/**
* Obtain the underlying string from a MDString value.
*
* @param V Instance to obtain string from.
* @param Length Memory address which will hold length of returned string.
* @return String data in MDString.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetMDString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 861,
 FQN="LLVMGetMDString", NM="_Z15LLVMGetMDString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMGetMDString")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetMDString( LLVMOpaqueValue /*P*/ V, uint$ptr/*uint P*/ Length) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the number of operands from an MDNode value.
*
* @param V MDNode to get number of operands from.
* @return Number of operands of the MDNode.
*/

/**
* Obtain the number of operands from an MDNode value.
*
* @param V MDNode to get number of operands from.
* @return Number of operands of the MDNode.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetMDNodeNumOperands">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 871,
 FQN="LLVMGetMDNodeNumOperands", NM="_Z24LLVMGetMDNodeNumOperands",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMGetMDNodeNumOperands")
//</editor-fold>
public static /*uint*/int LLVMGetMDNodeNumOperands( LLVMOpaqueValue /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 878,
 FQN="LLVMGetMDNodeOperands", NM="_Z21LLVMGetMDNodeOperands",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMGetMDNodeOperands")
//</editor-fold>
public static void LLVMGetMDNodeOperands( LLVMOpaqueValue /*P*/ V, type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Dest) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 1997,
 FQN="LLVMBasicBlockAsValue", NM="_Z21LLVMBasicBlockAsValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMBasicBlockAsValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBasicBlockAsValue( LLVMOpaqueBasicBlock /*P*/ BB) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Determine whether an LLVMValueRef is itself a basic block.
*/

/**
* Determine whether an LLVMValueRef is itself a basic block.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMValueIsBasicBlock">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2001,
 FQN="LLVMValueIsBasicBlock", NM="_Z21LLVMValueIsBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMValueIsBasicBlock")
//</editor-fold>
public static int LLVMValueIsBasicBlock( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Convert an LLVMValueRef to an LLVMBasicBlockRef instance.
*/

/**
* Convert an LLVMValueRef to an LLVMBasicBlockRef instance.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMValueAsBasicBlock">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2005,
 FQN="LLVMValueAsBasicBlock", NM="_Z21LLVMValueAsBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMValueAsBasicBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMValueAsBasicBlock( LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the string name of a basic block.
*/

/**
* Obtain the string name of a basic block.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetBasicBlockName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2009,
 FQN="LLVMGetBasicBlockName", NM="_Z21LLVMGetBasicBlockName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMGetBasicBlockName")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetBasicBlockName( LLVMOpaqueBasicBlock /*P*/ BB) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the function to which a basic block belongs.
*
* @see llvm::BasicBlock::getParent()
*/

/**
* Obtain the function to which a basic block belongs.
*
* @see llvm::BasicBlock::getParent()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetBasicBlockParent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2013,
 FQN="LLVMGetBasicBlockParent", NM="_Z23LLVMGetBasicBlockParent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMGetBasicBlockParent")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetBasicBlockParent( LLVMOpaqueBasicBlock /*P*/ BB) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2017,
 FQN="LLVMGetBasicBlockTerminator", NM="_Z27LLVMGetBasicBlockTerminator",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMGetBasicBlockTerminator")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetBasicBlockTerminator( LLVMOpaqueBasicBlock /*P*/ BB) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the number of basic blocks in a function.
*
* @param Fn Function value to operate on.
*/

/**
* Obtain the number of basic blocks in a function.
*
* @param Fn Function value to operate on.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMCountBasicBlocks">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2021,
 FQN="LLVMCountBasicBlocks", NM="_Z20LLVMCountBasicBlocks",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMCountBasicBlocks")
//</editor-fold>
public static /*uint*/int LLVMCountBasicBlocks( LLVMOpaqueValue /*P*/ FnRef) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain all of the basic blocks in a function.
*
* This operates on a function value. The BasicBlocks parameter is a
* pointer to a pre-allocated array of LLVMBasicBlockRef of at least
* LLVMCountBasicBlocks() in length. This array is populated with
* LLVMBasicBlockRef instances.
*/

/**
* Obtain all of the basic blocks in a function.
*
* This operates on a function value. The BasicBlocks parameter is a
* pointer to a pre-allocated array of LLVMBasicBlockRef of at least
* LLVMCountBasicBlocks() in length. This array is populated with
* LLVMBasicBlockRef instances.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetBasicBlocks">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2025,
 FQN="LLVMGetBasicBlocks", NM="_Z18LLVMGetBasicBlocks",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetBasicBlocks")
//</editor-fold>
public static void LLVMGetBasicBlocks( LLVMOpaqueValue /*P*/ FnRef, type$ptr<LLVMOpaqueBasicBlock /*P*/ /*P*/> BasicBlocksRefs) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the first basic block in a function.
*
* The returned basic block can be used as an iterator. You will likely
* eventually call into LLVMGetNextBasicBlock() with it.
*
* @see llvm::Function::begin()
*/

/**
* Obtain the first basic block in a function.
*
* The returned basic block can be used as an iterator. You will likely
* eventually call into LLVMGetNextBasicBlock() with it.
*
* @see llvm::Function::begin()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetFirstBasicBlock">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2035,
 FQN="LLVMGetFirstBasicBlock", NM="_Z22LLVMGetFirstBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMGetFirstBasicBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetFirstBasicBlock( LLVMOpaqueValue /*P*/ Fn) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the last basic block in a function.
*
* @see llvm::Function::end()
*/

/**
* Obtain the last basic block in a function.
*
* @see llvm::Function::end()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetLastBasicBlock">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2043,
 FQN="LLVMGetLastBasicBlock", NM="_Z21LLVMGetLastBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMGetLastBasicBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetLastBasicBlock( LLVMOpaqueValue /*P*/ Fn) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Advance a basic block iterator.
*/

/**
* Advance a basic block iterator.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNextBasicBlock">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2051,
 FQN="LLVMGetNextBasicBlock", NM="_Z21LLVMGetNextBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMGetNextBasicBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetNextBasicBlock( LLVMOpaqueBasicBlock /*P*/ BB) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Go backwards in a basic block iterator.
*/

/**
* Go backwards in a basic block iterator.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetPreviousBasicBlock">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2059,
 FQN="LLVMGetPreviousBasicBlock", NM="_Z25LLVMGetPreviousBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMGetPreviousBasicBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetPreviousBasicBlock( LLVMOpaqueBasicBlock /*P*/ BB) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the basic block that corresponds to the entry point of a
* function.
*
* @see llvm::Function::getEntryBlock()
*/

/**
* Obtain the basic block that corresponds to the entry point of a
* function.
*
* @see llvm::Function::getEntryBlock()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetEntryBasicBlock">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2031,
 FQN="LLVMGetEntryBasicBlock", NM="_Z22LLVMGetEntryBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMGetEntryBasicBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetEntryBasicBlock( LLVMOpaqueValue /*P*/ Fn) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Append a basic block to the end of a function.
*
* @see llvm::BasicBlock::Create()
*/

/**
* Append a basic block to the end of a function.
*
* @see llvm::BasicBlock::Create()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMAppendBasicBlockInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2067,
 FQN="LLVMAppendBasicBlockInContext", NM="_Z29LLVMAppendBasicBlockInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMAppendBasicBlockInContext")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMAppendBasicBlockInContext( LLVMOpaqueContext /*P*/ C, 
                              LLVMOpaqueValue /*P*/ FnRef, 
                             /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Append a basic block to the end of a function using the global
* context.
*
* @see llvm::BasicBlock::Create()
*/

/**
* Append a basic block to the end of a function using the global
* context.
*
* @see llvm::BasicBlock::Create()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMAppendBasicBlock">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2073,
 FQN="LLVMAppendBasicBlock", NM="_Z20LLVMAppendBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMAppendBasicBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMAppendBasicBlock( LLVMOpaqueValue /*P*/ FnRef, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Insert a basic block in a function before another basic block.
*
* The function to add to is determined by the function of the
* passed basic block.
*
* @see llvm::BasicBlock::Create()
*/

/**
* Insert a basic block in a function before another basic block.
*
* The function to add to is determined by the function of the
* passed basic block.
*
* @see llvm::BasicBlock::Create()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMInsertBasicBlockInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2077,
 FQN="LLVMInsertBasicBlockInContext", NM="_Z29LLVMInsertBasicBlockInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMInsertBasicBlockInContext")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMInsertBasicBlockInContext( LLVMOpaqueContext /*P*/ C, 
                              LLVMOpaqueBasicBlock /*P*/ BBRef, 
                             /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Insert a basic block in a function using the global context.
*
* @see llvm::BasicBlock::Create()
*/

/**
* Insert a basic block in a function using the global context.
*
* @see llvm::BasicBlock::Create()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMInsertBasicBlock">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2084,
 FQN="LLVMInsertBasicBlock", NM="_Z20LLVMInsertBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMInsertBasicBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMInsertBasicBlock( LLVMOpaqueBasicBlock /*P*/ BBRef, 
                    /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Remove a basic block from a function and delete it.
*
* This deletes the basic block from its containing function and deletes
* the basic block itself.
*
* @see llvm::BasicBlock::eraseFromParent()
*/

/**
* Remove a basic block from a function and delete it.
*
* This deletes the basic block from its containing function and deletes
* the basic block itself.
*
* @see llvm::BasicBlock::eraseFromParent()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMDeleteBasicBlock">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2089,
 FQN="LLVMDeleteBasicBlock", NM="_Z20LLVMDeleteBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMDeleteBasicBlock")
//</editor-fold>
public static void LLVMDeleteBasicBlock( LLVMOpaqueBasicBlock /*P*/ BBRef) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Remove a basic block from a function.
*
* This deletes the basic block from its containing function but keep
* the basic block alive.
*
* @see llvm::BasicBlock::removeFromParent()
*/

/**
* Remove a basic block from a function.
*
* This deletes the basic block from its containing function but keep
* the basic block alive.
*
* @see llvm::BasicBlock::removeFromParent()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMRemoveBasicBlockFromParent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2093,
 FQN="LLVMRemoveBasicBlockFromParent", NM="_Z30LLVMRemoveBasicBlockFromParent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z30LLVMRemoveBasicBlockFromParent")
//</editor-fold>
public static void LLVMRemoveBasicBlockFromParent( LLVMOpaqueBasicBlock /*P*/ BBRef) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Move a basic block to before another one.
*
* @see llvm::BasicBlock::moveBefore()
*/

/**
* Move a basic block to before another one.
*
* @see llvm::BasicBlock::moveBefore()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMMoveBasicBlockBefore">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2097,
 FQN="LLVMMoveBasicBlockBefore", NM="_Z24LLVMMoveBasicBlockBefore",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMMoveBasicBlockBefore")
//</editor-fold>
public static void LLVMMoveBasicBlockBefore( LLVMOpaqueBasicBlock /*P*/ BB,  LLVMOpaqueBasicBlock /*P*/ MovePos) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Move a basic block to after another one.
*
* @see llvm::BasicBlock::moveAfter()
*/

/**
* Move a basic block to after another one.
*
* @see llvm::BasicBlock::moveAfter()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMMoveBasicBlockAfter">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2101,
 FQN="LLVMMoveBasicBlockAfter", NM="_Z23LLVMMoveBasicBlockAfter",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMMoveBasicBlockAfter")
//</editor-fold>
public static void LLVMMoveBasicBlockAfter( LLVMOpaqueBasicBlock /*P*/ BB,  LLVMOpaqueBasicBlock /*P*/ MovePos) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the first instruction in a basic block.
*
* The returned LLVMValueRef corresponds to a llvm::Instruction
* instance.
*/

/**
* Obtain the first instruction in a basic block.
*
* The returned LLVMValueRef corresponds to a llvm::Instruction
* instance.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetFirstInstruction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2111,
 FQN="LLVMGetFirstInstruction", NM="_Z23LLVMGetFirstInstruction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMGetFirstInstruction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetFirstInstruction( LLVMOpaqueBasicBlock /*P*/ BB) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the last instruction in a basic block.
*
* The returned LLVMValueRef corresponds to an LLVM:Instruction.
*/

/**
* Obtain the last instruction in a basic block.
*
* The returned LLVMValueRef corresponds to an LLVM:Instruction.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetLastInstruction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2119,
 FQN="LLVMGetLastInstruction", NM="_Z22LLVMGetLastInstruction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMGetLastInstruction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetLastInstruction( LLVMOpaqueBasicBlock /*P*/ BB) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 662,
 FQN="LLVMHasMetadata", NM="_Z15LLVMHasMetadata",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMHasMetadata")
//</editor-fold>
public static int LLVMHasMetadata( LLVMOpaqueValue /*P*/ Inst) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Return metadata associated with an instruction value.
*/

/**
* Return metadata associated with an instruction value.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetMetadata">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 666,
 FQN="LLVMGetMetadata", NM="_Z15LLVMGetMetadata",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMGetMetadata")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetMetadata( LLVMOpaqueValue /*P*/ Inst, /*uint*/int KindID) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set metadata associated with an instruction value.
*/

/**
* Set metadata associated with an instruction value.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetMetadata">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 688,
 FQN="LLVMSetMetadata", NM="_Z15LLVMSetMetadata",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMSetMetadata")
//</editor-fold>
public static void LLVMSetMetadata( LLVMOpaqueValue /*P*/ Inst, /*uint*/int KindID,  LLVMOpaqueValue /*P*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the basic block to which an instruction belongs.
*
* @see llvm::Instruction::getParent()
*/

/**
* Obtain the basic block to which an instruction belongs.
*
* @see llvm::Instruction::getParent()
*/

/*--.. Operations on instructions ..........................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetInstructionParent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2107,
 FQN="LLVMGetInstructionParent", NM="_Z24LLVMGetInstructionParent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMGetInstructionParent")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetInstructionParent( LLVMOpaqueValue /*P*/ Inst) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the instruction that occurs after the one specified.
*
* The next instruction will be from the same basic block.
*
* If this is the last instruction in a basic block, NULL will be
* returned.
*/

/**
* Obtain the instruction that occurs after the one specified.
*
* The next instruction will be from the same basic block.
*
* If this is the last instruction in a basic block, NULL will be
* returned.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNextInstruction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2127,
 FQN="LLVMGetNextInstruction", NM="_Z22LLVMGetNextInstruction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMGetNextInstruction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetNextInstruction( LLVMOpaqueValue /*P*/ Inst) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the instruction that occurred before this one.
*
* If the instruction is the first instruction in a basic block, NULL
* will be returned.
*/

/**
* Obtain the instruction that occurred before this one.
*
* If the instruction is the first instruction in a basic block, NULL
* will be returned.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetPreviousInstruction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2135,
 FQN="LLVMGetPreviousInstruction", NM="_Z26LLVMGetPreviousInstruction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMGetPreviousInstruction")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetPreviousInstruction( LLVMOpaqueValue /*P*/ Inst) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Remove and delete an instruction.
*
* The instruction specified is removed from its containing building
* block but is kept alive.
*
* @see llvm::Instruction::removeFromParent()
*/

/**
* Remove and delete an instruction.
*
* The instruction specified is removed from its containing building
* block but is kept alive.
*
* @see llvm::Instruction::removeFromParent()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMInstructionRemoveFromParent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2143,
 FQN="LLVMInstructionRemoveFromParent", NM="_Z31LLVMInstructionRemoveFromParent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z31LLVMInstructionRemoveFromParent")
//</editor-fold>
public static void LLVMInstructionRemoveFromParent( LLVMOpaqueValue /*P*/ Inst) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Remove and delete an instruction.
*
* The instruction specified is removed from its containing building
* block and then deleted.
*
* @see llvm::Instruction::eraseFromParent()
*/

/**
* Remove and delete an instruction.
*
* The instruction specified is removed from its containing building
* block and then deleted.
*
* @see llvm::Instruction::eraseFromParent()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMInstructionEraseFromParent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2147,
 FQN="LLVMInstructionEraseFromParent", NM="_Z30LLVMInstructionEraseFromParent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z30LLVMInstructionEraseFromParent")
//</editor-fold>
public static void LLVMInstructionEraseFromParent( LLVMOpaqueValue /*P*/ Inst) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the code opcode for an individual instruction.
*
* @see llvm::Instruction::getOpCode()
*/

/**
* Obtain the code opcode for an individual instruction.
*
* @see llvm::Instruction::getOpCode()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetInstructionOpcode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2169,
 FQN="LLVMGetInstructionOpcode", NM="_Z24LLVMGetInstructionOpcode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMGetInstructionOpcode")
//</editor-fold>
public static LLVMOpcode LLVMGetInstructionOpcode( LLVMOpaqueValue /*P*/ Inst) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the predicate of an instruction.
*
* This is only valid for instructions that correspond to llvm::ICmpInst
* or llvm::ConstantExpr whose opcode is llvm::Instruction::ICmp.
*
* @see llvm::ICmpInst::getPredicate()
*/

/**
* Obtain the predicate of an instruction.
*
* This is only valid for instructions that correspond to llvm::ICmpInst
* or llvm::ConstantExpr whose opcode is llvm::Instruction::ICmp.
*
* @see llvm::ICmpInst::getPredicate()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetICmpPredicate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2151,
 FQN="LLVMGetICmpPredicate", NM="_Z20LLVMGetICmpPredicate",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetICmpPredicate")
//</editor-fold>
public static LLVMIntPredicate LLVMGetICmpPredicate( LLVMOpaqueValue /*P*/ Inst) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the float predicate of an instruction.
*
* This is only valid for instructions that correspond to llvm::FCmpInst
* or llvm::ConstantExpr whose opcode is llvm::Instruction::FCmp.
*
* @see llvm::FCmpInst::getPredicate()
*/

/**
* Obtain the float predicate of an instruction.
*
* This is only valid for instructions that correspond to llvm::FCmpInst
* or llvm::ConstantExpr whose opcode is llvm::Instruction::FCmp.
*
* @see llvm::FCmpInst::getPredicate()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetFCmpPredicate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2160,
 FQN="LLVMGetFCmpPredicate", NM="_Z20LLVMGetFCmpPredicate",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetFCmpPredicate")
//</editor-fold>
public static LLVMRealPredicate LLVMGetFCmpPredicate( LLVMOpaqueValue /*P*/ Inst) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Create a copy of 'this' instruction that is identical in all ways
* except the following:
*   * The instruction has no parent
*   * The instruction has no name
*
* @see llvm::Instruction::clone()
*/

/**
* Create a copy of 'this' instruction that is identical in all ways
* except the following:
*   * The instruction has no parent
*   * The instruction has no name
*
* @see llvm::Instruction::clone()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMInstructionClone">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2175,
 FQN="LLVMInstructionClone", NM="_Z20LLVMInstructionClone",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMInstructionClone")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMInstructionClone( LLVMOpaqueValue /*P*/ Inst) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2183,
 FQN="LLVMGetNumArgOperands", NM="_Z21LLVMGetNumArgOperands",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMGetNumArgOperands")
//</editor-fold>
public static /*uint*/int LLVMGetNumArgOperands( LLVMOpaqueValue /*P*/ Instr) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2191,
 FQN="LLVMSetInstructionCallConv", NM="_Z26LLVMSetInstructionCallConv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMSetInstructionCallConv")
//</editor-fold>
public static void LLVMSetInstructionCallConv( LLVMOpaqueValue /*P*/ Instr, /*uint*/int CC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the calling convention for a call instruction.
*
* This is the opposite of LLVMSetInstructionCallConv(). Reads its
* usage.
*
* @see LLVMSetInstructionCallConv()
*/

/**
* Obtain the calling convention for a call instruction.
*
* This is the opposite of LLVMSetInstructionCallConv(). Reads its
* usage.
*
* @see LLVMSetInstructionCallConv()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetInstructionCallConv">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2187,
 FQN="LLVMGetInstructionCallConv", NM="_Z26LLVMGetInstructionCallConv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMGetInstructionCallConv")
//</editor-fold>
public static /*uint*/int LLVMGetInstructionCallConv( LLVMOpaqueValue /*P*/ Instr) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMAddInstrAttribute">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2196,
 FQN="LLVMAddInstrAttribute", NM="_Z21LLVMAddInstrAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMAddInstrAttribute")
//</editor-fold>
public static void LLVMAddInstrAttribute( LLVMOpaqueValue /*P*/ Instr, /*uint*/int index, 
                     LLVMAttribute PA) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMRemoveInstrAttribute">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2206,
 FQN="LLVMRemoveInstrAttribute", NM="_Z24LLVMRemoveInstrAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMRemoveInstrAttribute")
//</editor-fold>
public static void LLVMRemoveInstrAttribute( LLVMOpaqueValue /*P*/ Instr, /*uint*/int index, 
                        LLVMAttribute PA) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetInstrParamAlignment">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2216,
 FQN="LLVMSetInstrParamAlignment", NM="_Z26LLVMSetInstrParamAlignment",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMSetInstrParamAlignment")
//</editor-fold>
public static void LLVMSetInstrParamAlignment( LLVMOpaqueValue /*P*/ Instr, /*uint*/int index, 
                          /*uint*/int align) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMAddCallSiteAttribute">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2227,
 FQN="LLVMAddCallSiteAttribute", NM="_Z24LLVMAddCallSiteAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMAddCallSiteAttribute")
//</editor-fold>
public static void LLVMAddCallSiteAttribute( LLVMOpaqueValue /*P*/ C, /*uint*/int Idx, 
                         LLVMOpaqueAttributeRef /*P*/ A) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetCallSiteAttributeCount">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2232,
 FQN="LLVMGetCallSiteAttributeCount", NM="_Z29LLVMGetCallSiteAttributeCount",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMGetCallSiteAttributeCount")
//</editor-fold>
public static /*uint*/int LLVMGetCallSiteAttributeCount( LLVMOpaqueValue /*P*/ C, 
                             /*uint*/int Idx) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetCallSiteAttributes">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2239,
 FQN="LLVMGetCallSiteAttributes", NM="_Z25LLVMGetCallSiteAttributes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMGetCallSiteAttributes")
//</editor-fold>
public static void LLVMGetCallSiteAttributes( LLVMOpaqueValue /*P*/ C, /*uint*/int Idx, 
                         type$ptr<LLVMOpaqueAttributeRef /*P*/ /*P*/> Attrs) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetCallSiteEnumAttribute">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2247,
 FQN="LLVMGetCallSiteEnumAttribute", NM="_Z28LLVMGetCallSiteEnumAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z28LLVMGetCallSiteEnumAttribute")
//</editor-fold>
public static  LLVMOpaqueAttributeRef /*P*/ LLVMGetCallSiteEnumAttribute( LLVMOpaqueValue /*P*/ C, 
                            /*uint*/int Idx, 
                            /*uint*/int KindID) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetCallSiteStringAttribute">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2254,
 FQN="LLVMGetCallSiteStringAttribute", NM="_Z30LLVMGetCallSiteStringAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z30LLVMGetCallSiteStringAttribute")
//</editor-fold>
public static  LLVMOpaqueAttributeRef /*P*/ LLVMGetCallSiteStringAttribute( LLVMOpaqueValue /*P*/ C, 
                              /*uint*/int Idx, 
                              /*const*/char$ptr/*char P*/ K, /*uint*/int KLen) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMRemoveCallSiteEnumAttribute">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2261,
 FQN="LLVMRemoveCallSiteEnumAttribute", NM="_Z31LLVMRemoveCallSiteEnumAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z31LLVMRemoveCallSiteEnumAttribute")
//</editor-fold>
public static void LLVMRemoveCallSiteEnumAttribute( LLVMOpaqueValue /*P*/ C, /*uint*/int Idx, 
                               /*uint*/int KindID) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMRemoveCallSiteStringAttribute">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2267,
 FQN="LLVMRemoveCallSiteStringAttribute", NM="_Z33LLVMRemoveCallSiteStringAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z33LLVMRemoveCallSiteStringAttribute")
//</editor-fold>
public static void LLVMRemoveCallSiteStringAttribute( LLVMOpaqueValue /*P*/ C, /*uint*/int Idx, 
                                 /*const*/char$ptr/*char P*/ K, /*uint*/int KLen) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2272,
 FQN="LLVMGetCalledValue", NM="_Z18LLVMGetCalledValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetCalledValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetCalledValue( LLVMOpaqueValue /*P*/ Instr) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain whether a call instruction is a tail call.
*
* This only works on llvm::CallInst instructions.
*
* @see llvm::CallInst::isTailCall()
*/

/**
* Obtain whether a call instruction is a tail call.
*
* This only works on llvm::CallInst instructions.
*
* @see llvm::CallInst::isTailCall()
*/

/*--.. Operations on call instructions (only) ..............................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsTailCall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2278,
 FQN="LLVMIsTailCall", NM="_Z14LLVMIsTailCall",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMIsTailCall")
//</editor-fold>
public static int LLVMIsTailCall( LLVMOpaqueValue /*P*/ Call) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set whether a call instruction is a tail call.
*
* This only works on llvm::CallInst instructions.
*
* @see llvm::CallInst::setTailCall()
*/

/**
* Set whether a call instruction is a tail call.
*
* This only works on llvm::CallInst instructions.
*
* @see llvm::CallInst::setTailCall()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetTailCall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2282,
 FQN="LLVMSetTailCall", NM="_Z15LLVMSetTailCall",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMSetTailCall")
//</editor-fold>
public static void LLVMSetTailCall( LLVMOpaqueValue /*P*/ Call, int isTailCall) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Return the normal destination basic block.
*
* This only works on llvm::InvokeInst instructions.
*
* @see llvm::InvokeInst::getNormalDest()
*/

/**
* Return the normal destination basic block.
*
* This only works on llvm::InvokeInst instructions.
*
* @see llvm::InvokeInst::getNormalDest()
*/

/*--.. Operations on invoke instructions (only) ............................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetNormalDest">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2288,
 FQN="LLVMGetNormalDest", NM="_Z17LLVMGetNormalDest",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetNormalDest")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetNormalDest( LLVMOpaqueValue /*P*/ Invoke) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Return the unwind destination basic block.
*
* This only works on llvm::InvokeInst instructions.
*
* @see llvm::InvokeInst::getUnwindDest()
*/

/**
* Return the unwind destination basic block.
*
* This only works on llvm::InvokeInst instructions.
*
* @see llvm::InvokeInst::getUnwindDest()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetUnwindDest">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2292,
 FQN="LLVMGetUnwindDest", NM="_Z17LLVMGetUnwindDest",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetUnwindDest")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetUnwindDest( LLVMOpaqueValue /*P*/ Invoke) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set the normal destination basic block.
*
* This only works on llvm::InvokeInst instructions.
*
* @see llvm::InvokeInst::setNormalDest()
*/

/**
* Set the normal destination basic block.
*
* This only works on llvm::InvokeInst instructions.
*
* @see llvm::InvokeInst::setNormalDest()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetNormalDest">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2296,
 FQN="LLVMSetNormalDest", NM="_Z17LLVMSetNormalDest",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMSetNormalDest")
//</editor-fold>
public static void LLVMSetNormalDest( LLVMOpaqueValue /*P*/ Invoke,  LLVMOpaqueBasicBlock /*P*/ B) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set the unwind destination basic block.
*
* This only works on llvm::InvokeInst instructions.
*
* @see llvm::InvokeInst::setUnwindDest()
*/

/**
* Set the unwind destination basic block.
*
* This only works on llvm::InvokeInst instructions.
*
* @see llvm::InvokeInst::setUnwindDest()
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetUnwindDest">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2300,
 FQN="LLVMSetUnwindDest", NM="_Z17LLVMSetUnwindDest",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMSetUnwindDest")
//</editor-fold>
public static void LLVMSetUnwindDest( LLVMOpaqueValue /*P*/ Invoke,  LLVMOpaqueBasicBlock /*P*/ B) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2306,
 FQN="LLVMGetNumSuccessors", NM="_Z20LLVMGetNumSuccessors",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetNumSuccessors")
//</editor-fold>
public static /*uint*/int LLVMGetNumSuccessors( LLVMOpaqueValue /*P*/ Term) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Return the specified successor.
*
* @see llvm::TerminatorInst::getSuccessor
*/

/**
* Return the specified successor.
*
* @see llvm::TerminatorInst::getSuccessor
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetSuccessor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2310,
 FQN="LLVMGetSuccessor", NM="_Z16LLVMGetSuccessor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMGetSuccessor")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetSuccessor( LLVMOpaqueValue /*P*/ Term, /*uint*/int i) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Update the specified successor to point at the provided block.
*
* @see llvm::TerminatorInst::setSuccessor
*/

/**
* Update the specified successor to point at the provided block.
*
* @see llvm::TerminatorInst::setSuccessor
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetSuccessor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2314,
 FQN="LLVMSetSuccessor", NM="_Z16LLVMSetSuccessor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMSetSuccessor")
//</editor-fold>
public static void LLVMSetSuccessor( LLVMOpaqueValue /*P*/ Term, /*uint*/int i,  LLVMOpaqueBasicBlock /*P*/ block) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Return if a branch is conditional.
*
* This only works on llvm::BranchInst instructions.
*
* @see llvm::BranchInst::isConditional
*/

/**
* Return if a branch is conditional.
*
* This only works on llvm::BranchInst instructions.
*
* @see llvm::BranchInst::isConditional
*/

/*--.. Operations on branch instructions (only) ............................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMIsConditional">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2320,
 FQN="LLVMIsConditional", NM="_Z17LLVMIsConditional",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMIsConditional")
//</editor-fold>
public static int LLVMIsConditional( LLVMOpaqueValue /*P*/ Branch) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Return the condition of a branch instruction.
*
* This only works on llvm::BranchInst instructions.
*
* @see llvm::BranchInst::getCondition
*/

/**
* Return the condition of a branch instruction.
*
* This only works on llvm::BranchInst instructions.
*
* @see llvm::BranchInst::getCondition
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetCondition">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2324,
 FQN="LLVMGetCondition", NM="_Z16LLVMGetCondition",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMGetCondition")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetCondition( LLVMOpaqueValue /*P*/ Branch) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set the condition of a branch instruction.
*
* This only works on llvm::BranchInst instructions.
*
* @see llvm::BranchInst::setCondition
*/

/**
* Set the condition of a branch instruction.
*
* This only works on llvm::BranchInst instructions.
*
* @see llvm::BranchInst::setCondition
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetCondition">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2328,
 FQN="LLVMSetCondition", NM="_Z16LLVMSetCondition",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMSetCondition")
//</editor-fold>
public static void LLVMSetCondition( LLVMOpaqueValue /*P*/ Branch,  LLVMOpaqueValue /*P*/ Cond) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the default destination basic block of a switch instruction.
*
* This only works on llvm::SwitchInst instructions.
*
* @see llvm::SwitchInst::getDefaultDest()
*/

/**
* Obtain the default destination basic block of a switch instruction.
*
* This only works on llvm::SwitchInst instructions.
*
* @see llvm::SwitchInst::getDefaultDest()
*/

/*--.. Operations on switch instructions (only) ............................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetSwitchDefaultDest">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2334,
 FQN="LLVMGetSwitchDefaultDest", NM="_Z24LLVMGetSwitchDefaultDest",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMGetSwitchDefaultDest")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetSwitchDefaultDest( LLVMOpaqueValue /*P*/ Switch) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2340,
 FQN="LLVMGetAllocatedType", NM="_Z20LLVMGetAllocatedType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetAllocatedType")
//</editor-fold>
public static  LLVMOpaqueType /*P*/ LLVMGetAllocatedType( LLVMOpaqueValue /*P*/ Alloca) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2346,
 FQN="LLVMIsInBounds", NM="_Z14LLVMIsInBounds",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMIsInBounds")
//</editor-fold>
public static int LLVMIsInBounds( LLVMOpaqueValue /*P*/ GEP) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set the given GEP instruction to be inbounds or not.
*/

/**
* Set the given GEP instruction to be inbounds or not.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetIsInBounds">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2350,
 FQN="LLVMSetIsInBounds", NM="_Z17LLVMSetIsInBounds",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMSetIsInBounds")
//</editor-fold>
public static void LLVMSetIsInBounds( LLVMOpaqueValue /*P*/ GEP, int InBounds) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2356,
 FQN="LLVMAddIncoming", NM="_Z15LLVMAddIncoming",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMAddIncoming")
//</editor-fold>
public static void LLVMAddIncoming( LLVMOpaqueValue /*P*/ PhiNode, type$ptr<LLVMOpaqueValue /*P*/ /*P*/> IncomingValues, 
               type$ptr<LLVMOpaqueBasicBlock /*P*/ /*P*/> IncomingBlocks, /*uint*/int Count) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the number of incoming basic blocks to a PHI node.
*/

/**
* Obtain the number of incoming basic blocks to a PHI node.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMCountIncoming">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2363,
 FQN="LLVMCountIncoming", NM="_Z17LLVMCountIncoming",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMCountIncoming")
//</editor-fold>
public static /*uint*/int LLVMCountIncoming( LLVMOpaqueValue /*P*/ PhiNode) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain an incoming value to a PHI node as an LLVMValueRef.
*/

/**
* Obtain an incoming value to a PHI node as an LLVMValueRef.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetIncomingValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2367,
 FQN="LLVMGetIncomingValue", NM="_Z20LLVMGetIncomingValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetIncomingValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetIncomingValue( LLVMOpaqueValue /*P*/ PhiNode, /*uint*/int Index) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain an incoming value to a PHI node as an LLVMBasicBlockRef.
*/

/**
* Obtain an incoming value to a PHI node as an LLVMBasicBlockRef.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetIncomingBlock">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2371,
 FQN="LLVMGetIncomingBlock", NM="_Z20LLVMGetIncomingBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMGetIncomingBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetIncomingBlock( LLVMOpaqueValue /*P*/ PhiNode, /*uint*/int Index) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2377,
 FQN="LLVMGetNumIndices", NM="_Z17LLVMGetNumIndices",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetNumIndices")
//</editor-fold>
public static /*uint*/int LLVMGetNumIndices( LLVMOpaqueValue /*P*/ Inst) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Obtain the indices as an array.
*/

/**
* Obtain the indices as an array.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMGetIndices">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2389,
 FQN="LLVMGetIndices", NM="_Z14LLVMGetIndices",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMGetIndices")
//</editor-fold>
public static /*const*/uint$ptr/*uint P*/ LLVMGetIndices( LLVMOpaqueValue /*P*/ Inst) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2402,
 FQN="LLVMCreateBuilderInContext", NM="_Z26LLVMCreateBuilderInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMCreateBuilderInContext")
//</editor-fold>
public static  LLVMOpaqueBuilder /*P*/ LLVMCreateBuilderInContext( LLVMOpaqueContext /*P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMCreateBuilder">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2406,
 FQN="LLVMCreateBuilder", NM="_Z17LLVMCreateBuilder",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMCreateBuilder")
//</editor-fold>
public static  LLVMOpaqueBuilder /*P*/ LLVMCreateBuilder() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMPositionBuilder">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2410,
 FQN="LLVMPositionBuilder", NM="_Z19LLVMPositionBuilder",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMPositionBuilder")
//</editor-fold>
public static void LLVMPositionBuilder( LLVMOpaqueBuilder /*P*/ Builder,  LLVMOpaqueBasicBlock /*P*/ Block, 
                    LLVMOpaqueValue /*P*/ Instr) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMPositionBuilderBefore">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2417,
 FQN="LLVMPositionBuilderBefore", NM="_Z25LLVMPositionBuilderBefore",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMPositionBuilderBefore")
//</editor-fold>
public static void LLVMPositionBuilderBefore( LLVMOpaqueBuilder /*P*/ Builder,  LLVMOpaqueValue /*P*/ Instr) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMPositionBuilderAtEnd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2422,
 FQN="LLVMPositionBuilderAtEnd", NM="_Z24LLVMPositionBuilderAtEnd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMPositionBuilderAtEnd")
//</editor-fold>
public static void LLVMPositionBuilderAtEnd( LLVMOpaqueBuilder /*P*/ Builder,  LLVMOpaqueBasicBlock /*P*/ Block) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetInsertBlock">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2427,
 FQN="LLVMGetInsertBlock", NM="_Z18LLVMGetInsertBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetInsertBlock")
//</editor-fold>
public static  LLVMOpaqueBasicBlock /*P*/ LLVMGetInsertBlock( LLVMOpaqueBuilder /*P*/ Builder) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMClearInsertionPosition">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2431,
 FQN="LLVMClearInsertionPosition", NM="_Z26LLVMClearInsertionPosition",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMClearInsertionPosition")
//</editor-fold>
public static void LLVMClearInsertionPosition( LLVMOpaqueBuilder /*P*/ Builder) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMInsertIntoBuilder">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2435,
 FQN="LLVMInsertIntoBuilder", NM="_Z21LLVMInsertIntoBuilder",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMInsertIntoBuilder")
//</editor-fold>
public static void LLVMInsertIntoBuilder( LLVMOpaqueBuilder /*P*/ Builder,  LLVMOpaqueValue /*P*/ Instr) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMInsertIntoBuilderWithName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2439,
 FQN="LLVMInsertIntoBuilderWithName", NM="_Z29LLVMInsertIntoBuilderWithName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMInsertIntoBuilderWithName")
//</editor-fold>
public static void LLVMInsertIntoBuilderWithName( LLVMOpaqueBuilder /*P*/ Builder,  LLVMOpaqueValue /*P*/ Instr, 
                             /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMDisposeBuilder">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2444,
 FQN="LLVMDisposeBuilder", NM="_Z18LLVMDisposeBuilder",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMDisposeBuilder")
//</editor-fold>
public static void LLVMDisposeBuilder( LLVMOpaqueBuilder /*P*/ Builder) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Metadata */

/* Metadata */

/*--.. Metadata builders ...................................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMSetCurrentDebugLocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2450,
 FQN="LLVMSetCurrentDebugLocation", NM="_Z27LLVMSetCurrentDebugLocation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMSetCurrentDebugLocation")
//</editor-fold>
public static void LLVMSetCurrentDebugLocation( LLVMOpaqueBuilder /*P*/ Builder,  LLVMOpaqueValue /*P*/ L) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetCurrentDebugLocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2456,
 FQN="LLVMGetCurrentDebugLocation", NM="_Z27LLVMGetCurrentDebugLocation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z27LLVMGetCurrentDebugLocation")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetCurrentDebugLocation( LLVMOpaqueBuilder /*P*/ Builder) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetInstDebugLocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2462,
 FQN="LLVMSetInstDebugLocation", NM="_Z24LLVMSetInstDebugLocation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMSetInstDebugLocation")
//</editor-fold>
public static void LLVMSetInstDebugLocation( LLVMOpaqueBuilder /*P*/ Builder,  LLVMOpaqueValue /*P*/ Inst) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Terminators */

/* Terminators */

/*--.. Instruction builders ................................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMBuildRetVoid">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2469,
 FQN="LLVMBuildRetVoid", NM="_Z16LLVMBuildRetVoid",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMBuildRetVoid")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildRetVoid( LLVMOpaqueBuilder /*P*/ B) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildRet">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2473,
 FQN="LLVMBuildRet", NM="_Z12LLVMBuildRet",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildRet")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildRet( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildAggregateRet">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2477,
 FQN="LLVMBuildAggregateRet", NM="_Z21LLVMBuildAggregateRet",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMBuildAggregateRet")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildAggregateRet( LLVMOpaqueBuilder /*P*/ B, type$ptr<LLVMOpaqueValue /*P*/ /*P*/> RetVals, 
                     /*uint*/int N) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildBr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2482,
 FQN="LLVMBuildBr", NM="_Z11LLVMBuildBr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z11LLVMBuildBr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildBr( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueBasicBlock /*P*/ Dest) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildCondBr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2486,
 FQN="LLVMBuildCondBr", NM="_Z15LLVMBuildCondBr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildCondBr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildCondBr( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ If, 
                LLVMOpaqueBasicBlock /*P*/ Then,  LLVMOpaqueBasicBlock /*P*/ Else) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildSwitch">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2491,
 FQN="LLVMBuildSwitch", NM="_Z15LLVMBuildSwitch",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildSwitch")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildSwitch( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ V, 
                LLVMOpaqueBasicBlock /*P*/ Else, /*uint*/int NumCases) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildIndirectBr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2496,
 FQN="LLVMBuildIndirectBr", NM="_Z19LLVMBuildIndirectBr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMBuildIndirectBr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildIndirectBr( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Addr, 
                   /*uint*/int NumDests) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildInvoke">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2501,
 FQN="LLVMBuildInvoke", NM="_Z15LLVMBuildInvoke",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildInvoke")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildInvoke( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Fn, 
               type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Args, /*uint*/int NumArgs, 
                LLVMOpaqueBasicBlock /*P*/ Then,  LLVMOpaqueBasicBlock /*P*/ Catch, 
               /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildLandingPad">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2510,
 FQN="LLVMBuildLandingPad", NM="_Z19LLVMBuildLandingPad",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMBuildLandingPad")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildLandingPad( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueType /*P*/ Ty, 
                    LLVMOpaqueValue /*P*/ PersFn, /*uint*/int NumClauses, 
                   /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildResume">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2522,
 FQN="LLVMBuildResume", NM="_Z15LLVMBuildResume",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildResume")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildResume( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Exn) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildUnreachable">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2526,
 FQN="LLVMBuildUnreachable", NM="_Z20LLVMBuildUnreachable",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMBuildUnreachable")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildUnreachable( LLVMOpaqueBuilder /*P*/ B) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Add a case to the switch instruction */

/* Add a case to the switch instruction */
//<editor-fold defaultstate="collapsed" desc="LLVMAddCase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2530,
 FQN="LLVMAddCase", NM="_Z11LLVMAddCase",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z11LLVMAddCase")
//</editor-fold>
public static void LLVMAddCase( LLVMOpaqueValue /*P*/ Switch,  LLVMOpaqueValue /*P*/ OnVal, 
            LLVMOpaqueBasicBlock /*P*/ Dest) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Add a destination to the indirectbr instruction */

/* Add a destination to the indirectbr instruction */
//<editor-fold defaultstate="collapsed" desc="LLVMAddDestination">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2535,
 FQN="LLVMAddDestination", NM="_Z18LLVMAddDestination",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMAddDestination")
//</editor-fold>
public static void LLVMAddDestination( LLVMOpaqueValue /*P*/ IndirectBr,  LLVMOpaqueBasicBlock /*P*/ Dest) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Get the number of clauses on the landingpad instruction */

/* Get the number of clauses on the landingpad instruction */
//<editor-fold defaultstate="collapsed" desc="LLVMGetNumClauses">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2539,
 FQN="LLVMGetNumClauses", NM="_Z17LLVMGetNumClauses",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetNumClauses")
//</editor-fold>
public static /*uint*/int LLVMGetNumClauses( LLVMOpaqueValue /*P*/ LandingPad) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Get the value of the clause at idnex Idx on the landingpad instruction */

/* Get the value of the clause at idnex Idx on the landingpad instruction */
//<editor-fold defaultstate="collapsed" desc="LLVMGetClause">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2543,
 FQN="LLVMGetClause", NM="_Z13LLVMGetClause",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMGetClause")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMGetClause( LLVMOpaqueValue /*P*/ LandingPad, /*uint*/int Idx) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Add a catch or filter clause to the landingpad instruction */

/* Add a catch or filter clause to the landingpad instruction */
//<editor-fold defaultstate="collapsed" desc="LLVMAddClause">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2547,
 FQN="LLVMAddClause", NM="_Z13LLVMAddClause",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMAddClause")
//</editor-fold>
public static void LLVMAddClause( LLVMOpaqueValue /*P*/ LandingPad,  LLVMOpaqueValue /*P*/ ClauseVal) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Get the 'cleanup' flag in the landingpad instruction */

/* Get the 'cleanup' flag in the landingpad instruction */
//<editor-fold defaultstate="collapsed" desc="LLVMIsCleanup">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2552,
 FQN="LLVMIsCleanup", NM="_Z13LLVMIsCleanup",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMIsCleanup")
//</editor-fold>
public static int LLVMIsCleanup( LLVMOpaqueValue /*P*/ LandingPad) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Set the 'cleanup' flag in the landingpad instruction */

/* Set the 'cleanup' flag in the landingpad instruction */
//<editor-fold defaultstate="collapsed" desc="LLVMSetCleanup">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2556,
 FQN="LLVMSetCleanup", NM="_Z14LLVMSetCleanup",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMSetCleanup")
//</editor-fold>
public static void LLVMSetCleanup( LLVMOpaqueValue /*P*/ LandingPad, int Val) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Arithmetic */

/* Arithmetic */

/*--.. Arithmetic ..........................................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMBuildAdd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2562,
 FQN="LLVMBuildAdd", NM="_Z12LLVMBuildAdd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildAdd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildAdd( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
            /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNSWAdd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2567,
 FQN="LLVMBuildNSWAdd", NM="_Z15LLVMBuildNSWAdd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildNSWAdd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNSWAdd( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
               /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNUWAdd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2572,
 FQN="LLVMBuildNUWAdd", NM="_Z15LLVMBuildNUWAdd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildNUWAdd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNUWAdd( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
               /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFAdd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2577,
 FQN="LLVMBuildFAdd", NM="_Z13LLVMBuildFAdd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildFAdd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFAdd( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildSub">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2582,
 FQN="LLVMBuildSub", NM="_Z12LLVMBuildSub",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildSub")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildSub( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
            /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNSWSub">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2587,
 FQN="LLVMBuildNSWSub", NM="_Z15LLVMBuildNSWSub",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildNSWSub")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNSWSub( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
               /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNUWSub">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2592,
 FQN="LLVMBuildNUWSub", NM="_Z15LLVMBuildNUWSub",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildNUWSub")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNUWSub( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
               /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFSub">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2597,
 FQN="LLVMBuildFSub", NM="_Z13LLVMBuildFSub",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildFSub")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFSub( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildMul">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2602,
 FQN="LLVMBuildMul", NM="_Z12LLVMBuildMul",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildMul")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildMul( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
            /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNSWMul">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2607,
 FQN="LLVMBuildNSWMul", NM="_Z15LLVMBuildNSWMul",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildNSWMul")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNSWMul( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
               /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNUWMul">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2612,
 FQN="LLVMBuildNUWMul", NM="_Z15LLVMBuildNUWMul",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildNUWMul")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNUWMul( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
               /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFMul">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2617,
 FQN="LLVMBuildFMul", NM="_Z13LLVMBuildFMul",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildFMul")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFMul( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildUDiv">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2622,
 FQN="LLVMBuildUDiv", NM="_Z13LLVMBuildUDiv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildUDiv")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildUDiv( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildSDiv">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2627,
 FQN="LLVMBuildSDiv", NM="_Z13LLVMBuildSDiv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildSDiv")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildSDiv( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildExactSDiv">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2632,
 FQN="LLVMBuildExactSDiv", NM="_Z18LLVMBuildExactSDiv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMBuildExactSDiv")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildExactSDiv( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS, 
                   LLVMOpaqueValue /*P*/ RHS, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFDiv">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2637,
 FQN="LLVMBuildFDiv", NM="_Z13LLVMBuildFDiv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildFDiv")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFDiv( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildURem">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2642,
 FQN="LLVMBuildURem", NM="_Z13LLVMBuildURem",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildURem")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildURem( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildSRem">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2647,
 FQN="LLVMBuildSRem", NM="_Z13LLVMBuildSRem",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildSRem")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildSRem( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFRem">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2652,
 FQN="LLVMBuildFRem", NM="_Z13LLVMBuildFRem",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildFRem")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFRem( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildShl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2657,
 FQN="LLVMBuildShl", NM="_Z12LLVMBuildShl",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildShl")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildShl( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
            /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildLShr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2662,
 FQN="LLVMBuildLShr", NM="_Z13LLVMBuildLShr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildLShr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildLShr( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildAShr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2667,
 FQN="LLVMBuildAShr", NM="_Z13LLVMBuildAShr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildAShr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildAShr( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildAnd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2672,
 FQN="LLVMBuildAnd", NM="_Z12LLVMBuildAnd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildAnd")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildAnd( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
            /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildOr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2677,
 FQN="LLVMBuildOr", NM="_Z11LLVMBuildOr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z11LLVMBuildOr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildOr( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
           /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildXor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2682,
 FQN="LLVMBuildXor", NM="_Z12LLVMBuildXor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildXor")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildXor( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
            /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildBinOp">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2687,
 FQN="LLVMBuildBinOp", NM="_Z14LLVMBuildBinOp",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMBuildBinOp")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildBinOp( LLVMOpaqueBuilder /*P*/ B, LLVMOpcode Op, 
               LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
              /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNeg">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2694,
 FQN="LLVMBuildNeg", NM="_Z12LLVMBuildNeg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildNeg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNeg( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ V, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNSWNeg">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2698,
 FQN="LLVMBuildNSWNeg", NM="_Z15LLVMBuildNSWNeg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildNSWNeg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNSWNeg( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ V, 
               /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNUWNeg">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2703,
 FQN="LLVMBuildNUWNeg", NM="_Z15LLVMBuildNUWNeg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildNUWNeg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNUWNeg( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ V, 
               /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFNeg">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2708,
 FQN="LLVMBuildFNeg", NM="_Z13LLVMBuildFNeg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildFNeg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFNeg( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ V, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildNot">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2712,
 FQN="LLVMBuildNot", NM="_Z12LLVMBuildNot",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildNot")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildNot( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ V, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Memory */

/* Memory */

/*--.. Memory ..............................................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMBuildMalloc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2718,
 FQN="LLVMBuildMalloc", NM="_Z15LLVMBuildMalloc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildMalloc")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildMalloc( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueType /*P*/ Ty, 
               /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildArrayMalloc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2729,
 FQN="LLVMBuildArrayMalloc", NM="_Z20LLVMBuildArrayMalloc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMBuildArrayMalloc")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildArrayMalloc( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueType /*P*/ Ty, 
                     LLVMOpaqueValue /*P*/ Val, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildAlloca">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2740,
 FQN="LLVMBuildAlloca", NM="_Z15LLVMBuildAlloca",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildAlloca")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildAlloca( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueType /*P*/ Ty, 
               /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildArrayAlloca">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2745,
 FQN="LLVMBuildArrayAlloca", NM="_Z20LLVMBuildArrayAlloca",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMBuildArrayAlloca")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildArrayAlloca( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueType /*P*/ Ty, 
                     LLVMOpaqueValue /*P*/ Val, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFree">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2750,
 FQN="LLVMBuildFree", NM="_Z13LLVMBuildFree",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildFree")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFree( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ PointerVal) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildLoad">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2755,
 FQN="LLVMBuildLoad", NM="_Z13LLVMBuildLoad",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildLoad")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildLoad( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ PointerVal, 
             /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildStore">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2760,
 FQN="LLVMBuildStore", NM="_Z14LLVMBuildStore",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMBuildStore")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildStore( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
               LLVMOpaqueValue /*P*/ PointerVal) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildGEP">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2805,
 FQN="LLVMBuildGEP", NM="_Z12LLVMBuildGEP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildGEP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildGEP( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Pointer, 
            type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Indices, /*uint*/int NumIndices, 
            /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildInBoundsGEP">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2812,
 FQN="LLVMBuildInBoundsGEP", NM="_Z20LLVMBuildInBoundsGEP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMBuildInBoundsGEP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildInBoundsGEP( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Pointer, 
                    type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Indices, /*uint*/int NumIndices, 
                    /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildStructGEP">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2820,
 FQN="LLVMBuildStructGEP", NM="_Z18LLVMBuildStructGEP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMBuildStructGEP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildStructGEP( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Pointer, 
                  /*uint*/int Idx, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildGlobalString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2825,
 FQN="LLVMBuildGlobalString", NM="_Z21LLVMBuildGlobalString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMBuildGlobalString")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildGlobalString( LLVMOpaqueBuilder /*P*/ B, /*const*/char$ptr/*char P*/ Str, 
                     /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildGlobalStringPtr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2830,
 FQN="LLVMBuildGlobalStringPtr", NM="_Z24LLVMBuildGlobalStringPtr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMBuildGlobalStringPtr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildGlobalStringPtr( LLVMOpaqueBuilder /*P*/ B, /*const*/char$ptr/*char P*/ Str, 
                        /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetVolatile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2835,
 FQN="LLVMGetVolatile", NM="_Z15LLVMGetVolatile",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMGetVolatile")
//</editor-fold>
public static int LLVMGetVolatile( LLVMOpaqueValue /*P*/ MemAccessInst) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetVolatile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2842,
 FQN="LLVMSetVolatile", NM="_Z15LLVMSetVolatile",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMSetVolatile")
//</editor-fold>
public static void LLVMSetVolatile( LLVMOpaqueValue /*P*/ MemAccessInst, int isVolatile) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetOrdering">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2849,
 FQN="LLVMGetOrdering", NM="_Z15LLVMGetOrdering",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMGetOrdering")
//</editor-fold>
public static LLVMAtomicOrdering LLVMGetOrdering( LLVMOpaqueValue /*P*/ MemAccessInst) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetOrdering">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2859,
 FQN="LLVMSetOrdering", NM="_Z15LLVMSetOrdering",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMSetOrdering")
//</editor-fold>
public static void LLVMSetOrdering( LLVMOpaqueValue /*P*/ MemAccessInst, LLVMAtomicOrdering Ordering) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Casts */

/* Casts */

/*--.. Casts ...............................................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMBuildTrunc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2870,
 FQN="LLVMBuildTrunc", NM="_Z14LLVMBuildTrunc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMBuildTrunc")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildTrunc( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
               LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildZExt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2875,
 FQN="LLVMBuildZExt", NM="_Z13LLVMBuildZExt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildZExt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildZExt( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
              LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildSExt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2880,
 FQN="LLVMBuildSExt", NM="_Z13LLVMBuildSExt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildSExt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildSExt( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
              LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFPToUI">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2885,
 FQN="LLVMBuildFPToUI", NM="_Z15LLVMBuildFPToUI",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildFPToUI")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFPToUI( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFPToSI">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2890,
 FQN="LLVMBuildFPToSI", NM="_Z15LLVMBuildFPToSI",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildFPToSI")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFPToSI( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildUIToFP">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2895,
 FQN="LLVMBuildUIToFP", NM="_Z15LLVMBuildUIToFP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildUIToFP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildUIToFP( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildSIToFP">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2900,
 FQN="LLVMBuildSIToFP", NM="_Z15LLVMBuildSIToFP",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildSIToFP")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildSIToFP( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFPTrunc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2905,
 FQN="LLVMBuildFPTrunc", NM="_Z16LLVMBuildFPTrunc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMBuildFPTrunc")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFPTrunc( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                 LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFPExt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2910,
 FQN="LLVMBuildFPExt", NM="_Z14LLVMBuildFPExt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMBuildFPExt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFPExt( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
               LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildPtrToInt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2915,
 FQN="LLVMBuildPtrToInt", NM="_Z17LLVMBuildPtrToInt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMBuildPtrToInt")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildPtrToInt( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                  LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildIntToPtr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2920,
 FQN="LLVMBuildIntToPtr", NM="_Z17LLVMBuildIntToPtr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMBuildIntToPtr")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildIntToPtr( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                  LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildBitCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2925,
 FQN="LLVMBuildBitCast", NM="_Z16LLVMBuildBitCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMBuildBitCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildBitCast( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                 LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildAddrSpaceCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2930,
 FQN="LLVMBuildAddrSpaceCast", NM="_Z22LLVMBuildAddrSpaceCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMBuildAddrSpaceCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildAddrSpaceCast( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                       LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildZExtOrBitCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2935,
 FQN="LLVMBuildZExtOrBitCast", NM="_Z22LLVMBuildZExtOrBitCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMBuildZExtOrBitCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildZExtOrBitCast( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                       LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildSExtOrBitCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2941,
 FQN="LLVMBuildSExtOrBitCast", NM="_Z22LLVMBuildSExtOrBitCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMBuildSExtOrBitCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildSExtOrBitCast( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                       LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildTruncOrBitCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2947,
 FQN="LLVMBuildTruncOrBitCast", NM="_Z23LLVMBuildTruncOrBitCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMBuildTruncOrBitCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildTruncOrBitCast( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                        LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2953,
 FQN="LLVMBuildCast", NM="_Z13LLVMBuildCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildCast( LLVMOpaqueBuilder /*P*/ B, LLVMOpcode Op,  LLVMOpaqueValue /*P*/ Val, 
              LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildPointerCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2959,
 FQN="LLVMBuildPointerCast", NM="_Z20LLVMBuildPointerCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMBuildPointerCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildPointerCast( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                     LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildIntCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2964,
 FQN="LLVMBuildIntCast", NM="_Z16LLVMBuildIntCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMBuildIntCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildIntCast( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                 LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFPCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2970,
 FQN="LLVMBuildFPCast", NM="_Z15LLVMBuildFPCast",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildFPCast")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFPCast( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                LLVMOpaqueType /*P*/ DestTy, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Comparisons */

/* Comparisons */

/*--.. Comparisons .........................................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMBuildICmp">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2977,
 FQN="LLVMBuildICmp", NM="_Z13LLVMBuildICmp",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildICmp")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildICmp( LLVMOpaqueBuilder /*P*/ B, LLVMIntPredicate Op, 
              LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFCmp">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2984,
 FQN="LLVMBuildFCmp", NM="_Z13LLVMBuildFCmp",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildFCmp")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFCmp( LLVMOpaqueBuilder /*P*/ B, LLVMRealPredicate Op, 
              LLVMOpaqueValue /*P*/ LHS,  LLVMOpaqueValue /*P*/ RHS, 
             /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Miscellaneous instructions */

/* Miscellaneous instructions */

/*--.. Miscellaneous instructions ..........................................--*/
//<editor-fold defaultstate="collapsed" desc="LLVMBuildPhi">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2993,
 FQN="LLVMBuildPhi", NM="_Z12LLVMBuildPhi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z12LLVMBuildPhi")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildPhi( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueType /*P*/ Ty, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildCall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2997,
 FQN="LLVMBuildCall", NM="_Z13LLVMBuildCall",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z13LLVMBuildCall")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildCall( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Fn, 
             type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Args, /*uint*/int NumArgs, 
             /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildSelect">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3005,
 FQN="LLVMBuildSelect", NM="_Z15LLVMBuildSelect",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildSelect")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildSelect( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ If, 
                LLVMOpaqueValue /*P*/ Then,  LLVMOpaqueValue /*P*/ Else, 
               /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildVAArg">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3012,
 FQN="LLVMBuildVAArg", NM="_Z14LLVMBuildVAArg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMBuildVAArg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildVAArg( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ List, 
               LLVMOpaqueType /*P*/ Ty, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildExtractElement">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3017,
 FQN="LLVMBuildExtractElement", NM="_Z23LLVMBuildExtractElement",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMBuildExtractElement")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildExtractElement( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ VecVal, 
                        LLVMOpaqueValue /*P*/ Index, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildInsertElement">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3023,
 FQN="LLVMBuildInsertElement", NM="_Z22LLVMBuildInsertElement",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMBuildInsertElement")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildInsertElement( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ VecVal, 
                       LLVMOpaqueValue /*P*/ EltVal,  LLVMOpaqueValue /*P*/ Index, 
                      /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildShuffleVector">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3030,
 FQN="LLVMBuildShuffleVector", NM="_Z22LLVMBuildShuffleVector",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMBuildShuffleVector")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildShuffleVector( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ V1, 
                       LLVMOpaqueValue /*P*/ V2,  LLVMOpaqueValue /*P*/ Mask, 
                      /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildExtractValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3037,
 FQN="LLVMBuildExtractValue", NM="_Z21LLVMBuildExtractValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMBuildExtractValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildExtractValue( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ AggVal, 
                     /*uint*/int Index, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildInsertValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3042,
 FQN="LLVMBuildInsertValue", NM="_Z20LLVMBuildInsertValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z20LLVMBuildInsertValue")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildInsertValue( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ AggVal, 
                     LLVMOpaqueValue /*P*/ EltVal, /*uint*/int Index, 
                    /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildIsNull">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3049,
 FQN="LLVMBuildIsNull", NM="_Z15LLVMBuildIsNull",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z15LLVMBuildIsNull")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildIsNull( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
               /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildIsNotNull">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3054,
 FQN="LLVMBuildIsNotNull", NM="_Z18LLVMBuildIsNotNull",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMBuildIsNotNull")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildIsNotNull( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Val, 
                  /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildPtrDiff">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3059,
 FQN="LLVMBuildPtrDiff", NM="_Z16LLVMBuildPtrDiff",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z16LLVMBuildPtrDiff")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildPtrDiff( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ LHS, 
                 LLVMOpaqueValue /*P*/ RHS, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildFence">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 2797,
 FQN="LLVMBuildFence", NM="_Z14LLVMBuildFence",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z14LLVMBuildFence")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildFence( LLVMOpaqueBuilder /*P*/ B, LLVMAtomicOrdering Ordering, 
              int isSingleThread, /*const*/char$ptr/*char P*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildAtomicRMW">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3064,
 FQN="LLVMBuildAtomicRMW", NM="_Z18LLVMBuildAtomicRMW",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMBuildAtomicRMW")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildAtomicRMW( LLVMOpaqueBuilder /*P*/ B, LLVMAtomicRMWBinOp op, 
                   LLVMOpaqueValue /*P*/ PTR,  LLVMOpaqueValue /*P*/ Val, 
                  LLVMAtomicOrdering ordering, 
                  int singleThread) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMBuildAtomicCmpXchg">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3086,
 FQN="LLVMBuildAtomicCmpXchg", NM="_Z22LLVMBuildAtomicCmpXchg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMBuildAtomicCmpXchg")
//</editor-fold>
public static  LLVMOpaqueValue /*P*/ LLVMBuildAtomicCmpXchg( LLVMOpaqueBuilder /*P*/ B,  LLVMOpaqueValue /*P*/ Ptr, 
                       LLVMOpaqueValue /*P*/ Cmp,  LLVMOpaqueValue /*P*/ New, 
                      LLVMAtomicOrdering SuccessOrdering, 
                      LLVMAtomicOrdering FailureOrdering, 
                      int singleThread) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMIsAtomicSingleThread">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3099,
 FQN="LLVMIsAtomicSingleThread", NM="_Z24LLVMIsAtomicSingleThread",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z24LLVMIsAtomicSingleThread")
//</editor-fold>
public static int LLVMIsAtomicSingleThread( LLVMOpaqueValue /*P*/ AtomicInst) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetAtomicSingleThread">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3107,
 FQN="LLVMSetAtomicSingleThread", NM="_Z25LLVMSetAtomicSingleThread",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMSetAtomicSingleThread")
//</editor-fold>
public static void LLVMSetAtomicSingleThread( LLVMOpaqueValue /*P*/ AtomicInst, int NewValue) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetCmpXchgSuccessOrdering">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3116,
 FQN="LLVMGetCmpXchgSuccessOrdering", NM="_Z29LLVMGetCmpXchgSuccessOrdering",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMGetCmpXchgSuccessOrdering")
//</editor-fold>
public static LLVMAtomicOrdering LLVMGetCmpXchgSuccessOrdering( LLVMOpaqueValue /*P*/ CmpXchgInst) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetCmpXchgSuccessOrdering">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3121,
 FQN="LLVMSetCmpXchgSuccessOrdering", NM="_Z29LLVMSetCmpXchgSuccessOrdering",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMSetCmpXchgSuccessOrdering")
//</editor-fold>
public static void LLVMSetCmpXchgSuccessOrdering( LLVMOpaqueValue /*P*/ CmpXchgInst, 
                             LLVMAtomicOrdering Ordering) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetCmpXchgFailureOrdering">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3129,
 FQN="LLVMGetCmpXchgFailureOrdering", NM="_Z29LLVMGetCmpXchgFailureOrdering",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMGetCmpXchgFailureOrdering")
//</editor-fold>
public static LLVMAtomicOrdering LLVMGetCmpXchgFailureOrdering( LLVMOpaqueValue /*P*/ CmpXchgInst) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMSetCmpXchgFailureOrdering">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3134,
 FQN="LLVMSetCmpXchgFailureOrdering", NM="_Z29LLVMSetCmpXchgFailureOrdering",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMSetCmpXchgFailureOrdering")
//</editor-fold>
public static void LLVMSetCmpXchgFailureOrdering( LLVMOpaqueValue /*P*/ CmpXchgInst, 
                             LLVMAtomicOrdering Ordering) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3144,
 FQN="LLVMCreateModuleProviderForExistingModule", NM="_Z41LLVMCreateModuleProviderForExistingModule",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z41LLVMCreateModuleProviderForExistingModule")
//</editor-fold>
public static  LLVMOpaqueModuleProvider /*P*/ LLVMCreateModuleProviderForExistingModule( LLVMOpaqueModule /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Destroys the module M.
*/

/**
* Destroys the module M.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMDisposeModuleProvider">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3149,
 FQN="LLVMDisposeModuleProvider", NM="_Z25LLVMDisposeModuleProvider",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMDisposeModuleProvider")
//</editor-fold>
public static void LLVMDisposeModuleProvider( LLVMOpaqueModuleProvider /*P*/ MP) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* @}
*/

/**
* @defgroup LLVMCCoreMemoryBuffers Memory Buffers
*
* @{
*/

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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3156,
 FQN="LLVMCreateMemoryBufferWithContentsOfFile", NM="_Z40LLVMCreateMemoryBufferWithContentsOfFile",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z40LLVMCreateMemoryBufferWithContentsOfFile")
//</editor-fold>
public static int LLVMCreateMemoryBufferWithContentsOfFile(/*const*/char$ptr/*char P*/ Path, 
                                        type$ptr<LLVMOpaqueMemoryBuffer /*P*/ /*P*/> OutMemBuf, 
                                        type$ptr<char$ptr>/*char PP*/ OutMessage) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMCreateMemoryBufferWithSTDIN">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3170,
 FQN="LLVMCreateMemoryBufferWithSTDIN", NM="_Z31LLVMCreateMemoryBufferWithSTDIN",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z31LLVMCreateMemoryBufferWithSTDIN")
//</editor-fold>
public static int LLVMCreateMemoryBufferWithSTDIN(type$ptr<LLVMOpaqueMemoryBuffer /*P*/ /*P*/> OutMemBuf, 
                               type$ptr<char$ptr>/*char PP*/ OutMessage) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMCreateMemoryBufferWithMemoryRange">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3181,
 FQN="LLVMCreateMemoryBufferWithMemoryRange", NM="_Z37LLVMCreateMemoryBufferWithMemoryRange",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z37LLVMCreateMemoryBufferWithMemoryRange")
//</editor-fold>
public static  LLVMOpaqueMemoryBuffer /*P*/ LLVMCreateMemoryBufferWithMemoryRange(/*const*/char$ptr/*char P*/ InputData, 
                                     /*size_t*/int InputDataLength, 
                                     /*const*/char$ptr/*char P*/ BufferName, 
                                     int RequiresNullTerminator) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMCreateMemoryBufferWithMemoryRangeCopy">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3192,
 FQN="LLVMCreateMemoryBufferWithMemoryRangeCopy", NM="_Z41LLVMCreateMemoryBufferWithMemoryRangeCopy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z41LLVMCreateMemoryBufferWithMemoryRangeCopy")
//</editor-fold>
public static  LLVMOpaqueMemoryBuffer /*P*/ LLVMCreateMemoryBufferWithMemoryRangeCopy(/*const*/char$ptr/*char P*/ InputData, 
                                         /*size_t*/int InputDataLength, 
                                         /*const*/char$ptr/*char P*/ BufferName) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetBufferStart">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3202,
 FQN="LLVMGetBufferStart", NM="_Z18LLVMGetBufferStart",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMGetBufferStart")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LLVMGetBufferStart( LLVMOpaqueMemoryBuffer /*P*/ MemBuf) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetBufferSize">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3206,
 FQN="LLVMGetBufferSize", NM="_Z17LLVMGetBufferSize",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z17LLVMGetBufferSize")
//</editor-fold>
public static /*size_t*/int LLVMGetBufferSize( LLVMOpaqueMemoryBuffer /*P*/ MemBuf) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMDisposeMemoryBuffer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3210,
 FQN="LLVMDisposeMemoryBuffer", NM="_Z23LLVMDisposeMemoryBuffer",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z23LLVMDisposeMemoryBuffer")
//</editor-fold>
public static void LLVMDisposeMemoryBuffer( LLVMOpaqueMemoryBuffer /*P*/ MemBuf) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3216,
 FQN="LLVMGetGlobalPassRegistry", NM="_Z25LLVMGetGlobalPassRegistry",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z25LLVMGetGlobalPassRegistry")
//</editor-fold>
public static  LLVMOpaquePassRegistry /*P*/ LLVMGetGlobalPassRegistry() {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3222,
 FQN="LLVMCreatePassManager", NM="_Z21LLVMCreatePassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMCreatePassManager")
//</editor-fold>
public static  LLVMOpaquePassManager /*P*/ LLVMCreatePassManager() {
  throw new UnsupportedOperationException("EmptyBody");
}


/** Constructs a new function-by-function pass pipeline over the module
provider. It does not take ownership of the module provider. This type of
pipeline is suitable for code generation and JIT compilation tasks.
@see llvm::FunctionPassManager::FunctionPassManager */

/** Constructs a new function-by-function pass pipeline over the module
provider. It does not take ownership of the module provider. This type of
pipeline is suitable for code generation and JIT compilation tasks.
@see llvm::FunctionPassManager::FunctionPassManager */
//<editor-fold defaultstate="collapsed" desc="LLVMCreateFunctionPassManagerForModule">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3226,
 FQN="LLVMCreateFunctionPassManagerForModule", NM="_Z38LLVMCreateFunctionPassManagerForModule",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z38LLVMCreateFunctionPassManagerForModule")
//</editor-fold>
public static  LLVMOpaquePassManager /*P*/ LLVMCreateFunctionPassManagerForModule( LLVMOpaqueModule /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** Deprecated: Use LLVMCreateFunctionPassManagerForModule instead. */

/** Deprecated: Use LLVMCreateFunctionPassManagerForModule instead. */
//<editor-fold defaultstate="collapsed" desc="LLVMCreateFunctionPassManager">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3230,
 FQN="LLVMCreateFunctionPassManager", NM="_Z29LLVMCreateFunctionPassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z29LLVMCreateFunctionPassManager")
//</editor-fold>
public static  LLVMOpaquePassManager /*P*/ LLVMCreateFunctionPassManager( LLVMOpaqueModuleProvider /*P*/ P) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** Initializes, executes on the provided module, and finalizes all of the
passes scheduled in the pass manager. Returns 1 if any of the passes
modified the module, 0 otherwise.
@see llvm::PassManager::run(Module&) */

/** Initializes, executes on the provided module, and finalizes all of the
passes scheduled in the pass manager. Returns 1 if any of the passes
modified the module, 0 otherwise.
@see llvm::PassManager::run(Module&) */
//<editor-fold defaultstate="collapsed" desc="LLVMRunPassManager">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3235,
 FQN="LLVMRunPassManager", NM="_Z18LLVMRunPassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z18LLVMRunPassManager")
//</editor-fold>
public static int LLVMRunPassManager( LLVMOpaquePassManager /*P*/ PM,  LLVMOpaqueModule /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** Initializes all of the function passes scheduled in the function pass
manager. Returns 1 if any of the passes modified the module, 0 otherwise.
@see llvm::FunctionPassManager::doInitialization */

/** Initializes all of the function passes scheduled in the function pass
manager. Returns 1 if any of the passes modified the module, 0 otherwise.
@see llvm::FunctionPassManager::doInitialization */
//<editor-fold defaultstate="collapsed" desc="LLVMInitializeFunctionPassManager">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3239,
 FQN="LLVMInitializeFunctionPassManager", NM="_Z33LLVMInitializeFunctionPassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z33LLVMInitializeFunctionPassManager")
//</editor-fold>
public static int LLVMInitializeFunctionPassManager( LLVMOpaquePassManager /*P*/ FPM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** Executes all of the function passes scheduled in the function pass manager
on the provided function. Returns 1 if any of the passes modified the
function, false otherwise.
@see llvm::FunctionPassManager::run(Function&) */

/** Executes all of the function passes scheduled in the function pass manager
on the provided function. Returns 1 if any of the passes modified the
function, false otherwise.
@see llvm::FunctionPassManager::run(Function&) */
//<editor-fold defaultstate="collapsed" desc="LLVMRunFunctionPassManager">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3243,
 FQN="LLVMRunFunctionPassManager", NM="_Z26LLVMRunFunctionPassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z26LLVMRunFunctionPassManager")
//</editor-fold>
public static int LLVMRunFunctionPassManager( LLVMOpaquePassManager /*P*/ FPM,  LLVMOpaqueValue /*P*/ F) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** Finalizes all of the function passes scheduled in in the function pass
manager. Returns 1 if any of the passes modified the module, 0 otherwise.
@see llvm::FunctionPassManager::doFinalization */

/** Finalizes all of the function passes scheduled in in the function pass
manager. Returns 1 if any of the passes modified the module, 0 otherwise.
@see llvm::FunctionPassManager::doFinalization */
//<editor-fold defaultstate="collapsed" desc="LLVMFinalizeFunctionPassManager">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3247,
 FQN="LLVMFinalizeFunctionPassManager", NM="_Z31LLVMFinalizeFunctionPassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z31LLVMFinalizeFunctionPassManager")
//</editor-fold>
public static int LLVMFinalizeFunctionPassManager( LLVMOpaquePassManager /*P*/ FPM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** Frees the memory of a pass pipeline. For function pipelines, does not free
the module provider.
@see llvm::PassManagerBase::~PassManagerBase. */

/** Frees the memory of a pass pipeline. For function pipelines, does not free
the module provider.
@see llvm::PassManagerBase::~PassManagerBase. */
//<editor-fold defaultstate="collapsed" desc="LLVMDisposePassManager">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3251,
 FQN="LLVMDisposePassManager", NM="_Z22LLVMDisposePassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMDisposePassManager")
//</editor-fold>
public static void LLVMDisposePassManager( LLVMOpaquePassManager /*P*/ PM) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3257,
 FQN="LLVMStartMultithreaded", NM="_Z22LLVMStartMultithreaded",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z22LLVMStartMultithreaded")
//</editor-fold>
public static int LLVMStartMultithreaded() {
  throw new UnsupportedOperationException("EmptyBody");
}


/** Deprecated: Multi-threading can only be enabled/disabled with the compile
time define LLVM_ENABLE_THREADS. */

/** Deprecated: Multi-threading can only be enabled/disabled with the compile
time define LLVM_ENABLE_THREADS. */
//<editor-fold defaultstate="collapsed" desc="LLVMStopMultithreaded">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3261,
 FQN="LLVMStopMultithreaded", NM="_Z21LLVMStopMultithreaded",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z21LLVMStopMultithreaded")
//</editor-fold>
public static void LLVMStopMultithreaded() {
  throw new UnsupportedOperationException("EmptyBody");
}


/** Check whether LLVM is executing in thread-safe mode or not.
@see llvm::llvm_is_multithreaded */

/** Check whether LLVM is executing in thread-safe mode or not.
@see llvm::llvm_is_multithreaded */
//<editor-fold defaultstate="collapsed" desc="LLVMIsMultithreaded">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/IR/Core.cpp", line = 3264,
 FQN="LLVMIsMultithreaded", NM="_Z19LLVMIsMultithreaded",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_Z19LLVMIsMultithreaded")
//</editor-fold>
public static int LLVMIsMultithreaded() {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class CoreGlobals
