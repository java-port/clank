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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


/// RangeSet contains a set of ranges. If the set is empty, then
///  there the value of a symbol is overly constrained and there are no
///  possible values for that symbol.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 73,
 FQN="(anonymous namespace)::RangeSet", NM="_ZN12_GLOBAL__N_18RangeSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_18RangeSetE")
//</editor-fold>
public class RangeSet implements FoldingSetTrait.Profilable, NativeCloneable<RangeSet>, Destructors.ClassWithDestructor, Native.NativeComparable<RangeSet> {
  // JAVA: typedef llvm::ImmutableSet<Range, RangeTrait> PrimRangeSet
//  public final class PrimRangeSet extends ImmutableSet<Range>{ };
  private ImmutableSet<Range> ranges; // no need to make const, since it is an
  // ImmutableSet - this allows default operator=
  // to work.
/*public:*/
  // JAVA: typedef PrimRangeSet::Factory Factory
//  public final class Factory extends ImmutableSet.Factory<Range>{ };
  // JAVA: typedef PrimRangeSet::iterator iterator
//  public final class iterator extends ImutAVLValueIteratorTypeBoolType<Range>{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeSet::RangeSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 82,
   FQN="(anonymous namespace)::RangeSet::RangeSet", NM="_ZN12_GLOBAL__N_18RangeSetC1EN4llvm12ImmutableSetINS_5RangeENS_10RangeTraitEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_18RangeSetC1EN4llvm12ImmutableSetINS_5RangeENS_10RangeTraitEEE")
  //</editor-fold>
  public RangeSet(ImmutableSet<Range> RS) {
    // : ranges(RS) 
    //START JInit
    this.ranges = new ImmutableSet<Range>(RS);
    //END JInit
  }

  
  /// Create a new set with all ranges of this set and RS.
  /// Possible intersections are not checked here.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeSet::addRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 86,
   FQN="(anonymous namespace)::RangeSet::addRange", NM="_ZN12_GLOBAL__N_18RangeSet8addRangeERN4llvm12ImmutableSetINS_5RangeENS_10RangeTraitEE7FactoryERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_18RangeSet8addRangeERN4llvm12ImmutableSetINS_5RangeENS_10RangeTraitEE7FactoryERKS0_")
  //</editor-fold>
  public RangeSet addRange(final ImmutableSet.Factory<Range>/*&*/ F, final /*const*/ RangeSet /*&*/ RS) {
    ImmutableSet<Range> Ranges = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Ranges/*J*/= new ImmutableSet<Range>(RS.ranges);
      for (final /*const*/ Range /*&*/ range : ranges)  {
        $c$.clean(Ranges.$assign($c$.track(F.add($c$.track(new ImmutableSet<Range>(Ranges)), range))));
      }
      return $c$.clean(new RangeSet($c$.track(new ImmutableSet<Range>(Ranges))));
    } finally {
      if (Ranges != null) { Ranges.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeSet::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 93,
   FQN="(anonymous namespace)::RangeSet::begin", NM="_ZNK12_GLOBAL__N_18RangeSet5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZNK12_GLOBAL__N_18RangeSet5beginEv")
  //</editor-fold>
  public ImutAVLValueIteratorTypeBoolType<Range> begin() /*const*/ {
    return ranges.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeSet::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 94,
   FQN="(anonymous namespace)::RangeSet::end", NM="_ZNK12_GLOBAL__N_18RangeSet3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZNK12_GLOBAL__N_18RangeSet3endEv")
  //</editor-fold>
  public ImutAVLValueIteratorTypeBoolType<Range> end() /*const*/ {
    return ranges.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeSet::isEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 96,
   FQN="(anonymous namespace)::RangeSet::isEmpty", NM="_ZNK12_GLOBAL__N_18RangeSet7isEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZNK12_GLOBAL__N_18RangeSet7isEmptyEv")
  //</editor-fold>
  public boolean isEmpty() /*const*/ {
    return ranges.isEmpty();
  }

  
  /// Construct a new RangeSet representing '{ [from, to] }'.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeSet::RangeSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 99,
   FQN="(anonymous namespace)::RangeSet::RangeSet", NM="_ZN12_GLOBAL__N_18RangeSetC1ERN4llvm12ImmutableSetINS_5RangeENS_10RangeTraitEE7FactoryERKNS1_6APSIntESA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_18RangeSetC1ERN4llvm12ImmutableSetINS_5RangeENS_10RangeTraitEE7FactoryERKNS1_6APSIntESA_")
  //</editor-fold>
  public RangeSet(final ImmutableSet.Factory<Range>/*&*/ F, final /*const*/ APSInt /*&*/ from, final /*const*/ APSInt /*&*/ to) {
    // : ranges($c$.track(F.add($c$.track(F.getEmptySet()), Range(from, to)))) 
    //START JInit
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      this.ranges = $c$.clean(F.add($c$.track(F.getEmptySet()), new Range(from, to)));
    } finally {
      $c$.$destroy();
    }
    //END JInit
  }

  
  /// Profile - Generates a hash profile of this RangeSet for use
  ///  by FoldingSet.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeSet::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 104,
   FQN="(anonymous namespace)::RangeSet::Profile", NM="_ZNK12_GLOBAL__N_18RangeSet7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZNK12_GLOBAL__N_18RangeSet7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public/*public*/ void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ranges.Profile(ID);
  }

  
  /// getConcreteValue - If a symbol is contrained to equal a specific integer
  ///  constant then this method returns that value.  Otherwise, it returns
  ///  NULL.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeSet::getConcreteValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 109,
   FQN="(anonymous namespace)::RangeSet::getConcreteValue", NM="_ZNK12_GLOBAL__N_18RangeSet16getConcreteValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZNK12_GLOBAL__N_18RangeSet16getConcreteValueEv")
  //</editor-fold>
  public /*const*/ APSInt /*P*/ getConcreteValue() /*const*/ {
    return ranges.isSingleton() ? ranges.begin().$arrow().getConcreteValue() : null;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeSet::IntersectInRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 114,
   FQN="(anonymous namespace)::RangeSet::IntersectInRange", NM="_ZNK12_GLOBAL__N_18RangeSet16IntersectInRangeERN5clang4ento17BasicValueFactoryERN4llvm12ImmutableSetINS_5RangeENS_10RangeTraitEE7FactoryERKNS5_6APSIntESE_RS9_RNS5_20ImutAVLValueIteratorIS9_EESI_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZNK12_GLOBAL__N_18RangeSet16IntersectInRangeERN5clang4ento17BasicValueFactoryERN4llvm12ImmutableSetINS_5RangeENS_10RangeTraitEE7FactoryERKNS5_6APSIntESE_RS9_RNS5_20ImutAVLValueIteratorIS9_EESI_")
  //</editor-fold>
  private void IntersectInRange(final BasicValueFactory /*&*/ BV, final ImmutableSet.Factory<Range>/*&*/ F, 
                  final /*const*/ APSInt /*&*/ Lower, 
                  final /*const*/ APSInt /*&*/ Upper, 
                  final ImmutableSet<Range> /*&*/ newRanges, 
                  final ImutAVLValueIteratorTypeBoolType<Range> /*&*/ i, 
                  final ImutAVLValueIteratorTypeBoolType<Range> /*&*/ e) /*const*/ {
    // There are six cases for each range R in the set:
    //   1. R is entirely before the intersection range.
    //   2. R is entirely after the intersection range.
    //   3. R contains the entire intersection range.
    //   4. R starts before the intersection range and ends in the middle.
    //   5. R starts in the middle of the intersection range and ends after it.
    //   6. R is entirely contained in the intersection range.
    // These correspond to each of the conditions below.
    for (; i.$noteq(/* i = begin(), e = end() */ e); i.$preInc()) {
      if (i.$arrow().To().$less(Lower)) {
        continue;
      }
      if (i.$arrow().From().$greater(Upper)) {
        break;
      }
      if (i.$arrow().Includes(Lower)) {
        if (i.$arrow().Includes(Upper)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(newRanges.$assign($c$.track(F.add($c$.track(new ImmutableSet<Range>(newRanges)), new Range(BV.getValue(Lower), 
                        BV.getValue(Upper))))));
            break;
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(newRanges.$assign($c$.track(F.add($c$.track(new ImmutableSet<Range>(newRanges)), new Range(BV.getValue(Lower), i.$arrow().To())))));
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        if (i.$arrow().Includes(Upper)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(newRanges.$assign($c$.track(F.add($c$.track(new ImmutableSet<Range>(newRanges)), new Range(i.$arrow().From(), BV.getValue(Upper))))));
            break;
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(newRanges.$assign($c$.track(F.add($c$.track(new ImmutableSet<Range>(newRanges)), i.$star()))));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeSet::getMinValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 153,
   FQN="(anonymous namespace)::RangeSet::getMinValue", NM="_ZNK12_GLOBAL__N_18RangeSet11getMinValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZNK12_GLOBAL__N_18RangeSet11getMinValueEv")
  //</editor-fold>
  private /*const*/ APSInt /*&*/ getMinValue() /*const*/ {
      assert (!isEmpty());
    return ranges.begin().$arrow().From();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeSet::pin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 158,
   FQN="(anonymous namespace)::RangeSet::pin", NM="_ZNK12_GLOBAL__N_18RangeSet3pinERN4llvm6APSIntES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZNK12_GLOBAL__N_18RangeSet3pinERN4llvm6APSIntES3_")
  //</editor-fold>
  private boolean pin(final APSInt /*&*/ Lower, final APSInt /*&*/ Upper) /*const*/ {
    // This function has nine cases, the cartesian product of range-testing
    // both the upper and lower bounds against the symbol's type.
    // Each case requires a different pinning operation.
    // The function returns false if the described range is entirely outside
    // the range of values for the associated symbol.
    APSIntType Type/*J*/= new APSIntType(getMinValue());
    APSIntType.RangeTestResultKind LowerTest = Type.testInRange(Lower, true);
    APSIntType.RangeTestResultKind UpperTest = Type.testInRange(Upper, true);
    switch (LowerTest) {
     case RTR_Below:
      switch (UpperTest) {
       case RTR_Below:
        // The entire range is outside the symbol's set of possible values.
        // If this is a conventionally-ordered range, the state is infeasible.
        if (Lower.$lesseq(Upper)) {
          return false;
        }
        
        // However, if the range wraps around, it spans all possible values.
        Lower.$assignMove(Type.getMinValue());
        Upper.$assignMove(Type.getMaxValue());
        break;
       case RTR_Within:
        // The range starts below what's possible but ends within it. Pin.
        Lower.$assignMove(Type.getMinValue());
        Type.apply(Upper);
        break;
       case RTR_Above:
        // The range spans all possible values for the symbol. Pin.
        Lower.$assignMove(Type.getMinValue());
        Upper.$assignMove(Type.getMaxValue());
        break;
      }
      break;
     case RTR_Within:
      switch (UpperTest) {
       case RTR_Below:
        // The range wraps around, but all lower values are not possible.
        Type.apply(Lower);
        Upper.$assignMove(Type.getMaxValue());
        break;
       case RTR_Within:
        // The range may or may not wrap around, but both limits are valid.
        Type.apply(Lower);
        Type.apply(Upper);
        break;
       case RTR_Above:
        // The range starts within what's possible but ends above it. Pin.
        Type.apply(Lower);
        Upper.$assignMove(Type.getMaxValue());
        break;
      }
      break;
     case RTR_Above:
      switch (UpperTest) {
       case RTR_Below:
        // The range wraps but is outside the symbol's set of possible values.
        return false;
       case RTR_Within:
        // The range starts above what's possible but ends within it (wrap).
        Lower.$assignMove(Type.getMinValue());
        Type.apply(Upper);
        break;
       case RTR_Above:
        // The entire range is outside the symbol's set of possible values.
        // If this is a conventionally-ordered range, the state is infeasible.
        if (Lower.$lesseq(Upper)) {
          return false;
        }
        
        // However, if the range wraps around, it spans all possible values.
        Lower.$assignMove(Type.getMinValue());
        Upper.$assignMove(Type.getMaxValue());
        break;
      }
      break;
    }
    
    return true;
  }

/*public:*/
  // Returns a set containing the values in the receiving set, intersected with
  // the closed range [Lower, Upper]. Unlike the Range type, this range uses
  // modular arithmetic, corresponding to the common treatment of C integer
  // overflow. Thus, if the Lower bound is greater than the Upper bound, the
  // range is taken to wrap around. This is equivalent to taking the
  // intersection with the two ranges [Min, Upper] and [Lower, Max],
  // or, alternatively, /removing/ all integers between Upper and Lower.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeSet::Intersect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 247,
   FQN="(anonymous namespace)::RangeSet::Intersect", NM="_ZNK12_GLOBAL__N_18RangeSet9IntersectERN5clang4ento17BasicValueFactoryERN4llvm12ImmutableSetINS_5RangeENS_10RangeTraitEE7FactoryENS5_6APSIntESC_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZNK12_GLOBAL__N_18RangeSet9IntersectERN5clang4ento17BasicValueFactoryERN4llvm12ImmutableSetINS_5RangeENS_10RangeTraitEE7FactoryENS5_6APSIntESC_")
  //</editor-fold>
  public RangeSet Intersect(final BasicValueFactory /*&*/ BV, final ImmutableSet.Factory<Range>/*&*/ F, 
           APSInt Lower, APSInt Upper) /*const*/ {
    ImmutableSet<Range> newRanges = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!pin(Lower, Upper)) {
        return $c$.clean(new RangeSet($c$.track(F.getEmptySet())));
      }
      
      newRanges = F.getEmptySet();
      
      ImutAVLValueIteratorTypeBoolType<Range> i = begin();
      ImutAVLValueIteratorTypeBoolType<Range> e = end();
      if (Lower.$lesseq(Upper)) {
        IntersectInRange(BV, F, Lower, Upper, newRanges, i, e);
      } else {
        // The order of the next two statements is important!
        // IntersectInRange() does not reset the iteration state for i and e.
        // Therefore, the lower range most be handled first.
        IntersectInRange(BV, F, BV.getMinValue(Upper), Upper, newRanges, i, e);
        IntersectInRange(BV, F, Lower, BV.getMaxValue(Lower), newRanges, i, e);
      }
      
      return $c$.clean(new RangeSet($c$.track(new ImmutableSet<Range>(newRanges))));
    } finally {
      if (newRanges != null) { newRanges.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeSet::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 268,
   FQN="(anonymous namespace)::RangeSet::print", NM="_ZNK12_GLOBAL__N_18RangeSet5printERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZNK12_GLOBAL__N_18RangeSet5printERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ os) /*const*/ {
    boolean isFirst = true;
    os.$out(/*KEEP_STR*/"{ ");
    for (ImutAVLValueIteratorTypeBoolType<Range> i = begin(), e = end(); i.$noteq(e); i.$preInc()) {
      if (isFirst) {
        isFirst = false;
      } else {
        os.$out(/*KEEP_STR*/$COMMA_SPACE);
      }

      os.$out_char($$LSQUARE).$out(i.$arrow().From().__toString(10)).$out(/*KEEP_STR*/$COMMA_SPACE).$out(i.$arrow().To().__toString(10)).$out_char(
          $$RSQUARE
      );
    }
    os.$out(/*KEEP_STR*/" }");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeSet::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 283,
   FQN="(anonymous namespace)::RangeSet::operator==", NM="_ZNK12_GLOBAL__N_18RangeSeteqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZNK12_GLOBAL__N_18RangeSeteqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ RangeSet /*&*/ other) /*const*/ {
    return ranges.$eq(other.ranges);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeSet::RangeSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 73,
   FQN="(anonymous namespace)::RangeSet::RangeSet", NM="_ZN12_GLOBAL__N_18RangeSetC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_18RangeSetC1EOS0_")
  //</editor-fold>
  public /*inline*/ RangeSet(JD$Move _dparam, final RangeSet /*&&*/$Prm0) {
    // : ranges(static_cast<RangeSet &&>().ranges) 
    //START JInit
    this.ranges = new ImmutableSet<Range>($Prm0.ranges);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeSet::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 73,
   FQN="(anonymous namespace)::RangeSet::operator=", NM="_ZN12_GLOBAL__N_18RangeSetaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_18RangeSetaSEOS0_")
  //</editor-fold>
  public /*inline*/ RangeSet /*&*/ $assignMove(final RangeSet /*&&*/$Prm0) {
    this.ranges.$assign($Prm0.ranges);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeSet::~RangeSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 73,
   FQN="(anonymous namespace)::RangeSet::~RangeSet", NM="_ZN12_GLOBAL__N_18RangeSetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_18RangeSetD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    ranges.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RangeSet::RangeSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 73,
   FQN="(anonymous namespace)::RangeSet::RangeSet", NM="_ZN12_GLOBAL__N_18RangeSetC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_18RangeSetC1ERKS0_")
  //</editor-fold>
  public /*inline*/ RangeSet(final /*const*/ RangeSet /*&*/ $Prm0) {
    // : ranges(.ranges) 
    //START JInit
    this.ranges = new ImmutableSet<Range>($Prm0.ranges);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public RangeSet clone() { return new RangeSet(this); }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "ranges=" + ranges; // NOI18N
  }
}
