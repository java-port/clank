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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.clang.staticanalyzer.core.impl.SValBuilderStatics;

//<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 32,
 FQN="clang::ento::SValBuilder", NM="_ZN5clang4ento11SValBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilderE")
//</editor-fold>
public abstract class SValBuilder implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // Basic SVal creation.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 30,
   FQN="clang::ento::SValBuilder::anchor", NM="_ZN5clang4ento11SValBuilder6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*protected:*/
  protected final ASTContext /*&*/ Context;
  
  /// Manager of APSInt values.
  protected BasicValueFactory BasicVals;
  
  /// Manages the creation of symbols.
  protected SymbolManager SymMgr;
  
  /// Manages the creation of memory regions.
  protected MemRegionManager MemMgr;
  
  protected final ProgramStateManager /*&*/ StateMgr;
  
  /// The scalar type to use for array indices.
  protected /*const*/ QualType ArrayIndexTy;
  
  /// The width of the scalar type used for array indices.
  protected /*const*//*uint*/int ArrayIndexWidth;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::evalCastFromNonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 54,
   FQN="clang::ento::SValBuilder::evalCastFromNonLoc", NM="_ZN5clang4ento11SValBuilder18evalCastFromNonLocENS0_6NonLocENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder18evalCastFromNonLocENS0_6NonLocENS_8QualTypeE")
  //</editor-fold>
  protected abstract /*virtual*/ SVal evalCastFromNonLoc(NonLoc val, QualType castTy)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::evalCastFromLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 55,
   FQN="clang::ento::SValBuilder::evalCastFromLoc", NM="_ZN5clang4ento11SValBuilder15evalCastFromLocENS0_3LocENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder15evalCastFromLocENS0_3LocENS_8QualTypeE")
  //</editor-fold>
  protected abstract /*virtual*/ SVal evalCastFromLoc(Loc val, QualType castTy)/* = 0*/;

/*public:*/
  // FIXME: Make these protected again once RegionStoreManager correctly
  // handles loads from different bound value types.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::dispatchCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 60,
   FQN="clang::ento::SValBuilder::dispatchCast", NM="_ZN5clang4ento11SValBuilder12dispatchCastENS0_4SValENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder12dispatchCastENS0_4SValENS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ SVal dispatchCast(SVal val, QualType castTy)/* = 0*/;

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::SValBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 63,
   FQN="clang::ento::SValBuilder::SValBuilder", NM="_ZN5clang4ento11SValBuilderC1ERN4llvm20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEERNS_10ASTContextERNS0_19ProgramStateManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilderC1ERN4llvm20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEERNS_10ASTContextERNS0_19ProgramStateManagerE")
  //</editor-fold>
  public SValBuilder(final BumpPtrAllocatorImpl /*&*/ alloc, final ASTContext /*&*/ context, 
      final ProgramStateManager /*&*/ stateMgr) {
    // : Context(context), BasicVals(context, alloc), SymMgr(context, BasicVals, alloc), MemMgr(context, alloc), StateMgr(stateMgr), ArrayIndexTy(context.LongLongTy.operator QualType()), ArrayIndexWidth(context.getTypeSize(ArrayIndexTy)) 
    //START JInit
    this./*&*/Context=/*&*/context;
    this.BasicVals = new BasicValueFactory(context, alloc);
    this.SymMgr = new SymbolManager(context, BasicVals, alloc);
    this.MemMgr = new MemRegionManager(context, alloc);
    this./*&*/StateMgr=/*&*/stateMgr;
    this.ArrayIndexTy = context.LongLongTy.$QualType();
    this.ArrayIndexWidth = $ulong2uint(context.getTypeSize(new QualType(ArrayIndexTy)));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::~SValBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 72,
   FQN="clang::ento::SValBuilder::~SValBuilder", NM="_ZN5clang4ento11SValBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilderD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    //START JDestroy
    MemMgr.$destroy();
    SymMgr.$destroy();
    BasicVals.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::haveSameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 74,
   FQN="clang::ento::SValBuilder::haveSameType", NM="_ZN5clang4ento11SValBuilder12haveSameTypeEPKNS0_7SymExprES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder12haveSameTypeEPKNS0_7SymExprES4_")
  //</editor-fold>
  public boolean haveSameType(/*const*/ SymExpr /*P*/ Sym1, /*const*/ SymExpr /*P*/ Sym2) {
    return haveSameType(Sym1.getType(), Sym2.getType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::haveSameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 78,
   FQN="clang::ento::SValBuilder::haveSameType", NM="_ZN5clang4ento11SValBuilder12haveSameTypeENS_8QualTypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder12haveSameTypeENS_8QualTypeES2_")
  //</editor-fold>
  public boolean haveSameType(QualType Ty1, QualType Ty2) {
    // FIXME: Remove the second disjunct when we support symbolic
    // truncation/extension.
    return ($eq_CanQual$T_CanQual$U(Context.getCanonicalType(/*NO_COPY*/Ty1), Context.getCanonicalType(/*NO_COPY*/Ty2))
       || (Ty1.$arrow().isIntegralOrEnumerationType()
       && Ty2.$arrow().isIntegralOrEnumerationType()));
  }

  
  
  // FIXME: should rewrite according to the cast kind.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::evalCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 471,
   FQN="clang::ento::SValBuilder::evalCast", NM="_ZN5clang4ento11SValBuilder8evalCastENS0_4SValENS_8QualTypeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder8evalCastENS0_4SValENS_8QualTypeES3_")
  //</editor-fold>
  public SVal evalCast(SVal val, QualType castTy, QualType originalTy) {
    castTy.$assignMove(Context.getCanonicalType(/*NO_COPY*/castTy).$QualType());
    originalTy.$assignMove(Context.getCanonicalType(/*NO_COPY*/originalTy).$QualType());
    if (val.isUnknownOrUndef$SVal() || QualType.$eq_QualType$C(castTy, originalTy)) {
      return new SVal(JD$Move.INSTANCE, val);
    }
    if (castTy.$arrow().isBooleanType()) {
      if (val.isUnknownOrUndef$SVal()) {
        return new SVal(JD$Move.INSTANCE, val);
      }
      if (val.isConstant()) {
        return new SVal(JD$Move.INSTANCE, makeTruthVal(!val.isZeroConstant(), new QualType(castTy)));
      }
      if (!Loc.isLocType(new QualType(originalTy))
         && !originalTy.$arrow().isIntegralOrEnumerationType()
         && !originalTy.$arrow().isMemberPointerType()) {
        return new SVal(JD$Move.INSTANCE, new UnknownVal());
      }
      {
        /*const*/ SymExpr /*P*/ Sym = val.getAsSymbol(true);
        if ((Sym != null)) {
          final BasicValueFactory /*&*/ BVF = getBasicValueFactory();
          // FIXME: If we had a state here, we could see if the symbol is known to
          // be zero, but we don't.
          return new SVal(JD$Move.INSTANCE, makeNonLoc(Sym, BinaryOperatorKind.BO_NE, BVF.getValue($int2ulong(0), Sym.getType()), new QualType(castTy)));
        }
      }
      {
        // Loc values are not always true, they could be weakly linked functions.
        Optional<Loc> L = val.getAs(Loc.class);
        if (L.$bool()) {
          return evalCastFromLoc(new Loc(L.$star()), new QualType(castTy));
        }
      }
      
      Loc L = val.castAs(NsNonloc.LocAsInteger.class).getLoc();
      return evalCastFromLoc(new Loc(L), new QualType(castTy));
    }
    
    // For const casts, casts to void, just propagate the value.
    if (!castTy.$arrow().isVariableArrayType() && !originalTy.$arrow().isVariableArrayType()) {
      if (SValBuilderStatics.shouldBeModeledWithNoOp(Context, Context.getPointerType(/*NO_COPY*/castTy), 
          Context.getPointerType(/*NO_COPY*/originalTy))) {
        return new SVal(JD$Move.INSTANCE, val);
      }
    }
    
    // Check for casts from pointers to integers.
    if (castTy.$arrow().isIntegralOrEnumerationType() && Loc.isLocType(new QualType(originalTy))) {
      return evalCastFromLoc(val.castAs(Loc.class), new QualType(castTy));
    }
    
    // Check for casts from integers to pointers.
    if (Loc.isLocType(new QualType(castTy)) && originalTy.$arrow().isIntegralOrEnumerationType()) {
      {
        Optional<NsNonloc.LocAsInteger> LV = val.getAs(NsNonloc.LocAsInteger.class);
        if (LV.$bool()) {
          {
            /*const*/ MemRegion /*P*/ R = LV.$arrow().getLoc().getAsRegion();
            if ((R != null)) {
              final StoreManager /*&*/ storeMgr = StateMgr.getStoreManager();
              R = storeMgr.castRegion(R, new QualType(castTy));
              return (R != null) ? new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(R)) : new SVal(JD$Move.INSTANCE, new UnknownVal());
            }
          }
          return new SVal(JD$Move.INSTANCE, LV.$arrow().getLoc());
        }
      }
      return dispatchCast(new SVal(val), new QualType(castTy));
    }
    
    // Just pass through function and block pointers.
    if (originalTy.$arrow().isBlockPointerType() || originalTy.$arrow().isFunctionPointerType()) {
      assert (Loc.isLocType(new QualType(castTy)));
      return new SVal(JD$Move.INSTANCE, val);
    }
    {
      
      // Check for casts from array type to another type.
      /*const*/ ArrayType /*P*/ arrayT = dyn_cast_ArrayType(originalTy.getCanonicalType());
      if ((arrayT != null)) {
        // We will always decay to a pointer.
        QualType elemTy = arrayT.getElementType();
        val.$assignMove(StateMgr.ArrayToPointer(val.castAs(Loc.class), new QualType(elemTy)));
        
        // Are we casting from an array to a pointer?  If so just pass on
        // the decayed value.
        if (castTy.$arrow().isPointerType() || castTy.$arrow().isReferenceType()) {
          return new SVal(JD$Move.INSTANCE, val);
        }
        
        // Are we casting from an array to an integer?  If so, cast the decayed
        // pointer value to an integer.
        assert (castTy.$arrow().isIntegralOrEnumerationType());
        
        // FIXME: Keep these here for now in case we decide soon that we
        // need the original decayed type.
        //    QualType elemTy = cast<ArrayType>(originalTy)->getElementType();
        //    QualType pointerTy = C.getPointerType(elemTy);
        return evalCastFromLoc(val.castAs(Loc.class), new QualType(castTy));
      }
    }
    {
      
      // Check for casts from a region to a specific type.
      /*const*/ MemRegion /*P*/ R = val.getAsRegion();
      if ((R != null)) {
        // Handle other casts of locations to integers.
        if (castTy.$arrow().isIntegralOrEnumerationType()) {
          return evalCastFromLoc(new Loc(JD$Move.INSTANCE, new NsLoc.MemRegionVal(R)), new QualType(castTy));
        }
        
        // FIXME: We should handle the case where we strip off view layers to get
        //  to a desugared type.
        if (!Loc.isLocType(new QualType(castTy))) {
          // FIXME: There can be gross cases where one casts the result of a function
          // (that returns a pointer) to some other value that happens to fit
          // within that pointer value.  We currently have no good way to
          // model such operations.  When this happens, the underlying operation
          // is that the caller is reasoning about bits.  Conceptually we are
          // layering a "view" of a location on top of those bits.  Perhaps
          // we need to be more lazy about mutual possible views, even on an
          // SVal?  This may be necessary for bit-level reasoning as well.
          return new SVal(JD$Move.INSTANCE, new UnknownVal());
        }
        
        // We get a symbolic function pointer for a dereference of a function
        // pointer, but it is of function type. Example:
        
        //  struct FPRec {
        //    void (*my_func)(int * x);
        //  };
        //
        //  int bar(int x);
        //
        //  int f1_a(struct FPRec* foo) {
        //    int x;
        //    (*foo->my_func)(&x);
        //    return bar(x)+1; // no-warning
        //  }
        assert (Loc.isLocType(new QualType(originalTy)) || originalTy.$arrow().isFunctionType() || originalTy.$arrow().isBlockPointerType() || castTy.$arrow().isReferenceType());
        
        final StoreManager /*&*/ storeMgr = StateMgr.getStoreManager();
        
        // Delegate to store manager to get the result of casting a region to a
        // different type.  If the MemRegion* returned is NULL, this expression
        // Evaluates to UnknownVal.
        R = storeMgr.castRegion(R, new QualType(castTy));
        return (R != null) ? new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(R)) : new SVal(JD$Move.INSTANCE, new UnknownVal());
      }
    }
    
    return dispatchCast(new SVal(val), new QualType(castTy));
  }

  
  // Handles casts of type CK_IntegralCast.
  
  // Handles casts of type CK_IntegralCast.
  // At the moment, this function will redirect to evalCast, except when the range
  // of the original value is known to be greater than the max of the target type.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::evalIntegralCast">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*std.tie*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 434,
   FQN="clang::ento::SValBuilder::evalIntegralCast", NM="_ZN5clang4ento11SValBuilder16evalIntegralCastEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValENS_8QualTypeES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder16evalIntegralCastEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValENS_8QualTypeES8_")
  //</editor-fold>
  public SVal evalIntegralCast(IntrusiveRefCntPtr</*const*/ ProgramState> state, SVal val, 
                  QualType castTy, QualType originalTy) {
    IntrusiveRefCntPtr</*const*/ ProgramState> IsNotTruncated = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> IsTruncated = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // No truncations if target type is big enough.
      if ($greatereq_ulong(getContext().getTypeSize(new QualType(castTy)), getContext().getTypeSize(new QualType(originalTy)))) {
        return evalCast(new SVal(val), new QualType(castTy), new QualType(originalTy));
      }
      
      /*const*/ SymExpr /*P*/ se = val.getAsSymbolicExpression();
      if (!(se != null)) { // Let evalCast handle non symbolic expressions.
        return evalCast(new SVal(val), new QualType(castTy), new QualType(originalTy));
      }
      
      // Find the maximum value of the target type.
      APSIntType ToType/*J*/= new APSIntType($ulong2uint(getContext().getTypeSize(new QualType(castTy))), 
          castTy.$arrow().isUnsignedIntegerType());
      APSInt ToTypeMax = ToType.getMaxValue();
      NonLoc ToTypeMaxVal = makeIntVal(ToTypeMax.isUnsigned() ? ToTypeMax.getZExtValue() : ToTypeMax.getSExtValue(), 
    new QualType(castTy)).castAs(NonLoc.class);
      // Check the range of the symbol being casted against the maximum value of the
      // target type.
      NonLoc FromVal = val.castAs(NonLoc.class);
      QualType CmpTy = getConditionType();
      NonLoc CompVal = $c$.clean(evalBinOpNN($c$.track(new IntrusiveRefCntPtr(state)), BinaryOperatorKind.BO_LE, new NonLoc(FromVal), new NonLoc(ToTypeMaxVal), new QualType(CmpTy)).castAs(NonLoc.class));
      IsNotTruncated/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      IsTruncated/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(IsNotTruncated, IsTruncated).$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(CompVal)))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
              $c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(CompVal)));
      IsNotTruncated.$assign($assume.first);
      IsTruncated.$assign($assume.second);
      assert !$assume.first.$bool();
      assert !$assume.second.$bool();
      $c$.clean();
      
      if (!IsNotTruncated.$bool() && IsTruncated.$bool()) {
        // Symbol is truncated so we evaluate it as a cast.
        NonLoc CastVal = makeNonLoc(se, new QualType(originalTy), new QualType(castTy));
        return new SVal(CastVal);
      }
      return evalCast(new SVal(val), new QualType(castTy), new QualType(originalTy));
    } finally {
      if (IsTruncated != null) { IsTruncated.$destroy(); }
      if (IsNotTruncated != null) { IsNotTruncated.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::evalMinus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 92,
   FQN="clang::ento::SValBuilder::evalMinus", NM="_ZN5clang4ento11SValBuilder9evalMinusENS0_6NonLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder9evalMinusENS0_6NonLocE")
  //</editor-fold>
  public abstract /*virtual*/ SVal evalMinus(NonLoc val)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::evalComplement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 94,
   FQN="clang::ento::SValBuilder::evalComplement", NM="_ZN5clang4ento11SValBuilder14evalComplementENS0_6NonLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder14evalComplementENS0_6NonLocE")
  //</editor-fold>
  public abstract /*virtual*/ SVal evalComplement(NonLoc val)/* = 0*/;

  
  /// Create a new value which represents a binary expression with two non-
  /// location operands.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::evalBinOpNN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 98,
   FQN="clang::ento::SValBuilder::evalBinOpNN", NM="_ZN5clang4ento11SValBuilder11evalBinOpNNEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS_18BinaryOperatorKindENS0_6NonLocES8_NS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder11evalBinOpNNEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS_18BinaryOperatorKindENS0_6NonLocES8_NS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ SVal evalBinOpNN(IntrusiveRefCntPtr</*const*/ ProgramState> state, BinaryOperatorKind op, 
             NonLoc lhs, NonLoc rhs, QualType resultTy)/* = 0*/;

  
  /// Create a new value which represents a binary expression with two memory
  /// location operands.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::evalBinOpLL">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 103,
   FQN="clang::ento::SValBuilder::evalBinOpLL", NM="_ZN5clang4ento11SValBuilder11evalBinOpLLEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS_18BinaryOperatorKindENS0_3LocES8_NS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder11evalBinOpLLEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS_18BinaryOperatorKindENS0_3LocES8_NS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ SVal evalBinOpLL(IntrusiveRefCntPtr</*const*/ ProgramState> state, BinaryOperatorKind op, 
             Loc lhs, Loc rhs, QualType resultTy)/* = 0*/;

  
  /// Create a new value which represents a binary expression with a memory
  /// location and non-location operands. For example, this would be used to
  /// evaluate a pointer arithmetic operation.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::evalBinOpLN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 109,
   FQN="clang::ento::SValBuilder::evalBinOpLN", NM="_ZN5clang4ento11SValBuilder11evalBinOpLNEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS_18BinaryOperatorKindENS0_3LocENS0_6NonLocENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder11evalBinOpLNEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS_18BinaryOperatorKindENS0_3LocENS0_6NonLocENS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ SVal evalBinOpLN(IntrusiveRefCntPtr</*const*/ ProgramState> state, BinaryOperatorKind op, 
             Loc lhs, NonLoc rhs, QualType resultTy)/* = 0*/;

  
  /// Evaluates a given SVal. If the SVal has only one possible (integer) value,
  /// that value is returned. Otherwise, returns NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getKnownValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 114,
   FQN="clang::ento::SValBuilder::getKnownValue", NM="_ZN5clang4ento11SValBuilder13getKnownValueEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder13getKnownValueEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValE")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/ APSInt /*P*/ getKnownValue(IntrusiveRefCntPtr</*const*/ ProgramState> state, SVal val)/* = 0*/;

  
  /// Constructs a symbolic expression for two non-location values.
  
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeSymExprValNN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 332,
   FQN="clang::ento::SValBuilder::makeSymExprValNN", NM="_ZN5clang4ento11SValBuilder16makeSymExprValNNEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS_18BinaryOperatorKindENS0_6NonLocES8_NS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder16makeSymExprValNNEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS_18BinaryOperatorKindENS0_6NonLocES8_NS_8QualTypeE")
  //</editor-fold>
  public SVal makeSymExprValNN(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                  BinaryOperatorKind Op, 
                  NonLoc LHS, NonLoc RHS, 
                  QualType ResultTy) {
    if (!State.$arrow().isTainted(new SVal(RHS)) && !State.$arrow().isTainted(new SVal(LHS))) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    /*const*/ SymExpr /*P*/ symLHS = LHS.getAsSymExpr();
    /*const*/ SymExpr /*P*/ symRHS = RHS.getAsSymExpr();
    // TODO: When the Max Complexity is reached, we should conjure a symbol
    // instead of generating an Unknown value and propagate the taint info to it.
    /*const*//*uint*/int MaxComp = 10000; // 100000 28X
    if ((symLHS != null) && (symRHS != null)
       && $less_uint((symLHS.computeComplexity() + symRHS.computeComplexity()), MaxComp)) {
      return new SVal(JD$Move.INSTANCE, makeNonLoc(symLHS, Op, symRHS, new QualType(ResultTy)));
    }
    if ((symLHS != null) && $less_uint(symLHS.computeComplexity(), MaxComp)) {
      {
        Optional<NsNonloc.ConcreteInt> rInt = RHS.getAs(NsNonloc.ConcreteInt.class);
        if (rInt.$bool()) {
          return new SVal(JD$Move.INSTANCE, makeNonLoc(symLHS, Op, rInt.$arrow().getValue(), new QualType(ResultTy)));
        }
      }
    }
    if ((symRHS != null) && $less_uint(symRHS.computeComplexity(), MaxComp)) {
      {
        Optional<NsNonloc.ConcreteInt> lInt = LHS.getAs(NsNonloc.ConcreteInt.class);
        if (lInt.$bool()) {
          return new SVal(JD$Move.INSTANCE, makeNonLoc(lInt.$arrow().getValue(), Op, symRHS, new QualType(ResultTy)));
        }
      }
    }
    
    return new SVal(JD$Move.INSTANCE, new UnknownVal());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::evalBinOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 361,
   FQN="clang::ento::SValBuilder::evalBinOp", NM="_ZN5clang4ento11SValBuilder9evalBinOpEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS_18BinaryOperatorKindENS0_4SValES8_NS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder9evalBinOpEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS_18BinaryOperatorKindENS0_4SValES8_NS_8QualTypeE")
  //</editor-fold>
  public SVal evalBinOp(IntrusiveRefCntPtr</*const*/ ProgramState> state, BinaryOperatorKind op, 
           SVal lhs, SVal rhs, QualType type) {
    JavaCleaner $c$ = $createJavaCleaner();
    try { 
      if (lhs.isUndef$SVal() || rhs.isUndef$SVal()) {
        return new SVal(JD$Move.INSTANCE, new UndefinedVal());
      }
      if (lhs.isUnknown$SVal() || rhs.isUnknown$SVal()) {
        return new SVal(JD$Move.INSTANCE, new UnknownVal());
      }
      if (lhs.getAs(NsNonloc.LazyCompoundVal.class).$bool()
         || rhs.getAs(NsNonloc.LazyCompoundVal.class).$bool()) {
        return new SVal(JD$Move.INSTANCE, new UnknownVal());
      }
      {

        Optional<Loc> LV = lhs.getAs(Loc.class);
        if (LV.$bool()) {
          {
            Optional<Loc> RV = rhs.getAs(Loc.class);
            if (RV.$bool()) {
              return $c$.clean(evalBinOpLL($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), op, new Loc(LV.$star()), new Loc(RV.$star()), new QualType(type)));
            }
          }

          return $c$.clean(evalBinOpLN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), op, new Loc(LV.$star()), rhs.castAs(NonLoc.class), new QualType(type)));
        }
      }
      {

        Optional<Loc> RV = rhs.getAs(Loc.class);
        if (RV.$bool()) {
          // Support pointer arithmetic where the addend is on the left
          // and the pointer on the right.
          assert (op == BinaryOperatorKind.BO_Add);

          // Commute the operands.
          return $c$.clean(evalBinOpLN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), op, new Loc(RV.$star()), lhs.castAs(NonLoc.class), new QualType(type)));
        }
      }

      return $c$.clean(evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), op, lhs.castAs(NonLoc.class), rhs.castAs(NonLoc.class), 
          new QualType(type)));
    } finally {
     $c$.$destroy();
    } 
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::evalEQ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 395,
   FQN="clang::ento::SValBuilder::evalEQ", NM="_ZN5clang4ento11SValBuilder6evalEQEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_20DefinedOrUnknownSValES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder6evalEQEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_20DefinedOrUnknownSValES7_")
  //</editor-fold>
  public DefinedOrUnknownSVal evalEQ(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
        DefinedOrUnknownSVal lhs, 
        DefinedOrUnknownSVal rhs) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(evalBinOp($c$.track(new IntrusiveRefCntPtr(state)), BinaryOperatorKind.BO_EQ, new SVal(lhs), new SVal(rhs), getConditionType()).castAs(DefinedOrUnknownSVal.class));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 126,
   FQN="clang::ento::SValBuilder::getContext", NM="_ZN5clang4ento11SValBuilder10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder10getContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getContext() {
    return Context;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 127,
   FQN="clang::ento::SValBuilder::getContext", NM="_ZNK5clang4ento11SValBuilder10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZNK5clang4ento11SValBuilder10getContextEv")
  //</editor-fold>
  public /*const*/ ASTContext /*&*/ getContext$Const() /*const*/ {
    return Context;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getStateManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 129,
   FQN="clang::ento::SValBuilder::getStateManager", NM="_ZN5clang4ento11SValBuilder15getStateManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder15getStateManagerEv")
  //</editor-fold>
  public ProgramStateManager /*&*/ getStateManager() {
    return StateMgr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getConditionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 131,
   FQN="clang::ento::SValBuilder::getConditionType", NM="_ZNK5clang4ento11SValBuilder16getConditionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZNK5clang4ento11SValBuilder16getConditionTypeEv")
  //</editor-fold>
  public QualType getConditionType() /*const*/ {
    return (Context.getLangOpts().CPlusPlus ? Context.BoolTy : Context.IntTy).$QualType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getArrayIndexType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 135,
   FQN="clang::ento::SValBuilder::getArrayIndexType", NM="_ZNK5clang4ento11SValBuilder17getArrayIndexTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZNK5clang4ento11SValBuilder17getArrayIndexTypeEv")
  //</editor-fold>
  public QualType getArrayIndexType() /*const*/ {
    return new QualType(ArrayIndexTy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getBasicValueFactory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 139,
   FQN="clang::ento::SValBuilder::getBasicValueFactory", NM="_ZN5clang4ento11SValBuilder20getBasicValueFactoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder20getBasicValueFactoryEv")
  //</editor-fold>
  public BasicValueFactory /*&*/ getBasicValueFactory() {
    return BasicVals;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getBasicValueFactory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 140,
   FQN="clang::ento::SValBuilder::getBasicValueFactory", NM="_ZNK5clang4ento11SValBuilder20getBasicValueFactoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZNK5clang4ento11SValBuilder20getBasicValueFactoryEv")
  //</editor-fold>
  public /*const*/ BasicValueFactory /*&*/ getBasicValueFactory$Const() /*const*/ {
    return BasicVals;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getSymbolManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 142,
   FQN="clang::ento::SValBuilder::getSymbolManager", NM="_ZN5clang4ento11SValBuilder16getSymbolManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder16getSymbolManagerEv")
  //</editor-fold>
  public SymbolManager /*&*/ getSymbolManager() {
    return SymMgr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getSymbolManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 143,
   FQN="clang::ento::SValBuilder::getSymbolManager", NM="_ZNK5clang4ento11SValBuilder16getSymbolManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZNK5clang4ento11SValBuilder16getSymbolManagerEv")
  //</editor-fold>
  public /*const*/ SymbolManager /*&*/ getSymbolManager$Const() /*const*/ {
    return SymMgr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getRegionManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 145,
   FQN="clang::ento::SValBuilder::getRegionManager", NM="_ZN5clang4ento11SValBuilder16getRegionManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder16getRegionManagerEv")
  //</editor-fold>
  public MemRegionManager /*&*/ getRegionManager() {
    return MemMgr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getRegionManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 146,
   FQN="clang::ento::SValBuilder::getRegionManager", NM="_ZNK5clang4ento11SValBuilder16getRegionManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZNK5clang4ento11SValBuilder16getRegionManagerEv")
  //</editor-fold>
  public /*const*/ MemRegionManager /*&*/ getRegionManager$Const() /*const*/ {
    return MemMgr;
  }

  
  // Forwarding methods to SymbolManager.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::conjureSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 150,
   FQN="clang::ento::SValBuilder::conjureSymbol", NM="_ZN5clang4ento11SValBuilder13conjureSymbolEPKNS_4StmtEPKNS_15LocationContextENS_8QualTypeEjPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder13conjureSymbolEPKNS_4StmtEPKNS_15LocationContextENS_8QualTypeEjPKv")
  //</editor-fold>
  public /*const*/ SymbolConjured /*P*/ conjureSymbol(/*const*/ Stmt /*P*/ stmt, 
               /*const*/ LocationContext /*P*/ LCtx, 
               QualType type, 
               /*uint*/int visitCount) {
    return conjureSymbol(stmt, 
               LCtx, 
               type, 
               visitCount, 
               (/*const*/Object/*void P*/ )null);
  }
  public /*const*/ SymbolConjured /*P*/ conjureSymbol(/*const*/ Stmt /*P*/ stmt, 
               /*const*/ LocationContext /*P*/ LCtx, 
               QualType type, 
               /*uint*/int visitCount, 
               /*const*/Object/*void P*/ symbolTag/*= null*/) {
    return SymMgr.conjureSymbol(stmt, LCtx, new QualType(type), visitCount, symbolTag);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::conjureSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 158,
   FQN="clang::ento::SValBuilder::conjureSymbol", NM="_ZN5clang4ento11SValBuilder13conjureSymbolEPKNS_4ExprEPKNS_15LocationContextEjPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder13conjureSymbolEPKNS_4ExprEPKNS_15LocationContextEjPKv")
  //</editor-fold>
  public /*const*/ SymbolConjured /*P*/ conjureSymbol(/*const*/ Expr /*P*/ expr, 
               /*const*/ LocationContext /*P*/ LCtx, 
               /*uint*/int visitCount) {
    return conjureSymbol(expr, 
               LCtx, 
               visitCount, 
               (/*const*/Object/*void P*/ )null);
  }
  public /*const*/ SymbolConjured /*P*/ conjureSymbol(/*const*/ Expr /*P*/ expr, 
               /*const*/ LocationContext /*P*/ LCtx, 
               /*uint*/int visitCount, 
               /*const*/Object/*void P*/ symbolTag/*= null*/) {
    return SymMgr.conjureSymbol(expr, LCtx, visitCount, symbolTag);
  }

  
  /// Construct an SVal representing '0' for the specified type.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeZeroVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 32,
   FQN="clang::ento::SValBuilder::makeZeroVal", NM="_ZN5clang4ento11SValBuilder11makeZeroValENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder11makeZeroValENS_8QualTypeE")
  //</editor-fold>
  public DefinedOrUnknownSVal makeZeroVal(QualType type) {
    if (Loc.isLocType(new QualType(type))) {
      return new DefinedOrUnknownSVal(JD$Move.INSTANCE, makeNull());
    }
    if (type.$arrow().isIntegralOrEnumerationType()) {
      return new DefinedOrUnknownSVal(JD$Move.INSTANCE, makeIntVal($int2ulong(0), new QualType(type)));
    }
    
    // FIXME: Handle floats.
    // FIXME: Handle structs.
    return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new UnknownVal());
  }

  
  /// Make a unique symbol for value of region.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getRegionValueSymbolVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 94,
   FQN="clang::ento::SValBuilder::getRegionValueSymbolVal", NM="_ZN5clang4ento11SValBuilder23getRegionValueSymbolValEPKNS0_16TypedValueRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder23getRegionValueSymbolValEPKNS0_16TypedValueRegionE")
  //</editor-fold>
  public DefinedOrUnknownSVal getRegionValueSymbolVal(/*const*/ TypedValueRegion /*P*/ region) {
    QualType T = region.getValueType();
    if (T.$arrow().isNullPtrType()) {
      return makeZeroVal(new QualType(T));
    }
    if (!SymbolManager.canSymbolicate(new QualType(T))) {
      return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    /*const*/ SymExpr /*P*/ sym = SymMgr.getRegionValueSymbol(region);
    if (Loc.isLocType(new QualType(T))) {
      return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(MemMgr.getSymbolicRegion(sym)));
    }
    
    return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new NsNonloc.SymbolVal(sym));
  }

  
  /// \brief Create a new symbol with a unique 'name'.
  ///
  /// We resort to conjured symbols when we cannot construct a derived symbol.
  /// The advantage of symbols derived/built from other symbols is that we
  /// preserve the relation between related(or even equivalent) expressions, so
  /// conjured symbols should be used sparingly.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::conjureSymbolVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 112,
   FQN="clang::ento::SValBuilder::conjureSymbolVal", NM="_ZN5clang4ento11SValBuilder16conjureSymbolValEPKvPKNS_4ExprEPKNS_15LocationContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder16conjureSymbolValEPKvPKNS_4ExprEPKNS_15LocationContextEj")
  //</editor-fold>
  public DefinedOrUnknownSVal conjureSymbolVal(/*const*/Object/*void P*/ SymbolTag, 
                  /*const*/ Expr /*P*/ Ex, 
                  /*const*/ LocationContext /*P*/ LCtx, 
                  /*uint*/int Count) {
    QualType T = Ex.getType();
    if (T.$arrow().isNullPtrType()) {
      return makeZeroVal(new QualType(T));
    }
    
    // Compute the type of the result. If the expression is not an R-value, the
    // result should be a location.
    QualType ExType = Ex.getType();
    if (Ex.isGLValue()) {
      T.$assignMove(LCtx.getAnalysisDeclContext().getASTContext().getPointerType(/*NO_COPY*/ExType));
    }
    
    return conjureSymbolVal(SymbolTag, Ex, LCtx, new QualType(T), Count);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::conjureSymbolVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 130,
   FQN="clang::ento::SValBuilder::conjureSymbolVal", NM="_ZN5clang4ento11SValBuilder16conjureSymbolValEPKvPKNS_4ExprEPKNS_15LocationContextENS_8QualTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder16conjureSymbolValEPKvPKNS_4ExprEPKNS_15LocationContextENS_8QualTypeEj")
  //</editor-fold>
  public DefinedOrUnknownSVal conjureSymbolVal(/*const*/Object/*void P*/ symbolTag, 
                  /*const*/ Expr /*P*/ expr, 
                  /*const*/ LocationContext /*P*/ LCtx, 
                  QualType type, 
                  /*uint*/int count) {
    if (type.$arrow().isNullPtrType()) {
      return makeZeroVal(new QualType(type));
    }
    if (!SymbolManager.canSymbolicate(new QualType(type))) {
      return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    /*const*/ SymExpr /*P*/ sym = SymMgr.conjureSymbol(expr, LCtx, new QualType(type), count, symbolTag);
    if (Loc.isLocType(new QualType(type))) {
      return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(MemMgr.getSymbolicRegion(sym)));
    }
    
    return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new NsNonloc.SymbolVal(sym));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::conjureSymbolVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 150,
   FQN="clang::ento::SValBuilder::conjureSymbolVal", NM="_ZN5clang4ento11SValBuilder16conjureSymbolValEPKNS_4StmtEPKNS_15LocationContextENS_8QualTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder16conjureSymbolValEPKNS_4StmtEPKNS_15LocationContextENS_8QualTypeEj")
  //</editor-fold>
  public DefinedOrUnknownSVal conjureSymbolVal(/*const*/ Stmt /*P*/ stmt, 
                  /*const*/ LocationContext /*P*/ LCtx, 
                  QualType type, 
                  /*uint*/int visitCount) {
    if (type.$arrow().isNullPtrType()) {
      return makeZeroVal(new QualType(type));
    }
    if (!SymbolManager.canSymbolicate(new QualType(type))) {
      return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    /*const*/ SymExpr /*P*/ sym = SymMgr.conjureSymbol(stmt, LCtx, new QualType(type), visitCount);
    if (Loc.isLocType(new QualType(type))) {
      return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(MemMgr.getSymbolicRegion(sym)));
    }
    
    return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new NsNonloc.SymbolVal(sym));
  }

  /// \brief Conjure a symbol representing heap allocated memory region.
  ///
  /// Note, the expression should represent a location.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getConjuredHeapSymbolVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 168,
   FQN="clang::ento::SValBuilder::getConjuredHeapSymbolVal", NM="_ZN5clang4ento11SValBuilder24getConjuredHeapSymbolValEPKNS_4ExprEPKNS_15LocationContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder24getConjuredHeapSymbolValEPKNS_4ExprEPKNS_15LocationContextEj")
  //</editor-fold>
  public DefinedOrUnknownSVal getConjuredHeapSymbolVal(/*const*/ Expr /*P*/ E, 
                          /*const*/ LocationContext /*P*/ LCtx, 
                          /*uint*/int VisitCount) {
    QualType T = E.getType();
    assert (Loc.isLocType(new QualType(T)));
    assert (SymbolManager.canSymbolicate(new QualType(T)));
    if (T.$arrow().isNullPtrType()) {
      return makeZeroVal(new QualType(T));
    }
    
    /*const*/ SymExpr /*P*/ sym = SymMgr.conjureSymbol(E, LCtx, new QualType(T), VisitCount);
    return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(MemMgr.getSymbolicHeapRegion(sym)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getDerivedRegionValueSymbolVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 197,
   FQN="clang::ento::SValBuilder::getDerivedRegionValueSymbolVal", NM="_ZN5clang4ento11SValBuilder30getDerivedRegionValueSymbolValEPKNS0_7SymExprEPKNS0_16TypedValueRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder30getDerivedRegionValueSymbolValEPKNS0_7SymExprEPKNS0_16TypedValueRegionE")
  //</editor-fold>
  public DefinedOrUnknownSVal getDerivedRegionValueSymbolVal(/*const*/ SymExpr /*P*/ parentSymbol, 
                                /*const*/ TypedValueRegion /*P*/ region) {
    QualType T = region.getValueType();
    if (T.$arrow().isNullPtrType()) {
      return makeZeroVal(new QualType(T));
    }
    if (!SymbolManager.canSymbolicate(new QualType(T))) {
      return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    /*const*/ SymExpr /*P*/ sym = SymMgr.getDerivedSymbol(parentSymbol, region);
    if (Loc.isLocType(new QualType(T))) {
      return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(MemMgr.getSymbolicRegion(sym)));
    }
    
    return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new NsNonloc.SymbolVal(sym));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getMetadataSymbolVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 182,
   FQN="clang::ento::SValBuilder::getMetadataSymbolVal", NM="_ZN5clang4ento11SValBuilder20getMetadataSymbolValEPKvPKNS0_9MemRegionEPKNS_4ExprENS_8QualTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder20getMetadataSymbolValEPKvPKNS0_9MemRegionEPKNS_4ExprENS_8QualTypeEj")
  //</editor-fold>
  public DefinedSVal getMetadataSymbolVal(/*const*/Object/*void P*/ symbolTag, 
                      /*const*/ MemRegion /*P*/ region, 
                      /*const*/ Expr /*P*/ expr, QualType type, 
                      /*uint*/int count) {
    assert (SymbolManager.canSymbolicate(new QualType(type))) : "Invalid metadata symbol type";
    
    /*const*/ SymExpr /*P*/ sym = SymMgr.getMetadataSymbol(region, expr, new QualType(type), count, symbolTag);
    if (Loc.isLocType(new QualType(type))) {
      return new DefinedSVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(MemMgr.getSymbolicRegion(sym)));
    }
    
    return new DefinedSVal(JD$Move.INSTANCE, new NsNonloc.SymbolVal(sym));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getFunctionPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 216,
   FQN="clang::ento::SValBuilder::getFunctionPointer", NM="_ZN5clang4ento11SValBuilder18getFunctionPointerEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder18getFunctionPointerEPKNS_12FunctionDeclE")
  //</editor-fold>
  public DefinedSVal getFunctionPointer(/*const*/ FunctionDecl /*P*/ func) {
    return new DefinedSVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(MemMgr.getFunctionCodeRegion(func)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getBlockPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 220,
   FQN="clang::ento::SValBuilder::getBlockPointer", NM="_ZN5clang4ento11SValBuilder15getBlockPointerEPKNS_9BlockDeclENS_7CanQualINS_4TypeEEEPKNS_15LocationContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder15getBlockPointerEPKNS_9BlockDeclENS_7CanQualINS_4TypeEEEPKNS_15LocationContextEj")
  //</editor-fold>
  public DefinedSVal getBlockPointer(/*const*/ BlockDecl /*P*/ block, 
                 CanQual<Type> locTy, 
                 /*const*/ LocationContext /*P*/ locContext, 
                 /*uint*/int blockCount) {
    /*const*/ BlockCodeRegion /*P*/ BC = MemMgr.getBlockCodeRegion(block, new CanQual<Type>(locTy), locContext.getAnalysisDeclContext());
    /*const*/ BlockDataRegion /*P*/ BD = MemMgr.getBlockDataRegion(BC, locContext, 
        blockCount);
    return new DefinedSVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(BD));
  }

  
  /// Returns the value of \p E, if it can be determined in a non-path-sensitive
  /// manner.
  ///
  /// If \p E is not a constant or cannot be modeled, returns \c None.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getConstantVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 246,
   FQN="clang::ento::SValBuilder::getConstantVal", NM="_ZN5clang4ento11SValBuilder14getConstantValEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder14getConstantValEPKNS_4ExprE")
  //</editor-fold>
  public Optional<SVal> getConstantVal(/*const*/ Expr /*P*/ E) {
    E = E.IgnoreParens$Const();
    switch (E.getStmtClass()) {
     case AddrLabelExprClass:
      // Handle expressions that we treat differently from the AST's constant
      // evaluator.
      return new Optional<SVal>(JD$T$RR.INSTANCE, makeLoc(cast_AddrLabelExpr(E)));
     case CXXScalarValueInitExprClass:
     case ImplicitValueInitExprClass:
      return new Optional<SVal>(JD$T$RR.INSTANCE, makeZeroVal(E.getType()));
     case ObjCStringLiteralClass:
      {
        /*const*/ ObjCStringLiteral /*P*/ SL = cast_ObjCStringLiteral(E);
        return new Optional<SVal>(JD$T$RR.INSTANCE, makeLoc(getRegionManager().getObjCStringRegion(SL)));
      }
     case StringLiteralClass:
      {
        /*const*/ StringLiteral /*P*/ SL = cast_StringLiteral(E);
        return new Optional<SVal>(JD$T$RR.INSTANCE, makeLoc(getRegionManager().getStringRegion(SL)));
      }
     case CharacterLiteralClass:
      {
        /*const*/ CharacterLiteral /*P*/ C = cast_CharacterLiteral(E);
        return new Optional<SVal>(JD$T$RR.INSTANCE, makeIntVal($uint2ulong(C.getValue()), C.getType()));
      }
     case CXXBoolLiteralExprClass:
      return new Optional<SVal>(JD$T$RR.INSTANCE, makeBoolVal(cast_CXXBoolLiteralExpr(E)));
     case TypeTraitExprClass:
      {
        /*const*/ TypeTraitExpr /*P*/ TE = cast_TypeTraitExpr(E);
        return new Optional<SVal>(JD$T$RR.INSTANCE, makeTruthVal(TE.getValue(), TE.getType()));
      }
     case IntegerLiteralClass:
      return new Optional<SVal>(JD$T$RR.INSTANCE, makeIntVal(cast_IntegerLiteral(E)));
     case ObjCBoolLiteralExprClass:
      return new Optional<SVal>(JD$T$RR.INSTANCE, makeBoolVal(cast_ObjCBoolLiteralExpr(E)));
     case CXXNullPtrLiteralExprClass:
      return new Optional<SVal>(JD$T$RR.INSTANCE, makeNull());
     case ImplicitCastExprClass:
      {
        /*const*/ CastExpr /*P*/ CE = cast_CastExpr(E);
        switch (CE.getCastKind()) {
         default:
          break;
         case CK_ArrayToPointerDecay:
         case CK_BitCast:
          {
            /*const*/ Expr /*P*/ SE = CE.getSubExpr$Const();
            Optional<SVal> Val = getConstantVal(SE);
            if (!Val.$bool()) {
              return new Optional<SVal>(None);
            }
            return new Optional<SVal>(JD$T$RR.INSTANCE, evalCast(new SVal(Val.$star()), CE.getType(), SE.getType()));
          }
        }
        // FALLTHROUGH
      }
     default:
      {
        // Don't try to come up with a value for materialized temporaries.
        if (E.isGLValue()) {
          return new Optional<SVal>(None);
        }
        
        final ASTContext /*&*/ Ctx = getContext();
        APSInt Result/*J*/= new APSInt();
        if (E.EvaluateAsInt(Result, Ctx)) {
          return new Optional<SVal>(JD$T$RR.INSTANCE, makeIntVal(Result));
        }
        if (Loc.isLocType(E.getType())) {
          if ((E.isNullPointerConstant(Ctx, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNotNull).getValue() != 0)) {
            return new Optional<SVal>(JD$T$RR.INSTANCE, makeNull());
          }
        }
        
        return new Optional<SVal>(None);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeCompoundVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 217,
   FQN="clang::ento::SValBuilder::makeCompoundVal", NM="_ZN5clang4ento11SValBuilder15makeCompoundValENS_8QualTypeEN4llvm13ImmutableListINS0_4SValEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder15makeCompoundValENS_8QualTypeEN4llvm13ImmutableListINS0_4SValEEE")
  //</editor-fold>
  public NonLoc makeCompoundVal(QualType type, ImmutableList<SVal> vals) {
    return new NonLoc(JD$Move.INSTANCE, new NsNonloc.CompoundVal(BasicVals.getCompoundValData(new QualType(type), new ImmutableList<SVal>(vals))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeLazyCompoundVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 221,
   FQN="clang::ento::SValBuilder::makeLazyCompoundVal", NM="_ZN5clang4ento11SValBuilder19makeLazyCompoundValERKNS0_8StoreRefEPKNS0_16TypedValueRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder19makeLazyCompoundValERKNS0_8StoreRefEPKNS0_16TypedValueRegionE")
  //</editor-fold>
  public NonLoc makeLazyCompoundVal(final /*const*/ StoreRef /*&*/ store, 
                     /*const*/ TypedValueRegion /*P*/ region) {
    return new NonLoc(JD$Move.INSTANCE, new NsNonloc.LazyCompoundVal(BasicVals.getLazyCompoundValData(store, region)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeZeroArrayIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 227,
   FQN="clang::ento::SValBuilder::makeZeroArrayIndex", NM="_ZN5clang4ento11SValBuilder18makeZeroArrayIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder18makeZeroArrayIndexEv")
  //</editor-fold>
  public NonLoc makeZeroArrayIndex() {
    return new NonLoc(JD$Move.INSTANCE, new NsNonloc.ConcreteInt(BasicVals.getValue($int2ulong(0), new QualType(ArrayIndexTy))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeArrayIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 231,
   FQN="clang::ento::SValBuilder::makeArrayIndex", NM="_ZN5clang4ento11SValBuilder14makeArrayIndexEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder14makeArrayIndexEy")
  //</editor-fold>
  public NonLoc makeArrayIndex(long/*uint64_t*/ idx) {
    return new NonLoc(JD$Move.INSTANCE, new NsNonloc.ConcreteInt(BasicVals.getValue(idx, new QualType(ArrayIndexTy))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::convertToArrayIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 76,
   FQN="clang::ento::SValBuilder::convertToArrayIndex", NM="_ZN5clang4ento11SValBuilder19convertToArrayIndexENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder19convertToArrayIndexENS0_4SValE")
  //</editor-fold>
  public SVal convertToArrayIndex(SVal val) {
    if (val.isUnknownOrUndef$SVal()) {
      return new SVal(JD$Move.INSTANCE, val);
    }
    {
      
      // Common case: we have an appropriately sized integer.
      Optional<NsNonloc.ConcreteInt> CI = val.getAs(NsNonloc.ConcreteInt.class);
      if (CI.$bool()) {
        final /*const*/ APSInt /*&*/ I = CI.$arrow().getValue();
        if (I.getBitWidth() == ArrayIndexWidth && I.isSigned()) {
          return new SVal(JD$Move.INSTANCE, val);
        }
      }
    }
    
    return evalCastFromNonLoc(val.castAs(NonLoc.class), new QualType(ArrayIndexTy));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeIntVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 237,
   FQN="clang::ento::SValBuilder::makeIntVal", NM="_ZN5clang4ento11SValBuilder10makeIntValEPKNS_14IntegerLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder10makeIntValEPKNS_14IntegerLiteralE")
  //</editor-fold>
  public NsNonloc.ConcreteInt makeIntVal(/*const*/ IntegerLiteral /*P*/ integer) {
    return new NsNonloc.ConcreteInt(BasicVals.getValue(integer.getValue(), 
            integer.getType().$arrow().isUnsignedIntegerOrEnumerationType()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeBoolVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 243,
   FQN="clang::ento::SValBuilder::makeBoolVal", NM="_ZN5clang4ento11SValBuilder11makeBoolValEPKNS_19ObjCBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder11makeBoolValEPKNS_19ObjCBoolLiteralExprE")
  //</editor-fold>
  public NsNonloc.ConcreteInt makeBoolVal(/*const*/ ObjCBoolLiteralExpr /*P*/ __boolean) {
    return makeTruthVal(__boolean.getValue(), __boolean.getType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeBoolVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 90,
   FQN="clang::ento::SValBuilder::makeBoolVal", NM="_ZN5clang4ento11SValBuilder11makeBoolValEPKNS_18CXXBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder11makeBoolValEPKNS_18CXXBoolLiteralExprE")
  //</editor-fold>
  public NsNonloc.ConcreteInt makeBoolVal(/*const*/ CXXBoolLiteralExpr /*P*/ __boolean) {
    return makeTruthVal(__boolean.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeIntVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 249,
   FQN="clang::ento::SValBuilder::makeIntVal", NM="_ZN5clang4ento11SValBuilder10makeIntValERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder10makeIntValERKN4llvm6APSIntE")
  //</editor-fold>
  public NsNonloc.ConcreteInt makeIntVal(final /*const*/ APSInt /*&*/ integer) {
    return new NsNonloc.ConcreteInt(BasicVals.getValue(integer));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeIntLocVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 253,
   FQN="clang::ento::SValBuilder::makeIntLocVal", NM="_ZN5clang4ento11SValBuilder13makeIntLocValERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder13makeIntLocValERKN4llvm6APSIntE")
  //</editor-fold>
  public NsLoc.ConcreteInt makeIntLocVal(final /*const*/ APSInt /*&*/ integer) {
    return new NsLoc.ConcreteInt(BasicVals.getValue(integer));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeIntVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 257,
   FQN="clang::ento::SValBuilder::makeIntVal", NM="_ZN5clang4ento11SValBuilder10makeIntValERKN4llvm5APIntEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder10makeIntValERKN4llvm5APIntEb")
  //</editor-fold>
  public NonLoc makeIntVal(final /*const*/ APInt /*&*/ integer, boolean isUnsigned) {
    return new NonLoc(JD$Move.INSTANCE, new NsNonloc.ConcreteInt(BasicVals.getValue(integer, isUnsigned)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeIntVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 261,
   FQN="clang::ento::SValBuilder::makeIntVal", NM="_ZN5clang4ento11SValBuilder10makeIntValEyNS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder10makeIntValEyNS_8QualTypeE")
  //</editor-fold>
  public DefinedSVal makeIntVal(long/*uint64_t*/ integer, QualType type) {
    if (Loc.isLocType(new QualType(type))) {
      return new DefinedSVal(JD$Move.INSTANCE, new NsLoc.ConcreteInt(BasicVals.getValue(integer, new QualType(type))));
    }
    
    return new DefinedSVal(JD$Move.INSTANCE, new NsNonloc.ConcreteInt(BasicVals.getValue(integer, new QualType(type))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeIntVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 268,
   FQN="clang::ento::SValBuilder::makeIntVal", NM="_ZN5clang4ento11SValBuilder10makeIntValEyb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder10makeIntValEyb")
  //</editor-fold>
  public NonLoc makeIntVal(long/*uint64_t*/ integer, boolean isUnsigned) {
    return new NonLoc(JD$Move.INSTANCE, new NsNonloc.ConcreteInt(BasicVals.getIntValue(integer, isUnsigned)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeIntValWithPtrWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 272,
   FQN="clang::ento::SValBuilder::makeIntValWithPtrWidth", NM="_ZN5clang4ento11SValBuilder22makeIntValWithPtrWidthEyb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder22makeIntValWithPtrWidthEyb")
  //</editor-fold>
  public NonLoc makeIntValWithPtrWidth(long/*uint64_t*/ integer, boolean isUnsigned) {
    return new NonLoc(JD$Move.INSTANCE, new NsNonloc.ConcreteInt(BasicVals.getIntWithPtrWidth(integer, isUnsigned)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeLocAsInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 277,
   FQN="clang::ento::SValBuilder::makeLocAsInteger", NM="_ZN5clang4ento11SValBuilder16makeLocAsIntegerENS0_3LocEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder16makeLocAsIntegerENS0_3LocEj")
  //</editor-fold>
  public NonLoc makeLocAsInteger(Loc loc, /*uint*/int bits) {
    return new NonLoc(JD$Move.INSTANCE, new NsNonloc.LocAsInteger(BasicVals.getPersistentSValWithData(loc, bits)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeNonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 44,
   FQN="clang::ento::SValBuilder::makeNonLoc", NM="_ZN5clang4ento11SValBuilder10makeNonLocEPKNS0_7SymExprENS_18BinaryOperatorKindERKN4llvm6APSIntENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder10makeNonLocEPKNS0_7SymExprENS_18BinaryOperatorKindERKN4llvm6APSIntENS_8QualTypeE")
  //</editor-fold>
  public NonLoc makeNonLoc(/*const*/ SymExpr /*P*/ lhs, BinaryOperatorKind op, 
            final /*const*/ APSInt /*&*/ rhs, QualType type) {
    // The Environment ensures we always get a persistent APSInt in
    // BasicValueFactory, so we don't need to get the APSInt from
    // BasicValueFactory again.
    assert Native.$bool(lhs);
    assert (!Loc.isLocType(new QualType(type)));
    return new NonLoc(JD$Move.INSTANCE, new NsNonloc.SymbolVal(SymMgr.getSymIntExpr_SymExpr$C$P_BinaryOperatorKind_APSInt$C_QualType(lhs, op, rhs, new QualType(type))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeNonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 54,
   FQN="clang::ento::SValBuilder::makeNonLoc", NM="_ZN5clang4ento11SValBuilder10makeNonLocERKN4llvm6APSIntENS_18BinaryOperatorKindEPKNS0_7SymExprENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder10makeNonLocERKN4llvm6APSIntENS_18BinaryOperatorKindEPKNS0_7SymExprENS_8QualTypeE")
  //</editor-fold>
  public NonLoc makeNonLoc(final /*const*/ APSInt /*&*/ lhs, 
            BinaryOperatorKind op, /*const*/ SymExpr /*P*/ rhs, 
            QualType type) {
    assert Native.$bool(rhs);
    assert (!Loc.isLocType(new QualType(type)));
    return new NonLoc(JD$Move.INSTANCE, new NsNonloc.SymbolVal(SymMgr.getIntSymExpr(lhs, op, rhs, new QualType(type))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeNonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 62,
   FQN="clang::ento::SValBuilder::makeNonLoc", NM="_ZN5clang4ento11SValBuilder10makeNonLocEPKNS0_7SymExprENS_18BinaryOperatorKindES4_NS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder10makeNonLocEPKNS0_7SymExprENS_18BinaryOperatorKindES4_NS_8QualTypeE")
  //</editor-fold>
  public NonLoc makeNonLoc(/*const*/ SymExpr /*P*/ lhs, BinaryOperatorKind op, 
            /*const*/ SymExpr /*P*/ rhs, QualType type) {
    assert ((lhs != null) && (rhs != null));
    assert (!Loc.isLocType(new QualType(type)));
    return new NonLoc(JD$Move.INSTANCE, new NsNonloc.SymbolVal(SymMgr.getSymSymExpr(lhs, op, rhs, new QualType(type))));
  }

  
  /// \brief Create a NonLoc value for cast.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeNonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 69,
   FQN="clang::ento::SValBuilder::makeNonLoc", NM="_ZN5clang4ento11SValBuilder10makeNonLocEPKNS0_7SymExprENS_8QualTypeES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder10makeNonLocEPKNS0_7SymExprENS_8QualTypeES5_")
  //</editor-fold>
  public NonLoc makeNonLoc(/*const*/ SymExpr /*P*/ operand, 
            QualType fromTy, QualType toTy) {
    assert Native.$bool(operand);
    assert (!Loc.isLocType(new QualType(toTy)));
    return new NonLoc(JD$Move.INSTANCE, new NsNonloc.SymbolVal(SymMgr.getCastSymbol(operand, new QualType(fromTy), new QualType(toTy))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeTruthVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 293,
   FQN="clang::ento::SValBuilder::makeTruthVal", NM="_ZN5clang4ento11SValBuilder12makeTruthValEbNS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder12makeTruthValEbNS_8QualTypeE")
  //</editor-fold>
  public NsNonloc.ConcreteInt makeTruthVal(boolean b, QualType type) {
    return new NsNonloc.ConcreteInt(BasicVals.getTruthValue(b, new QualType(type)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeTruthVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 297,
   FQN="clang::ento::SValBuilder::makeTruthVal", NM="_ZN5clang4ento11SValBuilder12makeTruthValEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder12makeTruthValEb")
  //</editor-fold>
  public NsNonloc.ConcreteInt makeTruthVal(boolean b) {
    return new NsNonloc.ConcreteInt(BasicVals.getTruthValue(b));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 301,
   FQN="clang::ento::SValBuilder::makeNull", NM="_ZN5clang4ento11SValBuilder8makeNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder8makeNullEv")
  //</editor-fold>
  public Loc makeNull() {
    return new Loc(JD$Move.INSTANCE, new NsLoc.ConcreteInt(BasicVals.getZeroWithPtrWidth()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 305,
   FQN="clang::ento::SValBuilder::makeLoc", NM="_ZN5clang4ento11SValBuilder7makeLocEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder7makeLocEPKNS0_7SymExprE")
  //</editor-fold>
  public Loc makeLoc(/*const*/ SymExpr /*P*/ sym) {
    return new Loc(JD$Move.INSTANCE, new NsLoc.MemRegionVal(MemMgr.getSymbolicRegion(sym)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 309,
   FQN="clang::ento::SValBuilder::makeLoc", NM="_ZN5clang4ento11SValBuilder7makeLocEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder7makeLocEPKNS0_9MemRegionE")
  //</editor-fold>
  public Loc makeLoc(/*const*/ MemRegion /*P*/ region) {
    return new Loc(JD$Move.INSTANCE, new NsLoc.MemRegionVal(region));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 313,
   FQN="clang::ento::SValBuilder::makeLoc", NM="_ZN5clang4ento11SValBuilder7makeLocEPKNS_13AddrLabelExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder7makeLocEPKNS_13AddrLabelExprE")
  //</editor-fold>
  public Loc makeLoc(/*const*/ AddrLabelExpr /*P*/ expr) {
    return new Loc(JD$Move.INSTANCE, new NsLoc.GotoLabel(expr.getLabel()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::makeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValBuilder.h", line = 317,
   FQN="clang::ento::SValBuilder::makeLoc", NM="_ZN5clang4ento11SValBuilder7makeLocERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder7makeLocERKN4llvm6APSIntE")
  //</editor-fold>
  public Loc makeLoc(final /*const*/ APSInt /*&*/ integer) {
    return new Loc(JD$Move.INSTANCE, new NsLoc.ConcreteInt(BasicVals.getValue(integer)));
  }

  
  /// Return a memory region for the 'this' object reference.
  
  /// Return a memory region for the 'this' object reference.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getCXXThis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 232,
   FQN="clang::ento::SValBuilder::getCXXThis", NM="_ZN5clang4ento11SValBuilder10getCXXThisEPKNS_13CXXMethodDeclEPKNS_17StackFrameContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder10getCXXThisEPKNS_13CXXMethodDeclEPKNS_17StackFrameContextE")
  //</editor-fold>
  public NsLoc.MemRegionVal getCXXThis(/*const*/ CXXMethodDecl /*P*/ D, 
            /*const*/ StackFrameContext /*P*/ SFC) {
    return new NsLoc.MemRegionVal(getRegionManager().
            getCXXThisRegion(D.getThisType(getContext()), SFC));
  }

  
  /// Return a memory region for the 'this' object reference.
  
  /// Return a memory region for the 'this' object reference.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValBuilder::getCXXThis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp", line = 239,
   FQN="clang::ento::SValBuilder::getCXXThis", NM="_ZN5clang4ento11SValBuilder10getCXXThisEPKNS_13CXXRecordDeclEPKNS_17StackFrameContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento11SValBuilder10getCXXThisEPKNS_13CXXRecordDeclEPKNS_17StackFrameContextE")
  //</editor-fold>
  public NsLoc.MemRegionVal getCXXThis(/*const*/ CXXRecordDecl /*P*/ D, 
            /*const*/ StackFrameContext /*P*/ SFC) {
    /*const*/ Type /*P*/ T = D.getTypeForDecl();
    QualType PT = getContext().getPointerType(new QualType(T, 0));
    return new NsLoc.MemRegionVal(getRegionManager().getCXXThisRegion(new QualType(PT), SFC));
  }

  
  @Override public String toString() {
    return "" + "Context=" + "[ASTContext]" // NOI18N
              + ", BasicVals=" + "[BasicValueFactory]" // NOI18N
              + ", SymMgr=" + "[SymbolManager]" // NOI18N
              + ", MemMgr=" + "[MemRegionManager]" // NOI18N
              + ", StateMgr=" + "[ProgramStateManager]" // NOI18N
              + ", ArrayIndexTy=" + ArrayIndexTy // NOI18N
              + ", ArrayIndexWidth=" + ArrayIndexWidth; // NOI18N
  }
}
