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
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.*;
import org.llvm.ir.FunctionType;
import org.llvm.ir.Type;
import static org.clang.ast.CharUnitsGlobals.*;
import org.clang.ast.DeclContext.specific_decl_iterator;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.codegen.impl.CGExprCXXStatics.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGExprCXX">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGExprCXX",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGExprAgg ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitCXXNewExprEPKNS_10CXXNewExprE;_ZN5clang7CodeGen15CodeGenFunction14EmitDeleteCallEPKNS_12FunctionDeclEPN4llvm5ValueENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction14EmitLambdaExprEPKNS_10LambdaExprENS0_12AggValueSlotE;_ZN5clang7CodeGen15CodeGenFunction15EmitDynamicCastENS0_7AddressEPKNS_18CXXDynamicCastExprE;_ZN5clang7CodeGen15CodeGenFunction17EmitCXXDeleteExprEPKNS_13CXXDeleteExprE;_ZN5clang7CodeGen15CodeGenFunction17EmitCXXTypeidExprEPKNS_13CXXTypeidExprE;_ZN5clang7CodeGen15CodeGenFunction20EmitCXXConstructExprEPKNS_16CXXConstructExprENS0_12AggValueSlotE;_ZN5clang7CodeGen15CodeGenFunction21EmitCXXDestructorCallEPKNS_17CXXDestructorDeclEPN4llvm5ValueES7_S7_NS_8QualTypeEPKNS_8CallExprENS0_12StructorTypeE;_ZN5clang7CodeGen15CodeGenFunction21EmitCXXMemberCallExprEPKNS_17CXXMemberCallExprENS0_15ReturnValueSlotE;_ZN5clang7CodeGen15CodeGenFunction22EmitCUDAKernelCallExprEPKNS_18CUDAKernelCallExprENS0_15ReturnValueSlotE;_ZN5clang7CodeGen15CodeGenFunction23EmitNewArrayInitializerEPKNS_10CXXNewExprENS_8QualTypeEPN4llvm4TypeENS0_7AddressEPNS6_5ValueESB_;_ZN5clang7CodeGen15CodeGenFunction24EmitBuiltinNewDeleteCallEPKNS_17FunctionProtoTypeEPKNS_4ExprEb;_ZN5clang7CodeGen15CodeGenFunction26EmitSynthesizedCXXCopyCtorENS0_7AddressES2_PKNS_4ExprE;_ZN5clang7CodeGen15CodeGenFunction27EmitCXXMemberOrOperatorCallEPKNS_13CXXMethodDeclEPN4llvm5ValueENS0_15ReturnValueSlotES7_S7_NS_8QualTypeEPKNS_8CallExprE;_ZN5clang7CodeGen15CodeGenFunction27pushCallObjectDeleteCleanupEPKNS_12FunctionDeclEPN4llvm5ValueENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction28EmitCXXMemberPointerCallExprEPKNS_17CXXMemberCallExprENS0_15ReturnValueSlotE;_ZN5clang7CodeGen15CodeGenFunction29EmitCXXOperatorMemberCallExprEPKNS_19CXXOperatorCallExprEPKNS_13CXXMethodDeclENS0_15ReturnValueSlotE;_ZN5clang7CodeGen15CodeGenFunction37EmitCXXMemberOrOperatorMemberCallExprEPKNS_8CallExprEPKNS_13CXXMethodDeclENS0_15ReturnValueSlotEbPNS_19NestedNameSpecifierEbPKNS_4ExprE; -static-type=CodeGenFunction_CGExprCXX -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGExprCXX extends CodeGenFunction_CGExprAgg {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGExprCXX(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::pushCallObjectDeleteCleanup">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1536,
 FQN="clang::CodeGen::CodeGenFunction::pushCallObjectDeleteCleanup", NM="_ZN5clang7CodeGen15CodeGenFunction27pushCallObjectDeleteCleanupEPKNS_12FunctionDeclEPN4llvm5ValueENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction27pushCallObjectDeleteCleanupEPKNS_12FunctionDeclEPN4llvm5ValueENS_8QualTypeE")
//</editor-fold>
public final void pushCallObjectDeleteCleanup(/*const*/ FunctionDecl /*P*/ OperatorDelete, 
                           Value /*P*/ CompletePtr, 
                           QualType ElementType) {
  $this().EHStack.<CallObjectDelete>pushCleanup$T(CleanupKind.NormalAndEHCleanup, () -> new CallObjectDelete(CompletePtr, 
      OperatorDelete, new QualType(ElementType)));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitNewArrayInitializer">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 831,
 FQN="clang::CodeGen::CodeGenFunction::EmitNewArrayInitializer", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitNewArrayInitializerEPKNS_10CXXNewExprENS_8QualTypeEPN4llvm4TypeENS0_7AddressEPNS6_5ValueESB_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitNewArrayInitializerEPKNS_10CXXNewExprENS_8QualTypeEPN4llvm4TypeENS0_7AddressEPNS6_5ValueESB_")
//</editor-fold>
public final void EmitNewArrayInitializer(/*const*/ CXXNewExpr /*P*/ E, QualType ElementType, org.llvm.ir.Type /*P*/ ElementTy, 
                       Address BeginPtr, Value /*P*/ NumElements, 
                       Value /*P*/ AllocSizeWithoutCookie) {
  // If we have a type with trivial initialization and no initializer,
  // there's nothing to do.
  if (!E.hasInitializer()) {
    return;
  }
  
  Address CurPtr = new Address(BeginPtr);
  
  /*uint*/int InitListElements = 0;
  
  /*const*/ Expr /*P*/ Init = E.getInitializer$Const();
  Address EndOfInit = Address.invalid();
  QualType.DestructionKind DtorKind = ElementType.isDestructedType();
  EHScopeStack.stable_iterator Cleanup/*J*/= new EHScopeStack.stable_iterator();
  Instruction /*P*/ CleanupDominator = null;
  
  CharUnits ElementSize = $this().getContext().getTypeSizeInChars(/*NO_COPY*/ElementType);
  CharUnits ElementAlign = BeginPtr.getAlignment().alignmentOfArrayElement(new CharUnits(ElementSize));
  {
    
    // If the initializer is an initializer list, first do the explicit elements.
    /*const*/ InitListExpr /*P*/ ILE = dyn_cast_InitListExpr(Init);
    if ((ILE != null)) {
      InitListElements = ILE.getNumInits();
      
      // If this is a multi-dimensional array new, we will initialize multiple
      // elements with each init list element.
      QualType AllocType = E.getAllocatedType();
      {
        /*const*/ ConstantArrayType /*P*/ CAT = dyn_cast_or_null_ConstantArrayType(AllocType.$arrow().getAsArrayTypeUnsafe());
        if ((CAT != null)) {
          ElementTy = $this().ConvertTypeForMem(new QualType(AllocType));
          CurPtr.$assignMove($this().Builder.CreateElementBitCast(new Address(CurPtr), ElementTy));
          InitListElements *= $this().getContext().getConstantArrayElementCount(CAT);
        }
      }
      
      // Enter a partial-destruction Cleanup if necessary.
      if ($this().needsEHCleanup(DtorKind)) {
        // In principle we could tell the Cleanup where we are more
        // directly, but the control flow can get so varied here that it
        // would actually be quite complex.  Therefore we go through an
        // alloca.
        EndOfInit.$assignMove($this().CreateTempAlloca(BeginPtr.getType(), /*J:ToBase*/super.getPointerAlign(), 
                new Twine(/*KEEP_STR*/"array.init.end")));
        CleanupDominator = $this().Builder.CreateStore(BeginPtr.getPointer(), new Address(EndOfInit));
        $this().pushIrregularPartialArrayCleanup(BeginPtr.getPointer(), new Address(EndOfInit), 
            new QualType(ElementType), new CharUnits(ElementAlign), 
            $this().getDestroyer(DtorKind));
        Cleanup.$assignMove($this().EHStack.stable_begin());
      }
      
      CharUnits StartAlign = CurPtr.getAlignment();
      for (/*uint*/int i = 0, e = ILE.getNumInits(); i != e; ++i) {
        // Tell the cleanup that it needs to destroy up to this
        // element.  TODO: some of these stores can be trivially
        // observed to be unnecessary.
        if (EndOfInit.isValid()) {
          Value /*P*/ FinishedPtr = $this().Builder.CreateBitCast(CurPtr.getPointer(), BeginPtr.getType());
          $this().Builder.CreateStore(FinishedPtr, new Address(EndOfInit));
        }
        // FIXME: If the last initializer is an incomplete initializer list for
        // an array, and we have an array filler, we can fold together the two
        // initialization loops.
        CGExprCXXStatics.StoreAnyExprIntoOneUnit(/*Deref*/$this(), ILE.getInit$Const(i), 
            ILE.getInit$Const(i).getType(), new Address(CurPtr));
        CurPtr.$assignMove(new Address($this().Builder.CreateInBoundsGEP(CurPtr.getPointer(), 
                    new ArrayRef<Value /*P*/ >($this().Builder.getSize($int2ulong(1)), true), 
                    new Twine(/*KEEP_STR*/"array.exp.next")), 
                StartAlign.alignmentAtOffset($star_long_CharUnits$C($uint2long((i + 1)), ElementSize))));
      }
      
      // The remaining elements are filled with the array filler expression.
      Init = ILE.getArrayFiller$Const();
      
      // Extract the initializer for the individual array elements by pulling
      // out the array filler from all the nested initializer lists. This avoids
      // generating a nested loop for the initialization.
      while ((Init != null) && Init.getType().$arrow().isConstantArrayType()) {
        /*const*/ InitListExpr /*P*/ SubILE = dyn_cast_InitListExpr(Init);
        if (!(SubILE != null)) {
          break;
        }
        assert (SubILE.getNumInits() == 0) : "explicit inits in array filler?";
        Init = SubILE.getArrayFiller$Const();
      }
      
      // Switch back to initializing one base element at a time.
      CurPtr.$assignMove($this().Builder.CreateBitCast(new Address(CurPtr), BeginPtr.getType()));
    }
  }
  
  int InitListElements_final = InitListElements;
  // Attempt to perform zero-initialization using memset.
  VoidBoolPredicate TryMemsetInitialization = /*[&, this, &ElementType, &AllocSizeWithoutCookie, &InitListElements, &CurPtr]*/ () -> {
        // FIXME: If the type is a pointer-to-data-member under the Itanium ABI,
        // we can initialize with a memset to -1.
        if (!$this().CGM.getTypes().isZeroInitializable(new QualType(ElementType))) {
          return false;
        }
        
        // Optimization: since zero initialization will just set the memory
        // to all zeroes, generate a single memset to do it in one shot.
        
        // Subtract out the size of any elements we've already initialized.
        Value /*P*/ RemainingSize = AllocSizeWithoutCookie;
        if ((InitListElements_final != 0)) {
          // We know this can't overflow; we check this when doing the allocation.
          Constant /*P*/ InitializedSize = ConstantInt.get(RemainingSize.getType(), 
              $this().getContext().getTypeSizeInChars(/*NO_COPY*/ElementType).getQuantity()
                 * $uint2llong(InitListElements_final));
          RemainingSize = $this().Builder.CreateSub(RemainingSize, InitializedSize);
        }
        
        // Create the memset.
        $this().Builder.CreateMemSet(new Address(CurPtr), $this().Builder.getInt8($int2uchar(0)), RemainingSize, false);
        return true;
      };
  
  // If all elements have already been initialized, skip any further
  // initialization.
  ConstantInt /*P*/ ConstNum = dyn_cast_ConstantInt(NumElements);
  if ((ConstNum != null) && $lesseq_ulong_uint(ConstNum.getZExtValue(), InitListElements)) {
    // If there was a Cleanup, deactivate it.
    if ((CleanupDominator != null)) {
      $this().DeactivateCleanupBlock(new EHScopeStack.stable_iterator(Cleanup), CleanupDominator);
    }
    return;
  }
  assert ((Init != null)) : "have trailing elements to initialize but no initializer";
  {
    
    // If this is a constructor call, try to optimize it out, and failing that
    // emit a single loop to initialize all remaining elements.
    /*const*/ CXXConstructExpr /*P*/ CCE = dyn_cast_CXXConstructExpr(Init);
    if ((CCE != null)) {
      CXXConstructorDecl /*P*/ Ctor = CCE.getConstructor();
      if (Ctor.isTrivial()) {
        // If new expression did not specify value-initialization, then there
        // is no initialization.
        if (!CCE.requiresZeroInitialization() || Ctor.getParent().isEmpty()) {
          return;
        }
        if (TryMemsetInitialization.$call()) {
          return;
        }
      }
      
      // Store the new Cleanup position for irregular Cleanups.
      //
      // FIXME: Share this cleanup with the constructor call emission rather than
      // having it create a cleanup of its own.
      if (EndOfInit.isValid()) {
        $this().Builder.CreateStore(CurPtr.getPointer(), new Address(EndOfInit));
      }
      
      // Emit a constructor call loop to initialize the remaining elements.
      if ((InitListElements != 0)) {
        NumElements = $this().Builder.CreateSub(NumElements, 
            ConstantInt.get(NumElements.getType(), $uint2ulong(InitListElements)));
      }
      $this().EmitCXXAggrConstructorCall(Ctor, NumElements, new Address(CurPtr), CCE, 
          CCE.requiresZeroInitialization());
      return;
    }
  }
  
  // If this is value-initialization, we can usually use memset.
  ImplicitValueInitExpr IVIE/*J*/= new ImplicitValueInitExpr(new QualType(ElementType));
  if (isa_ImplicitValueInitExpr(Init)) {
    if (TryMemsetInitialization.$call()) {
      return;
    }
    
    // Switch to an ImplicitValueInitExpr for the element type. This handles
    // only one case: multidimensional array new of pointers to members. In
    // all other cases, we already have an initializer for the array element.
    Init = $AddrOf(IVIE);
  }
  
  // At this point we should have found an initializer for the individual
  // elements of the array.
  assert ($this().getContext().hasSameUnqualifiedType(new QualType(ElementType), Init.getType())) : "got wrong type of element to initialize";
  {
    
    // If we have an empty initializer list, we can usually use memset.
    /*const*/ InitListExpr /*P*/ ILE = dyn_cast_InitListExpr(Init);
    if ((ILE != null)) {
      if (ILE.getNumInits() == 0 && TryMemsetInitialization.$call()) {
        return;
      }
    }
  }
  {
    
    // If we have a struct whose every field is value-initialized, we can
    // usually use memset.
    /*const*/ InitListExpr /*P*/ ILE = dyn_cast_InitListExpr(Init);
    if ((ILE != null)) {
      {
        /*const*/ RecordType /*P*/ RType = ILE.getType().$arrow().getAs$RecordType();
        if ((RType != null)) {
          if (RType.getDecl().isStruct()) {
            /*uint*/int NumElements$1 = 0;
            {
              CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(RType.getDecl());
              if ((CXXRD != null)) {
                NumElements$1 = CXXRD.getNumBases();
              }
            }
            for (FieldDecl /*P*/ Field : RType.getDecl().fields())  {
              if (!Field.isUnnamedBitfield()) {
                ++NumElements$1;
              }
            }
            // FIXME: Recurse into nested InitListExprs.
            if (ILE.getNumInits() == NumElements$1) {
              for (/*uint*/int i = 0, e = ILE.getNumInits(); i != e; ++i)  {
                if (!isa_ImplicitValueInitExpr(ILE.getInit$Const(i))) {
                  --NumElements$1;
                }
              }
            }
            if (ILE.getNumInits() == NumElements$1 && TryMemsetInitialization.$call()) {
              return;
            }
          }
        }
      }
    }
  }
  
  // Create the loop blocks.
  BasicBlock /*P*/ EntryBB = $this().Builder.GetInsertBlock();
  BasicBlock /*P*/ LoopBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"new.loop"));
  BasicBlock /*P*/ ContBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"new.loop.end"));
  
  // Find the end of the array, hoisted out of the loop.
  Value /*P*/ EndPtr = $this().Builder.CreateInBoundsGEP(BeginPtr.getPointer(), new ArrayRef<Value /*P*/ >(NumElements, true), new Twine(/*KEEP_STR*/"array.end"));
  
  // If the number of elements isn't constant, we have to now check if there is
  // anything left to initialize.
  if (!(ConstNum != null)) {
    Value /*P*/ IsEmpty = $this().Builder.CreateICmpEQ(CurPtr.getPointer(), EndPtr, new Twine(/*KEEP_STR*/"array.isempty"));
    $this().Builder.CreateCondBr(IsEmpty, ContBB, LoopBB);
  }
  
  // Enter the loop.
  $this().EmitBlock(LoopBB);
  
  // Set up the current-element phi.
  PHINode /*P*/ CurPtrPhi = $this().Builder.CreatePHI(CurPtr.getType(), 2, new Twine(/*KEEP_STR*/"array.cur"));
  CurPtrPhi.addIncoming(CurPtr.getPointer(), EntryBB);
  
  CurPtr.$assignMove(new Address(CurPtrPhi, new CharUnits(ElementAlign)));
  
  // Store the new Cleanup position for irregular Cleanups.
  if (EndOfInit.isValid()) {
    $this().Builder.CreateStore(CurPtr.getPointer(), new Address(EndOfInit));
  }
  
  // Enter a partial-destruction Cleanup if necessary.
  if (!(CleanupDominator != null) && $this().needsEHCleanup(DtorKind)) {
    $this().pushRegularPartialArrayCleanup(BeginPtr.getPointer(), CurPtr.getPointer(), 
        new QualType(ElementType), new CharUnits(ElementAlign), 
        $this().getDestroyer(DtorKind));
    Cleanup.$assignMove($this().EHStack.stable_begin());
    CleanupDominator = $this().Builder.CreateUnreachable();
  }
  
  // Emit the initializer into this element.
  CGExprCXXStatics.StoreAnyExprIntoOneUnit(/*Deref*/$this(), Init, Init.getType(), new Address(CurPtr));
  
  // Leave the Cleanup if we entered one.
  if ((CleanupDominator != null)) {
    $this().DeactivateCleanupBlock(new EHScopeStack.stable_iterator(Cleanup), CleanupDominator);
    CleanupDominator.eraseFromParent();
  }
  
  // Advance to the next element by adjusting the pointer type as necessary.
  Value /*P*/ NextPtr = $this().Builder.CreateConstInBoundsGEP1_32(ElementTy, CurPtr.getPointer(), 1, 
      new Twine(/*KEEP_STR*/"array.next"));
  
  // Check whether we've gotten to the end of the array and, if so,
  // exit the loop.
  Value /*P*/ IsEnd = $this().Builder.CreateICmpEQ(NextPtr, EndPtr, new Twine(/*KEEP_STR*/"array.atend"));
  $this().Builder.CreateCondBr(IsEnd, ContBB, LoopBB);
  CurPtrPhi.addIncoming(NextPtr, $this().Builder.GetInsertBlock());
  
  $this().EmitBlock(ContBB);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXNewExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1316,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXNewExpr", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitCXXNewExprEPKNS_10CXXNewExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitCXXNewExprEPKNS_10CXXNewExprE")
//</editor-fold>
public final Value /*P*/ EmitCXXNewExpr(/*const*/ CXXNewExpr /*P*/ E) {
  CallArgList allocatorArgs = null;
  try {
    // The element type being allocated.
    QualType allocType = $this().getContext().getBaseElementType(E.getAllocatedType());
    
    // 1. Build a call to the allocation function.
    FunctionDecl /*P*/ allocator = E.getOperatorNew();
    
    // If there is a brace-initializer, cannot allocate fewer elements than inits.
    /*uint*/int minElements = 0;
    if (E.isArray() && E.hasInitializer()) {
      {
        /*const*/ InitListExpr /*P*/ ILE = dyn_cast_InitListExpr(E.getInitializer$Const());
        if ((ILE != null)) {
          minElements = ILE.getNumInits();
        }
      }
    }
    
    type$ref<Value /*P*/ > numElements = create_type$null$ref(null);
    type$ref<Value /*P*/ > allocSizeWithoutCookie = create_type$null$ref(null);
    Value /*P*/ allocSize = CGExprCXXStatics.EmitCXXNewAllocSize(/*Deref*/$this(), E, minElements, numElements, 
        allocSizeWithoutCookie);
    
    // Emit the allocation call.  If the allocator is a global placement
    // operator, just "inline" it directly.
    Address allocation = Address.invalid();
    allocatorArgs/*J*/= new CallArgList();
    if (allocator.isReservedGlobalPlacementOperator()) {
      assert (E.getNumPlacementArgs() == 1);
      /*const*/ Expr /*P*/ arg = ((Stmt.ConstExprIterator)E.placement_arguments$Const().begin()).$star();
      
      type$ptr<AlignmentSource> alignSource = create_type$null$ptr();
      allocation.$assignMove($this().EmitPointerWithAlignment(arg, $AddrOf(alignSource)));
      
      // The pointer expression will, in many cases, be an opaque void*.
      // In these cases, discard the computed alignment and use the
      // formal alignment of the allocated type.
      if (alignSource.$star() != AlignmentSource.Decl) {
        allocation.$assignMove(new Address(allocation.getPointer(), 
                $this().getContext().getTypeAlignInChars(new QualType(allocType))));
      }
      
      // Set up allocatorArgs for the call to operator delete if it's not
      // the reserved global operator.
      if ((E.getOperatorDelete() != null)
         && !E.getOperatorDelete().isReservedGlobalPlacementOperator()) {
        allocatorArgs.add(RValue.get(allocSize), $this().getContext().getSizeType().$QualType());
        allocatorArgs.add(RValue.get(allocation.getPointer()), arg.getType());
      }
    } else {
      /*const*/ FunctionProtoType /*P*/ allocatorType = allocator.getType().$arrow().castAs(FunctionProtoType.class);
      
      // The allocation size is the first argument.
      QualType sizeType = $this().getContext().getSizeType().$QualType();
      allocatorArgs.add(RValue.get(allocSize), new QualType(sizeType));
      
      // We start at 1 here because the first argument (the allocation size)
      // has already been emitted.
      $this().EmitCallArgs(allocatorArgs, allocatorType, E.placement_arguments$Const(), 
          /* CalleeDecl */ (/*const*/ FunctionDecl /*P*/ )null, 
          /*ParamsToSkip*/ 1);
      
      RValue RV = CGExprCXXStatics.EmitNewDeleteCall(/*Deref*/$this(), allocator, allocatorType, allocatorArgs);
      
      // For now, only assume that the allocation function returns
      // something satisfactorily aligned for the element type, plus
      // the cookie if we have one.
      CharUnits allocationAlign = $this().getContext().getTypeAlignInChars(new QualType(allocType));
      if (allocSize != allocSizeWithoutCookie.$deref()) {
        CharUnits cookieAlign = /*J:ToBase*/super.getSizeAlign(); // FIXME?
        allocationAlign.$assign(std.max(allocationAlign, cookieAlign));
      }
      
      allocation.$assignMove(new Address(RV.getScalarVal(), new CharUnits(allocationAlign)));
    }
    
    // Emit a null check on the allocation result if the allocation
    // function is allowed to return null (because it has a non-throwing
    // exception spec or is the reserved placement new) and we have an
    // interesting initializer.
    boolean nullCheck = E.shouldNullCheckAllocation($this().getContext())
       && (!allocType.isPODType($this().getContext()) || E.hasInitializer());
    
    BasicBlock /*P*/ nullCheckBB = null;
    BasicBlock /*P*/ contBB = null;
    
    // The null-check means that the initializer is conditionally
    // evaluated.
    ConditionalEvaluation conditional/*J*/= new ConditionalEvaluation(/*Deref*/$this());
    if (nullCheck) {
      conditional.begin(/*Deref*/$this());
      
      nullCheckBB = $this().Builder.GetInsertBlock();
      BasicBlock /*P*/ notNullBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"new.notnull"));
      contBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"new.cont"));
      
      Value /*P*/ isNull = $this().Builder.CreateIsNull(allocation.getPointer(), new Twine(/*KEEP_STR*/"new.isnull"));
      $this().Builder.CreateCondBr(isNull, contBB, notNullBB);
      $this().EmitBlock(notNullBB);
    }
    
    // If there's an operator delete, enter a cleanup to call it if an
    // exception is thrown.
    EHScopeStack.stable_iterator operatorDeleteCleanup/*J*/= new EHScopeStack.stable_iterator();
    Instruction /*P*/ cleanupDominator = null;
    if ((E.getOperatorDelete() != null)
       && !E.getOperatorDelete().isReservedGlobalPlacementOperator()) {
      CGExprCXXStatics.EnterNewDeleteCleanup(/*Deref*/$this(), E, new Address(allocation), allocSize, allocatorArgs);
      operatorDeleteCleanup.$assignMove($this().EHStack.stable_begin());
      cleanupDominator = $this().Builder.CreateUnreachable();
    }
    assert ((allocSize == allocSizeWithoutCookie.$deref()) == CGExprCXXStatics.CalculateCookiePadding(/*Deref*/$this(), E).isZero());
    if (allocSize != allocSizeWithoutCookie.$deref()) {
      assert (E.isArray());
      allocation.$assignMove($this().CGM.getCXXABI().InitializeArrayCookie(/*Deref*/$this(), new Address(allocation), 
              numElements.$deref(), 
              E, new QualType(allocType)));
    }
    
    org.llvm.ir.Type /*P*/ elementTy = $this().ConvertTypeForMem(new QualType(allocType));
    Address result = $this().Builder.CreateElementBitCast(new Address(allocation), elementTy);
    
    // Passing pointer through invariant.group.barrier to avoid propagation of
    // vptrs information which may be included in previous type.
    if ($this().CGM.getCodeGenOpts().StrictVTablePointers
       && $2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) > 0
       && allocator.isReservedGlobalPlacementOperator()) {
      result.$assignMove(new Address($this().Builder.CreateInvariantGroupBarrier(result.getPointer()), 
              result.getAlignment()));
    }
    
    CGExprCXXStatics.EmitNewInitializer(/*Deref*/$this(), E, new QualType(allocType), elementTy, new Address(result), numElements.$deref(), 
        allocSizeWithoutCookie.$deref());
    if (E.isArray()) {
      // NewPtr is a pointer to the base element type.  If we're
      // allocating an array of arrays, we'll need to cast back to the
      // array pointer type.
      org.llvm.ir.Type /*P*/ resultType = $this().ConvertTypeForMem(E.getType());
      if (result.getType() != resultType) {
        result.$assignMove($this().Builder.CreateBitCast(new Address(result), resultType));
      }
    }
    
    // Deactivate the 'operator delete' cleanup if we finished
    // initialization.
    if (operatorDeleteCleanup.isValid()) {
      $this().DeactivateCleanupBlock(new EHScopeStack.stable_iterator(operatorDeleteCleanup), cleanupDominator);
      cleanupDominator.eraseFromParent();
    }
    
    Value /*P*/ resultPtr = result.getPointer();
    if (nullCheck) {
      conditional.end(/*Deref*/$this());
      
      BasicBlock /*P*/ notNullBB = $this().Builder.GetInsertBlock();
      $this().EmitBlock(contBB);
      
      PHINode /*P*/ PHI = $this().Builder.CreatePHI(resultPtr.getType(), 2);
      PHI.addIncoming(resultPtr, notNullBB);
      PHI.addIncoming(Constant.getNullValue(resultPtr.getType()), 
          nullCheckBB);
      
      resultPtr = PHI;
    }
    
    return resultPtr;
  } finally {
    if (allocatorArgs != null) { allocatorArgs.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXDeleteExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1704,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXDeleteExpr", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitCXXDeleteExprEPKNS_13CXXDeleteExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitCXXDeleteExprEPKNS_13CXXDeleteExprE")
//</editor-fold>
public final void EmitCXXDeleteExpr(/*const*/ CXXDeleteExpr /*P*/ E) {
  /*const*/ Expr /*P*/ Arg = E.getArgument$Const();
  Address Ptr = $this().EmitPointerWithAlignment(Arg);
  
  // Null check the pointer.
  BasicBlock /*P*/ DeleteNotNull = $this().createBasicBlock(new Twine(/*KEEP_STR*/"delete.notnull"));
  BasicBlock /*P*/ DeleteEnd = $this().createBasicBlock(new Twine(/*KEEP_STR*/"delete.end"));
  
  Value /*P*/ IsNull = $this().Builder.CreateIsNull(Ptr.getPointer(), new Twine(/*KEEP_STR*/"isnull"));
  
  $this().Builder.CreateCondBr(IsNull, DeleteEnd, DeleteNotNull);
  $this().EmitBlock(DeleteNotNull);
  
  // We might be deleting a pointer to array.  If so, GEP down to the
  // first non-array element.
  // (this assumes that A(*)[3][7] is converted to [3 x [7 x %A]]*)
  QualType DeleteTy = Arg.getType().$arrow().getAs(org.clang.ast.PointerType.class).getPointeeType();
  if (DeleteTy.$arrow().isConstantArrayType()) {
    Value /*P*/ Zero = $this().Builder.getInt32(0);
    SmallVector<Value /*P*/ > GEP/*J*/= new SmallVector<Value /*P*/ >(8, (Value /*P*/ )null);
    
    GEP.push_back(Zero); // point at the outermost array
    {
      
      // For each layer of array type we're pointing at:
      /*const*/ ConstantArrayType /*P*/ Arr;
      while (((/*P*/ Arr = $this().getContext().getAsConstantArrayType(new QualType(DeleteTy))) != null)) {
        // 1. Unpeel the array type.
        DeleteTy.$assignMove(Arr.getElementType());
        
        // 2. GEP to the first element of the array.
        GEP.push_back(Zero);
      }
    }
    
    Ptr.$assignMove(new Address($this().Builder.CreateInBoundsGEP(Ptr.getPointer(), new ArrayRef<Value /*P*/ >(GEP, true), new Twine(/*KEEP_STR*/"del.first")), 
            Ptr.getAlignment()));
  }
  assert ($this().ConvertTypeForMem(new QualType(DeleteTy)) == Ptr.getElementType());
  if (E.isArrayForm()) {
    CGExprCXXStatics.EmitArrayDelete(/*Deref*/$this(), E, new Address(Ptr), new QualType(DeleteTy));
  } else {
    CGExprCXXStatics.EmitObjectDelete(/*Deref*/$this(), E, new Address(Ptr), new QualType(DeleteTy));
  }
  
  $this().EmitBlock(DeleteEnd);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitDeleteCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1487,
 FQN="clang::CodeGen::CodeGenFunction::EmitDeleteCall", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitDeleteCallEPKNS_12FunctionDeclEPN4llvm5ValueENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitDeleteCallEPKNS_12FunctionDeclEPN4llvm5ValueENS_8QualTypeE")
//</editor-fold>
public final void EmitDeleteCall(/*const*/ FunctionDecl /*P*/ DeleteFD, 
              Value /*P*/ Ptr, 
              QualType DeleteTy) {
  CallArgList DeleteArgs = null;
  try {
    assert (DeleteFD.getOverloadedOperator() == OverloadedOperatorKind.OO_Delete);
    
    /*const*/ FunctionProtoType /*P*/ DeleteFTy = DeleteFD.getType().$arrow().getAs(FunctionProtoType.class);
    
    DeleteArgs/*J*/= new CallArgList();
    
    // Check if we need to pass the size to the delete operator.
    Value /*P*/ Size = null;
    QualType SizeTy/*J*/= new QualType();
    if (DeleteFTy.getNumParams() == 2) {
      SizeTy.$assignMove(DeleteFTy.getParamType(1));
      CharUnits DeleteTypeSize = $this().getContext().getTypeSizeInChars(/*NO_COPY*/DeleteTy);
      Size = ConstantInt.get($this().ConvertType(new QualType(SizeTy)), 
          DeleteTypeSize.getQuantity());
    }
    
    QualType ArgTy = DeleteFTy.getParamType(0);
    Value /*P*/ DeletePtr = $this().Builder.CreateBitCast(Ptr, $this().ConvertType(new QualType(ArgTy)));
    DeleteArgs.add(RValue.get(DeletePtr), new QualType(ArgTy));
    if ((Size != null)) {
      DeleteArgs.add(RValue.get(Size), new QualType(SizeTy));
    }
    
    // Emit the call to delete.
    CGExprCXXStatics.EmitNewDeleteCall(/*Deref*/$this(), DeleteFD, DeleteFTy, DeleteArgs);
  } finally {
    if (DeleteArgs != null) { DeleteArgs.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitBuiltinNewDeleteCall">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1145,
 FQN="clang::CodeGen::CodeGenFunction::EmitBuiltinNewDeleteCall", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitBuiltinNewDeleteCallEPKNS_17FunctionProtoTypeEPKNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitBuiltinNewDeleteCallEPKNS_17FunctionProtoTypeEPKNS_4ExprEb")
//</editor-fold>
public final RValue EmitBuiltinNewDeleteCall(/*const*/ FunctionProtoType /*P*/ Type, 
                        /*const*/ Expr /*P*/ Arg, 
                        boolean IsDelete) {
  CallArgList Args = null;
  try {
    Args/*J*/= new CallArgList();
    /*const*/ type$ptr<Expr> /*P*/ ArgS = create_type$ptr(Arg);
    $this().EmitCallArgs1(Args, new ArrayRef<QualType>(Type.param_type_begin().$star(), false), new iterator_range</*const*/ Expr /*P*/ /*const*/>(ArgS, ArgS.$add(1)));
    // Find the allocation or deallocation function that we're calling.
    final ASTContext /*&*/ Ctx = $this().getContext();
    DeclarationName Name = Ctx.DeclarationNames.
        getCXXOperatorName(IsDelete ? OverloadedOperatorKind.OO_Delete : OverloadedOperatorKind.OO_New);
    for (NamedDecl /*P*/ Decl : Ctx.getTranslationUnitDecl().lookup(new DeclarationName(Name)))  {
      {
        FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(Decl);
        if ((FD != null)) {
          if (Ctx.hasSameType(FD.getType(), new QualType(Type, 0))) {
            return CGExprCXXStatics.EmitNewDeleteCall(/*Deref*/$this(), cast_FunctionDecl(Decl), Type, Args);
          }
        }
      }
    }
    throw new llvm_unreachable("predeclared global operator new/delete is missing");
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXTypeidExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1816,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXTypeidExpr", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitCXXTypeidExprEPKNS_13CXXTypeidExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitCXXTypeidExprEPKNS_13CXXTypeidExprE")
//</editor-fold>
public final Value /*P*/ EmitCXXTypeidExpr(/*const*/ CXXTypeidExpr /*P*/ E) {
  org.llvm.ir.Type /*P*/ StdTypeInfoPtrTy = $this().ConvertType(E.getType()).getPointerTo();
  if (E.isTypeOperand()) {
    Constant /*P*/ TypeInfo = $this().CGM.GetAddrOfRTTIDescriptor(E.getTypeOperand($this().getContext()));
    return $this().Builder.CreateBitCast(TypeInfo, StdTypeInfoPtrTy);
  }
  
  // C++ [expr.typeid]p2:
  //   When typeid is applied to a glvalue expression whose type is a
  //   polymorphic class type, the result refers to a std::type_info object
  //   representing the type of the most derived object (that is, the dynamic
  //   type) to which the glvalue refers.
  if (E.isPotentiallyEvaluated()) {
    return CGExprCXXStatics.EmitTypeidFromVTable(/*Deref*/$this(), E.getExprOperand(), 
        StdTypeInfoPtrTy);
  }
  
  QualType OperandTy = E.getExprOperand().getType();
  return $this().Builder.CreateBitCast($this().CGM.GetAddrOfRTTIDescriptor(new QualType(OperandTy)), 
      StdTypeInfoPtrTy);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitDynamicCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1855,
 FQN="clang::CodeGen::CodeGenFunction::EmitDynamicCast", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitDynamicCastENS0_7AddressEPKNS_18CXXDynamicCastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitDynamicCastENS0_7AddressEPKNS_18CXXDynamicCastExprE")
//</editor-fold>
public final Value /*P*/ EmitDynamicCast(Address ThisAddr, 
               /*const*/ CXXDynamicCastExpr /*P*/ DCE) {
  $this().CGM.EmitExplicitCastExprType(DCE, $this());
  QualType DestTy = DCE.getTypeAsWritten();
  if (DCE.isAlwaysNull()) {
    {
      Value /*P*/ T = CGExprCXXStatics.EmitDynamicCastToNull(/*Deref*/$this(), new QualType(DestTy));
      if ((T != null)) {
        return T;
      }
    }
  }
  
  QualType SrcTy = DCE.getSubExpr$Const().getType();
  
  // C++ [expr.dynamic.cast]p7:
  //   If T is "pointer to cv void," then the result is a pointer to the most
  //   derived object pointed to by v.
  /*const*/ org.clang.ast.PointerType /*P*/ DestPTy = DestTy.$arrow().getAs(org.clang.ast.PointerType.class);
  
  boolean isDynamicCastToVoid;
  QualType SrcRecordTy/*J*/= new QualType();
  QualType DestRecordTy/*J*/= new QualType();
  if ((DestPTy != null)) {
    isDynamicCastToVoid = DestPTy.getPointeeType().$arrow().isVoidType();
    SrcRecordTy.$assignMove(SrcTy.$arrow().castAs(org.clang.ast.PointerType.class).getPointeeType());
    DestRecordTy.$assignMove(DestPTy.getPointeeType());
  } else {
    isDynamicCastToVoid = false;
    SrcRecordTy.$assign(SrcTy);
    DestRecordTy.$assignMove(DestTy.$arrow().castAs(ReferenceType.class).getPointeeType());
  }
  assert (SrcRecordTy.$arrow().isRecordType()) : "source type must be a record type!";
  
  // C++ [expr.dynamic.cast]p4: 
  //   If the value of v is a null pointer value in the pointer case, the result
  //   is the null pointer value of type T.
  boolean ShouldNullCheckSrcValue = $this().CGM.getCXXABI().shouldDynamicCastCallBeNullChecked(SrcTy.$arrow().isPointerType(), 
      new QualType(SrcRecordTy));
  
  BasicBlock /*P*/ CastNull = null;
  BasicBlock /*P*/ CastNotNull = null;
  BasicBlock /*P*/ CastEnd = $this().createBasicBlock(new Twine(/*KEEP_STR*/"dynamic_cast.end"));
  if (ShouldNullCheckSrcValue) {
    CastNull = $this().createBasicBlock(new Twine(/*KEEP_STR*/"dynamic_cast.null"));
    CastNotNull = $this().createBasicBlock(new Twine(/*KEEP_STR*/"dynamic_cast.notnull"));
    
    Value /*P*/ IsNull = $this().Builder.CreateIsNull(ThisAddr.getPointer());
    $this().Builder.CreateCondBr(IsNull, CastNull, CastNotNull);
    $this().EmitBlock(CastNotNull);
  }
  
  Value /*P*/ $Value;
  if (isDynamicCastToVoid) {
    $Value = $this().CGM.getCXXABI().EmitDynamicCastToVoid(/*Deref*/$this(), new Address(ThisAddr), new QualType(SrcRecordTy), 
        new QualType(DestTy));
  } else {
    assert (DestRecordTy.$arrow().isRecordType()) : "destination type must be a record type!";
    $Value = $this().CGM.getCXXABI().EmitDynamicCastCall(/*Deref*/$this(), new Address(ThisAddr), new QualType(SrcRecordTy), 
        new QualType(DestTy), new QualType(DestRecordTy), CastEnd);
    CastNotNull = $this().Builder.GetInsertBlock();
  }
  if (ShouldNullCheckSrcValue) {
    $this().EmitBranch(CastEnd);
    
    $this().EmitBlock(CastNull);
    $this().EmitBranch(CastEnd);
  }
  
  $this().EmitBlock(CastEnd);
  if (ShouldNullCheckSrcValue) {
    PHINode /*P*/ PHI = $this().Builder.CreatePHI($Value.getType(), 2);
    PHI.addIncoming($Value, CastNotNull);
    PHI.addIncoming(Constant.getNullValue($Value.getType()), CastNull);
    
    $Value = PHI;
  }
  
  return $Value;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXMemberOrOperatorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 73,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXMemberOrOperatorCall", NM="_ZN5clang7CodeGen15CodeGenFunction27EmitCXXMemberOrOperatorCallEPKNS_13CXXMethodDeclEPN4llvm5ValueENS0_15ReturnValueSlotES7_S7_NS_8QualTypeEPKNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction27EmitCXXMemberOrOperatorCallEPKNS_13CXXMethodDeclEPN4llvm5ValueENS0_15ReturnValueSlotES7_S7_NS_8QualTypeEPKNS_8CallExprE")
//</editor-fold>
public final RValue EmitCXXMemberOrOperatorCall(/*const*/ CXXMethodDecl /*P*/ MD, Value /*P*/ Callee, ReturnValueSlot ReturnValue, 
                           Value /*P*/ This, Value /*P*/ ImplicitParam, QualType ImplicitParamTy, 
                           /*const*/ CallExpr /*P*/ CE) {
  CallArgList Args = null;
  try {
    /*const*/ FunctionProtoType /*P*/ FPT = MD.getType().$arrow().castAs(FunctionProtoType.class);
    Args/*J*/= new CallArgList();
    RequiredArgs required = CGExprCXXStatics.commonEmitCXXMemberOrOperatorCall(/*Deref*/$this(), MD, This, ImplicitParam, new QualType(ImplicitParamTy), CE, Args);
    return $this().EmitCall($this().CGM.getTypes().arrangeCXXMethodCall(Args, FPT, new RequiredArgs(required)), 
        Callee, new ReturnValueSlot(ReturnValue), Args, new CGCalleeInfo(MD));
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXDestructorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 85,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXDestructorCall", NM="_ZN5clang7CodeGen15CodeGenFunction21EmitCXXDestructorCallEPKNS_17CXXDestructorDeclEPN4llvm5ValueES7_S7_NS_8QualTypeEPKNS_8CallExprENS0_12StructorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21EmitCXXDestructorCallEPKNS_17CXXDestructorDeclEPN4llvm5ValueES7_S7_NS_8QualTypeEPKNS_8CallExprENS0_12StructorTypeE")
//</editor-fold>
public final RValue EmitCXXDestructorCall(/*const*/ CXXDestructorDecl /*P*/ DD, Value /*P*/ Callee, Value /*P*/ This, 
                     Value /*P*/ ImplicitParam, QualType ImplicitParamTy, /*const*/ CallExpr /*P*/ CE, 
                     StructorType Type) {
  CallArgList Args = null;
  try {
    Args/*J*/= new CallArgList();
    CGExprCXXStatics.commonEmitCXXMemberOrOperatorCall(/*Deref*/$this(), DD, This, ImplicitParam, 
        new QualType(ImplicitParamTy), CE, Args);
    return $this().EmitCall($this().CGM.getTypes().arrangeCXXStructorDeclaration(DD, Type), 
        Callee, new ReturnValueSlot(), Args, new CGCalleeInfo(DD));
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}


// Note: This function also emit constructor calls to support a MSVC
// extensions allowing explicit constructor function call.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXMemberCallExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 106,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXMemberCallExpr", NM="_ZN5clang7CodeGen15CodeGenFunction21EmitCXXMemberCallExprEPKNS_17CXXMemberCallExprENS0_15ReturnValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21EmitCXXMemberCallExprEPKNS_17CXXMemberCallExprENS0_15ReturnValueSlotE")
//</editor-fold>
public final RValue EmitCXXMemberCallExpr(/*const*/ CXXMemberCallExpr /*P*/ CE, 
                     ReturnValueSlot ReturnValue) {
  /*const*/ Expr /*P*/ callee = CE.getCallee$Const().IgnoreParens$Const();
  if (AstRTTI.isa_BinaryOperator(callee)) {
    return $this().EmitCXXMemberPointerCallExpr(CE, new ReturnValueSlot(ReturnValue));
  }
  
  /*const*/ MemberExpr /*P*/ ME = cast_MemberExpr(callee);
  /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(ME.getMemberDecl());
  if (MD.isStatic()) {
    // The method is static, emit it as we would a regular call.
    Value /*P*/ Callee = $this().CGM.GetAddrOfFunction(new GlobalDecl(MD));
    return $this().EmitCall($this().getContext().getPointerType(MD.getType()), Callee, CE, 
        new ReturnValueSlot(ReturnValue));
  }
  
  boolean HasQualifier = ME.hasQualifier();
  NestedNameSpecifier /*P*/ Qualifier = HasQualifier ? ME.getQualifier() : null;
  boolean IsArrow = ME.isArrow();
  /*const*/ Expr /*P*/ Base = ME.getBase();
  
  return $this().EmitCXXMemberOrOperatorMemberCallExpr(CE, MD, new ReturnValueSlot(ReturnValue), HasQualifier, Qualifier, IsArrow, Base);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXMemberOrOperatorMemberCallExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 132,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXMemberOrOperatorMemberCallExpr", NM="_ZN5clang7CodeGen15CodeGenFunction37EmitCXXMemberOrOperatorMemberCallExprEPKNS_8CallExprEPKNS_13CXXMethodDeclENS0_15ReturnValueSlotEbPNS_19NestedNameSpecifierEbPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction37EmitCXXMemberOrOperatorMemberCallExprEPKNS_8CallExprEPKNS_13CXXMethodDeclENS0_15ReturnValueSlotEbPNS_19NestedNameSpecifierEbPKNS_4ExprE")
//</editor-fold>
public final RValue EmitCXXMemberOrOperatorMemberCallExpr(/*const*/ CallExpr /*P*/ CE, /*const*/ CXXMethodDecl /*P*/ MD, ReturnValueSlot ReturnValue, 
                                     boolean HasQualifier, NestedNameSpecifier /*P*/ Qualifier, boolean IsArrow, 
                                     /*const*/ Expr /*P*/ Base) {
  assert (isa_CXXMemberCallExpr(CE) || isa_CXXOperatorCallExpr(CE));
  
  // Compute the object pointer.
  boolean CanUseVirtualCall = MD.isVirtual() && !HasQualifier;
  
  /*const*/ CXXMethodDecl /*P*/ DevirtualizedMethod = null;
  if (CanUseVirtualCall && $this().CanDevirtualizeMemberFunctionCall(Base, MD)) {
    /*const*/ CXXRecordDecl /*P*/ BestDynamicDecl = Base.getBestDynamicClassType();
    DevirtualizedMethod = MD.getCorrespondingMethodInClass$Const(BestDynamicDecl);
    assert Native.$bool(DevirtualizedMethod);
    /*const*/ CXXRecordDecl /*P*/ DevirtualizedClass = DevirtualizedMethod.getParent$Const();
    /*const*/ Expr /*P*/ Inner = Base.ignoreParenBaseCasts$Const();
    if (QualType.$noteq_QualType$C(DevirtualizedMethod.getReturnType().getCanonicalType(), 
        MD.getReturnType().getCanonicalType())) {
      // If the return types are not the same, this might be a case where more
      // code needs to run to compensate for it. For example, the derived
      // method might return a type that inherits form from the return
      // type of MD and has a prefix.
      // For now we just avoid devirtualizing these covariant cases.
      DevirtualizedMethod = null;
    } else if (CGExprCXXStatics.getCXXRecord(Inner) == DevirtualizedClass) {
      // If the class of the Inner expression is where the dynamic method
      // is defined, build the this pointer from it.
      Base = Inner;
    } else if (CGExprCXXStatics.getCXXRecord(Base) != DevirtualizedClass) {
      // If the method is defined in a class that is not the best dynamic
      // one or the one of the full expression, we would have to build
      // a derived-to-base cast to compute the correct this pointer, but
      // we don't have support for that yet, so do a virtual call.
      DevirtualizedMethod = null;
    }
  }
  
  Address This = Address.invalid();
  if (IsArrow) {
    This.$assignMove($this().EmitPointerWithAlignment(Base));
  } else {
    This.$assignMove($this().EmitLValue(Base).getAddress());
  }
  if (MD.isTrivial() || (MD.isDefaulted() && MD.getParent$Const().isUnion())) {
    if (isa_CXXDestructorDecl(MD)) {
      return RValue.get((Value /*P*/ )null);
    }
    if (isa_CXXConstructorDecl(MD)
       && cast_CXXConstructorDecl(MD).isDefaultConstructor()) {
      return RValue.get((Value /*P*/ )null);
    }
    if (!MD.getParent$Const().mayInsertExtraPadding()) {
      if (MD.isCopyAssignmentOperator() || MD.isMoveAssignmentOperator()) {
        // We don't like to generate the trivial copy/move assignment operator
        // when it isn't necessary; just produce the proper effect here.
        // Special case: skip first argument of CXXOperatorCall (it is "this").
        /*uint*/int ArgsToSkip = isa_CXXOperatorCallExpr(CE) ? 1 : 0;
        Address RHS = $this().EmitLValue((CE.arg_begin$Const().$add(ArgsToSkip)).$star()).getAddress();
        $this().EmitAggregateAssign(new Address(This), new Address(RHS), CE.getType());
        return RValue.get(This.getPointer());
      }
      if (isa_CXXConstructorDecl(MD)
         && cast_CXXConstructorDecl(MD).isCopyOrMoveConstructor()) {
        // Trivial move and copy ctor are the same.
        assert (CE.getNumArgs() == 1) : "unexpected argcount for trivial ctor";
        Address RHS = $this().EmitLValue(CE.arg_begin$Const().$star()).getAddress();
        $this().EmitAggregateCopy(new Address(This), new Address(RHS), (CE.arg_begin$Const().$star()).getType());
        return RValue.get(This.getPointer());
      }
      throw new llvm_unreachable("unknown trivial member function");
    }
  }
  
  // Compute the function type we're calling.
  /*const*/ CXXMethodDecl /*P*/ CalleeDecl = (DevirtualizedMethod != null) ? DevirtualizedMethod : MD;
  /*const*/ CGFunctionInfo /*P*/ FInfo = null;
  {
    /*const*/ CXXDestructorDecl /*P*/ Dtor = dyn_cast_CXXDestructorDecl(CalleeDecl);
    if ((Dtor != null)) {
      FInfo = $AddrOf($this().CGM.getTypes().arrangeCXXStructorDeclaration(Dtor, StructorType.Complete));
    } else {
      /*const*/ CXXConstructorDecl /*P*/ Ctor = dyn_cast_CXXConstructorDecl(CalleeDecl);
      if ((Ctor != null)) {
        FInfo = $AddrOf($this().CGM.getTypes().arrangeCXXStructorDeclaration(Ctor, StructorType.Complete));
      } else {
        FInfo = $AddrOf($this().CGM.getTypes().arrangeCXXMethodDeclaration(CalleeDecl));
      }
    }
  }
  
  org.llvm.ir.FunctionType /*P*/ Ty = $this().CGM.getTypes().GetFunctionType($Deref(FInfo));
  
  // C++ [class.virtual]p12:
  //   Explicit qualification with the scope operator (5.1) suppresses the
  //   virtual call mechanism.
  //
  // We also don't emit a virtual call if the base expression has a record type
  // because then we know what the type is.
  boolean UseVirtualCall = CanUseVirtualCall && !(DevirtualizedMethod != null);
  Value /*P*/ Callee;
  {
    
    /*const*/ CXXDestructorDecl /*P*/ Dtor = dyn_cast_CXXDestructorDecl(MD);
    if ((Dtor != null)) {
      assert (CE.arg_begin$Const().$eq(CE.arg_end$Const())) : "Destructor shouldn't have explicit parameters";
      assert (ReturnValue.isNull()) : "Destructor shouldn't have return value";
      if (UseVirtualCall) {
        $this().CGM.getCXXABI().EmitVirtualDestructorCall(/*Deref*/$this(), Dtor, CXXDtorType.Dtor_Complete, new Address(This), cast_CXXMemberCallExpr(CE));
      } else {
        if ($this().getLangOpts().AppleKext && MD.isVirtual() && HasQualifier) {
          Callee = $this().BuildAppleKextVirtualCall(MD, Qualifier, Ty);
        } else if (!(DevirtualizedMethod != null)) {
          Callee
             = $this().CGM.getAddrOfCXXStructor(Dtor, StructorType.Complete, FInfo, Ty);
        } else {
          /*const*/ CXXDestructorDecl /*P*/ DDtor = cast_CXXDestructorDecl(DevirtualizedMethod);
          Callee = $this().CGM.GetAddrOfFunction(new GlobalDecl(AstJavaDifferentiators.JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, DDtor, CXXDtorType.Dtor_Complete), Ty);
        }
        $this().EmitCXXMemberOrOperatorCall(MD, Callee, new ReturnValueSlot(ReturnValue), This.getPointer(), 
            /*ImplicitParam=*/ (Value /*P*/ )null, new QualType(), CE);
      }
      return RValue.get((Value /*P*/ )null);
    }
  }
  {
    
    /*const*/ CXXConstructorDecl /*P*/ Ctor = dyn_cast_CXXConstructorDecl(MD);
    if ((Ctor != null)) {
      Callee = $this().CGM.GetAddrOfFunction(new GlobalDecl(AstJavaDifferentiators.JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, Ctor, CXXCtorType.Ctor_Complete), Ty);
    } else if (UseVirtualCall) {
      Callee = $this().CGM.getCXXABI().getVirtualFunctionPointer(/*Deref*/$this(), new GlobalDecl(MD), new Address(This), Ty, 
          CE.getLocStart());
    } else {
      if ($this().SanOpts.has(SanitizerKind.CFINVCall)
         && MD.getParent$Const().isDynamicClass()) {
        Value /*P*/ VTable = $this().GetVTablePtr(new Address(This), Unnamed_field9.Int8PtrTy, MD.getParent$Const());
        $this().EmitVTablePtrCheckForCall(MD.getParent$Const(), VTable, CFITypeCheckKind.CFITCK_NVCall, 
            CE.getLocStart());
      }
      if ($this().getLangOpts().AppleKext && MD.isVirtual() && HasQualifier) {
        Callee = $this().BuildAppleKextVirtualCall(MD, Qualifier, Ty);
      } else if (!(DevirtualizedMethod != null)) {
        Callee = $this().CGM.GetAddrOfFunction(new GlobalDecl(MD), Ty);
      } else {
        Callee = $this().CGM.GetAddrOfFunction(new GlobalDecl(DevirtualizedMethod), Ty);
      }
    }
  }
  if (MD.isVirtual()) {
    This.$assignMove($this().CGM.getCXXABI().adjustThisArgumentForVirtualFunctionCall(/*Deref*/$this(), new GlobalDecl(CalleeDecl), new Address(This), UseVirtualCall));
  }
  
  return $this().EmitCXXMemberOrOperatorCall(MD, Callee, new ReturnValueSlot(ReturnValue), This.getPointer(), 
      /*ImplicitParam=*/ (Value /*P*/ )null, new QualType(), CE);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXMemberPointerCallExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 284,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXMemberPointerCallExpr", NM="_ZN5clang7CodeGen15CodeGenFunction28EmitCXXMemberPointerCallExprEPKNS_17CXXMemberCallExprENS0_15ReturnValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28EmitCXXMemberPointerCallExprEPKNS_17CXXMemberCallExprENS0_15ReturnValueSlotE")
//</editor-fold>
public final RValue EmitCXXMemberPointerCallExpr(/*const*/ CXXMemberCallExpr /*P*/ E, 
                            ReturnValueSlot ReturnValue) {
  CallArgList Args = null;
  try {
    /*const*/ org.clang.ast.BinaryOperator /*P*/ BO = AstRTTI.cast_BinaryOperator(E.getCallee$Const().IgnoreParens$Const());
    /*const*/ Expr /*P*/ BaseExpr = BO.getLHS();
    /*const*/ Expr /*P*/ MemFnExpr = BO.getRHS();
    
    /*const*/ MemberPointerType /*P*/ MPT = MemFnExpr.getType().$arrow().castAs(MemberPointerType.class);
    
    /*const*/ FunctionProtoType /*P*/ FPT = MPT.getPointeeType().$arrow().castAs(FunctionProtoType.class);
    /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(MPT.__getClass().getAs$RecordType().getDecl());
    
    // Get the member function pointer.
    Value /*P*/ MemFnPtr = $this().EmitScalarExpr(MemFnExpr);
    
    // Emit the 'this' pointer.
    Address This = Address.invalid();
    if (BO.getOpcode() == BinaryOperatorKind.BO_PtrMemI) {
      This.$assignMove($this().EmitPointerWithAlignment(BaseExpr));
    } else {
      This.$assignMove($this().EmitLValue(BaseExpr).getAddress());
    }
    
    $this().EmitTypeCheck(TypeCheckKind.TCK_MemberCall, E.getExprLoc(), This.getPointer(), 
        new QualType(MPT.__getClass(), 0));
    
    // Ask the ABI to load the callee.  Note that This is modified.
    type$ref<Value /*P*/ > ThisPtrForCall = create_type$null$ref(null);
    Value /*P*/ Callee = $this().CGM.getCXXABI().EmitLoadOfMemberFunctionPointer(/*Deref*/$this(), BO, new Address(This), 
        ThisPtrForCall, MemFnPtr, MPT);
    
    Args/*J*/= new CallArgList();
    
    QualType ThisType = $this().getContext().getPointerType($this().getContext().getTagDeclType(RD));
    
    // Push the this ptr.
    Args.add(RValue.get(ThisPtrForCall.$deref()), new QualType(ThisType));
    
    RequiredArgs required = RequiredArgs.forPrototypePlus(FPT, 1, /*FD=*/ (/*const*/ FunctionDecl /*P*/ )null);
    
    // And the rest of the call args
    $this().EmitCallArgs(Args, FPT, E.arguments$Const());
    return $this().EmitCall($this().CGM.getTypes().arrangeCXXMethodCall(Args, FPT, new RequiredArgs(required)), 
        Callee, new ReturnValueSlot(ReturnValue), Args);
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXOperatorMemberCallExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 336,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXOperatorMemberCallExpr", NM="_ZN5clang7CodeGen15CodeGenFunction29EmitCXXOperatorMemberCallExprEPKNS_19CXXOperatorCallExprEPKNS_13CXXMethodDeclENS0_15ReturnValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction29EmitCXXOperatorMemberCallExprEPKNS_19CXXOperatorCallExprEPKNS_13CXXMethodDeclENS0_15ReturnValueSlotE")
//</editor-fold>
public final RValue EmitCXXOperatorMemberCallExpr(/*const*/ CXXOperatorCallExpr /*P*/ E, 
                             /*const*/ CXXMethodDecl /*P*/ MD, 
                             ReturnValueSlot ReturnValue) {
  assert (MD.isInstance()) : "Trying to emit a member call expr on a static method!";
  return $this().EmitCXXMemberOrOperatorMemberCallExpr(E, MD, new ReturnValueSlot(ReturnValue), /*HasQualifier=*/ false, /*Qualifier=*/ (NestedNameSpecifier /*P*/ )null, 
      /*IsArrow=*/ false, E.getArg$Const(0));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCUDAKernelCallExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 347,
 FQN="clang::CodeGen::CodeGenFunction::EmitCUDAKernelCallExpr", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitCUDAKernelCallExprEPKNS_18CUDAKernelCallExprENS0_15ReturnValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitCUDAKernelCallExprEPKNS_18CUDAKernelCallExprENS0_15ReturnValueSlotE")
//</editor-fold>
public final RValue EmitCUDAKernelCallExpr(/*const*/ CUDAKernelCallExpr /*P*/ E, 
                      ReturnValueSlot ReturnValue) {
  return $this().CGM.getCUDARuntime().EmitCUDAKernelCallExpr(/*Deref*/$this(), E, new ReturnValueSlot(ReturnValue));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXConstructExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 439,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXConstructExpr", NM="_ZN5clang7CodeGen15CodeGenFunction20EmitCXXConstructExprEPKNS_16CXXConstructExprENS0_12AggValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20EmitCXXConstructExprEPKNS_16CXXConstructExprENS0_12AggValueSlotE")
//</editor-fold>
public final void EmitCXXConstructExpr(/*const*/ CXXConstructExpr /*P*/ E, 
                    AggValueSlot Dest) {
  assert (!Dest.isIgnored()) : "Must have a destination!";
  /*const*/ CXXConstructorDecl /*P*/ CD = E.getConstructor();
  
  // If we require zero initialization before (or instead of) calling the
  // constructor, as can be the case with a non-user-provided default
  // constructor, emit the zero initialization now, unless destination is
  // already zeroed.
  if (E.requiresZeroInitialization() && !(Dest.isZeroed().getValue() != 0)) {
    switch (E.getConstructionKind()) {
     case CK_Delegating:
     case CK_Complete:
      $this().EmitNullInitialization(Dest.getAddress(), E.getType());
      break;
     case CK_VirtualBase:
     case CK_NonVirtualBase:
      CGExprCXXStatics.EmitNullBaseClassInitialization(/*Deref*/$this(), Dest.getAddress(), 
          CD.getParent$Const());
      break;
    }
  }
  
  // If this is a call to a trivial default constructor, do nothing.
  if (CD.isTrivial() && CD.isDefaultConstructor()) {
    return;
  }
  
  // Elide the constructor if we're constructing from a temporary.
  // The temporary check is required because Sema sets this on NRVO
  // returns.
  if ($this().getLangOpts().ElideConstructors && E.isElidable()) {
    assert ($this().getContext().hasSameUnqualifiedType(E.getType(), E.getArg$Const(0).getType()));
    if (E.getArg$Const(0).isTemporaryObject($this().getContext(), CD.getParent$Const())) {
      $this().EmitAggExpr(E.getArg$Const(0), new AggValueSlot(Dest));
      return;
    }
  }
  {
    
    /*const*/ org.clang.ast.ArrayType /*P*/ arrayType = $this().getContext().getAsArrayType(E.getType());
    if ((arrayType != null)) {
      $this().EmitCXXAggrConstructorCall(CD, arrayType, Dest.getAddress(), E);
    } else {
      CXXCtorType Type = CXXCtorType.Ctor_Complete;
      boolean ForVirtualBase = false;
      boolean Delegating = false;
      switch (E.getConstructionKind()) {
       case CK_Delegating:
        // We should be emitting a constructor; GlobalDecl will assert this
        Type = $this().CurGD.getCtorType();
        Delegating = true;
        break;
       case CK_Complete:
        Type = CXXCtorType.Ctor_Complete;
        break;
       case CK_VirtualBase:
        ForVirtualBase = true;
       case CK_NonVirtualBase:
        // fall-through
        Type = CXXCtorType.Ctor_Base;
      }
      
      // Call the constructor.
      $this().EmitCXXConstructorCall(CD, Type, ForVirtualBase, Delegating, 
          Dest.getAddress(), E);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitSynthesizedCXXCopyCtor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 512,
 FQN="clang::CodeGen::CodeGenFunction::EmitSynthesizedCXXCopyCtor", NM="_ZN5clang7CodeGen15CodeGenFunction26EmitSynthesizedCXXCopyCtorENS0_7AddressES2_PKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26EmitSynthesizedCXXCopyCtorENS0_7AddressES2_PKNS_4ExprE")
//</editor-fold>
public final void EmitSynthesizedCXXCopyCtor(Address Dest, Address Src, 
                          /*const*/ Expr /*P*/ Exp) {
  RunCleanupsScope Scope = null;
  try {
    {
      /*const*/ ExprWithCleanups /*P*/ E = dyn_cast_ExprWithCleanups(Exp);
      if ((E != null)) {
        Exp = E.getSubExpr$Const();
      }
    }
    assert (isa_CXXConstructExpr(Exp)) : "EmitSynthesizedCXXCopyCtor - unknown copy ctor expr";
    /*const*/ CXXConstructExpr /*P*/ E = cast_CXXConstructExpr(Exp);
    /*const*/ CXXConstructorDecl /*P*/ CD = E.getConstructor();
    Scope/*J*/= new RunCleanupsScope(/*Deref*/$this());
    
    // If we require zero initialization before (or instead of) calling the
    // constructor, as can be the case with a non-user-provided default
    // constructor, emit the zero initialization now.
    // FIXME. Do I still need this for a copy ctor synthesis?
    if (E.requiresZeroInitialization()) {
      $this().EmitNullInitialization(new Address(Dest), E.getType());
    }
    assert (!($this().getContext().getAsConstantArrayType(E.getType()) != null)) : "EmitSynthesizedCXXCopyCtor - Copied-in Array";
    $this().EmitSynthesizedCXXCopyCtorCall(CD, new Address(Dest), new Address(Src), E);
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLambdaExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1938,
 FQN="clang::CodeGen::CodeGenFunction::EmitLambdaExpr", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitLambdaExprEPKNS_10LambdaExprENS0_12AggValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitLambdaExprEPKNS_10LambdaExprENS0_12AggValueSlotE")
//</editor-fold>
public final void EmitLambdaExpr(/*const*/ LambdaExpr /*P*/ E, AggValueSlot Slot) {
  RunCleanupsScope Scope = null;
  try {
    Scope/*J*/= new RunCleanupsScope(/*Deref*/$this());
    LValue SlotLV = $this().MakeAddrLValue(Slot.getAddress(), E.getType());
    
    DeclContext.specific_decl_iterator<FieldDecl> CurField = E.getLambdaClass().field_begin();
    for (type$ptr<Expr /*P*/ /*const*/ /*P*/> i = $tryClone(E.capture_init_begin$Const()), 
        /*P*/ /*const*/ /*P*/ e = $tryClone(E.capture_init_end$Const());
         $noteq_ptr(i, e); i.$preInc() , CurField.$preInc()) {
      // Emit initialization
      LValue LV = $this().EmitLValueForFieldInitialization(new LValue(SlotLV), CurField.$star());
      if (CurField.$arrow().hasCapturedVLAType()) {
        /*const*/ VariableArrayType /*P*/ VAT = CurField.$arrow().getCapturedVLAType();
        $this().EmitStoreThroughLValue(RValue.get($this().VLASizeMap.$at_T1$RR(VAT.getSizeExpr())), new LValue(LV));
      } else {
        ArrayRef<VarDecl /*P*/ > ArrayIndexes/*J*/= new ArrayRef<VarDecl /*P*/ >(true);
        if (CurField.$arrow().getType().$arrow().isArrayType()) {
          ArrayIndexes.$assignMove(E.getCaptureInitIndexVars(i));
        }
        $this().EmitInitializerForField(CurField.$star(), new LValue(LV), i.$star(), new ArrayRef<VarDecl /*P*/ >(ArrayIndexes));
      }
    }
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}

} // END OF class CodeGenFunction_CGExprCXX
