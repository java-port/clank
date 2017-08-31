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
import org.llvm.ir.java.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.CharUnitsGlobals.*;
import org.clang.ast.DeclContext.specific_decl_iterator;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.support.AdtsupportLlvmGlobals;


//<editor-fold defaultstate="collapsed" desc="static type CGExprStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.impl.CGExprStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL15emitHash16BytesRN5clang7CodeGen11CGBuilderTyEPN4llvm5ValueES5_;_ZL15getRangeForTypeRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeERN4llvm5APIntES6_b;_ZL18getRecoverableKindy;_ZL20emitCheckHandlerCallRN5clang7CodeGen15CodeGenFunctionEPN4llvm12FunctionTypeENS3_8ArrayRefIPNS3_5ValueEEENS3_9StringRefEN12_GLOBAL__N_120CheckRecoverableKindEbPNS3_10BasicBlockE;_ZL20emitPseudoObjectExprRN5clang7CodeGen15CodeGenFunctionEPKNS_16PseudoObjectExprEbNS0_12AggValueSlotE;_ZL20getArrayElementAlignN5clang9CharUnitsEPN4llvm5ValueES0_;_ZL20pushTemporaryCleanupRN5clang7CodeGen15CodeGenFunctionEPKNS_24MaterializeTemporaryExprEPKNS_4ExprENS0_7AddressE;_ZL20setObjCGCLValueClassRKN5clang10ASTContextEPKNS_4ExprERNS_7CodeGen6LValueEb;_ZL21emitArraySubscriptGEPRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEN4llvm8ArrayRefIPNS4_5ValueEEENS_8QualTypeEbRKNS4_5TwineE;_ZL21emitArraySubscriptGEPRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS3_8ArrayRefIS5_EEbRKNS3_5TwineE;_ZL21getArrayIndexingBoundRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprERNS_8QualTypeE;_ZL22EmitFunctionDeclLValueRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprEPKNS_12FunctionDeclE;_ZL22emitAddrOfFieldStorageRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEPKNS_9FieldDeclE;_ZL23EmitCapturedFieldLValueRN5clang7CodeGen15CodeGenFunctionEPKNS_9FieldDeclEPN4llvm5ValueE;_ZL23EmitGlobalNamedRegisterPKN5clang7VarDeclERNS_7CodeGen13CodeGenModuleE;_ZL23EmitGlobalVarDeclLValueRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprEPKNS_7VarDeclE;_ZL23emitOMPArraySectionBaseRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprERNS0_15AlignmentSourceENS_8QualTypeES8_b;_ZL23getFixedSizeElementTypeRKN5clang10ASTContextEPKNS_17VariableArrayTypeE;_ZL24createReferenceTemporaryRN5clang7CodeGen15CodeGenFunctionEPKNS_24MaterializeTemporaryExprEPKNS_4ExprE;_ZL24hasBooleanRepresentationN5clang8QualTypeE;_ZL25isFlexibleArrayMemberExprPKN5clang4ExprE;_ZL25isSimpleArrayDecayOperandPKN5clang4ExprE;_ZL27EmitLValueOrThrowExpressionRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE;_ZL29isConstantEmittableObjectTypeN5clang8QualTypeE;_ZL30EmitThreadPrivateVarDeclLValueRN5clang7CodeGen15CodeGenFunctionEPKNS_7VarDeclENS_8QualTypeENS0_7AddressEPN4llvm4TypeENS_14SourceLocationE;_ZL31EmitBitCastOfLValueToProperTypeRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueEPNS3_4TypeENS3_9StringRefE;_ZL31checkVarTypeForConstantEmissionN5clang8QualTypeE; -static-type=CGExprStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGExprStatics {

//<editor-fold defaultstate="collapsed" desc="pushTemporaryCleanup">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 198,
 FQN="pushTemporaryCleanup", NM="_ZL20pushTemporaryCleanupRN5clang7CodeGen15CodeGenFunctionEPKNS_24MaterializeTemporaryExprEPKNS_4ExprENS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL20pushTemporaryCleanupRN5clang7CodeGen15CodeGenFunctionEPKNS_24MaterializeTemporaryExprEPKNS_4ExprENS0_7AddressE")
//</editor-fold>
public static void pushTemporaryCleanup(final CodeGenFunction /*&*/ CGF, /*const*/ MaterializeTemporaryExpr /*P*/ M, 
                    /*const*/ Expr /*P*/ E, Address ReferenceTemporary) {
  {
    // Objective-C++ ARC:
    //   If we are binding a reference to a temporary that has ownership, we
    //   need to perform retain/release operations on the temporary.
    //
    // FIXME: This should be looking at E, not M.
    Qualifiers.ObjCLifetime Lifetime = M.getType().getObjCLifetime();
    if ((Lifetime.getValue() != 0)) {
      switch (Lifetime) {
       case OCL_None:
       case OCL_ExplicitNone:
        // Carry on to normal cleanup handling.
        break;
       case OCL_Autoreleasing:
        // Nothing to do; cleaned up by an autorelease pool.
        return;
       case OCL_Strong:
       case OCL_Weak:
        {
          StorageDuration Duration = M.getStorageDuration();
          switch (Duration) {
           case SD_Static:
            // Note: we intentionally do not register a cleanup to release
            // the object on program termination.
            return;
           case SD_Thread:
            // FIXME: We should probably register a cleanup in this case.
            return;
           case SD_Automatic:
           case SD_FullExpression:
            CodeGenFunction.AddressQualType2Void Destroy;
            /*CleanupKind*//*uint*/int _CleanupKind;
            if (Lifetime == Qualifiers.ObjCLifetime.OCL_Strong) {
              /*const*/ ValueDecl /*P*/ VD = M.getExtendingDecl();
              boolean Precise = (VD != null) && isa_VarDecl(VD) && VD.hasAttr(ObjCPreciseLifetimeAttr.class);
              _CleanupKind = CGF.getARCCleanupKind();
              Destroy = Precise ? /*AddrOf*//*FPtr*/CodeGenFunction_CGObjC::destroyARCStrongPrecise : /*AddrOf*//*FPtr*/CodeGenFunction_CGObjC::destroyARCStrongImprecise;
            } else {
              // __weak objects always get EH cleanups; otherwise, exceptions
              // could cause really nasty crashes instead of mere leaks.
              _CleanupKind = CleanupKind.NormalAndEHCleanup;
              Destroy = /*AddrOf*//*FPtr*/CodeGenFunction_CGObjC::destroyARCWeak;
            }
            if (Duration == StorageDuration.SD_FullExpression) {
              CGF.pushDestroy(_CleanupKind, new Address(ReferenceTemporary), 
                  M.getType(), /*FuncRef*/Destroy, 
                  ((_CleanupKind & CleanupKind.EHCleanup) != 0));
            } else {
              CGF.pushLifetimeExtendedDestroy(_CleanupKind, new Address(ReferenceTemporary), 
                  M.getType(), 
                  /*FuncRef*/Destroy, ((_CleanupKind & CleanupKind.EHCleanup) != 0));
            }
            return;
           case SD_Dynamic:
            throw new llvm_unreachable("temporary cannot have dynamic storage duration");
          }
        }
        throw new llvm_unreachable("unknown storage duration");
      }
    }
  }
  
  CXXDestructorDecl /*P*/ ReferenceTemporaryDtor = null;
  {
    /*const*/ RecordType /*P*/ RT = E.getType().$arrow().getBaseElementTypeUnsafe().getAs$RecordType();
    if ((RT != null)) {
      // Get the destructor for the reference temporary.
      CXXRecordDecl /*P*/ ClassDecl = cast_CXXRecordDecl(RT.getDecl());
      if (!ClassDecl.hasTrivialDestructor()) {
        ReferenceTemporaryDtor = ClassDecl.getDestructor();
      }
    }
  }
  if (!(ReferenceTemporaryDtor != null)) {
    return;
  }
  
  // Call the destructor for the temporary.
  switch (M.getStorageDuration()) {
   case SD_Static:
   case SD_Thread:
    {
      Constant /*P*/ CleanupFn;
      Constant /*P*/ CleanupArg;
      if (E.getType().$arrow().isArrayType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(CleanupFn = $c$.track(new CodeGenFunction(CGF.CGM)).generateDestroyHelper(new Address(ReferenceTemporary), E.getType(), 
              /*FuncRef*/CodeGenFunction::destroyCXXObject, CGF.getLangOpts().Exceptions, 
              dyn_cast_or_null_VarDecl(M.getExtendingDecl())));
          CleanupArg = Constant.getNullValue(CGF.Unnamed_field9.Int8PtrTy);
        } finally {
          $c$.$destroy();
        }
      } else {
        CleanupFn = CGF.CGM.getAddrOfCXXStructor(ReferenceTemporaryDtor, 
            StructorType.Complete);
        CleanupArg = cast_Constant(ReferenceTemporary.getPointer());
      }
      CGF.CGM.getCXXABI().registerGlobalDtor(CGF, $Deref(cast_VarDecl(M.getExtendingDecl())), CleanupFn, CleanupArg);
      break;
    }
   case SD_FullExpression:
    CGF.pushDestroy(CleanupKind.NormalAndEHCleanup, new Address(ReferenceTemporary), E.getType(), 
        /*FuncRef*/CodeGenFunction::destroyCXXObject, 
        CGF.getLangOpts().Exceptions);
    break;
   case SD_Automatic:
    CGF.pushLifetimeExtendedDestroy(CleanupKind.NormalAndEHCleanup, 
        new Address(ReferenceTemporary), E.getType(), 
        /*FuncRef*/CodeGenFunction::destroyCXXObject, 
        CGF.getLangOpts().Exceptions);
    break;
   case SD_Dynamic:
    throw new llvm_unreachable("temporary cannot have dynamic storage duration");
  }
}

//<editor-fold defaultstate="collapsed" desc="createReferenceTemporary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 315,
 FQN="createReferenceTemporary", NM="_ZL24createReferenceTemporaryRN5clang7CodeGen15CodeGenFunctionEPKNS_24MaterializeTemporaryExprEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL24createReferenceTemporaryRN5clang7CodeGen15CodeGenFunctionEPKNS_24MaterializeTemporaryExprEPKNS_4ExprE")
//</editor-fold>
public static Address createReferenceTemporary(final CodeGenFunction /*&*/ CGF, 
                        /*const*/ MaterializeTemporaryExpr /*P*/ M, /*const*/ Expr /*P*/ Inner) {
  switch (M.getStorageDuration()) {
   case SD_FullExpression:
   case SD_Automatic:
    {
      // If we have a constant temporary array or record try to promote it into a
      // constant global under the same rules a normal constant would've been
      // promoted. This is easier on the optimizer and generally emits fewer
      // instructions.
      QualType Ty = Inner.getType();
      if (CGF.CGM.getCodeGenOpts().MergeAllConstants
         && (Ty.$arrow().isArrayType() || Ty.$arrow().isRecordType())
         && CGF.CGM.isTypeConstant(new QualType(Ty), true)) {
        {
          Constant /*P*/ Init = CGF.CGM.EmitConstantExpr(Inner, new QualType(Ty), $AddrOf(CGF));
          if ((Init != null)) {
            GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
                return new GlobalVariable(CGF.CGM.getModule(), Init.getType(), /*isConstant=*/ true, 
                GlobalValue.LinkageTypes.PrivateLinkage, Init, new Twine(/*KEEP_STR*/".ref.tmp"));
             });
            CharUnits alignment = CGF.getContext().getTypeAlignInChars(new QualType(Ty));
            GV.setAlignment($long2uint(alignment.getQuantity()));
            // FIXME: Should we put the new global into a COMDAT?
            return new Address(GV, new CharUnits(alignment));
          }
        }
      }
      return CGF.CreateMemTemp(new QualType(Ty), new Twine(/*KEEP_STR*/"ref.tmp"));
    }
   case SD_Thread:
   case SD_Static:
    return new Address(JD$Move.INSTANCE, CGF.CGM.GetAddrOfGlobalTemporary(M, Inner));
   case SD_Dynamic:
    throw new llvm_unreachable("temporary can't have dynamic storage duration");
  }
  throw new llvm_unreachable("unknown storage duration");
}


/// Emit the hash_16_bytes function from include/llvm/ADT/Hashing.h.
//<editor-fold defaultstate="collapsed" desc="emitHash16Bytes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 514,
 FQN="emitHash16Bytes", NM="_ZL15emitHash16BytesRN5clang7CodeGen11CGBuilderTyEPN4llvm5ValueES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL15emitHash16BytesRN5clang7CodeGen11CGBuilderTyEPN4llvm5ValueES5_")
//</editor-fold>
public static Value /*P*/ emitHash16Bytes(final CGBuilderTy /*&*/ Builder, Value /*P*/ Low, 
               Value /*P*/ High) {
  Value /*P*/ KMul = Builder.getInt64(0x9ddfea08eb382d69L/*ULL*/);
  Value /*P*/ K47 = Builder.getInt64($int2ulong(47));
  Value /*P*/ A0 = Builder.CreateMul(Builder.CreateXor(Low, High), KMul);
  Value /*P*/ A1 = Builder.CreateXor(Builder.CreateLShr(A0, K47), A0);
  Value /*P*/ B0 = Builder.CreateMul(Builder.CreateXor(High, A1), KMul);
  Value /*P*/ B1 = Builder.CreateXor(Builder.CreateLShr(B0, K47), B0);
  return Builder.CreateMul(B1, KMul);
}


/// Determine whether this expression refers to a flexible array member in a
/// struct. We disable array bounds checks for such members.
//<editor-fold defaultstate="collapsed" desc="isFlexibleArrayMemberExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 690,
 FQN="isFlexibleArrayMemberExpr", NM="_ZL25isFlexibleArrayMemberExprPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL25isFlexibleArrayMemberExprPKN5clang4ExprE")
//</editor-fold>
public static boolean isFlexibleArrayMemberExpr(/*const*/ Expr /*P*/ E) {
  // For compatibility with existing code, we treat arrays of length 0 or
  // 1 as flexible array members.
  /*const*/ org.clang.ast.ArrayType /*P*/ AT = E.getType().$arrow().castAsArrayTypeUnsafe();
  {
    /*const*/ org.clang.ast.ConstantArrayType /*P*/ CAT = dyn_cast_ConstantArrayType(AT);
    if ((CAT != null)) {
      if (CAT.getSize().ugt($int2ulong(1))) {
        return false;
      }
    } else if (!isa_IncompleteArrayType(AT)) {
      return false;
    }
  }
  
  E = E.IgnoreParens$Const();
  {
    
    // A flexible array member must be the last member in the class.
    /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E);
    if ((ME != null)) {
      {
        // FIXME: If the base type of the member expr is not FD->getParent(),
        // this should not be treated as a flexible array member access.
        /*const*/ FieldDecl /*P*/ FD = dyn_cast_FieldDecl(ME.getMemberDecl());
        if ((FD != null)) {
          DeclContext.specific_decl_iterator<FieldDecl> FI/*J*/= new DeclContext.specific_decl_iterator<FieldDecl>(FieldDecl.class, new DeclContext.decl_iterator(((/*const_cast*/FieldDecl /*P*/ )(FD))));
          return specific_decl_iterator.$eq_specific_decl_iterator$SpecificDecl$C(FI.$preInc(), FD.getParent$Const().field_end());
        }
      }
    }
  }
  
  return false;
}


/// If Base is known to point to the start of an array, return the length of
/// that array. Return 0 if the length cannot be determined.
//<editor-fold defaultstate="collapsed" desc="getArrayIndexingBound">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 718,
 FQN="getArrayIndexingBound", NM="_ZL21getArrayIndexingBoundRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprERNS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL21getArrayIndexingBoundRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprERNS_8QualTypeE")
//</editor-fold>
public static Value /*P*/ getArrayIndexingBound(final CodeGenFunction /*&*/ CGF, /*const*/ Expr /*P*/ Base, final QualType /*&*/ IndexedType) {
  {
    // For the vector indexing extension, the bound is the number of elements.
    /*const*/ org.clang.ast.VectorType /*P*/ VT = Base.getType().$arrow().getAs(org.clang.ast.VectorType.class);
    if ((VT != null)) {
      IndexedType.$assignMove(Base.getType());
      return CGF.Builder.getInt32(VT.getNumElements());
    }
  }
  
  Base = Base.IgnoreParens$Const();
  {
    
    /*const*/ CastExpr /*P*/ CE = dyn_cast_CastExpr(Base);
    if ((CE != null)) {
      if (CE.getCastKind() == CastKind.CK_ArrayToPointerDecay
         && !isFlexibleArrayMemberExpr(CE.getSubExpr$Const())) {
        IndexedType.$assignMove(CE.getSubExpr$Const().getType());
        /*const*/ org.clang.ast.ArrayType /*P*/ AT = IndexedType.$arrow().castAsArrayTypeUnsafe();
        {
          /*const*/ org.clang.ast.ConstantArrayType /*P*/ CAT = dyn_cast_ConstantArrayType(AT);
          if ((CAT != null)) {
            return CGF.Builder.getInt(CAT.getSize());
          } else {
            /*const*/ VariableArrayType /*P*/ VAT = dyn_cast_VariableArrayType(AT);
            if ((VAT != null)) {
              return CGF.getVLASize(VAT).first;
            }
          }
        }
      }
    }
  }
  
  return null;
}


/// Given an object of the given canonical type, can we safely copy a
/// value out of it based on its initializer?
//<editor-fold defaultstate="collapsed" desc="isConstantEmittableObjectType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1086,
 FQN="isConstantEmittableObjectType", NM="_ZL29isConstantEmittableObjectTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL29isConstantEmittableObjectTypeN5clang8QualTypeE")
//</editor-fold>
public static boolean isConstantEmittableObjectType(QualType type) {
  assert (type.isCanonical());
  assert (!type.$arrow().isReferenceType());
  
  // Must be const-qualified but non-volatile.
  Qualifiers qs = type.getLocalQualifiers();
  if (!qs.hasConst() || qs.hasVolatile()) {
    return false;
  }
  {
    
    // Otherwise, all object types satisfy this except C++ classes with
    // mutable subobjects or non-trivial copy/destroy behavior.
    /*const*/ RecordType /*P*/ RT = dyn_cast_RecordType(type);
    if ((RT != null)) {
      {
        /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(RT.getDecl());
        if ((RD != null)) {
          if (RD.hasMutableFields() || !RD.isTrivial()) {
            return false;
          }
        }
      }
    }
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="checkVarTypeForConstantEmission">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1117,
 FQN="checkVarTypeForConstantEmission", NM="_ZL31checkVarTypeForConstantEmissionN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL31checkVarTypeForConstantEmissionN5clang8QualTypeE")
//</editor-fold>
public static ConstantEmissionKind checkVarTypeForConstantEmission(QualType type) {
  type.$assignMove(type.getCanonicalType());
  {
    /*const*/ ReferenceType /*P*/ ref = dyn_cast_ReferenceType(type);
    if ((ref != null)) {
      if (isConstantEmittableObjectType(ref.getPointeeType())) {
        return ConstantEmissionKind.CEK_AsValueOrReference;
      }
      return ConstantEmissionKind.CEK_AsReferenceOnly;
    }
  }
  if (isConstantEmittableObjectType(new QualType(type))) {
    return ConstantEmissionKind.CEK_AsValueOnly;
  }
  return ConstantEmissionKind.CEK_None;
}

//<editor-fold defaultstate="collapsed" desc="hasBooleanRepresentation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1205,
 FQN="hasBooleanRepresentation", NM="_ZL24hasBooleanRepresentationN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL24hasBooleanRepresentationN5clang8QualTypeE")
//</editor-fold>
public static boolean hasBooleanRepresentation(QualType Ty) {
  if (Ty.$arrow().isBooleanType()) {
    return true;
  }
  {
    
    /*const*/ EnumType /*P*/ ET = Ty.$arrow().getAs$EnumType();
    if ((ET != null)) {
      return ET.getDecl().getIntegerType().$arrow().isBooleanType();
    }
  }
  {
    
    /*const*/ AtomicType /*P*/ AT = Ty.$arrow().getAs(AtomicType.class);
    if ((AT != null)) {
      return hasBooleanRepresentation(AT.getValueType());
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="getRangeForType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1218,
 FQN="getRangeForType", NM="_ZL15getRangeForTypeRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeERN4llvm5APIntES6_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL15getRangeForTypeRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeERN4llvm5APIntES6_b")
//</editor-fold>
public static boolean getRangeForType(final CodeGenFunction /*&*/ CGF, QualType Ty, 
               final APInt /*&*/ Min, final APInt /*&*/ End, 
               boolean StrictEnums) {
  /*const*/ EnumType /*P*/ ET = Ty.$arrow().getAs$EnumType();
  boolean IsRegularCPlusPlusEnum = CGF.getLangOpts().CPlusPlus && StrictEnums
     && (ET != null) && !ET.getDecl().isFixed();
  boolean IsBool = hasBooleanRepresentation(new QualType(Ty));
  if (!IsBool && !IsRegularCPlusPlusEnum) {
    return false;
  }
  if (IsBool) {
    Min.$assignMove(new APInt(JD$UInt_ULong.INSTANCE, $ulong2uint(CGF.getContext().getTypeSize(new QualType(Ty))), $int2ulong(0)));
    End.$assignMove(new APInt(JD$UInt_ULong.INSTANCE, $ulong2uint(CGF.getContext().getTypeSize(new QualType(Ty))), $int2ulong(2)));
  } else {
    /*const*/ EnumDecl /*P*/ ED = ET.getDecl();
    org.llvm.ir.Type /*P*/ LTy = CGF.ConvertTypeForMem(ED.getIntegerType());
    /*uint*/int Bitwidth = LTy.getScalarSizeInBits();
    /*uint*/int NumNegativeBits = ED.getNumNegativeBits();
    /*uint*/int NumPositiveBits = ED.getNumPositiveBits();
    if ((NumNegativeBits != 0)) {
      /*uint*/int NumBits = std.max(NumNegativeBits, NumPositiveBits + 1);
      assert ($lesseq_uint(NumBits, Bitwidth));
      End.$assignMove(new APInt(JD$UInt_ULong.INSTANCE, Bitwidth, $int2ulong(1)).$out((NumBits - 1)));
      Min.$assignMove(End.$sub());
    } else {
      assert ($lesseq_uint(NumPositiveBits, Bitwidth));
      End.$assignMove(new APInt(JD$UInt_ULong.INSTANCE, Bitwidth, $int2ulong(1)).$out(NumPositiveBits));
      Min.$assignMove(new APInt(JD$UInt_ULong.INSTANCE, Bitwidth, $int2ulong(0)));
    }
  }
  return true;
}


// setObjCGCLValueClass - sets class of the lvalue for the purpose of
// generating write-barries API. It is currently a global, ivar,
// or neither.
//<editor-fold defaultstate="collapsed" desc="setObjCGCLValueClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1845,
 FQN="setObjCGCLValueClass", NM="_ZL20setObjCGCLValueClassRKN5clang10ASTContextEPKNS_4ExprERNS_7CodeGen6LValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL20setObjCGCLValueClassRKN5clang10ASTContextEPKNS_4ExprERNS_7CodeGen6LValueEb")
//</editor-fold>
public static void setObjCGCLValueClass(final /*const*/ ASTContext /*&*/ Ctx, /*const*/ Expr /*P*/ E, 
                    final LValue /*&*/ LV) {
  setObjCGCLValueClass(Ctx, E, 
                    LV, 
                    false);
}
public static void setObjCGCLValueClass(final /*const*/ ASTContext /*&*/ Ctx, /*const*/ Expr /*P*/ E, 
                    final LValue /*&*/ LV, 
                    boolean IsMemberAccess/*= false*/) {
  if (Ctx.getLangOpts().getGC() == LangOptions.GCMode.NonGC) {
    return;
  }
  if (isa_ObjCIvarRefExpr(E)) {
    QualType ExpTy = E.getType();
    if (IsMemberAccess && ExpTy.$arrow().isPointerType()) {
      // If ivar is a structure pointer, assigning to field of
      // this struct follows gcc's behavior and makes it a non-ivar
      // writer-barrier conservatively.
      ExpTy.$assignMove(ExpTy.$arrow().getAs(org.clang.ast.PointerType.class).getPointeeType());
      if (ExpTy.$arrow().isRecordType()) {
        LV.setObjCIvar(false);
        return;
      }
    }
    LV.setObjCIvar(true);
    ObjCIvarRefExpr /*P*/ Exp = cast_ObjCIvarRefExpr(((/*const_cast*/Expr /*P*/ )(E)));
    LV.setBaseIvarExp(Exp.getBase());
    LV.setObjCArray(E.getType().$arrow().isArrayType());
    return;
  }
  {
    
    /*const*/ DeclRefExpr /*P*/ Exp = dyn_cast_DeclRefExpr(E);
    if ((Exp != null)) {
      {
        /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(Exp.getDecl$Const());
        if ((VD != null)) {
          if (VD.hasGlobalStorage()) {
            LV.setGlobalObjCRef(true);
            LV.setThreadLocalRef(VD.getTLSKind() != VarDecl.TLSKind.TLS_None);
          }
        }
      }
      LV.setObjCArray(E.getType().$arrow().isArrayType());
      return;
    }
  }
  {
    
    /*const*/ UnaryOperator /*P*/ Exp = dyn_cast_UnaryOperator(E);
    if ((Exp != null)) {
      setObjCGCLValueClass(Ctx, Exp.getSubExpr(), LV, IsMemberAccess);
      return;
    }
  }
  {
    
    /*const*/ ParenExpr /*P*/ Exp = dyn_cast_ParenExpr(E);
    if ((Exp != null)) {
      setObjCGCLValueClass(Ctx, Exp.getSubExpr$Const(), LV, IsMemberAccess);
      if (LV.isObjCIvar()) {
        // If cast is to a structure pointer, follow gcc's behavior and make it
        // a non-ivar write-barrier.
        QualType ExpTy = E.getType();
        if (ExpTy.$arrow().isPointerType()) {
          ExpTy.$assignMove(ExpTy.$arrow().getAs(org.clang.ast.PointerType.class).getPointeeType());
        }
        if (ExpTy.$arrow().isRecordType()) {
          LV.setObjCIvar(false);
        }
      }
      return;
    }
  }
  {
    
    /*const*/ GenericSelectionExpr /*P*/ Exp = dyn_cast_GenericSelectionExpr(E);
    if ((Exp != null)) {
      setObjCGCLValueClass(Ctx, Exp.getResultExpr$Const(), LV);
      return;
    }
  }
  {
    
    /*const*/ ImplicitCastExpr /*P*/ Exp = dyn_cast_ImplicitCastExpr(E);
    if ((Exp != null)) {
      setObjCGCLValueClass(Ctx, Exp.getSubExpr$Const(), LV, IsMemberAccess);
      return;
    }
  }
  {
    
    /*const*/ CStyleCastExpr /*P*/ Exp = dyn_cast_CStyleCastExpr(E);
    if ((Exp != null)) {
      setObjCGCLValueClass(Ctx, Exp.getSubExpr$Const(), LV, IsMemberAccess);
      return;
    }
  }
  {
    
    /*const*/ ObjCBridgedCastExpr /*P*/ Exp = dyn_cast_ObjCBridgedCastExpr(E);
    if ((Exp != null)) {
      setObjCGCLValueClass(Ctx, Exp.getSubExpr$Const(), LV, IsMemberAccess);
      return;
    }
  }
  {
    
    /*const*/ ArraySubscriptExpr /*P*/ Exp = dyn_cast_ArraySubscriptExpr(E);
    if ((Exp != null)) {
      setObjCGCLValueClass(Ctx, Exp.getBase$Const(), LV);
      if (LV.isObjCIvar() && !LV.isObjCArray()) {
        // Using array syntax to assigning to what an ivar points to is not
        // same as assigning to the ivar itself. {id *Names;} Names[i] = 0;
        LV.setObjCIvar(false);
      } else if (LV.isGlobalObjCRef() && !LV.isObjCArray()) {
        // Using array syntax to assigning to what global points to is not
        // same as assigning to the global itself. {id *G;} G[i] = 0;
        LV.setGlobalObjCRef(false);
      }
      return;
    }
  }
  {
    
    /*const*/ MemberExpr /*P*/ Exp = dyn_cast_MemberExpr(E);
    if ((Exp != null)) {
      setObjCGCLValueClass(Ctx, Exp.getBase(), LV, true);
      // We don't know if member is an 'ivar', but this flag is looked at
      // only in the context of LV.isObjCIvar().
      LV.setObjCArray(E.getType().$arrow().isArrayType());
      return;
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="EmitBitCastOfLValueToProperType">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1942,
 FQN="EmitBitCastOfLValueToProperType", NM="_ZL31EmitBitCastOfLValueToProperTypeRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueEPNS3_4TypeENS3_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL31EmitBitCastOfLValueToProperTypeRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueEPNS3_4TypeENS3_9StringRefE")
//</editor-fold>
public static Value /*P*/ EmitBitCastOfLValueToProperType(final CodeGenFunction /*&*/ CGF, 
                               Value /*P*/ V, org.llvm.ir.Type /*P*/ IRType) {
  return EmitBitCastOfLValueToProperType(CGF, 
                               V, IRType, 
                               new StringRef());
}
public static Value /*P*/ EmitBitCastOfLValueToProperType(final CodeGenFunction /*&*/ CGF, 
                               Value /*P*/ V, org.llvm.ir.Type /*P*/ IRType, 
                               StringRef Name/*= StringRef()*/) {
  /*uint*/int AS = IrRTTI.cast_PointerType(V.getType()).getAddressSpace();
  return CGF.Builder.CreateBitCast(V, IRType.getPointerTo(AS), new Twine(Name));
}

//<editor-fold defaultstate="collapsed" desc="EmitThreadPrivateVarDeclLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1950,
 FQN="EmitThreadPrivateVarDeclLValue", NM="_ZL30EmitThreadPrivateVarDeclLValueRN5clang7CodeGen15CodeGenFunctionEPKNS_7VarDeclENS_8QualTypeENS0_7AddressEPN4llvm4TypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL30EmitThreadPrivateVarDeclLValueRN5clang7CodeGen15CodeGenFunctionEPKNS_7VarDeclENS_8QualTypeENS0_7AddressEPN4llvm4TypeENS_14SourceLocationE")
//</editor-fold>
public static LValue EmitThreadPrivateVarDeclLValue(final CodeGenFunction /*&*/ CGF, /*const*/ VarDecl /*P*/ VD, QualType T, Address Addr, 
                              org.llvm.ir.Type /*P*/ RealVarTy, SourceLocation Loc) {
  Addr.$assignMove(CGF.CGM.getOpenMPRuntime().getAddrOfThreadPrivate(CGF, VD, new Address(Addr), new SourceLocation(Loc)));
  Addr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(Addr), RealVarTy));
  return CGF.MakeAddrLValue(new Address(Addr), new QualType(T), AlignmentSource.Decl);
}

//<editor-fold defaultstate="collapsed" desc="EmitGlobalVarDeclLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1989,
 FQN="EmitGlobalVarDeclLValue", NM="_ZL23EmitGlobalVarDeclLValueRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprEPKNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL23EmitGlobalVarDeclLValueRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprEPKNS_7VarDeclE")
//</editor-fold>
public static LValue EmitGlobalVarDeclLValue(final CodeGenFunction /*&*/ CGF, 
                       /*const*/ Expr /*P*/ E, /*const*/ VarDecl /*P*/ VD) {
  QualType T = E.getType();
  
  // If it's thread_local, emit a call to its wrapper function instead.
  if (VD.getTLSKind() == VarDecl.TLSKind.TLS_Dynamic
     && CGF.CGM.getCXXABI().usesThreadWrapperFunction()) {
    return CGF.CGM.getCXXABI().EmitThreadLocalVarDeclLValue(CGF, VD, new QualType(T));
  }
  
  Value /*P*/ V = CGF.CGM.GetAddrOfGlobalVar(VD);
  org.llvm.ir.Type /*P*/ RealVarTy = CGF.getTypes().ConvertTypeForMem(VD.getType());
  V = EmitBitCastOfLValueToProperType(CGF, V, RealVarTy);
  CharUnits Alignment = CGF.getContext().getDeclAlign(VD);
  Address Addr/*J*/= new Address(V, new CharUnits(Alignment));
  LValue LV/*J*/= new LValue();
  // Emit reference to the private copy of the variable if it is an OpenMP
  // threadprivate variable.
  if ((CGF.getLangOpts().OpenMP != 0) && VD.hasAttr(OMPThreadPrivateDeclAttr.class)) {
    return EmitThreadPrivateVarDeclLValue(CGF, VD, new QualType(T), new Address(Addr), RealVarTy, 
        E.getExprLoc());
  }
  {
    /*const*/ ReferenceType /*P*/ RefTy = VD.getType().$arrow().getAs(ReferenceType.class);
    if ((RefTy != null)) {
      LV.$assignMove(CGF.EmitLoadOfReferenceLValue(new Address(Addr), RefTy));
    } else {
      LV.$assignMove(CGF.MakeAddrLValue(new Address(Addr), new QualType(T), AlignmentSource.Decl));
    }
  }
  setObjCGCLValueClass(CGF.getContext(), E, LV);
  return LV;
}

//<editor-fold defaultstate="collapsed" desc="EmitFunctionDeclLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2018,
 FQN="EmitFunctionDeclLValue", NM="_ZL22EmitFunctionDeclLValueRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL22EmitFunctionDeclLValueRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprEPKNS_12FunctionDeclE")
//</editor-fold>
public static LValue EmitFunctionDeclLValue(final CodeGenFunction /*&*/ CGF, 
                      /*const*/ Expr /*P*/ E, /*const*/ FunctionDecl /*P*/ FD) {
  Value /*P*/ V = CGF.CGM.GetAddrOfFunction(new GlobalDecl(FD));
  if (!FD.hasPrototype()) {
    {
      /*const*/ FunctionProtoType /*P*/ Proto = FD.getType().$arrow().getAs(FunctionProtoType.class);
      if ((Proto != null)) {
        // Ugly case: for a K&R-style definition, the type of the definition
        // isn't the same as the type of a use.  Correct for this with a
        // bitcast.
        QualType NoProtoType = CGF.getContext().getFunctionNoProtoType(Proto.getReturnType());
        NoProtoType.$assignMove(CGF.getContext().getPointerType(/*NO_COPY*/NoProtoType));
        V = CGF.Builder.CreateBitCast(V, CGF.ConvertType(new QualType(NoProtoType)));
      }
    }
  }
  CharUnits Alignment = CGF.getContext().getDeclAlign(FD);
  return CGF.MakeAddrLValue(V, E.getType(), new CharUnits(Alignment), AlignmentSource.Decl);
}

//<editor-fold defaultstate="collapsed" desc="EmitCapturedFieldLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2037,
 FQN="EmitCapturedFieldLValue", NM="_ZL23EmitCapturedFieldLValueRN5clang7CodeGen15CodeGenFunctionEPKNS_9FieldDeclEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL23EmitCapturedFieldLValueRN5clang7CodeGen15CodeGenFunctionEPKNS_9FieldDeclEPN4llvm5ValueE")
//</editor-fold>
public static LValue EmitCapturedFieldLValue(final CodeGenFunction /*&*/ CGF, /*const*/ FieldDecl /*P*/ FD, 
                       Value /*P*/ ThisValue) {
  QualType TagType = CGF.getContext().getTagDeclType(FD.getParent$Const());
  LValue LV = CGF.MakeNaturalAlignAddrLValue(ThisValue, new QualType(TagType));
  return CGF.EmitLValueForField(new LValue(LV), FD);
}


/// Named Registers are named metadata pointing to the register name
/// which will be read from/written to as an argument to the intrinsic
/// @llvm.read/write_register.
/// So far, only the name is being passed down, but other options such as
/// register type, allocation type or even optimization options could be
/// passed down via the metadata node.
//<editor-fold defaultstate="collapsed" desc="EmitGlobalNamedRegister">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2050,
 FQN="EmitGlobalNamedRegister", NM="_ZL23EmitGlobalNamedRegisterPKN5clang7VarDeclERNS_7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL23EmitGlobalNamedRegisterPKN5clang7VarDeclERNS_7CodeGen13CodeGenModuleE")
//</editor-fold>
public static LValue EmitGlobalNamedRegister(/*const*/ VarDecl /*P*/ VD, final CodeGenModule /*&*/ CGM) {
  SmallString/*<64>*/ Name/*J*/= new SmallString/*<64>*/(64, new StringRef(/*KEEP_STR*/"llvm.named.register."));
  AsmLabelAttr /*P*/ Asm = VD.getAttr(AsmLabelAttr.class);
  assert ($less_uint(Asm.getLabel().size(), 64 - Name.size())) : "Register name too big";
  Name.append(Asm.getLabel());
  NamedMDNode /*P*/ M = CGM.getModule().getOrInsertNamedMetadata(Name.$StringRef());
  if (M.getNumOperands() == 0) {
    MDString /*P*/ Str = MDString.get(CGM.getLLVMContext(), 
        Asm.getLabel());
    Metadata /*P*/ Ops[/*1*/] = new Metadata /*P*/  [/*1*/] {Str};
    M.addOperand(MDNode.get(CGM.getLLVMContext(), new ArrayRef<Metadata /*P*/ >(Ops, true)));
  }
  
  CharUnits Alignment = CGM.getContext().getDeclAlign(VD);
  
  Value /*P*/ Ptr = MetadataAsValue.get(CGM.getLLVMContext(), M.getOperand(0));
  return LValue.MakeGlobalReg(new Address(Ptr, new CharUnits(Alignment)), VD.getType());
}

//<editor-fold defaultstate="collapsed" desc="getRecoverableKind">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2450,
 FQN="getRecoverableKind", NM="_ZL18getRecoverableKindy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL18getRecoverableKindy")
//</editor-fold>
public static CheckRecoverableKind getRecoverableKind(long/*uint64_t*/ Kind) {
  assert (AdtsupportLlvmGlobals.countPopulation(Kind) == 1);
  // JAVA: can't switch by long// switch (Kind) {
   if (Kind == SanitizerKind.Vptr) { // case SanitizerKind.Vptr:
    return CheckRecoverableKind.AlwaysRecoverable;
   } else if (Kind == SanitizerKind.Return // case SanitizerKind.Return:
     || Kind == SanitizerKind.Unreachable) { // case SanitizerKind.Unreachable:
    return CheckRecoverableKind.Unrecoverable;
   } else { // default:
    return CheckRecoverableKind.Recoverable;
  }
}

//<editor-fold defaultstate="collapsed" desc="emitCheckHandlerCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2463,
 FQN="emitCheckHandlerCall", NM="_ZL20emitCheckHandlerCallRN5clang7CodeGen15CodeGenFunctionEPN4llvm12FunctionTypeENS3_8ArrayRefIPNS3_5ValueEEENS3_9StringRefEN12_GLOBAL__N_120CheckRecoverableKindEbPNS3_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL20emitCheckHandlerCallRN5clang7CodeGen15CodeGenFunctionEPN4llvm12FunctionTypeENS3_8ArrayRefIPNS3_5ValueEEENS3_9StringRefEN12_GLOBAL__N_120CheckRecoverableKindEbPNS3_10BasicBlockE")
//</editor-fold>
public static void emitCheckHandlerCall(final CodeGenFunction /*&*/ CGF, 
                    org.llvm.ir.FunctionType /*P*/ FnType, 
                    ArrayRef<Value /*P*/ > FnArgs, 
                    StringRef CheckName, 
                    CheckRecoverableKind RecoverKind, boolean IsFatal, 
                    BasicBlock /*P*/ ContBB) {
  AttrBuilder B = null;
  try {
    assert (IsFatal || RecoverKind != CheckRecoverableKind.Unrecoverable);
    boolean NeedsAbortSuffix = IsFatal && RecoverKind != CheckRecoverableKind.Unrecoverable;
    std.string FnName = ($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"__ubsan_handle_", CheckName), 
        new Twine((NeedsAbortSuffix ? $("_abort") : $EMPTY)))).str();
    boolean MayReturn = !IsFatal || RecoverKind == CheckRecoverableKind.AlwaysRecoverable;
    
    B/*J*/= new AttrBuilder();
    if (!MayReturn) {
      B.addAttribute(Attribute.AttrKind.NoReturn).
          addAttribute(Attribute.AttrKind.NoUnwind);
    }
    B.addAttribute(Attribute.AttrKind.UWTable);
    
    Value /*P*/ Fn = CGF.CGM.CreateRuntimeFunction(FnType, new StringRef(FnName), 
        AttributeSet.get(CGF.getLLVMContext(), 
            AttributeSet.AttrIndex.FunctionIndex.getValue(), B));
    CallInst /*P*/ HandlerCall = CGF.EmitNounwindRuntimeCall(Fn, new ArrayRef<Value /*P*/ >(FnArgs));
    if (!MayReturn) {
      HandlerCall.setDoesNotReturn();
      CGF.Builder.CreateUnreachable();
    } else {
      CGF.Builder.CreateBr(ContBB);
    }
  } finally {
    if (B != null) { B.$destroy(); }
  }
}


/// isSimpleArrayDecayOperand - If the specified expr is a simple decay from an
/// array to pointer, return the array subexpression.
//<editor-fold defaultstate="collapsed" desc="isSimpleArrayDecayOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2792,
 FQN="isSimpleArrayDecayOperand", NM="_ZL25isSimpleArrayDecayOperandPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL25isSimpleArrayDecayOperandPKN5clang4ExprE")
//</editor-fold>
public static /*const*/ Expr /*P*/ isSimpleArrayDecayOperand(/*const*/ Expr /*P*/ E) {
  // If this isn't just an array->pointer decay, bail out.
  /*const*/ CastExpr /*P*/ CE = dyn_cast_CastExpr(E);
  if (!(CE != null) || CE.getCastKind() != CastKind.CK_ArrayToPointerDecay) {
    return null;
  }
  
  // If this is a decay from variable width array, bail out.
  /*const*/ Expr /*P*/ SubExpr = CE.getSubExpr$Const();
  if (SubExpr.getType().$arrow().isVariableArrayType()) {
    return null;
  }
  
  return SubExpr;
}

//<editor-fold defaultstate="collapsed" desc="emitArraySubscriptGEP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2806,
 FQN="emitArraySubscriptGEP", NM="_ZL21emitArraySubscriptGEPRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS3_8ArrayRefIS5_EEbRKNS3_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL21emitArraySubscriptGEPRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS3_8ArrayRefIS5_EEbRKNS3_5TwineE")
//</editor-fold>
public static Value /*P*/ emitArraySubscriptGEP(final CodeGenFunction /*&*/ CGF, 
                     Value /*P*/ ptr, 
                     ArrayRef<Value /*P*/ > indices, 
                     boolean inbounds) {
  return emitArraySubscriptGEP(CGF, 
                     ptr, 
                     indices, 
                     inbounds, 
                     new Twine(/*KEEP_STR*/"arrayidx"));
}
public static Value /*P*/ emitArraySubscriptGEP(final CodeGenFunction /*&*/ CGF, 
                     Value /*P*/ ptr, 
                     ArrayRef<Value /*P*/ > indices, 
                     boolean inbounds, 
                     final /*const*/ Twine /*&*/ name/*= "arrayidx"*/) {
  if (inbounds) {
    return CGF.Builder.CreateInBoundsGEP(ptr, new ArrayRef<Value /*P*/ >(indices), name);
  } else {
    return CGF.Builder.CreateGEP(ptr, new ArrayRef<Value /*P*/ >(indices), name);
  }
}

//<editor-fold defaultstate="collapsed" desc="getArrayElementAlign">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2818,
 FQN="getArrayElementAlign", NM="_ZL20getArrayElementAlignN5clang9CharUnitsEPN4llvm5ValueES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL20getArrayElementAlignN5clang9CharUnitsEPN4llvm5ValueES0_")
//</editor-fold>
public static CharUnits getArrayElementAlign(CharUnits arrayAlign, 
                    Value /*P*/ idx, 
                    CharUnits eltSize) {
  {
    // If we have a constant index, we can use the exact offset of the
    // element we're accessing.
    ConstantInt /*P*/ constantIdx = dyn_cast_ConstantInt(idx);
    if ((constantIdx != null)) {
      CharUnits offset = $star_long_CharUnits$C(constantIdx.getZExtValue(), eltSize);
      return arrayAlign.alignmentAtOffset(new CharUnits(offset));
      // Otherwise, use the worst-case alignment for any element.
    } else {
      return arrayAlign.alignmentOfArrayElement(new CharUnits(eltSize));
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="getFixedSizeElementType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2833,
 FQN="getFixedSizeElementType", NM="_ZL23getFixedSizeElementTypeRKN5clang10ASTContextEPKNS_17VariableArrayTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL23getFixedSizeElementTypeRKN5clang10ASTContextEPKNS_17VariableArrayTypeE")
//</editor-fold>
public static QualType getFixedSizeElementType(final /*const*/ ASTContext /*&*/ ctx, 
                       /*const*/ VariableArrayType /*P*/ vla) {
  QualType eltType/*J*/= new QualType();
  do {
    eltType.$assignMove(vla.getElementType());
  } while (((vla = ctx.getAsVariableArrayType(new QualType(eltType))) != null));
  return eltType;
}

//<editor-fold defaultstate="collapsed" desc="emitArraySubscriptGEP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2842,
 FQN="emitArraySubscriptGEP", NM="_ZL21emitArraySubscriptGEPRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEN4llvm8ArrayRefIPNS4_5ValueEEENS_8QualTypeEbRKNS4_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL21emitArraySubscriptGEPRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEN4llvm8ArrayRefIPNS4_5ValueEEENS_8QualTypeEbRKNS4_5TwineE")
//</editor-fold>
public static Address emitArraySubscriptGEP(final CodeGenFunction /*&*/ CGF, Address addr, 
                     ArrayRef<Value /*P*/ > indices, 
                     QualType eltType, boolean inbounds) {
  return emitArraySubscriptGEP(CGF, addr, 
                     indices, 
                     eltType, inbounds, 
                     new Twine(/*KEEP_STR*/"arrayidx"));
}
public static Address emitArraySubscriptGEP(final CodeGenFunction /*&*/ CGF, Address addr, 
                     ArrayRef<Value /*P*/ > indices, 
                     QualType eltType, boolean inbounds, 
                     final /*const*/ Twine /*&*/ name/*= "arrayidx"*/) {
  for (Value /*P*/ idx : indices.drop_back())  {
    assert (isa_ConstantInt(idx) && cast_ConstantInt(idx).isZero());
  }
  {
    
    // Determine the element size of the statically-sized base.  This is
    // the thing that the indices are expressed in terms of.
    /*const*/ VariableArrayType /*P*/ vla = CGF.getContext().getAsVariableArrayType(new QualType(eltType));
    if ((vla != null)) {
      eltType.$assignMove(getFixedSizeElementType(CGF.getContext(), vla));
    }
  }
  
  // We can use that to compute the best alignment of the element.
  CharUnits eltSize = CGF.getContext().getTypeSizeInChars(/*NO_COPY*/eltType);
  CharUnits eltAlign = getArrayElementAlign(addr.getAlignment(), indices.back(), new CharUnits(eltSize));
  
  Value /*P*/ eltPtr = emitArraySubscriptGEP(CGF, addr.getPointer(), new ArrayRef<Value /*P*/ >(indices), inbounds, name);
  return new Address(eltPtr, new CharUnits(eltAlign));
}

//<editor-fold defaultstate="collapsed" desc="emitOMPArraySectionBase">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2999,
 FQN="emitOMPArraySectionBase", NM="_ZL23emitOMPArraySectionBaseRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprERNS0_15AlignmentSourceENS_8QualTypeES8_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL23emitOMPArraySectionBaseRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprERNS0_15AlignmentSourceENS_8QualTypeES8_b")
//</editor-fold>
public static Address emitOMPArraySectionBase(final CodeGenFunction /*&*/ CGF, /*const*/ Expr /*P*/ Base, 
                       final type$ref<AlignmentSource /*&*/> AlignSource, 
                       QualType BaseTy, QualType ElTy, 
                       boolean IsLowerBound) {
  LValue BaseLVal/*J*/= new LValue();
  {
    /*const*/ OMPArraySectionExpr /*P*/ ASE = dyn_cast_OMPArraySectionExpr(Base.IgnoreParenImpCasts$Const());
    if ((ASE != null)) {
      BaseLVal.$assignMove(CGF.EmitOMPArraySectionExpr(ASE, IsLowerBound));
      if (BaseTy.$arrow().isArrayType()) {
        Address Addr = BaseLVal.getAddress();
        AlignSource.$set(BaseLVal.getAlignmentSource());
        
        // If the array type was an incomplete type, we need to make sure
        // the decay ends up being the right type.
        org.llvm.ir.Type /*P*/ NewTy = CGF.ConvertType(new QualType(BaseTy));
        Addr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(Addr), NewTy));
        
        // Note that VLA pointers are always decayed, so we don't need to do
        // anything here.
        if (!BaseTy.$arrow().isVariableArrayType()) {
          assert (IrRTTI.isa_ArrayType(Addr.getElementType())) : "Expected pointer to array";
          Addr.$assignMove(CGF.Builder.CreateStructGEP(new Address(Addr), 0, CharUnits.Zero(), 
                  new Twine(/*KEEP_STR*/"arraydecay")));
        }
        
        return CGF.Builder.CreateElementBitCast(new Address(Addr), 
            CGF.ConvertTypeForMem(new QualType(ElTy)));
      }
      CharUnits Align = CGF.getNaturalTypeAlignment(new QualType(ElTy), AlignSource.deref$ptr());
      return new Address(CGF.Builder.CreateLoad(BaseLVal.getAddress()), new CharUnits(Align));
    }
  }
  return CGF.EmitPointerWithAlignment(Base, AlignSource.deref$ptr());
}


/// Drill down to the storage of a field without walking into
/// reference types.
///
/// The resulting address doesn't necessarily have the right type.
//<editor-fold defaultstate="collapsed" desc="emitAddrOfFieldStorage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3287,
 FQN="emitAddrOfFieldStorage", NM="_ZL22emitAddrOfFieldStorageRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEPKNS_9FieldDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL22emitAddrOfFieldStorageRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEPKNS_9FieldDeclE")
//</editor-fold>
public static Address emitAddrOfFieldStorage(final CodeGenFunction /*&*/ CGF, Address base, 
                      /*const*/ FieldDecl /*P*/ field) {
  /*const*/ RecordDecl /*P*/ rec = field.getParent$Const();
  
  /*uint*/int idx = CGF.CGM.getTypes().getCGRecordLayout(rec).getLLVMFieldNo(field);
  
  CharUnits offset/*J*/= new CharUnits();
  // Adjust the alignment down to the given offset.
  // As a special case, if the LLVM field index is 0, we know that this
  // is zero.
  assert ((idx != 0 || CGF.getContext().getASTRecordLayout(rec).getFieldOffset(field.getFieldIndex()) == $int2ullong(0))) : "LLVM field at index zero had non-zero offset?";
  if (idx != 0) {
    final /*const*/ ASTRecordLayout /*&*/ recLayout = CGF.getContext().getASTRecordLayout(rec);
    long/*uint64_t*/ offsetInBits = recLayout.getFieldOffset(field.getFieldIndex());
    offset.$assignMove(CGF.getContext().toCharUnitsFromBits(offsetInBits));
  }
  
  return CGF.Builder.CreateStructGEP(new Address(base), idx, new CharUnits(offset), new Twine(field.getName()));
}


/// Emit the operand of a glvalue conditional operator. This is either a glvalue
/// or a (possibly-parenthesized) throw-expression. If this is a throw, no
/// LValue is returned and the current block has been terminated.
//<editor-fold defaultstate="collapsed" desc="EmitLValueOrThrowExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3472,
 FQN="EmitLValueOrThrowExpression", NM="_ZL27EmitLValueOrThrowExpressionRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL27EmitLValueOrThrowExpressionRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprE")
//</editor-fold>
public static Optional<LValue> EmitLValueOrThrowExpression(final CodeGenFunction /*&*/ CGF, 
                           /*const*/ Expr /*P*/ Operand) {
  {
    /*const*/ CXXThrowExpr /*P*/ ThrowExpr = dyn_cast_CXXThrowExpr(Operand.IgnoreParens$Const());
    if ((ThrowExpr != null)) {
      CGF.EmitCXXThrowExpr(ThrowExpr, /*KeepInsertionPoint*/ false);
      return new Optional<LValue>(None);
    }
  }
  
  return new Optional<LValue>(JD$T$RR.INSTANCE, CGF.EmitLValue(Operand));
}

//<editor-fold defaultstate="collapsed" desc="emitPseudoObjectExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 4189,
 FQN="emitPseudoObjectExpr", NM="_ZL20emitPseudoObjectExprRN5clang7CodeGen15CodeGenFunctionEPKNS_16PseudoObjectExprEbNS0_12AggValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZL20emitPseudoObjectExprRN5clang7CodeGen15CodeGenFunctionEPKNS_16PseudoObjectExprEbNS0_12AggValueSlotE")
//</editor-fold>
public static LValueOrRValue emitPseudoObjectExpr(final CodeGenFunction /*&*/ CGF, 
                    /*const*/ PseudoObjectExpr /*P*/ E, 
                    boolean forLValue, 
                    AggValueSlot slot) {
  SmallVector<CodeGenFunction.OpaqueValueMappingData> opaques/*J*/= new SmallVector<CodeGenFunction.OpaqueValueMappingData>(4, new CodeGenFunction.OpaqueValueMappingData());
  
  // Find the result expression, if any.
  /*const*/ Expr /*P*/ resultExpr = E.getResultExpr$Const();
  LValueOrRValue result/*J*/= new LValueOrRValue();
  
  for (type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> i = $tryClone(E.semantics_begin$Const()), /*P*/ /*const*/ /*P*/ e = $tryClone(E.semantics_end$Const()); $noteq_ptr(i, e); i.$preInc()) {
    /*const*/ Expr /*P*/ semantic = i.$star();
    {
      
      // If this semantic expression is an opaque value, bind it
      // to the result of its source expression.
      /*const*/ OpaqueValueExpr /*P*/ ov = dyn_cast_OpaqueValueExpr(semantic);
      if ((ov != null)) {
        
        // If this is the result expression, we may need to evaluate
        // directly into the slot.
        // JAVA: typedef CodeGenFunction::OpaqueValueMappingData OVMA
//        final class OVMA extends CodeGenFunction.OpaqueValueMappingData{ };
        CodeGenFunction.OpaqueValueMappingData opaqueData/*J*/= new CodeGenFunction.OpaqueValueMappingData();
        if (ov == resultExpr && ov.isRValue() && !forLValue
           && CodeGenFunction.hasAggregateEvaluationKind(ov.getType())) {
          CGF.EmitAggExpr(ov.getSourceExpr(), new AggValueSlot(slot));
          
          LValue LV = CGF.MakeAddrLValue(slot.getAddress(), ov.getType(), 
              AlignmentSource.Decl);
          opaqueData.$assignMove(CodeGenFunction.OpaqueValueMappingData.bind(CGF, ov, LV));
          result.RV.$assignMove(slot.asRValue());
          // Otherwise, emit as normal.
        } else {
          opaqueData.$assignMove(CodeGenFunction.OpaqueValueMappingData.bind(CGF, ov, ov.getSourceExpr()));
          
          // If this is the result, also evaluate the result now.
          if (ov == resultExpr) {
            if (forLValue) {
              result.LV.$assignMove(CGF.EmitLValue(ov));
            } else {
              result.RV.$assignMove(CGF.EmitAnyExpr(ov, new AggValueSlot(slot)));
            }
          }
        }
        
        opaques.push_back(opaqueData);
        // Otherwise, if the expression is the result, evaluate it
        // and remember the result.
      } else if (semantic == resultExpr) {
        if (forLValue) {
          result.LV.$assignMove(CGF.EmitLValue(semantic));
        } else {
          result.RV.$assignMove(CGF.EmitAnyExpr(semantic, new AggValueSlot(slot)));
        }
        // Otherwise, evaluate the expression in an ignored context.
      } else {
        CGF.EmitIgnoredExpr(semantic);
      }
    }
  }
  
  // Unbind all the opaques now.
  for (/*uint*/int i = 0, e = opaques.size(); i != e; ++i)  {
    opaques.$at(i).unbind(CGF);
  }
  
  return result;
}

} // END OF class CGExprStatics
