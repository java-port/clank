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
import org.llvm.ir.FunctionType;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;
import org.llvm.ir.intrinsic.ID;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.codegen.impl.CGClassStatics.*;
import static org.clang.codegen.CodeGen.impl.CodeGenStatics.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.ast.java.AstJavaDifferentiators.*;
import org.clang.codegen.java.ClangCodeGenDummies;
import org.llvm.transforms.utils.SanitizerStatKind;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGClass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGClass",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGCall ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12GetVTablePtrENS0_7AddressEPN4llvm4TypeEPKNS_13CXXRecordDeclE;_ZN5clang7CodeGen15CodeGenFunction15GetVTTParameterENS_10GlobalDeclEbb;_ZN5clang7CodeGen15CodeGenFunction16EmitCtorPrologueEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeERNS0_15FunctionArgListE;_ZN5clang7CodeGen15CodeGenFunction16destroyCXXObjectERS1_NS0_7AddressENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction17EnterDtorCleanupsEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeE;_ZN5clang7CodeGen15CodeGenFunction17getVTablePointersENS_13BaseSubobjectEPKNS_13CXXRecordDeclENS_9CharUnitsEbS5_RN4llvm11SmallPtrSetIS5_Lj4EEERNS7_11SmallVectorINS1_4VPtrELj4EEE;_ZN5clang7CodeGen15CodeGenFunction17getVTablePointersEPKNS_13CXXRecordDeclE;_ZN5clang7CodeGen15CodeGenFunction18EmitDestructorBodyERNS0_15FunctionArgListE;_ZN5clang7CodeGen15CodeGenFunction18EmitVTablePtrCheckEPKNS_13CXXRecordDeclEPN4llvm5ValueENS1_16CFITypeCheckKindENS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction18LoadCXXThisAddressEv;_ZN5clang7CodeGen15CodeGenFunction19EmitConstructorBodyERNS0_15FunctionArgListE;_ZN5clang7CodeGen15CodeGenFunction21EmitCXXDestructorCallEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeEbbNS0_7AddressE;_ZN5clang7CodeGen15CodeGenFunction21GetAddressOfBaseClassENS0_7AddressEPKNS_13CXXRecordDeclEPKPKNS_16CXXBaseSpecifierESA_bNS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction21PushDestructorCleanupENS_8QualTypeENS0_7AddressE;_ZN5clang7CodeGen15CodeGenFunction21PushDestructorCleanupEPKNS_17CXXDestructorDeclENS0_7AddressE;_ZN5clang7CodeGen15CodeGenFunction22EmitCXXConstructorCallEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeEbbNS0_7AddressEPKNS_16CXXConstructExprE;_ZN5clang7CodeGen15CodeGenFunction22EmitCXXConstructorCallEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeEbbNS0_7AddressERNS0_11CallArgListE;_ZN5clang7CodeGen15CodeGenFunction23EmitInitializerForFieldEPNS_9FieldDeclENS0_6LValueEPNS_4ExprEN4llvm8ArrayRefIPNS_7VarDeclEEE;_ZN5clang7CodeGen15CodeGenFunction23InitializeVTablePointerERKNS1_4VPtrE;_ZN5clang7CodeGen15CodeGenFunction24EmitVTableAssumptionLoadERKNS1_4VPtrENS0_7AddressE;_ZN5clang7CodeGen15CodeGenFunction24GetAddressOfDerivedClassENS0_7AddressEPKNS_13CXXRecordDeclEPKPKNS_16CXXBaseSpecifierESA_b;_ZN5clang7CodeGen15CodeGenFunction24InitializeVTablePointersEPKNS_13CXXRecordDeclE;_ZN5clang7CodeGen15CodeGenFunction25EmitLambdaBlockInvokeBodyEv;_ZN5clang7CodeGen15CodeGenFunction25EmitVTableAssumptionLoadsEPKNS_13CXXRecordDeclENS0_7AddressE;_ZN5clang7CodeGen15CodeGenFunction25EmitVTablePtrCheckForCallEPKNS_13CXXRecordDeclEPN4llvm5ValueENS1_16CFITypeCheckKindENS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction25EmitVTablePtrCheckForCastENS_8QualTypeEPN4llvm5ValueEbNS1_16CFITypeCheckKindENS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction25EmitVTableTypeCheckedLoadEPKNS_13CXXRecordDeclEPN4llvm5ValueEy;_ZN5clang7CodeGen15CodeGenFunction26EmitAsanPrologueOrEpilogueEb;_ZN5clang7CodeGen15CodeGenFunction26EmitCXXAggrConstructorCallEPKNS_18CXXConstructorDeclEPKNS_9ArrayTypeENS0_7AddressEPKNS_16CXXConstructExprEb;_ZN5clang7CodeGen15CodeGenFunction26EmitCXXAggrConstructorCallEPKNS_18CXXConstructorDeclEPN4llvm5ValueENS0_7AddressEPKNS_16CXXConstructExprEb;_ZN5clang7CodeGen15CodeGenFunction26EmitForwardingCallToLambdaEPKNS_13CXXMethodDeclERNS0_11CallArgListE;_ZN5clang7CodeGen15CodeGenFunction28EmitLambdaToBlockPointerBodyERNS0_15FunctionArgListE;_ZN5clang7CodeGen15CodeGenFunction28EmitTypeMetadataCodeForVCallEPKNS_13CXXRecordDeclEPN4llvm5ValueENS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction30EmitDelegateCXXConstructorCallEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeERKNS0_15FunctionArgListENS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction30EmitLambdaDelegatingInvokeBodyEPKNS_13CXXMethodDeclE;_ZN5clang7CodeGen15CodeGenFunction30EmitLambdaStaticInvokeFunctionEPKNS_13CXXMethodDeclE;_ZN5clang7CodeGen15CodeGenFunction30EmitSynthesizedCXXCopyCtorCallEPKNS_18CXXConstructorDeclENS0_7AddressES5_PKNS_16CXXConstructExprE;_ZN5clang7CodeGen15CodeGenFunction31EmitCXXMemberDataPointerAddressEPKNS_4ExprENS0_7AddressEPN4llvm5ValueEPKNS_17MemberPointerTypeEPNS0_15AlignmentSourceE;_ZN5clang7CodeGen15CodeGenFunction31EmitInheritedCXXConstructorCallEPKNS_18CXXConstructorDeclEbNS0_7AddressEbPKNS_24CXXInheritedCtorInitExprE;_ZN5clang7CodeGen15CodeGenFunction31ShouldEmitVTableTypeCheckedLoadEPKNS_13CXXRecordDeclE;_ZN5clang7CodeGen15CodeGenFunction32EmitDelegatingCXXConstructorCallEPKNS_18CXXConstructorDeclERKNS0_15FunctionArgListE;_ZN5clang7CodeGen15CodeGenFunction33CanDevirtualizeMemberFunctionCallEPKNS_4ExprEPKNS_13CXXMethodDeclE;_ZN5clang7CodeGen15CodeGenFunction34emitImplicitAssignmentOperatorBodyERNS0_15FunctionArgListE;_ZN5clang7CodeGen15CodeGenFunction37GetAddressOfDirectBaseInCompleteClassENS0_7AddressEPKNS_13CXXRecordDeclES5_b;_ZN5clang7CodeGen15CodeGenFunction39EmitInlinedInheritingCXXConstructorCallEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeEbbRNS0_11CallArgListE; -static-type=CodeGenFunction_CGClass -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGClass extends CodeGenFunction_CGCall {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGClass(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}


/// PushDestructorCleanup - Push a cleanup to call the
/// complete-object destructor of an object of the given type at the
/// given address.  Does nothing if T is not a C++ class type with a
/// non-trivial destructor.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::PushDestructorCleanup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2421,
 FQN="clang::CodeGen::CodeGenFunction::PushDestructorCleanup", NM="_ZN5clang7CodeGen15CodeGenFunction21PushDestructorCleanupENS_8QualTypeENS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21PushDestructorCleanupENS_8QualTypeENS0_7AddressE")
//</editor-fold>
public final void PushDestructorCleanup(QualType T, Address Addr) {
  CXXRecordDecl /*P*/ ClassDecl = T.$arrow().getAsCXXRecordDecl();
  if (!(ClassDecl != null)) {
    return;
  }
  if (ClassDecl.hasTrivialDestructor()) {
    return;
  }
  
  /*const*/ CXXDestructorDecl /*P*/ D = ClassDecl.getDestructor();
  assert ((D != null) && D.isUsed()) : "destructor not marked as used!";
  $this().PushDestructorCleanup(D, new Address(Addr));
}


/// PushDestructorCleanup - Push a cleanup to call the
/// complete-object variant of the given destructor on the object at
/// the given address.
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::PushDestructorCleanup">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2416,
 FQN="clang::CodeGen::CodeGenFunction::PushDestructorCleanup", NM="_ZN5clang7CodeGen15CodeGenFunction21PushDestructorCleanupEPKNS_17CXXDestructorDeclENS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21PushDestructorCleanupEPKNS_17CXXDestructorDeclENS0_7AddressE")
//</editor-fold>
public final void PushDestructorCleanup(/*const*/ CXXDestructorDecl /*P*/ D, 
                     Address Addr) {
  $this().EHStack.<CallLocalDtor>pushCleanup$T(CleanupKind.NormalAndEHCleanup, () -> new CallLocalDtor(D, new Address(Addr)));
}


/// EmitConstructorBody - Emits the body of the current constructor.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitConstructorBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 917,
 FQN="clang::CodeGen::CodeGenFunction::EmitConstructorBody", NM="_ZN5clang7CodeGen15CodeGenFunction19EmitConstructorBodyERNS0_15FunctionArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19EmitConstructorBodyERNS0_15FunctionArgListE")
//</editor-fold>
public final void EmitConstructorBody(final FunctionArgList /*&*/ Args) {
  RunCleanupsScope RunCleanups = null;
  try {
    $this().EmitAsanPrologueOrEpilogue(true);
    /*const*/ CXXConstructorDecl /*P*/ Ctor = cast_CXXConstructorDecl($this().CurGD.getDecl());
    CXXCtorType CtorType = $this().CurGD.getCtorType();
    assert (($this().CGM.getTarget().getCXXABI().hasConstructorVariants() || CtorType == CXXCtorType.Ctor_Complete)) : "can only generate complete ctor for this ABI";
    
    // Before we go any further, try the complete->base constructor
    // delegation optimization.
    if (CtorType == CXXCtorType.Ctor_Complete && IsConstructorDelegationValid(Ctor)
       && $this().CGM.getTarget().getCXXABI().hasConstructorVariants()) {
      $this().EmitDelegateCXXConstructorCall(Ctor, CXXCtorType.Ctor_Base, Args, Ctor.getLocEnd());
      return;
    }
    
    final type$ref</*const*/ FunctionDecl /*P*/ > Definition = create_type$null$ref(null);
    Stmt /*P*/ Body = Ctor.getBody(Definition);
    assert (Definition.$deref() == Ctor) : "emitting wrong constructor body";
    
    // Enter the function-try-block before the constructor prologue if
    // applicable.
    boolean IsTryBody = ((Body != null) && isa_CXXTryStmt(Body));
    if (IsTryBody) {
      $this().EnterCXXTryStmt($Deref(cast_CXXTryStmt(Body)), true);
    }
    
    $this().incrementProfileCounter(Body);
    
    RunCleanups/*J*/= new RunCleanupsScope(/*Deref*/$this());
    
    // TODO: in restricted cases, we can emit the vbase initializers of
    // a complete ctor and then delegate to the base ctor.
    
    // Emit the constructor prologue, i.e. the base and member
    // initializers.
    $this().EmitCtorPrologue(Ctor, CtorType, Args);
    
    // Emit the body of the statement.
    if (IsTryBody) {
      $this().EmitStmt(cast_CXXTryStmt(Body).getTryBlock());
    } else if ((Body != null)) {
      $this().EmitStmt(Body);
    }
    
    // Emit any cleanup blocks associated with the member or base
    // initializers, which includes (along the exceptional path) the
    // destructors for those members and bases that were fully
    // constructed.
    RunCleanups.ForceCleanup();
    if (IsTryBody) {
      $this().ExitCXXTryStmt($Deref(cast_CXXTryStmt(Body)), true);
    }
  } finally {
    if (RunCleanups != null) { RunCleanups.$destroy(); }
  }
}


/// EmitDestructorBody - Emits the body of the current destructor.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitDestructorBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1502,
 FQN="clang::CodeGen::CodeGenFunction::EmitDestructorBody", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitDestructorBodyERNS0_15FunctionArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitDestructorBodyERNS0_15FunctionArgListE")
//</editor-fold>
public final void EmitDestructorBody(final FunctionArgList /*&*/ Args) {
  RunCleanupsScope DtorEpilogue = null;
  try {
    /*const*/ CXXDestructorDecl /*P*/ Dtor = cast_CXXDestructorDecl($this().CurGD.getDecl());
    CXXDtorType DtorType = $this().CurGD.getDtorType();
    
    Stmt /*P*/ Body = Dtor.getBody();
    if ((Body != null)) {
      $this().incrementProfileCounter(Body);
    }
    
    // The call to operator delete in a deleting destructor happens
    // outside of the function-try-block, which means it's always
    // possible to delegate the destructor body to the complete
    // destructor.  Do so.
    if (DtorType == CXXDtorType.Dtor_Deleting) {
      $this().EnterDtorCleanups(Dtor, CXXDtorType.Dtor_Deleting);
      $this().EmitCXXDestructorCall(Dtor, CXXDtorType.Dtor_Complete, /*ForVirtualBase=*/ false, 
          /*Delegating=*/ false, $this().LoadCXXThisAddress());
      $this().PopCleanupBlock();
      return;
    }
    
    // If the body is a function-try-block, enter the try before
    // anything else.
    boolean isTryBody = ((Body != null) && isa_CXXTryStmt(Body));
    if (isTryBody) {
      $this().EnterCXXTryStmt($Deref(cast_CXXTryStmt(Body)), true);
    }
    $this().EmitAsanPrologueOrEpilogue(false);
    
    // Enter the epilogue cleanups.
    DtorEpilogue/*J*/= new RunCleanupsScope(/*Deref*/$this());
    
    // If this is the complete variant, just invoke the base variant;
    // the epilogue will destruct the virtual bases.  But we can't do
    // this optimization if the body is a function-try-block, because
    // we'd introduce *two* handler blocks.  In the Microsoft ABI, we
    // always delegate because we might not have a definition in this TU.
    switch (DtorType) {
     case Dtor_Comdat:
      throw new llvm_unreachable("not expecting a COMDAT");
     case Dtor_Deleting:
      throw new llvm_unreachable("already handled deleting case");
     case Dtor_Complete:
      assert (((Body != null) || $this().getTarget().getCXXABI().isMicrosoft())) : "can't emit a dtor without a body for non-Microsoft ABIs";
      
      // Enter the cleanup scopes for virtual bases.
      $this().EnterDtorCleanups(Dtor, CXXDtorType.Dtor_Complete);
      if (!isTryBody) {
        $this().EmitCXXDestructorCall(Dtor, CXXDtorType.Dtor_Base, /*ForVirtualBase=*/ false, 
            /*Delegating=*/ false, $this().LoadCXXThisAddress());
        break;
      }
     case Dtor_Base:
      // Fallthrough: act like we're in the base variant.
      assert Native.$bool(Body);
      
      // Enter the cleanup scopes for fields and non-virtual bases.
      $this().EnterDtorCleanups(Dtor, CXXDtorType.Dtor_Base);
      
      // Initialize the vtable pointers before entering the body.
      if (!CGClassStatics.CanSkipVTablePointerInitialization(/*Deref*/$this(), Dtor)) {
        // Insert the llvm.invariant.group.barrier intrinsic before initializing
        // the vptrs to cancel any previous assumptions we might have made.
        if ($this().CGM.getCodeGenOpts().StrictVTablePointers
           && $2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) > 0) {
          $this().CXXThisValue = $this().Builder.CreateInvariantGroupBarrier($this().LoadCXXThis());
        }
        $this().InitializeVTablePointers(Dtor.getParent$Const());
      }
      if (isTryBody) {
        $this().EmitStmt(cast_CXXTryStmt(Body).getTryBlock());
      } else if ((Body != null)) {
        $this().EmitStmt(Body);
      } else {
        assert (Dtor.isImplicit()) : "bodyless dtor not implicit";
        // nothing to do besides what's in the epilogue
      }
      // -fapple-kext must inline any call to this dtor into
      // the caller's body.
      if ($this().getLangOpts().AppleKext) {
        $this().CurFn.addFnAttr(Attribute.AttrKind.AlwaysInline);
      }
      
      break;
    }
    
    // Jump out through the epilogue cleanups.
    DtorEpilogue.ForceCleanup();
    
    // Exit the try if applicable.
    if (isTryBody) {
      $this().ExitCXXTryStmt($Deref(cast_CXXTryStmt(Body)), true);
    }
  } finally {
    if (DtorEpilogue != null) { DtorEpilogue.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::emitImplicitAssignmentOperatorBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1597,
 FQN="clang::CodeGen::CodeGenFunction::emitImplicitAssignmentOperatorBody", NM="_ZN5clang7CodeGen15CodeGenFunction34emitImplicitAssignmentOperatorBodyERNS0_15FunctionArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction34emitImplicitAssignmentOperatorBodyERNS0_15FunctionArgListE")
//</editor-fold>
public final void emitImplicitAssignmentOperatorBody(final FunctionArgList /*&*/ Args) {
  LexicalScope Scope = null;
  AssignmentMemcpyizer AM = null;
  try {
    /*const*/ CXXMethodDecl /*P*/ AssignOp = cast_CXXMethodDecl($this().CurGD.getDecl());
    /*const*/ Stmt /*P*/ RootS = AssignOp.getBody();
    assert (isa_CompoundStmt(RootS)) : "Body of an implicit assignment operator should be compound stmt.";
    /*const*/ CompoundStmt /*P*/ RootCS = cast_CompoundStmt(RootS);
    
    Scope/*J*/= new LexicalScope(/*Deref*/$this(), RootCS.getSourceRange());
    
    $this().incrementProfileCounter(RootCS);
    AM/*J*/= new AssignmentMemcpyizer(/*Deref*/$this(), AssignOp, Args);
    for (Stmt /*P*/ I : RootCS.body$Const())  {
      AM.emitAssignment(I);
    }
    AM.finish();
  } finally {
    if (AM != null) { AM.$destroy(); }
    if (Scope != null) { Scope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitForwardingCallToLambda">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2898,
 FQN="clang::CodeGen::CodeGenFunction::EmitForwardingCallToLambda", NM="_ZN5clang7CodeGen15CodeGenFunction26EmitForwardingCallToLambdaEPKNS_13CXXMethodDeclERNS0_11CallArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26EmitForwardingCallToLambdaEPKNS_13CXXMethodDeclERNS0_11CallArgListE")
//</editor-fold>
public final void EmitForwardingCallToLambda(/*const*/ CXXMethodDecl /*P*/ callOperator, 
                          final CallArgList /*&*/ callArgs) {
  // Get the address of the call operator.
  final /*const*/ CGFunctionInfo /*&*/ calleeFnInfo = $this().CGM.getTypes().arrangeCXXMethodDeclaration(callOperator);
  Value /*P*/ callee = $this().CGM.GetAddrOfFunction(new GlobalDecl(callOperator), 
      $this().CGM.getTypes().GetFunctionType(calleeFnInfo));
  
  // Prepare the return slot.
  /*const*/ FunctionProtoType /*P*/ FPT = callOperator.getType().$arrow().castAs(FunctionProtoType.class);
  QualType resultType = FPT.getReturnType();
  ReturnValueSlot returnSlot/*J*/= new ReturnValueSlot();
  if (!resultType.$arrow().isVoidType()
     && calleeFnInfo.getReturnInfo$Const().getKind() == ABIArgInfo.Kind.Indirect
     && !CodeGenFunction.hasScalarEvaluationKind(calleeFnInfo.getReturnType().$QualType())) {
    returnSlot.$assignMove(new ReturnValueSlot(new Address($this().ReturnValue), resultType.isVolatileQualified()));
  }
  
  // We don't need to separately arrange the call arguments because
  // the call can't be variadic anyway --- it's impossible to forward
  // variadic arguments.
  
  // Now emit our call.
  RValue RV = $this().EmitCall(calleeFnInfo, callee, new ReturnValueSlot(returnSlot), 
      callArgs, new CGCalleeInfo(callOperator));
  
  // If necessary, copy the returned value into the slot.
  if (!resultType.$arrow().isVoidType() && returnSlot.isNull()) {
    $this().EmitReturnOfRValue(new RValue(RV), new QualType(resultType));
  } else {
    $this().EmitBranchThroughCleanup(new JumpDest($this().ReturnBlock));
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLambdaToBlockPointerBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2954,
 FQN="clang::CodeGen::CodeGenFunction::EmitLambdaToBlockPointerBody", NM="_ZN5clang7CodeGen15CodeGenFunction28EmitLambdaToBlockPointerBodyERNS0_15FunctionArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28EmitLambdaToBlockPointerBodyERNS0_15FunctionArgListE")
//</editor-fold>
public final void EmitLambdaToBlockPointerBody(final FunctionArgList /*&*/ Args) {
  if (cast_CXXMethodDecl($this().CurCodeDecl).isVariadic()) {
    // FIXME: Making this work correctly is nasty because it requires either
    // cloning the body of the call operator or making the call operator forward.
    $this().CGM.ErrorUnsupported($this().CurCodeDecl, $("lambda conversion to variadic function"));
    return;
  }
  
  $this().EmitFunctionBody(Args, cast_FunctionDecl($this().CurGD.getDecl()).getBody());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLambdaBlockInvokeBody">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2933,
 FQN="clang::CodeGen::CodeGenFunction::EmitLambdaBlockInvokeBody", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitLambdaBlockInvokeBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitLambdaBlockInvokeBodyEv")
//</editor-fold>
public final void EmitLambdaBlockInvokeBody() {
  CallArgList CallArgs = null;
  try {
    /*const*/ BlockDecl /*P*/ BD = $this().BlockInfo.getBlockDecl();
    /*const*/ VarDecl /*P*/ variable = BD.capture_begin().$star().getVariable();
    /*const*/ CXXRecordDecl /*P*/ Lambda = variable.getType().$arrow().getAsCXXRecordDecl();
    
    // Start building arguments for forwarding call
    CallArgs/*J*/= new CallArgList();
    
    QualType ThisType = $this().getContext().getPointerType($this().getContext().getRecordType(Lambda));
    Address ThisPtr = $this().GetAddrOfBlockDecl(variable, false);
    CallArgs.add(RValue.get(ThisPtr.getPointer()), new QualType(ThisType));
    
    // Add the rest of the parameters.
    for (ParmVarDecl /*P*/ param : BD.parameters$Const())  {
      $this().EmitDelegateCallArg(CallArgs, param, param.getLocStart());
    }
    assert (!Lambda.isGenericLambda()) : "generic lambda interconversion to block not implemented";
    $this().EmitForwardingCallToLambda(Lambda.getLambdaCallOperator(), CallArgs);
  } finally {
    if (CallArgs != null) { CallArgs.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLambdaDelegatingInvokeBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2965,
 FQN="clang::CodeGen::CodeGenFunction::EmitLambdaDelegatingInvokeBody", NM="_ZN5clang7CodeGen15CodeGenFunction30EmitLambdaDelegatingInvokeBodyEPKNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction30EmitLambdaDelegatingInvokeBodyEPKNS_13CXXMethodDeclE")
//</editor-fold>
public final void EmitLambdaDelegatingInvokeBody(/*const*/ CXXMethodDecl /*P*/ MD) {
  CallArgList CallArgs = null;
  try {
    /*const*/ CXXRecordDecl /*P*/ Lambda = MD.getParent$Const();
    
    // Start building arguments for forwarding call
    CallArgs/*J*/= new CallArgList();
    
    QualType ThisType = $this().getContext().getPointerType($this().getContext().getRecordType(Lambda));
    Value /*P*/ ThisPtr = UndefValue.get($this().getTypes().ConvertType(new QualType(ThisType)));
    CallArgs.add(RValue.get(ThisPtr), new QualType(ThisType));
    
    // Add the rest of the parameters.
    for (ParmVarDecl /*P*/ Param : MD.parameters$Const())  {
      $this().EmitDelegateCallArg(CallArgs, Param, Param.getLocStart());
    }
    
    /*const*/ CXXMethodDecl /*P*/ CallOp = Lambda.getLambdaCallOperator();
    // For a generic lambda, find the corresponding call operator specialization
    // to which the call to the static-invoker shall be forwarded.
    if (Lambda.isGenericLambda()) {
      assert (MD.isFunctionTemplateSpecialization());
      /*const*/ TemplateArgumentList /*P*/ TAL = MD.getTemplateSpecializationArgs();
      FunctionTemplateDecl /*P*/ CallOpTemplate = CallOp.getDescribedFunctionTemplate();
      final type$ref<type$ptr<FunctionTemplateSpecializationInfo /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
      FunctionDecl /*P*/ CorrespondingCallOpSpecialization = CallOpTemplate.findSpecialization(TAL.asArray(), InsertPos);
      assert Native.$bool(CorrespondingCallOpSpecialization);
      CallOp = cast_CXXMethodDecl(CorrespondingCallOpSpecialization);
    }
    $this().EmitForwardingCallToLambda(CallOp, CallArgs);
  } finally {
    if (CallArgs != null) { CallArgs.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLambdaStaticInvokeFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2995,
 FQN="clang::CodeGen::CodeGenFunction::EmitLambdaStaticInvokeFunction", NM="_ZN5clang7CodeGen15CodeGenFunction30EmitLambdaStaticInvokeFunctionEPKNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction30EmitLambdaStaticInvokeFunctionEPKNS_13CXXMethodDeclE")
//</editor-fold>
public final void EmitLambdaStaticInvokeFunction(/*const*/ CXXMethodDecl /*P*/ MD) {
  if (MD.isVariadic()) {
    // FIXME: Making this work correctly is nasty because it requires either
    // cloning the body of the call operator or making the call operator forward.
    $this().CGM.ErrorUnsupported(MD, $("lambda conversion to variadic function"));
    return;
  }
  
  $this().EmitLambdaDelegatingInvokeBody(MD);
}


// Emit code in ctor (Prologue==true) or dtor (Prologue==false)
// to poison the extra field paddings inserted under
// -fsanitize-address-field-padding=1|2.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAsanPrologueOrEpilogue">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 854,
 FQN="clang::CodeGen::CodeGenFunction::EmitAsanPrologueOrEpilogue", NM="_ZN5clang7CodeGen15CodeGenFunction26EmitAsanPrologueOrEpilogueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26EmitAsanPrologueOrEpilogueEb")
//</editor-fold>
public final void EmitAsanPrologueOrEpilogue(boolean Prologue) {
  final ASTContext /*&*/ Context = $this().getContext();
  /*const*/ CXXRecordDecl /*P*/ ClassDecl = Prologue ? cast_CXXConstructorDecl($this().CurGD.getDecl()).getParent$Const() : cast_CXXDestructorDecl($this().CurGD.getDecl()).getParent$Const();
  if (!ClassDecl.mayInsertExtraPadding()) {
    return;
  }
  
  //<editor-fold defaultstate="collapsed" desc="SizeAndOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 861,
   FQN="SizeAndOffset", NM="_ZZN5clang7CodeGen15CodeGenFunction26EmitAsanPrologueOrEpilogueEbE13SizeAndOffset",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZZN5clang7CodeGen15CodeGenFunction26EmitAsanPrologueOrEpilogueEbE13SizeAndOffset")
  //</editor-fold>
   class/*struct*/ SizeAndOffset {
    public long/*uint64_t*/ Size;
    public long/*uint64_t*/ Offset;
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAsanPrologueOrEpilogue(bool)::SizeAndOffset::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 861,
     FQN="clang::CodeGen::CodeGenFunction::EmitAsanPrologueOrEpilogue(bool)::SizeAndOffset::operator=", NM="_ZZN5clang7CodeGen15CodeGenFunction26EmitAsanPrologueOrEpilogueEbEN13SizeAndOffsetaSERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZZN5clang7CodeGen15CodeGenFunction26EmitAsanPrologueOrEpilogueEbEN13SizeAndOffsetaSERKS2_")
    //</editor-fold>
    public final /*inline*/ SizeAndOffset /*&*/ $assign(final /*const*/ SizeAndOffset /*&*/ $Prm0) {
      this.Size = $Prm0.Size;
      this.Offset = $Prm0.Offset;
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "Size=" + Size // NOI18N
                + ", Offset=" + Offset; // NOI18N
    }
  };
  
  /*uint*/int PtrSize = $this().CGM.getDataLayout().getPointerSizeInBits();
  final /*const*/ ASTRecordLayout /*&*/ Info = Context.getASTRecordLayout(ClassDecl);
  
  // Populate sizes and offsets of fields.
  SmallVector<SizeAndOffset> SSV/*J*/= new SmallVector<SizeAndOffset>(JD$UInt_T$C$R.INSTANCE, 16, Info.getFieldCount(), new SizeAndOffset());
  for (/*uint*/int i = 0, e = Info.getFieldCount(); i != e; ++i)  {
    SSV.$at(i).Offset
       = Context.toCharUnitsFromBits(Info.getFieldOffset(i)).getQuantity();
  }
  
  /*size_t*/int NumFields = 0;
  for (/*const*/ FieldDecl /*P*/ Field : ClassDecl.fields()) {
    /*const*/ FieldDecl /*P*/ D = Field;
    std.pair<CharUnits, CharUnits> FieldInfo = Context.getTypeInfoInChars(D.getType());
    CharUnits FieldSize = new CharUnits(FieldInfo.first);
    assert ($less_uint(NumFields, SSV.size()));
    SSV.$at(NumFields).Size = D.isBitField() ? 0 : FieldSize.getQuantity();
    NumFields++;
  }
  assert (NumFields == SSV.size());
  if ($lesseq_uint(SSV.size(), 1)) {
    return;
  }
  
  // We will insert calls to __asan_* run-time functions.
  // LLVM AddressSanitizer pass may decide to inline them later.
  org.llvm.ir.Type /*P*/ Args[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {Unnamed_field8.IntPtrTy, Unnamed_field8.IntPtrTy};
  org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get($this().CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(Args, true), false);
  Constant /*P*/ F = $this().CGM.CreateRuntimeFunction(FTy, new StringRef(Prologue ? $("__asan_poison_intra_object_redzone") : $("__asan_unpoison_intra_object_redzone")));
  
  Value /*P*/ ThisPtr = $this().LoadCXXThis();
  ThisPtr = $this().Builder.CreatePtrToInt(ThisPtr, Unnamed_field8.IntPtrTy);
  long/*uint64_t*/ TypeSize = Info.getNonVirtualSize().getQuantity();
  // For each field check if it has sufficient padding,
  // if so (un)poison it with a call.
  for (/*size_t*/int i = 0; $less_uint(i, SSV.size()); i++) {
    long/*uint64_t*/ AsanAlignment = $int2ulong(8);
    long/*uint64_t*/ NextField = i == SSV.size() - 1 ? TypeSize : SSV.$at(i + 1).Offset;
    long/*uint64_t*/ PoisonSize = NextField - SSV.$at(i).Offset - SSV.$at(i).Size;
    long/*uint64_t*/ EndOffset = SSV.$at(i).Offset + SSV.$at(i).Size;
    if ($less_ulong(PoisonSize, AsanAlignment) || !(SSV.$at(i).Size != 0)
       || ($rem_ulong(NextField, AsanAlignment)) != $int2ullong(0)) {
      continue;
    }
    $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {
              $this().Builder.CreateAdd(ThisPtr, $this().Builder.getIntN(PtrSize, EndOffset)), 
              $this().Builder.getIntN(PtrSize, PoisonSize)}, true)/* }*/);
  }
}


/// EmitCtorPrologue - This routine generates necessary code to initialize
/// base classes and non-static data members belonging to this constructor.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCtorPrologue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1352,
 FQN="clang::CodeGen::CodeGenFunction::EmitCtorPrologue", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitCtorPrologueEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeERNS0_15FunctionArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitCtorPrologueEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeERNS0_15FunctionArgListE")
//</editor-fold>
public final void EmitCtorPrologue(/*const*/ CXXConstructorDecl /*P*/ CD, 
                CXXCtorType CtorType, 
                final FunctionArgList /*&*/ Args) {
  FieldConstructionScope FCS = null;
  ConstructorMemcpyizer CM = null;
  try {
    if (CD.isDelegatingConstructor()) {
      $this().EmitDelegatingCXXConstructorCall(CD, Args);
      /*JAVA:return*/return;
    }
    
    /*const*/ CXXRecordDecl /*P*/ ClassDecl = CD.getParent$Const();
    
    type$ptr<CXXCtorInitializer/*P*/> B = $tryClone(CD.init_begin$Const());
    type$ptr<CXXCtorInitializer/*P*/> E = $tryClone(CD.init_end$Const());
    
    BasicBlock /*P*/ BaseCtorContinueBB = null;
    if ((ClassDecl.getNumVBases() != 0)
       && !$this().CGM.getTarget().getCXXABI().hasConstructorVariants()) {
      // The ABIs that don't have constructor variants need to put a branch
      // before the virtual base initialization code.
      BaseCtorContinueBB
         = $this().CGM.getCXXABI().EmitCtorCompleteObjectHandler(/*Deref*/$this(), ClassDecl);
      assert Native.$bool(BaseCtorContinueBB);
    }
    
    Value /*P*/ /*const*/ OldThis = $this().CXXThisValue;
    // Virtual base initializers first.
    for (; $noteq_ptr(B, E) && (B.$star()).isBaseInitializer() && (B.$star()).isBaseVirtual(); B.$postInc()) {
      if ($this().CGM.getCodeGenOpts().StrictVTablePointers
         && $2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) > 0
         && CGClassStatics.isInitializerOfDynamicClass(B.$star())) {
        $this().CXXThisValue = $this().Builder.CreateInvariantGroupBarrier($this().LoadCXXThis());
      }
      CGClassStatics.EmitBaseInitializer(/*Deref*/$this(), ClassDecl, B.$star(), CtorType);
    }
    if ((BaseCtorContinueBB != null)) {
      // Complete object handler should continue to the remaining initializers.
      $this().Builder.CreateBr(BaseCtorContinueBB);
      $this().EmitBlock(BaseCtorContinueBB);
    }
    
    // Then, non-virtual base initializers.
    for (; $noteq_ptr(B, E) && (B.$star()).isBaseInitializer(); B.$postInc()) {
      assert (!(B.$star()).isBaseVirtual());
      if ($this().CGM.getCodeGenOpts().StrictVTablePointers
         && $2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) > 0
         && CGClassStatics.isInitializerOfDynamicClass(B.$star())) {
        $this().CXXThisValue = $this().Builder.CreateInvariantGroupBarrier($this().LoadCXXThis());
      }
      CGClassStatics.EmitBaseInitializer(/*Deref*/$this(), ClassDecl, B.$star(), CtorType);
    }
    
    $this().CXXThisValue = OldThis;
    
    $this().InitializeVTablePointers(ClassDecl);
    
    // And finally, initialize class members.
    FCS/*J*/= new FieldConstructionScope(/*Deref*/$this(), $this().LoadCXXThisAddress());
    CM/*J*/= new ConstructorMemcpyizer(/*Deref*/$this(), CD, Args);
    for (; $noteq_ptr(B, E); B.$postInc()) {
      CXXCtorInitializer /*P*/ Member = (B.$star());
      assert (!Member.isBaseInitializer());
      assert (Member.isAnyMemberInitializer()) : "Delegating initializer on non-delegating constructor";
      CM.addMemberInitializer(Member);
    }
    CM.finish();
  } finally {
    if (CM != null) { CM.$destroy(); }
    if (FCS != null) { FCS.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitInitializerForField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 753,
 FQN="clang::CodeGen::CodeGenFunction::EmitInitializerForField", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitInitializerForFieldEPNS_9FieldDeclENS0_6LValueEPNS_4ExprEN4llvm8ArrayRefIPNS_7VarDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitInitializerForFieldEPNS_9FieldDeclENS0_6LValueEPNS_4ExprEN4llvm8ArrayRefIPNS_7VarDeclEEE")
//</editor-fold>
public final void EmitInitializerForField(FieldDecl /*P*/ Field, LValue LHS, 
                       Expr /*P*/ Init, ArrayRef<VarDecl /*P*/ > ArrayIndexes) {
  QualType FieldType = Field.getType();
  switch (CodeGenFunction.getEvaluationKind(new QualType(FieldType))) {
   case TEK_Scalar:
    if (LHS.isSimple()) {
      $this().EmitExprAsInit(Init, Field, new LValue(LHS), false);
    } else {
      RValue RHS = RValue.get($this().EmitScalarExpr(Init));
      $this().EmitStoreThroughLValue(new RValue(RHS), new LValue(LHS));
    }
    break;
   case TEK_Complex:
    $this().EmitComplexExprIntoLValue(Init, new LValue(LHS), /*isInit*/ true);
    break;
   case TEK_Aggregate:
    {
      Address ArrayIndexVar = Address.invalid();
      if ((ArrayIndexes.size() != 0)) {
        // The LHS is a pointer to the first object we'll be constructing, as
        // a flat array.
        QualType BaseElementTy = $this().getContext().getBaseElementType(new QualType(FieldType));
        org.llvm.ir.Type /*P*/ BasePtr = $this().ConvertType(new QualType(BaseElementTy));
        BasePtr = org.llvm.ir.PointerType.getUnqual(BasePtr);
        Address BaseAddrPtr = $this().Builder.CreateBitCast(LHS.getAddress(), BasePtr);
        LHS.$assignMove($this().MakeAddrLValue(new Address(BaseAddrPtr), new QualType(BaseElementTy)));
        
        // Create an array index that will be used to walk over all of the
        // objects we're constructing.
        ArrayIndexVar.$assignMove($this().CreateMemTemp($this().getContext().getSizeType().$QualType(), new Twine(/*KEEP_STR*/"object.index")));
        Value /*P*/ Zero = Constant.getNullValue(ArrayIndexVar.getElementType());
        $this().Builder.CreateStore(Zero, new Address(ArrayIndexVar));
        
        // Emit the block variables for the array indices, if any.
        for (/*uint*/int I = 0, N = ArrayIndexes.size(); I != N; ++I)  {
          $this().EmitAutoVarDecl($Deref(ArrayIndexes.$at(I)));
        }
      }
      
      CGClassStatics.EmitAggMemberInitializer(/*Deref*/$this(), new LValue(LHS), Init, new Address(ArrayIndexVar), new QualType(FieldType), 
          new ArrayRef<VarDecl /*P*/ >(ArrayIndexes), 0);
    }
  }
  
  // Ensure that we destroy this object if an exception is thrown
  // later in the constructor.
  QualType.DestructionKind dtorKind = FieldType.isDestructedType();
  if ($this().needsEHCleanup(dtorKind)) {
    $this().pushEHDestroy(dtorKind, LHS.getAddress(), new QualType(FieldType));
  }
}


/// Initialize the vtable pointer of the given subobject.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::InitializeVTablePointer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2431,
 FQN="clang::CodeGen::CodeGenFunction::InitializeVTablePointer", NM="_ZN5clang7CodeGen15CodeGenFunction23InitializeVTablePointerERKNS1_4VPtrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23InitializeVTablePointerERKNS1_4VPtrE")
//</editor-fold>
public final void InitializeVTablePointer(final /*const*/ VPtr /*&*/ Vptr) {
  // Compute the address point.
  Value /*P*/ VTableAddressPoint = $this().CGM.getCXXABI().getVTableAddressPointInStructor(/*Deref*/$this(), Vptr.VTableClass, new BaseSubobject(Vptr.Base), Vptr.NearestVBase);
  if (!(VTableAddressPoint != null)) {
    return;
  }
  
  // Compute where to store the address point.
  Value /*P*/ VirtualOffset = null;
  CharUnits NonVirtualOffset = CharUnits.Zero();
  if ($this().CGM.getCXXABI().isVirtualOffsetNeededForVTableField(/*Deref*/$this(), new CodeGenFunction.VPtr(Vptr))) {
    // We need to use the virtual base offset offset because the virtual base
    // might have a different offset in the most derived class.
    VirtualOffset = $this().CGM.getCXXABI().GetVirtualBaseClassOffset(/*Deref*/$this(), $this().LoadCXXThisAddress(), Vptr.VTableClass, Vptr.NearestVBase);
    NonVirtualOffset.$assign(Vptr.OffsetFromNearestVBase);
  } else {
    // We can just use the base offset in the complete class.
    NonVirtualOffset.$assignMove(Vptr.Base.getBaseOffset());
  }
  
  // Apply the offsets.
  Address VTableField = $this().LoadCXXThisAddress();
  if (!NonVirtualOffset.isZero() || (VirtualOffset != null)) {
    VTableField.$assignMove(CGClassStatics.ApplyNonVirtualAndVirtualOffset(/*Deref*/$this(), new Address(VTableField), new CharUnits(NonVirtualOffset), VirtualOffset, Vptr.VTableClass, 
            Vptr.NearestVBase));
  }
  
  // Finally, store the address point. Use the same LLVM types as the field to
  // support optimization.
  org.llvm.ir.Type /*P*/ VTablePtrTy = org.llvm.ir.FunctionType.get($this().CGM.Int32Ty, /*isVarArg=*/ true).
      getPointerTo().
      getPointerTo();
  VTableField.$assignMove($this().Builder.CreateBitCast(new Address(VTableField), VTablePtrTy.getPointerTo()));
  VTableAddressPoint = $this().Builder.CreateBitCast(VTableAddressPoint, VTablePtrTy);
  
  StoreInst /*P*/ Store = $this().Builder.CreateStore(VTableAddressPoint, new Address(VTableField));
  $this().CGM.DecorateInstructionWithTBAA(Store, $this().CGM.getTBAAInfoForVTablePtr());
  if ($2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) > 0
     && $this().CGM.getCodeGenOpts().StrictVTablePointers) {
    $this().CGM.DecorateInstructionWithInvariantGroup(Store, Vptr.VTableClass);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getVTablePointers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2480,
 FQN="clang::CodeGen::CodeGenFunction::getVTablePointers", NM="_ZN5clang7CodeGen15CodeGenFunction17getVTablePointersEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17getVTablePointersEPKNS_13CXXRecordDeclE")
//</editor-fold>
public final SmallVector<VPtr> getVTablePointers(/*const*/ CXXRecordDecl /*P*/ VTableClass) {
  SmallVector<VPtr> VPtrsResult/*J*/= new SmallVector<VPtr>(4, new VPtr());
  SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > VBases/*J*/= new SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
  $this().getVTablePointers(new BaseSubobject(VTableClass, CharUnits.Zero()), 
      /*NearestVBase=*/ (/*const*/ CXXRecordDecl /*P*/ )null, 
      /*OffsetFromNearestVBase=*/ CharUnits.Zero(), 
      /*BaseIsNonVirtualPrimaryBase=*/ false, VTableClass, VBases, 
      VPtrsResult);
  return VPtrsResult;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getVTablePointers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2492,
 FQN="clang::CodeGen::CodeGenFunction::getVTablePointers", NM="_ZN5clang7CodeGen15CodeGenFunction17getVTablePointersENS_13BaseSubobjectEPKNS_13CXXRecordDeclENS_9CharUnitsEbS5_RN4llvm11SmallPtrSetIS5_Lj4EEERNS7_11SmallVectorINS1_4VPtrELj4EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17getVTablePointersENS_13BaseSubobjectEPKNS_13CXXRecordDeclENS_9CharUnitsEbS5_RN4llvm11SmallPtrSetIS5_Lj4EEERNS7_11SmallVectorINS1_4VPtrELj4EEE")
//</editor-fold>
public final void getVTablePointers(BaseSubobject Base, 
                 /*const*/ CXXRecordDecl /*P*/ NearestVBase, 
                 CharUnits OffsetFromNearestVBase, 
                 boolean BaseIsNonVirtualPrimaryBase, 
                 /*const*/ CXXRecordDecl /*P*/ VTableClass, 
                 final SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > /*&*/ VBases, 
                 final SmallVector<VPtr> /*&*/ Vptrs) {
  // If this base is a non-virtual primary base the address point has already
  // been set.
  if (!BaseIsNonVirtualPrimaryBase) {
    // Initialize the vtable pointer for this base.
    VPtr Vptr = new VPtr(Base, NearestVBase, OffsetFromNearestVBase, VTableClass);
    Vptrs.push_back(Vptr);
  }
  
  /*const*/ CXXRecordDecl /*P*/ RD = Base.getBase();
  
  // Traverse bases.
  for (final /*const*/ CXXBaseSpecifier /*&*/ I : RD.bases$Const()) {
    CXXRecordDecl /*P*/ BaseDecl = cast_CXXRecordDecl(I.getType().$arrow().getAs$RecordType().getDecl());
    
    // Ignore classes without a vtable.
    if (!BaseDecl.isDynamicClass()) {
      continue;
    }
    
    CharUnits BaseOffset/*J*/= new CharUnits();
    CharUnits BaseOffsetFromNearestVBase/*J*/= new CharUnits();
    boolean BaseDeclIsNonVirtualPrimaryBase;
    if (I.isVirtual()) {
      // Check if we've visited this virtual base before.
      if (!VBases.insert(BaseDecl).second) {
        continue;
      }
      
      final /*const*/ ASTRecordLayout /*&*/ Layout = $this().getContext().getASTRecordLayout(VTableClass);
      
      BaseOffset.$assignMove(Layout.getVBaseClassOffset(BaseDecl));
      BaseOffsetFromNearestVBase.$assignMove(CharUnits.Zero());
      BaseDeclIsNonVirtualPrimaryBase = false;
    } else {
      final /*const*/ ASTRecordLayout /*&*/ Layout = $this().getContext().getASTRecordLayout(RD);
      
      BaseOffset.$assignMove(Base.getBaseOffset().$add(Layout.getBaseClassOffset(BaseDecl)));
      BaseOffsetFromNearestVBase.$assignMove(
          OffsetFromNearestVBase.$add(Layout.getBaseClassOffset(BaseDecl))
      );
      BaseDeclIsNonVirtualPrimaryBase = Layout.getPrimaryBase() == BaseDecl;
    }
    
    $this().getVTablePointers(new BaseSubobject(BaseDecl, new CharUnits(BaseOffset)), 
        I.isVirtual() ? BaseDecl : NearestVBase, new CharUnits(BaseOffsetFromNearestVBase), 
        BaseDeclIsNonVirtualPrimaryBase, VTableClass, VBases, Vptrs);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::InitializeVTablePointers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2549,
 FQN="clang::CodeGen::CodeGenFunction::InitializeVTablePointers", NM="_ZN5clang7CodeGen15CodeGenFunction24InitializeVTablePointersEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24InitializeVTablePointersEPKNS_13CXXRecordDeclE")
//</editor-fold>
public final void InitializeVTablePointers(/*const*/ CXXRecordDecl /*P*/ RD) {
  // Ignore classes without a vtable.
  if (!RD.isDynamicClass()) {
    return;
  }
  
  // Initialize the vtable pointers for this class and all of its bases.
  if ($this().CGM.getCXXABI().doStructorsInitializeVPtrs(RD)) {
    for (final /*const*/ VPtr /*&*/ Vptr : $this().getVTablePointers(RD))  {
      $this().InitializeVTablePointer(Vptr);
    }
  }
  if ((RD.getNumVBases() != 0)) {
    $this().CGM.getCXXABI().initializeHiddenVirtualInheritanceMembers(/*Deref*/$this(), RD);
  }
}


/// GetVTablePtr - Return the Value of the vtable pointer member pointed
/// to by This.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GetVTablePtr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2563,
 FQN="clang::CodeGen::CodeGenFunction::GetVTablePtr", NM="_ZN5clang7CodeGen15CodeGenFunction12GetVTablePtrENS0_7AddressEPN4llvm4TypeEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12GetVTablePtrENS0_7AddressEPN4llvm4TypeEPKNS_13CXXRecordDeclE")
//</editor-fold>
public final Value /*P*/ GetVTablePtr(Address This, 
            org.llvm.ir.Type /*P*/ VTableTy, 
            /*const*/ CXXRecordDecl /*P*/ RD) {
  Address VTablePtrSrc = $this().Builder.CreateElementBitCast(new Address(This), VTableTy);
  Instruction /*P*/ VTable = $this().Builder.CreateLoad(new Address(VTablePtrSrc), $("vtable"));
  $this().CGM.DecorateInstructionWithTBAA(VTable, $this().CGM.getTBAAInfoForVTablePtr());
  if ($2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) > 0
     && $this().CGM.getCodeGenOpts().StrictVTablePointers) {
    $this().CGM.DecorateInstructionWithInvariantGroup(VTable, RD);
  }
  
  return VTable;
}


/// \brief Derived is the presumed address of an object of type T after a
/// cast. If T is a polymorphic class type, emit a check that the virtual
/// table for Derived belongs to a class derived from T.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitVTablePtrCheckForCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2643,
 FQN="clang::CodeGen::CodeGenFunction::EmitVTablePtrCheckForCast", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitVTablePtrCheckForCastENS_8QualTypeEPN4llvm5ValueEbNS1_16CFITypeCheckKindENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitVTablePtrCheckForCastENS_8QualTypeEPN4llvm5ValueEbNS1_16CFITypeCheckKindENS_14SourceLocationE")
//</editor-fold>
public final void EmitVTablePtrCheckForCast(QualType T, 
                         Value /*P*/ Derived, 
                         boolean MayBeNull, 
                         CFITypeCheckKind TCK, 
                         SourceLocation Loc) {
  if (!$this().getLangOpts().CPlusPlus) {
    return;
  }
  
  /*const*/ RecordType /*P*/ ClassTy = T.$arrow().getAs$RecordType();
  if (!(ClassTy != null)) {
    return;
  }
  
  /*const*/ CXXRecordDecl /*P*/ ClassDecl = cast_CXXRecordDecl(ClassTy.getDecl());
  if (!ClassDecl.isCompleteDefinition() || !ClassDecl.isDynamicClass()) {
    return;
  }
  if (!$this().SanOpts.has(SanitizerKind.CFICastStrict)) {
    ClassDecl = CGClassStatics.LeastDerivedClassWithSameLayout(ClassDecl);
  }
  
  BasicBlock /*P*/ ContBlock = null;
  if (MayBeNull) {
    Value /*P*/ DerivedNotNull = $this().Builder.CreateIsNotNull(Derived, new Twine(/*KEEP_STR*/"cast.nonnull"));
    
    BasicBlock /*P*/ CheckBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"cast.check"));
    ContBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"cast.cont"));
    
    $this().Builder.CreateCondBr(DerivedNotNull, CheckBlock, ContBlock);
    
    $this().EmitBlock(CheckBlock);
  }
  
  Value /*P*/ VTable = $this().GetVTablePtr(new Address(Derived, /*J:ToBase*/super.getPointerAlign()), Unnamed_field9.Int8PtrTy, ClassDecl);
  
  $this().EmitVTablePtrCheck(ClassDecl, VTable, TCK, new SourceLocation(Loc));
  if (MayBeNull) {
    $this().Builder.CreateBr(ContBlock);
    $this().EmitBlock(ContBlock);
  }
}


/// EmitVTablePtrCheckForCall - Virtual method MD is being called via VTable.
/// If vptr CFI is enabled, emit a check that VTable is valid.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitVTablePtrCheckForCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2633,
 FQN="clang::CodeGen::CodeGenFunction::EmitVTablePtrCheckForCall", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitVTablePtrCheckForCallEPKNS_13CXXRecordDeclEPN4llvm5ValueENS1_16CFITypeCheckKindENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitVTablePtrCheckForCallEPKNS_13CXXRecordDeclEPN4llvm5ValueENS1_16CFITypeCheckKindENS_14SourceLocationE")
//</editor-fold>
public final void EmitVTablePtrCheckForCall(/*const*/ CXXRecordDecl /*P*/ RD, 
                         Value /*P*/ VTable, 
                         CFITypeCheckKind TCK, 
                         SourceLocation Loc) {
  if (!$this().SanOpts.has(SanitizerKind.CFICastStrict)) {
    RD = CGClassStatics.LeastDerivedClassWithSameLayout(RD);
  }
  
  $this().EmitVTablePtrCheck(RD, VTable, TCK, new SourceLocation(Loc));
}


/// EmitVTablePtrCheck - Emit a check that VTable is a valid virtual table for
/// RD using llvm.type.test.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitVTablePtrCheck">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2688,
 FQN="clang::CodeGen::CodeGenFunction::EmitVTablePtrCheck", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitVTablePtrCheckEPKNS_13CXXRecordDeclEPN4llvm5ValueENS1_16CFITypeCheckKindENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitVTablePtrCheckEPKNS_13CXXRecordDeclEPN4llvm5ValueENS1_16CFITypeCheckKindENS_14SourceLocationE")
//</editor-fold>
public final void EmitVTablePtrCheck(/*const*/ CXXRecordDecl /*P*/ RD, 
                  Value /*P*/ VTable, 
                  CFITypeCheckKind TCK, 
                  SourceLocation Loc) {
  SanitizerScope SanScope = null;
  try {
    if (!$this().CGM.getCodeGenOpts().SanitizeCfiCrossDso
       && !$this().CGM.HasHiddenLTOVisibility(RD)) {
      return;
    }
    
    std.string TypeName = RD.getQualifiedNameAsString();
    if ($this().getContext().getSanitizerBlacklist().isBlacklistedType(new StringRef(TypeName))) {
      return;
    }
    
    SanScope/*J*/= new SanitizerScope($this());
    SanitizerStatKind SSK = SanitizerStatKind.SanStat_CFI_VCall;
    switch (TCK) {
     case CFITCK_VCall:
      SSK = SanitizerStatKind.SanStat_CFI_VCall;
      break;
     case CFITCK_NVCall:
      SSK = SanitizerStatKind.SanStat_CFI_NVCall;
      break;
     case CFITCK_DerivedCast:
      SSK = SanitizerStatKind.SanStat_CFI_DerivedCast;
      break;
     case CFITCK_UnrelatedCast:
      SSK = SanitizerStatKind.SanStat_CFI_UnrelatedCast;
      break;
     case CFITCK_ICall:
      throw new llvm_unreachable("not expecting CFITCK_ICall");
    }
    $this().EmitSanitizerStatReport(SSK);
    
    Metadata /*P*/ MD = $this().CGM.CreateMetadataIdentifierForType(new QualType(RD.getTypeForDecl(), 0));
    Value /*P*/ TypeId = MetadataAsValue.get($this().getLLVMContext(), MD);
    
    Value /*P*/ CastedVTable = $this().Builder.CreateBitCast(VTable, Unnamed_field9.Int8PtrTy);
    Value /*P*/ TypeTest = $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.type_test), /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {CastedVTable, TypeId}, true)/* }*/);
    
    long/*uint64_t*/ M = 0;
    switch (TCK) {
     case CFITCK_VCall:
      M = SanitizerKind.CFIVCall;
      break;
     case CFITCK_NVCall:
      M = SanitizerKind.CFINVCall;
      break;
     case CFITCK_DerivedCast:
      M = SanitizerKind.CFIDerivedCast;
      break;
     case CFITCK_UnrelatedCast:
      M = SanitizerKind.CFIUnrelatedCast;
      break;
     case CFITCK_ICall:
      throw new llvm_unreachable("not expecting CFITCK_ICall");
    }
    
    Constant /*P*/ StaticData[/*3*/] = new Constant /*P*/  [/*3*/] {
      ConstantInt.get(Int8Ty, TCK.getValue()), 
      $this().EmitCheckSourceLocation(new SourceLocation(Loc)), 
      $this().EmitCheckTypeDescriptor(new QualType(RD.getTypeForDecl(), 0))
    };
    
    ConstantInt /*P*/ CrossDsoTypeId = $this().CGM.CreateCrossDsoCfiTypeId(MD);
    if ($this().CGM.getCodeGenOpts().SanitizeCfiCrossDso && (CrossDsoTypeId != null)) {
      $this().EmitCfiSlowPathCheck(M, TypeTest, CrossDsoTypeId, CastedVTable, new ArrayRef<Constant /*P*/ >(StaticData, true));
      return;
    }
    if ($this().CGM.getCodeGenOpts().SanitizeTrap.has(M)) {
      $this().EmitTrapCheck(TypeTest);
      return;
    }
    
    Value /*P*/ AllVtables = MetadataAsValue.get($this().CGM.getLLVMContext(), 
        MDString.get($this().CGM.getLLVMContext(), $("all-vtables")));
    Value /*P*/ ValidVtable = $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.type_test), /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {CastedVTable, AllVtables}, true)/* }*/);
    $this().EmitCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(std.make_pair_Ptr_ulong(TypeTest, M), false), new StringRef(/*KEEP_STR*/"cfi_check_fail"), new ArrayRef<Constant /*P*/ >(StaticData, true), 
        /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {CastedVTable, ValidVtable}, true)/* }*/);
  } finally {
    if (SanScope != null) { SanScope.$destroy(); }
  }
}


/// If whole-program virtual table optimization is enabled, emit an assumption
/// that VTable is a member of RD's type identifier. Or, if vptr CFI is
/// enabled, emit a check that VTable is a member of RD's type identifier.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitTypeMetadataCodeForVCall">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2612,
 FQN="clang::CodeGen::CodeGenFunction::EmitTypeMetadataCodeForVCall", NM="_ZN5clang7CodeGen15CodeGenFunction28EmitTypeMetadataCodeForVCallEPKNS_13CXXRecordDeclEPN4llvm5ValueENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28EmitTypeMetadataCodeForVCallEPKNS_13CXXRecordDeclEPN4llvm5ValueENS_14SourceLocationE")
//</editor-fold>
public final void EmitTypeMetadataCodeForVCall(/*const*/ CXXRecordDecl /*P*/ RD, 
                            Value /*P*/ VTable, 
                            SourceLocation Loc) {
  if ($this().CGM.getCodeGenOpts().WholeProgramVTables
     && $this().CGM.HasHiddenLTOVisibility(RD)) {
    Metadata /*P*/ MD = $this().CGM.CreateMetadataIdentifierForType(new QualType(RD.getTypeForDecl(), 0));
    Value /*P*/ TypeId = MetadataAsValue.get($this().CGM.getLLVMContext(), MD);
    
    Value /*P*/ CastedVTable = $this().Builder.CreateBitCast(VTable, Unnamed_field9.Int8PtrTy);
    Value /*P*/ TypeTest = $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.type_test), 
        /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {CastedVTable, TypeId}, true)/* }*/);
    $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.assume), new ArrayRef<Value /*P*/ >(TypeTest, true));
  }
  if ($this().SanOpts.has(SanitizerKind.CFIVCall)) {
    $this().EmitVTablePtrCheckForCall(RD, VTable, CodeGenFunction.CFITypeCheckKind.CFITCK_VCall, new SourceLocation(Loc));
  }
}


/// Returns whether we should perform a type checked load when loading a
/// virtual function for virtual calls to members of RD. This is generally
/// true when both vcall CFI and whole-program-vtables are enabled.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ShouldEmitVTableTypeCheckedLoad">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2772,
 FQN="clang::CodeGen::CodeGenFunction::ShouldEmitVTableTypeCheckedLoad", NM="_ZN5clang7CodeGen15CodeGenFunction31ShouldEmitVTableTypeCheckedLoadEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction31ShouldEmitVTableTypeCheckedLoadEPKNS_13CXXRecordDeclE")
//</editor-fold>
public final boolean ShouldEmitVTableTypeCheckedLoad(/*const*/ CXXRecordDecl /*P*/ RD) {
  if (!$this().CGM.getCodeGenOpts().WholeProgramVTables
     || !$this().SanOpts.has(SanitizerKind.CFIVCall)
     || !$this().CGM.getCodeGenOpts().SanitizeTrap.has(SanitizerKind.CFIVCall)
     || !$this().CGM.HasHiddenLTOVisibility(RD)) {
    return false;
  }
  
  std.string TypeName = RD.getQualifiedNameAsString();
  return !$this().getContext().getSanitizerBlacklist().isBlacklistedType(new StringRef(TypeName));
}


/// Emit a type checked load from the given vtable.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitVTableTypeCheckedLoad">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2783,
 FQN="clang::CodeGen::CodeGenFunction::EmitVTableTypeCheckedLoad", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitVTableTypeCheckedLoadEPKNS_13CXXRecordDeclEPN4llvm5ValueEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitVTableTypeCheckedLoadEPKNS_13CXXRecordDeclEPN4llvm5ValueEy")
//</editor-fold>
public final Value /*P*/ EmitVTableTypeCheckedLoad(/*const*/ CXXRecordDecl /*P*/ RD, Value /*P*/ VTable, long/*uint64_t*/ VTableByteOffset) {
  SanitizerScope SanScope = null;
  try {
    SanScope/*J*/= new SanitizerScope($this());
    
    $this().EmitSanitizerStatReport(SanitizerStatKind.SanStat_CFI_VCall);
    
    Metadata /*P*/ MD = $this().CGM.CreateMetadataIdentifierForType(new QualType(RD.getTypeForDecl(), 0));
    Value /*P*/ TypeId = MetadataAsValue.get($this().CGM.getLLVMContext(), MD);
    
    Value /*P*/ CastedVTable = $this().Builder.CreateBitCast(VTable, Unnamed_field9.Int8PtrTy);
    Value /*P*/ CheckedLoad = $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.type_checked_load), 
        /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {
              CastedVTable, ConstantInt.get(Int32Ty, VTableByteOffset), 
              TypeId}, true)/* }*/);
    Value /*P*/ CheckResult = $this().Builder.CreateExtractValue(CheckedLoad, new ArrayRefUInt(1));
    
    $this().EmitCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(std.make_pair_Ptr_ulong(CheckResult, SanitizerKind.CFIVCall), false), 
        new StringRef(/*KEEP_STR*/"cfi_check_fail"), new ArrayRef<Constant /*P*/ >((Constant /*P*/ /*const*/)null, true), new ArrayRef<Value /*P*/ >((Value /*P*/ /*const*/)null, true));
    
    return $this().Builder.CreateBitCast($this().Builder.CreateExtractValue(CheckedLoad, new ArrayRefUInt(0)), 
        cast_PointerType(VTable.getType()).getElementType());
  } finally {
    if (SanScope != null) { SanScope.$destroy(); }
  }
}


/// CanDevirtualizeMemberFunctionCalls - Checks whether virtual calls on given
/// expr can be devirtualized.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CanDevirtualizeMemberFunctionCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2833,
 FQN="clang::CodeGen::CodeGenFunction::CanDevirtualizeMemberFunctionCall", NM="_ZN5clang7CodeGen15CodeGenFunction33CanDevirtualizeMemberFunctionCallEPKNS_4ExprEPKNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction33CanDevirtualizeMemberFunctionCallEPKNS_4ExprEPKNS_13CXXMethodDeclE")
//</editor-fold>
public final boolean CanDevirtualizeMemberFunctionCall(/*const*/ Expr /*P*/ Base, 
                                 /*const*/ CXXMethodDecl /*P*/ MD) {
  // When building with -fapple-kext, all calls must go through the vtable since
  // the kernel linker can do runtime patching of vtables.
  if ($this().getLangOpts().AppleKext) {
    return false;
  }
  
  // If the most derived class is marked final, we know that no subclass can
  // override this member function and so we can devirtualize it. For example:
  //
  // struct A { virtual void f(); }
  // struct B final : A { };
  //
  // void f(B *b) {
  //   b->f();
  // }
  //
  /*const*/ CXXRecordDecl /*P*/ MostDerivedClassDecl = Base.getBestDynamicClassType();
  if (MostDerivedClassDecl.hasAttr(FinalAttr.class)) {
    return true;
  }
  
  // If the member function is marked 'final', we know that it can't be
  // overridden and can therefore devirtualize it.
  if (MD.hasAttr(FinalAttr.class)) {
    return true;
  }
  
  // Similarly, if the class itself is marked 'final' it can't be overridden
  // and we can therefore devirtualize the member function call.
  if (MD.getParent$Const().hasAttr(FinalAttr.class)) {
    return true;
  }
  
  Base = CGClassStatics.skipNoOpCastsAndParens(Base);
  {
    /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Base);
    if ((DRE != null)) {
      {
        /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DRE.getDecl$Const());
        if ((VD != null)) {
          // This is a record decl. We know the type and can devirtualize it.
          return VD.getType().$arrow().isRecordType();
        }
      }
      
      return false;
    }
  }
  {
    
    // We can devirtualize calls on an object accessed by a class member access
    // expression, since by C++11 [basic.life]p6 we know that it can't refer to
    // a derived class object constructed in the same location.
    /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(Base);
    if ((ME != null)) {
      {
        /*const*/ ValueDecl /*P*/ VD = dyn_cast_ValueDecl(ME.getMemberDecl());
        if ((VD != null)) {
          return VD.getType().$arrow().isRecordType();
        }
      }
    }
  }
  
  // We can always devirtualize calls on temporary object expressions.
  if (isa_CXXConstructExpr(Base)) {
    return true;
  }
  
  // And calls on bound temporaries.
  if (isa_CXXBindTemporaryExpr(Base)) {
    return true;
  }
  {
    
    // Check if this is a call expr that returns a record type.
    /*const*/ CallExpr /*P*/ CE = dyn_cast_CallExpr(Base);
    if ((CE != null)) {
      return CE.getCallReturnType($this().getContext()).$arrow().isRecordType();
    }
  }
  
  // We can't devirtualize the call.
  return false;
}


/// EnterDtorCleanups - Enter the cleanups necessary to complete the
/// given phase of destruction for a destructor.  The end result
/// should call destructors on members and base classes in reverse
/// order of their construction.
// end anonymous namespace

/// \brief Emit all code that comes at the end of class's
/// destructor. This is to call destructors on members and base classes
/// in reverse order of their construction.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EnterDtorCleanups">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1807,
 FQN="clang::CodeGen::CodeGenFunction::EnterDtorCleanups", NM="_ZN5clang7CodeGen15CodeGenFunction17EnterDtorCleanupsEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EnterDtorCleanupsEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeE")
//</editor-fold>
public final void EnterDtorCleanups(/*const*/ CXXDestructorDecl /*P*/ DD, 
                 CXXDtorType DtorType) {
  assert ((!DD.isTrivial() || DD.hasAttr(DLLExportAttr.class))) : "Should not emit dtor epilogue for non-exported trivial dtor!";
  
  // The deleting-destructor phase just needs to call the appropriate
  // operator delete that Sema picked up.
  if (DtorType == CXXDtorType.Dtor_Deleting) {
    assert ((DD.getOperatorDelete() != null)) : "operator delete missing - EnterDtorCleanups";
    if (($this().CXXStructorImplicitParamValue != null)) {
      // If there is an implicit param to the deleting dtor, it's a boolean
      // telling whether we should call delete at the end of the dtor.
      $this().EHStack.<CallDtorDeleteConditional>pushCleanup$T(CleanupKind.NormalAndEHCleanup, () -> new CallDtorDeleteConditional($this().CXXStructorImplicitParamValue));
    } else {
      $this().EHStack.<CallDtorDelete>pushCleanup$T(CleanupKind.NormalAndEHCleanup, () -> new CallDtorDelete());
    }
    return;
  }
  
  /*const*/ CXXRecordDecl /*P*/ ClassDecl = DD.getParent$Const();
  
  // Unions have no bases and do not call field destructors.
  if (ClassDecl.isUnion()) {
    return;
  }
  
  // The complete-destructor phase just destructs all the virtual bases.
  if (DtorType == CXXDtorType.Dtor_Complete) {
    // Poison the vtable pointer such that access after the base
    // and member destructors are invoked is invalid.
    if ($this().CGM.getCodeGenOpts().SanitizeMemoryUseAfterDtor
       && $this().SanOpts.has(SanitizerKind.Memory) && (ClassDecl.getNumVBases() != 0)
       && ClassDecl.isPolymorphic()) {
      $this().EHStack.<SanitizeDtorVTable>pushCleanup$T(CleanupKind.NormalAndEHCleanup, () -> new SanitizeDtorVTable(DD));
    }
    
    // We push them in the forward order so that they'll be popped in
    // the reverse order.
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : ClassDecl.vbases$Const()) {
      CXXRecordDecl /*P*/ BaseClassDecl = cast_CXXRecordDecl(Base.getType().$arrow().getAs$RecordType().getDecl());
      
      // Ignore trivial destructors.
      if (BaseClassDecl.hasTrivialDestructor()) {
        continue;
      }
      
      $this().EHStack.<CallBaseDtor>pushCleanup$T(CleanupKind.NormalAndEHCleanup, 
          () -> new CallBaseDtor(BaseClassDecl, 
          /*BaseIsVirtual*/ true));
    }
    
    return;
  }
  assert (DtorType == CXXDtorType.Dtor_Base);
  // Poison the vtable pointer if it has no virtual bases, but inherits
  // virtual functions.
  if ($this().CGM.getCodeGenOpts().SanitizeMemoryUseAfterDtor
     && $this().SanOpts.has(SanitizerKind.Memory) && !(ClassDecl.getNumVBases() != 0)
     && ClassDecl.isPolymorphic()) {
    $this().EHStack.<SanitizeDtorVTable>pushCleanup$T(CleanupKind.NormalAndEHCleanup, () -> new SanitizeDtorVTable(DD));
  }
  
  // Destroy non-virtual bases.
  for (final /*const*/ CXXBaseSpecifier /*&*/ Base : ClassDecl.bases$Const()) {
    // Ignore virtual bases.
    if (Base.isVirtual()) {
      continue;
    }
    
    CXXRecordDecl /*P*/ BaseClassDecl = Base.getType().$arrow().getAsCXXRecordDecl();
    
    // Ignore trivial destructors.
    if (BaseClassDecl.hasTrivialDestructor()) {
      continue;
    }
    
    $this().EHStack.<CallBaseDtor>pushCleanup$T(CleanupKind.NormalAndEHCleanup, 
        () -> new CallBaseDtor(BaseClassDecl, 
        /*BaseIsVirtual*/ false));
  }
  
  // Poison fields such that access after their destructors are
  // invoked, and before the base class destructor runs, is invalid.
  if ($this().CGM.getCodeGenOpts().SanitizeMemoryUseAfterDtor
     && $this().SanOpts.has(SanitizerKind.Memory)) {
    $this().EHStack.<SanitizeDtorMembers>pushCleanup$T(CleanupKind.NormalAndEHCleanup, () -> new SanitizeDtorMembers(DD));
  }
  
  // Destroy direct fields.
  for (/*const*/ FieldDecl /*P*/ Field : ClassDecl.fields()) {
    QualType type = Field.getType();
    QualType.DestructionKind dtorKind = type.isDestructedType();
    if (!(dtorKind.getValue() != 0)) {
      continue;
    }
    
    // Anonymous union members do not have their destructors called.
    /*const*/ RecordType /*P*/ RT = type.$arrow().getAsUnionType();
    if ((RT != null) && RT.getDecl().isAnonymousStructOrUnion()) {
      continue;
    }
    
    /*CleanupKind*//*uint*/int cleanupKind = $this().getCleanupKind(dtorKind);
    $this().EHStack.<DestroyField>pushCleanup$T(cleanupKind, () -> new DestroyField(Field, 
        $this().getDestroyer(dtorKind), 
        $bool(cleanupKind & CleanupKind.EHCleanup)));
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::LoadCXXThisAddress">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 109,
 FQN="clang::CodeGen::CodeGenFunction::LoadCXXThisAddress", NM="_ZN5clang7CodeGen15CodeGenFunction18LoadCXXThisAddressEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18LoadCXXThisAddressEv")
//</editor-fold>
public final Address LoadCXXThisAddress() {
  assert (($this().CurFuncDecl != null)) : "loading 'this' without a func declaration?";
  assert (isa_CXXMethodDecl($this().CurFuncDecl));
  
  // Lazily compute CXXThisAlignment.
  if ($this().CXXThisAlignment.isZero()) {
    // Just use the best known alignment for the parent.
    // TODO: if we're currently emitting a complete-object ctor/dtor,
    // we can always use the complete-object alignment.
    /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXMethodDecl($this().CurFuncDecl).getParent$Const();
    $this().CXXThisAlignment.$assignMove($this().CGM.getClassPointerAlignment(RD));
  }
  
  return new Address($this().LoadCXXThis(), new CharUnits($this().CXXThisAlignment));
}


/// GetAddressOfBaseOfCompleteClass - Convert the given pointer to a
/// complete class to the given direct base.

/// Gets the address of a direct base class within a complete object.
/// This should only be used for (1) non-virtual bases or (2) virtual bases
/// when the type is known to be complete (e.g. in complete destructors).
///
/// The object pointed to by 'This' is assumed to be non-null.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GetAddressOfDirectBaseInCompleteClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 196,
 FQN="clang::CodeGen::CodeGenFunction::GetAddressOfDirectBaseInCompleteClass", NM="_ZN5clang7CodeGen15CodeGenFunction37GetAddressOfDirectBaseInCompleteClassENS0_7AddressEPKNS_13CXXRecordDeclES5_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction37GetAddressOfDirectBaseInCompleteClassENS0_7AddressEPKNS_13CXXRecordDeclES5_b")
//</editor-fold>
public final Address GetAddressOfDirectBaseInCompleteClass(Address This, 
                                     /*const*/ CXXRecordDecl /*P*/ Derived, 
                                     /*const*/ CXXRecordDecl /*P*/ Base, 
                                     boolean BaseIsVirtual) {
  // 'this' must be a pointer (in some address space) to Derived.
  assert (This.getElementType() == $this().ConvertType(Derived));
  
  // Compute the offset of the virtual base.
  CharUnits Offset/*J*/= new CharUnits();
  final /*const*/ ASTRecordLayout /*&*/ Layout = $this().getContext().getASTRecordLayout(Derived);
  if (BaseIsVirtual) {
    Offset.$assignMove(Layout.getVBaseClassOffset(Base));
  } else {
    Offset.$assignMove(Layout.getBaseClassOffset(Base));
  }
  
  // Shift and cast down to the base type.
  // TODO: for complete types, this should be possible with a GEP.
  Address V = new Address(This);
  if (!Offset.isZero()) {
    V.$assignMove($this().Builder.CreateElementBitCast(new Address(V), Int8Ty));
    V.$assignMove($this().Builder.CreateConstInBoundsByteGEP(new Address(V), new CharUnits(Offset)));
  }
  V.$assignMove($this().Builder.CreateElementBitCast(new Address(V), $this().ConvertType(Base)));
  
  return V;
}


/// GetAddressOfBaseClass - This function will add the necessary delta to the
/// load of 'this' and returns address of the base class.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GetAddressOfBaseClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 265,
 FQN="clang::CodeGen::CodeGenFunction::GetAddressOfBaseClass", NM="_ZN5clang7CodeGen15CodeGenFunction21GetAddressOfBaseClassENS0_7AddressEPKNS_13CXXRecordDeclEPKPKNS_16CXXBaseSpecifierESA_bNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21GetAddressOfBaseClassENS0_7AddressEPKNS_13CXXRecordDeclEPKPKNS_16CXXBaseSpecifierESA_bNS_14SourceLocationE")
//</editor-fold>
public final Address GetAddressOfBaseClass(Address Value, /*const*/ CXXRecordDecl /*P*/ Derived, 
                     type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> PathBegin, 
                     type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> PathEnd, boolean NullCheckValue, 
                     SourceLocation Loc) {
  assert ($noteq_ptr(PathBegin, PathEnd)) : "Base path should not be empty!";
  
  type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> Start = $tryClone(PathBegin);
  /*const*/ CXXRecordDecl /*P*/ VBase = null;
  
  // Sema has done some convenient canonicalization here: if the
  // access path involved any virtual steps, the conversion path will
  // *start* with a step down to the correct virtual base subobject,
  // and hence will not require any further steps.
  if ((Start.$star()).isVirtual()) {
    VBase
       = cast_CXXRecordDecl((Start.$star()).getType().$arrow().getAs$RecordType().getDecl());
    Start.$preInc();
  }
  
  // Compute the static offset of the ultimate destination within its
  // allocating subobject (the virtual base, if there is one, or else
  // the "complete" object that we see).
  CharUnits NonVirtualOffset = $this().CGM.computeNonVirtualBaseClassOffset((VBase != null) ? VBase : Derived, Start, PathEnd);
  
  // If there's a virtual step, we can sometimes "devirtualize" it.
  // For now, that's limited to when the derived type is final.
  // TODO: "devirtualize" this for accesses to known-complete objects.
  if ((VBase != null) && Derived.hasAttr(FinalAttr.class)) {
    final /*const*/ ASTRecordLayout /*&*/ layout = $this().getContext().getASTRecordLayout(Derived);
    CharUnits vBaseOffset = layout.getVBaseClassOffset(VBase);
    NonVirtualOffset.$addassign(vBaseOffset);
    VBase = null; // we no longer have a virtual step
  }
  
  // Get the base pointer type.
  org.llvm.ir.Type /*P*/ BasePtrTy = $this().ConvertType((PathEnd.$at(-1)).getType()).getPointerTo();
  
  QualType DerivedTy = $this().getContext().getRecordType(Derived);
  CharUnits DerivedAlign = $this().CGM.getClassPointerAlignment(Derived);
  
  // If the static offset is zero and we don't have a virtual step,
  // just do a bitcast; null checks are unnecessary.
  if (NonVirtualOffset.isZero() && !(VBase != null)) {
    if ($this().sanitizePerformTypeCheck()) {
      $this().EmitTypeCheck(TypeCheckKind.TCK_Upcast, new SourceLocation(Loc), Value.getPointer(), 
          new QualType(DerivedTy), new CharUnits(DerivedAlign), !NullCheckValue);
    }
    return $this().Builder.CreateBitCast(new Address(Value), BasePtrTy);
  }
  
  BasicBlock /*P*/ origBB = null;
  BasicBlock /*P*/ endBB = null;
  
  // Skip over the offset (and the vtable load) if we're supposed to
  // null-check the pointer.
  if (NullCheckValue) {
    origBB = $this().Builder.GetInsertBlock();
    BasicBlock /*P*/ notNullBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"cast.notnull"));
    endBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"cast.end"));
    
    Value /*P*/ isNull = $this().Builder.CreateIsNull(Value.getPointer());
    $this().Builder.CreateCondBr(isNull, endBB, notNullBB);
    $this().EmitBlock(notNullBB);
  }
  if ($this().sanitizePerformTypeCheck()) {
    $this().EmitTypeCheck((VBase != null) ? TypeCheckKind.TCK_UpcastToVirtualBase : TypeCheckKind.TCK_Upcast, new SourceLocation(Loc), 
        Value.getPointer(), new QualType(DerivedTy), new CharUnits(DerivedAlign), true);
  }
  
  // Compute the virtual offset.
  Value /*P*/ VirtualOffset = null;
  if ((VBase != null)) {
    VirtualOffset
       = $this().CGM.getCXXABI().GetVirtualBaseClassOffset(/*Deref*/$this(), new Address(Value), Derived, VBase);
  }
  
  // Apply both offsets.
  Value.$assignMove(CGClassStatics.ApplyNonVirtualAndVirtualOffset(/*Deref*/$this(), new Address(Value), new CharUnits(NonVirtualOffset), 
          VirtualOffset, Derived, VBase));
  
  // Cast to the destination type.
  Value.$assignMove($this().Builder.CreateBitCast(new Address(Value), BasePtrTy));
  
  // Build a phi if we needed a null check.
  if (NullCheckValue) {
    BasicBlock /*P*/ notNullBB = $this().Builder.GetInsertBlock();
    $this().Builder.CreateBr(endBB);
    $this().EmitBlock(endBB);
    
    PHINode /*P*/ PHI = $this().Builder.CreatePHI(BasePtrTy, 2, new Twine(/*KEEP_STR*/"cast.result"));
    PHI.addIncoming(Value.getPointer(), notNullBB);
    PHI.addIncoming(Constant.getNullValue(BasePtrTy), origBB);
    Value.$assignMove(new Address(PHI, Value.getAlignment()));
  }
  
  return new Address(JD$Move.INSTANCE, Value);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GetAddressOfDerivedClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 367,
 FQN="clang::CodeGen::CodeGenFunction::GetAddressOfDerivedClass", NM="_ZN5clang7CodeGen15CodeGenFunction24GetAddressOfDerivedClassENS0_7AddressEPKNS_13CXXRecordDeclEPKPKNS_16CXXBaseSpecifierESA_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24GetAddressOfDerivedClassENS0_7AddressEPKNS_13CXXRecordDeclEPKPKNS_16CXXBaseSpecifierESA_b")
//</editor-fold>
public final Address GetAddressOfDerivedClass(Address BaseAddr, 
                        /*const*/ CXXRecordDecl /*P*/ Derived, 
                        type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> PathBegin, 
                        type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> PathEnd, 
                        boolean NullCheckValue) {
  assert ($noteq_ptr(PathBegin, PathEnd)) : "Base path should not be empty!";
  
  QualType DerivedTy = $this().getContext().getCanonicalType($this().getContext().getTagDeclType(Derived)).$QualType();
  org.llvm.ir.Type /*P*/ DerivedPtrTy = $this().ConvertType(new QualType(DerivedTy)).getPointerTo();
  
  Value /*P*/ NonVirtualOffset = $this().CGM.GetNonVirtualBaseClassOffset(Derived, PathBegin, PathEnd);
  if (!(NonVirtualOffset != null)) {
    // No offset, we can just cast back.
    return $this().Builder.CreateBitCast(new Address(BaseAddr), DerivedPtrTy);
  }
  
  BasicBlock /*P*/ CastNull = null;
  BasicBlock /*P*/ CastNotNull = null;
  BasicBlock /*P*/ CastEnd = null;
  if (NullCheckValue) {
    CastNull = $this().createBasicBlock(new Twine(/*KEEP_STR*/"cast.null"));
    CastNotNull = $this().createBasicBlock(new Twine(/*KEEP_STR*/"cast.notnull"));
    CastEnd = $this().createBasicBlock(new Twine(/*KEEP_STR*/"cast.end"));
    
    Value /*P*/ IsNull = $this().Builder.CreateIsNull(BaseAddr.getPointer());
    $this().Builder.CreateCondBr(IsNull, CastNull, CastNotNull);
    $this().EmitBlock(CastNotNull);
  }
  
  // Apply the offset.
  Value /*P*/ $Value = $this().Builder.CreateBitCast(BaseAddr.getPointer(), Unnamed_field9.Int8PtrTy);
  $Value = $this().Builder.CreateGEP($Value, $this().Builder.CreateNeg(NonVirtualOffset), 
      new Twine(/*KEEP_STR*/"sub.ptr"));
  
  // Just cast.
  $Value = $this().Builder.CreateBitCast($Value, DerivedPtrTy);
  
  // Produce a PHI if we had a null-check.
  if (NullCheckValue) {
    $this().Builder.CreateBr(CastEnd);
    $this().EmitBlock(CastNull);
    $this().Builder.CreateBr(CastEnd);
    $this().EmitBlock(CastEnd);
    
    PHINode /*P*/ PHI = $this().Builder.CreatePHI($Value.getType(), 2);
    PHI.addIncoming($Value, CastNotNull);
    PHI.addIncoming(Constant.getNullValue($Value.getType()), CastNull);
    $Value = PHI;
  }
  
  return new Address($Value, $this().CGM.getClassPointerAlignment(Derived));
}


/// GetVTTParameter - Return the VTT parameter that should be passed to a
/// base constructor/destructor with virtual bases.
/// FIXME: VTTs are Itanium ABI-specific, so the definition should move
/// to ItaniumCXXABI.cpp together with all the references to VTT.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GetVTTParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 425,
 FQN="clang::CodeGen::CodeGenFunction::GetVTTParameter", NM="_ZN5clang7CodeGen15CodeGenFunction15GetVTTParameterENS_10GlobalDeclEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15GetVTTParameterENS_10GlobalDeclEbb")
//</editor-fold>
public final Value /*P*/ GetVTTParameter(GlobalDecl GD, 
               boolean ForVirtualBase, 
               boolean Delegating) {
  if (!$this().CGM.getCXXABI().NeedsVTTParameter(new GlobalDecl(GD))) {
    // This constructor/destructor does not need a VTT parameter.
    return null;
  }
  
  /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXMethodDecl($this().CurCodeDecl).getParent$Const();
  /*const*/ CXXRecordDecl /*P*/ Base = cast_CXXMethodDecl(GD.getDecl()).getParent$Const();
  
  Value /*P*/ VTT;
  
  long/*uint64_t*/ SubVTTIndex;
  if (Delegating) {
    // If this is a delegating constructor call, just load the VTT.
    return $this().LoadCXXVTT();
  } else if (RD == Base) {
    // If the record matches the base, this is the complete ctor/dtor
    // variant calling the base variant in a class with virtual bases.
    assert (!$this().CGM.getCXXABI().NeedsVTTParameter(new GlobalDecl($this().CurGD))) : "doing no-op VTT offset in base dtor/ctor?";
    assert (!ForVirtualBase) : "Can't have same class as virtual base!";
    SubVTTIndex = $int2ulong(0);
  } else {
    final /*const*/ ASTRecordLayout /*&*/ Layout = $this().getContext().getASTRecordLayout(RD);
    CharUnits BaseOffset = ForVirtualBase ? Layout.getVBaseClassOffset(Base) : Layout.getBaseClassOffset(Base);
    
    SubVTTIndex
       = $this().CGM.getVTables().getSubVTTIndex(RD, new BaseSubobject(Base, new CharUnits(BaseOffset)));
    assert (SubVTTIndex != $int2ullong(0)) : "Sub-VTT index must be greater than zero!";
  }
  if ($this().CGM.getCXXABI().NeedsVTTParameter(new GlobalDecl($this().CurGD))) {
    // A VTT parameter was passed to the constructor, use it.
    VTT = $this().LoadCXXVTT();
    VTT = $this().Builder.CreateConstInBoundsGEP1_64(VTT, SubVTTIndex);
  } else {
    // We're the complete constructor, so get the VTT by name.
    VTT = $this().CGM.getVTables().GetAddrOfVTT(RD);
    VTT = $this().Builder.CreateConstInBoundsGEP2_64(VTT, $int2ulong(0), SubVTTIndex);
  }
  
  return VTT;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitDelegateCXXConstructorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2313,
 FQN="clang::CodeGen::CodeGenFunction::EmitDelegateCXXConstructorCall", NM="_ZN5clang7CodeGen15CodeGenFunction30EmitDelegateCXXConstructorCallEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeERKNS0_15FunctionArgListENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction30EmitDelegateCXXConstructorCallEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeERKNS0_15FunctionArgListENS_14SourceLocationE")
//</editor-fold>
public final void EmitDelegateCXXConstructorCall(/*const*/ CXXConstructorDecl /*P*/ Ctor, 
                              CXXCtorType CtorType, 
                              final /*const*/ FunctionArgList /*&*/ Args, 
                              SourceLocation Loc) {
  CallArgList DelegateArgs = null;
  try {
    DelegateArgs/*J*/= new CallArgList();
    
    type$ptr</*const*/ VarDecl /*P*/ /*const*/ /*P*/> I = $tryClone(Args.begin$Const());
    type$ptr</*const*/ VarDecl /*P*/ /*const*/ /*P*/> E = $tryClone(Args.end$Const());
    assert ($noteq_ptr(I, E)) : "no parameters to constructor";
    
    // this
    Address This = $this().LoadCXXThisAddress();
    DelegateArgs.add(RValue.get(This.getPointer()), (I.$star()).getType());
    I.$preInc();
    
    // FIXME: The location of the VTT parameter in the parameter list is
    // specific to the Itanium ABI and shouldn't be hardcoded here.
    if ($this().CGM.getCXXABI().NeedsVTTParameter(new GlobalDecl($this().CurGD))) {
      assert ($noteq_ptr(I, E)) : "cannot skip vtt parameter, already done with args";
      assert ((I.$star()).getType().$arrow().isPointerType()) : "skipping parameter not of vtt type";
      I.$preInc();
    }
    
    // Explicit arguments.
    for (; $noteq_ptr(I, E); I.$preInc()) {
      /*const*/ VarDecl /*P*/ param = I.$star();
      // FIXME: per-argument source location
      $this().EmitDelegateCallArg(DelegateArgs, param, new SourceLocation(Loc));
    }
    
    $this().EmitCXXConstructorCall(Ctor, CtorType, /*ForVirtualBase=*/ false, 
        /*Delegating=*/ true, new Address(This), DelegateArgs);
  } finally {
    if (DelegateArgs != null) { DelegateArgs.$destroy(); }
  }
}

// It's important not to confuse this and the previous function. Delegating
// constructors are the C++0x feature. The constructor delegate optimization
// is used to reduce duplication in the base and complete consturctors where
// they are substantially the same.
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitDelegatingCXXConstructorCall">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2365,
 FQN="clang::CodeGen::CodeGenFunction::EmitDelegatingCXXConstructorCall", NM="_ZN5clang7CodeGen15CodeGenFunction32EmitDelegatingCXXConstructorCallEPKNS_18CXXConstructorDeclERKNS0_15FunctionArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction32EmitDelegatingCXXConstructorCallEPKNS_18CXXConstructorDeclERKNS0_15FunctionArgListE")
//</editor-fold>
public final void EmitDelegatingCXXConstructorCall(/*const*/ CXXConstructorDecl /*P*/ Ctor, 
                                final /*const*/ FunctionArgList /*&*/ Args) {
  assert (Ctor.isDelegatingConstructor());
  
  Address ThisPtr = $this().LoadCXXThisAddress();
  
  AggValueSlot AggSlot = AggValueSlot.forAddr(new Address(ThisPtr), new Qualifiers(), 
      AggValueSlot.IsDestructed_t.IsDestructed, 
      AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers, 
      AggValueSlot.IsAliased_t.IsNotAliased);
  
  $this().EmitAggExpr(Ctor.init_begin$Const().$at(0).getInit(), new AggValueSlot(AggSlot));
  
  /*const*/ CXXRecordDecl /*P*/ ClassDecl = Ctor.getParent$Const();
  if ($this().CGM.getLangOpts().Exceptions && !ClassDecl.hasTrivialDestructor()) {
    CXXDtorType Type = $this().CurGD.getCtorType() == CXXCtorType.Ctor_Complete ? CXXDtorType.Dtor_Complete : CXXDtorType.Dtor_Base;
    
    $this().EHStack.<CallDelegatingCtorDtor>pushCleanup$T(CleanupKind.EHCleanup, 
        () -> new CallDelegatingCtorDtor(ClassDecl.getDestructor(), 
        new Address(ThisPtr), Type));
  }
}


/// Emit a call to an inheriting constructor (that is, one that invokes a
/// constructor inherited from a base class) by inlining its definition. This
/// is necessary if the ABI does not support forwarding the arguments to the
/// base class constructor (because they're variadic or similar).
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitInlinedInheritingCXXConstructorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2219,
 FQN="clang::CodeGen::CodeGenFunction::EmitInlinedInheritingCXXConstructorCall", NM="_ZN5clang7CodeGen15CodeGenFunction39EmitInlinedInheritingCXXConstructorCallEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeEbbRNS0_11CallArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction39EmitInlinedInheritingCXXConstructorCallEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeEbbRNS0_11CallArgListE")
//</editor-fold>
public final void EmitInlinedInheritingCXXConstructorCall(/*const*/ CXXConstructorDecl /*P*/ Ctor, CXXCtorType CtorType, boolean ForVirtualBase, 
                                       boolean Delegating, final CallArgList /*&*/ Args) {
  InlinedInheritingConstructorScope Scope = null;
  FunctionArgList Params = null;
  try {
    Scope/*J*/= new InlinedInheritingConstructorScope(/*Deref*/$this(), new GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, Ctor, CtorType));
    
    // Save the arguments to be passed to the inherited constructor.
    $this().CXXInheritedCtorInitExprArgs.$assign(Args);
    
    Params/*J*/= new FunctionArgList();
    QualType RetType = $this().BuildFunctionArgList(new GlobalDecl($this().CurGD), Params);
    $this().FnRetTy.$assign(RetType);
    
    // Insert any ABI-specific implicit constructor arguments.
    $this().CGM.getCXXABI().addImplicitConstructorArgs(/*Deref*/$this(), Ctor, CtorType, 
        ForVirtualBase, Delegating, Args);
    
    // Emit a simplified prolog. We only need to emit the implicit params.
    assert ($greatereq_uint(Args.size(), Params.size())) : "too few arguments for call";
    for (/*uint*/int I = 0, N = Args.size(); I != N; ++I) {
      if ($less_uint(I, Params.size()) && isa_ImplicitParamDecl(Params.$at(I))) {
        final /*const*/ RValue /*&*/ RV = Args.$at(I).RV;
        assert (!RV.isComplex()) : "complex indirect params not supported";
        ParamValue Val = RV.isScalar() ? ParamValue.forDirect(RV.getScalarVal()) : ParamValue.forIndirect(RV.getAggregateAddress());
        $this().EmitParmDecl($Deref(Params.$at(I)), new ParamValue(Val), I + 1);
      }
    }
    
    // Create a return value slot if the ABI implementation wants one.
    // FIXME: This is dumb, we should ask the ABI not to try to set the return
    // value instead.
    if (!RetType.$arrow().isVoidType()) {
      $this().ReturnValue.$assignMove($this().CreateIRTemp(new QualType(RetType), new Twine(/*KEEP_STR*/"retval.inhctor")));
    }
    
    $this().CGM.getCXXABI().EmitInstanceFunctionProlog(/*Deref*/$this());
    $this().CXXThisValue = $this().CXXABIThisValue;
    
    // Directly emit the constructor initializers.
    $this().EmitCtorPrologue(Ctor, CtorType, Params);
  } finally {
    if (Params != null) { Params.$destroy(); }
    if (Scope != null) { Scope.$destroy(); }
  }
}


/// Emit a call to a constructor inherited from a base class, passing the
/// current constructor's arguments along unmodified (without even making
/// a copy).
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitInheritedCXXConstructorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2172,
 FQN="clang::CodeGen::CodeGenFunction::EmitInheritedCXXConstructorCall", NM="_ZN5clang7CodeGen15CodeGenFunction31EmitInheritedCXXConstructorCallEPKNS_18CXXConstructorDeclEbNS0_7AddressEbPKNS_24CXXInheritedCtorInitExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction31EmitInheritedCXXConstructorCallEPKNS_18CXXConstructorDeclEbNS0_7AddressEbPKNS_24CXXInheritedCtorInitExprE")
//</editor-fold>
public final void EmitInheritedCXXConstructorCall(/*const*/ CXXConstructorDecl /*P*/ D, boolean ForVirtualBase, Address This, 
                               boolean InheritedFromVBase, /*const*/ CXXInheritedCtorInitExpr /*P*/ E) {
  CallArgList Args = null;
  try {
    Args/*J*/= new CallArgList();
    CallArg ThisArg/*J*/= new CallArg(RValue.get(This.getPointer()), D.getThisType($this().getContext()), 
        /*NeedsCopy=*/ false);
    
    // Forward the parameters.
    if (InheritedFromVBase
       && $this().CGM.getTarget().getCXXABI().hasConstructorVariants()) {
      // Nothing to do; this construction is not responsible for constructing
      // the base class containing the inherited constructor.
      // FIXME: Can we just pass undef's for the remaining arguments if we don't
      // have constructor variants?
      Args.push_back(ThisArg);
    } else if (!$this().CXXInheritedCtorInitExprArgs.empty()) {
      // The inheriting constructor was inlined; just inject its arguments.
      assert ($greatereq_uint($this().CXXInheritedCtorInitExprArgs.size(), D.getNumParams())) : "wrong number of parameters for inherited constructor call";
      Args.$assign($this().CXXInheritedCtorInitExprArgs);
      Args.$at(0).$assign(ThisArg);
    } else {
      // The inheriting constructor was not inlined. Emit delegating arguments.
      Args.push_back(ThisArg);
      /*const*/ CXXConstructorDecl /*P*/ OuterCtor = cast_CXXConstructorDecl($this().CurCodeDecl);
      assert (OuterCtor.getNumParams() == D.getNumParams());
      assert (!OuterCtor.isVariadic()) : "should have been inlined";
      
      for (/*const*/ ParmVarDecl /*P*/ Param : OuterCtor.parameters$Const()) {
        assert ($this().getContext().hasSameUnqualifiedType(OuterCtor.getParamDecl$Const(Param.getFunctionScopeIndex()).getType(), Param.getType()));
        $this().EmitDelegateCallArg(Args, Param, E.getLocation());
        
        // Forward __attribute__(pass_object_size).
        if (Param.hasAttr(PassObjectSizeAttr.class)) {
          /*const*/ ImplicitParamDecl /*P*/ POSParam = $this().SizeArguments.$at_T1$C$R(Param);
          assert ((POSParam != null)) : "missing pass_object_size value for forwarding";
          $this().EmitDelegateCallArg(Args, POSParam, E.getLocation());
        }
      }
    }
    
    $this().EmitCXXConstructorCall(D, CXXCtorType.Ctor_Base, ForVirtualBase, /*Delegating*/ false, 
        new Address(This), Args);
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXConstructorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2046,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXConstructorCall", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitCXXConstructorCallEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeEbbNS0_7AddressEPKNS_16CXXConstructExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitCXXConstructorCallEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeEbbNS0_7AddressEPKNS_16CXXConstructExprE")
//</editor-fold>
public final void EmitCXXConstructorCall(/*const*/ CXXConstructorDecl /*P*/ D, 
                      CXXCtorType Type, 
                      boolean ForVirtualBase, 
                      boolean Delegating, Address This, 
                      /*const*/ CXXConstructExpr /*P*/ E) {
  CallArgList Args = null;
  try {
    Args/*J*/= new CallArgList();
    
    // Push the this ptr.
    Args.add(RValue.get(This.getPointer()), D.getThisType($this().getContext()));
    
    // If this is a trivial constructor, emit a memcpy now before we lose
    // the alignment information on the argument.
    // FIXME: It would be better to preserve alignment information into CallArg.
    if (CGClassStatics.isMemcpyEquivalentSpecialMember(D)) {
      assert (E.getNumArgs() == 1) : "unexpected argcount for trivial ctor";
      
      /*const*/ Expr /*P*/ Arg = E.getArg$Const(0);
      QualType SrcTy = Arg.getType();
      Address Src = $this().EmitLValue(Arg).getAddress();
      QualType DestTy = $this().getContext().getTypeDeclType(D.getParent$Const());
      $this().EmitAggregateCopyCtor(new Address(This), new Address(Src), new QualType(DestTy), new QualType(SrcTy));
      return;
    }
    
    // Add the rest of the user-supplied arguments.
    /*const*/ FunctionProtoType /*P*/ FPT = D.getType().$arrow().castAs(FunctionProtoType.class);
    $this().EmitCallArgs(Args, FPT, E.arguments$Const(), E.getConstructor());
    
    $this().EmitCXXConstructorCall(D, Type, ForVirtualBase, Delegating, new Address(This), Args);
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXConstructorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2101,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXConstructorCall", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitCXXConstructorCallEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeEbbNS0_7AddressERNS0_11CallArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitCXXConstructorCallEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeEbbNS0_7AddressERNS0_11CallArgListE")
//</editor-fold>
public final void EmitCXXConstructorCall(/*const*/ CXXConstructorDecl /*P*/ D, 
                      CXXCtorType Type, 
                      boolean ForVirtualBase, 
                      boolean Delegating, 
                      Address This, 
                      final CallArgList /*&*/ Args) {
  /*const*/ CXXRecordDecl /*P*/ ClassDecl = D.getParent$Const();
  
  // C++11 [class.mfct.non-static]p2:
  //   If a non-static member function of a class X is called for an object that
  //   is not of type X, or of a type derived from X, the behavior is undefined.
  // FIXME: Provide a source location here.
  $this().EmitTypeCheck(CodeGenFunction.TypeCheckKind.TCK_ConstructorCall, new SourceLocation(), 
      This.getPointer(), $this().getContext().getRecordType(ClassDecl));
  if (D.isTrivial() && D.isDefaultConstructor()) {
    assert (Args.size() == 1) : "trivial default ctor with args";
    return;
  }
  
  // If this is a trivial constructor, just emit what's needed. If this is a
  // union copy constructor, we must emit a memcpy, because the AST does not
  // model that copy.
  if (CGClassStatics.isMemcpyEquivalentSpecialMember(D)) {
    assert (Args.size() == 2) : "unexpected argcount for trivial ctor";
    
    QualType SrcTy = D.getParamDecl$Const(0).getType().getNonReferenceType();
    Address Src/*J*/= new Address(Args.$at(1).RV.getScalarVal(), $this().getNaturalTypeAlignment(new QualType(SrcTy)));
    QualType DestTy = $this().getContext().getTypeDeclType(ClassDecl);
    $this().EmitAggregateCopyCtor(new Address(This), new Address(Src), new QualType(DestTy), new QualType(SrcTy));
    return;
  }
  {
    
    // Check whether we can actually emit the constructor before trying to do so.
    InheritedConstructor Inherited = D.getInheritedConstructor();
    if (Inherited.$bool()) {
      if ($this().getTypes().inheritingCtorHasParams(Inherited, Type)
         && !CGClassStatics.canEmitDelegateCallArgs(/*Deref*/$this(), D, Type, Args)) {
        $this().EmitInlinedInheritingCXXConstructorCall(D, Type, ForVirtualBase, 
            Delegating, Args);
        return;
      }
    }
  }
  
  // Insert any ABI-specific implicit constructor arguments.
  /*uint*/int ExtraArgs = $this().CGM.getCXXABI().addImplicitConstructorArgs(/*Deref*/$this(), D, Type, ForVirtualBase, Delegating, Args);
  
  // Emit the call.
  Value /*P*/ Callee = $this().CGM.getAddrOfCXXStructor(D, CodeGenStatics.getFromCtorType(Type));
  final /*const*/ CGFunctionInfo /*&*/ Info = $this().CGM.getTypes().arrangeCXXConstructorCall(Args, D, Type, ExtraArgs);
  $this().EmitCall(Info, Callee, new ReturnValueSlot(), Args, new CGCalleeInfo(D));
  
  // Generate vtable assumptions if we're constructing a complete object
  // with a vtable.  We don't do this for base subobjects for two reasons:
  // first, it's incorrect for classes with virtual bases, and second, we're
  // about to overwrite the vptrs anyway.
  // We also have to make sure if we can refer to vtable:
  // - Otherwise we can refer to vtable if it's safe to speculatively emit.
  // FIXME: If vtable is used by ctor/dtor, or if vtable is external and we are
  // sure that definition of vtable is not hidden,
  // then we are always safe to refer to it.
  // FIXME: It looks like InstCombine is very inefficient on dealing with
  // assumes. Make assumption loads require -fstrict-vtable-pointers temporarily.
  if ($2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) > 0
     && ClassDecl.isDynamicClass() && Type != CXXCtorType.Ctor_Base
     && $this().CGM.getCXXABI().canSpeculativelyEmitVTable(ClassDecl)
     && $this().CGM.getCodeGenOpts().StrictVTablePointers) {
    $this().EmitVTableAssumptionLoads(ClassDecl, new Address(This));
  }
}


/// Emit assumption load for all bases. Requires to be be called only on
/// most-derived class and not under construction of the object.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitVTableAssumptionLoads">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2282,
 FQN="clang::CodeGen::CodeGenFunction::EmitVTableAssumptionLoads", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitVTableAssumptionLoadsEPKNS_13CXXRecordDeclENS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitVTableAssumptionLoadsEPKNS_13CXXRecordDeclENS0_7AddressE")
//</editor-fold>
public final void EmitVTableAssumptionLoads(/*const*/ CXXRecordDecl /*P*/ ClassDecl, 
                         Address This) {
  if ($this().CGM.getCXXABI().doStructorsInitializeVPtrs(ClassDecl)) {
    for (final /*const*/ VPtr /*&*/ Vptr : $this().getVTablePointers(ClassDecl))  {
      $this().EmitVTableAssumptionLoad(Vptr, new Address(This));
    }
  }
}


/// Emit assumption that vptr load == global vtable.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitVTableAssumptionLoad">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2261,
 FQN="clang::CodeGen::CodeGenFunction::EmitVTableAssumptionLoad", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitVTableAssumptionLoadERKNS1_4VPtrENS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitVTableAssumptionLoadERKNS1_4VPtrENS0_7AddressE")
//</editor-fold>
public final void EmitVTableAssumptionLoad(final /*const*/ VPtr /*&*/ Vptr, Address This) {
  Value /*P*/ VTableGlobal = $this().CGM.getCXXABI().getVTableAddressPoint(new BaseSubobject(Vptr.Base), Vptr.VTableClass);
  if (!(VTableGlobal != null)) {
    return;
  }
  
  // We can just use the base offset in the complete class.
  CharUnits NonVirtualOffset = Vptr.Base.getBaseOffset();
  if (!NonVirtualOffset.isZero()) {
    This.$assignMove(
        CGClassStatics.ApplyNonVirtualAndVirtualOffset(/*Deref*/$this(), new Address(This), new CharUnits(NonVirtualOffset), (Value /*P*/ )null, 
            Vptr.VTableClass, Vptr.NearestVBase)
    );
  }
  
  Value /*P*/ VPtrValue = $this().GetVTablePtr(new Address(This), VTableGlobal.getType(), Vptr.VTableClass);
  Value /*P*/ Cmp = $this().Builder.CreateICmpEQ(VPtrValue, VTableGlobal, new Twine(/*KEEP_STR*/"cmp.vtables"));
  $this().Builder.CreateAssumption(Cmp);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitSynthesizedCXXCopyCtorCall">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2289,
 FQN="clang::CodeGen::CodeGenFunction::EmitSynthesizedCXXCopyCtorCall", NM="_ZN5clang7CodeGen15CodeGenFunction30EmitSynthesizedCXXCopyCtorCallEPKNS_18CXXConstructorDeclENS0_7AddressES5_PKNS_16CXXConstructExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction30EmitSynthesizedCXXCopyCtorCallEPKNS_18CXXConstructorDeclENS0_7AddressES5_PKNS_16CXXConstructExprE")
//</editor-fold>
public final void EmitSynthesizedCXXCopyCtorCall(/*const*/ CXXConstructorDecl /*P*/ D, 
                              Address This, Address Src, 
                              /*const*/ CXXConstructExpr /*P*/ E) {
  CallArgList Args = null;
  try {
    /*const*/ FunctionProtoType /*P*/ FPT = D.getType().$arrow().castAs(FunctionProtoType.class);
    
    Args/*J*/= new CallArgList();
    
    // Push the this ptr.
    Args.add(RValue.get(This.getPointer()), D.getThisType($this().getContext()));
    
    // Push the src ptr.
    QualType QT = new QualType((FPT.param_type_begin()).$star());
    org.llvm.ir.Type /*P*/ t = $this().CGM.getTypes().ConvertType(new QualType(QT));
    Src.$assignMove($this().Builder.CreateBitCast(new Address(Src), t));
    Args.add(RValue.get(Src.getPointer()), new QualType(QT));
    
    // Skip over first argument (Src).
    $this().EmitCallArgs(Args, FPT, ClangCodeGenDummies.drop_begin(E.arguments$Const(), 1), E.getConstructor(), 
        /*ParamsToSkip*/ 1);
    
    $this().EmitCXXConstructorCall(D, CXXCtorType.Ctor_Complete, false, false, new Address(This), Args);
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}


/// EmitCXXAggrConstructorCall - Emit a loop to call a particular
/// constructor for each of several members of an array.
///
/// \param ctor the constructor to call for each element
/// \param arrayType the type of the array to initialize
/// \param arrayBegin an arrayType*
/// \param zeroInitialize true if each element should be
///   zero-initialized before it is constructed
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXAggrConstructorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1917,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXAggrConstructorCall", NM="_ZN5clang7CodeGen15CodeGenFunction26EmitCXXAggrConstructorCallEPKNS_18CXXConstructorDeclEPKNS_9ArrayTypeENS0_7AddressEPKNS_16CXXConstructExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26EmitCXXAggrConstructorCallEPKNS_18CXXConstructorDeclEPKNS_9ArrayTypeENS0_7AddressEPKNS_16CXXConstructExprEb")
//</editor-fold>
public final void EmitCXXAggrConstructorCall(/*const*/ CXXConstructorDecl /*P*/ ctor, /*const*/ org.clang.ast.ArrayType /*P*/ arrayType, 
                          Address arrayBegin, /*const*/ CXXConstructExpr /*P*/ E) {
  EmitCXXAggrConstructorCall(ctor, arrayType, 
                          arrayBegin, E, false);
}
public final void EmitCXXAggrConstructorCall(/*const*/ CXXConstructorDecl /*P*/ ctor, /*const*/ org.clang.ast.ArrayType /*P*/ arrayType, 
                          Address arrayBegin, /*const*/ CXXConstructExpr /*P*/ E, boolean zeroInitialize/*= false*/) {
  QualType elementType/*J*/= new QualType();
  Value /*P*/ numElements = $this().emitArrayLength(arrayType, elementType, arrayBegin);
  
  $this().EmitCXXAggrConstructorCall(ctor, numElements, new Address(arrayBegin), E, zeroInitialize);
}


/// EmitCXXAggrConstructorCall - Emit a loop to call a particular
/// constructor for each of several members of an array.
///
/// \param ctor the constructor to call for each element
/// \param numElements the number of elements in the array;
///   may be zero
/// \param arrayBase a T*, where T is the type constructed by ctor
/// \param zeroInitialize true if each element should be
///   zero-initialized before it is constructed
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXAggrConstructorCall">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1936,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXAggrConstructorCall", NM="_ZN5clang7CodeGen15CodeGenFunction26EmitCXXAggrConstructorCallEPKNS_18CXXConstructorDeclEPN4llvm5ValueENS0_7AddressEPKNS_16CXXConstructExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26EmitCXXAggrConstructorCallEPKNS_18CXXConstructorDeclEPN4llvm5ValueENS0_7AddressEPKNS_16CXXConstructExprEb")
//</editor-fold>
public final void EmitCXXAggrConstructorCall(/*const*/ CXXConstructorDecl /*P*/ ctor, 
                          Value /*P*/ numElements, 
                          Address arrayBase, 
                          /*const*/ CXXConstructExpr /*P*/ E) {
  EmitCXXAggrConstructorCall(ctor, 
                          numElements, 
                          arrayBase, 
                          E, 
                          false);
}
public final void EmitCXXAggrConstructorCall(/*const*/ CXXConstructorDecl /*P*/ ctor, 
                          Value /*P*/ numElements, 
                          Address arrayBase, 
                          /*const*/ CXXConstructExpr /*P*/ E, 
                          boolean zeroInitialize/*= false*/) {
  // It's legal for numElements to be zero.  This can happen both
  // dynamically, because x can be zero in 'new A[x]', and statically,
  // because of GCC extensions that permit zero-length arrays.  There
  // are probably legitimate places where we could assume that this
  // doesn't happen, but it's not clear that it's worth it.
  BranchInst /*P*/ zeroCheckBranch = null;
  
  // Optimize for a constant count.
  ConstantInt /*P*/ constantCount = dyn_cast_ConstantInt(numElements);
  if ((constantCount != null)) {
    // Just skip out if the constant count is zero.
    if (constantCount.isZero()) {
      return;
    }
    // Otherwise, emit the check.
  } else {
    BasicBlock /*P*/ loopBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"new.ctorloop"));
    Value /*P*/ iszero = $this().Builder.CreateIsNull(numElements, new Twine(/*KEEP_STR*/"isempty"));
    zeroCheckBranch = $this().Builder.CreateCondBr(iszero, loopBB, loopBB);
    $this().EmitBlock(loopBB);
  }
  
  // Find the end of the array.
  Value /*P*/ arrayBegin = arrayBase.getPointer();
  Value /*P*/ arrayEnd = $this().Builder.CreateInBoundsGEP(arrayBegin, new ArrayRef<Value /*P*/ >(numElements, true), 
      new Twine(/*KEEP_STR*/"arrayctor.end"));
  
  // Enter the loop, setting up a phi for the current location to initialize.
  BasicBlock /*P*/ entryBB = $this().Builder.GetInsertBlock();
  BasicBlock /*P*/ loopBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"arrayctor.loop"));
  $this().EmitBlock(loopBB);
  PHINode /*P*/ cur = $this().Builder.CreatePHI(arrayBegin.getType(), 2, 
      new Twine(/*KEEP_STR*/"arrayctor.cur"));
  cur.addIncoming(arrayBegin, entryBB);
  
  // Inside the loop body, emit the constructor call on the array element.
  
  // The alignment of the base, adjusted by the size of a single element,
  // provides a conservative estimate of the alignment of every element.
  // (This assumes we never start tracking offsetted alignments.)
  // 
  // Note that these are complete objects and so we don't need to
  // use the non-virtual size or alignment.
  QualType type = $this().getContext().getTypeDeclType(ctor.getParent$Const());
  CharUnits eltAlignment = arrayBase.getAlignment().
      alignmentOfArrayElement($this().getContext().getTypeSizeInChars(/*NO_COPY*/type));
  Address curAddr = new Address(cur, new CharUnits(eltAlignment));
  
  // Zero initialize the storage, if requested.
  if (zeroInitialize) {
    $this().EmitNullInitialization(new Address(curAddr), new QualType(type));
  }
  {
    RunCleanupsScope Scope = null;
    try {
      Scope/*J*/= new RunCleanupsScope(/*Deref*/$this());
      
      // Evaluate the constructor and its arguments in a regular
      // partial-destroy cleanup.
      if ($this().getLangOpts().Exceptions
         && !ctor.getParent$Const().hasTrivialDestructor()) {
        CodeGenFunction.AddressQualType2Void destroyer = /*FuncRef*/CodeGenFunction::destroyCXXObject;
        $this().pushRegularPartialArrayCleanup(arrayBegin, cur, new QualType(type), new CharUnits(eltAlignment), 
            /*FuncRef*/destroyer);
      }
      
      $this().EmitCXXConstructorCall(ctor, CXXCtorType.Ctor_Complete, /*ForVirtualBase=*/ false, 
          /*Delegating=*/ false, new Address(curAddr), E);
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }
  
  // Go to the next element.
  Value /*P*/ next = $this().Builder.CreateInBoundsGEP(cur, new ArrayRef<Value /*P*/ >(ConstantInt.get(Unnamed_field8.SizeTy, $int2ulong(1)), true), 
      new Twine(/*KEEP_STR*/"arrayctor.next"));
  cur.addIncoming(next, $this().Builder.GetInsertBlock());
  
  // Check whether that's the end of the loop.
  Value /*P*/ done = $this().Builder.CreateICmpEQ(next, arrayEnd, new Twine(/*KEEP_STR*/"arrayctor.done"));
  BasicBlock /*P*/ contBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"arrayctor.cont"));
  $this().Builder.CreateCondBr(done, contBB, loopBB);
  
  // Patch the earlier check to skip over the loop.
  if ((zeroCheckBranch != null)) {
    zeroCheckBranch.setSuccessor(0, contBB);
  }
  
  $this().EmitBlock(contBB);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::destroyCXXObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2035,
 FQN="clang::CodeGen::CodeGenFunction::destroyCXXObject", NM="_ZN5clang7CodeGen15CodeGenFunction16destroyCXXObjectERS1_NS0_7AddressENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16destroyCXXObjectERS1_NS0_7AddressENS_8QualTypeE")
//</editor-fold>
public static void destroyCXXObject(final CodeGenFunction /*&*/ CGF, 
                Address addr, 
                QualType type) {
  /*const*/ RecordType /*P*/ rtype = type.$arrow().castAs$RecordType();
  /*const*/ CXXRecordDecl /*P*/ record = cast_CXXRecordDecl(rtype.getDecl());
  /*const*/ CXXDestructorDecl /*P*/ dtor = record.getDestructor();
  assert (!dtor.isTrivial());
  CGF.EmitCXXDestructorCall(dtor, CXXDtorType.Dtor_Complete, /*for vbase*/ false, 
      /*Delegating=*/ false, new Address(addr));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXDestructorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2391,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXDestructorCall", NM="_ZN5clang7CodeGen15CodeGenFunction21EmitCXXDestructorCallEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeEbbNS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21EmitCXXDestructorCallEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeEbbNS0_7AddressE")
//</editor-fold>
public final void EmitCXXDestructorCall(/*const*/ CXXDestructorDecl /*P*/ DD, 
                     CXXDtorType Type, 
                     boolean ForVirtualBase, 
                     boolean Delegating, 
                     Address This) {
  $this().CGM.getCXXABI().EmitDestructorCall(/*Deref*/$this(), DD, Type, ForVirtualBase, 
      Delegating, new Address(This));
}

// Compute the object pointer.

/// Emit the address of a field using a member data pointer.
///
/// \param E Only used for emergency diagnostics
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXMemberDataPointerAddress">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 128,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXMemberDataPointerAddress", NM="_ZN5clang7CodeGen15CodeGenFunction31EmitCXXMemberDataPointerAddressEPKNS_4ExprENS0_7AddressEPN4llvm5ValueEPKNS_17MemberPointerTypeEPNS0_15AlignmentSourceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction31EmitCXXMemberDataPointerAddressEPKNS_4ExprENS0_7AddressEPN4llvm5ValueEPKNS_17MemberPointerTypeEPNS0_15AlignmentSourceE")
//</editor-fold>
public final Address EmitCXXMemberDataPointerAddress(/*const*/ Expr /*P*/ E, Address base, 
                               Value /*P*/ memberPtr, 
                               /*const*/ MemberPointerType /*P*/ memberPtrType) {
  return EmitCXXMemberDataPointerAddress(E, base, 
                               memberPtr, 
                               memberPtrType, 
                               create_type$null$ptr());
}
public final Address EmitCXXMemberDataPointerAddress(/*const*/ Expr /*P*/ E, Address base, 
                               Value /*P*/ memberPtr, 
                               /*const*/ MemberPointerType /*P*/ memberPtrType, 
                               type$ptr<AlignmentSource /*P*/> alignSource/*= null*/) {
  // Ask the ABI to compute the actual address.
  Value /*P*/ ptr = $this().CGM.getCXXABI().EmitMemberDataPointerAddress(/*Deref*/$this(), E, new Address(base), 
      memberPtr, memberPtrType);
  
  QualType memberType = memberPtrType.getPointeeType();
  CharUnits memberAlign = $this().getNaturalTypeAlignment(new QualType(memberType), alignSource);
  memberAlign.$assignMove(
      $this().CGM.getDynamicOffsetAlignment(base.getAlignment(), 
          memberPtrType.__getClass().getAsCXXRecordDecl(), 
          new CharUnits(memberAlign))
  );
  return new Address(ptr, new CharUnits(memberAlign));
}

} // END OF class CodeGenFunction_CGClass
