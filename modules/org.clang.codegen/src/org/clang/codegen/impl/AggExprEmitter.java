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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.ast.DeclContext.specific_decl_iterator;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.codegen.impl.CGExprAggStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 33,
 FQN="(anonymous namespace)::AggExprEmitter", NM="_ZN12_GLOBAL__N_114AggExprEmitterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitterE")
//</editor-fold>
public class AggExprEmitter implements /*public*/ StmtVisitorVoid<AggExprEmitter> {
  private final CodeGenFunction /*&*/ CGF;
  private final CGBuilderTy /*&*/ Builder;
  private AggValueSlot Dest;
  private boolean IsResultUnused;
  
  /// We want to use 'dest' as the return slot except under two
  /// conditions:
  ///   - The destination slot requires garbage collection, so we
  ///     need to use the GC API.
  ///   - The destination slot is potentially aliased.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::shouldUseDestForReturnSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 44,
   FQN="(anonymous namespace)::AggExprEmitter::shouldUseDestForReturnSlot", NM="_ZNK12_GLOBAL__N_114AggExprEmitter26shouldUseDestForReturnSlotEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZNK12_GLOBAL__N_114AggExprEmitter26shouldUseDestForReturnSlotEv")
  //</editor-fold>
  private boolean shouldUseDestForReturnSlot() /*const*/ {
    return !((Dest.requiresGCollection().getValue() != 0) || (Dest.isPotentiallyAliased().getValue() != 0));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::getReturnValueSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 48,
   FQN="(anonymous namespace)::AggExprEmitter::getReturnValueSlot", NM="_ZNK12_GLOBAL__N_114AggExprEmitter18getReturnValueSlotEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZNK12_GLOBAL__N_114AggExprEmitter18getReturnValueSlotEv")
  //</editor-fold>
  private ReturnValueSlot getReturnValueSlot() /*const*/ {
    if (!shouldUseDestForReturnSlot()) {
      return new ReturnValueSlot();
    }
    
    return new ReturnValueSlot(Dest.getAddress(), Dest.isVolatile(), 
        IsResultUnused);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::EnsureSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 56,
   FQN="(anonymous namespace)::AggExprEmitter::EnsureSlot", NM="_ZN12_GLOBAL__N_114AggExprEmitter10EnsureSlotEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter10EnsureSlotEN5clang8QualTypeE")
  //</editor-fold>
  private AggValueSlot EnsureSlot(QualType T) {
    if (!Dest.isIgnored()) {
      return new AggValueSlot(Dest);
    }
    return CGF.CreateAggTemp(new QualType(T), new Twine(/*KEEP_STR*/"agg.tmp.ensured"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::EnsureDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 60,
   FQN="(anonymous namespace)::AggExprEmitter::EnsureDest", NM="_ZN12_GLOBAL__N_114AggExprEmitter10EnsureDestEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter10EnsureDestEN5clang8QualTypeE")
  //</editor-fold>
  private void EnsureDest(QualType T) {
    if (!Dest.isIgnored()) {
      return;
    }
    Dest.$assignMove(CGF.CreateAggTemp(new QualType(T), new Twine(/*KEEP_STR*/"agg.tmp.ensured")));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::AggExprEmitter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 66,
   FQN="(anonymous namespace)::AggExprEmitter::AggExprEmitter", NM="_ZN12_GLOBAL__N_114AggExprEmitterC1ERN5clang7CodeGen15CodeGenFunctionENS2_12AggValueSlotEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitterC1ERN5clang7CodeGen15CodeGenFunctionENS2_12AggValueSlotEb")
  //</editor-fold>
  public AggExprEmitter(final CodeGenFunction /*&*/ cgf, AggValueSlot Dest, boolean IsResultUnused) {
    // : StmtVisitor<AggExprEmitter>(), CGF(cgf), Builder(CGF.Builder), Dest(Dest), IsResultUnused(IsResultUnused) 
    //START JInit
    $StmtVisitor();
    this./*&*/CGF=/*&*/cgf;
    this./*&*/Builder=/*&*/CGF.Builder;
    this.Dest = new AggValueSlot(Dest);
    this.IsResultUnused = IsResultUnused;
    //END JInit
  }

  
  //===--------------------------------------------------------------------===//
  //                               Utilities
  //===--------------------------------------------------------------------===//
  
  /// EmitAggLoadOfLValue - Given an expression with aggregate type that
  /// represents a value lvalue, this method emits the address of the lvalue,
  /// then loads the result into DestPtr.
  // end anonymous namespace.
  
  //===----------------------------------------------------------------------===//
  //                                Utilities
  //===----------------------------------------------------------------------===//
  
  /// EmitAggLoadOfLValue - Given an expression with aggregate type that
  /// represents a value lvalue, this method emits the address of the lvalue,
  /// then loads the result into DestPtr.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::EmitAggLoadOfLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 216,
   FQN="(anonymous namespace)::AggExprEmitter::EmitAggLoadOfLValue", NM="_ZN12_GLOBAL__N_114AggExprEmitter19EmitAggLoadOfLValueEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter19EmitAggLoadOfLValueEPKN5clang4ExprE")
  //</editor-fold>
  public void EmitAggLoadOfLValue(/*const*/ Expr /*P*/ E) {
    LValue LV = CGF.EmitLValue(E);
    
    // If the type of the l-value is atomic, then do an atomic load.
    if (LV.getType().$arrow().isAtomicType() || CGF.LValueIsSuitableForInlineAtomic(new LValue(LV))) {
      CGF.EmitAtomicLoad(new LValue(LV), E.getExprLoc(), new AggValueSlot(Dest));
      return;
    }
    
    EmitFinalDestCopy(E.getType(), LV);
  }

  
  /// EmitFinalDestCopy - Perform the final copy to DestPtr, if desired.
  
  /// EmitFinalDestCopy - Perform the final copy to DestPtr, if desired.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::EmitFinalDestCopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 276,
   FQN="(anonymous namespace)::AggExprEmitter::EmitFinalDestCopy", NM="_ZN12_GLOBAL__N_114AggExprEmitter17EmitFinalDestCopyEN5clang8QualTypeERKNS1_7CodeGen6LValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter17EmitFinalDestCopyEN5clang8QualTypeERKNS1_7CodeGen6LValueE")
  //</editor-fold>
  public void EmitFinalDestCopy(QualType type, final /*const*/ LValue /*&*/ src) {
    // If Dest is ignored, then we're evaluating an aggregate expression
    // in a context that doesn't care about the result.  Note that loads
    // from volatile l-values force the existence of a non-ignored
    // destination.
    if (Dest.isIgnored()) {
      return;
    }
    
    AggValueSlot srcAgg = AggValueSlot.forLValue(src, AggValueSlot.IsDestructed_t.IsDestructed, 
        needsGC(new QualType(type)), AggValueSlot.IsAliased_t.IsAliased);
    EmitCopy(new QualType(type), Dest, srcAgg);
  }

  
  /// EmitFinalDestCopy - Perform the final copy to DestPtr, if desired.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::EmitFinalDestCopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 269,
   FQN="(anonymous namespace)::AggExprEmitter::EmitFinalDestCopy", NM="_ZN12_GLOBAL__N_114AggExprEmitter17EmitFinalDestCopyEN5clang8QualTypeENS1_7CodeGen6RValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter17EmitFinalDestCopyEN5clang8QualTypeENS1_7CodeGen6RValueE")
  //</editor-fold>
  public void EmitFinalDestCopy(QualType type, RValue src) {
    assert (src.isAggregate()) : "value must be aggregate value!";
    LValue srcLV = CGF.MakeAddrLValue(src.getAggregateAddress(), new QualType(type));
    EmitFinalDestCopy(new QualType(type), srcLV);
  }

  
  /// Perform a copy from the source into the destination.
  ///
  /// \param type - the type of the aggregate being copied; qualifiers are
  ///   ignored
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::EmitCopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 294,
   FQN="(anonymous namespace)::AggExprEmitter::EmitCopy", NM="_ZN12_GLOBAL__N_114AggExprEmitter8EmitCopyEN5clang8QualTypeERKNS1_7CodeGen12AggValueSlotES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter8EmitCopyEN5clang8QualTypeERKNS1_7CodeGen12AggValueSlotES6_")
  //</editor-fold>
  public void EmitCopy(QualType type, final /*const*/ AggValueSlot /*&*/ dest, 
          final /*const*/ AggValueSlot /*&*/ src) {
    if ((dest.requiresGCollection().getValue() != 0)) {
      CharUnits sz = CGF.getContext().getTypeSizeInChars(/*NO_COPY*/type);
      Value /*P*/ size = ConstantInt.get(CGF.Unnamed_field8.SizeTy, sz.getQuantity());
      CGF.CGM.getObjCRuntime().EmitGCMemmoveCollectable(CGF, 
          dest.getAddress(), 
          src.getAddress(), 
          size);
      return;
    }
    
    // If the result of the assignment is used, copy the LHS there also.
    // It's volatile if either side is.  Use the minimum alignment of
    // the two sides.
    CGF.EmitAggregateCopy(dest.getAddress(), src.getAddress(), new QualType(type), 
        dest.isVolatile() || src.isVolatile());
  }

  
  
  /// \brief Perform the final move to DestPtr if for some reason
  /// getReturnValueSlot() didn't use it directly.
  ///
  /// The idea is that you do something like this:
  ///   RValue Result = EmitSomething(..., getReturnValueSlot());
  ///   EmitMoveFromReturnSlot(E, Result);
  ///
  /// If nothing interferes, this will cause the result to be emitted
  /// directly into the return value slot.  Otherwise, a final move
  /// will be performed.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::EmitMoveFromReturnSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 255,
   FQN="(anonymous namespace)::AggExprEmitter::EmitMoveFromReturnSlot", NM="_ZN12_GLOBAL__N_114AggExprEmitter22EmitMoveFromReturnSlotEPKN5clang4ExprENS1_7CodeGen6RValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter22EmitMoveFromReturnSlotEPKN5clang4ExprENS1_7CodeGen6RValueE")
  //</editor-fold>
  public void EmitMoveFromReturnSlot(/*const*/ Expr /*P*/ E, RValue src) {
    if (shouldUseDestForReturnSlot()) {
      // Logically, Dest.getAddr() should equal Src.getAggregateAddr().
      // The possibility of undef rvalues complicates that a lot,
      // though, so we can't really assert.
      return;
    }
    
    // Otherwise, copy from there to the destination.
    assert (Dest.getPointer() != src.getAggregatePointer());
    EmitFinalDestCopy(E.getType(), new RValue(src));
  }

  
  
  /// \brief Emit initialization of an array from an initializer list.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::EmitArrayInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 402,
   FQN="(anonymous namespace)::AggExprEmitter::EmitArrayInit", NM="_ZN12_GLOBAL__N_114AggExprEmitter13EmitArrayInitEN5clang7CodeGen7AddressEPN4llvm9ArrayTypeENS1_8QualTypeEPNS1_12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter13EmitArrayInitEN5clang7CodeGen7AddressEPN4llvm9ArrayTypeENS1_8QualTypeEPNS1_12InitListExprE")
  //</editor-fold>
  public void EmitArrayInit(Address DestPtr, org.llvm.ir.ArrayType /*P*/ AType, 
               QualType elementType, InitListExpr /*P*/ E) {
    long/*uint64_t*/ NumInitElements = $uint2ulong(E.getNumInits());
    
    long/*uint64_t*/ NumArrayElements = AType.getNumElements();
    assert ($lesseq_ulong(NumInitElements, NumArrayElements));
    
    // DestPtr is an array*.  Construct an elementType* by drilling
    // down a level.
    Value /*P*/ zero = ConstantInt.get(CGF.Unnamed_field8.SizeTy, $int2ulong(0));
    Value /*P*/ indices[/*2*/] = new Value /*P*/  [/*2*/] {zero, zero};
    Value /*P*/ begin = Builder.CreateInBoundsGEP(DestPtr.getPointer(), new ArrayRef<Value /*P*/ >(indices, true), new Twine(/*KEEP_STR*/"arrayinit.begin"));
    
    CharUnits elementSize = CGF.getContext().getTypeSizeInChars(/*NO_COPY*/elementType);
    CharUnits elementAlign = DestPtr.getAlignment().alignmentOfArrayElement(new CharUnits(elementSize));
    
    // Exception safety requires us to destroy all the
    // already-constructed members if an initializer throws.
    // For that, we'll need an EH cleanup.
    QualType.DestructionKind dtorKind = elementType.isDestructedType();
    Address endOfInit = Address.invalid();
    EHScopeStack.stable_iterator cleanup/*J*/= new EHScopeStack.stable_iterator();
    Instruction /*P*/ cleanupDominator = null;
    if (CGF.needsEHCleanup(dtorKind)) {
      // In principle we could tell the cleanup where we are more
      // directly, but the control flow can get so varied here that it
      // would actually be quite complex.  Therefore we go through an
      // alloca.
      endOfInit.$assignMove(CGF.CreateTempAlloca(begin.getType(), CGF.getPointerAlign(), 
              new Twine(/*KEEP_STR*/"arrayinit.endOfInit")));
      cleanupDominator = Builder.CreateStore(begin, new Address(endOfInit));
      CGF.pushIrregularPartialArrayCleanup(begin, new Address(endOfInit), new QualType(elementType), 
          new CharUnits(elementAlign), 
          CGF.getDestroyer(dtorKind));
      cleanup.$assignMove(CGF.EHStack.stable_begin());
      // Otherwise, remember that we didn't need a cleanup.
    } else {
      dtorKind = QualType.DestructionKind.DK_none;
    }
    
    Value /*P*/ one = ConstantInt.get(CGF.Unnamed_field8.SizeTy, $int2ulong(1));
    
    // The 'current element to initialize'.  The invariants on this
    // variable are complicated.  Essentially, after each iteration of
    // the loop, it points to the last initialized element, except
    // that it points to the beginning of the array before any
    // elements have been initialized.
    Value /*P*/ element = begin;
    
    // Emit the explicit initializers.
    for (long/*uint64_t*/ i = $int2ulong(0); i != NumInitElements; ++i) {
      // Advance to the next element.
      if ($greater_ulong_ullong(i, $int2ullong(0))) {
        element = Builder.CreateInBoundsGEP(element, new ArrayRef<Value /*P*/ >(one, true), new Twine(/*KEEP_STR*/"arrayinit.element"));
        
        // Tell the cleanup that it needs to destroy up to this
        // element.  TODO: some of these stores can be trivially
        // observed to be unnecessary.
        if (endOfInit.isValid()) {
          Builder.CreateStore(element, new Address(endOfInit));
        }
      }
      
      LValue elementLV = CGF.MakeAddrLValue(new Address(element, new CharUnits(elementAlign)), new QualType(elementType));
      EmitInitializationToLValue(E.getInit($ulong2uint(i)), new LValue(elementLV));
    }
    
    // Check whether there's a non-trivial array-fill expression.
    Expr /*P*/ filler = E.getArrayFiller();
    boolean hasTrivialFiller = isTrivialFiller(filler);
    
    // Any remaining elements need to be zero-initialized, possibly
    // using the filler expression.  We can skip this if the we're
    // emitting to zeroed memory.
    if (NumInitElements != NumArrayElements
       && !((Dest.isZeroed().getValue() != 0) && hasTrivialFiller
       && CGF.getTypes().isZeroInitializable(new QualType(elementType)))) {
      
      // Use an actual loop.  This is basically
      //   do { *array++ = filler; } while (array != end);
      
      // Advance to the start of the rest of the array.
      if ((NumInitElements != 0)) {
        element = Builder.CreateInBoundsGEP(element, new ArrayRef<Value /*P*/ >(one, true), new Twine(/*KEEP_STR*/"arrayinit.start"));
        if (endOfInit.isValid()) {
          Builder.CreateStore(element, new Address(endOfInit));
        }
      }
      
      // Compute the end of the array.
      Value /*P*/ end = Builder.CreateInBoundsGEP(begin, 
          new ArrayRef<Value /*P*/ >(ConstantInt.get(CGF.Unnamed_field8.SizeTy, NumArrayElements), true), 
          new Twine(/*KEEP_STR*/"arrayinit.end"));
      
      BasicBlock /*P*/ entryBB = Builder.GetInsertBlock();
      BasicBlock /*P*/ bodyBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"arrayinit.body"));
      
      // Jump into the body.
      CGF.EmitBlock(bodyBB);
      PHINode /*P*/ currentElement = Builder.CreatePHI(element.getType(), 2, new Twine(/*KEEP_STR*/"arrayinit.cur"));
      currentElement.addIncoming(element, entryBB);
      
      // Emit the actual filler expression.
      LValue elementLV = CGF.MakeAddrLValue(new Address(currentElement, new CharUnits(elementAlign)), new QualType(elementType));
      if ((filler != null)) {
        EmitInitializationToLValue(filler, new LValue(elementLV));
      } else {
        EmitNullInitializationToLValue(new LValue(elementLV));
      }
      
      // Move on to the next element.
      Value /*P*/ nextElement = Builder.CreateInBoundsGEP(currentElement, new ArrayRef<Value /*P*/ >(one, true), new Twine(/*KEEP_STR*/"arrayinit.next"));
      
      // Tell the EH cleanup that we finished with the last element.
      if (endOfInit.isValid()) {
        Builder.CreateStore(nextElement, new Address(endOfInit));
      }
      
      // Leave the loop if we're done.
      Value /*P*/ done = Builder.CreateICmpEQ(nextElement, end, 
          new Twine(/*KEEP_STR*/"arrayinit.done"));
      BasicBlock /*P*/ endBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"arrayinit.end"));
      Builder.CreateCondBr(done, endBB, bodyBB);
      currentElement.addIncoming(nextElement, Builder.GetInsertBlock());
      
      CGF.EmitBlock(endBB);
    }
    
    // Leave the partial-array cleanup if we entered one.
    if ((dtorKind.getValue() != 0)) {
      CGF.DeactivateCleanupBlock(new EHScopeStack.stable_iterator(cleanup), cleanupDominator);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::needsGC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 90,
   FQN="(anonymous namespace)::AggExprEmitter::needsGC", NM="_ZN12_GLOBAL__N_114AggExprEmitter7needsGCEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter7needsGCEN5clang8QualTypeE")
  //</editor-fold>
  public AggValueSlot.NeedsGCBarriers_t needsGC(QualType T) {
    if ((CGF.getLangOpts().getGC().getValue() != 0) && TypeRequiresGCollection(new QualType(T))) {
      return AggValueSlot.NeedsGCBarriers_t.NeedsGCBarriers;
    }
    return AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers;
  }

  
  
  /// \brief True if the given aggregate type requires special GC API calls.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::TypeRequiresGCollection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 229,
   FQN="(anonymous namespace)::AggExprEmitter::TypeRequiresGCollection", NM="_ZN12_GLOBAL__N_114AggExprEmitter23TypeRequiresGCollectionEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter23TypeRequiresGCollectionEN5clang8QualTypeE")
  //</editor-fold>
  public boolean TypeRequiresGCollection(QualType T) {
    // Only record types have members that might require garbage collection.
    /*const*/ RecordType /*P*/ RecordTy = T.$arrow().getAs$RecordType();
    if (!(RecordTy != null)) {
      return false;
    }
    
    // Don't mess with non-trivial C++ types.
    RecordDecl /*P*/ Record = RecordTy.getDecl();
    if (isa_CXXRecordDecl(Record)
       && (cast_CXXRecordDecl(Record).hasNonTrivialCopyConstructor()
       || !cast_CXXRecordDecl(Record).hasTrivialDestructor())) {
      return false;
    }
    
    // Check whether the type has an object member.
    return Record.hasObjectMember();
  }

  
  //===--------------------------------------------------------------------===//
  //                            Visitor Methods
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::Visit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 102,
   FQN="(anonymous namespace)::AggExprEmitter::Visit", NM="_ZN12_GLOBAL__N_114AggExprEmitter5VisitEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter5VisitEPN5clang4ExprE")
  //</editor-fold>
  public void Visit(Expr /*P*/ E) {
    ApplyDebugLocation DL = null;
    try {
      DL/*J*/= new ApplyDebugLocation(CGF, E);
      StmtVisitorVoid.super.Visit(E);
    } finally {
      if (DL != null) { DL.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 107,
   FQN="(anonymous namespace)::AggExprEmitter::VisitStmt", NM="_ZN12_GLOBAL__N_114AggExprEmitter9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public void VisitStmt(Stmt /*P*/ S) {
    CGF.ErrorUnsupported(S, $("aggregate expression"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitParenExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 110,
   FQN="(anonymous namespace)::AggExprEmitter::VisitParenExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter14VisitParenExprEPN5clang9ParenExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter14VisitParenExprEPN5clang9ParenExprE")
  //</editor-fold>
  public void VisitParenExpr(ParenExpr /*P*/ PE) {
    Visit(PE.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitGenericSelectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 111,
   FQN="(anonymous namespace)::AggExprEmitter::VisitGenericSelectionExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter25VisitGenericSelectionExprEPN5clang20GenericSelectionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter25VisitGenericSelectionExprEPN5clang20GenericSelectionExprE")
  //</editor-fold>
  public void VisitGenericSelectionExpr(GenericSelectionExpr /*P*/ GE) {
    Visit(GE.getResultExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitUnaryExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 114,
   FQN="(anonymous namespace)::AggExprEmitter::VisitUnaryExtension", NM="_ZN12_GLOBAL__N_114AggExprEmitter19VisitUnaryExtensionEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter19VisitUnaryExtensionEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryExtension(UnaryOperator /*P*/ E) {
    Visit(E.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitSubstNonTypeTemplateParmExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 115,
   FQN="(anonymous namespace)::AggExprEmitter::VisitSubstNonTypeTemplateParmExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter33VisitSubstNonTypeTemplateParmExprEPN5clang28SubstNonTypeTemplateParmExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter33VisitSubstNonTypeTemplateParmExprEPN5clang28SubstNonTypeTemplateParmExprE")
  //</editor-fold>
  public void VisitSubstNonTypeTemplateParmExpr(SubstNonTypeTemplateParmExpr /*P*/ E) {
    Visit(E.getReplacement());
    /*JAVA:return*/return;
  }

  
  // l-values.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 120,
   FQN="(anonymous namespace)::AggExprEmitter::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public void VisitDeclRefExpr(DeclRefExpr /*P*/ E) {
    // For aggregates, we should always be able to emit the variable
    // as an l-value unless it's a reference.  This is due to the fact
    // that we can't actually ever see a normal l2r conversion on an
    // aggregate in C++, and in C there's no language standard
    // actively preventing us from listing variables in the captures
    // list of a block.
    if (E.getDecl().getType().$arrow().isReferenceType()) {
      {
        CodeGenFunction.ConstantEmission result = CGF.tryEmitAsConstant(E);
        if (result.$bool()) {
          EmitFinalDestCopy(E.getType(), result.getReferenceLValue(CGF, E));
          return;
        }
      }
    }
    
    EmitAggLoadOfLValue(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 138,
   FQN="(anonymous namespace)::AggExprEmitter::VisitMemberExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter15VisitMemberExprEPN5clang10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter15VisitMemberExprEPN5clang10MemberExprE")
  //</editor-fold>
  public void VisitMemberExpr(MemberExpr /*P*/ ME) {
    EmitAggLoadOfLValue(ME);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitUnaryDeref">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 139,
   FQN="(anonymous namespace)::AggExprEmitter::VisitUnaryDeref", NM="_ZN12_GLOBAL__N_114AggExprEmitter15VisitUnaryDerefEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter15VisitUnaryDerefEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryDeref(UnaryOperator /*P*/ E) {
    EmitAggLoadOfLValue(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 140,
   FQN="(anonymous namespace)::AggExprEmitter::VisitStringLiteral", NM="_ZN12_GLOBAL__N_114AggExprEmitter18VisitStringLiteralEPN5clang13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter18VisitStringLiteralEPN5clang13StringLiteralE")
  //</editor-fold>
  public void VisitStringLiteral(StringLiteral /*P*/ E) {
    EmitAggLoadOfLValue(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitCompoundLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 546,
   FQN="(anonymous namespace)::AggExprEmitter::VisitCompoundLiteralExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter24VisitCompoundLiteralExprEPN5clang19CompoundLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter24VisitCompoundLiteralExprEPN5clang19CompoundLiteralExprE")
  //</editor-fold>
  public void VisitCompoundLiteralExpr(CompoundLiteralExpr /*P*/ E) {
    if ((Dest.isPotentiallyAliased().getValue() != 0)
       && E.getType().isPODType(CGF.getContext())) {
      // For a POD type, just emit a load of the lvalue + a copy, because our
      // compound literal might alias the destination.
      EmitAggLoadOfLValue(E);
      return;
    }
    
    AggValueSlot Slot = EnsureSlot(E.getType());
    CGF.EmitAggExpr(E.getInitializer(), new AggValueSlot(Slot));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitArraySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 142,
   FQN="(anonymous namespace)::AggExprEmitter::VisitArraySubscriptExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter23VisitArraySubscriptExprEPN5clang18ArraySubscriptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter23VisitArraySubscriptExprEPN5clang18ArraySubscriptExprE")
  //</editor-fold>
  public void VisitArraySubscriptExpr(ArraySubscriptExpr /*P*/ E) {
    EmitAggLoadOfLValue(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitPredefinedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 145,
   FQN="(anonymous namespace)::AggExprEmitter::VisitPredefinedExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter19VisitPredefinedExprEPKN5clang14PredefinedExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter19VisitPredefinedExprEPKN5clang14PredefinedExprE")
  //</editor-fold>
  public void VisitPredefinedExpr(/*const*/ PredefinedExpr /*P*/ E) {
    EmitAggLoadOfLValue(E);
  }

  
  // Operators.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 575,
   FQN="(anonymous namespace)::AggExprEmitter::VisitCastExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter13VisitCastExprEPN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter13VisitCastExprEPN5clang8CastExprE")
  //</editor-fold>
  public void VisitCastExpr(CastExpr /*P*/ E) {
    {
      /*const*/ ExplicitCastExpr /*P*/ ECE = dyn_cast_ExplicitCastExpr(E);
      if ((ECE != null)) {
        CGF.CGM.EmitExplicitCastExprType(ECE, /*AddrOf*/CGF);
      }
    }
    switch (E.getCastKind()) {
     case CK_Dynamic:
      {
        // FIXME: Can this actually happen? We have no test coverage for it.
        assert (isa_CXXDynamicCastExpr(E)) : "CK_Dynamic without a dynamic_cast?";
        LValue LV = CGF.EmitCheckedLValue(E.getSubExpr(), 
            CodeGenFunction.TypeCheckKind.TCK_Load);
        // FIXME: Do we also need to handle property references here?
        if (LV.isSimple()) {
          CGF.EmitDynamicCast(LV.getAddress(), cast_CXXDynamicCastExpr(E));
        } else {
          CGF.CGM.ErrorUnsupported(E, $("non-simple lvalue dynamic_cast"));
        }
        if (!Dest.isIgnored()) {
          CGF.CGM.ErrorUnsupported(E, $("lvalue dynamic_cast with a destination"));
        }
        break;
      }
     case CK_ToUnion:
      {
        // Evaluate even if the destination is ignored.
        if (Dest.isIgnored()) {
          CGF.EmitAnyExpr(E.getSubExpr(), AggValueSlot.ignored(), 
              /*ignoreResult=*/ true);
          break;
        }
        
        // GCC union extension
        QualType Ty = E.getSubExpr().getType();
        Address CastPtr = Builder.CreateElementBitCast(Dest.getAddress(), CGF.ConvertType(new QualType(Ty)));
        EmitInitializationToLValue(E.getSubExpr(), 
            CGF.MakeAddrLValue(new Address(CastPtr), new QualType(Ty)));
        break;
      }
     case CK_DerivedToBase:
     case CK_BaseToDerived:
     case CK_UncheckedDerivedToBase:
      {
        throw new llvm_unreachable("cannot perform hierarchy conversion in EmitAggExpr: should have been unpacked before we got here");
      }
     case CK_NonAtomicToAtomic:
     case CK_AtomicToNonAtomic:
      {
        boolean isToAtomic = (E.getCastKind() == CastKind.CK_NonAtomicToAtomic);
        
        // Determine the atomic and value types.
        QualType atomicType = E.getSubExpr().getType();
        QualType valueType = E.getType();
        if (isToAtomic) {
          //std.swap(atomicType, valueType);
          QualType tmp = valueType;
          valueType = atomicType;
          atomicType = tmp;
        }
        assert (atomicType.$arrow().isAtomicType());
        assert (CGF.getContext().hasSameUnqualifiedType(new QualType(valueType), atomicType.$arrow().castAs(AtomicType.class).getValueType()));
        
        // Just recurse normally if we're ignoring the result or the
        // atomic type doesn't change representation.
        if (Dest.isIgnored() || !CGF.CGM.isPaddedAtomicType(new QualType(atomicType))) {
          Visit(E.getSubExpr());
          /*JAVA:return*/return;
        }
        
        CastKind peepholeTarget = (isToAtomic ? CastKind.CK_AtomicToNonAtomic : CastKind.CK_NonAtomicToAtomic);
        {
          
          // These two cases are reverses of each other; try to peephole them.
          Expr /*P*/ op = findPeephole(E.getSubExpr(), peepholeTarget);
          if ((op != null)) {
            assert (CGF.getContext().hasSameUnqualifiedType(op.getType(), E.getType())) : "peephole significantly changed types?";
            Visit(op);
            /*JAVA:return*/return;
          }
        }
        
        // If we're converting an r-value of non-atomic type to an r-value
        // of atomic type, just emit directly into the relevant sub-object.
        if (isToAtomic) {
          AggValueSlot valueDest = new AggValueSlot(Dest);
          if (!valueDest.isIgnored() && CGF.CGM.isPaddedAtomicType(new QualType(atomicType))) {
            // Zero-initialize.  (Strictly speaking, we only need to intialize
            // the padding at the end, but this is simpler.)
            if (!(Dest.isZeroed().getValue() != 0)) {
              CGF.EmitNullInitialization(Dest.getAddress(), new QualType(atomicType));
            }
            
            // Build a GEP to refer to the subobject.
            Address valueAddr = CGF.Builder.CreateStructGEP(valueDest.getAddress(), 0, 
                new CharUnits());
            valueDest.$assignMove(AggValueSlot.forAddr(new Address(valueAddr), 
                    valueDest.getQualifiers(), 
                    valueDest.isExternallyDestructed(), 
                    valueDest.requiresGCollection(), 
                    valueDest.isPotentiallyAliased(), 
                    AggValueSlot.IsZeroed_t.IsZeroed));
          }
          
          CGF.EmitAggExpr(E.getSubExpr(), new AggValueSlot(valueDest));
          return;
        }
        
        // Otherwise, we're converting an atomic type to a non-atomic type.
        // Make an atomic temporary, emit into that, and then copy the value out.
        AggValueSlot atomicSlot = CGF.CreateAggTemp(new QualType(atomicType), new Twine(/*KEEP_STR*/"atomic-to-nonatomic.temp"));
        CGF.EmitAggExpr(E.getSubExpr(), new AggValueSlot(atomicSlot));
        
        Address valueAddr = Builder.CreateStructGEP(atomicSlot.getAddress(), 0, new CharUnits());
        RValue rvalue = RValue.getAggregate(new Address(valueAddr), atomicSlot.isVolatile());
        EmitFinalDestCopy(new QualType(valueType), new RValue(rvalue));
        /*JAVA:return*/return;
      }
     case CK_LValueToRValue:
      // If we're loading from a volatile type, force the destination
      // into existence.
      if (E.getSubExpr().getType().isVolatileQualified()) {
        EnsureDest(E.getType());
        Visit(E.getSubExpr());
        /*JAVA:return*/return;
      }
     case CK_NoOp:
     case CK_UserDefinedConversion:
     case CK_ConstructorConversion:
      
      // fallthrough
      assert (CGF.getContext().hasSameUnqualifiedType(E.getSubExpr().getType(), E.getType())) : "Implicit cast types must be compatible";
      Visit(E.getSubExpr());
      break;
     case CK_LValueBitCast:
      throw new llvm_unreachable("should not be emitting lvalue bitcast as rvalue");
     case CK_Dependent:
     case CK_BitCast:
     case CK_ArrayToPointerDecay:
     case CK_FunctionToPointerDecay:
     case CK_NullToPointer:
     case CK_NullToMemberPointer:
     case CK_BaseToDerivedMemberPointer:
     case CK_DerivedToBaseMemberPointer:
     case CK_MemberPointerToBoolean:
     case CK_ReinterpretMemberPointer:
     case CK_IntegralToPointer:
     case CK_PointerToIntegral:
     case CK_PointerToBoolean:
     case CK_ToVoid:
     case CK_VectorSplat:
     case CK_IntegralCast:
     case CK_BooleanToSignedIntegral:
     case CK_IntegralToBoolean:
     case CK_IntegralToFloating:
     case CK_FloatingToIntegral:
     case CK_FloatingToBoolean:
     case CK_FloatingCast:
     case CK_CPointerToObjCPointerCast:
     case CK_BlockPointerToObjCPointerCast:
     case CK_AnyPointerToBlockPointerCast:
     case CK_ObjCObjectLValueCast:
     case CK_FloatingRealToComplex:
     case CK_FloatingComplexToReal:
     case CK_FloatingComplexToBoolean:
     case CK_FloatingComplexCast:
     case CK_FloatingComplexToIntegralComplex:
     case CK_IntegralRealToComplex:
     case CK_IntegralComplexToReal:
     case CK_IntegralComplexToBoolean:
     case CK_IntegralComplexCast:
     case CK_IntegralComplexToFloatingComplex:
     case CK_ARCProduceObject:
     case CK_ARCConsumeObject:
     case CK_ARCReclaimReturnedObject:
     case CK_ARCExtendBlockObject:
     case CK_CopyAndAutoreleaseBlockObject:
     case CK_BuiltinFnToFnPtr:
     case CK_ZeroToOCLEvent:
     case CK_AddressSpaceConversion:
      throw new llvm_unreachable("cast kind invalid for aggregate types");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 757,
   FQN="(anonymous namespace)::AggExprEmitter::VisitCallExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter13VisitCallExprEPKN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter13VisitCallExprEPKN5clang8CallExprE")
  //</editor-fold>
  public void VisitCallExpr(/*const*/ CallExpr /*P*/ E) {
    if (E.getCallReturnType(CGF.getContext()).$arrow().isReferenceType()) {
      EmitAggLoadOfLValue(E);
      return;
    }
    
    RValue RV = CGF.EmitCallExpr(E, getReturnValueSlot());
    EmitMoveFromReturnSlot(E, new RValue(RV));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitStmtExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 777,
   FQN="(anonymous namespace)::AggExprEmitter::VisitStmtExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter13VisitStmtExprEPKN5clang8StmtExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter13VisitStmtExprEPKN5clang8StmtExprE")
  //</editor-fold>
  public void VisitStmtExpr(/*const*/ StmtExpr /*P*/ E) {
    CodeGenFunction.StmtExprEvaluation eval = null;
    try {
      eval/*J*/= new CodeGenFunction.StmtExprEvaluation(CGF);
      CGF.EmitCompoundStmt(/*Deref*/E.getSubStmt$Const(), true, new AggValueSlot(Dest));
    } finally {
      if (eval != null) { eval.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 782,
   FQN="(anonymous namespace)::AggExprEmitter::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_114AggExprEmitter19VisitBinaryOperatorEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter19VisitBinaryOperatorEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinaryOperator(/*const*/ org.clang.ast.BinaryOperator /*P*/ E) {
    if (E.getOpcode() == BinaryOperatorKind.BO_PtrMemD || E.getOpcode() == BinaryOperatorKind.BO_PtrMemI) {
      VisitPointerToDataMemberBinaryOperator(E);
    } else {
      CGF.ErrorUnsupported(E, $("aggregate binary expression"));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitPointerToDataMemberBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 789,
   FQN="(anonymous namespace)::AggExprEmitter::VisitPointerToDataMemberBinaryOperator", NM="_ZN12_GLOBAL__N_114AggExprEmitter38VisitPointerToDataMemberBinaryOperatorEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter38VisitPointerToDataMemberBinaryOperatorEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitPointerToDataMemberBinaryOperator(/*const*/ org.clang.ast.BinaryOperator /*P*/ E) {
    LValue LV = CGF.EmitPointerToDataMemberBinaryExpr(E);
    EmitFinalDestCopy(E.getType(), LV);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitBinAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 861,
   FQN="(anonymous namespace)::AggExprEmitter::VisitBinAssign", NM="_ZN12_GLOBAL__N_114AggExprEmitter14VisitBinAssignEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter14VisitBinAssignEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinAssign(/*const*/ org.clang.ast.BinaryOperator /*P*/ E) {
    // For an assignment to work, the value on the right has
    // to be compatible with the value on the left.
    assert (CGF.getContext().hasSameUnqualifiedType(E.getLHS().getType(), E.getRHS().getType())) : "Invalid assignment";
    
    // If the LHS might be a __block variable, and the RHS can
    // potentially cause a block copy, we need to evaluate the RHS first
    // so that the assignment goes the right place.
    // This is pretty semantically fragile.
    if (isBlockVarRef(E.getLHS())
       && E.getRHS().HasSideEffects(CGF.getContext())) {
      // Ensure that we have a destination, and evaluate the RHS into that.
      EnsureDest(E.getRHS().getType());
      Visit(E.getRHS());
      
      // Now emit the LHS and copy into it.
      LValue LHS = CGF.EmitCheckedLValue(E.getLHS(), CodeGenFunction.TypeCheckKind.TCK_Store);
      
      // That copy is an atomic copy if the LHS is atomic.
      if (LHS.getType().$arrow().isAtomicType()
         || CGF.LValueIsSuitableForInlineAtomic(new LValue(LHS))) {
        CGF.EmitAtomicStore(Dest.asRValue(), new LValue(LHS), /*isInit*/ false);
        return;
      }
      
      EmitCopy(E.getLHS().getType(), 
          AggValueSlot.forLValue(LHS, AggValueSlot.IsDestructed_t.IsDestructed, 
              needsGC(E.getLHS().getType()), 
              AggValueSlot.IsAliased_t.IsAliased), 
          Dest);
      return;
    }
    
    LValue LHS = CGF.EmitLValue(E.getLHS());
    
    // If we have an atomic type, evaluate into the destination and then
    // do an atomic copy.
    if (LHS.getType().$arrow().isAtomicType()
       || CGF.LValueIsSuitableForInlineAtomic(new LValue(LHS))) {
      EnsureDest(E.getRHS().getType());
      Visit(E.getRHS());
      CGF.EmitAtomicStore(Dest.asRValue(), new LValue(LHS), /*isInit*/ false);
      return;
    }
    
    // Codegen the RHS so that it stores directly into the LHS.
    AggValueSlot LHSSlot = AggValueSlot.forLValue(LHS, AggValueSlot.IsDestructed_t.IsDestructed, 
        needsGC(E.getLHS().getType()), 
        AggValueSlot.IsAliased_t.IsAliased);
    // A non-volatile aggregate destination might have volatile member.
    if (!LHSSlot.isVolatile()
       && CGF.hasVolatileMember(E.getLHS().getType())) {
      LHSSlot.setVolatile(true);
    }
    
    CGF.EmitAggExpr(E.getRHS(), new AggValueSlot(LHSSlot));
    
    // Copy into the destination if the assignment isn't ignored.
    EmitFinalDestCopy(E.getType(), LHS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitBinComma">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 772,
   FQN="(anonymous namespace)::AggExprEmitter::VisitBinComma", NM="_ZN12_GLOBAL__N_114AggExprEmitter13VisitBinCommaEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter13VisitBinCommaEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinComma(/*const*/ org.clang.ast.BinaryOperator /*P*/ E) {
    CGF.EmitIgnoredExpr(E.getLHS());
    Visit(E.getRHS());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitObjCMessageExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 767,
   FQN="(anonymous namespace)::AggExprEmitter::VisitObjCMessageExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter20VisitObjCMessageExprEPN5clang15ObjCMessageExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter20VisitObjCMessageExprEPN5clang15ObjCMessageExprE")
  //</editor-fold>
  public void VisitObjCMessageExpr(ObjCMessageExpr /*P*/ E) {
    RValue RV = CGF.EmitObjCMessageExpr(E, getReturnValueSlot());
    EmitMoveFromReturnSlot(E, new RValue(RV));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitObjCIvarRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 159,
   FQN="(anonymous namespace)::AggExprEmitter::VisitObjCIvarRefExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter20VisitObjCIvarRefExprEPN5clang15ObjCIvarRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter20VisitObjCIvarRefExprEPN5clang15ObjCIvarRefExprE")
  //</editor-fold>
  public void VisitObjCIvarRefExpr(ObjCIvarRefExpr /*P*/ E) {
    EmitAggLoadOfLValue(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitDesignatedInitUpdateExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 1319,
   FQN="(anonymous namespace)::AggExprEmitter::VisitDesignatedInitUpdateExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter29VisitDesignatedInitUpdateExprEPN5clang24DesignatedInitUpdateExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter29VisitDesignatedInitUpdateExprEPN5clang24DesignatedInitUpdateExprE")
  //</editor-fold>
  public void VisitDesignatedInitUpdateExpr(DesignatedInitUpdateExpr /*P*/ E) {
    AggValueSlot Dest = EnsureSlot(E.getType());
    
    LValue DestLV = CGF.MakeAddrLValue(Dest.getAddress(), E.getType());
    EmitInitializationToLValue(E.getBase(), new LValue(DestLV));
    VisitInitListExpr(E.getUpdater());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitAbstractConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 924,
   FQN="(anonymous namespace)::AggExprEmitter::VisitAbstractConditionalOperator", NM="_ZN12_GLOBAL__N_114AggExprEmitter32VisitAbstractConditionalOperatorEPKN5clang27AbstractConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter32VisitAbstractConditionalOperatorEPKN5clang27AbstractConditionalOperatorE")
  //</editor-fold>
  public void VisitAbstractConditionalOperator(/*const*/ AbstractConditionalOperator /*P*/ E) {
    CodeGenFunction.OpaqueValueMapping binding = null;
    try {
      BasicBlock /*P*/ LHSBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"cond.true"));
      BasicBlock /*P*/ RHSBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"cond.false"));
      BasicBlock /*P*/ ContBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"cond.end"));
      
      // Bind the common expression if necessary.
      binding/*J*/= new CodeGenFunction.OpaqueValueMapping(CGF, E);
      
      CodeGenFunction.ConditionalEvaluation eval/*J*/= new CodeGenFunction.ConditionalEvaluation(CGF);
      CGF.EmitBranchOnBoolExpr(E.getCond(), LHSBlock, RHSBlock, 
          CGF.getProfileCount(E));
      
      // Save whether the destination's lifetime is externally managed.
      boolean isExternallyDestructed = (Dest.isExternallyDestructed().getValue() != 0);
      
      eval.begin(CGF);
      CGF.EmitBlock(LHSBlock);
      CGF.incrementProfileCounter(E);
      Visit(E.getTrueExpr());
      eval.end(CGF);
      assert (CGF.HaveInsertPoint()) : "expression evaluation ended with no IP!";
      CGF.Builder.CreateBr(ContBlock);
      
      // If the result of an agg expression is unused, then the emission
      // of the LHS might need to create a destination slot.  That's fine
      // with us, and we can safely emit the RHS into the same slot, but
      // we shouldn't claim that it's already being destructed.
      Dest.setExternallyDestructed(isExternallyDestructed);
      
      eval.begin(CGF);
      CGF.EmitBlock(RHSBlock);
      Visit(E.getFalseExpr());
      eval.end(CGF);
      
      CGF.EmitBlock(ContBlock);
    } finally {
      if (binding != null) { binding.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitChooseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 963,
   FQN="(anonymous namespace)::AggExprEmitter::VisitChooseExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter15VisitChooseExprEPKN5clang10ChooseExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter15VisitChooseExprEPKN5clang10ChooseExprE")
  //</editor-fold>
  public void VisitChooseExpr(/*const*/ ChooseExpr /*P*/ CE) {
    Visit(CE.getChosenSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitInitListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 1129,
   FQN="(anonymous namespace)::AggExprEmitter::VisitInitListExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter17VisitInitListExprEPN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter17VisitInitListExprEPN5clang12InitListExprE")
  //</editor-fold>
  public void VisitInitListExpr(InitListExpr /*P*/ E) {
    CodeGenFunction.FieldConstructionScope FCS = null;
    try {
      if (E.hadArrayRangeDesignator()) {
        CGF.ErrorUnsupported(E, $("GNU array range designator extension"));
      }
      
      AggValueSlot Dest = EnsureSlot(E.getType());
      
      LValue DestLV = CGF.MakeAddrLValue(Dest.getAddress(), E.getType());
      
      // Handle initialization of an array.
      if (E.getType().$arrow().isArrayType()) {
        if (E.isStringLiteralInit()) {
          Visit(E.getInit(0));
          /*JAVA:return*/return;
        }
        
        QualType elementType = CGF.getContext().getAsArrayType(E.getType()).getElementType();
        
        org.llvm.ir.ArrayType /*P*/ AType = cast_ArrayType(Dest.getAddress().getElementType());
        EmitArrayInit(Dest.getAddress(), AType, new QualType(elementType), E);
        return;
      }
      if (E.getType().$arrow().isAtomicType()) {
        // An _Atomic(T) object can be list-initialized from an expression
        // of the same type.
        assert (E.getNumInits() == 1 && CGF.getContext().hasSameUnqualifiedType(E.getInit(0).getType(), E.getType())) : "unexpected list initialization for atomic object";
        Visit(E.getInit(0));
        /*JAVA:return*/return;
      }
      assert (E.getType().$arrow().isRecordType()) : "Only support structs/unions here!";
      
      // Do struct initialization; this code just sets each individual member
      // to the approprate value.  This makes bitfield support automatic;
      // the disadvantage is that the generated code is more difficult for
      // the optimizer, especially with bitfields.
      /*uint*/int NumInitElements = E.getNumInits();
      RecordDecl /*P*/ record = E.getType().$arrow().castAs$RecordType().getDecl();
      
      // We'll need to enter cleanup scopes in case any of the element
      // initializers throws an exception.
      SmallVector<EHScopeStack.stable_iterator> cleanups/*J*/= new SmallVector<EHScopeStack.stable_iterator>(16, new EHScopeStack.stable_iterator());
      Instruction /*P*/ cleanupDominator = null;
      
      /*uint*/int curInitIndex = 0;
      {
        
        // Emit initialization of base classes.
        CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(record);
        if ((CXXRD != null)) {
          assert ($greatereq_uint(E.getNumInits(), CXXRD.getNumBases())) : "missing initializer for base class";
          for (final CXXBaseSpecifier /*&*/ Base : CXXRD.bases()) {
            assert (!Base.isVirtual()) : "should not see vbases here";
            CXXRecordDecl /*P*/ BaseRD = Base.getType().$arrow().getAsCXXRecordDecl();
            Address V = CGF.GetAddressOfDirectBaseInCompleteClass(Dest.getAddress(), CXXRD, BaseRD, 
                /*isBaseVirtual*/ false);
            AggValueSlot AggSlot = AggValueSlot.forAddr(new Address(V), new Qualifiers(), 
                AggValueSlot.IsDestructed_t.IsDestructed, 
                AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers, 
                AggValueSlot.IsAliased_t.IsNotAliased);
            CGF.EmitAggExpr(E.getInit(curInitIndex++), new AggValueSlot(AggSlot));
            {
              
              QualType.DestructionKind dtorKind = Base.getType().isDestructedType();
              if ((dtorKind.getValue() != 0)) {
                CGF.pushDestroy(dtorKind, new Address(V), Base.getType());
                cleanups.push_back(CGF.EHStack.stable_begin());
              }
            }
          }
        }
      }
      
      // Prepare a 'this' for CXXDefaultInitExprs.
      FCS/*J*/= new CodeGenFunction.FieldConstructionScope(CGF, Dest.getAddress());
      if (record.isUnion()) {
        // Only initialize one field of a union. The field itself is
        // specified by the initializer list.
        if (!(E.getInitializedFieldInUnion() != null)) {
          // Make sure that it's really an empty and not a failure of
          // semantic analysis.
          for (/*const*/ FieldDecl /*P*/ Field : record.fields())  {
            assert (Field.isUnnamedBitfield()) : "Only unnamed bitfields allowed";
          }
          return;
        }
        
        // FIXME: volatility
        FieldDecl /*P*/ Field = E.getInitializedFieldInUnion();
        
        LValue FieldLoc = CGF.EmitLValueForFieldInitialization(new LValue(DestLV), Field);
        if ((NumInitElements != 0)) {
          // Store the initializer into the field
          EmitInitializationToLValue(E.getInit(0), new LValue(FieldLoc));
        } else {
          // Default-initialize to null.
          EmitNullInitializationToLValue(new LValue(FieldLoc));
        }
        
        return;
      }
      
      // Here we iterate over the fields; this makes it simpler to both
      // default-initialize fields and skip over unnamed fields.
      for (/*const*/ FieldDecl /*P*/ field : record.fields()) {
        // We're done once we hit the flexible array member.
        if (field.getType().$arrow().isIncompleteArrayType()) {
          break;
        }
        
        // Always skip anonymous bitfields.
        if (field.isUnnamedBitfield()) {
          continue;
        }
        
        // We're done if we reach the end of the explicit initializers, we
        // have a zeroed object, and the rest of the fields are
        // zero-initializable.
        if (curInitIndex == NumInitElements && (Dest.isZeroed().getValue() != 0)
           && CGF.getTypes().isZeroInitializable(E.getType())) {
          break;
        }
        
        LValue LV = CGF.EmitLValueForFieldInitialization(new LValue(DestLV), field);
        // We never generate write-barries for initialized fields.
        LV.setNonGC(true);
        if ($less_uint(curInitIndex, NumInitElements)) {
          // Store the initializer into the field.
          EmitInitializationToLValue(E.getInit(curInitIndex++), new LValue(LV));
        } else {
          // We're out of initalizers; default-initialize to null
          EmitNullInitializationToLValue(new LValue(LV));
        }
        
        // Push a destructor if necessary.
        // FIXME: if we have an array of structures, all explicitly
        // initialized, we can end up pushing a linear number of cleanups.
        boolean pushedCleanup = false;
        {
          QualType.DestructionKind dtorKind = field.getType().isDestructedType();
          if ((dtorKind.getValue() != 0)) {
            assert (LV.isSimple());
            if (CGF.needsEHCleanup(dtorKind)) {
              if (!(cleanupDominator != null)) {
                cleanupDominator = CGF.Builder.CreateAlignedLoad(CGF.Int8Ty, 
                    Constant.getNullValue(CGF.Unnamed_field9.Int8PtrTy), 
                    CharUnits.One()); // placeholder
              }
              
              CGF.pushDestroy(CleanupKind.EHCleanup, LV.getAddress(), field.getType(), 
                  CGF.getDestroyer(dtorKind), false);
              cleanups.push_back(CGF.EHStack.stable_begin());
              pushedCleanup = true;
            }
          }
        }
        
        // If the GEP didn't get used because of a dead zero init or something
        // else, clean it up for -O0 builds and general tidiness.
        if (!pushedCleanup && LV.isSimple()) {
          {
            GetElementPtrInst /*P*/ GEP = dyn_cast_GetElementPtrInst(LV.getPointer());
            if ((GEP != null)) {
              if (GEP.use_empty()) {
                GEP.eraseFromParent();
              }
            }
          }
        }
      }
      
      // Deactivate all the partial cleanups in reverse order, which
      // generally means popping them.
      for (/*uint*/int i = cleanups.size(); i != 0; --i)  {
        CGF.DeactivateCleanupBlock(new EHScopeStack.stable_iterator(cleanups.$at(i - 1)), cleanupDominator);
      }
      
      // Destroy the placeholder if we made one.
      if ((cleanupDominator != null)) {
        cleanupDominator.eraseFromParent();
      }
    } finally {
      if (FCS != null) { FCS.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitImplicitValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 1028,
   FQN="(anonymous namespace)::AggExprEmitter::VisitImplicitValueInitExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter26VisitImplicitValueInitExprEPN5clang21ImplicitValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter26VisitImplicitValueInitExprEPN5clang21ImplicitValueInitExprE")
  //</editor-fold>
  public void VisitImplicitValueInitExpr(ImplicitValueInitExpr /*P*/ E) {
    QualType T = E.getType();
    AggValueSlot Slot = EnsureSlot(new QualType(T));
    EmitNullInitializationToLValue(CGF.MakeAddrLValue(Slot.getAddress(), new QualType(T)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitNoInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 168,
   FQN="(anonymous namespace)::AggExprEmitter::VisitNoInitExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter15VisitNoInitExprEPN5clang10NoInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter15VisitNoInitExprEPN5clang10NoInitExprE")
  //</editor-fold>
  public void VisitNoInitExpr(NoInitExpr /*P*/ E) {
  } // Do nothing.

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitCXXDefaultArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 169,
   FQN="(anonymous namespace)::AggExprEmitter::VisitCXXDefaultArgExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter22VisitCXXDefaultArgExprEPN5clang17CXXDefaultArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter22VisitCXXDefaultArgExprEPN5clang17CXXDefaultArgExprE")
  //</editor-fold>
  public void VisitCXXDefaultArgExpr(CXXDefaultArgExpr /*P*/ DAE) {
    Visit(DAE.getExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitCXXDefaultInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 172,
   FQN="(anonymous namespace)::AggExprEmitter::VisitCXXDefaultInitExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter23VisitCXXDefaultInitExprEPN5clang18CXXDefaultInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter23VisitCXXDefaultInitExprEPN5clang18CXXDefaultInitExprE")
  //</editor-fold>
  public void VisitCXXDefaultInitExpr(CXXDefaultInitExpr /*P*/ DIE) {
    CodeGenFunction.CXXDefaultInitExprScope Scope = null;
    try {
      Scope/*J*/= new CodeGenFunction.CXXDefaultInitExprScope(CGF);
      Visit(DIE.getExpr());
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitCXXBindTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 980,
   FQN="(anonymous namespace)::AggExprEmitter::VisitCXXBindTemporaryExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter25VisitCXXBindTemporaryExprEPN5clang20CXXBindTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter25VisitCXXBindTemporaryExprEPN5clang20CXXBindTemporaryExprE")
  //</editor-fold>
  public void VisitCXXBindTemporaryExpr(CXXBindTemporaryExpr /*P*/ E) {
    // Ensure that we have a slot, but if we already do, remember
    // whether it was externally destructed.
    boolean wasExternallyDestructed = (Dest.isExternallyDestructed().getValue() != 0);
    EnsureDest(E.getType());
    
    // We're going to push a destructor if there isn't already one.
    Dest.setExternallyDestructed();
    
    Visit(E.getSubExpr());
    
    // Push that destructor we promised.
    if (!wasExternallyDestructed) {
      CGF.EmitCXXTemporary(E.getTemporary(), E.getType(), Dest.getAddress());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 996,
   FQN="(anonymous namespace)::AggExprEmitter::VisitCXXConstructExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter21VisitCXXConstructExprEPKN5clang16CXXConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter21VisitCXXConstructExprEPKN5clang16CXXConstructExprE")
  //</editor-fold>
  public void VisitCXXConstructExpr(/*const*/ CXXConstructExpr /*P*/ E) {
    AggValueSlot Slot = EnsureSlot(E.getType());
    CGF.EmitCXXConstructExpr(E, new AggValueSlot(Slot));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitCXXInheritedCtorInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 1002,
   FQN="(anonymous namespace)::AggExprEmitter::VisitCXXInheritedCtorInitExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter29VisitCXXInheritedCtorInitExprEPKN5clang24CXXInheritedCtorInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter29VisitCXXInheritedCtorInitExprEPKN5clang24CXXInheritedCtorInitExprE")
  //</editor-fold>
  public void VisitCXXInheritedCtorInitExpr(/*const*/ CXXInheritedCtorInitExpr /*P*/ E) {
    AggValueSlot Slot = EnsureSlot(E.getType());
    CGF.EmitInheritedCXXConstructorCall(E.getConstructor(), E.constructsVBase(), Slot.getAddress(), 
        E.inheritedFromVBase(), E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitLambdaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 1010,
   FQN="(anonymous namespace)::AggExprEmitter::VisitLambdaExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter15VisitLambdaExprEPN5clang10LambdaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter15VisitLambdaExprEPN5clang10LambdaExprE")
  //</editor-fold>
  public void VisitLambdaExpr(LambdaExpr /*P*/ E) {
    AggValueSlot Slot = EnsureSlot(E.getType());
    CGF.EmitLambdaExpr(E, new AggValueSlot(Slot));
  }

  
  /// \brief Emit the initializer for a std::initializer_list initialized with a
  /// real initializer list.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitCXXStdInitializerListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 315,
   FQN="(anonymous namespace)::AggExprEmitter::VisitCXXStdInitializerListExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter30VisitCXXStdInitializerListExprEPN5clang25CXXStdInitializerListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter30VisitCXXStdInitializerListExprEPN5clang25CXXStdInitializerListExprE")
  //</editor-fold>
  public void VisitCXXStdInitializerListExpr(CXXStdInitializerListExpr /*P*/ E) {
    // Emit an array containing the elements.  The array is externally destructed
    // if the std::initializer_list object is.
    final ASTContext /*&*/ Ctx = CGF.getContext();
    LValue Array = CGF.EmitLValue(E.getSubExpr());
    assert (Array.isSimple()) : "initializer_list array not a simple lvalue";
    Address ArrayPtr = Array.getAddress();
    
    /*const*/ ConstantArrayType /*P*/ ArrayType = Ctx.getAsConstantArrayType(E.getSubExpr().getType());
    assert ((ArrayType != null)) : "std::initializer_list constructed from non-array";
    
    // FIXME: Perform the checks on the field types in SemaInit.
    RecordDecl /*P*/ Record = E.getType().$arrow().castAs$RecordType().getDecl();
    specific_decl_iterator<FieldDecl> Field = Record.field_begin();
    if (specific_decl_iterator.$eq_specific_decl_iterator$SpecificDecl$C(Field, Record.field_end())) {
      CGF.ErrorUnsupported(E, $("weird std::initializer_list"));
      return;
    }
    
    // Start pointer.
    if (!Field.$arrow().getType().$arrow().isPointerType()
       || !Ctx.hasSameType(Field.$arrow().getType().$arrow().getPointeeType(), 
        ArrayType.getElementType())) {
      CGF.ErrorUnsupported(E, $("weird std::initializer_list"));
      return;
    }
    
    AggValueSlot Dest = EnsureSlot(E.getType());
    LValue DestLV = CGF.MakeAddrLValue(Dest.getAddress(), E.getType());
    LValue Start = CGF.EmitLValueForFieldInitialization(new LValue(DestLV), Field.$star());
    Value /*P*/ Zero = ConstantInt.get(CGF.Unnamed_field8.PtrDiffTy, $int2ulong(0));
    Value /*P*/ IdxStart[/*2*/] = new Value /*P*/  [/*2*/] {Zero, Zero};
    Value /*P*/ ArrayStart = Builder.CreateInBoundsGEP(ArrayPtr.getPointer(), new ArrayRef<Value /*P*/ >(IdxStart, true), new Twine(/*KEEP_STR*/"arraystart"));
    CGF.EmitStoreThroughLValue(RValue.get(ArrayStart), new LValue(Start));
    Field.$preInc();
    if (specific_decl_iterator.$eq_specific_decl_iterator$SpecificDecl$C(Field, Record.field_end())) {
      CGF.ErrorUnsupported(E, $("weird std::initializer_list"));
      return;
    }
    
    Value /*P*/ Size = Builder.getInt(ArrayType.getSize());
    LValue EndOrLength = CGF.EmitLValueForFieldInitialization(new LValue(DestLV), Field.$star());
    if (Field.$arrow().getType().$arrow().isPointerType()
       && Ctx.hasSameType(Field.$arrow().getType().$arrow().getPointeeType(), 
        ArrayType.getElementType())) {
      // End pointer.
      Value /*P*/ IdxEnd[/*2*/] = new Value /*P*/  [/*2*/] {Zero, Size};
      Value /*P*/ ArrayEnd = Builder.CreateInBoundsGEP(ArrayPtr.getPointer(), new ArrayRef<Value /*P*/ >(IdxEnd, true), new Twine(/*KEEP_STR*/"arrayend"));
      CGF.EmitStoreThroughLValue(RValue.get(ArrayEnd), new LValue(EndOrLength));
    } else if (Ctx.hasSameType(Field.$arrow().getType(), Ctx.getSizeType().$QualType())) {
      // Length.
      CGF.EmitStoreThroughLValue(RValue.get(Size), new LValue(EndOrLength));
    } else {
      CGF.ErrorUnsupported(E, $("weird std::initializer_list"));
      return;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitExprWithCleanups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 1016,
   FQN="(anonymous namespace)::AggExprEmitter::VisitExprWithCleanups", NM="_ZN12_GLOBAL__N_114AggExprEmitter21VisitExprWithCleanupsEPN5clang16ExprWithCleanupsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter21VisitExprWithCleanupsEPN5clang16ExprWithCleanupsE")
  //</editor-fold>
  public void VisitExprWithCleanups(ExprWithCleanups /*P*/ E) {
    CodeGenFunction.RunCleanupsScope cleanups = null;
    try {
      CGF.enterFullExpression(E);
      cleanups/*J*/= new CodeGenFunction.RunCleanupsScope(CGF);
      Visit(E.getSubExpr());
    } finally {
      if (cleanups != null) { cleanups.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitCXXScalarValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 1022,
   FQN="(anonymous namespace)::AggExprEmitter::VisitCXXScalarValueInitExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter27VisitCXXScalarValueInitExprEPN5clang22CXXScalarValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter27VisitCXXScalarValueInitExprEPN5clang22CXXScalarValueInitExprE")
  //</editor-fold>
  public void VisitCXXScalarValueInitExpr(CXXScalarValueInitExpr /*P*/ E) {
    QualType T = E.getType();
    AggValueSlot Slot = EnsureSlot(new QualType(T));
    EmitNullInitializationToLValue(CGF.MakeAddrLValue(Slot.getAddress(), new QualType(T)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitCXXTypeidExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 183,
   FQN="(anonymous namespace)::AggExprEmitter::VisitCXXTypeidExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter18VisitCXXTypeidExprEPN5clang13CXXTypeidExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter18VisitCXXTypeidExprEPN5clang13CXXTypeidExprE")
  //</editor-fold>
  public void VisitCXXTypeidExpr(CXXTypeidExpr /*P*/ E) {
    EmitAggLoadOfLValue(E);
  }

  
  //===----------------------------------------------------------------------===//
  //                            Visitor Methods
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitMaterializeTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 538,
   FQN="(anonymous namespace)::AggExprEmitter::VisitMaterializeTemporaryExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter29VisitMaterializeTemporaryExprEPN5clang24MaterializeTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter29VisitMaterializeTemporaryExprEPN5clang24MaterializeTemporaryExprE")
  //</editor-fold>
  public void VisitMaterializeTemporaryExpr(MaterializeTemporaryExpr /*P*/ E) {
    Visit(E.GetTemporaryExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitOpaqueValueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 542,
   FQN="(anonymous namespace)::AggExprEmitter::VisitOpaqueValueExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter20VisitOpaqueValueExprEPN5clang15OpaqueValueExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter20VisitOpaqueValueExprEPN5clang15OpaqueValueExprE")
  //</editor-fold>
  public void VisitOpaqueValueExpr(OpaqueValueExpr /*P*/ e) {
    EmitFinalDestCopy(e.getType(), CGF.getOpaqueLValueMapping(e));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitPseudoObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 187,
   FQN="(anonymous namespace)::AggExprEmitter::VisitPseudoObjectExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter21VisitPseudoObjectExprEPN5clang16PseudoObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter21VisitPseudoObjectExprEPN5clang16PseudoObjectExprE")
  //</editor-fold>
  public void VisitPseudoObjectExpr(PseudoObjectExpr /*P*/ E) {
    if (E.isGLValue()) {
      LValue LV = CGF.EmitPseudoObjectLValue(E);
      EmitFinalDestCopy(E.getType(), LV);
      /*JAVA:return*/return;
    }
    
    CGF.EmitPseudoObjectRValue(E, EnsureSlot(E.getType()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitVAArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 967,
   FQN="(anonymous namespace)::AggExprEmitter::VisitVAArgExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter14VisitVAArgExprEPN5clang9VAArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter14VisitVAArgExprEPN5clang9VAArgExprE")
  //</editor-fold>
  public void VisitVAArgExpr(VAArgExpr /*P*/ VE) {
    Address ArgValue = Address.invalid();
    Address ArgPtr = CGF.EmitVAArg(VE, ArgValue);
    
    // If EmitVAArg fails, emit an error.
    if (!ArgPtr.isValid()) {
      CGF.ErrorUnsupported(VE, $("aggregate va_arg expression"));
      return;
    }
    
    EmitFinalDestCopy(VE.getType(), CGF.MakeAddrLValue(new Address(ArgPtr), VE.getType()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::EmitInitializationToLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 1062,
   FQN="(anonymous namespace)::AggExprEmitter::EmitInitializationToLValue", NM="_ZN12_GLOBAL__N_114AggExprEmitter26EmitInitializationToLValueEPN5clang4ExprENS1_7CodeGen6LValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter26EmitInitializationToLValueEPN5clang4ExprENS1_7CodeGen6LValueE")
  //</editor-fold>
  public void EmitInitializationToLValue(Expr /*P*/ E, LValue LV) {
    QualType type = LV.getType();
    // FIXME: Ignore result?
    // FIXME: Are initializers affected by volatile?
    if ((Dest.isZeroed().getValue() != 0) && isSimpleZero(E, CGF)) {
      // Storing "i32 0" to a zero'd memory location is a noop.
      return;
    } else if (isa_ImplicitValueInitExpr(E) || isa_CXXScalarValueInitExpr(E)) {
      EmitNullInitializationToLValue(new LValue(LV));
      /*JAVA:return*/return;
    } else if (isa_NoInitExpr(E)) {
      // Do nothing.
      return;
    } else if (type.$arrow().isReferenceType()) {
      RValue RV = CGF.EmitReferenceBindingToExpr(E);
      CGF.EmitStoreThroughLValue(new RValue(RV), new LValue(LV));
      /*JAVA:return*/return;
    }
    switch (CGF.getEvaluationKind(new QualType(type))) {
     case TEK_Complex:
      CGF.EmitComplexExprIntoLValue(E, new LValue(LV), /*isInit*/ true);
      return;
     case TEK_Aggregate:
      CGF.EmitAggExpr(E, AggValueSlot.forLValue(LV, 
              AggValueSlot.IsDestructed_t.IsDestructed, 
              AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers, 
              AggValueSlot.IsAliased_t.IsNotAliased, 
              Dest.isZeroed()));
      return;
     case TEK_Scalar:
      if (LV.isSimple()) {
        CGF.EmitScalarInit(E, /*D=*/ (/*const*/ ValueDecl /*P*/ )null, new LValue(LV), /*Captured=*/ false);
      } else {
        CGF.EmitStoreThroughLValue(RValue.get(CGF.EmitScalarExpr(E)), new LValue(LV));
      }
      return;
    }
    throw new llvm_unreachable("bad evaluation kind");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::EmitNullInitializationToLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 1102,
   FQN="(anonymous namespace)::AggExprEmitter::EmitNullInitializationToLValue", NM="_ZN12_GLOBAL__N_114AggExprEmitter30EmitNullInitializationToLValueEN5clang7CodeGen6LValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter30EmitNullInitializationToLValueEN5clang7CodeGen6LValueE")
  //</editor-fold>
  public void EmitNullInitializationToLValue(LValue lv) {
    QualType type = lv.getType();
    
    // If the destination slot is already zeroed out before the aggregate is
    // copied into it, we don't have to emit any zeros here.
    if ((Dest.isZeroed().getValue() != 0) && CGF.getTypes().isZeroInitializable(new QualType(type))) {
      return;
    }
    if (CGF.hasScalarEvaluationKind(new QualType(type))) {
      // For non-aggregates, we can store the appropriate null constant.
      Value /*P*/ __null = CGF.CGM.EmitNullConstant(new QualType(type));
      // Note that the following is not equivalent to
      // EmitStoreThroughBitfieldLValue for ARC types.
      if (lv.isBitField()) {
        CGF.EmitStoreThroughBitfieldLValue(RValue.get(__null), new LValue(lv));
      } else {
        assert (lv.isSimple());
        CGF.EmitStoreOfScalar(__null, new LValue(lv), /* isInitialization */ true);
      }
    } else {
      // There's a potential optimization opportunity in combining
      // memsets; that would be easy for arrays, but relatively
      // difficult for structures with the current code.
      CGF.EmitNullInitialization(lv.getAddress(), lv.getType());
    }
  }

  //  case Expr::ChooseExprClass:
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitCXXThrowExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 201,
   FQN="(anonymous namespace)::AggExprEmitter::VisitCXXThrowExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter17VisitCXXThrowExprEPKN5clang12CXXThrowExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter17VisitCXXThrowExprEPKN5clang12CXXThrowExprE")
  //</editor-fold>
  public void VisitCXXThrowExpr(/*const*/ CXXThrowExpr /*P*/ E) {
    CGF.EmitCXXThrowExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AggExprEmitter::VisitAtomicExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 202,
   FQN="(anonymous namespace)::AggExprEmitter::VisitAtomicExpr", NM="_ZN12_GLOBAL__N_114AggExprEmitter15VisitAtomicExprEPN5clang10AtomicExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZN12_GLOBAL__N_114AggExprEmitter15VisitAtomicExprEPN5clang10AtomicExprE")
  //</editor-fold>
  public void VisitAtomicExpr(AtomicExpr /*P*/ E) {
    RValue Res = CGF.EmitAtomicExpr(E);
    EmitFinalDestCopy(E.getType(), new RValue(Res));
  }

  
  @Override public String toString() {
    return "" + "CGF=" + CGF // NOI18N
              + ", Builder=" + Builder // NOI18N
              + ", Dest=" + Dest // NOI18N
              + ", IsResultUnused=" + IsResultUnused // NOI18N
              + super.toString(); // NOI18N
  }
}
