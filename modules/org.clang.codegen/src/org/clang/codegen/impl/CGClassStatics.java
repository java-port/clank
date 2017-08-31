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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CGClassStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZL19EmitBaseInitializerRN5clang7CodeGen15CodeGenFunctionEPKNS_13CXXRecordDeclEPNS_18CXXCtorInitializerENS_11CXXCtorTypeE;_ZL21EmitMemberInitializerRN5clang7CodeGen15CodeGenFunctionEPKNS_13CXXRecordDeclEPNS_18CXXCtorInitializerEPKNS_18CXXConstructorDeclERNS0_15FunctionArgListE;_ZL22skipNoOpCastsAndParensPKN5clang4ExprE;_ZL23BaseInitializerUsesThisRN5clang10ASTContextEPKNS_4ExprE;_ZL23canEmitDelegateCallArgsRN5clang7CodeGen15CodeGenFunctionEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeERNS0_11CallArgListE;_ZL24EmitAggMemberInitializerRN5clang7CodeGen15CodeGenFunctionENS0_6LValueEPNS_4ExprENS0_7AddressENS_8QualTypeEN4llvm8ArrayRefIPNS_7VarDeclEEEj;_ZL24HasTrivialDestructorBodyRN5clang10ASTContextEPKNS_13CXXRecordDeclES4_;_ZL27isInitializerOfDynamicClassPKN5clang18CXXCtorInitializerE;_ZL28IsConstructorDelegationValidPKN5clang18CXXConstructorDeclE;_ZL29FieldHasTrivialDestructorBodyRN5clang10ASTContextEPKNS_9FieldDeclE;_ZL31ApplyNonVirtualAndVirtualOffsetRN5clang7CodeGen15CodeGenFunctionENS0_7AddressENS_9CharUnitsEPN4llvm5ValueEPKNS_13CXXRecordDeclESA_;_ZL31LeastDerivedClassWithSameLayoutPKN5clang13CXXRecordDeclE;_ZL31isMemcpyEquivalentSpecialMemberPKN5clang13CXXMethodDeclE;_ZL34CanSkipVTablePointerInitializationRN5clang7CodeGen15CodeGenFunctionEPKNS_17CXXDestructorDeclE;_ZL35EmitLValueForAnyFieldInitializationRN5clang7CodeGen15CodeGenFunctionEPNS_18CXXCtorInitializerERNS0_6LValueE;_ZN12_GLOBAL__N_1L25EmitSanitizerDtorCallbackERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueEx; -static-type=CGClassStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGClassStatics {

//<editor-fold defaultstate="collapsed" desc="ApplyNonVirtualAndVirtualOffset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 224,
 FQN="ApplyNonVirtualAndVirtualOffset", NM="_ZL31ApplyNonVirtualAndVirtualOffsetRN5clang7CodeGen15CodeGenFunctionENS0_7AddressENS_9CharUnitsEPN4llvm5ValueEPKNS_13CXXRecordDeclESA_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZL31ApplyNonVirtualAndVirtualOffsetRN5clang7CodeGen15CodeGenFunctionENS0_7AddressENS_9CharUnitsEPN4llvm5ValueEPKNS_13CXXRecordDeclESA_")
//</editor-fold>
public static Address ApplyNonVirtualAndVirtualOffset(final CodeGenFunction /*&*/ CGF, Address addr, 
                               CharUnits nonVirtualOffset, 
                               Value /*P*/ virtualOffset, 
                               /*const*/ CXXRecordDecl /*P*/ derivedClass, 
                               /*const*/ CXXRecordDecl /*P*/ nearestVBase) {
  // Assert that we have something to do.
  assert (!nonVirtualOffset.isZero() || virtualOffset != null);
  
  // Compute the offset from the static and dynamic components.
  Value /*P*/ baseOffset;
  if (!nonVirtualOffset.isZero()) {
    baseOffset = ConstantInt.get(CGF.Unnamed_field8.PtrDiffTy, 
        nonVirtualOffset.getQuantity());
    if ((virtualOffset != null)) {
      baseOffset = CGF.Builder.CreateAdd(virtualOffset, baseOffset);
    }
  } else {
    baseOffset = virtualOffset;
  }
  
  // Apply the base offset.
  Value /*P*/ ptr = addr.getPointer();
  ptr = CGF.Builder.CreateBitCast(ptr, CGF.Unnamed_field9.Int8PtrTy);
  ptr = CGF.Builder.CreateInBoundsGEP(ptr, new ArrayRef<Value /*P*/ >(baseOffset, true), new Twine(/*KEEP_STR*/"add.ptr"));
  
  // If we have a virtual component, the alignment of the result will
  // be relative only to the known alignment of that vbase.
  CharUnits alignment/*J*/= new CharUnits();
  if ((virtualOffset != null)) {
    assert ((nearestVBase != null)) : "virtual offset without vbase?";
    alignment.$assignMove(CGF.CGM.getVBaseAlignment(addr.getAlignment(), 
            derivedClass, nearestVBase));
  } else {
    alignment.$assignMove(addr.getAlignment());
  }
  alignment.$assignMove(alignment.alignmentAtOffset(new CharUnits(nonVirtualOffset)));
  
  return new Address(ptr, new CharUnits(alignment));
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="BaseInitializerUsesThis">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 514,
 FQN="BaseInitializerUsesThis", NM="_ZL23BaseInitializerUsesThisRN5clang10ASTContextEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZL23BaseInitializerUsesThisRN5clang10ASTContextEPKNS_4ExprE")
//</editor-fold>
public static boolean BaseInitializerUsesThis(final ASTContext /*&*/ C, /*const*/ Expr /*P*/ Init) {
  DynamicThisUseChecker Checker/*J*/= new DynamicThisUseChecker(C);
  Checker.Visit(Init);
  return Checker.UsesThis;
}

//<editor-fold defaultstate="collapsed" desc="EmitBaseInitializer">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 520,
 FQN="EmitBaseInitializer", NM="_ZL19EmitBaseInitializerRN5clang7CodeGen15CodeGenFunctionEPKNS_13CXXRecordDeclEPNS_18CXXCtorInitializerENS_11CXXCtorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZL19EmitBaseInitializerRN5clang7CodeGen15CodeGenFunctionEPKNS_13CXXRecordDeclEPNS_18CXXCtorInitializerENS_11CXXCtorTypeE")
//</editor-fold>
public static void EmitBaseInitializer(final CodeGenFunction /*&*/ CGF, 
                   /*const*/ CXXRecordDecl /*P*/ ClassDecl, 
                   CXXCtorInitializer /*P*/ BaseInit, 
                   CXXCtorType CtorType) {
  assert (BaseInit.isBaseInitializer()) : "Must have base initializer!";
  
  Address ThisPtr = CGF.LoadCXXThisAddress();
  
  /*const*/ org.clang.ast.Type /*P*/ BaseType = BaseInit.getBaseClass();
  CXXRecordDecl /*P*/ BaseClassDecl = cast_CXXRecordDecl(BaseType.getAs$RecordType().getDecl());
  
  boolean isBaseVirtual = BaseInit.isBaseVirtual();
  
  // The base constructor doesn't construct virtual bases.
  if (CtorType == CXXCtorType.Ctor_Base && isBaseVirtual) {
    return;
  }
  
  // If the initializer for the base (other than the constructor
  // itself) accesses 'this' in any way, we need to initialize the
  // vtables.
  if (BaseInitializerUsesThis(CGF.getContext(), BaseInit.getInit())) {
    CGF.InitializeVTablePointers(ClassDecl);
  }
  
  // We can pretend to be a complete class because it only matters for
  // virtual bases, and we only do virtual bases for complete ctors.
  Address V = CGF.GetAddressOfDirectBaseInCompleteClass(new Address(ThisPtr), ClassDecl, 
      BaseClassDecl, 
      isBaseVirtual);
  AggValueSlot AggSlot = AggValueSlot.forAddr(new Address(V), new Qualifiers(), 
      AggValueSlot.IsDestructed_t.IsDestructed, 
      AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers, 
      AggValueSlot.IsAliased_t.IsNotAliased);
  
  CGF.EmitAggExpr(BaseInit.getInit(), new AggValueSlot(AggSlot));
  if (CGF.CGM.getLangOpts().Exceptions
     && !BaseClassDecl.hasTrivialDestructor()) {
    CGF.EHStack.<CallBaseDtor>pushCleanup$T(CleanupKind.EHCleanup, () -> new CallBaseDtor(BaseClassDecl, 
        isBaseVirtual));
  }
}

//<editor-fold defaultstate="collapsed" desc="EmitAggMemberInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 565,
 FQN="EmitAggMemberInitializer", NM="_ZL24EmitAggMemberInitializerRN5clang7CodeGen15CodeGenFunctionENS0_6LValueEPNS_4ExprENS0_7AddressENS_8QualTypeEN4llvm8ArrayRefIPNS_7VarDeclEEEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZL24EmitAggMemberInitializerRN5clang7CodeGen15CodeGenFunctionENS0_6LValueEPNS_4ExprENS0_7AddressENS_8QualTypeEN4llvm8ArrayRefIPNS_7VarDeclEEEj")
//</editor-fold>
public static void EmitAggMemberInitializer(final CodeGenFunction /*&*/ CGF, 
                        LValue LHS, 
                        Expr /*P*/ Init, 
                        Address ArrayIndexVar, 
                        QualType T, 
                        ArrayRef<VarDecl /*P*/ > ArrayIndexes, 
                        /*uint*/int Index) {
  if (Index == ArrayIndexes.size()) {
    LValue LV = new LValue(LHS);
    if (ArrayIndexVar.isValid()) {
      // If we have an array index variable, load it and use it as an offset.
      // Then, increment the value.
      Value /*P*/ Dest = LHS.getPointer();
      Value /*P*/ ArrayIndex = CGF.Builder.CreateLoad(new Address(ArrayIndexVar));
      Dest = CGF.Builder.CreateInBoundsGEP(Dest, new ArrayRef<Value /*P*/ >(ArrayIndex, true), new Twine(/*KEEP_STR*/"destaddress"));
      Value /*P*/ Next = ConstantInt.get(ArrayIndex.getType(), $int2ulong(1));
      Next = CGF.Builder.CreateAdd(ArrayIndex, Next, new Twine(/*KEEP_STR*/"inc"));
      CGF.Builder.CreateStore(Next, new Address(ArrayIndexVar));
      
      // Update the LValue.
      CharUnits EltSize = CGF.getContext().getTypeSizeInChars(/*NO_COPY*/T);
      CharUnits Align = LV.getAlignment().alignmentOfArrayElement(new CharUnits(EltSize));
      LV.setAddress(new Address(Dest, new CharUnits(Align)));
    }
    switch (CGF.getEvaluationKind(new QualType(T))) {
     case TEK_Scalar:
      CGF.EmitScalarInit(Init, /*decl*/ (/*const*/ ValueDecl /*P*/ )null, new LValue(LV), false);
      break;
     case TEK_Complex:
      CGF.EmitComplexExprIntoLValue(Init, new LValue(LV), /*isInit*/ true);
      break;
     case TEK_Aggregate:
      {
        AggValueSlot Slot = AggValueSlot.forLValue(LV, 
            AggValueSlot.IsDestructed_t.IsDestructed, 
            AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers, 
            AggValueSlot.IsAliased_t.IsNotAliased);
        
        CGF.EmitAggExpr(Init, new AggValueSlot(Slot));
        break;
      }
    }
    
    return;
  }
  
  /*const*/ ConstantArrayType /*P*/ Array = CGF.getContext().getAsConstantArrayType(new QualType(T));
  assert ((Array != null)) : "Array initialization without the array type?";
  Address IndexVar = CGF.GetAddrOfLocalVar(ArrayIndexes.$at(Index));
  
  // Initialize this index variable to zero.
  Value /*P*/ Zero = Constant.getNullValue(IndexVar.getElementType());
  CGF.Builder.CreateStore(Zero, new Address(IndexVar));
  
  // Start the loop with a block that tests the condition.
  BasicBlock /*P*/ CondBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"for.cond"));
  BasicBlock /*P*/ AfterFor = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"for.end"));
  
  CGF.EmitBlock(CondBlock);
  
  BasicBlock /*P*/ ForBody = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"for.body"));
  // Generate: if (loop-index < number-of-elements) fall to the loop body,
  // otherwise, go to the block after the for-loop.
  long/*uint64_t*/ NumElements = Array.getSize().getZExtValue();
  Value /*P*/ Counter = CGF.Builder.CreateLoad(new Address(IndexVar));
  Value /*P*/ NumElementsPtr = ConstantInt.get(Counter.getType(), NumElements);
  Value /*P*/ IsLess = CGF.Builder.CreateICmpULT(Counter, NumElementsPtr, 
      new Twine(/*KEEP_STR*/"isless"));
  
  // If the condition is true, execute the body.
  CGF.Builder.CreateCondBr(IsLess, ForBody, AfterFor);
  
  CGF.EmitBlock(ForBody);
  BasicBlock /*P*/ ContinueBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"for.inc"));
  
  // Inside the loop body recurse to emit the inner loop or, eventually, the
  // constructor call.
  EmitAggMemberInitializer(CGF, new LValue(LHS), Init, new Address(ArrayIndexVar), 
      Array.getElementType(), new ArrayRef<VarDecl /*P*/ >(ArrayIndexes), Index + 1);
  
  CGF.EmitBlock(ContinueBlock);
  
  // Emit the increment of the loop counter.
  Value /*P*/ NextVal = ConstantInt.get(Counter.getType(), $int2ulong(1));
  Counter = CGF.Builder.CreateLoad(new Address(IndexVar));
  NextVal = CGF.Builder.CreateAdd(Counter, NextVal, new Twine(/*KEEP_STR*/"inc"));
  CGF.Builder.CreateStore(NextVal, new Address(IndexVar));
  
  // Finally, branch back up to the condition for the next iteration.
  CGF.EmitBranch(CondBlock);
  
  // Emit the fall-through block.
  CGF.EmitBlock(AfterFor, true);
}

//<editor-fold defaultstate="collapsed" desc="isMemcpyEquivalentSpecialMember">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 664,
 FQN="isMemcpyEquivalentSpecialMember", NM="_ZL31isMemcpyEquivalentSpecialMemberPKN5clang13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZL31isMemcpyEquivalentSpecialMemberPKN5clang13CXXMethodDeclE")
//</editor-fold>
public static boolean isMemcpyEquivalentSpecialMember(/*const*/ CXXMethodDecl /*P*/ D) {
  /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(D);
  if (!((CD != null) && CD.isCopyOrMoveConstructor())
     && !D.isCopyAssignmentOperator() && !D.isMoveAssignmentOperator()) {
    return false;
  }
  
  // We can emit a memcpy for a trivial copy or move constructor/assignment.
  if (D.isTrivial() && !D.getParent$Const().mayInsertExtraPadding()) {
    return true;
  }
  
  // We *must* emit a memcpy for a defaulted union copy or move op.
  if (D.getParent$Const().isUnion() && D.isDefaulted()) {
    return true;
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="EmitLValueForAnyFieldInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 681,
 FQN="EmitLValueForAnyFieldInitialization", NM="_ZL35EmitLValueForAnyFieldInitializationRN5clang7CodeGen15CodeGenFunctionEPNS_18CXXCtorInitializerERNS0_6LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZL35EmitLValueForAnyFieldInitializationRN5clang7CodeGen15CodeGenFunctionEPNS_18CXXCtorInitializerERNS0_6LValueE")
//</editor-fold>
public static void EmitLValueForAnyFieldInitialization(final CodeGenFunction /*&*/ CGF, 
                                   CXXCtorInitializer /*P*/ MemberInit, 
                                   final LValue /*&*/ LHS) {
  FieldDecl /*P*/ Field = MemberInit.getAnyMember();
  if (MemberInit.isIndirectMemberInitializer()) {
    // If we are initializing an anonymous union field, drill down to the field.
    IndirectFieldDecl /*P*/ IndirectField = MemberInit.getIndirectMember();
    for (/*const*/ NamedDecl /*P*/ I : IndirectField.chain())  {
      LHS.$assignMove(CGF.EmitLValueForFieldInitialization(new LValue(LHS), cast_FieldDecl(I)));
    }
  } else {
    LHS.$assignMove(CGF.EmitLValueForFieldInitialization(new LValue(LHS), Field));
  }
}

//<editor-fold defaultstate="collapsed" desc="EmitMemberInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 695,
 FQN="EmitMemberInitializer", NM="_ZL21EmitMemberInitializerRN5clang7CodeGen15CodeGenFunctionEPKNS_13CXXRecordDeclEPNS_18CXXCtorInitializerEPKNS_18CXXConstructorDeclERNS0_15FunctionArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZL21EmitMemberInitializerRN5clang7CodeGen15CodeGenFunctionEPKNS_13CXXRecordDeclEPNS_18CXXCtorInitializerEPKNS_18CXXConstructorDeclERNS0_15FunctionArgListE")
//</editor-fold>
public static void EmitMemberInitializer(final CodeGenFunction /*&*/ CGF, 
                     /*const*/ CXXRecordDecl /*P*/ ClassDecl, 
                     CXXCtorInitializer /*P*/ MemberInit, 
                     /*const*/ CXXConstructorDecl /*P*/ Constructor, 
                     final FunctionArgList /*&*/ Args) {
  ApplyDebugLocation Loc = null;
  try {
    Loc/*J*/= new ApplyDebugLocation(CGF, MemberInit.getSourceLocation());
    assert (MemberInit.isAnyMemberInitializer()) : "Must have member initializer!";
    assert ((MemberInit.getInit() != null)) : "Must have initializer!";
    
    // non-static data member initializers.
    FieldDecl /*P*/ Field = MemberInit.getAnyMember();
    QualType FieldType = Field.getType();
    
    Value /*P*/ ThisPtr = CGF.LoadCXXThis();
    QualType RecordTy = CGF.getContext().getTypeDeclType(ClassDecl);
    LValue LHS = CGF.MakeNaturalAlignAddrLValue(ThisPtr, new QualType(RecordTy));
    
    EmitLValueForAnyFieldInitialization(CGF, MemberInit, LHS);
    
    // Special case: if we are in a copy or move constructor, and we are copying
    // an array of PODs or classes with trivial copy constructors, ignore the
    // AST and perform the copy we know is equivalent.
    // FIXME: This is hacky at best... if we had a bit more explicit information
    // in the AST, we could generalize it more easily.
    /*const*/ ConstantArrayType /*P*/ Array = CGF.getContext().getAsConstantArrayType(new QualType(FieldType));
    if ((Array != null) && Constructor.isDefaulted()
       && Constructor.isCopyOrMoveConstructor()) {
      QualType BaseElementTy = CGF.getContext().getBaseElementType(Array);
      CXXConstructExpr /*P*/ CE = dyn_cast_CXXConstructExpr(MemberInit.getInit());
      if (BaseElementTy.isPODType(CGF.getContext())
         || ((CE != null) && isMemcpyEquivalentSpecialMember(CE.getConstructor()))) {
        /*uint*/int SrcArgIndex = CGF.CGM.getCXXABI().getSrcArgforCopyCtor(Constructor, Args);
        Value /*P*/ SrcPtr = CGF.Builder.CreateLoad(CGF.GetAddrOfLocalVar(Args.$at(SrcArgIndex)));
        LValue ThisRHSLV = CGF.MakeNaturalAlignAddrLValue(SrcPtr, new QualType(RecordTy));
        LValue Src = CGF.EmitLValueForFieldInitialization(new LValue(ThisRHSLV), Field);
        
        // Copy the aggregate.
        CGF.EmitAggregateCopy(LHS.getAddress(), Src.getAddress(), new QualType(FieldType), 
            LHS.isVolatileQualified());
        // Ensure that we destroy the objects if an exception is thrown later in
        // the constructor.
        QualType.DestructionKind dtorKind = FieldType.isDestructedType();
        if (CGF.needsEHCleanup(dtorKind)) {
          CGF.pushEHDestroy(dtorKind, LHS.getAddress(), new QualType(FieldType));
        }
        return;
      }
    }
    
    ArrayRef<VarDecl /*P*/ > ArrayIndexes/*J*/= new ArrayRef<VarDecl /*P*/ >(true);
    if ((MemberInit.getNumArrayIndices() != 0)) {
      ArrayIndexes.$assignMove(MemberInit.getArrayIndices());
    }
    CGF.EmitInitializerForField(Field, new LValue(LHS), MemberInit.getInit(), new ArrayRef<VarDecl /*P*/ >(ArrayIndexes));
  } finally {
    if (Loc != null) { Loc.$destroy(); }
  }
}


/// Checks whether the given constructor is a valid subject for the
/// complete-to-base constructor delegation optimization, i.e.
/// emitting the complete constructor as a simple call to the base
/// constructor.
//<editor-fold defaultstate="collapsed" desc="IsConstructorDelegationValid">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 807,
 FQN="IsConstructorDelegationValid", NM="_ZL28IsConstructorDelegationValidPKN5clang18CXXConstructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZL28IsConstructorDelegationValidPKN5clang18CXXConstructorDeclE")
//</editor-fold>
public static boolean IsConstructorDelegationValid(/*const*/ CXXConstructorDecl /*P*/ Ctor) {
  
  // Currently we disable the optimization for classes with virtual
  // bases because (1) the addresses of parameter variables need to be
  // consistent across all initializers but (2) the delegate function
  // call necessarily creates a second copy of the parameter variable.
  //
  // The limiting example (purely theoretical AFAIK):
  //   struct A { A(int &c) { c++; } };
  //   struct B : virtual A {
  //     B(int count) : A(count) { printf("%d\n", count); }
  //   };
  // ...although even this example could in principle be emitted as a
  // delegation since the address of the parameter doesn't escape.
  if ((Ctor.getParent$Const().getNumVBases() != 0)) {
    // TODO: white-list trivial vbase initializers.  This case wouldn't
    // be subject to the restrictions below.
    
    // TODO: white-list cases where:
    //  - there are no non-reference parameters to the constructor
    //  - the initializers don't access any non-reference parameters
    //  - the initializers don't take the address of non-reference
    //    parameters
    //  - etc.
    // If we ever add any of the above cases, remember that:
    //  - function-try-blocks will always blacklist this optimization
    //  - we need to perform the constructor prologue and cleanup in
    //    EmitConstructorBody.
    return false;
  }
  
  // We also disable the optimization for variadic functions because
  // it's impossible to "re-pass" varargs.
  if (Ctor.getType().$arrow().getAs(FunctionProtoType.class).isVariadic()) {
    return false;
  }
  
  // FIXME: Decide if we can do a delegation of a delegating constructor.
  if (Ctor.isDelegatingConstructor()) {
    return false;
  }
  
  return true;
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="isInitializerOfDynamicClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1343,
 FQN="isInitializerOfDynamicClass", NM="_ZL27isInitializerOfDynamicClassPKN5clang18CXXCtorInitializerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZL27isInitializerOfDynamicClassPKN5clang18CXXCtorInitializerE")
//</editor-fold>
public static boolean isInitializerOfDynamicClass(/*const*/ CXXCtorInitializer /*P*/ BaseInit) {
  /*const*/ org.clang.ast.Type /*P*/ BaseType = BaseInit.getBaseClass();
  /*const*/ CXXRecordDecl /*P*/ BaseClassDecl = cast_CXXRecordDecl(BaseType.getAs$RecordType().getDecl());
  return BaseClassDecl.isDynamicClass();
}

//<editor-fold defaultstate="collapsed" desc="FieldHasTrivialDestructorBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1463,
 FQN="FieldHasTrivialDestructorBody", NM="_ZL29FieldHasTrivialDestructorBodyRN5clang10ASTContextEPKNS_9FieldDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZL29FieldHasTrivialDestructorBodyRN5clang10ASTContextEPKNS_9FieldDeclE")
//</editor-fold>
public static boolean FieldHasTrivialDestructorBody(final ASTContext /*&*/ Context, 
                             /*const*/ FieldDecl /*P*/ Field) {
  QualType FieldBaseElementType = Context.getBaseElementType(Field.getType());
  
  /*const*/ RecordType /*P*/ RT = FieldBaseElementType.$arrow().getAs$RecordType();
  if (!(RT != null)) {
    return true;
  }
  
  CXXRecordDecl /*P*/ FieldClassDecl = cast_CXXRecordDecl(RT.getDecl());
  
  // The destructor for an implicit anonymous union member is never invoked.
  if (FieldClassDecl.isUnion() && FieldClassDecl.isAnonymousStructOrUnion()) {
    return false;
  }
  
  return HasTrivialDestructorBody(Context, FieldClassDecl, FieldClassDecl);
}

//<editor-fold defaultstate="collapsed" desc="HasTrivialDestructorBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1420,
 FQN="HasTrivialDestructorBody", NM="_ZL24HasTrivialDestructorBodyRN5clang10ASTContextEPKNS_13CXXRecordDeclES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZL24HasTrivialDestructorBodyRN5clang10ASTContextEPKNS_13CXXRecordDeclES4_")
//</editor-fold>
public static boolean HasTrivialDestructorBody(final ASTContext /*&*/ Context, 
                        /*const*/ CXXRecordDecl /*P*/ BaseClassDecl, 
                        /*const*/ CXXRecordDecl /*P*/ MostDerivedClassDecl) {
  // If the destructor is trivial we don't have to check anything else.
  if (BaseClassDecl.hasTrivialDestructor()) {
    return true;
  }
  if (!BaseClassDecl.getDestructor().hasTrivialBody()) {
    return false;
  }
  
  // Check fields.
  for (/*const*/ FieldDecl /*P*/ Field : BaseClassDecl.fields())  {
    if (!FieldHasTrivialDestructorBody(Context, Field)) {
      return false;
    }
  }
  
  // Check non-virtual bases.
  for (final /*const*/ CXXBaseSpecifier /*&*/ I : BaseClassDecl.bases$Const()) {
    if (I.isVirtual()) {
      continue;
    }
    
    /*const*/ CXXRecordDecl /*P*/ NonVirtualBase = cast_CXXRecordDecl(I.getType().$arrow().castAs$RecordType().getDecl());
    if (!HasTrivialDestructorBody(Context, NonVirtualBase, 
        MostDerivedClassDecl)) {
      return false;
    }
  }
  if (BaseClassDecl == MostDerivedClassDecl) {
    // Check virtual bases.
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : BaseClassDecl.vbases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ VirtualBase = cast_CXXRecordDecl(I.getType().$arrow().castAs$RecordType().getDecl());
      if (!HasTrivialDestructorBody(Context, VirtualBase, 
          MostDerivedClassDecl)) {
        return false;
      }
    }
  }
  
  return true;
}


/// CanSkipVTablePointerInitialization - Check whether we need to initialize
/// any vtable pointers before calling this destructor.
//<editor-fold defaultstate="collapsed" desc="CanSkipVTablePointerInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1484,
 FQN="CanSkipVTablePointerInitialization", NM="_ZL34CanSkipVTablePointerInitializationRN5clang7CodeGen15CodeGenFunctionEPKNS_17CXXDestructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZL34CanSkipVTablePointerInitializationRN5clang7CodeGen15CodeGenFunctionEPKNS_17CXXDestructorDeclE")
//</editor-fold>
public static boolean CanSkipVTablePointerInitialization(final CodeGenFunction /*&*/ CGF, 
                                  /*const*/ CXXDestructorDecl /*P*/ Dtor) {
  /*const*/ CXXRecordDecl /*P*/ ClassDecl = Dtor.getParent$Const();
  if (!ClassDecl.isDynamicClass()) {
    return true;
  }
  if (!Dtor.hasTrivialBody()) {
    return false;
  }
  
  // Check the fields.
  for (/*const*/ FieldDecl /*P*/ Field : ClassDecl.fields())  {
    if (!FieldHasTrivialDestructorBody(CGF.getContext(), Field)) {
      return false;
    }
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmitSanitizerDtorCallback">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1677,
 FQN="(anonymous namespace)::EmitSanitizerDtorCallback", NM="_ZN12_GLOBAL__N_1L25EmitSanitizerDtorCallbackERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_1L25EmitSanitizerDtorCallbackERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueEx")
//</editor-fold>
public static void EmitSanitizerDtorCallback(final CodeGenFunction /*&*/ CGF, Value /*P*/ Ptr, 
                         long/*int64_t*/ PoisonSize) {
  // Pass in void pointer and size of region as arguments to runtime
  // function
  Value /*P*/ Args[/*2*/] = new Value /*P*/  [/*2*/] {
    CGF.Builder.CreateBitCast(Ptr, CGF.Unnamed_field9.VoidPtrTy), 
    ConstantInt.get(CGF.Unnamed_field8.SizeTy, PoisonSize)};
  
  org.llvm.ir.Type /*P*/ ArgTypes[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {CGF.Unnamed_field9.VoidPtrTy, CGF.Unnamed_field8.SizeTy};
  
  org.llvm.ir.FunctionType /*P*/ FnType = org.llvm.ir.FunctionType.get(CGF.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTypes, true), false);
  Value /*P*/ Fn = CGF.CGM.CreateRuntimeFunction(FnType, new StringRef(/*KEEP_STR*/"__sanitizer_dtor_callback"));
  CGF.EmitNounwindRuntimeCall(Fn, new ArrayRef<Value /*P*/ >(Args, true));
}

//<editor-fold defaultstate="collapsed" desc="canEmitDelegateCallArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2077,
 FQN="canEmitDelegateCallArgs", NM="_ZL23canEmitDelegateCallArgsRN5clang7CodeGen15CodeGenFunctionEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeERNS0_11CallArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZL23canEmitDelegateCallArgsRN5clang7CodeGen15CodeGenFunctionEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeERNS0_11CallArgListE")
//</editor-fold>
public static boolean canEmitDelegateCallArgs(final CodeGenFunction /*&*/ CGF, 
                       /*const*/ CXXConstructorDecl /*P*/ Ctor, 
                       CXXCtorType Type, final CallArgList /*&*/ Args) {
  // We can't forward a variadic call.
  if (Ctor.isVariadic()) {
    return false;
  }
  if (CGF.getTarget().getCXXABI().areArgsDestroyedLeftToRightInCallee()) {
    // If the parameters are callee-cleanup, it's not safe to forward.
    for (ParmVarDecl /*P*/ P : Ctor.parameters$Const())  {
      if ((P.getType().isDestructedType().getValue() != 0)) {
        return false;
      }
    }
    
    // Likewise if they're inalloca.
    final /*const*/ CGFunctionInfo /*&*/ Info = CGF.CGM.getTypes().arrangeCXXConstructorCall(Args, Ctor, Type, 0);
    if (Info.usesInAlloca()) {
      return false;
    }
  }
  
  // Anything else should be OK.
  return true;
}


// If a class has a single non-virtual base and does not introduce or override
// virtual member functions or fields, it will have the same layout as its base.
// This function returns the least derived such class.
//
// Casting an instance of a base class to such a derived class is technically
// undefined behavior, but it is a relatively common hack for introducing member
// functions on class instances with specific properties (e.g. llvm::Operator)
// that works under most compilers and should not have security implications, so
// we allow it by default. It can be disabled with -fsanitize=cfi-cast-strict.
//<editor-fold defaultstate="collapsed" desc="LeastDerivedClassWithSameLayout">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2586,
 FQN="LeastDerivedClassWithSameLayout", NM="_ZL31LeastDerivedClassWithSameLayoutPKN5clang13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZL31LeastDerivedClassWithSameLayoutPKN5clang13CXXRecordDeclE")
//</editor-fold>
public static /*const*/ CXXRecordDecl /*P*/ LeastDerivedClassWithSameLayout(/*const*/ CXXRecordDecl /*P*/ RD) {
  if (!RD.field_empty()) {
    return RD;
  }
  if (RD.getNumVBases() != 0) {
    return RD;
  }
  if (RD.getNumBases() != 1) {
    return RD;
  }
  
  for (/*const*/ CXXMethodDecl /*P*/ MD : RD.methods()) {
    if (MD.isVirtual()) {
      // Virtual member functions are only ok if they are implicit destructors
      // because the implicit destructor will have the same semantics as the
      // base class's destructor if no fields are added.
      if (isa_CXXDestructorDecl(MD) && MD.isImplicit()) {
        continue;
      }
      return RD;
    }
  }
  
  return LeastDerivedClassWithSameLayout(RD.bases_begin$Const().$arrow().getType().$arrow().getAsCXXRecordDecl());
}


// FIXME: Ideally Expr::IgnoreParenNoopCasts should do this, but it doesn't do
// quite what we want.
//<editor-fold defaultstate="collapsed" desc="skipNoOpCastsAndParens">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 2810,
 FQN="skipNoOpCastsAndParens", NM="_ZL22skipNoOpCastsAndParensPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZL22skipNoOpCastsAndParensPKN5clang4ExprE")
//</editor-fold>
public static /*const*/ Expr /*P*/ skipNoOpCastsAndParens(/*const*/ Expr /*P*/ E) {
  while (true) {
    {
      /*const*/ ParenExpr /*P*/ PE = dyn_cast_ParenExpr(E);
      if ((PE != null)) {
        E = PE.getSubExpr$Const();
        continue;
      }
    }
    {
      
      /*const*/ CastExpr /*P*/ CE = dyn_cast_CastExpr(E);
      if ((CE != null)) {
        if (CE.getCastKind() == CastKind.CK_NoOp) {
          E = CE.getSubExpr$Const();
          continue;
        }
      }
    }
    {
      /*const*/ UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(E);
      if ((UO != null)) {
        if (UO.getOpcode() == UnaryOperatorKind.UO_Extension) {
          E = UO.getSubExpr();
          continue;
        }
      }
    }
    return E;
  }
}

} // END OF class CGClassStatics
