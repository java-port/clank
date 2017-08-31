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
package org.clang.staticanalyzer.core.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleSValBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp", line = 22,
 FQN="(anonymous namespace)::SimpleSValBuilder", NM="_ZN12_GLOBAL__N_117SimpleSValBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp -nm=_ZN12_GLOBAL__N_117SimpleSValBuilderE")
//</editor-fold>
public class SimpleSValBuilder extends /*public*/ SValBuilder implements Destructors.ClassWithDestructor {
/*protected:*/
  
  //===----------------------------------------------------------------------===//
  // Transfer function for Casts.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleSValBuilder::dispatchCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp", line = 62,
   FQN="(anonymous namespace)::SimpleSValBuilder::dispatchCast", NM="_ZN12_GLOBAL__N_117SimpleSValBuilder12dispatchCastEN5clang4ento4SValENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp -nm=_ZN12_GLOBAL__N_117SimpleSValBuilder12dispatchCastEN5clang4ento4SValENS1_8QualTypeE")
  //</editor-fold>
  @Override public/*protected*/ SVal dispatchCast(SVal Val, QualType CastTy)/* override*/ {
    assert (Val.getAs(Loc.class).$bool() || Val.getAs(NonLoc.class).$bool());
    return Val.getAs(Loc.class).$bool() ? evalCastFromLoc(Val.castAs(Loc.class), new QualType(CastTy)) : evalCastFromNonLoc(Val.castAs(NonLoc.class), new QualType(CastTy));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleSValBuilder::evalCastFromNonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp", line = 68,
   FQN="(anonymous namespace)::SimpleSValBuilder::evalCastFromNonLoc", NM="_ZN12_GLOBAL__N_117SimpleSValBuilder18evalCastFromNonLocEN5clang4ento6NonLocENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp -nm=_ZN12_GLOBAL__N_117SimpleSValBuilder18evalCastFromNonLocEN5clang4ento6NonLocENS1_8QualTypeE")
  //</editor-fold>
  @Override protected SVal evalCastFromNonLoc(NonLoc val, QualType castTy)/* override*/ {
    
    boolean isLocType = Loc.isLocType(new QualType(castTy));
    {
      
      Optional<NsNonloc.LocAsInteger> LI = val.getAs(NsNonloc.LocAsInteger.class);
      if (LI.$bool()) {
        if (isLocType) {
          return new SVal(JD$Move.INSTANCE, LI.$arrow().getLoc());
        }
        
        // FIXME: Correctly support promotions/truncations.
        /*uint*/int castSize = $ulong2uint(Context.getTypeSize(new QualType(castTy)));
        if (castSize == LI.$arrow().getNumBits()) {
          return new SVal(val);
        }
        return new SVal(JD$Move.INSTANCE, makeLocAsInteger(LI.$arrow().getLoc(), castSize));
      }
    }
    {
      
      /*const*/ SymExpr /*P*/ se = val.getAsSymbolicExpression();
      if ((se != null)) {
        QualType T = Context.getCanonicalType(se.getType()).$QualType();
        // If types are the same or both are integers, ignore the cast.
        // FIXME: Remove this hack when we support symbolic truncation/extension.
        // HACK: If both castTy and T are integers, ignore the cast.  This is
        // not a permanent solution.  Eventually we want to precisely handle
        // extension/truncation of symbolic integers.  This prevents us from losing
        // precision when we assign 'x = y' and 'y' is symbolic and x and y are
        // different integer types.
        if (haveSameType(new QualType(T), new QualType(castTy))) {
          return new SVal(val);
        }
        if (!isLocType) {
          return new SVal(JD$Move.INSTANCE, makeNonLoc(se, new QualType(T), new QualType(castTy)));
        }
        return new SVal(JD$Move.INSTANCE, new UnknownVal());
      }
    }
    
    // If value is a non-integer constant, produce unknown.
    if (!val.getAs(NsNonloc.ConcreteInt.class).$bool()) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    // Handle casts to a boolean type.
    if (castTy.$arrow().isBooleanType()) {
      boolean b = val.castAs(NsNonloc.ConcreteInt.class).getValue().getBoolValue();
      return new SVal(JD$Move.INSTANCE, makeTruthVal(b, new QualType(castTy)));
    }
    
    // Only handle casts from integers to integers - if val is an integer constant
    // being cast to a non-integer type, produce unknown.
    if (!isLocType && !castTy.$arrow().isIntegralOrEnumerationType()) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    APSInt i = new APSInt(val.castAs(NsNonloc.ConcreteInt.class).getValue());
    BasicVals.getAPSIntType(new QualType(castTy)).apply(i);
    if (isLocType) {
      return new SVal(JD$Move.INSTANCE, makeIntLocVal(i));
    } else {
      return new SVal(JD$Move.INSTANCE, makeIntVal(i));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleSValBuilder::evalCastFromLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp", line = 124,
   FQN="(anonymous namespace)::SimpleSValBuilder::evalCastFromLoc", NM="_ZN12_GLOBAL__N_117SimpleSValBuilder15evalCastFromLocEN5clang4ento3LocENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp -nm=_ZN12_GLOBAL__N_117SimpleSValBuilder15evalCastFromLocEN5clang4ento3LocENS1_8QualTypeE")
  //</editor-fold>
  @Override protected SVal evalCastFromLoc(Loc val, QualType castTy)/* override*/ {
    
    // Casts from pointers -> pointers, just return the lval.
    //
    // Casts from pointers -> references, just return the lval.  These
    //   can be introduced by the frontend for corner cases, e.g
    //   casting from va_list* to __builtin_va_list&.
    //
    if (Loc.isLocType(new QualType(castTy)) || castTy.$arrow().isReferenceType()) {
      return new SVal(val);
    }
    
    // FIXME: Handle transparent unions where a value can be "transparently"
    //  lifted into a union type.
    if (castTy.$arrow().isUnionType()) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    // Casting a Loc to a bool will almost always be true,
    // unless this is a weak function or a symbolic region.
    if (castTy.$arrow().isBooleanType()) {
      switch (NsLoc.Kind.valueOf(val.getSubKind())) {
       case MemRegionValKind:
        {
          /*const*/ MemRegion /*P*/ R = val.castAs(NsLoc.MemRegionVal.class).getRegion();
          {
            /*const*/ FunctionCodeRegion /*P*/ FTR = dyn_cast_FunctionCodeRegion(R);
            if ((FTR != null)) {
              {
                /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(FTR.getDecl());
                if ((FD != null)) {
                  if (FD.isWeak()) {
                    // FIXME: Currently we are using an extent symbol here,
                    // because there are no generic region address metadata
                    // symbols to use, only content metadata.
                    return new SVal(JD$Move.INSTANCE, new NsNonloc.SymbolVal(SymMgr.getExtentSymbol(FTR)));
                  }
                }
              }
            }
          }
          {
            
            /*const*/ SymbolicRegion /*P*/ SymR = R.getSymbolicBase();
            if ((SymR != null)) {
              return new SVal(JD$Move.INSTANCE, new NsNonloc.SymbolVal(SymR.getSymbol()));
            }
          }
          // FALL-THROUGH
        }
       case GotoLabelKind:
        // Labels and non-symbolic memory regions are always true.
        return new SVal(JD$Move.INSTANCE, makeTruthVal(true, new QualType(castTy)));
      }
    }
    if (castTy.$arrow().isIntegralOrEnumerationType()) {
      /*uint*/int BitWidth = $ulong2uint(Context.getTypeSize(new QualType(castTy)));
      if (!val.getAs(NsLoc.ConcreteInt.class).$bool()) {
        return new SVal(JD$Move.INSTANCE, makeLocAsInteger(new Loc(val), BitWidth));
      }
      
      APSInt i = new APSInt(val.castAs(NsLoc.ConcreteInt.class).getValue());
      BasicVals.getAPSIntType(new QualType(castTy)).apply(i);
      return new SVal(JD$Move.INSTANCE, makeIntVal(i));
    }
    
    // All other cases: return 'UnknownVal'.  This includes casting pointers
    // to floats, which is probably badness it itself, but this is a good
    // intermediate solution until we do something better.
    return new SVal(JD$Move.INSTANCE, new UnknownVal());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleSValBuilder::SimpleSValBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp", line = 29,
   FQN="(anonymous namespace)::SimpleSValBuilder::SimpleSValBuilder", NM="_ZN12_GLOBAL__N_117SimpleSValBuilderC1ERN4llvm20BumpPtrAllocatorImplINS1_15MallocAllocatorELj4096ELj4096EEERN5clang10ASTContextERNS6_4ento19ProgramStateManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp -nm=_ZN12_GLOBAL__N_117SimpleSValBuilderC1ERN4llvm20BumpPtrAllocatorImplINS1_15MallocAllocatorELj4096ELj4096EEERN5clang10ASTContextERNS6_4ento19ProgramStateManagerE")
  //</editor-fold>
  public SimpleSValBuilder(final BumpPtrAllocatorImpl /*&*/ alloc, final ASTContext /*&*/ context, 
      final ProgramStateManager /*&*/ stateMgr) {
    // : SValBuilder(alloc, context, stateMgr) 
    //START JInit
    super(alloc, context, stateMgr);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleSValBuilder::~SimpleSValBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp", line = 32,
   FQN="(anonymous namespace)::SimpleSValBuilder::~SimpleSValBuilder", NM="_ZN12_GLOBAL__N_117SimpleSValBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp -nm=_ZN12_GLOBAL__N_117SimpleSValBuilderD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }

  
  
  //===----------------------------------------------------------------------===//
  // Transfer function for unary operators.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleSValBuilder::evalMinus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp", line = 187,
   FQN="(anonymous namespace)::SimpleSValBuilder::evalMinus", NM="_ZN12_GLOBAL__N_117SimpleSValBuilder9evalMinusEN5clang4ento6NonLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp -nm=_ZN12_GLOBAL__N_117SimpleSValBuilder9evalMinusEN5clang4ento6NonLocE")
  //</editor-fold>
  @Override public SVal evalMinus(NonLoc val)/* override*/ {
    switch (NsNonloc.Kind.valueOf(val.getSubKind())) {
     case ConcreteIntKind:
      return new SVal(JD$Move.INSTANCE, val.castAs(NsNonloc.ConcreteInt.class).evalMinus(/*Deref*/this));
     default:
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleSValBuilder::evalComplement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp", line = 196,
   FQN="(anonymous namespace)::SimpleSValBuilder::evalComplement", NM="_ZN12_GLOBAL__N_117SimpleSValBuilder14evalComplementEN5clang4ento6NonLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp -nm=_ZN12_GLOBAL__N_117SimpleSValBuilder14evalComplementEN5clang4ento6NonLocE")
  //</editor-fold>
  @Override public SVal evalComplement(NonLoc X)/* override*/ {
    switch (NsNonloc.Kind.valueOf(X.getSubKind())) {
     case ConcreteIntKind:
      return new SVal(JD$Move.INSTANCE, X.castAs(NsNonloc.ConcreteInt.class).evalComplement(/*Deref*/this));
     default:
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleSValBuilder::evalBinOpNN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp", line = 304,
   FQN="(anonymous namespace)::SimpleSValBuilder::evalBinOpNN", NM="_ZN12_GLOBAL__N_117SimpleSValBuilder11evalBinOpNNEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS3_18BinaryOperatorKindENS4_6NonLocES9_NS3_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp -nm=_ZN12_GLOBAL__N_117SimpleSValBuilder11evalBinOpNNEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS3_18BinaryOperatorKindENS4_6NonLocES9_NS3_8QualTypeE")
  //</editor-fold>
  @Override public SVal evalBinOpNN(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
             BinaryOperatorKind op, 
             NonLoc lhs, NonLoc rhs, 
             QualType resultTy)/* override*/ {
    NonLoc InputLHS = new NonLoc(lhs);
    NonLoc InputRHS = new NonLoc(rhs);
    
    // Handle trivial case where left-side and right-side are the same.
    if (lhs.$eq(rhs)) {
      switch (op) {
       default:
        break;
       case BO_EQ:
       case BO_LE:
       case BO_GE:
        return new SVal(JD$Move.INSTANCE, makeTruthVal(true, new QualType(resultTy)));
       case BO_LT:
       case BO_GT:
       case BO_NE:
        return new SVal(JD$Move.INSTANCE, makeTruthVal(false, new QualType(resultTy)));
       case BO_Xor:
       case BO_Sub:
        if (resultTy.$arrow().isIntegralOrEnumerationType()) {
          return new SVal(JD$Move.INSTANCE, makeIntVal($int2ulong(0), new QualType(resultTy)));
        }
        return evalCastFromNonLoc(makeIntVal($int2ulong(0), /*Unsigned=*/ false), new QualType(resultTy));
       case BO_Or:
       case BO_And:
        return evalCastFromNonLoc(new NonLoc(lhs), new QualType(resultTy));
      }
    }
    while (true) {
      switch (NsNonloc.Kind.valueOf(lhs.getSubKind())) {
       default:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(makeSymExprValNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), op, new NonLoc(lhs), new NonLoc(rhs), new QualType(resultTy)));
          } finally {
            $c$.$destroy();
          }
        }
       case LocAsIntegerKind:
        {
          Loc lhsL = lhs.castAs(NsNonloc.LocAsInteger.class).getLoc();
          switch (NsNonloc.Kind.valueOf(rhs.getSubKind())) {
           case LocAsIntegerKind:
            {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                return $c$.clean(evalBinOpLL($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), op, new Loc(lhsL), 
                    rhs.castAs(NsNonloc.LocAsInteger.class).getLoc(), 
                    new QualType(resultTy)));
              } finally {
                $c$.$destroy();
              }
            }
           case ConcreteIntKind:
            {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                // Transform the integer into a location and compare.
                APSInt i = new APSInt(rhs.castAs(NsNonloc.ConcreteInt.class).getValue());
                BasicVals.getAPSIntType(Context.VoidPtrTy.$QualType()).apply(i);
                return $c$.clean(evalBinOpLL($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), op, new Loc(lhsL), makeLoc(i), new QualType(resultTy)));
              } finally {
                $c$.$destroy();
              }
            }
           default:
            switch (op) {
             case BO_EQ:
              return new SVal(JD$Move.INSTANCE, makeTruthVal(false, new QualType(resultTy)));
             case BO_NE:
              return new SVal(JD$Move.INSTANCE, makeTruthVal(true, new QualType(resultTy)));
             default:
              {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  // This case also handles pointer arithmetic.
                  return $c$.clean(makeSymExprValNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), op, new NonLoc(InputLHS), new NonLoc(InputRHS), new QualType(resultTy)));
                } finally {
                  $c$.$destroy();
                }
              }
            }
          }
        }
       case ConcreteIntKind:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            APSInt LHSValue = new APSInt(lhs.castAs(NsNonloc.ConcreteInt.class).getValue());
            {
              
              // If we're dealing with two known constants, just perform the operation.
              /*const*/ APSInt /*P*/ KnownRHSValue = $c$.clean(getKnownValue($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(rhs)));
              if ((KnownRHSValue != null)) {
                APSInt RHSValue = new APSInt($Deref(KnownRHSValue));
                if (BinaryOperator.isComparisonOp(op)) {
                  // We're looking for a type big enough to compare the two values.
                  // FIXME: This is not correct. char + short will result in a promotion
                  // to int. Unfortunately we have lost types by this point.
                  APSIntType CompareType = new APSIntType(std.max(new APSIntType(LHSValue), 
                          new APSIntType(RHSValue)));
                  CompareType.apply(LHSValue);
                  CompareType.apply(RHSValue);
                } else if (!BinaryOperator.isShiftOp(op)) {
                  APSIntType IntType = BasicVals.getAPSIntType(new QualType(resultTy));
                  IntType.apply(LHSValue);
                  IntType.apply(RHSValue);
                }
                
                /*const*/ APSInt /*P*/ Result = BasicVals.evalAPSInt(op, LHSValue, RHSValue);
                if (!(Result != null)) {
                  return new SVal(JD$Move.INSTANCE, new UndefinedVal());
                }
                
                return new SVal(JD$Move.INSTANCE, new NsNonloc.ConcreteInt($Deref(Result)));
              }
            }
            
            // Swap the left and right sides and flip the operator if doing so
            // allows us to better reason about the expression (this is a form
            // of expression canonicalization).
            // While we're at it, catch some special cases for non-commutative ops.
            switch (op) {
             case BO_LT:
             case BO_GT:
             case BO_LE:
             case BO_GE:
              op = BinaryOperator.reverseComparisonOp(op);
             case BO_EQ:
             case BO_NE:
             case BO_Add:
             case BO_Mul:
             case BO_And:
             case BO_Xor:
             case BO_Or:
              // FALL-THROUGH
              std.swap(lhs, rhs);
              continue;
             case BO_Shr:
              // (~0)>>a
              if (LHSValue.isAllOnesValue() && LHSValue.isSigned()) {
                return evalCastFromNonLoc(new NonLoc(lhs), new QualType(resultTy));
              }
             case BO_Shl:
              // 0<<a and 0>>a
              if (LHSValue.$eq(0)) {
                return evalCastFromNonLoc(new NonLoc(lhs), new QualType(resultTy));
              }
              return $c$.clean(makeSymExprValNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), op, new NonLoc(InputLHS), new NonLoc(InputRHS), new QualType(resultTy)));
             default:
              return $c$.clean(makeSymExprValNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), op, new NonLoc(InputLHS), new NonLoc(InputRHS), new QualType(resultTy)));
            }
          } finally {
            $c$.$destroy();
          }
        }
       case SymbolValKind:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // We only handle LHS as simple symbols or SymIntExprs.
            /*const*/ SymExpr /*P*/ Sym = lhs.castAs(NsNonloc.SymbolVal.class).getSymbol();
            {
              
              // LHS is a symbolic expression.
              /*const*/ SymIntExpr /*P*/ symIntExpr = dyn_cast_SymIntExpr(Sym);
              if ((symIntExpr != null)) {
                
                // Is this a logical not? (!x is represented as x == 0.)
                if (op == BinaryOperatorKind.BO_EQ && rhs.isZeroConstant()) {
                  // We know how to negate certain expressions. Simplify them here.
                  BinaryOperatorKind opc = symIntExpr.getOpcode();
                  switch (opc) {
                   default:
                    // We don't know how to negate this operation.
                    // Just handle it as if it were a normal comparison to 0.
                    break;
                   case BO_LAnd:
                   case BO_LOr:
                    throw new llvm_unreachable("Logical operators handled by branching logic.");
                   case BO_Assign:
                   case BO_MulAssign:
                   case BO_DivAssign:
                   case BO_RemAssign:
                   case BO_AddAssign:
                   case BO_SubAssign:
                   case BO_ShlAssign:
                   case BO_ShrAssign:
                   case BO_AndAssign:
                   case BO_XorAssign:
                   case BO_OrAssign:
                   case BO_Comma:
                    throw new llvm_unreachable("'=' and ',' operators handled by ExprEngine.");
                   case BO_PtrMemD:
                   case BO_PtrMemI:
                    throw new llvm_unreachable("Pointer arithmetic not handled here.");
                   case BO_LT:
                   case BO_GT:
                   case BO_LE:
                   case BO_GE:
                   case BO_EQ:
                   case BO_NE:
                    assert (resultTy.$arrow().isBooleanType() || QualType.$eq_QualType$C(resultTy, getConditionType()));
                    assert (symIntExpr.getType().$arrow().isBooleanType() || getContext().hasSameUnqualifiedType(symIntExpr.getType(), getConditionType()));
                    // Negate the comparison and make a value.
                    opc = BinaryOperator.negateComparisonOp(opc);
                    return new SVal(JD$Move.INSTANCE, makeNonLoc(symIntExpr.getLHS(), opc, 
                            symIntExpr.getRHS(), new QualType(resultTy)));
                  }
                }
                {
                  
                  // For now, only handle expressions whose RHS is a constant.
                  /*const*/ APSInt /*P*/ RHSValue = $c$.clean(getKnownValue($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(rhs)));
                  if ((RHSValue != null)) {
                    // If both the LHS and the current expression are additive,
                    // fold their constants and try again.
                    if (BinaryOperator.isAdditiveOp(op)) {
                      BinaryOperatorKind lop = symIntExpr.getOpcode();
                      if (BinaryOperator.isAdditiveOp(lop)) {
                        // Convert the two constants to a common type, then combine them.
                        
                        // resultTy may not be the best type to convert to, but it's
                        // probably the best choice in expressions with mixed type
                        // (such as x+1U+2LL). The rules for implicit conversions should
                        // choose a reasonable type to preserve the expression, and will
                        // at least match how the value is going to be used.
                        APSIntType IntType = BasicVals.getAPSIntType(new QualType(resultTy));
                        final /*const*/ APSInt /*&*/ first = IntType.convert(symIntExpr.getRHS());
                        final /*const*/ APSInt /*&*/ second = IntType.convert($Deref(RHSValue));
                        
                        /*const*/ APSInt /*P*/ newRHS;
                        if (lop == op) {
                          newRHS = BasicVals.evalAPSInt(BinaryOperatorKind.BO_Add, first, second);
                        } else {
                          newRHS = BasicVals.evalAPSInt(BinaryOperatorKind.BO_Sub, first, second);
                        }
                        assert ((newRHS != null)) : "Invalid operation despite common type!";
                        rhs.$assignMove(new NsNonloc.ConcreteInt($Deref(newRHS)));
                        lhs.$assignMove(new NsNonloc.SymbolVal(symIntExpr.getLHS()));
                        op = lop;
                        continue;
                      }
                    }
                    
                    // Otherwise, make a SymIntExpr out of the expression.
                    return MakeSymIntVal(symIntExpr, op, $Deref(RHSValue), new QualType(resultTy));
                  }
                }
              }
            }
            
            // Does the symbolic expression simplify to a constant?
            // If so, "fold" the constant by setting 'lhs' to a ConcreteInt
            // and try again.
            final ConstraintManager /*&*/ CMgr = state.$arrow().getConstraintManager();
            {
              /*const*/ APSInt /*P*/ Constant = $c$.clean(CMgr.getSymVal($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym));
              if ((Constant != null)) {
                lhs.$assignMove(new NsNonloc.ConcreteInt($Deref(Constant)));
                continue;
              }
            }
            {
              
              // Is the RHS a constant?
              /*const*/ APSInt /*P*/ RHSValue = $c$.clean(getKnownValue($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(rhs)));
              if ((RHSValue != null)) {
                return MakeSymIntVal(Sym, op, $Deref(RHSValue), new QualType(resultTy));
              }
            }
            
            // Give up -- this is not a symbolic expression we can handle.
            return $c$.clean(makeSymExprValNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), op, new NonLoc(InputLHS), new NonLoc(InputRHS), new QualType(resultTy)));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  } 

  
  // FIXME: all this logic will change if/when we have MemRegion::getLocation().
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleSValBuilder::evalBinOpLL">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp", line = 583,
   FQN="(anonymous namespace)::SimpleSValBuilder::evalBinOpLL", NM="_ZN12_GLOBAL__N_117SimpleSValBuilder11evalBinOpLLEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS3_18BinaryOperatorKindENS4_3LocES9_NS3_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp -nm=_ZN12_GLOBAL__N_117SimpleSValBuilder11evalBinOpLLEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS3_18BinaryOperatorKindENS4_3LocES9_NS3_8QualTypeE")
  //</editor-fold>
  @Override public SVal evalBinOpLL(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
             BinaryOperatorKind op, 
             Loc lhs, Loc rhs, 
             QualType resultTy)/* override*/ {
    // Only comparisons and subtractions are valid operations on two pointers.
    // See [C99 6.5.5 through 6.5.14] or [C++0x 5.6 through 5.15].
    // However, if a pointer is casted to an integer, evalBinOpNN may end up
    // calling this function with another operation (PR7527). We don't attempt to
    // model this for now, but it could be useful, particularly when the
    // "location" is actually an integer value that's been passed through a void*.
    if (!(BinaryOperator.isComparisonOp(op) || op == BinaryOperatorKind.BO_Sub)) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    // Special cases for when both sides are identical.
    if (lhs.$eq(rhs)) {
      switch (op) {
       default:
        throw new llvm_unreachable("Unimplemented operation for two identical values");
       case BO_Sub:
        return new SVal(JD$Move.INSTANCE, makeZeroVal(new QualType(resultTy)));
       case BO_EQ:
       case BO_LE:
       case BO_GE:
        return new SVal(JD$Move.INSTANCE, makeTruthVal(true, new QualType(resultTy)));
       case BO_NE:
       case BO_LT:
       case BO_GT:
        return new SVal(JD$Move.INSTANCE, makeTruthVal(false, new QualType(resultTy)));
      }
    }
    switch (NsLoc.Kind.valueOf(lhs.getSubKind())) {
     default:
      throw new llvm_unreachable("Ordering not implemented for this Loc.");
     case GotoLabelKind:
      // The only thing we know about labels is that they're non-null.
      if (rhs.isZeroConstant()) {
        switch (op) {
         default:
          break;
         case BO_Sub:
          return evalCastFromLoc(new Loc(lhs), new QualType(resultTy));
         case BO_EQ:
         case BO_LE:
         case BO_LT:
          return new SVal(JD$Move.INSTANCE, makeTruthVal(false, new QualType(resultTy)));
         case BO_NE:
         case BO_GT:
         case BO_GE:
          return new SVal(JD$Move.INSTANCE, makeTruthVal(true, new QualType(resultTy)));
        }
      }
      // There may be two labels for the same location, and a function region may
      // have the same address as a label at the start of the function (depending
      // on the ABI).
      // FIXME: we can probably do a comparison against other MemRegions, though.
      // FIXME: is there a way to tell if two labels refer to the same location?
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
     case ConcreteIntKind:
      {
        {
          // If one of the operands is a symbol and the other is a constant,
          // build an expression for use by the constraint manager.
          /*const*/ SymExpr /*P*/ rSym = rhs.getAsLocSymbol();
          if ((rSym != null)) {
            // We can only build expressions with symbols on the left,
            // so we need a reversible operator.
            if (!BinaryOperator.isComparisonOp(op)) {
              return new SVal(JD$Move.INSTANCE, new UnknownVal());
            }
            
            final /*const*/ APSInt /*&*/ lVal = lhs.castAs(NsLoc.ConcreteInt.class).getValue();
            op = BinaryOperator.reverseComparisonOp(op);
            return new SVal(JD$Move.INSTANCE, makeNonLoc(rSym, op, lVal, new QualType(resultTy)));
          }
        }
        {
          
          // If both operands are constants, just perform the operation.
          Optional<NsLoc.ConcreteInt> rInt = rhs.getAs(NsLoc.ConcreteInt.class);
          if (rInt.$bool()) {
            SVal ResultVal = lhs.castAs(NsLoc.ConcreteInt.class).evalBinOp(BasicVals, op, rInt.$star());
            {
              Optional<NonLoc> Result = ResultVal.getAs(NonLoc.class);
              if (Result.$bool()) {
                return evalCastFromNonLoc(new NonLoc(Result.$star()), new QualType(resultTy));
              }
            }
            assert (!ResultVal.getAs(Loc.class).$bool()) : "Loc-Loc ops should not produce Locs";
            return new SVal(JD$Move.INSTANCE, new UnknownVal());
          }
        }
        
        // Special case comparisons against NULL.
        // This must come after the test if the RHS is a symbol, which is used to
        // build constraints. The address of any non-symbolic region is guaranteed
        // to be non-NULL, as is any label.
        assert (rhs.getAs(NsLoc.MemRegionVal.class).$bool() || rhs.getAs(NsLoc.GotoLabel.class).$bool());
        if (lhs.isZeroConstant()) {
          switch (op) {
           default:
            break;
           case BO_EQ:
           case BO_GT:
           case BO_GE:
            return new SVal(JD$Move.INSTANCE, makeTruthVal(false, new QualType(resultTy)));
           case BO_NE:
           case BO_LT:
           case BO_LE:
            return new SVal(JD$Move.INSTANCE, makeTruthVal(true, new QualType(resultTy)));
          }
        }
        
        // Comparing an arbitrary integer to a region or label address is
        // completely unknowable.
        return new SVal(JD$Move.INSTANCE, new UnknownVal());
      }
     case MemRegionValKind:
      {
        {
          Optional<NsLoc.ConcreteInt> rInt = rhs.getAs(NsLoc.ConcreteInt.class);
          if (rInt.$bool()) {
            {
              // If one of the operands is a symbol and the other is a constant,
              // build an expression for use by the constraint manager.
              /*const*/ SymExpr /*P*/ lSym = lhs.getAsLocSymbol(true);
              if ((lSym != null)) {
                return MakeSymIntVal(lSym, op, rInt.$arrow().getValue(), new QualType(resultTy));
              }
            }
            
            // Special case comparisons to NULL.
            // This must come after the test if the LHS is a symbol, which is used to
            // build constraints. The address of any non-symbolic region is guaranteed
            // to be non-NULL.
            if (rInt.$arrow().isZeroConstant()) {
              if (op == BinaryOperatorKind.BO_Sub) {
                return evalCastFromLoc(new Loc(lhs), new QualType(resultTy));
              }
              if (BinaryOperator.isComparisonOp(op)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  QualType boolType = getContext().BoolTy.$QualType();
                  NonLoc l = evalCastFromLoc(new Loc(lhs), new QualType(boolType)).castAs(NonLoc.class);
                  NonLoc r = makeTruthVal(false, new QualType(boolType)).castAs(NonLoc.class);
                  return $c$.clean(evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), op, new NonLoc(l), new NonLoc(r), new QualType(resultTy)));
                } finally {
                  $c$.$destroy();
                }
              }
            }
            
            // Comparing a region to an arbitrary integer is completely unknowable.
            return new SVal(JD$Move.INSTANCE, new UnknownVal());
          }
        }
        
        // Get both values as regions, if possible.
        /*const*/ MemRegion /*P*/ LeftMR = lhs.getAsRegion();
        assert ((LeftMR != null)) : "MemRegionValKind SVal doesn't have a region!";
        
        /*const*/ MemRegion /*P*/ RightMR = rhs.getAsRegion();
        if (!(RightMR != null)) {
          // The RHS is probably a label, which in theory could address a region.
          // FIXME: we can probably make a more useful statement about non-code
          // regions, though.
          return new SVal(JD$Move.INSTANCE, new UnknownVal());
        }
        
        /*const*/ MemRegion /*P*/ LeftBase = LeftMR.getBaseRegion();
        /*const*/ MemRegion /*P*/ RightBase = RightMR.getBaseRegion();
        /*const*/ MemSpaceRegion /*P*/ LeftMS = LeftBase.getMemorySpace();
        /*const*/ MemSpaceRegion /*P*/ RightMS = RightBase.getMemorySpace();
        /*const*/ MemSpaceRegion /*P*/ UnknownMS = MemMgr.getUnknownRegion();
        
        // If the two regions are from different known memory spaces they cannot be
        // equal. Also, assume that no symbolic region (whose memory space is
        // unknown) is on the stack.
        if (LeftMS != RightMS
           && ((LeftMS != UnknownMS && RightMS != UnknownMS)
           || (isa_StackSpaceRegion(LeftMS) || isa_StackSpaceRegion(RightMS)))) {
          switch (op) {
           default:
            return new SVal(JD$Move.INSTANCE, new UnknownVal());
           case BO_EQ:
            return new SVal(JD$Move.INSTANCE, makeTruthVal(false, new QualType(resultTy)));
           case BO_NE:
            return new SVal(JD$Move.INSTANCE, makeTruthVal(true, new QualType(resultTy)));
          }
        }
        
        // If both values wrap regions, see if they're from different base regions.
        // Note, heap base symbolic regions are assumed to not alias with
        // each other; for example, we assume that malloc returns different address
        // on each invocation.
        if (LeftBase != RightBase
           && ((!isa_SymbolicRegion(LeftBase) && !isa_SymbolicRegion(RightBase))
           || (isa_HeapSpaceRegion(LeftMS) || isa_HeapSpaceRegion(RightMS)))) {
          switch (op) {
           default:
            return new SVal(JD$Move.INSTANCE, new UnknownVal());
           case BO_EQ:
            return new SVal(JD$Move.INSTANCE, makeTruthVal(false, new QualType(resultTy)));
           case BO_NE:
            return new SVal(JD$Move.INSTANCE, makeTruthVal(true, new QualType(resultTy)));
          }
        }
        
        // Handle special cases for when both regions are element regions.
        /*const*/ ElementRegion /*P*/ RightER = dyn_cast_ElementRegion(RightMR);
        /*const*/ ElementRegion /*P*/ LeftER = dyn_cast_ElementRegion(LeftMR);
        if ((RightER != null) && (LeftER != null)) {
          // Next, see if the two ERs have the same super-region and matching types.
          // FIXME: This should do something useful even if the types don't match,
          // though if both indexes are constant the RegionRawOffset path will
          // give the correct answer.
          if (LeftER.getSuperRegion() == RightER.getSuperRegion()
             && QualType.$eq_QualType$C(LeftER.getElementType(), RightER.getElementType())) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // Get the left index and cast it to the correct type.
              // If the index is unknown or undefined, bail out here.
              SVal LeftIndexVal = new SVal(JD$Move.INSTANCE, LeftER.getIndex());
              Optional<NonLoc> LeftIndex = LeftIndexVal.getAs(NonLoc.class);
              if (!LeftIndex.$bool()) {
                return new SVal(JD$Move.INSTANCE, new UnknownVal());
              }
              LeftIndexVal.$assignMove(evalCastFromNonLoc(new NonLoc(LeftIndex.$star()), new QualType(ArrayIndexTy)));
              LeftIndex.$assignMove(LeftIndexVal.getAs(NonLoc.class));
              if (!LeftIndex.$bool()) {
                return new SVal(JD$Move.INSTANCE, new UnknownVal());
              }
              
              // Do the same for the right index.
              SVal RightIndexVal = new SVal(JD$Move.INSTANCE, RightER.getIndex());
              Optional<NonLoc> RightIndex = RightIndexVal.getAs(NonLoc.class);
              if (!RightIndex.$bool()) {
                return new SVal(JD$Move.INSTANCE, new UnknownVal());
              }
              RightIndexVal.$assignMove(evalCastFromNonLoc(new NonLoc(RightIndex.$star()), new QualType(ArrayIndexTy)));
              RightIndex.$assignMove(RightIndexVal.getAs(NonLoc.class));
              if (!RightIndex.$bool()) {
                return new SVal(JD$Move.INSTANCE, new UnknownVal());
              }
              
              // Actually perform the operation.
              // evalBinOpNN expects the two indexes to already be the right type.
              return $c$.clean(evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), op, new NonLoc(LeftIndex.$star()), new NonLoc(RightIndex.$star()), new QualType(resultTy)));
            } finally {
              $c$.$destroy();
            }
          }
        }
        
        // Special handling of the FieldRegions, even with symbolic offsets.
        /*const*/ FieldRegion /*P*/ RightFR = dyn_cast_FieldRegion(RightMR);
        /*const*/ FieldRegion /*P*/ LeftFR = dyn_cast_FieldRegion(LeftMR);
        if ((RightFR != null) && (LeftFR != null)) {
          SVal R = SimpleSValBuilderStatics.evalBinOpFieldRegionFieldRegion(LeftFR, RightFR, op, new QualType(resultTy), 
              /*Deref*/this);
          if (!R.isUnknown$SVal()) {
            return R;
          }
        }
        
        // Compare the regions using the raw offsets.
        RegionOffset LeftOffset = LeftMR.getAsOffset();
        RegionOffset RightOffset = RightMR.getAsOffset();
        if (LeftOffset.getRegion() != null
           && LeftOffset.getRegion() == RightOffset.getRegion()
           && !LeftOffset.hasSymbolicOffset() && !RightOffset.hasSymbolicOffset()) {
          long/*int64_t*/ left = LeftOffset.getOffset();
          long/*int64_t*/ right = RightOffset.getOffset();
          switch (op) {
           default:
            return new SVal(JD$Move.INSTANCE, new UnknownVal());
           case BO_LT:
            return new SVal(JD$Move.INSTANCE, makeTruthVal(left < right, new QualType(resultTy)));
           case BO_GT:
            return new SVal(JD$Move.INSTANCE, makeTruthVal(left > right, new QualType(resultTy)));
           case BO_LE:
            return new SVal(JD$Move.INSTANCE, makeTruthVal(left <= right, new QualType(resultTy)));
           case BO_GE:
            return new SVal(JD$Move.INSTANCE, makeTruthVal(left >= right, new QualType(resultTy)));
           case BO_EQ:
            return new SVal(JD$Move.INSTANCE, makeTruthVal(left == right, new QualType(resultTy)));
           case BO_NE:
            return new SVal(JD$Move.INSTANCE, makeTruthVal(left != right, new QualType(resultTy)));
          }
        }
        
        // At this point we're not going to get a good answer, but we can try
        // conjuring an expression instead.
        /*const*/ SymExpr /*P*/ LHSSym = lhs.getAsLocSymbol();
        /*const*/ SymExpr /*P*/ RHSSym = rhs.getAsLocSymbol();
        if ((LHSSym != null) && (RHSSym != null)) {
          return new SVal(JD$Move.INSTANCE, makeNonLoc(LHSSym, op, RHSSym, new QualType(resultTy)));
        }
        
        // If we get here, we have no way of comparing the regions.
        return new SVal(JD$Move.INSTANCE, new UnknownVal());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleSValBuilder::evalBinOpLN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp", line = 857,
   FQN="(anonymous namespace)::SimpleSValBuilder::evalBinOpLN", NM="_ZN12_GLOBAL__N_117SimpleSValBuilder11evalBinOpLNEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS3_18BinaryOperatorKindENS4_3LocENS4_6NonLocENS3_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp -nm=_ZN12_GLOBAL__N_117SimpleSValBuilder11evalBinOpLNEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS3_18BinaryOperatorKindENS4_3LocENS4_6NonLocENS3_8QualTypeE")
  //</editor-fold>
  @Override public SVal evalBinOpLN(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
             BinaryOperatorKind op, 
             Loc lhs, NonLoc rhs, QualType resultTy)/* override*/ {
    assert (!BinaryOperator.isComparisonOp(op)) : "arguments to comparison ops must be of the same type";
    
    // Special case: rhs is a zero constant.
    if (rhs.isZeroConstant()) {
      return new SVal(lhs);
    }
    {
      
      // We are dealing with pointer arithmetic.
      
      // Handle pointer arithmetic on constant values.
      Optional<NsNonloc.ConcreteInt> rhsInt = rhs.getAs(NsNonloc.ConcreteInt.class);
      if (rhsInt.$bool()) {
        {
          Optional<NsLoc.ConcreteInt> lhsInt = lhs.getAs(NsLoc.ConcreteInt.class);
          if (lhsInt.$bool()) {
            final /*const*/ APSInt /*&*/ leftI = lhsInt.$arrow().getValue();
            assert (leftI.isUnsigned());
            APSInt rightI/*J*/= new APSInt(new APInt(rhsInt.$arrow().getValue()), /* isUnsigned */ true);
            
            // Convert the bitwidth of rightI.  This should deal with overflow
            // since we are dealing with concrete values.
            rightI.$assignMove(rightI.extOrTrunc(leftI.getBitWidth()));
            
            // Offset the increment by the pointer size.
            APSInt Multiplicand/*J*/= new APSInt(rightI.getBitWidth(), /* isUnsigned */ true);
            rightI.$starassign(Multiplicand);
            
            // Compute the adjusted pointer.
            switch (op) {
             case BO_Add:
              rightI.$assignMove(leftI.$add(rightI));
              break;
             case BO_Sub:
              rightI.$assignMove(leftI.$sub(rightI));
              break;
             default:
              throw new llvm_unreachable("Invalid pointer arithmetic operation");
            }
            return new SVal(JD$Move.INSTANCE, new NsLoc.ConcreteInt(getBasicValueFactory().getValue(rightI)));
          }
        }
      }
    }
    {
      
      // Handle cases where 'lhs' is a region.
      /*const*/ MemRegion /*P*/ region = lhs.getAsRegion();
      if ((region != null)) {
        rhs.$assignMove(convertToArrayIndex(new SVal(rhs)).castAs(NonLoc.class));
        SVal index = new SVal(JD$Move.INSTANCE, new UnknownVal());
        /*const*/ MemRegion /*P*/ superR = null;
        QualType elementType/*J*/= new QualType();
        {
          
          /*const*/ ElementRegion /*P*/ elemReg = dyn_cast_ElementRegion(region);
          if ((elemReg != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              assert (op == BinaryOperatorKind.BO_Add || op == BinaryOperatorKind.BO_Sub);
              $c$.clean(index.$assignMove(evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), op, elemReg.getIndex(), new NonLoc(rhs), 
                      getArrayIndexType())));
              superR = elemReg.getSuperRegion();
              elementType.$assignMove(elemReg.getElementType());
            } finally {
              $c$.$destroy();
            }
          } else if (isa_SubRegion(region)) {
            assert (op == BinaryOperatorKind.BO_Add || op == BinaryOperatorKind.BO_Sub);
            index.$assignMove((op == BinaryOperatorKind.BO_Add) ? new SVal(rhs) : evalMinus(new NonLoc(rhs)));
            superR = region;
            if (resultTy.$arrow().isAnyPointerType()) {
              elementType.$assignMove(resultTy.$arrow().getPointeeType());
            }
          }
        }
        {
          
          Optional<NonLoc> indexV = index.getAs(NonLoc.class);
          if (indexV.$bool()) {
            return new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(MemMgr.getElementRegion(new QualType(elementType), new NonLoc(indexV.$star()), 
                        superR, getContext())));
          }
        }
      }
    }
    return new SVal(JD$Move.INSTANCE, new UnknownVal());
  }

  
  /// getKnownValue - evaluates a given SVal. If the SVal has only one possible
  ///  (integer) value, that value is returned. Otherwise, returns NULL.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleSValBuilder::getKnownValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp", line = 929,
   FQN="(anonymous namespace)::SimpleSValBuilder::getKnownValue", NM="_ZN12_GLOBAL__N_117SimpleSValBuilder13getKnownValueEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS4_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp -nm=_ZN12_GLOBAL__N_117SimpleSValBuilder13getKnownValueEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS4_4SValE")
  //</editor-fold>
  @Override public /*const*/ APSInt /*P*/ getKnownValue(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
               SVal V)/* override*/ {
    if (V.isUnknownOrUndef$SVal()) {
      return null;
    }
    {
      
      Optional<NsLoc.ConcreteInt> X = V.getAs(NsLoc.ConcreteInt.class);
      if (X.$bool()) {
        return $AddrOf(X.$arrow().getValue());
      }
    }
    {
      
      Optional<NsNonloc.ConcreteInt> X = V.getAs(NsNonloc.ConcreteInt.class);
      if (X.$bool()) {
        return $AddrOf(X.$arrow().getValue());
      }
    }
    {
      
      /*const*/ SymExpr /*P*/ Sym = V.getAsSymbol();
      if ((Sym != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(state.$arrow().getConstraintManager().getSymVal($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Sym));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // FIXME: Add support for SymExprs.
    return null;
  }

  
  
  //===----------------------------------------------------------------------===//
  // Transfer function for binary operators.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleSValBuilder::MakeSymIntVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp", line = 209,
   FQN="(anonymous namespace)::SimpleSValBuilder::MakeSymIntVal", NM="_ZN12_GLOBAL__N_117SimpleSValBuilder13MakeSymIntValEPKN5clang4ento7SymExprENS1_18BinaryOperatorKindERKN4llvm6APSIntENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp -nm=_ZN12_GLOBAL__N_117SimpleSValBuilder13MakeSymIntValEPKN5clang4ento7SymExprENS1_18BinaryOperatorKindERKN4llvm6APSIntENS1_8QualTypeE")
  //</editor-fold>
  public SVal MakeSymIntVal(/*const*/ SymExpr /*P*/ LHS, 
               BinaryOperatorKind op, 
               final /*const*/ APSInt /*&*/ RHS, 
               QualType resultTy) {
    boolean isIdempotent = false;
    
    // Check for a few special cases with known reductions first.
    switch (op) {
     default:
      // We can't reduce this case; just treat it normally.
      break;
     case BO_Mul:
      // a*0 and a*1
      if (RHS.$eq(0)) {
        return new SVal(JD$Move.INSTANCE, makeIntVal($int2ulong(0), new QualType(resultTy)));
      } else if (RHS.$eq(1)) {
        isIdempotent = true;
      }
      break;
     case BO_Div:
      // a/0 and a/1
      if (RHS.$eq(0)) {
        // This is also handled elsewhere.
        return new SVal(JD$Move.INSTANCE, new UndefinedVal());
      } else if (RHS.$eq(1)) {
        isIdempotent = true;
      }
      break;
     case BO_Rem:
      // a%0 and a%1
      if (RHS.$eq(0)) {
        // This is also handled elsewhere.
        return new SVal(JD$Move.INSTANCE, new UndefinedVal());
      } else if (RHS.$eq(1)) {
        return new SVal(JD$Move.INSTANCE, makeIntVal($int2ulong(0), new QualType(resultTy)));
      }
      break;
     case BO_Add:
     case BO_Sub:
     case BO_Shl:
     case BO_Shr:
     case BO_Xor:
      // a+0, a-0, a<<0, a>>0, a^0
      if (RHS.$eq(0)) {
        isIdempotent = true;
      }
      break;
     case BO_And:
      // a&0 and a&(~0)
      if (RHS.$eq(0)) {
        return new SVal(JD$Move.INSTANCE, makeIntVal($int2ulong(0), new QualType(resultTy)));
      } else if (RHS.isAllOnesValue()) {
        isIdempotent = true;
      }
      break;
     case BO_Or:
      // a|0 and a|(~0)
      if (RHS.$eq(0)) {
        isIdempotent = true;
      } else if (RHS.isAllOnesValue()) {
        final /*const*/ APSInt /*&*/ Result = BasicVals.Convert(new QualType(resultTy), RHS);
        return new SVal(JD$Move.INSTANCE, new NsNonloc.ConcreteInt(Result));
      }
      break;
    }
    
    // Idempotent ops (like a*1) can still change the type of an expression.
    // Wrap the LHS up in a NonLoc again and let evalCastFromNonLoc do the
    // dirty work.
    if (isIdempotent) {
      return evalCastFromNonLoc(new NonLoc(JD$Move.INSTANCE, new NsNonloc.SymbolVal(LHS)), new QualType(resultTy));
    }
    
    // If we reach this point, the expression cannot be simplified.
    // Make a SymbolVal for the entire expression, after converting the RHS.
    /*const*/ APSInt /*P*/ ConvertedRHS = $AddrOf(RHS);
    if (BinaryOperator.isComparisonOp(op)) {
      // We're looking for a type big enough to compare the symbolic value
      // with the given constant.
      // FIXME: This is an approximation of Sema::UsualArithmeticConversions.
      final ASTContext /*&*/ Ctx = getContext();
      QualType SymbolType = LHS.getType();
      long/*uint64_t*/ ValWidth = $uint2ulong(RHS.getBitWidth());
      long/*uint64_t*/ TypeWidth = Ctx.getTypeSize(new QualType(SymbolType));
      if ($less_ulong(ValWidth, TypeWidth)) {
        // If the value is too small, extend it.
        ConvertedRHS = $AddrOf(BasicVals.Convert(new QualType(SymbolType), RHS));
      } else if (ValWidth == TypeWidth) {
        // If the value is signed but the symbol is unsigned, do the comparison
        // in unsigned space. [C99 6.3.1.8]
        // (For the opposite case, the value is already unsigned.)
        if (RHS.isSigned() && !SymbolType.$arrow().isSignedIntegerOrEnumerationType()) {
          ConvertedRHS = $AddrOf(BasicVals.Convert(new QualType(SymbolType), RHS));
        }
      }
    } else {
      ConvertedRHS = $AddrOf(BasicVals.Convert(new QualType(resultTy), RHS));
    }
    
    return new SVal(JD$Move.INSTANCE, makeNonLoc(LHS, op, $Deref(ConvertedRHS), new QualType(resultTy)));
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
