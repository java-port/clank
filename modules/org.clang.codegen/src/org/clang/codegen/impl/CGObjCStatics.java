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

import java.util.function.Supplier;
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
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.java.ilist_traits_IR;


//<editor-fold defaultstate="collapsed" desc="static type CGObjCStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.impl.CGObjCStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL14findWeakLValuePKN5clang4ExprE;_ZL17hasTrivialGetExprPKN5clang20ObjCPropertyImplDeclE;_ZL17hasTrivialSetExprPKN5clang20ObjCPropertyImplDeclE;_ZL18UseOptimizedSetterRN5clang7CodeGen13CodeGenModuleE;_ZL18getNullForVariableN5clang7CodeGen7AddressE;_ZL19hasUnalignedAtomicsN4llvm6Triple8ArchTypeE;_ZL20AdjustObjCObjectTypeRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeENS0_6RValueE;_ZL20emitARCCopyOperationRN5clang7CodeGen15CodeGenFunctionENS0_7AddressES3_RPN4llvm8ConstantENS4_9StringRefE;_ZL20emitARCLoadOperationRN5clang7CodeGen15CodeGenFunctionENS0_7AddressERPN4llvm8ConstantENS4_9StringRefE;_ZL20emitStructGetterCallRN5clang7CodeGen15CodeGenFunctionEPNS_12ObjCIvarDeclEbb;_ZL20emitStructSetterCallRN5clang7CodeGen15CodeGenFunctionEPNS_14ObjCMethodDeclEPNS_12ObjCIvarDeclE;_ZL21emitARCStoreOperationRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEPN4llvm5ValueERPNS4_8ConstantENS4_9StringRefEb;_ZL21emitARCValueOperationRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueERPNS3_8ConstantENS3_9StringRefEb;_ZL21emitCXXDestructMethodRN5clang7CodeGen15CodeGenFunctionEPNS_22ObjCImplementationDeclE;_ZL22getMaxAtomicAccessSizeRN5clang7CodeGen13CodeGenModuleEN4llvm6Triple8ArchTypeE;_ZL23emitARCRetainCallResultRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE;_ZL24createARCRuntimeFunctionRN5clang7CodeGen13CodeGenModuleEPN4llvm12FunctionTypeENS3_9StringRefE;_ZL25destroyARCStrongWithStoreRN5clang7CodeGen15CodeGenFunctionENS0_7AddressENS_8QualTypeE;_ZL25emitARCOperationAfterCallRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS3_12function_refIFS5_S2_S5_EEES8_;_ZL25emitARCRetainLoadOfScalarRN5clang7CodeGen15CodeGenFunctionENS0_6LValueENS_8QualTypeE;_ZL26tryEmitARCRetainScalarExprRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE;_ZL28emitARCUnsafeClaimCallResultRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE;_ZL28tryEmitARCRetainLoadOfScalarRN5clang7CodeGen15CodeGenFunctionENS0_6LValueENS_8QualTypeE;_ZL28tryEmitARCRetainLoadOfScalarRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE;_ZL29emitCPPObjectAtomicGetterCallRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueEPNS_12ObjCIvarDeclEPNS3_8ConstantE;_ZL29emitCPPObjectAtomicSetterCallRN5clang7CodeGen15CodeGenFunctionEPNS_14ObjCMethodDeclEPNS_12ObjCIvarDeclEPN4llvm8ConstantE;_ZL29shouldEmitSeparateBlockRetainPKN5clang4ExprE;_ZL33emitARCUnsafeUnretainedScalarExprRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE;_ZL33emitAutoreleasedReturnValueMarkerRN5clang7CodeGen15CodeGenFunctionE;_ZL42shouldExtendReceiverForInnerPointerMessagePKN5clang15ObjCMessageExprE; -static-type=CGObjCStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGObjCStatics {

//<editor-fold defaultstate="collapsed" desc="tryEmitARCRetainScalarExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2901,
 FQN="tryEmitARCRetainScalarExpr", NM="_ZL26tryEmitARCRetainScalarExprRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL26tryEmitARCRetainScalarExprRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE")
//</editor-fold>
public static PointerBoolPair<Value /*P*/ > tryEmitARCRetainScalarExpr(final CodeGenFunction /*&*/ CGF, /*const*/ Expr /*P*/ e) {
  return new ARCRetainExprEmitter(CGF).visit(e);
}


/// \brief Adjust the type of an Objective-C object that doesn't match up due
/// to type erasure at various points, e.g., related result types or the use
/// of parameterized classes.
//<editor-fold defaultstate="collapsed" desc="AdjustObjCObjectType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 251,
 FQN="AdjustObjCObjectType", NM="_ZL20AdjustObjCObjectTypeRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeENS0_6RValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL20AdjustObjCObjectTypeRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeENS0_6RValueE")
//</editor-fold>
public static RValue AdjustObjCObjectType(final CodeGenFunction /*&*/ CGF, QualType ExpT, 
                    RValue Result) {
  if (!ExpT.$arrow().isObjCRetainableType()) {
    return new RValue(JD$Move.INSTANCE, Result);
  }
  
  // If the converted types are the same, we're done.
  org.llvm.ir.Type /*P*/ ExpLLVMTy = CGF.ConvertType(new QualType(ExpT));
  if (ExpLLVMTy == Result.getScalarVal().getType()) {
    return new RValue(JD$Move.INSTANCE, Result);
  }
  
  // We have applied a substitution. Cast the rvalue appropriately.
  return RValue.get(CGF.Builder.CreateBitCast(Result.getScalarVal(), 
          ExpLLVMTy));
}


/// Given the address of a variable of pointer type, find the correct
/// null to store into it.
//<editor-fold defaultstate="collapsed" desc="getNullForVariable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 40,
 FQN="getNullForVariable", NM="_ZL18getNullForVariableN5clang7CodeGen7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL18getNullForVariableN5clang7CodeGen7AddressE")
//</editor-fold>
public static Constant /*P*/ getNullForVariable(Address addr) {
  org.llvm.ir.Type /*P*/ type = addr.getElementType();
  return ConstantPointerNull.get(cast_PointerType(type));
}


/// Decide whether to extend the lifetime of the receiver of a
/// returns-inner-pointer message.
//<editor-fold defaultstate="collapsed" desc="shouldExtendReceiverForInnerPointerMessage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 268,
 FQN="shouldExtendReceiverForInnerPointerMessage", NM="_ZL42shouldExtendReceiverForInnerPointerMessagePKN5clang15ObjCMessageExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL42shouldExtendReceiverForInnerPointerMessagePKN5clang15ObjCMessageExprE")
//</editor-fold>
public static boolean shouldExtendReceiverForInnerPointerMessage(/*const*/ ObjCMessageExpr /*P*/ message) {
  switch (message.getReceiverKind()) {
   case Instance:
    {
      /*const*/ Expr /*P*/ receiver = message.getInstanceReceiver$Const();
      {
        
        // Look through OVEs.
        /*const*/ OpaqueValueExpr /*P*/ opaque = dyn_cast_OpaqueValueExpr(receiver);
        if ((opaque != null)) {
          if ((opaque.getSourceExpr() != null)) {
            receiver = opaque.getSourceExpr().IgnoreParens();
          }
        }
      }
      
      /*const*/ ImplicitCastExpr /*P*/ ice = dyn_cast_ImplicitCastExpr(receiver);
      if (!(ice != null) || ice.getCastKind() != CastKind.CK_LValueToRValue) {
        return true;
      }
      receiver = ice.getSubExpr$Const().IgnoreParens$Const();
      {
        
        // Look through OVEs.
        /*const*/ OpaqueValueExpr /*P*/ opaque = dyn_cast_OpaqueValueExpr(receiver);
        if ((opaque != null)) {
          if ((opaque.getSourceExpr() != null)) {
            receiver = opaque.getSourceExpr().IgnoreParens();
          }
        }
      }
      
      // Only __strong variables.
      if (receiver.getType().getObjCLifetime() != Qualifiers.ObjCLifetime.OCL_Strong) {
        return true;
      }
      
      // All ivars and fields have precise lifetime.
      if (isa_MemberExpr(receiver) || isa_ObjCIvarRefExpr(receiver)) {
        return false;
      }
      
      // Otherwise, check for variables.
      /*const*/ DeclRefExpr /*P*/ declRef = dyn_cast_DeclRefExpr(ice.getSubExpr$Const());
      if (!(declRef != null)) {
        return true;
      }
      /*const*/ VarDecl /*P*/ var = dyn_cast_VarDecl(declRef.getDecl$Const());
      if (!(var != null)) {
        return true;
      }
      
      // All variables have precise lifetime except local variables with
      // automatic storage duration that aren't specially marked.
      return (var.hasLocalStorage()
         && !var.hasAttr(ObjCPreciseLifetimeAttr.class));
    }
   case Class:
   case SuperClass:
    // It's never necessary for class objects.
    return false;
   case SuperInstance:
    // We generally assume that 'self' lives throughout a method call.
    return false;
  }
  throw new llvm_unreachable("invalid receiver kind");
}


/// Given an expression of ObjC pointer type, check whether it was
/// immediately loaded from an ARC __weak l-value.
//<editor-fold defaultstate="collapsed" desc="findWeakLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 328,
 FQN="findWeakLValue", NM="_ZL14findWeakLValuePKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL14findWeakLValuePKN5clang4ExprE")
//</editor-fold>
public static /*const*/ Expr /*P*/ findWeakLValue(/*const*/ Expr /*P*/ E) {
  assert (E.getType().$arrow().isObjCRetainableType());
  E = E.IgnoreParens$Const();
  {
    /*const*/ CastExpr /*P*/ CE = dyn_cast_CastExpr(E);
    if ((CE != null)) {
      if (CE.getCastKind() == CastKind.CK_LValueToRValue) {
        if (CE.getSubExpr$Const().getType().getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Weak) {
          return CE.getSubExpr$Const();
        }
      }
    }
  }
  
  return null;
}

//<editor-fold defaultstate="collapsed" desc="emitARCRetainLoadOfScalar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2906,
 FQN="emitARCRetainLoadOfScalar", NM="_ZL25emitARCRetainLoadOfScalarRN5clang7CodeGen15CodeGenFunctionENS0_6LValueENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL25emitARCRetainLoadOfScalarRN5clang7CodeGen15CodeGenFunctionENS0_6LValueENS_8QualTypeE")
//</editor-fold>
public static Value /*P*/ emitARCRetainLoadOfScalar(final CodeGenFunction /*&*/ CGF, 
                         LValue lvalue, 
                         QualType type) {
  PointerBoolPair<Value /*P*/ > result = tryEmitARCRetainLoadOfScalar(CGF, new LValue(lvalue), new QualType(type));
  Value /*P*/ value = result.getPointer();
  if (!result.getInt()) {
    value = CGF.EmitARCRetain(new QualType(type), value);
  }
  return value;
}


/// emitStructGetterCall - Call the runtime function to load a property
/// into the return value slot.
//<editor-fold defaultstate="collapsed" desc="emitStructGetterCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 569,
 FQN="emitStructGetterCall", NM="_ZL20emitStructGetterCallRN5clang7CodeGen15CodeGenFunctionEPNS_12ObjCIvarDeclEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL20emitStructGetterCallRN5clang7CodeGen15CodeGenFunctionEPNS_12ObjCIvarDeclEbb")
//</editor-fold>
public static void emitStructGetterCall(final CodeGenFunction /*&*/ CGF, ObjCIvarDecl /*P*/ ivar, 
                    boolean isAtomic, boolean hasStrong) {
  CallArgList args = null;
  try {
    final ASTContext /*&*/ Context = CGF.getContext();
    
    Address src = CGF.EmitLValueForIvar(CGF.TypeOfSelfObject(), CGF.LoadObjCSelf(), ivar, 0).
        getAddress();
    
    // objc_copyStruct (ReturnValue, &structIvar, 
    //                  sizeof (Type of Ivar), isAtomic, false);
    args/*J*/= new CallArgList();
    
    Address dest = CGF.Builder.CreateBitCast(new Address(CGF.ReturnValue), CGF.Unnamed_field9.VoidPtrTy);
    args.add(RValue.get(dest.getPointer()), Context.VoidPtrTy.$QualType());
    
    src.$assignMove(CGF.Builder.CreateBitCast(new Address(src), CGF.Unnamed_field9.VoidPtrTy));
    args.add(RValue.get(src.getPointer()), Context.VoidPtrTy.$QualType());
    
    CharUnits size = CGF.getContext().getTypeSizeInChars(ivar.getType());
    args.add(RValue.get(CGF.CGM.getSize(new CharUnits(size))), Context.getSizeType().$QualType());
    args.add(RValue.get(CGF.Builder.getInt1(isAtomic)), Context.BoolTy.$QualType());
    args.add(RValue.get(CGF.Builder.getInt1(hasStrong)), Context.BoolTy.$QualType());
    
    Value /*P*/ fn = CGF.CGM.getObjCRuntime().GetGetStructFunction();
    CGF.EmitCall(CGF.getTypes().arrangeBuiltinFunctionCall(Context.VoidTy.$QualType(), args), 
        fn, new ReturnValueSlot(), args);
  } finally {
    if (args != null) { args.$destroy(); }
  }
}


/// Determine whether the given architecture supports unaligned atomic
/// accesses.  They don't have to be fast, just faster than a function
/// call and a mutex.
//<editor-fold defaultstate="collapsed" desc="hasUnalignedAtomics">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 600,
 FQN="hasUnalignedAtomics", NM="_ZL19hasUnalignedAtomicsN4llvm6Triple8ArchTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL19hasUnalignedAtomicsN4llvm6Triple8ArchTypeE")
//</editor-fold>
public static boolean hasUnalignedAtomics(Triple.ArchType arch) {
  // FIXME: Allow unaligned atomic load/store on x86.  (It is not
  // currently supported by the backend.)
  return false;
}


/// Return the maximum size that permits atomic accesses for the given
/// architecture.
//<editor-fold defaultstate="collapsed" desc="getMaxAtomicAccessSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 608,
 FQN="getMaxAtomicAccessSize", NM="_ZL22getMaxAtomicAccessSizeRN5clang7CodeGen13CodeGenModuleEN4llvm6Triple8ArchTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL22getMaxAtomicAccessSizeRN5clang7CodeGen13CodeGenModuleEN4llvm6Triple8ArchTypeE")
//</editor-fold>
public static CharUnits getMaxAtomicAccessSize(final CodeGenModule /*&*/ CGM, 
                      Triple.ArchType arch) {
  // ARM has 8-byte atomic accesses, but it's not clear whether we
  // want to rely on them here.
  
  // In the default case, just assume that any size up to a pointer is
  // fine given adequate alignment.
  return CharUnits.fromQuantity($uchar2long(CGM.Unnamed_field13.PointerSizeInBytes));
}

//<editor-fold defaultstate="collapsed" desc="hasTrivialGetExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 809,
 FQN="hasTrivialGetExpr", NM="_ZL17hasTrivialGetExprPKN5clang20ObjCPropertyImplDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL17hasTrivialGetExprPKN5clang20ObjCPropertyImplDeclE")
//</editor-fold>
public static boolean hasTrivialGetExpr(/*const*/ ObjCPropertyImplDecl /*P*/ propImpl) {
  /*const*/ Expr /*P*/ getter = propImpl.getGetterCXXConstructor();
  if (!(getter != null)) {
    return true;
  }
  
  // Sema only makes only of these when the ivar has a C++ class type,
  // so the form is pretty constrained.
  
  // If the property has a reference type, we might just be binding a
  // reference, in which case the result will be a gl-value.  We should
  // treat this as a non-trivial operation.
  if (getter.isGLValue()) {
    return false;
  }
  {
    
    // If we selected a trivial copy-constructor, we're okay.
    /*const*/ CXXConstructExpr /*P*/ construct = dyn_cast_CXXConstructExpr(getter);
    if ((construct != null)) {
      return (construct.getConstructor().isTrivial());
    }
  }
  
  // The constructor might require cleanups (in which case it's never
  // trivial).
  assert (isa_ExprWithCleanups(getter));
  return false;
}


/// emitCPPObjectAtomicGetterCall - Call the runtime function to 
/// copy the ivar into the resturn slot.
//<editor-fold defaultstate="collapsed" desc="emitCPPObjectAtomicGetterCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 834,
 FQN="emitCPPObjectAtomicGetterCall", NM="_ZL29emitCPPObjectAtomicGetterCallRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueEPNS_12ObjCIvarDeclEPNS3_8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL29emitCPPObjectAtomicGetterCallRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueEPNS_12ObjCIvarDeclEPNS3_8ConstantE")
//</editor-fold>
public static void emitCPPObjectAtomicGetterCall(final CodeGenFunction /*&*/ CGF, 
                             Value /*P*/ returnAddr, 
                             ObjCIvarDecl /*P*/ ivar, 
                             Constant /*P*/ AtomicHelperFn) {
  CallArgList args = null;
  try {
    // objc_copyCppObjectAtomic (&returnSlot, &CppObjectIvar,
    //                           AtomicHelperFn);
    args/*J*/= new CallArgList();
    
    // The 1st argument is the return Slot.
    args.add(RValue.get(returnAddr), CGF.getContext().VoidPtrTy.$QualType());
    
    // The 2nd argument is the address of the ivar.
    Value /*P*/ ivarAddr = CGF.EmitLValueForIvar(CGF.TypeOfSelfObject(), 
        CGF.LoadObjCSelf(), ivar, 0).getPointer();
    ivarAddr = CGF.Builder.CreateBitCast(ivarAddr, CGF.Unnamed_field9.Int8PtrTy);
    args.add(RValue.get(ivarAddr), CGF.getContext().VoidPtrTy.$QualType());
    
    // Third argument is the helper function.
    args.add(RValue.get(AtomicHelperFn), CGF.getContext().VoidPtrTy.$QualType());
    
    Value /*P*/ copyCppAtomicObjectFn = CGF.CGM.getObjCRuntime().GetCppAtomicObjectGetFunction();
    CGF.EmitCall(CGF.getTypes().arrangeBuiltinFunctionCall(CGF.getContext().VoidTy.$QualType(), args), 
        copyCppAtomicObjectFn, new ReturnValueSlot(), args);
  } finally {
    if (args != null) { args.$destroy(); }
  }
}


/// emitStructSetterCall - Call the runtime function to store the value
/// from the first formal parameter into the given ivar.
//<editor-fold defaultstate="collapsed" desc="emitStructSetterCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1038,
 FQN="emitStructSetterCall", NM="_ZL20emitStructSetterCallRN5clang7CodeGen15CodeGenFunctionEPNS_14ObjCMethodDeclEPNS_12ObjCIvarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL20emitStructSetterCallRN5clang7CodeGen15CodeGenFunctionEPNS_14ObjCMethodDeclEPNS_12ObjCIvarDeclE")
//</editor-fold>
public static void emitStructSetterCall(final CodeGenFunction /*&*/ CGF, ObjCMethodDecl /*P*/ OMD, 
                    ObjCIvarDecl /*P*/ ivar) {
  CallArgList args = null;
  try {
    // objc_copyStruct (&structIvar, &Arg, 
    //                  sizeof (struct something), true, false);
    args/*J*/= new CallArgList();
    
    // The first argument is the address of the ivar.
    Value /*P*/ ivarAddr = CGF.EmitLValueForIvar(CGF.TypeOfSelfObject(), 
        CGF.LoadObjCSelf(), ivar, 0).
        getPointer();
    ivarAddr = CGF.Builder.CreateBitCast(ivarAddr, CGF.Unnamed_field9.Int8PtrTy);
    args.add(RValue.get(ivarAddr), CGF.getContext().VoidPtrTy.$QualType());
    
    // The second argument is the address of the parameter variable.
    ParmVarDecl /*P*/ argVar = OMD.param_begin().$star();
    DeclRefExpr argRef/*J*/= new DeclRefExpr(argVar, false, argVar.getType().getNonReferenceType(), 
        ExprValueKind.VK_LValue, new SourceLocation());
    Value /*P*/ argAddr = CGF.EmitLValue($AddrOf(argRef)).getPointer();
    argAddr = CGF.Builder.CreateBitCast(argAddr, CGF.Unnamed_field9.Int8PtrTy);
    args.add(RValue.get(argAddr), CGF.getContext().VoidPtrTy.$QualType());
    
    // The third argument is the sizeof the type.
    Value /*P*/ size = CGF.CGM.getSize(CGF.getContext().getTypeSizeInChars(ivar.getType()));
    args.add(RValue.get(size), CGF.getContext().getSizeType().$QualType());
    
    // The fourth argument is the 'isAtomic' flag.
    args.add(RValue.get(CGF.Builder.getTrue()), CGF.getContext().BoolTy.$QualType());
    
    // The fifth argument is the 'hasStrong' flag.
    // FIXME: should this really always be false?
    args.add(RValue.get(CGF.Builder.getFalse()), CGF.getContext().BoolTy.$QualType());
    
    Value /*P*/ copyStructFn = CGF.CGM.getObjCRuntime().GetSetStructFunction();
    CGF.EmitCall(CGF.getTypes().arrangeBuiltinFunctionCall(CGF.getContext().VoidTy.$QualType(), args), 
        copyStructFn, new ReturnValueSlot(), args);
  } finally {
    if (args != null) { args.$destroy(); }
  }
}


/// emitCPPObjectAtomicSetterCall - Call the runtime function to store 
/// the value from the first formal parameter into the given ivar, using 
/// the Cpp API for atomic Cpp objects with non-trivial copy assignment.
//<editor-fold defaultstate="collapsed" desc="emitCPPObjectAtomicSetterCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1080,
 FQN="emitCPPObjectAtomicSetterCall", NM="_ZL29emitCPPObjectAtomicSetterCallRN5clang7CodeGen15CodeGenFunctionEPNS_14ObjCMethodDeclEPNS_12ObjCIvarDeclEPN4llvm8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL29emitCPPObjectAtomicSetterCallRN5clang7CodeGen15CodeGenFunctionEPNS_14ObjCMethodDeclEPNS_12ObjCIvarDeclEPN4llvm8ConstantE")
//</editor-fold>
public static void emitCPPObjectAtomicSetterCall(final CodeGenFunction /*&*/ CGF, 
                             ObjCMethodDecl /*P*/ OMD, 
                             ObjCIvarDecl /*P*/ ivar, 
                             Constant /*P*/ AtomicHelperFn) {
  CallArgList args = null;
  try {
    // objc_copyCppObjectAtomic (&CppObjectIvar, &Arg, 
    //                           AtomicHelperFn);
    args/*J*/= new CallArgList();
    
    // The first argument is the address of the ivar.
    Value /*P*/ ivarAddr = CGF.EmitLValueForIvar(CGF.TypeOfSelfObject(), 
        CGF.LoadObjCSelf(), ivar, 0).getPointer();
    ivarAddr = CGF.Builder.CreateBitCast(ivarAddr, CGF.Unnamed_field9.Int8PtrTy);
    args.add(RValue.get(ivarAddr), CGF.getContext().VoidPtrTy.$QualType());
    
    // The second argument is the address of the parameter variable.
    ParmVarDecl /*P*/ argVar = OMD.param_begin().$star();
    DeclRefExpr argRef/*J*/= new DeclRefExpr(argVar, false, argVar.getType().getNonReferenceType(), 
        ExprValueKind.VK_LValue, new SourceLocation());
    Value /*P*/ argAddr = CGF.EmitLValue($AddrOf(argRef)).getPointer();
    argAddr = CGF.Builder.CreateBitCast(argAddr, CGF.Unnamed_field9.Int8PtrTy);
    args.add(RValue.get(argAddr), CGF.getContext().VoidPtrTy.$QualType());
    
    // Third argument is the helper function.
    args.add(RValue.get(AtomicHelperFn), CGF.getContext().VoidPtrTy.$QualType());
    
    Value /*P*/ copyCppAtomicObjectFn = CGF.CGM.getObjCRuntime().GetCppAtomicObjectSetFunction();
    CGF.EmitCall(CGF.getTypes().arrangeBuiltinFunctionCall(CGF.getContext().VoidTy.$QualType(), args), 
        copyCppAtomicObjectFn, new ReturnValueSlot(), args);
  } finally {
    if (args != null) { args.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="hasTrivialSetExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1114,
 FQN="hasTrivialSetExpr", NM="_ZL17hasTrivialSetExprPKN5clang20ObjCPropertyImplDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL17hasTrivialSetExprPKN5clang20ObjCPropertyImplDeclE")
//</editor-fold>
public static boolean hasTrivialSetExpr(/*const*/ ObjCPropertyImplDecl /*P*/ PID) {
  Expr /*P*/ setter = PID.getSetterCXXAssignment();
  if (!(setter != null)) {
    return true;
  }
  {
    
    // Sema only makes only of these when the ivar has a C++ class type,
    // so the form is pretty constrained.
    
    // An operator call is trivial if the function it calls is trivial.
    // This also implies that there's nothing non-trivial going on with
    // the arguments, because operator= can only be trivial if it's a
    // synthesized assignment operator and therefore both parameters are
    // references.
    CallExpr /*P*/ call = dyn_cast_CallExpr(setter);
    if ((call != null)) {
      {
        /*const*/ FunctionDecl /*P*/ callee = dyn_cast_or_null_FunctionDecl(call.getCalleeDecl());
        if ((callee != null)) {
          if (callee.isTrivial()) {
            return true;
          }
        }
      }
      return false;
    }
  }
  assert (isa_ExprWithCleanups(setter));
  return false;
}

//<editor-fold defaultstate="collapsed" desc="UseOptimizedSetter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1138,
 FQN="UseOptimizedSetter", NM="_ZL18UseOptimizedSetterRN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL18UseOptimizedSetterRN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static boolean UseOptimizedSetter(final CodeGenModule /*&*/ CGM) {
  if (CGM.getLangOpts().getGC() != LangOptions.GCMode.NonGC) {
    return false;
  }
  return CGM.getLangOpts().ObjCRuntime.hasOptimizedSetter();
}


/// Like CodeGenFunction::destroyARCStrong, but do it with a call.
//<editor-fold defaultstate="collapsed" desc="destroyARCStrongWithStore">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1359,
 FQN="destroyARCStrongWithStore", NM="_ZL25destroyARCStrongWithStoreRN5clang7CodeGen15CodeGenFunctionENS0_7AddressENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL25destroyARCStrongWithStoreRN5clang7CodeGen15CodeGenFunctionENS0_7AddressENS_8QualTypeE")
//</editor-fold>
public static void destroyARCStrongWithStore(final CodeGenFunction /*&*/ CGF, 
                         Address addr, 
                         QualType type) {
  Value /*P*/ __null = getNullForVariable(new Address(addr));
  CGF.EmitARCStoreStrongCall(new Address(addr), __null, /*ignored*/ true);
}

//<editor-fold defaultstate="collapsed" desc="emitCXXDestructMethod">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1366,
 FQN="emitCXXDestructMethod", NM="_ZL21emitCXXDestructMethodRN5clang7CodeGen15CodeGenFunctionEPNS_22ObjCImplementationDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL21emitCXXDestructMethodRN5clang7CodeGen15CodeGenFunctionEPNS_22ObjCImplementationDeclE")
//</editor-fold>
public static void emitCXXDestructMethod(final CodeGenFunction /*&*/ CGF, 
                     ObjCImplementationDecl /*P*/ impl) {
  CodeGenFunction.RunCleanupsScope scope = null;
  try {
    scope/*J*/= new CodeGenFunction.RunCleanupsScope(CGF);
    
    Value /*P*/ self = CGF.LoadObjCSelf();
    
    /*const*/ ObjCInterfaceDecl /*P*/ iface = impl.getClassInterface();
    for (/*const*/ ObjCIvarDecl /*P*/ ivar = iface.all_declared_ivar_begin$Const();
         (ivar != null); ivar = ivar.getNextIvar$Const()) {
      QualType type = ivar.getType();
      
      // Check whether the ivar is a destructible type.
      QualType.DestructionKind dtorKind = type.isDestructedType();
      if (!(dtorKind.getValue() != 0)) {
        continue;
      }
      
      CodeGenFunction.AddressQualType2Void destroyer = null;
      
      // Use a call to objc_storeStrong to destroy strong ivars, for the
      // general benefit of the tools.
      if (dtorKind == QualType.DestructionKind.DK_objc_strong_lifetime) {
        destroyer = /*$tryClone(*//*FuncRef*/CGObjCStatics::destroyARCStrongWithStore/*)*/;
        // Otherwise use the default for the destruction kind.
      } else {
        destroyer = $tryClone(CGF.getDestroyer(dtorKind));
      }
      
      /*CleanupKind*//*uint*/int cleanupKind = CGF.getCleanupKind(dtorKind);
      ObjCIvarDecl /*P*/ ivar_final = ivar;
      CodeGenFunction.AddressQualType2Void destroyer_final = destroyer;
      CGF.EHStack.<DestroyIvar>pushCleanup$T(cleanupKind, new Supplier<DestroyIvar>() {
        @Override
        public DestroyIvar get() {
          return new DestroyIvar(self, ivar_final, destroyer_final, 
          (cleanupKind & CleanupKind.EHCleanup) == 1);
        }
      });
    }
    assert (scope.requiresCleanups()) : "nothing to do in .cxx_destruct?";
  } finally {
    if (scope != null) { scope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="createARCRuntimeFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1797,
 FQN="createARCRuntimeFunction", NM="_ZL24createARCRuntimeFunctionRN5clang7CodeGen13CodeGenModuleEPN4llvm12FunctionTypeENS3_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL24createARCRuntimeFunctionRN5clang7CodeGen13CodeGenModuleEPN4llvm12FunctionTypeENS3_9StringRefE")
//</editor-fold>
public static Constant /*P*/ createARCRuntimeFunction(final CodeGenModule /*&*/ CGM, 
                        org.llvm.ir.FunctionType /*P*/ type, 
                        StringRef fnName) {
  Constant /*P*/ fn = CGM.CreateRuntimeFunction(type, new StringRef(fnName));
  {
    
    Function /*P*/ f = dyn_cast_Function(fn);
    if ((f != null)) {
      // If the target runtime doesn't naturally support ARC, emit weak
      // references to the runtime support library.  We don't really
      // permit this to fail, but we need a particular relocation style.
      if (!CGM.getLangOpts().ObjCRuntime.hasNativeARC()) {
        f.setLinkage(Function.LinkageTypes.ExternalWeakLinkage);
      } else if ($eq_StringRef(/*NO_COPY*/fnName, /*STRINGREF_STR*/"objc_retain") || $eq_StringRef(/*NO_COPY*/fnName, /*STRINGREF_STR*/"objc_release")) {
        // If we have Native ARC, set nonlazybind attribute for these APIs for
        // performance.
        f.addFnAttr(Attribute.AttrKind.NonLazyBind);
      }
    }
  }
  
  return fn;
}


/// Perform an operation having the signature
///   i8* (i8*)
/// where a null input causes a no-op and returns null.
//<editor-fold defaultstate="collapsed" desc="emitARCValueOperation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1821,
 FQN="emitARCValueOperation", NM="_ZL21emitARCValueOperationRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueERPNS3_8ConstantENS3_9StringRefEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL21emitARCValueOperationRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueERPNS3_8ConstantENS3_9StringRefEb")
//</editor-fold>
public static Value /*P*/ emitARCValueOperation(final CodeGenFunction /*&*/ CGF, 
                     Value /*P*/ value, 
                     final type$ref<Constant /*P*/ /*&*/> fn, 
                     StringRef fnName) {
  return emitARCValueOperation(CGF, 
                     value, 
                     fn, 
                     fnName, 
                     false);
}
public static Value /*P*/ emitARCValueOperation(final CodeGenFunction /*&*/ CGF, 
                     Value /*P*/ value, 
                     final type$ref<Constant /*P*/ /*&*/> fn, 
                     StringRef fnName, 
                     boolean isTailCall/*= false*/) {
  if (isa_ConstantPointerNull(value)) {
    return value;
  }
  if (!(fn.$deref() != null)) {
    org.llvm.ir.FunctionType /*P*/ fnType = org.llvm.ir.FunctionType.get(CGF.Unnamed_field9.Int8PtrTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(CGF.Unnamed_field9.Int8PtrTy, true), false);
    fn.$set(createARCRuntimeFunction(CGF.CGM, fnType, new StringRef(fnName)));
  }
  
  // Cast the argument to 'id'.
  org.llvm.ir.Type /*P*/ origType = value.getType();
  value = CGF.Builder.CreateBitCast(value, CGF.Unnamed_field9.Int8PtrTy);
  
  // Call the function.
  CallInst /*P*/ call = CGF.EmitNounwindRuntimeCall(fn.$deref(), new ArrayRef<Value /*P*/ >(value, true));
  if (isTailCall) {
    call.setTailCall();
  }
  
  // Cast the result back to the original type.
  return CGF.Builder.CreateBitCast(call, origType);
}


/// Perform an operation having the following signature:
///   i8* (i8**)
//<editor-fold defaultstate="collapsed" desc="emitARCLoadOperation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1849,
 FQN="emitARCLoadOperation", NM="_ZL20emitARCLoadOperationRN5clang7CodeGen15CodeGenFunctionENS0_7AddressERPN4llvm8ConstantENS4_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL20emitARCLoadOperationRN5clang7CodeGen15CodeGenFunctionENS0_7AddressERPN4llvm8ConstantENS4_9StringRefE")
//</editor-fold>
public static Value /*P*/ emitARCLoadOperation(final CodeGenFunction /*&*/ CGF, 
                    Address addr, 
                    final type$ref<Constant /*P*/ /*&*/> fn, 
                    StringRef fnName) {
  if (!(fn.$deref() != null)) {
    org.llvm.ir.FunctionType /*P*/ fnType = org.llvm.ir.FunctionType.get(CGF.Unnamed_field9.Int8PtrTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(CGF.Unnamed_field10.Int8PtrPtrTy, true), false);
    fn.$set(createARCRuntimeFunction(CGF.CGM, fnType, new StringRef(fnName)));
  }
  
  // Cast the argument to 'id*'.
  org.llvm.ir.Type /*P*/ origType = addr.getElementType();
  addr.$assignMove(CGF.Builder.CreateBitCast(new Address(addr), CGF.Unnamed_field10.Int8PtrPtrTy));
  
  // Call the function.
  Value /*P*/ result = CGF.EmitNounwindRuntimeCall(fn.$deref(), new ArrayRef<Value /*P*/ >(addr.getPointer(), true));
  
  // Cast the result back to a dereference of the original type.
  if (origType != CGF.Unnamed_field9.Int8PtrTy) {
    result = CGF.Builder.CreateBitCast(result, origType);
  }
  
  return result;
}


/// Perform an operation having the following signature:
///   i8* (i8**, i8*)
//<editor-fold defaultstate="collapsed" desc="emitARCStoreOperation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1875,
 FQN="emitARCStoreOperation", NM="_ZL21emitARCStoreOperationRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEPN4llvm5ValueERPNS4_8ConstantENS4_9StringRefEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL21emitARCStoreOperationRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEPN4llvm5ValueERPNS4_8ConstantENS4_9StringRefEb")
//</editor-fold>
public static Value /*P*/ emitARCStoreOperation(final CodeGenFunction /*&*/ CGF, 
                     Address addr, 
                     Value /*P*/ value, 
                     final type$ref<Constant /*P*/ /*&*/> fn, 
                     StringRef fnName, 
                     boolean ignored) {
  assert (addr.getElementType() == value.getType());
  if (!(fn.$deref() != null)) {
    org.llvm.ir.Type /*P*/ argTypes[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {CGF.Unnamed_field10.Int8PtrPtrTy, CGF.Unnamed_field9.Int8PtrTy};
    
    org.llvm.ir.FunctionType /*P*/ fnType = org.llvm.ir.FunctionType.get(CGF.Unnamed_field9.Int8PtrTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(argTypes, true), false);
    fn.$set(createARCRuntimeFunction(CGF.CGM, fnType, new StringRef(fnName)));
  }
  
  org.llvm.ir.Type /*P*/ origType = value.getType();
  
  Value /*P*/ args[/*2*/] = new Value /*P*/  [/*2*/] {
    CGF.Builder.CreateBitCast(addr.getPointer(), CGF.Unnamed_field10.Int8PtrPtrTy), 
    CGF.Builder.CreateBitCast(value, CGF.Unnamed_field9.Int8PtrTy)
  };
  CallInst /*P*/ result = CGF.EmitNounwindRuntimeCall(fn.$deref(), new ArrayRef<Value /*P*/ >(args, true));
  if (ignored) {
    return null;
  }
  
  return CGF.Builder.CreateBitCast(result, origType);
}


/// Perform an operation having the following signature:
///   void (i8**, i8**)
//<editor-fold defaultstate="collapsed" desc="emitARCCopyOperation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1906,
 FQN="emitARCCopyOperation", NM="_ZL20emitARCCopyOperationRN5clang7CodeGen15CodeGenFunctionENS0_7AddressES3_RPN4llvm8ConstantENS4_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL20emitARCCopyOperationRN5clang7CodeGen15CodeGenFunctionENS0_7AddressES3_RPN4llvm8ConstantENS4_9StringRefE")
//</editor-fold>
public static void emitARCCopyOperation(final CodeGenFunction /*&*/ CGF, 
                    Address dst, 
                    Address src, 
                    final type$ref<Constant /*P*/ /*&*/> fn, 
                    StringRef fnName) {
  assert (dst.getType() == src.getType());
  if (!(fn.$deref() != null)) {
    org.llvm.ir.Type /*P*/ argTypes[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {CGF.Unnamed_field10.Int8PtrPtrTy, CGF.Unnamed_field10.Int8PtrPtrTy};
    
    org.llvm.ir.FunctionType /*P*/ fnType = org.llvm.ir.FunctionType.get(CGF.Builder.getVoidTy(), new ArrayRef<org.llvm.ir.Type /*P*/ >(argTypes, true), false);
    fn.$set(createARCRuntimeFunction(CGF.CGM, fnType, new StringRef(fnName)));
  }
  
  Value /*P*/ args[/*2*/] = new Value /*P*/  [/*2*/] {
    CGF.Builder.CreateBitCast(dst.getPointer(), CGF.Unnamed_field10.Int8PtrPtrTy), 
    CGF.Builder.CreateBitCast(src.getPointer(), CGF.Unnamed_field10.Int8PtrPtrTy)
  };
  CGF.EmitNounwindRuntimeCall(fn.$deref(), new ArrayRef<Value /*P*/ >(args, true));
}

//<editor-fold defaultstate="collapsed" desc="emitAutoreleasedReturnValueMarker">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 1975,
 FQN="emitAutoreleasedReturnValueMarker", NM="_ZL33emitAutoreleasedReturnValueMarkerRN5clang7CodeGen15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL33emitAutoreleasedReturnValueMarkerRN5clang7CodeGen15CodeGenFunctionE")
//</editor-fold>
public static void emitAutoreleasedReturnValueMarker(final CodeGenFunction /*&*/ CGF) {
  // Fetch the void(void) inline asm which marks that we're going to
  // do something with the autoreleased return value.
  final type$ref<InlineAsm /*P*/ /*&*/> marker = CGF.CGM.getObjCEntrypoints().retainAutoreleasedReturnValueMarker_ref;
  if (!(marker.$deref() != null)) {
    StringRef assembly = CGF.CGM.getTargetCodeGenInfo().
        getARCRetainAutoreleasedReturnValueMarker();
    
    // If we have an empty assembly string, there's nothing to do.
    if (assembly.empty()) {
      // Otherwise, at -O0, build an inline asm that we're going to call
      // in a moment.
    } else if ($2bits_uint2uint(CGF.CGM.getCodeGenOpts().OptimizationLevel) == 0) {
      org.llvm.ir.FunctionType /*P*/ type = org.llvm.ir.FunctionType.get(CGF.VoidTy, /*variadic*/ false);
      
      marker.$set(InlineAsm.get(type, new StringRef(assembly), new StringRef(/*KEEP_STR*/$EMPTY), /*sideeffects*/ true));
      // If we're at -O1 and above, we don't want to litter the code
      // with this marker yet, so leave a breadcrumb for the ARC
      // optimizer to pick up.
    } else {
      NamedMDNode /*P*/ metadata = CGF.CGM.getModule().getOrInsertNamedMetadata(new StringRef(/*KEEP_STR*/"clang.arc.retainAutoreleasedReturnValueMarker"));
      assert ($lesseq_uint(metadata.getNumOperands(), 1));
      if (metadata.getNumOperands() == 0) {
        final LLVMContext /*&*/ ctx = CGF.getLLVMContext();
        metadata.addOperand(MDNode.get(ctx, 
                new ArrayRef<Metadata /*P*/ >(MDString.get(ctx, new StringRef(assembly)), true)));
      }
    }
  }
  
  // Call the marker asm if we made one, which we do only at -O0.
  if ((marker.$deref() != null)) {
    CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(marker.$deref());
  }
}

//<editor-fold defaultstate="collapsed" desc="tryEmitARCRetainLoadOfScalar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2403,
 FQN="tryEmitARCRetainLoadOfScalar", NM="_ZL28tryEmitARCRetainLoadOfScalarRN5clang7CodeGen15CodeGenFunctionENS0_6LValueENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL28tryEmitARCRetainLoadOfScalarRN5clang7CodeGen15CodeGenFunctionENS0_6LValueENS_8QualTypeE")
//</editor-fold>
public static PointerBoolPair<Value /*P*/ > tryEmitARCRetainLoadOfScalar(final CodeGenFunction /*&*/ CGF, 
                            LValue lvalue, 
                            QualType type) {
  switch (type.getObjCLifetime()) {
   case OCL_None:
   case OCL_ExplicitNone:
   case OCL_Strong:
   case OCL_Autoreleasing:
    return new PointerBoolPair<Value /*P*/ >(CGF.EmitLoadOfLValue(new LValue(lvalue), 
            new SourceLocation()).getScalarVal(), 
        false);
   case OCL_Weak:
    return new PointerBoolPair<Value /*P*/ >(CGF.EmitARCLoadWeakRetained(lvalue.getAddress()), 
        true);
  }
  throw new llvm_unreachable("impossible lifetime!");
}

//<editor-fold defaultstate="collapsed" desc="tryEmitARCRetainLoadOfScalar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2423,
 FQN="tryEmitARCRetainLoadOfScalar", NM="_ZL28tryEmitARCRetainLoadOfScalarRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL28tryEmitARCRetainLoadOfScalarRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE")
//</editor-fold>
public static PointerBoolPair<Value /*P*/ > tryEmitARCRetainLoadOfScalar(final CodeGenFunction /*&*/ CGF, 
                            /*const*/ Expr /*P*/ e) {
  e = e.IgnoreParens$Const();
  QualType type = e.getType();
  
  // If we're loading retained from a __strong xvalue, we can avoid 
  // an extra retain/release pair by zeroing out the source of this
  // "move" operation.
  if (e.isXValue()
     && !type.isConstQualified()
     && type.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Strong) {
    // Emit the lvalue.
    LValue lv = CGF.EmitLValue(e);
    
    // Load the object pointer.
    Value /*P*/ result = CGF.EmitLoadOfLValue(new LValue(lv), 
        new SourceLocation()).getScalarVal();
    
    // Set the source pointer to NULL.
    CGF.EmitStoreOfScalar(getNullForVariable(lv.getAddress()), new LValue(lv));
    
    return new PointerBoolPair<Value /*P*/ >(result, true);
  }
  
  // As a very special optimization, in ARC++, if the l-value is the
  // result of a non-volatile assignment, do a simple retain of the
  // result of the call to objc_storeWeak instead of reloading.
  if (CGF.getLangOpts().CPlusPlus
     && !type.isVolatileQualified()
     && type.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Weak
     && isa_BinaryOperator(e)
     && cast_BinaryOperator(e).getOpcode() == BinaryOperatorKind.BO_Assign) {
    return new PointerBoolPair<Value /*P*/ >(CGF.EmitScalarExpr(e), false);
  }
  
  return tryEmitARCRetainLoadOfScalar(CGF, CGF.EmitLValue(e), new QualType(type));
}


/// Insert code immediately after a call.
//<editor-fold defaultstate="collapsed" desc="emitARCOperationAfterCall">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2465,
 FQN="emitARCOperationAfterCall", NM="_ZL25emitARCOperationAfterCallRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS3_12function_refIFS5_S2_S5_EEES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL25emitARCOperationAfterCallRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS3_12function_refIFS5_S2_S5_EEES8_")
//</editor-fold>
public static Value /*P*/ emitARCOperationAfterCall(final CodeGenFunction /*&*/ CGF, 
                         Value /*P*/ value, 
                         CodeGenFunction.Value2Value doAfterCall, 
                         CodeGenFunction.Value2Value doFallback) {
  {
    CallInst /*P*/ call = dyn_cast_CallInst(value);
    if ((call != null)) {
      CGBuilderTy.InsertPoint ip = CGF.Builder.saveIP();
      
      // Place the retain immediately following the call.
      CGF.Builder.SetInsertPoint(call.getParent(), 
          new ilist_iterator<Instruction>(new ilist_iterator<Instruction>(call, ilist_traits_IR.ilist_traits$Instruction()).$preInc()));
      value = doAfterCall.$call(CGF, value);
      
      CGF.Builder.restoreIP(new IRBuilderBase.InsertPoint(ip));
      return value;
    } else {
      InvokeInst /*P*/ invoke = dyn_cast_InvokeInst(value);
      if ((invoke != null)) {
        CGBuilderTy.InsertPoint ip = CGF.Builder.saveIP();
        
        // Place the retain at the beginning of the normal destination block.
        BasicBlock /*P*/ BB = invoke.getNormalDest();
        CGF.Builder.SetInsertPoint(BB, BB.begin());
        value = doAfterCall.$call(CGF, value);
        
        CGF.Builder.restoreIP(new IRBuilderBase.InsertPoint(ip));
        return value;
        // Bitcasts can arise because of related-result returns.  Rewrite
        // the operand.
      } else {
        BitCastInst /*P*/ bitcast = dyn_cast_BitCastInst(value);
        if ((bitcast != null)) {
          Value /*P*/ operand = bitcast.getOperand(0);
          operand = emitARCOperationAfterCall(CGF, operand, /*FuncArg*/doAfterCall, /*FuncArg*/doFallback);
          bitcast.setOperand(0, operand);
          return bitcast;
          // Generic fall-back case.
        } else {
          // Retain using the non-block variant: we never need to do a copy
          // of a block that's been returned to us.
          return doFallback.$call(CGF, value);
        }
      }
    }
  }
}


/// Given that the given expression is some sort of call (which does
/// not return retained), emit a retain following it.
//<editor-fold defaultstate="collapsed" desc="emitARCRetainCallResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2508,
 FQN="emitARCRetainCallResult", NM="_ZL23emitARCRetainCallResultRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL23emitARCRetainCallResultRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE")
//</editor-fold>
public static Value /*P*/ emitARCRetainCallResult(final CodeGenFunction /*&*/ CGF, 
                       /*const*/ Expr /*P*/ e) {
  Value /*P*/ value = CGF.EmitScalarExpr(e);
  return emitARCOperationAfterCall(CGF, value, 
      /*FuncArg*//*[]*/ (final CodeGenFunction /*&*/ CGF$1, Value /*P*/ value$1) -> {
            return CGF$1.EmitARCRetainAutoreleasedReturnValue(value$1);
          }, 
      /*FuncArg*//*[]*/ (final CodeGenFunction /*&*/ CGF$1, Value /*P*/ value$1) -> {
            return CGF$1.EmitARCRetainNonBlock(value$1);
          });
}


/// Given that the given expression is some sort of call (which does
/// not return retained), perform an unsafeClaim following it.
//<editor-fold defaultstate="collapsed" desc="emitARCUnsafeClaimCallResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2522,
 FQN="emitARCUnsafeClaimCallResult", NM="_ZL28emitARCUnsafeClaimCallResultRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL28emitARCUnsafeClaimCallResultRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE")
//</editor-fold>
public static Value /*P*/ emitARCUnsafeClaimCallResult(final CodeGenFunction /*&*/ CGF, 
                            /*const*/ Expr /*P*/ e) {
  Value /*P*/ value = CGF.EmitScalarExpr(e);
  return emitARCOperationAfterCall(CGF, value, 
      /*FuncArg*//*[]*/ (final CodeGenFunction /*&*/ CGF$1, Value /*P*/ value$1) -> {
            return CGF$1.EmitARCUnsafeClaimAutoreleasedReturnValue(value$1);
          }, 
      /*FuncArg*//*[]*/ (final CodeGenFunction /*&*/ CGF$1, Value /*P*/ value$1) -> {
            return value$1;
          });
}


/// Determine whether it might be important to emit a separate
/// objc_retain_block on the result of the given expression, or
/// whether it's okay to just emit it in a +1 context.
//<editor-fold defaultstate="collapsed" desc="shouldEmitSeparateBlockRetain">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2548,
 FQN="shouldEmitSeparateBlockRetain", NM="_ZL29shouldEmitSeparateBlockRetainPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL29shouldEmitSeparateBlockRetainPKN5clang4ExprE")
//</editor-fold>
public static boolean shouldEmitSeparateBlockRetain(/*const*/ Expr /*P*/ e) {
  assert (e.getType().$arrow().isBlockPointerType());
  e = e.IgnoreParens$Const();
  
  // For future goodness, emit block expressions directly in +1
  // contexts if we can.
  if (isa_BlockExpr(e)) {
    return false;
  }
  {
    
    /*const*/ CastExpr /*P*/ cast = dyn_cast_CastExpr(e);
    if ((cast != null)) {
      switch (cast.getCastKind()) {
       case CK_LValueToRValue:
       case CK_ARCReclaimReturnedObject:
       case CK_ARCConsumeObject:
       case CK_ARCProduceObject:
        // Emitting these operations in +1 contexts is goodness.
        return false;
       case CK_NoOp:
       case CK_BitCast:
        
        // These operations preserve a block type.
        return shouldEmitSeparateBlockRetain(cast.getSubExpr$Const());
       case CK_AnyPointerToBlockPointerCast:
       default:
        
        // These operations are known to be bad (or haven't been considered).
        return true;
      }
    }
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="emitARCUnsafeUnretainedScalarExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 3038,
 FQN="emitARCUnsafeUnretainedScalarExpr", NM="_ZL33emitARCUnsafeUnretainedScalarExprRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZL33emitARCUnsafeUnretainedScalarExprRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE")
//</editor-fold>
public static Value /*P*/ emitARCUnsafeUnretainedScalarExpr(final CodeGenFunction /*&*/ CGF, 
                                 /*const*/ Expr /*P*/ e) {
  return new ARCUnsafeUnretainedExprEmitter(CGF).visit(e);
}

} // END OF class CGObjCStatics
