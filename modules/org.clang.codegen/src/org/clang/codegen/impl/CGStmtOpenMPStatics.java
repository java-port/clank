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
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.java.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clank.support.Native.$AddrOf;
import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$Move;
import org.clank.support.aliases.type$ptr;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CGStmtOpenMPStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.impl.CGStmtOpenMPStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL10castToBaseRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeES3_NS0_6LValueEPN4llvm5ValueE;_ZL11emitPreCondRN5clang7CodeGen15CodeGenFunctionERKNS_16OMPLoopDirectiveEPKNS_4ExprEPN4llvm10BasicBlockESB_y;_ZL11loadToBeginRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeES3_NS0_6LValueE;_ZL13convertToTypeRN5clang7CodeGen15CodeGenFunctionENS0_6RValueENS_8QualTypeES4_NS_14SourceLocationE;_ZL16EmitOMPHelperVarRN5clang7CodeGen15CodeGenFunctionEPKNS_11DeclRefExprE;_ZL16emitOMPAtomicRMWRN5clang7CodeGen15CodeGenFunctionENS0_6LValueENS0_6RValueENS_18BinaryOperatorKindEN4llvm14AtomicOrderingEb;_ZL16getReductionInitPKN5clang4ExprE;_ZL17EmitOMPAtomicExprRN5clang7CodeGen15CodeGenFunctionENS_16OpenMPClauseKindEbbPKNS_4ExprES6_S6_S6_bNS_14SourceLocationE;_ZL17createSectionLValRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeERKN4llvm5TwineEPNS4_5ValueE;_ZL17emitAlignedClauseRN5clang7CodeGen15CodeGenFunctionERKNS_22OMPExecutableDirectiveE;_ZL20EmitOMPAggregateInitRN5clang7CodeGen15CodeGenFunctionENS0_7AddressENS_8QualTypeEPKNS_4ExprES3_;_ZL20castValueFromUintptrRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeEN4llvm9StringRefENS0_6LValueEb;_ZL20convertToScalarValueRN5clang7CodeGen15CodeGenFunctionENS0_6RValueENS_8QualTypeES4_NS_14SourceLocationE;_ZL21EmitOMPAtomicReadExprRN5clang7CodeGen15CodeGenFunctionEbPKNS_4ExprES5_NS_14SourceLocationE;_ZL21convertToComplexValueRN5clang7CodeGen15CodeGenFunctionENS0_6RValueENS_8QualTypeES4_NS_14SourceLocationE;_ZL21emitSimpleAtomicStoreRN5clang7CodeGen15CodeGenFunctionEbNS0_6LValueENS0_6RValueE;_ZL22EmitOMPAtomicWriteExprRN5clang7CodeGen15CodeGenFunctionEbPKNS_4ExprES5_NS_14SourceLocationE;_ZL23EmitOMPAtomicUpdateExprRN5clang7CodeGen15CodeGenFunctionEbPKNS_4ExprES5_S5_bNS_14SourceLocationE;_ZL24EmitOMPAtomicCaptureExprRN5clang7CodeGen15CodeGenFunctionEbbPKNS_4ExprES5_S5_S5_bNS_14SourceLocationE;_ZL24emitSimdlenSafelenClauseRN5clang7CodeGen15CodeGenFunctionERKNS_22OMPExecutableDirectiveEb;_ZL27emitCommonOMPTeamsDirectiveRN5clang7CodeGen15CodeGenFunctionERKNS_22OMPExecutableDirectiveENS_19OpenMPDirectiveKindERKNS0_15RegionCodeGenTyE;_ZL27emitOutlinedOrderedFunctionRN5clang7CodeGen13CodeGenModuleEPKNS_12CapturedStmtE;_ZL30emitCommonOMPParallelDirectiveRN5clang7CodeGen15CodeGenFunctionERKNS_22OMPExecutableDirectiveENS_19OpenMPDirectiveKindERKNS0_15RegionCodeGenTyE;_ZL32emitInitWithReductionInitializerRN5clang7CodeGen15CodeGenFunctionEPKNS_23OMPDeclareReductionDeclEPKNS_4ExprENS0_7AddressES9_NS_8QualTypeE;_ZL32emitPostUpdateForReductionClauseRN5clang7CodeGen15CodeGenFunctionERKNS_22OMPExecutableDirectiveERKN4llvm12function_refIFPNS6_5ValueES2_EEE;_ZL8mapParamRN5clang7CodeGen15CodeGenFunctionEPKNS_11DeclRefExprEPKNS_17ImplicitParamDeclERNS1_15OMPPrivateScopeE; -static-type=CGStmtOpenMPStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGStmtOpenMPStatics {

//<editor-fold defaultstate="collapsed" desc="castValueFromUintptr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 172,
 FQN="castValueFromUintptr", NM="_ZL20castValueFromUintptrRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeEN4llvm9StringRefENS0_6LValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL20castValueFromUintptrRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeEN4llvm9StringRefENS0_6LValueEb")
//</editor-fold>
public static Address castValueFromUintptr(final CodeGenFunction /*&*/ CGF, QualType DstType, 
                    StringRef Name, LValue AddrLV) {
  return castValueFromUintptr(CGF, DstType, 
                    Name, AddrLV, 
                    false);
}
public static Address castValueFromUintptr(final CodeGenFunction /*&*/ CGF, QualType DstType, 
                    StringRef Name, LValue AddrLV, 
                    boolean isReferenceType/*= false*/) {
  final ASTContext /*&*/ Ctx = CGF.getContext();
  
  Value /*P*/ CastedPtr = CGF.EmitScalarConversion(AddrLV.getAddress().getPointer(), Ctx.getUIntPtrType(), 
      Ctx.getPointerType(/*NO_COPY*/DstType), new SourceLocation());
  Address TmpAddr = CGF.MakeNaturalAlignAddrLValue(CastedPtr, Ctx.getPointerType(/*NO_COPY*/DstType)).
      getAddress();
  
  // If we are dealing with references we need to return the address of the
  // reference instead of the reference of the value.
  if (isReferenceType) {
    QualType RefType = Ctx.getLValueReferenceType(new QualType(DstType));
    Value /*P*/ RefVal = TmpAddr.getPointer();
    TmpAddr.$assignMove(CGF.CreateMemTemp(new QualType(RefType), $add_Twine$C(new Twine(Name), new Twine(/*KEEP_STR*/".ref"))));
    LValue TmpLVal = CGF.MakeAddrLValue(new Address(TmpAddr), new QualType(RefType));
    CGF.EmitScalarInit(RefVal, new LValue(TmpLVal));
  }
  
  return TmpAddr;
}


/// Check if the combiner is a call to UDR combiner and if it is so return the
/// UDR decl used for reduction.
//<editor-fold defaultstate="collapsed" desc="getReductionInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 386,
 FQN="getReductionInit", NM="_ZL16getReductionInitPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL16getReductionInitPKN5clang4ExprE")
//</editor-fold>
public static /*const*/ OMPDeclareReductionDecl /*P*/ getReductionInit(/*const*/ Expr /*P*/ ReductionOp) {
  {
    /*const*/ CallExpr /*P*/ CE = dyn_cast_CallExpr(ReductionOp);
    if ((CE != null)) {
      {
        /*const*/ OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(CE.getCallee$Const());
        if ((OVE != null)) {
          {
            DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(OVE.getSourceExpr().IgnoreImpCasts());
            if ((DRE != null)) {
              {
                OMPDeclareReductionDecl /*P*/ DRD = dyn_cast_OMPDeclareReductionDecl(DRE.getDecl());
                if ((DRD != null)) {
                  return DRD;
                }
              }
            }
          }
        }
      }
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="emitInitWithReductionInitializer">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 397,
 FQN="emitInitWithReductionInitializer", NM="_ZL32emitInitWithReductionInitializerRN5clang7CodeGen15CodeGenFunctionEPKNS_23OMPDeclareReductionDeclEPKNS_4ExprENS0_7AddressES9_NS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL32emitInitWithReductionInitializerRN5clang7CodeGen15CodeGenFunctionEPKNS_23OMPDeclareReductionDeclEPKNS_4ExprENS0_7AddressES9_NS_8QualTypeE")
//</editor-fold>
public static void emitInitWithReductionInitializer(final CodeGenFunction /*&*/ CGF, 
                                /*const*/ OMPDeclareReductionDecl /*P*/ DRD, 
                                /*const*/ Expr /*P*/ InitOp, 
                                Address Private, Address Original, 
                                QualType Ty) {
  if ((DRD.getInitializer$Const() != null)) {
    CodeGenFunction.OMPPrivateScope PrivateScope = null;
    CodeGenFunction.OpaqueValueMapping Map = null;
    try {
      std.pair<Function /*P*/ , Function /*P*/ > Reduction = CGF.CGM.getOpenMPRuntime().getUserDefinedReduction(DRD);
      /*const*/ CallExpr /*P*/ CE = cast_CallExpr(InitOp);
      /*const*/ OpaqueValueExpr /*P*/ OVE = cast_OpaqueValueExpr(CE.getCallee$Const());
      /*const*/ Expr /*P*/ LHS = CE.getArg$Const(/*Arg=*/ 0).IgnoreParenImpCasts$Const();
      /*const*/ Expr /*P*/ RHS = CE.getArg$Const(/*Arg=*/ 1).IgnoreParenImpCasts$Const();
      DeclRefExpr /*P*/ LHSDRE = cast_DeclRefExpr(cast_UnaryOperator(LHS).getSubExpr());
      DeclRefExpr /*P*/ RHSDRE = cast_DeclRefExpr(cast_UnaryOperator(RHS).getSubExpr());
      PrivateScope/*J*/= new CodeGenFunction.OMPPrivateScope(CGF);
      PrivateScope.addPrivate(cast_VarDecl(LHSDRE.getDecl()), 
          /*FuncArg*//*[=, =L$Private(Private)]*/ () -> {
                return new Address(Private);
              });
      PrivateScope.addPrivate(cast_VarDecl(RHSDRE.getDecl()), 
          /*FuncArg*//*[=, =L$Original(Original)]*/ () -> {
                return new Address(Original);
              });
      /*J:(void)*/PrivateScope.Privatize();
      RValue Func = RValue.get(Reduction.second);
      Map/*J*/= new CodeGenFunction.OpaqueValueMapping(CGF, OVE, new RValue(Func));
      CGF.EmitIgnoredExpr(InitOp);
    } finally {
      if (Map != null) { Map.$destroy(); }
      if (PrivateScope != null) { PrivateScope.$destroy(); }
    }
  } else {
    CodeGenFunction.OpaqueValueMapping OpaqueMap = null;
    try {
      Constant /*P*/ Init = CGF.CGM.EmitNullConstant(new QualType(Ty));
      GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGF.CGM.getModule(), Init.getType(), /*isConstant=*/ true, 
          GlobalValue.LinkageTypes.PrivateLinkage, Init, new Twine(/*KEEP_STR*/".init"));
       });
      LValue LV = CGF.MakeNaturalAlignAddrLValue(GV, new QualType(Ty));
      RValue InitRVal/*J*/= new RValue();
      switch (CGF.getEvaluationKind(new QualType(Ty))) {
       case TEK_Scalar:
        InitRVal.$assignMove(CGF.EmitLoadOfLValue(new LValue(LV), new SourceLocation()));
        break;
       case TEK_Complex:
        InitRVal.$assignMove(
            RValue.getComplex(CGF.EmitLoadOfComplex(new LValue(LV), new SourceLocation()))
        );
        break;
       case TEK_Aggregate:
        InitRVal.$assignMove(RValue.getAggregate(LV.getAddress()));
        break;
      }
      OpaqueValueExpr OVE/*J*/= new OpaqueValueExpr(new SourceLocation(), new QualType(Ty), ExprValueKind.VK_RValue);
      OpaqueMap/*J*/= new CodeGenFunction.OpaqueValueMapping(CGF, $AddrOf(OVE), new RValue(InitRVal));
      CGF.EmitAnyExprToMem($AddrOf(OVE), new Address(Private), Ty.getQualifiers(), 
          /*IsInitializer=*/ false);
    } finally {
      if (OpaqueMap != null) { OpaqueMap.$destroy(); }
    }
  }
}


/// \brief Emit initialization of arrays of complex types.
/// \param DestAddr Address of the array.
/// \param Type Type of array.
/// \param Init Initial expression of array.
/// \param SrcAddr Address of the original array.
//<editor-fold defaultstate="collapsed" desc="EmitOMPAggregateInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 451,
 FQN="EmitOMPAggregateInit", NM="_ZL20EmitOMPAggregateInitRN5clang7CodeGen15CodeGenFunctionENS0_7AddressENS_8QualTypeEPKNS_4ExprES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL20EmitOMPAggregateInitRN5clang7CodeGen15CodeGenFunctionENS0_7AddressENS_8QualTypeEPKNS_4ExprES3_")
//</editor-fold>
public static void EmitOMPAggregateInit(final CodeGenFunction /*&*/ CGF, Address DestAddr, 
                    QualType Type, /*const*/ Expr /*P*/ Init) {
  EmitOMPAggregateInit(CGF, DestAddr, 
                    Type, Init, 
                    Address.invalid());
}
public static void EmitOMPAggregateInit(final CodeGenFunction /*&*/ CGF, Address DestAddr, 
                    QualType Type, /*const*/ Expr /*P*/ Init, 
                    Address SrcAddr/*= Address::invalid()*/) {
  /*const*/ OMPDeclareReductionDecl /*P*/ DRD = getReductionInit(Init);
  // Perform element-by-element initialization.
  QualType ElementTy/*J*/= new QualType();
  
  // Drill down to the base element type on both arrays.
  /*const*/ org.clang.ast.ArrayType /*P*/ ArrayTy = Type.$arrow().getAsArrayTypeUnsafe();
  Value /*P*/ NumElements = CGF.emitArrayLength(ArrayTy, ElementTy, DestAddr);
  DestAddr.$assignMove(
      CGF.Builder.CreateElementBitCast(new Address(DestAddr), DestAddr.getElementType())
  );
  if ((DRD != null)) {
    SrcAddr.$assignMove(
        CGF.Builder.CreateElementBitCast(new Address(SrcAddr), DestAddr.getElementType())
    );
  }
  
  Value /*P*/ SrcBegin = null;
  if ((DRD != null)) {
    SrcBegin = SrcAddr.getPointer();
  }
  Value /*P*/ DestBegin = DestAddr.getPointer();
  // Cast from pointer to array type to pointer to single element.
  Value /*P*/ DestEnd = CGF.Builder.CreateGEP(DestBegin, NumElements);
  // The basic structure here is a while-do loop.
  BasicBlock /*P*/ BodyBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"omp.arrayinit.body"));
  BasicBlock /*P*/ DoneBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"omp.arrayinit.done"));
  Value /*P*/ IsEmpty = CGF.Builder.CreateICmpEQ(DestBegin, DestEnd, new Twine(/*KEEP_STR*/"omp.arrayinit.isempty"));
  CGF.Builder.CreateCondBr(IsEmpty, DoneBB, BodyBB);
  
  // Enter the loop body, making that address the current address.
  BasicBlock /*P*/ EntryBB = CGF.Builder.GetInsertBlock();
  CGF.EmitBlock(BodyBB);
  
  CharUnits ElementSize = CGF.getContext().getTypeSizeInChars(/*NO_COPY*/ElementTy);
  
  PHINode /*P*/ SrcElementPHI = null;
  Address SrcElementCurrent = Address.invalid();
  if ((DRD != null)) {
    SrcElementPHI = CGF.Builder.CreatePHI(SrcBegin.getType(), 2, 
        new Twine(/*KEEP_STR*/"omp.arraycpy.srcElementPast"));
    SrcElementPHI.addIncoming(SrcBegin, EntryBB);
    SrcElementCurrent.$assignMove(
        new Address(SrcElementPHI, 
            SrcAddr.getAlignment().alignmentOfArrayElement(new CharUnits(ElementSize)))
    );
  }
  PHINode /*P*/ DestElementPHI = CGF.Builder.CreatePHI(DestBegin.getType(), 2, new Twine(/*KEEP_STR*/"omp.arraycpy.destElementPast"));
  DestElementPHI.addIncoming(DestBegin, EntryBB);
  Address DestElementCurrent = new Address(DestElementPHI, 
      DestAddr.getAlignment().alignmentOfArrayElement(new CharUnits(ElementSize)));
  {
    CodeGenFunction.RunCleanupsScope InitScope = null;
    try {
      InitScope/*J*/= new CodeGenFunction.RunCleanupsScope(CGF);
      if ((DRD != null) && ((DRD.getInitializer$Const() != null) || !(Init != null))) {
        emitInitWithReductionInitializer(CGF, DRD, Init, new Address(DestElementCurrent), 
            new Address(SrcElementCurrent), new QualType(ElementTy));
      } else {
        CGF.EmitAnyExprToMem(Init, new Address(DestElementCurrent), ElementTy.getQualifiers(), 
            /*IsInitializer=*/ false);
      }
    } finally {
      if (InitScope != null) { InitScope.$destroy(); }
    }
  }
  if ((DRD != null)) {
    // Shift the address forward by one element.
    Value /*P*/ SrcElementNext = CGF.Builder.CreateConstGEP1_32(SrcElementPHI, /*Idx0=*/ 1, new Twine(/*KEEP_STR*/"omp.arraycpy.dest.element"));
    SrcElementPHI.addIncoming(SrcElementNext, CGF.Builder.GetInsertBlock());
  }
  
  // Shift the address forward by one element.
  Value /*P*/ DestElementNext = CGF.Builder.CreateConstGEP1_32(DestElementPHI, /*Idx0=*/ 1, new Twine(/*KEEP_STR*/"omp.arraycpy.dest.element"));
  // Check whether we've reached the end.
  Value /*P*/ Done = CGF.Builder.CreateICmpEQ(DestElementNext, DestEnd, new Twine(/*KEEP_STR*/"omp.arraycpy.done"));
  CGF.Builder.CreateCondBr(Done, DoneBB, BodyBB);
  DestElementPHI.addIncoming(DestElementNext, CGF.Builder.GetInsertBlock());
  
  // Done.
  CGF.EmitBlock(DoneBB, /*IsFinished=*/ true);
}

//<editor-fold defaultstate="collapsed" desc="castToBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 886,
 FQN="castToBase", NM="_ZL10castToBaseRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeES3_NS0_6LValueEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL10castToBaseRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeES3_NS0_6LValueEPN4llvm5ValueE")
//</editor-fold>
public static Address castToBase(final CodeGenFunction /*&*/ CGF, QualType BaseTy, QualType ElTy, 
          LValue BaseLV, Value /*P*/ Addr) {
  Address Tmp = Address.invalid();
  Address TopTmp = Address.invalid();
  Address MostTopTmp = Address.invalid();
  BaseTy.$assignMove(BaseTy.getNonReferenceType());
  while ((BaseTy.$arrow().isPointerType() || BaseTy.$arrow().isReferenceType())
     && !CGF.getContext().hasSameType(new QualType(BaseTy), new QualType(ElTy))) {
    Tmp.$assignMove(CGF.CreateMemTemp(new QualType(BaseTy)));
    if (TopTmp.isValid()) {
      CGF.Builder.CreateStore(Tmp.getPointer(), new Address(TopTmp));
    } else {
      MostTopTmp.$assign(Tmp);
    }
    TopTmp.$assign(Tmp);
    BaseTy.$assignMove(BaseTy.$arrow().getPointeeType());
  }
  org.llvm.ir.Type /*P*/ Ty = BaseLV.getPointer().getType();
  if (Tmp.isValid()) {
    Ty = Tmp.getElementType();
  }
  Addr = CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(Addr, Ty);
  if (Tmp.isValid()) {
    CGF.Builder.CreateStore(Addr, new Address(Tmp));
    return MostTopTmp;
  }
  return new Address(Addr, BaseLV.getAlignment());
}

//<editor-fold defaultstate="collapsed" desc="loadToBegin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 913,
 FQN="loadToBegin", NM="_ZL11loadToBeginRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeES3_NS0_6LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL11loadToBeginRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeES3_NS0_6LValueE")
//</editor-fold>
public static LValue loadToBegin(final CodeGenFunction /*&*/ CGF, QualType BaseTy, QualType ElTy, 
           LValue BaseLV) {
  BaseTy.$assignMove(BaseTy.getNonReferenceType());
  while ((BaseTy.$arrow().isPointerType() || BaseTy.$arrow().isReferenceType())
     && !CGF.getContext().hasSameType(new QualType(BaseTy), new QualType(ElTy))) {
    {
      /*const*/ org.clang.ast.PointerType /*P*/ PtrTy = BaseTy.$arrow().getAs(org.clang.ast.PointerType.class);
      if ((PtrTy != null)) {
        BaseLV.$assignMove(CGF.EmitLoadOfPointerLValue(BaseLV.getAddress(), PtrTy));
      } else {
        BaseLV.$assignMove(CGF.EmitLoadOfReferenceLValue(BaseLV.getAddress(), 
                BaseTy.$arrow().castAs(ReferenceType.class)));
      }
    }
    BaseTy.$assignMove(BaseTy.$arrow().getPointeeType());
  }
  return CGF.MakeAddrLValue(new Address(CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(BaseLV.getPointer(), CGF.ConvertTypeForMem(new QualType(ElTy)).getPointerTo()), 
          BaseLV.getAlignment()), 
      BaseLV.getType(), BaseLV.getAlignmentSource());
}

//<editor-fold defaultstate="collapsed" desc="emitPostUpdateForReductionClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1165,
 FQN="emitPostUpdateForReductionClause", NM="_ZL32emitPostUpdateForReductionClauseRN5clang7CodeGen15CodeGenFunctionERKNS_22OMPExecutableDirectiveERKN4llvm12function_refIFPNS6_5ValueES2_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL32emitPostUpdateForReductionClauseRN5clang7CodeGen15CodeGenFunctionERKNS_22OMPExecutableDirectiveERKN4llvm12function_refIFPNS6_5ValueES2_EEE")
//</editor-fold>
public static void emitPostUpdateForReductionClause(final CodeGenFunction /*&*/ CGF, final /*const*/ OMPExecutableDirective /*&*/ D, 
                                final /*const*/CodeGenFunction.ValueProducer /*&*/ CondGen) {
  if (!CGF.HaveInsertPoint()) {
    return;
  }
  BasicBlock /*P*/ DoneBB = null;
  for (/*const*/ OMPReductionClause /*P*/ C : D.<OMPReductionClause>getClausesOfKind(OMPReductionClause.class)) {
    {
      /*const*/ Expr /*P*/ PostUpdate = C.getPostUpdateExpr$Const();
      if ((PostUpdate != null)) {
        if (!(DoneBB != null)) {
          {
            Value /*P*/ Cond = CondGen.$call(CGF);
            if ((Cond != null)) {
              // If the first post-update expression is found, emit conditional
              // block if it was requested.
              BasicBlock /*P*/ ThenBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".omp.reduction.pu"));
              DoneBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".omp.reduction.pu.done"));
              CGF.Builder.CreateCondBr(Cond, ThenBB, DoneBB);
              CGF.EmitBlock(ThenBB);
            }
          }
        }
        CGF.EmitIgnoredExpr(PostUpdate);
      }
    }
  }
  if ((DoneBB != null)) {
    CGF.EmitBlock(DoneBB, /*IsFinished=*/ true);
  }
}

//<editor-fold defaultstate="collapsed" desc="emitCommonOMPParallelDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1190,
 FQN="emitCommonOMPParallelDirective", NM="_ZL30emitCommonOMPParallelDirectiveRN5clang7CodeGen15CodeGenFunctionERKNS_22OMPExecutableDirectiveENS_19OpenMPDirectiveKindERKNS0_15RegionCodeGenTyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL30emitCommonOMPParallelDirectiveRN5clang7CodeGen15CodeGenFunctionERKNS_22OMPExecutableDirectiveENS_19OpenMPDirectiveKindERKNS0_15RegionCodeGenTyE")
//</editor-fold>
public static void emitCommonOMPParallelDirective(final CodeGenFunction /*&*/ CGF, 
                              final /*const*/ OMPExecutableDirective /*&*/ S, 
                              OpenMPDirectiveKind InnermostKind, 
                              final /*const*/ RegionCodeGenTy /*&*/ CodeGen) {
  OMPLexicalScope Scope = null;
  try {
    CapturedStmt /*P*/ CS = cast_CapturedStmt(S.getAssociatedStmt());
    Value /*P*/ OutlinedFn = CGF.CGM.getOpenMPRuntime().
        emitParallelOrTeamsOutlinedFunction(S, 
        CS.getCapturedDecl().param_begin().$star(), InnermostKind, CodeGen);
    {
      /*const*/ OMPNumThreadsClause /*P*/ NumThreadsClause = S.<OMPNumThreadsClause>getSingleClause(OMPNumThreadsClause.class);
      if ((NumThreadsClause != null)) {
        CodeGenFunction.RunCleanupsScope NumThreadsScope = null;
        try {
          NumThreadsScope/*J*/= new CodeGenFunction.RunCleanupsScope(CGF);
          Value /*P*/ NumThreads = CGF.EmitScalarExpr(NumThreadsClause.getNumThreads(), 
              /*IgnoreResultAssign*/ true);
          CGF.CGM.getOpenMPRuntime().emitNumThreadsClause(CGF, NumThreads, NumThreadsClause.getLocStart());
        } finally {
          if (NumThreadsScope != null) { NumThreadsScope.$destroy(); }
        }
      }
    }
    {
      /*const*/ OMPProcBindClause /*P*/ ProcBindClause = S.<OMPProcBindClause>getSingleClause(OMPProcBindClause.class);
      if ((ProcBindClause != null)) {
        CodeGenFunction.RunCleanupsScope ProcBindScope = null;
        try {
          ProcBindScope/*J*/= new CodeGenFunction.RunCleanupsScope(CGF);
          CGF.CGM.getOpenMPRuntime().emitProcBindClause(CGF, ProcBindClause.getProcBindKind(), ProcBindClause.getLocStart());
        } finally {
          if (ProcBindScope != null) { ProcBindScope.$destroy(); }
        }
      }
    }
    /*const*/ Expr /*P*/ IfCond = null;
    for (/*const*/ OMPIfClause /*P*/ C : S.<OMPIfClause>getClausesOfKind(OMPIfClause.class)) {
      if (C.getNameModifier() == OpenMPDirectiveKind.OMPD_unknown
         || C.getNameModifier() == OpenMPDirectiveKind.OMPD_parallel) {
        IfCond = C.getCondition();
        break;
      }
    }
    
    Scope/*J*/= new OMPLexicalScope(CGF, S);
    SmallVector<Value /*P*/ > CapturedVars/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
    CGF.GenerateOpenMPCapturedVars($Deref(CS), CapturedVars);
    CGF.CGM.getOpenMPRuntime().emitParallelCall(CGF, S.getLocStart(), OutlinedFn, 
        new ArrayRef<Value /*P*/ >(CapturedVars, true), IfCond);
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="emitAlignedClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1391,
 FQN="emitAlignedClause", NM="_ZL17emitAlignedClauseRN5clang7CodeGen15CodeGenFunctionERKNS_22OMPExecutableDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL17emitAlignedClauseRN5clang7CodeGen15CodeGenFunctionERKNS_22OMPExecutableDirectiveE")
//</editor-fold>
public static void emitAlignedClause(final CodeGenFunction /*&*/ CGF, 
                 final /*const*/ OMPExecutableDirective /*&*/ D) {
  if (!CGF.HaveInsertPoint()) {
    return;
  }
  for (/*const*/ OMPAlignedClause /*P*/ Clause : D.<OMPAlignedClause>getClausesOfKind(OMPAlignedClause.class)) {
    /*uint*/int ClauseAlignment = 0;
    {
      /*const*/ Expr /*P*/ AlignmentExpr = Clause.getAlignment$Const();
      if ((AlignmentExpr != null)) {
        ConstantInt /*P*/ AlignmentCI = cast_ConstantInt(CGF.EmitScalarExpr(AlignmentExpr));
        ClauseAlignment = ((/*static_cast*//*uint*/int)($ulong2uint(AlignmentCI.getZExtValue())));
      }
    }
    for (/*const*/ Expr /*P*/ E : Clause.varlists$Const()) {
      /*uint*/int Alignment = ClauseAlignment;
      if (Alignment == 0) {
        // OpenMP [2.8.1, Description]
        // If no optional parameter is specified, implementation-defined default
        // alignments for SIMD instructions on the target platforms are assumed.
        Alignment
           = $long2uint(CGF.getContext().
            toCharUnitsFromBits($uint2long(CGF.getContext().getOpenMPDefaultSimdAlign(E.getType().$arrow().getPointeeType()))).
            getQuantity());
      }
      assert ((Alignment == 0 || llvm.isPowerOf2_32(Alignment))) : "alignment is not power of 2";
      if (Alignment != 0) {
        Value /*P*/ PtrValue = CGF.EmitScalarExpr(E);
        CGF.EmitAlignmentAssumption(PtrValue, Alignment);
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="emitPreCond">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1456,
 FQN="emitPreCond", NM="_ZL11emitPreCondRN5clang7CodeGen15CodeGenFunctionERKNS_16OMPLoopDirectiveEPKNS_4ExprEPN4llvm10BasicBlockESB_y",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL11emitPreCondRN5clang7CodeGen15CodeGenFunctionERKNS_16OMPLoopDirectiveEPKNS_4ExprEPN4llvm10BasicBlockESB_y")
//</editor-fold>
public static void emitPreCond(final CodeGenFunction /*&*/ CGF, final /*const*/ OMPLoopDirective /*&*/ S, 
           /*const*/ Expr /*P*/ Cond, BasicBlock /*P*/ TrueBlock, 
           BasicBlock /*P*/ FalseBlock, long/*uint64_t*/ TrueCount) {
  if (!CGF.HaveInsertPoint()) {
    return;
  }
  {
    CodeGenFunction.OMPPrivateScope PreCondScope = null;
    try {
      PreCondScope/*J*/= new CodeGenFunction.OMPPrivateScope(CGF);
      CGF.EmitOMPPrivateLoopCounters(S, PreCondScope);
      /*J:(void)*/PreCondScope.Privatize();
      // Get initial values of real counters.
      for (Expr /*P*/ I : S.inits$Const()) {
        CGF.EmitIgnoredExpr(I);
      }
    } finally {
      if (PreCondScope != null) { PreCondScope.$destroy(); }
    }
  }
  // Check that loop is executed at least one time.
  CGF.EmitBranchOnBoolExpr(Cond, TrueBlock, FalseBlock, TrueCount);
}

//<editor-fold defaultstate="collapsed" desc="emitSimdlenSafelenClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1508,
 FQN="emitSimdlenSafelenClause", NM="_ZL24emitSimdlenSafelenClauseRN5clang7CodeGen15CodeGenFunctionERKNS_22OMPExecutableDirectiveEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL24emitSimdlenSafelenClauseRN5clang7CodeGen15CodeGenFunctionERKNS_22OMPExecutableDirectiveEb")
//</editor-fold>
public static void emitSimdlenSafelenClause(final CodeGenFunction /*&*/ CGF, 
                        final /*const*/ OMPExecutableDirective /*&*/ D, 
                        boolean IsMonotonic) {
  if (!CGF.HaveInsertPoint()) {
    return;
  }
  {
    /*const*/ OMPSimdlenClause /*P*/ C = D.<OMPSimdlenClause>getSingleClause(OMPSimdlenClause.class);
    if ((C != null)) {
      RValue Len = CGF.EmitAnyExpr(C.getSimdlen(), AggValueSlot.ignored(), 
          /*ignoreResult=*/ true);
      ConstantInt /*P*/ Val = cast_ConstantInt(Len.getScalarVal());
      CGF.LoopStack.setVectorizeWidth($ulong2uint(Val.getZExtValue()));
      // In presence of finite 'safelen', it may be unsafe to mark all
      // the memory instructions parallel, because loop-carried
      // dependences of 'safelen' iterations are possible.
      if (!IsMonotonic) {
        CGF.LoopStack.setParallel(!(D.<OMPSafelenClause>getSingleClause(OMPSafelenClause.class) != null));
      }
    } else {
      /*const*/ OMPSafelenClause /*P*/ C$1 = D.<OMPSafelenClause>getSingleClause(OMPSafelenClause.class);
      if ((C$1 != null)) {
        RValue Len = CGF.EmitAnyExpr(C$1.getSafelen(), AggValueSlot.ignored(), 
            /*ignoreResult=*/ true);
        ConstantInt /*P*/ Val = cast_ConstantInt(Len.getScalarVal());
        CGF.LoopStack.setVectorizeWidth($ulong2uint(Val.getZExtValue()));
        // In presence of finite 'safelen', it may be unsafe to mark all
        // the memory instructions parallel, because loop-carried
        // dependences of 'safelen' iterations are possible.
        CGF.LoopStack.setParallel(false);
      }
    }
  }
}


/// \brief Emit a helper variable and return corresponding lvalue.
//<editor-fold defaultstate="collapsed" desc="EmitOMPHelperVar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1917,
 FQN="EmitOMPHelperVar", NM="_ZL16EmitOMPHelperVarRN5clang7CodeGen15CodeGenFunctionEPKNS_11DeclRefExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL16EmitOMPHelperVarRN5clang7CodeGen15CodeGenFunctionEPKNS_11DeclRefExprE")
//</editor-fold>
public static LValue EmitOMPHelperVar(final CodeGenFunction /*&*/ CGF, 
                /*const*/ DeclRefExpr /*P*/ Helper) {
  /*const*/ VarDecl /*P*/ VDecl = cast_VarDecl(Helper.getDecl$Const());
  CGF.EmitVarDecl($Deref(VDecl));
  return CGF.EmitLValue(Helper);
}

//<editor-fold defaultstate="collapsed" desc="createSectionLVal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2144,
 FQN="createSectionLVal", NM="_ZL17createSectionLValRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeERKN4llvm5TwineEPNS4_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL17createSectionLValRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeERKN4llvm5TwineEPNS4_5ValueE")
//</editor-fold>
public static LValue createSectionLVal(final CodeGenFunction /*&*/ CGF, QualType Ty, 
                 final /*const*/ Twine /*&*/ Name) {
  return createSectionLVal(CGF, Ty, 
                 Name, 
                 (Value /*P*/ )null);
}
public static LValue createSectionLVal(final CodeGenFunction /*&*/ CGF, QualType Ty, 
                 final /*const*/ Twine /*&*/ Name, 
                 Value /*P*/ Init/*= null*/) {
  LValue LVal = CGF.MakeAddrLValue(CGF.CreateMemTemp(new QualType(Ty), Name), new QualType(Ty));
  if ((Init != null)) {
    CGF.EmitScalarInit(Init, new LValue(LVal));
  }
  return LVal;
}

//<editor-fold defaultstate="collapsed" desc="emitOutlinedOrderedFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2746,
 FQN="emitOutlinedOrderedFunction", NM="_ZL27emitOutlinedOrderedFunctionRN5clang7CodeGen13CodeGenModuleEPKNS_12CapturedStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL27emitOutlinedOrderedFunctionRN5clang7CodeGen13CodeGenModuleEPKNS_12CapturedStmtE")
//</editor-fold>
public static Function /*P*/ emitOutlinedOrderedFunction(final CodeGenModule /*&*/ CGM, 
                           /*const*/ CapturedStmt /*P*/ S) {
  CodeGenFunction CGF = null;
  CodeGenFunction.CGCapturedStmtInfo CapStmtInfo = null;
  try {
    CGF/*J*/= new CodeGenFunction(CGM, /*suppressNewContext=*/ true);
    CapStmtInfo/*J*/= new CodeGenFunction.CGCapturedStmtInfo();
    CGF.CapturedStmtInfo = $AddrOf(CapStmtInfo);
    Function /*P*/ Fn = CGF.GenerateOpenMPCapturedStmtFunction($Deref(S));
    Fn.addFnAttr(Attribute.AttrKind.NoInline);
    return Fn;
  } finally {
    if (CapStmtInfo != null) { CapStmtInfo.$destroy(); }
    if (CGF != null) { CGF.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="convertToScalarValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2781,
 FQN="convertToScalarValue", NM="_ZL20convertToScalarValueRN5clang7CodeGen15CodeGenFunctionENS0_6RValueENS_8QualTypeES4_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL20convertToScalarValueRN5clang7CodeGen15CodeGenFunctionENS0_6RValueENS_8QualTypeES4_NS_14SourceLocationE")
//</editor-fold>
public static Value /*P*/ convertToScalarValue(final CodeGenFunction /*&*/ CGF, RValue Val, 
                    QualType SrcType, QualType DestType, 
                    SourceLocation Loc) {
  assert (CGF.hasScalarEvaluationKind(new QualType(DestType))) : "DestType must have scalar evaluation kind.";
  assert (!Val.isAggregate()) : "Must be a scalar or complex.";
  return Val.isScalar() ? CGF.EmitScalarConversion(Val.getScalarVal(), new QualType(SrcType), new QualType(DestType), 
      new SourceLocation(Loc)) : CGF.EmitComplexToScalarConversion(Val.getComplexVal(), new QualType(SrcType), 
      new QualType(DestType), new SourceLocation(Loc));
}

//<editor-fold defaultstate="collapsed" desc="convertToComplexValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2794,
 FQN="convertToComplexValue", NM="_ZL21convertToComplexValueRN5clang7CodeGen15CodeGenFunctionENS0_6RValueENS_8QualTypeES4_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL21convertToComplexValueRN5clang7CodeGen15CodeGenFunctionENS0_6RValueENS_8QualTypeES4_NS_14SourceLocationE")
//</editor-fold>
public static std.pairPtrPtr<Value /*P*/ , Value /*P*/ > convertToComplexValue(final CodeGenFunction /*&*/ CGF, RValue Val, QualType SrcType, 
                     QualType DestType, SourceLocation Loc) {
  assert (CGF.getEvaluationKind(new QualType(DestType)) == TypeEvaluationKind.TEK_Complex) : "DestType must have complex evaluation kind.";
  std.pairPtrPtr<Value /*P*/ , Value /*P*/ > ComplexVal/*J*/= new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >();
  if (Val.isScalar()) {
    // Convert the input element to the element type of the complex.
    QualType DestElementType = DestType.$arrow().castAs(ComplexType.class).getElementType();
    Value /*P*/ ScalarVal = CGF.EmitScalarConversion(Val.getScalarVal(), new QualType(SrcType), 
        new QualType(DestElementType), new SourceLocation(Loc));
    ComplexVal.$assignMove(new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, ScalarVal, Constant.getNullValue(ScalarVal.getType())));
  } else {
    assert (Val.isComplex()) : "Must be a scalar or complex.";
    QualType SrcElementType = SrcType.$arrow().castAs(ComplexType.class).getElementType();
    QualType DestElementType = DestType.$arrow().castAs(ComplexType.class).getElementType();
    ComplexVal.first = CGF.EmitScalarConversion(Val.getComplexVal().first, new QualType(SrcElementType), new QualType(DestElementType), new SourceLocation(Loc));
    ComplexVal.second = CGF.EmitScalarConversion(Val.getComplexVal().second, new QualType(SrcElementType), new QualType(DestElementType), new SourceLocation(Loc));
  }
  return ComplexVal;
}

//<editor-fold defaultstate="collapsed" desc="emitSimpleAtomicStore">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2819,
 FQN="emitSimpleAtomicStore", NM="_ZL21emitSimpleAtomicStoreRN5clang7CodeGen15CodeGenFunctionEbNS0_6LValueENS0_6RValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL21emitSimpleAtomicStoreRN5clang7CodeGen15CodeGenFunctionEbNS0_6LValueENS0_6RValueE")
//</editor-fold>
public static void emitSimpleAtomicStore(final CodeGenFunction /*&*/ CGF, boolean IsSeqCst, 
                     LValue LVal, RValue RVal) {
  if (LVal.isGlobalReg()) {
    CGF.EmitStoreThroughGlobalRegLValue(new RValue(RVal), new LValue(LVal));
  } else {
    CGF.EmitAtomicStore(new RValue(RVal), new LValue(LVal), 
        IsSeqCst ? AtomicOrdering.SequentiallyConsistent : AtomicOrdering.Monotonic, 
        LVal.isVolatile(), /*IsInit=*/ false);
  }
}

//<editor-fold defaultstate="collapsed" desc="EmitOMPAtomicReadExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2849,
 FQN="EmitOMPAtomicReadExpr", NM="_ZL21EmitOMPAtomicReadExprRN5clang7CodeGen15CodeGenFunctionEbPKNS_4ExprES5_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL21EmitOMPAtomicReadExprRN5clang7CodeGen15CodeGenFunctionEbPKNS_4ExprES5_NS_14SourceLocationE")
//</editor-fold>
public static void EmitOMPAtomicReadExpr(final CodeGenFunction /*&*/ CGF, boolean IsSeqCst, 
                     /*const*/ Expr /*P*/ X, /*const*/ Expr /*P*/ V, 
                     SourceLocation Loc) {
  // v = x;
  assert (V.isLValue()) : "V of 'omp atomic read' is not lvalue";
  assert (X.isLValue()) : "X of 'omp atomic read' is not lvalue";
  LValue XLValue = CGF.EmitLValue(X);
  LValue VLValue = CGF.EmitLValue(V);
  RValue Res = XLValue.isGlobalReg() ? CGF.EmitLoadOfLValue(new LValue(XLValue), new SourceLocation(Loc)) : CGF.EmitAtomicLoad(new LValue(XLValue), new SourceLocation(Loc), 
      IsSeqCst ? AtomicOrdering.SequentiallyConsistent : AtomicOrdering.Monotonic, 
      XLValue.isVolatile());
  // OpenMP, 2.12.6, atomic Construct
  // Any atomic construct with a seq_cst clause forces the atomically
  // performed operation to include an implicit flush operation without a
  // list.
  if (IsSeqCst) {
    CGF.CGM.getOpenMPRuntime().emitFlush(CGF, new ArrayRef</*const*/ Expr /*P*/ >(llvm.None, true), new SourceLocation(Loc));
  }
  CGF.emitOMPSimpleStore(new LValue(VLValue), new RValue(Res), X.getType().getNonReferenceType(), new SourceLocation(Loc));
}

//<editor-fold defaultstate="collapsed" desc="EmitOMPAtomicWriteExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2873,
 FQN="EmitOMPAtomicWriteExpr", NM="_ZL22EmitOMPAtomicWriteExprRN5clang7CodeGen15CodeGenFunctionEbPKNS_4ExprES5_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL22EmitOMPAtomicWriteExprRN5clang7CodeGen15CodeGenFunctionEbPKNS_4ExprES5_NS_14SourceLocationE")
//</editor-fold>
public static void EmitOMPAtomicWriteExpr(final CodeGenFunction /*&*/ CGF, boolean IsSeqCst, 
                      /*const*/ Expr /*P*/ X, /*const*/ Expr /*P*/ E, 
                      SourceLocation Loc) {
  // x = expr;
  assert (X.isLValue()) : "X of 'omp atomic write' is not lvalue";
  emitSimpleAtomicStore(CGF, IsSeqCst, CGF.EmitLValue(X), CGF.EmitAnyExpr(E));
  // OpenMP, 2.12.6, atomic Construct
  // Any atomic construct with a seq_cst clause forces the atomically
  // performed operation to include an implicit flush operation without a
  // list.
  if (IsSeqCst) {
    CGF.CGM.getOpenMPRuntime().emitFlush(CGF, new ArrayRef</*const*/ Expr /*P*/ >(llvm.None, true), new SourceLocation(Loc));
  }
}

//<editor-fold defaultstate="collapsed" desc="emitOMPAtomicRMW">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2887,
 FQN="emitOMPAtomicRMW", NM="_ZL16emitOMPAtomicRMWRN5clang7CodeGen15CodeGenFunctionENS0_6LValueENS0_6RValueENS_18BinaryOperatorKindEN4llvm14AtomicOrderingEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL16emitOMPAtomicRMWRN5clang7CodeGen15CodeGenFunctionENS0_6LValueENS0_6RValueENS_18BinaryOperatorKindEN4llvm14AtomicOrderingEb")
//</editor-fold>
public static std.pairBoolType<RValue> emitOMPAtomicRMW(final CodeGenFunction /*&*/ CGF, LValue X, 
                RValue Update, 
                BinaryOperatorKind BO, 
                AtomicOrdering AO, 
                boolean IsXLHSInRHSPart) {
  final ASTContext /*&*/ Context = CGF.CGM.getContext();
  // Allow atomicrmw only if 'x' and 'update' are integer values, lvalue for 'x'
  // expression is simple and atomic is allowed for the given type for the
  // target platform.
  if (BO == BinaryOperatorKind.BO_Comma || !Update.isScalar()
     || !Update.getScalarVal().getType().isIntegerTy()
     || !X.isSimple() || (!isa_ConstantInt(Update.getScalarVal())
     && (Update.getScalarVal().getType()
     != X.getAddress().getElementType()))
     || !X.getAddress().getElementType().isIntegerTy()
     || !Context.getTargetInfo().hasBuiltinAtomic(Context.getTypeSize(X.getType()), Context.toBits(X.getAlignment()))) {
    return std.make_pair_bool_T(false, $Move(RValue.get((Value /*P*/ )null)));
  }
  
  AtomicRMWInst.BinOp RMWOp = null;
  switch (BO) {
   case BO_Add:
    RMWOp = AtomicRMWInst.BinOp.Add;
    break;
   case BO_Sub:
    if (!IsXLHSInRHSPart) {
      return std.make_pair_bool_T(false, $Move(RValue.get((Value /*P*/ )null)));
    }
    RMWOp = AtomicRMWInst.BinOp.Sub;
    break;
   case BO_And:
    RMWOp = AtomicRMWInst.BinOp.And;
    break;
   case BO_Or:
    RMWOp = AtomicRMWInst.BinOp.Or;
    break;
   case BO_Xor:
    RMWOp = AtomicRMWInst.BinOp.Xor;
    break;
   case BO_LT:
    RMWOp = X.getType().$arrow().hasSignedIntegerRepresentation() ? (IsXLHSInRHSPart ? AtomicRMWInst.BinOp.Min : AtomicRMWInst.BinOp.Max) : (IsXLHSInRHSPart ? AtomicRMWInst.BinOp.UMin : AtomicRMWInst.BinOp.UMax);
    break;
   case BO_GT:
    RMWOp = X.getType().$arrow().hasSignedIntegerRepresentation() ? (IsXLHSInRHSPart ? AtomicRMWInst.BinOp.Max : AtomicRMWInst.BinOp.Min) : (IsXLHSInRHSPart ? AtomicRMWInst.BinOp.UMax : AtomicRMWInst.BinOp.UMin);
    break;
   case BO_Assign:
    RMWOp = AtomicRMWInst.BinOp.Xchg;
    break;
   case BO_Mul:
   case BO_Div:
   case BO_Rem:
   case BO_Shl:
   case BO_Shr:
   case BO_LAnd:
   case BO_LOr:
    return std.make_pair_bool_T(false, $Move(RValue.get((Value /*P*/ )null)));
   case BO_PtrMemD:
   case BO_PtrMemI:
   case BO_LE:
   case BO_GE:
   case BO_EQ:
   case BO_NE:
   case BO_AddAssign:
   case BO_SubAssign:
   case BO_AndAssign:
   case BO_OrAssign:
   case BO_XorAssign:
   case BO_MulAssign:
   case BO_DivAssign:
   case BO_RemAssign:
   case BO_ShlAssign:
   case BO_ShrAssign:
   case BO_Comma:
    throw new llvm_unreachable("Unsupported atomic update operation");
  }
  Value /*P*/ UpdateVal = Update.getScalarVal();
  {
    ConstantInt /*P*/ IC = dyn_cast_ConstantInt(UpdateVal);
    if ((IC != null)) {
      UpdateVal = CGF.Builder.CreateIntCast(IC, X.getAddress().getElementType(), 
          X.getType().$arrow().hasSignedIntegerRepresentation());
    }
  }
  AtomicRMWInst /*P*/ Res = CGF.Builder.CreateAtomicRMW(RMWOp, X.getPointer(), UpdateVal, AO);
  return std.make_pair_bool_T(true, $Move(RValue.get(Res)));
}

//<editor-fold defaultstate="collapsed" desc="EmitOMPAtomicUpdateExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3003,
 FQN="EmitOMPAtomicUpdateExpr", NM="_ZL23EmitOMPAtomicUpdateExprRN5clang7CodeGen15CodeGenFunctionEbPKNS_4ExprES5_S5_bNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL23EmitOMPAtomicUpdateExprRN5clang7CodeGen15CodeGenFunctionEbPKNS_4ExprES5_S5_bNS_14SourceLocationE")
//</editor-fold>
public static void EmitOMPAtomicUpdateExpr(final CodeGenFunction /*&*/ CGF, boolean IsSeqCst, 
                       /*const*/ Expr /*P*/ X, /*const*/ Expr /*P*/ E, 
                       /*const*/ Expr /*P*/ UE, boolean IsXLHSInRHSPart, 
                       SourceLocation Loc) {
  assert (AstRTTI.isa_BinaryOperator(UE.IgnoreImpCasts$Const())) : "Update expr in 'atomic update' must be a binary operator.";
  /*const*/ org.clang.ast.BinaryOperator /*P*/ BOUE = AstRTTI.cast_BinaryOperator(UE.IgnoreImpCasts$Const());
  // Update expressions are allowed to have the following forms:
  // x binop= expr; -> xrval + expr;
  // x++, ++x -> xrval + 1;
  // x--, --x -> xrval - 1;
  // x = x binop expr; -> xrval binop expr
  // x = expr Op x; - > expr binop xrval;
  assert (X.isLValue()) : "X of 'omp atomic update' is not lvalue";
  LValue XLValue = CGF.EmitLValue(X);
  RValue ExprRValue = CGF.EmitAnyExpr(E);
  AtomicOrdering AO = IsSeqCst ? AtomicOrdering.SequentiallyConsistent : AtomicOrdering.Monotonic;
  OpaqueValueExpr /*P*/ LHS = cast_OpaqueValueExpr(BOUE.getLHS().IgnoreImpCasts());
  OpaqueValueExpr /*P*/ RHS = cast_OpaqueValueExpr(BOUE.getRHS().IgnoreImpCasts());
  OpaqueValueExpr /*P*/ XRValExpr = IsXLHSInRHSPart ? LHS : RHS;
  OpaqueValueExpr /*P*/ ERValExpr = IsXLHSInRHSPart ? RHS : LHS;
  Type2Type<RValue> Gen = /*[&CGF, =L$UE(UE), =L$ExprRValue(ExprRValue), =L$XRValExpr(XRValExpr), =L$ERValExpr(ERValExpr)]*/ (RValue XRValue) -> {
        CodeGenFunction.OpaqueValueMapping MapExpr = null;
        CodeGenFunction.OpaqueValueMapping MapX = null;
        try {
          MapExpr/*J*/= new CodeGenFunction.OpaqueValueMapping(CGF, ERValExpr, new RValue(ExprRValue));
          MapX/*J*/= new CodeGenFunction.OpaqueValueMapping(CGF, XRValExpr, new RValue(XRValue));
          return CGF.EmitAnyExpr(UE);
        } finally {
          if (MapX != null) { MapX.$destroy(); }
          if (MapExpr != null) { MapExpr.$destroy(); }
        }
      };
  /*J:(void)*/CGF.EmitOMPAtomicSimpleUpdateExpr(new LValue(XLValue), new RValue(ExprRValue), BOUE.getOpcode(), IsXLHSInRHSPart, AO, new SourceLocation(Loc), /*FuncArg*/Gen);
  // OpenMP, 2.12.6, atomic Construct
  // Any atomic construct with a seq_cst clause forces the atomically
  // performed operation to include an implicit flush operation without a
  // list.
  if (IsSeqCst) {
    CGF.CGM.getOpenMPRuntime().emitFlush(CGF, new ArrayRef</*const*/ Expr /*P*/ >(llvm.None, true), new SourceLocation(Loc));
  }
}

//<editor-fold defaultstate="collapsed" desc="convertToType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3041,
 FQN="convertToType", NM="_ZL13convertToTypeRN5clang7CodeGen15CodeGenFunctionENS0_6RValueENS_8QualTypeES4_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL13convertToTypeRN5clang7CodeGen15CodeGenFunctionENS0_6RValueENS_8QualTypeES4_NS_14SourceLocationE")
//</editor-fold>
public static RValue convertToType(final CodeGenFunction /*&*/ CGF, RValue Value, 
             QualType SourceType, QualType ResType, 
             SourceLocation Loc) {
  switch (CGF.getEvaluationKind(new QualType(ResType))) {
   case TEK_Scalar:
    return RValue.get(convertToScalarValue(CGF, new RValue(Value), new QualType(SourceType), new QualType(ResType), new SourceLocation(Loc)));
   case TEK_Complex:
    {
      std.pairPtrPtr<Value /*P*/ , Value /*P*/ > Res = convertToComplexValue(CGF, new RValue(Value), new QualType(SourceType), new QualType(ResType), new SourceLocation(Loc));
      return RValue.getComplex(Res.first, Res.second);
    }
   case TEK_Aggregate:
    break;
  }
  throw new llvm_unreachable("Must be a scalar or complex.");
}

//<editor-fold defaultstate="collapsed" desc="EmitOMPAtomicCaptureExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3058,
 FQN="EmitOMPAtomicCaptureExpr", NM="_ZL24EmitOMPAtomicCaptureExprRN5clang7CodeGen15CodeGenFunctionEbbPKNS_4ExprES5_S5_S5_bNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL24EmitOMPAtomicCaptureExprRN5clang7CodeGen15CodeGenFunctionEbbPKNS_4ExprES5_S5_S5_bNS_14SourceLocationE")
//</editor-fold>
public static void EmitOMPAtomicCaptureExpr(final CodeGenFunction /*&*/ CGF, boolean IsSeqCst, 
                        boolean IsPostfixUpdate, /*const*/ Expr /*P*/ V, 
                        /*const*/ Expr /*P*/ X, /*const*/ Expr /*P*/ E, 
                        /*const*/ Expr /*P*/ UE, boolean IsXLHSInRHSPart, 
                        SourceLocation Loc) {
  assert (X.isLValue()) : "X of 'omp atomic capture' is not lvalue";
  assert (V.isLValue()) : "V of 'omp atomic capture' is not lvalue";
  RValue NewVVal/*J*/= new RValue();
  LValue VLValue = CGF.EmitLValue(V);
  LValue XLValue = CGF.EmitLValue(X);
  RValue ExprRValue = CGF.EmitAnyExpr(E);
  AtomicOrdering AO = IsSeqCst ? AtomicOrdering.SequentiallyConsistent : AtomicOrdering.Monotonic;
  QualType NewVValType/*J*/= new QualType();
  if ((UE != null)) {
    // 'x' is updated with some additional value.
    assert (AstRTTI.isa_BinaryOperator(UE.IgnoreImpCasts$Const())) : "Update expr in 'atomic capture' must be a binary operator.";
    /*const*/ org.clang.ast.BinaryOperator /*P*/ BOUE = AstRTTI.cast_BinaryOperator(UE.IgnoreImpCasts$Const());
    // Update expressions are allowed to have the following forms:
    // x binop= expr; -> xrval + expr;
    // x++, ++x -> xrval + 1;
    // x--, --x -> xrval - 1;
    // x = x binop expr; -> xrval binop expr
    // x = expr Op x; - > expr binop xrval;
    OpaqueValueExpr /*P*/ LHS = cast_OpaqueValueExpr(BOUE.getLHS().IgnoreImpCasts());
    OpaqueValueExpr /*P*/ RHS = cast_OpaqueValueExpr(BOUE.getRHS().IgnoreImpCasts());
    OpaqueValueExpr /*P*/ XRValExpr = IsXLHSInRHSPart ? LHS : RHS;
    NewVValType.$assignMove(XRValExpr.getType());
    OpaqueValueExpr /*P*/ ERValExpr = IsXLHSInRHSPart ? RHS : LHS;
    final Type2Type<RValue> Gen = /*[&CGF, &NewVVal, =L$UE(UE), =L$ExprRValue(ExprRValue), =L$XRValExpr(XRValExpr), =L$ERValExpr(ERValExpr), =L$IsSeqCst(IsSeqCst), =L$IsPostfixUpdate(IsPostfixUpdate)]*/ (RValue XRValue) -> {
          CodeGenFunction.OpaqueValueMapping MapExpr = null;
          CodeGenFunction.OpaqueValueMapping MapX = null;
          try {
            MapExpr/*J*/= new CodeGenFunction.OpaqueValueMapping(CGF, ERValExpr, new RValue(ExprRValue));
            MapX/*J*/= new CodeGenFunction.OpaqueValueMapping(CGF, XRValExpr, new RValue(XRValue));
            RValue Res = CGF.EmitAnyExpr(UE);
            NewVVal.$assign(IsPostfixUpdate ? XRValue : Res);
            return Res;
          } finally {
            if (MapX != null) { MapX.$destroy(); }
            if (MapExpr != null) { MapExpr.$destroy(); }
          }
        };
    std.pairBoolType<RValue> Res = CGF.EmitOMPAtomicSimpleUpdateExpr(new LValue(XLValue), new RValue(ExprRValue), BOUE.getOpcode(), IsXLHSInRHSPart, AO, new SourceLocation(Loc), /*FuncArg*/Gen);
    if (Res.first) {
      // 'atomicrmw' instruction was generated.
      if (IsPostfixUpdate) {
        // Use old value from 'atomicrmw'.
        NewVVal.$assign(Res.second);
      } else {
        CodeGenFunction.OpaqueValueMapping MapExpr = null;
        CodeGenFunction.OpaqueValueMapping MapX = null;
        try {
          // 'atomicrmw' does not provide new value, so evaluate it using old
          // value of 'x'.
          MapExpr/*J*/= new CodeGenFunction.OpaqueValueMapping(CGF, ERValExpr, new RValue(ExprRValue));
          MapX/*J*/= new CodeGenFunction.OpaqueValueMapping(CGF, XRValExpr, new RValue(Res.second));
          NewVVal.$assignMove(CGF.EmitAnyExpr(UE));
        } finally {
          if (MapX != null) { MapX.$destroy(); }
          if (MapExpr != null) { MapExpr.$destroy(); }
        }
      }
    }
  } else {
    // 'x' is simply rewritten with some 'expr'.
    NewVValType.$assignMove(X.getType().getNonReferenceType());
    ExprRValue.$assignMove(convertToType(CGF, new RValue(ExprRValue), E.getType(), 
            X.getType().getNonReferenceType(), new SourceLocation(Loc)));
    final Type2Type<RValue> Gen = /*[&CGF, &NewVVal, =L$ExprRValue(ExprRValue)]*/ (RValue XRValue) -> {
          NewVVal.$assign(XRValue);
          return new RValue(ExprRValue);
        };
    // Try to perform atomicrmw xchg, otherwise simple exchange.
    std.pairBoolType<RValue> Res = CGF.EmitOMPAtomicSimpleUpdateExpr(new LValue(XLValue), new RValue(ExprRValue), /*BO=*/ BinaryOperatorKind.BO_Assign, /*IsXLHSInRHSPart=*/ false, AO, 
        new SourceLocation(Loc), /*FuncArg*/Gen);
    if (Res.first) {
      // 'atomicrmw' instruction was generated.
      NewVVal.$assign(IsPostfixUpdate ? Res.second : ExprRValue);
    }
  }
  // Emit post-update store to 'v' of old/new 'x' value.
  CGF.emitOMPSimpleStore(new LValue(VLValue), new RValue(NewVVal), new QualType(NewVValType), new SourceLocation(Loc));
  // OpenMP, 2.12.6, atomic Construct
  // Any atomic construct with a seq_cst clause forces the atomically
  // performed operation to include an implicit flush operation without a
  // list.
  if (IsSeqCst) {
    CGF.CGM.getOpenMPRuntime().emitFlush(CGF, new ArrayRef</*const*/ Expr /*P*/ >(llvm.None, true), new SourceLocation(Loc));
  }
}

//<editor-fold defaultstate="collapsed" desc="EmitOMPAtomicExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3139,
 FQN="EmitOMPAtomicExpr", NM="_ZL17EmitOMPAtomicExprRN5clang7CodeGen15CodeGenFunctionENS_16OpenMPClauseKindEbbPKNS_4ExprES6_S6_S6_bNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL17EmitOMPAtomicExprRN5clang7CodeGen15CodeGenFunctionENS_16OpenMPClauseKindEbbPKNS_4ExprES6_S6_S6_bNS_14SourceLocationE")
//</editor-fold>
public static void EmitOMPAtomicExpr(final CodeGenFunction /*&*/ CGF, OpenMPClauseKind Kind, 
                 boolean IsSeqCst, boolean IsPostfixUpdate, 
                 /*const*/ Expr /*P*/ X, /*const*/ Expr /*P*/ V, /*const*/ Expr /*P*/ E, 
                 /*const*/ Expr /*P*/ UE, boolean IsXLHSInRHSPart, 
                 SourceLocation Loc) {
  switch (Kind) {
   case OMPC_read:
    EmitOMPAtomicReadExpr(CGF, IsSeqCst, X, V, new SourceLocation(Loc));
    break;
   case OMPC_write:
    EmitOMPAtomicWriteExpr(CGF, IsSeqCst, X, E, new SourceLocation(Loc));
    break;
   case OMPC_unknown:
   case OMPC_update:
    EmitOMPAtomicUpdateExpr(CGF, IsSeqCst, X, E, UE, IsXLHSInRHSPart, new SourceLocation(Loc));
    break;
   case OMPC_capture:
    EmitOMPAtomicCaptureExpr(CGF, IsSeqCst, IsPostfixUpdate, V, X, E, UE, 
        IsXLHSInRHSPart, new SourceLocation(Loc));
    break;
   case OMPC_if:
   case OMPC_final:
   case OMPC_num_threads:
   case OMPC_private:
   case OMPC_firstprivate:
   case OMPC_lastprivate:
   case OMPC_reduction:
   case OMPC_safelen:
   case OMPC_simdlen:
   case OMPC_collapse:
   case OMPC_default:
   case OMPC_seq_cst:
   case OMPC_shared:
   case OMPC_linear:
   case OMPC_aligned:
   case OMPC_copyin:
   case OMPC_copyprivate:
   case OMPC_flush:
   case OMPC_proc_bind:
   case OMPC_schedule:
   case OMPC_ordered:
   case OMPC_nowait:
   case OMPC_untied:
   case OMPC_threadprivate:
   case OMPC_depend:
   case OMPC_mergeable:
   case OMPC_device:
   case OMPC_threads:
   case OMPC_simd:
   case OMPC_map:
   case OMPC_num_teams:
   case OMPC_thread_limit:
   case OMPC_priority:
   case OMPC_grainsize:
   case OMPC_nogroup:
   case OMPC_num_tasks:
   case OMPC_hint:
   case OMPC_dist_schedule:
   case OMPC_defaultmap:
   case OMPC_uniform:
   case OMPC_to:
   case OMPC_from:
   case OMPC_use_device_ptr:
   case OMPC_is_device_ptr:
    throw new llvm_unreachable("Clause is not allowed in 'omp atomic'.");
  }
}

//<editor-fold defaultstate="collapsed" desc="emitCommonOMPTeamsDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3317,
 FQN="emitCommonOMPTeamsDirective", NM="_ZL27emitCommonOMPTeamsDirectiveRN5clang7CodeGen15CodeGenFunctionERKNS_22OMPExecutableDirectiveENS_19OpenMPDirectiveKindERKNS0_15RegionCodeGenTyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL27emitCommonOMPTeamsDirectiveRN5clang7CodeGen15CodeGenFunctionERKNS_22OMPExecutableDirectiveENS_19OpenMPDirectiveKindERKNS0_15RegionCodeGenTyE")
//</editor-fold>
public static void emitCommonOMPTeamsDirective(final CodeGenFunction /*&*/ CGF, 
                           final /*const*/ OMPExecutableDirective /*&*/ S, 
                           OpenMPDirectiveKind InnermostKind, 
                           final /*const*/ RegionCodeGenTy /*&*/ CodeGen) {
  OMPLexicalScope Scope = null;
  try {
    CapturedStmt /*P*/ CS = cast_CapturedStmt(S.getAssociatedStmt());
    Value /*P*/ OutlinedFn = CGF.CGM.getOpenMPRuntime().
        emitParallelOrTeamsOutlinedFunction(S, 
        CS.getCapturedDecl().param_begin().$star(), InnermostKind, CodeGen);
    
    final /*const*/ OMPTeamsDirective /*&*/ TD = $Deref(dyn_cast_OMPTeamsDirective($AddrOf(S)));
    /*const*/ OMPNumTeamsClause /*P*/ NT = TD.<OMPNumTeamsClause>getSingleClause(OMPNumTeamsClause.class);
    /*const*/ OMPThreadLimitClause /*P*/ TL = TD.<OMPThreadLimitClause>getSingleClause(OMPThreadLimitClause.class);
    if ((NT != null) || (TL != null)) {
      Expr /*P*/ NumTeams = ((NT) != null) ? NT.getNumTeams$Const() : null;
      Expr /*P*/ ThreadLimit = ((TL) != null) ? TL.getThreadLimit$Const() : null;
      
      CGF.CGM.getOpenMPRuntime().emitNumTeamsClause(CGF, NumTeams, ThreadLimit, 
          S.getLocStart());
    }
    
    Scope/*J*/= new OMPLexicalScope(CGF, S);
    SmallVector<Value /*P*/ > CapturedVars/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
    CGF.GenerateOpenMPCapturedVars($Deref(CS), CapturedVars);
    CGF.CGM.getOpenMPRuntime().emitTeamsCall(CGF, S, S.getLocStart(), OutlinedFn, 
        new ArrayRef<Value /*P*/ >(CapturedVars, true));
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}


/// Emit a helper variable and return corresponding lvalue.
//<editor-fold defaultstate="collapsed" desc="mapParam">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3467,
 FQN="mapParam", NM="_ZL8mapParamRN5clang7CodeGen15CodeGenFunctionEPKNS_11DeclRefExprEPKNS_17ImplicitParamDeclERNS1_15OMPPrivateScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZL8mapParamRN5clang7CodeGen15CodeGenFunctionEPKNS_11DeclRefExprEPKNS_17ImplicitParamDeclERNS1_15OMPPrivateScopeE")
//</editor-fold>
public static void mapParam(final CodeGenFunction /*&*/ CGF, /*const*/ DeclRefExpr /*P*/ Helper, 
        /*const*/ ImplicitParamDecl /*P*/ PVD, 
        final CodeGenFunction.OMPPrivateScope /*&*/ Privates) {
  /*const*/ VarDecl /*P*/ VDecl = cast_VarDecl(Helper.getDecl$Const());
  Privates.addPrivate(VDecl, /*FuncArg*//*[&CGF, =L$PVD(PVD)]*/ () -> {
            return CGF.GetAddrOfLocalVar(PVD);
          });
}

} // END OF class CGStmtOpenMPStatics
