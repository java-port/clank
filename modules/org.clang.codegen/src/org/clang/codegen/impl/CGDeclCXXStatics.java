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

import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.intrinsic.ID;
import org.clang.ast.java.AstJavaDifferentiators.*;

//<editor-fold defaultstate="collapsed" desc="static type CGDeclCXXStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.impl.CGDeclCXXStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZL12EmitDeclInitRN5clang7CodeGen15CodeGenFunctionERKNS_7VarDeclENS0_15ConstantAddressE;_ZL15EmitDeclDestroyRN5clang7CodeGen15CodeGenFunctionERKNS_7VarDeclENS0_15ConstantAddressE;_ZL17EmitDeclInvariantRN5clang7CodeGen15CodeGenFunctionERKNS_7VarDeclEPN4llvm8ConstantE; -static-type=CGDeclCXXStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGDeclCXXStatics {

//<editor-fold defaultstate="collapsed" desc="EmitDeclInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp", line = 26,
 FQN="EmitDeclInit", NM="_ZL12EmitDeclInitRN5clang7CodeGen15CodeGenFunctionERKNS_7VarDeclENS0_15ConstantAddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZL12EmitDeclInitRN5clang7CodeGen15CodeGenFunctionERKNS_7VarDeclENS0_15ConstantAddressE")
//</editor-fold>
public static void EmitDeclInit(final CodeGenFunction /*&*/ CGF, final /*const*/ VarDecl /*&*/ D, 
            ConstantAddress DeclPtr) {
  assert (D.hasGlobalStorage()) : "VarDecl must have global storage!";
  assert (!D.getType().$arrow().isReferenceType()) : "Should not call EmitDeclInit on a reference!";
  
  QualType type = D.getType();
  LValue lv = CGF.MakeAddrLValue(new Address(DeclPtr), new QualType(type));
  
  /*const*/ Expr /*P*/ Init = D.getInit$Const();
  switch (CGF.getEvaluationKind(new QualType(type))) {
   case TEK_Scalar:
    {
      final CodeGenModule /*&*/ CGM = CGF.CGM;
      if (lv.isObjCStrong()) {
        CGM.getObjCRuntime().EmitObjCGlobalAssign(CGF, CGF.EmitScalarExpr(Init), 
            new Address(DeclPtr), (D.getTLSKind().getValue() != 0));
      } else if (lv.isObjCWeak()) {
        CGM.getObjCRuntime().EmitObjCWeakAssign(CGF, CGF.EmitScalarExpr(Init), 
            new Address(DeclPtr));
      } else {
        CGF.EmitScalarInit(Init, $AddrOf(D), new LValue(lv), false);
      }
      return;
    }
   case TEK_Complex:
    CGF.EmitComplexExprIntoLValue(Init, new LValue(lv), /*isInit*/ true);
    return;
   case TEK_Aggregate:
    CGF.EmitAggExpr(Init, AggValueSlot.forLValue(lv, AggValueSlot.IsDestructed_t.IsDestructed, 
            AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers, 
            AggValueSlot.IsAliased_t.IsNotAliased));
    return;
  }
  throw new llvm_unreachable("bad evaluation kind");
}


/// Emit code to cause the destruction of the given variable with
/// static storage duration.
//<editor-fold defaultstate="collapsed" desc="EmitDeclDestroy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp", line = 63,
 FQN="EmitDeclDestroy", NM="_ZL15EmitDeclDestroyRN5clang7CodeGen15CodeGenFunctionERKNS_7VarDeclENS0_15ConstantAddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZL15EmitDeclDestroyRN5clang7CodeGen15CodeGenFunctionERKNS_7VarDeclENS0_15ConstantAddressE")
//</editor-fold>
public static void EmitDeclDestroy(final CodeGenFunction /*&*/ CGF, final /*const*/ VarDecl /*&*/ D, 
               ConstantAddress addr) {
  final CodeGenModule /*&*/ CGM = CGF.CGM;
  
  // FIXME:  __attribute__((cleanup)) ?
  QualType type = D.getType();
  QualType.DestructionKind dtorKind = type.isDestructedType();
  switch (dtorKind) {
   case DK_none:
    return;
   case DK_cxx_destructor:
    break;
   case DK_objc_strong_lifetime:
   case DK_objc_weak_lifetime:
    // We don't care about releasing objects during process teardown.
    assert (!(D.getTLSKind().getValue() != 0)) : "should have rejected this";
    return;
  }
  
  Constant /*P*/ function;
  Constant /*P*/ argument;
  
  // Special-case non-array C++ destructors, if they have the right signature.
  // Under some ABIs, destructors return this instead of void, and cannot be
  // passed directly to __cxa_atexit if the target does not allow this mismatch.
  /*const*/ CXXRecordDecl /*P*/ Record = type.$arrow().getAsCXXRecordDecl();
  boolean CanRegisterDestructor = (Record != null) && (!CGM.getCXXABI().HasThisReturn(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, Record.getDestructor(), CXXDtorType.Dtor_Complete))
     || CGM.getCXXABI().canCallMismatchedFunctionType());
  // If __cxa_atexit is disabled via a flag, a different helper function is
  // generated elsewhere which uses atexit instead, and it takes the destructor
  // directly.
  boolean UsingExternalHelper = !CGM.getCodeGenOpts().CXAAtExit;
  if ((Record != null) && (CanRegisterDestructor || UsingExternalHelper)) {
    assert (!Record.hasTrivialDestructor());
    CXXDestructorDecl /*P*/ dtor = Record.getDestructor();
    
    function = CGM.getAddrOfCXXStructor(dtor, StructorType.Complete);
    argument = ConstantExpr.getBitCast(addr.getPointer(), CGF.getTypes().ConvertType(new QualType(type)).getPointerTo());
    // Otherwise, the standard logic requires a helper function.
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(function = $c$.track(new CodeGenFunction(CGM)).
          generateDestroyHelper(new Address(addr), new QualType(type), CGF.getDestroyer(dtorKind), 
          CGF.needsEHCleanup(dtorKind), $AddrOf(D)));
      argument = Constant.getNullValue(CGF.Unnamed_field9.Int8PtrTy);
    } finally {
      $c$.$destroy();
    }
  }
  
  CGM.getCXXABI().registerGlobalDtor(CGF, D, function, argument);
}


/// Emit code to cause the variable at the given address to be considered as
/// constant from this point onwards.
//<editor-fold defaultstate="collapsed" desc="EmitDeclInvariant">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp", line = 122,
 FQN="EmitDeclInvariant", NM="_ZL17EmitDeclInvariantRN5clang7CodeGen15CodeGenFunctionERKNS_7VarDeclEPN4llvm8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZL17EmitDeclInvariantRN5clang7CodeGen15CodeGenFunctionERKNS_7VarDeclEPN4llvm8ConstantE")
//</editor-fold>
public static void EmitDeclInvariant(final CodeGenFunction /*&*/ CGF, final /*const*/ VarDecl /*&*/ D, 
                 Constant /*P*/ Addr) {
  // Don't emit the intrinsic if we're not optimizing.
  if (!($2bits_uint2uint(CGF.CGM.getCodeGenOpts().OptimizationLevel) != 0)) {
    return;
  }
  
  // Grab the llvm.invariant.start intrinsic.
  /*Intrinsic.ID*/int InvStartID = ID.invariant_start;
  Constant /*P*/ InvariantStart = CGF.CGM.getIntrinsic(InvStartID);
  
  // Emit a call with the size in bytes of the object.
  CharUnits WidthChars = CGF.getContext().getTypeSizeInChars(D.getType());
  long/*uint64_t*/ Width = WidthChars.getQuantity();
  Value /*P*/ Args[/*2*/] = new Value /*P*/  [/*2*/] {
    ConstantInt.getSigned(CGF.Int64Ty, Width), 
    ConstantExpr.getBitCast(Addr, CGF.Unnamed_field9.Int8PtrTy)};
  CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(InvariantStart, new ArrayRef<Value /*P*/ >(Args, true));
}

} // END OF class CGDeclCXXStatics
