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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.CharUnitsGlobals.*;
import org.clang.ast.DeclContext.specific_decl_iterator;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.support.AdtsupportLlvmGlobals.$out_raw_ostream_APSInt$C;
import org.llvm.support.sys.fs;


//<editor-fold defaultstate="collapsed" desc="static type CGOpenMPRuntimeStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.impl.CGOpenMPRuntimeStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL12getIdentSizeRN5clang7CodeGen13CodeGenModuleE;_ZL13getIdentAlignRN5clang7CodeGen13CodeGenModuleE;_ZL15emitOMPIfClauseRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprERKNS0_15RegionCodeGenTyES8_;_ZL15evaluateCDTSizePKN5clang12FunctionDeclEN4llvm8ArrayRefIN12_GLOBAL__N_111ParamAttrTyEEE;_ZL16emitPrivatesInitRN5clang7CodeGen15CodeGenFunctionERKNS_22OMPExecutableDirectiveENS0_7AddressENS0_6LValueEPKNS_10RecordDeclENS_8QualTypeESB_RKNS0_13OMPTaskDataTyEN4llvm8ArrayRefISt4pairINS_9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEEEEb;_ZL18getRuntimeScheduleN5clang24OpenMPScheduleClauseKindEbb;_ZL18getRuntimeScheduleN5clang28OpenMPDistScheduleClauseKindEb;_ZL19checkInitIsRequiredRN5clang7CodeGen15CodeGenFunctionEN4llvm8ArrayRefISt4pairINS_9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEEEE;_ZL19createIdentFieldGEPRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEN12_GLOBAL__N_115IdentFieldIndexERKN4llvm5TwineE;_ZL19emitTaskDupFunctionRN5clang7CodeGen13CodeGenModuleENS_14SourceLocationERKNS_22OMPExecutableDirectiveENS_8QualTypeEPKNS_10RecordDeclESA_S7_S7_RKNS0_13OMPTaskDataTyEN4llvm8ArrayRefISt4pairINS_9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEEEEb;_ZL19getCancellationKindN5clang19OpenMPDirectiveKindE;_ZL19ignoreCompoundStmtsPKN5clang4StmtE;_ZL20addFieldToRecordDeclRN5clang10ASTContextEPNS_11DeclContextENS_8QualTypeE;_ZL20emitOffloadingArraysRN5clang7CodeGen15CodeGenFunctionERPN4llvm5ValueES6_S6_S6_RNS3_11SmallVectorIS5_Lj16EEES9_S9_RNS7_IjLj16EEE;_ZL21emitForStaticInitCallRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueES5_PNS3_8ConstantEN12_GLOBAL__N_115OpenMPSchedTypeENS_28OpenMPScheduleClauseModifierESA_jbNS0_7AddressESB_SB_SB_S5_;_ZL21emitProxyTaskFunctionRN5clang7CodeGen13CodeGenModuleENS_14SourceLocationENS_19OpenMPDirectiveKindENS_8QualTypeES5_S5_S5_S5_PN4llvm5ValueES8_;_ZL21emitReductionCombinerRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE;_ZL21emitReductionFunctionRN5clang7CodeGen13CodeGenModuleEPN4llvm4TypeENS3_8ArrayRefIPKNS_4ExprEEESA_SA_SA_;_ZL21getOffsetOfIdentFieldN12_GLOBAL__N_115IdentFieldIndexE;_ZL22addMonoNonMonoModifierN12_GLOBAL__N_115OpenMPSchedTypeEN5clang28OpenMPScheduleClauseModifierES2_;_ZL22emitAddrOfVarFromArrayRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEjPKNS_7VarDeclE;_ZL23emitDestructorsFunctionRN5clang7CodeGen13CodeGenModuleENS_14SourceLocationENS_8QualTypeES4_S4_;_ZL24checkDestructorsRequiredPKN5clang10RecordDeclE;_ZL24createKmpTaskTRecordDeclRN5clang7CodeGen13CodeGenModuleENS_19OpenMPDirectiveKindENS_8QualTypeES4_;_ZL24createPrivatesRecordDeclRN5clang7CodeGen13CodeGenModuleEN4llvm8ArrayRefISt4pairINS_9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEEEE;_ZL24getTargetEntryUniqueInfoRN5clang10ASTContextENS_14SourceLocationERjS3_S3_;_ZL25EmitOMPAggregateReductionRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeEPKNS_7VarDeclES6_RKN4llvm12function_refIFvS2_PKNS_4ExprESB_SB_EEESB_SB_SB_;_ZL25array_pod_sort_comparatorPKSt4pairIN5clang9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEES6_;_ZL25emitCombinerOrInitializerRN5clang7CodeGen13CodeGenModuleENS_8QualTypeEPKNS_4ExprEPKNS_7VarDeclES9_b;_ZL26emitX86DeclareSimdFunctionPKN5clang12FunctionDeclEPN4llvm8FunctionENS3_6APSIntENS3_8ArrayRefIN12_GLOBAL__N_111ParamAttrTyEEENS_22OMPDeclareSimdDeclAttr13BranchStateTyE;_ZL27emitCopyprivateCopyFunctionRN5clang7CodeGen13CodeGenModuleEPN4llvm4TypeENS3_8ArrayRefIPKNS_4ExprEEESA_SA_SA_;_ZL27emitSingleReductionCombinerRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprES5_PKNS_11DeclRefExprES8_;_ZL28emitOffloadingArraysArgumentRN5clang7CodeGen15CodeGenFunctionERPN4llvm5ValueES6_S6_S6_S5_S5_S5_S5_j;_ZL30emitTaskPrivateMappingFunctionRN5clang7CodeGen13CodeGenModuleENS_14SourceLocationEN4llvm8ArrayRefIPKNS_4ExprEEES9_S9_NS_8QualTypeENS5_ISt4pairINS_9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEEEE;_ZL36createKmpTaskTWithPrivatesRecordDeclRN5clang7CodeGen13CodeGenModuleENS_8QualTypeEN4llvm8ArrayRefISt4pairINS_9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEEEE;_ZL36emitNumTeamsClauseForTargetDirectiveRN5clang7CodeGen15CGOpenMPRuntimeERNS0_15CodeGenFunctionERKNS_22OMPExecutableDirectiveE;_ZL39emitThreadLimitClauseForTargetDirectiveRN5clang7CodeGen15CGOpenMPRuntimeERNS0_15CodeGenFunctionERKNS_22OMPExecutableDirectiveE;_ZL40createOffloadingBinaryDescriptorFunctionRN5clang7CodeGen13CodeGenModuleEN4llvm9StringRefERKNS0_15RegionCodeGenTyE;_ZN12_GLOBAL__N_1L12EmptyCodeGenERN5clang7CodeGen15CodeGenFunctionERNS1_15PrePostActionTyE; -static-type=CGOpenMPRuntimeStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGOpenMPRuntimeStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptyCodeGen">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 320,
 FQN="(anonymous namespace)::EmptyCodeGen", NM="_ZN12_GLOBAL__N_1L12EmptyCodeGenERN5clang7CodeGen15CodeGenFunctionERNS1_15PrePostActionTyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_1L12EmptyCodeGenERN5clang7CodeGen15CodeGenFunctionERNS1_15PrePostActionTyE")
//</editor-fold>
public static void EmptyCodeGen(Object java_not_used, final CodeGenFunction /*&*/ $Prm0, final PrePostActionTy /*&*/ $Prm1) {
  throw new llvm_unreachable("No codegen for expressions");
}

//<editor-fold defaultstate="collapsed" desc="emitCombinerOrInitializer">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 738,
 FQN="emitCombinerOrInitializer", NM="_ZL25emitCombinerOrInitializerRN5clang7CodeGen13CodeGenModuleENS_8QualTypeEPKNS_4ExprEPKNS_7VarDeclES9_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL25emitCombinerOrInitializerRN5clang7CodeGen13CodeGenModuleENS_8QualTypeEPKNS_4ExprEPKNS_7VarDeclES9_b")
//</editor-fold>
public static Function /*P*/ emitCombinerOrInitializer(final CodeGenModule /*&*/ CGM, QualType Ty, 
                         /*const*/ Expr /*P*/ CombinerInitializer, /*const*/ VarDecl /*P*/ In, 
                         /*const*/ VarDecl /*P*/ Out, boolean IsCombiner) {
  FunctionArgList Args = null;
  ImplicitParamDecl OmpOutParm = null;
  ImplicitParamDecl OmpInParm = null;
  CodeGenFunction CGF = null;
  CodeGenFunction.OMPPrivateScope Scope = null;
  try {
    // void .omp_combiner.(Ty *in, Ty *out);
    final ASTContext /*&*/ C = CGM.getContext();
    QualType PtrTy = C.getPointerType(/*NO_COPY*/Ty).withRestrict();
    Args/*J*/= new FunctionArgList();
    OmpOutParm/*J*/= new ImplicitParamDecl(C, /*DC=*/ (DeclContext /*P*/ )null, Out.getLocation(), 
        /*Id=*/ (IdentifierInfo /*P*/ )null, new QualType(PtrTy));
    OmpInParm/*J*/= new ImplicitParamDecl(C, /*DC=*/ (DeclContext /*P*/ )null, In.getLocation(), 
        /*Id=*/ (IdentifierInfo /*P*/ )null, new QualType(PtrTy));
    Args.push_back($AddrOf(OmpOutParm));
    Args.push_back($AddrOf(OmpInParm));
    final /*const*/ CGFunctionInfo /*&*/ FnInfo = CGM.getTypes().arrangeBuiltinFunctionDeclaration(C.VoidTy.$QualType(), Args);
    org.llvm.ir.FunctionType /*P*/ FnTy = CGM.getTypes().GetFunctionType(FnInfo);
    Function /*P*/ Fn = Function.Create(FnTy, GlobalValue.LinkageTypes.InternalLinkage, 
        new Twine(IsCombiner ? $(".omp_combiner.") : $(".omp_initializer.")), $AddrOf(CGM.getModule()));
    CGM.SetInternalFunctionAttributes(/*D=*/ (/*const*/ Decl /*P*/ )null, Fn, FnInfo);
    Fn.addFnAttr(Attribute.AttrKind.AlwaysInline);
    CGF/*J*/= new CodeGenFunction(CGM);
    // Map "T omp_in;" variable to "*omp_in_parm" value in all expressions.
    // Map "T omp_out;" variable to "*omp_out_parm" value in all expressions.
    CGF.StartFunction(new GlobalDecl(), C.VoidTy.$QualType(), Fn, FnInfo, Args);
    Scope/*J*/= new CodeGenFunction.OMPPrivateScope(CGF);
    Address AddrIn = CGF.GetAddrOfLocalVar($AddrOf(OmpInParm));
    final CodeGenFunction $CGF = CGF;
    Scope.addPrivate(In, /*FuncArg*//*[&CGF, =L$AddrIn(AddrIn), =L$PtrTy(PtrTy)]*/ () -> {
              return $CGF.EmitLoadOfPointerLValue(new Address(AddrIn), PtrTy.$arrow().castAs(org.clang.ast.PointerType.class)).
                  getAddress();
            });
    Address AddrOut = CGF.GetAddrOfLocalVar($AddrOf(OmpOutParm));
    Scope.addPrivate(Out, /*FuncArg*//*[&CGF, =L$AddrOut(AddrOut), =L$PtrTy(PtrTy)]*/ () -> {
              return $CGF.EmitLoadOfPointerLValue(new Address(AddrOut), PtrTy.$arrow().castAs(org.clang.ast.PointerType.class)).
                  getAddress();
            });
    /*J:(void)*/Scope.Privatize();
    CGF.EmitIgnoredExpr(CombinerInitializer);
    Scope.ForceCleanup_OMPPrivateScope();
    CGF.FinishFunction();
    return Fn;
  } finally {
    if (Scope != null) { Scope.$destroy(); }
    if (CGF != null) { CGF.$destroy(); }
    if (OmpInParm != null) { OmpInParm.$destroy(); }
    if (OmpOutParm != null) { OmpOutParm.$destroy(); }
    if (Args != null) { Args.$destroy(); }
  }
}


// Layout information for ident_t.
//<editor-fold defaultstate="collapsed" desc="getIdentAlign">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 823,
 FQN="getIdentAlign", NM="_ZL13getIdentAlignRN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL13getIdentAlignRN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static CharUnits getIdentAlign(final CodeGenModule /*&*/ CGM) {
  return CGM.getPointerAlign();
}

//<editor-fold defaultstate="collapsed" desc="getIdentSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 826,
 FQN="getIdentSize", NM="_ZL12getIdentSizeRN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL12getIdentSizeRN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static CharUnits getIdentSize(final CodeGenModule /*&*/ CGM) {
  assert (($star_long_CharUnits$C(4, CGM.getPointerSize())).isMultipleOf(CGM.getPointerAlign()));
  return CharUnits.fromQuantity(16).$add(CGM.getPointerSize());
}

//<editor-fold defaultstate="collapsed" desc="getOffsetOfIdentField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 830,
 FQN="getOffsetOfIdentField", NM="_ZL21getOffsetOfIdentFieldN12_GLOBAL__N_115IdentFieldIndexE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL21getOffsetOfIdentFieldN12_GLOBAL__N_115IdentFieldIndexE")
//</editor-fold>
public static CharUnits getOffsetOfIdentField(IdentFieldIndex Field) {
  // All the fields except the last are i32, so this works beautifully.
  return $star_long_CharUnits$C($uint2long(((/*uint*/int)(Field.getValue()))), CharUnits.fromQuantity(4));
}

//<editor-fold defaultstate="collapsed" desc="createIdentFieldGEP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 834,
 FQN="createIdentFieldGEP", NM="_ZL19createIdentFieldGEPRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEN12_GLOBAL__N_115IdentFieldIndexERKN4llvm5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL19createIdentFieldGEPRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEN12_GLOBAL__N_115IdentFieldIndexERKN4llvm5TwineE")
//</editor-fold>
public static Address createIdentFieldGEP(final CodeGenFunction /*&*/ CGF, Address Addr, 
                   IdentFieldIndex Field) {
  return createIdentFieldGEP(CGF, Addr, 
                   Field, 
                   new Twine(/*KEEP_STR*/$EMPTY));
}
public static Address createIdentFieldGEP(final CodeGenFunction /*&*/ CGF, Address Addr, 
                   IdentFieldIndex Field, 
                   final /*const*/ Twine /*&*/ Name/*= ""*/) {
  CharUnits Offset = getOffsetOfIdentField(Field);
  return CGF.Builder.CreateStructGEP(new Address(Addr), Field.getValue(), new CharUnits(Offset), Name);
}


/// \brief Emits code for OpenMP 'if' clause using specified \a CodeGen
/// function. Here is the logic:
/// if (Cond) {
///   ThenGen();
/// } else {
///   ElseGen();
/// }
//<editor-fold defaultstate="collapsed" desc="emitOMPIfClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 1892,
 FQN="emitOMPIfClause", NM="_ZL15emitOMPIfClauseRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprERKNS0_15RegionCodeGenTyES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL15emitOMPIfClauseRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprERKNS0_15RegionCodeGenTyES8_")
//</editor-fold>
public static void emitOMPIfClause(final CodeGenFunction /*&*/ CGF, /*const*/ Expr /*P*/ Cond, 
               final /*const*/ RegionCodeGenTy /*&*/ ThenGen, 
               final /*const*/ RegionCodeGenTy /*&*/ ElseGen) {
  CodeGenFunction.LexicalScope ConditionScope = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    ConditionScope/*J*/= new CodeGenFunction.LexicalScope(CGF, Cond.getSourceRange());
    
    // If the condition constant folds and can be elided, try to avoid emitting
    // the condition and the dead arm of the if/else.
    bool$ref CondConstant = create_bool$ref();
    if (CGF.ConstantFoldsToSimpleInteger(Cond, CondConstant)) {
      if (CondConstant.$deref()) {
        ThenGen.$call(CGF);
      } else {
        ElseGen.$call(CGF);
      }
      return;
    }
    
    // Otherwise, the condition did not fold, or we couldn't elide it.  Just
    // emit the conditional branch.
    BasicBlock /*P*/ ThenBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"omp_if.then"));
    BasicBlock /*P*/ ElseBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"omp_if.else"));
    BasicBlock /*P*/ ContBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"omp_if.end"));
    CGF.EmitBranchOnBoolExpr(Cond, ThenBlock, ElseBlock, /*TrueCount=*/ $int2ulong(0));
    
    // Emit the 'then' code.
    CGF.EmitBlock(ThenBlock);
    ThenGen.$call(CGF);
    CGF.EmitBranch(ContBlock);
    // Emit the 'else' code if present.
    // There is no need to emit line number for unconditional branch.
    /*J:(void)*/$c$.track(ApplyDebugLocation.CreateEmpty(CGF)); $c$.clean();
    CGF.EmitBlock(ElseBlock);
    ElseGen.$call(CGF);
    // There is no need to emit line number for unconditional branch.
    /*J:(void)*/$c$.track(ApplyDebugLocation.CreateEmpty(CGF)); $c$.clean();
    CGF.EmitBranch(ContBlock);
    // Emit the continuation block for code after the if.
    CGF.EmitBlock(ContBlock, /*IsFinished=*/ true);
  } finally {
    if (ConditionScope != null) { ConditionScope.$destroy(); }
    $c$.$destroy();
  }
}


/// Given an array of pointers to variables, project the address of a
/// given variable.
//<editor-fold defaultstate="collapsed" desc="emitAddrOfVarFromArray">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2152,
 FQN="emitAddrOfVarFromArray", NM="_ZL22emitAddrOfVarFromArrayRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEjPKNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL22emitAddrOfVarFromArrayRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEjPKNS_7VarDeclE")
//</editor-fold>
public static Address emitAddrOfVarFromArray(final CodeGenFunction /*&*/ CGF, Address Array, 
                      /*uint*/int Index, /*const*/ VarDecl /*P*/ Var) {
  // Pull out the pointer to the variable.
  Address PtrAddr = CGF.Builder.CreateConstArrayGEP(new Address(Array), $uint2ulong(Index), CGF.getPointerSize());
  Value /*P*/ Ptr = CGF.Builder.CreateLoad(new Address(PtrAddr));
  
  Address Addr = new Address(Ptr, CGF.getContext().getDeclAlign(Var));
  Addr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(Addr), CGF.ConvertTypeForMem(Var.getType())));
  return Addr;
}

//<editor-fold defaultstate="collapsed" desc="emitCopyprivateCopyFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2165,
 FQN="emitCopyprivateCopyFunction", NM="_ZL27emitCopyprivateCopyFunctionRN5clang7CodeGen13CodeGenModuleEPN4llvm4TypeENS3_8ArrayRefIPKNS_4ExprEEESA_SA_SA_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL27emitCopyprivateCopyFunctionRN5clang7CodeGen13CodeGenModuleEPN4llvm4TypeENS3_8ArrayRefIPKNS_4ExprEEESA_SA_SA_")
//</editor-fold>
public static Value /*P*/ emitCopyprivateCopyFunction(final CodeGenModule /*&*/ CGM, org.llvm.ir.Type /*P*/ ArgsType, 
                           ArrayRef</*const*/ Expr /*P*/ > CopyprivateVars, ArrayRef</*const*/ Expr /*P*/ > DestExprs, 
                           ArrayRef</*const*/ Expr /*P*/ > SrcExprs, ArrayRef</*const*/ Expr /*P*/ > AssignmentOps) {
  FunctionArgList Args = null;
  ImplicitParamDecl LHSArg = null;
  ImplicitParamDecl RHSArg = null;
  CodeGenFunction CGF = null;
  try {
    final ASTContext /*&*/ C = CGM.getContext();
    // void copy_func(void *LHSArg, void *RHSArg);
    Args/*J*/= new FunctionArgList();
    LHSArg/*J*/= new ImplicitParamDecl(C, /*DC=*/ (DeclContext /*P*/ )null, new SourceLocation(), /*Id=*/ (IdentifierInfo /*P*/ )null, 
        C.VoidPtrTy.$QualType());
    RHSArg/*J*/= new ImplicitParamDecl(C, /*DC=*/ (DeclContext /*P*/ )null, new SourceLocation(), /*Id=*/ (IdentifierInfo /*P*/ )null, 
        C.VoidPtrTy.$QualType());
    Args.push_back($AddrOf(LHSArg));
    Args.push_back($AddrOf(RHSArg));
    final /*const*/ CGFunctionInfo /*&*/ CGFI = CGM.getTypes().arrangeBuiltinFunctionDeclaration(C.VoidTy.$QualType(), Args);
    Function /*P*/ Fn = Function.Create(CGM.getTypes().GetFunctionType(CGFI), GlobalValue.LinkageTypes.InternalLinkage, 
        new Twine(/*KEEP_STR*/".omp.copyprivate.copy_func"), $AddrOf(CGM.getModule()));
    CGM.SetInternalFunctionAttributes(/*D=*/ (/*const*/ Decl /*P*/ )null, Fn, CGFI);
    CGF/*J*/= new CodeGenFunction(CGM);
    CGF.StartFunction(new GlobalDecl(), C.VoidTy.$QualType(), Fn, CGFI, Args);
    // Dest = (void*[n])(LHSArg);
    // Src = (void*[n])(RHSArg);
    Address LHS/*J*/= new Address(CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(CGF.Builder.CreateLoad(CGF.GetAddrOfLocalVar($AddrOf(LHSArg))), 
            ArgsType), CGF.getPointerAlign());
    Address RHS/*J*/= new Address(CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(CGF.Builder.CreateLoad(CGF.GetAddrOfLocalVar($AddrOf(RHSArg))), 
            ArgsType), CGF.getPointerAlign());
    // *(Type0*)Dst[0] = *(Type0*)Src[0];
    // *(Type1*)Dst[1] = *(Type1*)Src[1];
    // ...
    // *(Typen*)Dst[n] = *(Typen*)Src[n];
    for (/*uint*/int I = 0, E = AssignmentOps.size(); $less_uint(I, E); ++I) {
      /*const*/ VarDecl /*P*/ DestVar = cast_VarDecl(cast_DeclRefExpr(DestExprs.$at(I)).getDecl$Const());
      Address DestAddr = emitAddrOfVarFromArray(CGF, new Address(LHS), I, DestVar);
      
      /*const*/ VarDecl /*P*/ SrcVar = cast_VarDecl(cast_DeclRefExpr(SrcExprs.$at(I)).getDecl$Const());
      Address SrcAddr = emitAddrOfVarFromArray(CGF, new Address(RHS), I, SrcVar);
      
      /*const*/ ValueDecl /*P*/ VD = cast_DeclRefExpr(CopyprivateVars.$at(I)).getDecl$Const();
      QualType Type = VD.getType();
      CGF.EmitOMPCopy(new QualType(Type), new Address(DestAddr), new Address(SrcAddr), DestVar, SrcVar, AssignmentOps.$at(I));
    }
    CGF.FinishFunction();
    return Fn;
  } finally {
    if (CGF != null) { CGF.$destroy(); }
    if (RHSArg != null) { RHSArg.$destroy(); }
    if (LHSArg != null) { LHSArg.$destroy(); }
    if (Args != null) { Args.$destroy(); }
  }
}


/// \brief Map the OpenMP loop schedule to the runtime enumeration.
//<editor-fold defaultstate="collapsed" desc="getRuntimeSchedule">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2363,
 FQN="getRuntimeSchedule", NM="_ZL18getRuntimeScheduleN5clang24OpenMPScheduleClauseKindEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL18getRuntimeScheduleN5clang24OpenMPScheduleClauseKindEbb")
//</editor-fold>
public static /*OpenMPSchedType*//*uint*/int getRuntimeSchedule(/*OpenMPScheduleClauseKind*/int ScheduleKind, 
                  boolean Chunked, boolean Ordered) {
  switch (ScheduleKind) {
   case OpenMPScheduleClauseKind.OMPC_SCHEDULE_static:
    return Chunked ? (Ordered ? OpenMPSchedType.OMP_ord_static_chunked : OpenMPSchedType.OMP_sch_static_chunked) : (Ordered ? OpenMPSchedType.OMP_ord_static : OpenMPSchedType.OMP_sch_static);
   case OpenMPScheduleClauseKind.OMPC_SCHEDULE_dynamic:
    return Ordered ? OpenMPSchedType.OMP_ord_dynamic_chunked : OpenMPSchedType.OMP_sch_dynamic_chunked;
   case OpenMPScheduleClauseKind.OMPC_SCHEDULE_guided:
    return Ordered ? OpenMPSchedType.OMP_ord_guided_chunked : OpenMPSchedType.OMP_sch_guided_chunked;
   case OpenMPScheduleClauseKind.OMPC_SCHEDULE_runtime:
    return Ordered ? OpenMPSchedType.OMP_ord_runtime : OpenMPSchedType.OMP_sch_runtime;
   case OpenMPScheduleClauseKind.OMPC_SCHEDULE_auto:
    return Ordered ? OpenMPSchedType.OMP_ord_auto : OpenMPSchedType.OMP_sch_auto;
   case OpenMPScheduleClauseKind.OMPC_SCHEDULE_unknown:
    assert (!Chunked) : "chunk was specified but schedule kind not known";
    return Ordered ? OpenMPSchedType.OMP_ord_static : OpenMPSchedType.OMP_sch_static;
  }
  throw new llvm_unreachable("Unexpected runtime schedule");
}


/// \brief Map the OpenMP distribute schedule to the runtime enumeration.
//<editor-fold defaultstate="collapsed" desc="getRuntimeSchedule">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2385,
 FQN="getRuntimeSchedule", NM="_ZL18getRuntimeScheduleN5clang28OpenMPDistScheduleClauseKindEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL18getRuntimeScheduleN5clang28OpenMPDistScheduleClauseKindEb")
//</editor-fold>
public static /*OpenMPSchedType*//*uint*/int getRuntimeSchedule(/*OpenMPDistScheduleClauseKind*/int ScheduleKind, boolean Chunked) {
  // only static is allowed for dist_schedule
  return Chunked ? OpenMPSchedType.OMP_dist_sch_static_chunked : OpenMPSchedType.OMP_dist_sch_static;
}

//<editor-fold defaultstate="collapsed" desc="addMonoNonMonoModifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2411,
 FQN="addMonoNonMonoModifier", NM="_ZL22addMonoNonMonoModifierN12_GLOBAL__N_115OpenMPSchedTypeEN5clang28OpenMPScheduleClauseModifierES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL22addMonoNonMonoModifierN12_GLOBAL__N_115OpenMPSchedTypeEN5clang28OpenMPScheduleClauseModifierES2_")
//</editor-fold>
public static int addMonoNonMonoModifier(/*OpenMPSchedType*//*uint*/int Schedule, 
                      /*OpenMPScheduleClauseModifier*/int M1, 
                      /*OpenMPScheduleClauseModifier*/int M2) {
  int Modifier = 0;
  switch (M1) {
   case OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_monotonic:
    Modifier = OpenMPSchedType.OMP_sch_modifier_monotonic;
    break;
   case OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_nonmonotonic:
    Modifier = OpenMPSchedType.OMP_sch_modifier_nonmonotonic;
    break;
   case OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_simd:
    if (Schedule == OpenMPSchedType.OMP_sch_static_chunked) {
      Schedule = OpenMPSchedType.OMP_sch_static_balanced_chunked;
    }
    break;
   case OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_last:
   case OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_unknown:
    break;
  }
  switch (M2) {
   case OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_monotonic:
    Modifier = OpenMPSchedType.OMP_sch_modifier_monotonic;
    break;
   case OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_nonmonotonic:
    Modifier = OpenMPSchedType.OMP_sch_modifier_nonmonotonic;
    break;
   case OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_simd:
    if (Schedule == OpenMPSchedType.OMP_sch_static_chunked) {
      Schedule = OpenMPSchedType.OMP_sch_static_balanced_chunked;
    }
    break;
   case OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_last:
   case OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_unknown:
    break;
  }
  return Schedule | Modifier;
}

//<editor-fold defaultstate="collapsed" desc="emitForStaticInitCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2482,
 FQN="emitForStaticInitCall", NM="_ZL21emitForStaticInitCallRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueES5_PNS3_8ConstantEN12_GLOBAL__N_115OpenMPSchedTypeENS_28OpenMPScheduleClauseModifierESA_jbNS0_7AddressESB_SB_SB_S5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL21emitForStaticInitCallRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueES5_PNS3_8ConstantEN12_GLOBAL__N_115OpenMPSchedTypeENS_28OpenMPScheduleClauseModifierESA_jbNS0_7AddressESB_SB_SB_S5_")
//</editor-fold>
public static void emitForStaticInitCall(final CodeGenFunction /*&*/ CGF, Value /*P*/ UpdateLocation, Value /*P*/ ThreadId, 
                     Constant /*P*/ ForStaticInitFunction, /*OpenMPSchedType*//*uint*/int Schedule, 
                     /*OpenMPScheduleClauseModifier*/int M1, /*OpenMPScheduleClauseModifier*/int M2, 
                     /*uint*/int IVSize, boolean Ordered, Address IL, Address LB, Address UB, 
                     Address ST, Value /*P*/ Chunk) {
  if (!CGF.HaveInsertPoint()) {
    return;
  }
  assert (!Ordered);
  assert (Schedule == OpenMPSchedType.OMP_sch_static || Schedule == OpenMPSchedType.OMP_sch_static_chunked || Schedule == OpenMPSchedType.OMP_sch_static_balanced_chunked || Schedule == OpenMPSchedType.OMP_ord_static || Schedule == OpenMPSchedType.OMP_ord_static_chunked || Schedule == OpenMPSchedType.OMP_dist_sch_static || Schedule == OpenMPSchedType.OMP_dist_sch_static_chunked);
  
  // Call __kmpc_for_static_init(
  //          ident_t *loc, kmp_int32 tid, kmp_int32 schedtype,
  //          kmp_int32 *p_lastiter, kmp_int[32|64] *p_lower,
  //          kmp_int[32|64] *p_upper, kmp_int[32|64] *p_stride,
  //          kmp_int[32|64] incr, kmp_int[32|64] chunk);
  if (Chunk == null) {
    assert ((Schedule == OpenMPSchedType.OMP_sch_static || Schedule == OpenMPSchedType.OMP_ord_static || Schedule == OpenMPSchedType.OMP_dist_sch_static)) : "expected static non-chunked schedule";
    // If the Chunk was not specified in the clause - use default value 1.
    Chunk = CGF.Builder.getIntN(IVSize, $int2ulong(1));
  } else {
    assert ((Schedule == OpenMPSchedType.OMP_sch_static_chunked || Schedule == OpenMPSchedType.OMP_sch_static_balanced_chunked || Schedule == OpenMPSchedType.OMP_ord_static_chunked || Schedule == OpenMPSchedType.OMP_dist_sch_static_chunked)) : "expected static chunked schedule";
  }
  Value /*P*/ Args[/*9*/] = new Value /*P*/  [/*9*/] {
    UpdateLocation, ThreadId, CGF.Builder.getInt32(addMonoNonMonoModifier(Schedule, M1, M2)),  // Schedule type
    IL.getPointer(),  // &isLastIter
    LB.getPointer(),  // &LB
    UB.getPointer(),  // &UB
    ST.getPointer(),  // &Stride
    CGF.Builder.getIntN(IVSize, $int2ulong(1)),  // Incr
    Chunk // Chunk
  };
  CGF.EmitRuntimeCall(ForStaticInitFunction, new ArrayRef<Value /*P*/ >(Args, true));
}


/// \brief Create a Ctor/Dtor-like function whose body is emitted through
/// \a Codegen. This is used to emit the two functions that register and
/// unregister the descriptor of the current compilation unit.
//<editor-fold defaultstate="collapsed" desc="createOffloadingBinaryDescriptorFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2760,
 FQN="createOffloadingBinaryDescriptorFunction", NM="_ZL40createOffloadingBinaryDescriptorFunctionRN5clang7CodeGen13CodeGenModuleEN4llvm9StringRefERKNS0_15RegionCodeGenTyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL40createOffloadingBinaryDescriptorFunctionRN5clang7CodeGen13CodeGenModuleEN4llvm9StringRefERKNS0_15RegionCodeGenTyE")
//</editor-fold>
public static Function /*P*/ createOffloadingBinaryDescriptorFunction(final CodeGenModule /*&*/ CGM, StringRef Name, 
                                        final /*const*/ RegionCodeGenTy /*&*/ Codegen) {
  FunctionArgList Args = null;
  ImplicitParamDecl DummyPtr = null;
  CodeGenFunction CGF = null;
  try {
    final ASTContext /*&*/ C = CGM.getContext();
    Args/*J*/= new FunctionArgList();
    DummyPtr/*J*/= new ImplicitParamDecl(C, /*DC=*/ (DeclContext /*P*/ )null, new SourceLocation(), 
        /*Id=*/ (IdentifierInfo /*P*/ )null, C.VoidPtrTy.$QualType());
    Args.push_back($AddrOf(DummyPtr));
    
    CGF/*J*/= new CodeGenFunction(CGM);
    new GlobalDecl();
    final /*const*/ CGFunctionInfo /*&*/ FI = CGM.getTypes().arrangeBuiltinFunctionDeclaration(C.VoidTy.$QualType(), Args);
    org.llvm.ir.FunctionType /*P*/ FTy = CGM.getTypes().GetFunctionType(FI);
    Function /*P*/ Fn = CGM.CreateGlobalInitOrDestructFunction(FTy, new Twine(Name), FI, new SourceLocation());
    CGF.StartFunction(new GlobalDecl(), C.VoidTy.$QualType(), Fn, FI, Args, new SourceLocation());
    Codegen.$call(CGF);
    CGF.FinishFunction();
    return Fn;
  } finally {
    if (CGF != null) { CGF.$destroy(); }
    if (DummyPtr != null) { DummyPtr.$destroy(); }
    if (Args != null) { Args.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="addFieldToRecordDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3065,
 FQN="addFieldToRecordDecl", NM="_ZL20addFieldToRecordDeclRN5clang10ASTContextEPNS_11DeclContextENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL20addFieldToRecordDeclRN5clang10ASTContextEPNS_11DeclContextENS_8QualTypeE")
//</editor-fold>
public static FieldDecl /*P*/ addFieldToRecordDecl(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
                    QualType FieldTy) {
  FieldDecl /*P*/ Field = FieldDecl.Create(C, DC, new SourceLocation(), new SourceLocation(), /*Id=*/ (IdentifierInfo /*P*/ )null, new QualType(FieldTy), 
      C.getTrivialTypeSourceInfo(/*NO_COPY*/FieldTy, new SourceLocation()), 
      /*BW=*/ (Expr /*P*/ )null, /*Mutable=*/ false, /*InitStyle=*/ InClassInitStyle.ICIS_NoInit);
  Field.setAccess(AccessSpecifier.AS_public);
  DC.addDecl(Field);
  return Field;
}

// anonymous namespace
//<editor-fold defaultstate="collapsed" desc="createPrivatesRecordDecl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3163,
 FQN="createPrivatesRecordDecl", NM="_ZL24createPrivatesRecordDeclRN5clang7CodeGen13CodeGenModuleEN4llvm8ArrayRefISt4pairINS_9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL24createPrivatesRecordDeclRN5clang7CodeGen13CodeGenModuleEN4llvm8ArrayRefISt4pairINS_9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEEEE")
//</editor-fold>
public static RecordDecl /*P*/ createPrivatesRecordDecl(final CodeGenModule /*&*/ CGM, ArrayRef<std.pairTypeType<CharUnits, PrivateHelpersTy>> Privates) {
  if (!Privates.empty()) {
    final ASTContext /*&*/ C = CGM.getContext();
    // Build struct .kmp_privates_t. {
    //         /*  private vars  */
    //       };
    RecordDecl /*P*/ RD = C.buildImplicitRecord(new StringRef(/*KEEP_STR*/".kmp_privates.t"));
    RD.startDefinition();
    for (final /*const*/std.pairTypeType<CharUnits, PrivateHelpersTy> /*&*/ Pair : Privates) {
      /*const*/ VarDecl /*P*/ VD = Pair.second.Original;
      QualType Type = VD.getType();
      Type.$assignMove(Type.getNonReferenceType());
      FieldDecl /*P*/ FD = addFieldToRecordDecl(C, RD, new QualType(Type));
      if (VD.hasAttrs()) {
        for (specific_attr_iterator<AlignedAttr> I/*J*/= new specific_attr_iterator<AlignedAttr>(AlignedAttr.class, VD.getAttrs$Const().begin$Const()), 
            E/*J*/= new specific_attr_iterator<AlignedAttr>(AlignedAttr.class, VD.getAttrs$Const().end$Const());
             specific_attr_iterator.$noteq_specific_attr_iterator$SpecificAttr(/*NO_COPY*/I, /*NO_COPY*/E); I.$preInc())  {
          FD.addAttr(I.$star());
        }
      }
    }
    RD.completeDefinition();
    return RD;
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="createKmpTaskTRecordDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3190,
 FQN="createKmpTaskTRecordDecl", NM="_ZL24createKmpTaskTRecordDeclRN5clang7CodeGen13CodeGenModuleENS_19OpenMPDirectiveKindENS_8QualTypeES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL24createKmpTaskTRecordDeclRN5clang7CodeGen13CodeGenModuleENS_19OpenMPDirectiveKindENS_8QualTypeES4_")
//</editor-fold>
public static RecordDecl /*P*/ createKmpTaskTRecordDecl(final CodeGenModule /*&*/ CGM, OpenMPDirectiveKind Kind, 
                        QualType KmpInt32Ty, 
                        QualType KmpRoutineEntryPointerQTy) {
  final ASTContext /*&*/ C = CGM.getContext();
  // Build struct kmp_task_t {
  //         void *              shareds;
  //         kmp_routine_entry_t routine;
  //         kmp_int32           part_id;
  //         kmp_cmplrdata_t data1;
  //         kmp_cmplrdata_t data2;
  // For taskloops additional fields:
  //         kmp_uint64          lb;
  //         kmp_uint64          ub;
  //         kmp_int64           st;
  //         kmp_int32           liter;
  //       };
  RecordDecl /*P*/ UD = C.buildImplicitRecord(new StringRef(/*KEEP_STR*/"kmp_cmplrdata_t"), TagTypeKind.TTK_Union);
  UD.startDefinition();
  addFieldToRecordDecl(C, UD, new QualType(KmpInt32Ty));
  addFieldToRecordDecl(C, UD, new QualType(KmpRoutineEntryPointerQTy));
  UD.completeDefinition();
  QualType KmpCmplrdataTy = C.getRecordType(UD);
  RecordDecl /*P*/ RD = C.buildImplicitRecord(new StringRef(/*KEEP_STR*/"kmp_task_t"));
  RD.startDefinition();
  addFieldToRecordDecl(C, RD, C.VoidPtrTy.$QualType());
  addFieldToRecordDecl(C, RD, new QualType(KmpRoutineEntryPointerQTy));
  addFieldToRecordDecl(C, RD, new QualType(KmpInt32Ty));
  addFieldToRecordDecl(C, RD, new QualType(KmpCmplrdataTy));
  addFieldToRecordDecl(C, RD, new QualType(KmpCmplrdataTy));
  if (isOpenMPTaskLoopDirective(Kind)) {
    QualType KmpUInt64Ty = CGM.getContext().getIntTypeForBitwidth(/*DestWidth=*/ 64, /*Signed=*/ 0);
    QualType KmpInt64Ty = CGM.getContext().getIntTypeForBitwidth(/*DestWidth=*/ 64, /*Signed=*/ 1);
    addFieldToRecordDecl(C, RD, new QualType(KmpUInt64Ty));
    addFieldToRecordDecl(C, RD, new QualType(KmpUInt64Ty));
    addFieldToRecordDecl(C, RD, new QualType(KmpInt64Ty));
    addFieldToRecordDecl(C, RD, new QualType(KmpInt32Ty));
  }
  RD.completeDefinition();
  return RD;
}

//<editor-fold defaultstate="collapsed" desc="createKmpTaskTWithPrivatesRecordDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3234,
 FQN="createKmpTaskTWithPrivatesRecordDecl", NM="_ZL36createKmpTaskTWithPrivatesRecordDeclRN5clang7CodeGen13CodeGenModuleENS_8QualTypeEN4llvm8ArrayRefISt4pairINS_9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL36createKmpTaskTWithPrivatesRecordDeclRN5clang7CodeGen13CodeGenModuleENS_8QualTypeEN4llvm8ArrayRefISt4pairINS_9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEEEE")
//</editor-fold>
public static RecordDecl /*P*/ createKmpTaskTWithPrivatesRecordDecl(final CodeGenModule /*&*/ CGM, QualType KmpTaskTQTy, 
                                    ArrayRef<std.pairTypeType<CharUnits, PrivateHelpersTy>> Privates) {
  final ASTContext /*&*/ C = CGM.getContext();
  // Build struct kmp_task_t_with_privates {
  //         kmp_task_t task_data;
  //         .kmp_privates_t. privates;
  //       };
  RecordDecl /*P*/ RD = C.buildImplicitRecord(new StringRef(/*KEEP_STR*/"kmp_task_t_with_privates"));
  RD.startDefinition();
  addFieldToRecordDecl(C, RD, new QualType(KmpTaskTQTy));
  {
    RecordDecl /*P*/ PrivateRD = createPrivatesRecordDecl(CGM, new ArrayRef<std.pairTypeType<CharUnits, PrivateHelpersTy>>(Privates));
    if ((PrivateRD != null)) {
      addFieldToRecordDecl(C, RD, C.getRecordType(PrivateRD));
    }
  }
  RD.completeDefinition();
  return RD;
}


/// \brief Emit a proxy function which accepts kmp_task_t as the second
/// argument.
/// \code
/// kmp_int32 .omp_task_entry.(kmp_int32 gtid, kmp_task_t *tt) {
///   TaskFunction(gtid, tt->part_id, &tt->privates, task_privates_map, tt,
///   For taskloops:
///   tt->task_data.lb, tt->task_data.ub, tt->task_data.st, tt->task_data.liter,
///   tt->shareds);
///   return 0;
/// }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="emitProxyTaskFunction">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3263,
 FQN="emitProxyTaskFunction", NM="_ZL21emitProxyTaskFunctionRN5clang7CodeGen13CodeGenModuleENS_14SourceLocationENS_19OpenMPDirectiveKindENS_8QualTypeES5_S5_S5_S5_PN4llvm5ValueES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL21emitProxyTaskFunctionRN5clang7CodeGen13CodeGenModuleENS_14SourceLocationENS_19OpenMPDirectiveKindENS_8QualTypeES5_S5_S5_S5_PN4llvm5ValueES8_")
//</editor-fold>
public static Value /*P*/ emitProxyTaskFunction(final CodeGenModule /*&*/ CGM, SourceLocation Loc, 
                     OpenMPDirectiveKind Kind, QualType KmpInt32Ty, 
                     QualType KmpTaskTWithPrivatesPtrQTy, 
                     QualType KmpTaskTWithPrivatesQTy, QualType KmpTaskTQTy, 
                     QualType SharedsPtrTy, Value /*P*/ TaskFunction, 
                     Value /*P*/ TaskPrivatesMap) {
  FunctionArgList Args = null;
  ImplicitParamDecl GtidArg = null;
  ImplicitParamDecl TaskTypeArg = null;
  CodeGenFunction CGF = null;
  try {
    final ASTContext /*&*/ C = CGM.getContext();
    Args/*J*/= new FunctionArgList();
    GtidArg/*J*/= new ImplicitParamDecl(C, /*DC=*/ (DeclContext /*P*/ )null, new SourceLocation(Loc), /*Id=*/ (IdentifierInfo /*P*/ )null, new QualType(KmpInt32Ty));
    TaskTypeArg/*J*/= new ImplicitParamDecl(C, /*DC=*/ (DeclContext /*P*/ )null, new SourceLocation(Loc), 
        /*Id=*/ (IdentifierInfo /*P*/ )null, 
        KmpTaskTWithPrivatesPtrQTy.withRestrict());
    Args.push_back($AddrOf(GtidArg));
    Args.push_back($AddrOf(TaskTypeArg));
    final /*const*/ CGFunctionInfo /*&*/ TaskEntryFnInfo = CGM.getTypes().arrangeBuiltinFunctionDeclaration(new QualType(KmpInt32Ty), Args);
    org.llvm.ir.FunctionType /*P*/ TaskEntryTy = CGM.getTypes().GetFunctionType(TaskEntryFnInfo);
    Function /*P*/ TaskEntry = Function.Create(TaskEntryTy, GlobalValue.LinkageTypes.InternalLinkage, 
        new Twine(/*KEEP_STR*/".omp_task_entry."), $AddrOf(CGM.getModule()));
    CGM.SetInternalFunctionAttributes(/*D=*/ (/*const*/ Decl /*P*/ )null, TaskEntry, TaskEntryFnInfo);
    CGF/*J*/= new CodeGenFunction(CGM);
    CGF.disableDebugInfo();
    CGF.StartFunction(new GlobalDecl(), new QualType(KmpInt32Ty), TaskEntry, TaskEntryFnInfo, Args);
    
    // TaskFunction(gtid, tt->task_data.part_id, &tt->privates, task_privates_map,
    // tt,
    // For taskloops:
    // tt->task_data.lb, tt->task_data.ub, tt->task_data.st, tt->task_data.liter,
    // tt->task_data.shareds);
    Value /*P*/ GtidParam = CGF.EmitLoadOfScalar(CGF.GetAddrOfLocalVar($AddrOf(GtidArg)), /*Volatile=*/ false, new QualType(KmpInt32Ty), new SourceLocation(Loc));
    LValue TDBase = CGF.EmitLoadOfPointerLValue(CGF.GetAddrOfLocalVar($AddrOf(TaskTypeArg)), 
        KmpTaskTWithPrivatesPtrQTy.$arrow().castAs(org.clang.ast.PointerType.class));
    RecordDecl /*P*/ KmpTaskTWithPrivatesQTyRD = cast_RecordDecl(KmpTaskTWithPrivatesQTy.$arrow().getAsTagDecl());
    LValue Base = CGF.EmitLValueForField(new LValue(TDBase), KmpTaskTWithPrivatesQTyRD.field_begin().$star());
    RecordDecl /*P*/ KmpTaskTQTyRD = cast_RecordDecl(KmpTaskTQTy.$arrow().getAsTagDecl());
    DeclContext.specific_decl_iterator<FieldDecl> PartIdFI = std.next(KmpTaskTQTyRD.field_begin(), KmpTaskTFields.KmpTaskTPartId.getValue());
    LValue PartIdLVal = CGF.EmitLValueForField(new LValue(Base), PartIdFI.$star());
    Value /*P*/ PartidParam = PartIdLVal.getPointer();
    
    DeclContext.specific_decl_iterator<FieldDecl> SharedsFI = std.next(KmpTaskTQTyRD.field_begin(), KmpTaskTFields.KmpTaskTShareds.getValue());
    LValue SharedsLVal = CGF.EmitLValueForField(new LValue(Base), SharedsFI.$star());
    Value /*P*/ SharedsParam = CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(CGF.EmitLoadOfLValue(new LValue(SharedsLVal), new SourceLocation(Loc)).getScalarVal(), 
        CGF.ConvertTypeForMem(new QualType(SharedsPtrTy)));
    
    DeclContext.specific_decl_iterator<FieldDecl> PrivatesFI = std.next(KmpTaskTWithPrivatesQTyRD.field_begin(), 1);
    Value /*P*/ PrivatesParam;
    if (specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(PrivatesFI, KmpTaskTWithPrivatesQTyRD.field_end())) {
      LValue PrivatesLVal = CGF.EmitLValueForField(new LValue(TDBase), PrivatesFI.$star());
      PrivatesParam = CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(PrivatesLVal.getPointer(), CGF.Unnamed_field9.VoidPtrTy);
    } else {
      PrivatesParam = ConstantPointerNull.get(CGF.Unnamed_field9.VoidPtrTy);
    }
    
    Value /*P*/ CommonArgs[/*5*/] = new Value /*P*/  [/*5*/] {
      GtidParam, PartidParam, PrivatesParam, 
      TaskPrivatesMap, 
      CGF.Builder.
          CreatePointerBitCastOrAddrSpaceCast(TDBase.getAddress(), CGF.Unnamed_field9.VoidPtrTy).
          getPointer()
    };
    SmallVector<Value /*P*/ > CallArgs/*J*/= new SmallVector<Value /*P*/ >(JD$T.INSTANCE, 16, std.begin(CommonArgs), 
        std.end(CommonArgs), (Value /*P*/ )null);
    if (isOpenMPTaskLoopDirective(Kind)) {
      DeclContext.specific_decl_iterator<FieldDecl> LBFI = std.next(KmpTaskTQTyRD.field_begin(), KmpTaskTFields.KmpTaskTLowerBound.getValue());
      LValue LBLVal = CGF.EmitLValueForField(new LValue(Base), LBFI.$star());
      Value /*P*/ LBParam = CGF.EmitLoadOfLValue(new LValue(LBLVal), new SourceLocation(Loc)).getScalarVal();
      DeclContext.specific_decl_iterator<FieldDecl> UBFI = std.next(KmpTaskTQTyRD.field_begin(), KmpTaskTFields.KmpTaskTUpperBound.getValue());
      LValue UBLVal = CGF.EmitLValueForField(new LValue(Base), UBFI.$star());
      Value /*P*/ UBParam = CGF.EmitLoadOfLValue(new LValue(UBLVal), new SourceLocation(Loc)).getScalarVal();
      DeclContext.specific_decl_iterator<FieldDecl> StFI = std.next(KmpTaskTQTyRD.field_begin(), KmpTaskTFields.KmpTaskTStride.getValue());
      LValue StLVal = CGF.EmitLValueForField(new LValue(Base), StFI.$star());
      Value /*P*/ StParam = CGF.EmitLoadOfLValue(new LValue(StLVal), new SourceLocation(Loc)).getScalarVal();
      DeclContext.specific_decl_iterator<FieldDecl> LIFI = std.next(KmpTaskTQTyRD.field_begin(), KmpTaskTFields.KmpTaskTLastIter.getValue());
      LValue LILVal = CGF.EmitLValueForField(new LValue(Base), LIFI.$star());
      Value /*P*/ LIParam = CGF.EmitLoadOfLValue(new LValue(LILVal), new SourceLocation(Loc)).getScalarVal();
      CallArgs.push_back(LBParam);
      CallArgs.push_back(UBParam);
      CallArgs.push_back(StParam);
      CallArgs.push_back(LIParam);
    }
    CallArgs.push_back(SharedsParam);
    
    CGF.EmitCallOrInvoke(TaskFunction, new ArrayRef<Value /*P*/ >(CallArgs, true));
    CGF.EmitStoreThroughLValue(RValue.get(CGF.Builder.getInt32(/*C=*/ 0)), 
        CGF.MakeAddrLValue(new Address(CGF.ReturnValue), new QualType(KmpInt32Ty)));
    CGF.FinishFunction();
    return TaskEntry;
  } finally {
    if (CGF != null) { CGF.$destroy(); }
    if (TaskTypeArg != null) { TaskTypeArg.$destroy(); }
    if (GtidArg != null) { GtidArg.$destroy(); }
    if (Args != null) { Args.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="emitDestructorsFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3359,
 FQN="emitDestructorsFunction", NM="_ZL23emitDestructorsFunctionRN5clang7CodeGen13CodeGenModuleENS_14SourceLocationENS_8QualTypeES4_S4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL23emitDestructorsFunctionRN5clang7CodeGen13CodeGenModuleENS_14SourceLocationENS_8QualTypeES4_S4_")
//</editor-fold>
public static Value /*P*/ emitDestructorsFunction(final CodeGenModule /*&*/ CGM, 
                       SourceLocation Loc, 
                       QualType KmpInt32Ty, 
                       QualType KmpTaskTWithPrivatesPtrQTy, 
                       QualType KmpTaskTWithPrivatesQTy) {
  FunctionArgList Args = null;
  ImplicitParamDecl GtidArg = null;
  ImplicitParamDecl TaskTypeArg = null;
  CodeGenFunction CGF = null;
  try {
    final ASTContext /*&*/ C = CGM.getContext();
    Args/*J*/= new FunctionArgList();
    GtidArg/*J*/= new ImplicitParamDecl(C, /*DC=*/ (DeclContext /*P*/ )null, new SourceLocation(Loc), /*Id=*/ (IdentifierInfo /*P*/ )null, new QualType(KmpInt32Ty));
    TaskTypeArg/*J*/= new ImplicitParamDecl(C, /*DC=*/ (DeclContext /*P*/ )null, new SourceLocation(Loc), 
        /*Id=*/ (IdentifierInfo /*P*/ )null, 
        KmpTaskTWithPrivatesPtrQTy.withRestrict());
    Args.push_back($AddrOf(GtidArg));
    Args.push_back($AddrOf(TaskTypeArg));
    org.clang.ast.FunctionType.ExtInfo Info/*J*/= new org.clang.ast.FunctionType.ExtInfo();
    final /*const*/ CGFunctionInfo /*&*/ DestructorFnInfo = CGM.getTypes().arrangeBuiltinFunctionDeclaration(new QualType(KmpInt32Ty), Args);
    org.llvm.ir.FunctionType /*P*/ DestructorFnTy = CGM.getTypes().GetFunctionType(DestructorFnInfo);
    Function /*P*/ DestructorFn = Function.Create(DestructorFnTy, GlobalValue.LinkageTypes.InternalLinkage, 
        new Twine(/*KEEP_STR*/".omp_task_destructor."), $AddrOf(CGM.getModule()));
    CGM.SetInternalFunctionAttributes(/*D=*/ (/*const*/ Decl /*P*/ )null, DestructorFn, 
        DestructorFnInfo);
    CGF/*J*/= new CodeGenFunction(CGM);
    CGF.disableDebugInfo();
    CGF.StartFunction(new GlobalDecl(), new QualType(KmpInt32Ty), DestructorFn, DestructorFnInfo, 
        Args);
    
    LValue Base = CGF.EmitLoadOfPointerLValue(CGF.GetAddrOfLocalVar($AddrOf(TaskTypeArg)), 
        KmpTaskTWithPrivatesPtrQTy.$arrow().castAs(org.clang.ast.PointerType.class));
    RecordDecl /*P*/ KmpTaskTWithPrivatesQTyRD = cast_RecordDecl(KmpTaskTWithPrivatesQTy.$arrow().getAsTagDecl());
    DeclContext.specific_decl_iterator<FieldDecl> FI = std.next(KmpTaskTWithPrivatesQTyRD.field_begin());
    Base.$assignMove(CGF.EmitLValueForField(new LValue(Base), FI.$star()));
    for (FieldDecl /*P*/ Field : cast_RecordDecl(FI.$arrow().getType().$arrow().getAsTagDecl()).fields()) {
      {
        QualType.DestructionKind DtorKind = Field.getType().isDestructedType();
        if ((DtorKind.getValue() != 0)) {
          LValue FieldLValue = CGF.EmitLValueForField(new LValue(Base), Field);
          CGF.pushDestroy(DtorKind, FieldLValue.getAddress(), Field.getType());
        }
      }
    }
    CGF.FinishFunction();
    return DestructorFn;
  } finally {
    if (CGF != null) { CGF.$destroy(); }
    if (TaskTypeArg != null) { TaskTypeArg.$destroy(); }
    if (GtidArg != null) { GtidArg.$destroy(); }
    if (Args != null) { Args.$destroy(); }
  }
}


/// \brief Emit a privates mapping function for correct handling of private and
/// firstprivate variables.
/// \code
/// void .omp_task_privates_map.(const .privates. *noalias privs, <ty1>
/// **noalias priv1,...,  <tyn> **noalias privn) {
///   *priv1 = &.privates.priv1;
///   ...;
///   *privn = &.privates.privn;
/// }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="emitTaskPrivateMappingFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3414,
 FQN="emitTaskPrivateMappingFunction", NM="_ZL30emitTaskPrivateMappingFunctionRN5clang7CodeGen13CodeGenModuleENS_14SourceLocationEN4llvm8ArrayRefIPKNS_4ExprEEES9_S9_NS_8QualTypeENS5_ISt4pairINS_9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL30emitTaskPrivateMappingFunctionRN5clang7CodeGen13CodeGenModuleENS_14SourceLocationEN4llvm8ArrayRefIPKNS_4ExprEEES9_S9_NS_8QualTypeENS5_ISt4pairINS_9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEEEE")
//</editor-fold>
public static Value /*P*/ emitTaskPrivateMappingFunction(final CodeGenModule /*&*/ CGM, SourceLocation Loc, 
                              ArrayRef</*const*/ Expr /*P*/ > PrivateVars, 
                              ArrayRef</*const*/ Expr /*P*/ > FirstprivateVars, 
                              ArrayRef</*const*/ Expr /*P*/ > LastprivateVars, 
                              QualType PrivatesQTy, 
                              ArrayRef<std.pairTypeType<CharUnits, PrivateHelpersTy>> Privates) {
  FunctionArgList Args = null;
  ImplicitParamDecl TaskPrivatesArg = null;
  CodeGenFunction CGF = null;
  try {
    final ASTContext /*&*/ C = CGM.getContext();
    Args/*J*/= new FunctionArgList();
    TaskPrivatesArg/*J*/= new ImplicitParamDecl(C, /*DC=*/ (DeclContext /*P*/ )null, new SourceLocation(Loc), /*Id=*/ (IdentifierInfo /*P*/ )null, 
        C.getPointerType(/*NO_COPY*/PrivatesQTy).withConst().withRestrict());
    Args.push_back($AddrOf(TaskPrivatesArg));
    DenseMapTypeUInt</*const*/ VarDecl /*P*/ > PrivateVarsPos/*J*/= new DenseMapTypeUInt</*const*/ VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    /*uint*/int Counter = 1;
    for (/*const*/ Expr /*P*/ E : PrivateVars) {
      Args.push_back(ImplicitParamDecl.Create(C, /*DC=*/ (DeclContext /*P*/ )null, new SourceLocation(Loc), 
              /*Id=*/ (IdentifierInfo /*P*/ )null, C.getPointerType(C.getPointerType(E.getType())).
                  withConst().
                  withRestrict()));
      /*const*/ VarDecl /*P*/ VD = cast_VarDecl(cast_DeclRefExpr(E).getDecl$Const());
      PrivateVarsPos.$set(VD, Counter);
      ++Counter;
    }
    for (/*const*/ Expr /*P*/ E : FirstprivateVars) {
      Args.push_back(ImplicitParamDecl.Create(C, /*DC=*/ (DeclContext /*P*/ )null, new SourceLocation(Loc), 
              /*Id=*/ (IdentifierInfo /*P*/ )null, C.getPointerType(C.getPointerType(E.getType())).
                  withConst().
                  withRestrict()));
      /*const*/ VarDecl /*P*/ VD = cast_VarDecl(cast_DeclRefExpr(E).getDecl$Const());
      PrivateVarsPos.$set(VD, Counter);
      ++Counter;
    }
    for (/*const*/ Expr /*P*/ E : LastprivateVars) {
      Args.push_back(ImplicitParamDecl.Create(C, /*DC=*/ (DeclContext /*P*/ )null, new SourceLocation(Loc), 
              /*Id=*/ (IdentifierInfo /*P*/ )null, C.getPointerType(C.getPointerType(E.getType())).
                  withConst().
                  withRestrict()));
      /*const*/ VarDecl /*P*/ VD = cast_VarDecl(cast_DeclRefExpr(E).getDecl$Const());
      PrivateVarsPos.$set(VD, Counter);
      ++Counter;
    }
    final /*const*/ CGFunctionInfo /*&*/ TaskPrivatesMapFnInfo = CGM.getTypes().arrangeBuiltinFunctionDeclaration(C.VoidTy.$QualType(), Args);
    org.llvm.ir.FunctionType /*P*/ TaskPrivatesMapTy = CGM.getTypes().GetFunctionType(TaskPrivatesMapFnInfo);
    Function /*P*/ TaskPrivatesMap = Function.Create(TaskPrivatesMapTy, GlobalValue.LinkageTypes.InternalLinkage, 
        new Twine(/*KEEP_STR*/".omp_task_privates_map."), $AddrOf(CGM.getModule()));
    CGM.SetInternalFunctionAttributes(/*D=*/ (/*const*/ Decl /*P*/ )null, TaskPrivatesMap, 
        TaskPrivatesMapFnInfo);
    TaskPrivatesMap.addFnAttr(Attribute.AttrKind.AlwaysInline);
    CGF/*J*/= new CodeGenFunction(CGM);
    CGF.disableDebugInfo();
    CGF.StartFunction(new GlobalDecl(), C.VoidTy.$QualType(), TaskPrivatesMap, 
        TaskPrivatesMapFnInfo, Args);
    
    // *privi = &.privates.privi;
    LValue Base = CGF.EmitLoadOfPointerLValue(CGF.GetAddrOfLocalVar($AddrOf(TaskPrivatesArg)), 
        TaskPrivatesArg.getType().$arrow().castAs(org.clang.ast.PointerType.class));
    RecordDecl /*P*/ PrivatesQTyRD = cast_RecordDecl(PrivatesQTy.$arrow().getAsTagDecl());
    Counter = 0;
    for (FieldDecl /*P*/ Field : PrivatesQTyRD.fields()) {
      LValue FieldLVal = CGF.EmitLValueForField(new LValue(Base), Field);
      /*const*/ VarDecl /*P*/ VD = Args.$at(PrivateVarsPos.$at_T1$C$R(Privates.$at(Counter).second.Original));
      LValue RefLVal = CGF.MakeAddrLValue(CGF.GetAddrOfLocalVar(VD), VD.getType());
      LValue RefLoadLVal = CGF.EmitLoadOfPointerLValue(RefLVal.getAddress(), RefLVal.getType().$arrow().castAs(org.clang.ast.PointerType.class));
      CGF.EmitStoreOfScalar(FieldLVal.getPointer(), new LValue(RefLoadLVal));
      ++Counter;
    }
    CGF.FinishFunction();
    return TaskPrivatesMap;
  } finally {
    if (CGF != null) { CGF.$destroy(); }
    if (TaskPrivatesArg != null) { TaskPrivatesArg.$destroy(); }
    if (Args != null) { Args.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="array_pod_sort_comparator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3493,
 FQN="array_pod_sort_comparator", NM="_ZL25array_pod_sort_comparatorPKSt4pairIN5clang9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL25array_pod_sort_comparatorPKSt4pairIN5clang9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEES6_")
//</editor-fold>
public static int array_pod_sort_comparator(/*const*/std.pairTypeType<CharUnits, PrivateHelpersTy> /*P*/ P1, 
                         /*const*/std.pairTypeType<CharUnits, PrivateHelpersTy> /*P*/ P2) {
  return P1.first.$less(P2.first) ? 1 : (P2.first.$less(P1.first) ? -1 : 0);
}


/// Emit initialization for private variables in task-based directives.
//<editor-fold defaultstate="collapsed" desc="emitPrivatesInit">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3499,
 FQN="emitPrivatesInit", NM="_ZL16emitPrivatesInitRN5clang7CodeGen15CodeGenFunctionERKNS_22OMPExecutableDirectiveENS0_7AddressENS0_6LValueEPKNS_10RecordDeclENS_8QualTypeESB_RKNS0_13OMPTaskDataTyEN4llvm8ArrayRefISt4pairINS_9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL16emitPrivatesInitRN5clang7CodeGen15CodeGenFunctionERKNS_22OMPExecutableDirectiveENS0_7AddressENS0_6LValueEPKNS_10RecordDeclENS_8QualTypeESB_RKNS0_13OMPTaskDataTyEN4llvm8ArrayRefISt4pairINS_9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEEEEb")
//</editor-fold>
public static void emitPrivatesInit(final CodeGenFunction /*&*/ CGF, 
                final /*const*/ OMPExecutableDirective /*&*/ D, 
                Address KmpTaskSharedsPtr, LValue TDBase, 
                /*const*/ RecordDecl /*P*/ KmpTaskTWithPrivatesQTyRD, 
                QualType SharedsTy, QualType SharedsPtrTy, 
                final /*const*/ OMPTaskDataTy /*&*/ Data, 
                ArrayRef<std.pairTypeType<CharUnits, PrivateHelpersTy>> Privates, boolean ForDup) {
  CodeGenFunction.CGCapturedStmtInfo CapturesInfo = null;
  try {
    final ASTContext /*&*/ C = CGF.getContext();
    DeclContext.specific_decl_iterator<FieldDecl> FI = std.next(KmpTaskTWithPrivatesQTyRD.field_begin());
    LValue PrivatesBase = CGF.EmitLValueForField(new LValue(TDBase), FI.$star());
    LValue SrcBase/*J*/= new LValue();
    if (!Data.FirstprivateVars.empty()) {
      SrcBase.$assignMove(CGF.MakeAddrLValue(CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(new Address(KmpTaskSharedsPtr), CGF.ConvertTypeForMem(new QualType(SharedsPtrTy))), 
              new QualType(SharedsTy)));
    }
    CapturesInfo/*J*/= new CodeGenFunction.CGCapturedStmtInfo(cast_CapturedStmt($Deref(D.getAssociatedStmt())));
    FI.$assignMove(cast_RecordDecl(FI.$arrow().getType().$arrow().getAsTagDecl()).field_begin());
    for (final /*const*/std.pairTypeType<CharUnits, PrivateHelpersTy> /*&*/ Pair : Privates) {
      /*const*/ VarDecl /*P*/ VD = Pair.second.PrivateCopy;
      /*const*/ Expr /*P*/ Init = VD.getAnyInitializer();
      if ((Init != null) && (!ForDup || (isa_CXXConstructExpr(Init)
         && !CGF.isTrivialInitializer(Init)))) {
        LValue PrivateLValue = CGF.EmitLValueForField(new LValue(PrivatesBase), FI.$star());
        {
          /*const*/ VarDecl /*P*/ Elem = Pair.second.PrivateElemInit;
          if ((Elem != null)) {
            /*const*/ VarDecl /*P*/ OriginalVD = Pair.second.Original;
            /*const*/ FieldDecl /*P*/ SharedField = CapturesInfo.lookup(OriginalVD);
            final LValue SharedRefLValue = CGF.EmitLValueForField(new LValue(SrcBase), SharedField);
            SharedRefLValue.$assignMove(CGF.MakeAddrLValue(new Address(SharedRefLValue.getPointer(), C.getDeclAlign(OriginalVD)), 
                    SharedRefLValue.getType(), AlignmentSource.Decl));
            QualType Type = OriginalVD.getType();
            if (Type.$arrow().isArrayType()) {
              // Initialize firstprivate array.
              if (!isa_CXXConstructExpr(Init) || CGF.isTrivialInitializer(Init)) {
                // Perform simple memcpy.
                CGF.EmitAggregateAssign(PrivateLValue.getAddress(), 
                    SharedRefLValue.getAddress(), new QualType(Type));
              } else {
                // Initialize firstprivate array using element-by-element
                // intialization.
                CodeGenFunction.CGCapturedStmtInfo $CapturesInfo = CapturesInfo;
                CGF.EmitOMPAggregateAssign(PrivateLValue.getAddress(), SharedRefLValue.getAddress(), new QualType(Type), 
                    /*FuncArg*//*[&CGF, =L$Elem(Elem), =L$Init(Init), &CapturesInfo]*/ (Address DestElement, Address SrcElement) -> {
                          CodeGenFunction.OMPPrivateScope InitScope = null;
                          CodeGenFunction.CGCapturedStmtRAII CapInfoRAII = null;
                          try {
                            // Clean up any temporaries needed by the initialization.
                            InitScope/*J*/= new CodeGenFunction.OMPPrivateScope(CGF);
                            InitScope.addPrivate(Elem, /*FuncArg*//*[=L$SrcElement(SrcElement)]*/ () -> {
                                      return new Address(SrcElement);
                                    });
                            /*J:(void)*/InitScope.Privatize();
                            // Emit initialization for single element.
                            CapInfoRAII/*J*/= new CodeGenFunction.CGCapturedStmtRAII(CGF, $AddrOf($CapturesInfo));
                            CGF.EmitAnyExprToMem(Init, new Address(DestElement), 
                                Init.getType().getQualifiers(), 
                                /*IsInitializer=*/ false);
                          } finally {
                            if (CapInfoRAII != null) { CapInfoRAII.$destroy(); }
                            if (InitScope != null) { InitScope.$destroy(); }
                          }
                        });
              }
            } else {
              CodeGenFunction.OMPPrivateScope InitScope = null;
              CodeGenFunction.CGCapturedStmtRAII CapInfoRAII = null;
              try {
                InitScope/*J*/= new CodeGenFunction.OMPPrivateScope(CGF);
                InitScope.addPrivate(Elem, /*FuncArg*//*[=L$SharedRefLValue(SharedRefLValue)]*/ () -> {
                          return SharedRefLValue.getAddress();
                        });
                /*J:(void)*/InitScope.Privatize();
                CapInfoRAII/*J*/= new CodeGenFunction.CGCapturedStmtRAII(CGF, $AddrOf(CapturesInfo));
                CGF.EmitExprAsInit(Init, VD, new LValue(PrivateLValue), 
                    /*capturedByInit=*/ false);
              } finally {
                if (CapInfoRAII != null) { CapInfoRAII.$destroy(); }
                if (InitScope != null) { InitScope.$destroy(); }
              }
            }
          } else {
            CGF.EmitExprAsInit(Init, VD, new LValue(PrivateLValue), /*capturedByInit=*/ false);
          }
        }
      }
      FI.$preInc();
    }
  } finally {
    if (CapturesInfo != null) { CapturesInfo.$destroy(); }
  }
}


/// Check if duplication function is required for taskloops.
//<editor-fold defaultstate="collapsed" desc="checkInitIsRequired">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3577,
 FQN="checkInitIsRequired", NM="_ZL19checkInitIsRequiredRN5clang7CodeGen15CodeGenFunctionEN4llvm8ArrayRefISt4pairINS_9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL19checkInitIsRequiredRN5clang7CodeGen15CodeGenFunctionEN4llvm8ArrayRefISt4pairINS_9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEEEE")
//</editor-fold>
public static boolean checkInitIsRequired(final CodeGenFunction /*&*/ CGF, 
                   ArrayRef<std.pairTypeType<CharUnits, PrivateHelpersTy>> Privates) {
  boolean InitRequired = false;
  for (final /*const*/std.pairTypeType<CharUnits, PrivateHelpersTy> /*&*/ Pair : Privates) {
    /*const*/ VarDecl /*P*/ VD = Pair.second.PrivateCopy;
    /*const*/ Expr /*P*/ Init = VD.getAnyInitializer();
    InitRequired = InitRequired || ((Init != null) && isa_CXXConstructExpr(Init)
       && !CGF.isTrivialInitializer(Init));
  }
  return InitRequired;
}


/// Emit task_dup function (for initialization of
/// private/firstprivate/lastprivate vars and last_iter flag)
/// \code
/// void __task_dup_entry(kmp_task_t *task_dst, const kmp_task_t *task_src, int
/// lastpriv) {
/// // setup lastprivate flag
///    task_dst->last = lastpriv;
/// // could be constructor calls here...
/// }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="emitTaskDupFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3600,
 FQN="emitTaskDupFunction", NM="_ZL19emitTaskDupFunctionRN5clang7CodeGen13CodeGenModuleENS_14SourceLocationERKNS_22OMPExecutableDirectiveENS_8QualTypeEPKNS_10RecordDeclESA_S7_S7_RKNS0_13OMPTaskDataTyEN4llvm8ArrayRefISt4pairINS_9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL19emitTaskDupFunctionRN5clang7CodeGen13CodeGenModuleENS_14SourceLocationERKNS_22OMPExecutableDirectiveENS_8QualTypeEPKNS_10RecordDeclESA_S7_S7_RKNS0_13OMPTaskDataTyEN4llvm8ArrayRefISt4pairINS_9CharUnitsEN12_GLOBAL__N_116PrivateHelpersTyEEEEb")
//</editor-fold>
public static Value /*P*/ emitTaskDupFunction(final CodeGenModule /*&*/ CGM, SourceLocation Loc, 
                   final /*const*/ OMPExecutableDirective /*&*/ D, 
                   QualType KmpTaskTWithPrivatesPtrQTy, 
                   /*const*/ RecordDecl /*P*/ KmpTaskTWithPrivatesQTyRD, 
                   /*const*/ RecordDecl /*P*/ KmpTaskTQTyRD, QualType SharedsTy, 
                   QualType SharedsPtrTy, final /*const*/ OMPTaskDataTy /*&*/ Data, 
                   ArrayRef<std.pairTypeType<CharUnits, PrivateHelpersTy>> Privates, boolean WithLastIter) {
  FunctionArgList Args = null;
  ImplicitParamDecl DstArg = null;
  ImplicitParamDecl SrcArg = null;
  ImplicitParamDecl LastprivArg = null;
  CodeGenFunction CGF = null;
  try {
    final ASTContext /*&*/ C = CGM.getContext();
    Args/*J*/= new FunctionArgList();
    DstArg/*J*/= new ImplicitParamDecl(C, /*DC=*/ (DeclContext /*P*/ )null, new SourceLocation(Loc), 
        /*Id=*/ (IdentifierInfo /*P*/ )null, new QualType(KmpTaskTWithPrivatesPtrQTy));
    SrcArg/*J*/= new ImplicitParamDecl(C, /*DC=*/ (DeclContext /*P*/ )null, new SourceLocation(Loc), 
        /*Id=*/ (IdentifierInfo /*P*/ )null, new QualType(KmpTaskTWithPrivatesPtrQTy));
    LastprivArg/*J*/= new ImplicitParamDecl(C, /*DC=*/ (DeclContext /*P*/ )null, new SourceLocation(Loc), 
        /*Id=*/ (IdentifierInfo /*P*/ )null, C.IntTy.$QualType());
    Args.push_back($AddrOf(DstArg));
    Args.push_back($AddrOf(SrcArg));
    Args.push_back($AddrOf(LastprivArg));
    final /*const*/ CGFunctionInfo /*&*/ TaskDupFnInfo = CGM.getTypes().arrangeBuiltinFunctionDeclaration(C.VoidTy.$QualType(), Args);
    org.llvm.ir.FunctionType /*P*/ TaskDupTy = CGM.getTypes().GetFunctionType(TaskDupFnInfo);
    Function /*P*/ TaskDup = Function.Create(TaskDupTy, GlobalValue.LinkageTypes.InternalLinkage, 
        new Twine(/*KEEP_STR*/".omp_task_dup."), $AddrOf(CGM.getModule()));
    CGM.SetInternalFunctionAttributes(/*D=*/ (/*const*/ Decl /*P*/ )null, TaskDup, TaskDupFnInfo);
    CGF/*J*/= new CodeGenFunction(CGM);
    CGF.disableDebugInfo();
    CGF.StartFunction(new GlobalDecl(), C.VoidTy.$QualType(), TaskDup, TaskDupFnInfo, Args);
    
    LValue TDBase = CGF.EmitLoadOfPointerLValue(CGF.GetAddrOfLocalVar($AddrOf(DstArg)), 
        KmpTaskTWithPrivatesPtrQTy.$arrow().castAs(org.clang.ast.PointerType.class));
    // task_dst->liter = lastpriv;
    if (WithLastIter) {
      DeclContext.specific_decl_iterator<FieldDecl> LIFI = std.next(KmpTaskTQTyRD.field_begin(), KmpTaskTFields.KmpTaskTLastIter.getValue());
      LValue Base = CGF.EmitLValueForField(new LValue(TDBase), KmpTaskTWithPrivatesQTyRD.field_begin().$star());
      LValue LILVal = CGF.EmitLValueForField(new LValue(Base), LIFI.$star());
      Value /*P*/ Lastpriv = CGF.EmitLoadOfScalar(CGF.GetAddrOfLocalVar($AddrOf(LastprivArg)), /*Volatile=*/ false, C.IntTy.$QualType(), new SourceLocation(Loc));
      CGF.EmitStoreOfScalar(Lastpriv, new LValue(LILVal));
    }
    
    // Emit initial values for private copies (if any).
    assert (!Privates.empty());
    Address KmpTaskSharedsPtr = Address.invalid();
    if (!Data.FirstprivateVars.empty()) {
      LValue TDBase$1 = CGF.EmitLoadOfPointerLValue(CGF.GetAddrOfLocalVar($AddrOf(SrcArg)), 
          KmpTaskTWithPrivatesPtrQTy.$arrow().castAs(org.clang.ast.PointerType.class));
      LValue Base = CGF.EmitLValueForField(new LValue(TDBase$1), KmpTaskTWithPrivatesQTyRD.field_begin().$star());
      KmpTaskSharedsPtr.$assignMove(new Address(CGF.EmitLoadOfScalar(CGF.EmitLValueForField(new LValue(Base), std.next(KmpTaskTQTyRD.field_begin(), 
                          KmpTaskTFields.KmpTaskTShareds.getValue()).$star()), 
                  new SourceLocation(Loc)), 
              CGF.getNaturalTypeAlignment(new QualType(SharedsTy))));
    }
    emitPrivatesInit(CGF, D, new Address(KmpTaskSharedsPtr), new LValue(TDBase), KmpTaskTWithPrivatesQTyRD, 
        new QualType(SharedsTy), new QualType(SharedsPtrTy), Data, new ArrayRef<std.pairTypeType<CharUnits, PrivateHelpersTy>>(Privates), /*ForDup=*/ true);
    CGF.FinishFunction();
    return TaskDup;
  } finally {
    if (CGF != null) { CGF.$destroy(); }
    if (LastprivArg != null) { LastprivArg.$destroy(); }
    if (SrcArg != null) { SrcArg.$destroy(); }
    if (DstArg != null) { DstArg.$destroy(); }
    if (Args != null) { Args.$destroy(); }
  }
}


/// Checks if destructor function is required to be generated.
/// \return true if cleanups are required, false otherwise.
//<editor-fold defaultstate="collapsed" desc="checkDestructorsRequired">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3668,
 FQN="checkDestructorsRequired", NM="_ZL24checkDestructorsRequiredPKN5clang10RecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL24checkDestructorsRequiredPKN5clang10RecordDeclE")
//</editor-fold>
public static boolean checkDestructorsRequired(/*const*/ RecordDecl /*P*/ KmpTaskTWithPrivatesQTyRD) {
  boolean NeedsCleanup = false;
  DeclContext.specific_decl_iterator<FieldDecl> FI = std.next(KmpTaskTWithPrivatesQTyRD.field_begin());
  RecordDecl /*P*/ PrivateRD = cast_RecordDecl(FI.$arrow().getType().$arrow().getAsTagDecl());
  for (FieldDecl /*P*/ FD : PrivateRD.fields()) {
    NeedsCleanup = NeedsCleanup || (FD.getType().isDestructedType().getValue() != 0);
    if (NeedsCleanup) {
      break;
    }
  }
  return NeedsCleanup;
}


/// \brief Emit reduction operation for each element of array (required for
/// array sections) LHS op = RHS.
/// \param Type Type of array.
/// \param LHSVar Variable on the left side of the reduction operation
/// (references element of array in original variable).
/// \param RHSVar Variable on the right side of the reduction operation
/// (references element of array in original variable).
/// \param RedOpGen Generator of reduction operation with use of LHSVar and
/// RHSVar.
//<editor-fold defaultstate="collapsed" desc="EmitOMPAggregateReduction">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4130,
 FQN="EmitOMPAggregateReduction", NM="_ZL25EmitOMPAggregateReductionRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeEPKNS_7VarDeclES6_RKN4llvm12function_refIFvS2_PKNS_4ExprESB_SB_EEESB_SB_SB_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL25EmitOMPAggregateReductionRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeEPKNS_7VarDeclES6_RKN4llvm12function_refIFvS2_PKNS_4ExprESB_SB_EEESB_SB_SB_")
//</editor-fold>
public static void EmitOMPAggregateReduction(final CodeGenFunction /*&*/ CGF, QualType Type, /*const*/ VarDecl /*P*/ LHSVar, 
                         /*const*/ VarDecl /*P*/ RHSVar, 
                         final /*const*/CodeGenFunction.ThreeExpr2Void /*&*/ RedOpGen) {
  EmitOMPAggregateReduction(CGF, Type, LHSVar, 
                         RHSVar, 
                         RedOpGen, 
                         (/*const*/ Expr /*P*/ )null, (/*const*/ Expr /*P*/ )null, 
                         (/*const*/ Expr /*P*/ )null);
}
public static void EmitOMPAggregateReduction(final CodeGenFunction /*&*/ CGF, QualType Type, /*const*/ VarDecl /*P*/ LHSVar, 
                         /*const*/ VarDecl /*P*/ RHSVar, 
                         final /*const*/CodeGenFunction.ThreeExpr2Void /*&*/ RedOpGen, 
                         /*const*/ Expr /*P*/ XExpr/*= null*/) {
  EmitOMPAggregateReduction(CGF, Type, LHSVar, 
                         RHSVar, 
                         RedOpGen, 
                         XExpr, (/*const*/ Expr /*P*/ )null, 
                         (/*const*/ Expr /*P*/ )null);
}
public static void EmitOMPAggregateReduction(final CodeGenFunction /*&*/ CGF, QualType Type, /*const*/ VarDecl /*P*/ LHSVar, 
                         /*const*/ VarDecl /*P*/ RHSVar, 
                         final /*const*/CodeGenFunction.ThreeExpr2Void /*&*/ RedOpGen, 
                         /*const*/ Expr /*P*/ XExpr/*= null*/, /*const*/ Expr /*P*/ EExpr/*= null*/) {
  EmitOMPAggregateReduction(CGF, Type, LHSVar, 
                         RHSVar, 
                         RedOpGen, 
                         XExpr, EExpr, 
                         (/*const*/ Expr /*P*/ )null);
}
public static void EmitOMPAggregateReduction(final CodeGenFunction /*&*/ CGF, QualType Type, /*const*/ VarDecl /*P*/ LHSVar, 
                         /*const*/ VarDecl /*P*/ RHSVar, 
                         final /*const*/CodeGenFunction.ThreeExpr2Void /*&*/ RedOpGen, 
                         /*const*/ Expr /*P*/ XExpr/*= null*/, /*const*/ Expr /*P*/ EExpr/*= null*/, 
                         /*const*/ Expr /*P*/ UpExpr/*= null*/) {
  CodeGenFunction.OMPPrivateScope Scope = null;
  try {
    // Perform element-by-element initialization.
    QualType ElementTy/*J*/= new QualType();
    Address LHSAddr = CGF.GetAddrOfLocalVar(LHSVar);
    Address RHSAddr = CGF.GetAddrOfLocalVar(RHSVar);
    
    // Drill down to the base element type on both arrays.
    /*const*/ org.clang.ast.ArrayType /*P*/ ArrayTy = Type.$arrow().getAsArrayTypeUnsafe();
    Value /*P*/ NumElements = CGF.emitArrayLength(ArrayTy, ElementTy, LHSAddr);
    
    Value /*P*/ RHSBegin = RHSAddr.getPointer();
    Value /*P*/ LHSBegin = LHSAddr.getPointer();
    // Cast from pointer to array type to pointer to single element.
    Value /*P*/ LHSEnd = CGF.Builder.CreateGEP(LHSBegin, NumElements);
    // The basic structure here is a while-do loop.
    BasicBlock /*P*/ BodyBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"omp.arraycpy.body"));
    BasicBlock /*P*/ DoneBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"omp.arraycpy.done"));
    Value /*P*/ IsEmpty = CGF.Builder.CreateICmpEQ(LHSBegin, LHSEnd, new Twine(/*KEEP_STR*/"omp.arraycpy.isempty"));
    CGF.Builder.CreateCondBr(IsEmpty, DoneBB, BodyBB);
    
    // Enter the loop body, making that address the current address.
    BasicBlock /*P*/ EntryBB = CGF.Builder.GetInsertBlock();
    CGF.EmitBlock(BodyBB);
    
    CharUnits ElementSize = CGF.getContext().getTypeSizeInChars(/*NO_COPY*/ElementTy);
    
    PHINode /*P*/ RHSElementPHI = CGF.Builder.CreatePHI(RHSBegin.getType(), 2, new Twine(/*KEEP_STR*/"omp.arraycpy.srcElementPast"));
    RHSElementPHI.addIncoming(RHSBegin, EntryBB);
    Address RHSElementCurrent = new Address(RHSElementPHI, 
        RHSAddr.getAlignment().alignmentOfArrayElement(new CharUnits(ElementSize)));
    
    PHINode /*P*/ LHSElementPHI = CGF.Builder.CreatePHI(LHSBegin.getType(), 2, new Twine(/*KEEP_STR*/"omp.arraycpy.destElementPast"));
    LHSElementPHI.addIncoming(LHSBegin, EntryBB);
    Address LHSElementCurrent = new Address(LHSElementPHI, 
        LHSAddr.getAlignment().alignmentOfArrayElement(new CharUnits(ElementSize)));
    
    // Emit copy.
    Scope/*J*/= new CodeGenFunction.OMPPrivateScope(CGF);
    Scope.addPrivate(LHSVar, /*FuncArg*//*[=, =L$LHSElementCurrent(LHSElementCurrent)]*/ () -> {
              return new Address(LHSElementCurrent);
            });
    Scope.addPrivate(RHSVar, /*FuncArg*//*[=, =L$RHSElementCurrent(RHSElementCurrent)]*/ () -> {
              return new Address(RHSElementCurrent);
            });
    Scope.Privatize();
    RedOpGen.$call(CGF, XExpr, EExpr, UpExpr);
    Scope.ForceCleanup_OMPPrivateScope();
    
    // Shift the address forward by one element.
    Value /*P*/ LHSElementNext = CGF.Builder.CreateConstGEP1_32(LHSElementPHI, /*Idx0=*/ 1, new Twine(/*KEEP_STR*/"omp.arraycpy.dest.element"));
    Value /*P*/ RHSElementNext = CGF.Builder.CreateConstGEP1_32(RHSElementPHI, /*Idx0=*/ 1, new Twine(/*KEEP_STR*/"omp.arraycpy.src.element"));
    // Check whether we've reached the end.
    Value /*P*/ Done = CGF.Builder.CreateICmpEQ(LHSElementNext, LHSEnd, new Twine(/*KEEP_STR*/"omp.arraycpy.done"));
    CGF.Builder.CreateCondBr(Done, DoneBB, BodyBB);
    LHSElementPHI.addIncoming(LHSElementNext, CGF.Builder.GetInsertBlock());
    RHSElementPHI.addIncoming(RHSElementNext, CGF.Builder.GetInsertBlock());
    
    // Done.
    CGF.EmitBlock(DoneBB, /*IsFinished=*/ true);
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}


/// Emit reduction combiner. If the combiner is a simple expression emit it as
/// is, otherwise consider it as combiner of UDR decl and emit it as a call of
/// UDR combiner function.
//<editor-fold defaultstate="collapsed" desc="emitReductionCombiner">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4204,
 FQN="emitReductionCombiner", NM="_ZL21emitReductionCombinerRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL21emitReductionCombinerRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE")
//</editor-fold>
public static void emitReductionCombiner(final CodeGenFunction /*&*/ CGF, 
                     /*const*/ Expr /*P*/ ReductionOp) {
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
                  CodeGenFunction.OpaqueValueMapping Map = null;
                  try {
                    std.pair<Function /*P*/ , Function /*P*/ > Reduction = CGF.CGM.getOpenMPRuntime().getUserDefinedReduction(DRD);
                    RValue Func = RValue.get(Reduction.first);
                    Map/*J*/= new CodeGenFunction.OpaqueValueMapping(CGF, OVE, new RValue(Func));
                    CGF.EmitIgnoredExpr(ReductionOp);
                    return;
                  } finally {
                    if (Map != null) { Map.$destroy(); }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  CGF.EmitIgnoredExpr(ReductionOp);
}

//<editor-fold defaultstate="collapsed" desc="emitReductionFunction">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4221,
 FQN="emitReductionFunction", NM="_ZL21emitReductionFunctionRN5clang7CodeGen13CodeGenModuleEPN4llvm4TypeENS3_8ArrayRefIPKNS_4ExprEEESA_SA_SA_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL21emitReductionFunctionRN5clang7CodeGen13CodeGenModuleEPN4llvm4TypeENS3_8ArrayRefIPKNS_4ExprEEESA_SA_SA_")
//</editor-fold>
public static Value /*P*/ emitReductionFunction(final CodeGenModule /*&*/ CGM, 
                     org.llvm.ir.Type /*P*/ ArgsType, 
                     ArrayRef</*const*/ Expr /*P*/ > Privates, 
                     ArrayRef</*const*/ Expr /*P*/ > LHSExprs, 
                     ArrayRef</*const*/ Expr /*P*/ > RHSExprs, 
                     ArrayRef</*const*/ Expr /*P*/ > ReductionOps) {
  FunctionArgList Args = null;
  ImplicitParamDecl LHSArg = null;
  ImplicitParamDecl RHSArg = null;
  CodeGenFunction CGF = null;
  CodeGenFunction.OMPPrivateScope Scope = null;
  try {
    final ASTContext /*&*/ C = CGM.getContext();
    
    // void reduction_func(void *LHSArg, void *RHSArg);
    Args/*J*/= new FunctionArgList();
    LHSArg/*J*/= new ImplicitParamDecl(C, /*DC=*/ (DeclContext /*P*/ )null, new SourceLocation(), /*Id=*/ (IdentifierInfo /*P*/ )null, 
        C.VoidPtrTy.$QualType());
    RHSArg/*J*/= new ImplicitParamDecl(C, /*DC=*/ (DeclContext /*P*/ )null, new SourceLocation(), /*Id=*/ (IdentifierInfo /*P*/ )null, 
        C.VoidPtrTy.$QualType());
    Args.push_back($AddrOf(LHSArg));
    Args.push_back($AddrOf(RHSArg));
    final /*const*/ CGFunctionInfo /*&*/ CGFI = CGM.getTypes().arrangeBuiltinFunctionDeclaration(C.VoidTy.$QualType(), Args);
    Function /*P*/ Fn = Function.Create(CGM.getTypes().GetFunctionType(CGFI), GlobalValue.LinkageTypes.InternalLinkage, 
        new Twine(/*KEEP_STR*/".omp.reduction.reduction_func"), $AddrOf(CGM.getModule()));
    CGM.SetInternalFunctionAttributes(/*D=*/ (/*const*/ Decl /*P*/ )null, Fn, CGFI);
    CGF/*J*/= new CodeGenFunction(CGM);
    CGF.StartFunction(new GlobalDecl(), C.VoidTy.$QualType(), Fn, CGFI, Args);
    
    // Dst = (void*[n])(LHSArg);
    // Src = (void*[n])(RHSArg);
    Address LHS/*J*/= new Address(CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(CGF.Builder.CreateLoad(CGF.GetAddrOfLocalVar($AddrOf(LHSArg))), 
            ArgsType), CGF.getPointerAlign());
    Address RHS/*J*/= new Address(CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(CGF.Builder.CreateLoad(CGF.GetAddrOfLocalVar($AddrOf(RHSArg))), 
            ArgsType), CGF.getPointerAlign());
    
    //  ...
    //  *(Type<i>*)lhs[i] = RedOp<i>(*(Type<i>*)lhs[i], *(Type<i>*)rhs[i]);
    //  ...
    Scope/*J*/= new CodeGenFunction.OMPPrivateScope(CGF);
    type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> IPriv = $tryClone(Privates.begin());
    /*uint*/int Idx = 0;
    final CodeGenFunction $CGF = CGF;
    for (/*uint*/int I = 0, E = ReductionOps.size(); $less_uint(I, E); ++I , IPriv.$preInc() , ++Idx) {
      /*const*/ VarDecl /*P*/ RHSVar = cast_VarDecl(cast_DeclRefExpr(RHSExprs.$at(I)).getDecl$Const());
      int $Idx = Idx;
      Scope.addPrivate(RHSVar, /*FuncArg*//*[&, &CGF, &RHS, &Idx, &RHSVar]*/ () -> {
                return emitAddrOfVarFromArray($CGF, new Address(RHS), $Idx, RHSVar);
              });
      /*const*/ VarDecl /*P*/ LHSVar = cast_VarDecl(cast_DeclRefExpr(LHSExprs.$at(I)).getDecl$Const());
      Scope.addPrivate(LHSVar, /*FuncArg*//*[&, &CGF, &LHS, &Idx, &LHSVar]*/ () -> {
                return emitAddrOfVarFromArray($CGF, new Address(LHS), $Idx, LHSVar);
              });
      QualType PrivTy = (IPriv.$star()).getType();
      if (PrivTy.$arrow().isVariablyModifiedType()) {
        CodeGenFunction.OpaqueValueMapping OpaqueMap = null;
        try {
          // Get array size and emit VLA type.
          ++Idx;
          Address Elem = CGF.Builder.CreateConstArrayGEP(new Address(LHS), $uint2ulong(Idx), CGF.getPointerSize());
          Value /*P*/ Ptr = CGF.Builder.CreateLoad(new Address(Elem));
          /*const*/ VariableArrayType /*P*/ VLA = CGF.getContext().getAsVariableArrayType(new QualType(PrivTy));
          OpaqueValueExpr /*P*/ OVE = cast_OpaqueValueExpr(VLA.getSizeExpr());
          OpaqueMap/*J*/= new CodeGenFunction.OpaqueValueMapping(CGF, OVE, RValue.get(CGF.Builder.CreatePtrToInt(Ptr, CGF.Unnamed_field8.SizeTy)));
          CGF.EmitVariablyModifiedType(new QualType(PrivTy));
        } finally {
          if (OpaqueMap != null) { OpaqueMap.$destroy(); }
        }
      }
    }
    Scope.Privatize();
    IPriv = $tryClone(Privates.begin());
    type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> ILHS = $tryClone(LHSExprs.begin());
    type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> IRHS = $tryClone(RHSExprs.begin());
    for (/*const*/ Expr /*P*/ E : ReductionOps) {
      if ((IPriv.$star()).getType().$arrow().isArrayType()) {
        // Emit reduction for array section.
        /*const*/ VarDecl /*P*/ LHSVar = cast_VarDecl(cast_DeclRefExpr(ILHS.$star()).getDecl$Const());
        /*const*/ VarDecl /*P*/ RHSVar = cast_VarDecl(cast_DeclRefExpr(IRHS.$star()).getDecl$Const());
        EmitOMPAggregateReduction(CGF, (IPriv.$star()).getType(), LHSVar, RHSVar, 
            /*FuncArg*//*[=, =L$E(E)]*/ (final CodeGenFunction /*&*/ CGF$1, /*const*/ Expr /*P*/ $Prm1, /*const*/ Expr /*P*/ $Prm2, /*const*/ Expr /*P*/ $Prm3) -> {
                  emitReductionCombiner(CGF$1, E);
                });
      } else {
        // Emit reduction for array subscript or single variable.
        emitReductionCombiner(CGF, E);
      }
      IPriv.$preInc();
      ILHS.$preInc();
      IRHS.$preInc();
    }
    Scope.ForceCleanup_OMPPrivateScope();
    CGF.FinishFunction();
    return Fn;
  } finally {
    if (Scope != null) { Scope.$destroy(); }
    if (CGF != null) { CGF.$destroy(); }
    if (RHSArg != null) { RHSArg.$destroy(); }
    if (LHSArg != null) { LHSArg.$destroy(); }
    if (Args != null) { Args.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="emitSingleReductionCombiner">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4309,
 FQN="emitSingleReductionCombiner", NM="_ZL27emitSingleReductionCombinerRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprES5_PKNS_11DeclRefExprES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL27emitSingleReductionCombinerRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprES5_PKNS_11DeclRefExprES8_")
//</editor-fold>
public static void emitSingleReductionCombiner(final CodeGenFunction /*&*/ CGF, 
                           /*const*/ Expr /*P*/ ReductionOp, 
                           /*const*/ Expr /*P*/ PrivateRef, 
                           /*const*/ DeclRefExpr /*P*/ LHS, 
                           /*const*/ DeclRefExpr /*P*/ RHS) {
  if (PrivateRef.getType().$arrow().isArrayType()) {
    // Emit reduction for array section.
    /*const*/ VarDecl /*P*/ LHSVar = cast_VarDecl(LHS.getDecl$Const());
    /*const*/ VarDecl /*P*/ RHSVar = cast_VarDecl(RHS.getDecl$Const());
    EmitOMPAggregateReduction(CGF, PrivateRef.getType(), LHSVar, RHSVar, 
        /*FuncArg*//*[=, =L$ReductionOp(ReductionOp)]*/ (final CodeGenFunction /*&*/ CGF$1, /*const*/ Expr /*P*/ $Prm1, /*const*/ Expr /*P*/ $Prm2, /*const*/ Expr /*P*/ $Prm3) -> {
              emitReductionCombiner(CGF$1, ReductionOp);
            });
  } else {
    // Emit reduction for array subscript or single variable.
    emitReductionCombiner(CGF, ReductionOp);
  }
}

// anonymous namespace
//<editor-fold defaultstate="collapsed" desc="getCancellationKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4654,
 FQN="getCancellationKind", NM="_ZL19getCancellationKindN5clang19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL19getCancellationKindN5clang19OpenMPDirectiveKindE")
//</editor-fold>
public static RTCancelKind getCancellationKind(OpenMPDirectiveKind CancelRegion) {
  RTCancelKind CancelKind = RTCancelKind.CancelNoreq;
  if (CancelRegion == OpenMPDirectiveKind.OMPD_parallel) {
    CancelKind = RTCancelKind.CancelParallel;
  } else if (CancelRegion == OpenMPDirectiveKind.OMPD_for) {
    CancelKind = RTCancelKind.CancelLoop;
  } else if (CancelRegion == OpenMPDirectiveKind.OMPD_sections) {
    CancelKind = RTCancelKind.CancelSections;
  } else {
    assert (CancelRegion == OpenMPDirectiveKind.OMPD_taskgroup);
    CancelKind = RTCancelKind.CancelTaskgroup;
  }
  return CancelKind;
}


/// \brief Obtain information that uniquely identifies a target entry. This
/// consists of the file and device IDs as well as line number associated with
/// the relevant entry source location.
//<editor-fold defaultstate="collapsed" desc="getTargetEntryUniqueInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4753,
 FQN="getTargetEntryUniqueInfo", NM="_ZL24getTargetEntryUniqueInfoRN5clang10ASTContextENS_14SourceLocationERjS3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL24getTargetEntryUniqueInfoRN5clang10ASTContextENS_14SourceLocationERjS3_S3_")
//</editor-fold>
public static void getTargetEntryUniqueInfo(final ASTContext /*&*/ C, SourceLocation Loc, 
                        final uint$ref/*uint &*/ DeviceID, final uint$ref/*uint &*/ FileID, 
                        final uint$ref/*uint &*/ LineNum) {
  
  final SourceManager /*&*/ SM = C.getSourceManager();
  
  // The loc should be always valid and have a file ID (the user cannot use
  // #pragma directives in macros)
  assert (Loc.isValid()) : "Source location is expected to be always valid.";
  assert (Loc.isFileID()) : "Source location is expected to refer to a file.";
  
  PresumedLoc PLoc = SM.getPresumedLoc(/*NO_COPY*/Loc);
  assert (PLoc.isValid()) : "Source location is expected to be always valid.";
  
  fs.UniqueID ID/*J*/= new fs.UniqueID();
  if (fs.getUniqueID(new Twine(PLoc.getFilename()), ID).$bool()) {
    throw new llvm_unreachable("Source file with target region no longer exists!");
  }
  
  DeviceID.$set($ulong2uint(ID.getDevice()));
  FileID.$set($ulong2uint(ID.getFile()));
  LineNum.$set(PLoc.getLine());
}


/// discard all CompoundStmts intervening between two constructs
//<editor-fold defaultstate="collapsed" desc="ignoreCompoundStmts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4851,
 FQN="ignoreCompoundStmts", NM="_ZL19ignoreCompoundStmtsPKN5clang4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL19ignoreCompoundStmtsPKN5clang4StmtE")
//</editor-fold>
public static /*const*/ Stmt /*P*/ ignoreCompoundStmts(/*const*/ Stmt /*P*/ Body) {
  {
    /*const*/ CompoundStmt /*P*/ CS;
    while (((/*P*/ CS = dyn_cast_or_null_CompoundStmt(Body)) != null)) {
      Body = CS.body_front$Const();
    }
  }
  
  return Body;
}


/// \brief Emit the num_teams clause of an enclosed teams directive at the
/// target region scope. If there is no teams directive associated with the
/// target directive, or if there is no num_teams clause associated with the
/// enclosed teams directive, return nullptr.
//<editor-fold defaultstate="collapsed" desc="emitNumTeamsClauseForTargetDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4862,
 FQN="emitNumTeamsClauseForTargetDirective", NM="_ZL36emitNumTeamsClauseForTargetDirectiveRN5clang7CodeGen15CGOpenMPRuntimeERNS0_15CodeGenFunctionERKNS_22OMPExecutableDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL36emitNumTeamsClauseForTargetDirectiveRN5clang7CodeGen15CGOpenMPRuntimeERNS0_15CodeGenFunctionERKNS_22OMPExecutableDirectiveE")
//</editor-fold>
public static Value /*P*/ emitNumTeamsClauseForTargetDirective(final CGOpenMPRuntime /*&*/ OMPRuntime, 
                                    final CodeGenFunction /*&*/ CGF, 
                                    final /*const*/ OMPExecutableDirective /*&*/ D) {
  assert (!CGF.getLangOpts().OpenMPIsDevice) : "Clauses associated with the teams directive expected to be emitted only for the host!";
  
  // FIXME: For the moment we do not support combined directives with target and
  // teams, so we do not expect to get any num_teams clause in the provided
  // directive. Once we support that, this assertion can be replaced by the
  // actual emission of the clause expression.
  assert (D.<OMPNumTeamsClause>getSingleClause(OMPNumTeamsClause.class) == null) : "Not expecting clause in directive.";
  
  // If the current target region has a teams region enclosed, we need to get
  // the number of teams to pass to the runtime function call. This is done
  // by generating the expression in a inlined region. This is required because
  // the expression is captured in the enclosing target environment when the
  // teams directive is not combined with target.
  final /*const*/ CapturedStmt /*&*/ CS = $Deref(cast_CapturedStmt(D.getAssociatedStmt()));
  {
    
    // FIXME: Accommodate other combined directives with teams when they become
    // available.
    /*const*/ OMPTeamsDirective /*P*/ TeamsDir = dyn_cast_or_null_OMPTeamsDirective(ignoreCompoundStmts(CS.getCapturedStmt$Const()));
    if ((TeamsDir != null)) {
      {
        /*const*/ OMPNumTeamsClause /*P*/ NTE = TeamsDir.<OMPNumTeamsClause>getSingleClause(OMPNumTeamsClause.class);
        if ((NTE != null)) {
          CGOpenMPInnerExprInfo CGInfo = null;
          CodeGenFunction.CGCapturedStmtRAII CapInfoRAII = null;
          try {
            CGInfo/*J*/= new CGOpenMPInnerExprInfo(CGF, CS);
            CapInfoRAII/*J*/= new CodeGenFunction.CGCapturedStmtRAII(CGF, $AddrOf(CGInfo));
            Value /*P*/ NumTeams = CGF.EmitScalarExpr(NTE.getNumTeams$Const());
            return CGF.Builder.CreateIntCast(NumTeams, CGF.Int32Ty, 
                /*IsSigned=*/ true);
          } finally {
            if (CapInfoRAII != null) { CapInfoRAII.$destroy(); }
            if (CGInfo != null) { CGInfo.$destroy(); }
          }
        }
      }
      
      // If we have an enclosed teams directive but no num_teams clause we use
      // the default value 0.
      return CGF.Builder.getInt32(0);
    }
  }
  
  // No teams associated with the directive.
  return null;
}


/// \brief Emit the thread_limit clause of an enclosed teams directive at the
/// target region scope. If there is no teams directive associated with the
/// target directive, or if there is no thread_limit clause associated with the
/// enclosed teams directive, return nullptr.
//<editor-fold defaultstate="collapsed" desc="emitThreadLimitClauseForTargetDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4911,
 FQN="emitThreadLimitClauseForTargetDirective", NM="_ZL39emitThreadLimitClauseForTargetDirectiveRN5clang7CodeGen15CGOpenMPRuntimeERNS0_15CodeGenFunctionERKNS_22OMPExecutableDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL39emitThreadLimitClauseForTargetDirectiveRN5clang7CodeGen15CGOpenMPRuntimeERNS0_15CodeGenFunctionERKNS_22OMPExecutableDirectiveE")
//</editor-fold>
public static Value /*P*/ emitThreadLimitClauseForTargetDirective(final CGOpenMPRuntime /*&*/ OMPRuntime, 
                                       final CodeGenFunction /*&*/ CGF, 
                                       final /*const*/ OMPExecutableDirective /*&*/ D) {
  assert (!CGF.getLangOpts().OpenMPIsDevice) : "Clauses associated with the teams directive expected to be emitted only for the host!";
  
  // FIXME: For the moment we do not support combined directives with target and
  // teams, so we do not expect to get any thread_limit clause in the provided
  // directive. Once we support that, this assertion can be replaced by the
  // actual emission of the clause expression.
  assert (D.<OMPThreadLimitClause>getSingleClause(OMPThreadLimitClause.class) == null) : "Not expecting clause in directive.";
  
  // If the current target region has a teams region enclosed, we need to get
  // the thread limit to pass to the runtime function call. This is done
  // by generating the expression in a inlined region. This is required because
  // the expression is captured in the enclosing target environment when the
  // teams directive is not combined with target.
  final /*const*/ CapturedStmt /*&*/ CS = $Deref(cast_CapturedStmt(D.getAssociatedStmt()));
  {
    
    // FIXME: Accommodate other combined directives with teams when they become
    // available.
    /*const*/ OMPTeamsDirective /*P*/ TeamsDir = dyn_cast_or_null_OMPTeamsDirective(ignoreCompoundStmts(CS.getCapturedStmt$Const()));
    if ((TeamsDir != null)) {
      {
        /*const*/ OMPThreadLimitClause /*P*/ TLE = TeamsDir.<OMPThreadLimitClause>getSingleClause(OMPThreadLimitClause.class);
        if ((TLE != null)) {
          CGOpenMPInnerExprInfo CGInfo = null;
          CodeGenFunction.CGCapturedStmtRAII CapInfoRAII = null;
          try {
            CGInfo/*J*/= new CGOpenMPInnerExprInfo(CGF, CS);
            CapInfoRAII/*J*/= new CodeGenFunction.CGCapturedStmtRAII(CGF, $AddrOf(CGInfo));
            Value /*P*/ ThreadLimit = CGF.EmitScalarExpr(TLE.getThreadLimit$Const());
            return CGF.Builder.CreateIntCast(ThreadLimit, CGF.Int32Ty, 
                /*IsSigned=*/ true);
          } finally {
            if (CapInfoRAII != null) { CapInfoRAII.$destroy(); }
            if (CGInfo != null) { CGInfo.$destroy(); }
          }
        }
      }
      
      // If we have an enclosed teams directive but no thread_limit clause we use
      // the default value 0.
      return CGF.Builder.getInt32(0);
    }
  }
  
  // No teams associated with the directive.
  return null;
}

// anonymous namespace

/// \brief Emit the arrays used to pass the captures and map information to the
/// offloading runtime library. If there is no map or capture information,
/// return nullptr by reference.
//<editor-fold defaultstate="collapsed" desc="emitOffloadingArrays">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 5550,
 FQN="emitOffloadingArrays", NM="_ZL20emitOffloadingArraysRN5clang7CodeGen15CodeGenFunctionERPN4llvm5ValueES6_S6_S6_RNS3_11SmallVectorIS5_Lj16EEES9_S9_RNS7_IjLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL20emitOffloadingArraysRN5clang7CodeGen15CodeGenFunctionERPN4llvm5ValueES6_S6_S6_RNS3_11SmallVectorIS5_Lj16EEES9_S9_RNS7_IjLj16EEE")
//</editor-fold>
public static void emitOffloadingArrays(final CodeGenFunction /*&*/ CGF, final type$ref<Value /*P*/ /*&*/> BasePointersArray, 
                    final type$ref<Value /*P*/ /*&*/> PointersArray, final type$ref<Value /*P*/ /*&*/> SizesArray, 
                    final type$ref<Value /*P*/ /*&*/> MapTypesArray, 
                    final SmallVector<Value /*P*/ > /*&*/ BasePointers, 
                    final SmallVector<Value /*P*/ > /*&*/ Pointers, 
                    final SmallVector<Value /*P*/ > /*&*/ Sizes, 
                    final SmallVectorUInt /*&*/ MapTypes) {
  final CodeGenModule /*&*/ CGM = CGF.CGM;
  final ASTContext /*&*/ Ctx = CGF.getContext();
  
  BasePointersArray.$set(PointersArray.$set(SizesArray.$set(MapTypesArray.$set(null))));
  {
    
    /*uint*/int PointerNumVal = BasePointers.size();
    if ((PointerNumVal != 0)) {
      // Detect if we have any capture size requiring runtime evaluation of the
      // size so that a constant array could be eventually used.
      boolean hasRuntimeEvaluationCaptureSize = false;
      for (Value /*P*/ S : Sizes)  {
        if (!isa_Constant(S)) {
          hasRuntimeEvaluationCaptureSize = true;
          break;
        }
      }
      
      APInt PointerNumAP/*J*/= new APInt(JD$UInt_ULong.INSTANCE, 32, $uint2ulong(PointerNumVal), /*isSigned=*/ true);
      QualType PointerArrayType = Ctx.getConstantArrayType(Ctx.VoidPtrTy.$QualType(), PointerNumAP, org.clang.ast.ArrayType.ArraySizeModifier.Normal, 
          /*IndexTypeQuals=*/ 0);
      
      BasePointersArray.$set(CGF.CreateMemTemp(new QualType(PointerArrayType), new Twine(/*KEEP_STR*/".offload_baseptrs")).getPointer());
      PointersArray.$set(CGF.CreateMemTemp(new QualType(PointerArrayType), new Twine(/*KEEP_STR*/".offload_ptrs")).getPointer());
      
      // If we don't have any VLA types or other types that require runtime
      // evaluation, we can use a constant array for the map sizes, otherwise we
      // need to fill up the arrays as we do for the pointers.
      if (hasRuntimeEvaluationCaptureSize) {
        QualType SizeArrayType = Ctx.getConstantArrayType(Ctx.getSizeType().$QualType(), PointerNumAP, org.clang.ast.ArrayType.ArraySizeModifier.Normal, 
            /*IndexTypeQuals=*/ 0);
        SizesArray.$set(CGF.CreateMemTemp(new QualType(SizeArrayType), new Twine(/*KEEP_STR*/".offload_sizes")).getPointer());
      } else {
        // We expect all the sizes to be constant, so we collect them to create
        // a constant array.
        SmallVector<Constant /*P*/ > ConstSizes/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
        for (Value /*P*/ S : Sizes)  {
          ConstSizes.push_back(cast_Constant(S));
        }
        
        Constant /*P*/ SizesArrayInit = ConstantArray.get(org.llvm.ir.ArrayType.get(CGM.Unnamed_field8.SizeTy, $uint2ulong(ConstSizes.size())), new ArrayRef<Constant /*P*/ >(ConstSizes, true));
        GlobalVariable /*P*/ SizesArrayGbl = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(CGM.getModule(), SizesArrayInit.getType(), 
            /*isConstant=*/ true, GlobalValue.LinkageTypes.PrivateLinkage, 
            SizesArrayInit, new Twine(/*KEEP_STR*/".offload_sizes"));
         });
        SizesArrayGbl.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
        SizesArray.$set(SizesArrayGbl);
      }
      
      // The map types are always constant so we don't need to generate code to
      // fill arrays. Instead, we create an array constant.
      Constant /*P*/ MapTypesArrayInit = ConstantDataArray.get_LLVMContext_ArrayRefUInt(CGF.Builder.getContext(), new ArrayRefUInt(MapTypes));
      GlobalVariable /*P*/ MapTypesArrayGbl = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), MapTypesArrayInit.getType(), 
          /*isConstant=*/ true, GlobalValue.LinkageTypes.PrivateLinkage, 
          MapTypesArrayInit, new Twine(/*KEEP_STR*/".offload_maptypes"));
       });
      MapTypesArrayGbl.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
      MapTypesArray.$set(MapTypesArrayGbl);
      
      for (/*uint*/int i = 0; $less_uint(i, PointerNumVal); ++i) {
        Value /*P*/ BPVal = BasePointers.$at(i);
        if (BPVal.getType().isPointerTy()) {
          BPVal = CGF.Builder.CreateBitCast(BPVal, CGM.Unnamed_field9.VoidPtrTy);
        } else {
          assert (BPVal.getType().isIntegerTy()) : "If not a pointer, the value type must be an integer.";
          BPVal = CGF.Builder.CreateIntToPtr(BPVal, CGM.Unnamed_field9.VoidPtrTy);
        }
        Value /*P*/ BP = CGF.Builder.CreateConstInBoundsGEP2_32(org.llvm.ir.ArrayType.get(CGM.Unnamed_field9.VoidPtrTy, $uint2ulong(PointerNumVal)), BasePointersArray.$deref(), 
            0, i);
        Address BPAddr/*J*/= new Address(BP, Ctx.getTypeAlignInChars(Ctx.VoidPtrTy.$QualType()));
        CGF.Builder.CreateStore(BPVal, new Address(BPAddr));
        
        Value /*P*/ PVal = Pointers.$at(i);
        if (PVal.getType().isPointerTy()) {
          PVal = CGF.Builder.CreateBitCast(PVal, CGM.Unnamed_field9.VoidPtrTy);
        } else {
          assert (PVal.getType().isIntegerTy()) : "If not a pointer, the value type must be an integer.";
          PVal = CGF.Builder.CreateIntToPtr(PVal, CGM.Unnamed_field9.VoidPtrTy);
        }
        Value /*P*/ P = CGF.Builder.CreateConstInBoundsGEP2_32(org.llvm.ir.ArrayType.get(CGM.Unnamed_field9.VoidPtrTy, $uint2ulong(PointerNumVal)), PointersArray.$deref(), 0, 
            i);
        Address PAddr/*J*/= new Address(P, Ctx.getTypeAlignInChars(Ctx.VoidPtrTy.$QualType()));
        CGF.Builder.CreateStore(PVal, new Address(PAddr));
        if (hasRuntimeEvaluationCaptureSize) {
          Value /*P*/ S = CGF.Builder.CreateConstInBoundsGEP2_32(org.llvm.ir.ArrayType.get(CGM.Unnamed_field8.SizeTy, $uint2ulong(PointerNumVal)), SizesArray.$deref(), 
              /*Idx0=*/ 0, 
              /*Idx1=*/ i);
          Address SAddr/*J*/= new Address(S, Ctx.getTypeAlignInChars(Ctx.getSizeType().$QualType()));
          CGF.Builder.CreateStore(CGF.Builder.CreateIntCast(Sizes.$at(i), CGM.Unnamed_field8.SizeTy, /*isSigned=*/ true), 
              new Address(SAddr));
        }
      }
    }
  }
}

/// \brief Emit the arguments to be passed to the runtime library based on the
/// arrays of pointers, sizes and map types.
//<editor-fold defaultstate="collapsed" desc="emitOffloadingArraysArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 5664,
 FQN="emitOffloadingArraysArgument", NM="_ZL28emitOffloadingArraysArgumentRN5clang7CodeGen15CodeGenFunctionERPN4llvm5ValueES6_S6_S6_S5_S5_S5_S5_j",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL28emitOffloadingArraysArgumentRN5clang7CodeGen15CodeGenFunctionERPN4llvm5ValueES6_S6_S6_S5_S5_S5_S5_j")
//</editor-fold>
public static void emitOffloadingArraysArgument(final CodeGenFunction /*&*/ CGF, final type$ref<Value /*P*/ /*&*/> BasePointersArrayArg, 
                            final type$ref<Value /*P*/ /*&*/> PointersArrayArg, final type$ref<Value /*P*/ /*&*/> SizesArrayArg, 
                            final type$ref<Value /*P*/ /*&*/> MapTypesArrayArg, Value /*P*/ BasePointersArray, 
                            Value /*P*/ PointersArray, Value /*P*/ SizesArray, 
                            Value /*P*/ MapTypesArray, /*uint*/int NumElems) {
  final CodeGenModule /*&*/ CGM = CGF.CGM;
  if ((NumElems != 0)) {
    BasePointersArrayArg.$set(CGF.Builder.CreateConstInBoundsGEP2_32(org.llvm.ir.ArrayType.get(CGM.Unnamed_field9.VoidPtrTy, $uint2ulong(NumElems)), BasePointersArray, 
        /*Idx0=*/ 0, /*Idx1=*/ 0));
    PointersArrayArg.$set(CGF.Builder.CreateConstInBoundsGEP2_32(org.llvm.ir.ArrayType.get(CGM.Unnamed_field9.VoidPtrTy, $uint2ulong(NumElems)), PointersArray, 
        /*Idx0=*/ 0, 
        /*Idx1=*/ 0));
    SizesArrayArg.$set(CGF.Builder.CreateConstInBoundsGEP2_32(org.llvm.ir.ArrayType.get(CGM.Unnamed_field8.SizeTy, $uint2ulong(NumElems)), SizesArray, 
        /*Idx0=*/ 0, /*Idx1=*/ 0));
    MapTypesArrayArg.$set(CGF.Builder.CreateConstInBoundsGEP2_32(org.llvm.ir.ArrayType.get(CGM.Int32Ty, $uint2ulong(NumElems)), MapTypesArray, 
        /*Idx0=*/ 0, 
        /*Idx1=*/ 0));
  } else {
    BasePointersArrayArg.$set(ConstantPointerNull.get(CGM.Unnamed_field10.VoidPtrPtrTy));
    PointersArrayArg.$set(ConstantPointerNull.get(CGM.Unnamed_field10.VoidPtrPtrTy));
    SizesArrayArg.$set(ConstantPointerNull.get(CGM.Unnamed_field8.SizeTy.getPointerTo()));
    MapTypesArrayArg.$set(ConstantPointerNull.get(CGM.Int32Ty.getPointerTo()));
  }
}

// namespace
//<editor-fold defaultstate="collapsed" desc="evaluateCDTSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 6275,
 FQN="evaluateCDTSize", NM="_ZL15evaluateCDTSizePKN5clang12FunctionDeclEN4llvm8ArrayRefIN12_GLOBAL__N_111ParamAttrTyEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL15evaluateCDTSizePKN5clang12FunctionDeclEN4llvm8ArrayRefIN12_GLOBAL__N_111ParamAttrTyEEE")
//</editor-fold>
public static /*uint*/int evaluateCDTSize(/*const*/ FunctionDecl /*P*/ FD, 
               ArrayRef<ParamAttrTy> ParamAttrs) {
  // Every vector variant of a SIMD-enabled function has a vector length (VLEN).
  // If OpenMP clause "simdlen" is used, the VLEN is the value of the argument
  // of that clause. The VLEN value must be power of 2.
  // In other case the notion of the function`s "characteristic data type" (CDT)
  // is used to compute the vector length.
  // CDT is defined in the following order:
  //   a) For non-void function, the CDT is the return type.
  //   b) If the function has any non-uniform, non-linear parameters, then the
  //   CDT is the type of the first such parameter.
  //   c) If the CDT determined by a) or b) above is struct, union, or class
  //   type which is pass-by-value (except for the type that maps to the
  //   built-in complex data type), the characteristic data type is int.
  //   d) If none of the above three cases is applicable, the CDT is int.
  // The VLEN is then determined based on the CDT and the size of vector
  // register of that ISA for which current vector version is generated. The
  // VLEN is computed using the formula below:
  //   VLEN  = sizeof(vector_register) / sizeof(CDT),
  // where vector register size specified in section 3.2.1 Registers and the
  // Stack Frame of original AMD64 ABI document.
  QualType RetType = FD.getReturnType();
  if (RetType.isNull()) {
    return 0;
  }
  final ASTContext /*&*/ C = FD.getASTContext();
  QualType CDT/*J*/= new QualType();
  if (!RetType.isNull() && !RetType.$arrow().isVoidType()) {
    CDT.$assign(RetType);
  } else {
    /*uint*/int Offset = 0;
    {
      /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(FD);
      if ((MD != null)) {
        if (ParamAttrs.$at(Offset).Kind == ParamKindTy.Vector) {
          CDT.$assignMove(C.getPointerType(C.getRecordType(MD.getParent$Const())));
        }
        ++Offset;
      }
    }
    if (CDT.isNull()) {
      for (/*uint*/int I = 0, E = FD.getNumParams(); $less_uint(I, E); ++I) {
        if (ParamAttrs.$at(I + Offset).Kind == ParamKindTy.Vector) {
          CDT.$assignMove(FD.getParamDecl$Const(I).getType());
          break;
        }
      }
    }
  }
  if (CDT.isNull()) {
    CDT.$assignMove(C.IntTy.$QualType());
  }
  CDT.$assignMove(CDT.$arrow().getCanonicalTypeUnqualified().$QualType());
  if (CDT.$arrow().isRecordType() || CDT.$arrow().isUnionType()) {
    CDT.$assignMove(C.IntTy.$QualType());
  }
  return $ulong2uint(C.getTypeSize(new QualType(CDT)));
}

//<editor-fold defaultstate="collapsed" desc="emitX86DeclareSimdFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 6327,
 FQN="emitX86DeclareSimdFunction", NM="_ZL26emitX86DeclareSimdFunctionPKN5clang12FunctionDeclEPN4llvm8FunctionENS3_6APSIntENS3_8ArrayRefIN12_GLOBAL__N_111ParamAttrTyEEENS_22OMPDeclareSimdDeclAttr13BranchStateTyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZL26emitX86DeclareSimdFunctionPKN5clang12FunctionDeclEPN4llvm8FunctionENS3_6APSIntENS3_8ArrayRefIN12_GLOBAL__N_111ParamAttrTyEEENS_22OMPDeclareSimdDeclAttr13BranchStateTyE")
//</editor-fold>
public static void emitX86DeclareSimdFunction(/*const*/ FunctionDecl /*P*/ FD, Function /*P*/ Fn, 
                          APSInt VLENVal, 
                          ArrayRef<ParamAttrTy> ParamAttrs, 
                          OMPDeclareSimdDeclAttr.BranchStateTy State) {
  //<editor-fold defaultstate="collapsed" desc="ISADataTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 6332,
   FQN="ISADataTy", NM="_ZZL26emitX86DeclareSimdFunctionPKN5clang12FunctionDeclEPN4llvm8FunctionENS3_6APSIntENS3_8ArrayRefIN12_GLOBAL__N_111ParamAttrTyEEENS_22OMPDeclareSimdDeclAttr13BranchStateTyEE9ISADataTy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZZL26emitX86DeclareSimdFunctionPKN5clang12FunctionDeclEPN4llvm8FunctionENS3_6APSIntENS3_8ArrayRefIN12_GLOBAL__N_111ParamAttrTyEEENS_22OMPDeclareSimdDeclAttr13BranchStateTyEE9ISADataTy")
  //</editor-fold>
   class/*struct*/ ISADataTy {
    public /*char*/byte ISA;
    public /*uint*/int VecRegSize;
    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public ISADataTy(byte ISA, int VecRegSize) {
      this.ISA = ISA;
      this.VecRegSize = VecRegSize;
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "ISA=" + ISA // NOI18N
                + ", VecRegSize=" + VecRegSize; // NOI18N
    }
  };
  ISADataTy ISAData[/*4*/] = new ISADataTy [/*4*/] {
    new ISADataTy(
      $$b, 128
    ),  // SSE
    new ISADataTy(
      $$c, 256
    ),  // AVX
    new ISADataTy(
      $$d, 256
    ),  // AVX2
    new ISADataTy(
      $$e, 512
    ) // AVX512
  };
  SmallString Masked/*J*/= new SmallString(2);
  switch (State) {
   case BS_Undefined:
    Masked.push_back($$N);
    Masked.push_back($$M);
    break;
   case BS_Notinbranch:
    Masked.push_back($$N);
    break;
   case BS_Inbranch:
    Masked.push_back($$M);
    break;
  }
  for (/*char*/byte Mask : Masked) {
    for (final ISADataTy /*&*/ Data : ISAData) {
      raw_svector_ostream Out = null;
      try {
        SmallString/*<256>*/ Buffer/*J*/= new SmallString/*<256>*/(256);
        Out/*J*/= new raw_svector_ostream(Buffer);
        Out.$out(/*KEEP_STR*/"_ZGV").$out_char(Data.ISA).$out_char(Mask);
        if (VLENVal.$not()) {
          $out_raw_ostream_APSInt$C(Out, APSInt.getUnsigned($uint2ulong($div_uint(Data.VecRegSize
                    , evaluateCDTSize(FD, new ArrayRef<ParamAttrTy>(ParamAttrs))))));
        } else {
          $out_raw_ostream_APSInt$C(Out, VLENVal);
        }
        for (final /*const*/ ParamAttrTy /*&*/ ParamAttr : ParamAttrs) {
          switch (ParamAttr.Kind) {
           case LinearWithVarStride:
            $out_raw_ostream_APSInt$C(Out.$out_char($$s), ParamAttr.StrideOrArg);
            break;
           case Linear:
            Out.$out_char($$l);
            if (!ParamAttr.StrideOrArg.$not()) {
              $out_raw_ostream_APSInt$C(Out, ParamAttr.StrideOrArg);
            }
            break;
           case Uniform:
            Out.$out_char($$u);
            break;
           case Vector:
            Out.$out_char($$v);
            break;
          }
          if (!ParamAttr.Alignment.$not()) {
            $out_raw_ostream_APSInt$C(Out.$out_char($$a), ParamAttr.Alignment);
          }
        }
        Out.$out_char($$UNDERSCORE).$out(Fn.getName());
        Fn.addFnAttr(Out.str());
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
  }
}

} // END OF class CGOpenMPRuntimeStatics
