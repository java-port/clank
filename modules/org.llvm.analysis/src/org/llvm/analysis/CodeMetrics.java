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

import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.SmallPtrSetImpl;
import org.llvm.adt.aliases.DenseMapInfo$LikePtr;
import org.llvm.adt.aliases.DenseMapTypeUInt;
import org.llvm.adt.aliases.SmallVector;
import static org.llvm.analysis.impl.CodeMetricsStatics.*;
import org.llvm.ir.*;
import org.llvm.analysis.target.*;
import static org.llvm.ir.java.IrRTTI.*;


/// \brief Utility to calculate the size and a few similar metrics for a set
/// of basic blocks.
//<editor-fold defaultstate="collapsed" desc="llvm::CodeMetrics">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CodeMetrics.h", line = 42,
 FQN="llvm::CodeMetrics", NM="_ZN4llvm11CodeMetricsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CodeMetrics.cpp -nm=_ZN4llvm11CodeMetricsE")
//</editor-fold>
public class/*struct*/ CodeMetrics implements Destructors.ClassWithDestructor {
  /// \brief True if this function contains a call to setjmp or other functions
  /// with attribute "returns twice" without having the attribute itself.
  public boolean exposesReturnsTwice/* = false*/;
  
  /// \brief True if this function calls itself.
  public boolean isRecursive/* = false*/;
  
  /// \brief True if this function cannot be duplicated.
  ///
  /// True if this function contains one or more indirect branches, or it contains
  /// one or more 'noduplicate' instructions.
  public boolean notDuplicatable/* = false*/;
  
  /// \brief True if this function contains a call to a convergent function.
  public boolean convergent/* = false*/;
  
  /// \brief True if this function calls alloca (in the C sense).
  public boolean usesDynamicAlloca/* = false*/;
  
  /// \brief Number of instructions in the analyzed blocks.
  public /*uint*/int NumInsts/* = false*/;
  
  /// \brief Number of analyzed blocks.
  public /*uint*/int NumBlocks/* = false*/;
  
  /// \brief Keeps track of basic block code size estimates.
  public DenseMapTypeUInt</*const*/ BasicBlock /*P*/ > NumBBInsts;
  
  /// \brief Keep track of the number of calls to 'big' functions.
  public /*uint*/int NumCalls/* = false*/;
  
  /// \brief The number of calls to internal functions with a single caller.
  ///
  /// These are likely targets for future inlining, likely exposed by
  /// interleaved devirtualization.
  public /*uint*/int NumInlineCandidates/* = 0*/;
  
  /// \brief How many instructions produce vector values.
  ///
  /// The inliner is more aggressive with inlining vector kernels.
  public /*uint*/int NumVectorInsts/* = 0*/;
  
  /// \brief How many 'ret' instructions the blocks contain.
  public /*uint*/int NumRets/* = 0*/;
  
  /// \brief Add information about a block to the current state.
  
  /// Fill in the current structure with information gleaned from the specified
  /// block.
  //<editor-fold defaultstate="collapsed" desc="llvm::CodeMetrics::analyzeBasicBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CodeMetrics.cpp", line = 105,
   FQN="llvm::CodeMetrics::analyzeBasicBlock", NM="_ZN4llvm11CodeMetrics17analyzeBasicBlockEPKNS_10BasicBlockERKNS_19TargetTransformInfoERNS_15SmallPtrSetImplIPKNS_5ValueEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CodeMetrics.cpp -nm=_ZN4llvm11CodeMetrics17analyzeBasicBlockEPKNS_10BasicBlockERKNS_19TargetTransformInfoERNS_15SmallPtrSetImplIPKNS_5ValueEEE")
  //</editor-fold>
  public void analyzeBasicBlock(/*const*/ BasicBlock /*P*/ BB, 
                   final /*const*/ TargetTransformInfo /*&*/ TTI, 
                   final SmallPtrSetImpl</*const*/ Value /*P*/ > /*&*/ EphValues) {
    ++NumBlocks;
    /*uint*/int NumInstsBeforeThisBB = NumInsts;
    for (final /*const*/ Instruction /*&*/ I : $Deref(BB)) {
      // Skip ephemeral values.
      if ((EphValues.count($AddrOf(I)) != 0)) {
        continue;
      }
      
      // Special handling for calls.
      if (isa_CallInst(I) || isa_InvokeInst(I)) {
        ImmutableCallSite CS/*J*/= new ImmutableCallSite($AddrOf(I));
        {
          
          /*const*/ Function /*P*/ F = CS.getCalledFunction();
          if ((F != null)) {
            // If a function is both internal and has a single use, then it is
            // extremely likely to get inlined in the future (it was probably
            // exposed by an interleaved devirtualization pass).
            if (!CS.isNoInline() && F.hasInternalLinkage() && F.hasOneUse()) {
              ++NumInlineCandidates;
            }
            
            // If this call is to function itself, then the function is recursive.
            // Inlining it into other functions is a bad idea, because this is
            // basically just a form of loop peeling, and our metrics aren't useful
            // for that case.
            if (F == BB.getParent$Const()) {
              isRecursive = true;
            }
            if (TTI.isLoweredToCall(F)) {
              ++NumCalls;
            }
          } else {
            // We don't want inline asm to count as a call - that would prevent loop
            // unrolling. The argument setup cost is still real, though.
            if (!isa_InlineAsm(CS.getCalledValue())) {
              ++NumCalls;
            }
          }
        }
      }
      {
        
        /*const*/ AllocaInst /*P*/ AI = dyn_cast_AllocaInst($AddrOf(I));
        if ((AI != null)) {
          if (!AI.isStaticAlloca()) {
            this.usesDynamicAlloca = true;
          }
        }
      }
      if (isa_ExtractElementInst(I) || I.getType().isVectorTy()) {
        ++NumVectorInsts;
      }
      if (I.getType().isTokenTy() && I.isUsedOutsideOfBlock(BB)) {
        notDuplicatable = true;
      }
      {
        
        /*const*/ CallInst /*P*/ CI = dyn_cast_CallInst($AddrOf(I));
        if ((CI != null)) {
          if (CI.cannotDuplicate()) {
            notDuplicatable = true;
          }
          if (CI.isConvergent()) {
            convergent = true;
          }
        }
      }
      {
        
        /*const*/ InvokeInst /*P*/ InvI = dyn_cast_InvokeInst($AddrOf(I));
        if ((InvI != null)) {
          if (InvI.cannotDuplicate()) {
            notDuplicatable = true;
          }
        }
      }
      
      NumInsts += TTI.getUserCost($AddrOf(I));
    }
    if (isa_ReturnInst(BB.getTerminator$Const())) {
      ++NumRets;
    }
    
    // We never want to inline functions that contain an indirectbr.  This is
    // incorrect because all the blockaddress's (in static global initializers
    // for example) would be referring to the original function, and this indirect
    // jump would jump from the inlined copy of the function into the original
    // function which is extremely undefined behavior.
    // FIXME: This logic isn't really right; we can safely inline functions
    // with indirectbr's as long as no other function or global references the
    // blockaddress of a block within the current function.  And as a QOI issue,
    // if someone is using a blockaddress without an indirectbr, and that
    // reference somehow ends up in another function or global, we probably
    // don't want to inline this function.
    notDuplicatable |= isa_IndirectBrInst(BB.getTerminator$Const());
    
    // Remember NumInsts for this BB.
    NumBBInsts.$set(BB, NumInsts - NumInstsBeforeThisBB);
  }

  
  /// \brief Collect a loop's ephemeral values (those used only by an assume
  /// or similar intrinsics in the loop).
  
  // Find all ephemeral values.
  //<editor-fold defaultstate="collapsed" desc="llvm::CodeMetrics::collectEphemeralValues">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CodeMetrics.cpp", line = 64,
   FQN="llvm::CodeMetrics::collectEphemeralValues", NM="_ZN4llvm11CodeMetrics22collectEphemeralValuesEPKNS_4LoopEPNS_15AssumptionCacheERNS_15SmallPtrSetImplIPKNS_5ValueEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CodeMetrics.cpp -nm=_ZN4llvm11CodeMetrics22collectEphemeralValuesEPKNS_4LoopEPNS_15AssumptionCacheERNS_15SmallPtrSetImplIPKNS_5ValueEEE")
  //</editor-fold>
  public static void collectEphemeralValues_Loop$C$P_AssumptionCache$P_SmallPtrSetImpl$Value$C$P(/*const*/ Loop /*P*/ L, AssumptionCache /*P*/ AC, 
                                                                             final SmallPtrSetImpl</*const*/ Value /*P*/ > /*&*/ EphValues) {
    SmallVector</*const*/ Value /*P*/ > WorkSet/*J*/= new SmallVector</*const*/ Value /*P*/ >(16, (/*const*/ Value /*P*/ )null);
    
    for (final WeakVH /*&*/ AssumeVH : AC.assumptions()) {
      if (!((AssumeVH.$Value$P()) != null)) {
        continue;
      }
      Instruction /*P*/ I = cast_Instruction(AssumeVH.$Value$P());
      
      // Filter out call sites outside of the loop so we don't to a function's
      // worth of work for each of its loops (and, in the common case, ephemeral
      // values in the loop are likely due to @llvm.assume calls in the loop).
      if (!L.contains_T$C$P(I.getParent())) {
        continue;
      }
      
      WorkSet.push_back(I);
    }
    
    completeEphemeralValues(WorkSet, EphValues);
  }

  
  /// \brief Collect a functions's ephemeral values (those used only by an
  /// assume or similar intrinsics in the function).
  //<editor-fold defaultstate="collapsed" desc="llvm::CodeMetrics::collectEphemeralValues">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CodeMetrics.cpp", line = 86,
   FQN="llvm::CodeMetrics::collectEphemeralValues", NM="_ZN4llvm11CodeMetrics22collectEphemeralValuesEPKNS_8FunctionEPNS_15AssumptionCacheERNS_15SmallPtrSetImplIPKNS_5ValueEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CodeMetrics.cpp -nm=_ZN4llvm11CodeMetrics22collectEphemeralValuesEPKNS_8FunctionEPNS_15AssumptionCacheERNS_15SmallPtrSetImplIPKNS_5ValueEEE")
  //</editor-fold>
  public static void collectEphemeralValues_Function$C$P_AssumptionCache$P_SmallPtrSetImpl$Value$C$P(/*const*/ Function /*P*/ F, AssumptionCache /*P*/ AC, 
                                                                                 final SmallPtrSetImpl</*const*/ Value /*P*/ > /*&*/ EphValues) {
    SmallVector</*const*/ Value /*P*/ > WorkSet/*J*/= new SmallVector</*const*/ Value /*P*/ >(16, (/*const*/ Value /*P*/ )null);
    
    for (final WeakVH /*&*/ AssumeVH : AC.assumptions()) {
      if (!((AssumeVH.$Value$P()) != null)) {
        continue;
      }
      Instruction /*P*/ I = cast_Instruction(AssumeVH.$Value$P());
      assert (I.getParent().getParent() == F) : "Found assumption for the wrong function!";
      WorkSet.push_back(I);
    }
    
    completeEphemeralValues(WorkSet, EphValues);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CodeMetrics::~CodeMetrics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CodeMetrics.h", line = 42,
   FQN="llvm::CodeMetrics::~CodeMetrics", NM="_ZN4llvm11CodeMetricsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRotation.cpp -nm=_ZN4llvm11CodeMetricsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    NumBBInsts.$destroy();
    //END JDestroy
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::CodeMetrics::CodeMetrics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CodeMetrics.h", line = 42,
   FQN="llvm::CodeMetrics::CodeMetrics", NM="_ZN4llvm11CodeMetricsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRotation.cpp -nm=_ZN4llvm11CodeMetricsC1Ev")
  //</editor-fold>
  public /*inline*/ CodeMetrics() {
    // : exposesReturnsTwice(false), isRecursive(false), notDuplicatable(false), convergent(false), usesDynamicAlloca(false), NumInsts(false), NumBlocks(false), NumBBInsts(), NumCalls(false), NumInlineCandidates(0), NumVectorInsts(0), NumRets(0) 
    //START JInit
    /*InClass*/this.exposesReturnsTwice = false;
    /*InClass*/this.isRecursive = false;
    /*InClass*/this.notDuplicatable = false;
    /*InClass*/this.convergent = false;
    /*InClass*/this.usesDynamicAlloca = false;
    /*InClass*/this.NumInsts = /*false*/0;
    /*InClass*/this.NumBlocks = /*false*/0;
    this.NumBBInsts = new DenseMapTypeUInt</*const*/ BasicBlock /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    /*InClass*/this.NumCalls = /*false*/0;
    /*InClass*/this.NumInlineCandidates = 0;
    /*InClass*/this.NumVectorInsts = 0;
    /*InClass*/this.NumRets = 0;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "exposesReturnsTwice=" + exposesReturnsTwice // NOI18N
              + ", isRecursive=" + isRecursive // NOI18N
              + ", notDuplicatable=" + notDuplicatable // NOI18N
              + ", convergent=" + convergent // NOI18N
              + ", usesDynamicAlloca=" + usesDynamicAlloca // NOI18N
              + ", NumInsts=" + NumInsts // NOI18N
              + ", NumBlocks=" + NumBlocks // NOI18N
              + ", NumBBInsts=" + NumBBInsts // NOI18N
              + ", NumCalls=" + NumCalls // NOI18N
              + ", NumInlineCandidates=" + NumInlineCandidates // NOI18N
              + ", NumVectorInsts=" + NumVectorInsts // NOI18N
              + ", NumRets=" + NumRets; // NOI18N
  }
}
