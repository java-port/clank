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
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.*;
import org.clang.ast.ArrayType;
import org.llvm.ir.FunctionType;
import org.llvm.ir.Type;
import org.clang.ast.BinaryOperator;
import static org.clang.ast.CharUnitsGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.codegen.impl.CGObjCStatics.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGObjC">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGObjC",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGExprScalar ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12LoadObjCSelfEv;_ZN5clang7CodeGen15CodeGenFunction13EmitARCRetainENS_8QualTypeEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction14EmitARCReleaseEPN4llvm5ValueENS0_20ARCPreciseLifetime_tE;_ZN5clang7CodeGen15CodeGenFunction14destroyARCWeakERS1_NS0_7AddressENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction15EmitARCCopyWeakENS0_7AddressES2_;_ZN5clang7CodeGen15CodeGenFunction15EmitARCInitWeakENS0_7AddressEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction15EmitARCLoadWeakENS0_7AddressE;_ZN5clang7CodeGen15CodeGenFunction15EmitARCMoveWeakENS0_7AddressES2_;_ZN5clang7CodeGen15CodeGenFunction15StartObjCMethodEPKNS_14ObjCMethodDeclEPKNS_17ObjCContainerDeclE;_ZN5clang7CodeGen15CodeGenFunction16EmitARCStoreWeakENS0_7AddressEPN4llvm5ValueEb;_ZN5clang7CodeGen15CodeGenFunction16TypeOfSelfObjectEv;_ZN5clang7CodeGen15CodeGenFunction17EmitObjCAtTryStmtERKNS_13ObjCAtTryStmtE;_ZN5clang7CodeGen15CodeGenFunction17EmitObjCBoxedExprEPKNS_13ObjCBoxedExprE;_ZN5clang7CodeGen15CodeGenFunction18EmitARCAutoreleaseEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction18EmitARCDestroyWeakENS0_7AddressE;_ZN5clang7CodeGen15CodeGenFunction18EmitARCRetainBlockEPN4llvm5ValueEb;_ZN5clang7CodeGen15CodeGenFunction18EmitARCStoreStrongENS0_6LValueEPN4llvm5ValueEb;_ZN5clang7CodeGen15CodeGenFunction18EmitARCStoreStrongEPKNS_14BinaryOperatorEb;_ZN5clang7CodeGen15CodeGenFunction18GenerateObjCGetterEPNS_22ObjCImplementationDeclEPKNS_20ObjCPropertyImplDeclE;_ZN5clang7CodeGen15CodeGenFunction18GenerateObjCMethodEPKNS_14ObjCMethodDeclE;_ZN5clang7CodeGen15CodeGenFunction18GenerateObjCSetterEPNS_22ObjCImplementationDeclEPKNS_20ObjCPropertyImplDeclE;_ZN5clang7CodeGen15CodeGenFunction19EmitARCIntrinsicUseEN4llvm8ArrayRefIPNS2_5ValueEEE;_ZN5clang7CodeGen15CodeGenFunction19EmitObjCAtThrowStmtERKNS_15ObjCAtThrowStmtE;_ZN5clang7CodeGen15CodeGenFunction19EmitObjCMessageExprEPKNS_15ObjCMessageExprENS0_15ReturnValueSlotE;_ZN5clang7CodeGen15CodeGenFunction20EmitARCDestroyStrongENS0_7AddressENS0_20ARCPreciseLifetime_tE;_ZN5clang7CodeGen15CodeGenFunction20EmitExtendGCLifetimeEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction20EmitObjCArrayLiteralEPKNS_16ObjCArrayLiteralE;_ZN5clang7CodeGen15CodeGenFunction20EmitObjCProtocolExprEPKNS_16ObjCProtocolExprE;_ZN5clang7CodeGen15CodeGenFunction20EmitObjCSelectorExprEPKNS_16ObjCSelectorExprE;_ZN5clang7CodeGen15CodeGenFunction20EmitObjCThrowOperandEPKNS_4ExprE;_ZN5clang7CodeGen15CodeGenFunction21EmitARCRetainNonBlockEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction21EmitObjCConsumeObjectENS_8QualTypeEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction21EmitObjCStringLiteralEPKNS_17ObjCStringLiteralE;_ZN5clang7CodeGen15CodeGenFunction22EmitARCStoreStrongCallENS0_7AddressEPN4llvm5ValueEb;_ZN5clang7CodeGen15CodeGenFunction22generateObjCGetterBodyEPKNS_22ObjCImplementationDeclEPKNS_20ObjCPropertyImplDeclEPKNS_14ObjCMethodDeclEPN4llvm8ConstantE;_ZN5clang7CodeGen15CodeGenFunction22generateObjCSetterBodyEPKNS_22ObjCImplementationDeclEPKNS_20ObjCPropertyImplDeclEPN4llvm8ConstantE;_ZN5clang7CodeGen15CodeGenFunction23EmitARCLoadWeakRetainedENS0_7AddressE;_ZN5clang7CodeGen15CodeGenFunction23EmitARCRetainScalarExprEPKNS_4ExprE;_ZN5clang7CodeGen15CodeGenFunction23destroyARCStrongPreciseERS1_NS0_7AddressENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction24EmitARCExtendBlockObjectEPKNS_4ExprE;_ZN5clang7CodeGen15CodeGenFunction24EmitARCRetainAutoreleaseENS_8QualTypeEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction25EmitARCStoreAutoreleasingEPKNS_14BinaryOperatorE;_ZN5clang7CodeGen15CodeGenFunction25EmitObjCCollectionLiteralEPKNS_4ExprEPKNS_14ObjCMethodDeclE;_ZN5clang7CodeGen15CodeGenFunction25EmitObjCDictionaryLiteralEPKNS_21ObjCDictionaryLiteralE;_ZN5clang7CodeGen15CodeGenFunction25EmitObjCForCollectionStmtERKNS_21ObjCForCollectionStmtE;_ZN5clang7CodeGen15CodeGenFunction25destroyARCStrongImpreciseERS1_NS0_7AddressENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction26EmitObjCAtSynchronizedStmtERKNS_22ObjCAtSynchronizedStmtE;_ZN5clang7CodeGen15CodeGenFunction26EmitObjCAutoreleasePoolPopEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction26GenerateObjCCtorDtorMethodEPNS_22ObjCImplementationDeclEPNS_14ObjCMethodDeclEb;_ZN5clang7CodeGen15CodeGenFunction27EmitBlockCopyAndAutoreleaseEPN4llvm5ValueENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction27EmitObjCAutoreleasePoolPushEv;_ZN5clang7CodeGen15CodeGenFunction27EmitObjCAutoreleasePoolStmtERKNS_23ObjCAutoreleasePoolStmtE;_ZN5clang7CodeGen15CodeGenFunction28EmitARCReclaimReturnedObjectEPKNS_4ExprEb;_ZN5clang7CodeGen15CodeGenFunction28EmitARCStoreUnsafeUnretainedEPKNS_14BinaryOperatorEb;_ZN5clang7CodeGen15CodeGenFunction28EmitObjCExtendObjectLifetimeENS_8QualTypeEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction29EmitARCAutoreleaseReturnValueEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction29EmitObjCMRRAutoreleasePoolPopEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction30EmitObjCAutoreleasePoolCleanupEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction30EmitObjCMRRAutoreleasePoolPushEv;_ZN5clang7CodeGen15CodeGenFunction32EmitARCRetainAutoreleaseNonBlockEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction33EmitARCUnsafeUnretainedScalarExprEPKNS_4ExprE;_ZN5clang7CodeGen15CodeGenFunction34EmitARCRetainAutoreleaseScalarExprEPKNS_4ExprE;_ZN5clang7CodeGen15CodeGenFunction35EmitARCRetainAutoreleaseReturnValueEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction36EmitARCRetainAutoreleasedReturnValueEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction41EmitARCUnsafeClaimAutoreleasedReturnValueEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction42GenerateObjCAtomicGetterCopyHelperFunctionEPKNS_20ObjCPropertyImplDeclE;_ZN5clang7CodeGen15CodeGenFunction42GenerateObjCAtomicSetterCopyHelperFunctionEPKNS_20ObjCPropertyImplDeclE; -static-type=CodeGenFunction_CGObjC -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGObjC extends CodeGenFunction_CGExprScalar {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGObjC(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}


//===--------------------------------------------------------------------===//
//                                  Objective-C
//===--------------------------------------------------------------------===//

/// Generate an Objective-C method.  An Objective-C method is a C function with
/// its pointer, name, and types registered in the class struture.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateObjCMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 558,
 FQN="clang::CodeGen::CodeGenFunction::GenerateObjCMethod", NM="_ZN5clang7CodeGen15CodeGenFunction18GenerateObjCMethodEPKNS_14ObjCMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18GenerateObjCMethodEPKNS_14ObjCMethodDeclE")
//</editor-fold>
public final void GenerateObjCMethod(/*const*/ ObjCMethodDecl /*P*/ OMD) {
  $this().StartObjCMethod(OMD, OMD.getClassInterface$Const());
  $this().PGO.assignRegionCounters(new GlobalDecl(OMD), $this().CurFn);
  assert (isa_CompoundStmt(OMD.getBody()));
  $this().incrementProfileCounter(OMD.getBody());
  $this().EmitCompoundStmtWithoutScope($Deref(cast_CompoundStmt(OMD.getBody())));
  $this().FinishFunction(OMD.getBodyRBrace());
}


/// StartObjCMethod - Begin emission of an ObjCMethod. This generates
/// the LLVM function and sets the other context used by
/// CodeGenFunction.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::StartObjCMethod">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 518,
 FQN="clang::CodeGen::CodeGenFunction::StartObjCMethod", NM="_ZN5clang7CodeGen15CodeGenFunction15StartObjCMethodEPKNS_14ObjCMethodDeclEPKNS_17ObjCContainerDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15StartObjCMethodEPKNS_14ObjCMethodDeclEPKNS_17ObjCContainerDeclE")
//</editor-fold>
public final void StartObjCMethod(/*const*/ ObjCMethodDecl /*P*/ OMD, 
               /*const*/ ObjCContainerDecl /*P*/ CD) {
  FunctionArgList args = null;
  try {
    SourceLocation StartLoc = OMD.getLocStart();
    args/*J*/= new FunctionArgList();
    // Check if we should generate debug info for this method.
    if (OMD.hasAttr(NoDebugAttr.class)) {
      $this().DebugInfo = null; // disable debug info indefinitely for this function
    }
    
    Function /*P*/ Fn = $this().CGM.getObjCRuntime().GenerateMethod(OMD, CD);
    
    final /*const*/ CGFunctionInfo /*&*/ FI = $this().CGM.getTypes().arrangeObjCMethodDeclaration(OMD);
    $this().CGM.SetInternalFunctionAttributes(OMD, Fn, FI);
    
    args.push_back(OMD.getSelfDecl());
    args.push_back(OMD.getCmdDecl());
    
    args.append_T(OMD.param_begin$Const(), OMD.param_end$Const());
    
    $this().CurGD.$assignMove(new GlobalDecl(OMD));
    $this().CurEHLocation.$assignMove(OMD.getLocEnd());
    
    $this().StartFunction(new GlobalDecl(OMD), OMD.getReturnType(), Fn, FI, args, 
        OMD.getLocation(), new SourceLocation(StartLoc));
    
    // In ARC, certain methods get an extra cleanup.
    if ($this().CGM.getLangOpts().ObjCAutoRefCount
       && OMD.isInstanceMethod()
       && OMD.getSelector().isUnarySelector()) {
      /*const*/ IdentifierInfo /*P*/ ident = OMD.getSelector().getIdentifierInfoForSlot(0);
      if (ident.isStr(/*KEEP_STR*/"dealloc")) {
        $this().EHStack.<FinishARCDealloc>pushCleanup$T($this().getARCCleanupKind(), () -> new FinishARCDealloc());
      }
    }
  } finally {
    if (args != null) { args.$destroy(); }
  }
}


/// GenerateObjCGetter - Synthesize an Objective-C property getter function.

/// \brief Generate an Objective-C property getter function.
///
/// The given Decl must be an ObjCImplementationDecl. \@synthesize
/// is illegal within a category.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateObjCGetter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 795,
 FQN="clang::CodeGen::CodeGenFunction::GenerateObjCGetter", NM="_ZN5clang7CodeGen15CodeGenFunction18GenerateObjCGetterEPNS_22ObjCImplementationDeclEPKNS_20ObjCPropertyImplDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18GenerateObjCGetterEPNS_22ObjCImplementationDeclEPKNS_20ObjCPropertyImplDeclE")
//</editor-fold>
public final void GenerateObjCGetter(ObjCImplementationDecl /*P*/ IMP, 
                  /*const*/ ObjCPropertyImplDecl /*P*/ PID) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Constant /*P*/ AtomicHelperFn = $c$.clean($c$.track(new CodeGenFunction($this().CGM)).GenerateObjCAtomicGetterCopyHelperFunction(PID));
    /*const*/ ObjCPropertyDecl /*P*/ PD = PID.getPropertyDecl();
    ObjCMethodDecl /*P*/ OMD = PD.getGetterMethodDecl();
    assert ((OMD != null)) : "Invalid call to generate getter (empty method)";
    $this().StartObjCMethod(OMD, IMP.getClassInterface());
    
    $this().generateObjCGetterBody(IMP, PID, OMD, AtomicHelperFn);
    
    $this().FinishFunction();
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::generateObjCGetterBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 862,
 FQN="clang::CodeGen::CodeGenFunction::generateObjCGetterBody", NM="_ZN5clang7CodeGen15CodeGenFunction22generateObjCGetterBodyEPKNS_22ObjCImplementationDeclEPKNS_20ObjCPropertyImplDeclEPKNS_14ObjCMethodDeclEPN4llvm8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22generateObjCGetterBodyEPKNS_22ObjCImplementationDeclEPKNS_20ObjCPropertyImplDeclEPKNS_14ObjCMethodDeclEPN4llvm8ConstantE")
//</editor-fold>
public final void generateObjCGetterBody(/*const*/ ObjCImplementationDecl /*P*/ classImpl, 
                      /*const*/ ObjCPropertyImplDecl /*P*/ propImpl, 
                      /*const*/ ObjCMethodDecl /*P*/ GetterMethodDecl, 
                      Constant /*P*/ AtomicHelperFn) {
  // If there's a non-trivial 'get' expression, we just have to emit that.
  if (!CGObjCStatics.hasTrivialGetExpr(propImpl)) {
    if (!(AtomicHelperFn != null)) {
      ReturnStmt ret/*J*/= new ReturnStmt(new SourceLocation(), propImpl.getGetterCXXConstructor(), 
          /*nrvo*/ (/*const*/ VarDecl /*P*/ )null);
      $this().EmitReturnStmt(ret);
    } else {
      ObjCIvarDecl /*P*/ ivar = propImpl.getPropertyIvarDecl();
      CGObjCStatics.emitCPPObjectAtomicGetterCall(/*Deref*/$this(), $this().ReturnValue.getPointer(), 
          ivar, AtomicHelperFn);
    }
    return;
  }
  
  /*const*/ ObjCPropertyDecl /*P*/ prop = propImpl.getPropertyDecl();
  QualType propType = prop.getType();
  ObjCMethodDecl /*P*/ getterMethod = prop.getGetterMethodDecl();
  
  ObjCIvarDecl /*P*/ ivar = propImpl.getPropertyIvarDecl();
  
  // Pick an implementation strategy.
  PropertyImplStrategy strategy/*J*/= new PropertyImplStrategy($this().CGM, propImpl);
  switch (strategy.getKind()) {
   case Native:
    {
      // We don't need to do anything for a zero-size struct.
      if (strategy.getIvarSize().isZero()) {
        return;
      }
      
      LValue LV = $this().EmitLValueForIvar($this().TypeOfSelfObject(), $this().LoadObjCSelf(), ivar, 0);
      
      // Currently, all atomic accesses have to be through integer
      // types, so there's no point in trying to pick a prettier type.
      long/*uint64_t*/ ivarSize = $this().getContext().toBits(strategy.getIvarSize());
      org.llvm.ir.Type /*P*/ bitcastType = org.llvm.ir.Type.getIntNTy($this().getLLVMContext(), $ulong2uint(ivarSize));
      bitcastType = bitcastType.getPointerTo(); // addrspace 0 okay
      
      // Perform an atomic load.  This does not impose ordering constraints.
      Address ivarAddr = LV.getAddress();
      ivarAddr.$assignMove($this().Builder.CreateBitCast(new Address(ivarAddr), bitcastType));
      LoadInst /*P*/ load = $this().Builder.CreateLoad(new Address(ivarAddr), $("load"));
      load.setAtomic(AtomicOrdering.Unordered);
      
      // Store that value into the return address.  Doing this with a
      // bitcast is likely to produce some pretty ugly IR, but it's not
      // the *most* terrible thing in the world.
      org.llvm.ir.Type /*P*/ retTy = $this().ConvertType(getterMethod.getReturnType());
      long/*uint64_t*/ retTySize = $this().CGM.getDataLayout().getTypeSizeInBits(retTy);
      Value /*P*/ ivarVal = load;
      if ($greater_ulong(ivarSize, retTySize)) {
        org.llvm.ir.Type /*P*/ newTy = org.llvm.ir.Type.getIntNTy($this().getLLVMContext(), $ulong2uint(retTySize));
        ivarVal = $this().Builder.CreateTrunc(load, newTy);
        bitcastType = newTy.getPointerTo();
      }
      $this().Builder.CreateStore(ivarVal, 
          $this().Builder.CreateBitCast(new Address($this().ReturnValue), bitcastType));
      
      // Make sure we don't do an autorelease.
      $this().AutoreleaseResult = false;
      return;
    }
   case GetSetProperty:
    {
      CallArgList args = null;
      try {
        Value /*P*/ getPropertyFn = $this().CGM.getObjCRuntime().GetPropertyGetFunction();
        if (!(getPropertyFn != null)) {
          $this().CGM.ErrorUnsupported(propImpl, $("Obj-C getter requiring atomic copy"));
          return;
        }
        
        // Return (ivar-type) objc_getProperty((id) self, _cmd, offset, true).
        // FIXME: Can't this be simpler? This might even be worse than the
        // corresponding gcc code.
        Value /*P*/ cmd = $this().Builder.CreateLoad($this().GetAddrOfLocalVar(getterMethod.getCmdDecl()), $("cmd"));
        Value /*P*/ self = $this().Builder.CreateBitCast($this().LoadObjCSelf(), Unnamed_field9.VoidPtrTy);
        Value /*P*/ ivarOffset = $this().EmitIvarOffset(classImpl.getClassInterface$Const(), ivar);
        
        args/*J*/= new CallArgList();
        args.add(RValue.get(self), $this().getContext().getObjCIdType());
        args.add(RValue.get(cmd), $this().getContext().getObjCSelType());
        args.add(RValue.get(ivarOffset), $this().getContext().getPointerDiffType());
        args.add(RValue.get($this().Builder.getInt1(strategy.isAtomic())), 
            $this().getContext().BoolTy.$QualType());
        
        // FIXME: We shouldn't need to get the function info here, the
        // runtime already should have computed it to build the function.
        type$ptr<Instruction /*P*/ > CallInstruction = create_type$null$ptr();
        RValue RV = $this().EmitCall($this().getTypes().arrangeBuiltinFunctionCall(new QualType(propType), args), 
            getPropertyFn, new ReturnValueSlot(), args, new CGCalleeInfo(), 
            $AddrOf(CallInstruction));
        {
          CallInst /*P*/ call = dyn_cast_CallInst(CallInstruction.$star());
          if ((call != null)) {
            call.setTailCall();
          }
        }
        
        // We need to fix the type here. Ivars with copy & retain are
        // always objects so we don't need to worry about complex or
        // aggregates.
        RV.$assignMove(RValue.get($this().Builder.CreateBitCast(RV.getScalarVal(), 
                    $this().getTypes().ConvertType(getterMethod.getReturnType()))));
        
        $this().EmitReturnOfRValue(new RValue(RV), new QualType(propType));
        
        // objc_getProperty does an autorelease, so we should suppress ours.
        $this().AutoreleaseResult = false;
        
        return;
      } finally {
        if (args != null) { args.$destroy(); }
      }
    }
   case CopyStruct:
    CGObjCStatics.emitStructGetterCall(/*Deref*/$this(), ivar, strategy.isAtomic(), 
        strategy.hasStrongMember());
    return;
   case Expression:
   case SetPropertyAndExpressionGet:
    {
      LValue LV = $this().EmitLValueForIvar($this().TypeOfSelfObject(), $this().LoadObjCSelf(), ivar, 0);
      
      QualType ivarType = ivar.getType();
      switch (CodeGenFunction.getEvaluationKind(new QualType(ivarType))) {
       case TEK_Complex:
        {
          std.pair<Value /*P*/ , Value /*P*/ > pair = $this().EmitLoadOfComplex(new LValue(LV), new SourceLocation());
          $this().EmitStoreOfComplex(new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(pair), $this().MakeAddrLValue(new Address($this().ReturnValue), new QualType(ivarType)), 
              /*init*/ true);
          return;
        }
       case TEK_Aggregate:
        // The return value slot is guaranteed to not be aliased, but
        // that's not necessarily the same as "on the stack", so
        // we still potentially need objc_memmove_collectable.
        $this().EmitAggregateCopy(new Address($this().ReturnValue), LV.getAddress(), new QualType(ivarType));
        return;
       case TEK_Scalar:
        {
          Value /*P*/ value;
          if (propType.$arrow().isReferenceType()) {
            value = LV.getAddress().getPointer();
          } else {
            // We want to load and autoreleaseReturnValue ARC __weak ivars.
            if (LV.getQuals().getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Weak) {
              if ($this().getLangOpts().ObjCAutoRefCount) {
                value = CGObjCStatics.emitARCRetainLoadOfScalar(/*Deref*/$this(), new LValue(LV), new QualType(ivarType));
              } else {
                value = $this().EmitARCLoadWeak(LV.getAddress());
              }
              // Otherwise we want to do a simple load, suppressing the
              // final autorelease.
            } else {
              value = $this().EmitLoadOfLValue(new LValue(LV), new SourceLocation()).getScalarVal();
              $this().AutoreleaseResult = false;
            }
            
            value = $this().Builder.CreateBitCast(value, $this().ConvertType(GetterMethodDecl.getReturnType()));
          }
          
          $this().EmitReturnOfRValue(RValue.get(value), new QualType(propType));
          return;
        }
      }
      throw new llvm_unreachable("bad evaluation kind");
    }
  }
  throw new llvm_unreachable("bad @property implementation strategy!");
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateObjCCtorDtorMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1402,
 FQN="clang::CodeGen::CodeGenFunction::GenerateObjCCtorDtorMethod", NM="_ZN5clang7CodeGen15CodeGenFunction26GenerateObjCCtorDtorMethodEPNS_22ObjCImplementationDeclEPNS_14ObjCMethodDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26GenerateObjCCtorDtorMethodEPNS_22ObjCImplementationDeclEPNS_14ObjCMethodDeclEb")
//</editor-fold>
public final void GenerateObjCCtorDtorMethod(ObjCImplementationDecl /*P*/ IMP, 
                          ObjCMethodDecl /*P*/ MD, 
                          boolean ctor) {
  MD.createImplicitParams($this().CGM.getContext(), IMP.getClassInterface());
  $this().StartObjCMethod(MD, IMP.getClassInterface());
  
  // Emit .cxx_construct.
  if (ctor) {
    // Suppress the final autorelease in ARC.
    $this().AutoreleaseResult = false;
    
    for (/*const*/ CXXCtorInitializer /*P*/ IvarInit : IMP.inits()) {
      FieldDecl /*P*/ Field = IvarInit.getAnyMember();
      ObjCIvarDecl /*P*/ Ivar = cast_ObjCIvarDecl(Field);
      LValue LV = $this().EmitLValueForIvar($this().TypeOfSelfObject(), 
          $this().LoadObjCSelf(), Ivar, 0);
      $this().EmitAggExpr(IvarInit.getInit(), 
          AggValueSlot.forLValue(LV, AggValueSlot.IsDestructed_t.IsDestructed, 
              AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers, 
              AggValueSlot.IsAliased_t.IsNotAliased));
    }
    // constructor returns 'self'.
    final CodeGenTypes /*&*/ Types = $this().CGM.getTypes();
    QualType IdTy/*J*/= $this().CGM.getContext().getObjCIdType();
    Value /*P*/ SelfAsId = $this().Builder.CreateBitCast($this().LoadObjCSelf(), Types.ConvertType(new QualType(IdTy)));
    $this().EmitReturnOfRValue(RValue.get(SelfAsId), new QualType(IdTy));
    // Emit .cxx_destruct.
  } else {
    CGObjCStatics.emitCXXDestructMethod(/*Deref*/$this(), IMP);
  }
  $this().FinishFunction();
}


/// GenerateObjCSetter - Synthesize an Objective-C property setter function
/// for the given property.

/// \brief Generate an Objective-C property setter function.
///
/// The given Decl must be an ObjCImplementationDecl. \@synthesize
/// is illegal within a category.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateObjCSetter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1321,
 FQN="clang::CodeGen::CodeGenFunction::GenerateObjCSetter", NM="_ZN5clang7CodeGen15CodeGenFunction18GenerateObjCSetterEPNS_22ObjCImplementationDeclEPKNS_20ObjCPropertyImplDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18GenerateObjCSetterEPNS_22ObjCImplementationDeclEPKNS_20ObjCPropertyImplDeclE")
//</editor-fold>
public final void GenerateObjCSetter(ObjCImplementationDecl /*P*/ IMP, 
                  /*const*/ ObjCPropertyImplDecl /*P*/ PID) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Constant /*P*/ AtomicHelperFn = $c$.clean($c$.track(new CodeGenFunction($this().CGM)).GenerateObjCAtomicSetterCopyHelperFunction(PID));
    /*const*/ ObjCPropertyDecl /*P*/ PD = PID.getPropertyDecl();
    ObjCMethodDecl /*P*/ OMD = PD.getSetterMethodDecl();
    assert ((OMD != null)) : "Invalid call to generate setter (empty method)";
    $this().StartObjCMethod(OMD, IMP.getClassInterface());
    
    $this().generateObjCSetterBody(IMP, PID, AtomicHelperFn);
    
    $this().FinishFunction();
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::generateObjCSetterBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1144,
 FQN="clang::CodeGen::CodeGenFunction::generateObjCSetterBody", NM="_ZN5clang7CodeGen15CodeGenFunction22generateObjCSetterBodyEPKNS_22ObjCImplementationDeclEPKNS_20ObjCPropertyImplDeclEPN4llvm8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22generateObjCSetterBodyEPKNS_22ObjCImplementationDeclEPKNS_20ObjCPropertyImplDeclEPN4llvm8ConstantE")
//</editor-fold>
public final void generateObjCSetterBody(/*const*/ ObjCImplementationDecl /*P*/ classImpl, 
                      /*const*/ ObjCPropertyImplDecl /*P*/ propImpl, 
                      Constant /*P*/ AtomicHelperFn) {
  /*const*/ ObjCPropertyDecl /*P*/ prop = propImpl.getPropertyDecl();
  ObjCIvarDecl /*P*/ ivar = propImpl.getPropertyIvarDecl();
  ObjCMethodDecl /*P*/ setterMethod = prop.getSetterMethodDecl();
  
  // Just use the setter expression if Sema gave us one and it's
  // non-trivial.
  if (!CGObjCStatics.hasTrivialSetExpr(propImpl)) {
    if (!(AtomicHelperFn != null)) {
      // If non-atomic, assignment is called directly.
      $this().EmitStmt(propImpl.getSetterCXXAssignment());
    } else {
      // If atomic, assignment is called via a locking api.
      CGObjCStatics.emitCPPObjectAtomicSetterCall(/*Deref*/$this(), setterMethod, ivar, 
          AtomicHelperFn);
    }
    return;
  }
  
  PropertyImplStrategy strategy/*J*/= new PropertyImplStrategy($this().CGM, propImpl);
  switch (strategy.getKind()) {
   case Native:
    {
      // We don't need to do anything for a zero-size struct.
      if (strategy.getIvarSize().isZero()) {
        return;
      }
      
      Address argAddr = $this().GetAddrOfLocalVar(setterMethod.param_begin().$star());
      
      LValue ivarLValue = $this().EmitLValueForIvar($this().TypeOfSelfObject(), $this().LoadObjCSelf(), ivar, /*quals*/ 0);
      Address ivarAddr = ivarLValue.getAddress();
      
      // Currently, all atomic accesses have to be through integer
      // types, so there's no point in trying to pick a prettier type.
      org.llvm.ir.Type /*P*/ bitcastType = org.llvm.ir.Type.getIntNTy($this().getLLVMContext(), 
          $long2uint($this().getContext().toBits(strategy.getIvarSize())));
      
      // Cast both arguments to the chosen operation type.
      argAddr.$assignMove($this().Builder.CreateElementBitCast(new Address(argAddr), bitcastType));
      ivarAddr.$assignMove($this().Builder.CreateElementBitCast(new Address(ivarAddr), bitcastType));
      
      // This bitcast load is likely to cause some nasty IR.
      Value /*P*/ load = $this().Builder.CreateLoad(new Address(argAddr));
      
      // Perform an atomic store.  There are no memory ordering requirements.
      StoreInst /*P*/ store = $this().Builder.CreateStore(load, new Address(ivarAddr));
      store.setAtomic(AtomicOrdering.Unordered);
      return;
    }
   case GetSetProperty:
   case SetPropertyAndExpressionGet:
    {
      CallArgList args = null;
      try {
        
        Value /*P*/ setOptimizedPropertyFn = null;
        Value /*P*/ setPropertyFn = null;
        if (CGObjCStatics.UseOptimizedSetter($this().CGM)) {
          // 10.8 and iOS 6.0 code and GC is off
          setOptimizedPropertyFn
             = $this().CGM.getObjCRuntime().
              GetOptimizedPropertySetFunction(strategy.isAtomic(), 
              strategy.isCopy());
          if (!(setOptimizedPropertyFn != null)) {
            $this().CGM.ErrorUnsupported(propImpl, $("Obj-C optimized setter - NYI"));
            return;
          }
        } else {
          setPropertyFn = $this().CGM.getObjCRuntime().GetPropertySetFunction();
          if (!(setPropertyFn != null)) {
            $this().CGM.ErrorUnsupported(propImpl, $("Obj-C setter requiring atomic copy"));
            return;
          }
        }
        
        // Emit objc_setProperty((id) self, _cmd, offset, arg,
        //                       <is-atomic>, <is-copy>).
        Value /*P*/ cmd = $this().Builder.CreateLoad($this().GetAddrOfLocalVar(setterMethod.getCmdDecl()));
        Value /*P*/ self = $this().Builder.CreateBitCast($this().LoadObjCSelf(), Unnamed_field9.VoidPtrTy);
        Value /*P*/ ivarOffset = $this().EmitIvarOffset(classImpl.getClassInterface$Const(), ivar);
        Address argAddr = $this().GetAddrOfLocalVar(setterMethod.param_begin().$star());
        Value /*P*/ arg = $this().Builder.CreateLoad(new Address(argAddr), $("arg"));
        arg = $this().Builder.CreateBitCast(arg, Unnamed_field9.VoidPtrTy);
        
        args/*J*/= new CallArgList();
        args.add(RValue.get(self), $this().getContext().getObjCIdType());
        args.add(RValue.get(cmd), $this().getContext().getObjCSelType());
        if ((setOptimizedPropertyFn != null)) {
          args.add(RValue.get(arg), $this().getContext().getObjCIdType());
          args.add(RValue.get(ivarOffset), $this().getContext().getPointerDiffType());
          $this().EmitCall($this().getTypes().arrangeBuiltinFunctionCall($this().getContext().VoidTy.$QualType(), args), 
              setOptimizedPropertyFn, new ReturnValueSlot(), args);
        } else {
          args.add(RValue.get(ivarOffset), $this().getContext().getPointerDiffType());
          args.add(RValue.get(arg), $this().getContext().getObjCIdType());
          args.add(RValue.get($this().Builder.getInt1(strategy.isAtomic())), 
              $this().getContext().BoolTy.$QualType());
          args.add(RValue.get($this().Builder.getInt1(strategy.isCopy())), 
              $this().getContext().BoolTy.$QualType());
          // FIXME: We shouldn't need to get the function info here, the runtime
          // already should have computed it to build the function.
          $this().EmitCall($this().getTypes().arrangeBuiltinFunctionCall($this().getContext().VoidTy.$QualType(), args), 
              setPropertyFn, new ReturnValueSlot(), args);
        }
        
        return;
      } finally {
        if (args != null) { args.$destroy(); }
      }
    }
   case CopyStruct:
    CGObjCStatics.emitStructSetterCall(/*Deref*/$this(), setterMethod, ivar);
    return;
   case Expression:
    break;
  }
  
  // Otherwise, fake up some ASTs and emit a normal assignment.
  ValueDecl /*P*/ selfDecl = setterMethod.getSelfDecl();
  DeclRefExpr self/*J*/= new DeclRefExpr(selfDecl, false, selfDecl.getType(), 
      ExprValueKind.VK_LValue, new SourceLocation());
  ImplicitCastExpr selfLoad/*J*/= new ImplicitCastExpr(ImplicitCastExpr.OnStack_t.OnStack, 
      selfDecl.getType(), CastKind.CK_LValueToRValue, $AddrOf(self), 
      ExprValueKind.VK_RValue);
  ObjCIvarRefExpr ivarRef/*J*/= new ObjCIvarRefExpr(ivar, ivar.getType().getNonReferenceType(), 
      new SourceLocation(), new SourceLocation(), 
      $AddrOf(selfLoad), true, true);
  
  ParmVarDecl /*P*/ argDecl = setterMethod.param_begin().$star();
  QualType argType = argDecl.getType().getNonReferenceType();
  DeclRefExpr arg/*J*/= new DeclRefExpr(argDecl, false, new QualType(argType), ExprValueKind.VK_LValue, new SourceLocation());
  ImplicitCastExpr argLoad/*J*/= new ImplicitCastExpr(ImplicitCastExpr.OnStack_t.OnStack, 
      argType.getUnqualifiedType(), CastKind.CK_LValueToRValue, 
      $AddrOf(arg), ExprValueKind.VK_RValue);
  
  // The property type can differ from the ivar type in some situations with
  // Objective-C pointer types, we can always bit cast the RHS in these cases.
  // The following absurdity is just to ensure well-formed IR.
  CastKind argCK = CastKind.CK_NoOp;
  if (ivarRef.getType().$arrow().isObjCObjectPointerType()) {
    if (argLoad.getType().$arrow().isObjCObjectPointerType()) {
      argCK = CastKind.CK_BitCast;
    } else if (argLoad.getType().$arrow().isBlockPointerType()) {
      argCK = CastKind.CK_BlockPointerToObjCPointerCast;
    } else {
      argCK = CastKind.CK_CPointerToObjCPointerCast;
    }
  } else if (ivarRef.getType().$arrow().isBlockPointerType()) {
    if (argLoad.getType().$arrow().isBlockPointerType()) {
      argCK = CastKind.CK_BitCast;
    } else {
      argCK = CastKind.CK_AnyPointerToBlockPointerCast;
    }
  } else if (ivarRef.getType().$arrow().isPointerType()) {
    argCK = CastKind.CK_BitCast;
  }
  ImplicitCastExpr argCast/*J*/= new ImplicitCastExpr(ImplicitCastExpr.OnStack_t.OnStack, 
      ivarRef.getType(), argCK, $AddrOf(argLoad), 
      ExprValueKind.VK_RValue);
  Expr /*P*/ finalArg = $AddrOf(argLoad);
  if (!$this().getContext().hasSameUnqualifiedType(ivarRef.getType(), 
      argLoad.getType())) {
    finalArg = $AddrOf(argCast);
  }
  
  org.clang.ast.BinaryOperator assign/*J*/= new org.clang.ast.BinaryOperator($AddrOf(ivarRef), finalArg, BinaryOperatorKind.BO_Assign, 
      ivarRef.getType(), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
      new SourceLocation(), false);
  $this().EmitStmt($AddrOf(assign));
}


/// GenerateObjCAtomicSetterCopyHelperFunction - Given a c++ object type with
/// non-trivial copy assignment function, produce following helper function.
/// static void copyHelper(Ty *dest, const Ty *source) { *dest = *source; }
///
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateObjCAtomicSetterCopyHelperFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 3164,
 FQN="clang::CodeGen::CodeGenFunction::GenerateObjCAtomicSetterCopyHelperFunction", NM="_ZN5clang7CodeGen15CodeGenFunction42GenerateObjCAtomicSetterCopyHelperFunctionEPKNS_20ObjCPropertyImplDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction42GenerateObjCAtomicSetterCopyHelperFunctionEPKNS_20ObjCPropertyImplDeclE")
//</editor-fold>
public final Constant /*P*/ GenerateObjCAtomicSetterCopyHelperFunction(/*const*/ ObjCPropertyImplDecl /*P*/ PID) {
  FunctionArgList args = null;
  ImplicitParamDecl dstDecl = null;
  ImplicitParamDecl srcDecl = null;
  try {
    if (!$this().getLangOpts().CPlusPlus
       || !$this().getLangOpts().ObjCRuntime.hasAtomicCopyHelper()) {
      return null;
    }
    QualType Ty = PID.getPropertyIvarDecl().getType();
    if (!Ty.$arrow().isRecordType()) {
      return null;
    }
    /*const*/ ObjCPropertyDecl /*P*/ PD = PID.getPropertyDecl();
    if ((!((PD.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_atomic) != 0))) {
      return null;
    }
    Constant /*P*/ HelperFn = null;
    if (CGObjCStatics.hasTrivialSetExpr(PID)) {
      return null;
    }
    assert ((PID.getSetterCXXAssignment() != null)) : "SetterCXXAssignment - null";
    if (((HelperFn = $this().CGM.getAtomicSetterHelperFnMap(new QualType(Ty))) != null)) {
      return HelperFn;
    }
    
    final ASTContext /*&*/ C = $this().getContext();
    IdentifierInfo /*P*/ II = $AddrOf($this().CGM.getContext().Idents.get(new StringRef(/*KEEP_STR*/"__assign_helper_atomic_property_")));
    FunctionDecl /*P*/ FD = FunctionDecl.Create(C, 
        C.getTranslationUnitDecl(), 
        new SourceLocation(), 
        new SourceLocation(), new DeclarationName(II), C.VoidTy.$QualType(), 
        (TypeSourceInfo /*P*/ )null, StorageClass.SC_Static, 
        false, 
        false);
    
    QualType DestTy = C.getPointerType(/*NO_COPY*/Ty);
    QualType SrcTy = new QualType(Ty);
    SrcTy.addConst();
    SrcTy.$assignMove(C.getPointerType(/*NO_COPY*/SrcTy));
    
    args/*J*/= new FunctionArgList();
    dstDecl/*J*/= new ImplicitParamDecl($this().getContext(), FD, new SourceLocation(), (IdentifierInfo /*P*/ )null, new QualType(DestTy));
    args.push_back($AddrOf(dstDecl));
    srcDecl/*J*/= new ImplicitParamDecl($this().getContext(), FD, new SourceLocation(), (IdentifierInfo /*P*/ )null, new QualType(SrcTy));
    args.push_back($AddrOf(srcDecl));
    
    final /*const*/ CGFunctionInfo /*&*/ FI = $this().CGM.getTypes().arrangeBuiltinFunctionDeclaration(C.VoidTy.$QualType(), args);
    
    org.llvm.ir.FunctionType /*P*/ LTy = $this().CGM.getTypes().GetFunctionType(FI);
    
    Function /*P*/ Fn = Function.Create(LTy, GlobalValue.LinkageTypes.InternalLinkage, 
        new Twine(/*KEEP_STR*/"__assign_helper_atomic_property_"), 
        $AddrOf($this().CGM.getModule()));
    
    $this().CGM.SetInternalFunctionAttributes((/*const*/ Decl /*P*/ )null, Fn, FI);
    
    $this().StartFunction(new GlobalDecl(FD), C.VoidTy.$QualType(), Fn, FI, args);
    
    DeclRefExpr DstExpr/*J*/= new DeclRefExpr($AddrOf(dstDecl), false, new QualType(DestTy), 
        ExprValueKind.VK_RValue, new SourceLocation());
    UnaryOperator DST/*J*/= new UnaryOperator($AddrOf(DstExpr), UnaryOperatorKind.UO_Deref, DestTy.$arrow().getPointeeType(), 
        ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, new SourceLocation());
    
    DeclRefExpr SrcExpr/*J*/= new DeclRefExpr($AddrOf(srcDecl), false, new QualType(SrcTy), 
        ExprValueKind.VK_RValue, new SourceLocation());
    UnaryOperator SRC/*J*/= new UnaryOperator($AddrOf(SrcExpr), UnaryOperatorKind.UO_Deref, SrcTy.$arrow().getPointeeType(), 
        ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, new SourceLocation());
    
    Expr /*P*/ Args[/*2*/] = new Expr /*P*/  [/*2*/] {$AddrOf(DST), $AddrOf(SRC)};
    CallExpr /*P*/ CalleeExp = cast_CallExpr(PID.getSetterCXXAssignment());
    CXXOperatorCallExpr TheCall/*J*/= new CXXOperatorCallExpr(C, OverloadedOperatorKind.OO_Equal, CalleeExp.getCallee(), 
        new ArrayRef<Expr /*P*/ >(Args, true), DestTy.$arrow().getPointeeType(), 
        ExprValueKind.VK_LValue, new SourceLocation(), false);
    
    $this().EmitStmt($AddrOf(TheCall));
    
    $this().FinishFunction();
    HelperFn = ConstantExpr.getBitCast(Fn, Unnamed_field9.VoidPtrTy);
    $this().CGM.setAtomicSetterHelperFnMap(new QualType(Ty), HelperFn);
    return HelperFn;
  } finally {
    if (srcDecl != null) { srcDecl.$destroy(); }
    if (dstDecl != null) { dstDecl.$destroy(); }
    if (args != null) { args.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateObjCAtomicGetterCopyHelperFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 3243,
 FQN="clang::CodeGen::CodeGenFunction::GenerateObjCAtomicGetterCopyHelperFunction", NM="_ZN5clang7CodeGen15CodeGenFunction42GenerateObjCAtomicGetterCopyHelperFunctionEPKNS_20ObjCPropertyImplDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction42GenerateObjCAtomicGetterCopyHelperFunctionEPKNS_20ObjCPropertyImplDeclE")
//</editor-fold>
public final Constant /*P*/ GenerateObjCAtomicGetterCopyHelperFunction(/*const*/ ObjCPropertyImplDecl /*P*/ PID) {
  FunctionArgList args = null;
  ImplicitParamDecl dstDecl = null;
  ImplicitParamDecl srcDecl = null;
  try {
    if (!$this().getLangOpts().CPlusPlus
       || !$this().getLangOpts().ObjCRuntime.hasAtomicCopyHelper()) {
      return null;
    }
    /*const*/ ObjCPropertyDecl /*P*/ PD = PID.getPropertyDecl();
    QualType Ty = PD.getType();
    if (!Ty.$arrow().isRecordType()) {
      return null;
    }
    if ((!((PD.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_atomic) != 0))) {
      return null;
    }
    Constant /*P*/ HelperFn = null;
    if (CGObjCStatics.hasTrivialGetExpr(PID)) {
      return null;
    }
    assert ((PID.getGetterCXXConstructor() != null)) : "getGetterCXXConstructor - null";
    if (((HelperFn = $this().CGM.getAtomicGetterHelperFnMap(new QualType(Ty))) != null)) {
      return HelperFn;
    }
    
    final ASTContext /*&*/ C = $this().getContext();
    IdentifierInfo /*P*/ II = $AddrOf($this().CGM.getContext().Idents.get(new StringRef(/*KEEP_STR*/"__copy_helper_atomic_property_")));
    FunctionDecl /*P*/ FD = FunctionDecl.Create(C, 
        C.getTranslationUnitDecl(), 
        new SourceLocation(), 
        new SourceLocation(), new DeclarationName(II), C.VoidTy.$QualType(), 
        (TypeSourceInfo /*P*/ )null, StorageClass.SC_Static, 
        false, 
        false);
    
    QualType DestTy = C.getPointerType(/*NO_COPY*/Ty);
    QualType SrcTy = new QualType(Ty);
    SrcTy.addConst();
    SrcTy.$assignMove(C.getPointerType(/*NO_COPY*/SrcTy));
    
    args/*J*/= new FunctionArgList();
    dstDecl/*J*/= new ImplicitParamDecl($this().getContext(), FD, new SourceLocation(), (IdentifierInfo /*P*/ )null, new QualType(DestTy));
    args.push_back($AddrOf(dstDecl));
    srcDecl/*J*/= new ImplicitParamDecl($this().getContext(), FD, new SourceLocation(), (IdentifierInfo /*P*/ )null, new QualType(SrcTy));
    args.push_back($AddrOf(srcDecl));
    
    final /*const*/ CGFunctionInfo /*&*/ FI = $this().CGM.getTypes().arrangeBuiltinFunctionDeclaration(C.VoidTy.$QualType(), args);
    
    org.llvm.ir.FunctionType /*P*/ LTy = $this().CGM.getTypes().GetFunctionType(FI);
    
    Function /*P*/ Fn = Function.Create(LTy, GlobalValue.LinkageTypes.InternalLinkage, 
        new Twine(/*KEEP_STR*/"__copy_helper_atomic_property_"), $AddrOf($this().CGM.getModule()));
    
    $this().CGM.SetInternalFunctionAttributes((/*const*/ Decl /*P*/ )null, Fn, FI);
    
    $this().StartFunction(new GlobalDecl(FD), C.VoidTy.$QualType(), Fn, FI, args);
    
    DeclRefExpr SrcExpr/*J*/= new DeclRefExpr($AddrOf(srcDecl), false, new QualType(SrcTy), 
        ExprValueKind.VK_RValue, new SourceLocation());
    
    UnaryOperator SRC/*J*/= new UnaryOperator($AddrOf(SrcExpr), UnaryOperatorKind.UO_Deref, SrcTy.$arrow().getPointeeType(), 
        ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, new SourceLocation());
    
    CXXConstructExpr /*P*/ CXXConstExpr = cast_CXXConstructExpr(PID.getGetterCXXConstructor());
    
    SmallVector<Expr /*P*/ > ConstructorArgs/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
    ConstructorArgs.push_back($AddrOf(SRC));
    ConstructorArgs.append_T(std.next(CXXConstExpr.arg_begin()), 
        CXXConstExpr.arg_end());
    
    CXXConstructExpr /*P*/ TheCXXConstructExpr = CXXConstructExpr.Create(C, new QualType(Ty), new SourceLocation(), 
        CXXConstExpr.getConstructor(), 
        CXXConstExpr.isElidable(), 
        new ArrayRef<Expr /*P*/ >(ConstructorArgs, true), 
        CXXConstExpr.hadMultipleCandidates(), 
        CXXConstExpr.isListInitialization(), 
        CXXConstExpr.isStdInitListInitialization(), 
        CXXConstExpr.requiresZeroInitialization(), 
        CXXConstExpr.getConstructionKind(), 
        new SourceRange());
    
    DeclRefExpr DstExpr/*J*/= new DeclRefExpr($AddrOf(dstDecl), false, new QualType(DestTy), 
        ExprValueKind.VK_RValue, new SourceLocation());
    
    RValue DV = $this().EmitAnyExpr($AddrOf(DstExpr));
    CharUnits Alignment = $this().getContext().getTypeAlignInChars(TheCXXConstructExpr.getType());
    $this().EmitAggExpr(TheCXXConstructExpr, 
        AggValueSlot.forAddr(new Address(DV.getScalarVal(), new CharUnits(Alignment)), 
            new Qualifiers(), 
            AggValueSlot.IsDestructed_t.IsDestructed, 
            AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers, 
            AggValueSlot.IsAliased_t.IsNotAliased));
    
    $this().FinishFunction();
    HelperFn = ConstantExpr.getBitCast(Fn, Unnamed_field9.VoidPtrTy);
    $this().CGM.setAtomicGetterHelperFnMap(new QualType(Ty), HelperFn);
    return HelperFn;
  } finally {
    if (srcDecl != null) { srcDecl.$destroy(); }
    if (dstDecl != null) { dstDecl.$destroy(); }
    if (args != null) { args.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitBlockCopyAndAutorelease">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 3344,
 FQN="clang::CodeGen::CodeGenFunction::EmitBlockCopyAndAutorelease", NM="_ZN5clang7CodeGen15CodeGenFunction27EmitBlockCopyAndAutoreleaseEPN4llvm5ValueENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction27EmitBlockCopyAndAutoreleaseEPN4llvm5ValueENS_8QualTypeE")
//</editor-fold>
public final Value /*P*/ EmitBlockCopyAndAutorelease(Value /*P*/ Block, QualType Ty) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Get selectors for retain/autorelease.
    IdentifierInfo /*P*/ CopyID = $AddrOf($this().getContext().Idents.get(new StringRef(/*KEEP_STR*/"copy")));
    Selector CopySelector = $this().getContext().Selectors.getNullarySelector(CopyID);
    IdentifierInfo /*P*/ AutoreleaseID = $AddrOf($this().getContext().Idents.get(new StringRef(/*KEEP_STR*/"autorelease")));
    Selector AutoreleaseSelector = $this().getContext().Selectors.getNullarySelector(AutoreleaseID);
    
    // Emit calls to retain/autorelease.
    final CGObjCRuntime /*&*/ Runtime = $this().CGM.getObjCRuntime();
    Value /*P*/ Val = Block;
    RValue Result/*J*/= new RValue();
    $c$.clean(Result.$assignMove(Runtime.GenerateMessageSend(/*Deref*/$this(), new ReturnValueSlot(), 
            new QualType(Ty), new Selector(CopySelector), 
            Val, $c$.track(new CallArgList()), (/*const*/ ObjCInterfaceDecl /*P*/ )null, (/*const*/ ObjCMethodDecl /*P*/ )null)));
    Val = Result.getScalarVal();
    $c$.clean(Result.$assignMove(Runtime.GenerateMessageSend(/*Deref*/$this(), new ReturnValueSlot(), 
            new QualType(Ty), new Selector(AutoreleaseSelector), 
            Val, $c$.track(new CallArgList()), (/*const*/ ObjCInterfaceDecl /*P*/ )null, (/*const*/ ObjCMethodDecl /*P*/ )null)));
    Val = Result.getScalarVal();
    return Val;
  } finally {
    $c$.$destroy();
  }
}


/// LoadObjCSelf - Load the value of self. This function is only valid while
/// generating code for an Objective-C method.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::LoadObjCSelf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1437,
 FQN="clang::CodeGen::CodeGenFunction::LoadObjCSelf", NM="_ZN5clang7CodeGen15CodeGenFunction12LoadObjCSelfEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12LoadObjCSelfEv")
//</editor-fold>
public final Value /*P*/ LoadObjCSelf() {
  VarDecl /*P*/ Self = cast_ObjCMethodDecl($this().CurFuncDecl).getSelfDecl();
  DeclRefExpr DRE/*J*/= new DeclRefExpr(Self, /*is enclosing local*/ ($this().CurFuncDecl != $this().CurCodeDecl), 
      Self.getType(), ExprValueKind.VK_LValue, new SourceLocation());
  return $this().EmitLoadOfScalar($this().EmitDeclRefLValue($AddrOf(DRE)), new SourceLocation());
}


/// TypeOfSelfObject - Return type of object that this self represents.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::TypeOfSelfObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1444,
 FQN="clang::CodeGen::CodeGenFunction::TypeOfSelfObject", NM="_ZN5clang7CodeGen15CodeGenFunction16TypeOfSelfObjectEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16TypeOfSelfObjectEv")
//</editor-fold>
public final QualType TypeOfSelfObject() {
  /*const*/ ObjCMethodDecl /*P*/ OMD = cast_ObjCMethodDecl($this().CurFuncDecl);
  ImplicitParamDecl /*P*/ selfDecl = OMD.getSelfDecl();
  /*const*/ ObjCObjectPointerType /*P*/ PTy = cast_ObjCObjectPointerType($this().getContext().getCanonicalType(selfDecl.getType()));
  return PTy.getPointeeType();
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCForCollectionStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1452,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCForCollectionStmt", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitObjCForCollectionStmtERKNS_21ObjCForCollectionStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitObjCForCollectionStmtERKNS_21ObjCForCollectionStmtE")
//</editor-fold>
public final void EmitObjCForCollectionStmt(final /*const*/ ObjCForCollectionStmt /*&*/ S) {
  RunCleanupsScope ForScope = null;
  CallArgList Args = null;
  CallArgList Args2 = null;
  RunCleanupsScope elementVariableScope = null;
  try {
    Constant /*P*/ EnumerationMutationFn = $this().CGM.getObjCRuntime().EnumerationMutationFunction();
    if (!(EnumerationMutationFn != null)) {
      $this().CGM.ErrorUnsupported($AddrOf(S), $("Obj-C fast enumeration for this runtime"));
      return;
    }
    
    CGDebugInfo /*P*/ DI = $this().getDebugInfo();
    if ((DI != null)) {
      DI.EmitLexicalBlockStart($this().Builder, S.getSourceRange().getBegin());
    }
    
    // The local variable comes into scope immediately.
    AutoVarEmission variable = AutoVarEmission.invalid();
    {
      /*const*/ DeclStmt /*P*/ SD = dyn_cast_DeclStmt(S.getElement$Const());
      if ((SD != null)) {
        variable.$assignMove($this().EmitAutoVarAlloca($Deref(cast_VarDecl(SD.getSingleDecl$Const()))));
      }
    }
    
    JumpDest LoopEnd = $this().getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"forcoll.end"));
    
    // Fast enumeration state.
    QualType StateTy = $this().CGM.getObjCFastEnumerationStateType();
    Address StatePtr = $this().CreateMemTemp(new QualType(StateTy), new Twine(/*KEEP_STR*/"state.ptr"));
    $this().EmitNullInitialization(new Address(StatePtr), new QualType(StateTy));
    
    // Number of elements in the items array.
    final/*static*/ /*const*//*uint*/int NumItems = EmitObjCForCollectionStmt$$.NumItems;
    
    // Fetch the countByEnumeratingWithState:objects:count: selector.
    IdentifierInfo /*P*/ II[/*3*/] = new IdentifierInfo /*P*/  [/*3*/] {
      $AddrOf($this().CGM.getContext().Idents.get(new StringRef(/*KEEP_STR*/"countByEnumeratingWithState"))), 
      $AddrOf($this().CGM.getContext().Idents.get(new StringRef(/*KEEP_STR*/"objects"))), 
      $AddrOf($this().CGM.getContext().Idents.get(new StringRef(/*KEEP_STR*/"count")))
    };
    Selector FastEnumSel = $this().CGM.getContext().Selectors.getSelector(llvm.array_lengthof(II), $AddrOf(create_type$ptr(II, 0)));
    
    QualType ItemsTy = $this().getContext().getConstantArrayType($this().getContext().getObjCIdType(), 
        new APInt(JD$UInt_ULong.INSTANCE, 32, $uint2ulong(NumItems)), 
        org.clang.ast.ArrayType.ArraySizeModifier.Normal, 0);
    Address ItemsPtr = $this().CreateMemTemp(new QualType(ItemsTy), new Twine(/*KEEP_STR*/"items.ptr"));
    
    ForScope/*J*/= new RunCleanupsScope(/*Deref*/$this());
    
    // Emit the collection pointer.  In ARC, we do a retain.
    Value /*P*/ Collection;
    if ($this().getLangOpts().ObjCAutoRefCount) {
      Collection = $this().EmitARCRetainScalarExpr(S.getCollection$Const());
      
      // Enter a cleanup to do the release.
      $this().EmitObjCConsumeObject(S.getCollection$Const().getType(), Collection);
    } else {
      Collection = $this().EmitScalarExpr(S.getCollection$Const());
    }
    
    // The 'continue' label needs to appear within the cleanup for the
    // collection object.
    JumpDest AfterBody = $this().getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"forcoll.next"));
    
    // Send it our message:
    Args/*J*/= new CallArgList();
    
    // The first argument is a temporary of the enumeration-state type.
    Args.add(RValue.get(StatePtr.getPointer()), 
        $this().getContext().getPointerType(/*NO_COPY*/StateTy));
    
    // The second argument is a temporary array with space for NumItems
    // pointers.  We'll actually be loading elements from the array
    // pointer written into the control state; this buffer is so that
    // collections that *aren't* backed by arrays can still queue up
    // batches of elements.
    Args.add(RValue.get(ItemsPtr.getPointer()), 
        $this().getContext().getPointerType(/*NO_COPY*/ItemsTy));
    
    // The third argument is the capacity of that temporary array.
    org.llvm.ir.Type /*P*/ UnsignedLongLTy = $this().ConvertType($this().getContext().UnsignedLongTy.$QualType());
    Constant /*P*/ Count = ConstantInt.get(UnsignedLongLTy, $uint2ulong(NumItems));
    Args.add(RValue.get(Count), $this().getContext().UnsignedLongTy.$QualType());
    
    // Start the enumeration.
    RValue CountRV = $this().CGM.getObjCRuntime().GenerateMessageSend(/*Deref*/$this(), new ReturnValueSlot(), 
        $this().getContext().UnsignedLongTy.$QualType(), 
        new Selector(FastEnumSel), 
        Collection, Args);
    
    // The initial number of objects that were returned in the buffer.
    Value /*P*/ initialBufferLimit = CountRV.getScalarVal();
    
    BasicBlock /*P*/ EmptyBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"forcoll.empty"));
    BasicBlock /*P*/ LoopInitBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"forcoll.loopinit"));
    
    Value /*P*/ zero = Constant.getNullValue(UnsignedLongLTy);
    
    // If the limit pointer was zero to begin with, the collection is
    // empty; skip all this. Set the branch weight assuming this has the same
    // probability of exiting the loop as any other loop exit.
    long/*uint64_t*/ EntryCount = $this().getCurrentProfileCount();
    $this().Builder.CreateCondBr($this().Builder.CreateICmpEQ(initialBufferLimit, zero, new Twine(/*KEEP_STR*/"iszero")), EmptyBB, 
        LoopInitBB, 
        $this().createProfileWeights(EntryCount, $this().getProfileCount(S.getBody$Const())));
    
    // Otherwise, initialize the loop.
    $this().EmitBlock(LoopInitBB);
    
    // Save the initial mutations value.  This is the value at an
    // address that was written into the state object by
    // countByEnumeratingWithState:objects:count:.
    Address StateMutationsPtrPtr = $this().Builder.CreateStructGEP(new Address(StatePtr), 2, $star_long_CharUnits$C(2, /*J:ToBase*/super.getPointerSize()), new Twine(/*KEEP_STR*/"mutationsptr.ptr"));
    Value /*P*/ StateMutationsPtr = $this().Builder.CreateLoad(new Address(StateMutationsPtrPtr), $("mutationsptr"));
    
    Value /*P*/ initialMutations = $this().Builder.CreateAlignedLoad(StateMutationsPtr, /*J:ToBase*/super.getPointerAlign(), 
        $("forcoll.initial-mutations"));
    
    // Start looping.  This is the point we return to whenever we have a
    // fresh, non-empty batch of objects.
    BasicBlock /*P*/ LoopBodyBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"forcoll.loopbody"));
    $this().EmitBlock(LoopBodyBB);
    
    // The current index into the buffer.
    PHINode /*P*/ index = $this().Builder.CreatePHI(UnsignedLongLTy, 3, new Twine(/*KEEP_STR*/"forcoll.index"));
    index.addIncoming(zero, LoopInitBB);
    
    // The current buffer size.
    PHINode /*P*/ count = $this().Builder.CreatePHI(UnsignedLongLTy, 3, new Twine(/*KEEP_STR*/"forcoll.count"));
    count.addIncoming(initialBufferLimit, LoopInitBB);
    
    $this().incrementProfileCounter($AddrOf(S));
    
    // Check whether the mutations value has changed from where it was
    // at start.  StateMutationsPtr should actually be invariant between
    // refreshes.
    StateMutationsPtr = $this().Builder.CreateLoad(new Address(StateMutationsPtrPtr), $("mutationsptr"));
    Value /*P*/ currentMutations = $this().Builder.CreateAlignedLoad(StateMutationsPtr, /*J:ToBase*/super.getPointerAlign(), 
        $("statemutations"));
    
    BasicBlock /*P*/ WasMutatedBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"forcoll.mutated"));
    BasicBlock /*P*/ WasNotMutatedBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"forcoll.notmutated"));
    
    $this().Builder.CreateCondBr($this().Builder.CreateICmpEQ(currentMutations, initialMutations), 
        WasNotMutatedBB, WasMutatedBB);
    
    // If so, call the enumeration-mutation function.
    $this().EmitBlock(WasMutatedBB);
    Value /*P*/ V = $this().Builder.CreateBitCast(Collection, 
        $this().ConvertType($this().getContext().getObjCIdType()));
    Args2/*J*/= new CallArgList();
    Args2.add(RValue.get(V), $this().getContext().getObjCIdType());
    // FIXME: We shouldn't need to get the function info here, the runtime already
    // should have computed it to build the function.
    $this().EmitCall($this().CGM.getTypes().arrangeBuiltinFunctionCall($this().getContext().VoidTy.$QualType(), Args2), 
        EnumerationMutationFn, new ReturnValueSlot(), Args2);
    
    // Otherwise, or if the mutation function returns, just continue.
    $this().EmitBlock(WasNotMutatedBB);
    
    // Initialize the element variable.
    elementVariableScope/*J*/= new RunCleanupsScope(/*Deref*/$this());
    boolean elementIsVariable;
    LValue elementLValue/*J*/= new LValue();
    QualType elementType/*J*/= new QualType();
    {
      /*const*/ DeclStmt /*P*/ SD = dyn_cast_DeclStmt(S.getElement$Const());
      if ((SD != null)) {
        // Initialize the variable, in case it's a __block variable or something.
        $this().EmitAutoVarInit(variable);
        
        /*const*/ VarDecl /*P*/ D = cast_VarDecl(SD.getSingleDecl$Const());
        DeclRefExpr tempDRE/*J*/= new DeclRefExpr(((/*const_cast*/VarDecl /*P*/ )(D)), false, D.getType(), 
            ExprValueKind.VK_LValue, new SourceLocation());
        elementLValue.$assignMove($this().EmitLValue($AddrOf(tempDRE)));
        elementType.$assignMove(D.getType());
        elementIsVariable = true;
        if (D.isARCPseudoStrong()) {
          elementLValue.getQuals().setObjCLifetime(Qualifiers.ObjCLifetime.OCL_ExplicitNone);
        }
      } else {
        elementLValue.$assignMove(new LValue()); // suppress warning
        elementType.$assignMove(cast_Expr(S.getElement$Const()).getType());
        elementIsVariable = false;
      }
    }
    org.llvm.ir.Type /*P*/ convertedElementType = $this().ConvertType(new QualType(elementType));
    
    // Fetch the buffer out of the enumeration state.
    // TODO: this pointer should actually be invariant between
    // refreshes, which would help us do certain loop optimizations.
    Address StateItemsPtr = $this().Builder.CreateStructGEP(new Address(StatePtr), 1, /*J:ToBase*/super.getPointerSize(), new Twine(/*KEEP_STR*/"stateitems.ptr"));
    Value /*P*/ EnumStateItems = $this().Builder.CreateLoad(new Address(StateItemsPtr), $("stateitems"));
    
    // Fetch the value at the current index from the buffer.
    Value /*P*/ CurrentItemPtr = $this().Builder.CreateGEP(EnumStateItems, index, new Twine(/*KEEP_STR*/"currentitem.ptr"));
    Value /*P*/ CurrentItem = $this().Builder.CreateAlignedLoad(CurrentItemPtr, /*J:ToBase*/super.getPointerAlign());
    
    // Cast that value to the right type.
    CurrentItem = $this().Builder.CreateBitCast(CurrentItem, convertedElementType, 
        new Twine(/*KEEP_STR*/"currentitem"));
    
    // Make sure we have an l-value.  Yes, this gets evaluated every
    // time through the loop.
    if (!elementIsVariable) {
      elementLValue.$assignMove($this().EmitLValue(cast_Expr(S.getElement$Const())));
      $this().EmitStoreThroughLValue(RValue.get(CurrentItem), new LValue(elementLValue));
    } else {
      $this().EmitScalarInit(CurrentItem, new LValue(elementLValue));
    }
    
    // If we do have an element variable, this assignment is the end of
    // its initialization.
    if (elementIsVariable) {
      $this().EmitAutoVarCleanups(variable);
    }
    
    // Perform the loop body, setting up break and continue labels.
    $this().BreakContinueStack.push_back(new BreakContinue(new JumpDest(LoopEnd), new JumpDest(AfterBody)));
    {
      RunCleanupsScope Scope = null;
      try {
        Scope/*J*/= new RunCleanupsScope(/*Deref*/$this());
        $this().EmitStmt(S.getBody$Const());
      } finally {
        if (Scope != null) { Scope.$destroy(); }
      }
    }
    $this().BreakContinueStack.pop_back();
    
    // Destroy the element variable now.
    elementVariableScope.ForceCleanup();
    
    // Check whether there are more elements.
    $this().EmitBlock(AfterBody.getBlock());
    
    BasicBlock /*P*/ FetchMoreBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"forcoll.refetch"));
    
    // First we check in the local buffer.
    Value /*P*/ indexPlusOne = $this().Builder.CreateAdd(index, ConstantInt.get(UnsignedLongLTy, $int2ulong(1)));
    
    // If we haven't overrun the buffer yet, we can continue.
    // Set the branch weights based on the simplifying assumption that this is
    // like a while-loop, i.e., ignoring that the false branch fetches more
    // elements and then returns to the loop.
    $this().Builder.CreateCondBr($this().Builder.CreateICmpULT(indexPlusOne, count), LoopBodyBB, FetchMoreBB, 
        $this().createProfileWeights($this().getProfileCount(S.getBody$Const()), EntryCount));
    
    index.addIncoming(indexPlusOne, AfterBody.getBlock());
    count.addIncoming(count, AfterBody.getBlock());
    
    // Otherwise, we have to fetch more elements.
    $this().EmitBlock(FetchMoreBB);
    
    CountRV.$assignMove(
        $this().CGM.getObjCRuntime().GenerateMessageSend(/*Deref*/$this(), new ReturnValueSlot(), 
            $this().getContext().UnsignedLongTy.$QualType(), 
            new Selector(FastEnumSel), 
            Collection, Args)
    );
    
    // If we got a zero count, we're done.
    Value /*P*/ refetchCount = CountRV.getScalarVal();
    
    // (note that the message send might split FetchMoreBB)
    index.addIncoming(zero, $this().Builder.GetInsertBlock());
    count.addIncoming(refetchCount, $this().Builder.GetInsertBlock());
    
    $this().Builder.CreateCondBr($this().Builder.CreateICmpEQ(refetchCount, zero), 
        EmptyBB, LoopBodyBB);
    
    // No more elements.
    $this().EmitBlock(EmptyBB);
    if (!elementIsVariable) {
      // If the element was not a declaration, set it to be null.
      Value /*P*/ __null = Constant.getNullValue(convertedElementType);
      elementLValue.$assignMove($this().EmitLValue(cast_Expr(S.getElement$Const())));
      $this().EmitStoreThroughLValue(RValue.get(__null), new LValue(elementLValue));
    }
    if ((DI != null)) {
      DI.EmitLexicalBlockEnd($this().Builder, S.getSourceRange().getEnd());
    }
    
    ForScope.ForceCleanup();
    $this().EmitBlock(LoopEnd.getBlock());
  } finally {
    if (elementVariableScope != null) { elementVariableScope.$destroy(); }
    if (Args2 != null) { Args2.$destroy(); }
    if (Args != null) { Args.$destroy(); }
    if (ForScope != null) { ForScope.$destroy(); }
  }
}
private static final class EmitObjCForCollectionStmt$$ {
  static final/*static*/ /*const*//*uint*/int NumItems = 16;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCAtTryStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1741,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCAtTryStmt", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitObjCAtTryStmtERKNS_13ObjCAtTryStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitObjCAtTryStmtERKNS_13ObjCAtTryStmtE")
//</editor-fold>
public final void EmitObjCAtTryStmt(final /*const*/ ObjCAtTryStmt /*&*/ S) {
  $this().CGM.getObjCRuntime().EmitTryStmt(/*Deref*/$this(), S);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCAtThrowStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1745,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCAtThrowStmt", NM="_ZN5clang7CodeGen15CodeGenFunction19EmitObjCAtThrowStmtERKNS_15ObjCAtThrowStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19EmitObjCAtThrowStmtERKNS_15ObjCAtThrowStmtE")
//</editor-fold>
public final void EmitObjCAtThrowStmt(final /*const*/ ObjCAtThrowStmt /*&*/ S) {
  $this().CGM.getObjCRuntime().EmitThrowStmt(/*Deref*/$this(), S);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCAtSynchronizedStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1749,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCAtSynchronizedStmt", NM="_ZN5clang7CodeGen15CodeGenFunction26EmitObjCAtSynchronizedStmtERKNS_22ObjCAtSynchronizedStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26EmitObjCAtSynchronizedStmtERKNS_22ObjCAtSynchronizedStmtE")
//</editor-fold>
public final void EmitObjCAtSynchronizedStmt(final /*const*/ ObjCAtSynchronizedStmt /*&*/ S) {
  $this().CGM.getObjCRuntime().EmitSynchronizedStmt(/*Deref*/$this(), S);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCAutoreleasePoolStmt">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 3118,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCAutoreleasePoolStmt", NM="_ZN5clang7CodeGen15CodeGenFunction27EmitObjCAutoreleasePoolStmtERKNS_23ObjCAutoreleasePoolStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction27EmitObjCAutoreleasePoolStmtERKNS_23ObjCAutoreleasePoolStmtE")
//</editor-fold>
public final void EmitObjCAutoreleasePoolStmt(final /*const*/ ObjCAutoreleasePoolStmt /*&*/ ARPS) {
  RunCleanupsScope Scope = null;
  try {
    /*const*/ Stmt /*P*/ subStmt = ARPS.getSubStmt$Const();
    final /*const*/ CompoundStmt /*&*/ S = cast_CompoundStmt($Deref(subStmt));
    
    CGDebugInfo /*P*/ DI = $this().getDebugInfo();
    if ((DI != null)) {
      DI.EmitLexicalBlockStart($this().Builder, S.getLBracLoc());
    }
    
    // Keep track of the current cleanup stack depth.
    Scope/*J*/= new RunCleanupsScope(/*Deref*/$this());
    if ($this().CGM.getLangOpts().ObjCRuntime.hasNativeARC()) {
      Value /*P*/ token = $this().EmitObjCAutoreleasePoolPush();
      $this().EHStack.<CallObjCAutoreleasePoolObject>pushCleanup$T(CleanupKind.NormalCleanup, () -> new CallObjCAutoreleasePoolObject(token));
    } else {
      Value /*P*/ token = $this().EmitObjCMRRAutoreleasePoolPush();
      $this().EHStack.<CallObjCMRRAutoreleasePoolObject>pushCleanup$T(CleanupKind.NormalCleanup, () -> new CallObjCMRRAutoreleasePoolObject(token));
    }
    
    for (/*const*/ Stmt /*P*/ I : S.body$Const())  {
      $this().EmitStmt(I);
    }
    if ((DI != null)) {
      DI.EmitLexicalBlockEnd($this().Builder, S.getRBracLoc());
    }
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCProtocolExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 243,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCProtocolExpr", NM="_ZN5clang7CodeGen15CodeGenFunction20EmitObjCProtocolExprEPKNS_16ObjCProtocolExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20EmitObjCProtocolExprEPKNS_16ObjCProtocolExprE")
//</editor-fold>
public final Value /*P*/ EmitObjCProtocolExpr(/*const*/ ObjCProtocolExpr /*P*/ E) {
  // FIXME: This should pass the Decl not the name.
  return $this().CGM.getObjCRuntime().GenerateProtocolRef(/*Deref*/$this(), E.getProtocol());
}


/// Emits an instance of NSConstantString representing the object.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCStringLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 46,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCStringLiteral", NM="_ZN5clang7CodeGen15CodeGenFunction21EmitObjCStringLiteralEPKNS_17ObjCStringLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21EmitObjCStringLiteralEPKNS_17ObjCStringLiteralE")
//</editor-fold>
public final Value /*P*/ EmitObjCStringLiteral(/*const*/ ObjCStringLiteral /*P*/ E) {
  Constant /*P*/ C = $this().CGM.getObjCRuntime().GenerateConstantString(E.getString$Const()).getPointer();
  // FIXME: This bitcast should just be made an invariant on the Runtime.
  return ConstantExpr.getBitCast(C, $this().ConvertType(E.getType()));
}


/// EmitObjCBoxedExpr - This routine generates code to call
/// the appropriate expression boxing method. This will either be
/// one of +[NSNumber numberWith<Type>:], or +[NSString stringWithUTF8String:],
/// or [NSValue valueWithBytes:objCType:].
///
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCBoxedExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 59,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCBoxedExpr", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitObjCBoxedExprEPKNS_13ObjCBoxedExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitObjCBoxedExprEPKNS_13ObjCBoxedExprE")
//</editor-fold>
public final Value /*P*/ EmitObjCBoxedExpr(/*const*/ ObjCBoxedExpr /*P*/ E) {
  CallArgList Args = null;
  try {
    // Generate the correct selector for this literal's concrete type.
    // Get the method.
    /*const*/ ObjCMethodDecl /*P*/ BoxingMethod = E.getBoxingMethod();
    /*const*/ Expr /*P*/ SubExpr = E.getSubExpr$Const();
    assert ((BoxingMethod != null)) : "BoxingMethod is null";
    assert (BoxingMethod.isClassMethod()) : "BoxingMethod must be a class method";
    Selector Sel = BoxingMethod.getSelector();
    
    // Generate a reference to the class pointer, which will be the receiver.
    // Assumes that the method was introduced in the class that should be
    // messaged (avoids pulling it out of the result type).
    final CGObjCRuntime /*&*/ Runtime = $this().CGM.getObjCRuntime();
    /*const*/ ObjCInterfaceDecl /*P*/ ClassDecl = BoxingMethod.getClassInterface$Const();
    Value /*P*/ Receiver = Runtime.GetClass(/*Deref*/$this(), ClassDecl);
    
    Args/*J*/= new CallArgList();
    /*const*/ ParmVarDecl /*P*/ ArgDecl = BoxingMethod.param_begin$Const().$star();
    QualType ArgQT = ArgDecl.getType().getUnqualifiedType();
    
    // ObjCBoxedExpr supports boxing of structs and unions 
    // via [NSValue valueWithBytes:objCType:]
    /*const*/ QualType ValueType/*J*/= SubExpr.getType().getCanonicalType();
    if (ValueType.$arrow().isObjCBoxableRecordType()) {
      // Emit CodeGen for first parameter
      // and cast value to correct type
      Address Temporary = $this().CreateMemTemp(SubExpr.getType());
      $this().EmitAnyExprToMem(SubExpr, new Address(Temporary), new Qualifiers(), /*isInit*/ true);
      Address BitCast = $this().Builder.CreateBitCast(new Address(Temporary), $this().ConvertType(new QualType(ArgQT)));
      Args.add(RValue.get(BitCast.getPointer()), new QualType(ArgQT));
      
      // Create char array to store type encoding
      std.string Str/*J*/= new std.string();
      $this().getContext().getObjCEncodingForType(new QualType(ValueType), Str);
      Constant /*P*/ GV = $this().CGM.GetAddrOfConstantCString(Str).getPointer();
      
      // Cast type encoding to correct type
      /*const*/ ParmVarDecl /*P*/ EncodingDecl = BoxingMethod.parameters().$at(1);
      QualType EncodingQT = EncodingDecl.getType().getUnqualifiedType();
      Value /*P*/ Cast = $this().Builder.CreateBitCast(GV, $this().ConvertType(new QualType(EncodingQT)));
      
      Args.add(RValue.get(Cast), new QualType(EncodingQT));
    } else {
      Args.add($this().EmitAnyExpr(SubExpr), new QualType(ArgQT));
    }
    
    RValue result = Runtime.GenerateMessageSend(/*Deref*/$this(), new ReturnValueSlot(), BoxingMethod.getReturnType(), new Selector(Sel), Receiver, 
        Args, ClassDecl, BoxingMethod);
    return $this().Builder.CreateBitCast(result.getScalarVal(), 
        $this().ConvertType(E.getType()));
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCArrayLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 225,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCArrayLiteral", NM="_ZN5clang7CodeGen15CodeGenFunction20EmitObjCArrayLiteralEPKNS_16ObjCArrayLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20EmitObjCArrayLiteralEPKNS_16ObjCArrayLiteralE")
//</editor-fold>
public final Value /*P*/ EmitObjCArrayLiteral(/*const*/ ObjCArrayLiteral /*P*/ E) {
  return $this().EmitObjCCollectionLiteral(E, E.getArrayWithObjectsMethod());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCDictionaryLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 229,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCDictionaryLiteral", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitObjCDictionaryLiteralEPKNS_21ObjCDictionaryLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitObjCDictionaryLiteralEPKNS_21ObjCDictionaryLiteralE")
//</editor-fold>
public final Value /*P*/ EmitObjCDictionaryLiteral(/*const*/ ObjCDictionaryLiteral /*P*/ E) {
  return $this().EmitObjCCollectionLiteral(E, E.getDictWithObjectsMethod());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCCollectionLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 113,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCCollectionLiteral", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitObjCCollectionLiteralEPKNS_4ExprEPKNS_14ObjCMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitObjCCollectionLiteralEPKNS_4ExprEPKNS_14ObjCMethodDeclE")
//</editor-fold>
public final Value /*P*/ EmitObjCCollectionLiteral(/*const*/ Expr /*P*/ E, 
                         /*const*/ ObjCMethodDecl /*P*/ MethodWithObjects) {
  CallArgList Args = null;
  try {
    final ASTContext /*&*/ Context = $this().CGM.getContext();
    /*const*/ ObjCDictionaryLiteral /*P*/ DLE = null;
    /*const*/ ObjCArrayLiteral /*P*/ ALE = dyn_cast_ObjCArrayLiteral(E);
    if (!(ALE != null)) {
      DLE = cast_ObjCDictionaryLiteral(E);
    }
    
    // Compute the type of the array we're initializing.
    long/*uint64_t*/ NumElements = $uint2ulong((ALE != null) ? ALE.getNumElements() : DLE.getNumElements());
    APInt APNumElements/*J*/= new APInt(JD$UInt_ULong.INSTANCE, $ulong2uint(Context.getTypeSize(Context.getSizeType().$QualType())), 
        NumElements);
    QualType ElementType = Context.getObjCIdType().withConst();
    QualType ElementArrayType = Context.getConstantArrayType(new QualType(ElementType), APNumElements, 
        org.clang.ast.ArrayType.ArraySizeModifier.Normal, /*IndexTypeQuals=*/ 0);
    
    // Allocate the temporary array(s).
    Address Objects = $this().CreateMemTemp(new QualType(ElementArrayType), new Twine(/*KEEP_STR*/"objects"));
    Address Keys = Address.invalid();
    if ((DLE != null)) {
      Keys.$assignMove($this().CreateMemTemp(new QualType(ElementArrayType), new Twine(/*KEEP_STR*/"keys")));
    }
    
    // In ARC, we may need to do extra work to keep all the keys and
    // values alive until after the call.
    SmallVector<Value /*P*/ > NeededObjects/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
    boolean TrackNeededObjects = ($this().getLangOpts().ObjCAutoRefCount
       && $2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) != 0);
    
    // Perform the actual initialialization of the array(s).
    for (long/*uint64_t*/ i = $int2ulong(0); $less_ulong(i, NumElements); i++) {
      if ((ALE != null)) {
        // Emit the element and store it to the appropriate array slot.
        /*const*/ Expr /*P*/ Rhs = ALE.getElement$Const($ulong2uint(i));
        LValue LV = $this().MakeAddrLValue($this().Builder.CreateConstArrayGEP(new Address(Objects), i, /*J:ToBase*/super.getPointerSize()), 
            new QualType(ElementType), AlignmentSource.Decl);
        
        Value /*P*/ value = $this().EmitScalarExpr(Rhs);
        $this().EmitStoreThroughLValue(RValue.get(value), new LValue(LV), true);
        if (TrackNeededObjects) {
          NeededObjects.push_back(value);
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Emit the key and store it to the appropriate array slot.
          /*const*/ Expr /*P*/ Key = $c$.clean($c$.track(DLE.getKeyValueElement($ulong2uint(i))).Key);
          LValue KeyLV = $this().MakeAddrLValue($this().Builder.CreateConstArrayGEP(new Address(Keys), i, /*J:ToBase*/super.getPointerSize()), 
              new QualType(ElementType), AlignmentSource.Decl);
          Value /*P*/ keyValue = $this().EmitScalarExpr(Key);
          $this().EmitStoreThroughLValue(RValue.get(keyValue), new LValue(KeyLV), /*isInit=*/ true);
          
          // Emit the value and store it to the appropriate array slot.
          /*const*/ Expr /*P*/ Value = $c$.clean($c$.track(DLE.getKeyValueElement($ulong2uint(i))).Value);
          LValue ValueLV = $this().MakeAddrLValue($this().Builder.CreateConstArrayGEP(new Address(Objects), i, /*J:ToBase*/super.getPointerSize()), 
              new QualType(ElementType), AlignmentSource.Decl);
          Value /*P*/ valueValue = $this().EmitScalarExpr(Value);
          $this().EmitStoreThroughLValue(RValue.get(valueValue), new LValue(ValueLV), /*isInit=*/ true);
          if (TrackNeededObjects) {
            NeededObjects.push_back(keyValue);
            NeededObjects.push_back(valueValue);
          }
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Generate the argument list.
    Args/*J*/= new CallArgList();
    type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/> PI = $tryClone(MethodWithObjects.param_begin$Const());
    /*const*/ ParmVarDecl /*P*/ argDecl = PI.$postInc().$star();
    QualType ArgQT = argDecl.getType().getUnqualifiedType();
    Args.add(RValue.get(Objects.getPointer()), new QualType(ArgQT));
    if ((DLE != null)) {
      argDecl = PI.$postInc().$star();
      ArgQT.$assignMove(argDecl.getType().getUnqualifiedType());
      Args.add(RValue.get(Keys.getPointer()), new QualType(ArgQT));
    }
    argDecl = PI.$star();
    ArgQT.$assignMove(argDecl.getType().getUnqualifiedType());
    Value /*P*/ Count = ConstantInt.get($this().CGM.getTypes().ConvertType(new QualType(ArgQT)), NumElements);
    Args.add(RValue.get(Count), new QualType(ArgQT));
    
    // Generate a reference to the class pointer, which will be the receiver.
    Selector Sel = MethodWithObjects.getSelector();
    QualType ResultType = E.getType();
    /*const*/ ObjCObjectPointerType /*P*/ InterfacePointerType = ResultType.$arrow().getAsObjCInterfacePointerType();
    ObjCInterfaceDecl /*P*/ Class = InterfacePointerType.getObjectType().getInterface();
    final CGObjCRuntime /*&*/ Runtime = $this().CGM.getObjCRuntime();
    Value /*P*/ Receiver = Runtime.GetClass(/*Deref*/$this(), Class);
    
    // Generate the message send.
    RValue result = Runtime.GenerateMessageSend(/*Deref*/$this(), new ReturnValueSlot(), MethodWithObjects.getReturnType(), new Selector(Sel), 
        Receiver, Args, Class, MethodWithObjects);
    
    // The above message send needs these objects, but in ARC they are
    // passed in a buffer that is essentially __unsafe_unretained.
    // Therefore we must prevent the optimizer from releasing them until
    // after the call.
    if (TrackNeededObjects) {
      $this().EmitARCIntrinsicUse(new ArrayRef<Value /*P*/ >(NeededObjects, true));
    }
    
    return $this().Builder.CreateBitCast(result.getScalarVal(), 
        $this().ConvertType(E.getType()));
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}


/// Emit a selector.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCSelectorExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 235,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCSelectorExpr", NM="_ZN5clang7CodeGen15CodeGenFunction20EmitObjCSelectorExprEPKNS_16ObjCSelectorExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20EmitObjCSelectorExprEPKNS_16ObjCSelectorExprE")
//</editor-fold>
public final Value /*P*/ EmitObjCSelectorExpr(/*const*/ ObjCSelectorExpr /*P*/ E) {
  // Untyped selector.
  // Note that this implementation allows for non-constant strings to be passed
  // as arguments to @selector().  Currently, the only thing preventing this
  // behaviour is the type checking in the front end.
  return $this().CGM.getObjCRuntime().GetSelector(/*Deref*/$this(), E.getSelector());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCMessageExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 341,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCMessageExpr", NM="_ZN5clang7CodeGen15CodeGenFunction19EmitObjCMessageExprEPKNS_15ObjCMessageExprENS0_15ReturnValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19EmitObjCMessageExprEPKNS_15ObjCMessageExprENS0_15ReturnValueSlotE")
//</editor-fold>
public final RValue EmitObjCMessageExpr(/*const*/ ObjCMessageExpr /*P*/ E) {
  return EmitObjCMessageExpr(E, 
                   new ReturnValueSlot());
}
public final RValue EmitObjCMessageExpr(/*const*/ ObjCMessageExpr /*P*/ E, 
                   ReturnValueSlot Return/*= ReturnValueSlot()*/) {
  CallArgList Args = null;
  try {
    // Only the lookup mechanism and first two arguments of the method
    // implementation vary between runtimes.  We can get the receiver and
    // arguments in generic code.
    boolean isDelegateInit = E.isDelegateInitCall();
    
    /*const*/ ObjCMethodDecl /*P*/ method = E.getMethodDecl$Const();
    
    // If the method is -retain, and the receiver's being loaded from
    // a __weak variable, peephole the entire operation to objc_loadWeakRetained.
    if ((method != null) && E.getReceiverKind() == ObjCMessageExpr.ReceiverKind.Instance
       && method.getMethodFamily() == ObjCMethodFamily.OMF_retain) {
      {
        /*const*/ Expr /*P*/ lvalueExpr = CGObjCStatics.findWeakLValue(E.getInstanceReceiver$Const());
        if ((lvalueExpr != null)) {
          LValue lvalue = $this().EmitLValue(lvalueExpr);
          Value /*P*/ result = $this().EmitARCLoadWeakRetained(lvalue.getAddress());
          return CGObjCStatics.AdjustObjCObjectType(/*Deref*/$this(), E.getType(), RValue.get(result));
        }
      }
    }
    
    // We don't retain the receiver in delegate init calls, and this is
    // safe because the receiver value is always loaded from 'self',
    // which we zero out.  We don't want to Block_copy block receivers,
    // though.
    boolean retainSelf = (!isDelegateInit
       && $this().CGM.getLangOpts().ObjCAutoRefCount
       && (method != null)
       && method.hasAttr(NSConsumesSelfAttr.class));
    
    final CGObjCRuntime /*&*/ Runtime = $this().CGM.getObjCRuntime();
    boolean isSuperMessage = false;
    boolean isClassMessage = false;
    ObjCInterfaceDecl /*P*/ OID = null;
    // Find the receiver
    QualType ReceiverType/*J*/= new QualType();
    Value /*P*/ Receiver = null;
    switch (E.getReceiverKind()) {
     case Instance:
      ReceiverType.$assignMove(E.getInstanceReceiver$Const().getType());
      if (retainSelf) {
        PointerBoolPair<Value /*P*/ > ter = CGObjCStatics.tryEmitARCRetainScalarExpr(/*Deref*/$this(), 
            E.getInstanceReceiver$Const());
        Receiver = ter.getPointer();
        if (ter.getInt()) {
          retainSelf = false;
        }
      } else {
        Receiver = $this().EmitScalarExpr(E.getInstanceReceiver$Const());
      }
      break;
     case Class:
      {
        ReceiverType.$assignMove(E.getClassReceiver());
        /*const*/ ObjCObjectType /*P*/ ObjTy = ReceiverType.$arrow().getAs(ObjCObjectType.class);
        assert ((ObjTy != null)) : "Invalid Objective-C class message send";
        OID = ObjTy.getInterface();
        assert ((OID != null)) : "Invalid Objective-C class message send";
        Receiver = Runtime.GetClass(/*Deref*/$this(), OID);
        isClassMessage = true;
        break;
      }
     case SuperInstance:
      ReceiverType.$assignMove(E.getSuperType());
      Receiver = $this().LoadObjCSelf();
      isSuperMessage = true;
      break;
     case SuperClass:
      ReceiverType.$assignMove(E.getSuperType());
      Receiver = $this().LoadObjCSelf();
      isSuperMessage = true;
      isClassMessage = true;
      break;
    }
    if (retainSelf) {
      Receiver = $this().EmitARCRetainNonBlock(Receiver);
    }
    
    // In ARC, we sometimes want to "extend the lifetime"
    // (i.e. retain+autorelease) of receivers of returns-inner-pointer
    // messages.
    if ($this().getLangOpts().ObjCAutoRefCount && (method != null)
       && method.hasAttr(ObjCReturnsInnerPointerAttr.class)
       && CGObjCStatics.shouldExtendReceiverForInnerPointerMessage(E)) {
      Receiver = $this().EmitARCRetainAutorelease(new QualType(ReceiverType), Receiver);
    }
    
    QualType ResultType = (method != null) ? method.getReturnType() : E.getType();
    
    Args/*J*/= new CallArgList();
    $this().EmitCallArgs(Args, method, E.arguments$Const());
    
    // For delegate init calls in ARC, do an unsafe store of null into
    // self.  This represents the call taking direct ownership of that
    // value.  We have to do this after emitting the other call
    // arguments because they might also reference self, but we don't
    // have to worry about any of them modifying self because that would
    // be an undefined read and write of an object in unordered
    // expressions.
    if (isDelegateInit) {
      assert ($this().getLangOpts().ObjCAutoRefCount) : "delegate init calls should only be marked in ARC";
      
      // Do an unsafe store of null into self.
      Address selfAddr = $this().GetAddrOfLocalVar(cast_ObjCMethodDecl($this().CurCodeDecl).getSelfDecl());
      $this().Builder.CreateStore(CGObjCStatics.getNullForVariable(new Address(selfAddr)), new Address(selfAddr));
    }
    
    RValue result/*J*/= new RValue();
    if (isSuperMessage) {
      // super is only valid in an Objective-C method
      /*const*/ ObjCMethodDecl /*P*/ OMD = cast_ObjCMethodDecl($this().CurFuncDecl);
      boolean isCategoryImpl = isa_ObjCCategoryImplDecl(OMD.getDeclContext$Const());
      result.$assignMove(Runtime.GenerateMessageSendSuper(/*Deref*/$this(), new ReturnValueSlot(Return), new QualType(ResultType), 
              E.getSelector(), 
              OMD.getClassInterface$Const(), 
              isCategoryImpl, 
              Receiver, 
              isClassMessage, 
              Args, 
              method));
    } else {
      result.$assignMove(Runtime.GenerateMessageSend(/*Deref*/$this(), new ReturnValueSlot(Return), new QualType(ResultType), 
              E.getSelector(), 
              Receiver, Args, OID, 
              method));
    }
    
    // For delegate init calls in ARC, implicitly store the result of
    // the call back into self.  This takes ownership of the value.
    if (isDelegateInit) {
      Address selfAddr = $this().GetAddrOfLocalVar(cast_ObjCMethodDecl($this().CurCodeDecl).getSelfDecl());
      Value /*P*/ newSelf = result.getScalarVal();
      
      // The delegate return type isn't necessarily a matching type; in
      // fact, it's quite likely to be 'id'.
      org.llvm.ir.Type /*P*/ selfTy = selfAddr.getElementType();
      newSelf = $this().Builder.CreateBitCast(newSelf, selfTy);
      
      $this().Builder.CreateStore(newSelf, new Address(selfAddr));
    }
    
    return CGObjCStatics.AdjustObjCObjectType(/*Deref*/$this(), E.getType(), new RValue(result));
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}


// ARC primitives.

/// i8* \@objc_initWeak(i8** %addr, i8* %value)
/// Returns %value.  %addr is known to not have a current weak entry.
/// Essentially equivalent to:
///   *addr = nil; objc_storeWeak(addr, value);
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCInitWeak">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2237,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCInitWeak", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitARCInitWeakENS0_7AddressEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitARCInitWeakENS0_7AddressEPN4llvm5ValueE")
//</editor-fold>
public final void EmitARCInitWeak(Address addr, Value /*P*/ value) {
  // If we're initializing to null, just write null to memory; no need
  // to get the runtime involved.  But don't do this if optimization
  // is enabled, because accounting for this would make the optimizer
  // much more complicated.
  if (isa_ConstantPointerNull(value)
     && $2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) == 0) {
    $this().Builder.CreateStore(value, new Address(addr));
    return;
  }
  
  CGObjCStatics.emitARCStoreOperation(/*Deref*/$this(), new Address(addr), value, 
      $this().CGM.getObjCEntrypoints().objc_initWeak_ref, 
      new StringRef(/*KEEP_STR*/"objc_initWeak"), /*ignored*/ true);
}


/// void \@objc_destroyWeak(i8** %addr)
/// Essentially objc_storeWeak(addr, nil).
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCDestroyWeak">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2255,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCDestroyWeak", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitARCDestroyWeakENS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitARCDestroyWeakENS0_7AddressE")
//</editor-fold>
public final void EmitARCDestroyWeak(Address addr) {
  final type$ref<Constant /*P*/ /*&*/> fn = $this().CGM.getObjCEntrypoints().objc_destroyWeak_ref;
  if (!(fn.$deref() != null)) {
    org.llvm.ir.FunctionType /*P*/ fnType = org.llvm.ir.FunctionType.get($this().Builder.getVoidTy(), new ArrayRef<org.llvm.ir.Type /*P*/ >(Unnamed_field10.Int8PtrPtrTy, true), false);
    fn.$set(CGObjCStatics.createARCRuntimeFunction($this().CGM, fnType, new StringRef(/*KEEP_STR*/"objc_destroyWeak")));
  }
  
  // Cast the argument to 'id*'.
  addr.$assignMove($this().Builder.CreateBitCast(new Address(addr), Unnamed_field10.Int8PtrPtrTy));
  
  $this().EmitNounwindRuntimeCall(fn.$deref(), new ArrayRef<Value /*P*/ >(addr.getPointer(), true));
}


/// i8* \@objc_loadWeak(i8** %addr)
/// Essentially objc_autorelease(objc_loadWeakRetained(addr)).
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCLoadWeak">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2210,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCLoadWeak", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitARCLoadWeakENS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitARCLoadWeakENS0_7AddressE")
//</editor-fold>
public final Value /*P*/ EmitARCLoadWeak(Address addr) {
  return CGObjCStatics.emitARCLoadOperation(/*Deref*/$this(), new Address(addr), 
      $this().CGM.getObjCEntrypoints().objc_loadWeak_ref, 
      new StringRef(/*KEEP_STR*/"objc_loadWeak"));
}


/// i8* \@objc_loadWeakRetained(i8** %addr)
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCLoadWeakRetained">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2217,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCLoadWeakRetained", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitARCLoadWeakRetainedENS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitARCLoadWeakRetainedENS0_7AddressE")
//</editor-fold>
public final Value /*P*/ EmitARCLoadWeakRetained(Address addr) {
  return CGObjCStatics.emitARCLoadOperation(/*Deref*/$this(), new Address(addr), 
      $this().CGM.getObjCEntrypoints().objc_loadWeakRetained_ref, 
      new StringRef(/*KEEP_STR*/"objc_loadWeakRetained"));
}


/// i8* \@objc_storeWeak(i8** %addr, i8* %value)
/// Returns %value.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCStoreWeak">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2225,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCStoreWeak", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitARCStoreWeakENS0_7AddressEPN4llvm5ValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitARCStoreWeakENS0_7AddressEPN4llvm5ValueEb")
//</editor-fold>
public final Value /*P*/ EmitARCStoreWeak(Address addr, 
                Value /*P*/ value, 
                boolean ignored) {
  return CGObjCStatics.emitARCStoreOperation(/*Deref*/$this(), new Address(addr), value, 
      $this().CGM.getObjCEntrypoints().objc_storeWeak_ref, 
      new StringRef(/*KEEP_STR*/"objc_storeWeak"), ignored);
}


/// void \@objc_copyWeak(i8** %dest, i8** %src)
/// Disregards the current value in %dest.  Essentially
///   objc_release(objc_initWeak(dest, objc_readWeakRetained(src)))
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCCopyWeak">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2281,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCCopyWeak", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitARCCopyWeakENS0_7AddressES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitARCCopyWeakENS0_7AddressES2_")
//</editor-fold>
public final void EmitARCCopyWeak(Address dst, Address src) {
  CGObjCStatics.emitARCCopyOperation(/*Deref*/$this(), new Address(dst), new Address(src), 
      $this().CGM.getObjCEntrypoints().objc_copyWeak_ref, 
      new StringRef(/*KEEP_STR*/"objc_copyWeak"));
}


/// void \@objc_moveWeak(i8** %dest, i8** %src)
/// Disregards the current value in %dest.  Leaves %src pointing to nothing.
/// Essentially (objc_copyWeak(dest, src), objc_destroyWeak(src)).
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCMoveWeak">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2272,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCMoveWeak", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitARCMoveWeakENS0_7AddressES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitARCMoveWeakENS0_7AddressES2_")
//</editor-fold>
public final void EmitARCMoveWeak(Address dst, Address src) {
  CGObjCStatics.emitARCCopyOperation(/*Deref*/$this(), new Address(dst), new Address(src), 
      $this().CGM.getObjCEntrypoints().objc_moveWeak_ref, 
      new StringRef(/*KEEP_STR*/"objc_moveWeak"));
}


/// Do a fused retain/autorelease of the given object.
///   call i8* \@objc_retainAutorelease(i8* %value)
/// or
///   %retain = call i8* \@objc_retainBlock(i8* %value)
///   call i8* \@objc_autorelease(i8* %retain)
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCRetainAutorelease">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2185,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCRetainAutorelease", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitARCRetainAutoreleaseENS_8QualTypeEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitARCRetainAutoreleaseENS_8QualTypeEPN4llvm5ValueE")
//</editor-fold>
public final Value /*P*/ EmitARCRetainAutorelease(QualType type, 
                        Value /*P*/ value) {
  if (!type.$arrow().isBlockPointerType()) {
    return $this().EmitARCRetainAutoreleaseNonBlock(value);
  }
  if (isa_ConstantPointerNull(value)) {
    return value;
  }
  
  org.llvm.ir.Type /*P*/ origType = value.getType();
  value = $this().Builder.CreateBitCast(value, Unnamed_field9.Int8PtrTy);
  value = $this().EmitARCRetainBlock(value, /*mandatory*/ true);
  value = $this().EmitARCAutorelease(value);
  return $this().Builder.CreateBitCast(value, origType);
}


/// Do a fused retain/autorelease of the given object.
///   call i8* \@objc_retainAutorelease(i8* %value)
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCRetainAutoreleaseNonBlock">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2201,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCRetainAutoreleaseNonBlock", NM="_ZN5clang7CodeGen15CodeGenFunction32EmitARCRetainAutoreleaseNonBlockEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction32EmitARCRetainAutoreleaseNonBlockEPN4llvm5ValueE")
//</editor-fold>
public final Value /*P*/ EmitARCRetainAutoreleaseNonBlock(Value /*P*/ value) {
  return CGObjCStatics.emitARCValueOperation(/*Deref*/$this(), value, 
      $this().CGM.getObjCEntrypoints().objc_retainAutorelease_ref, 
      new StringRef(/*KEEP_STR*/"objc_retainAutorelease"));
}


/// Store into a strong object.  Sometimes calls this:
///   call void \@objc_storeStrong(i8** %addr, i8* %value)
/// Other times, breaks it down into components.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCStoreStrong">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2119,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCStoreStrong", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitARCStoreStrongENS0_6LValueEPN4llvm5ValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitARCStoreStrongENS0_6LValueEPN4llvm5ValueEb")
//</editor-fold>
public final Value /*P*/ EmitARCStoreStrong(LValue dst, 
                  Value /*P*/ newValue, 
                  boolean ignored) {
  QualType type = dst.getType();
  boolean isBlock = type.$arrow().isBlockPointerType();
  
  // Use a store barrier at -O0 unless this is a block type or the
  // lvalue is inadequately aligned.
  if ($this().shouldUseFusedARCCalls()
     && !isBlock
     && (dst.getAlignment().isZero()
     || dst.getAlignment().$greatereq(CharUnits.fromQuantity($uchar2long(Unnamed_field13.PointerAlignInBytes))))) {
    return $this().EmitARCStoreStrongCall(dst.getAddress(), newValue, ignored);
  }
  
  // Otherwise, split it out.
  
  // Retain the new value.
  newValue = $this().EmitARCRetain(new QualType(type), newValue);
  
  // Read the old value.
  Value /*P*/ oldValue = $this().EmitLoadOfScalar(new LValue(dst), new SourceLocation());
  
  // Store.  We do this before the release so that any deallocs won't
  // see the old value.
  $this().EmitStoreOfScalar(newValue, new LValue(dst));
  
  // Finally, release the old value.
  $this().EmitARCRelease(oldValue, dst.isARCPreciseLifetime());
  
  return newValue;
}


/// Store into a strong object.  Always calls this:
///   call void \@objc_storeStrong(i8** %addr, i8* %value)
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCStoreStrongCall">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2093,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCStoreStrongCall", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitARCStoreStrongCallENS0_7AddressEPN4llvm5ValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitARCStoreStrongCallENS0_7AddressEPN4llvm5ValueEb")
//</editor-fold>
public final Value /*P*/ EmitARCStoreStrongCall(Address addr, 
                      Value /*P*/ value, 
                      boolean ignored) {
  assert (addr.getElementType() == value.getType());
  
  final type$ref<Constant /*P*/ /*&*/> fn = $this().CGM.getObjCEntrypoints().objc_storeStrong_ref;
  if (!(fn.$deref() != null)) {
    org.llvm.ir.Type /*P*/ argTypes[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {Unnamed_field10.Int8PtrPtrTy, Unnamed_field9.Int8PtrTy};
    org.llvm.ir.FunctionType /*P*/ fnType = org.llvm.ir.FunctionType.get($this().Builder.getVoidTy(), new ArrayRef<org.llvm.ir.Type /*P*/ >(argTypes, true), false);
    fn.$set(CGObjCStatics.createARCRuntimeFunction($this().CGM, fnType, new StringRef(/*KEEP_STR*/"objc_storeStrong")));
  }
  
  Value /*P*/ args[/*2*/] = new Value /*P*/  [/*2*/] {
    $this().Builder.CreateBitCast(addr.getPointer(), Unnamed_field10.Int8PtrPtrTy), 
    $this().Builder.CreateBitCast(value, Unnamed_field9.Int8PtrTy)
  };
  $this().EmitNounwindRuntimeCall(fn.$deref(), new ArrayRef<Value /*P*/ >(args, true));
  if (ignored) {
    return null;
  }
  return value;
}


/// Produce the code to do a retain.  Based on the type, calls one of:
///   call i8* \@objc_retain(i8* %value)
///   call i8* \@objc_retainBlock(i8* %value)
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCRetain">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1931,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCRetain", NM="_ZN5clang7CodeGen15CodeGenFunction13EmitARCRetainENS_8QualTypeEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13EmitARCRetainENS_8QualTypeEPN4llvm5ValueE")
//</editor-fold>
public final Value /*P*/ EmitARCRetain(QualType type, Value /*P*/ value) {
  if (type.$arrow().isBlockPointerType()) {
    return $this().EmitARCRetainBlock(value, /*mandatory*/ false);
  } else {
    return $this().EmitARCRetainNonBlock(value);
  }
}


/// Retain the given object, with normal retain semantics.
///   call i8* \@objc_retain(i8* %value)
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCRetainNonBlock">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1940,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCRetainNonBlock", NM="_ZN5clang7CodeGen15CodeGenFunction21EmitARCRetainNonBlockEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21EmitARCRetainNonBlockEPN4llvm5ValueE")
//</editor-fold>
public final Value /*P*/ EmitARCRetainNonBlock(Value /*P*/ value) {
  return CGObjCStatics.emitARCValueOperation(/*Deref*/$this(), value, 
      $this().CGM.getObjCEntrypoints().objc_retain_ref, 
      new StringRef(/*KEEP_STR*/"objc_retain"));
}


/// Retain the given block, with _Block_copy semantics.
///   call i8* \@objc_retainBlock(i8* %value)
///
/// \param mandatory - If false, emit the call with metadata
/// indicating that it's okay for the optimizer to eliminate this call
/// if it can prove that the block never escapes except down the stack.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCRetainBlock">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1952,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCRetainBlock", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitARCRetainBlockEPN4llvm5ValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitARCRetainBlockEPN4llvm5ValueEb")
//</editor-fold>
public final Value /*P*/ EmitARCRetainBlock(Value /*P*/ value, 
                  boolean mandatory) {
  Value /*P*/ result = CGObjCStatics.emitARCValueOperation(/*Deref*/$this(), value, 
      $this().CGM.getObjCEntrypoints().objc_retainBlock_ref, 
      new StringRef(/*KEEP_STR*/"objc_retainBlock"));
  
  // If the copy isn't mandatory, add !clang.arc.copy_on_escape to
  // tell the optimizer that it doesn't need to do this copy if the
  // block doesn't escape, where being passed as an argument doesn't
  // count as escaping.
  if (!mandatory && isa_Instruction(result)) {
    CallInst /*P*/ call = cast_CallInst(result.stripPointerCasts());
    assert (call.getCalledValue() == $this().CGM.getObjCEntrypoints().objc_retainBlock);
    
    call.setMetadata(new StringRef(/*KEEP_STR*/"clang.arc.copy_on_escape"), 
        MDNode.get($this().Builder.getContext(), new ArrayRef<Metadata /*P*/ >(None, true)));
  }
  
  return result;
}


/// Destroy a __strong variable.
///
/// At -O0, emit a call to store 'null' into the address;
/// instrumenting tools prefer this because the address is exposed,
/// but it's relatively cumbersome to optimize.
///
/// At -O1 and above, just load and call objc_release.
///
///   call void \@objc_storeStrong(i8** %addr, i8* null)
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCDestroyStrong">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2079,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCDestroyStrong", NM="_ZN5clang7CodeGen15CodeGenFunction20EmitARCDestroyStrongENS0_7AddressENS0_20ARCPreciseLifetime_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20EmitARCDestroyStrongENS0_7AddressENS0_20ARCPreciseLifetime_tE")
//</editor-fold>
public final void EmitARCDestroyStrong(Address addr, 
                    ARCPreciseLifetime_t precise) {
  if ($2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) == 0) {
    Value /*P*/ __null = CGObjCStatics.getNullForVariable(new Address(addr));
    $this().EmitARCStoreStrongCall(new Address(addr), __null, /*ignored*/ true);
    return;
  }
  
  Value /*P*/ value = $this().Builder.CreateLoad(new Address(addr));
  $this().EmitARCRelease(value, precise);
}


/// Release the given object.
///   call void \@objc_release(i8* %value)
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCRelease">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2047,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCRelease", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitARCReleaseEPN4llvm5ValueENS0_20ARCPreciseLifetime_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitARCReleaseEPN4llvm5ValueENS0_20ARCPreciseLifetime_tE")
//</editor-fold>
public final void EmitARCRelease(Value /*P*/ value, 
              ARCPreciseLifetime_t precise) {
  if (isa_ConstantPointerNull(value)) {
    return;
  }
  
  final type$ref<Constant /*P*/ /*&*/> fn = $this().CGM.getObjCEntrypoints().objc_release_ref;
  if (!(fn.$deref() != null)) {
    org.llvm.ir.FunctionType /*P*/ fnType = org.llvm.ir.FunctionType.get($this().Builder.getVoidTy(), new ArrayRef<org.llvm.ir.Type /*P*/ >(Unnamed_field9.Int8PtrTy, true), false);
    fn.$set(CGObjCStatics.createARCRuntimeFunction($this().CGM, fnType, new StringRef(/*KEEP_STR*/"objc_release")));
  }
  
  // Cast the argument to 'id'.
  value = $this().Builder.CreateBitCast(value, Unnamed_field9.Int8PtrTy);
  
  // Call objc_release.
  CallInst /*P*/ call = $this().EmitNounwindRuntimeCall(fn.$deref(), new ArrayRef<Value /*P*/ >(value, true));
  if (precise == ARCPreciseLifetime_t.ARCImpreciseLifetime) {
    call.setMetadata(new StringRef(/*KEEP_STR*/"clang.imprecise_release"), 
        MDNode.get($this().Builder.getContext(), new ArrayRef<Metadata /*P*/ >(None, true)));
  }
}


/// Autorelease the given object.
///   call i8* \@objc_autorelease(i8* %value)
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCAutorelease">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2154,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCAutorelease", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitARCAutoreleaseEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitARCAutoreleaseEPN4llvm5ValueE")
//</editor-fold>
public final Value /*P*/ EmitARCAutorelease(Value /*P*/ value) {
  return CGObjCStatics.emitARCValueOperation(/*Deref*/$this(), value, 
      $this().CGM.getObjCEntrypoints().objc_autorelease_ref, 
      new StringRef(/*KEEP_STR*/"objc_autorelease"));
}


/// Autorelease the given object.
///   call i8* \@objc_autoreleaseReturnValue(i8* %value)
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCAutoreleaseReturnValue">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2162,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCAutoreleaseReturnValue", NM="_ZN5clang7CodeGen15CodeGenFunction29EmitARCAutoreleaseReturnValueEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction29EmitARCAutoreleaseReturnValueEPN4llvm5ValueE")
//</editor-fold>
public final Value /*P*/ EmitARCAutoreleaseReturnValue(Value /*P*/ value) {
  return CGObjCStatics.emitARCValueOperation(/*Deref*/$this(), value, 
      $this().CGM.getObjCEntrypoints().objc_autoreleaseReturnValue_ref, 
      new StringRef(/*KEEP_STR*/"objc_autoreleaseReturnValue"), 
      /*isTailCall*/ true);
}


/// Do a fused retain/autorelease of the given object.
///   call i8* \@objc_retainAutoreleaseReturnValue(i8* %value)
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCRetainAutoreleaseReturnValue">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2172,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCRetainAutoreleaseReturnValue", NM="_ZN5clang7CodeGen15CodeGenFunction35EmitARCRetainAutoreleaseReturnValueEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction35EmitARCRetainAutoreleaseReturnValueEPN4llvm5ValueE")
//</editor-fold>
public final Value /*P*/ EmitARCRetainAutoreleaseReturnValue(Value /*P*/ value) {
  return CGObjCStatics.emitARCValueOperation(/*Deref*/$this(), value, 
      $this().CGM.getObjCEntrypoints().objc_retainAutoreleaseReturnValue_ref, 
      new StringRef(/*KEEP_STR*/"objc_retainAutoreleaseReturnValue"), 
      /*isTailCall*/ true);
}


/// Retain the given object which is the result of a function call.
///   call i8* \@objc_retainAutoreleasedReturnValue(i8* %value)
///
/// Yes, this function name is one character away from a different
/// call with completely different semantics.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCRetainAutoreleasedReturnValue">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2022,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCRetainAutoreleasedReturnValue", NM="_ZN5clang7CodeGen15CodeGenFunction36EmitARCRetainAutoreleasedReturnValueEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction36EmitARCRetainAutoreleasedReturnValueEPN4llvm5ValueE")
//</editor-fold>
public final Value /*P*/ EmitARCRetainAutoreleasedReturnValue(Value /*P*/ value) {
  CGObjCStatics.emitAutoreleasedReturnValueMarker(/*Deref*/$this());
  return CGObjCStatics.emitARCValueOperation(/*Deref*/$this(), value, 
      $this().CGM.getObjCEntrypoints().objc_retainAutoreleasedReturnValue_ref, 
      new StringRef(/*KEEP_STR*/"objc_retainAutoreleasedReturnValue"));
}


/// Claim a possibly-autoreleased return value at +0.  This is only
/// valid to do in contexts which do not rely on the retain to keep
/// the object valid for for all of its uses; for example, when
/// the value is ignored, or when it is being assigned to an
/// __unsafe_unretained variable.
///
///   call i8* \@objc_unsafeClaimAutoreleasedReturnValue(i8* %value)
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCUnsafeClaimAutoreleasedReturnValue">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2037,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCUnsafeClaimAutoreleasedReturnValue", NM="_ZN5clang7CodeGen15CodeGenFunction41EmitARCUnsafeClaimAutoreleasedReturnValueEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction41EmitARCUnsafeClaimAutoreleasedReturnValueEPN4llvm5ValueE")
//</editor-fold>
public final Value /*P*/ EmitARCUnsafeClaimAutoreleasedReturnValue(Value /*P*/ value) {
  CGObjCStatics.emitAutoreleasedReturnValueMarker(/*Deref*/$this());
  return CGObjCStatics.emitARCValueOperation(/*Deref*/$this(), value, 
      $this().CGM.getObjCEntrypoints().objc_unsafeClaimAutoreleasedReturnValue_ref, 
      new StringRef(/*KEEP_STR*/"objc_unsafeClaimAutoreleasedReturnValue"));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCStoreAutoreleasing">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 3108,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCStoreAutoreleasing", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitARCStoreAutoreleasingEPKNS_14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitARCStoreAutoreleasingEPKNS_14BinaryOperatorE")
//</editor-fold>
public final std.pair<LValue, Value /*P*/ > EmitARCStoreAutoreleasing(/*const*/ org.clang.ast.BinaryOperator /*P*/ e) {
  Value /*P*/ value = $this().EmitARCRetainAutoreleaseScalarExpr(e.getRHS());
  LValue lvalue = $this().EmitLValue(e.getLHS());
  
  $this().EmitStoreOfScalar(value, new LValue(lvalue));
  
  return new std.pairTypePtr<LValue, Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, new LValue(/*Fwd*/lvalue), value);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCStoreStrong">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 3077,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCStoreStrong", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitARCStoreStrongEPKNS_14BinaryOperatorEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitARCStoreStrongEPKNS_14BinaryOperatorEb")
//</editor-fold>
public final std.pair<LValue, Value /*P*/ > EmitARCStoreStrong(/*const*/ org.clang.ast.BinaryOperator /*P*/ e, 
                  boolean ignored) {
  // Evaluate the RHS first.
  PointerBoolPair<Value /*P*/ > result = CGObjCStatics.tryEmitARCRetainScalarExpr(/*Deref*/$this(), e.getRHS());
  Value /*P*/ value = result.getPointer();
  
  boolean hasImmediateRetain = result.getInt();
  
  // If we didn't emit a retained object, and the l-value is of block
  // type, then we need to emit the block-retain immediately in case
  // it invalidates the l-value.
  if (!hasImmediateRetain && e.getType().$arrow().isBlockPointerType()) {
    value = $this().EmitARCRetainBlock(value, /*mandatory*/ false);
    hasImmediateRetain = true;
  }
  
  LValue lvalue = $this().EmitLValue(e.getLHS());
  
  // If the RHS was emitted retained, expand this.
  if (hasImmediateRetain) {
    Value /*P*/ oldValue = $this().EmitLoadOfScalar(new LValue(lvalue), new SourceLocation());
    $this().EmitStoreOfScalar(value, new LValue(lvalue));
    $this().EmitARCRelease(oldValue, lvalue.isARCPreciseLifetime());
  } else {
    value = $this().EmitARCStoreStrong(new LValue(lvalue), value, ignored);
  }
  
  return new std.pairTypePtr<LValue, Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, new LValue(/*Fwd*/lvalue), value);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCStoreUnsafeUnretained">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 3058,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCStoreUnsafeUnretained", NM="_ZN5clang7CodeGen15CodeGenFunction28EmitARCStoreUnsafeUnretainedEPKNS_14BinaryOperatorEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28EmitARCStoreUnsafeUnretainedEPKNS_14BinaryOperatorEb")
//</editor-fold>
public final std.pair<LValue, Value /*P*/ > EmitARCStoreUnsafeUnretained(/*const*/ org.clang.ast.BinaryOperator /*P*/ e, 
                            boolean ignored) {
  // Evaluate the RHS first.  If we're ignoring the result, assume
  // that we can emit at an unsafe +0.
  Value /*P*/ value;
  if (ignored) {
    value = $this().EmitARCUnsafeUnretainedScalarExpr(e.getRHS());
  } else {
    value = $this().EmitScalarExpr(e.getRHS());
  }
  
  // Emit the LHS and perform the store.
  LValue lvalue = $this().EmitLValue(e.getLHS());
  $this().EmitStoreOfScalar(value, new LValue(lvalue));
  
  return new std.pairTypePtr<LValue, Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, new LValue(JD$Move.INSTANCE, /*Fwd*/std.move(lvalue)), value);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCThrowOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2971,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCThrowOperand", NM="_ZN5clang7CodeGen15CodeGenFunction20EmitObjCThrowOperandEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20EmitObjCThrowOperandEPKNS_4ExprE")
//</editor-fold>
public final Value /*P*/ EmitObjCThrowOperand(/*const*/ Expr /*P*/ expr) {
  // In ARC, retain and autorelease the expression.
  if ($this().getLangOpts().ObjCAutoRefCount) {
    // Do so before running any cleanups for the full-expression.
    // EmitARCRetainAutoreleaseScalarExpr does this for us.
    return $this().EmitARCRetainAutoreleaseScalarExpr(expr);
  }
  
  // Otherwise, use the normal scalar-expression emission.  The
  // exception machinery doesn't do anything special with the
  // exception like retaining it, so there's no safety associated with
  // only running cleanups after the throw has started, and when it
  // matters it tends to be substantially inferior code.
  return $this().EmitScalarExpr(expr);
}


/// Produce the code for a CK_ARCConsumeObject.  Does a primitive
/// release at the end of the full-expression.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCConsumeObject">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1768,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCConsumeObject", NM="_ZN5clang7CodeGen15CodeGenFunction21EmitObjCConsumeObjectENS_8QualTypeEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21EmitObjCConsumeObjectENS_8QualTypeEPN4llvm5ValueE")
//</editor-fold>
public final Value /*P*/ EmitObjCConsumeObject(QualType type, 
                     Value /*P*/ object) {
  // If we're in a conditional branch, we need to make the cleanup
  // conditional.
  $this().<CallObjCRelease>pushFullExprCleanup($this().getARCCleanupKind(), (Object... A) -> new CallObjCRelease((Value) A[0]), object);
  return object;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCExtendObjectLifetime">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1776,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCExtendObjectLifetime", NM="_ZN5clang7CodeGen15CodeGenFunction28EmitObjCExtendObjectLifetimeENS_8QualTypeEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28EmitObjCExtendObjectLifetimeENS_8QualTypeEPN4llvm5ValueE")
//</editor-fold>
public final Value /*P*/ EmitObjCExtendObjectLifetime(QualType type, 
                            Value /*P*/ value) {
  return $this().EmitARCRetainAutorelease(new QualType(type), value);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCExtendBlockObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2953,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCExtendBlockObject", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitARCExtendBlockObjectEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitARCExtendBlockObjectEPKNS_4ExprE")
//</editor-fold>
public final Value /*P*/ EmitARCExtendBlockObject(/*const*/ Expr /*P*/ e) {
  Value /*P*/ result;
  boolean doRetain;
  if (CGObjCStatics.shouldEmitSeparateBlockRetain(e)) {
    result = $this().EmitScalarExpr(e);
    doRetain = true;
  } else {
    PointerBoolPair<Value /*P*/ > subresult = CGObjCStatics.tryEmitARCRetainScalarExpr(/*Deref*/$this(), e);
    result = subresult.getPointer();
    doRetain = !subresult.getInt();
  }
  if (doRetain) {
    result = $this().EmitARCRetainBlock(result, /*mandatory*/ true);
  }
  return $this().EmitObjCConsumeObject(e.getType(), result);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCReclaimReturnedObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2534,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCReclaimReturnedObject", NM="_ZN5clang7CodeGen15CodeGenFunction28EmitARCReclaimReturnedObjectEPKNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28EmitARCReclaimReturnedObjectEPKNS_4ExprEb")
//</editor-fold>
public final Value /*P*/ EmitARCReclaimReturnedObject(/*const*/ Expr /*P*/ E, 
                            boolean allowUnsafeClaim) {
  if (allowUnsafeClaim
     && $this().CGM.getLangOpts().ObjCRuntime.hasARCUnsafeClaimAutoreleasedReturnValue()) {
    return CGObjCStatics.emitARCUnsafeClaimCallResult(/*Deref*/$this(), E);
  } else {
    Value /*P*/ value = CGObjCStatics.emitARCRetainCallResult(/*Deref*/$this(), E);
    return $this().EmitObjCConsumeObject(E.getType(), value);
  }
}


/// EmitARCRetainScalarExpr - Semantically equivalent to
/// EmitARCRetainObject(e->getType(), EmitScalarExpr(e)), but making a
/// best-effort attempt to peephole expressions that naturally produce
/// retained objects.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCRetainScalarExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2920,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCRetainScalarExpr", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitARCRetainScalarExprEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitARCRetainScalarExprEPKNS_4ExprE")
//</editor-fold>
public final Value /*P*/ EmitARCRetainScalarExpr(/*const*/ Expr /*P*/ e) {
  {
    // The retain needs to happen within the full-expression.
    /*const*/ ExprWithCleanups /*P*/ cleanups = dyn_cast_ExprWithCleanups(e);
    if ((cleanups != null)) {
      RunCleanupsScope scope = null;
      try {
        $this().enterFullExpression(cleanups);
        scope/*J*/= new RunCleanupsScope(/*Deref*/$this());
        return $this().EmitARCRetainScalarExpr(cleanups.getSubExpr$Const());
      } finally {
        if (scope != null) { scope.$destroy(); }
      }
    }
  }
  
  PointerBoolPair<Value /*P*/ > result = CGObjCStatics.tryEmitARCRetainScalarExpr(/*Deref*/$this(), e);
  Value /*P*/ value = result.getPointer();
  if (!result.getInt()) {
    value = $this().EmitARCRetain(e.getType(), value);
  }
  return value;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCRetainAutoreleaseScalarExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2935,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCRetainAutoreleaseScalarExpr", NM="_ZN5clang7CodeGen15CodeGenFunction34EmitARCRetainAutoreleaseScalarExprEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction34EmitARCRetainAutoreleaseScalarExprEPKNS_4ExprE")
//</editor-fold>
public final Value /*P*/ EmitARCRetainAutoreleaseScalarExpr(/*const*/ Expr /*P*/ e) {
  {
    // The retain needs to happen within the full-expression.
    /*const*/ ExprWithCleanups /*P*/ cleanups = dyn_cast_ExprWithCleanups(e);
    if ((cleanups != null)) {
      RunCleanupsScope scope = null;
      try {
        $this().enterFullExpression(cleanups);
        scope/*J*/= new RunCleanupsScope(/*Deref*/$this());
        return $this().EmitARCRetainAutoreleaseScalarExpr(cleanups.getSubExpr$Const());
      } finally {
        if (scope != null) { scope.$destroy(); }
      }
    }
  }
  
  PointerBoolPair<Value /*P*/ > result = CGObjCStatics.tryEmitARCRetainScalarExpr(/*Deref*/$this(), e);
  Value /*P*/ value = result.getPointer();
  if (result.getInt()) {
    value = $this().EmitARCAutorelease(value);
  } else {
    value = $this().EmitARCRetainAutorelease(e.getType(), value);
  }
  return value;
}


/// EmitARCUnsafeUnretainedScalarExpr - Semantically equivalent to
/// immediately releasing the resut of EmitARCRetainScalarExpr, but
/// avoiding any spurious retains, including by performing reclaims
/// with objc_unsafeClaimAutoreleasedReturnValue.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCUnsafeUnretainedScalarExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 3047,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCUnsafeUnretainedScalarExpr", NM="_ZN5clang7CodeGen15CodeGenFunction33EmitARCUnsafeUnretainedScalarExprEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction33EmitARCUnsafeUnretainedScalarExprEPKNS_4ExprE")
//</editor-fold>
public final Value /*P*/ EmitARCUnsafeUnretainedScalarExpr(/*const*/ Expr /*P*/ e) {
  {
    // Look through full-expressions.
    /*const*/ ExprWithCleanups /*P*/ cleanups = dyn_cast_ExprWithCleanups(e);
    if ((cleanups != null)) {
      RunCleanupsScope scope = null;
      try {
        $this().enterFullExpression(cleanups);
        scope/*J*/= new RunCleanupsScope(/*Deref*/$this());
        return CGObjCStatics.emitARCUnsafeUnretainedScalarExpr(/*Deref*/$this(), cleanups.getSubExpr$Const());
      } finally {
        if (scope != null) { scope.$destroy(); }
      }
    }
  }
  
  return CGObjCStatics.emitARCUnsafeUnretainedScalarExpr(/*Deref*/$this(), e);
}


/// Given a number of pointers, inform the optimizer that they're
/// being intrinsically used up until this point in the program.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitARCIntrinsicUse">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1783,
 FQN="clang::CodeGen::CodeGenFunction::EmitARCIntrinsicUse", NM="_ZN5clang7CodeGen15CodeGenFunction19EmitARCIntrinsicUseEN4llvm8ArrayRefIPNS2_5ValueEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19EmitARCIntrinsicUseEN4llvm8ArrayRefIPNS2_5ValueEEE")
//</editor-fold>
public final void EmitARCIntrinsicUse(ArrayRef<Value /*P*/ > values) {
  final type$ref<Constant /*P*/ /*&*/> fn = $this().CGM.getObjCEntrypoints().clang_arc_use_ref;
  if (!(fn.$deref() != null)) {
    org.llvm.ir.FunctionType /*P*/ fnType = org.llvm.ir.FunctionType.get($this().CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(None, true), true);
    fn.$set($this().CGM.CreateRuntimeFunction(fnType, new StringRef(/*KEEP_STR*/"clang.arc.use")));
  }
  
  // This isn't really a "runtime" function, but as an intrinsic it
  // doesn't really matter as long as we align things up.
  $this().EmitNounwindRuntimeCall(fn.$deref(), new ArrayRef<Value /*P*/ >(values));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::destroyARCStrongImprecise">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2363,
 FQN="clang::CodeGen::CodeGenFunction::destroyARCStrongImprecise", NM="_ZN5clang7CodeGen15CodeGenFunction25destroyARCStrongImpreciseERS1_NS0_7AddressENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25destroyARCStrongImpreciseERS1_NS0_7AddressENS_8QualTypeE")
//</editor-fold>
public static void destroyARCStrongImprecise(final CodeGenFunction /*&*/ CGF, 
                         Address addr, 
                         QualType type) {
  CGF.EmitARCDestroyStrong(new Address(addr), ARCPreciseLifetime_t.ARCImpreciseLifetime);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::destroyARCStrongPrecise">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2357,
 FQN="clang::CodeGen::CodeGenFunction::destroyARCStrongPrecise", NM="_ZN5clang7CodeGen15CodeGenFunction23destroyARCStrongPreciseERS1_NS0_7AddressENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23destroyARCStrongPreciseERS1_NS0_7AddressENS_8QualTypeE")
//</editor-fold>
public static void destroyARCStrongPrecise(final CodeGenFunction /*&*/ CGF, 
                       Address addr, 
                       QualType type) {
  CGF.EmitARCDestroyStrong(new Address(addr), ARCPreciseLifetime_t.ARCPreciseLifetime);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::destroyARCWeak">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2369,
 FQN="clang::CodeGen::CodeGenFunction::destroyARCWeak", NM="_ZN5clang7CodeGen15CodeGenFunction14destroyARCWeakERS1_NS0_7AddressENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14destroyARCWeakERS1_NS0_7AddressENS_8QualTypeE")
//</editor-fold>
public static void destroyARCWeak(final CodeGenFunction /*&*/ CGF, 
              Address addr, 
              QualType type) {
  CGF.EmitARCDestroyWeak(new Address(addr));
}


/// Produce the code to do a primitive release.
///   call void \@objc_autoreleasePoolPop(i8* %ptr)
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCAutoreleasePoolPop">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2302,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCAutoreleasePoolPop", NM="_ZN5clang7CodeGen15CodeGenFunction26EmitObjCAutoreleasePoolPopEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26EmitObjCAutoreleasePoolPopEPN4llvm5ValueE")
//</editor-fold>
public final void EmitObjCAutoreleasePoolPop(Value /*P*/ value) {
  assert (value.getType() == Unnamed_field9.Int8PtrTy);
  
  final type$ref<Constant /*P*/ /*&*/> fn = $this().CGM.getObjCEntrypoints().objc_autoreleasePoolPop_ref;
  if (!(fn.$deref() != null)) {
    org.llvm.ir.FunctionType /*P*/ fnType = org.llvm.ir.FunctionType.get($this().Builder.getVoidTy(), new ArrayRef<org.llvm.ir.Type /*P*/ >(Unnamed_field9.Int8PtrTy, true), false);
    
    // We don't want to use a weak import here; instead we should not
    // fall into this path.
    fn.$set(CGObjCStatics.createARCRuntimeFunction($this().CGM, fnType, new StringRef(/*KEEP_STR*/"objc_autoreleasePoolPop")));
  }
  
  // objc_autoreleasePoolPop can throw.
  $this().EmitRuntimeCallOrInvoke(fn.$deref(), new ArrayRef<Value /*P*/ >(value, true));
}


/// Produce the code to do a objc_autoreleasepool_push.
///   call i8* \@objc_autoreleasePoolPush(void)
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCAutoreleasePoolPush">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2289,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCAutoreleasePoolPush", NM="_ZN5clang7CodeGen15CodeGenFunction27EmitObjCAutoreleasePoolPushEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction27EmitObjCAutoreleasePoolPushEv")
//</editor-fold>
public final Value /*P*/ EmitObjCAutoreleasePoolPush() {
  final type$ref<Constant /*P*/ /*&*/> fn = $this().CGM.getObjCEntrypoints().objc_autoreleasePoolPush_ref;
  if (!(fn.$deref() != null)) {
    org.llvm.ir.FunctionType /*P*/ fnType = org.llvm.ir.FunctionType.get(Unnamed_field9.Int8PtrTy, false);
    fn.$set(CGObjCStatics.createARCRuntimeFunction($this().CGM, fnType, new StringRef(/*KEEP_STR*/"objc_autoreleasePoolPush")));
  }
  
  return $this().EmitNounwindRuntimeCall(fn.$deref());
}


/// Produce the code to do an MRR version objc_autoreleasepool_push.
/// Which is: [[NSAutoreleasePool alloc] init];
/// Where alloc is declared as: + (id) alloc; in NSAutoreleasePool class.
/// init is declared as: - (id) init; in its NSObject super class.
///
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCMRRAutoreleasePoolPush">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2324,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCMRRAutoreleasePoolPush", NM="_ZN5clang7CodeGen15CodeGenFunction30EmitObjCMRRAutoreleasePoolPushEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction30EmitObjCMRRAutoreleasePoolPushEv")
//</editor-fold>
public final Value /*P*/ EmitObjCMRRAutoreleasePoolPush() {
  CallArgList Args = null;
  try {
    final CGObjCRuntime /*&*/ Runtime = $this().CGM.getObjCRuntime();
    Value /*P*/ Receiver = Runtime.EmitNSAutoreleasePoolClassRef(/*Deref*/$this());
    // [NSAutoreleasePool alloc]
    type$ptr<IdentifierInfo /*P*/ > II = create_type$ptr($AddrOf($this().CGM.getContext().Idents.get(new StringRef(/*KEEP_STR*/"alloc"))));
    Selector AllocSel = $this().getContext().Selectors.getSelector(0, $AddrOf(II));
    Args/*J*/= new CallArgList();
    RValue AllocRV = Runtime.GenerateMessageSend(/*Deref*/$this(), new ReturnValueSlot(), 
        $this().getContext().getObjCIdType(), 
        new Selector(AllocSel), Receiver, Args);
    
    // [Receiver init]
    Receiver = AllocRV.getScalarVal();
    II.$set($AddrOf($this().CGM.getContext().Idents.get(new StringRef(/*KEEP_STR*/"init"))));
    Selector InitSel = $this().getContext().Selectors.getSelector(0, $AddrOf(II));
    RValue InitRV = Runtime.GenerateMessageSend(/*Deref*/$this(), new ReturnValueSlot(), 
        $this().getContext().getObjCIdType(), 
        new Selector(InitSel), Receiver, Args);
    return InitRV.getScalarVal();
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCAutoreleasePoolCleanup">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2396,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCAutoreleasePoolCleanup", NM="_ZN5clang7CodeGen15CodeGenFunction30EmitObjCAutoreleasePoolCleanupEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction30EmitObjCAutoreleasePoolCleanupEPN4llvm5ValueE")
//</editor-fold>
public final void EmitObjCAutoreleasePoolCleanup(Value /*P*/ Ptr) {
  if ($this().CGM.getLangOpts().ObjCAutoRefCount) {
    $this().EHStack.<CallObjCAutoreleasePoolObject>pushCleanup$T(CleanupKind.NormalCleanup, () -> new CallObjCAutoreleasePoolObject(Ptr));
  } else {
    $this().EHStack.<CallObjCMRRAutoreleasePoolObject>pushCleanup$T(CleanupKind.NormalCleanup, () -> new CallObjCMRRAutoreleasePoolObject(Ptr));
  }
}


/// Produce the code to do a primitive release.
/// [tmp drain];
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCMRRAutoreleasePoolPop">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2349,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCMRRAutoreleasePoolPop", NM="_ZN5clang7CodeGen15CodeGenFunction29EmitObjCMRRAutoreleasePoolPopEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction29EmitObjCMRRAutoreleasePoolPopEPN4llvm5ValueE")
//</editor-fold>
public final void EmitObjCMRRAutoreleasePoolPop(Value /*P*/ Arg) {
  CallArgList Args = null;
  try {
    type$ptr<IdentifierInfo /*P*/ > II = create_type$ptr($AddrOf($this().CGM.getContext().Idents.get(new StringRef(/*KEEP_STR*/"drain"))));
    Selector DrainSel = $this().getContext().Selectors.getSelector(0, $AddrOf(II));
    Args/*J*/= new CallArgList();
    $this().CGM.getObjCRuntime().GenerateMessageSend(/*Deref*/$this(), new ReturnValueSlot(), 
        $this().getContext().VoidTy.$QualType(), new Selector(DrainSel), Arg, Args);
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}


/// EmitExtendGCLifetime - Given a pointer to an Objective-C object,
/// make sure it survives garbage collection until this point.

/// EmitExtendGCLifetime - Given a pointer to an Objective-C object,
/// make sure it survives garbage collection until this point.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitExtendGCLifetime">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 3146,
 FQN="clang::CodeGen::CodeGenFunction::EmitExtendGCLifetime", NM="_ZN5clang7CodeGen15CodeGenFunction20EmitExtendGCLifetimeEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20EmitExtendGCLifetimeEPN4llvm5ValueE")
//</editor-fold>
public final void EmitExtendGCLifetime(Value /*P*/ object) {
  // We just use an inline assembly.
  org.llvm.ir.FunctionType /*P*/ extenderType = org.llvm.ir.FunctionType.get(VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(Unnamed_field9.VoidPtrTy, true), ((RequiredArgs.All_t.All).getValue() != 0));
  Value /*P*/ extender = InlineAsm.get(extenderType, 
      /* assembly */ new StringRef(/*KEEP_STR*/$EMPTY), 
      /* constraints */ new StringRef(/*KEEP_STR*/$r), 
      /* side effects */ true);
  
  object = $this().Builder.CreateBitCast(object, Unnamed_field9.VoidPtrTy);
  $this().EmitNounwindRuntimeCall(extender, new ArrayRef<Value /*P*/ >(object, true));
}

} // END OF class CodeGenFunction_CGObjC
