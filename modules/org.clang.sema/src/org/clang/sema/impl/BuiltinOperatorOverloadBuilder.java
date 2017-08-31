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

package org.clang.sema.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.llvm.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.SemaOverloadStatics.*;
import static org.clang.ast.java.AstTypesRTTI.*;


/// \brief Helper class to manage the addition of builtin operator overload
/// candidates. It provides shared state and utility methods used throughout
/// the process, as well as a helper method to add each group of builtin
/// operator overloads from the standard to a candidate set.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7190,
 FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilderE")
//</editor-fold>
public class BuiltinOperatorOverloadBuilder {
  // Common instance state available to all overload candidate addition methods.
  private final Sema /*&*/ S;
  private ArrayRef<Expr /*P*/ > Args;
  private Qualifiers VisibleTypeConversionsQuals;
  private boolean HasArithmeticOrEnumeralCandidateType;
  private final SmallVectorImpl<BuiltinCandidateTypeSet> /*&*/ CandidateTypes;
  private final OverloadCandidateSet /*&*/ CandidateSet;
  
  // Define some constants used to index and iterate over the arithemetic types
  // provided via the getArithmeticType() method below.
  // The "promoted arithmetic types" are the arithmetic
  // types are that preserved by promotion (C++ [over.built]p2).
  private static /*const*//*uint*/int FirstIntegralType = 4;
  private static /*const*//*uint*/int LastIntegralType = 21;
  private static /*const*//*uint*/int FirstPromotedIntegralType = 4;
  private static /*const*//*uint*/int LastPromotedIntegralType = 12;
  private static /*const*//*uint*/int FirstPromotedArithmeticType = 0;
  private static /*const*//*uint*/int LastPromotedArithmeticType = 12;
  private static /*const*//*uint*/int NumArithmeticTypes = 21;
  
  /// \brief Get the canonical type for a given arithmetic type index.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::getArithmeticType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7212,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::getArithmeticType", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder17getArithmeticTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder17getArithmeticTypeEj")
  //</editor-fold>
  private CanQual<Type> getArithmeticType(/*uint*/int index) {
    assert ($less_uint(index, NumArithmeticTypes));
    return new CanQual<Type>(getArithmeticType$$.ArithmeticTypes[index].$call(S.Context));
  }
  private static final class getArithmeticType$$ {
    @FunctionalInterface interface ASTContextCanQualTypeFieldPointer {
      CanQual<Type> $call(ASTContext c);
    }
    static final/*static*/ ASTContextCanQualTypeFieldPointer /*const*/ ArithmeticTypes[/*21*/] = new ASTContextCanQualTypeFieldPointer/*const*/ [/*21*/] {
      // Start of promoted types.
      (ASTContext C) -> { return C.FloatTy; }, 
      (ASTContext C) -> { return C.DoubleTy; }, 
      (ASTContext C) -> { return C.LongDoubleTy; },
      (ASTContext C) -> { return C.Float128Ty; },

      // Start of integral types.
      (ASTContext C) -> { return C.IntTy; },
      (ASTContext C) -> { return C.LongTy; },
      (ASTContext C) -> { return C.LongLongTy; },
      (ASTContext C) -> { return C.Int128Ty; },
      (ASTContext C) -> { return C.UnsignedIntTy; },
      (ASTContext C) -> { return C.UnsignedLongTy; },
      (ASTContext C) -> { return C.UnsignedLongLongTy; },
      (ASTContext C) -> { return C.UnsignedInt128Ty; },
      // End of promoted types.
      (ASTContext C) -> { return C.BoolTy; },
      (ASTContext C) -> { return C.CharTy; },
      (ASTContext C) -> { return C.WCharTy; },
      (ASTContext C) -> { return C.Char16Ty; },
      (ASTContext C) -> { return C.Char32Ty; },
      (ASTContext C) -> { return C.SignedCharTy; },
      (ASTContext C) -> { return C.ShortTy; },
      (ASTContext C) -> { return C.UnsignedCharTy; },
      (ASTContext C) -> { return C.UnsignedShortTy; }
    };
  }
  
  
  /// \brief Gets the canonical type resulting from the usual arithemetic
  /// converions for the given arithmetic types.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::getUsualArithmeticConversions">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*fixed clang bug?*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7250,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::getUsualArithmeticConversions", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder29getUsualArithmeticConversionsEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder29getUsualArithmeticConversionsEjj")
  //</editor-fold>
  private CanQual<Type> getUsualArithmeticConversions(/*uint*/int L, /*uint*/int R) {
    // Accelerator table for performing the usual arithmetic conversions.
    // The rules are basically:
    //   - if either is floating-point, use the wider floating-point
    //   - if same signedness, use the higher rank
    //   - if same size, use unsigned of the higher rank
    //   - use the larger type
    // These rules, together with the axiom that higher ranks are
    // never smaller, are sufficient to precompute all of these results
    // *except* when dealing with signed types of higher rank.
    // (we could precompute SLL x UI for all known platforms, but it's
    // better not to make any assumptions).
    // We assume that int128 has a higher rank than long long on all platforms.
    final/*static*/ /*const*/ byte/*PromotedType*/ ConversionsTable[/*12*/][/*12*/] = getUsualArithmeticConversions$$.ConversionsTable;
    assert ($less_uint(L, LastPromotedArithmeticType));
    assert ($less_uint(R, LastPromotedArithmeticType));
    int Idx = ConversionsTable[L][R];
    
    // Fast path: the table gives us a concrete answer.
    if (Idx != PromotedType.Dep) {
      return getArithmeticType(Idx);
    }
    
    // Slow path: we need to compare widths.
    // An invariant is that the signed type has higher rank.
    CanQual<Type> LT = getArithmeticType(L);
    CanQual<Type> RT = getArithmeticType(R);
    /*uint*/int LW = S.Context.getIntWidth(LT.$QualType());
    /*uint*/int RW = S.Context.getIntWidth(RT.$QualType());
    
    // If they're different widths, use the signed type.
    if ($greater_uint(LW, RW)) {
      return LT;
    } else if ($less_uint(LW, RW)) {
      return RT;
    }
    
    // Otherwise, use the unsigned type of the signed type's rank.
    if (L == PromotedType.SL || R == PromotedType.SL) {
      return new CanQual<Type>(S.Context.UnsignedLongTy);
    }
    assert (L == PromotedType.SLL || R == PromotedType.SLL);
    return new CanQual<Type>(S.Context.UnsignedLongLongTy);
  }

  final class/*enum*/ PromotedType/* : int8_t*/ {
    private static final byte/*int8_t*/ Dep = -1;
    private static final byte/*int8_t*/ Flt = Dep + 1;
    private static final byte/*int8_t*/ Dbl = Flt + 1;
    private static final byte/*int8_t*/ LDbl = Dbl + 1;
    private static final byte/*int8_t*/ F128 = LDbl + 1;
    private static final byte/*int8_t*/ SI = F128 + 1;
    private static final byte/*int8_t*/ SL = SI + 1;
    private static final byte/*int8_t*/ SLL = SL + 1;
    private static final byte/*int8_t*/ S128 = SLL + 1;
    private static final byte/*int8_t*/ UI = S128 + 1;
    private static final byte/*int8_t*/ UL = UI + 1;
    private static final byte/*int8_t*/ ULL = UL + 1;
    private static final byte/*int8_t*/ U128 = ULL + 1;
  };
  
  private static final class getUsualArithmeticConversions$$ {
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*added 12th value*/)
    static final/*static*/ /*const*/ byte/*PromotedType*/ ConversionsTable[/*12*/][/*12*/] = new /*const*/ byte/*PromotedType*/ [/*12*/][/*12*/] {
      /* Flt*/ new /*const*/ byte/*PromotedType*/ [/*12*/] {PromotedType.Flt, PromotedType.Dbl, PromotedType.LDbl, PromotedType.F128, PromotedType.Flt, PromotedType.Flt, PromotedType.Flt, PromotedType.Flt, PromotedType.Flt, PromotedType.Flt, PromotedType.Flt, PromotedType.Flt}, 
      /* Dbl*/ new /*const*/ byte/*PromotedType*/ [/*12*/] {PromotedType.Dbl, PromotedType.Dbl, PromotedType.LDbl, PromotedType.F128, PromotedType.Dbl, PromotedType.Dbl, PromotedType.Dbl, PromotedType.Dbl, PromotedType.Dbl, PromotedType.Dbl, PromotedType.Dbl, PromotedType.Dbl}, 
      /*LDbl*/ new /*const*/ byte/*PromotedType*/ [/*12*/] {PromotedType.LDbl, PromotedType.LDbl, PromotedType.LDbl, PromotedType.F128, PromotedType.LDbl, PromotedType.LDbl, PromotedType.LDbl, PromotedType.LDbl, PromotedType.LDbl, PromotedType.LDbl, PromotedType.LDbl, PromotedType.LDbl}, 
      /*F128*/ new /*const*/ byte/*PromotedType*/ [/*12*/] {PromotedType.F128, PromotedType.F128, PromotedType.F128, PromotedType.F128, PromotedType.F128, PromotedType.F128, PromotedType.F128, PromotedType.F128, PromotedType.F128, PromotedType.F128, PromotedType.F128, PromotedType.F128}, 
      /*  SI*/ new /*const*/ byte/*PromotedType*/ [/*12*/] {PromotedType.Flt, PromotedType.Dbl, PromotedType.LDbl, PromotedType.F128, PromotedType.SI, PromotedType.SL, PromotedType.SLL, PromotedType.S128, PromotedType.UI, PromotedType.UL, PromotedType.ULL, PromotedType.U128}, 
      /*  SL*/ new /*const*/ byte/*PromotedType*/ [/*12*/] {PromotedType.Flt, PromotedType.Dbl, PromotedType.LDbl, PromotedType.F128, PromotedType.SL, PromotedType.SL, PromotedType.SLL, PromotedType.S128, PromotedType.Dep, PromotedType.UL, PromotedType.ULL, PromotedType.U128}, 
      /* SLL*/ new /*const*/ byte/*PromotedType*/ [/*12*/] {PromotedType.Flt, PromotedType.Dbl, PromotedType.LDbl, PromotedType.F128, PromotedType.SLL, PromotedType.SLL, PromotedType.SLL, PromotedType.S128, PromotedType.Dep, PromotedType.Dep, PromotedType.ULL, PromotedType.U128}, 
      /*S128*/ new /*const*/ byte/*PromotedType*/ [/*12*/] {PromotedType.Flt, PromotedType.Dbl, PromotedType.LDbl, PromotedType.F128, PromotedType.S128, PromotedType.S128, PromotedType.S128, PromotedType.S128, PromotedType.S128, PromotedType.S128, PromotedType.S128, PromotedType.U128}, 
      /*  UI*/ new /*const*/ byte/*PromotedType*/ [/*12*/] {PromotedType.Flt, PromotedType.Dbl, PromotedType.LDbl, PromotedType.F128, PromotedType.UI, PromotedType.Dep, PromotedType.Dep, PromotedType.S128, PromotedType.UI, PromotedType.UL, PromotedType.ULL, PromotedType.U128}, 
      /*  UL*/ new /*const*/ byte/*PromotedType*/ [/*12*/] {PromotedType.Flt, PromotedType.Dbl, PromotedType.LDbl, PromotedType.F128, PromotedType.UL, PromotedType.UL, PromotedType.Dep, PromotedType.S128, PromotedType.UL, PromotedType.UL, PromotedType.ULL, PromotedType.U128}, 
      /* ULL*/ new /*const*/ byte/*PromotedType*/ [/*12*/] {PromotedType.Flt, PromotedType.Dbl, PromotedType.LDbl, PromotedType.F128, PromotedType.ULL, PromotedType.ULL, PromotedType.ULL, PromotedType.S128, PromotedType.ULL, PromotedType.ULL, PromotedType.ULL, PromotedType.U128}, 
      /*U128*/ new /*const*/ byte/*PromotedType*/ [/*12*/] {PromotedType.Flt, PromotedType.Dbl, PromotedType.LDbl, PromotedType.F128, PromotedType.U128, PromotedType.U128, PromotedType.U128, PromotedType.U128, PromotedType.U128, PromotedType.U128, PromotedType.U128, PromotedType.U128},
    };
  }

  
  /// \brief Helper method to factor out the common pattern of adding overloads
  /// for '++' and '--' builtin operators.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addPlusPlusMinusMinusStyleOverloads">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7308,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addPlusPlusMinusMinusStyleOverloads", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder35addPlusPlusMinusMinusStyleOverloadsEN5clang8QualTypeEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder35addPlusPlusMinusMinusStyleOverloadsEN5clang8QualTypeEbb")
  //</editor-fold>
  private void addPlusPlusMinusMinusStyleOverloads(QualType CandidateTy, 
                                     boolean HasVolatile, 
                                     boolean HasRestrict) {
    QualType ParamTypes[/*2*/] = new QualType [/*2*/] {
      S.Context.getLValueReferenceType(new QualType(CandidateTy)), 
      S.Context.IntTy.$QualType()
    };
    
    // Non-volatile version.
    if (Args.size() == 1) {
      S.AddBuiltinCandidate(new QualType(ParamTypes[0]), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
    } else {
      S.AddBuiltinCandidate(new QualType(CandidateTy), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
    }
    
    // Use a heuristic to reduce number of builtin candidates in the set:
    // add volatile version only if there are conversions to a volatile type.
    if (HasVolatile) {
      ParamTypes[0].$assignMove(
          S.Context.getLValueReferenceType(S.Context.getVolatileType(new QualType(CandidateTy)))
      );
      if (Args.size() == 1) {
        S.AddBuiltinCandidate(new QualType(ParamTypes[0]), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
      } else {
        S.AddBuiltinCandidate(new QualType(CandidateTy), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
      }
    }
    
    // Add restrict version only if there are conversions to a restrict type
    // and our candidate type is a non-restrict-qualified pointer.
    if (HasRestrict && CandidateTy.$arrow().isAnyPointerType()
       && !CandidateTy.isRestrictQualified()) {
      ParamTypes[0].$assignMove(
          S.Context.getLValueReferenceType(S.Context.getCVRQualifiedType(new QualType(CandidateTy), Qualifiers.TQ.Restrict))
      );
      if (Args.size() == 1) {
        S.AddBuiltinCandidate(new QualType(ParamTypes[0]), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
      } else {
        S.AddBuiltinCandidate(new QualType(CandidateTy), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
      }
      if (HasVolatile) {
        ParamTypes[0].$assignMove(
            S.Context.getLValueReferenceType(S.Context.getCVRQualifiedType(new QualType(CandidateTy), 
                    (Qualifiers.TQ.Volatile
                       | Qualifiers.TQ.Restrict)))
        );
        if (Args.size() == 1) {
          S.AddBuiltinCandidate(new QualType(ParamTypes[0]), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
        } else {
          S.AddBuiltinCandidate(new QualType(CandidateTy), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
        }
      }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::BuiltinOperatorOverloadBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7362,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::BuiltinOperatorOverloadBuilder", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilderC1ERN5clang4SemaEN4llvm8ArrayRefIPNS1_4ExprEEENS1_10QualifiersEbRNS4_15SmallVectorImplINS_23BuiltinCandidateTypeSetEEERNS1_20OverloadCandidateSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilderC1ERN5clang4SemaEN4llvm8ArrayRefIPNS1_4ExprEEENS1_10QualifiersEbRNS4_15SmallVectorImplINS_23BuiltinCandidateTypeSetEEERNS1_20OverloadCandidateSetE")
  //</editor-fold>
  public BuiltinOperatorOverloadBuilder(final Sema /*&*/ S, ArrayRef<Expr /*P*/ > Args, 
      Qualifiers VisibleTypeConversionsQuals, 
      boolean HasArithmeticOrEnumeralCandidateType, 
      final SmallVectorImpl<BuiltinCandidateTypeSet> /*&*/ CandidateTypes, 
      final OverloadCandidateSet /*&*/ CandidateSet) {
    // : S(S), Args(Args), VisibleTypeConversionsQuals(VisibleTypeConversionsQuals), HasArithmeticOrEnumeralCandidateType(HasArithmeticOrEnumeralCandidateType), CandidateTypes(CandidateTypes), CandidateSet(CandidateSet) 
    //START JInit
    this./*&*/S=/*&*/S;
    this.Args = new ArrayRef<Expr /*P*/ >(Args);
    this.VisibleTypeConversionsQuals = new Qualifiers(VisibleTypeConversionsQuals);
    this.HasArithmeticOrEnumeralCandidateType = HasArithmeticOrEnumeralCandidateType;
    this./*&*/CandidateTypes=/*&*/CandidateTypes;
    this./*&*/CandidateSet=/*&*/CandidateSet;
    //END JInit
    // Validate some of our static helper constants in debug builds.
    assert ($eq_CanQual$T_CanQual$U(getArithmeticType(FirstPromotedIntegralType), /*NO_COPY*/S.Context.IntTy)) : "Invalid first promoted integral type";
    assert ($eq_CanQual$T_CanQual$U(getArithmeticType(LastPromotedIntegralType - 1), /*NO_COPY*/S.Context.UnsignedInt128Ty)) : "Invalid last promoted integral type";
    assert ($eq_CanQual$T_CanQual$U(getArithmeticType(FirstPromotedArithmeticType), /*NO_COPY*/S.Context.FloatTy)) : "Invalid first promoted arithmetic type";
    assert ($eq_CanQual$T_CanQual$U(getArithmeticType(LastPromotedArithmeticType - 1), /*NO_COPY*/S.Context.UnsignedInt128Ty)) : "Invalid last promoted arithmetic type";
  }

  
  // C++ [over.built]p3:
  //
  //   For every pair (T, VQ), where T is an arithmetic type, and VQ
  //   is either volatile or empty, there exist candidate operator
  //   functions of the form
  //
  //       VQ T&      operator++(VQ T&);
  //       T          operator++(VQ T&, int);
  //
  // C++ [over.built]p4:
  //
  //   For every pair (T, VQ), where T is an arithmetic type other
  //   than bool, and VQ is either volatile or empty, there exist
  //   candidate operator functions of the form
  //
  //       VQ T&      operator--(VQ T&);
  //       T          operator--(VQ T&, int);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addPlusPlusMinusMinusArithmeticOverloads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7405,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addPlusPlusMinusMinusArithmeticOverloads", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder40addPlusPlusMinusMinusArithmeticOverloadsEN5clang22OverloadedOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder40addPlusPlusMinusMinusArithmeticOverloadsEN5clang22OverloadedOperatorKindE")
  //</editor-fold>
  public void addPlusPlusMinusMinusArithmeticOverloads(OverloadedOperatorKind Op) {
    if (!HasArithmeticOrEnumeralCandidateType) {
      return;
    }
    
    for (/*uint*/int Arith = (Op == OverloadedOperatorKind.OO_PlusPlus ? 0 : 1);
         $less_uint(Arith, NumArithmeticTypes); ++Arith) {
      addPlusPlusMinusMinusStyleOverloads(getArithmeticType(Arith).$QualType(), 
          VisibleTypeConversionsQuals.hasVolatile(), 
          VisibleTypeConversionsQuals.hasRestrict());
    }
  }

  
  // C++ [over.built]p5:
  //
  //   For every pair (T, VQ), where T is a cv-qualified or
  //   cv-unqualified object type, and VQ is either volatile or
  //   empty, there exist candidate operator functions of the form
  //
  //       T*VQ&      operator++(T*VQ&);
  //       T*VQ&      operator--(T*VQ&);
  //       T*         operator++(T*VQ&, int);
  //       T*         operator--(T*VQ&, int);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addPlusPlusMinusMinusPointerOverloads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7428,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addPlusPlusMinusMinusPointerOverloads", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder37addPlusPlusMinusMinusPointerOverloadsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder37addPlusPlusMinusMinusPointerOverloadsEv")
  //</editor-fold>
  public void addPlusPlusMinusMinusPointerOverloads() {
    for (/*const*/type$ptr<QualType /*P*/> Ptr = $tryClone(CandidateTypes.$at(0).pointer_begin()), 
        /*P*/ PtrEnd = $tryClone(CandidateTypes.$at(0).pointer_end());
         $noteq_ptr(Ptr, PtrEnd); Ptr.$preInc()) {
      // Skip pointer types that aren't pointers to object types.
      if (!(Ptr.$star()).$arrow().getPointeeType().$arrow().isObjectType()) {
        continue;
      }
      
      addPlusPlusMinusMinusStyleOverloads(new QualType(Ptr.$star()), 
          (!(Ptr.$star()).isVolatileQualified()
             && VisibleTypeConversionsQuals.hasVolatile()), 
          (!(Ptr.$star()).isRestrictQualified()
             && VisibleTypeConversionsQuals.hasRestrict()));
    }
  }

  
  // C++ [over.built]p6:
  //   For every cv-qualified or cv-unqualified object type T, there
  //   exist candidate operator functions of the form
  //
  //       T&         operator*(T*);
  //
  // C++ [over.built]p7:
  //   For every function type T that does not have cv-qualifiers or a
  //   ref-qualifier, there exist candidate operator functions of the form
  //       T&         operator*(T*);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addUnaryStarPointerOverloads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7455,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addUnaryStarPointerOverloads", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder28addUnaryStarPointerOverloadsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder28addUnaryStarPointerOverloadsEv")
  //</editor-fold>
  public void addUnaryStarPointerOverloads() {
    for (/*const*/type$ptr<QualType /*P*/> Ptr = $tryClone(CandidateTypes.$at(0).pointer_begin()), 
        /*P*/ PtrEnd = $tryClone(CandidateTypes.$at(0).pointer_end());
         $noteq_ptr(Ptr, PtrEnd); Ptr.$preInc()) {
      QualType ParamTy = new QualType(Ptr.$star());
      QualType PointeeTy = ParamTy.$arrow().getPointeeType();
      if (!PointeeTy.$arrow().isObjectType() && !PointeeTy.$arrow().isFunctionType()) {
        continue;
      }
      {
        
        /*const*/ FunctionProtoType /*P*/ Proto = PointeeTy.$arrow().getAs(FunctionProtoType.class);
        if ((Proto != null)) {
          if ((Proto.getTypeQuals() != 0) || (Proto.getRefQualifier().getValue() != 0)) {
            continue;
          }
        }
      }
      
      S.AddBuiltinCandidate(S.Context.getLValueReferenceType(new QualType(PointeeTy)), 
          $AddrOf(ParamTy), new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
    }
  }

  
  // C++ [over.built]p9:
  //  For every promoted arithmetic type T, there exist candidate
  //  operator functions of the form
  //
  //       T         operator+(T);
  //       T         operator-(T);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addUnaryPlusOrMinusArithmeticOverloads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7480,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addUnaryPlusOrMinusArithmeticOverloads", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder38addUnaryPlusOrMinusArithmeticOverloadsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder38addUnaryPlusOrMinusArithmeticOverloadsEv")
  //</editor-fold>
  public void addUnaryPlusOrMinusArithmeticOverloads() {
    if (!HasArithmeticOrEnumeralCandidateType) {
      return;
    }
    
    for (/*uint*/int Arith = FirstPromotedArithmeticType;
         $less_uint(Arith, LastPromotedArithmeticType); ++Arith) {
      QualType ArithTy = getArithmeticType(Arith).$QualType();
      S.AddBuiltinCandidate(new QualType(ArithTy), $AddrOf(ArithTy), new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
    }
    
    // Extension: We also add these operators for vector types.
    for (/*const*/type$ptr<QualType /*P*/> Vec = $tryClone(CandidateTypes.$at(0).vector_begin()), 
        /*P*/ VecEnd = $tryClone(CandidateTypes.$at(0).vector_end());
         $noteq_ptr(Vec, VecEnd); Vec.$preInc()) {
      QualType VecTy = new QualType(Vec.$star());
      S.AddBuiltinCandidate(new QualType(VecTy), $AddrOf(VecTy), new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
    }
  }

  
  // C++ [over.built]p8:
  //   For every type T, there exist candidate operator functions of
  //   the form
  //
  //       T*         operator+(T*);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addUnaryPlusPointerOverloads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7505,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addUnaryPlusPointerOverloads", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder28addUnaryPlusPointerOverloadsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder28addUnaryPlusPointerOverloadsEv")
  //</editor-fold>
  public void addUnaryPlusPointerOverloads() {
    for (/*const*/type$ptr<QualType /*P*/> Ptr = $tryClone(CandidateTypes.$at(0).pointer_begin()), 
        /*P*/ PtrEnd = $tryClone(CandidateTypes.$at(0).pointer_end());
         $noteq_ptr(Ptr, PtrEnd); Ptr.$preInc()) {
      QualType ParamTy = new QualType(Ptr.$star());
      S.AddBuiltinCandidate(new QualType(ParamTy), $AddrOf(ParamTy), new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
    }
  }

  
  // C++ [over.built]p10:
  //   For every promoted integral type T, there exist candidate
  //   operator functions of the form
  //
  //        T         operator~(T);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addUnaryTildePromotedIntegralOverloads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7520,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addUnaryTildePromotedIntegralOverloads", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder38addUnaryTildePromotedIntegralOverloadsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder38addUnaryTildePromotedIntegralOverloadsEv")
  //</editor-fold>
  public void addUnaryTildePromotedIntegralOverloads() {
    if (!HasArithmeticOrEnumeralCandidateType) {
      return;
    }
    
    for (/*uint*/int Int = FirstPromotedIntegralType;
         $less_uint(Int, LastPromotedIntegralType); ++Int) {
      QualType IntTy = getArithmeticType(Int).$QualType();
      S.AddBuiltinCandidate(new QualType(IntTy), $AddrOf(IntTy), new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
    }
    
    // Extension: We also add this operator for vector types.
    for (/*const*/type$ptr<QualType /*P*/> Vec = $tryClone(CandidateTypes.$at(0).vector_begin()), 
        /*P*/ VecEnd = $tryClone(CandidateTypes.$at(0).vector_end());
         $noteq_ptr(Vec, VecEnd); Vec.$preInc()) {
      QualType VecTy = new QualType(Vec.$star());
      S.AddBuiltinCandidate(new QualType(VecTy), $AddrOf(VecTy), new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
    }
  }

  
  // C++ [over.match.oper]p16:
  //   For every pointer to member type T, there exist candidate operator
  //   functions of the form
  //
  //        bool operator==(T,T);
  //        bool operator!=(T,T);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addEqualEqualOrNotEqualMemberPointerOverloads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7546,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addEqualEqualOrNotEqualMemberPointerOverloads", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder45addEqualEqualOrNotEqualMemberPointerOverloadsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder45addEqualEqualOrNotEqualMemberPointerOverloadsEv")
  //</editor-fold>
  public void addEqualEqualOrNotEqualMemberPointerOverloads() {
    /// Set of (canonical) types that we've already handled.
    SmallPtrSet<QualType> AddedTypes/*J*/= new SmallPtrSet<QualType>(DenseMapInfoQualType.$Info(), 8);
    
    for (/*uint*/int ArgIdx = 0, N = Args.size(); ArgIdx != N; ++ArgIdx) {
      for (/*const*/type$ptr<QualType /*P*/> MemPtr = $tryClone(CandidateTypes.$at(ArgIdx).member_pointer_begin()), 
          /*P*/ MemPtrEnd = $tryClone(CandidateTypes.$at(ArgIdx).member_pointer_end());
           $noteq_ptr(MemPtr, MemPtrEnd);
           MemPtr.$preInc()) {
        // Don't add the same builtin candidate twice.
        if (!AddedTypes.insert(S.Context.getCanonicalType(new QualType(MemPtr.$star())).$QualType()).second) {
          continue;
        }
        
        QualType ParamTypes[/*2*/] = new QualType [/*2*/] {MemPtr.$star(), MemPtr.$star()};
        S.AddBuiltinCandidate(S.Context.BoolTy.$QualType(), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
      }
    }
  }

  
  // C++ [over.built]p15:
  //
  //   For every T, where T is an enumeration type, a pointer type, or 
  //   std::nullptr_t, there exist candidate operator functions of the form
  //
  //        bool       operator<(T, T);
  //        bool       operator>(T, T);
  //        bool       operator<=(T, T);
  //        bool       operator>=(T, T);
  //        bool       operator==(T, T);
  //        bool       operator!=(T, T);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addRelationalPointerOrEnumeralOverloads">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7577,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addRelationalPointerOrEnumeralOverloads", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder39addRelationalPointerOrEnumeralOverloadsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder39addRelationalPointerOrEnumeralOverloadsEv")
  //</editor-fold>
  public void addRelationalPointerOrEnumeralOverloads() {
    // C++ [over.match.oper]p3:
    //   [...]the built-in candidates include all of the candidate operator
    //   functions defined in 13.6 that, compared to the given operator, [...]
    //   do not have the same parameter-type-list as any non-template non-member
    //   candidate.
    //
    // Note that in practice, this only affects enumeration types because there
    // aren't any built-in candidates of record type, and a user-defined operator
    // must have an operand of record or enumeration type. Also, the only other
    // overloaded operator with enumeration arguments, operator=,
    // cannot be overloaded for enumeration types, so this is the only place
    // where we must suppress candidates like this.
    DenseSet<std.pair<CanQual<Type>, CanQual<Type> > > UserDefinedBinaryOperators/*J*/= new DenseSet<std.pair<CanQual<Type>, CanQual<Type> > >(
            new DenseMapInfoPair<CanQual<Type>, CanQual<Type>>(DenseMapInfoCanQual$Type.$Info(), DenseMapInfoCanQual$Type.$Info()));
    
    for (/*uint*/int ArgIdx = 0, N = Args.size(); ArgIdx != N; ++ArgIdx) {
      if ($noteq_ptr(CandidateTypes.$at(ArgIdx).enumeration_begin(), CandidateTypes.$at(ArgIdx).enumeration_end())) {
        for (type$ptr<OverloadCandidate> C = $tryClone(CandidateSet.begin()), 
            /*P*/ CEnd = $tryClone(CandidateSet.end());
             $noteq_ptr(C, CEnd); C.$preInc()) {
          if (!C./*->*/$star().Viable || !(C./*->*/$star().Function != null) || C./*->*/$star().Function.getNumParams() != 2) {
            continue;
          }
          if (C./*->*/$star().Function.isFunctionTemplateSpecialization()) {
            continue;
          }
          
          QualType FirstParamType = C./*->*/$star().Function.getParamDecl(0).getType().getUnqualifiedType();
          QualType SecondParamType = C./*->*/$star().Function.getParamDecl(1).getType().getUnqualifiedType();
          
          // Skip if either parameter isn't of enumeral type.
          if (!FirstParamType.$arrow().isEnumeralType()
             || !SecondParamType.$arrow().isEnumeralType()) {
            continue;
          }
          
          // Add this operator to the set of known user-defined operators.
          UserDefinedBinaryOperators.insert(std.make_pair(S.Context.getCanonicalType(new QualType(FirstParamType)), 
                  S.Context.getCanonicalType(new QualType(SecondParamType))));
        }
      }
    }
    
    /// Set of (canonical) types that we've already handled.
    SmallPtrSet<QualType> AddedTypes/*J*/= new SmallPtrSet<QualType>(DenseMapInfoQualType.$Info(), 8);
    
    for (/*uint*/int ArgIdx = 0, N = Args.size(); ArgIdx != N; ++ArgIdx) {
      for (/*const*/type$ptr<QualType /*P*/> Ptr = $tryClone(CandidateTypes.$at(ArgIdx).pointer_begin()), 
          /*P*/ PtrEnd = $tryClone(CandidateTypes.$at(ArgIdx).pointer_end());
           $noteq_ptr(Ptr, PtrEnd); Ptr.$preInc()) {
        // Don't add the same builtin candidate twice.
        if (!AddedTypes.insert(S.Context.getCanonicalType(new QualType(Ptr.$star())).$QualType()).second) {
          continue;
        }
        
        QualType ParamTypes[/*2*/] = new QualType [/*2*/] {Ptr.$star(), Ptr.$star()};
        S.AddBuiltinCandidate(S.Context.BoolTy.$QualType(), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
      }
      for (/*const*/type$ptr<QualType /*P*/> Enum = $tryClone(CandidateTypes.$at(ArgIdx).enumeration_begin()), 
          /*P*/ EnumEnd = $tryClone(CandidateTypes.$at(ArgIdx).enumeration_end());
           $noteq_ptr(Enum, EnumEnd); Enum.$preInc()) {
        CanQual<Type> CanonType = S.Context.getCanonicalType(new QualType(Enum.$star()));
        
        // Don't add the same builtin candidate twice, or if a user defined
        // candidate exists.
        if (!AddedTypes.insert(CanonType.$QualType()).second
           || (UserDefinedBinaryOperators.count(std.make_pair(CanonType, 
                CanonType)) != 0)) {
          continue;
        }
        
        QualType ParamTypes[/*2*/] = new QualType [/*2*/] {Enum.$star(), Enum.$star()};
        S.AddBuiltinCandidate(S.Context.BoolTy.$QualType(), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
      }
      if (CandidateTypes.$at(ArgIdx).hasNullPtrType()) {
        CanQual<Type> NullPtrTy = S.Context.getCanonicalType(S.Context.NullPtrTy.$QualType());
        if (AddedTypes.insert(NullPtrTy.$QualType()).second
           && !(UserDefinedBinaryOperators.count(std.make_pair(NullPtrTy, 
                NullPtrTy)) != 0)) {
          QualType ParamTypes[/*2*/] = new QualType [/*2*/] {NullPtrTy.$QualType(), NullPtrTy.$QualType()};
          S.AddBuiltinCandidate(S.Context.BoolTy.$QualType(), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), 
              CandidateSet);
        }
      }
    }
  }

  
  // C++ [over.built]p13:
  //
  //   For every cv-qualified or cv-unqualified object type T
  //   there exist candidate operator functions of the form
  //
  //      T*         operator+(T*, ptrdiff_t);
  //      T&         operator[](T*, ptrdiff_t);    [BELOW]
  //      T*         operator-(T*, ptrdiff_t);
  //      T*         operator+(ptrdiff_t, T*);
  //      T&         operator[](ptrdiff_t, T*);    [BELOW]
  //
  // C++ [over.built]p14:
  //
  //   For every T, where T is a pointer to object type, there
  //   exist candidate operator functions of the form
  //
  //      ptrdiff_t  operator-(T, T);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addBinaryPlusOrMinusPointerOverloads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7685,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addBinaryPlusOrMinusPointerOverloads", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder36addBinaryPlusOrMinusPointerOverloadsEN5clang22OverloadedOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder36addBinaryPlusOrMinusPointerOverloadsEN5clang22OverloadedOperatorKindE")
  //</editor-fold>
  public void addBinaryPlusOrMinusPointerOverloads(OverloadedOperatorKind Op) {
    /// Set of (canonical) types that we've already handled.
    SmallPtrSet<QualType> AddedTypes/*J*/= new SmallPtrSet<QualType>(DenseMapInfoQualType.$Info(), 8);
    
    for (int Arg = 0; Arg < 2; ++Arg) {
      QualType AsymmetricParamTypes[/*2*/] = new QualType [/*2*/] {
        S.Context.getPointerDiffType(), 
        S.Context.getPointerDiffType()
      };
      for (/*const*/type$ptr<QualType /*P*/> Ptr = $tryClone(CandidateTypes.$at(Arg).pointer_begin()), 
          /*P*/ PtrEnd = $tryClone(CandidateTypes.$at(Arg).pointer_end());
           $noteq_ptr(Ptr, PtrEnd); Ptr.$preInc()) {
        QualType PointeeTy = (Ptr.$star()).$arrow().getPointeeType();
        if (!PointeeTy.$arrow().isObjectType()) {
          continue;
        }
        
        AsymmetricParamTypes[Arg].$assign(Ptr.$star());
        if (Arg == 0 || Op == OverloadedOperatorKind.OO_Plus) {
          // operator+(T*, ptrdiff_t) or operator-(T*, ptrdiff_t)
          // T* operator+(ptrdiff_t, T*);
          S.AddBuiltinCandidate(new QualType(Ptr.$star()), AsymmetricParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
        }
        if (Op == OverloadedOperatorKind.OO_Minus) {
          // ptrdiff_t operator-(T, T);
          if (!AddedTypes.insert(S.Context.getCanonicalType(new QualType(Ptr.$star())).$QualType()).second) {
            continue;
          }
          
          QualType ParamTypes[/*2*/] = new QualType [/*2*/] {Ptr.$star(), Ptr.$star()};
          S.AddBuiltinCandidate(S.Context.getPointerDiffType(), ParamTypes, 
              new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
        }
      }
    }
  }

  
  // C++ [over.built]p12:
  //
  //   For every pair of promoted arithmetic types L and R, there
  //   exist candidate operator functions of the form
  //
  //        LR         operator*(L, R);
  //        LR         operator/(L, R);
  //        LR         operator+(L, R);
  //        LR         operator-(L, R);
  //        bool       operator<(L, R);
  //        bool       operator>(L, R);
  //        bool       operator<=(L, R);
  //        bool       operator>=(L, R);
  //        bool       operator==(L, R);
  //        bool       operator!=(L, R);
  //
  //   where LR is the result of the usual arithmetic conversions
  //   between types L and R.
  //
  // C++ [over.built]p24:
  //
  //   For every pair of promoted arithmetic types L and R, there exist
  //   candidate operator functions of the form
  //
  //        LR       operator?(bool, L, R);
  //
  //   where LR is the result of the usual arithmetic conversions
  //   between types L and R.
  // Our candidates ignore the first parameter.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addGenericBinaryArithmeticOverloads">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7750,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addGenericBinaryArithmeticOverloads", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder35addGenericBinaryArithmeticOverloadsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder35addGenericBinaryArithmeticOverloadsEb")
  //</editor-fold>
  public void addGenericBinaryArithmeticOverloads(boolean isComparison) {
    if (!HasArithmeticOrEnumeralCandidateType) {
      return;
    }
    
    for (/*uint*/int Left = FirstPromotedArithmeticType;
         $less_uint(Left, LastPromotedArithmeticType); ++Left) {
      for (/*uint*/int Right = FirstPromotedArithmeticType;
           $less_uint(Right, LastPromotedArithmeticType); ++Right) {
        QualType LandR[/*2*/] = new QualType [/*2*/] {
          getArithmeticType(Left).$QualType(), 
          getArithmeticType(Right).$QualType()};
        QualType Result = (isComparison ? new CanQual<Type>(S.Context.BoolTy) : getUsualArithmeticConversions(Left, Right)).$QualType();
        S.AddBuiltinCandidate(new QualType(Result), LandR, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
      }
    }
    
    // Extension: Add the binary operators ==, !=, <, <=, >=, >, *, /, and the
    // conditional operator for vector types.
    for (/*const*/type$ptr<QualType /*P*/> Vec1 = $tryClone(CandidateTypes.$at(0).vector_begin()), 
        /*P*/ Vec1End = $tryClone(CandidateTypes.$at(0).vector_end());
         $noteq_ptr(Vec1, Vec1End); Vec1.$preInc()) {
      for (/*const*/type$ptr<QualType /*P*/> Vec2 = $tryClone(CandidateTypes.$at(1).vector_begin()), 
          /*P*/ Vec2End = $tryClone(CandidateTypes.$at(1).vector_end());
           $noteq_ptr(Vec2, Vec2End); Vec2.$preInc()) {
        QualType LandR[/*2*/] = new QualType [/*2*/] {Vec1.$star(), Vec2.$star()};
        QualType Result = S.Context.BoolTy.$QualType();
        if (!isComparison) {
          if ((Vec1.$star()).$arrow().isExtVectorType() || !(Vec2.$star()).$arrow().isExtVectorType()) {
            Result.$assign(Vec1.$star());
          } else {
            Result.$assign(Vec2.$star());
          }
        }
        
        S.AddBuiltinCandidate(new QualType(Result), LandR, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
      }
    }
  }

  
  // C++ [over.built]p17:
  //
  //   For every pair of promoted integral types L and R, there
  //   exist candidate operator functions of the form
  //
  //      LR         operator%(L, R);
  //      LR         operator&(L, R);
  //      LR         operator^(L, R);
  //      LR         operator|(L, R);
  //      L          operator<<(L, R);
  //      L          operator>>(L, R);
  //
  //   where LR is the result of the usual arithmetic conversions
  //   between types L and R.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addBinaryBitwiseArithmeticOverloads">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7805,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addBinaryBitwiseArithmeticOverloads", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder35addBinaryBitwiseArithmeticOverloadsEN5clang22OverloadedOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder35addBinaryBitwiseArithmeticOverloadsEN5clang22OverloadedOperatorKindE")
  //</editor-fold>
  public void addBinaryBitwiseArithmeticOverloads(OverloadedOperatorKind Op) {
    if (!HasArithmeticOrEnumeralCandidateType) {
      return;
    }
    
    for (/*uint*/int Left = FirstPromotedIntegralType;
         $less_uint(Left, LastPromotedIntegralType); ++Left) {
      for (/*uint*/int Right = FirstPromotedIntegralType;
           $less_uint(Right, LastPromotedIntegralType); ++Right) {
        QualType LandR[/*2*/] = new QualType [/*2*/] {
          getArithmeticType(Left).$QualType(), 
          getArithmeticType(Right).$QualType()};
        QualType Result = (Op == OverloadedOperatorKind.OO_LessLess || Op == OverloadedOperatorKind.OO_GreaterGreater) ? new QualType(LandR[0]) : getUsualArithmeticConversions(Left, Right).$QualType();
        S.AddBuiltinCandidate(new QualType(Result), LandR, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
      }
    }
  }

  
  // C++ [over.built]p20:
  //
  //   For every pair (T, VQ), where T is an enumeration or
  //   pointer to member type and VQ is either volatile or
  //   empty, there exist candidate operator functions of the form
  //
  //        VQ T&      operator=(VQ T&, T);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addAssignmentMemberPointerOrEnumeralOverloads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7830,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addAssignmentMemberPointerOrEnumeralOverloads", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder45addAssignmentMemberPointerOrEnumeralOverloadsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder45addAssignmentMemberPointerOrEnumeralOverloadsEv")
  //</editor-fold>
  public void addAssignmentMemberPointerOrEnumeralOverloads() {
    /// Set of (canonical) types that we've already handled.
    SmallPtrSet<QualType> AddedTypes/*J*/= new SmallPtrSet<QualType>(DenseMapInfoQualType.$Info(), 8);
    
    for (/*uint*/int ArgIdx = 0; $less_uint(ArgIdx, 2); ++ArgIdx) {
      for (/*const*/type$ptr<QualType /*P*/> Enum = $tryClone(CandidateTypes.$at(ArgIdx).enumeration_begin()), 
          /*P*/ EnumEnd = $tryClone(CandidateTypes.$at(ArgIdx).enumeration_end());
           $noteq_ptr(Enum, EnumEnd); Enum.$preInc()) {
        if (!AddedTypes.insert(S.Context.getCanonicalType(new QualType(Enum.$star())).$QualType()).second) {
          continue;
        }
        
        AddBuiltinAssignmentOperatorCandidates(S, new QualType(Enum.$star()), new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
      }
      
      for (/*const*/type$ptr<QualType /*P*/> MemPtr = $tryClone(CandidateTypes.$at(ArgIdx).member_pointer_begin()), 
          /*P*/ MemPtrEnd = $tryClone(CandidateTypes.$at(ArgIdx).member_pointer_end());
           $noteq_ptr(MemPtr, MemPtrEnd); MemPtr.$preInc()) {
        if (!AddedTypes.insert(S.Context.getCanonicalType(new QualType(MemPtr.$star())).$QualType()).second) {
          continue;
        }
        
        AddBuiltinAssignmentOperatorCandidates(S, new QualType(MemPtr.$star()), new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
      }
    }
  }

  
  // C++ [over.built]p19:
  //
  //   For every pair (T, VQ), where T is any type and VQ is either
  //   volatile or empty, there exist candidate operator functions
  //   of the form
  //
  //        T*VQ&      operator=(T*VQ&, T*);
  //
  // C++ [over.built]p21:
  //
  //   For every pair (T, VQ), where T is a cv-qualified or
  //   cv-unqualified object type and VQ is either volatile or
  //   empty, there exist candidate operator functions of the form
  //
  //        T*VQ&      operator+=(T*VQ&, ptrdiff_t);
  //        T*VQ&      operator-=(T*VQ&, ptrdiff_t);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addAssignmentPointerOverloads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7873,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addAssignmentPointerOverloads", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder29addAssignmentPointerOverloadsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder29addAssignmentPointerOverloadsEb")
  //</editor-fold>
  public void addAssignmentPointerOverloads(boolean isEqualOp) {
    /// Set of (canonical) types that we've already handled.
    SmallPtrSet<QualType> AddedTypes/*J*/= new SmallPtrSet<QualType>(DenseMapInfoQualType.$Info(), 8);
    
    for (/*const*/type$ptr<QualType /*P*/> Ptr = $tryClone(CandidateTypes.$at(0).pointer_begin()), 
        /*P*/ PtrEnd = $tryClone(CandidateTypes.$at(0).pointer_end());
         $noteq_ptr(Ptr, PtrEnd); Ptr.$preInc()) {
      // If this is operator=, keep track of the builtin candidates we added.
      if (isEqualOp) {
        AddedTypes.insert(S.Context.getCanonicalType(new QualType(Ptr.$star())).$QualType());
      } else if (!(Ptr.$star()).$arrow().getPointeeType().$arrow().isObjectType()) {
        continue;
      }
      
      // non-volatile version
      QualType ParamTypes[/*2*/] = new QualType [/*2*/] {
        S.Context.getLValueReferenceType(new QualType(Ptr.$star())), 
        isEqualOp ? new QualType(Ptr.$star()) : S.Context.getPointerDiffType()
      };
      S.AddBuiltinCandidate(new QualType(ParamTypes[0]), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
          /*IsAssigmentOperator=*/ isEqualOp);
      
      boolean NeedVolatile = !(Ptr.$star()).isVolatileQualified()
         && VisibleTypeConversionsQuals.hasVolatile();
      if (NeedVolatile) {
        // volatile version
        ParamTypes[0].$assignMove(
            S.Context.getLValueReferenceType(S.Context.getVolatileType(new QualType(Ptr.$star())))
        );
        S.AddBuiltinCandidate(new QualType(ParamTypes[0]), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
            /*IsAssigmentOperator=*/ isEqualOp);
      }
      if (!(Ptr.$star()).isRestrictQualified()
         && VisibleTypeConversionsQuals.hasRestrict()) {
        // restrict version
        ParamTypes[0].$assignMove(
            S.Context.getLValueReferenceType(S.Context.getRestrictType(new QualType(Ptr.$star())))
        );
        S.AddBuiltinCandidate(new QualType(ParamTypes[0]), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
            /*IsAssigmentOperator=*/ isEqualOp);
        if (NeedVolatile) {
          // volatile restrict version
          ParamTypes[0].$assignMove(
              S.Context.getLValueReferenceType(S.Context.getCVRQualifiedType(new QualType(Ptr.$star()), 
                      (Qualifiers.TQ.Volatile
                         | Qualifiers.TQ.Restrict)))
          );
          S.AddBuiltinCandidate(new QualType(ParamTypes[0]), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
              /*IsAssigmentOperator=*/ isEqualOp);
        }
      }
    }
    if (isEqualOp) {
      for (/*const*/type$ptr<QualType /*P*/> Ptr = $tryClone(CandidateTypes.$at(1).pointer_begin()), 
          /*P*/ PtrEnd = $tryClone(CandidateTypes.$at(1).pointer_end());
           $noteq_ptr(Ptr, PtrEnd); Ptr.$preInc()) {
        // Make sure we don't add the same candidate twice.
        if (!AddedTypes.insert(S.Context.getCanonicalType(new QualType(Ptr.$star())).$QualType()).second) {
          continue;
        }
        
        QualType ParamTypes[/*2*/] = new QualType [/*2*/] {
          S.Context.getLValueReferenceType(new QualType(Ptr.$star())), 
          Ptr.$star()
        };
        
        // non-volatile version
        S.AddBuiltinCandidate(new QualType(ParamTypes[0]), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
            /*IsAssigmentOperator=*/ true);
        
        boolean NeedVolatile = !(Ptr.$star()).isVolatileQualified()
           && VisibleTypeConversionsQuals.hasVolatile();
        if (NeedVolatile) {
          // volatile version
          ParamTypes[0].$assignMove(
              S.Context.getLValueReferenceType(S.Context.getVolatileType(new QualType(Ptr.$star())))
          );
          S.AddBuiltinCandidate(new QualType(ParamTypes[0]), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
              /*IsAssigmentOperator=*/ true);
        }
        if (!(Ptr.$star()).isRestrictQualified()
           && VisibleTypeConversionsQuals.hasRestrict()) {
          // restrict version
          ParamTypes[0].$assignMove(
              S.Context.getLValueReferenceType(S.Context.getRestrictType(new QualType(Ptr.$star())))
          );
          S.AddBuiltinCandidate(new QualType(ParamTypes[0]), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
              /*IsAssigmentOperator=*/ true);
          if (NeedVolatile) {
            // volatile restrict version
            ParamTypes[0].$assignMove(
                S.Context.getLValueReferenceType(S.Context.getCVRQualifiedType(new QualType(Ptr.$star()), 
                        (Qualifiers.TQ.Volatile
                           | Qualifiers.TQ.Restrict)))
            );
            S.AddBuiltinCandidate(new QualType(ParamTypes[0]), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
                /*IsAssigmentOperator=*/ true);
          }
        }
      }
    }
  }

  
  // C++ [over.built]p18:
  //
  //   For every triple (L, VQ, R), where L is an arithmetic type,
  //   VQ is either volatile or empty, and R is a promoted
  //   arithmetic type, there exist candidate operator functions of
  //   the form
  //
  //        VQ L&      operator=(VQ L&, R);
  //        VQ L&      operator*=(VQ L&, R);
  //        VQ L&      operator/=(VQ L&, R);
  //        VQ L&      operator+=(VQ L&, R);
  //        VQ L&      operator-=(VQ L&, R);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addAssignmentArithmeticOverloads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7989,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addAssignmentArithmeticOverloads", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder32addAssignmentArithmeticOverloadsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder32addAssignmentArithmeticOverloadsEb")
  //</editor-fold>
  public void addAssignmentArithmeticOverloads(boolean isEqualOp) {
    if (!HasArithmeticOrEnumeralCandidateType) {
      return;
    }
    
    for (/*uint*/int Left = 0; $less_uint(Left, NumArithmeticTypes); ++Left) {
      for (/*uint*/int Right = FirstPromotedArithmeticType;
           $less_uint(Right, LastPromotedArithmeticType); ++Right) {
        QualType ParamTypes[/*2*/]/*J*/= new$T(new QualType [2], ()->new QualType());
        ParamTypes[1].$assignMove(getArithmeticType(Right).$QualType());
        
        // Add this built-in operator as a candidate (VQ is empty).
        ParamTypes[0].$assignMove(
            S.Context.getLValueReferenceType(getArithmeticType(Left).$QualType())
        );
        S.AddBuiltinCandidate(new QualType(ParamTypes[0]), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
            /*IsAssigmentOperator=*/ isEqualOp);
        
        // Add this built-in operator as a candidate (VQ is 'volatile').
        if (VisibleTypeConversionsQuals.hasVolatile()) {
          ParamTypes[0].$assignMove(
              S.Context.getVolatileType(getArithmeticType(Left).$QualType())
          );
          ParamTypes[0].$assignMove(S.Context.getLValueReferenceType(new QualType(ParamTypes[0])));
          S.AddBuiltinCandidate(new QualType(ParamTypes[0]), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
              /*IsAssigmentOperator=*/ isEqualOp);
        }
      }
    }
    
    // Extension: Add the binary operators =, +=, -=, *=, /= for vector types.
    for (/*const*/type$ptr<QualType /*P*/> Vec1 = $tryClone(CandidateTypes.$at(0).vector_begin()), 
        /*P*/ Vec1End = $tryClone(CandidateTypes.$at(0).vector_end());
         $noteq_ptr(Vec1, Vec1End); Vec1.$preInc()) {
      for (/*const*/type$ptr<QualType /*P*/> Vec2 = $tryClone(CandidateTypes.$at(1).vector_begin()), 
          /*P*/ Vec2End = $tryClone(CandidateTypes.$at(1).vector_end());
           $noteq_ptr(Vec2, Vec2End); Vec2.$preInc()) {
        QualType ParamTypes[/*2*/]/*J*/= new$T(new QualType [2], ()->new QualType());
        ParamTypes[1].$assign(Vec2.$star());
        // Add this built-in operator as a candidate (VQ is empty).
        ParamTypes[0].$assignMove(S.Context.getLValueReferenceType(new QualType(Vec1.$star())));
        S.AddBuiltinCandidate(new QualType(ParamTypes[0]), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
            /*IsAssigmentOperator=*/ isEqualOp);
        
        // Add this built-in operator as a candidate (VQ is 'volatile').
        if (VisibleTypeConversionsQuals.hasVolatile()) {
          ParamTypes[0].$assignMove(S.Context.getVolatileType(new QualType(Vec1.$star())));
          ParamTypes[0].$assignMove(S.Context.getLValueReferenceType(new QualType(ParamTypes[0])));
          S.AddBuiltinCandidate(new QualType(ParamTypes[0]), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
              /*IsAssigmentOperator=*/ isEqualOp);
        }
      }
    }
  }

  
  // C++ [over.built]p22:
  //
  //   For every triple (L, VQ, R), where L is an integral type, VQ
  //   is either volatile or empty, and R is a promoted integral
  //   type, there exist candidate operator functions of the form
  //
  //        VQ L&       operator%=(VQ L&, R);
  //        VQ L&       operator<<=(VQ L&, R);
  //        VQ L&       operator>>=(VQ L&, R);
  //        VQ L&       operator&=(VQ L&, R);
  //        VQ L&       operator^=(VQ L&, R);
  //        VQ L&       operator|=(VQ L&, R);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addAssignmentIntegralOverloads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8055,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addAssignmentIntegralOverloads", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder30addAssignmentIntegralOverloadsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder30addAssignmentIntegralOverloadsEv")
  //</editor-fold>
  public void addAssignmentIntegralOverloads() {
    if (!HasArithmeticOrEnumeralCandidateType) {
      return;
    }
    
    for (/*uint*/int Left = FirstIntegralType; $less_uint(Left, LastIntegralType); ++Left) {
      for (/*uint*/int Right = FirstPromotedIntegralType;
           $less_uint(Right, LastPromotedIntegralType); ++Right) {
        QualType ParamTypes[/*2*/]/*J*/= new$T(new QualType [2], ()->new QualType());
        ParamTypes[1].$assignMove(getArithmeticType(Right).$QualType());
        
        // Add this built-in operator as a candidate (VQ is empty).
        ParamTypes[0].$assignMove(
            S.Context.getLValueReferenceType(getArithmeticType(Left).$QualType())
        );
        S.AddBuiltinCandidate(new QualType(ParamTypes[0]), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
        if (VisibleTypeConversionsQuals.hasVolatile()) {
          // Add this built-in operator as a candidate (VQ is 'volatile').
          ParamTypes[0].$assignMove(getArithmeticType(Left).$QualType());
          ParamTypes[0].$assignMove(S.Context.getVolatileType(new QualType(ParamTypes[0])));
          ParamTypes[0].$assignMove(S.Context.getLValueReferenceType(new QualType(ParamTypes[0])));
          S.AddBuiltinCandidate(new QualType(ParamTypes[0]), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
        }
      }
    }
  }

  
  // C++ [over.operator]p23:
  //
  //   There also exist candidate operator functions of the form
  //
  //        bool        operator!(bool);
  //        bool        operator&&(bool, bool);
  //        bool        operator||(bool, bool);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addExclaimOverload">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8087,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addExclaimOverload", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder18addExclaimOverloadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder18addExclaimOverloadEv")
  //</editor-fold>
  public void addExclaimOverload() {
    QualType ParamTy = S.Context.BoolTy.$QualType();
    S.AddBuiltinCandidate(new QualType(ParamTy), $AddrOf(ParamTy), new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
        /*IsAssignmentOperator=*/ false, 
        /*NumContextualBoolArguments=*/ 1);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addAmpAmpOrPipePipeOverload">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8093,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addAmpAmpOrPipePipeOverload", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder27addAmpAmpOrPipePipeOverloadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder27addAmpAmpOrPipePipeOverloadEv")
  //</editor-fold>
  public void addAmpAmpOrPipePipeOverload() {
    QualType ParamTypes[/*2*/] = new QualType [/*2*/] {S.Context.BoolTy.$QualType(), S.Context.BoolTy.$QualType()};
    S.AddBuiltinCandidate(S.Context.BoolTy.$QualType(), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
        /*IsAssignmentOperator=*/ false, 
        /*NumContextualBoolArguments=*/ 2);
  }

  
  // C++ [over.built]p13:
  //
  //   For every cv-qualified or cv-unqualified object type T there
  //   exist candidate operator functions of the form
  //
  //        T*         operator+(T*, ptrdiff_t);     [ABOVE]
  //        T&         operator[](T*, ptrdiff_t);
  //        T*         operator-(T*, ptrdiff_t);     [ABOVE]
  //        T*         operator+(ptrdiff_t, T*);     [ABOVE]
  //        T&         operator[](ptrdiff_t, T*);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addSubscriptOverloads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8110,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addSubscriptOverloads", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder21addSubscriptOverloadsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder21addSubscriptOverloadsEv")
  //</editor-fold>
  public void addSubscriptOverloads() {
    for (/*const*/type$ptr<QualType /*P*/> Ptr = $tryClone(CandidateTypes.$at(0).pointer_begin()), 
        /*P*/ PtrEnd = $tryClone(CandidateTypes.$at(0).pointer_end());
         $noteq_ptr(Ptr, PtrEnd); Ptr.$preInc()) {
      QualType ParamTypes[/*2*/] = new QualType [/*2*/] {Ptr.$star(), S.Context.getPointerDiffType()};
      QualType PointeeType = (Ptr.$star()).$arrow().getPointeeType();
      if (!PointeeType.$arrow().isObjectType()) {
        continue;
      }
      
      QualType ResultTy = S.Context.getLValueReferenceType(new QualType(PointeeType));
      
      // T& operator[](T*, ptrdiff_t)
      S.AddBuiltinCandidate(new QualType(ResultTy), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
    }
    
    for (/*const*/type$ptr<QualType /*P*/> Ptr = $tryClone(CandidateTypes.$at(1).pointer_begin()), 
        /*P*/ PtrEnd = $tryClone(CandidateTypes.$at(1).pointer_end());
         $noteq_ptr(Ptr, PtrEnd); Ptr.$preInc()) {
      QualType ParamTypes[/*2*/] = new QualType [/*2*/] {S.Context.getPointerDiffType(), Ptr.$star()};
      QualType PointeeType = (Ptr.$star()).$arrow().getPointeeType();
      if (!PointeeType.$arrow().isObjectType()) {
        continue;
      }
      
      QualType ResultTy = S.Context.getLValueReferenceType(new QualType(PointeeType));
      
      // T& operator[](ptrdiff_t, T*)
      S.AddBuiltinCandidate(new QualType(ResultTy), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
    }
  }

  
  // C++ [over.built]p11:
  //    For every quintuple (C1, C2, T, CV1, CV2), where C2 is a class type,
  //    C1 is the same type as C2 or is a derived class of C2, T is an object
  //    type or a function type, and CV1 and CV2 are cv-qualifier-seqs,
  //    there exist candidate operator functions of the form
  //
  //      CV12 T& operator->*(CV1 C1*, CV2 T C2::*);
  //
  //    where CV12 is the union of CV1 and CV2.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addArrowStarOverloads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8151,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addArrowStarOverloads", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder21addArrowStarOverloadsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder21addArrowStarOverloadsEv")
  //</editor-fold>
  public void addArrowStarOverloads() {
    for (/*const*/type$ptr<QualType /*P*/> Ptr = $tryClone(CandidateTypes.$at(0).pointer_begin()), 
        /*P*/ PtrEnd = $tryClone(CandidateTypes.$at(0).pointer_end());
         $noteq_ptr(Ptr, PtrEnd); Ptr.$preInc()) {
      QualType C1Ty = new QualType((Ptr.$star()));
      QualType C1/*J*/= new QualType();
      QualifierCollector Q1/*J*/= new QualifierCollector();
      C1.$assignMove(new QualType(Q1.strip(C1Ty.$arrow().getPointeeType()), 0));
      if (!isa_RecordType(C1)) {
        continue;
      }
      // heuristic to reduce number of builtin candidates in the set.
      // Add volatile/restrict version only if there are conversions to a
      // volatile/restrict type.
      if (!VisibleTypeConversionsQuals.hasVolatile() && Q1.hasVolatile()) {
        continue;
      }
      if (!VisibleTypeConversionsQuals.hasRestrict() && Q1.hasRestrict()) {
        continue;
      }
      for (/*const*/type$ptr<QualType /*P*/> MemPtr = $tryClone(CandidateTypes.$at(1).member_pointer_begin()), 
          /*P*/ MemPtrEnd = $tryClone(CandidateTypes.$at(1).member_pointer_end());
           $noteq_ptr(MemPtr, MemPtrEnd); MemPtr.$preInc()) {
        /*const*/ MemberPointerType /*P*/ mptr = cast_MemberPointerType(MemPtr.$star());
        QualType C2 = new QualType(mptr.__getClass(), 0);
        C2.$assignMove(C2.getUnqualifiedType());
        if ($noteq_QualType$C(C1, C2) && !S.IsDerivedFrom(CandidateSet.getLocation(), new QualType(C1), new QualType(C2))) {
          break;
        }
        QualType ParamTypes[/*2*/] = new QualType [/*2*/] {Ptr.$star(), MemPtr.$star()};
        // build CV12 T&
        QualType T = mptr.getPointeeType();
        if (!VisibleTypeConversionsQuals.hasVolatile()
           && T.isVolatileQualified()) {
          continue;
        }
        if (!VisibleTypeConversionsQuals.hasRestrict()
           && T.isRestrictQualified()) {
          continue;
        }
        T.$assignMove(Q1.apply(S.Context, new QualType(T)));
        QualType ResultTy = S.Context.getLValueReferenceType(new QualType(T));
        S.AddBuiltinCandidate(new QualType(ResultTy), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
      }
    }
  }

  
  // Note that we don't consider the first argument, since it has been
  // contextually converted to bool long ago. The candidates below are
  // therefore added as binary.
  //
  // C++ [over.built]p25:
  //   For every type T, where T is a pointer, pointer-to-member, or scoped
  //   enumeration type, there exist candidate operator functions of the form
  //
  //        T        operator?(bool, T, T);
  //
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addConditionalOperatorOverloads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8204,
   FQN="(anonymous namespace)::BuiltinOperatorOverloadBuilder::addConditionalOperatorOverloads", NM="_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder31addConditionalOperatorOverloadsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_130BuiltinOperatorOverloadBuilder31addConditionalOperatorOverloadsEv")
  //</editor-fold>
  public void addConditionalOperatorOverloads() {
    /// Set of (canonical) types that we've already handled.
    SmallPtrSet<QualType> AddedTypes/*J*/= new SmallPtrSet<QualType>(DenseMapInfoQualType.$Info(), 8);
    
    for (/*uint*/int ArgIdx = 0; $less_uint(ArgIdx, 2); ++ArgIdx) {
      for (/*const*/type$ptr<QualType /*P*/> Ptr = $tryClone(CandidateTypes.$at(ArgIdx).pointer_begin()), 
          /*P*/ PtrEnd = $tryClone(CandidateTypes.$at(ArgIdx).pointer_end());
           $noteq_ptr(Ptr, PtrEnd); Ptr.$preInc()) {
        if (!AddedTypes.insert(S.Context.getCanonicalType(new QualType(Ptr.$star())).$QualType()).second) {
          continue;
        }
        
        QualType ParamTypes[/*2*/] = new QualType [/*2*/] {Ptr.$star(), Ptr.$star()};
        S.AddBuiltinCandidate(new QualType(Ptr.$star()), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
      }
      
      for (/*const*/type$ptr<QualType /*P*/> MemPtr = $tryClone(CandidateTypes.$at(ArgIdx).member_pointer_begin()), 
          /*P*/ MemPtrEnd = $tryClone(CandidateTypes.$at(ArgIdx).member_pointer_end());
           $noteq_ptr(MemPtr, MemPtrEnd); MemPtr.$preInc()) {
        if (!AddedTypes.insert(S.Context.getCanonicalType(new QualType(MemPtr.$star())).$QualType()).second) {
          continue;
        }
        
        QualType ParamTypes[/*2*/] = new QualType [/*2*/] {MemPtr.$star(), MemPtr.$star()};
        S.AddBuiltinCandidate(new QualType(MemPtr.$star()), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
      }
      if (S.getLangOpts().CPlusPlus11) {
        for (/*const*/type$ptr<QualType /*P*/> Enum = $tryClone(CandidateTypes.$at(ArgIdx).enumeration_begin()), 
            /*P*/ EnumEnd = $tryClone(CandidateTypes.$at(ArgIdx).enumeration_end());
             $noteq_ptr(Enum, EnumEnd); Enum.$preInc()) {
          if (!(Enum.$star()).$arrow().<EnumType>getAs$EnumType().getDecl().isScoped()) {
            continue;
          }
          if (!AddedTypes.insert(S.Context.getCanonicalType(new QualType(Enum.$star())).$QualType()).second) {
            continue;
          }
          
          QualType ParamTypes[/*2*/] = new QualType [/*2*/] {Enum.$star(), Enum.$star()};
          S.AddBuiltinCandidate(new QualType(Enum.$star()), ParamTypes, new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
        }
      }
    }
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", Args=" + Args // NOI18N
              + ", VisibleTypeConversionsQuals=" + VisibleTypeConversionsQuals // NOI18N
              + ", HasArithmeticOrEnumeralCandidateType=" + HasArithmeticOrEnumeralCandidateType // NOI18N
              + ", CandidateTypes=" + CandidateTypes // NOI18N
              + ", CandidateSet=" + CandidateSet; // NOI18N
  }
}
