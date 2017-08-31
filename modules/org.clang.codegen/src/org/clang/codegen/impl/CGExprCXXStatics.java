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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.intrinsic.ID;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.codegen.java.ClangCodeGenDummies.*;
import org.clank.support.JavaDifferentiators.JD$UInt_ULong;
import static org.clank.support.Native.$AddrOf;


//<editor-fold defaultstate="collapsed" desc="static type CGExprCXXStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.impl.CGExprCXXStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZL12getCXXRecordPKN5clang4ExprE;_ZL15EmitArrayDeleteRN5clang7CodeGen15CodeGenFunctionEPKNS_13CXXDeleteExprENS0_7AddressENS_8QualTypeE;_ZL16EmitObjectDeleteRN5clang7CodeGen15CodeGenFunctionEPKNS_13CXXDeleteExprENS0_7AddressENS_8QualTypeE;_ZL17EmitNewDeleteCallRN5clang7CodeGen15CodeGenFunctionEPKNS_12FunctionDeclEPKNS_17FunctionProtoTypeERKNS0_11CallArgListE;_ZL18EmitNewInitializerRN5clang7CodeGen15CodeGenFunctionEPKNS_10CXXNewExprENS_8QualTypeEPN4llvm4TypeENS0_7AddressEPNS7_5ValueESC_;_ZL19EmitCXXNewAllocSizeRN5clang7CodeGen15CodeGenFunctionEPKNS_10CXXNewExprEjRPN4llvm5ValueES9_;_ZL20EmitTypeidFromVTableRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprEPN4llvm4TypeE;_ZL21EmitDynamicCastToNullRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeE;_ZL21EnterNewDeleteCleanupRN5clang7CodeGen15CodeGenFunctionEPKNS_10CXXNewExprENS0_7AddressEPN4llvm5ValueERKNS0_11CallArgListE;_ZL22CalculateCookiePaddingRN5clang7CodeGen15CodeGenFunctionEPKNS_10CXXNewExprE;_ZL23StoreAnyExprIntoOneUnitRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprENS_8QualTypeENS0_7AddressE;_ZL25isGLValueFromPointerDerefPKN5clang4ExprE;_ZL31EmitNullBaseClassInitializationRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEPKNS_13CXXRecordDeclE;_ZL33commonEmitCXXMemberOrOperatorCallRN5clang7CodeGen15CodeGenFunctionEPKNS_13CXXMethodDeclEPN4llvm5ValueES8_NS_8QualTypeEPKNS_8CallExprERNS0_11CallArgListE; -static-type=CGExprCXXStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGExprCXXStatics {

//<editor-fold defaultstate="collapsed" desc="commonEmitCXXMemberOrOperatorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 27,
 FQN="commonEmitCXXMemberOrOperatorCall", NM="_ZL33commonEmitCXXMemberOrOperatorCallRN5clang7CodeGen15CodeGenFunctionEPKNS_13CXXMethodDeclEPN4llvm5ValueES8_NS_8QualTypeEPKNS_8CallExprERNS0_11CallArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZL33commonEmitCXXMemberOrOperatorCallRN5clang7CodeGen15CodeGenFunctionEPKNS_13CXXMethodDeclEPN4llvm5ValueES8_NS_8QualTypeEPKNS_8CallExprERNS0_11CallArgListE")
//</editor-fold>
public static RequiredArgs commonEmitCXXMemberOrOperatorCall(final CodeGenFunction /*&*/ CGF, /*const*/ CXXMethodDecl /*P*/ MD, 
                                 Value /*P*/ This, Value /*P*/ ImplicitParam, 
                                 QualType ImplicitParamTy, /*const*/ CallExpr /*P*/ CE, 
                                 final CallArgList /*&*/ Args) {
  assert (CE == null || isa_CXXMemberCallExpr(CE) || isa_CXXOperatorCallExpr(CE));
  assert (MD.isInstance()) : "Trying to emit a member or operator call expr on a static method!";
  
  // C++11 [class.mfct.non-static]p2:
  //   If a non-static member function of a class X is called for an object that
  //   is not of type X, or of a type derived from X, the behavior is undefined.
  SourceLocation CallLoc/*J*/= new SourceLocation();
  if ((CE != null)) {
    CallLoc.$assignMove(CE.getExprLoc());
  }
  CGF.EmitTypeCheck(isa_CXXConstructorDecl(MD) ? CodeGenFunction.TypeCheckKind.TCK_ConstructorCall : CodeGenFunction.TypeCheckKind.TCK_MemberCall, 
      new SourceLocation(CallLoc), This, CGF.getContext().getRecordType(MD.getParent$Const()));
  
  // Push the this ptr.
  Args.add(RValue.get(This), MD.getThisType(CGF.getContext()));
  
  // If there is an implicit parameter (e.g. VTT), emit it.
  if ((ImplicitParam != null)) {
    Args.add(RValue.get(ImplicitParam), new QualType(ImplicitParamTy));
  }
  
  /*const*/ FunctionProtoType /*P*/ FPT = MD.getType().$arrow().castAs(FunctionProtoType.class);
  RequiredArgs required = RequiredArgs.forPrototypePlus(FPT, Args.size(), MD);
  
  // And the rest of the call args.
  if ((CE != null)) {
    // Special case: skip first argument of CXXOperatorCall (it is "this").
    /*uint*/int ArgsToSkip = isa_CXXOperatorCallExpr(CE) ? 1 : 0;
    CGF.EmitCallArgs(Args, FPT, drop_begin(CE.arguments$Const(), ArgsToSkip), 
        CE.getDirectCallee$Const());
  } else {
    assert (FPT.getNumParams() == 0) : "No CallExpr specified for function with non-zero number of arguments";
  }
  return required;
}

//<editor-fold defaultstate="collapsed" desc="getCXXRecord">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 96,
 FQN="getCXXRecord", NM="_ZL12getCXXRecordPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZL12getCXXRecordPKN5clang4ExprE")
//</editor-fold>
public static CXXRecordDecl /*P*/ getCXXRecord(/*const*/ Expr /*P*/ E) {
  QualType T = E.getType();
  {
    /*const*/ org.clang.ast.PointerType /*P*/ PTy = T.$arrow().getAs(org.clang.ast.PointerType.class);
    if ((PTy != null)) {
      T.$assignMove(PTy.getPointeeType());
    }
  }
  /*const*/ RecordType /*P*/ Ty = T.$arrow().castAs$RecordType();
  return cast_CXXRecordDecl(Ty.getDecl());
}

//<editor-fold defaultstate="collapsed" desc="EmitNullBaseClassInitialization">
@Converted(kind = Converted.Kind.MANUAL/*emplace back Clone and vector initialization*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 352,
 FQN="EmitNullBaseClassInitialization", NM="_ZL31EmitNullBaseClassInitializationRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZL31EmitNullBaseClassInitializationRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEPKNS_13CXXRecordDeclE")
//</editor-fold>
public static void EmitNullBaseClassInitialization(final CodeGenFunction /*&*/ CGF, 
                               Address DestPtr, 
                               /*const*/ CXXRecordDecl /*P*/ Base) {
  std.vector<CharUnits> VBPtrOffsets = null;
  try {
    if (Base.isEmpty()) {
      return;
    }
    
    DestPtr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(DestPtr), CGF.Int8Ty));
    
    final /*const*/ ASTRecordLayout /*&*/ Layout = CGF.getContext().getASTRecordLayout(Base);
    CharUnits NVSize = Layout.getNonVirtualSize();
    
    // We cannot simply zero-initialize the entire base sub-object if vbptrs are
    // present, they are initialized by the most derived class before calling the
    // constructor.
    SmallVector<std.pairTypeType<CharUnits, CharUnits>> Stores/*J*/= new SmallVector<std.pairTypeType<CharUnits, CharUnits>>(1, new std.pairTypeType<CharUnits, CharUnits>(new CharUnits(), new CharUnits()));
    Stores.emplace_back(new std.pairTypeType<CharUnits, CharUnits>(Native.$Clone(CharUnits.Zero()), Native.$Clone(NVSize)));
    
    // Each store is split by the existence of a vbptr.
    CharUnits VBPtrWidth = CGF.getPointerSize();
    VBPtrOffsets = CGF.CGM.getCXXABI().getVBPtrOffsets(Base);
    for (CharUnits VBPtrOffset : VBPtrOffsets) {
      // Stop before we hit any virtual base pointers located in virtual bases.
      if (VBPtrOffset.$greatereq(NVSize)) {
        break;
      }
      std.pairTypeType<CharUnits, CharUnits> LastStore = Stores.pop_back_val();
      CharUnits LastStoreOffset = new CharUnits(LastStore.first);
      CharUnits LastStoreSize = new CharUnits(LastStore.second);
      
      CharUnits SplitBeforeOffset = new CharUnits(LastStoreOffset);
      CharUnits SplitBeforeSize = VBPtrOffset.$sub(SplitBeforeOffset);
      assert (!SplitBeforeSize.isNegative()) : "negative store size!";
      if (!SplitBeforeSize.isZero()) {
        Stores.emplace_back(new std.pairTypeType<CharUnits, CharUnits>(Native.$Clone(SplitBeforeOffset), Native.$Clone(SplitBeforeSize)));
      }
      
      CharUnits SplitAfterOffset = VBPtrOffset.$add(VBPtrWidth);
      CharUnits SplitAfterSize = LastStoreSize.$sub(SplitAfterOffset);
      assert (!SplitAfterSize.isNegative()) : "negative store size!";
      if (!SplitAfterSize.isZero()) {
        Stores.emplace_back(new std.pairTypeType<CharUnits, CharUnits>(Native.$Clone(SplitAfterOffset), Native.$Clone(SplitAfterSize)));
      }
    }
    
    // If the type contains a pointer to data member we can't memset it to zero.
    // Instead, create a null constant and copy it to the destination.
    // TODO: there are other patterns besides zero that we can usefully memset,
    // like -1, which happens to be the pattern used by member-pointers.
    // TODO: isZeroInitializable can be over-conservative in the case where a
    // virtual base contains a member pointer.
    Constant /*P*/ NullConstantForBase = CGF.CGM.EmitNullConstantForBase(Base);
    if (!NullConstantForBase.isNullValue()) {
      GlobalVariable /*P*/ NullVariable = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGF.CGM.getModule(), NullConstantForBase.getType(), 
          /*isConstant=*/ true, GlobalVariable.LinkageTypes.PrivateLinkage, 
          NullConstantForBase, new Twine());
       });
      
      CharUnits Align = new CharUnits(std.max(Layout.getNonVirtualAlignment(), 
              DestPtr.getAlignment()));
      NullVariable.setAlignment($long2uint(Align.getQuantity()));
      
      Address SrcPtr = new Address(CGF.EmitCastToVoidPtr(NullVariable), new CharUnits(Align));
      
      // Get and call the appropriate llvm.memcpy overload.
      for (std.pairTypeType<CharUnits, CharUnits> Store : Stores) {
        CharUnits StoreOffset = new CharUnits(Store.first);
        CharUnits StoreSize = new CharUnits(Store.second);
        Value /*P*/ StoreSizeVal = CGF.CGM.getSize(new CharUnits(StoreSize));
        CGF.Builder.CreateMemCpy(CGF.Builder.CreateConstInBoundsByteGEP(new Address(DestPtr), new CharUnits(StoreOffset)), 
            CGF.Builder.CreateConstInBoundsByteGEP(new Address(SrcPtr), new CharUnits(StoreOffset)), 
            StoreSizeVal);
      }
      // Otherwise, just memset the whole thing to zero.  This is legal
      // because in LLVM, all default initializers (other than the ones we just
      // handled above) are guaranteed to have a bit pattern of all zeros.
    } else {
      for (std.pairTypeType<CharUnits, CharUnits> Store : Stores) {
        CharUnits StoreOffset = new CharUnits(Store.first);
        CharUnits StoreSize = new CharUnits(Store.second);
        Value /*P*/ StoreSizeVal = CGF.CGM.getSize(new CharUnits(StoreSize));
        CGF.Builder.CreateMemSet(CGF.Builder.CreateConstInBoundsByteGEP(new Address(DestPtr), new CharUnits(StoreOffset)), 
            CGF.Builder.getInt8($int2uchar(0)), StoreSizeVal);
      }
    }
  } finally {
    if (VBPtrOffsets != null) { VBPtrOffsets.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="CalculateCookiePadding">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 534,
 FQN="CalculateCookiePadding", NM="_ZL22CalculateCookiePaddingRN5clang7CodeGen15CodeGenFunctionEPKNS_10CXXNewExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZL22CalculateCookiePaddingRN5clang7CodeGen15CodeGenFunctionEPKNS_10CXXNewExprE")
//</editor-fold>
public static CharUnits CalculateCookiePadding(final CodeGenFunction /*&*/ CGF, 
                      /*const*/ CXXNewExpr /*P*/ E) {
  if (!E.isArray()) {
    return CharUnits.Zero();
  }
  
  // No cookie is required if the operator new[] being used is the
  // reserved placement operator new[].
  if (E.getOperatorNew().isReservedGlobalPlacementOperator()) {
    return CharUnits.Zero();
  }
  
  return CGF.CGM.getCXXABI().GetArrayCookieSize(E);
}

//<editor-fold defaultstate="collapsed" desc="EmitCXXNewAllocSize">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 547,
 FQN="EmitCXXNewAllocSize", NM="_ZL19EmitCXXNewAllocSizeRN5clang7CodeGen15CodeGenFunctionEPKNS_10CXXNewExprEjRPN4llvm5ValueES9_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZL19EmitCXXNewAllocSizeRN5clang7CodeGen15CodeGenFunctionEPKNS_10CXXNewExprEjRPN4llvm5ValueES9_")
//</editor-fold>
public static Value /*P*/ EmitCXXNewAllocSize(final CodeGenFunction /*&*/ CGF, 
                   /*const*/ CXXNewExpr /*P*/ e, 
                   /*uint*/int minElements, 
                   final type$ref<Value /*P*/ /*&*/> numElements, 
                   final type$ref<Value /*P*/ /*&*/> sizeWithoutCookie) {
  QualType type = e.getAllocatedType();
  if (!e.isArray()) {
    CharUnits typeSize = CGF.getContext().getTypeSizeInChars(/*NO_COPY*/type);
    sizeWithoutCookie.$set(ConstantInt.get(CGF.Unnamed_field8.SizeTy, typeSize.getQuantity()));
    return sizeWithoutCookie.$deref();
  }
  
  // The width of size_t.
  /*uint*/int sizeWidth = CGF.Unnamed_field8.SizeTy.getBitWidth();
  
  // Figure out the cookie size.
  APInt cookieSize/*J*/= new APInt(JD$UInt_ULong.INSTANCE, sizeWidth, 
      CalculateCookiePadding(CGF, e).getQuantity());
  
  // Emit the array size expression.
  // We multiply the size of all dimensions for NumElements.
  // e.g for 'int[2][3]', ElemType is 'int' and NumElements is 6.
  numElements.$set(CGF.EmitScalarExpr(e.getArraySize$Const()));
  assert (isa_IntegerType(numElements.$deref().getType()));
  
  // The number of elements can be have an arbitrary integer type;
  // essentially, we need to multiply it by a constant factor, add a
  // cookie size, and verify that the result is representable as a
  // size_t.  That's just a gloss, though, and it's wrong in one
  // important way: if the count is negative, it's an error even if
  // the cookie size would bring the total size >= 0.
  boolean isSigned = e.getArraySize$Const().getType().$arrow().isSignedIntegerOrEnumerationType();
  IntegerType /*P*/ numElementsType = cast_IntegerType(numElements.$deref().getType());
  /*uint*/int numElementsWidth = numElementsType.getBitWidth();
  
  // Compute the constant factor.
  APInt arraySizeMultiplier/*J*/= new APInt(JD$UInt_ULong.INSTANCE, sizeWidth, $int2ulong(1));
  {
    /*const*/ ConstantArrayType /*P*/ CAT;
    while (((/*P*/ CAT = CGF.getContext().getAsConstantArrayType(new QualType(type))) != null)) {
      type.$assignMove(CAT.getElementType());
      arraySizeMultiplier.$starassign(CAT.getSize());
    }
  }
  
  CharUnits typeSize = CGF.getContext().getTypeSizeInChars(/*NO_COPY*/type);
  APInt typeSizeMultiplier/*J*/= new APInt(JD$UInt_ULong.INSTANCE, sizeWidth, typeSize.getQuantity());
  typeSizeMultiplier.$starassign(arraySizeMultiplier);
  
  // This will be a size_t.
  Value /*P*/ size;
  {
    
    // If someone is doing 'new int[42]' there is no need to do a dynamic check.
    // Don't bloat the -O0 code.
    ConstantInt /*P*/ numElementsC = dyn_cast_ConstantInt(numElements.$deref());
    if ((numElementsC != null)) {
      final /*const*/ APInt /*&*/ count = numElementsC.getValue();
      
      boolean hasAnyOverflow = false;
      
      // If 'count' was a negative number, it's an overflow.
      if (isSigned && count.isNegative()) {
        hasAnyOverflow = true;
      } else 
      // We want to do all this arithmetic in size_t.  If numElements is
      // wider than that, check whether it's already too big, and if so,
      // overflow.
      if ($greater_uint(numElementsWidth, sizeWidth)
         && $greater_uint(numElementsWidth - sizeWidth, count.countLeadingZeros())) {
        hasAnyOverflow = true;
      }
      
      // Okay, compute a count at the right width.
      APInt adjustedCount = count.zextOrTrunc(sizeWidth);
      
      // If there is a brace-initializer, we cannot allocate fewer elements than
      // there are initializers. If we do, that's treated like an overflow.
      if (adjustedCount.ult($uint2ulong(minElements))) {
        hasAnyOverflow = true;
      }
      
      // Scale numElements by that.  This might overflow, but we don't
      // care because it only overflows if allocationSize does, too, and
      // if that overflows then we shouldn't use this.
      numElements.$set(ConstantInt.get(CGF.Unnamed_field8.SizeTy, 
          adjustedCount.$star(arraySizeMultiplier)));
      
      // Compute the size before cookie, and track whether it overflowed.
      bool$ref overflow = create_bool$ref();
      APInt allocationSize = adjustedCount.umul_ov(typeSizeMultiplier, overflow);
      hasAnyOverflow |= overflow.$deref();
      
      // Add in the cookie, and check whether it's overflowed.
      if (cookieSize.$noteq($int2ulong(0))) {
        // Save the current size without a cookie.  This shouldn't be
        // used if there was overflow.
        sizeWithoutCookie.$set(ConstantInt.get(CGF.Unnamed_field8.SizeTy, allocationSize));
        
        allocationSize.$assignMove(allocationSize.uadd_ov(cookieSize, overflow));
        hasAnyOverflow |= overflow.$deref();
      }
      
      // On overflow, produce a -1 so operator new will fail.
      if (hasAnyOverflow) {
        size = Constant.getAllOnesValue(CGF.Unnamed_field8.SizeTy);
      } else {
        size = ConstantInt.get(CGF.Unnamed_field8.SizeTy, allocationSize);
      }
      // Otherwise, we might need to use the overflow intrinsics.
    } else {
      // There are up to five conditions we need to test for:
      // 1) if isSigned, we need to check whether numElements is negative;
      // 2) if numElementsWidth > sizeWidth, we need to check whether
      //   numElements is larger than something representable in size_t;
      // 3) if minElements > 0, we need to check whether numElements is smaller
      //    than that.
      // 4) we need to compute
      //      sizeWithoutCookie := numElements * typeSizeMultiplier
      //    and check whether it overflows; and
      // 5) if we need a cookie, we need to compute
      //      size := sizeWithoutCookie + cookieSize
      //    and check whether it overflows.
      Value /*P*/ hasOverflow = null;
      
      // If numElementsWidth > sizeWidth, then one way or another, we're
      // going to have to do a comparison for (2), and this happens to
      // take care of (1), too.
      if ($greater_uint(numElementsWidth, sizeWidth)) {
        APInt threshold/*J*/= new APInt(JD$UInt_ULong.INSTANCE, numElementsWidth, $int2ulong(1));
        threshold.$lshiftassign(sizeWidth);
        
        Value /*P*/ thresholdV = ConstantInt.get(numElementsType, threshold);
        
        hasOverflow = CGF.Builder.CreateICmpUGE(numElements.$deref(), thresholdV);
        numElements.$set(CGF.Builder.CreateTrunc(numElements.$deref(), CGF.Unnamed_field8.SizeTy));
        // Otherwise, if we're signed, we want to sext up to size_t.
      } else if (isSigned) {
        if ($less_uint(numElementsWidth, sizeWidth)) {
          numElements.$set(CGF.Builder.CreateSExt(numElements.$deref(), CGF.Unnamed_field8.SizeTy));
        }
        
        // If there's a non-1 type size multiplier, then we can do the
        // signedness check at the same time as we do the multiply
        // because a negative number times anything will cause an
        // unsigned overflow.  Otherwise, we have to do it here. But at least
        // in this case, we can subsume the >= minElements check.
        if (typeSizeMultiplier.$eq($int2ulong(1))) {
          hasOverflow = CGF.Builder.CreateICmpSLT(numElements.$deref(), 
              ConstantInt.get(CGF.Unnamed_field8.SizeTy, $uint2ulong(minElements)));
        }
        // Otherwise, zext up to size_t if necessary.
      } else if ($less_uint(numElementsWidth, sizeWidth)) {
        numElements.$set(CGF.Builder.CreateZExt(numElements.$deref(), CGF.Unnamed_field8.SizeTy));
      }
      assert (numElements.$deref().getType() == CGF.Unnamed_field8.SizeTy);
      if ((minElements != 0)) {
        // Don't allow allocation of fewer elements than we have initializers.
        if (!(hasOverflow != null)) {
          hasOverflow = CGF.Builder.CreateICmpULT(numElements.$deref(), 
              ConstantInt.get(CGF.Unnamed_field8.SizeTy, $uint2ulong(minElements)));
        } else if ($greater_uint(numElementsWidth, sizeWidth)) {
          // The other existing overflow subsumes this check.
          // We do an unsigned comparison, since any signed value < -1 is
          // taken care of either above or below.
          hasOverflow = CGF.Builder.CreateOr(hasOverflow, 
              CGF.Builder.CreateICmpULT(numElements.$deref(), 
                  ConstantInt.get(CGF.Unnamed_field8.SizeTy, $uint2ulong(minElements))));
        }
      }
      
      size = numElements.$deref();
      
      // Multiply by the type size if necessary.  This multiplier
      // includes all the factors for nested arrays.
      //
      // This step also causes numElements to be scaled up by the
      // nested-array factor if necessary.  Overflow on this computation
      // can be ignored because the result shouldn't be used if
      // allocation fails.
      if (typeSizeMultiplier.$noteq($int2ulong(1))) {
        Value /*P*/ umul_with_overflow = CGF.CGM.getIntrinsic(ID.umul_with_overflow, new ArrayRef<org.llvm.ir.Type /*P*/ >(CGF.Unnamed_field8.SizeTy, true));
        
        Value /*P*/ tsmV = ConstantInt.get(CGF.Unnamed_field8.SizeTy, typeSizeMultiplier);
        Value /*P*/ result = CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(umul_with_overflow, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {size, tsmV}, true)/* }*/);
        
        Value /*P*/ overflowed = CGF.Builder.CreateExtractValue(result, new ArrayRefUInt(1));
        if ((hasOverflow != null)) {
          hasOverflow = CGF.Builder.CreateOr(hasOverflow, overflowed);
        } else {
          hasOverflow = overflowed;
        }
        
        size = CGF.Builder.CreateExtractValue(result, new ArrayRefUInt(0));
        
        // Also scale up numElements by the array size multiplier.
        if (arraySizeMultiplier.$noteq($int2ulong(1))) {
          // If the base element type size is 1, then we can re-use the
          // multiply we just did.
          if (typeSize.isOne()) {
            assert (arraySizeMultiplier.$eq(typeSizeMultiplier));
            numElements.$set(size);
            // Otherwise we need a separate multiply.
          } else {
            Value /*P*/ asmV = ConstantInt.get(CGF.Unnamed_field8.SizeTy, arraySizeMultiplier);
            numElements.$set(CGF.Builder.CreateMul(numElements.$deref(), asmV));
          }
        }
      } else {
        // numElements doesn't need to be scaled.
        assert (arraySizeMultiplier.$eq($int2ulong(1)));
      }
      
      // Add in the cookie size if necessary.
      if (cookieSize.$noteq($int2ulong(0))) {
        sizeWithoutCookie.$set(size);
        
        Value /*P*/ uadd_with_overflow = CGF.CGM.getIntrinsic(ID.uadd_with_overflow, new ArrayRef<org.llvm.ir.Type /*P*/ >(CGF.Unnamed_field8.SizeTy, true));
        
        Value /*P*/ cookieSizeV = ConstantInt.get(CGF.Unnamed_field8.SizeTy, cookieSize);
        Value /*P*/ result = CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(uadd_with_overflow, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {size, cookieSizeV}, true)/* }*/);
        
        Value /*P*/ overflowed = CGF.Builder.CreateExtractValue(result, new ArrayRefUInt(1));
        if ((hasOverflow != null)) {
          hasOverflow = CGF.Builder.CreateOr(hasOverflow, overflowed);
        } else {
          hasOverflow = overflowed;
        }
        
        size = CGF.Builder.CreateExtractValue(result, new ArrayRefUInt(0));
      }
      
      // If we had any possibility of dynamic overflow, make a select to
      // overwrite 'size' with an all-ones value, which should cause
      // operator new to throw.
      if ((hasOverflow != null)) {
        size = CGF.Builder.CreateSelect(hasOverflow, 
            Constant.getAllOnesValue(CGF.Unnamed_field8.SizeTy), 
            size);
      }
    }
  }
  if (cookieSize.$eq($int2ulong(0))) {
    sizeWithoutCookie.$set(size);
  } else {
    assert ((sizeWithoutCookie.$deref() != null)) : "didn't set sizeWithoutCookie?";
  }
  
  return size;
}

//<editor-fold defaultstate="collapsed" desc="StoreAnyExprIntoOneUnit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 806,
 FQN="StoreAnyExprIntoOneUnit", NM="_ZL23StoreAnyExprIntoOneUnitRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprENS_8QualTypeENS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZL23StoreAnyExprIntoOneUnitRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprENS_8QualTypeENS0_7AddressE")
//</editor-fold>
public static void StoreAnyExprIntoOneUnit(final CodeGenFunction /*&*/ CGF, /*const*/ Expr /*P*/ Init, 
                       QualType AllocType, Address NewPtr) {
  // FIXME: Refactor with EmitExprAsInit.
  switch (CGF.getEvaluationKind(new QualType(AllocType))) {
   case TEK_Scalar:
    CGF.EmitScalarInit(Init, (/*const*/ ValueDecl /*P*/ )null, 
        CGF.MakeAddrLValue(new Address(NewPtr), new QualType(AllocType)), false);
    return;
   case TEK_Complex:
    CGF.EmitComplexExprIntoLValue(Init, CGF.MakeAddrLValue(new Address(NewPtr), new QualType(AllocType)), 
        /*isInit*/ true);
    return;
   case TEK_Aggregate:
    {
      AggValueSlot Slot = AggValueSlot.forAddr(new Address(NewPtr), AllocType.getQualifiers(), 
          AggValueSlot.IsDestructed_t.IsDestructed, 
          AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers, 
          AggValueSlot.IsAliased_t.IsNotAliased);
      CGF.EmitAggExpr(Init, new AggValueSlot(Slot));
      return;
    }
  }
  throw new llvm_unreachable("bad evaluation kind");
}

//<editor-fold defaultstate="collapsed" desc="EmitNewInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1098,
 FQN="EmitNewInitializer", NM="_ZL18EmitNewInitializerRN5clang7CodeGen15CodeGenFunctionEPKNS_10CXXNewExprENS_8QualTypeEPN4llvm4TypeENS0_7AddressEPNS7_5ValueESC_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZL18EmitNewInitializerRN5clang7CodeGen15CodeGenFunctionEPKNS_10CXXNewExprENS_8QualTypeEPN4llvm4TypeENS0_7AddressEPNS7_5ValueESC_")
//</editor-fold>
public static void EmitNewInitializer(final CodeGenFunction /*&*/ CGF, /*const*/ CXXNewExpr /*P*/ E, 
                  QualType ElementType, org.llvm.ir.Type /*P*/ ElementTy, 
                  Address NewPtr, Value /*P*/ NumElements, 
                  Value /*P*/ AllocSizeWithoutCookie) {
  ApplyDebugLocation DL = null;
  try {
    DL/*J*/= new ApplyDebugLocation(CGF, E);
    if (E.isArray()) {
      CGF.EmitNewArrayInitializer(E, new QualType(ElementType), ElementTy, new Address(NewPtr), NumElements, 
          AllocSizeWithoutCookie);
    } else {
      /*const*/ Expr /*P*/ Init = E.getInitializer$Const();
      if ((Init != null)) {
        StoreAnyExprIntoOneUnit(CGF, Init, E.getAllocatedType(), new Address(NewPtr));
      }
    }
  } finally {
    if (DL != null) { DL.$destroy(); }
  }
}


/// Emit a call to an operator new or operator delete function, as implicitly
/// created by new-expressions and delete-expressions.
//<editor-fold defaultstate="collapsed" desc="EmitNewDeleteCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1112,
 FQN="EmitNewDeleteCall", NM="_ZL17EmitNewDeleteCallRN5clang7CodeGen15CodeGenFunctionEPKNS_12FunctionDeclEPKNS_17FunctionProtoTypeERKNS0_11CallArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZL17EmitNewDeleteCallRN5clang7CodeGen15CodeGenFunctionEPKNS_12FunctionDeclEPKNS_17FunctionProtoTypeERKNS0_11CallArgListE")
//</editor-fold>
public static RValue EmitNewDeleteCall(final CodeGenFunction /*&*/ CGF, 
                 /*const*/ FunctionDecl /*P*/ Callee, 
                 /*const*/ FunctionProtoType /*P*/ CalleeType, 
                 final /*const*/ CallArgList /*&*/ Args) {
  type$ptr<Instruction /*P*/ > CallOrInvoke = create_type$null$ptr();
  Value /*P*/ CalleeAddr = CGF.CGM.GetAddrOfFunction(new GlobalDecl(Callee));
  RValue RV = CGF.EmitCall(CGF.CGM.getTypes().arrangeFreeFunctionCall(Args, CalleeType, /*chainCall=*/ false), 
      CalleeAddr, new ReturnValueSlot(), Args, new CGCalleeInfo(Callee), $AddrOf(CallOrInvoke));
  
  /// C++1y [expr.new]p10:
  ///   [In a new-expression,] an implementation is allowed to omit a call
  ///   to a replaceable global allocation function.
  ///
  /// We model such elidable calls with the 'builtin' attribute.
  Function /*P*/ Fn = dyn_cast_Function(CalleeAddr);
  if (Callee.isReplaceableGlobalAllocationFunction()
     && (Fn != null) && Fn.hasFnAttribute(Attribute.AttrKind.NoBuiltin)) {
    {
      // FIXME: Add addAttribute to CallSite.
      CallInst /*P*/ CI = dyn_cast_CallInst(CallOrInvoke.$star());
      if ((CI != null)) {
        CI.addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), 
            Attribute.AttrKind.Builtin);
      } else {
        InvokeInst /*P*/ II = dyn_cast_InvokeInst(CallOrInvoke.$star());
        if ((II != null)) {
          II.addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), 
              Attribute.AttrKind.Builtin);
        } else {
          throw new llvm_unreachable("unexpected kind of call instruction");
        }
      }
    }
  }
  
  return RV;
}


/// Enter a cleanup to call 'operator delete' if the initializer in a
/// new-expression throws.
//<editor-fold defaultstate="collapsed" desc="EnterNewDeleteCleanup">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1277,
 FQN="EnterNewDeleteCleanup", NM="_ZL21EnterNewDeleteCleanupRN5clang7CodeGen15CodeGenFunctionEPKNS_10CXXNewExprENS0_7AddressEPN4llvm5ValueERKNS0_11CallArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZL21EnterNewDeleteCleanupRN5clang7CodeGen15CodeGenFunctionEPKNS_10CXXNewExprENS0_7AddressEPN4llvm5ValueERKNS0_11CallArgListE")
//</editor-fold>
public static void EnterNewDeleteCleanup(final CodeGenFunction /*&*/ CGF, 
                     /*const*/ CXXNewExpr /*P*/ E, 
                     Address NewPtr, 
                     Value /*P*/ AllocSize, 
                     final /*const*/ CallArgList /*&*/ NewArgs) {
  // If we're not inside a conditional branch, then the cleanup will
  // dominate and we can do the easier (and more efficient) thing.
  if (!CGF.isInConditionalBranch()) {
    CallDeleteDuringNew /*P*/ Cleanup = CGF.EHStack.
        pushCleanupWithExtra$CallDeleteDuringNew(CleanupKind.EHCleanup, 
        E.getNumPlacementArgs(), 
        () -> new CallDeleteDuringNew(
        E.getNumPlacementArgs(), 
        E.getOperatorDelete(), 
        NewPtr.getPointer(), 
        AllocSize));
    for (/*uint*/int I = 0, N = E.getNumPlacementArgs(); I != N; ++I)  {
      Cleanup.setPlacementArg(I, new RValue(NewArgs.$at$Const(I + 1).RV));
    }
    
    return;
  }
  
  // Otherwise, we need to save all this stuff.
  DominatingValueRValue.saved_type SavedNewPtr = DominatingValueRValue.save(CGF, RValue.get(NewPtr.getPointer()));
  DominatingValueRValue.saved_type SavedAllocSize = DominatingValueRValue.save(CGF, RValue.get(AllocSize));
  
  CallDeleteDuringConditionalNew /*P*/ Cleanup = CGF.EHStack.
      pushCleanupWithExtra$CallDeleteDuringConditionalNew(CleanupKind.EHCleanup, 
      E.getNumPlacementArgs(), 
      () -> new CallDeleteDuringConditionalNew(E.getNumPlacementArgs(), 
      E.getOperatorDelete(), 
      new DominatingValueRValue.saved_type(SavedNewPtr), 
      new DominatingValueRValue.saved_type(SavedAllocSize)));
  for (/*uint*/int I = 0, N = E.getNumPlacementArgs(); I != N; ++I)  {
    Cleanup.setPlacementArg(I, 
        DominatingValueRValue.save(CGF, new RValue(NewArgs.$at$Const(I + 1).RV)));
  }
  
  CGF.initFullExprCleanup();
}


/// Emit the code for deleting a single object.
//<editor-fold defaultstate="collapsed" desc="EmitObjectDelete">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1545,
 FQN="EmitObjectDelete", NM="_ZL16EmitObjectDeleteRN5clang7CodeGen15CodeGenFunctionEPKNS_13CXXDeleteExprENS0_7AddressENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZL16EmitObjectDeleteRN5clang7CodeGen15CodeGenFunctionEPKNS_13CXXDeleteExprENS0_7AddressENS_8QualTypeE")
//</editor-fold>
public static void EmitObjectDelete(final CodeGenFunction /*&*/ CGF, 
                /*const*/ CXXDeleteExpr /*P*/ DE, 
                Address Ptr, 
                QualType ElementType) {
  // Find the destructor for the type, if applicable.  If the
  // destructor is virtual, we'll just emit the vcall and return.
  /*const*/ CXXDestructorDecl /*P*/ Dtor = null;
  {
    /*const*/ RecordType /*P*/ RT = ElementType.$arrow().getAs$RecordType();
    if ((RT != null)) {
      CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(RT.getDecl());
      if (RD.hasDefinition() && !RD.hasTrivialDestructor()) {
        Dtor = RD.getDestructor();
        if (Dtor.isVirtual()) {
          CGF.CGM.getCXXABI().emitVirtualObjectDelete(CGF, DE, new Address(Ptr), new QualType(ElementType), 
              Dtor);
          return;
        }
      }
    }
  }
  
  // Make sure that we call delete even if the dtor throws.
  // This doesn't have to a conditional cleanup because we're going
  // to pop it off in a second.
  /*const*/ FunctionDecl /*P*/ OperatorDelete = DE.getOperatorDelete();
  CGF.EHStack.<CallObjectDelete>pushCleanup$T(CleanupKind.NormalAndEHCleanup, 
      () -> new CallObjectDelete(
      Ptr.getPointer(), 
      OperatorDelete, new QualType(ElementType)));
  if ((Dtor != null)) {
    CGF.EmitCXXDestructorCall(Dtor, CXXDtorType.Dtor_Complete, 
        /*ForVirtualBase=*/ false, 
        /*Delegating=*/ false, 
        new Address(Ptr));
  } else {
    Qualifiers.ObjCLifetime Lifetime = ElementType.getObjCLifetime();
    if ((Lifetime.getValue() != 0)) {
      switch (Lifetime) {
       case OCL_None:
       case OCL_ExplicitNone:
       case OCL_Autoreleasing:
        break;
       case OCL_Strong:
        CGF.EmitARCDestroyStrong(new Address(Ptr), ARCPreciseLifetime_t.ARCPreciseLifetime);
        break;
       case OCL_Weak:
        CGF.EmitARCDestroyWeak(new Address(Ptr));
        break;
      }
    }
  }
  
  CGF.PopCleanupBlock();
}


/// Emit the code for deleting an array of objects.
//<editor-fold defaultstate="collapsed" desc="EmitArrayDelete">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1660,
 FQN="EmitArrayDelete", NM="_ZL15EmitArrayDeleteRN5clang7CodeGen15CodeGenFunctionEPKNS_13CXXDeleteExprENS0_7AddressENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZL15EmitArrayDeleteRN5clang7CodeGen15CodeGenFunctionEPKNS_13CXXDeleteExprENS0_7AddressENS_8QualTypeE")
//</editor-fold>
public static void EmitArrayDelete(final CodeGenFunction /*&*/ CGF, 
               /*const*/ CXXDeleteExpr /*P*/ E, 
               Address deletedPtr, 
               QualType elementType) {
  type$ref<Value /*P*/ > numElements = create_type$null$ref(null);
  type$ref<Value /*P*/ > allocatedPtr = create_type$null$ref(null);
  CharUnits cookieSize/*J*/= new CharUnits();
  CGF.CGM.getCXXABI().ReadArrayCookie(CGF, new Address(deletedPtr), E, new QualType(elementType), 
      numElements, allocatedPtr, cookieSize);
  assert ((allocatedPtr.$deref() != null)) : "ReadArrayCookie didn't set allocated pointer";
  
  // Make sure that we call delete even if one of the dtors throws.
  /*const*/ FunctionDecl /*P*/ operatorDelete = E.getOperatorDelete();
  CGF.EHStack.<CallArrayDelete>pushCleanup$T(CleanupKind.NormalAndEHCleanup, 
      () -> new CallArrayDelete(
      allocatedPtr.$deref(), operatorDelete, 
      numElements.$deref(), new QualType(elementType), 
      new CharUnits(cookieSize)));
  {
    
    // Destroy the elements.
    QualType.DestructionKind dtorKind = elementType.isDestructedType();
    if ((dtorKind.getValue() != 0)) {
      assert ((numElements.$deref() != null)) : "no element count for a type with a destructor!";
      
      CharUnits elementSize = CGF.getContext().getTypeSizeInChars(/*NO_COPY*/elementType);
      CharUnits elementAlign = deletedPtr.getAlignment().alignmentOfArrayElement(new CharUnits(elementSize));
      
      Value /*P*/ arrayBegin = deletedPtr.getPointer();
      Value /*P*/ arrayEnd = CGF.Builder.CreateInBoundsGEP(arrayBegin, new ArrayRef<Value /*P*/ >(numElements.$deref(), true), new Twine(/*KEEP_STR*/"delete.end"));
      
      // Note that it is legal to allocate a zero-length array, and we
      // can never fold the check away because the length should always
      // come from a cookie.
      CGF.emitArrayDestroy(arrayBegin, arrayEnd, new QualType(elementType), new CharUnits(elementAlign), 
          CGF.getDestroyer(dtorKind), 
          /*checkZeroLength*/ true, 
          CGF.needsEHCleanup(dtorKind));
    }
  }
  
  // Pop the cleanup block.
  CGF.PopCleanupBlock();
}

//<editor-fold defaultstate="collapsed" desc="isGLValueFromPointerDeref">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1752,
 FQN="isGLValueFromPointerDeref", NM="_ZL25isGLValueFromPointerDerefPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZL25isGLValueFromPointerDerefPKN5clang4ExprE")
//</editor-fold>
public static boolean isGLValueFromPointerDeref(/*const*/ Expr /*P*/ E) {
  E = E.IgnoreParens$Const();
  {
    
    /*const*/ CastExpr /*P*/ CE = dyn_cast_CastExpr(E);
    if ((CE != null)) {
      if (!CE.getSubExpr$Const().isGLValue()) {
        return false;
      }
      return isGLValueFromPointerDeref(CE.getSubExpr$Const());
    }
  }
  {
    
    /*const*/ OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(E);
    if ((OVE != null)) {
      return isGLValueFromPointerDeref(OVE.getSourceExpr());
    }
  }
  {
    
    /*const*/ org.clang.ast.BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(E);
    if ((BO != null)) {
      if (BO.getOpcode() == BinaryOperatorKind.BO_Comma) {
        return isGLValueFromPointerDeref(BO.getRHS());
      }
    }
  }
  {
    
    /*const*/ AbstractConditionalOperator /*P*/ ACO = dyn_cast_AbstractConditionalOperator(E);
    if ((ACO != null)) {
      return isGLValueFromPointerDeref(ACO.getTrueExpr())
         || isGLValueFromPointerDeref(ACO.getFalseExpr());
    }
  }
  
  // C++11 [expr.sub]p1:
  //   The expression E1[E2] is identical (by definition) to *((E1)+(E2))
  if (isa_ArraySubscriptExpr(E)) {
    return true;
  }
  {
    
    /*const*/ UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(E);
    if ((UO != null)) {
      if (UO.getOpcode() == UnaryOperatorKind.UO_Deref) {
        return true;
      }
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="EmitTypeidFromVTable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1784,
 FQN="EmitTypeidFromVTable", NM="_ZL20EmitTypeidFromVTableRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprEPN4llvm4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZL20EmitTypeidFromVTableRN5clang7CodeGen15CodeGenFunctionEPKNS_4ExprEPN4llvm4TypeE")
//</editor-fold>
public static Value /*P*/ EmitTypeidFromVTable(final CodeGenFunction /*&*/ CGF, /*const*/ Expr /*P*/ E, 
                    org.llvm.ir.Type /*P*/ StdTypeInfoPtrTy) {
  // Get the vtable pointer.
  Address ThisPtr = CGF.EmitLValue(E).getAddress();
  
  // C++ [expr.typeid]p2:
  //   If the glvalue expression is obtained by applying the unary * operator to
  //   a pointer and the pointer is a null pointer value, the typeid expression
  //   throws the std::bad_typeid exception.
  //
  // However, this paragraph's intent is not clear.  We choose a very generous
  // interpretation which implores us to consider comma operators, conditional
  // operators, parentheses and other such constructs.
  QualType SrcRecordTy = E.getType();
  if (CGF.CGM.getCXXABI().shouldTypeidBeNullChecked(isGLValueFromPointerDeref(E), new QualType(SrcRecordTy))) {
    BasicBlock /*P*/ BadTypeidBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"typeid.bad_typeid"));
    BasicBlock /*P*/ EndBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"typeid.end"));
    
    Value /*P*/ IsNull = CGF.Builder.CreateIsNull(ThisPtr.getPointer());
    CGF.Builder.CreateCondBr(IsNull, BadTypeidBlock, EndBlock);
    
    CGF.EmitBlock(BadTypeidBlock);
    CGF.CGM.getCXXABI().EmitBadTypeidCall(CGF);
    CGF.EmitBlock(EndBlock);
  }
  
  return CGF.CGM.getCXXABI().EmitTypeid(CGF, new QualType(SrcRecordTy), new Address(ThisPtr), 
      StdTypeInfoPtrTy);
}

//<editor-fold defaultstate="collapsed" desc="EmitDynamicCastToNull">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1840,
 FQN="EmitDynamicCastToNull", NM="_ZL21EmitDynamicCastToNullRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZL21EmitDynamicCastToNullRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeE")
//</editor-fold>
public static Value /*P*/ EmitDynamicCastToNull(final CodeGenFunction /*&*/ CGF, 
                     QualType DestTy) {
  org.llvm.ir.Type /*P*/ DestLTy = CGF.ConvertType(new QualType(DestTy));
  if (DestTy.$arrow().isPointerType()) {
    return Constant.getNullValue(DestLTy);
  }
  
  /// C++ [expr.dynamic.cast]p9:
  ///   A failed cast to reference type throws std::bad_cast
  if (!CGF.CGM.getCXXABI().EmitBadCastCall(CGF)) {
    return null;
  }
  
  CGF.EmitBlock(CGF.createBasicBlock(new Twine(/*KEEP_STR*/"dynamic_cast.end")));
  return UndefValue.get(DestLTy);
}

} // END OF class CGExprCXXStatics
