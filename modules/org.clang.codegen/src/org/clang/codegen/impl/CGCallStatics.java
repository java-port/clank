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
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.intrinsic.ID;
import org.clang.ast.aliases.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.codegen.java.CodegenRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CGCallStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.impl.CGCallStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL11GetThisTypeRN5clang10ASTContextEPKNS_13CXXRecordDeclE;_ZL13BuildAggStoreRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS0_7AddressEb;_ZL13GetFormalTypePKN5clang13CXXMethodDeclE;_ZL13GetReturnTypeN5clang8QualTypeE;_ZL13emitWritebackRN5clang7CodeGen15CodeGenFunctionERKNS0_11CallArgList9WritebackE;_ZL14emitWritebacksRN5clang7CodeGen15CodeGenFunctionERKNS0_11CallArgListE;_ZL14getNonNullAttrPKN5clang4DeclEPKNS_11ParmVarDeclENS_8QualTypeEj;_ZL14isProvablyNullPN4llvm5ValueE;_ZL16emitWritebackArgRN5clang7CodeGen15CodeGenFunctionERNS0_11CallArgListEPKNS_27ObjCIndirectCopyRestoreExprE;_ZL16getExpansionSizeN5clang8QualTypeERKNS_10ASTContextE;_ZL16getTypeExpansionN5clang8QualTypeERKNS_10ASTContextE;_ZL17CreateCoercedLoadN5clang7CodeGen7AddressEPN4llvm4TypeERNS0_15CodeGenFunctionE;_ZL17isProvablyNonNullPN4llvm5ValueE;_ZL18CreateCoercedStorePN4llvm5ValueEN5clang7CodeGen7AddressEbRNS3_15CodeGenFunctionE;_ZL18getArgTypesForCallRN5clang10ASTContextERKNS_7CodeGen11CallArgListE;_ZL18isInAllocaArgumentRN5clang7CodeGen8CGCXXABIENS_8QualTypeE;_ZL19emitAddressAtOffsetRN5clang7CodeGen15CodeGenFunctionENS0_7AddressERKNS0_10ABIArgInfoE;_ZL19eraseUnusedBitCastsPN4llvm11InstructionE;_ZL20appendParameterTypesRKN5clang7CodeGen12CodeGenTypesERN4llvm15SmallVectorImplINS_7CanQualINS_4TypeEEEEERNS5_INS_17FunctionProtoType16ExtParameterInfoEEENS6_ISB_EEPKNS_12FunctionDeclE;_ZL20emitArgumentDemotionRN5clang7CodeGen15CodeGenFunctionEPKNS_7VarDeclEPN4llvm5ValueE;_ZL20getBundlesForFuncletPN4llvm5ValueEPNS_11InstructionERNS_15SmallVectorImplINS_17OperandBundleDefTIS1_EEEE;_ZL21createPlaceholderSlotRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeE;_ZL21tryRemoveRetainOfSelfRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE;_ZL23arrangeLLVMFunctionInfoRN5clang7CodeGen12CodeGenTypesEbRN4llvm15SmallVectorImplINS_7CanQualINS_4TypeEEEEENS5_INS_17FunctionProtoTypeEEEPKNS_12FunctionDeclE;_ZL23emitAutoreleaseOfResultRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE;_ZL24CoerceIntOrPtrToIntOrPtrPN4llvm5ValueEPNS_4TypeERN5clang7CodeGen15CodeGenFunctionE;_ZL25forConstantArrayExpansionRN5clang7CodeGen15CodeGenFunctionEPN12_GLOBAL__N_122ConstantArrayExpansionENS0_7AddressEN4llvm12function_refIFvS6_EEE;_ZL25getArgTypesForDeclarationRN5clang10ASTContextERKNS_7CodeGen15FunctionArgListE;_ZL26maybeGetUnaryAddrOfOperandPKN5clang4ExprE;_ZL27CreateTempAllocaForCoercionRN5clang7CodeGen15CodeGenFunctionEPN4llvm4TypeENS_9CharUnitsE;_ZL27EmitInitStoreOfNonAggregateRN5clang7CodeGen15CodeGenFunctionENS0_6RValueENS0_6LValueE;_ZL27addExtParameterInfosForCallRN4llvm15SmallVectorImplIN5clang17FunctionProtoType16ExtParameterInfoEEEPKS2_jj;_ZL27arrangeFreeFunctionLikeCallRN5clang7CodeGen12CodeGenTypesERNS0_13CodeGenModuleERKNS0_11CallArgListEPKNS_12FunctionTypeEjb;_ZL27getCallingConventionForDeclPKN5clang4DeclEb;_ZL27getExtParameterInfosForCallPKN5clang17FunctionProtoTypeEjj;_ZL31deactivateArgCleanupsBeforeCallRN5clang7CodeGen15CodeGenFunctionERKNS0_11CallArgListE;_ZL31tryEmitFusedAutoreleaseOfResultRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE;_ZL32findDominatingStoreToReturnValueRN5clang7CodeGen15CodeGenFunctionE;_ZL34AddAttributesFromFunctionProtoTypeRN5clang10ASTContextERN4llvm11AttrBuilderEPKNS_17FunctionProtoTypeE;_ZL34EnterStructPointerForCoercedAccessN5clang7CodeGen7AddressEPN4llvm10StructTypeEyRNS0_15CodeGenFunctionE; -static-type=CGCallStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGCallStatics {


/// Derives the 'this' type for codegen purposes, i.e. ignoring method
/// qualification.
/// FIXME: address space qualification?
//<editor-fold defaultstate="collapsed" desc="GetThisType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 71,
 FQN="GetThisType", NM="_ZL11GetThisTypeRN5clang10ASTContextEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL11GetThisTypeRN5clang10ASTContextEPKNS_13CXXRecordDeclE")
//</editor-fold>
public static CanQual<org.clang.ast.Type> GetThisType(final ASTContext /*&*/ Context, /*const*/ CXXRecordDecl /*P*/ RD) {
  QualType RecTy = Context.getTagDeclType(RD).$arrow().getCanonicalTypeInternal();
  return Context.getPointerType(CanQual.<org.clang.ast.Type>CreateUnsafe(new QualType(RecTy)));
}


/// Returns the canonical formal type of the given C++ method.
//<editor-fold defaultstate="collapsed" desc="GetFormalType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 77,
 FQN="GetFormalType", NM="_ZL13GetFormalTypePKN5clang13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL13GetFormalTypePKN5clang13CXXMethodDeclE")
//</editor-fold>
public static CanQual<FunctionProtoType> GetFormalType(/*const*/ CXXMethodDecl /*P*/ MD) {
  return ((CanProxyFunctionProtoType)MD.getType().$arrow().getCanonicalTypeUnqualified().getAs(FunctionProtoType.class)).$CanQual$T();
}


/// Returns the "extra-canonicalized" return type, which discards
/// qualifiers on the return type.  Codegen doesn't care about them,
/// and it makes ABI code a little easier to be able to assume that
/// all parameter and return types are top-level unqualified.
//<editor-fold defaultstate="collapsed" desc="GetReturnType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 86,
 FQN="GetReturnType", NM="_ZL13GetReturnTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL13GetReturnTypeN5clang8QualTypeE")
//</editor-fold>
public static CanQual<org.clang.ast.Type> GetReturnType(QualType RetTy) {
  return RetTy.$arrow().getCanonicalTypeUnqualified().getUnqualifiedType();
}


/// Adds the formal paramaters in FPT to the given prefix. If any parameter in
/// FPT has pass_object_size attrs, then we'll add parameters for those, too.
//<editor-fold defaultstate="collapsed" desc="appendParameterTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 104,
 FQN="appendParameterTypes", NM="_ZL20appendParameterTypesRKN5clang7CodeGen12CodeGenTypesERN4llvm15SmallVectorImplINS_7CanQualINS_4TypeEEEEERNS5_INS_17FunctionProtoType16ExtParameterInfoEEENS6_ISB_EEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL20appendParameterTypesRKN5clang7CodeGen12CodeGenTypesERN4llvm15SmallVectorImplINS_7CanQualINS_4TypeEEEEERNS5_INS_17FunctionProtoType16ExtParameterInfoEEENS6_ISB_EEPKNS_12FunctionDeclE")
//</editor-fold>
public static void appendParameterTypes(final /*const*/ CodeGenTypes /*&*/ CGT, 
                    final SmallVectorImpl<CanQual<org.clang.ast.Type> > /*&*/ prefix, 
                    final SmallVectorImpl<FunctionProtoType.ExtParameterInfo> /*&*/ paramInfos, 
                    CanQual<FunctionProtoType> FPT, 
                    /*const*/ FunctionDecl /*P*/ FD) {  
  // Fill out paramInfos.
  if (((CanProxyFunctionProtoType)FPT.$arrow(FunctionProtoType.class)).$arrow().hasExtParameterInfos() || !paramInfos.empty()) {
    assert ($lesseq_uint(paramInfos.size(), prefix.size()));
    ArrayRef<FunctionProtoType.ExtParameterInfo> protoParamInfos = ((CanProxyFunctionProtoType)FPT.$arrow(FunctionProtoType.class)).$arrow().getExtParameterInfos();
    paramInfos.reserve(prefix.size() + protoParamInfos.size());
    paramInfos.resize(prefix.size());
    paramInfos.append_T(protoParamInfos.begin(), protoParamInfos.end());
  }

  // Fast path: unknown target.
  if (FD == null) {
    prefix.append_T(((CanProxyFunctionProtoType)FPT.$arrow(FunctionProtoType.class)).$arrow().param_type_begin(), ((CanProxyFunctionProtoType)FPT.$arrow(FunctionProtoType.class)).$arrow().param_type_end());
    return;
  }

  // In the vast majority cases, we'll have precisely FPT->getNumParams()
  // parameters; the only thing that can change this is the presence of
  // pass_object_size. So, we preallocate for the common case.
  prefix.reserve(prefix.size() + ((CanProxyFunctionProtoType)FPT.$arrow(FunctionProtoType.class)).$arrow().getNumParams());
  assert (FD.getNumParams() == ((CanProxyFunctionProtoType)FPT.$arrow(FunctionProtoType.class)).$arrow().getNumParams());
  for (/*uint*/int I = 0, E = ((CanProxyFunctionProtoType)FPT.$arrow(FunctionProtoType.class)).$arrow().getNumParams(); I != E; ++I) {
    prefix.push_back(((CanProxyFunctionProtoType)FPT.$arrow(FunctionProtoType.class)).$arrow().getParamType(I));
    if (FD.getParamDecl$Const(I).hasAttr(PassObjectSizeAttr.class)) {
      prefix.push_back(CGT.getContext().getSizeType());
    }
  }
}


/// Arrange the LLVM function layout for a value of the given function
/// type, on top of any implicit parameters already stored.
//<editor-fold defaultstate="collapsed" desc="arrangeLLVMFunctionInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 139,
 FQN="arrangeLLVMFunctionInfo", NM="_ZL23arrangeLLVMFunctionInfoRN5clang7CodeGen12CodeGenTypesEbRN4llvm15SmallVectorImplINS_7CanQualINS_4TypeEEEEENS5_INS_17FunctionProtoTypeEEEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL23arrangeLLVMFunctionInfoRN5clang7CodeGen12CodeGenTypesEbRN4llvm15SmallVectorImplINS_7CanQualINS_4TypeEEEEENS5_INS_17FunctionProtoTypeEEEPKNS_12FunctionDeclE")
//</editor-fold>
public static /*const*/ CGFunctionInfo /*&*/ arrangeLLVMFunctionInfo(final CodeGenTypes /*&*/ CGT, boolean instanceMethod, 
                       final SmallVectorImpl<CanQual<org.clang.ast.Type> > /*&*/ prefix, 
                       CanQual<FunctionProtoType> FTP, 
                       /*const*/ FunctionDecl /*P*/ FD) {
  SmallVector<FunctionProtoType.ExtParameterInfo> paramInfos/*J*/= new SmallVector<FunctionProtoType.ExtParameterInfo>(16, new FunctionProtoType.ExtParameterInfo());
  RequiredArgs Required = RequiredArgs.forPrototypePlus(new CanQual<FunctionProtoType>(FTP), prefix.size(), FD);
  // FIXME: Kill copy.
  appendParameterTypes(CGT, prefix, paramInfos, new CanQual<FunctionProtoType>(FTP), FD);
  CanQual<org.clang.ast.Type> resultType = ((CanProxyFunctionProtoType)FTP.$arrow(FunctionProtoType.class)).$arrow().getReturnType().getUnqualifiedType();
  
  return CGT.arrangeLLVMFunctionInfo(new CanQual<org.clang.ast.Type>(resultType), instanceMethod, 
      /*chainCall=*/ false, new ArrayRef<CanQual<org.clang.ast.Type>>(prefix, false), 
      ((CanProxyFunctionProtoType)FTP.$arrow(FunctionProtoType.class)).$arrow().getExtInfo(), new ArrayRef<FunctionProtoType.ExtParameterInfo>(paramInfos, false), 
      new RequiredArgs(Required));
}

//<editor-fold defaultstate="collapsed" desc="getCallingConventionForDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 167,
 FQN="getCallingConventionForDecl", NM="_ZL27getCallingConventionForDeclPKN5clang4DeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL27getCallingConventionForDeclPKN5clang4DeclEb")
//</editor-fold>
public static org.clang.basic.CallingConv getCallingConventionForDecl(/*const*/ Decl /*P*/ D, boolean IsWindows) {
  // Set the appropriate calling convention for the Function.
  if (D.hasAttr(StdCallAttr.class)) {
    return org.clang.basic.CallingConv.CC_X86StdCall;
  }
  if (D.hasAttr(FastCallAttr.class)) {
    return org.clang.basic.CallingConv.CC_X86FastCall;
  }
  if (D.hasAttr(ThisCallAttr.class)) {
    return org.clang.basic.CallingConv.CC_X86ThisCall;
  }
  if (D.hasAttr(VectorCallAttr.class)) {
    return org.clang.basic.CallingConv.CC_X86VectorCall;
  }
  if (D.hasAttr(PascalAttr.class)) {
    return org.clang.basic.CallingConv.CC_X86Pascal;
  }
  {
    
    PcsAttr /*P*/ PCS = D.getAttr(PcsAttr.class);
    if ((PCS != null)) {
      return (PCS.getPCS() == PcsAttr.PCSType.AAPCS ? org.clang.basic.CallingConv.CC_AAPCS : org.clang.basic.CallingConv.CC_AAPCS_VFP);
    }
  }
  if (D.hasAttr(IntelOclBiccAttr.class)) {
    return org.clang.basic.CallingConv.CC_IntelOclBicc;
  }
  if (D.hasAttr(MSABIAttr.class)) {
    return IsWindows ? org.clang.basic.CallingConv.CC_C : org.clang.basic.CallingConv.CC_X86_64Win64;
  }
  if (D.hasAttr(SysVABIAttr.class)) {
    return IsWindows ? org.clang.basic.CallingConv.CC_X86_64SysV : org.clang.basic.CallingConv.CC_C;
  }
  if (D.hasAttr(PreserveMostAttr.class)) {
    return org.clang.basic.CallingConv.CC_PreserveMost;
  }
  if (D.hasAttr(PreserveAllAttr.class)) {
    return org.clang.basic.CallingConv.CC_PreserveAll;
  }
  
  return org.clang.basic.CallingConv.CC_C;
}

//<editor-fold defaultstate="collapsed" desc="getArgTypesForCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 303,
 FQN="getArgTypesForCall", NM="_ZL18getArgTypesForCallRN5clang10ASTContextERKNS_7CodeGen11CallArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL18getArgTypesForCallRN5clang10ASTContextERKNS_7CodeGen11CallArgListE")
//</editor-fold>
public static SmallVector<CanQual<org.clang.ast.Type>> getArgTypesForCall(final ASTContext /*&*/ ctx, final /*const*/ CallArgList /*&*/ args) {
  SmallVector<CanQual<org.clang.ast.Type>> argTypes/*J*/= new SmallVector<CanQual<org.clang.ast.Type>>(16, new CanQual<org.clang.ast.Type>());
  for (final /*const*/ CallArg /*&*/ arg : args)  {
    argTypes.push_back(ctx.getCanonicalParamType(new QualType(arg.Ty)));
  }
  return argTypes;
}

//<editor-fold defaultstate="collapsed" desc="getArgTypesForDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 311,
 FQN="getArgTypesForDeclaration", NM="_ZL25getArgTypesForDeclarationRN5clang10ASTContextERKNS_7CodeGen15FunctionArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL25getArgTypesForDeclarationRN5clang10ASTContextERKNS_7CodeGen15FunctionArgListE")
//</editor-fold>
public static SmallVector<CanQual<org.clang.ast.Type>> getArgTypesForDeclaration(final ASTContext /*&*/ ctx, final /*const*/ FunctionArgList /*&*/ args) {
  SmallVector<CanQual<org.clang.ast.Type>> argTypes/*J*/= new SmallVector<CanQual<org.clang.ast.Type>>(16, new CanQual<org.clang.ast.Type>());
  for (final /*const*/ VarDecl /*P*/ /*const*/ /*&*/ arg : args)  {
    argTypes.push_back(ctx.getCanonicalParamType(arg.getType()));
  }
  return argTypes;
}

//<editor-fold defaultstate="collapsed" desc="addExtParameterInfosForCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 319,
 FQN="addExtParameterInfosForCall", NM="_ZL27addExtParameterInfosForCallRN4llvm15SmallVectorImplIN5clang17FunctionProtoType16ExtParameterInfoEEEPKS2_jj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL27addExtParameterInfosForCallRN4llvm15SmallVectorImplIN5clang17FunctionProtoType16ExtParameterInfoEEEPKS2_jj")
//</editor-fold>
public static void addExtParameterInfosForCall(final SmallVectorImpl<FunctionProtoType.ExtParameterInfo> /*&*/ paramInfos, 
                           /*const*/ FunctionProtoType /*P*/ proto, 
                           /*uint*/int prefixArgs, 
                           /*uint*/int totalArgs) {
  assert (proto.hasExtParameterInfos());
  assert ($lesseq_uint(paramInfos.size(), prefixArgs));
  assert ($lesseq_uint(proto.getNumParams() + prefixArgs, totalArgs));
  
  // Add default infos for any prefix args that don't already have infos.
  paramInfos.resize(prefixArgs);
  
  // Add infos for the prototype.
  ArrayRef<FunctionProtoType.ExtParameterInfo> protoInfos = proto.getExtParameterInfos();
  paramInfos.append_T(protoInfos.begin(), protoInfos.end());
  
  // Add default infos for the variadic arguments.
  paramInfos.resize(totalArgs);
}

//<editor-fold defaultstate="collapsed" desc="getExtParameterInfosForCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 339,
 FQN="getExtParameterInfosForCall", NM="_ZL27getExtParameterInfosForCallPKN5clang17FunctionProtoTypeEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL27getExtParameterInfosForCallPKN5clang17FunctionProtoTypeEjj")
//</editor-fold>
public static SmallVector<FunctionProtoType.ExtParameterInfo> getExtParameterInfosForCall(/*const*/ FunctionProtoType /*P*/ proto, 
                           /*uint*/int prefixArgs, /*uint*/int totalArgs) {
  SmallVector<FunctionProtoType.ExtParameterInfo> result/*J*/= new SmallVector<FunctionProtoType.ExtParameterInfo>(16, new FunctionProtoType.ExtParameterInfo());
  if (proto.hasExtParameterInfos()) {
    addExtParameterInfosForCall(result, proto, prefixArgs, totalArgs);
  }
  return result;
}


/// Arrange a call as unto a free function, except possibly with an
/// additional number of formal parameters considered required.
//<editor-fold defaultstate="collapsed" desc="arrangeFreeFunctionLikeCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 507,
 FQN="arrangeFreeFunctionLikeCall", NM="_ZL27arrangeFreeFunctionLikeCallRN5clang7CodeGen12CodeGenTypesERNS0_13CodeGenModuleERKNS0_11CallArgListEPKNS_12FunctionTypeEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL27arrangeFreeFunctionLikeCallRN5clang7CodeGen12CodeGenTypesERNS0_13CodeGenModuleERKNS0_11CallArgListEPKNS_12FunctionTypeEjb")
//</editor-fold>
public static /*const*/ CGFunctionInfo /*&*/ arrangeFreeFunctionLikeCall(final CodeGenTypes /*&*/ CGT, 
                           final CodeGenModule /*&*/ CGM, 
                           final /*const*/ CallArgList /*&*/ args, 
                           /*const*/ org.clang.ast.FunctionType /*P*/ fnType, 
                           /*uint*/int numExtraRequiredArgs, 
                           boolean chainCall) {
  assert ($greatereq_uint(args.size(), numExtraRequiredArgs));
  
  SmallVector<FunctionProtoType.ExtParameterInfo> paramInfos/*J*/= new SmallVector<FunctionProtoType.ExtParameterInfo>(16, new FunctionProtoType.ExtParameterInfo());
  
  // In most cases, there are no optional arguments.
  RequiredArgs required = new RequiredArgs(RequiredArgs.All_t.All);
  {
    
    // If we have a variadic prototype, the required arguments are the
    // extra prefix plus the arguments in the prototype.
    /*const*/ FunctionProtoType /*P*/ proto = dyn_cast_FunctionProtoType(fnType);
    if ((proto != null)) {
      if (proto.isVariadic()) {
        required.$assignMove(new RequiredArgs(proto.getNumParams() + numExtraRequiredArgs));
      }
      if (proto.hasExtParameterInfos()) {
        addExtParameterInfosForCall(paramInfos, proto, numExtraRequiredArgs, 
            args.size());
      }
      // If we don't have a prototype at all, but we're supposed to
      // explicitly use the variadic convention for unprototyped calls,
      // treat all of the arguments as required but preserve the nominal
      // possibility of variadics.
    } else if (CGM.getTargetCodeGenInfo().
        isNoProtoCallVariadic(args, 
        cast_FunctionNoProtoType(fnType))) {
      required.$assignMove(new RequiredArgs(args.size()));
    }
  }
  
  // FIXME: Kill copy.
  SmallVector<CanQual<org.clang.ast.Type>> argTypes/*J*/= new SmallVector<CanQual<org.clang.ast.Type>>(16, new CanQual<org.clang.ast.Type>());
  for (final /*const*/ CallArg /*&*/ arg : args)  {
    argTypes.push_back(CGT.getContext().getCanonicalParamType(new QualType(arg.Ty)));
  }
  return CGT.arrangeLLVMFunctionInfo(GetReturnType(fnType.getReturnType()), 
      /*instanceMethod=*/ false, chainCall, 
      new ArrayRef<CanQual<org.clang.ast.Type>>(argTypes, false), fnType.getExtInfo(), new ArrayRef<FunctionProtoType.ExtParameterInfo>(paramInfos, false), 
      new RequiredArgs(required));
}

// namespace
//<editor-fold defaultstate="collapsed" desc="getTypeExpansion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 831,
 FQN="getTypeExpansion", NM="_ZL16getTypeExpansionN5clang8QualTypeERKNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL16getTypeExpansionN5clang8QualTypeERKNS_10ASTContextE")
//</editor-fold>
public static std.unique_ptr<TypeExpansion> getTypeExpansion(QualType Ty, final /*const*/ ASTContext /*&*/ Context) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    {
      /*const*/ ConstantArrayType /*P*/ AT = Context.getAsConstantArrayType(new QualType(Ty));
      if ((AT != null)) {
        return $c$.clean(new std.unique_ptr<TypeExpansion>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ConstantArrayExpansion(AT.getElementType(), AT.getSize().getZExtValue())))));
      }
    }
    {
      /*const*/ RecordType /*P*/ RT = Ty.$arrow().getAs$RecordType();
      if ((RT != null)) {
        SmallVector</*const*/ CXXBaseSpecifier /*P*/ > Bases/*J*/= new SmallVector</*const*/ CXXBaseSpecifier /*P*/ >(1, (/*const*/ CXXBaseSpecifier /*P*/ )null);
        SmallVector</*const*/ FieldDecl /*P*/ > Fields/*J*/= new SmallVector</*const*/ FieldDecl /*P*/ >(1, (/*const*/ FieldDecl /*P*/ )null);
        /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
        assert (!RD.hasFlexibleArrayMember()) : "Cannot expand structure with flexible array.";
        if (RD.isUnion()) {
          // Unions can be here only in degenerative cases - all the fields are same
          // after flattening. Thus we have to use the "largest" field.
          /*const*/ FieldDecl /*P*/ LargestFD = null;
          CharUnits UnionSize = CharUnits.Zero();
          
          for (/*const*/ FieldDecl /*P*/ FD : RD.fields()) {
            // Skip zero length bitfields.
            if (FD.isBitField() && FD.getBitWidthValue(Context) == 0) {
              continue;
            }
            assert (!FD.isBitField()) : "Cannot expand structure with bit-field members.";
            CharUnits FieldSize = Context.getTypeSizeInChars(FD.getType());
            if (UnionSize.$less(FieldSize)) {
              UnionSize.$assign(FieldSize);
              LargestFD = FD;
            }
          }
          if ((LargestFD != null)) {
            Fields.push_back(LargestFD);
          }
        } else {
          {
            /*const*/ CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(RD);
            if ((CXXRD != null)) {
              assert (!CXXRD.isDynamicClass()) : "cannot expand vtable pointers in dynamic classes";
              for (final /*const*/ CXXBaseSpecifier /*&*/ BS : CXXRD.bases$Const())  {
                Bases.push_back($AddrOf(BS));
              }
            }
          }
          
          for (/*const*/ FieldDecl /*P*/ FD : RD.fields()) {
            // Skip zero length bitfields.
            if (FD.isBitField() && FD.getBitWidthValue(Context) == 0) {
              continue;
            }
            assert (!FD.isBitField()) : "Cannot expand structure with bit-field members.";
            Fields.push_back(FD);
          }
        }
        return $c$.clean(new std.unique_ptr<TypeExpansion>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new RecordExpansion(std.move(Bases), 
                std.move(Fields))))));
      }
    }
    {
      /*const*/ ComplexType /*P*/ CT = Ty.$arrow().getAs(ComplexType.class);
      if ((CT != null)) {
        return $c$.clean(new std.unique_ptr<TypeExpansion>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ComplexExpansion(CT.getElementType())))));
      }
    }
    return $c$.clean(new std.unique_ptr<TypeExpansion>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new NoExpansion()))));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="getExpansionSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 889,
 FQN="getExpansionSize", NM="_ZL16getExpansionSizeN5clang8QualTypeERKNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL16getExpansionSizeN5clang8QualTypeERKNS_10ASTContextE")
//</editor-fold>
public static int getExpansionSize(QualType Ty, final /*const*/ ASTContext /*&*/ Context) {
  unique_ptr<TypeExpansion> Exp = null;
  try {
    Exp = getTypeExpansion(new QualType(Ty), Context);
    {
      ConstantArrayExpansion /*P*/ CAExp = dyn_cast_ConstantArrayExpansion(Exp.get());
      if ((CAExp != null)) {
        return $ullong2int(CAExp.NumElts * $int2ullong(getExpansionSize(new QualType(CAExp.EltTy), Context)));
      }
    }
    {
      RecordExpansion /*P*/ RExp = dyn_cast_RecordExpansion(Exp.get());
      if ((RExp != null)) {
        int Res = 0;
        for (/*const*/ CXXBaseSpecifier /*P*/ BS : RExp.Bases)  {
          Res += getExpansionSize(BS.getType(), Context);
        }
        for (/*const*/ FieldDecl /*P*/ FD : RExp.Fields)  {
          Res += getExpansionSize(FD.getType(), Context);
        }
        return Res;
      }
    }
    if (isa_ComplexExpansion(Exp.get())) {
      return 2;
    }
    assert (isa_NoExpansion(Exp.get()));
    return 1;
  } finally {
    if (Exp != null) { Exp.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="forConstantArrayExpansion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 931,
 FQN="forConstantArrayExpansion", NM="_ZL25forConstantArrayExpansionRN5clang7CodeGen15CodeGenFunctionEPN12_GLOBAL__N_122ConstantArrayExpansionENS0_7AddressEN4llvm12function_refIFvS6_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL25forConstantArrayExpansionRN5clang7CodeGen15CodeGenFunctionEPN12_GLOBAL__N_122ConstantArrayExpansionENS0_7AddressEN4llvm12function_refIFvS6_EEE")
//</editor-fold>
public static void forConstantArrayExpansion(final CodeGenFunction /*&*/ CGF, 
                         ConstantArrayExpansion /*P*/ CAE, 
                         Address BaseAddr, 
                         Type2Void<Address> Fn) {
  CharUnits EltSize = CGF.getContext().getTypeSizeInChars(/*NO_COPY*/CAE.EltTy);
  CharUnits EltAlign = BaseAddr.getAlignment().alignmentOfArrayElement(new CharUnits(EltSize));
  
  for (int i = 0, n = $ulong2int(CAE.NumElts); i < n; i++) {
    Value /*P*/ EltAddr = CGF.Builder.CreateConstGEP2_32((org.llvm.ir.Type /*P*/ )null, BaseAddr.getPointer(), 0, i);
    Fn.$call(new Address(EltAddr, new CharUnits(EltAlign)));
  }
}


/// Create a temporary allocation for the purposes of coercion.
//<editor-fold defaultstate="collapsed" desc="CreateTempAllocaForCoercion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1036,
 FQN="CreateTempAllocaForCoercion", NM="_ZL27CreateTempAllocaForCoercionRN5clang7CodeGen15CodeGenFunctionEPN4llvm4TypeENS_9CharUnitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL27CreateTempAllocaForCoercionRN5clang7CodeGen15CodeGenFunctionEPN4llvm4TypeENS_9CharUnitsE")
//</editor-fold>
public static Address CreateTempAllocaForCoercion(final CodeGenFunction /*&*/ CGF, org.llvm.ir.Type /*P*/ Ty, 
                           CharUnits MinAlign) {
  // Don't use an alignment that's worse than what LLVM would prefer.
  /*uint*/int PrefAlign = CGF.CGM.getDataLayout().getPrefTypeAlignment(Ty);
  CharUnits Align = new CharUnits(std.max(MinAlign, CharUnits.fromQuantity($uint2long(PrefAlign))));
  
  return CGF.CreateTempAlloca(Ty, new CharUnits(Align));
}


/// EnterStructPointerForCoercedAccess - Given a struct pointer that we are
/// accessing some number of bytes out of it, try to gep into the struct to get
/// at its inner goodness.  Dive as deep as possible without entering an element
/// with an in-memory size smaller than DstSize.
//<editor-fold defaultstate="collapsed" desc="EnterStructPointerForCoercedAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1049,
 FQN="EnterStructPointerForCoercedAccess", NM="_ZL34EnterStructPointerForCoercedAccessN5clang7CodeGen7AddressEPN4llvm10StructTypeEyRNS0_15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL34EnterStructPointerForCoercedAccessN5clang7CodeGen7AddressEPN4llvm10StructTypeEyRNS0_15CodeGenFunctionE")
//</editor-fold>
public static Address EnterStructPointerForCoercedAccess(Address SrcPtr, 
                                  StructType /*P*/ SrcSTy, 
                                  long/*uint64_t*/ DstSize, final CodeGenFunction /*&*/ CGF) {
  // We can't dive into a zero-element struct.
  if (SrcSTy.getNumElements() == 0) {
    return new Address(JD$Move.INSTANCE, SrcPtr);
  }
  
  org.llvm.ir.Type /*P*/ FirstElt = SrcSTy.getElementType(0);
  
  // If the first elt is at least as large as what we're looking for, or if the
  // first element is the same size as the whole struct, we can enter it. The
  // comparison must be made on the store size and not the alloca size. Using
  // the alloca size may overstate the size of the load.
  long/*uint64_t*/ FirstEltSize = CGF.CGM.getDataLayout().getTypeStoreSize(FirstElt);
  if ($less_ulong(FirstEltSize, DstSize)
     && $less_ulong(FirstEltSize, CGF.CGM.getDataLayout().getTypeStoreSize(SrcSTy))) {
    return new Address(JD$Move.INSTANCE, SrcPtr);
  }
  
  // GEP into the first element.
  SrcPtr.$assignMove(CGF.Builder.CreateStructGEP(new Address(SrcPtr), 0, new CharUnits(), new Twine(/*KEEP_STR*/"coerce.dive")));
  
  // If the first element is a struct, recurse.
  org.llvm.ir.Type /*P*/ SrcTy = SrcPtr.getElementType();
  {
    StructType /*P*/ SrcSTy$1 = dyn_cast_StructType(SrcTy);
    if ((SrcSTy$1 != null)) {
      return EnterStructPointerForCoercedAccess(new Address(SrcPtr), SrcSTy$1, DstSize, CGF);
    }
  }
  
  return new Address(JD$Move.INSTANCE, SrcPtr);
}


/// CoerceIntOrPtrToIntOrPtr - Convert a value Val to the specific Ty where both
/// are either integers or pointers.  This does a truncation of the value if it
/// is too large or a zero extension if it is too small.
///
/// This behaves as if the value were coerced through memory, so on big-endian
/// targets the high bits are preserved in a truncation, while little-endian
/// targets preserve the low bits.
//<editor-fold defaultstate="collapsed" desc="CoerceIntOrPtrToIntOrPtr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1086,
 FQN="CoerceIntOrPtrToIntOrPtr", NM="_ZL24CoerceIntOrPtrToIntOrPtrPN4llvm5ValueEPNS_4TypeERN5clang7CodeGen15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL24CoerceIntOrPtrToIntOrPtrPN4llvm5ValueEPNS_4TypeERN5clang7CodeGen15CodeGenFunctionE")
//</editor-fold>
public static Value /*P*/ CoerceIntOrPtrToIntOrPtr(Value /*P*/ Val, 
                        org.llvm.ir.Type /*P*/ Ty, 
                        final CodeGenFunction /*&*/ CGF) {
  if (Val.getType() == Ty) {
    return Val;
  }
  if (isa_PointerType(Val.getType())) {
    // If this is Pointer->Pointer avoid conversion to and from int.
    if (isa_PointerType(Ty)) {
      return CGF.Builder.CreateBitCast(Val, Ty, new Twine(/*KEEP_STR*/"coerce.val"));
    }
    
    // Convert the pointer to an integer so we can play with its width.
    Val = CGF.Builder.CreatePtrToInt(Val, CGF.Unnamed_field8.IntPtrTy, new Twine(/*KEEP_STR*/"coerce.val.pi"));
  }
  
  org.llvm.ir.Type /*P*/ DestIntTy = Ty;
  if (isa_PointerType(DestIntTy)) {
    DestIntTy = CGF.Unnamed_field8.IntPtrTy;
  }
  if (Val.getType() != DestIntTy) {
    final /*const*/ DataLayout /*&*/ DL = CGF.CGM.getDataLayout();
    if (DL.isBigEndian()) {
      // Preserve the high bits on big-endian targets.
      // That is what memory coercion does.
      long/*uint64_t*/ SrcSize = DL.getTypeSizeInBits(Val.getType());
      long/*uint64_t*/ DstSize = DL.getTypeSizeInBits(DestIntTy);
      if ($greater_ulong(SrcSize, DstSize)) {
        Val = CGF.Builder.CreateLShr(Val, SrcSize - DstSize, new Twine(/*KEEP_STR*/"coerce.highbits"));
        Val = CGF.Builder.CreateTrunc(Val, DestIntTy, new Twine(/*KEEP_STR*/"coerce.val.ii"));
      } else {
        Val = CGF.Builder.CreateZExt(Val, DestIntTy, new Twine(/*KEEP_STR*/"coerce.val.ii"));
        Val = CGF.Builder.CreateShl(Val, DstSize - SrcSize, new Twine(/*KEEP_STR*/"coerce.highbits"));
      }
    } else {
      // Little-endian targets preserve the low bits. No shifts required.
      Val = CGF.Builder.CreateIntCast(Val, DestIntTy, false, new Twine(/*KEEP_STR*/"coerce.val.ii"));
    }
  }
  if (isa_PointerType(Ty)) {
    Val = CGF.Builder.CreateIntToPtr(Val, Ty, new Twine(/*KEEP_STR*/"coerce.val.ip"));
  }
  return Val;
}


/// CreateCoercedLoad - Create a load from \arg SrcPtr interpreted as
/// a pointer to an object of type \arg Ty, known to be aligned to
/// \arg SrcAlign bytes.
///
/// This safely handles the case when the src type is smaller than the
/// destination type; in this situation the values of bits which not
/// present in the src are undefined.
//<editor-fold defaultstate="collapsed" desc="CreateCoercedLoad">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1140,
 FQN="CreateCoercedLoad", NM="_ZL17CreateCoercedLoadN5clang7CodeGen7AddressEPN4llvm4TypeERNS0_15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL17CreateCoercedLoadN5clang7CodeGen7AddressEPN4llvm4TypeERNS0_15CodeGenFunctionE")
//</editor-fold>
public static Value /*P*/ CreateCoercedLoad(Address Src, org.llvm.ir.Type /*P*/ Ty, 
                 final CodeGenFunction /*&*/ CGF) {
  org.llvm.ir.Type /*P*/ SrcTy = Src.getElementType();
  
  // If SrcTy and Ty are the same, just do a load.
  if (SrcTy == Ty) {
    return CGF.Builder.CreateLoad(new Address(Src));
  }
  
  long/*uint64_t*/ DstSize = CGF.CGM.getDataLayout().getTypeAllocSize(Ty);
  {
    
    StructType /*P*/ SrcSTy = dyn_cast_StructType(SrcTy);
    if ((SrcSTy != null)) {
      Src.$assignMove(EnterStructPointerForCoercedAccess(new Address(Src), SrcSTy, DstSize, CGF));
      SrcTy = Src.getType().getElementType();
    }
  }
  
  long/*uint64_t*/ SrcSize = CGF.CGM.getDataLayout().getTypeAllocSize(SrcTy);
  
  // If the source and destination are integer or pointer types, just do an
  // extension or truncation to the desired type.
  if ((isa_IntegerType(Ty) || isa_PointerType(Ty))
     && (isa_IntegerType(SrcTy) || isa_PointerType(SrcTy))) {
    Value /*P*/ Load = CGF.Builder.CreateLoad(new Address(Src));
    return CoerceIntOrPtrToIntOrPtr(Load, Ty, CGF);
  }
  
  // If load is legal, just bitcast the src pointer.
  if ($greatereq_ulong(SrcSize, DstSize)) {
    // Generally SrcSize is never greater than DstSize, since this means we are
    // losing bits. However, this can happen in cases where the structure has
    // additional padding, for example due to a user specified alignment.
    //
    // FIXME: Assert that we aren't truncating non-padding bits when have access
    // to that information.
    Src.$assignMove(CGF.Builder.CreateBitCast(new Address(Src), org.llvm.ir.PointerType.getUnqual(Ty)));
    return CGF.Builder.CreateLoad(new Address(Src));
  }
  
  // Otherwise do coercion through memory. This is stupid, but simple.
  Address Tmp = CreateTempAllocaForCoercion(CGF, Ty, Src.getAlignment());
  Address Casted = CGF.Builder.CreateBitCast(new Address(Tmp), CGF.Unnamed_field9.Int8PtrTy);
  Address SrcCasted = CGF.Builder.CreateBitCast(new Address(Src), CGF.Unnamed_field9.Int8PtrTy);
  CGF.Builder.CreateMemCpy(new Address(Casted), new Address(SrcCasted), 
      ConstantInt.get(CGF.Unnamed_field8.IntPtrTy, SrcSize), 
      false);
  return CGF.Builder.CreateLoad(new Address(Tmp));
}


// Function to store a first-class aggregate into memory.  We prefer to
// store the elements rather than the aggregate to be more friendly to
// fast-isel.
// FIXME: Do we need to recurse here?
//<editor-fold defaultstate="collapsed" desc="BuildAggStore">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1191,
 FQN="BuildAggStore", NM="_ZL13BuildAggStoreRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS0_7AddressEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL13BuildAggStoreRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS0_7AddressEb")
//</editor-fold>
public static void BuildAggStore(final CodeGenFunction /*&*/ CGF, Value /*P*/ Val, 
             Address Dest, boolean DestIsVolatile) {
  {
    // Prefer scalar stores to first-class aggregate stores.
    StructType /*P*/ STy = dyn_cast_StructType(Val.getType());
    if ((STy != null)) {
      /*const*/ StructLayout /*P*/ Layout = CGF.CGM.getDataLayout().getStructLayout(STy);
      
      for (/*uint*/int i = 0, e = STy.getNumElements(); i != e; ++i) {
        CharUnits EltOffset = CharUnits.fromQuantity(Layout.getElementOffset(i));
        Address EltPtr = CGF.Builder.CreateStructGEP(new Address(Dest), i, new CharUnits(EltOffset));
        Value /*P*/ Elt = CGF.Builder.CreateExtractValue(Val, new ArrayRefUInt(i));
        CGF.Builder.CreateStore(Elt, new Address(EltPtr), DestIsVolatile);
      }
    } else {
      CGF.Builder.CreateStore(Val, new Address(Dest), DestIsVolatile);
    }
  }
}


/// CreateCoercedStore - Create a store to \arg DstPtr from \arg Src,
/// where the source and destination may have different types.  The
/// destination is known to be aligned to \arg DstAlign bytes.
///
/// This safely handles the case when the src type is larger than the
/// destination type; the upper bits of the src will be lost.
//<editor-fold defaultstate="collapsed" desc="CreateCoercedStore">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1216,
 FQN="CreateCoercedStore", NM="_ZL18CreateCoercedStorePN4llvm5ValueEN5clang7CodeGen7AddressEbRNS3_15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL18CreateCoercedStorePN4llvm5ValueEN5clang7CodeGen7AddressEbRNS3_15CodeGenFunctionE")
//</editor-fold>
public static void CreateCoercedStore(Value /*P*/ Src, 
                  Address Dst, 
                  boolean DstIsVolatile, 
                  final CodeGenFunction /*&*/ CGF) {
  org.llvm.ir.Type /*P*/ SrcTy = Src.getType();
  org.llvm.ir.Type /*P*/ DstTy = Dst.getType().getElementType();
  if (SrcTy == DstTy) {
    CGF.Builder.CreateStore(Src, new Address(Dst), DstIsVolatile);
    return;
  }
  
  long/*uint64_t*/ SrcSize = CGF.CGM.getDataLayout().getTypeAllocSize(SrcTy);
  {
    
    StructType /*P*/ DstSTy = dyn_cast_StructType(DstTy);
    if ((DstSTy != null)) {
      Dst.$assignMove(EnterStructPointerForCoercedAccess(new Address(Dst), DstSTy, SrcSize, CGF));
      DstTy = Dst.getType().getElementType();
    }
  }
  
  // If the source and destination are integer or pointer types, just do an
  // extension or truncation to the desired type.
  if ((isa_IntegerType(SrcTy) || isa_PointerType(SrcTy))
     && (isa_IntegerType(DstTy) || isa_PointerType(DstTy))) {
    Src = CoerceIntOrPtrToIntOrPtr(Src, DstTy, CGF);
    CGF.Builder.CreateStore(Src, new Address(Dst), DstIsVolatile);
    return;
  }
  
  long/*uint64_t*/ DstSize = CGF.CGM.getDataLayout().getTypeAllocSize(DstTy);
  
  // If store is legal, just bitcast the src pointer.
  if ($lesseq_ulong(SrcSize, DstSize)) {
    Dst.$assignMove(CGF.Builder.CreateBitCast(new Address(Dst), org.llvm.ir.PointerType.getUnqual(SrcTy)));
    BuildAggStore(CGF, Src, new Address(Dst), DstIsVolatile);
  } else {
    // Otherwise do coercion through memory. This is stupid, but
    // simple.
    
    // Generally SrcSize is never greater than DstSize, since this means we are
    // losing bits. However, this can happen in cases where the structure has
    // additional padding, for example due to a user specified alignment.
    //
    // FIXME: Assert that we aren't truncating non-padding bits when have access
    // to that information.
    Address Tmp = CreateTempAllocaForCoercion(CGF, SrcTy, Dst.getAlignment());
    CGF.Builder.CreateStore(Src, new Address(Tmp));
    Address Casted = CGF.Builder.CreateBitCast(new Address(Tmp), CGF.Unnamed_field9.Int8PtrTy);
    Address DstCasted = CGF.Builder.CreateBitCast(new Address(Dst), CGF.Unnamed_field9.Int8PtrTy);
    CGF.Builder.CreateMemCpy(new Address(DstCasted), new Address(Casted), 
        ConstantInt.get(CGF.Unnamed_field8.IntPtrTy, DstSize), 
        false);
  }
}

//<editor-fold defaultstate="collapsed" desc="emitAddressAtOffset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1269,
 FQN="emitAddressAtOffset", NM="_ZL19emitAddressAtOffsetRN5clang7CodeGen15CodeGenFunctionENS0_7AddressERKNS0_10ABIArgInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL19emitAddressAtOffsetRN5clang7CodeGen15CodeGenFunctionENS0_7AddressERKNS0_10ABIArgInfoE")
//</editor-fold>
public static Address emitAddressAtOffset(final CodeGenFunction /*&*/ CGF, Address addr, 
                   final /*const*/ ABIArgInfo /*&*/ info) {
  {
    /*uint*/int offset = info.getDirectOffset();
    if ((offset != 0)) {
      addr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(addr), CGF.Int8Ty));
      addr.$assignMove(CGF.Builder.CreateConstInBoundsByteGEP(new Address(addr), 
              CharUnits.fromQuantity($uint2long(offset))));
      addr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(addr), info.getCoerceToType()));
    }
  }
  return new Address(JD$Move.INSTANCE, addr);
}

//<editor-fold defaultstate="collapsed" desc="AddAttributesFromFunctionProtoType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1609,
 FQN="AddAttributesFromFunctionProtoType", NM="_ZL34AddAttributesFromFunctionProtoTypeRN5clang10ASTContextERN4llvm11AttrBuilderEPKNS_17FunctionProtoTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL34AddAttributesFromFunctionProtoTypeRN5clang10ASTContextERN4llvm11AttrBuilderEPKNS_17FunctionProtoTypeE")
//</editor-fold>
public static void AddAttributesFromFunctionProtoType(final ASTContext /*&*/ Ctx, 
                                  final AttrBuilder /*&*/ FuncAttrs, 
                                  /*const*/ FunctionProtoType /*P*/ FPT) {
  if (!(FPT != null)) {
    return;
  }
  if (!isUnresolvedExceptionSpec(FPT.getExceptionSpecType())
     && FPT.isNothrow(Ctx)) {
    FuncAttrs.addAttribute(Attribute.AttrKind.NoUnwind);
  }
}


/// An argument came in as a promoted argument; demote it back to its
/// declared type.
//<editor-fold defaultstate="collapsed" desc="emitArgumentDemotion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 2014,
 FQN="emitArgumentDemotion", NM="_ZL20emitArgumentDemotionRN5clang7CodeGen15CodeGenFunctionEPKNS_7VarDeclEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL20emitArgumentDemotionRN5clang7CodeGen15CodeGenFunctionEPKNS_7VarDeclEPN4llvm5ValueE")
//</editor-fold>
public static Value /*P*/ emitArgumentDemotion(final CodeGenFunction /*&*/ CGF, 
                    /*const*/ VarDecl /*P*/ var, 
                    Value /*P*/ value) {
  org.llvm.ir.Type /*P*/ varType = CGF.ConvertType(var.getType());
  
  // This can happen with promotions that actually don't change the
  // underlying type, like the enum promotions.
  if (value.getType() == varType) {
    return value;
  }
  assert ((varType.isIntegerTy() || varType.isFloatingPointTy())) : "unexpected promotion type";
  if (isa_IntegerType(varType)) {
    return CGF.Builder.CreateTrunc(value, varType, new Twine(/*KEEP_STR*/"arg.unpromote"));
  }
  
  return CGF.Builder.CreateFPCast(value, varType, new Twine(/*KEEP_STR*/"arg.unpromote"));
}


/// Returns the attribute (either parameter attribute, or function
/// attribute), which declares argument ArgNo to be non-null.
//<editor-fold defaultstate="collapsed" desc="getNonNullAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 2034,
 FQN="getNonNullAttr", NM="_ZL14getNonNullAttrPKN5clang4DeclEPKNS_11ParmVarDeclENS_8QualTypeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL14getNonNullAttrPKN5clang4DeclEPKNS_11ParmVarDeclENS_8QualTypeEj")
//</editor-fold>
public static /*const*/ NonNullAttr /*P*/ getNonNullAttr(/*const*/ Decl /*P*/ FD, /*const*/ ParmVarDecl /*P*/ PVD, 
              QualType ArgType, /*uint*/int ArgNo) {
  // FIXME: __attribute__((nonnull)) can also be applied to:
  //   - references to pointers, where the pointee is known to be
  //     nonnull (apparently a Clang extension)
  //   - transparent unions containing pointers
  // In the former case, LLVM IR cannot represent the constraint. In
  // the latter case, we have no guarantee that the transparent union
  // is in fact passed as a pointer.
  if (!ArgType.$arrow().isAnyPointerType() && !ArgType.$arrow().isBlockPointerType()) {
    return null;
  }
  // First, check attribute on parameter itself.
  if ((PVD != null)) {
    {
      NonNullAttr /*P*/ ParmNNAttr = PVD.getAttr(NonNullAttr.class);
      if ((ParmNNAttr != null)) {
        return ParmNNAttr;
      }
    }
  }
  // Check function attributes.
  if (!(FD != null)) {
    return null;
  }
  for (/*const*/ NonNullAttr /*P*/ NNAttr : FD.specific_attrs(NonNullAttr.class)) {
    if (NNAttr.isNonNull(ArgNo)) {
      return NNAttr;
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="eraseUnusedBitCasts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 2444,
 FQN="eraseUnusedBitCasts", NM="_ZL19eraseUnusedBitCastsPN4llvm11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL19eraseUnusedBitCastsPN4llvm11InstructionE")
//</editor-fold>
public static void eraseUnusedBitCasts(Instruction /*P*/ insn) {
  while (insn.use_empty()) {
    BitCastInst /*P*/ bitcast = dyn_cast_BitCastInst(insn);
    if (!(bitcast != null)) {
      return;
    }
    
    // This is "safe" because we would have used a ConstantExpr otherwise.
    insn = cast_Instruction(bitcast.getOperand(0));
    bitcast.eraseFromParent();
  }
}


/// Try to emit a fused autorelease of a return result.
//<editor-fold defaultstate="collapsed" desc="tryEmitFusedAutoreleaseOfResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 2456,
 FQN="tryEmitFusedAutoreleaseOfResult", NM="_ZL31tryEmitFusedAutoreleaseOfResultRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL31tryEmitFusedAutoreleaseOfResultRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE")
//</editor-fold>
public static Value /*P*/ tryEmitFusedAutoreleaseOfResult(final CodeGenFunction /*&*/ CGF, 
                               Value /*P*/ result) {
  // We must be immediately followed the cast.
  BasicBlock /*P*/ BB = CGF.Builder.GetInsertBlock();
  if (BB.empty()) {
    return null;
  }
  if ($AddrOf(BB.back()) != result) {
    return null;
  }
  
  org.llvm.ir.Type /*P*/ resultType = result.getType();
  
  // result is in a BasicBlock and is therefore an Instruction.
  Instruction /*P*/ generator = cast_Instruction(result);
  
  SmallVector<Instruction /*P*/ > insnsToKill/*J*/= new SmallVector<Instruction /*P*/ >(4, (Instruction /*P*/ )null);
  {
    
    // Look for:
    //  %generator = bitcast %type1* %generator2 to %type2*
    BitCastInst /*P*/ bitcast;
    while (((/*P*/ bitcast = dyn_cast_BitCastInst(generator)) != null)) {
      // We would have emitted this as a constant if the operand weren't
      // an Instruction.
      generator = cast_Instruction(bitcast.getOperand(0));
      
      // Require the generator to be immediately followed by the cast.
      if (generator.getNextNode() != bitcast) {
        return null;
      }
      
      insnsToKill.push_back(bitcast);
    }
  }
  
  // Look for:
  //   %generator = call i8* @objc_retain(i8* %originalResult)
  // or
  //   %generator = call i8* @objc_retainAutoreleasedReturnValue(i8* %originalResult)
  CallInst /*P*/ call = dyn_cast_CallInst(generator);
  if (!(call != null)) {
    return null;
  }
  
  boolean doRetainAutorelease;
  if (call.getCalledValue() == CGF.CGM.getObjCEntrypoints().objc_retain) {
    doRetainAutorelease = true;
  } else if (call.getCalledValue() == CGF.CGM.getObjCEntrypoints().
      objc_retainAutoreleasedReturnValue) {
    doRetainAutorelease = false;
    
    // If we emitted an assembly marker for this call (and the
    // ARCEntrypoints field should have been set if so), go looking
    // for that call.  If we can't find it, we can't do this
    // optimization.  But it should always be the immediately previous
    // instruction, unless we needed bitcasts around the call.
    if ((CGF.CGM.getObjCEntrypoints().retainAutoreleasedReturnValueMarker != null)) {
      Instruction /*P*/ prev = call.getPrevNode();
      assert Native.$bool(prev);
      if (isa_BitCastInst(prev)) {
        prev = prev.getPrevNode();
        assert Native.$bool(prev);
      }
      assert (isa_CallInst(prev));
      assert (cast_CallInst(prev).getCalledValue() == CGF.CGM.getObjCEntrypoints().retainAutoreleasedReturnValueMarker);
      insnsToKill.push_back(prev);
    }
  } else {
    return null;
  }
  
  result = call.getArgOperand(0);
  insnsToKill.push_back(call);
  {
    
    // Keep killing bitcasts, for sanity.  Note that we no longer care
    // about precise ordering as long as there's exactly one use.
    BitCastInst /*P*/ bitcast$1;
    while (((/*P*/ bitcast$1 = dyn_cast_BitCastInst(result)) != null)) {
      if (!bitcast$1.hasOneUse()) {
        break;
      }
      insnsToKill.push_back(bitcast$1);
      result = bitcast$1.getOperand(0);
    }
  }
  
  // Delete all the unnecessary instructions, from latest to earliest.
  for (type$ptr<Instruction /*P*/ /*P*/> i = $tryClone(insnsToKill.begin()), /*P*/ e = $tryClone(insnsToKill.end()); $noteq_ptr(i, e); i.$preInc())  {
    (i.$star()).eraseFromParent();
  }
  
  // Do the fused retain/autorelease if we were asked to.
  if (doRetainAutorelease) {
    result = CGF.EmitARCRetainAutoreleaseReturnValue(result);
  }
  
  // Cast back to the result type.
  return CGF.Builder.CreateBitCast(result, resultType);
}


/// If this is a +1 of the value of an immutable 'self', remove it.
//<editor-fold defaultstate="collapsed" desc="tryRemoveRetainOfSelf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 2545,
 FQN="tryRemoveRetainOfSelf", NM="_ZL21tryRemoveRetainOfSelfRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL21tryRemoveRetainOfSelfRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE")
//</editor-fold>
public static Value /*P*/ tryRemoveRetainOfSelf(final CodeGenFunction /*&*/ CGF, 
                     Value /*P*/ result) {
  // This is only applicable to a method with an immutable 'self'.
  /*const*/ ObjCMethodDecl /*P*/ method = dyn_cast_or_null_ObjCMethodDecl(CGF.CurCodeDecl);
  if (!(method != null)) {
    return null;
  }
  /*const*/ VarDecl /*P*/ self = method.getSelfDecl();
  if (!self.getType().isConstQualified()) {
    return null;
  }
  
  // Look for a retain call.
  CallInst /*P*/ retainCall = dyn_cast_CallInst(result.stripPointerCasts());
  if (!(retainCall != null)
     || retainCall.getCalledValue() != CGF.CGM.getObjCEntrypoints().objc_retain) {
    return null;
  }
  
  // Look for an ordinary load of 'self'.
  Value /*P*/ retainedValue = retainCall.getArgOperand(0);
  LoadInst /*P*/ load = dyn_cast_LoadInst(retainedValue.stripPointerCasts());
  if (!(load != null) || load.isAtomic() || load.isVolatile()
     || load.getPointerOperand() != CGF.GetAddrOfLocalVar(self).getPointer()) {
    return null;
  }
  
  // Okay!  Burn it all down.  This relies for correctness on the
  // assumption that the retain is emitted as part of the return and
  // that thereafter everything is used "linearly".
  org.llvm.ir.Type /*P*/ resultType = result.getType();
  eraseUnusedBitCasts(cast_Instruction(result));
  assert (retainCall.use_empty());
  retainCall.eraseFromParent();
  eraseUnusedBitCasts(cast_Instruction(retainedValue));
  
  return CGF.Builder.CreateBitCast(load, resultType);
}


/// Emit an ARC autorelease of the result of a function.
///
/// \return the value to actually return from the function
//<editor-fold defaultstate="collapsed" desc="emitAutoreleaseOfResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 2584,
 FQN="emitAutoreleaseOfResult", NM="_ZL23emitAutoreleaseOfResultRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL23emitAutoreleaseOfResultRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE")
//</editor-fold>
public static Value /*P*/ emitAutoreleaseOfResult(final CodeGenFunction /*&*/ CGF, 
                       Value /*P*/ result) {
  {
    // If we're returning 'self', kill the initial retain.  This is a
    // heuristic attempt to "encourage correctness" in the really unfortunate
    // case where we have a return of self during a dealloc and we desperately
    // need to avoid the possible autorelease.
    Value /*P*/ self = tryRemoveRetainOfSelf(CGF, result);
    if ((self != null)) {
      return self;
    }
  }
  
  // At -O0, try to emit a fused retain/autorelease.
  if (CGF.shouldUseFusedARCCalls()) {
    {
      Value /*P*/ fused = tryEmitFusedAutoreleaseOfResult(CGF, result);
      if ((fused != null)) {
        return fused;
      }
    }
  }
  
  return CGF.EmitARCAutoreleaseReturnValue(result);
}


/// Heuristically search for a dominating store to the return-value slot.
//<editor-fold defaultstate="collapsed" desc="findDominatingStoreToReturnValue">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 2602,
 FQN="findDominatingStoreToReturnValue", NM="_ZL32findDominatingStoreToReturnValueRN5clang7CodeGen15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL32findDominatingStoreToReturnValueRN5clang7CodeGen15CodeGenFunctionE")
//</editor-fold>
public static StoreInst /*P*/ findDominatingStoreToReturnValue(final CodeGenFunction /*&*/ CGF) {
  // Check if a User is a store which pointerOperand is the ReturnValue.
  // We are looking for stores to the ReturnValue, not for stores of the
  // ReturnValue to some other location.
  Type2RetType<User, StoreInst> GetStoreIfValid = /*[&CGF]*/ (User /*P*/ U) -> {
        StoreInst /*P*/ SI = dyn_cast_StoreInst(U);
        if (!(SI != null) || SI.getPointerOperand() != CGF.ReturnValue.getPointer()) {
          return null;
        }
        // These aren't actually possible for non-coerced returns, and we
        // only care about non-coerced returns on this code path.
        assert (!SI.isAtomic() && !SI.isVolatile());
        return SI;
      };
  // If there are multiple uses of the return-value slot, just check
  // for something immediately preceding the IP.  Sometimes this can
  // happen with how we generate implicit-returns; it can also happen
  // with noreturn cleanups.
  if (!CGF.ReturnValue.getPointer().hasOneUse()) {
    BasicBlock /*P*/ IP = CGF.Builder.GetInsertBlock();
    if (IP.empty()) {
      return null;
    }
    Instruction /*P*/ I = $AddrOf(IP.back());
    
    // Skip lifetime markers
    for (std.reverse_iterator<Instruction> II = IP.rbegin(), 
        IE = IP.rend();
         $noteq_reverse_iterator$C(II, IE); II.$preInc()) {
      {
        IntrinsicInst /*P*/ Intrinsic = dyn_cast_IntrinsicInst($AddrOf(II.$star()));
        if ((Intrinsic != null)) {
          if (Intrinsic.getIntrinsicID() == ID.lifetime_end) {
            /*const*/ Value /*P*/ CastAddr = Intrinsic.getArgOperand(1);
            II.$preInc();
            if ($eq_reverse_iterator$C(II, IE)) {
              break;
            }
            if (isa_BitCastInst($AddrOf(II.$star())) && (CastAddr == $AddrOf(II.$star()))) {
              continue;
            }
          }
        }
      }
      I = $AddrOf(II.$star());
      break;
    }
    
    return GetStoreIfValid.$call(I);
  }
  
  StoreInst /*P*/ store = GetStoreIfValid.$call(CGF.ReturnValue.getPointer().user_back$Value());
  if (!(store != null)) {
    return null;
  }
  
  // Now do a first-and-dirty dominance check: just walk up the
  // single-predecessors chain from the current insertion point.
  BasicBlock /*P*/ StoreBB = store.getParent();
  BasicBlock /*P*/ IP = CGF.Builder.GetInsertBlock();
  while (IP != StoreBB) {
    if (!((IP = IP.getSinglePredecessor()) != null)) {
      return null;
    }
  }
  
  // Okay, the store's basic block dominates the insertion point; we
  // can do our thing.
  return store;
}

//<editor-fold defaultstate="collapsed" desc="isInAllocaArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 2856,
 FQN="isInAllocaArgument", NM="_ZL18isInAllocaArgumentRN5clang7CodeGen8CGCXXABIENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL18isInAllocaArgumentRN5clang7CodeGen8CGCXXABIENS_8QualTypeE")
//</editor-fold>
public static boolean isInAllocaArgument(final CGCXXABI /*&*/ ABI, QualType type) {
  /*const*/ CXXRecordDecl /*P*/ RD = type.$arrow().getAsCXXRecordDecl();
  return (RD != null) && ABI.getRecordArgABI(RD) == CGCXXABI.RecordArgABI.RAA_DirectInMemory;
}

//<editor-fold defaultstate="collapsed" desc="createPlaceholderSlot">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 2861,
 FQN="createPlaceholderSlot", NM="_ZL21createPlaceholderSlotRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL21createPlaceholderSlotRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeE")
//</editor-fold>
public static AggValueSlot createPlaceholderSlot(final CodeGenFunction /*&*/ CGF, 
                     QualType Ty) {
  // FIXME: Generate IR in one pass, rather than going back and fixing up these
  // placeholders.
  org.llvm.ir.Type /*P*/ IRTy = CGF.ConvertTypeForMem(new QualType(Ty));
  Value /*P*/ Placeholder = UndefValue.get(IRTy.getPointerTo().getPointerTo());
  Placeholder = CGF.Builder.CreateDefaultAlignedLoad(Placeholder);
  
  // FIXME: When we generate this IR in one pass, we shouldn't need
  // this win32-specific alignment hack.
  CharUnits Align = CharUnits.fromQuantity(4);
  
  return AggValueSlot.forAddr(new Address(Placeholder, new CharUnits(Align)), 
      Ty.getQualifiers(), 
      AggValueSlot.IsDestructed_t.IsNotDestructed, 
      AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers, 
      AggValueSlot.IsAliased_t.IsNotAliased);
}

//<editor-fold defaultstate="collapsed" desc="isProvablyNull">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 2902,
 FQN="isProvablyNull", NM="_ZL14isProvablyNullPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL14isProvablyNullPN4llvm5ValueE")
//</editor-fold>
public static boolean isProvablyNull(Value /*P*/ addr) {
  return isa_ConstantPointerNull(addr);
}

//<editor-fold defaultstate="collapsed" desc="isProvablyNonNull">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 2906,
 FQN="isProvablyNonNull", NM="_ZL17isProvablyNonNullPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL17isProvablyNonNullPN4llvm5ValueE")
//</editor-fold>
public static boolean isProvablyNonNull(Value /*P*/ addr) {
  return isa_AllocaInst(addr);
}


/// Emit the actual writing-back of a writeback.
//<editor-fold defaultstate="collapsed" desc="emitWriteback">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 2911,
 FQN="emitWriteback", NM="_ZL13emitWritebackRN5clang7CodeGen15CodeGenFunctionERKNS0_11CallArgList9WritebackE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL13emitWritebackRN5clang7CodeGen15CodeGenFunctionERKNS0_11CallArgList9WritebackE")
//</editor-fold>
public static void emitWriteback(final CodeGenFunction /*&*/ CGF, 
             final /*const*/ CallArgList.Writeback /*&*/ writeback) {
  final /*const*/ LValue /*&*/ srcLV = writeback.Source;
  Address srcAddr = srcLV.getAddress();
  assert (!isProvablyNull(srcAddr.getPointer())) : "shouldn't have writeback for provably null argument";
  
  BasicBlock /*P*/ contBB = null;
  
  // If the argument wasn't provably non-null, we need to null check
  // before doing the store.
  boolean provablyNonNull = isProvablyNonNull(srcAddr.getPointer());
  if (!provablyNonNull) {
    BasicBlock /*P*/ writebackBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"icr.writeback"));
    contBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"icr.done"));
    
    Value /*P*/ isNull = CGF.Builder.CreateIsNull(srcAddr.getPointer(), new Twine(/*KEEP_STR*/"icr.isnull"));
    CGF.Builder.CreateCondBr(isNull, contBB, writebackBB);
    CGF.EmitBlock(writebackBB);
  }
  
  // Load the value to writeback.
  Value /*P*/ value = CGF.Builder.CreateLoad(new Address(writeback.Temporary));
  
  // Cast it back, in case we're writing an id to a Foo* or something.
  value = CGF.Builder.CreateBitCast(value, srcAddr.getElementType(), 
      new Twine(/*KEEP_STR*/"icr.writeback-cast"));
  
  // Perform the writeback.
  
  // If we have a "to use" value, it's something we need to emit a use
  // of.  This has to be carefully threaded in: if it's done after the
  // release it's potentially undefined behavior (and the optimizer
  // will ignore it), and if it happens before the retain then the
  // optimizer could move the release there.
  if ((writeback.ToUse != null)) {
    assert (srcLV.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Strong);
    
    // Retain the new value.  No need to block-copy here:  the block's
    // being passed up the stack.
    value = CGF.EmitARCRetainNonBlock(value);
    
    // Emit the intrinsic use here.
    CGF.EmitARCIntrinsicUse(new ArrayRef<Value /*P*/ >(writeback.ToUse, true));
    
    // Load the old value (primitively).
    Value /*P*/ oldValue = CGF.EmitLoadOfScalar(new LValue(srcLV), new SourceLocation());
    
    // Put the new value in place (primitively).
    CGF.EmitStoreOfScalar(value, new LValue(srcLV), /*init*/ false);
    
    // Release the old value.
    CGF.EmitARCRelease(oldValue, srcLV.isARCPreciseLifetime());
    // Otherwise, we can just do a normal lvalue store.
  } else {
    CGF.EmitStoreThroughLValue(RValue.get(value), new LValue(srcLV));
  }
  
  // Jump to the continuation block.
  if (!provablyNonNull) {
    CGF.EmitBlock(contBB);
  }
}

//<editor-fold defaultstate="collapsed" desc="emitWritebacks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 2976,
 FQN="emitWritebacks", NM="_ZL14emitWritebacksRN5clang7CodeGen15CodeGenFunctionERKNS0_11CallArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL14emitWritebacksRN5clang7CodeGen15CodeGenFunctionERKNS0_11CallArgListE")
//</editor-fold>
public static void emitWritebacks(final CodeGenFunction /*&*/ CGF, 
              final /*const*/ CallArgList /*&*/ args) {
  for (final /*const*/ CallArgList.Writeback /*&*/ I : args.writebacks())  {
    emitWriteback(CGF, I);
  }
}

//<editor-fold defaultstate="collapsed" desc="deactivateArgCleanupsBeforeCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 2982,
 FQN="deactivateArgCleanupsBeforeCall", NM="_ZL31deactivateArgCleanupsBeforeCallRN5clang7CodeGen15CodeGenFunctionERKNS0_11CallArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL31deactivateArgCleanupsBeforeCallRN5clang7CodeGen15CodeGenFunctionERKNS0_11CallArgListE")
//</editor-fold>
public static void deactivateArgCleanupsBeforeCall(final CodeGenFunction /*&*/ CGF, 
                               final /*const*/ CallArgList /*&*/ CallArgs) {
  assert (CGF.getTarget().getCXXABI().areArgsDestroyedLeftToRightInCallee());
  ArrayRef<CallArgList.CallArgCleanup> Cleanups = CallArgs.getCleanupsToDeactivate();
  // Iterate in reverse to increase the likelihood of popping the cleanup.
  for (final /*const*/ CallArgList.CallArgCleanup /*&*/ I : llvm.reverse$HasRBegin(Cleanups)) {
    CGF.DeactivateCleanupBlock(new EHScopeStack.stable_iterator(I.Cleanup), I.IsActiveIP);
    I.IsActiveIP.eraseFromParent();
  }
}

//<editor-fold defaultstate="collapsed" desc="maybeGetUnaryAddrOfOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 2994,
 FQN="maybeGetUnaryAddrOfOperand", NM="_ZL26maybeGetUnaryAddrOfOperandPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL26maybeGetUnaryAddrOfOperandPKN5clang4ExprE")
//</editor-fold>
public static /*const*/ Expr /*P*/ maybeGetUnaryAddrOfOperand(/*const*/ Expr /*P*/ E) {
  {
    /*const*/ UnaryOperator /*P*/ uop = dyn_cast_UnaryOperator(E.IgnoreParens$Const());
    if ((uop != null)) {
      if (uop.getOpcode() == UnaryOperatorKind.UO_AddrOf) {
        return uop.getSubExpr();
      }
    }
  }
  return null;
}


/// Emit an argument that's being passed call-by-writeback.  That is,
/// we are passing the address of an __autoreleased temporary; it
/// might be copy-initialized with the current value of the given
/// address, but it will definitely be copied out of after the call.
//<editor-fold defaultstate="collapsed" desc="emitWritebackArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3005,
 FQN="emitWritebackArg", NM="_ZL16emitWritebackArgRN5clang7CodeGen15CodeGenFunctionERNS0_11CallArgListEPKNS_27ObjCIndirectCopyRestoreExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL16emitWritebackArgRN5clang7CodeGen15CodeGenFunctionERNS0_11CallArgListEPKNS_27ObjCIndirectCopyRestoreExprE")
//</editor-fold>
public static void emitWritebackArg(final CodeGenFunction /*&*/ CGF, final CallArgList /*&*/ args, 
                /*const*/ ObjCIndirectCopyRestoreExpr /*P*/ CRE) {
  LValue srcLV/*J*/= new LValue();
  {
    
    // Make an optimistic effort to emit the address as an l-value.
    // This can fail if the argument expression is more complicated.
    /*const*/ Expr /*P*/ lvExpr = maybeGetUnaryAddrOfOperand(CRE.getSubExpr$Const());
    if ((lvExpr != null)) {
      srcLV.$assignMove(CGF.EmitLValue(lvExpr));
      // Otherwise, just emit it as a scalar.
    } else {
      Address srcAddr = CGF.EmitPointerWithAlignment(CRE.getSubExpr$Const());
      
      QualType srcAddrType = CRE.getSubExpr$Const().getType().$arrow().castAs(org.clang.ast.PointerType.class).getPointeeType();
      srcLV.$assignMove(CGF.MakeAddrLValue(new Address(srcAddr), new QualType(srcAddrType)));
    }
  }
  Address srcAddr = srcLV.getAddress();
  
  // The dest and src types don't necessarily match in LLVM terms
  // because of the crazy ObjC compatibility rules.
  org.llvm.ir.PointerType /*P*/ destType = cast_PointerType(CGF.ConvertType(CRE.getType()));
  
  // If the address is a constant null, just pass the appropriate null.
  if (isProvablyNull(srcAddr.getPointer())) {
    args.add(RValue.get(ConstantPointerNull.get(destType)), 
        CRE.getType());
    return;
  }
  
  // Create the temporary.
  Address temp = CGF.CreateTempAlloca(destType.getElementType(), 
      CGF.getPointerAlign(), 
      new Twine(/*KEEP_STR*/"icr.temp"));
  // Loading an l-value can introduce a cleanup if the l-value is __weak,
  // and that cleanup will be conditional if we can't prove that the l-value
  // isn't null, so we need to register a dominating point so that the cleanups
  // system will make valid IR.
  CodeGenFunction.ConditionalEvaluation condEval/*J*/= new CodeGenFunction.ConditionalEvaluation(CGF);
  
  // Zero-initialize it if we're not doing a copy-initialization.
  boolean shouldCopy = CRE.shouldCopy();
  if (!shouldCopy) {
    Value /*P*/ __null = ConstantPointerNull.get(cast_PointerType(destType.getElementType()));
    CGF.Builder.CreateStore(__null, new Address(temp));
  }
  
  BasicBlock /*P*/ contBB = null;
  BasicBlock /*P*/ originBB = null;
  
  // If the address is *not* known to be non-null, we need to switch.
  Value /*P*/ finalArgument;
  
  boolean provablyNonNull = isProvablyNonNull(srcAddr.getPointer());
  if (provablyNonNull) {
    finalArgument = temp.getPointer();
  } else {
    Value /*P*/ isNull = CGF.Builder.CreateIsNull(srcAddr.getPointer(), new Twine(/*KEEP_STR*/"icr.isnull"));
    
    finalArgument = CGF.Builder.CreateSelect(isNull, 
        ConstantPointerNull.get(destType), 
        temp.getPointer(), new Twine(/*KEEP_STR*/"icr.argument"));
    
    // If we need to copy, then the load has to be conditional, which
    // means we need control flow.
    if (shouldCopy) {
      originBB = CGF.Builder.GetInsertBlock();
      contBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"icr.cont"));
      BasicBlock /*P*/ copyBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"icr.copy"));
      CGF.Builder.CreateCondBr(isNull, contBB, copyBB);
      CGF.EmitBlock(copyBB);
      condEval.begin(CGF);
    }
  }
  
  Value /*P*/ valueToUse = null;
  
  // Perform a copy if necessary.
  if (shouldCopy) {
    RValue srcRV = CGF.EmitLoadOfLValue(new LValue(srcLV), new SourceLocation());
    assert (srcRV.isScalar());
    
    Value /*P*/ src = srcRV.getScalarVal();
    src = CGF.Builder.CreateBitCast(src, destType.getElementType(), 
        new Twine(/*KEEP_STR*/"icr.cast"));
    
    // Use an ordinary store, not a store-to-lvalue.
    CGF.Builder.CreateStore(src, new Address(temp));
    
    // If optimization is enabled, and the value was held in a
    // __strong variable, we need to tell the optimizer that this
    // value has to stay alive until we're doing the store back.
    // This is because the temporary is effectively unretained,
    // and so otherwise we can violate the high-level semantics.
    if ($2bits_uint2uint(CGF.CGM.getCodeGenOpts().OptimizationLevel) != 0
       && srcLV.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Strong) {
      valueToUse = src;
    }
  }
  
  // Finish the control flow if we needed it.
  if (shouldCopy && !provablyNonNull) {
    BasicBlock /*P*/ copyBB = CGF.Builder.GetInsertBlock();
    CGF.EmitBlock(contBB);
    
    // Make a phi for the value to intrinsically use.
    if ((valueToUse != null)) {
      PHINode /*P*/ phiToUse = CGF.Builder.CreatePHI(valueToUse.getType(), 2, 
          new Twine(/*KEEP_STR*/"icr.to-use"));
      phiToUse.addIncoming(valueToUse, copyBB);
      phiToUse.addIncoming(UndefValue.get(valueToUse.getType()), 
          originBB);
      valueToUse = phiToUse;
    }
    
    condEval.end(CGF);
  }
  
  args.addWriteback(new LValue(srcLV), new Address(temp), valueToUse);
  args.add(RValue.get(finalArgument), CRE.getType());
}


// Calls which may throw must have operand bundles indicating which funclet
// they are nested within.
//<editor-fold defaultstate="collapsed" desc="getBundlesForFunclet">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3395,
 FQN="getBundlesForFunclet", NM="_ZL20getBundlesForFuncletPN4llvm5ValueEPNS_11InstructionERNS_15SmallVectorImplINS_17OperandBundleDefTIS1_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL20getBundlesForFuncletPN4llvm5ValueEPNS_11InstructionERNS_15SmallVectorImplINS_17OperandBundleDefTIS1_EEEE")
//</editor-fold>
public static void getBundlesForFunclet(Value /*P*/ Callee, Instruction /*P*/ CurrentFuncletPad, 
                    final SmallVectorImpl<OperandBundleDefT<Value /*P*/ > > /*&*/ BundleList) {
  // There is no need for a funclet operand bundle if we aren't inside a
  // funclet.
  if (!(CurrentFuncletPad != null)) {
    return;
  }
  
  // Skip intrinsics which cannot throw.
  Function /*P*/ CalleeFn = dyn_cast_Function(Callee.stripPointerCasts());
  if ((CalleeFn != null) && CalleeFn.isIntrinsic() && CalleeFn.doesNotThrow()) {
    return;
  }
  
  BundleList.emplace_back(new OperandBundleDefT<Value /*P*/ >(new string("funclet"), new ArrayRef(CurrentFuncletPad)));
}


/// \brief Store a non-aggregate value to an address to initialize it.  For
/// initialization, a non-atomic store will be used.
//<editor-fold defaultstate="collapsed" desc="EmitInitStoreOfNonAggregate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3494,
 FQN="EmitInitStoreOfNonAggregate", NM="_ZL27EmitInitStoreOfNonAggregateRN5clang7CodeGen15CodeGenFunctionENS0_6RValueENS0_6LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZL27EmitInitStoreOfNonAggregateRN5clang7CodeGen15CodeGenFunctionENS0_6RValueENS0_6LValueE")
//</editor-fold>
public static void EmitInitStoreOfNonAggregate(final CodeGenFunction /*&*/ CGF, RValue Src, 
                           LValue Dst) {
  if (Src.isScalar()) {
    CGF.EmitStoreOfScalar(Src.getScalarVal(), new LValue(Dst), /*init=*/ true);
  } else {
    CGF.EmitStoreOfComplex(Src.getComplexVal(), new LValue(Dst), /*init=*/ true);
  }
}

} // END OF class CGCallStatics
