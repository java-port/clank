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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;
import static org.llvm.support.AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C;


/// This class represents a range of values.
///
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantRange.h", line = 43,
 FQN="llvm::ConstantRange", NM="_ZN4llvm13ConstantRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZN4llvm13ConstantRangeE")
//</editor-fold>
public class ConstantRange implements Destructors.ClassWithDestructor, Native.NativeComparable<ConstantRange> {
  private APInt Lower;
  private APInt Upper;

  // If we have move semantics, pass APInts by value and move them into place.
  // JAVA: typedef APInt APIntMoveTy
//  public final class APIntMoveTy extends APInt{ };
/*public:*/
  /// Initialize a full (the default) or empty set for the specified bit width.
  ///

  /// Initialize a full (the default) or empty set for the specified type.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::ConstantRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 34,
   FQN="llvm::ConstantRange::ConstantRange", NM="_ZN4llvm13ConstantRangeC1Ejb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZN4llvm13ConstantRangeC1Ejb")
  //</editor-fold>
  public ConstantRange(/*uint32_t*/int BitWidth) {
    this(BitWidth, true);
  }
  public ConstantRange(/*uint32_t*/int BitWidth, boolean Full/*= true*/) {
    // : Lower(), Upper()
    //START JInit
    this.Lower = new APInt();
    this.Upper = new APInt();
    //END JInit
    if (Full) {
      Lower.$assign(Upper.$assignMove(APInt.getMaxValue(BitWidth)));
    } else {
      Lower.$assign(Upper.$assignMove(APInt.getMinValue(BitWidth)));
    }
  }


  /// Initialize a range to hold the single specified value.
  ///

  /// Initialize a range to hold the single specified value.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::ConstantRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 43,
   FQN="llvm::ConstantRange::ConstantRange", NM="_ZN4llvm13ConstantRangeC1ENS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZN4llvm13ConstantRangeC1ENS_5APIntE")
  //</editor-fold>
  public ConstantRange(APInt V) {
    // : Lower(std::move(V)), Upper(Lower + 1)
    //START JInit
    this.Lower = new APInt(JD$Move.INSTANCE, std.move(V));
    this.Upper = Lower.$add($int2ulong(1));
    //END JInit
  }


  /// @brief Initialize a range of values explicitly. This will assert out if
  /// Lower==Upper and Lower != Min or Max value for its type. It will also
  /// assert out if the two APInt's are not the same bit width.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::ConstantRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 46,
   FQN="llvm::ConstantRange::ConstantRange", NM="_ZN4llvm13ConstantRangeC1ENS_5APIntES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZN4llvm13ConstantRangeC1ENS_5APIntES1_")
  //</editor-fold>
  public ConstantRange(APInt L, APInt U) {
    // : Lower(std::move(L)), Upper(std::move(U))
    //START JInit
    this.Lower = new APInt(JD$Move.INSTANCE, std.move(L));
    this.Upper = new APInt(JD$Move.INSTANCE, std.move(U));
    //END JInit
    assert (Lower.getBitWidth() == Upper.getBitWidth()) : "ConstantRange with unequal bit widths";
    assert ((Lower.$noteq(Upper) || (Lower.isMaxValue() || Lower.isMinValue()))) : "Lower == Upper, but they aren't min or max value!";
  }


  /// Produce the smallest range such that all values that may satisfy the given
  /// predicate with any value contained within Other is contained in the
  /// returned range.  Formally, this returns a superset of
  /// 'union over all y in Other . { x : icmp op x y is true }'.  If the exact
  /// answer is not representable as a ConstantRange, the return value will be a
  /// proper superset of the above.
  ///
  /// Example: Pred = ult and Other = i8 [2, 5) returns Result = [0, 4)
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::makeAllowedICmpRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 54,
   FQN="llvm::ConstantRange::makeAllowedICmpRegion", NM="_ZN4llvm13ConstantRange21makeAllowedICmpRegionENS_7CmpInst9PredicateERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZN4llvm13ConstantRange21makeAllowedICmpRegionENS_7CmpInst9PredicateERKS0_")
  //</editor-fold>
  public static ConstantRange makeAllowedICmpRegion(CmpInst.Predicate Pred,
                       final /*const*/ ConstantRange /*&*/ CR) {
    if (CR.isEmptySet()) {
      return new ConstantRange(CR);
    }

    /*uint32_t*/int W = CR.getBitWidth();
    switch (Pred) {
     default:
      throw new llvm_unreachable("Invalid ICmp predicate to makeAllowedICmpRegion()");
     case ICMP_EQ:
      return new ConstantRange(CR);
     case ICMP_NE:
      if (CR.isSingleElement()) {
        return new ConstantRange(new APInt(CR.getUpper()), new APInt(CR.getLower()));
      }
      return new ConstantRange(W);
     case ICMP_ULT:
      {
        APInt UMax/*J*/= CR.getUnsignedMax();
        if (UMax.isMinValue()) {
          return new ConstantRange(W, /* empty */ false);
        }
        return new ConstantRange(APInt.getMinValue(W), new APInt(UMax));
      }
     case ICMP_SLT:
      {
        APInt SMax/*J*/= CR.getSignedMax();
        if (SMax.isMinSignedValue()) {
          return new ConstantRange(W, /* empty */ false);
        }
        return new ConstantRange(APInt.getSignedMinValue(W), new APInt(SMax));
      }
     case ICMP_ULE:
      {
        APInt UMax/*J*/= CR.getUnsignedMax();
        if (UMax.isMaxValue()) {
          return new ConstantRange(W);
        }
        return new ConstantRange(APInt.getMinValue(W), UMax.$add($int2ulong(1)));
      }
     case ICMP_SLE:
      {
        APInt SMax/*J*/= CR.getSignedMax();
        if (SMax.isMaxSignedValue()) {
          return new ConstantRange(W);
        }
        return new ConstantRange(APInt.getSignedMinValue(W), SMax.$add($int2ulong(1)));
      }
     case ICMP_UGT:
      {
        APInt UMin/*J*/= CR.getUnsignedMin();
        if (UMin.isMaxValue()) {
          return new ConstantRange(W, /* empty */ false);
        }
        return new ConstantRange(UMin.$add($int2ulong(1)), APInt.getNullValue(W));
      }
     case ICMP_SGT:
      {
        APInt SMin/*J*/= CR.getSignedMin();
        if (SMin.isMaxSignedValue()) {
          return new ConstantRange(W, /* empty */ false);
        }
        return new ConstantRange(SMin.$add($int2ulong(1)), APInt.getSignedMinValue(W));
      }
     case ICMP_UGE:
      {
        APInt UMin/*J*/= CR.getUnsignedMin();
        if (UMin.isMinValue()) {
          return new ConstantRange(W);
        }
        return new ConstantRange(new APInt(UMin), APInt.getNullValue(W));
      }
     case ICMP_SGE:
      {
        APInt SMin/*J*/= CR.getSignedMin();
        if (SMin.isMinSignedValue()) {
          return new ConstantRange(W);
        }
        return new ConstantRange(new APInt(SMin), APInt.getSignedMinValue(W));
      }
    }
  }


  /// Produce the largest range such that all values in the returned range
  /// satisfy the given predicate with all values contained within Other.
  /// Formally, this returns a subset of
  /// 'intersection over all y in Other . { x : icmp op x y is true }'.  If the
  /// exact answer is not representable as a ConstantRange, the return value
  /// will be a proper subset of the above.
  ///
  /// Example: Pred = ult and Other = i8 [2, 5) returns [0, 2)
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::makeSatisfyingICmpRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 120,
   FQN="llvm::ConstantRange::makeSatisfyingICmpRegion", NM="_ZN4llvm13ConstantRange24makeSatisfyingICmpRegionENS_7CmpInst9PredicateERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZN4llvm13ConstantRange24makeSatisfyingICmpRegionENS_7CmpInst9PredicateERKS0_")
  //</editor-fold>
  public static ConstantRange makeSatisfyingICmpRegion(CmpInst.Predicate Pred,
                          final /*const*/ ConstantRange /*&*/ CR) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Follows from De-Morgan's laws:
      //
      // ~(~A union ~B) == A intersect B.
      //
      return $c$.clean($c$.track(makeAllowedICmpRegion(CmpInst.getInversePredicate(Pred), CR)).
          inverse());
    } finally {
      $c$.$destroy();
    }
  }


  /// Produce the exact range such that all values in the returned range satisfy
  /// the given predicate with any value contained within Other. Formally, this
  /// returns the exact answer when the superset of 'union over all y in Other
  /// is exactly same as the subset of intersection over all y in Other.
  /// { x : icmp op x y is true}'.
  ///
  /// Example: Pred = ult and Other = i8 3 returns [0, 3)
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::makeExactICmpRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 130,
   FQN="llvm::ConstantRange::makeExactICmpRegion", NM="_ZN4llvm13ConstantRange19makeExactICmpRegionENS_7CmpInst9PredicateERKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZN4llvm13ConstantRange19makeExactICmpRegionENS_7CmpInst9PredicateERKNS_5APIntE")
  //</editor-fold>
  public static ConstantRange makeExactICmpRegion(CmpInst.Predicate Pred,
                     final /*const*/ APInt /*&*/ C) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Computes the exact range that is equal to both the constant ranges returned
      // by makeAllowedICmpRegion and makeSatisfyingICmpRegion. This is always true
      // when RHS is a singleton such as an APInt and so the assert is valid.
      // However for non-singleton RHS, for example ult [2,5) makeAllowedICmpRegion
      // returns [0,4) but makeSatisfyICmpRegion returns [0,2).
      //
      assert ($c$.track(makeAllowedICmpRegion(Pred, $c$.track(new ConstantRange(new APInt(C))))).$eq($c$.track(makeSatisfyingICmpRegion(Pred, $c$.track(new ConstantRange(new APInt(C))))))); $c$.clean();
      return $c$.clean(makeAllowedICmpRegion(Pred, $c$.track(new ConstantRange(new APInt(C)))));
    } finally {
      $c$.$destroy();
    }
  }


  /// Return the largest range containing all X such that "X BinOpC Y" is
  /// guaranteed not to wrap (overflow) for all Y in Other.
  ///
  /// NB! The returned set does *not* contain **all** possible values of X for
  /// which "X BinOpC Y" does not wrap -- some viable values of X may be
  /// missing, so you cannot use this to contrain X's range.  E.g. in the last
  /// example, "(-2) + 1" is both nsw and nuw (so the "X" could be -2), but (-2)
  /// is not in the set returned.
  ///
  /// Examples:
  ///  typedef OverflowingBinaryOperator OBO;
  ///  #define MGNR makeGuaranteedNoWrapRegion
  ///  MGNR(Add, [i8 1, 2), OBO::NoSignedWrap) == [-128, 127)
  ///  MGNR(Add, [i8 1, 2), OBO::NoUnsignedWrap) == [0, -1)
  ///  MGNR(Add, [i8 0, 1), OBO::NoUnsignedWrap) == Full Set
  ///  MGNR(Add, [i8 1, 2), OBO::NoUnsignedWrap | OBO::NoSignedWrap)
  ///    == [0,INT_MAX)
  ///  MGNR(Add, [i8 -1, 6), OBO::NoSignedWrap) == [INT_MIN+1, INT_MAX-4)
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::makeGuaranteedNoWrapRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 168,
   FQN="llvm::ConstantRange::makeGuaranteedNoWrapRegion", NM="_ZN4llvm13ConstantRange26makeGuaranteedNoWrapRegionENS_11Instruction9BinaryOpsERKS0_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZN4llvm13ConstantRange26makeGuaranteedNoWrapRegionENS_11Instruction9BinaryOpsERKS0_j")
  //</editor-fold>
  public static ConstantRange makeGuaranteedNoWrapRegion(/*BinaryOps*/int BinOp,
                            final /*const*/ ConstantRange /*&*/ Other,
                            /*uint*/int NoWrapKind) {
    ConstantRange Result = null;
    try {
      // JAVA: typedef OverflowingBinaryOperator OBO
//      final class OBO extends OverflowingBinaryOperator{ };

      // Computes the intersection of CR0 and CR1.  It is different from
      // intersectWith in that the ConstantRange returned will only contain elements
      // in both CR0 and CR1 (i.e. SubsetIntersect(X, Y) is a *subset*, proper or
      // not, of both X and Y).
      TypeType2Type<ConstantRange, ConstantRange, ConstantRange> SubsetIntersect = /*[]*/ (final /*const*/ ConstantRange /*&*/ CR0, final /*const*/ ConstantRange /*&*/ CR1) -> {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              return $c$.clean($c$.track($c$.track(CR0.inverse()).unionWith($c$.track(CR1.inverse()))).inverse());
            } finally {
              $c$.$destroy();
            }
          };
      assert (BinOp >= Instruction.BinaryOps.BinaryOpsBegin && BinOp < Instruction.BinaryOps.BinaryOpsEnd) : "Binary operators only!";
      assert ((NoWrapKind == OverflowingBinaryOperator.NoSignedWrap || NoWrapKind == OverflowingBinaryOperator.NoUnsignedWrap || NoWrapKind == (OverflowingBinaryOperator.NoUnsignedWrap | OverflowingBinaryOperator.NoSignedWrap))) : "NoWrapKind invalid!";

      /*uint*/int BitWidth = Other.getBitWidth();
      if (BinOp != Instruction.BinaryOps.Add) {
        // Conservative answer: empty set
        return new ConstantRange(BitWidth, false);
      }
      {

        /*const*/ APInt /*P*/ C = Other.getSingleElement();
        if ((C != null)) {
          if (C.isMinValue()) {
            // Full set: nothing signed / unsigned wraps when added to 0.
            return new ConstantRange(BitWidth);
          }
        }
      }

      Result/*J*/= new ConstantRange(BitWidth);
      if (((NoWrapKind & OverflowingBinaryOperator.NoUnsignedWrap) != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(Result.$assignMove(
              $c$.track(SubsetIntersect.$call(Result, $c$.track(new ConstantRange(APInt.getNullValue(BitWidth),
                      Other.getUnsignedMax().$sub()))))
          ));
        } finally {
          $c$.$destroy();
        }
      }
      if (((NoWrapKind & OverflowingBinaryOperator.NoSignedWrap) != 0)) {
        APInt SignedMin = Other.getSignedMin();
        APInt SignedMax = Other.getSignedMax();
        if (SignedMax.isStrictlyPositive()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(Result.$assignMove($c$.track(SubsetIntersect.$call(
                    Result,
                    $c$.track(new ConstantRange(APInt.getSignedMinValue(BitWidth),
                        APInt.getSignedMinValue(BitWidth).$sub(SignedMax)))
                ))));
          } finally {
            $c$.$destroy();
          }
        }
        if (SignedMin.isNegative()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(Result.$assignMove($c$.track(SubsetIntersect.$call(
                    Result, $c$.track(new ConstantRange(APInt.getSignedMinValue(BitWidth).$sub(SignedMin),
                        APInt.getSignedMinValue(BitWidth)))
                ))));
          } finally {
            $c$.$destroy();
          }
        }
      }

      return new ConstantRange(JD$Move.INSTANCE, Result);
    } finally {
      if (Result != null) { Result.$destroy(); }
    }
  }


  /// Set up \p Pred and \p RHS such that
  /// ConstantRange::makeExactICmpRegion(Pred, RHS) == *this.  Return true if
  /// successful.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::getEquivalentICmp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 142,
   FQN="llvm::ConstantRange::getEquivalentICmp", NM="_ZNK4llvm13ConstantRange17getEquivalentICmpERNS_7CmpInst9PredicateERNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange17getEquivalentICmpERNS_7CmpInst9PredicateERNS_5APIntE")
  //</editor-fold>
  public boolean getEquivalentICmp(final type$ref<CmpInst.Predicate /*&*/> Pred,
                   final APInt /*&*/ RHS) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      boolean Success = false;
      if (isFullSet() || isEmptySet()) {
        Pred.$set(isEmptySet() ? CmpInst.Predicate.ICMP_ULT : CmpInst.Predicate.ICMP_UGE);
        RHS.$assignMove(new APInt(JD$UInt_ULong.INSTANCE, getBitWidth(), $int2ulong(0)));
        Success = true;
      } else if (getLower().isMinSignedValue() || getLower().isMinValue()) {
        Pred.$set(getLower().isMinSignedValue() ? CmpInst.Predicate.ICMP_SLT : CmpInst.Predicate.ICMP_ULT);
        RHS.$assign(getUpper());
        Success = true;
      } else if (getUpper().isMinSignedValue() || getUpper().isMinValue()) {
        Pred.$set(getUpper().isMinSignedValue() ? CmpInst.Predicate.ICMP_SGE : CmpInst.Predicate.ICMP_UGE);
        RHS.$assign(getLower());
        Success = true;
      }
      assert ((!Success || $c$.track(ConstantRange.makeExactICmpRegion(Pred.$deref(), RHS)).$eq(/*Deref*/this))) : "Bad result!"; $c$.clean();

      return Success;
    } finally {
      $c$.$destroy();
    }
  }


  /// Return the lower value for this range.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::getLower">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantRange.h", line = 124,
   FQN="llvm::ConstantRange::getLower", NM="_ZNK4llvm13ConstantRange8getLowerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange8getLowerEv")
  //</editor-fold>
  public /*const*/ APInt /*&*/ getLower() /*const*/ {
    return Lower;
  }


  /// Return the upper value for this range.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::getUpper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantRange.h", line = 128,
   FQN="llvm::ConstantRange::getUpper", NM="_ZNK4llvm13ConstantRange8getUpperEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange8getUpperEv")
  //</editor-fold>
  public /*const*/ APInt /*&*/ getUpper() /*const*/ {
    return Upper;
  }


  /// Get the bit width of this ConstantRange.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::getBitWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantRange.h", line = 132,
   FQN="llvm::ConstantRange::getBitWidth", NM="_ZNK4llvm13ConstantRange11getBitWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange11getBitWidthEv")
  //</editor-fold>
  public /*uint32_t*/int getBitWidth() /*const*/ {
    return Lower.getBitWidth();
  }


  /// Return true if this set contains all of the elements possible
  /// for this data-type.
  ///

  /// isFullSet - Return true if this set contains all of the elements possible
  /// for this data-type
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::isFullSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 229,
   FQN="llvm::ConstantRange::isFullSet", NM="_ZNK4llvm13ConstantRange9isFullSetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange9isFullSetEv")
  //</editor-fold>
  public boolean isFullSet() /*const*/ {
    return Lower.$eq(Upper) && Lower.isMaxValue();
  }


  /// Return true if this set contains no members.
  ///

  /// isEmptySet - Return true if this set contains no members.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::isEmptySet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 235,
   FQN="llvm::ConstantRange::isEmptySet", NM="_ZNK4llvm13ConstantRange10isEmptySetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange10isEmptySetEv")
  //</editor-fold>
  public boolean isEmptySet() /*const*/ {
    return Lower.$eq(Upper) && Lower.isMinValue();
  }


  /// Return true if this set wraps around the top of the range.
  /// For example: [100, 8).
  ///

  /// isWrappedSet - Return true if this set wraps around the top of the range,
  /// for example: [100, 8)
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::isWrappedSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 242,
   FQN="llvm::ConstantRange::isWrappedSet", NM="_ZNK4llvm13ConstantRange12isWrappedSetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange12isWrappedSetEv")
  //</editor-fold>
  public boolean isWrappedSet() /*const*/ {
    return Lower.ugt(Upper);
  }


  /// Return true if this set wraps around the INT_MIN of
  /// its bitwidth. For example: i8 [120, 140).
  ///

  /// isSignWrappedSet - Return true if this set wraps around the INT_MIN of
  /// its bitwidth, for example: i8 [120, 140).
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::isSignWrappedSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 249,
   FQN="llvm::ConstantRange::isSignWrappedSet", NM="_ZNK4llvm13ConstantRange16isSignWrappedSetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange16isSignWrappedSetEv")
  //</editor-fold>
  public boolean isSignWrappedSet() /*const*/ {
    return contains(APInt.getSignedMaxValue(getBitWidth()))
       && contains(APInt.getSignedMinValue(getBitWidth()));
  }


  /// Return true if the specified value is in the set.
  ///

  /// contains - Return true if the specified value is in the set.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::contains">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 319,
   FQN="llvm::ConstantRange::contains", NM="_ZNK4llvm13ConstantRange8containsERKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange8containsERKNS_5APIntE")
  //</editor-fold>
  public boolean contains(final /*const*/ APInt /*&*/ V) /*const*/ {
    if (Lower.$eq(Upper)) {
      return isFullSet();
    }
    if (!isWrappedSet()) {
      return Lower.ule(V) && V.ult(Upper);
    }
    return Lower.ule(V) || V.ult(Upper);
  }


  /// Return true if the other range is a subset of this one.
  ///

  /// contains - Return true if the argument is a subset of this range.
  /// Two equal sets contain each other. The empty set contained by all other
  /// sets.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::contains">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 332,
   FQN="llvm::ConstantRange::contains", NM="_ZNK4llvm13ConstantRange8containsERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange8containsERKS0_")
  //</editor-fold>
  public boolean contains(final /*const*/ ConstantRange /*&*/ Other) /*const*/ {
    if (isFullSet() || Other.isEmptySet()) {
      return true;
    }
    if (isEmptySet() || Other.isFullSet()) {
      return false;
    }
    if (!isWrappedSet()) {
      if (Other.isWrappedSet()) {
        return false;
      }

      return Lower.ule(Other.getLower()) && Other.getUpper().ule(Upper);
    }
    if (!Other.isWrappedSet()) {
      return Other.getUpper().ule(Upper)
         || Lower.ule(Other.getLower());
    }

    return Other.getUpper().ule(Upper) && Lower.ule(Other.getLower());
  }


  /// If this set contains a single element, return it, otherwise return null.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::getSingleElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantRange.h", line = 163,
   FQN="llvm::ConstantRange::getSingleElement", NM="_ZNK4llvm13ConstantRange16getSingleElementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange16getSingleElementEv")
  //</editor-fold>
  public /*const*/ APInt /*P*/ getSingleElement() /*const*/ {
    if (Upper.$eq(Lower.$add($int2ulong(1)))) {
      return $AddrOf(Lower);
    }
    return null;
  }


  /// Return true if this set contains exactly one member.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::isSingleElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantRange.h", line = 171,
   FQN="llvm::ConstantRange::isSingleElement", NM="_ZNK4llvm13ConstantRange15isSingleElementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange15isSingleElementEv")
  //</editor-fold>
  public boolean isSingleElement() /*const*/ {
    return getSingleElement() != null;
  }


  /// Return the number of elements in this set.
  ///

  /// getSetSize - Return the number of elements in this set.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::getSetSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 256,
   FQN="llvm::ConstantRange::getSetSize", NM="_ZNK4llvm13ConstantRange10getSetSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange10getSetSizeEv")
  //</editor-fold>
  public APInt getSetSize() /*const*/ {
    if (isFullSet()) {
      APInt Size/*J*/= new APInt(JD$UInt_ULong.INSTANCE, getBitWidth() + 1, $int2ulong(0));
      Size.setBit(getBitWidth());
      return Size;
    }

    // This is also correct for wrapped sets.
    return (Upper.$sub(Lower)).zext(getBitWidth() + 1);
  }


  /// Return the largest unsigned value contained in the ConstantRange.
  ///

  /// getUnsignedMax - Return the largest unsigned value contained in the
  /// ConstantRange.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::getUnsignedMax">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 270,
   FQN="llvm::ConstantRange::getUnsignedMax", NM="_ZNK4llvm13ConstantRange14getUnsignedMaxEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange14getUnsignedMaxEv")
  //</editor-fold>
  public APInt getUnsignedMax() /*const*/ {
    if (isFullSet() || isWrappedSet()) {
      return APInt.getMaxValue(getBitWidth());
    }
    return getUpper().$sub($int2ulong(1));
  }


  /// Return the smallest unsigned value contained in the ConstantRange.
  ///

  /// getUnsignedMin - Return the smallest unsigned value contained in the
  /// ConstantRange.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::getUnsignedMin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 279,
   FQN="llvm::ConstantRange::getUnsignedMin", NM="_ZNK4llvm13ConstantRange14getUnsignedMinEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange14getUnsignedMinEv")
  //</editor-fold>
  public APInt getUnsignedMin() /*const*/ {
    if (isFullSet() || (isWrappedSet() && getUpper().$noteq($int2ulong(0)))) {
      return APInt.getMinValue(getBitWidth());
    }
    return new APInt(getLower());
  }


  /// Return the largest signed value contained in the ConstantRange.
  ///

  /// getSignedMax - Return the largest signed value contained in the
  /// ConstantRange.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::getSignedMax">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 288,
   FQN="llvm::ConstantRange::getSignedMax", NM="_ZNK4llvm13ConstantRange12getSignedMaxEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange12getSignedMaxEv")
  //</editor-fold>
  public APInt getSignedMax() /*const*/ {
    APInt SignedMax/*J*/= APInt.getSignedMaxValue(getBitWidth());
    if (!isWrappedSet()) {
      if (getLower().sle(getUpper().$sub($int2ulong(1)))) {
        return getUpper().$sub($int2ulong(1));
      }
      return SignedMax;
    }
    if (getLower().isNegative() == getUpper().isNegative()) {
      return SignedMax;
    }
    return getUpper().$sub($int2ulong(1));
  }


  /// Return the smallest signed value contained in the ConstantRange.
  ///

  /// getSignedMin - Return the smallest signed value contained in the
  /// ConstantRange.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::getSignedMin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 303,
   FQN="llvm::ConstantRange::getSignedMin", NM="_ZNK4llvm13ConstantRange12getSignedMinEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange12getSignedMinEv")
  //</editor-fold>
  public APInt getSignedMin() /*const*/ {
    APInt SignedMin/*J*/= APInt.getSignedMinValue(getBitWidth());
    if (!isWrappedSet()) {
      if (getLower().sle(getUpper().$sub($int2ulong(1)))) {
        return new APInt(getLower());
      }
      return SignedMin;
    }
    if ((getUpper().$sub($int2ulong(1))).slt(getLower())) {
      if (getUpper().$noteq(SignedMin)) {
        return SignedMin;
      }
    }
    return new APInt(getLower());
  }


  /// Return true if this range is equal to another range.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantRange.h", line = 195,
   FQN="llvm::ConstantRange::operator==", NM="_ZNK4llvm13ConstantRangeeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRangeeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ ConstantRange /*&*/ CR) /*const*/ {
    return Lower.$eq(CR.Lower) && Upper.$eq(CR.Upper);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantRange.h", line = 198,
   FQN="llvm::ConstantRange::operator!=", NM="_ZNK4llvm13ConstantRangeneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRangeneERKS0_")
  //</editor-fold>
  public boolean $noteq(final /*const*/ ConstantRange /*&*/ CR) /*const*/ {
    return !$eq(CR);
  }


  /// Subtract the specified constant from the endpoints of this constant range.

  /// subtract - Subtract the specified constant from the endpoints of this
  /// constant range.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::subtract">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 352,
   FQN="llvm::ConstantRange::subtract", NM="_ZNK4llvm13ConstantRange8subtractERKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange8subtractERKNS_5APIntE")
  //</editor-fold>
  public ConstantRange subtract(final /*const*/ APInt /*&*/ Val) /*const*/ {
    assert (Val.getBitWidth() == getBitWidth()) : "Wrong bit width";
    // If the set is empty or full, don't modify the endpoints.
    if (Lower.$eq(Upper)) {
      return new ConstantRange(/*Deref*/this);
    }
    return new ConstantRange(Lower.$sub(Val), Upper.$sub(Val));
  }


  /// \brief Subtract the specified range from this range (aka relative
  /// complement of the sets).

  /// \brief Subtract the specified range from this range (aka relative complement
  /// of the sets).
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::difference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 362,
   FQN="llvm::ConstantRange::difference", NM="_ZNK4llvm13ConstantRange10differenceERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange10differenceERKS0_")
  //</editor-fold>
  public ConstantRange difference(final /*const*/ ConstantRange /*&*/ CR) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(intersectWith($c$.track(CR.inverse())));
    } finally {
      $c$.$destroy();
    }
  }


  /// Return the range that results from the intersection of
  /// this range with another range.  The resultant range is guaranteed to
  /// include all elements contained in both input ranges, and to have the
  /// smallest possible set size that does so.  Because there may be two
  /// intersections with the same set size, A.intersectWith(B) might not
  /// be equal to B.intersectWith(A).
  ///

  /// intersectWith - Return the range that results from the intersection of this
  /// range with another range.  The resultant range is guaranteed to include all
  /// elements contained in both input ranges, and to have the smallest possible
  /// set size that does so.  Because there may be two intersections with the
  /// same set size, A.intersectWith(B) might not be equal to B.intersectWith(A).
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::intersectWith">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 371,
   FQN="llvm::ConstantRange::intersectWith", NM="_ZNK4llvm13ConstantRange13intersectWithERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange13intersectWithERKS0_")
  //</editor-fold>
  public ConstantRange intersectWith(final /*const*/ ConstantRange /*&*/ CR) /*const*/ {
    assert (getBitWidth() == CR.getBitWidth()) : "ConstantRange types don't agree!";

    // Handle common cases.
    if (isEmptySet() || CR.isFullSet()) {
      return new ConstantRange(/*Deref*/this);
    }
    if (CR.isEmptySet() || isFullSet()) {
      return new ConstantRange(CR);
    }
    if (!isWrappedSet() && CR.isWrappedSet()) {
      return CR.intersectWith(/*Deref*/this);
    }
    if (!isWrappedSet() && !CR.isWrappedSet()) {
      if (Lower.ult(CR.Lower)) {
        if (Upper.ule(CR.Lower)) {
          return new ConstantRange(getBitWidth(), false);
        }
        if (Upper.ult(CR.Upper)) {
          return new ConstantRange(new APInt(CR.Lower), new APInt(Upper));
        }

        return new ConstantRange(CR);
      }
      if (Upper.ult(CR.Upper)) {
        return new ConstantRange(/*Deref*/this);
      }
      if (Lower.ult(CR.Upper)) {
        return new ConstantRange(new APInt(Lower), new APInt(CR.Upper));
      }

      return new ConstantRange(getBitWidth(), false);
    }
    if (isWrappedSet() && !CR.isWrappedSet()) {
      if (CR.Lower.ult(Upper)) {
        if (CR.Upper.ult(Upper)) {
          return new ConstantRange(CR);
        }
        if (CR.Upper.ule(Lower)) {
          return new ConstantRange(new APInt(CR.Lower), new APInt(Upper));
        }
        if (getSetSize().ult(CR.getSetSize())) {
          return new ConstantRange(/*Deref*/this);
        }
        return new ConstantRange(CR);
      }
      if (CR.Lower.ult(Lower)) {
        if (CR.Upper.ule(Lower)) {
          return new ConstantRange(getBitWidth(), false);
        }

        return new ConstantRange(new APInt(Lower), new APInt(CR.Upper));
      }
      return new ConstantRange(CR);
    }
    if (CR.Upper.ult(Upper)) {
      if (CR.Lower.ult(Upper)) {
        if (getSetSize().ult(CR.getSetSize())) {
          return new ConstantRange(/*Deref*/this);
        }
        return new ConstantRange(CR);
      }
      if (CR.Lower.ult(Lower)) {
        return new ConstantRange(new APInt(Lower), new APInt(CR.Upper));
      }

      return new ConstantRange(CR);
    }
    if (CR.Upper.ule(Lower)) {
      if (CR.Lower.ult(Lower)) {
        return new ConstantRange(/*Deref*/this);
      }

      return new ConstantRange(new APInt(CR.Lower), new APInt(Upper));
    }
    if (getSetSize().ult(CR.getSetSize())) {
      return new ConstantRange(/*Deref*/this);
    }
    return new ConstantRange(CR);
  }


  /// Return the range that results from the union of this range
  /// with another range.  The resultant range is guaranteed to include the
  /// elements of both sets, but may contain more.  For example, [3, 9) union
  /// [12,15) is [3, 15), which includes 9, 10, and 11, which were not included
  /// in either set before.
  ///

  /// unionWith - Return the range that results from the union of this range with
  /// another range.  The resultant range is guaranteed to include the elements of
  /// both sets, but may contain more.  For example, [3, 9) union [12,15) is
  /// [3, 15), which includes 9, 10, and 11, which were not included in either
  /// set before.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::unionWith">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 452,
   FQN="llvm::ConstantRange::unionWith", NM="_ZNK4llvm13ConstantRange9unionWithERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange9unionWithERKS0_")
  //</editor-fold>
  public ConstantRange unionWith(final /*const*/ ConstantRange /*&*/ CR) /*const*/ {
    assert (getBitWidth() == CR.getBitWidth()) : "ConstantRange types don't agree!";
    if (isFullSet() || CR.isEmptySet()) {
      return new ConstantRange(/*Deref*/this);
    }
    if (CR.isFullSet() || isEmptySet()) {
      return new ConstantRange(CR);
    }
    if (!isWrappedSet() && CR.isWrappedSet()) {
      return CR.unionWith(/*Deref*/this);
    }
    if (!isWrappedSet() && !CR.isWrappedSet()) {
      if (CR.Upper.ult(Lower) || Upper.ult(CR.Lower)) {
        // If the two ranges are disjoint, find the smaller gap and bridge it.
        APInt d1 = CR.Lower.$sub(Upper);
        APInt d2 = Lower.$sub(CR.Upper);
        if (d1.ult(d2)) {
          return new ConstantRange(new APInt(Lower), new APInt(CR.Upper));
        }
        return new ConstantRange(new APInt(CR.Lower), new APInt(Upper));
      }

      APInt L = new APInt(Lower);
      APInt U = new APInt(Upper);
      if (CR.Lower.ult(L)) {
        L.$assign(CR.Lower);
      }
      if ((CR.Upper.$sub($int2ulong(1))).ugt(U.$sub($int2ulong(1)))) {
        U.$assign(CR.Upper);
      }
      if (L.$eq($int2ulong(0)) && U.$eq($int2ulong(0))) {
        return new ConstantRange(getBitWidth());
      }

      return new ConstantRange(new APInt(L), new APInt(U));
    }
    if (!CR.isWrappedSet()) {
      // ------U   L-----  and  ------U   L----- : this
      //   L--U                            L--U  : CR
      if (CR.Upper.ule(Upper) || CR.Lower.uge(Lower)) {
        return new ConstantRange(/*Deref*/this);
      }

      // ------U   L----- : this
      //    L---------U   : CR
      if (CR.Lower.ule(Upper) && Lower.ule(CR.Upper)) {
        return new ConstantRange(getBitWidth());
      }

      // ----U       L---- : this
      //       L---U       : CR
      //    <d1>  <d2>
      if (Upper.ule(CR.Lower) && CR.Upper.ule(Lower)) {
        APInt d1 = CR.Lower.$sub(Upper);
        APInt d2 = Lower.$sub(CR.Upper);
        if (d1.ult(d2)) {
          return new ConstantRange(new APInt(Lower), new APInt(CR.Upper));
        }
        return new ConstantRange(new APInt(CR.Lower), new APInt(Upper));
      }

      // ----U     L----- : this
      //        L----U    : CR
      if (Upper.ult(CR.Lower) && Lower.ult(CR.Upper)) {
        return new ConstantRange(new APInt(CR.Lower), new APInt(Upper));
      }

      // ------U    L---- : this
      //    L-----U       : CR
      assert (CR.Lower.ult(Upper) && CR.Upper.ult(Lower)) : "ConstantRange::unionWith missed a case with one range wrapped";
      return new ConstantRange(new APInt(Lower), new APInt(CR.Upper));
    }

    // ------U    L----  and  ------U    L---- : this
    // -U  L-----------  and  ------------U  L : CR
    if (CR.Lower.ule(Upper) || Lower.ule(CR.Upper)) {
      return new ConstantRange(getBitWidth());
    }

    APInt L = new APInt(Lower);
    APInt U = new APInt(Upper);
    if (CR.Upper.ugt(U)) {
      U.$assign(CR.Upper);
    }
    if (CR.Lower.ult(L)) {
      L.$assign(CR.Lower);
    }

    return new ConstantRange(new APInt(L), new APInt(U));
  }


  /// Return a new range in the specified integer type, which must
  /// be strictly larger than the current type.  The returned range will
  /// correspond to the possible range of values if the source range had been
  /// zero extended to BitWidth.

  /// zeroExtend - Return a new range in the specified integer type, which must
  /// be strictly larger than the current type.  The returned range will
  /// correspond to the possible range of values as if the source range had been
  /// zero extended.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::zeroExtend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 533,
   FQN="llvm::ConstantRange::zeroExtend", NM="_ZNK4llvm13ConstantRange10zeroExtendEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange10zeroExtendEj")
  //</editor-fold>
  public ConstantRange zeroExtend(/*uint32_t*/int DstTySize) /*const*/ {
    if (isEmptySet()) {
      return new ConstantRange(DstTySize, /*isFullSet=*/ false);
    }

    /*uint*/int SrcTySize = getBitWidth();
    assert ($less_uint(SrcTySize, DstTySize)) : "Not a value extension";
    if (isFullSet() || isWrappedSet()) {
      // Change into [0, 1 << src bit width)
      APInt LowerExt/*J*/= new APInt(JD$UInt_ULong.INSTANCE, DstTySize, $int2ulong(0));
      if (Upper.$not()) { // special case: [X, 0) -- not really wrapping around
        LowerExt.$assignMove(Lower.zext(DstTySize));
      }
      return new ConstantRange(new APInt(LowerExt), APInt.getOneBitSet(DstTySize, SrcTySize));
    }

    return new ConstantRange(Lower.zext(DstTySize), Upper.zext(DstTySize));
  }


  /// Return a new range in the specified integer type, which must
  /// be strictly larger than the current type.  The returned range will
  /// correspond to the possible range of values if the source range had been
  /// sign extended to BitWidth.

  /// signExtend - Return a new range in the specified integer type, which must
  /// be strictly larger than the current type.  The returned range will
  /// correspond to the possible range of values as if the source range had been
  /// sign extended.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::signExtend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 553,
   FQN="llvm::ConstantRange::signExtend", NM="_ZNK4llvm13ConstantRange10signExtendEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange10signExtendEj")
  //</editor-fold>
  public ConstantRange signExtend(/*uint32_t*/int DstTySize) /*const*/ {
    if (isEmptySet()) {
      return new ConstantRange(DstTySize, /*isFullSet=*/ false);
    }

    /*uint*/int SrcTySize = getBitWidth();
    assert ($less_uint(SrcTySize, DstTySize)) : "Not a value extension";

    // special case: [X, INT_MIN) -- not really wrapping around
    if (Upper.isMinSignedValue()) {
      return new ConstantRange(Lower.sext(DstTySize), Upper.zext(DstTySize));
    }
    if (isFullSet() || isSignWrappedSet()) {
      return new ConstantRange(APInt.getHighBitsSet(DstTySize, DstTySize - SrcTySize + 1),
          APInt.getLowBitsSet(DstTySize, SrcTySize - 1).$add($int2ulong(1)));
    }

    return new ConstantRange(Lower.sext(DstTySize), Upper.sext(DstTySize));
  }


  /// Return a new range in the specified integer type, which must be
  /// strictly smaller than the current type.  The returned range will
  /// correspond to the possible range of values if the source range had been
  /// truncated to the specified type.

  /// truncate - Return a new range in the specified integer type, which must be
  /// strictly smaller than the current type.  The returned range will
  /// correspond to the possible range of values as if the source range had been
  /// truncated to the specified type.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::truncate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 575,
   FQN="llvm::ConstantRange::truncate", NM="_ZNK4llvm13ConstantRange8truncateEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange8truncateEj")
  //</editor-fold>
  public ConstantRange truncate(/*uint32_t*/int DstTySize) /*const*/ {
    ConstantRange Union = null;
    try {
      assert ($greater_uint(getBitWidth(), DstTySize)) : "Not a value truncation";
      if (isEmptySet()) {
        return new ConstantRange(DstTySize, /*isFullSet=*/ false);
      }
      if (isFullSet()) {
        return new ConstantRange(DstTySize, /*isFullSet=*/ true);
      }

      APInt MaxValue = APInt.getMaxValue(DstTySize).zext(getBitWidth());
      APInt MaxBitValue/*J*/= new APInt(JD$UInt_ULong.INSTANCE, getBitWidth(), $int2ulong(0));
      MaxBitValue.setBit(DstTySize);

      APInt LowerDiv/*J*/= new APInt(Lower);
      APInt UpperDiv/*J*/= new APInt(Upper);
      Union/*J*/= new ConstantRange(DstTySize, /*isFullSet=*/ false);

      // Analyze wrapped sets in their two parts: [0, Upper) \/ [Lower, MaxValue]
      // We use the non-wrapped set code to analyze the [Lower, MaxValue) part, and
      // then we do the union with [MaxValue, Upper)
      if (isWrappedSet()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // If Upper is greater than Max Value, it covers the whole truncated range.
          if (Upper.uge(MaxValue)) {
            return new ConstantRange(DstTySize, /*isFullSet=*/ true);
          }

          $c$.clean(Union.$assignMove($c$.track(new ConstantRange(APInt.getMaxValue(DstTySize), Upper.trunc(DstTySize)))));
          UpperDiv.$assignMove(APInt.getMaxValue(getBitWidth()));

          // Union covers the MaxValue case, so return if the remaining range is just
          // MaxValue.
          if (LowerDiv.$eq(UpperDiv)) {
            return new ConstantRange(JD$Move.INSTANCE, Union);
          }
        } finally {
          $c$.$destroy();
        }
      }

      // Chop off the most significant bits that are past the destination bitwidth.
      if (LowerDiv.uge(MaxValue)) {
        APInt Div/*J*/= new APInt(JD$UInt_ULong.INSTANCE, getBitWidth(), $int2ulong(0));
        APInt.udivrem(LowerDiv, MaxBitValue, Div, LowerDiv);
        UpperDiv.$assignMove(UpperDiv.$sub(MaxBitValue.$star(Div)));
      }
      if (UpperDiv.ule(MaxValue)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean($c$.track(new ConstantRange(LowerDiv.trunc(DstTySize),
              UpperDiv.trunc(DstTySize))).unionWith(Union));
        } finally {
          $c$.$destroy();
        }
      }

      // The truncated value wraps around. Check if we can do better than fullset.
      APInt UpperModulo = UpperDiv.$sub(MaxBitValue);
      if (UpperModulo.ult(LowerDiv)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean($c$.track(new ConstantRange(LowerDiv.trunc(DstTySize),
              UpperModulo.trunc(DstTySize))).unionWith(Union));
        } finally {
          $c$.$destroy();
        }
      }

      return new ConstantRange(DstTySize, /*isFullSet=*/ true);
    } finally {
      if (Union != null) { Union.$destroy(); }
    }
  }


  /// Make this range have the bit width given by \p BitWidth. The
  /// value is zero extended, truncated, or left alone to make it that width.

  /// zextOrTrunc - make this range have the bit width given by \p DstTySize. The
  /// value is zero extended, truncated, or left alone to make it that width.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::zextOrTrunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 628,
   FQN="llvm::ConstantRange::zextOrTrunc", NM="_ZNK4llvm13ConstantRange11zextOrTruncEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange11zextOrTruncEj")
  //</editor-fold>
  public ConstantRange zextOrTrunc(/*uint32_t*/int DstTySize) /*const*/ {
    /*uint*/int SrcTySize = getBitWidth();
    if ($greater_uint(SrcTySize, DstTySize)) {
      return truncate(DstTySize);
    }
    if ($less_uint(SrcTySize, DstTySize)) {
      return zeroExtend(DstTySize);
    }
    return new ConstantRange(/*Deref*/this);
  }


  /// Make this range have the bit width given by \p BitWidth. The
  /// value is sign extended, truncated, or left alone to make it that width.

  /// sextOrTrunc - make this range have the bit width given by \p DstTySize. The
  /// value is sign extended, truncated, or left alone to make it that width.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::sextOrTrunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 639,
   FQN="llvm::ConstantRange::sextOrTrunc", NM="_ZNK4llvm13ConstantRange11sextOrTruncEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange11sextOrTruncEj")
  //</editor-fold>
  public ConstantRange sextOrTrunc(/*uint32_t*/int DstTySize) /*const*/ {
    /*uint*/int SrcTySize = getBitWidth();
    if ($greater_uint(SrcTySize, DstTySize)) {
      return truncate(DstTySize);
    }
    if ($less_uint(SrcTySize, DstTySize)) {
      return signExtend(DstTySize);
    }
    return new ConstantRange(/*Deref*/this);
  }


  /// Return a new range representing the possible values resulting
  /// from an addition of a value in this range and a value in \p Other.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 648,
   FQN="llvm::ConstantRange::add", NM="_ZNK4llvm13ConstantRange3addERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange3addERKS0_")
  //</editor-fold>
  public ConstantRange add(final /*const*/ ConstantRange /*&*/ Other) /*const*/ {
    ConstantRange X = null;
    try {
      if (isEmptySet() || Other.isEmptySet()) {
        return new ConstantRange(getBitWidth(), /*isFullSet=*/ false);
      }
      if (isFullSet() || Other.isFullSet()) {
        return new ConstantRange(getBitWidth(), /*isFullSet=*/ true);
      }

      APInt Spread_X = getSetSize();
      APInt Spread_Y = Other.getSetSize();
      APInt NewLower = getLower().$add(Other.getLower());
      APInt NewUpper = getUpper().$add(Other.getUpper()).$sub($int2ulong(1));
      if (NewLower.$eq(NewUpper)) {
        return new ConstantRange(getBitWidth(), /*isFullSet=*/ true);
      }

      X = new ConstantRange(new APInt(NewLower), new APInt(NewUpper));
      if (X.getSetSize().ult(Spread_X) || X.getSetSize().ult(Spread_Y)) {
        // We've wrapped, therefore, full set.
        return new ConstantRange(getBitWidth(), /*isFullSet=*/ true);
      }

      return new ConstantRange(JD$Move.INSTANCE, X);
    } finally {
      if (X != null) { X.$destroy(); }
    }
  }


  /// Return a new range representing the possible values resulting
  /// from a subtraction of a value in this range and a value in \p Other.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::sub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 669,
   FQN="llvm::ConstantRange::sub", NM="_ZNK4llvm13ConstantRange3subERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange3subERKS0_")
  //</editor-fold>
  public ConstantRange sub(final /*const*/ ConstantRange /*&*/ Other) /*const*/ {
    ConstantRange X = null;
    try {
      if (isEmptySet() || Other.isEmptySet()) {
        return new ConstantRange(getBitWidth(), /*isFullSet=*/ false);
      }
      if (isFullSet() || Other.isFullSet()) {
        return new ConstantRange(getBitWidth(), /*isFullSet=*/ true);
      }

      APInt Spread_X = getSetSize();
      APInt Spread_Y = Other.getSetSize();
      APInt NewLower = getLower().$sub(Other.getUpper()).$add($int2ulong(1));
      APInt NewUpper = getUpper().$sub(Other.getLower());
      if (NewLower.$eq(NewUpper)) {
        return new ConstantRange(getBitWidth(), /*isFullSet=*/ true);
      }

      X = new ConstantRange(new APInt(NewLower), new APInt(NewUpper));
      if (X.getSetSize().ult(Spread_X) || X.getSetSize().ult(Spread_Y)) {
        // We've wrapped, therefore, full set.
        return new ConstantRange(getBitWidth(), /*isFullSet=*/ true);
      }

      return new ConstantRange(JD$Move.INSTANCE, X);
    } finally {
      if (X != null) { X.$destroy(); }
    }
  }


  /// Return a new range representing the possible values resulting
  /// from a multiplication of a value in this range and a value in \p Other,
  /// treating both this and \p Other as unsigned ranges.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::multiply">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 690,
   FQN="llvm::ConstantRange::multiply", NM="_ZNK4llvm13ConstantRange8multiplyERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange8multiplyERKS0_")
  //</editor-fold>
  public ConstantRange multiply(final /*const*/ ConstantRange /*&*/ Other) /*const*/ {
    ConstantRange Result_zext = null;
    ConstantRange UR = null;
    ConstantRange Result_sext = null;
    ConstantRange SR = null;
    try {
      // TODO: If either operand is a single element and the multiply is known to
      // be non-wrapping, round the result min and max value to the appropriate
      // multiple of that element. If wrapping is possible, at least adjust the
      // range according to the greatest power-of-two factor of the single element.
      if (isEmptySet() || Other.isEmptySet()) {
        return new ConstantRange(getBitWidth(), /*isFullSet=*/ false);
      }

      // Multiplication is signedness-independent. However different ranges can be
      // obtained depending on how the input ranges are treated. These different
      // ranges are all conservatively correct, but one might be better than the
      // other. We calculate two ranges; one treating the inputs as unsigned
      // and the other signed, then return the smallest of these ranges.

      // Unsigned range first.
      APInt this_min = getUnsignedMin().zext(getBitWidth() * 2);
      APInt this_max = getUnsignedMax().zext(getBitWidth() * 2);
      APInt Other_min = Other.getUnsignedMin().zext(getBitWidth() * 2);
      APInt Other_max = Other.getUnsignedMax().zext(getBitWidth() * 2);

      Result_zext = new ConstantRange(this_min.$star(Other_min),
          this_max.$star(Other_max).$add($int2ulong(1)));
      UR = Result_zext.truncate(getBitWidth());

      // If the unsigned range doesn't wrap, and isn't negative then it's a range
      // from one positive number to another which is as good as we can generate.
      // In this case, skip the extra work of generating signed ranges which aren't
      // going to be better than this range.
      if (!UR.isWrappedSet() && UR.getLower().isNonNegative()) {
        return new ConstantRange(JD$Move.INSTANCE, UR);
      }

      // Now the signed range. Because we could be dealing with negative numbers
      // here, the lower bound is the smallest of the cartesian product of the
      // lower and upper ranges; for example:
      //   [-1,4) * [-2,3) = min(-1*-2, -1*2, 3*-2, 3*2) = -6.
      // Similarly for the upper bound, swapping min for max.
      this_min.$assignMove(getSignedMin().sext(getBitWidth() * 2));
      this_max.$assignMove(getSignedMax().sext(getBitWidth() * 2));
      Other_min.$assignMove(Other.getSignedMin().sext(getBitWidth() * 2));
      Other_max.$assignMove(Other.getSignedMax().sext(getBitWidth() * 2));

      /*std.initializer_list<APInt>*/ APInt[] L = new /*const*/ APInt [/*4*/] {
        this_min.$star(Other_min), this_min.$star(Other_max),
        this_max.$star(Other_min), this_max.$star(Other_max)};
      Compare<APInt> Compare = /*[]*/ (final /*const*/ APInt /*&*/ A, final /*const*/ APInt /*&*/ B) -> {
            return A.slt(B);
          };
      Result_sext/*J*/= new ConstantRange(std.min(new std.initializer_list<APInt>(L), Compare), std.max(new std.initializer_list<APInt>(L), Compare).$add($int2ulong(1)));
      SR = Result_sext.truncate(getBitWidth());

      return new ConstantRange(UR.getSetSize().ult(SR.getSetSize()) ? UR : SR);
    } finally {
      if (SR != null) { SR.$destroy(); }
      if (Result_sext != null) { Result_sext.$destroy(); }
      if (UR != null) { UR.$destroy(); }
      if (Result_zext != null) { Result_zext.$destroy(); }
    }
  }


  /// Return a new range representing the possible values resulting
  /// from a signed maximum of a value in this range and a value in \p Other.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::smax">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 743,
   FQN="llvm::ConstantRange::smax", NM="_ZNK4llvm13ConstantRange4smaxERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange4smaxERKS0_")
  //</editor-fold>
  public ConstantRange smax(final /*const*/ ConstantRange /*&*/ Other) /*const*/ {
    // X smax Y is: range(smax(X_smin, Y_smin),
    //                    smax(X_smax, Y_smax))
    if (isEmptySet() || Other.isEmptySet()) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ false);
    }
    APInt NewL = new APInt(APIntOps.smax(getSignedMin(), Other.getSignedMin()));
    APInt NewU = APIntOps.smax(getSignedMax(), Other.getSignedMax()).$add($int2ulong(1));
    if (NewU.$eq(NewL)) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ true);
    }
    return new ConstantRange(new APInt(NewL), new APInt(NewU));
  }


  /// Return a new range representing the possible values resulting
  /// from an unsigned maximum of a value in this range and a value in \p Other.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::umax">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 756,
   FQN="llvm::ConstantRange::umax", NM="_ZNK4llvm13ConstantRange4umaxERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange4umaxERKS0_")
  //</editor-fold>
  public ConstantRange umax(final /*const*/ ConstantRange /*&*/ Other) /*const*/ {
    // X umax Y is: range(umax(X_umin, Y_umin),
    //                    umax(X_umax, Y_umax))
    if (isEmptySet() || Other.isEmptySet()) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ false);
    }
    APInt NewL = new APInt(APIntOps.umax(getUnsignedMin(), Other.getUnsignedMin()));
    APInt NewU = APIntOps.umax(getUnsignedMax(), Other.getUnsignedMax()).$add($int2ulong(1));
    if (NewU.$eq(NewL)) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ true);
    }
    return new ConstantRange(new APInt(NewL), new APInt(NewU));
  }


  /// Return a new range representing the possible values resulting
  /// from a signed minimum of a value in this range and a value in \p Other.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::smin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 769,
   FQN="llvm::ConstantRange::smin", NM="_ZNK4llvm13ConstantRange4sminERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange4sminERKS0_")
  //</editor-fold>
  public ConstantRange smin(final /*const*/ ConstantRange /*&*/ Other) /*const*/ {
    // X smin Y is: range(smin(X_smin, Y_smin),
    //                    smin(X_smax, Y_smax))
    if (isEmptySet() || Other.isEmptySet()) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ false);
    }
    APInt NewL = new APInt(APIntOps.smin(getSignedMin(), Other.getSignedMin()));
    APInt NewU = APIntOps.smin(getSignedMax(), Other.getSignedMax()).$add($int2ulong(1));
    if (NewU.$eq(NewL)) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ true);
    }
    return new ConstantRange(new APInt(NewL), new APInt(NewU));
  }


  /// Return a new range representing the possible values resulting
  /// from an unsigned minimum of a value in this range and a value in \p Other.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::umin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 782,
   FQN="llvm::ConstantRange::umin", NM="_ZNK4llvm13ConstantRange4uminERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange4uminERKS0_")
  //</editor-fold>
  public ConstantRange umin(final /*const*/ ConstantRange /*&*/ Other) /*const*/ {
    // X umin Y is: range(umin(X_umin, Y_umin),
    //                    umin(X_umax, Y_umax))
    if (isEmptySet() || Other.isEmptySet()) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ false);
    }
    APInt NewL = new APInt(APIntOps.umin(getUnsignedMin(), Other.getUnsignedMin()));
    APInt NewU = APIntOps.umin(getUnsignedMax(), Other.getUnsignedMax()).$add($int2ulong(1));
    if (NewU.$eq(NewL)) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ true);
    }
    return new ConstantRange(new APInt(NewL), new APInt(NewU));
  }


  /// Return a new range representing the possible values resulting
  /// from an unsigned division of a value in this range and a value in
  /// \p Other.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::udiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 795,
   FQN="llvm::ConstantRange::udiv", NM="_ZNK4llvm13ConstantRange4udivERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange4udivERKS0_")
  //</editor-fold>
  public ConstantRange udiv(final /*const*/ ConstantRange /*&*/ RHS) /*const*/ {
    if (isEmptySet() || RHS.isEmptySet() || RHS.getUnsignedMax().$eq($int2ulong(0))) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ false);
    }
    if (RHS.isFullSet()) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ true);
    }

    APInt Lower = getUnsignedMin().udiv(RHS.getUnsignedMax());

    APInt RHS_umin = RHS.getUnsignedMin();
    if (RHS_umin.$eq($int2ulong(0))) {
      // We want the lowest value in RHS excluding zero. Usually that would be 1
      // except for a range in the form of [X, 1) in which case it would be X.
      if (RHS.getUpper().$eq($int2ulong(1))) {
        RHS_umin.$assign(RHS.getLower());
      } else {
        RHS_umin.$assignMove(new APInt(JD$UInt_ULong.INSTANCE, getBitWidth(), $int2ulong(1)));
      }
    }

    APInt Upper = getUnsignedMax().udiv(RHS_umin).$add($int2ulong(1));

    // If the LHS is Full and the RHS is a wrapped interval containing 1 then
    // this could occur.
    if (Lower.$eq(Upper)) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ true);
    }

    return new ConstantRange(new APInt(Lower), new APInt(Upper));
  }


  /// Return a new range representing the possible values resulting
  /// from a binary-and of a value in this range by a value in \p Other.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::binaryAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 824,
   FQN="llvm::ConstantRange::binaryAnd", NM="_ZNK4llvm13ConstantRange9binaryAndERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange9binaryAndERKS0_")
  //</editor-fold>
  public ConstantRange binaryAnd(final /*const*/ ConstantRange /*&*/ Other) /*const*/ {
    if (isEmptySet() || Other.isEmptySet()) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ false);
    }

    // TODO: replace this with something less conservative
    APInt umin = new APInt(APIntOps.umin(Other.getUnsignedMax(), getUnsignedMax()));
    if (umin.isAllOnesValue()) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ true);
    }
    return new ConstantRange(APInt.getNullValue(getBitWidth()), umin.$add($int2ulong(1)));
  }


  /// Return a new range representing the possible values resulting
  /// from a binary-or of a value in this range by a value in \p Other.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::binaryOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 837,
   FQN="llvm::ConstantRange::binaryOr", NM="_ZNK4llvm13ConstantRange8binaryOrERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange8binaryOrERKS0_")
  //</editor-fold>
  public ConstantRange binaryOr(final /*const*/ ConstantRange /*&*/ Other) /*const*/ {
    if (isEmptySet() || Other.isEmptySet()) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ false);
    }

    // TODO: replace this with something less conservative
    APInt umax = new APInt(APIntOps.umax(getUnsignedMin(), Other.getUnsignedMin()));
    if (umax.isMinValue()) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ true);
    }
    return new ConstantRange(new APInt(umax), APInt.getNullValue(getBitWidth()));
  }


  /// Return a new range representing the possible values resulting
  /// from a left shift of a value in this range by a value in \p Other.
  /// TODO: This isn't fully implemented yet.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::shl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 850,
   FQN="llvm::ConstantRange::shl", NM="_ZNK4llvm13ConstantRange3shlERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange3shlERKS0_")
  //</editor-fold>
  public ConstantRange shl(final /*const*/ ConstantRange /*&*/ Other) /*const*/ {
    if (isEmptySet() || Other.isEmptySet()) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ false);
    }

    APInt min = getUnsignedMin().shl(Other.getUnsignedMin());
    APInt max = getUnsignedMax().shl(Other.getUnsignedMax());

    // there's no overflow!
    APInt Zeros/*J*/= new APInt(JD$UInt_ULong.INSTANCE, getBitWidth(), $uint2ulong(getUnsignedMax().countLeadingZeros()));
    if (Zeros.ugt(Other.getUnsignedMax())) {
      return new ConstantRange(new APInt(min), max.$add($int2ulong(1)));
    }

    // FIXME: implement the other tricky cases
    return new ConstantRange(getBitWidth(), /*isFullSet=*/ true);
  }


  /// Return a new range representing the possible values resulting from a
  /// logical right shift of a value in this range and a value in \p Other.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::lshr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 867,
   FQN="llvm::ConstantRange::lshr", NM="_ZNK4llvm13ConstantRange4lshrERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange4lshrERKS0_")
  //</editor-fold>
  public ConstantRange lshr(final /*const*/ ConstantRange /*&*/ Other) /*const*/ {
    if (isEmptySet() || Other.isEmptySet()) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ false);
    }

    APInt max = getUnsignedMax().lshr(Other.getUnsignedMin());
    APInt min = getUnsignedMin().lshr(Other.getUnsignedMax());
    if (min.$eq(max.$add($int2ulong(1)))) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ true);
    }

    return new ConstantRange(new APInt(min), max.$add($int2ulong(1)));
  }


  /// Return a new range that is the logical not of the current set.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::inverse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 880,
   FQN="llvm::ConstantRange::inverse", NM="_ZNK4llvm13ConstantRange7inverseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange7inverseEv")
  //</editor-fold>
  public ConstantRange inverse() /*const*/ {
    if (isFullSet()) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ false);
    }
    if (isEmptySet()) {
      return new ConstantRange(getBitWidth(), /*isFullSet=*/ true);
    }
    return new ConstantRange(new APInt(Upper), new APInt(Lower));
  }


  /// Print out the bounds to a stream.
  ///

  /// print - Print out the bounds to a stream...
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 890,
   FQN="llvm::ConstantRange::print", NM="_ZNK4llvm13ConstantRange5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    if (isFullSet()) {
      OS.$out(/*KEEP_STR*/"full-set");
    } else if (isEmptySet()) {
      OS.$out(/*KEEP_STR*/"empty-set");
    } else {
      $out_raw_ostream_APInt$C($out_raw_ostream_APInt$C(OS.$out(/*KEEP_STR*/$LSQUARE), Lower).$out(/*KEEP_STR*/$COMMA), Upper).$out(/*KEEP_STR*/$RPAREN);
    }
  }


  /// Allow printing from a debugger easily.
  ///

  /// dump - Allow printing from a debugger easily...
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp", line = 901,
   FQN="llvm::ConstantRange::dump", NM="_ZNK4llvm13ConstantRange4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZNK4llvm13ConstantRange4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(dbgs());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::ConstantRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantRange.h", line = 43,
   FQN="llvm::ConstantRange::ConstantRange", NM="_ZN4llvm13ConstantRangeC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZN4llvm13ConstantRangeC1EOS0_")
  //</editor-fold>
  public /*inline*/ ConstantRange(JD$Move _dparam, final ConstantRange /*&&*/$Prm0) {
    // : Lower(static_cast<ConstantRange &&>().Lower), Upper(static_cast<ConstantRange &&>().Upper)
    //START JInit
    this.Lower = new APInt(JD$Move.INSTANCE, $Prm0.Lower);
    this.Upper = new APInt(JD$Move.INSTANCE, $Prm0.Upper);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantRange.h", line = 43,
   FQN="llvm::ConstantRange::operator=", NM="_ZN4llvm13ConstantRangeaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZN4llvm13ConstantRangeaSEOS0_")
  //</editor-fold>
  public /*inline*/ ConstantRange /*&*/ $assignMove(final ConstantRange /*&&*/$Prm0) {
    this.Lower.$assignMove($Prm0.Lower);
    this.Upper.$assignMove($Prm0.Upper);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::~ConstantRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantRange.h", line = 43,
   FQN="llvm::ConstantRange::~ConstantRange", NM="_ZN4llvm13ConstantRangeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZN4llvm13ConstantRangeD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Upper.$destroy();
    Lower.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::ConstantRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantRange.h", line = 43,
   FQN="llvm::ConstantRange::ConstantRange", NM="_ZN4llvm13ConstantRangeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZN4llvm13ConstantRangeC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ConstantRange(final /*const*/ ConstantRange /*&*/ $Prm0) {
    // : Lower(.Lower), Upper(.Upper)
    //START JInit
    this.Lower = new APInt($Prm0.Lower);
    this.Upper = new APInt($Prm0.Upper);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantRange::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantRange.h", line = 43,
   FQN="llvm::ConstantRange::operator=", NM="_ZN4llvm13ConstantRangeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Float2Int.cpp -nm=_ZN4llvm13ConstantRangeaSERKS0_")
  //</editor-fold>
  public /*inline*/ ConstantRange /*&*/ $assign(final /*const*/ ConstantRange /*&*/ $Prm0) {
    this.Lower.$assign($Prm0.Lower);
    this.Upper.$assign($Prm0.Upper);
    return /*Deref*/this;
  }


  @Override public String toString() {
    return "" + "Lower=" + Lower // NOI18N
              + ", Upper=" + Upper; // NOI18N
  }
}
