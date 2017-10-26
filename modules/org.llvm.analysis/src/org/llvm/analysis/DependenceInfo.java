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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.APInt;
import org.llvm.adt.APIntOps;
import org.llvm.adt.SmallBitVector;
import org.llvm.adt.aliases.ArrayRef;
import org.llvm.adt.aliases.SmallVector;
import org.llvm.adt.aliases.SmallVectorImpl;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import org.llvm.analysis.impl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.analysis.impl.DependenceAnalysisStatics.*;


/// DependenceInfo - This class is the main dependence-analysis driver.
///
//<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 282,
 FQN="llvm::DependenceInfo", NM="_ZN4llvm14DependenceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfoE")
//</editor-fold>
public class DependenceInfo {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::DependenceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 284,
   FQN="llvm::DependenceInfo::DependenceInfo", NM="_ZN4llvm14DependenceInfoC1EPNS_8FunctionEPNS_9AAResultsEPNS_15ScalarEvolutionEPNS_8LoopInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfoC1EPNS_8FunctionEPNS_9AAResultsEPNS_15ScalarEvolutionEPNS_8LoopInfoE")
  //</editor-fold>
  public DependenceInfo(Function /*P*/ F, AAResults /*P*/ AA, ScalarEvolution /*P*/ SE, 
      LoopInfo /*P*/ LI) {
    // : AA(AA), SE(SE), LI(LI), F(F) 
    //START JInit
    this.AA = AA;
    this.SE = SE;
    this.LI = LI;
    this.F = F;
    //END JInit
  }

  
  /// depends - Tests for a dependence between the Src and Dst instructions.
  /// Returns NULL if no dependence; otherwise, returns a Dependence (or a
  /// FullDependence) with as much information as can be gleaned.
  /// The flag PossiblyLoopIndependent should be set by the caller
  /// if it appears that control flow can reach from Src to Dst
  /// without traversing a loop back edge.
  
  // depends -
  // Returns NULL if there is no dependence.
  // Otherwise, return a Dependence with as many details as possible.
  // Corresponds to Section 3.1 in the paper
  //
  //            Practical Dependence Testing
  //            Goff, Kennedy, Tseng
  //            PLDI 1991
  //
  // Care is required to keep the routine below, getSplitIteration(),
  // up to date with respect to this routine.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::depends">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 3288,
   FQN="llvm::DependenceInfo::depends", NM="_ZN4llvm14DependenceInfo7dependsEPNS_11InstructionES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo7dependsEPNS_11InstructionES2_b")
  //</editor-fold>
  public std.unique_ptr<Dependence> depends(Instruction /*P*/ Src, Instruction /*P*/ Dst, 
         boolean PossiblyLoopIndependent) {
    FullDependence Result = null;
    SmallVector<Subscript> Pair = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (Src == Dst) {
        PossiblyLoopIndependent = false;
      }
      if ((!Src.mayReadFromMemory() && !Src.mayWriteToMemory())
         || (!Dst.mayReadFromMemory() && !Dst.mayWriteToMemory())) {
        // if both instructions don't reference memory, there's no dependence
        return new std.unique_ptr<Dependence>(JD$NullPtr.INSTANCE, null);
      }
      if (!isLoadOrStore(Src) || !isLoadOrStore(Dst)) {
        // can only analyze simple loads and stores, i.e., no calls, invokes, etc.
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"can only handle simple loads and stores\n");
          }
        } while (false);
        return llvm.make_unique(new Dependence(Src, Dst));
      }
      
      Value /*P*/ SrcPtr = getPointerOperand(Src);
      Value /*P*/ DstPtr = getPointerOperand(Dst);
      switch (underlyingObjectsAlias(AA, F.getParent().getDataLayout(), DstPtr, 
          SrcPtr)) {
       case MayAlias:
       case PartialAlias:
        // cannot analyse objects if we don't understand their aliasing.
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"can't analyze may or partial alias\n");
          }
        } while (false);
        return llvm.make_unique(new Dependence(Src, Dst));
       case NoAlias:
        // If the objects noalias, they are distinct, accesses are independent.
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"no alias\n");
          }
        } while (false);
        return new std.unique_ptr<Dependence>(JD$NullPtr.INSTANCE, null);
       case MustAlias:
        break; // The underlying objects alias; test accesses for dependence.
      }
      
      // establish loop nesting levels
      establishNestingLevels(Src, Dst);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          dbgs().$out(/*KEEP_STR*/"    common nesting levels = ").$out_uint(CommonLevels).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          dbgs().$out(/*KEEP_STR*/"    maximum nesting levels = ").$out_uint(MaxLevels).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      
      Result/*J*/= new FullDependence(Src, Dst, PossiblyLoopIndependent, CommonLevels);
      TotalArrayPairs.$preInc();
      
      // See if there are GEPs we can use.
      boolean UsefulGEP = false;
      GEPOperator /*P*/ SrcGEP = dyn_cast_GEPOperator(SrcPtr);
      GEPOperator /*P*/ DstGEP = dyn_cast_GEPOperator(DstPtr);
      if ((SrcGEP != null) && (DstGEP != null)
         && SrcGEP.getPointerOperandType() == DstGEP.getPointerOperandType()) {
        /*const*/ SCEV /*P*/ SrcPtrSCEV = SE.getSCEV(SrcGEP.getPointerOperand());
        /*const*/ SCEV /*P*/ DstPtrSCEV = SE.getSCEV(DstGEP.getPointerOperand());
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"    SrcPtrSCEV = "), $Deref(SrcPtrSCEV)).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"    DstPtrSCEV = "), $Deref(DstPtrSCEV)).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        
        UsefulGEP = isLoopInvariant(SrcPtrSCEV, LI.getLoopFor(Src.getParent()))
           && isLoopInvariant(DstPtrSCEV, LI.getLoopFor(Dst.getParent()))
           && (SrcGEP.getNumOperands$User() == DstGEP.getNumOperands$User());
      }
      /*uint*/int Pairs = UsefulGEP ? SrcGEP.idx_end().$sub(SrcGEP.idx_begin()) : 1;
      Pair/*J*/= new SmallVector<Subscript>(JD$UInt_T$C$R.INSTANCE, 4, Pairs, new Subscript());
      if (UsefulGEP) {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"    using GEPs\n");
          }
        } while (false);
        /*uint*/int P = 0;
        for (type$ptr</*const*/ Use /*P*/ > SrcIdx = $tryClone(SrcGEP.idx_begin()), 
            /*P*/ SrcEnd = $tryClone(SrcGEP.idx_end()), 
            /*P*/ DstIdx = $tryClone(DstGEP.idx_begin());
             $noteq_ptr(SrcIdx, SrcEnd);
             SrcIdx.$preInc() , DstIdx.$preInc() , ++P) {
          Pair.$at(P).Src = SE.getSCEV(SrcIdx.$star().$Value$P());
          Pair.$at(P).Dst = SE.getSCEV(DstIdx.$star().$Value$P());
          unifySubscriptType(new ArrayRef<Subscript /*P*/ >($AddrOf(Pair.$at(P)), true));
        }
      } else {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"    ignoring GEPs\n");
          }
        } while (false);
        /*const*/ SCEV /*P*/ SrcSCEV = SE.getSCEV(SrcPtr);
        /*const*/ SCEV /*P*/ DstSCEV = SE.getSCEV(DstPtr);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"    SrcSCEV = "), $Deref(SrcSCEV)).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"    DstSCEV = "), $Deref(DstSCEV)).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        Pair.$at(0).Src = SrcSCEV;
        Pair.$at(0).Dst = DstSCEV;
      }
      if (Delinearize.$T() && $greater_uint(CommonLevels, 1)) {
        if (tryDelinearize(Src, Dst, Pair)) {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              dbgs().$out(/*KEEP_STR*/"    delinerized GEP\n");
            }
          } while (false);
          Pairs = Pair.size();
        }
      }
      
      for (/*uint*/int P = 0; $less_uint(P, Pairs); ++P) {
        Pair.$at(P).Loops.resize(MaxLevels + 1);
        Pair.$at(P).GroupLoops.resize(MaxLevels + 1);
        Pair.$at(P).Group.resize(Pairs);
        removeMatchingExtensions($AddrOf(Pair.$at(P)));
        Pair.$at(P).Classification
           = classifyPair(Pair.$at(P).Src, LI.getLoopFor(Src.getParent()), 
            Pair.$at(P).Dst, LI.getLoopFor(Dst.getParent()), 
            Pair.$at(P).Loops);
        Pair.$at(P).GroupLoops.$assign(Pair.$at(P).Loops);
        Pair.$at(P).Group.set(P);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"    subscript ").$out_uint(P).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\tsrc = "), $Deref(Pair.$at(P).Src)).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\tdst = "), $Deref(Pair.$at(P).Dst)).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"\tclass = ").$out_int(Pair.$at(P).Classification.getValue()).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"\tloops = ");
          }
        } while (false);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dumpSmallBitVector(Pair.$at(P).Loops);
          }
        } while (false);
      }
      
      SmallBitVector Separable/*J*/= new SmallBitVector(Pairs);
      SmallBitVector Coupled/*J*/= new SmallBitVector(Pairs);
      
      // Partition subscripts into separable and minimally-coupled groups
      // Algorithm in paper is algorithmically better;
      // this may be faster in practice. Check someday.
      //
      // Here's an example of how it works. Consider this code:
      //
      //   for (i = ...) {
      //     for (j = ...) {
      //       for (k = ...) {
      //         for (l = ...) {
      //           for (m = ...) {
      //             A[i][j][k][m] = ...;
      //             ... = A[0][j][l][i + j];
      //           }
      //         }
      //       }
      //     }
      //   }
      //
      // There are 4 subscripts here:
      //    0 [i] and [0]
      //    1 [j] and [j]
      //    2 [k] and [l]
      //    3 [m] and [i + j]
      //
      // We've already classified each subscript pair as ZIV, SIV, etc.,
      // and collected all the loops mentioned by pair P in Pair[P].Loops.
      // In addition, we've initialized Pair[P].GroupLoops to Pair[P].Loops
      // and set Pair[P].Group = {P}.
      //
      //      Src Dst    Classification Loops  GroupLoops Group
      //    0 [i] [0]         SIV       {1}      {1}        {0}
      //    1 [j] [j]         SIV       {2}      {2}        {1}
      //    2 [k] [l]         RDIV      {3,4}    {3,4}      {2}
      //    3 [m] [i + j]     MIV       {1,2,5}  {1,2,5}    {3}
      //
      // For each subscript SI 0 .. 3, we consider each remaining subscript, SJ.
      // So, 0 is compared against 1, 2, and 3; 1 is compared against 2 and 3, etc.
      //
      // We begin by comparing 0 and 1. The intersection of the GroupLoops is empty.
      // Next, 0 and 2. Again, the intersection of their GroupLoops is empty.
      // Next 0 and 3. The intersection of their GroupLoop = {1}, not empty,
      // so Pair[3].Group = {0,3} and Done = false (that is, 0 will not be added
      // to either Separable or Coupled).
      //
      // Next, we consider 1 and 2. The intersection of the GroupLoops is empty.
      // Next, 1 and 3. The intersectionof their GroupLoops = {2}, not empty,
      // so Pair[3].Group = {0, 1, 3} and Done = false.
      //
      // Next, we compare 2 against 3. The intersection of the GroupLoops is empty.
      // Since Done remains true, we add 2 to the set of Separable pairs.
      //
      // Finally, we consider 3. There's nothing to compare it with,
      // so Done remains true and we add it to the Coupled set.
      // Pair[3].Group = {0, 1, 3} and GroupLoops = {1, 2, 5}.
      //
      // In the end, we've got 1 separable subscript and 1 coupled group.
      for (/*uint*/int SI = 0; $less_uint(SI, Pairs); ++SI) {
        if (Pair.$at(SI).Classification == Subscript.ClassificationKind.NonLinear) {
          // ignore these, but collect loops for later
          NonlinearSubscriptPairs.$preInc();
          collectCommonLoops(Pair.$at(SI).Src, 
              LI.getLoopFor(Src.getParent()), 
              Pair.$at(SI).Loops);
          collectCommonLoops(Pair.$at(SI).Dst, 
              LI.getLoopFor(Dst.getParent()), 
              Pair.$at(SI).Loops);
          Result.Consistent = false;
        } else if (Pair.$at(SI).Classification == Subscript.ClassificationKind.ZIV) {
          // always separable
          Separable.set(SI);
        } else {
          // SIV, RDIV, or MIV, so check for coupled group
          boolean Done = true;
          for (/*uint*/int SJ = SI + 1; $less_uint(SJ, Pairs); ++SJ) {
            SmallBitVector Intersection = new SmallBitVector(Pair.$at(SI).GroupLoops);
            Intersection.$andassign(Pair.$at(SJ).GroupLoops);
            if (Intersection.any()) {
              // accumulate set of all the loops in group
              Pair.$at(SJ).GroupLoops.$orassign(Pair.$at(SI).GroupLoops);
              // accumulate set of all subscripts in group
              Pair.$at(SJ).Group.$orassign(Pair.$at(SI).Group);
              Done = false;
            }
          }
          if (Done) {
            if (Pair.$at(SI).Group.count() == 1) {
              Separable.set(SI);
              SeparableSubscriptPairs.$preInc();
            } else {
              Coupled.set(SI);
              CoupledSubscriptPairs.$preInc();
            }
          }
        }
      }
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          dbgs().$out(/*KEEP_STR*/"    Separable = ");
        }
      } while (false);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          dumpSmallBitVector(Separable);
        }
      } while (false);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          dbgs().$out(/*KEEP_STR*/"    Coupled = ");
        }
      } while (false);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          dumpSmallBitVector(Coupled);
        }
      } while (false);
      
      Constraint NewConstraint/*J*/= new Constraint();
      NewConstraint.setAny(SE);
      
      // test separable subscripts
      for (int SI = Separable.find_first(); SI >= 0; SI = Separable.find_next(SI)) {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"testing subscript ").$out_int(SI);
          }
        } while (false);
        switch (Pair.$at(SI).Classification) {
         case ZIV:
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              dbgs().$out(/*KEEP_STR*/", ZIV\n");
            }
          } while (false);
          if (testZIV(Pair.$at(SI).Src, Pair.$at(SI).Dst, Result)) {
            return new std.unique_ptr<Dependence>(JD$NullPtr.INSTANCE, null);
          }
          break;
         case SIV:
          {
            do {
              if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
                dbgs().$out(/*KEEP_STR*/", SIV\n");
              }
            } while (false);
            uint$ref Level = create_uint$ref();
            type$ref</*const*/ SCEV /*P*/ > SplitIter = create_type$null$ref(null);
            if (testSIV(Pair.$at(SI).Src, Pair.$at(SI).Dst, Level, Result, NewConstraint, 
                SplitIter)) {
              return new std.unique_ptr<Dependence>(JD$NullPtr.INSTANCE, null);
            }
            break;
          }
         case RDIV:
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              dbgs().$out(/*KEEP_STR*/", RDIV\n");
            }
          } while (false);
          if (testRDIV(Pair.$at(SI).Src, Pair.$at(SI).Dst, Result)) {
            return new std.unique_ptr<Dependence>(JD$NullPtr.INSTANCE, null);
          }
          break;
         case MIV:
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              dbgs().$out(/*KEEP_STR*/", MIV\n");
            }
          } while (false);
          if (testMIV(Pair.$at(SI).Src, Pair.$at(SI).Dst, Pair.$at(SI).Loops, Result)) {
            return new std.unique_ptr<Dependence>(JD$NullPtr.INSTANCE, null);
          }
          break;
         default:
          throw new llvm_unreachable("subscript has unexpected classification");
        }
      }
      if ((Coupled.count() != 0)) {
        // test coupled subscript groups
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"starting on coupled subscripts\n");
          }
        } while (false);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"MaxLevels + 1 = ").$out_uint(MaxLevels + 1).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        SmallVector<Constraint> Constraints/*J*/= new SmallVector<Constraint>(JD$UInt_T$C$R.INSTANCE, 4, MaxLevels + 1, new Constraint());
        for (/*uint*/int II = 0; $lesseq_uint(II, MaxLevels); ++II)  {
          Constraints.$at(II).setAny(SE);
        }
        for (int SI = Coupled.find_first(); SI >= 0; SI = Coupled.find_next(SI)) {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              dbgs().$out(/*KEEP_STR*/"testing subscript group ").$out_int(SI).$out(/*KEEP_STR*/" { ");
            }
          } while (false);
          SmallBitVector Group/*J*/= new SmallBitVector(Pair.$at(SI).Group);
          SmallBitVector Sivs/*J*/= new SmallBitVector(Pairs);
          SmallBitVector Mivs/*J*/= new SmallBitVector(Pairs);
          SmallBitVector ConstrainedLevels/*J*/= new SmallBitVector(MaxLevels + 1);
          SmallVector<Subscript /*P*/ > PairsInGroup/*J*/= new SmallVector<Subscript /*P*/ >(4, (Subscript /*P*/ )null);
          for (int SJ = Group.find_first(); SJ >= 0; SJ = Group.find_next(SJ)) {
            do {
              if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
                dbgs().$out_int(SJ).$out(/*KEEP_STR*/$SPACE);
              }
            } while (false);
            if (Pair.$at(SJ).Classification == Subscript.ClassificationKind.SIV) {
              Sivs.set(SJ);
            } else {
              Mivs.set(SJ);
            }
            PairsInGroup.push_back($AddrOf(Pair.$at(SJ)));
          }
          unifySubscriptType(new ArrayRef<Subscript /*P*/ >(PairsInGroup, true));
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              dbgs().$out(/*KEEP_STR*/"}\n");
            }
          } while (false);
          while (Sivs.any()) {
            boolean Changed = false;
            for (int SJ = Sivs.find_first(); SJ >= 0; SJ = Sivs.find_next(SJ)) {
              do {
                if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
                  dbgs().$out(/*KEEP_STR*/"testing subscript ").$out_int(SJ).$out(/*KEEP_STR*/", SIV\n");
                }
              } while (false);
              // SJ is an SIV subscript that's part of the current coupled group
              uint$ref Level = create_uint$ref();
              type$ref</*const*/ SCEV /*P*/ > SplitIter = create_type$null$ref(null);
              do {
                if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
                  dbgs().$out(/*KEEP_STR*/"SIV\n");
                }
              } while (false);
              if (testSIV(Pair.$at(SJ).Src, Pair.$at(SJ).Dst, Level, Result, NewConstraint, 
                  SplitIter)) {
                return new std.unique_ptr<Dependence>(JD$NullPtr.INSTANCE, null);
              }
              ConstrainedLevels.set(Level.$deref());
              if (intersectConstraints($AddrOf(Constraints.$at(Level.$deref())), $AddrOf(NewConstraint))) {
                if (Constraints.$at(Level.$deref()).isEmpty()) {
                  DeltaIndependence.$preInc();
                  return new std.unique_ptr<Dependence>(JD$NullPtr.INSTANCE, null);
                }
                Changed = true;
              }
              Sivs.reset(SJ);
            }
            if (Changed) {
              // propagate, possibly creating new SIVs and ZIVs
              do {
                if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
                  dbgs().$out(/*KEEP_STR*/"    propagating\n");
                }
              } while (false);
              do {
                if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
                  dbgs().$out(/*KEEP_STR*/"\tMivs = ");
                }
              } while (false);
              do {
                if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
                  dumpSmallBitVector(Mivs);
                }
              } while (false);
              for (int SJ = Mivs.find_first(); SJ >= 0; SJ = Mivs.find_next(SJ)) {
                // SJ is an MIV subscript that's part of the current coupled group
                do {
                  if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
                    dbgs().$out(/*KEEP_STR*/"\tSJ = ").$out_int(SJ).$out(/*KEEP_STR*/$LF);
                  }
                } while (false);
                if (propagate(Pair.$at(SJ).Src_ref, Pair.$at(SJ).Dst_ref, Pair.$at(SJ).Loops, 
                    Constraints, Result.Consistent_ref)) {
                  do {
                    if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
                      dbgs().$out(/*KEEP_STR*/"\t    Changed\n");
                    }
                  } while (false);
                  DeltaPropagations.$preInc();
                  Pair.$at(SJ).Classification
                     = classifyPair(Pair.$at(SJ).Src, LI.getLoopFor(Src.getParent()), 
                      Pair.$at(SJ).Dst, LI.getLoopFor(Dst.getParent()), 
                      Pair.$at(SJ).Loops);
                  switch (Pair.$at(SJ).Classification) {
                   case ZIV:
                    do {
                      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
                        dbgs().$out(/*KEEP_STR*/"ZIV\n");
                      }
                    } while (false);
                    if (testZIV(Pair.$at(SJ).Src, Pair.$at(SJ).Dst, Result)) {
                      return new std.unique_ptr<Dependence>(JD$NullPtr.INSTANCE, null);
                    }
                    Mivs.reset(SJ);
                    break;
                   case SIV:
                    Sivs.set(SJ);
                    Mivs.reset(SJ);
                    break;
                   case RDIV:
                   case MIV:
                    break;
                   default:
                    throw new llvm_unreachable("bad subscript classification");
                  }
                }
              }
            }
          }
          
          // test & propagate remaining RDIVs
          for (int SJ = Mivs.find_first(); SJ >= 0; SJ = Mivs.find_next(SJ)) {
            if (Pair.$at(SJ).Classification == Subscript.ClassificationKind.RDIV) {
              do {
                if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
                  dbgs().$out(/*KEEP_STR*/"RDIV test\n");
                }
              } while (false);
              if (testRDIV(Pair.$at(SJ).Src, Pair.$at(SJ).Dst, Result)) {
                return new std.unique_ptr<Dependence>(JD$NullPtr.INSTANCE, null);
              }
              // I don't yet understand how to propagate RDIV results
              Mivs.reset(SJ);
            }
          }
          
          // test remaining MIVs
          // This code is temporary.
          // Better to somehow test all remaining subscripts simultaneously.
          for (int SJ = Mivs.find_first(); SJ >= 0; SJ = Mivs.find_next(SJ)) {
            if (Pair.$at(SJ).Classification == Subscript.ClassificationKind.MIV) {
              do {
                if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
                  dbgs().$out(/*KEEP_STR*/"MIV test\n");
                }
              } while (false);
              if (testMIV(Pair.$at(SJ).Src, Pair.$at(SJ).Dst, Pair.$at(SJ).Loops, Result)) {
                return new std.unique_ptr<Dependence>(JD$NullPtr.INSTANCE, null);
              }
            } else {
              throw new llvm_unreachable("expected only MIV subscripts at this point");
            }
          }
          
          // update Result.DV from constraint vector
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              dbgs().$out(/*KEEP_STR*/"    updating\n");
            }
          } while (false);
          for (int SJ = ConstrainedLevels.find_first(); SJ >= 0;
               SJ = ConstrainedLevels.find_next(SJ)) {
            if (SJ > (int)CommonLevels) {
              break;
            }
            updateDirection(Result.DV.$at(SJ - 1), Constraints.$at(SJ));
            if ($uchar2int(Unsigned.$3bits_uchar2uchar(Result.DV.$at(SJ - 1).Direction)) == Dependence.DVEntry.Unnamed_enum.NONE.getValue()) {
              return new std.unique_ptr<Dependence>(JD$NullPtr.INSTANCE, null);
            }
          }
        }
      }
      
      // Make sure the Scalar flags are set correctly.
      SmallBitVector CompleteLoops/*J*/= new SmallBitVector(MaxLevels + 1);
      for (/*uint*/int SI = 0; $less_uint(SI, Pairs); ++SI)  {
        CompleteLoops.$orassign(Pair.$at(SI).Loops);
      }
      for (/*uint*/int II = 1; $lesseq_uint(II, CommonLevels); ++II)  {
        if (CompleteLoops.$at(II).$bool()) {
          Result.DV.$at(II - 1).Scalar = false;
        }
      }
      if (PossiblyLoopIndependent) {
        // Make sure the LoopIndependent flag is set correctly.
        // All directions must include equal, otherwise no
        // loop-independent dependence is possible.
        for (/*uint*/int II = 1; $lesseq_uint(II, CommonLevels); ++II) {
          if (!((Result.getDirection(II) & Dependence.DVEntry.Unnamed_enum.EQ.getValue()) != 0)) {
            Result.LoopIndependent = false;
            break;
          }
        }
      } else {
        // On the other hand, if all directions are equal and there's no
        // loop-independent dependence possible, then no dependence exists.
        boolean AllEqual = true;
        for (/*uint*/int II = 1; $lesseq_uint(II, CommonLevels); ++II) {
          if (Result.getDirection(II) != Dependence.DVEntry.Unnamed_enum.EQ.getValue()) {
            AllEqual = false;
            break;
          }
        }
        if (AllEqual) {
          return new std.unique_ptr<Dependence>(JD$NullPtr.INSTANCE, null);
        }
      }
      
      return $c$.clean(new std.unique_ptr<Dependence>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new FullDependence(std.move(Result))))));
    } finally {
      if (Pair != null) { Pair.$destroy(); }
      if (Result != null) { Result.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// getSplitIteration - Give a dependence that's splittable at some
  /// particular level, return the iteration that should be used to split
  /// the loop.
  ///
  /// Generally, the dependence analyzer will be used to build
  /// a dependence graph for a function (basically a map from instructions
  /// to dependences). Looking for cycles in the graph shows us loops
  /// that cannot be trivially vectorized/parallelized.
  ///
  /// We can try to improve the situation by examining all the dependences
  /// that make up the cycle, looking for ones we can break.
  /// Sometimes, peeling the first or last iteration of a loop will break
  /// dependences, and there are flags for those possibilities.
  /// Sometimes, splitting a loop at some other iteration will do the trick,
  /// and we've got a flag for that case. Rather than waste the space to
  /// record the exact iteration (since we rarely know), we provide
  /// a method that calculates the iteration. It's a drag that it must work
  /// from scratch, but wonderful in that it's possible.
  ///
  /// Here's an example:
  ///
  ///    for (i = 0; i < 10; i++)
  ///        A[i] = ...
  ///        ... = A[11 - i]
  ///
  /// There's a loop-carried flow dependence from the store to the load,
  /// found by the weak-crossing SIV test. The dependence will have a flag,
  /// indicating that the dependence can be broken by splitting the loop.
  /// Calling getSplitIteration will return 5.
  /// Splitting the loop breaks the dependence, like so:
  ///
  ///    for (i = 0; i <= 5; i++)
  ///        A[i] = ...
  ///        ... = A[11 - i]
  ///    for (i = 6; i < 10; i++)
  ///        A[i] = ...
  ///        ... = A[11 - i]
  ///
  /// breaks the dependence and allows us to vectorize/parallelize
  /// both loops.
  
  //===----------------------------------------------------------------------===//
  // getSplitIteration -
  // Rather than spend rarely-used space recording the splitting iteration
  // during the Weak-Crossing SIV test, we re-compute it on demand.
  // The re-computation is basically a repeat of the entire dependence test,
  // though simplified since we know that the dependence exists.
  // It's tedious, since we must go through all propagations, etc.
  //
  // Care is required to keep this code up to date with respect to the routine
  // above, depends().
  //
  // Generally, the dependence analyzer will be used to build
  // a dependence graph for a function (basically a map from instructions
  // to dependences). Looking for cycles in the graph shows us loops
  // that cannot be trivially vectorized/parallelized.
  //
  // We can try to improve the situation by examining all the dependences
  // that make up the cycle, looking for ones we can break.
  // Sometimes, peeling the first or last iteration of a loop will break
  // dependences, and we've got flags for those possibilities.
  // Sometimes, splitting a loop at some other iteration will do the trick,
  // and we've got a flag for that case. Rather than waste the space to
  // record the exact iteration (since we rarely know), we provide
  // a method that calculates the iteration. It's a drag that it must work
  // from scratch, but wonderful in that it's possible.
  //
  // Here's an example:
  //
  //    for (i = 0; i < 10; i++)
  //        A[i] = ...
  //        ... = A[11 - i]
  //
  // There's a loop-carried flow dependence from the store to the load,
  // found by the weak-crossing SIV test. The dependence will have a flag,
  // indicating that the dependence can be broken by splitting the loop.
  // Calling getSplitIteration will return 5.
  // Splitting the loop breaks the dependence, like so:
  //
  //    for (i = 0; i <= 5; i++)
  //        A[i] = ...
  //        ... = A[11 - i]
  //    for (i = 6; i < 10; i++)
  //        A[i] = ...
  //        ... = A[11 - i]
  //
  // breaks the dependence and allows us to vectorize/parallelize
  // both loops.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::getSplitIteration">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 3745,
   FQN="llvm::DependenceInfo::getSplitIteration", NM="_ZN4llvm14DependenceInfo17getSplitIterationERKNS_10DependenceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo17getSplitIterationERKNS_10DependenceEj")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getSplitIteration(final /*const*/ Dependence /*&*/ Dep, 
                   /*uint*/int SplitLevel) {
    FullDependence Result = null;
    SmallVector<Subscript> Pair = null;
    try {
      assert (Dep.isSplitable(SplitLevel)) : "Dep should be splitable at SplitLevel";
      Instruction /*P*/ Src = Dep.getSrc();
      Instruction /*P*/ Dst = Dep.getDst();
      assert (Src.mayReadFromMemory() || Src.mayWriteToMemory());
      assert (Dst.mayReadFromMemory() || Dst.mayWriteToMemory());
      assert (isLoadOrStore(Src));
      assert (isLoadOrStore(Dst));
      Value /*P*/ SrcPtr = getPointerOperand(Src);
      Value /*P*/ DstPtr = getPointerOperand(Dst);
      assert (underlyingObjectsAlias(AA, F.getParent().getDataLayout(), DstPtr, SrcPtr) == AliasResult.MustAlias);
      
      // establish loop nesting levels
      establishNestingLevels(Src, Dst);
      
      Result/*J*/= new FullDependence(Src, Dst, false, CommonLevels);
      
      // See if there are GEPs we can use.
      boolean UsefulGEP = false;
      GEPOperator /*P*/ SrcGEP = dyn_cast_GEPOperator(SrcPtr);
      GEPOperator /*P*/ DstGEP = dyn_cast_GEPOperator(DstPtr);
      if ((SrcGEP != null) && (DstGEP != null)
         && SrcGEP.getPointerOperandType() == DstGEP.getPointerOperandType()) {
        /*const*/ SCEV /*P*/ SrcPtrSCEV = SE.getSCEV(SrcGEP.getPointerOperand());
        /*const*/ SCEV /*P*/ DstPtrSCEV = SE.getSCEV(DstGEP.getPointerOperand());
        UsefulGEP = isLoopInvariant(SrcPtrSCEV, LI.getLoopFor(Src.getParent()))
           && isLoopInvariant(DstPtrSCEV, LI.getLoopFor(Dst.getParent()))
           && (SrcGEP.getNumOperands$User() == DstGEP.getNumOperands$User());
      }
      /*uint*/int Pairs = UsefulGEP ? SrcGEP.idx_end().$sub(SrcGEP.idx_begin()) : 1;
      Pair/*J*/= new SmallVector<Subscript>(JD$UInt_T$C$R.INSTANCE, 4, Pairs, new Subscript());
      if (UsefulGEP) {
        /*uint*/int P = 0;
        for (type$ptr</*const*/ Use /*P*/ > SrcIdx = $tryClone(SrcGEP.idx_begin()), 
            /*P*/ SrcEnd = $tryClone(SrcGEP.idx_end()), 
            /*P*/ DstIdx = $tryClone(DstGEP.idx_begin());
             $noteq_ptr(SrcIdx, SrcEnd);
             SrcIdx.$preInc() , DstIdx.$preInc() , ++P) {
          Pair.$at(P).Src = SE.getSCEV(SrcIdx.$star().$Value$P());
          Pair.$at(P).Dst = SE.getSCEV(DstIdx.$star().$Value$P());
        }
      } else {
        /*const*/ SCEV /*P*/ SrcSCEV = SE.getSCEV(SrcPtr);
        /*const*/ SCEV /*P*/ DstSCEV = SE.getSCEV(DstPtr);
        Pair.$at(0).Src = SrcSCEV;
        Pair.$at(0).Dst = DstSCEV;
      }
      if (Delinearize.$T() && $greater_uint(CommonLevels, 1)) {
        if (tryDelinearize(Src, Dst, Pair)) {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              dbgs().$out(/*KEEP_STR*/"    delinerized GEP\n");
            }
          } while (false);
          Pairs = Pair.size();
        }
      }
      
      for (/*uint*/int P = 0; $less_uint(P, Pairs); ++P) {
        Pair.$at(P).Loops.resize(MaxLevels + 1);
        Pair.$at(P).GroupLoops.resize(MaxLevels + 1);
        Pair.$at(P).Group.resize(Pairs);
        removeMatchingExtensions($AddrOf(Pair.$at(P)));
        Pair.$at(P).Classification
           = classifyPair(Pair.$at(P).Src, LI.getLoopFor(Src.getParent()), 
            Pair.$at(P).Dst, LI.getLoopFor(Dst.getParent()), 
            Pair.$at(P).Loops);
        Pair.$at(P).GroupLoops.$assign(Pair.$at(P).Loops);
        Pair.$at(P).Group.set(P);
      }
      
      SmallBitVector Separable/*J*/= new SmallBitVector(Pairs);
      SmallBitVector Coupled/*J*/= new SmallBitVector(Pairs);
      
      // partition subscripts into separable and minimally-coupled groups
      for (/*uint*/int SI = 0; $less_uint(SI, Pairs); ++SI) {
        if (Pair.$at(SI).Classification == Subscript.ClassificationKind.NonLinear) {
          // ignore these, but collect loops for later
          collectCommonLoops(Pair.$at(SI).Src, 
              LI.getLoopFor(Src.getParent()), 
              Pair.$at(SI).Loops);
          collectCommonLoops(Pair.$at(SI).Dst, 
              LI.getLoopFor(Dst.getParent()), 
              Pair.$at(SI).Loops);
          Result.Consistent = false;
        } else if (Pair.$at(SI).Classification == Subscript.ClassificationKind.ZIV) {
          Separable.set(SI);
        } else {
          // SIV, RDIV, or MIV, so check for coupled group
          boolean Done = true;
          for (/*uint*/int SJ = SI + 1; $less_uint(SJ, Pairs); ++SJ) {
            SmallBitVector Intersection = new SmallBitVector(Pair.$at(SI).GroupLoops);
            Intersection.$andassign(Pair.$at(SJ).GroupLoops);
            if (Intersection.any()) {
              // accumulate set of all the loops in group
              Pair.$at(SJ).GroupLoops.$orassign(Pair.$at(SI).GroupLoops);
              // accumulate set of all subscripts in group
              Pair.$at(SJ).Group.$orassign(Pair.$at(SI).Group);
              Done = false;
            }
          }
          if (Done) {
            if (Pair.$at(SI).Group.count() == 1) {
              Separable.set(SI);
            } else {
              Coupled.set(SI);
            }
          }
        }
      }
      
      Constraint NewConstraint/*J*/= new Constraint();
      NewConstraint.setAny(SE);
      
      // test separable subscripts
      for (int SI = Separable.find_first(); SI >= 0; SI = Separable.find_next(SI)) {
        switch (Pair.$at(SI).Classification) {
         case SIV:
          {
            uint$ref Level = create_uint$ref();
            type$ref</*const*/ SCEV /*P*/ > SplitIter = create_type$null$ref(null);
            /*J:(void)*/testSIV(Pair.$at(SI).Src, Pair.$at(SI).Dst, Level, 
                Result, NewConstraint, SplitIter);
            if (Level.$deref() == SplitLevel) {
              assert (SplitIter.$deref() != null);
              return SplitIter.$deref();
            }
            break;
          }
         case ZIV:
         case RDIV:
         case MIV:
          break;
         default:
          throw new llvm_unreachable("subscript has unexpected classification");
        }
      }
      if ((Coupled.count() != 0)) {
        // test coupled subscript groups
        SmallVector<Constraint> Constraints/*J*/= new SmallVector<Constraint>(JD$UInt_T$C$R.INSTANCE, 4, MaxLevels + 1, new Constraint());
        for (/*uint*/int II = 0; $lesseq_uint(II, MaxLevels); ++II)  {
          Constraints.$at(II).setAny(SE);
        }
        for (int SI = Coupled.find_first(); SI >= 0; SI = Coupled.find_next(SI)) {
          SmallBitVector Group/*J*/= new SmallBitVector(Pair.$at(SI).Group);
          SmallBitVector Sivs/*J*/= new SmallBitVector(Pairs);
          SmallBitVector Mivs/*J*/= new SmallBitVector(Pairs);
          SmallBitVector ConstrainedLevels/*J*/= new SmallBitVector(MaxLevels + 1);
          for (int SJ = Group.find_first(); SJ >= 0; SJ = Group.find_next(SJ)) {
            if (Pair.$at(SJ).Classification == Subscript.ClassificationKind.SIV) {
              Sivs.set(SJ);
            } else {
              Mivs.set(SJ);
            }
          }
          while (Sivs.any()) {
            boolean Changed = false;
            for (int SJ = Sivs.find_first(); SJ >= 0; SJ = Sivs.find_next(SJ)) {
              // SJ is an SIV subscript that's part of the current coupled group
              uint$ref Level = create_uint$ref();
              type$ref</*const*/ SCEV /*P*/ > SplitIter = create_type$null$ref(null);
              /*J:(void)*/testSIV(Pair.$at(SJ).Src, Pair.$at(SJ).Dst, Level, 
                  Result, NewConstraint, SplitIter);
              if (Level.$deref() == SplitLevel && (SplitIter.$deref() != null)) {
                return SplitIter.$deref();
              }
              ConstrainedLevels.set(Level.$deref());
              if (intersectConstraints($AddrOf(Constraints.$at(Level.$deref())), $AddrOf(NewConstraint))) {
                Changed = true;
              }
              Sivs.reset(SJ);
            }
            if (Changed) {
              // propagate, possibly creating new SIVs and ZIVs
              for (int SJ = Mivs.find_first(); SJ >= 0; SJ = Mivs.find_next(SJ)) {
                // SJ is an MIV subscript that's part of the current coupled group
                if (propagate(Pair.$at(SJ).Src_ref, Pair.$at(SJ).Dst_ref, 
                    Pair.$at(SJ).Loops, Constraints, Result.Consistent_ref)) {
                  Pair.$at(SJ).Classification
                     = classifyPair(Pair.$at(SJ).Src, LI.getLoopFor(Src.getParent()), 
                      Pair.$at(SJ).Dst, LI.getLoopFor(Dst.getParent()), 
                      Pair.$at(SJ).Loops);
                  switch (Pair.$at(SJ).Classification) {
                   case ZIV:
                    Mivs.reset(SJ);
                    break;
                   case SIV:
                    Sivs.set(SJ);
                    Mivs.reset(SJ);
                    break;
                   case RDIV:
                   case MIV:
                    break;
                   default:
                    throw new llvm_unreachable("bad subscript classification");
                  }
                }
              }
            }
          }
        }
      }
      throw new llvm_unreachable("somehow reached end of routine");
//      return null;
    } finally {
      if (Pair != null) { Pair.$destroy(); }
      if (Result != null) { Result.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::getFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 340,
   FQN="llvm::DependenceInfo::getFunction", NM="_ZNK4llvm14DependenceInfo11getFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo11getFunctionEv")
  //</editor-fold>
  public Function /*P*/ getFunction() /*const*/ {
    return F;
  }

/*private:*/
  private AAResults /*P*/ AA;
  private ScalarEvolution /*P*/ SE;
  private LoopInfo /*P*/ LI;
  private Function /*P*/ F;
  
  /// Subscript - This private struct represents a pair of subscripts from
  /// a pair of potentially multi-dimensional array references. We use a
  /// vector of them to guide subscript partitioning.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Subscript">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 351,
   FQN="llvm::DependenceInfo::Subscript", NM="_ZN4llvm14DependenceInfo9SubscriptE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo9SubscriptE")
  //</editor-fold>
  private static class/*struct*/ Subscript implements Destructors.ClassWithDestructor {
    public /*const*/ SCEV /*P*/ Src;
    public /*const*/ SCEV /*P*/ Dst;
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Subscript::ClassificationKind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 354,
     FQN="llvm::DependenceInfo::Subscript::ClassificationKind", NM="_ZN4llvm14DependenceInfo9Subscript18ClassificationKindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo9Subscript18ClassificationKindE")
    //</editor-fold>
    public enum ClassificationKind implements Native.NativeUIntEnum {
      ZIV(0),
      SIV(ZIV.getValue() + 1),
      RDIV(SIV.getValue() + 1),
      MIV(RDIV.getValue() + 1),
      NonLinear(MIV.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static ClassificationKind valueOf(int val) {
        ClassificationKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final ClassificationKind[] VALUES;
        private static final ClassificationKind[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (ClassificationKind kind : ClassificationKind.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new ClassificationKind[min < 0 ? (1-min) : 0];
          VALUES = new ClassificationKind[max >= 0 ? (1+max) : 0];
          for (ClassificationKind kind : ClassificationKind.values()) {
            if (kind.value < 0) {
              if (_VALUES[-kind.value] == null) {
                _VALUES[-kind.value] = kind;
              } else {
                assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
              }
            } else {
              if (VALUES[kind.value] == null) {
                VALUES[kind.value] = kind;
              } else {
                assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
              }
            }
          }
        }
      }

      private final /*uint*/int value;
      private ClassificationKind(int val) { this.value = (/*uint*/int)val;}
      @Override public final /*uint*/int getValue() { return value;}
      //</editor-fold>
    };
    public  ClassificationKind Classification;
    public SmallBitVector Loops;
    public SmallBitVector GroupLoops;
    public SmallBitVector Group;
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Subscript::Subscript">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 351,
     FQN="llvm::DependenceInfo::Subscript::Subscript", NM="_ZN4llvm14DependenceInfo9SubscriptC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo9SubscriptC1EOS1_")
    //</editor-fold>
    public /*inline*/ Subscript(JD$Move _dparam, final Subscript /*&&*/$Prm0) {
      // : Src(static_cast<Subscript &&>().Src), Dst(static_cast<Subscript &&>().Dst), Classification(static_cast<Subscript &&>().Classification), Loops(static_cast<Subscript &&>().Loops), GroupLoops(static_cast<Subscript &&>().GroupLoops), Group(static_cast<Subscript &&>().Group) 
      //START JInit
      this.Src = $Prm0.Src;
      this.Dst = $Prm0.Dst;
      this.Classification = $Prm0.Classification;
      this.Loops = new SmallBitVector(JD$Move.INSTANCE, $Prm0.Loops);
      this.GroupLoops = new SmallBitVector(JD$Move.INSTANCE, $Prm0.GroupLoops);
      this.Group = new SmallBitVector(JD$Move.INSTANCE, $Prm0.Group);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Subscript::~Subscript">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 351,
     FQN="llvm::DependenceInfo::Subscript::~Subscript", NM="_ZN4llvm14DependenceInfo9SubscriptD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo9SubscriptD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Group.$destroy();
      GroupLoops.$destroy();
      Loops.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Subscript::Subscript">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 351,
     FQN="llvm::DependenceInfo::Subscript::Subscript", NM="_ZN4llvm14DependenceInfo9SubscriptC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo9SubscriptC1Ev")
    //</editor-fold>
    public /*inline*/ Subscript() {
      // : Loops(), GroupLoops(), Group() 
      //START JInit
      this.Loops = new SmallBitVector();
      this.GroupLoops = new SmallBitVector();
      this.Group = new SmallBitVector();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Subscript::Subscript">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 351,
     FQN="llvm::DependenceInfo::Subscript::Subscript", NM="_ZN4llvm14DependenceInfo9SubscriptC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo9SubscriptC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Subscript(final /*const*/ Subscript /*&*/ $Prm0) {
      // : Src(.Src), Dst(.Dst), Classification(.Classification), Loops(.Loops), GroupLoops(.GroupLoops), Group(.Group) 
      //START JInit
      this.Src = $Prm0.Src;
      this.Dst = $Prm0.Dst;
      this.Classification = $Prm0.Classification;
      this.Loops = new SmallBitVector($Prm0.Loops);
      this.GroupLoops = new SmallBitVector($Prm0.GroupLoops);
      this.Group = new SmallBitVector($Prm0.Group);
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    
    public type$ref<SCEV> Src_ref = new type$ptr$inout<SCEV>(this) {
      @Override
      protected SCEV $star$impl() {
        return Src;
      }
    
      @Override
      protected SCEV $set$impl(SCEV value) {
        Src = value;
        return Src;
      }      
    };
    public type$ref<SCEV> Dst_ref = new type$ptr$inout<SCEV>(this) {
      @Override
      protected SCEV $star$impl() {
        return Dst;
      }
    
      @Override
      protected SCEV $set$impl(SCEV value) {
        Dst = value;
        return Dst;
      }      
    };


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Src=" + Src // NOI18N
                + ", Dst=" + Dst // NOI18N
                + ", Classification=" + Classification // NOI18N
                + ", Loops=" + Loops // NOI18N
                + ", GroupLoops=" + GroupLoops // NOI18N
                + ", Group=" + Group; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::CoefficientInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 360,
   FQN="llvm::DependenceInfo::CoefficientInfo", NM="_ZN4llvm14DependenceInfo15CoefficientInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo15CoefficientInfoE")
  //</editor-fold>
  private static class/*struct*/ CoefficientInfo {
    public /*const*/ SCEV /*P*/ Coeff;
    public /*const*/ SCEV /*P*/ PosPart;
    public /*const*/ SCEV /*P*/ NegPart;
    public /*const*/ SCEV /*P*/ Iterations;
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::CoefficientInfo::CoefficientInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 360,
     FQN="llvm::DependenceInfo::CoefficientInfo::CoefficientInfo", NM="_ZN4llvm14DependenceInfo15CoefficientInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo15CoefficientInfoC1Ev")
    //</editor-fold>
    public /*inline*/ CoefficientInfo() {
    }

    
    @Override public String toString() {
      return "" + "Coeff=" + Coeff // NOI18N
                + ", PosPart=" + PosPart // NOI18N
                + ", NegPart=" + NegPart // NOI18N
                + ", Iterations=" + Iterations; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::BoundInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 367,
   FQN="llvm::DependenceInfo::BoundInfo", NM="_ZN4llvm14DependenceInfo9BoundInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo9BoundInfoE")
  //</editor-fold>
  private static class/*struct*/ BoundInfo {
    public /*const*/ SCEV /*P*/ Iterations;
    public /*const*/ SCEV /*P*/ Upper[/*8*/] = new /*const*/ SCEV /*P*/  [8];
    public /*const*/ SCEV /*P*/ Lower[/*8*/] = new /*const*/ SCEV /*P*/  [8];
    public /*uchar*/byte Direction;
    public /*uchar*/byte DirSet;
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::BoundInfo::BoundInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 367,
     FQN="llvm::DependenceInfo::BoundInfo::BoundInfo", NM="_ZN4llvm14DependenceInfo9BoundInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo9BoundInfoC1Ev")
    //</editor-fold>
    public /*inline*/ BoundInfo() {
    }

    
    @Override public String toString() {
      return "" + "Iterations=" + Iterations // NOI18N
                + ", Upper=" + Upper // NOI18N
                + ", Lower=" + Lower // NOI18N
                + ", Direction=" + $uchar2uint(Direction) // NOI18N
                + ", DirSet=" + $uchar2uint(DirSet); // NOI18N
    }
  };
  
  /// Constraint - This private class represents a constraint, as defined
  /// in the paper
  ///
  ///           Practical Dependence Testing
  ///           Goff, Kennedy, Tseng
  ///           PLDI 1991
  ///
  /// There are 5 kinds of constraint, in a hierarchy.
  ///   1) Any - indicates no constraint, any dependence is possible.
  ///   2) Line - A line ax + by = c, where a, b, and c are parameters,
  ///             representing the dependence equation.
  ///   3) Distance - The value d of the dependence distance;
  ///   4) Point - A point <x, y> representing the dependence from
  ///              iteration x to iteration y.
  ///   5) Empty - No dependence is possible.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 390,
   FQN="llvm::DependenceInfo::Constraint", NM="_ZN4llvm14DependenceInfo10ConstraintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo10ConstraintE")
  //</editor-fold>
  private static class Constraint {
  /*private:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::ConstraintKind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 392,
     FQN="llvm::DependenceInfo::Constraint::ConstraintKind", NM="_ZN4llvm14DependenceInfo10Constraint14ConstraintKindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo10Constraint14ConstraintKindE")
    //</editor-fold>
    private enum ConstraintKind implements Native.NativeUIntEnum {
      Empty(0),
      Point(Empty.getValue() + 1),
      Distance(Point.getValue() + 1),
      Line(Distance.getValue() + 1),
      Any(Line.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static ConstraintKind valueOf(int val) {
        ConstraintKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final ConstraintKind[] VALUES;
        private static final ConstraintKind[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (ConstraintKind kind : ConstraintKind.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new ConstraintKind[min < 0 ? (1-min) : 0];
          VALUES = new ConstraintKind[max >= 0 ? (1+max) : 0];
          for (ConstraintKind kind : ConstraintKind.values()) {
            if (kind.value < 0) {
              if (_VALUES[-kind.value] == null) {
                _VALUES[-kind.value] = kind;
              } else {
                assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
              }
            } else {
              if (VALUES[kind.value] == null) {
                VALUES[kind.value] = kind;
              } else {
                assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
              }
            }
          }
        }
      }

      private final /*uint*/int value;
      private ConstraintKind(int val) { this.value = (/*uint*/int)val;}
      @Override public final /*uint*/int getValue() { return value;}
      //</editor-fold>
    };
    private  ConstraintKind Kind;
    private ScalarEvolution /*P*/ SE;
    private /*const*/ SCEV /*P*/ A;
    private /*const*/ SCEV /*P*/ B;
    private /*const*/ SCEV /*P*/ C;
    private /*const*/ Loop /*P*/ AssociatedLoop;
  /*public:*/
    /// isEmpty - Return true if the constraint is of kind Empty.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::isEmpty">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 401,
     FQN="llvm::DependenceInfo::Constraint::isEmpty", NM="_ZNK4llvm14DependenceInfo10Constraint7isEmptyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint7isEmptyEv")
    //</editor-fold>
    public boolean isEmpty() /*const*/ {
      return Kind == ConstraintKind.Empty;
    }

    
    /// isPoint - Return true if the constraint is of kind Point.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::isPoint">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 404,
     FQN="llvm::DependenceInfo::Constraint::isPoint", NM="_ZNK4llvm14DependenceInfo10Constraint7isPointEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint7isPointEv")
    //</editor-fold>
    public boolean isPoint() /*const*/ {
      return Kind == ConstraintKind.Point;
    }

    
    /// isDistance - Return true if the constraint is of kind Distance.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::isDistance">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 407,
     FQN="llvm::DependenceInfo::Constraint::isDistance", NM="_ZNK4llvm14DependenceInfo10Constraint10isDistanceEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint10isDistanceEv")
    //</editor-fold>
    public boolean isDistance() /*const*/ {
      return Kind == ConstraintKind.Distance;
    }

    
    /// isLine - Return true if the constraint is of kind Line.
    /// Since Distance's can also be represented as Lines, we also return
    /// true if the constraint is of kind Distance.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::isLine">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 412,
     FQN="llvm::DependenceInfo::Constraint::isLine", NM="_ZNK4llvm14DependenceInfo10Constraint6isLineEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint6isLineEv")
    //</editor-fold>
    public boolean isLine() /*const*/ {
      return Kind == ConstraintKind.Line || Kind == ConstraintKind.Distance;
    }

    
    /// isAny - Return true if the constraint is of kind Any;
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::isAny">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 415,
     FQN="llvm::DependenceInfo::Constraint::isAny", NM="_ZNK4llvm14DependenceInfo10Constraint5isAnyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint5isAnyEv")
    //</editor-fold>
    public boolean isAny() /*const*/ {
      return Kind == ConstraintKind.Any;
    }

    
    /// getX - If constraint is a point <X, Y>, returns X.
    /// Otherwise assert.
    
    //===----------------------------------------------------------------------===//
    // DependenceInfo::Constraint methods
    
    // If constraint is a point <X, Y>, returns X.
    // Otherwise assert.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::getX">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 299,
     FQN="llvm::DependenceInfo::Constraint::getX", NM="_ZNK4llvm14DependenceInfo10Constraint4getXEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint4getXEv")
    //</editor-fold>
    public /*const*/ SCEV /*P*/ getX() /*const*/ {
      assert (Kind == ConstraintKind.Point) : "Kind should be Point";
      return A;
    }

    
    /// getY - If constraint is a point <X, Y>, returns Y.
    /// Otherwise assert.
    
    // If constraint is a point <X, Y>, returns Y.
    // Otherwise assert.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::getY">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 307,
     FQN="llvm::DependenceInfo::Constraint::getY", NM="_ZNK4llvm14DependenceInfo10Constraint4getYEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint4getYEv")
    //</editor-fold>
    public /*const*/ SCEV /*P*/ getY() /*const*/ {
      assert (Kind == ConstraintKind.Point) : "Kind should be Point";
      return B;
    }

    
    /// getA - If constraint is a line AX + BY = C, returns A.
    /// Otherwise assert.
    
    // If constraint is a line AX + BY = C, returns A.
    // Otherwise assert.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::getA">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 315,
     FQN="llvm::DependenceInfo::Constraint::getA", NM="_ZNK4llvm14DependenceInfo10Constraint4getAEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint4getAEv")
    //</editor-fold>
    public /*const*/ SCEV /*P*/ getA() /*const*/ {
      assert ((Kind == ConstraintKind.Line || Kind == ConstraintKind.Distance)) : "Kind should be Line (or Distance)";
      return A;
    }

    
    /// getB - If constraint is a line AX + BY = C, returns B.
    /// Otherwise assert.
    
    // If constraint is a line AX + BY = C, returns B.
    // Otherwise assert.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::getB">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 324,
     FQN="llvm::DependenceInfo::Constraint::getB", NM="_ZNK4llvm14DependenceInfo10Constraint4getBEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint4getBEv")
    //</editor-fold>
    public /*const*/ SCEV /*P*/ getB() /*const*/ {
      assert ((Kind == ConstraintKind.Line || Kind == ConstraintKind.Distance)) : "Kind should be Line (or Distance)";
      return B;
    }

    
    /// getC - If constraint is a line AX + BY = C, returns C.
    /// Otherwise assert.
    
    // If constraint is a line AX + BY = C, returns C.
    // Otherwise assert.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::getC">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 333,
     FQN="llvm::DependenceInfo::Constraint::getC", NM="_ZNK4llvm14DependenceInfo10Constraint4getCEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint4getCEv")
    //</editor-fold>
    public /*const*/ SCEV /*P*/ getC() /*const*/ {
      assert ((Kind == ConstraintKind.Line || Kind == ConstraintKind.Distance)) : "Kind should be Line (or Distance)";
      return C;
    }

    
    /// getD - If constraint is a distance, returns D.
    /// Otherwise assert.
    
    // If constraint is a distance, returns D.
    // Otherwise assert.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::getD">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 342,
     FQN="llvm::DependenceInfo::Constraint::getD", NM="_ZNK4llvm14DependenceInfo10Constraint4getDEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint4getDEv")
    //</editor-fold>
    public /*const*/ SCEV /*P*/ getD() /*const*/ {
      assert (Kind == ConstraintKind.Distance) : "Kind should be Distance";
      return SE.getNegativeSCEV(C);
    }

    
    /// getAssociatedLoop - Returns the loop associated with this constraint.
    
    // Returns the loop associated with this constraint.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::getAssociatedLoop">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 349,
     FQN="llvm::DependenceInfo::Constraint::getAssociatedLoop", NM="_ZNK4llvm14DependenceInfo10Constraint17getAssociatedLoopEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint17getAssociatedLoopEv")
    //</editor-fold>
    public /*const*/ Loop /*P*/ getAssociatedLoop() /*const*/ {
      assert ((Kind == ConstraintKind.Distance || Kind == ConstraintKind.Line || Kind == ConstraintKind.Point)) : "Kind should be Distance, Line, or Point";
      return AssociatedLoop;
    }

    
    /// setPoint - Change a constraint to Point.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::setPoint">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 355,
     FQN="llvm::DependenceInfo::Constraint::setPoint", NM="_ZN4llvm14DependenceInfo10Constraint8setPointEPKNS_4SCEVES4_PKNS_4LoopE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo10Constraint8setPointEPKNS_4SCEVES4_PKNS_4LoopE")
    //</editor-fold>
    public void setPoint(/*const*/ SCEV /*P*/ X, /*const*/ SCEV /*P*/ Y, 
            /*const*/ Loop /*P*/ CurLoop) {
      Kind = ConstraintKind.Point;
      A = X;
      B = Y;
      AssociatedLoop = CurLoop;
    }

    
    /// setLine - Change a constraint to Line.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::setLine">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 363,
     FQN="llvm::DependenceInfo::Constraint::setLine", NM="_ZN4llvm14DependenceInfo10Constraint7setLineEPKNS_4SCEVES4_S4_PKNS_4LoopE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo10Constraint7setLineEPKNS_4SCEVES4_S4_PKNS_4LoopE")
    //</editor-fold>
    public void setLine(/*const*/ SCEV /*P*/ AA, /*const*/ SCEV /*P*/ BB, 
           /*const*/ SCEV /*P*/ CC, /*const*/ Loop /*P*/ CurLoop) {
      Kind = ConstraintKind.Line;
      A = AA;
      B = BB;
      C = CC;
      AssociatedLoop = CurLoop;
    }

    
    /// setDistance - Change a constraint to Distance.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::setDistance">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 372,
     FQN="llvm::DependenceInfo::Constraint::setDistance", NM="_ZN4llvm14DependenceInfo10Constraint11setDistanceEPKNS_4SCEVEPKNS_4LoopE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo10Constraint11setDistanceEPKNS_4SCEVEPKNS_4LoopE")
    //</editor-fold>
    public void setDistance(/*const*/ SCEV /*P*/ D, 
               /*const*/ Loop /*P*/ CurLoop) {
      Kind = ConstraintKind.Distance;
      A = SE.getOne(D.getType());
      B = SE.getNegativeSCEV(A);
      C = SE.getNegativeSCEV(D);
      AssociatedLoop = CurLoop;
    }

    
    /// setEmpty - Change a constraint to Empty.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::setEmpty">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 381,
     FQN="llvm::DependenceInfo::Constraint::setEmpty", NM="_ZN4llvm14DependenceInfo10Constraint8setEmptyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo10Constraint8setEmptyEv")
    //</editor-fold>
    public void setEmpty() {
      Kind = ConstraintKind.Empty;
    }

    
    /// setAny - Change a constraint to Any.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::setAny">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 383,
     FQN="llvm::DependenceInfo::Constraint::setAny", NM="_ZN4llvm14DependenceInfo10Constraint6setAnyEPNS_15ScalarEvolutionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo10Constraint6setAnyEPNS_15ScalarEvolutionE")
    //</editor-fold>
    public void setAny(ScalarEvolution /*P*/ NewSE) {
      SE = NewSE;
      Kind = ConstraintKind.Any;
    }

    
    /// dump - For debugging purposes. Dumps the constraint
    /// out to OS.
    
    // For debugging purposes. Dumps the constraint out to OS.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::dump">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 390,
     FQN="llvm::DependenceInfo::Constraint::dump", NM="_ZNK4llvm14DependenceInfo10Constraint4dumpERNS_11raw_ostreamE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint4dumpERNS_11raw_ostreamE")
    //</editor-fold>
    public void dump(final raw_ostream /*&*/ OS) /*const*/ {
      if (isEmpty()) {
        OS.$out(/*KEEP_STR*/" Empty\n");
      } else if (isAny()) {
        OS.$out(/*KEEP_STR*/" Any\n");
      } else if (isPoint()) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(OS.$out(/*KEEP_STR*/" Point is <"), $Deref(getX())).$out(/*KEEP_STR*/$COMMA_SPACE), $Deref(getY())).$out(/*KEEP_STR*/$GT_LF);
      } else if (isDistance()) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(OS.$out(/*KEEP_STR*/" Distance is "), $Deref(getD())).$out(
                        /*KEEP_STR*/" ("
                    ), $Deref(getA())).$out(/*KEEP_STR*/"*X + "), $Deref(getB())).$out(/*KEEP_STR*/"*Y = "), $Deref(getC())).$out(/*KEEP_STR*/")\n");
      } else if (isLine()) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(OS.$out(/*KEEP_STR*/" Line is "), $Deref(getA())).$out(/*KEEP_STR*/"*X + "), 
                $Deref(getB())).$out(/*KEEP_STR*/"*Y = "), $Deref(getC())).$out(/*KEEP_STR*/$LF);
      } else {
        throw new llvm_unreachable("unknown constraint type in Constraint::dump");
      }
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 390,
     FQN="llvm::DependenceInfo::Constraint::operator=", NM="_ZN4llvm14DependenceInfo10ConstraintaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo10ConstraintaSERKS1_")
    //</editor-fold>
    public /*inline*/ Constraint /*&*/ $assign(final /*const*/ Constraint /*&*/ $Prm0) {
      this.Kind = $Prm0.Kind;
      this.SE = $Prm0.SE;
      this.A = $Prm0.A;
      this.B = $Prm0.B;
      this.C = $Prm0.C;
      this.AssociatedLoop = $Prm0.AssociatedLoop;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::Constraint">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 390,
     FQN="llvm::DependenceInfo::Constraint::Constraint", NM="_ZN4llvm14DependenceInfo10ConstraintC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo10ConstraintC1Ev")
    //</editor-fold>
    public /*inline*/ Constraint() {
    }

    
    @Override public String toString() {
      return "" + "Kind=" + Kind // NOI18N
                + ", SE=" + SE // NOI18N
                + ", A=" + A // NOI18N
                + ", B=" + B // NOI18N
                + ", C=" + C // NOI18N
                + ", AssociatedLoop=" + AssociatedLoop; // NOI18N
    }
  };
  
  /// establishNestingLevels - Examines the loop nesting of the Src and Dst
  /// instructions and establishes their shared loops. Sets the variables
  /// CommonLevels, SrcLevels, and MaxLevels.
  /// The source and destination instructions needn't be contained in the same
  /// loop. The routine establishNestingLevels finds the level of most deeply
  /// nested loop that contains them both, CommonLevels. An instruction that's
  /// not contained in a loop is at level = 0. MaxLevels is equal to the level
  /// of the source plus the level of the destination, minus CommonLevels.
  /// This lets us allocate vectors MaxLevels in length, with room for every
  /// distinct loop referenced in both the source and destination subscripts.
  /// The variable SrcLevels is the nesting depth of the source instruction.
  /// It's used to help calculate distinct loops referenced by the destination.
  /// Here's the map from loops to levels:
  ///            0 - unused
  ///            1 - outermost common loop
  ///          ... - other common loops
  /// CommonLevels - innermost common loop
  ///          ... - loops containing Src but not Dst
  ///    SrcLevels - innermost loop containing Src but not Dst
  ///          ... - loops containing Dst but not Src
  ///    MaxLevels - innermost loop containing Dst but not Src
  /// Consider the follow code fragment:
  ///    for (a = ...) {
  ///      for (b = ...) {
  ///        for (c = ...) {
  ///          for (d = ...) {
  ///            A[] = ...;
  ///          }
  ///        }
  ///        for (e = ...) {
  ///          for (f = ...) {
  ///            for (g = ...) {
  ///              ... = A[];
  ///            }
  ///          }
  ///        }
  ///      }
  ///    }
  /// If we're looking at the possibility of a dependence between the store
  /// to A (the Src) and the load from A (the Dst), we'll note that they
  /// have 2 loops in common, so CommonLevels will equal 2 and the direction
  /// vector for Result will have 2 entries. SrcLevels = 4 and MaxLevels = 7.
  /// A map from loop names to level indices would look like
  ///     a - 1
  ///     b - 2 = CommonLevels
  ///     c - 3
  ///     d - 4 = SrcLevels
  ///     e - 5
  ///     f - 6
  ///     g - 7 = MaxLevels
  
  // Examines the loop nesting of the Src and Dst
  // instructions and establishes their shared loops. Sets the variables
  // CommonLevels, SrcLevels, and MaxLevels.
  // The source and destination instructions needn't be contained in the same
  // loop. The routine establishNestingLevels finds the level of most deeply
  // nested loop that contains them both, CommonLevels. An instruction that's
  // not contained in a loop is at level = 0. MaxLevels is equal to the level
  // of the source plus the level of the destination, minus CommonLevels.
  // This lets us allocate vectors MaxLevels in length, with room for every
  // distinct loop referenced in both the source and destination subscripts.
  // The variable SrcLevels is the nesting depth of the source instruction.
  // It's used to help calculate distinct loops referenced by the destination.
  // Here's the map from loops to levels:
  //            0 - unused
  //            1 - outermost common loop
  //          ... - other common loops
  // CommonLevels - innermost common loop
  //          ... - loops containing Src but not Dst
  //    SrcLevels - innermost loop containing Src but not Dst
  //          ... - loops containing Dst but not Src
  //    MaxLevels - innermost loops containing Dst but not Src
  // Consider the follow code fragment:
  //   for (a = ...) {
  //     for (b = ...) {
  //       for (c = ...) {
  //         for (d = ...) {
  //           A[] = ...;
  //         }
  //       }
  //       for (e = ...) {
  //         for (f = ...) {
  //           for (g = ...) {
  //             ... = A[];
  //           }
  //         }
  //       }
  //     }
  //   }
  // If we're looking at the possibility of a dependence between the store
  // to A (the Src) and the load from A (the Dst), we'll note that they
  // have 2 loops in common, so CommonLevels will equal 2 and the direction
  // vector for Result will have 2 entries. SrcLevels = 4 and MaxLevels = 7.
  // A map from loop names to loop numbers would look like
  //     a - 1
  //     b - 2 = CommonLevels
  //     c - 3
  //     d - 4 = SrcLevels
  //     e - 5
  //     f - 6
  //     g - 7 = MaxLevels
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::establishNestingLevels">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 707,
   FQN="llvm::DependenceInfo::establishNestingLevels", NM="_ZN4llvm14DependenceInfo22establishNestingLevelsEPKNS_11InstructionES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo22establishNestingLevelsEPKNS_11InstructionES3_")
  //</editor-fold>
  private void establishNestingLevels(/*const*/ Instruction /*P*/ Src, 
                        /*const*/ Instruction /*P*/ Dst) {
    /*const*/ BasicBlock /*P*/ SrcBlock = Src.getParent$Const();
    /*const*/ BasicBlock /*P*/ DstBlock = Dst.getParent$Const();
    /*uint*/int SrcLevel = LI.getLoopDepth(SrcBlock);
    /*uint*/int DstLevel = LI.getLoopDepth(DstBlock);
    /*const*/ Loop /*P*/ SrcLoop = LI.getLoopFor(SrcBlock);
    /*const*/ Loop /*P*/ DstLoop = LI.getLoopFor(DstBlock);
    SrcLevels = SrcLevel;
    MaxLevels = SrcLevel + DstLevel;
    while ($greater_uint(SrcLevel, DstLevel)) {
      SrcLoop = SrcLoop.getParentLoop();
      SrcLevel--;
    }
    while ($greater_uint(DstLevel, SrcLevel)) {
      DstLoop = DstLoop.getParentLoop();
      DstLevel--;
    }
    while (SrcLoop != DstLoop) {
      SrcLoop = SrcLoop.getParentLoop();
      DstLoop = DstLoop.getParentLoop();
      SrcLevel--;
    }
    CommonLevels = SrcLevel;
    MaxLevels -= CommonLevels;
  }

  
  private /*uint*/int CommonLevels;
  
  private /*uint*/int SrcLevels;
  
  private /*uint*/int MaxLevels;
  
  /// mapSrcLoop - Given one of the loops containing the source, return
  /// its level index in our numbering scheme.
  
  // Given one of the loops containing the source, return
  // its level index in our numbering scheme.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::mapSrcLoop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 737,
   FQN="llvm::DependenceInfo::mapSrcLoop", NM="_ZNK4llvm14DependenceInfo10mapSrcLoopEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10mapSrcLoopEPKNS_4LoopE")
  //</editor-fold>
  private /*uint*/int mapSrcLoop(/*const*/ Loop /*P*/ SrcLoop) /*const*/ {
    return SrcLoop.getLoopDepth();
  }

  
  /// mapDstLoop - Given one of the loops containing the destination,
  /// return its level index in our numbering scheme.
  
  // Given one of the loops containing the destination,
  // return its level index in our numbering scheme.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::mapDstLoop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 744,
   FQN="llvm::DependenceInfo::mapDstLoop", NM="_ZNK4llvm14DependenceInfo10mapDstLoopEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10mapDstLoopEPKNS_4LoopE")
  //</editor-fold>
  private /*uint*/int mapDstLoop(/*const*/ Loop /*P*/ DstLoop) /*const*/ {
    /*uint*/int D = DstLoop.getLoopDepth();
    if ($greater_uint(D, CommonLevels)) {
      return D - CommonLevels + SrcLevels;
    } else {
      return D;
    }
  }

  
  /// isLoopInvariant - Returns true if Expression is loop invariant
  /// in LoopNest.
  
  // Returns true if Expression is loop invariant in LoopNest.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::isLoopInvariant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 754,
   FQN="llvm::DependenceInfo::isLoopInvariant", NM="_ZNK4llvm14DependenceInfo15isLoopInvariantEPKNS_4SCEVEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo15isLoopInvariantEPKNS_4SCEVEPKNS_4LoopE")
  //</editor-fold>
  private boolean isLoopInvariant(/*const*/ SCEV /*P*/ Expression, 
                 /*const*/ Loop /*P*/ LoopNest) /*const*/ {
    if (!(LoopNest != null)) {
      return true;
    }
    return SE.isLoopInvariant(Expression, LoopNest)
       && isLoopInvariant(Expression, LoopNest.getParentLoop());
  }

  
  /// Makes sure all subscript pairs share the same integer type by
  /// sign-extending as necessary.
  /// Sign-extending a subscript is safe because getelementptr assumes the
  /// array subscripts are signed.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::unifySubscriptType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 777,
   FQN="llvm::DependenceInfo::unifySubscriptType", NM="_ZN4llvm14DependenceInfo18unifySubscriptTypeENS_8ArrayRefIPNS0_9SubscriptEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo18unifySubscriptTypeENS_8ArrayRefIPNS0_9SubscriptEEE")
  //</editor-fold>
  private void unifySubscriptType(ArrayRef<Subscript /*P*/ > Pairs) {
    
    /*uint*/int widestWidthSeen = 0;
    Type /*P*/ widestType = null;
    
    // Go through each pair and find the widest bit to which we need
    // to extend all of them.
    for (Subscript /*P*/ Pair : Pairs) {
      /*const*/ SCEV /*P*/ Src = Pair.Src;
      /*const*/ SCEV /*P*/ Dst = Pair.Dst;
      IntegerType /*P*/ SrcTy = dyn_cast_IntegerType(Src.getType());
      IntegerType /*P*/ DstTy = dyn_cast_IntegerType(Dst.getType());
      if (SrcTy == null || DstTy == null) {
        assert (SrcTy == DstTy) : "This function only unify integer types and expect Src and Dst share the same type otherwise.";
        continue;
      }
      if ($greater_uint(SrcTy.getBitWidth(), widestWidthSeen)) {
        widestWidthSeen = SrcTy.getBitWidth();
        widestType = SrcTy;
      }
      if ($greater_uint(DstTy.getBitWidth(), widestWidthSeen)) {
        widestWidthSeen = DstTy.getBitWidth();
        widestType = DstTy;
      }
    }
    assert ($greater_uint(widestWidthSeen, 0));
    
    // Now extend each pair to the widest seen.
    for (Subscript /*P*/ Pair : Pairs) {
      /*const*/ SCEV /*P*/ Src = Pair.Src;
      /*const*/ SCEV /*P*/ Dst = Pair.Dst;
      IntegerType /*P*/ SrcTy = dyn_cast_IntegerType(Src.getType());
      IntegerType /*P*/ DstTy = dyn_cast_IntegerType(Dst.getType());
      if (SrcTy == null || DstTy == null) {
        assert (SrcTy == DstTy) : "This function only unify integer types and expect Src and Dst share the same type otherwise.";
        continue;
      }
      if ($less_uint(SrcTy.getBitWidth(), widestWidthSeen)) {
        // Sign-extend Src to widestType
        Pair.Src = SE.getSignExtendExpr(Src, widestType);
      }
      if ($less_uint(DstTy.getBitWidth(), widestWidthSeen)) {
        // Sign-extend Dst to widestType
        Pair.Dst = SE.getSignExtendExpr(Dst, widestType);
      }
    }
  }

  
  /// removeMatchingExtensions - Examines a subscript pair.
  /// If the source and destination are identically sign (or zero)
  /// extended, it strips off the extension in an effort to
  /// simplify the actual analysis.
  
  // removeMatchingExtensions - Examines a subscript pair.
  // If the source and destination are identically sign (or zero)
  // extended, it strips off the extension in an effect to simplify
  // the actual analysis.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::removeMatchingExtensions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 834,
   FQN="llvm::DependenceInfo::removeMatchingExtensions", NM="_ZN4llvm14DependenceInfo24removeMatchingExtensionsEPNS0_9SubscriptE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo24removeMatchingExtensionsEPNS0_9SubscriptE")
  //</editor-fold>
  private void removeMatchingExtensions(Subscript /*P*/ Pair) {
    /*const*/ SCEV /*P*/ Src = Pair.Src;
    /*const*/ SCEV /*P*/ Dst = Pair.Dst;
    if ((isa_SCEVZeroExtendExpr(Src) && isa_SCEVZeroExtendExpr(Dst))
       || (isa_SCEVSignExtendExpr(Src) && isa_SCEVSignExtendExpr(Dst))) {
      /*const*/ SCEVCastExpr /*P*/ SrcCast = cast_SCEVCastExpr(Src);
      /*const*/ SCEVCastExpr /*P*/ DstCast = cast_SCEVCastExpr(Dst);
      /*const*/ SCEV /*P*/ SrcCastOp = SrcCast.getOperand();
      /*const*/ SCEV /*P*/ DstCastOp = DstCast.getOperand();
      if (SrcCastOp.getType() == DstCastOp.getType()) {
        Pair.Src = SrcCastOp;
        Pair.Dst = DstCastOp;
      }
    }
  }

  
  /// collectCommonLoops - Finds the set of loops from the LoopNest that
  /// have a level <= CommonLevels and are referred to by the SCEV Expression.
  
  // Finds the set of loops from the LoopNest that
  // have a level <= CommonLevels and are referred to by the SCEV Expression.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::collectCommonLoops">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 766,
   FQN="llvm::DependenceInfo::collectCommonLoops", NM="_ZNK4llvm14DependenceInfo18collectCommonLoopsEPKNS_4SCEVEPKNS_4LoopERNS_14SmallBitVectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo18collectCommonLoopsEPKNS_4SCEVEPKNS_4LoopERNS_14SmallBitVectorE")
  //</editor-fold>
  private void collectCommonLoops(/*const*/ SCEV /*P*/ Expression, 
                    /*const*/ Loop /*P*/ LoopNest, 
                    final SmallBitVector /*&*/ Loops) /*const*/ {
    while ((LoopNest != null)) {
      /*uint*/int Level = LoopNest.getLoopDepth();
      if ($lesseq_uint(Level, CommonLevels) && !SE.isLoopInvariant(Expression, LoopNest)) {
        Loops.set(Level);
      }
      LoopNest = LoopNest.getParentLoop();
    }
  }

  
  /// checkSrcSubscript - Examines the SCEV Src, returning true iff it's
  /// linear. Collect the set of loops mentioned by Src.
  
  // Examine the scev and return true iff it's linear.
  // Collect any loops mentioned in the set of "Loops".
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::checkSrcSubscript">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 853,
   FQN="llvm::DependenceInfo::checkSrcSubscript", NM="_ZN4llvm14DependenceInfo17checkSrcSubscriptEPKNS_4SCEVEPKNS_4LoopERNS_14SmallBitVectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo17checkSrcSubscriptEPKNS_4SCEVEPKNS_4LoopERNS_14SmallBitVectorE")
  //</editor-fold>
  private boolean checkSrcSubscript(/*const*/ SCEV /*P*/ Src, /*const*/ Loop /*P*/ LoopNest, 
                   final SmallBitVector /*&*/ Loops) {
    /*const*/ SCEVAddRecExpr /*P*/ AddRec = dyn_cast_SCEVAddRecExpr(Src);
    if (!(AddRec != null)) {
      return isLoopInvariant(Src, LoopNest);
    }
    /*const*/ SCEV /*P*/ Start = AddRec.getStart();
    /*const*/ SCEV /*P*/ Step = AddRec.getStepRecurrence($Deref(SE));
    /*const*/ SCEV /*P*/ UB = SE.getBackedgeTakenCount(AddRec.getLoop());
    if (!isa_SCEVCouldNotCompute(UB)) {
      if ($less_ulong(SE.getTypeSizeInBits(Start.getType())
        , SE.getTypeSizeInBits(UB.getType()))) {
        if (!(AddRec.getNoWrapFlags() != 0)) {
          return false;
        }
      }
    }
    if (!isLoopInvariant(Step, LoopNest)) {
      return false;
    }
    Loops.set(mapSrcLoop(AddRec.getLoop()));
    return checkSrcSubscript(Start, LoopNest, Loops);
  }

  
  /// checkDstSubscript - Examines the SCEV Dst, returning true iff it's
  /// linear. Collect the set of loops mentioned by Dst.
  
  // Examine the scev and return true iff it's linear.
  // Collect any loops mentioned in the set of "Loops".
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::checkDstSubscript">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 878,
   FQN="llvm::DependenceInfo::checkDstSubscript", NM="_ZN4llvm14DependenceInfo17checkDstSubscriptEPKNS_4SCEVEPKNS_4LoopERNS_14SmallBitVectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo17checkDstSubscriptEPKNS_4SCEVEPKNS_4LoopERNS_14SmallBitVectorE")
  //</editor-fold>
  private boolean checkDstSubscript(/*const*/ SCEV /*P*/ Dst, /*const*/ Loop /*P*/ LoopNest, 
                   final SmallBitVector /*&*/ Loops) {
    /*const*/ SCEVAddRecExpr /*P*/ AddRec = dyn_cast_SCEVAddRecExpr(Dst);
    if (!(AddRec != null)) {
      return isLoopInvariant(Dst, LoopNest);
    }
    /*const*/ SCEV /*P*/ Start = AddRec.getStart();
    /*const*/ SCEV /*P*/ Step = AddRec.getStepRecurrence($Deref(SE));
    /*const*/ SCEV /*P*/ UB = SE.getBackedgeTakenCount(AddRec.getLoop());
    if (!isa_SCEVCouldNotCompute(UB)) {
      if ($less_ulong(SE.getTypeSizeInBits(Start.getType())
        , SE.getTypeSizeInBits(UB.getType()))) {
        if (!(AddRec.getNoWrapFlags() != 0)) {
          return false;
        }
      }
    }
    if (!isLoopInvariant(Step, LoopNest)) {
      return false;
    }
    Loops.set(mapDstLoop(AddRec.getLoop()));
    return checkDstSubscript(Start, LoopNest, Loops);
  }

  
  /// isKnownPredicate - Compare X and Y using the predicate Pred.
  /// Basically a wrapper for SCEV::isKnownPredicate,
  /// but tries harder, especially in the presence of sign and zero
  /// extensions and symbolics.
  
  // A wrapper around SCEV::isKnownPredicate.
  // Looks for cases where we're interested in comparing for equality.
  // If both X and Y have been identically sign or zero extended,
  // it strips off the (confusing) extensions before invoking
  // SCEV::isKnownPredicate. Perhaps, someday, the ScalarEvolution package
  // will be similarly updated.
  //
  // If SCEV::isKnownPredicate can't prove the predicate,
  // we try simple subtraction, which seems to help in some cases
  // involving symbolics.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::isKnownPredicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 938,
   FQN="llvm::DependenceInfo::isKnownPredicate", NM="_ZNK4llvm14DependenceInfo16isKnownPredicateENS_7CmpInst9PredicateEPKNS_4SCEVES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo16isKnownPredicateENS_7CmpInst9PredicateEPKNS_4SCEVES5_")
  //</editor-fold>
  private boolean isKnownPredicate(ICmpInst.Predicate Pred, /*const*/ SCEV /*P*/ X, 
                  /*const*/ SCEV /*P*/ Y) /*const*/ {
    if (Pred == CmpInst.Predicate.ICMP_EQ
       || Pred == CmpInst.Predicate.ICMP_NE) {
      if ((isa_SCEVSignExtendExpr(X)
         && isa_SCEVSignExtendExpr(Y))
         || (isa_SCEVZeroExtendExpr(X)
         && isa_SCEVZeroExtendExpr(Y))) {
        /*const*/ SCEVCastExpr /*P*/ CX = cast_SCEVCastExpr(X);
        /*const*/ SCEVCastExpr /*P*/ CY = cast_SCEVCastExpr(Y);
        /*const*/ SCEV /*P*/ Xop = CX.getOperand();
        /*const*/ SCEV /*P*/ Yop = CY.getOperand();
        if (Xop.getType() == Yop.getType()) {
          X = Xop;
          Y = Yop;
        }
      }
    }
    if (SE.isKnownPredicate(Pred, X, Y)) {
      return true;
    }
    // If SE->isKnownPredicate can't prove the condition,
    // we try the brute-force approach of subtracting
    // and testing the difference.
    // By testing with SE->isKnownPredicate first, we avoid
    // the possibility of overflow when the arguments are constants.
    /*const*/ SCEV /*P*/ Delta = SE.getMinusSCEV(X, Y);
    switch (Pred) {
     case ICMP_EQ:
      return Delta.isZero();
     case ICMP_NE:
      return SE.isKnownNonZero(Delta);
     case ICMP_SGE:
      return SE.isKnownNonNegative(Delta);
     case ICMP_SLE:
      return SE.isKnownNonPositive(Delta);
     case ICMP_SGT:
      return SE.isKnownPositive(Delta);
     case ICMP_SLT:
      return SE.isKnownNegative(Delta);
     default:
      throw new llvm_unreachable("unexpected predicate in isKnownPredicate");
    }
  }

  
  /// collectUpperBound - All subscripts are the same type (on my machine,
  /// an i64). The loop bound may be a smaller type. collectUpperBound
  /// find the bound, if available, and zero extends it to the Type T.
  /// (I zero extend since the bound should always be >= 0.)
  /// If no upper bound is available, return NULL.
  
  // All subscripts are all the same type.
  // Loop bound may be smaller (e.g., a char).
  // Should zero extend loop bound, since it's always >= 0.
  // This routine collects upper bound and extends or truncates if needed.
  // Truncating is safe when subscripts are known not to wrap. Cases without
  // nowrap flags should have been rejected earlier.
  // Return null if no bound available.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::collectUpperBound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 990,
   FQN="llvm::DependenceInfo::collectUpperBound", NM="_ZNK4llvm14DependenceInfo17collectUpperBoundEPKNS_4LoopEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo17collectUpperBoundEPKNS_4LoopEPNS_4TypeE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ collectUpperBound(/*const*/ Loop /*P*/ L, Type /*P*/ T) /*const*/ {
    if (SE.hasLoopInvariantBackedgeTakenCount(L)) {
      /*const*/ SCEV /*P*/ UB = SE.getBackedgeTakenCount(L);
      return SE.getTruncateOrZeroExtend(UB, T);
    }
    return null;
  }

  
  /// collectConstantUpperBound - Calls collectUpperBound(), then
  /// attempts to cast it to SCEVConstant. If the cast fails,
  /// returns NULL.
  
  // Calls collectUpperBound(), then attempts to cast it to SCEVConstant.
  // If the cast fails, returns NULL.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::collectConstantUpperBound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1001,
   FQN="llvm::DependenceInfo::collectConstantUpperBound", NM="_ZNK4llvm14DependenceInfo25collectConstantUpperBoundEPKNS_4LoopEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo25collectConstantUpperBoundEPKNS_4LoopEPNS_4TypeE")
  //</editor-fold>
  private /*const*/ SCEVConstant /*P*/ collectConstantUpperBound(/*const*/ Loop /*P*/ L, 
                           Type /*P*/ T) /*const*/ {
    {
      /*const*/ SCEV /*P*/ UB = collectUpperBound(L, T);
      if ((UB != null)) {
        return dyn_cast_SCEVConstant(UB);
      }
    }
    return null;
  }

  
  /// classifyPair - Examines the subscript pair (the Src and Dst SCEVs)
  /// and classifies it as either ZIV, SIV, RDIV, MIV, or Nonlinear.
  /// Collects the associated loops in a set.
  
  // Examines the subscript pair (the Src and Dst SCEVs)
  // and classifies it as either ZIV, SIV, RDIV, MIV, or Nonlinear.
  // Collects the associated loops in a set.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::classifyPair">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 903,
   FQN="llvm::DependenceInfo::classifyPair", NM="_ZN4llvm14DependenceInfo12classifyPairEPKNS_4SCEVEPKNS_4LoopES3_S6_RNS_14SmallBitVectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo12classifyPairEPKNS_4SCEVEPKNS_4LoopES3_S6_RNS_14SmallBitVectorE")
  //</editor-fold>
  private DependenceInfo.Subscript.ClassificationKind classifyPair(/*const*/ SCEV /*P*/ Src, /*const*/ Loop /*P*/ SrcLoopNest, 
              /*const*/ SCEV /*P*/ Dst, /*const*/ Loop /*P*/ DstLoopNest, 
              final SmallBitVector /*&*/ Loops) {
    SmallBitVector SrcLoops/*J*/= new SmallBitVector(MaxLevels + 1);
    SmallBitVector DstLoops/*J*/= new SmallBitVector(MaxLevels + 1);
    if (!checkSrcSubscript(Src, SrcLoopNest, SrcLoops)) {
      return Subscript.ClassificationKind.NonLinear;
    }
    if (!checkDstSubscript(Dst, DstLoopNest, DstLoops)) {
      return Subscript.ClassificationKind.NonLinear;
    }
    Loops.$assign(SrcLoops);
    Loops.$orassign(DstLoops);
    /*uint*/int N = Loops.count();
    if (N == 0) {
      return Subscript.ClassificationKind.ZIV;
    }
    if (N == 1) {
      return Subscript.ClassificationKind.SIV;
    }
    if (N == 2 && (SrcLoops.count() == 0
       || DstLoops.count() == 0
       || (SrcLoops.count() == 1 && DstLoops.count() == 1))) {
      return Subscript.ClassificationKind.RDIV;
    }
    return Subscript.ClassificationKind.MIV;
  }

  
  /// testZIV - Tests the ZIV subscript pair (Src and Dst) for dependence.
  /// Returns true if any possible dependence is disproved.
  /// If there might be a dependence, returns false.
  /// If the dependence isn't proven to exist,
  /// marks the Result as inconsistent.
  
  // testZIV -
  // When we have a pair of subscripts of the form [c1] and [c2],
  // where c1 and c2 are both loop invariant, we attack it using
  // the ZIV test. Basically, we test by comparing the two values,
  // but there are actually three possible results:
  // 1) the values are equal, so there's a dependence
  // 2) the values are different, so there's no dependence
  // 3) the values might be equal, so we have to assume a dependence.
  //
  // Return true if dependence disproved.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::testZIV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1019,
   FQN="llvm::DependenceInfo::testZIV", NM="_ZNK4llvm14DependenceInfo7testZIVEPKNS_4SCEVES3_RNS_14FullDependenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo7testZIVEPKNS_4SCEVES3_RNS_14FullDependenceE")
  //</editor-fold>
  private boolean testZIV(/*const*/ SCEV /*P*/ Src, /*const*/ SCEV /*P*/ Dst, 
         final FullDependence /*&*/ Result) /*const*/ {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"    src = "), $Deref(Src)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"    dst = "), $Deref(Dst)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    ZIVapplications.$preInc();
    if (isKnownPredicate(CmpInst.Predicate.ICMP_EQ, Src, Dst)) {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          dbgs().$out(/*KEEP_STR*/"    provably dependent\n");
        }
      } while (false);
      return false; // provably dependent
    }
    if (isKnownPredicate(CmpInst.Predicate.ICMP_NE, Src, Dst)) {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          dbgs().$out(/*KEEP_STR*/"    provably independent\n");
        }
      } while (false);
      ZIVindependence.$preInc();
      return true; // provably independent
    }
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"    possibly dependent\n");
      }
    } while (false);
    Result.Consistent = false;
    return false; // possibly dependent
  }

  
  /// testSIV - Tests the SIV subscript pair (Src and Dst) for dependence.
  /// Things of the form [c1 + a1*i] and [c2 + a2*j], where
  /// i and j are induction variables, c1 and c2 are loop invariant,
  /// and a1 and a2 are constant.
  /// Returns true if any possible dependence is disproved.
  /// If there might be a dependence, returns false.
  /// Sets appropriate direction vector entry and, when possible,
  /// the distance vector entry.
  /// If the dependence isn't proven to exist,
  /// marks the Result as inconsistent.
  
  // testSIV -
  // When we have a pair of subscripts of the form [c1 + a1*i] and [c2 - a2*i]
  // where i is an induction variable, c1 and c2 are loop invariant, and a1 and
  // a2 are constant, we attack it with an SIV test. While they can all be
  // solved with the Exact SIV test, it's worthwhile to use simpler tests when
  // they apply; they're cheaper and sometimes more precise.
  //
  // Return true if dependence disproved.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::testSIV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2073,
   FQN="llvm::DependenceInfo::testSIV", NM="_ZNK4llvm14DependenceInfo7testSIVEPKNS_4SCEVES3_RjRNS_14FullDependenceERNS0_10ConstraintERS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo7testSIVEPKNS_4SCEVES3_RjRNS_14FullDependenceERNS0_10ConstraintERS3_")
  //</editor-fold>
  private boolean testSIV(/*const*/ SCEV /*P*/ Src, /*const*/ SCEV /*P*/ Dst, final uint$ref/*uint &*/ Level, 
         final FullDependence /*&*/ Result, final Constraint /*&*/ NewConstraint, 
         final type$ref</*const*/ SCEV /*P*/ /*&*/> SplitIter) /*const*/ {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"    src = "), $Deref(Src)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"    dst = "), $Deref(Dst)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    /*const*/ SCEVAddRecExpr /*P*/ SrcAddRec = dyn_cast_SCEVAddRecExpr(Src);
    /*const*/ SCEVAddRecExpr /*P*/ DstAddRec = dyn_cast_SCEVAddRecExpr(Dst);
    if ((SrcAddRec != null) && (DstAddRec != null)) {
      /*const*/ SCEV /*P*/ SrcConst = SrcAddRec.getStart();
      /*const*/ SCEV /*P*/ DstConst = DstAddRec.getStart();
      /*const*/ SCEV /*P*/ SrcCoeff = SrcAddRec.getStepRecurrence($Deref(SE));
      /*const*/ SCEV /*P*/ DstCoeff = DstAddRec.getStepRecurrence($Deref(SE));
      /*const*/ Loop /*P*/ CurLoop = SrcAddRec.getLoop();
      assert (CurLoop == DstAddRec.getLoop()) : "both loops in SIV should be same";
      Level.$set(mapSrcLoop(CurLoop));
      boolean disproven;
      if (SrcCoeff == DstCoeff) {
        disproven = strongSIVtest(SrcCoeff, SrcConst, DstConst, CurLoop, 
            Level.$deref(), Result, NewConstraint);
      } else if (SrcCoeff == SE.getNegativeSCEV(DstCoeff)) {
        disproven = weakCrossingSIVtest(SrcCoeff, SrcConst, DstConst, CurLoop, 
            Level.$deref(), Result, NewConstraint, SplitIter);
      } else {
        disproven = exactSIVtest(SrcCoeff, DstCoeff, SrcConst, DstConst, CurLoop, 
            Level.$deref(), Result, NewConstraint);
      }
      return disproven
         || gcdMIVtest(Src, Dst, Result)
         || symbolicRDIVtest(SrcCoeff, DstCoeff, SrcConst, DstConst, CurLoop, CurLoop);
    }
    if ((SrcAddRec != null)) {
      /*const*/ SCEV /*P*/ SrcConst = SrcAddRec.getStart();
      /*const*/ SCEV /*P*/ SrcCoeff = SrcAddRec.getStepRecurrence($Deref(SE));
      /*const*/ SCEV /*P*/ DstConst = Dst;
      /*const*/ Loop /*P*/ CurLoop = SrcAddRec.getLoop();
      Level.$set(mapSrcLoop(CurLoop));
      return weakZeroDstSIVtest(SrcCoeff, SrcConst, DstConst, CurLoop, 
          Level.$deref(), Result, NewConstraint)
         || gcdMIVtest(Src, Dst, Result);
    }
    if ((DstAddRec != null)) {
      /*const*/ SCEV /*P*/ DstConst = DstAddRec.getStart();
      /*const*/ SCEV /*P*/ DstCoeff = DstAddRec.getStepRecurrence($Deref(SE));
      /*const*/ SCEV /*P*/ SrcConst = Src;
      /*const*/ Loop /*P*/ CurLoop = DstAddRec.getLoop();
      Level.$set(mapDstLoop(CurLoop));
      return weakZeroSrcSIVtest(DstCoeff, SrcConst, DstConst, 
          CurLoop, Level.$deref(), Result, NewConstraint)
         || gcdMIVtest(Src, Dst, Result);
    }
    throw new llvm_unreachable("SIV test expected at least one AddRec");
//    return false;
  }

  
  /// testRDIV - Tests the RDIV subscript pair (Src and Dst) for dependence.
  /// Things of the form [c1 + a1*i] and [c2 + a2*j]
  /// where i and j are induction variables, c1 and c2 are loop invariant,
  /// and a1 and a2 are constant.
  /// With minor algebra, this test can also be used for things like
  /// [c1 + a1*i + a2*j][c2].
  /// Returns true if any possible dependence is disproved.
  /// If there might be a dependence, returns false.
  /// Marks the Result as inconsistent.
  
  // testRDIV -
  // When we have a pair of subscripts of the form [c1 + a1*i] and [c2 + a2*j]
  // where i and j are induction variables, c1 and c2 are loop invariant,
  // and a1 and a2 are constant, we can solve it exactly with an easy adaptation
  // of the Exact SIV test, the Restricted Double Index Variable (RDIV) test.
  // It doesn't make sense to talk about distance or direction in this case,
  // so there's no point in making special versions of the Strong SIV test or
  // the Weak-crossing SIV test.
  //
  // With minor algebra, this test can also be used for things like
  // [c1 + a1*i + a2*j][c2].
  //
  // Return true if dependence disproved.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::testRDIV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2141,
   FQN="llvm::DependenceInfo::testRDIV", NM="_ZNK4llvm14DependenceInfo8testRDIVEPKNS_4SCEVES3_RNS_14FullDependenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo8testRDIVEPKNS_4SCEVES3_RNS_14FullDependenceE")
  //</editor-fold>
  private boolean testRDIV(/*const*/ SCEV /*P*/ Src, /*const*/ SCEV /*P*/ Dst, 
          final FullDependence /*&*/ Result) /*const*/ {
    // we have 3 possible situations here:
    //   1) [a*i + b] and [c*j + d]
    //   2) [a*i + c*j + b] and [d]
    //   3) [b] and [a*i + c*j + d]
    // We need to find what we've got and get organized
    /*const*/ SCEV /*P*/ SrcConst;
    /*const*/ SCEV /*P*/ DstConst;
    /*const*/ SCEV /*P*/ SrcCoeff;
    /*const*/ SCEV /*P*/ DstCoeff;
    /*const*/ Loop /*P*/ SrcLoop;
    /*const*/ Loop /*P*/ DstLoop;
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"    src = "), $Deref(Src)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"    dst = "), $Deref(Dst)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    /*const*/ SCEVAddRecExpr /*P*/ SrcAddRec = dyn_cast_SCEVAddRecExpr(Src);
    /*const*/ SCEVAddRecExpr /*P*/ DstAddRec = dyn_cast_SCEVAddRecExpr(Dst);
    if ((SrcAddRec != null) && (DstAddRec != null)) {
      SrcConst = SrcAddRec.getStart();
      SrcCoeff = SrcAddRec.getStepRecurrence($Deref(SE));
      SrcLoop = SrcAddRec.getLoop();
      DstConst = DstAddRec.getStart();
      DstCoeff = DstAddRec.getStepRecurrence($Deref(SE));
      DstLoop = DstAddRec.getLoop();
    } else if ((SrcAddRec != null)) {
      {
        /*const*/ SCEVAddRecExpr /*P*/ tmpAddRec = dyn_cast_SCEVAddRecExpr(SrcAddRec.getStart());
        if ((tmpAddRec != null)) {
          SrcConst = tmpAddRec.getStart();
          SrcCoeff = tmpAddRec.getStepRecurrence($Deref(SE));
          SrcLoop = tmpAddRec.getLoop();
          DstConst = Dst;
          DstCoeff = SE.getNegativeSCEV(SrcAddRec.getStepRecurrence($Deref(SE)));
          DstLoop = SrcAddRec.getLoop();
        } else {
          throw new llvm_unreachable("RDIV reached by surprising SCEVs");
        }
      }
    } else if ((DstAddRec != null)) {
      {
        /*const*/ SCEVAddRecExpr /*P*/ tmpAddRec = dyn_cast_SCEVAddRecExpr(DstAddRec.getStart());
        if ((tmpAddRec != null)) {
          DstConst = tmpAddRec.getStart();
          DstCoeff = tmpAddRec.getStepRecurrence($Deref(SE));
          DstLoop = tmpAddRec.getLoop();
          SrcConst = Src;
          SrcCoeff = SE.getNegativeSCEV(DstAddRec.getStepRecurrence($Deref(SE)));
          SrcLoop = DstAddRec.getLoop();
        } else {
          throw new llvm_unreachable("RDIV reached by surprising SCEVs");
        }
      }
    } else {
      throw new llvm_unreachable("RDIV expected at least one AddRec");
    }
    return exactRDIVtest(SrcCoeff, DstCoeff, 
        SrcConst, DstConst, 
        SrcLoop, DstLoop, 
        Result)
       || gcdMIVtest(Src, Dst, Result)
       || symbolicRDIVtest(SrcCoeff, DstCoeff, 
        SrcConst, DstConst, 
        SrcLoop, DstLoop);
  }

  
  /// testMIV - Tests the MIV subscript pair (Src and Dst) for dependence.
  /// Returns true if dependence disproved.
  /// Can sometimes refine direction vectors.
  
  // Tests the single-subscript MIV pair (Src and Dst) for dependence.
  // Return true if dependence disproved.
  // Can sometimes refine direction vectors.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::testMIV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2207,
   FQN="llvm::DependenceInfo::testMIV", NM="_ZNK4llvm14DependenceInfo7testMIVEPKNS_4SCEVES3_RKNS_14SmallBitVectorERNS_14FullDependenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo7testMIVEPKNS_4SCEVES3_RKNS_14SmallBitVectorERNS_14FullDependenceE")
  //</editor-fold>
  private boolean testMIV(/*const*/ SCEV /*P*/ Src, /*const*/ SCEV /*P*/ Dst, 
         final /*const*/ SmallBitVector /*&*/ Loops, 
         final FullDependence /*&*/ Result) /*const*/ {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"    src = "), $Deref(Src)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"    dst = "), $Deref(Dst)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    Result.Consistent = false;
    return gcdMIVtest(Src, Dst, Result)
       || banerjeeMIVtest(Src, Dst, Loops, Result);
  }

  
  /// strongSIVtest - Tests the strong SIV subscript pair (Src and Dst)
  /// for dependence.
  /// Things of the form [c1 + a*i] and [c2 + a*i],
  /// where i is an induction variable, c1 and c2 are loop invariant,
  /// and a is a constant
  /// Returns true if any possible dependence is disproved.
  /// If there might be a dependence, returns false.
  /// Sets appropriate direction and distance.
  
  // strongSIVtest -
  // From the paper, Practical Dependence Testing, Section 4.2.1
  //
  // When we have a pair of subscripts of the form [c1 + a*i] and [c2 + a*i],
  // where i is an induction variable, c1 and c2 are loop invariant,
  //  and a is a constant, we can solve it exactly using the Strong SIV test.
  //
  // Can prove independence. Failing that, can compute distance (and direction).
  // In the presence of symbolic terms, we can sometimes make progress.
  //
  // If there's a dependence,
  //
  //    c1 + a*i = c2 + a*i'
  //
  // The dependence distance is
  //
  //    d = i' - i = (c1 - c2)/a
  //
  // A dependence only exists if d is an integer and abs(d) <= U, where U is the
  // loop's upper bound. If a dependence exists, the dependence direction is
  // defined as
  //
  //                { < if d > 0
  //    direction = { = if d = 0
  //                { > if d < 0
  //
  // Return true if dependence disproved.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::strongSIVtest">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1066,
   FQN="llvm::DependenceInfo::strongSIVtest", NM="_ZNK4llvm14DependenceInfo13strongSIVtestEPKNS_4SCEVES3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo13strongSIVtestEPKNS_4SCEVES3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintE")
  //</editor-fold>
  private boolean strongSIVtest(/*const*/ SCEV /*P*/ Coeff, /*const*/ SCEV /*P*/ SrcConst, 
               /*const*/ SCEV /*P*/ DstConst, /*const*/ Loop /*P*/ CurLoop, 
               /*uint*/int Level, final FullDependence /*&*/ Result, 
               final Constraint /*&*/ NewConstraint) /*const*/ {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"\tStrong SIV test\n");
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    Coeff = "), $Deref(Coeff));
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        IrLlvmGlobals.$out_raw_ostream_Type(dbgs().$out(/*KEEP_STR*/$COMMA_SPACE), $Deref(Coeff.getType())).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    SrcConst = "), $Deref(SrcConst));
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        IrLlvmGlobals.$out_raw_ostream_Type(dbgs().$out(/*KEEP_STR*/$COMMA_SPACE), $Deref(SrcConst.getType())).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    DstConst = "), $Deref(DstConst));
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        IrLlvmGlobals.$out_raw_ostream_Type(dbgs().$out(/*KEEP_STR*/$COMMA_SPACE), $Deref(DstConst.getType())).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    StrongSIVapplications.$preInc();
    assert ($less_uint(0, Level) && $lesseq_uint(Level, CommonLevels)) : "level out of range";
    Level--;
    
    /*const*/ SCEV /*P*/ Delta = SE.getMinusSCEV(SrcConst, DstConst);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    Delta = "), $Deref(Delta));
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        IrLlvmGlobals.$out_raw_ostream_Type(dbgs().$out(/*KEEP_STR*/$COMMA_SPACE), $Deref(Delta.getType())).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    {
      
      // check that |Delta| < iteration count
      /*const*/ SCEV /*P*/ UpperBound = collectUpperBound(CurLoop, Delta.getType());
      if ((UpperBound != null)) {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    UpperBound = "), $Deref(UpperBound));
          }
        } while (false);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            IrLlvmGlobals.$out_raw_ostream_Type(dbgs().$out(/*KEEP_STR*/$COMMA_SPACE), $Deref(UpperBound.getType())).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        /*const*/ SCEV /*P*/ AbsDelta = SE.isKnownNonNegative(Delta) ? Delta : SE.getNegativeSCEV(Delta);
        /*const*/ SCEV /*P*/ AbsCoeff = SE.isKnownNonNegative(Coeff) ? Coeff : SE.getNegativeSCEV(Coeff);
        /*const*/ SCEV /*P*/ Product = SE.getMulExpr(UpperBound, AbsCoeff);
        if (isKnownPredicate(CmpInst.Predicate.ICMP_SGT, AbsDelta, Product)) {
          // Distance greater than trip count - no dependence
          StrongSIVindependence.$preInc();
          StrongSIVsuccesses.$preInc();
          return true;
        }
      }
    }
    
    // Can we compute distance?
    if (isa_SCEVConstant(Delta) && isa_SCEVConstant(Coeff)) {
      APInt ConstDelta = new APInt(cast_SCEVConstant(Delta).getAPInt());
      APInt ConstCoeff = new APInt(cast_SCEVConstant(Coeff).getAPInt());
      APInt Distance = new APInt(ConstDelta); // these need to be initialized
      APInt Remainder = new APInt(ConstDelta);
      APInt.sdivrem(ConstDelta, ConstCoeff, Distance, Remainder);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    Distance = "), Distance).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    Remainder = "), Remainder).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      // Make sure Coeff divides Delta exactly
      if (Remainder.$noteq($int2ulong(0))) {
        // Coeff doesn't divide Distance, no dependence
        StrongSIVindependence.$preInc();
        StrongSIVsuccesses.$preInc();
        return true;
      }
      Result.DV.$at(Level).Distance = SE.getConstant(Distance);
      NewConstraint.setDistance(SE.getConstant(Distance), CurLoop);
      if (Distance.sgt(0)) {
        Result.DV.$at(Level).Direction &= Unsigned.$int2uchar_3bits(Dependence.DVEntry.Unnamed_enum.LT.getValue());
      } else if (Distance.slt(0)) {
        Result.DV.$at(Level).Direction &= Unsigned.$int2uchar_3bits(Dependence.DVEntry.Unnamed_enum.GT.getValue());
      } else {
        Result.DV.$at(Level).Direction &= Unsigned.$int2uchar_3bits(Dependence.DVEntry.Unnamed_enum.EQ.getValue());
      }
      StrongSIVsuccesses.$preInc();
    } else if (Delta.isZero()) {
      // since 0/X == 0
      Result.DV.$at(Level).Distance = Delta;
      NewConstraint.setDistance(Delta, CurLoop);
      Result.DV.$at(Level).Direction &= Unsigned.$int2uchar_3bits(Dependence.DVEntry.Unnamed_enum.EQ.getValue());
      StrongSIVsuccesses.$preInc();
    } else {
      if (Coeff.isOne()) {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    Distance = "), $Deref(Delta)).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        Result.DV.$at(Level).Distance = Delta; // since X/1 == X
        NewConstraint.setDistance(Delta, CurLoop);
      } else {
        Result.Consistent = false;
        NewConstraint.setLine(Coeff, 
            SE.getNegativeSCEV(Coeff), 
            SE.getNegativeSCEV(Delta), CurLoop);
      }
      
      // maybe we can get a useful direction
      boolean DeltaMaybeZero = !SE.isKnownNonZero(Delta);
      boolean DeltaMaybePositive = !SE.isKnownNonPositive(Delta);
      boolean DeltaMaybeNegative = !SE.isKnownNonNegative(Delta);
      boolean CoeffMaybePositive = !SE.isKnownNonPositive(Coeff);
      boolean CoeffMaybeNegative = !SE.isKnownNonNegative(Coeff);
      // The double negatives above are confusing.
      // It helps to read !SE->isKnownNonZero(Delta)
      // as "Delta might be Zero"
      /*uint*/int NewDirection = Dependence.DVEntry.Unnamed_enum.NONE.getValue();
      if ((DeltaMaybePositive && CoeffMaybePositive)
         || (DeltaMaybeNegative && CoeffMaybeNegative)) {
        NewDirection = Dependence.DVEntry.Unnamed_enum.LT.getValue();
      }
      if (DeltaMaybeZero) {
        NewDirection |= Dependence.DVEntry.Unnamed_enum.EQ.getValue();
      }
      if ((DeltaMaybeNegative && CoeffMaybePositive)
         || (DeltaMaybePositive && CoeffMaybeNegative)) {
        NewDirection |= Dependence.DVEntry.Unnamed_enum.GT.getValue();
      }
      if ($less_uint_uchar(NewDirection, Unsigned.$3bits_uchar2uchar(Result.DV.$at(Level).Direction))) {
        StrongSIVsuccesses.$preInc();
      }
      Result.DV.$at(Level).Direction &= Unsigned.$uint2uchar_3bits(NewDirection);
    }
    return false;
  }

  
  /// weakCrossingSIVtest - Tests the weak-crossing SIV subscript pair
  /// (Src and Dst) for dependence.
  /// Things of the form [c1 + a*i] and [c2 - a*i],
  /// where i is an induction variable, c1 and c2 are loop invariant,
  /// and a is a constant.
  /// Returns true if any possible dependence is disproved.
  /// If there might be a dependence, returns false.
  /// Sets appropriate direction entry.
  /// Set consistent to false.
  /// Marks the dependence as splitable.
  
  // weakCrossingSIVtest -
  // From the paper, Practical Dependence Testing, Section 4.2.2
  //
  // When we have a pair of subscripts of the form [c1 + a*i] and [c2 - a*i],
  // where i is an induction variable, c1 and c2 are loop invariant,
  // and a is a constant, we can solve it exactly using the
  // Weak-Crossing SIV test.
  //
  // Given c1 + a*i = c2 - a*i', we can look for the intersection of
  // the two lines, where i = i', yielding
  //
  //    c1 + a*i = c2 - a*i
  //    2a*i = c2 - c1
  //    i = (c2 - c1)/2a
  //
  // If i < 0, there is no dependence.
  // If i > upperbound, there is no dependence.
  // If i = 0 (i.e., if c1 = c2), there's a dependence with distance = 0.
  // If i = upperbound, there's a dependence with distance = 0.
  // If i is integral, there's a dependence (all directions).
  // If the non-integer part = 1/2, there's a dependence (<> directions).
  // Otherwise, there's no dependence.
  //
  // Can prove independence. Failing that,
  // can sometimes refine the directions.
  // Can determine iteration for splitting.
  //
  // Return true if dependence disproved.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::weakCrossingSIVtest">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1202,
   FQN="llvm::DependenceInfo::weakCrossingSIVtest", NM="_ZNK4llvm14DependenceInfo19weakCrossingSIVtestEPKNS_4SCEVES3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintERS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo19weakCrossingSIVtestEPKNS_4SCEVES3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintERS3_")
  //</editor-fold>
  private boolean weakCrossingSIVtest(/*const*/ SCEV /*P*/ Coeff, /*const*/ SCEV /*P*/ SrcConst, /*const*/ SCEV /*P*/ DstConst, 
                     /*const*/ Loop /*P*/ CurLoop, /*uint*/int Level, final FullDependence /*&*/ Result, 
                     final Constraint /*&*/ NewConstraint, final type$ref</*const*/ SCEV /*P*/ /*&*/> SplitIter) /*const*/ {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"\tWeak-Crossing SIV test\n");
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    Coeff = "), $Deref(Coeff)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    SrcConst = "), $Deref(SrcConst)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    DstConst = "), $Deref(DstConst)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    WeakCrossingSIVapplications.$preInc();
    assert ($less_uint(0, Level) && $lesseq_uint(Level, CommonLevels)) : "Level out of range";
    Level--;
    Result.Consistent = false;
    /*const*/ SCEV /*P*/ Delta = SE.getMinusSCEV(DstConst, SrcConst);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    Delta = "), $Deref(Delta)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    NewConstraint.setLine(Coeff, Coeff, Delta, CurLoop);
    if (Delta.isZero()) {
      Result.DV.$at(Level).Direction &= Unsigned.$uint2uchar_3bits(((/*uint*/int)(~Dependence.DVEntry.Unnamed_enum.LT.getValue())));
      Result.DV.$at(Level).Direction &= Unsigned.$uint2uchar_3bits(((/*uint*/int)(~Dependence.DVEntry.Unnamed_enum.GT.getValue())));
      WeakCrossingSIVsuccesses.$preInc();
      if (!(Unsigned.$3bits_uchar2uchar(Result.DV.$at(Level).Direction) != 0)) {
        WeakCrossingSIVindependence.$preInc();
        return true;
      }
      Result.DV.$at(Level).Distance = Delta; // = 0
      return false;
    }
    /*const*/ SCEVConstant /*P*/ ConstCoeff = dyn_cast_SCEVConstant(Coeff);
    if (!(ConstCoeff != null)) {
      return false;
    }
    
    Result.DV.$at(Level).Splitable = true;
    if (SE.isKnownNegative(ConstCoeff)) {
      ConstCoeff = dyn_cast_SCEVConstant(SE.getNegativeSCEV(ConstCoeff));
      assert ((ConstCoeff != null)) : "dynamic cast of negative of ConstCoeff should yield constant";
      Delta = SE.getNegativeSCEV(Delta);
    }
    assert (SE.isKnownPositive(ConstCoeff)) : "ConstCoeff should be positive";
    
    // compute SplitIter for use by DependenceInfo::getSplitIteration()
    SplitIter.$set(SE.getUDivExpr(SE.getSMaxExpr(SE.getZero(Delta.getType()), Delta), 
        SE.getMulExpr(SE.getConstant(Delta.getType(), $int2ulong(2)), ConstCoeff)));
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    Split iter = "), $Deref(SplitIter.$deref())).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    
    /*const*/ SCEVConstant /*P*/ ConstDelta = dyn_cast_SCEVConstant(Delta);
    if (!(ConstDelta != null)) {
      return false;
    }
    
    // We're certain that ConstCoeff > 0; therefore,
    // if Delta < 0, then no dependence.
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    Delta = "), $Deref(Delta)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    ConstCoeff = "), $Deref(ConstCoeff)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    if (SE.isKnownNegative(Delta)) {
      // No dependence, Delta < 0
      WeakCrossingSIVindependence.$preInc();
      WeakCrossingSIVsuccesses.$preInc();
      return true;
    }
    {
      
      // We're certain that Delta > 0 and ConstCoeff > 0.
      // Check Delta/(2*ConstCoeff) against upper loop bound
      /*const*/ SCEV /*P*/ UpperBound = collectUpperBound(CurLoop, Delta.getType());
      if ((UpperBound != null)) {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    UpperBound = "), $Deref(UpperBound)).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        /*const*/ SCEV /*P*/ ConstantTwo = SE.getConstant(UpperBound.getType(), $int2ulong(2));
        /*const*/ SCEV /*P*/ ML = SE.getMulExpr(SE.getMulExpr(ConstCoeff, UpperBound), 
            ConstantTwo);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    ML = "), $Deref(ML)).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        if (isKnownPredicate(CmpInst.Predicate.ICMP_SGT, Delta, ML)) {
          // Delta too big, no dependence
          WeakCrossingSIVindependence.$preInc();
          WeakCrossingSIVsuccesses.$preInc();
          return true;
        }
        if (isKnownPredicate(CmpInst.Predicate.ICMP_EQ, Delta, ML)) {
          // i = i' = UB
          Result.DV.$at(Level).Direction &= Unsigned.$uint2uchar_3bits(((/*uint*/int)(~Dependence.DVEntry.Unnamed_enum.LT.getValue())));
          Result.DV.$at(Level).Direction &= Unsigned.$uint2uchar_3bits(((/*uint*/int)(~Dependence.DVEntry.Unnamed_enum.GT.getValue())));
          WeakCrossingSIVsuccesses.$preInc();
          if (!(Unsigned.$3bits_uchar2uchar(Result.DV.$at(Level).Direction) != 0)) {
            WeakCrossingSIVindependence.$preInc();
            return true;
          }
          Result.DV.$at(Level).Splitable = false;
          Result.DV.$at(Level).Distance = SE.getZero(Delta.getType());
          return false;
        }
      }
    }
    
    // check that Coeff divides Delta
    APInt APDelta = new APInt(ConstDelta.getAPInt());
    APInt APCoeff = new APInt(ConstCoeff.getAPInt());
    APInt Distance = new APInt(APDelta); // these need to be initialzed
    APInt Remainder = new APInt(APDelta);
    APInt.sdivrem(APDelta, APCoeff, Distance, Remainder);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    Remainder = "), Remainder).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    if (Remainder.$noteq($int2ulong(0))) {
      // Coeff doesn't divide Delta, no dependence
      WeakCrossingSIVindependence.$preInc();
      WeakCrossingSIVsuccesses.$preInc();
      return true;
    }
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    Distance = "), Distance).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    
    // if 2*Coeff doesn't divide Delta, then the equal direction isn't possible
    APInt Two = new APInt(JD$UInt_ULong.INSTANCE, Distance.getBitWidth(), $int2ulong(2), true);
    Remainder.$assignMove(Distance.srem(Two));
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    Remainder = "), Remainder).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    if (Remainder.$noteq($int2ulong(0))) {
      // Equal direction isn't possible
      Result.DV.$at(Level).Direction &= $uint2uchar_3bits(((/*uint*/int)(~Dependence.DVEntry.Unnamed_enum.EQ.getValue())));
      WeakCrossingSIVsuccesses.$preInc();
    }
    return false;
  }

  
  /// ExactSIVtest - Tests the SIV subscript pair
  /// (Src and Dst) for dependence.
  /// Things of the form [c1 + a1*i] and [c2 + a2*i],
  /// where i is an induction variable, c1 and c2 are loop invariant,
  /// and a1 and a2 are constant.
  /// Returns true if any possible dependence is disproved.
  /// If there might be a dependence, returns false.
  /// Sets appropriate direction entry.
  /// Set consistent to false.
  
  // exactSIVtest -
  // When we have a pair of subscripts of the form [c1 + a1*i] and [c2 + a2*i],
  // where i is an induction variable, c1 and c2 are loop invariant, and a1
  // and a2 are constant, we can solve it exactly using an algorithm developed
  // by Banerjee and Wolfe. See Section 2.5.3 in
  //
  //        Optimizing Supercompilers for Supercomputers
  //        Michael Wolfe
  //        MIT Press, 1989
  //
  // It's slower than the specialized tests (strong SIV, weak-zero SIV, etc),
  // so use them if possible. They're also a bit better with symbolics and,
  // in the case of the strong SIV test, can compute Distances.
  //
  // Return true if dependence disproved.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::exactSIVtest">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1413,
   FQN="llvm::DependenceInfo::exactSIVtest", NM="_ZNK4llvm14DependenceInfo12exactSIVtestEPKNS_4SCEVES3_S3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo12exactSIVtestEPKNS_4SCEVES3_S3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintE")
  //</editor-fold>
  private boolean exactSIVtest(/*const*/ SCEV /*P*/ SrcCoeff, /*const*/ SCEV /*P*/ DstCoeff, 
              /*const*/ SCEV /*P*/ SrcConst, /*const*/ SCEV /*P*/ DstConst, 
              /*const*/ Loop /*P*/ CurLoop, /*uint*/int Level, 
              final FullDependence /*&*/ Result, 
              final Constraint /*&*/ NewConstraint) /*const*/ {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"\tExact SIV test\n");
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    SrcCoeff = "), $Deref(SrcCoeff)).$out(/*KEEP_STR*/" = AM\n");
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    DstCoeff = "), $Deref(DstCoeff)).$out(/*KEEP_STR*/" = BM\n");
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    SrcConst = "), $Deref(SrcConst)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    DstConst = "), $Deref(DstConst)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    ExactSIVapplications.$preInc();
    assert ($less_uint(0, Level) && $lesseq_uint(Level, CommonLevels)) : "Level out of range";
    Level--;
    Result.Consistent = false;
    /*const*/ SCEV /*P*/ Delta = SE.getMinusSCEV(DstConst, SrcConst);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    Delta = "), $Deref(Delta)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    NewConstraint.setLine(SrcCoeff, SE.getNegativeSCEV(DstCoeff), 
        Delta, CurLoop);
    /*const*/ SCEVConstant /*P*/ ConstDelta = dyn_cast_SCEVConstant(Delta);
    /*const*/ SCEVConstant /*P*/ ConstSrcCoeff = dyn_cast_SCEVConstant(SrcCoeff);
    /*const*/ SCEVConstant /*P*/ ConstDstCoeff = dyn_cast_SCEVConstant(DstCoeff);
    if (!(ConstDelta != null) || !(ConstSrcCoeff != null) || !(ConstDstCoeff != null)) {
      return false;
    }
    
    // find gcd
    APInt G/*J*/= new APInt();
    APInt X/*J*/= new APInt();
    APInt Y/*J*/= new APInt();
    APInt AM = new APInt(ConstSrcCoeff.getAPInt());
    APInt BM = new APInt(ConstDstCoeff.getAPInt());
    /*uint*/int Bits = AM.getBitWidth();
    if (findGCD(Bits, AM, BM, ConstDelta.getAPInt(), G, X, Y)) {
      // gcd doesn't divide Delta, no dependence
      ExactSIVindependence.$preInc();
      ExactSIVsuccesses.$preInc();
      return true;
    }
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    X = "), X).$out(/*KEEP_STR*/", Y = "), Y).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    
    // since SCEV construction normalizes, LM = 0
    APInt UM/*J*/= new APInt(JD$UInt_ULong.INSTANCE, Bits, $int2ulong(1), true);
    boolean UMvalid = false;
    {
      // UM is perhaps unavailable, let's check
      /*const*/ SCEVConstant /*P*/ CUB = collectConstantUpperBound(CurLoop, Delta.getType());
      if ((CUB != null)) {
        UM.$assign(CUB.getAPInt());
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    UM = "), UM).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        UMvalid = true;
      }
    }
    
    APInt TU/*J*/= APInt.getSignedMaxValue(Bits);
    APInt TL/*J*/= APInt.getSignedMinValue(Bits);
    
    // test(BM/G, LM-X) and test(-BM/G, X-UM)
    APInt TMUL = BM.sdiv(G);
    if (TMUL.sgt(0)) {
      TL.$assignMove(maxAPInt(new APInt(TL), ceilingOfQuotient(X.$sub(), TMUL)));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    TL = "), TL).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      if (UMvalid) {
        TU.$assignMove(minAPInt(new APInt(TU), floorOfQuotient(UM.$sub(X), TMUL)));
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    TU = "), TU).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
      }
    } else {
      TU.$assignMove(minAPInt(new APInt(TU), floorOfQuotient(X.$sub(), TMUL)));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    TU = "), TU).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      if (UMvalid) {
        TL.$assignMove(maxAPInt(new APInt(TL), ceilingOfQuotient(UM.$sub(X), TMUL)));
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    TL = "), TL).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
      }
    }
    
    // test(AM/G, LM-Y) and test(-AM/G, Y-UM)
    TMUL.$assignMove(AM.sdiv(G));
    if (TMUL.sgt(0)) {
      TL.$assignMove(maxAPInt(new APInt(TL), ceilingOfQuotient(Y.$sub(), TMUL)));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    TL = "), TL).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      if (UMvalid) {
        TU.$assignMove(minAPInt(new APInt(TU), floorOfQuotient(UM.$sub(Y), TMUL)));
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    TU = "), TU).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
      }
    } else {
      TU.$assignMove(minAPInt(new APInt(TU), floorOfQuotient(Y.$sub(), TMUL)));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    TU = "), TU).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      if (UMvalid) {
        TL.$assignMove(maxAPInt(new APInt(TL), ceilingOfQuotient(UM.$sub(Y), TMUL)));
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    TL = "), TL).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
      }
    }
    if (TL.sgt(TU)) {
      ExactSIVindependence.$preInc();
      ExactSIVsuccesses.$preInc();
      return true;
    }
    
    // explore directions
    /*uint*/int NewDirection = Dependence.DVEntry.Unnamed_enum.NONE.getValue();
    
    // less than
    APInt SaveTU/*J*/= new APInt(TU); // save these
    APInt SaveTL/*J*/= new APInt(TL);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"\t    exploring LT direction\n");
      }
    } while (false);
    TMUL.$assignMove(AM.$sub(BM));
    if (TMUL.sgt(0)) {
      TL.$assignMove(maxAPInt(new APInt(TL), ceilingOfQuotient(X.$sub(Y).$add($int2ulong(1)), TMUL)));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t\t    TL = "), TL).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
    } else {
      TU.$assignMove(minAPInt(new APInt(TU), floorOfQuotient(X.$sub(Y).$add($int2ulong(1)), TMUL)));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t\t    TU = "), TU).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
    }
    if (TL.sle(TU)) {
      NewDirection |= Dependence.DVEntry.Unnamed_enum.LT.getValue();
      ExactSIVsuccesses.$preInc();
    }
    
    // equal
    TU.$assign(SaveTU); // restore
    TL.$assign(SaveTL);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"\t    exploring EQ direction\n");
      }
    } while (false);
    if (TMUL.sgt(0)) {
      TL.$assignMove(maxAPInt(new APInt(TL), ceilingOfQuotient(X.$sub(Y), TMUL)));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t\t    TL = "), TL).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
    } else {
      TU.$assignMove(minAPInt(new APInt(TU), floorOfQuotient(X.$sub(Y), TMUL)));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t\t    TU = "), TU).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
    }
    TMUL.$assignMove(BM.$sub(AM));
    if (TMUL.sgt(0)) {
      TL.$assignMove(maxAPInt(new APInt(TL), ceilingOfQuotient(Y.$sub(X), TMUL)));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t\t    TL = "), TL).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
    } else {
      TU.$assignMove(minAPInt(new APInt(TU), floorOfQuotient(Y.$sub(X), TMUL)));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t\t    TU = "), TU).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
    }
    if (TL.sle(TU)) {
      NewDirection |= Dependence.DVEntry.Unnamed_enum.EQ.getValue();
      ExactSIVsuccesses.$preInc();
    }
    
    // greater than
    TU.$assign(SaveTU); // restore
    TL.$assign(SaveTL);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"\t    exploring GT direction\n");
      }
    } while (false);
    if (TMUL.sgt(0)) {
      TL.$assignMove(maxAPInt(new APInt(TL), ceilingOfQuotient(Y.$sub(X).$add($int2ulong(1)), TMUL)));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t\t    TL = "), TL).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
    } else {
      TU.$assignMove(minAPInt(new APInt(TU), floorOfQuotient(Y.$sub(X).$add($int2ulong(1)), TMUL)));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t\t    TU = "), TU).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
    }
    if (TL.sle(TU)) {
      NewDirection |= Dependence.DVEntry.Unnamed_enum.GT.getValue();
      ExactSIVsuccesses.$preInc();
    }
    
    // finished
    Result.DV.$at(Level).Direction &= $uint2uchar_3bits(NewDirection);
    if ($uchar2int(Unsigned.$3bits_uchar2uchar(Result.DV.$at(Level).Direction)) == Dependence.DVEntry.Unnamed_enum.NONE.getValue()) {
      ExactSIVindependence.$preInc();
    }
    return $uchar2int(Unsigned.$3bits_uchar2uchar(Result.DV.$at(Level).Direction)) == Dependence.DVEntry.Unnamed_enum.NONE.getValue();
  }

  
  /// weakZeroSrcSIVtest - Tests the weak-zero SIV subscript pair
  /// (Src and Dst) for dependence.
  /// Things of the form [c1] and [c2 + a*i],
  /// where i is an induction variable, c1 and c2 are loop invariant,
  /// and a is a constant. See also weakZeroDstSIVtest.
  /// Returns true if any possible dependence is disproved.
  /// If there might be a dependence, returns false.
  /// Sets appropriate direction entry.
  /// Set consistent to false.
  /// If loop peeling will break the dependence, mark appropriately.
  
  // weakZeroSrcSIVtest -
  // From the paper, Practical Dependence Testing, Section 4.2.2
  //
  // When we have a pair of subscripts of the form [c1] and [c2 + a*i],
  // where i is an induction variable, c1 and c2 are loop invariant,
  // and a is a constant, we can solve it exactly using the
  // Weak-Zero SIV test.
  //
  // Given
  //
  //    c1 = c2 + a*i
  //
  // we get
  //
  //    (c1 - c2)/a = i
  //
  // If i is not an integer, there's no dependence.
  // If i < 0 or > UB, there's no dependence.
  // If i = 0, the direction is <= and peeling the
  // 1st iteration will break the dependence.
  // If i = UB, the direction is >= and peeling the
  // last iteration will break the dependence.
  // Otherwise, the direction is *.
  //
  // Can prove independence. Failing that, we can sometimes refine
  // the directions. Can sometimes show that first or last
  // iteration carries all the dependences (so worth peeling).
  //
  // (see also weakZeroDstSIVtest)
  //
  // Return true if dependence disproved.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::weakZeroSrcSIVtest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1622,
   FQN="llvm::DependenceInfo::weakZeroSrcSIVtest", NM="_ZNK4llvm14DependenceInfo18weakZeroSrcSIVtestEPKNS_4SCEVES3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo18weakZeroSrcSIVtestEPKNS_4SCEVES3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintE")
  //</editor-fold>
  private boolean weakZeroSrcSIVtest(/*const*/ SCEV /*P*/ DstCoeff, 
                    /*const*/ SCEV /*P*/ SrcConst, 
                    /*const*/ SCEV /*P*/ DstConst, 
                    /*const*/ Loop /*P*/ CurLoop, /*uint*/int Level, 
                    final FullDependence /*&*/ Result, 
                    final Constraint /*&*/ NewConstraint) /*const*/ {
    // For the WeakSIV test, it's possible the loop isn't common to
    // the Src and Dst loops. If it isn't, then there's no need to
    // record a direction.
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"\tWeak-Zero (src) SIV test\n");
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    DstCoeff = "), $Deref(DstCoeff)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    SrcConst = "), $Deref(SrcConst)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    DstConst = "), $Deref(DstConst)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    WeakZeroSIVapplications.$preInc();
    assert ($less_uint(0, Level) && $lesseq_uint(Level, MaxLevels)) : "Level out of range";
    Level--;
    Result.Consistent = false;
    /*const*/ SCEV /*P*/ Delta = SE.getMinusSCEV(SrcConst, DstConst);
    NewConstraint.setLine(SE.getZero(Delta.getType()), DstCoeff, Delta, 
        CurLoop);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    Delta = "), $Deref(Delta)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    if (isKnownPredicate(CmpInst.Predicate.ICMP_EQ, SrcConst, DstConst)) {
      if ($less_uint(Level, CommonLevels)) {
        Result.DV.$at(Level).Direction &= $int2uchar_3bits(Dependence.DVEntry.Unnamed_enum.LE.getValue());
        Result.DV.$at(Level).PeelFirst = true;
        WeakZeroSIVsuccesses.$preInc();
      }
      return false; // dependences caused by first iteration
    }
    /*const*/ SCEVConstant /*P*/ ConstCoeff = dyn_cast_SCEVConstant(DstCoeff);
    if (!(ConstCoeff != null)) {
      return false;
    }
    /*const*/ SCEV /*P*/ AbsCoeff = SE.isKnownNegative(ConstCoeff) ? SE.getNegativeSCEV(ConstCoeff) : ConstCoeff;
    /*const*/ SCEV /*P*/ NewDelta = SE.isKnownNegative(ConstCoeff) ? SE.getNegativeSCEV(Delta) : Delta;
    {
      
      // check that Delta/SrcCoeff < iteration count
      // really check NewDelta < count*AbsCoeff
      /*const*/ SCEV /*P*/ UpperBound = collectUpperBound(CurLoop, Delta.getType());
      if ((UpperBound != null)) {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    UpperBound = "), $Deref(UpperBound)).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        /*const*/ SCEV /*P*/ Product = SE.getMulExpr(AbsCoeff, UpperBound);
        if (isKnownPredicate(CmpInst.Predicate.ICMP_SGT, NewDelta, Product)) {
          WeakZeroSIVindependence.$preInc();
          WeakZeroSIVsuccesses.$preInc();
          return true;
        }
        if (isKnownPredicate(CmpInst.Predicate.ICMP_EQ, NewDelta, Product)) {
          // dependences caused by last iteration
          if ($less_uint(Level, CommonLevels)) {
            Result.DV.$at(Level).Direction &= $int2uchar_3bits(Dependence.DVEntry.Unnamed_enum.GE.getValue());
            Result.DV.$at(Level).PeelLast = true;
            WeakZeroSIVsuccesses.$preInc();
          }
          return false;
        }
      }
    }
    
    // check that Delta/SrcCoeff >= 0
    // really check that NewDelta >= 0
    if (SE.isKnownNegative(NewDelta)) {
      // No dependence, newDelta < 0
      WeakZeroSIVindependence.$preInc();
      WeakZeroSIVsuccesses.$preInc();
      return true;
    }
    
    // if SrcCoeff doesn't divide Delta, then no dependence
    if (isa_SCEVConstant(Delta)
       && !isRemainderZero(cast_SCEVConstant(Delta), ConstCoeff)) {
      WeakZeroSIVindependence.$preInc();
      WeakZeroSIVsuccesses.$preInc();
      return true;
    }
    return false;
  }

  
  /// weakZeroDstSIVtest - Tests the weak-zero SIV subscript pair
  /// (Src and Dst) for dependence.
  /// Things of the form [c1 + a*i] and [c2],
  /// where i is an induction variable, c1 and c2 are loop invariant,
  /// and a is a constant. See also weakZeroSrcSIVtest.
  /// Returns true if any possible dependence is disproved.
  /// If there might be a dependence, returns false.
  /// Sets appropriate direction entry.
  /// Set consistent to false.
  /// If loop peeling will break the dependence, mark appropriately.
  
  // weakZeroDstSIVtest -
  // From the paper, Practical Dependence Testing, Section 4.2.2
  //
  // When we have a pair of subscripts of the form [c1 + a*i] and [c2],
  // where i is an induction variable, c1 and c2 are loop invariant,
  // and a is a constant, we can solve it exactly using the
  // Weak-Zero SIV test.
  //
  // Given
  //
  //    c1 + a*i = c2
  //
  // we get
  //
  //    i = (c2 - c1)/a
  //
  // If i is not an integer, there's no dependence.
  // If i < 0 or > UB, there's no dependence.
  // If i = 0, the direction is <= and peeling the
  // 1st iteration will break the dependence.
  // If i = UB, the direction is >= and peeling the
  // last iteration will break the dependence.
  // Otherwise, the direction is *.
  //
  // Can prove independence. Failing that, we can sometimes refine
  // the directions. Can sometimes show that first or last
  // iteration carries all the dependences (so worth peeling).
  //
  // (see also weakZeroSrcSIVtest)
  //
  // Return true if dependence disproved.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::weakZeroDstSIVtest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1732,
   FQN="llvm::DependenceInfo::weakZeroDstSIVtest", NM="_ZNK4llvm14DependenceInfo18weakZeroDstSIVtestEPKNS_4SCEVES3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo18weakZeroDstSIVtestEPKNS_4SCEVES3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintE")
  //</editor-fold>
  private boolean weakZeroDstSIVtest(/*const*/ SCEV /*P*/ SrcCoeff, 
                    /*const*/ SCEV /*P*/ SrcConst, 
                    /*const*/ SCEV /*P*/ DstConst, 
                    /*const*/ Loop /*P*/ CurLoop, /*uint*/int Level, 
                    final FullDependence /*&*/ Result, 
                    final Constraint /*&*/ NewConstraint) /*const*/ {
    // For the WeakSIV test, it's possible the loop isn't common to the
    // Src and Dst loops. If it isn't, then there's no need to record a direction.
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"\tWeak-Zero (dst) SIV test\n");
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    SrcCoeff = "), $Deref(SrcCoeff)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    SrcConst = "), $Deref(SrcConst)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    DstConst = "), $Deref(DstConst)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    WeakZeroSIVapplications.$preInc();
    assert ($less_uint(0, Level) && $lesseq_uint(Level, SrcLevels)) : "Level out of range";
    Level--;
    Result.Consistent = false;
    /*const*/ SCEV /*P*/ Delta = SE.getMinusSCEV(DstConst, SrcConst);
    NewConstraint.setLine(SrcCoeff, SE.getZero(Delta.getType()), Delta, 
        CurLoop);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    Delta = "), $Deref(Delta)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    if (isKnownPredicate(CmpInst.Predicate.ICMP_EQ, DstConst, SrcConst)) {
      if ($less_uint(Level, CommonLevels)) {
        Result.DV.$at(Level).Direction &= $int2uchar_3bits(Dependence.DVEntry.Unnamed_enum.LE.getValue());
        Result.DV.$at(Level).PeelFirst = true;
        WeakZeroSIVsuccesses.$preInc();
      }
      return false; // dependences caused by first iteration
    }
    /*const*/ SCEVConstant /*P*/ ConstCoeff = dyn_cast_SCEVConstant(SrcCoeff);
    if (!(ConstCoeff != null)) {
      return false;
    }
    /*const*/ SCEV /*P*/ AbsCoeff = SE.isKnownNegative(ConstCoeff) ? SE.getNegativeSCEV(ConstCoeff) : ConstCoeff;
    /*const*/ SCEV /*P*/ NewDelta = SE.isKnownNegative(ConstCoeff) ? SE.getNegativeSCEV(Delta) : Delta;
    {
      
      // check that Delta/SrcCoeff < iteration count
      // really check NewDelta < count*AbsCoeff
      /*const*/ SCEV /*P*/ UpperBound = collectUpperBound(CurLoop, Delta.getType());
      if ((UpperBound != null)) {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    UpperBound = "), $Deref(UpperBound)).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        /*const*/ SCEV /*P*/ Product = SE.getMulExpr(AbsCoeff, UpperBound);
        if (isKnownPredicate(CmpInst.Predicate.ICMP_SGT, NewDelta, Product)) {
          WeakZeroSIVindependence.$preInc();
          WeakZeroSIVsuccesses.$preInc();
          return true;
        }
        if (isKnownPredicate(CmpInst.Predicate.ICMP_EQ, NewDelta, Product)) {
          // dependences caused by last iteration
          if ($less_uint(Level, CommonLevels)) {
            Result.DV.$at(Level).Direction &= $int2uchar_3bits(Dependence.DVEntry.Unnamed_enum.GE.getValue());
            Result.DV.$at(Level).PeelLast = true;
            WeakZeroSIVsuccesses.$preInc();
          }
          return false;
        }
      }
    }
    
    // check that Delta/SrcCoeff >= 0
    // really check that NewDelta >= 0
    if (SE.isKnownNegative(NewDelta)) {
      // No dependence, newDelta < 0
      WeakZeroSIVindependence.$preInc();
      WeakZeroSIVsuccesses.$preInc();
      return true;
    }
    
    // if SrcCoeff doesn't divide Delta, then no dependence
    if (isa_SCEVConstant(Delta)
       && !isRemainderZero(cast_SCEVConstant(Delta), ConstCoeff)) {
      WeakZeroSIVindependence.$preInc();
      WeakZeroSIVsuccesses.$preInc();
      return true;
    }
    return false;
  }

  
  /// exactRDIVtest - Tests the RDIV subscript pair for dependence.
  /// Things of the form [c1 + a*i] and [c2 + b*j],
  /// where i and j are induction variable, c1 and c2 are loop invariant,
  /// and a and b are constants.
  /// Returns true if any possible dependence is disproved.
  /// Marks the result as inconsistent.
  /// Works in some cases that symbolicRDIVtest doesn't,
  /// and vice versa.
  
  // exactRDIVtest - Tests the RDIV subscript pair for dependence.
  // Things of the form [c1 + a*i] and [c2 + b*j],
  // where i and j are induction variable, c1 and c2 are loop invariant,
  // and a and b are constants.
  // Returns true if any possible dependence is disproved.
  // Marks the result as inconsistent.
  // Works in some cases that symbolicRDIVtest doesn't, and vice versa.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::exactRDIVtest">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1817,
   FQN="llvm::DependenceInfo::exactRDIVtest", NM="_ZNK4llvm14DependenceInfo13exactRDIVtestEPKNS_4SCEVES3_S3_S3_PKNS_4LoopES6_RNS_14FullDependenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo13exactRDIVtestEPKNS_4SCEVES3_S3_S3_PKNS_4LoopES6_RNS_14FullDependenceE")
  //</editor-fold>
  private boolean exactRDIVtest(/*const*/ SCEV /*P*/ SrcCoeff, /*const*/ SCEV /*P*/ DstCoeff, 
               /*const*/ SCEV /*P*/ SrcConst, /*const*/ SCEV /*P*/ DstConst, 
               /*const*/ Loop /*P*/ SrcLoop, /*const*/ Loop /*P*/ DstLoop, 
               final FullDependence /*&*/ Result) /*const*/ {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"\tExact RDIV test\n");
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    SrcCoeff = "), $Deref(SrcCoeff)).$out(/*KEEP_STR*/" = AM\n");
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    DstCoeff = "), $Deref(DstCoeff)).$out(/*KEEP_STR*/" = BM\n");
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    SrcConst = "), $Deref(SrcConst)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    DstConst = "), $Deref(DstConst)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    ExactRDIVapplications.$preInc();
    Result.Consistent = false;
    /*const*/ SCEV /*P*/ Delta = SE.getMinusSCEV(DstConst, SrcConst);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    Delta = "), $Deref(Delta)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    /*const*/ SCEVConstant /*P*/ ConstDelta = dyn_cast_SCEVConstant(Delta);
    /*const*/ SCEVConstant /*P*/ ConstSrcCoeff = dyn_cast_SCEVConstant(SrcCoeff);
    /*const*/ SCEVConstant /*P*/ ConstDstCoeff = dyn_cast_SCEVConstant(DstCoeff);
    if (!(ConstDelta != null) || !(ConstSrcCoeff != null) || !(ConstDstCoeff != null)) {
      return false;
    }
    
    // find gcd
    APInt G/*J*/= new APInt();
    APInt X/*J*/= new APInt();
    APInt Y/*J*/= new APInt();
    APInt AM = new APInt(ConstSrcCoeff.getAPInt());
    APInt BM = new APInt(ConstDstCoeff.getAPInt());
    /*uint*/int Bits = AM.getBitWidth();
    if (findGCD(Bits, AM, BM, ConstDelta.getAPInt(), G, X, Y)) {
      // gcd doesn't divide Delta, no dependence
      ExactRDIVindependence.$preInc();
      return true;
    }
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    X = "), X).$out(/*KEEP_STR*/", Y = "), Y).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    
    // since SCEV construction seems to normalize, LM = 0
    APInt SrcUM/*J*/= new APInt(JD$UInt_ULong.INSTANCE, Bits, $int2ulong(1), true);
    boolean SrcUMvalid = false;
    {
      // SrcUM is perhaps unavailable, let's check
      /*const*/ SCEVConstant /*P*/ UpperBound = collectConstantUpperBound(SrcLoop, Delta.getType());
      if ((UpperBound != null)) {
        SrcUM.$assign(UpperBound.getAPInt());
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    SrcUM = "), SrcUM).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        SrcUMvalid = true;
      }
    }
    
    APInt DstUM/*J*/= new APInt(JD$UInt_ULong.INSTANCE, Bits, $int2ulong(1), true);
    boolean DstUMvalid = false;
    {
      // UM is perhaps unavailable, let's check
      /*const*/ SCEVConstant /*P*/ UpperBound = collectConstantUpperBound(DstLoop, Delta.getType());
      if ((UpperBound != null)) {
        DstUM.$assign(UpperBound.getAPInt());
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    DstUM = "), DstUM).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        DstUMvalid = true;
      }
    }
    
    APInt TU/*J*/= APInt.getSignedMaxValue(Bits);
    APInt TL/*J*/= APInt.getSignedMinValue(Bits);
    
    // test(BM/G, LM-X) and test(-BM/G, X-UM)
    APInt TMUL = BM.sdiv(G);
    if (TMUL.sgt(0)) {
      TL.$assignMove(maxAPInt(new APInt(TL), ceilingOfQuotient(X.$sub(), TMUL)));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    TL = "), TL).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      if (SrcUMvalid) {
        TU.$assignMove(minAPInt(new APInt(TU), floorOfQuotient(SrcUM.$sub(X), TMUL)));
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    TU = "), TU).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
      }
    } else {
      TU.$assignMove(minAPInt(new APInt(TU), floorOfQuotient(X.$sub(), TMUL)));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    TU = "), TU).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      if (SrcUMvalid) {
        TL.$assignMove(maxAPInt(new APInt(TL), ceilingOfQuotient(SrcUM.$sub(X), TMUL)));
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    TL = "), TL).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
      }
    }
    
    // test(AM/G, LM-Y) and test(-AM/G, Y-UM)
    TMUL.$assignMove(AM.sdiv(G));
    if (TMUL.sgt(0)) {
      TL.$assignMove(maxAPInt(new APInt(TL), ceilingOfQuotient(Y.$sub(), TMUL)));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    TL = "), TL).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      if (DstUMvalid) {
        TU.$assignMove(minAPInt(new APInt(TU), floorOfQuotient(DstUM.$sub(Y), TMUL)));
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    TU = "), TU).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
      }
    } else {
      TU.$assignMove(minAPInt(new APInt(TU), floorOfQuotient(Y.$sub(), TMUL)));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    TU = "), TU).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      if (DstUMvalid) {
        TL.$assignMove(maxAPInt(new APInt(TL), ceilingOfQuotient(DstUM.$sub(Y), TMUL)));
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t    TL = "), TL).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
      }
    }
    if (TL.sgt(TU)) {
      ExactRDIVindependence.$preInc();
    }
    return TL.sgt(TU);
  }

  
  /// symbolicRDIVtest - Tests the RDIV subscript pair for dependence.
  /// Things of the form [c1 + a*i] and [c2 + b*j],
  /// where i and j are induction variable, c1 and c2 are loop invariant,
  /// and a and b are constants.
  /// Returns true if any possible dependence is disproved.
  /// Marks the result as inconsistent.
  /// Works in some cases that exactRDIVtest doesn't,
  /// and vice versa. Can also be used as a backup for
  /// ordinary SIV tests.
  
  // symbolicRDIVtest -
  // In Section 4.5 of the Practical Dependence Testing paper,the authors
  // introduce a special case of Banerjee's Inequalities (also called the
  // Extreme-Value Test) that can handle some of the SIV and RDIV cases,
  // particularly cases with symbolics. Since it's only able to disprove
  // dependence (not compute distances or directions), we'll use it as a
  // fall back for the other tests.
  //
  // When we have a pair of subscripts of the form [c1 + a1*i] and [c2 + a2*j]
  // where i and j are induction variables and c1 and c2 are loop invariants,
  // we can use the symbolic tests to disprove some dependences, serving as a
  // backup for the RDIV test. Note that i and j can be the same variable,
  // letting this test serve as a backup for the various SIV tests.
  //
  // For a dependence to exist, c1 + a1*i must equal c2 + a2*j for some
  //  0 <= i <= N1 and some 0 <= j <= N2, where N1 and N2 are the (normalized)
  // loop bounds for the i and j loops, respectively. So, ...
  //
  // c1 + a1*i = c2 + a2*j
  // a1*i - a2*j = c2 - c1
  //
  // To test for a dependence, we compute c2 - c1 and make sure it's in the
  // range of the maximum and minimum possible values of a1*i - a2*j.
  // Considering the signs of a1 and a2, we have 4 possible cases:
  //
  // 1) If a1 >= 0 and a2 >= 0, then
  //        a1*0 - a2*N2 <= c2 - c1 <= a1*N1 - a2*0
  //              -a2*N2 <= c2 - c1 <= a1*N1
  //
  // 2) If a1 >= 0 and a2 <= 0, then
  //        a1*0 - a2*0 <= c2 - c1 <= a1*N1 - a2*N2
  //                  0 <= c2 - c1 <= a1*N1 - a2*N2
  //
  // 3) If a1 <= 0 and a2 >= 0, then
  //        a1*N1 - a2*N2 <= c2 - c1 <= a1*0 - a2*0
  //        a1*N1 - a2*N2 <= c2 - c1 <= 0
  //
  // 4) If a1 <= 0 and a2 <= 0, then
  //        a1*N1 - a2*0  <= c2 - c1 <= a1*0 - a2*N2
  //        a1*N1         <= c2 - c1 <=       -a2*N2
  //
  // return true if dependence disproved
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::symbolicRDIVtest">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1958,
   FQN="llvm::DependenceInfo::symbolicRDIVtest", NM="_ZNK4llvm14DependenceInfo16symbolicRDIVtestEPKNS_4SCEVES3_S3_S3_PKNS_4LoopES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo16symbolicRDIVtestEPKNS_4SCEVES3_S3_S3_PKNS_4LoopES6_")
  //</editor-fold>
  private boolean symbolicRDIVtest(/*const*/ SCEV /*P*/ A1, /*const*/ SCEV /*P*/ A2, 
                  /*const*/ SCEV /*P*/ C1, /*const*/ SCEV /*P*/ C2, 
                  /*const*/ Loop /*P*/ Loop1, 
                  /*const*/ Loop /*P*/ Loop2) /*const*/ {
    SymbolicRDIVapplications.$preInc();
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"\ttry symbolic RDIV test\n");
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    A1 = "), $Deref(A1));
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        IrLlvmGlobals.$out_raw_ostream_Type(dbgs().$out(/*KEEP_STR*/", type = "), $Deref(A1.getType())).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    A2 = "), $Deref(A2)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    C1 = "), $Deref(C1)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    C2 = "), $Deref(C2)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    /*const*/ SCEV /*P*/ N1 = collectUpperBound(Loop1, A1.getType());
    /*const*/ SCEV /*P*/ N2 = collectUpperBound(Loop2, A1.getType());
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        if ((N1 != null)) {
          ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    N1 = "), $Deref(N1)).$out(/*KEEP_STR*/$LF);
        }
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        if ((N2 != null)) {
          ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    N2 = "), $Deref(N2)).$out(/*KEEP_STR*/$LF);
        }
      }
    } while (false);
    /*const*/ SCEV /*P*/ C2_C1 = SE.getMinusSCEV(C2, C1);
    /*const*/ SCEV /*P*/ C1_C2 = SE.getMinusSCEV(C1, C2);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    C2 - C1 = "), $Deref(C2_C1)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    C1 - C2 = "), $Deref(C1_C2)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    if (SE.isKnownNonNegative(A1)) {
      if (SE.isKnownNonNegative(A2)) {
        // A1 >= 0 && A2 >= 0
        if ((N1 != null)) {
          // make sure that c2 - c1 <= a1*N1
          /*const*/ SCEV /*P*/ A1N1 = SE.getMulExpr(A1, N1);
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    A1*N1 = "), $Deref(A1N1)).$out(/*KEEP_STR*/$LF);
            }
          } while (false);
          if (isKnownPredicate(CmpInst.Predicate.ICMP_SGT, C2_C1, A1N1)) {
            SymbolicRDIVindependence.$preInc();
            return true;
          }
        }
        if ((N2 != null)) {
          // make sure that -a2*N2 <= c2 - c1, or a2*N2 >= c1 - c2
          /*const*/ SCEV /*P*/ A2N2 = SE.getMulExpr(A2, N2);
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    A2*N2 = "), $Deref(A2N2)).$out(/*KEEP_STR*/$LF);
            }
          } while (false);
          if (isKnownPredicate(CmpInst.Predicate.ICMP_SLT, A2N2, C1_C2)) {
            SymbolicRDIVindependence.$preInc();
            return true;
          }
        }
      } else if (SE.isKnownNonPositive(A2)) {
        // a1 >= 0 && a2 <= 0
        if ((N1 != null) && (N2 != null)) {
          // make sure that c2 - c1 <= a1*N1 - a2*N2
          /*const*/ SCEV /*P*/ A1N1 = SE.getMulExpr(A1, N1);
          /*const*/ SCEV /*P*/ A2N2 = SE.getMulExpr(A2, N2);
          /*const*/ SCEV /*P*/ A1N1_A2N2 = SE.getMinusSCEV(A1N1, A2N2);
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    A1*N1 - A2*N2 = "), $Deref(A1N1_A2N2)).$out(/*KEEP_STR*/$LF);
            }
          } while (false);
          if (isKnownPredicate(CmpInst.Predicate.ICMP_SGT, C2_C1, A1N1_A2N2)) {
            SymbolicRDIVindependence.$preInc();
            return true;
          }
        }
        // make sure that 0 <= c2 - c1
        if (SE.isKnownNegative(C2_C1)) {
          SymbolicRDIVindependence.$preInc();
          return true;
        }
      }
    } else if (SE.isKnownNonPositive(A1)) {
      if (SE.isKnownNonNegative(A2)) {
        // a1 <= 0 && a2 >= 0
        if ((N1 != null) && (N2 != null)) {
          // make sure that a1*N1 - a2*N2 <= c2 - c1
          /*const*/ SCEV /*P*/ A1N1 = SE.getMulExpr(A1, N1);
          /*const*/ SCEV /*P*/ A2N2 = SE.getMulExpr(A2, N2);
          /*const*/ SCEV /*P*/ A1N1_A2N2 = SE.getMinusSCEV(A1N1, A2N2);
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    A1*N1 - A2*N2 = "), $Deref(A1N1_A2N2)).$out(/*KEEP_STR*/$LF);
            }
          } while (false);
          if (isKnownPredicate(CmpInst.Predicate.ICMP_SGT, A1N1_A2N2, C2_C1)) {
            SymbolicRDIVindependence.$preInc();
            return true;
          }
        }
        // make sure that c2 - c1 <= 0
        if (SE.isKnownPositive(C2_C1)) {
          SymbolicRDIVindependence.$preInc();
          return true;
        }
      } else if (SE.isKnownNonPositive(A2)) {
        // a1 <= 0 && a2 <= 0
        if ((N1 != null)) {
          // make sure that a1*N1 <= c2 - c1
          /*const*/ SCEV /*P*/ A1N1 = SE.getMulExpr(A1, N1);
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    A1*N1 = "), $Deref(A1N1)).$out(/*KEEP_STR*/$LF);
            }
          } while (false);
          if (isKnownPredicate(CmpInst.Predicate.ICMP_SGT, A1N1, C2_C1)) {
            SymbolicRDIVindependence.$preInc();
            return true;
          }
        }
        if ((N2 != null)) {
          // make sure that c2 - c1 <= -a2*N2, or c1 - c2 >= a2*N2
          /*const*/ SCEV /*P*/ A2N2 = SE.getMulExpr(A2, N2);
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    A2*N2 = "), $Deref(A2N2)).$out(/*KEEP_STR*/$LF);
            }
          } while (false);
          if (isKnownPredicate(CmpInst.Predicate.ICMP_SLT, C1_C2, A2N2)) {
            SymbolicRDIVindependence.$preInc();
            return true;
          }
        }
      }
    }
    return false;
  }

  
  /// gcdMIVtest - Tests an MIV subscript pair for dependence.
  /// Returns true if any possible dependence is disproved.
  /// Marks the result as inconsistent.
  /// Can sometimes disprove the equal direction for 1 or more loops.
  //  Can handle some symbolics that even the SIV tests don't get,
  /// so we use it as a backup for everything.
  
  //===----------------------------------------------------------------------===//
  // gcdMIVtest -
  // Tests an MIV subscript pair for dependence.
  // Returns true if any possible dependence is disproved.
  // Marks the result as inconsistent.
  // Can sometimes disprove the equal direction for 1 or more loops,
  // as discussed in Michael Wolfe's book,
  // High Performance Compilers for Parallel Computing, page 235.
  //
  // We spend some effort (code!) to handle cases like
  // [10*i + 5*N*j + 15*M + 6], where i and j are induction variables,
  // but M and N are just loop-invariant variables.
  // This should help us handle linearized subscripts;
  // also makes this test a useful backup to the various SIV tests.
  //
  // It occurs to me that the presence of loop-invariant variables
  // changes the nature of the test from "greatest common divisor"
  // to "a common divisor".
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::gcdMIVtest">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2249,
   FQN="llvm::DependenceInfo::gcdMIVtest", NM="_ZNK4llvm14DependenceInfo10gcdMIVtestEPKNS_4SCEVES3_RNS_14FullDependenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10gcdMIVtestEPKNS_4SCEVES3_RNS_14FullDependenceE")
  //</editor-fold>
  private boolean gcdMIVtest(/*const*/ SCEV /*P*/ Src, /*const*/ SCEV /*P*/ Dst, 
            final FullDependence /*&*/ Result) /*const*/ {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"starting gcd\n");
      }
    } while (false);
    GCDapplications.$preInc();
    /*uint*/int BitWidth = $ulong2uint(SE.getTypeSizeInBits(Src.getType()));
    APInt RunningGCD = APInt.getNullValue(BitWidth);
    
    // Examine Src coefficients.
    // Compute running GCD and record source constant.
    // Because we're looking for the constant at the end of the chain,
    // we can't quit the loop just because the GCD == 1.
    /*const*/ SCEV /*P*/ Coefficients = Src;
    {
      /*const*/ SCEVAddRecExpr /*P*/ AddRec;
      while (((/*P*/ AddRec = dyn_cast_SCEVAddRecExpr(Coefficients)) != null)) {
        /*const*/ SCEV /*P*/ Coeff = AddRec.getStepRecurrence($Deref(SE));
        // If the coefficient is the product of a constant and other stuff,
        // we can use the constant in the GCD computation.
        /*const*/ SCEVConstant /*P*/ Constant = getConstantPart(Coeff);
        if (!(Constant != null)) {
          return false;
        }
        APInt ConstCoeff = new APInt(Constant.getAPInt());
        RunningGCD.$assignMove(APIntOps.GreatestCommonDivisor(RunningGCD, ConstCoeff.abs()));
        Coefficients = AddRec.getStart();
      }
    }
    /*const*/ SCEV /*P*/ SrcConst = Coefficients;
    
    // Examine Dst coefficients.
    // Compute running GCD and record destination constant.
    // Because we're looking for the constant at the end of the chain,
    // we can't quit the loop just because the GCD == 1.
    Coefficients = Dst;
    {
      /*const*/ SCEVAddRecExpr /*P*/ AddRec$1;
      while (((/*P*/ AddRec$1 = dyn_cast_SCEVAddRecExpr(Coefficients)) != null)) {
        /*const*/ SCEV /*P*/ Coeff = AddRec$1.getStepRecurrence($Deref(SE));
        // If the coefficient is the product of a constant and other stuff,
        // we can use the constant in the GCD computation.
        /*const*/ SCEVConstant /*P*/ Constant = getConstantPart(Coeff);
        if (!(Constant != null)) {
          return false;
        }
        APInt ConstCoeff = new APInt(Constant.getAPInt());
        RunningGCD.$assignMove(APIntOps.GreatestCommonDivisor(RunningGCD, ConstCoeff.abs()));
        Coefficients = AddRec$1.getStart();
      }
    }
    /*const*/ SCEV /*P*/ DstConst = Coefficients;
    
    APInt ExtraGCD = APInt.getNullValue(BitWidth);
    /*const*/ SCEV /*P*/ Delta = SE.getMinusSCEV(DstConst, SrcConst);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"    Delta = "), $Deref(Delta)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    /*const*/ SCEVConstant /*P*/ Constant = dyn_cast_SCEVConstant(Delta);
    {
      /*const*/ SCEVAddExpr /*P*/ Sum = dyn_cast_SCEVAddExpr(Delta);
      if ((Sum != null)) {
        // If Delta is a sum of products, we may be able to make further progress.
        for (/*uint*/int Op = 0, Ops = Sum.getNumOperands(); $less_uint(Op, Ops); Op++) {
          /*const*/ SCEV /*P*/ Operand = Sum.getOperand(Op);
          if (isa_SCEVConstant(Operand)) {
            assert (!(Constant != null)) : "Surprised to find multiple constants";
            Constant = cast_SCEVConstant(Operand);
          } else {
            /*const*/ SCEVMulExpr /*P*/ Product = dyn_cast_SCEVMulExpr(Operand);
            if ((Product != null)) {
              // Search for constant operand to participate in GCD;
              // If none found; return false.
              /*const*/ SCEVConstant /*P*/ ConstOp = getConstantPart(Product);
              if (!(ConstOp != null)) {
                return false;
              }
              APInt ConstOpValue = new APInt(ConstOp.getAPInt());
              ExtraGCD.$assignMove(APIntOps.GreatestCommonDivisor(ExtraGCD, 
                      ConstOpValue.abs()));
            } else {
              return false;
            }
          }
        }
      }
    }
    if (!(Constant != null)) {
      return false;
    }
    APInt ConstDelta = new APInt(cast_SCEVConstant(Constant).getAPInt());
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"    ConstDelta = "), ConstDelta).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    if (ConstDelta.$eq($int2ulong(0))) {
      return false;
    }
    RunningGCD.$assignMove(APIntOps.GreatestCommonDivisor(RunningGCD, ExtraGCD));
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"    RunningGCD = "), RunningGCD).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    APInt Remainder = ConstDelta.srem(RunningGCD);
    if (Remainder.$noteq($int2ulong(0))) {
      GCDindependence.$preInc();
      return true;
    }
    
    // Try to disprove equal directions.
    // For example, given a subscript pair [3*i + 2*j] and [i' + 2*j' - 1],
    // the code above can't disprove the dependence because the GCD = 1.
    // So we consider what happen if i = i' and what happens if j = j'.
    // If i = i', we can simplify the subscript to [2*i + 2*j] and [2*j' - 1],
    // which is infeasible, so we can disallow the = direction for the i level.
    // Setting j = j' doesn't help matters, so we end up with a direction vector
    // of [<>, *]
    //
    // Given A[5*i + 10*j*M + 9*M*N] and A[15*i + 20*j*M - 21*N*M + 5],
    // we need to remember that the constant part is 5 and the RunningGCD should
    // be initialized to ExtraGCD = 30.
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"    ExtraGCD = "), ExtraGCD).$out_char($$LF);
      }
    } while (false);
    
    boolean Improved = false;
    Coefficients = Src;
    {
      /*const*/ SCEVAddRecExpr /*P*/ AddRec$2;
      while (((/*P*/ AddRec$2 = dyn_cast_SCEVAddRecExpr(Coefficients)) != null)) {
        Coefficients = AddRec$2.getStart();
        /*const*/ Loop /*P*/ CurLoop = AddRec$2.getLoop();
        RunningGCD.$assign(ExtraGCD);
        /*const*/ SCEV /*P*/ SrcCoeff = AddRec$2.getStepRecurrence($Deref(SE));
        /*const*/ SCEV /*P*/ DstCoeff = SE.getMinusSCEV(SrcCoeff, SrcCoeff);
        /*const*/ SCEV /*P*/ Inner = Src;
        while (RunningGCD.$noteq($int2ulong(1)) && isa_SCEVAddRecExpr(Inner)) {
          AddRec$2 = cast_SCEVAddRecExpr(Inner);
          /*const*/ SCEV /*P*/ Coeff = AddRec$2.getStepRecurrence($Deref(SE));
          if (CurLoop == AddRec$2.getLoop()) {
            ; // SrcCoeff == Coeff
          } else {
            // If the coefficient is the product of a constant and other stuff,
            // we can use the constant in the GCD computation.
            Constant = getConstantPart(Coeff);
            if (!(Constant != null)) {
              return false;
            }
            APInt ConstCoeff = new APInt(Constant.getAPInt());
            RunningGCD.$assignMove(APIntOps.GreatestCommonDivisor(RunningGCD, ConstCoeff.abs()));
          }
          Inner = AddRec$2.getStart();
        }
        Inner = Dst;
        while (RunningGCD.$noteq($int2ulong(1)) && isa_SCEVAddRecExpr(Inner)) {
          AddRec$2 = cast_SCEVAddRecExpr(Inner);
          /*const*/ SCEV /*P*/ Coeff = AddRec$2.getStepRecurrence($Deref(SE));
          if (CurLoop == AddRec$2.getLoop()) {
            DstCoeff = Coeff;
          } else {
            // If the coefficient is the product of a constant and other stuff,
            // we can use the constant in the GCD computation.
            Constant = getConstantPart(Coeff);
            if (!(Constant != null)) {
              return false;
            }
            APInt ConstCoeff = new APInt(Constant.getAPInt());
            RunningGCD.$assignMove(APIntOps.GreatestCommonDivisor(RunningGCD, ConstCoeff.abs()));
          }
          Inner = AddRec$2.getStart();
        }
        Delta = SE.getMinusSCEV(SrcCoeff, DstCoeff);
        // If the coefficient is the product of a constant and other stuff,
        // we can use the constant in the GCD computation.
        Constant = getConstantPart(Delta);
        if (!(Constant != null)) {
          // The difference of the two coefficients might not be a product
          // or constant, in which case we give up on this direction.
          continue;
        }
        APInt ConstCoeff = new APInt(Constant.getAPInt());
        RunningGCD.$assignMove(APIntOps.GreatestCommonDivisor(RunningGCD, ConstCoeff.abs()));
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\tRunningGCD = "), RunningGCD).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        if (RunningGCD.$noteq($int2ulong(0))) {
          Remainder.$assignMove(ConstDelta.srem(RunningGCD));
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\tRemainder = "), Remainder).$out(/*KEEP_STR*/$LF);
            }
          } while (false);
          if (Remainder.$noteq($int2ulong(0))) {
            /*uint*/int Level = mapSrcLoop(CurLoop);
            Result.DV.$at(Level - 1).Direction &= $uint2uchar_3bits(((/*uint*/int)(~Dependence.DVEntry.Unnamed_enum.EQ.getValue())));
            Improved = true;
          }
        }
      }
    }
    if (Improved) {
      GCDsuccesses.$preInc();
    }
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"all done\n");
      }
    } while (false);
    return false;
  }

  
  /// banerjeeMIVtest - Tests an MIV subscript pair for dependence.
  /// Returns true if any possible dependence is disproved.
  /// Marks the result as inconsistent.
  /// Computes directions.
  
  //===----------------------------------------------------------------------===//
  // banerjeeMIVtest -
  // Use Banerjee's Inequalities to test an MIV subscript pair.
  // (Wolfe, in the race-car book, calls this the Extreme Value Test.)
  // Generally follows the discussion in Section 2.5.2 of
  //
  //    Optimizing Supercompilers for Supercomputers
  //    Michael Wolfe
  //
  // The inequalities given on page 25 are simplified in that loops are
  // normalized so that the lower bound is always 0 and the stride is always 1.
  // For example, Wolfe gives
  //
  //     LB^<_k = (A^-_k - B_k)^- (U_k - L_k - N_k) + (A_k - B_k)L_k - B_k N_k
  //
  // where A_k is the coefficient of the kth index in the source subscript,
  // B_k is the coefficient of the kth index in the destination subscript,
  // U_k is the upper bound of the kth index, L_k is the lower bound of the Kth
  // index, and N_k is the stride of the kth index. Since all loops are normalized
  // by the SCEV package, N_k = 1 and L_k = 0, allowing us to simplify the
  // equation to
  //
  //     LB^<_k = (A^-_k - B_k)^- (U_k - 0 - 1) + (A_k - B_k)0 - B_k 1
  //            = (A^-_k - B_k)^- (U_k - 1)  - B_k
  //
  // Similar simplifications are possible for the other equations.
  //
  // When we can't determine the number of iterations for a loop,
  // we use NULL as an indicator for the worst case, infinity.
  // When computing the upper bound, NULL denotes +inf;
  // for the lower bound, NULL denotes -inf.
  //
  // Return true if dependence disproved.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::banerjeeMIVtest">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2452,
   FQN="llvm::DependenceInfo::banerjeeMIVtest", NM="_ZNK4llvm14DependenceInfo15banerjeeMIVtestEPKNS_4SCEVES3_RKNS_14SmallBitVectorERNS_14FullDependenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo15banerjeeMIVtestEPKNS_4SCEVES3_RKNS_14SmallBitVectorERNS_14FullDependenceE")
  //</editor-fold>
  private boolean banerjeeMIVtest(/*const*/ SCEV /*P*/ Src, /*const*/ SCEV /*P*/ Dst, 
                 final /*const*/ SmallBitVector /*&*/ Loops, 
                 final FullDependence /*&*/ Result) /*const*/ {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"starting Banerjee\n");
      }
    } while (false);
    BanerjeeApplications.$preInc();
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"    Src = "), $Deref(Src)).$out_char($$LF);
      }
    } while (false);
    type$ref</*const*/ SCEV /*P*/ > A0 = create_type$ref();
    CoefficientInfo[] /*P*/ A = collectCoeffInfo(Src, true, A0);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"    Dst = "), $Deref(Dst)).$out_char($$LF);
      }
    } while (false);
    type$ref</*const*/ SCEV /*P*/ > B0 = create_type$ref();
    CoefficientInfo[] /*P*/ B = collectCoeffInfo(Dst, false, B0);
    BoundInfo[] /*P*/ Bound = new BoundInfo [MaxLevels + 1];
    /*const*/ SCEV /*P*/ Delta = SE.getMinusSCEV(B0.$deref(), A0.$deref());
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\tDelta = "), $Deref(Delta)).$out_char($$LF);
      }
    } while (false);
    
    // Compute bounds for all the * directions.
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"\tBounds[*]\n");
      }
    } while (false);
    for (/*uint*/int K = 1; $lesseq_uint(K, MaxLevels); ++K) {
      Bound[K].Iterations = (A[K].Iterations != null) ? A[K].Iterations : B[K].Iterations;
      Bound[K].Direction = (byte) Dependence.DVEntry.Unnamed_enum.ALL.getValue();
      Bound[K].DirSet = (byte) Dependence.DVEntry.Unnamed_enum.NONE.getValue();
      findBoundsALL(A, B, Bound, K);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          dbgs().$out(/*KEEP_STR*/"\t    ").$out_uint(K).$out_char($$TAB);
        }
      } while (false);
      if ((Bound[K].Lower[Dependence.DVEntry.Unnamed_enum.ALL.getValue()] != null)) {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs(), $Deref(Bound[K].Lower[Dependence.DVEntry.Unnamed_enum.ALL.getValue()])).$out_char($$TAB);
          }
        } while (false);
      } else {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"-inf\t");
          }
        } while (false);
      }
      if ((Bound[K].Upper[Dependence.DVEntry.Unnamed_enum.ALL.getValue()] != null)) {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs(), $Deref(Bound[K].Upper[Dependence.DVEntry.Unnamed_enum.ALL.getValue()])).$out_char($$LF);
          }
        } while (false);
      } else {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"+inf\n");
          }
        } while (false);
      }
    }
    
    // Test the *, *, *, ... case.
    boolean Disproved = false;
    if (testBounds((byte)Dependence.DVEntry.Unnamed_enum.ALL.getValue(), 0, Bound, Delta)) {
      // Explore the direction vector hierarchy.
      uint$ref DepthExpanded = create_uint$ref(0);
      /*uint*/int NewDeps = exploreDirections(1, A, B, Bound, 
          Loops, DepthExpanded, Delta);
      if ($greater_uint(NewDeps, 0)) {
        boolean Improved = false;
        for (/*uint*/int K = 1; $lesseq_uint(K, CommonLevels); ++K) {
          if (Loops.$at$Const(K)) {
            /*uint*/int Old = $uchar2uint($3bits_uchar2uchar(Result.DV.$at(K - 1).Direction));
            Result.DV.$at(K - 1).Direction = $uchar2uchar_3bits($uint2uchar(Old & $uchar2uint(Bound[K].DirSet)));
            Improved |= Old != $uchar2uint($3bits_uchar2uchar(Result.DV.$at(K - 1).Direction));
            if (!($3bits_uchar2uchar(Result.DV.$at(K - 1).Direction) != 0)) {
              Improved = false;
              Disproved = true;
              break;
            }
          }
        }
        if (Improved) {
          BanerjeeSuccesses.$preInc();
        }
      } else {
        BanerjeeIndependence.$preInc();
        Disproved = true;
      }
    } else {
      BanerjeeIndependence.$preInc();
      Disproved = true;
    }
    /*delete[]*/Destructors.$destroyArray(Bound);
    /*delete[]*/Destructors.$destroyArray(A);
    /*delete[]*/Destructors.$destroyArray(B);
    return Disproved;
  }

  
  /// collectCoefficientInfo - Walks through the subscript,
  /// collecting each coefficient, the associated loop bounds,
  /// and recording its positive and negative parts for later use.
  
  // Walks through the subscript,
  // collecting each coefficient, the associated loop bounds,
  // and recording its positive and negative parts for later use.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::collectCoeffInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2826,
   FQN="llvm::DependenceInfo::collectCoeffInfo", NM="_ZNK4llvm14DependenceInfo16collectCoeffInfoEPKNS_4SCEVEbRS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo16collectCoeffInfoEPKNS_4SCEVEbRS3_")
  //</editor-fold>
  private DependenceInfo.CoefficientInfo[] /*P*/ collectCoeffInfo(/*const*/ SCEV /*P*/ Subscript, boolean SrcFlag, 
                  final type$ref</*const*/ SCEV /*P*/ /*&*/> Constant) /*const*/ {
    /*const*/ SCEV /*P*/ Zero = SE.getZero(Subscript.getType());
    CoefficientInfo[] /*P*/ CI = new CoefficientInfo [MaxLevels + 1];
    for (/*uint*/int K = 1; $lesseq_uint(K, MaxLevels); ++K) {
      CI[K].Coeff = Zero;
      CI[K].PosPart = Zero;
      CI[K].NegPart = Zero;
      CI[K].Iterations = null;
    }
    {
      /*const*/ SCEVAddRecExpr /*P*/ AddRec;
      while (((/*P*/ AddRec = dyn_cast_SCEVAddRecExpr(Subscript)) != null)) {
        /*const*/ Loop /*P*/ L = AddRec.getLoop();
        /*uint*/int K = SrcFlag ? mapSrcLoop(L) : mapDstLoop(L);
        CI[K].Coeff = AddRec.getStepRecurrence($Deref(SE));
        CI[K].PosPart = getPositivePart(CI[K].Coeff);
        CI[K].NegPart = getNegativePart(CI[K].Coeff);
        CI[K].Iterations = collectUpperBound(L, Subscript.getType());
        Subscript = AddRec.getStart();
      }
    }
    Constant.$set(Subscript);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"\tCoefficient Info\n");
      }
    } while (false);
    for (/*uint*/int K = 1; $lesseq_uint(K, MaxLevels); ++K) {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    ").$out_uint(K).$out(/*KEEP_STR*/$TAB), $Deref(CI[K].Coeff));
        }
      } while (false);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          dbgs().$out(/*KEEP_STR*/"\tPos Part = ");
        }
      } while (false);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs(), $Deref(CI[K].PosPart));
        }
      } while (false);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          dbgs().$out(/*KEEP_STR*/"\tNeg Part = ");
        }
      } while (false);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs(), $Deref(CI[K].NegPart));
        }
      } while (false);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          dbgs().$out(/*KEEP_STR*/"\tUpper Bound = ");
        }
      } while (false);
      if ((CI[K].Iterations != null)) {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs(), $Deref(CI[K].Iterations));
          }
        } while (false);
      } else {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"+inf");
          }
        } while (false);
      }
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          dbgs().$out_char($$LF);
        }
      } while (false);
    }
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t    Constant = "), $Deref(Subscript)).$out_char($$LF);
      }
    } while (false);
    return CI;
  }

  
  /// getPositivePart - X^+ = max(X, 0).
  ///
  
  // X^+ = max(X, 0)
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::getPositivePart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2812,
   FQN="llvm::DependenceInfo::getPositivePart", NM="_ZNK4llvm14DependenceInfo15getPositivePartEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo15getPositivePartEPKNS_4SCEVE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ getPositivePart(/*const*/ SCEV /*P*/ X) /*const*/ {
    return SE.getSMaxExpr(X, SE.getZero(X.getType()));
  }

  
  /// getNegativePart - X^- = min(X, 0).
  ///
  
  // X^- = min(X, 0)
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::getNegativePart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2818,
   FQN="llvm::DependenceInfo::getNegativePart", NM="_ZNK4llvm14DependenceInfo15getNegativePartEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo15getNegativePartEPKNS_4SCEVE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ getNegativePart(/*const*/ SCEV /*P*/ X) /*const*/ {
    return SE.getSMinExpr(X, SE.getZero(X.getType()));
  }

  
  /// getLowerBound - Looks through all the bounds info and
  /// computes the lower bound given the current direction settings
  /// at each level.
  
  // Looks through all the bounds info and
  // computes the lower bound given the current direction settings
  // at each level. If the lower bound for any level is -inf,
  // the result is -inf.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::getLowerBound">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2872,
   FQN="llvm::DependenceInfo::getLowerBound", NM="_ZNK4llvm14DependenceInfo13getLowerBoundEPNS0_9BoundInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo13getLowerBoundEPNS0_9BoundInfoE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ getLowerBound(BoundInfo[] /*P*/ Bound) /*const*/ {
    /*const*/ SCEV /*P*/ Sum = Bound[1].Lower[Bound[1].Direction];
    for (/*uint*/int K = 2; (Sum != null) && $lesseq_uint(K, MaxLevels); ++K) {
      if ((Bound[K].Lower[Bound[K].Direction] != null)) {
        Sum = SE.getAddExpr(Sum, Bound[K].Lower[Bound[K].Direction]);
      } else {
        Sum = null;
      }
    }
    return Sum;
  }

  
  /// getUpperBound - Looks through all the bounds info and
  /// computes the upper bound given the current direction settings
  /// at each level.
  
  // Looks through all the bounds info and
  // computes the upper bound given the current direction settings
  // at each level. If the upper bound at any level is +inf,
  // the result is +inf.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::getUpperBound">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2888,
   FQN="llvm::DependenceInfo::getUpperBound", NM="_ZNK4llvm14DependenceInfo13getUpperBoundEPNS0_9BoundInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo13getUpperBoundEPNS0_9BoundInfoE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ getUpperBound(BoundInfo[] /*P*/ Bound) /*const*/ {
    /*const*/ SCEV /*P*/ Sum = Bound[1].Upper[Bound[1].Direction];
    for (/*uint*/int K = 2; (Sum != null) && $lesseq_uint(K, MaxLevels); ++K) {
      if ((Bound[K].Upper[Bound[K].Direction] != null)) {
        Sum = SE.getAddExpr(Sum, Bound[K].Upper[Bound[K].Direction]);
      } else {
        Sum = null;
      }
    }
    return Sum;
  }

  
  /// exploreDirections - Hierarchically expands the direction vector
  /// search space, combining the directions of discovered dependences
  /// in the DirSet field of Bound. Returns the number of distinct
  /// dependences discovered. If the dependence is disproved,
  /// it will return 0.
  
  // Hierarchically expands the direction vector
  // search space, combining the directions of discovered dependences
  // in the DirSet field of Bound. Returns the number of distinct
  // dependences discovered. If the dependence is disproved,
  // it will return 0.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::exploreDirections">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2532,
   FQN="llvm::DependenceInfo::exploreDirections", NM="_ZNK4llvm14DependenceInfo17exploreDirectionsEjPNS0_15CoefficientInfoES2_PNS0_9BoundInfoERKNS_14SmallBitVectorERjPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo17exploreDirectionsEjPNS0_15CoefficientInfoES2_PNS0_9BoundInfoERKNS_14SmallBitVectorERjPKNS_4SCEVE")
  //</editor-fold>
  private /*uint*/int exploreDirections(/*uint*/int Level, CoefficientInfo[] /*P*/ A, 
                   CoefficientInfo[] /*P*/ B, BoundInfo[] /*P*/ Bound, 
                   final /*const*/ SmallBitVector /*&*/ Loops, 
                   final uint$ref/*uint &*/ DepthExpanded, 
                   /*const*/ SCEV /*P*/ Delta) /*const*/ {
    if ($greater_uint(Level, CommonLevels)) {
      // record result
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          dbgs().$out(/*KEEP_STR*/"\t[");
        }
      } while (false);
      for (/*uint*/int K = 1; $lesseq_uint(K, CommonLevels); ++K) {
        if (Loops.$at$Const(K)) {
          Bound[K].DirSet |= $uchar2int(Bound[K].Direction);
          switch (Dependence.DVEntry.Unnamed_enum.valueOf($uchar2int(Bound[K].Direction))) {
           case LT:
            do {
              if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
                dbgs().$out(/*KEEP_STR*/" <");
              }
            } while (false);
            break;
           case EQ:
            do {
              if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
                dbgs().$out(/*KEEP_STR*/" =");
              }
            } while (false);
            break;
           case GT:
            do {
              if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
                dbgs().$out(/*KEEP_STR*/" >");
              }
            } while (false);
            break;
           case ALL:
            do {
              if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
                dbgs().$out(/*KEEP_STR*/" *");
              }
            } while (false);
            break;
           default:
            throw new llvm_unreachable("unexpected Bound[K].Direction");
          }
        }
      }
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          dbgs().$out(/*KEEP_STR*/" ]\n");
        }
      } while (false);
      return 1;
    }
    if (Loops.$at$Const(Level)) {
      if ($greater_uint(Level, DepthExpanded.$deref())) {
        DepthExpanded.$set(Level);
        // compute bounds for <, =, > at current level
        findBoundsLT(A, B, Bound, Level);
        findBoundsGT(A, B, Bound, Level);
        findBoundsEQ(A, B, Bound, Level);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"\tBound for level = ").$out_uint(Level).$out_char($$LF);
          }
        } while (false);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"\t    <\t");
          }
        } while (false);
        if ((Bound[Level].Lower[Dependence.DVEntry.Unnamed_enum.LT.getValue()] != null)) {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs(), $Deref(Bound[Level].Lower[Dependence.DVEntry.Unnamed_enum.LT.getValue()])).$out_char($$TAB);
            }
          } while (false);
        } else {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              dbgs().$out(/*KEEP_STR*/"-inf\t");
            }
          } while (false);
        }
        if ((Bound[Level].Upper[Dependence.DVEntry.Unnamed_enum.LT.getValue()] != null)) {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs(), $Deref(Bound[Level].Upper[Dependence.DVEntry.Unnamed_enum.LT.getValue()])).$out_char($$LF);
            }
          } while (false);
        } else {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              dbgs().$out(/*KEEP_STR*/"+inf\n");
            }
          } while (false);
        }
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"\t    =\t");
          }
        } while (false);
        if ((Bound[Level].Lower[Dependence.DVEntry.Unnamed_enum.EQ.getValue()] != null)) {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs(), $Deref(Bound[Level].Lower[Dependence.DVEntry.Unnamed_enum.EQ.getValue()])).$out_char($$TAB);
            }
          } while (false);
        } else {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              dbgs().$out(/*KEEP_STR*/"-inf\t");
            }
          } while (false);
        }
        if ((Bound[Level].Upper[Dependence.DVEntry.Unnamed_enum.EQ.getValue()] != null)) {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs(), $Deref(Bound[Level].Upper[Dependence.DVEntry.Unnamed_enum.EQ.getValue()])).$out_char($$LF);
            }
          } while (false);
        } else {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              dbgs().$out(/*KEEP_STR*/"+inf\n");
            }
          } while (false);
        }
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"\t    >\t");
          }
        } while (false);
        if ((Bound[Level].Lower[Dependence.DVEntry.Unnamed_enum.GT.getValue()] != null)) {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs(), $Deref(Bound[Level].Lower[Dependence.DVEntry.Unnamed_enum.GT.getValue()])).$out_char($$TAB);
            }
          } while (false);
        } else {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              dbgs().$out(/*KEEP_STR*/"-inf\t");
            }
          } while (false);
        }
        if ((Bound[Level].Upper[Dependence.DVEntry.Unnamed_enum.GT.getValue()] != null)) {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs(), $Deref(Bound[Level].Upper[Dependence.DVEntry.Unnamed_enum.GT.getValue()])).$out_char($$LF);
            }
          } while (false);
        } else {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
              dbgs().$out(/*KEEP_STR*/"+inf\n");
            }
          } while (false);
        }
      }
      
      /*uint*/int NewDeps = 0;
      
      // test bounds for <, *, *, ...
      if (testBounds((byte) Dependence.DVEntry.Unnamed_enum.LT.getValue(), Level, Bound, Delta)) {
        NewDeps += exploreDirections(Level + 1, A, B, Bound, 
            Loops, DepthExpanded, Delta);
      }
      
      // Test bounds for =, *, *, ...
      if (testBounds((byte) Dependence.DVEntry.Unnamed_enum.EQ.getValue(), Level, Bound, Delta)) {
        NewDeps += exploreDirections(Level + 1, A, B, Bound, 
            Loops, DepthExpanded, Delta);
      }
      
      // test bounds for >, *, *, ...
      if (testBounds((byte) Dependence.DVEntry.Unnamed_enum.GT.getValue(), Level, Bound, Delta)) {
        NewDeps += exploreDirections(Level + 1, A, B, Bound, 
            Loops, DepthExpanded, Delta);
      }
      
      Bound[Level].Direction = (byte) Dependence.DVEntry.Unnamed_enum.ALL.getValue();
      return NewDeps;
    } else {
      return exploreDirections(Level + 1, A, B, Bound, Loops, DepthExpanded, Delta);
    }
  }

  
  /// testBounds - Returns true iff the current bounds are plausible.
  
  // Returns true iff the current bounds are plausible.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::testBounds">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2631,
   FQN="llvm::DependenceInfo::testBounds", NM="_ZNK4llvm14DependenceInfo10testBoundsEhjPNS0_9BoundInfoEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10testBoundsEhjPNS0_9BoundInfoEPKNS_4SCEVE")
  //</editor-fold>
  private boolean testBounds(/*uchar*/byte DirKind, /*uint*/int Level, 
            BoundInfo[] /*P*/ Bound, /*const*/ SCEV /*P*/ Delta) /*const*/ {
    Bound[Level].Direction = DirKind;
    {
      /*const*/ SCEV /*P*/ LowerBound = getLowerBound(Bound);
      if ((LowerBound != null)) {
        if (isKnownPredicate(CmpInst.Predicate.ICMP_SGT, LowerBound, Delta)) {
          return false;
        }
      }
    }
    {
      /*const*/ SCEV /*P*/ UpperBound = getUpperBound(Bound);
      if ((UpperBound != null)) {
        if (isKnownPredicate(CmpInst.Predicate.ICMP_SGT, Delta, UpperBound)) {
          return false;
        }
      }
    }
    return true;
  }

  
  /// findBoundsALL - Computes the upper and lower bounds for level K
  /// using the * direction. Records them in Bound.
  
  // Computes the upper and lower bounds for level K
  // using the * direction. Records them in Bound.
  // Wolfe gives the equations
  //
  //    LB^*_k = (A^-_k - B^+_k)(U_k - L_k) + (A_k - B_k)L_k
  //    UB^*_k = (A^+_k - B^-_k)(U_k - L_k) + (A_k - B_k)L_k
  //
  // Since we normalize loops, we can simplify these equations to
  //
  //    LB^*_k = (A^-_k - B^+_k)U_k
  //    UB^*_k = (A^+_k - B^-_k)U_k
  //
  // We must be careful to handle the case where the upper bound is unknown.
  // Note that the lower bound is always <= 0
  // and the upper bound is always >= 0.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::findBoundsALL">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2659,
   FQN="llvm::DependenceInfo::findBoundsALL", NM="_ZNK4llvm14DependenceInfo13findBoundsALLEPNS0_15CoefficientInfoES2_PNS0_9BoundInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo13findBoundsALLEPNS0_15CoefficientInfoES2_PNS0_9BoundInfoEj")
  //</editor-fold>
  private void findBoundsALL(CoefficientInfo[] /*P*/ A, CoefficientInfo[] /*P*/ B, 
               BoundInfo[] /*P*/ Bound, /*uint*/int K) /*const*/ {
    Bound[K].Lower[Dependence.DVEntry.Unnamed_enum.ALL.getValue()] = null; // Default value = -infinity.
    Bound[K].Upper[Dependence.DVEntry.Unnamed_enum.ALL.getValue()] = null; // Default value = +infinity.
    if ((Bound[K].Iterations != null)) {
      Bound[K].Lower[Dependence.DVEntry.Unnamed_enum.ALL.getValue()]
         = SE.getMulExpr(SE.getMinusSCEV(A[K].NegPart, B[K].PosPart), 
          Bound[K].Iterations);
      Bound[K].Upper[Dependence.DVEntry.Unnamed_enum.ALL.getValue()]
         = SE.getMulExpr(SE.getMinusSCEV(A[K].PosPart, B[K].NegPart), 
          Bound[K].Iterations);
    } else {
      // If the difference is 0, we won't need to know the number of iterations.
      if (isKnownPredicate(CmpInst.Predicate.ICMP_EQ, A[K].NegPart, B[K].PosPart)) {
        Bound[K].Lower[Dependence.DVEntry.Unnamed_enum.ALL.getValue()]
           = SE.getZero(A[K].Coeff.getType());
      }
      if (isKnownPredicate(CmpInst.Predicate.ICMP_EQ, A[K].PosPart, B[K].NegPart)) {
        Bound[K].Upper[Dependence.DVEntry.Unnamed_enum.ALL.getValue()]
           = SE.getZero(A[K].Coeff.getType());
      }
    }
  }

  
  /// findBoundsLT - Computes the upper and lower bounds for level K
  /// using the < direction. Records them in Bound.
  
  // Computes the upper and lower bounds for level K
  // using the < direction. Records them in Bound.
  // Wolfe gives the equations
  //
  //    LB^<_k = (A^-_k - B_k)^- (U_k - L_k - N_k) + (A_k - B_k)L_k - B_k N_k
  //    UB^<_k = (A^+_k - B_k)^+ (U_k - L_k - N_k) + (A_k - B_k)L_k - B_k N_k
  //
  // Since we normalize loops, we can simplify these equations to
  //
  //    LB^<_k = (A^-_k - B_k)^- (U_k - 1) - B_k
  //    UB^<_k = (A^+_k - B_k)^+ (U_k - 1) - B_k
  //
  // We must be careful to handle the case where the upper bound is unknown.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::findBoundsLT">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2738,
   FQN="llvm::DependenceInfo::findBoundsLT", NM="_ZNK4llvm14DependenceInfo12findBoundsLTEPNS0_15CoefficientInfoES2_PNS0_9BoundInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo12findBoundsLTEPNS0_15CoefficientInfoES2_PNS0_9BoundInfoEj")
  //</editor-fold>
  private void findBoundsLT(CoefficientInfo[] /*P*/ A, CoefficientInfo[] /*P*/ B, 
              BoundInfo[] /*P*/ Bound, /*uint*/int K) /*const*/ {
    Bound[K].Lower[Dependence.DVEntry.Unnamed_enum.LT.getValue()] = null; // Default value = -infinity.
    Bound[K].Upper[Dependence.DVEntry.Unnamed_enum.LT.getValue()] = null; // Default value = +infinity.
    if ((Bound[K].Iterations != null)) {
      /*const*/ SCEV /*P*/ Iter_1 = SE.getMinusSCEV(Bound[K].Iterations, SE.getOne(Bound[K].Iterations.getType()));
      /*const*/ SCEV /*P*/ NegPart = getNegativePart(SE.getMinusSCEV(A[K].NegPart, B[K].Coeff));
      Bound[K].Lower[Dependence.DVEntry.Unnamed_enum.LT.getValue()]
         = SE.getMinusSCEV(SE.getMulExpr(NegPart, Iter_1), B[K].Coeff);
      /*const*/ SCEV /*P*/ PosPart = getPositivePart(SE.getMinusSCEV(A[K].PosPart, B[K].Coeff));
      Bound[K].Upper[Dependence.DVEntry.Unnamed_enum.LT.getValue()]
         = SE.getMinusSCEV(SE.getMulExpr(PosPart, Iter_1), B[K].Coeff);
    } else {
      // If the positive/negative part of the difference is 0,
      // we won't need to know the number of iterations.
      /*const*/ SCEV /*P*/ NegPart = getNegativePart(SE.getMinusSCEV(A[K].NegPart, B[K].Coeff));
      if (NegPart.isZero()) {
        Bound[K].Lower[Dependence.DVEntry.Unnamed_enum.LT.getValue()] = SE.getNegativeSCEV(B[K].Coeff);
      }
      /*const*/ SCEV /*P*/ PosPart = getPositivePart(SE.getMinusSCEV(A[K].PosPart, B[K].Coeff));
      if (PosPart.isZero()) {
        Bound[K].Upper[Dependence.DVEntry.Unnamed_enum.LT.getValue()] = SE.getNegativeSCEV(B[K].Coeff);
      }
    }
  }

  
  /// findBoundsGT - Computes the upper and lower bounds for level K
  /// using the > direction. Records them in Bound.
  
  // Computes the upper and lower bounds for level K
  // using the > direction. Records them in Bound.
  // Wolfe gives the equations
  //
  //    LB^>_k = (A_k - B^+_k)^- (U_k - L_k - N_k) + (A_k - B_k)L_k + A_k N_k
  //    UB^>_k = (A_k - B^-_k)^+ (U_k - L_k - N_k) + (A_k - B_k)L_k + A_k N_k
  //
  // Since we normalize loops, we can simplify these equations to
  //
  //    LB^>_k = (A_k - B^+_k)^- (U_k - 1) + A_k
  //    UB^>_k = (A_k - B^-_k)^+ (U_k - 1) + A_k
  //
  // We must be careful to handle the case where the upper bound is unknown.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::findBoundsGT">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2782,
   FQN="llvm::DependenceInfo::findBoundsGT", NM="_ZNK4llvm14DependenceInfo12findBoundsGTEPNS0_15CoefficientInfoES2_PNS0_9BoundInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo12findBoundsGTEPNS0_15CoefficientInfoES2_PNS0_9BoundInfoEj")
  //</editor-fold>
  private void findBoundsGT(CoefficientInfo[] /*P*/ A, CoefficientInfo[] /*P*/ B, 
              BoundInfo[] /*P*/ Bound, /*uint*/int K) /*const*/ {
    Bound[K].Lower[Dependence.DVEntry.Unnamed_enum.GT.getValue()] = null; // Default value = -infinity.
    Bound[K].Upper[Dependence.DVEntry.Unnamed_enum.GT.getValue()] = null; // Default value = +infinity.
    if ((Bound[K].Iterations != null)) {
      /*const*/ SCEV /*P*/ Iter_1 = SE.getMinusSCEV(Bound[K].Iterations, SE.getOne(Bound[K].Iterations.getType()));
      /*const*/ SCEV /*P*/ NegPart = getNegativePart(SE.getMinusSCEV(A[K].Coeff, B[K].PosPart));
      Bound[K].Lower[Dependence.DVEntry.Unnamed_enum.GT.getValue()]
         = SE.getAddExpr(SE.getMulExpr(NegPart, Iter_1), A[K].Coeff);
      /*const*/ SCEV /*P*/ PosPart = getPositivePart(SE.getMinusSCEV(A[K].Coeff, B[K].NegPart));
      Bound[K].Upper[Dependence.DVEntry.Unnamed_enum.GT.getValue()]
         = SE.getAddExpr(SE.getMulExpr(PosPart, Iter_1), A[K].Coeff);
    } else {
      // If the positive/negative part of the difference is 0,
      // we won't need to know the number of iterations.
      /*const*/ SCEV /*P*/ NegPart = getNegativePart(SE.getMinusSCEV(A[K].Coeff, B[K].PosPart));
      if (NegPart.isZero()) {
        Bound[K].Lower[Dependence.DVEntry.Unnamed_enum.GT.getValue()] = A[K].Coeff;
      }
      /*const*/ SCEV /*P*/ PosPart = getPositivePart(SE.getMinusSCEV(A[K].Coeff, B[K].NegPart));
      if (PosPart.isZero()) {
        Bound[K].Upper[Dependence.DVEntry.Unnamed_enum.GT.getValue()] = A[K].Coeff;
      }
    }
  }

  
  /// findBoundsEQ - Computes the upper and lower bounds for level K
  /// using the = direction. Records them in Bound.
  
  // Computes the upper and lower bounds for level K
  // using the = direction. Records them in Bound.
  // Wolfe gives the equations
  //
  //    LB^=_k = (A_k - B_k)^- (U_k - L_k) + (A_k - B_k)L_k
  //    UB^=_k = (A_k - B_k)^+ (U_k - L_k) + (A_k - B_k)L_k
  //
  // Since we normalize loops, we can simplify these equations to
  //
  //    LB^=_k = (A_k - B_k)^- U_k
  //    UB^=_k = (A_k - B_k)^+ U_k
  //
  // We must be careful to handle the case where the upper bound is unknown.
  // Note that the lower bound is always <= 0
  // and the upper bound is always >= 0.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::findBoundsEQ">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2698,
   FQN="llvm::DependenceInfo::findBoundsEQ", NM="_ZNK4llvm14DependenceInfo12findBoundsEQEPNS0_15CoefficientInfoES2_PNS0_9BoundInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo12findBoundsEQEPNS0_15CoefficientInfoES2_PNS0_9BoundInfoEj")
  //</editor-fold>
  private void findBoundsEQ(CoefficientInfo[] /*P*/ A, CoefficientInfo[] /*P*/ B, 
              BoundInfo[] /*P*/ Bound, /*uint*/int K) /*const*/ {
    Bound[K].Lower[Dependence.DVEntry.Unnamed_enum.EQ.getValue()] = null; // Default value = -infinity.
    Bound[K].Upper[Dependence.DVEntry.Unnamed_enum.EQ.getValue()] = null; // Default value = +infinity.
    if ((Bound[K].Iterations != null)) {
      /*const*/ SCEV /*P*/ Delta = SE.getMinusSCEV(A[K].Coeff, B[K].Coeff);
      /*const*/ SCEV /*P*/ NegativePart = getNegativePart(Delta);
      Bound[K].Lower[Dependence.DVEntry.Unnamed_enum.EQ.getValue()]
         = SE.getMulExpr(NegativePart, Bound[K].Iterations);
      /*const*/ SCEV /*P*/ PositivePart = getPositivePart(Delta);
      Bound[K].Upper[Dependence.DVEntry.Unnamed_enum.EQ.getValue()]
         = SE.getMulExpr(PositivePart, Bound[K].Iterations);
    } else {
      // If the positive/negative part of the difference is 0,
      // we won't need to know the number of iterations.
      /*const*/ SCEV /*P*/ Delta = SE.getMinusSCEV(A[K].Coeff, B[K].Coeff);
      /*const*/ SCEV /*P*/ NegativePart = getNegativePart(Delta);
      if (NegativePart.isZero()) {
        Bound[K].Lower[Dependence.DVEntry.Unnamed_enum.EQ.getValue()] = NegativePart; // Zero
      }
      /*const*/ SCEV /*P*/ PositivePart = getPositivePart(Delta);
      if (PositivePart.isZero()) {
        Bound[K].Upper[Dependence.DVEntry.Unnamed_enum.EQ.getValue()] = PositivePart; // Zero
      }
    }
  }

  
  /// intersectConstraints - Updates X with the intersection
  /// of the Constraints X and Y. Returns true if X has changed.
  
  // Updates X with the intersection
  // of the Constraints X and Y. Returns true if X has changed.
  // Corresponds to Figure 4 from the paper
  //
  //            Practical Dependence Testing
  //            Goff, Kennedy, Tseng
  //            PLDI 1991
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::intersectConstraints">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 415,
   FQN="llvm::DependenceInfo::intersectConstraints", NM="_ZN4llvm14DependenceInfo20intersectConstraintsEPNS0_10ConstraintEPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo20intersectConstraintsEPNS0_10ConstraintEPKS1_")
  //</editor-fold>
  private boolean intersectConstraints(Constraint /*P*/ X, /*const*/ Constraint /*P*/ Y) {
    DeltaApplications.$preInc();
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"\tintersect constraints\n");
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"\t    X =");
        X.dump(dbgs());
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"\t    Y =");
        Y.dump(dbgs());
      }
    } while (false);
    assert (!Y.isPoint()) : "Y must not be a Point";
    if (X.isAny()) {
      if (Y.isAny()) {
        return false;
      }
      $Deref(X).$assign($Deref(Y));
      return true;
    }
    if (X.isEmpty()) {
      return false;
    }
    if (Y.isEmpty()) {
      X.setEmpty();
      return true;
    }
    if (X.isDistance() && Y.isDistance()) {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          dbgs().$out(/*KEEP_STR*/"\t    intersect 2 distances\n");
        }
      } while (false);
      if (isKnownPredicate(CmpInst.Predicate.ICMP_EQ, X.getD(), Y.getD())) {
        return false;
      }
      if (isKnownPredicate(CmpInst.Predicate.ICMP_NE, X.getD(), Y.getD())) {
        X.setEmpty();
        DeltaSuccesses.$preInc();
        return true;
      }
      // Hmmm, interesting situation.
      // I guess if either is constant, keep it and ignore the other.
      if (isa_SCEVConstant(Y.getD())) {
        $Deref(X).$assign($Deref(Y));
        return true;
      }
      return false;
    }
    
    // At this point, the pseudo-code in Figure 4 of the paper
    // checks if (X->isPoint() && Y->isPoint()).
    // This case can't occur in our implementation,
    // since a Point can only arise as the result of intersecting
    // two Line constraints, and the right-hand value, Y, is never
    // the result of an intersection.
    assert (!(X.isPoint() && Y.isPoint())) : "We shouldn't ever see X->isPoint() && Y->isPoint()";
    if (X.isLine() && Y.isLine()) {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          dbgs().$out(/*KEEP_STR*/"\t    intersect 2 lines\n");
        }
      } while (false);
      /*const*/ SCEV /*P*/ Prod1 = SE.getMulExpr(X.getA(), Y.getB());
      /*const*/ SCEV /*P*/ Prod2 = SE.getMulExpr(X.getB(), Y.getA());
      if (isKnownPredicate(CmpInst.Predicate.ICMP_EQ, Prod1, Prod2)) {
        // slopes are equal, so lines are parallel
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"\t\tsame slope\n");
          }
        } while (false);
        Prod1 = SE.getMulExpr(X.getC(), Y.getB());
        Prod2 = SE.getMulExpr(X.getB(), Y.getC());
        if (isKnownPredicate(CmpInst.Predicate.ICMP_EQ, Prod1, Prod2)) {
          return false;
        }
        if (isKnownPredicate(CmpInst.Predicate.ICMP_NE, Prod1, Prod2)) {
          X.setEmpty();
          DeltaSuccesses.$preInc();
          return true;
        }
        return false;
      }
      if (isKnownPredicate(CmpInst.Predicate.ICMP_NE, Prod1, Prod2)) {
        // slopes differ, so lines intersect
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            dbgs().$out(/*KEEP_STR*/"\t\tdifferent slopes\n");
          }
        } while (false);
        /*const*/ SCEV /*P*/ C1B2 = SE.getMulExpr(X.getC(), Y.getB());
        /*const*/ SCEV /*P*/ C1A2 = SE.getMulExpr(X.getC(), Y.getA());
        /*const*/ SCEV /*P*/ C2B1 = SE.getMulExpr(Y.getC(), X.getB());
        /*const*/ SCEV /*P*/ C2A1 = SE.getMulExpr(Y.getC(), X.getA());
        /*const*/ SCEV /*P*/ A1B2 = SE.getMulExpr(X.getA(), Y.getB());
        /*const*/ SCEV /*P*/ A2B1 = SE.getMulExpr(Y.getA(), X.getB());
        /*const*/ SCEVConstant /*P*/ C1A2_C2A1 = dyn_cast_SCEVConstant(SE.getMinusSCEV(C1A2, C2A1));
        /*const*/ SCEVConstant /*P*/ C1B2_C2B1 = dyn_cast_SCEVConstant(SE.getMinusSCEV(C1B2, C2B1));
        /*const*/ SCEVConstant /*P*/ A1B2_A2B1 = dyn_cast_SCEVConstant(SE.getMinusSCEV(A1B2, A2B1));
        /*const*/ SCEVConstant /*P*/ A2B1_A1B2 = dyn_cast_SCEVConstant(SE.getMinusSCEV(A2B1, A1B2));
        if (!(C1B2_C2B1 != null) || !(C1A2_C2A1 != null)
           || !(A1B2_A2B1 != null) || !(A2B1_A1B2 != null)) {
          return false;
        }
        APInt Xtop = new APInt(C1B2_C2B1.getAPInt());
        APInt Xbot = new APInt(A1B2_A2B1.getAPInt());
        APInt Ytop = new APInt(C1A2_C2A1.getAPInt());
        APInt Ybot = new APInt(A2B1_A1B2.getAPInt());
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t\tXtop = "), Xtop).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t\tXbot = "), Xbot).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t\tYtop = "), Ytop).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t\tYbot = "), Ybot).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        APInt Xq = new APInt(Xtop); // these need to be initialized, even
        APInt Xr = new APInt(Xtop); // though they're just going to be overwritten
        APInt.sdivrem(Xtop, Xbot, Xq, Xr);
        APInt Yq = new APInt(Ytop);
        APInt Yr = new APInt(Ytop);
        APInt.sdivrem(Ytop, Ybot, Yq, Yr);
        if (Xr.$noteq($int2ulong(0)) || Yr.$noteq($int2ulong(0))) {
          X.setEmpty();
          DeltaSuccesses.$preInc();
          return true;
        }
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
            AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t\tX = "), Xq).$out(/*KEEP_STR*/", Y = "), Yq).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
        if (Xq.slt(0) || Yq.slt(0)) {
          X.setEmpty();
          DeltaSuccesses.$preInc();
          return true;
        }
        {
          /*const*/ SCEVConstant /*P*/ CUB = collectConstantUpperBound(X.getAssociatedLoop(), Prod1.getType());
          if ((CUB != null)) {
            final /*const*/ APInt /*&*/ UpperBound = CUB.getAPInt();
            do {
              if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
                AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C(dbgs().$out(/*KEEP_STR*/"\t\tupper bound = "), UpperBound).$out(/*KEEP_STR*/$LF);
              }
            } while (false);
            if (Xq.sgt(UpperBound) || Yq.sgt(UpperBound)) {
              X.setEmpty();
              DeltaSuccesses.$preInc();
              return true;
            }
          }
        }
        X.setPoint(SE.getConstant(Xq), 
            SE.getConstant(Yq), 
            X.getAssociatedLoop());
        DeltaSuccesses.$preInc();
        return true;
      }
      return false;
    }
    
    // if (X->isLine() && Y->isPoint()) This case can't occur.
    assert (!(X.isLine() && Y.isPoint())) : "This case should never occur";
    if (X.isPoint() && Y.isLine()) {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          dbgs().$out(/*KEEP_STR*/"\t    intersect Point and Line\n");
        }
      } while (false);
      /*const*/ SCEV /*P*/ A1X1 = SE.getMulExpr(Y.getA(), X.getX());
      /*const*/ SCEV /*P*/ B1Y1 = SE.getMulExpr(Y.getB(), X.getY());
      /*const*/ SCEV /*P*/ Sum = SE.getAddExpr(A1X1, B1Y1);
      if (isKnownPredicate(CmpInst.Predicate.ICMP_EQ, Sum, Y.getC())) {
        return false;
      }
      if (isKnownPredicate(CmpInst.Predicate.ICMP_NE, Sum, Y.getC())) {
        X.setEmpty();
        DeltaSuccesses.$preInc();
        return true;
      }
      return false;
    }
    throw new llvm_unreachable("shouldn't reach the end of Constraint intersection");
//    return false;
  }

  
  /// propagate - Review the constraints, looking for opportunities
  /// to simplify a subscript pair (Src and Dst).
  /// Return true if some simplification occurs.
  /// If the simplification isn't exact (that is, if it is conservative
  /// in terms of dependence), set consistent to false.
  
  // Review the constraints, looking for opportunities
  // to simplify a subscript pair (Src and Dst).
  // Return true if some simplification occurs.
  // If the simplification isn't exact (that is, if it is conservative
  // in terms of dependence), set consistent to false.
  // Corresponds to Figure 5 from the paper
  //
  //            Practical Dependence Testing
  //            Goff, Kennedy, Tseng
  //            PLDI 1991
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::propagate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2981,
   FQN="llvm::DependenceInfo::propagate", NM="_ZN4llvm14DependenceInfo9propagateERPKNS_4SCEVES4_RNS_14SmallBitVectorERNS_15SmallVectorImplINS0_10ConstraintEEERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo9propagateERPKNS_4SCEVES4_RNS_14SmallBitVectorERNS_15SmallVectorImplINS0_10ConstraintEEERb")
  //</editor-fold>
  private boolean propagate(final type$ref</*const*/ SCEV /*P*/ /*&*/> Src, final type$ref</*const*/ SCEV /*P*/ /*&*/> Dst, 
           final SmallBitVector /*&*/ Loops, 
           final SmallVectorImpl<Constraint> /*&*/ Constraints, 
           final bool$ref/*bool &*/ Consistent) {
    boolean Result = false;
    for (int LI = Loops.find_first(); LI >= 0; LI = Loops.find_next(LI)) {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          dbgs().$out(/*KEEP_STR*/"\t    Constraint[").$out_int(LI).$out(/*KEEP_STR*/"] is");
        }
      } while (false);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
          Constraints.$at(LI).dump(dbgs());
        }
      } while (false);
      if (Constraints.$at(LI).isDistance()) {
        Result |= propagateDistance(Src, Dst, Constraints.$at(LI), Consistent);
      } else if (Constraints.$at(LI).isLine()) {
        Result |= propagateLine(Src, Dst, Constraints.$at(LI), Consistent);
      } else if (Constraints.$at(LI).isPoint()) {
        Result |= propagatePoint(Src, Dst, Constraints.$at(LI));
      }
    }
    return Result;
  }

  
  /// propagateDistance - Attempt to propagate a distance
  /// constraint into a subscript pair (Src and Dst).
  /// Return true if some simplification occurs.
  /// If the simplification isn't exact (that is, if it is conservative
  /// in terms of dependence), set consistent to false.
  
  // Attempt to propagate a distance
  // constraint into a subscript pair (Src and Dst).
  // Return true if some simplification occurs.
  // If the simplification isn't exact (that is, if it is conservative
  // in terms of dependence), set consistent to false.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::propagateDistance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 3005,
   FQN="llvm::DependenceInfo::propagateDistance", NM="_ZN4llvm14DependenceInfo17propagateDistanceERPKNS_4SCEVES4_RNS0_10ConstraintERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo17propagateDistanceERPKNS_4SCEVES4_RNS0_10ConstraintERb")
  //</editor-fold>
  private boolean propagateDistance(final type$ref</*const*/ SCEV /*P*/ /*&*/> Src, final type$ref</*const*/ SCEV /*P*/ /*&*/> Dst, 
                   final Constraint /*&*/ CurConstraint, 
                   final bool$ref/*bool &*/ Consistent) {
    /*const*/ Loop /*P*/ CurLoop = CurConstraint.getAssociatedLoop();
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t\tSrc is "), $Deref(Src.$deref())).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    /*const*/ SCEV /*P*/ A_K = findCoefficient(Src.$deref(), CurLoop);
    if (A_K.isZero()) {
      return false;
    }
    /*const*/ SCEV /*P*/ DA_K = SE.getMulExpr(A_K, CurConstraint.getD());
    Src.$set(SE.getMinusSCEV(Src.$deref(), DA_K));
    Src.$set(zeroCoefficient(Src.$deref(), CurLoop));
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t\tnew Src is "), $Deref(Src.$deref())).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t\tDst is "), $Deref(Dst.$deref())).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    Dst.$set(addToCoefficient(Dst.$deref(), CurLoop, SE.getNegativeSCEV(A_K)));
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t\tnew Dst is "), $Deref(Dst.$deref())).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    if (!findCoefficient(Dst.$deref(), CurLoop).isZero()) {
      Consistent.$set(false);
    }
    return true;
  }

  
  /// propagatePoint - Attempt to propagate a point
  /// constraint into a subscript pair (Src and Dst).
  /// Return true if some simplification occurs.
  
  // Attempt to propagate a point
  // constraint into a subscript pair (Src and Dst).
  // Return true if some simplification occurs.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::propagatePoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 3105,
   FQN="llvm::DependenceInfo::propagatePoint", NM="_ZN4llvm14DependenceInfo14propagatePointERPKNS_4SCEVES4_RNS0_10ConstraintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo14propagatePointERPKNS_4SCEVES4_RNS0_10ConstraintE")
  //</editor-fold>
  private boolean propagatePoint(final type$ref</*const*/ SCEV /*P*/ /*&*/> Src, final type$ref</*const*/ SCEV /*P*/ /*&*/> Dst, 
                final Constraint /*&*/ CurConstraint) {
    /*const*/ Loop /*P*/ CurLoop = CurConstraint.getAssociatedLoop();
    /*const*/ SCEV /*P*/ A_K = findCoefficient(Src.$deref(), CurLoop);
    /*const*/ SCEV /*P*/ AP_K = findCoefficient(Dst.$deref(), CurLoop);
    /*const*/ SCEV /*P*/ XA_K = SE.getMulExpr(A_K, CurConstraint.getX());
    /*const*/ SCEV /*P*/ YAP_K = SE.getMulExpr(AP_K, CurConstraint.getY());
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t\tSrc is "), $Deref(Src.$deref())).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    Src.$set(SE.getAddExpr(Src.$deref(), SE.getMinusSCEV(XA_K, YAP_K)));
    Src.$set(zeroCoefficient(Src.$deref(), CurLoop));
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t\tnew Src is "), $Deref(Src.$deref())).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t\tDst is "), $Deref(Dst.$deref())).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    Dst.$set(zeroCoefficient(Dst.$deref(), CurLoop));
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t\tnew Dst is "), $Deref(Dst.$deref())).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    return true;
  }

  
  /// propagateLine - Attempt to propagate a line
  /// constraint into a subscript pair (Src and Dst).
  /// Return true if some simplification occurs.
  /// If the simplification isn't exact (that is, if it is conservative
  /// in terms of dependence), set consistent to false.
  
  // Attempt to propagate a line
  // constraint into a subscript pair (Src and Dst).
  // Return true if some simplification occurs.
  // If the simplification isn't exact (that is, if it is conservative
  // in terms of dependence), set consistent to false.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::propagateLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 3031,
   FQN="llvm::DependenceInfo::propagateLine", NM="_ZN4llvm14DependenceInfo13propagateLineERPKNS_4SCEVES4_RNS0_10ConstraintERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo13propagateLineERPKNS_4SCEVES4_RNS0_10ConstraintERb")
  //</editor-fold>
  private boolean propagateLine(final type$ref</*const*/ SCEV /*P*/ /*&*/> Src, final type$ref</*const*/ SCEV /*P*/ /*&*/> Dst, 
               final Constraint /*&*/ CurConstraint, 
               final bool$ref/*bool &*/ Consistent) {
    /*const*/ Loop /*P*/ CurLoop = CurConstraint.getAssociatedLoop();
    /*const*/ SCEV /*P*/ A = CurConstraint.getA();
    /*const*/ SCEV /*P*/ B = CurConstraint.getB();
    /*const*/ SCEV /*P*/ C = CurConstraint.getC();
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t\tA = "), $Deref(A)).$out(/*KEEP_STR*/", B = "), $Deref(B)).$out(/*KEEP_STR*/", C = "), $Deref(C)).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t\tSrc = "), $Deref(Src.$deref())).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t\tDst = "), $Deref(Dst.$deref())).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    if (A.isZero()) {
      /*const*/ SCEVConstant /*P*/ Bconst = dyn_cast_SCEVConstant(B);
      /*const*/ SCEVConstant /*P*/ Cconst = dyn_cast_SCEVConstant(C);
      if (!(Bconst != null) || !(Cconst != null)) {
        return false;
      }
      APInt Beta = new APInt(Bconst.getAPInt());
      APInt Charlie = new APInt(Cconst.getAPInt());
      APInt CdivB = Charlie.sdiv(Beta);
      assert (Charlie.srem(Beta).$eq($int2ulong(0))) : "C should be evenly divisible by B";
      /*const*/ SCEV /*P*/ AP_K = findCoefficient(Dst.$deref(), CurLoop);
      //    Src = SE->getAddExpr(Src, SE->getMulExpr(AP_K, SE->getConstant(CdivB)));
      Src.$set(SE.getMinusSCEV(Src.$deref(), SE.getMulExpr(AP_K, SE.getConstant(CdivB))));
      Dst.$set(zeroCoefficient(Dst.$deref(), CurLoop));
      if (!findCoefficient(Src.$deref(), CurLoop).isZero()) {
        Consistent.$set(false);
      }
    } else if (B.isZero()) {
      /*const*/ SCEVConstant /*P*/ Aconst = dyn_cast_SCEVConstant(A);
      /*const*/ SCEVConstant /*P*/ Cconst = dyn_cast_SCEVConstant(C);
      if (!(Aconst != null) || !(Cconst != null)) {
        return false;
      }
      APInt Alpha = new APInt(Aconst.getAPInt());
      APInt Charlie = new APInt(Cconst.getAPInt());
      APInt CdivA = Charlie.sdiv(Alpha);
      assert (Charlie.srem(Alpha).$eq($int2ulong(0))) : "C should be evenly divisible by A";
      /*const*/ SCEV /*P*/ A_K = findCoefficient(Src.$deref(), CurLoop);
      Src.$set(SE.getAddExpr(Src.$deref(), SE.getMulExpr(A_K, SE.getConstant(CdivA))));
      Src.$set(zeroCoefficient(Src.$deref(), CurLoop));
      if (!findCoefficient(Dst.$deref(), CurLoop).isZero()) {
        Consistent.$set(false);
      }
    } else if (isKnownPredicate(CmpInst.Predicate.ICMP_EQ, A, B)) {
      /*const*/ SCEVConstant /*P*/ Aconst = dyn_cast_SCEVConstant(A);
      /*const*/ SCEVConstant /*P*/ Cconst = dyn_cast_SCEVConstant(C);
      if (!(Aconst != null) || !(Cconst != null)) {
        return false;
      }
      APInt Alpha = new APInt(Aconst.getAPInt());
      APInt Charlie = new APInt(Cconst.getAPInt());
      APInt CdivA = Charlie.sdiv(Alpha);
      assert (Charlie.srem(Alpha).$eq($int2ulong(0))) : "C should be evenly divisible by A";
      /*const*/ SCEV /*P*/ A_K = findCoefficient(Src.$deref(), CurLoop);
      Src.$set(SE.getAddExpr(Src.$deref(), SE.getMulExpr(A_K, SE.getConstant(CdivA))));
      Src.$set(zeroCoefficient(Src.$deref(), CurLoop));
      Dst.$set(addToCoefficient(Dst.$deref(), CurLoop, A_K));
      if (!findCoefficient(Dst.$deref(), CurLoop).isZero()) {
        Consistent.$set(false);
      }
    } else {
      // paper is incorrect here, or perhaps just misleading
      /*const*/ SCEV /*P*/ A_K = findCoefficient(Src.$deref(), CurLoop);
      Src.$set(SE.getMulExpr(Src.$deref(), A));
      Dst.$set(SE.getMulExpr(Dst.$deref(), A));
      Src.$set(SE.getAddExpr(Src.$deref(), SE.getMulExpr(A_K, C)));
      Src.$set(zeroCoefficient(Src.$deref(), CurLoop));
      Dst.$set(addToCoefficient(Dst.$deref(), CurLoop, SE.getMulExpr(A_K, B)));
      if (!findCoefficient(Dst.$deref(), CurLoop).isZero()) {
        Consistent.$set(false);
      }
    }
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t\tnew Src = "), $Deref(Src.$deref())).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs().$out(/*KEEP_STR*/"\t\tnew Dst = "), $Deref(Dst.$deref())).$out(/*KEEP_STR*/$LF);
      }
    } while (false);
    return true;
  }

  
  /// findCoefficient - Given a linear SCEV,
  /// return the coefficient corresponding to specified loop.
  /// If there isn't one, return the SCEV constant 0.
  /// For example, given a*i + b*j + c*k, returning the coefficient
  /// corresponding to the j loop would yield b.
  
  //===----------------------------------------------------------------------===//
  // Constraint manipulation for Delta test.
  
  // Given a linear SCEV,
  // return the coefficient (the step)
  // corresponding to the specified loop.
  // If there isn't one, return 0.
  // For example, given a*i + b*j + c*k, finding the coefficient
  // corresponding to the j loop would yield b.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::findCoefficient">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2909,
   FQN="llvm::DependenceInfo::findCoefficient", NM="_ZNK4llvm14DependenceInfo15findCoefficientEPKNS_4SCEVEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo15findCoefficientEPKNS_4SCEVEPKNS_4LoopE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ findCoefficient(/*const*/ SCEV /*P*/ Expr, 
                 /*const*/ Loop /*P*/ TargetLoop) /*const*/ {
    /*const*/ SCEVAddRecExpr /*P*/ AddRec = dyn_cast_SCEVAddRecExpr(Expr);
    if (!(AddRec != null)) {
      return SE.getZero(Expr.getType());
    }
    if (AddRec.getLoop() == TargetLoop) {
      return AddRec.getStepRecurrence($Deref(SE));
    }
    return findCoefficient(AddRec.getStart(), TargetLoop);
  }

  
  /// zeroCoefficient - Given a linear SCEV,
  /// return the SCEV given by zeroing out the coefficient
  /// corresponding to the specified loop.
  /// For example, given a*i + b*j + c*k, zeroing the coefficient
  /// corresponding to the j loop would yield a*i + c*k.
  
  // Given a linear SCEV,
  // return the SCEV given by zeroing out the coefficient
  // corresponding to the specified loop.
  // For example, given a*i + b*j + c*k, zeroing the coefficient
  // corresponding to the j loop would yield a*i + c*k.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::zeroCoefficient">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2925,
   FQN="llvm::DependenceInfo::zeroCoefficient", NM="_ZNK4llvm14DependenceInfo15zeroCoefficientEPKNS_4SCEVEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo15zeroCoefficientEPKNS_4SCEVEPKNS_4LoopE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ zeroCoefficient(/*const*/ SCEV /*P*/ Expr, 
                 /*const*/ Loop /*P*/ TargetLoop) /*const*/ {
    /*const*/ SCEVAddRecExpr /*P*/ AddRec = dyn_cast_SCEVAddRecExpr(Expr);
    if (!(AddRec != null)) {
      return Expr; // ignore
    }
    if (AddRec.getLoop() == TargetLoop) {
      return AddRec.getStart();
    }
    return SE.getAddRecExpr(zeroCoefficient(AddRec.getStart(), TargetLoop), 
        AddRec.getStepRecurrence($Deref(SE)), 
        AddRec.getLoop(), 
        AddRec.getNoWrapFlags());
  }

  
  /// addToCoefficient - Given a linear SCEV Expr,
  /// return the SCEV given by adding some Value to the
  /// coefficient corresponding to the specified TargetLoop.
  /// For example, given a*i + b*j + c*k, adding 1 to the coefficient
  /// corresponding to the j loop would yield a*i + (b+1)*j + c*k.
  
  // Given a linear SCEV Expr,
  // return the SCEV given by adding some Value to the
  // coefficient corresponding to the specified TargetLoop.
  // For example, given a*i + b*j + c*k, adding 1 to the coefficient
  // corresponding to the j loop would yield a*i + (b+1)*j + c*k.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::addToCoefficient">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2944,
   FQN="llvm::DependenceInfo::addToCoefficient", NM="_ZNK4llvm14DependenceInfo16addToCoefficientEPKNS_4SCEVEPKNS_4LoopES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo16addToCoefficientEPKNS_4SCEVEPKNS_4LoopES3_")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ addToCoefficient(/*const*/ SCEV /*P*/ Expr, 
                  /*const*/ Loop /*P*/ TargetLoop, 
                  /*const*/ SCEV /*P*/ Value) /*const*/ {
    /*const*/ SCEVAddRecExpr /*P*/ AddRec = dyn_cast_SCEVAddRecExpr(Expr);
    if (!(AddRec != null)) { // create a new addRec
      return SE.getAddRecExpr(Expr, 
          Value, 
          TargetLoop, 
          SCEV.NoWrapFlags.FlagAnyWrap); // Worst case, with no info.
    }
    if (AddRec.getLoop() == TargetLoop) {
      /*const*/ SCEV /*P*/ Sum = SE.getAddExpr(AddRec.getStepRecurrence($Deref(SE)), Value);
      if (Sum.isZero()) {
        return AddRec.getStart();
      }
      return SE.getAddRecExpr(AddRec.getStart(), 
          Sum, 
          AddRec.getLoop(), 
          AddRec.getNoWrapFlags());
    }
    if (SE.isLoopInvariant(AddRec, TargetLoop)) {
      return SE.getAddRecExpr(AddRec, Value, TargetLoop, SCEV.NoWrapFlags.FlagAnyWrap);
    }
    return SE.getAddRecExpr(addToCoefficient(AddRec.getStart(), TargetLoop, Value), 
        AddRec.getStepRecurrence($Deref(SE)), AddRec.getLoop(), 
        AddRec.getNoWrapFlags());
  }

  
  /// updateDirection - Update direction vector entry
  /// based on the current constraint.
  
  // Update direction vector entry based on the current constraint.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::updateDirection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 3124,
   FQN="llvm::DependenceInfo::updateDirection", NM="_ZNK4llvm14DependenceInfo15updateDirectionERNS_10Dependence7DVEntryERKNS0_10ConstraintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo15updateDirectionERNS_10Dependence7DVEntryERKNS0_10ConstraintE")
  //</editor-fold>
  private void updateDirection(final Dependence.DVEntry /*&*/ Level, 
                 final /*const*/ Constraint /*&*/ CurConstraint) /*const*/ {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        dbgs().$out(/*KEEP_STR*/"\tUpdate direction, constraint =");
      }
    } while (false);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        CurConstraint.dump(dbgs());
      }
    } while (false);
    if (CurConstraint.isAny()) {
      ; // use defaults
    } else if (CurConstraint.isDistance()) {
      // this one is consistent, the others aren't
      Level.Scalar = false;
      Level.Distance = CurConstraint.getD();
      /*uint*/int NewDirection = Dependence.DVEntry.Unnamed_enum.NONE.getValue();
      if (!SE.isKnownNonZero(Level.Distance)) { // if may be zero
        NewDirection = Dependence.DVEntry.Unnamed_enum.EQ.getValue();
      }
      if (!SE.isKnownNonPositive(Level.Distance)) { // if may be positive
        NewDirection |= Dependence.DVEntry.Unnamed_enum.LT.getValue();
      }
      if (!SE.isKnownNonNegative(Level.Distance)) { // if may be negative
        NewDirection |= Dependence.DVEntry.Unnamed_enum.GT.getValue();
      }
      Level.Direction &= $uint2uchar_3bits(NewDirection);
    } else if (CurConstraint.isLine()) {
      Level.Scalar = false;
      Level.Distance = null;
      // direction should be accurate
    } else if (CurConstraint.isPoint()) {
      Level.Scalar = false;
      Level.Distance = null;
      /*uint*/int NewDirection = Dependence.DVEntry.Unnamed_enum.NONE.getValue();
      if (!isKnownPredicate(CmpInst.Predicate.ICMP_NE, 
          CurConstraint.getY(), 
          CurConstraint.getX())) {
        // if X may be = Y
        NewDirection |= Dependence.DVEntry.Unnamed_enum.EQ.getValue();
      }
      if (!isKnownPredicate(CmpInst.Predicate.ICMP_SLE, 
          CurConstraint.getY(), 
          CurConstraint.getX())) {
        // if Y may be > X
        NewDirection |= Dependence.DVEntry.Unnamed_enum.LT.getValue();
      }
      if (!isKnownPredicate(CmpInst.Predicate.ICMP_SGE, 
          CurConstraint.getY(), 
          CurConstraint.getX())) {
        // if Y may be < X
        NewDirection |= Dependence.DVEntry.Unnamed_enum.GT.getValue();
      }
      Level.Direction &= $uint2uchar_3bits(NewDirection);
    } else {
      throw new llvm_unreachable("constraint has unexpected kind");
    }
  }

  
  
  /// Check if we can delinearize the subscripts. If the SCEVs representing the
  /// source and destination array references are recurrences on a nested loop,
  /// this function flattens the nested recurrences into separate recurrences
  /// for each loop level.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::tryDelinearize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 3177,
   FQN="llvm::DependenceInfo::tryDelinearize", NM="_ZN4llvm14DependenceInfo14tryDelinearizeEPNS_11InstructionES2_RNS_15SmallVectorImplINS0_9SubscriptEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo14tryDelinearizeEPNS_11InstructionES2_RNS_15SmallVectorImplINS0_9SubscriptEEE")
  //</editor-fold>
  private boolean tryDelinearize(Instruction /*P*/ Src, Instruction /*P*/ Dst, 
                final SmallVectorImpl<Subscript> /*&*/ Pair) {
    Value /*P*/ SrcPtr = getPointerOperand(Src);
    Value /*P*/ DstPtr = getPointerOperand(Dst);
    
    Loop /*P*/ SrcLoop = LI.getLoopFor(Src.getParent());
    Loop /*P*/ DstLoop = LI.getLoopFor(Dst.getParent());
    
    // Below code mimics the code in Delinearization.cpp
    /*const*/ SCEV /*P*/ SrcAccessFn = SE.getSCEVAtScope(SrcPtr, SrcLoop);
    /*const*/ SCEV /*P*/ DstAccessFn = SE.getSCEVAtScope(DstPtr, DstLoop);
    
    /*const*/ SCEVUnknown /*P*/ SrcBase = dyn_cast_SCEVUnknown(SE.getPointerBase(SrcAccessFn));
    /*const*/ SCEVUnknown /*P*/ DstBase = dyn_cast_SCEVUnknown(SE.getPointerBase(DstAccessFn));
    if (!(SrcBase != null) || !(DstBase != null) || SrcBase != DstBase) {
      return false;
    }
    
    /*const*/ SCEV /*P*/ ElementSize = SE.getElementSize(Src);
    if (ElementSize != SE.getElementSize(Dst)) {
      return false;
    }
    
    /*const*/ SCEV /*P*/ SrcSCEV = SE.getMinusSCEV(SrcAccessFn, SrcBase);
    /*const*/ SCEV /*P*/ DstSCEV = SE.getMinusSCEV(DstAccessFn, DstBase);
    
    /*const*/ SCEVAddRecExpr /*P*/ SrcAR = dyn_cast_SCEVAddRecExpr(SrcSCEV);
    /*const*/ SCEVAddRecExpr /*P*/ DstAR = dyn_cast_SCEVAddRecExpr(DstSCEV);
    if (!(SrcAR != null) || !(DstAR != null) || !SrcAR.isAffine() || !DstAR.isAffine()) {
      return false;
    }
    
    // First step: collect parametric terms in both array references.
    SmallVector</*const*/ SCEV /*P*/ > Terms/*J*/= new SmallVector</*const*/ SCEV /*P*/ >(4, (/*const*/ SCEV /*P*/ )null);
    SE.collectParametricTerms(SrcAR, Terms);
    SE.collectParametricTerms(DstAR, Terms);
    
    // Second step: find subscript sizes.
    SmallVector</*const*/ SCEV /*P*/ > Sizes/*J*/= new SmallVector</*const*/ SCEV /*P*/ >(4, (/*const*/ SCEV /*P*/ )null);
    SE.findArrayDimensions(Terms, Sizes, ElementSize);
    
    // Third step: compute the access functions for each subscript.
    SmallVector</*const*/ SCEV /*P*/ > SrcSubscripts/*J*/= new SmallVector</*const*/ SCEV /*P*/ >(4, (/*const*/ SCEV /*P*/ )null);
    SmallVector</*const*/ SCEV /*P*/ > DstSubscripts/*J*/= new SmallVector</*const*/ SCEV /*P*/ >(4, (/*const*/ SCEV /*P*/ )null);
    SE.computeAccessFunctions(SrcAR, SrcSubscripts, Sizes);
    SE.computeAccessFunctions(DstAR, DstSubscripts, Sizes);
    
    // Fail when there is only a subscript: that's a linearized access function.
    if ($less_uint(SrcSubscripts.size(), 2) || $less_uint(DstSubscripts.size(), 2)
       || SrcSubscripts.size() != DstSubscripts.size()) {
      return false;
    }
    
    int size = SrcSubscripts.size();
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"da")) {
        {
          dbgs().$out(/*KEEP_STR*/"\nSrcSubscripts: ");
          for (int i = 0; i < size; i++)  {
            ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs(), $Deref(SrcSubscripts.$at(i)));
          }
          dbgs().$out(/*KEEP_STR*/"\nDstSubscripts: ");
          for (int i = 0; i < size; i++)  {
            ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(dbgs(), $Deref(DstSubscripts.$at(i)));
          }
        }
        ;
      }
    } while (false);
    
    // The delinearization transforms a single-subscript MIV dependence test into
    // a multi-subscript SIV dependence test that is easier to compute. So we
    // resize Pair to contain as many pairs of subscripts as the delinearization
    // has found, and then initialize the pairs following the delinearization.
    Pair.resize(size);
    for (int i = 0; i < size; ++i) {
      Pair.$at(i).Src = SrcSubscripts.$at(i);
      Pair.$at(i).Dst = DstSubscripts.$at(i);
      unifySubscriptType(new ArrayRef<Subscript /*P*/ >($AddrOf(Pair.$at(i)), true));
      // FIXME: we should record the bounds SrcSizes[i] and DstSizes[i] that the
      // delinearization has found, and add these constraints to the dependence
      // check to avoid memory accesses overflow from one dimension into another.
      // This is related to the problem of determining the existence of data
      // dependences in array accesses using a different number of subscripts: in
      // C one can access an array A[100][100]; as A[0][9999], *A[9999], etc.
    }
    
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::DependenceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 282,
   FQN="llvm::DependenceInfo::DependenceInfo", NM="_ZN4llvm14DependenceInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfoC1EOS0_")
  //</editor-fold>
  public /*inline*/ DependenceInfo(JD$Move _dparam, final DependenceInfo /*&&*/$Prm0) {
    // : AA(static_cast<DependenceInfo &&>().AA), SE(static_cast<DependenceInfo &&>().SE), LI(static_cast<DependenceInfo &&>().LI), F(static_cast<DependenceInfo &&>().F), CommonLevels(static_cast<DependenceInfo &&>().CommonLevels), SrcLevels(static_cast<DependenceInfo &&>().SrcLevels), MaxLevels(static_cast<DependenceInfo &&>().MaxLevels) 
    //START JInit
    this.AA = $Prm0.AA;
    this.SE = $Prm0.SE;
    this.LI = $Prm0.LI;
    this.F = $Prm0.F;
    this.CommonLevels = $Prm0.CommonLevels;
    this.SrcLevels = $Prm0.SrcLevels;
    this.MaxLevels = $Prm0.MaxLevels;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "AA=" + AA // NOI18N
              + ", SE=" + SE // NOI18N
              + ", LI=" + LI // NOI18N
              + ", F=" + F // NOI18N
              + ", CommonLevels=" + CommonLevels // NOI18N
              + ", SrcLevels=" + SrcLevels // NOI18N
              + ", MaxLevels=" + MaxLevels; // NOI18N
  }
}
