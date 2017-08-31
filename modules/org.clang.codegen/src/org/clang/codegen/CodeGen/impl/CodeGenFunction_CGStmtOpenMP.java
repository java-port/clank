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
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.java.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.java.ClangCodeGenFunctionPointers.*;
import org.clang.codegen.java.ClangCodeGenJavaDifferentiators.*;
import org.clang.ast.DeclContext.specific_decl_iterator;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.ast.java.AstJavaDifferentiators.JD$CXXConstructorDecl$C$P_CXXCtorType;
import org.clang.ast.java.AstJavaDifferentiators.JD$CXXDestructorDecl$C$P_CXXDtorType;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGStmtOpenMP">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGStmtOpenMP",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGStmt ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11EmitOMPCopyENS_8QualTypeENS0_7AddressES3_PKNS_7VarDeclES6_PKNS_4ExprE;_ZN5clang7CodeGen15CodeGenFunction11getTypeSizeENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction12EmitSectionsERKNS_22OMPExecutableDirectiveE;_ZN5clang7CodeGen15CodeGenFunction15EmitOMPLoopBodyERKNS_16OMPLoopDirectiveENS1_8JumpDestE;_ZN5clang7CodeGen15CodeGenFunction15EmitOMPSimdInitERKNS_16OMPLoopDirectiveEb;_ZN5clang7CodeGen15CodeGenFunction16EmitOMPInnerLoopERKNS_4StmtEbPKNS_4ExprES7_RKN4llvm12function_refIFvRS1_EEESE_;_ZN5clang7CodeGen15CodeGenFunction16EmitOMPOuterLoopEbbRKNS_16OMPLoopDirectiveERNS1_15OMPPrivateScopeEbNS0_7AddressES7_S7_S7_PN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction16EmitOMPSimdFinalERKNS_16OMPLoopDirectiveERKN4llvm12function_refIFPNS5_5ValueERS1_EEE;_ZN5clang7CodeGen15CodeGenFunction18emitOMPSimpleStoreENS0_6LValueENS0_6RValueENS_8QualTypeENS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction19EmitOMPCopyinClauseERKNS_22OMPExecutableDirectiveE;_ZN5clang7CodeGen15CodeGenFunction19EmitOMPForDirectiveERKNS_15OMPForDirectiveE;_ZN5clang7CodeGen15CodeGenFunction19EmitOMPForOuterLoopERKNS_16OpenMPScheduleTyEbRKNS_16OMPLoopDirectiveERNS1_15OMPPrivateScopeEbNS0_7AddressESA_SA_SA_PN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction19EmitOMPLinearClauseERKNS_16OMPLoopDirectiveERNS1_15OMPPrivateScopeE;_ZN5clang7CodeGen15CodeGenFunction20EmitOMPPrivateClauseERKNS_22OMPExecutableDirectiveERNS1_15OMPPrivateScopeE;_ZN5clang7CodeGen15CodeGenFunction20EmitOMPSimdDirectiveERKNS_16OMPSimdDirectiveE;_ZN5clang7CodeGen15CodeGenFunction20EmitOMPTaskDirectiveERKNS_16OMPTaskDirectiveE;_ZN5clang7CodeGen15CodeGenFunction21EmitOMPDistributeLoopERKNS_22OMPDistributeDirectiveE;_ZN5clang7CodeGen15CodeGenFunction21EmitOMPFlushDirectiveERKNS_17OMPFlushDirectiveE;_ZN5clang7CodeGen15CodeGenFunction21EmitOMPTeamsDirectiveERKNS_17OMPTeamsDirectiveE;_ZN5clang7CodeGen15CodeGenFunction22EmitOMPAggregateAssignENS0_7AddressES2_NS_8QualTypeERKN4llvm12function_refIFvS2_S2_EEE;_ZN5clang7CodeGen15CodeGenFunction22EmitOMPAtomicDirectiveERKNS_18OMPAtomicDirectiveE;_ZN5clang7CodeGen15CodeGenFunction22EmitOMPCancelDirectiveERKNS_18OMPCancelDirectiveE;_ZN5clang7CodeGen15CodeGenFunction22EmitOMPMasterDirectiveERKNS_18OMPMasterDirectiveE;_ZN5clang7CodeGen15CodeGenFunction22EmitOMPSingleDirectiveERKNS_18OMPSingleDirectiveE;_ZN5clang7CodeGen15CodeGenFunction22EmitOMPTargetDirectiveERKNS_18OMPTargetDirectiveE;_ZN5clang7CodeGen15CodeGenFunction22EmitOMPWorksharingLoopERKNS_16OMPLoopDirectiveE;_ZN5clang7CodeGen15CodeGenFunction23EmitOMPBarrierDirectiveERKNS_19OMPBarrierDirectiveE;_ZN5clang7CodeGen15CodeGenFunction23EmitOMPForSimdDirectiveERKNS_19OMPForSimdDirectiveE;_ZN5clang7CodeGen15CodeGenFunction23EmitOMPLinearClauseInitERKNS_16OMPLoopDirectiveE;_ZN5clang7CodeGen15CodeGenFunction23EmitOMPOrderedDirectiveERKNS_19OMPOrderedDirectiveE;_ZN5clang7CodeGen15CodeGenFunction23EmitOMPSectionDirectiveERKNS_19OMPSectionDirectiveE;_ZN5clang7CodeGen15CodeGenFunction23getOMPCancelDestinationENS_19OpenMPDirectiveKindE;_ZN5clang7CodeGen15CodeGenFunction24EmitOMPCriticalDirectiveERKNS_20OMPCriticalDirectiveE;_ZN5clang7CodeGen15CodeGenFunction24EmitOMPLinearClauseFinalERKNS_16OMPLoopDirectiveERKN4llvm12function_refIFPNS5_5ValueERS1_EEE;_ZN5clang7CodeGen15CodeGenFunction24EmitOMPParallelDirectiveERKNS_20OMPParallelDirectiveE;_ZN5clang7CodeGen15CodeGenFunction24EmitOMPSectionsDirectiveERKNS_20OMPSectionsDirectiveE;_ZN5clang7CodeGen15CodeGenFunction24EmitOMPTaskLoopDirectiveERKNS_20OMPTaskLoopDirectiveE;_ZN5clang7CodeGen15CodeGenFunction24EmitOMPTaskwaitDirectiveERKNS_20OMPTaskwaitDirectiveE;_ZN5clang7CodeGen15CodeGenFunction25EmitOMPFirstprivateClauseERKNS_22OMPExecutableDirectiveERNS1_15OMPPrivateScopeE;_ZN5clang7CodeGen15CodeGenFunction25EmitOMPTaskBasedDirectiveERKNS_22OMPExecutableDirectiveERKNS0_15RegionCodeGenTyERKN4llvm12function_refIFvRS1_PNS8_5ValueERKNS0_13OMPTaskDataTyEEEERSD_;_ZN5clang7CodeGen15CodeGenFunction25EmitOMPTaskgroupDirectiveERKNS_21OMPTaskgroupDirectiveE;_ZN5clang7CodeGen15CodeGenFunction25EmitOMPTaskyieldDirectiveERKNS_21OMPTaskyieldDirectiveE;_ZN5clang7CodeGen15CodeGenFunction26EmitOMPDistributeDirectiveERKNS_22OMPDistributeDirectiveE;_ZN5clang7CodeGen15CodeGenFunction26EmitOMPDistributeOuterLoopENS_28OpenMPDistScheduleClauseKindERKNS_22OMPDistributeDirectiveERNS1_15OMPPrivateScopeENS0_7AddressES8_S8_S8_PN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction26EmitOMPPrivateLoopCountersERKNS_16OMPLoopDirectiveERNS1_15OMPPrivateScopeE;_ZN5clang7CodeGen15CodeGenFunction26EmitOMPReductionClauseInitERKNS_22OMPExecutableDirectiveERNS1_15OMPPrivateScopeE;_ZN5clang7CodeGen15CodeGenFunction26EmitOMPTargetDataDirectiveERKNS_22OMPTargetDataDirectiveE;_ZN5clang7CodeGen15CodeGenFunction26GenerateOpenMPCapturedVarsERKNS_12CapturedStmtERN4llvm15SmallVectorImplIPNS5_5ValueEEE;_ZN5clang7CodeGen15CodeGenFunction27EmitOMPParallelForDirectiveERKNS_23OMPParallelForDirectiveE;_ZN5clang7CodeGen15CodeGenFunction27EmitOMPReductionClauseFinalERKNS_22OMPExecutableDirectiveE;_ZN5clang7CodeGen15CodeGenFunction28EmitOMPLastprivateClauseInitERKNS_22OMPExecutableDirectiveERNS1_15OMPPrivateScopeE;_ZN5clang7CodeGen15CodeGenFunction28EmitOMPTargetUpdateDirectiveERKNS_24OMPTargetUpdateDirectiveE;_ZN5clang7CodeGen15CodeGenFunction28EmitOMPTaskLoopSimdDirectiveERKNS_24OMPTaskLoopSimdDirectiveE;_ZN5clang7CodeGen15CodeGenFunction29EmitOMPAtomicSimpleUpdateExprENS0_6LValueENS0_6RValueENS_18BinaryOperatorKindEbN4llvm14AtomicOrderingENS_14SourceLocationERKNS5_12function_refIFS3_S3_EEE;_ZN5clang7CodeGen15CodeGenFunction29EmitOMPLastprivateClauseFinalERKNS_22OMPExecutableDirectiveEbPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction29EmitOMPTaskLoopBasedDirectiveERKNS_16OMPLoopDirectiveE;_ZN5clang7CodeGen15CodeGenFunction30EmitOMPDistributeSimdDirectiveERKNS_26OMPDistributeSimdDirectiveE;_ZN5clang7CodeGen15CodeGenFunction30EmitOMPTargetExitDataDirectiveERKNS_26OMPTargetExitDataDirectiveE;_ZN5clang7CodeGen15CodeGenFunction30EmitOMPTargetParallelDirectiveERKNS_26OMPTargetParallelDirectiveE;_ZN5clang7CodeGen15CodeGenFunction31EmitOMPParallelForSimdDirectiveERKNS_27OMPParallelForSimdDirectiveE;_ZN5clang7CodeGen15CodeGenFunction31EmitOMPTargetEnterDataDirectiveERKNS_27OMPTargetEnterDataDirectiveE;_ZN5clang7CodeGen15CodeGenFunction32EmitOMPParallelSectionsDirectiveERKNS_28OMPParallelSectionsDirectiveE;_ZN5clang7CodeGen15CodeGenFunction33EmitOMPCancellationPointDirectiveERKNS_29OMPCancellationPointDirectiveE;_ZN5clang7CodeGen15CodeGenFunction33EmitOMPTargetParallelForDirectiveERKNS_29OMPTargetParallelForDirectiveE;_ZN5clang7CodeGen15CodeGenFunction34GenerateOpenMPCapturedStmtFunctionERKNS_12CapturedStmtE;_ZN5clang7CodeGen15CodeGenFunction37EmitOMPDistributeParallelForDirectiveERKNS_33OMPDistributeParallelForDirectiveE;_ZN5clang7CodeGen15CodeGenFunction37EmitOMPTargetParallelForSimdDirectiveERKNS_33OMPTargetParallelForSimdDirectiveE;_ZN5clang7CodeGen15CodeGenFunction38EmitOMPTargetDirectiveOutlinedFunctionERNS0_13CodeGenModuleERKNS_18OMPTargetDirectiveEN4llvm9StringRefEb;_ZN5clang7CodeGen15CodeGenFunction41EmitOMPDistributeParallelForSimdDirectiveERKNS_37OMPDistributeParallelForSimdDirectiveE; -static-type=CodeGenFunction_CGStmtOpenMP -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGStmtOpenMP extends CodeGenFunction_CGStmt {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGStmtOpenMP(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}


/// Returns calculated size of the specified type.
// namespace
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getTypeSize">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 105,
 FQN="clang::CodeGen::CodeGenFunction::getTypeSize", NM="_ZN5clang7CodeGen15CodeGenFunction11getTypeSizeENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11getTypeSizeENS_8QualTypeE")
//</editor-fold>
public final Value /*P*/ getTypeSize(QualType Ty) {
  final ASTContext /*&*/ C = $this().getContext();
  Value /*P*/ Size = null;
  CharUnits SizeInChars = C.getTypeSizeInChars(/*NO_COPY*/Ty);
  if (SizeInChars.isZero()) {
    {
      // getTypeSizeInChars() returns 0 for a VLA.
      /*const*/ VariableArrayType /*P*/ VAT;
      while (((/*P*/ VAT = C.getAsVariableArrayType(new QualType(Ty))) != null)) {
        //std.tie(ArraySize, Ty).$assign(tmp);
        pair<Value, QualType> tmp = $this().getVLASize(VAT);
        Value /*P*/ ArraySize = tmp.first;
        Ty = tmp.second;
        Size = (Size != null) ? $this().Builder.CreateNUWMul(Size, ArraySize) : ArraySize;
      }
    }
    SizeInChars.$assignMove(C.getTypeSizeInChars(/*NO_COPY*/Ty));
    if (SizeInChars.isZero()) {
      return ConstantInt.get(Unnamed_field8.SizeTy, /*V=*/ $int2ulong(0));
    }
    Size = $this().Builder.CreateNUWMul(Size, $this().CGM.getSize(new CharUnits(SizeInChars)));
  } else {
    Size = $this().CGM.getSize(new CharUnits(SizeInChars));
  }
  return Size;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateOpenMPCapturedStmtFunction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 197,
 FQN="clang::CodeGen::CodeGenFunction::GenerateOpenMPCapturedStmtFunction", NM="_ZN5clang7CodeGen15CodeGenFunction34GenerateOpenMPCapturedStmtFunctionERKNS_12CapturedStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction34GenerateOpenMPCapturedStmtFunctionERKNS_12CapturedStmtE")
//</editor-fold>
public final Function /*P*/ GenerateOpenMPCapturedStmtFunction(final /*const*/ CapturedStmt /*&*/ S) {
  FunctionArgList Args = null;
  try {
    assert (($this().CapturedStmtInfo != null)) : "CapturedStmtInfo should be set when generating the captured function";
    /*const*/ CapturedDecl /*P*/ CD = S.getCapturedDecl$Const();
    /*const*/ RecordDecl /*P*/ RD = S.getCapturedRecordDecl();
    assert (CD.hasBody()) : "missing CapturedDecl body";
    
    // Build the argument list.
    final ASTContext /*&*/ Ctx = $this().CGM.getContext();
    Args/*J*/= new FunctionArgList();
    Args.append_T(CD.param_begin(), 
        std.next(CD.param_begin(), CD.getContextParamPosition()));
    type$iterator<? extends type$iterator, CapturedStmt.Capture> I = S.captures$Const().begin();
    //type$ptr<CapturedStmt.Capture /*P*/> I = S.captures$Const().begin();
    for (FieldDecl /*P*/ FD : RD.fields()) {
      QualType ArgType = FD.getType();
      IdentifierInfo /*P*/ II = null;
      VarDecl /*P*/ CapVar = null;
      
      // If this is a capture by copy and the type is not a pointer, the outlined
      // function argument type should be uintptr and the value properly casted to
      // uintptr. This is necessary given that the runtime library is only able to
      // deal with pointers. We can pass in the same way the VLA type sizes to the
      // outlined function.
      if ((I.$star().capturesVariableByCopy() && !ArgType.$arrow().isAnyPointerType())
         || I.$star().capturesVariableArrayType()) {
        ArgType.$assignMove(Ctx.getUIntPtrType());
      }
      if (I.$star().capturesVariable() || I.$star().capturesVariableByCopy()) {
        CapVar = I.$star().getCapturedVar();
        II = CapVar.getIdentifier();
      } else if (I.$star().capturesThis()) {
        II = /*AddrOf*/$this().getContext().Idents.get(new StringRef(/*KEEP_STR*/$this));
      } else {
        assert (I.$star().capturesVariableArrayType());
        II = /*AddrOf*/$this().getContext().Idents.get(new StringRef(/*KEEP_STR*/"vla"));
      }
      if (ArgType.$arrow().isVariablyModifiedType()) {
        ArgType.$assignMove($this().getContext().getVariableArrayDecayedType(new QualType(ArgType)));
      }
      Args.push_back(ImplicitParamDecl.Create($this().getContext(), (DeclContext /*P*/ )null, 
              FD.getLocation(), II, new QualType(ArgType)));
      I.$preInc();
    }
    Args.append_T(std.next(CD.param_begin(), CD.getContextParamPosition() + 1), 
        CD.param_end());
    
    // Create the function declaration.
    org.clang.ast.FunctionType.ExtInfo ExtInfo/*J*/= new org.clang.ast.FunctionType.ExtInfo();
    final /*const*/ CGFunctionInfo /*&*/ FuncInfo = $this().CGM.getTypes().arrangeBuiltinFunctionDeclaration(Ctx.VoidTy.$QualType(), Args);
    org.llvm.ir.FunctionType /*P*/ FuncLLVMTy = $this().CGM.getTypes().GetFunctionType(FuncInfo);
    
    Function /*P*/ F = Function.Create(FuncLLVMTy, GlobalValue.LinkageTypes.InternalLinkage, 
        new Twine($this().CapturedStmtInfo.getHelperName()), $AddrOf($this().CGM.getModule()));
    $this().CGM.SetInternalFunctionAttributes(CD, F, FuncInfo);
    if (CD.isNothrow()) {
      F.addFnAttr(Attribute.AttrKind.NoUnwind);
    }
    
    // Generate the function.
    $this().StartFunction(new GlobalDecl(CD), Ctx.VoidTy.$QualType(), F, FuncInfo, Args, CD.getLocation(), 
        CD.getBody().getLocStart());
    /*uint*/int Cnt = CD.getContextParamPosition();
    I = S.captures$Const().begin();
    for (FieldDecl /*P*/ FD : RD.fields()) {
      // If we are capturing a pointer by copy we don't need to do anything, just
      // use the value that we get from the arguments.
      if (I.$star().capturesVariableByCopy() && FD.getType().$arrow().isAnyPointerType()) {
        $this().setAddrOfLocalVar(I.$star().getCapturedVar(), $this().GetAddrOfLocalVar(Args.$at(Cnt)));
        ++Cnt;
        I.$preInc();
        continue;
      }
      
      LValue ArgLVal = $this().MakeAddrLValue($this().GetAddrOfLocalVar(Args.$at(Cnt)), Args.$at(Cnt).getType(), 
          AlignmentSource.Decl);
      if (FD.hasCapturedVLAType()) {
        LValue CastedArgLVal = $this().MakeAddrLValue(CGStmtOpenMPStatics.castValueFromUintptr(/*Deref*/$this(), FD.getType(), 
                Args.$at(Cnt).getName(), new LValue(ArgLVal)), 
            FD.getType(), AlignmentSource.Decl);
        Value /*P*/ ExprArg = $this().EmitLoadOfLValue(new LValue(CastedArgLVal), new SourceLocation()).getScalarVal();
        /*const*/ VariableArrayType /*P*/ VAT = FD.getCapturedVLAType();
        $this().VLASizeMap.$set(VAT.getSizeExpr(), ExprArg);
      } else if (I.$star().capturesVariable()) {
        VarDecl /*P*/ Var = I.$star().getCapturedVar();
        QualType VarTy = Var.getType();
        Address ArgAddr = ArgLVal.getAddress();
        if (!VarTy.$arrow().isReferenceType()) {
          ArgAddr.$assignMove($this().EmitLoadOfReference(new Address(ArgAddr), ArgLVal.getType().$arrow().castAs(ReferenceType.class)));
        }
        $this().setAddrOfLocalVar(Var, new Address(ArgAddr.getPointer(), $this().getContext().getDeclAlign(Var)));
      } else if (I.$star().capturesVariableByCopy()) {
        assert (!FD.getType().$arrow().isAnyPointerType()) : "Not expecting a captured pointer.";
        VarDecl /*P*/ Var = I.$star().getCapturedVar();
        QualType VarTy = Var.getType();
        $this().setAddrOfLocalVar(Var, CGStmtOpenMPStatics.castValueFromUintptr(/*Deref*/$this(), FD.getType(), 
                Args.$at(Cnt).getName(), new LValue(ArgLVal), 
                VarTy.$arrow().isReferenceType()));
      } else {
        // If 'this' is captured, load it into CXXThisValue.
        assert (I.$star().capturesThis());
        $this().CXXThisValue
           = $this().EmitLoadOfLValue(new LValue(ArgLVal), Args.$at(Cnt).getLocation()).getScalarVal();
      }
      ++Cnt;
      I.$preInc();
    }
    
    $this().PGO.assignRegionCounters(new GlobalDecl(CD), F);
    $this().CapturedStmtInfo.EmitBody(/*Deref*/$this(), CD.getBody());
    $this().FinishFunction(CD.getBodyRBrace());
    
    return F;
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateOpenMPCapturedVars">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 125,
 FQN="clang::CodeGen::CodeGenFunction::GenerateOpenMPCapturedVars", NM="_ZN5clang7CodeGen15CodeGenFunction26GenerateOpenMPCapturedVarsERKNS_12CapturedStmtERN4llvm15SmallVectorImplIPNS5_5ValueEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26GenerateOpenMPCapturedVarsERKNS_12CapturedStmtERN4llvm15SmallVectorImplIPNS5_5ValueEEE")
//</editor-fold>
public final void GenerateOpenMPCapturedVars(final /*const*/ CapturedStmt /*&*/ S, final SmallVectorImpl<Value /*P*/ > /*&*/ CapturedVars) {
  /*const*/ RecordDecl /*P*/ RD = S.getCapturedRecordDecl();
  specific_decl_iterator<FieldDecl> CurField = RD.field_begin();
  type$iterator<? extends type$iterator, CapturedStmt.Capture> /*P*/ CurCap = S.captures$Const().begin();
  for (type$ptr<Expr /*P*/ /*const*/ /*P*/> I = $tryClone(S.capture_init_begin$Const()), 
      /*P*/ /*const*/ /*P*/ E = $tryClone(S.capture_init_end$Const());
       $noteq_ptr(I, E); I.$preInc() , CurField.$preInc() , CurCap.$preInc()) {
    if (CurField.$arrow().hasCapturedVLAType()) {
      /*const*/ VariableArrayType /*P*/ VAT = CurField.$arrow().getCapturedVLAType();
      Value /*P*/ Val = $this().VLASizeMap.$at_T1$RR(VAT.getSizeExpr());
      CapturedVars.push_back(Val);
    } else if (CurCap.$star().capturesThis()) {
      CapturedVars.push_back($this().CXXThisValue);
    } else if (CurCap.$star().capturesVariableByCopy()) {
      Value /*P*/ CV = $this().EmitLoadOfLValue($this().EmitLValue(I.$star()), new SourceLocation()).getScalarVal();
      
      // If the field is not a pointer, we need to save the actual value
      // and load it as a void pointer.
      if (!CurField.$arrow().getType().$arrow().isAnyPointerType()) {
        final ASTContext /*&*/ Ctx = $this().getContext();
        Address DstAddr = $this().CreateMemTemp(Ctx.getUIntPtrType(), 
            $add_Twine$C(new Twine(CurCap.$star().getCapturedVar().getName()), new Twine(/*KEEP_STR*/".casted")));
        LValue DstLV = $this().MakeAddrLValue(new Address(DstAddr), Ctx.getUIntPtrType());
        
        Value /*P*/ SrcAddrVal = $this().EmitScalarConversion(DstAddr.getPointer(), Ctx.getPointerType(Ctx.getUIntPtrType()), 
            Ctx.getPointerType(CurField.$arrow().getType()), new SourceLocation());
        LValue SrcLV = $this().MakeNaturalAlignAddrLValue(SrcAddrVal, CurField.$arrow().getType());
        
        // Store the value using the source type pointer.
        $this().EmitStoreThroughLValue(RValue.get(CV), new LValue(SrcLV));
        
        // Load the value using the destination type pointer.
        CV = $this().EmitLoadOfLValue(new LValue(DstLV), new SourceLocation()).getScalarVal();
      }
      CapturedVars.push_back(CV);
    } else {
      assert (CurCap.$star().capturesVariable()) : "Expected capture by reference.";
      CapturedVars.push_back($this().EmitLValue(I.$star()).getAddress().getPointer());
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::emitOMPSimpleStore">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2831,
 FQN="clang::CodeGen::CodeGenFunction::emitOMPSimpleStore", NM="_ZN5clang7CodeGen15CodeGenFunction18emitOMPSimpleStoreENS0_6LValueENS0_6RValueENS_8QualTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18emitOMPSimpleStoreENS0_6LValueENS0_6RValueENS_8QualTypeENS_14SourceLocationE")
//</editor-fold>
public final void emitOMPSimpleStore(LValue LVal, RValue RVal, 
                  QualType RValTy, SourceLocation Loc) {
  switch (CodeGenFunction.getEvaluationKind(LVal.getType())) {
   case TEK_Scalar:
    $this().EmitStoreThroughLValue(RValue.get(CGStmtOpenMPStatics.convertToScalarValue(/*Deref*/$this(), new RValue(RVal), new QualType(RValTy), LVal.getType(), new SourceLocation(Loc))), 
        new LValue(LVal));
    break;
   case TEK_Complex:
    $this().EmitStoreOfComplex(CGStmtOpenMPStatics.convertToComplexValue(/*Deref*/$this(), new RValue(RVal), new QualType(RValTy), LVal.getType(), new SourceLocation(Loc)), new LValue(LVal), 
        /*isInit=*/ false);
    break;
   case TEK_Aggregate:
    throw new llvm_unreachable("Must be a scalar or complex.");
  }
}

/// \brief Perform element by element copying of arrays with type \a
/// OriginalType from \a SrcAddr to \a DestAddr using copying procedure
/// generated by \a CopyGen.
///
/// \param DestAddr Address of the destination array.
/// \param SrcAddr Address of the source array.
/// \param OriginalType Type of destination and source arrays.
/// \param CopyGen Copying procedure that copies value of single array element
/// to another single array element.

//===----------------------------------------------------------------------===//
//                              OpenMP Directive Emission
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPAggregateAssign">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 323,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPAggregateAssign", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitOMPAggregateAssignENS0_7AddressES2_NS_8QualTypeERKN4llvm12function_refIFvS2_S2_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitOMPAggregateAssignENS0_7AddressES2_NS_8QualTypeERKN4llvm12function_refIFvS2_S2_EEE")
//</editor-fold>
public final void EmitOMPAggregateAssign(Address DestAddr, Address SrcAddr, QualType OriginalType, 
                      final /*const*/TypeType2Void<Address, Address> /*&*/ CopyGen) {
  // Perform element-by-element initialization.
  QualType ElementTy/*J*/= new QualType();
  
  // Drill down to the base element type on both arrays.
  /*const*/ org.clang.ast.ArrayType /*P*/ ArrayTy = OriginalType.$arrow().getAsArrayTypeUnsafe();
  Value /*P*/ NumElements = $this().emitArrayLength(ArrayTy, ElementTy, DestAddr);
  SrcAddr.$assignMove($this().Builder.CreateElementBitCast(new Address(SrcAddr), DestAddr.getElementType()));
  
  Value /*P*/ SrcBegin = SrcAddr.getPointer();
  Value /*P*/ DestBegin = DestAddr.getPointer();
  // Cast from pointer to array type to pointer to single element.
  Value /*P*/ DestEnd = $this().Builder.CreateGEP(DestBegin, NumElements);
  // The basic structure here is a while-do loop.
  BasicBlock /*P*/ BodyBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"omp.arraycpy.body"));
  BasicBlock /*P*/ DoneBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"omp.arraycpy.done"));
  Value /*P*/ IsEmpty = $this().Builder.CreateICmpEQ(DestBegin, DestEnd, new Twine(/*KEEP_STR*/"omp.arraycpy.isempty"));
  $this().Builder.CreateCondBr(IsEmpty, DoneBB, BodyBB);
  
  // Enter the loop body, making that address the current address.
  BasicBlock /*P*/ EntryBB = $this().Builder.GetInsertBlock();
  $this().EmitBlock(BodyBB);
  
  CharUnits ElementSize = $this().getContext().getTypeSizeInChars(/*NO_COPY*/ElementTy);
  
  PHINode /*P*/ SrcElementPHI = $this().Builder.CreatePHI(SrcBegin.getType(), 2, new Twine(/*KEEP_STR*/"omp.arraycpy.srcElementPast"));
  SrcElementPHI.addIncoming(SrcBegin, EntryBB);
  Address SrcElementCurrent = new Address(SrcElementPHI, 
      SrcAddr.getAlignment().alignmentOfArrayElement(new CharUnits(ElementSize)));
  
  PHINode /*P*/ DestElementPHI = $this().Builder.CreatePHI(DestBegin.getType(), 2, new Twine(/*KEEP_STR*/"omp.arraycpy.destElementPast"));
  DestElementPHI.addIncoming(DestBegin, EntryBB);
  Address DestElementCurrent = new Address(DestElementPHI, 
      DestAddr.getAlignment().alignmentOfArrayElement(new CharUnits(ElementSize)));
  
  // Emit copy.
  CopyGen.$call(new Address(DestElementCurrent), new Address(SrcElementCurrent));
  
  // Shift the address forward by one element.
  Value /*P*/ DestElementNext = $this().Builder.CreateConstGEP1_32(DestElementPHI, /*Idx0=*/ 1, new Twine(/*KEEP_STR*/"omp.arraycpy.dest.element"));
  Value /*P*/ SrcElementNext = $this().Builder.CreateConstGEP1_32(SrcElementPHI, /*Idx0=*/ 1, new Twine(/*KEEP_STR*/"omp.arraycpy.src.element"));
  // Check whether we've reached the end.
  Value /*P*/ Done = $this().Builder.CreateICmpEQ(DestElementNext, DestEnd, new Twine(/*KEEP_STR*/"omp.arraycpy.done"));
  $this().Builder.CreateCondBr(Done, DoneBB, BodyBB);
  DestElementPHI.addIncoming(DestElementNext, $this().Builder.GetInsertBlock());
  SrcElementPHI.addIncoming(SrcElementNext, $this().Builder.GetInsertBlock());
  
  // Done.
  $this().EmitBlock(DoneBB, /*IsFinished=*/ true);
}

/// \brief Emit proper copying of data from one variable to another.
///
/// \param OriginalType Original type of the copied variables.
/// \param DestAddr Destination address.
/// \param SrcAddr Source address.
/// \param DestVD Destination variable used in \a CopyExpr (for arrays, has
/// type of the base array element).
/// \param SrcVD Source variable used in \a CopyExpr (for arrays, has type of
/// the base array element).
/// \param Copy Actual copygin expression for copying data from \a SrcVD to \a
/// DestVD.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPCopy">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 534,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPCopy", NM="_ZN5clang7CodeGen15CodeGenFunction11EmitOMPCopyENS_8QualTypeENS0_7AddressES3_PKNS_7VarDeclES6_PKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11EmitOMPCopyENS_8QualTypeENS0_7AddressES3_PKNS_7VarDeclES6_PKNS_4ExprE")
//</editor-fold>
public final void EmitOMPCopy(QualType OriginalType, Address DestAddr, 
           Address SrcAddr, /*const*/ VarDecl /*P*/ DestVD, 
           /*const*/ VarDecl /*P*/ SrcVD, /*const*/ Expr /*P*/ Copy) {
  if (OriginalType.$arrow().isArrayType()) {
    /*const*/ org.clang.ast.BinaryOperator /*P*/ BO = AstRTTI.dyn_cast_BinaryOperator(Copy);
    if ((BO != null) && BO.getOpcode() == BinaryOperatorKind.BO_Assign) {
      // Perform simple memcpy for simple copying.
      $this().EmitAggregateAssign(new Address(DestAddr), new Address(SrcAddr), new QualType(OriginalType));
    } else {
      // For arrays with complex element types perform element by element
      // copying.
      VarDecl L$DestVD =DestVD;
      VarDecl L$SrcVD = SrcVD;
      Expr L$Copy = Copy;
      $this().EmitOMPAggregateAssign(new Address(DestAddr), new Address(SrcAddr), new QualType(OriginalType), 
          /*FuncArg*//*[this, =L$Copy(Copy), =L$SrcVD(SrcVD), =L$DestVD(DestVD)]*/ (Address DestElement, Address SrcElement) -> {
                CodeGenFunction.OMPPrivateScope Remap = null;
                try {
                  // Working with the single array element, so have to remap
                  // destination and source variables to corresponding array
                  // elements.
                  Remap/*J*/= new CodeGenFunction.OMPPrivateScope(/*Deref*/$this());
                  Address L$DestElement = DestElement;
                  Remap.addPrivate(L$DestVD, /*FuncArg*//*[=L$DestElement(DestElement)]*/ () -> {
                            return new Address(L$DestElement);
                          });
                  Address L$SrcElement = SrcElement;
                  Remap.addPrivate(L$SrcVD, /*FuncArg*//*[=L$SrcElement(SrcElement)]*/ () -> {
                            return new Address(L$SrcElement);
                          });
                  /*J:(void)*/Remap.Privatize();
                  $this().EmitIgnoredExpr(L$Copy);
                } finally {
                  if (Remap != null) { Remap.$destroy(); }
                }
              });
    }
  } else {
    CodeGenFunction.OMPPrivateScope Remap = null;
    try {
      // Remap pseudo source variable to private copy.
      Remap/*J*/= new CodeGenFunction.OMPPrivateScope(/*Deref*/$this());
      Address L$SrcAddr = SrcAddr;
      Remap.addPrivate(SrcVD, /*FuncArg*//*[=L$SrcAddr(SrcAddr)]*/ () -> {
                return new Address(L$SrcAddr);
              });
      Address L$DestAddr = DestAddr;
      Remap.addPrivate(DestVD, /*FuncArg*//*[=L$DestAddr(DestAddr)]*/ () -> {
                return new Address(L$DestAddr);
              });
      /*J:(void)*/Remap.Privatize();
      // Emit copying of the whole variable.
      $this().EmitIgnoredExpr(Copy);
    } finally {
      if (Remap != null) { Remap.$destroy(); }
    }
  }
}

/// \brief Emit atomic update code for constructs: \a X = \a X \a BO \a E or
/// \a X = \a E \a BO \a E.
///
/// \param X Value to be updated.
/// \param E Update value.
/// \param BO Binary operation for update operation.
/// \param IsXLHSInRHSPart true if \a X is LHS in RHS part of the update
/// expression, false otherwise.
/// \param AO Atomic ordering of the generated atomic instructions.
/// \param CommonGen Code generator for complex expressions that cannot be
/// expressed through atomicrmw instruction.
/// \returns <true, OldAtomicValue> if simple 'atomicrmw' instruction was
/// generated, <false, RValue::get(nullptr)> otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPAtomicSimpleUpdateExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2979,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPAtomicSimpleUpdateExpr", NM="_ZN5clang7CodeGen15CodeGenFunction29EmitOMPAtomicSimpleUpdateExprENS0_6LValueENS0_6RValueENS_18BinaryOperatorKindEbN4llvm14AtomicOrderingENS_14SourceLocationERKNS5_12function_refIFS3_S3_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction29EmitOMPAtomicSimpleUpdateExprENS0_6LValueENS0_6RValueENS_18BinaryOperatorKindEbN4llvm14AtomicOrderingENS_14SourceLocationERKNS5_12function_refIFS3_S3_EEE")
//</editor-fold>
public final std.pairBoolType<RValue> EmitOMPAtomicSimpleUpdateExpr(LValue X, RValue E, BinaryOperatorKind BO, boolean IsXLHSInRHSPart, 
                             AtomicOrdering AO, SourceLocation Loc, 
                             final /*const*/Type2Type<RValue> /*&*/ CommonGen) {
  // Update expressions are allowed to have the following forms:
  // x binop= expr; -> xrval + expr;
  // x++, ++x -> xrval + 1;
  // x--, --x -> xrval - 1;
  // x = x binop expr; -> xrval binop expr
  // x = expr Op x; - > expr binop xrval;
  std.pairBoolType<RValue> Res = CGStmtOpenMPStatics.emitOMPAtomicRMW(/*Deref*/$this(), new LValue(X), new RValue(E), BO, AO, IsXLHSInRHSPart);
  if (!Res.first) {
    if (X.isGlobalReg()) {
      // Emit an update expression: 'xrval' binop 'expr' or 'expr' binop
      // 'xrval'.
      $this().EmitStoreThroughLValue(CommonGen.$call($this().EmitLoadOfLValue(new LValue(X), new SourceLocation(Loc))), new LValue(X));
    } else {
      // Perform compare-and-swap procedure.
      $this().EmitAtomicUpdate(new LValue(X), AO, CommonGen, X.getType().isVolatileQualified());
    }
  }
  return Res;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPFirstprivateClause">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 572,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPFirstprivateClause", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitOMPFirstprivateClauseERKNS_22OMPExecutableDirectiveERNS1_15OMPPrivateScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitOMPFirstprivateClauseERKNS_22OMPExecutableDirectiveERNS1_15OMPPrivateScopeE")
//</editor-fold>
public final boolean EmitOMPFirstprivateClause(final /*const*/ OMPExecutableDirective /*&*/ D, 
                         final OMPPrivateScope /*&*/ PrivateScope) {
  CGCapturedStmtInfo CapturesInfo = null;
  try {
    if (!$this().HaveInsertPoint()) {
      return false;
    }
    boolean FirstprivateIsLastprivate = false;
    DenseSet</*const*/ VarDecl /*P*/ > Lastprivates/*J*/= new DenseSet</*const*/ VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info());
    for (/*const*/ OMPLastprivateClause /*P*/ C : D.<OMPLastprivateClause>getClausesOfKind(OMPLastprivateClause.class)) {
      for (/*const*/ Expr /*P*/ D$1 : C.varlists$Const())  {
        Lastprivates.insert(cast_VarDecl(cast_DeclRefExpr(D$1).getDecl$Const()).getCanonicalDecl$Const());
      }
    }
    DenseSet</*const*/ VarDecl /*P*/ > EmittedAsFirstprivate/*J*/= new DenseSet</*const*/ VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info());
    CapturesInfo/*J*/= new CGCapturedStmtInfo(cast_CapturedStmt($Deref(D.getAssociatedStmt())));
    for (/*const*/ OMPFirstprivateClause /*P*/ C : D.<OMPFirstprivateClause>getClausesOfKind(OMPFirstprivateClause.class)) {
      type$ptr<Expr/*P*/>/*iterator*/ IRef = $tryClone(C.varlist_begin$Const());
      type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> InitsRef = $tryClone(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.inits$Const().begin()));
      for (/*const*/ Expr /*P*/ IInit : C.private_copies$Const()) {
        /*const*/ VarDecl /*P*/ OrigVD = cast_VarDecl(cast_DeclRefExpr(IRef.$star()).getDecl$Const());
        boolean ThisFirstprivateIsLastprivate = $greater_uint(Lastprivates.count(OrigVD.getCanonicalDecl$Const()), 0);
        /*const*/ FieldDecl /*P*/ CapFD = CapturesInfo.lookup(OrigVD);
        /*const*/ FieldDecl /*P*/ FD = $this().CapturedStmtInfo.lookup(OrigVD);
        if (!ThisFirstprivateIsLastprivate && (FD != null) && (FD == CapFD)
           && !FD.getType().$arrow().isReferenceType()) {
          EmittedAsFirstprivate.insert(OrigVD.getCanonicalDecl$Const());
          IRef.$preInc();
          InitsRef.$preInc();
          continue;
        }
        FirstprivateIsLastprivate
           = FirstprivateIsLastprivate || ThisFirstprivateIsLastprivate;
        if (EmittedAsFirstprivate.insert(OrigVD.getCanonicalDecl$Const()).second) {
          /*const*/ VarDecl /*P*/ VD = cast_VarDecl(cast_DeclRefExpr(IInit).getDecl$Const());
          /*const*/ VarDecl /*P*/ VDInit = cast_VarDecl(cast_DeclRefExpr(InitsRef.$star()).getDecl$Const());
          boolean IsRegistered;
          DeclRefExpr DRE/*J*/= new DeclRefExpr(((/*const_cast*/VarDecl /*P*/ )(OrigVD)), 
              /*RefersToEnclosingVariableOrCapture=*/ FD != (/*const*/ FieldDecl /*P*/ )null, 
              (IRef.$star()).getType(), ExprValueKind.VK_LValue, (IRef.$star()).getExprLoc());
          Address OriginalAddr = $this().EmitLValue($AddrOf(DRE)).getAddress();
          QualType Type = VD.getType();
          if (Type.$arrow().isArrayType()) {
            // Emit VarDecl with copy init for arrays.
            // Get the address of the original variable captured in current
            // captured region.
            VarDecl L$VDInit = VDInit;
            IsRegistered = PrivateScope.addPrivate(OrigVD, /*FuncArg*//*[&, this, &VD, &OriginalAddr, &Type, &VDInit]*/ () -> {
                      AutoVarEmission Emission = $this().EmitAutoVarAlloca($Deref(VD));
                      /*const*/ Expr /*P*/ Init = VD.getInit$Const();
                      if (!isa_CXXConstructExpr(Init) || $this().isTrivialInitializer(Init)) {
                        // Perform simple memcpy.
                        $this().EmitAggregateAssign(Emission.getAllocatedAddress(), new Address(OriginalAddr), 
                            new QualType(Type));
                      } else {
                        Expr L$Init = Init;
                        $this().EmitOMPAggregateAssign(Emission.getAllocatedAddress(), new Address(OriginalAddr), new QualType(Type), 
                            /*FuncArg*//*[this, =L$VDInit(VDInit), =L$Init(Init)]*/ (Address DestElement, Address SrcElement) -> {
                                  RunCleanupsScope InitScope = null;
                                  try {
                                    // Clean up any temporaries needed by the initialization.
                                    InitScope/*J*/= new RunCleanupsScope(/*Deref*/$this());
                                    // Emit initialization for single element.
                                    $this().setAddrOfLocalVar(L$VDInit, new Address(SrcElement));
                                    $this().EmitAnyExprToMem(L$Init, new Address(DestElement), 
                                        L$Init.getType().getQualifiers(), 
                                        /*IsInitializer*/ false);
                                    $this().LocalDeclMap.erase(L$VDInit);
                                  } finally {
                                    if (InitScope != null) { InitScope.$destroy(); }
                                  }
                                });
                      }
                      $this().EmitAutoVarCleanups(Emission);
                      return Emission.getAllocatedAddress();
                    });
          } else {
            IsRegistered = PrivateScope.addPrivate(OrigVD, /*FuncArg*//*[&, this, &VDInit, &OriginalAddr, &VD]*/ () -> {
                      // Emit private VarDecl with copy init.
                      // Remap temp VDInit variable to the address of the original
                      // variable
                      // (for proper handling of captured global variables).
                      $this().setAddrOfLocalVar(VDInit, new Address(OriginalAddr));
                      $this().EmitDecl($Deref(VD));
                      $this().LocalDeclMap.erase(VDInit);
                      return $this().GetAddrOfLocalVar(VD);
                    });
          }
          assert (IsRegistered) : "firstprivate var already registered as private";
          // Silence the warning about unused variable.
          ///*J:(void)*/IsRegistered;
        }
        IRef.$preInc();
        InitsRef.$preInc();
      }
    }
    return FirstprivateIsLastprivate && !EmittedAsFirstprivate.empty();
  } finally {
    if (CapturesInfo != null) { CapturesInfo.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPPrivateClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 665,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPPrivateClause", NM="_ZN5clang7CodeGen15CodeGenFunction20EmitOMPPrivateClauseERKNS_22OMPExecutableDirectiveERNS1_15OMPPrivateScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20EmitOMPPrivateClauseERKNS_22OMPExecutableDirectiveERNS1_15OMPPrivateScopeE")
//</editor-fold>
public final void EmitOMPPrivateClause(final /*const*/ OMPExecutableDirective /*&*/ D, 
                    final CodeGenFunction.OMPPrivateScope /*&*/ PrivateScope) {
  if (!$this().HaveInsertPoint()) {
    return;
  }
  DenseSet</*const*/ VarDecl /*P*/ > EmittedAsPrivate/*J*/= new DenseSet</*const*/ VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info());
  for (/*const*/ OMPPrivateClause /*P*/ C : D.<OMPPrivateClause>getClausesOfKind(OMPPrivateClause.class)) {
    type$ptr<Expr/*P*/>/*iterator*/ IRef = $tryClone(C.varlist_begin$Const());
    for (/*const*/ Expr /*P*/ IInit : C.private_copies$Const()) {
      /*const*/ VarDecl /*P*/ OrigVD = cast_VarDecl(cast_DeclRefExpr(IRef.$star()).getDecl$Const());
      if (EmittedAsPrivate.insert(OrigVD.getCanonicalDecl$Const()).second) {
        /*const*/ VarDecl /*P*/ VD = cast_VarDecl(cast_DeclRefExpr(IInit).getDecl$Const());
        boolean IsRegistered = PrivateScope.addPrivate(OrigVD, /*FuncArg*//*[&, this, &VD]*/ () -> {
                  // Emit private VarDecl with copy init.
                  $this().EmitDecl($Deref(VD));
                  return $this().GetAddrOfLocalVar(VD);
                });
        assert (IsRegistered) : "private var already registered as private";
        // Silence the warning about unused variable.
        ///*J:(void)*/IsRegistered;
      }
      IRef.$preInc();
    }
  }
}

/// \brief Emit code for copyin clause in \a D directive. The next code is
/// generated at the start of outlined functions for directives:
/// \code
/// threadprivate_var1 = master_threadprivate_var1;
/// operator=(threadprivate_var2, master_threadprivate_var2);
/// ...
/// __kmpc_barrier(&loc, global_tid);
/// \endcode
///
/// \param D OpenMP directive possibly with 'copyin' clause(s).
/// \returns true if at least one copyin variable is found, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPCopyinClause">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 692,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPCopyinClause", NM="_ZN5clang7CodeGen15CodeGenFunction19EmitOMPCopyinClauseERKNS_22OMPExecutableDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19EmitOMPCopyinClauseERKNS_22OMPExecutableDirectiveE")
//</editor-fold>
public final boolean EmitOMPCopyinClause(final /*const*/ OMPExecutableDirective /*&*/ D) {
  if (!$this().HaveInsertPoint()) {
    return false;
  }
  // threadprivate_var1 = master_threadprivate_var1;
  // operator=(threadprivate_var2, master_threadprivate_var2);
  // ...
  // __kmpc_barrier(&loc, global_tid);
  DenseSet</*const*/ VarDecl /*P*/ > CopiedVars/*J*/= new DenseSet</*const*/ VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info());
  BasicBlock /*P*/ CopyBegin = null;
  BasicBlock /*P*/ CopyEnd = null;
  for (/*const*/ OMPCopyinClause /*P*/ C : D.<OMPCopyinClause>getClausesOfKind(OMPCopyinClause.class)) {
    type$ptr<Expr/*P*/>/*iterator*/ IRef = $tryClone(C.varlist_begin$Const());
    type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> ISrcRef = $tryClone(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.source_exprs$Const().begin()));
    type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> IDestRef = $tryClone(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.destination_exprs$Const().begin()));
    for (/*const*/ Expr /*P*/ AssignOp : C.assignment_ops$Const()) {
      /*const*/ VarDecl /*P*/ VD = cast_VarDecl(cast_DeclRefExpr(IRef.$star()).getDecl$Const());
      QualType Type = VD.getType();
      if (CopiedVars.insert(VD.getCanonicalDecl$Const()).second) {
        // Get the address of the master variable. If we are emitting code with
        // TLS support, the address is passed from the master as field in the
        // captured declaration.
        Address MasterAddr = Address.invalid();
        if ($this().getLangOpts().OpenMPUseTLS
           && $this().getContext().getTargetInfo().isTLSSupported()) {
          assert (($this().CapturedStmtInfo.lookup(VD) != null)) : "Copyin threadprivates should have been captured!";
          DeclRefExpr DRE/*J*/= new DeclRefExpr(((/*const_cast*/VarDecl /*P*/ )(VD)), true, (IRef.$star()).getType(), 
              ExprValueKind.VK_LValue, (IRef.$star()).getExprLoc());
          MasterAddr.$assignMove($this().EmitLValue($AddrOf(DRE)).getAddress());
          $this().LocalDeclMap.erase(VD);
        } else {
          MasterAddr.$assignMove(
              new Address(VD.isStaticLocal() ? $this().CGM.getStaticLocalDeclAddress(VD) : $this().CGM.GetAddrOfGlobal(new GlobalDecl(VD)), 
                  $this().getContext().getDeclAlign(VD))
          );
        }
        // Get the address of the threadprivate variable.
        Address PrivateAddr = $this().EmitLValue(IRef.$star()).getAddress();
        if (CopiedVars.size() == 1) {
          // At first check if current thread is a master thread. If it is, no
          // need to copy data.
          CopyBegin = $this().createBasicBlock(new Twine(/*KEEP_STR*/"copyin.not.master"));
          CopyEnd = $this().createBasicBlock(new Twine(/*KEEP_STR*/"copyin.not.master.end"));
          $this().Builder.CreateCondBr($this().Builder.CreateICmpNE($this().Builder.CreatePtrToInt(MasterAddr.getPointer(), $this().CGM.Unnamed_field8.IntPtrTy), 
                  $this().Builder.CreatePtrToInt(PrivateAddr.getPointer(), $this().CGM.Unnamed_field8.IntPtrTy)), 
              CopyBegin, CopyEnd);
          $this().EmitBlock(CopyBegin);
        }
        /*const*/ VarDecl /*P*/ SrcVD = cast_VarDecl(cast_DeclRefExpr(ISrcRef.$star()).getDecl$Const());
        /*const*/ VarDecl /*P*/ DestVD = cast_VarDecl(cast_DeclRefExpr(IDestRef.$star()).getDecl$Const());
        $this().EmitOMPCopy(new QualType(Type), new Address(PrivateAddr), new Address(MasterAddr), DestVD, SrcVD, AssignOp);
      }
      IRef.$preInc();
      ISrcRef.$preInc();
      IDestRef.$preInc();
    }
  }
  if ((CopyEnd != null)) {
    // Exit out of copying procedure for non-master thread.
    $this().EmitBlock(CopyEnd, /*IsFinished=*/ true);
    return true;
  }
  return false;
}

/// \brief Emit initial code for lastprivate variables. If some variable is
/// not also firstprivate, then the default initialization is used. Otherwise
/// initialization of this variable is performed by EmitOMPFirstprivateClause
/// method.
///
/// \param D Directive that may have 'lastprivate' directives.
/// \param PrivateScope Private scope for capturing lastprivate variables for
/// proper codegen in internal captured statement.
///
/// \returns true if there is at least one lastprivate variable, false
/// otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPLastprivateClauseInit">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 758,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPLastprivateClauseInit", NM="_ZN5clang7CodeGen15CodeGenFunction28EmitOMPLastprivateClauseInitERKNS_22OMPExecutableDirectiveERNS1_15OMPPrivateScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28EmitOMPLastprivateClauseInitERKNS_22OMPExecutableDirectiveERNS1_15OMPPrivateScopeE")
//</editor-fold>
public final boolean EmitOMPLastprivateClauseInit(final /*const*/ OMPExecutableDirective /*&*/ D, final OMPPrivateScope /*&*/ PrivateScope) {
  if (!$this().HaveInsertPoint()) {
    return false;
  }
  boolean HasAtLeastOneLastprivate = false;
  DenseSet</*const*/ VarDecl /*P*/ > SIMDLCVs/*J*/= new DenseSet</*const*/ VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info());
  if (isOpenMPSimdDirective(D.getDirectiveKind())) {
    /*const*/ OMPLoopDirective /*P*/ LoopDirective = cast_OMPLoopDirective($AddrOf(D));
    for (Expr /*P*/ C : LoopDirective.counters$Const()) {
      SIMDLCVs.insert(cast_VarDecl(cast_DeclRefExpr(C).getDecl()).getCanonicalDecl());
    }
  }
  DenseSet</*const*/ VarDecl /*P*/ > AlreadyEmittedVars/*J*/= new DenseSet</*const*/ VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info());
  for (/*const*/ OMPLastprivateClause /*P*/ C : D.<OMPLastprivateClause>getClausesOfKind(OMPLastprivateClause.class)) {
    HasAtLeastOneLastprivate = true;
    if (isOpenMPTaskLoopDirective(D.getDirectiveKind())) {
      break;
    }
    type$ptr<Expr/*P*/>/*iterator*/ IRef = $tryClone(C.varlist_begin$Const());
    type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> IDestRef = $tryClone(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.destination_exprs$Const().begin()));
    for (/*const*/ Expr /*P*/ IInit : C.private_copies$Const()) {
      // Keep the address of the original variable for future update at the end
      // of the loop.
      /*const*/ VarDecl /*P*/ OrigVD = cast_VarDecl(cast_DeclRefExpr(IRef.$star()).getDecl$Const());
      // Taskloops do not require additional initialization, it is done in
      // runtime support library.
      if (AlreadyEmittedVars.insert(OrigVD.getCanonicalDecl$Const()).second) {
        /*const*/ VarDecl /*P*/ DestVD = cast_VarDecl(cast_DeclRefExpr(IDestRef.$star()).getDecl$Const());
        VarDecl L$OrigVD = OrigVD;
        type$ptr<Expr/*P*/>/*iterator*/L$IRef = $tryClone(IRef);
        PrivateScope.addPrivate(DestVD, /*FuncArg*//*[this, =L$OrigVD(OrigVD), =L$IRef(IRef)]*/ () -> {
                  DeclRefExpr DRE/*J*/= new DeclRefExpr(((/*const_cast*/VarDecl /*P*/ )(L$OrigVD)), 
                      /*RefersToEnclosingVariableOrCapture=*/ $this().CapturedStmtInfo.lookup(L$OrigVD) != (/*const*/ FieldDecl /*P*/ )null, 
                      (L$IRef.$star()).getType(), ExprValueKind.VK_LValue, (L$IRef.$star()).getExprLoc());
                  return $this().EmitLValue($AddrOf(DRE)).getAddress();
                });
        // Check if the variable is also a firstprivate: in this case IInit is
        // not generated. Initialization of this variable will happen in codegen
        // for 'firstprivate' clause.
        if ((IInit != null) && !(SIMDLCVs.count(OrigVD.getCanonicalDecl$Const()) != 0)) {
          /*const*/ VarDecl /*P*/ VD = cast_VarDecl(cast_DeclRefExpr(IInit).getDecl$Const());
          boolean IsRegistered = PrivateScope.addPrivate(OrigVD, /*FuncArg*//*[&, this, &VD]*/ () -> {
                    // Emit private VarDecl with copy init.
                    $this().EmitDecl($Deref(VD));
                    return $this().GetAddrOfLocalVar(VD);
                  });
          assert (IsRegistered) : "lastprivate var already registered as private";
          ///*J:(void)*/IsRegistered;
        }
      }
      IRef.$preInc();
      IDestRef.$preInc();
    }
  }
  return HasAtLeastOneLastprivate;
}

/// \brief Emit final copying of lastprivate values to original variables at
/// the end of the worksharing or simd directive.
///
/// \param D Directive that has at least one 'lastprivate' directives.
/// \param IsLastIterCond Boolean condition that must be set to 'i1 true' if
/// it is the last iteration of the loop code in associated directive, or to
/// 'i1 false' otherwise. If this item is nullptr, no final check is required.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPLastprivateClauseFinal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 816,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPLastprivateClauseFinal", NM="_ZN5clang7CodeGen15CodeGenFunction29EmitOMPLastprivateClauseFinalERKNS_22OMPExecutableDirectiveEbPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction29EmitOMPLastprivateClauseFinalERKNS_22OMPExecutableDirectiveEbPN4llvm5ValueE")
//</editor-fold>
public final void EmitOMPLastprivateClauseFinal(final /*const*/ OMPExecutableDirective /*&*/ D, boolean NoFinals) {
  EmitOMPLastprivateClauseFinal(D, NoFinals, 
                             (Value /*P*/ )null);
}
public final void EmitOMPLastprivateClauseFinal(final /*const*/ OMPExecutableDirective /*&*/ D, boolean NoFinals, 
                             Value /*P*/ IsLastIterCond/*= null*/) {
  if (!$this().HaveInsertPoint()) {
    return;
  }
  // Emit following code:
  // if (<IsLastIterCond>) {
  //   orig_var1 = private_orig_var1;
  //   ...
  //   orig_varn = private_orig_varn;
  // }
  BasicBlock /*P*/ ThenBB = null;
  BasicBlock /*P*/ DoneBB = null;
  if ((IsLastIterCond != null)) {
    ThenBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/".omp.lastprivate.then"));
    DoneBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/".omp.lastprivate.done"));
    $this().Builder.CreateCondBr(IsLastIterCond, ThenBB, DoneBB);
    $this().EmitBlock(ThenBB);
  }
  DenseSet</*const*/ VarDecl /*P*/ > AlreadyEmittedVars/*J*/= new DenseSet</*const*/ VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info());
  DenseMap</*const*/ VarDecl /*P*/ , /*const*/ Expr /*P*/ > LoopCountersAndUpdates/*J*/= new DenseMap</*const*/ VarDecl /*P*/ , /*const*/ Expr /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ Expr /*P*/ )null);
  {
    /*const*/ OMPLoopDirective /*P*/ LoopDirective = dyn_cast_OMPLoopDirective($AddrOf(D));
    if ((LoopDirective != null)) {
      type$ptr<Expr /*P*/ /*const*/ /*P*/> IC = $tryClone(LoopDirective.counters$Const().begin());
      for (Expr /*P*/ F : LoopDirective.finals$Const()) {
        VarDecl /*P*/ D$1 = cast_VarDecl(cast_DeclRefExpr(IC.$star()).getDecl()).getCanonicalDecl();
        if (NoFinals) {
          AlreadyEmittedVars.insert(D$1);
        } else {
          LoopCountersAndUpdates.$set(D$1, F);
        }
        IC.$preInc();
      }
    }
  }
  for (/*const*/ OMPLastprivateClause /*P*/ C : D.<OMPLastprivateClause>getClausesOfKind(OMPLastprivateClause.class)) {
    type$ptr<Expr/*P*/>/*iterator*/ IRef = $tryClone(C.varlist_begin$Const());
    type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> ISrcRef = $tryClone(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.source_exprs$Const().begin()));
    type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> IDestRef = $tryClone(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.destination_exprs$Const().begin()));
    for (/*const*/ Expr /*P*/ AssignOp : C.assignment_ops$Const()) {
      /*const*/ VarDecl /*P*/ PrivateVD = cast_VarDecl(cast_DeclRefExpr(IRef.$star()).getDecl$Const());
      QualType Type = PrivateVD.getType();
      /*const*/ VarDecl /*P*/ CanonicalVD = PrivateVD.getCanonicalDecl$Const();
      if (AlreadyEmittedVars.insert(CanonicalVD).second) {
        {
          // If lastprivate variable is a loop control variable for loop-based
          // directive, update its value before copyin back to original
          // variable.
          /*const*/ Expr /*P*/ FinalExpr = LoopCountersAndUpdates.lookup(CanonicalVD);
          if ((FinalExpr != null)) {
            $this().EmitIgnoredExpr(FinalExpr);
          }
        }
        /*const*/ VarDecl /*P*/ SrcVD = cast_VarDecl(cast_DeclRefExpr(ISrcRef.$star()).getDecl$Const());
        /*const*/ VarDecl /*P*/ DestVD = cast_VarDecl(cast_DeclRefExpr(IDestRef.$star()).getDecl$Const());
        // Get the address of the original variable.
        Address OriginalAddr = $this().GetAddrOfLocalVar(DestVD);
        // Get the address of the private variable.
        Address PrivateAddr = $this().GetAddrOfLocalVar(PrivateVD);
        {
          /*const*/ ReferenceType /*P*/ RefTy = PrivateVD.getType().$arrow().getAs(ReferenceType.class);
          if ((RefTy != null)) {
            PrivateAddr.$assignMove(
                new Address($this().Builder.CreateLoad(new Address(PrivateAddr)), 
                    $this().getNaturalTypeAlignment(RefTy.getPointeeType()))
            );
          }
        }
        $this().EmitOMPCopy(new QualType(Type), new Address(OriginalAddr), new Address(PrivateAddr), DestVD, SrcVD, AssignOp);
      }
      IRef.$preInc();
      ISrcRef.$preInc();
      IDestRef.$preInc();
    }
    {
      /*const*/ Expr /*P*/ PostUpdate = C.getPostUpdateExpr$Const();
      if ((PostUpdate != null)) {
        $this().EmitIgnoredExpr(PostUpdate);
      }
    }
  }
  if ((IsLastIterCond != null)) {
    $this().EmitBlock(DoneBB, /*IsFinished=*/ true);
  }
}

/// Emit initial code for linear clauses.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPLinearClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1474,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPLinearClause", NM="_ZN5clang7CodeGen15CodeGenFunction19EmitOMPLinearClauseERKNS_16OMPLoopDirectiveERNS1_15OMPPrivateScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19EmitOMPLinearClauseERKNS_16OMPLoopDirectiveERNS1_15OMPPrivateScopeE")
//</editor-fold>
public final void EmitOMPLinearClause(final /*const*/ OMPLoopDirective /*&*/ D, final CodeGenFunction.OMPPrivateScope /*&*/ PrivateScope) {
  if (!$this().HaveInsertPoint()) {
    return;
  }
  DenseSet</*const*/ VarDecl /*P*/ > SIMDLCVs/*J*/= new DenseSet</*const*/ VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info());
  if (isOpenMPSimdDirective(D.getDirectiveKind())) {
    /*const*/ OMPLoopDirective /*P*/ LoopDirective = cast_OMPLoopDirective($AddrOf(D));
    for (Expr /*P*/ C : LoopDirective.counters$Const()) {
      SIMDLCVs.insert(cast_VarDecl(cast_DeclRefExpr(C).getDecl()).getCanonicalDecl());
    }
  }
  for (/*const*/ OMPLinearClause /*P*/ C : D.<OMPLinearClause>getClausesOfKind(OMPLinearClause.class)) {
    type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> CurPrivate = $tryClone(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.privates$Const().begin()));
    for (/*const*/ Expr /*P*/ E : C.varlists$Const()) {
      /*const*/ VarDecl /*P*/ VD = cast_VarDecl(cast_DeclRefExpr(E).getDecl$Const());
      /*const*/ VarDecl /*P*/ PrivateVD = cast_VarDecl(cast_DeclRefExpr(CurPrivate.$star()).getDecl$Const());
      if (!(SIMDLCVs.count(VD.getCanonicalDecl$Const()) != 0)) {
        boolean IsRegistered = PrivateScope.addPrivate(VD, /*FuncArg*//*[&, this, &PrivateVD]*/ () -> {
                  // Emit private VarDecl with copy init.
                  $this().EmitVarDecl($Deref(PrivateVD));
                  return $this().GetAddrOfLocalVar(PrivateVD);
                });
        assert (IsRegistered) : "linear var already registered as private";
        // Silence the warning about unused variable.
        ///*J:(void)*/IsRegistered;
      } else {
        $this().EmitVarDecl($Deref(PrivateVD));
      }
      CurPrivate.$preInc();
    }
  }
}

/// Emit final code for linear clauses.
/// \param CondGen Optional conditional code for final part of codegen for
/// linear clause.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPLinearClauseFinal">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1353,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPLinearClauseFinal", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitOMPLinearClauseFinalERKNS_16OMPLoopDirectiveERKN4llvm12function_refIFPNS5_5ValueERS1_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitOMPLinearClauseFinalERKNS_16OMPLoopDirectiveERKN4llvm12function_refIFPNS5_5ValueERS1_EEE")
//</editor-fold>
public final void EmitOMPLinearClauseFinal(final /*const*/ OMPLoopDirective /*&*/ D, 
                        final /*const*/CodeGenFunction.ValueProducer /*&*/ CondGen) {
  if (!$this().HaveInsertPoint()) {
    return;
  }
  BasicBlock /*P*/ DoneBB = null;
  // Emit the final values of the linear variables.
  for (/*const*/ OMPLinearClause /*P*/ C : D.<OMPLinearClause>getClausesOfKind(OMPLinearClause.class)) {
    type$ptr<Expr/*P*/>/*iterator*/ IC = $tryClone(C.varlist_begin$Const());
    for (/*const*/ Expr /*P*/ F : C.finals$Const()) {
      CodeGenFunction.OMPPrivateScope VarScope = null;
      try {
        if (!(DoneBB != null)) {
          {
            Value /*P*/ Cond = CondGen.$call(/*Deref*/$this());
            if ((Cond != null)) {
              // If the first post-update expression is found, emit conditional
              // block if it was requested.
              BasicBlock /*P*/ ThenBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/".omp.linear.pu"));
              DoneBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/".omp.linear.pu.done"));
              $this().Builder.CreateCondBr(Cond, ThenBB, DoneBB);
              $this().EmitBlock(ThenBB);
            }
          }
        }
        /*const*/ VarDecl /*P*/ OrigVD = cast_VarDecl(cast_DeclRefExpr(IC.$star()).getDecl$Const());
        DeclRefExpr DRE/*J*/= new DeclRefExpr(((/*const_cast*/VarDecl /*P*/ )(OrigVD)), 
            $this().CapturedStmtInfo.lookup(OrigVD) != (/*const*/ FieldDecl /*P*/ )null, 
            (IC.$star()).getType(), ExprValueKind.VK_LValue, (IC.$star()).getExprLoc());
        Address OrigAddr = $this().EmitLValue($AddrOf(DRE)).getAddress();
        VarScope/*J*/= new CodeGenFunction.OMPPrivateScope(/*Deref*/$this());
        Address L$OrigAddr = OrigAddr;
        VarScope.addPrivate(OrigVD, /*FuncArg*//*[=L$OrigAddr(OrigAddr)]*/ () -> {
                  return new Address(L$OrigAddr);
                });
        /*J:(void)*/VarScope.Privatize();
        $this().EmitIgnoredExpr(F);
        IC.$preInc();
      } finally {
        if (VarScope != null) { VarScope.$destroy(); }
      }
    }
    {
      /*const*/ Expr /*P*/ PostUpdate = C.getPostUpdateExpr$Const();
      if ((PostUpdate != null)) {
        $this().EmitIgnoredExpr(PostUpdate);
      }
    }
  }
  if ((DoneBB != null)) {
    $this().EmitBlock(DoneBB, /*IsFinished=*/ true);
  }
}

/// \brief Emit initial code for reduction variables. Creates reduction copies
/// and initializes them with the values according to OpenMP standard.
///
/// \param D Directive (possibly) with the 'reduction' clause.
/// \param PrivateScope Private scope for capturing reduction variables for
/// proper codegen in internal captured statement.
///
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPReductionClauseInit">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 934,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPReductionClauseInit", NM="_ZN5clang7CodeGen15CodeGenFunction26EmitOMPReductionClauseInitERKNS_22OMPExecutableDirectiveERNS1_15OMPPrivateScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26EmitOMPReductionClauseInitERKNS_22OMPExecutableDirectiveERNS1_15OMPPrivateScopeE")
//</editor-fold>
public final void EmitOMPReductionClauseInit(final /*const*/ OMPExecutableDirective /*&*/ D, 
                          final CodeGenFunction.OMPPrivateScope /*&*/ PrivateScope) {
  if (!$this().HaveInsertPoint()) {
    return;
  }
  for (/*const*/ OMPReductionClause /*P*/ C : D.<OMPReductionClause>getClausesOfKind(OMPReductionClause.class)) {
    type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> ILHS = $tryClone(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.lhs_exprs$Const().begin()));
    type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> IRHS = $tryClone(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.rhs_exprs$Const().begin()));
    type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> IPriv = $tryClone(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.privates$Const().begin()));
    type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> IRed = $tryClone(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.reduction_ops$Const().begin()));
    for (/*const*/ Expr /*P*/ IRef : C.varlists$Const()) {
      /*const*/ VarDecl /*P*/ LHSVD = cast_VarDecl(cast_DeclRefExpr(ILHS.$star()).getDecl$Const());
      /*const*/ VarDecl /*P*/ RHSVD = cast_VarDecl(cast_DeclRefExpr(IRHS.$star()).getDecl$Const());
      /*const*/ VarDecl /*P*/ PrivateVD = cast_VarDecl(cast_DeclRefExpr(IPriv.$star()).getDecl$Const());
      /*const*/ OMPDeclareReductionDecl /*P*/ DRD = CGStmtOpenMPStatics.getReductionInit(IRed.$star());
      {
        /*const*/ OMPArraySectionExpr /*P*/ OASE = dyn_cast_OMPArraySectionExpr(IRef);
        if ((OASE != null)) {
          /*const*/ Expr /*P*/ Base = OASE.getBase$Const().IgnoreParenImpCasts$Const();
          {
            /*const*/ OMPArraySectionExpr /*P*/ TempOASE;
            while (((/*P*/ TempOASE = dyn_cast_OMPArraySectionExpr(Base)) != null)) {
              Base = TempOASE.getBase$Const().IgnoreParenImpCasts$Const();
            }
          }
          {
            /*const*/ ArraySubscriptExpr /*P*/ TempASE;
            while (((/*P*/ TempASE = dyn_cast_ArraySubscriptExpr(Base)) != null)) {
              Base = TempASE.getBase$Const().IgnoreParenImpCasts$Const();
            }
          }
          /*const*/ DeclRefExpr /*P*/ DE = cast_DeclRefExpr(Base);
          /*const*/ VarDecl /*P*/ OrigVD = cast_VarDecl(DE.getDecl$Const());
          LValue OASELValueLB = $this().EmitOMPArraySectionExpr(OASE);
          LValue OASELValueUB = $this().EmitOMPArraySectionExpr(OASE, /*IsLowerBound=*/ false);
          LValue OriginalBaseLValue = $this().EmitLValue(DE);
          LValue BaseLValue = CGStmtOpenMPStatics.loadToBegin(/*Deref*/$this(), OrigVD.getType(), OASELValueLB.getType(), 
              new LValue(OriginalBaseLValue));
          // Store the address of the original variable associated with the LHS
          // implicit variable.
          LValue L$OASELValueLB = OASELValueLB;
          LValue L$OASELValueUB = OASELValueUB;
          VarDecl L$PrivateVD = PrivateVD;
          type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> L$IRed = $tryClone(IRed);
          OMPDeclareReductionDecl L$DRD = DRD;
          LValue L$BaseLValue = BaseLValue;
          VarDecl L$OrigVD = OrigVD;
          LValue L$OriginalBaseLValue = OriginalBaseLValue;
          PrivateScope.addPrivate(LHSVD, /*FuncArg*//*[this, =L$OASELValueLB(OASELValueLB)]*/ () -> {
                    return L$OASELValueLB.getAddress();
                  });
          // Emit reduction copy.
          boolean IsRegistered = PrivateScope.addPrivate(OrigVD, /*FuncArg*//*[this, =L$OrigVD(OrigVD), =L$PrivateVD(PrivateVD), =L$BaseLValue(BaseLValue), =L$OASELValueLB(OASELValueLB), =L$OASELValueUB(OASELValueUB), =L$OriginalBaseLValue(OriginalBaseLValue), =L$DRD(DRD), =L$IRed(IRed)]*/ () -> {
                    CodeGenFunction.OpaqueValueMapping OpaqueMap = null;
                    try {
                      // Emit VarDecl with copy init for arrays.
                      // Get the address of the original variable captured in current
                      // captured region.
                      Value /*P*/ Size = $this().Builder.CreatePtrDiff(L$OASELValueUB.getPointer(), 
                          L$OASELValueLB.getPointer());
                      Size = $this().Builder.CreateNUWAdd(Size, ConstantInt.get(Size.getType(), /*V=*/ $int2ulong(1)));
                      OpaqueMap/*J*/= new CodeGenFunction.OpaqueValueMapping(/*Deref*/$this(), cast_OpaqueValueExpr($this().getContext().
    getAsVariableArrayType(L$PrivateVD.getType()).
    getSizeExpr()), 
                          RValue.get(Size));
                      $this().EmitVariablyModifiedType(L$PrivateVD.getType());
                      AutoVarEmission Emission = $this().EmitAutoVarAlloca($Deref(L$PrivateVD));
                      Address Addr = Emission.getAllocatedAddress();
                      /*const*/ Expr /*P*/ Init = L$PrivateVD.getInit$Const();
                      CGStmtOpenMPStatics.EmitOMPAggregateInit(/*Deref*/$this(), new Address(Addr), L$PrivateVD.getType(), 
                          (L$DRD != null) ? L$IRed.$star() : Init, 
                          L$OASELValueLB.getAddress());
                      $this().EmitAutoVarCleanups(Emission);
                      // Emit private VarDecl with reduction init.
                      Value /*P*/ Offset = $this().Builder.CreatePtrDiff(L$BaseLValue.getPointer(), 
                          L$OASELValueLB.getPointer());
                      Value /*P*/ Ptr = $this().Builder.CreateGEP(Addr.getPointer(), Offset);
                      return CGStmtOpenMPStatics.castToBase(/*Deref*/$this(), L$OrigVD.getType(), 
                          L$OASELValueLB.getType(), new LValue(L$OriginalBaseLValue), 
                          Ptr);
                    } finally {
                      if (OpaqueMap != null) { OpaqueMap.$destroy(); }
                    }
                  });
          assert (IsRegistered) : "private var already registered as private";
          // Silence the warning about unused variable.
          ///*J:(void)*/IsRegistered;
          PrivateScope.addPrivate(RHSVD, /*FuncArg*//*[this, =L$PrivateVD(PrivateVD)]*/ () -> {
                    return $this().GetAddrOfLocalVar(L$PrivateVD);
                  });
        } else {
          /*const*/ ArraySubscriptExpr /*P*/ ASE = dyn_cast_ArraySubscriptExpr(IRef);
          if ((ASE != null)) {
            /*const*/ Expr /*P*/ Base = ASE.getBase$Const().IgnoreParenImpCasts$Const();
            {
              /*const*/ ArraySubscriptExpr /*P*/ TempASE;
              while (((/*P*/ TempASE = dyn_cast_ArraySubscriptExpr(Base)) != null)) {
                Base = TempASE.getBase$Const().IgnoreParenImpCasts$Const();
              }
            }
            /*const*/ DeclRefExpr /*P*/ DE = cast_DeclRefExpr(Base);
            /*const*/ VarDecl /*P*/ OrigVD = cast_VarDecl(DE.getDecl$Const());
            LValue ASELValue = $this().EmitLValue(ASE);
            LValue OriginalBaseLValue = $this().EmitLValue(DE);
            LValue BaseLValue = CGStmtOpenMPStatics.loadToBegin(/*Deref*/$this(), OrigVD.getType(), ASELValue.getType(), new LValue(OriginalBaseLValue));
            // Store the address of the original variable associated with the LHS
            // implicit variable.
            LValue L$ASELValue = ASELValue;
            PrivateScope.addPrivate(LHSVD, /*FuncArg*//*[this, =L$ASELValue(ASELValue)]*/ () -> {
                      return L$ASELValue.getAddress();
                    });
            // Emit reduction copy.
            VarDecl L$PrivateVD = PrivateVD;
            OMPDeclareReductionDecl L$DRD = DRD;
            type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> L$IRed = $tryClone(IRed);
            LValue L$BaseLValue = BaseLValue;
            VarDecl L$OrigVD = OrigVD;
            LValue L$OriginalBaseLValue = OriginalBaseLValue;
            boolean IsRegistered = PrivateScope.addPrivate(OrigVD, /*FuncArg*//*[this, =L$OrigVD(OrigVD), =L$PrivateVD(PrivateVD), =L$BaseLValue(BaseLValue), =L$ASELValue(ASELValue), =L$OriginalBaseLValue(OriginalBaseLValue), =L$DRD(DRD), =L$IRed(IRed)]*/ () -> {
                      // Emit private VarDecl with reduction init.
                      AutoVarEmission Emission = $this().EmitAutoVarAlloca($Deref(L$PrivateVD));
                      Address Addr = Emission.getAllocatedAddress();
                      if ((L$DRD != null) && ((L$DRD.getInitializer$Const() != null) || !L$PrivateVD.hasInit())) {
                        CGStmtOpenMPStatics.emitInitWithReductionInitializer(/*Deref*/$this(), L$DRD, L$IRed.$star(), new Address(Addr), 
                            L$ASELValue.getAddress(), 
                            L$ASELValue.getType());
                      } else {
                        $this().EmitAutoVarInit(Emission);
                      }
                      $this().EmitAutoVarCleanups(Emission);
                      Value /*P*/ Offset = $this().Builder.CreatePtrDiff(L$BaseLValue.getPointer(), 
                          L$ASELValue.getPointer());
                      Value /*P*/ Ptr = $this().Builder.CreateGEP(Addr.getPointer(), Offset);
                      return CGStmtOpenMPStatics.castToBase(/*Deref*/$this(), L$OrigVD.getType(), L$ASELValue.getType(), 
                          new LValue(L$OriginalBaseLValue), Ptr);
                    });
            assert (IsRegistered) : "private var already registered as private";
            // Silence the warning about unused variable.
            ///*J:(void)*/IsRegistered;
            VarDecl L$RHSVD = RHSVD;
            PrivateScope.addPrivate(RHSVD, /*FuncArg*//*[this, =L$PrivateVD(PrivateVD), =L$RHSVD(RHSVD)]*/ () -> {
                      return $this().Builder.CreateElementBitCast($this().GetAddrOfLocalVar(L$PrivateVD), $this().ConvertTypeForMem(L$RHSVD.getType()), 
                          new Twine(/*KEEP_STR*/"rhs.begin"));
                    });
          } else {
            /*const*/ VarDecl /*P*/ OrigVD = cast_VarDecl(cast_DeclRefExpr(IRef).getDecl$Const());
            QualType Type = PrivateVD.getType();
            if (($this().getContext().getAsArrayType(new QualType(Type)) != null)) {
              // Store the address of the original variable associated with the LHS
              // implicit variable.
              DeclRefExpr DRE/*J*/= new DeclRefExpr(((/*const_cast*/VarDecl /*P*/ )(OrigVD)), 
                  $this().CapturedStmtInfo.lookup(OrigVD) != (/*const*/ FieldDecl /*P*/ )null, 
                  IRef.getType(), ExprValueKind.VK_LValue, IRef.getExprLoc());
              Address OriginalAddr = $this().EmitLValue(/*AddrOf*/DRE).getAddress();
              VarDecl L$LHSVD = LHSVD;
              PrivateScope.addPrivate(LHSVD, /*FuncArg*//*[this, &OriginalAddr, =L$LHSVD(LHSVD)]*/ () -> {
                        OriginalAddr.$assignMove($this().Builder.CreateElementBitCast(new Address(OriginalAddr), $this().ConvertTypeForMem(L$LHSVD.getType()), new Twine(/*KEEP_STR*/"lhs.begin")));
                        return new Address(OriginalAddr);
                      });
              boolean IsRegistered = PrivateScope.addPrivate(OrigVD, /*FuncArg*//*[&, &Type, this, &PrivateVD, &OrigVD, &DRD, &IRed, &OriginalAddr]*/ () -> {
                        if (Type.$arrow().isVariablyModifiedType()) {
                          CodeGenFunction.OpaqueValueMapping OpaqueMap = null;
                          try {
                            OpaqueMap/*J*/= new CodeGenFunction.OpaqueValueMapping(/*Deref*/$this(), cast_OpaqueValueExpr($this().getContext().
    getAsVariableArrayType(PrivateVD.getType()).
    getSizeExpr()), 
                                RValue.get($this().getTypeSize(OrigVD.getType().getNonReferenceType())));
                            $this().EmitVariablyModifiedType(new QualType(Type));
                          } finally {
                            if (OpaqueMap != null) { OpaqueMap.$destroy(); }
                          }
                        }
                        AutoVarEmission Emission = $this().EmitAutoVarAlloca($Deref(PrivateVD));
                        Address Addr = Emission.getAllocatedAddress();
                        /*const*/ Expr /*P*/ Init = PrivateVD.getInit$Const();
                        CGStmtOpenMPStatics.EmitOMPAggregateInit(/*Deref*/$this(), new Address(Addr), PrivateVD.getType(), 
                            (DRD != null) ? IRed.$star() : Init, new Address(OriginalAddr));
                        $this().EmitAutoVarCleanups(Emission);
                        return Emission.getAllocatedAddress();
                      });
              assert (IsRegistered) : "private var already registered as private";
              // Silence the warning about unused variable.
              ///*J:(void)*/IsRegistered;
              VarDecl L$PrivateVD = PrivateVD;
              VarDecl L$RHSVD = RHSVD;
              PrivateScope.addPrivate(RHSVD, /*FuncArg*//*[this, =L$PrivateVD(PrivateVD), =L$RHSVD(RHSVD)]*/ () -> {
                        return $this().Builder.CreateElementBitCast($this().GetAddrOfLocalVar(L$PrivateVD), 
                            $this().ConvertTypeForMem(L$RHSVD.getType()), new Twine(/*KEEP_STR*/"rhs.begin"));
                      });
            } else {
              // Store the address of the original variable associated with the LHS
              // implicit variable.
              Address OriginalAddr = Address.invalid();
              VarDecl L$OrigVD = OrigVD;
              Expr L$IRef = IRef;
              PrivateScope.addPrivate(LHSVD, /*FuncArg*//*[this, =L$OrigVD(OrigVD), =L$IRef(IRef), &OriginalAddr]*/ () -> {
                        DeclRefExpr DRE/*J*/= new DeclRefExpr(((/*const_cast*/VarDecl /*P*/ )(L$OrigVD)), 
                            $this().CapturedStmtInfo.lookup(L$OrigVD) != (/*const*/ FieldDecl /*P*/ )null, 
                            L$IRef.getType(), ExprValueKind.VK_LValue, L$IRef.getExprLoc());
                        OriginalAddr.$assignMove($this().EmitLValue($AddrOf(DRE)).getAddress());
                        return new Address(OriginalAddr);
                      });
              // Emit reduction copy.
              VarDecl L$PrivateVD = PrivateVD;
              OMPDeclareReductionDecl L$DRD = DRD;
              Address L$OriginalAddr = OriginalAddr;
              type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>L$IRed = $tryClone(IRed);
              boolean IsRegistered = PrivateScope.addPrivate(OrigVD, /*FuncArg*//*[this, =L$PrivateVD(PrivateVD), =L$OriginalAddr(OriginalAddr), =L$DRD(DRD), =L$IRed(IRed)]*/ () -> {
                        // Emit private VarDecl with reduction init.
                        AutoVarEmission Emission = $this().EmitAutoVarAlloca($Deref(L$PrivateVD));
                        Address Addr = Emission.getAllocatedAddress();
                        if ((L$DRD != null) && ((L$DRD.getInitializer$Const() != null) || !L$PrivateVD.hasInit())) {
                          CGStmtOpenMPStatics.emitInitWithReductionInitializer(/*Deref*/$this(), L$DRD, L$IRed.$star(), new Address(Addr), 
                              new Address(L$OriginalAddr), 
                              L$PrivateVD.getType());
                        } else {
                          $this().EmitAutoVarInit(Emission);
                        }
                        $this().EmitAutoVarCleanups(Emission);
                        return Addr;
                      });
              assert (IsRegistered) : "private var already registered as private";
              // Silence the warning about unused variable.
              ///*J:(void)*/IsRegistered;
              PrivateScope.addPrivate(RHSVD, /*FuncArg*//*[this, =L$PrivateVD(PrivateVD)]*/ () -> {
                        return $this().GetAddrOfLocalVar(L$PrivateVD);
                      });
            }
          }
        }
      }
      ILHS.$preInc();
      IRHS.$preInc();
      IPriv.$preInc();
      IRed.$preInc();
    }
  }
}

/// \brief Emit final update of reduction values to original variables at
/// the end of the directive.
///
/// \param D Directive that has at least one 'reduction' directives.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPReductionClauseFinal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1137,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPReductionClauseFinal", NM="_ZN5clang7CodeGen15CodeGenFunction27EmitOMPReductionClauseFinalERKNS_22OMPExecutableDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction27EmitOMPReductionClauseFinalERKNS_22OMPExecutableDirectiveE")
//</editor-fold>
public final void EmitOMPReductionClauseFinal(final /*const*/ OMPExecutableDirective /*&*/ D) {
  if (!$this().HaveInsertPoint()) {
    return;
  }
  SmallVector</*const*/ Expr /*P*/ > Privates/*J*/= new SmallVector</*const*/ Expr /*P*/ >(8, (/*const*/ Expr /*P*/ )null);
  SmallVector</*const*/ Expr /*P*/ > LHSExprs/*J*/= new SmallVector</*const*/ Expr /*P*/ >(8, (/*const*/ Expr /*P*/ )null);
  SmallVector</*const*/ Expr /*P*/ > RHSExprs/*J*/= new SmallVector</*const*/ Expr /*P*/ >(8, (/*const*/ Expr /*P*/ )null);
  SmallVector</*const*/ Expr /*P*/ > ReductionOps/*J*/= new SmallVector</*const*/ Expr /*P*/ >(8, (/*const*/ Expr /*P*/ )null);
  boolean HasAtLeastOneReduction = false;
  for (/*const*/ OMPReductionClause /*P*/ C : D.<OMPReductionClause>getClausesOfKind(OMPReductionClause.class)) {
    HasAtLeastOneReduction = true;
    Privates.append_T(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.privates$Const().begin()), ((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.privates$Const().end()));
    LHSExprs.append_T(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.lhs_exprs$Const().begin()), ((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.lhs_exprs$Const().end()));
    RHSExprs.append_T(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.rhs_exprs$Const().begin()), ((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.rhs_exprs$Const().end()));
    ReductionOps.append_T(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.reduction_ops$Const().begin()), ((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.reduction_ops$Const().end()));
  }
  if (HasAtLeastOneReduction) {
    // Emit nowait reduction if nowait clause is present or directive is a
    // parallel directive (it always has implicit barrier).
    $this().CGM.getOpenMPRuntime().emitReduction(/*Deref*/$this(), D.getLocEnd(), new ArrayRef</*const*/ Expr /*P*/ >(Privates, true), new ArrayRef</*const*/ Expr /*P*/ >(LHSExprs, true), new ArrayRef</*const*/ Expr /*P*/ >(RHSExprs, true), new ArrayRef</*const*/ Expr /*P*/ >(ReductionOps, true), 
        (D.<OMPNowaitClause>getSingleClause(OMPNowaitClause.class) != null)
           || isOpenMPParallelDirective(D.getDirectiveKind())
           || D.getDirectiveKind() == OpenMPDirectiveKind.OMPD_simd, 
        D.getDirectiveKind() == OpenMPDirectiveKind.OMPD_simd);
  }
}

/// \brief Emit initial code for linear variables. Creates private copies
/// and initializes them with the values according to OpenMP standard.
///
/// \param D Directive (possibly) with the 'linear' clause.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPLinearClauseInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1321,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPLinearClauseInit", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitOMPLinearClauseInitERKNS_16OMPLoopDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitOMPLinearClauseInitERKNS_16OMPLoopDirectiveE")
//</editor-fold>
public final void EmitOMPLinearClauseInit(final /*const*/ OMPLoopDirective /*&*/ D) {
  if (!$this().HaveInsertPoint()) {
    return;
  }
  // Emit inits for the linear variables.
  for (/*const*/ OMPLinearClause /*P*/ C : D.<OMPLinearClause>getClausesOfKind(OMPLinearClause.class)) {
    for (/*const*/ Expr /*P*/ Init : C.inits$Const()) {
      /*const*/ VarDecl /*P*/ VD = cast_VarDecl(cast_DeclRefExpr(Init).getDecl$Const());
      {
        /*const*/ DeclRefExpr /*P*/ Ref = dyn_cast_DeclRefExpr(VD.getInit$Const().IgnoreImpCasts$Const());
        if ((Ref != null)) {
          AutoVarEmission Emission = $this().EmitAutoVarAlloca($Deref(VD));
          /*const*/ VarDecl /*P*/ OrigVD = cast_VarDecl(Ref.getDecl$Const());
          DeclRefExpr DRE/*J*/= new DeclRefExpr(((/*const_cast*/VarDecl /*P*/ )(OrigVD)), 
              $this().CapturedStmtInfo.lookup(OrigVD) != (/*const*/ FieldDecl /*P*/ )null, 
              VD.getInit$Const().getType(), ExprValueKind.VK_LValue, 
              VD.getInit$Const().getExprLoc());
          $this().EmitExprAsInit($AddrOf(DRE), VD, $this().MakeAddrLValue(Emission.getAllocatedAddress(), 
                  VD.getType()), 
              /*capturedByInit=*/ false);
          $this().EmitAutoVarCleanups(Emission);
        } else {
          $this().EmitVarDecl($Deref(VD));
        }
      }
    }
    {
      // Emit the linear steps for the linear clauses.
      // If a step is not constant, it is pre-calculated before the loop.
      /*const*/ org.clang.ast.BinaryOperator /*P*/ CS = cast_or_null_BinaryOperator(C.getCalcStep$Const());
      if ((CS != null)) {
        {
          DeclRefExpr /*P*/ SaveRef = cast_DeclRefExpr(CS.getLHS());
          if ((SaveRef != null)) {
            $this().EmitVarDecl($Deref(cast_VarDecl(SaveRef.getDecl())));
            // Emit calculation of the linear step.
            $this().EmitIgnoredExpr(CS);
          }
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPTaskBasedDirective">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2403,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPTaskBasedDirective", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitOMPTaskBasedDirectiveERKNS_22OMPExecutableDirectiveERKNS0_15RegionCodeGenTyERKN4llvm12function_refIFvRS1_PNS8_5ValueERKNS0_13OMPTaskDataTyEEEERSD_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitOMPTaskBasedDirectiveERKNS_22OMPExecutableDirectiveERKNS0_15RegionCodeGenTyERKN4llvm12function_refIFvRS1_PNS8_5ValueERKNS0_13OMPTaskDataTyEEEERSD_")
//</editor-fold>
public final void EmitOMPTaskBasedDirective(final /*const*/ OMPExecutableDirective /*&*/ S, 
                         final /*const*/ RegionCodeGenTy /*&*/ BodyGen, 
                         final /*const*/CodeGenFunction.ValueOMPTaskDataTy2Void /*&*/ TaskGen, 
                         final OMPTaskDataTy /*&*/ Data) {
  OMPLexicalScope Scope = null;
  try {
    // Emit outlined function for task construct.
    CapturedStmt /*P*/ CS = cast_CapturedStmt(S.getAssociatedStmt());
    type$ptr<ImplicitParamDecl /*P*/ /*const*/ /*P*/> I = $tryClone(CS.getCapturedDecl().param_begin());
    type$ptr<ImplicitParamDecl /*P*/ /*const*/ /*P*/> PartId = $tryClone(std.next(I));
    type$ptr<ImplicitParamDecl /*P*/ /*const*/ /*P*/> TaskT = $tryClone(std.next(I, 4));
    {
      // Check if the task is final
      /*const*/ OMPFinalClause /*P*/ Clause = S.<OMPFinalClause>getSingleClause(OMPFinalClause.class);
      if ((Clause != null)) {
        // If the condition constant folds and can be elided, try to avoid emitting
        // the condition and the dead arm of the if/else.
        Expr /*P*/ Cond = Clause.getCondition();
        bool$ref CondConstant = create_bool$ref();
        if ($this().ConstantFoldsToSimpleInteger(Cond, CondConstant)) {
          Data.Final.setInt(CondConstant.$deref());
        } else {
          Data.Final.setPointer($this().EvaluateExprAsBool(Cond));
        }
      } else {
        // By default the task is not final.
        Data.Final.setInt(/*IntVal=*/ false);
      }
    }
    {
      // Check if the task has 'priority' clause.
      /*const*/ OMPPriorityClause /*P*/ Clause = S.<OMPPriorityClause>getSingleClause(OMPPriorityClause.class);
      if ((Clause != null)) {
        // Runtime currently does not support codegen for priority clause argument.
        // TODO: Add codegen for priority clause arg when runtime lib support it.
        Expr /*P*/ Prio = Clause.getPriority$Const();
        Data.Priority.setInt((Prio != null));
        Data.Priority.setPointer($this().EmitScalarConversion($this().EmitScalarExpr(Prio), Prio.getType(), 
                $this().getContext().getIntTypeForBitwidth(/*DestWidth=*/ 32, /*Signed=*/ 1), 
                Prio.getExprLoc()));
      }
    }
    // The first function argument for tasks is a thread id, the second one is a
    // part id (0 for tied tasks, >=0 for untied task).
    DenseSet</*const*/ VarDecl /*P*/ > EmittedAsPrivate/*J*/= new DenseSet</*const*/ VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info());
    // Get list of private variables.
    for (/*const*/ OMPPrivateClause /*P*/ C : S.<OMPPrivateClause>getClausesOfKind(OMPPrivateClause.class)) {
      type$ptr<Expr/*P*/>/*iterator*/ IRef = $tryClone(C.varlist_begin$Const());
      for (/*const*/ Expr /*P*/ IInit : C.private_copies$Const()) {
        /*const*/ VarDecl /*P*/ OrigVD = cast_VarDecl(cast_DeclRefExpr(IRef.$star()).getDecl$Const());
        if (EmittedAsPrivate.insert(OrigVD.getCanonicalDecl$Const()).second) {
          Data.PrivateVars.push_back(IRef.$star());
          Data.PrivateCopies.push_back(IInit);
        }
        IRef.$preInc();
      }
    }
    EmittedAsPrivate.clear();
    // Get list of firstprivate variables.
    for (/*const*/ OMPFirstprivateClause /*P*/ C : S.<OMPFirstprivateClause>getClausesOfKind(OMPFirstprivateClause.class)) {
      type$ptr<Expr/*P*/>/*iterator*/ IRef = $tryClone(C.varlist_begin$Const());
      type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> IElemInitRef = $tryClone(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.inits$Const().begin()));
      for (/*const*/ Expr /*P*/ IInit : C.private_copies$Const()) {
        /*const*/ VarDecl /*P*/ OrigVD = cast_VarDecl(cast_DeclRefExpr(IRef.$star()).getDecl$Const());
        if (EmittedAsPrivate.insert(OrigVD.getCanonicalDecl$Const()).second) {
          Data.FirstprivateVars.push_back(IRef.$star());
          Data.FirstprivateCopies.push_back(IInit);
          Data.FirstprivateInits.push_back(IElemInitRef.$star());
        }
        IRef.$preInc();
        IElemInitRef.$preInc();
      }
    }
    // Get list of lastprivate variables (for taskloops).
    DenseMap</*const*/ VarDecl /*P*/ , /*const*/ DeclRefExpr /*P*/ > LastprivateDstsOrigs/*J*/= new DenseMap</*const*/ VarDecl /*P*/ , /*const*/ DeclRefExpr /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ DeclRefExpr /*P*/ )null);
    for (/*const*/ OMPLastprivateClause /*P*/ C : S.<OMPLastprivateClause>getClausesOfKind(OMPLastprivateClause.class)) {
      type$ptr<Expr/*P*/>/*iterator*/ IRef = $tryClone(C.varlist_begin$Const());
      type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> ID = $tryClone(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.destination_exprs$Const().begin()));
      for (/*const*/ Expr /*P*/ IInit : C.private_copies$Const()) {
        /*const*/ VarDecl /*P*/ OrigVD = cast_VarDecl(cast_DeclRefExpr(IRef.$star()).getDecl$Const());
        if (EmittedAsPrivate.insert(OrigVD.getCanonicalDecl$Const()).second) {
          Data.LastprivateVars.push_back(IRef.$star());
          Data.LastprivateCopies.push_back(IInit);
        }
        LastprivateDstsOrigs.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrPtr</*const*/ VarDecl /*P*/ , /*const*/ DeclRefExpr /*P*/ >(JD$T$RR_T1$RR.INSTANCE, cast_VarDecl(cast_DeclRefExpr(ID.$star()).getDecl$Const()), 
                cast_DeclRefExpr(IRef.$star()))/* }*/);
        IRef.$preInc();
        ID.$preInc();
      }
    }
    // Build list of dependences.
    for (/*const*/ OMPDependClause /*P*/ C : S.<OMPDependClause>getClausesOfKind(OMPDependClause.class))  {
      for (/*const*/ Expr /*P*/ IRef : C.varlists$Const())  {
        Data.Dependences.push_back(std.make_pair_E_Ptr(C.getDependencyKind(), IRef));
      }
    }
    CapturedStmt L$CS = CS;
    final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[=L$PartId(PartId), &S, &Data, =L$CS(CS), &BodyGen, &LastprivateDstsOrigs]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ Action) -> {
          OMPPrivateScope Scope$1 = null;
          try {
            // Set proper addresses for generated private copies.
            Scope$1/*J*/= new OMPPrivateScope(CGF);
            if (!Data.PrivateVars.empty() || !Data.FirstprivateVars.empty()
               || !Data.LastprivateVars.empty()) {
              LoadInst /*P*/ CopyFn = CGF.Builder.CreateLoad(CGF.GetAddrOfLocalVar(L$CS.getCapturedDecl().getParam(3)));
              LoadInst /*P*/ PrivatesPtr = CGF.Builder.CreateLoad(CGF.GetAddrOfLocalVar(L$CS.getCapturedDecl().getParam(2)));
              // Map privates.
              SmallVector<std.pair</*const*/ VarDecl /*P*/ , Address>> PrivatePtrs/*J*/= new SmallVector<std.pair</*const*/ VarDecl /*P*/ , Address>>(16, new std.pairPtrType</*const*/ VarDecl /*P*/ , Address>(null, new Address()));
              SmallVector<Value /*P*/ > CallArgs/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
              CallArgs.push_back(PrivatesPtr);
              for (/*const*/ Expr /*P*/ E : Data.PrivateVars) {
                /*const*/ VarDecl /*P*/ VD = cast_VarDecl(cast_DeclRefExpr(E).getDecl$Const());
                Address PrivatePtr = CGF.CreateMemTemp(CGF.getContext().getPointerType(E.getType()), new Twine(/*KEEP_STR*/".priv.ptr.addr"));
                PrivatePtrs.push_back(std.make_pair_Ptr_T(VD, $Clone(PrivatePtr)));
                CallArgs.push_back(PrivatePtr.getPointer());
              }
              for (/*const*/ Expr /*P*/ E : Data.FirstprivateVars) {
                /*const*/ VarDecl /*P*/ VD = cast_VarDecl(cast_DeclRefExpr(E).getDecl$Const());
                Address PrivatePtr = CGF.CreateMemTemp(CGF.getContext().getPointerType(E.getType()), 
                    new Twine(/*KEEP_STR*/".firstpriv.ptr.addr"));
                PrivatePtrs.push_back(std.make_pair_Ptr_T(VD, $Clone(PrivatePtr)));
                CallArgs.push_back(PrivatePtr.getPointer());
              }
              for (/*const*/ Expr /*P*/ E : Data.LastprivateVars) {
                /*const*/ VarDecl /*P*/ VD = cast_VarDecl(cast_DeclRefExpr(E).getDecl$Const());
                Address PrivatePtr = CGF.CreateMemTemp(CGF.getContext().getPointerType(E.getType()), 
                    new Twine(/*KEEP_STR*/".lastpriv.ptr.addr"));
                PrivatePtrs.push_back(std.make_pair_Ptr_T(VD, $Clone(PrivatePtr)));
                CallArgs.push_back(PrivatePtr.getPointer());
              }
              CGF.EmitRuntimeCall(CopyFn, new ArrayRef<Value /*P*/ >(CallArgs, true));
              for (final std.pair</*const*/ VarDecl /*P*/ , /*const*/ DeclRefExpr /*P*/ > /*&*/ Pair : LastprivateDstsOrigs) {
                /*const*/ VarDecl /*P*/ OrigVD = cast_VarDecl(Pair.second.getDecl$Const());
                DeclRefExpr DRE/*J*/= new DeclRefExpr(((/*const_cast*/VarDecl /*P*/ )(OrigVD)), 
                    /*RefersToEnclosingVariableOrCapture=*/ CGF.CapturedStmtInfo.lookup(OrigVD) != (/*const*/ FieldDecl /*P*/ )null, 
                    Pair.second.getType(), ExprValueKind.VK_LValue, Pair.second.getExprLoc());
                Scope$1.addPrivate(Pair.first, /*FuncArg*//*[&CGF, &DRE]*/ () -> {
                          return CGF.EmitLValue($AddrOf(DRE)).getAddress();
                        });
              }
              for (final std.pair</*const*/ VarDecl /*P*/ , Address> /*&*/ /*&*/ Pair : PrivatePtrs) {
                Address Replacement/*J*/= new Address(CGF.Builder.CreateLoad(new Address(Pair.second)), 
                    CGF.getContext().getDeclAlign(Pair.first));
                Address L$Replacement = Replacement;
                Scope$1.addPrivate(Pair.first, /*FuncArg*//*[=L$Replacement(Replacement)]*/ () -> {
                          return new Address(L$Replacement);
                        });
              }
            }
            /*J:(void)*/Scope$1.Privatize();
            
            Action.Enter(CGF);
            BodyGen.$call(CGF);
          } finally {
            if (Scope$1 != null) { Scope$1.$destroy(); }
          }
        };
    Value /*P*/ OutlinedFn = $this().CGM.getOpenMPRuntime().emitTaskOutlinedFunction(
            S, I.$star(), PartId.$star(), TaskT.$star(), S.getDirectiveKind(),
            new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen), Data.Tied, 
        Data.NumberOfParts_ref);
    Scope/*J*/= new OMPLexicalScope(/*Deref*/$this(), S);
    TaskGen.$call(/*Deref*/$this(), OutlinedFn, Data);
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPParallelDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1226,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPParallelDirective", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitOMPParallelDirectiveERKNS_20OMPParallelDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitOMPParallelDirectiveERKNS_20OMPParallelDirectiveE")
//</editor-fold>
public final void EmitOMPParallelDirective(final /*const*/ OMPParallelDirective /*&*/ S) {
  // Emit parallel region as a standalone region.
  final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&S]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
        OMPPrivateScope PrivateScope = null;
        try {
          PrivateScope/*J*/= new OMPPrivateScope(CGF);
          boolean Copyins = CGF.EmitOMPCopyinClause(S);
          /*J:(void)*/CGF.EmitOMPFirstprivateClause(S, PrivateScope);
          if (Copyins) {
            // Emit implicit barrier to synchronize threads and avoid data races on
            // propagation master's thread values of threadprivate variables to local
            // instances of that variables of all other implicit threads.
            CGF.CGM.getOpenMPRuntime().emitBarrierCall(CGF, S.getLocStart(), OpenMPDirectiveKind.OMPD_unknown, /*EmitChecks=*/ false, 
                /*ForceSimpleCall=*/ true);
          }
          CGF.EmitOMPPrivateClause(S, PrivateScope);
          CGF.EmitOMPReductionClauseInit(S, PrivateScope);
          /*J:(void)*/PrivateScope.Privatize();
          CGF.EmitStmt(cast_CapturedStmt(S.getAssociatedStmt()).getCapturedStmt());
          CGF.EmitOMPReductionClauseFinal(S);
        } finally {
          if (PrivateScope != null) { PrivateScope.$destroy(); }
        }
      };
  CGStmtOpenMPStatics.emitCommonOMPParallelDirective(/*Deref*/$this(), S, OpenMPDirectiveKind.OMPD_parallel, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen));
  CGStmtOpenMPStatics.emitPostUpdateForReductionClause(/*Deref*/$this(), S, /*FuncArg*//*[]*/ (final CodeGenFunction /*&*/ $Prm0) -> {
            return (Value /*P*/ )null;
          });
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPSimdDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1589,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPSimdDirective", NM="_ZN5clang7CodeGen15CodeGenFunction20EmitOMPSimdDirectiveERKNS_16OMPSimdDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20EmitOMPSimdDirectiveERKNS_16OMPSimdDirectiveE")
//</editor-fold>
public final void EmitOMPSimdDirective(final /*const*/ OMPSimdDirective /*&*/ S) {
  OMPLexicalScope Scope = null;
  try {
    final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&S]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
          OMPLoopScope PreInitScope = null;
          try {
            PreInitScope/*J*/= new OMPLoopScope(CGF, S);
            // if (PreCond) {
            //   for (IV in 0..LastIteration) BODY;
            //   <Final counter/linear vars updates>;
            // }
            //
            
            // Emit: if (PreCond) - begin.
            // If the condition constant folds and can be elided, avoid emitting the
            // whole loop.
            bool$ref CondConstant = create_bool$ref();
            BasicBlock /*P*/ ContBlock = null;
            if (CGF.ConstantFoldsToSimpleInteger(S.getPreCond(), CondConstant)) {
              if (!CondConstant.$deref()) {
                return;
              }
            } else {
              BasicBlock /*P*/ ThenBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"simd.if.then"));
              ContBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"simd.if.end"));
              CGStmtOpenMPStatics.emitPreCond(CGF, S, S.getPreCond(), ThenBlock, ContBlock, 
                  CGF.getProfileCount($AddrOf(S)));
              CGF.EmitBlock(ThenBlock);
              CGF.incrementProfileCounter($AddrOf(S));
            }
            
            // Emit the loop iteration variable.
            /*const*/ Expr /*P*/ IVExpr = S.getIterationVariable();
            /*const*/ VarDecl /*P*/ IVDecl = cast_VarDecl(cast_DeclRefExpr(IVExpr).getDecl$Const());
            CGF.EmitVarDecl($Deref(IVDecl));
            CGF.EmitIgnoredExpr(S.getInit());
            {
              
              // Emit the iterations count variable.
              // If it is not a variable, Sema decided to calculate iterations count on
              // each iteration (e.g., it is foldable into a constant).
              DeclRefExpr /*P*/ LIExpr = dyn_cast_DeclRefExpr(S.getLastIteration());
              if ((LIExpr != null)) {
                CGF.EmitVarDecl($Deref(cast_VarDecl(LIExpr.getDecl())));
                // Emit calculation of the iterations count.
                CGF.EmitIgnoredExpr(S.getCalcLastIteration());
              }
            }
            
            CGF.EmitOMPSimdInit(S);
            
            CGStmtOpenMPStatics.emitAlignedClause(CGF, S);
            CGF.EmitOMPLinearClauseInit(S);
            {
              OMPPrivateScope LoopScope = null;
              try {
                LoopScope/*J*/= new OMPPrivateScope(CGF);
                CGF.EmitOMPPrivateLoopCounters(S, LoopScope);
                CGF.EmitOMPLinearClause(S, LoopScope);
                CGF.EmitOMPPrivateClause(S, LoopScope);
                CGF.EmitOMPReductionClauseInit(S, LoopScope);
                boolean HasLastprivateClause = CGF.EmitOMPLastprivateClauseInit(S, LoopScope);
                /*J:(void)*/LoopScope.Privatize();
                CGF.EmitOMPInnerLoop(S, LoopScope.requiresCleanups(), S.getCond(), 
                    S.getInc(), 
                    /*FuncArg*//*[&S]*/ (final CodeGenFunction /*&*/ CGF$1) -> {
                          CGF$1.EmitOMPLoopBody(S, new JumpDest());
                          CGF$1.EmitStopPoint($AddrOf(S));
                        }, 
                    /*FuncArg*//*[]*/ (final CodeGenFunction /*&*/ $Prm0) -> {
                        });
                CGF.EmitOMPSimdFinal(S, /*FuncArg*//*[]*/ (final CodeGenFunction /*&*/ $Prm0) -> {
                          return (Value /*P*/ )null;
                        });
                // Emit final copy of the lastprivate variables at the end of loops.
                if (HasLastprivateClause) {
                  CGF.EmitOMPLastprivateClauseFinal(S, /*NoFinals=*/ true);
                }
                CGF.EmitOMPReductionClauseFinal(S);
                CGStmtOpenMPStatics.emitPostUpdateForReductionClause(CGF, S, /*FuncArg*//*[]*/ (final CodeGenFunction /*&*/ $Prm0) -> {
                          return (Value /*P*/ )null;
                        });
              } finally {
                if (LoopScope != null) { LoopScope.$destroy(); }
              }
            }
            CGF.EmitOMPLinearClauseFinal(S, /*FuncArg*//*[]*/ (final CodeGenFunction /*&*/ $Prm0) -> {
                      return (Value /*P*/ )null;
                    });
            // Emit: if (PreCond) - end.
            if ((ContBlock != null)) {
              CGF.EmitBranch(ContBlock);
              CGF.EmitBlock(ContBlock, true);
            }
          } finally {
            if (PreInitScope != null) { PreInitScope.$destroy(); }
          }
        };
    Scope/*J*/= new OMPLexicalScope(/*Deref*/$this(), S, /*AsInlined=*/ true);
    $this().CGM.getOpenMPRuntime().emitInlinedDirective(/*Deref*/$this(), OpenMPDirectiveKind.OMPD_simd, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen));
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPForDirective">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2109,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPForDirective", NM="_ZN5clang7CodeGen15CodeGenFunction19EmitOMPForDirectiveERKNS_15OMPForDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19EmitOMPForDirectiveERKNS_15OMPForDirectiveE")
//</editor-fold>
public final void EmitOMPForDirective(final /*const*/ OMPForDirective /*&*/ S) {
  bool$ref HasLastprivates = create_bool$ref(false);
  final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&S, &HasLastprivates]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
        HasLastprivates.$set(CGF.EmitOMPWorksharingLoop(S));
      };
  {
    OMPLexicalScope Scope = null;
    try {
      Scope/*J*/= new OMPLexicalScope(/*Deref*/$this(), S, /*AsInlined=*/ true);
      $this().CGM.getOpenMPRuntime().emitInlinedDirective(/*Deref*/$this(), OpenMPDirectiveKind.OMPD_for, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen), 
          S.hasCancel());
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }
  
  // Emit an implicit barrier at the end.
  if (!(S.<OMPNowaitClause>getSingleClause(OMPNowaitClause.class) != null) || HasLastprivates.$deref()) {
    $this().CGM.getOpenMPRuntime().emitBarrierCall(/*Deref*/$this(), S.getLocStart(), OpenMPDirectiveKind.OMPD_for);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPForSimdDirective">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2127,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPForSimdDirective", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitOMPForSimdDirectiveERKNS_19OMPForSimdDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitOMPForSimdDirectiveERKNS_19OMPForSimdDirectiveE")
//</editor-fold>
public final void EmitOMPForSimdDirective(final /*const*/ OMPForSimdDirective /*&*/ S) {
  bool$ref HasLastprivates = create_bool$ref(false);
  final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&S, &HasLastprivates]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
        HasLastprivates.$set(CGF.EmitOMPWorksharingLoop(S));
      };
  {
    OMPLexicalScope Scope = null;
    try {
      Scope/*J*/= new OMPLexicalScope(/*Deref*/$this(), S, /*AsInlined=*/ true);
      $this().CGM.getOpenMPRuntime().emitInlinedDirective(/*Deref*/$this(), OpenMPDirectiveKind.OMPD_simd, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen));
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }
  
  // Emit an implicit barrier at the end.
  if (!(S.<OMPNowaitClause>getSingleClause(OMPNowaitClause.class) != null) || HasLastprivates.$deref()) {
    $this().CGM.getOpenMPRuntime().emitBarrierCall(/*Deref*/$this(), S.getLocStart(), OpenMPDirectiveKind.OMPD_for);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPSectionsDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2288,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPSectionsDirective", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitOMPSectionsDirectiveERKNS_20OMPSectionsDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitOMPSectionsDirectiveERKNS_20OMPSectionsDirectiveE")
//</editor-fold>
public final void EmitOMPSectionsDirective(final /*const*/ OMPSectionsDirective /*&*/ S) {
  {
    OMPLexicalScope Scope = null;
    try {
      Scope/*J*/= new OMPLexicalScope(/*Deref*/$this(), S, /*AsInlined=*/ true);
      $this().EmitSections(S);
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }
  // Emit an implicit barrier at the end.
  if (!(S.<OMPNowaitClause>getSingleClause(OMPNowaitClause.class) != null)) {
    $this().CGM.getOpenMPRuntime().emitBarrierCall(/*Deref*/$this(), S.getLocStart(), 
        OpenMPDirectiveKind.OMPD_sections);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPSectionDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2300,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPSectionDirective", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitOMPSectionDirectiveERKNS_19OMPSectionDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitOMPSectionDirectiveERKNS_19OMPSectionDirectiveE")
//</editor-fold>
public final void EmitOMPSectionDirective(final /*const*/ OMPSectionDirective /*&*/ S) {
  OMPLexicalScope Scope = null;
  try {
    final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&S]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
          CGF.EmitStmt(cast_CapturedStmt(S.getAssociatedStmt()).getCapturedStmt());
        };
    Scope/*J*/= new OMPLexicalScope(/*Deref*/$this(), S, /*AsInlined=*/ true);
    $this().CGM.getOpenMPRuntime().emitInlinedDirective(/*Deref*/$this(), OpenMPDirectiveKind.OMPD_section, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen), 
        S.hasCancel());
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPSingleDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2309,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPSingleDirective", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitOMPSingleDirectiveERKNS_18OMPSingleDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitOMPSingleDirectiveERKNS_18OMPSingleDirectiveE")
//</editor-fold>
public final void EmitOMPSingleDirective(final /*const*/ OMPSingleDirective /*&*/ S) {
  SmallVector</*const*/ Expr /*P*/ > CopyprivateVars/*J*/= new SmallVector</*const*/ Expr /*P*/ >(8, (/*const*/ Expr /*P*/ )null);
  SmallVector</*const*/ Expr /*P*/ > DestExprs/*J*/= new SmallVector</*const*/ Expr /*P*/ >(8, (/*const*/ Expr /*P*/ )null);
  SmallVector</*const*/ Expr /*P*/ > SrcExprs/*J*/= new SmallVector</*const*/ Expr /*P*/ >(8, (/*const*/ Expr /*P*/ )null);
  SmallVector</*const*/ Expr /*P*/ > AssignmentOps/*J*/= new SmallVector</*const*/ Expr /*P*/ >(8, (/*const*/ Expr /*P*/ )null);
  // Check if there are any 'copyprivate' clauses associated with this
  // 'single' construct.
  // Build a list of copyprivate variables along with helper expressions
  // (<source>, <destination>, <destination>=<source> expressions)
  for (/*const*/ OMPCopyprivateClause /*P*/ C : S.<OMPCopyprivateClause>getClausesOfKind(OMPCopyprivateClause.class)) {
    CopyprivateVars.append_T(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.varlists$Const().begin()), ((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.varlists$Const().end()));
    DestExprs.append_T(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.destination_exprs$Const().begin()), 
        ((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.destination_exprs$Const().end()));
    SrcExprs.append_T(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.source_exprs$Const().begin()), ((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.source_exprs$Const().end()));
    AssignmentOps.append_T(((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.assignment_ops$Const().begin()), 
        ((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)C.assignment_ops$Const().end()));
  }
  // Emit code for 'single' region along with 'copyprivate' clauses
  final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&S]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ Action) -> {
        OMPPrivateScope SingleScope = null;
        try {
          Action.Enter(CGF);
          SingleScope/*J*/= new OMPPrivateScope(CGF);
          /*J:(void)*/CGF.EmitOMPFirstprivateClause(S, SingleScope);
          CGF.EmitOMPPrivateClause(S, SingleScope);
          /*J:(void)*/SingleScope.Privatize();
          CGF.EmitStmt(cast_CapturedStmt(S.getAssociatedStmt()).getCapturedStmt());
        } finally {
          if (SingleScope != null) { SingleScope.$destroy(); }
        }
      };
  {
    OMPLexicalScope Scope = null;
    try {
      Scope/*J*/= new OMPLexicalScope(/*Deref*/$this(), S, /*AsInlined=*/ true);
      $this().CGM.getOpenMPRuntime().emitSingleRegion(/*Deref*/$this(), new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen), S.getLocStart(), 
          new ArrayRef</*const*/ Expr /*P*/ >(CopyprivateVars, true), new ArrayRef</*const*/ Expr /*P*/ >(DestExprs, true), 
          new ArrayRef</*const*/ Expr /*P*/ >(SrcExprs, true), new ArrayRef</*const*/ Expr /*P*/ >(AssignmentOps, true));
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }
  // Emit an implicit barrier at the end (to avoid data race on firstprivate
  // init or if no 'nowait' clause was specified and no 'copyprivate' clause).
  if (!(S.<OMPNowaitClause>getSingleClause(OMPNowaitClause.class) != null) && CopyprivateVars.empty()) {
    $this().CGM.getOpenMPRuntime().emitBarrierCall(/*Deref*/$this(), S.getLocStart(), 
        (S.<OMPNowaitClause>getSingleClause(OMPNowaitClause.class) != null) ? OpenMPDirectiveKind.OMPD_unknown : OpenMPDirectiveKind.OMPD_single);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPMasterDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2350,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPMasterDirective", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitOMPMasterDirectiveERKNS_18OMPMasterDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitOMPMasterDirectiveERKNS_18OMPMasterDirectiveE")
//</editor-fold>
public final void EmitOMPMasterDirective(final /*const*/ OMPMasterDirective /*&*/ S) {
  OMPLexicalScope Scope = null;
  try {
    final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&S]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ Action) -> {
          Action.Enter(CGF);
          CGF.EmitStmt(cast_CapturedStmt(S.getAssociatedStmt()).getCapturedStmt());
        };
    Scope/*J*/= new OMPLexicalScope(/*Deref*/$this(), S, /*AsInlined=*/ true);
    $this().CGM.getOpenMPRuntime().emitMasterRegion(/*Deref*/$this(), new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen), S.getLocStart());
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPCriticalDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2359,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPCriticalDirective", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitOMPCriticalDirectiveERKNS_20OMPCriticalDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitOMPCriticalDirectiveERKNS_20OMPCriticalDirectiveE")
//</editor-fold>
public final void EmitOMPCriticalDirective(final /*const*/ OMPCriticalDirective /*&*/ S) {
  OMPLexicalScope Scope = null;
  try {
    final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&S]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ Action) -> {
          Action.Enter(CGF);
          CGF.EmitStmt(cast_CapturedStmt(S.getAssociatedStmt()).getCapturedStmt());
        };
    Expr /*P*/ Hint = null;
    {
      /*const*/ OMPHintClause /*P*/ HintClause = S.<OMPHintClause>getSingleClause(OMPHintClause.class);
      if ((HintClause != null)) {
        Hint = HintClause.getHint();
      }
    }
    Scope/*J*/= new OMPLexicalScope(/*Deref*/$this(), S, /*AsInlined=*/ true);
    $this().CGM.getOpenMPRuntime().emitCriticalRegion(/*Deref*/$this(), 
        new StringRef(S.getDirectiveName().getAsString()), 
        new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen), S.getLocStart(), Hint);
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPParallelForDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2373,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPParallelForDirective", NM="_ZN5clang7CodeGen15CodeGenFunction27EmitOMPParallelForDirectiveERKNS_23OMPParallelForDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction27EmitOMPParallelForDirectiveERKNS_23OMPParallelForDirectiveE")
//</editor-fold>
public final void EmitOMPParallelForDirective(final /*const*/ OMPParallelForDirective /*&*/ S) {
  // Emit directive as a combined directive that consists of two implicit
  // directives: 'parallel' with 'for' directive.
  final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&S]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
        CGF.EmitOMPWorksharingLoop(S);
      };
  CGStmtOpenMPStatics.emitCommonOMPParallelDirective(/*Deref*/$this(), S, OpenMPDirectiveKind.OMPD_for, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPParallelForSimdDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2383,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPParallelForSimdDirective", NM="_ZN5clang7CodeGen15CodeGenFunction31EmitOMPParallelForSimdDirectiveERKNS_27OMPParallelForSimdDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction31EmitOMPParallelForSimdDirectiveERKNS_27OMPParallelForSimdDirectiveE")
//</editor-fold>
public final void EmitOMPParallelForSimdDirective(final /*const*/ OMPParallelForSimdDirective /*&*/ S) {
  // Emit directive as a combined directive that consists of two implicit
  // directives: 'parallel' with 'for' directive.
  final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&S]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
        CGF.EmitOMPWorksharingLoop(S);
      };
  CGStmtOpenMPStatics.emitCommonOMPParallelDirective(/*Deref*/$this(), S, OpenMPDirectiveKind.OMPD_simd, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPParallelSectionsDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2393,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPParallelSectionsDirective", NM="_ZN5clang7CodeGen15CodeGenFunction32EmitOMPParallelSectionsDirectiveERKNS_28OMPParallelSectionsDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction32EmitOMPParallelSectionsDirectiveERKNS_28OMPParallelSectionsDirectiveE")
//</editor-fold>
public final void EmitOMPParallelSectionsDirective(final /*const*/ OMPParallelSectionsDirective /*&*/ S) {
  // Emit directive as a combined directive that consists of two implicit
  // directives: 'parallel' with 'sections' directive.
  final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&S]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
        CGF.EmitSections(S);
      };
  CGStmtOpenMPStatics.emitCommonOMPParallelDirective(/*Deref*/$this(), S, OpenMPDirectiveKind.OMPD_sections, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPTaskDirective">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2557,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPTaskDirective", NM="_ZN5clang7CodeGen15CodeGenFunction20EmitOMPTaskDirectiveERKNS_16OMPTaskDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20EmitOMPTaskDirectiveERKNS_16OMPTaskDirectiveE")
//</editor-fold>
public final void EmitOMPTaskDirective(final /*const*/ OMPTaskDirective /*&*/ S) {
  OMPTaskDataTy Data = null;
  try {
    // Emit outlined function for task construct.
    CapturedStmt /*P*/ CS = cast_CapturedStmt(S.getAssociatedStmt());
    Address CapturedStruct = $this().GenerateCapturedStmtArgument($Deref(CS));
    QualType SharedsTy = $this().getContext().getRecordType(CS.getCapturedRecordDecl());
    /*const*/ Expr /*P*/ IfCond = null;
    for (/*const*/ OMPIfClause /*P*/ C : S.<OMPIfClause>getClausesOfKind(OMPIfClause.class)) {
      if (C.getNameModifier() == OpenMPDirectiveKind.OMPD_unknown
         || C.getNameModifier() == OpenMPDirectiveKind.OMPD_task) {
        IfCond = C.getCondition();
        break;
      }
    }
    
    Data/*J*/= new OMPTaskDataTy();
    // Check if we should emit tied or untied task.
    Data.Tied = !(S.<OMPUntiedClause>getSingleClause(OMPUntiedClause.class) != null);
    CapturedStmt L$CS = CS;
    final CodeGenFunctionPrePostActionTy2Void BodyGen = /*[=L$CS(CS)]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
          CGF.EmitStmt(L$CS.getCapturedStmt());
        };
    QualType L$SharedsTy = SharedsTy;
    Address L$CapturedStruct = CapturedStruct;
    Expr L$IfCond = IfCond;
    final CodeGenFunction.ValueOMPTaskDataTy2Void/*const*/ TaskGen = /*[&S, =L$SharedsTy(SharedsTy), =L$CapturedStruct(CapturedStruct), =L$IfCond(IfCond)]*/ (final CodeGenFunction /*&*/ CGF, Value /*P*/ OutlinedFn, final /*const*/ OMPTaskDataTy /*&*/ Data$1) -> {
          CGF.CGM.getOpenMPRuntime().emitTaskCall(CGF, S.getLocStart(), S, OutlinedFn, 
              new QualType(L$SharedsTy), new Address(L$CapturedStruct), L$IfCond, 
              Data$1);
        };
    $this().EmitOMPTaskBasedDirective(S, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, BodyGen), /*FuncArg*/TaskGen, Data);
  } finally {
    if (Data != null) { Data.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPTaskyieldDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2587,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPTaskyieldDirective", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitOMPTaskyieldDirectiveERKNS_21OMPTaskyieldDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitOMPTaskyieldDirectiveERKNS_21OMPTaskyieldDirectiveE")
//</editor-fold>
public final void EmitOMPTaskyieldDirective(final /*const*/ OMPTaskyieldDirective /*&*/ S) {
  $this().CGM.getOpenMPRuntime().emitTaskyieldCall(/*Deref*/$this(), S.getLocStart());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPBarrierDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2592,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPBarrierDirective", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitOMPBarrierDirectiveERKNS_19OMPBarrierDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitOMPBarrierDirectiveERKNS_19OMPBarrierDirectiveE")
//</editor-fold>
public final void EmitOMPBarrierDirective(final /*const*/ OMPBarrierDirective /*&*/ S) {
  $this().CGM.getOpenMPRuntime().emitBarrierCall(/*Deref*/$this(), S.getLocStart(), OpenMPDirectiveKind.OMPD_barrier);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPTaskwaitDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2596,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPTaskwaitDirective", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitOMPTaskwaitDirectiveERKNS_20OMPTaskwaitDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitOMPTaskwaitDirectiveERKNS_20OMPTaskwaitDirectiveE")
//</editor-fold>
public final void EmitOMPTaskwaitDirective(final /*const*/ OMPTaskwaitDirective /*&*/ S) {
  $this().CGM.getOpenMPRuntime().emitTaskwaitCall(/*Deref*/$this(), S.getLocStart());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPTaskgroupDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2600,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPTaskgroupDirective", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitOMPTaskgroupDirectiveERKNS_21OMPTaskgroupDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitOMPTaskgroupDirectiveERKNS_21OMPTaskgroupDirectiveE")
//</editor-fold>
public final void EmitOMPTaskgroupDirective(final /*const*/ OMPTaskgroupDirective /*&*/ S) {
  OMPLexicalScope Scope = null;
  try {
    final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&S]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ Action) -> {
          Action.Enter(CGF);
          CGF.EmitStmt(cast_CapturedStmt(S.getAssociatedStmt()).getCapturedStmt());
        };
    Scope/*J*/= new OMPLexicalScope(/*Deref*/$this(), S, /*AsInlined=*/ true);
    $this().CGM.getOpenMPRuntime().emitTaskgroupRegion(/*Deref*/$this(), new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen), S.getLocStart());
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPFlushDirective">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2610,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPFlushDirective", NM="_ZN5clang7CodeGen15CodeGenFunction21EmitOMPFlushDirectiveERKNS_17OMPFlushDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21EmitOMPFlushDirectiveERKNS_17OMPFlushDirectiveE")
//</editor-fold>
public final void EmitOMPFlushDirective(final /*const*/ OMPFlushDirective /*&*/ S) {
  Void2ArrayRef<Expr> callable = () -> {
            {
              /*const*/ OMPFlushClause /*P*/ FlushClause = S.<OMPFlushClause>getSingleClause(OMPFlushClause.class);
              if ((FlushClause != null)) {
                return llvm.makeArrayRef(FlushClause.varlist_begin$Const(), 
                    FlushClause.varlist_end$Const());
              }
            }
            return new ArrayRef</*const*/ Expr /*P*/ >(llvm.None, true);
          };
  $this().CGM.getOpenMPRuntime().emitFlush(/*Deref*/$this(), callable.$call(), S.getLocStart());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPOrderedDirective">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2756,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPOrderedDirective", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitOMPOrderedDirectiveERKNS_19OMPOrderedDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitOMPOrderedDirectiveERKNS_19OMPOrderedDirectiveE")
//</editor-fold>
public final void EmitOMPOrderedDirective(final /*const*/ OMPOrderedDirective /*&*/ S) {
  OMPLexicalScope Scope = null;
  try {
    if (!(S.getAssociatedStmt() != null)) {
      for (/*const*/ OMPDependClause /*P*/ DC : S.<OMPDependClause>getClausesOfKind(OMPDependClause.class))  {
        $this().CGM.getOpenMPRuntime().emitDoacrossOrdered(/*Deref*/$this(), DC);
      }
      return;
    }
    /*const*/ OMPSIMDClause /*P*/ C = S.<OMPSIMDClause>getSingleClause(OMPSIMDClause.class);
    OMPSIMDClause L$C = C;
    final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&S, =L$C(C), this]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ Action) -> {
          if ((L$C != null)) {
            CapturedStmt /*P*/ CS = cast_CapturedStmt(S.getAssociatedStmt());
            SmallVector<Value /*P*/ > CapturedVars/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
            CGF.GenerateOpenMPCapturedVars($Deref(CS), CapturedVars);
            Function /*P*/ OutlinedFn = CGStmtOpenMPStatics.emitOutlinedOrderedFunction($this().CGM, CS);
            CGF.EmitNounwindRuntimeCall(OutlinedFn, new ArrayRef<Value /*P*/ >(CapturedVars, true));
          } else {
            Action.Enter(CGF);
            CGF.EmitStmt(cast_CapturedStmt(S.getAssociatedStmt()).getCapturedStmt());
          }
        };
    Scope/*J*/= new OMPLexicalScope(/*Deref*/$this(), S, /*AsInlined=*/ true);
    $this().CGM.getOpenMPRuntime().emitOrderedRegion(/*Deref*/$this(), new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen), S.getLocStart(), !(C != null));
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPAtomicDirective">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3207,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPAtomicDirective", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitOMPAtomicDirectiveERKNS_18OMPAtomicDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitOMPAtomicDirectiveERKNS_18OMPAtomicDirectiveE")
//</editor-fold>
public final void EmitOMPAtomicDirective(final /*const*/ OMPAtomicDirective /*&*/ S) {
  OMPLexicalScope Scope = null;
  try {
    boolean IsSeqCst = (S.<OMPSeqCstClause>getSingleClause(OMPSeqCstClause.class) != null);
    OpenMPClauseKind Kind = OpenMPClauseKind.OMPC_unknown;
    for (OMPClause /*P*/ C : S.clauses$Const()) {
      // Find first clause (skip seq_cst clause, if it is first).
      if (C.getClauseKind() != OpenMPClauseKind.OMPC_seq_cst) {
        Kind = C.getClauseKind();
        break;
      }
    }
    
    /*const*/ Stmt /*P*/ CS = S.getAssociatedStmt().IgnoreContainers(/*IgnoreCaptured=*/ true);
    {
      /*const*/ ExprWithCleanups /*P*/ EWC = dyn_cast_ExprWithCleanups(CS);
      if ((EWC != null)) {
        $this().enterFullExpression(EWC);
      }
    }
    {
      // Processing for statements under 'atomic capture'.
      /*const*/ CompoundStmt /*P*/ Compound = dyn_cast_CompoundStmt(CS);
      if ((Compound != null)) {
        for (/*const*/ Stmt /*P*/ C : Compound.body$Const()) {
          {
            /*const*/ ExprWithCleanups /*P*/ EWC = dyn_cast_ExprWithCleanups(C);
            if ((EWC != null)) {
              $this().enterFullExpression(EWC);
            }
          }
        }
      }
    }
    
    Stmt L$CS = CS;
    OpenMPClauseKind L$Kind = Kind;
    boolean L$IsSeqCst = IsSeqCst;
    final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&S, =L$Kind(Kind), =L$IsSeqCst(IsSeqCst), =L$CS(CS)]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
          CGF.EmitStopPoint(L$CS);
          CGStmtOpenMPStatics.EmitOMPAtomicExpr(CGF, L$Kind, L$IsSeqCst, S.isPostfixUpdate(), S.getX$Const(), 
              S.getV$Const(), S.getExpr$Const(), S.getUpdateExpr$Const(), 
              S.isXLHSInRHSPart(), S.getLocStart());
        };
    Scope/*J*/= new OMPLexicalScope(/*Deref*/$this(), S, /*AsInlined=*/ true);
    $this().CGM.getOpenMPRuntime().emitInlinedDirective(/*Deref*/$this(), OpenMPDirectiveKind.OMPD_atomic, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen));
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPTargetDirective">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3264,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPTargetDirective", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitOMPTargetDirectiveERKNS_18OMPTargetDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitOMPTargetDirectiveERKNS_18OMPTargetDirectiveE")
//</editor-fold>
public final void EmitOMPTargetDirective(final /*const*/ OMPTargetDirective /*&*/ S) {
  OMPLexicalScope Scope = null;
  try {
    final /*const*/ CapturedStmt /*&*/ CS = $Deref(cast_CapturedStmt(S.getAssociatedStmt()));
    
    SmallVector<Value /*P*/ > CapturedVars/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
    $this().GenerateOpenMPCapturedVars(CS, CapturedVars);
    
    Function /*P*/ Fn = null;
    Constant /*P*/ FnID = null;
    
    // Check if we have any if clause associated with the directive.
    /*const*/ Expr /*P*/ IfCond = null;
    {
      
      /*const*/ OMPIfClause /*P*/ C = S.<OMPIfClause>getSingleClause(OMPIfClause.class);
      if ((C != null)) {
        IfCond = C.getCondition();
      }
    }
    
    // Check if we have any device clause associated with the directive.
    /*const*/ Expr /*P*/ Device = null;
    {
      /*const*/ OMPDeviceClause /*P*/ C = S.<OMPDeviceClause>getSingleClause(OMPDeviceClause.class);
      if ((C != null)) {
        Device = C.getDevice$Const();
      }
    }
    
    // Check if we have an if clause whose conditional always evaluates to false
    // or if we do not have any targets specified. If so the target region is not
    // an offload entry point.
    boolean IsOffloadEntry = true;
    if ((IfCond != null)) {
      bool$ref Val = create_bool$ref();
      if ($this().ConstantFoldsToSimpleInteger(IfCond, Val) && !Val.$deref()) {
        IsOffloadEntry = false;
      }
    }
    if ($this().CGM.getLangOpts().OMPTargetTriples.empty()) {
      IsOffloadEntry = false;
    }
    assert (($this().CurFuncDecl != null)) : "No parent declaration for target region!";
    StringRef ParentName/*J*/= new StringRef();
    {
      // In case we have Ctors/Dtors we use the complete type variant to produce
      // the mangling of the device outlined kernel.
      /*const*/ CXXConstructorDecl /*P*/ D = dyn_cast_CXXConstructorDecl($this().CurFuncDecl);
      if ((D != null)) {
        ParentName.$assignMove($this().CGM.getMangledName(new GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, D, CXXCtorType.Ctor_Complete)));
      } else {
        /*const*/ CXXDestructorDecl /*P*/ D$1 = dyn_cast_CXXDestructorDecl($this().CurFuncDecl);
        if ((D$1 != null)) {
          ParentName.$assignMove($this().CGM.getMangledName(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, D$1, CXXDtorType.Dtor_Complete)));
        } else {
          ParentName.$assignMove(
              $this().CGM.getMangledName(new GlobalDecl(cast_FunctionDecl($this().CurFuncDecl)))
          );
        }
      }
    }
    
    std.tie(Fn, FnID).$assign(EmitOMPTargetDirectiveOutlinedFunction($this().CGM, S, new StringRef(ParentName), IsOffloadEntry));
    Scope/*J*/= new OMPLexicalScope(/*Deref*/$this(), S);
    $this().CGM.getOpenMPRuntime().emitTargetCall(/*Deref*/$this(), S, Fn, FnID, IfCond, Device, 
        new ArrayRef<Value /*P*/ >(CapturedVars, true));
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}


// Generate the instructions for '#pragma omp target data' directive.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPTargetDataDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3385,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPTargetDataDirective", NM="_ZN5clang7CodeGen15CodeGenFunction26EmitOMPTargetDataDirectiveERKNS_22OMPTargetDataDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26EmitOMPTargetDataDirectiveERKNS_22OMPTargetDataDirectiveE")
//</editor-fold>
public final void EmitOMPTargetDataDirective(final /*const*/ OMPTargetDataDirective /*&*/ S) {
  // The target data enclosed region is implemented just by emitting the
  // statement.
  final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&S]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
        CGF.EmitStmt(cast_CapturedStmt(S.getAssociatedStmt()).getCapturedStmt());
      };
  
  // If we don't have target devices, don't bother emitting the data mapping
  // code.
  if ($this().CGM.getLangOpts().OMPTargetTriples.empty()) {
    OMPLexicalScope Scope = null;
    try {
      Scope/*J*/= new OMPLexicalScope(/*Deref*/$this(), S, /*AsInlined=*/ true);
      
      $this().CGM.getOpenMPRuntime().emitInlinedDirective(/*Deref*/$this(), OpenMPDirectiveKind.OMPD_target_data, 
          new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen));
      return;
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }
  
  // Check if we have any if clause associated with the directive.
  /*const*/ Expr /*P*/ IfCond = null;
  {
    /*const*/ OMPIfClause /*P*/ C = S.<OMPIfClause>getSingleClause(OMPIfClause.class);
    if ((C != null)) {
      IfCond = C.getCondition();
    }
  }
  
  // Check if we have any device clause associated with the directive.
  /*const*/ Expr /*P*/ Device = null;
  {
    /*const*/ OMPDeviceClause /*P*/ C = S.<OMPDeviceClause>getSingleClause(OMPDeviceClause.class);
    if ((C != null)) {
      Device = C.getDevice$Const();
    }
  }
  
  $this().CGM.getOpenMPRuntime().emitTargetDataCalls(/*Deref*/$this(), S, IfCond, Device, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPTargetEnterDataDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3416,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPTargetEnterDataDirective", NM="_ZN5clang7CodeGen15CodeGenFunction31EmitOMPTargetEnterDataDirectiveERKNS_27OMPTargetEnterDataDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction31EmitOMPTargetEnterDataDirectiveERKNS_27OMPTargetEnterDataDirectiveE")
//</editor-fold>
public final void EmitOMPTargetEnterDataDirective(final /*const*/ OMPTargetEnterDataDirective /*&*/ S) {
  // If we don't have target devices, don't bother emitting the data mapping
  // code.
  if ($this().CGM.getLangOpts().OMPTargetTriples.empty()) {
    return;
  }
  
  // Check if we have any if clause associated with the directive.
  /*const*/ Expr /*P*/ IfCond = null;
  {
    /*const*/ OMPIfClause /*P*/ C = S.<OMPIfClause>getSingleClause(OMPIfClause.class);
    if ((C != null)) {
      IfCond = C.getCondition();
    }
  }
  
  // Check if we have any device clause associated with the directive.
  /*const*/ Expr /*P*/ Device = null;
  {
    /*const*/ OMPDeviceClause /*P*/ C = S.<OMPDeviceClause>getSingleClause(OMPDeviceClause.class);
    if ((C != null)) {
      Device = C.getDevice$Const();
    }
  }
  
  $this().CGM.getOpenMPRuntime().emitTargetDataStandAloneCall(/*Deref*/$this(), S, IfCond, Device);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPTargetExitDataDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3436,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPTargetExitDataDirective", NM="_ZN5clang7CodeGen15CodeGenFunction30EmitOMPTargetExitDataDirectiveERKNS_26OMPTargetExitDataDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction30EmitOMPTargetExitDataDirectiveERKNS_26OMPTargetExitDataDirectiveE")
//</editor-fold>
public final void EmitOMPTargetExitDataDirective(final /*const*/ OMPTargetExitDataDirective /*&*/ S) {
  // If we don't have target devices, don't bother emitting the data mapping
  // code.
  if ($this().CGM.getLangOpts().OMPTargetTriples.empty()) {
    return;
  }
  
  // Check if we have any if clause associated with the directive.
  /*const*/ Expr /*P*/ IfCond = null;
  {
    /*const*/ OMPIfClause /*P*/ C = S.<OMPIfClause>getSingleClause(OMPIfClause.class);
    if ((C != null)) {
      IfCond = C.getCondition();
    }
  }
  
  // Check if we have any device clause associated with the directive.
  /*const*/ Expr /*P*/ Device = null;
  {
    /*const*/ OMPDeviceClause /*P*/ C = S.<OMPDeviceClause>getSingleClause(OMPDeviceClause.class);
    if ((C != null)) {
      Device = C.getDevice$Const();
    }
  }
  
  $this().CGM.getOpenMPRuntime().emitTargetDataStandAloneCall(/*Deref*/$this(), S, IfCond, Device);
}


// Generate the instructions for '#pragma omp target update' directive.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPTargetUpdateDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3613,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPTargetUpdateDirective", NM="_ZN5clang7CodeGen15CodeGenFunction28EmitOMPTargetUpdateDirectiveERKNS_24OMPTargetUpdateDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28EmitOMPTargetUpdateDirectiveERKNS_24OMPTargetUpdateDirectiveE")
//</editor-fold>
public final void EmitOMPTargetUpdateDirective(final /*const*/ OMPTargetUpdateDirective /*&*/ S) {
  // If we don't have target devices, don't bother emitting the data mapping
  // code.
  if ($this().CGM.getLangOpts().OMPTargetTriples.empty()) {
    return;
  }
  
  // Check if we have any if clause associated with the directive.
  /*const*/ Expr /*P*/ IfCond = null;
  {
    /*const*/ OMPIfClause /*P*/ C = S.<OMPIfClause>getSingleClause(OMPIfClause.class);
    if ((C != null)) {
      IfCond = C.getCondition();
    }
  }
  
  // Check if we have any device clause associated with the directive.
  /*const*/ Expr /*P*/ Device = null;
  {
    /*const*/ OMPDeviceClause /*P*/ C = S.<OMPDeviceClause>getSingleClause(OMPDeviceClause.class);
    if ((C != null)) {
      Device = C.getDevice$Const();
    }
  }
  
  $this().CGM.getOpenMPRuntime().emitTargetDataStandAloneCall(/*Deref*/$this(), S, IfCond, Device);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPTargetParallelDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3456,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPTargetParallelDirective", NM="_ZN5clang7CodeGen15CodeGenFunction30EmitOMPTargetParallelDirectiveERKNS_26OMPTargetParallelDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction30EmitOMPTargetParallelDirectiveERKNS_26OMPTargetParallelDirectiveE")
//</editor-fold>
public final void EmitOMPTargetParallelDirective(final /*const*/ OMPTargetParallelDirective /*&*/ S) {
  // TODO: codegen for target parallel.
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPTargetParallelForDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3461,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPTargetParallelForDirective", NM="_ZN5clang7CodeGen15CodeGenFunction33EmitOMPTargetParallelForDirectiveERKNS_29OMPTargetParallelForDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction33EmitOMPTargetParallelForDirectiveERKNS_29OMPTargetParallelForDirectiveE")
//</editor-fold>
public final void EmitOMPTargetParallelForDirective(final /*const*/ OMPTargetParallelForDirective /*&*/ S) {
  // TODO: codegen for target parallel for.
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPTeamsDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3344,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPTeamsDirective", NM="_ZN5clang7CodeGen15CodeGenFunction21EmitOMPTeamsDirectiveERKNS_17OMPTeamsDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21EmitOMPTeamsDirectiveERKNS_17OMPTeamsDirectiveE")
//</editor-fold>
public final void EmitOMPTeamsDirective(final /*const*/ OMPTeamsDirective /*&*/ S) {
  // Emit parallel region as a standalone region.
  final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&S]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
        OMPPrivateScope PrivateScope = null;
        try {
          PrivateScope/*J*/= new OMPPrivateScope(CGF);
          /*J:(void)*/CGF.EmitOMPFirstprivateClause(S, PrivateScope);
          CGF.EmitOMPPrivateClause(S, PrivateScope);
          /*J:(void)*/PrivateScope.Privatize();
          CGF.EmitStmt(cast_CapturedStmt(S.getAssociatedStmt()).getCapturedStmt());
        } finally {
          if (PrivateScope != null) { PrivateScope.$destroy(); }
        }
      };
  CGStmtOpenMPStatics.emitCommonOMPTeamsDirective(/*Deref*/$this(), S, OpenMPDirectiveKind.OMPD_teams, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPCancellationPointDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3356,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPCancellationPointDirective", NM="_ZN5clang7CodeGen15CodeGenFunction33EmitOMPCancellationPointDirectiveERKNS_29OMPCancellationPointDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction33EmitOMPCancellationPointDirectiveERKNS_29OMPCancellationPointDirectiveE")
//</editor-fold>
public final void EmitOMPCancellationPointDirective(final /*const*/ OMPCancellationPointDirective /*&*/ S) {
  $this().CGM.getOpenMPRuntime().emitCancellationPointCall(/*Deref*/$this(), S.getLocStart(), 
      S.getCancelRegion());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPCancelDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3362,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPCancelDirective", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitOMPCancelDirectiveERKNS_18OMPCancelDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitOMPCancelDirectiveERKNS_18OMPCancelDirectiveE")
//</editor-fold>
public final void EmitOMPCancelDirective(final /*const*/ OMPCancelDirective /*&*/ S) {
  /*const*/ Expr /*P*/ IfCond = null;
  for (/*const*/ OMPIfClause /*P*/ C : S.<OMPIfClause>getClausesOfKind(OMPIfClause.class)) {
    if (C.getNameModifier() == OpenMPDirectiveKind.OMPD_unknown
       || C.getNameModifier() == OpenMPDirectiveKind.OMPD_cancel) {
      IfCond = C.getCondition();
      break;
    }
  }
  $this().CGM.getOpenMPRuntime().emitCancelCall(/*Deref*/$this(), S.getLocStart(), IfCond, 
      S.getCancelRegion());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPTaskLoopBasedDirective">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3475,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPTaskLoopBasedDirective", NM="_ZN5clang7CodeGen15CodeGenFunction29EmitOMPTaskLoopBasedDirectiveERKNS_16OMPLoopDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction29EmitOMPTaskLoopBasedDirectiveERKNS_16OMPLoopDirectiveE")
//</editor-fold>
public final void EmitOMPTaskLoopBasedDirective(final /*const*/ OMPLoopDirective /*&*/ S) {
  OMPTaskDataTy Data = null;
  try {
    assert (isOpenMPTaskLoopDirective(S.getDirectiveKind()));
    // Emit outlined function for task construct.
    CapturedStmt /*P*/ CS = cast_CapturedStmt(S.getAssociatedStmt());
    Address CapturedStruct = $this().GenerateCapturedStmtArgument($Deref(CS));
    QualType SharedsTy = $this().getContext().getRecordType(CS.getCapturedRecordDecl());
    /*const*/ Expr /*P*/ IfCond = null;
    for (/*const*/ OMPIfClause /*P*/ C : S.<OMPIfClause>getClausesOfKind(OMPIfClause.class)) {
      if (C.getNameModifier() == OpenMPDirectiveKind.OMPD_unknown
         || C.getNameModifier() == OpenMPDirectiveKind.OMPD_taskloop) {
        IfCond = C.getCondition();
        break;
      }
    }
    
    Data/*J*/= new OMPTaskDataTy();
    // Check if taskloop must be emitted without taskgroup.
    Data.Nogroup = (S.<OMPNogroupClause>getSingleClause(OMPNogroupClause.class) != null);
    // TODO: Check if we should emit tied or untied task.
    Data.Tied = true;
    {
      // Set scheduling for taskloop
      /*const*/ OMPGrainsizeClause /*P*/ Clause = S.<OMPGrainsizeClause>getSingleClause(OMPGrainsizeClause.class);
      if ((Clause != null)) {
        // grainsize clause
        Data.Schedule.setInt(/*IntVal=*/ false);
        Data.Schedule.setPointer($this().EmitScalarExpr(Clause.getGrainsize()));
      } else {
        /*const*/ OMPNumTasksClause /*P*/ Clause$1 = S.<OMPNumTasksClause>getSingleClause(OMPNumTasksClause.class);
        if ((Clause$1 != null)) {
          // num_tasks clause
          Data.Schedule.setInt(/*IntVal=*/ true);
          Data.Schedule.setPointer($this().EmitScalarExpr(Clause$1.getNumTasks()));
        }
      }
    }
    
    CapturedStmt L$CS = CS;
    final CodeGenFunctionPrePostActionTy2Void BodyGen = /*[=L$CS(CS), &S]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
          OMPLoopScope PreInitScope = null;
          OMPPrivateScope LoopScope = null;
          try {
            // if (PreCond) {
            //   for (IV in 0..LastIteration) BODY;
            //   <Final counter/linear vars updates>;
            // }
            //
            
            // Emit: if (PreCond) - begin.
            // If the condition constant folds and can be elided, avoid emitting the
            // whole loop.
            bool$ref CondConstant = create_bool$ref();
            BasicBlock /*P*/ ContBlock = null;
            PreInitScope/*J*/= new OMPLoopScope(CGF, S);
            if (CGF.ConstantFoldsToSimpleInteger(S.getPreCond(), CondConstant)) {
              if (!CondConstant.$deref()) {
                return;
              }
            } else {
              BasicBlock /*P*/ ThenBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"taskloop.if.then"));
              ContBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"taskloop.if.end"));
              CGStmtOpenMPStatics.emitPreCond(CGF, S, S.getPreCond(), ThenBlock, ContBlock, 
                  CGF.getProfileCount($AddrOf(S)));
              CGF.EmitBlock(ThenBlock);
              CGF.incrementProfileCounter($AddrOf(S));
            }
            if (isOpenMPSimdDirective(S.getDirectiveKind())) {
              CGF.EmitOMPSimdInit(S);
            }
            
            LoopScope/*J*/= new OMPPrivateScope(CGF);
            // Emit helper vars inits.
            /*enum ANONYMOUS_INT_CONSTANTS {*/
              final /*uint*/int LowerBound = 5;
              final /*uint*/int UpperBound = LowerBound + 1;
              final /*uint*/int Stride = UpperBound + 1;
              final /*uint*/int LastIter = Stride + 1;
            /*}*/;
            type$ptr<ImplicitParamDecl /*P*/ /*const*/ /*P*/> I = $tryClone(L$CS.getCapturedDecl().param_begin());
            type$ptr<ImplicitParamDecl /*P*/ /*const*/ /*P*/> LBP = $tryClone(std.next(I, LowerBound));
            type$ptr<ImplicitParamDecl /*P*/ /*const*/ /*P*/> UBP = $tryClone(std.next(I, UpperBound));
            type$ptr<ImplicitParamDecl /*P*/ /*const*/ /*P*/> STP = $tryClone(std.next(I, Stride));
            type$ptr<ImplicitParamDecl /*P*/ /*const*/ /*P*/> LIP = $tryClone(std.next(I, LastIter));
            CGStmtOpenMPStatics.mapParam(CGF, cast_DeclRefExpr(S.getLowerBoundVariable()), LBP.$star(), 
                LoopScope);
            CGStmtOpenMPStatics.mapParam(CGF, cast_DeclRefExpr(S.getUpperBoundVariable()), UBP.$star(), 
                LoopScope);
            CGStmtOpenMPStatics.mapParam(CGF, cast_DeclRefExpr(S.getStrideVariable()), STP.$star(), LoopScope);
            CGStmtOpenMPStatics.mapParam(CGF, cast_DeclRefExpr(S.getIsLastIterVariable()), LIP.$star(), 
                LoopScope);
            CGF.EmitOMPPrivateLoopCounters(S, LoopScope);
            boolean HasLastprivateClause = CGF.EmitOMPLastprivateClauseInit(S, LoopScope);
            /*J:(void)*/LoopScope.Privatize();
            // Emit the loop iteration variable.
            /*const*/ Expr /*P*/ IVExpr = S.getIterationVariable();
            /*const*/ VarDecl /*P*/ IVDecl = cast_VarDecl(cast_DeclRefExpr(IVExpr).getDecl$Const());
            CGF.EmitVarDecl($Deref(IVDecl));
            CGF.EmitIgnoredExpr(S.getInit());
            {
              
              // Emit the iterations count variable.
              // If it is not a variable, Sema decided to calculate iterations count on
              // each iteration (e.g., it is foldable into a constant).
              DeclRefExpr /*P*/ LIExpr = dyn_cast_DeclRefExpr(S.getLastIteration());
              if ((LIExpr != null)) {
                CGF.EmitVarDecl($Deref(cast_VarDecl(LIExpr.getDecl())));
                // Emit calculation of the iterations count.
                CGF.EmitIgnoredExpr(S.getCalcLastIteration());
              }
            }
            
            CGF.EmitOMPInnerLoop(S, LoopScope.requiresCleanups(), S.getCond(), 
                S.getInc(), 
                /*FuncArg*//*[&S]*/ (final CodeGenFunction /*&*/ CGF$1) -> {
                      CGF$1.EmitOMPLoopBody(S, new JumpDest());
                      CGF$1.EmitStopPoint($AddrOf(S));
                    }, 
                /*FuncArg*//*[]*/ (final CodeGenFunction /*&*/ $Prm0) -> {
                    });
            // Emit: if (PreCond) - end.
            if ((ContBlock != null)) {
              CGF.EmitBranch(ContBlock);
              CGF.EmitBlock(ContBlock, true);
            }
            // Emit final copy of the lastprivate variables if IsLastIter != 0.
            if (HasLastprivateClause) {
              CGF.EmitOMPLastprivateClauseFinal(S, isOpenMPSimdDirective(S.getDirectiveKind()), 
                  CGF.Builder.CreateIsNotNull(CGF.EmitLoadOfScalar(CGF.GetAddrOfLocalVar(LIP.$star()), /*Volatile=*/ false, 
                          (LIP.$star()).getType(), S.getLocStart())));
            }
          } finally {
            if (LoopScope != null) { LoopScope.$destroy(); }
            if (PreInitScope != null) { PreInitScope.$destroy(); }
          }
        };
    QualType L$SharedsTy = SharedsTy;
    Address L$CapturedStruct = CapturedStruct;
    Expr L$IfCond = IfCond;
    final CodeGenFunction.ValueOMPTaskDataTy2Void/*const*/ TaskGen = /*[&S, =L$SharedsTy(SharedsTy), =L$CapturedStruct(CapturedStruct), =L$IfCond(IfCond)]*/ (final CodeGenFunction /*&*/ CGF, Value /*P*/ OutlinedFn, final /*const*/ OMPTaskDataTy /*&*/ Data$1) -> {
          final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&, &S, &OutlinedFn, &SharedsTy, &CapturedStruct, &IfCond, &Data]*/ (final CodeGenFunction /*&*/ CGF$1, final PrePostActionTy /*&*/ $Prm1) -> {
                OMPLoopScope PreInitScope = null;
                try {
                  PreInitScope/*J*/= new OMPLoopScope(CGF$1, S);
                  CGF$1.CGM.getOpenMPRuntime().emitTaskLoopCall(CGF$1, S.getLocStart(), S, 
                      OutlinedFn, new QualType(L$SharedsTy), 
                      new Address(L$CapturedStruct), L$IfCond, Data$1);
                } finally {
                  if (PreInitScope != null) { PreInitScope.$destroy(); }
                }
              };
          CGF.CGM.getOpenMPRuntime().emitInlinedDirective(CGF, OpenMPDirectiveKind.OMPD_taskloop, 
              new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen));
        };
    $this().EmitOMPTaskBasedDirective(S, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, BodyGen), /*FuncArg*/TaskGen, Data);
  } finally {
    if (Data != null) { Data.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPTaskLoopDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3603,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPTaskLoopDirective", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitOMPTaskLoopDirectiveERKNS_20OMPTaskLoopDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitOMPTaskLoopDirectiveERKNS_20OMPTaskLoopDirectiveE")
//</editor-fold>
public final void EmitOMPTaskLoopDirective(final /*const*/ OMPTaskLoopDirective /*&*/ S) {
  $this().EmitOMPTaskLoopBasedDirective(S);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPTaskLoopSimdDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3607,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPTaskLoopSimdDirective", NM="_ZN5clang7CodeGen15CodeGenFunction28EmitOMPTaskLoopSimdDirectiveERKNS_24OMPTaskLoopSimdDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28EmitOMPTaskLoopSimdDirectiveERKNS_24OMPTaskLoopSimdDirectiveE")
//</editor-fold>
public final void EmitOMPTaskLoopSimdDirective(final /*const*/ OMPTaskLoopSimdDirective /*&*/ S) {
  $this().EmitOMPTaskLoopBasedDirective(S);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPDistributeDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2736,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPDistributeDirective", NM="_ZN5clang7CodeGen15CodeGenFunction26EmitOMPDistributeDirectiveERKNS_22OMPDistributeDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26EmitOMPDistributeDirectiveERKNS_22OMPDistributeDirectiveE")
//</editor-fold>
public final void EmitOMPDistributeDirective(final /*const*/ OMPDistributeDirective /*&*/ S) {
  OMPLexicalScope Scope = null;
  try {
    final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&S]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
          CGF.EmitOMPDistributeLoop(S);
        };
    Scope/*J*/= new OMPLexicalScope(/*Deref*/$this(), S, /*AsInlined=*/ true);
    $this().CGM.getOpenMPRuntime().emitInlinedDirective(/*Deref*/$this(), OpenMPDirectiveKind.OMPD_distribute, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen), 
        false);
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPDistributeLoop">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2620,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPDistributeLoop", NM="_ZN5clang7CodeGen15CodeGenFunction21EmitOMPDistributeLoopERKNS_22OMPDistributeDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21EmitOMPDistributeLoopERKNS_22OMPDistributeDirectiveE")
//</editor-fold>
public final void EmitOMPDistributeLoop(final /*const*/ OMPDistributeDirective /*&*/ S) {
  // Emit the loop iteration variable.
  DeclRefExpr /*P*/ IVExpr = cast_DeclRefExpr(S.getIterationVariable());
  VarDecl /*P*/ IVDecl = cast_VarDecl(IVExpr.getDecl());
  $this().EmitVarDecl($Deref(IVDecl));
  {
    
    // Emit the iterations count variable.
    // If it is not a variable, Sema decided to calculate iterations count on each
    // iteration (e.g., it is foldable into a constant).
    DeclRefExpr /*P*/ LIExpr = dyn_cast_DeclRefExpr(S.getLastIteration());
    if ((LIExpr != null)) {
      $this().EmitVarDecl($Deref(cast_VarDecl(LIExpr.getDecl())));
      // Emit calculation of the iterations count.
      $this().EmitIgnoredExpr(S.getCalcLastIteration());
    }
  }
  
  final CGOpenMPRuntime /*&*/ RT = $this().CGM.getOpenMPRuntime();
  {
    OMPLoopScope PreInitScope = null;
    try {
      PreInitScope/*J*/= new OMPLoopScope(/*Deref*/$this(), S);
      // Skip the entire loop if we don't meet the precondition.
      // If the condition constant folds and can be elided, avoid emitting the
      // whole loop.
      bool$ref CondConstant = create_bool$ref();
      BasicBlock /*P*/ ContBlock = null;
      if ($this().ConstantFoldsToSimpleInteger(S.getPreCond(), CondConstant)) {
        if (!CondConstant.$deref()) {
          return;
        }
      } else {
        BasicBlock /*P*/ ThenBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"omp.precond.then"));
        ContBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"omp.precond.end"));
        CGStmtOpenMPStatics.emitPreCond(/*Deref*/$this(), S, S.getPreCond(), ThenBlock, ContBlock, 
            $this().getProfileCount($AddrOf(S)));
        $this().EmitBlock(ThenBlock);
        $this().incrementProfileCounter($AddrOf(S));
      }
      {
        OMPPrivateScope LoopScope = null;
        try {
          // Emit helper vars inits.
          LValue LB = CGStmtOpenMPStatics.EmitOMPHelperVar(/*Deref*/$this(), cast_DeclRefExpr(S.getLowerBoundVariable()));
          LValue UB = CGStmtOpenMPStatics.EmitOMPHelperVar(/*Deref*/$this(), cast_DeclRefExpr(S.getUpperBoundVariable()));
          LValue ST = CGStmtOpenMPStatics.EmitOMPHelperVar(/*Deref*/$this(), cast_DeclRefExpr(S.getStrideVariable()));
          LValue IL = CGStmtOpenMPStatics.EmitOMPHelperVar(/*Deref*/$this(), cast_DeclRefExpr(S.getIsLastIterVariable()));
          
          LoopScope/*J*/= new OMPPrivateScope(/*Deref*/$this());
          $this().EmitOMPPrivateLoopCounters(S, LoopScope);
          /*J:(void)*/LoopScope.Privatize();
          
          // Detect the distribute schedule kind and chunk.
          Value /*P*/ Chunk = null;
          /*OpenMPDistScheduleClauseKind*/int ScheduleKind = OpenMPDistScheduleClauseKind.OMPC_DIST_SCHEDULE_unknown;
          {
            /*const*/ OMPDistScheduleClause /*P*/ C = S.<OMPDistScheduleClause>getSingleClause(OMPDistScheduleClause.class);
            if ((C != null)) {
              ScheduleKind = C.getDistScheduleKind();
              {
                /*const*/ Expr /*P*/ Ch = C.getChunkSize$Const();
                if ((Ch != null)) {
                  Chunk = $this().EmitScalarExpr(Ch);
                  Chunk = $this().EmitScalarConversion(Chunk, Ch.getType(), 
                      S.getIterationVariable().getType(), 
                      S.getLocStart());
                }
              }
            }
          }
          /*const*//*uint*/int IVSize = $ulong2uint($this().getContext().getTypeSize(IVExpr.getType()));
          /*const*/boolean IVSigned = IVExpr.getType().$arrow().hasSignedIntegerRepresentation();
          
          // OpenMP [2.10.8, distribute Construct, Description]
          // If dist_schedule is specified, kind must be static. If specified,
          // iterations are divided into chunks of size chunk_size, chunks are
          // assigned to the teams of the league in a round-robin fashion in the
          // order of the team number. When no chunk_size is specified, the
          // iteration space is divided into chunks that are approximately equal
          // in size, and at most one chunk is distributed to each team of the
          // league. The size of the chunks is unspecified in this case.
          if (RT.isStaticNonchunked_OpenMPDistScheduleClauseKind_bool(ScheduleKind, 
              /* Chunked */ Chunk != (Value /*P*/ )null)) {
            RT.emitDistributeStaticInit(/*Deref*/$this(), S.getLocStart(), ScheduleKind, 
                IVSize, IVSigned, /* Ordered = */ false, 
                IL.getAddress(), LB.getAddress(), 
                UB.getAddress(), ST.getAddress());
            JumpDest LoopExit = $this().getJumpDestInCurrentScope($this().createBasicBlock(new Twine(/*KEEP_STR*/"omp.loop.exit")));
            // UB = min(UB, GlobalUB);
            $this().EmitIgnoredExpr(S.getEnsureUpperBound());
            // IV = LB;
            $this().EmitIgnoredExpr(S.getInit());
            // while (idx <= UB) { BODY; ++idx; }
            JumpDest L$LoopExit = LoopExit;
            $this().EmitOMPInnerLoop(S, LoopScope.requiresCleanups(), S.getCond(), 
                S.getInc(), 
                /*FuncArg*//*[&S, =L$LoopExit(LoopExit)]*/ (final CodeGenFunction /*&*/ CGF) -> {
                      CGF.EmitOMPLoopBody(S, new JumpDest(L$LoopExit));
                      CGF.EmitStopPoint($AddrOf(S));
                    }, 
                /*FuncArg*//*[]*/ (final CodeGenFunction /*&*/ $Prm0) -> {
                    });
            $this().EmitBlock(LoopExit.getBlock());
            // Tell the runtime we are done.
            RT.emitForStaticFinish(/*Deref*/$this(), S.getLocStart());
          } else {
            // Emit the outer loop, which requests its work chunk [LB..UB] from
            // runtime and runs the inner loop to process it.
            $this().EmitOMPDistributeOuterLoop(ScheduleKind, S, LoopScope, 
                LB.getAddress(), UB.getAddress(), ST.getAddress(), 
                IL.getAddress(), Chunk);
          }
        } finally {
          if (LoopScope != null) { LoopScope.$destroy(); }
        }
      }
      
      // We're now done with the loop, so jump to the continuation block.
      if ((ContBlock != null)) {
        $this().EmitBranch(ContBlock);
        $this().EmitBlock(ContBlock, true);
      }
    } finally {
      if (PreInitScope != null) { PreInitScope.$destroy(); }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPDistributeParallelForDirective">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1868,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPDistributeParallelForDirective", NM="_ZN5clang7CodeGen15CodeGenFunction37EmitOMPDistributeParallelForDirectiveERKNS_33OMPDistributeParallelForDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction37EmitOMPDistributeParallelForDirectiveERKNS_33OMPDistributeParallelForDirectiveE")
//</editor-fold>
public final void EmitOMPDistributeParallelForDirective(final /*const*/ OMPDistributeParallelForDirective /*&*/ S) {
  OMPLexicalScope Scope = null;
  try {
    Scope/*J*/= new OMPLexicalScope(/*Deref*/$this(), S, /*AsInlined=*/ true);
    CodeGenFunctionPrePostActionTy2Void callable = /*[&S]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
                  OMPLoopScope PreInitScope = null;
                  try {
                    PreInitScope/*J*/= new OMPLoopScope(CGF, S);
                    CGF.EmitStmt(cast_CapturedStmt(S.getAssociatedStmt()).getCapturedStmt());
                  } finally {
                    if (PreInitScope != null) { PreInitScope.$destroy(); }
                  }
                };
    $this().CGM.getOpenMPRuntime().emitInlinedDirective(/*Deref*/$this(), OpenMPDirectiveKind.OMPD_distribute_parallel_for, 
        new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, callable));
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPDistributeParallelForSimdDirective">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1880,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPDistributeParallelForSimdDirective", NM="_ZN5clang7CodeGen15CodeGenFunction41EmitOMPDistributeParallelForSimdDirectiveERKNS_37OMPDistributeParallelForSimdDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction41EmitOMPDistributeParallelForSimdDirectiveERKNS_37OMPDistributeParallelForSimdDirectiveE")
//</editor-fold>
public final void EmitOMPDistributeParallelForSimdDirective(final /*const*/ OMPDistributeParallelForSimdDirective /*&*/ S) {
  OMPLexicalScope Scope = null;
  try {
    Scope/*J*/= new OMPLexicalScope(/*Deref*/$this(), S, /*AsInlined=*/ true);
    CodeGenFunctionPrePostActionTy2Void callable = /*[&S]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
                  OMPLoopScope PreInitScope = null;
                  try {
                    PreInitScope/*J*/= new OMPLoopScope(CGF, S);
                    CGF.EmitStmt(cast_CapturedStmt(S.getAssociatedStmt()).getCapturedStmt());
                  } finally {
                    if (PreInitScope != null) { PreInitScope.$destroy(); }
                  }
                };
    $this().CGM.getOpenMPRuntime().emitInlinedDirective(/*Deref*/$this(), OpenMPDirectiveKind.OMPD_distribute_parallel_for_simd, 
        new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, callable));
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPDistributeSimdDirective">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1892,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPDistributeSimdDirective", NM="_ZN5clang7CodeGen15CodeGenFunction30EmitOMPDistributeSimdDirectiveERKNS_26OMPDistributeSimdDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction30EmitOMPDistributeSimdDirectiveERKNS_26OMPDistributeSimdDirectiveE")
//</editor-fold>
public final void EmitOMPDistributeSimdDirective(final /*const*/ OMPDistributeSimdDirective /*&*/ S) {
  OMPLexicalScope Scope = null;
  try {
    Scope/*J*/= new OMPLexicalScope(/*Deref*/$this(), S, /*AsInlined=*/ true);
    CodeGenFunctionPrePostActionTy2Void callable = /*[&S]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
                  OMPLoopScope PreInitScope = null;
                  try {
                    PreInitScope/*J*/= new OMPLoopScope(CGF, S);
                    CGF.EmitStmt(cast_CapturedStmt(S.getAssociatedStmt()).getCapturedStmt());
                  } finally {
                    if (PreInitScope != null) { PreInitScope.$destroy(); }
                  }
                };
    $this().CGM.getOpenMPRuntime().emitInlinedDirective(/*Deref*/$this(), OpenMPDirectiveKind.OMPD_distribute_simd, 
        new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, callable));
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPTargetParallelForSimdDirective">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1904,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPTargetParallelForSimdDirective", NM="_ZN5clang7CodeGen15CodeGenFunction37EmitOMPTargetParallelForSimdDirectiveERKNS_33OMPTargetParallelForSimdDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction37EmitOMPTargetParallelForSimdDirectiveERKNS_33OMPTargetParallelForSimdDirectiveE")
//</editor-fold>
public final void EmitOMPTargetParallelForSimdDirective(final /*const*/ OMPTargetParallelForSimdDirective /*&*/ S) {
  OMPLexicalScope Scope = null;
  try {
    Scope/*J*/= new OMPLexicalScope(/*Deref*/$this(), S, /*AsInlined=*/ true);
    CodeGenFunctionPrePostActionTy2Void callable = /*[&S]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
                  OMPLoopScope PreInitScope = null;
                  try {
                    PreInitScope/*J*/= new OMPLoopScope(CGF, S);
                    CGF.EmitStmt(cast_CapturedStmt(S.getAssociatedStmt()).getCapturedStmt());
                  } finally {
                    if (PreInitScope != null) { PreInitScope.$destroy(); }
                  }
                };
    $this().CGM.getOpenMPRuntime().emitInlinedDirective(/*Deref*/$this(), OpenMPDirectiveKind.OMPD_target_parallel_for_simd, 
        new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, callable));
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}


/// Emit outlined function for the target directive.
/*OutlinedFn*/
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPTargetDirectiveOutlinedFunction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3243,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPTargetDirectiveOutlinedFunction", NM="_ZN5clang7CodeGen15CodeGenFunction38EmitOMPTargetDirectiveOutlinedFunctionERNS0_13CodeGenModuleERKNS_18OMPTargetDirectiveEN4llvm9StringRefEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction38EmitOMPTargetDirectiveOutlinedFunctionERNS0_13CodeGenModuleERKNS_18OMPTargetDirectiveEN4llvm9StringRefEb")
//</editor-fold>
public static std.pair<Function /*P*/ , Constant /*P*/ > EmitOMPTargetDirectiveOutlinedFunction(final CodeGenModule /*&*/ CGM, final /*const*/ OMPTargetDirective /*&*/ S, StringRef ParentName, 
                                      boolean IsOffloadEntry) {
  type$ref<Function /*P*/ > OutlinedFn = create_type$null$ref(null);
  type$ref<Constant /*P*/ > OutlinedFnID = create_type$null$ref(null);
  final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&S]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ Action) -> {
        OMPPrivateScope PrivateScope = null;
        try {
          PrivateScope/*J*/= new OMPPrivateScope(CGF);
          /*J:(void)*/CGF.EmitOMPFirstprivateClause(S, PrivateScope);
          CGF.EmitOMPPrivateClause(S, PrivateScope);
          /*J:(void)*/PrivateScope.Privatize();
          
          Action.Enter(CGF);
          CGF.EmitStmt(cast_CapturedStmt(S.getAssociatedStmt()).getCapturedStmt());
        } finally {
          if (PrivateScope != null) { PrivateScope.$destroy(); }
        }
      };
  // Emit target region as a standalone region.
  CGM.getOpenMPRuntime().emitTargetOutlinedFunction(S, new StringRef(ParentName), OutlinedFn, OutlinedFnID, IsOffloadEntry, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen));
  return std.make_pair_Ptr_Ptr(OutlinedFn.$deref(), OutlinedFnID.$deref());
}

/// \brief Emit inner loop of the worksharing/simd construct.
///
/// \param S Directive, for which the inner loop must be emitted.
/// \param RequiresCleanup true, if directive has some associated private
/// variables.
/// \param LoopCond Bollean condition for loop continuation.
/// \param IncExpr Increment expression for loop control variable.
/// \param BodyGen Generator for the inner body of the inner loop.
/// \param PostIncGen Genrator for post-increment code (required for ordered
/// loop directvies).
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPInnerLoop">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1274,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPInnerLoop", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitOMPInnerLoopERKNS_4StmtEbPKNS_4ExprES7_RKN4llvm12function_refIFvRS1_EEESE_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitOMPInnerLoopERKNS_4StmtEbPKNS_4ExprES7_RKN4llvm12function_refIFvRS1_EEESE_")
//</editor-fold>
public final void EmitOMPInnerLoop(final /*const*/ Stmt /*&*/ S, boolean RequiresCleanup, /*const*/ Expr /*P*/ LoopCond, 
                /*const*/ Expr /*P*/ IncExpr, 
                final /*const*/CodeGenFunction.GenFun /*&*/ BodyGen, 
                final /*const*/CodeGenFunction.GenFun /*&*/ PostIncGen) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    JumpDest LoopExit = $this().getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"omp.inner.for.end"));
    
    // Start the loop with a block that tests the condition.
    BasicBlock /*P*/ CondBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"omp.inner.for.cond"));
    $this().EmitBlock(CondBlock);
    $this().LoopStack.push(CondBlock, $c$.track(new DebugLoc($this().Builder.getCurrentDebugLocation()))); $c$.clean();
    
    // If there are any cleanups between here and the loop-exit scope,
    // create a block to stage a loop exit along.
    BasicBlock /*P*/ ExitBlock = LoopExit.getBlock();
    if (RequiresCleanup) {
      ExitBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"omp.inner.for.cond.cleanup"));
    }
    
    BasicBlock /*P*/ LoopBody = $this().createBasicBlock(new Twine(/*KEEP_STR*/"omp.inner.for.body"));
    
    // Emit condition.
    $this().EmitBranchOnBoolExpr(LoopCond, LoopBody, ExitBlock, $this().getProfileCount($AddrOf(S)));
    if (ExitBlock != LoopExit.getBlock()) {
      $this().EmitBlock(ExitBlock);
      $this().EmitBranchThroughCleanup(new JumpDest(LoopExit));
    }
    
    $this().EmitBlock(LoopBody);
    $this().incrementProfileCounter($AddrOf(S));
    
    // Create a block for the increment.
    JumpDest Continue = $this().getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"omp.inner.for.inc"));
    $this().BreakContinueStack.push_back(new BreakContinue(new JumpDest(LoopExit), new JumpDest(Continue)));
    
    BodyGen.$call(/*Deref*/$this());
    
    // Emit "IV = IV + 1" and a back-edge to the condition block.
    $this().EmitBlock(Continue.getBlock());
    $this().EmitIgnoredExpr(IncExpr);
    PostIncGen.$call(/*Deref*/$this());
    $this().BreakContinueStack.pop_back();
    $this().EmitBranch(CondBlock);
    $this().LoopStack.pop();
    // Emit the fall-through block.
    $this().EmitBlock(LoopExit.getBlock());
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getOMPCancelDestination">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 3375,
 FQN="clang::CodeGen::CodeGenFunction::getOMPCancelDestination", NM="_ZN5clang7CodeGen15CodeGenFunction23getOMPCancelDestinationENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23getOMPCancelDestinationENS_19OpenMPDirectiveKindE")
//</editor-fold>
public final CodeGenFunction.JumpDest getOMPCancelDestination(OpenMPDirectiveKind Kind) {
  if (Kind == OpenMPDirectiveKind.OMPD_parallel || Kind == OpenMPDirectiveKind.OMPD_task) {
    return new CodeGenFunction.JumpDest($this().ReturnBlock);
  }
  assert (Kind == OpenMPDirectiveKind.OMPD_for || Kind == OpenMPDirectiveKind.OMPD_section || Kind == OpenMPDirectiveKind.OMPD_sections || Kind == OpenMPDirectiveKind.OMPD_parallel_sections || Kind == OpenMPDirectiveKind.OMPD_parallel_for);
  return new CodeGenFunction.JumpDest($this().BreakContinueStack.back().BreakBlock);
}

/// Emit initial code for loop counters of loop-based directives.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPPrivateLoopCounters">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1424,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPPrivateLoopCounters", NM="_ZN5clang7CodeGen15CodeGenFunction26EmitOMPPrivateLoopCountersERKNS_16OMPLoopDirectiveERNS1_15OMPPrivateScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26EmitOMPPrivateLoopCountersERKNS_16OMPLoopDirectiveERNS1_15OMPPrivateScopeE")
//</editor-fold>
public final void EmitOMPPrivateLoopCounters(final /*const*/ OMPLoopDirective /*&*/ S, final CodeGenFunction.OMPPrivateScope /*&*/ LoopScope) {
  if (!$this().HaveInsertPoint()) {
    return;
  }
  type$ptr<Expr /*P*/ /*const*/ /*P*/> I = $tryClone(S.private_counters$Const().begin());
  for (Expr /*P*/ E : S.counters$Const()) {
    VarDecl /*P*/ VD = cast_VarDecl(cast_DeclRefExpr(E).getDecl());
    VarDecl /*P*/ PrivateVD = cast_VarDecl(cast_DeclRefExpr(I.$star()).getDecl());
    /*J:(void)*/LoopScope.addPrivate(VD, /*FuncArg*//*[&, this, &PrivateVD, &I]*/ () -> {
              // Emit var without initialization.
              if (!($this().LocalDeclMap.count(PrivateVD) != 0)) {
                AutoVarEmission VarEmission = $this().EmitAutoVarAlloca($Deref(PrivateVD));
                $this().EmitAutoVarCleanups(VarEmission);
              }
              DeclRefExpr DRE/*J*/= new DeclRefExpr(((/*const_cast*/VarDecl /*P*/ )(PrivateVD)), 
                  /*RefersToEnclosingVariableOrCapture=*/ false, 
                  (I.$star()).getType(), ExprValueKind.VK_LValue, (I.$star()).getExprLoc());
              return $this().EmitLValue($AddrOf(DRE)).getAddress();
            });
    if (($this().LocalDeclMap.count(VD) != 0) || ($this().CapturedStmtInfo.lookup(VD) != null)
       || VD.hasGlobalStorage()) {
      /*J:(void)*/LoopScope.addPrivate(PrivateVD, /*FuncArg*//*[&, &VD, this, &E]*/ () -> {
                DeclRefExpr DRE/*J*/= new DeclRefExpr(((/*const_cast*/VarDecl /*P*/ )(VD)), 
                    ($this().LocalDeclMap.count(VD) != 0) || ($this().CapturedStmtInfo.lookup(VD) != null), 
                    E.getType(), ExprValueKind.VK_LValue, E.getExprLoc());
                return $this().EmitLValue($AddrOf(DRE)).getAddress();
              });
    }
    I.$preInc();
  }
}

/// Helpers for the OpenMP loop directives.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPLoopBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1251,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPLoopBody", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitOMPLoopBodyERKNS_16OMPLoopDirectiveENS1_8JumpDestE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitOMPLoopBodyERKNS_16OMPLoopDirectiveENS1_8JumpDestE")
//</editor-fold>
protected/*private*/ final void EmitOMPLoopBody(final /*const*/ OMPLoopDirective /*&*/ D, 
               JumpDest LoopExit) {
  RunCleanupsScope BodyScope = null;
  try {
    BodyScope/*J*/= new RunCleanupsScope(/*Deref*/$this());
    // Update counters values on current iteration.
    for (Expr /*P*/ I : D.updates$Const()) {
      $this().EmitIgnoredExpr(I);
    }
    // Update the linear variables.
    for (/*const*/ OMPLinearClause /*P*/ C : D.<OMPLinearClause>getClausesOfKind(OMPLinearClause.class)) {
      for (/*const*/ Expr /*P*/ U : C.updates$Const())  {
        $this().EmitIgnoredExpr(U);
      }
    }
    
    // On a continue in the body, jump to the end.
    JumpDest Continue = $this().getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"omp.body.continue"));
    $this().BreakContinueStack.push_back(new BreakContinue(new JumpDest(LoopExit), new JumpDest(Continue)));
    // Emit loop body.
    $this().EmitStmt(D.getBody());
    // The end (updates/cleanups).
    $this().EmitBlock(Continue.getBlock());
    $this().BreakContinueStack.pop_back();
  } finally {
    if (BodyScope != null) { BodyScope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPSimdInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1535,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPSimdInit", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitOMPSimdInitERKNS_16OMPLoopDirectiveEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitOMPSimdInitERKNS_16OMPLoopDirectiveEb")
//</editor-fold>
protected/*private*/ final void EmitOMPSimdInit(final /*const*/ OMPLoopDirective /*&*/ D) {
  EmitOMPSimdInit(D, 
               false);
}
protected/*private*/ final void EmitOMPSimdInit(final /*const*/ OMPLoopDirective /*&*/ D, 
               boolean IsMonotonic/*= false*/) {
  // Walk clauses and process safelen/lastprivate.
  $this().LoopStack.setParallel(!IsMonotonic);
  $this().LoopStack.setVectorizeEnable(true);
  CGStmtOpenMPStatics.emitSimdlenSafelenClause(/*Deref*/$this(), D, IsMonotonic);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPSimdFinal">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1543,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPSimdFinal", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitOMPSimdFinalERKNS_16OMPLoopDirectiveERKN4llvm12function_refIFPNS5_5ValueERS1_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitOMPSimdFinalERKNS_16OMPLoopDirectiveERKN4llvm12function_refIFPNS5_5ValueERS1_EEE")
//</editor-fold>
protected/*private*/ final void EmitOMPSimdFinal(final /*const*/ OMPLoopDirective /*&*/ D, 
                final /*const*/CodeGenFunction.ValueProducer /*&*/ CondGen) {
  if (!$this().HaveInsertPoint()) {
    return;
  }
  BasicBlock /*P*/ DoneBB = null;
  type$ptr<Expr /*P*/ /*const*/ /*P*/> IC = $tryClone(D.counters$Const().begin());
  type$ptr<Expr /*P*/ /*const*/ /*P*/> IPC = $tryClone(D.private_counters$Const().begin());
  for (Expr /*P*/ F : D.finals$Const()) {
    VarDecl /*P*/ OrigVD = cast_VarDecl(cast_DeclRefExpr((IC.$star())).getDecl());
    VarDecl /*P*/ PrivateVD = cast_VarDecl(cast_DeclRefExpr((IPC.$star())).getDecl());
    OMPCapturedExprDecl /*P*/ CED = dyn_cast_OMPCapturedExprDecl(OrigVD);
    if (($this().LocalDeclMap.count(OrigVD) != 0) || ($this().CapturedStmtInfo.lookup(OrigVD) != null)
       || OrigVD.hasGlobalStorage() || (CED != null)) {
      OMPPrivateScope VarScope = null;
      try {
        if (!(DoneBB != null)) {
          {
            Value /*P*/ Cond = CondGen.$call(/*Deref*/$this());
            if ((Cond != null)) {
              // If the first post-update expression is found, emit conditional
              // block if it was requested.
              BasicBlock /*P*/ ThenBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/".omp.final.then"));
              DoneBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/".omp.final.done"));
              $this().Builder.CreateCondBr(Cond, ThenBB, DoneBB);
              $this().EmitBlock(ThenBB);
            }
          }
        }
        Address OrigAddr = Address.invalid();
        if ((CED != null)) {
          OrigAddr.$assignMove($this().EmitLValue(CED.getInit().IgnoreImpCasts()).getAddress());
        } else {
          DeclRefExpr DRE/*J*/= new DeclRefExpr(((/*const_cast*/VarDecl /*P*/ )(PrivateVD)), 
              /*RefersToEnclosingVariableOrCapture=*/ false, 
              (IPC.$star()).getType(), ExprValueKind.VK_LValue, (IPC.$star()).getExprLoc());
          OrigAddr.$assignMove($this().EmitLValue($AddrOf(DRE)).getAddress());
        }
        VarScope/*J*/= new OMPPrivateScope(/*Deref*/$this());
        Address L$OrigAddr = OrigAddr;
        VarScope.addPrivate(OrigVD, 
            /*FuncArg*//*[=L$OrigAddr(OrigAddr)]*/ () -> {
                  return new Address(L$OrigAddr);
                });
        /*J:(void)*/VarScope.Privatize();
        $this().EmitIgnoredExpr(F);
      } finally {
        if (VarScope != null) { VarScope.$destroy(); }
      }
    }
    IC.$preInc();
    IPC.$preInc();
  }
  if ((DoneBB != null)) {
    $this().EmitBlock(DoneBB, /*IsFinished=*/ true);
  }
}

/// \brief Emit code for the worksharing loop-based directive.
/// \return true, if this construct has any lastprivate clause, false -
/// otherwise.
// namespace
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPWorksharingLoop">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1936,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPWorksharingLoop", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitOMPWorksharingLoopERKNS_16OMPLoopDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitOMPWorksharingLoopERKNS_16OMPLoopDirectiveE")
//</editor-fold>
protected/*private*/ final boolean EmitOMPWorksharingLoop(final /*const*/ OMPLoopDirective /*&*/ S) {
  // Emit the loop iteration variable.
  DeclRefExpr /*P*/ IVExpr = cast_DeclRefExpr(S.getIterationVariable());
  VarDecl /*P*/ IVDecl = cast_VarDecl(IVExpr.getDecl());
  $this().EmitVarDecl($Deref(IVDecl));
  {
    
    // Emit the iterations count variable.
    // If it is not a variable, Sema decided to calculate iterations count on each
    // iteration (e.g., it is foldable into a constant).
    DeclRefExpr /*P*/ LIExpr = dyn_cast_DeclRefExpr(S.getLastIteration());
    if ((LIExpr != null)) {
      $this().EmitVarDecl($Deref(cast_VarDecl(LIExpr.getDecl())));
      // Emit calculation of the iterations count.
      $this().EmitIgnoredExpr(S.getCalcLastIteration());
    }
  }
  
  final CGOpenMPRuntime /*&*/ RT = $this().CGM.getOpenMPRuntime();
  
  boolean HasLastprivateClause;
  {
    OMPLoopScope PreInitScope = null;
    try {
      PreInitScope/*J*/= new OMPLoopScope(/*Deref*/$this(), S);
      // Skip the entire loop if we don't meet the precondition.
      // If the condition constant folds and can be elided, avoid emitting the
      // whole loop.
      bool$ref CondConstant = create_bool$ref();
      BasicBlock /*P*/ ContBlock = null;
      if ($this().ConstantFoldsToSimpleInteger(S.getPreCond(), CondConstant)) {
        if (!CondConstant.$deref()) {
          return false;
        }
      } else {
        BasicBlock /*P*/ ThenBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"omp.precond.then"));
        ContBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"omp.precond.end"));
        CGStmtOpenMPStatics.emitPreCond(/*Deref*/$this(), S, S.getPreCond(), ThenBlock, ContBlock, 
            $this().getProfileCount($AddrOf(S)));
        $this().EmitBlock(ThenBlock);
        $this().incrementProfileCounter($AddrOf(S));
      }
      
      boolean Ordered = false;
      {
        /*const*/ OMPOrderedClause /*P*/ OrderedClause = S.<OMPOrderedClause>getSingleClause(OMPOrderedClause.class);
        if ((OrderedClause != null)) {
          if ((OrderedClause.getNumForLoops() != null)) {
            RT.emitDoacrossInit(/*Deref*/$this(), S);
          } else {
            Ordered = true;
          }
        }
      }
      
      DenseSet</*const*/ Expr /*P*/ > EmittedFinals/*J*/= new DenseSet</*const*/ Expr /*P*/ >(DenseMapInfo$LikePtr.$Info());
      CGStmtOpenMPStatics.emitAlignedClause(/*Deref*/$this(), S);
      $this().EmitOMPLinearClauseInit(S);
      // Emit helper vars inits.
      LValue LB = CGStmtOpenMPStatics.EmitOMPHelperVar(/*Deref*/$this(), cast_DeclRefExpr(S.getLowerBoundVariable()));
      LValue UB = CGStmtOpenMPStatics.EmitOMPHelperVar(/*Deref*/$this(), cast_DeclRefExpr(S.getUpperBoundVariable()));
      LValue ST = CGStmtOpenMPStatics.EmitOMPHelperVar(/*Deref*/$this(), cast_DeclRefExpr(S.getStrideVariable()));
      LValue IL = CGStmtOpenMPStatics.EmitOMPHelperVar(/*Deref*/$this(), cast_DeclRefExpr(S.getIsLastIterVariable()));
      {
        OMPPrivateScope LoopScope = null;
        try {
          LoopScope/*J*/= new OMPPrivateScope(/*Deref*/$this());
          if ($this().EmitOMPFirstprivateClause(S, LoopScope)) {
            // Emit implicit barrier to synchronize threads and avoid data races on
            // initialization of firstprivate variables and post-update of
            // lastprivate variables.
            $this().CGM.getOpenMPRuntime().emitBarrierCall(/*Deref*/$this(), S.getLocStart(), OpenMPDirectiveKind.OMPD_unknown, /*EmitChecks=*/ false, 
                /*ForceSimpleCall=*/ true);
          }
          $this().EmitOMPPrivateClause(S, LoopScope);
          HasLastprivateClause = $this().EmitOMPLastprivateClauseInit(S, LoopScope);
          $this().EmitOMPReductionClauseInit(S, LoopScope);
          $this().EmitOMPPrivateLoopCounters(S, LoopScope);
          $this().EmitOMPLinearClause(S, LoopScope);
          /*J:(void)*/LoopScope.Privatize();
          
          // Detect the loop schedule kind and chunk.
          Value /*P*/ Chunk = null;
          OpenMPScheduleTy ScheduleKind/*J*/= new OpenMPScheduleTy();
          {
            /*const*/ OMPScheduleClause /*P*/ C = S.<OMPScheduleClause>getSingleClause(OMPScheduleClause.class);
            if ((C != null)) {
              ScheduleKind.Schedule = C.getScheduleKind();
              ScheduleKind.M1 = C.getFirstScheduleModifier();
              ScheduleKind.M2 = C.getSecondScheduleModifier();
              {
                /*const*/ Expr /*P*/ Ch = C.getChunkSize$Const();
                if ((Ch != null)) {
                  Chunk = $this().EmitScalarExpr(Ch);
                  Chunk = $this().EmitScalarConversion(Chunk, Ch.getType(), 
                      S.getIterationVariable().getType(), 
                      S.getLocStart());
                }
              }
            }
          }
          /*const*//*uint*/int IVSize = $ulong2uint($this().getContext().getTypeSize(IVExpr.getType()));
          /*const*/boolean IVSigned = IVExpr.getType().$arrow().hasSignedIntegerRepresentation();
          // OpenMP 4.5, 2.7.1 Loop Construct, Description.
          // If the static schedule kind is specified or if the ordered clause is
          // specified, and if no monotonic modifier is specified, the effect will
          // be as if the monotonic modifier was specified.
          if (RT.isStaticNonchunked_OpenMPScheduleClauseKind_bool(ScheduleKind.Schedule, 
              /* Chunked */ Chunk != (Value /*P*/ )null)
             && !Ordered) {
            if (isOpenMPSimdDirective(S.getDirectiveKind())) {
              $this().EmitOMPSimdInit(S, /*IsMonotonic=*/ true);
            }
            // OpenMP [2.7.1, Loop Construct, Description, table 2-1]
            // When no chunk_size is specified, the iteration space is divided into
            // chunks that are approximately equal in size, and at most one chunk is
            // distributed to each thread. Note that the size of the chunks is
            // unspecified in this case.
            RT.emitForStaticInit(/*Deref*/$this(), S.getLocStart(), ScheduleKind, 
                IVSize, IVSigned, Ordered, 
                IL.getAddress(), LB.getAddress(), 
                UB.getAddress(), ST.getAddress());
            JumpDest LoopExit = $this().getJumpDestInCurrentScope($this().createBasicBlock(new Twine(/*KEEP_STR*/"omp.loop.exit")));
            // UB = min(UB, GlobalUB);
            $this().EmitIgnoredExpr(S.getEnsureUpperBound());
            // IV = LB;
            $this().EmitIgnoredExpr(S.getInit());
            // while (idx <= UB) { BODY; ++idx; }
            JumpDest L$LoopExit = LoopExit;
            $this().EmitOMPInnerLoop(S, LoopScope.requiresCleanups(), S.getCond(), 
                S.getInc(), 
                /*FuncArg*//*[&S, =L$LoopExit(LoopExit)]*/ (final CodeGenFunction /*&*/ CGF) -> {
                      CGF.EmitOMPLoopBody(S, new JumpDest(L$LoopExit));
                      CGF.EmitStopPoint($AddrOf(S));
                    }, 
                /*FuncArg*//*[]*/ (final CodeGenFunction /*&*/ $Prm0) -> {
                    });
            $this().EmitBlock(LoopExit.getBlock());
            // Tell the runtime we are done.
            RT.emitForStaticFinish(/*Deref*/$this(), S.getLocStart());
          } else {
            /*const*/boolean IsMonotonic = Ordered || ScheduleKind.Schedule == OpenMPScheduleClauseKind.OMPC_SCHEDULE_static
               || ScheduleKind.Schedule == OpenMPScheduleClauseKind.OMPC_SCHEDULE_unknown
               || ScheduleKind.M1 == OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_monotonic
               || ScheduleKind.M2 == OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_monotonic;
            // Emit the outer loop, which requests its work chunk [LB..UB] from
            // runtime and runs the inner loop to process it.
            $this().EmitOMPForOuterLoop(ScheduleKind, IsMonotonic, S, LoopScope, Ordered, 
                LB.getAddress(), UB.getAddress(), ST.getAddress(), 
                IL.getAddress(), Chunk);
          }
          if (isOpenMPSimdDirective(S.getDirectiveKind())) {
            $this().EmitOMPSimdFinal(S, 
                /*FuncArg*//*[&, &IL, &S]*/ (final CodeGenFunction /*&*/ CGF) -> {
                      return CGF.Builder.CreateIsNotNull(CGF.EmitLoadOfScalar(new LValue(IL), S.getLocStart()));
                    });
          }
          $this().EmitOMPReductionClauseFinal(S);
          // Emit post-update of the reduction variables if IsLastIter != 0.
          CGStmtOpenMPStatics.emitPostUpdateForReductionClause(/*Deref*/$this(), S, /*FuncArg*//*[&, &IL, &S]*/ (final CodeGenFunction /*&*/ CGF) -> {
                    return CGF.Builder.CreateIsNotNull(CGF.EmitLoadOfScalar(new LValue(IL), S.getLocStart()));
                  });
          // Emit final copy of the lastprivate variables if IsLastIter != 0.
          if (HasLastprivateClause) {
            $this().EmitOMPLastprivateClauseFinal(S, isOpenMPSimdDirective(S.getDirectiveKind()), 
                $this().Builder.CreateIsNotNull($this().EmitLoadOfScalar(new LValue(IL), S.getLocStart())));
          }
        } finally {
          if (LoopScope != null) { LoopScope.$destroy(); }
        }
      }
      $this().EmitOMPLinearClauseFinal(S, /*FuncArg*//*[&, &IL, &S]*/ (final CodeGenFunction /*&*/ CGF) -> {
                return CGF.Builder.CreateIsNotNull(CGF.EmitLoadOfScalar(new LValue(IL), S.getLocStart()));
              });
      // We're now done with the loop, so jump to the continuation block.
      if ((ContBlock != null)) {
        $this().EmitBranch(ContBlock);
        $this().EmitBlock(ContBlock, true);
      }
    } finally {
      if (PreInitScope != null) { PreInitScope.$destroy(); }
    }
  }
  return HasLastprivateClause;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPOuterLoop">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1671,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPOuterLoop", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitOMPOuterLoopEbbRKNS_16OMPLoopDirectiveERNS1_15OMPPrivateScopeEbNS0_7AddressES7_S7_S7_PN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitOMPOuterLoopEbbRKNS_16OMPLoopDirectiveERNS1_15OMPPrivateScopeEbNS0_7AddressES7_S7_S7_PN4llvm5ValueE")
//</editor-fold>
protected/*private*/ final void EmitOMPOuterLoop(boolean DynamicOrOrdered, boolean IsMonotonic, 
                final /*const*/ OMPLoopDirective /*&*/ S, final OMPPrivateScope /*&*/ LoopScope, boolean Ordered, 
                Address LB, Address UB, Address ST, Address IL, Value /*P*/ Chunk) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    final CGOpenMPRuntime /*&*/ RT = $this().CGM.getOpenMPRuntime();
    
    /*const*/ Expr /*P*/ IVExpr = S.getIterationVariable();
    /*const*//*uint*/int IVSize = $ulong2uint($this().getContext().getTypeSize(IVExpr.getType()));
    /*const*/boolean IVSigned = IVExpr.getType().$arrow().hasSignedIntegerRepresentation();
    
    JumpDest LoopExit = $this().getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"omp.dispatch.end"));
    
    // Start the loop with a block that tests the condition.
    BasicBlock /*P*/ CondBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"omp.dispatch.cond"));
    $this().EmitBlock(CondBlock);
    $this().LoopStack.push(CondBlock, $c$.track(new DebugLoc($this().Builder.getCurrentDebugLocation()))); $c$.clean();
    
    Value /*P*/ BoolCondVal = null;
    if (!DynamicOrOrdered) {
      // UB = min(UB, GlobalUB)
      $this().EmitIgnoredExpr(S.getEnsureUpperBound());
      // IV = LB
      $this().EmitIgnoredExpr(S.getInit());
      // IV < UB
      BoolCondVal = $this().EvaluateExprAsBool(S.getCond());
    } else {
      BoolCondVal = RT.emitForNext(/*Deref*/$this(), S.getLocStart(), IVSize, IVSigned, new Address(IL), 
          new Address(LB), new Address(UB), new Address(ST));
    }
    
    // If there are any cleanups between here and the loop-exit scope,
    // create a block to stage a loop exit along.
    BasicBlock /*P*/ ExitBlock = LoopExit.getBlock();
    if (LoopScope.requiresCleanups()) {
      ExitBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"omp.dispatch.cleanup"));
    }
    
    BasicBlock /*P*/ LoopBody = $this().createBasicBlock(new Twine(/*KEEP_STR*/"omp.dispatch.body"));
    $this().Builder.CreateCondBr(BoolCondVal, LoopBody, ExitBlock);
    if (ExitBlock != LoopExit.getBlock()) {
      $this().EmitBlock(ExitBlock);
      $this().EmitBranchThroughCleanup(new JumpDest(LoopExit));
    }
    $this().EmitBlock(LoopBody);
    
    // Emit "IV = LB" (in case of static schedule, we have already calculated new
    // LB for loop condition and emitted it above).
    if (DynamicOrOrdered) {
      $this().EmitIgnoredExpr(S.getInit());
    }
    
    // Create a block for the increment.
    JumpDest Continue = $this().getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"omp.dispatch.inc"));
    $this().BreakContinueStack.push_back(new BreakContinue(new JumpDest(LoopExit), new JumpDest(Continue)));
    
    // Generate !llvm.loop.parallel metadata for loads and stores for loops
    // with dynamic/guided scheduling and without ordered clause.
    if (!isOpenMPSimdDirective(S.getDirectiveKind())) {
      $this().LoopStack.setParallel(!IsMonotonic);
    } else {
      $this().EmitOMPSimdInit(S, IsMonotonic);
    }
    
    SourceLocation Loc = S.getLocStart();
    JumpDest L$LoopExit = LoopExit;
    boolean L$Ordered = Ordered;
    SourceLocation L$Loc = Loc;
    int L$IVSize = IVSize;
    boolean L$IVSigned = IVSigned;
    $this().EmitOMPInnerLoop(S, LoopScope.requiresCleanups(), S.getCond(), S.getInc(), 
        /*FuncArg*//*[&S, =L$LoopExit(LoopExit)]*/ (final CodeGenFunction /*&*/ CGF) -> {
              CGF.EmitOMPLoopBody(S, new JumpDest(L$LoopExit));
              CGF.EmitStopPoint($AddrOf(S));
            }, 
        /*FuncArg*//*[=L$Ordered(Ordered), =L$IVSize(IVSize), =L$IVSigned(IVSigned), =L$Loc(Loc)]*/ (final CodeGenFunction /*&*/ CGF) -> {
              if (L$Ordered) {
                CGF.CGM.getOpenMPRuntime().emitForOrderedIterationEnd(CGF, new SourceLocation(L$Loc), L$IVSize, L$IVSigned);
              }
            });
    
    $this().EmitBlock(Continue.getBlock());
    $this().BreakContinueStack.pop_back();
    if (!DynamicOrOrdered) {
      // Emit "LB = LB + Stride", "UB = UB + Stride".
      $this().EmitIgnoredExpr(S.getNextLowerBound());
      $this().EmitIgnoredExpr(S.getNextUpperBound());
    }
    
    $this().EmitBranch(CondBlock);
    $this().LoopStack.pop();
    // Emit the fall-through block.
    $this().EmitBlock(LoopExit.getBlock());
    
    // Tell the runtime we are done.
    if (!DynamicOrOrdered) {
      RT.emitForStaticFinish(/*Deref*/$this(), S.getLocEnd());
    }
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPForOuterLoop">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1762,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPForOuterLoop", NM="_ZN5clang7CodeGen15CodeGenFunction19EmitOMPForOuterLoopERKNS_16OpenMPScheduleTyEbRKNS_16OMPLoopDirectiveERNS1_15OMPPrivateScopeEbNS0_7AddressESA_SA_SA_PN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19EmitOMPForOuterLoopERKNS_16OpenMPScheduleTyEbRKNS_16OMPLoopDirectiveERNS1_15OMPPrivateScopeEbNS0_7AddressESA_SA_SA_PN4llvm5ValueE")
//</editor-fold>
protected/*private*/ final void EmitOMPForOuterLoop(final /*const*/ OpenMPScheduleTy /*&*/ ScheduleKind, boolean IsMonotonic, 
                   final /*const*/ OMPLoopDirective /*&*/ S, final OMPPrivateScope /*&*/ LoopScope, boolean Ordered, 
                   Address LB, Address UB, Address ST, Address IL, Value /*P*/ Chunk) {
  final CGOpenMPRuntime /*&*/ RT = $this().CGM.getOpenMPRuntime();
  
  // Dynamic scheduling of the outer loop (dynamic, guided, auto, runtime).
  /*const*/boolean DynamicOrOrdered = Ordered || RT.isDynamic(ScheduleKind.Schedule);
  assert ((Ordered || !RT.isStaticNonchunked_OpenMPScheduleClauseKind_bool(ScheduleKind.Schedule, Chunk != (Value /*P*/ )null))) : "static non-chunked schedule does not need outer loop";
  
  // Emit outer loop.
  //
  // OpenMP [2.7.1, Loop Construct, Description, table 2-1]
  // When schedule(dynamic,chunk_size) is specified, the iterations are
  // distributed to threads in the team in chunks as the threads request them.
  // Each thread executes a chunk of iterations, then requests another chunk,
  // until no chunks remain to be distributed. Each chunk contains chunk_size
  // iterations, except for the last chunk to be distributed, which may have
  // fewer iterations. When no chunk_size is specified, it defaults to 1.
  //
  // When schedule(guided,chunk_size) is specified, the iterations are assigned
  // to threads in the team in chunks as the executing threads request them.
  // Each thread executes a chunk of iterations, then requests another chunk,
  // until no chunks remain to be assigned. For a chunk_size of 1, the size of
  // each chunk is proportional to the number of unassigned iterations divided
  // by the number of threads in the team, decreasing to 1. For a chunk_size
  // with value k (greater than 1), the size of each chunk is determined in the
  // same way, with the restriction that the chunks do not contain fewer than k
  // iterations (except for the last chunk to be assigned, which may have fewer
  // than k iterations).
  //
  // When schedule(auto) is specified, the decision regarding scheduling is
  // delegated to the compiler and/or runtime system. The programmer gives the
  // implementation the freedom to choose any possible mapping of iterations to
  // threads in the team.
  //
  // When schedule(runtime) is specified, the decision regarding scheduling is
  // deferred until run time, and the schedule and chunk size are taken from the
  // run-sched-var ICV. If the ICV is set to auto, the schedule is
  // implementation defined
  //
  // while(__kmpc_dispatch_next(&LB, &UB)) {
  //   idx = LB;
  //   while (idx <= UB) { BODY; ++idx;
  //   __kmpc_dispatch_fini_(4|8)[u](); // For ordered loops only.
  //   } // inner loop
  // }
  //
  // OpenMP [2.7.1, Loop Construct, Description, table 2-1]
  // When schedule(static, chunk_size) is specified, iterations are divided into
  // chunks of size chunk_size, and the chunks are assigned to the threads in
  // the team in a round-robin fashion in the order of the thread number.
  //
  // while(UB = min(UB, GlobalUB), idx = LB, idx < UB) {
  //   while (idx <= UB) { BODY; ++idx; } // inner loop
  //   LB = LB + ST;
  //   UB = UB + ST;
  // }
  //
  /*const*/ Expr /*P*/ IVExpr = S.getIterationVariable();
  /*const*//*uint*/int IVSize = $ulong2uint($this().getContext().getTypeSize(IVExpr.getType()));
  /*const*/boolean IVSigned = IVExpr.getType().$arrow().hasSignedIntegerRepresentation();
  if (DynamicOrOrdered) {
    Value /*P*/ UBVal = $this().EmitScalarExpr(S.getLastIteration());
    RT.emitForDispatchInit(/*Deref*/$this(), S.getLocStart(), ScheduleKind, IVSize, 
        IVSigned, Ordered, UBVal, Chunk);
  } else {
    RT.emitForStaticInit(/*Deref*/$this(), S.getLocStart(), ScheduleKind, IVSize, IVSigned, 
        Ordered, new Address(IL), new Address(LB), new Address(UB), new Address(ST), Chunk);
  }
  
  $this().EmitOMPOuterLoop(DynamicOrOrdered, IsMonotonic, S, LoopScope, Ordered, new Address(LB), new Address(UB), 
      new Address(ST), new Address(IL), Chunk);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPDistributeOuterLoop">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 1844,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPDistributeOuterLoop", NM="_ZN5clang7CodeGen15CodeGenFunction26EmitOMPDistributeOuterLoopENS_28OpenMPDistScheduleClauseKindERKNS_22OMPDistributeDirectiveERNS1_15OMPPrivateScopeENS0_7AddressES8_S8_S8_PN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26EmitOMPDistributeOuterLoopENS_28OpenMPDistScheduleClauseKindERKNS_22OMPDistributeDirectiveERNS1_15OMPPrivateScopeENS0_7AddressES8_S8_S8_PN4llvm5ValueE")
//</editor-fold>
protected/*private*/ final void EmitOMPDistributeOuterLoop(/*OpenMPDistScheduleClauseKind*/int ScheduleKind, 
                          final /*const*/ OMPDistributeDirective /*&*/ S, final OMPPrivateScope /*&*/ LoopScope, 
                          Address LB, Address UB, Address ST, Address IL, Value /*P*/ Chunk) {
  
  final CGOpenMPRuntime /*&*/ RT = $this().CGM.getOpenMPRuntime();
  
  // Emit outer loop.
  // Same behavior as a OMPForOuterLoop, except that schedule cannot be
  // dynamic
  //
  /*const*/ Expr /*P*/ IVExpr = S.getIterationVariable();
  /*const*//*uint*/int IVSize = $ulong2uint($this().getContext().getTypeSize(IVExpr.getType()));
  /*const*/boolean IVSigned = IVExpr.getType().$arrow().hasSignedIntegerRepresentation();
  
  RT.emitDistributeStaticInit(/*Deref*/$this(), S.getLocStart(), ScheduleKind, 
      IVSize, IVSigned, /* Ordered = */ false, 
      new Address(IL), new Address(LB), new Address(UB), new Address(ST), Chunk);
  
  $this().EmitOMPOuterLoop(/* DynamicOrOrdered = */ false, /* IsMonotonic = */ false, 
      S, LoopScope, /* Ordered = */ false, new Address(LB), new Address(UB), new Address(ST), new Address(IL), Chunk);
}

/// \brief Emit code for sections directive.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitSections">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp", line = 2153,
 FQN="clang::CodeGen::CodeGenFunction::EmitSections", NM="_ZN5clang7CodeGen15CodeGenFunction12EmitSectionsERKNS_22OMPExecutableDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12EmitSectionsERKNS_22OMPExecutableDirectiveE")
//</editor-fold>
protected/*private*/ final void EmitSections(final /*const*/ OMPExecutableDirective /*&*/ S) {
  Stmt /*P*/ $Stmt = cast_CapturedStmt(S.getAssociatedStmt()).getCapturedStmt();
  CompoundStmt /*P*/ CS = dyn_cast_CompoundStmt($Stmt);
  bool$ref HasLastprivates = create_bool$ref(false);
  CompoundStmt L$CS = CS;
  final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&S, =L$$Stmt($Stmt), =L$CS(CS), &HasLastprivates]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
        CodeGenFunction.OpaqueValueMapping OpaqueIV = null;
        CodeGenFunction.OpaqueValueMapping OpaqueUB = null;
        CodeGenFunction.OMPPrivateScope LoopScope = null;
        try {
          final ASTContext /*&*/ C = CGF.CGM.getContext();
          QualType KmpInt32Ty = C.getIntTypeForBitwidth(/*DestWidth=*/ 32, /*Signed=*/ 1);
          // Emit helper vars inits.
          LValue LB = CGStmtOpenMPStatics.createSectionLVal(CGF, new QualType(KmpInt32Ty), new Twine(/*KEEP_STR*/".omp.sections.lb."), 
              CGF.Builder.getInt32(0));
          ConstantInt /*P*/ GlobalUBVal = L$CS != null ? CGF.Builder.getInt32(L$CS.size() - 1) : CGF.Builder.getInt32(0);
          LValue UB = CGStmtOpenMPStatics.createSectionLVal(CGF, new QualType(KmpInt32Ty), new Twine(/*KEEP_STR*/".omp.sections.ub."), GlobalUBVal);
          LValue ST = CGStmtOpenMPStatics.createSectionLVal(CGF, new QualType(KmpInt32Ty), new Twine(/*KEEP_STR*/".omp.sections.st."), 
              CGF.Builder.getInt32(1));
          LValue IL = CGStmtOpenMPStatics.createSectionLVal(CGF, new QualType(KmpInt32Ty), new Twine(/*KEEP_STR*/".omp.sections.il."), 
              CGF.Builder.getInt32(0));
          // Loop counter.
          LValue IV = CGStmtOpenMPStatics.createSectionLVal(CGF, new QualType(KmpInt32Ty), new Twine(/*KEEP_STR*/".omp.sections.iv."));
          OpaqueValueExpr IVRefExpr/*J*/= new OpaqueValueExpr(S.getLocStart(), new QualType(KmpInt32Ty), ExprValueKind.VK_LValue);
          OpaqueIV/*J*/= new CodeGenFunction.OpaqueValueMapping(CGF, $AddrOf(IVRefExpr), new LValue(IV));
          OpaqueValueExpr UBRefExpr/*J*/= new OpaqueValueExpr(S.getLocStart(), new QualType(KmpInt32Ty), ExprValueKind.VK_LValue);
          OpaqueUB/*J*/= new CodeGenFunction.OpaqueValueMapping(CGF, $AddrOf(UBRefExpr), new LValue(UB));
          // Generate condition for loop.
          org.clang.ast.BinaryOperator Cond/*J*/= new org.clang.ast.BinaryOperator($AddrOf(IVRefExpr), $AddrOf(UBRefExpr), BinaryOperatorKind.BO_LE, C.BoolTy.$QualType(), ExprValueKind.VK_RValue, 
              ExprObjectKind.OK_Ordinary, S.getLocStart(), 
              /*fpContractable=*/ false);
          // Increment for loop counter.
          UnaryOperator Inc/*J*/= new UnaryOperator($AddrOf(IVRefExpr), UnaryOperatorKind.UO_PreInc, new QualType(KmpInt32Ty), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
              S.getLocStart());
          Stmt L$$Stmt = $Stmt;
          CodeGenFunction.GenFun/*const*/ BodyGen = /*[=L$L$$Stmt(L$$Stmt), =L$L$CS(L$CS), &S, &IV]*/ (final CodeGenFunction /*&*/ CGF$1) -> {
                // Iterate through all sections and emit a switch construct:
                // switch (IV) {
                //   case 0:
                //     <SectionStmt[0]>;
                //     break;
                // ...
                //   case <NumSection> - 1:
                //     <SectionStmt[<NumSection> - 1]>;
                //     break;
                // }
                // .omp.sections.exit:
                BasicBlock /*P*/ ExitBB = CGF$1.createBasicBlock(new Twine(/*KEEP_STR*/".omp.sections.exit"));
                SwitchInst /*P*/ SwitchStmt = CGF$1.Builder.CreateSwitch(CGF$1.EmitLoadOfLValue(new LValue(IV), S.getLocStart()).getScalarVal(), ExitBB, 
                    L$CS == (CompoundStmt /*P*/ )null ? 1 : L$CS.size());
                if ((L$CS != null)) {
                  /*uint*/int CaseNumber = 0;
                  for (Stmt /*P*/ SubStmt : L$CS.children()) {
                    BasicBlock /*P*/ CaseBB = CGF$1.createBasicBlock(new Twine(/*KEEP_STR*/".omp.sections.case"));
                    CGF$1.EmitBlock(CaseBB);
                    SwitchStmt.addCase(CGF$1.Builder.getInt32(CaseNumber), CaseBB);
                    CGF$1.EmitStmt(SubStmt);
                    CGF$1.EmitBranch(ExitBB);
                    ++CaseNumber;
                  }
                } else {
                  BasicBlock /*P*/ CaseBB = CGF$1.createBasicBlock(new Twine(/*KEEP_STR*/".omp.sections.case"));
                  CGF$1.EmitBlock(CaseBB);
                  SwitchStmt.addCase(CGF$1.Builder.getInt32(0), CaseBB);
                  CGF$1.EmitStmt(L$$Stmt);
                  CGF$1.EmitBranch(ExitBB);
                }
                CGF$1.EmitBlock(ExitBB, /*IsFinished=*/ true);
              };
          
          LoopScope/*J*/= new CodeGenFunction.OMPPrivateScope(CGF);
          if (CGF.EmitOMPFirstprivateClause(S, LoopScope)) {
            // Emit implicit barrier to synchronize threads and avoid data races on
            // initialization of firstprivate variables and post-update of lastprivate
            // variables.
            CGF.CGM.getOpenMPRuntime().emitBarrierCall(CGF, S.getLocStart(), OpenMPDirectiveKind.OMPD_unknown, /*EmitChecks=*/ false, 
                /*ForceSimpleCall=*/ true);
          }
          CGF.EmitOMPPrivateClause(S, LoopScope);
          HasLastprivates.$set(CGF.EmitOMPLastprivateClauseInit(S, LoopScope));
          CGF.EmitOMPReductionClauseInit(S, LoopScope);
          /*J:(void)*/LoopScope.Privatize();
          
          // Emit static non-chunked loop.
          OpenMPScheduleTy ScheduleKind/*J*/= new OpenMPScheduleTy();
          ScheduleKind.Schedule = OpenMPScheduleClauseKind.OMPC_SCHEDULE_static;
          CGF.CGM.getOpenMPRuntime().emitForStaticInit(CGF, S.getLocStart(), ScheduleKind, /*IVSize=*/ 32, 
              /*IVSigned=*/ true, /*Ordered=*/ false, IL.getAddress(), LB.getAddress(), 
              UB.getAddress(), ST.getAddress());
          // UB = min(UB, GlobalUB);
          Value /*P*/ UBVal = CGF.EmitLoadOfScalar(new LValue(UB), S.getLocStart());
          Value /*P*/ MinUBGlobalUB = CGF.Builder.CreateSelect(CGF.Builder.CreateICmpSLT(UBVal, GlobalUBVal), UBVal, GlobalUBVal);
          CGF.EmitStoreOfScalar(MinUBGlobalUB, new LValue(UB));
          // IV = LB;
          CGF.EmitStoreOfScalar(CGF.EmitLoadOfScalar(new LValue(LB), S.getLocStart()), new LValue(IV));
          // while (idx <= UB) { BODY; ++idx; }
          CGF.EmitOMPInnerLoop(S, /*RequiresCleanup=*/ false, $AddrOf(Cond), $AddrOf(Inc), /*FuncArg*/BodyGen, 
              /*FuncArg*//*[]*/ (final CodeGenFunction /*&*/ $Prm0) -> {
                  });
          // Tell the runtime we are done.
          CGF.CGM.getOpenMPRuntime().emitForStaticFinish(CGF, S.getLocStart());
          CGF.EmitOMPReductionClauseFinal(S);
          // Emit post-update of the reduction variables if IsLastIter != 0.
          CGStmtOpenMPStatics.emitPostUpdateForReductionClause(CGF, S, /*FuncArg*//*[&, &IL, &S]*/ (final CodeGenFunction /*&*/ CGF$1) -> {
                    return CGF$1.Builder.CreateIsNotNull(CGF$1.EmitLoadOfScalar(new LValue(IL), S.getLocStart()));
                  });
          
          // Emit final copy of the lastprivate variables if IsLastIter != 0.
          if (HasLastprivates.$deref()) {
            CGF.EmitOMPLastprivateClauseFinal(S, /*NoFinals=*/ false, 
                CGF.Builder.CreateIsNotNull(CGF.EmitLoadOfScalar(new LValue(IL), S.getLocStart())));
          }
        } finally {
          if (LoopScope != null) { LoopScope.$destroy(); }
          if (OpaqueUB != null) { OpaqueUB.$destroy(); }
          if (OpaqueIV != null) { OpaqueIV.$destroy(); }
        }
      };
  
  boolean HasCancel = false;
  {
    /*const*/ OMPSectionsDirective /*P*/ OSD = dyn_cast_OMPSectionsDirective($AddrOf(S));
    if ((OSD != null)) {
      HasCancel = OSD.hasCancel();
    } else {
      /*const*/ OMPParallelSectionsDirective /*P*/ OPSD = dyn_cast_OMPParallelSectionsDirective($AddrOf(S));
      if ((OPSD != null)) {
        HasCancel = OPSD.hasCancel();
      }
    }
  }
  $this().CGM.getOpenMPRuntime().emitInlinedDirective(/*Deref*/$this(), OpenMPDirectiveKind.OMPD_sections, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen), 
      HasCancel);
  // Emit barrier for lastprivates only if 'sections' directive has 'nowait'
  // clause. Otherwise the barrier will be generated by the codegen for the
  // directive.
  if (HasLastprivates.$deref() && (S.<OMPNowaitClause>getSingleClause(OMPNowaitClause.class) != null)) {
    // Emit implicit barrier to synchronize threads and avoid data races on
    // initialization of firstprivate variables.
    $this().CGM.getOpenMPRuntime().emitBarrierCall(/*Deref*/$this(), S.getLocStart(), 
        OpenMPDirectiveKind.OMPD_unknown);
  }
}

} // END OF class CodeGenFunction_CGStmtOpenMP
